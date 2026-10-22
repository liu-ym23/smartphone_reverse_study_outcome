package com.ss.android.lark.framework.assembly.eventbus;

import android.content.Context;
import com.larksuite.framework.launch.task.AsyncLaunchTask;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.eventbus.EventBus;

/* JADX INFO: loaded from: classes36.dex */
public class InitThreadPoolEventBusTask extends AsyncLaunchTask {
    public InitThreadPoolEventBusTask() {
    }

    @Override // com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final void a(Context r100) {
        EventBus.getDefault().setExecutorService(CoreThreadPool.getDefault().getFixedThreadPool());
    }
}
