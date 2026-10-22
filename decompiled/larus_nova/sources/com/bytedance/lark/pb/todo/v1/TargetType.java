package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum TargetType extends Enum<TargetType> implements WireEnum {
    private static final /* synthetic */ TargetType[] $VALUES = null;
    public static final ProtoAdapter<TargetType> ADAPTER = null;
    public static final TargetType TASK = null;
    public static final TargetType TASK_LIST = null;
    private final int value;

    static {
        TargetType r100 = new TargetType("TASK_LIST", 0, 0);
        TASK_LIST = r100;
        TargetType r101 = new TargetType("TASK", 1, 1);
        TASK = r101;
        $VALUES = new TargetType[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(TargetType.class);
    }

    public static TargetType[] values() {
        return (TargetType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static TargetType fromValue(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return TASK;
    L10:
        return TASK_LIST;
    }

    public static TargetType valueOf(String r100) {
        return (TargetType) a.a(TargetType.class, r100);
    }

    private TargetType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
