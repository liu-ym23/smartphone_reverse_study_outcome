package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.a;
import we6.b;

/* JADX INFO: loaded from: classes20.dex */
public final class SetEnvResponse extends com.squareup.wire.Message<SetEnvResponse, Builder> {
    public static final ProtoAdapter<SetEnvResponse> ADAPTER = null;
    public static final ProtoAdapter_SetEnvResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final DomainSettings domain_settings;

    public static final class Builder extends com.squareup.wire.Message.Builder<SetEnvResponse, Builder> implements b<SetEnvResponse> {
        public DomainSettings domain_settings;

        @Override // com.squareup.wire.Message.Builder
        public SetEnvResponse build() {
            return new SetEnvResponse(this.domain_settings, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder domain_settings(DomainSettings r100) {
            this.domain_settings = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SetEnvResponse extends ProtoAdapter<SetEnvResponse> implements a<SetEnvResponse> {
        public ProtoAdapter_SetEnvResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SetEnvResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SetEnvResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.domain_settings = DomainSettings.ADAPTER.decode(r100);
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L9:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SetEnvResponse r100) {
            DomainSettings r101 = r100.domain_settings;
            if (r101 == null) goto L5;
            int r102 = DomainSettings.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SetEnvResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SetEnvResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SetEnvResponse r101) throws IOException {
            DomainSettings r102 = r101.domain_settings;
            if (r102 == null) goto L5;
            DomainSettings.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SetEnvResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SetEnvResponse r100 = new ProtoAdapter_SetEnvResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.domain_settings = this.domain_settings;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SetEnvResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public SetEnvResponse(DomainSettings r100) {
        this(r100, ByteString.EMPTY);
    }

    public SetEnvResponse(DomainSettings r100, ByteString r101) {
        super(ADAPTER, r101);
        this.domain_settings = r100;
    }
}
