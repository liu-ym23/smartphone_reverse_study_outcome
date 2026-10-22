package com.larus.multitask_management.api.data;

import kl9.a0;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.Serializable;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0087\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/larus/multitask_management/api/data/TaskPriority;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNDEFINED", "OTHER_TASK", "RUNNING_OMNI", "MEDIA_TASK", "CALLING_OMNI", "Companion", "multitask_management_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable(with = a0.class)
public final enum TaskPriority extends Enum<TaskPriority> {
    public static final TaskPriority CALLING_OMNI = null;
    public static final a Companion = null;
    public static final TaskPriority MEDIA_TASK = null;
    public static final TaskPriority OTHER_TASK = null;
    public static final TaskPriority RUNNING_OMNI = null;
    public static final TaskPriority UNDEFINED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TaskPriority[] f359377a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f359378b = null;
    private final int value;

    public static EnumEntries<TaskPriority> getEntries() {
        return f359378b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.multitask_management.api.data.TaskPriority$a] */
    static {
        TaskPriority r100 = new TaskPriority("UNDEFINED", 0, 0);
        UNDEFINED = r100;
        TaskPriority r101 = new TaskPriority("OTHER_TASK", 1, 1000);
        OTHER_TASK = r101;
        TaskPriority r102 = new TaskPriority("RUNNING_OMNI", 2, 1500);
        RUNNING_OMNI = r102;
        TaskPriority r103 = new TaskPriority("MEDIA_TASK", 3, 2000);
        MEDIA_TASK = r103;
        TaskPriority r104 = new TaskPriority("CALLING_OMNI", 4, 5000);
        CALLING_OMNI = r104;
        TaskPriority[] r105 = {r100, r101, r102, r103, r104};
        f359377a = r105;
        f359378b = EnumEntriesKt.enumEntries(r105);
        Companion = new a();
    }

    public static TaskPriority[] values() {
        return (TaskPriority[]) f359377a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static TaskPriority valueOf(String r100) {
        return (TaskPriority) r27.a.a(TaskPriority.class, r100);
    }

    public TaskPriority(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
