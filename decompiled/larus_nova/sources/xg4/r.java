package xg4;

import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;

/* JADX INFO: loaded from: classes15.dex */
public final class r implements Runnable {
    public r() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean r100 = "true".equals(com.bytedance.crash.util.h.c(new PolarisFileWrapper(com.bytedance.crash.i.c(), "anr_profiler.config")));     // Catch: Throwable -> L4
    L5:
        if (r100 == true) goto L14;
        NativeBridge.a0();     // Catch: Throwable -> L9
        return;
    L15:
        return;
    L14:
        return;
    L4:
        r100 = false;
        goto L5
    }
}
