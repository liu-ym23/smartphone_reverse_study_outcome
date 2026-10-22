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
public final class Crypto extends com.squareup.wire.Message<Crypto, Builder> {
    public static final ProtoAdapter<Crypto> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Cipher mcipher;
    public final Type mtype;

    public static final class Builder extends com.squareup.wire.Message.Builder<Crypto, Builder> {
        public Cipher mcipher;
        public Type mtype;

        @Override // com.squareup.wire.Message.Builder
        public Crypto build() {
            return new Crypto(this.mtype, this.mcipher, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder cipher(Cipher r100) {
            this.mcipher = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.mtype = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Crypto extends ProtoAdapter<Crypto> {
        public ProtoAdapter_Crypto() {
            super(FieldEncoding.LENGTH_DELIMITED, Crypto.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Crypto decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.mtype = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mcipher = Cipher.ADAPTER.decode(r100);
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
        public int encodedSize2(Crypto r100) {
            Type r101 = r100.mtype;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = Type.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            Cipher r104 = r100.mcipher;
            if (r104 == null) goto L10;
            r102 = Cipher.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Crypto decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Crypto r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Crypto r101) throws IOException {
            Type r102 = r101.mtype;
            if (r102 == null) goto L5;
            Type.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            Cipher r103 = r101.mcipher;
            if (r103 == null) goto L8;
            Cipher.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Crypto r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type AES_256_GCM = null;
        public static final Type AES_CTR = null;
        public static final Type CRYPTO_SDK_DOWNGRADE = null;
        public static final Type CRYPTO_SDK_THIRDPARTY = null;
        public static final Type CRYPTO_SDK_UNIFIED = null;
        public static final Type SM4_128 = null;
        public static final Type UNKNOWN = null;
        private final int value;

        static {
            Type r100 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Type r101 = new Type("AES_256_GCM", 1, 1);
            AES_256_GCM = r101;
            Type r102 = new Type("AES_CTR", 2, 2);
            AES_CTR = r102;
            Type r103 = new Type("CRYPTO_SDK_UNIFIED", 3, 3);
            CRYPTO_SDK_UNIFIED = r103;
            Type r104 = new Type("CRYPTO_SDK_DOWNGRADE", 4, 4);
            CRYPTO_SDK_DOWNGRADE = r104;
            Type r105 = new Type("CRYPTO_SDK_THIRDPARTY", 5, 5);
            CRYPTO_SDK_THIRDPARTY = r105;
            Type r110 = new Type("SM4_128", 6, 6);
            SM4_128 = r110;
            $VALUES = new Type[]{r100, r101, r102, r103, r104, r105, r110};
            ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Type fromValue(int r100) {
            switch(r100) {
                case 0: goto L18;
                case 1: goto L16;
                case 2: goto L14;
                case 3: goto L12;
                case 4: goto L10;
                case 5: goto L8;
                case 6: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return SM4_128;
        L8:
            return CRYPTO_SDK_THIRDPARTY;
        L10:
            return CRYPTO_SDK_DOWNGRADE;
        L12:
            return CRYPTO_SDK_UNIFIED;
        L14:
            return AES_CTR;
        L16:
            return AES_256_GCM;
        L18:
            return UNKNOWN;
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        private Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Crypto();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mtype = this.mtype;
        r100.mcipher = this.mcipher;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Crypto.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public Crypto(Type r100, Cipher r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public Crypto(Type r100, Cipher r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mtype = r100;
        this.mcipher = r101;
    }
}
