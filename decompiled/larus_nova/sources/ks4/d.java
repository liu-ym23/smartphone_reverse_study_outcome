package ks4;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.homepage.chart.ChartConfig;
import com.bytedance.ee.bear.bitable.homepage.chart.container.JSContextTag;
import com.bytedance.ee.bear.bitable.homepage.chart.container.loader.TemplateLoaderCreator;
import com.bytedance.ee.bear.bitable.homepage.chart.widget.chart.ChartItemView$generateChartLynxContainer$lynxContainer$1;
import com.bytedance.ee.bear.bitable.homepage.chart.widget.chart.ChartItemView$generateChartLynxContainer$lynxContainer$2;
import com.bytedance.geckox.GeckoConfig;
import com.dtf.face.api.IDTFacade;
import com.larksuite.framework.utils.ApkUtil;
import com.lynx.tasm.LynxGroup;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.lynxkit.container.LarkLynxContainerBuilder;
import com.ss.android.lark.lynxkit.initializer.LarkLynxKitInitializer;
import com.ss.android.lark.lynxkit.templateloader.loaderimpl.GeckoStrategy;
import com.ss.android.lark.passport_api.IPassportApi;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.PackageChannelManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
@UserScope
public final class d implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f505911a;

    public static final class a {
    }

    static {
    }

    @Override // ks4.k
    public final void reset() {
        this.f505911a.set(false);
    }

    @Inject
    public d() {
        this.f505911a = new AtomicBoolean(false);
    }

    public static String c() {
        yob.e.a().getClass();
        int r100 = com.ss.android.lark.language.service.impl.a.f431092f;
        Locale r101 = com.ss.android.lark.language.service.impl.a.b.f431098a.getLanguageSetting();
        if (r101 != null) goto L5;
        r101 = Locale.getDefault();
    L5:
        if (r101 == null) goto L20;
        String r102 = r101.toLanguageTag();
        if (TextUtils.equals("zh-Hans-CN", r102) == false) goto L10;
        r102 = "zh-CN";
    L17:
        Intrinsics.checkNotNull(r102);
        return r102;
    L10:
        if (TextUtils.equals("zh-Hant-TW", r102) == false) goto L12;
        r102 = IDTFacade.ZIM_EXT_PARAMS_LAN_VAL_ZH_TW;
        goto L17
    L12:
        Intrinsics.checkNotNull(r102);
        if (StringsKt.startsWith$default(r102, "zh-Hans", false, 2, null) == true) goto L16;
        Intrinsics.checkNotNull(r102);
        if (StringsKt.startsWith$default(r102, "zh-Hant", false, 2, null) == false) goto L17;
    L16:
        r102 = IDTFacade.ZIM_EXT_PARAMS_LAN_VAL_ZH_HK;
        goto L17
    L20:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final LynxGroup b(d r100, String r101) {
        r100.getClass();
        return LynxGroup.Create(r101, r101, null, false, true, true);
    }

    @Override // ks4.k
    public final b a(Context r110, ChartItemView$generateChartLynxContainer$lynxContainer$1 r111, Map r112, JSContextTag r210, ChartItemView$generateChartLynxContainer$lynxContainer$2 r211) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r210, "tagForJsContext");
        Intrinsics.checkNotNullParameter(r211, "templateLoadListener");
        tt5.a.h("ChartLynxContainerProvider", "createLynxContainer");
        if (this.f505911a.get() == true) goto L34;
        tt5.a.h("ChartLynxContainerProvider", "init start");
        this.f505911a.set(true);
        LarkLynxKitInitializer.Companion.getClass();
        LarkLynxKitInitializer.b.a().registerLynxGroup(JSContextTag.TAG_FOR_JS_CONTEXT_HOME.getValue(), new e(this));
        LarkLynxKitInitializer.b.a().registerLynxGroup(JSContextTag.TAG_FOR_JS_CONTEXT_ADD.getValue(), new f(this));
        LarkLynxKitInitializer.b.a().registerLynxGroup(JSContextTag.TAG_FOR_JS_CONTEXT_FULLSCREEN.getValue(), new g(this));
        LarkLynxKitInitializer.b.a().registerLynxGroup(JSContextTag.TAG_FOR_JS_CONTEXT_PLAYGROUND.getValue(), new h(this));
        LarkLynxKitInitializer r113 = LarkLynxKitInitializer.b.a();
        if (h18.f.a(LarkContext.getApplication()) == false) goto L8;
        String r100 = "dark";
    L9:
        LinkedHashMap r114 = new LinkedHashMap();
        JSONObject r115 = new JSONObject();     // Catch: Throwable -> L16
        r115.put("os", "Android");     // Catch: Throwable -> L16
        r115.put("platform", "android");     // Catch: Throwable -> L16
        r115.put("osVersion", String.valueOf(Build.VERSION.SDK_INT));     // Catch: Throwable -> L16
        r115.put("brand", Build.BRAND);     // Catch: Throwable -> L16
        r114.put("deviceInfo", r115);     // Catch: Throwable -> L16
        IPassportApi r116 = (IPassportApi) ApiUtils.getApi(IPassportApi.class);     // Catch: Throwable -> L16
        JSONObject r117 = new JSONObject();     // Catch: Throwable -> L16
        r117.put("deviceID", r116.getDeviceId());     // Catch: Throwable -> L16
        r117.put("tenantID", r116.getTenantId());     // Catch: Throwable -> L16
        r117.put("tenantBrand", r116.getTenantBrand());     // Catch: Throwable -> L16
        r117.put("isFeishuBrand", r116.isFeishuBrand());     // Catch: Throwable -> L16
        r117.put("isChinaMainlandGeo", r116.isChinaMainlandGeo());     // Catch: Throwable -> L16
        r117.put("userID", r116.getUserId());     // Catch: Throwable -> L16
        r117.put("userGeo", r116.getUser().userGeo);     // Catch: Throwable -> L16
        r114.put("accountInfo", r117);     // Catch: Throwable -> L16
        JSONObject r118 = new JSONObject();     // Catch: Throwable -> L16
        r118.put("language", c());     // Catch: Throwable -> L16
        r118.put("larkVersion", ApkUtil.getAppVersionName(LarkContext.getApplication()));     // Catch: Throwable -> L16
        r118.put("theme", r100);     // Catch: Throwable -> L16
        r118.put("isKA", PackageChannelManager.isKABuildPackage(LarkContext.getApplication()));     // Catch: Throwable -> L16
        LarkAppContext.Companion.getClass();     // Catch: Throwable -> L16
        r118.put("isLark", LarkAppContext.access$getInstance$cp().buildConfig().isUsPackage());     // Catch: Throwable -> L16
        if (LarkAppContext.access$getInstance$cp().buildConfig().isUsPackage() == true) goto L13;
        boolean r119 = true;
    L14:
        r118.put("isFeishu", r119);     // Catch: Throwable -> L16
        r118.put("timezone", TimeZone.getDefault().getID());     // Catch: Throwable -> L16
        r114.put("larkInfo", r118);     // Catch: Throwable -> L16
    L18:
        r113.registerGlobalData("LarkBitableForChart", r114);
        LarkLynxKitInitializer.Companion.getClass();
        LarkLynxKitInitializer.b.a().registerBridgeMethodDispatcher("LarkBitableForChart", new ks4.a());
        LarkLynxKitInitializer r101 = LarkLynxKitInitializer.b.a();
        Lazy r120 = TemplateLoaderCreator.f212440a;
        if (PackageChannelManager.getDeployMode(LarkContext.getApplication()) == 1) goto L21;
        boolean r121 = true;
    L22:
        if (r121 == false) goto L24;
        List<? extends uqb.b> r122 = CollectionsKt.listOf(new com.bytedance.ee.bear.bitable.homepage.chart.container.loader.a());
    L33:
        r101.registerTemplateLoaders("LarkBitableForChart", r122);
        tt5.a.h("ChartLynxContainerProvider", "init end");
        goto L34
    L24:
        Lazy r123 = TemplateLoaderCreator.f212441b;
        if (((GeckoConfig) r123.getValue()) != null) goto L27;
        com.bytedance.ee.bear.bitable.homepage.chart.container.loader.b r124 = null;
    L30:
        if (r124 != null) goto L32;
        r122 = CollectionsKt.emptyList();
        goto L33
    L32:
        r122 = CollectionsKt.listOf(r124);
        goto L33
    L27:
        GeckoConfig r125 = (GeckoConfig) r123.getValue();
        if (r125 == null) goto L43;
        r124 = new com.bytedance.ee.bear.bitable.homepage.chart.container.loader.b(r125, GeckoStrategy.WAIT_FOR_REMOTE);
        goto L30
    L43:
        throw new IllegalArgumentException("Required value was null.".toString());
    L21:
        r121 = false;
        goto L22
    L13:
        r119 = false;
    L16:
        th = move-exception;
        tt5.a.f("ChartLynxContainerProvider", th, false);
        goto L18
    L8:
        r100 = "light";
    L34:
        c r102 = new c();
        if (r112 == null) goto L37;
        Intrinsics.checkNotNullParameter(r112, RuleConditionBean.BIZ_DATA_KEY);
        r102.f505910a.putAll(r112);
    L37:
        ChartConfig r103 = (ChartConfig) SettingManager.getInstance().get(ChartConfig.class);
        if (r103 != null) goto L40;
        r103 = new ChartConfig();
    L40:
        LarkLynxContainerBuilder r104 = new LarkLynxContainerBuilder(r110).containerContext(r102).tagForJsContext(r210.getValue()).tagForCustomComponent("LarkBitableForChart").tagForBridgeMethodDispatcher("LarkBitableForChart").tagForTemplateLoader("LarkBitableForChart").tagForGlobalData("LarkBitableForChart").templateLoadListener(r211).setEnableUserCodeCache(true).enableDevToolsDebug(false).setCodeCacheSourceUrl("local://bitable_chart_code_cache").enableAsyncRender(r103.d());
        r104.lynxViewLifeCycle(r111);
        return new b(r104.build(), r102);
    }
}
