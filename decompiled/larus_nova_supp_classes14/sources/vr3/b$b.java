package vr3;

import android.os.SystemClock;
import bs3.l;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import ps3.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class b$b implements Runnable {
    public final /* synthetic */ b a;

    public final void a() {
        Object r1 = b.C;
        monitor-enter(r1);
        boolean r3 = false;
        if (com.bytedance.apm.d.j() == false) goto L7;
        b.a(new String[]{"onTimer record, current is background? : " + ActivityLifeObserver.getInstance().isForeground()});     // Catch: Throwable -> L26
    L7:
        boolean r0 = this.a.l(true);     // Catch: Throwable -> L26
        Iterator r2 = ((ConcurrentHashMap) this.a.g).values().iterator();     // Catch: Throwable -> L26
    L9:
        if (r2.hasNext() == false) goto L11;
        ((l) r2.next()).b(r0);     // Catch: Throwable -> L26
        goto L9
    L11:
        long r5 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L26
        if (this.a.j == true) goto L14;
    L28:
        monitor-exit(r1);     // Catch: Throwable -> L30
        return;
    L14:
        if ((r5 - this.a.m) <= (this.a.l * 60000)) goto L17;
        r3 = true;
    L17:
        if (com.bytedance.apm.d.k() == false) goto L28;
        if (r3 == false) goto L28;
        as3.b.a.a.i();     // Catch: Throwable -> L22
    L24:
        this.a.m = r5;     // Catch: Throwable -> L26
    L22:
        th = move-exception;
        EnsureManager.ensureNotReachHere(th, "handleReportAndHandleCache");     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        EnsureManager.ensureNotReachHere(th, "onStart");     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;
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

    public b$b(b r1) {
        this.a = r1;
    }
}
