package com.larus.bmhome.chat.model.strategy;

import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
public final class h0 {
    static {
    }

    public static List a(String r210) {
        Intrinsics.checkNotNullParameter(r210, "selectorListJson");
        ArrayList r100 = new ArrayList();
        if (StringsKt.isBlank(r210) == false) goto L61;
        FLogger.f375446a.e("PPTMessageRequestParser", "parseInstructionItemsTemplate: empty input");
        return r100;
    L61:
        JSONArray r101 = new JSONObject(r210).optJSONArray("selector_list");
        if (r101 != null) goto L10;
        return r100;
    L10:
        int r102 = r101.length();
        int r103 = 0;
    L11:
        if (r103 >= r102) goto L57;
        String r104 = JSONArrayProtectorUtils.getJSONObject(r101, r103).optString(ThumbGlideUrl.SOURCE_TEMPLATE);
        boolean r105 = true;
        if (r104 != null) goto L15;
    L18:
        boolean r106 = true;
    L19:
        if (r106 == true) goto L56;
        JSONObject r107 = new JSONObject(r104);     // Catch: Exception -> L54
        String r108 = r107.optString("label");
        if (r108 == null) goto L28;
        if (r108.length() == 0) goto L28;
        r105 = false;
    L28:
        if (r105 == false) goto L30;
        r108 = r107.optString("display_text");
    L30:
        JSONArray r109 = r107.optJSONArray("option_list");
        if (r109 == null) goto L56;
        int r110 = r109.length();
        int r111 = 0;
    L34:
        if (r111 >= r110) goto L56;
        JSONObject r112 = JSONArrayProtectorUtils.getJSONObject(r109, r111);
        JSONObject r113 = r112.optJSONObject("extra");
        if (r113 == null) goto L53;
        String r114 = r113.optString("page_size_id");
        String r115 = r112.optString("display_text");
        String r116 = r113.optString("selected_id");
        String r117 = r113.optString("selected_type");
        String r118 = r113.optString("selected_result_from");
        if (o0.d(r114) == false) goto L43;
        int r119 = PPTOptionType.PAGE_SIZE.getType();
    L41:
        int r120 = r119;
        String r121 = null;
        if (o0.d(r114) == false) goto L49;
        String r122 = r115;
    L50:
        if (r116 == null) goto L52;
        r121 = r115;
    L52:
        r100.add(new i0(r108, r114, r122, r116, r117, r121, r120));
        goto L53
    L49:
        r122 = null;
        goto L50
    L43:
        if (Intrinsics.areEqual(r118, "selected_result_from_action_bar_button_router") == false) goto L45;
        r119 = PPTOptionType.TEMPLATE.getType();
        goto L41
    L45:
        r119 = PPTOptionType.UNKNOWN.getType();
    L53:
        r111 = r111 + 1;
    L54:
        e = move-exception;
        FLogger.f375446a.e("PPTMessageRequestParser", "parseInstructionItemsTemplate: template json parse error=" + e.getMessage());
    L56:
        r103 = r103 + 1;
        goto L11
    L15:
        if (StringsKt.isBlank(r104) == true) goto L18;
        r106 = false;
        goto L19
    L57:
        return r100;
    L58:
        e = move-exception;
        FLogger.f375446a.e("PPTMessageRequestParser", "parseInstructionItemsTemplate: root json parse error=" + e.getMessage());
        return r100;
    }
}
