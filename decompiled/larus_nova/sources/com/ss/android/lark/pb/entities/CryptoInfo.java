package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class CryptoInfo extends com.squareup.wire.Message<CryptoInfo, Builder> {
    public static final ProtoAdapter<CryptoInfo> ADAPTER = null;
    public static final Integer DEFAULT_BURNED_SECONDS = null;
    public static final String DEFAULT_SECRET_VERSION = "";
    private static final long serialVersionUID = 0;
    public final Integer mburned_seconds;
    public final CryptoType mcrypto_type;
    public final CryptoMessageDetail mfallback_detail;
    public final SecretMessageDetail msecret_message_detail;
    public final String msecret_version;

    public static final class Builder extends com.squareup.wire.Message.Builder<CryptoInfo, Builder> {
        public Integer mburned_seconds;
        public CryptoType mcrypto_type;
        public CryptoMessageDetail mfallback_detail;
        public SecretMessageDetail msecret_message_detail;
        public String msecret_version;

        @Override // com.squareup.wire.Message.Builder
        public CryptoInfo build() {
            return new CryptoInfo(this.mcrypto_type, this.msecret_version, this.mburned_seconds, this.mfallback_detail, this.msecret_message_detail, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder burned_seconds(Integer r100) {
            this.mburned_seconds = r100;
            return this;
        }

        public Builder crypto_type(CryptoType r100) {
            this.mcrypto_type = r100;
            return this;
        }

        public Builder fallback_detail(CryptoMessageDetail r100) {
            this.mfallback_detail = r100;
            return this;
        }

        public Builder secret_message_detail(SecretMessageDetail r100) {
            this.msecret_message_detail = r100;
            return this;
        }

        public Builder secret_version(String r100) {
            this.msecret_version = r100;
            return this;
        }
    }

    public static final enum CryptoType extends Enum<CryptoType> implements WireEnum {
        private static final /* synthetic */ CryptoType[] $VALUES = null;
        public static final ProtoAdapter<CryptoType> ADAPTER = null;
        public static final CryptoType E2EE = null;
        public static final CryptoType PLAIN_TEXT = null;
        public static final CryptoType THIRD_PARTY = null;
        public static final CryptoType UNKNOWN = null;
        private final int value;

        static {
            CryptoType r100 = new CryptoType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            CryptoType r101 = new CryptoType("PLAIN_TEXT", 1, 1);
            PLAIN_TEXT = r101;
            CryptoType r102 = new CryptoType("E2EE", 2, 2);
            E2EE = r102;
            CryptoType r103 = new CryptoType("THIRD_PARTY", 3, 3);
            THIRD_PARTY = r103;
            $VALUES = new CryptoType[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(CryptoType.class);
        }

        public static CryptoType[] values() {
            return (CryptoType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static CryptoType fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return THIRD_PARTY;
        L14:
            return E2EE;
        L16:
            return PLAIN_TEXT;
        L18:
            return UNKNOWN;
        }

        public static CryptoType valueOf(String r100) {
            return (CryptoType) a.a(CryptoType.class, r100);
        }

        private CryptoType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_CryptoInfo extends ProtoAdapter<CryptoInfo> {
        public ProtoAdapter_CryptoInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, CryptoInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CryptoInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.msecret_version = "";
            r101.mburned_seconds = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.mcrypto_type = CryptoType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.msecret_version = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mburned_seconds = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.mfallback_detail = CryptoMessageDetail.ADAPTER.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.msecret_message_detail = SecretMessageDetail.ADAPTER.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CryptoInfo r100) {
            CryptoType r101 = r100.mcrypto_type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = CryptoType.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.msecret_version;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Integer r107 = r100.mburned_seconds;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT32.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            CryptoMessageDetail r110 = r100.mfallback_detail;
            if (r110 == null) goto L17;
            int r111 = CryptoMessageDetail.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            SecretMessageDetail r113 = r100.msecret_message_detail;
            if (r113 == null) goto L22;
            r102 = SecretMessageDetail.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            return (r112 + r102) + r100.unknownFields().size();
        L17:
            r111 = 0;
            goto L18
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
        public /* bridge */ /* synthetic */ CryptoInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CryptoInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CryptoInfo r101) throws IOException {
            CryptoType r102 = r101.mcrypto_type;
            if (r102 == null) goto L5;
            CryptoType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.msecret_version;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Integer r104 = r101.mburned_seconds;
            if (r104 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
        L11:
            CryptoMessageDetail r105 = r101.mfallback_detail;
            if (r105 == null) goto L14;
            CryptoMessageDetail.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            SecretMessageDetail r106 = r101.msecret_message_detail;
            if (r106 == null) goto L17;
            SecretMessageDetail.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CryptoInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CryptoInfo();
        DEFAULT_BURNED_SECONDS = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mcrypto_type = this.mcrypto_type;
        r100.msecret_version = this.msecret_version;
        r100.mburned_seconds = this.mburned_seconds;
        r100.mfallback_detail = this.mfallback_detail;
        r100.msecret_message_detail = this.msecret_message_detail;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CryptoInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public CryptoInfo(CryptoType r100, String r101, Integer r110, CryptoMessageDetail r111, SecretMessageDetail r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public CryptoInfo(CryptoType r100, String r101, Integer r102, CryptoMessageDetail r103, SecretMessageDetail r104, ByteString r105) {
        super(ADAPTER, r105);
        this.mcrypto_type = r100;
        this.msecret_version = r101;
        this.mburned_seconds = r102;
        this.mfallback_detail = r103;
        this.msecret_message_detail = r104;
    }
}
