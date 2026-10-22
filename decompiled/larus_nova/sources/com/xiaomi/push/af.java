package com.xiaomi.push;

import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes41.dex */
public class af {
    public static void a() {
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) == ThreadMethodProxy.currentThread()) goto L6;
        return;
    L6:
        throw new RuntimeException("can't do this on ui thread");
    }
}
