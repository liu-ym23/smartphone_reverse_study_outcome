package com.bytedance.common.utility.concurrent;

import com.bytedance.common.utility.Logger;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
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
        Runnable r100 = this.runnable;
        if (r100 == null) goto L6;
        r100.run();
        return;
    }

    static {
        mCachedExecutor = TTExecutors.getNormalExecutor();
        mFixedExecutor = TTExecutors.getNormalExecutor();
        S_COUNT = new AtomicInteger();
    }

    public void start() {
        if (Logger.debug() == false) goto L5;
        Runnable r100 = new AnonymousClass1(this);
    L7:
        if (this.mBackground == false) goto L9;
        mFixedExecutor.submit(r100);
        return;
    L9:
        mCachedExecutor.submit(r100);
        return;
    L5:
        r100 = this;
        goto L7
    }

    public ThreadPlus(boolean r100) {
        this.mBackground = r100;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_bytedance_common_utility_concurrent_ThreadPlus_com_larus_apm_impl_protector_RunnableLancet_run(ThreadPlus r100) {
        r100.com_bytedance_common_utility_concurrent_ThreadPlus__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public static void setExecutorService(ExecutorService r100) {
        mCachedExecutor = r100;
        mFixedExecutor = r100;
    }

    public static void submitRunnable(Runnable r100) {
        if (r100 == null) goto L5;
        mCachedExecutor.submit(r100);
        return;
    }

    public ThreadPlus(String r100) {
        this(false);
    }

    public ThreadPlus(Runnable r100, String r101, boolean r102) {
        this.runnable = r100;
        this.mBackground = r102;
    }
}
