package vk7;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.ug.sdk.luckydog.api.log.c;
import com.google.gson.Gson;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import gn7.g;
import il7.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import zl7.k;

/* JADX INFO: loaded from: classes22.dex */
public final class a implements gn7.b, k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f555533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f555534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f555535c;

    @Override // gn7.b, zl7.k
    public final void onSuccess() {
        k r100 = this.f555533a;
        if (r100 == null) goto L5;
        r100.onSuccess();
    L5:
        a(true, null);
        HashMap r101 = new HashMap();
        r101.put("url", this.f555534b.f481827j);
        r101.put("is_async", Boolean.valueOf(this.f555534b.f481824g));
        String r102 = this.f555534b.f481819b;
        c.a r103 = new c.a();
        r103.b("schema", r102);
        HashMap r104 = new HashMap();
        r104.putAll(r101);
        Gson r105 = c.f271581a;
        c.b("RouteALog", "ug route success", r104, r103);
    }

    public a(k r100) {
        this.f555533a = r100;
    }

    @Override // gn7.b, zl7.k
    public final void onFail(String r100) {
        k r101 = this.f555533a;
        if (r101 == null) goto L5;
        r101.onFail(r100);
    L5:
        a(false, r100);
        String r102 = this.f555534b.f481819b;
        c.a r103 = new c.a();
        r103.b("schema", r102);
        HashMap r104 = new HashMap();
        Gson r105 = c.f271581a;
        c.b("RouteALog", r100, r104, r103);
    }

    public final void a(boolean r110, String r111) {
        g r100 = this.f555534b;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f555535c == true) goto L69;
        String r101 = r100.f481827j;
        long r102 = System.currentTimeMillis();
        g r103 = this.f555534b;
        long r104 = r102 - r103.f481825h;
        String r105 = r103.f481819b;
        List<String> r106 = b.f555536a;
        monitor-enter(b.class);
        int r107 = 0;
        if (b.f555537b == false) goto L25;
        b.f555537b = false;     // Catch: Throwable -> L50
        String r108 = m.a().e("route_report_params", "");     // Catch: Throwable -> L50
        ArrayList r109 = new ArrayList();     // Catch: Throwable -> L50
        JSONArray r112 = new JSONArray(r108);     // Catch: Exception -> L18 Throwable -> L50
        int r113 = 0;
    L13:
        if (r113 >= r112.length()) goto L20;
        if (r112.optString(r113) == null) goto L17;
        r109.add(r112.optString(r113));     // Catch: Exception -> L18 Throwable -> L50
    L17:
        r113 = r113 + 1;
    L20:
        int r114 = 0;
    L21:
        if (r114 >= r109.size()) goto L25;
        List<String> r115 = b.f555536a;     // Catch: Throwable -> L50
        ArrayList r116 = (ArrayList) r115;     // Catch: Throwable -> L50
        r116.add(ListProtector.get(r109, r114));     // Catch: Throwable -> L50
        r114 = r114 + 1;
    L18:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L50
    L25:
        monitor-exit(b.class);
        JSONObject r117 = new JSONObject();
    L47:
        e = move-exception;
        e.printStackTrace();
    L49:
        com.bytedance.ug.sdk.luckydog.api.log.b.a("ug_sdk_luckyservice_handle", r117);
        this.f555535c = true;
        return;
    L28:
        if (TextUtils.isEmpty(r105) == true) goto L43;
        Uri r118 = UriProtector.parse(r105);     // Catch: JSONException -> L47
        r117.put("origin_schema_host", r118.getHost());     // Catch: JSONException -> L47
        r117.put("origin_schema_path", r118.getPath());     // Catch: JSONException -> L47
    L58:
        List<String> r119 = b.f555536a;     // Catch: Exception -> L40
        if (r107 >= ((ArrayList) r119).size()) goto L43;
        String r120 = (String) ListProtector.get(r119, r107);     // Catch: Exception -> L40
        if (r120 == null) goto L39;
        String r121 = UriProtector.getQueryParameter(r118, r120);     // Catch: Exception -> L40
        if (r121 != null) goto L38;
        r121 = "";
    L38:
        r117.put(r120, r121);     // Catch: Exception -> L40
    L39:
        r107 = r107 + 1;
    L40:
        e = move-exception;
        e.printStackTrace();     // Catch: JSONException -> L47
        com.bytedance.ug.sdk.luckydog.api.log.a.a("RouteEventReporter", e.getMessage());     // Catch: JSONException -> L47
    L43:
        if (TextUtils.isEmpty(r101) == true) goto L45;
        Uri r122 = UriProtector.parse(r101);     // Catch: JSONException -> L47
        r117.put("final_schema_host", r122.getHost());     // Catch: JSONException -> L47
        r117.put("final_schema_path", r122.getPath());     // Catch: JSONException -> L47
    L45:
        r117.put("duration", r104);     // Catch: JSONException -> L47
        r117.put("url", r105);     // Catch: JSONException -> L47
        r117.put(PickerReporterConstants.KEY.TARGET, r101);     // Catch: JSONException -> L47
        r117.put("reason", r111);     // Catch: JSONException -> L47
        r117.put("handle", r110 ? 1 : 0);     // Catch: JSONException -> L47
    L50:
        th = move-exception;
        throw th;
    }
}
