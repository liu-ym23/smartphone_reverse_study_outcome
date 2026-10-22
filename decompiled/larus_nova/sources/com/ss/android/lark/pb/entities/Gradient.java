package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class Gradient extends com.squareup.wire.Message<Gradient, Builder> {
    public static final ProtoAdapter<Gradient> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Linear mlinear;
    public final Type mtype;

    public static final class Builder extends com.squareup.wire.Message.Builder<Gradient, Builder> {
        public Linear mlinear;
        public Type mtype;

        @Override // com.squareup.wire.Message.Builder
        public Gradient build() {
            return new Gradient(this.mtype, this.mlinear, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder linear(Linear r100) {
            this.mlinear = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.mtype = r100;
            return this;
        }
    }

    public static final class Linear extends com.squareup.wire.Message<Linear, Builder> {
        public static final ProtoAdapter<Linear> ADAPTER = null;
        public static final Integer DEFAULT_DEG = null;
        private static final long serialVersionUID = 0;
        public final List<Integer> mcolors;
        public final List<Integer> mcolors_v2;
        public final List<ThemeColor> mcolors_v3;
        public final Integer mdeg;

        public static final class Builder extends com.squareup.wire.Message.Builder<Linear, Builder> {
            public List<Integer> mcolors;
            public List<Integer> mcolors_v2;
            public List<ThemeColor> mcolors_v3;
            public Integer mdeg;

            @Override // com.squareup.wire.Message.Builder
            public Linear build() {
                return new Linear(this.mdeg, this.mcolors, this.mcolors_v2, this.mcolors_v3, super.buildUnknownFields());
            }

            public Builder() {
                this.mcolors = Internal.newMutableList();
                this.mcolors_v2 = Internal.newMutableList();
                this.mcolors_v3 = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder colors(List<Integer> r100) {
                Internal.checkElementsNotNull(r100);
                this.mcolors = r100;
                return this;
            }

            public Builder colors_v2(List<Integer> r100) {
                Internal.checkElementsNotNull(r100);
                this.mcolors_v2 = r100;
                return this;
            }

            public Builder colors_v3(List<ThemeColor> r100) {
                Internal.checkElementsNotNull(r100);
                this.mcolors_v3 = r100;
                return this;
            }

            public Builder deg(Integer r100) {
                this.mdeg = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Linear extends ProtoAdapter<Linear> {
            public ProtoAdapter_Linear() {
                super(FieldEncoding.LENGTH_DELIMITED, Linear.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Linear decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mdeg = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.mdeg = ProtoAdapter.INT32.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.mcolors.add(ProtoAdapter.INT32.decode(r100));
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.mcolors_v2.add(ProtoAdapter.UINT32.decode(r100));
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.mcolors_v3.add(ThemeColor.ADAPTER.decode(r100));
                goto L3
            L13:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L18:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(Linear r100) {
                Integer r101 = r100.mdeg;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
            L7:
                return (((r102 + ProtoAdapter.INT32.asRepeated().encodedSizeWithTag(2, r100.mcolors)) + ProtoAdapter.UINT32.asRepeated().encodedSizeWithTag(3, r100.mcolors_v2)) + ThemeColor.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.mcolors_v3)) + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Linear decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Linear r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Linear r101) throws IOException {
                Integer r102 = r101.mdeg;
                if (r102 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
            L5:
                ProtoAdapter.INT32.asRepeated().encodeWithTag(r100, 2, r101.mcolors);
                ProtoAdapter.UINT32.asRepeated().encodeWithTag(r100, 3, r101.mcolors_v2);
                ThemeColor.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.mcolors_v3);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Linear r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Linear();
            DEFAULT_DEG = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mdeg = this.mdeg;
            r100.mcolors = Internal.copyOf("mcolors", this.mcolors);
            r100.mcolors_v2 = Internal.copyOf("mcolors_v2", this.mcolors_v2);
            r100.mcolors_v3 = Internal.copyOf("mcolors_v3", this.mcolors_v3);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Linear.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public Linear(Integer r100, List<Integer> r101, List<Integer> r102, List<ThemeColor> r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public Linear(Integer r100, List<Integer> r101, List<Integer> r102, List<ThemeColor> r103, ByteString r104) {
            super(ADAPTER, r104);
            this.mdeg = r100;
            this.mcolors = Internal.immutableCopyOf("mcolors", r101);
            this.mcolors_v2 = Internal.immutableCopyOf("mcolors_v2", r102);
            this.mcolors_v3 = Internal.immutableCopyOf("mcolors_v3", r103);
        }
    }

    public static final class ProtoAdapter_Gradient extends ProtoAdapter<Gradient> {
        public ProtoAdapter_Gradient() {
            super(FieldEncoding.LENGTH_DELIMITED, Gradient.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Gradient decode(ProtoReader r100) throws IOException {
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
            r101.linear(Linear.ADAPTER.decode(r100));
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
        public int encodedSize2(Gradient r100) {
            Type r101 = r100.mtype;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = Type.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            Linear r104 = r100.mlinear;
            if (r104 == null) goto L10;
            r102 = Linear.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Gradient decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Gradient r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Gradient r101) throws IOException {
            Type r102 = r101.mtype;
            if (r102 == null) goto L5;
            Type.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            Linear r103 = r101.mlinear;
            if (r103 == null) goto L8;
            Linear.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Gradient r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type LINEAR = null;
        private final int value;

        static {
            Type r100 = new Type("LINEAR", 0, 0);
            LINEAR = r100;
            $VALUES = new Type[]{r100};
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
            if (r100 == 0) goto L6;
            return null;
        L6:
            return LINEAR;
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
        ADAPTER = new ProtoAdapter_Gradient();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mtype = this.mtype;
        r100.mlinear = this.mlinear;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Gradient.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public Gradient(Type r100, Linear r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public Gradient(Type r100, Linear r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mtype = r100;
        this.mlinear = r101;
    }
}
