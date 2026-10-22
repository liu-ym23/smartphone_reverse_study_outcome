package com.obric.assistant.task;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/task/TaskStatus;", "", "<init>", "(Ljava/lang/String;I)V", "QUEUEING", "PROGRESS", "COMPLETED", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TaskStatus extends Enum<TaskStatus> {
    public static final TaskStatus COMPLETED = null;
    public static final TaskStatus PROGRESS = null;
    public static final TaskStatus QUEUEING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TaskStatus[] f393372a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f393373b = null;

    public static EnumEntries<TaskStatus> getEntries() {
        return f393373b;
    }

    static {
        TaskStatus r100 = new TaskStatus("QUEUEING", 0);
        QUEUEING = r100;
        TaskStatus r101 = new TaskStatus("PROGRESS", 1);
        PROGRESS = r101;
        TaskStatus r102 = new TaskStatus("COMPLETED", 2);
        COMPLETED = r102;
        TaskStatus[] r103 = {r100, r101, r102};
        f393372a = r103;
        f393373b = EnumEntriesKt.enumEntries(r103);
    }

    public static TaskStatus[] values() {
        return (TaskStatus[]) f393372a.clone();
    }

    public static TaskStatus valueOf(String r100) {
        return (TaskStatus) r27.a.a(TaskStatus.class, r100);
    }

    public TaskStatus(String r100, int r101) {
        super(r100, r101);
    }
}
