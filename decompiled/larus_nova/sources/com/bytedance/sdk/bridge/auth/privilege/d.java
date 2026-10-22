package com.bytedance.sdk.bridge.auth.privilege;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.sdk.bridge.BridgeManager;
import com.bytedance.sdk.bridge.Logger;
import com.bytedance.sdk.bridge.api.BridgeService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f269569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vc7.b f269570b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f269571a = null;

        static {
            f269571a = new d();
        }
    }

    public final void b() throws JSONException {
        Context r100 = BridgeManager.INSTANCE.getBridgeConfig().getApplication();
        if (r100 == null) goto L9;
        String r101 = r100.getSharedPreferences("JsBridgeAuthStore", 0).getString("accessKeyContent", "");
        if (r101.isEmpty() == true) goto L10;
        c(r101);
        return;
    L10:
        return;
    L9:
        throw new RuntimeException("BridgeSDK can not get application context");
    }

    public d() {
        this.f269570b = new vc7.b();
        BridgeService r100 = (BridgeService) ServiceManager.getService(BridgeService.class);
        if (r100 == null) goto L6;
        this.f269569a = r100.initBridgeLazyConfig().f269576a.f269581e;
        return;
    }

    public final void a(JSONObject r110) {
        ((ConcurrentHashMap) this.f269570b.f554126a).clear();
        Iterator<String> r100 = r110.keys();
    L4:
        if (r100.hasNext() == false) goto L35;
        String r101 = r100.next();
        JSONArray r102 = r110.optJSONArray(r101);
        if (r102 == null) goto L7;
        ArrayList r103 = new ArrayList();
        int r104 = 0;
    L10:
        if (r104 >= r102.length()) goto L34;
        JSONObject r105 = r102.optJSONObject(r104);
        if (r105 != null) goto L14;
        vc7.a r106 = null;
    L31:
        if (r106 == null) goto L33;
        r103.add(r106);
    L33:
        r104 = r104 + 1;
        goto L10
    L14:
        vc7.a r107 = new vc7.a();
        String r108 = r105.optString("pattern");
        String r109 = r105.optString("group");
        r107.f554122a = r108;
        r107.f554123b = r109;
        JSONArray r111 = r105.optJSONArray("included_methods");
        if (r111 == null) goto L21;
        ArrayList r112 = new ArrayList();
        int r113 = 0;
    L18:
        if (r113 >= r111.length()) goto L20;
        r112.add(r111.optString(r113));
        r113 = r113 + 1;
        goto L18
    L20:
        r107.f554124c = r112;
    L22:
        JSONArray r114 = r105.optJSONArray("excluded_methods");
        if (r114 == null) goto L29;
        ArrayList r115 = new ArrayList();
        int r116 = 0;
    L26:
        if (r116 >= r114.length()) goto L28;
        r115.add(r114.optString(r116));
        r116 = r116 + 1;
        goto L26
    L28:
        r107.f554125d = r115;
    L30:
        r106 = r107;
        goto L31
    L29:
        Logger.f269563c.getClass();
        Logger.b();
        goto L30
    L21:
        Logger.f269563c.getClass();
        Logger.b();
        goto L22
    L34:
        ((ConcurrentHashMap) this.f269570b.f554126a).put(r101, r103);
        goto L4
    L7:
        Logger.f269563c.getClass();
        Logger.b();
        goto L4
    }

    public final synchronized void c(String r100) throws JSONException {
        monitor-enter(this);
    L52:
        th = move-exception;
        throw th;
    L4:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        Logger.f269563c.getClass();     // Catch: Throwable -> L52
        Logger.b();     // Catch: Throwable -> L52
        monitor-exit(this);
        return;
    L8:
        JSONArray r101 = new JSONArray(r100);     // Catch: Throwable -> L52
        if (r101.length() > 0) goto L13;
        Logger.f269563c.getClass();     // Catch: Throwable -> L52
        Logger.b();     // Catch: Throwable -> L52
        monitor-exit(this);
        return;
    L13:
        int r102 = 0;
    L15:
        if (r102 >= r101.length()) goto L25;
        JSONObject r103 = r101.optJSONObject(r102);     // Catch: Throwable -> L52
        if (r103 == null) goto L24;
        String r104 = r103.optString("channel");     // Catch: Throwable -> L52
        if (r103.optInt("package_type") != 3) goto L24;
        if (TextUtils.equals(r104, "_jsb_auth") == false) goto L24;
    L26:
        if (r103 != null) goto L30;
        Logger.f269563c.getClass();     // Catch: Throwable -> L52
        Logger.a();     // Catch: Throwable -> L52
        monitor-exit(this);
        return;
    L30:
        JSONObject r105 = r103.optJSONObject("content");     // Catch: Throwable -> L52
        if (r105 != null) goto L35;
        Logger.f269563c.getClass();     // Catch: Throwable -> L52
        Logger.b();     // Catch: Throwable -> L52
        monitor-exit(this);
        return;
    L35:
        a(r105);     // Catch: Throwable -> L52
        JSONObject r106 = r103.optJSONObject("overridden_methods");     // Catch: Throwable -> L52
        if (r106 == null) goto L50;
        Iterator<String> r107 = r106.keys();     // Catch: Throwable -> L52
    L40:
        if (r107.hasNext() == false) goto L50;
        String r108 = r107.next();     // Catch: Throwable -> L52
        Map<String, List<String>> r109 = this.f269570b.f554127b;     // Catch: Throwable -> L52
        JSONArray r110 = r106.optJSONArray(r108);     // Catch: Throwable -> L52
        ArrayList r111 = new ArrayList();     // Catch: Throwable -> L52
        if (r110 == null) goto L48;
        int r112 = 0;
    L46:
        if (r112 >= r110.length()) goto L48;
        r111.add(JSONArrayProtectorUtils.getString(r110, r112));     // Catch: Throwable -> L52
        r112 = r112 + 1;     // Catch: Throwable -> L52
    L48:
        ((ConcurrentHashMap) r109).put(r108, r111);     // Catch: Throwable -> L52
    L50:
        monitor-exit(this);
        return;
    L24:
        r102 = r102 + 1;     // Catch: Throwable -> L52
        goto L15
    L25:
        r103 = null;
        goto L26
    }
}
