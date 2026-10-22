package s45;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.ee.bear.bizwidget.sharepermissiondialog.BottomPopupData;
import com.bytedance.ee.bear.doc.docupgrade.DocRedirectToDocxPlugin;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@UserScope
public class p implements t45.c {
    public static String t;
    public static String u;
    public String a;
    public String b;
    public String c;
    public c d;
    public f e;
    public r f;
    public b g;
    public String h;
    public q i;
    public boolean j;
    public final CompositeDisposable k;
    public final Map<String, Map<String, String[]>> l;
    public final Map<String, Map<String, String[]>> m;
    public final Map<String, String[]> n;
    public final Map<String, String[]> o;
    public final awa.d p;
    public Pattern q;
    public Pattern r;
    public final Map<String, Boolean> s;

    @Override // t45.c
    public String T6(String r1, Integer r2) {
        return r1;
    }

    @Override // t45.c
    public final String Mc() {
        return this.e.u;
    }

    @Override // t45.c
    public final void S8() {
        final f r0 = this.e;
        r0.getClass();
        r0.B = System.currentTimeMillis();
        com.bytedance.ee.util.ui.m.a(new d(r0));
    }

    @Override // t45.c
    public final String T0() {
        return this.e.p;
    }

    @Override // t45.c
    public final String U0() {
        return this.e.t;
    }

    @Override // t45.c
    public final String X1() {
        return this.e.q;
    }

    public final void b() {
        tt5.a.h("SpaceKitUrlHelper", "getInstance singleInstance SpaceKitUrlHelper");
        f r1 = new f();
        this.e = r1;
        this.i = new q(r1);
        String r2 = (String) new ml5.b("debug_config").a("ip_proxy", "");
        this.h = r2;
        this.f = new r(r2);
        this.g = new b(this.e.m);
        if (TextUtils.isEmpty(this.h) == true) goto L7;
        String r3 = this.h;
        r r4 = this.f;
        String[] r5 = this.e.l;
        r4.getClass();
        int r6 = r5.length;
        int r7 = 0;
    L5:
        if (r7 >= r6) goto L7;
        r4.a(r3, r5[r7]);
        r7 = r7 + 1;
    L7:
        j();
        e(t);
        d(u);
        tt5.a.h("SpaceKitUrlHelper", "init()...mWhiteList " + this.f.b.toString());
        StringBuilder r8 = new StringBuilder("init()...urlRegex ");
        r r9 = this.f;
        r9.getClass();
        r8.append(String.format("%s%s%s", new Object[]{"(\\/|\\.)", r9.e, r9.g}));
        tt5.a.h("SpaceKitUrlHelper", r8.toString());
        c();
        i();
    }

    public final void c() {
        tt5.a.h("SpaceKitUrlHelper", "initMgApiDomain start");
        ((ConcurrentHashMap) this.l).clear();     // Catch: Throwable -> L15
        ((ConcurrentHashMap) this.m).clear();     // Catch: Throwable -> L15
        ((ConcurrentHashMap) this.n).clear();     // Catch: Throwable -> L15
        ((ConcurrentHashMap) this.o).clear();     // Catch: Throwable -> L15
        awa.d r1 = this.p;     // Catch: Throwable -> L15
        if (r1 == null) goto L7;
        String r2 = r1.a();     // Catch: Throwable -> L15
    L8:
        JSONObject r3 = new JSONObject(r2);     // Catch: Throwable -> L15
        JSONArray r4 = r3.optJSONArray("docs_mg_api");     // Catch: Throwable -> L15
        JSONArray r5 = r3.optJSONArray("docs_mg_frontier");     // Catch: Throwable -> L15
        JSONArray r6 = r3.optJSONArray("docs_mg_api_v2");     // Catch: Throwable -> L15
        JSONArray r7 = r3.optJSONArray("docs_mg_frontier_v2");     // Catch: Throwable -> L15
        String r8 = r3.optJSONArray("docs_mg_geo_regex").optString(0, "");     // Catch: Throwable -> L15
        String r9 = r3.optJSONArray("docs_mg_brand_regex").optString(0, "");     // Catch: Throwable -> L15
        f(this.l, r4);     // Catch: Throwable -> L15
        f(this.m, r5);     // Catch: Throwable -> L15
        g(this.n, r6);     // Catch: Throwable -> L15
        g(this.o, r7);     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r8) == true) goto L12;
        this.q = PatternProtector.compile(r8);     // Catch: Throwable -> L15
    L12:
        if (TextUtils.isEmpty(r9) == true) goto L20;
        this.r = PatternProtector.compile(r9);     // Catch: Throwable -> L15
        return;
    L20:
        return;
    L7:
        r2 = (String) com.bytedance.ee.bear.appsetting.c.a.a.d("biz_domain_config", "");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        tt5.a.l("SpaceKitUrlHelper", "Failed to initMgApiDomain", th);
    }

    @Override // t45.c
    public final String f9() {
        String r0 = this.a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return t;
    }

    @Override // t45.c
    public final String getMainDomain() {
        f r0 = this.e;
        if (TextUtils.isEmpty(r0.C) == false) goto L19;
        c r1 = r0.D;
        if (r1 == null) goto L7;
        String r2 = r1.getString("domain_characteristic_config", "");
    L9:
        if (TextUtils.isEmpty(r2) == false) goto L20;
        tt5.a.h("DomainConfigParser", "parseMainDomain()...domainCharacteristicStr is empty");
        goto L19
    L20:
        JSONObject r3 = new JSONObject(r2).optJSONObject("common");     // Catch: JSONException -> L15
        if (r3 == null) goto L17;
        r0.C = r3.optString("mainDomain");     // Catch: JSONException -> L15
    L17:
        tt5.a.h("DomainConfigParser", "parseMainDomain()...mainDomain = " + r0.C);
    L15:
        e = move-exception;
        tt5.a.d("DomainConfigParser", "parseMainDomain()...error = " + e);
        goto L17
    L7:
        Intrinsics.checkNotNullParameter("privatizationConfig", "name");
        com.ss.android.lark.storage.kv.repo.a r4 = ay4.b.b("privatizationConfig", true, ay4.b.a("privatizationConfig"));
        Intrinsics.checkNotNullParameter(r4, "repo");
        new ArrayList();
        Intrinsics.checkNotNullParameter("domain_characteristic_config", "key");
        r2 = r4.getString("domain_characteristic_config", "");
    L19:
        return r0.C;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [s45.m] */
    public final void i() {
        final ?? r0 = new m(this);
        Disposable r1 = Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).subscribe(new n(this, r0), new o());
        this.k.add(r1);
    }

    public final void j() {
        int r1 = 0;
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.disable_space_api_whitelist_addition") == false) goto L5;
        tt5.a.h("SpaceKitUrlHelper", "updateWhiteList()...ccm.mobile.disable_space_api_whitelist_addition is true");
    L8:
        r r0 = this.f;
        f r2 = this.e;
        String[] r3 = r2.n;
        String[] r4 = r2.l;
        r0.getClass();
        int r5 = r3.length;
        int r6 = 0;
    L9:
        if (r6 >= r5) goto L14;
        String r7 = r3[r6];
        int r8 = r4.length;
        int r9 = 0;
    L11:
        if (r9 >= r8) goto L13;
        r0.a(r7, r4[r9]);
        r9 = r9 + 1;
        goto L11
    L13:
        r6 = r6 + 1;
        goto L9
    L14:
        r r10 = this.f;
        String[] r11 = sbb.f.e;
        r10.getClass();
        int r12 = r11.length;
    L15:
        if (r1 >= r12) goto L17;
        r10.a("ccm.bytedance.net", r11[r1]);
        r1 = r1 + 1;
        goto L15
    L17:
        return;
    L5:
        tt5.a.h("SpaceKitUrlHelper", "updateWhiteList()...ccm.mobile.disable_space_api_whitelist_addition is false");
        r r13 = this.f;
        f r14 = this.e;
        String[] r16 = r14.o;
        String r17 = r14.f();
        r13.getClass();
        int r18 = r16.length;
        int r19 = 0;
    L6:
        if (r19 >= r18) goto L8;
        r13.a(r16[r19], r17);
        r19 = r19 + 1;
        goto L6
    }

    @Override // t45.c
    public final String u9() {
        return this.e.f();
    }

    public p() {
        this.k = new CompositeDisposable();
        this.l = new ConcurrentHashMap();
        this.m = new ConcurrentHashMap();
        this.n = new ConcurrentHashMap();
        this.o = new ConcurrentHashMap();
        this.q = null;
        this.r = null;
        this.s = new ConcurrentHashMap();
        b();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        iu5.d.a("SpaceKitUrlHelper", e);
    }

    public static t45.c a() {
        t45.c r0 = (t45.c) e0c.k.a(LarkContext.getApplication(), t45.c.class);
        if (r0 != null) goto L5;
        tt5.a.d("SpaceKitUrlHelper", "dwarf ISpaceKitUrlHelper is null");
    L5:
        return r0;
    }

    @Override // t45.c
    public final String getProxy() {
        return this.h;
    }

    @Override // t45.c
    public final String Ca(String r8) {
        String r0 = this.h;
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return r8;
    L5:
        if (v6(r8) == true) goto L7;
        return r8;
    L7:
        if (TextUtils.isEmpty(r0) == true) goto L14;
        Uri r1 = UriProtector.parse(r0);
        String[] r2 = new String[3];
        if (r1 == null) goto L13;
        r2[0] = r1.getScheme();
        r2[1] = r1.getHost();
        if (r1.getPort() == (-1)) goto L13;
        r2[2] = String.valueOf(r1.getPort());
    L13:
        tt5.a.b("SpaceKitUrlHelper", "parseNetInfo: scheme = " + r2[0] + ", host = " + r2[1] + ", port = " + r2[2]);
    L15:
        if (r2 == null) goto L32;
        String r3 = r2[0] + "://" + r2[1];
        String r4 = r2[2];
        StringBuilder r5 = new StringBuilder();
        r5.append(r3);
        if (TextUtils.isEmpty(r4) == false) goto L19;
        String r6 = "";
    L20:
        r5.append(r6);
        String r7 = r5.toString();
        Uri r9 = UriProtector.parse(r8);
        if (r9 == null) goto L33;
        String r10 = r9.getScheme();
        String r11 = r9.getHost();
        if (TextUtils.isEmpty(r10) == false) goto L25;
        return r8;
    L25:
        if (TextUtils.isEmpty(r11) == false) goto L27;
        return r8;
    L27:
        if (r8.contains(r3) == false) goto L29;
        return r8;
    L29:
        return r8.replaceFirst(r10 + "://" + r11, r7);
    L33:
        return r8;
    L19:
        r6 = ":" + r4;
        goto L20
    L32:
        return r8;
    L14:
        r2 = null;
        goto L15
    }

    @Override // t45.c
    public final void F3(String r3) {
        tt5.a.h("SpaceKitUrlHelper", "setApiHost()...apiHost = " + r3);
        if (TextUtils.isEmpty(r3) == false) goto L5;
    L9:
        tt5.a.h("SpaceKitUrlHelper", "setApiHost()...apiHost is null or same");
        return;
    L5:
        if (TextUtils.equals(r3, u) == true) goto L9;
        u = r3;
        this.c = r3;
        d(r3);
    }

    @Override // t45.c
    public final void F6(List<String> r7) {
        tt5.a.h("SpaceKitUrlHelper", "setHistoryDomains()...domains = " + r7);
        if (hu5.a.d(r7) == false) goto L5;
        return;
    L5:
        Iterator<String> r8 = r7.iterator();
    L7:
        if (r8.hasNext() == false) goto L11;
        String r0 = r8.next();
        r r1 = this.f;
        String[] r2 = this.e.l;
        r1.getClass();
        int r3 = r2.length;
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L7;
        r1.a(r0, r2[r4]);
        r4 = r4 + 1;
        goto L9
    }

    @Override // t45.c
    public final Boolean F7(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return null;
    L7:
        return this.s.get(r2);
    }

    @Override // t45.c
    public final void K5(String r1) {
        this.a = r1;
    }

    @Override // t45.c
    public final boolean L5(String r5) {
        this.g.getClass();
        if (TextUtils.isEmpty(r5) == false) goto L11;
        tt5.a.h("BlackList", "isVersionManagerUrl()...url is empty");
        return false;
    L11:
        return !TextUtils.isEmpty(UriProtector.getQueryParameter(UriProtector.parse(r5), "edition_id"));
    L8:
        e = move-exception;
        tt5.a.d("BlackList", "isVersionManagerUrl()...err: " + e.getMessage());
        return false;
    }

    @Override // t45.c
    public final boolean Oa(String r6) {
        if (TextUtils.isEmpty(r6) == false) goto L5;
        return false;
    L5:
        String r7 = UriProtector.parse(r6).getPath();
        if (r7 == null) goto L20;
        int r0 = r7.length();
        int r2 = 0;
    L8:
        if (r2 >= r0) goto L13;
        int r3 = r7.codePointAt(r2);
        if (Character.isWhitespace(r3) == false) goto L11;
        r2 = r2 + Character.charCount(r3);
        goto L8
    L11:
        boolean r1 = false;
    L14:
        if (r1 == true) goto L20;
        return this.e.E.matcher(r7).find();
    L18:
        e = move-exception;
        tt5.a.d("SpaceKitUrlHelper", "isBitableAppModeUrl()...err: " + e.getMessage());
        goto L20
    L13:
        r1 = true;
    L20:
        return false;
    }

    @Override // t45.c
    public final void Sa(boolean r2) {
        this.j = r2;
        tt5.a.h("SpaceKitUrlHelper", "setPrivateKaPKG()...mIsPrivateKaPKG = " + this.j);
    }

    @Override // t45.c
    public final String[] U3(l r2) {
        String[] r3 = this.o.get(r2.a);
        if (r3 != null) goto L5;
    L9:
        tt5.a.h("SpaceKitUrlHelper", "getFrontierHostByGeoV2 no config, use user empty");
        return null;
    L5:
        if (r3.length <= 0) goto L9;
        if (TextUtils.isEmpty(r3[0]) == true) goto L9;
        return r3;
    }

    @Override // t45.c
    public final boolean X(String r5) {
        b r0 = this.g;
        r0.getClass();
        if (TextUtils.isEmpty(r5) == false) goto L6;
        tt5.a.h("BlackList", "isInBlackList()...url is empty");
        return false;
    L6:
        if (r0.a != null) goto L8;
        tt5.a.h("BlackList", "isInBlackList()...mPattern is null");
        return false;
    L8:
        String r6 = UriProtector.parse(r5).getPath();
        if (TextUtils.isEmpty(r6) == false) goto L16;
        tt5.a.h("BlackList", "isInBlackList()...path is empty");
        return false;
    L16:
        return r0.a.matcher(r6).find();
    L13:
        e = move-exception;
        tt5.a.f("BlackList", e, false);
        return false;
    }

    @Override // t45.c
    public final BearUrl Z(String r3) {
        if (v6(r3) == false) goto L5;
        BearUrl r4 = this.i.d(r3);
        tt5.a.h("SpaceKitUrlHelper", "parseUrl()...is suite url");
        return r4;
    L5:
        BearUrl r0 = new BearUrl(r3);
        tt5.a.h("SpaceKitUrlHelper", "parseUrl()...is not suite url");
        return r0;
    }

    @Override // t45.c
    public final void c2(String r3) {
        tt5.a.h("SpaceKitUrlHelper", "setProductHost()...productHost = " + r3);
        if (TextUtils.isEmpty(r3) == false) goto L5;
    L9:
        tt5.a.h("SpaceKitUrlHelper", "setProductHost()...productHost is null or same");
        return;
    L5:
        if (TextUtils.equals(r3, this.b) == true) goto L9;
        t = r3;
        this.b = r3;
        e(r3);
    }

    public final void d(String r3) {
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.disable_space_api_whitelist_addition") == false) goto L6;
        tt5.a.h("SpaceKitUrlHelper", "mergeApiHost()...ccm.mobile.disable_space_api_whitelist_addition is true");
        return;
    L6:
        tt5.a.h("SpaceKitUrlHelper", "mergeApiHost()...ccm.mobile.disable_space_api_whitelist_addition is false");
        if (TextUtils.isEmpty(r3) == false) goto L10;
        tt5.a.h("SpaceKitUrlHelper", "mergeApiHost()...apiHost is null");
        return;
    L10:
        this.f.a(r3, this.e.f());
    }

    public final void e(String r6) {
        tt5.a.h("SpaceKitUrlHelper", "mergeProductHost()...productHost = " + r6);
        if (TextUtils.isEmpty(r6) == false) goto L6;
        tt5.a.h("SpaceKitUrlHelper", "mergeProductHost()...productHost is null");
        return;
    L6:
        r r0 = this.f;
        String[] r1 = this.e.l;
        r0.getClass();
        int r2 = r1.length;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L9;
        r0.a(r6, r1[r3]);
        r3 = r3 + 1;
        goto L7
    }

    public final l h(String r7) {
        l r1 = new l();
        if (TextUtils.isEmpty(r7) == false) goto L18;
        return r1;
    L18:
        String r8 = UriProtector.parse(r7).getHost();     // Catch: Throwable -> L12
        r1.c = r8;     // Catch: Throwable -> L12
        r1.d = r8;     // Catch: Throwable -> L12
        Pattern r2 = this.q;     // Catch: Throwable -> L12
        if (r2 != null) goto L8;
        return r1;
    L8:
        Matcher r3 = r2.matcher(r8);     // Catch: Throwable -> L12
        String r4 = "";
    L10:
        if (r3.find() == false) goto L14;
        String r5 = r3.group();     // Catch: Throwable -> L12
        r1.d = r8.replaceFirst(r5, ".");     // Catch: Throwable -> L12
        r4 = r5.substring(1, r5.length() - 1);     // Catch: Throwable -> L12
        goto L10
    L14:
        tt5.a.h("SpaceKitUrlHelper", "parseUnitFromUrl, host=" + r8 + " geo=" + r4);     // Catch: Throwable -> L12
        r1.a = r4;     // Catch: Throwable -> L12
    L17:
        return r1;
    L12:
        th = move-exception;
        tt5.a.f("SpaceKitUrlHelper", th, false);
        goto L17
    }

    @Override // t45.c
    public final boolean ia(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return false;
    L5:
        Uri r5 = UriProtector.parse(r4);
        if (TextUtils.equals(r5.getHost(), "bitable.feishu.cn") == true) goto L8;
        return false;
    L8:
        String r6 = r5.getPath();
        return PatternProtector.compile("^/app(\\w{24}|\\w{19})$").matcher(r6).find();
    }

    @Override // t45.c
    public final String m4(l r4) {
        String[] r5 = this.n.get(r4.a);
        if (r5 != null) goto L5;
    L10:
        tt5.a.h("SpaceKitUrlHelper", "getApiUrlByGeoV2 no config, use user empty");
        return "";
    L5:
        if (r5.length <= 0) goto L10;
        if (TextUtils.isEmpty(r5[0]) == true) goto L10;
        return "https://" + r5[0] + "/" + u9();
    }

    @Override // t45.c
    public final l m8(String r8) {
        l r1 = new l();
        if (TextUtils.isEmpty(r8) == false) goto L26;
        return r1;
    L26:
        String r9 = UriProtector.parse(r8).getHost().toLowerCase();     // Catch: Throwable -> L15
        r1.c = r9;     // Catch: Throwable -> L15
        r1.d = r9;     // Catch: Throwable -> L15
        Pattern r2 = this.q;     // Catch: Throwable -> L15
        if (r2 != null) goto L8;
    L23:
        return r1;
    L8:
        if (this.r == null) goto L23;
        Matcher r3 = r2.matcher(r9);     // Catch: Throwable -> L15
        String r4 = "";
        String r5 = "";
    L13:
        if (r3.find() == false) goto L17;
        String r6 = r3.group();     // Catch: Throwable -> L15
        r1.d = r9.replace(r6, ".");     // Catch: Throwable -> L15
        r5 = r6.substring(1, r6.length() - 1);     // Catch: Throwable -> L15
        goto L13
    L17:
        Matcher r7 = this.r.matcher(r9);     // Catch: Throwable -> L15
    L19:
        if (r7.find() == false) goto L21;
        String r10 = r7.group();     // Catch: Throwable -> L15
        r4 = r10.substring(1, r10.length() - 1);     // Catch: Throwable -> L15
        goto L19
    L21:
        tt5.a.h("SpaceKitUrlHelper", "parseUnitAndBrandFromUrl, host=" + r9 + " geo=" + r5 + " brand=" + r4);     // Catch: Throwable -> L15
        r1.a = r5;     // Catch: Throwable -> L15
        r1.b = r4;     // Catch: Throwable -> L15
    L25:
        return r1;
    L15:
        th = move-exception;
        tt5.a.f("SpaceKitUrlHelper", th, false);
        goto L25
    }

    @Override // t45.c
    public final String s0(String r7) {
        if (TextUtils.isEmpty(r7) == false) goto L5;
        return "";
    L5:
        String r0 = this.e.f();
        if (r7.startsWith(r0) == false) goto L8;
        return r7;
    L8:
        if (r7.startsWith("/" + r0) == true) goto L32;
        String[] r2 = this.e.k;
        if (r2 != null) goto L13;
    L15:
        String r3 = "";
    L17:
        if (TextUtils.isEmpty(r3) == false) goto L19;
    L24:
        String r1 = r7;
    L26:
        if (r7.startsWith("/") == false) goto L29;
        return "/" + r0 + r1;
    L29:
        return r0 + "/" + r1;
    L19:
        if (r7.startsWith(r3 + "/") == false) goto L22;
        r1 = r7.replace(r3 + "/", "");
        goto L26
    L22:
        if (r7.startsWith("/" + r3 + "/") == false) goto L24;
        r1 = r7.replace("/" + r3 + "/", "/");
        goto L26
    L13:
        if (r2.length <= 1) goto L15;
        r3 = r2[1];
        goto L17
    L32:
        return r7;
    }

    @Override // t45.c
    public final boolean u6(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return false;
    L6:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("apaas.miaoda.migrate_to_ccm") == false) goto L11;
        sbb.c.a.getClass();
        if (sbb.c.b(r4) == false) goto L12;
        return true;
    L12:
        return false;
    L11:
        return false;
    }

    @Override // t45.c
    public final boolean v6(String r12) {
        if (r12 == null) goto L10;
        if (r12.contains("routeFromSync") == false) goto L10;
        if (r12.contains("/sync/") == false) goto L10;
        return false;
    L10:
        if (r12 == null) goto L18;
        if (r12.contains("/sync/") == false) goto L18;
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.docx.synced_block.separate_page_mobile") == true) goto L18;
        tt5.a.h("SpaceKitUrlHelper", "sync block disable");
        return false;
    L18:
        if (u6(r12) == false) goto L21;
        return true;
    L21:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("bitable.record.share.v2.mobile_downgrade") == false) goto L27;
        BearUrl r0 = this.i.d(r12);
        if (TextUtils.isEmpty(r0.l) == true) goto L27;
        if (r0.l.startsWith("/record/") == false) goto L27;
        return false;
    L27:
        r r1 = this.f;
        r1.getClass();
        if (TextUtils.isEmpty(r12) == true) goto L93;
        Uri r4 = UriProtector.parse(r12);
        if (r4.isHierarchical() == false) goto L93;
        if (TextUtils.isEmpty(r4.getHost()) == true) goto L93;
        if (TextUtils.equals(r4.getScheme(), "http") == true) goto L44;
        if (TextUtils.equals(r4.getScheme(), "https") == true) goto L44;
        if (TextUtils.equals(r4.getScheme(), "lark") == true) goto L44;
        tt5.a.h("WhiteList", "illegal schema = " + r4.getScheme());
    L44:
        if (r1.j == false) goto L76;
        String r5 = r4.getHost();
        if (TextUtils.isEmpty(r5) == true) goto L71;
        String r6 = r5.toLowerCase(Locale.US);
        Iterator r7 = ((CopyOnWriteArraySet) r1.d).iterator();
    L50:
        if (r7.hasNext() == false) goto L71;
        String r8 = (String) r7.next();
        if (TextUtils.isEmpty(r6) == false) goto L54;
    L68:
        boolean r9 = false;
    L69:
        if (r9 == false) goto L50;
        boolean r10 = true;
    L72:
        if (r10 == true) goto L76;
        if (TextUtils.isEmpty(r1.i) == true) goto L93;
        boolean r2 = TextUtils.equals(r4.getHost(), UriProtector.parse(r1.i).getHost());
    L94:
        if (r2 == false) goto L98;
        tt5.a.h("SpaceKitUrlHelper", "isSuiteUrl()... in WhiteList");
        return true;
    L98:
        if (this.j == false) goto L104;
        int r3 = sbb.e.g(this.i.d(r12).getType());
        if (Arrays.asList(sbb.e.z).contains(Integer.valueOf(r3)) == false) goto L104;
        tt5.a.h("SpaceKitUrlHelper", "isSuiteUrl()... in path for ka, type = " + r3);
        return true;
    L104:
        if (this.j == false) goto L106;
    L109:
        tt5.a.h("SpaceKitUrlHelper", "isSuiteUrl()...result = false");
        return false;
    L106:
        if (ia(r12) == false) goto L109;
        tt5.a.h("SpaceKitUrlHelper", "isSuiteUrl()...bitable url");
        return true;
    L54:
        if (TextUtils.isEmpty(r8) == true) goto L68;
        if (r6.length() < r8.length()) goto L68;
        if (r6.endsWith(r8) == false) goto L68;
        if (r6.length() != r8.length()) goto L66;
    L67:
        r9 = true;
        goto L69
    L66:
        if (r6.charAt((r6.length() - r8.length()) - 1) != '.') goto L68;
    L71:
        r10 = false;
    L76:
        String r11 = r4.getScheme() + "://" + r4.getHost() + r4.getPath();
    L88:
        e = move-exception;
        tt5.a.f("WhiteList", e, false);
    L91:
        if (TextUtils.isEmpty(r1.i) == true) goto L93;
        r2 = TextUtils.equals(r4.getHost(), UriProtector.parse(r1.i).getHost());
        goto L94
    L78:
        if (r1.h == true) goto L80;
        Iterator r13 = ((CopyOnWriteArrayList) r1.a).iterator();     // Catch: Exception -> L88
    L84:
        if (r13.hasNext() == false) goto L91;
        if (((Pattern) r13.next()).matcher(r11).find() == false) goto L84;
    L87:
        r2 = true;
        goto L94
    L80:
        if (PatternProtector.compile(String.format("%s%s%s", new Object[]{"(\\/|\\.)", r1.e, r1.g})).matcher(r11).find() == false) goto L91;
    L93:
        r2 = false;
        goto L94
    }

    @Override // t45.c
    public final String v8(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L7;
        tt5.a.h("SpaceKitUrlHelper", "correctProductUrl() url is empty");
        return "";
    L7:
        if (a.e(UriProtector.parse(r4).getPath()) == null) goto L9;
        return r4;
    L9:
        String r0 = va(r4);
        BearUrl r5 = this.i.d(r4);
        if (TextUtils.isEmpty(r5.getType()) == false) goto L12;
    L25:
        return r0;
    L12:
        if (TextUtils.isEmpty(r5.b) == true) goto L25;
        if (r5.e.contains("record") == false) goto L17;
        return r0;
    L17:
        if (TextUtils.equals(sbb.e.i.getType(), r5.getType()) == false) goto L22;
        if (Oa(r5.e) == false) goto L22;
        return r0;
    L22:
        if (r5.e.contains("share/base") == true) goto L25;
        return UriProtector.parse(r0).buildUpon().path(a9(r5.getType(), r5.b)).build().toString();
    }

    @Override // t45.c
    public final String va(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L24;
        tt5.a.h("SpaceKitUrlHelper", "url is empty");
        return r8;
    L24:
        l r3 = h(r8);     // Catch: Exception -> L21
        String r4 = r3.d;     // Catch: Exception -> L21
        if (TextUtils.isEmpty(r4) == false) goto L11;
        tt5.a.h("SpaceKitUrlHelper", "urlHost is empty");     // Catch: Exception -> L21
        return r8;
    L11:
        String r5 = this.d.t6(r4);     // Catch: Exception -> L21
        tt5.a.h("SpaceKitUrlHelper", "urlHost : " + r4 + "  value : " + r5);     // Catch: Exception -> L21
        if (TextUtils.isEmpty(r5) == false) goto L14;
    L23:
        return r8;
    L14:
        if (TextUtils.isEmpty(r3.a) == true) goto L16;
        int r0 = r5.indexOf(46);     // Catch: Exception -> L21
        if (r0 == (-1)) goto L23;
        return r8.replaceFirst(r3.c, r5.substring(0, r0 + 1) + r3.a + r5.substring(r0));
    L16:
        return r8.replaceFirst(r4, r5);
    L21:
        e = move-exception;
        tt5.a.f("SpaceKitUrlHelper", e, false);
        goto L23
    }

    public static void f(Map r9, JSONArray r10) {
        if (r10 != null) goto L5;
    L22:
        tt5.a.h("SpaceKitUrlHelper", "initMgApiDomain is empty.");
    L23:
        tt5.a.h("SpaceKitUrlHelper", "initMgApiDomain parseDocsMgHost ret=" + r9);
        return;
    L5:
        if (r10.length() <= 0) goto L22;
        int r2 = 0;
    L8:
        if (r2 >= r10.length()) goto L23;
        String[] r3 = r10.optString(r2, "").split("\\|");
        String r4 = r3[0];
        String r5 = r3[1];
        String r6 = r3[2];
        if (TextUtils.isEmpty(r4) == true) goto L21;
        if (TextUtils.isEmpty(r6) == true) goto L21;
        Map r7 = (Map) r9.get(r4);
        if (r7 != null) goto L16;
        r7 = new ConcurrentHashMap();
        r9.put(r4, r7);
    L16:
        String[] r8 = r6.split(",");
        int r11 = 0;
    L18:
        if (r11 >= r8.length) goto L20;
        r8[r11] = r8[r11].trim();
        r11 = r11 + 1;
        goto L18
    L20:
        tt5.a.h("SpaceKitUrlHelper", "parseDocsMgHost brand=" + r4 + " geo=" + r5 + " hosts=" + Arrays.toString(r8));
        r7.put(r5, r8);
    L21:
        r2 = r2 + 1;
        goto L8
    }

    public static void g(Map r7, JSONArray r8) {
        if (r8 != null) goto L5;
    L17:
        tt5.a.h("SpaceKitUrlHelper", "initMgApiDomainV2 is empty.");
    L18:
        tt5.a.h("SpaceKitUrlHelper", "initMgApiDomainV2 parseDocsMgHost ret=" + r7);
        return;
    L5:
        if (r8.length() <= 0) goto L17;
        int r2 = 0;
    L8:
        if (r2 >= r8.length()) goto L18;
        String[] r3 = r8.optString(r2, "").split("\\|");
        String r4 = r3[0];
        String r5 = r3[1];
        if (TextUtils.isEmpty(r5) == true) goto L16;
        String[] r6 = r5.split(",");
        int r9 = 0;
    L13:
        if (r9 >= r6.length) goto L15;
        r6[r9] = r6[r9].trim();
        r9 = r9 + 1;
        goto L13
    L15:
        tt5.a.h("SpaceKitUrlHelper", "parseDocsMgHostV2 geo=" + r4 + " hosts=" + Arrays.toString(r6));
        r7.put(r4, r6);
    L16:
        r2 = r2 + 1;
        goto L8
    }

    @Override // t45.c
    public final String A9(String r2, String r3) {
        return Le(r2, r3, null);
    }

    @Override // t45.c
    public final boolean H3(String r5, String r6) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
    L19:
        tt5.a.h("SpaceKitUrlHelper", "isSameVersionUrl()...false for empty");
        return false;
    L5:
        if (TextUtils.isEmpty(r6) == true) goto L19;
        if (L5(r5) == true) goto L10;
    L17:
        tt5.a.h("SpaceKitUrlHelper", "isSameVersionUrl()...false for some one not version url");
        return false;
    L10:
        if (L5(r6) == false) goto L17;
        return TextUtils.equals(UriProtector.getQueryParameter(UriProtector.parse(r5), "edition_id"), UriProtector.getQueryParameter(UriProtector.parse(r6), "edition_id"));
    L14:
        e = move-exception;
        tt5.a.d("SpaceKitUrlHelper", "isSameVersionUrl()...err: " + e.getMessage());
        return false;
    }

    @Override // t45.c
    public final boolean Ha(String r5, String r6) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
    L20:
        tt5.a.h("SpaceKitUrlHelper", "isSameProductUrl()...false for empty");
        return false;
    L5:
        if (TextUtils.isEmpty(r6) == true) goto L20;
        if (v6(r5) == true) goto L10;
    L18:
        tt5.a.h("SpaceKitUrlHelper", "isSameProductUrl()...false for not suite url");
        return false;
    L10:
        if (v6(r6) == false) goto L18;
        BearUrl r7 = Z(r5);
        BearUrl r8 = Z(r6);
        tt5.a.h("SpaceKitUrlHelper", "isSameProductUrl()...first type = " + r7.a + ", second type = " + r8.a);
        if (TextUtils.equals(r7.a, r8.a) == true) goto L15;
        return false;
    L15:
        if (TextUtils.equals(r7.b, r8.b) == false) goto L23;
        return true;
    L23:
        return false;
    }

    @Override // t45.c
    public final void I9(String[] r9, String[] r10) {
        r r0 = this.f;
        r0.getClass();
        int r1 = r9.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L8;
        String r4 = r9[r3];
        int r5 = r10.length;
        int r6 = 0;
    L5:
        if (r6 >= r5) goto L7;
        r0.a(r4, r10[r6]);
        r6 = r6 + 1;
        goto L5
    L7:
        r3 = r3 + 1;
        goto L3
    }

    @Override // t45.c
    public final String a9(String r6, String r7) {
        if (TextUtils.isEmpty(r6) == false) goto L7;
        tt5.a.h("SpaceKitUrlHelper", "genProductPath()...type is null");
        return null;
    L7:
        if (TextUtils.isEmpty(r7) == false) goto L10;
        tt5.a.h("SpaceKitUrlHelper", "genProductPath()...token is null");
        return null;
    L10:
        HashMap r0 = (HashMap) this.e.r;
        String r3 = (String) r0.get(r6);
        if (TextUtils.isEmpty(r3) == false) goto L13;
        r3 = (String) r0.get(BottomPopupData.Default);
    L13:
        if (r3 != null) goto L16;
        tt5.a.d("SpaceKitUrlHelper", "template is null, type = " + r6);
        return null;
    L16:
        String r1 = sbb.e.b(r6);
        if (TextUtils.equals(r6, sbb.e.i.getType()) == false) goto L24;
        Boolean r8 = this.s.get(r7);
        if (r8 == null) goto L24;
        if (r8.booleanValue() == false) goto L24;
        r1 = this.e.F;
    L24:
        return r3.replace("${type}", r1).replace("${token}", r7);
    }

    @Override // t45.c
    public final String j8(String r4, String r5) {
        if (TextUtils.isEmpty(r4) == false) goto L7;
        tt5.a.h("SpaceKitUrlHelper", "genPhoenixPath()...type is null");
        return null;
    L7:
        if (TextUtils.isEmpty(r5) == false) goto L11;
        tt5.a.h("SpaceKitUrlHelper", "genPhoenixPath()...token is null");
        return null;
    L11:
        if (TextUtils.isEmpty(this.e.v) == false) goto L15;
        tt5.a.h("SpaceKitUrlHelper", "genPhoenixPath()...phoenixPath is null");
        return null;
    L15:
        return this.e.v.replace("${type}", sbb.e.b(r4)).replace("${token}", r5);
    }

    @Override // t45.c
    public final boolean na(String r2, String r3) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.equals(Z(r2).a, r3) == false) goto L7;
        return true;
    }

    @Override // t45.c
    public final void rd(String r2, boolean r3) {
        this.s.put(r2, Boolean.valueOf(r3));
    }

    @Inject
    public p(c r5, awa.d r6, f r7) {
        this.k = new CompositeDisposable();
        this.l = new ConcurrentHashMap();
        this.m = new ConcurrentHashMap();
        this.n = new ConcurrentHashMap();
        this.o = new ConcurrentHashMap();
        this.q = null;
        this.r = null;
        this.s = new ConcurrentHashMap();
        tt5.a.h("SpaceKitUrlHelper", "getInstance dwarf SpaceKitUrlHelper instance=" + this);
        this.d = r5;
        this.e = r7;
        this.i = new q(r7);
        this.p = r6;
        String r8 = (String) new ml5.b("debug_config").a("ip_proxy", "");
        this.h = r8;
        this.f = new r(r8);
        this.g = new b(this.e.m);
        if (TextUtils.isEmpty(this.h) == true) goto L7;
        String r9 = this.h;
        r r10 = this.f;
        String[] r11 = this.e.l;
        r10.getClass();
        int r0 = r11.length;
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L7;
        r10.a(r9, r11[r2]);
        r2 = r2 + 1;
    L7:
        j();
        e(this.b);
        d(this.c);
        tt5.a.h("SpaceKitUrlHelper", "init()...mWhiteList " + this.f.b.toString());
        c();
        i();
    }

    @Override // t45.c
    public final String Le(String r3, String r4, Map<String, String> r5) {
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.ark_domain") == false) goto L5;
        String r0 = f9();
    L7:
        return Te(r0, r3, r4, r5);
    L5:
        r0 = t;
        goto L7
    }

    @Override // t45.c
    public final void O7(String r2, String r3, String r4) {
        this.a = r3;
        c2(r2);
        F3(r4);
        c();
        tt5.a.h("SpaceKitUrlHelper", "onConfigChanged()...api domain = " + r2 + ", product domain = " + r4);
    }

    @Override // t45.c
    public String ua(String r3, String r4, String r5) {
        String r6 = a9(r3, r4);
        if (r6 != null) goto L5;
    L7:
        Uri.Builder r7 = new Uri.Builder().scheme("https");
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.ark_domain") == false) goto L10;
        String r0 = f9();
    L11:
        Uri.Builder r8 = r7.authority(r0).appendEncodedPath(r6);
        if (TextUtils.isEmpty(r5) == true) goto L15;
        r8.appendQueryParameter(DocRedirectToDocxPlugin.FROM, r5);
    L15:
        return r8.build().toString();
    L10:
        r0 = t;
        goto L11
    L5:
        if (r6.startsWith("/") == false) goto L7;
        r6 = r6.substring(1);
        goto L7
    }

    @Override // t45.c
    public final String Fd(String r3, String r4, String r5, Map<String, String> r6) {
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.ark_domain") == false) goto L5;
        String r0 = f9();
    L7:
        if (TextUtils.isEmpty(r3) == true) goto L14;
        if (v6(r3) == false) goto L14;
        Uri r7 = UriProtector.parse(r3);
        if (TextUtils.isEmpty(r7.getHost()) == true) goto L14;
        r0 = r7.getHost();
    L14:
        return Te(r0, r4, r5, r6);
    L5:
        r0 = t;
        goto L7
    }

    @Override // t45.c
    public String J8(String r3, String r4, String r5, String r6) {
        String r7 = a9(r3, r4);
        if (r7 != null) goto L5;
    L7:
        Uri.Builder r8 = new Uri.Builder().scheme("https");
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.ark_domain") == false) goto L10;
        String r0 = f9();
    L11:
        Uri.Builder r9 = r8.authority(r0).appendEncodedPath(r7);
        if (TextUtils.isEmpty(r5) == true) goto L15;
        r9.appendQueryParameter(DocRedirectToDocxPlugin.FROM, r5);
    L15:
        if (TextUtils.isEmpty(r6) == true) goto L18;
        r9.appendQueryParameter("ccm_open_type", r6);
    L18:
        return r9.build().toString();
    L10:
        r0 = t;
        goto L11
    L5:
        if (r7.startsWith("/") == false) goto L7;
        r7 = r7.substring(1);
        goto L7
    }

    @Override // t45.c
    public String Te(String r2, String r3, String r4, Map<String, String> r5) {
        String r6 = a9(r3, r4);
        if (r6 != null) goto L5;
    L7:
        Uri.Builder r7 = new Uri.Builder().scheme("https").authority(r2).appendEncodedPath(r6);
        if (hu5.a.e(r5) == true) goto L14;
        Iterator<Map.Entry<String, String>> r8 = r5.entrySet().iterator();
    L11:
        if (r8.hasNext() == false) goto L14;
        Map.Entry<String, String> r9 = r8.next();
        r7.appendQueryParameter(r9.getKey(), r9.getValue());
    L14:
        return r7.build().toString();
    L5:
        if (r6.startsWith("/") == false) goto L7;
        r6 = r6.substring(1);
        goto L7
    }
}
