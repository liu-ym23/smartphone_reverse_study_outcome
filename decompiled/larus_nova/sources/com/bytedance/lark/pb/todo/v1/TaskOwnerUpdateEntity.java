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
public final class TaskOwnerUpdateEntity extends Message<TaskOwnerUpdateEntity, Builder> {
    public static final ProtoAdapter<TaskOwnerUpdateEntity> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<TodoUser> new_owners;
    public final List<TodoUser> old_owners;

    public static final class Builder extends Message.Builder<TaskOwnerUpdateEntity, Builder> {
        public List<TodoUser> new_owners;
        public List<TodoUser> old_owners;

        @Override // com.squareup.wire.Message.Builder
        public TaskOwnerUpdateEntity build() {
            return new TaskOwnerUpdateEntity(this.old_owners, this.new_owners, super.buildUnknownFields());
        }

        public Builder() {
            this.old_owners = Internal.newMutableList();
            this.new_owners = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder new_owners(List<TodoUser> r100) {
            Internal.checkElementsNotNull(r100);
            this.new_owners = r100;
            return this;
        }

        public Builder old_owners(List<TodoUser> r100) {
            Internal.checkElementsNotNull(r100);
            this.old_owners = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskOwnerUpdateEntity extends ProtoAdapter<TaskOwnerUpdateEntity> {
        public ProtoAdapter_TaskOwnerUpdateEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskOwnerUpdateEntity.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskOwnerUpdateEntity decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.old_owners.add(TodoUser.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.new_owners.add(TodoUser.ADAPTER.decode(r100));
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
        public int encodedSize2(TaskOwnerUpdateEntity r100) {
            ProtoAdapter<TodoUser> r101 = TodoUser.ADAPTER;
            return (r101.asRepeated().encodedSizeWithTag(1, r100.old_owners) + r101.asRepeated().encodedSizeWithTag(2, r100.new_owners)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TaskOwnerUpdateEntity decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TaskOwnerUpdateEntity r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TaskOwnerUpdateEntity r101) throws IOException {
            ProtoAdapter<TodoUser> r102 = TodoUser.ADAPTER;
            r102.asRepeated().encodeWithTag(r100, 1, r101.old_owners);
            r102.asRepeated().encodeWithTag(r100, 2, r101.new_owners);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskOwnerUpdateEntity r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskOwnerUpdateEntity();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.old_owners = Internal.copyOf("old_owners", this.old_owners);
        r100.new_owners = Internal.copyOf("new_owners", this.new_owners);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TaskOwnerUpdateEntity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TaskOwnerUpdateEntity(List<TodoUser> r100, List<TodoUser> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public TaskOwnerUpdateEntity(List<TodoUser> r100, List<TodoUser> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.old_owners = Internal.immutableCopyOf("old_owners", r100);
        this.new_owners = Internal.immutableCopyOf("new_owners", r101);
    }
}
