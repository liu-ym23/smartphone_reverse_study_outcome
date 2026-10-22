package com.bytedance.sync.v2.protocal;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public final class BsyncPacket extends Message<BsyncPacket, Builder> {
    public static final ProtoAdapter<BsyncPacket> ADAPTER = null;
    public static final PacketStatus DEFAULT_STATUS = null;
    public static final Long DEFAULT_TS = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.bytedance.sync.v2.protocal.BsyncCursor#ADAPTER", label = WireField.Label.REQUIRED, tag = 1)
    public final BsyncCursor cursor;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 256)
    public final Map<String, String> extra;

    @WireField(adapter = "com.bytedance.sync.v2.protocal.BsyncPayload#ADAPTER", tag = 2)
    public final BsyncPayload payload;

    @WireField(adapter = "com.bytedance.sync.v2.protocal.PacketStatus#ADAPTER", tag = 3)
    public final PacketStatus status;

    /* JADX INFO: renamed from: ts, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 255)
    public final Long f270529ts;

    /* JADX INFO: loaded from: classes22.dex */
    public static final class Builder extends Message.Builder<BsyncPacket, Builder> {
        public BsyncCursor cursor;
        public Map<String, String> extra;
        public BsyncPayload payload;
        public PacketStatus status;

        /* JADX INFO: renamed from: ts, reason: collision with root package name */
        public Long f270530ts;

        @Override // com.squareup.wire.Message.Builder
        public BsyncPacket build() {
            BsyncCursor r100 = this.cursor;
            if (r100 == null) goto L7;
            return new BsyncPacket(this.cursor, this.payload, this.status, this.f270530ts, this.extra, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, EffectConfiguration.KEY_CURSOR});
        }

        public Builder() {
            this.extra = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder cursor(BsyncCursor r100) {
            this.cursor = r100;
            return this;
        }

        public Builder extra(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.extra = r100;
            return this;
        }

        public Builder payload(BsyncPayload r100) {
            this.payload = r100;
            return this;
        }

        public Builder status(PacketStatus r100) {
            this.status = r100;
            return this;
        }

        public Builder ts(Long r100) {
            this.f270530ts = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_BsyncPacket extends ProtoAdapter<BsyncPacket> {
        private final ProtoAdapter<Map<String, String>> extra;

        public ProtoAdapter_BsyncPacket() {
            super(FieldEncoding.LENGTH_DELIMITED, BsyncPacket.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.extra = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public BsyncPacket decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.cursor(BsyncCursor.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.payload(BsyncPayload.ADAPTER.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.status(PacketStatus.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r103 != 255) goto L14;
            r101.ts(ProtoAdapter.INT64.decode(r100));
            goto L3
        L14:
            if (r103 != 256) goto L15;
            r101.extra.putAll(this.extra.decode(r100));
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
        public int encodedSize2(BsyncPacket r100) {
            return ((((BsyncCursor.ADAPTER.encodedSizeWithTag(1, r100.cursor) + BsyncPayload.ADAPTER.encodedSizeWithTag(2, r100.payload)) + PacketStatus.ADAPTER.encodedSizeWithTag(3, r100.status)) + ProtoAdapter.INT64.encodedSizeWithTag(255, r100.f270529ts)) + this.extra.encodedSizeWithTag(256, r100.extra)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public BsyncPacket redact2(BsyncPacket r100) {
            Builder r101 = r100.newBuilder();
            r101.cursor = BsyncCursor.ADAPTER.redact(r101.cursor);
            BsyncPayload r102 = r101.payload;
            if (r102 == null) goto L5;
            r101.payload = BsyncPayload.ADAPTER.redact(r102);
        L5:
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BsyncPacket decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BsyncPacket r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BsyncPacket redact(BsyncPacket r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BsyncPacket r101) throws IOException {
            BsyncCursor.ADAPTER.encodeWithTag(r100, 1, r101.cursor);
            BsyncPayload.ADAPTER.encodeWithTag(r100, 2, r101.payload);
            PacketStatus.ADAPTER.encodeWithTag(r100, 3, r101.status);
            ProtoAdapter.INT64.encodeWithTag(r100, 255, r101.f270529ts);
            this.extra.encodeWithTag(r100, 256, r101.extra);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BsyncPacket r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BsyncPacket();
        DEFAULT_STATUS = PacketStatus.Full;
        DEFAULT_TS = 0L;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L17;
        int r101 = ((unknownFields().hashCode() * 37) + this.cursor.hashCode()) * 37;
        BsyncPayload r102 = this.payload;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.hashCode();
    L8:
        int r105 = (r101 + r104) * 37;
        PacketStatus r106 = this.status;
        if (r106 == null) goto L11;
        int r107 = r106.hashCode();
    L12:
        int r108 = (r105 + r107) * 37;
        Long r109 = this.f270529ts;
        if (r109 == null) goto L15;
        r103 = r109.hashCode();
    L15:
        int r110 = ((r108 + r103) * 37) + this.extra.hashCode();
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
        r100.cursor = this.cursor;
        r100.payload = this.payload;
        r100.status = this.status;
        r100.f270530ts = this.f270529ts;
        r100.extra = Internal.copyOf("extra", this.extra);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(", cursor=");
        r100.append(this.cursor);
        if (this.payload == null) goto L6;
        r100.append(", payload=");
        r100.append(this.payload);
    L6:
        if (this.status == null) goto L9;
        r100.append(", status=");
        r100.append(this.status);
    L9:
        if (this.f270529ts == null) goto L12;
        r100.append(", ts=");
        r100.append(this.f270529ts);
    L12:
        if (this.extra.isEmpty() == true) goto L14;
        r100.append(", extra=");
        r100.append(this.extra);
    L14:
        StringBuilder r101 = r100.replace(0, 2, "BsyncPacket{");
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
        if ((r100 instanceof BsyncPacket) == true) goto L8;
        return false;
    L8:
        BsyncPacket r101 = (BsyncPacket) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L21:
        return false;
    L11:
        if (this.cursor.equals(r101.cursor) == false) goto L21;
        if (Internal.equals(this.payload, r101.payload) == false) goto L21;
        if (Internal.equals(this.status, r101.status) == false) goto L21;
        if (Internal.equals(this.f270529ts, r101.f270529ts) == false) goto L21;
        if (this.extra.equals(r101.extra) == false) goto L21;
        return true;
    }

    public BsyncPacket(BsyncCursor r100, BsyncPayload r101, PacketStatus r110, Long r111, Map<String, String> r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public BsyncPacket(BsyncCursor r100, BsyncPayload r101, PacketStatus r102, Long r103, Map<String, String> r104, ByteString r105) {
        super(ADAPTER, r105);
        this.cursor = r100;
        this.payload = r101;
        this.status = r102;
        this.f270529ts = r103;
        this.extra = Internal.immutableCopyOf("extra", r104);
    }
}
