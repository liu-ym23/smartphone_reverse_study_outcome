package com.ss.android.lark.pb.todo_entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class NumberFieldSettings extends Message<NumberFieldSettings, Builder> {
    public static final ProtoAdapter<NumberFieldSettings> ADAPTER = null;
    public static final String DEFAULT_CUSTOM_SYMBOL_CHARS = "";
    public static final Integer DEFAULT_DECIMAL_COUNT = null;
    private static final long serialVersionUID = 0;
    public final String mcustom_symbol_chars;
    public final CustomSymbolPosition mcustom_symbol_position;
    public final Integer mdecimal_count;
    public final Format mformat;
    public final Separator mseparator;

    public static final class Builder extends Message.Builder<NumberFieldSettings, Builder> {
        public String mcustom_symbol_chars;
        public CustomSymbolPosition mcustom_symbol_position;
        public Integer mdecimal_count;
        public Format mformat;
        public Separator mseparator;

        @Override // com.squareup.wire.Message.Builder
        public NumberFieldSettings build() {
            return new NumberFieldSettings(this.mformat, this.mcustom_symbol_chars, this.mcustom_symbol_position, this.mdecimal_count, this.mseparator, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder custom_symbol_chars(String r100) {
            this.mcustom_symbol_chars = r100;
            return this;
        }

        public Builder custom_symbol_position(CustomSymbolPosition r100) {
            this.mcustom_symbol_position = r100;
            return this;
        }

        public Builder decimal_count(Integer r100) {
            this.mdecimal_count = r100;
            return this;
        }

        public Builder format(Format r100) {
            this.mformat = r100;
            return this;
        }

        public Builder separator(Separator r100) {
            this.mseparator = r100;
            return this;
        }
    }

    public static final enum CustomSymbolPosition extends Enum<CustomSymbolPosition> implements WireEnum {
        private static final /* synthetic */ CustomSymbolPosition[] $VALUES = null;
        public static final ProtoAdapter<CustomSymbolPosition> ADAPTER = null;
        public static final CustomSymbolPosition LEFT = null;
        public static final CustomSymbolPosition RIGHT = null;
        private final int value;

        static {
            CustomSymbolPosition r100 = new CustomSymbolPosition("LEFT", 0, 1);
            LEFT = r100;
            CustomSymbolPosition r101 = new CustomSymbolPosition("RIGHT", 1, 2);
            RIGHT = r101;
            $VALUES = new CustomSymbolPosition[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(CustomSymbolPosition.class);
        }

        public static CustomSymbolPosition[] values() {
            return (CustomSymbolPosition[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static CustomSymbolPosition fromValue(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return null;
        L9:
            return RIGHT;
        L11:
            return LEFT;
        }

        public static CustomSymbolPosition valueOf(String r100) {
            return (CustomSymbolPosition) a.a(CustomSymbolPosition.class, r100);
        }

        private CustomSymbolPosition(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum Format extends Enum<Format> implements WireEnum {
        private static final /* synthetic */ Format[] $VALUES = null;
        public static final ProtoAdapter<Format> ADAPTER = null;
        public static final Format CUSTOM_SYMBOL = null;
        public static final Format NORMAL = null;
        public static final Format PERCENTAGE = null;
        public static final Format RMB = null;
        public static final Format USD = null;
        private final int value;

        static {
            Format r100 = new Format(EffectConstants.NORMAL, 0, 0);
            NORMAL = r100;
            Format r101 = new Format("PERCENTAGE", 1, 1);
            PERCENTAGE = r101;
            Format r102 = new Format("RMB", 2, 2);
            RMB = r102;
            Format r103 = new Format("USD", 3, 3);
            USD = r103;
            Format r104 = new Format("CUSTOM_SYMBOL", 4, 1000);
            CUSTOM_SYMBOL = r104;
            $VALUES = new Format[]{r100, r101, r102, r103, r104};
            ADAPTER = ProtoAdapter.newEnumAdapter(Format.class);
        }

        public static Format[] values() {
            return (Format[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Format fromValue(int r100) {
            if (r100 == 0) goto L22;
            if (r100 == 1) goto L20;
            if (r100 == 2) goto L18;
            if (r100 == 3) goto L16;
            if (r100 == 1000) goto L14;
            return null;
        L14:
            return CUSTOM_SYMBOL;
        L16:
            return USD;
        L18:
            return RMB;
        L20:
            return PERCENTAGE;
        L22:
            return NORMAL;
        }

        public static Format valueOf(String r100) {
            return (Format) a.a(Format.class, r100);
        }

        private Format(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_NumberFieldSettings extends ProtoAdapter<NumberFieldSettings> {
        public ProtoAdapter_NumberFieldSettings() {
            super(FieldEncoding.LENGTH_DELIMITED, NumberFieldSettings.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public NumberFieldSettings decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mcustom_symbol_chars = "";
            r101.mdecimal_count = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L30;
            if (r103 != 1) goto L8;
            r101.mformat = Format.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L28
        L28:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mcustom_symbol_chars = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mcustom_symbol_position = CustomSymbolPosition.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
        L23:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.mdecimal_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.mseparator = Separator.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L30:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(NumberFieldSettings r100) {
            Format r101 = r100.mformat;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = Format.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mcustom_symbol_chars;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            CustomSymbolPosition r107 = r100.mcustom_symbol_position;
            if (r107 == null) goto L13;
            int r108 = CustomSymbolPosition.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Integer r110 = r100.mdecimal_count;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.INT32.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Separator r113 = r100.mseparator;
            if (r113 == null) goto L22;
            r102 = Separator.ADAPTER.encodedSizeWithTag(5, r113);
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
        public /* bridge */ /* synthetic */ NumberFieldSettings decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(NumberFieldSettings r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, NumberFieldSettings r101) throws IOException {
            Format r102 = r101.mformat;
            if (r102 == null) goto L5;
            Format.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mcustom_symbol_chars;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            CustomSymbolPosition r104 = r101.mcustom_symbol_position;
            if (r104 == null) goto L11;
            CustomSymbolPosition.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            Integer r105 = r101.mdecimal_count;
            if (r105 == null) goto L14;
            ProtoAdapter.INT32.encodeWithTag(r100, 4, r105);
        L14:
            Separator r106 = r101.mseparator;
            if (r106 == null) goto L17;
            Separator.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, NumberFieldSettings r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Separator extends Enum<Separator> implements WireEnum {
        private static final /* synthetic */ Separator[] $VALUES = null;
        public static final ProtoAdapter<Separator> ADAPTER = null;
        public static final Separator NO = null;
        public static final Separator THOUSAND = null;
        private final int value;

        static {
            Separator r100 = new Separator("NO", 0, 0);
            NO = r100;
            Separator r101 = new Separator("THOUSAND", 1, 1);
            THOUSAND = r101;
            $VALUES = new Separator[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(Separator.class);
        }

        public static Separator[] values() {
            return (Separator[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Separator fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return THOUSAND;
        L10:
            return NO;
        }

        public static Separator valueOf(String r100) {
            return (Separator) a.a(Separator.class, r100);
        }

        private Separator(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_NumberFieldSettings();
        DEFAULT_DECIMAL_COUNT = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mformat = this.mformat;
        r100.mcustom_symbol_chars = this.mcustom_symbol_chars;
        r100.mcustom_symbol_position = this.mcustom_symbol_position;
        r100.mdecimal_count = this.mdecimal_count;
        r100.mseparator = this.mseparator;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return NumberFieldSettings.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public NumberFieldSettings(Format r100, String r101, CustomSymbolPosition r110, Integer r111, Separator r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public NumberFieldSettings(Format r100, String r101, CustomSymbolPosition r102, Integer r103, Separator r104, ByteString r105) {
        super(ADAPTER, r105);
        this.mformat = r100;
        this.mcustom_symbol_chars = r101;
        this.mcustom_symbol_position = r102;
        this.mdecimal_count = r103;
        this.mseparator = r104;
    }
}
