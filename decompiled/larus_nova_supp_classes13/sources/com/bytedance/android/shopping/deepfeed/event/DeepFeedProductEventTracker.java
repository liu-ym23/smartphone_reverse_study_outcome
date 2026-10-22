package com.bytedance.android.shopping.deepfeed.event;

import android.net.Uri;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.bst.api.ext.ExtKt;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.android.shopping.base.event.EventActionImpl;
import com.bytedance.android.shopping.buynow.data.model.PageScrollStatus;
import com.bytedance.android.shopping.deepfeed.data.DeepFeedQueryParam;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackData;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackDataElements;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.bytedance.android.shopping.infeed.data.idl.InFeedUrlModel;
import com.bytedance.android.shopping.infeed.data.idl.ad.AdBaseInfo;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.services.apm.api.EnsureManager;
import he3.a0;
import he3.c0;
import he3.d1;
import he3.e1;
import he3.e2;
import he3.f0;
import he3.f2;
import he3.h2;
import he3.k0;
import he3.k1;
import he3.n0;
import he3.o1;
import he3.p0;
import he3.p1;
import he3.r1;
import he3.u0;
import he3.w;
import he3.w1;
import he3.x1;
import he3.y;
import he3.y1;
import he3.z0;
import he3.z1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.random.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class DeepFeedProductEventTracker implements com.bytedance.android.shopping.base.event.b {
    public static final /* synthetic */ int d = 0;
    public final Set<InFeedProductV2> a;
    public final boolean b;
    public final /* synthetic */ EventActionImpl c;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.bst.api.g {
        public final /* synthetic */ DeepFeedProductEventTracker a;
        public final /* synthetic */ String b;
        public final /* synthetic */ InFeedProductV2 c;
        public final /* synthetic */ int d;
        public final /* synthetic */ List e;
        public final /* synthetic */ Map f;
        public final /* synthetic */ View g;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void a(String r5, Map<Object, ? extends Object> r6) {
            Intrinsics.checkNotNullParameter(r5, "eventName");
            Intrinsics.checkNotNullParameter(r6, "params");
            Map<String, Object> r0 = this.a.g(this.d, this.c, this.e);
            ArrayList r1 = new ArrayList(r6.size());
            Iterator r7 = ((LinkedHashMap) r6).entrySet().iterator();
        L4:
            if (r7.hasNext() == false) goto L6;
            Map.Entry r2 = (Map.Entry) r7.next();
            r1.add(TuplesKt.to(r2.getKey().toString(), r2.getValue()));
            goto L4
        L6:
            MapsKt.putAll(r0, r1);
            InFeedProductV2 r8 = this.c;
            if (r8 == null) goto L11;
            String r9 = DeepFeedProductEventTracker.a(this.a, r8);
            if (r9 == null) goto L11;
            r0.put("is_other_channel", r9);
        L11:
            InFeedProductV2 r10 = this.c;
            if (r10 != null) goto L14;
        L16:
            Map r11 = this.f;
            if (r11 == null) goto L22;
            Iterator r12 = r11.entrySet().iterator();
        L20:
            if (r12.hasNext() == false) goto L22;
            Map.Entry r3 = (Map.Entry) r12.next();
            r0.put(r3.getKey(), r3.getValue());
        L22:
            this.a.getClass();
            DeepFeedProductEventTracker.b(r0);
            DeepFeedProductEventTracker r13 = this.a;
            le3.b.a(r0, this.b, this.g);
            r13.doEventAction(r5, r0);
            return;
        L14:
            if (com.bytedance.android.shopping.deepfeed.utlis.g.b(r10) != true) goto L16;
            r0.put("has_live_header", "1");
            goto L16
        }

        public b(DeepFeedProductEventTracker r1, String r2, InFeedProductV2 r3, int r4, List r5, Map r6, View r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }
    }

    static {
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void appendEventParamToEntranceInfo(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        this.c.appendEventParamToEntranceInfo(r2, r3);
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void appendEventParams(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "paramsMap");
        this.c.appendEventParams(r2);
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void appendEventParams(Pair<String, ? extends Object>... r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        this.c.appendEventParams(r2);
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void clearEventParams() {
        this.c.clearEventParams();
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void doEventAction(String r2, PageFinder r3, Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r2, "actionName");
        Intrinsics.checkNotNullParameter(r4, "params");
        this.c.doEventAction(r2, r3, r4);
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void doEventAction(String r2, PageFinder r3, Pair<String, ? extends Object>... r4) {
        Intrinsics.checkNotNullParameter(r2, "actionName");
        Intrinsics.checkNotNullParameter(r4, "params");
        this.c.doEventAction(r2, r3, r4);
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void doEventAction(String r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "actionName");
        Intrinsics.checkNotNullParameter(r3, "params");
        this.c.doEventAction(r2, r3);
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void doEventAction(String r2, Pair<String, ? extends Object>... r3) {
        Intrinsics.checkNotNullParameter(r2, "actionName");
        Intrinsics.checkNotNullParameter(r3, "params");
        this.c.doEventAction(r2, r3);
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void initEventContext(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "paramsMap");
        this.c.initEventContext(r2);
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void initEventContext(Pair<String, ? extends Object>... r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        this.c.initEventContext(r2);
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final Map<String, Object> getEventParams() {
        return this.c.c();
    }

    public DeepFeedProductEventTracker() {
        this.c = new EventActionImpl();
        this.a = new LinkedHashSet();
        int r0 = com.bytedance.android.ec.base.settings.a.a;
        Object r1 = Boolean.TRUE;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L166
        Object r3 = null;
        Object r4 = com.bytedance.android.ec.base.settings.d.c.get("ec_inflow_ohr_hand_result_report_enable");     // Catch: Throwable -> L57
        if (r4 != null) goto L9;
    L54:
        Object r5 = null;
    L55:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L57
    L59:
        Throwable r7 = Result.exceptionOrNull-impl(r6);     // Catch: Throwable -> L166
        if (r7 == null) goto L63;
        EnsureManager.ensureNotReachHere(r7);     // Catch: Throwable -> L166
    L63:
        if (Result.isFailure-impl(r6) == false) goto L66;
        r6 = null;
    L66:
        if ((r6 instanceof Boolean) == true) goto L68;
        r6 = null;
    L68:
        Object r8 = (Boolean) r6;     // Catch: Throwable -> L166
        if (r8 != null) goto L75;
        Object r9 = com.bytedance.android.ec.base.settings.d.a.get("ec_inflow_ohr_hand_result_report_enable");     // Catch: Throwable -> L166
        if ((r9 instanceof Boolean) == true) goto L74;
        r9 = null;
    L74:
        r8 = (Boolean) r9;     // Catch: Throwable -> L166
    L75:
        if (r8 != null) goto L175;
        int r10 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L166
        Object r11 = com.bytedance.android.ec.base.settings.d.c.get("ec_inflow_ohr_hand_result_report_enable");     // Catch: Throwable -> L130
        if (r11 != null) goto L82;
    L127:
        Object r12 = null;
    L128:
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L130
    L132:
        Throwable r14 = Result.exceptionOrNull-impl(r13);     // Catch: Throwable -> L156
        if (r14 == null) goto L136;
        EnsureManager.ensureNotReachHere(r14);     // Catch: Throwable -> L156
    L136:
        if (Result.isFailure-impl(r13) == false) goto L139;
        r13 = null;
    L139:
        if ((r13 instanceof Boolean) == true) goto L141;
        r13 = null;
    L141:
        r8 = (Boolean) r13;     // Catch: Throwable -> L156
        if (r8 != null) goto L164;
        IHybridHostService r15 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r15 == null) goto L147;
        Object r16 = r15.getHostABValue("ec_inflow_ohr_hand_result_report_enable", r1);     // Catch: Throwable -> L156
    L148:
        if (r16 != null) goto L150;
    L155:
        r8 = r1;
        goto L164
    L150:
        if ((r16 instanceof Boolean) == false) goto L153;
        r3 = r16;
    L153:
        Object r17 = (Boolean) r3;     // Catch: Throwable -> L156
        if (r17 == null) goto L155;
    L163:
        r8 = r17;
        goto L164
    L147:
        r16 = null;
    L164:
        com.bytedance.android.ec.base.settings.d.d("ec_inflow_ohr_hand_result_report_enable", r8);     // Catch: Throwable -> L166
        goto L175
    L82:
        if ((r11 instanceof Boolean) == true) goto L84;
        Object r18 = null;
    L85:
        r12 = (Boolean) r18;     // Catch: Throwable -> L130
        if (r12 != null) goto L128;
        if ((r11 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r19 = Float.valueOf(((Number) r11).floatValue());     // Catch: Throwable -> L130
        if ((r19 instanceof Boolean) == true) goto L95;
        r19 = null;
    L95:
        r12 = (Boolean) r19;     // Catch: Throwable -> L130
        goto L128
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r20 = Double.valueOf(((Number) r11).doubleValue());     // Catch: Throwable -> L130
        if ((r20 instanceof Boolean) == true) goto L101;
        r20 = null;
    L101:
        r12 = (Boolean) r20;     // Catch: Throwable -> L130
        goto L128
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        Integer r21 = Integer.valueOf(((Number) r11).intValue());     // Catch: Throwable -> L130
        if ((r21 instanceof Boolean) == true) goto L107;
        r21 = null;
    L107:
        r12 = (Boolean) r21;     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r22 = Long.valueOf(((Number) r11).longValue());     // Catch: Throwable -> L130
        if ((r22 instanceof Boolean) == true) goto L113;
        r22 = null;
    L113:
        r12 = (Boolean) r22;     // Catch: Throwable -> L130
    L115:
        if ((r11 instanceof JSONObject) == false) goto L117;
    L184:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L123
        Object r23 = SDKSettingsCacheManager.a().fromJson(r11.toString(), Boolean.class);     // Catch: Throwable -> L123
        if ((r23 instanceof Boolean) == true) goto L121;
        r23 = null;
    L121:
        Object r24 = Result.constructor-impl((Boolean) r23);     // Catch: Throwable -> L123
    L125:
        r12 = r24;
        if (Result.isFailure-impl(r12) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L130
        r24 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r11 instanceof JSONArray) == false) goto L127;
    L84:
        r18 = r11;
    L156:
        th = move-exception;
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L166
        r17 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
        Throwable r27 = Result.exceptionOrNull-impl(r17);     // Catch: Throwable -> L166
        if (r27 == null) goto L161;
        EnsureManager.ensureNotReachHere(r27);     // Catch: Throwable -> L166
    L161:
        if (Result.isFailure-impl(r17) == false) goto L163;
        r17 = r1;
    L130:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L156
        r13 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
    L175:
        this.b = ((Boolean) r8).booleanValue();
        return;
    L9:
        if ((r4 instanceof Boolean) == true) goto L11;
        Object r29 = null;
    L12:
        r5 = (Boolean) r29;     // Catch: Throwable -> L57
        if (r5 != null) goto L55;
        if ((r4 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r30 = Float.valueOf(((Number) r4).floatValue());     // Catch: Throwable -> L57
        if ((r30 instanceof Boolean) == true) goto L22;
        r30 = null;
    L22:
        r5 = (Boolean) r30;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r31 = Double.valueOf(((Number) r4).doubleValue());     // Catch: Throwable -> L57
        if ((r31 instanceof Boolean) == true) goto L28;
        r31 = null;
    L28:
        r5 = (Boolean) r31;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        Integer r32 = Integer.valueOf(((Number) r4).intValue());     // Catch: Throwable -> L57
        if ((r32 instanceof Boolean) == true) goto L34;
        r32 = null;
    L34:
        r5 = (Boolean) r32;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r33 = Long.valueOf(((Number) r4).longValue());     // Catch: Throwable -> L57
        if ((r33 instanceof Boolean) == true) goto L40;
        r33 = null;
    L40:
        r5 = (Boolean) r33;     // Catch: Throwable -> L57
    L42:
        if ((r4 instanceof JSONObject) == false) goto L44;
    L181:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r34 = SDKSettingsCacheManager.a().fromJson(r4.toString(), Boolean.class);     // Catch: Throwable -> L50
        if ((r34 instanceof Boolean) == true) goto L48;
        r34 = null;
    L48:
        Object r35 = Result.constructor-impl((Boolean) r34);     // Catch: Throwable -> L50
    L52:
        r5 = r35;
        if (Result.isFailure-impl(r5) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L57
        r35 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r4 instanceof JSONArray) == false) goto L54;
    L11:
        r29 = r4;
    L57:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L166
        r6 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
        Object r39 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r40 = Result.exceptionOrNull-impl(r39);
        if (r40 == null) goto L171;
        EnsureManager.ensureNotReachHere(r40);
    L171:
        if (Result.isFailure-impl(r39) == true) goto L174;
        r1 = r39;
    L174:
        r8 = r1;
        goto L175
    }

    public static void b(Map r5) {
        Intrinsics.checkNotNullParameter(r5, "params");
        if (TypeIntrinsics.isMutableMap(r5) == true) goto L5;
        r5 = null;
    L5:
        if (r5 != null) goto L7;
        return;
    L7:
        r5.put("track_unique_id", String.valueOf(Random.Default.nextLong(1000000000000000L, 10000000000000000L)));
    }

    public final void t(boolean r3) {
        doEventAction("ec_perf_load_more_mall_inner_feed_immersion", new Pair[]{TuplesKt.to("show_loadmore", Integer.valueOf(r3 ? 1 : 0)), TuplesKt.to("inner_type", 0)});
    }

    public static final String a(DeepFeedProductEventTracker r1, InFeedProductV2 r2) {
        r1.getClass();
        InFeedProductPackData r3 = r2.getPackData();
        if (r3 == null) goto L25;
        InFeedProductPackDataElements r4 = r3.getElements();
        if (r4 == null) goto L25;
        ie3.a r5 = r4.getAd();
        if (r5 == null) goto L25;
        AdBaseInfo r6 = r5.a();
        if (r6 == null) goto L25;
        Integer r7 = r6.getPricingType();
        if (r7 != null) goto L14;
    L16:
        String r8 = r6.getAdPackCell();
        if (r8 != null) goto L19;
    L22:
        boolean r9 = true;
    L23:
        if (r9 == true) goto L25;
        return "effective_ad";
    L19:
        if (r8.length() == 0) goto L22;
        r9 = false;
        goto L23
    L14:
        if (r7.intValue() != 2) goto L16;
        return "brand_ad";
    L25:
        return null;
    }

    public static void c(Map r2, Map r3) {
        if (r3 == null) goto L7;
        Iterator r4 = r3.entrySet().iterator();
    L5:
        if (r4.hasNext() == false) goto L9;
        Map.Entry r0 = (Map.Entry) r4.next();
        r2.put(r0.getKey(), r0.getValue());
        goto L5
    L9:
        return;
    }

    public static void f(InFeedProductV2 r1, Map r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (com.bytedance.android.shopping.deepfeed.utlis.g.b(r1) != true) goto L8;
        r2.put("has_live_header", "1");
        return;
    }

    public static Map d(int r13, InFeedProductV2 r14, Map r15) {
        String r1 = null;
        if (r14 == null) goto L5;
        Map<String, Object> r2 = com.bytedance.android.shopping.deepfeed.utlis.a.b(r14, "click_product");
    L6:
        if (r2 != null) goto L8;
        r2 = MapsKt.emptyMap();
    L8:
        boolean r3 = true;
        if (r14 == null) goto L36;
        InFeedProductPackData r5 = r14.getPackData();
        if (r5 == null) goto L36;
        InFeedProductPackDataElements r6 = r5.getElements();
        if (r6 == null) goto L36;
        Intrinsics.checkNotNullParameter(r6, "$this$eventLiveInfo");
        n0 r7 = r6.getSliceCard();
        if (r7 == null) goto L21;
        y r8 = r7.c;
        if (r8 == null) goto L21;
        a0 r9 = r8.a();
        if (r9 == null) goto L21;
        c0 r10 = r9.b();
    L22:
        if (r10 == null) goto L36;
        f0 r11 = r10.a();
        if (r11 == null) goto L36;
        String r12 = r11.a();
        if (r12 == null) goto L36;
        if (r12.length() <= 0) goto L30;
        boolean r16 = true;
    L31:
        if (r16 == true) goto L34;
        r12 = null;
    L34:
        if (r12 == null) goto L36;
        Uri r17 = UriProtector.parse(r12);
    L37:
        Object r18 = r2.get("outflow_order");
        if (r18 != null) goto L42;
        if (r15 == null) goto L41;
        r18 = r15.get("outflow_order");
        goto L42
    L41:
        r18 = null;
    L42:
        Object r19 = r2.get(PdpOpenThirdParam.KEY_PRODUCT_ID);
        if (r19 != null) goto L49;
        if (r14 == null) goto L48;
        e1 r20 = com.bytedance.android.shopping.deepfeed.utlis.a.a(r14);
        if (r20 == null) goto L48;
        r19 = r20.a();
    L48:
        r19 = null;
    L49:
        Object r4 = r2.get("recommend_info");
        if (r4 != null) goto L56;
        if (r14 == null) goto L55;
        u0 r110 = r14.getCustom();
        if (r110 == null) goto L55;
        r4 = r110.a();
    L55:
        r4 = null;
    L56:
        Pair[] r111 = new Pair[9];
        if (r17 == null) goto L59;
        String r112 = UriProtector.getQueryParameter(r17, "enter_from_merge");
    L60:
        r111[0] = TuplesKt.to("enter_from_merge", r112);
        if (r17 == null) goto L63;
        String r113 = UriProtector.getQueryParameter(r17, "enter_method");
    L64:
        r111[1] = TuplesKt.to("enter_method", r113);
        if (r17 == null) goto L67;
        String r114 = UriProtector.getQueryParameter(r17, "room_id");
    L68:
        r111[2] = TuplesKt.to("room_id", r114);
        if (r17 == null) goto L71;
        String r115 = UriProtector.getQueryParameter(r17, "request_id");
    L72:
        r111[3] = TuplesKt.to("request_id", r115);
        r111[4] = TuplesKt.to("inflow_order", Integer.valueOf(r13));
        r111[5] = TuplesKt.to("outflow_order", r18);
        r111[6] = TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, r19);
        r111[7] = TuplesKt.to("recommend_info", r4);
        if (r17 == null) goto L95;
        r1 = UriProtector.getQueryParameter(r17, "ecom_live_params");
    L95:
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L88
        if (r1 != null) goto L78;
    L81:
        if (r3 == false) goto L83;
        JSONObject r22 = new JSONObject();     // Catch: Throwable -> L88
    L86:
        Object r23 = Result.constructor-impl(r22);     // Catch: Throwable -> L88
    L90:
        JSONObject r24 = new JSONObject();
        if (Result.isFailure-impl(r23) == false) goto L93;
        r23 = r24;
    L93:
        JSONObject r25 = (JSONObject) r23;
        r25.put("inflow_order", r13);
        r25.put("outflow_order", r18);
        r25.put(PdpOpenThirdParam.KEY_PRODUCT_ID, r19);
        r25.put("recommend_info", r4);
        r111[8] = TuplesKt.to("pass_through_log_data", r25);
        Map r116 = MapsKt.mutableMapOf(r111);
        CollectionsKt.removeAll(r116.entrySet(), DeepFeedProductEventTracker$buildLiveShowParams$1$1.INSTANCE);
        return r116;
    L83:
        r22 = new JSONObject(r1).optJSONObject("pass_through_log_data");     // Catch: Throwable -> L88
        if (r22 != null) goto L86;
        r22 = new JSONObject();     // Catch: Throwable -> L88
        goto L86
    L78:
        if (r1.length() == 0) goto L81;
        r3 = false;
    L88:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L90
    L71:
        r115 = null;
        goto L72
    L67:
        r114 = null;
        goto L68
    L63:
        r113 = null;
        goto L64
    L59:
        r112 = null;
        goto L60
    L30:
        r16 = false;
    L21:
        r10 = null;
    L36:
        r17 = null;
        goto L37
    L5:
        r2 = null;
        goto L6
    }

    public static Map e(int r8, InFeedProductV2 r9, DeepFeedQueryParam r10) {
        String r0 = null;
        if (r9 == null) goto L104;
        InFeedProductPackData r1 = r9.getPackData();
        if (r1 == null) goto L104;
        InFeedProductPackDataElements r2 = r1.getElements();
        if (r2 == null) goto L104;
        String r3 = com.bytedance.android.shopping.deepfeed.utlis.a.e(r2);
        Intrinsics.checkNotNullParameter(r2, "$this$searchStrPoint");
        List<p0> r4 = r2.getProducts();
        if (r4 == null) goto L23;
        p0 r5 = (p0) CollectionsKt.firstOrNull(r4);
        if (r5 == null) goto L23;
        w1 r6 = r5.o();
        if (r6 == null) goto L23;
        List<x1> r7 = r6.a();
        if (r7 == null) goto L23;
        x1 r11 = (x1) CollectionsKt.firstOrNull(r7);
        if (r11 == null) goto L23;
        y1 r12 = r11.c();
        if (r12 == null) goto L23;
        z1 r13 = r12.a();
        if (r13 == null) goto L23;
    L29:
        Intrinsics.checkNotNullParameter(r2, "$this$searchKey");
        List<p0> r14 = r2.getProducts();
        if (r14 == null) goto L41;
        p0 r15 = (p0) CollectionsKt.firstOrNull(r14);
        if (r15 == null) goto L41;
        w1 r16 = r15.o();
        if (r16 == null) goto L41;
        List<x1> r17 = r16.a();
        if (r17 == null) goto L41;
        x1 r18 = (x1) CollectionsKt.firstOrNull(r17);
        if (r18 == null) goto L41;
        String r19 = r18.a();
        if (r19 == null) goto L41;
    L49:
        Pair[] r20 = new Pair[15];
        r20[0] = TuplesKt.to("inflow_order", Integer.valueOf(r8));
        z0 r21 = r9.getRespExtra();
        if (r21 == null) goto L52;
        Integer r22 = r21.b();
    L53:
        r20[1] = TuplesKt.to("inflow_page_number", r22);
        r20[2] = TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, r3);
        if (r10 == null) goto L56;
        String r110 = r10.getFirstCardProductId();
    L57:
        r20[3] = TuplesKt.to("related_product_id", r110);
        u0 r111 = r9.getCustom();
        if (r111 == null) goto L60;
        String r112 = r111.a();
    L61:
        r20[4] = TuplesKt.to("recommend_info", r112);
        z0 r23 = r9.getRespExtra();
        if (r23 == null) goto L64;
        String r24 = r23.c();
    L65:
        r20[5] = TuplesKt.to("request_id", r24);
        r20[6] = TuplesKt.to(SimilarProductParam.ENTER_FROM, "search_order_center");
        r20[7] = TuplesKt.to("words_source", "guess_search");
        r20[8] = TuplesKt.to("words_content", r19);
        r20[9] = TuplesKt.to("from_gid", r3);
        r20[10] = TuplesKt.to("enter_group_id", r3);
        if (r13 == null) goto L69;
        String r25 = r13.a();
        if (r25 == null) goto L69;
    L77:
        r20[11] = TuplesKt.to("group_id", r25);
        if (r13 == null) goto L81;
        String r26 = r13.b();
        if (r26 == null) goto L81;
    L89:
        r20[12] = TuplesKt.to("impr_id", r26);
        if (r13 == null) goto L95;
        String r27 = r13.c();
        if (r27 == null) goto L95;
        r0 = r27;
    L102:
        r20[13] = TuplesKt.to("reason", r0);
        r20[14] = TuplesKt.to("rank", Integer.valueOf(r8));
        return MapsKt.mutableMapOf(r20);
    L95:
        n0 r28 = r2.getSliceCard();
        if (r28 == null) goto L102;
        k0 r29 = r28.e();
        if (r29 == null) goto L102;
        w r30 = r29.g();
        if (r30 == null) goto L102;
        r0 = r30.c();
    L81:
        n0 r31 = r2.getSliceCard();
        if (r31 == null) goto L88;
        k0 r32 = r31.e();
        if (r32 == null) goto L88;
        w r33 = r32.g();
        if (r33 == null) goto L88;
        r26 = r33.b();
    L88:
        r26 = null;
    L69:
        n0 r34 = r2.getSliceCard();
        if (r34 == null) goto L76;
        k0 r35 = r34.e();
        if (r35 == null) goto L76;
        w r36 = r35.g();
        if (r36 == null) goto L76;
        r25 = r36.a();
    L76:
        r25 = null;
        goto L77
    L64:
        r24 = null;
        goto L65
    L60:
        r112 = null;
        goto L61
    L56:
        r110 = null;
        goto L57
    L52:
        r22 = null;
    L41:
        n0 r37 = r2.getSliceCard();
        if (r37 == null) goto L48;
        k0 r38 = r37.e();
        if (r38 == null) goto L48;
        w r39 = r38.g();
        if (r39 == null) goto L48;
        r19 = r39.d();
    L48:
        r19 = null;
    L23:
        n0 r40 = r2.getSliceCard();
        if (r40 == null) goto L28;
        k0 r41 = r40.e();
        if (r41 == null) goto L28;
        r13 = r41.g();
    L28:
        r13 = null;
    L104:
        return null;
    }

    public final Map<String, Object> g(int r13, InFeedProductV2 r14, List<String> r15) {
        if (r14 == null) goto L190;
        InFeedProductPackData r0 = r14.getPackData();
        if (r0 == null) goto L190;
        InFeedProductPackDataElements r1 = r0.getElements();
        if (r1 == null) goto L190;
        Intrinsics.checkNotNullParameter(r1, "$this$eventRoomId");
        List<p0> r2 = r1.getProducts();
        if (r2 == null) goto L16;
        p0 r3 = (p0) CollectionsKt.firstOrNull(r2);
        if (r3 == null) goto L16;
        e1 r4 = r3.b();
        if (r4 == null) goto L16;
        String r5 = r4.c();
        if (r5 == null) goto L16;
    L24:
        List<e2> r6 = com.bytedance.android.shopping.deepfeed.utlis.a.f(r1);
        Intrinsics.checkNotNullParameter(r1, "$this$eventMainImage");
        List<p0> r7 = r1.getProducts();
        if (r7 == null) goto L32;
        p0 r8 = (p0) CollectionsKt.firstOrNull(r7);
        if (r8 == null) goto L32;
        k1 r9 = r8.g();
        if (r9 == null) goto L32;
        List<InFeedUrlModel> r10 = r9.b();
        if (r10 == null) goto L32;
    L40:
        List<e2> r11 = com.bytedance.android.shopping.deepfeed.utlis.a.f(r1);
        Intrinsics.checkNotNullParameter(r1, "$this$eventPriceInfo");
        List<p0> r12 = r1.getProducts();
        if (r12 == null) goto L46;
        p0 r16 = (p0) CollectionsKt.firstOrNull(r12);
        if (r16 == null) goto L46;
        p1 r17 = r16.k();
        if (r17 == null) goto L46;
    L52:
        Map<String, Object> r18 = com.bytedance.android.shopping.deepfeed.utlis.a.l(r1);
        Intrinsics.checkNotNullParameter(r1, "$this$eventRecReasonInfo");
        List<p0> r19 = r1.getProducts();
        if (r19 == null) goto L58;
        p0 r20 = (p0) CollectionsKt.firstOrNull(r19);
        if (r20 == null) goto L58;
        r1 r21 = r20.m();
        if (r21 == null) goto L58;
    L64:
        Pair[] r22 = new Pair[14];
        r22[0] = TuplesKt.to("inflow_order", Integer.valueOf(r13));
        z0 r110 = r14.getRespExtra();
        if (r110 == null) goto L67;
        Integer r111 = r110.b();
    L68:
        r22[1] = TuplesKt.to("inflow_page_number", r111);
        r22[2] = TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, com.bytedance.android.shopping.deepfeed.utlis.a.e(r1));
        u0 r112 = r14.getCustom();
        if (r112 == null) goto L71;
        String r113 = r112.a();
    L72:
        r22[3] = TuplesKt.to("recommend_info", r113);
        z0 r114 = r14.getRespExtra();
        if (r114 == null) goto L75;
        String r115 = r114.c();
    L76:
        r22[4] = TuplesKt.to("request_id", r115);
        if (r17 == null) goto L79;
        String r116 = k.b(r17).toString();
    L80:
        r22[5] = TuplesKt.to("price_info", r116);
        if (r21 == null) goto L83;
        String r117 = k.b(r21).toString();
    L84:
        r22[6] = TuplesKt.to("rec_reasons", r117);
        if (r10 == null) goto L91;
        InFeedUrlModel r118 = (InFeedUrlModel) CollectionsKt.firstOrNull(r10);
        if (r118 == null) goto L91;
        List r119 = r118.getUrlList();
        if (r119 == null) goto L91;
        String r120 = (String) CollectionsKt.firstOrNull(r119);
    L92:
        r22[7] = TuplesKt.to("uri", r120);
        int r121 = f.a;
        r22[8] = TuplesKt.to("main_pic_type", f.d(r11, r10, r5, com.bytedance.android.shopping.extensions.k.c(r5)));
        if (r6 == null) goto L100;
        e2 r122 = (e2) CollectionsKt.firstOrNull(r6);
        if (r122 == null) goto L100;
        f2 r123 = r122.c();
        if (r123 == null) goto L100;
        String r124 = r123.a();
        if (r124 == null) goto L100;
    L101:
        r22[9] = TuplesKt.to("video_type", r124);
        if (r17 == null) goto L107;
        o1 r125 = r17.b();
        if (r125 == null) goto L107;
        String r126 = r125.a();
        if (r126 == null) goto L107;
    L112:
        r22[10] = TuplesKt.to("price_type", r126);
        if (r11 == null) goto L117;
        e2 r127 = (e2) CollectionsKt.firstOrNull(r11);
        if (r127 == null) goto L117;
        String r128 = r127.e();
    L118:
        r22[11] = TuplesKt.to("video_id", r128);
        if (r18 == null) goto L125;
        String r23 = r18.toString();
        if (r23 == null) goto L125;
        JSONObject r24 = k.c(r23);
        if (r24 == null) goto L125;
        String r25 = r24.optString("standard_track_param");
    L126:
        r22[12] = TuplesKt.to("standard_track_param", r25);
        if (r18 == null) goto L133;
        String r26 = r18.toString();
        if (r26 == null) goto L133;
        JSONObject r27 = k.c(r26);
        if (r27 == null) goto L133;
        String r28 = r27.optString("standard_product_marketing_param");
    L134:
        r22[13] = TuplesKt.to("standard_product_marketing_param", r28);
        Map<String, Object> r129 = MapsKt.mutableMapOf(r22);
        Intrinsics.checkNotNullParameter(r14, "$this$product");
        InFeedProductPackDataElements r29 = com.bytedance.android.shopping.deepfeed.utlis.a.d(r14);
        if (r29 == null) goto L139;
        List<p0> r30 = r29.getProducts();
        if (r30 == null) goto L139;
        p0 r31 = (p0) CollectionsKt.firstOrNull(r30);
    L140:
        if (r31 == null) goto L144;
        Map<String, Object> r32 = r31.a();
        if (r32 == null) goto L144;
        r129.putAll(r32);
    L144:
        ArrayList r33 = new ArrayList();
        if (r15 == null) goto L162;
        Iterator<T> r130 = r15.iterator();
    L148:
        if (r130.hasNext() == false) goto L162;
        JSONObject r34 = k.c((String) r130.next());
        if (r34 == null) goto L152;
        String r35 = r34.optString("tag_code");
    L153:
        if (r35 != null) goto L155;
    L158:
        boolean r36 = true;
    L159:
        if (r36 == true) goto L148;
        r33.add(r35);
        goto L148
    L155:
        if (r35.length() == 0) goto L158;
        r36 = false;
        goto L159
    L152:
        r35 = null;
    L162:
        if ((!r33.isEmpty()) == false) goto L165;
        r129.put("tag_code_list", r33);
    L165:
        if (r14.isCacheData() == false) goto L168;
        r129.put("is_cache_data", "1");
    L168:
        if (this.b == false) goto L170;
        g33.b r131 = g33.b.b;
        r129.put("last_predict_hand_result", r131.F("last_predict"));
        r129.put("recently_used_hand_result", r131.F("recently_used"));
    L170:
        h2 r132 = com.bytedance.android.shopping.deepfeed.utlis.a.j(r14);
        if (r132 == null) goto L188;
        List<d1> r133 = r132.a();
        if (r133 == null) goto L188;
        d1 r134 = (d1) CollectionsKt.firstOrNull(r133);
        if (r134 == null) goto L188;
        Map<String, Object> r135 = r134.b();
        if (r135 == null) goto L181;
        Object r136 = r135.get("coupon_bsk");
        if (r136 == null) goto L181;
        r129.put("coupon_bsk", r136);
    L181:
        String r137 = r134.c();
        if (r137 == null) goto L184;
        r129.put("coupon_discount", r137);
    L184:
        String r138 = r134.d();
        if (r138 == null) goto L187;
        r129.put("coupon_activity_id", r138);
    L187:
        r129.put("coupon_need_apply", "1");
    L188:
        return r129;
    L139:
        r31 = null;
    L133:
        r28 = null;
    L125:
        r25 = null;
    L117:
        r128 = null;
    L107:
        if (r17 == null) goto L111;
        o1 r139 = r17.d();
        if (r139 == null) goto L111;
        r126 = r139.a();
    L111:
        r126 = null;
    L100:
        r124 = "";
    L91:
        r120 = null;
        goto L92
    L83:
        r117 = null;
        goto L84
    L79:
        r116 = null;
        goto L80
    L75:
        r115 = null;
        goto L76
    L71:
        r113 = null;
        goto L72
    L67:
        r111 = null;
    L58:
        n0 r37 = r1.getSliceCard();
        if (r37 == null) goto L63;
        y r38 = r37.c;
        if (r38 == null) goto L63;
        r21 = r38.d();
    L63:
        r21 = null;
    L46:
        n0 r39 = r1.getSliceCard();
        if (r39 == null) goto L51;
        y r40 = r39.c;
        if (r40 == null) goto L51;
        r17 = r40.c();
    L51:
        r17 = null;
    L32:
        n0 r41 = r1.getSliceCard();
        if (r41 == null) goto L39;
        y r42 = r41.c;
        if (r42 == null) goto L39;
        a0 r43 = r42.a();
        if (r43 == null) goto L39;
        r10 = r43.a();
    L39:
        r10 = null;
    L16:
        n0 r44 = r1.getSliceCard();
        if (r44 == null) goto L23;
        k0 r45 = r44.e();
        if (r45 == null) goto L23;
        e1 r46 = r45.b();
        if (r46 == null) goto L23;
        r5 = r46.c();
    L23:
        r5 = null;
    L190:
        return new LinkedHashMap();
    }

    public final void l(String r4, View r5, InFeedProductV2 r6, String r7) {
        Intrinsics.checkNotNullParameter(r5, FreqActions.ACTION_VIEW);
        if (r7 != null) goto L5;
        r7 = "click_cart_entrance";
    L5:
        Pair[] r0 = new Pair[2];
        r0[0] = TuplesKt.to("inflow_order", -1);
        if (r6 == null) goto L10;
        z0 r8 = r6.getRespExtra();
        if (r8 == null) goto L10;
        Integer r9 = r8.b();
    L11:
        r0[1] = TuplesKt.to("inflow_page_number", r9);
        Map<String, ? extends Object> r10 = MapsKt.mutableMapOf(r0);
        le3.b.a(r10, r4, r5);
        doEventAction(r7, r10);
        return;
    L10:
        r9 = null;
        goto L11
    }

    public static /* synthetic */ void q(DeepFeedProductEventTracker r7, int r8, InFeedProductV2 r9, String r10, View r11) {
        r7.p(r8, r9, r10, r11, null, null);
    }

    public final void u(Integer r4, InFeedProductV2 r5, String r6, Map<String, ? extends Object> r7, String r8) {
        if (r8 != null) goto L4;
        r8 = "product_tag_show";
    L4:
        if (r5 == null) goto L22;
        InFeedProductPackData r0 = r5.getPackData();
        if (r0 == null) goto L23;
        InFeedProductPackDataElements r1 = r0.getElements();
        if (r1 == null) goto L24;
        String r2 = com.bytedance.android.shopping.deepfeed.utlis.a.e(r1);
        if (r2 != null) goto L13;
        return;
    L13:
        Pair[] r3 = new Pair[6];
        r3[0] = TuplesKt.to("inflow_order", r4);
        z0 r9 = r5.getRespExtra();
        if (r9 == null) goto L16;
        Integer r10 = r9.b();
    L17:
        r3[1] = TuplesKt.to("inflow_page_number", r10);
        r3[2] = TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, r2);
        r3[3] = TuplesKt.to("tag_show_scene", "guess_you_like");
        r3[4] = TuplesKt.to("tag_show_page_position", "guessyoulike_deep_feed_card");
        if (r6 != null) goto L20;
        r6 = "";
    L20:
        r3[5] = TuplesKt.to("product_tag", r6);
        Map<String, ? extends Object> r11 = MapsKt.mutableMapOf(r3);
        c(r11, r7);
        doEventAction(r8, r11);
        return;
    L16:
        r10 = null;
        goto L17
    L24:
        return;
    L23:
        return;
    }

    public final void x(String r4, View r5, InFeedProductV2 r6, Map<String, ? extends Object> r7, String r8) {
        Intrinsics.checkNotNullParameter(r5, FreqActions.ACTION_VIEW);
        if (r8 != null) goto L5;
        r8 = "show_cart_entrance";
    L5:
        Pair[] r0 = new Pair[2];
        r0[0] = TuplesKt.to("inflow_order", -1);
        if (r6 == null) goto L12;
        z0 r9 = r6.getRespExtra();
        if (r9 == null) goto L12;
        Integer r10 = r9.b();
        if (r10 == null) goto L12;
        int r11 = r10.intValue();
    L13:
        r0[1] = TuplesKt.to("inflow_page_number", Integer.valueOf(r11));
        Map<String, ? extends Object> r12 = MapsKt.mutableMapOf(r0);
        c(r12, r7);
        le3.b.a(r12, r4, r5);
        doEventAction(r8, r12);
        return;
    L12:
        r11 = 1;
        goto L13
    }

    public final void A(int r4, InFeedProductV2 r5, String r6, View r7, Map<String, ? extends Object> r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, FreqActions.ACTION_VIEW);
        if (r9 != null) goto L5;
        r9 = "show_store_entrance";
    L5:
        if (r5 == null) goto L19;
        InFeedProductPackData r0 = r5.getPackData();
        if (r0 == null) goto L20;
        InFeedProductPackDataElements r1 = r0.getElements();
        if (r1 == null) goto L21;
        String r2 = com.bytedance.android.shopping.deepfeed.utlis.a.e(r1);
        if (r2 == null) goto L22;
        Pair[] r3 = new Pair[3];
        r3[0] = TuplesKt.to("inflow_order", Integer.valueOf(r4));
        r3[1] = TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, r2);
        z0 r10 = r5.getRespExtra();
        if (r10 == null) goto L16;
        Integer r11 = r10.b();
    L17:
        r3[2] = TuplesKt.to("inflow_page_number", r11);
        Map<String, ? extends Object> r12 = MapsKt.mutableMapOf(r3);
        c(r12, r8);
        le3.b.a(r12, r6, r7);
        doEventAction(r9, r12);
        return;
    L16:
        r11 = null;
        goto L17
    L22:
        return;
    L21:
        return;
    L20:
        return;
    }

    public final void B(int r4, InFeedProductV2 r5, String r6, View r7, Map<String, ? extends Object> r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, FreqActions.ACTION_VIEW);
        if (r9 != null) goto L5;
        r9 = "show_wish_button";
    L5:
        if (r5 == null) goto L19;
        InFeedProductPackData r0 = r5.getPackData();
        if (r0 == null) goto L20;
        InFeedProductPackDataElements r1 = r0.getElements();
        if (r1 == null) goto L21;
        String r2 = com.bytedance.android.shopping.deepfeed.utlis.a.e(r1);
        if (r2 == null) goto L22;
        Pair[] r3 = new Pair[3];
        r3[0] = TuplesKt.to("inflow_order", Integer.valueOf(r4));
        z0 r10 = r5.getRespExtra();
        if (r10 == null) goto L16;
        Integer r11 = r10.b();
    L17:
        r3[1] = TuplesKt.to("inflow_page_number", r11);
        r3[2] = TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, r2);
        Map<String, ? extends Object> r12 = MapsKt.mutableMapOf(r3);
        c(r12, r8);
        le3.b.a(r12, r6, r7);
        doEventAction(r9, r12);
        return;
    L16:
        r11 = null;
        goto L17
    L22:
        return;
    L21:
        return;
    L20:
        return;
    }

    public final void C(int r3, int r4, boolean r5, String r6, View r7, InFeedProductV2 r8) {
        Intrinsics.checkNotNullParameter(r7, FreqActions.ACTION_VIEW);
        Pair[] r0 = new Pair[4];
        r0[0] = TuplesKt.to("inflow_order", Integer.valueOf(r3));
        if (r5 == false) goto L5;
        String r9 = PageScrollStatus.slide;
    L6:
        r0[1] = TuplesKt.to("slide_type", r9);
        if (r8 == null) goto L11;
        z0 r10 = r8.getRespExtra();
        if (r10 == null) goto L11;
        Integer r11 = r10.b();
    L12:
        r0[2] = TuplesKt.to("inflow_page_number", r11);
        r0[3] = TuplesKt.to("item_order", Integer.valueOf(r4));
        Map<String, ? extends Object> r12 = MapsKt.mutableMapOf(r0);
        le3.b.a(r12, r6, r7);
        doEventAction("slide_product_big_picture", r12);
        return;
    L11:
        r11 = null;
        goto L12
    L5:
        r9 = "default";
        goto L6
    }

    public final void m(int r4, InFeedProductV2 r5, String r6, View r7, Map<String, ? extends Object> r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, FreqActions.ACTION_VIEW);
        if (r9 != null) goto L5;
        r9 = "click_comment_entrance";
    L5:
        if (r5 == null) goto L19;
        InFeedProductPackData r0 = r5.getPackData();
        if (r0 == null) goto L20;
        InFeedProductPackDataElements r1 = r0.getElements();
        if (r1 == null) goto L21;
        String r2 = com.bytedance.android.shopping.deepfeed.utlis.a.e(r1);
        if (r2 == null) goto L22;
        Pair[] r3 = new Pair[3];
        r3[0] = TuplesKt.to("inflow_order", Integer.valueOf(r4));
        z0 r10 = r5.getRespExtra();
        if (r10 == null) goto L16;
        Integer r11 = r10.b();
    L17:
        r3[1] = TuplesKt.to("inflow_page_number", r11);
        r3[2] = TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, r2);
        Map<String, ? extends Object> r12 = MapsKt.mutableMapOf(r3);
        c(r12, r8);
        le3.b.a(r12, r6, r7);
        doEventAction(r9, r12);
        return;
    L16:
        r11 = null;
        goto L17
    L22:
        return;
    L21:
        return;
    L20:
        return;
    }

    public final void p(int r4, InFeedProductV2 r5, String r6, View r7, Map<String, ? extends Object> r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, FreqActions.ACTION_VIEW);
        if (r9 != null) goto L5;
        r9 = "click_store_entrance";
    L5:
        if (r5 == null) goto L19;
        InFeedProductPackData r0 = r5.getPackData();
        if (r0 == null) goto L20;
        InFeedProductPackDataElements r1 = r0.getElements();
        if (r1 == null) goto L21;
        String r2 = com.bytedance.android.shopping.deepfeed.utlis.a.e(r1);
        if (r2 == null) goto L22;
        Pair[] r3 = new Pair[3];
        r3[0] = TuplesKt.to("inflow_order", Integer.valueOf(r4));
        r3[1] = TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, r2);
        z0 r10 = r5.getRespExtra();
        if (r10 == null) goto L16;
        Integer r11 = r10.b();
    L17:
        r3[2] = TuplesKt.to("inflow_page_number", r11);
        Map<String, ? extends Object> r12 = MapsKt.mutableMapOf(r3);
        f(r5, r12);
        c(r12, r8);
        le3.b.a(r12, r6, r7);
        doEventAction(r9, r12);
        return;
    L16:
        r11 = null;
        goto L17
    L22:
        return;
    L21:
        return;
    L20:
        return;
    }

    public final void r(int r4, InFeedProductV2 r5, String r6, View r7, Map<String, ? extends Object> r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, FreqActions.ACTION_VIEW);
        if (r9 != null) goto L5;
        r9 = "click_wish_button";
    L5:
        if (r5 == null) goto L19;
        InFeedProductPackData r0 = r5.getPackData();
        if (r0 == null) goto L20;
        InFeedProductPackDataElements r1 = r0.getElements();
        if (r1 == null) goto L21;
        String r2 = com.bytedance.android.shopping.deepfeed.utlis.a.e(r1);
        if (r2 == null) goto L22;
        Pair[] r3 = new Pair[3];
        r3[0] = TuplesKt.to("inflow_order", Integer.valueOf(r4));
        z0 r10 = r5.getRespExtra();
        if (r10 == null) goto L16;
        Integer r11 = r10.b();
    L17:
        r3[1] = TuplesKt.to("inflow_page_number", r11);
        r3[2] = TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, r2);
        Map<String, ? extends Object> r12 = MapsKt.mutableMapOf(r3);
        c(r12, r8);
        le3.b.a(r12, r6, r7);
        doEventAction(r9, r12);
        return;
    L16:
        r11 = null;
        goto L17
    L22:
        return;
    L21:
        return;
    L20:
        return;
    }

    public final void v(int r4, InFeedProductV2 r5, String r6, View r7, Map<String, ? extends Object> r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, FreqActions.ACTION_VIEW);
        if (r9 != null) goto L5;
        r9 = "show_add_to_cart";
    L5:
        if (r5 == null) goto L20;
        InFeedProductPackData r0 = r5.getPackData();
        if (r0 == null) goto L21;
        InFeedProductPackDataElements r1 = r0.getElements();
        if (r1 == null) goto L22;
        String r2 = com.bytedance.android.shopping.deepfeed.utlis.a.e(r1);
        if (r2 != null) goto L14;
        return;
    L14:
        Pair[] r3 = new Pair[3];
        r3[0] = TuplesKt.to("inflow_order", Integer.valueOf(r4));
        z0 r10 = r5.getRespExtra();
        if (r10 == null) goto L17;
        Integer r11 = r10.b();
    L18:
        r3[1] = TuplesKt.to("inflow_page_number", r11);
        r3[2] = TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, r2);
        Map<String, ? extends Object> r12 = MapsKt.mutableMapOf(r3);
        c(r12, r8);
        le3.b.a(r12, r6, r7);
        doEventAction(r9, r12);
        return;
    L17:
        r11 = null;
        goto L18
    L22:
        return;
    L21:
        return;
    }

    public final void w(int r4, InFeedProductV2 r5, String r6, View r7, Map<String, ? extends Object> r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, FreqActions.ACTION_VIEW);
        if (r9 != null) goto L5;
        r9 = "show_buy_button";
    L5:
        if (r5 == null) goto L20;
        InFeedProductPackData r0 = r5.getPackData();
        if (r0 == null) goto L21;
        InFeedProductPackDataElements r1 = r0.getElements();
        if (r1 == null) goto L22;
        String r2 = com.bytedance.android.shopping.deepfeed.utlis.a.e(r1);
        if (r2 != null) goto L14;
        return;
    L14:
        Pair[] r3 = new Pair[3];
        r3[0] = TuplesKt.to("inflow_order", Integer.valueOf(r4));
        z0 r10 = r5.getRespExtra();
        if (r10 == null) goto L17;
        Integer r11 = r10.b();
    L18:
        r3[1] = TuplesKt.to("inflow_page_number", r11);
        r3[2] = TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, r2);
        Map<String, ? extends Object> r12 = MapsKt.mutableMapOf(r3);
        c(r12, r8);
        le3.b.a(r12, r6, r7);
        doEventAction(r9, r12);
        return;
    L17:
        r11 = null;
        goto L18
    L22:
        return;
    L21:
        return;
    }

    public final void y(int r4, InFeedProductV2 r5, String r6, View r7, Map<String, ? extends Object> r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, FreqActions.ACTION_VIEW);
        if (r9 != null) goto L5;
        r9 = "show_comment_entrance";
    L5:
        if (r5 == null) goto L19;
        InFeedProductPackData r0 = r5.getPackData();
        if (r0 == null) goto L20;
        InFeedProductPackDataElements r1 = r0.getElements();
        if (r1 == null) goto L21;
        String r2 = com.bytedance.android.shopping.deepfeed.utlis.a.e(r1);
        if (r2 == null) goto L22;
        Pair[] r3 = new Pair[3];
        r3[0] = TuplesKt.to("inflow_order", Integer.valueOf(r4));
        z0 r10 = r5.getRespExtra();
        if (r10 == null) goto L16;
        Integer r11 = r10.b();
    L17:
        r3[1] = TuplesKt.to("inflow_page_number", r11);
        r3[2] = TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, r2);
        Map<String, ? extends Object> r12 = MapsKt.mutableMapOf(r3);
        c(r12, r8);
        le3.b.a(r12, r6, r7);
        doEventAction(r9, r12);
        return;
    L16:
        r11 = null;
        goto L17
    L22:
        return;
    L21:
        return;
    L20:
        return;
    }

    public final void z(int r12, InFeedProductV2 r13, String r14, ConstraintLayout r15, List r16, Map r17) {
        Intrinsics.checkNotNullParameter(r15, FreqActions.ACTION_VIEW);
        if (r14 != null) goto L5;
        String r9 = "";
    L6:
        e r10 = new e(this, r14, r13, r12, r16, r17, r15);
        if (r9.length() != 0) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == false) goto L12;
        ExtKt.b("BstItemCreate", "btm is empty!");
    L12:
        com.bytedance.android.bst.api.d r1 = new com.bytedance.android.bst.api.d(r15);
        r1.a = r9;
        r1.b = "show_product";
        r1.c = r13;
        r1.d = null;
        r1.e = -1;
        r1.f = r10;
        com.bytedance.android.bst.api.f.b.getClass();
        com.bytedance.android.bst.api.f.a(r1);
        return;
    L9:
        r0 = false;
        goto L10
    L5:
        r9 = r14;
        goto L6
    }

    public static /* synthetic */ void o(DeepFeedProductEventTracker r8, int r9, InFeedProductV2 r10, String r11, String r12, View r13, List r14) {
        r8.n(r9, r10, r11, r12, r13, r14, null);
    }

    public final void j(int r12, InFeedProductV2 r13, String r14, View r15, JSONObject r16, Map<String, ? extends Object> r17, String r18) {
        if (r18 != null) goto L4;
        String r0 = "click_add_to_cart";
    L5:
        if (r13 == null) goto L57;
        e1 r1 = com.bytedance.android.shopping.deepfeed.utlis.a.a(r13);
        if (r1 == null) goto L57;
        String r2 = r1.a();
        if (r2 == null) goto L57;
        p1 r3 = com.bytedance.android.shopping.deepfeed.utlis.a.i(r13);
        r1 r4 = com.bytedance.android.shopping.deepfeed.utlis.a.k(r13);
        List<e2> r5 = com.bytedance.android.shopping.deepfeed.utlis.a.m(r13);
        List<InFeedUrlModel> r6 = com.bytedance.android.shopping.deepfeed.utlis.a.h(r13);
        Pair[] r7 = new Pair[13];
        r7[0] = TuplesKt.to("inflow_order", Integer.valueOf(r12));
        z0 r8 = r13.getRespExtra();
        String r9 = null;
        if (r8 == null) goto L14;
        Integer r10 = r8.b();
    L15:
        r7[1] = TuplesKt.to("inflow_page_number", r10);
        r7[2] = TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, r2);
        u0 r11 = r13.getCustom();
        if (r11 == null) goto L18;
        String r19 = r11.a();
    L19:
        r7[3] = TuplesKt.to("recommend_info", r19);
        z0 r20 = r13.getRespExtra();
        if (r20 == null) goto L22;
        String r21 = r20.c();
    L23:
        r7[4] = TuplesKt.to("request_id", r21);
        if (r3 == null) goto L26;
        String r22 = k.b(r3).toString();
    L27:
        r7[5] = TuplesKt.to("price_info", r22);
        if (r4 == null) goto L30;
        String r23 = k.b(r4).toString();
    L31:
        r7[6] = TuplesKt.to("rec_reasons", r23);
        if (r3 == null) goto L37;
        o1 r24 = r3.b();
        if (r24 == null) goto L37;
        String r25 = r24.a();
        if (r25 == null) goto L37;
    L42:
        r7[7] = TuplesKt.to("price_type", r25);
        int r26 = f.a;
        e1 r27 = com.bytedance.android.shopping.deepfeed.utlis.a.a(r13);
        if (r27 == null) goto L45;
        String r28 = r27.c();
    L46:
        e1 r29 = com.bytedance.android.shopping.deepfeed.utlis.a.a(r13);
        if (r29 == null) goto L49;
        String r30 = r29.c();
    L50:
        r7[8] = TuplesKt.to("main_pic_type", f.d(r5, r6, r28, com.bytedance.android.shopping.extensions.k.c(r30)));
        if (r5 == null) goto L55;
        e2 r31 = (e2) CollectionsKt.firstOrNull(r5);
        if (r31 == null) goto L55;
        r9 = r31.e();
    L55:
        r7[9] = TuplesKt.to("video_id", r9);
        r7[10] = TuplesKt.to("entrance_info", r16);
        r7[11] = TuplesKt.to("source_method", "guess_you_like");
        r7[12] = TuplesKt.to("is_live_product", 0);
        Map<String, ? extends Object> r32 = MapsKt.mutableMapOf(r7);
        c(r32, r17);
        le3.b.a(r32, r14, r15);
        doEventAction(r0, r32);
        return;
    L49:
        r30 = null;
        goto L50
    L45:
        r28 = null;
    L37:
        if (r3 == null) goto L41;
        o1 r33 = r3.d();
        if (r33 == null) goto L41;
        r25 = r33.a();
    L41:
        r25 = null;
        goto L42
    L30:
        r23 = null;
        goto L31
    L26:
        r22 = null;
        goto L27
    L22:
        r21 = null;
        goto L23
    L18:
        r19 = null;
        goto L19
    L14:
        r10 = null;
    L57:
        return;
    L4:
        r0 = r18;
        goto L5
    }

    public final void k(int r12, InFeedProductV2 r13, String r14, View r15, JSONObject r16, Map<String, ? extends Object> r17, String r18) {
        if (r18 != null) goto L4;
        String r0 = "click_buy_button";
    L5:
        if (r13 == null) goto L57;
        e1 r1 = com.bytedance.android.shopping.deepfeed.utlis.a.a(r13);
        if (r1 == null) goto L57;
        String r2 = r1.a();
        if (r2 == null) goto L57;
        p1 r3 = com.bytedance.android.shopping.deepfeed.utlis.a.i(r13);
        r1 r4 = com.bytedance.android.shopping.deepfeed.utlis.a.k(r13);
        List<e2> r5 = com.bytedance.android.shopping.deepfeed.utlis.a.m(r13);
        List<InFeedUrlModel> r6 = com.bytedance.android.shopping.deepfeed.utlis.a.h(r13);
        Pair[] r7 = new Pair[13];
        r7[0] = TuplesKt.to("inflow_order", Integer.valueOf(r12));
        z0 r8 = r13.getRespExtra();
        String r9 = null;
        if (r8 == null) goto L14;
        Integer r10 = r8.b();
    L15:
        r7[1] = TuplesKt.to("inflow_page_number", r10);
        r7[2] = TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, r2);
        u0 r11 = r13.getCustom();
        if (r11 == null) goto L18;
        String r19 = r11.a();
    L19:
        r7[3] = TuplesKt.to("recommend_info", r19);
        z0 r20 = r13.getRespExtra();
        if (r20 == null) goto L22;
        String r21 = r20.c();
    L23:
        r7[4] = TuplesKt.to("request_id", r21);
        if (r3 == null) goto L26;
        String r22 = k.b(r3).toString();
    L27:
        r7[5] = TuplesKt.to("price_info", r22);
        if (r4 == null) goto L30;
        String r23 = k.b(r4).toString();
    L31:
        r7[6] = TuplesKt.to("rec_reasons", r23);
        if (r3 == null) goto L37;
        o1 r24 = r3.b();
        if (r24 == null) goto L37;
        String r25 = r24.a();
        if (r25 == null) goto L37;
    L42:
        r7[7] = TuplesKt.to("price_type", r25);
        int r26 = f.a;
        e1 r27 = com.bytedance.android.shopping.deepfeed.utlis.a.a(r13);
        if (r27 == null) goto L45;
        String r28 = r27.c();
    L46:
        e1 r29 = com.bytedance.android.shopping.deepfeed.utlis.a.a(r13);
        if (r29 == null) goto L49;
        String r30 = r29.c();
    L50:
        r7[8] = TuplesKt.to("main_pic_type", f.d(r5, r6, r28, com.bytedance.android.shopping.extensions.k.c(r30)));
        if (r5 == null) goto L55;
        e2 r31 = (e2) CollectionsKt.firstOrNull(r5);
        if (r31 == null) goto L55;
        r9 = r31.e();
    L55:
        r7[9] = TuplesKt.to("video_id", r9);
        r7[10] = TuplesKt.to("entrance_info", r16);
        r7[11] = TuplesKt.to("source_method", "guess_you_like");
        r7[12] = TuplesKt.to("is_live_product", 0);
        Map<String, ? extends Object> r32 = MapsKt.mutableMapOf(r7);
        c(r32, r17);
        le3.b.a(r32, r14, r15);
        doEventAction(r0, r32);
        return;
    L49:
        r30 = null;
        goto L50
    L45:
        r28 = null;
    L37:
        if (r3 == null) goto L41;
        o1 r33 = r3.d();
        if (r33 == null) goto L41;
        r25 = r33.a();
    L41:
        r25 = null;
        goto L42
    L30:
        r23 = null;
        goto L31
    L26:
        r22 = null;
        goto L27
    L22:
        r21 = null;
        goto L23
    L18:
        r19 = null;
        goto L19
    L14:
        r10 = null;
    L57:
        return;
    L4:
        r0 = r18;
        goto L5
    }

    public final void n(int r12, InFeedProductV2 r13, String r14, String r15, View r16, List<String> r17, Map<String, ? extends Object> r18) {
        Intrinsics.checkNotNullParameter(r14, "clickArea");
        Intrinsics.checkNotNullParameter(r16, FreqActions.ACTION_VIEW);
        if (r15 != null) goto L5;
        String r9 = "";
    L6:
        b r10 = new b(this, r15, r13, r12, r17, r18, r16);
        if (r9.length() != 0) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == false) goto L12;
        ExtKt.b("BstItemCreate", "btm is empty!");
    L12:
        com.bytedance.android.bst.api.d r1 = new com.bytedance.android.bst.api.d(r16);
        r1.a = r9;
        r1.b = "click_product";
        r1.c = r13;
        r1.d = null;
        r1.e = -1;
        r1.f = r10;
        com.bytedance.android.bst.api.f.b.getClass();
        com.bytedance.android.bst.api.f.c(r1);
        return;
    L9:
        r0 = false;
        goto L10
    L5:
        r9 = r15;
        goto L6
    }

    public static /* synthetic */ void i(DeepFeedProductEventTracker r9, String r10, int r11, InFeedProductV2 r12, String r13, String r14, View r15, List r16) {
        r9.h(r10, r11, r12, r13, r14, r15, r16, null);
    }

    public final void h(String r2, int r3, InFeedProductV2 r4, String r5, String r6, View r7, List<String> r8, Map<String, ? extends Object> r9) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r5, "clickArea");
        Intrinsics.checkNotNullParameter(r7, FreqActions.ACTION_VIEW);
        Map<String, Object> r10 = g(r3, r4, r8);
        r10.put("click_area", r5);
        if (Intrinsics.areEqual(r2, "click_content_small_pic") == false) goto L5;
        f(r4, r10);
    L5:
        c(r10, r9);
        le3.b.a(r10, r6, r7);
        doEventAction(r2, r10);
    }

    public final void s(String r4, InFeedProductV2 r5, int r6, Map<String, ? extends Object> r7, String r8, List<String> r9, String r10, View r11) {
        Intrinsics.checkNotNullParameter(r4, "eventName");
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r8, "sameAs");
        Intrinsics.checkNotNullParameter(r11, FreqActions.ACTION_VIEW);
        if (r5 == null) goto L18;
        InFeedProductPackData r0 = r5.getPackData();
        if (r0 == null) goto L19;
        InFeedProductPackDataElements r1 = r0.getElements();
        if (r1 == null) goto L20;
        String r2 = com.bytedance.android.shopping.deepfeed.utlis.a.e(r1);
        if (r2 == null) goto L21;
        LinkedHashMap r3 = new LinkedHashMap();
        if (Intrinsics.areEqual(r8, "show_product") == false) goto L14;
    L15:
        r3.putAll(g(r6, r5, r9));
    L16:
        r3.putAll(r7);
        r3.put(PdpOpenThirdParam.KEY_PRODUCT_ID, r2);
        le3.b.a(r3, r10, r11);
        doEventAction(r4, r3);
        return;
    L14:
        if (Intrinsics.areEqual(r8, "click_product") == false) goto L16;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }
}
