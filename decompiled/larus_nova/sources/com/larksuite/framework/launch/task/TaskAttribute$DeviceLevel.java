package com.larksuite.framework.launch.task;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/larksuite/framework/launch/task/TaskAttribute$DeviceLevel;", "", "title", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getTitle", "()Ljava/lang/String;", "getValue", "()I", "UNKNOWN", "HIGH", "MIDDLE", "LOW", "ULTRALOW", "launch-scheduler_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TaskAttribute$DeviceLevel extends Enum<TaskAttribute$DeviceLevel> {
    public static final TaskAttribute$DeviceLevel HIGH = null;
    public static final TaskAttribute$DeviceLevel LOW = null;
    public static final TaskAttribute$DeviceLevel MIDDLE = null;
    public static final TaskAttribute$DeviceLevel ULTRALOW = null;
    public static final TaskAttribute$DeviceLevel UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TaskAttribute$DeviceLevel[] f285677a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f285678b = null;
    private final String title;
    private final int value;

    public static EnumEntries<TaskAttribute$DeviceLevel> getEntries() {
        return f285678b;
    }

    static {
        TaskAttribute$DeviceLevel r100 = new TaskAttribute$DeviceLevel("UNKNOWN", 0, "unknown", 0);
        UNKNOWN = r100;
        TaskAttribute$DeviceLevel r101 = new TaskAttribute$DeviceLevel("HIGH", 1, "high", 4);
        HIGH = r101;
        TaskAttribute$DeviceLevel r102 = new TaskAttribute$DeviceLevel("MIDDLE", 2, "middle", 3);
        MIDDLE = r102;
        TaskAttribute$DeviceLevel r103 = new TaskAttribute$DeviceLevel("LOW", 3, "low", 2);
        LOW = r103;
        TaskAttribute$DeviceLevel r104 = new TaskAttribute$DeviceLevel("ULTRALOW", 4, "ultralow", 1);
        ULTRALOW = r104;
        TaskAttribute$DeviceLevel[] r110 = {r100, r101, r102, r103, r104};
        f285677a = r110;
        f285678b = EnumEntriesKt.enumEntries(r110);
    }

    public static TaskAttribute$DeviceLevel[] values() {
        return (TaskAttribute$DeviceLevel[]) f285677a.clone();
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getValue() {
        return this.value;
    }

    public static TaskAttribute$DeviceLevel valueOf(String r100) {
        return (TaskAttribute$DeviceLevel) a.a(TaskAttribute$DeviceLevel.class, r100);
    }

    public TaskAttribute$DeviceLevel(String r100, int r101, String r102, int r103) {
        super(r100, r101);
        this.title = r102;
        this.value = r103;
    }
}
