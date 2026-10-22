package com.ss.android.lark.pb.videochat;

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
public final class GetAdminSettingsResponse extends Message<GetAdminSettingsResponse, Builder> {
    public static final ProtoAdapter<GetAdminSettingsResponse> ADAPTER = null;
    public static final Boolean DEFAULT_ALLOW_USER_CHANGE_PSTN_AUDIO_TYPE = null;
    public static final Boolean DEFAULT_AUTO_SHARE_SCREEN_CCM_PERMISSION = null;
    public static final Boolean DEFAULT_CAN_PERSONAL_INSTALL = null;
    public static final Boolean DEFAULT_ENABLE_1080P_VIDEO = null;
    public static final Boolean DEFAULT_ENABLE_4K_SHARE = null;
    public static final Boolean DEFAULT_ENABLE_CHECK_SCREEN_SHARE = null;
    public static final Boolean DEFAULT_ENABLE_CUSTOM_MEETING_BACKGROUND = null;
    public static final Boolean DEFAULT_ENABLE_LIVE = null;
    public static final Boolean DEFAULT_ENABLE_LOCAL_RECORD = null;
    public static final Boolean DEFAULT_ENABLE_MEETING_BACKGROUND = null;
    public static final Boolean DEFAULT_ENABLE_MEETING_PASSWORD = null;
    public static final Boolean DEFAULT_ENABLE_PSTN_CALLOUT_SCOPE_ANY = null;
    public static final Boolean DEFAULT_ENABLE_RECORD = null;
    public static final Boolean DEFAULT_ENABLE_RECORD_AI_SUMMARY = null;
    public static final Boolean DEFAULT_ENABLE_SIP = null;
    public static final Boolean DEFAULT_ENABLE_SUBTITLE = null;
    public static final Boolean DEFAULT_ENABLE_VIRTUAL_AVATAR = null;
    public static final Boolean DEFAULT_ENABLE_VOICEPRINT = null;
    public static final Integer DEFAULT_JOIN_GROUP_MEETING_PRIVILEGE_TYPE = null;
    public static final Integer DEFAULT_JOIN_USER_INSTANT_MEETING_PRIVILEGE_TYPE = null;
    public static final Integer DEFAULT_JOIN_USER_RESERVED_MEETING_PRIVILEGE_TYPE = null;
    public static final Boolean DEFAULT_MEETING_FORCE_RECORD = null;
    public static final Boolean DEFAULT_PSTN_ENABLE_INCOMING_CALL = null;
    public static final Boolean DEFAULT_PSTN_ENABLE_OUTGOING_CALL = null;
    public static final Boolean DEFAULT_PSTN_HIDE_PHONE_NUMBER = null;
    public static final Boolean DEFAULT_PSTN_JOIN_MEETING_PROMPT = null;
    public static final Boolean DEFAULT_RECORD_AUTO_APPLY_START = null;
    public static final Boolean DEFAULT_RECORD_AUTO_START = null;
    public static final Boolean DEFAULT_RECORD_NEED_APPROVE = null;
    public static final Integer DEFAULT_SIP_DEFAULT_LAYOUT = null;
    public static final Boolean DEFAULT_SIP_ENABLE_DUAL_STREAM = null;
    public static final Boolean DEFAULT_SIP_ENABLE_ENTER_LEAVE_PROMPT = null;
    public static final Boolean DEFAULT_SIP_ENABLE_FECC = null;
    public static final Boolean DEFAULT_SIP_ENABLE_IM = null;
    public static final Boolean DEFAULT_SIP_ENABLE_SHOW_NAME = null;
    public static final Boolean DEFAULT_SIP_LIVE_NEED_APPROVE = null;
    public static final Boolean DEFAULT_SIP_NEED_ENCRYPT = null;
    public static final String DEFAULT_SIP_PROMPT_LANGUAGE = "";
    public static final Boolean DEFAULT_SIP_RECORD_NEED_APPROVE = null;
    public static final Integer DEFAULT_SIP_VIDEO_LOOP_INTERVAL = null;
    public static final Boolean DEFAULT_VOICE_FORCE_RECORD = null;
    private static final long serialVersionUID = 0;
    public final Boolean mallow_user_change_pstn_audio_type;
    public final Boolean mauto_share_screen_ccm_permission;
    public final Bandwidth mbandwidth;
    public final Boolean mcan_personal_install;
    public final Boolean menable_1080p_video;
    public final Boolean menable_4k_share;
    public final Boolean menable_check_screen_share;
    public final Boolean menable_custom_meeting_background;
    public final Boolean menable_live;
    public final Boolean menable_local_record;
    public final Boolean menable_meeting_background;
    public final Boolean menable_meeting_password;
    public final Boolean menable_pstn_callout_scope_any;
    public final Boolean menable_record;
    public final Boolean menable_record_ai_summary;
    public final Boolean menable_sip;
    public final Boolean menable_subtitle;
    public final Boolean menable_virtual_avatar;
    public final Boolean menable_voiceprint;
    public final Integer mjoin_group_meeting_privilege_type;
    public final Integer mjoin_user_instant_meeting_privilege_type;
    public final Integer mjoin_user_reserved_meeting_privilege_type;
    public final List<MeetingBackground> mmeeting_background_list;
    public final Boolean mmeeting_force_record;
    public final Boolean mpstn_enable_incoming_call;
    public final Boolean mpstn_enable_outgoing_call;
    public final Boolean mpstn_hide_phone_number;
    public final List<String> mpstn_incoming_call_country_default;
    public final List<PSTNPhone> mpstn_incoming_call_phone_list;
    public final Boolean mpstn_join_meeting_prompt;
    public final List<String> mpstn_outgoing_call_country_default;
    public final List<String> mpstn_outgoing_call_country_list;
    public final Boolean mrecord_auto_apply_start;
    public final Boolean mrecord_auto_start;
    public final Boolean mrecord_need_approve;
    public final RTCProxy mrtc_proxy;
    public final List<RTCProxy> mrtc_proxy_list;
    public final ShareScreenConfirm mshare_screen_confirm;
    public final Integer msip_default_layout;
    public final Boolean msip_enable_dual_stream;
    public final Boolean msip_enable_enter_leave_prompt;
    public final Boolean msip_enable_fecc;
    public final Boolean msip_enable_im;
    public final Boolean msip_enable_show_name;
    public final Boolean msip_live_need_approve;
    public final Boolean msip_need_encrypt;
    public final String msip_prompt_language;
    public final Boolean msip_record_need_approve;
    public final Integer msip_video_loop_interval;
    public final List<String> mspeed_up_nodes;
    public final Boolean mvoice_force_record;

    public static final class Builder extends Message.Builder<GetAdminSettingsResponse, Builder> {
        public Boolean mallow_user_change_pstn_audio_type;
        public Boolean mauto_share_screen_ccm_permission;
        public Bandwidth mbandwidth;
        public Boolean mcan_personal_install;
        public Boolean menable_1080p_video;
        public Boolean menable_4k_share;
        public Boolean menable_check_screen_share;
        public Boolean menable_custom_meeting_background;
        public Boolean menable_live;
        public Boolean menable_local_record;
        public Boolean menable_meeting_background;
        public Boolean menable_meeting_password;
        public Boolean menable_pstn_callout_scope_any;
        public Boolean menable_record;
        public Boolean menable_record_ai_summary;
        public Boolean menable_sip;
        public Boolean menable_subtitle;
        public Boolean menable_virtual_avatar;
        public Boolean menable_voiceprint;
        public Integer mjoin_group_meeting_privilege_type;
        public Integer mjoin_user_instant_meeting_privilege_type;
        public Integer mjoin_user_reserved_meeting_privilege_type;
        public List<MeetingBackground> mmeeting_background_list;
        public Boolean mmeeting_force_record;
        public Boolean mpstn_enable_incoming_call;
        public Boolean mpstn_enable_outgoing_call;
        public Boolean mpstn_hide_phone_number;
        public List<String> mpstn_incoming_call_country_default;
        public List<PSTNPhone> mpstn_incoming_call_phone_list;
        public Boolean mpstn_join_meeting_prompt;
        public List<String> mpstn_outgoing_call_country_default;
        public List<String> mpstn_outgoing_call_country_list;
        public Boolean mrecord_auto_apply_start;
        public Boolean mrecord_auto_start;
        public Boolean mrecord_need_approve;
        public RTCProxy mrtc_proxy;
        public List<RTCProxy> mrtc_proxy_list;
        public ShareScreenConfirm mshare_screen_confirm;
        public Integer msip_default_layout;
        public Boolean msip_enable_dual_stream;
        public Boolean msip_enable_enter_leave_prompt;
        public Boolean msip_enable_fecc;
        public Boolean msip_enable_im;
        public Boolean msip_enable_show_name;
        public Boolean msip_live_need_approve;
        public Boolean msip_need_encrypt;
        public String msip_prompt_language;
        public Boolean msip_record_need_approve;
        public Integer msip_video_loop_interval;
        public List<String> mspeed_up_nodes;
        public Boolean mvoice_force_record;

        @Override // com.squareup.wire.Message.Builder
        public GetAdminSettingsResponse build() {
            return new GetAdminSettingsResponse(this.menable_record, this.menable_subtitle, this.mrecord_need_approve, this.mpstn_enable_outgoing_call, this.mpstn_hide_phone_number, this.mpstn_enable_incoming_call, this.mpstn_incoming_call_country_default, this.mpstn_incoming_call_phone_list, this.mpstn_outgoing_call_country_default, this.mpstn_outgoing_call_country_list, this.mpstn_join_meeting_prompt, this.msip_need_encrypt, this.msip_prompt_language, this.msip_record_need_approve, this.msip_live_need_approve, this.msip_enable_dual_stream, this.msip_enable_im, this.msip_enable_enter_leave_prompt, this.msip_enable_show_name, this.msip_default_layout, this.msip_video_loop_interval, this.msip_enable_fecc, this.menable_meeting_background, this.menable_custom_meeting_background, this.mmeeting_background_list, this.menable_virtual_avatar, this.mrtc_proxy, this.menable_sip, this.mcan_personal_install, this.menable_check_screen_share, this.mrecord_auto_start, this.mrecord_auto_apply_start, this.mjoin_group_meeting_privilege_type, this.mjoin_user_instant_meeting_privilege_type, this.mjoin_user_reserved_meeting_privilege_type, this.menable_pstn_callout_scope_any, this.menable_voiceprint, this.mallow_user_change_pstn_audio_type, this.menable_live, this.mspeed_up_nodes, this.mauto_share_screen_ccm_permission, this.mrtc_proxy_list, this.mshare_screen_confirm, this.mbandwidth, this.menable_local_record, this.menable_record_ai_summary, this.menable_meeting_password, this.mmeeting_force_record, this.mvoice_force_record, this.menable_4k_share, this.menable_1080p_video, super.buildUnknownFields());
        }

        public Builder() {
            this.mpstn_incoming_call_country_default = Internal.newMutableList();
            this.mpstn_incoming_call_phone_list = Internal.newMutableList();
            this.mpstn_outgoing_call_country_default = Internal.newMutableList();
            this.mpstn_outgoing_call_country_list = Internal.newMutableList();
            this.mmeeting_background_list = Internal.newMutableList();
            this.mspeed_up_nodes = Internal.newMutableList();
            this.mrtc_proxy_list = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder allow_user_change_pstn_audio_type(Boolean r100) {
            this.mallow_user_change_pstn_audio_type = r100;
            return this;
        }

        public Builder auto_share_screen_ccm_permission(Boolean r100) {
            this.mauto_share_screen_ccm_permission = r100;
            return this;
        }

        public Builder bandwidth(Bandwidth r100) {
            this.mbandwidth = r100;
            return this;
        }

        public Builder can_personal_install(Boolean r100) {
            this.mcan_personal_install = r100;
            return this;
        }

        public Builder enable_1080p_video(Boolean r100) {
            this.menable_1080p_video = r100;
            return this;
        }

        public Builder enable_4k_share(Boolean r100) {
            this.menable_4k_share = r100;
            return this;
        }

        public Builder enable_check_screen_share(Boolean r100) {
            this.menable_check_screen_share = r100;
            return this;
        }

        public Builder enable_custom_meeting_background(Boolean r100) {
            this.menable_custom_meeting_background = r100;
            return this;
        }

        public Builder enable_live(Boolean r100) {
            this.menable_live = r100;
            return this;
        }

        public Builder enable_local_record(Boolean r100) {
            this.menable_local_record = r100;
            return this;
        }

        public Builder enable_meeting_background(Boolean r100) {
            this.menable_meeting_background = r100;
            return this;
        }

        public Builder enable_meeting_password(Boolean r100) {
            this.menable_meeting_password = r100;
            return this;
        }

        public Builder enable_pstn_callout_scope_any(Boolean r100) {
            this.menable_pstn_callout_scope_any = r100;
            return this;
        }

        public Builder enable_record(Boolean r100) {
            this.menable_record = r100;
            return this;
        }

        public Builder enable_record_ai_summary(Boolean r100) {
            this.menable_record_ai_summary = r100;
            return this;
        }

        public Builder enable_sip(Boolean r100) {
            this.menable_sip = r100;
            return this;
        }

        public Builder enable_subtitle(Boolean r100) {
            this.menable_subtitle = r100;
            return this;
        }

        public Builder enable_virtual_avatar(Boolean r100) {
            this.menable_virtual_avatar = r100;
            return this;
        }

        public Builder enable_voiceprint(Boolean r100) {
            this.menable_voiceprint = r100;
            return this;
        }

        public Builder join_group_meeting_privilege_type(Integer r100) {
            this.mjoin_group_meeting_privilege_type = r100;
            return this;
        }

        public Builder join_user_instant_meeting_privilege_type(Integer r100) {
            this.mjoin_user_instant_meeting_privilege_type = r100;
            return this;
        }

        public Builder join_user_reserved_meeting_privilege_type(Integer r100) {
            this.mjoin_user_reserved_meeting_privilege_type = r100;
            return this;
        }

        public Builder meeting_background_list(List<MeetingBackground> r100) {
            Internal.checkElementsNotNull(r100);
            this.mmeeting_background_list = r100;
            return this;
        }

        public Builder meeting_force_record(Boolean r100) {
            this.mmeeting_force_record = r100;
            return this;
        }

        public Builder pstn_enable_incoming_call(Boolean r100) {
            this.mpstn_enable_incoming_call = r100;
            return this;
        }

        public Builder pstn_enable_outgoing_call(Boolean r100) {
            this.mpstn_enable_outgoing_call = r100;
            return this;
        }

        public Builder pstn_hide_phone_number(Boolean r100) {
            this.mpstn_hide_phone_number = r100;
            return this;
        }

        public Builder pstn_incoming_call_country_default(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mpstn_incoming_call_country_default = r100;
            return this;
        }

        public Builder pstn_incoming_call_phone_list(List<PSTNPhone> r100) {
            Internal.checkElementsNotNull(r100);
            this.mpstn_incoming_call_phone_list = r100;
            return this;
        }

        public Builder pstn_join_meeting_prompt(Boolean r100) {
            this.mpstn_join_meeting_prompt = r100;
            return this;
        }

        public Builder pstn_outgoing_call_country_default(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mpstn_outgoing_call_country_default = r100;
            return this;
        }

        public Builder pstn_outgoing_call_country_list(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mpstn_outgoing_call_country_list = r100;
            return this;
        }

        public Builder record_auto_apply_start(Boolean r100) {
            this.mrecord_auto_apply_start = r100;
            return this;
        }

        public Builder record_auto_start(Boolean r100) {
            this.mrecord_auto_start = r100;
            return this;
        }

        public Builder record_need_approve(Boolean r100) {
            this.mrecord_need_approve = r100;
            return this;
        }

        public Builder rtc_proxy(RTCProxy r100) {
            this.mrtc_proxy = r100;
            return this;
        }

        public Builder rtc_proxy_list(List<RTCProxy> r100) {
            Internal.checkElementsNotNull(r100);
            this.mrtc_proxy_list = r100;
            return this;
        }

        public Builder share_screen_confirm(ShareScreenConfirm r100) {
            this.mshare_screen_confirm = r100;
            return this;
        }

        public Builder sip_default_layout(Integer r100) {
            this.msip_default_layout = r100;
            return this;
        }

        public Builder sip_enable_dual_stream(Boolean r100) {
            this.msip_enable_dual_stream = r100;
            return this;
        }

        public Builder sip_enable_enter_leave_prompt(Boolean r100) {
            this.msip_enable_enter_leave_prompt = r100;
            return this;
        }

        public Builder sip_enable_fecc(Boolean r100) {
            this.msip_enable_fecc = r100;
            return this;
        }

        public Builder sip_enable_im(Boolean r100) {
            this.msip_enable_im = r100;
            return this;
        }

        public Builder sip_enable_show_name(Boolean r100) {
            this.msip_enable_show_name = r100;
            return this;
        }

        public Builder sip_live_need_approve(Boolean r100) {
            this.msip_live_need_approve = r100;
            return this;
        }

        public Builder sip_need_encrypt(Boolean r100) {
            this.msip_need_encrypt = r100;
            return this;
        }

        public Builder sip_prompt_language(String r100) {
            this.msip_prompt_language = r100;
            return this;
        }

        public Builder sip_record_need_approve(Boolean r100) {
            this.msip_record_need_approve = r100;
            return this;
        }

        public Builder sip_video_loop_interval(Integer r100) {
            this.msip_video_loop_interval = r100;
            return this;
        }

        public Builder speed_up_nodes(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mspeed_up_nodes = r100;
            return this;
        }

        public Builder voice_force_record(Boolean r100) {
            this.mvoice_force_record = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetAdminSettingsResponse extends ProtoAdapter<GetAdminSettingsResponse> {
        public ProtoAdapter_GetAdminSettingsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetAdminSettingsResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetAdminSettingsResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.FALSE;
            r101.menable_record = r102;
            r101.menable_subtitle = r102;
            r101.mrecord_need_approve = r102;
            r101.mpstn_enable_outgoing_call = r102;
            r101.mpstn_hide_phone_number = r102;
            r101.mpstn_enable_incoming_call = r102;
            r101.mpstn_join_meeting_prompt = r102;
            r101.msip_need_encrypt = r102;
            r101.msip_prompt_language = "";
            r101.msip_record_need_approve = r102;
            r101.msip_live_need_approve = r102;
            r101.msip_enable_dual_stream = r102;
            r101.msip_enable_im = r102;
            r101.msip_enable_enter_leave_prompt = r102;
            r101.msip_enable_show_name = r102;
            r101.msip_default_layout = 0;
            r101.msip_video_loop_interval = 0;
            r101.msip_enable_fecc = r102;
            r101.menable_meeting_background = r102;
            r101.menable_custom_meeting_background = r102;
            r101.menable_virtual_avatar = r102;
            r101.menable_sip = r102;
            r101.mcan_personal_install = r102;
            r101.menable_check_screen_share = r102;
            r101.mrecord_auto_start = r102;
            r101.mrecord_auto_apply_start = r102;
            r101.mjoin_group_meeting_privilege_type = 0;
            r101.mjoin_user_instant_meeting_privilege_type = 0;
            r101.mjoin_user_reserved_meeting_privilege_type = 0;
            r101.menable_pstn_callout_scope_any = r102;
            r101.menable_voiceprint = r102;
            r101.mallow_user_change_pstn_audio_type = r102;
            r101.menable_live = r102;
            r101.mauto_share_screen_ccm_permission = r102;
            r101.menable_local_record = r102;
            r101.menable_record_ai_summary = r102;
            r101.menable_meeting_password = r102;
            r101.mmeeting_force_record = r102;
            r101.mvoice_force_record = r102;
            r101.menable_4k_share = r102;
            r101.menable_1080p_video = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L61;
            switch(r104) {
                case 1: goto L60;
                case 2: goto L59;
                case 3: goto L58;
                case 4: goto L57;
                case 5: goto L56;
                case 6: goto L55;
                case 7: goto L54;
                case 8: goto L53;
                case 9: goto L52;
                case 10: goto L51;
                case 11: goto L50;
                case 12: goto L49;
                case 13: goto L48;
                case 14: goto L47;
                case 15: goto L46;
                case 16: goto L45;
                case 17: goto L44;
                case 18: goto L43;
                case 19: goto L42;
                case 20: goto L41;
                case 21: goto L40;
                case 22: goto L39;
                case 23: goto L38;
                case 24: goto L37;
                case 25: goto L36;
                case 26: goto L35;
                case 27: goto L34;
                case 28: goto L33;
                case 29: goto L32;
                case 30: goto L31;
                case 31: goto L30;
                case 32: goto L29;
                case 33: goto L28;
                case 34: goto L27;
                case 35: goto L26;
                case 36: goto L25;
                case 37: goto L24;
                case 38: goto L23;
                case 39: goto L22;
                case 40: goto L21;
                case 41: goto L20;
                case 42: goto L19;
                case 43: goto L63;
                case 44: goto L14;
                case 45: goto L13;
                case 46: goto L12;
                case 47: goto L11;
                case 48: goto L10;
                case 49: goto L9;
                case 50: goto L8;
                case 51: goto L7;
                default: goto L6;
            };
        L63:
            r101.mshare_screen_confirm = ShareScreenConfirm.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.menable_1080p_video = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            r101.menable_4k_share = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            r101.mvoice_force_record = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            r101.mmeeting_force_record = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            r101.menable_meeting_password = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            r101.menable_record_ai_summary = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            r101.menable_local_record = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L14:
            r101.mbandwidth = Bandwidth.ADAPTER.decode(r100);
            goto L3
        L19:
            r101.mrtc_proxy_list.add(RTCProxy.ADAPTER.decode(r100));
            goto L3
        L20:
            r101.mauto_share_screen_ccm_permission = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L21:
            r101.mspeed_up_nodes.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L22:
            r101.menable_live = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L23:
            r101.mallow_user_change_pstn_audio_type = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L24:
            r101.menable_voiceprint = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L25:
            r101.menable_pstn_callout_scope_any = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L26:
            r101.mjoin_user_reserved_meeting_privilege_type = ProtoAdapter.INT32.decode(r100);
            goto L3
        L27:
            r101.mjoin_user_instant_meeting_privilege_type = ProtoAdapter.INT32.decode(r100);
            goto L3
        L28:
            r101.mjoin_group_meeting_privilege_type = ProtoAdapter.INT32.decode(r100);
            goto L3
        L29:
            r101.mrecord_auto_apply_start = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L30:
            r101.mrecord_auto_start = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L31:
            r101.menable_check_screen_share = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L32:
            r101.mcan_personal_install = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L33:
            r101.menable_sip = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L34:
            r101.mrtc_proxy = RTCProxy.ADAPTER.decode(r100);
            goto L3
        L35:
            r101.menable_virtual_avatar = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L36:
            r101.mmeeting_background_list.add(MeetingBackground.ADAPTER.decode(r100));
            goto L3
        L37:
            r101.menable_custom_meeting_background = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L38:
            r101.menable_meeting_background = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L39:
            r101.msip_enable_fecc = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L40:
            r101.msip_video_loop_interval = ProtoAdapter.INT32.decode(r100);
            goto L3
        L41:
            r101.msip_default_layout = ProtoAdapter.INT32.decode(r100);
            goto L3
        L42:
            r101.msip_enable_show_name = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L43:
            r101.msip_enable_enter_leave_prompt = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L44:
            r101.msip_enable_im = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L45:
            r101.msip_enable_dual_stream = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L46:
            r101.msip_live_need_approve = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L47:
            r101.msip_record_need_approve = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L48:
            r101.msip_prompt_language = ProtoAdapter.STRING.decode(r100);
            goto L3
        L49:
            r101.msip_need_encrypt = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L50:
            r101.mpstn_join_meeting_prompt = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L51:
            r101.mpstn_outgoing_call_country_list.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L52:
            r101.mpstn_outgoing_call_country_default.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L53:
            r101.mpstn_incoming_call_phone_list.add(PSTNPhone.ADAPTER.decode(r100));
            goto L3
        L54:
            r101.mpstn_incoming_call_country_default.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L55:
            r101.mpstn_enable_incoming_call = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L56:
            r101.mpstn_hide_phone_number = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L57:
            r101.mpstn_enable_outgoing_call = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L58:
            r101.mrecord_need_approve = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L59:
            r101.menable_subtitle = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L60:
            r101.menable_record = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L61:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetAdminSettingsResponse r100) {
            Boolean r101 = r100.menable_record;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.menable_subtitle;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.mrecord_need_approve;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Boolean r110 = r100.mpstn_enable_outgoing_call;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Boolean r113 = r100.mpstn_hide_phone_number;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Boolean r116 = r100.mpstn_enable_incoming_call;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            ProtoAdapter<String> r119 = ProtoAdapter.STRING;
            int r120 = (((r118 + r119.asRepeated().encodedSizeWithTag(7, r100.mpstn_incoming_call_country_default)) + PSTNPhone.ADAPTER.asRepeated().encodedSizeWithTag(8, r100.mpstn_incoming_call_phone_list)) + r119.asRepeated().encodedSizeWithTag(9, r100.mpstn_outgoing_call_country_default)) + r119.asRepeated().encodedSizeWithTag(10, r100.mpstn_outgoing_call_country_list);
            Boolean r121 = r100.mpstn_join_meeting_prompt;
            if (r121 == null) goto L29;
            int r122 = ProtoAdapter.BOOL.encodedSizeWithTag(11, r121);
        L30:
            int r123 = r120 + r122;
            Boolean r124 = r100.msip_need_encrypt;
            if (r124 == null) goto L33;
            int r125 = ProtoAdapter.BOOL.encodedSizeWithTag(12, r124);
        L34:
            int r126 = r123 + r125;
            String r127 = r100.msip_prompt_language;
            if (r127 == null) goto L37;
            int r128 = r119.encodedSizeWithTag(13, r127);
        L38:
            int r129 = r126 + r128;
            Boolean r130 = r100.msip_record_need_approve;
            if (r130 == null) goto L41;
            int r131 = ProtoAdapter.BOOL.encodedSizeWithTag(14, r130);
        L42:
            int r132 = r129 + r131;
            Boolean r133 = r100.msip_live_need_approve;
            if (r133 == null) goto L45;
            int r134 = ProtoAdapter.BOOL.encodedSizeWithTag(15, r133);
        L46:
            int r135 = r132 + r134;
            Boolean r136 = r100.msip_enable_dual_stream;
            if (r136 == null) goto L49;
            int r137 = ProtoAdapter.BOOL.encodedSizeWithTag(16, r136);
        L50:
            int r138 = r135 + r137;
            Boolean r139 = r100.msip_enable_im;
            if (r139 == null) goto L53;
            int r140 = ProtoAdapter.BOOL.encodedSizeWithTag(17, r139);
        L54:
            int r141 = r138 + r140;
            Boolean r142 = r100.msip_enable_enter_leave_prompt;
            if (r142 == null) goto L57;
            int r143 = ProtoAdapter.BOOL.encodedSizeWithTag(18, r142);
        L58:
            int r144 = r141 + r143;
            Boolean r145 = r100.msip_enable_show_name;
            if (r145 == null) goto L61;
            int r146 = ProtoAdapter.BOOL.encodedSizeWithTag(19, r145);
        L62:
            int r147 = r144 + r146;
            Integer r148 = r100.msip_default_layout;
            if (r148 == null) goto L65;
            int r149 = ProtoAdapter.INT32.encodedSizeWithTag(20, r148);
        L66:
            int r150 = r147 + r149;
            Integer r151 = r100.msip_video_loop_interval;
            if (r151 == null) goto L69;
            int r152 = ProtoAdapter.INT32.encodedSizeWithTag(21, r151);
        L70:
            int r153 = r150 + r152;
            Boolean r154 = r100.msip_enable_fecc;
            if (r154 == null) goto L73;
            int r155 = ProtoAdapter.BOOL.encodedSizeWithTag(22, r154);
        L74:
            int r156 = r153 + r155;
            Boolean r157 = r100.menable_meeting_background;
            if (r157 == null) goto L77;
            int r158 = ProtoAdapter.BOOL.encodedSizeWithTag(23, r157);
        L78:
            int r159 = r156 + r158;
            Boolean r160 = r100.menable_custom_meeting_background;
            if (r160 == null) goto L81;
            int r161 = ProtoAdapter.BOOL.encodedSizeWithTag(24, r160);
        L82:
            int r162 = (r159 + r161) + MeetingBackground.ADAPTER.asRepeated().encodedSizeWithTag(25, r100.mmeeting_background_list);
            Boolean r163 = r100.menable_virtual_avatar;
            if (r163 == null) goto L85;
            int r164 = ProtoAdapter.BOOL.encodedSizeWithTag(26, r163);
        L86:
            int r165 = r162 + r164;
            RTCProxy r166 = r100.mrtc_proxy;
            if (r166 == null) goto L89;
            int r167 = RTCProxy.ADAPTER.encodedSizeWithTag(27, r166);
        L90:
            int r168 = r165 + r167;
            Boolean r169 = r100.menable_sip;
            if (r169 == null) goto L93;
            int r170 = ProtoAdapter.BOOL.encodedSizeWithTag(28, r169);
        L94:
            int r171 = r168 + r170;
            Boolean r172 = r100.mcan_personal_install;
            if (r172 == null) goto L97;
            int r173 = ProtoAdapter.BOOL.encodedSizeWithTag(29, r172);
        L98:
            int r174 = r171 + r173;
            Boolean r175 = r100.menable_check_screen_share;
            if (r175 == null) goto L101;
            int r176 = ProtoAdapter.BOOL.encodedSizeWithTag(30, r175);
        L102:
            int r177 = r174 + r176;
            Boolean r178 = r100.mrecord_auto_start;
            if (r178 == null) goto L105;
            int r179 = ProtoAdapter.BOOL.encodedSizeWithTag(31, r178);
        L106:
            int r180 = r177 + r179;
            Boolean r181 = r100.mrecord_auto_apply_start;
            if (r181 == null) goto L109;
            int r182 = ProtoAdapter.BOOL.encodedSizeWithTag(32, r181);
        L110:
            int r183 = r180 + r182;
            Integer r184 = r100.mjoin_group_meeting_privilege_type;
            if (r184 == null) goto L113;
            int r185 = ProtoAdapter.INT32.encodedSizeWithTag(33, r184);
        L114:
            int r186 = r183 + r185;
            Integer r187 = r100.mjoin_user_instant_meeting_privilege_type;
            if (r187 == null) goto L117;
            int r188 = ProtoAdapter.INT32.encodedSizeWithTag(34, r187);
        L118:
            int r189 = r186 + r188;
            Integer r190 = r100.mjoin_user_reserved_meeting_privilege_type;
            if (r190 == null) goto L121;
            int r191 = ProtoAdapter.INT32.encodedSizeWithTag(35, r190);
        L122:
            int r192 = r189 + r191;
            Boolean r193 = r100.menable_pstn_callout_scope_any;
            if (r193 == null) goto L125;
            int r194 = ProtoAdapter.BOOL.encodedSizeWithTag(36, r193);
        L126:
            int r195 = r192 + r194;
            Boolean r196 = r100.menable_voiceprint;
            if (r196 == null) goto L129;
            int r197 = ProtoAdapter.BOOL.encodedSizeWithTag(37, r196);
        L130:
            int r198 = r195 + r197;
            Boolean r199 = r100.mallow_user_change_pstn_audio_type;
            if (r199 == null) goto L133;
            int r200 = ProtoAdapter.BOOL.encodedSizeWithTag(38, r199);
        L134:
            int r201 = r198 + r200;
            Boolean r202 = r100.menable_live;
            if (r202 == null) goto L137;
            int r203 = ProtoAdapter.BOOL.encodedSizeWithTag(39, r202);
        L138:
            int r204 = (r201 + r203) + r119.asRepeated().encodedSizeWithTag(40, r100.mspeed_up_nodes);
            Boolean r205 = r100.mauto_share_screen_ccm_permission;
            if (r205 == null) goto L141;
            int r206 = ProtoAdapter.BOOL.encodedSizeWithTag(41, r205);
        L142:
            int r207 = (r204 + r206) + RTCProxy.ADAPTER.asRepeated().encodedSizeWithTag(42, r100.mrtc_proxy_list);
            ShareScreenConfirm r208 = r100.mshare_screen_confirm;
            if (r208 == null) goto L145;
            int r209 = ShareScreenConfirm.ADAPTER.encodedSizeWithTag(43, r208);
        L146:
            int r210 = r207 + r209;
            Bandwidth r211 = r100.mbandwidth;
            if (r211 == null) goto L149;
            int r212 = Bandwidth.ADAPTER.encodedSizeWithTag(44, r211);
        L150:
            int r213 = r210 + r212;
            Boolean r214 = r100.menable_local_record;
            if (r214 == null) goto L153;
            int r215 = ProtoAdapter.BOOL.encodedSizeWithTag(45, r214);
        L154:
            int r216 = r213 + r215;
            Boolean r217 = r100.menable_record_ai_summary;
            if (r217 == null) goto L157;
            int r218 = ProtoAdapter.BOOL.encodedSizeWithTag(46, r217);
        L158:
            int r219 = r216 + r218;
            Boolean r220 = r100.menable_meeting_password;
            if (r220 == null) goto L161;
            int r221 = ProtoAdapter.BOOL.encodedSizeWithTag(47, r220);
        L162:
            int r222 = r219 + r221;
            Boolean r223 = r100.mmeeting_force_record;
            if (r223 == null) goto L165;
            int r224 = ProtoAdapter.BOOL.encodedSizeWithTag(48, r223);
        L166:
            int r225 = r222 + r224;
            Boolean r226 = r100.mvoice_force_record;
            if (r226 == null) goto L169;
            int r227 = ProtoAdapter.BOOL.encodedSizeWithTag(49, r226);
        L170:
            int r228 = r225 + r227;
            Boolean r229 = r100.menable_4k_share;
            if (r229 == null) goto L173;
            int r230 = ProtoAdapter.BOOL.encodedSizeWithTag(50, r229);
        L174:
            int r231 = r228 + r230;
            Boolean r232 = r100.menable_1080p_video;
            if (r232 == null) goto L178;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(51, r232);
        L178:
            return (r231 + r102) + r100.unknownFields().size();
        L173:
            r230 = 0;
            goto L174
        L169:
            r227 = 0;
            goto L170
        L165:
            r224 = 0;
            goto L166
        L161:
            r221 = 0;
            goto L162
        L157:
            r218 = 0;
            goto L158
        L153:
            r215 = 0;
            goto L154
        L149:
            r212 = 0;
            goto L150
        L145:
            r209 = 0;
            goto L146
        L141:
            r206 = 0;
            goto L142
        L137:
            r203 = 0;
            goto L138
        L133:
            r200 = 0;
            goto L134
        L129:
            r197 = 0;
            goto L130
        L125:
            r194 = 0;
            goto L126
        L121:
            r191 = 0;
            goto L122
        L117:
            r188 = 0;
            goto L118
        L113:
            r185 = 0;
            goto L114
        L109:
            r182 = 0;
            goto L110
        L105:
            r179 = 0;
            goto L106
        L101:
            r176 = 0;
            goto L102
        L97:
            r173 = 0;
            goto L98
        L93:
            r170 = 0;
            goto L94
        L89:
            r167 = 0;
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
            r146 = 0;
            goto L62
        L57:
            r143 = 0;
            goto L58
        L53:
            r140 = 0;
            goto L54
        L49:
            r137 = 0;
            goto L50
        L45:
            r134 = 0;
            goto L46
        L41:
            r131 = 0;
            goto L42
        L37:
            r128 = 0;
            goto L38
        L33:
            r125 = 0;
            goto L34
        L29:
            r122 = 0;
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
        public /* bridge */ /* synthetic */ GetAdminSettingsResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetAdminSettingsResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetAdminSettingsResponse r101) throws IOException {
            Boolean r102 = r101.menable_record;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.menable_subtitle;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.mrecord_need_approve;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            Boolean r105 = r101.mpstn_enable_outgoing_call;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
        L14:
            Boolean r106 = r101.mpstn_hide_phone_number;
            if (r106 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r106);
        L17:
            Boolean r107 = r101.mpstn_enable_incoming_call;
            if (r107 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
        L20:
            ProtoAdapter<String> r108 = ProtoAdapter.STRING;
            r108.asRepeated().encodeWithTag(r100, 7, r101.mpstn_incoming_call_country_default);
            PSTNPhone.ADAPTER.asRepeated().encodeWithTag(r100, 8, r101.mpstn_incoming_call_phone_list);
            r108.asRepeated().encodeWithTag(r100, 9, r101.mpstn_outgoing_call_country_default);
            r108.asRepeated().encodeWithTag(r100, 10, r101.mpstn_outgoing_call_country_list);
            Boolean r109 = r101.mpstn_join_meeting_prompt;
            if (r109 == null) goto L23;
            ProtoAdapter.BOOL.encodeWithTag(r100, 11, r109);
        L23:
            Boolean r110 = r101.msip_need_encrypt;
            if (r110 == null) goto L26;
            ProtoAdapter.BOOL.encodeWithTag(r100, 12, r110);
        L26:
            String r111 = r101.msip_prompt_language;
            if (r111 == null) goto L29;
            r108.encodeWithTag(r100, 13, r111);
        L29:
            Boolean r112 = r101.msip_record_need_approve;
            if (r112 == null) goto L32;
            ProtoAdapter.BOOL.encodeWithTag(r100, 14, r112);
        L32:
            Boolean r113 = r101.msip_live_need_approve;
            if (r113 == null) goto L35;
            ProtoAdapter.BOOL.encodeWithTag(r100, 15, r113);
        L35:
            Boolean r114 = r101.msip_enable_dual_stream;
            if (r114 == null) goto L38;
            ProtoAdapter.BOOL.encodeWithTag(r100, 16, r114);
        L38:
            Boolean r115 = r101.msip_enable_im;
            if (r115 == null) goto L41;
            ProtoAdapter.BOOL.encodeWithTag(r100, 17, r115);
        L41:
            Boolean r116 = r101.msip_enable_enter_leave_prompt;
            if (r116 == null) goto L44;
            ProtoAdapter.BOOL.encodeWithTag(r100, 18, r116);
        L44:
            Boolean r117 = r101.msip_enable_show_name;
            if (r117 == null) goto L47;
            ProtoAdapter.BOOL.encodeWithTag(r100, 19, r117);
        L47:
            Integer r118 = r101.msip_default_layout;
            if (r118 == null) goto L50;
            ProtoAdapter.INT32.encodeWithTag(r100, 20, r118);
        L50:
            Integer r119 = r101.msip_video_loop_interval;
            if (r119 == null) goto L53;
            ProtoAdapter.INT32.encodeWithTag(r100, 21, r119);
        L53:
            Boolean r120 = r101.msip_enable_fecc;
            if (r120 == null) goto L56;
            ProtoAdapter.BOOL.encodeWithTag(r100, 22, r120);
        L56:
            Boolean r121 = r101.menable_meeting_background;
            if (r121 == null) goto L59;
            ProtoAdapter.BOOL.encodeWithTag(r100, 23, r121);
        L59:
            Boolean r122 = r101.menable_custom_meeting_background;
            if (r122 == null) goto L62;
            ProtoAdapter.BOOL.encodeWithTag(r100, 24, r122);
        L62:
            MeetingBackground.ADAPTER.asRepeated().encodeWithTag(r100, 25, r101.mmeeting_background_list);
            Boolean r123 = r101.menable_virtual_avatar;
            if (r123 == null) goto L65;
            ProtoAdapter.BOOL.encodeWithTag(r100, 26, r123);
        L65:
            RTCProxy r124 = r101.mrtc_proxy;
            if (r124 == null) goto L68;
            RTCProxy.ADAPTER.encodeWithTag(r100, 27, r124);
        L68:
            Boolean r125 = r101.menable_sip;
            if (r125 == null) goto L71;
            ProtoAdapter.BOOL.encodeWithTag(r100, 28, r125);
        L71:
            Boolean r126 = r101.mcan_personal_install;
            if (r126 == null) goto L74;
            ProtoAdapter.BOOL.encodeWithTag(r100, 29, r126);
        L74:
            Boolean r127 = r101.menable_check_screen_share;
            if (r127 == null) goto L77;
            ProtoAdapter.BOOL.encodeWithTag(r100, 30, r127);
        L77:
            Boolean r128 = r101.mrecord_auto_start;
            if (r128 == null) goto L80;
            ProtoAdapter.BOOL.encodeWithTag(r100, 31, r128);
        L80:
            Boolean r129 = r101.mrecord_auto_apply_start;
            if (r129 == null) goto L83;
            ProtoAdapter.BOOL.encodeWithTag(r100, 32, r129);
        L83:
            Integer r130 = r101.mjoin_group_meeting_privilege_type;
            if (r130 == null) goto L86;
            ProtoAdapter.INT32.encodeWithTag(r100, 33, r130);
        L86:
            Integer r131 = r101.mjoin_user_instant_meeting_privilege_type;
            if (r131 == null) goto L89;
            ProtoAdapter.INT32.encodeWithTag(r100, 34, r131);
        L89:
            Integer r132 = r101.mjoin_user_reserved_meeting_privilege_type;
            if (r132 == null) goto L92;
            ProtoAdapter.INT32.encodeWithTag(r100, 35, r132);
        L92:
            Boolean r133 = r101.menable_pstn_callout_scope_any;
            if (r133 == null) goto L95;
            ProtoAdapter.BOOL.encodeWithTag(r100, 36, r133);
        L95:
            Boolean r134 = r101.menable_voiceprint;
            if (r134 == null) goto L98;
            ProtoAdapter.BOOL.encodeWithTag(r100, 37, r134);
        L98:
            Boolean r135 = r101.mallow_user_change_pstn_audio_type;
            if (r135 == null) goto L101;
            ProtoAdapter.BOOL.encodeWithTag(r100, 38, r135);
        L101:
            Boolean r136 = r101.menable_live;
            if (r136 == null) goto L104;
            ProtoAdapter.BOOL.encodeWithTag(r100, 39, r136);
        L104:
            r108.asRepeated().encodeWithTag(r100, 40, r101.mspeed_up_nodes);
            Boolean r137 = r101.mauto_share_screen_ccm_permission;
            if (r137 == null) goto L107;
            ProtoAdapter.BOOL.encodeWithTag(r100, 41, r137);
        L107:
            RTCProxy.ADAPTER.asRepeated().encodeWithTag(r100, 42, r101.mrtc_proxy_list);
            ShareScreenConfirm r138 = r101.mshare_screen_confirm;
            if (r138 == null) goto L110;
            ShareScreenConfirm.ADAPTER.encodeWithTag(r100, 43, r138);
        L110:
            Bandwidth r139 = r101.mbandwidth;
            if (r139 == null) goto L113;
            Bandwidth.ADAPTER.encodeWithTag(r100, 44, r139);
        L113:
            Boolean r140 = r101.menable_local_record;
            if (r140 == null) goto L116;
            ProtoAdapter.BOOL.encodeWithTag(r100, 45, r140);
        L116:
            Boolean r141 = r101.menable_record_ai_summary;
            if (r141 == null) goto L119;
            ProtoAdapter.BOOL.encodeWithTag(r100, 46, r141);
        L119:
            Boolean r142 = r101.menable_meeting_password;
            if (r142 == null) goto L122;
            ProtoAdapter.BOOL.encodeWithTag(r100, 47, r142);
        L122:
            Boolean r143 = r101.mmeeting_force_record;
            if (r143 == null) goto L125;
            ProtoAdapter.BOOL.encodeWithTag(r100, 48, r143);
        L125:
            Boolean r144 = r101.mvoice_force_record;
            if (r144 == null) goto L128;
            ProtoAdapter.BOOL.encodeWithTag(r100, 49, r144);
        L128:
            Boolean r145 = r101.menable_4k_share;
            if (r145 == null) goto L131;
            ProtoAdapter.BOOL.encodeWithTag(r100, 50, r145);
        L131:
            Boolean r146 = r101.menable_1080p_video;
            if (r146 == null) goto L134;
            ProtoAdapter.BOOL.encodeWithTag(r100, 51, r146);
        L134:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetAdminSettingsResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetAdminSettingsResponse();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_ENABLE_RECORD = r100;
        DEFAULT_ENABLE_SUBTITLE = r100;
        DEFAULT_RECORD_NEED_APPROVE = r100;
        DEFAULT_PSTN_ENABLE_OUTGOING_CALL = r100;
        DEFAULT_PSTN_HIDE_PHONE_NUMBER = r100;
        DEFAULT_PSTN_ENABLE_INCOMING_CALL = r100;
        DEFAULT_PSTN_JOIN_MEETING_PROMPT = r100;
        DEFAULT_SIP_NEED_ENCRYPT = r100;
        DEFAULT_SIP_RECORD_NEED_APPROVE = r100;
        DEFAULT_SIP_LIVE_NEED_APPROVE = r100;
        DEFAULT_SIP_ENABLE_DUAL_STREAM = r100;
        DEFAULT_SIP_ENABLE_IM = r100;
        DEFAULT_SIP_ENABLE_ENTER_LEAVE_PROMPT = r100;
        DEFAULT_SIP_ENABLE_SHOW_NAME = r100;
        DEFAULT_SIP_DEFAULT_LAYOUT = 0;
        DEFAULT_SIP_VIDEO_LOOP_INTERVAL = 0;
        DEFAULT_SIP_ENABLE_FECC = r100;
        DEFAULT_ENABLE_MEETING_BACKGROUND = r100;
        DEFAULT_ENABLE_CUSTOM_MEETING_BACKGROUND = r100;
        DEFAULT_ENABLE_VIRTUAL_AVATAR = r100;
        DEFAULT_ENABLE_SIP = r100;
        DEFAULT_CAN_PERSONAL_INSTALL = r100;
        DEFAULT_ENABLE_CHECK_SCREEN_SHARE = r100;
        DEFAULT_RECORD_AUTO_START = r100;
        DEFAULT_RECORD_AUTO_APPLY_START = r100;
        DEFAULT_JOIN_GROUP_MEETING_PRIVILEGE_TYPE = 0;
        DEFAULT_JOIN_USER_INSTANT_MEETING_PRIVILEGE_TYPE = 0;
        DEFAULT_JOIN_USER_RESERVED_MEETING_PRIVILEGE_TYPE = 0;
        DEFAULT_ENABLE_PSTN_CALLOUT_SCOPE_ANY = r100;
        DEFAULT_ENABLE_VOICEPRINT = r100;
        DEFAULT_ALLOW_USER_CHANGE_PSTN_AUDIO_TYPE = r100;
        DEFAULT_ENABLE_LIVE = r100;
        DEFAULT_AUTO_SHARE_SCREEN_CCM_PERMISSION = r100;
        DEFAULT_ENABLE_LOCAL_RECORD = r100;
        DEFAULT_ENABLE_RECORD_AI_SUMMARY = r100;
        DEFAULT_ENABLE_MEETING_PASSWORD = r100;
        DEFAULT_MEETING_FORCE_RECORD = r100;
        DEFAULT_VOICE_FORCE_RECORD = r100;
        DEFAULT_ENABLE_4K_SHARE = r100;
        DEFAULT_ENABLE_1080P_VIDEO = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.menable_record = this.menable_record;
        r100.menable_subtitle = this.menable_subtitle;
        r100.mrecord_need_approve = this.mrecord_need_approve;
        r100.mpstn_enable_outgoing_call = this.mpstn_enable_outgoing_call;
        r100.mpstn_hide_phone_number = this.mpstn_hide_phone_number;
        r100.mpstn_enable_incoming_call = this.mpstn_enable_incoming_call;
        r100.mpstn_incoming_call_country_default = Internal.copyOf("mpstn_incoming_call_country_default", this.mpstn_incoming_call_country_default);
        r100.mpstn_incoming_call_phone_list = Internal.copyOf("mpstn_incoming_call_phone_list", this.mpstn_incoming_call_phone_list);
        r100.mpstn_outgoing_call_country_default = Internal.copyOf("mpstn_outgoing_call_country_default", this.mpstn_outgoing_call_country_default);
        r100.mpstn_outgoing_call_country_list = Internal.copyOf("mpstn_outgoing_call_country_list", this.mpstn_outgoing_call_country_list);
        r100.mpstn_join_meeting_prompt = this.mpstn_join_meeting_prompt;
        r100.msip_need_encrypt = this.msip_need_encrypt;
        r100.msip_prompt_language = this.msip_prompt_language;
        r100.msip_record_need_approve = this.msip_record_need_approve;
        r100.msip_live_need_approve = this.msip_live_need_approve;
        r100.msip_enable_dual_stream = this.msip_enable_dual_stream;
        r100.msip_enable_im = this.msip_enable_im;
        r100.msip_enable_enter_leave_prompt = this.msip_enable_enter_leave_prompt;
        r100.msip_enable_show_name = this.msip_enable_show_name;
        r100.msip_default_layout = this.msip_default_layout;
        r100.msip_video_loop_interval = this.msip_video_loop_interval;
        r100.msip_enable_fecc = this.msip_enable_fecc;
        r100.menable_meeting_background = this.menable_meeting_background;
        r100.menable_custom_meeting_background = this.menable_custom_meeting_background;
        r100.mmeeting_background_list = Internal.copyOf("mmeeting_background_list", this.mmeeting_background_list);
        r100.menable_virtual_avatar = this.menable_virtual_avatar;
        r100.mrtc_proxy = this.mrtc_proxy;
        r100.menable_sip = this.menable_sip;
        r100.mcan_personal_install = this.mcan_personal_install;
        r100.menable_check_screen_share = this.menable_check_screen_share;
        r100.mrecord_auto_start = this.mrecord_auto_start;
        r100.mrecord_auto_apply_start = this.mrecord_auto_apply_start;
        r100.mjoin_group_meeting_privilege_type = this.mjoin_group_meeting_privilege_type;
        r100.mjoin_user_instant_meeting_privilege_type = this.mjoin_user_instant_meeting_privilege_type;
        r100.mjoin_user_reserved_meeting_privilege_type = this.mjoin_user_reserved_meeting_privilege_type;
        r100.menable_pstn_callout_scope_any = this.menable_pstn_callout_scope_any;
        r100.menable_voiceprint = this.menable_voiceprint;
        r100.mallow_user_change_pstn_audio_type = this.mallow_user_change_pstn_audio_type;
        r100.menable_live = this.menable_live;
        r100.mspeed_up_nodes = Internal.copyOf("mspeed_up_nodes", this.mspeed_up_nodes);
        r100.mauto_share_screen_ccm_permission = this.mauto_share_screen_ccm_permission;
        r100.mrtc_proxy_list = Internal.copyOf("mrtc_proxy_list", this.mrtc_proxy_list);
        r100.mshare_screen_confirm = this.mshare_screen_confirm;
        r100.mbandwidth = this.mbandwidth;
        r100.menable_local_record = this.menable_local_record;
        r100.menable_record_ai_summary = this.menable_record_ai_summary;
        r100.menable_meeting_password = this.menable_meeting_password;
        r100.mmeeting_force_record = this.mmeeting_force_record;
        r100.mvoice_force_record = this.mvoice_force_record;
        r100.menable_4k_share = this.menable_4k_share;
        r100.menable_1080p_video = this.menable_1080p_video;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetAdminSettingsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetAdminSettingsResponse(Boolean r510, Boolean r511, Boolean r512, Boolean r513, Boolean r514, Boolean r515, List<String> r610, List<PSTNPhone> r611, List<String> r612, List<String> r613, Boolean r614, Boolean r615, String r616, Boolean r617, Boolean r618, Boolean r619, Boolean r710, Boolean r711, Boolean r712, Integer r713, Integer r714, Boolean r715, Boolean r716, Boolean r717, List<MeetingBackground> r718, Boolean r719, RTCProxy r810, Boolean r811, Boolean r812, Boolean r813, Boolean r814, Boolean r815, Integer r816, Integer r817, Integer r818, Boolean r819, Boolean r910, Boolean r911, Boolean r912, List<String> r913, Boolean r914, List<RTCProxy> r915, ShareScreenConfirm r916, Bandwidth r917, Boolean r918, Boolean r919, Boolean r100, Boolean r101, Boolean r102, Boolean r103, Boolean r104) {
        this(r510, r511, r512, r513, r514, r515, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711, r712, r713, r714, r715, r716, r717, r718, r719, r810, r811, r812, r813, r814, r815, r816, r817, r818, r819, r910, r911, r912, r913, r914, r915, r916, r917, r918, r919, r100, r101, r102, r103, r104, ByteString.EMPTY);
    }

    public GetAdminSettingsResponse(Boolean r100, Boolean r101, Boolean r102, Boolean r103, Boolean r104, Boolean r105, List<String> r110, List<PSTNPhone> r111, List<String> r112, List<String> r113, Boolean r114, Boolean r115, String r116, Boolean r117, Boolean r118, Boolean r119, Boolean r210, Boolean r211, Boolean r212, Integer r213, Integer r214, Boolean r215, Boolean r216, Boolean r217, List<MeetingBackground> r218, Boolean r219, RTCProxy r310, Boolean r311, Boolean r312, Boolean r313, Boolean r314, Boolean r315, Integer r316, Integer r317, Integer r318, Boolean r319, Boolean r410, Boolean r411, Boolean r412, List<String> r413, Boolean r414, List<RTCProxy> r415, ShareScreenConfirm r416, Bandwidth r417, Boolean r418, Boolean r419, Boolean r510, Boolean r511, Boolean r512, Boolean r513, Boolean r514, ByteString r515) {
        super(ADAPTER, r515);
        this.menable_record = r100;
        this.menable_subtitle = r101;
        this.mrecord_need_approve = r102;
        this.mpstn_enable_outgoing_call = r103;
        this.mpstn_hide_phone_number = r104;
        this.mpstn_enable_incoming_call = r105;
        this.mpstn_incoming_call_country_default = Internal.immutableCopyOf("mpstn_incoming_call_country_default", r110);
        this.mpstn_incoming_call_phone_list = Internal.immutableCopyOf("mpstn_incoming_call_phone_list", r111);
        this.mpstn_outgoing_call_country_default = Internal.immutableCopyOf("mpstn_outgoing_call_country_default", r112);
        this.mpstn_outgoing_call_country_list = Internal.immutableCopyOf("mpstn_outgoing_call_country_list", r113);
        this.mpstn_join_meeting_prompt = r114;
        this.msip_need_encrypt = r115;
        this.msip_prompt_language = r116;
        this.msip_record_need_approve = r117;
        this.msip_live_need_approve = r118;
        this.msip_enable_dual_stream = r119;
        this.msip_enable_im = r210;
        this.msip_enable_enter_leave_prompt = r211;
        this.msip_enable_show_name = r212;
        this.msip_default_layout = r213;
        this.msip_video_loop_interval = r214;
        this.msip_enable_fecc = r215;
        this.menable_meeting_background = r216;
        this.menable_custom_meeting_background = r217;
        this.mmeeting_background_list = Internal.immutableCopyOf("mmeeting_background_list", r218);
        this.menable_virtual_avatar = r219;
        this.mrtc_proxy = r310;
        this.menable_sip = r311;
        this.mcan_personal_install = r312;
        this.menable_check_screen_share = r313;
        this.mrecord_auto_start = r314;
        this.mrecord_auto_apply_start = r315;
        this.mjoin_group_meeting_privilege_type = r316;
        this.mjoin_user_instant_meeting_privilege_type = r317;
        this.mjoin_user_reserved_meeting_privilege_type = r318;
        this.menable_pstn_callout_scope_any = r319;
        this.menable_voiceprint = r410;
        this.mallow_user_change_pstn_audio_type = r411;
        this.menable_live = r412;
        this.mspeed_up_nodes = Internal.immutableCopyOf("mspeed_up_nodes", r413);
        this.mauto_share_screen_ccm_permission = r414;
        this.mrtc_proxy_list = Internal.immutableCopyOf("mrtc_proxy_list", r415);
        this.mshare_screen_confirm = r416;
        this.mbandwidth = r417;
        this.menable_local_record = r418;
        this.menable_record_ai_summary = r419;
        this.menable_meeting_password = r510;
        this.mmeeting_force_record = r511;
        this.mvoice_force_record = r512;
        this.menable_4k_share = r513;
        this.menable_1080p_video = r514;
    }
}
