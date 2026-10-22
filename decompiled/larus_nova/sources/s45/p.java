package s45;

import android.net.Uri;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
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

/* JADX INFO: loaded from: classes16.dex */
@UserScope
public class p implements t45.c {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static String f540583t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static String f540584u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f540585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f540586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f540587c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f540588d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f f540589e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public r f540590f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f540591g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f540592h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public q f540593i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f540594j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CompositeDisposable f540595k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<String, Map<String, String[]>> f540596l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<String, Map<String, String[]>> f540597m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map<String, String[]> f540598n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Map<String, String[]> f540599o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final awa.d f540600p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Pattern f540601q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Pattern f540602r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Map<String, Boolean> f540603s;

    @Override // t45.c
    public String T6(String r100, Integer r101) {
        return r100;
    }

    @Override // t45.c
    public final String Mc() {
        return this.f540589e.f540562u;
    }

    @Override // t45.c
    public final void S8() {
        final f r100 = this.f540589e;
        r100.getClass();
        r100.B = System.currentTimeMillis();
        com.bytedance.ee.util.ui.m.a(new d(r100));
    }

    @Override // t45.c
    public final String T0() {
        return this.f540589e.f540557p;
    }

    @Override // t45.c
    public final String U0() {
        return this.f540589e.f540561t;
    }

    @Override // t45.c
    public final String X1() {
        return this.f540589e.f540558q;
    }

    public final void b() {
        tt5.a.h("SpaceKitUrlHelper", "getInstance singleInstance SpaceKitUrlHelper");
        f r100 = new f();
        this.f540589e = r100;
        this.f540593i = new q(r100);
        String r101 = (String) new ml5.b("debug_config").a("ip_proxy", "");
        this.f540592h = r101;
        this.f540590f = new r(r101);
        this.f540591g = new b(this.f540589e.f540554m);
        if (TextUtils.isEmpty(this.f540592h) == true) goto L7;
        String r102 = this.f540592h;
        r r103 = this.f540590f;
        String[] r104 = this.f540589e.f540553l;
        r103.getClass();
        int r105 = r104.length;
        int r106 = 0;
    L5:
        if (r106 >= r105) goto L7;
        r103.a(r102, r104[r106]);
        r106 = r106 + 1;
    L7:
        j();
        e(f540583t);
        d(f540584u);
        tt5.a.h("SpaceKitUrlHelper", "init()...mWhiteList " + this.f540590f.f540606b.toString());
        StringBuilder r107 = new StringBuilder("init()...urlRegex ");
        r r108 = this.f540590f;
        r108.getClass();
        r107.append(String.format("%s%s%s", new Object[]{"(\\/|\\.)", r108.f540609e, r108.f540611g}));
        tt5.a.h("SpaceKitUrlHelper", r107.toString());
        c();
        i();
    }

    public final void c() {
        tt5.a.h("SpaceKitUrlHelper", "initMgApiDomain start");
        ((ConcurrentHashMap) this.f540596l).clear();     // Catch: Throwable -> L15
        ((ConcurrentHashMap) this.f540597m).clear();     // Catch: Throwable -> L15
        ((ConcurrentHashMap) this.f540598n).clear();     // Catch: Throwable -> L15
        ((ConcurrentHashMap) this.f540599o).clear();     // Catch: Throwable -> L15
        awa.d r100 = this.f540600p;     // Catch: Throwable -> L15
        if (r100 == null) goto L7;
        String r101 = r100.a();     // Catch: Throwable -> L15
    L8:
        JSONObject r102 = new JSONObject(r101);     // Catch: Throwable -> L15
        JSONArray r103 = r102.optJSONArray("docs_mg_api");     // Catch: Throwable -> L15
        JSONArray r104 = r102.optJSONArray("docs_mg_frontier");     // Catch: Throwable -> L15
        JSONArray r105 = r102.optJSONArray("docs_mg_api_v2");     // Catch: Throwable -> L15
        JSONArray r106 = r102.optJSONArray("docs_mg_frontier_v2");     // Catch: Throwable -> L15
        String r107 = r102.optJSONArray("docs_mg_geo_regex").optString(0, "");     // Catch: Throwable -> L15
        String r108 = r102.optJSONArray("docs_mg_brand_regex").optString(0, "");     // Catch: Throwable -> L15
        f(this.f540596l, r103);     // Catch: Throwable -> L15
        f(this.f540597m, r104);     // Catch: Throwable -> L15
        g(this.f540598n, r105);     // Catch: Throwable -> L15
        g(this.f540599o, r106);     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r107) == true) goto L12;
        this.f540601q = PatternProtector.compile(r107);     // Catch: Throwable -> L15
    L12:
        if (TextUtils.isEmpty(r108) == true) goto L20;
        this.f540602r = PatternProtector.compile(r108);     // Catch: Throwable -> L15
        return;
    L20:
        return;
    L7:
        r101 = (String) com.bytedance.ee.bear.appsetting.c.a.f206237a.d("biz_domain_config", "");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        tt5.a.l("SpaceKitUrlHelper", "Failed to initMgApiDomain", th);
    }

    @Override // t45.c
    public final String f9() {
        String r100 = this.f540585a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return f540583t;
    }

    @Override // t45.c
    public final String getMainDomain() {
        f r100 = this.f540589e;
        if (TextUtils.isEmpty(r100.C) == false) goto L19;
        c r101 = r100.D;
        if (r101 == null) goto L7;
        String r102 = r101.getString("domain_characteristic_config", "");
    L9:
        if (TextUtils.isEmpty(r102) == false) goto L20;
        tt5.a.h("DomainConfigParser", "parseMainDomain()...domainCharacteristicStr is empty");
        goto L19
    L20:
        JSONObject r103 = new JSONObject(r102).optJSONObject("common");     // Catch: JSONException -> L15
        if (r103 == null) goto L17;
        r100.C = r103.optString("mainDomain");     // Catch: JSONException -> L15
    L17:
        tt5.a.h("DomainConfigParser", "parseMainDomain()...mainDomain = " + r100.C);
    L15:
        e = move-exception;
        tt5.a.d("DomainConfigParser", "parseMainDomain()...error = " + e);
        goto L17
    L7:
        Intrinsics.checkNotNullParameter("privatizationConfig", "name");
        com.ss.android.lark.storage.kv.repo.a r104 = ay4.b.b("privatizationConfig", true, ay4.b.a("privatizationConfig"));
        Intrinsics.checkNotNullParameter(r104, "repo");
        new ArrayList();
        Intrinsics.checkNotNullParameter("domain_characteristic_config", "key");
        r102 = r104.getString("domain_characteristic_config", "");
    L19:
        return r100.C;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [s45.m] */
    public final void i() {
        final ?? r100 = new m(this);
        Disposable r101 = Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).subscribe(new n(this, r100), new o());
        this.f540595k.add(r101);
    }

    public final void j() {
        int r100 = 0;
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.disable_space_api_whitelist_addition") == false) goto L5;
        tt5.a.h("SpaceKitUrlHelper", "updateWhiteList()...ccm.mobile.disable_space_api_whitelist_addition is true");
    L8:
        r r101 = this.f540590f;
        f r102 = this.f540589e;
        String[] r103 = r102.f540555n;
        String[] r104 = r102.f540553l;
        r101.getClass();
        int r105 = r103.length;
        int r106 = 0;
    L9:
        if (r106 >= r105) goto L14;
        String r107 = r103[r106];
        int r108 = r104.length;
        int r109 = 0;
    L11:
        if (r109 >= r108) goto L13;
        r101.a(r107, r104[r109]);
        r109 = r109 + 1;
        goto L11
    L13:
        r106 = r106 + 1;
        goto L9
    L14:
        r r110 = this.f540590f;
        String[] r111 = sbb.f.f541323e;
        r110.getClass();
        int r112 = r111.length;
    L15:
        if (r100 >= r112) goto L17;
        r110.a("ccm.bytedance.net", r111[r100]);
        r100 = r100 + 1;
        goto L15
    L17:
        return;
    L5:
        tt5.a.h("SpaceKitUrlHelper", "updateWhiteList()...ccm.mobile.disable_space_api_whitelist_addition is false");
        r r113 = this.f540590f;
        f r114 = this.f540589e;
        String[] r115 = r114.f540556o;
        String r116 = r114.f();
        r113.getClass();
        int r117 = r115.length;
        int r118 = 0;
    L6:
        if (r118 >= r117) goto L8;
        r113.a(r115[r118], r116);
        r118 = r118 + 1;
        goto L6
    }

    @Override // t45.c
    public final String u9() {
        return this.f540589e.f();
    }

    public p() {
        this.f540595k = new CompositeDisposable();
        this.f540596l = new ConcurrentHashMap();
        this.f540597m = new ConcurrentHashMap();
        this.f540598n = new ConcurrentHashMap();
        this.f540599o = new ConcurrentHashMap();
        this.f540601q = null;
        this.f540602r = null;
        this.f540603s = new ConcurrentHashMap();
        b();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        iu5.d.a("SpaceKitUrlHelper", e);
    }

    public static t45.c a() {
        t45.c r100 = (t45.c) e0c.k.a(LarkContext.getApplication(), t45.c.class);
        if (r100 != null) goto L5;
        tt5.a.d("SpaceKitUrlHelper", "dwarf ISpaceKitUrlHelper is null");
    L5:
        return r100;
    }

    @Override // t45.c
    public final String getProxy() {
        return this.f540592h;
    }

    @Override // t45.c
    public final String Ca(String r100) {
        String r101 = this.f540592h;
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return r100;
    L5:
        if (v6(r100) == true) goto L7;
        return r100;
    L7:
        if (TextUtils.isEmpty(r101) == true) goto L14;
        Uri r102 = UriProtector.parse(r101);
        String[] r103 = new String[3];
        if (r102 == null) goto L13;
        r103[0] = r102.getScheme();
        r103[1] = r102.getHost();
        if (r102.getPort() == (-1)) goto L13;
        r103[2] = String.valueOf(r102.getPort());
    L13:
        tt5.a.b("SpaceKitUrlHelper", "parseNetInfo: scheme = " + r103[0] + ", host = " + r103[1] + ", port = " + r103[2]);
    L15:
        if (r103 == null) goto L32;
        String r104 = r103[0] + "://" + r103[1];
        String r105 = r103[2];
        StringBuilder r106 = new StringBuilder();
        r106.append(r104);
        if (TextUtils.isEmpty(r105) == false) goto L19;
        String r107 = "";
    L20:
        r106.append(r107);
        String r108 = r106.toString();
        Uri r109 = UriProtector.parse(r100);
        if (r109 == null) goto L33;
        String r110 = r109.getScheme();
        String r111 = r109.getHost();
        if (TextUtils.isEmpty(r110) == false) goto L25;
        return r100;
    L25:
        if (TextUtils.isEmpty(r111) == false) goto L27;
        return r100;
    L27:
        if (r100.contains(r104) == false) goto L29;
        return r100;
    L29:
        return r100.replaceFirst(r110 + "://" + r111, r108);
    L33:
        return r100;
    L19:
        r107 = ":" + r105;
        goto L20
    L32:
        return r100;
    L14:
        r103 = null;
        goto L15
    }

    @Override // t45.c
    public final void F3(String r100) {
        tt5.a.h("SpaceKitUrlHelper", "setApiHost()...apiHost = " + r100);
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L9:
        tt5.a.h("SpaceKitUrlHelper", "setApiHost()...apiHost is null or same");
        return;
    L5:
        if (TextUtils.equals(r100, f540584u) == true) goto L9;
        f540584u = r100;
        this.f540587c = r100;
        d(r100);
    }

    @Override // t45.c
    public final void F6(List<String> r100) {
        tt5.a.h("SpaceKitUrlHelper", "setHistoryDomains()...domains = " + r100);
        if (hu5.a.d(r100) == false) goto L5;
        return;
    L5:
        Iterator<String> r101 = r100.iterator();
    L7:
        if (r101.hasNext() == false) goto L11;
        String r102 = r101.next();
        r r103 = this.f540590f;
        String[] r104 = this.f540589e.f540553l;
        r103.getClass();
        int r105 = r104.length;
        int r106 = 0;
    L9:
        if (r106 >= r105) goto L7;
        r103.a(r102, r104[r106]);
        r106 = r106 + 1;
        goto L9
    }

    @Override // t45.c
    public final Boolean F7(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return null;
    L7:
        return this.f540603s.get(r100);
    }

    @Override // t45.c
    public final void K5(String r100) {
        this.f540585a = r100;
    }

    @Override // t45.c
    public final boolean L5(String r100) {
        this.f540591g.getClass();
        if (TextUtils.isEmpty(r100) == false) goto L11;
        tt5.a.h("BlackList", "isVersionManagerUrl()...url is empty");
        return false;
    L11:
        return !TextUtils.isEmpty(UriProtector.getQueryParameter(UriProtector.parse(r100), "edition_id"));
    L8:
        e = move-exception;
        tt5.a.d("BlackList", "isVersionManagerUrl()...err: " + e.getMessage());
        return false;
    }

    @Override // t45.c
    public final boolean Oa(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        String r101 = UriProtector.parse(r100).getPath();
        if (r101 == null) goto L20;
        int r102 = r101.length();
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L13;
        int r104 = r101.codePointAt(r103);
        if (Character.isWhitespace(r104) == false) goto L11;
        r103 = r103 + Character.charCount(r104);
        goto L8
    L11:
        boolean r105 = false;
    L14:
        if (r105 == true) goto L20;
        return this.f540589e.E.matcher(r101).find();
    L18:
        e = move-exception;
        tt5.a.d("SpaceKitUrlHelper", "isBitableAppModeUrl()...err: " + e.getMessage());
        goto L20
    L13:
        r105 = true;
    L20:
        return false;
    }

    @Override // t45.c
    public final void Sa(boolean r100) {
        this.f540594j = r100;
        tt5.a.h("SpaceKitUrlHelper", "setPrivateKaPKG()...mIsPrivateKaPKG = " + this.f540594j);
    }

    @Override // t45.c
    public final String[] U3(l r100) {
        String[] r101 = this.f540599o.get(r100.f540576a);
        if (r101 != null) goto L5;
    L9:
        tt5.a.h("SpaceKitUrlHelper", "getFrontierHostByGeoV2 no config, use user empty");
        return null;
    L5:
        if (r101.length <= 0) goto L9;
        if (TextUtils.isEmpty(r101[0]) == true) goto L9;
        return r101;
    }

    @Override // t45.c
    public final boolean X(String r100) {
        b r101 = this.f540591g;
        r101.getClass();
        if (TextUtils.isEmpty(r100) == false) goto L6;
        tt5.a.h("BlackList", "isInBlackList()...url is empty");
        return false;
    L6:
        if (r101.f540548a != null) goto L8;
        tt5.a.h("BlackList", "isInBlackList()...mPattern is null");
        return false;
    L8:
        String r102 = UriProtector.parse(r100).getPath();
        if (TextUtils.isEmpty(r102) == false) goto L16;
        tt5.a.h("BlackList", "isInBlackList()...path is empty");
        return false;
    L16:
        return r101.f540548a.matcher(r102).find();
    L13:
        e = move-exception;
        tt5.a.f("BlackList", e, false);
        return false;
    }

    @Override // t45.c
    public final BearUrl Z(String r100) {
        if (v6(r100) == false) goto L5;
        BearUrl r101 = this.f540593i.d(r100);
        tt5.a.h("SpaceKitUrlHelper", "parseUrl()...is suite url");
        return r101;
    L5:
        BearUrl r102 = new BearUrl(r100);
        tt5.a.h("SpaceKitUrlHelper", "parseUrl()...is not suite url");
        return r102;
    }

    @Override // t45.c
    public final void c2(String r100) {
        tt5.a.h("SpaceKitUrlHelper", "setProductHost()...productHost = " + r100);
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L9:
        tt5.a.h("SpaceKitUrlHelper", "setProductHost()...productHost is null or same");
        return;
    L5:
        if (TextUtils.equals(r100, this.f540586b) == true) goto L9;
        f540583t = r100;
        this.f540586b = r100;
        e(r100);
    }

    public final void d(String r100) {
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.disable_space_api_whitelist_addition") == false) goto L6;
        tt5.a.h("SpaceKitUrlHelper", "mergeApiHost()...ccm.mobile.disable_space_api_whitelist_addition is true");
        return;
    L6:
        tt5.a.h("SpaceKitUrlHelper", "mergeApiHost()...ccm.mobile.disable_space_api_whitelist_addition is false");
        if (TextUtils.isEmpty(r100) == false) goto L10;
        tt5.a.h("SpaceKitUrlHelper", "mergeApiHost()...apiHost is null");
        return;
    L10:
        this.f540590f.a(r100, this.f540589e.f());
    }

    public final void e(String r100) {
        tt5.a.h("SpaceKitUrlHelper", "mergeProductHost()...productHost = " + r100);
        if (TextUtils.isEmpty(r100) == false) goto L6;
        tt5.a.h("SpaceKitUrlHelper", "mergeProductHost()...productHost is null");
        return;
    L6:
        r r101 = this.f540590f;
        String[] r102 = this.f540589e.f540553l;
        r101.getClass();
        int r103 = r102.length;
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L9;
        r101.a(r100, r102[r104]);
        r104 = r104 + 1;
        goto L7
    }

    public final l h(String r100) {
        l r101 = new l();
        if (TextUtils.isEmpty(r100) == false) goto L18;
        return r101;
    L18:
        String r102 = UriProtector.parse(r100).getHost();     // Catch: Throwable -> L12
        r101.f540578c = r102;     // Catch: Throwable -> L12
        r101.f540579d = r102;     // Catch: Throwable -> L12
        Pattern r103 = this.f540601q;     // Catch: Throwable -> L12
        if (r103 != null) goto L8;
        return r101;
    L8:
        Matcher r104 = r103.matcher(r102);     // Catch: Throwable -> L12
        String r105 = "";
    L10:
        if (r104.find() == false) goto L14;
        String r106 = r104.group();     // Catch: Throwable -> L12
        r101.f540579d = r102.replaceFirst(r106, ".");     // Catch: Throwable -> L12
        r105 = r106.substring(1, r106.length() - 1);     // Catch: Throwable -> L12
        goto L10
    L14:
        tt5.a.h("SpaceKitUrlHelper", "parseUnitFromUrl, host=" + r102 + " geo=" + r105);     // Catch: Throwable -> L12
        r101.f540576a = r105;     // Catch: Throwable -> L12
    L17:
        return r101;
    L12:
        th = move-exception;
        tt5.a.f("SpaceKitUrlHelper", th, false);
        goto L17
    }

    @Override // t45.c
    public final boolean ia(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        Uri r101 = UriProtector.parse(r100);
        if (TextUtils.equals(r101.getHost(), "bitable.feishu.cn") == true) goto L8;
        return false;
    L8:
        String r102 = r101.getPath();
        return PatternProtector.compile("^/app(\\w{24}|\\w{19})$").matcher(r102).find();
    }

    @Override // t45.c
    public final String m4(l r100) {
        String[] r101 = this.f540598n.get(r100.f540576a);
        if (r101 != null) goto L5;
    L10:
        tt5.a.h("SpaceKitUrlHelper", "getApiUrlByGeoV2 no config, use user empty");
        return "";
    L5:
        if (r101.length <= 0) goto L10;
        if (TextUtils.isEmpty(r101[0]) == true) goto L10;
        return "https://" + r101[0] + HTTP.URL_DEFAULT + u9();
    }

    @Override // t45.c
    public final l m8(String r100) {
        l r101 = new l();
        if (TextUtils.isEmpty(r100) == false) goto L26;
        return r101;
    L26:
        String r102 = UriProtector.parse(r100).getHost().toLowerCase();     // Catch: Throwable -> L15
        r101.f540578c = r102;     // Catch: Throwable -> L15
        r101.f540579d = r102;     // Catch: Throwable -> L15
        Pattern r103 = this.f540601q;     // Catch: Throwable -> L15
        if (r103 != null) goto L8;
    L23:
        return r101;
    L8:
        if (this.f540602r == null) goto L23;
        Matcher r104 = r103.matcher(r102);     // Catch: Throwable -> L15
        String r105 = "";
        String r106 = "";
    L13:
        if (r104.find() == false) goto L17;
        String r107 = r104.group();     // Catch: Throwable -> L15
        r101.f540579d = r102.replace(r107, ".");     // Catch: Throwable -> L15
        r106 = r107.substring(1, r107.length() - 1);     // Catch: Throwable -> L15
        goto L13
    L17:
        Matcher r108 = this.f540602r.matcher(r102);     // Catch: Throwable -> L15
    L19:
        if (r108.find() == false) goto L21;
        String r109 = r108.group();     // Catch: Throwable -> L15
        r105 = r109.substring(1, r109.length() - 1);     // Catch: Throwable -> L15
        goto L19
    L21:
        tt5.a.h("SpaceKitUrlHelper", "parseUnitAndBrandFromUrl, host=" + r102 + " geo=" + r106 + " brand=" + r105);     // Catch: Throwable -> L15
        r101.f540576a = r106;     // Catch: Throwable -> L15
        r101.f540577b = r105;     // Catch: Throwable -> L15
    L25:
        return r101;
    L15:
        th = move-exception;
        tt5.a.f("SpaceKitUrlHelper", th, false);
        goto L25
    }

    @Override // t45.c
    public final String s0(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return "";
    L5:
        String r101 = this.f540589e.f();
        if (r100.startsWith(r101) == false) goto L8;
        return r100;
    L8:
        if (r100.startsWith(HTTP.URL_DEFAULT + r101) == true) goto L32;
        String[] r102 = this.f540589e.f540552k;
        if (r102 != null) goto L13;
    L15:
        String r103 = "";
    L17:
        if (TextUtils.isEmpty(r103) == false) goto L19;
    L24:
        String r104 = r100;
    L26:
        if (r100.startsWith(HTTP.URL_DEFAULT) == false) goto L29;
        return HTTP.URL_DEFAULT + r101 + r104;
    L29:
        return r101 + HTTP.URL_DEFAULT + r104;
    L19:
        if (r100.startsWith(r103 + HTTP.URL_DEFAULT) == false) goto L22;
        r104 = r100.replace(r103 + HTTP.URL_DEFAULT, "");
        goto L26
    L22:
        if (r100.startsWith(HTTP.URL_DEFAULT + r103 + HTTP.URL_DEFAULT) == false) goto L24;
        r104 = r100.replace(HTTP.URL_DEFAULT + r103 + HTTP.URL_DEFAULT, HTTP.URL_DEFAULT);
        goto L26
    L13:
        if (r102.length <= 1) goto L15;
        r103 = r102[1];
        goto L17
    L32:
        return r100;
    }

    @Override // t45.c
    public final boolean u6(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("apaas.miaoda.migrate_to_ccm") == false) goto L11;
        sbb.c.f541290a.getClass();
        if (sbb.c.b(r100) == false) goto L12;
        return true;
    L12:
        return false;
    L11:
        return false;
    }

    @Override // t45.c
    public final boolean v6(String r110) {
        if (r110 == null) goto L10;
        if (r110.contains("routeFromSync") == false) goto L10;
        if (r110.contains("/sync/") == false) goto L10;
        return false;
    L10:
        if (r110 == null) goto L18;
        if (r110.contains("/sync/") == false) goto L18;
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.docx.synced_block.separate_page_mobile") == true) goto L18;
        tt5.a.h("SpaceKitUrlHelper", "sync block disable");
        return false;
    L18:
        if (u6(r110) == false) goto L21;
        return true;
    L21:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("bitable.record.share.v2.mobile_downgrade") == false) goto L27;
        BearUrl r100 = this.f540593i.d(r110);
        if (TextUtils.isEmpty(r100.f222571l) == true) goto L27;
        if (r100.f222571l.startsWith("/record/") == false) goto L27;
        return false;
    L27:
        r r101 = this.f540590f;
        r101.getClass();
        if (TextUtils.isEmpty(r110) == true) goto L93;
        Uri r102 = UriProtector.parse(r110);
        if (r102.isHierarchical() == false) goto L93;
        if (TextUtils.isEmpty(r102.getHost()) == true) goto L93;
        if (TextUtils.equals(r102.getScheme(), "http") == true) goto L44;
        if (TextUtils.equals(r102.getScheme(), "https") == true) goto L44;
        if (TextUtils.equals(r102.getScheme(), "lark") == true) goto L44;
        tt5.a.h("WhiteList", "illegal schema = " + r102.getScheme());
    L44:
        if (r101.f540614j == false) goto L76;
        String r103 = r102.getHost();
        if (TextUtils.isEmpty(r103) == true) goto L71;
        String r104 = r103.toLowerCase(Locale.US);
        Iterator r105 = ((CopyOnWriteArraySet) r101.f540608d).iterator();
    L50:
        if (r105.hasNext() == false) goto L71;
        String r106 = (String) r105.next();
        if (TextUtils.isEmpty(r104) == false) goto L54;
    L68:
        boolean r107 = false;
    L69:
        if (r107 == false) goto L50;
        boolean r108 = true;
    L72:
        if (r108 == true) goto L76;
        if (TextUtils.isEmpty(r101.f540613i) == true) goto L93;
        boolean r109 = TextUtils.equals(r102.getHost(), UriProtector.parse(r101.f540613i).getHost());
    L94:
        if (r109 == false) goto L98;
        tt5.a.h("SpaceKitUrlHelper", "isSuiteUrl()... in WhiteList");
        return true;
    L98:
        if (this.f540594j == false) goto L104;
        int r111 = sbb.e.g(this.f540593i.d(r110).getType());
        if (Arrays.asList(sbb.e.f541315z).contains(Integer.valueOf(r111)) == false) goto L104;
        tt5.a.h("SpaceKitUrlHelper", "isSuiteUrl()... in path for ka, type = " + r111);
        return true;
    L104:
        if (this.f540594j == false) goto L106;
    L109:
        tt5.a.h("SpaceKitUrlHelper", "isSuiteUrl()...result = false");
        return false;
    L106:
        if (ia(r110) == false) goto L109;
        tt5.a.h("SpaceKitUrlHelper", "isSuiteUrl()...bitable url");
        return true;
    L54:
        if (TextUtils.isEmpty(r106) == true) goto L68;
        if (r104.length() < r106.length()) goto L68;
        if (r104.endsWith(r106) == false) goto L68;
        if (r104.length() != r106.length()) goto L66;
    L67:
        r107 = true;
        goto L69
    L66:
        if (r104.charAt((r104.length() - r106.length()) - 1) != '.') goto L68;
    L71:
        r108 = false;
    L76:
        String r112 = r102.getScheme() + "://" + r102.getHost() + r102.getPath();
    L88:
        e = move-exception;
        tt5.a.f("WhiteList", e, false);
    L91:
        if (TextUtils.isEmpty(r101.f540613i) == true) goto L93;
        r109 = TextUtils.equals(r102.getHost(), UriProtector.parse(r101.f540613i).getHost());
        goto L94
    L78:
        if (r101.f540612h == true) goto L80;
        Iterator r113 = ((CopyOnWriteArrayList) r101.f540605a).iterator();     // Catch: Exception -> L88
    L84:
        if (r113.hasNext() == false) goto L91;
        if (((Pattern) r113.next()).matcher(r112).find() == false) goto L84;
    L87:
        r109 = true;
        goto L94
    L80:
        if (PatternProtector.compile(String.format("%s%s%s", new Object[]{"(\\/|\\.)", r101.f540609e, r101.f540611g})).matcher(r112).find() == false) goto L91;
    L93:
        r109 = false;
        goto L94
    }

    @Override // t45.c
    public final String v8(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        tt5.a.h("SpaceKitUrlHelper", "correctProductUrl() url is empty");
        return "";
    L7:
        if (a.e(UriProtector.parse(r100).getPath()) == null) goto L9;
        return r100;
    L9:
        String r101 = va(r100);
        BearUrl r102 = this.f540593i.d(r100);
        if (TextUtils.isEmpty(r102.getType()) == false) goto L12;
    L25:
        return r101;
    L12:
        if (TextUtils.isEmpty(r102.f222561b) == true) goto L25;
        if (r102.f222564e.contains("record") == false) goto L17;
        return r101;
    L17:
        if (TextUtils.equals(sbb.e.f541298i.getType(), r102.getType()) == false) goto L22;
        if (Oa(r102.f222564e) == false) goto L22;
        return r101;
    L22:
        if (r102.f222564e.contains("share/base") == true) goto L25;
        return UriProtector.parse(r101).buildUpon().path(a9(r102.getType(), r102.f222561b)).build().toString();
    }

    @Override // t45.c
    public final String va(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L24;
        tt5.a.h("SpaceKitUrlHelper", "url is empty");
        return r100;
    L24:
        l r101 = h(r100);     // Catch: Exception -> L21
        String r102 = r101.f540579d;     // Catch: Exception -> L21
        if (TextUtils.isEmpty(r102) == false) goto L11;
        tt5.a.h("SpaceKitUrlHelper", "urlHost is empty");     // Catch: Exception -> L21
        return r100;
    L11:
        String r103 = this.f540588d.t6(r102);     // Catch: Exception -> L21
        tt5.a.h("SpaceKitUrlHelper", "urlHost : " + r102 + "  value : " + r103);     // Catch: Exception -> L21
        if (TextUtils.isEmpty(r103) == false) goto L14;
    L23:
        return r100;
    L14:
        if (TextUtils.isEmpty(r101.f540576a) == true) goto L16;
        int r104 = r103.indexOf(46);     // Catch: Exception -> L21
        if (r104 == (-1)) goto L23;
        return r100.replaceFirst(r101.f540578c, r103.substring(0, r104 + 1) + r101.f540576a + r103.substring(r104));
    L16:
        return r100.replaceFirst(r102, r103);
    L21:
        e = move-exception;
        tt5.a.f("SpaceKitUrlHelper", e, false);
        goto L23
    }

    public static void f(Map r100, JSONArray r110) {
        if (r110 != null) goto L5;
    L22:
        tt5.a.h("SpaceKitUrlHelper", "initMgApiDomain is empty.");
    L23:
        tt5.a.h("SpaceKitUrlHelper", "initMgApiDomain parseDocsMgHost ret=" + r100);
        return;
    L5:
        if (r110.length() <= 0) goto L22;
        int r101 = 0;
    L8:
        if (r101 >= r110.length()) goto L23;
        String[] r102 = r110.optString(r101, "").split("\\|");
        String r103 = r102[0];
        String r104 = r102[1];
        String r105 = r102[2];
        if (TextUtils.isEmpty(r103) == true) goto L21;
        if (TextUtils.isEmpty(r105) == true) goto L21;
        Map r106 = (Map) r100.get(r103);
        if (r106 != null) goto L16;
        r106 = new ConcurrentHashMap();
        r100.put(r103, r106);
    L16:
        String[] r107 = r105.split(",");
        int r108 = 0;
    L18:
        if (r108 >= r107.length) goto L20;
        r107[r108] = r107[r108].trim();
        r108 = r108 + 1;
        goto L18
    L20:
        tt5.a.h("SpaceKitUrlHelper", "parseDocsMgHost brand=" + r103 + " geo=" + r104 + " hosts=" + Arrays.toString(r107));
        r106.put(r104, r107);
    L21:
        r101 = r101 + 1;
        goto L8
    }

    public static void g(Map r100, JSONArray r101) {
        if (r101 != null) goto L5;
    L17:
        tt5.a.h("SpaceKitUrlHelper", "initMgApiDomainV2 is empty.");
    L18:
        tt5.a.h("SpaceKitUrlHelper", "initMgApiDomainV2 parseDocsMgHost ret=" + r100);
        return;
    L5:
        if (r101.length() <= 0) goto L17;
        int r102 = 0;
    L8:
        if (r102 >= r101.length()) goto L18;
        String[] r103 = r101.optString(r102, "").split("\\|");
        String r104 = r103[0];
        String r105 = r103[1];
        if (TextUtils.isEmpty(r105) == true) goto L16;
        String[] r106 = r105.split(",");
        int r107 = 0;
    L13:
        if (r107 >= r106.length) goto L15;
        r106[r107] = r106[r107].trim();
        r107 = r107 + 1;
        goto L13
    L15:
        tt5.a.h("SpaceKitUrlHelper", "parseDocsMgHostV2 geo=" + r104 + " hosts=" + Arrays.toString(r106));
        r100.put(r104, r106);
    L16:
        r102 = r102 + 1;
        goto L8
    }

    @Override // t45.c
    public final String A9(String r100, String r101) {
        return Le(r100, r101, null);
    }

    @Override // t45.c
    public final boolean H3(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L19:
        tt5.a.h("SpaceKitUrlHelper", "isSameVersionUrl()...false for empty");
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L19;
        if (L5(r100) == true) goto L10;
    L17:
        tt5.a.h("SpaceKitUrlHelper", "isSameVersionUrl()...false for some one not version url");
        return false;
    L10:
        if (L5(r101) == false) goto L17;
        return TextUtils.equals(UriProtector.getQueryParameter(UriProtector.parse(r100), "edition_id"), UriProtector.getQueryParameter(UriProtector.parse(r101), "edition_id"));
    L14:
        e = move-exception;
        tt5.a.d("SpaceKitUrlHelper", "isSameVersionUrl()...err: " + e.getMessage());
        return false;
    }

    @Override // t45.c
    public final boolean Ha(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L20:
        tt5.a.h("SpaceKitUrlHelper", "isSameProductUrl()...false for empty");
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L20;
        if (v6(r100) == true) goto L10;
    L18:
        tt5.a.h("SpaceKitUrlHelper", "isSameProductUrl()...false for not suite url");
        return false;
    L10:
        if (v6(r101) == false) goto L18;
        BearUrl r102 = Z(r100);
        BearUrl r103 = Z(r101);
        tt5.a.h("SpaceKitUrlHelper", "isSameProductUrl()...first type = " + r102.f222560a + ", second type = " + r103.f222560a);
        if (TextUtils.equals(r102.f222560a, r103.f222560a) == true) goto L15;
        return false;
    L15:
        if (TextUtils.equals(r102.f222561b, r103.f222561b) == false) goto L23;
        return true;
    L23:
        return false;
    }

    @Override // t45.c
    public final void I9(String[] r100, String[] r110) {
        r r101 = this.f540590f;
        r101.getClass();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        String r104 = r100[r103];
        int r105 = r110.length;
        int r106 = 0;
    L5:
        if (r106 >= r105) goto L7;
        r101.a(r104, r110[r106]);
        r106 = r106 + 1;
        goto L5
    L7:
        r103 = r103 + 1;
        goto L3
    }

    @Override // t45.c
    public final String a9(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        tt5.a.h("SpaceKitUrlHelper", "genProductPath()...type is null");
        return null;
    L7:
        if (TextUtils.isEmpty(r101) == false) goto L10;
        tt5.a.h("SpaceKitUrlHelper", "genProductPath()...token is null");
        return null;
    L10:
        HashMap r102 = (HashMap) this.f540589e.f540559r;
        String r103 = (String) r102.get(r100);
        if (TextUtils.isEmpty(r103) == false) goto L13;
        r103 = (String) r102.get("default");
    L13:
        if (r103 != null) goto L16;
        tt5.a.d("SpaceKitUrlHelper", "template is null, type = " + r100);
        return null;
    L16:
        String r104 = sbb.e.b(r100);
        if (TextUtils.equals(r100, sbb.e.f541298i.getType()) == false) goto L24;
        Boolean r105 = this.f540603s.get(r101);
        if (r105 == null) goto L24;
        if (r105.booleanValue() == false) goto L24;
        r104 = this.f540589e.F;
    L24:
        return r103.replace("${type}", r104).replace("${token}", r101);
    }

    @Override // t45.c
    public final String j8(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        tt5.a.h("SpaceKitUrlHelper", "genPhoenixPath()...type is null");
        return null;
    L7:
        if (TextUtils.isEmpty(r101) == false) goto L11;
        tt5.a.h("SpaceKitUrlHelper", "genPhoenixPath()...token is null");
        return null;
    L11:
        if (TextUtils.isEmpty(this.f540589e.f540563v) == false) goto L15;
        tt5.a.h("SpaceKitUrlHelper", "genPhoenixPath()...phoenixPath is null");
        return null;
    L15:
        return this.f540589e.f540563v.replace("${type}", sbb.e.b(r100)).replace("${token}", r101);
    }

    @Override // t45.c
    public final boolean na(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.equals(Z(r100).f222560a, r101) == false) goto L7;
        return true;
    }

    @Override // t45.c
    public final void rd(String r100, boolean r101) {
        this.f540603s.put(r100, Boolean.valueOf(r101));
    }

    @Inject
    public p(c r100, awa.d r101, f r102) {
        this.f540595k = new CompositeDisposable();
        this.f540596l = new ConcurrentHashMap();
        this.f540597m = new ConcurrentHashMap();
        this.f540598n = new ConcurrentHashMap();
        this.f540599o = new ConcurrentHashMap();
        this.f540601q = null;
        this.f540602r = null;
        this.f540603s = new ConcurrentHashMap();
        tt5.a.h("SpaceKitUrlHelper", "getInstance dwarf SpaceKitUrlHelper instance=" + this);
        this.f540588d = r100;
        this.f540589e = r102;
        this.f540593i = new q(r102);
        this.f540600p = r101;
        String r103 = (String) new ml5.b("debug_config").a("ip_proxy", "");
        this.f540592h = r103;
        this.f540590f = new r(r103);
        this.f540591g = new b(this.f540589e.f540554m);
        if (TextUtils.isEmpty(this.f540592h) == true) goto L7;
        String r104 = this.f540592h;
        r r105 = this.f540590f;
        String[] r106 = this.f540589e.f540553l;
        r105.getClass();
        int r107 = r106.length;
        int r108 = 0;
    L5:
        if (r108 >= r107) goto L7;
        r105.a(r104, r106[r108]);
        r108 = r108 + 1;
    L7:
        j();
        e(this.f540586b);
        d(this.f540587c);
        tt5.a.h("SpaceKitUrlHelper", "init()...mWhiteList " + this.f540590f.f540606b.toString());
        c();
        i();
    }

    @Override // t45.c
    public final String Le(String r100, String r101, Map<String, String> r102) {
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.ark_domain") == false) goto L5;
        String r103 = f9();
    L7:
        return Te(r103, r100, r101, r102);
    L5:
        r103 = f540583t;
        goto L7
    }

    @Override // t45.c
    public final void O7(String r100, String r101, String r102) {
        this.f540585a = r101;
        c2(r100);
        F3(r102);
        c();
        tt5.a.h("SpaceKitUrlHelper", "onConfigChanged()...api domain = " + r100 + ", product domain = " + r102);
    }

    @Override // t45.c
    public String ua(String r100, String r101, String r102) {
        String r103 = a9(r100, r101);
        if (r103 != null) goto L5;
    L7:
        Uri.Builder r104 = new Uri.Builder().scheme("https");
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.ark_domain") == false) goto L10;
        String r105 = f9();
    L11:
        Uri.Builder r106 = r104.authority(r105).appendEncodedPath(r103);
        if (TextUtils.isEmpty(r102) == true) goto L15;
        r106.appendQueryParameter("from", r102);
    L15:
        return r106.build().toString();
    L10:
        r105 = f540583t;
        goto L11
    L5:
        if (r103.startsWith(HTTP.URL_DEFAULT) == false) goto L7;
        r103 = r103.substring(1);
        goto L7
    }

    @Override // t45.c
    public final String Fd(String r100, String r101, String r102, Map<String, String> r103) {
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.ark_domain") == false) goto L5;
        String r104 = f9();
    L7:
        if (TextUtils.isEmpty(r100) == true) goto L14;
        if (v6(r100) == false) goto L14;
        Uri r105 = UriProtector.parse(r100);
        if (TextUtils.isEmpty(r105.getHost()) == true) goto L14;
        r104 = r105.getHost();
    L14:
        return Te(r104, r101, r102, r103);
    L5:
        r104 = f540583t;
        goto L7
    }

    @Override // t45.c
    public String J8(String r100, String r101, String r102, String r103) {
        String r104 = a9(r100, r101);
        if (r104 != null) goto L5;
    L7:
        Uri.Builder r105 = new Uri.Builder().scheme("https");
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.ark_domain") == false) goto L10;
        String r106 = f9();
    L11:
        Uri.Builder r107 = r105.authority(r106).appendEncodedPath(r104);
        if (TextUtils.isEmpty(r102) == true) goto L15;
        r107.appendQueryParameter("from", r102);
    L15:
        if (TextUtils.isEmpty(r103) == true) goto L18;
        r107.appendQueryParameter("ccm_open_type", r103);
    L18:
        return r107.build().toString();
    L10:
        r106 = f540583t;
        goto L11
    L5:
        if (r104.startsWith(HTTP.URL_DEFAULT) == false) goto L7;
        r104 = r104.substring(1);
        goto L7
    }

    @Override // t45.c
    public String Te(String r100, String r101, String r102, Map<String, String> r103) {
        String r104 = a9(r101, r102);
        if (r104 != null) goto L5;
    L7:
        Uri.Builder r105 = new Uri.Builder().scheme("https").authority(r100).appendEncodedPath(r104);
        if (hu5.a.e(r103) == true) goto L14;
        Iterator<Map.Entry<String, String>> r106 = r103.entrySet().iterator();
    L11:
        if (r106.hasNext() == false) goto L14;
        Map.Entry<String, String> r107 = r106.next();
        r105.appendQueryParameter(r107.getKey(), r107.getValue());
    L14:
        return r105.build().toString();
    L5:
        if (r104.startsWith(HTTP.URL_DEFAULT) == false) goto L7;
        r104 = r104.substring(1);
        goto L7
    }
}
