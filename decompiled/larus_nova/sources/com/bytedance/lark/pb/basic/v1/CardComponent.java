package com.bytedance.lark.pb.basic.v1;

import com.alibaba.gaiax.model.GXAnimation;
import com.bytedance.ee.bear.sheet.fab.FabItem;
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

/* JADX INFO: loaded from: classes20.dex */
public final class CardComponent extends com.squareup.wire.Message<CardComponent, Builder> {
    public static final ProtoAdapter<CardComponent> ADAPTER = null;
    public static final Type DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;
    public final List<String> child_ids;
    public final EngineProperty engine;
    public final FlexLayoutProperty flex_layout;
    public final Style style;
    public final Type type;

    public static final enum Align extends Enum<Align> implements WireEnum {
        private static final /* synthetic */ Align[] $VALUES = null;
        public static final ProtoAdapter<Align> ADAPTER = null;
        public static final Align BASELINE = null;
        public static final Align BOTTOM = null;
        public static final Align MIDDLE = null;
        public static final Align STRETCH = null;
        public static final Align TOP = null;
        private final int value;

        static {
            Align r100 = new Align("TOP", 0, 0);
            TOP = r100;
            Align r101 = new Align("MIDDLE", 1, 1);
            MIDDLE = r101;
            Align r102 = new Align("BOTTOM", 2, 2);
            BOTTOM = r102;
            Align r103 = new Align("STRETCH", 3, 3);
            STRETCH = r103;
            Align r104 = new Align("BASELINE", 4, 4);
            BASELINE = r104;
            $VALUES = new Align[]{r100, r101, r102, r103, r104};
            ADAPTER = ProtoAdapter.newEnumAdapter(Align.class);
        }

        public static Align[] values() {
            return (Align[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Align fromValue(int r100) {
            if (r100 == 0) goto L22;
            if (r100 == 1) goto L20;
            if (r100 == 2) goto L18;
            if (r100 == 3) goto L16;
            if (r100 == 4) goto L14;
            return null;
        L14:
            return BASELINE;
        L16:
            return STRETCH;
        L18:
            return BOTTOM;
        L20:
            return MIDDLE;
        L22:
            return TOP;
        }

        public static Align valueOf(String r100) {
            return (Align) a.a(Align.class, r100);
        }

        private Align(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Builder extends com.squareup.wire.Message.Builder<CardComponent, Builder> {
        public List<String> child_ids;
        public EngineProperty engine;
        public FlexLayoutProperty flex_layout;
        public Style style;
        public Type type;

        @Override // com.squareup.wire.Message.Builder
        public CardComponent build() {
            Type r100 = this.type;
            if (r100 == null) goto L7;
            return new CardComponent(this.type, this.child_ids, this.style, this.engine, this.flex_layout, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "type"});
        }

        public Builder() {
            this.child_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder child_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.child_ids = r100;
            return this;
        }

        public Builder engine(EngineProperty r100) {
            this.engine = r100;
            this.flex_layout = null;
            return this;
        }

        public Builder flex_layout(FlexLayoutProperty r100) {
            this.flex_layout = r100;
            this.engine = null;
            return this;
        }

        public Builder style(Style r100) {
            this.style = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class EngineProperty extends com.squareup.wire.Message<EngineProperty, Builder> {
        public static final ProtoAdapter<EngineProperty> ADAPTER = null;
        public static final EngineType DEFAULT_TYPE = null;
        private static final long serialVersionUID = 0;
        public final EngineType type;

        public static final class Builder extends com.squareup.wire.Message.Builder<EngineProperty, Builder> {
            public EngineType type;

            @Override // com.squareup.wire.Message.Builder
            public EngineProperty build() {
                return new EngineProperty(this.type, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder type(EngineType r100) {
                this.type = r100;
                return this;
            }
        }

        public static final enum EngineType extends Enum<EngineType> implements WireEnum {
            private static final /* synthetic */ EngineType[] $VALUES = null;
            public static final ProtoAdapter<EngineType> ADAPTER = null;
            public static final EngineType SMARTCARD = null;
            private final int value;

            static {
                EngineType r100 = new EngineType("SMARTCARD", 0, 0);
                SMARTCARD = r100;
                $VALUES = new EngineType[]{r100};
                ADAPTER = ProtoAdapter.newEnumAdapter(EngineType.class);
            }

            public static EngineType[] values() {
                return (EngineType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static EngineType fromValue(int r100) {
                if (r100 == 0) goto L6;
                return null;
            L6:
                return SMARTCARD;
            }

            public static EngineType valueOf(String r100) {
                return (EngineType) a.a(EngineType.class, r100);
            }

            private EngineType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_EngineProperty extends ProtoAdapter<EngineProperty> {
            public ProtoAdapter_EngineProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, EngineProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public EngineProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.type = EngineType.SMARTCARD;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L7;
                r101.type = EngineType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
            L10:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(EngineProperty r100) {
                EngineType r101 = r100.type;
                if (r101 == null) goto L5;
                int r102 = EngineType.ADAPTER.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ EngineProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(EngineProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, EngineProperty r101) throws IOException {
                EngineType r102 = r101.type;
                if (r102 == null) goto L5;
                EngineType.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EngineProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_EngineProperty();
            DEFAULT_TYPE = EngineType.SMARTCARD;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.type = this.type;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return EngineProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public EngineProperty(EngineType r100) {
            this(r100, ByteString.EMPTY);
        }

        public EngineProperty(EngineType r100, ByteString r101) {
            super(ADAPTER, r101);
            this.type = r100;
        }
    }

    public static final class FlexLayoutProperty extends com.squareup.wire.Message<FlexLayoutProperty, Builder> {
        public static final ProtoAdapter<FlexLayoutProperty> ADAPTER = null;
        public static final Align DEFAULT_CROSS_AXIS_ALIGN = null;
        public static final Float DEFAULT_CROSS_AXIS_SPACING = null;
        public static final FlexWrap DEFAULT_FLEX_WRAP = null;
        public static final Boolean DEFAULT_FORCE_USE_COMPACT_MODE = null;
        public static final Justify DEFAULT_MAIN_AXIS_JUSTIFY = null;
        public static final Float DEFAULT_MAIN_AXIS_SPACING = null;
        public static final Orientation DEFAULT_ORIENTATION = null;
        private static final long serialVersionUID = 0;
        public final Align cross_axis_align;
        public final Float cross_axis_spacing;
        public final FlexWrap flex_wrap;
        public final Boolean force_use_compact_mode;
        public final Justify main_axis_justify;
        public final Float main_axis_spacing;
        public final Orientation orientation;
        public final Padding padding;

        public static final class Builder extends com.squareup.wire.Message.Builder<FlexLayoutProperty, Builder> {
            public Align cross_axis_align;
            public Float cross_axis_spacing;
            public FlexWrap flex_wrap;
            public Boolean force_use_compact_mode;
            public Justify main_axis_justify;
            public Float main_axis_spacing;
            public Orientation orientation;
            public Padding padding;

            @Override // com.squareup.wire.Message.Builder
            public FlexLayoutProperty build() {
                return new FlexLayoutProperty(this.orientation, this.flex_wrap, this.main_axis_spacing, this.cross_axis_spacing, this.padding, this.main_axis_justify, this.cross_axis_align, this.force_use_compact_mode, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder cross_axis_align(Align r100) {
                this.cross_axis_align = r100;
                return this;
            }

            public Builder cross_axis_spacing(Float r100) {
                this.cross_axis_spacing = r100;
                return this;
            }

            public Builder flex_wrap(FlexWrap r100) {
                this.flex_wrap = r100;
                return this;
            }

            public Builder force_use_compact_mode(Boolean r100) {
                this.force_use_compact_mode = r100;
                return this;
            }

            public Builder main_axis_justify(Justify r100) {
                this.main_axis_justify = r100;
                return this;
            }

            public Builder main_axis_spacing(Float r100) {
                this.main_axis_spacing = r100;
                return this;
            }

            public Builder orientation(Orientation r100) {
                this.orientation = r100;
                return this;
            }

            public Builder padding(Padding r100) {
                this.padding = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_FlexLayoutProperty extends ProtoAdapter<FlexLayoutProperty> {
            public ProtoAdapter_FlexLayoutProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, FlexLayoutProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public FlexLayoutProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.orientation = Orientation.ROW;
                r101.flex_wrap = FlexWrap.NO_WRAP;
                Float r102 = Float.valueOf(0.0f);
                r101.main_axis_spacing = r102;
                r101.cross_axis_spacing = r102;
                r101.main_axis_justify = Justify.START;
                r101.cross_axis_align = Align.TOP;
                r101.force_use_compact_mode = Boolean.FALSE;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L27;
                switch(r104) {
                    case 1: goto L33;
                    case 2: goto L35;
                    case 3: goto L18;
                    case 4: goto L17;
                    case 5: goto L16;
                    case 6: goto L29;
                    case 7: goto L31;
                    case 8: goto L7;
                    default: goto L6;
                };
            L29:
                r101.main_axis_justify = Justify.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L31:
                r101.cross_axis_align = Align.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
            L10:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L33:
                r101.orientation = Orientation.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L25
            L25:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L35:
                r101.flex_wrap = FlexWrap.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
            L21:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r101.force_use_compact_mode = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L16:
                r101.padding = Padding.ADAPTER.decode(r100);
                goto L3
            L17:
                r101.cross_axis_spacing = ProtoAdapter.FLOAT.decode(r100);
                goto L3
            L18:
                r101.main_axis_spacing = ProtoAdapter.FLOAT.decode(r100);
                goto L3
            L6:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L27:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(FlexLayoutProperty r100) {
                Orientation r101 = r100.orientation;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = Orientation.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                FlexWrap r104 = r100.flex_wrap;
                if (r104 == null) goto L9;
                int r105 = FlexWrap.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Float r107 = r100.main_axis_spacing;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.FLOAT.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                Float r110 = r100.cross_axis_spacing;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.FLOAT.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                Padding r113 = r100.padding;
                if (r113 == null) goto L21;
                int r114 = Padding.ADAPTER.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                Justify r116 = r100.main_axis_justify;
                if (r116 == null) goto L25;
                int r117 = Justify.ADAPTER.encodedSizeWithTag(6, r116);
            L26:
                int r118 = r115 + r117;
                Align r119 = r100.cross_axis_align;
                if (r119 == null) goto L29;
                int r120 = Align.ADAPTER.encodedSizeWithTag(7, r119);
            L30:
                int r121 = r118 + r120;
                Boolean r122 = r100.force_use_compact_mode;
                if (r122 == null) goto L34;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r122);
            L34:
                return (r121 + r102) + r100.unknownFields().size();
            L29:
                r120 = 0;
                goto L30
            L25:
                r117 = 0;
                goto L26
            L21:
                r114 = 0;
                goto L22
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
            public /* bridge */ /* synthetic */ FlexLayoutProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(FlexLayoutProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, FlexLayoutProperty r101) throws IOException {
                Orientation r102 = r101.orientation;
                if (r102 == null) goto L5;
                Orientation.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                FlexWrap r103 = r101.flex_wrap;
                if (r103 == null) goto L8;
                FlexWrap.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                Float r104 = r101.main_axis_spacing;
                if (r104 == null) goto L11;
                ProtoAdapter.FLOAT.encodeWithTag(r100, 3, r104);
            L11:
                Float r105 = r101.cross_axis_spacing;
                if (r105 == null) goto L14;
                ProtoAdapter.FLOAT.encodeWithTag(r100, 4, r105);
            L14:
                Padding r106 = r101.padding;
                if (r106 == null) goto L17;
                Padding.ADAPTER.encodeWithTag(r100, 5, r106);
            L17:
                Justify r107 = r101.main_axis_justify;
                if (r107 == null) goto L20;
                Justify.ADAPTER.encodeWithTag(r100, 6, r107);
            L20:
                Align r108 = r101.cross_axis_align;
                if (r108 == null) goto L23;
                Align.ADAPTER.encodeWithTag(r100, 7, r108);
            L23:
                Boolean r109 = r101.force_use_compact_mode;
                if (r109 == null) goto L26;
                ProtoAdapter.BOOL.encodeWithTag(r100, 8, r109);
            L26:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FlexLayoutProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_FlexLayoutProperty();
            DEFAULT_ORIENTATION = Orientation.ROW;
            DEFAULT_FLEX_WRAP = FlexWrap.NO_WRAP;
            Float r100 = Float.valueOf(0.0f);
            DEFAULT_MAIN_AXIS_SPACING = r100;
            DEFAULT_CROSS_AXIS_SPACING = r100;
            DEFAULT_MAIN_AXIS_JUSTIFY = Justify.START;
            DEFAULT_CROSS_AXIS_ALIGN = Align.TOP;
            DEFAULT_FORCE_USE_COMPACT_MODE = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.orientation = this.orientation;
            r100.flex_wrap = this.flex_wrap;
            r100.main_axis_spacing = this.main_axis_spacing;
            r100.cross_axis_spacing = this.cross_axis_spacing;
            r100.padding = this.padding;
            r100.main_axis_justify = this.main_axis_justify;
            r100.cross_axis_align = this.cross_axis_align;
            r100.force_use_compact_mode = this.force_use_compact_mode;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return FlexLayoutProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public FlexLayoutProperty(Orientation r110, FlexWrap r111, Float r112, Float r113, Padding r114, Justify r115, Align r116, Boolean r117) {
            this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
        }

        public FlexLayoutProperty(Orientation r100, FlexWrap r101, Float r102, Float r103, Padding r104, Justify r105, Align r106, Boolean r107, ByteString r110) {
            super(ADAPTER, r110);
            this.orientation = r100;
            this.flex_wrap = r101;
            this.main_axis_spacing = r102;
            this.cross_axis_spacing = r103;
            this.padding = r104;
            this.main_axis_justify = r105;
            this.cross_axis_align = r106;
            this.force_use_compact_mode = r107;
        }
    }

    public static final enum FlexWrap extends Enum<FlexWrap> implements WireEnum {
        private static final /* synthetic */ FlexWrap[] $VALUES = null;
        public static final ProtoAdapter<FlexWrap> ADAPTER = null;
        public static final FlexWrap LINEAR_WRAP = null;
        public static final FlexWrap NO_WRAP = null;
        public static final FlexWrap WRAP = null;
        public static final FlexWrap WRAP_REVERSE = null;
        private final int value;

        static {
            FlexWrap r100 = new FlexWrap("NO_WRAP", 0, 0);
            NO_WRAP = r100;
            FlexWrap r101 = new FlexWrap("WRAP", 1, 1);
            WRAP = r101;
            FlexWrap r102 = new FlexWrap("WRAP_REVERSE", 2, 2);
            WRAP_REVERSE = r102;
            FlexWrap r103 = new FlexWrap("LINEAR_WRAP", 3, 3);
            LINEAR_WRAP = r103;
            $VALUES = new FlexWrap[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(FlexWrap.class);
        }

        public static FlexWrap[] values() {
            return (FlexWrap[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static FlexWrap fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return LINEAR_WRAP;
        L14:
            return WRAP_REVERSE;
        L16:
            return WRAP;
        L18:
            return NO_WRAP;
        }

        public static FlexWrap valueOf(String r100) {
            return (FlexWrap) a.a(FlexWrap.class, r100);
        }

        private FlexWrap(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum Justify extends Enum<Justify> implements WireEnum {
        private static final /* synthetic */ Justify[] $VALUES = null;
        public static final ProtoAdapter<Justify> ADAPTER = null;
        public static final Justify CENTER = null;
        public static final Justify END = null;
        public static final Justify SPACE_AROUND = null;
        public static final Justify SPACE_BETWEEN = null;
        public static final Justify SPACE_EVENLY = null;
        public static final Justify START = null;
        private final int value;

        static {
            Justify r100 = new Justify(GXAnimation.STATE_START, 0, 0);
            START = r100;
            Justify r101 = new Justify("CENTER", 1, 1);
            CENTER = r101;
            Justify r102 = new Justify(GXAnimation.STATE_END, 2, 2);
            END = r102;
            Justify r103 = new Justify("SPACE_BETWEEN", 3, 3);
            SPACE_BETWEEN = r103;
            Justify r104 = new Justify("SPACE_AROUND", 4, 4);
            SPACE_AROUND = r104;
            Justify r105 = new Justify("SPACE_EVENLY", 5, 5);
            SPACE_EVENLY = r105;
            $VALUES = new Justify[]{r100, r101, r102, r103, r104, r105};
            ADAPTER = ProtoAdapter.newEnumAdapter(Justify.class);
        }

        public static Justify[] values() {
            return (Justify[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Justify fromValue(int r100) {
            if (r100 == 0) goto L26;
            if (r100 == 1) goto L24;
            if (r100 == 2) goto L22;
            if (r100 == 3) goto L20;
            if (r100 == 4) goto L18;
            if (r100 == 5) goto L16;
            return null;
        L16:
            return SPACE_EVENLY;
        L18:
            return SPACE_AROUND;
        L20:
            return SPACE_BETWEEN;
        L22:
            return END;
        L24:
            return CENTER;
        L26:
            return START;
        }

        public static Justify valueOf(String r100) {
            return (Justify) a.a(Justify.class, r100);
        }

        private Justify(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum Orientation extends Enum<Orientation> implements WireEnum {
        private static final /* synthetic */ Orientation[] $VALUES = null;
        public static final ProtoAdapter<Orientation> ADAPTER = null;
        public static final Orientation COLUMN = null;
        public static final Orientation COLUMN_REVERSE = null;
        public static final Orientation ROW = null;
        public static final Orientation ROW_REVERSE = null;
        private final int value;

        static {
            Orientation r100 = new Orientation(FabItem.FabSheetItem.CellType.ROW, 0, 0);
            ROW = r100;
            Orientation r101 = new Orientation("COLUMN", 1, 1);
            COLUMN = r101;
            Orientation r102 = new Orientation("ROW_REVERSE", 2, 2);
            ROW_REVERSE = r102;
            Orientation r103 = new Orientation("COLUMN_REVERSE", 3, 3);
            COLUMN_REVERSE = r103;
            $VALUES = new Orientation[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(Orientation.class);
        }

        public static Orientation[] values() {
            return (Orientation[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Orientation fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return COLUMN_REVERSE;
        L14:
            return ROW_REVERSE;
        L16:
            return COLUMN;
        L18:
            return ROW;
        }

        public static Orientation valueOf(String r100) {
            return (Orientation) a.a(Orientation.class, r100);
        }

        private Orientation(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Padding extends com.squareup.wire.Message<Padding, Builder> {
        public static final ProtoAdapter<Padding> ADAPTER = null;
        public static final Float DEFAULT_BOTTOM = null;
        public static final Float DEFAULT_LEFT = null;
        public static final Float DEFAULT_RIGHT = null;
        public static final Float DEFAULT_TOP = null;
        private static final long serialVersionUID = 0;
        public final Float bottom;
        public final Float left;
        public final Float right;
        public final Float top;

        public static final class Builder extends com.squareup.wire.Message.Builder<Padding, Builder> {
            public Float bottom;
            public Float left;
            public Float right;
            public Float top;

            @Override // com.squareup.wire.Message.Builder
            public Padding build() {
                return new Padding(this.top, this.right, this.bottom, this.left, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder bottom(Float r100) {
                this.bottom = r100;
                return this;
            }

            public Builder left(Float r100) {
                this.left = r100;
                return this;
            }

            public Builder right(Float r100) {
                this.right = r100;
                return this;
            }

            public Builder top(Float r100) {
                this.top = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Padding extends ProtoAdapter<Padding> {
            public ProtoAdapter_Padding() {
                super(FieldEncoding.LENGTH_DELIMITED, Padding.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Padding decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                Float r102 = Float.valueOf(0.0f);
                r101.top = r102;
                r101.right = r102;
                r101.bottom = r102;
                r101.left = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L18;
                if (r104 != 1) goto L8;
                r101.top = ProtoAdapter.FLOAT.decode(r100);
                goto L3
            L8:
                if (r104 != 2) goto L10;
                r101.right = ProtoAdapter.FLOAT.decode(r100);
                goto L3
            L10:
                if (r104 != 3) goto L12;
                r101.bottom = ProtoAdapter.FLOAT.decode(r100);
                goto L3
            L12:
                if (r104 != 4) goto L13;
                r101.left = ProtoAdapter.FLOAT.decode(r100);
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
            public int encodedSize2(Padding r100) {
                Float r101 = r100.top;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.FLOAT.encodedSizeWithTag(1, r101);
            L6:
                Float r104 = r100.right;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.FLOAT.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Float r107 = r100.bottom;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.FLOAT.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                Float r110 = r100.left;
                if (r110 == null) goto L18;
                r102 = ProtoAdapter.FLOAT.encodedSizeWithTag(4, r110);
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
            public /* bridge */ /* synthetic */ Padding decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Padding r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Padding r101) throws IOException {
                Float r102 = r101.top;
                if (r102 == null) goto L5;
                ProtoAdapter.FLOAT.encodeWithTag(r100, 1, r102);
            L5:
                Float r103 = r101.right;
                if (r103 == null) goto L8;
                ProtoAdapter.FLOAT.encodeWithTag(r100, 2, r103);
            L8:
                Float r104 = r101.bottom;
                if (r104 == null) goto L11;
                ProtoAdapter.FLOAT.encodeWithTag(r100, 3, r104);
            L11:
                Float r105 = r101.left;
                if (r105 == null) goto L14;
                ProtoAdapter.FLOAT.encodeWithTag(r100, 4, r105);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Padding r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Padding();
            Float r100 = Float.valueOf(0.0f);
            DEFAULT_TOP = r100;
            DEFAULT_RIGHT = r100;
            DEFAULT_BOTTOM = r100;
            DEFAULT_LEFT = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.top = this.top;
            r100.right = this.right;
            r100.bottom = this.bottom;
            r100.left = this.left;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Padding.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public Padding(Float r100, Float r101, Float r102, Float r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public Padding(Float r100, Float r101, Float r102, Float r103, ByteString r104) {
            super(ADAPTER, r104);
            this.top = r100;
            this.right = r101;
            this.bottom = r102;
            this.left = r103;
        }
    }

    public static final class ProtoAdapter_CardComponent extends ProtoAdapter<CardComponent> {
        public ProtoAdapter_CardComponent() {
            super(FieldEncoding.LENGTH_DELIMITED, CardComponent.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CardComponent decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.type = Type.FLEX_LAYOUT;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.child_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.style = Style.ADAPTER.decode(r100);
            goto L3
        L12:
            if (r103 != 1000) goto L14;
            r101.engine(EngineProperty.ADAPTER.decode(r100));
            goto L3
        L14:
            if (r103 != 1001) goto L15;
            r101.flex_layout(FlexLayoutProperty.ADAPTER.decode(r100));
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
        public int encodedSize2(CardComponent r100) {
            int r101 = Type.ADAPTER.encodedSizeWithTag(1, r100.type) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, r100.child_ids);
            Style r102 = r100.style;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = Style.ADAPTER.encodedSizeWithTag(3, r102);
        L6:
            int r105 = r101 + r104;
            EngineProperty r106 = r100.engine;
            if (r106 == null) goto L9;
            int r107 = EngineProperty.ADAPTER.encodedSizeWithTag(1000, r106);
        L10:
            int r108 = r105 + r107;
            FlexLayoutProperty r109 = r100.flex_layout;
            if (r109 == null) goto L14;
            r103 = FlexLayoutProperty.ADAPTER.encodedSizeWithTag(1001, r109);
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
        public /* bridge */ /* synthetic */ CardComponent decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CardComponent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CardComponent r101) throws IOException {
            Type.ADAPTER.encodeWithTag(r100, 1, r101.type);
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 2, r101.child_ids);
            Style r102 = r101.style;
            if (r102 == null) goto L5;
            Style.ADAPTER.encodeWithTag(r100, 3, r102);
        L5:
            EngineProperty r103 = r101.engine;
            if (r103 == null) goto L8;
            EngineProperty.ADAPTER.encodeWithTag(r100, 1000, r103);
        L8:
            FlexLayoutProperty r104 = r101.flex_layout;
            if (r104 == null) goto L11;
            FlexLayoutProperty.ADAPTER.encodeWithTag(r100, 1001, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CardComponent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class Style extends com.squareup.wire.Message<Style, Builder> {
        public static final ProtoAdapter<Style> ADAPTER = null;
        public static final Align DEFAULT_ALIGN_SELF = null;
        public static final Integer DEFAULT_GROW_WEIGHT = null;
        public static final Integer DEFAULT_SHRINK_WEIGHT = null;
        private static final long serialVersionUID = 0;
        public final Align align_self;
        public final Integer grow_weight;
        public final Value height;
        public final Value max_height;
        public final Value max_width;
        public final Value min_height;
        public final Value min_width;
        public final Integer shrink_weight;
        public final Value width;

        public static final class Builder extends com.squareup.wire.Message.Builder<Style, Builder> {
            public Align align_self;
            public Integer grow_weight;
            public Value height;
            public Value max_height;
            public Value max_width;
            public Value min_height;
            public Value min_width;
            public Integer shrink_weight;
            public Value width;

            @Override // com.squareup.wire.Message.Builder
            public Style build() {
                return new Style(this.width, this.height, this.max_width, this.max_height, this.min_width, this.min_height, this.grow_weight, this.shrink_weight, this.align_self, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder align_self(Align r100) {
                this.align_self = r100;
                return this;
            }

            public Builder grow_weight(Integer r100) {
                this.grow_weight = r100;
                return this;
            }

            public Builder height(Value r100) {
                this.height = r100;
                return this;
            }

            public Builder max_height(Value r100) {
                this.max_height = r100;
                return this;
            }

            public Builder max_width(Value r100) {
                this.max_width = r100;
                return this;
            }

            public Builder min_height(Value r100) {
                this.min_height = r100;
                return this;
            }

            public Builder min_width(Value r100) {
                this.min_width = r100;
                return this;
            }

            public Builder shrink_weight(Integer r100) {
                this.shrink_weight = r100;
                return this;
            }

            public Builder width(Value r100) {
                this.width = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Style extends ProtoAdapter<Style> {
            public ProtoAdapter_Style() {
                super(FieldEncoding.LENGTH_DELIMITED, Style.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Style decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.grow_weight = 0;
                r101.shrink_weight = 0;
                r101.align_self = Align.TOP;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L19;
                switch(r103) {
                    case 1: goto L18;
                    case 2: goto L17;
                    case 3: goto L16;
                    case 4: goto L15;
                    case 5: goto L14;
                    case 6: goto L13;
                    case 7: goto L12;
                    case 8: goto L11;
                    case 9: goto L21;
                    default: goto L6;
                };
            L21:
                r101.align_self = Align.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
            L9:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L11:
                r101.shrink_weight = ProtoAdapter.INT32.decode(r100);
                goto L3
            L12:
                r101.grow_weight = ProtoAdapter.INT32.decode(r100);
                goto L3
            L13:
                r101.min_height = Value.ADAPTER.decode(r100);
                goto L3
            L14:
                r101.min_width = Value.ADAPTER.decode(r100);
                goto L3
            L15:
                r101.max_height = Value.ADAPTER.decode(r100);
                goto L3
            L16:
                r101.max_width = Value.ADAPTER.decode(r100);
                goto L3
            L17:
                r101.height = Value.ADAPTER.decode(r100);
                goto L3
            L18:
                r101.width = Value.ADAPTER.decode(r100);
                goto L3
            L6:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L19:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(Style r100) {
                Value r101 = r100.width;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = Value.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                Value r104 = r100.height;
                if (r104 == null) goto L9;
                int r105 = Value.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Value r107 = r100.max_width;
                if (r107 == null) goto L13;
                int r108 = Value.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                Value r110 = r100.max_height;
                if (r110 == null) goto L17;
                int r111 = Value.ADAPTER.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                Value r113 = r100.min_width;
                if (r113 == null) goto L21;
                int r114 = Value.ADAPTER.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                Value r116 = r100.min_height;
                if (r116 == null) goto L25;
                int r117 = Value.ADAPTER.encodedSizeWithTag(6, r116);
            L26:
                int r118 = r115 + r117;
                Integer r119 = r100.grow_weight;
                if (r119 == null) goto L29;
                int r120 = ProtoAdapter.INT32.encodedSizeWithTag(7, r119);
            L30:
                int r121 = r118 + r120;
                Integer r122 = r100.shrink_weight;
                if (r122 == null) goto L33;
                int r123 = ProtoAdapter.INT32.encodedSizeWithTag(8, r122);
            L34:
                int r124 = r121 + r123;
                Align r125 = r100.align_self;
                if (r125 == null) goto L38;
                r102 = Align.ADAPTER.encodedSizeWithTag(9, r125);
            L38:
                return (r124 + r102) + r100.unknownFields().size();
            L33:
                r123 = 0;
                goto L34
            L29:
                r120 = 0;
                goto L30
            L25:
                r117 = 0;
                goto L26
            L21:
                r114 = 0;
                goto L22
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
            public /* bridge */ /* synthetic */ Style decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Style r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Style r101) throws IOException {
                Value r102 = r101.width;
                if (r102 == null) goto L5;
                Value.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                Value r103 = r101.height;
                if (r103 == null) goto L8;
                Value.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                Value r104 = r101.max_width;
                if (r104 == null) goto L11;
                Value.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                Value r105 = r101.max_height;
                if (r105 == null) goto L14;
                Value.ADAPTER.encodeWithTag(r100, 4, r105);
            L14:
                Value r106 = r101.min_width;
                if (r106 == null) goto L17;
                Value.ADAPTER.encodeWithTag(r100, 5, r106);
            L17:
                Value r107 = r101.min_height;
                if (r107 == null) goto L20;
                Value.ADAPTER.encodeWithTag(r100, 6, r107);
            L20:
                Integer r108 = r101.grow_weight;
                if (r108 == null) goto L23;
                ProtoAdapter.INT32.encodeWithTag(r100, 7, r108);
            L23:
                Integer r109 = r101.shrink_weight;
                if (r109 == null) goto L26;
                ProtoAdapter.INT32.encodeWithTag(r100, 8, r109);
            L26:
                Align r110 = r101.align_self;
                if (r110 == null) goto L29;
                Align.ADAPTER.encodeWithTag(r100, 9, r110);
            L29:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Style r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Style();
            DEFAULT_GROW_WEIGHT = 0;
            DEFAULT_SHRINK_WEIGHT = 0;
            DEFAULT_ALIGN_SELF = Align.TOP;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.width = this.width;
            r100.height = this.height;
            r100.max_width = this.max_width;
            r100.max_height = this.max_height;
            r100.min_width = this.min_width;
            r100.min_height = this.min_height;
            r100.grow_weight = this.grow_weight;
            r100.shrink_weight = this.shrink_weight;
            r100.align_self = this.align_self;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Style.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public Style(Value r110, Value r111, Value r112, Value r113, Value r114, Value r115, Integer r116, Integer r117, Align r210) {
            this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
        }

        public Style(Value r100, Value r101, Value r102, Value r103, Value r104, Value r105, Integer r106, Integer r107, Align r110, ByteString r111) {
            super(ADAPTER, r111);
            this.width = r100;
            this.height = r101;
            this.max_width = r102;
            this.max_height = r103;
            this.min_width = r104;
            this.min_height = r105;
            this.grow_weight = r106;
            this.shrink_weight = r107;
            this.align_self = r110;
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type ENGINE = null;
        public static final Type FLEX_LAYOUT = null;
        private final int value;

        static {
            Type r100 = new Type("FLEX_LAYOUT", 0, 0);
            FLEX_LAYOUT = r100;
            Type r101 = new Type("ENGINE", 1, 1);
            ENGINE = r101;
            $VALUES = new Type[]{r100, r101};
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
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return ENGINE;
        L10:
            return FLEX_LAYOUT;
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        private Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Value extends com.squareup.wire.Message<Value, Builder> {
        public static final ProtoAdapter<Value> ADAPTER = null;
        public static final ValueType DEFAULT_TYPE = null;
        public static final Float DEFAULT_VALUE = null;
        private static final long serialVersionUID = 0;
        public final ValueType type;
        public final Float value;

        public static final class Builder extends com.squareup.wire.Message.Builder<Value, Builder> {
            public ValueType type;
            public Float value;

            @Override // com.squareup.wire.Message.Builder
            public Value build() {
                return new Value(this.type, this.value, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder type(ValueType r100) {
                this.type = r100;
                return this;
            }

            public Builder value(Float r100) {
                this.value = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Value extends ProtoAdapter<Value> {
            public ProtoAdapter_Value() {
                super(FieldEncoding.LENGTH_DELIMITED, Value.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Value decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.type = ValueType.AUTO;
                r101.value = Float.valueOf(0.0f);
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.type = ValueType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.value = ProtoAdapter.FLOAT.decode(r100);
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
            public int encodedSize2(Value r100) {
                ValueType r101 = r100.type;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ValueType.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                Float r104 = r100.value;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.FLOAT.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Value decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Value r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Value r101) throws IOException {
                ValueType r102 = r101.type;
                if (r102 == null) goto L5;
                ValueType.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                Float r103 = r101.value;
                if (r103 == null) goto L8;
                ProtoAdapter.FLOAT.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Value r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Value();
            DEFAULT_TYPE = ValueType.AUTO;
            DEFAULT_VALUE = Float.valueOf(0.0f);
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.type = this.type;
            r100.value = this.value;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Value.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public Value(ValueType r100, Float r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public Value(ValueType r100, Float r101, ByteString r102) {
            super(ADAPTER, r102);
            this.type = r100;
            this.value = r101;
        }
    }

    public static final enum ValueType extends Enum<ValueType> implements WireEnum {
        private static final /* synthetic */ ValueType[] $VALUES = null;
        public static final ProtoAdapter<ValueType> ADAPTER = null;
        public static final ValueType AUTO = null;
        public static final ValueType PERCENTAGE = null;
        public static final ValueType POINT = null;
        private final int value;

        static {
            ValueType r100 = new ValueType("AUTO", 0, 0);
            AUTO = r100;
            ValueType r101 = new ValueType("POINT", 1, 1);
            POINT = r101;
            ValueType r102 = new ValueType("PERCENTAGE", 2, 2);
            PERCENTAGE = r102;
            $VALUES = new ValueType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(ValueType.class);
        }

        public static ValueType[] values() {
            return (ValueType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ValueType fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return PERCENTAGE;
        L12:
            return POINT;
        L14:
            return AUTO;
        }

        public static ValueType valueOf(String r100) {
            return (ValueType) a.a(ValueType.class, r100);
        }

        private ValueType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CardComponent();
        DEFAULT_TYPE = Type.FLEX_LAYOUT;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.type = this.type;
        r100.child_ids = Internal.copyOf("child_ids", this.child_ids);
        r100.style = this.style;
        r100.engine = this.engine;
        r100.flex_layout = this.flex_layout;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CardComponent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public CardComponent(Type r100, List<String> r101, Style r110, EngineProperty r111, FlexLayoutProperty r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public CardComponent(Type r100, List<String> r101, Style r102, EngineProperty r103, FlexLayoutProperty r104, ByteString r105) {
        super(ADAPTER, r105);
        if (Internal.countNonNull(r103, r104) > 1) goto L7;
        this.type = r100;
        this.child_ids = Internal.immutableCopyOf("child_ids", r101);
        this.style = r102;
        this.engine = r103;
        this.flex_layout = r104;
        return;
    L7:
        throw new IllegalArgumentException("at most one of engine, flex_layout may be non-null");
    }
}
