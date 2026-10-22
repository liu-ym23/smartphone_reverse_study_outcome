package com.bytedance.ug.sdk.luckycat.impl.route;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.ug.sdk.luckycat.impl.manager.LuckyCatSettingsManger;
import com.bytedance.ug.sdk.luckycat.impl.utils.LuckyCatUtils;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f271459a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f271460b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<String> f271461c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<String> f271462d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f271463e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f271464f;

    static {
        f271459a = new String[]{"not_luckycat_schema"};
        f271460b = new String[]{"no_settings", "no_valid_rule", "over_stack", "fall_back"};
        ArrayList r100 = new ArrayList();
        f271461c = r100;
        ArrayList r101 = new ArrayList();
        f271462d = r101;
        f271463e = true;
        r100.add("enter_from");
        r101.add("enter_from");
        r101.add("scene_key");
        r101.add("ug_activity_id");
    }

    public static synchronized void a() {
        monitor-enter(n.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (f271463e == false) goto L14;
        int r100 = 0;
        f271463e = false;     // Catch: Throwable -> L16
        LuckyCatSettingsManger r101 = LuckyCatSettingsManger.b.f271283a;     // Catch: Throwable -> L16
        List<String> r102 = r101.f();     // Catch: Throwable -> L16
        List<String> r103 = r101.e();     // Catch: Throwable -> L16
        int r104 = 0;
    L8:
        if (r104 >= ((ArrayList) r102).size()) goto L10;
        List<String> r105 = f271461c;     // Catch: Throwable -> L16
        ArrayList r106 = (ArrayList) r105;     // Catch: Throwable -> L16
        r106.add(ListProtector.get(r102, r104));     // Catch: Throwable -> L16
        r104 = r104 + 1;     // Catch: Throwable -> L16
    L10:
        if (r100 >= ((ArrayList) r103).size()) goto L14;
        List<String> r107 = f271462d;     // Catch: Throwable -> L16
        ArrayList r108 = (ArrayList) r107;     // Catch: Throwable -> L16
        r108.add(ListProtector.get(r103, r100));     // Catch: Throwable -> L16
        r100 = r100 + 1;
    L14:
        monitor-exit(n.class);
    }

    public static boolean b(String r100, String r110, boolean r111, String r112, long r113, String r114) {
        String r101 = f271464f;
        List<String> r102 = LuckyCatUtils.f271506a;
        boolean r103 = false;
        if (r100 != null) goto L7;
        if (r101 != null) goto L6;
        boolean r104 = true;
    L8:
        if (r104 == false) goto L10;
        return false;
    L10:
        a();
        JSONObject r105 = new JSONObject();
    L60:
        e = move-exception;
        e.printStackTrace();
    L62:
        com.bytedance.ug.sdk.luckycat.impl.model.d.a("ug_sdk_luckyservice_handle", r105, true);
        return true;
    L13:
        if (TextUtils.isEmpty(r100) == true) goto L39;
        Uri r106 = UriProtector.parse(r100);     // Catch: JSONException -> L60
        r105.put("origin_schema_host", r106.getHost());     // Catch: JSONException -> L60
        r105.put("origin_schema_path", r106.getPath());     // Catch: JSONException -> L60
        int r107 = 0;
    L66:
        List<String> r108 = f271461c;     // Catch: Exception -> L36
        if (r107 >= ((ArrayList) r108).size()) goto L26;
        String r109 = (String) ListProtector.get(r108, r107);     // Catch: Exception -> L36
        if (r109 == null) goto L25;
        String r115 = UriProtector.getQueryParameter(r106, r109);     // Catch: Exception -> L36
        if (r115 != null) goto L24;
        r115 = "";
    L24:
        r105.put(r109, r115);     // Catch: Exception -> L36
    L25:
        r107 = r107 + 1;     // Catch: Exception -> L36
        goto L66
    L26:
        String r116 = UriProtector.getQueryParameter(r106, "surl");     // Catch: Exception -> L36
        if (r116 != null) goto L29;
    L30:
        r116 = UriProtector.getQueryParameter(r106, "url");     // Catch: Exception -> L36
    L31:
        if (r116 == null) goto L39;
        if (r116.isEmpty() == true) goto L39;
        r105.put("authority", UriProtector.parse(r116).getHost());     // Catch: Exception -> L36
    L29:
        if (r116.isEmpty() == false) goto L31;
    L36:
        e = move-exception;
        e.printStackTrace();     // Catch: JSONException -> L60
        com.bytedance.ug.sdk.luckycat.impl.utils.a.b("RouteEventReporter", e.getMessage());     // Catch: JSONException -> L60
    L39:
        if (TextUtils.isEmpty(r110) == true) goto L47;
        Uri r117 = UriProtector.parse(r110);     // Catch: JSONException -> L60
        r105.put("final_schema_host", r117.getHost());     // Catch: JSONException -> L60
        r105.put("final_schema_path", r117.getPath());     // Catch: JSONException -> L60
        String r118 = com.bytedance.ug.sdk.luckycat.utils.i.d(r110);     // Catch: JSONException -> L60
        if (TextUtils.isEmpty(r118) == false) goto L68;
    L46:
        r105.put("schema_type", com.bytedance.ug.sdk.luckycat.utils.i.c(r110));     // Catch: JSONException -> L60
        goto L47
    L68:
        r105.put("schema_surl_path", UriProtector.parse(r118).getPath());     // Catch: JSONException -> L44
    L44:
        e = move-exception;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.b("RouteEventReporter", "parse url fail" + e.getMessage());     // Catch: JSONException -> L60
    L47:
        r105.put("duration", r113);     // Catch: JSONException -> L60
        r105.put("url", r100);     // Catch: JSONException -> L60
        r105.put(PickerReporterConstants.KEY.TARGET, r110);     // Catch: JSONException -> L60
        r105.put("reason", r114);     // Catch: JSONException -> L60
        if (r111 == false) goto L50;
        int r119 = 1;
    L51:
        r105.put("handle", r119);     // Catch: JSONException -> L60
        String[] r120 = f271459a;     // Catch: JSONException -> L60
        int r121 = r120.length;     // Catch: JSONException -> L60
        int r122 = 0;
    L52:
        if (r122 >= r121) goto L57;
        if (r120[r122].equals(r112) == true) goto L55;
        r122 = r122 + 1;     // Catch: JSONException -> L60
        goto L52
    L55:
        r103 = true;
    L57:
        if (r103 == false) goto L62;
        r105.put("type", r112);     // Catch: JSONException -> L60
        goto L62
    L50:
        r119 = 0;
        goto L51
    L6:
        r104 = false;
        goto L8
    L7:
        r104 = r100.equals(r101);
        goto L8
    }
}
