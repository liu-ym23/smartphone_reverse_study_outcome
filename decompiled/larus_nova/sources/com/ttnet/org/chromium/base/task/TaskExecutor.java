package com.ttnet.org.chromium.base.task;

/* JADX INFO: loaded from: classes41.dex */
public interface TaskExecutor {
    boolean canRunTaskImmediately(TaskTraits r100);

    SequencedTaskRunner createSequencedTaskRunner(TaskTraits r100);

    SingleThreadTaskRunner createSingleThreadTaskRunner(TaskTraits r100);

    TaskRunner createTaskRunner(TaskTraits r100);

    void postDelayedTask(TaskTraits r100, Runnable r101, long r102);
}
