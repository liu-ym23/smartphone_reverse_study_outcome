package com.bytedance.applog.priority;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Collections;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes14.dex */
public class NativeRunnable implements Runnable {
    private static final List<String> loggerTags = null;
    private final long nativeTaskPtr;

    public native void nativeRun(long r100);

    @Override // java.lang.Runnable
    public void run() {
        com_bytedance_applog_priority_NativeRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    static {
        loggerTags = Collections.singletonList("PriorityNativeRunnable");
    }

    public void com_bytedance_applog_priority_NativeRunnable__run$___twin___() {
        com.bytedance.applog.log.n.w().e(loggerTags, "run with native ptr: " + this.nativeTaskPtr, new Object[0]);
        nativeRun(this.nativeTaskPtr);
    }

    public NativeRunnable(long r100) {
        this.nativeTaskPtr = r100;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_bytedance_applog_priority_NativeRunnable_com_larus_apm_impl_protector_RunnableLancet_run(NativeRunnable r100) {
        r100.com_bytedance_applog_priority_NativeRunnable__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
