package com.bytedance.ug.sdk.luckycat.impl.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class LuckyCatUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f271506a = null;

    static {
        f271506a = new AnonymousClass1();
    }

    public static boolean a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        Uri r101 = UriProtector.parse(r100);
        if (r101 != null) goto L8;
        return false;
    L8:
        String r102 = UriProtector.getQueryParameter(r101, "loading_manual_finished");
        if (TextUtils.isEmpty(r102) == true) goto L19;
        int r103 = CastIntegerProtector.parseInt(r102);     // Catch: NumberFormatException -> L12
    L14:
        if (r103 <= 0) goto L20;
        return true;
    L20:
        return false;
    L12:
        e = move-exception;
        e.printStackTrace();
        r103 = 0;
        goto L14
    L19:
        return false;
    }

    public static boolean b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        boolean r101 = com.bytedance.ug.sdk.luckycat.utils.i.f(r100);
        if (r101 == false) goto L8;
    L10:
        Uri r102 = UriProtector.parse(r100);
        if (r101 == true) goto L20;
        if (r102 != null) goto L38;
        r100 = null;
        goto L20
    L38:
        r100 = URLDecoder.decode(UriProtector.getQueryParameter(r102, "url"));     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        r100 = r102.toString();
    L20:
        if (TextUtils.isEmpty(r100) == false) goto L22;
        return false;
    L22:
        String r103 = UriProtector.parse(r100).getHost();
        if (r103 != null) goto L25;
        return false;
    L25:
        Iterator r104 = ((ArrayList) f271506a).iterator();
    L27:
        if (r104.hasNext() == false) goto L32;
        if (d(r103, (String) r104.next()) == false) goto L27;
        return true;
    L32:
        com.bytedance.ug.sdk.luckycat.api.depend.j r105 = com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a.f271336d;
        if (r105 == null) goto L37;
        bn7.e r106 = ((cn7.e) r105).f24556a;
        if (r106 == null) goto L37;
        r106.getSafeHostList();
    L37:
        return false;
    L8:
        if (com.bytedance.ug.sdk.luckycat.utils.i.j(r100) == true) goto L10;
        return false;
    }

    public static void c(JSONObject r110) {
        if (r110 != null) goto L32;
        return;
    L32:
        String r100 = r110.optString("report_type");     // Catch: JSONException -> L30
        String r101 = r110.optString("data");     // Catch: JSONException -> L30
        if (TextUtils.isEmpty(r100) == false) goto L10;
        return;
    L10:
        if (r100.equals("slardar") == false) goto L13;
        JSONObject r111 = new JSONObject(r101);     // Catch: JSONException -> L30
        String r102 = r111.optString("service_name");     // Catch: JSONException -> L30
        JSONObject r112 = r111.optJSONObject("metric");     // Catch: JSONException -> L30
        JSONObject r113 = r111.optJSONObject("category");     // Catch: JSONException -> L30
        JSONObject r114 = r111.optJSONObject("extra_value");     // Catch: JSONException -> L30
        JSONObject r115 = r111.optJSONObject("duration");     // Catch: JSONException -> L30
        com.bytedance.ug.sdk.luckycat.impl.model.f.b(r102, JSONObjectProtectorUtils.getInt(r111, "status"), r115, r113, r112, r114);     // Catch: JSONException -> L30
    L31:
        return;
    L13:
        if (r100.equals("tea") == false) goto L16;
        JSONObject r116 = new JSONObject(r101);     // Catch: JSONException -> L30
        com.bytedance.ug.sdk.luckycat.impl.model.d.a(JSONObjectProtectorUtils.getString(r116, "service_name"), r116, true);     // Catch: JSONException -> L30
        goto L31
    L16:
        if (r100.equals("hybird") == false) goto L18;
    L25:
        JSONObject r117 = new JSONObject(r101);     // Catch: JSONException -> L30
        r117.optString("service_name");     // Catch: JSONException -> L30
        JSONObject r103 = r117.optJSONObject("category");     // Catch: JSONException -> L30
        JSONObject r104 = r117.optJSONObject("metric");     // Catch: JSONException -> L30
        JSONObject r105 = r117.optJSONObject("extra_value");     // Catch: JSONException -> L30
        r117.optString("url");     // Catch: JSONException -> L30
        r117.optString("type");     // Catch: JSONException -> L30
        r117.optInt("may_sample");     // Catch: JSONException -> L30
        CopyOnWriteArrayList<ti7.c> r118 = com.bytedance.ug.sdk.luckycat.impl.model.f.f271396a;     // Catch: JSONException -> L30
        if (com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a.f271344l == false) goto L31;
        Objects.toString(r103);     // Catch: JSONException -> L30
        Objects.toString(r104);     // Catch: JSONException -> L30
        Objects.toString(r105);     // Catch: JSONException -> L30
        goto L31
    L18:
        if (r100.equals("hybrid") == true) goto L25;
        if (r100.equals(CloudControlInf.ALOG) == false) goto L31;
        JSONObject r119 = r110.optJSONObject("data");     // Catch: JSONException -> L30
        if (r119 == null) goto L31;
        String r106 = r119.optString("value");     // Catch: JSONException -> L30
        a.c(r119.optString("tag", "luckycat_fe_alog_tag"), r106);     // Catch: JSONException -> L30
    }

    public static boolean d(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        if (TextUtils.equals(r100, r101) == false) goto L8;
    L9:
        return true;
    L8:
        if (r100.endsWith("." + r101) == true) goto L9;
        return false;
    }
}
