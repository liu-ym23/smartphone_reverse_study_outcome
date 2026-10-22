package com.bytedance.ee.bear.task;

import android.content.Context;
import org.koin.java.a;
import zk5.b;

/* JADX INFO: loaded from: classes18.dex */
public class InitOperationUploadTask extends BaseAsyncLaunchTask {
    @Override // com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final int c() {
        return 5;
    }

    public InitOperationUploadTask() {
    }

    @Override // com.bytedance.ee.bear.task.BaseAsyncLaunchTask, com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final void a(Context r100) {
        ((b) a.a(b.class)).checkAndInit();
    }
}
