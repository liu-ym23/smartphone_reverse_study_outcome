package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes33.dex */
public final class RequestBody extends Message<RequestBody, Builder> {
    public static final ProtoAdapter<RequestBody> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @SerializedName("bizExampleRequest")
    @WireField(adapter = "com.obric.matrix.proto.BizExampleRequest#ADAPTER", tag = 100000)
    public final BizExampleRequest bizExampleRequest;

    @SerializedName("decodeLocationRequest")
    @WireField(adapter = "com.obric.matrix.proto.DecodeLocationRequest#ADAPTER", tag = 102003)
    public final DecodeLocationRequest decodeLocationRequest;

    @SerializedName("genericNetworkRequest")
    @WireField(adapter = "com.obric.matrix.proto.GenericNetworkRequest#ADAPTER", tag = 112003)
    public final GenericNetworkRequest genericNetworkRequest;

    @SerializedName("getIntersectFencesRequest")
    @WireField(adapter = "com.obric.matrix.proto.GetIntersectFencesRequest#ADAPTER", tag = 102004)
    public final GetIntersectFencesRequest getIntersectFencesRequest;

    @SerializedName("getLocationRequest")
    @WireField(adapter = "com.obric.matrix.proto.GetLocationRequest#ADAPTER", tag = 102001)
    public final GetLocationRequest getLocationRequest;

    @SerializedName("getTTNetParametersRequest")
    @WireField(adapter = "com.obric.matrix.proto.GetTTNetParametersRequest#ADAPTER", tag = 112004)
    public final GetTTNetParametersRequest getTTNetParametersRequest;

    @SerializedName("onePartyCommonNetworkRequest")
    @WireField(adapter = "com.obric.matrix.proto.OnePartyCommonNetworkRequest#ADAPTER", tag = 112001)
    public final OnePartyCommonNetworkRequest onePartyCommonNetworkRequest;

    @SerializedName("picoLinksCallback")
    @WireField(adapter = "com.obric.matrix.proto.PicoLinksCallback#ADAPTER", tag = 111002)
    public final PicoLinksCallback picoLinksCallback;

    @SerializedName("refreshLocationRequest")
    @WireField(adapter = "com.obric.matrix.proto.RefreshLocationRequest#ADAPTER", tag = 102002)
    public final RefreshLocationRequest refreshLocationRequest;

    @SerializedName("sendApplogEventRequest")
    @WireField(adapter = "com.obric.matrix.proto.SendApplogEventRequest#ADAPTER", tag = 112002)
    public final SendApplogEventRequest sendApplogEventRequest;

    @SerializedName("sendWsMessageRequest")
    @WireField(adapter = "com.obric.matrix.proto.SendWsMessageRequest#ADAPTER", tag = 101001)
    public final SendWsMessageRequest sendWsMessageRequest;

    @SerializedName("startPicoLinksRequest")
    @WireField(adapter = "com.obric.matrix.proto.StartPicoLinksRequest#ADAPTER", tag = 111001)
    public final StartPicoLinksRequest startPicoLinksRequest;

    @SerializedName("subscribeWsMsgByBroadCastRequest")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgByBroadCastRequest#ADAPTER", tag = 101006)
    public final SubscribeWsMsgByBroadCastRequest subscribeWsMsgByBroadCastRequest;

    @SerializedName("subscribeWsMsgByCallBackRequest")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgByCallBackRequest#ADAPTER", tag = 101005)
    public final SubscribeWsMsgByCallBackRequest subscribeWsMsgByCallBackRequest;

    @SerializedName("subscribeWsMsgByProviderRequest")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgByProviderRequest#ADAPTER", tag = 101004)
    public final SubscribeWsMsgByProviderRequest subscribeWsMsgByProviderRequest;

    @SerializedName("subscribeWsMsgRequest")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgRequest#ADAPTER", tag = 101002)
    public final SubscribeWsMsgRequest subscribeWsMsgRequest;

    @SerializedName("subscribeWsStatusRequest")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsStatusRequest#ADAPTER", tag = 101003)
    public final SubscribeWsStatusRequest subscribeWsStatusRequest;

    public static final class Builder extends Message.Builder<RequestBody, Builder> {
        public BizExampleRequest bizExampleRequest;
        public DecodeLocationRequest decodeLocationRequest;
        public GenericNetworkRequest genericNetworkRequest;
        public GetIntersectFencesRequest getIntersectFencesRequest;
        public GetLocationRequest getLocationRequest;
        public GetTTNetParametersRequest getTTNetParametersRequest;
        public OnePartyCommonNetworkRequest onePartyCommonNetworkRequest;
        public PicoLinksCallback picoLinksCallback;
        public RefreshLocationRequest refreshLocationRequest;
        public SendApplogEventRequest sendApplogEventRequest;
        public SendWsMessageRequest sendWsMessageRequest;
        public StartPicoLinksRequest startPicoLinksRequest;
        public SubscribeWsMsgByBroadCastRequest subscribeWsMsgByBroadCastRequest;
        public SubscribeWsMsgByCallBackRequest subscribeWsMsgByCallBackRequest;
        public SubscribeWsMsgByProviderRequest subscribeWsMsgByProviderRequest;
        public SubscribeWsMsgRequest subscribeWsMsgRequest;
        public SubscribeWsStatusRequest subscribeWsStatusRequest;

        @Override // com.squareup.wire.Message.Builder
        public RequestBody build() {
            return new RequestBody(this.bizExampleRequest, this.sendWsMessageRequest, this.subscribeWsMsgRequest, this.subscribeWsStatusRequest, this.subscribeWsMsgByProviderRequest, this.subscribeWsMsgByCallBackRequest, this.subscribeWsMsgByBroadCastRequest, this.getLocationRequest, this.refreshLocationRequest, this.decodeLocationRequest, this.getIntersectFencesRequest, this.startPicoLinksRequest, this.picoLinksCallback, this.onePartyCommonNetworkRequest, this.sendApplogEventRequest, this.genericNetworkRequest, this.getTTNetParametersRequest, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder bizExampleRequest(BizExampleRequest r100) {
            this.bizExampleRequest = r100;
            return this;
        }

        public Builder decodeLocationRequest(DecodeLocationRequest r100) {
            this.decodeLocationRequest = r100;
            return this;
        }

        public Builder genericNetworkRequest(GenericNetworkRequest r100) {
            this.genericNetworkRequest = r100;
            return this;
        }

        public Builder getIntersectFencesRequest(GetIntersectFencesRequest r100) {
            this.getIntersectFencesRequest = r100;
            return this;
        }

        public Builder getLocationRequest(GetLocationRequest r100) {
            this.getLocationRequest = r100;
            return this;
        }

        public Builder getTTNetParametersRequest(GetTTNetParametersRequest r100) {
            this.getTTNetParametersRequest = r100;
            return this;
        }

        public Builder onePartyCommonNetworkRequest(OnePartyCommonNetworkRequest r100) {
            this.onePartyCommonNetworkRequest = r100;
            return this;
        }

        public Builder picoLinksCallback(PicoLinksCallback r100) {
            this.picoLinksCallback = r100;
            return this;
        }

        public Builder refreshLocationRequest(RefreshLocationRequest r100) {
            this.refreshLocationRequest = r100;
            return this;
        }

        public Builder sendApplogEventRequest(SendApplogEventRequest r100) {
            this.sendApplogEventRequest = r100;
            return this;
        }

        public Builder sendWsMessageRequest(SendWsMessageRequest r100) {
            this.sendWsMessageRequest = r100;
            return this;
        }

        public Builder startPicoLinksRequest(StartPicoLinksRequest r100) {
            this.startPicoLinksRequest = r100;
            return this;
        }

        public Builder subscribeWsMsgByBroadCastRequest(SubscribeWsMsgByBroadCastRequest r100) {
            this.subscribeWsMsgByBroadCastRequest = r100;
            return this;
        }

        public Builder subscribeWsMsgByCallBackRequest(SubscribeWsMsgByCallBackRequest r100) {
            this.subscribeWsMsgByCallBackRequest = r100;
            return this;
        }

        public Builder subscribeWsMsgByProviderRequest(SubscribeWsMsgByProviderRequest r100) {
            this.subscribeWsMsgByProviderRequest = r100;
            return this;
        }

        public Builder subscribeWsMsgRequest(SubscribeWsMsgRequest r100) {
            this.subscribeWsMsgRequest = r100;
            return this;
        }

        public Builder subscribeWsStatusRequest(SubscribeWsStatusRequest r100) {
            this.subscribeWsStatusRequest = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_RequestBody extends ProtoAdapter<RequestBody> {
        public ProtoAdapter_RequestBody() {
            super(FieldEncoding.LENGTH_DELIMITED, RequestBody.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public RequestBody decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L29;
            if (r103 != 100000) goto L7;
            r101.bizExampleRequest(BizExampleRequest.ADAPTER.decode(r100));
            goto L3
        L7:
            switch(r103) {
                case 101001: goto L27;
                case 101002: goto L26;
                case 101003: goto L25;
                case 101004: goto L24;
                case 101005: goto L23;
                case 101006: goto L22;
                default: goto L8;
            };
        L22:
            r101.subscribeWsMsgByBroadCastRequest(SubscribeWsMsgByBroadCastRequest.ADAPTER.decode(r100));
            goto L3
        L23:
            r101.subscribeWsMsgByCallBackRequest(SubscribeWsMsgByCallBackRequest.ADAPTER.decode(r100));
            goto L3
        L24:
            r101.subscribeWsMsgByProviderRequest(SubscribeWsMsgByProviderRequest.ADAPTER.decode(r100));
            goto L3
        L25:
            r101.subscribeWsStatusRequest(SubscribeWsStatusRequest.ADAPTER.decode(r100));
            goto L3
        L26:
            r101.subscribeWsMsgRequest(SubscribeWsMsgRequest.ADAPTER.decode(r100));
            goto L3
        L27:
            r101.sendWsMessageRequest(SendWsMessageRequest.ADAPTER.decode(r100));
            goto L3
        L8:
            switch(r103) {
                case 102001: goto L21;
                case 102002: goto L20;
                case 102003: goto L19;
                case 102004: goto L18;
                default: goto L9;
            };
        L18:
            r101.getIntersectFencesRequest(GetIntersectFencesRequest.ADAPTER.decode(r100));
            goto L3
        L19:
            r101.decodeLocationRequest(DecodeLocationRequest.ADAPTER.decode(r100));
            goto L3
        L20:
            r101.refreshLocationRequest(RefreshLocationRequest.ADAPTER.decode(r100));
            goto L3
        L21:
            r101.getLocationRequest(GetLocationRequest.ADAPTER.decode(r100));
            goto L3
        L9:
            switch(r103) {
                case 111001: goto L17;
                case 111002: goto L16;
                default: goto L10;
            };
        L16:
            r101.picoLinksCallback(PicoLinksCallback.ADAPTER.decode(r100));
            goto L3
        L17:
            r101.startPicoLinksRequest(StartPicoLinksRequest.ADAPTER.decode(r100));
            goto L3
        L10:
            switch(r103) {
                case 112001: goto L15;
                case 112002: goto L14;
                case 112003: goto L13;
                case 112004: goto L12;
                default: goto L11;
            };
        L12:
            r101.getTTNetParametersRequest(GetTTNetParametersRequest.ADAPTER.decode(r100));
            goto L3
        L13:
            r101.genericNetworkRequest(GenericNetworkRequest.ADAPTER.decode(r100));
            goto L3
        L14:
            r101.sendApplogEventRequest(SendApplogEventRequest.ADAPTER.decode(r100));
            goto L3
        L15:
            r101.onePartyCommonNetworkRequest(OnePartyCommonNetworkRequest.ADAPTER.decode(r100));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L29:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(RequestBody r100) {
            return ((((((((((((((((BizExampleRequest.ADAPTER.encodedSizeWithTag(100000, r100.bizExampleRequest) + SendWsMessageRequest.ADAPTER.encodedSizeWithTag(101001, r100.sendWsMessageRequest)) + SubscribeWsMsgRequest.ADAPTER.encodedSizeWithTag(101002, r100.subscribeWsMsgRequest)) + SubscribeWsStatusRequest.ADAPTER.encodedSizeWithTag(101003, r100.subscribeWsStatusRequest)) + SubscribeWsMsgByProviderRequest.ADAPTER.encodedSizeWithTag(101004, r100.subscribeWsMsgByProviderRequest)) + SubscribeWsMsgByCallBackRequest.ADAPTER.encodedSizeWithTag(101005, r100.subscribeWsMsgByCallBackRequest)) + SubscribeWsMsgByBroadCastRequest.ADAPTER.encodedSizeWithTag(101006, r100.subscribeWsMsgByBroadCastRequest)) + GetLocationRequest.ADAPTER.encodedSizeWithTag(102001, r100.getLocationRequest)) + RefreshLocationRequest.ADAPTER.encodedSizeWithTag(102002, r100.refreshLocationRequest)) + DecodeLocationRequest.ADAPTER.encodedSizeWithTag(102003, r100.decodeLocationRequest)) + GetIntersectFencesRequest.ADAPTER.encodedSizeWithTag(102004, r100.getIntersectFencesRequest)) + StartPicoLinksRequest.ADAPTER.encodedSizeWithTag(111001, r100.startPicoLinksRequest)) + PicoLinksCallback.ADAPTER.encodedSizeWithTag(111002, r100.picoLinksCallback)) + OnePartyCommonNetworkRequest.ADAPTER.encodedSizeWithTag(112001, r100.onePartyCommonNetworkRequest)) + SendApplogEventRequest.ADAPTER.encodedSizeWithTag(112002, r100.sendApplogEventRequest)) + GenericNetworkRequest.ADAPTER.encodedSizeWithTag(112003, r100.genericNetworkRequest)) + GetTTNetParametersRequest.ADAPTER.encodedSizeWithTag(112004, r100.getTTNetParametersRequest)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public RequestBody redact2(RequestBody r100) {
            Builder r101 = r100.newBuilder();
            BizExampleRequest r102 = r101.bizExampleRequest;
            if (r102 == null) goto L5;
            r101.bizExampleRequest = BizExampleRequest.ADAPTER.redact(r102);
        L5:
            SendWsMessageRequest r103 = r101.sendWsMessageRequest;
            if (r103 == null) goto L8;
            r101.sendWsMessageRequest = SendWsMessageRequest.ADAPTER.redact(r103);
        L8:
            SubscribeWsMsgRequest r104 = r101.subscribeWsMsgRequest;
            if (r104 == null) goto L11;
            r101.subscribeWsMsgRequest = SubscribeWsMsgRequest.ADAPTER.redact(r104);
        L11:
            SubscribeWsStatusRequest r105 = r101.subscribeWsStatusRequest;
            if (r105 == null) goto L14;
            r101.subscribeWsStatusRequest = SubscribeWsStatusRequest.ADAPTER.redact(r105);
        L14:
            SubscribeWsMsgByProviderRequest r106 = r101.subscribeWsMsgByProviderRequest;
            if (r106 == null) goto L17;
            r101.subscribeWsMsgByProviderRequest = SubscribeWsMsgByProviderRequest.ADAPTER.redact(r106);
        L17:
            SubscribeWsMsgByCallBackRequest r107 = r101.subscribeWsMsgByCallBackRequest;
            if (r107 == null) goto L20;
            r101.subscribeWsMsgByCallBackRequest = SubscribeWsMsgByCallBackRequest.ADAPTER.redact(r107);
        L20:
            SubscribeWsMsgByBroadCastRequest r108 = r101.subscribeWsMsgByBroadCastRequest;
            if (r108 == null) goto L23;
            r101.subscribeWsMsgByBroadCastRequest = SubscribeWsMsgByBroadCastRequest.ADAPTER.redact(r108);
        L23:
            GetLocationRequest r109 = r101.getLocationRequest;
            if (r109 == null) goto L26;
            r101.getLocationRequest = GetLocationRequest.ADAPTER.redact(r109);
        L26:
            RefreshLocationRequest r110 = r101.refreshLocationRequest;
            if (r110 == null) goto L29;
            r101.refreshLocationRequest = RefreshLocationRequest.ADAPTER.redact(r110);
        L29:
            DecodeLocationRequest r111 = r101.decodeLocationRequest;
            if (r111 == null) goto L32;
            r101.decodeLocationRequest = DecodeLocationRequest.ADAPTER.redact(r111);
        L32:
            GetIntersectFencesRequest r112 = r101.getIntersectFencesRequest;
            if (r112 == null) goto L35;
            r101.getIntersectFencesRequest = GetIntersectFencesRequest.ADAPTER.redact(r112);
        L35:
            StartPicoLinksRequest r113 = r101.startPicoLinksRequest;
            if (r113 == null) goto L38;
            r101.startPicoLinksRequest = StartPicoLinksRequest.ADAPTER.redact(r113);
        L38:
            PicoLinksCallback r114 = r101.picoLinksCallback;
            if (r114 == null) goto L41;
            r101.picoLinksCallback = PicoLinksCallback.ADAPTER.redact(r114);
        L41:
            OnePartyCommonNetworkRequest r115 = r101.onePartyCommonNetworkRequest;
            if (r115 == null) goto L44;
            r101.onePartyCommonNetworkRequest = OnePartyCommonNetworkRequest.ADAPTER.redact(r115);
        L44:
            SendApplogEventRequest r116 = r101.sendApplogEventRequest;
            if (r116 == null) goto L47;
            r101.sendApplogEventRequest = SendApplogEventRequest.ADAPTER.redact(r116);
        L47:
            GenericNetworkRequest r117 = r101.genericNetworkRequest;
            if (r117 == null) goto L50;
            r101.genericNetworkRequest = GenericNetworkRequest.ADAPTER.redact(r117);
        L50:
            GetTTNetParametersRequest r118 = r101.getTTNetParametersRequest;
            if (r118 == null) goto L53;
            r101.getTTNetParametersRequest = GetTTNetParametersRequest.ADAPTER.redact(r118);
        L53:
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ RequestBody decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(RequestBody r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ RequestBody redact(RequestBody r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, RequestBody r101) throws IOException {
            BizExampleRequest.ADAPTER.encodeWithTag(r100, 100000, r101.bizExampleRequest);
            SendWsMessageRequest.ADAPTER.encodeWithTag(r100, 101001, r101.sendWsMessageRequest);
            SubscribeWsMsgRequest.ADAPTER.encodeWithTag(r100, 101002, r101.subscribeWsMsgRequest);
            SubscribeWsStatusRequest.ADAPTER.encodeWithTag(r100, 101003, r101.subscribeWsStatusRequest);
            SubscribeWsMsgByProviderRequest.ADAPTER.encodeWithTag(r100, 101004, r101.subscribeWsMsgByProviderRequest);
            SubscribeWsMsgByCallBackRequest.ADAPTER.encodeWithTag(r100, 101005, r101.subscribeWsMsgByCallBackRequest);
            SubscribeWsMsgByBroadCastRequest.ADAPTER.encodeWithTag(r100, 101006, r101.subscribeWsMsgByBroadCastRequest);
            GetLocationRequest.ADAPTER.encodeWithTag(r100, 102001, r101.getLocationRequest);
            RefreshLocationRequest.ADAPTER.encodeWithTag(r100, 102002, r101.refreshLocationRequest);
            DecodeLocationRequest.ADAPTER.encodeWithTag(r100, 102003, r101.decodeLocationRequest);
            GetIntersectFencesRequest.ADAPTER.encodeWithTag(r100, 102004, r101.getIntersectFencesRequest);
            StartPicoLinksRequest.ADAPTER.encodeWithTag(r100, 111001, r101.startPicoLinksRequest);
            PicoLinksCallback.ADAPTER.encodeWithTag(r100, 111002, r101.picoLinksCallback);
            OnePartyCommonNetworkRequest.ADAPTER.encodeWithTag(r100, 112001, r101.onePartyCommonNetworkRequest);
            SendApplogEventRequest.ADAPTER.encodeWithTag(r100, 112002, r101.sendApplogEventRequest);
            GenericNetworkRequest.ADAPTER.encodeWithTag(r100, 112003, r101.genericNetworkRequest);
            GetTTNetParametersRequest.ADAPTER.encodeWithTag(r100, 112004, r101.getTTNetParametersRequest);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, RequestBody r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_RequestBody();
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L73;
        int r101 = unknownFields().hashCode() * 37;
        BizExampleRequest r102 = this.bizExampleRequest;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.hashCode();
    L8:
        int r105 = (r101 + r104) * 37;
        SendWsMessageRequest r106 = this.sendWsMessageRequest;
        if (r106 == null) goto L11;
        int r107 = r106.hashCode();
    L12:
        int r108 = (r105 + r107) * 37;
        SubscribeWsMsgRequest r109 = this.subscribeWsMsgRequest;
        if (r109 == null) goto L15;
        int r110 = r109.hashCode();
    L16:
        int r111 = (r108 + r110) * 37;
        SubscribeWsStatusRequest r112 = this.subscribeWsStatusRequest;
        if (r112 == null) goto L19;
        int r113 = r112.hashCode();
    L20:
        int r114 = (r111 + r113) * 37;
        SubscribeWsMsgByProviderRequest r115 = this.subscribeWsMsgByProviderRequest;
        if (r115 == null) goto L23;
        int r116 = r115.hashCode();
    L24:
        int r117 = (r114 + r116) * 37;
        SubscribeWsMsgByCallBackRequest r118 = this.subscribeWsMsgByCallBackRequest;
        if (r118 == null) goto L27;
        int r119 = r118.hashCode();
    L28:
        int r120 = (r117 + r119) * 37;
        SubscribeWsMsgByBroadCastRequest r121 = this.subscribeWsMsgByBroadCastRequest;
        if (r121 == null) goto L31;
        int r122 = r121.hashCode();
    L32:
        int r123 = (r120 + r122) * 37;
        GetLocationRequest r124 = this.getLocationRequest;
        if (r124 == null) goto L35;
        int r125 = r124.hashCode();
    L36:
        int r126 = (r123 + r125) * 37;
        RefreshLocationRequest r127 = this.refreshLocationRequest;
        if (r127 == null) goto L39;
        int r128 = r127.hashCode();
    L40:
        int r129 = (r126 + r128) * 37;
        DecodeLocationRequest r130 = this.decodeLocationRequest;
        if (r130 == null) goto L43;
        int r131 = r130.hashCode();
    L44:
        int r132 = (r129 + r131) * 37;
        GetIntersectFencesRequest r133 = this.getIntersectFencesRequest;
        if (r133 == null) goto L47;
        int r134 = r133.hashCode();
    L48:
        int r135 = (r132 + r134) * 37;
        StartPicoLinksRequest r136 = this.startPicoLinksRequest;
        if (r136 == null) goto L51;
        int r137 = r136.hashCode();
    L52:
        int r138 = (r135 + r137) * 37;
        PicoLinksCallback r139 = this.picoLinksCallback;
        if (r139 == null) goto L55;
        int r140 = r139.hashCode();
    L56:
        int r141 = (r138 + r140) * 37;
        OnePartyCommonNetworkRequest r142 = this.onePartyCommonNetworkRequest;
        if (r142 == null) goto L59;
        int r143 = r142.hashCode();
    L60:
        int r144 = (r141 + r143) * 37;
        SendApplogEventRequest r145 = this.sendApplogEventRequest;
        if (r145 == null) goto L63;
        int r146 = r145.hashCode();
    L64:
        int r147 = (r144 + r146) * 37;
        GenericNetworkRequest r148 = this.genericNetworkRequest;
        if (r148 == null) goto L67;
        int r149 = r148.hashCode();
    L68:
        int r150 = (r147 + r149) * 37;
        GetTTNetParametersRequest r151 = this.getTTNetParametersRequest;
        if (r151 == null) goto L71;
        r103 = r151.hashCode();
    L71:
        int r152 = r150 + r103;
        this.hashCode = r152;
        return r152;
    L67:
        r149 = 0;
        goto L68
    L63:
        r146 = 0;
        goto L64
    L59:
        r143 = 0;
        goto L60
    L55:
        r140 = 0;
        goto L56
    L51:
        r137 = 0;
        goto L52
    L47:
        r134 = 0;
        goto L48
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
    L73:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.bizExampleRequest = this.bizExampleRequest;
        r100.sendWsMessageRequest = this.sendWsMessageRequest;
        r100.subscribeWsMsgRequest = this.subscribeWsMsgRequest;
        r100.subscribeWsStatusRequest = this.subscribeWsStatusRequest;
        r100.subscribeWsMsgByProviderRequest = this.subscribeWsMsgByProviderRequest;
        r100.subscribeWsMsgByCallBackRequest = this.subscribeWsMsgByCallBackRequest;
        r100.subscribeWsMsgByBroadCastRequest = this.subscribeWsMsgByBroadCastRequest;
        r100.getLocationRequest = this.getLocationRequest;
        r100.refreshLocationRequest = this.refreshLocationRequest;
        r100.decodeLocationRequest = this.decodeLocationRequest;
        r100.getIntersectFencesRequest = this.getIntersectFencesRequest;
        r100.startPicoLinksRequest = this.startPicoLinksRequest;
        r100.picoLinksCallback = this.picoLinksCallback;
        r100.onePartyCommonNetworkRequest = this.onePartyCommonNetworkRequest;
        r100.sendApplogEventRequest = this.sendApplogEventRequest;
        r100.genericNetworkRequest = this.genericNetworkRequest;
        r100.getTTNetParametersRequest = this.getTTNetParametersRequest;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.bizExampleRequest == null) goto L6;
        r100.append(", bizExampleRequest=");
        r100.append(this.bizExampleRequest);
    L6:
        if (this.sendWsMessageRequest == null) goto L9;
        r100.append(", sendWsMessageRequest=");
        r100.append(this.sendWsMessageRequest);
    L9:
        if (this.subscribeWsMsgRequest == null) goto L12;
        r100.append(", subscribeWsMsgRequest=");
        r100.append(this.subscribeWsMsgRequest);
    L12:
        if (this.subscribeWsStatusRequest == null) goto L15;
        r100.append(", subscribeWsStatusRequest=");
        r100.append(this.subscribeWsStatusRequest);
    L15:
        if (this.subscribeWsMsgByProviderRequest == null) goto L18;
        r100.append(", subscribeWsMsgByProviderRequest=");
        r100.append(this.subscribeWsMsgByProviderRequest);
    L18:
        if (this.subscribeWsMsgByCallBackRequest == null) goto L21;
        r100.append(", subscribeWsMsgByCallBackRequest=");
        r100.append(this.subscribeWsMsgByCallBackRequest);
    L21:
        if (this.subscribeWsMsgByBroadCastRequest == null) goto L24;
        r100.append(", subscribeWsMsgByBroadCastRequest=");
        r100.append(this.subscribeWsMsgByBroadCastRequest);
    L24:
        if (this.getLocationRequest == null) goto L27;
        r100.append(", getLocationRequest=");
        r100.append(this.getLocationRequest);
    L27:
        if (this.refreshLocationRequest == null) goto L30;
        r100.append(", refreshLocationRequest=");
        r100.append(this.refreshLocationRequest);
    L30:
        if (this.decodeLocationRequest == null) goto L33;
        r100.append(", decodeLocationRequest=");
        r100.append(this.decodeLocationRequest);
    L33:
        if (this.getIntersectFencesRequest == null) goto L36;
        r100.append(", getIntersectFencesRequest=");
        r100.append(this.getIntersectFencesRequest);
    L36:
        if (this.startPicoLinksRequest == null) goto L39;
        r100.append(", startPicoLinksRequest=");
        r100.append(this.startPicoLinksRequest);
    L39:
        if (this.picoLinksCallback == null) goto L42;
        r100.append(", picoLinksCallback=");
        r100.append(this.picoLinksCallback);
    L42:
        if (this.onePartyCommonNetworkRequest == null) goto L45;
        r100.append(", onePartyCommonNetworkRequest=");
        r100.append(this.onePartyCommonNetworkRequest);
    L45:
        if (this.sendApplogEventRequest == null) goto L48;
        r100.append(", sendApplogEventRequest=");
        r100.append(this.sendApplogEventRequest);
    L48:
        if (this.genericNetworkRequest == null) goto L51;
        r100.append(", genericNetworkRequest=");
        r100.append(this.genericNetworkRequest);
    L51:
        if (this.getTTNetParametersRequest == null) goto L53;
        r100.append(", getTTNetParametersRequest=");
        r100.append(this.getTTNetParametersRequest);
    L53:
        StringBuilder r101 = r100.replace(0, 2, "RequestBody{");
        r101.append('}');
        return r101.toString();
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof RequestBody) == true) goto L8;
        return false;
    L8:
        RequestBody r101 = (RequestBody) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L45:
        return false;
    L11:
        if (Internal.equals(this.bizExampleRequest, r101.bizExampleRequest) == false) goto L45;
        if (Internal.equals(this.sendWsMessageRequest, r101.sendWsMessageRequest) == false) goto L45;
        if (Internal.equals(this.subscribeWsMsgRequest, r101.subscribeWsMsgRequest) == false) goto L45;
        if (Internal.equals(this.subscribeWsStatusRequest, r101.subscribeWsStatusRequest) == false) goto L45;
        if (Internal.equals(this.subscribeWsMsgByProviderRequest, r101.subscribeWsMsgByProviderRequest) == false) goto L45;
        if (Internal.equals(this.subscribeWsMsgByCallBackRequest, r101.subscribeWsMsgByCallBackRequest) == false) goto L45;
        if (Internal.equals(this.subscribeWsMsgByBroadCastRequest, r101.subscribeWsMsgByBroadCastRequest) == false) goto L45;
        if (Internal.equals(this.getLocationRequest, r101.getLocationRequest) == false) goto L45;
        if (Internal.equals(this.refreshLocationRequest, r101.refreshLocationRequest) == false) goto L45;
        if (Internal.equals(this.decodeLocationRequest, r101.decodeLocationRequest) == false) goto L45;
        if (Internal.equals(this.getIntersectFencesRequest, r101.getIntersectFencesRequest) == false) goto L45;
        if (Internal.equals(this.startPicoLinksRequest, r101.startPicoLinksRequest) == false) goto L45;
        if (Internal.equals(this.picoLinksCallback, r101.picoLinksCallback) == false) goto L45;
        if (Internal.equals(this.onePartyCommonNetworkRequest, r101.onePartyCommonNetworkRequest) == false) goto L45;
        if (Internal.equals(this.sendApplogEventRequest, r101.sendApplogEventRequest) == false) goto L45;
        if (Internal.equals(this.genericNetworkRequest, r101.genericNetworkRequest) == false) goto L45;
        if (Internal.equals(this.getTTNetParametersRequest, r101.getTTNetParametersRequest) == false) goto L45;
        return true;
    }

    public RequestBody(BizExampleRequest r210, SendWsMessageRequest r211, SubscribeWsMsgRequest r212, SubscribeWsStatusRequest r213, SubscribeWsMsgByProviderRequest r214, SubscribeWsMsgByCallBackRequest r215, SubscribeWsMsgByBroadCastRequest r216, GetLocationRequest r217, RefreshLocationRequest r218, DecodeLocationRequest r219, GetIntersectFencesRequest r310, StartPicoLinksRequest r311, PicoLinksCallback r312, OnePartyCommonNetworkRequest r313, SendApplogEventRequest r314, GenericNetworkRequest r315, GetTTNetParametersRequest r316) {
        this(r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316, ByteString.EMPTY);
    }

    public RequestBody(BizExampleRequest r100, SendWsMessageRequest r101, SubscribeWsMsgRequest r102, SubscribeWsStatusRequest r103, SubscribeWsMsgByProviderRequest r104, SubscribeWsMsgByCallBackRequest r105, SubscribeWsMsgByBroadCastRequest r110, GetLocationRequest r111, RefreshLocationRequest r112, DecodeLocationRequest r113, GetIntersectFencesRequest r114, StartPicoLinksRequest r115, PicoLinksCallback r116, OnePartyCommonNetworkRequest r117, SendApplogEventRequest r118, GenericNetworkRequest r119, GetTTNetParametersRequest r210, ByteString r211) {
        super(ADAPTER, r211);
        this.bizExampleRequest = r100;
        this.sendWsMessageRequest = r101;
        this.subscribeWsMsgRequest = r102;
        this.subscribeWsStatusRequest = r103;
        this.subscribeWsMsgByProviderRequest = r104;
        this.subscribeWsMsgByCallBackRequest = r105;
        this.subscribeWsMsgByBroadCastRequest = r110;
        this.getLocationRequest = r111;
        this.refreshLocationRequest = r112;
        this.decodeLocationRequest = r113;
        this.getIntersectFencesRequest = r114;
        this.startPicoLinksRequest = r115;
        this.picoLinksCallback = r116;
        this.onePartyCommonNetworkRequest = r117;
        this.sendApplogEventRequest = r118;
        this.genericNetworkRequest = r119;
        this.getTTNetParametersRequest = r210;
    }
}
