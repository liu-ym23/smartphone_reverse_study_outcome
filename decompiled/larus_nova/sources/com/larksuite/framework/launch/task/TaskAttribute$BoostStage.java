package com.larksuite.framework.launch.task;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larksuite/framework/launch/task/TaskAttribute$BoostStage;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "FIRST_DATA_LOADED", "FIRST_FRAME_SHOWED", "FIRST_CONTENT_SHOWED_LOGIN", "FIRST_CONTENT_SHOWED_UN_LOGIN", "FIRST_CONTENT_SHOWED_BACKGROUND_LOGIN", "FIRST_CONTENT_SHOWED_BACKGROUND_UN_LOGIN", "launch-scheduler_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TaskAttribute$BoostStage extends Enum<TaskAttribute$BoostStage> {
    public static final TaskAttribute$BoostStage FIRST_CONTENT_SHOWED_BACKGROUND_LOGIN = null;
    public static final TaskAttribute$BoostStage FIRST_CONTENT_SHOWED_BACKGROUND_UN_LOGIN = null;
    public static final TaskAttribute$BoostStage FIRST_CONTENT_SHOWED_LOGIN = null;
    public static final TaskAttribute$BoostStage FIRST_CONTENT_SHOWED_UN_LOGIN = null;
    public static final TaskAttribute$BoostStage FIRST_DATA_LOADED = null;
    public static final TaskAttribute$BoostStage FIRST_FRAME_SHOWED = null;
    public static final TaskAttribute$BoostStage UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TaskAttribute$BoostStage[] f285675a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f285676b = null;
    private final int value;

    public static EnumEntries<TaskAttribute$BoostStage> getEntries() {
        return f285676b;
    }

    static {
        TaskAttribute$BoostStage r100 = new TaskAttribute$BoostStage("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        TaskAttribute$BoostStage r101 = new TaskAttribute$BoostStage("FIRST_DATA_LOADED", 1, 1);
        FIRST_DATA_LOADED = r101;
        TaskAttribute$BoostStage r102 = new TaskAttribute$BoostStage("FIRST_FRAME_SHOWED", 2, 2);
        FIRST_FRAME_SHOWED = r102;
        TaskAttribute$BoostStage r103 = new TaskAttribute$BoostStage("FIRST_CONTENT_SHOWED_LOGIN", 3, 3);
        FIRST_CONTENT_SHOWED_LOGIN = r103;
        TaskAttribute$BoostStage r104 = new TaskAttribute$BoostStage("FIRST_CONTENT_SHOWED_UN_LOGIN", 4, 4);
        FIRST_CONTENT_SHOWED_UN_LOGIN = r104;
        TaskAttribute$BoostStage r105 = new TaskAttribute$BoostStage("FIRST_CONTENT_SHOWED_BACKGROUND_LOGIN", 5, 5);
        FIRST_CONTENT_SHOWED_BACKGROUND_LOGIN = r105;
        TaskAttribute$BoostStage r110 = new TaskAttribute$BoostStage("FIRST_CONTENT_SHOWED_BACKGROUND_UN_LOGIN", 6, 6);
        FIRST_CONTENT_SHOWED_BACKGROUND_UN_LOGIN = r110;
        TaskAttribute$BoostStage[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f285675a = r111;
        f285676b = EnumEntriesKt.enumEntries(r111);
    }

    public static TaskAttribute$BoostStage[] values() {
        return (TaskAttribute$BoostStage[]) f285675a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static TaskAttribute$BoostStage valueOf(String r100) {
        return (TaskAttribute$BoostStage) a.a(TaskAttribute$BoostStage.class, r100);
    }

    public TaskAttribute$BoostStage(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
