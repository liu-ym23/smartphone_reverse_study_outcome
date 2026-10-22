package com.bytedance.android.shopping.mall.homepage;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.ec.hybrid.data.ECHybridDataEngine;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.opt.ImageResizeOpt;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.shopping.api.mall.IECMallHomepageService;
import com.bytedance.android.shopping.api.mall.IECNativeContainerLoadState$MallState;
import com.bytedance.android.shopping.api.mall.IECNativeHomeArgument;
import com.bytedance.android.shopping.api.mall.IECNativeHomeService;
import com.bytedance.android.shopping.api.mall.homepage.ECMallDeliveryReduceConfig;
import com.bytedance.android.shopping.api.mall.opt.ECDeepFeedDomainPreConnectUtil;
import com.bytedance.android.shopping.api.mall.preload.resource.ECMallResourcePreloader;
import com.bytedance.android.shopping.mall.homepage.card.ECMallLoginGuideCard;
import com.bytedance.android.shopping.mall.homepage.chunked.HomepageChunkedCallback;
import com.bytedance.android.shopping.mall.homepage.opt.MallDrainageOpt;
import com.bytedance.android.shopping.mall.homepage.tools.DataEngineWrapper;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.common.lib.AppLogNewUtils;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.thread.ThreadPoolHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallFragment$initListEngine$6 implements yj.b {
    public boolean a;
    public final /* synthetic */ ECMallFragment b;

    public static final class a implements Runnable {
        public final /* synthetic */ ECMallFragment$initListEngine$6 a;

        public a(ECMallFragment$initListEngine$6 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            IHybridHostService r0 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L8
            if (r0 == null) goto L11;
            yj.l r1 = r0.getIHybridHostFrescoService();     // Catch: Throwable -> L8
            if (r1 == null) goto L15;
            this.a.b.getContext();     // Catch: Throwable -> L8
            r1.e();     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    public final void b() {
        ECMallFragment r0 = this.b;
        int r1 = ECMallFragment.h4;
        if (r0.ja0() != null) goto L5;
        return;
    L5:
        if (com.bytedance.android.shopping.mall.homepage.opt.e.a() == true) goto L7;
        return;
    L7:
        if (this.a == true) goto L22;
        Lazy r2 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.m.a.b, "onRealStraightOutDrawEnd");
        this.b.p0.c();
        this.a = true;
        com.bytedance.android.shopping.mall.homepage.opt.e r3 = this.b.ja0();
        if (r3 == null) goto L23;
        Integer r4 = com.bytedance.android.shopping.mall.homepage.opt.e.e.a();
        if (r4 != null) goto L14;
    L16:
        Object r5 = r3.a;
        monitor-enter(r5);
        monitor-exit(r5);
        return;
    L14:
        if (r4.intValue() != 2) goto L16;
        int r6 = com.bytedance.android.shopping.mall.homepage.opt.h.a;
        goto L16
    L23:
        return;
    }

    public ECMallFragment$initListEngine$6(ECMallFragment r1, IECNativeHomeArgument r2) {
        this.b = r1;
    }

    public final void a(long r94, final long r96, com.bytedance.android.ec.hybrid.list.util.d r98) {
        Intrinsics.checkNotNullParameter(r98, "lynxLoadResult");
        Lazy r0 = ECMallLogUtil.a;
        com.bytedance.android.ec.hybrid.log.mall.m.a r1 = com.bytedance.android.ec.hybrid.log.mall.m.a.b;
        ECMallLogUtil.c(r1, "first screen call back lynxloadResut is " + r98);
        this.b.startPostponedEnterTransition();
        ECMallFragment r7 = this.b;
        int r8 = ECMallFragment.h4;
        r7.getClass();
        if (Intrinsics.areEqual(r98.k, "cache") == false) goto L43;
        ECMallFragment r9 = this.b;
        IECNativeContainerLoadState$MallState r13 = IECNativeContainerLoadState$MallState.INIT;
        r9.getClass();
        ECMallLogUtil.c(r1, "render with cached data finished");
        this.b.K = Boolean.TRUE;
        Runnable r2 = this.b.M;
        if (r2 == null) goto L7;
        r2.run();
    L7:
        this.b.M = null;
        lf3.b r3 = (lf3.b) this.b.k0.getValue();
        if (r3 == null) goto L10;
        r3.c = Long.valueOf(r96);
    L10:
        DataEngineWrapper r4 = this.b.L0;
        if (r4 == null) goto L13;
        r4.w(r96);
    L13:
        DataEngineWrapper r5 = this.b.L0;
        if (r5 == null) goto L16;
        r5.y(r98.d);
    L16:
        DataEngineWrapper r6 = this.b.L0;
        if (r6 == null) goto L19;
        r6.x(r98.e);
    L19:
        Logger.d("peive", "FirstScreen_cache_time:" + r94 + "\nlynxLoadResult:" + r98);
        if (this.a == true) goto L22;
        this.b.p0.c();
    L22:
        DataEngineWrapper r10 = this.b.L0;
        if (r10 == null) goto L25;
        r10.b = y93.a.a(r10.b, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(r98.i ? 1 : 0), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -8388609, -1, -1, -1, 127);
    L25:
        this.b.getClass();
        ECMallFragment r11 = this.b;
        DataEngineWrapper r12 = r11.L0;
        if (r12 == null) goto L28;
        r12.b = y93.a.a(r12.b, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(r11.C), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -1, -1, -1025, -1, 127);
    L28:
        Lazy r14 = HybridAppInfoService.a;
        if (HybridAppInfoService.l() == false) goto L33;
        IECMallHomepageService r15 = (IECMallHomepageService) ServiceManager.get().getService(IECMallHomepageService.class);
        if (r15 == null) goto L33;
        r15.notifyRenderFinished(this.b, true, new LinkedHashMap());
    L33:
        ECMallFragment r16 = this.b;
        ECHybridListEngine r17 = r16.H0;
        if (r17 == null) goto L40;
        MallDrainageOpt r18 = (MallDrainageOpt) r16.S.getValue();
        if (r18 == null) goto L40;
        Intrinsics.checkNotNullParameter(r17, "listEngine");
        if (Intrinsics.areEqual(r18.a, "1") == false) goto L40;
        r18.a(r17);
    L40:
        Lazy r19 = ECMallResourcePreloader.a;
        String r20 = this.b.d.e();
        Intrinsics.checkNotNullParameter(r20, "pageName");
        ECMallResourcePreloader.c(2, r20);
        return;
    L43:
        if (Intrinsics.areEqual(r98.k, "real") == false) goto L91;
        FragmentActivity r21 = this.b.getActivity();
        if (r21 == null) goto L91;
        Intent r22 = r21.getIntent();
        if (r22 == null) goto L91;
        Bundle r23 = r22.getExtras();
        if (r23 == null) goto L91;
        String r24 = r23.getString("schema", "");
        if (r24 == null) goto L91;
        if (r24.length() <= 0) goto L55;
        boolean r110 = true;
    L56:
        if (r110 == false) goto L91;
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L89
        Uri r25 = UriProtector.parse(r24);     // Catch: Throwable -> L89
        String r112 = UriProtector.getQueryParameter(r25, "delivery_session_id");     // Catch: Throwable -> L89
        String r26 = UriProtector.getQueryParameter(r25, "delivery_template_key");     // Catch: Throwable -> L89
        if (r112 != null) goto L60;
    L63:
        boolean r113 = true;
    L64:
        if (r113 == true) goto L87;
        if (r26 != null) goto L67;
    L70:
        boolean r114 = true;
    L71:
        if (r114 == true) goto L87;
        if (StringsKt.contains$default(r26, "delivery_to_mall_template", false, 2, null) == false) goto L87;
        IECNativeHomeService r27 = (IECNativeHomeService) ServiceManager.get().getService(IECNativeHomeService.class);     // Catch: Throwable -> L89
        if (r27 == null) goto L87;
        y93.b r28 = r27.a();     // Catch: Throwable -> L89
        if (r28 == null) goto L87;
        if (r28.h(r112) == null) goto L81;
        boolean r115 = true;
    L82:
        if (r115 == true) goto L85;
        r28 = null;
    L85:
        if (r28 == null) goto L87;
        r28.d(r112, "interactive_time", null, null);     // Catch: Throwable -> L89
        r28.c(new y93.e("tti", r112));     // Catch: Throwable -> L89
        goto L87
    L81:
        r115 = false;
        goto L82
    L67:
        if (r26.length() == 0) goto L70;
        r114 = false;
    L87:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L89
        goto L91
    L60:
        if (r112.length() == 0) goto L63;
        r113 = false;
    L89:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L91
    L55:
        r110 = false;
    L91:
        ECMallFragment r29 = this.b;
        IECNativeContainerLoadState$MallState r117 = IECNativeContainerLoadState$MallState.INIT;
        r29.getClass();
        if (this.b.ja0() == null) goto L99;
        Integer r30 = com.bytedance.android.shopping.mall.homepage.opt.e.e.a();
        if (r30 == null) goto L99;
        if (r30.intValue() != 3) goto L99;
        int r31 = com.bytedance.android.shopping.mall.homepage.opt.h.a;
    L99:
        HomepageChunkedCallback r32 = this.b.Y2;
        if (r32 == null) goto L102;
        r32.e();
    L102:
        Lazy r33 = HybridAppInfoService.a;
        if (HybridAppInfoService.l() == false) goto L107;
        IECMallHomepageService r34 = (IECMallHomepageService) ServiceManager.get().getService(IECMallHomepageService.class);
        if (r34 == null) goto L107;
        r34.notifyRenderFinished(this.b, false, new LinkedHashMap());
    L107:
        Lazy r35 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.m.a.b, "render first screen finished, flag = " + r98.k);
        DataEngineWrapper r36 = this.b.L0;
        if (r36 == null) goto L112;
        y93.a r37 = r36.b;
        if (r37 == null) goto L112;
        Long r38 = r37.x();
    L113:
        if (r38 == null) goto L117;
        DataEngineWrapper r39 = this.b.L0;
        if (r39 == null) goto L117;
        r39.L(new ECMallFragment$initListEngine$6$onFirstScreen$2(r96));
    L117:
        ECMallFragment r40 = this.b;
        ECHybridListEngine r118 = r40.H0;
        if (r118 == null) goto L127;
        MallDrainageOpt r41 = (MallDrainageOpt) r40.S.getValue();
        if (r41 == null) goto L127;
        Intrinsics.checkNotNullParameter(r118, "listEngine");
        Handler r42 = new Handler(Looper.getMainLooper());
        com.bytedance.android.shopping.mall.homepage.opt.d r119 = new com.bytedance.android.shopping.mall.homepage.opt.d(r41, r118);
        Long r43 = ((MallDrainageOpt.a.C0104a) r41.d.getValue()).a();
        if (r43 == null) goto L124;
        long r120 = r43.longValue();
    L125:
        r42.postDelayed(r119, r120);
        goto L127
    L124:
        r120 = 500;
    L127:
        if (((Boolean) this.b.b3.getValue()).booleanValue() == false) goto L133;
        ECHybridListEngine r44 = this.b.H0;
        if (r44 == null) goto L133;
        ECHybridRecyclerView r45 = r44.b;
        if (r45 == null) goto L133;
        r45.setTriggerChildShowStrictly(true);
    L133:
        lf3.b r46 = (lf3.b) this.b.k0.getValue();
        if (r46 == null) goto L136;
        r46.d = Long.valueOf(r96);
    L136:
        lf3.b r47 = (lf3.b) this.b.k0.getValue();
        if (r47 != null) goto L215;
    L142:
        DataEngineWrapper r48 = this.b.L0;
        if (r48 == null) goto L147;
        y93.a r49 = r48.b;
        if (r49 == null) goto L147;
        Long r50 = r49.j();
    L148:
        if (r50 != null) goto L159;
        ECMallFragment r51 = this.b;
        DataEngineWrapper r52 = r51.L0;
        if (r52 == null) goto L152;
        r52.b = y93.a.a(r52.b, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(r51.D), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -1, -1, -2049, -1, 127);
    L152:
        DataEngineWrapper r53 = this.b.L0;
        if (r53 == null) goto L155;
        r53.k(r94);
    L155:
        DataEngineWrapper r54 = this.b.L0;
        if (r54 == null) goto L158;
        r54.o(r96);
    L158:
        this.b.La0(1, r98);
        ECMallFragment r55 = this.b;
        r55.jq(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("first_screen_header_card_type", Integer.valueOf(r55.D)), TuplesKt.to("straight_out_header_card_type", Integer.valueOf(this.b.C))}), null);
    L159:
        this.b.getClass();
        ECMallFragment r56 = this.b;
        r56.va0(null);
        r56.ua0(null);
        Iterator r57 = ((ArrayList) r56.h1).iterator();
    L161:
        if (r57.hasNext() == false) goto L168;
        String r58 = (String) r57.next();
        if (r58 == null) goto L161;
        ECLynxCard r59 = r56.k1;
        if (r59 == null) goto L161;
        int r60 = com.bytedance.android.ec.hybrid.card.api.d.e;
        r59.e(com.bytedance.android.ec.hybrid.card.api.d.a.b(r58), true);
        goto L161
    L168:
        ((ArrayList) r56.h1).clear();
        ((ArrayList) this.b.h1).clear();
        this.b.e.onFirstScreen();
        this.b.p0.f();
        this.b.d.l = true;
        this.b.Na0(Boolean.valueOf(com.bytedance.android.shopping.api.mall.common.tools.h.b.getIHybridHostUserService().isLogin()));
        Lazy r61 = ECMallResourcePreloader.a;
        String r62 = this.b.d.e();
        Intrinsics.checkNotNullParameter(r62, "pageName");
        ECMallResourcePreloader.c(3, r62);
        ECDeepFeedDomainPreConnectUtil r63 = (ECDeepFeedDomainPreConnectUtil) this.b.L1.getValue();
        if (r63 == null) goto L182;
        ECDeepFeedDomainPreConnectUtil.g.getClass();
        com.bytedance.android.shopping.api.mall.opt.a r64 = ECDeepFeedDomainPreConnectUtil.a.b();
        if (r64.b() == true) goto L173;
        r63.e();
        goto L182
    L173:
        Set<String> r65 = ECDeepFeedDomainPreConnectUtil.h(r64.a());
        if (r65.isEmpty() == false) goto L176;
        r63.e();
        goto L182
    L176:
        r63.i(r65);
        Long r66 = r64.c();
        if (r66 != null) goto L179;
    L181:
        r63.e();
        goto L182
    L179:
        if (r66.longValue() <= 0) goto L181;
        r63.d(r66.longValue());
    L182:
        ECMallFragment r67 = this.b;
        if (r67.k3 == true) goto L185;
        ECMallLoginGuideCard.a r68 = ECMallLoginGuideCard.t;
        String r69 = r67.M3;
        r68.getClass();
        ECMallLoginGuideCard.a.a(r69);
    L185:
        ECHybridDataEngine.x.getClass();
        if (((Boolean) ECHybridDataEngine.r.getValue()).booleanValue() == false) goto L192;
        DataEngineWrapper r70 = this.b.L0;
        if (r70 == null) goto L192;
        ECHybridDataEngine r71 = r70.a;
        if (r71 == null) goto L192;
        r71.v();
    L192:
        com.bytedance.android.shopping.mall.homepage.opt.f r72 = (com.bytedance.android.shopping.mall.homepage.opt.f) this.b.u3.getValue();
        if (r72 == null) goto L195;
        Looper.myQueue().addIdleHandler(new com.bytedance.android.shopping.mall.homepage.opt.g(r72));
    L195:
        IHybridHostService r73 = com.bytedance.android.ec.hybrid.a.h();
        if (r73 == null) goto L198;
        r73.notifyPreloadDeepFeedSlc();
    L198:
        kjc.c r74 = new kjc.c();
        if (5 != kjc.a.a()) goto L202;
        kjc.b r75 = r74.a;
        ThreadPoolHelper.c().submit(new a(this));
        r75.a = Unit.INSTANCE;
        r74.b = true;
    L202:
        if (r74.b == true) goto L204;
        r74.a.a = Unit.INSTANCE;
    L204:
        Object r76 = r74.a.a;
        Context r77 = this.b.getContext();
        if (r77 == null) goto L207;
        boolean r78 = com.bytedance.android.ec.hybrid.list.util.o.a;
        com.bytedance.android.ec.hybrid.list.util.o.a(r77, hashCode());
    L207:
        Map r79 = com.bytedance.android.ec.hybrid.list.opt.b.a;
        Lifecycle r80 = this.b.getLifecycle();
        Intrinsics.checkNotNullParameter(r80, "lifecycle");
        if (com.bytedance.android.ec.hybrid.list.opt.b.b == false) goto L211;
        r80.addObserver(new ImageResizeOpt.injectLifeCycle.1());
    L211:
        ECMallFragment r81 = this.b;
        if (r81.R3 == false) goto L226;
        r81.R3 = false;
        ECMallDeliveryReduceConfig r82 = com.bytedance.android.shopping.mall.homepage.tools.g.a;
        LinkedHashMap r84 = new LinkedHashMap();
        ECMallFragment$initListEngine$6$onFirstScreen$6 r85 = new ECMallFragment$initListEngine$6$onFirstScreen$6(this);
        Intrinsics.checkNotNullParameter(r84, "deliveryParams");
        Intrinsics.checkNotNullParameter(r85, "action");
        return;
    L226:
        return;
    L147:
        r50 = null;
        goto L148
    L215:
        Result.Companion r86 = Result.Companion;     // Catch: Throwable -> L140
        JSONObject r87 = new JSONObject();     // Catch: Throwable -> L140
        r87.putOpt(SimilarProductParam.ENTER_FROM, r47.a);     // Catch: Throwable -> L140
        r87.putOpt("rebuild_time", r47.b);     // Catch: Throwable -> L140
        r87.putOpt("rebuild_straight_out", r47.c);     // Catch: Throwable -> L140
        r87.putOpt("rebuild_first_screen", r47.d);     // Catch: Throwable -> L140
        AppLogNewUtils.onEventV3("mall_rebuild_monitor", r87);     // Catch: Throwable -> L140
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L140
    L140:
        th = move-exception;
        Result.Companion r88 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L112:
        r38 = null;
        goto L113
    }
}
