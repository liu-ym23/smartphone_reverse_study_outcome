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
public final class TaskItemMembers extends Message<TaskItemMembers, Builder> {
    public static final ProtoAdapter<TaskItemMembers> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<TaskItemMember> members;

    public static final class Builder extends Message.Builder<TaskItemMembers, Builder> {
        public List<TaskItemMember> members;

        @Override // com.squareup.wire.Message.Builder
        public TaskItemMembers build() {
            return new TaskItemMembers(this.members, super.buildUnknownFields());
        }

        public Builder() {
            this.members = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder members(List<TaskItemMember> r100) {
            Internal.checkElementsNotNull(r100);
            this.members = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskItemMembers extends ProtoAdapter<TaskItemMembers> {
        public ProtoAdapter_TaskItemMembers() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskItemMembers.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskItemMembers decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.members.add(TaskItemMember.ADAPTER.decode(r100));
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
        public int encodedSize2(TaskItemMembers r100) {
            return TaskItemMember.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.members) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TaskItemMembers decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TaskItemMembers r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TaskItemMembers r101) throws IOException {
            TaskItemMember.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.members);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskItemMembers r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskItemMembers();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.members = Internal.copyOf("members", this.members);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TaskItemMembers.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TaskItemMembers(List<TaskItemMember> r100) {
        this(r100, ByteString.EMPTY);
    }

    public TaskItemMembers(List<TaskItemMember> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.members = Internal.immutableCopyOf("members", r100);
    }
}
