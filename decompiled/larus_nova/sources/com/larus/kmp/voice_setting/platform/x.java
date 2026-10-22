package com.larus.kmp.voice_setting.platform;

import android.content.Context;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import java.util.Arrays;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes30.dex */
public final class x {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f351738a = null;

        static {
            int[] r100 = new int[VoiceStringKey.values().length];
            r100[VoiceStringKey.LARUS_ASR_INTERRUPTED_BY_APP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L99
        L225:
            r100[VoiceStringKey.LARUS_AUDIO_ADJUST_TAG_DEFAULT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L100
        L241:
            r100[VoiceStringKey.LARUS_BOT_BAN_UNDER_REVIEW.ordinal()] = 3;     // Catch: NoSuchFieldError -> L101
        L255:
            r100[VoiceStringKey.LARUS_BOT_SETTING_VOICE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L102
        L261:
            r100[VoiceStringKey.LARUS_BOT_SETTING_VOICE_USE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L103
        L271:
            r100[VoiceStringKey.LARUS_BOTVOICE_TOAST_BG_PLAYBACK_OFF.ordinal()] = 6;     // Catch: NoSuchFieldError -> L104
        L285:
            r100[VoiceStringKey.LARUS_BOTVOICE_TOAST_BG_PLAYBACK_ON.ordinal()] = 7;     // Catch: NoSuchFieldError -> L105
        L307:
            r100[VoiceStringKey.LARUS_BOTVOICE_TOGGLE_HEADER_BG_PLAYBACK.ordinal()] = 8;     // Catch: NoSuchFieldError -> L106
        L323:
            r100[VoiceStringKey.LARUS_BOT_UPLOAD_PROFILE_PIC_FAILED.ordinal()] = 9;     // Catch: NoSuchFieldError -> L107
        L327:
            r100[VoiceStringKey.LARUS_BOT_BAN_NOTICE_CONFIRM.ordinal()] = 10;     // Catch: NoSuchFieldError -> L108
        L341:
            r100[VoiceStringKey.LARUS_BOT_VOICE_EMPTY_MESSAGE.ordinal()] = 11;     // Catch: NoSuchFieldError -> L109
        L363:
            r100[VoiceStringKey.LARUS_BOT_VOICE_NOT_AVAILABLE.ordinal()] = 12;     // Catch: NoSuchFieldError -> L110
        L379:
            r100[VoiceStringKey.LARUS_BOTSCOMMENT_COMMENTPANEL_TOAST_SCROLLFAIL.ordinal()] = 13;     // Catch: NoSuchFieldError -> L111
        L195:
            r100[VoiceStringKey.LARUS_CLICK_CREATE_VOICE3.ordinal()] = 14;     // Catch: NoSuchFieldError -> L112
        L209:
            r100[VoiceStringKey.LARUS_CLONE_VOCIE_TOO_SHORT_TOAST.ordinal()] = 15;     // Catch: NoSuchFieldError -> L113
        L235:
            r100[VoiceStringKey.LARUS_CREATE_BOT.ordinal()] = 16;     // Catch: NoSuchFieldError -> L114
        L253:
            r100[VoiceStringKey.LARUS_CREATE_BOT_DONE.ordinal()] = 17;     // Catch: NoSuchFieldError -> L115
        L259:
            r100[VoiceStringKey.LARUS_CREATE_BOT_SETTINGS_SOUND_POPUP_ERROR_MSG.ordinal()] = 18;     // Catch: NoSuchFieldError -> L116
        L275:
            r100[VoiceStringKey.LARUS_CREATE_BOTVOICE_TAG.ordinal()] = 19;     // Catch: NoSuchFieldError -> L117
        L297:
            r100[VoiceStringKey.LARUS_DELETE_BOT_DOUBLE_CONFIRMATION_CANCEL.ordinal()] = 20;     // Catch: NoSuchFieldError -> L118
        L311:
            r100[VoiceStringKey.LARUS_DELETE_BOT_DOUBLE_CONFIRMATION_DELETE.ordinal()] = 21;     // Catch: NoSuchFieldError -> L119
        L315:
            r100[VoiceStringKey.LARUS_CLEAR_MIXED_SOUND.ordinal()] = 22;     // Catch: NoSuchFieldError -> L120
        L331:
            r100[VoiceStringKey.LARUS_CLEAR_MIXED_SOUND_CONFIRM.ordinal()] = 23;     // Catch: NoSuchFieldError -> L121
        L353:
            r100[VoiceStringKey.LARUS_DELETE_VOICE_TEXT.ordinal()] = 24;     // Catch: NoSuchFieldError -> L122
        L367:
            r100[VoiceStringKey.LARUS_DELETE_VOICE_TITLE.ordinal()] = 25;     // Catch: NoSuchFieldError -> L123
        L371:
            r100[VoiceStringKey.LARUS_DISABLE_VOICE_LIMIT.ordinal()] = 26;     // Catch: NoSuchFieldError -> L124
        L199:
            r100[VoiceStringKey.LARUS_FEEDBACK_HISTORY_USER.ordinal()] = 27;     // Catch: NoSuchFieldError -> L125
        L223:
            r100[VoiceStringKey.LARUS_HOLD_TO_RECORD.ordinal()] = 28;     // Catch: NoSuchFieldError -> L126
        L239:
            r100[VoiceStringKey.LARUS_HOLD_TO_RECORD_NOTE.ordinal()] = 29;     // Catch: NoSuchFieldError -> L127
        L245:
            r100[VoiceStringKey.LARUS_HOLD_TO_SPEAK_NOTE.ordinal()] = 30;     // Catch: NoSuchFieldError -> L128
        L263:
            r100[VoiceStringKey.LARUS_RELEASE_TO_CANCEL.ordinal()] = 31;     // Catch: NoSuchFieldError -> L129
        L287:
            r100[VoiceStringKey.LARUS_MEMO_RECORDING_DENY_ACTIONS_ERROR_TOAST.ordinal()] = 32;     // Catch: NoSuchFieldError -> L130
        L299:
            r100[VoiceStringKey.LARUS_MIXED_SOUND.ordinal()] = 33;     // Catch: NoSuchFieldError -> L131
        L301:
            r100[VoiceStringKey.LARUS_MIXVOICE_TITLE_SELECTVOICE.ordinal()] = 34;     // Catch: NoSuchFieldError -> L132
        L317:
            r100[VoiceStringKey.LARUS_MODIFY_BOT_VOICE_BOT_CLONE_VOICE_BTN2.ordinal()] = 35;     // Catch: NoSuchFieldError -> L133
        L343:
            r100[VoiceStringKey.LARUS_MODIFY_BOT_VOICE_BOT_MODAL_BODY.ordinal()] = 36;     // Catch: NoSuchFieldError -> L134
        L355:
            r100[VoiceStringKey.LARUS_MODIFY_BOT_VOICE_BOT_SETTINGS_SECTION_SOUND.ordinal()] = 37;     // Catch: NoSuchFieldError -> L135
        L357:
            r100[VoiceStringKey.LARUS_MODIFY_BOT_VOICE_BOT_TOAST.ordinal()] = 38;     // Catch: NoSuchFieldError -> L136
        L373:
            r100[VoiceStringKey.LARUS_MODIFY_BOT_VOICE_BOT_TOAST2.ordinal()] = 39;     // Catch: NoSuchFieldError -> L137
        L211:
            r100[VoiceStringKey.LARUS_MODIFY_BOT_VOICE_BOT_VOICE_CARD_SLIDER_HEADER1.ordinal()] = 40;     // Catch: NoSuchFieldError -> L138
        L227:
            r100[VoiceStringKey.LARUS_MODIFY_BOT_VOICE_BOT_VOICE_CARD_SLIDER_HEADER2.ordinal()] = 41;     // Catch: NoSuchFieldError -> L139
        L229:
            r100[VoiceStringKey.LARUS_MODIFY_BOT_VOICE_CANCEL_BTN.ordinal()] = 42;     // Catch: NoSuchFieldError -> L140
        L247:
            r100[VoiceStringKey.LARUS_MODIFY_BOT_VOICE_EMPTY.ordinal()] = 43;     // Catch: NoSuchFieldError -> L141
        L277:
            r100[VoiceStringKey.LARUS_MODIFY_BOT_VOICE_FAILED_TOAST.ordinal()] = 44;     // Catch: NoSuchFieldError -> L142
        L289:
            r100[VoiceStringKey.LARUS_MUTED_VOICE.ordinal()] = 45;     // Catch: NoSuchFieldError -> L143
        L291:
            r100[VoiceStringKey.LARUS_NETWORK_ERROR.ordinal()] = 46;     // Catch: NoSuchFieldError -> L144
        L303:
            r100[VoiceStringKey.LARUS_NO_PUBLIC_VOICE.ordinal()] = 47;     // Catch: NoSuchFieldError -> L145
        L333:
            r100[VoiceStringKey.LARUS_PLAY_MIXED_SOUND.ordinal()] = 48;     // Catch: NoSuchFieldError -> L146
        L345:
            r100[VoiceStringKey.LARUS_TAG_FOR_YOU.ordinal()] = 49;     // Catch: NoSuchFieldError -> L147
        L347:
            r100[VoiceStringKey.LARUS_TABS_PROFILE.ordinal()] = 50;     // Catch: NoSuchFieldError -> L148
        L359:
            r100[VoiceStringKey.LARUS_UGC_VOICE_ALL.ordinal()] = 51;     // Catch: NoSuchFieldError -> L149
        L201:
            r100[VoiceStringKey.LARUS_UGC_VOICE_DEMO.ordinal()] = 52;     // Catch: NoSuchFieldError -> L150
        L215:
            r100[VoiceStringKey.LARUS_UGC_VOICE_EDIT.ordinal()] = 53;     // Catch: NoSuchFieldError -> L151
        L217:
            r100[VoiceStringKey.LARUS_UGC_VOICE_FINISH.ordinal()] = 54;     // Catch: NoSuchFieldError -> L152
        L231:
            r100[VoiceStringKey.LARUS_UGC_VOICE_ME.ordinal()] = 55;     // Catch: NoSuchFieldError -> L153
        L265:
            r100[VoiceStringKey.LARUS_UGC_VOICE_MYSELF_ONLY.ordinal()] = 56;     // Catch: NoSuchFieldError -> L154
        L279:
            r100[VoiceStringKey.LARUS_UGC_VOICE_NONE_VOICE.ordinal()] = 57;     // Catch: NoSuchFieldError -> L155
        L281:
            r100[VoiceStringKey.LARUS_UGC_VOICE_PROCESS.ordinal()] = 58;     // Catch: NoSuchFieldError -> L156
        L293:
            r100[VoiceStringKey.LARUS_UGC_VOICE_RELEASE.ordinal()] = 59;     // Catch: NoSuchFieldError -> L157
        L319:
            r100[VoiceStringKey.LARUS_UGC_VOICE_RETRY_1.ordinal()] = 60;     // Catch: NoSuchFieldError -> L158
        L335:
            r100[VoiceStringKey.LARUS_UGC_VOICE_RETRY_2.ordinal()] = 61;     // Catch: NoSuchFieldError -> L159
        L337:
            r100[VoiceStringKey.LARUS_UGC_VOICE_WHO_USE.ordinal()] = 62;     // Catch: NoSuchFieldError -> L160
        L349:
            r100[VoiceStringKey.LARUS_UNSUPPORTED_FORMAT.ordinal()] = 63;     // Catch: NoSuchFieldError -> L161
        L375:
            r100[VoiceStringKey.LARUS_UPDATE_FAILED_COMMON.ordinal()] = 64;     // Catch: NoSuchFieldError -> L162
        L203:
            r100[VoiceStringKey.LARUS_VOICE_CREATION_AUTHORIZATION_1.ordinal()] = 65;     // Catch: NoSuchFieldError -> L163
        L205:
            r100[VoiceStringKey.LARUS_VOICE_CREATION_AUTHORIZATION_2.ordinal()] = 66;     // Catch: NoSuchFieldError -> L164
        L219:
            r100[VoiceStringKey.LARUS_VOICE_CREATION_AUTHORIZATION_3.ordinal()] = 67;     // Catch: NoSuchFieldError -> L165
        L249:
            r100[VoiceStringKey.LARUS_VOICE_CREATION_AUTHORIZATION_4.ordinal()] = 68;     // Catch: NoSuchFieldError -> L166
        L267:
            r100[VoiceStringKey.LARUS_VOICE_CREATION_AUTHORIZATION_5.ordinal()] = 69;     // Catch: NoSuchFieldError -> L167
        L269:
            r100[VoiceStringKey.LARUS_VOICE_CREATION_AUTHORIZATION_6.ordinal()] = 70;     // Catch: NoSuchFieldError -> L168
        L283:
            r100[VoiceStringKey.LARUS_VOICE_CREATION_AUTHORIZATION_CONFIRM.ordinal()] = 71;     // Catch: NoSuchFieldError -> L169
        L305:
            r100[VoiceStringKey.LARUS_VOICE_CREATION_AUTHORIZATION_TITLE.ordinal()] = 72;     // Catch: NoSuchFieldError -> L170
        L321:
            r100[VoiceStringKey.LARUS_VOICE_CREATION_DEFAULT_NAMING_A.ordinal()] = 73;     // Catch: NoSuchFieldError -> L171
        L325:
            r100[VoiceStringKey.LARUS_VOICE_CREATION_FAILED.ordinal()] = 74;     // Catch: NoSuchFieldError -> L172
        L339:
            r100[VoiceStringKey.LARUS_VOICE_CREATION_READ_TITLE.ordinal()] = 75;     // Catch: NoSuchFieldError -> L173
        L361:
            r100[VoiceStringKey.LARUS_VOICE_CREATION_RECORD_TEXT_1.ordinal()] = 76;     // Catch: NoSuchFieldError -> L174
        L377:
            r100[VoiceStringKey.LARUS_VOICE_CREATION_RECORD_TITLE.ordinal()] = 77;     // Catch: NoSuchFieldError -> L175
        L193:
            r100[VoiceStringKey.LARUS_VOICE_CREATION_VERIFYING_FAILED.ordinal()] = 78;     // Catch: NoSuchFieldError -> L176
        L207:
            r100[VoiceStringKey.LARUS_VOICE_CREATION_VERIFYING_TITLE.ordinal()] = 79;     // Catch: NoSuchFieldError -> L177
        L233:
            r100[VoiceStringKey.LARUS_VOICE_DELETE_FAILED.ordinal()] = 80;     // Catch: NoSuchFieldError -> L178
        L251:
            r100[VoiceStringKey.LARUS_VOICE_EDIT_FAILED.ordinal()] = 81;     // Catch: NoSuchFieldError -> L179
        L257:
            r100[VoiceStringKey.LARUS_VOICE_EDIT_NAME.ordinal()] = 82;     // Catch: NoSuchFieldError -> L180
        L273:
            r100[VoiceStringKey.LARUS_VOICEGEN_TA_AIGEN_CN.ordinal()] = 83;     // Catch: NoSuchFieldError -> L181
        L295:
            r100[VoiceStringKey.LARUS_VOICE_IN_MODERATION.ordinal()] = 84;     // Catch: NoSuchFieldError -> L182
        L309:
            r100[VoiceStringKey.LARUS_VOICE_IN_MODERATION_MESSAGE.ordinal()] = 85;     // Catch: NoSuchFieldError -> L183
        L313:
            r100[VoiceStringKey.LARUS_VOICE_OPEN_WARNING.ordinal()] = 86;     // Catch: NoSuchFieldError -> L184
        L329:
            r100[VoiceStringKey.LARUS_VOICE_UNAVAILABLE.ordinal()] = 87;     // Catch: NoSuchFieldError -> L185
        L351:
            r100[VoiceStringKey.LARUS_VOICE_UNAVAILABLE_MESSAGE.ordinal()] = 88;     // Catch: NoSuchFieldError -> L186
        L365:
            r100[VoiceStringKey.LARUS_VOICE_UPDATE_SUCCESS_TOAST.ordinal()] = 89;     // Catch: NoSuchFieldError -> L187
        L369:
            r100[VoiceStringKey.LARUS_VOICE_UPDATE_FAIL_TOAST.ordinal()] = 90;     // Catch: NoSuchFieldError -> L188
        L197:
            r100[VoiceStringKey.LARUS_VOICE_CREATING.ordinal()] = 91;     // Catch: NoSuchFieldError -> L189
        L221:
            r100[VoiceStringKey.LARUS_VOICENAME_IN_MODERATION.ordinal()] = 92;     // Catch: NoSuchFieldError -> L190
        L237:
            r100[VoiceStringKey.LARUS_VOICENAME_UNAVAILABLE.ordinal()] = 93;     // Catch: NoSuchFieldError -> L191
        L243:
            r100[VoiceStringKey.LARUS_VOICENAME_UNAVAILABLE_MESSAGE.ordinal()] = 94;     // Catch: NoSuchFieldError -> L192
        L97:
            f351738a = r100;
        }
    }

    public static final int c(VoiceStringKey r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        switch(a.f351738a[r100.ordinal()]) {
            case 1: goto L99;
            case 2: goto L98;
            case 3: goto L97;
            case 4: goto L96;
            case 5: goto L95;
            case 6: goto L94;
            case 7: goto L93;
            case 8: goto L92;
            case 9: goto L91;
            case 10: goto L90;
            case 11: goto L89;
            case 12: goto L88;
            case 13: goto L87;
            case 14: goto L86;
            case 15: goto L85;
            case 16: goto L84;
            case 17: goto L83;
            case 18: goto L82;
            case 19: goto L81;
            case 20: goto L80;
            case 21: goto L79;
            case 22: goto L78;
            case 23: goto L77;
            case 24: goto L76;
            case 25: goto L75;
            case 26: goto L74;
            case 27: goto L73;
            case 28: goto L72;
            case 29: goto L71;
            case 30: goto L70;
            case 31: goto L69;
            case 32: goto L68;
            case 33: goto L67;
            case 34: goto L66;
            case 35: goto L65;
            case 36: goto L64;
            case 37: goto L63;
            case 38: goto L62;
            case 39: goto L61;
            case 40: goto L60;
            case 41: goto L59;
            case 42: goto L58;
            case 43: goto L57;
            case 44: goto L56;
            case 45: goto L55;
            case 46: goto L54;
            case 47: goto L53;
            case 48: goto L52;
            case 49: goto L51;
            case 50: goto L50;
            case 51: goto L49;
            case 52: goto L48;
            case 53: goto L47;
            case 54: goto L46;
            case 55: goto L45;
            case 56: goto L44;
            case 57: goto L43;
            case 58: goto L42;
            case 59: goto L41;
            case 60: goto L40;
            case 61: goto L39;
            case 62: goto L38;
            case 63: goto L37;
            case 64: goto L36;
            case 65: goto L35;
            case 66: goto L34;
            case 67: goto L33;
            case 68: goto L32;
            case 69: goto L31;
            case 70: goto L30;
            case 71: goto L29;
            case 72: goto L28;
            case 73: goto L27;
            case 74: goto L26;
            case 75: goto L25;
            case 76: goto L24;
            case 77: goto L23;
            case 78: goto L22;
            case 79: goto L21;
            case 80: goto L20;
            case 81: goto L19;
            case 82: goto L18;
            case 83: goto L17;
            case 84: goto L16;
            case 85: goto L15;
            case 86: goto L14;
            case 87: goto L13;
            case 88: goto L12;
            case 89: goto L11;
            case 90: goto L10;
            case 91: goto L9;
            case 92: goto L8;
            case 93: goto L7;
            case 94: goto L6;
            default: goto L5;
        };
    L6:
        return R.string.larus_voicename_unavailable_message;
    L7:
        return R.string.larus_voicename_unavailable;
    L8:
        return R.string.larus_voicename_in_moderation;
    L9:
        return R.string.larus_voice_creating;
    L10:
        return R.string.larus_voice_update_fail_toast;
    L11:
        return R.string.larus_voice_update_success_toast;
    L12:
        return R.string.larus_voice_unavailable_message;
    L13:
        return R.string.larus_voice_unavailable;
    L14:
        return R.string.larus_Voice_open_warning;
    L15:
        return R.string.larus_voice_in_moderation_message;
    L16:
        return R.string.larus_voice_in_moderation;
    L17:
        return R.string.larus_voiceGen_ta_aiGen_cn;
    L18:
        return R.string.larus_voice_edit_name;
    L19:
        return R.string.larus_voice_edit_failed;
    L20:
        return R.string.larus_voice_delete_failed;
    L21:
        return R.string.larus_voice_creation__Verifying_title;
    L22:
        return R.string.larus_voice_creation__Verifying_failed;
    L23:
        return R.string.larus_voice_creation_record_title;
    L24:
        return R.string.larus_voice_creation_record_text_1;
    L25:
        return R.string.larus_voice_creation_read_title;
    L26:
        return R.string.larus_voice_creation_failed;
    L27:
        return R.string.larus_voice_creation_default_naming_a;
    L28:
        return R.string.larus_voice_creation_authorization_title;
    L29:
        return R.string.larus_voice_creation_authorization_confirm;
    L30:
        return R.string.larus_voice_creation_authorization_6;
    L31:
        return R.string.larus_voice_creation_authorization_5;
    L32:
        return R.string.larus_voice_creation_authorization_4;
    L33:
        return R.string.larus_voice_creation_authorization_3;
    L34:
        return R.string.larus_voice_creation_authorization_2;
    L35:
        return R.string.larus_voice_creation_authorization_1;
    L36:
        return R.string.larus_update_failed_common;
    L37:
        return R.string.larus_unsupported_format;
    L38:
        return R.string.larus_ugc_voice_who_use;
    L39:
        return R.string.larus_ugc_voice_retry_2;
    L40:
        return R.string.larus_ugc_voice_retry_1;
    L41:
        return R.string.larus_ugc_voice_release;
    L42:
        return R.string.larus_ugc_voice_process;
    L43:
        return R.string.larus_ugc_voice_none_voice;
    L44:
        return R.string.larus_ugc_voice_myself_only;
    L45:
        return R.string.larus_ugc_voice_me;
    L46:
        return R.string.larus_ugc_voice_finish;
    L47:
        return R.string.larus_ugc_voice_edit;
    L48:
        return R.string.larus_ugc_voice_demo;
    L49:
        return R.string.larus_ugc_voice_all;
    L50:
        return R.string.larus_tabs_profile;
    L51:
        return R.string.larus_tag_for_you;
    L52:
        return R.string.larus_play_mixed_sound;
    L53:
        return R.string.larus_No_public_voice;
    L54:
        return R.string.larus_network_error;
    L55:
        return R.string.larus_muted_voice;
    L56:
        return R.string.larus_modify_bot_voice_failed_toast;
    L57:
        return R.string.larus_modify_bot_voice_empty;
    L58:
        return R.string.larus_modify_bot_voice_cancel_btn;
    L59:
        return R.string.larus_modify_bot_voice_bot_voice_card_slider_header2;
    L60:
        return R.string.larus_modify_bot_voice_bot_voice_card_slider_header1;
    L61:
        return R.string.larus_modify_bot_voice_bot_toast2;
    L62:
        return R.string.larus_modify_bot_voice_bot_toast;
    L63:
        return R.string.larus_modify_bot_voice_bot_settings_section_sound;
    L64:
        return R.string.larus_modify_bot_voice_bot_modal_body;
    L65:
        return R.string.larus_modify_bot_voice_bot_clone_voice_btn2;
    L66:
        return R.string.larus_mixVoice_title_selectVoice;
    L67:
        return R.string.larus_mixed_sound;
    L68:
        return R.string.larus_memo_recording_deny_actions_error_toast;
    L69:
        return R.string.larus_release_to_cancel;
    L70:
        return R.string.larus_hold_to_speak_note;
    L71:
        return R.string.larus_hold_to_record_note;
    L72:
        return R.string.larus_hold_to_record;
    L73:
        return R.string.larus_feedback_history_user;
    L74:
        return R.string.larus_disable_voice_limit;
    L75:
        return R.string.larus_delete_voice_title;
    L76:
        return R.string.larus_delete_voice_text;
    L77:
        return R.string.larus_delete_mixed_sound_confirm;
    L78:
        return R.string.larus_delete_mixed_sound;
    L79:
        return R.string.larus_delete_bot_double_confirmation_delete;
    L80:
        return R.string.larus_delete_bot_double_confirmation_cancel;
    L81:
        return R.string.larus_create_botvoice_tag;
    L82:
        return R.string.larus_create_bot_settings_sound_popup_error_msg;
    L83:
        return R.string.larus_create_bot_done;
    L84:
        return R.string.larus_create_bot;
    L85:
        return R.string.larus_clone_vocie_too_short_toast;
    L86:
        return R.string.larus_Click_create_voice3;
    L87:
        return R.string.larus_botsComment_commentPanel_toast_scrollFail;
    L88:
        return R.string.larus_bot_voice_not_available;
    L89:
        return R.string.larus_bot_voice_empty_message;
    L90:
        return R.string.larus_bot_ban_notice_confirm;
    L91:
        return R.string.larus_bot_upload_profile_pic_failed;
    L92:
        return R.string.larus_botVoice_toggleHeader_bgPlayback;
    L93:
        return R.string.larus_botVoice_toast_bgPlaybackOn;
    L94:
        return R.string.larus_botVoice_toast_bgPlaybackOff;
    L95:
        return R.string.larus_bot_setting_voice_use;
    L96:
        return R.string.larus_bot_setting_voice;
    L97:
        return R.string.larus_bot_ban_under_review;
    L98:
        return R.string.larus_audio_adjust_tag_default;
    L99:
        return R.string.larus_asr_interrupted_by_app;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public static final String b(VoiceStringKey r100, Object... r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "args");
        AppHost.Companion r102 = AppHost.f326268a;
        Context r103 = r102.a().getCurrentActivity();
        if (r103 != null) goto L7;
        r103 = r102.getApplication();
    L7:
        return a(r103, r100, Arrays.copyOf(r101, r101.length));
    }

    public static final String a(Context r100, VoiceStringKey r101, Object... r102) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "args");
        boolean r103 = true;
        if (r100 != null) goto L106;
        final Object[] r104 = Arrays.copyOf(r102, r102.length);
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r104, "args");
        switch(x0.f351739a[r101.ordinal()]) {
            case 1: goto L96;
            case 2: goto L95;
            case 3: goto L94;
            case 4: goto L93;
            case 5: goto L92;
            case 6: goto L91;
            case 7: goto L90;
            case 8: goto L89;
            case 9: goto L88;
            case 10: goto L87;
            case 11: goto L86;
            case 12: goto L85;
            case 13: goto L84;
            case 14: goto L83;
            case 15: goto L82;
            case 16: goto L81;
            case 17: goto L80;
            case 18: goto L79;
            case 19: goto L78;
            case 20: goto L77;
            case 21: goto L76;
            case 22: goto L75;
            case 23: goto L74;
            case 24: goto L73;
            case 25: goto L72;
            case 26: goto L71;
            case 27: goto L70;
            case 28: goto L69;
            case 29: goto L68;
            case 30: goto L67;
            case 31: goto L66;
            case 32: goto L65;
            case 33: goto L64;
            case 34: goto L63;
            case 35: goto L62;
            case 36: goto L61;
            case 37: goto L93;
            case 38: goto L60;
            case 39: goto L59;
            case 40: goto L58;
            case 41: goto L57;
            case 42: goto L77;
            case 43: goto L56;
            case 44: goto L55;
            case 45: goto L54;
            case 46: goto L53;
            case 47: goto L52;
            case 48: goto L51;
            case 49: goto L50;
            case 50: goto L49;
            case 51: goto L48;
            case 52: goto L47;
            case 53: goto L46;
            case 54: goto L45;
            case 55: goto L44;
            case 56: goto L43;
            case 57: goto L56;
            case 58: goto L42;
            case 59: goto L41;
            case 60: goto L40;
            case 61: goto L39;
            case 62: goto L38;
            case 63: goto L37;
            case 64: goto L36;
            case 65: goto L35;
            case 66: goto L34;
            case 67: goto L33;
            case 68: goto L32;
            case 69: goto L31;
            case 70: goto L30;
            case 71: goto L29;
            case 72: goto L28;
            case 73: goto L27;
            case 74: goto L26;
            case 75: goto L25;
            case 76: goto L24;
            case 77: goto L23;
            case 78: goto L22;
            case 79: goto L21;
            case 80: goto L20;
            case 81: goto L19;
            case 82: goto L18;
            case 83: goto L17;
            case 84: goto L94;
            case 85: goto L16;
            case 86: goto L15;
            case 87: goto L85;
            case 88: goto L14;
            case 89: goto L13;
            case 90: goto L12;
            case 91: goto L11;
            case 92: goto L10;
            case 93: goto L9;
            case 94: goto L8;
            default: goto L7;
        };
    L8:
        String r105 = "名称不可用，请修改后重试";
    L98:
        if (r104.length == 0) goto L101;
        r103 = false;
    L101:
        if (r103 == true) goto L113;
        final Ref.IntRef r106 = new Ref.IntRef();
        return new Regex("%(?:\\d+\\$)?[a-zA-Z]").replace(r105, new w0(r104, r106));
    L113:
        return r105;
    L9:
        r105 = "名称不可用";
        goto L98
    L10:
        r105 = "名称审核中";
        goto L98
    L11:
        r105 = "生成中";
        goto L98
    L12:
        r105 = "声音更新失败，请重试";
        goto L98
    L13:
        r105 = "更新成功";
        goto L98
    L14:
        r105 = "环境嘈杂，请重新录制";
        goto L98
    L15:
        r105 = "公开后其他用户可使用该声音";
        goto L98
    L16:
        r105 = "声音审核中，请稍后再试";
        goto L98
    L17:
        r105 = "AI 生成";
        goto L98
    L18:
        r105 = "编辑名称";
        goto L98
    L19:
        r105 = "编辑失败";
        goto L98
    L20:
        r105 = "删除失败";
        goto L98
    L21:
        r105 = "验证中";
        goto L98
    L22:
        r105 = "验证失败";
        goto L98
    L23:
        r105 = "录音中，请朗读...";
        goto L98
    L24:
        r105 = "请朗读这段文字，用自然的语气完成录音。";
        goto L98
    L25:
        r105 = "朗读文本";
        goto L98
    L26:
        r105 = "声音创建失败";
        goto L98
    L27:
        r105 = "我的声音";
        goto L98
    L28:
        r105 = "声音创建授权";
        goto L98
    L29:
        r105 = "同意并继续";
        goto L98
    L30:
        r105 = "继续即表示你同意以上内容";
        goto L98
    L31:
        r105 = "违规声音可能无法使用";
        goto L98
    L32:
        r105 = "生成内容可能需要审核";
        goto L98
    L33:
        r105 = "请遵守平台规范";
        goto L98
    L34:
        r105 = "请勿上传他人声音";
        goto L98
    L35:
        r105 = "请确认你已获得授权";
        goto L98
    L36:
        r105 = "更新失败，请重试";
        goto L98
    L37:
        r105 = "不支持的格式";
        goto L98
    L38:
        r105 = "谁可以使用";
        goto L98
    L39:
        r105 = "重新录制";
        goto L98
    L40:
        r105 = "重试";
        goto L98
    L41:
        r105 = "发布";
        goto L98
    L42:
        r105 = "处理中";
        goto L98
    L43:
        r105 = "仅你可用";
        goto L98
    L44:
        r105 = "仅自己";
        goto L98
    L45:
        r105 = "声音创建完成";
        goto L98
    L46:
        r105 = "发布失败，请修改信息";
        goto L98
    L47:
        r105 = "试听";
        goto L98
    L48:
        r105 = "所有人可用";
        goto L98
    L49:
        r105 = "我的";
        goto L98
    L50:
        r105 = "推荐";
        goto L98
    L51:
        r105 = "播放混合声音";
        goto L98
    L52:
        r105 = "暂无公开的声音";
        goto L98
    L53:
        r105 = "网络异常，请稍后重试";
        goto L98
    L54:
        r105 = "无声音";
        goto L98
    L55:
        r105 = "声音修改失败，请重试";
        goto L98
    L56:
        r105 = "暂无声音";
        goto L98
    L57:
        r105 = "音调";
        goto L98
    L58:
        r105 = "语速";
        goto L98
    L59:
        r105 = "请选择声音";
        goto L98
    L60:
        r105 = "已达到声音数量上限";
        goto L98
    L61:
        r105 = "修改后将应用到当前智能体";
        goto L98
    L62:
        r105 = "创建声音";
        goto L98
    L63:
        r105 = "从下方选择最多 %s 个声音";
        goto L98
    L64:
        r105 = "混合声音";
        goto L98
    L65:
        r105 = "当前无法录音";
        goto L98
    L66:
        r105 = "松开取消";
        goto L98
    L67:
        r105 = "按住说话";
        goto L98
    L68:
        r105 = "按住开始录音";
        goto L98
    L69:
        r105 = "按住录音";
        goto L98
    L70:
        r105 = "用户";
        goto L98
    L71:
        r105 = "当前声音不可用";
        goto L98
    L72:
        r105 = "确认删除声音？";
        goto L98
    L73:
        r105 = "删除后，该声音将不可恢复";
        goto L98
    L74:
        r105 = "清空";
        goto L98
    L75:
        r105 = "确定要清空所有声音？";
        goto L98
    L76:
        r105 = "删除";
        goto L98
    L77:
        r105 = "取消";
        goto L98
    L78:
        r105 = "最佳匹配";
        goto L98
    L79:
        r105 = "播放失败，请重试";
        goto L98
    L80:
        r105 = "完成";
        goto L98
    L81:
        r105 = "创建";
        goto L98
    L82:
        r105 = "录音时间太短";
        goto L98
    L83:
        r105 = "点击创建声音";
        goto L98
    L84:
        r105 = "定位失败，请稍后重试";
        goto L98
    L85:
        r105 = "声音不可用";
        goto L98
    L86:
        r105 = "暂无可用声音";
        goto L98
    L87:
        r105 = "知道了";
        goto L98
    L88:
        r105 = "上传头像失败";
        goto L98
    L89:
        r105 = "后台声音朗读";
        goto L98
    L90:
        r105 = "后台朗读已开启";
        goto L98
    L91:
        r105 = "后台朗读已关闭";
        goto L98
    L92:
        r105 = "使用";
        goto L98
    L93:
        r105 = "声音";
        goto L98
    L94:
        r105 = "审核中";
        goto L98
    L95:
        r105 = "（默认）";
        goto L98
    L96:
        r105 = "当前录音已中断";
        goto L98
    L7:
        throw new NoWhenBranchMatchedException();
    L106:
        if (r102.length == 0) goto L109;
        r103 = false;
    L109:
        if (r103 == false) goto L111;
        String r107 = r100.getString(c(r101));
        Intrinsics.checkNotNull(r107);
        return r107;
    L111:
        String r108 = r100.getString(c(r101), Arrays.copyOf(r102, r102.length));
        Intrinsics.checkNotNull(r108);
        return r108;
    }
}
