package com.ss.ugc.live.sdk.msg.unify.data.idl;

import android.os.Parcelable;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes36.dex */
public final class UMGWConnectionInfo extends AndroidMessage<UMGWConnectionInfo, Builder> {
    public static final ProtoAdapter<UMGWConnectionInfo> ADAPTER = null;
    public static final Parcelable.Creator<UMGWConnectionInfo> CREATOR = null;
    public static final Long DEFAULT_FETCH_INTERVAL = null;
    public static final Integer DEFAULT_FETCH_TYPE = null;
    public static final Long DEFAULT_HEARTBEAT_DURATION = null;
    public static final String DEFAULT_WSS_URL = "";
    public static final String DEFAULT_WSS_URL_V2 = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 1)
    public final Long fetch_interval;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer fetch_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    public final Long heartbeat_duration;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String wss_url;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String wss_url_v2;

    public static final class Builder extends Message.Builder<UMGWConnectionInfo, Builder> {
        public Long fetch_interval;
        public Integer fetch_type;
        public Long heartbeat_duration;
        public String wss_url;
        public String wss_url_v2;

        @Override // com.squareup.wire.Message.Builder
        public UMGWConnectionInfo build() {
            return new UMGWConnectionInfo(this.fetch_interval, this.fetch_type, this.wss_url, this.heartbeat_duration, this.wss_url_v2, super.buildUnknownFields());
        }

        public Builder() {
            this.fetch_interval = 0L;
            this.fetch_type = 0;
            this.wss_url = "";
            this.heartbeat_duration = 0L;
            this.wss_url_v2 = "";
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder fetch_interval(Long r100) {
            this.fetch_interval = r100;
            return this;
        }

        public Builder fetch_type(Integer r100) {
            this.fetch_type = r100;
            return this;
        }

        public Builder heartbeat_duration(Long r100) {
            this.heartbeat_duration = r100;
            return this;
        }

        public Builder wss_url(String r100) {
            this.wss_url = r100;
            return this;
        }

        public Builder wss_url_v2(String r100) {
            this.wss_url_v2 = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UMGWConnectionInfo extends ProtoAdapter<UMGWConnectionInfo> {
        public ProtoAdapter_UMGWConnectionInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, UMGWConnectionInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UMGWConnectionInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.fetch_interval(ProtoAdapter.INT64.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.fetch_type(ProtoAdapter.INT32.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.wss_url(ProtoAdapter.STRING.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.heartbeat_duration(ProtoAdapter.INT64.decode(r100));
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.wss_url_v2(ProtoAdapter.STRING.decode(r100));
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UMGWConnectionInfo r100) {
            ProtoAdapter<Long> r101 = ProtoAdapter.INT64;
            int r102 = r101.encodedSizeWithTag(1, r100.fetch_interval) + ProtoAdapter.INT32.encodedSizeWithTag(2, r100.fetch_type);
            ProtoAdapter<String> r103 = ProtoAdapter.STRING;
            return (((r102 + r103.encodedSizeWithTag(3, r100.wss_url)) + r101.encodedSizeWithTag(4, r100.heartbeat_duration)) + r103.encodedSizeWithTag(5, r100.wss_url_v2)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public UMGWConnectionInfo redact2(UMGWConnectionInfo r100) {
            Builder r101 = r100.newBuilder();
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UMGWConnectionInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UMGWConnectionInfo r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UMGWConnectionInfo redact(UMGWConnectionInfo r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UMGWConnectionInfo r101) throws IOException {
            ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
            r102.encodeWithTag(r100, 1, r101.fetch_interval);
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r101.fetch_type);
            ProtoAdapter<String> r103 = ProtoAdapter.STRING;
            r103.encodeWithTag(r100, 3, r101.wss_url);
            r102.encodeWithTag(r100, 4, r101.heartbeat_duration);
            r103.encodeWithTag(r100, 5, r101.wss_url_v2);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UMGWConnectionInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UMGWConnectionInfo r100 = new ProtoAdapter_UMGWConnectionInfo();
        ADAPTER = r100;
        CREATOR = AndroidMessage.newCreator(r100);
        DEFAULT_FETCH_INTERVAL = 0L;
        DEFAULT_FETCH_TYPE = 0;
        DEFAULT_HEARTBEAT_DURATION = 0L;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L25;
        int r101 = unknownFields().hashCode() * 37;
        Long r102 = this.fetch_interval;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.hashCode();
    L8:
        int r105 = (r101 + r104) * 37;
        Integer r106 = this.fetch_type;
        if (r106 == null) goto L11;
        int r107 = r106.hashCode();
    L12:
        int r108 = (r105 + r107) * 37;
        String r109 = this.wss_url;
        if (r109 == null) goto L15;
        int r110 = r109.hashCode();
    L16:
        int r111 = (r108 + r110) * 37;
        Long r112 = this.heartbeat_duration;
        if (r112 == null) goto L19;
        int r113 = r112.hashCode();
    L20:
        int r114 = (r111 + r113) * 37;
        String r115 = this.wss_url_v2;
        if (r115 == null) goto L23;
        r103 = r115.hashCode();
    L23:
        int r116 = r114 + r103;
        this.hashCode = r116;
        return r116;
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
    L25:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.fetch_interval = this.fetch_interval;
        r100.fetch_type = this.fetch_type;
        r100.wss_url = this.wss_url;
        r100.heartbeat_duration = this.heartbeat_duration;
        r100.wss_url_v2 = this.wss_url_v2;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.fetch_interval == null) goto L6;
        r100.append(", fetch_interval=");
        r100.append(this.fetch_interval);
    L6:
        if (this.fetch_type == null) goto L9;
        r100.append(", fetch_type=");
        r100.append(this.fetch_type);
    L9:
        if (this.wss_url == null) goto L12;
        r100.append(", wss_url=");
        r100.append(this.wss_url);
    L12:
        if (this.heartbeat_duration == null) goto L15;
        r100.append(", heartbeat_duration=");
        r100.append(this.heartbeat_duration);
    L15:
        if (this.wss_url_v2 == null) goto L17;
        r100.append(", wss_url_v2=");
        r100.append(this.wss_url_v2);
    L17:
        StringBuilder r101 = r100.replace(0, 2, "UMGWConnectionInfo{");
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
        if ((r100 instanceof UMGWConnectionInfo) == true) goto L8;
        return false;
    L8:
        UMGWConnectionInfo r101 = (UMGWConnectionInfo) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L21:
        return false;
    L11:
        if (Internal.equals(this.fetch_interval, r101.fetch_interval) == false) goto L21;
        if (Internal.equals(this.fetch_type, r101.fetch_type) == false) goto L21;
        if (Internal.equals(this.wss_url, r101.wss_url) == false) goto L21;
        if (Internal.equals(this.heartbeat_duration, r101.heartbeat_duration) == false) goto L21;
        if (Internal.equals(this.wss_url_v2, r101.wss_url_v2) == false) goto L21;
        return true;
    }

    public UMGWConnectionInfo(Long r100, Integer r101, String r110, Long r111, String r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public UMGWConnectionInfo(Long r100, Integer r101, String r102, Long r103, String r104, ByteString r105) {
        super(ADAPTER, r105);
        this.fetch_interval = r100;
        this.fetch_type = r101;
        this.wss_url = r102;
        this.heartbeat_duration = r103;
        this.wss_url_v2 = r104;
    }
}
