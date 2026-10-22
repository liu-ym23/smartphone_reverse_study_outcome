package com.ss.android.cert.manager.utils.thread;

import com.bytedance.common.utility.concurrent.TTExecutors;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.utils.CertLog;
import java.util.concurrent.ExecutorService;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
public class BCThread implements Runnable {
    private static volatile ExecutorService CACHED_EXECUTOR;
    public Runnable mRunnable;

    public BCThread() {
        this(null);
    }

    @Override // java.lang.Runnable
    public void run() {
        com_ss_android_cert_manager_utils_thread_BCThread_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    private static ExecutorService getCachedExecutor() {
        if (CACHED_EXECUTOR != null) goto L15;
        monitor-enter(BCThread.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (CACHED_EXECUTOR != null) goto L9;
        CACHED_EXECUTOR = TTExecutors.getNormalExecutor();     // Catch: Throwable -> L11
    L9:
        monitor-exit(BCThread.class);     // Catch: Throwable -> L11
    L15:
        return CACHED_EXECUTOR;
    }

    public void com_ss_android_cert_manager_utils_thread_BCThread__run$___twin___() {
        Runnable r100 = this.mRunnable;
        if (r100 == null) goto L11;
        r100.run();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        CertLog.e("BCThread", "BCThread exception occur", e);
        return;
    }

    public void start() {
        getCachedExecutor().execute(this);
    }

    public BCThread(Runnable r100) {
        this.mRunnable = r100;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_ss_android_cert_manager_utils_thread_BCThread_com_larus_apm_impl_protector_RunnableLancet_run(BCThread r100) {
        r100.com_ss_android_cert_manager_utils_thread_BCThread__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public static void setExecutorService(ExecutorService r100) {
        CACHED_EXECUTOR = r100;
    }

    public static void submitRunnable(Runnable r100) {
        getCachedExecutor().execute(r100);
    }
}
