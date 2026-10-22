package com.bytedance.lark.pb.basic.v1;

import annotation.Debug;
import com.google.protobuf.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TrafficData extends com.squareup.wire.Message<TrafficData, Builder> {
    public static final ProtoAdapter<TrafficData> ADAPTER = null;
    public static final Long DEFAULT_MOBILE_RECV = null;
    public static final Long DEFAULT_MOBILE_SEND = null;
    public static final Long DEFAULT_WIFI_RECV = null;
    public static final Long DEFAULT_WIFI_SEND = null;
    public static final FieldOptions FIELD_OPTIONS_MOBILE_RECV = null;
    public static final FieldOptions FIELD_OPTIONS_MOBILE_SEND = null;
    public static final FieldOptions FIELD_OPTIONS_WIFI_RECV = null;
    public static final FieldOptions FIELD_OPTIONS_WIFI_SEND = null;
    private static final long serialVersionUID = 0;
    public final Long mobile_recv;
    public final Long mobile_send;
    public final Long wifi_recv;
    public final Long wifi_send;

    public static final class Builder extends com.squareup.wire.Message.Builder<TrafficData, Builder> {
        public Long mobile_recv;
        public Long mobile_send;
        public Long wifi_recv;
        public Long wifi_send;

        @Override // com.squareup.wire.Message.Builder
        public TrafficData build() {
            return new TrafficData(this.wifi_recv, this.wifi_send, this.mobile_recv, this.mobile_send, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder mobile_recv(Long r100) {
            this.mobile_recv = r100;
            return this;
        }

        public Builder mobile_send(Long r100) {
            this.mobile_send = r100;
            return this;
        }

        public Builder wifi_recv(Long r100) {
            this.wifi_recv = r100;
            return this;
        }

        public Builder wifi_send(Long r100) {
            this.wifi_send = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TrafficData extends ProtoAdapter<TrafficData> {
        public ProtoAdapter_TrafficData() {
            super(FieldEncoding.LENGTH_DELIMITED, TrafficData.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TrafficData decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.wifi_recv = 0L;
            r101.wifi_send = 0L;
            r101.mobile_recv = 0L;
            r101.mobile_send = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.wifi_recv = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.wifi_send = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mobile_recv = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.mobile_send = ProtoAdapter.INT64.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TrafficData r100) {
            Long r101 = r100.wifi_recv;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.wifi_send;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.mobile_recv;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Long r110 = r100.mobile_send;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(4, r110);
        L18:
            return (r109 + r102) + r100.unknownFields().size();
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TrafficData decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TrafficData r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TrafficData r101) throws IOException {
            Long r102 = r101.wifi_recv;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.wifi_send;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.mobile_recv;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L11:
            Long r105 = r101.mobile_send;
            if (r105 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TrafficData r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TrafficData();
        FIELD_OPTIONS_WIFI_RECV = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_WIFI_SEND = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_MOBILE_RECV = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_MOBILE_SEND = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        DEFAULT_WIFI_RECV = 0L;
        DEFAULT_WIFI_SEND = 0L;
        DEFAULT_MOBILE_RECV = 0L;
        DEFAULT_MOBILE_SEND = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.wifi_recv = this.wifi_recv;
        r100.wifi_send = this.wifi_send;
        r100.mobile_recv = this.mobile_recv;
        r100.mobile_send = this.mobile_send;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TrafficData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public TrafficData(Long r100, Long r101, Long r102, Long r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public TrafficData(Long r100, Long r101, Long r102, Long r103, ByteString r104) {
        super(ADAPTER, r104);
        this.wifi_recv = r100;
        this.wifi_send = r101;
        this.mobile_recv = r102;
        this.mobile_send = r103;
    }
}
