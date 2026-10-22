package com.bytedance.apm.agent.tracing;

import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class AutoPageTraceHelper$2 implements Runnable {
    public AutoPageTraceHelper$2() {
    }

    @Override // java.lang.Runnable
    public void run() {
        com_bytedance_apm_agent_tracing_AutoPageTraceHelper$2_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_bytedance_apm_agent_tracing_AutoPageTraceHelper$2__run$___twin___() {
        AutoPageTraceHelper.access$000();
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_bytedance_apm_agent_tracing_AutoPageTraceHelper$2_com_larus_apm_impl_protector_RunnableLancet_run(AutoPageTraceHelper$2 r1) {
        r1.com_bytedance_apm_agent_tracing_AutoPageTraceHelper$2__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
