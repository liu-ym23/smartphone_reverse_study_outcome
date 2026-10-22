package kta;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f506122a;

    public q(Context r100) {
        SharedPreferences r101 = r100.getSharedPreferences("device_register_oaid_refine", 0);
        this.f506122a = r101;
        a(r100, r101);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public static void a(Context r210, SharedPreferences r211) {
        if (r211.getBoolean("migrated", false) == false) goto L5;
        return;
    L5:
        r211.edit().putBoolean("migrated", true).apply();
        SharedPreferences r100 = r210.getSharedPreferences("device-register-oaid", 0);
        long r101 = -1;
        p r110 = null;
        if (r100.contains("lastSuccessQueryOaid") == false) goto L32;
        String r102 = r100.getString("lastSuccessQueryOaid", null);
        Integer r111 = Integer.valueOf(r100.getInt("queryHmsTimes", -1));
        if (TextUtils.isEmpty(r102) == false) goto L64;
    L31:
        r100.edit().clear().apply();
    L54:
        Objects.toString(r110);
        if (r110 == null) goto L72;
        r211.edit().putString("oaid", r110.a().toString()).apply();
        return;
    L72:
        return;
    L64:
        JSONObject r103 = new JSONObject(r102);     // Catch: JSONException -> L29
        String r112 = r103.optString("id");     // Catch: JSONException -> L29
        String r104 = r103.optString("is_track_limited");     // Catch: JSONException -> L29
        String r105 = r103.optString("take_ms");     // Catch: JSONException -> L29
        String r106 = r103.optString("time");     // Catch: JSONException -> L29
        String r113 = r103.optString("req_id");     // Catch: JSONException -> L29
        String r107 = r103.optString("hw_id_version_code");     // Catch: JSONException -> L29
        Boolean r114 = Boolean.valueOf(Boolean.parseBoolean(r104));     // Catch: JSONException -> L29
        long r115 = CastLongProtector.parseLong(r105);     // Catch: NumberFormatException -> L12 JSONException -> L29
    L15:
        Long r116 = Long.valueOf(r115);     // Catch: JSONException -> L29
        long r108 = CastLongProtector.parseLong(r106);     // Catch: NumberFormatException -> L18 JSONException -> L29
    L21:
        Long r117 = Long.valueOf(r108);     // Catch: JSONException -> L29
        r101 = CastLongProtector.parseLong(r107);     // Catch: NumberFormatException -> L24 JSONException -> L29
    L27:
        r110 = new p(r112, r113, r114, r116, r117, r111, Long.valueOf(r101));     // Catch: JSONException -> L29
        goto L31
    L24:
        e = move-exception;
        e.printStackTrace();     // Catch: JSONException -> L29
        goto L27
    L18:
        e = move-exception;
        e.printStackTrace();     // Catch: JSONException -> L29
        r108 = -1;
        goto L21
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: JSONException -> L29
        r115 = -1;
    L29:
        e = move-exception;
        e.printStackTrace();
        goto L31
    L32:
        SharedPreferences r109 = r210.getSharedPreferences("device-register-oaid-xiaomi", 0);
        if (r109.contains("lastSuccessQueryOaid") == false) goto L53;
        String r118 = r109.getString("lastSuccessQueryOaid", null);
        Integer r119 = Integer.valueOf(r109.getInt("queryXiaomiTimes", -1));
        if (TextUtils.isEmpty(r118) == true) goto L53;
        JSONObject r120 = new JSONObject(r118);     // Catch: JSONException -> L51
        String r121 = r120.optString("oaid");     // Catch: JSONException -> L51
        String r122 = r120.optString("req_id");     // Catch: JSONException -> L51
        String r123 = r120.optString("last_success_query_oaid_time");     // Catch: JSONException -> L51
        long r124 = CastLongProtector.parseLong(r120.optString("take_ms"));     // Catch: NumberFormatException -> L40 JSONException -> L51
    L43:
        Long r125 = Long.valueOf(r124);     // Catch: JSONException -> L51
        r101 = CastLongProtector.parseLong(r123);     // Catch: NumberFormatException -> L46 JSONException -> L51
    L49:
        r110 = new p(r121, r122, null, r125, Long.valueOf(r101), r119, null);     // Catch: JSONException -> L51
        goto L53
    L46:
        e = move-exception;
        e.printStackTrace();     // Catch: JSONException -> L51
        goto L49
    L40:
        e = move-exception;
        e.printStackTrace();     // Catch: JSONException -> L51
        r124 = -1;
    L51:
        e = move-exception;
        e.printStackTrace();
    L53:
        r109.edit().clear().apply();
        goto L54
    }
}
