package com.google.protobuf.server;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes23.dex */
public final class MethodDescriptorProto extends Message<MethodDescriptorProto, Builder> {
    public static final ProtoAdapter<MethodDescriptorProto> ADAPTER = null;
    public static final Boolean DEFAULT_CLIENT_STREAMING = null;
    public static final String DEFAULT_INPUT_TYPE = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_OUTPUT_TYPE = "";
    public static final Boolean DEFAULT_SERVER_STREAMING = null;
    private static final long serialVersionUID = 0;
    public final Boolean mclient_streaming;
    public final String minput_type;
    public final String mname;
    public final MethodOptions moptions;
    public final String moutput_type;
    public final Boolean mserver_streaming;

    public static final class Builder extends Message.Builder<MethodDescriptorProto, Builder> {
        public Boolean mclient_streaming;
        public String minput_type;
        public String mname;
        public MethodOptions moptions;
        public String moutput_type;
        public Boolean mserver_streaming;

        @Override // com.squareup.wire.Message.Builder
        public MethodDescriptorProto build() {
            return new MethodDescriptorProto(this.mname, this.minput_type, this.moutput_type, this.moptions, this.mclient_streaming, this.mserver_streaming, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder client_streaming(Boolean r100) {
            this.mclient_streaming = r100;
            return this;
        }

        public Builder input_type(String r100) {
            this.minput_type = r100;
            return this;
        }

        public Builder name(String r100) {
            this.mname = r100;
            return this;
        }

        public Builder options(MethodOptions r100) {
            this.moptions = r100;
            return this;
        }

        public Builder output_type(String r100) {
            this.moutput_type = r100;
            return this;
        }

        public Builder server_streaming(Boolean r100) {
            this.mserver_streaming = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MethodDescriptorProto extends ProtoAdapter<MethodDescriptorProto> {
        public ProtoAdapter_MethodDescriptorProto() {
            super(FieldEncoding.LENGTH_DELIMITED, MethodDescriptorProto.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MethodDescriptorProto decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mname = "";
            r101.minput_type = "";
            r101.moutput_type = "";
            Boolean r102 = Boolean.FALSE;
            r101.mclient_streaming = r102;
            r101.mserver_streaming = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L13;
            switch(r104) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r101.mserver_streaming = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            r101.mclient_streaming = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            r101.moptions = MethodOptions.ADAPTER.decode(r100);
            goto L3
        L10:
            r101.moutput_type = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.minput_type = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.mname = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L13:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MethodDescriptorProto r100) {
            String r101 = r100.mname;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.minput_type;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.moutput_type;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            MethodOptions r110 = r100.moptions;
            if (r110 == null) goto L17;
            int r111 = MethodOptions.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Boolean r113 = r100.mclient_streaming;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Boolean r116 = r100.mserver_streaming;
            if (r116 == null) goto L26;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
        L26:
            return (r115 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ MethodDescriptorProto decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MethodDescriptorProto r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MethodDescriptorProto r101) throws IOException {
            String r102 = r101.mname;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.minput_type;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.moutput_type;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            MethodOptions r105 = r101.moptions;
            if (r105 == null) goto L14;
            MethodOptions.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            Boolean r106 = r101.mclient_streaming;
            if (r106 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r106);
        L17:
            Boolean r107 = r101.mserver_streaming;
            if (r107 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MethodDescriptorProto r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MethodDescriptorProto();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_CLIENT_STREAMING = r100;
        DEFAULT_SERVER_STREAMING = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mname = this.mname;
        r100.minput_type = this.minput_type;
        r100.moutput_type = this.moutput_type;
        r100.moptions = this.moptions;
        r100.mclient_streaming = this.mclient_streaming;
        r100.mserver_streaming = this.mserver_streaming;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MethodDescriptorProto.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MethodDescriptorProto(String r100, String r110, String r111, MethodOptions r112, Boolean r113, Boolean r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public MethodDescriptorProto(String r100, String r101, String r102, MethodOptions r103, Boolean r104, Boolean r105, ByteString r106) {
        super(ADAPTER, r106);
        this.mname = r100;
        this.minput_type = r101;
        this.moutput_type = r102;
        this.moptions = r103;
        this.mclient_streaming = r104;
        this.mserver_streaming = r105;
    }
}
