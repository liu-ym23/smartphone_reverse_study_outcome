package s45;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f extends sbb.b {
    public int A;
    public long B;
    public String C;
    public final c D;
    public Pattern E;
    public String F;
    public String[] k;
    public String[] l;
    public String[] m;
    public String[] n;
    public String[] o;
    public String p;
    public String q;
    public Map<String, String> r;
    public Map<String, String> s;
    public String t;
    public String u;
    public String v;
    public Pattern w;
    public Pattern x;
    public String y;
    public boolean z;

    public f() {
        com.bytedance.ee.bear.appsetting.c r0 = com.bytedance.ee.bear.appsetting.c.a.a;
        super((String) r0.d("domain_config", ""));
        this.k = new String[]{"space"};
        this.l = sbb.f.a;
        this.n = sbb.f.b;
        this.o = sbb.f.d;
        this.p = "";
        this.q = "workspace";
        this.r = sbb.f.h;
        this.s = sbb.f.g;
        this.t = "/blank/";
        this.u = "/ssr_template/";
        this.v = "/workspace/${type}/${token}";
        this.w = PatternProtector.compile("^(/space|/drive)?/(doc|docs|sheet|sheets|mindnote|mindnotes|slide|slides|file|bitable|base|folder|wiki|isv|docx)/[^\\/]{14,}(/)?");
        this.x = PatternProtector.compile("(bytedance(\\.(sg|us|jp))?)\\.feishu\\.cn");
        this.y = "$1.larkoffice.com";
        this.z = false;
        this.A = 86400000;
        this.C = "";
        this.E = PatternProtector.compile("/app/");
        this.F = "app";
        String r1 = (String) r0.d("domain_config", "");
        Intrinsics.checkNotNullParameter("privatizationConfig", "name");
        com.ss.android.lark.storage.kv.repo.a r2 = ay4.b.b("privatizationConfig", true, ay4.b.a("privatizationConfig"));
        Intrinsics.checkNotNullParameter(r2, "repo");
        new ArrayList();
        Intrinsics.checkNotNullParameter("domain_pool", "key");
        i(r2.getString("domain_pool", ""));
        Intrinsics.checkNotNullParameter("space_api", "key");
        m(r2.getString("space_api", ""));
        tt5.a.b("DomainConfigParser", "DomainConfig()...json = " + r1 + ", mainDomain = " + this.C);
    }

    public final String f() {
        String[] r0 = this.k;
        if (r0 != null) goto L5;
        return "space";
    L5:
        if (r0.length > 0) goto L7;
        return "space";
    L7:
        return r0[0];
    }

    public f(c r5) {
        com.bytedance.ee.bear.appsetting.c r0 = com.bytedance.ee.bear.appsetting.c.a.a;
        super((String) r0.d("domain_config", ""));
        this.k = new String[]{"space"};
        this.l = sbb.f.a;
        this.n = sbb.f.b;
        this.o = sbb.f.d;
        this.p = "";
        this.q = "workspace";
        this.r = sbb.f.h;
        this.s = sbb.f.g;
        this.t = "/blank/";
        this.u = "/ssr_template/";
        this.v = "/workspace/${type}/${token}";
        this.w = PatternProtector.compile("^(/space|/drive)?/(doc|docs|sheet|sheets|mindnote|mindnotes|slide|slides|file|bitable|base|folder|wiki|isv|docx)/[^\\/]{14,}(/)?");
        this.x = PatternProtector.compile("(bytedance(\\.(sg|us|jp))?)\\.feishu\\.cn");
        this.y = "$1.larkoffice.com";
        this.z = false;
        this.A = 86400000;
        String[] r3 = sbb.f.a;
        this.C = "";
        this.E = PatternProtector.compile("/app/");
        this.F = "app";
        this.D = r5;
        String r1 = (String) r0.d("domain_config", "");
        tt5.a.h("DomainConfigParser", "domainConfigStr = " + r1);
        a(r1);
        c(r1);
        e();
        i(r5.getString("domain_pool", ""));
        m(r5.getString("space_api", ""));
        tt5.a.b("DomainConfigParser", "DomainConfig()...json = " + r1 + ", mainDomain = " + this.C);
    }

    public static String[] g(JSONArray r3) {
        if (r3 != null) goto L4;
    L9:
        return null;
    L4:
        if (r3.length() <= 0) goto L9;
        String[] r0 = new String[r3.length()];
        int r1 = 0;
    L7:
        if (r1 >= r3.length()) goto L12;
        r0[r1] = r3.optString(r1);
        r1 = r1 + 1;
        goto L7
    L12:
        return r0;
    }

    public static Map l(JSONObject r4) {
        if (r4 == null) goto L4;
        Iterator<String> r0 = r4.keys();
        HashMap r1 = new HashMap();
    L7:
        if (r0.hasNext() == false) goto L9;
        String r2 = r0.next();
        r1.put(r2, r4.optString(r2));
        goto L7
    L9:
        r1.put("/drive/folder/", "folder");
        r1.put("/space/api/obj_template/create_i18n_obj/", "template_create");
        return r1;
    L4:
        return sbb.f.g;
    }

    public final void a(String r6) {
        if (TextUtils.isEmpty(r6) == false) goto L21;
        tt5.a.d("DomainConfigParser", "parseDomainConfig()... json is empty");
        return;
    L21:
        JSONObject r2 = new JSONObject(r6);     // Catch: JSONException -> L18
        String[] r7 = g(r2.optJSONArray("pathlist"));     // Catch: JSONException -> L18
        if (r7 == null) goto L10;
        this.k = r7;     // Catch: JSONException -> L18
    L10:
        String[] r8 = g(r2.optJSONArray("whitePathList"));     // Catch: JSONException -> L18
        if (r8 == null) goto L13;
        this.l = r8;     // Catch: JSONException -> L18
    L13:
        String[] r9 = g(r2.optJSONArray("blackPathList"));     // Catch: JSONException -> L18
        if (r9 == null) goto L16;
        this.m = r9;     // Catch: JSONException -> L18
    L16:
        g(r2.optJSONArray("productJoinWiki"));     // Catch: JSONException -> L18
        this.p = r2.optString("h5PathPrefix");     // Catch: JSONException -> L18
        this.q = r2.optString("phoenixPathPrefix", "workspace");     // Catch: JSONException -> L18
        d(r2);     // Catch: JSONException -> L18
        h(r2);     // Catch: JSONException -> L18
        this.r = k(r2.optJSONObject("pathGenerator"));     // Catch: JSONException -> L18
        this.s = l(r2.optJSONObject("pathMap"));     // Catch: JSONException -> L18
        j(r2);     // Catch: JSONException -> L18
        tt5.a.h("DomainConfigParser", String.format("DomainConfig()...mWebPathPrefix = %s\n mPhoenixPathPrefix = %s \n mPathGenerator = %s\n mPathMap = %s\n pathList = %s", new Object[]{this.p, this.q, this.r.toString(), this.s.toString(), Arrays.toString(this.k)}));     // Catch: JSONException -> L18
        return;
    L18:
        e = move-exception;
        tt5.a.f("DomainConfigParser", e, false);
    }

    public final void d(JSONObject r6) {
        JSONObject r7 = r6.optJSONObject(((sbb.b) this).h);
        String r1 = "^(/space|/drive)?/(doc|docs|sheet|sheets|mindnote|mindnotes|slide|slides|file|bitable|base|folder|wiki|isv|docx)/[^\\/]{14,}(/)?";
        String r2 = "/([\\w]{14,})";
        if (r7 == null) goto L12;
        r1 = r7.optString("androidUrlReg", "^(/space|/drive)?/(doc|docs|sheet|sheets|mindnote|mindnotes|slide|slides|file|bitable|base|folder|wiki|isv|docx)/[^\\/]{14,}(/)?");
        ((sbb.b) this).d = r7.optString(((sbb.b) this).f, "/(doc|docs|sheet|sheets|mindnote|mindnotes|slide|slides|file|bitable|base|folder|wiki|isv|docx)/");
        r2 = r7.optString(((sbb.b) this).g, "/([\\w]{14,})");
    L12:
        this.w = PatternProtector.compile(r1);     // Catch: Exception -> L8
        ((sbb.b) this).a = PatternProtector.compile(((sbb.b) this).d);     // Catch: Exception -> L8
        ((sbb.b) this).b = PatternProtector.compile(r2);     // Catch: Exception -> L8
    L10:
        tt5.a.h("DomainConfigParser", String.format("parseProductPattern()...mUrlReg = %s\n mTypeReg = %s\n mTokenReg = %s", new Object[]{r1, ((sbb.b) this).d, r2}));
        return;
    L8:
        e = move-exception;
        tt5.a.f("DomainConfigParser", e, false);
        goto L10
    }

    public final void h(JSONObject r5) {
        this.F = r5.optString("base_app_path_type", "app");     // Catch: Exception -> L9
        String r6 = r5.optString("base_app_product_path_pattern");     // Catch: Exception -> L9
        if (TextUtils.isEmpty(r6) == false) goto L7;
        tt5.a.h("DomainConfigParser", "parseBaseAppProductPathPattern()...regex is empty");     // Catch: Exception -> L9
        return;
    L7:
        tt5.a.h("DomainConfigParser", "parseBaseAppProductPathPattern()...regex = " + r6);     // Catch: Exception -> L9
        this.E = PatternProtector.compile(r6);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        tt5.a.f("DomainConfigParser", e, false);
    }

    public final void i(String r3) {
        tt5.a.h("DomainConfigParser", "parseDomainPoolStr()...domainPoolStr = " + r3);
        if (TextUtils.isEmpty(r3) == false) goto L12;
        return;
    L12:
        String[] r4 = g(new JSONArray(r3));     // Catch: JSONException -> L9
        if (r4 == null) goto L14;
        this.n = r4;     // Catch: JSONException -> L9
        return;
    L14:
        return;
    L9:
        e = move-exception;
        tt5.a.f("DomainConfigParser", e, false);
    }

    public final void j(JSONObject r6) {
        this.x = PatternProtector.compile(r6.optString("previousDomainReg"));     // Catch: Exception -> L5
        this.y = r6.optString("newDomainReplacement");     // Catch: Exception -> L5
        this.z = r6.optBoolean("reloadDomainPool");     // Catch: Exception -> L5
        this.A = r6.optInt("reloadInterval");     // Catch: Exception -> L5
        tt5.a.h("DomainConfigParser", String.format("DomainConfig()...mPreviousDomainPattern = %s\n mNewDomainReplacement = %s \n mReloadDomainPool = %s\n mReloadInterval = %s", new Object[]{this.x, this.y, Boolean.valueOf(this.z), Integer.valueOf(this.A)}));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.f("DomainConfigParser", e, false);
    }

    public final Map<String, String> k(JSONObject r5) {
        if (r5 == null) goto L4;
        r5.optString("help");
        r5.optString("upgrade");
        this.t = r5.optString("blank");
        this.u = r5.optString("ssrTemplatePath", "/ssr_template/");
        this.v = r5.optString("phoenix", "/workspace/${type}/${token}");
        tt5.a.h("DomainConfigParser", "parsePathGenerator()...mPhoenixPath = " + this.v);
        Iterator<String> r0 = r5.keys();
        HashMap r1 = new HashMap();
    L7:
        if (r0.hasNext() == false) goto L9;
        String r2 = r0.next();
        r1.put(r2, r5.optString(r2));
        goto L7
    L9:
        return r1;
    L4:
        return sbb.f.h;
    }

    public final void m(String r3) {
        tt5.a.h("DomainConfigParser", "parseSpaceApiHostArray()...spaceApiStr = " + r3);
        if (TextUtils.isEmpty(r3) == false) goto L12;
        return;
    L12:
        String[] r4 = g(new JSONArray(r3));     // Catch: JSONException -> L9
        if (this.o == null) goto L14;
        this.o = r4;     // Catch: JSONException -> L9
        return;
    L14:
        return;
    L9:
        e = move-exception;
        tt5.a.f("DomainConfigParser", e, false);
    }
}
