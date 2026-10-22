package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.LarkError;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class PushSpeechRecognitionEvent extends Message<PushSpeechRecognitionEvent, Builder> {
    public static final ProtoAdapter<PushSpeechRecognitionEvent> ADAPTER = null;
    public static final Event DEFAULT_EVENT = null;
    public static final String DEFAULT_SOURCE_ID = "";
    public static final ProtoAdapter_PushSpeechRecognitionEvent RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Event event;
    public final LarkError sdk_failed_error;
    public final String source_id;

    public static final class Builder extends Message.Builder<PushSpeechRecognitionEvent, Builder> implements d<PushSpeechRecognitionEvent> {
        public Event event;
        public LarkError sdk_failed_error;
        public String source_id;

        @Override // com.squareup.wire.Message.Builder
        public PushSpeechRecognitionEvent build() {
            String r100 = this.source_id;
            if (r100 == null) goto L9;
            if (this.event == null) goto L9;
            return new PushSpeechRecognitionEvent(this.source_id, this.event, this.sdk_failed_error, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "source_id", this.event, "event"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder event(Event r100) {
            this.event = r100;
            return this;
        }

        public Builder sdk_failed_error(LarkError r100) {
            this.sdk_failed_error = r100;
            return this;
        }

        public Builder source_id(String r100) {
            this.source_id = r100;
            return this;
        }
    }

    public static final enum Event extends Enum<Event> implements WireEnum {
        private static final /* synthetic */ Event[] $VALUES = null;
        public static final ProtoAdapter<Event> ADAPTER = null;
        public static final Event END_REQ_SENT = null;
        public static final Event SDK_FAILED = null;
        public static final Event TIMEOUT = null;
        private final int value;

        static {
            Event r100 = new Event("TIMEOUT", 0, 1);
            TIMEOUT = r100;
            Event r101 = new Event("END_REQ_SENT", 1, 2);
            END_REQ_SENT = r101;
            Event r102 = new Event("SDK_FAILED", 2, 3);
            SDK_FAILED = r102;
            $VALUES = new Event[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(Event.class);
        }

        public static Event[] values() {
            return (Event[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Event fromValue(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return null;
        L11:
            return SDK_FAILED;
        L13:
            return END_REQ_SENT;
        L15:
            return TIMEOUT;
        }

        public static Event valueOf(String r100) {
            return (Event) a.a(Event.class, r100);
        }

        private Event(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_PushSpeechRecognitionEvent extends ProtoAdapter<PushSpeechRecognitionEvent> implements c<PushSpeechRecognitionEvent> {
        public ProtoAdapter_PushSpeechRecognitionEvent() {
            super(FieldEncoding.LENGTH_DELIMITED, PushSpeechRecognitionEvent.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushSpeechRecognitionEvent decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.source_id = "";
            r101.event = Event.TIMEOUT;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.source_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.event = Event.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.sdk_failed_error(LarkError.ADAPTER.decode(r100));
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
        public int encodedSize2(PushSpeechRecognitionEvent r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.source_id) + Event.ADAPTER.encodedSizeWithTag(2, r100.event);
            LarkError r102 = r100.sdk_failed_error;
            if (r102 == null) goto L5;
            int r103 = LarkError.ADAPTER.encodedSizeWithTag(3, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushSpeechRecognitionEvent decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushSpeechRecognitionEvent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushSpeechRecognitionEvent r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.source_id);
            Event.ADAPTER.encodeWithTag(r100, 2, r101.event);
            LarkError r102 = r101.sdk_failed_error;
            if (r102 == null) goto L5;
            LarkError.ADAPTER.encodeWithTag(r100, 3, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushSpeechRecognitionEvent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushSpeechRecognitionEvent r100 = new ProtoAdapter_PushSpeechRecognitionEvent();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_EVENT = Event.TIMEOUT;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.source_id = this.source_id;
        r100.event = this.event;
        r100.sdk_failed_error = this.sdk_failed_error;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushSpeechRecognitionEvent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushSpeechRecognitionEvent(String r100, Event r101, LarkError r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public PushSpeechRecognitionEvent(String r100, Event r101, LarkError r102, ByteString r103) {
        super(ADAPTER, r103);
        this.source_id = r100;
        this.event = r101;
        this.sdk_failed_error = r102;
    }
}
