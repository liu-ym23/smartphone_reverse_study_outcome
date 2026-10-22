package com.bytedance.lark.pb.basic.v1;

import com.huawei.hms.push.HmsMessageService;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class ProxyConfig extends com.squareup.wire.Message<ProxyConfig, Builder> {
    public static final ProtoAdapter<ProxyConfig> ADAPTER = null;
    public static final ProxyType DEFAULT_PROXY_TYPE = null;
    private static final long serialVersionUID = 0;
    public final ProxyScheme proxy_scheme;
    public final ProxyType proxy_type;

    public static final class Builder extends com.squareup.wire.Message.Builder<ProxyConfig, Builder> {
        public ProxyScheme proxy_scheme;
        public ProxyType proxy_type;

        @Override // com.squareup.wire.Message.Builder
        public ProxyConfig build() {
            ProxyType r100 = this.proxy_type;
            if (r100 == null) goto L7;
            return new ProxyConfig(this.proxy_type, this.proxy_scheme, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, HmsMessageService.PROXY_TYPE});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder proxy_scheme(ProxyScheme r100) {
            this.proxy_scheme = r100;
            return this;
        }

        public Builder proxy_type(ProxyType r100) {
            this.proxy_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ProxyConfig extends ProtoAdapter<ProxyConfig> {
        public ProtoAdapter_ProxyConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, ProxyConfig.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ProxyConfig decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.proxy_type = ProxyType.None;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.proxy_type = ProxyType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.proxy_scheme = ProxyScheme.ADAPTER.decode(r100);
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ProxyConfig r100) {
            int r101 = ProxyType.ADAPTER.encodedSizeWithTag(1, r100.proxy_type);
            ProxyScheme r102 = r100.proxy_scheme;
            if (r102 == null) goto L5;
            int r103 = ProxyScheme.ADAPTER.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ProxyConfig decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ProxyConfig r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ProxyConfig r101) throws IOException {
            ProxyType.ADAPTER.encodeWithTag(r100, 1, r101.proxy_type);
            ProxyScheme r102 = r101.proxy_scheme;
            if (r102 == null) goto L5;
            ProxyScheme.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ProxyConfig r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ProxyConfig();
        DEFAULT_PROXY_TYPE = ProxyType.None;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.proxy_type = this.proxy_type;
        r100.proxy_scheme = this.proxy_scheme;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ProxyConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public ProxyConfig(ProxyType r100, ProxyScheme r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public ProxyConfig(ProxyType r100, ProxyScheme r101, ByteString r102) {
        super(ADAPTER, r102);
        this.proxy_type = r100;
        this.proxy_scheme = r101;
    }
}
