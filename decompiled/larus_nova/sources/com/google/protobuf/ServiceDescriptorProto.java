package com.google.protobuf;

import com.alipay.sdk.m.p.e;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public final class ServiceDescriptorProto extends com.squareup.wire.Message<ServiceDescriptorProto, Builder> {
    public static final ProtoAdapter<ServiceDescriptorProto> ADAPTER = null;
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;
    public final List<MethodDescriptorProto> method;
    public final String name;
    public final ServiceOptions options;

    public static final class Builder extends com.squareup.wire.Message.Builder<ServiceDescriptorProto, Builder> {
        public List<MethodDescriptorProto> method;
        public String name;
        public ServiceOptions options;

        @Override // com.squareup.wire.Message.Builder
        public ServiceDescriptorProto build() {
            return new ServiceDescriptorProto(this.name, this.method, this.options, super.buildUnknownFields());
        }

        public Builder() {
            this.method = com.squareup.wire.internal.Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder method(List<MethodDescriptorProto> r100) {
            com.squareup.wire.internal.Internal.checkElementsNotNull(r100);
            this.method = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder options(ServiceOptions r100) {
            this.options = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ServiceDescriptorProto extends ProtoAdapter<ServiceDescriptorProto> {
        public ProtoAdapter_ServiceDescriptorProto() {
            super(FieldEncoding.LENGTH_DELIMITED, ServiceDescriptorProto.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ServiceDescriptorProto decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.name = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.method.add(MethodDescriptorProto.ADAPTER.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.options = ServiceOptions.ADAPTER.decode(r100);
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
        public int encodedSize2(ServiceDescriptorProto r100) {
            String r101 = r100.name;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            int r104 = r103 + MethodDescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.method);
            ServiceOptions r105 = r100.options;
            if (r105 == null) goto L10;
            r102 = ServiceOptions.ADAPTER.encodedSizeWithTag(3, r105);
        L10:
            return (r104 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ServiceDescriptorProto decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ServiceDescriptorProto r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ServiceDescriptorProto r101) throws IOException {
            String r102 = r101.name;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            MethodDescriptorProto.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.method);
            ServiceOptions r103 = r101.options;
            if (r103 == null) goto L8;
            ServiceOptions.ADAPTER.encodeWithTag(r100, 3, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ServiceDescriptorProto r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ServiceDescriptorProto();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.name = this.name;
        r100.method = com.squareup.wire.internal.Internal.copyOf(e.f25671s, this.method);
        r100.options = this.options;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ServiceDescriptorProto.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public ServiceDescriptorProto(String r100, List<MethodDescriptorProto> r101, ServiceOptions r102) {
        this(r100, r101, r102, okio.ByteString.EMPTY);
    }

    public ServiceDescriptorProto(String r100, List<MethodDescriptorProto> r101, ServiceOptions r102, okio.ByteString r103) {
        super(ADAPTER, r103);
        this.name = r100;
        this.method = com.squareup.wire.internal.Internal.immutableCopyOf(e.f25671s, r101);
        this.options = r102;
    }
}
