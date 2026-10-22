package com.google.protobuf.server;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes23.dex */
public final class DescriptorProto extends Message<DescriptorProto, Builder> {
    public static final ProtoAdapter<DescriptorProto> ADAPTER = null;
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;
    public final List<EnumDescriptorProto> menum_type;
    public final List<FieldDescriptorProto> mextension;
    public final List<ExtensionRange> mextension_range;
    public final List<FieldDescriptorProto> mfield;
    public final String mname;
    public final List<DescriptorProto> mnested_type;
    public final List<OneofDescriptorProto> moneof_decl;
    public final MessageOptions moptions;
    public final List<String> mreserved_name;
    public final List<ReservedRange> mreserved_range;

    public static final class Builder extends Message.Builder<DescriptorProto, Builder> {
        public List<EnumDescriptorProto> menum_type;
        public List<FieldDescriptorProto> mextension;
        public List<ExtensionRange> mextension_range;
        public List<FieldDescriptorProto> mfield;
        public String mname;
        public List<DescriptorProto> mnested_type;
        public List<OneofDescriptorProto> moneof_decl;
        public MessageOptions moptions;
        public List<String> mreserved_name;
        public List<ReservedRange> mreserved_range;

        @Override // com.squareup.wire.Message.Builder
        public DescriptorProto build() {
            return new DescriptorProto(this.mname, this.mfield, this.mextension, this.mnested_type, this.menum_type, this.mextension_range, this.moneof_decl, this.moptions, this.mreserved_range, this.mreserved_name, super.buildUnknownFields());
        }

        public Builder() {
            this.mfield = Internal.newMutableList();
            this.mextension = Internal.newMutableList();
            this.mnested_type = Internal.newMutableList();
            this.menum_type = Internal.newMutableList();
            this.mextension_range = Internal.newMutableList();
            this.moneof_decl = Internal.newMutableList();
            this.mreserved_range = Internal.newMutableList();
            this.mreserved_name = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder enum_type(List<EnumDescriptorProto> r100) {
            Internal.checkElementsNotNull(r100);
            this.menum_type = r100;
            return this;
        }

        public Builder extension(List<FieldDescriptorProto> r100) {
            Internal.checkElementsNotNull(r100);
            this.mextension = r100;
            return this;
        }

        public Builder extension_range(List<ExtensionRange> r100) {
            Internal.checkElementsNotNull(r100);
            this.mextension_range = r100;
            return this;
        }

        public Builder field(List<FieldDescriptorProto> r100) {
            Internal.checkElementsNotNull(r100);
            this.mfield = r100;
            return this;
        }

        public Builder name(String r100) {
            this.mname = r100;
            return this;
        }

        public Builder nested_type(List<DescriptorProto> r100) {
            Internal.checkElementsNotNull(r100);
            this.mnested_type = r100;
            return this;
        }

        public Builder oneof_decl(List<OneofDescriptorProto> r100) {
            Internal.checkElementsNotNull(r100);
            this.moneof_decl = r100;
            return this;
        }

        public Builder options(MessageOptions r100) {
            this.moptions = r100;
            return this;
        }

        public Builder reserved_name(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mreserved_name = r100;
            return this;
        }

        public Builder reserved_range(List<ReservedRange> r100) {
            Internal.checkElementsNotNull(r100);
            this.mreserved_range = r100;
            return this;
        }
    }

    public static final class ExtensionRange extends Message<ExtensionRange, Builder> {
        public static final ProtoAdapter<ExtensionRange> ADAPTER = null;
        public static final Integer DEFAULT_END = null;
        public static final Integer DEFAULT_START = null;
        private static final long serialVersionUID = 0;
        public final Integer mend;
        public final Integer mstart;

        public static final class Builder extends Message.Builder<ExtensionRange, Builder> {
            public Integer mend;
            public Integer mstart;

            @Override // com.squareup.wire.Message.Builder
            public ExtensionRange build() {
                return new ExtensionRange(this.mstart, this.mend, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder end(Integer r100) {
                this.mend = r100;
                return this;
            }

            public Builder start(Integer r100) {
                this.mstart = r100;
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
                r101.mstart = 0;
                r101.mend = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.mstart = ProtoAdapter.INT32.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.mend = ProtoAdapter.INT32.decode(r100);
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
            public int encodedSize2(ExtensionRange r100) {
                Integer r101 = r100.mstart;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
            L6:
                Integer r104 = r100.mend;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
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
                Integer r102 = r101.mstart;
                if (r102 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
            L5:
                Integer r103 = r101.mend;
                if (r103 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
            L8:
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
            r100.mstart = this.mstart;
            r100.mend = this.mend;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ExtensionRange.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ExtensionRange(Integer r100, Integer r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public ExtensionRange(Integer r100, Integer r101, ByteString r102) {
            super(ADAPTER, r102);
            this.mstart = r100;
            this.mend = r101;
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
            r101.mname = "";
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
            r101.mreserved_name.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            r101.mreserved_range.add(ReservedRange.ADAPTER.decode(r100));
            goto L3
        L9:
            r101.moneof_decl.add(OneofDescriptorProto.ADAPTER.decode(r100));
            goto L3
        L10:
            r101.moptions = MessageOptions.ADAPTER.decode(r100);
            goto L3
        L11:
            r101.mextension.add(FieldDescriptorProto.ADAPTER.decode(r100));
            goto L3
        L12:
            r101.mextension_range.add(ExtensionRange.ADAPTER.decode(r100));
            goto L3
        L13:
            r101.menum_type.add(EnumDescriptorProto.ADAPTER.decode(r100));
            goto L3
        L14:
            r101.mnested_type.add(DescriptorProto.ADAPTER.decode(r100));
            goto L3
        L15:
            r101.mfield.add(FieldDescriptorProto.ADAPTER.decode(r100));
            goto L3
        L16:
            r101.mname = ProtoAdapter.STRING.decode(r100);
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
            String r101 = r100.mname;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            ProtoAdapter<FieldDescriptorProto> r104 = FieldDescriptorProto.ADAPTER;
            int r105 = (((((r103 + r104.asRepeated().encodedSizeWithTag(2, r100.mfield)) + r104.asRepeated().encodedSizeWithTag(6, r100.mextension)) + DescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.mnested_type)) + EnumDescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.menum_type)) + ExtensionRange.ADAPTER.asRepeated().encodedSizeWithTag(5, r100.mextension_range)) + OneofDescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(8, r100.moneof_decl);
            MessageOptions r106 = r100.moptions;
            if (r106 == null) goto L10;
            r102 = MessageOptions.ADAPTER.encodedSizeWithTag(7, r106);
        L10:
            return (((r105 + r102) + ReservedRange.ADAPTER.asRepeated().encodedSizeWithTag(9, r100.mreserved_range)) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(10, r100.mreserved_name)) + r100.unknownFields().size();
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
            String r102 = r101.mname;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            ProtoAdapter<FieldDescriptorProto> r103 = FieldDescriptorProto.ADAPTER;
            r103.asRepeated().encodeWithTag(r100, 2, r101.mfield);
            r103.asRepeated().encodeWithTag(r100, 6, r101.mextension);
            DescriptorProto.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.mnested_type);
            EnumDescriptorProto.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.menum_type);
            ExtensionRange.ADAPTER.asRepeated().encodeWithTag(r100, 5, r101.mextension_range);
            OneofDescriptorProto.ADAPTER.asRepeated().encodeWithTag(r100, 8, r101.moneof_decl);
            MessageOptions r104 = r101.moptions;
            if (r104 == null) goto L8;
            MessageOptions.ADAPTER.encodeWithTag(r100, 7, r104);
        L8:
            ReservedRange.ADAPTER.asRepeated().encodeWithTag(r100, 9, r101.mreserved_range);
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 10, r101.mreserved_name);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DescriptorProto r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class ReservedRange extends Message<ReservedRange, Builder> {
        public static final ProtoAdapter<ReservedRange> ADAPTER = null;
        public static final Integer DEFAULT_END = null;
        public static final Integer DEFAULT_START = null;
        private static final long serialVersionUID = 0;
        public final Integer mend;
        public final Integer mstart;

        public static final class Builder extends Message.Builder<ReservedRange, Builder> {
            public Integer mend;
            public Integer mstart;

            @Override // com.squareup.wire.Message.Builder
            public ReservedRange build() {
                return new ReservedRange(this.mstart, this.mend, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder end(Integer r100) {
                this.mend = r100;
                return this;
            }

            public Builder start(Integer r100) {
                this.mstart = r100;
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
                r101.mstart = 0;
                r101.mend = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.mstart = ProtoAdapter.INT32.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.mend = ProtoAdapter.INT32.decode(r100);
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
                Integer r101 = r100.mstart;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
            L6:
                Integer r104 = r100.mend;
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
                Integer r102 = r101.mstart;
                if (r102 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
            L5:
                Integer r103 = r101.mend;
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
            r100.mstart = this.mstart;
            r100.mend = this.mend;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ReservedRange.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ReservedRange(Integer r100, Integer r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public ReservedRange(Integer r100, Integer r101, ByteString r102) {
            super(ADAPTER, r102);
            this.mstart = r100;
            this.mend = r101;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DescriptorProto();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mname = this.mname;
        r100.mfield = Internal.copyOf("mfield", this.mfield);
        r100.mextension = Internal.copyOf("mextension", this.mextension);
        r100.mnested_type = Internal.copyOf("mnested_type", this.mnested_type);
        r100.menum_type = Internal.copyOf("menum_type", this.menum_type);
        r100.mextension_range = Internal.copyOf("mextension_range", this.mextension_range);
        r100.moneof_decl = Internal.copyOf("moneof_decl", this.moneof_decl);
        r100.moptions = this.moptions;
        r100.mreserved_range = Internal.copyOf("mreserved_range", this.mreserved_range);
        r100.mreserved_name = Internal.copyOf("mreserved_name", this.mreserved_name);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DescriptorProto.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DescriptorProto(String r110, List<FieldDescriptorProto> r111, List<FieldDescriptorProto> r112, List<DescriptorProto> r113, List<EnumDescriptorProto> r114, List<ExtensionRange> r115, List<OneofDescriptorProto> r116, MessageOptions r210, List<ReservedRange> r211, List<String> r212) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
    }

    public DescriptorProto(String r100, List<FieldDescriptorProto> r101, List<FieldDescriptorProto> r102, List<DescriptorProto> r103, List<EnumDescriptorProto> r104, List<ExtensionRange> r105, List<OneofDescriptorProto> r106, MessageOptions r107, List<ReservedRange> r110, List<String> r111, ByteString r112) {
        super(ADAPTER, r112);
        this.mname = r100;
        this.mfield = Internal.immutableCopyOf("mfield", r101);
        this.mextension = Internal.immutableCopyOf("mextension", r102);
        this.mnested_type = Internal.immutableCopyOf("mnested_type", r103);
        this.menum_type = Internal.immutableCopyOf("menum_type", r104);
        this.mextension_range = Internal.immutableCopyOf("mextension_range", r105);
        this.moneof_decl = Internal.immutableCopyOf("moneof_decl", r106);
        this.moptions = r107;
        this.mreserved_range = Internal.immutableCopyOf("mreserved_range", r110);
        this.mreserved_name = Internal.immutableCopyOf("mreserved_name", r111);
    }
}
