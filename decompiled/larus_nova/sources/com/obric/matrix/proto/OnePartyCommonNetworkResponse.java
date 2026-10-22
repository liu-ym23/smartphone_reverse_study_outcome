package com.obric.matrix.proto;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
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
public final class OnePartyCommonNetworkResponse extends Message<OnePartyCommonNetworkResponse, Builder> {
    public static final ProtoAdapter<OnePartyCommonNetworkResponse> ADAPTER = null;
    public static final String DEFAULT_BODY = "";
    public static final Boolean DEFAULT_ISSUCCEED = null;
    public static final String DEFAULT_SERVERLOGID = "";
    private static final long serialVersionUID = 0;

    @SerializedName(ContainerPosition.BODY)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String body;

    @SerializedName("extraMap")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final Map<String, String> extraMap;

    @SerializedName("isSucceed")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    public final Boolean isSucceed;

    @SerializedName("serverLogId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String serverLogId;

    public static final class Builder extends Message.Builder<OnePartyCommonNetworkResponse, Builder> {
        public String body;
        public Map<String, String> extraMap;
        public Boolean isSucceed;
        public String serverLogId;

        @Override // com.squareup.wire.Message.Builder
        public OnePartyCommonNetworkResponse build() {
            return new OnePartyCommonNetworkResponse(this.isSucceed, this.body, this.serverLogId, this.extraMap, super.buildUnknownFields());
        }

        public Builder() {
            this.isSucceed = Boolean.FALSE;
            this.body = "";
            this.serverLogId = "";
            this.extraMap = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder body(String r100) {
            this.body = r100;
            return this;
        }

        public Builder extraMap(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.extraMap = r100;
            return this;
        }

        public Builder isSucceed(Boolean r100) {
            this.isSucceed = r100;
            return this;
        }

        public Builder serverLogId(String r100) {
            this.serverLogId = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_OnePartyCommonNetworkResponse extends ProtoAdapter<OnePartyCommonNetworkResponse> {
        private final ProtoAdapter<Map<String, String>> extraMap;

        public ProtoAdapter_OnePartyCommonNetworkResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, OnePartyCommonNetworkResponse.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.extraMap = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public OnePartyCommonNetworkResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.isSucceed(ProtoAdapter.BOOL.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.body(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.serverLogId(ProtoAdapter.STRING.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.extraMap.putAll(this.extraMap.decode(r100));
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
        public int encodedSize2(OnePartyCommonNetworkResponse r100) {
            int r101 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r100.isSucceed);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            return (((r101 + r102.encodedSizeWithTag(2, r100.body)) + r102.encodedSizeWithTag(3, r100.serverLogId)) + this.extraMap.encodedSizeWithTag(4, r100.extraMap)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public OnePartyCommonNetworkResponse redact2(OnePartyCommonNetworkResponse r100) {
            Builder r101 = r100.newBuilder();
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ OnePartyCommonNetworkResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(OnePartyCommonNetworkResponse r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ OnePartyCommonNetworkResponse redact(OnePartyCommonNetworkResponse r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, OnePartyCommonNetworkResponse r101) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r101.isSucceed);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 2, r101.body);
            r102.encodeWithTag(r100, 3, r101.serverLogId);
            this.extraMap.encodeWithTag(r100, 4, r101.extraMap);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OnePartyCommonNetworkResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_OnePartyCommonNetworkResponse();
        DEFAULT_ISSUCCEED = Boolean.FALSE;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L17;
        int r101 = unknownFields().hashCode() * 37;
        Boolean r102 = this.isSucceed;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.hashCode();
    L8:
        int r105 = (r101 + r104) * 37;
        String r106 = this.body;
        if (r106 == null) goto L11;
        int r107 = r106.hashCode();
    L12:
        int r108 = (r105 + r107) * 37;
        String r109 = this.serverLogId;
        if (r109 == null) goto L15;
        r103 = r109.hashCode();
    L15:
        int r110 = ((r108 + r103) * 37) + this.extraMap.hashCode();
        this.hashCode = r110;
        return r110;
    L11:
        r107 = 0;
        goto L12
    L7:
        r104 = 0;
        goto L8
    L17:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.isSucceed = this.isSucceed;
        r100.body = this.body;
        r100.serverLogId = this.serverLogId;
        r100.extraMap = Internal.copyOf("extraMap", this.extraMap);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.isSucceed == null) goto L6;
        r100.append(", isSucceed=");
        r100.append(this.isSucceed);
    L6:
        if (this.body == null) goto L9;
        r100.append(", body=");
        r100.append(this.body);
    L9:
        if (this.serverLogId == null) goto L11;
        r100.append(", serverLogId=");
        r100.append(this.serverLogId);
    L11:
        Map<String, String> r101 = this.extraMap;
        if (r101 != null) goto L14;
    L16:
        StringBuilder r102 = r100.replace(0, 2, "OnePartyCommonNetworkResponse{");
        r102.append('}');
        return r102.toString();
    L14:
        if (r101.isEmpty() == true) goto L16;
        r100.append(", extraMap=");
        r100.append(this.extraMap);
        goto L16
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof OnePartyCommonNetworkResponse) == true) goto L8;
        return false;
    L8:
        OnePartyCommonNetworkResponse r101 = (OnePartyCommonNetworkResponse) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L19:
        return false;
    L11:
        if (Internal.equals(this.isSucceed, r101.isSucceed) == false) goto L19;
        if (Internal.equals(this.body, r101.body) == false) goto L19;
        if (Internal.equals(this.serverLogId, r101.serverLogId) == false) goto L19;
        if (this.extraMap.equals(r101.extraMap) == false) goto L19;
        return true;
    }

    public OnePartyCommonNetworkResponse(Boolean r100, String r101, String r102, Map<String, String> r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public OnePartyCommonNetworkResponse(Boolean r100, String r101, String r102, Map<String, String> r103, ByteString r104) {
        super(ADAPTER, r104);
        this.isSucceed = r100;
        this.body = r101;
        this.serverLogId = r102;
        this.extraMap = Internal.immutableCopyOf("extraMap", r103);
    }
}
