package com.bytedance.android.shopping.store.router;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.store.common.const.VolumeTypes;
import com.bytedance.android.ec.store.product.ECStoreSettingsValuePreloader;
import com.bytedance.android.ec.store.utils.taskmanager.ECTaskManager;
import com.bytedance.android.ec.store.utils.taskmanager.TaskPriority;
import com.bytedance.android.livesdk.ec.adapter.api.FloatWindowState;
import com.bytedance.android.livesdk.ec.adapter.api.Scene;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.home.api.StoreUIParam;
import com.bytedance.android.shopping.store.lifecycle.ECStorePerfMonitor;
import com.bytedance.android.shopping.store.lifecycle.StoreLynxResourcePreloadLifecycle;
import com.bytedance.android.shopping.store.lifecycle.g;
import com.bytedance.android.shopping.store.lifecycle.h;
import com.bytedance.android.shopping.store.lifecycle.j;
import com.bytedance.android.shopping.store.lifecycle.k;
import com.bytedance.android.shopping.store.lifecycle.l;
import com.bytedance.android.shopping.store.lifecycle.m;
import com.bytedance.android.shopping.store.lifecycle.n;
import com.bytedance.android.shopping.store.lifecycle.p;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.reflect.Method;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import sk3.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements bf.c {
    public a() {
    }

    public final void a() {
    }

    public final String b() {
        return "goods/store";
    }

    public final boolean c(final Context r12, final Uri r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "uri");
        int r2 = ShopHelper.a;
        Intrinsics.checkNotNullParameter(r13, "uri");
        long r1 = System.currentTimeMillis();
        if (r12 == null) goto L86;
        Map<Long, m> r4 = com.bytedance.android.shopping.store.lifecycle.a.a;
        Intrinsics.checkNotNullParameter(r12, "context");
        final long r7 = System.currentTimeMillis();
        m r0 = new m(r12.getClass().getName());
        r0.U(new l());
        r0.U(new h());
        r0.U(new p(r7));
        r0.U(new StoreLynxResourcePreloadLifecycle(r7));
        r0.U(new k());
        r0.U(new n());
        r0.U(new j());
        com.bytedance.android.shopping.store.lifecycle.a.a.put(Long.valueOf(r7), r0);
        int r3 = ECStorePerfMonitor.n;
        ECStorePerfMonitor r5 = ECStorePerfMonitor.a.a(Long.valueOf(r7));
        if (r5 == null) goto L10;
        g r6 = r5.k;
        if (r6 == null) goto L10;
        r6.c(1, Long.valueOf(r1));
    L10:
        int r8 = ECSdk.a;
        s83.g r9 = (s83.g) ECSdk.a(s83.g.class);
        if (r9 == null) goto L13;
        r9.j0("startFromSchema," + r12);
    L13:
        Resources r10 = Resources.getSystem();
        float r11 = WindowDisplayMetricsOverride.apply(r10, r10.getDisplayMetrics()).widthPixels;
        Resources r15 = Resources.getSystem();
        float r16 = WindowDisplayMetricsOverride.apply(r15, r15.getDisplayMetrics()).heightPixels;
        if (ECShopABSettings.e() == 1) goto L16;
    L18:
        boolean r17 = false;
    L19:
        if (r17 == true) goto L90;
    L27:
        int r18 = ECSdk.a;
        s83.g r19 = (s83.g) ECSdk.a(s83.g.class);
        if (r19 == null) goto L30;
        r19.z();
    L30:
        ph.a.a(r12);
        Map<Long, m> r20 = com.bytedance.android.shopping.store.lifecycle.a.a;
        m r21 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(r7));
        if (r21 == null) goto L34;
        r21.m(r12);
    L34:
        if (d.a(r12, r13) == false) goto L86;
        final String r22 = UriProtector.getQueryParameter(r13, "toast_msg");
        if (r22 != null) goto L40;
        r22 = "";
    L40:
        if (com.bytedance.android.shopping.extensions.k.c(r22) == false) goto L43;
        Lazy r23 = ECTaskManager.b;
        ECTaskManager.a.a().a(r7, TaskPriority.AFTER_FIRST_SCREEN, new ShopHelper$startFromSchema$1(r12, r22));
    L43:
        if ((r12 instanceof Activity) == true) goto L45;
        Context r24 = null;
    L46:
        final ECStoreParam r25 = ShopHelper.c(r13, (Activity) r24);
        r25.setLifecycleMonitorId(r7);
        StoreUIParam r26 = r25.getStoreUIParam();
        Integer r27 = r25.getStoreUIParam().getVolume();
        IAdapterService r28 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r28 == null) goto L49;
        wu1.a r29 = r28.getECLiveStateController();
    L50:
        if (r29 == null) goto L52;
        r29.a(Scene.SHOP);
    L52:
        VolumeTypes r30 = VolumeTypes.MUTE;
        int r31 = r30.getType();
        if (r27 != null) goto L56;
    L57:
        int r32 = VolumeTypes.UNMUTE.getType();
        if (r27 != null) goto L61;
    L63:
        boolean r33 = ECServiceManager.a;
        boolean r34 = !Intrinsics.areEqual(((s83.g) ECServiceManager.c(s83.g.class)).hasLivePlayingMute(), Boolean.FALSE);
    L71:
        r26.setLiveDefaultMute(r34);
        StoreUIParam r35 = r25.getStoreUIParam();
        IAdapterService r36 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r36 == null) goto L78;
        wu1.a r37 = r36.getECLiveStateController();
        if (r37 == null) goto L78;
        Scene r38 = Scene.LIVE;
        Pair r39 = r37.c();
        if (r39 == null) goto L78;
        FloatWindowState r40 = (FloatWindowState) r39.getFirst();
    L80:
        if (r40 == FloatWindowState.STOP) goto L82;
        boolean r41 = true;
    L83:
        r35.setCanShowFloatLive(r41);
        ECStoreSettingsValuePreloader.a();
        com.bytedance.android.ec.core.utils.n.b(r12, r14, null, new ShopHelper$getUserInfoAndStartStore$1(r25, r7, r12, r13), new ShopHelper$getUserInfoAndStartStore$2(r12, r13));
        if (ECAppInfoService.e.isDebug() == false) goto L86;
        Method r110 = ShopHelper.a().getDeclaredMethod("putBoolean", new Class[]{String.class, Boolean.TYPE});     // Catch: Exception -> L87
        r110.setAccessible(true);     // Catch: Exception -> L87
        Boolean r42 = Boolean.TRUE;     // Catch: Exception -> L87
        r110.invoke(null, new Object[]{"security_disable_lynx_jsb_auth", r42});     // Catch: Exception -> L87
        r110.invoke(null, new Object[]{"security_disable_lynx_sign_verify", r42});     // Catch: Exception -> L87
        goto L86
    L82:
        r41 = false;
    L78:
        r40 = null;
        goto L80
    L61:
        if (r27.intValue() != r32) goto L63;
    L64:
        int r43 = r30.getType();
        if (r27 != null) goto L68;
    L70:
        r34 = false;
        goto L71
    L68:
        if (r27.intValue() != r43) goto L70;
        r34 = true;
        goto L71
    L56:
        if (r27.intValue() == r31) goto L64;
    L49:
        r29 = null;
        goto L50
    L45:
        r24 = r12;
        goto L46
    L90:
        Context r44 = r12.getApplicationContext();     // Catch: Exception -> L25
        if (r44 != null) goto L23;
        r44 = wk3.b.b();     // Catch: Exception -> L25
    L23:
        e r45 = e.u;     // Catch: Exception -> L25
        r45.b((Application) r44);     // Catch: Exception -> L25
        r45.m = false;     // Catch: Exception -> L25
        r45.o = true;     // Catch: Exception -> L25
        c r46 = new c(r44);     // Catch: Exception -> L25
        Intrinsics.checkNotNullParameter(r46, "onAdaptListener");     // Catch: Exception -> L25
        r45.r = r46;     // Catch: Exception -> L25
    L25:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
        int r47 = wk3.a.a;
        wk3.a.a("InitProvider_init_failed," + e);
        goto L27
    L16:
        if ((r11 / RangesKt.coerceAtLeast(r16, 1.0f)) >= 0.7d) goto L18;
        r17 = true;
    L86:
        return true;
    }
}
