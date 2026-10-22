package com.bytedance.lark.pb.calendar.v1;

import annotation.Debug;
import com.bytedance.lark.pb.basic.v1.TagData;
import com.google.protobuf.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class CalendarEventAttendee extends Message<CalendarEventAttendee, Builder> {
    public static final ProtoAdapter<CalendarEventAttendee> ADAPTER = null;
    public static final Integer DEFAULT_ADDITIONAL_GUESTS_COUNT = null;
    public static final String DEFAULT_ATTENDEE_CALENDAR_ID = "";
    public static final String DEFAULT_AVATAR_KEY = "";
    public static final String DEFAULT_AVATAR_PATH = "";
    public static final Category DEFAULT_CATEGORY = null;
    public static final String DEFAULT_DISPLAY_NAME = "";
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_INVITER_CALENDAR_ID = "";
    public static final Boolean DEFAULT_IS_DIRTY = null;
    public static final Boolean DEFAULT_IS_EDITABLE = null;
    public static final Boolean DEFAULT_IS_OPTIONAL = null;
    public static final Boolean DEFAULT_IS_ORGANIZER = null;
    public static final String DEFAULT_KEY = "";
    public static final Long DEFAULT_ORIGINAL_TIME = null;
    public static final Status DEFAULT_STATUS = null;
    public static final FieldOptions FIELD_OPTIONS_GROUP = null;
    public static final FieldOptions FIELD_OPTIONS_PHONE_USER = null;
    public static final FieldOptions FIELD_OPTIONS_RESOURCE = null;
    public static final FieldOptions FIELD_OPTIONS_THIRD_PARTY_USER = null;
    public static final FieldOptions FIELD_OPTIONS_USER = null;
    private static final long serialVersionUID = 0;
    public final Integer additional_guests_count;
    public final String attendee_calendar_id;
    public final CalendarSchemaCollection attendee_schema;
    public final String avatar_key;
    public final String avatar_path;
    public final Category category;
    public final String display_name;
    public final Group group;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253599id;
    public final String inviter_calendar_id;
    public final Boolean is_dirty;
    public final Boolean is_editable;
    public final Boolean is_optional;
    public final Boolean is_organizer;
    public final String key;
    public final Long original_time;
    public final PhoneUser phone_user;
    public final TagData relation_tag;
    public final Resource resource;
    public final SchemaExtraData schema_extra_data;
    public final Status status;
    public final ThirdPartyUser third_party_user;
    public final User user;

    public static final class Builder extends Message.Builder<CalendarEventAttendee, Builder> {
        public Integer additional_guests_count;
        public String attendee_calendar_id;
        public CalendarSchemaCollection attendee_schema;
        public String avatar_key;
        public String avatar_path;
        public Category category;
        public String display_name;
        public Group group;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253600id;
        public String inviter_calendar_id;
        public Boolean is_dirty;
        public Boolean is_editable;
        public Boolean is_optional;
        public Boolean is_organizer;
        public String key;
        public Long original_time;
        public PhoneUser phone_user;
        public TagData relation_tag;
        public Resource resource;
        public SchemaExtraData schema_extra_data;
        public Status status;
        public ThirdPartyUser third_party_user;
        public User user;

        @Override // com.squareup.wire.Message.Builder
        public CalendarEventAttendee build() {
            String r100 = this.f253600id;
            if (r100 == null) goto L9;
            if (this.attendee_calendar_id == null) goto L9;
            return new CalendarEventAttendee(this.f253600id, this.key, this.original_time, this.display_name, this.attendee_calendar_id, this.is_organizer, this.is_optional, this.status, this.additional_guests_count, this.is_editable, this.inviter_calendar_id, this.avatar_key, this.category, this.avatar_path, this.attendee_schema, this.schema_extra_data, this.is_dirty, this.relation_tag, this.user, this.group, this.resource, this.third_party_user, this.phone_user, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "id", this.attendee_calendar_id, "attendee_calendar_id"});
        }

        public Builder() {
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

        public Builder attendee_schema(CalendarSchemaCollection r100) {
            this.attendee_schema = r100;
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

        public Builder category(Category r100) {
            this.category = r100;
            return this;
        }

        public Builder display_name(String r100) {
            this.display_name = r100;
            return this;
        }

        public Builder group(Group r100) {
            this.group = r100;
            this.user = null;
            this.resource = null;
            this.third_party_user = null;
            this.phone_user = null;
            return this;
        }

        public Builder id(String r100) {
            this.f253600id = r100;
            return this;
        }

        public Builder inviter_calendar_id(String r100) {
            this.inviter_calendar_id = r100;
            return this;
        }

        public Builder is_dirty(Boolean r100) {
            this.is_dirty = r100;
            return this;
        }

        public Builder is_editable(Boolean r100) {
            this.is_editable = r100;
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

        public Builder key(String r100) {
            this.key = r100;
            return this;
        }

        public Builder original_time(Long r100) {
            this.original_time = r100;
            return this;
        }

        public Builder phone_user(PhoneUser r100) {
            this.phone_user = r100;
            this.user = null;
            this.group = null;
            this.resource = null;
            this.third_party_user = null;
            return this;
        }

        public Builder relation_tag(TagData r100) {
            this.relation_tag = r100;
            return this;
        }

        public Builder resource(Resource r100) {
            this.resource = r100;
            this.user = null;
            this.group = null;
            this.third_party_user = null;
            this.phone_user = null;
            return this;
        }

        public Builder schema_extra_data(SchemaExtraData r100) {
            this.schema_extra_data = r100;
            return this;
        }

        public Builder status(Status r100) {
            this.status = r100;
            return this;
        }

        public Builder third_party_user(ThirdPartyUser r100) {
            this.third_party_user = r100;
            this.user = null;
            this.group = null;
            this.resource = null;
            this.phone_user = null;
            return this;
        }

        public Builder user(User r100) {
            this.user = r100;
            this.group = null;
            this.resource = null;
            this.third_party_user = null;
            this.phone_user = null;
            return this;
        }
    }

    public static final enum Category extends Enum<Category> implements WireEnum {
        private static final /* synthetic */ Category[] $VALUES = null;
        public static final ProtoAdapter<Category> ADAPTER = null;
        public static final Category GROUP = null;
        public static final Category PHONE = null;
        public static final Category RESOURCE = null;
        public static final Category THIRD_PARTY_USER = null;
        public static final Category UNKNOWN_CATEGORY = null;
        public static final Category USER = null;
        private final int value;

        static {
            Category r100 = new Category("UNKNOWN_CATEGORY", 0, 0);
            UNKNOWN_CATEGORY = r100;
            Category r101 = new Category(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 1, 1);
            USER = r101;
            Category r102 = new Category("GROUP", 2, 2);
            GROUP = r102;
            Category r103 = new Category("RESOURCE", 3, 3);
            RESOURCE = r103;
            Category r104 = new Category("THIRD_PARTY_USER", 4, 4);
            THIRD_PARTY_USER = r104;
            Category r105 = new Category("PHONE", 5, 5);
            PHONE = r105;
            $VALUES = new Category[]{r100, r101, r102, r103, r104, r105};
            ADAPTER = ProtoAdapter.newEnumAdapter(Category.class);
        }

        public static Category[] values() {
            return (Category[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Category fromValue(int r100) {
            if (r100 == 0) goto L26;
            if (r100 == 1) goto L24;
            if (r100 == 2) goto L22;
            if (r100 == 3) goto L20;
            if (r100 == 4) goto L18;
            if (r100 == 5) goto L16;
            return null;
        L16:
            return PHONE;
        L18:
            return THIRD_PARTY_USER;
        L20:
            return RESOURCE;
        L22:
            return GROUP;
        L24:
            return USER;
        L26:
            return UNKNOWN_CATEGORY;
        }

        public static Category valueOf(String r100) {
            return (Category) a.a(Category.class, r100);
        }

        private Category(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Group extends Message<Group, Builder> {
        public static final ProtoAdapter<Group> ADAPTER = null;
        public static final String DEFAULT_GROUP_ID = "";
        public static final Boolean DEFAULT_IS_ANY_REMOVED = null;
        public static final Boolean DEFAULT_IS_CROSS_TENANT = null;
        public static final Boolean DEFAULT_IS_SELF_IN_GROUP = null;
        public static final Boolean DEFAULT_IS_USER_COUNT_VISIBLE = null;
        public static final Boolean DEFAULT_OPEN_SECURITY = null;
        public static final Integer DEFAULT_SHOW_MEMBER_LIMIT = null;
        public static final String DEFAULT_TENANT_ID = "";
        public static final Integer DEFAULT_VALID_MEMBER_COUNT = null;
        private static final long serialVersionUID = 0;
        public final String group_id;
        public final Boolean is_any_removed;
        public final Boolean is_cross_tenant;
        public final Boolean is_self_in_group;
        public final Boolean is_user_count_visible;
        public final List<CalendarEventAttendee> members;
        public final Boolean open_security;
        public final Integer show_member_limit;
        public final String tenant_id;
        public final Integer valid_member_count;

        public static final class Builder extends Message.Builder<Group, Builder> {
            public String group_id;
            public Boolean is_any_removed;
            public Boolean is_cross_tenant;
            public Boolean is_self_in_group;
            public Boolean is_user_count_visible;
            public List<CalendarEventAttendee> members;
            public Boolean open_security;
            public Integer show_member_limit;
            public String tenant_id;
            public Integer valid_member_count;

            @Override // com.squareup.wire.Message.Builder
            public Group build() {
                return new Group(this.group_id, this.members, this.tenant_id, this.is_cross_tenant, this.open_security, this.show_member_limit, this.valid_member_count, this.is_any_removed, this.is_self_in_group, this.is_user_count_visible, super.buildUnknownFields());
            }

            public Builder() {
                this.members = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder group_id(String r100) {
                this.group_id = r100;
                return this;
            }

            public Builder is_any_removed(Boolean r100) {
                this.is_any_removed = r100;
                return this;
            }

            public Builder is_cross_tenant(Boolean r100) {
                this.is_cross_tenant = r100;
                return this;
            }

            public Builder is_self_in_group(Boolean r100) {
                this.is_self_in_group = r100;
                return this;
            }

            public Builder is_user_count_visible(Boolean r100) {
                this.is_user_count_visible = r100;
                return this;
            }

            public Builder members(List<CalendarEventAttendee> r100) {
                Internal.checkElementsNotNull(r100);
                this.members = r100;
                return this;
            }

            public Builder open_security(Boolean r100) {
                this.open_security = r100;
                return this;
            }

            public Builder show_member_limit(Integer r100) {
                this.show_member_limit = r100;
                return this;
            }

            public Builder tenant_id(String r100) {
                this.tenant_id = r100;
                return this;
            }

            public Builder valid_member_count(Integer r100) {
                this.valid_member_count = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Group extends ProtoAdapter<Group> {
            public ProtoAdapter_Group() {
                super(FieldEncoding.LENGTH_DELIMITED, Group.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Group decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.group_id = "";
                r101.tenant_id = "";
                Boolean r102 = Boolean.FALSE;
                r101.is_cross_tenant = r102;
                r101.open_security = r102;
                r101.show_member_limit = 0;
                r101.valid_member_count = 0;
                r101.is_any_removed = r102;
                r101.is_self_in_group = r102;
                r101.is_user_count_visible = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L17;
                switch(r104) {
                    case 1: goto L16;
                    case 2: goto L15;
                    case 3: goto L14;
                    case 4: goto L13;
                    case 5: goto L12;
                    case 6: goto L11;
                    case 7: goto L10;
                    case 8: goto L9;
                    case 9: goto L8;
                    case 10: goto L7;
                    default: goto L6;
                };
            L7:
                r101.is_user_count_visible = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                r101.is_self_in_group = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L9:
                r101.is_any_removed = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L10:
                r101.valid_member_count = ProtoAdapter.INT32.decode(r100);
                goto L3
            L11:
                r101.show_member_limit = ProtoAdapter.INT32.decode(r100);
                goto L3
            L12:
                r101.open_security = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L13:
                r101.is_cross_tenant = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L14:
                r101.tenant_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L15:
                r101.members.add(CalendarEventAttendee.ADAPTER.decode(r100));
                goto L3
            L16:
                r101.group_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L6:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L17:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(Group r100) {
                String r101 = r100.group_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                int r104 = r103 + CalendarEventAttendee.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.members);
                String r105 = r100.tenant_id;
                if (r105 == null) goto L9;
                int r106 = ProtoAdapter.STRING.encodedSizeWithTag(3, r105);
            L10:
                int r107 = r104 + r106;
                Boolean r108 = r100.is_cross_tenant;
                if (r108 == null) goto L13;
                int r109 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r108);
            L14:
                int r110 = r107 + r109;
                Boolean r111 = r100.open_security;
                if (r111 == null) goto L17;
                int r112 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r111);
            L18:
                int r113 = r110 + r112;
                Integer r114 = r100.show_member_limit;
                if (r114 == null) goto L21;
                int r115 = ProtoAdapter.INT32.encodedSizeWithTag(6, r114);
            L22:
                int r116 = r113 + r115;
                Integer r117 = r100.valid_member_count;
                if (r117 == null) goto L25;
                int r118 = ProtoAdapter.INT32.encodedSizeWithTag(7, r117);
            L26:
                int r119 = r116 + r118;
                Boolean r120 = r100.is_any_removed;
                if (r120 == null) goto L29;
                int r121 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r120);
            L30:
                int r122 = r119 + r121;
                Boolean r123 = r100.is_self_in_group;
                if (r123 == null) goto L33;
                int r124 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r123);
            L34:
                int r125 = r122 + r124;
                Boolean r126 = r100.is_user_count_visible;
                if (r126 == null) goto L38;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(10, r126);
            L38:
                return (r125 + r102) + r100.unknownFields().size();
            L33:
                r124 = 0;
                goto L34
            L29:
                r121 = 0;
                goto L30
            L25:
                r118 = 0;
                goto L26
            L21:
                r115 = 0;
                goto L22
            L17:
                r112 = 0;
                goto L18
            L13:
                r109 = 0;
                goto L14
            L9:
                r106 = 0;
                goto L10
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Group decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Group r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Group r101) throws IOException {
                String r102 = r101.group_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                CalendarEventAttendee.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.members);
                String r103 = r101.tenant_id;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r103);
            L8:
                Boolean r104 = r101.is_cross_tenant;
                if (r104 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r100, 4, r104);
            L11:
                Boolean r105 = r101.open_security;
                if (r105 == null) goto L14;
                ProtoAdapter.BOOL.encodeWithTag(r100, 5, r105);
            L14:
                Integer r106 = r101.show_member_limit;
                if (r106 == null) goto L17;
                ProtoAdapter.INT32.encodeWithTag(r100, 6, r106);
            L17:
                Integer r107 = r101.valid_member_count;
                if (r107 == null) goto L20;
                ProtoAdapter.INT32.encodeWithTag(r100, 7, r107);
            L20:
                Boolean r108 = r101.is_any_removed;
                if (r108 == null) goto L23;
                ProtoAdapter.BOOL.encodeWithTag(r100, 8, r108);
            L23:
                Boolean r109 = r101.is_self_in_group;
                if (r109 == null) goto L26;
                ProtoAdapter.BOOL.encodeWithTag(r100, 9, r109);
            L26:
                Boolean r110 = r101.is_user_count_visible;
                if (r110 == null) goto L29;
                ProtoAdapter.BOOL.encodeWithTag(r100, 10, r110);
            L29:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Group r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Group();
            Boolean r100 = Boolean.FALSE;
            DEFAULT_IS_CROSS_TENANT = r100;
            DEFAULT_OPEN_SECURITY = r100;
            DEFAULT_SHOW_MEMBER_LIMIT = 0;
            DEFAULT_VALID_MEMBER_COUNT = 0;
            DEFAULT_IS_ANY_REMOVED = r100;
            DEFAULT_IS_SELF_IN_GROUP = r100;
            DEFAULT_IS_USER_COUNT_VISIBLE = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.group_id = this.group_id;
            r100.members = Internal.copyOf("members", this.members);
            r100.tenant_id = this.tenant_id;
            r100.is_cross_tenant = this.is_cross_tenant;
            r100.open_security = this.open_security;
            r100.show_member_limit = this.show_member_limit;
            r100.valid_member_count = this.valid_member_count;
            r100.is_any_removed = this.is_any_removed;
            r100.is_self_in_group = this.is_self_in_group;
            r100.is_user_count_visible = this.is_user_count_visible;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Group.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public Group(String r110, List<CalendarEventAttendee> r111, String r112, Boolean r113, Boolean r114, Integer r115, Integer r116, Boolean r210, Boolean r211, Boolean r212) {
            this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
        }

        public Group(String r100, List<CalendarEventAttendee> r101, String r102, Boolean r103, Boolean r104, Integer r105, Integer r106, Boolean r107, Boolean r110, Boolean r111, ByteString r112) {
            super(ADAPTER, r112);
            this.group_id = r100;
            this.members = Internal.immutableCopyOf("members", r101);
            this.tenant_id = r102;
            this.is_cross_tenant = r103;
            this.open_security = r104;
            this.show_member_limit = r105;
            this.valid_member_count = r106;
            this.is_any_removed = r107;
            this.is_self_in_group = r110;
            this.is_user_count_visible = r111;
        }
    }

    public static final enum MailContactType extends Enum<MailContactType> implements WireEnum {
        private static final /* synthetic */ MailContactType[] $VALUES = null;
        public static final ProtoAdapter<MailContactType> ADAPTER = null;
        public static final MailContactType MAIL_CONTACT = null;
        public static final MailContactType MAIL_GROUP = null;
        public static final MailContactType NORMAL_MAIL = null;
        public static final MailContactType PUBLIC_MAIL = null;
        public static final MailContactType UNKNOWN = null;
        private final int value;

        static {
            MailContactType r100 = new MailContactType("NORMAL_MAIL", 0, 0);
            NORMAL_MAIL = r100;
            MailContactType r101 = new MailContactType("MAIL_CONTACT", 1, 1);
            MAIL_CONTACT = r101;
            MailContactType r102 = new MailContactType("PUBLIC_MAIL", 2, 2);
            PUBLIC_MAIL = r102;
            MailContactType r103 = new MailContactType("MAIL_GROUP", 3, 3);
            MAIL_GROUP = r103;
            MailContactType r104 = new MailContactType("UNKNOWN", 4, 4);
            UNKNOWN = r104;
            $VALUES = new MailContactType[]{r100, r101, r102, r103, r104};
            ADAPTER = ProtoAdapter.newEnumAdapter(MailContactType.class);
        }

        public static MailContactType[] values() {
            return (MailContactType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static MailContactType fromValue(int r100) {
            if (r100 == 0) goto L22;
            if (r100 == 1) goto L20;
            if (r100 == 2) goto L18;
            if (r100 == 3) goto L16;
            if (r100 == 4) goto L14;
            return null;
        L14:
            return UNKNOWN;
        L16:
            return MAIL_GROUP;
        L18:
            return PUBLIC_MAIL;
        L20:
            return MAIL_CONTACT;
        L22:
            return NORMAL_MAIL;
        }

        public static MailContactType valueOf(String r100) {
            return (MailContactType) a.a(MailContactType.class, r100);
        }

        private MailContactType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class PhoneUser extends Message<PhoneUser, Builder> {
        public static final ProtoAdapter<PhoneUser> ADAPTER = null;
        public static final String DEFAULT_PHONE = "";
        private static final long serialVersionUID = 0;
        public final String phone;

        public static final class Builder extends Message.Builder<PhoneUser, Builder> {
            public String phone;

            @Override // com.squareup.wire.Message.Builder
            public PhoneUser build() {
                return new PhoneUser(this.phone, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder phone(String r100) {
                this.phone = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_PhoneUser extends ProtoAdapter<PhoneUser> {
            public ProtoAdapter_PhoneUser() {
                super(FieldEncoding.LENGTH_DELIMITED, PhoneUser.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public PhoneUser decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.phone = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.phone = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(PhoneUser r100) {
                String r101 = r100.phone;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ PhoneUser decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(PhoneUser r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, PhoneUser r101) throws IOException {
                String r102 = r101.phone;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PhoneUser r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_PhoneUser();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.phone = this.phone;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return PhoneUser.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public PhoneUser(String r100) {
            this(r100, ByteString.EMPTY);
        }

        public PhoneUser(String r100, ByteString r101) {
            super(ADAPTER, r101);
            this.phone = r100;
        }
    }

    public static final class ProtoAdapter_CalendarEventAttendee extends ProtoAdapter<CalendarEventAttendee> {
        public ProtoAdapter_CalendarEventAttendee() {
            super(FieldEncoding.LENGTH_DELIMITED, CalendarEventAttendee.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CalendarEventAttendee decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253600id = "";
            r101.key = "";
            r101.original_time = 0L;
            r101.display_name = "";
            r101.attendee_calendar_id = "";
            Boolean r102 = Boolean.FALSE;
            r101.is_organizer = r102;
            r101.is_optional = r102;
            r101.status = Status.NEEDS_ACTION;
            r101.additional_guests_count = 0;
            r101.is_editable = r102;
            r101.inviter_calendar_id = "";
            r101.avatar_key = "";
            r101.category = Category.UNKNOWN_CATEGORY;
            r101.avatar_path = "";
            r101.is_dirty = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L37;
            switch(r104) {
                case 1: goto L36;
                case 2: goto L35;
                case 3: goto L34;
                case 4: goto L33;
                case 5: goto L32;
                case 6: goto L31;
                case 7: goto L30;
                case 8: goto L39;
                case 9: goto L25;
                case 10: goto L24;
                case 11: goto L23;
                case 12: goto L22;
                case 13: goto L41;
                case 14: goto L17;
                case 15: goto L16;
                case 16: goto L15;
                case 17: goto L14;
                case 18: goto L13;
                default: goto L6;
            };
        L39:
            r101.status = Status.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L28
        L28:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L41:
            r101.category = Category.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L13:
            r101.relation_tag = TagData.ADAPTER.decode(r100);
            goto L3
        L14:
            r101.is_dirty = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L15:
            r101.schema_extra_data = SchemaExtraData.ADAPTER.decode(r100);
            goto L3
        L16:
            r101.attendee_schema = CalendarSchemaCollection.ADAPTER.decode(r100);
            goto L3
        L17:
            r101.avatar_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L22:
            r101.avatar_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L23:
            r101.inviter_calendar_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L24:
            r101.is_editable = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L25:
            r101.additional_guests_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L30:
            r101.is_optional = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L31:
            r101.is_organizer = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L32:
            r101.attendee_calendar_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L33:
            r101.display_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L34:
            r101.original_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L35:
            r101.key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L36:
            r101.f253600id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            switch(r104) {
                case 100: goto L12;
                case 101: goto L11;
                case 102: goto L10;
                case 103: goto L9;
                case 104: goto L8;
                default: goto L7;
            };
        L8:
            r101.phone_user(PhoneUser.ADAPTER.decode(r100));
            goto L3
        L9:
            r101.third_party_user(ThirdPartyUser.ADAPTER.decode(r100));
            goto L3
        L10:
            r101.resource(Resource.ADAPTER.decode(r100));
            goto L3
        L11:
            r101.group(Group.ADAPTER.decode(r100));
            goto L3
        L12:
            r101.user(User.ADAPTER.decode(r100));
            goto L3
        L7:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L37:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CalendarEventAttendee r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.f253599id);
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
            Boolean r116 = r100.is_optional;
            if (r116 == null) goto L21;
            int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r116);
        L22:
            int r118 = r115 + r117;
            Status r119 = r100.status;
            if (r119 == null) goto L25;
            int r120 = Status.ADAPTER.encodedSizeWithTag(8, r119);
        L26:
            int r121 = r118 + r120;
            Integer r122 = r100.additional_guests_count;
            if (r122 == null) goto L29;
            int r123 = ProtoAdapter.INT32.encodedSizeWithTag(9, r122);
        L30:
            int r124 = r121 + r123;
            Boolean r125 = r100.is_editable;
            if (r125 == null) goto L33;
            int r126 = ProtoAdapter.BOOL.encodedSizeWithTag(10, r125);
        L34:
            int r127 = r124 + r126;
            String r128 = r100.inviter_calendar_id;
            if (r128 == null) goto L37;
            int r129 = r101.encodedSizeWithTag(11, r128);
        L38:
            int r130 = r127 + r129;
            String r131 = r100.avatar_key;
            if (r131 == null) goto L41;
            int r132 = r101.encodedSizeWithTag(12, r131);
        L42:
            int r133 = r130 + r132;
            Category r134 = r100.category;
            if (r134 == null) goto L45;
            int r135 = Category.ADAPTER.encodedSizeWithTag(13, r134);
        L46:
            int r136 = r133 + r135;
            String r137 = r100.avatar_path;
            if (r137 == null) goto L49;
            int r138 = r101.encodedSizeWithTag(14, r137);
        L50:
            int r139 = r136 + r138;
            CalendarSchemaCollection r140 = r100.attendee_schema;
            if (r140 == null) goto L53;
            int r141 = CalendarSchemaCollection.ADAPTER.encodedSizeWithTag(15, r140);
        L54:
            int r142 = r139 + r141;
            SchemaExtraData r143 = r100.schema_extra_data;
            if (r143 == null) goto L57;
            int r144 = SchemaExtraData.ADAPTER.encodedSizeWithTag(16, r143);
        L58:
            int r145 = r142 + r144;
            Boolean r146 = r100.is_dirty;
            if (r146 == null) goto L61;
            int r147 = ProtoAdapter.BOOL.encodedSizeWithTag(17, r146);
        L62:
            int r148 = r145 + r147;
            TagData r149 = r100.relation_tag;
            if (r149 == null) goto L65;
            int r150 = TagData.ADAPTER.encodedSizeWithTag(18, r149);
        L66:
            int r151 = r148 + r150;
            User r152 = r100.user;
            if (r152 == null) goto L69;
            int r153 = User.ADAPTER.encodedSizeWithTag(100, r152);
        L70:
            int r154 = r151 + r153;
            Group r155 = r100.group;
            if (r155 == null) goto L73;
            int r156 = Group.ADAPTER.encodedSizeWithTag(101, r155);
        L74:
            int r157 = r154 + r156;
            Resource r158 = r100.resource;
            if (r158 == null) goto L77;
            int r159 = Resource.ADAPTER.encodedSizeWithTag(102, r158);
        L78:
            int r160 = r157 + r159;
            ThirdPartyUser r161 = r100.third_party_user;
            if (r161 == null) goto L81;
            int r162 = ThirdPartyUser.ADAPTER.encodedSizeWithTag(103, r161);
        L82:
            int r163 = r160 + r162;
            PhoneUser r164 = r100.phone_user;
            if (r164 == null) goto L86;
            r104 = PhoneUser.ADAPTER.encodedSizeWithTag(104, r164);
        L86:
            return (r163 + r104) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ CalendarEventAttendee decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CalendarEventAttendee r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CalendarEventAttendee r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.f253599id);
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
            Boolean r107 = r101.is_optional;
            if (r107 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 7, r107);
        L17:
            Status r108 = r101.status;
            if (r108 == null) goto L20;
            Status.ADAPTER.encodeWithTag(r100, 8, r108);
        L20:
            Integer r109 = r101.additional_guests_count;
            if (r109 == null) goto L23;
            ProtoAdapter.INT32.encodeWithTag(r100, 9, r109);
        L23:
            Boolean r110 = r101.is_editable;
            if (r110 == null) goto L26;
            ProtoAdapter.BOOL.encodeWithTag(r100, 10, r110);
        L26:
            String r111 = r101.inviter_calendar_id;
            if (r111 == null) goto L29;
            r102.encodeWithTag(r100, 11, r111);
        L29:
            String r112 = r101.avatar_key;
            if (r112 == null) goto L32;
            r102.encodeWithTag(r100, 12, r112);
        L32:
            Category r113 = r101.category;
            if (r113 == null) goto L35;
            Category.ADAPTER.encodeWithTag(r100, 13, r113);
        L35:
            String r114 = r101.avatar_path;
            if (r114 == null) goto L38;
            r102.encodeWithTag(r100, 14, r114);
        L38:
            CalendarSchemaCollection r115 = r101.attendee_schema;
            if (r115 == null) goto L41;
            CalendarSchemaCollection.ADAPTER.encodeWithTag(r100, 15, r115);
        L41:
            SchemaExtraData r116 = r101.schema_extra_data;
            if (r116 == null) goto L44;
            SchemaExtraData.ADAPTER.encodeWithTag(r100, 16, r116);
        L44:
            Boolean r117 = r101.is_dirty;
            if (r117 == null) goto L47;
            ProtoAdapter.BOOL.encodeWithTag(r100, 17, r117);
        L47:
            TagData r118 = r101.relation_tag;
            if (r118 == null) goto L50;
            TagData.ADAPTER.encodeWithTag(r100, 18, r118);
        L50:
            User r119 = r101.user;
            if (r119 == null) goto L53;
            User.ADAPTER.encodeWithTag(r100, 100, r119);
        L53:
            Group r120 = r101.group;
            if (r120 == null) goto L56;
            Group.ADAPTER.encodeWithTag(r100, 101, r120);
        L56:
            Resource r121 = r101.resource;
            if (r121 == null) goto L59;
            Resource.ADAPTER.encodeWithTag(r100, 102, r121);
        L59:
            ThirdPartyUser r122 = r101.third_party_user;
            if (r122 == null) goto L62;
            ThirdPartyUser.ADAPTER.encodeWithTag(r100, 103, r122);
        L62:
            PhoneUser r123 = r101.phone_user;
            if (r123 == null) goto L65;
            PhoneUser.ADAPTER.encodeWithTag(r100, 104, r123);
        L65:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CalendarEventAttendee r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class Resource extends Message<Resource, Builder> {
        public static final ProtoAdapter<Resource> ADAPTER = null;
        public static final String DEFAULT_BOOKER_ID = "";
        public static final Boolean DEFAULT_IS_DISABLED = null;
        public static final ResourceStatus DEFAULT_RESOURCE_STATUS = null;
        public static final String DEFAULT_TENANT_ID = "";
        private static final long serialVersionUID = 0;
        public final String booker_id;
        public final Boolean is_disabled;
        public final ResourceStatus resource_status;
        public final String tenant_id;

        public static final class Builder extends Message.Builder<Resource, Builder> {
            public String booker_id;
            public Boolean is_disabled;
            public ResourceStatus resource_status;
            public String tenant_id;

            @Override // com.squareup.wire.Message.Builder
            public Resource build() {
                return new Resource(this.tenant_id, this.is_disabled, this.resource_status, this.booker_id, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder booker_id(String r100) {
                this.booker_id = r100;
                return this;
            }

            public Builder is_disabled(Boolean r100) {
                this.is_disabled = r100;
                return this;
            }

            public Builder resource_status(ResourceStatus r100) {
                this.resource_status = r100;
                return this;
            }

            public Builder tenant_id(String r100) {
                this.tenant_id = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Resource extends ProtoAdapter<Resource> {
            public ProtoAdapter_Resource() {
                super(FieldEncoding.LENGTH_DELIMITED, Resource.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Resource decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.tenant_id = "";
                r101.is_disabled = Boolean.FALSE;
                r101.resource_status = ResourceStatus.NORMAL;
                r101.booker_id = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                if (r103 != 1) goto L8;
                r101.tenant_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.is_disabled = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.resource_status = ResourceStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
            L17:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.booker_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L13:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L21:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(Resource r100) {
                String r101 = r100.tenant_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                Boolean r104 = r100.is_disabled;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                ResourceStatus r107 = r100.resource_status;
                if (r107 == null) goto L13;
                int r108 = ResourceStatus.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.booker_id;
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
            public /* bridge */ /* synthetic */ Resource decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Resource r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Resource r101) throws IOException {
                String r102 = r101.tenant_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                Boolean r103 = r101.is_disabled;
                if (r103 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
            L8:
                ResourceStatus r104 = r101.resource_status;
                if (r104 == null) goto L11;
                ResourceStatus.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.booker_id;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Resource r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Resource();
            DEFAULT_IS_DISABLED = Boolean.FALSE;
            DEFAULT_RESOURCE_STATUS = ResourceStatus.NORMAL;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.tenant_id = this.tenant_id;
            r100.is_disabled = this.is_disabled;
            r100.resource_status = this.resource_status;
            r100.booker_id = this.booker_id;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Resource.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public Resource(String r100, Boolean r101, ResourceStatus r102, String r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public Resource(String r100, Boolean r101, ResourceStatus r102, String r103, ByteString r104) {
            super(ADAPTER, r104);
            this.tenant_id = r100;
            this.is_disabled = r101;
            this.resource_status = r102;
            this.booker_id = r103;
        }
    }

    public static final enum ResourceStatus extends Enum<ResourceStatus> implements WireEnum {
        private static final /* synthetic */ ResourceStatus[] $VALUES = null;
        public static final ProtoAdapter<ResourceStatus> ADAPTER = null;
        public static final ResourceStatus NORMAL = null;
        public static final ResourceStatus RELEASED_EARLY = null;
        private final int value;

        static {
            ResourceStatus r100 = new ResourceStatus(EffectConstants.NORMAL, 0, 0);
            NORMAL = r100;
            ResourceStatus r101 = new ResourceStatus("RELEASED_EARLY", 1, 1);
            RELEASED_EARLY = r101;
            $VALUES = new ResourceStatus[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(ResourceStatus.class);
        }

        public static ResourceStatus[] values() {
            return (ResourceStatus[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ResourceStatus fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return RELEASED_EARLY;
        L10:
            return NORMAL;
        }

        public static ResourceStatus valueOf(String r100) {
            return (ResourceStatus) a.a(ResourceStatus.class, r100);
        }

        private ResourceStatus(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
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

    public static final class ThirdPartyUser extends Message<ThirdPartyUser, Builder> {
        public static final ProtoAdapter<ThirdPartyUser> ADAPTER = null;
        public static final String DEFAULT_EMAIL = "";
        public static final MailContactType DEFAULT_MAIL_CONTACT_TYPE = null;
        private static final long serialVersionUID = 0;
        public final String email;
        public final MailContactType mail_contact_type;

        public static final class Builder extends Message.Builder<ThirdPartyUser, Builder> {
            public String email;
            public MailContactType mail_contact_type;

            @Override // com.squareup.wire.Message.Builder
            public ThirdPartyUser build() {
                return new ThirdPartyUser(this.email, this.mail_contact_type, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder email(String r100) {
                this.email = r100;
                return this;
            }

            public Builder mail_contact_type(MailContactType r100) {
                this.mail_contact_type = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ThirdPartyUser extends ProtoAdapter<ThirdPartyUser> {
            public ProtoAdapter_ThirdPartyUser() {
                super(FieldEncoding.LENGTH_DELIMITED, ThirdPartyUser.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ThirdPartyUser decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.email = "";
                r101.mail_contact_type = MailContactType.NORMAL_MAIL;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.email = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.mail_contact_type = MailContactType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
            L12:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
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
            public int encodedSize2(ThirdPartyUser r100) {
                String r101 = r100.email;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                MailContactType r104 = r100.mail_contact_type;
                if (r104 == null) goto L10;
                r102 = MailContactType.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ThirdPartyUser decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ThirdPartyUser r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ThirdPartyUser r101) throws IOException {
                String r102 = r101.email;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                MailContactType r103 = r101.mail_contact_type;
                if (r103 == null) goto L8;
                MailContactType.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ThirdPartyUser r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ThirdPartyUser();
            DEFAULT_MAIL_CONTACT_TYPE = MailContactType.NORMAL_MAIL;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.email = this.email;
            r100.mail_contact_type = this.mail_contact_type;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ThirdPartyUser.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ThirdPartyUser(String r100, MailContactType r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public ThirdPartyUser(String r100, MailContactType r101, ByteString r102) {
            super(ADAPTER, r102);
            this.email = r100;
            this.mail_contact_type = r101;
        }
    }

    public static final class User extends Message<User, Builder> {
        public static final ProtoAdapter<User> ADAPTER = null;
        public static final String DEFAULT_TAGS = "";
        public static final String DEFAULT_TENANT_ID = "";
        public static final String DEFAULT_TIMEZONE_ID = "";
        public static final String DEFAULT_USER_ID = "";
        private static final long serialVersionUID = 0;
        public final String tags;
        public final String tenant_id;
        public final String timezone_id;
        public final String user_id;

        public static final class Builder extends Message.Builder<User, Builder> {
            public String tags;
            public String tenant_id;
            public String timezone_id;
            public String user_id;

            @Override // com.squareup.wire.Message.Builder
            public User build() {
                return new User(this.user_id, this.tenant_id, this.tags, this.timezone_id, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder tags(String r100) {
                this.tags = r100;
                return this;
            }

            public Builder tenant_id(String r100) {
                this.tenant_id = r100;
                return this;
            }

            public Builder timezone_id(String r100) {
                this.timezone_id = r100;
                return this;
            }

            public Builder user_id(String r100) {
                this.user_id = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_User extends ProtoAdapter<User> {
            public ProtoAdapter_User() {
                super(FieldEncoding.LENGTH_DELIMITED, User.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public User decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.user_id = "";
                r101.tenant_id = "";
                r101.tags = "";
                r101.timezone_id = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.user_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.tenant_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.tags = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.timezone_id = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(User r100) {
                String r101 = r100.user_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.tenant_id;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.tags;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.timezone_id;
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
            public /* bridge */ /* synthetic */ User decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(User r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, User r101) throws IOException {
                String r102 = r101.user_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.tenant_id;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.tags;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.timezone_id;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, User r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_User();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.user_id = this.user_id;
            r100.tenant_id = this.tenant_id;
            r100.tags = this.tags;
            r100.timezone_id = this.timezone_id;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return User.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public User(String r100, String r101, String r102, String r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public User(String r100, String r101, String r102, String r103, ByteString r104) {
            super(ADAPTER, r104);
            this.user_id = r100;
            this.tenant_id = r101;
            this.tags = r102;
            this.timezone_id = r103;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CalendarEventAttendee();
        FIELD_OPTIONS_USER = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_GROUP = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_RESOURCE = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_THIRD_PARTY_USER = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_PHONE_USER = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        DEFAULT_ORIGINAL_TIME = 0L;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_ORGANIZER = r100;
        DEFAULT_IS_OPTIONAL = r100;
        DEFAULT_STATUS = Status.NEEDS_ACTION;
        DEFAULT_ADDITIONAL_GUESTS_COUNT = 0;
        DEFAULT_IS_EDITABLE = r100;
        DEFAULT_CATEGORY = Category.UNKNOWN_CATEGORY;
        DEFAULT_IS_DIRTY = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253600id = this.f253599id;
        r100.key = this.key;
        r100.original_time = this.original_time;
        r100.display_name = this.display_name;
        r100.attendee_calendar_id = this.attendee_calendar_id;
        r100.is_organizer = this.is_organizer;
        r100.is_optional = this.is_optional;
        r100.status = this.status;
        r100.additional_guests_count = this.additional_guests_count;
        r100.is_editable = this.is_editable;
        r100.inviter_calendar_id = this.inviter_calendar_id;
        r100.avatar_key = this.avatar_key;
        r100.category = this.category;
        r100.avatar_path = this.avatar_path;
        r100.attendee_schema = this.attendee_schema;
        r100.schema_extra_data = this.schema_extra_data;
        r100.is_dirty = this.is_dirty;
        r100.relation_tag = this.relation_tag;
        r100.user = this.user;
        r100.group = this.group;
        r100.resource = this.resource;
        r100.third_party_user = this.third_party_user;
        r100.phone_user = this.phone_user;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CalendarEventAttendee.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CalendarEventAttendee(String r210, String r211, Long r212, String r213, String r310, Boolean r311, Boolean r312, Status r313, Integer r314, Boolean r315, String r316, String r317, Category r318, String r319, CalendarSchemaCollection r410, SchemaExtraData r411, Boolean r412, TagData r413, User r414, Group r415, Resource r416, ThirdPartyUser r417, PhoneUser r418) {
        this(r210, r211, r212, r213, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, ByteString.EMPTY);
    }

    public CalendarEventAttendee(String r110, String r111, Long r112, String r113, String r114, Boolean r115, Boolean r116, Status r117, Integer r118, Boolean r119, String r210, String r211, Category r212, String r213, CalendarSchemaCollection r214, SchemaExtraData r215, Boolean r216, TagData r217, User r218, Group r219, Resource r310, ThirdPartyUser r311, PhoneUser r312, ByteString r313) {
        super(ADAPTER, r313);
        if (Internal.countNonNull(r218, r219, r310, r311, new Object[]{r312}) > 1) goto L7;
        this.f253599id = r110;
        this.key = r111;
        this.original_time = r112;
        this.display_name = r113;
        this.attendee_calendar_id = r114;
        this.is_organizer = r115;
        this.is_optional = r116;
        this.status = r117;
        this.additional_guests_count = r118;
        this.is_editable = r119;
        this.inviter_calendar_id = r210;
        this.avatar_key = r211;
        this.category = r212;
        this.avatar_path = r213;
        this.attendee_schema = r214;
        this.schema_extra_data = r215;
        this.is_dirty = r216;
        this.relation_tag = r217;
        this.user = r218;
        this.group = r219;
        this.resource = r310;
        this.third_party_user = r311;
        this.phone_user = r312;
        return;
    L7:
        throw new IllegalArgumentException("at most one of user, group, resource, third_party_user, phone_user may be non-null");
    }
}
