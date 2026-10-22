package com.obric.aiagent.plugin_api.autoaction.assist_card;

import android.content.Context;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes6.dex */
public class CardResProvider {
    public CardResProvider() {
    }

    public static int getLayoutRes() {
        return R.layout.assist_widget;
    }

    public static int getIdRes(String r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        byte r101 = -1;
        switch(r100.hashCode()) {
            case -1116306093: goto L65;
            case 2521314: goto L61;
            case 63532782: goto L57;
            case 63532783: goto L53;
            case 63532784: goto L49;
            case 332973724: goto L45;
            case 1114219306: goto L41;
            case 1114549214: goto L37;
            case 1142848457: goto L33;
            case 1143178365: goto L29;
            case 1171477608: goto L25;
            case 1171807516: goto L21;
            case 1290981542: goto L17;
            case 1291311450: goto L13;
            case 1979680759: goto L9;
            default: goto L68;
        };
    L68:
        switch(r101) {
            case 0: goto L98;
            case 1: goto L96;
            case 2: goto L94;
            case 3: goto L92;
            case 4: goto L90;
            case 5: goto L88;
            case 6: goto L86;
            case 7: goto L84;
            case 8: goto L82;
            case 9: goto L80;
            case 10: goto L78;
            case 11: goto L76;
            case 12: goto L74;
            case 13: goto L72;
            case 14: goto L70;
            default: goto L69;
        };
    L69:
        return 0;
    L70:
        return R.id.assist_card_app_icon;
    L72:
        return R.id.assist_card_status_text;
    L74:
        return R.id.assist_card_status_icon;
    L76:
        return R.id.assist_card_btn_3_text;
    L78:
        return R.id.assist_card_btn_3_icon;
    L80:
        return R.id.assist_card_btn_2_text;
    L82:
        return R.id.assist_card_btn_2_icon;
    L84:
        return R.id.assist_card_btn_1_text;
    L86:
        return R.id.assist_card_btn_1_icon;
    L88:
        return R.id.assist_card_btn_group;
    L90:
        return R.id.assist_card_btn_3;
    L92:
        return R.id.assist_card_btn_2;
    L94:
        return R.id.assist_card_btn_1;
    L96:
        return R.id.assist_card_root;
    L98:
        return R.id.assist_card_content_text;
    L9:
        if (r100.equals("APP_ICON") == false) goto L68;
        r101 = 14;
        goto L68
    L13:
        if (r100.equals("STATUS_TEXT") == false) goto L68;
        r101 = HTTP.CR;
        goto L68
    L17:
        if (r100.equals("STATUS_ICON") == false) goto L68;
        r101 = 12;
        goto L68
    L21:
        if (r100.equals("BTN_3_TEXT") == false) goto L68;
        r101 = 11;
        goto L68
    L25:
        if (r100.equals("BTN_3_ICON") == false) goto L68;
        r101 = 10;
        goto L68
    L29:
        if (r100.equals("BTN_2_TEXT") == false) goto L68;
        r101 = 9;
        goto L68
    L33:
        if (r100.equals("BTN_2_ICON") == false) goto L68;
        r101 = 8;
        goto L68
    L37:
        if (r100.equals("BTN_1_TEXT") == false) goto L68;
        r101 = 7;
        goto L68
    L41:
        if (r100.equals("BTN_1_ICON") == false) goto L68;
        r101 = 6;
        goto L68
    L45:
        if (r100.equals("BTN_GROUP") == false) goto L68;
        r101 = 5;
        goto L68
    L49:
        if (r100.equals("BTN_3") == false) goto L68;
        r101 = 4;
        goto L68
    L53:
        if (r100.equals("BTN_2") == false) goto L68;
        r101 = 3;
        goto L68
    L57:
        if (r100.equals("BTN_1") == false) goto L68;
        r101 = 2;
        goto L68
    L61:
        if (r100.equals("ROOT") == false) goto L68;
        r101 = 1;
        goto L68
    L65:
        if (r100.equals("CONTENT_TEXT") == false) goto L68;
        r101 = 0;
        goto L68
    }

    public static int getBackgroundRes(String r100, boolean r101) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        byte r102 = -1;
        switch(r100.hashCode()) {
            case -2032180703: goto L37;
            case -1149187101: goto L33;
            case -744169569: goto L29;
            case -368591510: goto L25;
            case 2196191: goto L21;
            case 75902422: goto L17;
            case 1571564098: goto L13;
            case 1980572282: goto L9;
            default: goto L40;
        };
    L40:
        switch(r102) {
            case 0: goto L68;
            case 1: goto L64;
            case 2: goto L62;
            case 3: goto L58;
            case 4: goto L54;
            case 5: goto L50;
            case 6: goto L46;
            case 7: goto L42;
            default: goto L41;
        };
    L41:
        return 0;
    L42:
        if (r101 == false) goto L44;
        return R.drawable.assist_widget_bg_cancel_night;
    L44:
        return R.drawable.assist_widget_bg_cancel;
    L46:
        if (r101 == false) goto L48;
        return R.drawable.assist_widget_bg_clarify_night;
    L48:
        return R.drawable.assist_widget_bg_clarify;
    L50:
        if (r101 == false) goto L52;
        return R.drawable.assist_widget_bg_pause_night;
    L52:
        return R.drawable.assist_widget_bg_pause;
    L54:
        if (r101 == false) goto L56;
        return R.drawable.assist_btn_bg_grey_dark;
    L56:
        return R.drawable.assist_btn_bg_grey;
    L58:
        if (r101 == false) goto L60;
        return R.drawable.assist_widget_bg_failure_night;
    L60:
        return R.drawable.assist_widget_bg_failure;
    L62:
        return R.drawable.bg_button_gradient_round;
    L64:
        if (r101 == false) goto L66;
        return R.drawable.assist_widget_bg_success_night;
    L66:
        return R.drawable.assist_widget_bg_success;
    L68:
        if (r101 == false) goto L70;
        return R.drawable.assist_widget_bg_default_night;
    L70:
        return R.drawable.assist_widget_bg_default;
    L9:
        if (r100.equals("CANCEL") == false) goto L40;
        r102 = 7;
        goto L40
    L13:
        if (r100.equals("CLARIFY") == false) goto L40;
        r102 = 6;
        goto L40
    L17:
        if (r100.equals("PAUSE") == false) goto L40;
        r102 = 5;
        goto L40
    L21:
        if (r100.equals("GREY") == false) goto L40;
        r102 = 4;
        goto L40
    L25:
        if (r100.equals("FAILURE") == false) goto L40;
        r102 = 3;
        goto L40
    L29:
        if (r100.equals("GRADIENT_ROUND") == false) goto L40;
        r102 = 2;
        goto L40
    L33:
        if (r100.equals("SUCCESS") == false) goto L40;
        r102 = 1;
        goto L40
    L37:
        if (r100.equals("DEFAULT") == false) goto L40;
        r102 = 0;
        goto L40
    }

    public static int getIconRes(String r100, boolean r101) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        byte r102 = -1;
        switch(r100.hashCode()) {
            case -2107065985: goto L33;
            case -1764795109: goto L29;
            case -1109051467: goto L25;
            case 2555906: goto L21;
            case 2571565: goto L17;
            case 900418722: goto L13;
            case 1803427515: goto L9;
            default: goto L36;
        };
    L36:
        switch(r102) {
            case 0: goto L62;
            case 1: goto L58;
            case 2: goto L54;
            case 3: goto L50;
            case 4: goto L46;
            case 5: goto L42;
            case 6: goto L38;
            default: goto L37;
        };
    L37:
        return 0;
    L38:
        if (r101 == false) goto L40;
        return R.drawable.oic_arrowtriangle_2_refresh_rotate_45_night;
    L40:
        return R.drawable.oic_arrowtriangle_2_refresh_rotate_45;
    L42:
        if (r101 == false) goto L44;
        return R.drawable.oic_hand_left_ai_fill_night;
    L44:
        return R.drawable.oic_hand_left_ai_fill;
    L46:
        if (r101 == false) goto L48;
        return R.drawable.oic_text_night;
    L48:
        return R.drawable.oic_text;
    L50:
        if (r101 == false) goto L52;
        return R.drawable.oic_stop_night;
    L52:
        return R.drawable.oic_stop;
    L54:
        if (r101 == false) goto L56;
        return R.drawable.oic_checkmark_circle_fill_night;
    L56:
        return R.drawable.oic_checkmark_circle_fill;
    L58:
        if (r101 == false) goto L60;
        return R.drawable.oic_timelapse_night;
    L60:
        return R.drawable.oic_timelapse;
    L62:
        if (r101 == false) goto L64;
        return R.drawable.oic_exclamation_mark_circle_fill_night;
    L64:
        return R.drawable.oic_exclamation_mark_circle_fill;
    L9:
        if (r100.equals("REFRESH") == false) goto L36;
        r102 = 6;
        goto L36
    L13:
        if (r100.equals("LEFT_HAND_AI_FILL") == false) goto L36;
        r102 = 5;
        goto L36
    L17:
        if (r100.equals(CardAdapter.TEXT) == false) goto L36;
        r102 = 4;
        goto L36
    L21:
        if (r100.equals("STOP") == false) goto L36;
        r102 = 3;
        goto L36
    L25:
        if (r100.equals("CHECKMARK") == false) goto L36;
        r102 = 2;
        goto L36
    L29:
        if (r100.equals("TIME_LAPSE") == false) goto L36;
        r102 = 1;
        goto L36
    L33:
        if (r100.equals("EXCLAMATION_MARK") == false) goto L36;
        r102 = 0;
        goto L36
    }

    public static int getResId(Context r100, String r101, String r102) {
        return r100.getResources().getIdentifier(r101, r102, r100.getPackageName());
    }
}
