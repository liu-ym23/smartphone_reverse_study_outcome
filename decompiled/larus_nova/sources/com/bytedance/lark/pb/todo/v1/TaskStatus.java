package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum TaskStatus extends Enum<TaskStatus> implements WireEnum {
    private static final /* synthetic */ TaskStatus[] $VALUES = null;
    public static final ProtoAdapter<TaskStatus> ADAPTER = null;
    public static final TaskStatus BLOCKED = null;
    public static final TaskStatus COMPLETED = null;
    public static final TaskStatus IN_PROGRESS = null;
    public static final TaskStatus NOT_STARTED = null;
    public static final TaskStatus UNKNOWN_TASK_STATUS = null;
    private final int value;

    static {
        TaskStatus r100 = new TaskStatus("UNKNOWN_TASK_STATUS", 0, 0);
        UNKNOWN_TASK_STATUS = r100;
        TaskStatus r101 = new TaskStatus("NOT_STARTED", 1, 1);
        NOT_STARTED = r101;
        TaskStatus r102 = new TaskStatus("IN_PROGRESS", 2, 2);
        IN_PROGRESS = r102;
        TaskStatus r103 = new TaskStatus("BLOCKED", 3, 3);
        BLOCKED = r103;
        TaskStatus r104 = new TaskStatus("COMPLETED", 4, 4);
        COMPLETED = r104;
        $VALUES = new TaskStatus[]{r100, r101, r102, r103, r104};
        ADAPTER = ProtoAdapter.newEnumAdapter(TaskStatus.class);
    }

    public static TaskStatus[] values() {
        return (TaskStatus[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static TaskStatus fromValue(int r100) {
        if (r100 == 0) goto L22;
        if (r100 == 1) goto L20;
        if (r100 == 2) goto L18;
        if (r100 == 3) goto L16;
        if (r100 == 4) goto L14;
        return null;
    L14:
        return COMPLETED;
    L16:
        return BLOCKED;
    L18:
        return IN_PROGRESS;
    L20:
        return NOT_STARTED;
    L22:
        return UNKNOWN_TASK_STATUS;
    }

    public static TaskStatus valueOf(String r100) {
        return (TaskStatus) a.a(TaskStatus.class, r100);
    }

    private TaskStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
