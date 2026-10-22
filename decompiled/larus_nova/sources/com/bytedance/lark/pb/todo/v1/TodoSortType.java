package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum TodoSortType extends Enum<TodoSortType> implements WireEnum {
    private static final /* synthetic */ TodoSortType[] $VALUES = null;
    public static final ProtoAdapter<TodoSortType> ADAPTER = null;
    public static final TodoSortType CREATE_TIME = null;
    public static final TodoSortType DUE_TIME = null;
    public static final TodoSortType UNKNOWN = null;
    private final int value;

    static {
        TodoSortType r100 = new TodoSortType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        TodoSortType r101 = new TodoSortType("CREATE_TIME", 1, 1);
        CREATE_TIME = r101;
        TodoSortType r102 = new TodoSortType("DUE_TIME", 2, 2);
        DUE_TIME = r102;
        $VALUES = new TodoSortType[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(TodoSortType.class);
    }

    public static TodoSortType[] values() {
        return (TodoSortType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static TodoSortType fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return DUE_TIME;
    L12:
        return CREATE_TIME;
    L14:
        return UNKNOWN;
    }

    public static TodoSortType valueOf(String r100) {
        return (TodoSortType) a.a(TodoSortType.class, r100);
    }

    private TodoSortType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
