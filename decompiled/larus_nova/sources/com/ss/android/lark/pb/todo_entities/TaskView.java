package com.ss.android.lark.pb.todo_entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class TaskView extends Message<TaskView, Builder> {
    public static final ProtoAdapter<TaskView> ADAPTER = null;
    public static final Boolean DEFAULT_ADMIN_SETTING = null;
    public static final Long DEFAULT_ADMIN_SETTING_UPDATE_USER_ID = null;
    public static final String DEFAULT_CONTAINER_GUID = "";
    public static final String DEFAULT_CONTAINER_KEY = "";
    public static final Long DEFAULT_DELETE_MILLI_TIME = null;
    public static final String DEFAULT_GUID = "";
    public static final Boolean DEFAULT_SHOW_SUB_TASKS = null;
    public static final Long DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final Boolean madmin_setting;
    public final Long madmin_setting_update_user_id;
    public final String mcontainer_guid;
    public final String mcontainer_key;
    public final Long mdelete_milli_time;
    public final TaskViewFieldConfig mfield_config;
    public final GanttViewSetting mgantt_view_setting;
    public final String mguid;
    public final Boolean mshow_sub_tasks;
    public final Type mtype;
    public final Long mversion;
    public final TaskViewFields mview_fields;
    public final TaskViewFilters mview_filters;
    public final TaskViewGroups mview_groups;
    public final TaskViewSorts mview_sorts;

    public static final class Builder extends Message.Builder<TaskView, Builder> {
        public Boolean madmin_setting;
        public Long madmin_setting_update_user_id;
        public String mcontainer_guid;
        public String mcontainer_key;
        public Long mdelete_milli_time;
        public TaskViewFieldConfig mfield_config;
        public GanttViewSetting mgantt_view_setting;
        public String mguid;
        public Boolean mshow_sub_tasks;
        public Type mtype;
        public Long mversion;
        public TaskViewFields mview_fields;
        public TaskViewFilters mview_filters;
        public TaskViewGroups mview_groups;
        public TaskViewSorts mview_sorts;

        @Override // com.squareup.wire.Message.Builder
        public TaskView build() {
            return new TaskView(this.mguid, this.mtype, this.mview_fields, this.mview_groups, this.mview_sorts, this.mview_filters, this.mshow_sub_tasks, this.mcontainer_guid, this.mfield_config, this.mcontainer_key, this.madmin_setting, this.madmin_setting_update_user_id, this.mversion, this.mdelete_milli_time, this.mgantt_view_setting, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder admin_setting(Boolean r100) {
            this.madmin_setting = r100;
            return this;
        }

        public Builder admin_setting_update_user_id(Long r100) {
            this.madmin_setting_update_user_id = r100;
            return this;
        }

        public Builder container_guid(String r100) {
            this.mcontainer_guid = r100;
            return this;
        }

        public Builder container_key(String r100) {
            this.mcontainer_key = r100;
            return this;
        }

        public Builder delete_milli_time(Long r100) {
            this.mdelete_milli_time = r100;
            return this;
        }

        public Builder field_config(TaskViewFieldConfig r100) {
            this.mfield_config = r100;
            return this;
        }

        public Builder gantt_view_setting(GanttViewSetting r100) {
            this.mgantt_view_setting = r100;
            return this;
        }

        public Builder guid(String r100) {
            this.mguid = r100;
            return this;
        }

        public Builder show_sub_tasks(Boolean r100) {
            this.mshow_sub_tasks = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.mtype = r100;
            return this;
        }

        public Builder version(Long r100) {
            this.mversion = r100;
            return this;
        }

        public Builder view_fields(TaskViewFields r100) {
            this.mview_fields = r100;
            return this;
        }

        public Builder view_filters(TaskViewFilters r100) {
            this.mview_filters = r100;
            return this;
        }

        public Builder view_groups(TaskViewGroups r100) {
            this.mview_groups = r100;
            return this;
        }

        public Builder view_sorts(TaskViewSorts r100) {
            this.mview_sorts = r100;
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
            r101.mguid = "";
            Boolean r102 = Boolean.FALSE;
            r101.mshow_sub_tasks = r102;
            r101.mcontainer_guid = "";
            r101.mcontainer_key = "";
            r101.madmin_setting = r102;
            r101.madmin_setting_update_user_id = 0L;
            r101.mversion = 0L;
            r101.mdelete_milli_time = 0L;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L31;
            if (r104 != 100) goto L8;
            r101.mversion = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r104 != 101) goto L10;
            r101.mdelete_milli_time = ProtoAdapter.INT64.decode(r100);
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
            r101.mtype = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L25
        L25:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L13:
            r101.madmin_setting_update_user_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L14:
            r101.madmin_setting = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L15:
            r101.mcontainer_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.mfield_config = TaskViewFieldConfig.ADAPTER.decode(r100);
            goto L3
        L17:
            r101.mcontainer_guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.mshow_sub_tasks = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L19:
            r101.mview_filters = TaskViewFilters.ADAPTER.decode(r100);
            goto L3
        L20:
            r101.mview_sorts = TaskViewSorts.ADAPTER.decode(r100);
            goto L3
        L21:
            r101.mview_groups = TaskViewGroups.ADAPTER.decode(r100);
            goto L3
        L22:
            r101.mview_fields = TaskViewFields.ADAPTER.decode(r100);
            goto L3
        L27:
            r101.mguid = ProtoAdapter.STRING.decode(r100);
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
            String r101 = r100.mguid;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Type r104 = r100.mtype;
            if (r104 == null) goto L9;
            int r105 = Type.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            TaskViewFields r107 = r100.mview_fields;
            if (r107 == null) goto L13;
            int r108 = TaskViewFields.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            TaskViewGroups r110 = r100.mview_groups;
            if (r110 == null) goto L17;
            int r111 = TaskViewGroups.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            TaskViewSorts r113 = r100.mview_sorts;
            if (r113 == null) goto L21;
            int r114 = TaskViewSorts.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            TaskViewFilters r116 = r100.mview_filters;
            if (r116 == null) goto L25;
            int r117 = TaskViewFilters.ADAPTER.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Boolean r119 = r100.mshow_sub_tasks;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            String r122 = r100.mcontainer_guid;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.STRING.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            TaskViewFieldConfig r125 = r100.mfield_config;
            if (r125 == null) goto L37;
            int r126 = TaskViewFieldConfig.ADAPTER.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            String r128 = r100.mcontainer_key;
            if (r128 == null) goto L41;
            int r129 = ProtoAdapter.STRING.encodedSizeWithTag(10, r128);
        L42:
            int r130 = r127 + r129;
            Boolean r131 = r100.madmin_setting;
            if (r131 == null) goto L45;
            int r132 = ProtoAdapter.BOOL.encodedSizeWithTag(11, r131);
        L46:
            int r133 = r130 + r132;
            Long r134 = r100.madmin_setting_update_user_id;
            if (r134 == null) goto L49;
            int r135 = ProtoAdapter.INT64.encodedSizeWithTag(12, r134);
        L50:
            int r136 = r133 + r135;
            Long r137 = r100.mversion;
            if (r137 == null) goto L53;
            int r138 = ProtoAdapter.INT64.encodedSizeWithTag(100, r137);
        L54:
            int r139 = r136 + r138;
            Long r140 = r100.mdelete_milli_time;
            if (r140 == null) goto L57;
            int r141 = ProtoAdapter.INT64.encodedSizeWithTag(101, r140);
        L58:
            int r142 = r139 + r141;
            GanttViewSetting r143 = r100.mgantt_view_setting;
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
            String r102 = r101.mguid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Type r103 = r101.mtype;
            if (r103 == null) goto L8;
            Type.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            TaskViewFields r104 = r101.mview_fields;
            if (r104 == null) goto L11;
            TaskViewFields.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            TaskViewGroups r105 = r101.mview_groups;
            if (r105 == null) goto L14;
            TaskViewGroups.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            TaskViewSorts r106 = r101.mview_sorts;
            if (r106 == null) goto L17;
            TaskViewSorts.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            TaskViewFilters r107 = r101.mview_filters;
            if (r107 == null) goto L20;
            TaskViewFilters.ADAPTER.encodeWithTag(r100, 6, r107);
        L20:
            Boolean r108 = r101.mshow_sub_tasks;
            if (r108 == null) goto L23;
            ProtoAdapter.BOOL.encodeWithTag(r100, 7, r108);
        L23:
            String r109 = r101.mcontainer_guid;
            if (r109 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r100, 8, r109);
        L26:
            TaskViewFieldConfig r110 = r101.mfield_config;
            if (r110 == null) goto L29;
            TaskViewFieldConfig.ADAPTER.encodeWithTag(r100, 9, r110);
        L29:
            String r111 = r101.mcontainer_key;
            if (r111 == null) goto L32;
            ProtoAdapter.STRING.encodeWithTag(r100, 10, r111);
        L32:
            Boolean r112 = r101.madmin_setting;
            if (r112 == null) goto L35;
            ProtoAdapter.BOOL.encodeWithTag(r100, 11, r112);
        L35:
            Long r113 = r101.madmin_setting_update_user_id;
            if (r113 == null) goto L38;
            ProtoAdapter.INT64.encodeWithTag(r100, 12, r113);
        L38:
            Long r114 = r101.mversion;
            if (r114 == null) goto L41;
            ProtoAdapter.INT64.encodeWithTag(r100, 100, r114);
        L41:
            Long r115 = r101.mdelete_milli_time;
            if (r115 == null) goto L44;
            ProtoAdapter.INT64.encodeWithTag(r100, 101, r115);
        L44:
            GanttViewSetting r116 = r101.mgantt_view_setting;
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

    public static final class TaskViewField extends Message<TaskViewField, Builder> {
        public static final ProtoAdapter<TaskViewField> ADAPTER = null;
        public static final String DEFAULT_FIELD_KEY = "";
        public static final Boolean DEFAULT_VISIBLE = null;
        private static final long serialVersionUID = 0;
        public final String mfield_key;
        public final Boolean mvisible;

        public static final class Builder extends Message.Builder<TaskViewField, Builder> {
            public String mfield_key;
            public Boolean mvisible;

            @Override // com.squareup.wire.Message.Builder
            public TaskViewField build() {
                return new TaskViewField(this.mfield_key, this.mvisible, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder field_key(String r100) {
                this.mfield_key = r100;
                return this;
            }

            public Builder visible(Boolean r100) {
                this.mvisible = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_TaskViewField extends ProtoAdapter<TaskViewField> {
            public ProtoAdapter_TaskViewField() {
                super(FieldEncoding.LENGTH_DELIMITED, TaskViewField.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TaskViewField decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mfield_key = "";
                r101.mvisible = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.mfield_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.mvisible = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(TaskViewField r100) {
                String r101 = r100.mfield_key;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                Boolean r104 = r100.mvisible;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ TaskViewField decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TaskViewField r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TaskViewField r101) throws IOException {
                String r102 = r101.mfield_key;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                Boolean r103 = r101.mvisible;
                if (r103 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskViewField r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TaskViewField();
            DEFAULT_VISIBLE = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mfield_key = this.mfield_key;
            r100.mvisible = this.mvisible;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TaskViewField.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public TaskViewField(String r100, Boolean r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public TaskViewField(String r100, Boolean r101, ByteString r102) {
            super(ADAPTER, r102);
            this.mfield_key = r100;
            this.mvisible = r101;
        }
    }

    public static final class TaskViewFieldConfig extends Message<TaskViewFieldConfig, Builder> {
        public static final ProtoAdapter<TaskViewFieldConfig> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> menable_filter_field_keys;
        public final List<String> menable_group_field_keys;
        public final List<String> menable_sort_field_keys;
        public final List<String> menable_system_field_keys;

        public static final class Builder extends Message.Builder<TaskViewFieldConfig, Builder> {
            public List<String> menable_filter_field_keys;
            public List<String> menable_group_field_keys;
            public List<String> menable_sort_field_keys;
            public List<String> menable_system_field_keys;

            @Override // com.squareup.wire.Message.Builder
            public TaskViewFieldConfig build() {
                return new TaskViewFieldConfig(this.menable_system_field_keys, this.menable_filter_field_keys, this.menable_group_field_keys, this.menable_sort_field_keys, super.buildUnknownFields());
            }

            public Builder() {
                this.menable_system_field_keys = Internal.newMutableList();
                this.menable_filter_field_keys = Internal.newMutableList();
                this.menable_group_field_keys = Internal.newMutableList();
                this.menable_sort_field_keys = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder enable_filter_field_keys(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.menable_filter_field_keys = r100;
                return this;
            }

            public Builder enable_group_field_keys(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.menable_group_field_keys = r100;
                return this;
            }

            public Builder enable_sort_field_keys(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.menable_sort_field_keys = r100;
                return this;
            }

            public Builder enable_system_field_keys(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.menable_system_field_keys = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_TaskViewFieldConfig extends ProtoAdapter<TaskViewFieldConfig> {
            public ProtoAdapter_TaskViewFieldConfig() {
                super(FieldEncoding.LENGTH_DELIMITED, TaskViewFieldConfig.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TaskViewFieldConfig decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.menable_system_field_keys.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.menable_filter_field_keys.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.menable_group_field_keys.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.menable_sort_field_keys.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L13:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L18:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(TaskViewFieldConfig r100) {
                ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                return (((r101.asRepeated().encodedSizeWithTag(1, r100.menable_system_field_keys) + r101.asRepeated().encodedSizeWithTag(2, r100.menable_filter_field_keys)) + r101.asRepeated().encodedSizeWithTag(3, r100.menable_group_field_keys)) + r101.asRepeated().encodedSizeWithTag(4, r100.menable_sort_field_keys)) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ TaskViewFieldConfig decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TaskViewFieldConfig r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TaskViewFieldConfig r101) throws IOException {
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                r102.asRepeated().encodeWithTag(r100, 1, r101.menable_system_field_keys);
                r102.asRepeated().encodeWithTag(r100, 2, r101.menable_filter_field_keys);
                r102.asRepeated().encodeWithTag(r100, 3, r101.menable_group_field_keys);
                r102.asRepeated().encodeWithTag(r100, 4, r101.menable_sort_field_keys);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskViewFieldConfig r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TaskViewFieldConfig();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.menable_system_field_keys = Internal.copyOf("menable_system_field_keys", this.menable_system_field_keys);
            r100.menable_filter_field_keys = Internal.copyOf("menable_filter_field_keys", this.menable_filter_field_keys);
            r100.menable_group_field_keys = Internal.copyOf("menable_group_field_keys", this.menable_group_field_keys);
            r100.menable_sort_field_keys = Internal.copyOf("menable_sort_field_keys", this.menable_sort_field_keys);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TaskViewFieldConfig.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public TaskViewFieldConfig(List<String> r100, List<String> r101, List<String> r102, List<String> r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public TaskViewFieldConfig(List<String> r100, List<String> r101, List<String> r102, List<String> r103, ByteString r104) {
            super(ADAPTER, r104);
            this.menable_system_field_keys = Internal.immutableCopyOf("menable_system_field_keys", r100);
            this.menable_filter_field_keys = Internal.immutableCopyOf("menable_filter_field_keys", r101);
            this.menable_group_field_keys = Internal.immutableCopyOf("menable_group_field_keys", r102);
            this.menable_sort_field_keys = Internal.immutableCopyOf("menable_sort_field_keys", r103);
        }
    }

    public static final class TaskViewFields extends Message<TaskViewFields, Builder> {
        public static final ProtoAdapter<TaskViewFields> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<TaskViewField> mfields;

        public static final class Builder extends Message.Builder<TaskViewFields, Builder> {
            public List<TaskViewField> mfields;

            @Override // com.squareup.wire.Message.Builder
            public TaskViewFields build() {
                return new TaskViewFields(this.mfields, super.buildUnknownFields());
            }

            public Builder() {
                this.mfields = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder fields(List<TaskViewField> r100) {
                Internal.checkElementsNotNull(r100);
                this.mfields = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_TaskViewFields extends ProtoAdapter<TaskViewFields> {
            public ProtoAdapter_TaskViewFields() {
                super(FieldEncoding.LENGTH_DELIMITED, TaskViewFields.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TaskViewFields decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.mfields.add(TaskViewField.ADAPTER.decode(r100));
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L9:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(TaskViewFields r100) {
                return TaskViewField.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.mfields) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ TaskViewFields decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TaskViewFields r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TaskViewFields r101) throws IOException {
                TaskViewField.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.mfields);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskViewFields r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TaskViewFields();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mfields = Internal.copyOf("mfields", this.mfields);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TaskViewFields.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public TaskViewFields(List<TaskViewField> r100) {
            this(r100, ByteString.EMPTY);
        }

        public TaskViewFields(List<TaskViewField> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.mfields = Internal.immutableCopyOf("mfields", r100);
        }
    }

    public static final class TaskViewFilters extends Message<TaskViewFilters, Builder> {
        public static final ProtoAdapter<TaskViewFilters> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<FilterCondition> mconditions;
        public final FilterConjunction mconjunction;

        public static final class Builder extends Message.Builder<TaskViewFilters, Builder> {
            public List<FilterCondition> mconditions;
            public FilterConjunction mconjunction;

            @Override // com.squareup.wire.Message.Builder
            public TaskViewFilters build() {
                return new TaskViewFilters(this.mconjunction, this.mconditions, super.buildUnknownFields());
            }

            public Builder() {
                this.mconditions = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder conditions(List<FilterCondition> r100) {
                Internal.checkElementsNotNull(r100);
                this.mconditions = r100;
                return this;
            }

            public Builder conjunction(FilterConjunction r100) {
                this.mconjunction = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_TaskViewFilters extends ProtoAdapter<TaskViewFilters> {
            public ProtoAdapter_TaskViewFilters() {
                super(FieldEncoding.LENGTH_DELIMITED, TaskViewFilters.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TaskViewFilters decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.mconjunction = FilterConjunction.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.mconditions.add(FilterCondition.ADAPTER.decode(r100));
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L15:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(TaskViewFilters r100) {
                FilterConjunction r101 = r100.mconjunction;
                if (r101 == null) goto L5;
                int r102 = FilterConjunction.ADAPTER.encodedSizeWithTag(1, r101);
            L7:
                return (r102 + FilterCondition.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.mconditions)) + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ TaskViewFilters decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TaskViewFilters r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TaskViewFilters r101) throws IOException {
                FilterConjunction r102 = r101.mconjunction;
                if (r102 == null) goto L5;
                FilterConjunction.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                FilterCondition.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.mconditions);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskViewFilters r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TaskViewFilters();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mconjunction = this.mconjunction;
            r100.mconditions = Internal.copyOf("mconditions", this.mconditions);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TaskViewFilters.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public TaskViewFilters(FilterConjunction r100, List<FilterCondition> r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public TaskViewFilters(FilterConjunction r100, List<FilterCondition> r101, ByteString r102) {
            super(ADAPTER, r102);
            this.mconjunction = r100;
            this.mconditions = Internal.immutableCopyOf("mconditions", r101);
        }
    }

    public static final class TaskViewGroup extends Message<TaskViewGroup, Builder> {
        public static final ProtoAdapter<TaskViewGroup> ADAPTER = null;
        public static final String DEFAULT_FIELD_KEY = "";
        private static final long serialVersionUID = 0;
        public final String mfield_key;

        public static final class Builder extends Message.Builder<TaskViewGroup, Builder> {
            public String mfield_key;

            @Override // com.squareup.wire.Message.Builder
            public TaskViewGroup build() {
                return new TaskViewGroup(this.mfield_key, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder field_key(String r100) {
                this.mfield_key = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_TaskViewGroup extends ProtoAdapter<TaskViewGroup> {
            public ProtoAdapter_TaskViewGroup() {
                super(FieldEncoding.LENGTH_DELIMITED, TaskViewGroup.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TaskViewGroup decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mfield_key = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.mfield_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L9:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(TaskViewGroup r100) {
                String r101 = r100.mfield_key;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ TaskViewGroup decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TaskViewGroup r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TaskViewGroup r101) throws IOException {
                String r102 = r101.mfield_key;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskViewGroup r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TaskViewGroup();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mfield_key = this.mfield_key;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TaskViewGroup.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public TaskViewGroup(String r100) {
            this(r100, ByteString.EMPTY);
        }

        public TaskViewGroup(String r100, ByteString r101) {
            super(ADAPTER, r101);
            this.mfield_key = r100;
        }
    }

    public static final class TaskViewGroups extends Message<TaskViewGroups, Builder> {
        public static final ProtoAdapter<TaskViewGroups> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<TaskViewGroup> mgroups;

        public static final class Builder extends Message.Builder<TaskViewGroups, Builder> {
            public List<TaskViewGroup> mgroups;

            @Override // com.squareup.wire.Message.Builder
            public TaskViewGroups build() {
                return new TaskViewGroups(this.mgroups, super.buildUnknownFields());
            }

            public Builder() {
                this.mgroups = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder groups(List<TaskViewGroup> r100) {
                Internal.checkElementsNotNull(r100);
                this.mgroups = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_TaskViewGroups extends ProtoAdapter<TaskViewGroups> {
            public ProtoAdapter_TaskViewGroups() {
                super(FieldEncoding.LENGTH_DELIMITED, TaskViewGroups.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TaskViewGroups decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.mgroups.add(TaskViewGroup.ADAPTER.decode(r100));
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L9:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(TaskViewGroups r100) {
                return TaskViewGroup.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.mgroups) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ TaskViewGroups decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TaskViewGroups r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TaskViewGroups r101) throws IOException {
                TaskViewGroup.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.mgroups);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskViewGroups r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TaskViewGroups();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mgroups = Internal.copyOf("mgroups", this.mgroups);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TaskViewGroups.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public TaskViewGroups(List<TaskViewGroup> r100) {
            this(r100, ByteString.EMPTY);
        }

        public TaskViewGroups(List<TaskViewGroup> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.mgroups = Internal.immutableCopyOf("mgroups", r100);
        }
    }

    public static final class TaskViewSort extends Message<TaskViewSort, Builder> {
        public static final ProtoAdapter<TaskViewSort> ADAPTER = null;
        public static final String DEFAULT_FIELD_KEY = "";
        private static final long serialVersionUID = 0;
        public final String mfield_key;
        public final OrderType morder;

        public static final class Builder extends Message.Builder<TaskViewSort, Builder> {
            public String mfield_key;
            public OrderType morder;

            @Override // com.squareup.wire.Message.Builder
            public TaskViewSort build() {
                return new TaskViewSort(this.mfield_key, this.morder, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder field_key(String r100) {
                this.mfield_key = r100;
                return this;
            }

            public Builder order(OrderType r100) {
                this.morder = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_TaskViewSort extends ProtoAdapter<TaskViewSort> {
            public ProtoAdapter_TaskViewSort() {
                super(FieldEncoding.LENGTH_DELIMITED, TaskViewSort.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TaskViewSort decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mfield_key = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.mfield_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.morder = OrderType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
            L12:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L15:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(TaskViewSort r100) {
                String r101 = r100.mfield_key;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                OrderType r104 = r100.morder;
                if (r104 == null) goto L10;
                r102 = OrderType.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ TaskViewSort decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TaskViewSort r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TaskViewSort r101) throws IOException {
                String r102 = r101.mfield_key;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                OrderType r103 = r101.morder;
                if (r103 == null) goto L8;
                OrderType.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskViewSort r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TaskViewSort();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mfield_key = this.mfield_key;
            r100.morder = this.morder;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TaskViewSort.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public TaskViewSort(String r100, OrderType r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public TaskViewSort(String r100, OrderType r101, ByteString r102) {
            super(ADAPTER, r102);
            this.mfield_key = r100;
            this.morder = r101;
        }
    }

    public static final class TaskViewSorts extends Message<TaskViewSorts, Builder> {
        public static final ProtoAdapter<TaskViewSorts> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<TaskViewSort> msorts;

        public static final class Builder extends Message.Builder<TaskViewSorts, Builder> {
            public List<TaskViewSort> msorts;

            @Override // com.squareup.wire.Message.Builder
            public TaskViewSorts build() {
                return new TaskViewSorts(this.msorts, super.buildUnknownFields());
            }

            public Builder() {
                this.msorts = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder sorts(List<TaskViewSort> r100) {
                Internal.checkElementsNotNull(r100);
                this.msorts = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_TaskViewSorts extends ProtoAdapter<TaskViewSorts> {
            public ProtoAdapter_TaskViewSorts() {
                super(FieldEncoding.LENGTH_DELIMITED, TaskViewSorts.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TaskViewSorts decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.msorts.add(TaskViewSort.ADAPTER.decode(r100));
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L9:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(TaskViewSorts r100) {
                return TaskViewSort.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.msorts) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ TaskViewSorts decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TaskViewSorts r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TaskViewSorts r101) throws IOException {
                TaskViewSort.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.msorts);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskViewSorts r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TaskViewSorts();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.msorts = Internal.copyOf("msorts", this.msorts);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TaskViewSorts.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public TaskViewSorts(List<TaskViewSort> r100) {
            this(r100, ByteString.EMPTY);
        }

        public TaskViewSorts(List<TaskViewSort> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.msorts = Internal.immutableCopyOf("msorts", r100);
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
        r100.mguid = this.mguid;
        r100.mtype = this.mtype;
        r100.mview_fields = this.mview_fields;
        r100.mview_groups = this.mview_groups;
        r100.mview_sorts = this.mview_sorts;
        r100.mview_filters = this.mview_filters;
        r100.mshow_sub_tasks = this.mshow_sub_tasks;
        r100.mcontainer_guid = this.mcontainer_guid;
        r100.mfield_config = this.mfield_config;
        r100.mcontainer_key = this.mcontainer_key;
        r100.madmin_setting = this.madmin_setting;
        r100.madmin_setting_update_user_id = this.madmin_setting_update_user_id;
        r100.mversion = this.mversion;
        r100.mdelete_milli_time = this.mdelete_milli_time;
        r100.mgantt_view_setting = this.mgantt_view_setting;
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
        this.mguid = r100;
        this.mtype = r101;
        this.mview_fields = r102;
        this.mview_groups = r103;
        this.mview_sorts = r104;
        this.mview_filters = r105;
        this.mshow_sub_tasks = r110;
        this.mcontainer_guid = r111;
        this.mfield_config = r112;
        this.mcontainer_key = r113;
        this.madmin_setting = r114;
        this.madmin_setting_update_user_id = r115;
        this.mversion = r116;
        this.mdelete_milli_time = r117;
        this.mgantt_view_setting = r118;
    }
}
