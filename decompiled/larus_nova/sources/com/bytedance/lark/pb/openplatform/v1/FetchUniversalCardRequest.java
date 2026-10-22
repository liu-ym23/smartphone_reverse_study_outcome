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
public final class FetchUniversalCardRequest extends Message<FetchUniversalCardRequest, Builder> {
    public static final ProtoAdapter<FetchUniversalCardRequest> ADAPTER = null;
    public static final String DEFAULT_BIZ_ID = "";
    public static final UniversalCardBizType DEFAULT_BIZ_TYPE = null;
    public static final String DEFAULT_HOST_CARD_ID = "";
    public static final ProtoAdapter_FetchUniversalCardRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String biz_id;
    public final UniversalCardBizType biz_type;
    public final String host_card_id;

    public static final class Builder extends Message.Builder<FetchUniversalCardRequest, Builder> implements d<FetchUniversalCardRequest> {
        public String biz_id;
        public UniversalCardBizType biz_type;
        public String host_card_id;

        @Override // com.squareup.wire.Message.Builder
        public FetchUniversalCardRequest build() {
            String r100 = this.host_card_id;
            if (r100 == null) goto L11;
            if (this.biz_id == null) goto L11;
            if (this.biz_type == null) goto L11;
            return new FetchUniversalCardRequest(this.host_card_id, this.biz_id, this.biz_type, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "host_card_id", this.biz_id, AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID, this.biz_type, "biz_type"});
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

        public Builder biz_type(UniversalCardBizType r100) {
            this.biz_type = r100;
            return this;
        }

        public Builder host_card_id(String r100) {
            this.host_card_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FetchUniversalCardRequest extends ProtoAdapter<FetchUniversalCardRequest> implements c<FetchUniversalCardRequest> {
        public ProtoAdapter_FetchUniversalCardRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, FetchUniversalCardRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FetchUniversalCardRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.host_card_id = "";
            r101.biz_id = "";
            r101.biz_type = UniversalCardBizType.BIZ_TYPE_UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.host_card_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.biz_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.biz_type = UniversalCardBizType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
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
        public int encodedSize2(FetchUniversalCardRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return ((r101.encodedSizeWithTag(1, r100.host_card_id) + r101.encodedSizeWithTag(2, r100.biz_id)) + UniversalCardBizType.ADAPTER.encodedSizeWithTag(3, r100.biz_type)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FetchUniversalCardRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FetchUniversalCardRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FetchUniversalCardRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.host_card_id);
            r102.encodeWithTag(r100, 2, r101.biz_id);
            UniversalCardBizType.ADAPTER.encodeWithTag(r100, 3, r101.biz_type);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FetchUniversalCardRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_FetchUniversalCardRequest r100 = new ProtoAdapter_FetchUniversalCardRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_BIZ_TYPE = UniversalCardBizType.BIZ_TYPE_UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.host_card_id = this.host_card_id;
        r100.biz_id = this.biz_id;
        r100.biz_type = this.biz_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FetchUniversalCardRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FetchUniversalCardRequest(String r100, String r101, UniversalCardBizType r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public FetchUniversalCardRequest(String r100, String r101, UniversalCardBizType r102, ByteString r103) {
        super(ADAPTER, r103);
        this.host_card_id = r100;
        this.biz_id = r101;
        this.biz_type = r102;
    }
}
