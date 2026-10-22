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
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class PushTodoCommentReaction extends Message<PushTodoCommentReaction, Builder> {
    public static final ProtoAdapter<PushTodoCommentReaction> ADAPTER = null;
    public static final String DEFAULT_COMMENT_ID = "";
    public static final String DEFAULT_TODO_GUID = "";
    public static final Long DEFAULT_UPDATE_MILLI_TIME = null;
    public static final ProtoAdapter_PushTodoCommentReaction RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String comment_id;
    public final List<TodoCommentReaction> reactions;
    public final String todo_guid;
    public final Long update_milli_time;

    public static final class Builder extends Message.Builder<PushTodoCommentReaction, Builder> implements d<PushTodoCommentReaction> {
        public String comment_id;
        public List<TodoCommentReaction> reactions;
        public String todo_guid;
        public Long update_milli_time;

        @Override // com.squareup.wire.Message.Builder
        public PushTodoCommentReaction build() {
            return new PushTodoCommentReaction(this.todo_guid, this.comment_id, this.reactions, this.update_milli_time, super.buildUnknownFields());
        }

        public Builder() {
            this.reactions = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder comment_id(String r100) {
            this.comment_id = r100;
            return this;
        }

        public Builder reactions(List<TodoCommentReaction> r100) {
            Internal.checkElementsNotNull(r100);
            this.reactions = r100;
            return this;
        }

        public Builder todo_guid(String r100) {
            this.todo_guid = r100;
            return this;
        }

        public Builder update_milli_time(Long r100) {
            this.update_milli_time = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushTodoCommentReaction extends ProtoAdapter<PushTodoCommentReaction> implements c<PushTodoCommentReaction> {
        public ProtoAdapter_PushTodoCommentReaction() {
            super(FieldEncoding.LENGTH_DELIMITED, PushTodoCommentReaction.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushTodoCommentReaction decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.todo_guid = "";
            r101.comment_id = "";
            r101.update_milli_time = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.todo_guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.comment_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.reactions.add(TodoCommentReaction.ADAPTER.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.update_milli_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PushTodoCommentReaction r100) {
            String r101 = r100.todo_guid;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.comment_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = (r103 + r105) + TodoCommentReaction.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.reactions);
            Long r107 = r100.update_milli_time;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(4, r107);
        L14:
            return (r106 + r102) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushTodoCommentReaction decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushTodoCommentReaction r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushTodoCommentReaction r101) throws IOException {
            String r102 = r101.todo_guid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.comment_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            TodoCommentReaction.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.reactions);
            Long r104 = r101.update_milli_time;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 4, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushTodoCommentReaction r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushTodoCommentReaction r100 = new ProtoAdapter_PushTodoCommentReaction();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_UPDATE_MILLI_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.todo_guid = this.todo_guid;
        r100.comment_id = this.comment_id;
        r100.reactions = Internal.copyOf("reactions", this.reactions);
        r100.update_milli_time = this.update_milli_time;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushTodoCommentReaction.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushTodoCommentReaction(String r100, String r101, List<TodoCommentReaction> r102, Long r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public PushTodoCommentReaction(String r100, String r101, List<TodoCommentReaction> r102, Long r103, ByteString r104) {
        super(ADAPTER, r104);
        this.todo_guid = r100;
        this.comment_id = r101;
        this.reactions = Internal.immutableCopyOf("reactions", r102);
        this.update_milli_time = r103;
    }
}
