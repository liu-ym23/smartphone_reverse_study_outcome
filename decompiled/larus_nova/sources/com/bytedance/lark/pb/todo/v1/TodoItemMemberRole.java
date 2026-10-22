package com.bytedance.lark.pb.todo.v1;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum TodoItemMemberRole extends Enum<TodoItemMemberRole> implements WireEnum {
    private static final /* synthetic */ TodoItemMemberRole[] $VALUES = null;
    public static final ProtoAdapter<TodoItemMemberRole> ADAPTER = null;
    public static final TodoItemMemberRole INHERIT = null;
    public static final TodoItemMemberRole NONE = null;
    public static final TodoItemMemberRole OWNER = null;
    public static final TodoItemMemberRole READER = null;
    public static final TodoItemMemberRole WRITER = null;
    private final int value;

    static {
        TodoItemMemberRole r100 = new TodoItemMemberRole(UserProfileEvent.POSITION_NONE, 0, 0);
        NONE = r100;
        TodoItemMemberRole r101 = new TodoItemMemberRole("OWNER", 1, 1);
        OWNER = r101;
        TodoItemMemberRole r102 = new TodoItemMemberRole("WRITER", 2, 2);
        WRITER = r102;
        TodoItemMemberRole r103 = new TodoItemMemberRole("READER", 3, 3);
        READER = r103;
        TodoItemMemberRole r104 = new TodoItemMemberRole("INHERIT", 4, 100);
        INHERIT = r104;
        $VALUES = new TodoItemMemberRole[]{r100, r101, r102, r103, r104};
        ADAPTER = ProtoAdapter.newEnumAdapter(TodoItemMemberRole.class);
    }

    public static TodoItemMemberRole[] values() {
        return (TodoItemMemberRole[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static TodoItemMemberRole fromValue(int r100) {
        if (r100 == 0) goto L22;
        if (r100 == 1) goto L20;
        if (r100 == 2) goto L18;
        if (r100 == 3) goto L16;
        if (r100 == 100) goto L14;
        return null;
    L14:
        return INHERIT;
    L16:
        return READER;
    L18:
        return WRITER;
    L20:
        return OWNER;
    L22:
        return NONE;
    }

    public static TodoItemMemberRole valueOf(String r100) {
        return (TodoItemMemberRole) a.a(TodoItemMemberRole.class, r100);
    }

    private TodoItemMemberRole(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
