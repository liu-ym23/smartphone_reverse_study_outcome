package com.bytedance.sysoptimizer;

import android.content.Context;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes22.dex */
public class JNIEnvExceptionOpt {
    private static volatile boolean sInit;
    private static IThrowableConsumer sThrowableConsumer;

    public interface IThrowableConsumer {
        boolean consume(Thread r100, Throwable r101);
    }

    public JNIEnvExceptionOpt() {
    }

    private static native int nStart();

    private static boolean consume(Throwable r100) {
        IThrowableConsumer r101 = sThrowableConsumer;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.consume(ThreadMethodProxy.currentThread(), r100);
    }

    public static int start(Context r100, IThrowableConsumer r101) {
        if (sInit == false) goto L6;
        return 1;
    L6:
        if (SysOptimizer.loadOptimizerLibrary(r100) == true) goto L8;
        return -1;
    L8:
        if (sInit == true) goto L13;
        sThrowableConsumer = r101;
        int r102 = nStart();
        sInit = true;
        return r102;
    L13:
        return -1;
    }
}
