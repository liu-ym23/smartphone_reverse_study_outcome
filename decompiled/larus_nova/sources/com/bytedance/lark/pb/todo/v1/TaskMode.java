package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum TaskMode extends Enum<TaskMode> implements WireEnum {
    private static final /* synthetic */ TaskMode[] $VALUES = null;
    public static final ProtoAdapter<TaskMode> ADAPTER = null;
    public static final TaskMode TASK_COMPLETE = null;
    public static final TaskMode UNKNOWN_MODE = null;
    public static final TaskMode USER_COMPLETE = null;
    private final int value;

    static {
        TaskMode r100 = new TaskMode("UNKNOWN_MODE", 0, 0);
        UNKNOWN_MODE = r100;
        TaskMode r101 = new TaskMode("USER_COMPLETE", 1, 1);
        USER_COMPLETE = r101;
        TaskMode r102 = new TaskMode("TASK_COMPLETE", 2, 2);
        TASK_COMPLETE = r102;
        $VALUES = new TaskMode[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(TaskMode.class);
    }

    public static TaskMode[] values() {
        return (TaskMode[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static TaskMode fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return TASK_COMPLETE;
    L12:
        return USER_COMPLETE;
    L14:
        return UNKNOWN_MODE;
    }

    public static TaskMode valueOf(String r100) {
        return (TaskMode) a.a(TaskMode.class, r100);
    }

    private TaskMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
