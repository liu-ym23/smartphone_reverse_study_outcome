package com.bytedance.ee.lark.infra.foundation.schedulers;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.Callable;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes19.dex */
public abstract class CompletableFutureTask<V> implements Runnable {
    private static final int CANCELLED = 4;
    private static final int COMPLETING = 1;
    private static final int EXCEPTIONAL = 3;
    private static final int NEW = 0;
    private static final int NORMAL = 2;
    private Callable<V> callable;
    private volatile int state;

    public abstract void onError(Throwable r100);

    public abstract void onResult(V r100);

    @Override // java.lang.Runnable
    public void run() {
        com_bytedance_ee_lark_infra_foundation_schedulers_CompletableFutureTask_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public boolean cancel() {
        if (this.state != 0) goto L5;
    L9:
        this.state = 4;
        return true;
    L5:
        if (this.state == 4) goto L9;
        return false;
    }

    public void com_bytedance_ee_lark_infra_foundation_schedulers_CompletableFutureTask__run$___twin___() {
        if (this.state == 0) goto L5;
        return;
    L5:
        this.state = 1;
        onResult(this.callable.call());     // Catch: Throwable -> L8
        this.state = 2;     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        onError(th);
        this.state = 3;
    }

    public boolean isCancelled() {
        if (this.state < 4) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isUnSubscribe() {
        if (this.state < 2) goto L5;
        return true;
    L5:
        return false;
    }

    public CompletableFutureTask(Callable<V> r100) {
        if (r100 == null) goto L7;
        this.callable = r100;
        this.state = 0;
        return;
    L7:
        throw new NullPointerException("callable should not null");
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_bytedance_ee_lark_infra_foundation_schedulers_CompletableFutureTask_com_larus_apm_impl_protector_RunnableLancet_run(CompletableFutureTask r100) {
        r100.com_bytedance_ee_lark_infra_foundation_schedulers_CompletableFutureTask__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
