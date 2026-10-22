package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class TaskView extends Message<TaskView, Builder> {
    public static final ProtoAdapter<TaskView> ADAPTER = null;
    public static final Boolean DEFAULT_ADMIN_SETTING = null;
    public static final Long DEFAULT_ADMIN_SETTING_UPDATE_USER_ID = null;
    public static final String DEFAULT_CONTAINER_GUID = "";
    public static final String DEFAULT_CONTAINER_KEY = "";
    public static final Long DEFAULT_DELETE_MILLI_TIME = null;
    public static final String DEFAULT_GUID = "";
    public static final Boolean DEFAULT_SHOW_SUB_TASKS = null;
    public static final Type DEFAULT_TYPE = null;
    public static final Long DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final Boolean admin_setting;
    public final Long admin_setting_update_user_id;
    public final String container_guid;
    public final String container_key;
    public final Long delete_milli_time;
    public final TaskViewFieldConfig field_config;
    public final GanttViewSetting gantt_view_setting;
    public final String guid;
    public final Boolean show_sub_tasks;
    public final Type type;
    public final Long version;
    public final TaskViewFields view_fields;
    public final TaskViewFilters view_filters;
    public final TaskViewGroups view_groups;
    public final TaskViewSorts view_sorts;

    public static final class Builder extends Message.Builder<TaskView, Builder> {
        public Boolean admin_setting;
        public Long admin_setting_update_user_id;
        public String container_guid;
        public String container_key;
        public Long delete_milli_time;
        public TaskViewFieldConfig field_config;
        public GanttViewSetting gantt_view_setting;
        public String guid;
        public Boolean show_sub_tasks;
        public Type type;
        public Long version;
        public TaskViewFields view_fields;
        public TaskViewFilters view_filters;
        public TaskViewGroups view_groups;
        public TaskViewSorts view_sorts;

        @Override // com.squareup.wire.Message.Builder
        public TaskView build() {
            return new TaskView(this.guid, this.type, this.view_fields, this.view_groups, this.view_sorts, this.view_filters, this.show_sub_tasks, this.container_guid, this.field_config, this.container_key, this.admin_setting, this.admin_setting_update_user_id, this.version, this.delete_milli_time, this.gantt_view_setting, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder admin_setting(Boolean r100) {
            this.admin_setting = r100;
            return this;
        }

        public Builder admin_setting_update_user_id(Long r100) {
            this.admin_setting_update_user_id = r100;
            return this;
        }

        public Builder container_guid(String r100) {
            this.container_guid = r100;
            return this;
        }

        public Builder container_key(String r100) {
            this.container_key = r100;
            return this;
        }

        public Builder delete_milli_time(Long r100) {
            this.delete_milli_time = r100;
            return this;
        }

        public Builder field_config(TaskViewFieldConfig r100) {
            this.field_config = r100;
            return this;
        }

        public Builder gantt_view_setting(GanttViewSetting r100) {
            this.gantt_view_setting = r100;
            return this;
        }

        public Builder guid(String r100) {
            this.guid = r100;
            return this;
        }

        public Builder show_sub_tasks(Boolean r100) {
            this.show_sub_tasks = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.type = r100;
            return this;
        }

        public Builder version(Long r100) {
            this.version = r100;
            return this;
        }

        public Builder view_fields(TaskViewFields r100) {
            this.view_fields = r100;
            return this;
        }

        public Builder view_filters(TaskViewFilters r100) {
            this.view_filters = r100;
            return this;
        }

        public Builder view_groups(TaskViewGroups r100) {
            this.view_groups = r100;
            return this;
        }

        public Builder view_sorts(TaskViewSorts r100) {
            this.view_sorts = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskView extends ProtoAdapter<TaskView> {
        public ProtoAdapter_TaskView() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskView.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskView decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.guid = "";
            r101.type = Type.UNKNOWN;
            Boolean r102 = Boolean.FALSE;
            r101.show_sub_tasks = r102;
            r101.container_guid = "";
            r101.container_key = "";
            r101.admin_setting = r102;
            r101.admin_setting_update_user_id = 0L;
            r101.version = 0L;
            r101.delete_milli_time = 0L;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L31;
            if (r104 != 100) goto L8;
            r101.version = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r104 != 101) goto L10;
            r101.delete_milli_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r104 != 201) goto L11;
            r101.gantt_view_setting(GanttViewSetting.ADAPTER.decode(r100));
            goto L3
        L11:
            switch(r104) {
                case 1: goto L27;
                case 2: goto L33;
                case 3: goto L22;
                case 4: goto L21;
                case 5: goto L20;
                case 6: goto L19;
                case 7: goto L18;
                case 8: goto L17;
                case 9: goto L16;
                case 10: goto L15;
                case 11: goto L14;
                case 12: goto L13;
                default: goto L12;
            };
        L33:
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L25
        L25:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L13:
            r101.admin_setting_update_user_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L14:
            r101.admin_setting = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L15:
            r101.container_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.field_config = TaskViewFieldConfig.ADAPTER.decode(r100);
            goto L3
        L17:
            r101.container_guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.show_sub_tasks = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L19:
            r101.view_filters = TaskViewFilters.ADAPTER.decode(r100);
            goto L3
        L20:
            r101.view_sorts = TaskViewSorts.ADAPTER.decode(r100);
            goto L3
        L21:
            r101.view_groups = TaskViewGroups.ADAPTER.decode(r100);
            goto L3
        L22:
            r101.view_fields = TaskViewFields.ADAPTER.decode(r100);
            goto L3
        L27:
            r101.guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L31:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TaskView r100) {
            String r101 = r100.guid;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Type r104 = r100.type;
            if (r104 == null) goto L9;
            int r105 = Type.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            TaskViewFields r107 = r100.view_fields;
            if (r107 == null) goto L13;
            int r108 = TaskViewFields.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            TaskViewGroups r110 = r100.view_groups;
            if (r110 == null) goto L17;
            int r111 = TaskViewGroups.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            TaskViewSorts r113 = r100.view_sorts;
            if (r113 == null) goto L21;
            int r114 = TaskViewSorts.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            TaskViewFilters r116 = r100.view_filters;
            if (r116 == null) goto L25;
            int r117 = TaskViewFilters.ADAPTER.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Boolean r119 = r100.show_sub_tasks;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            String r122 = r100.container_guid;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.STRING.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            TaskViewFieldConfig r125 = r100.field_config;
            if (r125 == null) goto L37;
            int r126 = TaskViewFieldConfig.ADAPTER.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            String r128 = r100.container_key;
            if (r128 == null) goto L41;
            int r129 = ProtoAdapter.STRING.encodedSizeWithTag(10, r128);
        L42:
            int r130 = r127 + r129;
            Boolean r131 = r100.admin_setting;
            if (r131 == null) goto L45;
            int r132 = ProtoAdapter.BOOL.encodedSizeWithTag(11, r131);
        L46:
            int r133 = r130 + r132;
            Long r134 = r100.admin_setting_update_user_id;
            if (r134 == null) goto L49;
            int r135 = ProtoAdapter.INT64.encodedSizeWithTag(12, r134);
        L50:
            int r136 = r133 + r135;
            Long r137 = r100.version;
            if (r137 == null) goto L53;
            int r138 = ProtoAdapter.INT64.encodedSizeWithTag(100, r137);
        L54:
            int r139 = r136 + r138;
            Long r140 = r100.delete_milli_time;
            if (r140 == null) goto L57;
            int r141 = ProtoAdapter.INT64.encodedSizeWithTag(101, r140);
        L58:
            int r142 = r139 + r141;
            GanttViewSetting r143 = r100.gantt_view_setting;
            if (r143 == null) goto L62;
            r102 = GanttViewSetting.ADAPTER.encodedSizeWithTag(201, r143);
        L62:
            return (r142 + r102) + r100.unknownFields().size();
        L57:
            r141 = 0;
            goto L58
        L53:
            r138 = 0;
            goto L54
        L49:
            r135 = 0;
            goto L50
        L45:
            r132 = 0;
            goto L46
        L41:
            r129 = 0;
            goto L42
        L37:
            r126 = 0;
            goto L38
        L33:
            r123 = 0;
            goto L34
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
        public /* bridge */ /* synthetic */ TaskView decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TaskView r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TaskView r101) throws IOException {
            String r102 = r101.guid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Type r103 = r101.type;
            if (r103 == null) goto L8;
            Type.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            TaskViewFields r104 = r101.view_fields;
            if (r104 == null) goto L11;
            TaskViewFields.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            TaskViewGroups r105 = r101.view_groups;
            if (r105 == null) goto L14;
            TaskViewGroups.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            TaskViewSorts r106 = r101.view_sorts;
            if (r106 == null) goto L17;
            TaskViewSorts.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            TaskViewFilters r107 = r101.view_filters;
            if (r107 == null) goto L20;
            TaskViewFilters.ADAPTER.encodeWithTag(r100, 6, r107);
        L20:
            Boolean r108 = r101.show_sub_tasks;
            if (r108 == null) goto L23;
            ProtoAdapter.BOOL.encodeWithTag(r100, 7, r108);
        L23:
            String r109 = r101.container_guid;
            if (r109 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r100, 8, r109);
        L26:
            TaskViewFieldConfig r110 = r101.field_config;
            if (r110 == null) goto L29;
            TaskViewFieldConfig.ADAPTER.encodeWithTag(r100, 9, r110);
        L29:
            String r111 = r101.container_key;
            if (r111 == null) goto L32;
            ProtoAdapter.STRING.encodeWithTag(r100, 10, r111);
        L32:
            Boolean r112 = r101.admin_setting;
            if (r112 == null) goto L35;
            ProtoAdapter.BOOL.encodeWithTag(r100, 11, r112);
        L35:
            Long r113 = r101.admin_setting_update_user_id;
            if (r113 == null) goto L38;
            ProtoAdapter.INT64.encodeWithTag(r100, 12, r113);
        L38:
            Long r114 = r101.version;
            if (r114 == null) goto L41;
            ProtoAdapter.INT64.encodeWithTag(r100, 100, r114);
        L41:
            Long r115 = r101.delete_milli_time;
            if (r115 == null) goto L44;
            ProtoAdapter.INT64.encodeWithTag(r100, 101, r115);
        L44:
            GanttViewSetting r116 = r101.gantt_view_setting;
            if (r116 == null) goto L47;
            GanttViewSetting.ADAPTER.encodeWithTag(r100, 201, r116);
        L47:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskView r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type CALENDAR = null;
        public static final Type GANTT = null;
        public static final Type KANBAN = null;
        public static final Type TABLE = null;
        public static final Type UNKNOWN = null;
        private final int value;

        static {
            Type r100 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Type r101 = new Type("TABLE", 1, 1);
            TABLE = r101;
            Type r102 = new Type("KANBAN", 2, 2);
            KANBAN = r102;
            Type r103 = new Type("GANTT", 3, 3);
            GANTT = r103;
            Type r104 = new Type("CALENDAR", 4, 4);
            CALENDAR = r104;
            $VALUES = new Type[]{r100, r101, r102, r103, r104};
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
            if (r100 == 0) goto L22;
            if (r100 == 1) goto L20;
            if (r100 == 2) goto L18;
            if (r100 == 3) goto L16;
            if (r100 == 4) goto L14;
            return null;
        L14:
            return CALENDAR;
        L16:
            return GANTT;
        L18:
            return KANBAN;
        L20:
            return TABLE;
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
        ADAPTER = new ProtoAdapter_TaskView();
        DEFAULT_TYPE = Type.UNKNOWN;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_SHOW_SUB_TASKS = r100;
        DEFAULT_ADMIN_SETTING = r100;
        DEFAULT_ADMIN_SETTING_UPDATE_USER_ID = 0L;
        DEFAULT_VERSION = 0L;
        DEFAULT_DELETE_MILLI_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.guid = this.guid;
        r100.type = this.type;
        r100.view_fields = this.view_fields;
        r100.view_groups = this.view_groups;
        r100.view_sorts = this.view_sorts;
        r100.view_filters = this.view_filters;
        r100.show_sub_tasks = this.show_sub_tasks;
        r100.container_guid = this.container_guid;
        r100.field_config = this.field_config;
        r100.container_key = this.container_key;
        r100.admin_setting = this.admin_setting;
        r100.admin_setting_update_user_id = this.admin_setting_update_user_id;
        r100.version = this.version;
        r100.delete_milli_time = this.delete_milli_time;
        r100.gantt_view_setting = this.gantt_view_setting;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TaskView.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TaskView(String r110, Type r111, TaskViewFields r210, TaskViewGroups r211, TaskViewSorts r212, TaskViewFilters r213, Boolean r214, String r215, TaskViewFieldConfig r216, String r217, Boolean r218, Long r219, Long r310, Long r311, GanttViewSetting r312) {
        this(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, ByteString.EMPTY);
    }

    public TaskView(String r100, Type r101, TaskViewFields r102, TaskViewGroups r103, TaskViewSorts r104, TaskViewFilters r105, Boolean r110, String r111, TaskViewFieldConfig r112, String r113, Boolean r114, Long r115, Long r116, Long r117, GanttViewSetting r118, ByteString r119) {
        super(ADAPTER, r119);
        this.guid = r100;
        this.type = r101;
        this.view_fields = r102;
        this.view_groups = r103;
        this.view_sorts = r104;
        this.view_filters = r105;
        this.show_sub_tasks = r110;
        this.container_guid = r111;
        this.field_config = r112;
        this.container_key = r113;
        this.admin_setting = r114;
        this.admin_setting_update_user_id = r115;
        this.version = r116;
        this.delete_milli_time = r117;
        this.gantt_view_setting = r118;
    }
}
