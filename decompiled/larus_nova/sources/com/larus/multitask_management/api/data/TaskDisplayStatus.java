package com.larus.multitask_management.api.data;

import kl9.y;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.Serializable;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/larus/multitask_management/api/data/TaskDisplayStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DISPLAYED", "HIDDEN", "Companion", "multitask_management_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable(with = y.class)
public final enum TaskDisplayStatus extends Enum<TaskDisplayStatus> {
    public static final a Companion = null;
    public static final TaskDisplayStatus DISPLAYED = null;
    public static final TaskDisplayStatus HIDDEN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TaskDisplayStatus[] f359373a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f359374b = null;
    private final int value;

    public static EnumEntries<TaskDisplayStatus> getEntries() {
        return f359374b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.multitask_management.api.data.TaskDisplayStatus$a] */
    static {
        TaskDisplayStatus r100 = new TaskDisplayStatus("DISPLAYED", 0, 0);
        DISPLAYED = r100;
        TaskDisplayStatus r101 = new TaskDisplayStatus("HIDDEN", 1, 1);
        HIDDEN = r101;
        TaskDisplayStatus[] r102 = {r100, r101};
        f359373a = r102;
        f359374b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static TaskDisplayStatus[] values() {
        return (TaskDisplayStatus[]) f359373a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static TaskDisplayStatus valueOf(String r100) {
        return (TaskDisplayStatus) r27.a.a(TaskDisplayStatus.class, r100);
    }

    public TaskDisplayStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
