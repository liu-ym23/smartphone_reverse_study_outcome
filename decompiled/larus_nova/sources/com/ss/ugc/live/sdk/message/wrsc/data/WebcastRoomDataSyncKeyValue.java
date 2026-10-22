package com.ss.ugc.live.sdk.message.wrsc.data;

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
public final class WebcastRoomDataSyncKeyValue extends AndroidMessage<WebcastRoomDataSyncKeyValue, Builder> {
    public static final ProtoAdapter<WebcastRoomDataSyncKeyValue> ADAPTER = null;
    public static final Parcelable.Creator<WebcastRoomDataSyncKeyValue> CREATOR = null;
    public static final String DEFAULT_BIZLOGID = "";
    public static final Long DEFAULT_MSGID = null;
    public static final ByteString DEFAULT_PAYLOAD = null;
    public static final Long DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String bizLogID;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 3)
    public final Long msgID;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 2)
    public final ByteString payload;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 1)
    public final Long version;

    public static final class Builder extends Message.Builder<WebcastRoomDataSyncKeyValue, Builder> {
        public String bizLogID;
        public Long msgID;
        public ByteString payload;
        public Long version;

        @Override // com.squareup.wire.Message.Builder
        public WebcastRoomDataSyncKeyValue build() {
            return new WebcastRoomDataSyncKeyValue(this.version, this.payload, this.msgID, this.bizLogID, super.buildUnknownFields());
        }

        public Builder() {
            this.version = 0L;
            this.payload = ByteString.EMPTY;
            this.msgID = 0L;
            this.bizLogID = "";
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder bizLogID(String r100) {
            this.bizLogID = r100;
            return this;
        }

        public Builder msgID(Long r100) {
            this.msgID = r100;
            return this;
        }

        public Builder payload(ByteString r100) {
            this.payload = r100;
            return this;
        }

        public Builder version(Long r100) {
            this.version = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_WebcastRoomDataSyncKeyValue extends ProtoAdapter<WebcastRoomDataSyncKeyValue> {
        public ProtoAdapter_WebcastRoomDataSyncKeyValue() {
            super(FieldEncoding.LENGTH_DELIMITED, WebcastRoomDataSyncKeyValue.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public WebcastRoomDataSyncKeyValue decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.version(ProtoAdapter.INT64.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.payload(ProtoAdapter.BYTES.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.msgID(ProtoAdapter.INT64.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.bizLogID(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(WebcastRoomDataSyncKeyValue r100) {
            ProtoAdapter<Long> r101 = ProtoAdapter.INT64;
            return (((r101.encodedSizeWithTag(1, r100.version) + ProtoAdapter.BYTES.encodedSizeWithTag(2, r100.payload)) + r101.encodedSizeWithTag(3, r100.msgID)) + ProtoAdapter.STRING.encodedSizeWithTag(4, r100.bizLogID)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public WebcastRoomDataSyncKeyValue redact2(WebcastRoomDataSyncKeyValue r100) {
            Builder r101 = r100.newBuilder();
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ WebcastRoomDataSyncKeyValue decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(WebcastRoomDataSyncKeyValue r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ WebcastRoomDataSyncKeyValue redact(WebcastRoomDataSyncKeyValue r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, WebcastRoomDataSyncKeyValue r101) throws IOException {
            ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
            r102.encodeWithTag(r100, 1, r101.version);
            ProtoAdapter.BYTES.encodeWithTag(r100, 2, r101.payload);
            r102.encodeWithTag(r100, 3, r101.msgID);
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r101.bizLogID);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, WebcastRoomDataSyncKeyValue r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_WebcastRoomDataSyncKeyValue r100 = new ProtoAdapter_WebcastRoomDataSyncKeyValue();
        ADAPTER = r100;
        CREATOR = AndroidMessage.newCreator(r100);
        DEFAULT_VERSION = 0L;
        DEFAULT_PAYLOAD = ByteString.EMPTY;
        DEFAULT_MSGID = 0L;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L21;
        int r101 = unknownFields().hashCode() * 37;
        Long r102 = this.version;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.hashCode();
    L8:
        int r105 = (r101 + r104) * 37;
        ByteString r106 = this.payload;
        if (r106 == null) goto L11;
        int r107 = r106.hashCode();
    L12:
        int r108 = (r105 + r107) * 37;
        Long r109 = this.msgID;
        if (r109 == null) goto L15;
        int r110 = r109.hashCode();
    L16:
        int r111 = (r108 + r110) * 37;
        String r112 = this.bizLogID;
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
        r100.version = this.version;
        r100.payload = this.payload;
        r100.msgID = this.msgID;
        r100.bizLogID = this.bizLogID;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.version == null) goto L6;
        r100.append(", version=");
        r100.append(this.version);
    L6:
        if (this.msgID == null) goto L9;
        r100.append(", msgID=");
        r100.append(this.msgID);
    L9:
        if (this.bizLogID == null) goto L11;
        r100.append(", bizLogID=");
        r100.append(this.bizLogID);
    L11:
        StringBuilder r101 = r100.replace(0, 2, "WebcastRoomDataSyncKeyValue{");
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
        if ((r100 instanceof WebcastRoomDataSyncKeyValue) == true) goto L8;
        return false;
    L8:
        WebcastRoomDataSyncKeyValue r101 = (WebcastRoomDataSyncKeyValue) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L19:
        return false;
    L11:
        if (Internal.equals(this.version, r101.version) == false) goto L19;
        if (Internal.equals(this.payload, r101.payload) == false) goto L19;
        if (Internal.equals(this.msgID, r101.msgID) == false) goto L19;
        if (Internal.equals(this.bizLogID, r101.bizLogID) == false) goto L19;
        return true;
    }

    public WebcastRoomDataSyncKeyValue(Long r100, ByteString r101, Long r102, String r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public WebcastRoomDataSyncKeyValue(Long r100, ByteString r101, Long r102, String r103, ByteString r104) {
        super(ADAPTER, r104);
        this.version = r100;
        this.payload = r101;
        this.msgID = r102;
        this.bizLogID = r103;
    }
}
