package com.bytedance.locallife.biz.monitor.param;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/locallife/biz/monitor/param/TaskType;", "", "SET_PARAMS_JSON", "SET_PARAMS_URI", "REMOVE_PAGE", "CLEAR_ALL", "CHECK_PARAMS", "locallife-biz-common_release"}, k = 1, mv = {1, 4, 3})
public final enum TaskType extends Enum<TaskType> {
    public static final TaskType CHECK_PARAMS = null;
    public static final TaskType CLEAR_ALL = null;
    public static final TaskType REMOVE_PAGE = null;
    public static final TaskType SET_PARAMS_JSON = null;
    public static final TaskType SET_PARAMS_URI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TaskType[] f256718a = null;

    public static TaskType valueOf(String r100) {
        return (TaskType) r27.a.a(TaskType.class, r100);
    }

    public static TaskType[] values() {
        return (TaskType[]) f256718a.clone();
    }

    static {
        TaskType r100 = new TaskType("SET_PARAMS_JSON", 0);
        SET_PARAMS_JSON = r100;
        TaskType r101 = new TaskType("SET_PARAMS_URI", 1);
        SET_PARAMS_URI = r101;
        TaskType r102 = new TaskType("REMOVE_PAGE", 2);
        REMOVE_PAGE = r102;
        TaskType r103 = new TaskType("CLEAR_ALL", 3);
        CLEAR_ALL = r103;
        TaskType r104 = new TaskType("CHECK_PARAMS", 4);
        CHECK_PARAMS = r104;
        f256718a = new TaskType[]{r100, r101, r102, r103, r104};
    }

    public TaskType(String r100, int r101) {
        super(r100, r101);
    }
}
