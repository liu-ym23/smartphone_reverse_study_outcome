package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TaskListAssigneeUpdateEntity extends Message<TaskListAssigneeUpdateEntity, Builder> {
    public static final ProtoAdapter<TaskListAssigneeUpdateEntity> ADAPTER = null;
    public static final TodoItemMemberRole DEFAULT_NEW_ROLE = null;
    public static final TodoItemMemberRole DEFAULT_OLD_ROLE = null;
    private static final long serialVersionUID = 0;
    public final TodoItemMemberRole new_role;
    public final TodoItemMemberRole old_role;
    public final List<TaskItemMember> target_members;

    public static final class Builder extends Message.Builder<TaskListAssigneeUpdateEntity, Builder> {
        public TodoItemMemberRole new_role;
        public TodoItemMemberRole old_role;
        public List<TaskItemMember> target_members;

        @Override // com.squareup.wire.Message.Builder
        public TaskListAssigneeUpdateEntity build() {
            return new TaskListAssigneeUpdateEntity(this.target_members, this.old_role, this.new_role, super.buildUnknownFields());
        }

        public Builder() {
            this.target_members = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder new_role(TodoItemMemberRole r100) {
            this.new_role = r100;
            return this;
        }

        public Builder old_role(TodoItemMemberRole r100) {
            this.old_role = r100;
            return this;
        }

        public Builder target_members(List<TaskItemMember> r100) {
            Internal.checkElementsNotNull(r100);
            this.target_members = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskListAssigneeUpdateEntity extends ProtoAdapter<TaskListAssigneeUpdateEntity> {
        public ProtoAdapter_TaskListAssigneeUpdateEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskListAssigneeUpdateEntity.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskListAssigneeUpdateEntity decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            TodoItemMemberRole r102 = TodoItemMemberRole.NONE;
            r101.old_role = r102;
            r101.new_role = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L21;
            if (r104 != 1) goto L8;
            r101.target_members.add(TaskItemMember.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.old_role = TodoItemMemberRole.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r104 != 3) goto L11;
            r101.new_role = TodoItemMemberRole.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TaskListAssigneeUpdateEntity r100) {
            int r101 = TaskItemMember.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.target_members);
            TodoItemMemberRole r102 = r100.old_role;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = TodoItemMemberRole.ADAPTER.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            TodoItemMemberRole r106 = r100.new_role;
            if (r106 == null) goto L10;
            r103 = TodoItemMemberRole.ADAPTER.encodedSizeWithTag(3, r106);
        L10:
            return (r105 + r103) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TaskListAssigneeUpdateEntity decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TaskListAssigneeUpdateEntity r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TaskListAssigneeUpdateEntity r101) throws IOException {
            TaskItemMember.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.target_members);
            TodoItemMemberRole r102 = r101.old_role;
            if (r102 == null) goto L5;
            TodoItemMemberRole.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            TodoItemMemberRole r103 = r101.new_role;
            if (r103 == null) goto L8;
            TodoItemMemberRole.ADAPTER.encodeWithTag(r100, 3, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskListAssigneeUpdateEntity r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskListAssigneeUpdateEntity();
        TodoItemMemberRole r100 = TodoItemMemberRole.NONE;
        DEFAULT_OLD_ROLE = r100;
        DEFAULT_NEW_ROLE = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.target_members = Internal.copyOf("target_members", this.target_members);
        r100.old_role = this.old_role;
        r100.new_role = this.new_role;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TaskListAssigneeUpdateEntity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TaskListAssigneeUpdateEntity(List<TaskItemMember> r100, TodoItemMemberRole r101, TodoItemMemberRole r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public TaskListAssigneeUpdateEntity(List<TaskItemMember> r100, TodoItemMemberRole r101, TodoItemMemberRole r102, ByteString r103) {
        super(ADAPTER, r103);
        this.target_members = Internal.immutableCopyOf("target_members", r100);
        this.old_role = r101;
        this.new_role = r102;
    }
}
