package com.larus.login.impl.loginfragment;

import android.os.Bundle;
import com.larus.doc.sdk.api.VoiceInputFrom;
import com.larus.nova.R;
import com.larus.platform.model.TriggerLoginScene;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f358006a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f358007a = null;

        static {
            int[] r100 = new int[TriggerLoginScene.values().length];
            r100[TriggerLoginScene.TRIGGER_LOGIN_LANDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L30
        L87:
            r100[TriggerLoginScene.TRIGGER_LOGIN_CREATE_BOT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L31
        L103:
            r100[TriggerLoginScene.TRIGGER_LOGIN_CLICK_INPUT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L32
        L63:
            r100[TriggerLoginScene.TRIGGER_LOGIN_MESSAGE_LIMITED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L33
        L67:
            r100[TriggerLoginScene.TRIGGER_LOGIN_CLICK_TAB.ordinal()] = 5;     // Catch: NoSuchFieldError -> L34
        L81:
            r100[TriggerLoginScene.TRIGGER_LOGIN_CLICK_CALL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L35
        L97:
            r100[TriggerLoginScene.TRIGGER_LOGIN_CLICK_OTHERS.ordinal()] = 7;     // Catch: NoSuchFieldError -> L36
        L73:
            r100[TriggerLoginScene.TRIGGER_LOGIN_TOURIST_AUTH.ordinal()] = 8;     // Catch: NoSuchFieldError -> L37
        L91:
            r100[TriggerLoginScene.TRIGGER_LOGIN_FIRST_APPLICATION_MUSIC_QUERY.ordinal()] = 9;     // Catch: NoSuchFieldError -> L38
        L93:
            r100[TriggerLoginScene.TRIGGER_LOGIN_FIRST_APPLICATION_MUSIC_HISTORY_CLICK.ordinal()] = 10;     // Catch: NoSuchFieldError -> L39
        L57:
            r100[TriggerLoginScene.TRIGGER_LOGIN_CHAT_LIST_GUIDE_BANNER.ordinal()] = 11;     // Catch: NoSuchFieldError -> L40
        L85:
            r100[TriggerLoginScene.TRIGGER_LOGIN_DISABLE_TOURIST_CREATION.ordinal()] = 12;     // Catch: NoSuchFieldError -> L41
        L101:
            r100[TriggerLoginScene.TRIGGER_LOGIN_COMMERCE_CREDIT_TOURIST_GUIDE.ordinal()] = 13;     // Catch: NoSuchFieldError -> L42
        L55:
            r100[TriggerLoginScene.TRIGGER_LOGIN_AWEME_RED_PACKET.ordinal()] = 14;     // Catch: NoSuchFieldError -> L43
        L69:
            r100[TriggerLoginScene.TRIGGER_LOGIN_DISABLE_TOURIST_TUTOR.ordinal()] = 15;     // Catch: NoSuchFieldError -> L44
        L99:
            r100[TriggerLoginScene.TRIGGER_LOGIN_ENTER_SPRING_MAIN_VENUE.ordinal()] = 16;     // Catch: NoSuchFieldError -> L45
        L61:
            r100[TriggerLoginScene.TRIGGER_LOGIN_ECOMMERCE_PRODUCT_DETAIL.ordinal()] = 17;     // Catch: NoSuchFieldError -> L46
        L65:
            r100[TriggerLoginScene.TRIGGER_LOGIN_BD_TURING.ordinal()] = 18;     // Catch: NoSuchFieldError -> L47
        L83:
            r100[TriggerLoginScene.TRIGGER_LOGIN_ADD_ACCOUNT.ordinal()] = 19;     // Catch: NoSuchFieldError -> L48
        L59:
            r100[TriggerLoginScene.TRIGGER_LOGIN_INVALID_RELOGIN.ordinal()] = 20;     // Catch: NoSuchFieldError -> L49
        L77:
            r100[TriggerLoginScene.TRIGGER_LOGIN_LOCAL_LIFE.ordinal()] = 21;     // Catch: NoSuchFieldError -> L50
        L79:
            r100[TriggerLoginScene.TRIGGER_LOGIN_EC_SEARCH_SAAS_CARD.ordinal()] = 22;     // Catch: NoSuchFieldError -> L51
        L95:
            r100[TriggerLoginScene.TRIGGER_LOGIN_PARSE_NEED_LOGIN_ROUTER.ordinal()] = 23;     // Catch: NoSuchFieldError -> L52
        L71:
            r100[TriggerLoginScene.TRIGGER_LOGIN_ENTER_COMMON_MAIN_VENUE.ordinal()] = 24;     // Catch: NoSuchFieldError -> L53
        L89:
            r100[TriggerLoginScene.TRIGGER_LOGIN_AUDIO_RECORD.ordinal()] = 25;     // Catch: NoSuchFieldError -> L54
        L28:
            f358007a = r100;
        }
    }

    static {
    }

    public static n1 a(Bundle r100) {
        TriggerLoginScene.a r101 = TriggerLoginScene.Companion;
        String r102 = null;
        if (r100 == null) goto L5;
        Integer r103 = Integer.valueOf(r100.getInt("trigger_login_scene_tag", -1));
    L6:
        r101.getClass();
        TriggerLoginScene r104 = TriggerLoginScene.a.a(r103);
        switch(a.f358007a[r104.ordinal()]) {
            case 1: goto L34;
            case 2: goto L33;
            case 3: goto L32;
            case 4: goto L31;
            case 5: goto L30;
            case 6: goto L29;
            case 7: goto L28;
            case 8: goto L27;
            case 9: goto L26;
            case 10: goto L25;
            case 11: goto L24;
            case 12: goto L23;
            case 13: goto L22;
            case 14: goto L21;
            case 15: goto L20;
            case 16: goto L19;
            case 17: goto L18;
            case 18: goto L17;
            case 19: goto L16;
            case 20: goto L15;
            case 21: goto L14;
            case 22: goto L13;
            case 23: goto L12;
            case 24: goto L11;
            case 25: goto L10;
            default: goto L9;
        };
    L10:
        n1 r105 = new n1(r104, R.string.larus_visitor_login_to_unlock, "click_coco_record");
    L36:
        if (r104 != TriggerLoginScene.TRIGGER_LOGIN_PARSE_NEED_LOGIN_ROUTER) goto L51;
        if (r100 == null) goto L48;
        String r106 = r100.getString("account_enter_method");
        if (r106 == null) goto L48;
        if (r106.length() <= 0) goto L43;
        boolean r107 = true;
    L44:
        if (r107 == false) goto L46;
        r102 = r106;
    L46:
        if (r102 == null) goto L48;
    L49:
        String r108 = r102;
        TriggerLoginScene r109 = r105.f357997a;
        int r110 = r105.f357998b;
        List<String> r111 = r105.f358000d;
        String r112 = r105.f358001e;
        Intrinsics.checkNotNullParameter(r109, "scene");
        Intrinsics.checkNotNullParameter(r108, "traceEnterMethodParam");
        return new n1(r109, r110, r108, r111, r112);
    L43:
        r107 = false;
    L48:
        r102 = r105.f357999c;
        goto L49
    L51:
        return r105;
    L11:
        r105 = new n1(r104, R.string.larus_visitor_login_to_unlock, "click_common_main_venue");
        goto L36
    L12:
        r105 = new n1(r104, R.string.larus_visitor_login_to_unlock, "parse_need_login_router");
        goto L36
    L13:
        r105 = new n1(r104, R.string.larus_visitor_login_to_unlock, "click_ecom_search_saas_card");
        goto L36
    L14:
        r105 = new n1(r104, R.string.larus_visitor_login_to_unlock, "local_life");
        goto L36
    L15:
        r105 = new n1(r104, R.string.larus_visitor_login_to_unlock, "invalid_relogin");
        goto L36
    L16:
        r105 = new n1(r104, R.string.larus_switchAccount_addAcc, "add_account");
        goto L36
    L17:
        r105 = new n1(r104, R.string.larus_visitor_login_to_unlock, "bd_turing");
        goto L36
    L18:
        r105 = new n1(r104, R.string.larus_visitor_login_to_unlock, "enter_ecommerce_product_list");
        goto L36
    L19:
        r105 = new n1(r104, R.string.larus_visitor_login_to_unlock, "spring_guide_2026");
        goto L36
    L20:
        r105 = new n1(r104, R.string.larus_visitor_login_to_unlock, VoiceInputFrom.ACTION_BAR);
        goto L36
    L21:
        r105 = new n1(r104, R.string.larus_visitor_login_to_unlock, "aweme_red_packet");
        goto L36
    L22:
        r105 = new n1(r104, R.string.larus_visitor_login_to_unlock, "click_login_guide_credit");
        goto L36
    L23:
        r105 = new n1(r104, R.string.larus_visitor_login_to_unlock, VoiceInputFrom.ACTION_BAR);
        goto L36
    L24:
        r105 = new n1(r104, R.string.larus_visitor_login_to_unlock, "click_login_guide_banner");
        goto L36
    L25:
        r105 = new n1(r104, R.string.larus_visitor_login_to_unlock, "first_application_music_history_click");
        goto L36
    L26:
        r105 = new n1(r104, R.string.larus_visitor_login_to_unlock, "first_application_music_query");
        goto L36
    L27:
        r105 = new n1(r104, R.string.larus_visitor_login_to_unlock, "tourist_auth", CollectionsKt.listOf("douyin"), "douyin");
        goto L36
    L28:
        r105 = new n1(r104, R.string.larus_visitor_login_to_unlock, "others");
        goto L36
    L29:
        r105 = new n1(r104, R.string.larus_visitor_login_to_unlock, "click_call");
        goto L36
    L30:
        r105 = new n1(r104, R.string.larus_visitor_login_to_unlock, "click_tab");
        goto L36
    L31:
        r105 = new n1(r104, R.string.larus_visitor_login_to_chat, "message_quota_limit");
        goto L36
    L32:
        r105 = new n1(r104, R.string.larus_visitor_login_to_chat, "input_click");
        goto L36
    L33:
        r105 = new n1(r104, R.string.larus_visitor_login_to_create, "click_create_bot");
        goto L36
    L34:
        r105 = new n1(r104, R.string.larus_visitor_login_to_unlock, "landing");
        goto L36
    L9:
        throw new NoWhenBranchMatchedException();
    L5:
        r103 = null;
        goto L6
    }
}
