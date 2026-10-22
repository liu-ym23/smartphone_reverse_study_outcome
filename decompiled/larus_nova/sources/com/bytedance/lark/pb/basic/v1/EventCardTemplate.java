package com.bytedance.lark.pb.basic.v1;

import com.bytedance.lark.pb.calendar.v1.CalendarEventDescriptionElements;
import com.bytedance.lark.pb.calendar.v1.ConflictType;
import com.bytedance.lark.pb.calendar.v1.RecurrenceDisplayInstanceInfo;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class EventCardTemplate extends com.squareup.wire.Message<EventCardTemplate, Builder> {
    public static final ProtoAdapter<EventCardTemplate> ADAPTER = null;
    public static final Integer DEFAULT_ATTENDEE_COUNT = null;
    public static final String DEFAULT_CALENDAR_ID = "";
    public static final Long DEFAULT_CONFLICT_TIME = null;
    public static final ConflictType DEFAULT_CONFLICT_TYPE = null;
    public static final String DEFAULT_DESCRIPTION = "";
    public static final Long DEFAULT_END_TIME = null;
    public static final String DEFAULT_END_TIMEZONE = "";
    public static final Integer DEFAULT_EVENT_TYPE = null;
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_ALL_DAY = null;
    public static final Boolean DEFAULT_IS_CROSS_TENANT = null;
    public static final Boolean DEFAULT_IS_OPTIONAL = null;
    public static final Boolean DEFAULT_IS_WEBINAR = null;
    public static final String DEFAULT_KEY = "";
    public static final String DEFAULT_LOCATION = "";
    public static final Long DEFAULT_ORGANIZER_CALENDAR_ID = null;
    public static final Long DEFAULT_ORIGINAL_TIME = null;
    public static final String DEFAULT_RRULE = "";
    public static final Integer DEFAULT_SELF_ATTENDEE_STATUS = null;
    public static final String DEFAULT_SENDER_ID = "";
    public static final Long DEFAULT_START_TIME = null;
    public static final String DEFAULT_START_TIMEZONE = "";
    public static final String DEFAULT_SUMMARY = "";
    public static final Integer DEFAULT_TYPE = null;
    public static final Long DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final List<String> attendee_chatter_ids;
    public final Integer attendee_count;
    public final String calendar_id;
    public final List<String> chat_ids;
    public final Map<String, String> chat_names;
    public final Long conflict_time;
    public final ConflictType conflict_type;
    public final String description;
    public final CalendarEventDescriptionElements description_elements;
    public final Long end_time;
    public final String end_timezone;
    public final Integer event_type;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253493id;
    public final List<String> individual_chatter_ids;
    public final Boolean is_all_day;
    public final Boolean is_cross_tenant;
    public final List<Boolean> is_meeting_rooms_disabled;
    public final Boolean is_optional;
    public final Boolean is_webinar;
    public final String key;
    public final String location;
    public final List<String> meeting_rooms;
    public final Long organizer_calendar_id;
    public final Long original_time;
    public final RecurrenceDisplayInstanceInfo recurrence_display_instance_info;
    public final TagData relation_tag;
    public final String rrule;
    public final Integer self_attendee_status;
    public final String sender_id;
    public final ServerTagData server_tag;
    public final Map<String, String> speaker_chat_names;
    public final List<String> speaker_chatter_ids;
    public final Long start_time;
    public final String start_timezone;
    public final String summary;
    public final Integer type;
    public final Long version;

    public static final class Builder extends com.squareup.wire.Message.Builder<EventCardTemplate, Builder> {
        public List<String> attendee_chatter_ids;
        public Integer attendee_count;
        public String calendar_id;
        public List<String> chat_ids;
        public Map<String, String> chat_names;
        public Long conflict_time;
        public ConflictType conflict_type;
        public String description;
        public CalendarEventDescriptionElements description_elements;
        public Long end_time;
        public String end_timezone;
        public Integer event_type;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253494id;
        public List<String> individual_chatter_ids;
        public Boolean is_all_day;
        public Boolean is_cross_tenant;
        public List<Boolean> is_meeting_rooms_disabled;
        public Boolean is_optional;
        public Boolean is_webinar;
        public String key;
        public String location;
        public List<String> meeting_rooms;
        public Long organizer_calendar_id;
        public Long original_time;
        public RecurrenceDisplayInstanceInfo recurrence_display_instance_info;
        public TagData relation_tag;
        public String rrule;
        public Integer self_attendee_status;
        public String sender_id;
        public ServerTagData server_tag;
        public Map<String, String> speaker_chat_names;
        public List<String> speaker_chatter_ids;
        public Long start_time;
        public String start_timezone;
        public String summary;
        public Integer type;
        public Long version;

        @Override // com.squareup.wire.Message.Builder
        public EventCardTemplate build() {
            return new EventCardTemplate(this.summary, this.sender_id, this.is_optional, this.start_time, this.end_time, this.rrule, this.is_all_day, this.version, this.start_timezone, this.end_timezone, this.f253494id, this.type, this.key, this.original_time, this.calendar_id, this.meeting_rooms, this.attendee_chatter_ids, this.chat_ids, this.self_attendee_status, this.attendee_count, this.location, this.description, this.event_type, this.is_cross_tenant, this.individual_chatter_ids, this.is_meeting_rooms_disabled, this.is_webinar, this.speaker_chatter_ids, this.speaker_chat_names, this.organizer_calendar_id, this.conflict_type, this.conflict_time, this.chat_names, this.relation_tag, this.server_tag, this.description_elements, this.recurrence_display_instance_info, super.buildUnknownFields());
        }

        public Builder() {
            this.meeting_rooms = Internal.newMutableList();
            this.attendee_chatter_ids = Internal.newMutableList();
            this.chat_ids = Internal.newMutableList();
            this.individual_chatter_ids = Internal.newMutableList();
            this.is_meeting_rooms_disabled = Internal.newMutableList();
            this.speaker_chatter_ids = Internal.newMutableList();
            this.speaker_chat_names = Internal.newMutableMap();
            this.chat_names = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder attendee_chatter_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.attendee_chatter_ids = r100;
            return this;
        }

        public Builder attendee_count(Integer r100) {
            this.attendee_count = r100;
            return this;
        }

        public Builder calendar_id(String r100) {
            this.calendar_id = r100;
            return this;
        }

        public Builder chat_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.chat_ids = r100;
            return this;
        }

        public Builder chat_names(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.chat_names = r100;
            return this;
        }

        public Builder conflict_time(Long r100) {
            this.conflict_time = r100;
            return this;
        }

        public Builder conflict_type(ConflictType r100) {
            this.conflict_type = r100;
            return this;
        }

        public Builder description(String r100) {
            this.description = r100;
            return this;
        }

        public Builder description_elements(CalendarEventDescriptionElements r100) {
            this.description_elements = r100;
            return this;
        }

        public Builder end_time(Long r100) {
            this.end_time = r100;
            return this;
        }

        public Builder end_timezone(String r100) {
            this.end_timezone = r100;
            return this;
        }

        public Builder event_type(Integer r100) {
            this.event_type = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253494id = r100;
            return this;
        }

        public Builder individual_chatter_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.individual_chatter_ids = r100;
            return this;
        }

        public Builder is_all_day(Boolean r100) {
            this.is_all_day = r100;
            return this;
        }

        public Builder is_cross_tenant(Boolean r100) {
            this.is_cross_tenant = r100;
            return this;
        }

        public Builder is_meeting_rooms_disabled(List<Boolean> r100) {
            Internal.checkElementsNotNull(r100);
            this.is_meeting_rooms_disabled = r100;
            return this;
        }

        public Builder is_optional(Boolean r100) {
            this.is_optional = r100;
            return this;
        }

        public Builder is_webinar(Boolean r100) {
            this.is_webinar = r100;
            return this;
        }

        public Builder key(String r100) {
            this.key = r100;
            return this;
        }

        public Builder location(String r100) {
            this.location = r100;
            return this;
        }

        public Builder meeting_rooms(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.meeting_rooms = r100;
            return this;
        }

        public Builder organizer_calendar_id(Long r100) {
            this.organizer_calendar_id = r100;
            return this;
        }

        public Builder original_time(Long r100) {
            this.original_time = r100;
            return this;
        }

        public Builder recurrence_display_instance_info(RecurrenceDisplayInstanceInfo r100) {
            this.recurrence_display_instance_info = r100;
            return this;
        }

        public Builder relation_tag(TagData r100) {
            this.relation_tag = r100;
            return this;
        }

        public Builder rrule(String r100) {
            this.rrule = r100;
            return this;
        }

        public Builder self_attendee_status(Integer r100) {
            this.self_attendee_status = r100;
            return this;
        }

        public Builder sender_id(String r100) {
            this.sender_id = r100;
            return this;
        }

        public Builder server_tag(ServerTagData r100) {
            this.server_tag = r100;
            return this;
        }

        public Builder speaker_chat_names(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.speaker_chat_names = r100;
            return this;
        }

        public Builder speaker_chatter_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.speaker_chatter_ids = r100;
            return this;
        }

        public Builder start_time(Long r100) {
            this.start_time = r100;
            return this;
        }

        public Builder start_timezone(String r100) {
            this.start_timezone = r100;
            return this;
        }

        public Builder summary(String r100) {
            this.summary = r100;
            return this;
        }

        public Builder type(Integer r100) {
            this.type = r100;
            return this;
        }

        public Builder version(Long r100) {
            this.version = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_EventCardTemplate extends ProtoAdapter<EventCardTemplate> {
        private final ProtoAdapter<Map<String, String>> chat_names;
        private final ProtoAdapter<Map<String, String>> speaker_chat_names;

        public ProtoAdapter_EventCardTemplate() {
            super(FieldEncoding.LENGTH_DELIMITED, EventCardTemplate.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.speaker_chat_names = ProtoAdapter.newMapAdapter(r100, r100);
            this.chat_names = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public EventCardTemplate decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.summary = "";
            r101.sender_id = "";
            Boolean r102 = Boolean.FALSE;
            r101.is_optional = r102;
            r101.start_time = 0L;
            r101.end_time = 0L;
            r101.rrule = "";
            r101.is_all_day = r102;
            r101.version = 0L;
            r101.start_timezone = "";
            r101.end_timezone = "";
            r101.f253494id = "";
            r101.type = 0;
            r101.key = "";
            r101.original_time = 0L;
            r101.calendar_id = "";
            r101.self_attendee_status = 0;
            r101.attendee_count = 0;
            r101.location = "";
            r101.description = "";
            r101.event_type = 0;
            r101.is_cross_tenant = r102;
            r101.is_webinar = r102;
            r101.organizer_calendar_id = 0L;
            r101.conflict_type = ConflictType.NONE;
            r101.conflict_time = 0L;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L52;
            if (r104 != 201) goto L8;
            r101.description_elements = CalendarEventDescriptionElements.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r104 != 202) goto L9;
            r101.recurrence_display_instance_info = RecurrenceDisplayInstanceInfo.ADAPTER.decode(r100);
            goto L3
        L9:
            switch(r104) {
                case 1: goto L49;
                case 2: goto L48;
                case 3: goto L47;
                case 4: goto L46;
                case 5: goto L45;
                case 6: goto L44;
                case 7: goto L43;
                case 8: goto L42;
                case 9: goto L41;
                case 10: goto L40;
                case 11: goto L39;
                case 12: goto L38;
                case 13: goto L37;
                case 14: goto L36;
                case 15: goto L35;
                case 16: goto L34;
                case 17: goto L33;
                case 18: goto L32;
                case 19: goto L31;
                case 20: goto L30;
                case 21: goto L29;
                case 22: goto L28;
                case 23: goto L27;
                case 24: goto L26;
                case 25: goto L25;
                case 26: goto L24;
                case 27: goto L23;
                case 28: goto L22;
                case 29: goto L21;
                case 30: goto L20;
                default: goto L10;
            };
        L20:
            r101.organizer_calendar_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L21:
            r101.speaker_chat_names.putAll(this.speaker_chat_names.decode(r100));
            goto L3
        L22:
            r101.speaker_chatter_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L23:
            r101.is_webinar = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L24:
            r101.is_meeting_rooms_disabled.add(ProtoAdapter.BOOL.decode(r100));
            goto L3
        L25:
            r101.individual_chatter_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L26:
            r101.is_cross_tenant = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L27:
            r101.event_type = ProtoAdapter.INT32.decode(r100);
            goto L3
        L28:
            r101.description = ProtoAdapter.STRING.decode(r100);
            goto L3
        L29:
            r101.location = ProtoAdapter.STRING.decode(r100);
            goto L3
        L30:
            r101.attendee_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L31:
            r101.self_attendee_status = ProtoAdapter.INT32.decode(r100);
            goto L3
        L32:
            r101.chat_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L33:
            r101.attendee_chatter_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L34:
            r101.meeting_rooms.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L35:
            r101.calendar_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L36:
            r101.original_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L37:
            r101.key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L38:
            r101.type = ProtoAdapter.INT32.decode(r100);
            goto L3
        L39:
            r101.f253494id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L40:
            r101.end_timezone = ProtoAdapter.STRING.decode(r100);
            goto L3
        L41:
            r101.start_timezone = ProtoAdapter.STRING.decode(r100);
            goto L3
        L42:
            r101.version = ProtoAdapter.INT64.decode(r100);
            goto L3
        L43:
            r101.is_all_day = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L44:
            r101.rrule = ProtoAdapter.STRING.decode(r100);
            goto L3
        L45:
            r101.end_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L46:
            r101.start_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L47:
            r101.is_optional = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L48:
            r101.sender_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L49:
            r101.summary = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            switch(r104) {
                case 100: goto L54;
                case 101: goto L15;
                case 102: goto L14;
                case 103: goto L13;
                case 104: goto L12;
                default: goto L11;
            };
        L54:
            r101.conflict_type = ConflictType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            r101.server_tag = ServerTagData.ADAPTER.decode(r100);
            goto L3
        L13:
            r101.relation_tag = TagData.ADAPTER.decode(r100);
            goto L3
        L14:
            r101.chat_names.putAll(this.chat_names.decode(r100));
            goto L3
        L15:
            r101.conflict_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L11:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L52:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(EventCardTemplate r100) {
            String r101 = r100.summary;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.sender_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.is_optional;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Long r110 = r100.start_time;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.INT64.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Long r113 = r100.end_time;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.INT64.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.rrule;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Boolean r119 = r100.is_all_day;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            Long r122 = r100.version;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.INT64.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            String r125 = r100.start_timezone;
            if (r125 == null) goto L37;
            int r126 = ProtoAdapter.STRING.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            String r128 = r100.end_timezone;
            if (r128 == null) goto L41;
            int r129 = ProtoAdapter.STRING.encodedSizeWithTag(10, r128);
        L42:
            int r130 = r127 + r129;
            String r131 = r100.f253493id;
            if (r131 == null) goto L45;
            int r132 = ProtoAdapter.STRING.encodedSizeWithTag(11, r131);
        L46:
            int r133 = r130 + r132;
            Integer r134 = r100.type;
            if (r134 == null) goto L49;
            int r135 = ProtoAdapter.INT32.encodedSizeWithTag(12, r134);
        L50:
            int r136 = r133 + r135;
            String r137 = r100.key;
            if (r137 == null) goto L53;
            int r138 = ProtoAdapter.STRING.encodedSizeWithTag(13, r137);
        L54:
            int r139 = r136 + r138;
            Long r140 = r100.original_time;
            if (r140 == null) goto L57;
            int r141 = ProtoAdapter.INT64.encodedSizeWithTag(14, r140);
        L58:
            int r142 = r139 + r141;
            String r143 = r100.calendar_id;
            if (r143 == null) goto L61;
            int r144 = ProtoAdapter.STRING.encodedSizeWithTag(15, r143);
        L62:
            int r145 = r142 + r144;
            ProtoAdapter<String> r146 = ProtoAdapter.STRING;
            int r147 = ((r145 + r146.asRepeated().encodedSizeWithTag(16, r100.meeting_rooms)) + r146.asRepeated().encodedSizeWithTag(17, r100.attendee_chatter_ids)) + r146.asRepeated().encodedSizeWithTag(18, r100.chat_ids);
            Integer r148 = r100.self_attendee_status;
            if (r148 == null) goto L65;
            int r149 = ProtoAdapter.INT32.encodedSizeWithTag(19, r148);
        L66:
            int r150 = r147 + r149;
            Integer r151 = r100.attendee_count;
            if (r151 == null) goto L69;
            int r152 = ProtoAdapter.INT32.encodedSizeWithTag(20, r151);
        L70:
            int r153 = r150 + r152;
            String r154 = r100.location;
            if (r154 == null) goto L73;
            int r155 = r146.encodedSizeWithTag(21, r154);
        L74:
            int r156 = r153 + r155;
            String r157 = r100.description;
            if (r157 == null) goto L77;
            int r158 = r146.encodedSizeWithTag(22, r157);
        L78:
            int r159 = r156 + r158;
            Integer r160 = r100.event_type;
            if (r160 == null) goto L81;
            int r161 = ProtoAdapter.INT32.encodedSizeWithTag(23, r160);
        L82:
            int r162 = r159 + r161;
            Boolean r163 = r100.is_cross_tenant;
            if (r163 == null) goto L85;
            int r164 = ProtoAdapter.BOOL.encodedSizeWithTag(24, r163);
        L86:
            int r165 = (r162 + r164) + r146.asRepeated().encodedSizeWithTag(25, r100.individual_chatter_ids);
            ProtoAdapter<Boolean> r166 = ProtoAdapter.BOOL;
            int r167 = r165 + r166.asRepeated().encodedSizeWithTag(26, r100.is_meeting_rooms_disabled);
            Boolean r168 = r100.is_webinar;
            if (r168 == null) goto L89;
            int r169 = r166.encodedSizeWithTag(27, r168);
        L90:
            int r170 = ((r167 + r169) + r146.asRepeated().encodedSizeWithTag(28, r100.speaker_chatter_ids)) + this.speaker_chat_names.encodedSizeWithTag(29, r100.speaker_chat_names);
            Long r171 = r100.organizer_calendar_id;
            if (r171 == null) goto L93;
            int r172 = ProtoAdapter.INT64.encodedSizeWithTag(30, r171);
        L94:
            int r173 = r170 + r172;
            ConflictType r174 = r100.conflict_type;
            if (r174 == null) goto L97;
            int r175 = ConflictType.ADAPTER.encodedSizeWithTag(100, r174);
        L98:
            int r176 = r173 + r175;
            Long r177 = r100.conflict_time;
            if (r177 == null) goto L101;
            int r178 = ProtoAdapter.INT64.encodedSizeWithTag(101, r177);
        L102:
            int r179 = (r176 + r178) + this.chat_names.encodedSizeWithTag(102, r100.chat_names);
            TagData r180 = r100.relation_tag;
            if (r180 == null) goto L105;
            int r181 = TagData.ADAPTER.encodedSizeWithTag(103, r180);
        L106:
            int r182 = r179 + r181;
            ServerTagData r183 = r100.server_tag;
            if (r183 == null) goto L109;
            int r184 = ServerTagData.ADAPTER.encodedSizeWithTag(104, r183);
        L110:
            int r185 = r182 + r184;
            CalendarEventDescriptionElements r186 = r100.description_elements;
            if (r186 == null) goto L113;
            int r187 = CalendarEventDescriptionElements.ADAPTER.encodedSizeWithTag(201, r186);
        L114:
            int r188 = r185 + r187;
            RecurrenceDisplayInstanceInfo r189 = r100.recurrence_display_instance_info;
            if (r189 == null) goto L118;
            r102 = RecurrenceDisplayInstanceInfo.ADAPTER.encodedSizeWithTag(202, r189);
        L118:
            return (r188 + r102) + r100.unknownFields().size();
        L113:
            r187 = 0;
            goto L114
        L109:
            r184 = 0;
            goto L110
        L105:
            r181 = 0;
            goto L106
        L101:
            r178 = 0;
            goto L102
        L97:
            r175 = 0;
            goto L98
        L93:
            r172 = 0;
            goto L94
        L89:
            r169 = 0;
            goto L90
        L85:
            r164 = 0;
            goto L86
        L81:
            r161 = 0;
            goto L82
        L77:
            r158 = 0;
            goto L78
        L73:
            r155 = 0;
            goto L74
        L69:
            r152 = 0;
            goto L70
        L65:
            r149 = 0;
            goto L66
        L61:
            r144 = 0;
            goto L62
        L57:
            r141 = 0;
            goto L58
        L53:
            r138 = 0;
            goto L54
        L49:
            r135 = 0;
            goto L50
        L45:
            r132 = 0;
            goto L46
        L41:
            r129 = 0;
            goto L42
        L37:
            r126 = 0;
            goto L38
        L33:
            r123 = 0;
            goto L34
        L29:
            r120 = 0;
            goto L30
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
        public /* bridge */ /* synthetic */ EventCardTemplate decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(EventCardTemplate r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, EventCardTemplate r101) throws IOException {
            String r102 = r101.summary;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.sender_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.is_optional;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            Long r105 = r101.start_time;
            if (r105 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r100, 4, r105);
        L14:
            Long r106 = r101.end_time;
            if (r106 == null) goto L17;
            ProtoAdapter.INT64.encodeWithTag(r100, 5, r106);
        L17:
            String r107 = r101.rrule;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
        L20:
            Boolean r108 = r101.is_all_day;
            if (r108 == null) goto L23;
            ProtoAdapter.BOOL.encodeWithTag(r100, 7, r108);
        L23:
            Long r109 = r101.version;
            if (r109 == null) goto L26;
            ProtoAdapter.INT64.encodeWithTag(r100, 8, r109);
        L26:
            String r110 = r101.start_timezone;
            if (r110 == null) goto L29;
            ProtoAdapter.STRING.encodeWithTag(r100, 9, r110);
        L29:
            String r111 = r101.end_timezone;
            if (r111 == null) goto L32;
            ProtoAdapter.STRING.encodeWithTag(r100, 10, r111);
        L32:
            String r112 = r101.f253493id;
            if (r112 == null) goto L35;
            ProtoAdapter.STRING.encodeWithTag(r100, 11, r112);
        L35:
            Integer r113 = r101.type;
            if (r113 == null) goto L38;
            ProtoAdapter.INT32.encodeWithTag(r100, 12, r113);
        L38:
            String r114 = r101.key;
            if (r114 == null) goto L41;
            ProtoAdapter.STRING.encodeWithTag(r100, 13, r114);
        L41:
            Long r115 = r101.original_time;
            if (r115 == null) goto L44;
            ProtoAdapter.INT64.encodeWithTag(r100, 14, r115);
        L44:
            String r116 = r101.calendar_id;
            if (r116 == null) goto L47;
            ProtoAdapter.STRING.encodeWithTag(r100, 15, r116);
        L47:
            ProtoAdapter<String> r117 = ProtoAdapter.STRING;
            r117.asRepeated().encodeWithTag(r100, 16, r101.meeting_rooms);
            r117.asRepeated().encodeWithTag(r100, 17, r101.attendee_chatter_ids);
            r117.asRepeated().encodeWithTag(r100, 18, r101.chat_ids);
            Integer r118 = r101.self_attendee_status;
            if (r118 == null) goto L50;
            ProtoAdapter.INT32.encodeWithTag(r100, 19, r118);
        L50:
            Integer r119 = r101.attendee_count;
            if (r119 == null) goto L53;
            ProtoAdapter.INT32.encodeWithTag(r100, 20, r119);
        L53:
            String r120 = r101.location;
            if (r120 == null) goto L56;
            r117.encodeWithTag(r100, 21, r120);
        L56:
            String r121 = r101.description;
            if (r121 == null) goto L59;
            r117.encodeWithTag(r100, 22, r121);
        L59:
            Integer r122 = r101.event_type;
            if (r122 == null) goto L62;
            ProtoAdapter.INT32.encodeWithTag(r100, 23, r122);
        L62:
            Boolean r123 = r101.is_cross_tenant;
            if (r123 == null) goto L65;
            ProtoAdapter.BOOL.encodeWithTag(r100, 24, r123);
        L65:
            r117.asRepeated().encodeWithTag(r100, 25, r101.individual_chatter_ids);
            ProtoAdapter<Boolean> r124 = ProtoAdapter.BOOL;
            r124.asRepeated().encodeWithTag(r100, 26, r101.is_meeting_rooms_disabled);
            Boolean r125 = r101.is_webinar;
            if (r125 == null) goto L68;
            r124.encodeWithTag(r100, 27, r125);
        L68:
            r117.asRepeated().encodeWithTag(r100, 28, r101.speaker_chatter_ids);
            this.speaker_chat_names.encodeWithTag(r100, 29, r101.speaker_chat_names);
            Long r126 = r101.organizer_calendar_id;
            if (r126 == null) goto L71;
            ProtoAdapter.INT64.encodeWithTag(r100, 30, r126);
        L71:
            ConflictType r127 = r101.conflict_type;
            if (r127 == null) goto L74;
            ConflictType.ADAPTER.encodeWithTag(r100, 100, r127);
        L74:
            Long r128 = r101.conflict_time;
            if (r128 == null) goto L77;
            ProtoAdapter.INT64.encodeWithTag(r100, 101, r128);
        L77:
            this.chat_names.encodeWithTag(r100, 102, r101.chat_names);
            TagData r129 = r101.relation_tag;
            if (r129 == null) goto L80;
            TagData.ADAPTER.encodeWithTag(r100, 103, r129);
        L80:
            ServerTagData r130 = r101.server_tag;
            if (r130 == null) goto L83;
            ServerTagData.ADAPTER.encodeWithTag(r100, 104, r130);
        L83:
            CalendarEventDescriptionElements r131 = r101.description_elements;
            if (r131 == null) goto L86;
            CalendarEventDescriptionElements.ADAPTER.encodeWithTag(r100, 201, r131);
        L86:
            RecurrenceDisplayInstanceInfo r132 = r101.recurrence_display_instance_info;
            if (r132 == null) goto L89;
            RecurrenceDisplayInstanceInfo.ADAPTER.encodeWithTag(r100, 202, r132);
        L89:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EventCardTemplate r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_EventCardTemplate();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_OPTIONAL = r100;
        DEFAULT_START_TIME = 0L;
        DEFAULT_END_TIME = 0L;
        DEFAULT_IS_ALL_DAY = r100;
        DEFAULT_VERSION = 0L;
        DEFAULT_TYPE = 0;
        DEFAULT_ORIGINAL_TIME = 0L;
        DEFAULT_SELF_ATTENDEE_STATUS = 0;
        DEFAULT_ATTENDEE_COUNT = 0;
        DEFAULT_EVENT_TYPE = 0;
        DEFAULT_IS_CROSS_TENANT = r100;
        DEFAULT_IS_WEBINAR = r100;
        DEFAULT_ORGANIZER_CALENDAR_ID = 0L;
        DEFAULT_CONFLICT_TYPE = ConflictType.NONE;
        DEFAULT_CONFLICT_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.summary = this.summary;
        r100.sender_id = this.sender_id;
        r100.is_optional = this.is_optional;
        r100.start_time = this.start_time;
        r100.end_time = this.end_time;
        r100.rrule = this.rrule;
        r100.is_all_day = this.is_all_day;
        r100.version = this.version;
        r100.start_timezone = this.start_timezone;
        r100.end_timezone = this.end_timezone;
        r100.f253494id = this.f253493id;
        r100.type = this.type;
        r100.key = this.key;
        r100.original_time = this.original_time;
        r100.calendar_id = this.calendar_id;
        r100.meeting_rooms = Internal.copyOf("meeting_rooms", this.meeting_rooms);
        r100.attendee_chatter_ids = Internal.copyOf("attendee_chatter_ids", this.attendee_chatter_ids);
        r100.chat_ids = Internal.copyOf("chat_ids", this.chat_ids);
        r100.self_attendee_status = this.self_attendee_status;
        r100.attendee_count = this.attendee_count;
        r100.location = this.location;
        r100.description = this.description;
        r100.event_type = this.event_type;
        r100.is_cross_tenant = this.is_cross_tenant;
        r100.individual_chatter_ids = Internal.copyOf("individual_chatter_ids", this.individual_chatter_ids);
        r100.is_meeting_rooms_disabled = Internal.copyOf("is_meeting_rooms_disabled", this.is_meeting_rooms_disabled);
        r100.is_webinar = this.is_webinar;
        r100.speaker_chatter_ids = Internal.copyOf("speaker_chatter_ids", this.speaker_chatter_ids);
        r100.speaker_chat_names = Internal.copyOf("speaker_chat_names", this.speaker_chat_names);
        r100.organizer_calendar_id = this.organizer_calendar_id;
        r100.conflict_type = this.conflict_type;
        r100.conflict_time = this.conflict_time;
        r100.chat_names = Internal.copyOf("chat_names", this.chat_names);
        r100.relation_tag = this.relation_tag;
        r100.server_tag = this.server_tag;
        r100.description_elements = this.description_elements;
        r100.recurrence_display_instance_info = this.recurrence_display_instance_info;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return EventCardTemplate.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public EventCardTemplate(String r410, String r411, Boolean r412, Long r413, Long r414, String r415, Boolean r416, Long r417, String r418, String r419, String r510, Integer r511, String r512, Long r513, String r514, List<String> r515, List<String> r516, List<String> r517, Integer r518, Integer r519, String r610, String r611, Integer r612, Boolean r613, List<String> r614, List<Boolean> r615, Boolean r616, List<String> r617, Map<String, String> r618, Long r619, ConflictType r710, Long r711, Map<String, String> r712, TagData r713, ServerTagData r714, CalendarEventDescriptionElements r715, RecurrenceDisplayInstanceInfo r716) {
        this(r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711, r712, r713, r714, r715, r716, ByteString.EMPTY);
    }

    public EventCardTemplate(String r100, String r101, Boolean r102, Long r103, Long r104, String r105, Boolean r110, Long r111, String r112, String r113, String r114, Integer r115, String r116, Long r117, String r118, List<String> r119, List<String> r210, List<String> r211, Integer r212, Integer r213, String r214, String r215, Integer r216, Boolean r217, List<String> r218, List<Boolean> r219, Boolean r310, List<String> r311, Map<String, String> r312, Long r313, ConflictType r314, Long r315, Map<String, String> r316, TagData r317, ServerTagData r318, CalendarEventDescriptionElements r319, RecurrenceDisplayInstanceInfo r410, ByteString r411) {
        super(ADAPTER, r411);
        this.summary = r100;
        this.sender_id = r101;
        this.is_optional = r102;
        this.start_time = r103;
        this.end_time = r104;
        this.rrule = r105;
        this.is_all_day = r110;
        this.version = r111;
        this.start_timezone = r112;
        this.end_timezone = r113;
        this.f253493id = r114;
        this.type = r115;
        this.key = r116;
        this.original_time = r117;
        this.calendar_id = r118;
        this.meeting_rooms = Internal.immutableCopyOf("meeting_rooms", r119);
        this.attendee_chatter_ids = Internal.immutableCopyOf("attendee_chatter_ids", r210);
        this.chat_ids = Internal.immutableCopyOf("chat_ids", r211);
        this.self_attendee_status = r212;
        this.attendee_count = r213;
        this.location = r214;
        this.description = r215;
        this.event_type = r216;
        this.is_cross_tenant = r217;
        this.individual_chatter_ids = Internal.immutableCopyOf("individual_chatter_ids", r218);
        this.is_meeting_rooms_disabled = Internal.immutableCopyOf("is_meeting_rooms_disabled", r219);
        this.is_webinar = r310;
        this.speaker_chatter_ids = Internal.immutableCopyOf("speaker_chatter_ids", r311);
        this.speaker_chat_names = Internal.immutableCopyOf("speaker_chat_names", r312);
        this.organizer_calendar_id = r313;
        this.conflict_type = r314;
        this.conflict_time = r315;
        this.chat_names = Internal.immutableCopyOf("chat_names", r316);
        this.relation_tag = r317;
        this.server_tag = r318;
        this.description_elements = r319;
        this.recurrence_display_instance_info = r410;
    }
}
