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
public final class OnePartyCommonNetworkRequest extends Message<OnePartyCommonNetworkRequest, Builder> {
    public static final ProtoAdapter<OnePartyCommonNetworkRequest> ADAPTER = null;
    public static final Boolean DEFAULT_ADDCOMMONPARAM = null;
    public static final ByteString DEFAULT_BODY = null;
    public static final String DEFAULT_HOST = "";
    public static final NETWORK_METHOD DEFAULT_METHOD = null;
    public static final String DEFAULT_PATH = "";
    private static final long serialVersionUID = 0;

    @SerializedName("addCommonParam")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 8)
    public final Boolean addCommonParam;

    @SerializedName(ContainerPosition.BODY)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 6)
    public final ByteString body;

    @SerializedName("extraMap")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final Map<String, String> extraMap;

    @SerializedName("fieldMap")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final Map<String, String> fieldMap;

    @SerializedName("headerParams")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final Map<String, String> headerParams;

    @SerializedName("host")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String host;

    @SerializedName(e.f25671s)
    @WireField(adapter = "com.obric.matrix.proto.NETWORK_METHOD#ADAPTER", label = WireField.Label.REQUIRED, tag = 3)
    public final NETWORK_METHOD method;

    @SerializedName("path")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String path;

    @SerializedName("queryParams")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final Map<String, String> queryParams;

    public static final class Builder extends Message.Builder<OnePartyCommonNetworkRequest, Builder> {
        public Boolean addCommonParam;
        public ByteString body;
        public Map<String, String> extraMap;
        public Map<String, String> fieldMap;
        public Map<String, String> headerParams;
        public String host;
        public NETWORK_METHOD method;
        public String path;
        public Map<String, String> queryParams;

        @Override // com.squareup.wire.Message.Builder
        public OnePartyCommonNetworkRequest build() {
            NETWORK_METHOD r100 = this.method;
            if (r100 == null) goto L7;
            return new OnePartyCommonNetworkRequest(this.path, this.host, this.method, this.headerParams, this.queryParams, this.body, this.fieldMap, this.addCommonParam, this.extraMap, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, e.f25671s});
        }

        public Builder() {
            this.path = "";
            this.host = "";
            this.method = NETWORK_METHOD.METHOD_GET;
            this.body = ByteString.EMPTY;
            this.addCommonParam = Boolean.FALSE;
            this.headerParams = Internal.newMutableMap();
            this.queryParams = Internal.newMutableMap();
            this.fieldMap = Internal.newMutableMap();
            this.extraMap = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder addCommonParam(Boolean r100) {
            this.addCommonParam = r100;
            return this;
        }

        public Builder body(ByteString r100) {
            this.body = r100;
            return this;
        }

        public Builder extraMap(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.extraMap = r100;
            return this;
        }

        public Builder fieldMap(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.fieldMap = r100;
            return this;
        }

        public Builder headerParams(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.headerParams = r100;
            return this;
        }

        public Builder host(String r100) {
            this.host = r100;
            return this;
        }

        public Builder method(NETWORK_METHOD r100) {
            this.method = r100;
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

    public static final class ProtoAdapter_OnePartyCommonNetworkRequest extends ProtoAdapter<OnePartyCommonNetworkRequest> {
        private final ProtoAdapter<Map<String, String>> extraMap;
        private final ProtoAdapter<Map<String, String>> fieldMap;
        private final ProtoAdapter<Map<String, String>> headerParams;
        private final ProtoAdapter<Map<String, String>> queryParams;

        public ProtoAdapter_OnePartyCommonNetworkRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, OnePartyCommonNetworkRequest.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.headerParams = ProtoAdapter.newMapAdapter(r100, r100);
            this.queryParams = ProtoAdapter.newMapAdapter(r100, r100);
            this.fieldMap = ProtoAdapter.newMapAdapter(r100, r100);
            this.extraMap = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public OnePartyCommonNetworkRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L19;
            switch(r103) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L21;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L7;
                default: goto L6;
            };
        L21:
            r101.method(NETWORK_METHOD.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.extraMap.putAll(this.extraMap.decode(r100));
            goto L3
        L8:
            r101.addCommonParam(ProtoAdapter.BOOL.decode(r100));
            goto L3
        L9:
            r101.fieldMap.putAll(this.fieldMap.decode(r100));
            goto L3
        L10:
            r101.body(ProtoAdapter.BYTES.decode(r100));
            goto L3
        L11:
            r101.queryParams.putAll(this.queryParams.decode(r100));
            goto L3
        L12:
            r101.headerParams.putAll(this.headerParams.decode(r100));
            goto L3
        L17:
            r101.host(ProtoAdapter.STRING.decode(r100));
            goto L3
        L18:
            r101.path(ProtoAdapter.STRING.decode(r100));
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L19:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(OnePartyCommonNetworkRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return ((((((((r101.encodedSizeWithTag(1, r100.path) + r101.encodedSizeWithTag(2, r100.host)) + NETWORK_METHOD.ADAPTER.encodedSizeWithTag(3, r100.method)) + this.headerParams.encodedSizeWithTag(4, r100.headerParams)) + this.queryParams.encodedSizeWithTag(5, r100.queryParams)) + ProtoAdapter.BYTES.encodedSizeWithTag(6, r100.body)) + this.fieldMap.encodedSizeWithTag(7, r100.fieldMap)) + ProtoAdapter.BOOL.encodedSizeWithTag(8, r100.addCommonParam)) + this.extraMap.encodedSizeWithTag(9, r100.extraMap)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public OnePartyCommonNetworkRequest redact2(OnePartyCommonNetworkRequest r100) {
            Builder r101 = r100.newBuilder();
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ OnePartyCommonNetworkRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(OnePartyCommonNetworkRequest r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ OnePartyCommonNetworkRequest redact(OnePartyCommonNetworkRequest r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, OnePartyCommonNetworkRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.path);
            r102.encodeWithTag(r100, 2, r101.host);
            NETWORK_METHOD.ADAPTER.encodeWithTag(r100, 3, r101.method);
            this.headerParams.encodeWithTag(r100, 4, r101.headerParams);
            this.queryParams.encodeWithTag(r100, 5, r101.queryParams);
            ProtoAdapter.BYTES.encodeWithTag(r100, 6, r101.body);
            this.fieldMap.encodeWithTag(r100, 7, r101.fieldMap);
            ProtoAdapter.BOOL.encodeWithTag(r100, 8, r101.addCommonParam);
            this.extraMap.encodeWithTag(r100, 9, r101.extraMap);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OnePartyCommonNetworkRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_OnePartyCommonNetworkRequest();
        DEFAULT_METHOD = NETWORK_METHOD.METHOD_GET;
        DEFAULT_BODY = ByteString.EMPTY;
        DEFAULT_ADDCOMMONPARAM = Boolean.FALSE;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L21;
        int r101 = unknownFields().hashCode() * 37;
        String r102 = this.path;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.hashCode();
    L8:
        int r105 = (r101 + r104) * 37;
        String r106 = this.host;
        if (r106 == null) goto L11;
        int r107 = r106.hashCode();
    L12:
        int r108 = (((((((r105 + r107) * 37) + this.method.hashCode()) * 37) + this.headerParams.hashCode()) * 37) + this.queryParams.hashCode()) * 37;
        ByteString r109 = this.body;
        if (r109 == null) goto L15;
        int r110 = r109.hashCode();
    L16:
        int r111 = (((r108 + r110) * 37) + this.fieldMap.hashCode()) * 37;
        Boolean r112 = this.addCommonParam;
        if (r112 == null) goto L19;
        r103 = r112.hashCode();
    L19:
        int r113 = ((r111 + r103) * 37) + this.extraMap.hashCode();
        this.hashCode = r113;
        return r113;
    L15:
        r110 = 0;
        goto L16
    L11:
        r107 = 0;
        goto L12
    L7:
        r104 = 0;
        goto L8
    L21:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.path = this.path;
        r100.host = this.host;
        r100.method = this.method;
        r100.headerParams = Internal.copyOf("headerParams", this.headerParams);
        r100.queryParams = Internal.copyOf("queryParams", this.queryParams);
        r100.body = this.body;
        r100.fieldMap = Internal.copyOf("fieldMap", this.fieldMap);
        r100.addCommonParam = this.addCommonParam;
        r100.extraMap = Internal.copyOf("extraMap", this.extraMap);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.path == null) goto L6;
        r100.append(", path=");
        r100.append(this.path);
    L6:
        if (this.host == null) goto L8;
        r100.append(", host=");
        r100.append(this.host);
    L8:
        r100.append(", method=");
        r100.append(this.method);
        Map<String, String> r101 = this.headerParams;
        if (r101 != null) goto L11;
    L13:
        Map<String, String> r102 = this.queryParams;
        if (r102 == null) goto L19;
        if (r102.isEmpty() == true) goto L19;
        r100.append(", queryParams=");
        r100.append(this.queryParams);
    L19:
        if (this.body == null) goto L21;
        r100.append(", body=");
        r100.append(this.body);
    L21:
        Map<String, String> r103 = this.fieldMap;
        if (r103 == null) goto L27;
        if (r103.isEmpty() == true) goto L27;
        r100.append(", fieldMap=");
        r100.append(this.fieldMap);
    L27:
        if (this.addCommonParam == null) goto L29;
        r100.append(", addCommonParam=");
        r100.append(this.addCommonParam);
    L29:
        Map<String, String> r104 = this.extraMap;
        if (r104 != null) goto L32;
    L34:
        StringBuilder r105 = r100.replace(0, 2, "OnePartyCommonNetworkRequest{");
        r105.append('}');
        return r105.toString();
    L32:
        if (r104.isEmpty() == true) goto L34;
        r100.append(", extraMap=");
        r100.append(this.extraMap);
        goto L34
    L11:
        if (r101.isEmpty() == true) goto L13;
        r100.append(", headerParams=");
        r100.append(this.headerParams);
        goto L13
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof OnePartyCommonNetworkRequest) == true) goto L8;
        return false;
    L8:
        OnePartyCommonNetworkRequest r101 = (OnePartyCommonNetworkRequest) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L29:
        return false;
    L11:
        if (Internal.equals(this.path, r101.path) == false) goto L29;
        if (Internal.equals(this.host, r101.host) == false) goto L29;
        if (this.method.equals(r101.method) == false) goto L29;
        if (this.headerParams.equals(r101.headerParams) == false) goto L29;
        if (this.queryParams.equals(r101.queryParams) == false) goto L29;
        if (Internal.equals(this.body, r101.body) == false) goto L29;
        if (this.fieldMap.equals(r101.fieldMap) == false) goto L29;
        if (Internal.equals(this.addCommonParam, r101.addCommonParam) == false) goto L29;
        if (this.extraMap.equals(r101.extraMap) == false) goto L29;
        return true;
    }

    public OnePartyCommonNetworkRequest(String r110, String r111, NETWORK_METHOD r112, Map<String, String> r113, Map<String, String> r114, ByteString r115, Map<String, String> r116, Boolean r117, Map<String, String> r210) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
    }

    public OnePartyCommonNetworkRequest(String r100, String r101, NETWORK_METHOD r102, Map<String, String> r103, Map<String, String> r104, ByteString r105, Map<String, String> r106, Boolean r107, Map<String, String> r110, ByteString r111) {
        super(ADAPTER, r111);
        this.path = r100;
        this.host = r101;
        this.method = r102;
        this.headerParams = Internal.immutableCopyOf("headerParams", r103);
        this.queryParams = Internal.immutableCopyOf("queryParams", r104);
        this.body = r105;
        this.fieldMap = Internal.immutableCopyOf("fieldMap", r106);
        this.addCommonParam = r107;
        this.extraMap = Internal.immutableCopyOf("extraMap", r110);
    }
}
