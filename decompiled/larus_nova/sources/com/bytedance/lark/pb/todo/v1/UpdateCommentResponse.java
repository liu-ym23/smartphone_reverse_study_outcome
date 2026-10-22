package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class UpdateCommentResponse extends Message<UpdateCommentResponse, Builder> {
    public static final ProtoAdapter<UpdateCommentResponse> ADAPTER = null;
    public static final ProtoAdapter_UpdateCommentResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final TodoComment comment;

    public static final class Builder extends Message.Builder<UpdateCommentResponse, Builder> implements d<UpdateCommentResponse> {
        public TodoComment comment;

        @Override // com.squareup.wire.Message.Builder
        public UpdateCommentResponse build() {
            return new UpdateCommentResponse(this.comment, super.buildUnknownFields());
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
    }

    public static final class ProtoAdapter_UpdateCommentResponse extends ProtoAdapter<UpdateCommentResponse> implements c<UpdateCommentResponse> {
        public ProtoAdapter_UpdateCommentResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateCommentResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UpdateCommentResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.comment = TodoComment.ADAPTER.decode(r100);
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
        public int encodedSize2(UpdateCommentResponse r100) {
            TodoComment r101 = r100.comment;
            if (r101 == null) goto L5;
            int r102 = TodoComment.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UpdateCommentResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UpdateCommentResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UpdateCommentResponse r101) throws IOException {
            TodoComment r102 = r101.comment;
            if (r102 == null) goto L5;
            TodoComment.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UpdateCommentResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UpdateCommentResponse r100 = new ProtoAdapter_UpdateCommentResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.comment = this.comment;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UpdateCommentResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UpdateCommentResponse(TodoComment r100) {
        this(r100, ByteString.EMPTY);
    }

    public UpdateCommentResponse(TodoComment r100, ByteString r101) {
        super(ADAPTER, r101);
        this.comment = r100;
    }
}
