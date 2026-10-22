package com.ss.android.lark.app.task.scheduler;

import com.obric.miniapp.alarm.AccountType;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public final enum TaskConsumeType extends Enum<TaskConsumeType> {
    public static final TaskConsumeType ALL = null;
    public static final TaskConsumeType ONLY_ASYNC = null;
    public static final TaskConsumeType ONLY_SYNC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TaskConsumeType[] f408765a = null;

    static {
        TaskConsumeType r100 = new TaskConsumeType("ONLY_SYNC", 0);
        ONLY_SYNC = r100;
        TaskConsumeType r101 = new TaskConsumeType("ONLY_ASYNC", 1);
        ONLY_ASYNC = r101;
        TaskConsumeType r102 = new TaskConsumeType(AccountType.ALL, 2);
        ALL = r102;
        f408765a = new TaskConsumeType[]{r100, r101, r102};
    }

    public static TaskConsumeType[] values() {
        return (TaskConsumeType[]) f408765a.clone();
    }

    public static TaskConsumeType valueOf(String r100) {
        return (TaskConsumeType) a.a(TaskConsumeType.class, r100);
    }

    public TaskConsumeType(String r100, int r101) {
        super(r100, r101);
    }
}
