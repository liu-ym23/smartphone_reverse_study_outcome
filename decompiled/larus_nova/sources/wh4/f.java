package wh4;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.reparo.secondary.h;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f559657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Queue<c> f559658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Queue<Message> f559659c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile Handler f559660d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f559661e;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f559662a;

        public final void a() {
        L3:
            if (((ConcurrentLinkedQueue) this.f559662a.f559659c).isEmpty() == true) goto L10;
            if (this.f559662a.f559660d == null) goto L3;
            this.f559662a.f559660d.sendMessageAtFrontOfQueue((Message) ((ConcurrentLinkedQueue) this.f559662a.f559659c).poll());     // Catch: Throwable -> L8
        L10:
            if (((ConcurrentLinkedQueue) this.f559662a.f559658b).isEmpty() == true) goto L16;
            c r100 = (c) ((ConcurrentLinkedQueue) this.f559662a.f559658b).poll();
            if (this.f559662a.f559660d == null) goto L10;
            this.f559662a.f559660d.sendMessageAtTime(r100.f559666a, r100.f559667b);     // Catch: Throwable -> L15
            goto L10
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

        public a(f r100) {
            this.f559662a = r100;
        }
    }

    public class b extends PthreadHandlerThreadV2 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile int f559663c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile boolean f559664d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ f f559665e;

        /* JADX INFO: Infinite loop detected, blocks: 19, insns: 0 */
        @Override // android.os.HandlerThread
        public final void onLooperPrepared() {
            super.onLooperPrepared();
            Object r100 = this.f559665e.f559661e;
            monitor-enter(r100);
            this.f559665e.f559660d = new Handler();     // Catch: Throwable -> L18
            monitor-exit(r100);     // Catch: Throwable -> L18
            this.f559665e.f559660d.post(new a(this.f559665e));
        L24:
            Looper.loop();     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            if (this.f559663c >= 5) goto L14;
            ch4.c.c(th);     // Catch: Throwable -> L21
        L16:
            this.f559663c++;     // Catch: Throwable -> L21
            goto L24
        L14:
            if (this.f559664d == true) goto L16;
            this.f559664d = true;     // Catch: Throwable -> L21
            ch4.c.b("NPTH_ERR_MAX", new RuntimeException());     // Catch: Throwable -> L21
        L18:
            th = move-exception;
            throw th;
        }

        public b(f r100) {
            this.f559665e = r100;
            super("default_npth_thread");
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Message f559666a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f559667b;

        public c(Message r100, long r101) {
            this.f559666a = r100;
            this.f559667b = r101;
        }
    }

    public f() {
        this.f559658b = new ConcurrentLinkedQueue();
        this.f559659c = new ConcurrentLinkedQueue();
        this.f559661e = new Object();
        this.f559657a = new b(this);
    }

    public final void a(h.a r100) {
        Message r101 = Message.obtain(this.f559660d, r100);
        long r102 = SystemClock.uptimeMillis() + 10000;
        if (this.f559660d != null) goto L19;
        Object r103 = this.f559661e;
        monitor-enter(r103);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.f559660d != null) goto L11;
        Queue<c> r104 = this.f559658b;     // Catch: Throwable -> L13
        ConcurrentLinkedQueue r105 = (ConcurrentLinkedQueue) r104;     // Catch: Throwable -> L13
        r105.add(new c(r101, r102));     // Catch: Throwable -> L13
        monitor-exit(r103);     // Catch: Throwable -> L13
        return;
    L11:
        monitor-exit(r103);     // Catch: Throwable -> L13
    L19:
        this.f559660d.sendMessageAtTime(r101, r102);     // Catch: Throwable -> L18
        return;
    }
}
