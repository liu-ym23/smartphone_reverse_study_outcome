package com.bytedance.android.shopping.mall.feed.jsb;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.shopping.api.mall.IECNativeHomeService;
import com.bytedance.android.shopping.api.mall.feed.IECMallFeedService;
import com.bytedance.android.shopping.mall.feed.ECMallFeed;
import com.bytedance.android.shopping.mall.homepage.tools.DataEngineWrapper;
import com.bytedance.android.shopping.mall.opt.MallOptUtil;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallOpenSchemaJsb extends qf3.e {
    public static final /* synthetic */ int n = 0;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final List<com.bytedance.android.shopping.mall.feed.ability.f> l;
    public final String m;

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return this.m;
    }

    public ECMallOpenSchemaJsb(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
        this.d = LazyKt.lazy(ECMallOpenSchemaJsb$ensurePerfParamsEnable$2.INSTANCE);
        this.e = LazyKt.lazy(ECMallOpenSchemaJsb$enableFallbackSchemaIntercept$2.INSTANCE);
        this.f = LazyKt.lazy(ECMallOpenSchemaJsb$enableRouterOptPage$2.INSTANCE);
        this.g = LazyKt.lazy(ECMallOpenSchemaJsb$enableRouterOptScene$2.INSTANCE);
        this.h = LazyKt.lazy(ECMallOpenSchemaJsb$enableCheckBtm$2.INSTANCE);
        this.i = LazyKt.lazy(ECMallOpenSchemaJsb$enableDeliveryEventBus$2.INSTANCE);
        this.j = LazyKt.lazy(ECMallOpenSchemaJsb$enableDeliveryXScreen$2.INSTANCE);
        this.k = LazyKt.lazy(ECMallOpenSchemaJsb$enableSchemaParamsLogic$2.INSTANCE);
        this.l = new ArrayList();
        this.m = "ec.mallOpenSchema";
    }

    public static final Uri g(ECMallOpenSchemaJsb r0, Uri r1, String r2, String r3) {
        r0.getClass();
        if (UriProtector.getQueryParameterNames(r1).contains(r2) == false) goto L5;
        return r1;
    L5:
        return r1.buildUpon().appendQueryParameter(r2, r3).build();
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r19, IBDXBridgeContext r20, final Map<String, ? extends Object> r21, Map<String, Object> r22) {
        qf3.d r1 = r19;
        Intrinsics.checkNotNullParameter(r1, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r20, "bridgeContext");
        Intrinsics.checkNotNullParameter(r21, "params");
        Intrinsics.checkNotNullParameter(r22, "result");
        Intrinsics.checkNotNullParameter(r21, "params");
        Intrinsics.checkNotNullParameter("use_jsb", "type");
        long r5 = System.currentTimeMillis();
        if (r1 != null) goto L5;
        r1 = this.c;
    L5:
        qf3.d r12 = r1;
        Object r2 = r21.get("mall_schema");
        Object r7 = null;
        if ((r2 instanceof String) == true) goto L8;
        r2 = null;
    L8:
        String r3 = (String) r2;
        Object r4 = r21.get("schema");
        if ((r4 instanceof String) == true) goto L11;
        r4 = null;
    L11:
        final String r6 = (String) r4;
        Object r8 = r21.get("check_mall_visible");
        if ((r8 instanceof Integer) == true) goto L14;
        r8 = null;
    L14:
        Integer r9 = (Integer) r8;
        if (r9 == null) goto L17;
        int r10 = r9.intValue();
    L18:
        Object r11 = r21.get("deliverySessionId");
        if ((r11 instanceof String) == true) goto L21;
        r11 = null;
    L21:
        String r13 = (String) r11;
        if (r13 == null) goto L45;
        IECNativeHomeService r14 = (IECNativeHomeService) ServiceManager.get().getService(IECNativeHomeService.class);
        if (r14 == null) goto L29;
        y93.b r15 = r14.a();
        if (r15 == null) goto L29;
        r15.d(r13, "jsb_receive_time", null, null);
    L29:
        if (((Number) this.j.getValue()).intValue() != 1) goto L45;
        if (r13.length() <= 0) goto L33;
        boolean r16 = true;
    L34:
        if (r16 == false) goto L45;
        if (r10 != 1) goto L45;
        if (r12.b.A1.Q20() == false) goto L45;
        IECNativeHomeService r17 = (IECNativeHomeService) ServiceManager.get().getService(IECNativeHomeService.class);
        if (r17 == null) goto L203;
        y93.b r18 = r17.a();
        if (r18 == null) goto L203;
        r18.b(r13, MapsKt.mapOf(new Pair[]{TuplesKt.to("type", "[LIFECYCLE]|router|lynx"), TuplesKt.to("info", "mall invisible")}));
    L203:
        return qf3.e.c("商城不可见，七分屏漂移，拦截七分屏");
    L33:
        r16 = false;
    L45:
        if (((Boolean) this.e.getValue()).booleanValue() == true) goto L47;
    L50:
        Object r23 = r21.get("btm");
        if ((r23 instanceof String) == true) goto L53;
        r23 = null;
    L53:
        String r24 = (String) r23;
        if (r24 != null) goto L56;
    L59:
        boolean r25 = true;
    L60:
        if (r25 == false) goto L62;
    L64:
        int r26 = com.bytedance.android.shopping.api.mall.common.tools.q.a;
        Fragment r27 = r12.b.A1.M();
        DataEngineWrapper r28 = r12.b.C1;
        Intrinsics.checkNotNullParameter(r21, "params");
        if (r27 == null) goto L81;
        com.bytedance.android.btm.api.model.e r29 = BtmSDK.INSTANCE.getBtmPageInfo(PageFinder.via(r27));
        if (r29 == null) goto L81;
        Object r30 = r21.get("auto_half_page");
        if ((r30 instanceof Boolean) == true) goto L74;
        r30 = null;
    L74:
        if (Intrinsics.areEqual((Boolean) r30, Boolean.TRUE) == false) goto L81;
        if (r28 != null) goto L200;
    L78:
        Logger.d("puffone-HalfPageBtmHelper.tryAddLastShowId()", "add succ: " + r29.a);     // Catch: Exception -> L80
    L80:
        Logger.d("puffone-HalfPageBtmHelper.tryAddLastShowId()", "add fail");
        goto L81
    L200:
        r28.n();     // Catch: Exception -> L80
    L81:
        if (r6 != null) goto L83;
    L86:
        boolean r31 = true;
    L87:
        if (r31 == true) goto L204;
        ECHybridListEngine r32 = r12.b.J;
        if (r32 == null) goto L199;
        ECHybridRecyclerView r33 = r32.b;
        if (r33 == null) goto L199;
        if (BtmSDK.INSTANCE.useV2Api() == false) goto L98;
        int r34 = com.bytedance.android.shopping.api.mall.common.tools.b.a;
        r6 = com.bytedance.android.shopping.api.mall.common.tools.b.a(r6, r21, r12.b.A1.N90(r33), r12.a, ((Boolean) this.h.getValue()).booleanValue());
    L98:
        if (((Boolean) this.d.getValue()).booleanValue() == true) goto L101;
    L107:
        Lazy r35 = MallOptUtil.b;
        if (((Number) r35.getValue()).longValue() == 0) goto L110;
    L112:
        ((Number) r35.getValue()).longValue();
        ((Number) MallOptUtil.c.getValue()).longValue();
        IHybridHostService r36 = com.bytedance.android.ec.hybrid.a.h();
        if (r36 == null) goto L115;
        r36.getMallOptService();
    L115:
        Map<String, Object> r37 = MapsKt.toMutableMap(r21);
        r37.putAll(r12.b.A1.getGlobalProps());
        Iterator r38 = ((ArrayList) this.l).iterator();
    L117:
        if (r38.hasNext() == false) goto L119;
        com.bytedance.android.shopping.mall.feed.ability.f r39 = (com.bytedance.android.shopping.mall.feed.ability.f) r38.next();
        Object r110 = r21.get("auto_half_page");
        Boolean r111 = Boolean.TRUE;
        r39.c(new com.bytedance.android.shopping.mall.feed.ability.e(r6, Intrinsics.areEqual(r110, r111), Intrinsics.areEqual(r21.get("delayOnPause"), r111)));
        goto L117
    L119:
        long r40 = System.currentTimeMillis();
        Object r41 = r21.get("prefetchGyl");
        if ((r41 instanceof Number) == true) goto L122;
        r41 = null;
    L122:
        Number r42 = (Number) r41;
        if (r42 == null) goto L125;
        Integer r43 = Integer.valueOf(r42.intValue());
    L126:
        if (r43 != null) goto L129;
    L147:
        String r112 = r6;
        Context r44 = r12.a;
        Object r45 = r21.get("auto_half_page");
        if ((r45 instanceof Boolean) == true) goto L150;
        r45 = null;
    L150:
        Boolean r46 = (Boolean) r45;
        Object r47 = r21.get("scene");
        if ((r47 instanceof String) == false) goto L154;
        r7 = r47;
    L154:
        String r48 = (String) r7;
        if (r44 != null) goto L157;
        r44 = this.c.a;
    L157:
        com.bytedance.android.shopping.api.mall.idl.a r49 = this.c.b.A1.Bi();
        if (r49 == null) goto L163;
        com.bytedance.android.shopping.api.mall.idl.c r50 = r49.a;
        if (r50 == null) goto L163;
        r50.o = true;
    L163:
        if (Intrinsics.areEqual(r46, Boolean.TRUE) == true) goto L189;
        String r51 = this.c.b.B1.c;
        if (((ArrayList) this.f.getValue()).contains("all_page") == false) goto L167;
    L169:
        if (r48 != null) goto L171;
    L174:
        boolean r52 = true;
    L175:
        if (r52 == false) goto L177;
    L180:
        boolean r53 = false;
    L181:
        if (r53 == false) goto L189;
        Uri r54 = UriProtector.parse(r112);
        com.bytedance.android.shopping.api.mall.common.tools.k r55 = com.bytedance.android.shopping.api.mall.common.tools.k.b;
        if (r55.c(r54) == true) goto L186;
    L188:
        r55.d(r44, r112, r37);
        Lazy r56 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.a.c.b, "ec router error ,use smart router");
    L190:
        int r113 = 1;
    L191:
        com.bytedance.android.ec.hybrid.a.d().submit(new b0(r21, r5, r40, System.currentTimeMillis(), r113, r12));
        ECMallFeed r0 = r12.b;
        Object r57 = r21.get("scene");
        if ((r57 instanceof String) == true) goto L194;
        r57 = null;
    L194:
        c0.b(r0, r112, (String) r57);
        ECMallFeed r58 = r12.b;
        Object r59 = r21.get("scene");
        if ((r59 instanceof String) == true) goto L197;
        r59 = null;
    L197:
        String r60 = (String) r59;
        r58.getClass();
        return qf3.e.f(this);
    L186:
        if (r55.b(r44, r54, false) == false) goto L188;
        Lazy r61 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.a.c.b, "open use ec router");
        r113 = 2;
        goto L191
    L177:
        if (((ArrayList) this.g.getValue()).contains(r48) == false) goto L180;
        r53 = true;
        goto L181
    L171:
        if (r48.length() == 0) goto L174;
        r52 = false;
        goto L175
    L167:
        if (((ArrayList) this.f.getValue()).contains(r51) == true) goto L169;
    L189:
        Lazy r62 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.a.c.b, "check for use open use smart router");
        com.bytedance.android.shopping.api.mall.common.tools.k.b.d(r44, r112, r37);
        goto L190
    L129:
        if (r43.intValue() != 1) goto L147;
        Object r63 = r21.get("targetPageName");
        if ((r63 instanceof String) == true) goto L133;
        r63 = null;
    L133:
        String r64 = (String) r63;
        if (r64 == null) goto L147;
        if (r64.length() <= 0) goto L138;
        boolean r114 = true;
    L139:
        if (r114 == false) goto L147;
        IECMallFeedService r115 = (IECMallFeedService) ServiceManager.get().getService(IECMallFeedService.class);
        if (r115 == null) goto L147;
        com.bytedance.android.shopping.api.mall.feed.g r116 = r115.b(r64);
        if (r116 == null) goto L147;
        String r65 = r116.b(r6, new com.bytedance.android.shopping.api.mall.feed.j(r64));
        if (r65 == null) goto L147;
        r6 = UriProtector.parse(r6).buildUpon().appendQueryParameter("gyl_request_id", r65).build().toString();
        goto L147
    L138:
        r114 = false;
        goto L139
    L125:
        r43 = null;
        goto L126
    L110:
        if (((Number) MallOptUtil.c.getValue()).longValue() != 0) goto L112;
    L101:
        if (r6.length() != 0) goto L103;
        boolean r66 = true;
    L104:
        if (r66 == true) goto L107;
        final Ref.ObjectRef r67 = new Ref.ObjectRef();
        r67.element = r6;
        kk.d.c(new ECMallOpenSchemaJsb$ensurePerfParams$1(this, r6, r21, r67));
        r6 = (String) r67.element;
        goto L107
    L103:
        r66 = false;
    L199:
        return qf3.e.c("schema depend view is null");
    L204:
        return qf3.e.c("schema is null or blank");
    L83:
        if (StringsKt.isBlank(r6) == true) goto L86;
        r31 = false;
        goto L87
    L62:
        if (BtmSDK.INSTANCE.useV2Api() == true) goto L64;
        r12.b.A1.bI(r21, true);
        goto L64
    L56:
        if (r24.length() == 0) goto L59;
        r25 = false;
        goto L60
    L47:
        if (TextUtils.isEmpty(r3) == true) goto L50;
        if (r3 == null) goto L50;
        r12.b.A1.Wr();
        goto L50
    L17:
        r10 = 0;
        goto L18
    }
}
