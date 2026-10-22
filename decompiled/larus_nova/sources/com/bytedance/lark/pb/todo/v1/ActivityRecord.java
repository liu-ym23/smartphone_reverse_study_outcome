package com.bytedance.lark.pb.todo.v1;

import com.bytedance.lark.pb.basic.v1.RichContent;
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
public final class ActivityRecord extends Message<ActivityRecord, Builder> {
    public static final ProtoAdapter<ActivityRecord> ADAPTER = null;
    public static final String DEFAULT_GUID = "";
    public static final Long DEFAULT_OPERATE_MILLI_TIME = null;
    public static final ActivityRecordKey DEFAULT_RECORD_KEY = null;
    public static final String DEFAULT_RELATED_TASK_GUID = "";
    public static final TargetType DEFAULT_TARGET_TYPE = null;
    private static final long serialVersionUID = 0;
    public final TaskListAssigneeUpdateEntity assignee_update_entity;
    public final TaskAttachmentUpdateEntity attachment_entity;
    public final TaskCommentEntity comment_entity;
    public final TaskDescriptionUpdateEntity description_update_entity;
    public final TaskDueTimeUpdateEntity due_time_update_entity;
    public final TaskFieldValueUpdateEntity field_value_update_entity;
    public final TaskFollowersEntity followers_entity;
    public final String guid;
    public final TaskListFieldUpdateEntity list_field_update_entity;
    public final Long operate_milli_time;
    public final TodoUser operator;
    public final TaskOwnerUpdateEntity owner_update_entity;
    public final ActivityRecordKey record_key;
    public final String related_task_guid;
    public final List<String> related_task_list_guids;
    public final TaskSubTaskEntity remove_subtask_entity;
    public final TaskListRenameEntity rename_entity;
    public final TaskRepeatGenerateEntity repeat_generate_entity;
    public final TaskRruleUpdateEntity rrule_update_entity;
    public final TaskListSectionUpdateEntity section_update_entity;
    public final TaskSubTaskEntity set_subtask_entity;
    public final TaskSummaryUpdateEntity summary_update_entity;
    public final RichContent target_name;
    public final TargetType target_type;
    public final TaskAddOrRemoveListEntity task_add_or_remove_list_entity;
    public final TaskAncestorEntity task_ancestor_entity;
    public final TaskCompleteEntity task_complete_entity;
    public final TaskDependentEntity task_dependent_entity;
    public final Map<String, String> task_list_guid_to_names;
    public final TaskMilestoneEntity task_milestone_entity;
    public final TaskReminderEntity task_reminder_entity;
    public final TaskTimeEntity time_update_entity;
    public final TaskListViewAdminSettingEntity view_admin_setting_entity;

    public static final class Builder extends Message.Builder<ActivityRecord, Builder> {
        public TaskListAssigneeUpdateEntity assignee_update_entity;
        public TaskAttachmentUpdateEntity attachment_entity;
        public TaskCommentEntity comment_entity;
        public TaskDescriptionUpdateEntity description_update_entity;
        public TaskDueTimeUpdateEntity due_time_update_entity;
        public TaskFieldValueUpdateEntity field_value_update_entity;
        public TaskFollowersEntity followers_entity;
        public String guid;
        public TaskListFieldUpdateEntity list_field_update_entity;
        public Long operate_milli_time;
        public TodoUser operator;
        public TaskOwnerUpdateEntity owner_update_entity;
        public ActivityRecordKey record_key;
        public String related_task_guid;
        public List<String> related_task_list_guids;
        public TaskSubTaskEntity remove_subtask_entity;
        public TaskListRenameEntity rename_entity;
        public TaskRepeatGenerateEntity repeat_generate_entity;
        public TaskRruleUpdateEntity rrule_update_entity;
        public TaskListSectionUpdateEntity section_update_entity;
        public TaskSubTaskEntity set_subtask_entity;
        public TaskSummaryUpdateEntity summary_update_entity;
        public RichContent target_name;
        public TargetType target_type;
        public TaskAddOrRemoveListEntity task_add_or_remove_list_entity;
        public TaskAncestorEntity task_ancestor_entity;
        public TaskCompleteEntity task_complete_entity;
        public TaskDependentEntity task_dependent_entity;
        public Map<String, String> task_list_guid_to_names;
        public TaskMilestoneEntity task_milestone_entity;
        public TaskReminderEntity task_reminder_entity;
        public TaskTimeEntity time_update_entity;
        public TaskListViewAdminSettingEntity view_admin_setting_entity;

        @Override // com.squareup.wire.Message.Builder
        public ActivityRecord build() {
            return new ActivityRecord(this.guid, this.operate_milli_time, this.record_key, this.operator, this.target_type, this.target_name, this.related_task_list_guids, this.task_list_guid_to_names, this.related_task_guid, this.rename_entity, this.section_update_entity, this.assignee_update_entity, this.repeat_generate_entity, this.summary_update_entity, this.description_update_entity, this.owner_update_entity, this.due_time_update_entity, this.rrule_update_entity, this.attachment_entity, this.comment_entity, this.followers_entity, this.list_field_update_entity, this.field_value_update_entity, this.time_update_entity, this.task_milestone_entity, this.task_dependent_entity, this.task_add_or_remove_list_entity, this.task_reminder_entity, this.task_ancestor_entity, this.task_complete_entity, this.set_subtask_entity, this.remove_subtask_entity, this.view_admin_setting_entity, super.buildUnknownFields());
        }

        public Builder() {
            this.related_task_list_guids = Internal.newMutableList();
            this.task_list_guid_to_names = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder assignee_update_entity(TaskListAssigneeUpdateEntity r100) {
            this.assignee_update_entity = r100;
            return this;
        }

        public Builder attachment_entity(TaskAttachmentUpdateEntity r100) {
            this.attachment_entity = r100;
            return this;
        }

        public Builder comment_entity(TaskCommentEntity r100) {
            this.comment_entity = r100;
            return this;
        }

        public Builder description_update_entity(TaskDescriptionUpdateEntity r100) {
            this.description_update_entity = r100;
            return this;
        }

        public Builder due_time_update_entity(TaskDueTimeUpdateEntity r100) {
            this.due_time_update_entity = r100;
            return this;
        }

        public Builder field_value_update_entity(TaskFieldValueUpdateEntity r100) {
            this.field_value_update_entity = r100;
            return this;
        }

        public Builder followers_entity(TaskFollowersEntity r100) {
            this.followers_entity = r100;
            return this;
        }

        public Builder guid(String r100) {
            this.guid = r100;
            return this;
        }

        public Builder list_field_update_entity(TaskListFieldUpdateEntity r100) {
            this.list_field_update_entity = r100;
            return this;
        }

        public Builder operate_milli_time(Long r100) {
            this.operate_milli_time = r100;
            return this;
        }

        public Builder operator(TodoUser r100) {
            this.operator = r100;
            return this;
        }

        public Builder owner_update_entity(TaskOwnerUpdateEntity r100) {
            this.owner_update_entity = r100;
            return this;
        }

        public Builder record_key(ActivityRecordKey r100) {
            this.record_key = r100;
            return this;
        }

        public Builder related_task_guid(String r100) {
            this.related_task_guid = r100;
            return this;
        }

        public Builder related_task_list_guids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.related_task_list_guids = r100;
            return this;
        }

        public Builder remove_subtask_entity(TaskSubTaskEntity r100) {
            this.remove_subtask_entity = r100;
            return this;
        }

        public Builder rename_entity(TaskListRenameEntity r100) {
            this.rename_entity = r100;
            return this;
        }

        public Builder repeat_generate_entity(TaskRepeatGenerateEntity r100) {
            this.repeat_generate_entity = r100;
            return this;
        }

        public Builder rrule_update_entity(TaskRruleUpdateEntity r100) {
            this.rrule_update_entity = r100;
            return this;
        }

        public Builder section_update_entity(TaskListSectionUpdateEntity r100) {
            this.section_update_entity = r100;
            return this;
        }

        public Builder set_subtask_entity(TaskSubTaskEntity r100) {
            this.set_subtask_entity = r100;
            return this;
        }

        public Builder summary_update_entity(TaskSummaryUpdateEntity r100) {
            this.summary_update_entity = r100;
            return this;
        }

        public Builder target_name(RichContent r100) {
            this.target_name = r100;
            return this;
        }

        public Builder target_type(TargetType r100) {
            this.target_type = r100;
            return this;
        }

        public Builder task_add_or_remove_list_entity(TaskAddOrRemoveListEntity r100) {
            this.task_add_or_remove_list_entity = r100;
            return this;
        }

        public Builder task_ancestor_entity(TaskAncestorEntity r100) {
            this.task_ancestor_entity = r100;
            return this;
        }

        public Builder task_complete_entity(TaskCompleteEntity r100) {
            this.task_complete_entity = r100;
            return this;
        }

        public Builder task_dependent_entity(TaskDependentEntity r100) {
            this.task_dependent_entity = r100;
            return this;
        }

        public Builder task_list_guid_to_names(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.task_list_guid_to_names = r100;
            return this;
        }

        public Builder task_milestone_entity(TaskMilestoneEntity r100) {
            this.task_milestone_entity = r100;
            return this;
        }

        public Builder task_reminder_entity(TaskReminderEntity r100) {
            this.task_reminder_entity = r100;
            return this;
        }

        public Builder time_update_entity(TaskTimeEntity r100) {
            this.time_update_entity = r100;
            return this;
        }

        public Builder view_admin_setting_entity(TaskListViewAdminSettingEntity r100) {
            this.view_admin_setting_entity = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ActivityRecord extends ProtoAdapter<ActivityRecord> {
        private final ProtoAdapter<Map<String, String>> task_list_guid_to_names;

        public ProtoAdapter_ActivityRecord() {
            super(FieldEncoding.LENGTH_DELIMITED, ActivityRecord.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.task_list_guid_to_names = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ActivityRecord decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.guid = "";
            r101.operate_milli_time = 0L;
            r101.record_key = ActivityRecordKey.UNKNOWN_RECORD;
            r101.target_type = TargetType.TASK_LIST;
            r101.related_task_guid = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L49;
            if (r103 != 204) goto L7;
            r101.view_admin_setting_entity = TaskListViewAdminSettingEntity.ADAPTER.decode(r100);
            goto L3
        L7:
            switch(r103) {
                case 1: goto L47;
                case 2: goto L46;
                case 3: goto L53;
                case 4: goto L41;
                case 5: goto L51;
                case 6: goto L36;
                case 7: goto L35;
                case 8: goto L34;
                case 9: goto L33;
                default: goto L8;
            };
        L51:
            r101.target_type = TargetType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L39
        L39:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L53:
            r101.record_key = ActivityRecordKey.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L44
        L44:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L33:
            r101.related_task_guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L34:
            r101.task_list_guid_to_names.putAll(this.task_list_guid_to_names.decode(r100));
            goto L3
        L35:
            r101.related_task_list_guids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L36:
            r101.target_name = RichContent.ADAPTER.decode(r100);
            goto L3
        L41:
            r101.operator = TodoUser.ADAPTER.decode(r100);
            goto L3
        L46:
            r101.operate_milli_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L47:
            r101.guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            switch(r103) {
                case 100: goto L32;
                case 101: goto L31;
                case 102: goto L30;
                case 103: goto L29;
                case 104: goto L28;
                case 105: goto L27;
                case 106: goto L26;
                case 107: goto L25;
                case 108: goto L24;
                case 109: goto L23;
                case 110: goto L22;
                case 111: goto L21;
                case 112: goto L20;
                case 113: goto L19;
                case 114: goto L18;
                case 115: goto L17;
                case 116: goto L16;
                case 117: goto L15;
                case 118: goto L14;
                case 119: goto L13;
                case 120: goto L12;
                case 121: goto L11;
                case 122: goto L10;
                default: goto L9;
            };
        L10:
            r101.remove_subtask_entity = TaskSubTaskEntity.ADAPTER.decode(r100);
            goto L3
        L11:
            r101.set_subtask_entity = TaskSubTaskEntity.ADAPTER.decode(r100);
            goto L3
        L12:
            r101.task_complete_entity = TaskCompleteEntity.ADAPTER.decode(r100);
            goto L3
        L13:
            r101.task_ancestor_entity = TaskAncestorEntity.ADAPTER.decode(r100);
            goto L3
        L14:
            r101.task_reminder_entity = TaskReminderEntity.ADAPTER.decode(r100);
            goto L3
        L15:
            r101.task_add_or_remove_list_entity = TaskAddOrRemoveListEntity.ADAPTER.decode(r100);
            goto L3
        L16:
            r101.task_dependent_entity = TaskDependentEntity.ADAPTER.decode(r100);
            goto L3
        L17:
            r101.task_milestone_entity = TaskMilestoneEntity.ADAPTER.decode(r100);
            goto L3
        L18:
            r101.time_update_entity = TaskTimeEntity.ADAPTER.decode(r100);
            goto L3
        L19:
            r101.field_value_update_entity = TaskFieldValueUpdateEntity.ADAPTER.decode(r100);
            goto L3
        L20:
            r101.list_field_update_entity = TaskListFieldUpdateEntity.ADAPTER.decode(r100);
            goto L3
        L21:
            r101.followers_entity = TaskFollowersEntity.ADAPTER.decode(r100);
            goto L3
        L22:
            r101.comment_entity = TaskCommentEntity.ADAPTER.decode(r100);
            goto L3
        L23:
            r101.attachment_entity = TaskAttachmentUpdateEntity.ADAPTER.decode(r100);
            goto L3
        L24:
            r101.rrule_update_entity = TaskRruleUpdateEntity.ADAPTER.decode(r100);
            goto L3
        L25:
            r101.due_time_update_entity = TaskDueTimeUpdateEntity.ADAPTER.decode(r100);
            goto L3
        L26:
            r101.owner_update_entity = TaskOwnerUpdateEntity.ADAPTER.decode(r100);
            goto L3
        L27:
            r101.description_update_entity = TaskDescriptionUpdateEntity.ADAPTER.decode(r100);
            goto L3
        L28:
            r101.summary_update_entity = TaskSummaryUpdateEntity.ADAPTER.decode(r100);
            goto L3
        L29:
            r101.repeat_generate_entity = TaskRepeatGenerateEntity.ADAPTER.decode(r100);
            goto L3
        L30:
            r101.assignee_update_entity = TaskListAssigneeUpdateEntity.ADAPTER.decode(r100);
            goto L3
        L31:
            r101.section_update_entity = TaskListSectionUpdateEntity.ADAPTER.decode(r100);
            goto L3
        L32:
            r101.rename_entity = TaskListRenameEntity.ADAPTER.decode(r100);
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L49:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ActivityRecord r100) {
            String r101 = r100.guid;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.operate_milli_time;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            ActivityRecordKey r107 = r100.record_key;
            if (r107 == null) goto L13;
            int r108 = ActivityRecordKey.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            TodoUser r110 = r100.operator;
            if (r110 == null) goto L17;
            int r111 = TodoUser.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            TargetType r113 = r100.target_type;
            if (r113 == null) goto L21;
            int r114 = TargetType.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            RichContent r116 = r100.target_name;
            if (r116 == null) goto L25;
            int r117 = RichContent.ADAPTER.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            ProtoAdapter<String> r119 = ProtoAdapter.STRING;
            int r120 = (r118 + r119.asRepeated().encodedSizeWithTag(7, r100.related_task_list_guids)) + this.task_list_guid_to_names.encodedSizeWithTag(8, r100.task_list_guid_to_names);
            String r121 = r100.related_task_guid;
            if (r121 == null) goto L29;
            int r122 = r119.encodedSizeWithTag(9, r121);
        L30:
            int r123 = r120 + r122;
            TaskListRenameEntity r124 = r100.rename_entity;
            if (r124 == null) goto L33;
            int r125 = TaskListRenameEntity.ADAPTER.encodedSizeWithTag(100, r124);
        L34:
            int r126 = r123 + r125;
            TaskListSectionUpdateEntity r127 = r100.section_update_entity;
            if (r127 == null) goto L37;
            int r128 = TaskListSectionUpdateEntity.ADAPTER.encodedSizeWithTag(101, r127);
        L38:
            int r129 = r126 + r128;
            TaskListAssigneeUpdateEntity r130 = r100.assignee_update_entity;
            if (r130 == null) goto L41;
            int r131 = TaskListAssigneeUpdateEntity.ADAPTER.encodedSizeWithTag(102, r130);
        L42:
            int r132 = r129 + r131;
            TaskRepeatGenerateEntity r133 = r100.repeat_generate_entity;
            if (r133 == null) goto L45;
            int r134 = TaskRepeatGenerateEntity.ADAPTER.encodedSizeWithTag(103, r133);
        L46:
            int r135 = r132 + r134;
            TaskSummaryUpdateEntity r136 = r100.summary_update_entity;
            if (r136 == null) goto L49;
            int r137 = TaskSummaryUpdateEntity.ADAPTER.encodedSizeWithTag(104, r136);
        L50:
            int r138 = r135 + r137;
            TaskDescriptionUpdateEntity r139 = r100.description_update_entity;
            if (r139 == null) goto L53;
            int r140 = TaskDescriptionUpdateEntity.ADAPTER.encodedSizeWithTag(105, r139);
        L54:
            int r141 = r138 + r140;
            TaskOwnerUpdateEntity r142 = r100.owner_update_entity;
            if (r142 == null) goto L57;
            int r143 = TaskOwnerUpdateEntity.ADAPTER.encodedSizeWithTag(106, r142);
        L58:
            int r144 = r141 + r143;
            TaskDueTimeUpdateEntity r145 = r100.due_time_update_entity;
            if (r145 == null) goto L61;
            int r146 = TaskDueTimeUpdateEntity.ADAPTER.encodedSizeWithTag(107, r145);
        L62:
            int r147 = r144 + r146;
            TaskRruleUpdateEntity r148 = r100.rrule_update_entity;
            if (r148 == null) goto L65;
            int r149 = TaskRruleUpdateEntity.ADAPTER.encodedSizeWithTag(108, r148);
        L66:
            int r150 = r147 + r149;
            TaskAttachmentUpdateEntity r151 = r100.attachment_entity;
            if (r151 == null) goto L69;
            int r152 = TaskAttachmentUpdateEntity.ADAPTER.encodedSizeWithTag(109, r151);
        L70:
            int r153 = r150 + r152;
            TaskCommentEntity r154 = r100.comment_entity;
            if (r154 == null) goto L73;
            int r155 = TaskCommentEntity.ADAPTER.encodedSizeWithTag(110, r154);
        L74:
            int r156 = r153 + r155;
            TaskFollowersEntity r157 = r100.followers_entity;
            if (r157 == null) goto L77;
            int r158 = TaskFollowersEntity.ADAPTER.encodedSizeWithTag(111, r157);
        L78:
            int r159 = r156 + r158;
            TaskListFieldUpdateEntity r160 = r100.list_field_update_entity;
            if (r160 == null) goto L81;
            int r161 = TaskListFieldUpdateEntity.ADAPTER.encodedSizeWithTag(112, r160);
        L82:
            int r162 = r159 + r161;
            TaskFieldValueUpdateEntity r163 = r100.field_value_update_entity;
            if (r163 == null) goto L85;
            int r164 = TaskFieldValueUpdateEntity.ADAPTER.encodedSizeWithTag(113, r163);
        L86:
            int r165 = r162 + r164;
            TaskTimeEntity r166 = r100.time_update_entity;
            if (r166 == null) goto L89;
            int r167 = TaskTimeEntity.ADAPTER.encodedSizeWithTag(114, r166);
        L90:
            int r168 = r165 + r167;
            TaskMilestoneEntity r169 = r100.task_milestone_entity;
            if (r169 == null) goto L93;
            int r170 = TaskMilestoneEntity.ADAPTER.encodedSizeWithTag(115, r169);
        L94:
            int r171 = r168 + r170;
            TaskDependentEntity r172 = r100.task_dependent_entity;
            if (r172 == null) goto L97;
            int r173 = TaskDependentEntity.ADAPTER.encodedSizeWithTag(116, r172);
        L98:
            int r174 = r171 + r173;
            TaskAddOrRemoveListEntity r175 = r100.task_add_or_remove_list_entity;
            if (r175 == null) goto L101;
            int r176 = TaskAddOrRemoveListEntity.ADAPTER.encodedSizeWithTag(117, r175);
        L102:
            int r177 = r174 + r176;
            TaskReminderEntity r178 = r100.task_reminder_entity;
            if (r178 == null) goto L105;
            int r179 = TaskReminderEntity.ADAPTER.encodedSizeWithTag(118, r178);
        L106:
            int r180 = r177 + r179;
            TaskAncestorEntity r181 = r100.task_ancestor_entity;
            if (r181 == null) goto L109;
            int r182 = TaskAncestorEntity.ADAPTER.encodedSizeWithTag(119, r181);
        L110:
            int r183 = r180 + r182;
            TaskCompleteEntity r184 = r100.task_complete_entity;
            if (r184 == null) goto L113;
            int r185 = TaskCompleteEntity.ADAPTER.encodedSizeWithTag(120, r184);
        L114:
            int r186 = r183 + r185;
            TaskSubTaskEntity r187 = r100.set_subtask_entity;
            if (r187 == null) goto L117;
            int r188 = TaskSubTaskEntity.ADAPTER.encodedSizeWithTag(121, r187);
        L118:
            int r189 = r186 + r188;
            TaskSubTaskEntity r190 = r100.remove_subtask_entity;
            if (r190 == null) goto L121;
            int r191 = TaskSubTaskEntity.ADAPTER.encodedSizeWithTag(122, r190);
        L122:
            int r192 = r189 + r191;
            TaskListViewAdminSettingEntity r193 = r100.view_admin_setting_entity;
            if (r193 == null) goto L126;
            r102 = TaskListViewAdminSettingEntity.ADAPTER.encodedSizeWithTag(204, r193);
        L126:
            return (r192 + r102) + r100.unknownFields().size();
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
            r152 = 0;
            goto L70
        L65:
            r149 = 0;
            goto L66
        L61:
            r146 = 0;
            goto L62
        L57:
            r143 = 0;
            goto L58
        L53:
            r140 = 0;
            goto L54
        L49:
            r137 = 0;
            goto L50
        L45:
            r134 = 0;
            goto L46
        L41:
            r131 = 0;
            goto L42
        L37:
            r128 = 0;
            goto L38
        L33:
            r125 = 0;
            goto L34
        L29:
            r122 = 0;
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
        public /* bridge */ /* synthetic */ ActivityRecord decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ActivityRecord r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ActivityRecord r101) throws IOException {
            String r102 = r101.guid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.operate_milli_time;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            ActivityRecordKey r104 = r101.record_key;
            if (r104 == null) goto L11;
            ActivityRecordKey.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            TodoUser r105 = r101.operator;
            if (r105 == null) goto L14;
            TodoUser.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            TargetType r106 = r101.target_type;
            if (r106 == null) goto L17;
            TargetType.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            RichContent r107 = r101.target_name;
            if (r107 == null) goto L20;
            RichContent.ADAPTER.encodeWithTag(r100, 6, r107);
        L20:
            ProtoAdapter<String> r108 = ProtoAdapter.STRING;
            r108.asRepeated().encodeWithTag(r100, 7, r101.related_task_list_guids);
            this.task_list_guid_to_names.encodeWithTag(r100, 8, r101.task_list_guid_to_names);
            String r109 = r101.related_task_guid;
            if (r109 == null) goto L23;
            r108.encodeWithTag(r100, 9, r109);
        L23:
            TaskListRenameEntity r110 = r101.rename_entity;
            if (r110 == null) goto L26;
            TaskListRenameEntity.ADAPTER.encodeWithTag(r100, 100, r110);
        L26:
            TaskListSectionUpdateEntity r111 = r101.section_update_entity;
            if (r111 == null) goto L29;
            TaskListSectionUpdateEntity.ADAPTER.encodeWithTag(r100, 101, r111);
        L29:
            TaskListAssigneeUpdateEntity r112 = r101.assignee_update_entity;
            if (r112 == null) goto L32;
            TaskListAssigneeUpdateEntity.ADAPTER.encodeWithTag(r100, 102, r112);
        L32:
            TaskRepeatGenerateEntity r113 = r101.repeat_generate_entity;
            if (r113 == null) goto L35;
            TaskRepeatGenerateEntity.ADAPTER.encodeWithTag(r100, 103, r113);
        L35:
            TaskSummaryUpdateEntity r114 = r101.summary_update_entity;
            if (r114 == null) goto L38;
            TaskSummaryUpdateEntity.ADAPTER.encodeWithTag(r100, 104, r114);
        L38:
            TaskDescriptionUpdateEntity r115 = r101.description_update_entity;
            if (r115 == null) goto L41;
            TaskDescriptionUpdateEntity.ADAPTER.encodeWithTag(r100, 105, r115);
        L41:
            TaskOwnerUpdateEntity r116 = r101.owner_update_entity;
            if (r116 == null) goto L44;
            TaskOwnerUpdateEntity.ADAPTER.encodeWithTag(r100, 106, r116);
        L44:
            TaskDueTimeUpdateEntity r117 = r101.due_time_update_entity;
            if (r117 == null) goto L47;
            TaskDueTimeUpdateEntity.ADAPTER.encodeWithTag(r100, 107, r117);
        L47:
            TaskRruleUpdateEntity r118 = r101.rrule_update_entity;
            if (r118 == null) goto L50;
            TaskRruleUpdateEntity.ADAPTER.encodeWithTag(r100, 108, r118);
        L50:
            TaskAttachmentUpdateEntity r119 = r101.attachment_entity;
            if (r119 == null) goto L53;
            TaskAttachmentUpdateEntity.ADAPTER.encodeWithTag(r100, 109, r119);
        L53:
            TaskCommentEntity r120 = r101.comment_entity;
            if (r120 == null) goto L56;
            TaskCommentEntity.ADAPTER.encodeWithTag(r100, 110, r120);
        L56:
            TaskFollowersEntity r121 = r101.followers_entity;
            if (r121 == null) goto L59;
            TaskFollowersEntity.ADAPTER.encodeWithTag(r100, 111, r121);
        L59:
            TaskListFieldUpdateEntity r122 = r101.list_field_update_entity;
            if (r122 == null) goto L62;
            TaskListFieldUpdateEntity.ADAPTER.encodeWithTag(r100, 112, r122);
        L62:
            TaskFieldValueUpdateEntity r123 = r101.field_value_update_entity;
            if (r123 == null) goto L65;
            TaskFieldValueUpdateEntity.ADAPTER.encodeWithTag(r100, 113, r123);
        L65:
            TaskTimeEntity r124 = r101.time_update_entity;
            if (r124 == null) goto L68;
            TaskTimeEntity.ADAPTER.encodeWithTag(r100, 114, r124);
        L68:
            TaskMilestoneEntity r125 = r101.task_milestone_entity;
            if (r125 == null) goto L71;
            TaskMilestoneEntity.ADAPTER.encodeWithTag(r100, 115, r125);
        L71:
            TaskDependentEntity r126 = r101.task_dependent_entity;
            if (r126 == null) goto L74;
            TaskDependentEntity.ADAPTER.encodeWithTag(r100, 116, r126);
        L74:
            TaskAddOrRemoveListEntity r127 = r101.task_add_or_remove_list_entity;
            if (r127 == null) goto L77;
            TaskAddOrRemoveListEntity.ADAPTER.encodeWithTag(r100, 117, r127);
        L77:
            TaskReminderEntity r128 = r101.task_reminder_entity;
            if (r128 == null) goto L80;
            TaskReminderEntity.ADAPTER.encodeWithTag(r100, 118, r128);
        L80:
            TaskAncestorEntity r129 = r101.task_ancestor_entity;
            if (r129 == null) goto L83;
            TaskAncestorEntity.ADAPTER.encodeWithTag(r100, 119, r129);
        L83:
            TaskCompleteEntity r130 = r101.task_complete_entity;
            if (r130 == null) goto L86;
            TaskCompleteEntity.ADAPTER.encodeWithTag(r100, 120, r130);
        L86:
            TaskSubTaskEntity r131 = r101.set_subtask_entity;
            if (r131 == null) goto L89;
            TaskSubTaskEntity.ADAPTER.encodeWithTag(r100, 121, r131);
        L89:
            TaskSubTaskEntity r132 = r101.remove_subtask_entity;
            if (r132 == null) goto L92;
            TaskSubTaskEntity.ADAPTER.encodeWithTag(r100, 122, r132);
        L92:
            TaskListViewAdminSettingEntity r133 = r101.view_admin_setting_entity;
            if (r133 == null) goto L95;
            TaskListViewAdminSettingEntity.ADAPTER.encodeWithTag(r100, 204, r133);
        L95:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ActivityRecord r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ActivityRecord();
        DEFAULT_OPERATE_MILLI_TIME = 0L;
        DEFAULT_RECORD_KEY = ActivityRecordKey.UNKNOWN_RECORD;
        DEFAULT_TARGET_TYPE = TargetType.TASK_LIST;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.guid = this.guid;
        r100.operate_milli_time = this.operate_milli_time;
        r100.record_key = this.record_key;
        r100.operator = this.operator;
        r100.target_type = this.target_type;
        r100.target_name = this.target_name;
        r100.related_task_list_guids = Internal.copyOf("related_task_list_guids", this.related_task_list_guids);
        r100.task_list_guid_to_names = Internal.copyOf("task_list_guid_to_names", this.task_list_guid_to_names);
        r100.related_task_guid = this.related_task_guid;
        r100.rename_entity = this.rename_entity;
        r100.section_update_entity = this.section_update_entity;
        r100.assignee_update_entity = this.assignee_update_entity;
        r100.repeat_generate_entity = this.repeat_generate_entity;
        r100.summary_update_entity = this.summary_update_entity;
        r100.description_update_entity = this.description_update_entity;
        r100.owner_update_entity = this.owner_update_entity;
        r100.due_time_update_entity = this.due_time_update_entity;
        r100.rrule_update_entity = this.rrule_update_entity;
        r100.attachment_entity = this.attachment_entity;
        r100.comment_entity = this.comment_entity;
        r100.followers_entity = this.followers_entity;
        r100.list_field_update_entity = this.list_field_update_entity;
        r100.field_value_update_entity = this.field_value_update_entity;
        r100.time_update_entity = this.time_update_entity;
        r100.task_milestone_entity = this.task_milestone_entity;
        r100.task_dependent_entity = this.task_dependent_entity;
        r100.task_add_or_remove_list_entity = this.task_add_or_remove_list_entity;
        r100.task_reminder_entity = this.task_reminder_entity;
        r100.task_ancestor_entity = this.task_ancestor_entity;
        r100.task_complete_entity = this.task_complete_entity;
        r100.set_subtask_entity = this.set_subtask_entity;
        r100.remove_subtask_entity = this.remove_subtask_entity;
        r100.view_admin_setting_entity = this.view_admin_setting_entity;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ActivityRecord.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ActivityRecord(String r310, Long r311, ActivityRecordKey r312, TodoUser r313, TargetType r410, RichContent r411, List<String> r412, Map<String, String> r413, String r414, TaskListRenameEntity r415, TaskListSectionUpdateEntity r416, TaskListAssigneeUpdateEntity r417, TaskRepeatGenerateEntity r418, TaskSummaryUpdateEntity r419, TaskDescriptionUpdateEntity r510, TaskOwnerUpdateEntity r511, TaskDueTimeUpdateEntity r512, TaskRruleUpdateEntity r513, TaskAttachmentUpdateEntity r514, TaskCommentEntity r515, TaskFollowersEntity r516, TaskListFieldUpdateEntity r517, TaskFieldValueUpdateEntity r518, TaskTimeEntity r519, TaskMilestoneEntity r610, TaskDependentEntity r611, TaskAddOrRemoveListEntity r612, TaskReminderEntity r613, TaskAncestorEntity r614, TaskCompleteEntity r615, TaskSubTaskEntity r616, TaskSubTaskEntity r617, TaskListViewAdminSettingEntity r618) {
        this(r310, r311, r312, r313, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, ByteString.EMPTY);
    }

    public ActivityRecord(String r100, Long r101, ActivityRecordKey r102, TodoUser r103, TargetType r104, RichContent r105, List<String> r110, Map<String, String> r111, String r112, TaskListRenameEntity r113, TaskListSectionUpdateEntity r114, TaskListAssigneeUpdateEntity r115, TaskRepeatGenerateEntity r116, TaskSummaryUpdateEntity r117, TaskDescriptionUpdateEntity r118, TaskOwnerUpdateEntity r119, TaskDueTimeUpdateEntity r210, TaskRruleUpdateEntity r211, TaskAttachmentUpdateEntity r212, TaskCommentEntity r213, TaskFollowersEntity r214, TaskListFieldUpdateEntity r215, TaskFieldValueUpdateEntity r216, TaskTimeEntity r217, TaskMilestoneEntity r218, TaskDependentEntity r219, TaskAddOrRemoveListEntity r310, TaskReminderEntity r311, TaskAncestorEntity r312, TaskCompleteEntity r313, TaskSubTaskEntity r314, TaskSubTaskEntity r315, TaskListViewAdminSettingEntity r316, ByteString r317) {
        super(ADAPTER, r317);
        this.guid = r100;
        this.operate_milli_time = r101;
        this.record_key = r102;
        this.operator = r103;
        this.target_type = r104;
        this.target_name = r105;
        this.related_task_list_guids = Internal.immutableCopyOf("related_task_list_guids", r110);
        this.task_list_guid_to_names = Internal.immutableCopyOf("task_list_guid_to_names", r111);
        this.related_task_guid = r112;
        this.rename_entity = r113;
        this.section_update_entity = r114;
        this.assignee_update_entity = r115;
        this.repeat_generate_entity = r116;
        this.summary_update_entity = r117;
        this.description_update_entity = r118;
        this.owner_update_entity = r119;
        this.due_time_update_entity = r210;
        this.rrule_update_entity = r211;
        this.attachment_entity = r212;
        this.comment_entity = r213;
        this.followers_entity = r214;
        this.list_field_update_entity = r215;
        this.field_value_update_entity = r216;
        this.time_update_entity = r217;
        this.task_milestone_entity = r218;
        this.task_dependent_entity = r219;
        this.task_add_or_remove_list_entity = r310;
        this.task_reminder_entity = r311;
        this.task_ancestor_entity = r312;
        this.task_complete_entity = r313;
        this.set_subtask_entity = r314;
        this.remove_subtask_entity = r315;
        this.view_admin_setting_entity = r316;
    }
}
