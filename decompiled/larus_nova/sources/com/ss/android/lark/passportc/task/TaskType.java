package com.ss.android.lark.passportc.task;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/passportc/task/TaskType;", "", "<init>", "(Ljava/lang/String;I)V", "OFFLINE", "ONLINE", "passport-container-manager_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TaskType extends Enum<TaskType> {
    public static final TaskType OFFLINE = null;
    public static final TaskType ONLINE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TaskType[] f438498a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f438499b = null;

    public static EnumEntries<TaskType> getEntries() {
        return f438499b;
    }

    static {
        TaskType r100 = new TaskType("OFFLINE", 0);
        OFFLINE = r100;
        TaskType r101 = new TaskType("ONLINE", 1);
        ONLINE = r101;
        TaskType[] r102 = {r100, r101};
        f438498a = r102;
        f438499b = EnumEntriesKt.enumEntries(r102);
    }

    public static TaskType[] values() {
        return (TaskType[]) f438498a.clone();
    }

    public static TaskType valueOf(String r100) {
        return (TaskType) r27.a.a(TaskType.class, r100);
    }

    public TaskType(String r100, int r101) {
        super(r100, r101);
    }
}
