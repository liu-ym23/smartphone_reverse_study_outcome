package com.ss.ugc.live.sdk.msg.data;

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
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes36.dex */
public final class SdkUplinkPacket extends AndroidMessage<SdkUplinkPacket, Builder> {
    public static final ProtoAdapter<SdkUplinkPacket> ADAPTER = null;
    public static final Parcelable.Creator<SdkUplinkPacket> CREATOR = null;
    public static final ByteString DEFAULT_PAYLOAD = null;
    public static final Long DEFAULT_SERVICEID = null;
    public static final Integer DEFAULT_STATUSCODE = null;
    public static final String DEFAULT_STATUSMESSAGE = "";
    public static final Long DEFAULT_UNIQUEID = null;
    public static final Integer DEFAULT_UPLINKSTRATEGY = null;
    public static final String DEFAULT_URI = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final Map<String, String> headers;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 6)
    public final ByteString payload;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final Map<String, String> queryParams;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 2)
    public final Long serviceID;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 7)
    public final Integer statusCode;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 8)
    public final String statusMessage;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 1)
    public final Long uniqueID;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 9)
    public final Integer uplinkStrategy;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String uri;

    public static final class Builder extends Message.Builder<SdkUplinkPacket, Builder> {
        public Map<String, String> headers;
        public ByteString payload;
        public Map<String, String> queryParams;
        public Long serviceID;
        public Integer statusCode;
        public String statusMessage;
        public Long uniqueID;
        public Integer uplinkStrategy;
        public String uri;

        @Override // com.squareup.wire.Message.Builder
        public SdkUplinkPacket build() {
            return new SdkUplinkPacket(this.uniqueID, this.serviceID, this.queryParams, this.headers, this.uri, this.payload, this.statusCode, this.statusMessage, this.uplinkStrategy, super.buildUnknownFields());
        }

        public Builder() {
            this.uniqueID = 0L;
            this.serviceID = 0L;
            this.uri = "";
            this.payload = ByteString.EMPTY;
            this.statusCode = 0;
            this.statusMessage = "";
            this.uplinkStrategy = 0;
            this.queryParams = Internal.newMutableMap();
            this.headers = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder headers(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.headers = r100;
            return this;
        }

        public Builder payload(ByteString r100) {
            this.payload = r100;
            return this;
        }

        public Builder queryParams(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.queryParams = r100;
            return this;
        }

        public Builder serviceID(Long r100) {
            this.serviceID = r100;
            return this;
        }

        public Builder statusCode(Integer r100) {
            this.statusCode = r100;
            return this;
        }

        public Builder statusMessage(String r100) {
            this.statusMessage = r100;
            return this;
        }

        public Builder uniqueID(Long r100) {
            this.uniqueID = r100;
            return this;
        }

        public Builder uplinkStrategy(Integer r100) {
            this.uplinkStrategy = r100;
            return this;
        }

        public Builder uri(String r100) {
            this.uri = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SdkUplinkPacket extends ProtoAdapter<SdkUplinkPacket> {
        private final ProtoAdapter<Map<String, String>> headers;
        private final ProtoAdapter<Map<String, String>> queryParams;

        public ProtoAdapter_SdkUplinkPacket() {
            super(FieldEncoding.LENGTH_DELIMITED, SdkUplinkPacket.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.queryParams = ProtoAdapter.newMapAdapter(r100, r100);
            this.headers = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SdkUplinkPacket decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L16;
            switch(r103) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L7;
                default: goto L6;
            };
        L7:
            r101.uplinkStrategy(ProtoAdapter.INT32.decode(r100));
            goto L3
        L8:
            r101.statusMessage(ProtoAdapter.STRING.decode(r100));
            goto L3
        L9:
            r101.statusCode(ProtoAdapter.INT32.decode(r100));
            goto L3
        L10:
            r101.payload(ProtoAdapter.BYTES.decode(r100));
            goto L3
        L11:
            r101.uri(ProtoAdapter.STRING.decode(r100));
            goto L3
        L12:
            r101.headers.putAll(this.headers.decode(r100));
            goto L3
        L13:
            r101.queryParams.putAll(this.queryParams.decode(r100));
            goto L3
        L14:
            r101.serviceID(ProtoAdapter.INT64.decode(r100));
            goto L3
        L15:
            r101.uniqueID(ProtoAdapter.INT64.decode(r100));
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L16:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SdkUplinkPacket r100) {
            ProtoAdapter<Long> r101 = ProtoAdapter.INT64;
            int r102 = ((r101.encodedSizeWithTag(1, r100.uniqueID) + r101.encodedSizeWithTag(2, r100.serviceID)) + this.queryParams.encodedSizeWithTag(3, r100.queryParams)) + this.headers.encodedSizeWithTag(4, r100.headers);
            ProtoAdapter<String> r103 = ProtoAdapter.STRING;
            int r104 = (r102 + r103.encodedSizeWithTag(5, r100.uri)) + ProtoAdapter.BYTES.encodedSizeWithTag(6, r100.payload);
            ProtoAdapter<Integer> r105 = ProtoAdapter.INT32;
            return (((r104 + r105.encodedSizeWithTag(7, r100.statusCode)) + r103.encodedSizeWithTag(8, r100.statusMessage)) + r105.encodedSizeWithTag(9, r100.uplinkStrategy)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public SdkUplinkPacket redact2(SdkUplinkPacket r100) {
            Builder r101 = r100.newBuilder();
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SdkUplinkPacket decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SdkUplinkPacket r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SdkUplinkPacket redact(SdkUplinkPacket r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SdkUplinkPacket r101) throws IOException {
            ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
            r102.encodeWithTag(r100, 1, r101.uniqueID);
            r102.encodeWithTag(r100, 2, r101.serviceID);
            this.queryParams.encodeWithTag(r100, 3, r101.queryParams);
            this.headers.encodeWithTag(r100, 4, r101.headers);
            ProtoAdapter<String> r103 = ProtoAdapter.STRING;
            r103.encodeWithTag(r100, 5, r101.uri);
            ProtoAdapter.BYTES.encodeWithTag(r100, 6, r101.payload);
            ProtoAdapter<Integer> r104 = ProtoAdapter.INT32;
            r104.encodeWithTag(r100, 7, r101.statusCode);
            r103.encodeWithTag(r100, 8, r101.statusMessage);
            r104.encodeWithTag(r100, 9, r101.uplinkStrategy);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SdkUplinkPacket r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SdkUplinkPacket r100 = new ProtoAdapter_SdkUplinkPacket();
        ADAPTER = r100;
        CREATOR = AndroidMessage.newCreator(r100);
        DEFAULT_UNIQUEID = 0L;
        DEFAULT_SERVICEID = 0L;
        DEFAULT_PAYLOAD = ByteString.EMPTY;
        DEFAULT_STATUSCODE = 0;
        DEFAULT_UPLINKSTRATEGY = 0;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L33;
        int r101 = unknownFields().hashCode() * 37;
        Long r102 = this.uniqueID;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.hashCode();
    L8:
        int r105 = (r101 + r104) * 37;
        Long r106 = this.serviceID;
        if (r106 == null) goto L11;
        int r107 = r106.hashCode();
    L12:
        int r108 = (((((r105 + r107) * 37) + this.queryParams.hashCode()) * 37) + this.headers.hashCode()) * 37;
        String r109 = this.uri;
        if (r109 == null) goto L15;
        int r110 = r109.hashCode();
    L16:
        int r111 = (r108 + r110) * 37;
        ByteString r112 = this.payload;
        if (r112 == null) goto L19;
        int r113 = r112.hashCode();
    L20:
        int r114 = (r111 + r113) * 37;
        Integer r115 = this.statusCode;
        if (r115 == null) goto L23;
        int r116 = r115.hashCode();
    L24:
        int r117 = (r114 + r116) * 37;
        String r118 = this.statusMessage;
        if (r118 == null) goto L27;
        int r119 = r118.hashCode();
    L28:
        int r120 = (r117 + r119) * 37;
        Integer r121 = this.uplinkStrategy;
        if (r121 == null) goto L31;
        r103 = r121.hashCode();
    L31:
        int r122 = r120 + r103;
        this.hashCode = r122;
        return r122;
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
    L33:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.uniqueID = this.uniqueID;
        r100.serviceID = this.serviceID;
        r100.queryParams = Internal.copyOf("queryParams", this.queryParams);
        r100.headers = Internal.copyOf("headers", this.headers);
        r100.uri = this.uri;
        r100.payload = this.payload;
        r100.statusCode = this.statusCode;
        r100.statusMessage = this.statusMessage;
        r100.uplinkStrategy = this.uplinkStrategy;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.uniqueID == null) goto L6;
        r100.append(", uniqueID=");
        r100.append(this.uniqueID);
    L6:
        if (this.serviceID == null) goto L8;
        r100.append(", serviceID=");
        r100.append(this.serviceID);
    L8:
        Map<String, String> r101 = this.queryParams;
        if (r101 != null) goto L11;
    L13:
        Map<String, String> r102 = this.headers;
        if (r102 == null) goto L19;
        if (r102.isEmpty() == true) goto L19;
        r100.append(", headers=");
        r100.append(this.headers);
    L19:
        if (this.uri == null) goto L22;
        r100.append(", uri=");
        r100.append(this.uri);
    L22:
        if (this.statusCode == null) goto L25;
        r100.append(", statusCode=");
        r100.append(this.statusCode);
    L25:
        if (this.statusMessage == null) goto L28;
        r100.append(", statusMessage=");
        r100.append(this.statusMessage);
    L28:
        if (this.uplinkStrategy == null) goto L30;
        r100.append(", uplinkStrategy=");
        r100.append(this.uplinkStrategy);
    L30:
        StringBuilder r103 = r100.replace(0, 2, "SdkUplinkPacket{");
        r103.append('}');
        return r103.toString();
    L11:
        if (r101.isEmpty() == true) goto L13;
        r100.append(", queryParams=");
        r100.append(this.queryParams);
        goto L13
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof SdkUplinkPacket) == true) goto L8;
        return false;
    L8:
        SdkUplinkPacket r101 = (SdkUplinkPacket) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L29:
        return false;
    L11:
        if (Internal.equals(this.uniqueID, r101.uniqueID) == false) goto L29;
        if (Internal.equals(this.serviceID, r101.serviceID) == false) goto L29;
        if (this.queryParams.equals(r101.queryParams) == false) goto L29;
        if (this.headers.equals(r101.headers) == false) goto L29;
        if (Internal.equals(this.uri, r101.uri) == false) goto L29;
        if (Internal.equals(this.payload, r101.payload) == false) goto L29;
        if (Internal.equals(this.statusCode, r101.statusCode) == false) goto L29;
        if (Internal.equals(this.statusMessage, r101.statusMessage) == false) goto L29;
        if (Internal.equals(this.uplinkStrategy, r101.uplinkStrategy) == false) goto L29;
        return true;
    }

    public SdkUplinkPacket(Long r110, Long r111, Map<String, String> r112, Map<String, String> r113, String r114, ByteString r115, Integer r116, String r117, Integer r210) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
    }

    public SdkUplinkPacket(Long r100, Long r101, Map<String, String> r102, Map<String, String> r103, String r104, ByteString r105, Integer r106, String r107, Integer r110, ByteString r111) {
        super(ADAPTER, r111);
        this.uniqueID = r100;
        this.serviceID = r101;
        this.queryParams = Internal.immutableCopyOf("queryParams", r102);
        this.headers = Internal.immutableCopyOf("headers", r103);
        this.uri = r104;
        this.payload = r105;
        this.statusCode = r106;
        this.statusMessage = r107;
        this.uplinkStrategy = r110;
    }
}
