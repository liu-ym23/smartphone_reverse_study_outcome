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
public final class GetCommentDraftRequest extends Message<GetCommentDraftRequest, Builder> {
    public static final ProtoAdapter<GetCommentDraftRequest> ADAPTER = null;
    public static final String DEFAULT_TODO_GUID = "";
    public static final ProtoAdapter_GetCommentDraftRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String todo_guid;

    public static final class Builder extends Message.Builder<GetCommentDraftRequest, Builder> implements d<GetCommentDraftRequest> {
        public String todo_guid;

        @Override // com.squareup.wire.Message.Builder
        public GetCommentDraftRequest build() {
            return new GetCommentDraftRequest(this.todo_guid, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder todo_guid(String r100) {
            this.todo_guid = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetCommentDraftRequest extends ProtoAdapter<GetCommentDraftRequest> implements c<GetCommentDraftRequest> {
        public ProtoAdapter_GetCommentDraftRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetCommentDraftRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetCommentDraftRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.todo_guid = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.todo_guid = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(GetCommentDraftRequest r100) {
            String r101 = r100.todo_guid;
            if (r101 == null) goto L5;
            int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetCommentDraftRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetCommentDraftRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetCommentDraftRequest r101) throws IOException {
            String r102 = r101.todo_guid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetCommentDraftRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetCommentDraftRequest r100 = new ProtoAdapter_GetCommentDraftRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.todo_guid = this.todo_guid;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetCommentDraftRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetCommentDraftRequest(String r100) {
        this(r100, ByteString.EMPTY);
    }

    public GetCommentDraftRequest(String r100, ByteString r101) {
        super(ADAPTER, r101);
        this.todo_guid = r100;
    }
}
