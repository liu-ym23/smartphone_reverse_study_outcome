package com.bytedance.ee.lark.infra.foundation.schedulers;

import com.bytedance.ee.lark.infra.foundation.log.AppBrandLogger;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.optrace.api.TracingCoreSpan;
import com.ss.android.lark.optrace.core.b;
import com.ss.android.lark.optrace.core.c;
import java.util.concurrent.Callable;
import jyb.a;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes19.dex */
public abstract class SpanWrappedTask<V> extends CompletableFutureTask<V> {
    private static final String TAG = "SpanWrappedTask";
    private TracingCoreSpan mSpan;

    @Override // com.bytedance.ee.lark.infra.foundation.schedulers.CompletableFutureTask, java.lang.Runnable
    public void run() {
        com_bytedance_ee_lark_infra_foundation_schedulers_SpanWrappedTask_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_bytedance_ee_lark_infra_foundation_schedulers_SpanWrappedTask__run$___twin___() {
        if (this.mSpan == null) goto L8;
        c.f437607a.getClass();
        b r100 = a.f501070b;
        TracingCoreSpan r101 = this.mSpan;
        r100.getClass();
        com.ss.android.lark.optrace.core.a r102 = new com.ss.android.lark.optrace.core.a(r100, r101);
        super.run();
        if (r100.f437606a.get() != r102) goto L11;
        r100.f437606a.set(r102.f437605b);
        return;
    L11:
        return;
    L8:
        AppBrandLogger.w(TAG, new Object[]{"span null"});
        super.run();
    }

    public SpanWrappedTask(Callable<V> r100) {
        super(r100);
        c.f437607a.getClass();
        com.ss.android.lark.optrace.core.a r101 = a.f501070b.f437606a.get();
        if (r101 != null) goto L5;
        TracingCoreSpan r102 = null;
    L6:
        if (r102 != null) goto L8;
        AppBrandLogger.w(TAG, new Object[]{"no activeSpan for currentThread"});
        r102 = gyb.a.a();
        c.f437607a.getClass();
        b r103 = a.f501070b;
        r103.getClass();
        new com.ss.android.lark.optrace.core.a(r103, r102);
    L8:
        this.mSpan = r102.generateSpan();
        return;
    L5:
        r102 = r101.f437604a;
        goto L6
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_bytedance_ee_lark_infra_foundation_schedulers_SpanWrappedTask_com_larus_apm_impl_protector_RunnableLancet_run(SpanWrappedTask r100) {
        r100.com_bytedance_ee_lark_infra_foundation_schedulers_SpanWrappedTask__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
