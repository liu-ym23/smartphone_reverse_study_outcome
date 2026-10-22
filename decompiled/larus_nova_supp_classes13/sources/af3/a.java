package af3;

import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public final JSONObject a;
    public final JSONObject b;
    public final JSONObject c;
    public final boolean d;

    public final String a() {
        JSONObject r0 = b(this.b, "data");
        if (r0 != null) goto L24;
    L9:
        JSONArray r1 = new JSONArray();
    L11:
        if (r1.length() > 0) goto L22;
        return "";
    L22:
        JSONObject r2 = b(JSONArrayProtectorUtils.getJSONObject(r1, 0), "coupon");     // Catch: Exception -> L21
        if (r2 == null) goto L26;
        String r3 = d(r2, "toast");     // Catch: Exception -> L21
        if (r3 != null) goto L20;
        return "";
    L20:
        return r3;
    L26:
        return "";
    L28:
        return "";
    L24:
        r1 = JSONObjectProtectorUtils.getJSONArray(r0, "benefitInfos");     // Catch: Exception -> L7
    L8:
        if (r1 != null) goto L11;
    L7:
        r1 = new JSONArray();
        goto L8
    }

    public a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "rawData");
        this.a = new JSONObject();
        this.b = new JSONObject();
        this.c = new JSONObject();
        System.currentTimeMillis();     // Catch: Exception -> L17
        JSONObject r1 = new JSONObject(r5);     // Catch: Exception -> L17
        this.a = r1;     // Catch: Exception -> L17
        JSONObject r6 = JSONObjectProtectorUtils.getJSONObject(r1, "extra");     // Catch: Exception -> L17
        this.c = r6;     // Catch: Exception -> L17
        boolean r7 = JSONObjectProtectorUtils.getBoolean(r6, "popup_data_is_valid");     // Catch: Exception -> L6
    L7:
        if (r7 == true) goto L23;
        return;
    L23:
        int r8 = JSONObjectProtectorUtils.getInt(this.c, "native_open_ab");     // Catch: Exception -> L11
    L13:
        if (r8 != 1) goto L15;
        this.b = new JSONObject(JSONObjectProtectorUtils.getString(JSONObjectProtectorUtils.getJSONObject(JSONArrayProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONArray(r1, "popup_data"), 0), "biz_params_map"), "mall_popup"));     // Catch: Exception -> L17
    L15:
        this.d = true;     // Catch: Exception -> L17
        System.currentTimeMillis();     // Catch: Exception -> L17
        return;
    L11:
        r8 = 0;
    L6:
        r7 = false;
    L17:
        this.d = false;
    }

    public final String c(f r5) {
        JSONObject r0 = this.a;
        JSONObject r1 = new JSONObject();
        if (r5 == null) goto L5;
        int r2 = r5.a;
    L6:
        r1.put("result_code", r2);
        if (r5 == null) goto L10;
        String r6 = r5.b;
        if (r6 == null) goto L10;
    L11:
        r1.put("message", r6);
        Unit r7 = Unit.INSTANCE;
        r0.put("native_open_dialog_result", r1);
        return this.a.toString();
    L10:
        r6 = "";
        goto L11
    L5:
        r2 = 0;
        goto L6
    }

    public static JSONObject b(JSONObject r0, String r1) {
        return JSONObjectProtectorUtils.getJSONObject(r0, r1);
    L4:
        return null;
    }

    public static String d(JSONObject r0, String r1) {
        return JSONObjectProtectorUtils.getString(r0, r1);
    L4:
        return "";
    }
}
