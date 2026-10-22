package com.obric.matrix.proto;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.google.gson.annotations.SerializedName;
import com.heytap.mcssdk.constant.b;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes33.dex */
public final class Request extends Message<Request, Builder> {
    public static final ProtoAdapter<Request> ADAPTER = null;
    public static final String DEFAULT_ACCESSTOKEN = "";
    public static final String DEFAULT_APPKEY = "";
    public static final String DEFAULT_APPPKG = "";
    public static final String DEFAULT_APPVERSIONCODE = "";
    public static final String DEFAULT_CHANNEL = "";
    public static final Integer DEFAULT_CMD = null;
    public static final String DEFAULT_DEVICEID = "";
    public static final String DEFAULT_SDKVERSION = "";
    public static final String DEFAULT_SEQUENCEID = "";
    private static final long serialVersionUID = 0;

    @SerializedName("accessToken")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 12)
    public final String accessToken;

    @SerializedName(b.f276376z)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String appKey;

    @SerializedName("appPkg")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final String appPkg;

    @SerializedName(DBDefinition.APP_VERSION_CODE)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String appVersionCode;

    @SerializedName(ContainerPosition.BODY)
    @WireField(adapter = "com.obric.matrix.proto.RequestBody#ADAPTER", tag = 11)
    public final RequestBody body;

    @SerializedName("channel")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String channel;

    @SerializedName("cmd")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer cmd;

    @SerializedName("deviceId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String deviceId;

    @SerializedName("extraParams")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final Map<String, String> extraParams;

    @SerializedName("monitorInfo")
    @WireField(adapter = "com.obric.matrix.proto.MonitorInfo#ADAPTER", tag = 13)
    public final MonitorInfo monitorInfo;

    @SerializedName(b.C)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String sdkVersion;

    @SerializedName("sequenceId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String sequenceId;

    public static final class Builder extends Message.Builder<Request, Builder> {
        public String accessToken;
        public String appKey;
        public String appPkg;
        public String appVersionCode;
        public RequestBody body;
        public String channel;
        public Integer cmd;
        public String deviceId;
        public Map<String, String> extraParams;
        public MonitorInfo monitorInfo;
        public String sdkVersion;
        public String sequenceId;

        @Override // com.squareup.wire.Message.Builder
        public Request build() {
            return new Request(this.cmd, this.sequenceId, this.sdkVersion, this.appKey, this.deviceId, this.channel, this.appVersionCode, this.extraParams, this.appPkg, this.body, this.accessToken, this.monitorInfo, super.buildUnknownFields());
        }

        public Builder() {
            this.cmd = 0;
            this.sequenceId = "";
            this.sdkVersion = "";
            this.appKey = "";
            this.deviceId = "";
            this.channel = "";
            this.appVersionCode = "";
            this.appPkg = "";
            this.accessToken = "";
            this.extraParams = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder accessToken(String r100) {
            this.accessToken = r100;
            return this;
        }

        public Builder appKey(String r100) {
            this.appKey = r100;
            return this;
        }

        public Builder appPkg(String r100) {
            this.appPkg = r100;
            return this;
        }

        public Builder appVersionCode(String r100) {
            this.appVersionCode = r100;
            return this;
        }

        public Builder body(RequestBody r100) {
            this.body = r100;
            return this;
        }

        public Builder channel(String r100) {
            this.channel = r100;
            return this;
        }

        public Builder cmd(Integer r100) {
            this.cmd = r100;
            return this;
        }

        public Builder deviceId(String r100) {
            this.deviceId = r100;
            return this;
        }

        public Builder extraParams(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.extraParams = r100;
            return this;
        }

        public Builder monitorInfo(MonitorInfo r100) {
            this.monitorInfo = r100;
            return this;
        }

        public Builder sdkVersion(String r100) {
            this.sdkVersion = r100;
            return this;
        }

        public Builder sequenceId(String r100) {
            this.sequenceId = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Request extends ProtoAdapter<Request> {
        private final ProtoAdapter<Map<String, String>> extraParams;

        public ProtoAdapter_Request() {
            super(FieldEncoding.LENGTH_DELIMITED, Request.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.extraParams = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Request decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L19;
            switch(r103) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L12;
                case 8: goto L6;
                case 9: goto L11;
                case 10: goto L10;
                case 11: goto L9;
                case 12: goto L8;
                case 13: goto L7;
                default: goto L6;
            };
        L7:
            r101.monitorInfo(MonitorInfo.ADAPTER.decode(r100));
            goto L3
        L8:
            r101.accessToken(ProtoAdapter.STRING.decode(r100));
            goto L3
        L9:
            r101.body(RequestBody.ADAPTER.decode(r100));
            goto L3
        L10:
            r101.appPkg(ProtoAdapter.STRING.decode(r100));
            goto L3
        L11:
            r101.extraParams.putAll(this.extraParams.decode(r100));
            goto L3
        L12:
            r101.appVersionCode(ProtoAdapter.STRING.decode(r100));
            goto L3
        L13:
            r101.channel(ProtoAdapter.STRING.decode(r100));
            goto L3
        L14:
            r101.deviceId(ProtoAdapter.STRING.decode(r100));
            goto L3
        L15:
            r101.appKey(ProtoAdapter.STRING.decode(r100));
            goto L3
        L16:
            r101.sdkVersion(ProtoAdapter.STRING.decode(r100));
            goto L3
        L17:
            r101.sequenceId(ProtoAdapter.STRING.decode(r100));
            goto L3
        L18:
            r101.cmd(ProtoAdapter.INT32.decode(r100));
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
        public int encodedSize2(Request r100) {
            int r101 = ProtoAdapter.INT32.encodedSizeWithTag(1, r100.cmd);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            return (((((((((((r101 + r102.encodedSizeWithTag(2, r100.sequenceId)) + r102.encodedSizeWithTag(3, r100.sdkVersion)) + r102.encodedSizeWithTag(4, r100.appKey)) + r102.encodedSizeWithTag(5, r100.deviceId)) + r102.encodedSizeWithTag(6, r100.channel)) + r102.encodedSizeWithTag(7, r100.appVersionCode)) + this.extraParams.encodedSizeWithTag(9, r100.extraParams)) + r102.encodedSizeWithTag(10, r100.appPkg)) + RequestBody.ADAPTER.encodedSizeWithTag(11, r100.body)) + r102.encodedSizeWithTag(12, r100.accessToken)) + MonitorInfo.ADAPTER.encodedSizeWithTag(13, r100.monitorInfo)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public Request redact2(Request r100) {
            Builder r101 = r100.newBuilder();
            RequestBody r102 = r101.body;
            if (r102 == null) goto L5;
            r101.body = RequestBody.ADAPTER.redact(r102);
        L5:
            MonitorInfo r103 = r101.monitorInfo;
            if (r103 == null) goto L8;
            r101.monitorInfo = MonitorInfo.ADAPTER.redact(r103);
        L8:
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Request decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Request r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Request redact(Request r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Request r101) throws IOException {
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r101.cmd);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 2, r101.sequenceId);
            r102.encodeWithTag(r100, 3, r101.sdkVersion);
            r102.encodeWithTag(r100, 4, r101.appKey);
            r102.encodeWithTag(r100, 5, r101.deviceId);
            r102.encodeWithTag(r100, 6, r101.channel);
            r102.encodeWithTag(r100, 7, r101.appVersionCode);
            this.extraParams.encodeWithTag(r100, 9, r101.extraParams);
            r102.encodeWithTag(r100, 10, r101.appPkg);
            RequestBody.ADAPTER.encodeWithTag(r100, 11, r101.body);
            r102.encodeWithTag(r100, 12, r101.accessToken);
            MonitorInfo.ADAPTER.encodeWithTag(r100, 13, r101.monitorInfo);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Request r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Request();
        DEFAULT_CMD = 0;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L49;
        int r101 = unknownFields().hashCode() * 37;
        Integer r102 = this.cmd;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.hashCode();
    L8:
        int r105 = (r101 + r104) * 37;
        String r106 = this.sequenceId;
        if (r106 == null) goto L11;
        int r107 = r106.hashCode();
    L12:
        int r108 = (r105 + r107) * 37;
        String r109 = this.sdkVersion;
        if (r109 == null) goto L15;
        int r110 = r109.hashCode();
    L16:
        int r111 = (r108 + r110) * 37;
        String r112 = this.appKey;
        if (r112 == null) goto L19;
        int r113 = r112.hashCode();
    L20:
        int r114 = (r111 + r113) * 37;
        String r115 = this.deviceId;
        if (r115 == null) goto L23;
        int r116 = r115.hashCode();
    L24:
        int r117 = (r114 + r116) * 37;
        String r118 = this.channel;
        if (r118 == null) goto L27;
        int r119 = r118.hashCode();
    L28:
        int r120 = (r117 + r119) * 37;
        String r121 = this.appVersionCode;
        if (r121 == null) goto L31;
        int r122 = r121.hashCode();
    L32:
        int r123 = (((r120 + r122) * 37) + this.extraParams.hashCode()) * 37;
        String r124 = this.appPkg;
        if (r124 == null) goto L35;
        int r125 = r124.hashCode();
    L36:
        int r126 = (r123 + r125) * 37;
        RequestBody r127 = this.body;
        if (r127 == null) goto L39;
        int r128 = r127.hashCode();
    L40:
        int r129 = (r126 + r128) * 37;
        String r130 = this.accessToken;
        if (r130 == null) goto L43;
        int r131 = r130.hashCode();
    L44:
        int r132 = (r129 + r131) * 37;
        MonitorInfo r133 = this.monitorInfo;
        if (r133 == null) goto L47;
        r103 = r133.hashCode();
    L47:
        int r134 = r132 + r103;
        this.hashCode = r134;
        return r134;
    L43:
        r131 = 0;
        goto L44
    L39:
        r128 = 0;
        goto L40
    L35:
        r125 = 0;
        goto L36
    L31:
        r122 = 0;
        goto L32
    L27:
        r119 = 0;
        goto L28
    L23:
        r116 = 0;
        goto L24
    L19:
        r113 = 0;
        goto L20
    L15:
        r110 = 0;
        goto L16
    L11:
        r107 = 0;
        goto L12
    L7:
        r104 = 0;
        goto L8
    L49:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.cmd = this.cmd;
        r100.sequenceId = this.sequenceId;
        r100.sdkVersion = this.sdkVersion;
        r100.appKey = this.appKey;
        r100.deviceId = this.deviceId;
        r100.channel = this.channel;
        r100.appVersionCode = this.appVersionCode;
        r100.extraParams = Internal.copyOf("extraParams", this.extraParams);
        r100.appPkg = this.appPkg;
        r100.body = this.body;
        r100.accessToken = this.accessToken;
        r100.monitorInfo = this.monitorInfo;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.cmd == null) goto L6;
        r100.append(", cmd=");
        r100.append(this.cmd);
    L6:
        if (this.sequenceId == null) goto L9;
        r100.append(", sequenceId=");
        r100.append(this.sequenceId);
    L9:
        if (this.sdkVersion == null) goto L12;
        r100.append(", sdkVersion=");
        r100.append(this.sdkVersion);
    L12:
        if (this.appKey == null) goto L15;
        r100.append(", appKey=");
        r100.append(this.appKey);
    L15:
        if (this.deviceId == null) goto L18;
        r100.append(", deviceId=");
        r100.append(this.deviceId);
    L18:
        if (this.channel == null) goto L21;
        r100.append(", channel=");
        r100.append(this.channel);
    L21:
        if (this.appVersionCode == null) goto L23;
        r100.append(", appVersionCode=");
        r100.append(this.appVersionCode);
    L23:
        Map<String, String> r101 = this.extraParams;
        if (r101 == null) goto L29;
        if (r101.isEmpty() == true) goto L29;
        r100.append(", extraParams=");
        r100.append(this.extraParams);
    L29:
        if (this.appPkg == null) goto L32;
        r100.append(", appPkg=");
        r100.append(this.appPkg);
    L32:
        if (this.body == null) goto L35;
        r100.append(", body=");
        r100.append(this.body);
    L35:
        if (this.accessToken == null) goto L38;
        r100.append(", accessToken=");
        r100.append(this.accessToken);
    L38:
        if (this.monitorInfo == null) goto L40;
        r100.append(", monitorInfo=");
        r100.append(this.monitorInfo);
    L40:
        StringBuilder r102 = r100.replace(0, 2, "Request{");
        r102.append('}');
        return r102.toString();
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof Request) == true) goto L8;
        return false;
    L8:
        Request r101 = (Request) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L35:
        return false;
    L11:
        if (Internal.equals(this.cmd, r101.cmd) == false) goto L35;
        if (Internal.equals(this.sequenceId, r101.sequenceId) == false) goto L35;
        if (Internal.equals(this.sdkVersion, r101.sdkVersion) == false) goto L35;
        if (Internal.equals(this.appKey, r101.appKey) == false) goto L35;
        if (Internal.equals(this.deviceId, r101.deviceId) == false) goto L35;
        if (Internal.equals(this.channel, r101.channel) == false) goto L35;
        if (Internal.equals(this.appVersionCode, r101.appVersionCode) == false) goto L35;
        if (this.extraParams.equals(r101.extraParams) == false) goto L35;
        if (Internal.equals(this.appPkg, r101.appPkg) == false) goto L35;
        if (Internal.equals(this.body, r101.body) == false) goto L35;
        if (Internal.equals(this.accessToken, r101.accessToken) == false) goto L35;
        if (Internal.equals(this.monitorInfo, r101.monitorInfo) == false) goto L35;
        return true;
    }

    public Request(Integer r110, String r111, String r112, String r113, String r114, String r210, String r211, Map<String, String> r212, String r213, RequestBody r214, String r215, MonitorInfo r216) {
        this(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216, ByteString.EMPTY);
    }

    public Request(Integer r100, String r101, String r102, String r103, String r104, String r105, String r106, Map<String, String> r107, String r110, RequestBody r111, String r112, MonitorInfo r113, ByteString r114) {
        super(ADAPTER, r114);
        this.cmd = r100;
        this.sequenceId = r101;
        this.sdkVersion = r102;
        this.appKey = r103;
        this.deviceId = r104;
        this.channel = r105;
        this.appVersionCode = r106;
        this.extraParams = Internal.immutableCopyOf("extraParams", r107);
        this.appPkg = r110;
        this.body = r111;
        this.accessToken = r112;
        this.monitorInfo = r113;
    }
}
