package com.bytedance.ee.bear.document.render.preload;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.document.DocOpenConfig;
import com.bytedance.ee.bear.document.debug.DebugUtils;
import com.bytedance.ee.bear.lark.dependency.m;
import com.bytedance.ee.util.io.FileUtils;
import com.larksuite.component.ui.display.manager.zoom.ZoomLevel6;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.PackageChannelManager;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.lark.android.encryption.CipherManager;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import s45.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static String f;
    public static String g;
    public final vo5.a a;
    public final h0 b;
    public final i0 c;
    public final NetService d;
    public final ml5.b e;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.render.preload.a$a, reason: collision with other inner class name */
    public static final class C0100a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ZoomLevel6.values().length];
            r0[ZoomLevel6.SMALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[ZoomLevel6.LARGE1.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[ZoomLevel6.LARGE2.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[ZoomLevel6.LARGE3.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[ZoomLevel6.LARGE4.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    static {
    }

    public a(vo5.a r4) {
        Intrinsics.checkNotNullParameter(r4, "userComponent");
        this.a = r4;
        this.b = (h0) r4.a(h0.class);
        this.c = (i0) org.koin.java.a.c(i0.class, null, null, 6);
        this.d = (NetService) r4.a(NetService.class);
        this.e = DebugUtils.a();
    }

    public final HashMap<String, String> a(VFSPath r24, String r26) {
        String r4 = "lf-package-cn.feishucdn.com/obj/feishu-static";
        Intrinsics.checkNotNullParameter(r24, "resRoot");
        Intrinsics.checkNotNullParameter(r26, "jsbCheckKey");
        tt5.a.h("TemplateInfoReplacer", "==openDocs==preload== replaceTemplateInfos, start");
        LinkedHashMap r6 = new LinkedHashMap();
        AccountService$Account r0 = this.b.U5();
        String r7 = "";
        if (r0 == null) goto L11;
        String r8 = r0.uid;
        if (r8 != null) goto L7;
        r8 = "";
    L7:
        r6.put("{{ user_id }}", r8);
        String r1 = r0.tenantId;
        if (r1 != null) goto L10;
        r1 = "";
    L10:
        r6.put("{{ tenant_id }}", r1);
    L11:
        String r9 = ou5.b.a(this.c.c().getCountry(), this.c.a());
        JSONArray r12 = new JSONArray(((s45.c) org.koin.java.a.c(s45.c.class, null, null, 6)).Ba("overload_static_domain_new"));     // Catch: JSONException -> L16
        if (r12.length() <= 0) goto L18;
        String r13 = r12.optString(0, "");     // Catch: JSONException -> L16
    L19:
        r6.put("{{lang_cdn}}", "//" + r13 + "/eesz/resource/bear/lang/" + r9 + ".js");
        r6.put("{{ language }}", ou5.b.c(this.c.c().getCountry(), this.c.a()).toString());
        com.bytedance.ee.bear.appsetting.c r2 = com.bytedance.ee.bear.appsetting.c.a.a;
        String r14 = "{}";
        r6.put("\"{{ app_config }}\"", (String) r2.d("app_config", "{}"));
        boolean r3 = r2.g("ccm.mobile.disable_domain_all_opt") ^ true;
        if (r3 == false) goto L22;
        String r16 = DocOpenConfig.c();
    L23:
        tt5.a.h("TemplateInfoReplacer", "isDomainSyncEnable: " + r3 + ", getDomainCharacteristicConfig: " + r16);
        r6.put("\"{{ domain_characteristic_config }}\"", r16);
        if (r3 == false) goto L36;
        if (r16 != null) goto L27;
    L30:
        boolean r5 = true;
    L31:
        if (r5 == true) goto L35;
        if (TextUtils.equals(r16, "{}") == false) goto L36;
    L35:
        return new HashMap();
    L27:
        if (r16.length() == 0) goto L30;
        r5 = false;
    L36:
        StringCompanionObject r10 = StringCompanionObject.INSTANCE;
        r6.put("\"{{ app_debug_config }}\"", String.format("{\"isDebug\":%b}", Arrays.copyOf(new Object[]{this.e.a("isDebug", Boolean.FALSE)}, 1)));
        if (this.d.w6() == false) goto L39;
        String r11 = "staging";
    L40:
        r6.put("{{navigator_env}}", r11);
        String r17 = p.a().T0();
        if (r17 != null) goto L43;
        r17 = "";
    L43:
        r6.put("{{navigator_path_prefix}}", r17);
        r6.put("{{navigator_api_prefix}}", "https://" + p.u + '/' + p.a().u9());
        String r18 = "False";
        r6.put("{{ anonymous_access }}", "False");
        String r19 = n25.b.a;
        Application r20 = LarkContext.getApplication();
        if (r20 != null) goto L46;
    L48:
        boolean r21 = false;
    L50:
        if (r21 == false) goto L52;
        Object r22 = "True";
    L53:
        r6.put("{{ is_ka }}", r22);
        Application r23 = LarkContext.getApplication();
        if (r23 != null) goto L56;
    L58:
        boolean r110 = false;
    L59:
        if (r110 == false) goto L61;
        String r27 = PackageChannelManager.getBuildPackageChannel(r23);
    L62:
        r6.put("{{ ka_channel }}", r27);
        Iterator r28 = ArrayIteratorKt.iterator(n25.b.b);
    L64:
        if (r28.hasNext() == false) goto L68;
        String r111 = (String) r28.next();
        if (r6.containsKey(r111) == true) goto L64;
        r6.put(r111, "null");
        goto L64
    L68:
        r6.put("{{ enable_et_test }}", String.valueOf(((Boolean) this.e.a("enable_frontend_et_test", Boolean.FALSE)).booleanValue()));
        String r29 = ((m) org.koin.java.a.c(m.class, null, null, 6)).getString();
        if (TextUtils.isEmpty(r29) == false) goto L71;
        r29 = "{}";
    L71:
        r6.put("\"{{ globalKaConfig }}\"", r29);
        int r30 = b.a[zz7.b.d().ordinal()];
        if (r30 != 1) goto L74;
        String r31 = "S";
    L87:
        StringCompanionObject r112 = StringCompanionObject.INSTANCE;
        r6.put("\"{{ device_info }}\"", String.format("{\"baseFontSize\": \"%s\"}", Arrays.copyOf(new Object[]{r31}, 1)));
        if (((mw4.a) org.koin.java.a.c(mw4.a.class, null, null, 6)).isNightMode() == false) goto L90;
        String r32 = "\"dark\"";
    L91:
        r6.put("\"{{ theme }}\"", r32);
        tt5.a.b("TemplateInfoReplacer", "replaceTemplateInfos: theme = ".concat(r32));
        if (com.bytedance.ee.bear.appsetting.c.a.a.i("ccm.theme.mobile_darkmode_enable", false) == false) goto L94;
        Object r33 = "True";
    L95:
        r6.put("{{ darkmode_enable }}", r33);
        if (CipherManager.d() != 1) goto L98;
        r18 = "True";
    L98:
        r6.put("{{ disk_crypto_enable }}", r18);
        r6.put("{{ comment_disable_rn }}", "True");
        if (f == null) goto L101;
        tt5.a.h("TemplateInfoReplacer", "sFgMap is not null");
        String r113 = f;
    L118:
        if (r113 != null) goto L120;
        r113 = "{}";
    L120:
        r6.put("\"{{ mobile_fg_dictionary }}\"", r113);
        if (g == null) goto L124;
        tt5.a.h("TemplateInfoReplacer", "sAbTestMap is not null");
        String r34 = g;
    L161:
        if (r34 != null) goto L163;
        r34 = "{}";
    L163:
        r6.put("\"{{ mobile_ab_test_dictionary }}\"", r34);
        com.bytedance.ee.bear.appsetting.c r36 = com.bytedance.ee.bear.appsetting.c.a.a;
        if (r36.g("ccm.mobile.dynamic_cdn_domain_enable") == false) goto L167;
        r4 = r13;
    L167:
        r6.put("{{cdn_host}}", "//" + r4);
        JSONObject r37 = new JSONObject();     // Catch: Exception -> L189
        if (r36.g("ccm.mobile.enable_web_setting_dynamic") == false) goto L186;
        JSONObject r38 = new JSONObject((String) r36.d("ccm_web_template_setting_config", "{}"));     // Catch: Exception -> L189
        Iterator<String> r39 = r38.keys();     // Catch: Exception -> L189
    L172:
        if (r39.hasNext() == false) goto L187;
        String r40 = r39.next();     // Catch: Exception -> L189
        Object r41 = r38.get(r40);     // Catch: Exception -> L189
        if ((r41 instanceof JSONArray) == true) goto L176;
        tt5.a.d("TemplateInfoReplacer", "replaceTemplateInfos()... value is not JSONArray");     // Catch: Exception -> L189
        Unit r42 = Unit.INSTANCE;     // Catch: Exception -> L189
        goto L172
    L176:
        if (((JSONArray) r41).length() == 0) goto L177;
        JSONObject r43 = new JSONObject();     // Catch: Exception -> L189
        int r44 = ((JSONArray) r41).length();     // Catch: Exception -> L189
        int r114 = 0;
    L179:
        if (r114 >= r44) goto L184;
        Object r115 = ((JSONArray) r41).get(r114);     // Catch: Exception -> L189
        if ((r115 instanceof String) == false) goto L183;
        r43.put((String) r115, new JSONObject((String) com.bytedance.ee.bear.appsetting.c.a.a.d(r40, "{}")).get((String) r115));     // Catch: Exception -> L189
    L183:
        r114 = r114 + 1;     // Catch: Exception -> L189
        goto L179
    L184:
        r37.put(r40, r43);     // Catch: Exception -> L189
        goto L172
    L177:
        r37.put(r40, new JSONObject((String) com.bytedance.ee.bear.appsetting.c.a.a.d(r40, "{}")));     // Catch: Exception -> L189
    L187:
        r14 = r37.toString();     // Catch: Exception -> L189
    L191:
        r6.put("\"{{ settings_config }}\"", r14);
        r6.put("{{ iframeJsbCheck }}", r26);
        tt5.a.h("TemplateInfoReplacer", "==openDocs==preload== replaceTemplateInfos end, replaceMap.size =  " + r6.size());
        return r6;
    L186:
        JSONObject r46 = new JSONObject();     // Catch: Exception -> L189
        r46.put("reaction_bucket_prex", new JSONArray(jcb.b.c().b("reaction_bucket_prex")));     // Catch: Exception -> L189
        r46.put("suite_security_link", new JSONArray(jcb.b.c().b("suite_security_link")));     // Catch: Exception -> L189
        JSONObject r47 = new JSONObject();     // Catch: Exception -> L189
        r47.put("sec_link_whitelist", new JSONObject((String) r36.d("domain_manage_policy", "{}")).get("sec_link_whitelist"));     // Catch: Exception -> L189
        r37.put("biz_domain_config", r46);     // Catch: Exception -> L189
        r37.put("domain_manage_policy", r47);     // Catch: Exception -> L189
    L189:
        e = move-exception;
        tt5.a.e("TemplateInfoReplacer", "replaceTemplateInfos()... ", e, false);
        goto L191
    L124:
        if (r24.toFile().exists() == true) goto L126;
        tt5.a.h("TemplateInfoReplacer", "getAbTestValue, resource_root_path is null");
    L160:
        r34 = "{}";
        goto L161
    L126:
        tt5.a.h("TemplateInfoReplacer", "getAbTestValue from file");
        JSONObject r48 = new JSONObject();
        List r49 = StringsKt.split$default(FileUtils.E(r24.subPath("mobileABTestKeys.txt")), new String[]{","}, false, 0, 6, null);     // Catch: Throwable -> L158
        tt5.a.h("TemplateInfoReplacer", "getAbTestValue keys size is " + r49.size());     // Catch: Throwable -> L158
        LarkAppContext.Companion.getClass();     // Catch: Throwable -> L158
        boolean r50 = LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK();     // Catch: Throwable -> L158
        if (r50 == false) goto L130;
        int r51 = o25.a.a;     // Catch: Throwable -> L158
        Map<String, iua.a<?>> r52 = MapsKt.emptyMap();     // Catch: Throwable -> L158
    L131:
        Iterator r53 = r49.iterator();     // Catch: Throwable -> L158
    L133:
        if (r53.hasNext() == false) goto L156;
        String r54 = (String) r53.next();     // Catch: Throwable -> L158
        if (TextUtils.isEmpty(r54) == true) goto L133;
        Object r116 = r52.get(r54);     // Catch: Throwable -> L158
        if (r116 == null) goto L139;
        if (r50 == false) goto L151;
        Class<?> r117 = r116.getClass();     // Catch: Throwable -> L158
        Intrinsics.checkNotNull(r117, "null cannot be cast to non-null type java.lang.Class<T of com.bytedance.ee.bear.document.render.preload.TemplateInfoReplacer.getOfficeSDKAbTestStringValue>");     // Catch: Throwable -> L158
        etb.b r118 = (etb.b) LarkContext.spiByDwarf(etb.b.class);     // Catch: Throwable -> L158
        if (r118 == null) goto L146;
        Object r119 = r118.r(r54, r117, r116);     // Catch: Throwable -> L158
        if (r119 == null) goto L146;
        r116 = r119;
    L146:
        String r120 = mu5.b.e(r116);     // Catch: Throwable -> L158
        if (TextUtils.isEmpty(r120) == true) goto L150;
        r48.put(r54, r120);     // Catch: Throwable -> L158
        goto L133
    L150:
        tt5.a.k("TemplateInfoReplacer", "getAbTestValue in OfficeSDK but value is null, key=" + r54);     // Catch: Throwable -> L158
        goto L133
    L151:
        String r121 = ((xm4.a.a) org.koin.java.a.c(xm4.a.a.class, null, null, 6)).b(r116.getClass().getName());     // Catch: Throwable -> L158
        if (TextUtils.isEmpty(r121) == true) goto L154;
        r48.put(r54, r121);     // Catch: Throwable -> L158
        goto L133
    L154:
        tt5.a.k("TemplateInfoReplacer", "getAbTestValue but value is null");     // Catch: Throwable -> L158
        goto L133
    L139:
        tt5.a.k("TemplateInfoReplacer", "getAbTestValue key=" + r54 + " has not registered, isOfficeSDK=" + r50);     // Catch: Throwable -> L158
        goto L133
    L156:
        g = r48.toString();     // Catch: Throwable -> L158
        tt5.a.h("TemplateInfoReplacer", "getAbTestValue success");     // Catch: Throwable -> L158
        r34 = g;     // Catch: Throwable -> L158
        goto L161
    L130:
        r52 = o25.a.b();     // Catch: Throwable -> L158
    L158:
        th = move-exception;
        tt5.a.e("TemplateInfoReplacer", "getAbTestValue", th, false);
        goto L160
    L101:
        tt5.a.h("TemplateInfoReplacer", "getFGValueV2 from file");
        JSONObject r56 = new JSONObject();
        List r122 = StringsKt.split$default(FileUtils.E(r24.subPath("featureGatingKeys.txt")), new String[]{","}, false, 0, 6, null);     // Catch: Throwable -> L112
        tt5.a.h("TemplateInfoReplacer", "keys size is " + r122.size());     // Catch: Throwable -> L112
        Iterator r57 = r122.iterator();     // Catch: Throwable -> L112
    L104:
        if (r57.hasNext() == false) goto L110;
        String r123 = (String) r57.next();     // Catch: Throwable -> L112
        if (TextUtils.isEmpty(r123) == true) goto L104;
        if (com.bytedance.ee.bear.appsetting.c.a.a.g(r123) == false) goto L104;
        r56.put(r123, true);     // Catch: Throwable -> L112
        goto L104
    L110:
        f = r56.toString();     // Catch: Throwable -> L112
        tt5.a.h("TemplateInfoReplacer", "getFGValueV2 success");     // Catch: Throwable -> L112
        r113 = f;     // Catch: Throwable -> L112
    L112:
        th = move-exception;
        String r58 = th.getMessage();
        if (r58 == null) goto L117;
        r7 = r58;
    L117:
        tt5.a.e("TemplateInfoReplacer", r7, th, false);
        r113 = null;
        goto L118
    L94:
        r33 = "False";
        goto L95
    L90:
        r32 = "\"light\"";
        goto L91
    L74:
        if (r30 != 2) goto L76;
        r31 = "L";
        goto L87
    L76:
        if (r30 != 3) goto L78;
        r31 = "XL";
        goto L87
    L78:
        if (r30 != 4) goto L80;
        r31 = "2XL";
        goto L87
    L80:
        if (r30 == 5) goto L82;
        r31 = "M";
        goto L87
    L82:
        r31 = "3XL";
        goto L87
    L61:
        r27 = "";
        goto L62
    L56:
        if (PackageChannelManager.isKABuildPackage(r23) == false) goto L58;
        r110 = true;
        goto L59
    L52:
        r22 = "False";
        goto L53
    L46:
        if (PackageChannelManager.isKABuildPackage(r20) == false) goto L48;
        r21 = true;
        goto L50
    L39:
        r11 = "prod";
        goto L40
    L22:
        r16 = DocOpenConfig.b();
    L18:
        r13 = "lf-package-cn.feishucdn.com/obj/feishu-static";
    L16:
        e = move-exception;
        tt5.a.e("TemplateInfoReplacer", "getUpdateGifUrl err ", e, false);
        goto L18
    }
}
