package com.bytedance.lark.pb.openplatform.v1;

import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
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
public final class SetUniversalCardRenderStatusRequest extends Message<SetUniversalCardRenderStatusRequest, Builder> {
    public static final ProtoAdapter<SetUniversalCardRenderStatusRequest> ADAPTER = null;
    public static final String DEFAULT_BIZ_ID = "";
    public static final String DEFAULT_CARD_ID = "";
    public static final ProtoAdapter_SetUniversalCardRenderStatusRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String biz_id;
    public final String card_id;

    public static final class Builder extends Message.Builder<SetUniversalCardRenderStatusRequest, Builder> implements d<SetUniversalCardRenderStatusRequest> {
        public String biz_id;
        public String card_id;

        @Override // com.squareup.wire.Message.Builder
        public SetUniversalCardRenderStatusRequest build() {
            String r100 = this.card_id;
            if (r100 == null) goto L9;
            if (this.biz_id == null) goto L9;
            return new SetUniversalCardRenderStatusRequest(this.card_id, this.biz_id, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "card_id", this.biz_id, AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder biz_id(String r100) {
            this.biz_id = r100;
            return this;
        }

        public Builder card_id(String r100) {
            this.card_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SetUniversalCardRenderStatusRequest extends ProtoAdapter<SetUniversalCardRenderStatusRequest> implements c<SetUniversalCardRenderStatusRequest> {
        public ProtoAdapter_SetUniversalCardRenderStatusRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SetUniversalCardRenderStatusRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SetUniversalCardRenderStatusRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.card_id = "";
            r101.biz_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.card_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.biz_id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(SetUniversalCardRenderStatusRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return (r101.encodedSizeWithTag(1, r100.card_id) + r101.encodedSizeWithTag(2, r100.biz_id)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SetUniversalCardRenderStatusRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SetUniversalCardRenderStatusRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SetUniversalCardRenderStatusRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.card_id);
            r102.encodeWithTag(r100, 2, r101.biz_id);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SetUniversalCardRenderStatusRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SetUniversalCardRenderStatusRequest r100 = new ProtoAdapter_SetUniversalCardRenderStatusRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.card_id = this.card_id;
        r100.biz_id = this.biz_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SetUniversalCardRenderStatusRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SetUniversalCardRenderStatusRequest(String r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public SetUniversalCardRenderStatusRequest(String r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.card_id = r100;
        this.biz_id = r101;
    }
}
