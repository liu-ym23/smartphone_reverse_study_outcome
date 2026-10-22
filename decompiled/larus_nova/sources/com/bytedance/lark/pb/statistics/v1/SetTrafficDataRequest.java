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
public final class SetTrafficDataRequest extends Message<SetTrafficDataRequest, Builder> {
    public static final ProtoAdapter<SetTrafficDataRequest> ADAPTER = null;
    public static final ProtoAdapter_SetTrafficDataRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final TrafficData traffic_data;

    public static final class Builder extends Message.Builder<SetTrafficDataRequest, Builder> implements b<SetTrafficDataRequest> {
        public TrafficData traffic_data;

        @Override // com.squareup.wire.Message.Builder
        public SetTrafficDataRequest build() {
            return new SetTrafficDataRequest(this.traffic_data, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder traffic_data(TrafficData r100) {
            this.traffic_data = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SetTrafficDataRequest extends ProtoAdapter<SetTrafficDataRequest> implements a<SetTrafficDataRequest> {
        public ProtoAdapter_SetTrafficDataRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SetTrafficDataRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SetTrafficDataRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.traffic_data = TrafficData.ADAPTER.decode(r100);
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L9:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SetTrafficDataRequest r100) {
            TrafficData r101 = r100.traffic_data;
            if (r101 == null) goto L5;
            int r102 = TrafficData.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SetTrafficDataRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SetTrafficDataRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SetTrafficDataRequest r101) throws IOException {
            TrafficData r102 = r101.traffic_data;
            if (r102 == null) goto L5;
            TrafficData.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SetTrafficDataRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SetTrafficDataRequest r100 = new ProtoAdapter_SetTrafficDataRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.traffic_data = this.traffic_data;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SetTrafficDataRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SetTrafficDataRequest(TrafficData r100) {
        this(r100, ByteString.EMPTY);
    }

    public SetTrafficDataRequest(TrafficData r100, ByteString r101) {
        super(ADAPTER, r101);
        this.traffic_data = r100;
    }
}
