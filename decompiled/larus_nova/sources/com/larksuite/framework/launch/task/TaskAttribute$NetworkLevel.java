package com.larksuite.framework.launch.task;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larksuite/framework/launch/task/TaskAttribute$NetworkLevel;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "EXCELLENT", "EVALUATING", "WEAK", "NET_UNAVAILABLE", "SERVICE_UNAVAILABLE", "launch-scheduler_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TaskAttribute$NetworkLevel extends Enum<TaskAttribute$NetworkLevel> {
    public static final TaskAttribute$NetworkLevel EVALUATING = null;
    public static final TaskAttribute$NetworkLevel EXCELLENT = null;
    public static final TaskAttribute$NetworkLevel NET_UNAVAILABLE = null;
    public static final TaskAttribute$NetworkLevel SERVICE_UNAVAILABLE = null;
    public static final TaskAttribute$NetworkLevel WEAK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TaskAttribute$NetworkLevel[] f285679a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f285680b = null;
    private final int value;

    public static EnumEntries<TaskAttribute$NetworkLevel> getEntries() {
        return f285680b;
    }

    static {
        TaskAttribute$NetworkLevel r100 = new TaskAttribute$NetworkLevel("EXCELLENT", 0, 1);
        EXCELLENT = r100;
        TaskAttribute$NetworkLevel r101 = new TaskAttribute$NetworkLevel("EVALUATING", 1, 2);
        EVALUATING = r101;
        TaskAttribute$NetworkLevel r102 = new TaskAttribute$NetworkLevel("WEAK", 2, 3);
        WEAK = r102;
        TaskAttribute$NetworkLevel r103 = new TaskAttribute$NetworkLevel("NET_UNAVAILABLE", 3, 4);
        NET_UNAVAILABLE = r103;
        TaskAttribute$NetworkLevel r104 = new TaskAttribute$NetworkLevel("SERVICE_UNAVAILABLE", 4, 5);
        SERVICE_UNAVAILABLE = r104;
        TaskAttribute$NetworkLevel[] r110 = {r100, r101, r102, r103, r104};
        f285679a = r110;
        f285680b = EnumEntriesKt.enumEntries(r110);
    }

    public static TaskAttribute$NetworkLevel[] values() {
        return (TaskAttribute$NetworkLevel[]) f285679a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static TaskAttribute$NetworkLevel valueOf(String r100) {
        return (TaskAttribute$NetworkLevel) a.a(TaskAttribute$NetworkLevel.class, r100);
    }

    public TaskAttribute$NetworkLevel(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
