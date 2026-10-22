package com.ss.android.lark.pb.security_event;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class EventsRequest extends Message<EventsRequest, Builder> {
    public static final ProtoAdapter<EventsRequest> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<Event> mEvents;

    public static final class Builder extends Message.Builder<EventsRequest, Builder> {
        public List<Event> mEvents;

        @Override // com.squareup.wire.Message.Builder
        public EventsRequest build() {
            return new EventsRequest(this.mEvents, super.buildUnknownFields());
        }

        public Builder() {
            this.mEvents = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder Events(List<Event> r100) {
            Internal.checkElementsNotNull(r100);
            this.mEvents = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_EventsRequest extends ProtoAdapter<EventsRequest> {
        public ProtoAdapter_EventsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, EventsRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public EventsRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.mEvents.add(Event.ADAPTER.decode(r100));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L9:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(EventsRequest r100) {
            return Event.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.mEvents) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ EventsRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(EventsRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, EventsRequest r101) throws IOException {
            Event.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.mEvents);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EventsRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_EventsRequest();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mEvents = Internal.copyOf("mEvents", this.mEvents);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return EventsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public EventsRequest(List<Event> r100) {
        this(r100, ByteString.EMPTY);
    }

    public EventsRequest(List<Event> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.mEvents = Internal.immutableCopyOf("mEvents", r100);
    }
}
