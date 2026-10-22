package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TaskCommentEntity extends Message<TaskCommentEntity, Builder> {
    public static final ProtoAdapter<TaskCommentEntity> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final TodoComment comment;
    public final TodoComment reply_comment;

    public static final class Builder extends Message.Builder<TaskCommentEntity, Builder> {
        public TodoComment comment;
        public TodoComment reply_comment;

        @Override // com.squareup.wire.Message.Builder
        public TaskCommentEntity build() {
            return new TaskCommentEntity(this.comment, this.reply_comment, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder comment(TodoComment r100) {
            this.comment = r100;
            return this;
        }

        public Builder reply_comment(TodoComment r100) {
            this.reply_comment = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskCommentEntity extends ProtoAdapter<TaskCommentEntity> {
        public ProtoAdapter_TaskCommentEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskCommentEntity.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskCommentEntity decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.comment = TodoComment.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.reply_comment = TodoComment.ADAPTER.decode(r100);
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
        public int encodedSize2(TaskCommentEntity r100) {
            TodoComment r101 = r100.comment;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = TodoComment.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            TodoComment r104 = r100.reply_comment;
            if (r104 == null) goto L10;
            r102 = TodoComment.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TaskCommentEntity decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TaskCommentEntity r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TaskCommentEntity r101) throws IOException {
            TodoComment r102 = r101.comment;
            if (r102 == null) goto L5;
            TodoComment.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            TodoComment r103 = r101.reply_comment;
            if (r103 == null) goto L8;
            TodoComment.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskCommentEntity r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskCommentEntity();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.comment = this.comment;
        r100.reply_comment = this.reply_comment;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TaskCommentEntity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TaskCommentEntity(TodoComment r100, TodoComment r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public TaskCommentEntity(TodoComment r100, TodoComment r101, ByteString r102) {
        super(ADAPTER, r102);
        this.comment = r100;
        this.reply_comment = r101;
    }
}
