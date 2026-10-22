package com.google.protobuf;

import androidx.camera.video.AudioStats;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public final class UninterpretedOption extends com.squareup.wire.Message<UninterpretedOption, Builder> {
    public static final ProtoAdapter<UninterpretedOption> ADAPTER = null;
    public static final String DEFAULT_AGGREGATE_VALUE = "";
    public static final Double DEFAULT_DOUBLE_VALUE = null;
    public static final String DEFAULT_IDENTIFIER_VALUE = "";
    public static final Long DEFAULT_NEGATIVE_INT_VALUE = null;
    public static final Long DEFAULT_POSITIVE_INT_VALUE = null;
    public static final okio.ByteString DEFAULT_STRING_VALUE = null;
    private static final long serialVersionUID = 0;
    public final String aggregate_value;
    public final Double double_value;
    public final String identifier_value;
    public final List<NamePart> name;
    public final Long negative_int_value;
    public final Long positive_int_value;
    public final okio.ByteString string_value;

    public static final class Builder extends com.squareup.wire.Message.Builder<UninterpretedOption, Builder> {
        public String aggregate_value;
        public Double double_value;
        public String identifier_value;
        public List<NamePart> name;
        public Long negative_int_value;
        public Long positive_int_value;
        public okio.ByteString string_value;

        @Override // com.squareup.wire.Message.Builder
        public UninterpretedOption build() {
            return new UninterpretedOption(this.name, this.identifier_value, this.positive_int_value, this.negative_int_value, this.double_value, this.string_value, this.aggregate_value, super.buildUnknownFields());
        }

        public Builder() {
            this.name = com.squareup.wire.internal.Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder aggregate_value(String r100) {
            this.aggregate_value = r100;
            return this;
        }

        public Builder double_value(Double r100) {
            this.double_value = r100;
            return this;
        }

        public Builder identifier_value(String r100) {
            this.identifier_value = r100;
            return this;
        }

        public Builder name(List<NamePart> r100) {
            com.squareup.wire.internal.Internal.checkElementsNotNull(r100);
            this.name = r100;
            return this;
        }

        public Builder negative_int_value(Long r100) {
            this.negative_int_value = r100;
            return this;
        }

        public Builder positive_int_value(Long r100) {
            this.positive_int_value = r100;
            return this;
        }

        public Builder string_value(okio.ByteString r100) {
            this.string_value = r100;
            return this;
        }
    }

    public static final class NamePart extends com.squareup.wire.Message<NamePart, Builder> {
        public static final ProtoAdapter<NamePart> ADAPTER = null;
        public static final Boolean DEFAULT_IS_EXTENSION = null;
        public static final String DEFAULT_NAME_PART = "";
        private static final long serialVersionUID = 0;
        public final Boolean is_extension;
        public final String name_part;

        public static final class Builder extends com.squareup.wire.Message.Builder<NamePart, Builder> {
            public Boolean is_extension;
            public String name_part;

            @Override // com.squareup.wire.Message.Builder
            public NamePart build() {
                String r100 = this.name_part;
                if (r100 == null) goto L9;
                if (this.is_extension == null) goto L9;
                return new NamePart(this.name_part, this.is_extension, super.buildUnknownFields());
            L9:
                throw com.squareup.wire.internal.Internal.missingRequiredFields(new Object[]{r100, "name_part", this.is_extension, "is_extension"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder is_extension(Boolean r100) {
                this.is_extension = r100;
                return this;
            }

            public Builder name_part(String r100) {
                this.name_part = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_NamePart extends ProtoAdapter<NamePart> {
            public ProtoAdapter_NamePart() {
                super(FieldEncoding.LENGTH_DELIMITED, NamePart.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public NamePart decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.name_part = "";
                r101.is_extension = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.name_part = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.is_extension = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(NamePart r100) {
                return (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.name_part) + ProtoAdapter.BOOL.encodedSizeWithTag(2, r100.is_extension)) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ NamePart decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(NamePart r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, NamePart r101) throws IOException {
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.name_part);
                ProtoAdapter.BOOL.encodeWithTag(r100, 2, r101.is_extension);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, NamePart r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_NamePart();
            DEFAULT_IS_EXTENSION = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.name_part = this.name_part;
            r100.is_extension = this.is_extension;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return NamePart.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public NamePart(String r100, Boolean r101) {
            this(r100, r101, okio.ByteString.EMPTY);
        }

        public NamePart(String r100, Boolean r101, okio.ByteString r102) {
            super(ADAPTER, r102);
            this.name_part = r100;
            this.is_extension = r101;
        }
    }

    public static final class ProtoAdapter_UninterpretedOption extends ProtoAdapter<UninterpretedOption> {
        public ProtoAdapter_UninterpretedOption() {
            super(FieldEncoding.LENGTH_DELIMITED, UninterpretedOption.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UninterpretedOption decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.identifier_value = "";
            r101.positive_int_value = 0L;
            r101.negative_int_value = 0L;
            r101.double_value = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
            r101.string_value = okio.ByteString.EMPTY;
            r101.aggregate_value = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L14;
            switch(r103) {
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                default: goto L6;
            };
        L7:
            r101.aggregate_value = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.string_value = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L9:
            r101.double_value = ProtoAdapter.DOUBLE.decode(r100);
            goto L3
        L10:
            r101.negative_int_value = ProtoAdapter.INT64.decode(r100);
            goto L3
        L11:
            r101.positive_int_value = ProtoAdapter.UINT64.decode(r100);
            goto L3
        L12:
            r101.identifier_value = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.name.add(NamePart.ADAPTER.decode(r100));
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
        public int encodedSize2(UninterpretedOption r100) {
            int r101 = NamePart.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.name);
            String r102 = r100.identifier_value;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.STRING.encodedSizeWithTag(3, r102);
        L6:
            int r105 = r101 + r104;
            Long r106 = r100.positive_int_value;
            if (r106 == null) goto L9;
            int r107 = ProtoAdapter.UINT64.encodedSizeWithTag(4, r106);
        L10:
            int r108 = r105 + r107;
            Long r109 = r100.negative_int_value;
            if (r109 == null) goto L13;
            int r110 = ProtoAdapter.INT64.encodedSizeWithTag(5, r109);
        L14:
            int r111 = r108 + r110;
            Double r112 = r100.double_value;
            if (r112 == null) goto L17;
            int r113 = ProtoAdapter.DOUBLE.encodedSizeWithTag(6, r112);
        L18:
            int r114 = r111 + r113;
            okio.ByteString r115 = r100.string_value;
            if (r115 == null) goto L21;
            int r116 = ProtoAdapter.BYTES.encodedSizeWithTag(7, r115);
        L22:
            int r117 = r114 + r116;
            String r118 = r100.aggregate_value;
            if (r118 == null) goto L26;
            r103 = ProtoAdapter.STRING.encodedSizeWithTag(8, r118);
        L26:
            return (r117 + r103) + r100.unknownFields().size();
        L21:
            r116 = 0;
            goto L22
        L17:
            r113 = 0;
            goto L18
        L13:
            r110 = 0;
            goto L14
        L9:
            r107 = 0;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UninterpretedOption decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UninterpretedOption r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UninterpretedOption r101) throws IOException {
            NamePart.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.name);
            String r102 = r101.identifier_value;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r102);
        L5:
            Long r103 = r101.positive_int_value;
            if (r103 == null) goto L8;
            ProtoAdapter.UINT64.encodeWithTag(r100, 4, r103);
        L8:
            Long r104 = r101.negative_int_value;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 5, r104);
        L11:
            Double r105 = r101.double_value;
            if (r105 == null) goto L14;
            ProtoAdapter.DOUBLE.encodeWithTag(r100, 6, r105);
        L14:
            okio.ByteString r106 = r101.string_value;
            if (r106 == null) goto L17;
            ProtoAdapter.BYTES.encodeWithTag(r100, 7, r106);
        L17:
            String r107 = r101.aggregate_value;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 8, r107);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UninterpretedOption r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UninterpretedOption();
        DEFAULT_POSITIVE_INT_VALUE = 0L;
        DEFAULT_NEGATIVE_INT_VALUE = 0L;
        DEFAULT_DOUBLE_VALUE = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        DEFAULT_STRING_VALUE = okio.ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.name = com.squareup.wire.internal.Internal.copyOf("name", this.name);
        r100.identifier_value = this.identifier_value;
        r100.positive_int_value = this.positive_int_value;
        r100.negative_int_value = this.negative_int_value;
        r100.double_value = this.double_value;
        r100.string_value = this.string_value;
        r100.aggregate_value = this.aggregate_value;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UninterpretedOption.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public UninterpretedOption(List<NamePart> r110, String r111, Long r112, Long r113, Double r114, okio.ByteString r115, String r116) {
        this(r110, r111, r112, r113, r114, r115, r116, okio.ByteString.EMPTY);
    }

    public UninterpretedOption(List<NamePart> r100, String r101, Long r102, Long r103, Double r104, okio.ByteString r105, String r106, okio.ByteString r107) {
        super(ADAPTER, r107);
        this.name = com.squareup.wire.internal.Internal.immutableCopyOf("name", r100);
        this.identifier_value = r101;
        this.positive_int_value = r102;
        this.negative_int_value = r103;
        this.double_value = r104;
        this.string_value = r105;
        this.aggregate_value = r106;
    }
}
