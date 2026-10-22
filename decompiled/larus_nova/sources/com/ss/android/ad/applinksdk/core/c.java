package com.ss.android.ad.applinksdk.core;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ad.applinksdk.interceptor.InterceptorModel;
import com.ss.android.ad.applinksdk.interceptor.pack.PackageInterceptorManager;
import com.ss.android.ad.applinksdk.interceptor.url.UrlInterceptorManager;
import com.ss.android.ad.applinksdk.model.AppLinkEventConfig;
import com.ss.android.ad.applinksdk.model.AppLinkResult;
import com.ss.android.ad.applinksdk.utils.MonitorUtils;
import java.util.List;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f406355a = null;

    public c() {
    }

    static {
        f406355a = new c();
        d.f406360e.getClass();
    }

    public static AppLinkResult a(Context r100, ira.d r101, AppLinkEventConfig r102) {
        String r103 = "open_url_app";
        Object r104 = null;
        if (r100 != null) goto L7;
        d.f406360e.getClass();
        r100 = null;
    L7:
        if (r100 == null) goto L49;
        Intent r105 = r101.f495534j;
        if (r105 == null) goto L47;
        r101.f495535k = 3;
        ira.e r106 = new ira.e(r101, r102);
        r106.f495542a = null;
        b.c("applink_click", null, r106);
        b.g("bdal_applink_intent_click", new JSONObject());
        AppLinkResult r107 = g.a(r100, r105, r106);
        JSONObject r108 = new JSONObject();
        String r109 = r102.f406382c;     // Catch: Exception -> L17
        if (r109 != null) goto L15;
        r109 = "open_url_app";
    L15:
        r108.putOpt("user_label", r109);     // Catch: Exception -> L17
    L20:
        if (r107.a() == false) goto L22;
        b.g("bdal_applink_intetn_url_app_success", r108);
    L23:
        int r110 = g.f406364a;
        if (r107.a() == false) goto L51;
        JSONObject[] r111 = new JSONObject[3];
        r111[0] = b.a(r106);
        JSONObject r112 = new JSONObject();
        String r113 = r106.f495546e.f406382c;     // Catch: Exception -> L31
        if (r113 == null) goto L29;
        r103 = r113;
    L29:
        r112.putOpt("user_label", r103);     // Catch: Exception -> L31
    L33:
        r111[1] = r112;
        r111[2] = r106.f495546e.f406386g;
        b.g("bdal_applink_intent_url_app_user", mra.e.b(r111));
        b.f(r106);
        int r114 = mra.a.f515032a;
        d r115 = d.f406360e;
        r115.getClass();
        List<Object> r116 = jra.a.f500155a;
        mra.d.b(new jra.b(r106), 5000);
        int r117 = jra.c.f500159a;
        r115.getClass();
    L46:
        return r107;
    L31:
        e = move-exception;
        r112.putOpt("user_label", e.getMessage());
        goto L33
    L51:
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L39
        JSONObject r119 = new JSONObject().putOpt("open_fail_message", Integer.valueOf(r107.f406390b)).putOpt("open_url", r106.f495545d.f495529e).putOpt("applink_jump_type", Integer.valueOf(r106.f495545d.f495535k));     // Catch: Throwable -> L39
        String r120 = r106.f495546e.f406382c;     // Catch: Throwable -> L39
        if (r120 == null) goto L37;
        r103 = r120;
    L37:
        Object r121 = Result.m9449constructorimpl(r119.putOpt("user_label", r103));     // Catch: Throwable -> L39
    L42:
        if (Result.m9455isFailureimpl(r121) == true) goto L45;
        r104 = r121;
    L45:
        b.g("bdal_applink_open_fail", (JSONObject) r104);
    L39:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r121 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L42
    L22:
        b.g("bdal_applink_intent_url_app_fail", r108);
    L17:
        e = move-exception;
        r108.putOpt("user_label", e.getMessage());
        goto L20
    L47:
        AppLinkResult.Type.Companion.getClass();
        AppLinkResult.Message.Companion.getClass();
        return new AppLinkResult(-1, 31);
    L49:
        AppLinkResult.Type.Companion.getClass();
        AppLinkResult.Message.Companion.getClass();
        return new AppLinkResult(-1, 15);
    }

    public static AppLinkResult b(ira.d r100, AppLinkEventConfig r101, ira.b r102, List r103) {
        r100.f495535k = 2;
        ira.e r104 = new ira.e(r100, r101);
        r104.f495542a = r102;
        if (r102 != null) goto L5;
    L15:
        Lazy r105 = PackageInterceptorManager.f406372a;
        d.f406360e.getClass();
        Lazy r106 = PackageInterceptorManager.f406373b;     // Catch: Exception -> L21
        ((List) r106.getValue()).clear();     // Catch: Exception -> L21
        ((List) r106.getValue()).addAll((List) PackageInterceptorManager.f406372a.getValue());     // Catch: Exception -> L21
        if (r103 == null) goto L19;
        ((List) r106.getValue()).addAll(((List) r106.getValue()).size() - 1, r103);     // Catch: Exception -> L21
    L19:
        List r107 = (List) PackageInterceptorManager.f406373b.getValue();
        return ((com.ss.android.ad.applinksdk.interceptor.a) ListProtector.get(r107, 0)).intercept(new com.ss.android.ad.applinksdk.interceptor.b(r107, new InterceptorModel(r104, null), 1));
    L5:
        if (r102.f495503a != true) goto L15;
        if (Build.VERSION.SDK_INT < 26) goto L15;
        List<Object> r108 = jra.a.f500155a;
        if (jra.a.a() == false) goto L15;
        ira.b r109 = r104.f495542a;
        if (r109 == null) goto L15;
        if (r109.f495504b != true) goto L15;
        r100.f495536l = 1;
        goto L15
    }

    public static AppLinkResult d(Context r100, ira.d r101, AppLinkEventConfig r102, ira.b r103, List r110) {
        if (r100 != null) goto L6;
        d.f406360e.getClass();
        r100 = null;
    L6:
        AppLinkDataManager.AppLinkDataCache r104 = AppLinkDataManager.f406352a;
        d.f406360e.getClass();
        ((d.a) d.a()).getClass();
        boolean r105 = false;
        if (new JSONObject().optInt("enable_revise_data", 1) != 1) goto L9;
        boolean r106 = true;
    L10:
        if (r106 == true) goto L12;
    L32:
        r101.f495535k = 1;
        ira.e r107 = new ira.e(r101, r102);
        if (r103 == null) goto L35;
        r103.f495506d = false;
    L35:
        r107.f495542a = r103;
        if (r103 != null) goto L38;
    L44:
        d.f406360e.getClass();
        AppLinkResult r108 = UrlInterceptorManager.a(r107, r100, r110);
        if (r103 != null) goto L47;
        return r108;
    L47:
        if (r103.f495505c == true) goto L49;
        return r108;
    L49:
        if (r108.a() == true) goto L67;
        String r109 = r101.f495530f;
        if (r109 != null) goto L53;
    L54:
        r105 = true;
    L55:
        if (r105 == true) goto L68;
        int r111 = r108.f406390b;
        AppLinkResult.Message.Companion.getClass();
        if (r111 != 15) goto L59;
    L60:
        r103.f495509g = true;
    L62:
        return b(r101, r102, r103, r110);
    L59:
        if (r108.f406390b != 12) goto L62;
    L68:
        return r108;
    L53:
        if (r109.length() != 0) goto L55;
    L67:
        return r108;
    L38:
        if (r103.f495503a != true) goto L44;
        if (Build.VERSION.SDK_INT < 26) goto L44;
        List<Object> r112 = jra.a.f500155a;
        if (jra.a.a() == false) goto L44;
        r101.f495536l = 1;
        goto L44
    L12:
        if (r101.f495527c == false) goto L32;
        if (((ira.a) AppLinkDataManager.f406352a.get(Long.valueOf(r101.f495526b))) == null) goto L32;
        String r113 = r101.f495528d;
        if (r113 != null) goto L19;
    L22:
        boolean r114 = true;
    L23:
        if (r114 == true) goto L31;
        String r115 = r101.f495528d;
        if (r115 != null) goto L63;
    L29:
        boolean r116 = false;
    L30:
        if (r116 == true) goto L32;
    L63:
        new JSONObject(r115);     // Catch: JSONException -> L28
        r116 = true;
    L31:
        r101.f495528d = null;
        MonitorUtils.a("revise logExtra");
        goto L32
    L19:
        if (r113.length() == 0) goto L22;
        r114 = false;
        goto L23
    L9:
        r106 = false;
        goto L10
    }

    public static void c(Context r100, ira.d r101, AppLinkEventConfig r102, ira.b r103, List r104, a r105) {
        if (r100 != null) goto L5;
        d.f406360e.getClass();
        r100 = null;
    L5:
        r101.f495535k = 4;
        ira.e r106 = new ira.e(r101, r102);
        r103.f495506d = true;
        r106.f495542a = r103;
        r106.f495543b = r105;
        if (r103.f495503a == true) goto L8;
    L12:
        UrlInterceptorManager.a(r106, r100, r104);
        return;
    L8:
        if (Build.VERSION.SDK_INT < 26) goto L12;
        List<Object> r107 = jra.a.f500155a;
        if (jra.a.a() == false) goto L12;
        r101.f495536l = 1;
        goto L12
    }
}
