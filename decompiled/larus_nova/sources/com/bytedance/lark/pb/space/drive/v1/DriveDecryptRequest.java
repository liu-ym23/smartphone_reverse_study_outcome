package com.bytedance.lark.pb.space.drive.v1;

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
public final class DriveDecryptRequest extends Message<DriveDecryptRequest, Builder> {
    public static final ProtoAdapter<DriveDecryptRequest> ADAPTER = null;
    public static final ByteString DEFAULT_BODY = null;
    public static final DecryptType DEFAULT_DECRYPT_TYPE = null;
    public static final String DEFAULT_KEY = "";
    public static final String DEFAULT_NONCE = "";
    public static final ProtoAdapter_DriveDecryptRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ByteString body;
    public final DecryptType decrypt_type;
    public final String key;
    public final String nonce;

    public static final class Builder extends Message.Builder<DriveDecryptRequest, Builder> implements d<DriveDecryptRequest> {
        public ByteString body;
        public DecryptType decrypt_type;
        public String key;
        public String nonce;

        @Override // com.squareup.wire.Message.Builder
        public DriveDecryptRequest build() {
            DecryptType r100 = this.decrypt_type;
            if (r100 == null) goto L7;
            return new DriveDecryptRequest(this.decrypt_type, this.key, this.nonce, this.body, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "decrypt_type"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder body(ByteString r100) {
            this.body = r100;
            return this;
        }

        public Builder decrypt_type(DecryptType r100) {
            this.decrypt_type = r100;
            return this;
        }

        public Builder key(String r100) {
            this.key = r100;
            return this;
        }

        public Builder nonce(String r100) {
            this.nonce = r100;
            return this;
        }
    }

    public static final enum DecryptType extends Enum<DecryptType> implements WireEnum {
        private static final /* synthetic */ DecryptType[] $VALUES = null;
        public static final ProtoAdapter<DecryptType> ADAPTER = null;
        public static final DecryptType AesGcm = null;
        public static final DecryptType Sm4Gcm = null;
        private final int value;

        static {
            DecryptType r100 = new DecryptType("AesGcm", 0, 0);
            AesGcm = r100;
            DecryptType r101 = new DecryptType("Sm4Gcm", 1, 1);
            Sm4Gcm = r101;
            $VALUES = new DecryptType[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(DecryptType.class);
        }

        public static DecryptType[] values() {
            return (DecryptType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static DecryptType fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return Sm4Gcm;
        L10:
            return AesGcm;
        }

        public static DecryptType valueOf(String r100) {
            return (DecryptType) a.a(DecryptType.class, r100);
        }

        private DecryptType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_DriveDecryptRequest extends ProtoAdapter<DriveDecryptRequest> implements c<DriveDecryptRequest> {
        public ProtoAdapter_DriveDecryptRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, DriveDecryptRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DriveDecryptRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.decrypt_type = DecryptType.AesGcm;
            r101.key = "";
            r101.nonce = "";
            r101.body = ByteString.EMPTY;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.decrypt_type = DecryptType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.nonce = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.body = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(DriveDecryptRequest r100) {
            int r101 = DecryptType.ADAPTER.encodedSizeWithTag(1, r100.decrypt_type);
            String r102 = r100.key;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.STRING.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            String r106 = r100.nonce;
            if (r106 == null) goto L9;
            int r107 = ProtoAdapter.STRING.encodedSizeWithTag(3, r106);
        L10:
            int r108 = r105 + r107;
            ByteString r109 = r100.body;
            if (r109 == null) goto L14;
            r103 = ProtoAdapter.BYTES.encodedSizeWithTag(4, r109);
        L14:
            return (r108 + r103) + r100.unknownFields().size();
        L9:
            r107 = 0;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DriveDecryptRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DriveDecryptRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DriveDecryptRequest r101) throws IOException {
            DecryptType.ADAPTER.encodeWithTag(r100, 1, r101.decrypt_type);
            String r102 = r101.key;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r102);
        L5:
            String r103 = r101.nonce;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r103);
        L8:
            ByteString r104 = r101.body;
            if (r104 == null) goto L11;
            ProtoAdapter.BYTES.encodeWithTag(r100, 4, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DriveDecryptRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_DriveDecryptRequest r100 = new ProtoAdapter_DriveDecryptRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_DECRYPT_TYPE = DecryptType.AesGcm;
        DEFAULT_BODY = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.decrypt_type = this.decrypt_type;
        r100.key = this.key;
        r100.nonce = this.nonce;
        r100.body = this.body;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DriveDecryptRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DriveDecryptRequest(DecryptType r100, String r101, String r102, ByteString r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public DriveDecryptRequest(DecryptType r100, String r101, String r102, ByteString r103, ByteString r104) {
        super(ADAPTER, r104);
        this.decrypt_type = r100;
        this.key = r101;
        this.nonce = r102;
        this.body = r103;
    }
}
