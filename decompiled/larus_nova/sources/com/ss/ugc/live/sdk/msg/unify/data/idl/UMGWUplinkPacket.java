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
public final class UMGWUplinkPacket extends AndroidMessage<UMGWUplinkPacket, Builder> {
    public static final ProtoAdapter<UMGWUplinkPacket> ADAPTER = null;
    public static final Parcelable.Creator<UMGWUplinkPacket> CREATOR = null;
    public static final UMGWEventType DEFAULT_EVENT_TYPE = null;
    public static final Long DEFAULT_UNIQUE_ID = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.ss.ugc.live.sdk.msg.UMGWEventData#ADAPTER", tag = 3)
    public final UMGWEventData event_data;

    @WireField(adapter = "com.ss.ugc.live.sdk.msg.UMGWEventType#ADAPTER", tag = 2)
    public final UMGWEventType event_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 1)
    public final Long unique_id;

    public static final class Builder extends Message.Builder<UMGWUplinkPacket, Builder> {
        public UMGWEventData event_data;
        public UMGWEventType event_type;
        public Long unique_id;

        @Override // com.squareup.wire.Message.Builder
        public UMGWUplinkPacket build() {
            return new UMGWUplinkPacket(this.unique_id, this.event_type, this.event_data, super.buildUnknownFields());
        }

        public Builder() {
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

        public Builder unique_id(Long r100) {
            this.unique_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UMGWUplinkPacket extends ProtoAdapter<UMGWUplinkPacket> {
        public ProtoAdapter_UMGWUplinkPacket() {
            super(FieldEncoding.LENGTH_DELIMITED, UMGWUplinkPacket.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UMGWUplinkPacket decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.unique_id(ProtoAdapter.INT64.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.event_type(UMGWEventType.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.event_data(UMGWEventData.ADAPTER.decode(r100));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UMGWUplinkPacket r100) {
            return ((ProtoAdapter.INT64.encodedSizeWithTag(1, r100.unique_id) + UMGWEventType.ADAPTER.encodedSizeWithTag(2, r100.event_type)) + UMGWEventData.ADAPTER.encodedSizeWithTag(3, r100.event_data)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public UMGWUplinkPacket redact2(UMGWUplinkPacket r100) {
            Builder r101 = r100.newBuilder();
            UMGWEventData r102 = r101.event_data;
            if (r102 == null) goto L5;
            r101.event_data = UMGWEventData.ADAPTER.redact(r102);
        L5:
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UMGWUplinkPacket decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UMGWUplinkPacket r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UMGWUplinkPacket redact(UMGWUplinkPacket r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UMGWUplinkPacket r101) throws IOException {
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r101.unique_id);
            UMGWEventType.ADAPTER.encodeWithTag(r100, 2, r101.event_type);
            UMGWEventData.ADAPTER.encodeWithTag(r100, 3, r101.event_data);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UMGWUplinkPacket r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UMGWUplinkPacket r100 = new ProtoAdapter_UMGWUplinkPacket();
        ADAPTER = r100;
        CREATOR = AndroidMessage.newCreator(r100);
        DEFAULT_UNIQUE_ID = 0L;
        DEFAULT_EVENT_TYPE = UMGWEventType.FETCH;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L17;
        int r101 = unknownFields().hashCode() * 37;
        Long r102 = this.unique_id;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.hashCode();
    L8:
        int r105 = (r101 + r104) * 37;
        UMGWEventType r106 = this.event_type;
        if (r106 == null) goto L11;
        int r107 = r106.hashCode();
    L12:
        int r108 = (r105 + r107) * 37;
        UMGWEventData r109 = this.event_data;
        if (r109 == null) goto L15;
        r103 = r109.hashCode();
    L15:
        int r110 = r108 + r103;
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
        r100.unique_id = this.unique_id;
        r100.event_type = this.event_type;
        r100.event_data = this.event_data;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.unique_id == null) goto L6;
        r100.append(", unique_id=");
        r100.append(this.unique_id);
    L6:
        if (this.event_type == null) goto L9;
        r100.append(", event_type=");
        r100.append(this.event_type);
    L9:
        if (this.event_data == null) goto L11;
        r100.append(", event_data=");
        r100.append(this.event_data);
    L11:
        StringBuilder r101 = r100.replace(0, 2, "UMGWUplinkPacket{");
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
        if ((r100 instanceof UMGWUplinkPacket) == true) goto L8;
        return false;
    L8:
        UMGWUplinkPacket r101 = (UMGWUplinkPacket) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L17:
        return false;
    L11:
        if (Internal.equals(this.unique_id, r101.unique_id) == false) goto L17;
        if (Internal.equals(this.event_type, r101.event_type) == false) goto L17;
        if (Internal.equals(this.event_data, r101.event_data) == false) goto L17;
        return true;
    }

    public UMGWUplinkPacket(Long r100, UMGWEventType r101, UMGWEventData r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public UMGWUplinkPacket(Long r100, UMGWEventType r101, UMGWEventData r102, ByteString r103) {
        super(ADAPTER, r103);
        this.unique_id = r100;
        this.event_type = r101;
        this.event_data = r102;
    }
}
