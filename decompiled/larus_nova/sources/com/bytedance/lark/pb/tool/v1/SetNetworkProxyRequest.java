package com.bytedance.lark.pb.tool.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.a;
import we6.b;

/* JADX INFO: loaded from: classes20.dex */
public final class SetNetworkProxyRequest extends Message<SetNetworkProxyRequest, Builder> {
    public static final ProtoAdapter<SetNetworkProxyRequest> ADAPTER = null;
    public static final ProxyMode DEFAULT_MODE = null;
    public static final String DEFAULT_PROXY_URL = "";
    public static final ProtoAdapter_SetNetworkProxyRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ProxyMode mode;
    public final ProxyInfo proxy_info;
    public final String proxy_url;

    public static final class Builder extends Message.Builder<SetNetworkProxyRequest, Builder> implements b<SetNetworkProxyRequest> {
        public ProxyMode mode;
        public ProxyInfo proxy_info;
        public String proxy_url;

        @Override // com.squareup.wire.Message.Builder
        public SetNetworkProxyRequest build() {
            return new SetNetworkProxyRequest(this.proxy_url, this.mode, this.proxy_info, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder mode(ProxyMode r100) {
            this.mode = r100;
            return this;
        }

        public Builder proxy_info(ProxyInfo r100) {
            this.proxy_info = r100;
            return this;
        }

        public Builder proxy_url(String r100) {
            this.proxy_url = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SetNetworkProxyRequest extends ProtoAdapter<SetNetworkProxyRequest> implements a<SetNetworkProxyRequest> {
        public ProtoAdapter_SetNetworkProxyRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SetNetworkProxyRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SetNetworkProxyRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.proxy_url = "";
            r101.mode = ProxyMode.No;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.proxy_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mode = ProxyMode.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.proxy_info = ProxyInfo.ADAPTER.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SetNetworkProxyRequest r100) {
            String r101 = r100.proxy_url;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            ProxyMode r104 = r100.mode;
            if (r104 == null) goto L9;
            int r105 = ProxyMode.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            ProxyInfo r107 = r100.proxy_info;
            if (r107 == null) goto L14;
            r102 = ProxyInfo.ADAPTER.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ SetNetworkProxyRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SetNetworkProxyRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SetNetworkProxyRequest r101) throws IOException {
            String r102 = r101.proxy_url;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            ProxyMode r103 = r101.mode;
            if (r103 == null) goto L8;
            ProxyMode.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            ProxyInfo r104 = r101.proxy_info;
            if (r104 == null) goto L11;
            ProxyInfo.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SetNetworkProxyRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SetNetworkProxyRequest r100 = new ProtoAdapter_SetNetworkProxyRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_MODE = ProxyMode.No;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.proxy_url = this.proxy_url;
        r100.mode = this.mode;
        r100.proxy_info = this.proxy_info;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SetNetworkProxyRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SetNetworkProxyRequest(String r100, ProxyMode r101, ProxyInfo r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public SetNetworkProxyRequest(String r100, ProxyMode r101, ProxyInfo r102, ByteString r103) {
        super(ADAPTER, r103);
        this.proxy_url = r100;
        this.mode = r101;
        this.proxy_info = r102;
    }
}
