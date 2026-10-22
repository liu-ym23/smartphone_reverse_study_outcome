package com.bytedance.ee.lark.infra.foundation.schedulers;

/* JADX INFO: loaded from: classes19.dex */
public class AsyncSchedulerInit {
    static volatile boolean lockdown;
    static volatile SchedulerCreator onInitNetHandler;

    public AsyncSchedulerInit() {
    }

    public static void lockdown() {
        lockdown = true;
    }

    public static SchedulerCreator getNetSchedulerHandler() {
        return onInitNetHandler;
    }

    public static boolean isLockdown() {
        return lockdown;
    }

    public static SchedulerCreator onNetScheduler(SchedulerCreator r100) {
        lockdown();
        if (onInitNetHandler != null) goto L5;
        return r100;
    L5:
        return onInitNetHandler;
    }

    public static void setNetSchedulerHandler(SchedulerCreator r100) {
        if (lockdown == false) goto L5;
        return;
    L5:
        onInitNetHandler = r100;
    }
}
