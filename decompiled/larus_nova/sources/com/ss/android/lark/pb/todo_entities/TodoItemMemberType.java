package com.ss.android.lark.pb.todo_entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum TodoItemMemberType extends Enum<TodoItemMemberType> implements WireEnum {
    private static final /* synthetic */ TodoItemMemberType[] $VALUES = null;
    public static final ProtoAdapter<TodoItemMemberType> ADAPTER = null;
    public static final TodoItemMemberType APP = null;
    public static final TodoItemMemberType DOCS = null;
    public static final TodoItemMemberType GROUP = null;
    public static final TodoItemMemberType MEEGO = null;
    public static final TodoItemMemberType UNKNOWN_TODO_ITEM_MEMBER_TYPE = null;
    public static final TodoItemMemberType USER = null;
    private final int value;

    static {
        TodoItemMemberType r100 = new TodoItemMemberType("UNKNOWN_TODO_ITEM_MEMBER_TYPE", 0, 0);
        UNKNOWN_TODO_ITEM_MEMBER_TYPE = r100;
        TodoItemMemberType r101 = new TodoItemMemberType(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 1, 1);
        USER = r101;
        TodoItemMemberType r102 = new TodoItemMemberType("GROUP", 2, 2);
        GROUP = r102;
        TodoItemMemberType r103 = new TodoItemMemberType("APP", 3, 3);
        APP = r103;
        TodoItemMemberType r104 = new TodoItemMemberType("DOCS", 4, 4);
        DOCS = r104;
        TodoItemMemberType r105 = new TodoItemMemberType("MEEGO", 5, 6);
        MEEGO = r105;
        $VALUES = new TodoItemMemberType[]{r100, r101, r102, r103, r104, r105};
        ADAPTER = ProtoAdapter.newEnumAdapter(TodoItemMemberType.class);
    }

    public static TodoItemMemberType[] values() {
        return (TodoItemMemberType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static TodoItemMemberType fromValue(int r100) {
        if (r100 == 0) goto L26;
        if (r100 == 1) goto L24;
        if (r100 == 2) goto L22;
        if (r100 == 3) goto L20;
        if (r100 == 4) goto L18;
        if (r100 == 6) goto L16;
        return null;
    L16:
        return MEEGO;
    L18:
        return DOCS;
    L20:
        return APP;
    L22:
        return GROUP;
    L24:
        return USER;
    L26:
        return UNKNOWN_TODO_ITEM_MEMBER_TYPE;
    }

    public static TodoItemMemberType valueOf(String r100) {
        return (TodoItemMemberType) a.a(TodoItemMemberType.class, r100);
    }

    private TodoItemMemberType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
