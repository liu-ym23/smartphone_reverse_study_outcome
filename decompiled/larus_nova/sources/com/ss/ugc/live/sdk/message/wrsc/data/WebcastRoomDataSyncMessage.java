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
public final class WebcastRoomDataSyncMessage extends AndroidMessage<WebcastRoomDataSyncMessage, Builder> {
    public static final ProtoAdapter<WebcastRoomDataSyncMessage> ADAPTER = null;
    public static final Parcelable.Creator<WebcastRoomDataSyncMessage> CREATOR = null;
    public static final String DEFAULT_BIZLOGID = "";
    public static final ByteString DEFAULT_PAYLOAD = null;
    public static final Long DEFAULT_ROOMID = null;
    public static final String DEFAULT_SYNCKEY = "";
    public static final Long DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String bizLogID;

    @WireField(adapter = "com.ss.ugc.live.sdk.msg.Common#ADAPTER", tag = 1)
    public final Common common;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 5)
    public final ByteString payload;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 2)
    public final Long roomID;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String syncKey;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    public final Long version;

    public static final class Builder extends Message.Builder<WebcastRoomDataSyncMessage, Builder> {
        public String bizLogID;
        public Common common;
        public ByteString payload;
        public Long roomID;
        public String syncKey;
        public Long version;

        @Override // com.squareup.wire.Message.Builder
        public WebcastRoomDataSyncMessage build() {
            return new WebcastRoomDataSyncMessage(this.common, this.roomID, this.syncKey, this.version, this.payload, this.bizLogID, super.buildUnknownFields());
        }

        public Builder() {
            this.roomID = 0L;
            this.syncKey = "";
            this.version = 0L;
            this.payload = ByteString.EMPTY;
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

        public Builder common(Common r100) {
            this.common = r100;
            return this;
        }

        public Builder payload(ByteString r100) {
            this.payload = r100;
            return this;
        }

        public Builder roomID(Long r100) {
            this.roomID = r100;
            return this;
        }

        public Builder syncKey(String r100) {
            this.syncKey = r100;
            return this;
        }

        public Builder version(Long r100) {
            this.version = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_WebcastRoomDataSyncMessage extends ProtoAdapter<WebcastRoomDataSyncMessage> {
        public ProtoAdapter_WebcastRoomDataSyncMessage() {
            super(FieldEncoding.LENGTH_DELIMITED, WebcastRoomDataSyncMessage.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public WebcastRoomDataSyncMessage decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L13;
            switch(r103) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r101.bizLogID(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            r101.payload(ProtoAdapter.BYTES.decode(r100));
            goto L3
        L9:
            r101.version(ProtoAdapter.INT64.decode(r100));
            goto L3
        L10:
            r101.syncKey(ProtoAdapter.STRING.decode(r100));
            goto L3
        L11:
            r101.roomID(ProtoAdapter.INT64.decode(r100));
            goto L3
        L12:
            r101.common(Common.ADAPTER.decode(r100));
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L13:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(WebcastRoomDataSyncMessage r100) {
            int r101 = Common.ADAPTER.encodedSizeWithTag(1, r100.common);
            ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
            int r103 = r101 + r102.encodedSizeWithTag(2, r100.roomID);
            ProtoAdapter<String> r104 = ProtoAdapter.STRING;
            return ((((r103 + r104.encodedSizeWithTag(3, r100.syncKey)) + r102.encodedSizeWithTag(4, r100.version)) + ProtoAdapter.BYTES.encodedSizeWithTag(5, r100.payload)) + r104.encodedSizeWithTag(6, r100.bizLogID)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public WebcastRoomDataSyncMessage redact2(WebcastRoomDataSyncMessage r100) {
            Builder r101 = r100.newBuilder();
            Common r102 = r101.common;
            if (r102 == null) goto L5;
            r101.common = Common.ADAPTER.redact(r102);
        L5:
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ WebcastRoomDataSyncMessage decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(WebcastRoomDataSyncMessage r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ WebcastRoomDataSyncMessage redact(WebcastRoomDataSyncMessage r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, WebcastRoomDataSyncMessage r101) throws IOException {
            Common.ADAPTER.encodeWithTag(r100, 1, r101.common);
            ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
            r102.encodeWithTag(r100, 2, r101.roomID);
            ProtoAdapter<String> r103 = ProtoAdapter.STRING;
            r103.encodeWithTag(r100, 3, r101.syncKey);
            r102.encodeWithTag(r100, 4, r101.version);
            ProtoAdapter.BYTES.encodeWithTag(r100, 5, r101.payload);
            r103.encodeWithTag(r100, 6, r101.bizLogID);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, WebcastRoomDataSyncMessage r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_WebcastRoomDataSyncMessage r100 = new ProtoAdapter_WebcastRoomDataSyncMessage();
        ADAPTER = r100;
        CREATOR = AndroidMessage.newCreator(r100);
        DEFAULT_ROOMID = 0L;
        DEFAULT_VERSION = 0L;
        DEFAULT_PAYLOAD = ByteString.EMPTY;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L29;
        int r101 = unknownFields().hashCode() * 37;
        Common r102 = this.common;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.hashCode();
    L8:
        int r105 = (r101 + r104) * 37;
        Long r106 = this.roomID;
        if (r106 == null) goto L11;
        int r107 = r106.hashCode();
    L12:
        int r108 = (r105 + r107) * 37;
        String r109 = this.syncKey;
        if (r109 == null) goto L15;
        int r110 = r109.hashCode();
    L16:
        int r111 = (r108 + r110) * 37;
        Long r112 = this.version;
        if (r112 == null) goto L19;
        int r113 = r112.hashCode();
    L20:
        int r114 = (r111 + r113) * 37;
        ByteString r115 = this.payload;
        if (r115 == null) goto L23;
        int r116 = r115.hashCode();
    L24:
        int r117 = (r114 + r116) * 37;
        String r118 = this.bizLogID;
        if (r118 == null) goto L27;
        r103 = r118.hashCode();
    L27:
        int r119 = r117 + r103;
        this.hashCode = r119;
        return r119;
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
    L29:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.common = this.common;
        r100.roomID = this.roomID;
        r100.syncKey = this.syncKey;
        r100.version = this.version;
        r100.payload = this.payload;
        r100.bizLogID = this.bizLogID;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.common == null) goto L6;
        r100.append(", common=");
        r100.append(this.common);
    L6:
        if (this.roomID == null) goto L9;
        r100.append(", roomID=");
        r100.append(this.roomID);
    L9:
        if (this.syncKey == null) goto L12;
        r100.append(", syncKey=");
        r100.append(this.syncKey);
    L12:
        if (this.version == null) goto L15;
        r100.append(", version=");
        r100.append(this.version);
    L15:
        if (this.bizLogID == null) goto L17;
        r100.append(", bizLogID=");
        r100.append(this.bizLogID);
    L17:
        StringBuilder r101 = r100.replace(0, 2, "WebcastRoomDataSyncMessage{");
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
        if ((r100 instanceof WebcastRoomDataSyncMessage) == true) goto L8;
        return false;
    L8:
        WebcastRoomDataSyncMessage r101 = (WebcastRoomDataSyncMessage) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L23:
        return false;
    L11:
        if (Internal.equals(this.common, r101.common) == false) goto L23;
        if (Internal.equals(this.roomID, r101.roomID) == false) goto L23;
        if (Internal.equals(this.syncKey, r101.syncKey) == false) goto L23;
        if (Internal.equals(this.version, r101.version) == false) goto L23;
        if (Internal.equals(this.payload, r101.payload) == false) goto L23;
        if (Internal.equals(this.bizLogID, r101.bizLogID) == false) goto L23;
        return true;
    }

    public WebcastRoomDataSyncMessage(Common r100, Long r110, String r111, Long r112, ByteString r113, String r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public WebcastRoomDataSyncMessage(Common r100, Long r101, String r102, Long r103, ByteString r104, String r105, ByteString r106) {
        super(ADAPTER, r106);
        this.common = r100;
        this.roomID = r101;
        this.syncKey = r102;
        this.version = r103;
        this.payload = r104;
        this.bizLogID = r105;
    }
}
