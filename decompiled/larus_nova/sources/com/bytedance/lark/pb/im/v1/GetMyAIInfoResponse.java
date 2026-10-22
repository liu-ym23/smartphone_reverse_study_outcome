package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.ExtensionMode;
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
public final class GetMyAIInfoResponse extends Message<GetMyAIInfoResponse, Builder> {
    public static final ProtoAdapter<GetMyAIInfoResponse> ADAPTER = null;
    public static final ExtensionMode DEFAULT_MODE = null;
    public static final ProtoAdapter_GetMyAIInfoResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final AIRoundInfo ai_last_round_info;
    public final AISessionInfo ai_session_info;
    public final ExtensionMode mode;

    public static final class Builder extends Message.Builder<GetMyAIInfoResponse, Builder> implements d<GetMyAIInfoResponse> {
        public AIRoundInfo ai_last_round_info;
        public AISessionInfo ai_session_info;
        public ExtensionMode mode;

        @Override // com.squareup.wire.Message.Builder
        public GetMyAIInfoResponse build() {
            return new GetMyAIInfoResponse(this.ai_last_round_info, this.ai_session_info, this.mode, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder ai_last_round_info(AIRoundInfo r100) {
            this.ai_last_round_info = r100;
            return this;
        }

        public Builder ai_session_info(AISessionInfo r100) {
            this.ai_session_info = r100;
            return this;
        }

        public Builder mode(ExtensionMode r100) {
            this.mode = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetMyAIInfoResponse extends ProtoAdapter<GetMyAIInfoResponse> implements c<GetMyAIInfoResponse> {
        public ProtoAdapter_GetMyAIInfoResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetMyAIInfoResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetMyAIInfoResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mode = ExtensionMode.SINGLE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.ai_last_round_info = AIRoundInfo.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.ai_session_info = AISessionInfo.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.mode = ExtensionMode.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetMyAIInfoResponse r100) {
            AIRoundInfo r101 = r100.ai_last_round_info;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = AIRoundInfo.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            AISessionInfo r104 = r100.ai_session_info;
            if (r104 == null) goto L9;
            int r105 = AISessionInfo.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            ExtensionMode r107 = r100.mode;
            if (r107 == null) goto L14;
            r102 = ExtensionMode.ADAPTER.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ GetMyAIInfoResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetMyAIInfoResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetMyAIInfoResponse r101) throws IOException {
            AIRoundInfo r102 = r101.ai_last_round_info;
            if (r102 == null) goto L5;
            AIRoundInfo.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            AISessionInfo r103 = r101.ai_session_info;
            if (r103 == null) goto L8;
            AISessionInfo.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            ExtensionMode r104 = r101.mode;
            if (r104 == null) goto L11;
            ExtensionMode.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetMyAIInfoResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetMyAIInfoResponse r100 = new ProtoAdapter_GetMyAIInfoResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_MODE = ExtensionMode.SINGLE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.ai_last_round_info = this.ai_last_round_info;
        r100.ai_session_info = this.ai_session_info;
        r100.mode = this.mode;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetMyAIInfoResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetMyAIInfoResponse(AIRoundInfo r100, AISessionInfo r101, ExtensionMode r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetMyAIInfoResponse(AIRoundInfo r100, AISessionInfo r101, ExtensionMode r102, ByteString r103) {
        super(ADAPTER, r103);
        this.ai_last_round_info = r100;
        this.ai_session_info = r101;
        this.mode = r102;
    }
}
