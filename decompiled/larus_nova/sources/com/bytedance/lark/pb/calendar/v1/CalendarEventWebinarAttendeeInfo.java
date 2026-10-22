package com.bytedance.lark.pb.calendar.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class CalendarEventWebinarAttendeeInfo extends Message<CalendarEventWebinarAttendeeInfo, Builder> {
    public static final ProtoAdapter<CalendarEventWebinarAttendeeInfo> ADAPTER = null;
    public static final Boolean DEFAULT_REQUIRE_MORE = null;
    public static final String DEFAULT_SYNC_TOKEN = "";
    private static final long serialVersionUID = 0;
    public final List<CalendarEventAttendee> attendees;
    public final EventAttendeeInfo event_attendee_info;
    public final Boolean require_more;
    public final String sync_token;

    public static final class Builder extends Message.Builder<CalendarEventWebinarAttendeeInfo, Builder> {
        public List<CalendarEventAttendee> attendees;
        public EventAttendeeInfo event_attendee_info;
        public Boolean require_more;
        public String sync_token;

        @Override // com.squareup.wire.Message.Builder
        public CalendarEventWebinarAttendeeInfo build() {
            return new CalendarEventWebinarAttendeeInfo(this.attendees, this.event_attendee_info, this.require_more, this.sync_token, super.buildUnknownFields());
        }

        public Builder() {
            this.attendees = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder attendees(List<CalendarEventAttendee> r100) {
            Internal.checkElementsNotNull(r100);
            this.attendees = r100;
            return this;
        }

        public Builder event_attendee_info(EventAttendeeInfo r100) {
            this.event_attendee_info = r100;
            return this;
        }

        public Builder require_more(Boolean r100) {
            this.require_more = r100;
            return this;
        }

        public Builder sync_token(String r100) {
            this.sync_token = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CalendarEventWebinarAttendeeInfo extends ProtoAdapter<CalendarEventWebinarAttendeeInfo> {
        public ProtoAdapter_CalendarEventWebinarAttendeeInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, CalendarEventWebinarAttendeeInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CalendarEventWebinarAttendeeInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.require_more = Boolean.FALSE;
            r101.sync_token = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.attendees.add(CalendarEventAttendee.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.event_attendee_info = EventAttendeeInfo.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.require_more = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.sync_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CalendarEventWebinarAttendeeInfo r100) {
            int r101 = CalendarEventAttendee.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.attendees);
            EventAttendeeInfo r102 = r100.event_attendee_info;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = EventAttendeeInfo.ADAPTER.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            Boolean r106 = r100.require_more;
            if (r106 == null) goto L9;
            int r107 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r106);
        L10:
            int r108 = r105 + r107;
            String r109 = r100.sync_token;
            if (r109 == null) goto L14;
            r103 = ProtoAdapter.STRING.encodedSizeWithTag(4, r109);
        L14:
            return (r108 + r103) + r100.unknownFields().size();
        L9:
            r107 = 0;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CalendarEventWebinarAttendeeInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CalendarEventWebinarAttendeeInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CalendarEventWebinarAttendeeInfo r101) throws IOException {
            CalendarEventAttendee.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.attendees);
            EventAttendeeInfo r102 = r101.event_attendee_info;
            if (r102 == null) goto L5;
            EventAttendeeInfo.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            Boolean r103 = r101.require_more;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r103);
        L8:
            String r104 = r101.sync_token;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CalendarEventWebinarAttendeeInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CalendarEventWebinarAttendeeInfo();
        DEFAULT_REQUIRE_MORE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.attendees = Internal.copyOf("attendees", this.attendees);
        r100.event_attendee_info = this.event_attendee_info;
        r100.require_more = this.require_more;
        r100.sync_token = this.sync_token;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CalendarEventWebinarAttendeeInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CalendarEventWebinarAttendeeInfo(List<CalendarEventAttendee> r100, EventAttendeeInfo r101, Boolean r102, String r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public CalendarEventWebinarAttendeeInfo(List<CalendarEventAttendee> r100, EventAttendeeInfo r101, Boolean r102, String r103, ByteString r104) {
        super(ADAPTER, r104);
        this.attendees = Internal.immutableCopyOf("attendees", r100);
        this.event_attendee_info = r101;
        this.require_more = r102;
        this.sync_token = r103;
    }
}
