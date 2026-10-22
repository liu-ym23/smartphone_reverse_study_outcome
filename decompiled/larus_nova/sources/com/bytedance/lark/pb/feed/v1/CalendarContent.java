package com.bytedance.lark.pb.feed.v1;

import annotation.Debug;
import com.google.protobuf.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class CalendarContent extends Message<CalendarContent, Builder> {
    public static final ProtoAdapter<CalendarContent> ADAPTER = null;
    public static final Integer DEFAULT_CALENDAR_EVENT_COUNT = null;
    public static final String DEFAULT_MEETING_ROOM_DIGEST = "";
    public static final Long DEFAULT_START_TIME = null;
    public static final String DEFAULT_TITLE = "";
    public static final FieldOptions FIELD_OPTIONS_CALENDAR_EVENT_COUNT = null;
    public static final FieldOptions FIELD_OPTIONS_START_TIME = null;
    private static final long serialVersionUID = 0;
    public final Integer calendar_event_count;
    public final String meeting_room_digest;
    public final Long start_time;
    public final String title;

    public static final class Builder extends Message.Builder<CalendarContent, Builder> {
        public Integer calendar_event_count;
        public String meeting_room_digest;
        public Long start_time;
        public String title;

        @Override // com.squareup.wire.Message.Builder
        public CalendarContent build() {
            return new CalendarContent(this.title, this.start_time, this.calendar_event_count, this.meeting_room_digest, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder calendar_event_count(Integer r100) {
            this.calendar_event_count = r100;
            return this;
        }

        public Builder meeting_room_digest(String r100) {
            this.meeting_room_digest = r100;
            return this;
        }

        public Builder start_time(Long r100) {
            this.start_time = r100;
            return this;
        }

        public Builder title(String r100) {
            this.title = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CalendarContent extends ProtoAdapter<CalendarContent> {
        public ProtoAdapter_CalendarContent() {
            super(FieldEncoding.LENGTH_DELIMITED, CalendarContent.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CalendarContent decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.title = "";
            r101.start_time = 0L;
            r101.calendar_event_count = 0;
            r101.meeting_room_digest = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.title = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.start_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.calendar_event_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.meeting_room_digest = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(CalendarContent r100) {
            String r101 = r100.title;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.start_time;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Integer r107 = r100.calendar_event_count;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT32.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.meeting_room_digest;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            return (r109 + r102) + r100.unknownFields().size();
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CalendarContent decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CalendarContent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CalendarContent r101) throws IOException {
            String r102 = r101.title;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.start_time;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            Integer r104 = r101.calendar_event_count;
            if (r104 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.meeting_room_digest;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CalendarContent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CalendarContent();
        FIELD_OPTIONS_START_TIME = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_CALENDAR_EVENT_COUNT = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        DEFAULT_START_TIME = 0L;
        DEFAULT_CALENDAR_EVENT_COUNT = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.title = this.title;
        r100.start_time = this.start_time;
        r100.calendar_event_count = this.calendar_event_count;
        r100.meeting_room_digest = this.meeting_room_digest;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CalendarContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CalendarContent(String r100, Long r101, Integer r102, String r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public CalendarContent(String r100, Long r101, Integer r102, String r103, ByteString r104) {
        super(ADAPTER, r104);
        this.title = r100;
        this.start_time = r101;
        this.calendar_event_count = r102;
        this.meeting_room_digest = r103;
    }
}
