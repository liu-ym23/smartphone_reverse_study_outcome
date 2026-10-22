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
public final class ResponseBody extends Message<ResponseBody, Builder> {
    public static final ProtoAdapter<ResponseBody> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @SerializedName("bizExampleResponse")
    @WireField(adapter = "com.obric.matrix.proto.BizExampleResponse#ADAPTER", tag = 100000)
    public final BizExampleResponse bizExampleResponse;

    @SerializedName("decodeLocationResponse")
    @WireField(adapter = "com.obric.matrix.proto.DecodeLocationResponse#ADAPTER", tag = 102003)
    public final DecodeLocationResponse decodeLocationResponse;

    @SerializedName("genericNetworkResponse")
    @WireField(adapter = "com.obric.matrix.proto.GenericNetworkResponse#ADAPTER", tag = 112003)
    public final GenericNetworkResponse genericNetworkResponse;

    @SerializedName("getIntersectFencesResponse")
    @WireField(adapter = "com.obric.matrix.proto.GetIntersectFencesResponse#ADAPTER", tag = 102004)
    public final GetIntersectFencesResponse getIntersectFencesResponse;

    @SerializedName("getLocationResponse")
    @WireField(adapter = "com.obric.matrix.proto.GetLocationResponse#ADAPTER", tag = 102001)
    public final GetLocationResponse getLocationResponse;

    @SerializedName("getTTNetParametersResponse")
    @WireField(adapter = "com.obric.matrix.proto.GetTTNetParametersResponse#ADAPTER", tag = 112004)
    public final GetTTNetParametersResponse getTTNetParametersResponse;

    @SerializedName("onePartyCommonNetworkResponse")
    @WireField(adapter = "com.obric.matrix.proto.OnePartyCommonNetworkResponse#ADAPTER", tag = 112001)
    public final OnePartyCommonNetworkResponse onePartyCommonNetworkResponse;

    @SerializedName("refreshLocationResponse")
    @WireField(adapter = "com.obric.matrix.proto.RefreshLocationResponse#ADAPTER", tag = 102002)
    public final RefreshLocationResponse refreshLocationResponse;

    @SerializedName("sendApplogEventResponse")
    @WireField(adapter = "com.obric.matrix.proto.SendApplogEventResponse#ADAPTER", tag = 112002)
    public final SendApplogEventResponse sendApplogEventResponse;

    @SerializedName("sendWsMessageResponse")
    @WireField(adapter = "com.obric.matrix.proto.SendWsMessageResponse#ADAPTER", tag = 101001)
    public final SendWsMessageResponse sendWsMessageResponse;

    @SerializedName("startPicoLinksResponse")
    @WireField(adapter = "com.obric.matrix.proto.StartPicoLinksResponse#ADAPTER", tag = 111001)
    public final StartPicoLinksResponse startPicoLinksResponse;

    @SerializedName("subscribeWsMsgByBroadCastResponse")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgByBroadCastResponse#ADAPTER", tag = 101006)
    public final SubscribeWsMsgByBroadCastResponse subscribeWsMsgByBroadCastResponse;

    @SerializedName("subscribeWsMsgByCallBackResponse")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgByCallBackResponse#ADAPTER", tag = 101005)
    public final SubscribeWsMsgByCallBackResponse subscribeWsMsgByCallBackResponse;

    @SerializedName("subscribeWsMsgByProviderResponse")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgByProviderResponse#ADAPTER", tag = 101004)
    public final SubscribeWsMsgByProviderResponse subscribeWsMsgByProviderResponse;

    @SerializedName("subscribeWsMsgResponse")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgResponse#ADAPTER", tag = 101002)
    public final SubscribeWsMsgResponse subscribeWsMsgResponse;

    @SerializedName("subscribeWsStatusResponse")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsStatusResponse#ADAPTER", tag = 101003)
    public final SubscribeWsStatusResponse subscribeWsStatusResponse;

    public static final class Builder extends Message.Builder<ResponseBody, Builder> {
        public BizExampleResponse bizExampleResponse;
        public DecodeLocationResponse decodeLocationResponse;
        public GenericNetworkResponse genericNetworkResponse;
        public GetIntersectFencesResponse getIntersectFencesResponse;
        public GetLocationResponse getLocationResponse;
        public GetTTNetParametersResponse getTTNetParametersResponse;
        public OnePartyCommonNetworkResponse onePartyCommonNetworkResponse;
        public RefreshLocationResponse refreshLocationResponse;
        public SendApplogEventResponse sendApplogEventResponse;
        public SendWsMessageResponse sendWsMessageResponse;
        public StartPicoLinksResponse startPicoLinksResponse;
        public SubscribeWsMsgByBroadCastResponse subscribeWsMsgByBroadCastResponse;
        public SubscribeWsMsgByCallBackResponse subscribeWsMsgByCallBackResponse;
        public SubscribeWsMsgByProviderResponse subscribeWsMsgByProviderResponse;
        public SubscribeWsMsgResponse subscribeWsMsgResponse;
        public SubscribeWsStatusResponse subscribeWsStatusResponse;

        @Override // com.squareup.wire.Message.Builder
        public ResponseBody build() {
            return new ResponseBody(this.bizExampleResponse, this.sendWsMessageResponse, this.subscribeWsMsgResponse, this.subscribeWsStatusResponse, this.subscribeWsMsgByProviderResponse, this.subscribeWsMsgByCallBackResponse, this.subscribeWsMsgByBroadCastResponse, this.getLocationResponse, this.refreshLocationResponse, this.decodeLocationResponse, this.getIntersectFencesResponse, this.startPicoLinksResponse, this.onePartyCommonNetworkResponse, this.sendApplogEventResponse, this.genericNetworkResponse, this.getTTNetParametersResponse, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder bizExampleResponse(BizExampleResponse r100) {
            this.bizExampleResponse = r100;
            return this;
        }

        public Builder decodeLocationResponse(DecodeLocationResponse r100) {
            this.decodeLocationResponse = r100;
            return this;
        }

        public Builder genericNetworkResponse(GenericNetworkResponse r100) {
            this.genericNetworkResponse = r100;
            return this;
        }

        public Builder getIntersectFencesResponse(GetIntersectFencesResponse r100) {
            this.getIntersectFencesResponse = r100;
            return this;
        }

        public Builder getLocationResponse(GetLocationResponse r100) {
            this.getLocationResponse = r100;
            return this;
        }

        public Builder getTTNetParametersResponse(GetTTNetParametersResponse r100) {
            this.getTTNetParametersResponse = r100;
            return this;
        }

        public Builder onePartyCommonNetworkResponse(OnePartyCommonNetworkResponse r100) {
            this.onePartyCommonNetworkResponse = r100;
            return this;
        }

        public Builder refreshLocationResponse(RefreshLocationResponse r100) {
            this.refreshLocationResponse = r100;
            return this;
        }

        public Builder sendApplogEventResponse(SendApplogEventResponse r100) {
            this.sendApplogEventResponse = r100;
            return this;
        }

        public Builder sendWsMessageResponse(SendWsMessageResponse r100) {
            this.sendWsMessageResponse = r100;
            return this;
        }

        public Builder startPicoLinksResponse(StartPicoLinksResponse r100) {
            this.startPicoLinksResponse = r100;
            return this;
        }

        public Builder subscribeWsMsgByBroadCastResponse(SubscribeWsMsgByBroadCastResponse r100) {
            this.subscribeWsMsgByBroadCastResponse = r100;
            return this;
        }

        public Builder subscribeWsMsgByCallBackResponse(SubscribeWsMsgByCallBackResponse r100) {
            this.subscribeWsMsgByCallBackResponse = r100;
            return this;
        }

        public Builder subscribeWsMsgByProviderResponse(SubscribeWsMsgByProviderResponse r100) {
            this.subscribeWsMsgByProviderResponse = r100;
            return this;
        }

        public Builder subscribeWsMsgResponse(SubscribeWsMsgResponse r100) {
            this.subscribeWsMsgResponse = r100;
            return this;
        }

        public Builder subscribeWsStatusResponse(SubscribeWsStatusResponse r100) {
            this.subscribeWsStatusResponse = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ResponseBody extends ProtoAdapter<ResponseBody> {
        public ProtoAdapter_ResponseBody() {
            super(FieldEncoding.LENGTH_DELIMITED, ResponseBody.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ResponseBody decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L29;
            if (r103 != 100000) goto L8;
            r101.bizExampleResponse(BizExampleResponse.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 111001) goto L9;
            r101.startPicoLinksResponse(StartPicoLinksResponse.ADAPTER.decode(r100));
            goto L3
        L9:
            switch(r103) {
                case 101001: goto L26;
                case 101002: goto L25;
                case 101003: goto L24;
                case 101004: goto L23;
                case 101005: goto L22;
                case 101006: goto L21;
                default: goto L10;
            };
        L21:
            r101.subscribeWsMsgByBroadCastResponse(SubscribeWsMsgByBroadCastResponse.ADAPTER.decode(r100));
            goto L3
        L22:
            r101.subscribeWsMsgByCallBackResponse(SubscribeWsMsgByCallBackResponse.ADAPTER.decode(r100));
            goto L3
        L23:
            r101.subscribeWsMsgByProviderResponse(SubscribeWsMsgByProviderResponse.ADAPTER.decode(r100));
            goto L3
        L24:
            r101.subscribeWsStatusResponse(SubscribeWsStatusResponse.ADAPTER.decode(r100));
            goto L3
        L25:
            r101.subscribeWsMsgResponse(SubscribeWsMsgResponse.ADAPTER.decode(r100));
            goto L3
        L26:
            r101.sendWsMessageResponse(SendWsMessageResponse.ADAPTER.decode(r100));
            goto L3
        L10:
            switch(r103) {
                case 102001: goto L20;
                case 102002: goto L19;
                case 102003: goto L18;
                case 102004: goto L17;
                default: goto L11;
            };
        L17:
            r101.getIntersectFencesResponse(GetIntersectFencesResponse.ADAPTER.decode(r100));
            goto L3
        L18:
            r101.decodeLocationResponse(DecodeLocationResponse.ADAPTER.decode(r100));
            goto L3
        L19:
            r101.refreshLocationResponse(RefreshLocationResponse.ADAPTER.decode(r100));
            goto L3
        L20:
            r101.getLocationResponse(GetLocationResponse.ADAPTER.decode(r100));
            goto L3
        L11:
            switch(r103) {
                case 112001: goto L16;
                case 112002: goto L15;
                case 112003: goto L14;
                case 112004: goto L13;
                default: goto L12;
            };
        L13:
            r101.getTTNetParametersResponse(GetTTNetParametersResponse.ADAPTER.decode(r100));
            goto L3
        L14:
            r101.genericNetworkResponse(GenericNetworkResponse.ADAPTER.decode(r100));
            goto L3
        L15:
            r101.sendApplogEventResponse(SendApplogEventResponse.ADAPTER.decode(r100));
            goto L3
        L16:
            r101.onePartyCommonNetworkResponse(OnePartyCommonNetworkResponse.ADAPTER.decode(r100));
            goto L3
        L12:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L29:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ResponseBody r100) {
            return (((((((((((((((BizExampleResponse.ADAPTER.encodedSizeWithTag(100000, r100.bizExampleResponse) + SendWsMessageResponse.ADAPTER.encodedSizeWithTag(101001, r100.sendWsMessageResponse)) + SubscribeWsMsgResponse.ADAPTER.encodedSizeWithTag(101002, r100.subscribeWsMsgResponse)) + SubscribeWsStatusResponse.ADAPTER.encodedSizeWithTag(101003, r100.subscribeWsStatusResponse)) + SubscribeWsMsgByProviderResponse.ADAPTER.encodedSizeWithTag(101004, r100.subscribeWsMsgByProviderResponse)) + SubscribeWsMsgByCallBackResponse.ADAPTER.encodedSizeWithTag(101005, r100.subscribeWsMsgByCallBackResponse)) + SubscribeWsMsgByBroadCastResponse.ADAPTER.encodedSizeWithTag(101006, r100.subscribeWsMsgByBroadCastResponse)) + GetLocationResponse.ADAPTER.encodedSizeWithTag(102001, r100.getLocationResponse)) + RefreshLocationResponse.ADAPTER.encodedSizeWithTag(102002, r100.refreshLocationResponse)) + DecodeLocationResponse.ADAPTER.encodedSizeWithTag(102003, r100.decodeLocationResponse)) + GetIntersectFencesResponse.ADAPTER.encodedSizeWithTag(102004, r100.getIntersectFencesResponse)) + StartPicoLinksResponse.ADAPTER.encodedSizeWithTag(111001, r100.startPicoLinksResponse)) + OnePartyCommonNetworkResponse.ADAPTER.encodedSizeWithTag(112001, r100.onePartyCommonNetworkResponse)) + SendApplogEventResponse.ADAPTER.encodedSizeWithTag(112002, r100.sendApplogEventResponse)) + GenericNetworkResponse.ADAPTER.encodedSizeWithTag(112003, r100.genericNetworkResponse)) + GetTTNetParametersResponse.ADAPTER.encodedSizeWithTag(112004, r100.getTTNetParametersResponse)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public ResponseBody redact2(ResponseBody r100) {
            Builder r101 = r100.newBuilder();
            BizExampleResponse r102 = r101.bizExampleResponse;
            if (r102 == null) goto L5;
            r101.bizExampleResponse = BizExampleResponse.ADAPTER.redact(r102);
        L5:
            SendWsMessageResponse r103 = r101.sendWsMessageResponse;
            if (r103 == null) goto L8;
            r101.sendWsMessageResponse = SendWsMessageResponse.ADAPTER.redact(r103);
        L8:
            SubscribeWsMsgResponse r104 = r101.subscribeWsMsgResponse;
            if (r104 == null) goto L11;
            r101.subscribeWsMsgResponse = SubscribeWsMsgResponse.ADAPTER.redact(r104);
        L11:
            SubscribeWsStatusResponse r105 = r101.subscribeWsStatusResponse;
            if (r105 == null) goto L14;
            r101.subscribeWsStatusResponse = SubscribeWsStatusResponse.ADAPTER.redact(r105);
        L14:
            SubscribeWsMsgByProviderResponse r106 = r101.subscribeWsMsgByProviderResponse;
            if (r106 == null) goto L17;
            r101.subscribeWsMsgByProviderResponse = SubscribeWsMsgByProviderResponse.ADAPTER.redact(r106);
        L17:
            SubscribeWsMsgByCallBackResponse r107 = r101.subscribeWsMsgByCallBackResponse;
            if (r107 == null) goto L20;
            r101.subscribeWsMsgByCallBackResponse = SubscribeWsMsgByCallBackResponse.ADAPTER.redact(r107);
        L20:
            SubscribeWsMsgByBroadCastResponse r108 = r101.subscribeWsMsgByBroadCastResponse;
            if (r108 == null) goto L23;
            r101.subscribeWsMsgByBroadCastResponse = SubscribeWsMsgByBroadCastResponse.ADAPTER.redact(r108);
        L23:
            GetLocationResponse r109 = r101.getLocationResponse;
            if (r109 == null) goto L26;
            r101.getLocationResponse = GetLocationResponse.ADAPTER.redact(r109);
        L26:
            RefreshLocationResponse r110 = r101.refreshLocationResponse;
            if (r110 == null) goto L29;
            r101.refreshLocationResponse = RefreshLocationResponse.ADAPTER.redact(r110);
        L29:
            DecodeLocationResponse r111 = r101.decodeLocationResponse;
            if (r111 == null) goto L32;
            r101.decodeLocationResponse = DecodeLocationResponse.ADAPTER.redact(r111);
        L32:
            GetIntersectFencesResponse r112 = r101.getIntersectFencesResponse;
            if (r112 == null) goto L35;
            r101.getIntersectFencesResponse = GetIntersectFencesResponse.ADAPTER.redact(r112);
        L35:
            StartPicoLinksResponse r113 = r101.startPicoLinksResponse;
            if (r113 == null) goto L38;
            r101.startPicoLinksResponse = StartPicoLinksResponse.ADAPTER.redact(r113);
        L38:
            OnePartyCommonNetworkResponse r114 = r101.onePartyCommonNetworkResponse;
            if (r114 == null) goto L41;
            r101.onePartyCommonNetworkResponse = OnePartyCommonNetworkResponse.ADAPTER.redact(r114);
        L41:
            SendApplogEventResponse r115 = r101.sendApplogEventResponse;
            if (r115 == null) goto L44;
            r101.sendApplogEventResponse = SendApplogEventResponse.ADAPTER.redact(r115);
        L44:
            GenericNetworkResponse r116 = r101.genericNetworkResponse;
            if (r116 == null) goto L47;
            r101.genericNetworkResponse = GenericNetworkResponse.ADAPTER.redact(r116);
        L47:
            GetTTNetParametersResponse r117 = r101.getTTNetParametersResponse;
            if (r117 == null) goto L50;
            r101.getTTNetParametersResponse = GetTTNetParametersResponse.ADAPTER.redact(r117);
        L50:
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ResponseBody decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ResponseBody r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ResponseBody redact(ResponseBody r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ResponseBody r101) throws IOException {
            BizExampleResponse.ADAPTER.encodeWithTag(r100, 100000, r101.bizExampleResponse);
            SendWsMessageResponse.ADAPTER.encodeWithTag(r100, 101001, r101.sendWsMessageResponse);
            SubscribeWsMsgResponse.ADAPTER.encodeWithTag(r100, 101002, r101.subscribeWsMsgResponse);
            SubscribeWsStatusResponse.ADAPTER.encodeWithTag(r100, 101003, r101.subscribeWsStatusResponse);
            SubscribeWsMsgByProviderResponse.ADAPTER.encodeWithTag(r100, 101004, r101.subscribeWsMsgByProviderResponse);
            SubscribeWsMsgByCallBackResponse.ADAPTER.encodeWithTag(r100, 101005, r101.subscribeWsMsgByCallBackResponse);
            SubscribeWsMsgByBroadCastResponse.ADAPTER.encodeWithTag(r100, 101006, r101.subscribeWsMsgByBroadCastResponse);
            GetLocationResponse.ADAPTER.encodeWithTag(r100, 102001, r101.getLocationResponse);
            RefreshLocationResponse.ADAPTER.encodeWithTag(r100, 102002, r101.refreshLocationResponse);
            DecodeLocationResponse.ADAPTER.encodeWithTag(r100, 102003, r101.decodeLocationResponse);
            GetIntersectFencesResponse.ADAPTER.encodeWithTag(r100, 102004, r101.getIntersectFencesResponse);
            StartPicoLinksResponse.ADAPTER.encodeWithTag(r100, 111001, r101.startPicoLinksResponse);
            OnePartyCommonNetworkResponse.ADAPTER.encodeWithTag(r100, 112001, r101.onePartyCommonNetworkResponse);
            SendApplogEventResponse.ADAPTER.encodeWithTag(r100, 112002, r101.sendApplogEventResponse);
            GenericNetworkResponse.ADAPTER.encodeWithTag(r100, 112003, r101.genericNetworkResponse);
            GetTTNetParametersResponse.ADAPTER.encodeWithTag(r100, 112004, r101.getTTNetParametersResponse);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ResponseBody r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ResponseBody();
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L69;
        int r101 = unknownFields().hashCode() * 37;
        BizExampleResponse r102 = this.bizExampleResponse;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.hashCode();
    L8:
        int r105 = (r101 + r104) * 37;
        SendWsMessageResponse r106 = this.sendWsMessageResponse;
        if (r106 == null) goto L11;
        int r107 = r106.hashCode();
    L12:
        int r108 = (r105 + r107) * 37;
        SubscribeWsMsgResponse r109 = this.subscribeWsMsgResponse;
        if (r109 == null) goto L15;
        int r110 = r109.hashCode();
    L16:
        int r111 = (r108 + r110) * 37;
        SubscribeWsStatusResponse r112 = this.subscribeWsStatusResponse;
        if (r112 == null) goto L19;
        int r113 = r112.hashCode();
    L20:
        int r114 = (r111 + r113) * 37;
        SubscribeWsMsgByProviderResponse r115 = this.subscribeWsMsgByProviderResponse;
        if (r115 == null) goto L23;
        int r116 = r115.hashCode();
    L24:
        int r117 = (r114 + r116) * 37;
        SubscribeWsMsgByCallBackResponse r118 = this.subscribeWsMsgByCallBackResponse;
        if (r118 == null) goto L27;
        int r119 = r118.hashCode();
    L28:
        int r120 = (r117 + r119) * 37;
        SubscribeWsMsgByBroadCastResponse r121 = this.subscribeWsMsgByBroadCastResponse;
        if (r121 == null) goto L31;
        int r122 = r121.hashCode();
    L32:
        int r123 = (r120 + r122) * 37;
        GetLocationResponse r124 = this.getLocationResponse;
        if (r124 == null) goto L35;
        int r125 = r124.hashCode();
    L36:
        int r126 = (r123 + r125) * 37;
        RefreshLocationResponse r127 = this.refreshLocationResponse;
        if (r127 == null) goto L39;
        int r128 = r127.hashCode();
    L40:
        int r129 = (r126 + r128) * 37;
        DecodeLocationResponse r130 = this.decodeLocationResponse;
        if (r130 == null) goto L43;
        int r131 = r130.hashCode();
    L44:
        int r132 = (r129 + r131) * 37;
        GetIntersectFencesResponse r133 = this.getIntersectFencesResponse;
        if (r133 == null) goto L47;
        int r134 = r133.hashCode();
    L48:
        int r135 = (r132 + r134) * 37;
        StartPicoLinksResponse r136 = this.startPicoLinksResponse;
        if (r136 == null) goto L51;
        int r137 = r136.hashCode();
    L52:
        int r138 = (r135 + r137) * 37;
        OnePartyCommonNetworkResponse r139 = this.onePartyCommonNetworkResponse;
        if (r139 == null) goto L55;
        int r140 = r139.hashCode();
    L56:
        int r141 = (r138 + r140) * 37;
        SendApplogEventResponse r142 = this.sendApplogEventResponse;
        if (r142 == null) goto L59;
        int r143 = r142.hashCode();
    L60:
        int r144 = (r141 + r143) * 37;
        GenericNetworkResponse r145 = this.genericNetworkResponse;
        if (r145 == null) goto L63;
        int r146 = r145.hashCode();
    L64:
        int r147 = (r144 + r146) * 37;
        GetTTNetParametersResponse r148 = this.getTTNetParametersResponse;
        if (r148 == null) goto L67;
        r103 = r148.hashCode();
    L67:
        int r149 = r147 + r103;
        this.hashCode = r149;
        return r149;
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
    L69:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.bizExampleResponse = this.bizExampleResponse;
        r100.sendWsMessageResponse = this.sendWsMessageResponse;
        r100.subscribeWsMsgResponse = this.subscribeWsMsgResponse;
        r100.subscribeWsStatusResponse = this.subscribeWsStatusResponse;
        r100.subscribeWsMsgByProviderResponse = this.subscribeWsMsgByProviderResponse;
        r100.subscribeWsMsgByCallBackResponse = this.subscribeWsMsgByCallBackResponse;
        r100.subscribeWsMsgByBroadCastResponse = this.subscribeWsMsgByBroadCastResponse;
        r100.getLocationResponse = this.getLocationResponse;
        r100.refreshLocationResponse = this.refreshLocationResponse;
        r100.decodeLocationResponse = this.decodeLocationResponse;
        r100.getIntersectFencesResponse = this.getIntersectFencesResponse;
        r100.startPicoLinksResponse = this.startPicoLinksResponse;
        r100.onePartyCommonNetworkResponse = this.onePartyCommonNetworkResponse;
        r100.sendApplogEventResponse = this.sendApplogEventResponse;
        r100.genericNetworkResponse = this.genericNetworkResponse;
        r100.getTTNetParametersResponse = this.getTTNetParametersResponse;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.bizExampleResponse == null) goto L6;
        r100.append(", bizExampleResponse=");
        r100.append(this.bizExampleResponse);
    L6:
        if (this.sendWsMessageResponse == null) goto L9;
        r100.append(", sendWsMessageResponse=");
        r100.append(this.sendWsMessageResponse);
    L9:
        if (this.subscribeWsMsgResponse == null) goto L12;
        r100.append(", subscribeWsMsgResponse=");
        r100.append(this.subscribeWsMsgResponse);
    L12:
        if (this.subscribeWsStatusResponse == null) goto L15;
        r100.append(", subscribeWsStatusResponse=");
        r100.append(this.subscribeWsStatusResponse);
    L15:
        if (this.subscribeWsMsgByProviderResponse == null) goto L18;
        r100.append(", subscribeWsMsgByProviderResponse=");
        r100.append(this.subscribeWsMsgByProviderResponse);
    L18:
        if (this.subscribeWsMsgByCallBackResponse == null) goto L21;
        r100.append(", subscribeWsMsgByCallBackResponse=");
        r100.append(this.subscribeWsMsgByCallBackResponse);
    L21:
        if (this.subscribeWsMsgByBroadCastResponse == null) goto L24;
        r100.append(", subscribeWsMsgByBroadCastResponse=");
        r100.append(this.subscribeWsMsgByBroadCastResponse);
    L24:
        if (this.getLocationResponse == null) goto L27;
        r100.append(", getLocationResponse=");
        r100.append(this.getLocationResponse);
    L27:
        if (this.refreshLocationResponse == null) goto L30;
        r100.append(", refreshLocationResponse=");
        r100.append(this.refreshLocationResponse);
    L30:
        if (this.decodeLocationResponse == null) goto L33;
        r100.append(", decodeLocationResponse=");
        r100.append(this.decodeLocationResponse);
    L33:
        if (this.getIntersectFencesResponse == null) goto L36;
        r100.append(", getIntersectFencesResponse=");
        r100.append(this.getIntersectFencesResponse);
    L36:
        if (this.startPicoLinksResponse == null) goto L39;
        r100.append(", startPicoLinksResponse=");
        r100.append(this.startPicoLinksResponse);
    L39:
        if (this.onePartyCommonNetworkResponse == null) goto L42;
        r100.append(", onePartyCommonNetworkResponse=");
        r100.append(this.onePartyCommonNetworkResponse);
    L42:
        if (this.sendApplogEventResponse == null) goto L45;
        r100.append(", sendApplogEventResponse=");
        r100.append(this.sendApplogEventResponse);
    L45:
        if (this.genericNetworkResponse == null) goto L48;
        r100.append(", genericNetworkResponse=");
        r100.append(this.genericNetworkResponse);
    L48:
        if (this.getTTNetParametersResponse == null) goto L50;
        r100.append(", getTTNetParametersResponse=");
        r100.append(this.getTTNetParametersResponse);
    L50:
        StringBuilder r101 = r100.replace(0, 2, "ResponseBody{");
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
        if ((r100 instanceof ResponseBody) == true) goto L8;
        return false;
    L8:
        ResponseBody r101 = (ResponseBody) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L43:
        return false;
    L11:
        if (Internal.equals(this.bizExampleResponse, r101.bizExampleResponse) == false) goto L43;
        if (Internal.equals(this.sendWsMessageResponse, r101.sendWsMessageResponse) == false) goto L43;
        if (Internal.equals(this.subscribeWsMsgResponse, r101.subscribeWsMsgResponse) == false) goto L43;
        if (Internal.equals(this.subscribeWsStatusResponse, r101.subscribeWsStatusResponse) == false) goto L43;
        if (Internal.equals(this.subscribeWsMsgByProviderResponse, r101.subscribeWsMsgByProviderResponse) == false) goto L43;
        if (Internal.equals(this.subscribeWsMsgByCallBackResponse, r101.subscribeWsMsgByCallBackResponse) == false) goto L43;
        if (Internal.equals(this.subscribeWsMsgByBroadCastResponse, r101.subscribeWsMsgByBroadCastResponse) == false) goto L43;
        if (Internal.equals(this.getLocationResponse, r101.getLocationResponse) == false) goto L43;
        if (Internal.equals(this.refreshLocationResponse, r101.refreshLocationResponse) == false) goto L43;
        if (Internal.equals(this.decodeLocationResponse, r101.decodeLocationResponse) == false) goto L43;
        if (Internal.equals(this.getIntersectFencesResponse, r101.getIntersectFencesResponse) == false) goto L43;
        if (Internal.equals(this.startPicoLinksResponse, r101.startPicoLinksResponse) == false) goto L43;
        if (Internal.equals(this.onePartyCommonNetworkResponse, r101.onePartyCommonNetworkResponse) == false) goto L43;
        if (Internal.equals(this.sendApplogEventResponse, r101.sendApplogEventResponse) == false) goto L43;
        if (Internal.equals(this.genericNetworkResponse, r101.genericNetworkResponse) == false) goto L43;
        if (Internal.equals(this.getTTNetParametersResponse, r101.getTTNetParametersResponse) == false) goto L43;
        return true;
    }

    public ResponseBody(BizExampleResponse r110, SendWsMessageResponse r210, SubscribeWsMsgResponse r211, SubscribeWsStatusResponse r212, SubscribeWsMsgByProviderResponse r213, SubscribeWsMsgByCallBackResponse r214, SubscribeWsMsgByBroadCastResponse r215, GetLocationResponse r216, RefreshLocationResponse r217, DecodeLocationResponse r218, GetIntersectFencesResponse r219, StartPicoLinksResponse r310, OnePartyCommonNetworkResponse r311, SendApplogEventResponse r312, GenericNetworkResponse r313, GetTTNetParametersResponse r314) {
        this(r110, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, ByteString.EMPTY);
    }

    public ResponseBody(BizExampleResponse r100, SendWsMessageResponse r101, SubscribeWsMsgResponse r102, SubscribeWsStatusResponse r103, SubscribeWsMsgByProviderResponse r104, SubscribeWsMsgByCallBackResponse r105, SubscribeWsMsgByBroadCastResponse r110, GetLocationResponse r111, RefreshLocationResponse r112, DecodeLocationResponse r113, GetIntersectFencesResponse r114, StartPicoLinksResponse r115, OnePartyCommonNetworkResponse r116, SendApplogEventResponse r117, GenericNetworkResponse r118, GetTTNetParametersResponse r119, ByteString r210) {
        super(ADAPTER, r210);
        this.bizExampleResponse = r100;
        this.sendWsMessageResponse = r101;
        this.subscribeWsMsgResponse = r102;
        this.subscribeWsStatusResponse = r103;
        this.subscribeWsMsgByProviderResponse = r104;
        this.subscribeWsMsgByCallBackResponse = r105;
        this.subscribeWsMsgByBroadCastResponse = r110;
        this.getLocationResponse = r111;
        this.refreshLocationResponse = r112;
        this.decodeLocationResponse = r113;
        this.getIntersectFencesResponse = r114;
        this.startPicoLinksResponse = r115;
        this.onePartyCommonNetworkResponse = r116;
        this.sendApplogEventResponse = r117;
        this.genericNetworkResponse = r118;
        this.getTTNetParametersResponse = r119;
    }
}
