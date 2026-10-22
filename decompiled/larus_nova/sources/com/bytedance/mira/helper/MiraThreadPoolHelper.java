package com.bytedance.mira.helper;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public class MiraThreadPoolHelper {
    public static Executor sMiraFastExecutor;
    public static ScheduledExecutorService sSingleThreadPool;

    public MiraThreadPoolHelper() {
    }

    static {
        sMiraFastExecutor = PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory("MiraThreadPoolHelper"));
        sSingleThreadPool = PThreadExecutorsUtils.newSingleThreadScheduledExecutor(new DefaultThreadFactory("MiraThreadPoolHelper"));
    }

    public static ExecutorService createInstallThreadPool(int r100) {
        return PThreadExecutorsUtils.newFixedThreadPool(r100, new AnonymousClass1());
    }
}
