package com.ss.android.lark.pb.todo_comments;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class DeleteTodoCommentReactionRequest extends Message<DeleteTodoCommentReactionRequest, Builder> {
    public static final ProtoAdapter<DeleteTodoCommentReactionRequest> ADAPTER = null;
    public static final String DEFAULT_COMMENT_ID = "";
    public static final String DEFAULT_REACTION_TYPE = "";
    public static final String DEFAULT_TODO_GUID = "";
    private static final long serialVersionUID = 0;
    public final String mcomment_id;
    public final String mreaction_type;
    public final String mtodo_guid;

    public static final class Builder extends Message.Builder<DeleteTodoCommentReactionRequest, Builder> {
        public String mcomment_id;
        public String mreaction_type;
        public String mtodo_guid;

        @Override // com.squareup.wire.Message.Builder
        public DeleteTodoCommentReactionRequest build() {
            return new DeleteTodoCommentReactionRequest(this.mtodo_guid, this.mcomment_id, this.mreaction_type, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder comment_id(String r100) {
            this.mcomment_id = r100;
            return this;
        }

        public Builder reaction_type(String r100) {
            this.mreaction_type = r100;
            return this;
        }

        public Builder todo_guid(String r100) {
            this.mtodo_guid = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DeleteTodoCommentReactionRequest extends ProtoAdapter<DeleteTodoCommentReactionRequest> {
        public ProtoAdapter_DeleteTodoCommentReactionRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, DeleteTodoCommentReactionRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DeleteTodoCommentReactionRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mtodo_guid = "";
            r101.mcomment_id = "";
            r101.mreaction_type = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.mtodo_guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mcomment_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.mreaction_type = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(DeleteTodoCommentReactionRequest r100) {
            String r101 = r100.mtodo_guid;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mcomment_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.mreaction_type;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ DeleteTodoCommentReactionRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DeleteTodoCommentReactionRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DeleteTodoCommentReactionRequest r101) throws IOException {
            String r102 = r101.mtodo_guid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mcomment_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.mreaction_type;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DeleteTodoCommentReactionRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DeleteTodoCommentReactionRequest();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mtodo_guid = this.mtodo_guid;
        r100.mcomment_id = this.mcomment_id;
        r100.mreaction_type = this.mreaction_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DeleteTodoCommentReactionRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DeleteTodoCommentReactionRequest(String r100, String r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public DeleteTodoCommentReactionRequest(String r100, String r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mtodo_guid = r100;
        this.mcomment_id = r101;
        this.mreaction_type = r102;
    }
}
