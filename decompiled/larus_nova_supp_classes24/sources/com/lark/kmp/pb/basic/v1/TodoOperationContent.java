package com.lark.kmp.pb.basic.v1;

import com.lark.kmp.pb.todo.v1.TodoUser;
import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 .2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0005-./01B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010*\u001a\u00020\u0002H\u0016J\b\u0010+\u001a\u00020,H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\r0#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010&\u001a\u0004\u0018\u00010'¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)¨\u00062"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/TodoOperationContent;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/TodoOperationContent$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/TodoOperationContent$Builder;Lokio/ByteString;)V", "operation_type", "Lcom/lark/kmp/pb/basic/v1/TodoOperationContent$Type;", "getOperation_type", "()Lcom/lark/kmp/pb/basic/v1/TodoOperationContent$Type;", "operator", "Lcom/lark/kmp/pb/todo/v1/TodoUser;", "getOperator", "()Lcom/lark/kmp/pb/todo/v1/TodoUser;", "todo_detail", "Lcom/lark/kmp/pb/basic/v1/TodoDetail;", "getTodo_detail", "()Lcom/lark/kmp/pb/basic/v1/TodoDetail;", "msg_status", "Lcom/lark/kmp/pb/basic/v1/TodoOperationContent$MsgStatus;", "getMsg_status", "()Lcom/lark/kmp/pb/basic/v1/TodoOperationContent$MsgStatus;", "todo_comment_detail", "Lcom/lark/kmp/pb/basic/v1/TodoCommentDetail;", "getTodo_comment_detail$annotations", "()V", "getTodo_comment_detail", "()Lcom/lark/kmp/pb/basic/v1/TodoCommentDetail;", "daily_remind", "Lcom/lark/kmp/pb/basic/v1/TodoDailyRemind;", "getDaily_remind", "()Lcom/lark/kmp/pb/basic/v1/TodoDailyRemind;", "target_users", "", "getTarget_users", "()Ljava/util/List;", "complete_type", "Lcom/lark/kmp/pb/basic/v1/TodoOperationContent$CompleteType;", "getComplete_type", "()Lcom/lark/kmp/pb/basic/v1/TodoOperationContent$CompleteType;", "newBuilder", "toString", "", "Builder", "Companion", "Type", "CompleteType", "MsgStatus", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class TodoOperationContent extends com.lark.wire.Message<TodoOperationContent, a> {
    public static final ProtoAdapter<TodoOperationContent> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final CompleteType complete_type;
    private final TodoDailyRemind daily_remind;
    private final MsgStatus msg_status;
    private final Type operation_type;
    private final TodoUser operator;
    private final List<TodoUser> target_users;
    private final TodoCommentDetail todo_comment_detail;
    private final TodoDetail todo_detail;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u0000 \u00172\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0017B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0018"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/TodoOperationContent$CompleteType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_COMPLETE_TYPE", "COMPLETE_WHOLE_TODO", "COMPLETE_WHOLE_TODO_AFTER_REMOVE_ASSIGNEE_SELF", "COMPLETE_WHOLE_TODO_AFTER_REMOVE_ASSIGNEES", "COMPLETE_WHOLE_TODO_AFTER_REMOVE_ASSIGNEE_YOURSELF", "COMPLETE_WHOLE_TODO_AFTER_COMPLETE_ASSIGNEES", "COMPLETE_WHOLE_TODO_AFTER_COMPLETE_ASSIGNEE_YOURSELF", "RESTORE_WHOLE_TODO", "RESTORE_WHOLE_TODO_AFTER_ADD_ASSIGNEE_SELF", "RESTORE_WHOLE_TODO_AFTER_ADD_ASSIGNEES", "RESTORE_WHOLE_TODO_AFTER_ADD_ASSIGNEES_YOURSELF", "RESTORE_WHOLE_TODO_AFTER_RESTORE_SELF", "RESTORE_WHOLE_TODO_AFTER_RESTORE_ASSIGNEE", "RESTORE_WHOLE_TODO_AFTER_RESTORE_ASSIGNEE_YOURSELF", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum CompleteType extends Enum<CompleteType> implements o0 {
        public static final ProtoAdapter<CompleteType> ADAPTER = null;
        public static final CompleteType COMPLETE_WHOLE_TODO = null;
        public static final CompleteType COMPLETE_WHOLE_TODO_AFTER_COMPLETE_ASSIGNEES = null;
        public static final CompleteType COMPLETE_WHOLE_TODO_AFTER_COMPLETE_ASSIGNEE_YOURSELF = null;
        public static final CompleteType COMPLETE_WHOLE_TODO_AFTER_REMOVE_ASSIGNEES = null;
        public static final CompleteType COMPLETE_WHOLE_TODO_AFTER_REMOVE_ASSIGNEE_SELF = null;
        public static final CompleteType COMPLETE_WHOLE_TODO_AFTER_REMOVE_ASSIGNEE_YOURSELF = null;
        public static final b Companion = null;
        public static final CompleteType RESTORE_WHOLE_TODO = null;
        public static final CompleteType RESTORE_WHOLE_TODO_AFTER_ADD_ASSIGNEES = null;
        public static final CompleteType RESTORE_WHOLE_TODO_AFTER_ADD_ASSIGNEES_YOURSELF = null;
        public static final CompleteType RESTORE_WHOLE_TODO_AFTER_ADD_ASSIGNEE_SELF = null;
        public static final CompleteType RESTORE_WHOLE_TODO_AFTER_RESTORE_ASSIGNEE = null;
        public static final CompleteType RESTORE_WHOLE_TODO_AFTER_RESTORE_ASSIGNEE_YOURSELF = null;
        public static final CompleteType RESTORE_WHOLE_TODO_AFTER_RESTORE_SELF = null;
        public static final CompleteType UNKNOWN_COMPLETE_TYPE = null;
        public static final /* synthetic */ CompleteType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<CompleteType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                CompleteType.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<CompleteType> r1, Syntax r2, CompleteType r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static CompleteType a(int r0) {
                switch(r0) {
                    case 0: goto L27;
                    case 1: goto L26;
                    case 2: goto L25;
                    case 3: goto L24;
                    case 4: goto L23;
                    case 5: goto L22;
                    case 6: goto L21;
                    default: goto L3;
                };
            L3:
                switch(r0) {
                    case 21: goto L19;
                    case 22: goto L33;
                    case 23: goto L32;
                    case 24: goto L31;
                    case 25: goto L30;
                    case 26: goto L29;
                    case 27: goto L28;
                    default: goto L4;
                };
            L4:
                return null;
            L28:
                return CompleteType.RESTORE_WHOLE_TODO_AFTER_RESTORE_ASSIGNEE_YOURSELF;
            L29:
                return CompleteType.RESTORE_WHOLE_TODO_AFTER_RESTORE_ASSIGNEE;
            L30:
                return CompleteType.RESTORE_WHOLE_TODO_AFTER_RESTORE_SELF;
            L31:
                return CompleteType.RESTORE_WHOLE_TODO_AFTER_ADD_ASSIGNEES_YOURSELF;
            L32:
                return CompleteType.RESTORE_WHOLE_TODO_AFTER_ADD_ASSIGNEES;
            L33:
                return CompleteType.RESTORE_WHOLE_TODO_AFTER_ADD_ASSIGNEE_SELF;
            L19:
                return CompleteType.RESTORE_WHOLE_TODO;
            L21:
                return CompleteType.COMPLETE_WHOLE_TODO_AFTER_COMPLETE_ASSIGNEE_YOURSELF;
            L22:
                return CompleteType.COMPLETE_WHOLE_TODO_AFTER_COMPLETE_ASSIGNEES;
            L23:
                return CompleteType.COMPLETE_WHOLE_TODO_AFTER_REMOVE_ASSIGNEE_YOURSELF;
            L24:
                return CompleteType.COMPLETE_WHOLE_TODO_AFTER_REMOVE_ASSIGNEES;
            L25:
                return CompleteType.COMPLETE_WHOLE_TODO_AFTER_REMOVE_ASSIGNEE_SELF;
            L26:
                return CompleteType.COMPLETE_WHOLE_TODO;
            L27:
                return CompleteType.UNKNOWN_COMPLETE_TYPE;
            }
        }

        @JvmStatic
        public static final CompleteType fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<CompleteType> getEntries() {
            return b;
        }

        static {
            CompleteType r0 = new CompleteType("UNKNOWN_COMPLETE_TYPE", 0, 0);
            UNKNOWN_COMPLETE_TYPE = r0;
            CompleteType r1 = new CompleteType("COMPLETE_WHOLE_TODO", 1, 1);
            COMPLETE_WHOLE_TODO = r1;
            CompleteType r3 = new CompleteType("COMPLETE_WHOLE_TODO_AFTER_REMOVE_ASSIGNEE_SELF", 2, 2);
            COMPLETE_WHOLE_TODO_AFTER_REMOVE_ASSIGNEE_SELF = r3;
            CompleteType r5 = new CompleteType("COMPLETE_WHOLE_TODO_AFTER_REMOVE_ASSIGNEES", 3, 3);
            COMPLETE_WHOLE_TODO_AFTER_REMOVE_ASSIGNEES = r5;
            CompleteType r7 = new CompleteType("COMPLETE_WHOLE_TODO_AFTER_REMOVE_ASSIGNEE_YOURSELF", 4, 4);
            COMPLETE_WHOLE_TODO_AFTER_REMOVE_ASSIGNEE_YOURSELF = r7;
            CompleteType r9 = new CompleteType("COMPLETE_WHOLE_TODO_AFTER_COMPLETE_ASSIGNEES", 5, 5);
            COMPLETE_WHOLE_TODO_AFTER_COMPLETE_ASSIGNEES = r9;
            CompleteType r11 = new CompleteType("COMPLETE_WHOLE_TODO_AFTER_COMPLETE_ASSIGNEE_YOURSELF", 6, 6);
            COMPLETE_WHOLE_TODO_AFTER_COMPLETE_ASSIGNEE_YOURSELF = r11;
            CompleteType r13 = new CompleteType("RESTORE_WHOLE_TODO", 7, 21);
            RESTORE_WHOLE_TODO = r13;
            CompleteType r12 = new CompleteType("RESTORE_WHOLE_TODO_AFTER_ADD_ASSIGNEE_SELF", 8, 22);
            RESTORE_WHOLE_TODO_AFTER_ADD_ASSIGNEE_SELF = r12;
            CompleteType r10 = new CompleteType("RESTORE_WHOLE_TODO_AFTER_ADD_ASSIGNEES", 9, 23);
            RESTORE_WHOLE_TODO_AFTER_ADD_ASSIGNEES = r10;
            CompleteType r8 = new CompleteType("RESTORE_WHOLE_TODO_AFTER_ADD_ASSIGNEES_YOURSELF", 10, 24);
            RESTORE_WHOLE_TODO_AFTER_ADD_ASSIGNEES_YOURSELF = r8;
            CompleteType r6 = new CompleteType("RESTORE_WHOLE_TODO_AFTER_RESTORE_SELF", 11, 25);
            RESTORE_WHOLE_TODO_AFTER_RESTORE_SELF = r6;
            CompleteType r4 = new CompleteType("RESTORE_WHOLE_TODO_AFTER_RESTORE_ASSIGNEE", 12, 26);
            RESTORE_WHOLE_TODO_AFTER_RESTORE_ASSIGNEE = r4;
            CompleteType r2 = new CompleteType("RESTORE_WHOLE_TODO_AFTER_RESTORE_ASSIGNEE_YOURSELF", 13, 27);
            RESTORE_WHOLE_TODO_AFTER_RESTORE_ASSIGNEE_YOURSELF = r2;
            CompleteType[] r14 = {r0, r1, r3, r5, r7, r9, r11, r13, r12, r10, r8, r6, r4, r2};
            a = r14;
            b = EnumEntriesKt.enumEntries(r14);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(CompleteType.class), Syntax.PROTO_2, r0);
        }

        public static CompleteType[] values() {
            return (CompleteType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static CompleteType valueOf(String r1) {
            return (CompleteType) r27.a.a(CompleteType.class, r1);
        }

        public CompleteType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/TodoOperationContent$MsgStatus;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "ACTIVE", "DELETED", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum MsgStatus extends Enum<MsgStatus> implements o0 {
        public static final MsgStatus ACTIVE = null;
        public static final ProtoAdapter<MsgStatus> ADAPTER = null;
        public static final b Companion = null;
        public static final MsgStatus DELETED = null;
        public static final /* synthetic */ MsgStatus[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<MsgStatus> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                MsgStatus.Companion.getClass();
                if (r2 == 0) goto L9;
                if (r2 == 1) goto L11;
                return null;
            L11:
                return MsgStatus.DELETED;
            L9:
                return MsgStatus.ACTIVE;
            }

            public a(KClass<MsgStatus> r1, Syntax r2, MsgStatus r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<MsgStatus> getEntries() {
            return b;
        }

        static {
            MsgStatus r0 = new MsgStatus("ACTIVE", 0, 0);
            ACTIVE = r0;
            MsgStatus r1 = new MsgStatus("DELETED", 1, 1);
            DELETED = r1;
            MsgStatus[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(MsgStatus.class), Syntax.PROTO_2, r0);
        }

        public static MsgStatus[] values() {
            return (MsgStatus[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final MsgStatus fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L9;
            if (r1 == 1) goto L11;
            return null;
        L11:
            return DELETED;
        L9:
            return ACTIVE;
        }

        public static MsgStatus valueOf(String r1) {
            return (MsgStatus) r27.a.a(MsgStatus.class, r1);
        }

        public MsgStatus(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u001a\b\u0086\u0081\u0002\u0018\u0000 \u001d2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u001dB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c¨\u0006\u001e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/TodoOperationContent$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "UPDATE", "ASSIGN", "COMPLETE", "CANCEL", "DELETE", "CREATE", "INCOMPLETE", "SHARE", "CREATE_COMMENT", "REPLY_COMMENT", "DAILY_REMIND", "FOLLOW", "UNFOLLOW", "REACT_COMMENT", "COMPLETE_ASSIGNEE", "COMPLETE_SELF", "RESTORE_ASSIGNEE", "RESTORE_SELF", "ASSIGN_OWNER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Type extends Enum<Type> implements o0 {
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type ASSIGN = null;
        public static final Type ASSIGN_OWNER = null;
        public static final Type CANCEL = null;
        public static final Type COMPLETE = null;
        public static final Type COMPLETE_ASSIGNEE = null;
        public static final Type COMPLETE_SELF = null;
        public static final Type CREATE = null;

        @Deprecated(message = "CREATE_COMMENT is deprecated")
        public static final Type CREATE_COMMENT = null;
        public static final b Companion = null;
        public static final Type DAILY_REMIND = null;
        public static final Type DELETE = null;
        public static final Type FOLLOW = null;
        public static final Type INCOMPLETE = null;

        @Deprecated(message = "REACT_COMMENT is deprecated")
        public static final Type REACT_COMMENT = null;

        @Deprecated(message = "REPLY_COMMENT is deprecated")
        public static final Type REPLY_COMMENT = null;
        public static final Type RESTORE_ASSIGNEE = null;
        public static final Type RESTORE_SELF = null;
        public static final Type SHARE = null;
        public static final Type UNFOLLOW = null;
        public static final Type UNKNOWN = null;
        public static final Type UPDATE = null;
        public static final /* synthetic */ Type[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Type> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Type.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<Type> r1, Syntax r2, Type r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static Type a(int r0) {
                switch(r0) {
                    case 0: goto L24;
                    case 1: goto L44;
                    case 2: goto L43;
                    case 3: goto L42;
                    case 4: goto L41;
                    case 5: goto L40;
                    case 6: goto L39;
                    case 7: goto L38;
                    case 8: goto L37;
                    case 9: goto L36;
                    case 10: goto L35;
                    case 11: goto L34;
                    case 12: goto L33;
                    case 13: goto L32;
                    case 14: goto L31;
                    case 15: goto L30;
                    case 16: goto L29;
                    case 17: goto L28;
                    case 18: goto L27;
                    case 19: goto L26;
                    default: goto L3;
                };
            L3:
                return null;
            L26:
                return Type.ASSIGN_OWNER;
            L27:
                return Type.RESTORE_SELF;
            L28:
                return Type.RESTORE_ASSIGNEE;
            L29:
                return Type.COMPLETE_SELF;
            L30:
                return Type.COMPLETE_ASSIGNEE;
            L31:
                return Type.REACT_COMMENT;
            L32:
                return Type.UNFOLLOW;
            L33:
                return Type.FOLLOW;
            L34:
                return Type.DAILY_REMIND;
            L35:
                return Type.REPLY_COMMENT;
            L36:
                return Type.CREATE_COMMENT;
            L37:
                return Type.SHARE;
            L38:
                return Type.INCOMPLETE;
            L39:
                return Type.CREATE;
            L40:
                return Type.DELETE;
            L41:
                return Type.CANCEL;
            L42:
                return Type.COMPLETE;
            L43:
                return Type.ASSIGN;
            L44:
                return Type.UPDATE;
            L24:
                return Type.UNKNOWN;
            }
        }

        @JvmStatic
        public static final Type fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<Type> getEntries() {
            return b;
        }

        static {
            Type r0 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Type r1 = new Type("UPDATE", 1, 1);
            UPDATE = r1;
            Type r3 = new Type("ASSIGN", 2, 2);
            ASSIGN = r3;
            Type r5 = new Type("COMPLETE", 3, 3);
            COMPLETE = r5;
            Type r7 = new Type("CANCEL", 4, 4);
            CANCEL = r7;
            Type r9 = new Type("DELETE", 5, 5);
            DELETE = r9;
            Type r11 = new Type("CREATE", 6, 6);
            CREATE = r11;
            Type r13 = new Type("INCOMPLETE", 7, 7);
            INCOMPLETE = r13;
            Type r15 = new Type("SHARE", 8, 8);
            SHARE = r15;
            Type r14 = new Type("CREATE_COMMENT", 9, 9);
            CREATE_COMMENT = r14;
            Type r12 = new Type("REPLY_COMMENT", 10, 10);
            REPLY_COMMENT = r12;
            Type r10 = new Type("DAILY_REMIND", 11, 11);
            DAILY_REMIND = r10;
            Type r8 = new Type("FOLLOW", 12, 12);
            FOLLOW = r8;
            Type r6 = new Type("UNFOLLOW", 13, 13);
            UNFOLLOW = r6;
            Type r4 = new Type("REACT_COMMENT", 14, 14);
            REACT_COMMENT = r4;
            Type r2 = new Type("COMPLETE_ASSIGNEE", 15, 15);
            COMPLETE_ASSIGNEE = r2;
            Type r16 = new Type("COMPLETE_SELF", 16, 16);
            COMPLETE_SELF = r16;
            Type r17 = new Type("RESTORE_ASSIGNEE", 17, 17);
            RESTORE_ASSIGNEE = r17;
            Type r19 = new Type("RESTORE_SELF", 18, 18);
            RESTORE_SELF = r19;
            Type r20 = new Type("ASSIGN_OWNER", 19, 19);
            ASSIGN_OWNER = r20;
            Type[] r21 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r19, r20};
            a = r21;
            b = EnumEntriesKt.enumEntries(r21);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Type.class), Syntax.PROTO_2, r0);
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<TodoOperationContent, a> {
        public Type d;
        public TodoUser e;
        public TodoDetail f;
        public MsgStatus g;
        public TodoCommentDetail h;
        public TodoDailyRemind i;
        public List<TodoUser> j;
        public CompleteType k;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new TodoOperationContent(this, c(), null);
        }

        public a() {
            this.j = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<TodoOperationContent> {
        @Override // com.lark.wire.ProtoAdapter
        public final TodoOperationContent c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r0 = new a();
            ArrayList r1 = new ArrayList();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            if (r4 == (-1)) goto L24;
            switch(r4) {
                case 1: goto L28;
                case 2: goto L19;
                case 3: goto L18;
                case 4: goto L26;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L11;
                case 8: goto L30;
                default: goto L6;
            };
        L26:
            r0.g = MsgStatus.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r5 = Unit.INSTANCE;
            goto L3
        L28:
            r0.d = Type.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r6 = Unit.INSTANCE;
            goto L3
        L30:
            r0.k = CompleteType.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r7 = Unit.INSTANCE;
            goto L3
        L11:
            r1.add(TodoUser.ADAPTER.c(r10));
            goto L3
        L12:
            r0.i = TodoDailyRemind.ADAPTER.c(r10);
            goto L3
        L13:
            r0.h = TodoCommentDetail.ADAPTER.c(r10);
            goto L3
        L18:
            r0.f = TodoDetail.ADAPTER.c(r10);
            goto L3
        L19:
            r0.e = TodoUser.ADAPTER.c(r10);
            goto L3
        L6:
            r10.j(r4);
            goto L3
        L24:
            ByteString r11 = r10.d(r2);
            Intrinsics.checkNotNullParameter(r1, "target_users");
            com.lark.wire.internal.a.a(r1);
            r0.j = r1;
            return new TodoOperationContent(r0, r11, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(TodoOperationContent r6) {
            TodoOperationContent r7 = r6;
            Intrinsics.checkNotNullParameter(r7, "value");
            int r0 = r7.unknownFields().size() + Type.ADAPTER.l(1, r7.getOperation_type());
            ProtoAdapter<TodoUser> r1 = TodoUser.ADAPTER;
            return ((((((r0 + r1.l(2, r7.getOperator())) + TodoDetail.ADAPTER.l(3, r7.getTodo_detail())) + MsgStatus.ADAPTER.l(4, r7.getMsg_status())) + TodoCommentDetail.ADAPTER.l(5, r7.getTodo_comment_detail())) + TodoDailyRemind.ADAPTER.l(6, r7.getDaily_remind())) + r1.a().l(7, r7.getTarget_users())) + CompleteType.ADAPTER.l(8, r7.getComplete_type());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r5, TodoOperationContent r6) {
            TodoOperationContent r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            Type.ADAPTER.i(r5, 1, r7.getOperation_type());
            ProtoAdapter<TodoUser> r0 = TodoUser.ADAPTER;
            r0.i(r5, 2, r7.getOperator());
            TodoDetail.ADAPTER.i(r5, 3, r7.getTodo_detail());
            MsgStatus.ADAPTER.i(r5, 4, r7.getMsg_status());
            TodoCommentDetail.ADAPTER.i(r5, 5, r7.getTodo_comment_detail());
            TodoDailyRemind.ADAPTER.i(r5, 6, r7.getDaily_remind());
            r0.a().i(r5, 7, r7.getTarget_users());
            CompleteType.ADAPTER.i(r5, 8, r7.getComplete_type());
            r5.a(r7.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, TodoOperationContent r6) {
            TodoOperationContent r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            CompleteType.ADAPTER.j(r5, 8, r7.getComplete_type());
            ProtoAdapter<TodoUser> r0 = TodoUser.ADAPTER;
            r0.a().j(r5, 7, r7.getTarget_users());
            TodoDailyRemind.ADAPTER.j(r5, 6, r7.getDaily_remind());
            TodoCommentDetail.ADAPTER.j(r5, 5, r7.getTodo_comment_detail());
            MsgStatus.ADAPTER.j(r5, 4, r7.getMsg_status());
            TodoDetail.ADAPTER.j(r5, 3, r7.getTodo_detail());
            r0.j(r5, 2, r7.getOperator());
            Type.ADAPTER.j(r5, 1, r7.getOperation_type());
        }

        public b(FieldEncoding r7, KClass<TodoOperationContent> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.TodoOperationContent", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ TodoOperationContent(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    @Deprecated(message = "todo_comment_detail is deprecated")
    public static /* synthetic */ void getTodo_comment_detail$annotations() {
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TodoOperationContent.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.operation_type;
        r0.e = this.operator;
        r0.f = this.todo_detail;
        r0.g = this.msg_status;
        r0.h = this.todo_comment_detail;
        r0.i = this.daily_remind;
        r0.j = this.target_users;
        r0.k = this.complete_type;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(TodoOperationContent.class).getSimpleName() + '@' + hashCode();
    }

    public final CompleteType getComplete_type() {
        return this.complete_type;
    }

    public final TodoDailyRemind getDaily_remind() {
        return this.daily_remind;
    }

    public final MsgStatus getMsg_status() {
        return this.msg_status;
    }

    public final Type getOperation_type() {
        return this.operation_type;
    }

    public final TodoUser getOperator() {
        return this.operator;
    }

    public final List<TodoUser> getTarget_users() {
        return this.target_users;
    }

    public final TodoCommentDetail getTodo_comment_detail() {
        return this.todo_comment_detail;
    }

    public final TodoDetail getTodo_detail() {
        return this.todo_detail;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public TodoOperationContent(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.operation_type = r2.d;
        this.operator = r2.e;
        this.todo_detail = r2.f;
        this.msg_status = r2.g;
        this.todo_comment_detail = r2.h;
        this.daily_remind = r2.i;
        this.target_users = com.lark.wire.internal.a.c("target_users", r2.j);
        this.complete_type = r2.k;
    }

    public /* synthetic */ TodoOperationContent(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
