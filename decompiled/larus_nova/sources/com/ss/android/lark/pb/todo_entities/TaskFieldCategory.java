package com.ss.android.lark.pb.todo_entities;

import com.larus.media.MediaScene;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum TaskFieldCategory extends Enum<TaskFieldCategory> implements WireEnum {
    private static final /* synthetic */ TaskFieldCategory[] $VALUES = null;
    public static final ProtoAdapter<TaskFieldCategory> ADAPTER = null;
    public static final TaskFieldCategory PERSONAL = null;
    public static final TaskFieldCategory SYSTEM = null;
    public static final TaskFieldCategory TASK_LIST = null;
    public static final TaskFieldCategory TEMPLATE = null;
    public static final TaskFieldCategory UNKNOWN_FIELD_CATEGORY = null;
    private final int value;

    static {
        TaskFieldCategory r100 = new TaskFieldCategory("UNKNOWN_FIELD_CATEGORY", 0, 0);
        UNKNOWN_FIELD_CATEGORY = r100;
        TaskFieldCategory r101 = new TaskFieldCategory(MediaScene.SYSTEM, 1, 1);
        SYSTEM = r101;
        TaskFieldCategory r102 = new TaskFieldCategory("TEMPLATE", 2, 2);
        TEMPLATE = r102;
        TaskFieldCategory r103 = new TaskFieldCategory("TASK_LIST", 3, 3);
        TASK_LIST = r103;
        TaskFieldCategory r104 = new TaskFieldCategory("PERSONAL", 4, 4);
        PERSONAL = r104;
        $VALUES = new TaskFieldCategory[]{r100, r101, r102, r103, r104};
        ADAPTER = ProtoAdapter.newEnumAdapter(TaskFieldCategory.class);
    }

    public static TaskFieldCategory[] values() {
        return (TaskFieldCategory[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static TaskFieldCategory fromValue(int r100) {
        if (r100 == 0) goto L22;
        if (r100 == 1) goto L20;
        if (r100 == 2) goto L18;
        if (r100 == 3) goto L16;
        if (r100 == 4) goto L14;
        return null;
    L14:
        return PERSONAL;
    L16:
        return TASK_LIST;
    L18:
        return TEMPLATE;
    L20:
        return SYSTEM;
    L22:
        return UNKNOWN_FIELD_CATEGORY;
    }

    public static TaskFieldCategory valueOf(String r100) {
        return (TaskFieldCategory) a.a(TaskFieldCategory.class, r100);
    }

    private TaskFieldCategory(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
