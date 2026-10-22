package com.bytedance.lark.pb.calendar.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class CalendarEventWebinarInfo extends Message<CalendarEventWebinarInfo, Builder> {
    public static final ProtoAdapter<CalendarEventWebinarInfo> ADAPTER = null;
    public static final WebinarAttendeeType DEFAULT_SELF_WEBINAR_ATTENDEE_TYPE = null;
    public static final String DEFAULT_WEBINAR_DATA = "";
    private static final long serialVersionUID = 0;
    public final CalendarEventWebinarAttendeeInfo audiences;
    public final CalendarEventWebinarConf conf;
    public final WebinarAttendeeType self_webinar_attendee_type;
    public final CalendarEventWebinarAttendeeInfo speakers;
    public final String webinar_data;

    public static final class Builder extends Message.Builder<CalendarEventWebinarInfo, Builder> {
        public CalendarEventWebinarAttendeeInfo audiences;
        public CalendarEventWebinarConf conf;
        public WebinarAttendeeType self_webinar_attendee_type;
        public CalendarEventWebinarAttendeeInfo speakers;
        public String webinar_data;

        @Override // com.squareup.wire.Message.Builder
        public CalendarEventWebinarInfo build() {
            return new CalendarEventWebinarInfo(this.conf, this.speakers, this.audiences, this.self_webinar_attendee_type, this.webinar_data, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder audiences(CalendarEventWebinarAttendeeInfo r100) {
            this.audiences = r100;
            return this;
        }

        public Builder conf(CalendarEventWebinarConf r100) {
            this.conf = r100;
            return this;
        }

        public Builder self_webinar_attendee_type(WebinarAttendeeType r100) {
            this.self_webinar_attendee_type = r100;
            return this;
        }

        public Builder speakers(CalendarEventWebinarAttendeeInfo r100) {
            this.speakers = r100;
            return this;
        }

        public Builder webinar_data(String r100) {
            this.webinar_data = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CalendarEventWebinarInfo extends ProtoAdapter<CalendarEventWebinarInfo> {
        public ProtoAdapter_CalendarEventWebinarInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, CalendarEventWebinarInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CalendarEventWebinarInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.self_webinar_attendee_type = WebinarAttendeeType.Unknown;
            r101.webinar_data = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.conf = CalendarEventWebinarConf.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.speakers = CalendarEventWebinarAttendeeInfo.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.audiences = CalendarEventWebinarAttendeeInfo.ADAPTER.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.self_webinar_attendee_type = WebinarAttendeeType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.webinar_data = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(CalendarEventWebinarInfo r100) {
            CalendarEventWebinarConf r101 = r100.conf;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = CalendarEventWebinarConf.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            CalendarEventWebinarAttendeeInfo r104 = r100.speakers;
            if (r104 == null) goto L9;
            int r105 = CalendarEventWebinarAttendeeInfo.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            CalendarEventWebinarAttendeeInfo r107 = r100.audiences;
            if (r107 == null) goto L13;
            int r108 = CalendarEventWebinarAttendeeInfo.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            WebinarAttendeeType r110 = r100.self_webinar_attendee_type;
            if (r110 == null) goto L17;
            int r111 = WebinarAttendeeType.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.webinar_data;
            if (r113 == null) goto L22;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            return (r112 + r102) + r100.unknownFields().size();
        L17:
            r111 = 0;
            goto L18
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
        public /* bridge */ /* synthetic */ CalendarEventWebinarInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CalendarEventWebinarInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CalendarEventWebinarInfo r101) throws IOException {
            CalendarEventWebinarConf r102 = r101.conf;
            if (r102 == null) goto L5;
            CalendarEventWebinarConf.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            CalendarEventWebinarAttendeeInfo r103 = r101.speakers;
            if (r103 == null) goto L8;
            CalendarEventWebinarAttendeeInfo.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            CalendarEventWebinarAttendeeInfo r104 = r101.audiences;
            if (r104 == null) goto L11;
            CalendarEventWebinarAttendeeInfo.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            WebinarAttendeeType r105 = r101.self_webinar_attendee_type;
            if (r105 == null) goto L14;
            WebinarAttendeeType.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.webinar_data;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CalendarEventWebinarInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CalendarEventWebinarInfo();
        DEFAULT_SELF_WEBINAR_ATTENDEE_TYPE = WebinarAttendeeType.Unknown;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.conf = this.conf;
        r100.speakers = this.speakers;
        r100.audiences = this.audiences;
        r100.self_webinar_attendee_type = this.self_webinar_attendee_type;
        r100.webinar_data = this.webinar_data;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CalendarEventWebinarInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CalendarEventWebinarInfo(CalendarEventWebinarConf r100, CalendarEventWebinarAttendeeInfo r101, CalendarEventWebinarAttendeeInfo r110, WebinarAttendeeType r111, String r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public CalendarEventWebinarInfo(CalendarEventWebinarConf r100, CalendarEventWebinarAttendeeInfo r101, CalendarEventWebinarAttendeeInfo r102, WebinarAttendeeType r103, String r104, ByteString r105) {
        super(ADAPTER, r105);
        this.conf = r100;
        this.speakers = r101;
        this.audiences = r102;
        this.self_webinar_attendee_type = r103;
        this.webinar_data = r104;
    }
}
