package com.bytedance.ee.util.db;

import androidx.arch.core.executor.DefaultTaskExecutor;
import ju5.l;

/* JADX INFO: loaded from: classes19.dex */
public class SecureTaskExecutor extends DefaultTaskExecutor {
    public SecureTaskExecutor() {
    }

    @Override // androidx.arch.core.executor.DefaultTaskExecutor, androidx.arch.core.executor.TaskExecutor
    public final void executeOnDiskIO(Runnable r100) {
        super.executeOnDiskIO(new l(r100));
    }

    @Override // androidx.arch.core.executor.DefaultTaskExecutor, androidx.arch.core.executor.TaskExecutor
    public final void postToMainThread(Runnable r100) {
        super.postToMainThread(new l(r100));
    }
}
