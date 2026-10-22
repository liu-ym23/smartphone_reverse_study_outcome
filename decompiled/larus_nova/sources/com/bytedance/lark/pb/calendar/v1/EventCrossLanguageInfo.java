package com.bytedance.lark.pb.calendar.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class EventCrossLanguageInfo extends Message<EventCrossLanguageInfo, Builder> {
    public static final ProtoAdapter<EventCrossLanguageInfo> ADAPTER = null;
    public static final EventCrossLanguageType DEFAULT_LANGUAGE_TYPE = null;
    private static final long serialVersionUID = 0;
    public final EventCrossLanguageType language_type;

    public static final class Builder extends Message.Builder<EventCrossLanguageInfo, Builder> {
        public EventCrossLanguageType language_type;

        @Override // com.squareup.wire.Message.Builder
        public EventCrossLanguageInfo build() {
            return new EventCrossLanguageInfo(this.language_type, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder language_type(EventCrossLanguageType r100) {
            this.language_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_EventCrossLanguageInfo extends ProtoAdapter<EventCrossLanguageInfo> {
        public ProtoAdapter_EventCrossLanguageInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, EventCrossLanguageInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public EventCrossLanguageInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.language_type = EventCrossLanguageType.TYPE_UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L7;
            r101.language_type = EventCrossLanguageType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(EventCrossLanguageInfo r100) {
            EventCrossLanguageType r101 = r100.language_type;
            if (r101 == null) goto L5;
            int r102 = EventCrossLanguageType.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ EventCrossLanguageInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(EventCrossLanguageInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, EventCrossLanguageInfo r101) throws IOException {
            EventCrossLanguageType r102 = r101.language_type;
            if (r102 == null) goto L5;
            EventCrossLanguageType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EventCrossLanguageInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_EventCrossLanguageInfo();
        DEFAULT_LANGUAGE_TYPE = EventCrossLanguageType.TYPE_UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.language_type = this.language_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return EventCrossLanguageInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public EventCrossLanguageInfo(EventCrossLanguageType r100) {
        this(r100, ByteString.EMPTY);
    }

    public EventCrossLanguageInfo(EventCrossLanguageType r100, ByteString r101) {
        super(ADAPTER, r101);
        this.language_type = r100;
    }
}
