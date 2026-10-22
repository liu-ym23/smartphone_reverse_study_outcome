package com.larus.bmhome.chat.service.action;

import com.byted.cast.common.auth.AuthConstants;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.service.AccountService;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f308736a = 0;

    static {
    }

    public static boolean a(wh8.a r100) {
        if (r100 == null) goto L8;
        BotModel r101 = r100.f559709b;
        if (r101 == null) goto L8;
        BotCreatorInfo r102 = r101.getBotCreatorInfo();
        if (r102 == null) goto L8;
        String r103 = r102.getId();
    L10:
        return Intrinsics.areEqual(r103, AccountService.f365697a.getUserId());
    L8:
        r103 = null;
        goto L10
    }

    public static Integer b(wh8.a r100) {
        if (r100 == null) goto L6;
        BotModel r101 = r100.f559709b;
        if (r101 == null) goto L6;
        return r101.getBotType();
    L6:
        return null;
    }

    public static JSONObject c(wc9.e r100, wh8.a r101, String r102, boolean r103, String r104) {
        Intrinsics.checkNotNullParameter(r101, "data");
        JSONObject r105 = new JSONObject();
        BotModel r106 = r101.f559709b;
        String r107 = null;
        if (r106 == null) goto L5;
        String r108 = r106.getBotId();
    L6:
        if (r108 != null) goto L8;
        r108 = "";
    L8:
        r105.put("bot_id", r108);
        if (r100 == null) goto L11;
        String r109 = r100.f559198a;
    L12:
        r105.put("conversation_id", r109);
        r105.put("object_type", "chat");
        if (r100 == null) goto L24;
        String r110 = r100.I;
        if (r110 == null) goto L24;
        if (r110.length() <= 0) goto L19;
        boolean r111 = true;
    L20:
        if (r111 == true) goto L23;
        r110 = null;
    L23:
        if (r110 == null) goto L24;
    L25:
        r105.put(AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID, r110);
        ChatControlTrace r112 = ChatControlTrace.f309996b;
        if (r100 == null) goto L28;
        Integer r113 = r100.f559219v;
    L29:
        BotModel r114 = r101.f559709b;
        if (r114 == null) goto L32;
        Integer r115 = r114.getBotType();
    L33:
        BotModel r116 = r101.f559709b;
        if (r116 == null) goto L38;
        BotCreatorInfo r117 = r116.getBotCreatorInfo();
        if (r117 == null) goto L38;
        r107 = r117.getId();
    L38:
        r105.put("chat_type", r112.g(r113, r115, Intrinsics.areEqual(r107, AccountService.f365697a.getUserId())));
        if (r102 == null) goto L41;
        r105.put("click_from", r102);
    L41:
        if (r104 == null) goto L43;
        r105.put("current_page", r104);
    L43:
        if (r103 == false) goto L45;
        String r118 = "1";
    L46:
        r105.put("is_navigation_sidebar", r118);
        return r105;
    L45:
        r118 = "0";
        goto L46
    L32:
        r115 = null;
        goto L33
    L28:
        r113 = null;
        goto L29
    L19:
        r111 = false;
    L24:
        r110 = "-";
        goto L25
    L11:
        r109 = null;
        goto L12
    L5:
        r108 = null;
        goto L6
    }
}
