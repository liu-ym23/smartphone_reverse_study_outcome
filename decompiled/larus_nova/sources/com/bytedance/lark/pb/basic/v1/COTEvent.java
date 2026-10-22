package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class COTEvent extends com.squareup.wire.Message<COTEvent, Builder> {
    public static final ProtoAdapter<COTEvent> ADAPTER = null;
    public static final String DEFAULT_CONTENT = "";
    public static final Long DEFAULT_CREATED_AT = null;
    public static final String DEFAULT_EVENT_ID = "";
    public static final COTEventType DEFAULT_EVENT_TYPE = null;
    public static final Long DEFAULT_TIMESTAMP = null;
    private static final long serialVersionUID = 0;
    public final String content;
    public final Long created_at;
    public final String event_id;
    public final COTEventType event_type;
    public final Long timestamp;

    public static final class Builder extends com.squareup.wire.Message.Builder<COTEvent, Builder> {
        public String content;
        public Long created_at;
        public String event_id;
        public COTEventType event_type;
        public Long timestamp;

        @Override // com.squareup.wire.Message.Builder
        public COTEvent build() {
            String r100 = this.event_id;
            if (r100 == null) goto L15;
            if (this.event_type == null) goto L15;
            if (this.content == null) goto L15;
            if (this.timestamp == null) goto L15;
            if (this.created_at == null) goto L15;
            return new COTEvent(this.event_id, this.event_type, this.content, this.timestamp, this.created_at, super.buildUnknownFields());
        L15:
            throw Internal.missingRequiredFields(new Object[]{r100, "event_id", this.event_type, "event_type", this.content, "content", this.timestamp, "timestamp", this.created_at, "created_at"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder content(String r100) {
            this.content = r100;
            return this;
        }

        public Builder created_at(Long r100) {
            this.created_at = r100;
            return this;
        }

        public Builder event_id(String r100) {
            this.event_id = r100;
            return this;
        }

        public Builder event_type(COTEventType r100) {
            this.event_type = r100;
            return this;
        }

        public Builder timestamp(Long r100) {
            this.timestamp = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_COTEvent extends ProtoAdapter<COTEvent> {
        public ProtoAdapter_COTEvent() {
            super(FieldEncoding.LENGTH_DELIMITED, COTEvent.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public COTEvent decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.event_id = "";
            r101.event_type = COTEventType.COT_EVENT_UNKNOWN;
            r101.content = "";
            r101.timestamp = 0L;
            r101.created_at = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.event_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.event_type = COTEventType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
        L21:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.content = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.timestamp = ProtoAdapter.INT64.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.created_at = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(COTEvent r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = (r101.encodedSizeWithTag(1, r100.event_id) + COTEventType.ADAPTER.encodedSizeWithTag(2, r100.event_type)) + r101.encodedSizeWithTag(3, r100.content);
            ProtoAdapter<Long> r103 = ProtoAdapter.INT64;
            return ((r102 + r103.encodedSizeWithTag(4, r100.timestamp)) + r103.encodedSizeWithTag(5, r100.created_at)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ COTEvent decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(COTEvent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, COTEvent r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.event_id);
            COTEventType.ADAPTER.encodeWithTag(r100, 2, r101.event_type);
            r102.encodeWithTag(r100, 3, r101.content);
            ProtoAdapter<Long> r103 = ProtoAdapter.INT64;
            r103.encodeWithTag(r100, 4, r101.timestamp);
            r103.encodeWithTag(r100, 5, r101.created_at);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, COTEvent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_COTEvent();
        DEFAULT_EVENT_TYPE = COTEventType.COT_EVENT_UNKNOWN;
        DEFAULT_TIMESTAMP = 0L;
        DEFAULT_CREATED_AT = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.event_id = this.event_id;
        r100.event_type = this.event_type;
        r100.content = this.content;
        r100.timestamp = this.timestamp;
        r100.created_at = this.created_at;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return COTEvent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public COTEvent(String r100, COTEventType r101, String r110, Long r111, Long r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public COTEvent(String r100, COTEventType r101, String r102, Long r103, Long r104, ByteString r105) {
        super(ADAPTER, r105);
        this.event_id = r100;
        this.event_type = r101;
        this.content = r102;
        this.timestamp = r103;
        this.created_at = r104;
    }
}
