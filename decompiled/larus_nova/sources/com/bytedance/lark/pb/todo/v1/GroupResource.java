package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class GroupResource extends Message<GroupResource, Builder> {
    public static final ProtoAdapter<GroupResource> ADAPTER = null;
    public static final DateTimeGroupCategory DEFAULT_DATETIME_FIELD_GROUP = null;
    public static final DueTimeGroupCategory DEFAULT_DUE_TIME_GROUP = null;
    public static final StartTimeGroupCategory DEFAULT_START_TIME_GROUP = null;
    public static final Type DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;
    public final DateTimeGroupCategory datetime_field_group;
    public final DueTimeGroupCategory due_time_group;
    public final TaskSection section;
    public final SelectFieldOptionGroups select_field_option_group;
    public final TodoSourceOrigin source_origin;
    public final StartTimeGroupCategory start_time_group;
    public final Type type;
    public final TodoUsers users;

    public static final class Builder extends Message.Builder<GroupResource, Builder> {
        public DateTimeGroupCategory datetime_field_group;
        public DueTimeGroupCategory due_time_group;
        public TaskSection section;
        public SelectFieldOptionGroups select_field_option_group;
        public TodoSourceOrigin source_origin;
        public StartTimeGroupCategory start_time_group;
        public Type type;
        public TodoUsers users;

        @Override // com.squareup.wire.Message.Builder
        public GroupResource build() {
            return new GroupResource(this.type, this.section, this.users, this.due_time_group, this.source_origin, this.select_field_option_group, this.datetime_field_group, this.start_time_group, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder datetime_field_group(DateTimeGroupCategory r100) {
            this.datetime_field_group = r100;
            this.section = null;
            this.users = null;
            this.due_time_group = null;
            this.source_origin = null;
            this.select_field_option_group = null;
            this.start_time_group = null;
            return this;
        }

        public Builder due_time_group(DueTimeGroupCategory r100) {
            this.due_time_group = r100;
            this.section = null;
            this.users = null;
            this.source_origin = null;
            this.select_field_option_group = null;
            this.datetime_field_group = null;
            this.start_time_group = null;
            return this;
        }

        public Builder section(TaskSection r100) {
            this.section = r100;
            this.users = null;
            this.due_time_group = null;
            this.source_origin = null;
            this.select_field_option_group = null;
            this.datetime_field_group = null;
            this.start_time_group = null;
            return this;
        }

        public Builder select_field_option_group(SelectFieldOptionGroups r100) {
            this.select_field_option_group = r100;
            this.section = null;
            this.users = null;
            this.due_time_group = null;
            this.source_origin = null;
            this.datetime_field_group = null;
            this.start_time_group = null;
            return this;
        }

        public Builder source_origin(TodoSourceOrigin r100) {
            this.source_origin = r100;
            this.section = null;
            this.users = null;
            this.due_time_group = null;
            this.select_field_option_group = null;
            this.datetime_field_group = null;
            this.start_time_group = null;
            return this;
        }

        public Builder start_time_group(StartTimeGroupCategory r100) {
            this.start_time_group = r100;
            this.section = null;
            this.users = null;
            this.due_time_group = null;
            this.source_origin = null;
            this.select_field_option_group = null;
            this.datetime_field_group = null;
            return this;
        }

        public Builder type(Type r100) {
            this.type = r100;
            return this;
        }

        public Builder users(TodoUsers r100) {
            this.users = r100;
            this.section = null;
            this.due_time_group = null;
            this.source_origin = null;
            this.select_field_option_group = null;
            this.datetime_field_group = null;
            this.start_time_group = null;
            return this;
        }
    }

    public static final class ProtoAdapter_GroupResource extends ProtoAdapter<GroupResource> {
        public ProtoAdapter_GroupResource() {
            super(FieldEncoding.LENGTH_DELIMITED, GroupResource.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GroupResource decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.type = Type.UNKNOWN;
            r101.due_time_group(DueTimeGroupCategory.UNKNOWN_DUE_TIME);
            r101.datetime_field_group(DateTimeGroupCategory.UNKNOWN_DATE_TIME);
            r101.start_time_group(StartTimeGroupCategory.UNKNOWN_START_TIME);
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L29;
            if (r103 != 1) goto L7;
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L27
        L27:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            switch(r103) {
                case 100: goto L24;
                case 101: goto L23;
                case 102: goto L33;
                case 103: goto L18;
                case 104: goto L17;
                case 105: goto L31;
                case 106: goto L37;
                default: goto L8;
            };
        L31:
            r101.datetime_field_group(DateTimeGroupCategory.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L33:
            r101.due_time_group(DueTimeGroupCategory.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
        L21:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L37:
            r101.start_time_group(StartTimeGroupCategory.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
        L11:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L17:
            r101.select_field_option_group(SelectFieldOptionGroups.ADAPTER.decode(r100));
            goto L3
        L18:
            r101.source_origin(TodoSourceOrigin.ADAPTER.decode(r100));
            goto L3
        L23:
            r101.users(TodoUsers.ADAPTER.decode(r100));
            goto L3
        L24:
            r101.section(TaskSection.ADAPTER.decode(r100));
            goto L3
        L8:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L29:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GroupResource r100) {
            Type r101 = r100.type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = Type.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            TaskSection r104 = r100.section;
            if (r104 == null) goto L9;
            int r105 = TaskSection.ADAPTER.encodedSizeWithTag(100, r104);
        L10:
            int r106 = r103 + r105;
            TodoUsers r107 = r100.users;
            if (r107 == null) goto L13;
            int r108 = TodoUsers.ADAPTER.encodedSizeWithTag(101, r107);
        L14:
            int r109 = r106 + r108;
            DueTimeGroupCategory r110 = r100.due_time_group;
            if (r110 == null) goto L17;
            int r111 = DueTimeGroupCategory.ADAPTER.encodedSizeWithTag(102, r110);
        L18:
            int r112 = r109 + r111;
            TodoSourceOrigin r113 = r100.source_origin;
            if (r113 == null) goto L21;
            int r114 = TodoSourceOrigin.ADAPTER.encodedSizeWithTag(103, r113);
        L22:
            int r115 = r112 + r114;
            SelectFieldOptionGroups r116 = r100.select_field_option_group;
            if (r116 == null) goto L25;
            int r117 = SelectFieldOptionGroups.ADAPTER.encodedSizeWithTag(104, r116);
        L26:
            int r118 = r115 + r117;
            DateTimeGroupCategory r119 = r100.datetime_field_group;
            if (r119 == null) goto L29;
            int r120 = DateTimeGroupCategory.ADAPTER.encodedSizeWithTag(105, r119);
        L30:
            int r121 = r118 + r120;
            StartTimeGroupCategory r122 = r100.start_time_group;
            if (r122 == null) goto L34;
            r102 = StartTimeGroupCategory.ADAPTER.encodedSizeWithTag(106, r122);
        L34:
            return (r121 + r102) + r100.unknownFields().size();
        L29:
            r120 = 0;
            goto L30
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
        public /* bridge */ /* synthetic */ GroupResource decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GroupResource r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GroupResource r101) throws IOException {
            Type r102 = r101.type;
            if (r102 == null) goto L5;
            Type.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            TaskSection r103 = r101.section;
            if (r103 == null) goto L8;
            TaskSection.ADAPTER.encodeWithTag(r100, 100, r103);
        L8:
            TodoUsers r104 = r101.users;
            if (r104 == null) goto L11;
            TodoUsers.ADAPTER.encodeWithTag(r100, 101, r104);
        L11:
            DueTimeGroupCategory r105 = r101.due_time_group;
            if (r105 == null) goto L14;
            DueTimeGroupCategory.ADAPTER.encodeWithTag(r100, 102, r105);
        L14:
            TodoSourceOrigin r106 = r101.source_origin;
            if (r106 == null) goto L17;
            TodoSourceOrigin.ADAPTER.encodeWithTag(r100, 103, r106);
        L17:
            SelectFieldOptionGroups r107 = r101.select_field_option_group;
            if (r107 == null) goto L20;
            SelectFieldOptionGroups.ADAPTER.encodeWithTag(r100, 104, r107);
        L20:
            DateTimeGroupCategory r108 = r101.datetime_field_group;
            if (r108 == null) goto L23;
            DateTimeGroupCategory.ADAPTER.encodeWithTag(r100, 105, r108);
        L23:
            StartTimeGroupCategory r109 = r101.start_time_group;
            if (r109 == null) goto L26;
            StartTimeGroupCategory.ADAPTER.encodeWithTag(r100, 106, r109);
        L26:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GroupResource r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type DATETIME_FIELD = null;
        public static final Type DATE_TIME_GROUP_CATEGORY = null;
        public static final Type DUE_TIME_GROUP_CATEGORY = null;
        public static final Type SELECT_FIELD = null;
        public static final Type START_TIME_GROUP_CATEGORY = null;
        public static final Type TASK_SECTION = null;
        public static final Type TODO_SOURCE_ORIGIN = null;
        public static final Type TODO_USERS = null;
        public static final Type UNKNOWN = null;
        private final int value;

        static {
            Type r100 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Type r101 = new Type("TASK_SECTION", 1, 1);
            TASK_SECTION = r101;
            Type r102 = new Type("TODO_USERS", 2, 2);
            TODO_USERS = r102;
            Type r103 = new Type("DUE_TIME_GROUP_CATEGORY", 3, 3);
            DUE_TIME_GROUP_CATEGORY = r103;
            Type r104 = new Type("TODO_SOURCE_ORIGIN", 4, 4);
            TODO_SOURCE_ORIGIN = r104;
            Type r105 = new Type("SELECT_FIELD", 5, 5);
            SELECT_FIELD = r105;
            Type r110 = new Type("DATETIME_FIELD", 6, 6);
            DATETIME_FIELD = r110;
            Type r111 = new Type("DATE_TIME_GROUP_CATEGORY", 7, 7);
            DATE_TIME_GROUP_CATEGORY = r111;
            Type r112 = new Type("START_TIME_GROUP_CATEGORY", 8, 8);
            START_TIME_GROUP_CATEGORY = r112;
            $VALUES = new Type[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
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
                case 0: goto L22;
                case 1: goto L20;
                case 2: goto L18;
                case 3: goto L16;
                case 4: goto L14;
                case 5: goto L12;
                case 6: goto L10;
                case 7: goto L8;
                case 8: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return START_TIME_GROUP_CATEGORY;
        L8:
            return DATE_TIME_GROUP_CATEGORY;
        L10:
            return DATETIME_FIELD;
        L12:
            return SELECT_FIELD;
        L14:
            return TODO_SOURCE_ORIGIN;
        L16:
            return DUE_TIME_GROUP_CATEGORY;
        L18:
            return TODO_USERS;
        L20:
            return TASK_SECTION;
        L22:
            return UNKNOWN;
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        private Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GroupResource();
        DEFAULT_TYPE = Type.UNKNOWN;
        DEFAULT_DUE_TIME_GROUP = DueTimeGroupCategory.UNKNOWN_DUE_TIME;
        DEFAULT_DATETIME_FIELD_GROUP = DateTimeGroupCategory.UNKNOWN_DATE_TIME;
        DEFAULT_START_TIME_GROUP = StartTimeGroupCategory.UNKNOWN_START_TIME;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.type = this.type;
        r100.section = this.section;
        r100.users = this.users;
        r100.due_time_group = this.due_time_group;
        r100.source_origin = this.source_origin;
        r100.select_field_option_group = this.select_field_option_group;
        r100.datetime_field_group = this.datetime_field_group;
        r100.start_time_group = this.start_time_group;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GroupResource.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GroupResource(Type r110, TaskSection r111, TodoUsers r112, DueTimeGroupCategory r113, TodoSourceOrigin r114, SelectFieldOptionGroups r115, DateTimeGroupCategory r116, StartTimeGroupCategory r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
    }

    public GroupResource(Type r100, TaskSection r101, TodoUsers r102, DueTimeGroupCategory r103, TodoSourceOrigin r104, SelectFieldOptionGroups r105, DateTimeGroupCategory r106, StartTimeGroupCategory r110, ByteString r111) {
        super(ADAPTER, r111);
        if (Internal.countNonNull(r101, r102, r103, r104, new Object[]{r105, r106, r110}) > 1) goto L7;
        this.type = r100;
        this.section = r101;
        this.users = r102;
        this.due_time_group = r103;
        this.source_origin = r104;
        this.select_field_option_group = r105;
        this.datetime_field_group = r106;
        this.start_time_group = r110;
        return;
    L7:
        throw new IllegalArgumentException("at most one of section, users, due_time_group, source_origin, select_field_option_group, datetime_field_group, start_time_group may be non-null");
    }
}
