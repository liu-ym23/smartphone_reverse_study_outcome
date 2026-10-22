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
import okio.ByteString;

/* JADX INFO: loaded from: classes33.dex */
public final class GenericNetworkResponse extends Message<GenericNetworkResponse, Builder> {
    public static final ProtoAdapter<GenericNetworkResponse> ADAPTER = null;
    public static final String DEFAULT_BODY = "";
    public static final Boolean DEFAULT_ISSUCCEED = null;
    public static final String DEFAULT_SERVERLOGID = "";
    private static final long serialVersionUID = 0;

    @SerializedName(ContainerPosition.BODY)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 2)
    public final String body;

    @SerializedName("isSucceed")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", label = WireField.Label.REQUIRED, tag = 1)
    public final Boolean isSucceed;

    @SerializedName("serverLogId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 3)
    public final String serverLogId;

    public static final class Builder extends Message.Builder<GenericNetworkResponse, Builder> {
        public String body;
        public Boolean isSucceed;
        public String serverLogId;

        @Override // com.squareup.wire.Message.Builder
        public GenericNetworkResponse build() {
            Boolean r100 = this.isSucceed;
            if (r100 == null) goto L11;
            if (this.body == null) goto L11;
            if (this.serverLogId == null) goto L11;
            return new GenericNetworkResponse(this.isSucceed, this.body, this.serverLogId, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "isSucceed", this.body, ContainerPosition.BODY, this.serverLogId, "serverLogId"});
        }

        public Builder() {
            this.isSucceed = Boolean.FALSE;
            this.body = "";
            this.serverLogId = "";
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder body(String r100) {
            this.body = r100;
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

    public static final class ProtoAdapter_GenericNetworkResponse extends ProtoAdapter<GenericNetworkResponse> {
        public ProtoAdapter_GenericNetworkResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GenericNetworkResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GenericNetworkResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.isSucceed(ProtoAdapter.BOOL.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.body(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.serverLogId(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(GenericNetworkResponse r100) {
            int r101 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r100.isSucceed);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            return ((r101 + r102.encodedSizeWithTag(2, r100.body)) + r102.encodedSizeWithTag(3, r100.serverLogId)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public GenericNetworkResponse redact2(GenericNetworkResponse r100) {
            Builder r101 = r100.newBuilder();
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GenericNetworkResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GenericNetworkResponse r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GenericNetworkResponse redact(GenericNetworkResponse r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GenericNetworkResponse r101) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r101.isSucceed);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 2, r101.body);
            r102.encodeWithTag(r100, 3, r101.serverLogId);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GenericNetworkResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GenericNetworkResponse();
        DEFAULT_ISSUCCEED = Boolean.FALSE;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L6;
        int r101 = (((((unknownFields().hashCode() * 37) + this.isSucceed.hashCode()) * 37) + this.body.hashCode()) * 37) + this.serverLogId.hashCode();
        this.hashCode = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.isSucceed = this.isSucceed;
        r100.body = this.body;
        r100.serverLogId = this.serverLogId;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(", isSucceed=");
        r100.append(this.isSucceed);
        r100.append(", body=");
        r100.append(this.body);
        r100.append(", serverLogId=");
        r100.append(this.serverLogId);
        StringBuilder r101 = r100.replace(0, 2, "GenericNetworkResponse{");
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
        if ((r100 instanceof GenericNetworkResponse) == true) goto L8;
        return false;
    L8:
        GenericNetworkResponse r101 = (GenericNetworkResponse) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L17:
        return false;
    L11:
        if (this.isSucceed.equals(r101.isSucceed) == false) goto L17;
        if (this.body.equals(r101.body) == false) goto L17;
        if (this.serverLogId.equals(r101.serverLogId) == false) goto L17;
        return true;
    }

    public GenericNetworkResponse(Boolean r100, String r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GenericNetworkResponse(Boolean r100, String r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.isSucceed = r100;
        this.body = r101;
        this.serverLogId = r102;
    }
}
