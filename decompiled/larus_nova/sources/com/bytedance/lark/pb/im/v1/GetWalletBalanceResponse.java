package com.bytedance.lark.pb.im.v1;

import com.bytedance.android.livesdkapi.depend.message.wrds.PreviewPromotionSyncData;
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
public final class GetWalletBalanceResponse extends Message<GetWalletBalanceResponse, Builder> {
    public static final ProtoAdapter<GetWalletBalanceResponse> ADAPTER = null;
    public static final Long DEFAULT_BALANCE = null;
    public static final CurrencyType DEFAULT_CURRENCY = null;
    public static final ProtoAdapter_GetWalletBalanceResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Long balance;
    public final CurrencyType currency;

    public static final class Builder extends Message.Builder<GetWalletBalanceResponse, Builder> implements d<GetWalletBalanceResponse> {
        public Long balance;
        public CurrencyType currency;

        @Override // com.squareup.wire.Message.Builder
        public GetWalletBalanceResponse build() {
            Long r100 = this.balance;
            if (r100 == null) goto L9;
            if (this.currency == null) goto L9;
            return new GetWalletBalanceResponse(this.balance, this.currency, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "balance", this.currency, "currency"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder balance(Long r100) {
            this.balance = r100;
            return this;
        }

        public Builder currency(CurrencyType r100) {
            this.currency = r100;
            return this;
        }
    }

    public static final enum CurrencyType extends Enum<CurrencyType> implements WireEnum {
        private static final /* synthetic */ CurrencyType[] $VALUES = null;
        public static final ProtoAdapter<CurrencyType> ADAPTER = null;
        public static final CurrencyType CNY = null;
        public static final CurrencyType UNKNOWN = null;
        public static final CurrencyType USD = null;
        public static final CurrencyType VIR = null;
        private final int value;

        static {
            CurrencyType r100 = new CurrencyType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            CurrencyType r101 = new CurrencyType(PreviewPromotionSyncData.FANS_RED_PACKET_TYPE_MONEY, 1, 1);
            CNY = r101;
            CurrencyType r102 = new CurrencyType("USD", 2, 2);
            USD = r102;
            CurrencyType r103 = new CurrencyType("VIR", 3, 3);
            VIR = r103;
            $VALUES = new CurrencyType[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(CurrencyType.class);
        }

        public static CurrencyType[] values() {
            return (CurrencyType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static CurrencyType fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return VIR;
        L14:
            return USD;
        L16:
            return CNY;
        L18:
            return UNKNOWN;
        }

        public static CurrencyType valueOf(String r100) {
            return (CurrencyType) a.a(CurrencyType.class, r100);
        }

        private CurrencyType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_GetWalletBalanceResponse extends ProtoAdapter<GetWalletBalanceResponse> implements c<GetWalletBalanceResponse> {
        public ProtoAdapter_GetWalletBalanceResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetWalletBalanceResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetWalletBalanceResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.balance = 0L;
            r101.currency = CurrencyType.UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.balance = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.currency = CurrencyType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetWalletBalanceResponse r100) {
            return (ProtoAdapter.INT64.encodedSizeWithTag(1, r100.balance) + CurrencyType.ADAPTER.encodedSizeWithTag(2, r100.currency)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetWalletBalanceResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetWalletBalanceResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetWalletBalanceResponse r101) throws IOException {
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r101.balance);
            CurrencyType.ADAPTER.encodeWithTag(r100, 2, r101.currency);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetWalletBalanceResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetWalletBalanceResponse r100 = new ProtoAdapter_GetWalletBalanceResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_BALANCE = 0L;
        DEFAULT_CURRENCY = CurrencyType.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.balance = this.balance;
        r100.currency = this.currency;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetWalletBalanceResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetWalletBalanceResponse(Long r100, CurrencyType r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetWalletBalanceResponse(Long r100, CurrencyType r101, ByteString r102) {
        super(ADAPTER, r102);
        this.balance = r100;
        this.currency = r101;
    }
}
