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
public final class TaskFollowersEntity extends Message<TaskFollowersEntity, Builder> {
    public static final ProtoAdapter<TaskFollowersEntity> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<TodoUser> followers;

    public static final class Builder extends Message.Builder<TaskFollowersEntity, Builder> {
        public List<TodoUser> followers;

        @Override // com.squareup.wire.Message.Builder
        public TaskFollowersEntity build() {
            return new TaskFollowersEntity(this.followers, super.buildUnknownFields());
        }

        public Builder() {
            this.followers = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder followers(List<TodoUser> r100) {
            Internal.checkElementsNotNull(r100);
            this.followers = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskFollowersEntity extends ProtoAdapter<TaskFollowersEntity> {
        public ProtoAdapter_TaskFollowersEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskFollowersEntity.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskFollowersEntity decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.followers.add(TodoUser.ADAPTER.decode(r100));
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
        public int encodedSize2(TaskFollowersEntity r100) {
            return TodoUser.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.followers) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TaskFollowersEntity decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TaskFollowersEntity r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TaskFollowersEntity r101) throws IOException {
            TodoUser.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.followers);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskFollowersEntity r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskFollowersEntity();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.followers = Internal.copyOf("followers", this.followers);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TaskFollowersEntity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TaskFollowersEntity(List<TodoUser> r100) {
        this(r100, ByteString.EMPTY);
    }

    public TaskFollowersEntity(List<TodoUser> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.followers = Internal.immutableCopyOf("followers", r100);
    }
}
