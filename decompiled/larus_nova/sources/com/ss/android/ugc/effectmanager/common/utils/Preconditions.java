package com.ss.android.ugc.effectmanager.common.utils;

import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes40.dex */
public final class Preconditions {
    public static void checkUiThread() {
        Thread r100 = ThreadMethodProxy.currentThread();
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != r100) goto L6;
        return;
    L6:
        throw new IllegalStateException("Method cannot be called off the main application thread (on: " + r100.getName() + ")");
    }

    private Preconditions() {
    }

    public static <T> T checkNotNull(T r100) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw null;
    }

    public static void checkState(boolean r100) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException();
    }

    public static <T> T checkNotNull(T r100, Object r101) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw new NullPointerException(String.valueOf(r101));
    }
}
