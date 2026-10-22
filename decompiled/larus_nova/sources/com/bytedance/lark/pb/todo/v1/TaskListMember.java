package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TaskListMember extends Message<TaskListMember, Builder> {
    public static final ProtoAdapter<TaskListMember> ADAPTER = null;
    public static final TodoItemMemberRole DEFAULT_ROLE = null;
    private static final long serialVersionUID = 0;
    public final List<TodoItemMemberRole> enable_roles;
    public final TaskItemMember member;
    public final Map<Integer, Boolean> permissions;
    public final TodoItemMemberRole role;

    public static final class Builder extends Message.Builder<TaskListMember, Builder> {
        public List<TodoItemMemberRole> enable_roles;
        public TaskItemMember member;
        public Map<Integer, Boolean> permissions;
        public TodoItemMemberRole role;

        @Override // com.squareup.wire.Message.Builder
        public TaskListMember build() {
            return new TaskListMember(this.member, this.role, this.permissions, this.enable_roles, super.buildUnknownFields());
        }

        public Builder() {
            this.permissions = Internal.newMutableMap();
            this.enable_roles = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder enable_roles(List<TodoItemMemberRole> r100) {
            Internal.checkElementsNotNull(r100);
            this.enable_roles = r100;
            return this;
        }

        public Builder member(TaskItemMember r100) {
            this.member = r100;
            return this;
        }

        public Builder permissions(Map<Integer, Boolean> r100) {
            Internal.checkElementsNotNull(r100);
            this.permissions = r100;
            return this;
        }

        public Builder role(TodoItemMemberRole r100) {
            this.role = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskListMember extends ProtoAdapter<TaskListMember> {
        private final ProtoAdapter<Map<Integer, Boolean>> permissions;

        public ProtoAdapter_TaskListMember() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskListMember.class);
            this.permissions = ProtoAdapter.newMapAdapter(ProtoAdapter.INT32, ProtoAdapter.BOOL);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskListMember decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.role = TodoItemMemberRole.NONE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.member = TaskItemMember.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.role = TodoItemMemberRole.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
        L21:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.permissions.putAll(this.permissions.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.enable_roles.add(TodoItemMemberRole.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TaskListMember r100) {
            TaskItemMember r101 = r100.member;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = TaskItemMember.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            TodoItemMemberRole r104 = r100.role;
            if (r104 == null) goto L10;
            r102 = TodoItemMemberRole.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (((r103 + r102) + this.permissions.encodedSizeWithTag(3, r100.permissions)) + TodoItemMemberRole.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.enable_roles)) + r100.unknownFields().size();
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
            TaskItemMember r102 = r101.member;
            if (r102 == null) goto L5;
            TaskItemMember.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            TodoItemMemberRole r103 = r101.role;
            if (r103 == null) goto L8;
            TodoItemMemberRole.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            this.permissions.encodeWithTag(r100, 3, r101.permissions);
            TodoItemMemberRole.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.enable_roles);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskListMember r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskListMember();
        DEFAULT_ROLE = TodoItemMemberRole.NONE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.member = this.member;
        r100.role = this.role;
        r100.permissions = Internal.copyOf(ComplianceResult.JsonKey.PERMISSIONS, this.permissions);
        r100.enable_roles = Internal.copyOf("enable_roles", this.enable_roles);
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

    public TaskListMember(TaskItemMember r100, TodoItemMemberRole r101, Map<Integer, Boolean> r102, List<TodoItemMemberRole> r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public TaskListMember(TaskItemMember r100, TodoItemMemberRole r101, Map<Integer, Boolean> r102, List<TodoItemMemberRole> r103, ByteString r104) {
        super(ADAPTER, r104);
        this.member = r100;
        this.role = r101;
        this.permissions = Internal.immutableCopyOf(ComplianceResult.JsonKey.PERMISSIONS, r102);
        this.enable_roles = Internal.immutableCopyOf("enable_roles", r103);
    }
}
