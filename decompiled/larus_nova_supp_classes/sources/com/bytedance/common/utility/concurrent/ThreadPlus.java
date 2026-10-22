package com.bytedance.common.utility.concurrent;

import com.bytedance.common.utility.Logger;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class ThreadPlus implements Runnable {
    protected static final AtomicInteger S_COUNT = null;
    private static ExecutorService mCachedExecutor;
    private static ExecutorService mFixedExecutor;
    private final boolean mBackground;
    private Runnable runnable;

    public ThreadPlus() {
        this(false);
    }

    public static void shutdown() {
    }

    @Override // java.lang.Runnable
    public void run() {
        com_bytedance_common_utility_concurrent_ThreadPlus_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_bytedance_common_utility_concurrent_ThreadPlus__run$___twin___() {
        Runnable r0 = this.runnable;
        if (r0 == null) goto L6;
        r0.run();
        return;
    }

    static {
        mCachedExecutor = TTExecutors.getNormalExecutor();
        mFixedExecutor = TTExecutors.getNormalExecutor();
        S_COUNT = new AtomicInteger();
    }

    public void start() {
        if (Logger.debug() == false) goto L5;
        ThreadPlus r0 = new 1(this);
    L7:
        if (this.mBackground == false) goto L9;
        mFixedExecutor.submit(r0);
        return;
    L9:
        mCachedExecutor.submit(r0);
        return;
    L5:
        r0 = this;
        goto L7
    }

    public ThreadPlus(boolean r1) {
        this.mBackground = r1;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_bytedance_common_utility_concurrent_ThreadPlus_com_larus_apm_impl_protector_RunnableLancet_run(ThreadPlus r1) {
        r1.com_bytedance_common_utility_concurrent_ThreadPlus__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public static void setExecutorService(ExecutorService r0) {
        mCachedExecutor = r0;
        mFixedExecutor = r0;
    }

    public static void submitRunnable(Runnable r1) {
        if (r1 == null) goto L5;
        mCachedExecutor.submit(r1);
        return;
    }

    public ThreadPlus(String r1) {
        this(false);
    }

    public ThreadPlus(Runnable r1, String r2, boolean r3) {
        this.runnable = r1;
        this.mBackground = r3;
    }
}
