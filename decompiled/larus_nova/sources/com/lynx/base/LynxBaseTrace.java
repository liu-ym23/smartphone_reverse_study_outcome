package com.lynx.base;

import com.lynx.base.log.LynxLog;
import com.lynx.tasm.service.ILynxTraceService;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import i8a.n;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes32.dex */
public class LynxBaseTrace {
    private static final String TAG = "LynxBaseTrace";
    private static final AtomicBoolean sHasInit = null;
    private static volatile boolean sIsNativeLibLoad;

    public LynxBaseTrace() {
    }

    private static native void nativeInitBaseTrace(long r100);

    static {
        sHasInit = new AtomicBoolean(false);
    }

    public static void init() {
        if (sHasInit.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        ThreadMethodProxy.start(new PthreadThreadV2(new AnonymousClass1(), "LynxTraceInit"));
    }

    public static /* synthetic */ boolean access$100() {
        return initNativeBaseTrace();
    }

    private static boolean initNativeBaseTrace() {
        ILynxTraceService r100 = (ILynxTraceService) n.c().a(ILynxTraceService.class);
        if (r100 != null) goto L6;
        nativeInitBaseTrace(0);
        LynxLog.i(TAG, "LynxBaseTrace init successfully by itself.");
        return true;
    L6:
        long r101 = r100.getDefaultTraceFunction();
        if (r101 == 0) goto L10;
        nativeInitBaseTrace(r101);
        LynxLog.i(TAG, "LynxBaseTrace init successfully by custom LynxBaseTraceService. function native address is " + r101);
        return true;
    L10:
        LynxLog.i(TAG, "failed to init LynxBaseTrace dependency");
        return false;
    }

    public static /* synthetic */ boolean access$000() {
        return sIsNativeLibLoad;
    }

    public static /* synthetic */ boolean access$002(boolean r100) {
        sIsNativeLibLoad = r100;
        return r100;
    }
}
