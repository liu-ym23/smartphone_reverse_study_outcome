package com.bytedance.lark.pb.basic.v1;

import com.bytedance.lark.pb.todo.v1.TodoUser;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class TodoOperationContent extends com.squareup.wire.Message<TodoOperationContent, Builder> {
    public static final ProtoAdapter<TodoOperationContent> ADAPTER = null;
    public static final CompleteType DEFAULT_COMPLETE_TYPE = null;
    public static final MsgStatus DEFAULT_MSG_STATUS = null;
    public static final Type DEFAULT_OPERATION_TYPE = null;
    private static final long serialVersionUID = 0;
    public final CompleteType complete_type;
    public final TodoDailyRemind daily_remind;
    public final MsgStatus msg_status;
    public final Type operation_type;
    public final TodoUser operator;
    public final List<TodoUser> target_users;
    public final TodoCommentDetail todo_comment_detail;
    public final TodoDetail todo_detail;

    public static final class Builder extends com.squareup.wire.Message.Builder<TodoOperationContent, Builder> {
        public CompleteType complete_type;
        public TodoDailyRemind daily_remind;
        public MsgStatus msg_status;
        public Type operation_type;
        public TodoUser operator;
        public List<TodoUser> target_users;
        public TodoCommentDetail todo_comment_detail;
        public TodoDetail todo_detail;

        @Override // com.squareup.wire.Message.Builder
        public TodoOperationContent build() {
            return new TodoOperationContent(this.operation_type, this.operator, this.todo_detail, this.msg_status, this.todo_comment_detail, this.daily_remind, this.target_users, this.complete_type, super.buildUnknownFields());
        }

        public Builder() {
            this.target_users = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder complete_type(CompleteType r100) {
            this.complete_type = r100;
            return this;
        }

        public Builder daily_remind(TodoDailyRemind r100) {
            this.daily_remind = r100;
            return this;
        }

        public Builder msg_status(MsgStatus r100) {
            this.msg_status = r100;
            return this;
        }

        public Builder operation_type(Type r100) {
            this.operation_type = r100;
            return this;
        }

        public Builder operator(TodoUser r100) {
            this.operator = r100;
            return this;
        }

        public Builder target_users(List<TodoUser> r100) {
            Internal.checkElementsNotNull(r100);
            this.target_users = r100;
            return this;
        }

        public Builder todo_comment_detail(TodoCommentDetail r100) {
            this.todo_comment_detail = r100;
            return this;
        }

        public Builder todo_detail(TodoDetail r100) {
            this.todo_detail = r100;
            return this;
        }
    }

    public static final enum CompleteType extends Enum<CompleteType> implements WireEnum {
        private static final /* synthetic */ CompleteType[] $VALUES = null;
        public static final ProtoAdapter<CompleteType> ADAPTER = null;
        public static final CompleteType COMPLETE_WHOLE_TODO = null;
        public static final CompleteType COMPLETE_WHOLE_TODO_AFTER_COMPLETE_ASSIGNEES = null;
        public static final CompleteType COMPLETE_WHOLE_TODO_AFTER_COMPLETE_ASSIGNEE_YOURSELF = null;
        public static final CompleteType COMPLETE_WHOLE_TODO_AFTER_REMOVE_ASSIGNEES = null;
        public static final CompleteType COMPLETE_WHOLE_TODO_AFTER_REMOVE_ASSIGNEE_SELF = null;
        public static final CompleteType COMPLETE_WHOLE_TODO_AFTER_REMOVE_ASSIGNEE_YOURSELF = null;
        public static final CompleteType RESTORE_WHOLE_TODO = null;
        public static final CompleteType RESTORE_WHOLE_TODO_AFTER_ADD_ASSIGNEES = null;
        public static final CompleteType RESTORE_WHOLE_TODO_AFTER_ADD_ASSIGNEES_YOURSELF = null;
        public static final CompleteType RESTORE_WHOLE_TODO_AFTER_ADD_ASSIGNEE_SELF = null;
        public static final CompleteType RESTORE_WHOLE_TODO_AFTER_RESTORE_ASSIGNEE = null;
        public static final CompleteType RESTORE_WHOLE_TODO_AFTER_RESTORE_ASSIGNEE_YOURSELF = null;
        public static final CompleteType RESTORE_WHOLE_TODO_AFTER_RESTORE_SELF = null;
        public static final CompleteType UNKNOWN_COMPLETE_TYPE = null;
        private final int value;

        static {
            CompleteType r100 = new CompleteType("UNKNOWN_COMPLETE_TYPE", 0, 0);
            UNKNOWN_COMPLETE_TYPE = r100;
            CompleteType r101 = new CompleteType("COMPLETE_WHOLE_TODO", 1, 1);
            COMPLETE_WHOLE_TODO = r101;
            CompleteType r102 = new CompleteType("COMPLETE_WHOLE_TODO_AFTER_REMOVE_ASSIGNEE_SELF", 2, 2);
            COMPLETE_WHOLE_TODO_AFTER_REMOVE_ASSIGNEE_SELF = r102;
            CompleteType r103 = new CompleteType("COMPLETE_WHOLE_TODO_AFTER_REMOVE_ASSIGNEES", 3, 3);
            COMPLETE_WHOLE_TODO_AFTER_REMOVE_ASSIGNEES = r103;
            CompleteType r104 = new CompleteType("COMPLETE_WHOLE_TODO_AFTER_REMOVE_ASSIGNEE_YOURSELF", 4, 4);
            COMPLETE_WHOLE_TODO_AFTER_REMOVE_ASSIGNEE_YOURSELF = r104;
            CompleteType r105 = new CompleteType("COMPLETE_WHOLE_TODO_AFTER_COMPLETE_ASSIGNEES", 5, 5);
            COMPLETE_WHOLE_TODO_AFTER_COMPLETE_ASSIGNEES = r105;
            CompleteType r110 = new CompleteType("COMPLETE_WHOLE_TODO_AFTER_COMPLETE_ASSIGNEE_YOURSELF", 6, 6);
            COMPLETE_WHOLE_TODO_AFTER_COMPLETE_ASSIGNEE_YOURSELF = r110;
            CompleteType r111 = new CompleteType("RESTORE_WHOLE_TODO", 7, 21);
            RESTORE_WHOLE_TODO = r111;
            CompleteType r112 = new CompleteType("RESTORE_WHOLE_TODO_AFTER_ADD_ASSIGNEE_SELF", 8, 22);
            RESTORE_WHOLE_TODO_AFTER_ADD_ASSIGNEE_SELF = r112;
            CompleteType r113 = new CompleteType("RESTORE_WHOLE_TODO_AFTER_ADD_ASSIGNEES", 9, 23);
            RESTORE_WHOLE_TODO_AFTER_ADD_ASSIGNEES = r113;
            CompleteType r114 = new CompleteType("RESTORE_WHOLE_TODO_AFTER_ADD_ASSIGNEES_YOURSELF", 10, 24);
            RESTORE_WHOLE_TODO_AFTER_ADD_ASSIGNEES_YOURSELF = r114;
            CompleteType r106 = new CompleteType("RESTORE_WHOLE_TODO_AFTER_RESTORE_SELF", 11, 25);
            RESTORE_WHOLE_TODO_AFTER_RESTORE_SELF = r106;
            CompleteType r107 = new CompleteType("RESTORE_WHOLE_TODO_AFTER_RESTORE_ASSIGNEE", 12, 26);
            RESTORE_WHOLE_TODO_AFTER_RESTORE_ASSIGNEE = r107;
            CompleteType r108 = new CompleteType("RESTORE_WHOLE_TODO_AFTER_RESTORE_ASSIGNEE_YOURSELF", 13, 27);
            RESTORE_WHOLE_TODO_AFTER_RESTORE_ASSIGNEE_YOURSELF = r108;
            $VALUES = new CompleteType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108};
            ADAPTER = ProtoAdapter.newEnumAdapter(CompleteType.class);
        }

        public static CompleteType[] values() {
            return (CompleteType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static CompleteType fromValue(int r100) {
            switch(r100) {
                case 0: goto L33;
                case 1: goto L31;
                case 2: goto L29;
                case 3: goto L27;
                case 4: goto L25;
                case 5: goto L23;
                case 6: goto L21;
                default: goto L3;
            };
        L3:
            switch(r100) {
                case 21: goto L19;
                case 22: goto L17;
                case 23: goto L15;
                case 24: goto L13;
                case 25: goto L11;
                case 26: goto L9;
                case 27: goto L7;
                default: goto L4;
            };
        L4:
            return null;
        L7:
            return RESTORE_WHOLE_TODO_AFTER_RESTORE_ASSIGNEE_YOURSELF;
        L9:
            return RESTORE_WHOLE_TODO_AFTER_RESTORE_ASSIGNEE;
        L11:
            return RESTORE_WHOLE_TODO_AFTER_RESTORE_SELF;
        L13:
            return RESTORE_WHOLE_TODO_AFTER_ADD_ASSIGNEES_YOURSELF;
        L15:
            return RESTORE_WHOLE_TODO_AFTER_ADD_ASSIGNEES;
        L17:
            return RESTORE_WHOLE_TODO_AFTER_ADD_ASSIGNEE_SELF;
        L19:
            return RESTORE_WHOLE_TODO;
        L21:
            return COMPLETE_WHOLE_TODO_AFTER_COMPLETE_ASSIGNEE_YOURSELF;
        L23:
            return COMPLETE_WHOLE_TODO_AFTER_COMPLETE_ASSIGNEES;
        L25:
            return COMPLETE_WHOLE_TODO_AFTER_REMOVE_ASSIGNEE_YOURSELF;
        L27:
            return COMPLETE_WHOLE_TODO_AFTER_REMOVE_ASSIGNEES;
        L29:
            return COMPLETE_WHOLE_TODO_AFTER_REMOVE_ASSIGNEE_SELF;
        L31:
            return COMPLETE_WHOLE_TODO;
        L33:
            return UNKNOWN_COMPLETE_TYPE;
        }

        public static CompleteType valueOf(String r100) {
            return (CompleteType) a.a(CompleteType.class, r100);
        }

        private CompleteType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum MsgStatus extends Enum<MsgStatus> implements WireEnum {
        private static final /* synthetic */ MsgStatus[] $VALUES = null;
        public static final MsgStatus ACTIVE = null;
        public static final ProtoAdapter<MsgStatus> ADAPTER = null;
        public static final MsgStatus DELETED = null;
        private final int value;

        static {
            MsgStatus r100 = new MsgStatus("ACTIVE", 0, 0);
            ACTIVE = r100;
            MsgStatus r101 = new MsgStatus("DELETED", 1, 1);
            DELETED = r101;
            $VALUES = new MsgStatus[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(MsgStatus.class);
        }

        public static MsgStatus[] values() {
            return (MsgStatus[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static MsgStatus fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return DELETED;
        L10:
            return ACTIVE;
        }

        public static MsgStatus valueOf(String r100) {
            return (MsgStatus) a.a(MsgStatus.class, r100);
        }

        private MsgStatus(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_TodoOperationContent extends ProtoAdapter<TodoOperationContent> {
        public ProtoAdapter_TodoOperationContent() {
            super(FieldEncoding.LENGTH_DELIMITED, TodoOperationContent.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TodoOperationContent decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.operation_type = Type.UNKNOWN;
            r101.msg_status = MsgStatus.ACTIVE;
            r101.complete_type = CompleteType.UNKNOWN_COMPLETE_TYPE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            switch(r103) {
                case 1: goto L30;
                case 2: goto L19;
                case 3: goto L18;
                case 4: goto L26;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L11;
                case 8: goto L28;
                default: goto L6;
            };
        L26:
            r101.msg_status = MsgStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L28:
            r101.complete_type = CompleteType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L30:
            r101.operation_type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            r101.target_users.add(TodoUser.ADAPTER.decode(r100));
            goto L3
        L12:
            r101.daily_remind = TodoDailyRemind.ADAPTER.decode(r100);
            goto L3
        L13:
            r101.todo_comment_detail = TodoCommentDetail.ADAPTER.decode(r100);
            goto L3
        L18:
            r101.todo_detail = TodoDetail.ADAPTER.decode(r100);
            goto L3
        L19:
            r101.operator = TodoUser.ADAPTER.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TodoOperationContent r100) {
            Type r101 = r100.operation_type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = Type.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            TodoUser r104 = r100.operator;
            if (r104 == null) goto L9;
            int r105 = TodoUser.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            TodoDetail r107 = r100.todo_detail;
            if (r107 == null) goto L13;
            int r108 = TodoDetail.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            MsgStatus r110 = r100.msg_status;
            if (r110 == null) goto L17;
            int r111 = MsgStatus.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            TodoCommentDetail r113 = r100.todo_comment_detail;
            if (r113 == null) goto L21;
            int r114 = TodoCommentDetail.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            TodoDailyRemind r116 = r100.daily_remind;
            if (r116 == null) goto L25;
            int r117 = TodoDailyRemind.ADAPTER.encodedSizeWithTag(6, r116);
        L26:
            int r118 = (r115 + r117) + TodoUser.ADAPTER.asRepeated().encodedSizeWithTag(7, r100.target_users);
            CompleteType r119 = r100.complete_type;
            if (r119 == null) goto L30;
            r102 = CompleteType.ADAPTER.encodedSizeWithTag(8, r119);
        L30:
            return (r118 + r102) + r100.unknownFields().size();
        L25:
            r117 = 0;
            goto L26
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TodoOperationContent decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TodoOperationContent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TodoOperationContent r101) throws IOException {
            Type r102 = r101.operation_type;
            if (r102 == null) goto L5;
            Type.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            TodoUser r103 = r101.operator;
            if (r103 == null) goto L8;
            TodoUser.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            TodoDetail r104 = r101.todo_detail;
            if (r104 == null) goto L11;
            TodoDetail.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            MsgStatus r105 = r101.msg_status;
            if (r105 == null) goto L14;
            MsgStatus.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            TodoCommentDetail r106 = r101.todo_comment_detail;
            if (r106 == null) goto L17;
            TodoCommentDetail.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            TodoDailyRemind r107 = r101.daily_remind;
            if (r107 == null) goto L20;
            TodoDailyRemind.ADAPTER.encodeWithTag(r100, 6, r107);
        L20:
            TodoUser.ADAPTER.asRepeated().encodeWithTag(r100, 7, r101.target_users);
            CompleteType r108 = r101.complete_type;
            if (r108 == null) goto L23;
            CompleteType.ADAPTER.encodeWithTag(r100, 8, r108);
        L23:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TodoOperationContent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type ASSIGN = null;
        public static final Type ASSIGN_OWNER = null;
        public static final Type CANCEL = null;
        public static final Type COMPLETE = null;
        public static final Type COMPLETE_ASSIGNEE = null;
        public static final Type COMPLETE_SELF = null;
        public static final Type CREATE = null;
        public static final Type CREATE_COMMENT = null;
        public static final Type DAILY_REMIND = null;
        public static final Type DELETE = null;
        public static final Type FOLLOW = null;
        public static final Type INCOMPLETE = null;
        public static final Type REACT_COMMENT = null;
        public static final Type REPLY_COMMENT = null;
        public static final Type RESTORE_ASSIGNEE = null;
        public static final Type RESTORE_SELF = null;
        public static final Type SHARE = null;
        public static final Type UNFOLLOW = null;
        public static final Type UNKNOWN = null;
        public static final Type UPDATE = null;
        public final Boolean deprecated;
        private final int value;

        static {
            Type r100 = new Type("UNKNOWN", 0, 0, null);
            UNKNOWN = r100;
            Type r101 = new Type("UPDATE", 1, 1, null);
            UPDATE = r101;
            Type r102 = new Type("ASSIGN", 2, 2, null);
            ASSIGN = r102;
            Type r103 = new Type("COMPLETE", 3, 3, null);
            COMPLETE = r103;
            Type r104 = new Type("CANCEL", 4, 4, null);
            CANCEL = r104;
            Type r110 = new Type("DELETE", 5, 5, null);
            DELETE = r110;
            Type r111 = new Type("CREATE", 6, 6, null);
            CREATE = r111;
            Type r112 = new Type("INCOMPLETE", 7, 7, null);
            INCOMPLETE = r112;
            Type r113 = new Type("SHARE", 8, 8, null);
            SHARE = r113;
            Boolean r114 = Boolean.TRUE;
            Type r115 = new Type("CREATE_COMMENT", 9, 9, r114);
            CREATE_COMMENT = r115;
            Type r105 = new Type("REPLY_COMMENT", 10, 10, r114);
            REPLY_COMMENT = r105;
            Type r106 = new Type("DAILY_REMIND", 11, 11, null);
            DAILY_REMIND = r106;
            Type r107 = new Type("FOLLOW", 12, 12, null);
            FOLLOW = r107;
            Type r108 = new Type("UNFOLLOW", 13, 13, null);
            UNFOLLOW = r108;
            Type r109 = new Type("REACT_COMMENT", 14, 14, r114);
            REACT_COMMENT = r109;
            Type r116 = new Type("COMPLETE_ASSIGNEE", 15, 15, null);
            COMPLETE_ASSIGNEE = r116;
            Type r117 = new Type("COMPLETE_SELF", 16, 16, null);
            COMPLETE_SELF = r117;
            Type r118 = new Type("RESTORE_ASSIGNEE", 17, 17, null);
            RESTORE_ASSIGNEE = r118;
            Type r119 = new Type("RESTORE_SELF", 18, 18, null);
            RESTORE_SELF = r119;
            Type r120 = new Type("ASSIGN_OWNER", 19, 19, null);
            ASSIGN_OWNER = r120;
            $VALUES = new Type[]{r100, r101, r102, r103, r104, r110, r111, r112, r113, r115, r105, r106, r107, r108, r109, r116, r117, r118, r119, r120};
            ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Type fromValue(int r100) {
            switch(r100) {
                case 0: goto L44;
                case 1: goto L42;
                case 2: goto L40;
                case 3: goto L38;
                case 4: goto L36;
                case 5: goto L34;
                case 6: goto L32;
                case 7: goto L30;
                case 8: goto L28;
                case 9: goto L26;
                case 10: goto L24;
                case 11: goto L22;
                case 12: goto L20;
                case 13: goto L18;
                case 14: goto L16;
                case 15: goto L14;
                case 16: goto L12;
                case 17: goto L10;
                case 18: goto L8;
                case 19: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return ASSIGN_OWNER;
        L8:
            return RESTORE_SELF;
        L10:
            return RESTORE_ASSIGNEE;
        L12:
            return COMPLETE_SELF;
        L14:
            return COMPLETE_ASSIGNEE;
        L16:
            return REACT_COMMENT;
        L18:
            return UNFOLLOW;
        L20:
            return FOLLOW;
        L22:
            return DAILY_REMIND;
        L24:
            return REPLY_COMMENT;
        L26:
            return CREATE_COMMENT;
        L28:
            return SHARE;
        L30:
            return INCOMPLETE;
        L32:
            return CREATE;
        L34:
            return DELETE;
        L36:
            return CANCEL;
        L38:
            return COMPLETE;
        L40:
            return ASSIGN;
        L42:
            return UPDATE;
        L44:
            return UNKNOWN;
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        private Type(String r100, int r101, int r102, Boolean r103) {
            super(r100, r101);
            this.value = r102;
            this.deprecated = r103;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TodoOperationContent();
        DEFAULT_OPERATION_TYPE = Type.UNKNOWN;
        DEFAULT_MSG_STATUS = MsgStatus.ACTIVE;
        DEFAULT_COMPLETE_TYPE = CompleteType.UNKNOWN_COMPLETE_TYPE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.operation_type = this.operation_type;
        r100.operator = this.operator;
        r100.todo_detail = this.todo_detail;
        r100.msg_status = this.msg_status;
        r100.todo_comment_detail = this.todo_comment_detail;
        r100.daily_remind = this.daily_remind;
        r100.target_users = Internal.copyOf("target_users", this.target_users);
        r100.complete_type = this.complete_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TodoOperationContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public TodoOperationContent(Type r110, TodoUser r111, TodoDetail r112, MsgStatus r113, TodoCommentDetail r114, TodoDailyRemind r115, List<TodoUser> r116, CompleteType r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
    }

    public TodoOperationContent(Type r100, TodoUser r101, TodoDetail r102, MsgStatus r103, TodoCommentDetail r104, TodoDailyRemind r105, List<TodoUser> r106, CompleteType r107, ByteString r110) {
        super(ADAPTER, r110);
        this.operation_type = r100;
        this.operator = r101;
        this.todo_detail = r102;
        this.msg_status = r103;
        this.todo_comment_detail = r104;
        this.daily_remind = r105;
        this.target_users = Internal.immutableCopyOf("target_users", r106);
        this.complete_type = r107;
    }
}
