package com.google.common.util.concurrent;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
final class Platform {
    private Platform() {
    }

    public static void restoreInterruptIfIsInterruptedException(Throwable r100) {
        r100.getClass();
        if ((r100 instanceof InterruptedException) == false) goto L6;
        ThreadMethodProxy.currentThread().interrupt();
        return;
    }

    public static boolean isInstanceOfThrowableClass(@CheckForNull Throwable r100, Class<? extends Throwable> r101) {
        return r101.isInstance(r100);
    }
}
