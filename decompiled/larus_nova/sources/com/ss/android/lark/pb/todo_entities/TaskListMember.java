package com.ss.android.lark.pb.todo_entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class TaskListMember extends Message<TaskListMember, Builder> {
    public static final ProtoAdapter<TaskListMember> ADAPTER = null;
    public static final String DEFAULT_MEMBER_ID = "";
    private static final long serialVersionUID = 0;
    public final List<TodoItemMemberRole> menable_roles;
    public final String mmember_id;
    public final TaskContainerPermission mpermission;
    public final TodoItemMemberRole mrole;
    public final TodoItemMemberType mtype;

    public static final class Builder extends Message.Builder<TaskListMember, Builder> {
        public List<TodoItemMemberRole> menable_roles;
        public String mmember_id;
        public TaskContainerPermission mpermission;
        public TodoItemMemberRole mrole;
        public TodoItemMemberType mtype;

        @Override // com.squareup.wire.Message.Builder
        public TaskListMember build() {
            return new TaskListMember(this.mmember_id, this.mtype, this.mrole, this.mpermission, this.menable_roles, super.buildUnknownFields());
        }

        public Builder() {
            this.menable_roles = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder enable_roles(List<TodoItemMemberRole> r100) {
            Internal.checkElementsNotNull(r100);
            this.menable_roles = r100;
            return this;
        }

        public Builder member_id(String r100) {
            this.mmember_id = r100;
            return this;
        }

        public Builder permission(TaskContainerPermission r100) {
            this.mpermission = r100;
            return this;
        }

        public Builder role(TodoItemMemberRole r100) {
            this.mrole = r100;
            return this;
        }

        public Builder type(TodoItemMemberType r100) {
            this.mtype = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskListMember extends ProtoAdapter<TaskListMember> {
        public ProtoAdapter_TaskListMember() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskListMember.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskListMember decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mmember_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L30;
            if (r103 != 1) goto L8;
            r101.mmember_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mtype = TodoItemMemberType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L27
        L27:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mrole = TodoItemMemberRole.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
        L23:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.mpermission = TaskContainerPermission.ADAPTER.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.menable_roles.add(TodoItemMemberRole.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L30:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TaskListMember r100) {
            String r101 = r100.mmember_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            TodoItemMemberType r104 = r100.mtype;
            if (r104 == null) goto L9;
            int r105 = TodoItemMemberType.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            TodoItemMemberRole r107 = r100.mrole;
            if (r107 == null) goto L13;
            int r108 = TodoItemMemberRole.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            TaskContainerPermission r110 = r100.mpermission;
            if (r110 == null) goto L18;
            r102 = TaskContainerPermission.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            return ((r109 + r102) + TodoItemMemberRole.ADAPTER.asRepeated().encodedSizeWithTag(5, r100.menable_roles)) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ TaskListMember decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TaskListMember r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TaskListMember r101) throws IOException {
            String r102 = r101.mmember_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            TodoItemMemberType r103 = r101.mtype;
            if (r103 == null) goto L8;
            TodoItemMemberType.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            TodoItemMemberRole r104 = r101.mrole;
            if (r104 == null) goto L11;
            TodoItemMemberRole.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            TaskContainerPermission r105 = r101.mpermission;
            if (r105 == null) goto L14;
            TaskContainerPermission.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            TodoItemMemberRole.ADAPTER.asRepeated().encodeWithTag(r100, 5, r101.menable_roles);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskListMember r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskListMember();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mmember_id = this.mmember_id;
        r100.mtype = this.mtype;
        r100.mrole = this.mrole;
        r100.mpermission = this.mpermission;
        r100.menable_roles = Internal.copyOf("menable_roles", this.menable_roles);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TaskListMember.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TaskListMember(String r100, TodoItemMemberType r101, TodoItemMemberRole r110, TaskContainerPermission r111, List<TodoItemMemberRole> r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public TaskListMember(String r100, TodoItemMemberType r101, TodoItemMemberRole r102, TaskContainerPermission r103, List<TodoItemMemberRole> r104, ByteString r105) {
        super(ADAPTER, r105);
        this.mmember_id = r100;
        this.mtype = r101;
        this.mrole = r102;
        this.mpermission = r103;
        this.menable_roles = Internal.immutableCopyOf("menable_roles", r104);
    }
}
