package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class AIChatModeInitResponse extends Message<AIChatModeInitResponse, Builder> {
    public static final ProtoAdapter<AIChatModeInitResponse> ADAPTER = null;
    public static final String DEFAULT_AI_CHAT_MODE_ID = "";
    public static final String DEFAULT_CHAT_ID = "";
    private static final long serialVersionUID = 0;
    public final String mai_chat_mode_id;
    public final String mchat_id;

    public static final class Builder extends Message.Builder<AIChatModeInitResponse, Builder> {
        public String mai_chat_mode_id;
        public String mchat_id;

        @Override // com.squareup.wire.Message.Builder
        public AIChatModeInitResponse build() {
            return new AIChatModeInitResponse(this.mai_chat_mode_id, this.mchat_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder ai_chat_mode_id(String r100) {
            this.mai_chat_mode_id = r100;
            return this;
        }

        public Builder chat_id(String r100) {
            this.mchat_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_AIChatModeInitResponse extends ProtoAdapter<AIChatModeInitResponse> {
        public ProtoAdapter_AIChatModeInitResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, AIChatModeInitResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AIChatModeInitResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mai_chat_mode_id = "";
            r101.mchat_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.mai_chat_mode_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mchat_id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(AIChatModeInitResponse r100) {
            String r101 = r100.mai_chat_mode_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mchat_id;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ AIChatModeInitResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AIChatModeInitResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AIChatModeInitResponse r101) throws IOException {
            String r102 = r101.mai_chat_mode_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mchat_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AIChatModeInitResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AIChatModeInitResponse();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mai_chat_mode_id = this.mai_chat_mode_id;
        r100.mchat_id = this.mchat_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AIChatModeInitResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public AIChatModeInitResponse(String r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public AIChatModeInitResponse(String r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mai_chat_mode_id = r100;
        this.mchat_id = r101;
    }
}
