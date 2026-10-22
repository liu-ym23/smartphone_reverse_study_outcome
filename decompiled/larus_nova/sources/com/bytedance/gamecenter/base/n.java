package com.bytedance.gamecenter.base;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.downloadlib.DownloadComponentManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, p> f245009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f245010b;

    public n() {
        this.f245009a = new HashMap();
        this.f245010b = new Handler(Looper.getMainLooper());
    }

    public static String c(String r100, Map r101) {
        HashMap r102 = (HashMap) r101;
        if (r102.size() == 0) goto L15;
        Uri.Builder r103 = UriProtector.parse(r100).buildUpon();     // Catch: Throwable -> L11
        Iterator r104 = r102.entrySet().iterator();     // Catch: Throwable -> L11
    L7:
        if (r104.hasNext() == false) goto L9;
        Map.Entry r105 = (Map.Entry) r104.next();     // Catch: Throwable -> L11
        r103.appendQueryParameter((String) r105.getKey(), String.valueOf(r105.getValue()));     // Catch: Throwable -> L11
        goto L7
    L9:
        return r103.build().toString();
    L16:
        return r100;
    L15:
        return r100;
    }

    public static void a(n r100, JSONObject r101, JSONObject r102) {
        r100.getClass();
        String r103 = r101.optString("reserve_url");
        if (TextUtils.isEmpty(r103) == true) goto L10;
        HashMap r104 = new HashMap();
        r104.put("unified_game_id", r101.optString("order_id"));
        JSONObject r105 = r101.optJSONObject("extra");
        if (r105 == null) goto L8;
        r104.put(com.bytedance.android.ec.core.event.a.KEY_FROM_GROUP_ID, r105.optString(com.bytedance.android.ec.core.event.a.KEY_FROM_GROUP_ID));
    L8:
        j r106 = new j(r100, r101, r102);
        DownloadComponentManager.getInstance().submitCPUTask(new l(r103, r104, r106));
        return;
    }

    public static void b(n r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        Map<String, p> r104 = r100.f245009a;
        HashMap r105 = (HashMap) r104;
        p r106 = (p) r105.get(r101.optString("order_id"));
        if (r106 == null) goto L14;
        int r107 = r102.optInt("code");
        if (r107 != 0) goto L11;
        JSONObject r108 = r102.optJSONObject("reserve_info");
        if (r108 != null) goto L9;
        r108 = new JSONObject();
    L9:
        r106.e(r108);
        return;
    L11:
        if (r107 != 100) goto L16;
        r106.c(r103);
        return;
    L16:
        return;
    }
}
