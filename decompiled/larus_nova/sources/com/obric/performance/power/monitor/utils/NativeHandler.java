package com.obric.performance.power.monitor.utils;

import android.util.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0086 J\b\u0010\n\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/performance/power/monitor/utils/NativeHandler;", "", "<init>", "()V", "TAG", "", "setDebugger", "", "open", "", "getStack", "performance-power_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NativeHandler {
    public NativeHandler() {
    }

    public final native void setDebugger(boolean r100);

    static {
        new NativeHandler();
        EnsureLoad.f403830a.init();
    }

    @JvmStatic
    public static final void getStack() {
        Log.getStackTraceString(new RuntimeException(ThreadMethodProxy.currentThread().getName()));
    }
}
