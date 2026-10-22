package com.bytedance.ies.android.base.runtime.depend;

import java.util.concurrent.ExecutorService;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* JADX INFO: loaded from: classes19.dex */
@Deprecated(message = "已废弃", replaceWith = @ReplaceWith(expression = "com.bytedance.android.ad.sdk.api.thread.IAdThreadExecutorServiceDepend", imports = {}))
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ies/android/base/runtime/depend/IThreadPoolExecutorDepend;", "", "getCPUThreadExecutor", "Ljava/util/concurrent/ExecutorService;", "getIOThreadExecutor", "getNormalThreadExecutor", "runtime-api_release"}, k = 1, mv = {1, 1, 16})
public interface IThreadPoolExecutorDepend {
    ExecutorService getCPUThreadExecutor();

    ExecutorService getIOThreadExecutor();

    ExecutorService getNormalThreadExecutor();
}
