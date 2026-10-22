package es3;

import android.os.Build;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes14.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f473753a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f473754a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f473754a.f473753a.e();     // Catch: Throwable -> L4
            return;
        }

        public a(j r100) {
            this.f473754a = r100;
        }
    }

    public final void a() {
        h r100 = this.f473753a;     // Catch: Exception -> L33
        r100.f473733p = new a(this);     // Catch: Exception -> L33
        r100.f473726i = h.a(r100, r100.f473730m, "mLock");     // Catch: Exception -> L33
        h r101 = this.f473753a;     // Catch: Exception -> L33
        if (r101.f473726i != null) goto L6;
        r101.f473726i = h.b(r101, r101.f473730m, "mLock");     // Catch: Exception -> L33
    L6:
        h r102 = this.f473753a;     // Catch: Exception -> L33
        r102.f473727j = (Object[]) h.a(r102, r102.f473730m, "mCallbackQueues");     // Catch: Exception -> L33
        h r103 = this.f473753a;     // Catch: Exception -> L33
        if (r103.f473727j != null) goto L9;
        r103.f473727j = (Object[]) h.b(r103, r103.f473730m, "mCallbackQueues");     // Catch: Exception -> L33
    L9:
        int r104 = Build.VERSION.SDK_INT;     // Catch: Exception -> L33
        if (r104 != 28) goto L13;
        h r105 = this.f473753a;     // Catch: Exception -> L33
        r105.f473728k = (long[]) h.b(r105, h.b(r105, r105.f473730m, "mFrameInfo"), "mFrameInfo");     // Catch: Exception -> L33
    L18:
        if (this.f473753a.f473728k != null) goto L22;
        if (r104 <= 22) goto L22;
        EnsureManager.ensureNotReachHere("FrameInfoIsNull");     // Catch: Exception -> L33
    L22:
        if (this.f473753a.f473726i != null) goto L25;
        EnsureManager.ensureNotReachHere("CallbackQueueLockIsNull");     // Catch: Exception -> L33
    L25:
        if (this.f473753a.f473727j != null) goto L27;
        EnsureManager.ensureNotReachHere("callbackQueuesIsNull");     // Catch: Exception -> L33
    L27:
        h r106 = this.f473753a;     // Catch: Exception -> L33
        Object r107 = r106.f473727j[0];     // Catch: Exception -> L33
        Method r108 = r107.getClass().getDeclaredMethod("addCallbackLocked", new Class[]{Long.TYPE, Object.class, Object.class});     // Catch: Exception -> L30
        r108.setAccessible(true);     // Catch: Exception -> L30
    L31:
        r106.f473729l = r108;     // Catch: Exception -> L33
        h r109 = this.f473753a;     // Catch: Exception -> L33
        r109.c(r109.f473733p);     // Catch: Exception -> L33
        return;
    L30:
        r108 = null;
        goto L31
    L13:
        if (r104 <= 28) goto L15;
        h r110 = this.f473753a;     // Catch: Exception -> L33
        r110.f473728k = (long[]) h.b(r110, h.b(r110, r110.f473730m, "mFrameInfo"), "frameInfo");     // Catch: Exception -> L33
        goto L18
    L15:
        if (r104 <= 22) goto L18;
        h r111 = this.f473753a;     // Catch: Exception -> L33
        r111.f473728k = (long[]) h.a(r111, h.a(r111, r111.f473730m, "mFrameInfo"), "mFrameInfo");     // Catch: Exception -> L33
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

    public j(h r100) {
        this.f473753a = r100;
    }
}
