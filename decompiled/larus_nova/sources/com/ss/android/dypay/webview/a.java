package com.ss.android.dypay.webview;

import android.app.Activity;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.android.ttcjpaysdk.base.ui.dialog.CJPayLynxStandardKeepActivity;
import com.bytedance.android.shopping.buynow.data.model.PageType;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import org.json.JSONException;
import org.json.JSONObject;
import wta.f;
import wta.g;
import wta.h;
import wta.i;
import wta.j;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Activity> f408528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Class<? extends c>> f408529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f408530c;

    /* JADX INFO: renamed from: com.ss.android.dypay.webview.a$a, reason: collision with other inner class name */
    public static final class C4736a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f408531a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f408532b;

        public C4736a(a r100, String r101) {
            this.f408531a = r100;
            this.f408532b = r101;
        }

        public final void a(String r100, int r101) {
            a.a(this.f408531a, r101, r100, new JSONObject(), this.f408532b);
        }
    }

    public a(Activity r100, e r101) {
        this.f408530c = r101;
        this.f408528a = new WeakReference(r100);
        this.f408529b = MapsKt.mapOf(new Pair[]{TuplesKt.to("closeCallback", wta.a.class), TuplesKt.to(PageType.CONTINUEPAY, wta.b.class), TuplesKt.to("downloadDouyin", wta.c.class), TuplesKt.to("openAppSchema", wta.d.class), TuplesKt.to("setContainer", g.class), TuplesKt.to("setScreenShotEnable", f.class), TuplesKt.to("setPageReady", h.class), TuplesKt.to("getSettings", j.class), TuplesKt.to("showNav", i.class)});
    }

    public final void b(String r100, String r101, String r102) {
        C4736a r103 = new C4736a(this, r102);
        if (r101.length() != 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L8;
        JSONObject r105 = new JSONObject();
    L9:
        Class<? extends c> r106 = this.f408529b.get(r100);
        if (r106 == null) goto L14;
        c r107 = r106.newInstance();
        if (r107 == null) goto L14;
        r107.a(this.f408528a.get(), r105, r103);
        return;
    L14:
        c("jsb方法未注册", new JSONObject(), r102);
        return;
    L8:
        r105 = new JSONObject(r101);
        goto L9
    L5:
        r104 = false;
        goto L6
    }

    public final void c(String r100, JSONObject r101, String r102) {
        JSONObject r103 = new JSONObject();
        r103.put("code", 0);     // Catch: JSONException -> L8
        r103.put("msg", r100);     // Catch: JSONException -> L8
        r103.put("timestamp", System.currentTimeMillis());     // Catch: JSONException -> L8
        r103.put("response_id", r102);     // Catch: JSONException -> L8
        r103.put("params", r101);     // Catch: JSONException -> L8
    L6:
        this.f408530c.a(r103.toString());
    }

    @JavascriptInterface
    public final void jsbCall(String r100) {
        JSONObject r101 = new JSONObject(r100);     // Catch: Throwable -> L4
        b(r101.optString(com.alipay.sdk.m.p.e.f25671s), r101.optString("params"), r101.optString(CJPayLynxStandardKeepActivity.INTENT_CALLBACK_ID));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        c(Log.getStackTraceString(th), new JSONObject(), "");
    }

    public static final void a(a r100, int r101, String r102, JSONObject r103, String r104) {
        r100.getClass();
        JSONObject r105 = new JSONObject();
        r105.put("code", Integer.valueOf(r101));     // Catch: Exception -> L13
    L19:
        r105.put("msg", r102);     // Catch: Exception -> L14
    L17:
        r105.put("data", r103);     // Catch: Exception -> L15
    L7:
        JSONObject r106 = new JSONObject();
        r106.put("code", 1);     // Catch: JSONException -> L16
        r106.put("msg", "success");     // Catch: JSONException -> L16
        r106.put("timestamp", System.currentTimeMillis());     // Catch: JSONException -> L16
        r106.put("response_id", r104);     // Catch: JSONException -> L16
        r106.put("params", r105);     // Catch: JSONException -> L16
    L11:
        r100.f408530c.a(r106.toString());
    }
}
