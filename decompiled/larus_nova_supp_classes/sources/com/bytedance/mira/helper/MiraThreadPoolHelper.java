package com.bytedance.mira.helper;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class MiraThreadPoolHelper {
    public static Executor sMiraFastExecutor;
    public static ScheduledExecutorService sSingleThreadPool;

    public MiraThreadPoolHelper() {
    }

    static {
        sMiraFastExecutor = PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory("MiraThreadPoolHelper"));
        sSingleThreadPool = PThreadExecutorsUtils.newSingleThreadScheduledExecutor(new DefaultThreadFactory("MiraThreadPoolHelper"));
    }

    public static ExecutorService createInstallThreadPool(int r1) {
        return PThreadExecutorsUtils.newFixedThreadPool(r1, new 1());
    }
}
