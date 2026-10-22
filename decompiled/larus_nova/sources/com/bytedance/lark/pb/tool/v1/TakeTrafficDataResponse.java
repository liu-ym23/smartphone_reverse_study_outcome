package com.bytedance.lark.pb.tool.v1;

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
public final class TakeTrafficDataResponse extends Message<TakeTrafficDataResponse, Builder> {
    public static final ProtoAdapter<TakeTrafficDataResponse> ADAPTER = null;
    public static final Long DEFAULT_RECV_BYTES = null;
    public static final Long DEFAULT_SEND_BYTES = null;
    public static final ProtoAdapter_TakeTrafficDataResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final TrafficData data;
    public final Long recv_bytes;
    public final Long send_bytes;

    public static final class Builder extends Message.Builder<TakeTrafficDataResponse, Builder> implements b<TakeTrafficDataResponse> {
        public TrafficData data;
        public Long recv_bytes;
        public Long send_bytes;

        @Override // com.squareup.wire.Message.Builder
        public TakeTrafficDataResponse build() {
            return new TakeTrafficDataResponse(this.send_bytes, this.recv_bytes, this.data, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder data(TrafficData r100) {
            this.data = r100;
            return this;
        }

        public Builder recv_bytes(Long r100) {
            this.recv_bytes = r100;
            return this;
        }

        public Builder send_bytes(Long r100) {
            this.send_bytes = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TakeTrafficDataResponse extends ProtoAdapter<TakeTrafficDataResponse> implements a<TakeTrafficDataResponse> {
        public ProtoAdapter_TakeTrafficDataResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, TakeTrafficDataResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TakeTrafficDataResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.send_bytes = 0L;
            r101.recv_bytes = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.send_bytes = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.recv_bytes = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.data = TrafficData.ADAPTER.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TakeTrafficDataResponse r100) {
            Long r101 = r100.send_bytes;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.recv_bytes;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            TrafficData r107 = r100.data;
            if (r107 == null) goto L14;
            r102 = TrafficData.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            return (r106 + r102) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TakeTrafficDataResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TakeTrafficDataResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TakeTrafficDataResponse r101) throws IOException {
            Long r102 = r101.send_bytes;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.recv_bytes;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            TrafficData r104 = r101.data;
            if (r104 == null) goto L11;
            TrafficData.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TakeTrafficDataResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_TakeTrafficDataResponse r100 = new ProtoAdapter_TakeTrafficDataResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SEND_BYTES = 0L;
        DEFAULT_RECV_BYTES = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.send_bytes = this.send_bytes;
        r100.recv_bytes = this.recv_bytes;
        r100.data = this.data;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TakeTrafficDataResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TakeTrafficDataResponse(Long r100, Long r101, TrafficData r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public TakeTrafficDataResponse(Long r100, Long r101, TrafficData r102, ByteString r103) {
        super(ADAPTER, r103);
        this.send_bytes = r100;
        this.recv_bytes = r101;
        this.data = r102;
    }
}
