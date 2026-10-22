package com.bytedance.lark.pb.settings.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetUserSettingResponse extends Message<GetUserSettingResponse, Builder> {
    public static final ProtoAdapter<GetUserSettingResponse> ADAPTER = null;
    public static final Boolean DEFAULT_AUTO_AUDIO_TO_TEXT = null;
    public static final Boolean DEFAULT_AUTO_UPDATE_WORK_STATUS = null;
    public static final BadgeStyle DEFAULT_BADGE_STYLE = null;
    public static final Long DEFAULT_DO_NOT_DISTURB_END_TIME = null;
    public static final Boolean DEFAULT_MESSAGE_NOTIFICATIONS_OFF_DURING_CALLS = null;
    public static final Boolean DEFAULT_NAVIGATION_SHOW_MUTE_BADGE = null;
    public static final Long DEFAULT_UPDATE_TIME = null;
    public static final ProtoAdapter_GetUserSettingResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean auto_audio_to_text;
    public final Boolean auto_update_work_status;
    public final BadgeStyle badge_style;
    public final Long do_not_disturb_end_time;
    public final ExternalDisplayTimezoneSetting external_display_timezone;
    public final FeedSetting feed_setting;
    public final Boolean message_notifications_off_during_calls;
    public final Boolean navigation_show_mute_badge;
    public final NotificationSetting notification_setting;
    public final NotificationSettingV2 notification_setting_v2;
    public final SmsPhoneUrgentSetting sms_phone_urgent_setting;
    public final TimeFormatSetting time_format;
    public final Long update_time;

    public static final class Builder extends Message.Builder<GetUserSettingResponse, Builder> implements d<GetUserSettingResponse> {
        public Boolean auto_audio_to_text;
        public Boolean auto_update_work_status;
        public BadgeStyle badge_style;
        public Long do_not_disturb_end_time;
        public ExternalDisplayTimezoneSetting external_display_timezone;
        public FeedSetting feed_setting;
        public Boolean message_notifications_off_during_calls;
        public Boolean navigation_show_mute_badge;
        public NotificationSetting notification_setting;
        public NotificationSettingV2 notification_setting_v2;
        public SmsPhoneUrgentSetting sms_phone_urgent_setting;
        public TimeFormatSetting time_format;
        public Long update_time;

        @Override // com.squareup.wire.Message.Builder
        public GetUserSettingResponse build() {
            return new GetUserSettingResponse(this.auto_update_work_status, this.badge_style, this.notification_setting, this.time_format, this.auto_audio_to_text, this.do_not_disturb_end_time, this.sms_phone_urgent_setting, this.feed_setting, this.notification_setting_v2, this.message_notifications_off_during_calls, this.navigation_show_mute_badge, this.external_display_timezone, this.update_time, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder auto_audio_to_text(Boolean r100) {
            this.auto_audio_to_text = r100;
            return this;
        }

        public Builder auto_update_work_status(Boolean r100) {
            this.auto_update_work_status = r100;
            return this;
        }

        public Builder badge_style(BadgeStyle r100) {
            this.badge_style = r100;
            return this;
        }

        public Builder do_not_disturb_end_time(Long r100) {
            this.do_not_disturb_end_time = r100;
            return this;
        }

        public Builder external_display_timezone(ExternalDisplayTimezoneSetting r100) {
            this.external_display_timezone = r100;
            return this;
        }

        public Builder feed_setting(FeedSetting r100) {
            this.feed_setting = r100;
            return this;
        }

        public Builder message_notifications_off_during_calls(Boolean r100) {
            this.message_notifications_off_during_calls = r100;
            return this;
        }

        public Builder navigation_show_mute_badge(Boolean r100) {
            this.navigation_show_mute_badge = r100;
            return this;
        }

        public Builder notification_setting(NotificationSetting r100) {
            this.notification_setting = r100;
            return this;
        }

        public Builder notification_setting_v2(NotificationSettingV2 r100) {
            this.notification_setting_v2 = r100;
            return this;
        }

        public Builder sms_phone_urgent_setting(SmsPhoneUrgentSetting r100) {
            this.sms_phone_urgent_setting = r100;
            return this;
        }

        public Builder time_format(TimeFormatSetting r100) {
            this.time_format = r100;
            return this;
        }

        public Builder update_time(Long r100) {
            this.update_time = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetUserSettingResponse extends ProtoAdapter<GetUserSettingResponse> implements c<GetUserSettingResponse> {
        public ProtoAdapter_GetUserSettingResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetUserSettingResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetUserSettingResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.auto_update_work_status = Boolean.TRUE;
            r101.badge_style = BadgeStyle.WEAK_REMIND;
            Boolean r102 = Boolean.FALSE;
            r101.auto_audio_to_text = r102;
            r101.do_not_disturb_end_time = 0L;
            r101.message_notifications_off_during_calls = r102;
            r101.navigation_show_mute_badge = r102;
            r101.update_time = 0L;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L25;
            if (r104 != 20) goto L7;
            r101.update_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L7:
            switch(r104) {
                case 1: goto L23;
                case 2: goto L27;
                case 3: goto L18;
                case 4: goto L17;
                case 5: goto L16;
                case 6: goto L15;
                case 7: goto L14;
                case 8: goto L13;
                case 9: goto L12;
                case 10: goto L11;
                case 11: goto L10;
                case 12: goto L9;
                default: goto L8;
            };
        L27:
            r101.badge_style = BadgeStyle.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
        L21:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            r101.external_display_timezone = ExternalDisplayTimezoneSetting.ADAPTER.decode(r100);
            goto L3
        L10:
            r101.navigation_show_mute_badge = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            r101.message_notifications_off_during_calls = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            r101.notification_setting_v2 = NotificationSettingV2.ADAPTER.decode(r100);
            goto L3
        L13:
            r101.feed_setting = FeedSetting.ADAPTER.decode(r100);
            goto L3
        L14:
            r101.sms_phone_urgent_setting = SmsPhoneUrgentSetting.ADAPTER.decode(r100);
            goto L3
        L15:
            r101.do_not_disturb_end_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L16:
            r101.auto_audio_to_text = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L17:
            r101.time_format = TimeFormatSetting.ADAPTER.decode(r100);
            goto L3
        L18:
            r101.notification_setting = NotificationSetting.ADAPTER.decode(r100);
            goto L3
        L23:
            r101.auto_update_work_status = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L25:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetUserSettingResponse r100) {
            Boolean r101 = r100.auto_update_work_status;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            BadgeStyle r104 = r100.badge_style;
            if (r104 == null) goto L9;
            int r105 = BadgeStyle.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            NotificationSetting r107 = r100.notification_setting;
            if (r107 == null) goto L13;
            int r108 = NotificationSetting.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            TimeFormatSetting r110 = r100.time_format;
            if (r110 == null) goto L17;
            int r111 = TimeFormatSetting.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Boolean r113 = r100.auto_audio_to_text;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Long r116 = r100.do_not_disturb_end_time;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.INT64.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            SmsPhoneUrgentSetting r119 = r100.sms_phone_urgent_setting;
            if (r119 == null) goto L29;
            int r120 = SmsPhoneUrgentSetting.ADAPTER.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            FeedSetting r122 = r100.feed_setting;
            if (r122 == null) goto L33;
            int r123 = FeedSetting.ADAPTER.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            NotificationSettingV2 r125 = r100.notification_setting_v2;
            if (r125 == null) goto L37;
            int r126 = NotificationSettingV2.ADAPTER.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            Boolean r128 = r100.message_notifications_off_during_calls;
            if (r128 == null) goto L41;
            int r129 = ProtoAdapter.BOOL.encodedSizeWithTag(10, r128);
        L42:
            int r130 = r127 + r129;
            Boolean r131 = r100.navigation_show_mute_badge;
            if (r131 == null) goto L45;
            int r132 = ProtoAdapter.BOOL.encodedSizeWithTag(11, r131);
        L46:
            int r133 = r130 + r132;
            ExternalDisplayTimezoneSetting r134 = r100.external_display_timezone;
            if (r134 == null) goto L49;
            int r135 = ExternalDisplayTimezoneSetting.ADAPTER.encodedSizeWithTag(12, r134);
        L50:
            int r136 = r133 + r135;
            Long r137 = r100.update_time;
            if (r137 == null) goto L54;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(20, r137);
        L54:
            return (r136 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ GetUserSettingResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetUserSettingResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetUserSettingResponse r101) throws IOException {
            Boolean r102 = r101.auto_update_work_status;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            BadgeStyle r103 = r101.badge_style;
            if (r103 == null) goto L8;
            BadgeStyle.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            NotificationSetting r104 = r101.notification_setting;
            if (r104 == null) goto L11;
            NotificationSetting.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            TimeFormatSetting r105 = r101.time_format;
            if (r105 == null) goto L14;
            TimeFormatSetting.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            Boolean r106 = r101.auto_audio_to_text;
            if (r106 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r106);
        L17:
            Long r107 = r101.do_not_disturb_end_time;
            if (r107 == null) goto L20;
            ProtoAdapter.INT64.encodeWithTag(r100, 6, r107);
        L20:
            SmsPhoneUrgentSetting r108 = r101.sms_phone_urgent_setting;
            if (r108 == null) goto L23;
            SmsPhoneUrgentSetting.ADAPTER.encodeWithTag(r100, 7, r108);
        L23:
            FeedSetting r109 = r101.feed_setting;
            if (r109 == null) goto L26;
            FeedSetting.ADAPTER.encodeWithTag(r100, 8, r109);
        L26:
            NotificationSettingV2 r110 = r101.notification_setting_v2;
            if (r110 == null) goto L29;
            NotificationSettingV2.ADAPTER.encodeWithTag(r100, 9, r110);
        L29:
            Boolean r111 = r101.message_notifications_off_during_calls;
            if (r111 == null) goto L32;
            ProtoAdapter.BOOL.encodeWithTag(r100, 10, r111);
        L32:
            Boolean r112 = r101.navigation_show_mute_badge;
            if (r112 == null) goto L35;
            ProtoAdapter.BOOL.encodeWithTag(r100, 11, r112);
        L35:
            ExternalDisplayTimezoneSetting r113 = r101.external_display_timezone;
            if (r113 == null) goto L38;
            ExternalDisplayTimezoneSetting.ADAPTER.encodeWithTag(r100, 12, r113);
        L38:
            Long r114 = r101.update_time;
            if (r114 == null) goto L41;
            ProtoAdapter.INT64.encodeWithTag(r100, 20, r114);
        L41:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetUserSettingResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetUserSettingResponse r100 = new ProtoAdapter_GetUserSettingResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_AUTO_UPDATE_WORK_STATUS = Boolean.TRUE;
        DEFAULT_BADGE_STYLE = BadgeStyle.WEAK_REMIND;
        Boolean r101 = Boolean.FALSE;
        DEFAULT_AUTO_AUDIO_TO_TEXT = r101;
        DEFAULT_DO_NOT_DISTURB_END_TIME = 0L;
        DEFAULT_MESSAGE_NOTIFICATIONS_OFF_DURING_CALLS = r101;
        DEFAULT_NAVIGATION_SHOW_MUTE_BADGE = r101;
        DEFAULT_UPDATE_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.auto_update_work_status = this.auto_update_work_status;
        r100.badge_style = this.badge_style;
        r100.notification_setting = this.notification_setting;
        r100.time_format = this.time_format;
        r100.auto_audio_to_text = this.auto_audio_to_text;
        r100.do_not_disturb_end_time = this.do_not_disturb_end_time;
        r100.sms_phone_urgent_setting = this.sms_phone_urgent_setting;
        r100.feed_setting = this.feed_setting;
        r100.notification_setting_v2 = this.notification_setting_v2;
        r100.message_notifications_off_during_calls = this.message_notifications_off_during_calls;
        r100.navigation_show_mute_badge = this.navigation_show_mute_badge;
        r100.external_display_timezone = this.external_display_timezone;
        r100.update_time = this.update_time;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetUserSettingResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetUserSettingResponse(Boolean r110, BadgeStyle r111, NotificationSetting r112, TimeFormatSetting r113, Boolean r210, Long r211, SmsPhoneUrgentSetting r212, FeedSetting r213, NotificationSettingV2 r214, Boolean r215, Boolean r216, ExternalDisplayTimezoneSetting r217, Long r218) {
        this(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217, r218, ByteString.EMPTY);
    }

    public GetUserSettingResponse(Boolean r100, BadgeStyle r101, NotificationSetting r102, TimeFormatSetting r103, Boolean r104, Long r105, SmsPhoneUrgentSetting r106, FeedSetting r107, NotificationSettingV2 r110, Boolean r111, Boolean r112, ExternalDisplayTimezoneSetting r113, Long r114, ByteString r115) {
        super(ADAPTER, r115);
        this.auto_update_work_status = r100;
        this.badge_style = r101;
        this.notification_setting = r102;
        this.time_format = r103;
        this.auto_audio_to_text = r104;
        this.do_not_disturb_end_time = r105;
        this.sms_phone_urgent_setting = r106;
        this.feed_setting = r107;
        this.notification_setting_v2 = r110;
        this.message_notifications_off_during_calls = r111;
        this.navigation_show_mute_badge = r112;
        this.external_display_timezone = r113;
        this.update_time = r114;
    }
}
