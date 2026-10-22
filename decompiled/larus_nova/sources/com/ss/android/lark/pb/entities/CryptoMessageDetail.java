package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class CryptoMessageDetail extends com.squareup.wire.Message<CryptoMessageDetail, Builder> {
    public static final ProtoAdapter<CryptoMessageDetail> ADAPTER = null;
    public static final ByteString DEFAULT_ADDITIONAL_DATA = null;
    public static final ByteString DEFAULT_CONTENT = null;
    public static final String DEFAULT_FROM_DEVICE_ID = "";
    public static final ByteString DEFAULT_NONCE = null;
    public static final ByteString DEFAULT_SENDER_PUBLIC_KEY = null;
    private static final long serialVersionUID = 0;
    public final ByteString madditional_data;
    public final ByteString mcontent;
    public final String mfrom_device_id;
    public final ByteString mnonce;
    public final ByteString msender_public_key;

    public static final class Builder extends com.squareup.wire.Message.Builder<CryptoMessageDetail, Builder> {
        public ByteString madditional_data;
        public ByteString mcontent;
        public String mfrom_device_id;
        public ByteString mnonce;
        public ByteString msender_public_key;

        @Override // com.squareup.wire.Message.Builder
        public CryptoMessageDetail build() {
            return new CryptoMessageDetail(this.mcontent, this.mfrom_device_id, this.msender_public_key, this.mnonce, this.madditional_data, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder additional_data(ByteString r100) {
            this.madditional_data = r100;
            return this;
        }

        public Builder content(ByteString r100) {
            this.mcontent = r100;
            return this;
        }

        public Builder from_device_id(String r100) {
            this.mfrom_device_id = r100;
            return this;
        }

        public Builder nonce(ByteString r100) {
            this.mnonce = r100;
            return this;
        }

        public Builder sender_public_key(ByteString r100) {
            this.msender_public_key = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CryptoMessageDetail extends ProtoAdapter<CryptoMessageDetail> {
        public ProtoAdapter_CryptoMessageDetail() {
            super(FieldEncoding.LENGTH_DELIMITED, CryptoMessageDetail.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CryptoMessageDetail decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            ByteString r102 = ByteString.EMPTY;
            r101.mcontent = r102;
            r101.mfrom_device_id = "";
            r101.msender_public_key = r102;
            r101.mnonce = r102;
            r101.madditional_data = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L21;
            if (r104 != 1) goto L8;
            r101.mcontent = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.mfrom_device_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L12;
            r101.msender_public_key = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L12:
            if (r104 != 4) goto L14;
            r101.mnonce = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L14:
            if (r104 != 5) goto L15;
            r101.madditional_data = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L15:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CryptoMessageDetail r100) {
            ByteString r101 = r100.mcontent;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BYTES.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mfrom_device_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            ByteString r107 = r100.msender_public_key;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BYTES.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            ByteString r110 = r100.mnonce;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.BYTES.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            ByteString r113 = r100.madditional_data;
            if (r113 == null) goto L22;
            r102 = ProtoAdapter.BYTES.encodedSizeWithTag(5, r113);
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
        public /* bridge */ /* synthetic */ CryptoMessageDetail decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CryptoMessageDetail r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CryptoMessageDetail r101) throws IOException {
            ByteString r102 = r101.mcontent;
            if (r102 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mfrom_device_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            ByteString r104 = r101.msender_public_key;
            if (r104 == null) goto L11;
            ProtoAdapter.BYTES.encodeWithTag(r100, 3, r104);
        L11:
            ByteString r105 = r101.mnonce;
            if (r105 == null) goto L14;
            ProtoAdapter.BYTES.encodeWithTag(r100, 4, r105);
        L14:
            ByteString r106 = r101.madditional_data;
            if (r106 == null) goto L17;
            ProtoAdapter.BYTES.encodeWithTag(r100, 5, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CryptoMessageDetail r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CryptoMessageDetail();
        ByteString r100 = ByteString.EMPTY;
        DEFAULT_CONTENT = r100;
        DEFAULT_SENDER_PUBLIC_KEY = r100;
        DEFAULT_NONCE = r100;
        DEFAULT_ADDITIONAL_DATA = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mcontent = this.mcontent;
        r100.mfrom_device_id = this.mfrom_device_id;
        r100.msender_public_key = this.msender_public_key;
        r100.mnonce = this.mnonce;
        r100.madditional_data = this.madditional_data;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CryptoMessageDetail.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public CryptoMessageDetail(ByteString r100, String r101, ByteString r110, ByteString r111, ByteString r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public CryptoMessageDetail(ByteString r100, String r101, ByteString r102, ByteString r103, ByteString r104, ByteString r105) {
        super(ADAPTER, r105);
        this.mcontent = r100;
        this.mfrom_device_id = r101;
        this.msender_public_key = r102;
        this.mnonce = r103;
        this.madditional_data = r104;
    }
}
