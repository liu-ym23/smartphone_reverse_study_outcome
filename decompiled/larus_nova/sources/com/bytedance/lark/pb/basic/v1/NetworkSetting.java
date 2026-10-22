package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class NetworkSetting extends com.squareup.wire.Message<NetworkSetting, Builder> {
    public static final ProtoAdapter<NetworkSetting> ADAPTER = null;
    public static final Boolean DEFAULT_DISABLE_HTTP_DNS = null;
    public static final Boolean DEFAULT_DISABLE_SSL_PINING = null;
    private static final long serialVersionUID = 0;
    public final Boolean disable_http_dns;
    public final Boolean disable_ssl_pining;

    public static final class Builder extends com.squareup.wire.Message.Builder<NetworkSetting, Builder> {
        public Boolean disable_http_dns;
        public Boolean disable_ssl_pining;

        @Override // com.squareup.wire.Message.Builder
        public NetworkSetting build() {
            return new NetworkSetting(this.disable_ssl_pining, this.disable_http_dns, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder disable_http_dns(Boolean r100) {
            this.disable_http_dns = r100;
            return this;
        }

        public Builder disable_ssl_pining(Boolean r100) {
            this.disable_ssl_pining = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_NetworkSetting extends ProtoAdapter<NetworkSetting> {
        public ProtoAdapter_NetworkSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, NetworkSetting.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public NetworkSetting decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.FALSE;
            r101.disable_ssl_pining = r102;
            r101.disable_http_dns = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L12;
            if (r104 != 1) goto L8;
            r101.disable_ssl_pining = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L9;
            r101.disable_http_dns = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(NetworkSetting r100) {
            Boolean r101 = r100.disable_ssl_pining;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.disable_http_dns;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ NetworkSetting decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(NetworkSetting r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, NetworkSetting r101) throws IOException {
            Boolean r102 = r101.disable_ssl_pining;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.disable_http_dns;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, NetworkSetting r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_NetworkSetting();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_DISABLE_SSL_PINING = r100;
        DEFAULT_DISABLE_HTTP_DNS = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.disable_ssl_pining = this.disable_ssl_pining;
        r100.disable_http_dns = this.disable_http_dns;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return NetworkSetting.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public NetworkSetting(Boolean r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public NetworkSetting(Boolean r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.disable_ssl_pining = r100;
        this.disable_http_dns = r101;
    }
}
