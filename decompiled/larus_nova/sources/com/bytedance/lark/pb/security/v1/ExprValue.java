package com.bytedance.lark.pb.security.v1;

import androidx.camera.video.AudioStats;
import annotation.Debug;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.protobuf.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class ExprValue extends Message<ExprValue, Builder> {
    public static final ProtoAdapter<ExprValue> ADAPTER = null;
    public static final Boolean DEFAULT_BOOL_VALUE = null;
    public static final Double DEFAULT_DOUBLE_VALUE = null;
    public static final Long DEFAULT_LONG_VALUE = null;
    public static final String DEFAULT_STRING_VALUE = "";
    public static final FieldOptions FIELD_OPTIONS_ARRAY_VALUE = null;
    public static final FieldOptions FIELD_OPTIONS_BOOL_VALUE = null;
    public static final FieldOptions FIELD_OPTIONS_DOUBLE_VALUE = null;
    public static final FieldOptions FIELD_OPTIONS_LONG_VALUE = null;
    public static final FieldOptions FIELD_OPTIONS_MISS_VALUE = null;
    public static final FieldOptions FIELD_OPTIONS_NULL_VALUE = null;
    public static final FieldOptions FIELD_OPTIONS_STRING_VALUE = null;
    private static final long serialVersionUID = 0;
    public final ArrayValue array_value;
    public final Boolean bool_value;
    public final Double double_value;
    public final Long long_value;
    public final MissValue miss_value;
    public final NullValue null_value;
    public final String string_value;

    public static final class ArrayValue extends Message<ArrayValue, Builder> {
        public static final ProtoAdapter<ArrayValue> ADAPTER = null;
        public static final FieldOptions FIELD_OPTIONS_VALUE = null;
        private static final long serialVersionUID = 0;
        public final List<ExprValue> value;

        public static final class Builder extends Message.Builder<ArrayValue, Builder> {
            public List<ExprValue> value;

            @Override // com.squareup.wire.Message.Builder
            public ArrayValue build() {
                return new ArrayValue(this.value, super.buildUnknownFields());
            }

            public Builder() {
                this.value = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder value(List<ExprValue> r100) {
                Internal.checkElementsNotNull(r100);
                this.value = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ArrayValue extends ProtoAdapter<ArrayValue> {
            public ProtoAdapter_ArrayValue() {
                super(FieldEncoding.LENGTH_DELIMITED, ArrayValue.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ArrayValue decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.value.add(ExprValue.ADAPTER.decode(r100));
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
            public int encodedSize2(ArrayValue r100) {
                return ExprValue.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.value) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ArrayValue decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ArrayValue r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ArrayValue r101) throws IOException {
                ExprValue.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.value);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ArrayValue r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ArrayValue();
            FIELD_OPTIONS_VALUE = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.value = Internal.copyOf("value", this.value);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ArrayValue.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ArrayValue(List<ExprValue> r100) {
            this(r100, ByteString.EMPTY);
        }

        public ArrayValue(List<ExprValue> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.value = Internal.immutableCopyOf("value", r100);
        }
    }

    public static final class Builder extends Message.Builder<ExprValue, Builder> {
        public ArrayValue array_value;
        public Boolean bool_value;
        public Double double_value;
        public Long long_value;
        public MissValue miss_value;
        public NullValue null_value;
        public String string_value;

        @Override // com.squareup.wire.Message.Builder
        public ExprValue build() {
            return new ExprValue(this.string_value, this.double_value, this.long_value, this.bool_value, this.array_value, this.miss_value, this.null_value, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder array_value(ArrayValue r100) {
            this.array_value = r100;
            this.string_value = null;
            this.double_value = null;
            this.long_value = null;
            this.bool_value = null;
            this.miss_value = null;
            this.null_value = null;
            return this;
        }

        public Builder bool_value(Boolean r100) {
            this.bool_value = r100;
            this.string_value = null;
            this.double_value = null;
            this.long_value = null;
            this.array_value = null;
            this.miss_value = null;
            this.null_value = null;
            return this;
        }

        public Builder double_value(Double r100) {
            this.double_value = r100;
            this.string_value = null;
            this.long_value = null;
            this.bool_value = null;
            this.array_value = null;
            this.miss_value = null;
            this.null_value = null;
            return this;
        }

        public Builder long_value(Long r100) {
            this.long_value = r100;
            this.string_value = null;
            this.double_value = null;
            this.bool_value = null;
            this.array_value = null;
            this.miss_value = null;
            this.null_value = null;
            return this;
        }

        public Builder miss_value(MissValue r100) {
            this.miss_value = r100;
            this.string_value = null;
            this.double_value = null;
            this.long_value = null;
            this.bool_value = null;
            this.array_value = null;
            this.null_value = null;
            return this;
        }

        public Builder null_value(NullValue r100) {
            this.null_value = r100;
            this.string_value = null;
            this.double_value = null;
            this.long_value = null;
            this.bool_value = null;
            this.array_value = null;
            this.miss_value = null;
            return this;
        }

        public Builder string_value(String r100) {
            this.string_value = r100;
            this.double_value = null;
            this.long_value = null;
            this.bool_value = null;
            this.array_value = null;
            this.miss_value = null;
            this.null_value = null;
            return this;
        }
    }

    public static final class MissValue extends Message<MissValue, Builder> {
        public static final ProtoAdapter<MissValue> ADAPTER = null;
        public static final String DEFAULT_IDENTIFIER = "";
        public static final FieldOptions FIELD_OPTIONS_IDENTIFIER = null;
        private static final long serialVersionUID = 0;
        public final String identifier;

        public static final class Builder extends Message.Builder<MissValue, Builder> {
            public String identifier;

            @Override // com.squareup.wire.Message.Builder
            public MissValue build() {
                String r100 = this.identifier;
                if (r100 == null) goto L7;
                return new MissValue(this.identifier, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, LocationMonitorConst.IDENTIFIER});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder identifier(String r100) {
                this.identifier = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_MissValue extends ProtoAdapter<MissValue> {
            public ProtoAdapter_MissValue() {
                super(FieldEncoding.LENGTH_DELIMITED, MissValue.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public MissValue decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.identifier = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.identifier = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(MissValue r100) {
                return ProtoAdapter.STRING.encodedSizeWithTag(1, r100.identifier) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ MissValue decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(MissValue r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, MissValue r101) throws IOException {
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.identifier);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MissValue r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MissValue();
            FIELD_OPTIONS_IDENTIFIER = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.identifier = this.identifier;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return MissValue.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public MissValue(String r100) {
            this(r100, ByteString.EMPTY);
        }

        public MissValue(String r100, ByteString r101) {
            super(ADAPTER, r101);
            this.identifier = r100;
        }
    }

    public static final class NullValue extends Message<NullValue, Builder> {
        public static final ProtoAdapter<NullValue> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends Message.Builder<NullValue, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public NullValue build() {
                return new NullValue(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }
        }

        public static final class ProtoAdapter_NullValue extends ProtoAdapter<NullValue> {
            public ProtoAdapter_NullValue() {
                super(FieldEncoding.LENGTH_DELIMITED, NullValue.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public NullValue decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L6;
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L6:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(NullValue r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ NullValue decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(NullValue r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, NullValue r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, NullValue r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_NullValue();
        }

        public NullValue() {
            this(ByteString.EMPTY);
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return NullValue.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public NullValue(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class ProtoAdapter_ExprValue extends ProtoAdapter<ExprValue> {
        public ProtoAdapter_ExprValue() {
            super(FieldEncoding.LENGTH_DELIMITED, ExprValue.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ExprValue decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.string_value("");
            r101.double_value(Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE));
            r101.long_value(0L);
            r101.bool_value(Boolean.FALSE);
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L14;
            switch(r103) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r101.null_value(NullValue.ADAPTER.decode(r100));
            goto L3
        L8:
            r101.miss_value(MissValue.ADAPTER.decode(r100));
            goto L3
        L9:
            r101.array_value(ArrayValue.ADAPTER.decode(r100));
            goto L3
        L10:
            r101.bool_value(ProtoAdapter.BOOL.decode(r100));
            goto L3
        L11:
            r101.long_value(ProtoAdapter.INT64.decode(r100));
            goto L3
        L12:
            r101.double_value(ProtoAdapter.DOUBLE.decode(r100));
            goto L3
        L13:
            r101.string_value(ProtoAdapter.STRING.decode(r100));
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L14:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ExprValue r100) {
            String r101 = r100.string_value;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Double r104 = r100.double_value;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.DOUBLE.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.long_value;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Boolean r110 = r100.bool_value;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            ArrayValue r113 = r100.array_value;
            if (r113 == null) goto L21;
            int r114 = ArrayValue.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            MissValue r116 = r100.miss_value;
            if (r116 == null) goto L25;
            int r117 = MissValue.ADAPTER.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            NullValue r119 = r100.null_value;
            if (r119 == null) goto L30;
            r102 = NullValue.ADAPTER.encodedSizeWithTag(7, r119);
        L30:
            return (r118 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ ExprValue decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ExprValue r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ExprValue r101) throws IOException {
            String r102 = r101.string_value;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Double r103 = r101.double_value;
            if (r103 == null) goto L8;
            ProtoAdapter.DOUBLE.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.long_value;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L11:
            Boolean r105 = r101.bool_value;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
        L14:
            ArrayValue r106 = r101.array_value;
            if (r106 == null) goto L17;
            ArrayValue.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            MissValue r107 = r101.miss_value;
            if (r107 == null) goto L20;
            MissValue.ADAPTER.encodeWithTag(r100, 6, r107);
        L20:
            NullValue r108 = r101.null_value;
            if (r108 == null) goto L23;
            NullValue.ADAPTER.encodeWithTag(r100, 7, r108);
        L23:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ExprValue r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ExprValue();
        FIELD_OPTIONS_STRING_VALUE = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_DOUBLE_VALUE = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_LONG_VALUE = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_BOOL_VALUE = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_ARRAY_VALUE = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_MISS_VALUE = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_NULL_VALUE = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        DEFAULT_DOUBLE_VALUE = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        DEFAULT_LONG_VALUE = 0L;
        DEFAULT_BOOL_VALUE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.string_value = this.string_value;
        r100.double_value = this.double_value;
        r100.long_value = this.long_value;
        r100.bool_value = this.bool_value;
        r100.array_value = this.array_value;
        r100.miss_value = this.miss_value;
        r100.null_value = this.null_value;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ExprValue.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ExprValue(String r110, Double r111, Long r112, Boolean r113, ArrayValue r114, MissValue r115, NullValue r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public ExprValue(String r100, Double r101, Long r102, Boolean r103, ArrayValue r104, MissValue r105, NullValue r106, ByteString r110) {
        super(ADAPTER, r110);
        if (Internal.countNonNull(r100, r101, r102, r103, new Object[]{r104, r105, r106}) > 1) goto L7;
        this.string_value = r100;
        this.double_value = r101;
        this.long_value = r102;
        this.bool_value = r103;
        this.array_value = r104;
        this.miss_value = r105;
        this.null_value = r106;
        return;
    L7:
        throw new IllegalArgumentException("at most one of string_value, double_value, long_value, bool_value, array_value, miss_value, null_value may be non-null");
    }
}
