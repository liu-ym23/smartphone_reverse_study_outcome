package es3;

import android.os.Build;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j implements Runnable {
    public final /* synthetic */ h a;

    public class a implements Runnable {
        public final /* synthetic */ j a;

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a.e();     // Catch: Throwable -> L4
            return;
        }

        public a(j r1) {
            this.a = r1;
        }
    }

    public final void a() {
        h r2 = this.a;     // Catch: Exception -> L33
        r2.p = new a(this);     // Catch: Exception -> L33
        r2.i = h.a(r2, r2.m, "mLock");     // Catch: Exception -> L33
        h r3 = this.a;     // Catch: Exception -> L33
        if (r3.i != null) goto L6;
        r3.i = h.b(r3, r3.m, "mLock");     // Catch: Exception -> L33
    L6:
        h r1 = this.a;     // Catch: Exception -> L33
        r1.j = (Object[]) h.a(r1, r1.m, "mCallbackQueues");     // Catch: Exception -> L33
        h r4 = this.a;     // Catch: Exception -> L33
        if (r4.j != null) goto L9;
        r4.j = (Object[]) h.b(r4, r4.m, "mCallbackQueues");     // Catch: Exception -> L33
    L9:
        int r0 = Build.VERSION.SDK_INT;     // Catch: Exception -> L33
        if (r0 != 28) goto L13;
        h r5 = this.a;     // Catch: Exception -> L33
        r5.k = (long[]) h.b(r5, h.b(r5, r5.m, "mFrameInfo"), "mFrameInfo");     // Catch: Exception -> L33
    L18:
        if (this.a.k != null) goto L22;
        if (r0 <= 22) goto L22;
        EnsureManager.ensureNotReachHere("FrameInfoIsNull");     // Catch: Exception -> L33
    L22:
        if (this.a.i != null) goto L25;
        EnsureManager.ensureNotReachHere("CallbackQueueLockIsNull");     // Catch: Exception -> L33
    L25:
        if (this.a.j != null) goto L27;
        EnsureManager.ensureNotReachHere("callbackQueuesIsNull");     // Catch: Exception -> L33
    L27:
        h r6 = this.a;     // Catch: Exception -> L33
        Object r7 = r6.j[0];     // Catch: Exception -> L33
        Method r8 = r7.getClass().getDeclaredMethod("addCallbackLocked", new Class[]{Long.TYPE, Object.class, Object.class});     // Catch: Exception -> L30
        r8.setAccessible(true);     // Catch: Exception -> L30
    L31:
        r6.l = r8;     // Catch: Exception -> L33
        h r9 = this.a;     // Catch: Exception -> L33
        r9.c(r9.p);     // Catch: Exception -> L33
        return;
    L30:
        r8 = null;
        goto L31
    L13:
        if (r0 <= 28) goto L15;
        h r10 = this.a;     // Catch: Exception -> L33
        r10.k = (long[]) h.b(r10, h.b(r10, r10.m, "mFrameInfo"), "frameInfo");     // Catch: Exception -> L33
        goto L18
    L15:
        if (r0 <= 22) goto L18;
        h r11 = this.a;     // Catch: Exception -> L33
        r11.k = (long[]) h.a(r11, h.a(r11, r11.m, "mFrameInfo"), "mFrameInfo");     // Catch: Exception -> L33
    L33:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "MainThreadMonitor_fullFps");
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

    public j(h r1) {
        this.a = r1;
    }
}
