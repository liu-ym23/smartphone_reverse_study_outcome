package n25;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import android.webkit.WebResourceResponse;
import androidx.exifinterface.media.ExifInterface;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.LazyHeaders;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.doc.resupdate.e0;
import com.bytedance.ee.bear.document.DocOpenConfig;
import com.bytedance.ee.bear.document.g5;
import com.bytedance.ee.bear.document.offline.drive.DriveCompressCheckerV2;
import com.bytedance.ee.bear.document.q1;
import com.bytedance.ee.bear.document.s1;
import com.bytedance.ee.bear.lark.dependency.m;
import com.bytedance.ee.bear.middleground.drive.export.DownloadRequestInfo;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.bytedance.ee.util.io.FileUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.larksuite.component.ui.display.manager.zoom.ZoomLevel6;
import com.ss.android.lark.dynamicconfig.interfaces.IDomainConfigService;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.PackageChannelManager;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.lark.android.encryption.CipherManager;
import e0c.k;
import j25.q;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import s45.p;

/* JADX INFO: loaded from: classes16.dex */
public class g {
    public static final boolean A = false;
    public static int B;
    public static int C;
    public static int D;
    public static final int E = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static volatile String f516711y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static volatile String f516712z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f516713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f516714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f516715c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f516716d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f516717e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f516718f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f516719g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Context f516720h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final h0 f516721i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final NetService f516722j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final i0 f516723k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.bytedance.ee.bear.contract.d f516724l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b0 f516725m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public LazyHeaders f516726n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ml5.b f516727o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public l25.a f516728p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final DriveCompressCheckerV2 f516729q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f516730r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f516731s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f516732t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f516733u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile boolean f516734v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f516735w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final s1 f516736x;

    public class a implements com.bytedance.ee.bear.contract.b {
        public a() {
        }

        @Override // com.bytedance.ee.bear.contract.b
        public final void a(AccountService$Account r100) {
            g.f516711y = null;
            g.f516712z = null;
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f516737a = null;

        static {
            int[] r100 = new int[ZoomLevel6.values().length];
            f516737a = r100;
            r100[ZoomLevel6.SMALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f516737a[ZoomLevel6.LARGE1.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f516737a[ZoomLevel6.LARGE2.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f516737a[ZoomLevel6.LARGE3.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f516737a[ZoomLevel6.LARGE4.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public final String d() {
        JSONObject r100 = new JSONObject();     // Catch: Throwable -> L8
        String[] r101 = e.f516708a;     // Catch: Throwable -> L8
        int r102 = r101.length;     // Catch: Throwable -> L8
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L6;
        String r104 = r101[r103];     // Catch: Throwable -> L8
        r100.put(r104, com.bytedance.ee.bear.appsetting.c.a.f206237a.g(r104));     // Catch: Throwable -> L8
        r103 = r103 + 1;     // Catch: Throwable -> L8
        goto L4
    L6:
        tt5.a.h(this.f516714b, "getFG_RORM size is " + e.f516708a.length);     // Catch: Throwable -> L8
        return r100.toString();
    L8:
        th = move-exception;
        tt5.a.f(this.f516714b, th, false);
        return SliceInitService.DEFAULT_SWITCH;
    }

    static {
        boolean r100 = com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.inject_fg_enable");
        A = r100;
        if (r100 == false) goto L5;
        ((h0) org.koin.java.a.a(h0.class)).Pe(new a());
    L5:
        B = 0;
        C = 0;
        D = -1;
        E = 3;
    }

    public final synchronized void a() {
        monitor-enter(this);
        e0 r100 = ((com.bytedance.ee.bear.doc.resupdate.g) org.koin.java.a.a(com.bytedance.ee.bear.doc.resupdate.g.class)).getResource();     // Catch: Throwable -> L24
        VFSFile r101 = r100.f218007a;     // Catch: Throwable -> L24
        String r102 = r100.f218008b;     // Catch: Throwable -> L24
        if (r101 != null) goto L7;
    L9:
        boolean r103 = false;
    L10:
        i r104 = new i(r101, r102, r103);     // Catch: Throwable -> L24
        if (r101 == null) goto L13;
        VFSFile r105 = ay4.d.a().B(r101);     // Catch: Throwable -> L24
    L14:
        this.f516732t = r103;     // Catch: Throwable -> L24
        this.f516728p = new l25.a(this.f516722j, this.f516724l, r104);     // Catch: Throwable -> L24
        ow4.a.f527057a = r102;     // Catch: Throwable -> L24
        boolean r106 = h(r105);     // Catch: Throwable -> L24
        this.f516730r = r106;     // Catch: Throwable -> L24
        if (r106 == false) goto L18;
        if (r105 == null) goto L18;
        ((com.bytedance.ee.bear.rn.j) org.koin.java.a.a(com.bytedance.ee.bear.rn.j.class)).n(r105.getVfsPath());     // Catch: Throwable -> L24
    L19:
        this.f516717e = d25.d.b(e(this.f516715c));     // Catch: Throwable -> L24
        tt5.a.h(this.f516714b, "internalCheckOfflineRes() initSuccess = " + this.f516730r + ", resource = " + r104);     // Catch: Throwable -> L24
        if (TextUtils.isEmpty(this.f516717e) == true) goto L22;
        s();     // Catch: Throwable -> L24
    L22:
        monitor-exit(this);
        return;
    L18:
        tt5.a.d(this.f516714b, "checkOfflineRes(): init fail");     // Catch: Throwable -> L24
        goto L19
    L13:
        r105 = null;
        goto L14
    L7:
        if (r101.getAbsolutePath().contains("_sim") == false) goto L9;
        r103 = true;
    L24:
        th = move-exception;
        throw th;
    }

    public void s() {
        String r100 = "lf-package-cn.feishucdn.com/obj/feishu-static";
        AccountService$Account r101 = this.f516721i.U5();
        String r102 = "";
        if (r101 == null) goto L11;
        String r103 = this.f516717e;
        String r104 = r101.uid;
        if (r104 != null) goto L7;
        r104 = "";
    L7:
        String r105 = r103.replace("{{ user_id }}", r104);
        this.f516717e = r105;
        String r106 = r101.tenantId;
        if (r106 != null) goto L10;
        r106 = "";
    L10:
        this.f516717e = r105.replace("{{ tenant_id }}", r106);
    L11:
        String r107 = ou5.b.a(this.f516723k.c().getCountry(), this.f516723k.a());
        JSONArray r108 = new JSONArray(((s45.c) org.koin.java.a.a(s45.c.class)).Ba("overload_static_domain_new"));     // Catch: JSONException -> L18
        if (r108.length() <= 0) goto L16;
        String r109 = r108.optString(0, "");     // Catch: JSONException -> L18
    L17:
        String r110 = r109;
    L20:
        String r111 = this.f516717e.replace("{{lang_cdn}}", "//" + r110 + "/eesz/resource/bear/lang/" + r107 + ".js");
        this.f516717e = r111;
        this.f516717e = r111.replace("{{ language }}", ou5.b.c(this.f516723k.c().getCountry(), this.f516723k.a()));
        com.bytedance.ee.bear.appsetting.c r112 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        this.f516717e = this.f516717e.replace("\"{{ app_config }}\"", (String) r112.d("app_config", SliceInitService.DEFAULT_SWITCH));
        if (r112.g("ccm.mobile.domain_geo_replace_enable") == true) goto L26;
        String r113 = DocOpenConfig.c();
        if (TextUtils.equals(r113, SliceInitService.DEFAULT_SWITCH) == false) goto L27;
        tt5.a.d(this.f516714b, "replaceTemplateInfos()...domainCharacteristic is empty");
        iu5.d.a(this.f516714b, new RuntimeException("domainCharacteristic is empty"));
        return;
    L27:
        this.f516717e = this.f516717e.replace("\"{{ domain_characteristic_config }}\"", r113);
        tt5.a.h(this.f516714b, "replaceTemplateInfos()...lan = " + r107 + ", domainCharacteristicConfig = " + r113);
        this.f516717e = this.f516717e.replace("\"{{ app_debug_config }}\"", "{\"isDebug\":" + this.f516727o.a("isDebug", Boolean.FALSE) + com.alipay.sdk.m.u.i.f25855d);
        if (this.f516722j.w6() == false) goto L30;
        String r114 = "staging";
    L31:
        String r115 = this.f516717e.replace("{{navigator_env}}", r114);
        this.f516717e = r115;
        this.f516717e = r115.replace("{{navigator_path_prefix}}", p.a().T0());
        this.f516717e = this.f516717e.replace("{{navigator_api_prefix}}", "https://" + p.f540584u + HTTP.URL_DEFAULT + p.a().u9());
        boolean r116 = this.f516725m.b();
        String r117 = BdpAppEventConstant.FALSE;
        if (r116 == false) goto L34;
        this.f516717e = this.f516717e.replace("{{ anonymous_access }}", BdpAppEventConstant.TRUE);
    L35:
        String r118 = this.f516717e;
        String r119 = n25.b.f516700a;
        Application r120 = LarkContext.getApplication();
        if (r120 != null) goto L38;
    L40:
        boolean r121 = false;
    L41:
        if (r121 == false) goto L43;
        CharSequence r122 = BdpAppEventConstant.TRUE;
    L44:
        String r123 = r118.replace("{{ is_ka }}", r122);
        this.f516717e = r123;
        Application r124 = LarkContext.getApplication();
        if (r124 != null) goto L47;
    L49:
        boolean r125 = false;
    L50:
        if (r125 == false) goto L52;
        r102 = PackageChannelManager.getBuildPackageChannel(r124);
    L52:
        this.f516717e = r123.replace("{{ ka_channel }}", r102);
        String[] r126 = n25.b.f516701b;
        int r127 = r126.length;
        int r128 = 0;
    L53:
        if (r128 >= r127) goto L55;
        this.f516717e = this.f516717e.replace(r126[r128], "null");
        r128 = r128 + 1;
        goto L53
    L55:
        this.f516717e = this.f516717e.replace("{{ enable_et_test }}", ((Boolean) this.f516727o.a("enable_frontend_et_test", Boolean.FALSE)).toString());
        String r129 = ((m) org.koin.java.a.a(m.class)).getString();
        if (TextUtils.isEmpty(r129) == false) goto L58;
        r129 = SliceInitService.DEFAULT_SWITCH;
    L58:
        this.f516717e = this.f516717e.replace("\"{{ globalKaConfig }}\"", r129);
        int r130 = b.f516737a[zz7.b.d().ordinal()];
        if (r130 != 1) goto L61;
        String r131 = ExifInterface.LATITUDE_SOUTH;
    L74:
        tt5.a.h(this.f516714b, "currentBaseFontSize = ".concat(r131));
        String r132 = this.f516717e.replace("\"{{ device_info }}\"", String.format("{\"baseFontSize\": \"%s\"}", new Object[]{r131}));
        this.f516717e = r132;
        if (h18.f.a(eu5.b.f474075a) == false) goto L77;
        String r133 = "\"dark\"";
    L78:
        this.f516717e = r132.replace("\"{{ theme }}\"", r133);
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.i("ccm.theme.mobile_darkmode_enable", false) == false) goto L81;
        this.f516717e = this.f516717e.replace("{{ darkmode_enable }}", BdpAppEventConstant.TRUE);
    L82:
        String r134 = this.f516717e;
        if (CipherManager.d() != 1) goto L85;
        r117 = BdpAppEventConstant.TRUE;
    L85:
        String r135 = r134.replace("{{ disk_crypto_enable }}", r117);
        this.f516717e = r135;
        String r136 = r135.replace("{{ comment_disable_rn }}", BdpAppEventConstant.TRUE);
        this.f516717e = r136;
        if (A == true) goto L88;
        this.f516717e = r136.replace("\"{{ mobile_fg_dictionary }}\"", d());
    L112:
        String r137 = this.f516717e;
        if (f516712z == null) goto L115;
        tt5.a.h(this.f516714b, "sAbTestMap is not null");
        String r138 = f516712z;
    L138:
        this.f516717e = r137.replace("\"{{ mobile_ab_test_dictionary }}\"", r138);
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.dynamic_cdn_domain_enable") == false) goto L142;
        r100 = r110;
    L142:
        l25.a r139 = this.f516728p;
        r139.getClass();
        if (r100.startsWith("http://") == false) goto L145;
    L147:
        String r140 = r100;
    L181:
        r139.f507118e = new URL(r140).getHost();     // Catch: Exception -> L150
    L152:
        String r141 = this.f516717e.replace("{{cdn_host}}", "//".concat(r100));
        this.f516717e = r141;
        JSONObject r142 = new JSONObject();
        com.bytedance.ee.bear.appsetting.c r143 = com.bytedance.ee.bear.appsetting.c.a.f206237a;     // Catch: Exception -> L177
        if (r143.g("ccm.mobile.enable_web_setting_dynamic") == false) goto L175;
        JSONObject r144 = new JSONObject((String) r143.d("ccm_web_template_setting_config", SliceInitService.DEFAULT_SWITCH));     // Catch: Exception -> L177
        Iterator<String> r145 = r144.keys();     // Catch: Exception -> L177
    L157:
        if (r145.hasNext() == false) goto L179;
        String r146 = r145.next();     // Catch: Exception -> L177
        Object r147 = r144.get(r146);     // Catch: Exception -> L177
        if ((r147 instanceof JSONArray) == true) goto L160;
        tt5.a.d(this.f516714b, "replaceTemplateInfos()... value is not JSONArray");     // Catch: Exception -> L177
        goto L157
    L160:
        JSONArray r148 = (JSONArray) r147;     // Catch: Exception -> L177
        if (r148.length() == 0) goto L162;
        JSONObject r149 = new JSONObject();     // Catch: Exception -> L177
        int r150 = 0;
    L165:
        if (r150 >= r148.length()) goto L173;
        Object r151 = r148.get(r150);     // Catch: Exception -> L177
        if ((r151 instanceof String) == false) goto L172;
        String r152 = (String) r151;     // Catch: Exception -> L177
        Object r153 = new JSONObject((String) com.bytedance.ee.bear.appsetting.c.a.f206237a.d(r146, SliceInitService.DEFAULT_SWITCH)).opt(r152);     // Catch: Exception -> L177
        if (r153 == null) goto L172;
        r149.put(r152, r153);     // Catch: Exception -> L177
    L172:
        r150 = r150 + 1;     // Catch: Exception -> L177
        goto L165
    L173:
        r142.put(r146, r149);     // Catch: Exception -> L177
        goto L157
    L162:
        r142.put(r146, new JSONObject((String) com.bytedance.ee.bear.appsetting.c.a.f206237a.d(r146, SliceInitService.DEFAULT_SWITCH)));     // Catch: Exception -> L177
    L179:
        this.f516717e = r141.replace("\"{{ settings_config }}\"", r142.toString());
        return;
    L175:
        JSONObject r154 = new JSONObject();     // Catch: Exception -> L177
        r154.put(IDomainConfigService.DomainAlias.DOCS_REACTION_BUCKET_PREX, new JSONArray(jcb.b.c().b(IDomainConfigService.DomainAlias.DOCS_REACTION_BUCKET_PREX)));     // Catch: Exception -> L177
        r154.put("suite_security_link", new JSONArray(jcb.b.c().b("suite_security_link")));     // Catch: Exception -> L177
        JSONObject r155 = new JSONObject();     // Catch: Exception -> L177
        r155.put("sec_link_whitelist", new JSONObject((String) r143.d("domain_manage_policy", SliceInitService.DEFAULT_SWITCH)).get("sec_link_whitelist"));     // Catch: Exception -> L177
        r142.put("biz_domain_config", r154);     // Catch: Exception -> L177
        r142.put("domain_manage_policy", r155);     // Catch: Exception -> L177
    L177:
        e = move-exception;
        tt5.a.e(this.f516714b, "replaceTemplateInfos()... ", e, false);
    L150:
        e = move-exception;
        r139.f507118e = r140;
        tt5.a.f("RemoteResourceLoader", e, false);
        goto L152
    L145:
        if (r100.startsWith("https://") == true) goto L147;
        r140 = "https://".concat(r100);
        goto L181
    L115:
        String r156 = this.f516718f.get("resource_root_path");
        if (r156 != null) goto L118;
        tt5.a.h(this.f516714b, "getAbTestValue, resource_root_path is null");
    L137:
        r138 = SliceInitService.DEFAULT_SWITCH;
        goto L138
    L118:
        tt5.a.h(this.f516714b, "getAbTestValue from file");
        JSONObject r157 = new JSONObject();
        Map<String, iua.a<?>> r158 = o25.a.b();     // Catch: Throwable -> L135
        String[] r159 = FileUtils.E(ay4.d.a().z(r156).subPath("mobileABTestKeys.txt")).split(",");     // Catch: Throwable -> L135
        tt5.a.h(this.f516714b, "getAbTestValue keys size is " + r159.length);     // Catch: Throwable -> L135
        int r160 = r159.length;     // Catch: Throwable -> L135
        int r161 = 0;
    L120:
        if (r161 >= r160) goto L133;
        String r162 = r159[r161];     // Catch: Throwable -> L135
        if (TextUtils.isEmpty(r162) == true) goto L131;
        HashMap r163 = (HashMap) r158;     // Catch: Throwable -> L135
        if (r163.containsKey(r162) == false) goto L131;
        if (r163.get(r162) == null) goto L131;
        String r164 = ((xm4.a.InterfaceC8255a) org.koin.java.a.a(xm4.a.InterfaceC8255a.class)).b(((iua.a) r163.get(r162)).getClass().getName());     // Catch: Throwable -> L135
        if (TextUtils.isEmpty(r164) == true) goto L130;
        r157.put(r162, r164);     // Catch: Throwable -> L135
    L132:
        r161 = r161 + 1;     // Catch: Throwable -> L135
        goto L120
    L130:
        tt5.a.k(this.f516714b, "getAbTestValue but value is null");     // Catch: Throwable -> L135
    L131:
        tt5.a.k(this.f516714b, "getAbTestValue key is " + r162 + " has registered: " + ((HashMap) r158).containsKey(r162));     // Catch: Throwable -> L135
        goto L132
    L133:
        f516712z = r157.toString();     // Catch: Throwable -> L135
        tt5.a.h(this.f516714b, "getAbTestValue success");     // Catch: Throwable -> L135
        r138 = f516712z;     // Catch: Throwable -> L135
    L135:
        th = move-exception;
        tt5.a.e(this.f516714b, "getAbTestValue", th, false);
        goto L137
    L88:
        if (f516711y == null) goto L90;
        tt5.a.h(this.f516714b, "sFgMap is not null");
        String r165 = f516711y;
    L106:
        String r166 = this.f516717e;
        if (r165 != null) goto L110;
        r165 = SliceInitService.DEFAULT_SWITCH;
    L110:
        this.f516717e = r166.replace("\"{{ mobile_fg_dictionary }}\"", r165);
        goto L112
    L90:
        String r167 = this.f516718f.get("resource_root_path");
        if (r167 != null) goto L93;
        tt5.a.h(this.f516714b, "resource_root_path is null");
        r165 = d();
        goto L106
    L93:
        tt5.a.h(this.f516714b, "getFGValueV2 from file");
        JSONObject r168 = new JSONObject();
        String[] r169 = FileUtils.E(ay4.d.a().z(r167).subPath("featureGatingKeys.txt")).split(",");     // Catch: Throwable -> L104
        tt5.a.h(this.f516714b, "keys size is " + r169.length);     // Catch: Throwable -> L104
        int r170 = r169.length;     // Catch: Throwable -> L104
        int r171 = 0;
    L95:
        if (r171 >= r170) goto L102;
        String r172 = r169[r171];     // Catch: Throwable -> L104
        if (TextUtils.isEmpty(r172) == true) goto L101;
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g(r172) == false) goto L101;
        r168.put(r172, true);     // Catch: Throwable -> L104
    L101:
        r171 = r171 + 1;     // Catch: Throwable -> L104
        goto L95
    L102:
        f516711y = r168.toString();     // Catch: Throwable -> L104
        tt5.a.h(this.f516714b, "getFGValueV2 success");     // Catch: Throwable -> L104
        r165 = r168.toString();     // Catch: Throwable -> L104
    L104:
        th = move-exception;
        tt5.a.f(this.f516714b, th, false);
        r165 = d();
        goto L106
    L81:
        this.f516717e = this.f516717e.replace("{{ darkmode_enable }}", BdpAppEventConstant.FALSE);
        goto L82
    L77:
        r133 = "\"light\"";
        goto L78
    L61:
        if (r130 != 2) goto L63;
        r131 = "L";
        goto L74
    L63:
        if (r130 != 3) goto L65;
        r131 = "XL";
        goto L74
    L65:
        if (r130 != 4) goto L67;
        r131 = "2XL";
        goto L74
    L67:
        if (r130 == 5) goto L69;
        r131 = "M";
        goto L74
    L69:
        r131 = "3XL";
        goto L74
    L47:
        if (PackageChannelManager.isKABuildPackage(r124) == false) goto L49;
        r125 = true;
        goto L50
    L43:
        r122 = BdpAppEventConstant.FALSE;
        goto L44
    L38:
        if (PackageChannelManager.isKABuildPackage(r120) == false) goto L40;
        r121 = true;
        goto L41
    L34:
        this.f516717e = this.f516717e.replace("{{ anonymous_access }}", BdpAppEventConstant.FALSE);
        goto L35
    L30:
        r114 = "prod";
        goto L31
    L26:
        r113 = DocOpenConfig.b();
        goto L27
    L16:
        r109 = "lf-package-cn.feishucdn.com/obj/feishu-static";
    L18:
        e = move-exception;
        tt5.a.e(this.f516714b, "getUpdateGifUrl err ", e, false);
        r110 = "lf-package-cn.feishucdn.com/obj/feishu-static";
        goto L20
    }

    public final void u() {
        int r100 = B;
        int r101 = D;
        if (r100 < r101) goto L5;
    L6:
        s1 r102 = this.f516736x;
        int r103 = C;
        HashMap r104 = new HashMap(r102.f221484b.m("docCommonParams"));
        r104.put("responsive", 0);
        r104.put("from", 100);
        r104.put("load_blank_dead_count", Integer.valueOf(r100));
        r104.put("load_blank_fail_count", Integer.valueOf(r103));
        r102.f221484b.n("ccm_webview_responsive_state_dev", r104);
        tt5.a.b("DocReport", "reportTopBarClickEvent, params = " + r104);
        return;
    L5:
        if (C >= r101) goto L6;
    }

    public static void c(Map r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.containsKey("Origin") == false) goto L8;
        r100.put("access-control-allow-credentials", "true");
        r100.put("access-control-allow-methods", "POST, GET, OPTIONS, PUT, DELETE");
        r100.put("access-control-allow-origin", (String) r100.get("Origin"));
        return;
    }

    public final InputStream e(String r100) {
        String r101 = this.f516718f.get(r100);
        if (TextUtils.isEmpty(r101) == true) goto L15;
        int r102 = j.f516741a;
        InputStream r103 = (InputStream) j.b(this.f516720h, r101, null).first;
        if (r103 == null) goto L11;
        int r104 = r103.available();     // Catch: Exception -> L13
        if (r104 <= 0) goto L10;
        tt5.a.h(this.f516714b, "getFileStreamByName()... mFileStreamCacheMap fileName = " + r100 + " inputStream size: " + r104);     // Catch: Exception -> L13
        return r103;
    L10:
        tt5.a.h(this.f516714b, "getFileStreamByName()..11.. fileName = " + r100);     // Catch: Exception -> L13
        goto L15
    L11:
        tt5.a.h(this.f516714b, "getFileStreamByName()..22.. fileName = " + r100);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        tt5.a.h(this.f516714b, "getFileStreamByName()..33.. fileName = " + r100 + "   ===== e = " + e);
    L15:
        return null;
    }

    public final Pair<InputStream, Pair<String, Long>> g(VFSPath r100) {
        Pair<InputStream, Pair<String, Long>> r101 = new Pair(null, new Pair("0", -1L));
        if (r100 != null) goto L5;
        return r101;
    L5:
        if (r100.toFile().exists() == false) goto L15;
        return new Pair(r100.toFile().newInputStream(), new Pair("0", Long.valueOf(r100.toFile().length())));
    L9:
        tt5.a.d(this.f516714b, "File not found");
        return r101;
    L15:
        return r101;
    }

    public final boolean h(VFSFile r100) {
        if (r100 == null) goto L10;
        if (r100.exists() == false) goto L10;
        ConcurrentHashMap<String, String> r101 = this.f516718f;
        if (r101 == null) goto L8;
        r101.clear();
    L8:
        HashMap r102 = new HashMap();
        q(r100, r102, r100.getParentFile().getAbsolutePath().length());
        this.f516718f.putAll(r102);
        this.f516718f.put("resource_root_path", r100.getVfsPath().getAbsolutePath());
    L10:
        return !TextUtils.isEmpty(this.f516718f.get(this.f516715c));
    }

    public final void i(Map<String, String> r100) {
        AccountService$Account r101 = this.f516721i.U5();
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.hasLogin() == false) goto L19;
        LazyHeaders.Builder r102 = new LazyHeaders.Builder();
        if (r100 != null) goto L9;
    L14:
        tt5.a.k(this.f516714b, "initHeaders: headers is null");
    L15:
        this.f516726n = r102.build();
        return;
    L9:
        if (r100.size() <= 0) goto L14;
        Iterator<String> r103 = r100.keySet().iterator();
    L12:
        if (r103.hasNext() == false) goto L15;
        String r104 = r103.next();
        r102.addHeader(r104, r100.get(r104));
        goto L12
    }

    public final InputStream j(String r100) {
        q r101 = k25.e0.m().y(r100);
        InputStream r102 = null;
        if (r101 != null) goto L17;
    L15:
        return r102;
    L17:
    L13:
        e = move-exception;
        tt5.a.f(this.f516714b, e, false);
        goto L15
    L5:
        if (TextUtils.isEmpty(r101.f497004d) == true) goto L10;
        VFSFile r103 = ay4.d.a().i(r101.f497004d);     // Catch: Exception -> L13
        if (r103.exists() == false) goto L16;
        r102 = r103.newInputStream();     // Catch: Exception -> L13
    L16:
        goto L15
    L10:
        if (TextUtils.isEmpty(r101.f497005e) == true) goto L16;
        r102 = ContentResolverWrapper.openInputStream(this.f516720h.getContentResolver(), UriProtector.parse(r101.f497005e));     // Catch: Exception -> L13
        goto L16
    }

    public final boolean p(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L14:
        return false;
    L5:
        if (TextUtils.isEmpty(this.f516716d) == true) goto L14;
        if (r100.endsWith(this.f516716d) == false) goto L14;
        int r101 = (r100.length() - this.f516716d.length()) - 1;
        if (r101 < 0) goto L14;
        if (r100.charAt(r101) != '.') goto L14;
        return true;
    }

    public final Pair<InputStream, Pair<String, Long>> k(String r100, Map<String, String> r101) {
        String r102 = yu5.c.h(r100);     // Catch: Exception -> L4
        return o(r100, r100, p.a().s0(UriProtector.parse(r102).getPath()), r101);
    L4:
        tt5.a.d(this.f516714b, "internalGetDriveCoverImageStream Exception e");
        return new Pair(null, new Pair("0", -1L));
    }

    public final Pair<InputStream, Pair<String, Long>> n(String r110, Map<String, String> r111) {
        com.bytedance.ee.bear.appsetting.c r100 = com.bytedance.ee.bear.appsetting.c.a.f206237a;     // Catch: Exception -> L14
        Application r101 = LarkContext.getApplication();     // Catch: Exception -> L14
        r100.getClass();     // Catch: Exception -> L14
        boolean r102 = ((dn4.a) k.b(((v) k.a(r101, v.class)).c(((com.ss.android.lark.passportc.convention.a) k.a(r101, com.ss.android.lark.passportc.convention.a.class)).b()), dn4.a.class)).a().isEnable("ccm.docx.chart_ssr_mobile");     // Catch: Exception -> L14
        Uri r103 = UriProtector.parse(r110);     // Catch: Exception -> L14
        if (r102 == true) goto L6;
        r110 = yu5.c.h(r110);     // Catch: Exception -> L14
    L6:
        String r104 = r103.getScheme() + "://" + p.f540584u + p.a().s0(UriProtector.parse(r110).getPath());     // Catch: Exception -> L14
        if (r102 == false) goto L13;
        r104 = r104 + "?" + r103.getEncodedQuery();     // Catch: Exception -> L14
        if (TextUtils.equals(UriProtector.getQueryParameter(r103, "notIntercept"), "true") == false) goto L13;
        return new Pair(null, new Pair("0", -1L));
    L13:
        return o(r110, r104, r110, r111);
    L14:
        tt5.a.d(this.f516714b, "internalGetNetImageStream Exception e");
        return new Pair(null, new Pair("0", -1L));
    }

    public final w85.b l(String r100, DownloadRequestInfo.DownloadType r101, int r102) {
        Uri r103 = UriProtector.parse(r100);
        if (r103 == null) goto L9;
        String r104 = r103.getLastPathSegment();
        q r105 = k25.e0.m().y(r104);
        if (r105 == null) goto L9;
        if (TextUtils.isEmpty(r105.f497006f) == true) goto L9;
        VFSFile r106 = ay4.d.a().i(r105.f497004d);
    L10:
        if (r106 != null) goto L12;
    L17:
        String r107 = d25.d.f466517d;
        w85.a.C8081a r108 = new w85.a.C8081a();
        r108.f558642d = r100;
        r108.f558640b = r101;
        r108.f558649k = new DownloadRequestInfo.b(r102, r102);
        Pattern r109 = yu5.c.f569228a;
        if (r107 != null) goto L20;
        r107 = "";
    L20:
        r108.f558646h = r107;
        r108.f558647i = d25.d.f466519f;
        r108.f558645g = ((com.bytedance.ee.bear.f) org.koin.java.a.a(com.bytedance.ee.bear.f.class)).d(d25.d.f466520g);
        w85.a r110 = new w85.a(r108);
        w85.b r111 = ((w85.c) org.koin.java.a.a(w85.c.class)).d(r110);
        if (r111 != null) goto L23;
    L24:
        tt5.a.k(this.f516714b, "internalGetDriveImageInputStream() downloadImageFile failed!");
    L25:
        return r111;
    L23:
        if (r111.f558656e == 0) goto L25;
    L12:
        if (r106.exists() == false) goto L17;
        return new w85.b(r106.newInputStream(), r106, r106.length());
    L15:
        e = move-exception;
        tt5.a.e(this.f516714b, "internalGetDriveImageInputStream() FileNotFoundException", e, false);
    L9:
        r106 = null;
        goto L10
    }

    public final WebResourceResponse m(String r100, InputStream r101, Map<String, String> r102) {
        if (r101 != null) goto L14;
    L7:
        if (r101 != null) goto L9;
        tt5.a.k(this.f516714b, "WebResourceResponse input is null.");     // Catch: IOException -> L11
        return null;
    L9:
        tt5.a.k(this.f516714b, "WebResourceResponse input is not available.");     // Catch: IOException -> L11
        return null;
    L14:
    L11:
        tt5.a.d(this.f516714b, "  internalGetImageResponse(): ");
        return null;
    L4:
        if (r101.available() <= 0) goto L7;
        WebResourceResponse r103 = new WebResourceResponse(r100, n25.b.f516700a, r101);     // Catch: IOException -> L11
        c(r102);     // Catch: IOException -> L11
        r103.setResponseHeaders(r102);     // Catch: IOException -> L11
        return r103;
    }

    public final void q(VFSFile r110, Map<String, String> r111, int r112) {
        VFSFile[] r100 = r110.listFiles();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.length <= 0) goto L31;
        int r101 = r100.length;
        int r102 = 0;
    L7:
        if (r102 >= r101) goto L32;
        VFSFile r103 = r100[r102];
        if (r103.getName() != null) goto L11;
    L25:
        iu5.d.a(this.f516714b, new RuntimeException("name = " + r103.getName() + " path = " + r103.getAbsolutePath() + " file = " + r103.toString() + " dir = " + r110.toString()));
    L26:
        r102 = r102 + 1;
        goto L7
    L11:
        if (r103.getAbsolutePath() == null) goto L25;
        if (ay4.d.a().i(r103.getAbsolutePath()).isFile() == false) goto L24;
        String r104 = r103.getAbsolutePath();
        if (r104.endsWith(this.f516715c) == false) goto L20;
        boolean r105 = true;
        if (TextUtils.equals(r104.substring(r104.lastIndexOf(HTTP.URL_DEFAULT) + 1), this.f516715c) == false) goto L20;
    L21:
        if (r105 == false) goto L23;
        ((HashMap) r111).put(this.f516715c, r104);
        goto L24
    L23:
        ((HashMap) r111).put(r104.substring(r112), r104);
    L20:
        r105 = false;
    L24:
        q(r103, r111, r112);
        goto L26
    L32:
        return;
    }

    public final InputStream r(String r100, InputStream r101, InputStream r102) throws IOException {
        if (r102 == null) goto L13;
        tt5.a.b(this.f516714b, "sourceMap exist fileName=" + r100);
        ByteArrayOutputStream r103 = new ByteArrayOutputStream();
        byte[] r104 = new byte[1024];     // Catch: Throwable -> L10
    L5:
        int r105 = r102.read(r104);     // Catch: Throwable -> L10
        if (r105 == (-1)) goto L8;
        r103.write(r104, 0, r105);     // Catch: Throwable -> L10
        goto L5
    L8:
        String r106 = Base64.encodeToString(r103.toByteArray(), 2);     // Catch: Throwable -> L10
        StringBuilder r107 = new StringBuilder();     // Catch: Throwable -> L10
        r107.append('\n');     // Catch: Throwable -> L10
        r107.append("//# sourceMappingURL=data:application/json;charset=utf-8;base64,");     // Catch: Throwable -> L10
        r107.append(r106);     // Catch: Throwable -> L10
        SequenceInputStream r108 = new SequenceInputStream(r101, new ByteArrayInputStream(new String(r107).getBytes(StandardCharsets.UTF_8)));     // Catch: Throwable -> L10
        r102.close();
        r103.close();
        return r108;
    L10:
        th = move-exception;
        r102.close();
        r103.close();
        throw th;
    L13:
        return r101;
    }

    public final WebResourceResponse t(String r210, String r211, Map<String, String> r212) {
        if ("options".equalsIgnoreCase(r211) == false) goto L5;
        return null;
    L5:
        long r100 = SystemClock.uptimeMillis();
    L126:
        e = e;
        boolean r110 = false;
    L128:
        tt5.a.e(this.f516714b, "internalGetSubResponseStream ", e, r110);
    L129:
        String r101 = this.f516714b;
        if (r210 != null) goto L132;
    L136:
        String r102 = "";
    L137:
        tt5.a.h(r101, "internalGetSubResponseStream... not InterceptRequest ".concat(r102));
        return null;
    L132:
        if (r210.endsWith(".js") == false) goto L134;
    L135:
        r102 = r210;
        goto L137
    L134:
        if (r210.endsWith(".css") == false) goto L136;
    L8:
        if (TextUtils.equals(r210, this.f516731s) == false) goto L139;
        tt5.a.h(this.f516714b, "shouldInterceptRequest()... mPreloadUrl = " + this.f516731s);     // Catch: Exception -> L126
        u();     // Catch: Exception -> L126
        B = B + 1;     // Catch: Exception -> L126
        C++;     // Catch: Exception -> L126
        if (this.f516730r == true) goto L12;
    L21:
        tt5.a.d(this.f516714b, "shouldInterceptRequest()... mResponseContent initSuccess = " + this.f516730r + " mResponseContent: " + this.f516717e);     // Catch: Exception -> L126
    L22:
        return null;
    L12:
        if (TextUtils.isEmpty(this.f516717e) == true) goto L21;
        String r103 = this.f516717e;     // Catch: Exception -> L126
        String r104 = n25.b.f516700a;     // Catch: Exception -> L126
        ByteArrayInputStream r105 = new ByteArrayInputStream(r103.getBytes(r104));     // Catch: Exception -> L126
        if (r105.available() <= 0) goto L20;
        tt5.a.h(this.f516714b, "shouldInterceptRequest() mResponseContent replace html... ");     // Catch: Exception -> L126
        h r106 = new h(r210, d25.d.c(r210), r104, r105);     // Catch: Exception -> L126
        r212.put("codecache-optimize", "true");     // Catch: Exception -> L126
        r212.put("memcache-optimize", "true");     // Catch: Exception -> L126
        r212.put("readonce-optimize", "true");     // Catch: Exception -> L126
        if (r212.containsKey("ttweb_adblock") == false) goto L18;
        r212.remove("ttweb_adblock");     // Catch: Exception -> L126
    L18:
        r106.setResponseHeaders(r212);     // Catch: Exception -> L126
        this.f516734v = true;     // Catch: Exception -> L126
        this.f516724l.j("load_template_gap", ILoadStallMonitor.START_TIME, String.valueOf(System.currentTimeMillis()));     // Catch: Exception -> L126
        return r106;
    L20:
        tt5.a.d(this.f516714b, "shouldInterceptRequest()... mResponseContent inputstream is invalid end");     // Catch: Exception -> L126
        goto L22
    L139:
        if (g5.c(r210) == false) goto L41;
        String r107 = d25.d.f466520g;     // Catch: Exception -> L126
        Pair<Boolean, Integer> r108 = this.f516729q.a(r210);     // Catch: Exception -> L126
        boolean r109 = ((Boolean) r108.first).booleanValue();     // Catch: Exception -> L126
        if (r109 == false) goto L28;
        DownloadRequestInfo.DownloadType r111 = DownloadRequestInfo.DownloadType.COVER;     // Catch: Exception -> L126
    L29:
        if (r109 == false) goto L31;
        int r112 = ((Integer) r108.second).intValue();     // Catch: Exception -> L126
    L32:
        w85.b r113 = l(r210, r111, r112);     // Catch: Exception -> L126
        if (r113 == null) goto L39;
        WebResourceResponse r114 = m("image/*", r113.f558652a, r212);     // Catch: Exception -> L126
        if (r114 == null) goto L37;
        e25.a.b(r113.f558654c, r100, r113.f558655d, r113.f558656e, "customSchemeDrive", r112, r107);     // Catch: Exception -> L126
    L38:
        return r114;
    L37:
        e25.a.a(r100, r113.f558656e, "customSchemeDrive", r112, r107, "null_web_response");     // Catch: Exception -> L126
        goto L38
    L39:
        e25.a.a(r100, -1, "customSchemeDrive", r112, r107, "failure");     // Catch: Exception -> L126
    L50:
        int r115 = 0;
    L123:
        if (TextUtils.equals(r210, this.f516731s) == true) goto L129;
        B = r115;     // Catch: Exception -> L57
        goto L129
    L31:
        r112 = DriveCompressCheckerV2.CoverSize.ORIGINAL.size;     // Catch: Exception -> L126
        goto L32
    L28:
        r111 = DownloadRequestInfo.DownloadType.IMG;     // Catch: Exception -> L126
        goto L29
    L41:
        if (g5.b(r210) == true) goto L43;
        r115 = 0;
        r110 = false;
        r115 = 0;
        r115 = 0;
        r115 = 0;
        r115 = 0;
        if (g5.d(r210) == false) goto L60;
        int r116 = j.f516741a;     // Catch: Exception -> L57
        return m(d25.d.c(r210), j.a(this.f516720h, r210), r212);
    L60:
        if (q1.a(r210) == false) goto L70;
        if (this.f516719g == false) goto L68;
        if (p(UriProtector.parse(r210).getHost()) == false) goto L123;
        return f(r210, r212, r100, n(r210, r212), d25.d.f466520g);
    L68:
        return f(r210, r212, r100, n(r210, r212), d25.d.f466520g);
    L70:
        if (TextUtils.isEmpty(r210) == false) goto L72;
    L81:
        boolean r117 = false;
    L82:
        if (r117 == false) goto L86;
        return m(r210, j(r210), r212);
    L86:
        if (TextUtils.isEmpty(r210) == true) goto L123;
        String r118 = l25.b.a(UriProtector.parse(r210).getPath());     // Catch: Exception -> L57
        if (TextUtils.isEmpty(r118) == true) goto L123;
        InputStream r119 = e(r118);     // Catch: Exception -> L57
        if (r119 != null) goto L92;
        l25.a r120 = this.f516728p;     // Catch: Exception -> L57
        if (r120 == null) goto L123;
        if (r120.b(r210) == false) goto L123;
        WebResourceResponse r121 = this.f516728p.a(r210);     // Catch: Exception -> L57
        if (r121 == null) goto L121;
        c(r212);     // Catch: Exception -> L57
        r212.put("Access-Control-Allow-Headers", "accept, authorization, Content-Type");     // Catch: Exception -> L57
        r121.setResponseHeaders(r212);     // Catch: Exception -> L57
    L121:
        return r121;
    L92:
        if (com.bytedance.ee.bear.document.reloadwebview.a.f221273j == false) goto L95;
        com.bytedance.ee.bear.document.reloadwebview.a.f();     // Catch: Exception -> L57
    L95:
        if (this.f516733u == false) goto L97;
        r119 = r(r118, r119, e(r118 + ".map"));     // Catch: Exception -> L57
    L97:
        h r122 = new h(r210, d25.d.c(r210), n25.b.f516700a, r119);     // Catch: Exception -> L57
    L108:
        th = move-exception;
        tt5.a.e(this.f516714b, "ttwebview-response-update-time ", th, false);     // Catch: Exception -> L57
    L113:
        return r122;
    L99:
        if (TextUtils.isEmpty(this.f516718f.get(r118)) == true) goto L113;
        VFSFile r123 = ay4.d.a().i(this.f516718f.get(r118));     // Catch: Throwable -> L108
        if (r123.exists() == false) goto L113;
        r212.put("x-ttwebview-response-update-time", String.valueOf(r123.lastModified()));     // Catch: Throwable -> L108
        if (this.f516735w == false) goto L106;
        c(r212);     // Catch: Throwable -> L108
    L106:
        if (r212.containsKey("ttweb_adblock") == false) goto L110;
        r212.remove("ttweb_adblock");     // Catch: Throwable -> L108
    L110:
        r122.setResponseHeaders(r212);     // Catch: Throwable -> L108
    L72:
        if (r210.contains("/obj/creation-image-system/") == false) goto L81;
        int r124 = r210.lastIndexOf(HTTP.URL_DEFAULT);     // Catch: Exception -> L57
        if (r124 < 0) goto L78;
        int r125 = r124 + 1;     // Catch: Exception -> L57
        if (r125 > r210.length()) goto L78;
        boolean r126 = r210.substring(r125).startsWith("cover-");     // Catch: Exception -> L57
    L79:
        if (r126 == false) goto L81;
        r117 = true;
    L78:
        r126 = false;
        goto L79
    L43:
        if (this.f516719g == false) goto L52;
        if (p(UriProtector.parse(r210).getHost()) == false) goto L50;
        return f(r210, r212, r100, k(r210, r212), d25.d.f466520g);
    L52:
        return f(r210, r212, r100, k(r210, r212), d25.d.f466520g);
    L57:
        e = e;
        goto L128
    }

    public g(Context r100, String r110, boolean r111, String r112) {
        this.f516714b = "OfflineResourceInterceptor2";
        this.f516715c = "mobile_index.html";
        com.bytedance.ee.bear.appsetting.c r101 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        boolean r102 = r101.g("ccm.mobile.res.domain_check_enable");
        this.f516719g = r102;
        this.f516733u = false;
        this.f516734v = false;
        this.f516735w = r101.g("ccm.mobile.slides_enabled");
        if (TextUtils.isEmpty(r110) == true) goto L5;
        this.f516714b = "OfflineResourceInterceptor2_" + r110;
    L5:
        this.f516715c = r112;
        this.f516720h = r100;
        this.f516721i = (h0) org.koin.java.a.a(h0.class);
        this.f516722j = (NetService) org.koin.java.a.a(NetService.class);
        this.f516724l = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        this.f516723k = (i0) org.koin.java.a.a(i0.class);
        b0 r113 = (b0) org.koin.java.a.a(b0.class);
        this.f516725m = r113;
        this.f516718f = new ConcurrentHashMap();
        ml5.b r114 = new ml5.b("debug_config");
        this.f516727o = r114;
        this.f516729q = new DriveCompressCheckerV2(r100);
        ((Integer) r101.d("drive_rust_cover_size", 1280)).intValue();
        if (r111 == false) goto L8;
        String r103 = "aWZyYW1lSnNiQ2hlY2s=";
    L9:
        this.f516713a = r103;
        this.f516733u = r114.f514368a.getBoolean("offline_res_enable_source_map", false);
        this.f516736x = new s1(com.bytedance.ee.bear.contract.j.a.f217090a, (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), (b0) org.koin.java.a.a(b0.class), (com.bytedance.ee.bear.contract.f) org.koin.java.a.a(com.bytedance.ee.bear.contract.f.class), ((b0) org.koin.java.a.a(b0.class)).e());
        if (D != (-1)) goto L17;
        DocOpenConfig.DocsWebviewConfig r104 = (DocOpenConfig.DocsWebviewConfig) r101.c("docs_webview_config", DocOpenConfig.DocsWebviewConfig.class, new DocOpenConfig.DocsWebviewConfig());
        if (r104 == null) goto L16;
        int r105 = r104.resetWKProcessPoolContinuousFailCount;
        if (r105 <= 0) goto L16;
        D = r105;
    L16:
        D = E;
    L17:
        String r106 = r113.w();
        this.f516716d = r106;
        tt5.a.h(this.f516714b, "HostDomain is: " + r106 + "  isDomainMatchFG: " + r102);
        return;
    L8:
        r103 = UUID.randomUUID().toString();
        goto L9
    }

    public final VFSPath b(String r100, String r101, String r102, Map<String, String> r103) {
        i(r103);     // Catch: Exception -> L12
        VFSPath r104 = ay4.d.a().t(Glide.with(this.f516720h).load(new BearGlideUrl(r101, this.f516726n)).downloadOnly(Integer.MIN_VALUE, Integer.MIN_VALUE).get());     // Catch: Exception -> L12
        if (com.bytedance.ee.util.io.b.c(r104) == false) goto L10;
        q r105 = new q();     // Catch: Exception -> L12
        r105.f497001a = r104.getName() + "_" + System.currentTimeMillis();     // Catch: Exception -> L12
        String r106 = d25.d.f466517d;     // Catch: Exception -> L12
        if (r106 == null) goto L7;
        r105.f497002b = r106;     // Catch: Exception -> L12
        r105.f497003c = r106;     // Catch: Exception -> L12
    L8:
        r105.f497004d = k25.e0.D(r104.getRealPath());     // Catch: Exception -> L12
        r105.f497008h = Long.valueOf(FileUtils.v(r104));     // Catch: Exception -> L12
        r105.f497007g = r102;     // Catch: Exception -> L12
        k25.e0.m().u(r105);     // Catch: Exception -> L12
        return r104;
    L7:
        r105.f497002b = r100;     // Catch: Exception -> L12
        r105.f497003c = r100;     // Catch: Exception -> L12
        goto L8
    L10:
        tt5.a.k(this.f516714b, "internalGetNetImageStream isImage not: ");     // Catch: Exception -> L12
        return null;
    L12:
        e = move-exception;
        tt5.a.e(this.f516714b, "internalGetNetImageStream: downloadImage failed", e, false);
        return null;
    }

    public final Pair<InputStream, Pair<String, Long>> o(String r100, String r101, String r102, Map<String, String> r103) {
        k25.e0 r104 = k25.e0.m();     // Catch: IOException -> L24
        r104.getClass();     // Catch: IOException -> L24
        q r105 = ((j25.p) r104.q().d()).g(r102);     // Catch: Exception -> L6
        k25.e0.a(r105);     // Catch: Exception -> L6
    L8:
        tt5.a.h(this.f516714b, "internalGetNetImageStream()... end url = , path =" + r105);     // Catch: IOException -> L24
        if (r105 == null) goto L23;
        if (TextUtils.isEmpty(r105.f497004d) == true) goto L23;
        int r106 = j.f516741a;     // Catch: IOException -> L24
        Pair r107 = j.b(this.f516720h, r105.f497004d, r105.f497005e);     // Catch: IOException -> L24
        InputStream r108 = (InputStream) r107.first;     // Catch: IOException -> L24
        if (r108 != null) goto L15;
    L18:
        if (r108 == null) goto L20;
        r108.close();     // Catch: IOException -> L24
    L20:
        tt5.a.h(this.f516714b, "internalGetNetImageStream()... local file not valid, re-download it, path =" + r105);     // Catch: IOException -> L24
        return g(b(r100, r101, r102, r103));
    L15:
        if (r108.available() <= 0) goto L18;
        return new Pair(r108, new Pair("1", (Long) r107.second));
    L23:
        return g(b(r100, r101, r102, r103));
    L6:
        e = move-exception;
        iu5.d.c(e);     // Catch: IOException -> L24
        r105 = new q();     // Catch: IOException -> L24
    L24:
        tt5.a.d(this.f516714b, "IOException e");
        return new Pair(null, new Pair("0", -1L));
    }

    public final WebResourceResponse f(String r210, Map<String, String> r211, long r212, Pair<InputStream, Pair<String, Long>> r213, String r214) {
        InputStream r100 = (InputStream) r213.first;
        if (r100 == null) goto L10;
        WebResourceResponse r101 = m(d25.d.c(r210), r100, r211);
        Pair r102 = (Pair) r213.second;
        if (r102 == null) goto L8;
        if (r101 == null) goto L8;
        e25.a.b((String) r102.first, r212, ((Long) r102.second).longValue(), 0, "customSchemeDocs", -1, r214);
    L9:
        return r101;
    L8:
        e25.a.a(r212, -1, "customSchemeDocs", -1, r214, "null_web_response");
        goto L9
    L10:
        e25.a.a(r212, -1, "customSchemeDocs", -1, r214, "failure");
        return null;
    }
}
