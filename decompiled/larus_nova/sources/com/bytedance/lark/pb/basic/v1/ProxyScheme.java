package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class ProxyScheme extends com.squareup.wire.Message<ProxyScheme, Builder> {
    public static final ProtoAdapter<ProxyScheme> ADAPTER = null;
    public static final String DEFAULT_BYPASS_LIST = "";
    public static final String DEFAULT_HOST = "";
    public static final String DEFAULT_PASSWORD = "";
    public static final Integer DEFAULT_PORT = null;
    public static final String DEFAULT_USERNAME = "";
    private static final long serialVersionUID = 0;
    public final String bypass_list;
    public final String host;
    public final String password;
    public final Integer port;
    public final String username;

    public static final class Builder extends com.squareup.wire.Message.Builder<ProxyScheme, Builder> {
        public String bypass_list;
        public String host;
        public String password;
        public Integer port;
        public String username;

        @Override // com.squareup.wire.Message.Builder
        public ProxyScheme build() {
            String r100 = this.host;
            if (r100 == null) goto L9;
            if (this.port == null) goto L9;
            return new ProxyScheme(this.host, this.port, this.username, this.password, this.bypass_list, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "host", this.port, "port"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder bypass_list(String r100) {
            this.bypass_list = r100;
            return this;
        }

        public Builder host(String r100) {
            this.host = r100;
            return this;
        }

        public Builder password(String r100) {
            this.password = r100;
            return this;
        }

        public Builder port(Integer r100) {
            this.port = r100;
            return this;
        }

        public Builder username(String r100) {
            this.username = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ProxyScheme extends ProtoAdapter<ProxyScheme> {
        public ProtoAdapter_ProxyScheme() {
            super(FieldEncoding.LENGTH_DELIMITED, ProxyScheme.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ProxyScheme decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.host = "";
            r101.port = 0;
            r101.username = "";
            r101.password = "";
            r101.bypass_list = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.host = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.port = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.username = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.password = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.bypass_list = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ProxyScheme r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.host) + ProtoAdapter.INT32.encodedSizeWithTag(2, r100.port);
            String r103 = r100.username;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(3, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.password;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(4, r107);
        L10:
            int r109 = r106 + r108;
            String r110 = r100.bypass_list;
            if (r110 == null) goto L14;
            r104 = r101.encodedSizeWithTag(5, r110);
        L14:
            return (r109 + r104) + r100.unknownFields().size();
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ProxyScheme decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ProxyScheme r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ProxyScheme r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.host);
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r101.port);
            String r103 = r101.username;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 3, r103);
        L5:
            String r104 = r101.password;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 4, r104);
        L8:
            String r105 = r101.bypass_list;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 5, r105);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ProxyScheme r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ProxyScheme();
        DEFAULT_PORT = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.host = this.host;
        r100.port = this.port;
        r100.username = this.username;
        r100.password = this.password;
        r100.bypass_list = this.bypass_list;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ProxyScheme.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public ProxyScheme(String r100, Integer r101, String r110, String r111, String r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public ProxyScheme(String r100, Integer r101, String r102, String r103, String r104, ByteString r105) {
        super(ADAPTER, r105);
        this.host = r100;
        this.port = r101;
        this.username = r102;
        this.password = r103;
        this.bypass_list = r104;
    }
}
