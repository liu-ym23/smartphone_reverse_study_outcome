package sa5;

import android.text.TextUtils;
import android.webkit.CookieManager;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.larkicon.util.BizDomainConfig;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public class l implements okhttp3.h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f541173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final qu5.a.InterfaceC7393a f541174c;

    public l(qu5.a.InterfaceC7393a r100) {
        this.f541174c = r100;
        ArrayList r101 = new ArrayList();
        JSONArray r102 = JSONObjectProtectorUtils.getJSONArray(new JSONObject(SettingManager.getInstance().getString(BizDomainConfig.class)), "docs_white_domain");     // Catch: Exception -> L12
        if (r102 != null) goto L6;
    L10:
        tt5.a.h("CookiesAdapterV2", "white domain is empty.");     // Catch: Exception -> L12
    L14:
        this.f541173b = r101;
        return;
    L6:
        if (r102.length() <= 0) goto L10;
        int r103 = r102.length();     // Catch: Exception -> L12
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L14;
        String r105 = JSONArrayProtectorUtils.getString(r102, r104);     // Catch: Exception -> L12
        r101.add(r105);     // Catch: Exception -> L12
        tt5.a.h("CookiesAdapterV2", "white domain: " + r105);     // Catch: Exception -> L12
        r104 = r104 + 1;     // Catch: Exception -> L12
    L12:
        e = move-exception;
        tt5.a.l("CookiesAdapterV2", "Failed to initWhiteDomains", e);
        goto L14
    }

    @Override // okhttp3.h
    public final List<okhttp3.g> a(HttpUrl r100) {
        ArrayList r101 = new ArrayList();
        qu5.a.InterfaceC7393a r102 = this.f541174c;
        String r103 = "";
        if (r102 == null) goto L5;
        String r104 = r102.getToken();
    L6:
        if (r104 != null) goto L8;
        r104 = "";
    L8:
        Locale r105 = Locale.ENGLISH;
        qu5.a.InterfaceC7393a r106 = this.f541174c;
        if (r106 == null) goto L11;
        Locale r107 = r106.getLocale();
    L12:
        if (r107 == null) goto L15;
        r105 = r107;
    L15:
        String r108 = jcb.b.c().a("docs_main_domain");
        if (r108 == null) goto L19;
        r103 = r108;
    L19:
        String r109 = r100.host();
        int r110 = 0;
        if (TextUtils.isEmpty(r109) == false) goto L23;
    L43:
        boolean r111 = false;
    L45:
        if (r111 == false) goto L54;
        okhttp3.g.a r112 = new okhttp3.g.a();
        r112.a(r100.host(), true);
        r112.c("bear-session");
        r112.e(r104);
        r101.add(new okhttp3.g(r112));
        okhttp3.g.a r113 = new okhttp3.g.a();
        r113.a(r100.host(), true);
        r113.c(AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        r113.e(r104);
        r101.add(new okhttp3.g(r113));
        String r114 = CookieManager.getInstance().getCookie(r100.toString());
        if (TextUtils.isEmpty(r114) == true) goto L54;
        String[] r115 = r114.split(com.alipay.sdk.m.u.i.f25853b);
        int r116 = r115.length;
    L49:
        if (r110 >= r116) goto L54;
        String r117 = r115[r110];
        if (r117.contains("sl_session=") == true) goto L52;
        r110 = r110 + 1;
        goto L49
    L52:
        r101.add(okhttp3.g.c(r100, r117));
    L54:
        okhttp3.g.a r118 = new okhttp3.g.a();
        r118.a(r100.host(), true);
        r118.c(CommonConstant.ReqAccessTokenParam.LANGUAGE_LABEL);
        r118.e(r105.getLanguage());
        r101.add(new okhttp3.g(r118));
        okhttp3.g.a r119 = new okhttp3.g.a();
        r119.a(r100.host(), true);
        r119.c("locale");
        r119.e(r105.getLanguage() + "_" + r105.getCountry().toUpperCase());
        r101.add(new okhttp3.g(r119));
        return r101;
    L23:
        if (c(r109, "feishu.cn") == false) goto L25;
    L44:
        r111 = true;
        goto L45
    L25:
        if (c(r109, "larksuite.com") == true) goto L44;
        if (c(r109, "feishu.net") == true) goto L44;
        if (c(r109, "larkoffice.com") == true) goto L44;
        if (c(r109, r103) == true) goto L44;
        if (((ArrayList) this.f541173b).size() <= 0) goto L43;
        int r120 = 0;
    L38:
        if (r120 >= ((ArrayList) this.f541173b).size()) goto L43;
        if (c(r109, (String) ListProtector.get(this.f541173b, r120)) == true) goto L44;
        r120 = r120 + 1;
        goto L38
    L11:
        r107 = r105;
        goto L12
    L5:
        r104 = "";
        goto L6
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
        String r102 = r100.toString();
        CookieManager r103 = CookieManager.getInstance();
        Iterator<okhttp3.g> r104 = r101.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        r103.setCookie(r102, r104.next().toString());
        goto L4
    }
}
