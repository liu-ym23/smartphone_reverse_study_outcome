package com.larus.multitask_management.api.data;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kl9.d0;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.Serializable;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0087\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/multitask_management/api/data/TaskReplaceStrategy;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", UserProfileEvent.POSITION_NONE, "REPLACE_TASK_WITH_SAME_REFERENCE_ID_IN_PLACE", "REPLACE_TASK_WITH_SAME_TASK_KEY_IN_PLACE", "Companion", "multitask_management_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable(with = d0.class)
public final enum TaskReplaceStrategy extends Enum<TaskReplaceStrategy> {
    public static final a Companion = null;
    public static final TaskReplaceStrategy NONE = null;
    public static final TaskReplaceStrategy REPLACE_TASK_WITH_SAME_REFERENCE_ID_IN_PLACE = null;
    public static final TaskReplaceStrategy REPLACE_TASK_WITH_SAME_TASK_KEY_IN_PLACE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TaskReplaceStrategy[] f359379a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f359380b = null;
    private final int value;

    public static EnumEntries<TaskReplaceStrategy> getEntries() {
        return f359380b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.multitask_management.api.data.TaskReplaceStrategy$a] */
    static {
        TaskReplaceStrategy r100 = new TaskReplaceStrategy(UserProfileEvent.POSITION_NONE, 0, 0);
        NONE = r100;
        TaskReplaceStrategy r101 = new TaskReplaceStrategy("REPLACE_TASK_WITH_SAME_REFERENCE_ID_IN_PLACE", 1, 1);
        REPLACE_TASK_WITH_SAME_REFERENCE_ID_IN_PLACE = r101;
        TaskReplaceStrategy r102 = new TaskReplaceStrategy("REPLACE_TASK_WITH_SAME_TASK_KEY_IN_PLACE", 2, 2);
        REPLACE_TASK_WITH_SAME_TASK_KEY_IN_PLACE = r102;
        TaskReplaceStrategy[] r103 = {r100, r101, r102};
        f359379a = r103;
        f359380b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static TaskReplaceStrategy[] values() {
        return (TaskReplaceStrategy[]) f359379a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static TaskReplaceStrategy valueOf(String r100) {
        return (TaskReplaceStrategy) r27.a.a(TaskReplaceStrategy.class, r100);
    }

    public TaskReplaceStrategy(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
