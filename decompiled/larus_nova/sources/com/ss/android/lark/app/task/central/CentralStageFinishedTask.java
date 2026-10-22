package com.ss.android.lark.app.task.central;

import android.content.Context;
import com.larksuite.framework.launch.task.AsyncLaunchTask;
import com.larksuite.framework.launch.task.ILaunchTask;
import com.ss.android.lark.app.task.scheduler.LaunchTaskExecutor;
import com.ss.android.lark.log.Log;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public class CentralStageFinishedTask extends AsyncLaunchTask {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Class<? extends ILaunchTask>> f408751c;

    @Override // com.larksuite.framework.launch.task.AbstractLaunchTask
    public final List<Class<? extends ILaunchTask>> i() {
        return this.f408751c;
    }

    public CentralStageFinishedTask(List<Class<? extends ILaunchTask>> r100) {
        this.f408751c = r100;
    }

    @Override // com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final void a(Context r100) {
        LaunchTaskExecutor r101 = LaunchTaskExecutor.b();
        r101.getClass();
        Log.i("LaunchTaskExecutor", "shutdown is called! from = CentralStageFinishedTask");
        r101.f408760a = true;
        r101.f408761b.add(new LaunchTaskExecutor.TaskWrapper(null, null));
    }
}
