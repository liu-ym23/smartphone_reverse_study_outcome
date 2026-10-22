package com.bytedance.lark.pb.todo.v1;

import com.bytedance.lark.pb.basic.v1.RichContent;
import com.bytedance.lark.pb.entity_num.v1.EntityNumInfo;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class Todo extends Message<Todo, Builder> {
    public static final ProtoAdapter<Todo> ADAPTER = null;
    public static final String DEFAULT_ANCESTOR_GUID = "";
    public static final Integer DEFAULT_COMMENT_COUNT = null;
    public static final Long DEFAULT_COMPLETED_MILLI_TIME = null;
    public static final Long DEFAULT_CREATE_MILLI_TIME = null;
    public static final String DEFAULT_CREATOR_ID = "";
    public static final Long DEFAULT_DELETED_MILLI_TIME = null;
    public static final Long DEFAULT_DISPLAY_COMPLETED_MILLI_TIME = null;
    public static final Long DEFAULT_DUE_TIME = null;
    public static final String DEFAULT_DUE_TIMEZONE = "";
    public static final String DEFAULT_GUID = "";
    public static final Long DEFAULT_HIDDEN_MILLI_TIME = null;
    public static final Boolean DEFAULT_IS_ALL_DAY = null;
    public static final Boolean DEFAULT_IS_MILESTONE = null;
    public static final Boolean DEFAULT_IS_NOT_MINE = null;
    public static final String DEFAULT_ITEM_MAX_VERSION = "";
    public static final String DEFAULT_MEEGO_POINTS = "";
    public static final TaskMode DEFAULT_MODE = null;
    public static final String DEFAULT_POINTS = "";
    public static final String DEFAULT_RRULE = "";
    public static final TodoSource DEFAULT_SOURCE = null;
    public static final Long DEFAULT_START_MILLI_TIME = null;
    public static final Long DEFAULT_SUB_TASK_DEPTH = null;
    public static final String DEFAULT_TASK_PROGRESS = "";
    public static final TaskStatus DEFAULT_TASK_STATUS = null;
    public static final Long DEFAULT_UPDATE_MILLI_TIME = null;
    private static final long serialVersionUID = 0;
    public final AgentTaskContent agent_content;
    public final String ancestor_guid;
    public final List<TodoAssignee> assignees;
    public final TodoUser assigner;
    public final List<TodoAttachment> attachments;
    public final Integer comment_count;
    public final Long completed_milli_time;
    public final Long create_milli_time;
    public final TodoUser creator;
    public final String creator_id;
    public final CustomComplete custom_complete;
    public final Map<String, TaskFieldValue> custom_field_values;
    public final Long deleted_milli_time;
    public final List<TaskDependentRef> dependents;
    public final Long display_completed_milli_time;
    public final Long due_time;
    public final String due_timezone;
    public final EntityNumInfo entity_num;
    public final TodoExtra extra;
    public final List<TodoFollower> followers;
    public final String guid;
    public final Long hidden_milli_time;
    public final Boolean is_all_day;
    public final Boolean is_milestone;
    public final Boolean is_not_mine;
    public final String item_max_version;
    public final String meego_points;
    public final TaskMode mode;
    public final TodoOrigin origin;
    public final String points;
    public final Progress progress;
    public final List<String> refer_resource_ids;
    public final AgentInfo related_agent;
    public final List<String> related_task_list_guids;
    public final List<TodoReminder> reminders;
    public final RichContent rich_description;
    public final RichContent rich_summary;
    public final String rrule;
    public final TodoItemPermission self_permission;
    public final TodoSource source;
    public final Long start_milli_time;
    public final Long sub_task_depth;
    public final String task_progress;
    public final TaskStatus task_status;
    public final Long update_milli_time;

    public static final class Builder extends Message.Builder<Todo, Builder> {
        public AgentTaskContent agent_content;
        public String ancestor_guid;
        public List<TodoAssignee> assignees;
        public TodoUser assigner;
        public List<TodoAttachment> attachments;
        public Integer comment_count;
        public Long completed_milli_time;
        public Long create_milli_time;
        public TodoUser creator;
        public String creator_id;
        public CustomComplete custom_complete;
        public Map<String, TaskFieldValue> custom_field_values;
        public Long deleted_milli_time;
        public List<TaskDependentRef> dependents;
        public Long display_completed_milli_time;
        public Long due_time;
        public String due_timezone;
        public EntityNumInfo entity_num;
        public TodoExtra extra;
        public List<TodoFollower> followers;
        public String guid;
        public Long hidden_milli_time;
        public Boolean is_all_day;
        public Boolean is_milestone;
        public Boolean is_not_mine;
        public String item_max_version;
        public String meego_points;
        public TaskMode mode;
        public TodoOrigin origin;
        public String points;
        public Progress progress;
        public List<String> refer_resource_ids;
        public AgentInfo related_agent;
        public List<String> related_task_list_guids;
        public List<TodoReminder> reminders;
        public RichContent rich_description;
        public RichContent rich_summary;
        public String rrule;
        public TodoItemPermission self_permission;
        public TodoSource source;
        public Long start_milli_time;
        public Long sub_task_depth;
        public String task_progress;
        public TaskStatus task_status;
        public Long update_milli_time;

        @Override // com.squareup.wire.Message.Builder
        public Todo build() {
            return new Todo(this.guid, this.rich_summary, this.rich_description, this.reminders, this.source, this.due_time, this.due_timezone, this.is_all_day, this.self_permission, this.assignees, this.completed_milli_time, this.deleted_milli_time, this.creator_id, this.create_milli_time, this.creator, this.item_max_version, this.extra, this.is_not_mine, this.assigner, this.refer_resource_ids, this.followers, this.origin, this.display_completed_milli_time, this.custom_complete, this.rrule, this.update_milli_time, this.comment_count, this.entity_num, this.ancestor_guid, this.progress, this.hidden_milli_time, this.mode, this.related_task_list_guids, this.attachments, this.custom_field_values, this.start_milli_time, this.is_milestone, this.dependents, this.sub_task_depth, this.points, this.meego_points, this.task_status, this.task_progress, this.related_agent, this.agent_content, super.buildUnknownFields());
        }

        public Builder() {
            this.reminders = Internal.newMutableList();
            this.assignees = Internal.newMutableList();
            this.refer_resource_ids = Internal.newMutableList();
            this.followers = Internal.newMutableList();
            this.related_task_list_guids = Internal.newMutableList();
            this.attachments = Internal.newMutableList();
            this.custom_field_values = Internal.newMutableMap();
            this.dependents = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder agent_content(AgentTaskContent r100) {
            this.agent_content = r100;
            return this;
        }

        public Builder ancestor_guid(String r100) {
            this.ancestor_guid = r100;
            return this;
        }

        public Builder assignees(List<TodoAssignee> r100) {
            Internal.checkElementsNotNull(r100);
            this.assignees = r100;
            return this;
        }

        public Builder assigner(TodoUser r100) {
            this.assigner = r100;
            return this;
        }

        public Builder attachments(List<TodoAttachment> r100) {
            Internal.checkElementsNotNull(r100);
            this.attachments = r100;
            return this;
        }

        public Builder comment_count(Integer r100) {
            this.comment_count = r100;
            return this;
        }

        public Builder completed_milli_time(Long r100) {
            this.completed_milli_time = r100;
            return this;
        }

        public Builder create_milli_time(Long r100) {
            this.create_milli_time = r100;
            return this;
        }

        public Builder creator(TodoUser r100) {
            this.creator = r100;
            return this;
        }

        public Builder creator_id(String r100) {
            this.creator_id = r100;
            return this;
        }

        public Builder custom_complete(CustomComplete r100) {
            this.custom_complete = r100;
            return this;
        }

        public Builder custom_field_values(Map<String, TaskFieldValue> r100) {
            Internal.checkElementsNotNull(r100);
            this.custom_field_values = r100;
            return this;
        }

        public Builder deleted_milli_time(Long r100) {
            this.deleted_milli_time = r100;
            return this;
        }

        public Builder dependents(List<TaskDependentRef> r100) {
            Internal.checkElementsNotNull(r100);
            this.dependents = r100;
            return this;
        }

        public Builder display_completed_milli_time(Long r100) {
            this.display_completed_milli_time = r100;
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

        public Builder extra(TodoExtra r100) {
            this.extra = r100;
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

        public Builder hidden_milli_time(Long r100) {
            this.hidden_milli_time = r100;
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

        public Builder is_not_mine(Boolean r100) {
            this.is_not_mine = r100;
            return this;
        }

        public Builder item_max_version(String r100) {
            this.item_max_version = r100;
            return this;
        }

        public Builder meego_points(String r100) {
            this.meego_points = r100;
            return this;
        }

        public Builder mode(TaskMode r100) {
            this.mode = r100;
            return this;
        }

        public Builder origin(TodoOrigin r100) {
            this.origin = r100;
            return this;
        }

        public Builder points(String r100) {
            this.points = r100;
            return this;
        }

        public Builder progress(Progress r100) {
            this.progress = r100;
            return this;
        }

        public Builder refer_resource_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.refer_resource_ids = r100;
            return this;
        }

        public Builder related_agent(AgentInfo r100) {
            this.related_agent = r100;
            return this;
        }

        public Builder related_task_list_guids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.related_task_list_guids = r100;
            return this;
        }

        public Builder reminders(List<TodoReminder> r100) {
            Internal.checkElementsNotNull(r100);
            this.reminders = r100;
            return this;
        }

        public Builder rich_description(RichContent r100) {
            this.rich_description = r100;
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

        public Builder self_permission(TodoItemPermission r100) {
            this.self_permission = r100;
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

        public Builder sub_task_depth(Long r100) {
            this.sub_task_depth = r100;
            return this;
        }

        public Builder task_progress(String r100) {
            this.task_progress = r100;
            return this;
        }

        public Builder task_status(TaskStatus r100) {
            this.task_status = r100;
            return this;
        }

        public Builder update_milli_time(Long r100) {
            this.update_milli_time = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Todo extends ProtoAdapter<Todo> {
        private final ProtoAdapter<Map<String, TaskFieldValue>> custom_field_values;

        public ProtoAdapter_Todo() {
            super(FieldEncoding.LENGTH_DELIMITED, Todo.class);
            this.custom_field_values = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, TaskFieldValue.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Todo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.guid = "";
            r101.source = TodoSource.TODO;
            r101.due_time = 0L;
            r101.due_timezone = "";
            Boolean r102 = Boolean.FALSE;
            r101.is_all_day = r102;
            r101.completed_milli_time = 0L;
            r101.deleted_milli_time = 0L;
            r101.creator_id = "";
            r101.create_milli_time = 0L;
            r101.item_max_version = "";
            r101.is_not_mine = r102;
            r101.display_completed_milli_time = 0L;
            r101.rrule = "";
            r101.update_milli_time = 0L;
            r101.comment_count = 0;
            r101.ancestor_guid = "";
            r101.hidden_milli_time = 0L;
            r101.mode = TaskMode.UNKNOWN_MODE;
            r101.start_milli_time = 0L;
            r101.is_milestone = r102;
            r101.sub_task_depth = 0L;
            r101.points = "";
            r101.meego_points = "";
            r101.task_status = TaskStatus.UNKNOWN_TASK_STATUS;
            r101.task_progress = "";
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L63;
            switch(r104) {
                case 1: goto L62;
                case 2: goto L61;
                case 3: goto L60;
                case 4: goto L59;
                case 5: goto L67;
                case 6: goto L54;
                case 7: goto L53;
                case 8: goto L52;
                case 9: goto L51;
                case 10: goto L50;
                case 11: goto L49;
                case 12: goto L48;
                case 13: goto L47;
                case 14: goto L46;
                case 15: goto L45;
                case 16: goto L44;
                case 17: goto L43;
                case 18: goto L42;
                case 19: goto L41;
                case 20: goto L40;
                case 21: goto L39;
                case 22: goto L38;
                case 23: goto L37;
                case 24: goto L36;
                case 25: goto L35;
                case 26: goto L34;
                case 27: goto L33;
                case 28: goto L32;
                default: goto L6;
            };
        L67:
            r101.source = TodoSource.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L57
        L57:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L32:
            r101.entity_num = EntityNumInfo.ADAPTER.decode(r100);
            goto L3
        L33:
            r101.comment_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L34:
            r101.update_milli_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L35:
            r101.rrule = ProtoAdapter.STRING.decode(r100);
            goto L3
        L36:
            r101.custom_complete = CustomComplete.ADAPTER.decode(r100);
            goto L3
        L37:
            r101.display_completed_milli_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L38:
            r101.origin = TodoOrigin.ADAPTER.decode(r100);
            goto L3
        L39:
            r101.followers.add(TodoFollower.ADAPTER.decode(r100));
            goto L3
        L40:
            r101.refer_resource_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L41:
            r101.assigner = TodoUser.ADAPTER.decode(r100);
            goto L3
        L42:
            r101.is_not_mine = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L43:
            r101.extra = TodoExtra.ADAPTER.decode(r100);
            goto L3
        L44:
            r101.item_max_version = ProtoAdapter.STRING.decode(r100);
            goto L3
        L45:
            r101.creator = TodoUser.ADAPTER.decode(r100);
            goto L3
        L46:
            r101.create_milli_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L47:
            r101.creator_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L48:
            r101.deleted_milli_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L49:
            r101.completed_milli_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L50:
            r101.assignees.add(TodoAssignee.ADAPTER.decode(r100));
            goto L3
        L51:
            r101.self_permission = TodoItemPermission.ADAPTER.decode(r100);
            goto L3
        L52:
            r101.is_all_day = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L53:
            r101.due_timezone = ProtoAdapter.STRING.decode(r100);
            goto L3
        L54:
            r101.due_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L59:
            r101.reminders.add(TodoReminder.ADAPTER.decode(r100));
            goto L3
        L60:
            r101.rich_description = RichContent.ADAPTER.decode(r100);
            goto L3
        L61:
            r101.rich_summary = RichContent.ADAPTER.decode(r100);
            goto L3
        L62:
            r101.guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            switch(r104) {
                case 30: goto L31;
                case 31: goto L30;
                case 32: goto L29;
                case 33: goto L69;
                case 34: goto L24;
                case 35: goto L23;
                case 36: goto L22;
                case 37: goto L21;
                case 38: goto L20;
                case 39: goto L19;
                case 40: goto L18;
                case 41: goto L17;
                case 42: goto L16;
                default: goto L7;
            };
        L69:
            r101.mode = TaskMode.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L27
        L27:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L16:
            r101.meego_points = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.points = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.sub_task_depth = ProtoAdapter.INT64.decode(r100);
            goto L3
        L19:
            r101.dependents.add(TaskDependentRef.ADAPTER.decode(r100));
            goto L3
        L20:
            r101.is_milestone = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L21:
            r101.start_milli_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L22:
            r101.custom_field_values.putAll(this.custom_field_values.decode(r100));
            goto L3
        L23:
            r101.attachments.add(TodoAttachment.ADAPTER.decode(r100));
            goto L3
        L24:
            r101.related_task_list_guids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L29:
            r101.hidden_milli_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L30:
            r101.progress = Progress.ADAPTER.decode(r100);
            goto L3
        L31:
            r101.ancestor_guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L7:
            switch(r104) {
                case 51: goto L65;
                case 52: goto L11;
                case 53: goto L10;
                case 54: goto L9;
                default: goto L8;
            };
        L65:
            r101.task_status = TaskStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            r101.agent_content = AgentTaskContent.ADAPTER.decode(r100);
            goto L3
        L10:
            r101.related_agent = AgentInfo.ADAPTER.decode(r100);
            goto L3
        L11:
            r101.task_progress = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L63:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Todo r100) {
            String r101 = r100.guid;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            RichContent r104 = r100.rich_summary;
            if (r104 == null) goto L9;
            int r105 = RichContent.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            RichContent r107 = r100.rich_description;
            if (r107 == null) goto L13;
            int r108 = RichContent.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = (r106 + r108) + TodoReminder.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.reminders);
            TodoSource r110 = r100.source;
            if (r110 == null) goto L17;
            int r111 = TodoSource.ADAPTER.encodedSizeWithTag(5, r110);
        L18:
            int r112 = r109 + r111;
            Long r113 = r100.due_time;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.INT64.encodedSizeWithTag(6, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.due_timezone;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(7, r116);
        L26:
            int r118 = r115 + r117;
            Boolean r119 = r100.is_all_day;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r119);
        L30:
            int r121 = r118 + r120;
            TodoItemPermission r122 = r100.self_permission;
            if (r122 == null) goto L33;
            int r123 = TodoItemPermission.ADAPTER.encodedSizeWithTag(9, r122);
        L34:
            int r124 = (r121 + r123) + TodoAssignee.ADAPTER.asRepeated().encodedSizeWithTag(10, r100.assignees);
            Long r125 = r100.completed_milli_time;
            if (r125 == null) goto L37;
            int r126 = ProtoAdapter.INT64.encodedSizeWithTag(11, r125);
        L38:
            int r127 = r124 + r126;
            Long r128 = r100.deleted_milli_time;
            if (r128 == null) goto L41;
            int r129 = ProtoAdapter.INT64.encodedSizeWithTag(12, r128);
        L42:
            int r130 = r127 + r129;
            String r131 = r100.creator_id;
            if (r131 == null) goto L45;
            int r132 = ProtoAdapter.STRING.encodedSizeWithTag(13, r131);
        L46:
            int r133 = r130 + r132;
            Long r134 = r100.create_milli_time;
            if (r134 == null) goto L49;
            int r135 = ProtoAdapter.INT64.encodedSizeWithTag(14, r134);
        L50:
            int r136 = r133 + r135;
            TodoUser r137 = r100.creator;
            if (r137 == null) goto L53;
            int r138 = TodoUser.ADAPTER.encodedSizeWithTag(15, r137);
        L54:
            int r139 = r136 + r138;
            String r140 = r100.item_max_version;
            if (r140 == null) goto L57;
            int r141 = ProtoAdapter.STRING.encodedSizeWithTag(16, r140);
        L58:
            int r142 = r139 + r141;
            TodoExtra r143 = r100.extra;
            if (r143 == null) goto L61;
            int r144 = TodoExtra.ADAPTER.encodedSizeWithTag(17, r143);
        L62:
            int r145 = r142 + r144;
            Boolean r146 = r100.is_not_mine;
            if (r146 == null) goto L65;
            int r147 = ProtoAdapter.BOOL.encodedSizeWithTag(18, r146);
        L66:
            int r148 = r145 + r147;
            TodoUser r149 = r100.assigner;
            if (r149 == null) goto L69;
            int r150 = TodoUser.ADAPTER.encodedSizeWithTag(19, r149);
        L70:
            int r151 = r148 + r150;
            ProtoAdapter<String> r152 = ProtoAdapter.STRING;
            int r153 = (r151 + r152.asRepeated().encodedSizeWithTag(20, r100.refer_resource_ids)) + TodoFollower.ADAPTER.asRepeated().encodedSizeWithTag(21, r100.followers);
            TodoOrigin r154 = r100.origin;
            if (r154 == null) goto L73;
            int r155 = TodoOrigin.ADAPTER.encodedSizeWithTag(22, r154);
        L74:
            int r156 = r153 + r155;
            Long r157 = r100.display_completed_milli_time;
            if (r157 == null) goto L77;
            int r158 = ProtoAdapter.INT64.encodedSizeWithTag(23, r157);
        L78:
            int r159 = r156 + r158;
            CustomComplete r160 = r100.custom_complete;
            if (r160 == null) goto L81;
            int r161 = CustomComplete.ADAPTER.encodedSizeWithTag(24, r160);
        L82:
            int r162 = r159 + r161;
            String r163 = r100.rrule;
            if (r163 == null) goto L85;
            int r164 = r152.encodedSizeWithTag(25, r163);
        L86:
            int r165 = r162 + r164;
            Long r166 = r100.update_milli_time;
            if (r166 == null) goto L89;
            int r167 = ProtoAdapter.INT64.encodedSizeWithTag(26, r166);
        L90:
            int r168 = r165 + r167;
            Integer r169 = r100.comment_count;
            if (r169 == null) goto L93;
            int r170 = ProtoAdapter.INT32.encodedSizeWithTag(27, r169);
        L94:
            int r171 = r168 + r170;
            EntityNumInfo r172 = r100.entity_num;
            if (r172 == null) goto L97;
            int r173 = EntityNumInfo.ADAPTER.encodedSizeWithTag(28, r172);
        L98:
            int r174 = r171 + r173;
            String r175 = r100.ancestor_guid;
            if (r175 == null) goto L101;
            int r176 = r152.encodedSizeWithTag(30, r175);
        L102:
            int r177 = r174 + r176;
            Progress r178 = r100.progress;
            if (r178 == null) goto L105;
            int r179 = Progress.ADAPTER.encodedSizeWithTag(31, r178);
        L106:
            int r180 = r177 + r179;
            Long r181 = r100.hidden_milli_time;
            if (r181 == null) goto L109;
            int r182 = ProtoAdapter.INT64.encodedSizeWithTag(32, r181);
        L110:
            int r183 = r180 + r182;
            TaskMode r184 = r100.mode;
            if (r184 == null) goto L113;
            int r185 = TaskMode.ADAPTER.encodedSizeWithTag(33, r184);
        L114:
            int r186 = (((r183 + r185) + r152.asRepeated().encodedSizeWithTag(34, r100.related_task_list_guids)) + TodoAttachment.ADAPTER.asRepeated().encodedSizeWithTag(35, r100.attachments)) + this.custom_field_values.encodedSizeWithTag(36, r100.custom_field_values);
            Long r187 = r100.start_milli_time;
            if (r187 == null) goto L117;
            int r188 = ProtoAdapter.INT64.encodedSizeWithTag(37, r187);
        L118:
            int r189 = r186 + r188;
            Boolean r190 = r100.is_milestone;
            if (r190 == null) goto L121;
            int r191 = ProtoAdapter.BOOL.encodedSizeWithTag(38, r190);
        L122:
            int r192 = (r189 + r191) + TaskDependentRef.ADAPTER.asRepeated().encodedSizeWithTag(39, r100.dependents);
            Long r193 = r100.sub_task_depth;
            if (r193 == null) goto L125;
            int r194 = ProtoAdapter.INT64.encodedSizeWithTag(40, r193);
        L126:
            int r195 = r192 + r194;
            String r196 = r100.points;
            if (r196 == null) goto L129;
            int r197 = r152.encodedSizeWithTag(41, r196);
        L130:
            int r198 = r195 + r197;
            String r199 = r100.meego_points;
            if (r199 == null) goto L133;
            int r200 = r152.encodedSizeWithTag(42, r199);
        L134:
            int r201 = r198 + r200;
            TaskStatus r202 = r100.task_status;
            if (r202 == null) goto L137;
            int r203 = TaskStatus.ADAPTER.encodedSizeWithTag(51, r202);
        L138:
            int r204 = r201 + r203;
            String r205 = r100.task_progress;
            if (r205 == null) goto L141;
            int r206 = r152.encodedSizeWithTag(52, r205);
        L142:
            int r207 = r204 + r206;
            AgentInfo r208 = r100.related_agent;
            if (r208 == null) goto L145;
            int r209 = AgentInfo.ADAPTER.encodedSizeWithTag(53, r208);
        L146:
            int r210 = r207 + r209;
            AgentTaskContent r211 = r100.agent_content;
            if (r211 == null) goto L150;
            r102 = AgentTaskContent.ADAPTER.encodedSizeWithTag(54, r211);
        L150:
            return (r210 + r102) + r100.unknownFields().size();
        L145:
            r209 = 0;
            goto L146
        L141:
            r206 = 0;
            goto L142
        L137:
            r203 = 0;
            goto L138
        L133:
            r200 = 0;
            goto L134
        L129:
            r197 = 0;
            goto L130
        L125:
            r194 = 0;
            goto L126
        L121:
            r191 = 0;
            goto L122
        L117:
            r188 = 0;
            goto L118
        L113:
            r185 = 0;
            goto L114
        L109:
            r182 = 0;
            goto L110
        L105:
            r179 = 0;
            goto L106
        L101:
            r176 = 0;
            goto L102
        L97:
            r173 = 0;
            goto L98
        L93:
            r170 = 0;
            goto L94
        L89:
            r167 = 0;
            goto L90
        L85:
            r164 = 0;
            goto L86
        L81:
            r161 = 0;
            goto L82
        L77:
            r158 = 0;
            goto L78
        L73:
            r155 = 0;
            goto L74
        L69:
            r150 = 0;
            goto L70
        L65:
            r147 = 0;
            goto L66
        L61:
            r144 = 0;
            goto L62
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
        public /* bridge */ /* synthetic */ Todo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Todo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Todo r101) throws IOException {
            String r102 = r101.guid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            RichContent r103 = r101.rich_summary;
            if (r103 == null) goto L8;
            RichContent.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            RichContent r104 = r101.rich_description;
            if (r104 == null) goto L11;
            RichContent.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            TodoReminder.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.reminders);
            TodoSource r105 = r101.source;
            if (r105 == null) goto L14;
            TodoSource.ADAPTER.encodeWithTag(r100, 5, r105);
        L14:
            Long r106 = r101.due_time;
            if (r106 == null) goto L17;
            ProtoAdapter.INT64.encodeWithTag(r100, 6, r106);
        L17:
            String r107 = r101.due_timezone;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r107);
        L20:
            Boolean r108 = r101.is_all_day;
            if (r108 == null) goto L23;
            ProtoAdapter.BOOL.encodeWithTag(r100, 8, r108);
        L23:
            TodoItemPermission r109 = r101.self_permission;
            if (r109 == null) goto L26;
            TodoItemPermission.ADAPTER.encodeWithTag(r100, 9, r109);
        L26:
            TodoAssignee.ADAPTER.asRepeated().encodeWithTag(r100, 10, r101.assignees);
            Long r110 = r101.completed_milli_time;
            if (r110 == null) goto L29;
            ProtoAdapter.INT64.encodeWithTag(r100, 11, r110);
        L29:
            Long r111 = r101.deleted_milli_time;
            if (r111 == null) goto L32;
            ProtoAdapter.INT64.encodeWithTag(r100, 12, r111);
        L32:
            String r112 = r101.creator_id;
            if (r112 == null) goto L35;
            ProtoAdapter.STRING.encodeWithTag(r100, 13, r112);
        L35:
            Long r113 = r101.create_milli_time;
            if (r113 == null) goto L38;
            ProtoAdapter.INT64.encodeWithTag(r100, 14, r113);
        L38:
            TodoUser r114 = r101.creator;
            if (r114 == null) goto L41;
            TodoUser.ADAPTER.encodeWithTag(r100, 15, r114);
        L41:
            String r115 = r101.item_max_version;
            if (r115 == null) goto L44;
            ProtoAdapter.STRING.encodeWithTag(r100, 16, r115);
        L44:
            TodoExtra r116 = r101.extra;
            if (r116 == null) goto L47;
            TodoExtra.ADAPTER.encodeWithTag(r100, 17, r116);
        L47:
            Boolean r117 = r101.is_not_mine;
            if (r117 == null) goto L50;
            ProtoAdapter.BOOL.encodeWithTag(r100, 18, r117);
        L50:
            TodoUser r118 = r101.assigner;
            if (r118 == null) goto L53;
            TodoUser.ADAPTER.encodeWithTag(r100, 19, r118);
        L53:
            ProtoAdapter<String> r119 = ProtoAdapter.STRING;
            r119.asRepeated().encodeWithTag(r100, 20, r101.refer_resource_ids);
            TodoFollower.ADAPTER.asRepeated().encodeWithTag(r100, 21, r101.followers);
            TodoOrigin r120 = r101.origin;
            if (r120 == null) goto L56;
            TodoOrigin.ADAPTER.encodeWithTag(r100, 22, r120);
        L56:
            Long r121 = r101.display_completed_milli_time;
            if (r121 == null) goto L59;
            ProtoAdapter.INT64.encodeWithTag(r100, 23, r121);
        L59:
            CustomComplete r122 = r101.custom_complete;
            if (r122 == null) goto L62;
            CustomComplete.ADAPTER.encodeWithTag(r100, 24, r122);
        L62:
            String r123 = r101.rrule;
            if (r123 == null) goto L65;
            r119.encodeWithTag(r100, 25, r123);
        L65:
            Long r124 = r101.update_milli_time;
            if (r124 == null) goto L68;
            ProtoAdapter.INT64.encodeWithTag(r100, 26, r124);
        L68:
            Integer r125 = r101.comment_count;
            if (r125 == null) goto L71;
            ProtoAdapter.INT32.encodeWithTag(r100, 27, r125);
        L71:
            EntityNumInfo r126 = r101.entity_num;
            if (r126 == null) goto L74;
            EntityNumInfo.ADAPTER.encodeWithTag(r100, 28, r126);
        L74:
            String r127 = r101.ancestor_guid;
            if (r127 == null) goto L77;
            r119.encodeWithTag(r100, 30, r127);
        L77:
            Progress r128 = r101.progress;
            if (r128 == null) goto L80;
            Progress.ADAPTER.encodeWithTag(r100, 31, r128);
        L80:
            Long r129 = r101.hidden_milli_time;
            if (r129 == null) goto L83;
            ProtoAdapter.INT64.encodeWithTag(r100, 32, r129);
        L83:
            TaskMode r130 = r101.mode;
            if (r130 == null) goto L86;
            TaskMode.ADAPTER.encodeWithTag(r100, 33, r130);
        L86:
            r119.asRepeated().encodeWithTag(r100, 34, r101.related_task_list_guids);
            TodoAttachment.ADAPTER.asRepeated().encodeWithTag(r100, 35, r101.attachments);
            this.custom_field_values.encodeWithTag(r100, 36, r101.custom_field_values);
            Long r131 = r101.start_milli_time;
            if (r131 == null) goto L89;
            ProtoAdapter.INT64.encodeWithTag(r100, 37, r131);
        L89:
            Boolean r132 = r101.is_milestone;
            if (r132 == null) goto L92;
            ProtoAdapter.BOOL.encodeWithTag(r100, 38, r132);
        L92:
            TaskDependentRef.ADAPTER.asRepeated().encodeWithTag(r100, 39, r101.dependents);
            Long r133 = r101.sub_task_depth;
            if (r133 == null) goto L95;
            ProtoAdapter.INT64.encodeWithTag(r100, 40, r133);
        L95:
            String r134 = r101.points;
            if (r134 == null) goto L98;
            r119.encodeWithTag(r100, 41, r134);
        L98:
            String r135 = r101.meego_points;
            if (r135 == null) goto L101;
            r119.encodeWithTag(r100, 42, r135);
        L101:
            TaskStatus r136 = r101.task_status;
            if (r136 == null) goto L104;
            TaskStatus.ADAPTER.encodeWithTag(r100, 51, r136);
        L104:
            String r137 = r101.task_progress;
            if (r137 == null) goto L107;
            r119.encodeWithTag(r100, 52, r137);
        L107:
            AgentInfo r138 = r101.related_agent;
            if (r138 == null) goto L110;
            AgentInfo.ADAPTER.encodeWithTag(r100, 53, r138);
        L110:
            AgentTaskContent r139 = r101.agent_content;
            if (r139 == null) goto L113;
            AgentTaskContent.ADAPTER.encodeWithTag(r100, 54, r139);
        L113:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Todo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Todo();
        DEFAULT_SOURCE = TodoSource.TODO;
        DEFAULT_DUE_TIME = 0L;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_ALL_DAY = r100;
        DEFAULT_COMPLETED_MILLI_TIME = 0L;
        DEFAULT_DELETED_MILLI_TIME = 0L;
        DEFAULT_CREATE_MILLI_TIME = 0L;
        DEFAULT_IS_NOT_MINE = r100;
        DEFAULT_DISPLAY_COMPLETED_MILLI_TIME = 0L;
        DEFAULT_UPDATE_MILLI_TIME = 0L;
        DEFAULT_COMMENT_COUNT = 0;
        DEFAULT_HIDDEN_MILLI_TIME = 0L;
        DEFAULT_MODE = TaskMode.UNKNOWN_MODE;
        DEFAULT_START_MILLI_TIME = 0L;
        DEFAULT_IS_MILESTONE = r100;
        DEFAULT_SUB_TASK_DEPTH = 0L;
        DEFAULT_TASK_STATUS = TaskStatus.UNKNOWN_TASK_STATUS;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.guid = this.guid;
        r100.rich_summary = this.rich_summary;
        r100.rich_description = this.rich_description;
        r100.reminders = Internal.copyOf("reminders", this.reminders);
        r100.source = this.source;
        r100.due_time = this.due_time;
        r100.due_timezone = this.due_timezone;
        r100.is_all_day = this.is_all_day;
        r100.self_permission = this.self_permission;
        r100.assignees = Internal.copyOf("assignees", this.assignees);
        r100.completed_milli_time = this.completed_milli_time;
        r100.deleted_milli_time = this.deleted_milli_time;
        r100.creator_id = this.creator_id;
        r100.create_milli_time = this.create_milli_time;
        r100.creator = this.creator;
        r100.item_max_version = this.item_max_version;
        r100.extra = this.extra;
        r100.is_not_mine = this.is_not_mine;
        r100.assigner = this.assigner;
        r100.refer_resource_ids = Internal.copyOf("refer_resource_ids", this.refer_resource_ids);
        r100.followers = Internal.copyOf("followers", this.followers);
        r100.origin = this.origin;
        r100.display_completed_milli_time = this.display_completed_milli_time;
        r100.custom_complete = this.custom_complete;
        r100.rrule = this.rrule;
        r100.update_milli_time = this.update_milli_time;
        r100.comment_count = this.comment_count;
        r100.entity_num = this.entity_num;
        r100.ancestor_guid = this.ancestor_guid;
        r100.progress = this.progress;
        r100.hidden_milli_time = this.hidden_milli_time;
        r100.mode = this.mode;
        r100.related_task_list_guids = Internal.copyOf("related_task_list_guids", this.related_task_list_guids);
        r100.attachments = Internal.copyOf("attachments", this.attachments);
        r100.custom_field_values = Internal.copyOf("custom_field_values", this.custom_field_values);
        r100.start_milli_time = this.start_milli_time;
        r100.is_milestone = this.is_milestone;
        r100.dependents = Internal.copyOf("dependents", this.dependents);
        r100.sub_task_depth = this.sub_task_depth;
        r100.points = this.points;
        r100.meego_points = this.meego_points;
        r100.task_status = this.task_status;
        r100.task_progress = this.task_progress;
        r100.related_agent = this.related_agent;
        r100.agent_content = this.agent_content;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Todo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public Todo(String r410, RichContent r411, RichContent r510, List<TodoReminder> r511, TodoSource r512, Long r513, String r514, Boolean r515, TodoItemPermission r516, List<TodoAssignee> r517, Long r518, Long r519, String r610, Long r611, TodoUser r612, String r613, TodoExtra r614, Boolean r615, TodoUser r616, List<String> r617, List<TodoFollower> r618, TodoOrigin r619, Long r710, CustomComplete r711, String r712, Long r713, Integer r714, EntityNumInfo r715, String r716, Progress r717, Long r718, TaskMode r719, List<String> r810, List<TodoAttachment> r811, Map<String, TaskFieldValue> r812, Long r813, Boolean r814, List<TaskDependentRef> r815, Long r816, String r817, String r818, TaskStatus r819, String r910, AgentInfo r911, AgentTaskContent r912) {
        this(r410, r411, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711, r712, r713, r714, r715, r716, r717, r718, r719, r810, r811, r812, r813, r814, r815, r816, r817, r818, r819, r910, r911, r912, ByteString.EMPTY);
    }

    public Todo(String r100, RichContent r101, RichContent r102, List<TodoReminder> r103, TodoSource r104, Long r105, String r110, Boolean r111, TodoItemPermission r112, List<TodoAssignee> r113, Long r114, Long r115, String r116, Long r117, TodoUser r118, String r119, TodoExtra r210, Boolean r211, TodoUser r212, List<String> r213, List<TodoFollower> r214, TodoOrigin r215, Long r216, CustomComplete r217, String r218, Long r219, Integer r310, EntityNumInfo r311, String r312, Progress r313, Long r314, TaskMode r315, List<String> r316, List<TodoAttachment> r317, Map<String, TaskFieldValue> r318, Long r319, Boolean r410, List<TaskDependentRef> r411, Long r412, String r413, String r414, TaskStatus r415, String r416, AgentInfo r417, AgentTaskContent r418, ByteString r419) {
        super(ADAPTER, r419);
        this.guid = r100;
        this.rich_summary = r101;
        this.rich_description = r102;
        this.reminders = Internal.immutableCopyOf("reminders", r103);
        this.source = r104;
        this.due_time = r105;
        this.due_timezone = r110;
        this.is_all_day = r111;
        this.self_permission = r112;
        this.assignees = Internal.immutableCopyOf("assignees", r113);
        this.completed_milli_time = r114;
        this.deleted_milli_time = r115;
        this.creator_id = r116;
        this.create_milli_time = r117;
        this.creator = r118;
        this.item_max_version = r119;
        this.extra = r210;
        this.is_not_mine = r211;
        this.assigner = r212;
        this.refer_resource_ids = Internal.immutableCopyOf("refer_resource_ids", r213);
        this.followers = Internal.immutableCopyOf("followers", r214);
        this.origin = r215;
        this.display_completed_milli_time = r216;
        this.custom_complete = r217;
        this.rrule = r218;
        this.update_milli_time = r219;
        this.comment_count = r310;
        this.entity_num = r311;
        this.ancestor_guid = r312;
        this.progress = r313;
        this.hidden_milli_time = r314;
        this.mode = r315;
        this.related_task_list_guids = Internal.immutableCopyOf("related_task_list_guids", r316);
        this.attachments = Internal.immutableCopyOf("attachments", r317);
        this.custom_field_values = Internal.immutableCopyOf("custom_field_values", r318);
        this.start_milli_time = r319;
        this.is_milestone = r410;
        this.dependents = Internal.immutableCopyOf("dependents", r411);
        this.sub_task_depth = r412;
        this.points = r413;
        this.meego_points = r414;
        this.task_status = r415;
        this.task_progress = r416;
        this.related_agent = r417;
        this.agent_content = r418;
    }
}
