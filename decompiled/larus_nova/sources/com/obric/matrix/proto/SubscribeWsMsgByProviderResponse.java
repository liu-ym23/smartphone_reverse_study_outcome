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
import okio.ByteString;

/* JADX INFO: loaded from: classes33.dex */
public final class SubscribeWsMsgByProviderResponse extends Message<SubscribeWsMsgByProviderResponse, Builder> {
    public static final ProtoAdapter<SubscribeWsMsgByProviderResponse> ADAPTER = null;
    public static final String DEFAULT_EXT = "";
    public static final Boolean DEFAULT_SUBSCRIBERESULT = null;
    private static final long serialVersionUID = 0;

    @SerializedName("ext")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String ext;

    @SerializedName("subscribeResult")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    public final Boolean subscribeResult;

    public static final class Builder extends Message.Builder<SubscribeWsMsgByProviderResponse, Builder> {
        public String ext;
        public Boolean subscribeResult;

        @Override // com.squareup.wire.Message.Builder
        public SubscribeWsMsgByProviderResponse build() {
            return new SubscribeWsMsgByProviderResponse(this.subscribeResult, this.ext, super.buildUnknownFields());
        }

        public Builder() {
            this.subscribeResult = Boolean.FALSE;
            this.ext = "";
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder ext(String r100) {
            this.ext = r100;
            return this;
        }

        public Builder subscribeResult(Boolean r100) {
            this.subscribeResult = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SubscribeWsMsgByProviderResponse extends ProtoAdapter<SubscribeWsMsgByProviderResponse> {
        public ProtoAdapter_SubscribeWsMsgByProviderResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SubscribeWsMsgByProviderResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SubscribeWsMsgByProviderResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.subscribeResult(ProtoAdapter.BOOL.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.ext(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(SubscribeWsMsgByProviderResponse r100) {
            return (ProtoAdapter.BOOL.encodedSizeWithTag(1, r100.subscribeResult) + ProtoAdapter.STRING.encodedSizeWithTag(2, r100.ext)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public SubscribeWsMsgByProviderResponse redact2(SubscribeWsMsgByProviderResponse r100) {
            Builder r101 = r100.newBuilder();
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SubscribeWsMsgByProviderResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SubscribeWsMsgByProviderResponse r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SubscribeWsMsgByProviderResponse redact(SubscribeWsMsgByProviderResponse r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SubscribeWsMsgByProviderResponse r101) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r101.subscribeResult);
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r101.ext);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SubscribeWsMsgByProviderResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SubscribeWsMsgByProviderResponse();
        DEFAULT_SUBSCRIBERESULT = Boolean.FALSE;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L13;
        int r101 = unknownFields().hashCode() * 37;
        Boolean r102 = this.subscribeResult;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.hashCode();
    L8:
        int r105 = (r101 + r104) * 37;
        String r106 = this.ext;
        if (r106 == null) goto L11;
        r103 = r106.hashCode();
    L11:
        int r107 = r105 + r103;
        this.hashCode = r107;
        return r107;
    L7:
        r104 = 0;
        goto L8
    L13:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.subscribeResult = this.subscribeResult;
        r100.ext = this.ext;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.subscribeResult == null) goto L6;
        r100.append(", subscribeResult=");
        r100.append(this.subscribeResult);
    L6:
        if (this.ext == null) goto L8;
        r100.append(", ext=");
        r100.append(this.ext);
    L8:
        StringBuilder r101 = r100.replace(0, 2, "SubscribeWsMsgByProviderResponse{");
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
        if ((r100 instanceof SubscribeWsMsgByProviderResponse) == true) goto L8;
        return false;
    L8:
        SubscribeWsMsgByProviderResponse r101 = (SubscribeWsMsgByProviderResponse) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L15:
        return false;
    L11:
        if (Internal.equals(this.subscribeResult, r101.subscribeResult) == false) goto L15;
        if (Internal.equals(this.ext, r101.ext) == false) goto L15;
        return true;
    }

    public SubscribeWsMsgByProviderResponse(Boolean r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public SubscribeWsMsgByProviderResponse(Boolean r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.subscribeResult = r100;
        this.ext = r101;
    }
}
