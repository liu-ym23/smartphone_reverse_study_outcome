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
public final class TaskCompleteEntity extends Message<TaskCompleteEntity, Builder> {
    public static final ProtoAdapter<TaskCompleteEntity> ADAPTER = null;
    public static final Boolean DEFAULT_IS_WHOLE_TODO = null;
    private static final long serialVersionUID = 0;
    public final Boolean is_whole_todo;
    public final List<TodoUser> target_users;

    public static final class Builder extends Message.Builder<TaskCompleteEntity, Builder> {
        public Boolean is_whole_todo;
        public List<TodoUser> target_users;

        @Override // com.squareup.wire.Message.Builder
        public TaskCompleteEntity build() {
            return new TaskCompleteEntity(this.is_whole_todo, this.target_users, super.buildUnknownFields());
        }

        public Builder() {
            this.target_users = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder is_whole_todo(Boolean r100) {
            this.is_whole_todo = r100;
            return this;
        }

        public Builder target_users(List<TodoUser> r100) {
            Internal.checkElementsNotNull(r100);
            this.target_users = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskCompleteEntity extends ProtoAdapter<TaskCompleteEntity> {
        public ProtoAdapter_TaskCompleteEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskCompleteEntity.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskCompleteEntity decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.is_whole_todo = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.is_whole_todo = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.target_users.add(TodoUser.ADAPTER.decode(r100));
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
        public int encodedSize2(TaskCompleteEntity r100) {
            Boolean r101 = r100.is_whole_todo;
            if (r101 == null) goto L5;
            int r102 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L7:
            return (r102 + TodoUser.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.target_users)) + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TaskCompleteEntity decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TaskCompleteEntity r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TaskCompleteEntity r101) throws IOException {
            Boolean r102 = r101.is_whole_todo;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            TodoUser.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.target_users);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskCompleteEntity r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskCompleteEntity();
        DEFAULT_IS_WHOLE_TODO = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.is_whole_todo = this.is_whole_todo;
        r100.target_users = Internal.copyOf("target_users", this.target_users);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TaskCompleteEntity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TaskCompleteEntity(Boolean r100, List<TodoUser> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public TaskCompleteEntity(Boolean r100, List<TodoUser> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.is_whole_todo = r100;
        this.target_users = Internal.immutableCopyOf("target_users", r101);
    }
}
