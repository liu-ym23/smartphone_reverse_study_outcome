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
public final class FileDescriptorProto extends Message<FileDescriptorProto, Builder> {
    public static final ProtoAdapter<FileDescriptorProto> ADAPTER = null;
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_PACKAGE_ = "";
    public static final String DEFAULT_SYNTAX = "";
    private static final long serialVersionUID = 0;
    public final List<String> mdependency;
    public final List<EnumDescriptorProto> menum_type;
    public final List<FieldDescriptorProto> mextension;
    public final List<DescriptorProto> mmessage_type;
    public final String mname;
    public final FileOptions moptions;
    public final String mpackage_;
    public final List<Integer> mpublic_dependency;
    public final List<ServiceDescriptorProto> mservice;
    public final SourceCodeInfo msource_code_info;
    public final String msyntax;
    public final List<Integer> mweak_dependency;

    public static final class Builder extends Message.Builder<FileDescriptorProto, Builder> {
        public List<String> mdependency;
        public List<EnumDescriptorProto> menum_type;
        public List<FieldDescriptorProto> mextension;
        public List<DescriptorProto> mmessage_type;
        public String mname;
        public FileOptions moptions;
        public String mpackage_;
        public List<Integer> mpublic_dependency;
        public List<ServiceDescriptorProto> mservice;
        public SourceCodeInfo msource_code_info;
        public String msyntax;
        public List<Integer> mweak_dependency;

        @Override // com.squareup.wire.Message.Builder
        public FileDescriptorProto build() {
            return new FileDescriptorProto(this.mname, this.mpackage_, this.mdependency, this.mpublic_dependency, this.mweak_dependency, this.mmessage_type, this.menum_type, this.mservice, this.mextension, this.moptions, this.msource_code_info, this.msyntax, super.buildUnknownFields());
        }

        public Builder() {
            this.mdependency = Internal.newMutableList();
            this.mpublic_dependency = Internal.newMutableList();
            this.mweak_dependency = Internal.newMutableList();
            this.mmessage_type = Internal.newMutableList();
            this.menum_type = Internal.newMutableList();
            this.mservice = Internal.newMutableList();
            this.mextension = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder dependency(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mdependency = r100;
            return this;
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

        public Builder message_type(List<DescriptorProto> r100) {
            Internal.checkElementsNotNull(r100);
            this.mmessage_type = r100;
            return this;
        }

        public Builder name(String r100) {
            this.mname = r100;
            return this;
        }

        public Builder options(FileOptions r100) {
            this.moptions = r100;
            return this;
        }

        public Builder package_(String r100) {
            this.mpackage_ = r100;
            return this;
        }

        public Builder public_dependency(List<Integer> r100) {
            Internal.checkElementsNotNull(r100);
            this.mpublic_dependency = r100;
            return this;
        }

        public Builder service(List<ServiceDescriptorProto> r100) {
            Internal.checkElementsNotNull(r100);
            this.mservice = r100;
            return this;
        }

        public Builder source_code_info(SourceCodeInfo r100) {
            this.msource_code_info = r100;
            return this;
        }

        public Builder syntax(String r100) {
            this.msyntax = r100;
            return this;
        }

        public Builder weak_dependency(List<Integer> r100) {
            Internal.checkElementsNotNull(r100);
            this.mweak_dependency = r100;
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
            r101.mname = "";
            r101.mpackage_ = "";
            r101.msyntax = "";
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
            r101.msyntax = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.mweak_dependency.add(ProtoAdapter.INT32.decode(r100));
            goto L3
        L9:
            r101.mpublic_dependency.add(ProtoAdapter.INT32.decode(r100));
            goto L3
        L10:
            r101.msource_code_info = SourceCodeInfo.ADAPTER.decode(r100);
            goto L3
        L11:
            r101.moptions = FileOptions.ADAPTER.decode(r100);
            goto L3
        L12:
            r101.mextension.add(FieldDescriptorProto.ADAPTER.decode(r100));
            goto L3
        L13:
            r101.mservice.add(ServiceDescriptorProto.ADAPTER.decode(r100));
            goto L3
        L14:
            r101.menum_type.add(EnumDescriptorProto.ADAPTER.decode(r100));
            goto L3
        L15:
            r101.mmessage_type.add(DescriptorProto.ADAPTER.decode(r100));
            goto L3
        L16:
            r101.mdependency.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L17:
            r101.mpackage_ = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.mname = ProtoAdapter.STRING.decode(r100);
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
            String r101 = r100.mname;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mpackage_;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            ProtoAdapter<String> r107 = ProtoAdapter.STRING;
            int r108 = r106 + r107.asRepeated().encodedSizeWithTag(3, r100.mdependency);
            ProtoAdapter<Integer> r109 = ProtoAdapter.INT32;
            int r110 = (((((r108 + r109.asRepeated().encodedSizeWithTag(10, r100.mpublic_dependency)) + r109.asRepeated().encodedSizeWithTag(11, r100.mweak_dependency)) + DescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.mmessage_type)) + EnumDescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(5, r100.menum_type)) + ServiceDescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(6, r100.mservice)) + FieldDescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(7, r100.mextension);
            FileOptions r111 = r100.moptions;
            if (r111 == null) goto L13;
            int r112 = FileOptions.ADAPTER.encodedSizeWithTag(8, r111);
        L14:
            int r113 = r110 + r112;
            SourceCodeInfo r114 = r100.msource_code_info;
            if (r114 == null) goto L17;
            int r115 = SourceCodeInfo.ADAPTER.encodedSizeWithTag(9, r114);
        L18:
            int r116 = r113 + r115;
            String r117 = r100.msyntax;
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
            String r102 = r101.mname;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mpackage_;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            ProtoAdapter<String> r104 = ProtoAdapter.STRING;
            r104.asRepeated().encodeWithTag(r100, 3, r101.mdependency);
            ProtoAdapter<Integer> r105 = ProtoAdapter.INT32;
            r105.asRepeated().encodeWithTag(r100, 10, r101.mpublic_dependency);
            r105.asRepeated().encodeWithTag(r100, 11, r101.mweak_dependency);
            DescriptorProto.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.mmessage_type);
            EnumDescriptorProto.ADAPTER.asRepeated().encodeWithTag(r100, 5, r101.menum_type);
            ServiceDescriptorProto.ADAPTER.asRepeated().encodeWithTag(r100, 6, r101.mservice);
            FieldDescriptorProto.ADAPTER.asRepeated().encodeWithTag(r100, 7, r101.mextension);
            FileOptions r106 = r101.moptions;
            if (r106 == null) goto L11;
            FileOptions.ADAPTER.encodeWithTag(r100, 8, r106);
        L11:
            SourceCodeInfo r107 = r101.msource_code_info;
            if (r107 == null) goto L14;
            SourceCodeInfo.ADAPTER.encodeWithTag(r100, 9, r107);
        L14:
            String r108 = r101.msyntax;
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
        r100.mname = this.mname;
        r100.mpackage_ = this.mpackage_;
        r100.mdependency = Internal.copyOf("mdependency", this.mdependency);
        r100.mpublic_dependency = Internal.copyOf("mpublic_dependency", this.mpublic_dependency);
        r100.mweak_dependency = Internal.copyOf("mweak_dependency", this.mweak_dependency);
        r100.mmessage_type = Internal.copyOf("mmessage_type", this.mmessage_type);
        r100.menum_type = Internal.copyOf("menum_type", this.menum_type);
        r100.mservice = Internal.copyOf("mservice", this.mservice);
        r100.mextension = Internal.copyOf("mextension", this.mextension);
        r100.moptions = this.moptions;
        r100.msource_code_info = this.msource_code_info;
        r100.msyntax = this.msyntax;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FileDescriptorProto.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FileDescriptorProto(String r110, String r111, List<String> r112, List<Integer> r113, List<Integer> r114, List<DescriptorProto> r210, List<EnumDescriptorProto> r211, List<ServiceDescriptorProto> r212, List<FieldDescriptorProto> r213, FileOptions r214, SourceCodeInfo r215, String r216) {
        this(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216, ByteString.EMPTY);
    }

    public FileDescriptorProto(String r100, String r101, List<String> r102, List<Integer> r103, List<Integer> r104, List<DescriptorProto> r105, List<EnumDescriptorProto> r106, List<ServiceDescriptorProto> r107, List<FieldDescriptorProto> r110, FileOptions r111, SourceCodeInfo r112, String r113, ByteString r114) {
        super(ADAPTER, r114);
        this.mname = r100;
        this.mpackage_ = r101;
        this.mdependency = Internal.immutableCopyOf("mdependency", r102);
        this.mpublic_dependency = Internal.immutableCopyOf("mpublic_dependency", r103);
        this.mweak_dependency = Internal.immutableCopyOf("mweak_dependency", r104);
        this.mmessage_type = Internal.immutableCopyOf("mmessage_type", r105);
        this.menum_type = Internal.immutableCopyOf("menum_type", r106);
        this.mservice = Internal.immutableCopyOf("mservice", r107);
        this.mextension = Internal.immutableCopyOf("mextension", r110);
        this.moptions = r111;
        this.msource_code_info = r112;
        this.msyntax = r113;
    }
}
