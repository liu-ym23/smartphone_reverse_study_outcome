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
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes33.dex */
public final class SendApplogEventRequest extends Message<SendApplogEventRequest, Builder> {
    public static final ProtoAdapter<SendApplogEventRequest> ADAPTER = null;
    public static final String DEFAULT_APPID = "";
    private static final long serialVersionUID = 0;

    @SerializedName("appid")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String appid;

    @SerializedName("eventMap")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final Map<String, String> eventMap;

    public static final class Builder extends Message.Builder<SendApplogEventRequest, Builder> {
        public String appid;
        public Map<String, String> eventMap;

        @Override // com.squareup.wire.Message.Builder
        public SendApplogEventRequest build() {
            return new SendApplogEventRequest(this.appid, this.eventMap, super.buildUnknownFields());
        }

        public Builder() {
            this.appid = "";
            this.eventMap = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder appid(String r100) {
            this.appid = r100;
            return this;
        }

        public Builder eventMap(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.eventMap = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SendApplogEventRequest extends ProtoAdapter<SendApplogEventRequest> {
        private final ProtoAdapter<Map<String, String>> eventMap;

        public ProtoAdapter_SendApplogEventRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SendApplogEventRequest.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.eventMap = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SendApplogEventRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.appid(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.eventMap.putAll(this.eventMap.decode(r100));
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
        public int encodedSize2(SendApplogEventRequest r100) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.appid) + this.eventMap.encodedSizeWithTag(2, r100.eventMap)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public SendApplogEventRequest redact2(SendApplogEventRequest r100) {
            Builder r101 = r100.newBuilder();
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SendApplogEventRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SendApplogEventRequest r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SendApplogEventRequest redact(SendApplogEventRequest r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SendApplogEventRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.appid);
            this.eventMap.encodeWithTag(r100, 2, r101.eventMap);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SendApplogEventRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SendApplogEventRequest();
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L10;
        int r101 = unknownFields().hashCode() * 37;
        String r102 = this.appid;
        if (r102 == null) goto L7;
        int r103 = r102.hashCode();
    L8:
        int r104 = ((r101 + r103) * 37) + this.eventMap.hashCode();
        this.hashCode = r104;
        return r104;
    L7:
        r103 = 0;
        goto L8
    L10:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.appid = this.appid;
        r100.eventMap = Internal.copyOf("eventMap", this.eventMap);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.appid == null) goto L5;
        r100.append(", appid=");
        r100.append(this.appid);
    L5:
        Map<String, String> r101 = this.eventMap;
        if (r101 != null) goto L8;
    L10:
        StringBuilder r102 = r100.replace(0, 2, "SendApplogEventRequest{");
        r102.append('}');
        return r102.toString();
    L8:
        if (r101.isEmpty() == true) goto L10;
        r100.append(", eventMap=");
        r100.append(this.eventMap);
        goto L10
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof SendApplogEventRequest) == true) goto L8;
        return false;
    L8:
        SendApplogEventRequest r101 = (SendApplogEventRequest) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L15:
        return false;
    L11:
        if (Internal.equals(this.appid, r101.appid) == false) goto L15;
        if (this.eventMap.equals(r101.eventMap) == false) goto L15;
        return true;
    }

    public SendApplogEventRequest(String r100, Map<String, String> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public SendApplogEventRequest(String r100, Map<String, String> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.appid = r100;
        this.eventMap = Internal.immutableCopyOf("eventMap", r101);
    }
}
