package com.obric.matrix.proto;

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
public final class Response extends Message<Response, Builder> {
    public static final ProtoAdapter<Response> ADAPTER = null;
    public static final String DEFAULT_ACCESSTOKEN = "";
    public static final Integer DEFAULT_CMD = null;
    public static final String DEFAULT_ERRORMSG = "";
    public static final String DEFAULT_LOGID = "";
    public static final String DEFAULT_SEQUENCEID = "";
    public static final Integer DEFAULT_STATUSCODE = null;
    private static final long serialVersionUID = 0;

    @SerializedName("accessToken")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 8)
    public final String accessToken;

    @SerializedName(ContainerPosition.BODY)
    @WireField(adapter = "com.obric.matrix.proto.ResponseBody#ADAPTER", tag = 7)
    public final ResponseBody body;

    @SerializedName("cmd")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer cmd;

    @SerializedName("errorMsg")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String errorMsg;

    @SerializedName("extraParams")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final Map<String, String> extraParams;

    @SerializedName("logId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String logId;

    @SerializedName("monitorInfo")
    @WireField(adapter = "com.obric.matrix.proto.MonitorInfo#ADAPTER", tag = 9)
    public final MonitorInfo monitorInfo;

    @SerializedName("sequenceId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String sequenceId;

    @SerializedName("statusCode")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer statusCode;

    public static final class Builder extends Message.Builder<Response, Builder> {
        public String accessToken;
        public ResponseBody body;
        public Integer cmd;
        public String errorMsg;
        public Map<String, String> extraParams;
        public String logId;
        public MonitorInfo monitorInfo;
        public String sequenceId;
        public Integer statusCode;

        @Override // com.squareup.wire.Message.Builder
        public Response build() {
            return new Response(this.cmd, this.statusCode, this.errorMsg, this.logId, this.sequenceId, this.body, this.accessToken, this.monitorInfo, this.extraParams, super.buildUnknownFields());
        }

        public Builder() {
            this.cmd = 0;
            this.statusCode = 0;
            this.errorMsg = "";
            this.logId = "";
            this.sequenceId = "";
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

        public Builder body(ResponseBody r100) {
            this.body = r100;
            return this;
        }

        public Builder cmd(Integer r100) {
            this.cmd = r100;
            return this;
        }

        public Builder errorMsg(String r100) {
            this.errorMsg = r100;
            return this;
        }

        public Builder extraParams(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.extraParams = r100;
            return this;
        }

        public Builder logId(String r100) {
            this.logId = r100;
            return this;
        }

        public Builder monitorInfo(MonitorInfo r100) {
            this.monitorInfo = r100;
            return this;
        }

        public Builder sequenceId(String r100) {
            this.sequenceId = r100;
            return this;
        }

        public Builder statusCode(Integer r100) {
            this.statusCode = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Response extends ProtoAdapter<Response> {
        private final ProtoAdapter<Map<String, String>> extraParams;

        public ProtoAdapter_Response() {
            super(FieldEncoding.LENGTH_DELIMITED, Response.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.extraParams = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Response decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L16;
            switch(r103) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L6;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                case 10: goto L7;
                default: goto L6;
            };
        L7:
            r101.extraParams.putAll(this.extraParams.decode(r100));
            goto L3
        L8:
            r101.monitorInfo(MonitorInfo.ADAPTER.decode(r100));
            goto L3
        L9:
            r101.accessToken(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            r101.body(ResponseBody.ADAPTER.decode(r100));
            goto L3
        L11:
            r101.sequenceId(ProtoAdapter.STRING.decode(r100));
            goto L3
        L12:
            r101.logId(ProtoAdapter.STRING.decode(r100));
            goto L3
        L13:
            r101.errorMsg(ProtoAdapter.STRING.decode(r100));
            goto L3
        L14:
            r101.statusCode(ProtoAdapter.INT32.decode(r100));
            goto L3
        L15:
            r101.cmd(ProtoAdapter.INT32.decode(r100));
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L16:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Response r100) {
            ProtoAdapter<Integer> r101 = ProtoAdapter.INT32;
            int r102 = r101.encodedSizeWithTag(1, r100.cmd) + r101.encodedSizeWithTag(2, r100.statusCode);
            ProtoAdapter<String> r103 = ProtoAdapter.STRING;
            return (((((((r102 + r103.encodedSizeWithTag(3, r100.errorMsg)) + r103.encodedSizeWithTag(4, r100.logId)) + r103.encodedSizeWithTag(6, r100.sequenceId)) + ResponseBody.ADAPTER.encodedSizeWithTag(7, r100.body)) + r103.encodedSizeWithTag(8, r100.accessToken)) + MonitorInfo.ADAPTER.encodedSizeWithTag(9, r100.monitorInfo)) + this.extraParams.encodedSizeWithTag(10, r100.extraParams)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public Response redact2(Response r100) {
            Builder r101 = r100.newBuilder();
            ResponseBody r102 = r101.body;
            if (r102 == null) goto L5;
            r101.body = ResponseBody.ADAPTER.redact(r102);
        L5:
            MonitorInfo r103 = r101.monitorInfo;
            if (r103 == null) goto L8;
            r101.monitorInfo = MonitorInfo.ADAPTER.redact(r103);
        L8:
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Response decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Response r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Response redact(Response r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Response r101) throws IOException {
            ProtoAdapter<Integer> r102 = ProtoAdapter.INT32;
            r102.encodeWithTag(r100, 1, r101.cmd);
            r102.encodeWithTag(r100, 2, r101.statusCode);
            ProtoAdapter<String> r103 = ProtoAdapter.STRING;
            r103.encodeWithTag(r100, 3, r101.errorMsg);
            r103.encodeWithTag(r100, 4, r101.logId);
            r103.encodeWithTag(r100, 6, r101.sequenceId);
            ResponseBody.ADAPTER.encodeWithTag(r100, 7, r101.body);
            r103.encodeWithTag(r100, 8, r101.accessToken);
            MonitorInfo.ADAPTER.encodeWithTag(r100, 9, r101.monitorInfo);
            this.extraParams.encodeWithTag(r100, 10, r101.extraParams);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Response r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Response();
        DEFAULT_CMD = 0;
        DEFAULT_STATUSCODE = 0;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L37;
        int r101 = unknownFields().hashCode() * 37;
        Integer r102 = this.cmd;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.hashCode();
    L8:
        int r105 = (r101 + r104) * 37;
        Integer r106 = this.statusCode;
        if (r106 == null) goto L11;
        int r107 = r106.hashCode();
    L12:
        int r108 = (r105 + r107) * 37;
        String r109 = this.errorMsg;
        if (r109 == null) goto L15;
        int r110 = r109.hashCode();
    L16:
        int r111 = (r108 + r110) * 37;
        String r112 = this.logId;
        if (r112 == null) goto L19;
        int r113 = r112.hashCode();
    L20:
        int r114 = (r111 + r113) * 37;
        String r115 = this.sequenceId;
        if (r115 == null) goto L23;
        int r116 = r115.hashCode();
    L24:
        int r117 = (r114 + r116) * 37;
        ResponseBody r118 = this.body;
        if (r118 == null) goto L27;
        int r119 = r118.hashCode();
    L28:
        int r120 = (r117 + r119) * 37;
        String r121 = this.accessToken;
        if (r121 == null) goto L31;
        int r122 = r121.hashCode();
    L32:
        int r123 = (r120 + r122) * 37;
        MonitorInfo r124 = this.monitorInfo;
        if (r124 == null) goto L35;
        r103 = r124.hashCode();
    L35:
        int r125 = ((r123 + r103) * 37) + this.extraParams.hashCode();
        this.hashCode = r125;
        return r125;
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
    L37:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.cmd = this.cmd;
        r100.statusCode = this.statusCode;
        r100.errorMsg = this.errorMsg;
        r100.logId = this.logId;
        r100.sequenceId = this.sequenceId;
        r100.body = this.body;
        r100.accessToken = this.accessToken;
        r100.monitorInfo = this.monitorInfo;
        r100.extraParams = Internal.copyOf("extraParams", this.extraParams);
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
        if (this.statusCode == null) goto L9;
        r100.append(", statusCode=");
        r100.append(this.statusCode);
    L9:
        if (this.errorMsg == null) goto L12;
        r100.append(", errorMsg=");
        r100.append(this.errorMsg);
    L12:
        if (this.logId == null) goto L15;
        r100.append(", logId=");
        r100.append(this.logId);
    L15:
        if (this.sequenceId == null) goto L18;
        r100.append(", sequenceId=");
        r100.append(this.sequenceId);
    L18:
        if (this.body == null) goto L21;
        r100.append(", body=");
        r100.append(this.body);
    L21:
        if (this.accessToken == null) goto L24;
        r100.append(", accessToken=");
        r100.append(this.accessToken);
    L24:
        if (this.monitorInfo == null) goto L26;
        r100.append(", monitorInfo=");
        r100.append(this.monitorInfo);
    L26:
        Map<String, String> r101 = this.extraParams;
        if (r101 != null) goto L29;
    L31:
        StringBuilder r102 = r100.replace(0, 2, "Response{");
        r102.append('}');
        return r102.toString();
    L29:
        if (r101.isEmpty() == true) goto L31;
        r100.append(", extraParams=");
        r100.append(this.extraParams);
        goto L31
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof Response) == true) goto L8;
        return false;
    L8:
        Response r101 = (Response) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L29:
        return false;
    L11:
        if (Internal.equals(this.cmd, r101.cmd) == false) goto L29;
        if (Internal.equals(this.statusCode, r101.statusCode) == false) goto L29;
        if (Internal.equals(this.errorMsg, r101.errorMsg) == false) goto L29;
        if (Internal.equals(this.logId, r101.logId) == false) goto L29;
        if (Internal.equals(this.sequenceId, r101.sequenceId) == false) goto L29;
        if (Internal.equals(this.body, r101.body) == false) goto L29;
        if (Internal.equals(this.accessToken, r101.accessToken) == false) goto L29;
        if (Internal.equals(this.monitorInfo, r101.monitorInfo) == false) goto L29;
        if (this.extraParams.equals(r101.extraParams) == false) goto L29;
        return true;
    }

    public Response(Integer r110, Integer r111, String r112, String r113, String r114, ResponseBody r115, String r116, MonitorInfo r117, Map<String, String> r210) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
    }

    public Response(Integer r100, Integer r101, String r102, String r103, String r104, ResponseBody r105, String r106, MonitorInfo r107, Map<String, String> r110, ByteString r111) {
        super(ADAPTER, r111);
        this.cmd = r100;
        this.statusCode = r101;
        this.errorMsg = r102;
        this.logId = r103;
        this.sequenceId = r104;
        this.body = r105;
        this.accessToken = r106;
        this.monitorInfo = r107;
        this.extraParams = Internal.immutableCopyOf("extraParams", r110);
    }
}
