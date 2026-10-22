package com.bytedance.lark.pb.openplatform.v1;

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
public final class SubscribeUniversalCardRequest extends Message<SubscribeUniversalCardRequest, Builder> {
    public static final ProtoAdapter<SubscribeUniversalCardRequest> ADAPTER = null;
    public static final String DEFAULT_CARD_ID = "";
    public static final Boolean DEFAULT_NEED_PUSH = null;
    public static final ProtoAdapter_SubscribeUniversalCardRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final UniversalCardBizParam biz_param;
    public final String card_id;
    public final Boolean need_push;

    public static final class Builder extends Message.Builder<SubscribeUniversalCardRequest, Builder> implements d<SubscribeUniversalCardRequest> {
        public UniversalCardBizParam biz_param;
        public String card_id;
        public Boolean need_push;

        @Override // com.squareup.wire.Message.Builder
        public SubscribeUniversalCardRequest build() {
            String r100 = this.card_id;
            if (r100 == null) goto L9;
            if (this.biz_param == null) goto L9;
            return new SubscribeUniversalCardRequest(this.card_id, this.biz_param, this.need_push, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "card_id", this.biz_param, "biz_param"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder biz_param(UniversalCardBizParam r100) {
            this.biz_param = r100;
            return this;
        }

        public Builder card_id(String r100) {
            this.card_id = r100;
            return this;
        }

        public Builder need_push(Boolean r100) {
            this.need_push = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SubscribeUniversalCardRequest extends ProtoAdapter<SubscribeUniversalCardRequest> implements c<SubscribeUniversalCardRequest> {
        public ProtoAdapter_SubscribeUniversalCardRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SubscribeUniversalCardRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SubscribeUniversalCardRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.card_id = "";
            r101.need_push = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.card_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.biz_param = UniversalCardBizParam.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.need_push = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(SubscribeUniversalCardRequest r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.card_id) + UniversalCardBizParam.ADAPTER.encodedSizeWithTag(2, r100.biz_param);
            Boolean r102 = r100.need_push;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SubscribeUniversalCardRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SubscribeUniversalCardRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SubscribeUniversalCardRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.card_id);
            UniversalCardBizParam.ADAPTER.encodeWithTag(r100, 2, r101.biz_param);
            Boolean r102 = r101.need_push;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SubscribeUniversalCardRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SubscribeUniversalCardRequest r100 = new ProtoAdapter_SubscribeUniversalCardRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_NEED_PUSH = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.card_id = this.card_id;
        r100.biz_param = this.biz_param;
        r100.need_push = this.need_push;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SubscribeUniversalCardRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SubscribeUniversalCardRequest(String r100, UniversalCardBizParam r101, Boolean r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public SubscribeUniversalCardRequest(String r100, UniversalCardBizParam r101, Boolean r102, ByteString r103) {
        super(ADAPTER, r103);
        this.card_id = r100;
        this.biz_param = r101;
        this.need_push = r102;
    }
}
