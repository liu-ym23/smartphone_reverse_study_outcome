package com.bytedance.sysoptimizer.javahook;

import android.graphics.Matrix;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes22.dex */
public class ProxyView {
    private static final String TAG = "ProxyView";

    public ProxyView() {
    }

    public Matrix getMatrix() throws Throwable {
        AHook.getCallback().e(TAG, "getMatrix() called", new Throwable());
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) == ThreadMethodProxy.currentThread()) goto L6;
        AHook.getCallback().e(TAG, "getMatrix() called in sub thread", new Throwable());
    L6:
        return (Matrix) AHook.callOrigin(OriginMethodKey.KEY_VIEW_GETMATRIX, this, new Object[0]);
    }
}
