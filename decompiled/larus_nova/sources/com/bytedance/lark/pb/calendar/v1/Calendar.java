package com.bytedance.lark.pb.calendar.v1;

import com.larus.dora.api.model.FlowDoraWifiScene;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.banner.export.entity.BannerBizName;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class Calendar extends Message<Calendar, Builder> {
    public static final ProtoAdapter<Calendar> ADAPTER = null;
    public static final Integer DEFAULT_BACKGROUND_COLOR = null;
    public static final String DEFAULT_CALENDAR_OWNER_ID = "";
    public static final String DEFAULT_CALENDAR_TENANT_ID = "";
    public static final Long DEFAULT_CREATE_TIME = null;
    public static final AccessRole DEFAULT_DEFAULT_ACCESS_ROLE = null;
    public static final String DEFAULT_DEFAULT_TIMEZONE = "UTC";
    public static final String DEFAULT_DESCRIPTION = "";
    public static final CalendarDirtyType DEFAULT_DIRTY_TYPE = null;
    public static final String DEFAULT_EMAIL = "";
    public static final String DEFAULT_EXTERNAL_ACCOUNT_EMAIL = "";
    public static final Boolean DEFAULT_EXTERNAL_PASSWORD_INVALID = null;
    public static final Integer DEFAULT_FOREGROUND_COLOR = null;
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_ACTIVE = null;
    public static final Boolean DEFAULT_IS_ALL_STAFF = null;
    public static final Boolean DEFAULT_IS_CREATOR_RESIGNED = null;
    public static final Boolean DEFAULT_IS_CROSS_TENANT = null;
    public static final Boolean DEFAULT_IS_DEFAULT = null;
    public static final Boolean DEFAULT_IS_DISABLED = null;
    public static final Boolean DEFAULT_IS_LOADING = null;
    public static final Boolean DEFAULT_IS_PRIMARY = null;
    public static final Boolean DEFAULT_IS_PUBLIC = null;
    public static final Boolean DEFAULT_IS_SUBSCRIBER = null;
    public static final Boolean DEFAULT_IS_SYNCED = null;
    public static final Boolean DEFAULT_IS_VISIBLE = null;
    public static final String DEFAULT_LOCALIZED_SUMMARY = "";
    public static final String DEFAULT_NOTE = "";
    public static final OfficialType DEFAULT_OFFICIAL_TYPE = null;
    public static final Integer DEFAULT_RESOURCE_CAPACITY = null;
    public static final AccessRole DEFAULT_SELF_ACCESS_ROLE = null;
    public static final Status DEFAULT_SELF_STATUS = null;
    public static final String DEFAULT_SERVER_ID = "";
    public static final Source DEFAULT_SOURCE = null;
    public static final String DEFAULT_SUCCESSOR_CHATTER_ID = "";
    public static final String DEFAULT_SUMMARY = "";
    public static final String DEFAULT_TIMEZONE = "";
    public static final Type DEFAULT_TYPE = null;
    public static final Long DEFAULT_UPDATE_TIME = null;
    public static final String DEFAULT_USER_ID = "";
    public static final Integer DEFAULT_VISIBILITY_PROPERTY = null;
    public static final Integer DEFAULT_WEIGHT = null;
    private static final long serialVersionUID = 0;
    public final CalendarAuthInfo auth_info;
    public final Integer background_color;
    public final MappingColor cal_color;
    public final CalendarSchemaCollection calendar_event_schema;
    public final String calendar_owner_id;
    public final CalendarSchemaCollection calendar_schema;
    public final CalendarSyncInfo calendar_sync_info;
    public final String calendar_tenant_id;
    public final CalendarCoverImageSet cover_image_set;
    public final Long create_time;
    public final AccessRole default_access_role;
    public final List<CalendarEventReminder> default_reminders;
    public final String default_timezone;
    public final String description;
    public final CalendarDirtyType dirty_type;
    public final String email;
    public final String external_account_email;
    public final Boolean external_password_invalid;
    public final Integer foreground_color;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253595id;
    public final Boolean is_active;
    public final Boolean is_all_staff;
    public final Boolean is_creator_resigned;
    public final Boolean is_cross_tenant;
    public final Boolean is_default;
    public final Boolean is_disabled;
    public final Boolean is_loading;
    public final Boolean is_primary;
    public final Boolean is_public;
    public final Boolean is_subscriber;
    public final Boolean is_synced;
    public final Boolean is_visible;
    public final String localized_summary;
    public final String note;
    public final OfficialType official_type;
    public final CalendarMember owner;
    public final CalendarPersonalizationSettings personalization_settings;
    public final Integer resource_capacity;
    public final SchemaExtraData schema_extra_data;
    public final AccessRole self_access_role;
    public final Status self_status;
    public final String server_id;
    public final CalendarShareInfo share_info;
    public final CalendarShareOptions share_options;
    public final Source source;
    public final String successor_chatter_id;
    public final String summary;
    public final String timezone;
    public final Type type;
    public final Long update_time;
    public final String user_id;
    public final Integer visibility_property;
    public final Integer weight;
    public final WorkHourSetting work_hour_setting;

    public static final enum AccessRole extends Enum<AccessRole> implements WireEnum {
        private static final /* synthetic */ AccessRole[] $VALUES = null;
        public static final ProtoAdapter<AccessRole> ADAPTER = null;
        public static final AccessRole FREE_BUSY_READER = null;
        public static final AccessRole OWNER = null;
        public static final AccessRole READER = null;
        public static final AccessRole UNKNOWN_ACCESS_ROLE = null;
        public static final AccessRole WRITER = null;
        private final int value;

        static {
            AccessRole r100 = new AccessRole("UNKNOWN_ACCESS_ROLE", 0, 0);
            UNKNOWN_ACCESS_ROLE = r100;
            AccessRole r101 = new AccessRole("FREE_BUSY_READER", 1, 1);
            FREE_BUSY_READER = r101;
            AccessRole r102 = new AccessRole("READER", 2, 2);
            READER = r102;
            AccessRole r103 = new AccessRole("WRITER", 3, 3);
            WRITER = r103;
            AccessRole r104 = new AccessRole("OWNER", 4, 4);
            OWNER = r104;
            $VALUES = new AccessRole[]{r100, r101, r102, r103, r104};
            ADAPTER = ProtoAdapter.newEnumAdapter(AccessRole.class);
        }

        public static AccessRole[] values() {
            return (AccessRole[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static AccessRole fromValue(int r100) {
            if (r100 == 0) goto L22;
            if (r100 == 1) goto L20;
            if (r100 == 2) goto L18;
            if (r100 == 3) goto L16;
            if (r100 == 4) goto L14;
            return null;
        L14:
            return OWNER;
        L16:
            return WRITER;
        L18:
            return READER;
        L20:
            return FREE_BUSY_READER;
        L22:
            return UNKNOWN_ACCESS_ROLE;
        }

        public static AccessRole valueOf(String r100) {
            return (AccessRole) a.a(AccessRole.class, r100);
        }

        private AccessRole(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Builder extends Message.Builder<Calendar, Builder> {
        public CalendarAuthInfo auth_info;
        public Integer background_color;
        public MappingColor cal_color;
        public CalendarSchemaCollection calendar_event_schema;
        public String calendar_owner_id;
        public CalendarSchemaCollection calendar_schema;
        public CalendarSyncInfo calendar_sync_info;
        public String calendar_tenant_id;
        public CalendarCoverImageSet cover_image_set;
        public Long create_time;
        public AccessRole default_access_role;
        public List<CalendarEventReminder> default_reminders;
        public String default_timezone;
        public String description;
        public CalendarDirtyType dirty_type;
        public String email;
        public String external_account_email;
        public Boolean external_password_invalid;
        public Integer foreground_color;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253596id;
        public Boolean is_active;
        public Boolean is_all_staff;
        public Boolean is_creator_resigned;
        public Boolean is_cross_tenant;
        public Boolean is_default;
        public Boolean is_disabled;
        public Boolean is_loading;
        public Boolean is_primary;
        public Boolean is_public;
        public Boolean is_subscriber;
        public Boolean is_synced;
        public Boolean is_visible;
        public String localized_summary;
        public String note;
        public OfficialType official_type;
        public CalendarMember owner;
        public CalendarPersonalizationSettings personalization_settings;
        public Integer resource_capacity;
        public SchemaExtraData schema_extra_data;
        public AccessRole self_access_role;
        public Status self_status;
        public String server_id;
        public CalendarShareInfo share_info;
        public CalendarShareOptions share_options;
        public Source source;
        public String successor_chatter_id;
        public String summary;
        public String timezone;
        public Type type;
        public Long update_time;
        public String user_id;
        public Integer visibility_property;
        public Integer weight;
        public WorkHourSetting work_hour_setting;

        @Override // com.squareup.wire.Message.Builder
        public Calendar build() {
            String r100 = this.f253596id;
            if (r100 == null) goto L11;
            if (this.server_id == null) goto L11;
            if (this.user_id == null) goto L11;
            return new Calendar(this.f253596id, this.server_id, this.email, this.user_id, this.summary, this.description, this.type, this.default_timezone, this.default_access_role, this.dirty_type, this.foreground_color, this.background_color, this.weight, this.is_default, this.is_synced, this.is_visible, this.is_primary, this.is_public, this.is_subscriber, this.default_reminders, this.create_time, this.update_time, this.self_access_role, this.self_status, this.cal_color, this.source, this.localized_summary, this.note, this.owner, this.resource_capacity, this.is_all_staff, this.is_active, this.is_disabled, this.external_account_email, this.work_hour_setting, this.is_loading, this.visibility_property, this.timezone, this.calendar_event_schema, this.calendar_schema, this.schema_extra_data, this.auth_info, this.successor_chatter_id, this.external_password_invalid, this.share_options, this.share_info, this.is_cross_tenant, this.cover_image_set, this.calendar_owner_id, this.calendar_tenant_id, this.official_type, this.calendar_sync_info, this.personalization_settings, this.is_creator_resigned, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "id", this.server_id, "server_id", this.user_id, "user_id"});
        }

        public Builder() {
            this.default_reminders = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder auth_info(CalendarAuthInfo r100) {
            this.auth_info = r100;
            return this;
        }

        public Builder background_color(Integer r100) {
            this.background_color = r100;
            return this;
        }

        public Builder cal_color(MappingColor r100) {
            this.cal_color = r100;
            return this;
        }

        public Builder calendar_event_schema(CalendarSchemaCollection r100) {
            this.calendar_event_schema = r100;
            return this;
        }

        public Builder calendar_owner_id(String r100) {
            this.calendar_owner_id = r100;
            return this;
        }

        public Builder calendar_schema(CalendarSchemaCollection r100) {
            this.calendar_schema = r100;
            return this;
        }

        public Builder calendar_sync_info(CalendarSyncInfo r100) {
            this.calendar_sync_info = r100;
            return this;
        }

        public Builder calendar_tenant_id(String r100) {
            this.calendar_tenant_id = r100;
            return this;
        }

        public Builder cover_image_set(CalendarCoverImageSet r100) {
            this.cover_image_set = r100;
            return this;
        }

        public Builder create_time(Long r100) {
            this.create_time = r100;
            return this;
        }

        public Builder default_access_role(AccessRole r100) {
            this.default_access_role = r100;
            return this;
        }

        public Builder default_reminders(List<CalendarEventReminder> r100) {
            Internal.checkElementsNotNull(r100);
            this.default_reminders = r100;
            return this;
        }

        public Builder default_timezone(String r100) {
            this.default_timezone = r100;
            return this;
        }

        public Builder description(String r100) {
            this.description = r100;
            return this;
        }

        public Builder dirty_type(CalendarDirtyType r100) {
            this.dirty_type = r100;
            return this;
        }

        public Builder email(String r100) {
            this.email = r100;
            return this;
        }

        public Builder external_account_email(String r100) {
            this.external_account_email = r100;
            return this;
        }

        public Builder external_password_invalid(Boolean r100) {
            this.external_password_invalid = r100;
            return this;
        }

        public Builder foreground_color(Integer r100) {
            this.foreground_color = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253596id = r100;
            return this;
        }

        public Builder is_active(Boolean r100) {
            this.is_active = r100;
            return this;
        }

        public Builder is_all_staff(Boolean r100) {
            this.is_all_staff = r100;
            return this;
        }

        public Builder is_creator_resigned(Boolean r100) {
            this.is_creator_resigned = r100;
            return this;
        }

        public Builder is_cross_tenant(Boolean r100) {
            this.is_cross_tenant = r100;
            return this;
        }

        public Builder is_default(Boolean r100) {
            this.is_default = r100;
            return this;
        }

        public Builder is_disabled(Boolean r100) {
            this.is_disabled = r100;
            return this;
        }

        public Builder is_loading(Boolean r100) {
            this.is_loading = r100;
            return this;
        }

        public Builder is_primary(Boolean r100) {
            this.is_primary = r100;
            return this;
        }

        public Builder is_public(Boolean r100) {
            this.is_public = r100;
            return this;
        }

        public Builder is_subscriber(Boolean r100) {
            this.is_subscriber = r100;
            return this;
        }

        public Builder is_synced(Boolean r100) {
            this.is_synced = r100;
            return this;
        }

        public Builder is_visible(Boolean r100) {
            this.is_visible = r100;
            return this;
        }

        public Builder localized_summary(String r100) {
            this.localized_summary = r100;
            return this;
        }

        public Builder note(String r100) {
            this.note = r100;
            return this;
        }

        public Builder official_type(OfficialType r100) {
            this.official_type = r100;
            return this;
        }

        public Builder owner(CalendarMember r100) {
            this.owner = r100;
            return this;
        }

        public Builder personalization_settings(CalendarPersonalizationSettings r100) {
            this.personalization_settings = r100;
            return this;
        }

        public Builder resource_capacity(Integer r100) {
            this.resource_capacity = r100;
            return this;
        }

        public Builder schema_extra_data(SchemaExtraData r100) {
            this.schema_extra_data = r100;
            return this;
        }

        public Builder self_access_role(AccessRole r100) {
            this.self_access_role = r100;
            return this;
        }

        public Builder self_status(Status r100) {
            this.self_status = r100;
            return this;
        }

        public Builder server_id(String r100) {
            this.server_id = r100;
            return this;
        }

        public Builder share_info(CalendarShareInfo r100) {
            this.share_info = r100;
            return this;
        }

        public Builder share_options(CalendarShareOptions r100) {
            this.share_options = r100;
            return this;
        }

        public Builder source(Source r100) {
            this.source = r100;
            return this;
        }

        public Builder successor_chatter_id(String r100) {
            this.successor_chatter_id = r100;
            return this;
        }

        public Builder summary(String r100) {
            this.summary = r100;
            return this;
        }

        public Builder timezone(String r100) {
            this.timezone = r100;
            return this;
        }

        public Builder type(Type r100) {
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

        public Builder visibility_property(Integer r100) {
            this.visibility_property = r100;
            return this;
        }

        public Builder weight(Integer r100) {
            this.weight = r100;
            return this;
        }

        public Builder work_hour_setting(WorkHourSetting r100) {
            this.work_hour_setting = r100;
            return this;
        }
    }

    public static final class CalendarAuthInfo extends Message<CalendarAuthInfo, Builder> {
        public static final ProtoAdapter<CalendarAuthInfo> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final CalendarEditAuthInfo edit_auth_info;

        public static final class Builder extends Message.Builder<CalendarAuthInfo, Builder> {
            public CalendarEditAuthInfo edit_auth_info;

            @Override // com.squareup.wire.Message.Builder
            public CalendarAuthInfo build() {
                return new CalendarAuthInfo(this.edit_auth_info, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder edit_auth_info(CalendarEditAuthInfo r100) {
                this.edit_auth_info = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_CalendarAuthInfo extends ProtoAdapter<CalendarAuthInfo> {
            public ProtoAdapter_CalendarAuthInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, CalendarAuthInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CalendarAuthInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.edit_auth_info = CalendarEditAuthInfo.ADAPTER.decode(r100);
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
            public int encodedSize2(CalendarAuthInfo r100) {
                CalendarEditAuthInfo r101 = r100.edit_auth_info;
                if (r101 == null) goto L5;
                int r102 = CalendarEditAuthInfo.ADAPTER.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ CalendarAuthInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(CalendarAuthInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, CalendarAuthInfo r101) throws IOException {
                CalendarEditAuthInfo r102 = r101.edit_auth_info;
                if (r102 == null) goto L5;
                CalendarEditAuthInfo.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CalendarAuthInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CalendarAuthInfo();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.edit_auth_info = this.edit_auth_info;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return CalendarAuthInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public CalendarAuthInfo(CalendarEditAuthInfo r100) {
            this(r100, ByteString.EMPTY);
        }

        public CalendarAuthInfo(CalendarEditAuthInfo r100, ByteString r101) {
            super(ADAPTER, r101);
            this.edit_auth_info = r100;
        }
    }

    public static final class CalendarEditAuthInfo extends Message<CalendarEditAuthInfo, Builder> {
        public static final ProtoAdapter<CalendarEditAuthInfo> ADAPTER = null;
        public static final Boolean DEFAULT_IS_COLOR_EDITABLE = null;
        public static final Boolean DEFAULT_IS_COVER_IMAGE_EDITABLE = null;
        public static final Boolean DEFAULT_IS_DELETABLE = null;
        public static final Boolean DEFAULT_IS_DISCRIPTION_EDITABLE = null;
        public static final Boolean DEFAULT_IS_MEMBER_EDITABLE = null;
        public static final Boolean DEFAULT_IS_NOTE_EDITABLE = null;
        public static final Boolean DEFAULT_IS_SUMMARY_EDITABLE = null;
        public static final Boolean DEFAULT_IS_UNSUBSCRIBABLE = null;
        public static final Boolean DEFAULT_IS_VISIBILITY_EDITABLE = null;
        private static final long serialVersionUID = 0;
        public final Boolean is_color_editable;
        public final Boolean is_cover_image_editable;
        public final Boolean is_deletable;
        public final Boolean is_discription_editable;
        public final Boolean is_member_editable;
        public final Boolean is_note_editable;
        public final Boolean is_summary_editable;
        public final Boolean is_unsubscribable;
        public final Boolean is_visibility_editable;

        public static final class Builder extends Message.Builder<CalendarEditAuthInfo, Builder> {
            public Boolean is_color_editable;
            public Boolean is_cover_image_editable;
            public Boolean is_deletable;
            public Boolean is_discription_editable;
            public Boolean is_member_editable;
            public Boolean is_note_editable;
            public Boolean is_summary_editable;
            public Boolean is_unsubscribable;
            public Boolean is_visibility_editable;

            @Override // com.squareup.wire.Message.Builder
            public CalendarEditAuthInfo build() {
                return new CalendarEditAuthInfo(this.is_summary_editable, this.is_note_editable, this.is_visibility_editable, this.is_color_editable, this.is_discription_editable, this.is_member_editable, this.is_unsubscribable, this.is_deletable, this.is_cover_image_editable, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder is_color_editable(Boolean r100) {
                this.is_color_editable = r100;
                return this;
            }

            public Builder is_cover_image_editable(Boolean r100) {
                this.is_cover_image_editable = r100;
                return this;
            }

            public Builder is_deletable(Boolean r100) {
                this.is_deletable = r100;
                return this;
            }

            public Builder is_discription_editable(Boolean r100) {
                this.is_discription_editable = r100;
                return this;
            }

            public Builder is_member_editable(Boolean r100) {
                this.is_member_editable = r100;
                return this;
            }

            public Builder is_note_editable(Boolean r100) {
                this.is_note_editable = r100;
                return this;
            }

            public Builder is_summary_editable(Boolean r100) {
                this.is_summary_editable = r100;
                return this;
            }

            public Builder is_unsubscribable(Boolean r100) {
                this.is_unsubscribable = r100;
                return this;
            }

            public Builder is_visibility_editable(Boolean r100) {
                this.is_visibility_editable = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_CalendarEditAuthInfo extends ProtoAdapter<CalendarEditAuthInfo> {
            public ProtoAdapter_CalendarEditAuthInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, CalendarEditAuthInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CalendarEditAuthInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                Boolean r102 = Boolean.FALSE;
                r101.is_summary_editable = r102;
                r101.is_note_editable = r102;
                r101.is_visibility_editable = r102;
                r101.is_color_editable = r102;
                r101.is_discription_editable = r102;
                r101.is_member_editable = r102;
                r101.is_unsubscribable = r102;
                r101.is_deletable = r102;
                r101.is_cover_image_editable = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L16;
                switch(r104) {
                    case 1: goto L15;
                    case 2: goto L14;
                    case 3: goto L13;
                    case 4: goto L12;
                    case 5: goto L11;
                    case 6: goto L10;
                    case 7: goto L9;
                    case 8: goto L8;
                    case 9: goto L7;
                    default: goto L6;
                };
            L7:
                r101.is_cover_image_editable = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                r101.is_deletable = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L9:
                r101.is_unsubscribable = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L10:
                r101.is_member_editable = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L11:
                r101.is_discription_editable = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L12:
                r101.is_color_editable = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L13:
                r101.is_visibility_editable = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L14:
                r101.is_note_editable = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L15:
                r101.is_summary_editable = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L6:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L16:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(CalendarEditAuthInfo r100) {
                Boolean r101 = r100.is_summary_editable;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L6:
                Boolean r104 = r100.is_note_editable;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Boolean r107 = r100.is_visibility_editable;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                Boolean r110 = r100.is_color_editable;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                Boolean r113 = r100.is_discription_editable;
                if (r113 == null) goto L21;
                int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                Boolean r116 = r100.is_member_editable;
                if (r116 == null) goto L25;
                int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
            L26:
                int r118 = r115 + r117;
                Boolean r119 = r100.is_unsubscribable;
                if (r119 == null) goto L29;
                int r120 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r119);
            L30:
                int r121 = r118 + r120;
                Boolean r122 = r100.is_deletable;
                if (r122 == null) goto L33;
                int r123 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r122);
            L34:
                int r124 = r121 + r123;
                Boolean r125 = r100.is_cover_image_editable;
                if (r125 == null) goto L38;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r125);
            L38:
                return (r124 + r102) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ CalendarEditAuthInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(CalendarEditAuthInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, CalendarEditAuthInfo r101) throws IOException {
                Boolean r102 = r101.is_summary_editable;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                Boolean r103 = r101.is_note_editable;
                if (r103 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
            L8:
                Boolean r104 = r101.is_visibility_editable;
                if (r104 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
            L11:
                Boolean r105 = r101.is_color_editable;
                if (r105 == null) goto L14;
                ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
            L14:
                Boolean r106 = r101.is_discription_editable;
                if (r106 == null) goto L17;
                ProtoAdapter.BOOL.encodeWithTag(r100, 5, r106);
            L17:
                Boolean r107 = r101.is_member_editable;
                if (r107 == null) goto L20;
                ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
            L20:
                Boolean r108 = r101.is_unsubscribable;
                if (r108 == null) goto L23;
                ProtoAdapter.BOOL.encodeWithTag(r100, 7, r108);
            L23:
                Boolean r109 = r101.is_deletable;
                if (r109 == null) goto L26;
                ProtoAdapter.BOOL.encodeWithTag(r100, 8, r109);
            L26:
                Boolean r110 = r101.is_cover_image_editable;
                if (r110 == null) goto L29;
                ProtoAdapter.BOOL.encodeWithTag(r100, 9, r110);
            L29:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CalendarEditAuthInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CalendarEditAuthInfo();
            Boolean r100 = Boolean.FALSE;
            DEFAULT_IS_SUMMARY_EDITABLE = r100;
            DEFAULT_IS_NOTE_EDITABLE = r100;
            DEFAULT_IS_VISIBILITY_EDITABLE = r100;
            DEFAULT_IS_COLOR_EDITABLE = r100;
            DEFAULT_IS_DISCRIPTION_EDITABLE = r100;
            DEFAULT_IS_MEMBER_EDITABLE = r100;
            DEFAULT_IS_UNSUBSCRIBABLE = r100;
            DEFAULT_IS_DELETABLE = r100;
            DEFAULT_IS_COVER_IMAGE_EDITABLE = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.is_summary_editable = this.is_summary_editable;
            r100.is_note_editable = this.is_note_editable;
            r100.is_visibility_editable = this.is_visibility_editable;
            r100.is_color_editable = this.is_color_editable;
            r100.is_discription_editable = this.is_discription_editable;
            r100.is_member_editable = this.is_member_editable;
            r100.is_unsubscribable = this.is_unsubscribable;
            r100.is_deletable = this.is_deletable;
            r100.is_cover_image_editable = this.is_cover_image_editable;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return CalendarEditAuthInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public CalendarEditAuthInfo(Boolean r110, Boolean r111, Boolean r112, Boolean r113, Boolean r114, Boolean r115, Boolean r116, Boolean r117, Boolean r210) {
            this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
        }

        public CalendarEditAuthInfo(Boolean r100, Boolean r101, Boolean r102, Boolean r103, Boolean r104, Boolean r105, Boolean r106, Boolean r107, Boolean r110, ByteString r111) {
            super(ADAPTER, r111);
            this.is_summary_editable = r100;
            this.is_note_editable = r101;
            this.is_visibility_editable = r102;
            this.is_color_editable = r103;
            this.is_discription_editable = r104;
            this.is_member_editable = r105;
            this.is_unsubscribable = r106;
            this.is_deletable = r107;
            this.is_cover_image_editable = r110;
        }
    }

    public static final class CalendarShareInfo extends Message<CalendarShareInfo, Builder> {
        public static final ProtoAdapter<CalendarShareInfo> ADAPTER = null;
        public static final String DEFAULT_SHARE_URL = "";
        public static final Integer DEFAULT_SUBSCRIBER_NUM = null;
        private static final long serialVersionUID = 0;
        public final String share_url;
        public final Integer subscriber_num;

        public static final class Builder extends Message.Builder<CalendarShareInfo, Builder> {
            public String share_url;
            public Integer subscriber_num;

            @Override // com.squareup.wire.Message.Builder
            public CalendarShareInfo build() {
                return new CalendarShareInfo(this.share_url, this.subscriber_num, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder share_url(String r100) {
                this.share_url = r100;
                return this;
            }

            public Builder subscriber_num(Integer r100) {
                this.subscriber_num = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_CalendarShareInfo extends ProtoAdapter<CalendarShareInfo> {
            public ProtoAdapter_CalendarShareInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, CalendarShareInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CalendarShareInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.share_url = "";
                r101.subscriber_num = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.share_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.subscriber_num = ProtoAdapter.INT32.decode(r100);
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(CalendarShareInfo r100) {
                String r101 = r100.share_url;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                Integer r104 = r100.subscriber_num;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ CalendarShareInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(CalendarShareInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, CalendarShareInfo r101) throws IOException {
                String r102 = r101.share_url;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                Integer r103 = r101.subscriber_num;
                if (r103 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CalendarShareInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CalendarShareInfo();
            DEFAULT_SUBSCRIBER_NUM = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.share_url = this.share_url;
            r100.subscriber_num = this.subscriber_num;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return CalendarShareInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public CalendarShareInfo(String r100, Integer r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public CalendarShareInfo(String r100, Integer r101, ByteString r102) {
            super(ADAPTER, r102);
            this.share_url = r100;
            this.subscriber_num = r101;
        }
    }

    public static final class CalendarShareOptions extends Message<CalendarShareOptions, Builder> {
        public static final ProtoAdapter<CalendarShareOptions> ADAPTER = null;
        public static final ShareOption DEFAULT_CROSS_DEFAULT_SHARE_OPTION = null;
        public static final ShareOption DEFAULT_CROSS_TOP_SHARE_OPTION = null;
        public static final ShareOption DEFAULT_DEFAULT_SHARE_OPTION = null;
        private static final long serialVersionUID = 0;
        public final ShareOption cross_default_share_option;
        public final ShareOption cross_top_share_option;
        public final ShareOption default_share_option;

        public static final class Builder extends Message.Builder<CalendarShareOptions, Builder> {
            public ShareOption cross_default_share_option;
            public ShareOption cross_top_share_option;
            public ShareOption default_share_option;

            @Override // com.squareup.wire.Message.Builder
            public CalendarShareOptions build() {
                return new CalendarShareOptions(this.default_share_option, this.cross_default_share_option, this.cross_top_share_option, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder cross_default_share_option(ShareOption r100) {
                this.cross_default_share_option = r100;
                return this;
            }

            public Builder cross_top_share_option(ShareOption r100) {
                this.cross_top_share_option = r100;
                return this;
            }

            public Builder default_share_option(ShareOption r100) {
                this.default_share_option = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_CalendarShareOptions extends ProtoAdapter<CalendarShareOptions> {
            public ProtoAdapter_CalendarShareOptions() {
                super(FieldEncoding.LENGTH_DELIMITED, CalendarShareOptions.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CalendarShareOptions decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                ShareOption r102 = ShareOption.UNKNOWN_SHARE_OPT;
                r101.default_share_option = r102;
                r101.cross_default_share_option = r102;
                r101.cross_top_share_option = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L24;
                if (r104 != 1) goto L8;
                r101.default_share_option = ShareOption.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
            L22:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r104 != 2) goto L10;
                r101.cross_default_share_option = ShareOption.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
            L18:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L10:
                if (r104 != 3) goto L11;
                r101.cross_top_share_option = ShareOption.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L11:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L24:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(CalendarShareOptions r100) {
                ShareOption r101 = r100.default_share_option;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ShareOption.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                ShareOption r104 = r100.cross_default_share_option;
                if (r104 == null) goto L9;
                int r105 = ShareOption.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                ShareOption r107 = r100.cross_top_share_option;
                if (r107 == null) goto L14;
                r102 = ShareOption.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                return (r106 + r102) + r100.unknownFields().size();
            L9:
                r105 = 0;
                goto L10
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ CalendarShareOptions decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(CalendarShareOptions r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, CalendarShareOptions r101) throws IOException {
                ShareOption r102 = r101.default_share_option;
                if (r102 == null) goto L5;
                ShareOption.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                ShareOption r103 = r101.cross_default_share_option;
                if (r103 == null) goto L8;
                ShareOption.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                ShareOption r104 = r101.cross_top_share_option;
                if (r104 == null) goto L11;
                ShareOption.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CalendarShareOptions r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CalendarShareOptions();
            ShareOption r100 = ShareOption.UNKNOWN_SHARE_OPT;
            DEFAULT_DEFAULT_SHARE_OPTION = r100;
            DEFAULT_CROSS_DEFAULT_SHARE_OPTION = r100;
            DEFAULT_CROSS_TOP_SHARE_OPTION = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.default_share_option = this.default_share_option;
            r100.cross_default_share_option = this.cross_default_share_option;
            r100.cross_top_share_option = this.cross_top_share_option;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return CalendarShareOptions.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public CalendarShareOptions(ShareOption r100, ShareOption r101, ShareOption r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public CalendarShareOptions(ShareOption r100, ShareOption r101, ShareOption r102, ByteString r103) {
            super(ADAPTER, r103);
            this.default_share_option = r100;
            this.cross_default_share_option = r101;
            this.cross_top_share_option = r102;
        }
    }

    public static final enum OfficialType extends Enum<OfficialType> implements WireEnum {
        private static final /* synthetic */ OfficialType[] $VALUES = null;
        public static final ProtoAdapter<OfficialType> ADAPTER = null;
        public static final OfficialType BYTEDANCE = null;
        public static final OfficialType NOT_OFFICIAL = null;
        private final int value;

        static {
            OfficialType r100 = new OfficialType("NOT_OFFICIAL", 0, 0);
            NOT_OFFICIAL = r100;
            OfficialType r101 = new OfficialType("BYTEDANCE", 1, 1);
            BYTEDANCE = r101;
            $VALUES = new OfficialType[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(OfficialType.class);
        }

        public static OfficialType[] values() {
            return (OfficialType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static OfficialType fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return BYTEDANCE;
        L10:
            return NOT_OFFICIAL;
        }

        public static OfficialType valueOf(String r100) {
            return (OfficialType) a.a(OfficialType.class, r100);
        }

        private OfficialType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_Calendar extends ProtoAdapter<Calendar> {
        public ProtoAdapter_Calendar() {
            super(FieldEncoding.LENGTH_DELIMITED, Calendar.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Calendar decode(ProtoReader r110) throws IOException {
            Builder r100 = new Builder();
            r100.f253596id = "";
            r100.server_id = "";
            r100.email = "";
            r100.user_id = "";
            r100.summary = "";
            r100.description = "";
            r100.type = Type.PRIMARY;
            r100.default_timezone = "UTC";
            AccessRole r101 = AccessRole.FREE_BUSY_READER;
            r100.default_access_role = r101;
            r100.dirty_type = CalendarDirtyType.NONE_DIRTY_TYPE;
            r100.foreground_color = -1;
            r100.background_color = -1;
            r100.weight = 0;
            Boolean r102 = Boolean.FALSE;
            r100.is_default = r102;
            Boolean r103 = Boolean.TRUE;
            r100.is_synced = r103;
            r100.is_visible = r103;
            r100.is_primary = r102;
            r100.is_public = r102;
            r100.is_subscriber = r102;
            r100.create_time = 0L;
            r100.update_time = 0L;
            r100.self_access_role = r101;
            r100.self_status = Status.DEFAULT;
            r100.source = Source.NORMAL;
            r100.localized_summary = "";
            r100.note = "";
            r100.resource_capacity = 0;
            r100.is_all_staff = r102;
            r100.is_active = r102;
            r100.is_disabled = r102;
            r100.external_account_email = "";
            r100.is_loading = r102;
            r100.visibility_property = 0;
            r100.timezone = "";
            r100.successor_chatter_id = "";
            r100.external_password_invalid = r102;
            r100.is_cross_tenant = r102;
            r100.calendar_owner_id = "";
            r100.calendar_tenant_id = "";
            r100.official_type = OfficialType.NOT_OFFICIAL;
            r100.is_creator_resigned = r102;
            long r104 = r110.beginMessage();
        L3:
            int r105 = r110.nextTag();
            if (r105 == (-1)) goto L82;
            switch(r105) {
                case 1: goto L81;
                case 2: goto L80;
                case 3: goto L79;
                case 4: goto L78;
                case 5: goto L77;
                case 6: goto L76;
                case 7: goto L84;
                case 8: goto L71;
                case 9: goto L90;
                case 10: goto L94;
                case 11: goto L62;
                case 12: goto L61;
                case 13: goto L60;
                case 14: goto L59;
                case 15: goto L58;
                case 16: goto L57;
                case 17: goto L56;
                case 18: goto L55;
                case 19: goto L54;
                case 20: goto L53;
                case 21: goto L52;
                case 22: goto L51;
                case 23: goto L86;
                case 24: goto L88;
                case 25: goto L42;
                case 26: goto L96;
                case 27: goto L37;
                case 28: goto L36;
                case 29: goto L35;
                case 30: goto L34;
                case 31: goto L33;
                case 32: goto L32;
                case 33: goto L31;
                case 34: goto L30;
                case 35: goto L29;
                case 36: goto L28;
                case 37: goto L27;
                case 38: goto L26;
                case 39: goto L25;
                case 40: goto L24;
                case 41: goto L23;
                case 42: goto L22;
                case 43: goto L21;
                case 44: goto L20;
                case 45: goto L19;
                case 46: goto L18;
                case 47: goto L17;
                case 48: goto L16;
                case 49: goto L15;
                case 50: goto L14;
                case 51: goto L92;
                case 52: goto L9;
                case 53: goto L8;
                case 54: goto L7;
                default: goto L6;
            };
        L84:
            r100.type = Type.ADAPTER.decode(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L74
        L74:
            e = move-exception;
            r100.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L86:
            r100.self_access_role = AccessRole.ADAPTER.decode(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L49
        L49:
            e = move-exception;
            r100.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L88:
            r100.self_status = Status.ADAPTER.decode(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L45
        L45:
            e = move-exception;
            r100.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L90:
            r100.default_access_role = AccessRole.ADAPTER.decode(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L69
        L69:
            e = move-exception;
            r100.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L92:
            r100.official_type = OfficialType.ADAPTER.decode(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r100.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L94:
            r100.dirty_type = CalendarDirtyType.ADAPTER.decode(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L65
        L65:
            e = move-exception;
            r100.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L96:
            r100.source = Source.ADAPTER.decode(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L40
        L40:
            e = move-exception;
            r100.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r100.is_creator_resigned = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L8:
            r100.personalization_settings = CalendarPersonalizationSettings.ADAPTER.decode(r110);
            goto L3
        L9:
            r100.calendar_sync_info = CalendarSyncInfo.ADAPTER.decode(r110);
            goto L3
        L14:
            r100.calendar_tenant_id = ProtoAdapter.STRING.decode(r110);
            goto L3
        L15:
            r100.calendar_owner_id = ProtoAdapter.STRING.decode(r110);
            goto L3
        L16:
            r100.cover_image_set = CalendarCoverImageSet.ADAPTER.decode(r110);
            goto L3
        L17:
            r100.is_cross_tenant = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L18:
            r100.share_info = CalendarShareInfo.ADAPTER.decode(r110);
            goto L3
        L19:
            r100.share_options = CalendarShareOptions.ADAPTER.decode(r110);
            goto L3
        L20:
            r100.external_password_invalid = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L21:
            r100.successor_chatter_id = ProtoAdapter.STRING.decode(r110);
            goto L3
        L22:
            r100.auth_info = CalendarAuthInfo.ADAPTER.decode(r110);
            goto L3
        L23:
            r100.schema_extra_data = SchemaExtraData.ADAPTER.decode(r110);
            goto L3
        L24:
            r100.calendar_schema = CalendarSchemaCollection.ADAPTER.decode(r110);
            goto L3
        L25:
            r100.calendar_event_schema = CalendarSchemaCollection.ADAPTER.decode(r110);
            goto L3
        L26:
            r100.timezone = ProtoAdapter.STRING.decode(r110);
            goto L3
        L27:
            r100.visibility_property = ProtoAdapter.INT32.decode(r110);
            goto L3
        L28:
            r100.is_loading = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L29:
            r100.work_hour_setting = WorkHourSetting.ADAPTER.decode(r110);
            goto L3
        L30:
            r100.external_account_email = ProtoAdapter.STRING.decode(r110);
            goto L3
        L31:
            r100.is_disabled = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L32:
            r100.is_active = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L33:
            r100.is_all_staff = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L34:
            r100.resource_capacity = ProtoAdapter.INT32.decode(r110);
            goto L3
        L35:
            r100.owner = CalendarMember.ADAPTER.decode(r110);
            goto L3
        L36:
            r100.note = ProtoAdapter.STRING.decode(r110);
            goto L3
        L37:
            r100.localized_summary = ProtoAdapter.STRING.decode(r110);
            goto L3
        L42:
            r100.cal_color = MappingColor.ADAPTER.decode(r110);
            goto L3
        L51:
            r100.update_time = ProtoAdapter.INT64.decode(r110);
            goto L3
        L52:
            r100.create_time = ProtoAdapter.INT64.decode(r110);
            goto L3
        L53:
            r100.default_reminders.add(CalendarEventReminder.ADAPTER.decode(r110));
            goto L3
        L54:
            r100.is_subscriber = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L55:
            r100.is_public = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L56:
            r100.is_primary = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L57:
            r100.is_visible = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L58:
            r100.is_synced = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L59:
            r100.is_default = ProtoAdapter.BOOL.decode(r110);
            goto L3
        L60:
            r100.weight = ProtoAdapter.INT32.decode(r110);
            goto L3
        L61:
            r100.background_color = ProtoAdapter.INT32.decode(r110);
            goto L3
        L62:
            r100.foreground_color = ProtoAdapter.INT32.decode(r110);
            goto L3
        L71:
            r100.default_timezone = ProtoAdapter.STRING.decode(r110);
            goto L3
        L76:
            r100.description = ProtoAdapter.STRING.decode(r110);
            goto L3
        L77:
            r100.summary = ProtoAdapter.STRING.decode(r110);
            goto L3
        L78:
            r100.user_id = ProtoAdapter.STRING.decode(r110);
            goto L3
        L79:
            r100.email = ProtoAdapter.STRING.decode(r110);
            goto L3
        L80:
            r100.server_id = ProtoAdapter.STRING.decode(r110);
            goto L3
        L81:
            r100.f253596id = ProtoAdapter.STRING.decode(r110);
            goto L3
        L6:
            FieldEncoding r106 = r110.peekFieldEncoding();
            r100.addUnknownField(r105, r106, r106.rawProtoAdapter().decode(r110));
            goto L3
        L82:
            r110.endMessage(r104);
            return r100.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Calendar r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.f253595id) + r101.encodedSizeWithTag(2, r100.server_id);
            String r103 = r100.email;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(3, r103);
        L6:
            int r106 = (r102 + r105) + r101.encodedSizeWithTag(4, r100.user_id);
            String r107 = r100.summary;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(5, r107);
        L10:
            int r109 = r106 + r108;
            String r110 = r100.description;
            if (r110 == null) goto L13;
            int r111 = r101.encodedSizeWithTag(6, r110);
        L14:
            int r112 = r109 + r111;
            Type r113 = r100.type;
            if (r113 == null) goto L17;
            int r114 = Type.ADAPTER.encodedSizeWithTag(7, r113);
        L18:
            int r115 = r112 + r114;
            String r116 = r100.default_timezone;
            if (r116 == null) goto L21;
            int r117 = r101.encodedSizeWithTag(8, r116);
        L22:
            int r118 = r115 + r117;
            AccessRole r119 = r100.default_access_role;
            if (r119 == null) goto L25;
            int r120 = AccessRole.ADAPTER.encodedSizeWithTag(9, r119);
        L26:
            int r121 = r118 + r120;
            CalendarDirtyType r122 = r100.dirty_type;
            if (r122 == null) goto L29;
            int r123 = CalendarDirtyType.ADAPTER.encodedSizeWithTag(10, r122);
        L30:
            int r124 = r121 + r123;
            Integer r125 = r100.foreground_color;
            if (r125 == null) goto L33;
            int r126 = ProtoAdapter.INT32.encodedSizeWithTag(11, r125);
        L34:
            int r127 = r124 + r126;
            Integer r128 = r100.background_color;
            if (r128 == null) goto L37;
            int r129 = ProtoAdapter.INT32.encodedSizeWithTag(12, r128);
        L38:
            int r130 = r127 + r129;
            Integer r131 = r100.weight;
            if (r131 == null) goto L41;
            int r132 = ProtoAdapter.INT32.encodedSizeWithTag(13, r131);
        L42:
            int r133 = r130 + r132;
            Boolean r134 = r100.is_default;
            if (r134 == null) goto L45;
            int r135 = ProtoAdapter.BOOL.encodedSizeWithTag(14, r134);
        L46:
            int r136 = r133 + r135;
            Boolean r137 = r100.is_synced;
            if (r137 == null) goto L49;
            int r138 = ProtoAdapter.BOOL.encodedSizeWithTag(15, r137);
        L50:
            int r139 = r136 + r138;
            Boolean r140 = r100.is_visible;
            if (r140 == null) goto L53;
            int r141 = ProtoAdapter.BOOL.encodedSizeWithTag(16, r140);
        L54:
            int r142 = r139 + r141;
            Boolean r143 = r100.is_primary;
            if (r143 == null) goto L57;
            int r144 = ProtoAdapter.BOOL.encodedSizeWithTag(17, r143);
        L58:
            int r145 = r142 + r144;
            Boolean r146 = r100.is_public;
            if (r146 == null) goto L61;
            int r147 = ProtoAdapter.BOOL.encodedSizeWithTag(18, r146);
        L62:
            int r148 = r145 + r147;
            Boolean r149 = r100.is_subscriber;
            if (r149 == null) goto L65;
            int r150 = ProtoAdapter.BOOL.encodedSizeWithTag(19, r149);
        L66:
            int r151 = (r148 + r150) + CalendarEventReminder.ADAPTER.asRepeated().encodedSizeWithTag(20, r100.default_reminders);
            Long r152 = r100.create_time;
            if (r152 == null) goto L69;
            int r153 = ProtoAdapter.INT64.encodedSizeWithTag(21, r152);
        L70:
            int r154 = r151 + r153;
            Long r155 = r100.update_time;
            if (r155 == null) goto L73;
            int r156 = ProtoAdapter.INT64.encodedSizeWithTag(22, r155);
        L74:
            int r157 = r154 + r156;
            AccessRole r158 = r100.self_access_role;
            if (r158 == null) goto L77;
            int r159 = AccessRole.ADAPTER.encodedSizeWithTag(23, r158);
        L78:
            int r160 = r157 + r159;
            Status r161 = r100.self_status;
            if (r161 == null) goto L81;
            int r162 = Status.ADAPTER.encodedSizeWithTag(24, r161);
        L82:
            int r163 = r160 + r162;
            MappingColor r164 = r100.cal_color;
            if (r164 == null) goto L85;
            int r165 = MappingColor.ADAPTER.encodedSizeWithTag(25, r164);
        L86:
            int r166 = r163 + r165;
            Source r167 = r100.source;
            if (r167 == null) goto L89;
            int r168 = Source.ADAPTER.encodedSizeWithTag(26, r167);
        L90:
            int r169 = r166 + r168;
            String r170 = r100.localized_summary;
            if (r170 == null) goto L93;
            int r171 = r101.encodedSizeWithTag(27, r170);
        L94:
            int r172 = r169 + r171;
            String r173 = r100.note;
            if (r173 == null) goto L97;
            int r174 = r101.encodedSizeWithTag(28, r173);
        L98:
            int r175 = r172 + r174;
            CalendarMember r176 = r100.owner;
            if (r176 == null) goto L101;
            int r177 = CalendarMember.ADAPTER.encodedSizeWithTag(29, r176);
        L102:
            int r178 = r175 + r177;
            Integer r179 = r100.resource_capacity;
            if (r179 == null) goto L105;
            int r180 = ProtoAdapter.INT32.encodedSizeWithTag(30, r179);
        L106:
            int r181 = r178 + r180;
            Boolean r182 = r100.is_all_staff;
            if (r182 == null) goto L109;
            int r183 = ProtoAdapter.BOOL.encodedSizeWithTag(31, r182);
        L110:
            int r184 = r181 + r183;
            Boolean r185 = r100.is_active;
            if (r185 == null) goto L113;
            int r186 = ProtoAdapter.BOOL.encodedSizeWithTag(32, r185);
        L114:
            int r187 = r184 + r186;
            Boolean r188 = r100.is_disabled;
            if (r188 == null) goto L117;
            int r189 = ProtoAdapter.BOOL.encodedSizeWithTag(33, r188);
        L118:
            int r190 = r187 + r189;
            String r191 = r100.external_account_email;
            if (r191 == null) goto L121;
            int r192 = r101.encodedSizeWithTag(34, r191);
        L122:
            int r193 = r190 + r192;
            WorkHourSetting r194 = r100.work_hour_setting;
            if (r194 == null) goto L125;
            int r195 = WorkHourSetting.ADAPTER.encodedSizeWithTag(35, r194);
        L126:
            int r196 = r193 + r195;
            Boolean r197 = r100.is_loading;
            if (r197 == null) goto L129;
            int r198 = ProtoAdapter.BOOL.encodedSizeWithTag(36, r197);
        L130:
            int r199 = r196 + r198;
            Integer r200 = r100.visibility_property;
            if (r200 == null) goto L133;
            int r201 = ProtoAdapter.INT32.encodedSizeWithTag(37, r200);
        L134:
            int r202 = r199 + r201;
            String r203 = r100.timezone;
            if (r203 == null) goto L137;
            int r204 = r101.encodedSizeWithTag(38, r203);
        L138:
            int r205 = r202 + r204;
            CalendarSchemaCollection r206 = r100.calendar_event_schema;
            if (r206 == null) goto L141;
            int r207 = CalendarSchemaCollection.ADAPTER.encodedSizeWithTag(39, r206);
        L142:
            int r208 = r205 + r207;
            CalendarSchemaCollection r209 = r100.calendar_schema;
            if (r209 == null) goto L145;
            int r210 = CalendarSchemaCollection.ADAPTER.encodedSizeWithTag(40, r209);
        L146:
            int r211 = r208 + r210;
            SchemaExtraData r212 = r100.schema_extra_data;
            if (r212 == null) goto L149;
            int r213 = SchemaExtraData.ADAPTER.encodedSizeWithTag(41, r212);
        L150:
            int r214 = r211 + r213;
            CalendarAuthInfo r215 = r100.auth_info;
            if (r215 == null) goto L153;
            int r216 = CalendarAuthInfo.ADAPTER.encodedSizeWithTag(42, r215);
        L154:
            int r217 = r214 + r216;
            String r218 = r100.successor_chatter_id;
            if (r218 == null) goto L157;
            int r219 = r101.encodedSizeWithTag(43, r218);
        L158:
            int r220 = r217 + r219;
            Boolean r221 = r100.external_password_invalid;
            if (r221 == null) goto L161;
            int r222 = ProtoAdapter.BOOL.encodedSizeWithTag(44, r221);
        L162:
            int r223 = r220 + r222;
            CalendarShareOptions r224 = r100.share_options;
            if (r224 == null) goto L165;
            int r225 = CalendarShareOptions.ADAPTER.encodedSizeWithTag(45, r224);
        L166:
            int r226 = r223 + r225;
            CalendarShareInfo r227 = r100.share_info;
            if (r227 == null) goto L169;
            int r228 = CalendarShareInfo.ADAPTER.encodedSizeWithTag(46, r227);
        L170:
            int r229 = r226 + r228;
            Boolean r230 = r100.is_cross_tenant;
            if (r230 == null) goto L173;
            int r231 = ProtoAdapter.BOOL.encodedSizeWithTag(47, r230);
        L174:
            int r232 = r229 + r231;
            CalendarCoverImageSet r233 = r100.cover_image_set;
            if (r233 == null) goto L177;
            int r234 = CalendarCoverImageSet.ADAPTER.encodedSizeWithTag(48, r233);
        L178:
            int r235 = r232 + r234;
            String r236 = r100.calendar_owner_id;
            if (r236 == null) goto L181;
            int r237 = r101.encodedSizeWithTag(49, r236);
        L182:
            int r238 = r235 + r237;
            String r239 = r100.calendar_tenant_id;
            if (r239 == null) goto L185;
            int r240 = r101.encodedSizeWithTag(50, r239);
        L186:
            int r241 = r238 + r240;
            OfficialType r242 = r100.official_type;
            if (r242 == null) goto L189;
            int r243 = OfficialType.ADAPTER.encodedSizeWithTag(51, r242);
        L190:
            int r244 = r241 + r243;
            CalendarSyncInfo r245 = r100.calendar_sync_info;
            if (r245 == null) goto L193;
            int r246 = CalendarSyncInfo.ADAPTER.encodedSizeWithTag(52, r245);
        L194:
            int r247 = r244 + r246;
            CalendarPersonalizationSettings r248 = r100.personalization_settings;
            if (r248 == null) goto L197;
            int r249 = CalendarPersonalizationSettings.ADAPTER.encodedSizeWithTag(53, r248);
        L198:
            int r250 = r247 + r249;
            Boolean r251 = r100.is_creator_resigned;
            if (r251 == null) goto L202;
            r104 = ProtoAdapter.BOOL.encodedSizeWithTag(54, r251);
        L202:
            return (r250 + r104) + r100.unknownFields().size();
        L197:
            r249 = 0;
            goto L198
        L193:
            r246 = 0;
            goto L194
        L189:
            r243 = 0;
            goto L190
        L185:
            r240 = 0;
            goto L186
        L181:
            r237 = 0;
            goto L182
        L177:
            r234 = 0;
            goto L178
        L173:
            r231 = 0;
            goto L174
        L169:
            r228 = 0;
            goto L170
        L165:
            r225 = 0;
            goto L166
        L161:
            r222 = 0;
            goto L162
        L157:
            r219 = 0;
            goto L158
        L153:
            r216 = 0;
            goto L154
        L149:
            r213 = 0;
            goto L150
        L145:
            r210 = 0;
            goto L146
        L141:
            r207 = 0;
            goto L142
        L137:
            r204 = 0;
            goto L138
        L133:
            r201 = 0;
            goto L134
        L129:
            r198 = 0;
            goto L130
        L125:
            r195 = 0;
            goto L126
        L121:
            r192 = 0;
            goto L122
        L117:
            r189 = 0;
            goto L118
        L113:
            r186 = 0;
            goto L114
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
        public /* bridge */ /* synthetic */ Calendar decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Calendar r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Calendar r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.f253595id);
            r102.encodeWithTag(r100, 2, r101.server_id);
            String r103 = r101.email;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 3, r103);
        L5:
            r102.encodeWithTag(r100, 4, r101.user_id);
            String r104 = r101.summary;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 5, r104);
        L8:
            String r105 = r101.description;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 6, r105);
        L11:
            Type r106 = r101.type;
            if (r106 == null) goto L14;
            Type.ADAPTER.encodeWithTag(r100, 7, r106);
        L14:
            String r107 = r101.default_timezone;
            if (r107 == null) goto L17;
            r102.encodeWithTag(r100, 8, r107);
        L17:
            AccessRole r108 = r101.default_access_role;
            if (r108 == null) goto L20;
            AccessRole.ADAPTER.encodeWithTag(r100, 9, r108);
        L20:
            CalendarDirtyType r109 = r101.dirty_type;
            if (r109 == null) goto L23;
            CalendarDirtyType.ADAPTER.encodeWithTag(r100, 10, r109);
        L23:
            Integer r110 = r101.foreground_color;
            if (r110 == null) goto L26;
            ProtoAdapter.INT32.encodeWithTag(r100, 11, r110);
        L26:
            Integer r111 = r101.background_color;
            if (r111 == null) goto L29;
            ProtoAdapter.INT32.encodeWithTag(r100, 12, r111);
        L29:
            Integer r112 = r101.weight;
            if (r112 == null) goto L32;
            ProtoAdapter.INT32.encodeWithTag(r100, 13, r112);
        L32:
            Boolean r113 = r101.is_default;
            if (r113 == null) goto L35;
            ProtoAdapter.BOOL.encodeWithTag(r100, 14, r113);
        L35:
            Boolean r114 = r101.is_synced;
            if (r114 == null) goto L38;
            ProtoAdapter.BOOL.encodeWithTag(r100, 15, r114);
        L38:
            Boolean r115 = r101.is_visible;
            if (r115 == null) goto L41;
            ProtoAdapter.BOOL.encodeWithTag(r100, 16, r115);
        L41:
            Boolean r116 = r101.is_primary;
            if (r116 == null) goto L44;
            ProtoAdapter.BOOL.encodeWithTag(r100, 17, r116);
        L44:
            Boolean r117 = r101.is_public;
            if (r117 == null) goto L47;
            ProtoAdapter.BOOL.encodeWithTag(r100, 18, r117);
        L47:
            Boolean r118 = r101.is_subscriber;
            if (r118 == null) goto L50;
            ProtoAdapter.BOOL.encodeWithTag(r100, 19, r118);
        L50:
            CalendarEventReminder.ADAPTER.asRepeated().encodeWithTag(r100, 20, r101.default_reminders);
            Long r119 = r101.create_time;
            if (r119 == null) goto L53;
            ProtoAdapter.INT64.encodeWithTag(r100, 21, r119);
        L53:
            Long r120 = r101.update_time;
            if (r120 == null) goto L56;
            ProtoAdapter.INT64.encodeWithTag(r100, 22, r120);
        L56:
            AccessRole r121 = r101.self_access_role;
            if (r121 == null) goto L59;
            AccessRole.ADAPTER.encodeWithTag(r100, 23, r121);
        L59:
            Status r122 = r101.self_status;
            if (r122 == null) goto L62;
            Status.ADAPTER.encodeWithTag(r100, 24, r122);
        L62:
            MappingColor r123 = r101.cal_color;
            if (r123 == null) goto L65;
            MappingColor.ADAPTER.encodeWithTag(r100, 25, r123);
        L65:
            Source r124 = r101.source;
            if (r124 == null) goto L68;
            Source.ADAPTER.encodeWithTag(r100, 26, r124);
        L68:
            String r125 = r101.localized_summary;
            if (r125 == null) goto L71;
            r102.encodeWithTag(r100, 27, r125);
        L71:
            String r126 = r101.note;
            if (r126 == null) goto L74;
            r102.encodeWithTag(r100, 28, r126);
        L74:
            CalendarMember r127 = r101.owner;
            if (r127 == null) goto L77;
            CalendarMember.ADAPTER.encodeWithTag(r100, 29, r127);
        L77:
            Integer r128 = r101.resource_capacity;
            if (r128 == null) goto L80;
            ProtoAdapter.INT32.encodeWithTag(r100, 30, r128);
        L80:
            Boolean r129 = r101.is_all_staff;
            if (r129 == null) goto L83;
            ProtoAdapter.BOOL.encodeWithTag(r100, 31, r129);
        L83:
            Boolean r130 = r101.is_active;
            if (r130 == null) goto L86;
            ProtoAdapter.BOOL.encodeWithTag(r100, 32, r130);
        L86:
            Boolean r131 = r101.is_disabled;
            if (r131 == null) goto L89;
            ProtoAdapter.BOOL.encodeWithTag(r100, 33, r131);
        L89:
            String r132 = r101.external_account_email;
            if (r132 == null) goto L92;
            r102.encodeWithTag(r100, 34, r132);
        L92:
            WorkHourSetting r133 = r101.work_hour_setting;
            if (r133 == null) goto L95;
            WorkHourSetting.ADAPTER.encodeWithTag(r100, 35, r133);
        L95:
            Boolean r134 = r101.is_loading;
            if (r134 == null) goto L98;
            ProtoAdapter.BOOL.encodeWithTag(r100, 36, r134);
        L98:
            Integer r135 = r101.visibility_property;
            if (r135 == null) goto L101;
            ProtoAdapter.INT32.encodeWithTag(r100, 37, r135);
        L101:
            String r136 = r101.timezone;
            if (r136 == null) goto L104;
            r102.encodeWithTag(r100, 38, r136);
        L104:
            CalendarSchemaCollection r137 = r101.calendar_event_schema;
            if (r137 == null) goto L107;
            CalendarSchemaCollection.ADAPTER.encodeWithTag(r100, 39, r137);
        L107:
            CalendarSchemaCollection r138 = r101.calendar_schema;
            if (r138 == null) goto L110;
            CalendarSchemaCollection.ADAPTER.encodeWithTag(r100, 40, r138);
        L110:
            SchemaExtraData r139 = r101.schema_extra_data;
            if (r139 == null) goto L113;
            SchemaExtraData.ADAPTER.encodeWithTag(r100, 41, r139);
        L113:
            CalendarAuthInfo r140 = r101.auth_info;
            if (r140 == null) goto L116;
            CalendarAuthInfo.ADAPTER.encodeWithTag(r100, 42, r140);
        L116:
            String r141 = r101.successor_chatter_id;
            if (r141 == null) goto L119;
            r102.encodeWithTag(r100, 43, r141);
        L119:
            Boolean r142 = r101.external_password_invalid;
            if (r142 == null) goto L122;
            ProtoAdapter.BOOL.encodeWithTag(r100, 44, r142);
        L122:
            CalendarShareOptions r143 = r101.share_options;
            if (r143 == null) goto L125;
            CalendarShareOptions.ADAPTER.encodeWithTag(r100, 45, r143);
        L125:
            CalendarShareInfo r144 = r101.share_info;
            if (r144 == null) goto L128;
            CalendarShareInfo.ADAPTER.encodeWithTag(r100, 46, r144);
        L128:
            Boolean r145 = r101.is_cross_tenant;
            if (r145 == null) goto L131;
            ProtoAdapter.BOOL.encodeWithTag(r100, 47, r145);
        L131:
            CalendarCoverImageSet r146 = r101.cover_image_set;
            if (r146 == null) goto L134;
            CalendarCoverImageSet.ADAPTER.encodeWithTag(r100, 48, r146);
        L134:
            String r147 = r101.calendar_owner_id;
            if (r147 == null) goto L137;
            r102.encodeWithTag(r100, 49, r147);
        L137:
            String r148 = r101.calendar_tenant_id;
            if (r148 == null) goto L140;
            r102.encodeWithTag(r100, 50, r148);
        L140:
            OfficialType r149 = r101.official_type;
            if (r149 == null) goto L143;
            OfficialType.ADAPTER.encodeWithTag(r100, 51, r149);
        L143:
            CalendarSyncInfo r150 = r101.calendar_sync_info;
            if (r150 == null) goto L146;
            CalendarSyncInfo.ADAPTER.encodeWithTag(r100, 52, r150);
        L146:
            CalendarPersonalizationSettings r151 = r101.personalization_settings;
            if (r151 == null) goto L149;
            CalendarPersonalizationSettings.ADAPTER.encodeWithTag(r100, 53, r151);
        L149:
            Boolean r152 = r101.is_creator_resigned;
            if (r152 == null) goto L152;
            ProtoAdapter.BOOL.encodeWithTag(r100, 54, r152);
        L152:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Calendar r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum ShareOption extends Enum<ShareOption> implements WireEnum {
        private static final /* synthetic */ ShareOption[] $VALUES = null;
        public static final ProtoAdapter<ShareOption> ADAPTER = null;
        public static final ShareOption SHARE_OPT_FREE_BUSY_READER = null;
        public static final ShareOption SHARE_OPT_OWNER = null;
        public static final ShareOption SHARE_OPT_PRIVATE = null;
        public static final ShareOption SHARE_OPT_READER = null;
        public static final ShareOption SHARE_OPT_WRITER = null;
        public static final ShareOption UNKNOWN_SHARE_OPT = null;
        private final int value;

        static {
            ShareOption r100 = new ShareOption("UNKNOWN_SHARE_OPT", 0, 0);
            UNKNOWN_SHARE_OPT = r100;
            ShareOption r101 = new ShareOption("SHARE_OPT_PRIVATE", 1, 5);
            SHARE_OPT_PRIVATE = r101;
            ShareOption r102 = new ShareOption("SHARE_OPT_FREE_BUSY_READER", 2, 10);
            SHARE_OPT_FREE_BUSY_READER = r102;
            ShareOption r103 = new ShareOption("SHARE_OPT_READER", 3, 15);
            SHARE_OPT_READER = r103;
            ShareOption r104 = new ShareOption("SHARE_OPT_WRITER", 4, 20);
            SHARE_OPT_WRITER = r104;
            ShareOption r105 = new ShareOption("SHARE_OPT_OWNER", 5, 25);
            SHARE_OPT_OWNER = r105;
            $VALUES = new ShareOption[]{r100, r101, r102, r103, r104, r105};
            ADAPTER = ProtoAdapter.newEnumAdapter(ShareOption.class);
        }

        public static ShareOption[] values() {
            return (ShareOption[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ShareOption fromValue(int r100) {
            if (r100 == 0) goto L26;
            if (r100 == 5) goto L24;
            if (r100 == 10) goto L22;
            if (r100 == 15) goto L20;
            if (r100 == 20) goto L18;
            if (r100 == 25) goto L16;
            return null;
        L16:
            return SHARE_OPT_OWNER;
        L18:
            return SHARE_OPT_WRITER;
        L20:
            return SHARE_OPT_READER;
        L22:
            return SHARE_OPT_FREE_BUSY_READER;
        L24:
            return SHARE_OPT_PRIVATE;
        L26:
            return UNKNOWN_SHARE_OPT;
        }

        public static ShareOption valueOf(String r100) {
            return (ShareOption) a.a(ShareOption.class, r100);
        }

        private ShareOption(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum Source extends Enum<Source> implements WireEnum {
        private static final /* synthetic */ Source[] $VALUES = null;
        public static final ProtoAdapter<Source> ADAPTER = null;
        public static final Source MEETING_ROOM_VIEW = null;
        public static final Source NORMAL = null;
        public static final Source NORMAL_AND_MEETING_ROOM_VIEW = null;
        private final int value;

        static {
            Source r100 = new Source(EffectConstants.NORMAL, 0, 1);
            NORMAL = r100;
            Source r101 = new Source("MEETING_ROOM_VIEW", 1, 2);
            MEETING_ROOM_VIEW = r101;
            Source r102 = new Source("NORMAL_AND_MEETING_ROOM_VIEW", 2, 3);
            NORMAL_AND_MEETING_ROOM_VIEW = r102;
            $VALUES = new Source[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(Source.class);
        }

        public static Source[] values() {
            return (Source[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Source fromValue(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return null;
        L11:
            return NORMAL_AND_MEETING_ROOM_VIEW;
        L13:
            return MEETING_ROOM_VIEW;
        L15:
            return NORMAL;
        }

        public static Source valueOf(String r100) {
            return (Source) a.a(Source.class, r100);
        }

        private Source(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum Status extends Enum<Status> implements WireEnum {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final Status ACCEPTED = null;
        public static final ProtoAdapter<Status> ADAPTER = null;
        public static final Status DECLINED = null;
        public static final Status DEFAULT = null;
        public static final Status INVITED = null;
        public static final Status REMOVED = null;
        private final int value;

        static {
            Status r100 = new Status("DEFAULT", 0, 1);
            DEFAULT = r100;
            Status r101 = new Status("ACCEPTED", 1, 2);
            ACCEPTED = r101;
            Status r102 = new Status("DECLINED", 2, 3);
            DECLINED = r102;
            Status r103 = new Status("INVITED", 3, 4);
            INVITED = r103;
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
            return INVITED;
        L19:
            return DECLINED;
        L21:
            return ACCEPTED;
        L23:
            return DEFAULT;
        }

        public static Status valueOf(String r100) {
            return (Status) a.a(Status.class, r100);
        }

        private Status(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type ACTIVITY = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type EXCHANGE = null;
        public static final Type GOOGLE = null;
        public static final Type GOOGLE_RESOURCE = null;
        public static final Type OTHER = null;
        public static final Type PHONE = null;
        public static final Type PRIMARY = null;
        public static final Type RESOURCES = null;
        public static final Type UNKNOWN_TYPE = null;
        private final int value;

        static {
            Type r100 = new Type("UNKNOWN_TYPE", 0, 0);
            UNKNOWN_TYPE = r100;
            Type r101 = new Type("PRIMARY", 1, 1);
            PRIMARY = r101;
            Type r102 = new Type(FlowDoraWifiScene.OTHER, 2, 2);
            OTHER = r102;
            Type r103 = new Type("GOOGLE", 3, 3);
            GOOGLE = r103;
            Type r104 = new Type("RESOURCES", 4, 4);
            RESOURCES = r104;
            Type r105 = new Type("GOOGLE_RESOURCE", 5, 5);
            GOOGLE_RESOURCE = r105;
            Type r110 = new Type("EXCHANGE", 6, 8);
            EXCHANGE = r110;
            Type r111 = new Type(BannerBizName.ACTIVITY, 7, 9);
            ACTIVITY = r111;
            Type r112 = new Type("PHONE", 8, 10);
            PHONE = r112;
            $VALUES = new Type[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
            ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Type fromValue(int r100) {
            switch(r100) {
                case 0: goto L22;
                case 1: goto L20;
                case 2: goto L18;
                case 3: goto L16;
                case 4: goto L14;
                case 5: goto L12;
                case 6: goto L3;
                case 7: goto L3;
                case 8: goto L10;
                case 9: goto L8;
                case 10: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return PHONE;
        L8:
            return ACTIVITY;
        L10:
            return EXCHANGE;
        L12:
            return GOOGLE_RESOURCE;
        L14:
            return RESOURCES;
        L16:
            return GOOGLE;
        L18:
            return OTHER;
        L20:
            return PRIMARY;
        L22:
            return UNKNOWN_TYPE;
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        private Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum VisibilityProperty extends Enum<VisibilityProperty> implements WireEnum {
        private static final /* synthetic */ VisibilityProperty[] $VALUES = null;
        public static final ProtoAdapter<VisibilityProperty> ADAPTER = null;
        public static final VisibilityProperty MEETING_VIEW = null;
        public static final VisibilityProperty NONE_VIEW = null;
        public static final VisibilityProperty NORMAL_VIEW = null;
        public static final VisibilityProperty TODAY_FEED_VIEW = null;
        public final Boolean deprecated;
        private final int value;

        static {
            VisibilityProperty r100 = new VisibilityProperty("NONE_VIEW", 0, 0, null);
            NONE_VIEW = r100;
            VisibilityProperty r101 = new VisibilityProperty("NORMAL_VIEW", 1, 1, null);
            NORMAL_VIEW = r101;
            VisibilityProperty r102 = new VisibilityProperty("MEETING_VIEW", 2, 2, Boolean.TRUE);
            MEETING_VIEW = r102;
            VisibilityProperty r103 = new VisibilityProperty("TODAY_FEED_VIEW", 3, 4, null);
            TODAY_FEED_VIEW = r103;
            $VALUES = new VisibilityProperty[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(VisibilityProperty.class);
        }

        public static VisibilityProperty[] values() {
            return (VisibilityProperty[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static VisibilityProperty fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 4) goto L12;
            return null;
        L12:
            return TODAY_FEED_VIEW;
        L14:
            return MEETING_VIEW;
        L16:
            return NORMAL_VIEW;
        L18:
            return NONE_VIEW;
        }

        public static VisibilityProperty valueOf(String r100) {
            return (VisibilityProperty) a.a(VisibilityProperty.class, r100);
        }

        private VisibilityProperty(String r100, int r101, int r102, Boolean r103) {
            super(r100, r101);
            this.value = r102;
            this.deprecated = r103;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Calendar();
        DEFAULT_TYPE = Type.PRIMARY;
        AccessRole r100 = AccessRole.FREE_BUSY_READER;
        DEFAULT_DEFAULT_ACCESS_ROLE = r100;
        DEFAULT_DIRTY_TYPE = CalendarDirtyType.NONE_DIRTY_TYPE;
        DEFAULT_FOREGROUND_COLOR = -1;
        DEFAULT_BACKGROUND_COLOR = -1;
        DEFAULT_WEIGHT = 0;
        Boolean r101 = Boolean.FALSE;
        DEFAULT_IS_DEFAULT = r101;
        Boolean r102 = Boolean.TRUE;
        DEFAULT_IS_SYNCED = r102;
        DEFAULT_IS_VISIBLE = r102;
        DEFAULT_IS_PRIMARY = r101;
        DEFAULT_IS_PUBLIC = r101;
        DEFAULT_IS_SUBSCRIBER = r101;
        DEFAULT_CREATE_TIME = 0L;
        DEFAULT_UPDATE_TIME = 0L;
        DEFAULT_SELF_ACCESS_ROLE = r100;
        DEFAULT_SELF_STATUS = Status.DEFAULT;
        DEFAULT_SOURCE = Source.NORMAL;
        DEFAULT_RESOURCE_CAPACITY = 0;
        DEFAULT_IS_ALL_STAFF = r101;
        DEFAULT_IS_ACTIVE = r101;
        DEFAULT_IS_DISABLED = r101;
        DEFAULT_IS_LOADING = r101;
        DEFAULT_VISIBILITY_PROPERTY = 0;
        DEFAULT_EXTERNAL_PASSWORD_INVALID = r101;
        DEFAULT_IS_CROSS_TENANT = r101;
        DEFAULT_OFFICIAL_TYPE = OfficialType.NOT_OFFICIAL;
        DEFAULT_IS_CREATOR_RESIGNED = r101;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253596id = this.f253595id;
        r100.server_id = this.server_id;
        r100.email = this.email;
        r100.user_id = this.user_id;
        r100.summary = this.summary;
        r100.description = this.description;
        r100.type = this.type;
        r100.default_timezone = this.default_timezone;
        r100.default_access_role = this.default_access_role;
        r100.dirty_type = this.dirty_type;
        r100.foreground_color = this.foreground_color;
        r100.background_color = this.background_color;
        r100.weight = this.weight;
        r100.is_default = this.is_default;
        r100.is_synced = this.is_synced;
        r100.is_visible = this.is_visible;
        r100.is_primary = this.is_primary;
        r100.is_public = this.is_public;
        r100.is_subscriber = this.is_subscriber;
        r100.default_reminders = Internal.copyOf("default_reminders", this.default_reminders);
        r100.create_time = this.create_time;
        r100.update_time = this.update_time;
        r100.self_access_role = this.self_access_role;
        r100.self_status = this.self_status;
        r100.cal_color = this.cal_color;
        r100.source = this.source;
        r100.localized_summary = this.localized_summary;
        r100.note = this.note;
        r100.owner = this.owner;
        r100.resource_capacity = this.resource_capacity;
        r100.is_all_staff = this.is_all_staff;
        r100.is_active = this.is_active;
        r100.is_disabled = this.is_disabled;
        r100.external_account_email = this.external_account_email;
        r100.work_hour_setting = this.work_hour_setting;
        r100.is_loading = this.is_loading;
        r100.visibility_property = this.visibility_property;
        r100.timezone = this.timezone;
        r100.calendar_event_schema = this.calendar_event_schema;
        r100.calendar_schema = this.calendar_schema;
        r100.schema_extra_data = this.schema_extra_data;
        r100.auth_info = this.auth_info;
        r100.successor_chatter_id = this.successor_chatter_id;
        r100.external_password_invalid = this.external_password_invalid;
        r100.share_options = this.share_options;
        r100.share_info = this.share_info;
        r100.is_cross_tenant = this.is_cross_tenant;
        r100.cover_image_set = this.cover_image_set;
        r100.calendar_owner_id = this.calendar_owner_id;
        r100.calendar_tenant_id = this.calendar_tenant_id;
        r100.official_type = this.official_type;
        r100.calendar_sync_info = this.calendar_sync_info;
        r100.personalization_settings = this.personalization_settings;
        r100.is_creator_resigned = this.is_creator_resigned;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Calendar.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public Calendar(String r510, String r511, String r512, String r610, String r611, String r612, Type r613, String r614, AccessRole r615, CalendarDirtyType r616, Integer r617, Integer r618, Integer r619, Boolean r710, Boolean r711, Boolean r712, Boolean r713, Boolean r714, Boolean r715, List<CalendarEventReminder> r716, Long r717, Long r718, AccessRole r719, Status r810, MappingColor r811, Source r812, String r813, String r814, CalendarMember r815, Integer r816, Boolean r817, Boolean r818, Boolean r819, String r910, WorkHourSetting r911, Boolean r912, Integer r913, String r914, CalendarSchemaCollection r915, CalendarSchemaCollection r916, SchemaExtraData r917, CalendarAuthInfo r918, String r919, Boolean r100, CalendarShareOptions r101, CalendarShareInfo r102, Boolean r103, CalendarCoverImageSet r104, String r105, String r106, OfficialType r107, CalendarSyncInfo r108, CalendarPersonalizationSettings r109, Boolean r110) {
        this(r510, r511, r512, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711, r712, r713, r714, r715, r716, r717, r718, r719, r810, r811, r812, r813, r814, r815, r816, r817, r818, r819, r910, r911, r912, r913, r914, r915, r916, r917, r918, r919, r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, ByteString.EMPTY);
    }

    public Calendar(String r100, String r101, String r102, String r103, String r104, String r105, Type r110, String r111, AccessRole r112, CalendarDirtyType r113, Integer r114, Integer r115, Integer r116, Boolean r117, Boolean r118, Boolean r119, Boolean r210, Boolean r211, Boolean r212, List<CalendarEventReminder> r213, Long r214, Long r215, AccessRole r216, Status r217, MappingColor r218, Source r219, String r310, String r311, CalendarMember r312, Integer r313, Boolean r314, Boolean r315, Boolean r316, String r317, WorkHourSetting r318, Boolean r319, Integer r410, String r411, CalendarSchemaCollection r412, CalendarSchemaCollection r413, SchemaExtraData r414, CalendarAuthInfo r415, String r416, Boolean r417, CalendarShareOptions r418, CalendarShareInfo r419, Boolean r510, CalendarCoverImageSet r511, String r512, String r513, OfficialType r514, CalendarSyncInfo r515, CalendarPersonalizationSettings r516, Boolean r517, ByteString r518) {
        super(ADAPTER, r518);
        this.f253595id = r100;
        this.server_id = r101;
        this.email = r102;
        this.user_id = r103;
        this.summary = r104;
        this.description = r105;
        this.type = r110;
        this.default_timezone = r111;
        this.default_access_role = r112;
        this.dirty_type = r113;
        this.foreground_color = r114;
        this.background_color = r115;
        this.weight = r116;
        this.is_default = r117;
        this.is_synced = r118;
        this.is_visible = r119;
        this.is_primary = r210;
        this.is_public = r211;
        this.is_subscriber = r212;
        this.default_reminders = Internal.immutableCopyOf("default_reminders", r213);
        this.create_time = r214;
        this.update_time = r215;
        this.self_access_role = r216;
        this.self_status = r217;
        this.cal_color = r218;
        this.source = r219;
        this.localized_summary = r310;
        this.note = r311;
        this.owner = r312;
        this.resource_capacity = r313;
        this.is_all_staff = r314;
        this.is_active = r315;
        this.is_disabled = r316;
        this.external_account_email = r317;
        this.work_hour_setting = r318;
        this.is_loading = r319;
        this.visibility_property = r410;
        this.timezone = r411;
        this.calendar_event_schema = r412;
        this.calendar_schema = r413;
        this.schema_extra_data = r414;
        this.auth_info = r415;
        this.successor_chatter_id = r416;
        this.external_password_invalid = r417;
        this.share_options = r418;
        this.share_info = r419;
        this.is_cross_tenant = r510;
        this.cover_image_set = r511;
        this.calendar_owner_id = r512;
        this.calendar_tenant_id = r513;
        this.official_type = r514;
        this.calendar_sync_info = r515;
        this.personalization_settings = r516;
        this.is_creator_resigned = r517;
    }
}
