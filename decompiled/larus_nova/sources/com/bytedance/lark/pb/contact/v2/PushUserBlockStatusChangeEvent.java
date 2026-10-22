package com.bytedance.lark.pb.contact.v2;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class PushUserBlockStatusChangeEvent extends Message<PushUserBlockStatusChangeEvent, Builder> {
    public static final ProtoAdapter<PushUserBlockStatusChangeEvent> ADAPTER = null;
    public static final Boolean DEFAULT_BLOCK_STATUS = null;
    public static final String DEFAULT_BLOCK_USER_ID = "";
    public static final PushContactApplicationBannerAffectEvent.AffectEventType DEFAULT_EVENT_TYPE = null;
    public static final ProtoAdapter_PushUserBlockStatusChangeEvent RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean block_status;
    public final String block_user_id;
    public final PushContactApplicationBannerAffectEvent.AffectEventType event_type;

    public static final class Builder extends Message.Builder<PushUserBlockStatusChangeEvent, Builder> implements d<PushUserBlockStatusChangeEvent> {
        public Boolean block_status;
        public String block_user_id;
        public PushContactApplicationBannerAffectEvent.AffectEventType event_type;

        @Override // com.squareup.wire.Message.Builder
        public PushUserBlockStatusChangeEvent build() {
            return new PushUserBlockStatusChangeEvent(this.block_user_id, this.event_type, this.block_status, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder block_status(Boolean r100) {
            this.block_status = r100;
            return this;
        }

        public Builder block_user_id(String r100) {
            this.block_user_id = r100;
            return this;
        }

        public Builder event_type(PushContactApplicationBannerAffectEvent.AffectEventType r100) {
            this.event_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushUserBlockStatusChangeEvent extends ProtoAdapter<PushUserBlockStatusChangeEvent> implements c<PushUserBlockStatusChangeEvent> {
        public ProtoAdapter_PushUserBlockStatusChangeEvent() {
            super(FieldEncoding.LENGTH_DELIMITED, PushUserBlockStatusChangeEvent.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushUserBlockStatusChangeEvent decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.block_user_id = "";
            r101.event_type = PushContactApplicationBannerAffectEvent.AffectEventType.UnknownType;
            r101.block_status = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.block_user_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.event_type = PushContactApplicationBannerAffectEvent.AffectEventType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.block_status = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(PushUserBlockStatusChangeEvent r100) {
            String r101 = r100.block_user_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            PushContactApplicationBannerAffectEvent.AffectEventType r104 = r100.event_type;
            if (r104 == null) goto L9;
            int r105 = PushContactApplicationBannerAffectEvent.AffectEventType.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.block_status;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L14:
            return (r106 + r102) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushUserBlockStatusChangeEvent decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushUserBlockStatusChangeEvent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushUserBlockStatusChangeEvent r101) throws IOException {
            String r102 = r101.block_user_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            PushContactApplicationBannerAffectEvent.AffectEventType r103 = r101.event_type;
            if (r103 == null) goto L8;
            PushContactApplicationBannerAffectEvent.AffectEventType.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.block_status;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushUserBlockStatusChangeEvent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushUserBlockStatusChangeEvent r100 = new ProtoAdapter_PushUserBlockStatusChangeEvent();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_EVENT_TYPE = PushContactApplicationBannerAffectEvent.AffectEventType.UnknownType;
        DEFAULT_BLOCK_STATUS = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.block_user_id = this.block_user_id;
        r100.event_type = this.event_type;
        r100.block_status = this.block_status;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushUserBlockStatusChangeEvent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushUserBlockStatusChangeEvent(String r100, PushContactApplicationBannerAffectEvent.AffectEventType r101, Boolean r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public PushUserBlockStatusChangeEvent(String r100, PushContactApplicationBannerAffectEvent.AffectEventType r101, Boolean r102, ByteString r103) {
        super(ADAPTER, r103);
        this.block_user_id = r100;
        this.event_type = r101;
        this.block_status = r102;
    }
}
