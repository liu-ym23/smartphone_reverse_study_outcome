package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class EnterMyAIChatResponse extends Message<EnterMyAIChatResponse, Builder> {
    public static final ProtoAdapter<EnterMyAIChatResponse> ADAPTER = null;
    public static final Long DEFAULT_AI_CHAT_MODE_ID = null;
    public static final Boolean DEFAULT_NEED_ONBOARD = null;
    private static final long serialVersionUID = 0;
    public final Long mai_chat_mode_id;
    public final Boolean mneed_onboard;

    public static final class Builder extends Message.Builder<EnterMyAIChatResponse, Builder> {
        public Long mai_chat_mode_id;
        public Boolean mneed_onboard;

        @Override // com.squareup.wire.Message.Builder
        public EnterMyAIChatResponse build() {
            return new EnterMyAIChatResponse(this.mneed_onboard, this.mai_chat_mode_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder ai_chat_mode_id(Long r100) {
            this.mai_chat_mode_id = r100;
            return this;
        }

        public Builder need_onboard(Boolean r100) {
            this.mneed_onboard = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_EnterMyAIChatResponse extends ProtoAdapter<EnterMyAIChatResponse> {
        public ProtoAdapter_EnterMyAIChatResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, EnterMyAIChatResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public EnterMyAIChatResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mneed_onboard = Boolean.FALSE;
            r101.mai_chat_mode_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.mneed_onboard = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mai_chat_mode_id = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(EnterMyAIChatResponse r100) {
            Boolean r101 = r100.mneed_onboard;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.mai_chat_mode_id;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ EnterMyAIChatResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(EnterMyAIChatResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, EnterMyAIChatResponse r101) throws IOException {
            Boolean r102 = r101.mneed_onboard;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.mai_chat_mode_id;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EnterMyAIChatResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_EnterMyAIChatResponse();
        DEFAULT_NEED_ONBOARD = Boolean.FALSE;
        DEFAULT_AI_CHAT_MODE_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mneed_onboard = this.mneed_onboard;
        r100.mai_chat_mode_id = this.mai_chat_mode_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return EnterMyAIChatResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public EnterMyAIChatResponse(Boolean r100, Long r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public EnterMyAIChatResponse(Boolean r100, Long r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mneed_onboard = r100;
        this.mai_chat_mode_id = r101;
    }
}
