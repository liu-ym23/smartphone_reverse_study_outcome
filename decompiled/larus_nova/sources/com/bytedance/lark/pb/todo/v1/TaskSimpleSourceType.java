package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum TaskSimpleSourceType extends Enum<TaskSimpleSourceType> implements WireEnum {
    private static final /* synthetic */ TaskSimpleSourceType[] $VALUES = null;
    public static final ProtoAdapter<TaskSimpleSourceType> ADAPTER = null;
    public static final TaskSimpleSourceType ALL_SOURCE_TYPE = null;
    public static final TaskSimpleSourceType DOCX_SOURCE_TYPE = null;
    public static final TaskSimpleSourceType MEEGO_SOURCE_TYPE = null;
    public static final TaskSimpleSourceType MESSENGER_SOURCE_TYPE = null;
    public static final TaskSimpleSourceType OPENAPI_SOURCE_TYPE = null;
    public static final TaskSimpleSourceType OTHER_SOURCE_TYPE = null;
    public static final TaskSimpleSourceType UNKNOWN_SOURCE_TYPE = null;
    private final int value;

    static {
        TaskSimpleSourceType r100 = new TaskSimpleSourceType("UNKNOWN_SOURCE_TYPE", 0, 0);
        UNKNOWN_SOURCE_TYPE = r100;
        TaskSimpleSourceType r101 = new TaskSimpleSourceType("ALL_SOURCE_TYPE", 1, 1);
        ALL_SOURCE_TYPE = r101;
        TaskSimpleSourceType r102 = new TaskSimpleSourceType("MESSENGER_SOURCE_TYPE", 2, 2);
        MESSENGER_SOURCE_TYPE = r102;
        TaskSimpleSourceType r103 = new TaskSimpleSourceType("DOCX_SOURCE_TYPE", 3, 3);
        DOCX_SOURCE_TYPE = r103;
        TaskSimpleSourceType r104 = new TaskSimpleSourceType("OPENAPI_SOURCE_TYPE", 4, 4);
        OPENAPI_SOURCE_TYPE = r104;
        TaskSimpleSourceType r105 = new TaskSimpleSourceType("MEEGO_SOURCE_TYPE", 5, 5);
        MEEGO_SOURCE_TYPE = r105;
        TaskSimpleSourceType r110 = new TaskSimpleSourceType("OTHER_SOURCE_TYPE", 6, 255);
        OTHER_SOURCE_TYPE = r110;
        $VALUES = new TaskSimpleSourceType[]{r100, r101, r102, r103, r104, r105, r110};
        ADAPTER = ProtoAdapter.newEnumAdapter(TaskSimpleSourceType.class);
    }

    public static TaskSimpleSourceType[] values() {
        return (TaskSimpleSourceType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static TaskSimpleSourceType fromValue(int r100) {
        if (r100 == 0) goto L30;
        if (r100 == 1) goto L28;
        if (r100 == 2) goto L26;
        if (r100 == 3) goto L24;
        if (r100 == 4) goto L22;
        if (r100 == 5) goto L20;
        if (r100 == 255) goto L18;
        return null;
    L18:
        return OTHER_SOURCE_TYPE;
    L20:
        return MEEGO_SOURCE_TYPE;
    L22:
        return OPENAPI_SOURCE_TYPE;
    L24:
        return DOCX_SOURCE_TYPE;
    L26:
        return MESSENGER_SOURCE_TYPE;
    L28:
        return ALL_SOURCE_TYPE;
    L30:
        return UNKNOWN_SOURCE_TYPE;
    }

    public static TaskSimpleSourceType valueOf(String r100) {
        return (TaskSimpleSourceType) a.a(TaskSimpleSourceType.class, r100);
    }

    private TaskSimpleSourceType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
