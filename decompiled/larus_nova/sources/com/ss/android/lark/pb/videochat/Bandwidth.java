package com.ss.android.lark.pb.videochat;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class Bandwidth extends Message<Bandwidth, Builder> {
    public static final ProtoAdapter<Bandwidth> ADAPTER = null;
    public static final Boolean DEFAULT_BANDWIDTH_STATUS = null;
    public static final Long DEFAULT_DESKTOP_DOWNSTREAM_BANDWIDTH = null;
    public static final Long DEFAULT_DESKTOP_UPSTREAM_BANDWIDTH = null;
    public static final Long DEFAULT_MOBILE_DOWNSTREAM_BANDWIDTH = null;
    public static final Long DEFAULT_MOBILE_UPSTREAM_BANDWIDTH = null;
    public static final Long DEFAULT_WEB_DOWNSTREAM_BANDWIDTH = null;
    public static final Long DEFAULT_WEB_UPSTREAM_BANDWIDTH = null;
    private static final long serialVersionUID = 0;
    public final Boolean mbandwidth_status;
    public final Long mdesktop_downstream_bandwidth;
    public final Long mdesktop_upstream_bandwidth;
    public final Long mmobile_downstream_bandwidth;
    public final Long mmobile_upstream_bandwidth;
    public final Long mweb_downstream_bandwidth;
    public final Long mweb_upstream_bandwidth;

    public static final class Builder extends Message.Builder<Bandwidth, Builder> {
        public Boolean mbandwidth_status;
        public Long mdesktop_downstream_bandwidth;
        public Long mdesktop_upstream_bandwidth;
        public Long mmobile_downstream_bandwidth;
        public Long mmobile_upstream_bandwidth;
        public Long mweb_downstream_bandwidth;
        public Long mweb_upstream_bandwidth;

        @Override // com.squareup.wire.Message.Builder
        public Bandwidth build() {
            return new Bandwidth(this.mbandwidth_status, this.mweb_upstream_bandwidth, this.mweb_downstream_bandwidth, this.mmobile_upstream_bandwidth, this.mmobile_downstream_bandwidth, this.mdesktop_upstream_bandwidth, this.mdesktop_downstream_bandwidth, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder bandwidth_status(Boolean r100) {
            this.mbandwidth_status = r100;
            return this;
        }

        public Builder desktop_downstream_bandwidth(Long r100) {
            this.mdesktop_downstream_bandwidth = r100;
            return this;
        }

        public Builder desktop_upstream_bandwidth(Long r100) {
            this.mdesktop_upstream_bandwidth = r100;
            return this;
        }

        public Builder mobile_downstream_bandwidth(Long r100) {
            this.mmobile_downstream_bandwidth = r100;
            return this;
        }

        public Builder mobile_upstream_bandwidth(Long r100) {
            this.mmobile_upstream_bandwidth = r100;
            return this;
        }

        public Builder web_downstream_bandwidth(Long r100) {
            this.mweb_downstream_bandwidth = r100;
            return this;
        }

        public Builder web_upstream_bandwidth(Long r100) {
            this.mweb_upstream_bandwidth = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Bandwidth extends ProtoAdapter<Bandwidth> {
        public ProtoAdapter_Bandwidth() {
            super(FieldEncoding.LENGTH_DELIMITED, Bandwidth.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Bandwidth decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mbandwidth_status = Boolean.FALSE;
            r101.mweb_upstream_bandwidth = 0L;
            r101.mweb_downstream_bandwidth = 0L;
            r101.mmobile_upstream_bandwidth = 0L;
            r101.mmobile_downstream_bandwidth = 0L;
            r101.mdesktop_upstream_bandwidth = 0L;
            r101.mdesktop_downstream_bandwidth = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L14;
            switch(r103) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r101.mdesktop_downstream_bandwidth = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            r101.mdesktop_upstream_bandwidth = ProtoAdapter.INT64.decode(r100);
            goto L3
        L9:
            r101.mmobile_downstream_bandwidth = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            r101.mmobile_upstream_bandwidth = ProtoAdapter.INT64.decode(r100);
            goto L3
        L11:
            r101.mweb_downstream_bandwidth = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            r101.mweb_upstream_bandwidth = ProtoAdapter.INT64.decode(r100);
            goto L3
        L13:
            r101.mbandwidth_status = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L14:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Bandwidth r100) {
            Boolean r101 = r100.mbandwidth_status;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.mweb_upstream_bandwidth;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.mweb_downstream_bandwidth;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Long r110 = r100.mmobile_upstream_bandwidth;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.INT64.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Long r113 = r100.mmobile_downstream_bandwidth;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.INT64.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Long r116 = r100.mdesktop_upstream_bandwidth;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.INT64.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Long r119 = r100.mdesktop_downstream_bandwidth;
            if (r119 == null) goto L30;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(7, r119);
        L30:
            return (r118 + r102) + r100.unknownFields().size();
        L25:
            r117 = 0;
            goto L26
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
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
        public /* bridge */ /* synthetic */ Bandwidth decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Bandwidth r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Bandwidth r101) throws IOException {
            Boolean r102 = r101.mbandwidth_status;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.mweb_upstream_bandwidth;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.mweb_downstream_bandwidth;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L11:
            Long r105 = r101.mmobile_upstream_bandwidth;
            if (r105 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r100, 4, r105);
        L14:
            Long r106 = r101.mmobile_downstream_bandwidth;
            if (r106 == null) goto L17;
            ProtoAdapter.INT64.encodeWithTag(r100, 5, r106);
        L17:
            Long r107 = r101.mdesktop_upstream_bandwidth;
            if (r107 == null) goto L20;
            ProtoAdapter.INT64.encodeWithTag(r100, 6, r107);
        L20:
            Long r108 = r101.mdesktop_downstream_bandwidth;
            if (r108 == null) goto L23;
            ProtoAdapter.INT64.encodeWithTag(r100, 7, r108);
        L23:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Bandwidth r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Bandwidth();
        DEFAULT_BANDWIDTH_STATUS = Boolean.FALSE;
        DEFAULT_WEB_UPSTREAM_BANDWIDTH = 0L;
        DEFAULT_WEB_DOWNSTREAM_BANDWIDTH = 0L;
        DEFAULT_MOBILE_UPSTREAM_BANDWIDTH = 0L;
        DEFAULT_MOBILE_DOWNSTREAM_BANDWIDTH = 0L;
        DEFAULT_DESKTOP_UPSTREAM_BANDWIDTH = 0L;
        DEFAULT_DESKTOP_DOWNSTREAM_BANDWIDTH = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mbandwidth_status = this.mbandwidth_status;
        r100.mweb_upstream_bandwidth = this.mweb_upstream_bandwidth;
        r100.mweb_downstream_bandwidth = this.mweb_downstream_bandwidth;
        r100.mmobile_upstream_bandwidth = this.mmobile_upstream_bandwidth;
        r100.mmobile_downstream_bandwidth = this.mmobile_downstream_bandwidth;
        r100.mdesktop_upstream_bandwidth = this.mdesktop_upstream_bandwidth;
        r100.mdesktop_downstream_bandwidth = this.mdesktop_downstream_bandwidth;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Bandwidth.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public Bandwidth(Boolean r110, Long r111, Long r112, Long r113, Long r114, Long r115, Long r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public Bandwidth(Boolean r100, Long r101, Long r102, Long r103, Long r104, Long r105, Long r106, ByteString r107) {
        super(ADAPTER, r107);
        this.mbandwidth_status = r100;
        this.mweb_upstream_bandwidth = r101;
        this.mweb_downstream_bandwidth = r102;
        this.mmobile_upstream_bandwidth = r103;
        this.mmobile_downstream_bandwidth = r104;
        this.mdesktop_upstream_bandwidth = r105;
        this.mdesktop_downstream_bandwidth = r106;
    }
}
