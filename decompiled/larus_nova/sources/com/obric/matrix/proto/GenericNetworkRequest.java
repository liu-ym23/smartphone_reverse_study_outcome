package com.obric.matrix.proto;

import com.alipay.sdk.m.p.e;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes33.dex */
public final class GenericNetworkRequest extends Message<GenericNetworkRequest, Builder> {
    public static final ProtoAdapter<GenericNetworkRequest> ADAPTER = null;
    public static final String DEFAULT_ACCESSTOKEN = "";
    public static final ByteString DEFAULT_BODY = null;
    public static final NETWORK_METHOD DEFAULT_METHOD = null;
    public static final Boolean DEFAULT_NEEDACCESSTOKEN = null;
    public static final String DEFAULT_PATH = "";
    private static final long serialVersionUID = 0;

    @SerializedName("accessToken")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String accessToken;

    @SerializedName(ContainerPosition.BODY)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 5)
    public final ByteString body;

    @SerializedName("headerParams")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final Map<String, String> headerParams;

    @SerializedName(e.f25671s)
    @WireField(adapter = "com.obric.matrix.proto.NETWORK_METHOD#ADAPTER", label = WireField.Label.REQUIRED, tag = 2)
    public final NETWORK_METHOD method;

    @SerializedName("needAccessToken")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 6)
    public final Boolean needAccessToken;

    @SerializedName("path")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 1)
    public final String path;

    @SerializedName("queryParams")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final Map<String, String> queryParams;

    public static final class Builder extends Message.Builder<GenericNetworkRequest, Builder> {
        public String accessToken;
        public ByteString body;
        public Map<String, String> headerParams;
        public NETWORK_METHOD method;
        public Boolean needAccessToken;
        public String path;
        public Map<String, String> queryParams;

        @Override // com.squareup.wire.Message.Builder
        public GenericNetworkRequest build() {
            String r100 = this.path;
            if (r100 == null) goto L9;
            if (this.method == null) goto L9;
            return new GenericNetworkRequest(this.path, this.method, this.headerParams, this.queryParams, this.body, this.needAccessToken, this.accessToken, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "path", this.method, e.f25671s});
        }

        public Builder() {
            this.path = "";
            this.method = NETWORK_METHOD.METHOD_GET;
            this.body = ByteString.EMPTY;
            this.needAccessToken = Boolean.FALSE;
            this.accessToken = "";
            this.headerParams = Internal.newMutableMap();
            this.queryParams = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder accessToken(String r100) {
            this.accessToken = r100;
            return this;
        }

        public Builder body(ByteString r100) {
            this.body = r100;
            return this;
        }

        public Builder headerParams(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.headerParams = r100;
            return this;
        }

        public Builder method(NETWORK_METHOD r100) {
            this.method = r100;
            return this;
        }

        public Builder needAccessToken(Boolean r100) {
            this.needAccessToken = r100;
            return this;
        }

        public Builder path(String r100) {
            this.path = r100;
            return this;
        }

        public Builder queryParams(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.queryParams = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GenericNetworkRequest extends ProtoAdapter<GenericNetworkRequest> {
        private final ProtoAdapter<Map<String, String>> headerParams;
        private final ProtoAdapter<Map<String, String>> queryParams;

        public ProtoAdapter_GenericNetworkRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GenericNetworkRequest.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.headerParams = ProtoAdapter.newMapAdapter(r100, r100);
            this.queryParams = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GenericNetworkRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L17;
            switch(r103) {
                case 1: goto L16;
                case 2: goto L19;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L19:
            r101.method(NETWORK_METHOD.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.accessToken(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            r101.needAccessToken(ProtoAdapter.BOOL.decode(r100));
            goto L3
        L9:
            r101.body(ProtoAdapter.BYTES.decode(r100));
            goto L3
        L10:
            r101.queryParams.putAll(this.queryParams.decode(r100));
            goto L3
        L11:
            r101.headerParams.putAll(this.headerParams.decode(r100));
            goto L3
        L16:
            r101.path(ProtoAdapter.STRING.decode(r100));
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L17:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GenericNetworkRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return ((((((r101.encodedSizeWithTag(1, r100.path) + NETWORK_METHOD.ADAPTER.encodedSizeWithTag(2, r100.method)) + this.headerParams.encodedSizeWithTag(3, r100.headerParams)) + this.queryParams.encodedSizeWithTag(4, r100.queryParams)) + ProtoAdapter.BYTES.encodedSizeWithTag(5, r100.body)) + ProtoAdapter.BOOL.encodedSizeWithTag(6, r100.needAccessToken)) + r101.encodedSizeWithTag(7, r100.accessToken)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public GenericNetworkRequest redact2(GenericNetworkRequest r100) {
            Builder r101 = r100.newBuilder();
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GenericNetworkRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GenericNetworkRequest r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GenericNetworkRequest redact(GenericNetworkRequest r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GenericNetworkRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.path);
            NETWORK_METHOD.ADAPTER.encodeWithTag(r100, 2, r101.method);
            this.headerParams.encodeWithTag(r100, 3, r101.headerParams);
            this.queryParams.encodeWithTag(r100, 4, r101.queryParams);
            ProtoAdapter.BYTES.encodeWithTag(r100, 5, r101.body);
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r101.needAccessToken);
            r102.encodeWithTag(r100, 7, r101.accessToken);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GenericNetworkRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GenericNetworkRequest();
        DEFAULT_METHOD = NETWORK_METHOD.METHOD_GET;
        DEFAULT_BODY = ByteString.EMPTY;
        DEFAULT_NEEDACCESSTOKEN = Boolean.FALSE;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L17;
        int r101 = ((((((((unknownFields().hashCode() * 37) + this.path.hashCode()) * 37) + this.method.hashCode()) * 37) + this.headerParams.hashCode()) * 37) + this.queryParams.hashCode()) * 37;
        ByteString r102 = this.body;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.hashCode();
    L8:
        int r105 = (r101 + r104) * 37;
        Boolean r106 = this.needAccessToken;
        if (r106 == null) goto L11;
        int r107 = r106.hashCode();
    L12:
        int r108 = (r105 + r107) * 37;
        String r109 = this.accessToken;
        if (r109 == null) goto L15;
        r103 = r109.hashCode();
    L15:
        int r110 = r108 + r103;
        this.hashCode = r110;
        return r110;
    L11:
        r107 = 0;
        goto L12
    L7:
        r104 = 0;
        goto L8
    L17:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.path = this.path;
        r100.method = this.method;
        r100.headerParams = Internal.copyOf("headerParams", this.headerParams);
        r100.queryParams = Internal.copyOf("queryParams", this.queryParams);
        r100.body = this.body;
        r100.needAccessToken = this.needAccessToken;
        r100.accessToken = this.accessToken;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(", path=");
        r100.append(this.path);
        r100.append(", method=");
        r100.append(this.method);
        Map<String, String> r101 = this.headerParams;
        if (r101 != null) goto L5;
    L7:
        Map<String, String> r102 = this.queryParams;
        if (r102 == null) goto L13;
        if (r102.isEmpty() == true) goto L13;
        r100.append(", queryParams=");
        r100.append(this.queryParams);
    L13:
        if (this.body == null) goto L16;
        r100.append(", body=");
        r100.append(this.body);
    L16:
        if (this.needAccessToken == null) goto L19;
        r100.append(", needAccessToken=");
        r100.append(this.needAccessToken);
    L19:
        if (this.accessToken == null) goto L21;
        r100.append(", accessToken=");
        r100.append(this.accessToken);
    L21:
        StringBuilder r103 = r100.replace(0, 2, "GenericNetworkRequest{");
        r103.append('}');
        return r103.toString();
    L5:
        if (r101.isEmpty() == true) goto L7;
        r100.append(", headerParams=");
        r100.append(this.headerParams);
        goto L7
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof GenericNetworkRequest) == true) goto L8;
        return false;
    L8:
        GenericNetworkRequest r101 = (GenericNetworkRequest) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L25:
        return false;
    L11:
        if (this.path.equals(r101.path) == false) goto L25;
        if (this.method.equals(r101.method) == false) goto L25;
        if (this.headerParams.equals(r101.headerParams) == false) goto L25;
        if (this.queryParams.equals(r101.queryParams) == false) goto L25;
        if (Internal.equals(this.body, r101.body) == false) goto L25;
        if (Internal.equals(this.needAccessToken, r101.needAccessToken) == false) goto L25;
        if (Internal.equals(this.accessToken, r101.accessToken) == false) goto L25;
        return true;
    }

    public GenericNetworkRequest(String r110, NETWORK_METHOD r111, Map<String, String> r112, Map<String, String> r113, ByteString r114, Boolean r115, String r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public GenericNetworkRequest(String r100, NETWORK_METHOD r101, Map<String, String> r102, Map<String, String> r103, ByteString r104, Boolean r105, String r106, ByteString r107) {
        super(ADAPTER, r107);
        this.path = r100;
        this.method = r101;
        this.headerParams = Internal.immutableCopyOf("headerParams", r102);
        this.queryParams = Internal.immutableCopyOf("queryParams", r103);
        this.body = r104;
        this.needAccessToken = r105;
        this.accessToken = r106;
    }
}
