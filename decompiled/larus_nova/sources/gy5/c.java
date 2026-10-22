package gy5;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f483332f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f483333g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f483334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Queue<e> f483335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Queue<Message> f483336c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile Handler f483337d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f483338e;

    public static class a {
        public a() {
        }

        public final boolean a(Object r100, gy5.a.RunnableC6081a r101) {
            e r102 = (e) r100;
            if (r101 != null) goto L10;
            if (r102 == null) goto L15;
            Message r103 = r102.f483341a;
            if (r103 == null) goto L15;
            if (r103.getCallback() == null) goto L15;
        L16:
            return false;
        L15:
            return true;
        L10:
            if (r102 == null) goto L16;
            Message r104 = r102.f483341a;
            if (r104 == null) goto L16;
            if (r101.equals(r104.getCallback()) == false) goto L16;
            goto L15
        }
    }

    public static class b {
        public b() {
        }

        public final boolean a(Object r100, gy5.a.RunnableC6081a r101) {
            Message r102 = (Message) r100;
            if (r101 != null) goto L8;
            if (r102 != null) goto L6;
        L11:
            return true;
        L6:
            if (r102.getCallback() == null) goto L11;
        L12:
            return false;
        L8:
            if (r102 == null) goto L12;
            if (r101.equals(r102.getCallback()) == false) goto L12;
            goto L11
        }
    }

    /* JADX INFO: renamed from: gy5.c$c, reason: collision with other inner class name */
    public class RunnableC6082c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f483339a;

        public final void a() {
        L3:
            if (((ConcurrentLinkedQueue) this.f483339a.f483336c).isEmpty() == true) goto L8;
            if (this.f483339a.f483337d == null) goto L3;
            this.f483339a.f483337d.sendMessageAtFrontOfQueue((Message) ((ConcurrentLinkedQueue) this.f483339a.f483336c).poll());
        L8:
            if (((ConcurrentLinkedQueue) this.f483339a.f483335b).isEmpty() == true) goto L12;
            e r100 = (e) ((ConcurrentLinkedQueue) this.f483339a.f483335b).poll();
            if (this.f483339a.f483337d == null) goto L8;
            this.f483339a.f483337d.sendMessageAtTime(r100.f483341a, r100.f483342b);
            goto L8
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC6082c(c r100) {
            this.f483339a = r100;
        }
    }

    public class d extends PthreadHandlerThreadV2 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c f483340c;

        /* JADX INFO: Infinite loop detected, blocks: 7, insns: 0 */
        @Override // android.os.HandlerThread
        public final void onLooperPrepared() {
            super.onLooperPrepared();
            Object r100 = this.f483340c.f483338e;
            monitor-enter(r100);
            c r101 = this.f483340c;     // Catch: Throwable -> L9
            r101.f483337d = new Handler();     // Catch: Throwable -> L9
            monitor-exit(r100);     // Catch: Throwable -> L9
            this.f483340c.f483337d.post(new RunnableC6082c(this.f483340c));
        L13:
            Looper.loop();     // Catch: Throwable -> L12
        L9:
            th = move-exception;
            throw th;
        }

        public d(c r100) {
            this.f483340c = r100;
            super("AsyncEventManager-Thread");
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Message f483341a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f483342b;

        public e(Message r100, long r101) {
            this.f483341a = r100;
            this.f483342b = r101;
        }
    }

    static {
        f483332f = new a();
        f483333g = new b();
    }

    public c() {
        this.f483335b = new ConcurrentLinkedQueue();
        this.f483336c = new ConcurrentLinkedQueue();
        this.f483338e = new Object();
        this.f483334a = new d(this);
    }

    public final void a(gy5.a.RunnableC6081a r100) {
        if (((ConcurrentLinkedQueue) this.f483335b).isEmpty() == true) goto L5;
    L6:
        Queue<e> r101 = this.f483335b;
        a r102 = f483332f;
        Iterator r103 = ((ConcurrentLinkedQueue) r101).iterator();
    L8:
        if (r103.hasNext() == false) goto L12;
        if (r102.a(r103.next(), r100) == false) goto L8;
        r103.remove();
        goto L8
    L12:
        Queue<Message> r104 = this.f483336c;
        b r105 = f483333g;
        Iterator r106 = ((ConcurrentLinkedQueue) r104).iterator();
    L14:
        if (r106.hasNext() == false) goto L19;
        if (r105.a(r106.next(), r100) == false) goto L14;
        r106.remove();
    L19:
        if (this.f483337d == null) goto L32;
        this.f483337d.removeCallbacks(r100);
        return;
    L32:
        return;
    L5:
        if (((ConcurrentLinkedQueue) this.f483336c).isEmpty() == true) goto L19;
        goto L6
    }

    public final boolean b(Message r100, long r101) {
        if (r101 >= 0) goto L5;
        r101 = 0;
    L5:
        long r102 = SystemClock.uptimeMillis() + r101;
        if (this.f483337d != null) goto L20;
        Object r103 = this.f483338e;
        monitor-enter(r103);
    L16:
        th = move-exception;
        throw th;
    L10:
        if (this.f483337d != null) goto L14;
        ((ConcurrentLinkedQueue) this.f483335b).add(new e(r100, r102));     // Catch: Throwable -> L16
        monitor-exit(r103);     // Catch: Throwable -> L16
        return true;
    L14:
        monitor-exit(r103);     // Catch: Throwable -> L16
    L20:
        return this.f483337d.sendMessageAtTime(r100, r102);
    }
}
