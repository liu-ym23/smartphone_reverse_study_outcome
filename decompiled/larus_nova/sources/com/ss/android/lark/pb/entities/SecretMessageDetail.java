package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class SecretMessageDetail extends com.squareup.wire.Message<SecretMessageDetail, Builder> {
    public static final ProtoAdapter<SecretMessageDetail> ADAPTER = null;
    public static final ByteString DEFAULT_CONTENT = null;
    public static final String DEFAULT_FROM_DEVICE_ID = "";
    public static final ByteString DEFAULT_HEADER = null;
    public static final ByteString DEFAULT_SENDER_PUBLIC_KEY = null;
    private static final long serialVersionUID = 0;
    public final ByteString mcontent;
    public final String mfrom_device_id;
    public final ByteString mheader;
    public final ByteString msender_public_key;

    public static final class Builder extends com.squareup.wire.Message.Builder<SecretMessageDetail, Builder> {
        public ByteString mcontent;
        public String mfrom_device_id;
        public ByteString mheader;
        public ByteString msender_public_key;

        @Override // com.squareup.wire.Message.Builder
        public SecretMessageDetail build() {
            return new SecretMessageDetail(this.mcontent, this.msender_public_key, this.mheader, this.mfrom_device_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder content(ByteString r100) {
            this.mcontent = r100;
            return this;
        }

        public Builder from_device_id(String r100) {
            this.mfrom_device_id = r100;
            return this;
        }

        public Builder header(ByteString r100) {
            this.mheader = r100;
            return this;
        }

        public Builder sender_public_key(ByteString r100) {
            this.msender_public_key = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SecretMessageDetail extends ProtoAdapter<SecretMessageDetail> {
        public ProtoAdapter_SecretMessageDetail() {
            super(FieldEncoding.LENGTH_DELIMITED, SecretMessageDetail.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SecretMessageDetail decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            ByteString r102 = ByteString.EMPTY;
            r101.mcontent = r102;
            r101.msender_public_key = r102;
            r101.mheader = r102;
            r101.mfrom_device_id = "";
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L18;
            if (r104 != 1) goto L8;
            r101.mcontent = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.msender_public_key = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L12;
            r101.mheader = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L12:
            if (r104 != 4) goto L13;
            r101.mfrom_device_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SecretMessageDetail r100) {
            ByteString r101 = r100.mcontent;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BYTES.encodedSizeWithTag(1, r101);
        L6:
            ByteString r104 = r100.msender_public_key;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BYTES.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            ByteString r107 = r100.mheader;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BYTES.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.mfrom_device_id;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            return (r109 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ SecretMessageDetail decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SecretMessageDetail r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SecretMessageDetail r101) throws IOException {
            ByteString r102 = r101.mcontent;
            if (r102 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 1, r102);
        L5:
            ByteString r103 = r101.msender_public_key;
            if (r103 == null) goto L8;
            ProtoAdapter.BYTES.encodeWithTag(r100, 2, r103);
        L8:
            ByteString r104 = r101.mheader;
            if (r104 == null) goto L11;
            ProtoAdapter.BYTES.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.mfrom_device_id;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SecretMessageDetail r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SecretMessageDetail();
        ByteString r100 = ByteString.EMPTY;
        DEFAULT_CONTENT = r100;
        DEFAULT_SENDER_PUBLIC_KEY = r100;
        DEFAULT_HEADER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mcontent = this.mcontent;
        r100.msender_public_key = this.msender_public_key;
        r100.mheader = this.mheader;
        r100.mfrom_device_id = this.mfrom_device_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SecretMessageDetail.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public SecretMessageDetail(ByteString r100, ByteString r101, ByteString r102, String r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public SecretMessageDetail(ByteString r100, ByteString r101, ByteString r102, String r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mcontent = r100;
        this.msender_public_key = r101;
        this.mheader = r102;
        this.mfrom_device_id = r103;
    }
}
