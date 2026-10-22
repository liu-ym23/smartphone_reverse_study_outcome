package il7;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class k {
    public static void a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return;
    L6:
        if (rk7.m.f538351e == null) goto L14;
        com.bytedance.ug.sdk.luckycat.impl.manager.q r101 = com.bytedance.ug.sdk.luckycat.impl.manager.q.b.f271365a;
        if (TextUtils.isEmpty(r100) == true) goto L14;
        ak7.c r102 = ak7.c.f4079b;
        String r103 = r102.J();
        if (TextUtils.isEmpty(r103) == true) goto L14;
        r102.f0(r103);
    L14:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("ResLoadManager", "getGeckoResPath() 从端上的获取gecko路径：" + r100 + ", geckoPath: null");
        int r104 = 1;
        boolean r105 = TextUtils.isEmpty(null) ^ true;
        JSONObject r106 = new JSONObject();
        if (r105 == true) goto L24;
        r104 = 0;
    L24:
        r106.put("success", r104).put("url_msg", r100);     // Catch: JSONException -> L21
        com.bytedance.ug.sdk.luckydog.api.log.b.a("luckydog_gecko_fetch", r106);     // Catch: JSONException -> L21
        return;
    L21:
        e = move-exception;
        e.printStackTrace();
    }
}
