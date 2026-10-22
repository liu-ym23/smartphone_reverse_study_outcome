package ya7;

import android.text.TextUtils;
import com.bytedance.ee.bear.sheet.filter.FilterData;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.obric.aiagent.assistant.idl.IAgentIDL;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import za7.c;
import za7.d;

/* JADX INFO: loaded from: classes22.dex */
public final class a {
    public static c a(String r100) {
        c r101 = new c();
        b(r101, r100);     // Catch: Exception -> L42
        if (r101.f571091a == false) goto L44;
        JSONObject r102 = r101.f571094d;     // Catch: Exception -> L42
        if (r102 == null) goto L40;
        r101.f571088e = r102.optString(IAgentIDL.EXTRA_CLIENT_NAME);     // Catch: Exception -> L42
        r101.f571094d.optString("client_icon");     // Catch: Exception -> L42
        JSONArray r103 = r101.f571094d.optJSONArray(ParamKeyConstants.WebViewConstants.REDIRECT_QUERY_SCOPE);     // Catch: Exception -> L42
        int r104 = 0;
        if (r103 == null) goto L13;
        int r105 = 0;
    L11:
        if (r105 >= r103.length()) goto L13;
        r101.f571089f.add(r103.optString(r105));     // Catch: Exception -> L42
        r105 = r105 + 1;     // Catch: Exception -> L42
    L13:
        r101.f571094d.optJSONObject("scope_dict");     // Catch: Exception -> L42
        JSONObject r106 = r101.f571094d.optJSONObject("alert_scope");     // Catch: Exception -> L42
        if (r106 == null) goto L17;
        r106.optString("scope_name");     // Catch: Exception -> L42
        r106.optString("title");     // Catch: Exception -> L42
        r106.optString("content");     // Catch: Exception -> L42
        r106.optString("negative_button");     // Catch: Exception -> L42
        r106.optString("positive_button");     // Catch: Exception -> L42
    L17:
        JSONObject r107 = r101.f571094d.optJSONObject("customized_scopes");     // Catch: Exception -> L42
        if (r107 == null) goto L20;
        r101.f571090g = c(r107);     // Catch: Exception -> L42
    L20:
        r101.f571094d.optJSONObject("scope_description");     // Catch: Exception -> L42
        JSONObject r108 = r101.f571094d.optJSONObject("normal_scopes");     // Catch: Exception -> L42
        if (r108 == null) goto L30;
        r108.optBoolean("can_skip_confirm");     // Catch: Exception -> L42
        JSONArray r109 = r108.optJSONArray("content");     // Catch: Exception -> L42
        if (r109 == null) goto L30;
        int r110 = r109.length();     // Catch: Exception -> L42
        if (r110 <= 0) goto L30;
        HashSet r111 = new HashSet();     // Catch: Exception -> L42
        int r112 = 0;
    L28:
        if (r112 >= r110) goto L30;
        r111.add(r109.optString(r112));     // Catch: Exception -> L42
        r112 = r112 + 1;     // Catch: Exception -> L42
    L30:
        JSONObject r113 = r101.f571094d.optJSONObject("sensitive_scopes");     // Catch: Exception -> L42
        if (r113 == null) goto L39;
        r113.optBoolean("can_skip_confirm");     // Catch: Exception -> L42
        JSONArray r114 = r113.optJSONArray("content");     // Catch: Exception -> L42
        if (r114 == null) goto L39;
        int r115 = r114.length();     // Catch: Exception -> L42
        if (r115 <= 0) goto L39;
        HashSet r116 = new HashSet();     // Catch: Exception -> L42
    L37:
        if (r104 >= r115) goto L39;
        r116.add(r114.optString(r104));     // Catch: Exception -> L42
        r104 = r104 + 1;     // Catch: Exception -> L42
    L39:
        r101.f571094d.optBoolean("flipchat_conceal");     // Catch: Exception -> L42
        r101.f571094d.optBoolean("has_mobile");     // Catch: Exception -> L42
        r101.f571094d.optBoolean("login");     // Catch: Exception -> L42
        r101.f571094d.optBoolean("need_bind_mobile");     // Catch: Exception -> L42
        r101.f571094d.optBoolean("qq_conceal");     // Catch: Exception -> L42
        r101.f571094d.optBoolean("toutiao_conceal");     // Catch: Exception -> L42
        r101.f571094d.optBoolean("weibo_conceal");     // Catch: Exception -> L42
        r101.f571094d.optBoolean("wx_conceal");     // Catch: Exception -> L42
        r101.f571094d.optBoolean("contains_invalid_scope");     // Catch: Exception -> L42
        r101.f571094d.optString("tips");     // Catch: Exception -> L42
        r101.f571094d.optBoolean("can_skip_confirm");     // Catch: Exception -> L42
    L41:
        return r101;
    L40:
        r101.f571092b = -1;     // Catch: Exception -> L42
    L44:
        return r101;
    L42:
        e = move-exception;
        e.printStackTrace();
        goto L44
    }

    public static Map<String, Map<String, Integer[][]>> c(JSONObject r110) {
        HashMap r100 = new HashMap();
        Iterator<String> r101 = r110.keys();
    L4:
        if (r101.hasNext() == false) goto L42;
        String r102 = r101.next();
        JSONArray r103 = r110.optJSONArray(r102);
        if (r103 != null) goto L8;
    L37:
        HashMap r104 = null;
    L39:
        if (TextUtils.isEmpty(r102) == true) goto L4;
        if (r104 == null) goto L4;
        r100.put(r102, r104);
        goto L4
    L8:
        if (r103.length() == 0) goto L37;
        HashMap r105 = new HashMap();
        int r106 = 0;
        String r107 = null;
        Integer[][] r111 = null;
    L12:
        if (r106 >= r103.length()) goto L36;
        JSONObject r112 = r103.optJSONObject(r106);
        if (r112 == null) goto L32;
        r107 = r112.optString("style");
        JSONArray r113 = r112.optJSONArray(FilterData.FilterOptionItem.Type.RANGE);
        if (r113 != null) goto L18;
    L30:
        r111 = null;
        goto L32
    L18:
        if (r113.length() == 0) goto L30;
        Integer[][] r114 = (Integer[][]) Array.newInstance(Integer.class, new int[]{r113.length(), 2});
        int r115 = 0;
    L22:
        if (r115 >= r113.length()) goto L29;
        JSONArray r116 = r113.optJSONArray(r115);
        if (r116 == null) goto L28;
        if (r116.length() != 2) goto L28;
        r114[r115][0] = Integer.valueOf(r116.optInt(0));
        r114[r115][1] = Integer.valueOf(r116.optInt(1));
    L28:
        r115 = r115 + 1;
        goto L22
    L29:
        r111 = r114;
    L32:
        if (TextUtils.isEmpty(r107) == true) goto L35;
        if (r111 == null) goto L35;
        r105.put(r107, r111);
    L35:
        r106 = r106 + 1;
        goto L12
    L36:
        r104 = r105;
        goto L39
    L42:
        return r100;
    }

    public static void b(d r100, String r101) throws Exception {
        JSONObject r102 = new JSONObject(r101);
        if ("success".equals(r102.optString("message")) == false) goto L5;
        r100.f571091a = true;
        r100.f571094d = r102.optJSONObject("data");
        return;
    L5:
        r100.f571091a = false;
        JSONObject r103 = r102.optJSONObject("data");
        if (r103 == null) goto L10;
        r100.f571092b = r103.optInt("error_code");
        r100.f571093c = r103.optString("description");
        return;
    }
}
