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
public final class SubscribeWsMsgResponse extends Message<SubscribeWsMsgResponse, Builder> {
    public static final ProtoAdapter<SubscribeWsMsgResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @SerializedName("wsMessageInfo")
    @WireField(adapter = "com.obric.matrix.proto.WsMessageInfo#ADAPTER", tag = 1)
    public final WsMessageInfo wsMessageInfo;

    public static final class Builder extends Message.Builder<SubscribeWsMsgResponse, Builder> {
        public WsMessageInfo wsMessageInfo;

        @Override // com.squareup.wire.Message.Builder
        public SubscribeWsMsgResponse build() {
            return new SubscribeWsMsgResponse(this.wsMessageInfo, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder wsMessageInfo(WsMessageInfo r100) {
            this.wsMessageInfo = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SubscribeWsMsgResponse extends ProtoAdapter<SubscribeWsMsgResponse> {
        public ProtoAdapter_SubscribeWsMsgResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SubscribeWsMsgResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SubscribeWsMsgResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.wsMessageInfo(WsMessageInfo.ADAPTER.decode(r100));
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
        public int encodedSize2(SubscribeWsMsgResponse r100) {
            return WsMessageInfo.ADAPTER.encodedSizeWithTag(1, r100.wsMessageInfo) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public SubscribeWsMsgResponse redact2(SubscribeWsMsgResponse r100) {
            Builder r101 = r100.newBuilder();
            WsMessageInfo r102 = r101.wsMessageInfo;
            if (r102 == null) goto L5;
            r101.wsMessageInfo = WsMessageInfo.ADAPTER.redact(r102);
        L5:
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SubscribeWsMsgResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SubscribeWsMsgResponse r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SubscribeWsMsgResponse redact(SubscribeWsMsgResponse r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SubscribeWsMsgResponse r101) throws IOException {
            WsMessageInfo.ADAPTER.encodeWithTag(r100, 1, r101.wsMessageInfo);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SubscribeWsMsgResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SubscribeWsMsgResponse();
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L10;
        int r101 = unknownFields().hashCode() * 37;
        WsMessageInfo r102 = this.wsMessageInfo;
        if (r102 == null) goto L7;
        int r103 = r102.hashCode();
    L8:
        int r104 = r101 + r103;
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
        r100.wsMessageInfo = this.wsMessageInfo;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.wsMessageInfo == null) goto L5;
        r100.append(", wsMessageInfo=");
        r100.append(this.wsMessageInfo);
    L5:
        StringBuilder r101 = r100.replace(0, 2, "SubscribeWsMsgResponse{");
        r101.append('}');
        return r101.toString();
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SubscribeWsMsgResponse(WsMessageInfo r100) {
        this(r100, ByteString.EMPTY);
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof SubscribeWsMsgResponse) == true) goto L8;
        return false;
    L8:
        SubscribeWsMsgResponse r101 = (SubscribeWsMsgResponse) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L13:
        return false;
    L11:
        if (Internal.equals(this.wsMessageInfo, r101.wsMessageInfo) == false) goto L13;
        return true;
    }

    public SubscribeWsMsgResponse(WsMessageInfo r100, ByteString r101) {
        super(ADAPTER, r101);
        this.wsMessageInfo = r100;
    }
}
