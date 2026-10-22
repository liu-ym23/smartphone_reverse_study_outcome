package f25;

import com.bytedance.ee.bear.contract.i0;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final class t implements okhttp3.h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final okhttp3.h f475202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i0 f475203c;

    public static void d() {
        ArrayList r100 = new ArrayList();
        JSONArray r101 = JSONObjectProtectorUtils.getJSONArray(new JSONObject((String) com.bytedance.ee.bear.appsetting.c.a.f206237a.d("biz_domain_config", "")), "docs_white_domain");     // Catch: Exception -> L12
        if (r101 != null) goto L6;
    L10:
        tt5.a.h("WebviewCookiesAdapter", "white domain is empty.");     // Catch: Exception -> L12
    L14:
        ml5.b r102 = new ml5.b("debug_config");
        Boolean r103 = Boolean.TRUE;
        tt5.a.h("WebviewCookiesAdapter", "renderAccelerate: " + ((Boolean) r102.a("renderAccelerate", r103)).booleanValue() + " resourceIntercept: " + ((Boolean) r102.a("resourceIntercept", r103)).booleanValue());
        return;
    L6:
        if (r101.length() <= 0) goto L10;
        int r104 = r101.length();     // Catch: Exception -> L12
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L14;
        String r106 = JSONArrayProtectorUtils.getString(r101, r105);     // Catch: Exception -> L12
        r100.add(r106);     // Catch: Exception -> L12
        tt5.a.h("WebviewCookiesAdapter", "white domain: " + r106);     // Catch: Exception -> L12
        r105 = r105 + 1;     // Catch: Exception -> L12
    L12:
        e = move-exception;
        tt5.a.l("WebviewCookiesAdapter", "Failed to initWhiteDomains", e);
        goto L14
    }

    public t(okhttp3.h r100) {
        this.f475202b = r100;
        d();
    }

    @Override // okhttp3.h
    public final List<okhttp3.g> a(HttpUrl r100) {
        ArrayList r101 = new ArrayList();
        if (this.f475203c != null) goto L5;
        this.f475203c = (i0) org.koin.java.a.a(i0.class);
    L5:
        Locale r102 = this.f475203c.c();
        if (r102 != null) goto L8;
        tt5.a.k("WebviewCookiesAdapter", "Locale is empty.");
    L8:
        if (r102 != null) goto L10;
        r102 = Locale.ENGLISH;
    L10:
        okhttp3.g.a r103 = new okhttp3.g.a();
        r103.a(r100.host(), true);
        r103.c(CommonConstant.ReqAccessTokenParam.LANGUAGE_LABEL);
        r103.e(r102.getLanguage());
        r101.add(new okhttp3.g(r103));
        okhttp3.g.a r104 = new okhttp3.g.a();
        r104.a(r100.host(), true);
        r104.c("locale");
        r104.e(r102.getLanguage() + "_" + r102.getCountry().toUpperCase());
        r101.add(new okhttp3.g(r104));
        return r101;
    }

    public static boolean c(String r100, String r101) {
        if (r100.endsWith(r101) == false) goto L9;
        int r102 = (r100.length() - r101.length()) - 1;
        if (r102 >= 0) goto L7;
        return false;
    L7:
        if (r100.charAt(r102) != '.') goto L12;
        return true;
    L12:
        return false;
    L9:
        return false;
    }

    @Override // okhttp3.h
    public final void b(HttpUrl r100, List<okhttp3.g> r101) {
        this.f475202b.b(r100, r101);
    }
}
