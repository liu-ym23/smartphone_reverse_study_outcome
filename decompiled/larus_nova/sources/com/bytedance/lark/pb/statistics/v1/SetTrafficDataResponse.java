package com.bytedance.lark.pb.statistics.v1;

import com.bytedance.lark.pb.basic.v1.TrafficData;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.a;
import we6.b;

/* JADX INFO: loaded from: classes20.dex */
public final class SetTrafficDataResponse extends Message<SetTrafficDataResponse, Builder> {
    public static final ProtoAdapter<SetTrafficDataResponse> ADAPTER = null;
    public static final ProtoAdapter_SetTrafficDataResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final TrafficData app_traffic_data;
    public final TrafficData sdk_traffic_data;

    public static final class Builder extends Message.Builder<SetTrafficDataResponse, Builder> implements b<SetTrafficDataResponse> {
        public TrafficData app_traffic_data;
        public TrafficData sdk_traffic_data;

        @Override // com.squareup.wire.Message.Builder
        public SetTrafficDataResponse build() {
            return new SetTrafficDataResponse(this.app_traffic_data, this.sdk_traffic_data, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder app_traffic_data(TrafficData r100) {
            this.app_traffic_data = r100;
            return this;
        }

        public Builder sdk_traffic_data(TrafficData r100) {
            this.sdk_traffic_data = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SetTrafficDataResponse extends ProtoAdapter<SetTrafficDataResponse> implements a<SetTrafficDataResponse> {
        public ProtoAdapter_SetTrafficDataResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SetTrafficDataResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SetTrafficDataResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.app_traffic_data = TrafficData.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.sdk_traffic_data = TrafficData.ADAPTER.decode(r100);
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SetTrafficDataResponse r100) {
            TrafficData r101 = r100.app_traffic_data;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = TrafficData.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            TrafficData r104 = r100.sdk_traffic_data;
            if (r104 == null) goto L10;
            r102 = TrafficData.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SetTrafficDataResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SetTrafficDataResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SetTrafficDataResponse r101) throws IOException {
            TrafficData r102 = r101.app_traffic_data;
            if (r102 == null) goto L5;
            TrafficData.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            TrafficData r103 = r101.sdk_traffic_data;
            if (r103 == null) goto L8;
            TrafficData.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SetTrafficDataResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SetTrafficDataResponse r100 = new ProtoAdapter_SetTrafficDataResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.app_traffic_data = this.app_traffic_data;
        r100.sdk_traffic_data = this.sdk_traffic_data;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SetTrafficDataResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SetTrafficDataResponse(TrafficData r100, TrafficData r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public SetTrafficDataResponse(TrafficData r100, TrafficData r101, ByteString r102) {
        super(ADAPTER, r102);
        this.app_traffic_data = r100;
        this.sdk_traffic_data = r101;
    }
}
