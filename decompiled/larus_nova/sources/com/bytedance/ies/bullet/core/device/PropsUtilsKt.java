package com.bytedance.ies.bullet.core.device;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import com.bytedance.android.anniex.base.depend.AnnieXRuntime;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.h;
import com.bytedance.ies.bullet.flow.FlowContainerLoaderSwitch;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.c1;
import com.bytedance.ies.bullet.service.base.m0;
import com.bytedance.ies.bullet.service.base.r;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.dtf.face.config.IConstValues;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import i16.a;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import s26.d;
import t36.j;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001a4\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00062\u0006\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007\u001a2\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0007\u001a*\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0007\u001a1\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0007¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "kitType", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/bytedance/ies/bullet/core/BulletContext;", "bulletContext", "", "", "", "getDeviceProps", "", "withSafeAreaHeight", "Lt36/j;", "schemaModelUnion", "", "getPageCommonProps", "", "contentHeight", "getContainerProps", "(Landroid/content/Context;Ljava/lang/Integer;)Ljava/util/Map;", "anniex_release"}, k = 2, mv = {1, 4, 3})
public final class PropsUtilsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Object> f246472a = null;

    static {
        f246472a = new ConcurrentHashMap();
    }

    public static final String c() {
        List<String> r100 = a.f487988a;
        String r101 = Build.MODEL;
        String r102 = Build.BRAND;
        if (r101 == null) goto L10;
        if (r102 != null) goto L7;
        return r101;
    L7:
        if (StringsKt.contains$default(r101, r102, false, 2, null) == false) goto L9;
        return r101;
    L9:
        return r102 + ' ' + r101;
    L10:
        return r102;
    }

    public static View a(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static final boolean b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r101 = r100.getSystemService("activity");     // Catch: Throwable -> L8
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.app.ActivityManager");     // Catch: Throwable -> L8
        if (((ActivityManager) r101).getDeviceConfigurationInfo().reqGlEsVersion >= 196608) goto L7;
        return false;
    L7:
        return true;
    L12:
        return false;
    }

    public static final void d(Context r100) {
        ConcurrentHashMap<String, Object> r101 = f246472a;
        if (r101.isEmpty() == false) goto L9;
        if (r100 != null) goto L6;
        r100 = h.f246501h.f246503b;
    L6:
        if (r100 == null) goto L10;
        boolean r102 = b(r100);
        ExecutorService r103 = BulletLogger.f247763a;
        BulletLogger.k("getDeviceProps: isGLES3Support=" + r102, null, null, 6);
        List<String> r104 = a.f487988a;
        String r105 = Build.MODEL;
        r101.put("deviceModel", r105);
        r101.put("os", "android");
        r101.put("osVersion", Build.VERSION.RELEASE);
        r101.put("language", a.e());
        r101.put("deviceBrand", Build.BRAND);
        r101.put("glesVer", Integer.valueOf(a.d(r100)));
        r101.put("is32", Integer.valueOf(a.k() ? 1 : 0));
        r101.put("density", Float.valueOf(a.b(r100)));
        r101.put("isAccessable", Integer.valueOf(a.l(r100) ? 1 : 0));
        r101.put(IConstValues.DEVICE_TYPE, r105);
        r101.put("isGLES3Support", Boolean.valueOf(r102));
        r101.put("slardarModel", c());
        AnnieXRuntime.b().getClass();
        r101.put("isFoldableDevice", 0);
        AnnieXRuntime.b().getClass();
        return;
    L10:
        return;
    }

    public static final Map<String, Object> getContainerProps(Context r100, Integer r101) {
        com.bytedance.ies.bullet.service.base.h.w();
        if (r100 != null) goto L6;
        return null;
    L6:
        Activity r102 = o16.a.a(r100);
        if (r102 == null) goto L13;
        Window r103 = r102.getWindow();
        if (r103 == null) goto L13;
        View r104 = a(r103);
        if (r104 == null) goto L13;
        int r105 = r104.getWidth();
        int r106 = r104.getHeight();
    L14:
        if (r105 <= 0) goto L17;
        if (r106 <= 0) goto L17;
    L35:
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("containerWidth", Integer.valueOf(a.m(r105, r100))), TuplesKt.to("containerHeight", Integer.valueOf(a.m(r106, r100)))});
    L17:
        if ((r100 instanceof MutableContextWrapper) == true) goto L19;
    L29:
        Resources r107 = r100.getResources();
        if (r107 == null) goto L35;
        DisplayMetrics r108 = WindowDisplayMetricsOverride.apply(r107, r107.getDisplayMetrics());
        if (r108 == null) goto L35;
        r105 = r108.widthPixels;
        r106 = r108.heightPixels;
        goto L35
    L19:
        if (FlowContainerLoaderSwitch.INSTANCE.enableAnnieXFlowLoader() == false) goto L29;
        Resources r109 = ((MutableContextWrapper) r100).getResources();
        if (r109 == null) goto L35;
        DisplayMetrics r110 = WindowDisplayMetricsOverride.apply(r109, r109.getDisplayMetrics());
        if (r110 == null) goto L35;
        r105 = r110.widthPixels;
        if (r101 == null) goto L27;
        int r111 = r101.intValue();
    L28:
        r106 = r111;
        goto L35
    L27:
        r111 = r110.heightPixels;
    L13:
        r106 = 0;
        r105 = 0;
        goto L14
    }

    public static final Map<String, Object> getPageCommonProps(Context r110, j r111) {
        LinkedHashMap r100 = new LinkedHashMap();
        if (r110 != null) goto L102;
    L86:
        return r100;
    L102:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L13
        int r102 = a.f(r110);     // Catch: Throwable -> L13
        int r103 = a.i(r110);     // Catch: Throwable -> L11
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L17:
        boolean r104 = true;
        int r105 = a.j(r110);     // Catch: Throwable -> L65
    L63:
        th = th;
    L67:
        int r106 = r105;
        int r107 = 0;
        int r108 = 0;
        int r112 = 0;
    L68:
        Result.Companion r113 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        int r114 = r107;
        r102 = r108;
        r105 = r106;
        r112 = r112;
    L70:
        if (r110.getResources().getConfiguration().orientation == 2) goto L74;
        r104 = false;
    L74:
        if (r104 == false) goto L76;
        LinkedHashMap r115 = new LinkedHashMap();
        r115.put("marginTop", 0);
        r115.put("marginBottom", 0);
        r115.put("marginLeft", Integer.valueOf(a.m(r105, r110)));
        r115.put("marginRight", Integer.valueOf(a.m(r112, r110)));
        r100.put("safeArea", r115);
        int r109 = r102;
    L77:
        r100.put("topHeight", Integer.valueOf(a.m(r105, r110)));
        r100.put("bottomHeight", Integer.valueOf(a.m(r112, r110)));
        int r116 = a.m(r114, r110);
        int r117 = a.m(r103, r110);
        r100.put("contentHeight", Integer.valueOf(r116));
        r100.put("contentWidth", Integer.valueOf(r117));
        r100.put("safeAreaHeight", Integer.valueOf(a.m(r109, r110)));
        if (r104 == false) goto L80;
        String r118 = "landscape";
    L81:
        r100.put("screenOrientation", r118);
        AnnieXRuntime.b().getClass();
        AnnieXRuntime.b().getClass();
        Map<String, Object> r119 = getContainerProps(r110, Integer.valueOf(r114));
        if (r119 == null) goto L86;
        r100.putAll(r119);
        if (com.bytedance.ies.bullet.service.base.h.E() == false) goto L86;
        AnnieXRuntime.b().getClass();
        AnnieXRuntime.b().getClass();
        goto L86
    L80:
        r118 = "portrait";
        goto L81
    L76:
        int r120 = r102;
        LinkedHashMap r121 = new LinkedHashMap();
        r121.put("marginTop", Integer.valueOf(a.m(r105, r110)));
        r109 = r120;
        r121.put("marginBottom", Integer.valueOf(a.m(r112, r110)));
        r121.put("marginLeft", 0);
        r121.put("marginRight", 0);
        r100.put("safeArea", r121);
        goto L77
    L20:
        if ((r110 instanceof Activity) == false) goto L38;
        Rect r122 = new Rect();     // Catch: Throwable -> L63
        View r123 = a(((Activity) r110).getWindow());     // Catch: Throwable -> L63
        r123.getWindowVisibleDisplayFrame(r122);     // Catch: Throwable -> L63
        int r124 = r123.getHeight();     // Catch: Throwable -> L63
        int r125 = r122.top;     // Catch: Throwable -> L63
        int r126 = r122.bottom;     // Catch: Throwable -> L63
        if (r124 != 0) goto L25;
        if (r125 != 0) goto L25;
        r126 = r126 + r105;     // Catch: Throwable -> L63
    L25:
        r112 = Math.max(r102 - r126, 0);     // Catch: Throwable -> L63
        r107 = Math.max((r102 - r112) - r105, 0);     // Catch: Throwable -> L34
        int r127 = r122.height();     // Catch: Throwable -> L32
        if (r125 >= r105) goto L31;
        r127 = r127 - r105;
    L31:
        r114 = r107;
        r102 = r127;
    L59:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L61
    L61:
        th = th;
        r112 = r112;
        r106 = r105;
        r108 = r102;
        r107 = r114;
    L32:
        th = th;
    L36:
        r106 = r105;
        r108 = 0;
    L34:
        th = th;
        r107 = 0;
        goto L36
    L38:
        if ((r110 instanceof MutableContextWrapper) == true) goto L40;
    L58:
        r102 = 0;
        r112 = 0;
        r114 = 0;
        goto L59
    L40:
        if (FlowContainerLoaderSwitch.INSTANCE.enableAnnieXFlowLoader() == false) goto L58;
        Context r128 = ((MutableContextWrapper) r110).getApplicationContext();     // Catch: Throwable -> L63
    L55:
        th = th;
        r102 = 0;
        r112 = 0;
        r114 = 0;
    L87:
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L61
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L61
        goto L59
    L43:
        if (r128.getResources().getConfiguration().orientation != 2) goto L45;
        boolean r130 = true;
    L46:
        int r131 = i16.c.f487996a.h(r128);     // Catch: Throwable -> L55
        r114 = (r102 - r131) - r105;
        if (r130 == true) goto L93;
        r102 = (r102 - r105) - r131;
    L93:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L53
        r112 = r131;
    L53:
        th = th;
        r112 = r131;
        goto L87
    L45:
        r130 = false;
    L65:
        th = th;
        r105 = 0;
    L9:
        th = th;
    L16:
        Result.Companion r132 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L11:
        th = th;
    L15:
        r103 = 0;
    L13:
        th = th;
        r102 = 0;
        goto L15
    }

    public static final Map<String, Object> getDeviceProps(KitType r110, Context r111, BulletContext r112) {
        Intrinsics.checkNotNullParameter(r110, "kitType");
        if (r111 != null) goto L5;
        return null;
    L5:
        List<String> r100 = a.f487988a;
        Resources r101 = r111.getResources();
        a.f487990c = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density;
        long r102 = System.currentTimeMillis();
        d r103 = d.f540305c;
        m0 r104 = (m0) d.f540305c.c(m0.class);
        if (r104 == null) goto L8;
        r104.a0();
    L8:
        m0 r105 = (m0) d.f540305c.c(m0.class);
        if (r105 == null) goto L11;
        r105.a0();
    L11:
        boolean r106 = b(r111);
        ExecutorService r107 = BulletLogger.f247763a;
        BulletLogger.k("getDeviceProps: isGLES3Support=" + r106, null, null, 6);
        String r108 = Build.MODEL;
        AnnieXRuntime.b().getClass();
        Map<String, Object> r109 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("screenWidth", Integer.valueOf(a.m(a.i(r111), r111))), TuplesKt.to("screenHeight", Integer.valueOf(a.m(a.f(r111), r111))), TuplesKt.to("statusBarHeight", Integer.valueOf(a.m(a.j(r111), r111))), TuplesKt.to("deviceModel", r108), TuplesKt.to("os", "android"), TuplesKt.to("osVersion", Build.VERSION.RELEASE), TuplesKt.to("language", a.e()), TuplesKt.to("deviceBrand", Build.BRAND), TuplesKt.to("glesVer", Integer.valueOf(a.d(r111))), TuplesKt.to("is32", Integer.valueOf(a.k() ? 1 : 0)), TuplesKt.to("density", Float.valueOf(a.b(r111))), TuplesKt.to("isAccessable", Integer.valueOf(a.l(r111) ? 1 : 0)), TuplesKt.to(IConstValues.DEVICE_TYPE, r108), TuplesKt.to("isGLES3Support", Boolean.valueOf(r106)), TuplesKt.to("slardarModel", c()), TuplesKt.to("isFoldableDevice", 0)});
        AnnieXRuntime.b().getClass();
        AnnieXRuntime.b().getClass();
        AnnieXRuntime.b().getClass();
        a.f487989b = false;
        long r113 = System.currentTimeMillis();
        c1 r114 = new c1("bullet_global_props_cost", null, null, null, null, 254);
        if (r112 == null) goto L14;
        a36.a r115 = r112.f246449q;
    L15:
        r114.f247801k = r115;
        JSONObject r116 = new JSONObject();
        r116.put("device_props_cost", Math.max(0, r113 - r102));
        r116.put("global_props_cache_optimize", 0);
        r114.f247795e = r116;
        d r117 = d.f540305c;
        if (r112 == null) goto L19;
        String r118 = r112.f246438f;
        if (r118 == null) goto L19;
    L20:
        r r119 = (r) r117.d(r118, r.class);
        if (r119 == null) goto L24;
        r119.S(r114);
    L24:
        if (TypeIntrinsics.isMutableMap(r109) == true) goto L26;
        return null;
    L26:
        return r109;
    L19:
        r118 = "default_bid";
        goto L20
    L14:
        r115 = null;
        goto L15
    }

    public static final Map<String, Object> getPageCommonProps(Context r100, boolean r101, j r102) {
        if (r101 == true) goto L5;
        LinkedHashMap r103 = new LinkedHashMap();
        r103.putAll(getPageCommonProps(r100, r102));
        r103.remove("safeAreaHeight");
        return r103;
    L5:
        return getPageCommonProps(r100, r102);
    }
}
