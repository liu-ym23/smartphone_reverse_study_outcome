package com.google.protobuf;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public final class FileDescriptorProto extends com.squareup.wire.Message<FileDescriptorProto, Builder> {
    public static final ProtoAdapter<FileDescriptorProto> ADAPTER = null;
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_PACKAGE_ = "";
    public static final String DEFAULT_SYNTAX = "";
    private static final long serialVersionUID = 0;
    public final List<String> dependency;
    public final List<EnumDescriptorProto> enum_type;
    public final List<FieldDescriptorProto> extension;
    public final List<DescriptorProto> message_type;
    public final String name;
    public final FileOptions options;
    public final String package_;
    public final List<Integer> public_dependency;
    public final List<ServiceDescriptorProto> service;
    public final SourceCodeInfo source_code_info;
    public final String syntax;
    public final List<Integer> weak_dependency;

    public static final class Builder extends com.squareup.wire.Message.Builder<FileDescriptorProto, Builder> {
        public List<String> dependency;
        public List<EnumDescriptorProto> enum_type;
        public List<FieldDescriptorProto> extension;
        public List<DescriptorProto> message_type;
        public String name;
        public FileOptions options;
        public String package_;
        public List<Integer> public_dependency;
        public List<ServiceDescriptorProto> service;
        public SourceCodeInfo source_code_info;
        public String syntax;
        public List<Integer> weak_dependency;

        @Override // com.squareup.wire.Message.Builder
        public FileDescriptorProto build() {
            return new FileDescriptorProto(this.name, this.package_, this.dependency, this.public_dependency, this.weak_dependency, this.message_type, this.enum_type, this.service, this.extension, this.options, this.source_code_info, this.syntax, super.buildUnknownFields());
        }

        public Builder() {
            this.dependency = com.squareup.wire.internal.Internal.newMutableList();
            this.public_dependency = com.squareup.wire.internal.Internal.newMutableList();
            this.weak_dependency = com.squareup.wire.internal.Internal.newMutableList();
            this.message_type = com.squareup.wire.internal.Internal.newMutableList();
            this.enum_type = com.squareup.wire.internal.Internal.newMutableList();
            this.service = com.squareup.wire.internal.Internal.newMutableList();
            this.extension = com.squareup.wire.internal.Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder dependency(List<String> r100) {
            com.squareup.wire.internal.Internal.checkElementsNotNull(r100);
            this.dependency = r100;
            return this;
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

        public Builder message_type(List<DescriptorProto> r100) {
            com.squareup.wire.internal.Internal.checkElementsNotNull(r100);
            this.message_type = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder options(FileOptions r100) {
            this.options = r100;
            return this;
        }

        public Builder package_(String r100) {
            this.package_ = r100;
            return this;
        }

        public Builder public_dependency(List<Integer> r100) {
            com.squareup.wire.internal.Internal.checkElementsNotNull(r100);
            this.public_dependency = r100;
            return this;
        }

        public Builder service(List<ServiceDescriptorProto> r100) {
            com.squareup.wire.internal.Internal.checkElementsNotNull(r100);
            this.service = r100;
            return this;
        }

        public Builder source_code_info(SourceCodeInfo r100) {
            this.source_code_info = r100;
            return this;
        }

        public Builder syntax(String r100) {
            this.syntax = r100;
            return this;
        }

        public Builder weak_dependency(List<Integer> r100) {
            com.squareup.wire.internal.Internal.checkElementsNotNull(r100);
            this.weak_dependency = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FileDescriptorProto extends ProtoAdapter<FileDescriptorProto> {
        public ProtoAdapter_FileDescriptorProto() {
            super(FieldEncoding.LENGTH_DELIMITED, FileDescriptorProto.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FileDescriptorProto decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.name = "";
            r101.package_ = "";
            r101.syntax = "";
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
                case 9: goto L10;
                case 10: goto L9;
                case 11: goto L8;
                case 12: goto L7;
                default: goto L6;
            };
        L7:
            r101.syntax = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.weak_dependency.add(ProtoAdapter.INT32.decode(r100));
            goto L3
        L9:
            r101.public_dependency.add(ProtoAdapter.INT32.decode(r100));
            goto L3
        L10:
            r101.source_code_info = SourceCodeInfo.ADAPTER.decode(r100);
            goto L3
        L11:
            r101.options = FileOptions.ADAPTER.decode(r100);
            goto L3
        L12:
            r101.extension.add(FieldDescriptorProto.ADAPTER.decode(r100));
            goto L3
        L13:
            r101.service.add(ServiceDescriptorProto.ADAPTER.decode(r100));
            goto L3
        L14:
            r101.enum_type.add(EnumDescriptorProto.ADAPTER.decode(r100));
            goto L3
        L15:
            r101.message_type.add(DescriptorProto.ADAPTER.decode(r100));
            goto L3
        L16:
            r101.dependency.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L17:
            r101.package_ = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.name = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(FileDescriptorProto r100) {
            String r101 = r100.name;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.package_;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            ProtoAdapter<String> r107 = ProtoAdapter.STRING;
            int r108 = r106 + r107.asRepeated().encodedSizeWithTag(3, r100.dependency);
            ProtoAdapter<Integer> r109 = ProtoAdapter.INT32;
            int r110 = (((((r108 + r109.asRepeated().encodedSizeWithTag(10, r100.public_dependency)) + r109.asRepeated().encodedSizeWithTag(11, r100.weak_dependency)) + DescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.message_type)) + EnumDescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(5, r100.enum_type)) + ServiceDescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(6, r100.service)) + FieldDescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(7, r100.extension);
            FileOptions r111 = r100.options;
            if (r111 == null) goto L13;
            int r112 = FileOptions.ADAPTER.encodedSizeWithTag(8, r111);
        L14:
            int r113 = r110 + r112;
            SourceCodeInfo r114 = r100.source_code_info;
            if (r114 == null) goto L17;
            int r115 = SourceCodeInfo.ADAPTER.encodedSizeWithTag(9, r114);
        L18:
            int r116 = r113 + r115;
            String r117 = r100.syntax;
            if (r117 == null) goto L22;
            r102 = r107.encodedSizeWithTag(12, r117);
        L22:
            return (r116 + r102) + r100.unknownFields().size();
        L17:
            r115 = 0;
            goto L18
        L13:
            r112 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FileDescriptorProto decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FileDescriptorProto r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FileDescriptorProto r101) throws IOException {
            String r102 = r101.name;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.package_;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            ProtoAdapter<String> r104 = ProtoAdapter.STRING;
            r104.asRepeated().encodeWithTag(r100, 3, r101.dependency);
            ProtoAdapter<Integer> r105 = ProtoAdapter.INT32;
            r105.asRepeated().encodeWithTag(r100, 10, r101.public_dependency);
            r105.asRepeated().encodeWithTag(r100, 11, r101.weak_dependency);
            DescriptorProto.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.message_type);
            EnumDescriptorProto.ADAPTER.asRepeated().encodeWithTag(r100, 5, r101.enum_type);
            ServiceDescriptorProto.ADAPTER.asRepeated().encodeWithTag(r100, 6, r101.service);
            FieldDescriptorProto.ADAPTER.asRepeated().encodeWithTag(r100, 7, r101.extension);
            FileOptions r106 = r101.options;
            if (r106 == null) goto L11;
            FileOptions.ADAPTER.encodeWithTag(r100, 8, r106);
        L11:
            SourceCodeInfo r107 = r101.source_code_info;
            if (r107 == null) goto L14;
            SourceCodeInfo.ADAPTER.encodeWithTag(r100, 9, r107);
        L14:
            String r108 = r101.syntax;
            if (r108 == null) goto L17;
            r104.encodeWithTag(r100, 12, r108);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FileDescriptorProto r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FileDescriptorProto();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.name = this.name;
        r100.package_ = this.package_;
        r100.dependency = com.squareup.wire.internal.Internal.copyOf("dependency", this.dependency);
        r100.public_dependency = com.squareup.wire.internal.Internal.copyOf("public_dependency", this.public_dependency);
        r100.weak_dependency = com.squareup.wire.internal.Internal.copyOf("weak_dependency", this.weak_dependency);
        r100.message_type = com.squareup.wire.internal.Internal.copyOf("message_type", this.message_type);
        r100.enum_type = com.squareup.wire.internal.Internal.copyOf("enum_type", this.enum_type);
        r100.service = com.squareup.wire.internal.Internal.copyOf("service", this.service);
        r100.extension = com.squareup.wire.internal.Internal.copyOf("extension", this.extension);
        r100.options = this.options;
        r100.source_code_info = this.source_code_info;
        r100.syntax = this.syntax;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FileDescriptorProto.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public FileDescriptorProto(String r110, String r111, List<String> r112, List<Integer> r113, List<Integer> r114, List<DescriptorProto> r210, List<EnumDescriptorProto> r211, List<ServiceDescriptorProto> r212, List<FieldDescriptorProto> r213, FileOptions r214, SourceCodeInfo r215, String r216) {
        this(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216, okio.ByteString.EMPTY);
    }

    public FileDescriptorProto(String r100, String r101, List<String> r102, List<Integer> r103, List<Integer> r104, List<DescriptorProto> r105, List<EnumDescriptorProto> r106, List<ServiceDescriptorProto> r107, List<FieldDescriptorProto> r110, FileOptions r111, SourceCodeInfo r112, String r113, okio.ByteString r114) {
        super(ADAPTER, r114);
        this.name = r100;
        this.package_ = r101;
        this.dependency = com.squareup.wire.internal.Internal.immutableCopyOf("dependency", r102);
        this.public_dependency = com.squareup.wire.internal.Internal.immutableCopyOf("public_dependency", r103);
        this.weak_dependency = com.squareup.wire.internal.Internal.immutableCopyOf("weak_dependency", r104);
        this.message_type = com.squareup.wire.internal.Internal.immutableCopyOf("message_type", r105);
        this.enum_type = com.squareup.wire.internal.Internal.immutableCopyOf("enum_type", r106);
        this.service = com.squareup.wire.internal.Internal.immutableCopyOf("service", r107);
        this.extension = com.squareup.wire.internal.Internal.immutableCopyOf("extension", r110);
        this.options = r111;
        this.source_code_info = r112;
        this.syntax = r113;
    }
}
