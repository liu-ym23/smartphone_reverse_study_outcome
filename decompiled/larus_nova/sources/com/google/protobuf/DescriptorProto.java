package com.google.protobuf;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public final class DescriptorProto extends com.squareup.wire.Message<DescriptorProto, Builder> {
    public static final ProtoAdapter<DescriptorProto> ADAPTER = null;
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;
    public final List<EnumDescriptorProto> enum_type;
    public final List<FieldDescriptorProto> extension;
    public final List<ExtensionRange> extension_range;
    public final List<FieldDescriptorProto> field;
    public final String name;
    public final List<DescriptorProto> nested_type;
    public final List<OneofDescriptorProto> oneof_decl;
    public final MessageOptions options;
    public final List<String> reserved_name;
    public final List<ReservedRange> reserved_range;

    public static final class Builder extends com.squareup.wire.Message.Builder<DescriptorProto, Builder> {
        public List<EnumDescriptorProto> enum_type;
        public List<FieldDescriptorProto> extension;
        public List<ExtensionRange> extension_range;
        public List<FieldDescriptorProto> field;
        public String name;
        public List<DescriptorProto> nested_type;
        public List<OneofDescriptorProto> oneof_decl;
        public MessageOptions options;
        public List<String> reserved_name;
        public List<ReservedRange> reserved_range;

        @Override // com.squareup.wire.Message.Builder
        public DescriptorProto build() {
            return new DescriptorProto(this.name, this.field, this.extension, this.nested_type, this.enum_type, this.extension_range, this.oneof_decl, this.options, this.reserved_range, this.reserved_name, super.buildUnknownFields());
        }

        public Builder() {
            this.field = com.squareup.wire.internal.Internal.newMutableList();
            this.extension = com.squareup.wire.internal.Internal.newMutableList();
            this.nested_type = com.squareup.wire.internal.Internal.newMutableList();
            this.enum_type = com.squareup.wire.internal.Internal.newMutableList();
            this.extension_range = com.squareup.wire.internal.Internal.newMutableList();
            this.oneof_decl = com.squareup.wire.internal.Internal.newMutableList();
            this.reserved_range = com.squareup.wire.internal.Internal.newMutableList();
            this.reserved_name = com.squareup.wire.internal.Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder enum_type(List<EnumDescriptorProto> r100) {
            com.squareup.wire.internal.Internal.checkElementsNotNull(r100);
            this.enum_type = r100;
            return this;
        }

        public Builder extension(List<FieldDescriptorProto> r100) {
            com.squareup.wire.internal.Internal.checkElementsNotNull(r100);
            this.extension = r100;
            return this;
        }

        public Builder extension_range(List<ExtensionRange> r100) {
            com.squareup.wire.internal.Internal.checkElementsNotNull(r100);
            this.extension_range = r100;
            return this;
        }

        public Builder field(List<FieldDescriptorProto> r100) {
            com.squareup.wire.internal.Internal.checkElementsNotNull(r100);
            this.field = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder nested_type(List<DescriptorProto> r100) {
            com.squareup.wire.internal.Internal.checkElementsNotNull(r100);
            this.nested_type = r100;
            return this;
        }

        public Builder oneof_decl(List<OneofDescriptorProto> r100) {
            com.squareup.wire.internal.Internal.checkElementsNotNull(r100);
            this.oneof_decl = r100;
            return this;
        }

        public Builder options(MessageOptions r100) {
            this.options = r100;
            return this;
        }

        public Builder reserved_name(List<String> r100) {
            com.squareup.wire.internal.Internal.checkElementsNotNull(r100);
            this.reserved_name = r100;
            return this;
        }

        public Builder reserved_range(List<ReservedRange> r100) {
            com.squareup.wire.internal.Internal.checkElementsNotNull(r100);
            this.reserved_range = r100;
            return this;
        }
    }

    public static final class ExtensionRange extends com.squareup.wire.Message<ExtensionRange, Builder> {
        public static final ProtoAdapter<ExtensionRange> ADAPTER = null;
        public static final Integer DEFAULT_END = null;
        public static final Integer DEFAULT_START = null;
        private static final long serialVersionUID = 0;
        public final Integer end;
        public final ExtensionRangeOptions options;
        public final Integer start;

        public static final class Builder extends com.squareup.wire.Message.Builder<ExtensionRange, Builder> {
            public Integer end;
            public ExtensionRangeOptions options;
            public Integer start;

            @Override // com.squareup.wire.Message.Builder
            public ExtensionRange build() {
                return new ExtensionRange(this.start, this.end, this.options, super.buildUnknownFields());
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

            public Builder options(ExtensionRangeOptions r100) {
                this.options = r100;
                return this;
            }

            public Builder start(Integer r100) {
                this.start = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ExtensionRange extends ProtoAdapter<ExtensionRange> {
            public ProtoAdapter_ExtensionRange() {
                super(FieldEncoding.LENGTH_DELIMITED, ExtensionRange.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ExtensionRange decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.start = 0;
                r101.end = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.start = ProtoAdapter.INT32.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.end = ProtoAdapter.INT32.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.options = ExtensionRangeOptions.ADAPTER.decode(r100);
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
            public int encodedSize2(ExtensionRange r100) {
                Integer r101 = r100.start;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
            L6:
                Integer r104 = r100.end;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                ExtensionRangeOptions r107 = r100.options;
                if (r107 == null) goto L14;
                r102 = ExtensionRangeOptions.ADAPTER.encodedSizeWithTag(3, r107);
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
            public /* bridge */ /* synthetic */ ExtensionRange decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ExtensionRange r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ExtensionRange r101) throws IOException {
                Integer r102 = r101.start;
                if (r102 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
            L5:
                Integer r103 = r101.end;
                if (r103 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
            L8:
                ExtensionRangeOptions r104 = r101.options;
                if (r104 == null) goto L11;
                ExtensionRangeOptions.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ExtensionRange r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ExtensionRange();
            DEFAULT_START = 0;
            DEFAULT_END = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.start = this.start;
            r100.end = this.end;
            r100.options = this.options;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ExtensionRange.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ExtensionRange(Integer r100, Integer r101, ExtensionRangeOptions r102) {
            this(r100, r101, r102, okio.ByteString.EMPTY);
        }

        public ExtensionRange(Integer r100, Integer r101, ExtensionRangeOptions r102, okio.ByteString r103) {
            super(ADAPTER, r103);
            this.start = r100;
            this.end = r101;
            this.options = r102;
        }
    }

    public static final class ProtoAdapter_DescriptorProto extends ProtoAdapter<DescriptorProto> {
        public ProtoAdapter_DescriptorProto() {
            super(FieldEncoding.LENGTH_DELIMITED, DescriptorProto.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DescriptorProto decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.name = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L17;
            switch(r103) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                case 10: goto L7;
                default: goto L6;
            };
        L7:
            r101.reserved_name.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            r101.reserved_range.add(ReservedRange.ADAPTER.decode(r100));
            goto L3
        L9:
            r101.oneof_decl.add(OneofDescriptorProto.ADAPTER.decode(r100));
            goto L3
        L10:
            r101.options = MessageOptions.ADAPTER.decode(r100);
            goto L3
        L11:
            r101.extension.add(FieldDescriptorProto.ADAPTER.decode(r100));
            goto L3
        L12:
            r101.extension_range.add(ExtensionRange.ADAPTER.decode(r100));
            goto L3
        L13:
            r101.enum_type.add(EnumDescriptorProto.ADAPTER.decode(r100));
            goto L3
        L14:
            r101.nested_type.add(DescriptorProto.ADAPTER.decode(r100));
            goto L3
        L15:
            r101.field.add(FieldDescriptorProto.ADAPTER.decode(r100));
            goto L3
        L16:
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L17:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(DescriptorProto r100) {
            String r101 = r100.name;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            ProtoAdapter<FieldDescriptorProto> r104 = FieldDescriptorProto.ADAPTER;
            int r105 = (((((r103 + r104.asRepeated().encodedSizeWithTag(2, r100.field)) + r104.asRepeated().encodedSizeWithTag(6, r100.extension)) + DescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.nested_type)) + EnumDescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.enum_type)) + ExtensionRange.ADAPTER.asRepeated().encodedSizeWithTag(5, r100.extension_range)) + OneofDescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(8, r100.oneof_decl);
            MessageOptions r106 = r100.options;
            if (r106 == null) goto L10;
            r102 = MessageOptions.ADAPTER.encodedSizeWithTag(7, r106);
        L10:
            return (((r105 + r102) + ReservedRange.ADAPTER.asRepeated().encodedSizeWithTag(9, r100.reserved_range)) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(10, r100.reserved_name)) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DescriptorProto decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DescriptorProto r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DescriptorProto r101) throws IOException {
            String r102 = r101.name;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            ProtoAdapter<FieldDescriptorProto> r103 = FieldDescriptorProto.ADAPTER;
            r103.asRepeated().encodeWithTag(r100, 2, r101.field);
            r103.asRepeated().encodeWithTag(r100, 6, r101.extension);
            DescriptorProto.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.nested_type);
            EnumDescriptorProto.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.enum_type);
            ExtensionRange.ADAPTER.asRepeated().encodeWithTag(r100, 5, r101.extension_range);
            OneofDescriptorProto.ADAPTER.asRepeated().encodeWithTag(r100, 8, r101.oneof_decl);
            MessageOptions r104 = r101.options;
            if (r104 == null) goto L8;
            MessageOptions.ADAPTER.encodeWithTag(r100, 7, r104);
        L8:
            ReservedRange.ADAPTER.asRepeated().encodeWithTag(r100, 9, r101.reserved_range);
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 10, r101.reserved_name);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DescriptorProto r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class ReservedRange extends com.squareup.wire.Message<ReservedRange, Builder> {
        public static final ProtoAdapter<ReservedRange> ADAPTER = null;
        public static final Integer DEFAULT_END = null;
        public static final Integer DEFAULT_START = null;
        private static final long serialVersionUID = 0;
        public final Integer end;
        public final Integer start;

        public static final class Builder extends com.squareup.wire.Message.Builder<ReservedRange, Builder> {
            public Integer end;
            public Integer start;

            @Override // com.squareup.wire.Message.Builder
            public ReservedRange build() {
                return new ReservedRange(this.start, this.end, super.buildUnknownFields());
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

        public static final class ProtoAdapter_ReservedRange extends ProtoAdapter<ReservedRange> {
            public ProtoAdapter_ReservedRange() {
                super(FieldEncoding.LENGTH_DELIMITED, ReservedRange.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ReservedRange decode(ProtoReader r100) throws IOException {
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
            public int encodedSize2(ReservedRange r100) {
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
            public /* bridge */ /* synthetic */ ReservedRange decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ReservedRange r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ReservedRange r101) throws IOException {
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
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ReservedRange r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ReservedRange();
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
            return ReservedRange.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ReservedRange(Integer r100, Integer r101) {
            this(r100, r101, okio.ByteString.EMPTY);
        }

        public ReservedRange(Integer r100, Integer r101, okio.ByteString r102) {
            super(ADAPTER, r102);
            this.start = r100;
            this.end = r101;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DescriptorProto();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.name = this.name;
        r100.field = com.squareup.wire.internal.Internal.copyOf("field", this.field);
        r100.extension = com.squareup.wire.internal.Internal.copyOf("extension", this.extension);
        r100.nested_type = com.squareup.wire.internal.Internal.copyOf("nested_type", this.nested_type);
        r100.enum_type = com.squareup.wire.internal.Internal.copyOf("enum_type", this.enum_type);
        r100.extension_range = com.squareup.wire.internal.Internal.copyOf("extension_range", this.extension_range);
        r100.oneof_decl = com.squareup.wire.internal.Internal.copyOf("oneof_decl", this.oneof_decl);
        r100.options = this.options;
        r100.reserved_range = com.squareup.wire.internal.Internal.copyOf("reserved_range", this.reserved_range);
        r100.reserved_name = com.squareup.wire.internal.Internal.copyOf("reserved_name", this.reserved_name);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DescriptorProto.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public DescriptorProto(String r110, List<FieldDescriptorProto> r111, List<FieldDescriptorProto> r112, List<DescriptorProto> r113, List<EnumDescriptorProto> r114, List<ExtensionRange> r115, List<OneofDescriptorProto> r116, MessageOptions r210, List<ReservedRange> r211, List<String> r212) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, okio.ByteString.EMPTY);
    }

    public DescriptorProto(String r100, List<FieldDescriptorProto> r101, List<FieldDescriptorProto> r102, List<DescriptorProto> r103, List<EnumDescriptorProto> r104, List<ExtensionRange> r105, List<OneofDescriptorProto> r106, MessageOptions r107, List<ReservedRange> r110, List<String> r111, okio.ByteString r112) {
        super(ADAPTER, r112);
        this.name = r100;
        this.field = com.squareup.wire.internal.Internal.immutableCopyOf("field", r101);
        this.extension = com.squareup.wire.internal.Internal.immutableCopyOf("extension", r102);
        this.nested_type = com.squareup.wire.internal.Internal.immutableCopyOf("nested_type", r103);
        this.enum_type = com.squareup.wire.internal.Internal.immutableCopyOf("enum_type", r104);
        this.extension_range = com.squareup.wire.internal.Internal.immutableCopyOf("extension_range", r105);
        this.oneof_decl = com.squareup.wire.internal.Internal.immutableCopyOf("oneof_decl", r106);
        this.options = r107;
        this.reserved_range = com.squareup.wire.internal.Internal.immutableCopyOf("reserved_range", r110);
        this.reserved_name = com.squareup.wire.internal.Internal.immutableCopyOf("reserved_name", r111);
    }
}
