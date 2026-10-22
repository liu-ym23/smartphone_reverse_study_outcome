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
public final class ServiceDescriptorProto extends Message<ServiceDescriptorProto, Builder> {
    public static final ProtoAdapter<ServiceDescriptorProto> ADAPTER = null;
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;
    public final List<MethodDescriptorProto> mmethod;
    public final String mname;
    public final ServiceOptions moptions;

    public static final class Builder extends Message.Builder<ServiceDescriptorProto, Builder> {
        public List<MethodDescriptorProto> mmethod;
        public String mname;
        public ServiceOptions moptions;

        @Override // com.squareup.wire.Message.Builder
        public ServiceDescriptorProto build() {
            return new ServiceDescriptorProto(this.mname, this.mmethod, this.moptions, super.buildUnknownFields());
        }

        public Builder() {
            this.mmethod = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder method(List<MethodDescriptorProto> r100) {
            Internal.checkElementsNotNull(r100);
            this.mmethod = r100;
            return this;
        }

        public Builder name(String r100) {
            this.mname = r100;
            return this;
        }

        public Builder options(ServiceOptions r100) {
            this.moptions = r100;
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
            r101.mname = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.mname = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mmethod.add(MethodDescriptorProto.ADAPTER.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.moptions = ServiceOptions.ADAPTER.decode(r100);
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
            String r101 = r100.mname;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            int r104 = r103 + MethodDescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.mmethod);
            ServiceOptions r105 = r100.moptions;
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
            String r102 = r101.mname;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            MethodDescriptorProto.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.mmethod);
            ServiceOptions r103 = r101.moptions;
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
        r100.mname = this.mname;
        r100.mmethod = Internal.copyOf("mmethod", this.mmethod);
        r100.moptions = this.moptions;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ServiceDescriptorProto.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ServiceDescriptorProto(String r100, List<MethodDescriptorProto> r101, ServiceOptions r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public ServiceDescriptorProto(String r100, List<MethodDescriptorProto> r101, ServiceOptions r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mname = r100;
        this.mmethod = Internal.immutableCopyOf("mmethod", r101);
        this.moptions = r102;
    }
}
