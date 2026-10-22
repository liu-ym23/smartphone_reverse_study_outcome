package sa5;

import android.text.TextUtils;
import android.webkit.CookieManager;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.larkicon.util.BizDomainConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class l implements okhttp3.h {
    public final List<String> b;
    public final qu5.a.a c;

    public l(qu5.a.a r8) {
        this.c = r8;
        ArrayList r0 = new ArrayList();
        JSONArray r1 = JSONObjectProtectorUtils.getJSONArray(new JSONObject(SettingManager.getInstance().getString(BizDomainConfig.class)), "docs_white_domain");     // Catch: Exception -> L12
        if (r1 != null) goto L6;
    L10:
        tt5.a.h("CookiesAdapterV2", "white domain is empty.");     // Catch: Exception -> L12
    L14:
        this.b = r0;
        return;
    L6:
        if (r1.length() <= 0) goto L10;
        int r2 = r1.length();     // Catch: Exception -> L12
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L14;
        String r4 = JSONArrayProtectorUtils.getString(r1, r3);     // Catch: Exception -> L12
        r0.add(r4);     // Catch: Exception -> L12
        tt5.a.h("CookiesAdapterV2", "white domain: " + r4);     // Catch: Exception -> L12
        r3 = r3 + 1;     // Catch: Exception -> L12
    L12:
        e = move-exception;
        tt5.a.l("CookiesAdapterV2", "Failed to initWhiteDomains", e);
        goto L14
    }

    public final List<okhttp3.g> a(HttpUrl r9) {
        ArrayList r0 = new ArrayList();
        qu5.a.a r1 = this.c;
        String r2 = "";
        if (r1 == null) goto L5;
        String r3 = r1.getToken();
    L6:
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        Locale r4 = Locale.ENGLISH;
        qu5.a.a r5 = this.c;
        if (r5 == null) goto L11;
        Locale r6 = r5.getLocale();
    L12:
        if (r6 == null) goto L15;
        r4 = r6;
    L15:
        String r7 = jcb.b.c().a("docs_main_domain");
        if (r7 == null) goto L19;
        r2 = r7;
    L19:
        String r8 = r9.host();
        int r10 = 0;
        if (TextUtils.isEmpty(r8) == false) goto L23;
    L43:
        boolean r11 = false;
    L45:
        if (r11 == false) goto L54;
        okhttp3.g.a r12 = new okhttp3.g.a();
        r12.a(r9.host(), true);
        r12.c("bear-session");
        r12.e(r3);
        r0.add(new okhttp3.g(r12));
        okhttp3.g.a r13 = new okhttp3.g.a();
        r13.a(r9.host(), true);
        r13.c("session");
        r13.e(r3);
        r0.add(new okhttp3.g(r13));
        String r14 = CookieManager.getInstance().getCookie(r9.toString());
        if (TextUtils.isEmpty(r14) == true) goto L54;
        String[] r16 = r14.split(";");
        int r17 = r16.length;
    L49:
        if (r10 >= r17) goto L54;
        String r18 = r16[r10];
        if (r18.contains("sl_session=") == true) goto L52;
        r10 = r10 + 1;
        goto L49
    L52:
        r0.add(okhttp3.g.c(r9, r18));
    L54:
        okhttp3.g.a r19 = new okhttp3.g.a();
        r19.a(r9.host(), true);
        r19.c("lang");
        r19.e(r4.getLanguage());
        r0.add(new okhttp3.g(r19));
        okhttp3.g.a r20 = new okhttp3.g.a();
        r20.a(r9.host(), true);
        r20.c("locale");
        r20.e(r4.getLanguage() + OfflineDoc.DASH_DELIMITER + r4.getCountry().toUpperCase());
        r0.add(new okhttp3.g(r20));
        return r0;
    L23:
        if (c(r8, "feishu.cn") == false) goto L25;
    L44:
        r11 = true;
        goto L45
    L25:
        if (c(r8, "larksuite.com") == true) goto L44;
        if (c(r8, "feishu.net") == true) goto L44;
        if (c(r8, "larkoffice.com") == true) goto L44;
        if (c(r8, r2) == true) goto L44;
        if (((ArrayList) this.b).size() <= 0) goto L43;
        int r21 = 0;
    L38:
        if (r21 >= ((ArrayList) this.b).size()) goto L43;
        if (c(r8, (String) ListProtector.get(this.b, r21)) == true) goto L44;
        r21 = r21 + 1;
        goto L38
    L11:
        r6 = r4;
        goto L12
    L5:
        r3 = "";
        goto L6
    }

    public static boolean c(String r1, String r2) {
        if (r1.endsWith(r2) == false) goto L9;
        int r0 = (r1.length() - r2.length()) - 1;
        if (r0 >= 0) goto L7;
        return false;
    L7:
        if (r1.charAt(r0) != '.') goto L12;
        return true;
    L12:
        return false;
    L9:
        return false;
    }

    public final void b(HttpUrl r3, List<okhttp3.g> r4) {
        String r5 = r3.toString();
        CookieManager r0 = CookieManager.getInstance();
        Iterator<okhttp3.g> r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r0.setCookie(r5, r6.next().toString());
        goto L4
    }
}
