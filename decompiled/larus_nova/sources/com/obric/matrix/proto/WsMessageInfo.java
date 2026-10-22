package com.obric.matrix.proto;

import com.alipay.sdk.m.p.e;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
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
public final class WsMessageInfo extends Message<WsMessageInfo, Builder> {
    public static final ProtoAdapter<WsMessageInfo> ADAPTER = null;
    public static final Integer DEFAULT_CHANNELID = null;
    public static final Integer DEFAULT_CMD = null;
    public static final Long DEFAULT_LOGID = null;
    public static final Integer DEFAULT_METHOD = null;
    public static final ByteString DEFAULT_PAYLOAD = null;
    public static final String DEFAULT_PAYLOADENCODING = "";
    public static final String DEFAULT_PAYLOADTYPE = "";
    public static final Long DEFAULT_SEQID = null;
    public static final Integer DEFAULT_SERVICE = null;
    private static final long serialVersionUID = 0;

    @SerializedName(RemoteMessageConst.Notification.CHANNEL_ID)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 10)
    public final Integer channelId;

    @SerializedName("cmd")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 9)
    public final Integer cmd;

    @SerializedName("headers")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    public final Map<String, String> headers;

    @SerializedName("logId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 2)
    public final Long logId;

    @SerializedName(e.f25671s)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    public final Integer method;

    @SerializedName(WsConstants.KEY_PAYLOAD)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 8)
    public final ByteString payload;

    @SerializedName("payloadEncoding")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String payloadEncoding;

    @SerializedName("payloadType")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String payloadType;

    @SerializedName("seqId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 1)
    public final Long seqId;

    @SerializedName("service")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer service;

    public static final class Builder extends Message.Builder<WsMessageInfo, Builder> {
        public Integer channelId;
        public Integer cmd;
        public Map<String, String> headers;
        public Long logId;
        public Integer method;
        public ByteString payload;
        public String payloadEncoding;
        public String payloadType;
        public Long seqId;
        public Integer service;

        @Override // com.squareup.wire.Message.Builder
        public WsMessageInfo build() {
            return new WsMessageInfo(this.seqId, this.logId, this.service, this.method, this.payloadType, this.payloadEncoding, this.payload, this.cmd, this.channelId, this.headers, super.buildUnknownFields());
        }

        public Builder() {
            this.seqId = 0L;
            this.logId = 0L;
            this.service = 0;
            this.method = 0;
            this.payloadType = "";
            this.payloadEncoding = "";
            this.payload = ByteString.EMPTY;
            this.cmd = 0;
            this.channelId = 0;
            this.headers = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder channelId(Integer r100) {
            this.channelId = r100;
            return this;
        }

        public Builder cmd(Integer r100) {
            this.cmd = r100;
            return this;
        }

        public Builder headers(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.headers = r100;
            return this;
        }

        public Builder logId(Long r100) {
            this.logId = r100;
            return this;
        }

        public Builder method(Integer r100) {
            this.method = r100;
            return this;
        }

        public Builder payload(ByteString r100) {
            this.payload = r100;
            return this;
        }

        public Builder payloadEncoding(String r100) {
            this.payloadEncoding = r100;
            return this;
        }

        public Builder payloadType(String r100) {
            this.payloadType = r100;
            return this;
        }

        public Builder seqId(Long r100) {
            this.seqId = r100;
            return this;
        }

        public Builder service(Integer r100) {
            this.service = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_WsMessageInfo extends ProtoAdapter<WsMessageInfo> {
        private final ProtoAdapter<Map<String, String>> headers;

        public ProtoAdapter_WsMessageInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, WsMessageInfo.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.headers = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public WsMessageInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L17;
            switch(r103) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L6;
                case 6: goto L12;
                case 7: goto L11;
                case 8: goto L10;
                case 9: goto L9;
                case 10: goto L8;
                case 11: goto L7;
                default: goto L6;
            };
        L7:
            r101.headers.putAll(this.headers.decode(r100));
            goto L3
        L8:
            r101.channelId(ProtoAdapter.INT32.decode(r100));
            goto L3
        L9:
            r101.cmd(ProtoAdapter.INT32.decode(r100));
            goto L3
        L10:
            r101.payload(ProtoAdapter.BYTES.decode(r100));
            goto L3
        L11:
            r101.payloadEncoding(ProtoAdapter.STRING.decode(r100));
            goto L3
        L12:
            r101.payloadType(ProtoAdapter.STRING.decode(r100));
            goto L3
        L13:
            r101.method(ProtoAdapter.INT32.decode(r100));
            goto L3
        L14:
            r101.service(ProtoAdapter.INT32.decode(r100));
            goto L3
        L15:
            r101.logId(ProtoAdapter.INT64.decode(r100));
            goto L3
        L16:
            r101.seqId(ProtoAdapter.INT64.decode(r100));
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
        public int encodedSize2(WsMessageInfo r100) {
            ProtoAdapter<Long> r101 = ProtoAdapter.INT64;
            int r102 = r101.encodedSizeWithTag(1, r100.seqId) + r101.encodedSizeWithTag(2, r100.logId);
            ProtoAdapter<Integer> r103 = ProtoAdapter.INT32;
            int r104 = (r102 + r103.encodedSizeWithTag(3, r100.service)) + r103.encodedSizeWithTag(4, r100.method);
            ProtoAdapter<String> r105 = ProtoAdapter.STRING;
            return ((((((r104 + r105.encodedSizeWithTag(6, r100.payloadType)) + r105.encodedSizeWithTag(7, r100.payloadEncoding)) + ProtoAdapter.BYTES.encodedSizeWithTag(8, r100.payload)) + r103.encodedSizeWithTag(9, r100.cmd)) + r103.encodedSizeWithTag(10, r100.channelId)) + this.headers.encodedSizeWithTag(11, r100.headers)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public WsMessageInfo redact2(WsMessageInfo r100) {
            Builder r101 = r100.newBuilder();
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ WsMessageInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(WsMessageInfo r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ WsMessageInfo redact(WsMessageInfo r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, WsMessageInfo r101) throws IOException {
            ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
            r102.encodeWithTag(r100, 1, r101.seqId);
            r102.encodeWithTag(r100, 2, r101.logId);
            ProtoAdapter<Integer> r103 = ProtoAdapter.INT32;
            r103.encodeWithTag(r100, 3, r101.service);
            r103.encodeWithTag(r100, 4, r101.method);
            ProtoAdapter<String> r104 = ProtoAdapter.STRING;
            r104.encodeWithTag(r100, 6, r101.payloadType);
            r104.encodeWithTag(r100, 7, r101.payloadEncoding);
            ProtoAdapter.BYTES.encodeWithTag(r100, 8, r101.payload);
            r103.encodeWithTag(r100, 9, r101.cmd);
            r103.encodeWithTag(r100, 10, r101.channelId);
            this.headers.encodeWithTag(r100, 11, r101.headers);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, WsMessageInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_WsMessageInfo();
        DEFAULT_SEQID = 0L;
        DEFAULT_LOGID = 0L;
        DEFAULT_SERVICE = 0;
        DEFAULT_METHOD = 0;
        DEFAULT_PAYLOAD = ByteString.EMPTY;
        DEFAULT_CMD = 0;
        DEFAULT_CHANNELID = 0;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L41;
        int r101 = unknownFields().hashCode() * 37;
        Long r102 = this.seqId;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.hashCode();
    L8:
        int r105 = (r101 + r104) * 37;
        Long r106 = this.logId;
        if (r106 == null) goto L11;
        int r107 = r106.hashCode();
    L12:
        int r108 = (r105 + r107) * 37;
        Integer r109 = this.service;
        if (r109 == null) goto L15;
        int r110 = r109.hashCode();
    L16:
        int r111 = (r108 + r110) * 37;
        Integer r112 = this.method;
        if (r112 == null) goto L19;
        int r113 = r112.hashCode();
    L20:
        int r114 = (r111 + r113) * 37;
        String r115 = this.payloadType;
        if (r115 == null) goto L23;
        int r116 = r115.hashCode();
    L24:
        int r117 = (r114 + r116) * 37;
        String r118 = this.payloadEncoding;
        if (r118 == null) goto L27;
        int r119 = r118.hashCode();
    L28:
        int r120 = (r117 + r119) * 37;
        ByteString r121 = this.payload;
        if (r121 == null) goto L31;
        int r122 = r121.hashCode();
    L32:
        int r123 = (r120 + r122) * 37;
        Integer r124 = this.cmd;
        if (r124 == null) goto L35;
        int r125 = r124.hashCode();
    L36:
        int r126 = (r123 + r125) * 37;
        Integer r127 = this.channelId;
        if (r127 == null) goto L39;
        r103 = r127.hashCode();
    L39:
        int r128 = ((r126 + r103) * 37) + this.headers.hashCode();
        this.hashCode = r128;
        return r128;
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
    L41:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.seqId = this.seqId;
        r100.logId = this.logId;
        r100.service = this.service;
        r100.method = this.method;
        r100.payloadType = this.payloadType;
        r100.payloadEncoding = this.payloadEncoding;
        r100.payload = this.payload;
        r100.cmd = this.cmd;
        r100.channelId = this.channelId;
        r100.headers = Internal.copyOf("headers", this.headers);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.seqId == null) goto L6;
        r100.append(", seqId=");
        r100.append(this.seqId);
    L6:
        if (this.logId == null) goto L9;
        r100.append(", logId=");
        r100.append(this.logId);
    L9:
        if (this.service == null) goto L12;
        r100.append(", service=");
        r100.append(this.service);
    L12:
        if (this.method == null) goto L15;
        r100.append(", method=");
        r100.append(this.method);
    L15:
        if (this.payloadType == null) goto L18;
        r100.append(", payloadType=");
        r100.append(this.payloadType);
    L18:
        if (this.payloadEncoding == null) goto L21;
        r100.append(", payloadEncoding=");
        r100.append(this.payloadEncoding);
    L21:
        if (this.payload == null) goto L24;
        r100.append(", payload=");
        r100.append(this.payload);
    L24:
        if (this.cmd == null) goto L27;
        r100.append(", cmd=");
        r100.append(this.cmd);
    L27:
        if (this.channelId == null) goto L29;
        r100.append(", channelId=");
        r100.append(this.channelId);
    L29:
        Map<String, String> r101 = this.headers;
        if (r101 != null) goto L32;
    L34:
        StringBuilder r102 = r100.replace(0, 2, "WsMessageInfo{");
        r102.append('}');
        return r102.toString();
    L32:
        if (r101.isEmpty() == true) goto L34;
        r100.append(", headers=");
        r100.append(this.headers);
        goto L34
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof WsMessageInfo) == true) goto L8;
        return false;
    L8:
        WsMessageInfo r101 = (WsMessageInfo) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L31:
        return false;
    L11:
        if (Internal.equals(this.seqId, r101.seqId) == false) goto L31;
        if (Internal.equals(this.logId, r101.logId) == false) goto L31;
        if (Internal.equals(this.service, r101.service) == false) goto L31;
        if (Internal.equals(this.method, r101.method) == false) goto L31;
        if (Internal.equals(this.payloadType, r101.payloadType) == false) goto L31;
        if (Internal.equals(this.payloadEncoding, r101.payloadEncoding) == false) goto L31;
        if (Internal.equals(this.payload, r101.payload) == false) goto L31;
        if (Internal.equals(this.cmd, r101.cmd) == false) goto L31;
        if (Internal.equals(this.channelId, r101.channelId) == false) goto L31;
        if (this.headers.equals(r101.headers) == false) goto L31;
        return true;
    }

    public WsMessageInfo(Long r110, Long r111, Integer r112, Integer r113, String r114, String r115, ByteString r116, Integer r210, Integer r211, Map<String, String> r212) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
    }

    public WsMessageInfo(Long r100, Long r101, Integer r102, Integer r103, String r104, String r105, ByteString r106, Integer r107, Integer r110, Map<String, String> r111, ByteString r112) {
        super(ADAPTER, r112);
        this.seqId = r100;
        this.logId = r101;
        this.service = r102;
        this.method = r103;
        this.payloadType = r104;
        this.payloadEncoding = r105;
        this.payload = r106;
        this.cmd = r107;
        this.channelId = r110;
        this.headers = Internal.immutableCopyOf("headers", r111);
    }
}
