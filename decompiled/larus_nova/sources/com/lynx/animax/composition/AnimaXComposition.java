package com.lynx.animax.composition;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.animax.util.AnimaXLog;

/* JADX INFO: loaded from: classes32.dex */
public class AnimaXComposition {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f380258a;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f380259a;

        @Override // java.lang.Runnable
        public final void run() {
            AnimaXLog.b("AnimaXComposition", "nativeDestroy AnimaXComposition on CleanupReference.");     // Catch: Throwable -> L6
            long r100 = this.f380259a;     // Catch: Throwable -> L6
            if (r100 == 0) goto L9;
            AnimaXComposition.a(r100);     // Catch: Throwable -> L6
            this.f380259a = 0;     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public a(long r100) {
            this.f380259a = r100;
        }
    }

    private static native void nativeDestroy(long r100);

    private native long nativeGetEndFrame(long r100);

    private native long nativeGetStartFrame(long r100);

    public AnimaXComposition(long r100) {
        this.f380258a = r100;
        new q4a.a(this, new a(r100));
    }

    public static /* synthetic */ void a(long r100) {
        nativeDestroy(r100);
    }

    public static AnimaXComposition create(long r100) {
        return new AnimaXComposition(r100);
    }
}
