package com.ttnet.org.chromium.base.task;

import android.view.Choreographer;
import com.ttnet.org.chromium.base.ThreadUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
class DefaultTaskExecutor implements TaskExecutor {
    private final Map<TaskTraits, TaskRunner> mTraitsToRunnerMap;

    public static /* synthetic */ ChoreographerTaskRunner a() {
        return lambda$createChoreographerTaskRunner$0();
    }

    private synchronized ChoreographerTaskRunner createChoreographerTaskRunner() {
        monitor-enter(this);
        ChoreographerTaskRunner r100 = (ChoreographerTaskRunner) ThreadUtils.runOnUiThreadBlockingNoException(new e());     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.base.task.TaskExecutor
    public boolean canRunTaskImmediately(TaskTraits r100) {
        return false;
    }

    private static /* synthetic */ ChoreographerTaskRunner lambda$createChoreographerTaskRunner$0() throws Exception {
        return new ChoreographerTaskRunner(Choreographer.getInstance());
    }

    public DefaultTaskExecutor() {
        this.mTraitsToRunnerMap = new HashMap();
    }

    @Override // com.ttnet.org.chromium.base.task.TaskExecutor
    public SequencedTaskRunner createSequencedTaskRunner(TaskTraits r100) {
        if (r100.mIsChoreographerFrame == false) goto L7;
        return createChoreographerTaskRunner();
    L7:
        return new SequencedTaskRunnerImpl(r100);
    }

    @Override // com.ttnet.org.chromium.base.task.TaskExecutor
    public SingleThreadTaskRunner createSingleThreadTaskRunner(TaskTraits r100) {
        if (r100.mIsChoreographerFrame == false) goto L7;
        return createChoreographerTaskRunner();
    L7:
        return new SingleThreadTaskRunnerImpl(null, r100);
    }

    @Override // com.ttnet.org.chromium.base.task.TaskExecutor
    public TaskRunner createTaskRunner(TaskTraits r100) {
        if (r100.mIsChoreographerFrame == false) goto L7;
        return createChoreographerTaskRunner();
    L7:
        return new TaskRunnerImpl(r100);
    }

    @Override // com.ttnet.org.chromium.base.task.TaskExecutor
    public synchronized void postDelayedTask(TaskTraits r100, Runnable r101, long r102) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (r100.hasExtension() == false) goto L6;
        createTaskRunner(r100).postDelayedTask(r101, r102);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return;
    L6:
        TaskRunner r103 = this.mTraitsToRunnerMap.get(r100);     // Catch: Throwable -> L12
        if (r103 != null) goto L9;
        r103 = createTaskRunner(r100);     // Catch: Throwable -> L12
        this.mTraitsToRunnerMap.put(r100, r103);     // Catch: Throwable -> L12
    L9:
        r103.postDelayedTask(r101, r102);     // Catch: Throwable -> L12
        goto L10
    }
}
