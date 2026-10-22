package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;
import we6.b;

/* JADX INFO: loaded from: classes20.dex */
public final class NoticeClientEventRequest extends com.squareup.wire.Message<NoticeClientEventRequest, Builder> {
    public static final ProtoAdapter<NoticeClientEventRequest> ADAPTER = null;
    public static final Event DEFAULT_EVENT = null;
    public static final Long DEFAULT_UPDATE_TIME = null;
    public static final ProtoAdapter_NoticeClientEventRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Event event;
    public final Long update_time;

    public static final class Builder extends com.squareup.wire.Message.Builder<NoticeClientEventRequest, Builder> implements b<NoticeClientEventRequest> {
        public Event event;
        public Long update_time;

        @Override // com.squareup.wire.Message.Builder
        public NoticeClientEventRequest build() {
            Event r100 = this.event;
            if (r100 == null) goto L7;
            return new NoticeClientEventRequest(this.event, this.update_time, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "event"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder event(Event r100) {
            this.event = r100;
            return this;
        }

        public Builder update_time(Long r100) {
            this.update_time = r100;
            return this;
        }
    }

    public static final enum Event extends Enum<Event> implements WireEnum {
        private static final /* synthetic */ Event[] $VALUES = null;
        public static final ProtoAdapter<Event> ADAPTER = null;
        public static final Event CHAT_MESSAGE_GOT = null;
        public static final Event ENTER_BACKGROUND = null;
        public static final Event ENTER_FOREGROUND = null;
        public static final Event FIRST_SCREEN_FINISHED = null;
        public static final Event IDLE_AFTER_FIRST_SCREEN = null;
        public static final Event MEMORY_WARNING = null;
        public static final Event TERMINATING = null;
        private final int value;

        static {
            Event r100 = new Event("ENTER_FOREGROUND", 0, 1);
            ENTER_FOREGROUND = r100;
            Event r101 = new Event("ENTER_BACKGROUND", 1, 2);
            ENTER_BACKGROUND = r101;
            Event r102 = new Event("TERMINATING", 2, 3);
            TERMINATING = r102;
            Event r103 = new Event("MEMORY_WARNING", 3, 4);
            MEMORY_WARNING = r103;
            Event r104 = new Event("FIRST_SCREEN_FINISHED", 4, 5);
            FIRST_SCREEN_FINISHED = r104;
            Event r110 = new Event("CHAT_MESSAGE_GOT", 5, 6);
            CHAT_MESSAGE_GOT = r110;
            Event r111 = new Event("IDLE_AFTER_FIRST_SCREEN", 6, 7);
            IDLE_AFTER_FIRST_SCREEN = r111;
            $VALUES = new Event[]{r100, r101, r102, r103, r104, r110, r111};
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
            switch(r100) {
                case 1: goto L18;
                case 2: goto L16;
                case 3: goto L14;
                case 4: goto L12;
                case 5: goto L10;
                case 6: goto L8;
                case 7: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return IDLE_AFTER_FIRST_SCREEN;
        L8:
            return CHAT_MESSAGE_GOT;
        L10:
            return FIRST_SCREEN_FINISHED;
        L12:
            return MEMORY_WARNING;
        L14:
            return TERMINATING;
        L16:
            return ENTER_BACKGROUND;
        L18:
            return ENTER_FOREGROUND;
        }

        public static Event valueOf(String r100) {
            return (Event) a.a(Event.class, r100);
        }

        private Event(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_NoticeClientEventRequest extends ProtoAdapter<NoticeClientEventRequest> implements we6.a<NoticeClientEventRequest> {
        public ProtoAdapter_NoticeClientEventRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, NoticeClientEventRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public NoticeClientEventRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.event = Event.ENTER_FOREGROUND;
            r101.update_time = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.event = Event.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.update_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(NoticeClientEventRequest r100) {
            int r101 = Event.ADAPTER.encodedSizeWithTag(1, r100.event);
            Long r102 = r100.update_time;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ NoticeClientEventRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(NoticeClientEventRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, NoticeClientEventRequest r101) throws IOException {
            Event.ADAPTER.encodeWithTag(r100, 1, r101.event);
            Long r102 = r101.update_time;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, NoticeClientEventRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_NoticeClientEventRequest r100 = new ProtoAdapter_NoticeClientEventRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_EVENT = Event.ENTER_FOREGROUND;
        DEFAULT_UPDATE_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.event = this.event;
        r100.update_time = this.update_time;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return NoticeClientEventRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public NoticeClientEventRequest(Event r100, Long r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public NoticeClientEventRequest(Event r100, Long r101, ByteString r102) {
        super(ADAPTER, r102);
        this.event = r100;
        this.update_time = r101;
    }
}
