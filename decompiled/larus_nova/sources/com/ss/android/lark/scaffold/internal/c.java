package com.ss.android.lark.scaffold.internal;

import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes38.dex */
public final class c {
    public static final void a() {
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L9;
        return;
    L9:
        throw new IllegalStateException(("Should be called from the main thread, not " + ThreadMethodProxy.currentThread()).toString());
    L5:
        r100 = false;
        goto L6
    }
}
