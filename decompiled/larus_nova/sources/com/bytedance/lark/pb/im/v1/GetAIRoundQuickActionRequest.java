package com.bytedance.lark.pb.im.v1;

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
public final class GetAIRoundQuickActionRequest extends Message<GetAIRoundQuickActionRequest, Builder> {
    public static final ProtoAdapter<GetAIRoundQuickActionRequest> ADAPTER = null;
    public static final String DEFAULT_AI_CHAT_MODE_ID = "";
    public static final String DEFAULT_CHAT_ID = "";
    public static final Long DEFAULT_ROUND_ID_POSITION = null;
    public static final ProtoAdapter_GetAIRoundQuickActionRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String ai_chat_mode_id;
    public final String chat_id;
    public final FetchQuickActionsRequest fetch_request;
    public final Long round_id_position;

    public static final class Builder extends Message.Builder<GetAIRoundQuickActionRequest, Builder> implements d<GetAIRoundQuickActionRequest> {
        public String ai_chat_mode_id;
        public String chat_id;
        public FetchQuickActionsRequest fetch_request;
        public Long round_id_position;

        @Override // com.squareup.wire.Message.Builder
        public GetAIRoundQuickActionRequest build() {
            return new GetAIRoundQuickActionRequest(this.fetch_request, this.chat_id, this.ai_chat_mode_id, this.round_id_position, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder ai_chat_mode_id(String r100) {
            this.ai_chat_mode_id = r100;
            return this;
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder fetch_request(FetchQuickActionsRequest r100) {
            this.fetch_request = r100;
            return this;
        }

        public Builder round_id_position(Long r100) {
            this.round_id_position = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetAIRoundQuickActionRequest extends ProtoAdapter<GetAIRoundQuickActionRequest> implements c<GetAIRoundQuickActionRequest> {
        public ProtoAdapter_GetAIRoundQuickActionRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetAIRoundQuickActionRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetAIRoundQuickActionRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.chat_id = "";
            r101.ai_chat_mode_id = "";
            r101.round_id_position = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.fetch_request = FetchQuickActionsRequest.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.ai_chat_mode_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.round_id_position = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(GetAIRoundQuickActionRequest r100) {
            FetchQuickActionsRequest r101 = r100.fetch_request;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = FetchQuickActionsRequest.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.chat_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.ai_chat_mode_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Long r110 = r100.round_id_position;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(4, r110);
        L18:
            return (r109 + r102) + r100.unknownFields().size();
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetAIRoundQuickActionRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetAIRoundQuickActionRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetAIRoundQuickActionRequest r101) throws IOException {
            FetchQuickActionsRequest r102 = r101.fetch_request;
            if (r102 == null) goto L5;
            FetchQuickActionsRequest.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.chat_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.ai_chat_mode_id;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            Long r105 = r101.round_id_position;
            if (r105 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetAIRoundQuickActionRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetAIRoundQuickActionRequest r100 = new ProtoAdapter_GetAIRoundQuickActionRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_ROUND_ID_POSITION = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.fetch_request = this.fetch_request;
        r100.chat_id = this.chat_id;
        r100.ai_chat_mode_id = this.ai_chat_mode_id;
        r100.round_id_position = this.round_id_position;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetAIRoundQuickActionRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetAIRoundQuickActionRequest(FetchQuickActionsRequest r100, String r101, String r102, Long r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public GetAIRoundQuickActionRequest(FetchQuickActionsRequest r100, String r101, String r102, Long r103, ByteString r104) {
        super(ADAPTER, r104);
        this.fetch_request = r100;
        this.chat_id = r101;
        this.ai_chat_mode_id = r102;
        this.round_id_position = r103;
    }
}
