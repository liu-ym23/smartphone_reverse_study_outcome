package n25;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import android.webkit.WebResourceResponse;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.LazyHeaders;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.doc.docupgrade.DocRedirectToDocxPlugin;
import com.bytedance.ee.bear.doc.resupdate.e0;
import com.bytedance.ee.bear.document.DocOpenConfig;
import com.bytedance.ee.bear.document.g5;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
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
import java.io.File;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class g {
    public static final boolean A = false;
    public static int B;
    public static int C;
    public static int D;
    public static final int E = 0;
    public static volatile String y;
    public static volatile String z;
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public String e;
    public final ConcurrentHashMap<String, String> f;
    public final boolean g;
    public final Context h;
    public final h0 i;
    public final NetService j;
    public final i0 k;
    public final com.bytedance.ee.bear.contract.d l;
    public final b0 m;
    public LazyHeaders n;
    public final ml5.b o;
    public l25.a p;
    public final DriveCompressCheckerV2 q;
    public boolean r;
    public String s;
    public boolean t;
    public final boolean u;
    public volatile boolean v;
    public final boolean w;
    public final s1 x;

    public class a implements com.bytedance.ee.bear.contract.b {
        public a() {
        }

        @Override // com.bytedance.ee.bear.contract.b
        public final void a(AccountService$Account r1) {
            g.y = null;
            g.z = null;
        }
    }

    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ZoomLevel6.values().length];
            a = r0;
            r0[ZoomLevel6.SMALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            a[ZoomLevel6.LARGE1.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            a[ZoomLevel6.LARGE2.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            a[ZoomLevel6.LARGE3.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            a[ZoomLevel6.LARGE4.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public final String d() {
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L8
        String[] r2 = e.a;     // Catch: Throwable -> L8
        int r3 = r2.length;     // Catch: Throwable -> L8
        int r4 = 0;
    L4:
        if (r4 >= r3) goto L6;
        String r5 = r2[r4];     // Catch: Throwable -> L8
        r1.put(r5, com.bytedance.ee.bear.appsetting.c.a.a.g(r5));     // Catch: Throwable -> L8
        r4 = r4 + 1;     // Catch: Throwable -> L8
        goto L4
    L6:
        tt5.a.h(this.b, "getFG_RORM size is " + e.a.length);     // Catch: Throwable -> L8
        return r1.toString();
    L8:
        th = move-exception;
        tt5.a.f(this.b, th, false);
        return "{}";
    }

    static {
        boolean r0 = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.inject_fg_enable");
        A = r0;
        if (r0 == false) goto L5;
        ((h0) org.koin.java.a.a(h0.class)).Pe(new a());
    L5:
        B = 0;
        C = 0;
        D = -1;
        E = 3;
    }

    public final synchronized void a() {
        monitor-enter(this);
        e0 r1 = ((com.bytedance.ee.bear.doc.resupdate.g) org.koin.java.a.a(com.bytedance.ee.bear.doc.resupdate.g.class)).getResource();     // Catch: Throwable -> L24
        VFSFile r3 = r1.a;     // Catch: Throwable -> L24
        String r2 = r1.b;     // Catch: Throwable -> L24
        if (r3 != null) goto L7;
    L9:
        boolean r4 = false;
    L10:
        i r5 = new i(r3, r2, r4);     // Catch: Throwable -> L24
        if (r3 == null) goto L13;
        VFSFile r6 = ay4.d.a().B(r3);     // Catch: Throwable -> L24
    L14:
        this.t = r4;     // Catch: Throwable -> L24
        this.p = new l25.a(this.j, this.l, r5);     // Catch: Throwable -> L24
        ow4.a.a = r2;     // Catch: Throwable -> L24
        boolean r7 = h(r6);     // Catch: Throwable -> L24
        this.r = r7;     // Catch: Throwable -> L24
        if (r7 == false) goto L18;
        if (r6 == null) goto L18;
        ((com.bytedance.ee.bear.rn.j) org.koin.java.a.a(com.bytedance.ee.bear.rn.j.class)).n(r6.getVfsPath());     // Catch: Throwable -> L24
    L19:
        this.e = d25.d.b(e(this.c));     // Catch: Throwable -> L24
        tt5.a.h(this.b, "internalCheckOfflineRes() initSuccess = " + this.r + ", resource = " + r5);     // Catch: Throwable -> L24
        if (TextUtils.isEmpty(this.e) == true) goto L22;
        s();     // Catch: Throwable -> L24
    L22:
        monitor-exit(this);
        return;
    L18:
        tt5.a.d(this.b, "checkOfflineRes(): init fail");     // Catch: Throwable -> L24
        goto L19
    L13:
        r6 = null;
        goto L14
    L7:
        if (r3.getAbsolutePath().contains("_sim") == false) goto L9;
        r4 = true;
    L24:
        th = move-exception;
        throw th;
    }

    public void s() {
        String r2 = "lf-package-cn.feishucdn.com/obj/feishu-static";
        AccountService$Account r0 = this.i.U5();
        String r3 = "";
        if (r0 == null) goto L11;
        String r4 = this.e;
        String r5 = r0.uid;
        if (r5 != null) goto L7;
        r5 = "";
    L7:
        String r6 = r4.replace("{{ user_id }}", r5);
        this.e = r6;
        String r1 = r0.tenantId;
        if (r1 != null) goto L10;
        r1 = "";
    L10:
        this.e = r6.replace("{{ tenant_id }}", r1);
    L11:
        String r7 = ou5.b.a(this.k.c().getCountry(), this.k.a());
        JSONArray r8 = new JSONArray(((s45.c) org.koin.java.a.a(s45.c.class)).Ba("overload_static_domain_new"));     // Catch: JSONException -> L18
        if (r8.length() <= 0) goto L16;
        String r9 = r8.optString(0, "");     // Catch: JSONException -> L18
    L17:
        String r10 = r9;
    L20:
        String r11 = this.e.replace("{{lang_cdn}}", "//" + r10 + "/eesz/resource/bear/lang/" + r7 + ".js");
        this.e = r11;
        this.e = r11.replace("{{ language }}", ou5.b.c(this.k.c().getCountry(), this.k.a()));
        com.bytedance.ee.bear.appsetting.c r12 = com.bytedance.ee.bear.appsetting.c.a.a;
        this.e = this.e.replace("\"{{ app_config }}\"", (String) r12.d("app_config", "{}"));
        if (r12.g("ccm.mobile.domain_geo_replace_enable") == true) goto L26;
        String r13 = DocOpenConfig.c();
        if (TextUtils.equals(r13, "{}") == false) goto L27;
        tt5.a.d(this.b, "replaceTemplateInfos()...domainCharacteristic is empty");
        iu5.d.a(this.b, new RuntimeException("domainCharacteristic is empty"));
        return;
    L27:
        this.e = this.e.replace("\"{{ domain_characteristic_config }}\"", r13);
        tt5.a.h(this.b, "replaceTemplateInfos()...lan = " + r7 + ", domainCharacteristicConfig = " + r13);
        this.e = this.e.replace("\"{{ app_debug_config }}\"", "{\"isDebug\":" + this.o.a("isDebug", Boolean.FALSE) + "}");
        if (this.j.w6() == false) goto L30;
        String r14 = "staging";
    L31:
        String r16 = this.e.replace("{{navigator_env}}", r14);
        this.e = r16;
        this.e = r16.replace("{{navigator_path_prefix}}", p.a().T0());
        this.e = this.e.replace("{{navigator_api_prefix}}", "https://" + p.u + "/" + p.a().u9());
        String r17 = "False";
        if (this.m.b() == false) goto L34;
        this.e = this.e.replace("{{ anonymous_access }}", "True");
    L35:
        String r18 = this.e;
        String r19 = n25.b.a;
        Application r110 = LarkContext.getApplication();
        if (r110 != null) goto L38;
    L40:
        boolean r111 = false;
    L41:
        if (r111 == false) goto L43;
        CharSequence r112 = "True";
    L44:
        String r20 = r18.replace("{{ is_ka }}", r112);
        this.e = r20;
        Application r113 = LarkContext.getApplication();
        if (r113 != null) goto L47;
    L49:
        boolean r114 = false;
    L50:
        if (r114 == false) goto L52;
        r3 = PackageChannelManager.getBuildPackageChannel(r113);
    L52:
        this.e = r20.replace("{{ ka_channel }}", r3);
        String[] r21 = n25.b.b;
        int r22 = r21.length;
        int r115 = 0;
    L53:
        if (r115 >= r22) goto L55;
        this.e = this.e.replace(r21[r115], "null");
        r115 = r115 + 1;
        goto L53
    L55:
        this.e = this.e.replace("{{ enable_et_test }}", ((Boolean) this.o.a("enable_frontend_et_test", Boolean.FALSE)).toString());
        String r23 = ((m) org.koin.java.a.a(m.class)).getString();
        if (TextUtils.isEmpty(r23) == false) goto L58;
        r23 = "{}";
    L58:
        this.e = this.e.replace("\"{{ globalKaConfig }}\"", r23);
        int r24 = b.a[zz7.b.d().ordinal()];
        if (r24 != 1) goto L61;
        String r26 = "S";
    L74:
        tt5.a.h(this.b, "currentBaseFontSize = ".concat(r26));
        String r27 = this.e.replace("\"{{ device_info }}\"", String.format("{\"baseFontSize\": \"%s\"}", new Object[]{r26}));
        this.e = r27;
        if (h18.f.a(eu5.b.a) == false) goto L77;
        String r28 = "\"dark\"";
    L78:
        this.e = r27.replace("\"{{ theme }}\"", r28);
        if (com.bytedance.ee.bear.appsetting.c.a.a.i("ccm.theme.mobile_darkmode_enable", false) == false) goto L81;
        this.e = this.e.replace("{{ darkmode_enable }}", "True");
    L82:
        String r29 = this.e;
        if (CipherManager.d() != 1) goto L85;
        r17 = "True";
    L85:
        String r30 = r29.replace("{{ disk_crypto_enable }}", r17);
        this.e = r30;
        String r31 = r30.replace("{{ comment_disable_rn }}", "True");
        this.e = r31;
        if (A == true) goto L88;
        this.e = r31.replace("\"{{ mobile_fg_dictionary }}\"", d());
    L112:
        String r32 = this.e;
        if (z == null) goto L115;
        tt5.a.h(this.b, "sAbTestMap is not null");
        String r33 = z;
    L138:
        this.e = r32.replace("\"{{ mobile_ab_test_dictionary }}\"", r33);
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.dynamic_cdn_domain_enable") == false) goto L142;
        r2 = r10;
    L142:
        l25.a r34 = this.p;
        r34.getClass();
        if (r2.startsWith("http://") == false) goto L145;
    L147:
        String r36 = r2;
    L181:
        r34.e = new URL(r36).getHost();     // Catch: Exception -> L150
    L152:
        String r37 = this.e.replace("{{cdn_host}}", "//".concat(r2));
        this.e = r37;
        JSONObject r38 = new JSONObject();
        com.bytedance.ee.bear.appsetting.c r39 = com.bytedance.ee.bear.appsetting.c.a.a;     // Catch: Exception -> L177
        if (r39.g("ccm.mobile.enable_web_setting_dynamic") == false) goto L175;
        JSONObject r40 = new JSONObject((String) r39.d("ccm_web_template_setting_config", "{}"));     // Catch: Exception -> L177
        Iterator<String> r41 = r40.keys();     // Catch: Exception -> L177
    L157:
        if (r41.hasNext() == false) goto L179;
        String r42 = r41.next();     // Catch: Exception -> L177
        Object r43 = r40.get(r42);     // Catch: Exception -> L177
        if ((r43 instanceof JSONArray) == true) goto L160;
        tt5.a.d(this.b, "replaceTemplateInfos()... value is not JSONArray");     // Catch: Exception -> L177
        goto L157
    L160:
        JSONArray r44 = (JSONArray) r43;     // Catch: Exception -> L177
        if (r44.length() == 0) goto L162;
        JSONObject r46 = new JSONObject();     // Catch: Exception -> L177
        int r47 = 0;
    L165:
        if (r47 >= r44.length()) goto L173;
        Object r116 = r44.get(r47);     // Catch: Exception -> L177
        if ((r116 instanceof String) == false) goto L172;
        String r117 = (String) r116;     // Catch: Exception -> L177
        Object r118 = new JSONObject((String) com.bytedance.ee.bear.appsetting.c.a.a.d(r42, "{}")).opt(r117);     // Catch: Exception -> L177
        if (r118 == null) goto L172;
        r46.put(r117, r118);     // Catch: Exception -> L177
    L172:
        r47 = r47 + 1;     // Catch: Exception -> L177
        goto L165
    L173:
        r38.put(r42, r46);     // Catch: Exception -> L177
        goto L157
    L162:
        r38.put(r42, new JSONObject((String) com.bytedance.ee.bear.appsetting.c.a.a.d(r42, "{}")));     // Catch: Exception -> L177
    L179:
        this.e = r37.replace("\"{{ settings_config }}\"", r38.toString());
        return;
    L175:
        JSONObject r48 = new JSONObject();     // Catch: Exception -> L177
        r48.put("reaction_bucket_prex", new JSONArray(jcb.b.c().b("reaction_bucket_prex")));     // Catch: Exception -> L177
        r48.put("suite_security_link", new JSONArray(jcb.b.c().b("suite_security_link")));     // Catch: Exception -> L177
        JSONObject r49 = new JSONObject();     // Catch: Exception -> L177
        r49.put("sec_link_whitelist", new JSONObject((String) r39.d("domain_manage_policy", "{}")).get("sec_link_whitelist"));     // Catch: Exception -> L177
        r38.put("biz_domain_config", r48);     // Catch: Exception -> L177
        r38.put("domain_manage_policy", r49);     // Catch: Exception -> L177
    L177:
        e = move-exception;
        tt5.a.e(this.b, "replaceTemplateInfos()... ", e, false);
    L150:
        e = move-exception;
        r34.e = r36;
        tt5.a.f("RemoteResourceLoader", e, false);
        goto L152
    L145:
        if (r2.startsWith("https://") == true) goto L147;
        r36 = "https://".concat(r2);
        goto L181
    L115:
        String r50 = this.f.get("resource_root_path");
        if (r50 != null) goto L118;
        tt5.a.h(this.b, "getAbTestValue, resource_root_path is null");
    L137:
        r33 = "{}";
        goto L138
    L118:
        tt5.a.h(this.b, "getAbTestValue from file");
        JSONObject r119 = new JSONObject();
        Map<String, iua.a<?>> r120 = o25.a.b();     // Catch: Throwable -> L135
        String[] r51 = FileUtils.E(ay4.d.a().z(r50).subPath("mobileABTestKeys.txt")).split(",");     // Catch: Throwable -> L135
        tt5.a.h(this.b, "getAbTestValue keys size is " + r51.length);     // Catch: Throwable -> L135
        int r52 = r51.length;     // Catch: Throwable -> L135
        int r53 = 0;
    L120:
        if (r53 >= r52) goto L133;
        String r121 = r51[r53];     // Catch: Throwable -> L135
        if (TextUtils.isEmpty(r121) == true) goto L131;
        HashMap r122 = (HashMap) r120;     // Catch: Throwable -> L135
        if (r122.containsKey(r121) == false) goto L131;
        if (r122.get(r121) == null) goto L131;
        String r123 = ((xm4.a.a) org.koin.java.a.a(xm4.a.a.class)).b(((iua.a) r122.get(r121)).getClass().getName());     // Catch: Throwable -> L135
        if (TextUtils.isEmpty(r123) == true) goto L130;
        r119.put(r121, r123);     // Catch: Throwable -> L135
    L132:
        r53 = r53 + 1;     // Catch: Throwable -> L135
        goto L120
    L130:
        tt5.a.k(this.b, "getAbTestValue but value is null");     // Catch: Throwable -> L135
    L131:
        tt5.a.k(this.b, "getAbTestValue key is " + r121 + " has registered: " + ((HashMap) r120).containsKey(r121));     // Catch: Throwable -> L135
        goto L132
    L133:
        z = r119.toString();     // Catch: Throwable -> L135
        tt5.a.h(this.b, "getAbTestValue success");     // Catch: Throwable -> L135
        r33 = z;     // Catch: Throwable -> L135
    L135:
        th = move-exception;
        tt5.a.e(this.b, "getAbTestValue", th, false);
        goto L137
    L88:
        if (y == null) goto L90;
        tt5.a.h(this.b, "sFgMap is not null");
        String r54 = y;
    L106:
        String r56 = this.e;
        if (r54 != null) goto L110;
        r54 = "{}";
    L110:
        this.e = r56.replace("\"{{ mobile_fg_dictionary }}\"", r54);
        goto L112
    L90:
        String r57 = this.f.get("resource_root_path");
        if (r57 != null) goto L93;
        tt5.a.h(this.b, "resource_root_path is null");
        r54 = d();
        goto L106
    L93:
        tt5.a.h(this.b, "getFGValueV2 from file");
        JSONObject r124 = new JSONObject();
        String[] r58 = FileUtils.E(ay4.d.a().z(r57).subPath("featureGatingKeys.txt")).split(",");     // Catch: Throwable -> L104
        tt5.a.h(this.b, "keys size is " + r58.length);     // Catch: Throwable -> L104
        int r59 = r58.length;     // Catch: Throwable -> L104
        int r125 = 0;
    L95:
        if (r125 >= r59) goto L102;
        String r126 = r58[r125];     // Catch: Throwable -> L104
        if (TextUtils.isEmpty(r126) == true) goto L101;
        if (com.bytedance.ee.bear.appsetting.c.a.a.g(r126) == false) goto L101;
        r124.put(r126, true);     // Catch: Throwable -> L104
    L101:
        r125 = r125 + 1;     // Catch: Throwable -> L104
        goto L95
    L102:
        y = r124.toString();     // Catch: Throwable -> L104
        tt5.a.h(this.b, "getFGValueV2 success");     // Catch: Throwable -> L104
        r54 = r124.toString();     // Catch: Throwable -> L104
    L104:
        th = move-exception;
        tt5.a.f(this.b, th, false);
        r54 = d();
        goto L106
    L81:
        this.e = this.e.replace("{{ darkmode_enable }}", "False");
        goto L82
    L77:
        r28 = "\"light\"";
        goto L78
    L61:
        if (r24 != 2) goto L63;
        r26 = "L";
        goto L74
    L63:
        if (r24 != 3) goto L65;
        r26 = "XL";
        goto L74
    L65:
        if (r24 != 4) goto L67;
        r26 = "2XL";
        goto L74
    L67:
        if (r24 == 5) goto L69;
        r26 = "M";
        goto L74
    L69:
        r26 = "3XL";
        goto L74
    L47:
        if (PackageChannelManager.isKABuildPackage(r113) == false) goto L49;
        r114 = true;
        goto L50
    L43:
        r112 = "False";
        goto L44
    L38:
        if (PackageChannelManager.isKABuildPackage(r110) == false) goto L40;
        r111 = true;
        goto L41
    L34:
        this.e = this.e.replace("{{ anonymous_access }}", "False");
        goto L35
    L30:
        r14 = "prod";
        goto L31
    L26:
        r13 = DocOpenConfig.b();
        goto L27
    L16:
        r9 = "lf-package-cn.feishucdn.com/obj/feishu-static";
    L18:
        e = move-exception;
        tt5.a.e(this.b, "getUpdateGifUrl err ", e, false);
        r10 = "lf-package-cn.feishucdn.com/obj/feishu-static";
        goto L20
    }

    public final void u() {
        int r0 = B;
        int r1 = D;
        if (r0 < r1) goto L5;
    L6:
        s1 r2 = this.x;
        int r3 = C;
        HashMap r4 = new HashMap(r2.b.m("docCommonParams"));
        r4.put("responsive", 0);
        r4.put(DocRedirectToDocxPlugin.FROM, 100);
        r4.put("load_blank_dead_count", Integer.valueOf(r0));
        r4.put("load_blank_fail_count", Integer.valueOf(r3));
        r2.b.n("ccm_webview_responsive_state_dev", r4);
        tt5.a.b("DocReport", "reportTopBarClickEvent, params = " + r4);
        return;
    L5:
        if (C >= r1) goto L6;
    }

    public static void c(Map r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.containsKey("Origin") == false) goto L8;
        r3.put("access-control-allow-credentials", "true");
        r3.put("access-control-allow-methods", "POST, GET, OPTIONS, PUT, DELETE");
        r3.put("access-control-allow-origin", (String) r3.get("Origin"));
        return;
    }

    public final InputStream e(String r7) {
        String r3 = this.f.get(r7);
        if (TextUtils.isEmpty(r3) == true) goto L15;
        int r4 = j.a;
        InputStream r5 = (InputStream) j.b(this.h, r3, null).first;
        if (r5 == null) goto L11;
        int r2 = r5.available();     // Catch: Exception -> L13
        if (r2 <= 0) goto L10;
        tt5.a.h(this.b, "getFileStreamByName()... mFileStreamCacheMap fileName = " + r7 + " inputStream size: " + r2);     // Catch: Exception -> L13
        return r5;
    L10:
        tt5.a.h(this.b, "getFileStreamByName()..11.. fileName = " + r7);     // Catch: Exception -> L13
        goto L15
    L11:
        tt5.a.h(this.b, "getFileStreamByName()..22.. fileName = " + r7);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        tt5.a.h(this.b, "getFileStreamByName()..33.. fileName = " + r7 + "   ===== e = " + e);
    L15:
        return null;
    }

    public final Pair<InputStream, Pair<String, Long>> g(VFSPath r8) {
        Pair<InputStream, Pair<String, Long>> r0 = new Pair(null, new Pair(DiagramData$RESULT.FAIL, -1L));
        if (r8 != null) goto L5;
        return r0;
    L5:
        if (r8.toFile().exists() == false) goto L15;
        return new Pair(r8.toFile().newInputStream(), new Pair(DiagramData$RESULT.FAIL, Long.valueOf(r8.toFile().length())));
    L9:
        tt5.a.d(this.b, "File not found");
        return r0;
    L15:
        return r0;
    }

    public final boolean h(VFSFile r3) {
        if (r3 == null) goto L10;
        if (r3.exists() == false) goto L10;
        ConcurrentHashMap<String, String> r0 = this.f;
        if (r0 == null) goto L8;
        r0.clear();
    L8:
        HashMap r1 = new HashMap();
        q(r3, r1, r3.getParentFile().getAbsolutePath().length());
        this.f.putAll(r1);
        this.f.put("resource_root_path", r3.getVfsPath().getAbsolutePath());
    L10:
        return !TextUtils.isEmpty(this.f.get(this.c));
    }

    public final void i(Map<String, String> r5) {
        AccountService$Account r0 = this.i.U5();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.hasLogin() == false) goto L19;
        LazyHeaders.Builder r1 = new LazyHeaders.Builder();
        if (r5 != null) goto L9;
    L14:
        tt5.a.k(this.b, "initHeaders: headers is null");
    L15:
        this.n = r1.build();
        return;
    L9:
        if (r5.size() <= 0) goto L14;
        Iterator<String> r2 = r5.keySet().iterator();
    L12:
        if (r2.hasNext() == false) goto L15;
        String r3 = r2.next();
        r1.addHeader(r3, r5.get(r3));
        goto L12
    }

    public final InputStream j(String r4) {
        q r5 = k25.e0.m().y(r4);
        InputStream r0 = null;
        if (r5 != null) goto L17;
    L15:
        return r0;
    L17:
    L13:
        e = move-exception;
        tt5.a.f(this.b, e, false);
        goto L15
    L5:
        if (TextUtils.isEmpty(r5.d) == true) goto L10;
        VFSFile r6 = ay4.d.a().i(r5.d);     // Catch: Exception -> L13
        if (r6.exists() == false) goto L16;
        r0 = r6.newInputStream();     // Catch: Exception -> L13
    L16:
        goto L15
    L10:
        if (TextUtils.isEmpty(r5.e) == true) goto L16;
        r0 = ContentResolverWrapper.openInputStream(this.h.getContentResolver(), UriProtector.parse(r5.e));     // Catch: Exception -> L13
        goto L16
    }

    public final boolean p(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
    L14:
        return false;
    L5:
        if (TextUtils.isEmpty(this.d) == true) goto L14;
        if (r4.endsWith(this.d) == false) goto L14;
        int r0 = (r4.length() - this.d.length()) - 1;
        if (r0 < 0) goto L14;
        if (r4.charAt(r0) != '.') goto L14;
        return true;
    }

    public final Pair<InputStream, Pair<String, Long>> k(String r3, Map<String, String> r4) {
        String r0 = yu5.c.h(r3);     // Catch: Exception -> L4
        return o(r3, r3, p.a().s0(UriProtector.parse(r0).getPath()), r4);
    L4:
        tt5.a.d(this.b, "internalGetDriveCoverImageStream Exception e");
        return new Pair(null, new Pair(DiagramData$RESULT.FAIL, -1L));
    }

    public final Pair<InputStream, Pair<String, Long>> n(String r10, Map<String, String> r11) {
        com.bytedance.ee.bear.appsetting.c r4 = com.bytedance.ee.bear.appsetting.c.a.a;     // Catch: Exception -> L14
        Application r5 = LarkContext.getApplication();     // Catch: Exception -> L14
        r4.getClass();     // Catch: Exception -> L14
        boolean r6 = ((dn4.a) k.b(((v) k.a(r5, v.class)).c(((com.ss.android.lark.passportc.convention.a) k.a(r5, com.ss.android.lark.passportc.convention.a.class)).b()), dn4.a.class)).a().isEnable("ccm.docx.chart_ssr_mobile");     // Catch: Exception -> L14
        Uri r7 = UriProtector.parse(r10);     // Catch: Exception -> L14
        if (r6 == true) goto L6;
        r10 = yu5.c.h(r10);     // Catch: Exception -> L14
    L6:
        String r8 = r7.getScheme() + "://" + p.u + p.a().s0(UriProtector.parse(r10).getPath());     // Catch: Exception -> L14
        if (r6 == false) goto L13;
        r8 = r8 + "?" + r7.getEncodedQuery();     // Catch: Exception -> L14
        if (TextUtils.equals(UriProtector.getQueryParameter(r7, "notIntercept"), "true") == false) goto L13;
        return new Pair(null, new Pair(DiagramData$RESULT.FAIL, -1L));
    L13:
        return o(r10, r8, r10, r11);
    L14:
        tt5.a.d(this.b, "internalGetNetImageStream Exception e");
        return new Pair(null, new Pair(DiagramData$RESULT.FAIL, -1L));
    }

    public final w85.b l(String r6, DownloadRequestInfo.DownloadType r7, int r8) {
        Uri r0 = UriProtector.parse(r6);
        if (r0 == null) goto L9;
        String r1 = r0.getLastPathSegment();
        q r2 = k25.e0.m().y(r1);
        if (r2 == null) goto L9;
        if (TextUtils.isEmpty(r2.f) == true) goto L9;
        VFSFile r3 = ay4.d.a().i(r2.d);
    L10:
        if (r3 != null) goto L12;
    L17:
        String r4 = d25.d.d;
        w85.a.C0319a r5 = new w85.a.C0319a();
        r5.d = r6;
        r5.b = r7;
        r5.k = new DownloadRequestInfo.b(r8, r8);
        Pattern r9 = yu5.c.a;
        if (r4 != null) goto L20;
        r4 = "";
    L20:
        r5.h = r4;
        r5.i = d25.d.f;
        r5.g = ((com.bytedance.ee.bear.f) org.koin.java.a.a(com.bytedance.ee.bear.f.class)).d(d25.d.g);
        w85.a r10 = new w85.a(r5);
        w85.b r11 = ((w85.c) org.koin.java.a.a(w85.c.class)).d(r10);
        if (r11 != null) goto L23;
    L24:
        tt5.a.k(this.b, "internalGetDriveImageInputStream() downloadImageFile failed!");
    L25:
        return r11;
    L23:
        if (r11.e == 0) goto L25;
    L12:
        if (r3.exists() == false) goto L17;
        return new w85.b(r3.newInputStream(), r3, r3.length());
    L15:
        e = move-exception;
        tt5.a.e(this.b, "internalGetDriveImageInputStream() FileNotFoundException", e, false);
    L9:
        r3 = null;
        goto L10
    }

    public final WebResourceResponse m(String r3, InputStream r4, Map<String, String> r5) {
        if (r4 != null) goto L14;
    L7:
        if (r4 != null) goto L9;
        tt5.a.k(this.b, "WebResourceResponse input is null.");     // Catch: IOException -> L11
        return null;
    L9:
        tt5.a.k(this.b, "WebResourceResponse input is not available.");     // Catch: IOException -> L11
        return null;
    L14:
    L11:
        tt5.a.d(this.b, "  internalGetImageResponse(): ");
        return null;
    L4:
        if (r4.available() <= 0) goto L7;
        WebResourceResponse r0 = new WebResourceResponse(r3, n25.b.a, r4);     // Catch: IOException -> L11
        c(r5);     // Catch: IOException -> L11
        r0.setResponseHeaders(r5);     // Catch: IOException -> L11
        return r0;
    }

    public final void q(VFSFile r10, Map<String, String> r11, int r12) {
        File[] r0 = r10.listFiles();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.length <= 0) goto L31;
        int r1 = r0.length;
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L32;
        File r4 = r0[r3];
        if (r4.getName() != null) goto L11;
    L25:
        iu5.d.a(this.b, new RuntimeException("name = " + r4.getName() + " path = " + r4.getAbsolutePath() + " file = " + r4.toString() + " dir = " + r10.toString()));
    L26:
        r3 = r3 + 1;
        goto L7
    L11:
        if (r4.getAbsolutePath() == null) goto L25;
        if (ay4.d.a().i(r4.getAbsolutePath()).isFile() == false) goto L24;
        String r5 = r4.getAbsolutePath();
        if (r5.endsWith(this.c) == false) goto L20;
        boolean r7 = true;
        if (TextUtils.equals(r5.substring(r5.lastIndexOf("/") + 1), this.c) == false) goto L20;
    L21:
        if (r7 == false) goto L23;
        ((HashMap) r11).put(this.c, r5);
        goto L24
    L23:
        ((HashMap) r11).put(r5.substring(r12), r5);
    L20:
        r7 = false;
    L24:
        q(r4, r11, r12);
        goto L26
    L32:
        return;
    }

    public final InputStream r(String r5, InputStream r6, InputStream r7) throws IOException {
        if (r7 == null) goto L13;
        tt5.a.b(this.b, "sourceMap exist fileName=" + r5);
        ByteArrayOutputStream r8 = new ByteArrayOutputStream();
        byte[] r0 = new byte[1024];     // Catch: Throwable -> L10
    L5:
        int r1 = r7.read(r0);     // Catch: Throwable -> L10
        if (r1 == (-1)) goto L8;
        r8.write(r0, 0, r1);     // Catch: Throwable -> L10
        goto L5
    L8:
        String r2 = Base64.encodeToString(r8.toByteArray(), 2);     // Catch: Throwable -> L10
        StringBuilder r3 = new StringBuilder();     // Catch: Throwable -> L10
        r3.append('\n');     // Catch: Throwable -> L10
        r3.append("//# sourceMappingURL=data:application/json;charset=utf-8;base64,");     // Catch: Throwable -> L10
        r3.append(r2);     // Catch: Throwable -> L10
        SequenceInputStream r4 = new SequenceInputStream(r6, new ByteArrayInputStream(new String(r3).getBytes(StandardCharsets.UTF_8)));     // Catch: Throwable -> L10
        r7.close();
        r8.close();
        return r4;
    L10:
        th = move-exception;
        r7.close();
        r8.close();
        throw th;
    L13:
        return r6;
    }

    public final WebResourceResponse t(String r21, String r22, Map<String, String> r23) {
        if ("options".equalsIgnoreCase(r22) == false) goto L5;
        return null;
    L5:
        long r4 = SystemClock.uptimeMillis();
    L126:
        e = e;
        boolean r13 = false;
    L128:
        tt5.a.e(this.b, "internalGetSubResponseStream ", e, r13);
    L129:
        String r0 = this.b;
        if (r21 != null) goto L132;
    L136:
        String r1 = "";
    L137:
        tt5.a.h(r0, "internalGetSubResponseStream... not InterceptRequest ".concat(r1));
        return null;
    L132:
        if (r21.endsWith(".js") == false) goto L134;
    L135:
        r1 = r21;
        goto L137
    L134:
        if (r21.endsWith(".css") == false) goto L136;
    L8:
        if (TextUtils.equals(r21, this.s) == false) goto L139;
        tt5.a.h(this.b, "shouldInterceptRequest()... mPreloadUrl = " + this.s);     // Catch: Exception -> L126
        u();     // Catch: Exception -> L126
        B = B + 1;     // Catch: Exception -> L126
        C++;     // Catch: Exception -> L126
        if (this.r == true) goto L12;
    L21:
        tt5.a.d(this.b, "shouldInterceptRequest()... mResponseContent initSuccess = " + this.r + " mResponseContent: " + this.e);     // Catch: Exception -> L126
    L22:
        return null;
    L12:
        if (TextUtils.isEmpty(this.e) == true) goto L21;
        String r3 = this.e;     // Catch: Exception -> L126
        String r5 = n25.b.a;     // Catch: Exception -> L126
        ByteArrayInputStream r2 = new ByteArrayInputStream(r3.getBytes(r5));     // Catch: Exception -> L126
        if (r2.available() <= 0) goto L20;
        tt5.a.h(this.b, "shouldInterceptRequest() mResponseContent replace html... ");     // Catch: Exception -> L126
        h r6 = new h(r21, d25.d.c(r21), r5, r2);     // Catch: Exception -> L126
        r23.put("codecache-optimize", "true");     // Catch: Exception -> L126
        r23.put("memcache-optimize", "true");     // Catch: Exception -> L126
        r23.put("readonce-optimize", "true");     // Catch: Exception -> L126
        if (r23.containsKey("ttweb_adblock") == false) goto L18;
        r23.remove("ttweb_adblock");     // Catch: Exception -> L126
    L18:
        r6.setResponseHeaders(r23);     // Catch: Exception -> L126
        this.v = true;     // Catch: Exception -> L126
        this.l.j("load_template_gap", "start_time", String.valueOf(System.currentTimeMillis()));     // Catch: Exception -> L126
        return r6;
    L20:
        tt5.a.d(this.b, "shouldInterceptRequest()... mResponseContent inputstream is invalid end");     // Catch: Exception -> L126
        goto L22
    L139:
        if (g5.c(r21) == false) goto L41;
        String r7 = d25.d.g;     // Catch: Exception -> L126
        Pair<Boolean, Integer> r8 = this.q.a(r21);     // Catch: Exception -> L126
        boolean r9 = ((Boolean) r8.first).booleanValue();     // Catch: Exception -> L126
        if (r9 == false) goto L28;
        DownloadRequestInfo.DownloadType r10 = DownloadRequestInfo.DownloadType.COVER;     // Catch: Exception -> L126
    L29:
        if (r9 == false) goto L31;
        int r11 = ((Integer) r8.second).intValue();     // Catch: Exception -> L126
    L32:
        w85.b r12 = l(r21, r10, r11);     // Catch: Exception -> L126
        if (r12 == null) goto L39;
        WebResourceResponse r14 = m("image/*", r12.a, r23);     // Catch: Exception -> L126
        if (r14 == null) goto L37;
        e25.a.b(r12.c, r4, r12.d, r12.e, "customSchemeDrive", r11, r7);     // Catch: Exception -> L126
    L38:
        return r14;
    L37:
        e25.a.a(r4, r12.e, "customSchemeDrive", r11, r7, "null_web_response");     // Catch: Exception -> L126
        goto L38
    L39:
        e25.a.a(r4, -1, "customSchemeDrive", r11, r7, "failure");     // Catch: Exception -> L126
    L50:
        int r16 = 0;
    L123:
        if (TextUtils.equals(r21, this.s) == true) goto L129;
        B = r16;     // Catch: Exception -> L57
        goto L129
    L31:
        r11 = DriveCompressCheckerV2.CoverSize.ORIGINAL.size;     // Catch: Exception -> L126
        goto L32
    L28:
        r10 = DownloadRequestInfo.DownloadType.IMG;     // Catch: Exception -> L126
        goto L29
    L41:
        if (g5.b(r21) == true) goto L43;
        r16 = 0;
        r13 = false;
        r16 = 0;
        r16 = 0;
        r16 = 0;
        r16 = 0;
        if (g5.d(r21) == false) goto L60;
        int r17 = j.a;     // Catch: Exception -> L57
        return m(d25.d.c(r21), j.a(this.h, r21), r23);
    L60:
        if (q1.a(r21) == false) goto L70;
        if (this.g == false) goto L68;
        if (p(UriProtector.parse(r21).getHost()) == false) goto L123;
        return f(r21, r23, r4, n(r21, r23), d25.d.g);
    L68:
        return f(r21, r23, r4, n(r21, r23), d25.d.g);
    L70:
        if (TextUtils.isEmpty(r21) == false) goto L72;
    L81:
        boolean r18 = false;
    L82:
        if (r18 == false) goto L86;
        return m(r21, j(r21), r23);
    L86:
        if (TextUtils.isEmpty(r21) == true) goto L123;
        String r19 = l25.b.a(UriProtector.parse(r21).getPath());     // Catch: Exception -> L57
        if (TextUtils.isEmpty(r19) == true) goto L123;
        InputStream r20 = e(r19);     // Catch: Exception -> L57
        if (r20 != null) goto L92;
        l25.a r24 = this.p;     // Catch: Exception -> L57
        if (r24 == null) goto L123;
        if (r24.b(r21) == false) goto L123;
        WebResourceResponse r26 = this.p.a(r21);     // Catch: Exception -> L57
        if (r26 == null) goto L121;
        c(r23);     // Catch: Exception -> L57
        r23.put("Access-Control-Allow-Headers", "accept, authorization, Content-Type");     // Catch: Exception -> L57
        r26.setResponseHeaders(r23);     // Catch: Exception -> L57
    L121:
        return r26;
    L92:
        if (com.bytedance.ee.bear.document.reloadwebview.a.j == false) goto L95;
        com.bytedance.ee.bear.document.reloadwebview.a.f();     // Catch: Exception -> L57
    L95:
        if (this.u == false) goto L97;
        r20 = r(r19, r20, e(r19 + ".map"));     // Catch: Exception -> L57
    L97:
        h r27 = new h(r21, d25.d.c(r21), n25.b.a, r20);     // Catch: Exception -> L57
    L108:
        th = move-exception;
        tt5.a.e(this.b, "ttwebview-response-update-time ", th, false);     // Catch: Exception -> L57
    L113:
        return r27;
    L99:
        if (TextUtils.isEmpty(this.f.get(r19)) == true) goto L113;
        VFSFile r28 = ay4.d.a().i(this.f.get(r19));     // Catch: Throwable -> L108
        if (r28.exists() == false) goto L113;
        r23.put("x-ttwebview-response-update-time", String.valueOf(r28.lastModified()));     // Catch: Throwable -> L108
        if (this.w == false) goto L106;
        c(r23);     // Catch: Throwable -> L108
    L106:
        if (r23.containsKey("ttweb_adblock") == false) goto L110;
        r23.remove("ttweb_adblock");     // Catch: Throwable -> L108
    L110:
        r27.setResponseHeaders(r23);     // Catch: Throwable -> L108
    L72:
        if (r21.contains("/obj/creation-image-system/") == false) goto L81;
        int r29 = r21.lastIndexOf("/");     // Catch: Exception -> L57
        if (r29 < 0) goto L78;
        int r30 = r29 + 1;     // Catch: Exception -> L57
        if (r30 > r21.length()) goto L78;
        boolean r31 = r21.substring(r30).startsWith("cover-");     // Catch: Exception -> L57
    L79:
        if (r31 == false) goto L81;
        r18 = true;
    L78:
        r31 = false;
        goto L79
    L43:
        if (this.g == false) goto L52;
        if (p(UriProtector.parse(r21).getHost()) == false) goto L50;
        return f(r21, r23, r4, k(r21, r23), d25.d.g);
    L52:
        return f(r21, r23, r4, k(r21, r23), d25.d.g);
    L57:
        e = e;
        goto L128
    }

    public g(Context r9, String r10, boolean r11, String r12) {
        this.b = "OfflineResourceInterceptor2";
        this.c = "mobile_index.html";
        com.bytedance.ee.bear.appsetting.c r0 = com.bytedance.ee.bear.appsetting.c.a.a;
        boolean r1 = r0.g("ccm.mobile.res.domain_check_enable");
        this.g = r1;
        this.u = false;
        this.v = false;
        this.w = r0.g("ccm.mobile.slides_enabled");
        if (TextUtils.isEmpty(r10) == true) goto L5;
        this.b = "OfflineResourceInterceptor2_" + r10;
    L5:
        this.c = r12;
        this.h = r9;
        this.i = (h0) org.koin.java.a.a(h0.class);
        this.j = (NetService) org.koin.java.a.a(NetService.class);
        this.l = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        this.k = (i0) org.koin.java.a.a(i0.class);
        b0 r13 = (b0) org.koin.java.a.a(b0.class);
        this.m = r13;
        this.f = new ConcurrentHashMap();
        ml5.b r14 = new ml5.b("debug_config");
        this.o = r14;
        this.q = new DriveCompressCheckerV2(r9);
        ((Integer) r0.d("drive_rust_cover_size", 1280)).intValue();
        if (r11 == false) goto L8;
        String r16 = "aWZyYW1lSnNiQ2hlY2s=";
    L9:
        this.a = r16;
        this.u = r14.a.getBoolean("offline_res_enable_source_map", false);
        this.x = new s1(com.bytedance.ee.bear.contract.j.a.a, (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), (b0) org.koin.java.a.a(b0.class), (com.bytedance.ee.bear.contract.f) org.koin.java.a.a(com.bytedance.ee.bear.contract.f.class), ((b0) org.koin.java.a.a(b0.class)).e());
        if (D != (-1)) goto L17;
        DocOpenConfig.DocsWebviewConfig r17 = (DocOpenConfig.DocsWebviewConfig) r0.c("docs_webview_config", DocOpenConfig.DocsWebviewConfig.class, new DocOpenConfig.DocsWebviewConfig());
        if (r17 == null) goto L16;
        int r18 = r17.resetWKProcessPoolContinuousFailCount;
        if (r18 <= 0) goto L16;
        D = r18;
    L16:
        D = E;
    L17:
        String r19 = r13.w();
        this.d = r19;
        tt5.a.h(this.b, "HostDomain is: " + r19 + "  isDomainMatchFG: " + r1);
        return;
    L8:
        r16 = UUID.randomUUID().toString();
        goto L9
    }

    public final VFSPath b(String r4, String r5, String r6, Map<String, String> r7) {
        i(r7);     // Catch: Exception -> L12
        VFSPath r8 = ay4.d.a().t((File) Glide.with(this.h).load(new BearGlideUrl(r5, this.n)).downloadOnly(ShareItemModel.SRC_TINT_UNDEFINED, ShareItemModel.SRC_TINT_UNDEFINED).get());     // Catch: Exception -> L12
        if (com.bytedance.ee.util.io.b.c(r8) == false) goto L10;
        q r9 = new q();     // Catch: Exception -> L12
        r9.a = r8.getName() + OfflineDoc.DASH_DELIMITER + System.currentTimeMillis();     // Catch: Exception -> L12
        String r0 = d25.d.d;     // Catch: Exception -> L12
        if (r0 == null) goto L7;
        r9.b = r0;     // Catch: Exception -> L12
        r9.c = r0;     // Catch: Exception -> L12
    L8:
        r9.d = k25.e0.D(r8.getRealPath());     // Catch: Exception -> L12
        r9.h = Long.valueOf(FileUtils.v(r8));     // Catch: Exception -> L12
        r9.g = r6;     // Catch: Exception -> L12
        k25.e0.m().u(r9);     // Catch: Exception -> L12
        return r8;
    L7:
        r9.b = r4;     // Catch: Exception -> L12
        r9.c = r4;     // Catch: Exception -> L12
        goto L8
    L10:
        tt5.a.k(this.b, "internalGetNetImageStream isImage not: ");     // Catch: Exception -> L12
        return null;
    L12:
        e = move-exception;
        tt5.a.e(this.b, "internalGetNetImageStream: downloadImage failed", e, false);
        return null;
    }

    public final Pair<InputStream, Pair<String, Long>> o(String r6, String r7, String r8, Map<String, String> r9) {
        k25.e0 r2 = k25.e0.m();     // Catch: IOException -> L24
        r2.getClass();     // Catch: IOException -> L24
        q r3 = ((j25.p) r2.q().d()).g(r8);     // Catch: Exception -> L6
        k25.e0.a(r3);     // Catch: Exception -> L6
    L8:
        tt5.a.h(this.b, "internalGetNetImageStream()... end url = , path =" + r3);     // Catch: IOException -> L24
        if (r3 == null) goto L23;
        if (TextUtils.isEmpty(r3.d) == true) goto L23;
        int r1 = j.a;     // Catch: IOException -> L24
        Pair r4 = j.b(this.h, r3.d, r3.e);     // Catch: IOException -> L24
        InputStream r5 = (InputStream) r4.first;     // Catch: IOException -> L24
        if (r5 != null) goto L15;
    L18:
        if (r5 == null) goto L20;
        r5.close();     // Catch: IOException -> L24
    L20:
        tt5.a.h(this.b, "internalGetNetImageStream()... local file not valid, re-download it, path =" + r3);     // Catch: IOException -> L24
        return g(b(r6, r7, r8, r9));
    L15:
        if (r5.available() <= 0) goto L18;
        return new Pair(r5, new Pair(DiagramData$RESULT.SUCCESS, (Long) r4.second));
    L23:
        return g(b(r6, r7, r8, r9));
    L6:
        e = move-exception;
        iu5.d.c(e);     // Catch: IOException -> L24
        r3 = new q();     // Catch: IOException -> L24
    L24:
        tt5.a.d(this.b, "IOException e");
        return new Pair(null, new Pair(DiagramData$RESULT.FAIL, -1L));
    }

    public final WebResourceResponse f(String r20, Map<String, String> r21, long r22, Pair<InputStream, Pair<String, Long>> r24, String r26) {
        InputStream r1 = (InputStream) r24.first;
        if (r1 == null) goto L10;
        WebResourceResponse r2 = m(d25.d.c(r20), r1, r21);
        Pair r0 = (Pair) r24.second;
        if (r0 == null) goto L8;
        if (r2 == null) goto L8;
        e25.a.b((String) r0.first, r22, ((Long) r0.second).longValue(), 0, "customSchemeDocs", -1, r26);
    L9:
        return r2;
    L8:
        e25.a.a(r22, -1, "customSchemeDocs", -1, r26, "null_web_response");
        goto L9
    L10:
        e25.a.a(r22, -1, "customSchemeDocs", -1, r26, "failure");
        return null;
    }
}
