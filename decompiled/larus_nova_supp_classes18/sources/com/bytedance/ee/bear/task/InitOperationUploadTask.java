package com.bytedance.ee.bear.task;

import android.content.Context;
import org.koin.java.a;
import zk5.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class InitOperationUploadTask extends BaseAsyncLaunchTask {
    public final int c() {
        return 5;
    }

    public InitOperationUploadTask() {
    }

    @Override // com.bytedance.ee.bear.task.BaseAsyncLaunchTask
    public final void a(Context r1) {
        ((b) a.a(b.class)).checkAndInit();
    }
}
