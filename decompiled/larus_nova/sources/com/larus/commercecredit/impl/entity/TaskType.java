package com.larus.commercecredit.impl.entity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/commercecredit/impl/entity/TaskType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "TASK_TYPE_MOBILE_ACTIVITY", "TASK_TYPE_PC_ACTIVITY", "TASK_TYPE_FISSION_CAMPAIGN", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TaskType extends Enum<TaskType> {
    public static final TaskType TASK_TYPE_FISSION_CAMPAIGN = null;
    public static final TaskType TASK_TYPE_MOBILE_ACTIVITY = null;
    public static final TaskType TASK_TYPE_PC_ACTIVITY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TaskType[] f325717a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f325718b = null;
    private final int type;

    public static EnumEntries<TaskType> getEntries() {
        return f325718b;
    }

    static {
        TaskType r100 = new TaskType("TASK_TYPE_MOBILE_ACTIVITY", 0, 1);
        TASK_TYPE_MOBILE_ACTIVITY = r100;
        TaskType r101 = new TaskType("TASK_TYPE_PC_ACTIVITY", 1, 2);
        TASK_TYPE_PC_ACTIVITY = r101;
        TaskType r102 = new TaskType("TASK_TYPE_FISSION_CAMPAIGN", 2, 3);
        TASK_TYPE_FISSION_CAMPAIGN = r102;
        TaskType[] r103 = {r100, r101, r102};
        f325717a = r103;
        f325718b = EnumEntriesKt.enumEntries(r103);
    }

    public static TaskType[] values() {
        return (TaskType[]) f325717a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static TaskType valueOf(String r100) {
        return (TaskType) a.a(TaskType.class, r100);
    }

    public TaskType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
