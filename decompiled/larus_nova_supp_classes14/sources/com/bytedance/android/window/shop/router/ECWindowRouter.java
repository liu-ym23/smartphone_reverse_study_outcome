package com.bytedance.android.window.shop.router;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.DisplayMetrics;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.base.settings.d;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.monitor.l;
import com.bytedance.android.ec.core.monitor.o;
import com.bytedance.android.ec.core.utils.n;
import com.bytedance.android.ec.core.vmsdk.VmSdkSetting;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.window.base.utils.taskmanager.ECWindowTaskManager;
import com.bytedance.android.window.shop.home.tab.common.WindowConstDef;
import com.bytedance.android.window.shop.lifecycle.WindowPrefMonitorLifecycle;
import com.bytedance.android.window.shop.lifecycle.f;
import com.bytedance.android.window.shop.lifecycle.h;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import lp.e;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowRouter implements bf.c {

    public static final class a implements np.b {
        public a() {
        }

        public final void a(Object r4, Activity r5) {
            int r0 = pp.a.a;
            StringBuilder r1 = new StringBuilder("onAdaptAfter:target=");
            Integer r2 = null;
            if (r4 == null) goto L5;
            String r6 = r4.getClass().getSimpleName();
        L6:
            r1.append(r6);
            r1.append(",density=");
            if (r5 == null) goto L13;
            Resources r7 = th.a.f(r5);
            if (r7 == null) goto L13;
            DisplayMetrics r8 = WindowDisplayMetricsOverride.apply(r7, r7.getDisplayMetrics());
            if (r8 == null) goto L13;
            Float r9 = Float.valueOf(r8.density);
        L14:
            r1.append(r9);
            r1.append(",densityDPI=");
            if (r5 == null) goto L21;
            Resources r10 = th.a.f(r5);
            if (r10 == null) goto L21;
            DisplayMetrics r11 = WindowDisplayMetricsOverride.apply(r10, r10.getDisplayMetrics());
            if (r11 == null) goto L21;
            r2 = Integer.valueOf(r11.densityDpi);
        L21:
            r1.append(r2);
            pp.a.a(r1.toString());
            return;
        L13:
            r9 = null;
            goto L14
        L5:
            r6 = null;
            goto L6
        }

        public final void b(Object r4, Activity r5) {
            int r0 = pp.a.a;
            StringBuilder r1 = new StringBuilder("onAdaptBefore:target=");
            Integer r2 = null;
            if (r4 == null) goto L5;
            String r6 = r4.getClass().getSimpleName();
        L6:
            r1.append(r6);
            r1.append(",density=");
            if (r5 == null) goto L13;
            Resources r7 = th.a.f(r5);
            if (r7 == null) goto L13;
            DisplayMetrics r8 = WindowDisplayMetricsOverride.apply(r7, r7.getDisplayMetrics());
            if (r8 == null) goto L13;
            Float r9 = Float.valueOf(r8.density);
        L14:
            r1.append(r9);
            r1.append(",densityDPI=");
            if (r5 == null) goto L21;
            Resources r10 = th.a.f(r5);
            if (r10 == null) goto L21;
            DisplayMetrics r11 = WindowDisplayMetricsOverride.apply(r10, r10.getDisplayMetrics());
            if (r11 == null) goto L21;
            r2 = Integer.valueOf(r11.densityDpi);
        L21:
            r1.append(r2);
            pp.a.a(r1.toString());
            return;
        L13:
            r9 = null;
            goto L14
        L5:
            r6 = null;
            goto L6
        }
    }

    public ECWindowRouter() {
    }

    public final void a() {
    }

    public final String b() {
        return "goods/shop";
    }

    public final void d(Uri r6, Context r7) {
        Intrinsics.checkNotNullParameter(r6, "uri");
        Intrinsics.checkNotNullParameter(r7, "context");
        int r0 = l.a;
        String r1 = r6.toString();
        String r2 = UriProtector.getQueryParameter(r6, "enter_from");
        if (r2 != null) goto L5;
        r2 = "click_open_url";
    L5:
        l.a(r1, r2, "shop", CollectionsKt.listOf(new l.a("uid", "presence")));
        int r3 = ECSdk.a;
        o r4 = (o) ECSdk.a(o.class);
        if (r4 == null) goto L9;
        o.a.a(r4, r7, "window_page", r6.toString(), VmSdkSetting.a().j());
        return;
    }

    public final boolean c(final Context r11, final Uri r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "uri");
        Resources r2 = Resources.getSystem();
        float r3 = WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics()).widthPixels;
        Resources r4 = Resources.getSystem();
        float r5 = WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()).heightPixels;
        int r6 = 0;
        if (WindowConstDef.e == true) goto L5;
    L9:
        boolean r7 = false;
    L10:
        if (r7 == true) goto L210;
    L18:
        Map<String, String> r8 = b.a;
        Intrinsics.checkNotNullParameter(r12, "uri");
        Object r1 = null;
        if (r11 == null) goto L28;
        ConcurrentHashMap<Long, f> r9 = com.bytedance.android.window.shop.lifecycle.c.a;
        Intrinsics.checkNotNullParameter(r11, "context");
        String r0 = r11.getClass().getName();
        Intrinsics.checkNotNullParameter(r0, "name");
        final long r10 = System.currentTimeMillis();
        f r14 = new f(r6);
        WindowPrefMonitorLifecycle r15 = new WindowPrefMonitorLifecycle(r0);
        Intrinsics.checkNotNullParameter(r15, "lifeCycle");
        r14.a.add(r15);
        if (ECSettingKeys.c0() != 1) goto L24;
        h r16 = new h();
        Intrinsics.checkNotNullParameter(r16, "lifeCycle");
        r14.a.add(r16);
    L24:
        Intrinsics.checkNotNullParameter(r14, "windowLifecycleMonitor");
        com.bytedance.android.window.shop.lifecycle.c.a.put(Long.valueOf(r10), r14);
        f r17 = com.bytedance.android.window.shop.lifecycle.c.a(r10);
        if (r17 == null) goto L27;
        r17.v();
    L27:
        n.b(r11, r13, null, new WindowHelper$getUserInfoAndStartStore$1(r12, r10), WindowHelper$getUserInfoAndStartStore$2.INSTANCE);
    L28:
        int r18 = yq3.a.a;
        int r19 = com.bytedance.android.ec.core.opt.ab.n.a;
        Object r20 = 0;
        int r21 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L185
        Object r23 = d.c.get("window_opt_vmsdk_async");     // Catch: Throwable -> L79
        if (r23 != null) goto L34;
    L76:
        Object r24 = null;
    L77:
        Object r25 = Result.constructor-impl(r24);     // Catch: Throwable -> L79
    L81:
        Throwable r26 = Result.exceptionOrNull-impl(r25);     // Catch: Throwable -> L185
        if (r26 == null) goto L85;
        EnsureManager.ensureNotReachHere(r26);     // Catch: Throwable -> L185
    L85:
        if (Result.isFailure-impl(r25) == false) goto L88;
        r25 = null;
    L88:
        if ((r25 instanceof Integer) == true) goto L90;
        r25 = null;
    L90:
        Object r27 = (Integer) r25;     // Catch: Throwable -> L185
        if (r27 != null) goto L97;
        Object r28 = d.a.get("window_opt_vmsdk_async");     // Catch: Throwable -> L185
        if ((r28 instanceof Integer) == true) goto L96;
        r28 = null;
    L96:
        r27 = (Integer) r28;     // Catch: Throwable -> L185
    L97:
        if (r27 != null) goto L195;
        int r29 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L185
        Object r30 = d.c.get("window_opt_vmsdk_async");     // Catch: Throwable -> L149
        if (r30 != null) goto L104;
    L146:
        Object r31 = null;
    L147:
        Object r32 = Result.constructor-impl(r31);     // Catch: Throwable -> L149
    L151:
        Throwable r33 = Result.exceptionOrNull-impl(r32);     // Catch: Throwable -> L175
        if (r33 == null) goto L155;
        EnsureManager.ensureNotReachHere(r33);     // Catch: Throwable -> L175
    L155:
        if (Result.isFailure-impl(r32) == false) goto L158;
        r32 = null;
    L158:
        if ((r32 instanceof Integer) == true) goto L160;
        r32 = null;
    L160:
        r27 = (Integer) r32;     // Catch: Throwable -> L175
        if (r27 != null) goto L183;
        IHybridHostService r34 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L175
        if (r34 == null) goto L166;
        Object r35 = r34.getHostABValue("window_opt_vmsdk_async", r20);     // Catch: Throwable -> L175
    L167:
        if (r35 != null) goto L169;
    L174:
        r27 = r20;
        goto L183
    L169:
        if ((r35 instanceof Integer) == false) goto L172;
        r1 = r35;
    L172:
        Object r36 = (Integer) r1;     // Catch: Throwable -> L175
        if (r36 == null) goto L174;
    L182:
        r27 = r36;
        goto L183
    L166:
        r35 = null;
    L183:
        d.d("window_opt_vmsdk_async", r27);     // Catch: Throwable -> L185
        goto L195
    L104:
        if ((r30 instanceof Integer) == true) goto L106;
        Object r37 = null;
    L107:
        r31 = (Integer) r37;     // Catch: Throwable -> L149
        if (r31 != null) goto L147;
        if ((r30 instanceof Number) == false) goto L134;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L119;
        Float r38 = Float.valueOf(((Number) r30).floatValue());     // Catch: Throwable -> L149
        if ((r38 instanceof Integer) == true) goto L117;
        r38 = null;
    L117:
        r31 = (Integer) r38;     // Catch: Throwable -> L149
        goto L147
    L119:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L125;
        Double r39 = Double.valueOf(((Number) r30).doubleValue());     // Catch: Throwable -> L149
        if ((r39 instanceof Integer) == true) goto L123;
        r39 = null;
    L123:
        r31 = (Integer) r39;     // Catch: Throwable -> L149
        goto L147
    L125:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L128;
        r31 = Integer.valueOf(((Number) r30).intValue());     // Catch: Throwable -> L149
        goto L147
    L128:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L134;
        Long r40 = Long.valueOf(((Number) r30).longValue());     // Catch: Throwable -> L149
        if ((r40 instanceof Integer) == true) goto L132;
        r40 = null;
    L132:
        r31 = (Integer) r40;     // Catch: Throwable -> L149
    L134:
        if ((r30 instanceof JSONObject) == false) goto L136;
    L201:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L142
        Object r41 = SDKSettingsCacheManager.a().fromJson(r30.toString(), Integer.class);     // Catch: Throwable -> L142
        if ((r41 instanceof Integer) == true) goto L140;
        r41 = null;
    L140:
        Object r42 = Result.constructor-impl((Integer) r41);     // Catch: Throwable -> L142
    L144:
        r31 = r42;
        if (Result.isFailure-impl(r31) == false) goto L147;
    L142:
        th = move-exception;
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L149
        r42 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L149
        goto L144
    L136:
        if ((r30 instanceof JSONArray) == false) goto L146;
    L106:
        r37 = r30;
    L175:
        th = move-exception;
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L185
        r36 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L185
        Throwable r45 = Result.exceptionOrNull-impl(r36);     // Catch: Throwable -> L185
        if (r45 == null) goto L180;
        EnsureManager.ensureNotReachHere(r45);     // Catch: Throwable -> L185
    L180:
        if (Result.isFailure-impl(r36) == false) goto L182;
        r36 = r20;
    L149:
        th = move-exception;
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L175
        r32 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L175
    L195:
        if (((Number) r27).intValue() != 1) goto L197;
        Lazy r110 = ECWindowTaskManager.a;
        ECWindowTaskManager r111 = ECWindowTaskManager.a.a();
        Function0<Unit> r47 = new ECWindowRouter$open$2(this, r12, r11);
        r111.getClass();
        ECWindowTaskManager.a(r47);
    L198:
        return true;
    L197:
        d(r12, r11);
        goto L198
    L34:
        if ((r23 instanceof Integer) == true) goto L36;
        Object r48 = null;
    L37:
        r24 = (Integer) r48;     // Catch: Throwable -> L79
        if (r24 != null) goto L77;
        if ((r23 instanceof Number) == false) goto L64;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L49;
        Float r49 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L79
        if ((r49 instanceof Integer) == true) goto L47;
        r49 = null;
    L47:
        r24 = (Integer) r49;     // Catch: Throwable -> L79
        goto L77
    L49:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L55;
        Double r50 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L79
        if ((r50 instanceof Integer) == true) goto L53;
        r50 = null;
    L53:
        r24 = (Integer) r50;     // Catch: Throwable -> L79
        goto L77
    L55:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L58;
        r24 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L79
        goto L77
    L58:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L64;
        Long r51 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L79
        if ((r51 instanceof Integer) == true) goto L62;
        r51 = null;
    L62:
        r24 = (Integer) r51;     // Catch: Throwable -> L79
    L64:
        if ((r23 instanceof JSONObject) == false) goto L66;
    L199:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L72
        Object r52 = SDKSettingsCacheManager.a().fromJson(r23.toString(), Integer.class);     // Catch: Throwable -> L72
        if ((r52 instanceof Integer) == true) goto L70;
        r52 = null;
    L70:
        Object r53 = Result.constructor-impl((Integer) r52);     // Catch: Throwable -> L72
    L74:
        r24 = r53;
        if (Result.isFailure-impl(r24) == false) goto L77;
    L72:
        th = move-exception;
        Result.Companion r54 = Result.Companion;     // Catch: Throwable -> L79
        r53 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L79
        goto L74
    L66:
        if ((r23 instanceof JSONArray) == false) goto L76;
    L36:
        r48 = r23;
    L79:
        th = move-exception;
        Result.Companion r55 = Result.Companion;     // Catch: Throwable -> L185
        r25 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L185
    L185:
        th = move-exception;
        Result.Companion r56 = Result.Companion;
        Object r112 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r57 = Result.exceptionOrNull-impl(r112);
        if (r57 == null) goto L190;
        EnsureManager.ensureNotReachHere(r57);
    L190:
        if (Result.isFailure-impl(r112) == true) goto L193;
        r20 = r112;
    L193:
        r27 = r20;
        goto L195
    L210:
        Context r58 = r11.getApplicationContext();     // Catch: Exception -> L16
        if (r58 != null) goto L14;
        r58 = pp.b.b();     // Catch: Exception -> L16
    L14:
        e r59 = e.u;     // Catch: Exception -> L16
        r59.b((Application) r58);     // Catch: Exception -> L16
        r59.m = false;     // Catch: Exception -> L16
        r59.o = true;     // Catch: Exception -> L16
        a r60 = new a();     // Catch: Exception -> L16
        Intrinsics.checkNotNullParameter(r60, "onAdaptListener");     // Catch: Exception -> L16
        r59.r = r60;     // Catch: Exception -> L16
    L16:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
        int r61 = pp.a.a;
        pp.a.a("InitProvider_init_failed," + e);
        goto L18
    L5:
        if ((r3 / RangesKt.coerceAtLeast(r5, 1.0f)) >= 0.7d) goto L9;
        if (r3 <= com.bytedance.android.shopping.extensions.b.b(390)) goto L9;
        r7 = true;
        goto L10
    }
}
