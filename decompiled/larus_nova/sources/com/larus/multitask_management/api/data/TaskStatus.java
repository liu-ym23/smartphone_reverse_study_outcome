package com.larus.multitask_management.api.data;

import kl9.e0;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.Serializable;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0087\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/larus/multitask_management/api/data/TaskStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNDEFINED", "PENDING", "RUNNING", "PAUSED", "SUCCESS", "FAILED", "CANCELED", "Companion", "multitask_management_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable(with = e0.class)
public final enum TaskStatus extends Enum<TaskStatus> {
    public static final TaskStatus CANCELED = null;
    public static final a Companion = null;
    public static final TaskStatus FAILED = null;
    public static final TaskStatus PAUSED = null;
    public static final TaskStatus PENDING = null;
    public static final TaskStatus RUNNING = null;
    public static final TaskStatus SUCCESS = null;
    public static final TaskStatus UNDEFINED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TaskStatus[] f359381a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f359382b = null;
    private final int value;

    public static EnumEntries<TaskStatus> getEntries() {
        return f359382b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.multitask_management.api.data.TaskStatus$a] */
    static {
        TaskStatus r100 = new TaskStatus("UNDEFINED", 0, 0);
        UNDEFINED = r100;
        TaskStatus r101 = new TaskStatus("PENDING", 1, 1);
        PENDING = r101;
        TaskStatus r102 = new TaskStatus("RUNNING", 2, 2);
        RUNNING = r102;
        TaskStatus r103 = new TaskStatus("PAUSED", 3, 3);
        PAUSED = r103;
        TaskStatus r104 = new TaskStatus("SUCCESS", 4, 4);
        SUCCESS = r104;
        TaskStatus r105 = new TaskStatus("FAILED", 5, 5);
        FAILED = r105;
        TaskStatus r110 = new TaskStatus("CANCELED", 6, 6);
        CANCELED = r110;
        TaskStatus[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f359381a = r111;
        f359382b = EnumEntriesKt.enumEntries(r111);
        Companion = new a();
    }

    public static TaskStatus[] values() {
        return (TaskStatus[]) f359381a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static TaskStatus valueOf(String r100) {
        return (TaskStatus) r27.a.a(TaskStatus.class, r100);
    }

    public TaskStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
