package com.ss.android.lark.chat.cot;

import com.huawei.hms.support.api.entity.common.CommonConstant;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f415065a = 0;

    static {
    }

    public static ToolCallListResultArea a(JSONArray r110) {
        if (r110 != null) goto L5;
        return null;
    L5:
        if (r110.length() == 0) goto L82;
        ArrayList r100 = new ArrayList(r110.length());
        int r101 = r110.length();
        int r102 = 0;
    L8:
        boolean r103 = true;
        if (r102 >= r101) goto L71;
        Object r104 = r110.opt(r102);
        if ((r104 instanceof JSONObject) == false) goto L55;
        JSONObject r105 = (JSONObject) r104;
        String r106 = c(r105, new String[]{"text", "title", "name", "content"});
        if (r106.length() <= 0) goto L15;
        boolean r107 = true;
    L16:
        if (r107 == false) goto L18;
        String r111 = r106;
    L19:
        String r108 = c(r105, new String[]{"link", "url", "href"});
        if (r108.length() <= 0) goto L22;
        boolean r109 = true;
    L23:
        if (r109 == false) goto L25;
        String r112 = r108;
    L26:
        String r113 = r105.optString("icon");
        Intrinsics.checkNotNull(r113);
        if (r113.length() <= 0) goto L29;
        boolean r114 = true;
    L30:
        if (r114 == false) goto L32;
        String r115 = r113;
    L33:
        String r116 = c(r105, new String[]{"imageKey", "image_key"});
        if (r116.length() <= 0) goto L36;
        boolean r117 = true;
    L37:
        if (r117 == false) goto L39;
        String r118 = r116;
    L40:
        String r119 = c(r105, new String[]{"iconUrl", "icon_url"});
        if (r119.length() > 0) goto L44;
        r103 = false;
    L44:
        if (r103 == false) goto L46;
        String r120 = r119;
    L47:
        if (r111 != null) goto L53;
        if (r112 != null) goto L53;
        if (r115 != null) goto L53;
        if (r118 != null) goto L53;
        if (r120 != null) goto L53;
    L66:
        ToolCallResultAreaListItem r121 = null;
    L67:
        if (r121 == null) goto L69;
        r100.add(r121);
    L69:
        r102 = r102 + 1;
    L53:
        r121 = new ToolCallResultAreaListItem(r111, r112, r115, r118, r120);
        goto L67
    L46:
        r120 = null;
        goto L47
    L39:
        r118 = null;
        goto L40
    L36:
        r117 = false;
        goto L37
    L32:
        r115 = null;
        goto L33
    L29:
        r114 = false;
        goto L30
    L25:
        r112 = null;
        goto L26
    L22:
        r109 = false;
        goto L23
    L18:
        r111 = null;
        goto L19
    L15:
        r107 = false;
        goto L16
    L55:
        if ((r104 instanceof String) == false) goto L66;
        if (((String) r104).length() > 0) goto L60;
        r103 = false;
    L60:
        if (r103 == true) goto L63;
        r104 = null;
    L63:
        String r122 = (String) r104;
        if (r122 == null) goto L66;
        r121 = new ToolCallResultAreaListItem(r122, null, null, null, null);
        goto L67
    L71:
        if ((!r100.isEmpty()) == true) goto L74;
        r100 = null;
    L74:
        if (r100 != null) goto L76;
        return null;
    L76:
        return new ToolCallListResultArea(r100);
    L82:
        return null;
    }

    public static ToolCallResultArea b(JSONObject r100) {
        String r101 = r100.optString("type");
        String r102 = null;
        if (r101 == null) goto L46;
        int r103 = r101.hashCode();
        boolean r104 = false;
        if (r103 == 3059181) goto L28;
        if (r103 == 3322014) goto L24;
        if (r103 == 3556653) goto L12;
        return null;
    L12:
        if (r101.equals("text") == false) goto L50;
        String r105 = c(r100, new String[]{"text", "content", "value"});
        if (r105.length() <= 0) goto L17;
        r104 = true;
    L17:
        if (r104 == true) goto L20;
        r105 = null;
    L20:
        if (r105 != null) goto L47;
        return null;
    L47:
        return new ToolCallTextResultArea(r105);
    L50:
        return null;
    L24:
        if (r101.equals("list") == true) goto L48;
        return null;
    L48:
        return a(r100.optJSONArray("items"));
    L28:
        if (r101.equals("code") == false) goto L53;
        String r106 = c(r100, new String[]{"code", "content", "value"});
        if (r106.length() <= 0) goto L33;
        boolean r107 = true;
    L34:
        if (r107 == true) goto L37;
        r106 = null;
    L37:
        if (r106 == null) goto L54;
        String r108 = c(r100, new String[]{"language", CommonConstant.ReqAccessTokenParam.LANGUAGE_LABEL});
        if (r108.length() <= 0) goto L42;
        r104 = true;
    L42:
        if (r104 == false) goto L45;
        r102 = r108;
    L45:
        return new ToolCallCodeResultArea(r106, r102);
    L54:
        return null;
    L33:
        r107 = false;
        goto L34
    L53:
        return null;
    L46:
        return null;
    }

    public static String c(JSONObject r100, String... r101) {
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        String r104 = r101[r103];
        if (r100.has(r104) == false) goto L10;
        if (r100.isNull(r104) == true) goto L10;
        return r100.optString(r104);
    L10:
        r103 = r103 + 1;
        goto L3
    L11:
        return "";
    }
}
