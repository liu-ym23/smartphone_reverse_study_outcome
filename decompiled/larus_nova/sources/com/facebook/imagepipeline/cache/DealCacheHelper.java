package com.facebook.imagepipeline.cache;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes23.dex */
public class DealCacheHelper {
    private static volatile ExecutorService sIOExecutor;

    public DealCacheHelper() {
    }

    public static ExecutorService getIOExecutor() {
        if (sIOExecutor != null) goto L15;
        monitor-enter(DealCacheHelper.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sIOExecutor != null) goto L9;
        sIOExecutor = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("DealCacheHelper"));     // Catch: Throwable -> L11
    L9:
        monitor-exit(DealCacheHelper.class);     // Catch: Throwable -> L11
    L15:
        return sIOExecutor;
    }
}
