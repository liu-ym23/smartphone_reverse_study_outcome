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
public final class TodoCommentReaction extends Message<TodoCommentReaction, Builder> {
    public static final ProtoAdapter<TodoCommentReaction> ADAPTER = null;
    public static final String DEFAULT_TYPE = "";
    private static final long serialVersionUID = 0;
    public final String type;
    public final List<TodoUser> users;

    public static final class Builder extends Message.Builder<TodoCommentReaction, Builder> {
        public String type;
        public List<TodoUser> users;

        @Override // com.squareup.wire.Message.Builder
        public TodoCommentReaction build() {
            return new TodoCommentReaction(this.type, this.users, super.buildUnknownFields());
        }

        public Builder() {
            this.users = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder type(String r100) {
            this.type = r100;
            return this;
        }

        public Builder users(List<TodoUser> r100) {
            Internal.checkElementsNotNull(r100);
            this.users = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TodoCommentReaction extends ProtoAdapter<TodoCommentReaction> {
        public ProtoAdapter_TodoCommentReaction() {
            super(FieldEncoding.LENGTH_DELIMITED, TodoCommentReaction.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TodoCommentReaction decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.type = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.type = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.users.add(TodoUser.ADAPTER.decode(r100));
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
        public int encodedSize2(TodoCommentReaction r100) {
            String r101 = r100.type;
            if (r101 == null) goto L5;
            int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L7:
            return (r102 + TodoUser.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.users)) + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TodoCommentReaction decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TodoCommentReaction r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TodoCommentReaction r101) throws IOException {
            String r102 = r101.type;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            TodoUser.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.users);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TodoCommentReaction r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TodoCommentReaction();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.type = this.type;
        r100.users = Internal.copyOf("users", this.users);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TodoCommentReaction.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TodoCommentReaction(String r100, List<TodoUser> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public TodoCommentReaction(String r100, List<TodoUser> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.type = r100;
        this.users = Internal.immutableCopyOf("users", r101);
    }
}
