package com.bytedance.lark.pb.basic.v1;

import androidx.exifinterface.media.ExifInterface;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class ThemeColor extends com.squareup.wire.Message<ThemeColor, Builder> {
    public static final ProtoAdapter<ThemeColor> ADAPTER = null;
    public static final String DEFAULT_TOKEN = "";
    public static final Integer DEFAULT_VALUE = null;
    private static final long serialVersionUID = 0;
    public final Key key;
    public final String token;
    public final Integer value;

    public static final class Builder extends com.squareup.wire.Message.Builder<ThemeColor, Builder> {
        public Key key;
        public String token;
        public Integer value;

        @Override // com.squareup.wire.Message.Builder
        public ThemeColor build() {
            return new ThemeColor(this.token, this.key, this.value, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder key(Key r100) {
            this.key = r100;
            return this;
        }

        public Builder token(String r100) {
            this.token = r100;
            return this;
        }

        public Builder value(Integer r100) {
            this.value = r100;
            return this;
        }
    }

    public static final class Key extends com.squareup.wire.Message<Key, Builder> {
        public static final ProtoAdapter<Key> ADAPTER = null;
        public static final Integer DEFAULT_ALPHA = null;
        public static final KeyType DEFAULT_TYPE = null;
        public static final Integer DEFAULT_VALUE = null;
        private static final long serialVersionUID = 0;
        public final Integer alpha;
        public final KeyType type;
        public final Integer value;

        public static final class Builder extends com.squareup.wire.Message.Builder<Key, Builder> {
            public Integer alpha;
            public KeyType type;
            public Integer value;

            @Override // com.squareup.wire.Message.Builder
            public Key build() {
                KeyType r100 = this.type;
                if (r100 == null) goto L9;
                if (this.value == null) goto L9;
                return new Key(this.type, this.value, this.alpha, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r100, "type", this.value, "value"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder alpha(Integer r100) {
                this.alpha = r100;
                return this;
            }

            public Builder type(KeyType r100) {
                this.type = r100;
                return this;
            }

            public Builder value(Integer r100) {
                this.value = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Key extends ProtoAdapter<Key> {
            public ProtoAdapter_Key() {
                super(FieldEncoding.LENGTH_DELIMITED, Key.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Key decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.type = KeyType.N;
                r101.value = 0;
                r101.alpha = 100;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.type = KeyType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            L16:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.value = ProtoAdapter.UINT32.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.alpha = ProtoAdapter.UINT32.decode(r100);
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
            public int encodedSize2(Key r100) {
                int r101 = KeyType.ADAPTER.encodedSizeWithTag(1, r100.type);
                ProtoAdapter<Integer> r102 = ProtoAdapter.UINT32;
                int r103 = r101 + r102.encodedSizeWithTag(2, r100.value);
                Integer r104 = r100.alpha;
                if (r104 == null) goto L5;
                int r105 = r102.encodedSizeWithTag(3, r104);
            L7:
                return (r103 + r105) + r100.unknownFields().size();
            L5:
                r105 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Key decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Key r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Key r101) throws IOException {
                KeyType.ADAPTER.encodeWithTag(r100, 1, r101.type);
                ProtoAdapter<Integer> r102 = ProtoAdapter.UINT32;
                r102.encodeWithTag(r100, 2, r101.value);
                Integer r103 = r101.alpha;
                if (r103 == null) goto L5;
                r102.encodeWithTag(r100, 3, r103);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Key r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Key();
            DEFAULT_TYPE = KeyType.N;
            DEFAULT_VALUE = 0;
            DEFAULT_ALPHA = 100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.type = this.type;
            r100.value = this.value;
            r100.alpha = this.alpha;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Key.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public Key(KeyType r100, Integer r101, Integer r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public Key(KeyType r100, Integer r101, Integer r102, ByteString r103) {
            super(ADAPTER, r103);
            this.type = r100;
            this.value = r101;
            this.alpha = r102;
        }
    }

    public static final enum KeyType extends Enum<KeyType> implements WireEnum {
        private static final /* synthetic */ KeyType[] $VALUES = null;
        public static final ProtoAdapter<KeyType> ADAPTER = null;
        public static final KeyType B = null;
        public static final KeyType C = null;
        public static final KeyType G = null;
        public static final KeyType I = null;
        public static final KeyType L = null;
        public static final KeyType N = null;
        public static final KeyType O = null;
        public static final KeyType P = null;
        public static final KeyType R = null;
        public static final KeyType S = null;
        public static final KeyType STATIC_WHITE = null;
        public static final KeyType T = null;
        public static final KeyType V = null;
        public static final KeyType W = null;
        public static final KeyType Y = null;
        private final int value;

        static {
            KeyType r100 = new KeyType("N", 0, 0);
            N = r100;
            KeyType r101 = new KeyType("B", 1, 1);
            B = r101;
            KeyType r102 = new KeyType(ExifInterface.LONGITUDE_WEST, 2, 2);
            W = r102;
            KeyType r103 = new KeyType(ExifInterface.GPS_DIRECTION_TRUE, 3, 3);
            T = r103;
            KeyType r104 = new KeyType("G", 4, 4);
            G = r104;
            KeyType r105 = new KeyType("L", 5, 5);
            L = r105;
            KeyType r110 = new KeyType("Y", 6, 6);
            Y = r110;
            KeyType r111 = new KeyType(ExifInterface.LATITUDE_SOUTH, 7, 7);
            S = r111;
            KeyType r112 = new KeyType("O", 8, 8);
            O = r112;
            KeyType r113 = new KeyType("R", 9, 9);
            R = r113;
            KeyType r114 = new KeyType("C", 10, 10);
            C = r114;
            KeyType r115 = new KeyType("V", 11, 11);
            V = r115;
            KeyType r106 = new KeyType("P", 12, 12);
            P = r106;
            KeyType r107 = new KeyType("I", 13, 13);
            I = r107;
            KeyType r108 = new KeyType("STATIC_WHITE", 14, 14);
            STATIC_WHITE = r108;
            $VALUES = new KeyType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108};
            ADAPTER = ProtoAdapter.newEnumAdapter(KeyType.class);
        }

        public static KeyType[] values() {
            return (KeyType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static KeyType fromValue(int r100) {
            switch(r100) {
                case 0: goto L34;
                case 1: goto L32;
                case 2: goto L30;
                case 3: goto L28;
                case 4: goto L26;
                case 5: goto L24;
                case 6: goto L22;
                case 7: goto L20;
                case 8: goto L18;
                case 9: goto L16;
                case 10: goto L14;
                case 11: goto L12;
                case 12: goto L10;
                case 13: goto L8;
                case 14: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return STATIC_WHITE;
        L8:
            return I;
        L10:
            return P;
        L12:
            return V;
        L14:
            return C;
        L16:
            return R;
        L18:
            return O;
        L20:
            return S;
        L22:
            return Y;
        L24:
            return L;
        L26:
            return G;
        L28:
            return T;
        L30:
            return W;
        L32:
            return B;
        L34:
            return N;
        }

        public static KeyType valueOf(String r100) {
            return (KeyType) a.a(KeyType.class, r100);
        }

        private KeyType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_ThemeColor extends ProtoAdapter<ThemeColor> {
        public ProtoAdapter_ThemeColor() {
            super(FieldEncoding.LENGTH_DELIMITED, ThemeColor.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ThemeColor decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.token = "";
            r101.value = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.key = Key.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.value = ProtoAdapter.UINT32.decode(r100);
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
        public int encodedSize2(ThemeColor r100) {
            String r101 = r100.token;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Key r104 = r100.key;
            if (r104 == null) goto L9;
            int r105 = Key.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Integer r107 = r100.value;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.UINT32.encodedSizeWithTag(3, r107);
        L14:
            return (r106 + r102) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ThemeColor decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ThemeColor r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ThemeColor r101) throws IOException {
            String r102 = r101.token;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Key r103 = r101.key;
            if (r103 == null) goto L8;
            Key.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            Integer r104 = r101.value;
            if (r104 == null) goto L11;
            ProtoAdapter.UINT32.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ThemeColor r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ThemeColor();
        DEFAULT_VALUE = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.token = this.token;
        r100.key = this.key;
        r100.value = this.value;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ThemeColor.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public ThemeColor(String r100, Key r101, Integer r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public ThemeColor(String r100, Key r101, Integer r102, ByteString r103) {
        super(ADAPTER, r103);
        this.token = r100;
        this.key = r101;
        this.value = r102;
    }
}
