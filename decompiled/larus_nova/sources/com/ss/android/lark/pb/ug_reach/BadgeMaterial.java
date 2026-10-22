package com.ss.android.lark.pb.ug_reach;

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

/* JADX INFO: loaded from: classes37.dex */
public final class BadgeMaterial extends Message<BadgeMaterial, Builder> {
    public static final ProtoAdapter<BadgeMaterial> ADAPTER = null;
    public static final Integer DEFAULT_VIEWNUMBER = null;
    private static final long serialVersionUID = 0;
    public final Integer mViewNumber;
    public final TextElement mViewText;
    public final MaterialBase mbase;
    public final BadgeType mtype;

    public static final enum BadgeType extends Enum<BadgeType> implements WireEnum {
        private static final /* synthetic */ BadgeType[] $VALUES = null;
        public static final ProtoAdapter<BadgeType> ADAPTER = null;
        public static final BadgeType Number = null;
        public static final BadgeType RedPoint = null;
        public static final BadgeType Text = null;
        private final int value;

        static {
            BadgeType r100 = new BadgeType("RedPoint", 0, 1);
            RedPoint = r100;
            BadgeType r101 = new BadgeType("Text", 1, 2);
            Text = r101;
            BadgeType r102 = new BadgeType("Number", 2, 3);
            Number = r102;
            $VALUES = new BadgeType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(BadgeType.class);
        }

        public static BadgeType[] values() {
            return (BadgeType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static BadgeType fromValue(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return null;
        L11:
            return Number;
        L13:
            return Text;
        L15:
            return RedPoint;
        }

        public static BadgeType valueOf(String r100) {
            return (BadgeType) a.a(BadgeType.class, r100);
        }

        private BadgeType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Builder extends Message.Builder<BadgeMaterial, Builder> {
        public Integer mViewNumber;
        public TextElement mViewText;
        public MaterialBase mbase;
        public BadgeType mtype;

        @Override // com.squareup.wire.Message.Builder
        public BadgeMaterial build() {
            return new BadgeMaterial(this.mbase, this.mtype, this.mViewNumber, this.mViewText, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder ViewNumber(Integer r100) {
            this.mViewNumber = r100;
            this.mViewText = null;
            return this;
        }

        public Builder ViewText(TextElement r100) {
            this.mViewText = r100;
            this.mViewNumber = null;
            return this;
        }

        public Builder base(MaterialBase r100) {
            this.mbase = r100;
            return this;
        }

        public Builder type(BadgeType r100) {
            this.mtype = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_BadgeMaterial extends ProtoAdapter<BadgeMaterial> {
        public ProtoAdapter_BadgeMaterial() {
            super(FieldEncoding.LENGTH_DELIMITED, BadgeMaterial.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public BadgeMaterial decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.ViewNumber(0);
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.mbase = MaterialBase.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mtype = BadgeType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.ViewNumber(ProtoAdapter.INT32.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.ViewText(TextElement.ADAPTER.decode(r100));
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
        public int encodedSize2(BadgeMaterial r100) {
            MaterialBase r101 = r100.mbase;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = MaterialBase.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            BadgeType r104 = r100.mtype;
            if (r104 == null) goto L9;
            int r105 = BadgeType.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Integer r107 = r100.mViewNumber;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT32.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            TextElement r110 = r100.mViewText;
            if (r110 == null) goto L18;
            r102 = TextElement.ADAPTER.encodedSizeWithTag(4, r110);
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
        public /* bridge */ /* synthetic */ BadgeMaterial decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BadgeMaterial r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BadgeMaterial r101) throws IOException {
            MaterialBase r102 = r101.mbase;
            if (r102 == null) goto L5;
            MaterialBase.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            BadgeType r103 = r101.mtype;
            if (r103 == null) goto L8;
            BadgeType.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            Integer r104 = r101.mViewNumber;
            if (r104 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
        L11:
            TextElement r105 = r101.mViewText;
            if (r105 == null) goto L14;
            TextElement.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BadgeMaterial r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BadgeMaterial();
        DEFAULT_VIEWNUMBER = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mbase = this.mbase;
        r100.mtype = this.mtype;
        r100.mViewNumber = this.mViewNumber;
        r100.mViewText = this.mViewText;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return BadgeMaterial.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public BadgeMaterial(MaterialBase r100, BadgeType r101, Integer r102, TextElement r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public BadgeMaterial(MaterialBase r100, BadgeType r101, Integer r102, TextElement r103, ByteString r104) {
        super(ADAPTER, r104);
        if (Internal.countNonNull(r102, r103) > 1) goto L7;
        this.mbase = r100;
        this.mtype = r101;
        this.mViewNumber = r102;
        this.mViewText = r103;
        return;
    L7:
        throw new IllegalArgumentException("at most one of mViewNumber, mViewText may be non-null");
    }
}
