package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class CreateOrDeleteChatLastDraftIdRequest extends Message<CreateOrDeleteChatLastDraftIdRequest, Builder> {
    public static final ProtoAdapter<CreateOrDeleteChatLastDraftIdRequest> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final String DEFAULT_DRAFT_ID = "";
    public static final ProtoAdapter_CreateOrDeleteChatLastDraftIdRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String chat_id;
    public final String draft_id;

    public static final class Builder extends Message.Builder<CreateOrDeleteChatLastDraftIdRequest, Builder> implements d<CreateOrDeleteChatLastDraftIdRequest> {
        public String chat_id;
        public String draft_id;

        @Override // com.squareup.wire.Message.Builder
        public CreateOrDeleteChatLastDraftIdRequest build() {
            String r100 = this.chat_id;
            if (r100 == null) goto L7;
            return new CreateOrDeleteChatLastDraftIdRequest(this.chat_id, this.draft_id, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "chat_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder draft_id(String r100) {
            this.draft_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CreateOrDeleteChatLastDraftIdRequest extends ProtoAdapter<CreateOrDeleteChatLastDraftIdRequest> implements c<CreateOrDeleteChatLastDraftIdRequest> {
        public ProtoAdapter_CreateOrDeleteChatLastDraftIdRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, CreateOrDeleteChatLastDraftIdRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CreateOrDeleteChatLastDraftIdRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.chat_id = "";
            r101.draft_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.draft_id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(CreateOrDeleteChatLastDraftIdRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.chat_id);
            String r103 = r100.draft_id;
            if (r103 == null) goto L5;
            int r104 = r101.encodedSizeWithTag(2, r103);
        L7:
            return (r102 + r104) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CreateOrDeleteChatLastDraftIdRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CreateOrDeleteChatLastDraftIdRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CreateOrDeleteChatLastDraftIdRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.chat_id);
            String r103 = r101.draft_id;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CreateOrDeleteChatLastDraftIdRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_CreateOrDeleteChatLastDraftIdRequest r100 = new ProtoAdapter_CreateOrDeleteChatLastDraftIdRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_id = this.chat_id;
        r100.draft_id = this.draft_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CreateOrDeleteChatLastDraftIdRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CreateOrDeleteChatLastDraftIdRequest(String r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public CreateOrDeleteChatLastDraftIdRequest(String r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.chat_id = r100;
        this.draft_id = r101;
    }
}
