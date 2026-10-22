package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class SendHongbaoResponse extends Message<SendHongbaoResponse, Builder> {
    public static final ProtoAdapter<SendHongbaoResponse> ADAPTER = null;
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_PAY_URL = "";
    public static final PayURLType DEFAULT_PAY_URL_TYPE = null;
    public static final ProtoAdapter_SendHongbaoResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253655id;
    public final String pay_url;
    public final PayURLType pay_url_type;

    public static final class Builder extends Message.Builder<SendHongbaoResponse, Builder> implements d<SendHongbaoResponse> {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253656id;
        public String pay_url;
        public PayURLType pay_url_type;

        @Override // com.squareup.wire.Message.Builder
        public SendHongbaoResponse build() {
            String r100 = this.pay_url;
            if (r100 == null) goto L7;
            return new SendHongbaoResponse(this.f253656id, this.pay_url, this.pay_url_type, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "pay_url"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder id(String r100) {
            this.f253656id = r100;
            return this;
        }

        public Builder pay_url(String r100) {
            this.pay_url = r100;
            return this;
        }

        public Builder pay_url_type(PayURLType r100) {
            this.pay_url_type = r100;
            return this;
        }
    }

    public static final enum PayURLType extends Enum<PayURLType> implements WireEnum {
        private static final /* synthetic */ PayURLType[] $VALUES = null;
        public static final ProtoAdapter<PayURLType> ADAPTER = null;
        public static final PayURLType BYTE_PAY = null;
        public static final PayURLType CAIJING_PAY = null;
        public static final PayURLType UNKNOWN = null;
        private final int value;

        static {
            PayURLType r100 = new PayURLType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            PayURLType r101 = new PayURLType("CAIJING_PAY", 1, 1);
            CAIJING_PAY = r101;
            PayURLType r102 = new PayURLType("BYTE_PAY", 2, 2);
            BYTE_PAY = r102;
            $VALUES = new PayURLType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(PayURLType.class);
        }

        public static PayURLType[] values() {
            return (PayURLType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static PayURLType fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return BYTE_PAY;
        L12:
            return CAIJING_PAY;
        L14:
            return UNKNOWN;
        }

        public static PayURLType valueOf(String r100) {
            return (PayURLType) a.a(PayURLType.class, r100);
        }

        private PayURLType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_SendHongbaoResponse extends ProtoAdapter<SendHongbaoResponse> implements c<SendHongbaoResponse> {
        public ProtoAdapter_SendHongbaoResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SendHongbaoResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SendHongbaoResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253656id = "";
            r101.pay_url = "";
            r101.pay_url_type = PayURLType.UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.f253656id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.pay_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.pay_url_type = PayURLType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
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
        public int encodedSize2(SendHongbaoResponse r100) {
            String r101 = r100.f253655id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            int r104 = r103 + ProtoAdapter.STRING.encodedSizeWithTag(2, r100.pay_url);
            PayURLType r105 = r100.pay_url_type;
            if (r105 == null) goto L10;
            r102 = PayURLType.ADAPTER.encodedSizeWithTag(3, r105);
        L10:
            return (r104 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SendHongbaoResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SendHongbaoResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SendHongbaoResponse r101) throws IOException {
            String r102 = r101.f253655id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r101.pay_url);
            PayURLType r103 = r101.pay_url_type;
            if (r103 == null) goto L8;
            PayURLType.ADAPTER.encodeWithTag(r100, 3, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SendHongbaoResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SendHongbaoResponse r100 = new ProtoAdapter_SendHongbaoResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_PAY_URL_TYPE = PayURLType.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253656id = this.f253655id;
        r100.pay_url = this.pay_url;
        r100.pay_url_type = this.pay_url_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SendHongbaoResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SendHongbaoResponse(String r100, String r101, PayURLType r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public SendHongbaoResponse(String r100, String r101, PayURLType r102, ByteString r103) {
        super(ADAPTER, r103);
        this.f253655id = r100;
        this.pay_url = r101;
        this.pay_url_type = r102;
    }
}
