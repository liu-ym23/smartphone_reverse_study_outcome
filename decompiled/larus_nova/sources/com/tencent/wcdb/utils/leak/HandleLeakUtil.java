package com.tencent.wcdb.utils.leak;

import android.os.Handler;
import android.util.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import tpc.a;

/* JADX INFO: loaded from: classes35.dex */
public class HandleLeakUtil implements IHandleLeak {
    public static final long DELAY_INTERVAL = 0;
    public static final String TAG = "WCDB2_Handler_Leak";
    public static boolean enableCheckHandleLeak;
    private static IHandleLeak inst;
    private final ConcurrentHashMap<String, Runnable> handleLeakHashMap;
    private final Handler handler;

    public static /* synthetic */ void a(String r100) {
        lambda$startTimer$0(r100);
    }

    private static /* synthetic */ void lambda$startTimer$0(String r100) {
    }

    static {
        DELAY_INTERVAL = TimeUnit.SECONDS.toMillis(10);
    }

    public static IHandleLeak inst() {
        IHandleLeak r100 = inst;
        if (r100 == null) goto L6;
        return r100;
    L6:
        if (enableCheckHandleLeak == false) goto L8;
        inst = new HandleLeakUtil();
    L10:
        return inst;
    L8:
        inst = new HandleLeakNoop();
        goto L10
    }

    public HandleLeakUtil() {
        this.handleLeakHashMap = new ConcurrentHashMap();
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("handlerCheck");
        ThreadMethodProxy.start(r100);
        this.handler = new Handler(r100.getLooper());
    }

    @Override // com.tencent.wcdb.utils.leak.IHandleLeak
    public void cancelTimer(String r100) {
        Runnable r101 = this.handleLeakHashMap.get(r100);
        if (r101 == null) goto L6;
        this.handler.removeCallbacks(r101);
        this.handleLeakHashMap.remove(r100);
        return;
    }

    @Override // com.tencent.wcdb.utils.leak.IHandleLeak
    public void startTimer(String r100) {
        if (this.handleLeakHashMap.containsKey(r100) == false) goto L5;
        return;
    L5:
        final String r101 = Log.getStackTraceString(new RuntimeException("handleLeak=" + r100 + "_tid=" + ThreadMethodProxy.currentThread().getId() + "_tName=" + ThreadMethodProxy.currentThread().getName()));
        Runnable r102 = new a(r101);
        this.handleLeakHashMap.put(r100, r102);
        this.handler.postDelayed(r102, DELAY_INTERVAL);
    }
}
