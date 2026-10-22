package com.bytedance.lark.pb.basic.v1;

import com.bytedance.lark.pb.entity_num.v1.EntityNumInfo;
import com.bytedance.lark.pb.todo.v1.CustomComplete;
import com.bytedance.lark.pb.todo.v1.TaskMode;
import com.bytedance.lark.pb.todo.v1.TodoAssignee;
import com.bytedance.lark.pb.todo.v1.TodoFollower;
import com.bytedance.lark.pb.todo.v1.TodoOwner;
import com.bytedance.lark.pb.todo.v1.TodoReminder;
import com.bytedance.lark.pb.todo.v1.TodoSource;
import com.bytedance.lark.pb.todo.v1.TodoUser;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class TodoDetail extends com.squareup.wire.Message<TodoDetail, Builder> {
    public static final ProtoAdapter<TodoDetail> ADAPTER = null;
    public static final Boolean DEFAULT_CAN_FOLLOW = null;
    public static final Long DEFAULT_COMPLETED_MILLI_TIME = null;
    public static final Long DEFAULT_DELETED_MILLI_TIME = null;
    public static final Long DEFAULT_DUE_TIME = null;
    public static final String DEFAULT_DUE_TIMEZONE = "";
    public static final String DEFAULT_GUID = "";
    public static final Boolean DEFAULT_IS_ALL_DAY = null;
    public static final Boolean DEFAULT_IS_MILESTONE = null;
    public static final TaskMode DEFAULT_MODE = null;
    public static final MsgBelongTo DEFAULT_MSG_BELONG_TO = null;
    public static final String DEFAULT_RRULE = "";
    public static final TodoSource DEFAULT_SOURCE = null;
    public static final Long DEFAULT_START_MILLI_TIME = null;
    public static final String DEFAULT_SUMMARY = "";
    public static final Boolean DEFAULT_USER_COMPLETE_ENABLED = null;
    private static final long serialVersionUID = 0;
    public final List<TodoAssignee> assignees;
    public final Boolean can_follow;
    public final Long completed_milli_time;
    public final TodoUser creator;
    public final CustomComplete custom_complete;
    public final Long deleted_milli_time;
    public final Long due_time;
    public final String due_timezone;
    public final EntityNumInfo entity_num;
    public final List<TodoFollower> followers;
    public final String guid;
    public final Boolean is_all_day;
    public final Boolean is_milestone;
    public final TaskMode mode;
    public final MsgBelongTo msg_belong_to;
    public final TodoOwner owner;
    public final List<TodoReminder> reminders;
    public final RichContent rich_summary;
    public final String rrule;
    public final TodoSource source;
    public final Long start_milli_time;
    public final String summary;
    public final Boolean user_complete_enabled;
    public final Map<String, Permission> user_to_permission;

    public static final class Builder extends com.squareup.wire.Message.Builder<TodoDetail, Builder> {
        public List<TodoAssignee> assignees;
        public Boolean can_follow;
        public Long completed_milli_time;
        public TodoUser creator;
        public CustomComplete custom_complete;
        public Long deleted_milli_time;
        public Long due_time;
        public String due_timezone;
        public EntityNumInfo entity_num;
        public List<TodoFollower> followers;
        public String guid;
        public Boolean is_all_day;
        public Boolean is_milestone;
        public TaskMode mode;
        public MsgBelongTo msg_belong_to;
        public TodoOwner owner;
        public List<TodoReminder> reminders;
        public RichContent rich_summary;
        public String rrule;
        public TodoSource source;
        public Long start_milli_time;
        public String summary;
        public Boolean user_complete_enabled;
        public Map<String, Permission> user_to_permission;

        @Override // com.squareup.wire.Message.Builder
        public TodoDetail build() {
            return new TodoDetail(this.guid, this.assignees, this.summary, this.due_time, this.due_timezone, this.is_all_day, this.msg_belong_to, this.rich_summary, this.followers, this.creator, this.completed_milli_time, this.deleted_milli_time, this.source, this.can_follow, this.user_to_permission, this.user_complete_enabled, this.custom_complete, this.rrule, this.reminders, this.entity_num, this.owner, this.mode, this.start_milli_time, this.is_milestone, super.buildUnknownFields());
        }

        public Builder() {
            this.assignees = Internal.newMutableList();
            this.followers = Internal.newMutableList();
            this.user_to_permission = Internal.newMutableMap();
            this.reminders = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder assignees(List<TodoAssignee> r100) {
            Internal.checkElementsNotNull(r100);
            this.assignees = r100;
            return this;
        }

        public Builder can_follow(Boolean r100) {
            this.can_follow = r100;
            return this;
        }

        public Builder completed_milli_time(Long r100) {
            this.completed_milli_time = r100;
            return this;
        }

        public Builder creator(TodoUser r100) {
            this.creator = r100;
            return this;
        }

        public Builder custom_complete(CustomComplete r100) {
            this.custom_complete = r100;
            return this;
        }

        public Builder deleted_milli_time(Long r100) {
            this.deleted_milli_time = r100;
            return this;
        }

        public Builder due_time(Long r100) {
            this.due_time = r100;
            return this;
        }

        public Builder due_timezone(String r100) {
            this.due_timezone = r100;
            return this;
        }

        public Builder entity_num(EntityNumInfo r100) {
            this.entity_num = r100;
            return this;
        }

        public Builder followers(List<TodoFollower> r100) {
            Internal.checkElementsNotNull(r100);
            this.followers = r100;
            return this;
        }

        public Builder guid(String r100) {
            this.guid = r100;
            return this;
        }

        public Builder is_all_day(Boolean r100) {
            this.is_all_day = r100;
            return this;
        }

        public Builder is_milestone(Boolean r100) {
            this.is_milestone = r100;
            return this;
        }

        public Builder mode(TaskMode r100) {
            this.mode = r100;
            return this;
        }

        public Builder msg_belong_to(MsgBelongTo r100) {
            this.msg_belong_to = r100;
            return this;
        }

        public Builder owner(TodoOwner r100) {
            this.owner = r100;
            return this;
        }

        public Builder reminders(List<TodoReminder> r100) {
            Internal.checkElementsNotNull(r100);
            this.reminders = r100;
            return this;
        }

        public Builder rich_summary(RichContent r100) {
            this.rich_summary = r100;
            return this;
        }

        public Builder rrule(String r100) {
            this.rrule = r100;
            return this;
        }

        public Builder source(TodoSource r100) {
            this.source = r100;
            return this;
        }

        public Builder start_milli_time(Long r100) {
            this.start_milli_time = r100;
            return this;
        }

        public Builder summary(String r100) {
            this.summary = r100;
            return this;
        }

        public Builder user_complete_enabled(Boolean r100) {
            this.user_complete_enabled = r100;
            return this;
        }

        public Builder user_to_permission(Map<String, Permission> r100) {
            Internal.checkElementsNotNull(r100);
            this.user_to_permission = r100;
            return this;
        }
    }

    public static final enum MsgBelongTo extends Enum<MsgBelongTo> implements WireEnum {
        private static final /* synthetic */ MsgBelongTo[] $VALUES = null;
        public static final ProtoAdapter<MsgBelongTo> ADAPTER = null;
        public static final MsgBelongTo BOT = null;
        public static final MsgBelongTo CHAT = null;
        public static final MsgBelongTo UNKNOWN = null;
        private final int value;

        static {
            MsgBelongTo r100 = new MsgBelongTo("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            MsgBelongTo r101 = new MsgBelongTo("BOT", 1, 1);
            BOT = r101;
            MsgBelongTo r102 = new MsgBelongTo("CHAT", 2, 2);
            CHAT = r102;
            $VALUES = new MsgBelongTo[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(MsgBelongTo.class);
        }

        public static MsgBelongTo[] values() {
            return (MsgBelongTo[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static MsgBelongTo fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return CHAT;
        L12:
            return BOT;
        L14:
            return UNKNOWN;
        }

        public static MsgBelongTo valueOf(String r100) {
            return (MsgBelongTo) a.a(MsgBelongTo.class, r100);
        }

        private MsgBelongTo(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Permission extends com.squareup.wire.Message<Permission, Builder> {
        public static final ProtoAdapter<Permission> ADAPTER = null;
        public static final Boolean DEFAULT_CAN_COMPLETE_SELF = null;
        public static final Boolean DEFAULT_CAN_COMPLETE_TODO = null;
        public static final Boolean DEFAULT_CAN_FOLLOW = null;
        private static final long serialVersionUID = 0;
        public final Boolean can_complete_self;
        public final Boolean can_complete_todo;
        public final Boolean can_follow;

        public static final class Builder extends com.squareup.wire.Message.Builder<Permission, Builder> {
            public Boolean can_complete_self;
            public Boolean can_complete_todo;
            public Boolean can_follow;

            @Override // com.squareup.wire.Message.Builder
            public Permission build() {
                return new Permission(this.can_complete_todo, this.can_complete_self, this.can_follow, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder can_complete_self(Boolean r100) {
                this.can_complete_self = r100;
                return this;
            }

            public Builder can_complete_todo(Boolean r100) {
                this.can_complete_todo = r100;
                return this;
            }

            public Builder can_follow(Boolean r100) {
                this.can_follow = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Permission extends ProtoAdapter<Permission> {
            public ProtoAdapter_Permission() {
                super(FieldEncoding.LENGTH_DELIMITED, Permission.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Permission decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                Boolean r102 = Boolean.FALSE;
                r101.can_complete_todo = r102;
                r101.can_complete_self = r102;
                r101.can_follow = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L15;
                if (r104 != 1) goto L8;
                r101.can_complete_todo = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                if (r104 != 2) goto L10;
                r101.can_complete_self = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L10:
                if (r104 != 3) goto L11;
                r101.can_follow = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L11:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L15:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(Permission r100) {
                Boolean r101 = r100.can_complete_todo;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L6:
                Boolean r104 = r100.can_complete_self;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Boolean r107 = r100.can_follow;
                if (r107 == null) goto L14;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
            L14:
                return (r106 + r102) + r100.unknownFields().size();
            L9:
                r105 = 0;
                goto L10
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Permission decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Permission r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Permission r101) throws IOException {
                Boolean r102 = r101.can_complete_todo;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                Boolean r103 = r101.can_complete_self;
                if (r103 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
            L8:
                Boolean r104 = r101.can_follow;
                if (r104 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Permission r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Permission();
            Boolean r100 = Boolean.FALSE;
            DEFAULT_CAN_COMPLETE_TODO = r100;
            DEFAULT_CAN_COMPLETE_SELF = r100;
            DEFAULT_CAN_FOLLOW = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.can_complete_todo = this.can_complete_todo;
            r100.can_complete_self = this.can_complete_self;
            r100.can_follow = this.can_follow;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Permission.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public Permission(Boolean r100, Boolean r101, Boolean r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public Permission(Boolean r100, Boolean r101, Boolean r102, ByteString r103) {
            super(ADAPTER, r103);
            this.can_complete_todo = r100;
            this.can_complete_self = r101;
            this.can_follow = r102;
        }
    }

    public static final class ProtoAdapter_TodoDetail extends ProtoAdapter<TodoDetail> {
        private final ProtoAdapter<Map<String, Permission>> user_to_permission;

        public ProtoAdapter_TodoDetail() {
            super(FieldEncoding.LENGTH_DELIMITED, TodoDetail.class);
            this.user_to_permission = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, Permission.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TodoDetail decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.guid = "";
            r101.summary = "";
            r101.due_time = 0L;
            r101.due_timezone = "";
            Boolean r102 = Boolean.FALSE;
            r101.is_all_day = r102;
            r101.msg_belong_to = MsgBelongTo.UNKNOWN;
            r101.completed_milli_time = 0L;
            r101.deleted_milli_time = 0L;
            r101.source = TodoSource.TODO;
            r101.can_follow = r102;
            r101.user_complete_enabled = r102;
            r101.rrule = "";
            r101.mode = TaskMode.UNKNOWN_MODE;
            r101.start_milli_time = 0L;
            r101.is_milestone = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L40;
            switch(r104) {
                case 1: goto L39;
                case 2: goto L38;
                case 3: goto L37;
                case 4: goto L36;
                case 5: goto L35;
                case 6: goto L34;
                case 7: goto L46;
                case 8: goto L29;
                case 9: goto L28;
                case 10: goto L27;
                case 11: goto L26;
                case 12: goto L25;
                case 13: goto L42;
                case 14: goto L20;
                case 15: goto L19;
                case 16: goto L18;
                case 17: goto L17;
                case 18: goto L16;
                case 19: goto L15;
                case 20: goto L14;
                case 21: goto L13;
                case 22: goto L44;
                case 23: goto L8;
                case 24: goto L7;
                default: goto L6;
            };
        L42:
            r101.source = TodoSource.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
        L23:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L44:
            r101.mode = TaskMode.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
        L11:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L46:
            r101.msg_belong_to = MsgBelongTo.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L32
        L32:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.is_milestone = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            r101.start_milli_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L13:
            r101.owner = TodoOwner.ADAPTER.decode(r100);
            goto L3
        L14:
            r101.entity_num = EntityNumInfo.ADAPTER.decode(r100);
            goto L3
        L15:
            r101.reminders.add(TodoReminder.ADAPTER.decode(r100));
            goto L3
        L16:
            r101.rrule = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.custom_complete = CustomComplete.ADAPTER.decode(r100);
            goto L3
        L18:
            r101.user_complete_enabled = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L19:
            r101.user_to_permission.putAll(this.user_to_permission.decode(r100));
            goto L3
        L20:
            r101.can_follow = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L25:
            r101.deleted_milli_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L26:
            r101.completed_milli_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L27:
            r101.creator = TodoUser.ADAPTER.decode(r100);
            goto L3
        L28:
            r101.followers.add(TodoFollower.ADAPTER.decode(r100));
            goto L3
        L29:
            r101.rich_summary = RichContent.ADAPTER.decode(r100);
            goto L3
        L34:
            r101.is_all_day = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L35:
            r101.due_timezone = ProtoAdapter.STRING.decode(r100);
            goto L3
        L36:
            r101.due_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L37:
            r101.summary = ProtoAdapter.STRING.decode(r100);
            goto L3
        L38:
            r101.assignees.add(TodoAssignee.ADAPTER.decode(r100));
            goto L3
        L39:
            r101.guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L40:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TodoDetail r100) {
            String r101 = r100.guid;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            int r104 = r103 + TodoAssignee.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.assignees);
            String r105 = r100.summary;
            if (r105 == null) goto L9;
            int r106 = ProtoAdapter.STRING.encodedSizeWithTag(3, r105);
        L10:
            int r107 = r104 + r106;
            Long r108 = r100.due_time;
            if (r108 == null) goto L13;
            int r109 = ProtoAdapter.INT64.encodedSizeWithTag(4, r108);
        L14:
            int r110 = r107 + r109;
            String r111 = r100.due_timezone;
            if (r111 == null) goto L17;
            int r112 = ProtoAdapter.STRING.encodedSizeWithTag(5, r111);
        L18:
            int r113 = r110 + r112;
            Boolean r114 = r100.is_all_day;
            if (r114 == null) goto L21;
            int r115 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r114);
        L22:
            int r116 = r113 + r115;
            MsgBelongTo r117 = r100.msg_belong_to;
            if (r117 == null) goto L25;
            int r118 = MsgBelongTo.ADAPTER.encodedSizeWithTag(7, r117);
        L26:
            int r119 = r116 + r118;
            RichContent r120 = r100.rich_summary;
            if (r120 == null) goto L29;
            int r121 = RichContent.ADAPTER.encodedSizeWithTag(8, r120);
        L30:
            int r122 = (r119 + r121) + TodoFollower.ADAPTER.asRepeated().encodedSizeWithTag(9, r100.followers);
            TodoUser r123 = r100.creator;
            if (r123 == null) goto L33;
            int r124 = TodoUser.ADAPTER.encodedSizeWithTag(10, r123);
        L34:
            int r125 = r122 + r124;
            Long r126 = r100.completed_milli_time;
            if (r126 == null) goto L37;
            int r127 = ProtoAdapter.INT64.encodedSizeWithTag(11, r126);
        L38:
            int r128 = r125 + r127;
            Long r129 = r100.deleted_milli_time;
            if (r129 == null) goto L41;
            int r130 = ProtoAdapter.INT64.encodedSizeWithTag(12, r129);
        L42:
            int r131 = r128 + r130;
            TodoSource r132 = r100.source;
            if (r132 == null) goto L45;
            int r133 = TodoSource.ADAPTER.encodedSizeWithTag(13, r132);
        L46:
            int r134 = r131 + r133;
            Boolean r135 = r100.can_follow;
            if (r135 == null) goto L49;
            int r136 = ProtoAdapter.BOOL.encodedSizeWithTag(14, r135);
        L50:
            int r137 = (r134 + r136) + this.user_to_permission.encodedSizeWithTag(15, r100.user_to_permission);
            Boolean r138 = r100.user_complete_enabled;
            if (r138 == null) goto L53;
            int r139 = ProtoAdapter.BOOL.encodedSizeWithTag(16, r138);
        L54:
            int r140 = r137 + r139;
            CustomComplete r141 = r100.custom_complete;
            if (r141 == null) goto L57;
            int r142 = CustomComplete.ADAPTER.encodedSizeWithTag(17, r141);
        L58:
            int r143 = r140 + r142;
            String r144 = r100.rrule;
            if (r144 == null) goto L61;
            int r145 = ProtoAdapter.STRING.encodedSizeWithTag(18, r144);
        L62:
            int r146 = (r143 + r145) + TodoReminder.ADAPTER.asRepeated().encodedSizeWithTag(19, r100.reminders);
            EntityNumInfo r147 = r100.entity_num;
            if (r147 == null) goto L65;
            int r148 = EntityNumInfo.ADAPTER.encodedSizeWithTag(20, r147);
        L66:
            int r149 = r146 + r148;
            TodoOwner r150 = r100.owner;
            if (r150 == null) goto L69;
            int r151 = TodoOwner.ADAPTER.encodedSizeWithTag(21, r150);
        L70:
            int r152 = r149 + r151;
            TaskMode r153 = r100.mode;
            if (r153 == null) goto L73;
            int r154 = TaskMode.ADAPTER.encodedSizeWithTag(22, r153);
        L74:
            int r155 = r152 + r154;
            Long r156 = r100.start_milli_time;
            if (r156 == null) goto L77;
            int r157 = ProtoAdapter.INT64.encodedSizeWithTag(23, r156);
        L78:
            int r158 = r155 + r157;
            Boolean r159 = r100.is_milestone;
            if (r159 == null) goto L82;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(24, r159);
        L82:
            return (r158 + r102) + r100.unknownFields().size();
        L77:
            r157 = 0;
            goto L78
        L73:
            r154 = 0;
            goto L74
        L69:
            r151 = 0;
            goto L70
        L65:
            r148 = 0;
            goto L66
        L61:
            r145 = 0;
            goto L62
        L57:
            r142 = 0;
            goto L58
        L53:
            r139 = 0;
            goto L54
        L49:
            r136 = 0;
            goto L50
        L45:
            r133 = 0;
            goto L46
        L41:
            r130 = 0;
            goto L42
        L37:
            r127 = 0;
            goto L38
        L33:
            r124 = 0;
            goto L34
        L29:
            r121 = 0;
            goto L30
        L25:
            r118 = 0;
            goto L26
        L21:
            r115 = 0;
            goto L22
        L17:
            r112 = 0;
            goto L18
        L13:
            r109 = 0;
            goto L14
        L9:
            r106 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TodoDetail decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TodoDetail r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TodoDetail r101) throws IOException {
            String r102 = r101.guid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            TodoAssignee.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.assignees);
            String r103 = r101.summary;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r103);
        L8:
            Long r104 = r101.due_time;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 4, r104);
        L11:
            String r105 = r101.due_timezone;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r105);
        L14:
            Boolean r106 = r101.is_all_day;
            if (r106 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r106);
        L17:
            MsgBelongTo r107 = r101.msg_belong_to;
            if (r107 == null) goto L20;
            MsgBelongTo.ADAPTER.encodeWithTag(r100, 7, r107);
        L20:
            RichContent r108 = r101.rich_summary;
            if (r108 == null) goto L23;
            RichContent.ADAPTER.encodeWithTag(r100, 8, r108);
        L23:
            TodoFollower.ADAPTER.asRepeated().encodeWithTag(r100, 9, r101.followers);
            TodoUser r109 = r101.creator;
            if (r109 == null) goto L26;
            TodoUser.ADAPTER.encodeWithTag(r100, 10, r109);
        L26:
            Long r110 = r101.completed_milli_time;
            if (r110 == null) goto L29;
            ProtoAdapter.INT64.encodeWithTag(r100, 11, r110);
        L29:
            Long r111 = r101.deleted_milli_time;
            if (r111 == null) goto L32;
            ProtoAdapter.INT64.encodeWithTag(r100, 12, r111);
        L32:
            TodoSource r112 = r101.source;
            if (r112 == null) goto L35;
            TodoSource.ADAPTER.encodeWithTag(r100, 13, r112);
        L35:
            Boolean r113 = r101.can_follow;
            if (r113 == null) goto L38;
            ProtoAdapter.BOOL.encodeWithTag(r100, 14, r113);
        L38:
            this.user_to_permission.encodeWithTag(r100, 15, r101.user_to_permission);
            Boolean r114 = r101.user_complete_enabled;
            if (r114 == null) goto L41;
            ProtoAdapter.BOOL.encodeWithTag(r100, 16, r114);
        L41:
            CustomComplete r115 = r101.custom_complete;
            if (r115 == null) goto L44;
            CustomComplete.ADAPTER.encodeWithTag(r100, 17, r115);
        L44:
            String r116 = r101.rrule;
            if (r116 == null) goto L47;
            ProtoAdapter.STRING.encodeWithTag(r100, 18, r116);
        L47:
            TodoReminder.ADAPTER.asRepeated().encodeWithTag(r100, 19, r101.reminders);
            EntityNumInfo r117 = r101.entity_num;
            if (r117 == null) goto L50;
            EntityNumInfo.ADAPTER.encodeWithTag(r100, 20, r117);
        L50:
            TodoOwner r118 = r101.owner;
            if (r118 == null) goto L53;
            TodoOwner.ADAPTER.encodeWithTag(r100, 21, r118);
        L53:
            TaskMode r119 = r101.mode;
            if (r119 == null) goto L56;
            TaskMode.ADAPTER.encodeWithTag(r100, 22, r119);
        L56:
            Long r120 = r101.start_milli_time;
            if (r120 == null) goto L59;
            ProtoAdapter.INT64.encodeWithTag(r100, 23, r120);
        L59:
            Boolean r121 = r101.is_milestone;
            if (r121 == null) goto L62;
            ProtoAdapter.BOOL.encodeWithTag(r100, 24, r121);
        L62:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TodoDetail r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TodoDetail();
        DEFAULT_DUE_TIME = 0L;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_ALL_DAY = r100;
        DEFAULT_MSG_BELONG_TO = MsgBelongTo.UNKNOWN;
        DEFAULT_COMPLETED_MILLI_TIME = 0L;
        DEFAULT_DELETED_MILLI_TIME = 0L;
        DEFAULT_SOURCE = TodoSource.TODO;
        DEFAULT_CAN_FOLLOW = r100;
        DEFAULT_USER_COMPLETE_ENABLED = r100;
        DEFAULT_MODE = TaskMode.UNKNOWN_MODE;
        DEFAULT_START_MILLI_TIME = 0L;
        DEFAULT_IS_MILESTONE = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.guid = this.guid;
        r100.assignees = Internal.copyOf("assignees", this.assignees);
        r100.summary = this.summary;
        r100.due_time = this.due_time;
        r100.due_timezone = this.due_timezone;
        r100.is_all_day = this.is_all_day;
        r100.msg_belong_to = this.msg_belong_to;
        r100.rich_summary = this.rich_summary;
        r100.followers = Internal.copyOf("followers", this.followers);
        r100.creator = this.creator;
        r100.completed_milli_time = this.completed_milli_time;
        r100.deleted_milli_time = this.deleted_milli_time;
        r100.source = this.source;
        r100.can_follow = this.can_follow;
        r100.user_to_permission = Internal.copyOf("user_to_permission", this.user_to_permission);
        r100.user_complete_enabled = this.user_complete_enabled;
        r100.custom_complete = this.custom_complete;
        r100.rrule = this.rrule;
        r100.reminders = Internal.copyOf("reminders", this.reminders);
        r100.entity_num = this.entity_num;
        r100.owner = this.owner;
        r100.mode = this.mode;
        r100.start_milli_time = this.start_milli_time;
        r100.is_milestone = this.is_milestone;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TodoDetail.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public TodoDetail(String r210, List<TodoAssignee> r211, String r212, Long r310, String r311, Boolean r312, MsgBelongTo r313, RichContent r314, List<TodoFollower> r315, TodoUser r316, Long r317, Long r318, TodoSource r319, Boolean r410, Map<String, Permission> r411, Boolean r412, CustomComplete r413, String r414, List<TodoReminder> r415, EntityNumInfo r416, TodoOwner r417, TaskMode r418, Long r419, Boolean r510) {
        this(r210, r211, r212, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, ByteString.EMPTY);
    }

    public TodoDetail(String r100, List<TodoAssignee> r101, String r102, Long r103, String r104, Boolean r105, MsgBelongTo r110, RichContent r111, List<TodoFollower> r112, TodoUser r113, Long r114, Long r115, TodoSource r116, Boolean r117, Map<String, Permission> r118, Boolean r119, CustomComplete r210, String r211, List<TodoReminder> r212, EntityNumInfo r213, TodoOwner r214, TaskMode r215, Long r216, Boolean r217, ByteString r218) {
        super(ADAPTER, r218);
        this.guid = r100;
        this.assignees = Internal.immutableCopyOf("assignees", r101);
        this.summary = r102;
        this.due_time = r103;
        this.due_timezone = r104;
        this.is_all_day = r105;
        this.msg_belong_to = r110;
        this.rich_summary = r111;
        this.followers = Internal.immutableCopyOf("followers", r112);
        this.creator = r113;
        this.completed_milli_time = r114;
        this.deleted_milli_time = r115;
        this.source = r116;
        this.can_follow = r117;
        this.user_to_permission = Internal.immutableCopyOf("user_to_permission", r118);
        this.user_complete_enabled = r119;
        this.custom_complete = r210;
        this.rrule = r211;
        this.reminders = Internal.immutableCopyOf("reminders", r212);
        this.entity_num = r213;
        this.owner = r214;
        this.mode = r215;
        this.start_milli_time = r216;
        this.is_milestone = r217;
    }
}
