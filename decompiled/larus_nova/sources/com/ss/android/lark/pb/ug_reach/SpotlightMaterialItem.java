package com.ss.android.lark.pb.ug_reach;

import androidx.camera.video.AudioStats;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
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
public final class SpotlightMaterialItem extends Message<SpotlightMaterialItem, Builder> {
    public static final ProtoAdapter<SpotlightMaterialItem> ADAPTER = null;
    public static final String DEFAULT_STEP_NAME = "";
    private static final long serialVersionUID = 0;
    public final ContainerConfiguration mcontainer_config;
    public final SpotlightContent mcontent;
    public final String mstep_name;
    public final TargetAnchor mtarget_anchor_config;

    public static final enum ArrowDirection extends Enum<ArrowDirection> implements WireEnum {
        private static final /* synthetic */ ArrowDirection[] $VALUES = null;
        public static final ProtoAdapter<ArrowDirection> ADAPTER = null;
        public static final ArrowDirection DOWN = null;
        public static final ArrowDirection LEFT = null;
        public static final ArrowDirection RIGHT = null;
        public static final ArrowDirection UNKNOWN = null;
        public static final ArrowDirection UP = null;
        private final int value;

        static {
            ArrowDirection r100 = new ArrowDirection("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            ArrowDirection r101 = new ArrowDirection("LEFT", 1, 1);
            LEFT = r101;
            ArrowDirection r102 = new ArrowDirection("UP", 2, 2);
            UP = r102;
            ArrowDirection r103 = new ArrowDirection("RIGHT", 3, 3);
            RIGHT = r103;
            ArrowDirection r104 = new ArrowDirection("DOWN", 4, 4);
            DOWN = r104;
            $VALUES = new ArrowDirection[]{r100, r101, r102, r103, r104};
            ADAPTER = ProtoAdapter.newEnumAdapter(ArrowDirection.class);
        }

        public static ArrowDirection[] values() {
            return (ArrowDirection[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ArrowDirection fromValue(int r100) {
            if (r100 == 0) goto L22;
            if (r100 == 1) goto L20;
            if (r100 == 2) goto L18;
            if (r100 == 3) goto L16;
            if (r100 == 4) goto L14;
            return null;
        L14:
            return DOWN;
        L16:
            return RIGHT;
        L18:
            return UP;
        L20:
            return LEFT;
        L22:
            return UNKNOWN;
        }

        public static ArrowDirection valueOf(String r100) {
            return (ArrowDirection) a.a(ArrowDirection.class, r100);
        }

        private ArrowDirection(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Builder extends Message.Builder<SpotlightMaterialItem, Builder> {
        public ContainerConfiguration mcontainer_config;
        public SpotlightContent mcontent;
        public String mstep_name;
        public TargetAnchor mtarget_anchor_config;

        @Override // com.squareup.wire.Message.Builder
        public SpotlightMaterialItem build() {
            return new SpotlightMaterialItem(this.mstep_name, this.mcontent, this.mcontainer_config, this.mtarget_anchor_config, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder container_config(ContainerConfiguration r100) {
            this.mcontainer_config = r100;
            return this;
        }

        public Builder content(SpotlightContent r100) {
            this.mcontent = r100;
            return this;
        }

        public Builder step_name(String r100) {
            this.mstep_name = r100;
            return this;
        }

        public Builder target_anchor_config(TargetAnchor r100) {
            this.mtarget_anchor_config = r100;
            return this;
        }
    }

    public static final class ContainerConfiguration extends Message<ContainerConfiguration, Builder> {
        public static final ProtoAdapter<ContainerConfiguration> ADAPTER = null;
        public static final String DEFAULT_BACKGROUND_COLOR = "";
        public static final String DEFAULT_SHADOW_COLOR = "";
        private static final long serialVersionUID = 0;
        public final String mbackground_color;
        public final String mshadow_color;
        public final ContainerStyle mstyle;

        public static final class Builder extends Message.Builder<ContainerConfiguration, Builder> {
            public String mbackground_color;
            public String mshadow_color;
            public ContainerStyle mstyle;

            @Override // com.squareup.wire.Message.Builder
            public ContainerConfiguration build() {
                return new ContainerConfiguration(this.mbackground_color, this.mshadow_color, this.mstyle, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder background_color(String r100) {
                this.mbackground_color = r100;
                return this;
            }

            public Builder shadow_color(String r100) {
                this.mshadow_color = r100;
                return this;
            }

            public Builder style(ContainerStyle r100) {
                this.mstyle = r100;
                return this;
            }
        }

        public static final enum ContainerStyle extends Enum<ContainerStyle> implements WireEnum {
            private static final /* synthetic */ ContainerStyle[] $VALUES = null;
            public static final ProtoAdapter<ContainerStyle> ADAPTER = null;
            public static final ContainerStyle FILL = null;
            public static final ContainerStyle STROKE = null;
            public static final ContainerStyle UNKNOWN = null;
            private final int value;

            static {
                ContainerStyle r100 = new ContainerStyle("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                ContainerStyle r101 = new ContainerStyle("FILL", 1, 1);
                FILL = r101;
                ContainerStyle r102 = new ContainerStyle("STROKE", 2, 2);
                STROKE = r102;
                $VALUES = new ContainerStyle[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(ContainerStyle.class);
            }

            public static ContainerStyle[] values() {
                return (ContainerStyle[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static ContainerStyle fromValue(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return STROKE;
            L12:
                return FILL;
            L14:
                return UNKNOWN;
            }

            public static ContainerStyle valueOf(String r100) {
                return (ContainerStyle) a.a(ContainerStyle.class, r100);
            }

            private ContainerStyle(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_ContainerConfiguration extends ProtoAdapter<ContainerConfiguration> {
            public ProtoAdapter_ContainerConfiguration() {
                super(FieldEncoding.LENGTH_DELIMITED, ContainerConfiguration.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ContainerConfiguration decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mbackground_color = "";
                r101.mshadow_color = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.mbackground_color = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.mshadow_color = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.mstyle = ContainerStyle.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
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
            public int encodedSize2(ContainerConfiguration r100) {
                String r101 = r100.mbackground_color;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.mshadow_color;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                ContainerStyle r107 = r100.mstyle;
                if (r107 == null) goto L14;
                r102 = ContainerStyle.ADAPTER.encodedSizeWithTag(3, r107);
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
            public /* bridge */ /* synthetic */ ContainerConfiguration decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ContainerConfiguration r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ContainerConfiguration r101) throws IOException {
                String r102 = r101.mbackground_color;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.mshadow_color;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                ContainerStyle r104 = r101.mstyle;
                if (r104 == null) goto L11;
                ContainerStyle.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ContainerConfiguration r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ContainerConfiguration();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mbackground_color = this.mbackground_color;
            r100.mshadow_color = this.mshadow_color;
            r100.mstyle = this.mstyle;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ContainerConfiguration.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ContainerConfiguration(String r100, String r101, ContainerStyle r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public ContainerConfiguration(String r100, String r101, ContainerStyle r102, ByteString r103) {
            super(ADAPTER, r103);
            this.mbackground_color = r100;
            this.mshadow_color = r101;
            this.mstyle = r102;
        }
    }

    public static final class ProtoAdapter_SpotlightMaterialItem extends ProtoAdapter<SpotlightMaterialItem> {
        public ProtoAdapter_SpotlightMaterialItem() {
            super(FieldEncoding.LENGTH_DELIMITED, SpotlightMaterialItem.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SpotlightMaterialItem decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mstep_name = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mstep_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mcontent = SpotlightContent.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mcontainer_config = ContainerConfiguration.ADAPTER.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.mtarget_anchor_config = TargetAnchor.ADAPTER.decode(r100);
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
        public int encodedSize2(SpotlightMaterialItem r100) {
            String r101 = r100.mstep_name;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            SpotlightContent r104 = r100.mcontent;
            if (r104 == null) goto L9;
            int r105 = SpotlightContent.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            ContainerConfiguration r107 = r100.mcontainer_config;
            if (r107 == null) goto L13;
            int r108 = ContainerConfiguration.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            TargetAnchor r110 = r100.mtarget_anchor_config;
            if (r110 == null) goto L18;
            r102 = TargetAnchor.ADAPTER.encodedSizeWithTag(4, r110);
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
        public /* bridge */ /* synthetic */ SpotlightMaterialItem decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SpotlightMaterialItem r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SpotlightMaterialItem r101) throws IOException {
            String r102 = r101.mstep_name;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            SpotlightContent r103 = r101.mcontent;
            if (r103 == null) goto L8;
            SpotlightContent.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            ContainerConfiguration r104 = r101.mcontainer_config;
            if (r104 == null) goto L11;
            ContainerConfiguration.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            TargetAnchor r105 = r101.mtarget_anchor_config;
            if (r105 == null) goto L14;
            TargetAnchor.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SpotlightMaterialItem r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class SpotlightContent extends Message<SpotlightContent, Builder> {
        public static final ProtoAdapter<SpotlightContent> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<ButtonElement> mbuttons;
        public final TextElement mdescription;
        public final ImageElement mimage;
        public final TextElement mtitle;

        public static final class Builder extends Message.Builder<SpotlightContent, Builder> {
            public List<ButtonElement> mbuttons;
            public TextElement mdescription;
            public ImageElement mimage;
            public TextElement mtitle;

            @Override // com.squareup.wire.Message.Builder
            public SpotlightContent build() {
                return new SpotlightContent(this.mtitle, this.mdescription, this.mimage, this.mbuttons, super.buildUnknownFields());
            }

            public Builder() {
                this.mbuttons = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder buttons(List<ButtonElement> r100) {
                Internal.checkElementsNotNull(r100);
                this.mbuttons = r100;
                return this;
            }

            public Builder description(TextElement r100) {
                this.mdescription = r100;
                return this;
            }

            public Builder image(ImageElement r100) {
                this.mimage = r100;
                return this;
            }

            public Builder title(TextElement r100) {
                this.mtitle = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_SpotlightContent extends ProtoAdapter<SpotlightContent> {
            public ProtoAdapter_SpotlightContent() {
                super(FieldEncoding.LENGTH_DELIMITED, SpotlightContent.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SpotlightContent decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.mtitle = TextElement.ADAPTER.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.mdescription = TextElement.ADAPTER.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.mimage = ImageElement.ADAPTER.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.mbuttons.add(ButtonElement.ADAPTER.decode(r100));
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
            public int encodedSize2(SpotlightContent r100) {
                TextElement r101 = r100.mtitle;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = TextElement.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                TextElement r104 = r100.mdescription;
                if (r104 == null) goto L9;
                int r105 = TextElement.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                ImageElement r107 = r100.mimage;
                if (r107 == null) goto L14;
                r102 = ImageElement.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                return ((r106 + r102) + ButtonElement.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.mbuttons)) + r100.unknownFields().size();
            L9:
                r105 = 0;
                goto L10
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ SpotlightContent decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(SpotlightContent r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, SpotlightContent r101) throws IOException {
                TextElement r102 = r101.mtitle;
                if (r102 == null) goto L5;
                TextElement.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                TextElement r103 = r101.mdescription;
                if (r103 == null) goto L8;
                TextElement.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                ImageElement r104 = r101.mimage;
                if (r104 == null) goto L11;
                ImageElement.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                ButtonElement.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.mbuttons);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SpotlightContent r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SpotlightContent();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mtitle = this.mtitle;
            r100.mdescription = this.mdescription;
            r100.mimage = this.mimage;
            r100.mbuttons = Internal.copyOf("mbuttons", this.mbuttons);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return SpotlightContent.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public SpotlightContent(TextElement r100, TextElement r101, ImageElement r102, List<ButtonElement> r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public SpotlightContent(TextElement r100, TextElement r101, ImageElement r102, List<ButtonElement> r103, ByteString r104) {
            super(ADAPTER, r104);
            this.mtitle = r100;
            this.mdescription = r101;
            this.mimage = r102;
            this.mbuttons = Internal.immutableCopyOf("mbuttons", r103);
        }
    }

    public static final class TargetAnchor extends Message<TargetAnchor, Builder> {
        public static final ProtoAdapter<TargetAnchor> ADAPTER = null;
        public static final Double DEFAULT_OFFSET = null;
        private static final long serialVersionUID = 0;
        public final ArrowDirection marrow_direction;
        public final Double moffset;
        public final TargetRectType mtarget_rect_type;

        public static final class Builder extends Message.Builder<TargetAnchor, Builder> {
            public ArrowDirection marrow_direction;
            public Double moffset;
            public TargetRectType mtarget_rect_type;

            @Override // com.squareup.wire.Message.Builder
            public TargetAnchor build() {
                return new TargetAnchor(this.moffset, this.marrow_direction, this.mtarget_rect_type, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder arrow_direction(ArrowDirection r100) {
                this.marrow_direction = r100;
                return this;
            }

            public Builder offset(Double r100) {
                this.moffset = r100;
                return this;
            }

            public Builder target_rect_type(TargetRectType r100) {
                this.mtarget_rect_type = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_TargetAnchor extends ProtoAdapter<TargetAnchor> {
            public ProtoAdapter_TargetAnchor() {
                super(FieldEncoding.LENGTH_DELIMITED, TargetAnchor.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TargetAnchor decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.moffset = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                if (r103 != 1) goto L8;
                r101.moffset = ProtoAdapter.DOUBLE.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.marrow_direction = ArrowDirection.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
            L18:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.mtarget_rect_type = TargetRectType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L11:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L21:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(TargetAnchor r100) {
                Double r101 = r100.moffset;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.DOUBLE.encodedSizeWithTag(1, r101);
            L6:
                ArrowDirection r104 = r100.marrow_direction;
                if (r104 == null) goto L9;
                int r105 = ArrowDirection.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                TargetRectType r107 = r100.mtarget_rect_type;
                if (r107 == null) goto L14;
                r102 = TargetRectType.ADAPTER.encodedSizeWithTag(3, r107);
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
            public /* bridge */ /* synthetic */ TargetAnchor decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TargetAnchor r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TargetAnchor r101) throws IOException {
                Double r102 = r101.moffset;
                if (r102 == null) goto L5;
                ProtoAdapter.DOUBLE.encodeWithTag(r100, 1, r102);
            L5:
                ArrowDirection r103 = r101.marrow_direction;
                if (r103 == null) goto L8;
                ArrowDirection.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                TargetRectType r104 = r101.mtarget_rect_type;
                if (r104 == null) goto L11;
                TargetRectType.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TargetAnchor r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum TargetRectType extends Enum<TargetRectType> implements WireEnum {
            private static final /* synthetic */ TargetRectType[] $VALUES = null;
            public static final ProtoAdapter<TargetRectType> ADAPTER = null;
            public static final TargetRectType CIRCLE = null;
            public static final TargetRectType RECTANGLE = null;
            public static final TargetRectType UNKNOWN = null;
            private final int value;

            static {
                TargetRectType r100 = new TargetRectType("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                TargetRectType r101 = new TargetRectType("RECTANGLE", 1, 1);
                RECTANGLE = r101;
                TargetRectType r102 = new TargetRectType("CIRCLE", 2, 2);
                CIRCLE = r102;
                $VALUES = new TargetRectType[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(TargetRectType.class);
            }

            public static TargetRectType[] values() {
                return (TargetRectType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static TargetRectType fromValue(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return CIRCLE;
            L12:
                return RECTANGLE;
            L14:
                return UNKNOWN;
            }

            public static TargetRectType valueOf(String r100) {
                return (TargetRectType) a.a(TargetRectType.class, r100);
            }

            private TargetRectType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TargetAnchor();
            DEFAULT_OFFSET = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.moffset = this.moffset;
            r100.marrow_direction = this.marrow_direction;
            r100.mtarget_rect_type = this.mtarget_rect_type;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TargetAnchor.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public TargetAnchor(Double r100, ArrowDirection r101, TargetRectType r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public TargetAnchor(Double r100, ArrowDirection r101, TargetRectType r102, ByteString r103) {
            super(ADAPTER, r103);
            this.moffset = r100;
            this.marrow_direction = r101;
            this.mtarget_rect_type = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SpotlightMaterialItem();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mstep_name = this.mstep_name;
        r100.mcontent = this.mcontent;
        r100.mcontainer_config = this.mcontainer_config;
        r100.mtarget_anchor_config = this.mtarget_anchor_config;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SpotlightMaterialItem.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SpotlightMaterialItem(String r100, SpotlightContent r101, ContainerConfiguration r102, TargetAnchor r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public SpotlightMaterialItem(String r100, SpotlightContent r101, ContainerConfiguration r102, TargetAnchor r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mstep_name = r100;
        this.mcontent = r101;
        this.mcontainer_config = r102;
        this.mtarget_anchor_config = r103;
    }
}
