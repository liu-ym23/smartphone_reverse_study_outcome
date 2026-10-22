package com.ss.android.ttve.monitor;

import com.bytedance.ies.common.IESAppLogger;
import com.ss.android.ttvecamera.BuildConfig;
import com.ss.android.vesdk.VELogUtil;
import com.ss.android.vesdk.y0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f449933a;

    public interface a {
    }

    public static void a(String r100, JSONObject r101, String r102) {
        b(r100, r101, r102, true, false);
    }

    public static void c(String r100, String r101, JSONObject r102, boolean r103) {
        VELogUtil.d("ApplogUtils", "onEventReport " + r100 + ": " + r102 + " ,reportToBusiness : " + r103);
        y0.a("ApplogUtils-onEventReport");
        if (r101.equals("business") == false) goto L9;
        if (r103 == true) goto L9;
        JSONObject r104 = new JSONObject();     // Catch: JSONException -> L7
        r104.put("ApiName", r100);     // Catch: JSONException -> L7
        r104.put("ApiParam", r102.toString());     // Catch: JSONException -> L7
        r104.put("ApiResult", r104.opt("resultCode"));     // Catch: JSONException -> L7
        IESAppLogger.sharedInstance().appLogOnEvent("vesdk_api", r104, "business", r103);     // Catch: JSONException -> L7
    L10:
        y0.b();
        return;
    L7:
        e = move-exception;
        VELogUtil.e(b.class, "JSON error", e);
    L9:
        IESAppLogger.sharedInstance().appLogOnEvent(r100, r102, r101, r103);
        goto L10
    }

    public static void b(String r100, JSONObject r101, String r102, boolean r103, boolean r104) {
        if (IESAppLogger.sharedInstance().isSampled(r100) == false) goto L7;
        VELogUtil.d("ApplogUtils", r100 + " is sampled");
        return;
    L7:
        if (r101 != null) goto L20;
        r101 = new JSONObject();
    L20:
        r101.put(com.heytap.mcssdk.constant.b.C, BuildConfig.VE_VERSION);     // Catch: JSONException -> L11
    L14:
        if (f449933a == true) goto L16;
        if (r104 == true) goto L16;
    L17:
        if (r103 == false) goto L22;
        c(r100, r102, r101, false);
        return;
    L22:
        return;
    L16:
        c(r100, r102, r101, true);
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }
}
