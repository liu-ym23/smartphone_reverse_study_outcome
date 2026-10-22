package com.bytedance.lark.pb.tool.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class ProxyInfo extends Message<ProxyInfo, Builder> {
    public static final ProtoAdapter<ProxyInfo> ADAPTER = null;
    public static final String DEFAULT_HOST = "";
    public static final String DEFAULT_PASSWORD = "";
    public static final String DEFAULT_PORT = "";
    public static final String DEFAULT_USERNAME = "";
    private static final long serialVersionUID = 0;
    public final String host;
    public final String password;
    public final String port;
    public final String username;

    public static final class Builder extends Message.Builder<ProxyInfo, Builder> {
        public String host;
        public String password;
        public String port;
        public String username;

        @Override // com.squareup.wire.Message.Builder
        public ProxyInfo build() {
            String r100 = this.host;
            if (r100 == null) goto L9;
            if (this.port == null) goto L9;
            return new ProxyInfo(this.host, this.port, this.username, this.password, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "host", this.port, "port"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder host(String r100) {
            this.host = r100;
            return this;
        }

        public Builder password(String r100) {
            this.password = r100;
            return this;
        }

        public Builder port(String r100) {
            this.port = r100;
            return this;
        }

        public Builder username(String r100) {
            this.username = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ProxyInfo extends ProtoAdapter<ProxyInfo> {
        public ProtoAdapter_ProxyInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, ProxyInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ProxyInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.host = "";
            r101.port = "";
            r101.username = "";
            r101.password = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.host = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.port = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.username = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.password = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ProxyInfo r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.host) + r101.encodedSizeWithTag(2, r100.port);
            String r103 = r100.username;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(3, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.password;
            if (r107 == null) goto L10;
            r104 = r101.encodedSizeWithTag(4, r107);
        L10:
            return (r106 + r104) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ProxyInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ProxyInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ProxyInfo r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.host);
            r102.encodeWithTag(r100, 2, r101.port);
            String r103 = r101.username;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 3, r103);
        L5:
            String r104 = r101.password;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 4, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ProxyInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ProxyInfo();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.host = this.host;
        r100.port = this.port;
        r100.username = this.username;
        r100.password = this.password;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ProxyInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ProxyInfo(String r100, String r101, String r102, String r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public ProxyInfo(String r100, String r101, String r102, String r103, ByteString r104) {
        super(ADAPTER, r104);
        this.host = r100;
        this.port = r101;
        this.username = r102;
        this.password = r103;
    }
}
