package com.google.protobuf;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes23.dex */
public final class EnumValueDescriptorProto extends com.squareup.wire.Message<EnumValueDescriptorProto, Builder> {
    public static final ProtoAdapter<EnumValueDescriptorProto> ADAPTER = null;
    public static final String DEFAULT_NAME = "";
    public static final Integer DEFAULT_NUMBER = null;
    private static final long serialVersionUID = 0;
    public final String name;
    public final Integer number;
    public final EnumValueOptions options;

    public static final class Builder extends com.squareup.wire.Message.Builder<EnumValueDescriptorProto, Builder> {
        public String name;
        public Integer number;
        public EnumValueOptions options;

        @Override // com.squareup.wire.Message.Builder
        public EnumValueDescriptorProto build() {
            return new EnumValueDescriptorProto(this.name, this.number, this.options, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder number(Integer r100) {
            this.number = r100;
            return this;
        }

        public Builder options(EnumValueOptions r100) {
            this.options = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_EnumValueDescriptorProto extends ProtoAdapter<EnumValueDescriptorProto> {
        public ProtoAdapter_EnumValueDescriptorProto() {
            super(FieldEncoding.LENGTH_DELIMITED, EnumValueDescriptorProto.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public EnumValueDescriptorProto decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.name = "";
            r101.number = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.number = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.options = EnumValueOptions.ADAPTER.decode(r100);
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
        public int encodedSize2(EnumValueDescriptorProto r100) {
            String r101 = r100.name;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.number;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            EnumValueOptions r107 = r100.options;
            if (r107 == null) goto L14;
            r102 = EnumValueOptions.ADAPTER.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ EnumValueDescriptorProto decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(EnumValueDescriptorProto r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, EnumValueDescriptorProto r101) throws IOException {
            String r102 = r101.name;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.number;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            EnumValueOptions r104 = r101.options;
            if (r104 == null) goto L11;
            EnumValueOptions.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EnumValueDescriptorProto r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_EnumValueDescriptorProto();
        DEFAULT_NUMBER = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.name = this.name;
        r100.number = this.number;
        r100.options = this.options;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return EnumValueDescriptorProto.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public EnumValueDescriptorProto(String r100, Integer r101, EnumValueOptions r102) {
        this(r100, r101, r102, okio.ByteString.EMPTY);
    }

    public EnumValueDescriptorProto(String r100, Integer r101, EnumValueOptions r102, okio.ByteString r103) {
        super(ADAPTER, r103);
        this.name = r100;
        this.number = r101;
        this.options = r102;
    }
}
