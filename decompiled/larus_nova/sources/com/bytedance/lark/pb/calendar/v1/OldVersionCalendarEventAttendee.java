package com.bytedance.lark.pb.calendar.v1;

import com.bytedance.lark.pb.basic.v1.ImageSet;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class OldVersionCalendarEventAttendee extends Message<OldVersionCalendarEventAttendee, Builder> {
    public static final ProtoAdapter<OldVersionCalendarEventAttendee> ADAPTER = null;
    public static final Integer DEFAULT_ADDITIONAL_GUESTS_COUNT = null;
    public static final String DEFAULT_ATTENDEE_CALENDAR_ID = "";
    public static final String DEFAULT_AVATAR_KEY = "";
    public static final String DEFAULT_AVATAR_PATH = "";
    public static final Long DEFAULT_CREATE_TIME = null;
    public static final String DEFAULT_DISPLAY_NAME = "";
    public static final String DEFAULT_EMAIL = "";
    public static final String DEFAULT_GROUP_ID = "";
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_INVITER_CALENDAR_ID = "";
    public static final Boolean DEFAULT_IS_CROSS_TENANT = null;
    public static final Boolean DEFAULT_IS_DISABLED = null;
    public static final Boolean DEFAULT_IS_EDITABLE = null;
    public static final Boolean DEFAULT_IS_GROUP = null;
    public static final Boolean DEFAULT_IS_OPTIONAL = null;
    public static final Boolean DEFAULT_IS_ORGANIZER = null;
    public static final Boolean DEFAULT_IS_RESOURCE = null;
    public static final Boolean DEFAULT_IS_THIRD_PARTY = null;
    public static final String DEFAULT_KEY = "";
    public static final String DEFAULT_LOCALIZED_DISPLAY_NAME = "";
    public static final Boolean DEFAULT_OPEN_SECURITY = null;
    public static final Long DEFAULT_ORIGINAL_TIME = null;
    public static final Integer DEFAULT_SHOW_MEMBER_LIMIT = null;
    public static final Status DEFAULT_STATUS = null;
    public static final String DEFAULT_TAGS = "";
    public static final String DEFAULT_TENANT_ID = "";
    public static final Calendar.Type DEFAULT_TYPE = null;
    public static final Long DEFAULT_UPDATE_TIME = null;
    public static final String DEFAULT_USER_ID = "";
    private static final long serialVersionUID = 0;
    public final Integer additional_guests_count;
    public final String attendee_calendar_id;
    public final ImageSet avatar;
    public final String avatar_key;
    public final String avatar_path;
    public final Long create_time;
    public final String display_name;
    public final String email;
    public final String group_id;
    public final List<OldVersionCalendarEventAttendee> group_members;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253605id;
    public final String inviter_calendar_id;
    public final Boolean is_cross_tenant;
    public final Boolean is_disabled;
    public final Boolean is_editable;
    public final Boolean is_group;
    public final Boolean is_optional;
    public final Boolean is_organizer;
    public final Boolean is_resource;
    public final Boolean is_third_party;
    public final String key;
    public final String localized_display_name;
    public final Boolean open_security;
    public final Long original_time;
    public final Integer show_member_limit;
    public final Status status;
    public final String tags;
    public final String tenant_id;
    public final Calendar.Type type;
    public final Long update_time;
    public final String user_id;

    public static final class Builder extends Message.Builder<OldVersionCalendarEventAttendee, Builder> {
        public Integer additional_guests_count;
        public String attendee_calendar_id;
        public ImageSet avatar;
        public String avatar_key;
        public String avatar_path;
        public Long create_time;
        public String display_name;
        public String email;
        public String group_id;
        public List<OldVersionCalendarEventAttendee> group_members;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253606id;
        public String inviter_calendar_id;
        public Boolean is_cross_tenant;
        public Boolean is_disabled;
        public Boolean is_editable;
        public Boolean is_group;
        public Boolean is_optional;
        public Boolean is_organizer;
        public Boolean is_resource;
        public Boolean is_third_party;
        public String key;
        public String localized_display_name;
        public Boolean open_security;
        public Long original_time;
        public Integer show_member_limit;
        public Status status;
        public String tags;
        public String tenant_id;
        public Calendar.Type type;
        public Long update_time;
        public String user_id;

        @Override // com.squareup.wire.Message.Builder
        public OldVersionCalendarEventAttendee build() {
            String r100 = this.f253606id;
            if (r100 == null) goto L9;
            if (this.attendee_calendar_id == null) goto L9;
            return new OldVersionCalendarEventAttendee(this.f253606id, this.key, this.original_time, this.display_name, this.attendee_calendar_id, this.is_organizer, this.is_resource, this.is_optional, this.status, this.additional_guests_count, this.avatar, this.create_time, this.update_time, this.type, this.tags, this.group_id, this.is_group, this.group_members, this.avatar_key, this.localized_display_name, this.is_cross_tenant, this.tenant_id, this.open_security, this.show_member_limit, this.user_id, this.is_editable, this.inviter_calendar_id, this.is_disabled, this.email, this.is_third_party, this.avatar_path, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "id", this.attendee_calendar_id, "attendee_calendar_id"});
        }

        public Builder() {
            this.group_members = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder additional_guests_count(Integer r100) {
            this.additional_guests_count = r100;
            return this;
        }

        public Builder attendee_calendar_id(String r100) {
            this.attendee_calendar_id = r100;
            return this;
        }

        public Builder avatar(ImageSet r100) {
            this.avatar = r100;
            return this;
        }

        public Builder avatar_key(String r100) {
            this.avatar_key = r100;
            return this;
        }

        public Builder avatar_path(String r100) {
            this.avatar_path = r100;
            return this;
        }

        public Builder create_time(Long r100) {
            this.create_time = r100;
            return this;
        }

        public Builder display_name(String r100) {
            this.display_name = r100;
            return this;
        }

        public Builder email(String r100) {
            this.email = r100;
            return this;
        }

        public Builder group_id(String r100) {
            this.group_id = r100;
            return this;
        }

        public Builder group_members(List<OldVersionCalendarEventAttendee> r100) {
            Internal.checkElementsNotNull(r100);
            this.group_members = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253606id = r100;
            return this;
        }

        public Builder inviter_calendar_id(String r100) {
            this.inviter_calendar_id = r100;
            return this;
        }

        public Builder is_cross_tenant(Boolean r100) {
            this.is_cross_tenant = r100;
            return this;
        }

        public Builder is_disabled(Boolean r100) {
            this.is_disabled = r100;
            return this;
        }

        public Builder is_editable(Boolean r100) {
            this.is_editable = r100;
            return this;
        }

        public Builder is_group(Boolean r100) {
            this.is_group = r100;
            return this;
        }

        public Builder is_optional(Boolean r100) {
            this.is_optional = r100;
            return this;
        }

        public Builder is_organizer(Boolean r100) {
            this.is_organizer = r100;
            return this;
        }

        public Builder is_resource(Boolean r100) {
            this.is_resource = r100;
            return this;
        }

        public Builder is_third_party(Boolean r100) {
            this.is_third_party = r100;
            return this;
        }

        public Builder key(String r100) {
            this.key = r100;
            return this;
        }

        public Builder localized_display_name(String r100) {
            this.localized_display_name = r100;
            return this;
        }

        public Builder open_security(Boolean r100) {
            this.open_security = r100;
            return this;
        }

        public Builder original_time(Long r100) {
            this.original_time = r100;
            return this;
        }

        public Builder show_member_limit(Integer r100) {
            this.show_member_limit = r100;
            return this;
        }

        public Builder status(Status r100) {
            this.status = r100;
            return this;
        }

        public Builder tags(String r100) {
            this.tags = r100;
            return this;
        }

        public Builder tenant_id(String r100) {
            this.tenant_id = r100;
            return this;
        }

        public Builder type(Calendar.Type r100) {
            this.type = r100;
            return this;
        }

        public Builder update_time(Long r100) {
            this.update_time = r100;
            return this;
        }

        public Builder user_id(String r100) {
            this.user_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_OldVersionCalendarEventAttendee extends ProtoAdapter<OldVersionCalendarEventAttendee> {
        public ProtoAdapter_OldVersionCalendarEventAttendee() {
            super(FieldEncoding.LENGTH_DELIMITED, OldVersionCalendarEventAttendee.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public OldVersionCalendarEventAttendee decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253606id = "";
            r101.key = "";
            r101.original_time = 0L;
            r101.display_name = "";
            r101.attendee_calendar_id = "";
            Boolean r102 = Boolean.FALSE;
            r101.is_organizer = r102;
            r101.is_resource = r102;
            r101.is_optional = r102;
            r101.status = Status.NEEDS_ACTION;
            r101.additional_guests_count = 0;
            r101.create_time = 0L;
            r101.update_time = 0L;
            r101.type = Calendar.Type.PRIMARY;
            r101.tags = "";
            r101.group_id = "";
            r101.is_group = r102;
            r101.avatar_key = "";
            r101.localized_display_name = "";
            r101.is_cross_tenant = r102;
            r101.tenant_id = "";
            r101.open_security = r102;
            r101.show_member_limit = 0;
            r101.user_id = "";
            r101.is_editable = r102;
            r101.inviter_calendar_id = "";
            r101.is_disabled = r102;
            r101.email = "";
            r101.is_third_party = r102;
            r101.avatar_path = "";
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L44;
            switch(r104) {
                case 1: goto L43;
                case 2: goto L42;
                case 3: goto L41;
                case 4: goto L40;
                case 5: goto L39;
                case 6: goto L38;
                case 7: goto L37;
                case 8: goto L36;
                case 9: goto L46;
                case 10: goto L31;
                case 11: goto L30;
                case 12: goto L29;
                case 13: goto L28;
                case 14: goto L48;
                case 15: goto L23;
                case 16: goto L22;
                case 17: goto L21;
                case 18: goto L20;
                case 19: goto L19;
                case 20: goto L18;
                case 21: goto L17;
                case 22: goto L16;
                case 23: goto L15;
                case 24: goto L14;
                case 25: goto L13;
                case 26: goto L12;
                case 27: goto L11;
                case 28: goto L10;
                case 29: goto L9;
                case 30: goto L8;
                case 31: goto L7;
                default: goto L6;
            };
        L46:
            r101.status = Status.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L34
        L34:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L48:
            r101.type = Calendar.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L26
        L26:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.avatar_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.is_third_party = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            r101.email = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.is_disabled = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            r101.inviter_calendar_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.is_editable = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            r101.user_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.show_member_limit = ProtoAdapter.INT32.decode(r100);
            goto L3
        L15:
            r101.open_security = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L16:
            r101.tenant_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.is_cross_tenant = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L18:
            r101.localized_display_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L19:
            r101.avatar_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L20:
            r101.group_members.add(OldVersionCalendarEventAttendee.ADAPTER.decode(r100));
            goto L3
        L21:
            r101.is_group = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L22:
            r101.group_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L23:
            r101.tags = ProtoAdapter.STRING.decode(r100);
            goto L3
        L28:
            r101.update_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L29:
            r101.create_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L30:
            r101.avatar = ImageSet.ADAPTER.decode(r100);
            goto L3
        L31:
            r101.additional_guests_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L36:
            r101.is_optional = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L37:
            r101.is_resource = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L38:
            r101.is_organizer = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L39:
            r101.attendee_calendar_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L40:
            r101.display_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L41:
            r101.original_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L42:
            r101.key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L43:
            r101.f253606id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L44:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(OldVersionCalendarEventAttendee r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.f253605id);
            String r103 = r100.key;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            Long r107 = r100.original_time;
            if (r107 == null) goto L9;
            int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            String r110 = r100.display_name;
            if (r110 == null) goto L13;
            int r111 = r101.encodedSizeWithTag(4, r110);
        L14:
            int r112 = (r109 + r111) + r101.encodedSizeWithTag(5, r100.attendee_calendar_id);
            Boolean r113 = r100.is_organizer;
            if (r113 == null) goto L17;
            int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r113);
        L18:
            int r115 = r112 + r114;
            Boolean r116 = r100.is_resource;
            if (r116 == null) goto L21;
            int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r116);
        L22:
            int r118 = r115 + r117;
            Boolean r119 = r100.is_optional;
            if (r119 == null) goto L25;
            int r120 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r119);
        L26:
            int r121 = r118 + r120;
            Status r122 = r100.status;
            if (r122 == null) goto L29;
            int r123 = Status.ADAPTER.encodedSizeWithTag(9, r122);
        L30:
            int r124 = r121 + r123;
            Integer r125 = r100.additional_guests_count;
            if (r125 == null) goto L33;
            int r126 = ProtoAdapter.INT32.encodedSizeWithTag(10, r125);
        L34:
            int r127 = r124 + r126;
            ImageSet r128 = r100.avatar;
            if (r128 == null) goto L37;
            int r129 = ImageSet.ADAPTER.encodedSizeWithTag(11, r128);
        L38:
            int r130 = r127 + r129;
            Long r131 = r100.create_time;
            if (r131 == null) goto L41;
            int r132 = ProtoAdapter.INT64.encodedSizeWithTag(12, r131);
        L42:
            int r133 = r130 + r132;
            Long r134 = r100.update_time;
            if (r134 == null) goto L45;
            int r135 = ProtoAdapter.INT64.encodedSizeWithTag(13, r134);
        L46:
            int r136 = r133 + r135;
            Calendar.Type r137 = r100.type;
            if (r137 == null) goto L49;
            int r138 = Calendar.Type.ADAPTER.encodedSizeWithTag(14, r137);
        L50:
            int r139 = r136 + r138;
            String r140 = r100.tags;
            if (r140 == null) goto L53;
            int r141 = r101.encodedSizeWithTag(15, r140);
        L54:
            int r142 = r139 + r141;
            String r143 = r100.group_id;
            if (r143 == null) goto L57;
            int r144 = r101.encodedSizeWithTag(16, r143);
        L58:
            int r145 = r142 + r144;
            Boolean r146 = r100.is_group;
            if (r146 == null) goto L61;
            int r147 = ProtoAdapter.BOOL.encodedSizeWithTag(17, r146);
        L62:
            int r148 = (r145 + r147) + OldVersionCalendarEventAttendee.ADAPTER.asRepeated().encodedSizeWithTag(18, r100.group_members);
            String r149 = r100.avatar_key;
            if (r149 == null) goto L65;
            int r150 = r101.encodedSizeWithTag(19, r149);
        L66:
            int r151 = r148 + r150;
            String r152 = r100.localized_display_name;
            if (r152 == null) goto L69;
            int r153 = r101.encodedSizeWithTag(20, r152);
        L70:
            int r154 = r151 + r153;
            Boolean r155 = r100.is_cross_tenant;
            if (r155 == null) goto L73;
            int r156 = ProtoAdapter.BOOL.encodedSizeWithTag(21, r155);
        L74:
            int r157 = r154 + r156;
            String r158 = r100.tenant_id;
            if (r158 == null) goto L77;
            int r159 = r101.encodedSizeWithTag(22, r158);
        L78:
            int r160 = r157 + r159;
            Boolean r161 = r100.open_security;
            if (r161 == null) goto L81;
            int r162 = ProtoAdapter.BOOL.encodedSizeWithTag(23, r161);
        L82:
            int r163 = r160 + r162;
            Integer r164 = r100.show_member_limit;
            if (r164 == null) goto L85;
            int r165 = ProtoAdapter.INT32.encodedSizeWithTag(24, r164);
        L86:
            int r166 = r163 + r165;
            String r167 = r100.user_id;
            if (r167 == null) goto L89;
            int r168 = r101.encodedSizeWithTag(25, r167);
        L90:
            int r169 = r166 + r168;
            Boolean r170 = r100.is_editable;
            if (r170 == null) goto L93;
            int r171 = ProtoAdapter.BOOL.encodedSizeWithTag(26, r170);
        L94:
            int r172 = r169 + r171;
            String r173 = r100.inviter_calendar_id;
            if (r173 == null) goto L97;
            int r174 = r101.encodedSizeWithTag(27, r173);
        L98:
            int r175 = r172 + r174;
            Boolean r176 = r100.is_disabled;
            if (r176 == null) goto L101;
            int r177 = ProtoAdapter.BOOL.encodedSizeWithTag(28, r176);
        L102:
            int r178 = r175 + r177;
            String r179 = r100.email;
            if (r179 == null) goto L105;
            int r180 = r101.encodedSizeWithTag(29, r179);
        L106:
            int r181 = r178 + r180;
            Boolean r182 = r100.is_third_party;
            if (r182 == null) goto L109;
            int r183 = ProtoAdapter.BOOL.encodedSizeWithTag(30, r182);
        L110:
            int r184 = r181 + r183;
            String r185 = r100.avatar_path;
            if (r185 == null) goto L114;
            r104 = r101.encodedSizeWithTag(31, r185);
        L114:
            return (r184 + r104) + r100.unknownFields().size();
        L109:
            r183 = 0;
            goto L110
        L105:
            r180 = 0;
            goto L106
        L101:
            r177 = 0;
            goto L102
        L97:
            r174 = 0;
            goto L98
        L93:
            r171 = 0;
            goto L94
        L89:
            r168 = 0;
            goto L90
        L85:
            r165 = 0;
            goto L86
        L81:
            r162 = 0;
            goto L82
        L77:
            r159 = 0;
            goto L78
        L73:
            r156 = 0;
            goto L74
        L69:
            r153 = 0;
            goto L70
        L65:
            r150 = 0;
            goto L66
        L61:
            r147 = 0;
            goto L62
        L57:
            r144 = 0;
            goto L58
        L53:
            r141 = 0;
            goto L54
        L49:
            r138 = 0;
            goto L50
        L45:
            r135 = 0;
            goto L46
        L41:
            r132 = 0;
            goto L42
        L37:
            r129 = 0;
            goto L38
        L33:
            r126 = 0;
            goto L34
        L29:
            r123 = 0;
            goto L30
        L25:
            r120 = 0;
            goto L26
        L21:
            r117 = 0;
            goto L22
        L17:
            r114 = 0;
            goto L18
        L13:
            r111 = 0;
            goto L14
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ OldVersionCalendarEventAttendee decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(OldVersionCalendarEventAttendee r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, OldVersionCalendarEventAttendee r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.f253605id);
            String r103 = r101.key;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            Long r104 = r101.original_time;
            if (r104 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L8:
            String r105 = r101.display_name;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 4, r105);
        L11:
            r102.encodeWithTag(r100, 5, r101.attendee_calendar_id);
            Boolean r106 = r101.is_organizer;
            if (r106 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r106);
        L14:
            Boolean r107 = r101.is_resource;
            if (r107 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 7, r107);
        L17:
            Boolean r108 = r101.is_optional;
            if (r108 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 8, r108);
        L20:
            Status r109 = r101.status;
            if (r109 == null) goto L23;
            Status.ADAPTER.encodeWithTag(r100, 9, r109);
        L23:
            Integer r110 = r101.additional_guests_count;
            if (r110 == null) goto L26;
            ProtoAdapter.INT32.encodeWithTag(r100, 10, r110);
        L26:
            ImageSet r111 = r101.avatar;
            if (r111 == null) goto L29;
            ImageSet.ADAPTER.encodeWithTag(r100, 11, r111);
        L29:
            Long r112 = r101.create_time;
            if (r112 == null) goto L32;
            ProtoAdapter.INT64.encodeWithTag(r100, 12, r112);
        L32:
            Long r113 = r101.update_time;
            if (r113 == null) goto L35;
            ProtoAdapter.INT64.encodeWithTag(r100, 13, r113);
        L35:
            Calendar.Type r114 = r101.type;
            if (r114 == null) goto L38;
            Calendar.Type.ADAPTER.encodeWithTag(r100, 14, r114);
        L38:
            String r115 = r101.tags;
            if (r115 == null) goto L41;
            r102.encodeWithTag(r100, 15, r115);
        L41:
            String r116 = r101.group_id;
            if (r116 == null) goto L44;
            r102.encodeWithTag(r100, 16, r116);
        L44:
            Boolean r117 = r101.is_group;
            if (r117 == null) goto L47;
            ProtoAdapter.BOOL.encodeWithTag(r100, 17, r117);
        L47:
            OldVersionCalendarEventAttendee.ADAPTER.asRepeated().encodeWithTag(r100, 18, r101.group_members);
            String r118 = r101.avatar_key;
            if (r118 == null) goto L50;
            r102.encodeWithTag(r100, 19, r118);
        L50:
            String r119 = r101.localized_display_name;
            if (r119 == null) goto L53;
            r102.encodeWithTag(r100, 20, r119);
        L53:
            Boolean r120 = r101.is_cross_tenant;
            if (r120 == null) goto L56;
            ProtoAdapter.BOOL.encodeWithTag(r100, 21, r120);
        L56:
            String r121 = r101.tenant_id;
            if (r121 == null) goto L59;
            r102.encodeWithTag(r100, 22, r121);
        L59:
            Boolean r122 = r101.open_security;
            if (r122 == null) goto L62;
            ProtoAdapter.BOOL.encodeWithTag(r100, 23, r122);
        L62:
            Integer r123 = r101.show_member_limit;
            if (r123 == null) goto L65;
            ProtoAdapter.INT32.encodeWithTag(r100, 24, r123);
        L65:
            String r124 = r101.user_id;
            if (r124 == null) goto L68;
            r102.encodeWithTag(r100, 25, r124);
        L68:
            Boolean r125 = r101.is_editable;
            if (r125 == null) goto L71;
            ProtoAdapter.BOOL.encodeWithTag(r100, 26, r125);
        L71:
            String r126 = r101.inviter_calendar_id;
            if (r126 == null) goto L74;
            r102.encodeWithTag(r100, 27, r126);
        L74:
            Boolean r127 = r101.is_disabled;
            if (r127 == null) goto L77;
            ProtoAdapter.BOOL.encodeWithTag(r100, 28, r127);
        L77:
            String r128 = r101.email;
            if (r128 == null) goto L80;
            r102.encodeWithTag(r100, 29, r128);
        L80:
            Boolean r129 = r101.is_third_party;
            if (r129 == null) goto L83;
            ProtoAdapter.BOOL.encodeWithTag(r100, 30, r129);
        L83:
            String r130 = r101.avatar_path;
            if (r130 == null) goto L86;
            r102.encodeWithTag(r100, 31, r130);
        L86:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OldVersionCalendarEventAttendee r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Status extends Enum<Status> implements WireEnum {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final Status ACCEPT = null;
        public static final ProtoAdapter<Status> ADAPTER = null;
        public static final Status DECLINE = null;
        public static final Status NEEDS_ACTION = null;
        public static final Status REMOVED = null;
        public static final Status TENTATIVE = null;
        private final int value;

        static {
            Status r100 = new Status("NEEDS_ACTION", 0, 1);
            NEEDS_ACTION = r100;
            Status r101 = new Status("ACCEPT", 1, 2);
            ACCEPT = r101;
            Status r102 = new Status("TENTATIVE", 2, 3);
            TENTATIVE = r102;
            Status r103 = new Status("DECLINE", 3, 4);
            DECLINE = r103;
            Status r104 = new Status("REMOVED", 4, 5);
            REMOVED = r104;
            $VALUES = new Status[]{r100, r101, r102, r103, r104};
            ADAPTER = ProtoAdapter.newEnumAdapter(Status.class);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Status fromValue(int r100) {
            if (r100 == 1) goto L23;
            if (r100 == 2) goto L21;
            if (r100 == 3) goto L19;
            if (r100 == 4) goto L17;
            if (r100 == 5) goto L15;
            return null;
        L15:
            return REMOVED;
        L17:
            return DECLINE;
        L19:
            return TENTATIVE;
        L21:
            return ACCEPT;
        L23:
            return NEEDS_ACTION;
        }

        public static Status valueOf(String r100) {
            return (Status) a.a(Status.class, r100);
        }

        private Status(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_OldVersionCalendarEventAttendee();
        DEFAULT_ORIGINAL_TIME = 0L;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_ORGANIZER = r100;
        DEFAULT_IS_RESOURCE = r100;
        DEFAULT_IS_OPTIONAL = r100;
        DEFAULT_STATUS = Status.NEEDS_ACTION;
        DEFAULT_ADDITIONAL_GUESTS_COUNT = 0;
        DEFAULT_CREATE_TIME = 0L;
        DEFAULT_UPDATE_TIME = 0L;
        DEFAULT_TYPE = Calendar.Type.PRIMARY;
        DEFAULT_IS_GROUP = r100;
        DEFAULT_IS_CROSS_TENANT = r100;
        DEFAULT_OPEN_SECURITY = r100;
        DEFAULT_SHOW_MEMBER_LIMIT = 0;
        DEFAULT_IS_EDITABLE = r100;
        DEFAULT_IS_DISABLED = r100;
        DEFAULT_IS_THIRD_PARTY = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253606id = this.f253605id;
        r100.key = this.key;
        r100.original_time = this.original_time;
        r100.display_name = this.display_name;
        r100.attendee_calendar_id = this.attendee_calendar_id;
        r100.is_organizer = this.is_organizer;
        r100.is_resource = this.is_resource;
        r100.is_optional = this.is_optional;
        r100.status = this.status;
        r100.additional_guests_count = this.additional_guests_count;
        r100.avatar = this.avatar;
        r100.create_time = this.create_time;
        r100.update_time = this.update_time;
        r100.type = this.type;
        r100.tags = this.tags;
        r100.group_id = this.group_id;
        r100.is_group = this.is_group;
        r100.group_members = Internal.copyOf("group_members", this.group_members);
        r100.avatar_key = this.avatar_key;
        r100.localized_display_name = this.localized_display_name;
        r100.is_cross_tenant = this.is_cross_tenant;
        r100.tenant_id = this.tenant_id;
        r100.open_security = this.open_security;
        r100.show_member_limit = this.show_member_limit;
        r100.user_id = this.user_id;
        r100.is_editable = this.is_editable;
        r100.inviter_calendar_id = this.inviter_calendar_id;
        r100.is_disabled = this.is_disabled;
        r100.email = this.email;
        r100.is_third_party = this.is_third_party;
        r100.avatar_path = this.avatar_path;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return OldVersionCalendarEventAttendee.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public OldVersionCalendarEventAttendee(String r310, String r311, Long r312, String r313, String r314, Boolean r315, Boolean r410, Boolean r411, Status r412, Integer r413, ImageSet r414, Long r415, Long r416, Calendar.Type r417, String r418, String r419, Boolean r510, List<OldVersionCalendarEventAttendee> r511, String r512, String r513, Boolean r514, String r515, Boolean r516, Integer r517, String r518, Boolean r519, String r610, Boolean r611, String r612, Boolean r613, String r614) {
        this(r310, r311, r312, r313, r314, r315, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, ByteString.EMPTY);
    }

    public OldVersionCalendarEventAttendee(String r100, String r101, Long r102, String r103, String r104, Boolean r105, Boolean r110, Boolean r111, Status r112, Integer r113, ImageSet r114, Long r115, Long r116, Calendar.Type r117, String r118, String r119, Boolean r210, List<OldVersionCalendarEventAttendee> r211, String r212, String r213, Boolean r214, String r215, Boolean r216, Integer r217, String r218, Boolean r219, String r310, Boolean r311, String r312, Boolean r313, String r314, ByteString r315) {
        super(ADAPTER, r315);
        this.f253605id = r100;
        this.key = r101;
        this.original_time = r102;
        this.display_name = r103;
        this.attendee_calendar_id = r104;
        this.is_organizer = r105;
        this.is_resource = r110;
        this.is_optional = r111;
        this.status = r112;
        this.additional_guests_count = r113;
        this.avatar = r114;
        this.create_time = r115;
        this.update_time = r116;
        this.type = r117;
        this.tags = r118;
        this.group_id = r119;
        this.is_group = r210;
        this.group_members = Internal.immutableCopyOf("group_members", r211);
        this.avatar_key = r212;
        this.localized_display_name = r213;
        this.is_cross_tenant = r214;
        this.tenant_id = r215;
        this.open_security = r216;
        this.show_member_limit = r217;
        this.user_id = r218;
        this.is_editable = r219;
        this.inviter_calendar_id = r310;
        this.is_disabled = r311;
        this.email = r312;
        this.is_third_party = r313;
        this.avatar_path = r314;
    }
}
