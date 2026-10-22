package com.google.protobuf;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public final class EnumDescriptorProto extends com.squareup.wire.Message<EnumDescriptorProto, Builder> {
    public static final ProtoAdapter<EnumDescriptorProto> ADAPTER = null;
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;
    public final String name;
    public final EnumOptions options;
    public final List<String> reserved_name;
    public final List<EnumReservedRange> reserved_range;
    public final List<EnumValueDescriptorProto> value;

    public static final class Builder extends com.squareup.wire.Message.Builder<EnumDescriptorProto, Builder> {
        public String name;
        public EnumOptions options;
        public List<String> reserved_name;
        public List<EnumReservedRange> reserved_range;
        public List<EnumValueDescriptorProto> value;

        @Override // com.squareup.wire.Message.Builder
        public EnumDescriptorProto build() {
            return new EnumDescriptorProto(this.name, this.value, this.options, this.reserved_range, this.reserved_name, super.buildUnknownFields());
        }

        public Builder() {
            this.value = com.squareup.wire.internal.Internal.newMutableList();
            this.reserved_range = com.squareup.wire.internal.Internal.newMutableList();
            this.reserved_name = com.squareup.wire.internal.Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder options(EnumOptions r100) {
            this.options = r100;
            return this;
        }

        public Builder reserved_name(List<String> r100) {
            com.squareup.wire.internal.Internal.checkElementsNotNull(r100);
            this.reserved_name = r100;
            return this;
        }

        public Builder reserved_range(List<EnumReservedRange> r100) {
            com.squareup.wire.internal.Internal.checkElementsNotNull(r100);
            this.reserved_range = r100;
            return this;
        }

        public Builder value(List<EnumValueDescriptorProto> r100) {
            com.squareup.wire.internal.Internal.checkElementsNotNull(r100);
            this.value = r100;
            return this;
        }
    }

    public static final class EnumReservedRange extends com.squareup.wire.Message<EnumReservedRange, Builder> {
        public static final ProtoAdapter<EnumReservedRange> ADAPTER = null;
        public static final Integer DEFAULT_END = null;
        public static final Integer DEFAULT_START = null;
        private static final long serialVersionUID = 0;
        public final Integer end;
        public final Integer start;

        public static final class Builder extends com.squareup.wire.Message.Builder<EnumReservedRange, Builder> {
            public Integer end;
            public Integer start;

            @Override // com.squareup.wire.Message.Builder
            public EnumReservedRange build() {
                return new EnumReservedRange(this.start, this.end, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder end(Integer r100) {
                this.end = r100;
                return this;
            }

            public Builder start(Integer r100) {
                this.start = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_EnumReservedRange extends ProtoAdapter<EnumReservedRange> {
            public ProtoAdapter_EnumReservedRange() {
                super(FieldEncoding.LENGTH_DELIMITED, EnumReservedRange.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public EnumReservedRange decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.start = 0;
                r101.end = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.start = ProtoAdapter.INT32.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.end = ProtoAdapter.INT32.decode(r100);
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
            public int encodedSize2(EnumReservedRange r100) {
                Integer r101 = r100.start;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
            L6:
                Integer r104 = r100.end;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ EnumReservedRange decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(EnumReservedRange r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, EnumReservedRange r101) throws IOException {
                Integer r102 = r101.start;
                if (r102 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
            L5:
                Integer r103 = r101.end;
                if (r103 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EnumReservedRange r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_EnumReservedRange();
            DEFAULT_START = 0;
            DEFAULT_END = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.start = this.start;
            r100.end = this.end;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return EnumReservedRange.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public EnumReservedRange(Integer r100, Integer r101) {
            this(r100, r101, okio.ByteString.EMPTY);
        }

        public EnumReservedRange(Integer r100, Integer r101, okio.ByteString r102) {
            super(ADAPTER, r102);
            this.start = r100;
            this.end = r101;
        }
    }

    public static final class ProtoAdapter_EnumDescriptorProto extends ProtoAdapter<EnumDescriptorProto> {
        public ProtoAdapter_EnumDescriptorProto() {
            super(FieldEncoding.LENGTH_DELIMITED, EnumDescriptorProto.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public EnumDescriptorProto decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.name = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.value.add(EnumValueDescriptorProto.ADAPTER.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.options = EnumOptions.ADAPTER.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.reserved_range.add(EnumReservedRange.ADAPTER.decode(r100));
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.reserved_name.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(EnumDescriptorProto r100) {
            String r101 = r100.name;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            int r104 = r103 + EnumValueDescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.value);
            EnumOptions r105 = r100.options;
            if (r105 == null) goto L10;
            r102 = EnumOptions.ADAPTER.encodedSizeWithTag(3, r105);
        L10:
            return (((r104 + r102) + EnumReservedRange.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.reserved_range)) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(5, r100.reserved_name)) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ EnumDescriptorProto decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(EnumDescriptorProto r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, EnumDescriptorProto r101) throws IOException {
            String r102 = r101.name;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            EnumValueDescriptorProto.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.value);
            EnumOptions r103 = r101.options;
            if (r103 == null) goto L8;
            EnumOptions.ADAPTER.encodeWithTag(r100, 3, r103);
        L8:
            EnumReservedRange.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.reserved_range);
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 5, r101.reserved_name);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EnumDescriptorProto r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_EnumDescriptorProto();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.name = this.name;
        r100.value = com.squareup.wire.internal.Internal.copyOf("value", this.value);
        r100.options = this.options;
        r100.reserved_range = com.squareup.wire.internal.Internal.copyOf("reserved_range", this.reserved_range);
        r100.reserved_name = com.squareup.wire.internal.Internal.copyOf("reserved_name", this.reserved_name);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return EnumDescriptorProto.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public EnumDescriptorProto(String r100, List<EnumValueDescriptorProto> r101, EnumOptions r110, List<EnumReservedRange> r111, List<String> r112) {
        this(r100, r101, r110, r111, r112, okio.ByteString.EMPTY);
    }

    public EnumDescriptorProto(String r100, List<EnumValueDescriptorProto> r101, EnumOptions r102, List<EnumReservedRange> r103, List<String> r104, okio.ByteString r105) {
        super(ADAPTER, r105);
        this.name = r100;
        this.value = com.squareup.wire.internal.Internal.immutableCopyOf("value", r101);
        this.options = r102;
        this.reserved_range = com.squareup.wire.internal.Internal.immutableCopyOf("reserved_range", r103);
        this.reserved_name = com.squareup.wire.internal.Internal.immutableCopyOf("reserved_name", r104);
    }
}
