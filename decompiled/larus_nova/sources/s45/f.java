package s45;

import android.text.TextUtils;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.lark.inv.export.router.InvRouter$InviteMemberOrientationPage$Param$From;
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

/* JADX INFO: loaded from: classes16.dex */
public final class f extends sbb.b {
    public int A;
    public long B;
    public String C;
    public final c D;
    public Pattern E;
    public String F;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String[] f540552k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String[] f540553l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String[] f540554m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String[] f540555n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String[] f540556o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f540557p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f540558q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Map<String, String> f540559r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Map<String, String> f540560s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f540561t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f540562u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f540563v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Pattern f540564w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Pattern f540565x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f540566y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f540567z;

    public f() {
        com.bytedance.ee.bear.appsetting.c r100 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        super((String) r100.d("domain_config", ""));
        this.f540552k = new String[]{"space"};
        this.f540553l = sbb.f.f541319a;
        this.f540555n = sbb.f.f541320b;
        this.f540556o = sbb.f.f541322d;
        this.f540557p = "";
        this.f540558q = "workspace";
        this.f540559r = sbb.f.f541326h;
        this.f540560s = sbb.f.f541325g;
        this.f540561t = "/blank/";
        this.f540562u = "/ssr_template/";
        this.f540563v = "/workspace/${type}/${token}";
        this.f540564w = PatternProtector.compile("^(/space|/drive)?/(doc|docs|sheet|sheets|mindnote|mindnotes|slide|slides|file|bitable|base|folder|wiki|isv|docx)/[^\\/]{14,}(/)?");
        this.f540565x = PatternProtector.compile("(bytedance(\\.(sg|us|jp))?)\\.feishu\\.cn");
        this.f540566y = "$1.larkoffice.com";
        this.f540567z = false;
        this.A = BaseConstants.Time.DAY;
        this.C = "";
        this.E = PatternProtector.compile("/app/");
        this.F = "app";
        String r101 = (String) r100.d("domain_config", "");
        Intrinsics.checkNotNullParameter("privatizationConfig", "name");
        com.ss.android.lark.storage.kv.repo.a r102 = ay4.b.b("privatizationConfig", true, ay4.b.a("privatizationConfig"));
        Intrinsics.checkNotNullParameter(r102, "repo");
        new ArrayList();
        Intrinsics.checkNotNullParameter("domain_pool", "key");
        i(r102.getString("domain_pool", ""));
        Intrinsics.checkNotNullParameter("space_api", "key");
        m(r102.getString("space_api", ""));
        tt5.a.b("DomainConfigParser", "DomainConfig()...json = " + r101 + ", mainDomain = " + this.C);
    }

    public final String f() {
        String[] r100 = this.f540552k;
        if (r100 != null) goto L5;
        return "space";
    L5:
        if (r100.length > 0) goto L7;
        return "space";
    L7:
        return r100[0];
    }

    public f(c r100) {
        com.bytedance.ee.bear.appsetting.c r101 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        super((String) r101.d("domain_config", ""));
        this.f540552k = new String[]{"space"};
        this.f540553l = sbb.f.f541319a;
        this.f540555n = sbb.f.f541320b;
        this.f540556o = sbb.f.f541322d;
        this.f540557p = "";
        this.f540558q = "workspace";
        this.f540559r = sbb.f.f541326h;
        this.f540560s = sbb.f.f541325g;
        this.f540561t = "/blank/";
        this.f540562u = "/ssr_template/";
        this.f540563v = "/workspace/${type}/${token}";
        this.f540564w = PatternProtector.compile("^(/space|/drive)?/(doc|docs|sheet|sheets|mindnote|mindnotes|slide|slides|file|bitable|base|folder|wiki|isv|docx)/[^\\/]{14,}(/)?");
        this.f540565x = PatternProtector.compile("(bytedance(\\.(sg|us|jp))?)\\.feishu\\.cn");
        this.f540566y = "$1.larkoffice.com";
        this.f540567z = false;
        this.A = BaseConstants.Time.DAY;
        String[] r102 = sbb.f.f541319a;
        this.C = "";
        this.E = PatternProtector.compile("/app/");
        this.F = "app";
        this.D = r100;
        String r103 = (String) r101.d("domain_config", "");
        tt5.a.h("DomainConfigParser", "domainConfigStr = " + r103);
        a(r103);
        c(r103);
        e();
        i(r100.getString("domain_pool", ""));
        m(r100.getString("space_api", ""));
        tt5.a.b("DomainConfigParser", "DomainConfig()...json = " + r103 + ", mainDomain = " + this.C);
    }

    public static String[] g(JSONArray r100) {
        if (r100 != null) goto L4;
    L9:
        return null;
    L4:
        if (r100.length() <= 0) goto L9;
        String[] r101 = new String[r100.length()];
        int r102 = 0;
    L7:
        if (r102 >= r100.length()) goto L12;
        r101[r102] = r100.optString(r102);
        r102 = r102 + 1;
        goto L7
    L12:
        return r101;
    }

    public static Map l(JSONObject r100) {
        if (r100 == null) goto L4;
        Iterator<String> r101 = r100.keys();
        HashMap r102 = new HashMap();
    L7:
        if (r101.hasNext() == false) goto L9;
        String r103 = r101.next();
        r102.put(r103, r100.optString(r103));
        goto L7
    L9:
        r102.put("/drive/folder/", DocumentType.FOLDER_NAME);
        r102.put("/space/api/obj_template/create_i18n_obj/", "template_create");
        return r102;
    L4:
        return sbb.f.f541325g;
    }

    @Override // sbb.b
    public final void a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L21;
        tt5.a.d("DomainConfigParser", "parseDomainConfig()... json is empty");
        return;
    L21:
        JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L18
        String[] r102 = g(r101.optJSONArray("pathlist"));     // Catch: JSONException -> L18
        if (r102 == null) goto L10;
        this.f540552k = r102;     // Catch: JSONException -> L18
    L10:
        String[] r103 = g(r101.optJSONArray("whitePathList"));     // Catch: JSONException -> L18
        if (r103 == null) goto L13;
        this.f540553l = r103;     // Catch: JSONException -> L18
    L13:
        String[] r104 = g(r101.optJSONArray("blackPathList"));     // Catch: JSONException -> L18
        if (r104 == null) goto L16;
        this.f540554m = r104;     // Catch: JSONException -> L18
    L16:
        g(r101.optJSONArray("productJoinWiki"));     // Catch: JSONException -> L18
        this.f540557p = r101.optString("h5PathPrefix");     // Catch: JSONException -> L18
        this.f540558q = r101.optString("phoenixPathPrefix", "workspace");     // Catch: JSONException -> L18
        d(r101);     // Catch: JSONException -> L18
        h(r101);     // Catch: JSONException -> L18
        this.f540559r = k(r101.optJSONObject("pathGenerator"));     // Catch: JSONException -> L18
        this.f540560s = l(r101.optJSONObject("pathMap"));     // Catch: JSONException -> L18
        j(r101);     // Catch: JSONException -> L18
        tt5.a.h("DomainConfigParser", String.format("DomainConfig()...mWebPathPrefix = %s\n mPhoenixPathPrefix = %s \n mPathGenerator = %s\n mPathMap = %s\n pathList = %s", new Object[]{this.f540557p, this.f540558q, this.f540559r.toString(), this.f540560s.toString(), Arrays.toString(this.f540552k)}));     // Catch: JSONException -> L18
        return;
    L18:
        e = move-exception;
        tt5.a.f("DomainConfigParser", e, false);
    }

    @Override // sbb.b
    public final void d(JSONObject r100) {
        JSONObject r101 = r100.optJSONObject(this.f541287h);
        String r102 = "^(/space|/drive)?/(doc|docs|sheet|sheets|mindnote|mindnotes|slide|slides|file|bitable|base|folder|wiki|isv|docx)/[^\\/]{14,}(/)?";
        String r103 = "/([\\w]{14,})";
        if (r101 == null) goto L12;
        r102 = r101.optString("androidUrlReg", "^(/space|/drive)?/(doc|docs|sheet|sheets|mindnote|mindnotes|slide|slides|file|bitable|base|folder|wiki|isv|docx)/[^\\/]{14,}(/)?");
        this.f541283d = r101.optString(this.f541285f, "/(doc|docs|sheet|sheets|mindnote|mindnotes|slide|slides|file|bitable|base|folder|wiki|isv|docx)/");
        r103 = r101.optString(this.f541286g, "/([\\w]{14,})");
    L12:
        this.f540564w = PatternProtector.compile(r102);     // Catch: Exception -> L8
        this.f541280a = PatternProtector.compile(this.f541283d);     // Catch: Exception -> L8
        this.f541281b = PatternProtector.compile(r103);     // Catch: Exception -> L8
    L10:
        tt5.a.h("DomainConfigParser", String.format("parseProductPattern()...mUrlReg = %s\n mTypeReg = %s\n mTokenReg = %s", new Object[]{r102, this.f541283d, r103}));
        return;
    L8:
        e = move-exception;
        tt5.a.f("DomainConfigParser", e, false);
        goto L10
    }

    public final void h(JSONObject r100) {
        this.F = r100.optString("base_app_path_type", "app");     // Catch: Exception -> L9
        String r101 = r100.optString("base_app_product_path_pattern");     // Catch: Exception -> L9
        if (TextUtils.isEmpty(r101) == false) goto L7;
        tt5.a.h("DomainConfigParser", "parseBaseAppProductPathPattern()...regex is empty");     // Catch: Exception -> L9
        return;
    L7:
        tt5.a.h("DomainConfigParser", "parseBaseAppProductPathPattern()...regex = " + r101);     // Catch: Exception -> L9
        this.E = PatternProtector.compile(r101);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        tt5.a.f("DomainConfigParser", e, false);
    }

    public final void i(String r100) {
        tt5.a.h("DomainConfigParser", "parseDomainPoolStr()...domainPoolStr = " + r100);
        if (TextUtils.isEmpty(r100) == false) goto L12;
        return;
    L12:
        String[] r101 = g(new JSONArray(r100));     // Catch: JSONException -> L9
        if (r101 == null) goto L14;
        this.f540555n = r101;     // Catch: JSONException -> L9
        return;
    L14:
        return;
    L9:
        e = move-exception;
        tt5.a.f("DomainConfigParser", e, false);
    }

    public final void j(JSONObject r100) {
        this.f540565x = PatternProtector.compile(r100.optString("previousDomainReg"));     // Catch: Exception -> L5
        this.f540566y = r100.optString("newDomainReplacement");     // Catch: Exception -> L5
        this.f540567z = r100.optBoolean("reloadDomainPool");     // Catch: Exception -> L5
        this.A = r100.optInt("reloadInterval");     // Catch: Exception -> L5
        tt5.a.h("DomainConfigParser", String.format("DomainConfig()...mPreviousDomainPattern = %s\n mNewDomainReplacement = %s \n mReloadDomainPool = %s\n mReloadInterval = %s", new Object[]{this.f540565x, this.f540566y, Boolean.valueOf(this.f540567z), Integer.valueOf(this.A)}));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.f("DomainConfigParser", e, false);
    }

    public final Map<String, String> k(JSONObject r100) {
        if (r100 == null) goto L4;
        r100.optString("help");
        r100.optString(InvRouter$InviteMemberOrientationPage$Param$From.UPGRADE);
        this.f540561t = r100.optString("blank");
        this.f540562u = r100.optString("ssrTemplatePath", "/ssr_template/");
        this.f540563v = r100.optString("phoenix", "/workspace/${type}/${token}");
        tt5.a.h("DomainConfigParser", "parsePathGenerator()...mPhoenixPath = " + this.f540563v);
        Iterator<String> r101 = r100.keys();
        HashMap r102 = new HashMap();
    L7:
        if (r101.hasNext() == false) goto L9;
        String r103 = r101.next();
        r102.put(r103, r100.optString(r103));
        goto L7
    L9:
        return r102;
    L4:
        return sbb.f.f541326h;
    }

    public final void m(String r100) {
        tt5.a.h("DomainConfigParser", "parseSpaceApiHostArray()...spaceApiStr = " + r100);
        if (TextUtils.isEmpty(r100) == false) goto L12;
        return;
    L12:
        String[] r101 = g(new JSONArray(r100));     // Catch: JSONException -> L9
        if (this.f540556o == null) goto L14;
        this.f540556o = r101;     // Catch: JSONException -> L9
        return;
    L14:
        return;
    L9:
        e = move-exception;
        tt5.a.f("DomainConfigParser", e, false);
    }
}
