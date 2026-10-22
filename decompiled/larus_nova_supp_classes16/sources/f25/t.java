package f25;

import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class t implements okhttp3.h {
    public final okhttp3.h b;
    public i0 c;

    public static void d() {
        ArrayList r1 = new ArrayList();
        JSONArray r2 = JSONObjectProtectorUtils.getJSONArray(new JSONObject((String) com.bytedance.ee.bear.appsetting.c.a.a.d("biz_domain_config", "")), "docs_white_domain");     // Catch: Exception -> L12
        if (r2 != null) goto L6;
    L10:
        tt5.a.h("WebviewCookiesAdapter", "white domain is empty.");     // Catch: Exception -> L12
    L14:
        ml5.b r3 = new ml5.b("debug_config");
        Boolean r4 = Boolean.TRUE;
        tt5.a.h("WebviewCookiesAdapter", "renderAccelerate: " + ((Boolean) r3.a("renderAccelerate", r4)).booleanValue() + " resourceIntercept: " + ((Boolean) r3.a("resourceIntercept", r4)).booleanValue());
        return;
    L6:
        if (r2.length() <= 0) goto L10;
        int r5 = r2.length();     // Catch: Exception -> L12
        int r6 = 0;
    L8:
        if (r6 >= r5) goto L14;
        String r7 = JSONArrayProtectorUtils.getString(r2, r6);     // Catch: Exception -> L12
        r1.add(r7);     // Catch: Exception -> L12
        tt5.a.h("WebviewCookiesAdapter", "white domain: " + r7);     // Catch: Exception -> L12
        r6 = r6 + 1;     // Catch: Exception -> L12
    L12:
        e = move-exception;
        tt5.a.l("WebviewCookiesAdapter", "Failed to initWhiteDomains", e);
        goto L14
    }

    public t(okhttp3.h r1) {
        this.b = r1;
        d();
    }

    public final List<okhttp3.g> a(HttpUrl r6) {
        ArrayList r0 = new ArrayList();
        if (this.c != null) goto L5;
        this.c = (i0) org.koin.java.a.a(i0.class);
    L5:
        Locale r1 = this.c.c();
        if (r1 != null) goto L8;
        tt5.a.k("WebviewCookiesAdapter", "Locale is empty.");
    L8:
        if (r1 != null) goto L10;
        r1 = Locale.ENGLISH;
    L10:
        okhttp3.g.a r2 = new okhttp3.g.a();
        r2.a(r6.host(), true);
        r2.c("lang");
        r2.e(r1.getLanguage());
        r0.add(new okhttp3.g(r2));
        okhttp3.g.a r3 = new okhttp3.g.a();
        r3.a(r6.host(), true);
        r3.c("locale");
        r3.e(r1.getLanguage() + OfflineDoc.DASH_DELIMITER + r1.getCountry().toUpperCase());
        r0.add(new okhttp3.g(r3));
        return r0;
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

    public final void b(HttpUrl r2, List<okhttp3.g> r3) {
        this.b.b(r2, r3);
    }
}
