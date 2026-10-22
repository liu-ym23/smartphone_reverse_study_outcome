package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
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
public final class SubscribeWsStatusResponse extends Message<SubscribeWsStatusResponse, Builder> {
    public static final ProtoAdapter<SubscribeWsStatusResponse> ADAPTER = null;
    public static final Integer DEFAULT_CHANNELID = null;
    public static final Integer DEFAULT_CHANNELTYPE = null;
    public static final Integer DEFAULT_CONNECTIONSTATE = null;
    public static final Boolean DEFAULT_ISCONNECTED = null;
    private static final long serialVersionUID = 0;

    @SerializedName(RemoteMessageConst.Notification.CHANNEL_ID)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer channelId;

    @SerializedName("channelType")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer channelType;

    @SerializedName("connectionState")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer connectionState;

    @SerializedName("isConnected")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 4)
    public final Boolean isConnected;

    public static final class Builder extends Message.Builder<SubscribeWsStatusResponse, Builder> {
        public Integer channelId;
        public Integer channelType;
        public Integer connectionState;
        public Boolean isConnected;

        @Override // com.squareup.wire.Message.Builder
        public SubscribeWsStatusResponse build() {
            return new SubscribeWsStatusResponse(this.channelType, this.connectionState, this.channelId, this.isConnected, super.buildUnknownFields());
        }

        public Builder() {
            this.channelType = 0;
            this.connectionState = 0;
            this.channelId = 0;
            this.isConnected = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder channelId(Integer r100) {
            this.channelId = r100;
            return this;
        }

        public Builder channelType(Integer r100) {
            this.channelType = r100;
            return this;
        }

        public Builder connectionState(Integer r100) {
            this.connectionState = r100;
            return this;
        }

        public Builder isConnected(Boolean r100) {
            this.isConnected = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SubscribeWsStatusResponse extends ProtoAdapter<SubscribeWsStatusResponse> {
        public ProtoAdapter_SubscribeWsStatusResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SubscribeWsStatusResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SubscribeWsStatusResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.channelType(ProtoAdapter.INT32.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.connectionState(ProtoAdapter.INT32.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.channelId(ProtoAdapter.INT32.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.isConnected(ProtoAdapter.BOOL.decode(r100));
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
        public int encodedSize2(SubscribeWsStatusResponse r100) {
            ProtoAdapter<Integer> r101 = ProtoAdapter.INT32;
            return (((r101.encodedSizeWithTag(1, r100.channelType) + r101.encodedSizeWithTag(2, r100.connectionState)) + r101.encodedSizeWithTag(3, r100.channelId)) + ProtoAdapter.BOOL.encodedSizeWithTag(4, r100.isConnected)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public SubscribeWsStatusResponse redact2(SubscribeWsStatusResponse r100) {
            Builder r101 = r100.newBuilder();
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SubscribeWsStatusResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SubscribeWsStatusResponse r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SubscribeWsStatusResponse redact(SubscribeWsStatusResponse r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SubscribeWsStatusResponse r101) throws IOException {
            ProtoAdapter<Integer> r102 = ProtoAdapter.INT32;
            r102.encodeWithTag(r100, 1, r101.channelType);
            r102.encodeWithTag(r100, 2, r101.connectionState);
            r102.encodeWithTag(r100, 3, r101.channelId);
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r101.isConnected);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SubscribeWsStatusResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SubscribeWsStatusResponse();
        DEFAULT_CHANNELTYPE = 0;
        DEFAULT_CONNECTIONSTATE = 0;
        DEFAULT_CHANNELID = 0;
        DEFAULT_ISCONNECTED = Boolean.FALSE;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L21;
        int r101 = unknownFields().hashCode() * 37;
        Integer r102 = this.channelType;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.hashCode();
    L8:
        int r105 = (r101 + r104) * 37;
        Integer r106 = this.connectionState;
        if (r106 == null) goto L11;
        int r107 = r106.hashCode();
    L12:
        int r108 = (r105 + r107) * 37;
        Integer r109 = this.channelId;
        if (r109 == null) goto L15;
        int r110 = r109.hashCode();
    L16:
        int r111 = (r108 + r110) * 37;
        Boolean r112 = this.isConnected;
        if (r112 == null) goto L19;
        r103 = r112.hashCode();
    L19:
        int r113 = r111 + r103;
        this.hashCode = r113;
        return r113;
    L15:
        r110 = 0;
        goto L16
    L11:
        r107 = 0;
        goto L12
    L7:
        r104 = 0;
        goto L8
    L21:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.channelType = this.channelType;
        r100.connectionState = this.connectionState;
        r100.channelId = this.channelId;
        r100.isConnected = this.isConnected;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.channelType == null) goto L6;
        r100.append(", channelType=");
        r100.append(this.channelType);
    L6:
        if (this.connectionState == null) goto L9;
        r100.append(", connectionState=");
        r100.append(this.connectionState);
    L9:
        if (this.channelId == null) goto L12;
        r100.append(", channelId=");
        r100.append(this.channelId);
    L12:
        if (this.isConnected == null) goto L14;
        r100.append(", isConnected=");
        r100.append(this.isConnected);
    L14:
        StringBuilder r101 = r100.replace(0, 2, "SubscribeWsStatusResponse{");
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
        if ((r100 instanceof SubscribeWsStatusResponse) == true) goto L8;
        return false;
    L8:
        SubscribeWsStatusResponse r101 = (SubscribeWsStatusResponse) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L19:
        return false;
    L11:
        if (Internal.equals(this.channelType, r101.channelType) == false) goto L19;
        if (Internal.equals(this.connectionState, r101.connectionState) == false) goto L19;
        if (Internal.equals(this.channelId, r101.channelId) == false) goto L19;
        if (Internal.equals(this.isConnected, r101.isConnected) == false) goto L19;
        return true;
    }

    public SubscribeWsStatusResponse(Integer r100, Integer r101, Integer r102, Boolean r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public SubscribeWsStatusResponse(Integer r100, Integer r101, Integer r102, Boolean r103, ByteString r104) {
        super(ADAPTER, r104);
        this.channelType = r100;
        this.connectionState = r101;
        this.channelId = r102;
        this.isConnected = r103;
    }
}
