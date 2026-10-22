package com.bytedance.lark.pb.openplatform.v1;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetUniversalCardEntityByBizParamRequest extends Message<GetUniversalCardEntityByBizParamRequest, Builder> {
    public static final ProtoAdapter<GetUniversalCardEntityByBizParamRequest> ADAPTER = null;
    public static final Strategy DEFAULT_STRATEGY = null;
    public static final String DEFAULT_TRACE_ID = "";
    public static final ProtoAdapter_GetUniversalCardEntityByBizParamRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final UniversalCardBizParam biz_param;
    public final Strategy strategy;
    public final String trace_id;

    public static final class Builder extends Message.Builder<GetUniversalCardEntityByBizParamRequest, Builder> implements d<GetUniversalCardEntityByBizParamRequest> {
        public UniversalCardBizParam biz_param;
        public Strategy strategy;
        public String trace_id;

        @Override // com.squareup.wire.Message.Builder
        public GetUniversalCardEntityByBizParamRequest build() {
            UniversalCardBizParam r100 = this.biz_param;
            if (r100 == null) goto L9;
            if (this.strategy == null) goto L9;
            return new GetUniversalCardEntityByBizParamRequest(this.biz_param, this.strategy, this.trace_id, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "biz_param", this.strategy, BdpAppEventConstant.PARAMS_STRATEGY_NAME});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder biz_param(UniversalCardBizParam r100) {
            this.biz_param = r100;
            return this;
        }

        public Builder strategy(Strategy r100) {
            this.strategy = r100;
            return this;
        }

        public Builder trace_id(String r100) {
            this.trace_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetUniversalCardEntityByBizParamRequest extends ProtoAdapter<GetUniversalCardEntityByBizParamRequest> implements c<GetUniversalCardEntityByBizParamRequest> {
        public ProtoAdapter_GetUniversalCardEntityByBizParamRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetUniversalCardEntityByBizParamRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetUniversalCardEntityByBizParamRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.strategy = Strategy.unknown;
            r101.trace_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.biz_param = UniversalCardBizParam.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.strategy = Strategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.trace_id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(GetUniversalCardEntityByBizParamRequest r100) {
            int r101 = UniversalCardBizParam.ADAPTER.encodedSizeWithTag(1, r100.biz_param) + Strategy.ADAPTER.encodedSizeWithTag(2, r100.strategy);
            String r102 = r100.trace_id;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(3, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetUniversalCardEntityByBizParamRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetUniversalCardEntityByBizParamRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetUniversalCardEntityByBizParamRequest r101) throws IOException {
            UniversalCardBizParam.ADAPTER.encodeWithTag(r100, 1, r101.biz_param);
            Strategy.ADAPTER.encodeWithTag(r100, 2, r101.strategy);
            String r102 = r101.trace_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetUniversalCardEntityByBizParamRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Strategy extends Enum<Strategy> implements WireEnum {
        private static final /* synthetic */ Strategy[] $VALUES = null;
        public static final ProtoAdapter<Strategy> ADAPTER = null;
        public static final Strategy force_net = null;
        public static final Strategy local_and_net = null;
        public static final Strategy locale = null;
        public static final Strategy unknown = null;
        private final int value;

        static {
            Strategy r100 = new Strategy("unknown", 0, 0);
            unknown = r100;
            Strategy r101 = new Strategy("force_net", 1, 1);
            force_net = r101;
            Strategy r102 = new Strategy("local_and_net", 2, 2);
            local_and_net = r102;
            Strategy r103 = new Strategy("locale", 3, 3);
            locale = r103;
            $VALUES = new Strategy[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(Strategy.class);
        }

        public static Strategy[] values() {
            return (Strategy[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Strategy fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return locale;
        L14:
            return local_and_net;
        L16:
            return force_net;
        L18:
            return unknown;
        }

        public static Strategy valueOf(String r100) {
            return (Strategy) a.a(Strategy.class, r100);
        }

        private Strategy(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ProtoAdapter_GetUniversalCardEntityByBizParamRequest r100 = new ProtoAdapter_GetUniversalCardEntityByBizParamRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_STRATEGY = Strategy.unknown;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.biz_param = this.biz_param;
        r100.strategy = this.strategy;
        r100.trace_id = this.trace_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetUniversalCardEntityByBizParamRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetUniversalCardEntityByBizParamRequest(UniversalCardBizParam r100, Strategy r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetUniversalCardEntityByBizParamRequest(UniversalCardBizParam r100, Strategy r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.biz_param = r100;
        this.strategy = r101;
        this.trace_id = r102;
    }
}
