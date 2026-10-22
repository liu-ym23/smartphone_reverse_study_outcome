package com.bytedance.lark.pb.basic.v1;

import com.bytedance.lark.pb.calendar.v1.CalendarEventAttendee;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class AttendeeRSVPInfo extends com.squareup.wire.Message<AttendeeRSVPInfo, Builder> {
    public static final ProtoAdapter<AttendeeRSVPInfo> ADAPTER = null;
    public static final String DEFAULT_AVATAR_KEY = "";
    public static final Long DEFAULT_CALENDAR_ID = null;
    public static final Long DEFAULT_CHATTER_ID = null;
    public static final String DEFAULT_DISPLAY_NAME = "";
    public static final Boolean DEFAULT_IS_OPTIONAL = null;
    public static final CalendarEventAttendee.Status DEFAULT_STATUS = null;
    private static final long serialVersionUID = 0;
    public final String avatar_key;
    public final Long calendar_id;
    public final Long chatter_id;
    public final Chatter.Description description;
    public final String display_name;
    public final Boolean is_optional;
    public final CalendarEventAttendee.Status status;

    public static final class Builder extends com.squareup.wire.Message.Builder<AttendeeRSVPInfo, Builder> {
        public String avatar_key;
        public Long calendar_id;
        public Long chatter_id;
        public Chatter.Description description;
        public String display_name;
        public Boolean is_optional;
        public CalendarEventAttendee.Status status;

        @Override // com.squareup.wire.Message.Builder
        public AttendeeRSVPInfo build() {
            return new AttendeeRSVPInfo(this.display_name, this.calendar_id, this.status, this.chatter_id, this.is_optional, this.avatar_key, this.description, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder avatar_key(String r100) {
            this.avatar_key = r100;
            return this;
        }

        public Builder calendar_id(Long r100) {
            this.calendar_id = r100;
            return this;
        }

        public Builder chatter_id(Long r100) {
            this.chatter_id = r100;
            return this;
        }

        public Builder description(Chatter.Description r100) {
            this.description = r100;
            return this;
        }

        public Builder display_name(String r100) {
            this.display_name = r100;
            return this;
        }

        public Builder is_optional(Boolean r100) {
            this.is_optional = r100;
            return this;
        }

        public Builder status(CalendarEventAttendee.Status r100) {
            this.status = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_AttendeeRSVPInfo extends ProtoAdapter<AttendeeRSVPInfo> {
        public ProtoAdapter_AttendeeRSVPInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, AttendeeRSVPInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AttendeeRSVPInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.display_name = "";
            r101.calendar_id = 0L;
            r101.status = CalendarEventAttendee.Status.NEEDS_ACTION;
            r101.chatter_id = 0L;
            r101.is_optional = Boolean.FALSE;
            r101.avatar_key = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L17;
            switch(r103) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L19;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L19:
            r101.status = CalendarEventAttendee.Status.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.description = Chatter.Description.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.avatar_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.is_optional = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            r101.chatter_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L15:
            r101.calendar_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L16:
            r101.display_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L17:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(AttendeeRSVPInfo r100) {
            String r101 = r100.display_name;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.calendar_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            CalendarEventAttendee.Status r107 = r100.status;
            if (r107 == null) goto L13;
            int r108 = CalendarEventAttendee.Status.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Long r110 = r100.chatter_id;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.INT64.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Boolean r113 = r100.is_optional;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.avatar_key;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Chatter.Description r119 = r100.description;
            if (r119 == null) goto L30;
            r102 = Chatter.Description.ADAPTER.encodedSizeWithTag(7, r119);
        L30:
            return (r118 + r102) + r100.unknownFields().size();
        L25:
            r117 = 0;
            goto L26
        L21:
            r114 = 0;
            goto L22
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
        public /* bridge */ /* synthetic */ AttendeeRSVPInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AttendeeRSVPInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AttendeeRSVPInfo r101) throws IOException {
            String r102 = r101.display_name;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.calendar_id;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            CalendarEventAttendee.Status r104 = r101.status;
            if (r104 == null) goto L11;
            CalendarEventAttendee.Status.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            Long r105 = r101.chatter_id;
            if (r105 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r100, 4, r105);
        L14:
            Boolean r106 = r101.is_optional;
            if (r106 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r106);
        L17:
            String r107 = r101.avatar_key;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
        L20:
            Chatter.Description r108 = r101.description;
            if (r108 == null) goto L23;
            Chatter.Description.ADAPTER.encodeWithTag(r100, 7, r108);
        L23:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AttendeeRSVPInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AttendeeRSVPInfo();
        DEFAULT_CALENDAR_ID = 0L;
        DEFAULT_STATUS = CalendarEventAttendee.Status.NEEDS_ACTION;
        DEFAULT_CHATTER_ID = 0L;
        DEFAULT_IS_OPTIONAL = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.display_name = this.display_name;
        r100.calendar_id = this.calendar_id;
        r100.status = this.status;
        r100.chatter_id = this.chatter_id;
        r100.is_optional = this.is_optional;
        r100.avatar_key = this.avatar_key;
        r100.description = this.description;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AttendeeRSVPInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public AttendeeRSVPInfo(String r110, Long r111, CalendarEventAttendee.Status r112, Long r113, Boolean r114, String r115, Chatter.Description r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public AttendeeRSVPInfo(String r100, Long r101, CalendarEventAttendee.Status r102, Long r103, Boolean r104, String r105, Chatter.Description r106, ByteString r107) {
        super(ADAPTER, r107);
        this.display_name = r100;
        this.calendar_id = r101;
        this.status = r102;
        this.chatter_id = r103;
        this.is_optional = r104;
        this.avatar_key = r105;
        this.description = r106;
    }
}
