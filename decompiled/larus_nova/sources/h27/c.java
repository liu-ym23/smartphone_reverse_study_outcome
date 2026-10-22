package h27;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.common.utility.Logger;
import com.bytedance.mira.log.MiraLogger;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile c f483621d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f483622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<i27.b> f483623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, i27.a> f483624c;

    /* JADX INFO: loaded from: classes21.dex */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i27.a f483625a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f483626b;

        @Override // java.lang.Runnable
        public final void run() {
            c r100 = this.f483626b;     // Catch: Throwable -> L7
            i27.a r101 = this.f483625a;     // Catch: Throwable -> L7
            Iterator r102 = ((CopyOnWriteArrayList) r100.f483623b).iterator();     // Catch: Throwable -> L7
        L4:
            if (r102.hasNext() == false) goto L16;
            ((i27.b) r102.next()).a(r101);     // Catch: Throwable -> L7
            goto L4
        L16:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }

        public a(c r100, i27.a r101) {
            this.f483626b = r100;
            this.f483625a = r101;
        }
    }

    public static c a() {
        if (f483621d != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f483621d != null) goto L9;
        f483621d = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f483621d;
    }

    public c() {
        this.f483622a = new Handler(Looper.getMainLooper());
        this.f483623b = new CopyOnWriteArrayList();
        this.f483624c = new HashMap();
    }

    public final void b(i27.a r100) {
        if (r100.f488047a != null) goto L6;
        Logger.e(MiraLogger.TAG_DOWNLOAD, "modifyState ERROR: newState is null or newState.packageName is null.");
        return;
    L6:
        Map<String, i27.a> r101 = this.f483624c;
        monitor-enter(r101);
        Map<String, i27.a> r102 = this.f483624c;     // Catch: Throwable -> L13
        HashMap r103 = (HashMap) r102;     // Catch: Throwable -> L13
        i27.a r104 = (i27.a) r103.get(r100.f488047a);     // Catch: Throwable -> L13
        if (r104 == null) goto L11;
        r104.f488049c = r100.f488049c;     // Catch: Throwable -> L13
        r104.f488048b = r100.f488048b;     // Catch: Throwable -> L13
        r104.f488053g = r100.f488053g;     // Catch: Throwable -> L13
        r104.f488055i = r100.f488055i;     // Catch: Throwable -> L13
        r104.f488054h = r100.f488054h;     // Catch: Throwable -> L13
        r104.f488051e = r100.f488051e;     // Catch: Throwable -> L13
        r104.f488050d = r100.f488050d;     // Catch: Throwable -> L13
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final void c(i27.a r100) {
        if (r100.f488047a != null) goto L6;
        Logger.e(MiraLogger.TAG_DOWNLOAD, "notifyStateChange ERROR: newState is null or newState.packageName is null.");
        return;
    L6:
        Map<String, i27.a> r101 = this.f483624c;
        monitor-enter(r101);
        Map<String, i27.a> r102 = this.f483624c;     // Catch: Throwable -> L13
        HashMap r103 = (HashMap) r102;     // Catch: Throwable -> L13
        if (((i27.a) r103.get(r100.f488047a)) == null) goto L11;
        d(r100);     // Catch: Throwable -> L13
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final void d(i27.a r100) {
        if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(this.f483622a.getLooper())) goto L8;
        Iterator r101 = ((CopyOnWriteArrayList) this.f483623b).iterator();
    L6:
        if (r101.hasNext() == false) goto L11;
        ((i27.b) r101.next()).a(r100);
        goto L6
    L11:
        return;
    L8:
        this.f483622a.post(new a(this, r100));
    }
}
