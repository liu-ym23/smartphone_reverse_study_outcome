package gu3;

import android.text.TextUtils;
import com.apm.lite.runtime.ConfigManager;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements hu3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f482777a;

    public i(j r100) {
        this.f482777a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v13, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r10v4, types: [java.util.List] */
    @Override // hu3.b
    public final void a(JSONObject r210) {
        j r100 = this.f482777a;
        if (r210 != null) goto L5;
        r100.getClass();
        return;
    L5:
        r100.getClass();
        JSONObject r101 = r210.optJSONObject("general");
        String r102 = null;
        if (r101 != null) goto L8;
        JSONObject r103 = null;
    L9:
        if (r103 != null) goto L11;
        JSONObject r104 = null;
    L12:
        if (r104 == null) goto L89;
        JSONArray r105 = r104.optJSONArray("hosts");
        boolean r106 = false;
        if (r105 != null) goto L77;
    L30:
        ?? r110 = Collections.emptyList();
    L31:
        ArrayList r107 = new ArrayList();
        if (xu3.e.b(r110) == true) goto L41;
        Iterator r108 = r110.iterator();
        String r111 = null;
    L35:
        if (r108.hasNext() == false) goto L42;
        String r112 = (String) r108.next();
        r107.add("https://" + r112 + "/monitor/collect/batch/");
        if (r102 != null) goto L39;
        r102 = "https://" + r112 + ConfigManager.EXCEPTION_URL_SUFFIX;
    L39:
        if (r111 != null) goto L35;
        r111 = "https://" + r112 + "/monitor/collect/c/trace_collect";
    L42:
        boolean r109 = r104.optBoolean("enable_encrypt", true);
        long r113 = r104.optLong("apm6_once_max_size_kb", -1) * 1024;
        long r114 = r104.optLong("apm6_uploading_interval", -1) * 1000;
        JSONObject r115 = r210.optJSONObject("general");
        if (r115 != null) goto L45;
        int r116 = 0;
    L47:
        if (r116 != 1) goto L49;
        r106 = true;
    L49:
        nt3.a r117 = new nt3.a();
        if (xu3.e.b(r107) == true) goto L54;
        r117.f520477b = r107;
    L54:
        if (TextUtils.isEmpty(r102) == true) goto L58;
        ArrayList r118 = new ArrayList();
        r117.f520478c = r118;
        r118.add(r102);
    L58:
        if (TextUtils.isEmpty(r111) == true) goto L61;
        ArrayList r119 = new ArrayList();
        r117.f520479d = r119;
        r119.add(r111);
    L61:
        r117.f520476a = r113;
        r117.f520480e = r109;
        r117.f520482g = r114;
        r117.f520481f = r106;
        JSONObject r120 = r100.f482779b;
        if (r120 == null) goto L64;
        r117.f520485j = r120.optInt("max_size_mb_today", -1);
    L64:
        r117.f520486k = r104.optInt("compress_type", 2);
        JSONObject r121 = r210.optJSONObject("general");
        if (r121 == null) goto L69;
        JSONObject r122 = r121.optJSONObject("cleanup");
        if (r122 == null) goto L69;
        r117.f520483h = r122.optInt("log_max_size_mb", 80);
        r117.f520484i = r122.optInt("log_reserve_days", 5);
    L69:
        r100.f482778a = r117;
        if (xu3.a.a() == false) goto L72;
        av3.b.a("APM-Config", "received reportSetting=" + r104);
        av3.b.a("APM-Config", "parsed SlardarHandlerConfig=" + r100.f482778a);
    L72:
        eu3.a.f474059b = r106;
        if (TextUtils.isEmpty(r102) == true) goto L75;
        eu3.a.f474060c = r102;
    L75:
        mt3.h r123 = mt3.h.f515628f;
        mt3.h.f515628f.d(r100.f482778a);
        return;
    L45:
        r116 = r115.optInt("enable_report_internal_exception", 0);
        goto L47
    L41:
        r111 = null;
        goto L42
    L77:
    L26:
        e = move-exception;
        av3.b.c("APM-Setting", "parse setting host malformedurl exception", e);
    L28:
        e = move-exception;
        av3.b.c("APM-Setting", "parse setting host json exception", e);
        goto L30
    L17:
        if (r105.length() <= 0) goto L30;
        r110 = new ArrayList(2);     // Catch: MalformedURLException -> L26 JSONException -> L28
        int r124 = r105.length();     // Catch: MalformedURLException -> L26 JSONException -> L28
        int r125 = 0;
    L19:
        if (r125 >= r124) goto L31;
        String r126 = new URL(JSONArrayProtectorUtils.getString(r105, r125)).getHost();     // Catch: MalformedURLException -> L26 JSONException -> L28
        if (TextUtils.isEmpty(r126) == true) goto L25;
        if (r126.indexOf(46) <= 0) goto L25;
        r110.add(r126);     // Catch: MalformedURLException -> L26 JSONException -> L28
    L25:
        r125 = r125 + 1;
        goto L19
    L89:
        return;
    L11:
        r104 = r103.optJSONObject("report_setting");
        goto L12
    L8:
        r103 = r101.optJSONObject("slardar_api_settings");
        goto L9
    }
}
