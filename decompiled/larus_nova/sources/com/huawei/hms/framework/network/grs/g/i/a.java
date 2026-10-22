package com.huawei.hms.framework.network.grs.g.i;

import android.content.Context;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.g.j.d;
import com.huawei.hms.framework.network.grs.h.c;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f277251a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static d f277252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f277253c = null;

    static {
        f277253c = new Object();
    }

    public static d a(Context r100) {
        Object r101 = f277253c;
        monitor-enter(r101);
        d r102 = f277252b;     // Catch: Throwable -> L30
        if (r102 == null) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L30
        return r102;
    L8:
        String r103 = c.a(GrsApp.getInstance().getBrand(HTTP.URL_DEFAULT) + "grs_sdk_server_config.json", r100);     // Catch: Throwable -> L30
        ArrayList r104 = null;
        if (TextUtils.isEmpty(r103) == false) goto L33;
        monitor-exit(r101);     // Catch: Throwable -> L30
        return null;
    L33:
        JSONObject r105 = new JSONObject(r103).getJSONObject("grs_server");     // Catch: JSONException -> L23 Throwable -> L30
        JSONArray r106 = r105.getJSONArray("grs_base_url");     // Catch: JSONException -> L23 Throwable -> L30
        if (r106 != null) goto L16;
    L21:
        d r107 = new d();     // Catch: JSONException -> L23 Throwable -> L30
        f277252b = r107;     // Catch: JSONException -> L23 Throwable -> L30
        r107.a(r104);     // Catch: JSONException -> L23 Throwable -> L30
        f277252b.a(r105.getString("grs_query_endpoint_2.0"));     // Catch: JSONException -> L23 Throwable -> L30
        f277252b.a(r105.getInt("grs_query_timeout"));     // Catch: JSONException -> L23 Throwable -> L30
    L27:
        d r108 = f277252b;     // Catch: Throwable -> L30
        monitor-exit(r101);     // Catch: Throwable -> L30
        return r108;
    L16:
        if (r106.length() <= 0) goto L21;
        r104 = new ArrayList();     // Catch: JSONException -> L23 Throwable -> L30
        int r109 = 0;
    L19:
        if (r109 >= r106.length()) goto L21;
        r104.add(r106.get(r109).toString());     // Catch: JSONException -> L23 Throwable -> L30
        r109 = r109 + 1;     // Catch: JSONException -> L23 Throwable -> L30
    L23:
        e = move-exception;
        Logger.w(f277251a, "getGrsServerBean catch JSONException: %s", new Object[]{StringUtils.anonymizeMessage(e.getMessage())});     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;
    }
}
