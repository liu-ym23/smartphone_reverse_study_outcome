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
public final class UMGWDownlinkPacket extends AndroidMessage<UMGWDownlinkPacket, Builder> {
    public static final ProtoAdapter<UMGWDownlinkPacket> ADAPTER = null;
    public static final Parcelable.Creator<UMGWDownlinkPacket> CREATOR = null;
    public static final UMGWEventType DEFAULT_EVENT_TYPE = null;
    public static final Long DEFAULT_STATUS_CODE = null;
    public static final String DEFAULT_STATUS_MESSAGE = "";
    public static final Long DEFAULT_UNIQUE_ID = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.ss.ugc.live.sdk.msg.UMGWEventData#ADAPTER", tag = 5)
    public final UMGWEventData event_data;

    @WireField(adapter = "com.ss.ugc.live.sdk.msg.UMGWEventType#ADAPTER", tag = 4)
    public final UMGWEventType event_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 1)
    public final Long status_code;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String status_message;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 3)
    public final Long unique_id;

    public static final class Builder extends Message.Builder<UMGWDownlinkPacket, Builder> {
        public UMGWEventData event_data;
        public UMGWEventType event_type;
        public Long status_code;
        public String status_message;
        public Long unique_id;

        @Override // com.squareup.wire.Message.Builder
        public UMGWDownlinkPacket build() {
            return new UMGWDownlinkPacket(this.status_code, this.status_message, this.unique_id, this.event_type, this.event_data, super.buildUnknownFields());
        }

        public Builder() {
            this.status_code = 0L;
            this.status_message = "";
            this.unique_id = 0L;
            this.event_type = UMGWEventType.FETCH;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder event_data(UMGWEventData r100) {
            this.event_data = r100;
            return this;
        }

        public Builder event_type(UMGWEventType r100) {
            this.event_type = r100;
            return this;
        }

        public Builder status_code(Long r100) {
            this.status_code = r100;
            return this;
        }

        public Builder status_message(String r100) {
            this.status_message = r100;
            return this;
        }

        public Builder unique_id(Long r100) {
            this.unique_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UMGWDownlinkPacket extends ProtoAdapter<UMGWDownlinkPacket> {
        public ProtoAdapter_UMGWDownlinkPacket() {
            super(FieldEncoding.LENGTH_DELIMITED, UMGWDownlinkPacket.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UMGWDownlinkPacket decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.status_code(ProtoAdapter.INT64.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.status_message(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.unique_id(ProtoAdapter.INT64.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.event_type(UMGWEventType.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.event_data(UMGWEventData.ADAPTER.decode(r100));
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UMGWDownlinkPacket r100) {
            ProtoAdapter<Long> r101 = ProtoAdapter.INT64;
            return ((((r101.encodedSizeWithTag(1, r100.status_code) + ProtoAdapter.STRING.encodedSizeWithTag(2, r100.status_message)) + r101.encodedSizeWithTag(3, r100.unique_id)) + UMGWEventType.ADAPTER.encodedSizeWithTag(4, r100.event_type)) + UMGWEventData.ADAPTER.encodedSizeWithTag(5, r100.event_data)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public UMGWDownlinkPacket redact2(UMGWDownlinkPacket r100) {
            Builder r101 = r100.newBuilder();
            UMGWEventData r102 = r101.event_data;
            if (r102 == null) goto L5;
            r101.event_data = UMGWEventData.ADAPTER.redact(r102);
        L5:
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UMGWDownlinkPacket decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UMGWDownlinkPacket r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UMGWDownlinkPacket redact(UMGWDownlinkPacket r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UMGWDownlinkPacket r101) throws IOException {
            ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
            r102.encodeWithTag(r100, 1, r101.status_code);
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r101.status_message);
            r102.encodeWithTag(r100, 3, r101.unique_id);
            UMGWEventType.ADAPTER.encodeWithTag(r100, 4, r101.event_type);
            UMGWEventData.ADAPTER.encodeWithTag(r100, 5, r101.event_data);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UMGWDownlinkPacket r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UMGWDownlinkPacket r100 = new ProtoAdapter_UMGWDownlinkPacket();
        ADAPTER = r100;
        CREATOR = AndroidMessage.newCreator(r100);
        DEFAULT_STATUS_CODE = 0L;
        DEFAULT_UNIQUE_ID = 0L;
        DEFAULT_EVENT_TYPE = UMGWEventType.FETCH;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L25;
        int r101 = unknownFields().hashCode() * 37;
        Long r102 = this.status_code;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.hashCode();
    L8:
        int r105 = (r101 + r104) * 37;
        String r106 = this.status_message;
        if (r106 == null) goto L11;
        int r107 = r106.hashCode();
    L12:
        int r108 = (r105 + r107) * 37;
        Long r109 = this.unique_id;
        if (r109 == null) goto L15;
        int r110 = r109.hashCode();
    L16:
        int r111 = (r108 + r110) * 37;
        UMGWEventType r112 = this.event_type;
        if (r112 == null) goto L19;
        int r113 = r112.hashCode();
    L20:
        int r114 = (r111 + r113) * 37;
        UMGWEventData r115 = this.event_data;
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
        r100.status_code = this.status_code;
        r100.status_message = this.status_message;
        r100.unique_id = this.unique_id;
        r100.event_type = this.event_type;
        r100.event_data = this.event_data;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.status_code == null) goto L6;
        r100.append(", status_code=");
        r100.append(this.status_code);
    L6:
        if (this.status_message == null) goto L9;
        r100.append(", status_message=");
        r100.append(this.status_message);
    L9:
        if (this.unique_id == null) goto L12;
        r100.append(", unique_id=");
        r100.append(this.unique_id);
    L12:
        if (this.event_type == null) goto L15;
        r100.append(", event_type=");
        r100.append(this.event_type);
    L15:
        if (this.event_data == null) goto L17;
        r100.append(", event_data=");
        r100.append(this.event_data);
    L17:
        StringBuilder r101 = r100.replace(0, 2, "UMGWDownlinkPacket{");
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
        if ((r100 instanceof UMGWDownlinkPacket) == true) goto L8;
        return false;
    L8:
        UMGWDownlinkPacket r101 = (UMGWDownlinkPacket) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L21:
        return false;
    L11:
        if (Internal.equals(this.status_code, r101.status_code) == false) goto L21;
        if (Internal.equals(this.status_message, r101.status_message) == false) goto L21;
        if (Internal.equals(this.unique_id, r101.unique_id) == false) goto L21;
        if (Internal.equals(this.event_type, r101.event_type) == false) goto L21;
        if (Internal.equals(this.event_data, r101.event_data) == false) goto L21;
        return true;
    }

    public UMGWDownlinkPacket(Long r100, String r101, Long r110, UMGWEventType r111, UMGWEventData r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public UMGWDownlinkPacket(Long r100, String r101, Long r102, UMGWEventType r103, UMGWEventData r104, ByteString r105) {
        super(ADAPTER, r105);
        this.status_code = r100;
        this.status_message = r101;
        this.unique_id = r102;
        this.event_type = r103;
        this.event_data = r104;
    }
}
