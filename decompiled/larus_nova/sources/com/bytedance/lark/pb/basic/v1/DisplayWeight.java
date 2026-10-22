package com.bytedance.lark.pb.basic.v1;

import androidx.camera.video.AudioStats;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.banner.export.entity.BannerBizName;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class DisplayWeight extends com.squareup.wire.Message<DisplayWeight, Builder> {
    public static final ProtoAdapter<DisplayWeight> ADAPTER = null;
    public static final Double DEFAULT_PADDING_WEIGHT = null;
    public static final Type DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;
    public final DynamicConfig dynamic_config;
    public final Double padding_weight;
    public final StaticConfig static_config;
    public final Type type;

    public static final class Builder extends com.squareup.wire.Message.Builder<DisplayWeight, Builder> {
        public DynamicConfig dynamic_config;
        public Double padding_weight;
        public StaticConfig static_config;
        public Type type;

        @Override // com.squareup.wire.Message.Builder
        public DisplayWeight build() {
            return new DisplayWeight(this.type, this.padding_weight, this.static_config, this.dynamic_config, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder dynamic_config(DynamicConfig r100) {
            this.dynamic_config = r100;
            this.static_config = null;
            return this;
        }

        public Builder padding_weight(Double r100) {
            this.padding_weight = r100;
            return this;
        }

        public Builder static_config(StaticConfig r100) {
            this.static_config = r100;
            this.dynamic_config = null;
            return this;
        }

        public Builder type(Type r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class DynamicConfig extends com.squareup.wire.Message<DynamicConfig, Builder> {
        public static final ProtoAdapter<DynamicConfig> ADAPTER = null;
        public static final Double DEFAULT_LINE_CHAR_COUNT = null;
        public static final Double DEFAULT_MAX_WEIGHT = null;
        public static final Double DEFAULT_SCALE = null;
        private static final long serialVersionUID = 0;
        public final Double line_char_count;
        public final Double max_weight;
        public final Double scale;

        public static final class Builder extends com.squareup.wire.Message.Builder<DynamicConfig, Builder> {
            public Double line_char_count;
            public Double max_weight;
            public Double scale;

            @Override // com.squareup.wire.Message.Builder
            public DynamicConfig build() {
                return new DynamicConfig(this.line_char_count, this.max_weight, this.scale, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder line_char_count(Double r100) {
                this.line_char_count = r100;
                return this;
            }

            public Builder max_weight(Double r100) {
                this.max_weight = r100;
                return this;
            }

            public Builder scale(Double r100) {
                this.scale = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_DynamicConfig extends ProtoAdapter<DynamicConfig> {
            public ProtoAdapter_DynamicConfig() {
                super(FieldEncoding.LENGTH_DELIMITED, DynamicConfig.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DynamicConfig decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                Double r102 = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
                r101.line_char_count = r102;
                r101.max_weight = r102;
                r101.scale = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L15;
                if (r104 != 1) goto L8;
                r101.line_char_count = ProtoAdapter.DOUBLE.decode(r100);
                goto L3
            L8:
                if (r104 != 2) goto L10;
                r101.max_weight = ProtoAdapter.DOUBLE.decode(r100);
                goto L3
            L10:
                if (r104 != 3) goto L11;
                r101.scale = ProtoAdapter.DOUBLE.decode(r100);
                goto L3
            L11:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L15:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(DynamicConfig r100) {
                Double r101 = r100.line_char_count;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.DOUBLE.encodedSizeWithTag(1, r101);
            L6:
                Double r104 = r100.max_weight;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.DOUBLE.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Double r107 = r100.scale;
                if (r107 == null) goto L14;
                r102 = ProtoAdapter.DOUBLE.encodedSizeWithTag(3, r107);
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
            public /* bridge */ /* synthetic */ DynamicConfig decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DynamicConfig r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DynamicConfig r101) throws IOException {
                Double r102 = r101.line_char_count;
                if (r102 == null) goto L5;
                ProtoAdapter.DOUBLE.encodeWithTag(r100, 1, r102);
            L5:
                Double r103 = r101.max_weight;
                if (r103 == null) goto L8;
                ProtoAdapter.DOUBLE.encodeWithTag(r100, 2, r103);
            L8:
                Double r104 = r101.scale;
                if (r104 == null) goto L11;
                ProtoAdapter.DOUBLE.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DynamicConfig r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DynamicConfig();
            Double r100 = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
            DEFAULT_LINE_CHAR_COUNT = r100;
            DEFAULT_MAX_WEIGHT = r100;
            DEFAULT_SCALE = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.line_char_count = this.line_char_count;
            r100.max_weight = this.max_weight;
            r100.scale = this.scale;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return DynamicConfig.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public DynamicConfig(Double r100, Double r101, Double r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public DynamicConfig(Double r100, Double r101, Double r102, ByteString r103) {
            super(ADAPTER, r103);
            this.line_char_count = r100;
            this.max_weight = r101;
            this.scale = r102;
        }
    }

    public static final class ProtoAdapter_DisplayWeight extends ProtoAdapter<DisplayWeight> {
        public ProtoAdapter_DisplayWeight() {
            super(FieldEncoding.LENGTH_DELIMITED, DisplayWeight.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DisplayWeight decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.type = Type.STATIC;
            r101.padding_weight = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.padding_weight = ProtoAdapter.DOUBLE.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.static_config(StaticConfig.ADAPTER.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.dynamic_config(DynamicConfig.ADAPTER.decode(r100));
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
        public int encodedSize2(DisplayWeight r100) {
            Type r101 = r100.type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = Type.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            Double r104 = r100.padding_weight;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.DOUBLE.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            StaticConfig r107 = r100.static_config;
            if (r107 == null) goto L13;
            int r108 = StaticConfig.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            DynamicConfig r110 = r100.dynamic_config;
            if (r110 == null) goto L18;
            r102 = DynamicConfig.ADAPTER.encodedSizeWithTag(4, r110);
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
        public /* bridge */ /* synthetic */ DisplayWeight decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DisplayWeight r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DisplayWeight r101) throws IOException {
            Type r102 = r101.type;
            if (r102 == null) goto L5;
            Type.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            Double r103 = r101.padding_weight;
            if (r103 == null) goto L8;
            ProtoAdapter.DOUBLE.encodeWithTag(r100, 2, r103);
        L8:
            StaticConfig r104 = r101.static_config;
            if (r104 == null) goto L11;
            StaticConfig.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            DynamicConfig r105 = r101.dynamic_config;
            if (r105 == null) goto L14;
            DynamicConfig.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DisplayWeight r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class StaticConfig extends com.squareup.wire.Message<StaticConfig, Builder> {
        public static final ProtoAdapter<StaticConfig> ADAPTER = null;
        public static final Double DEFAULT_WEIGHT = null;
        private static final long serialVersionUID = 0;
        public final Double weight;

        public static final class Builder extends com.squareup.wire.Message.Builder<StaticConfig, Builder> {
            public Double weight;

            @Override // com.squareup.wire.Message.Builder
            public StaticConfig build() {
                return new StaticConfig(this.weight, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder weight(Double r100) {
                this.weight = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_StaticConfig extends ProtoAdapter<StaticConfig> {
            public ProtoAdapter_StaticConfig() {
                super(FieldEncoding.LENGTH_DELIMITED, StaticConfig.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public StaticConfig decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.weight = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.weight = ProtoAdapter.DOUBLE.decode(r100);
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L9:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(StaticConfig r100) {
                Double r101 = r100.weight;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.DOUBLE.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ StaticConfig decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(StaticConfig r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, StaticConfig r101) throws IOException {
                Double r102 = r101.weight;
                if (r102 == null) goto L5;
                ProtoAdapter.DOUBLE.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, StaticConfig r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_StaticConfig();
            DEFAULT_WEIGHT = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.weight = this.weight;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return StaticConfig.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public StaticConfig(Double r100) {
            this(r100, ByteString.EMPTY);
        }

        public StaticConfig(Double r100, ByteString r101) {
            super(ADAPTER, r101);
            this.weight = r100;
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type DYNAMIC = null;
        public static final Type STATIC = null;
        private final int value;

        static {
            Type r100 = new Type("STATIC", 0, 0);
            STATIC = r100;
            Type r101 = new Type(BannerBizName.DYNAMIC, 1, 1);
            DYNAMIC = r101;
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
            return DYNAMIC;
        L10:
            return STATIC;
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
        ADAPTER = new ProtoAdapter_DisplayWeight();
        DEFAULT_TYPE = Type.STATIC;
        DEFAULT_PADDING_WEIGHT = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.type = this.type;
        r100.padding_weight = this.padding_weight;
        r100.static_config = this.static_config;
        r100.dynamic_config = this.dynamic_config;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DisplayWeight.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public DisplayWeight(Type r100, Double r101, StaticConfig r102, DynamicConfig r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public DisplayWeight(Type r100, Double r101, StaticConfig r102, DynamicConfig r103, ByteString r104) {
        super(ADAPTER, r104);
        if (Internal.countNonNull(r102, r103) > 1) goto L7;
        this.type = r100;
        this.padding_weight = r101;
        this.static_config = r102;
        this.dynamic_config = r103;
        return;
    L7:
        throw new IllegalArgumentException("at most one of static_config, dynamic_config may be non-null");
    }
}
