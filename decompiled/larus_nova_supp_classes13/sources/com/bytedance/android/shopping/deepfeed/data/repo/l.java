package com.bytedance.android.shopping.deepfeed.data.repo;

import android.net.Uri;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.shopping.deepfeed.data.DeepFeedQueryParam;
import com.bytedance.android.shopping.deepfeed.data.api.DeepFeedCouponApi;
import com.bytedance.android.shopping.deepfeed.data.api.DeepFeedPackBFFApi;
import com.bytedance.android.shopping.deepfeed.data.api.DeepFeedProductCouponApi;
import com.bytedance.android.shopping.deepfeed.data.api.DeepFeedProductFeedBFFApi;
import com.bytedance.android.shopping.deepfeed.slice.DeepFeedSliceUtil;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackData;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackDataElements;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductResponse;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.jedi.model.repository.Repository;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.services.apm.api.EnsureManager;
import he3.h2;
import he3.i2;
import he3.n0;
import he3.y0;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l extends Repository implements fa3.d {
    public static final k q = null;
    public static final boolean r = false;
    public static final a s = null;
    public DeepFeedCouponApi b;
    public final List<InFeedProductV2> c;
    public String d;
    public MutableLiveData<he3.l> e;
    public Consumer<m> f;
    public boolean g;
    public Runnable h;
    public boolean i;
    public final Set<String> j;
    public final c k;
    public boolean l;
    public tf3.b m;
    public AbsDeepFeedRequest n;
    public final DeepFeedQueryParam o;
    public final /* synthetic */ fa3.b p;

    public static final class a {
        public a() {
        }

        public static boolean a(String r3) {
            Intrinsics.checkNotNullParameter(r3, "path");
            k r0 = l.q;
            if (Intrinsics.areEqual(r0.a(), Boolean.TRUE) == false) goto L9;
            List<String> r1 = r0.b();
            if (r1 == null) goto L9;
            if (r1.contains(r3) != true) goto L9;
            return true;
        L9:
            return false;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public b(Function1 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Function1 r0 = this.a;
            r0.invoke((uc3.c) r2);
        }
    }

    public static final class c {
        public c() {
        }
    }

    @Override // fa3.d
    public final Disposable add(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.p.add(r2);
        return r2;
    }

    static {
        s = new a();
        int r0 = s93.c.a;
        Object r1 = null;
        Object r2 = new k(null);
        IHybridHostService r3 = com.bytedance.android.ec.hybrid.a.h();
        if (r3 == null) goto L10;
        yj.g r4 = r3.getHostAB();
        if (r4 == null) goto L10;
        Object r5 = r4.a("ec_mall_deep_feed_net_listener_enable", r2);
        if (r5 == null) goto L10;
        r2 = r5;
    L10:
        Lazy r6 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.b, "Key : ec_mall_deep_feed_net_listener_enable, Value: " + r2);
        q = (k) r2;
        int r7 = com.bytedance.android.ec.hybrid.tools.f.a;
        Object r8 = Boolean.FALSE;
        int r9 = com.bytedance.android.ec.base.settings.c.a;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L91
        Object r11 = com.bytedance.android.ec.base.settings.d.c.get("mall_deep_feed_add_ad");     // Catch: Throwable -> L64
        if (r11 != null) goto L16;
    L61:
        Object r12 = null;
    L62:
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L64
    L66:
        Throwable r14 = Result.exceptionOrNull-impl(r13);     // Catch: Throwable -> L91
        if (r14 == null) goto L70;
        EnsureManager.ensureNotReachHere(r14);     // Catch: Throwable -> L91
    L70:
        if (Result.isFailure-impl(r13) == false) goto L73;
        r13 = null;
    L73:
        if ((r13 instanceof Boolean) == true) goto L75;
        r13 = null;
    L75:
        Boolean r15 = (Boolean) r13;     // Catch: Throwable -> L91
        if (r15 == null) goto L78;
        r8 = r15;
    L99:
        r = ((Boolean) r8).booleanValue();
        return;
    L78:
        IHybridHostService r16 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L91
        if (r16 == null) goto L81;
        Object r17 = r16.getHostABValue("mall_deep_feed_add_ad", r8);     // Catch: Throwable -> L91
    L82:
        if (r17 == null) goto L99;
        if ((r17 instanceof Boolean) == false) goto L87;
        r1 = r17;
    L87:
        Boolean r18 = (Boolean) r1;     // Catch: Throwable -> L91
        if (r18 == null) goto L99;
        r8 = r18;
        goto L99
    L81:
        r17 = null;
        goto L82
    L16:
        if ((r11 instanceof Boolean) == true) goto L18;
        Object r19 = null;
    L19:
        r12 = (Boolean) r19;     // Catch: Throwable -> L64
        if (r12 != null) goto L62;
        if ((r11 instanceof Number) == false) goto L49;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L31;
        Float r20 = Float.valueOf(((Number) r11).floatValue());     // Catch: Throwable -> L64
        if ((r20 instanceof Boolean) == true) goto L29;
        r20 = null;
    L29:
        r12 = (Boolean) r20;     // Catch: Throwable -> L64
        goto L62
    L31:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L37;
        Double r21 = Double.valueOf(((Number) r11).doubleValue());     // Catch: Throwable -> L64
        if ((r21 instanceof Boolean) == true) goto L35;
        r21 = null;
    L35:
        r12 = (Boolean) r21;     // Catch: Throwable -> L64
        goto L62
    L37:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L43;
        Integer r22 = Integer.valueOf(((Number) r11).intValue());     // Catch: Throwable -> L64
        if ((r22 instanceof Boolean) == true) goto L41;
        r22 = null;
    L41:
        r12 = (Boolean) r22;     // Catch: Throwable -> L64
        goto L62
    L43:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L49;
        Long r23 = Long.valueOf(((Number) r11).longValue());     // Catch: Throwable -> L64
        if ((r23 instanceof Boolean) == true) goto L47;
        r23 = null;
    L47:
        r12 = (Boolean) r23;     // Catch: Throwable -> L64
    L49:
        if ((r11 instanceof JSONObject) == false) goto L51;
    L101:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L57
        Object r24 = SDKSettingsCacheManager.a().fromJson(r11.toString(), Boolean.class);     // Catch: Throwable -> L57
        if ((r24 instanceof Boolean) == true) goto L55;
        r24 = null;
    L55:
        Object r25 = Result.constructor-impl((Boolean) r24);     // Catch: Throwable -> L57
    L59:
        r12 = r25;
        if (Result.isFailure-impl(r12) == false) goto L62;
    L57:
        th = move-exception;
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L64
        r25 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L64
        goto L59
    L51:
        if ((r11 instanceof JSONArray) == false) goto L61;
    L18:
        r19 = r11;
    L64:
        th = move-exception;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L91
        r13 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L91
    L91:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        Object r29 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r30 = Result.exceptionOrNull-impl(r29);
        if (r30 == null) goto L96;
        EnsureManager.ensureNotReachHere(r30);
    L96:
        if (Result.isFailure-impl(r29) == true) goto L99;
        r8 = r29;
        goto L99
    }

    public final o b() {
        AbsDeepFeedRequest r0 = this.n;
        if (r0 == null) goto L5;
    L19:
        return r0;
    L5:
        if (this.i == true) goto L19;
        DeepFeedAbValues r1 = this.o.getAbValues();
        if (r1 == null) goto L10;
        Integer r2 = r1.getDeepFeedUseSlc();
    L12:
        if (r2 != null) goto L15;
    L17:
        r0 = new DeepFeedRequest(false, this.o, this.m, this.c);
    L18:
        this.n = r0;
        goto L19
    L15:
        if (r2.intValue() != 1) goto L17;
        r0 = new DeepFeedBFFRequest(false, this.o, this.m, this.c);
        goto L18
    L10:
        r2 = null;
        goto L12
    }

    public final uc3.f g() {
        o r0 = b();
        if (r0 == null) goto L7;
        j r1 = ((AbsDeepFeedRequest) r0).i;
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new j();
    }

    public l(DeepFeedQueryParam r2) {
        Intrinsics.checkNotNullParameter(r2, "deepFeedParam");
        this.p = new fa3.b();
        this.o = r2;
        this.c = new ArrayList();
        this.j = new LinkedHashSet();
        this.k = new c();
    }

    public final void e(final Function1<? super Boolean, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        Intrinsics.checkNotNullParameter(r3, "callback");
        o r0 = b();
        if (r0 == null) goto L6;
        r0.a(new DeepFeedProductRepository$loadProductPack$1(this, r3));
        return;
    }

    public final void f(Uri r12) {
        Intrinsics.checkNotNullParameter(r12, "uri");
        DeepFeedSliceUtil.a();
        com.bytedance.android.shopping.deepfeed.ui.view.g.i.getClass();
        String r0 = UriProtector.getQueryParameter(r12, "outflow_product");
        JSONObject r1 = null;
        if (r0 == null) goto L5;
        JSONObject r2 = com.bytedance.android.shopping.extensions.k.w(r0);
    L6:
        String r3 = UriProtector.getQueryParameter(r12, "pre_product");
        if (r3 == null) goto L9;
        final JSONObject r4 = com.bytedance.android.shopping.extensions.k.w(r3);
    L10:
        if (r2 != null) goto L14;
        if (r4 != null) goto L14;
        return;
    L14:
        if (r == false) goto L22;
        if (r2 == null) goto L22;
        String r5 = r2.optString(PdpOpenThirdParam.KEY_PRODUCT_ID);
        JSONObject r6 = r2.optJSONObject("ad_params");
        if (r6 == null) goto L22;
        this.m = new tf3.b(r5, r6);
    L22:
        String r7 = UriProtector.getQueryParameter(r12, "triggers");
        boolean r8 = false;
        if (r7 != null) goto L25;
    L58:
        boolean r9 = false;
    L59:
        String r13 = UriProtector.getQueryParameter(r12, "ab_values");
        if (r13 == null) goto L62;
        r1 = com.bytedance.android.shopping.extensions.k.w(r13);
    L62:
        if (r1 != null) goto L64;
    L66:
        boolean r14 = false;
    L67:
        if (r1 != null) goto L69;
    L71:
        boolean r10 = false;
    L72:
        if (r1 != null) goto L74;
    L76:
        int r11 = ie3.b.a;
        if (r1 == null) goto L79;
        r1.optBoolean("deep_feed_qcpx_toast_show");
    L79:
        if (r14 == false) goto L81;
        com.bytedance.android.shopping.deepfeed.ui.vh.l.f = true;
    L81:
        if (r8 == false) goto L83;
        AbsDeepFeedRequest r15 = new DeepFeedBFFRequest(r10, this.o, this.m, this.c);
    L84:
        this.n = r15;
        o r16 = b();
        if (r16 == null) goto L87;
        r16.c(r4, r2, r9);
    L87:
        MutableLiveData<he3.l> r17 = this.e;
        if (r17 == null) goto L92;
        o r18 = b();
        if (r18 == null) goto L92;
        Intrinsics.checkNotNullParameter(r17, "liveData");
        ((AbsDeepFeedRequest) r18).c = r17;
    L92:
        Consumer<m> r19 = this.f;
        if (r19 == null) goto L99;
        o r20 = b();
        if (r20 == null) goto L100;
        ((AbsDeepFeedRequest) r20).J(r19);
        return;
    L100:
        return;
    L99:
        return;
    L83:
        r15 = new DeepFeedRequest(r10, this.o, this.m, this.c);
        goto L84
    L74:
        if (r1.optInt("deep_feed_slice") != 1) goto L76;
        r8 = true;
        goto L76
    L69:
        if (r1.optBoolean("style_optimize_v2") != true) goto L71;
        r10 = true;
        goto L72
    L64:
        if (r1.optBoolean("style_optimize") != true) goto L66;
        r14 = true;
        goto L67
    L25:
        if (r7.length() <= 0) goto L27;
        boolean r21 = true;
    L28:
        if (r21 == false) goto L58;
        if (StringsKt.contains$default(r7, "_", false, 2, null) == false) goto L58;
        List r22 = StringsKt.split$default(r7, new String[]{"_"}, false, 0, 6, null);
        if (r22.size() <= 1) goto L58;
        final String r23 = (String) CollectionsKt.getOrNull(r22, 1);
        if (r23 != null) goto L36;
        r23 = "";
    L36:
        if (r4 == null) goto L58;
        if (r23.length() != 0) goto L41;
        boolean r24 = true;
    L42:
        if (r24 == true) goto L58;
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L56
        JSONObject r26 = r4.optJSONObject("promotion_info");     // Catch: Throwable -> L56
        if (r26 == null) goto L54;
        h2 r27 = (h2) u0.c().fromJson(r26.toString(), h2.class);     // Catch: Throwable -> L56
        if (r27 != null) goto L49;
    L53:
        r9 = true;
        goto L59
    L49:
        if (com.bytedance.android.shopping.deepfeed.utlis.h.c(r27) == true) goto L51;
        int r28 = dd3.c.a;     // Catch: Throwable -> L56
        final boolean r29 = false;
    L52:
        DeepFeedProductCouponApi r30 = com.bytedance.android.shopping.deepfeed.utlis.e.a;     // Catch: Throwable -> L56
        com.bytedance.android.shopping.deepfeed.utlis.e.b(r27, r23, r29, new DeepFeedProductRepository$paramsAndHandlerCoupon$$inlined$runCatching$lambda$1(r29, this, r4, r23));     // Catch: Throwable -> L56
        goto L53
    L51:
        r29 = true;
        goto L52
    L54:
        Result.constructor-impl(null);     // Catch: Throwable -> L56
    L56:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L58
    L41:
        r24 = false;
        goto L42
    L27:
        r21 = false;
        goto L28
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public static void d(l r0, n r1) {
        o r2 = r0.b();
        if (r2 == null) goto L6;
        r2.loadProductFeed(r1);
        return;
    }

    public final boolean a(int r13, InFeedProductV2 r14) {
        r14.getDynamicData().c = r13;
        if (r13 >= ((ArrayList) this.c).size()) goto L62;
        InFeedProductV2 r0 = (InFeedProductV2) ListProtector.get(this.c, r13);
        List<InFeedProductV2> r2 = this.c;
        n0 r3 = r0.slcCard();
        InFeedProductPackData r4 = null;
        if (r3 == null) goto L7;
        com.bytedance.android.shopping.deepfeed.slice.c r5 = r3.d;
    L8:
        n0 r6 = r14.slcCard();
        if (r3 == null) goto L60;
        if (r5 == null) goto L60;
        if (r6 == null) goto L60;
        Map<String, Map<String, Object>> r7 = r6.f();
        if (r7 == null) goto L23;
        Map<String, Object> r8 = r7.get("product_card");
        if (r8 == null) goto L23;
        Map r9 = MapsKt.toMutableMap(r8);
        if (r9 == null) goto L23;
        r9.remove("state");
        Map<String, Object> r10 = r6.c();
        if (r10 == null) goto L24;
        r9.putAll(r10);
    L24:
        if (r9 == null) goto L35;
        com.bytedance.android.shopping.deepfeed.slice.c r11 = r3.d;
        if (r11 == null) goto L35;
        Intrinsics.checkNotNullParameter(r9, "data");
        ((LinkedHashMap) r11.a).clear();
        Iterator r12 = r9.entrySet().iterator();
    L29:
        if (r12.hasNext() == false) goto L34;
        Map.Entry r15 = (Map.Entry) r12.next();
        String r16 = (String) r15.getKey();
        Object r17 = r15.getValue();
        if ((!Intrinsics.areEqual(r16, "state")) == false) goto L29;
        if (r17 == null) goto L29;
        r11.a.put(r16, r17);
        goto L29
    L34:
        r11.b();
    L35:
        Map<String, Map<String, Object>> r18 = r3.f();
        if (r18 == null) goto L41;
        r18.clear();
        Map<String, Map<String, Object>> r19 = r6.f();
        if (r19 != null) goto L40;
        r19 = MapsKt.emptyMap();
    L40:
        r18.putAll(r19);
    L41:
        Map<String, Object> r20 = r3.c();
        if (r20 == null) goto L47;
        r20.clear();
        Map<String, Object> r21 = r6.c();
        if (r21 != null) goto L46;
        r21 = MapsKt.emptyMap();
    L46:
        r20.putAll(r21);
    L47:
        Map<String, String> r22 = r3.d();
        if (r22 == null) goto L53;
        r22.clear();
        Map<String, String> r23 = r6.d();
        if (r23 != null) goto L52;
        r23 = MapsKt.emptyMap();
    L52:
        r22.putAll(r23);
    L53:
        r3.b(r6.b, r6.a);
        InFeedProductPackData r24 = r14.getPackData();
        if (r24 == null) goto L56;
        InFeedProductPackDataElements r25 = r24.getElements();
    L57:
        if (r25 == null) goto L59;
        r4 = new InFeedProductPackData(new InFeedProductPackDataElements(r25.getProducts(), r3, r25.getAd(), r25.getAuthor()));
    L59:
        r0.setPackData(r4);
        r0.setCustom(r14.getCustom());
        r0.setRespExtra(r14.getRespExtra());
        r0.setCacheData(r14.isCacheData());
        r0.setSkeletonData(r14.isSkeletonData());
        r0.getDynamicData().c = r14.getDynamicData().c;
        r0.getDynamicData().d = r14.getDynamicData().d;
        r0.getDynamicData().f = r14.getDynamicData().f;
        r0.getDynamicData().g = r14.getDynamicData().g;
        r0.getDynamicData().n = r14.getDynamicData().n;
        r0.getDynamicData().o = r14.getDynamicData().o;
        r14 = r0;
        goto L60
    L56:
        r25 = null;
    L23:
        r9 = null;
    L60:
        ListProtector.set(r2, r13, r14);
        return true;
    L7:
        r5 = null;
        goto L8
    L62:
        if (r13 != ((ArrayList) this.c).size()) goto L64;
        ((ArrayList) this.c).add(r14);
        return true;
    L64:
        return false;
    }

    public final void c(InFeedProductV2 r6, Function1<? super uc3.c, Unit> r7) {
        Intrinsics.checkNotNullParameter(r7, "callback");
        DeepFeedCouponApi r0 = this.b;
        if (r0 != null) goto L15;
        DeepFeedCouponApi.a.getClass();
        r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        Object r2 = Result.constructor-impl((DeepFeedCouponApi) com.bytedance.android.ec.sdk.helper.n.a.create("https://aweme.snssdk.com", DeepFeedCouponApi.class, null, uc3.a.a()));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r2) == false) goto L12;
        r2 = null;
    L12:
        DeepFeedCouponApi r3 = (DeepFeedCouponApi) r2;
        if (r3 == null) goto L15;
        this.b = r3;
        r0 = r3;
    L7:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
    L15:
        if (r0 == null) goto L33;
        if (r6 == null) goto L34;
        h2 r8 = com.bytedance.android.shopping.deepfeed.utlis.a.j(r6);
        if (r8 == null) goto L35;
        i2 r9 = r8.b();
        if (r9 == null) goto L36;
        String r5 = r9.a();
        String r10 = "";
        if (r5 != null) goto L25;
        r5 = "";
    L25:
        String r11 = r9.b();
        if (r11 == null) goto L29;
        r10 = r11;
    L29:
        bg4.b.b(r0.checkCouponStatus(r5, r10, "qcpx")).subscribe(new b(r7));
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    }

    public final void h(String r13, Function1<? super i, Unit> r14) {
        Intrinsics.checkNotNullParameter(r13, "sessionId");
        Intrinsics.checkNotNullParameter(r14, "callback");
        o r2 = b();
        if ((r2 instanceof DeepFeedBFFRequest) == true) goto L5;
        r2 = null;
    L5:
        DeepFeedBFFRequest r3 = (DeepFeedBFFRequest) r2;
        if (r3 == null) goto L15;
        Intrinsics.checkNotNullParameter(r13, "sessionId");
        Intrinsics.checkNotNullParameter(r14, "callback");
        final Ref.ObjectRef r0 = new Ref.ObjectRef();
        r0.element = null;
        final Ref.ObjectRef r1 = new Ref.ObjectRef();
        r1.element = null;
        Ref.BooleanRef r4 = new Ref.BooleanRef();
        r4.element = false;
        final DeepFeedBFFRequest$requestCouponWaistReturnData$1 r11 = new DeepFeedBFFRequest$requestCouponWaistReturnData$1(r4, r14);
        final DeepFeedBFFRequest$requestCouponWaistReturnData$2 r15 = new DeepFeedBFFRequest$requestCouponWaistReturnData$2(r3, r0, r1, r11, r13);
        Function1<y0, Unit> r16 = new DeepFeedBFFRequest$requestCouponWaistReturnData$3(r11, r0, r15);
        DeepFeedPackBFFApi r5 = r3.O();
        if (r5 != null) goto L10;
        r16.invoke(null);
    L11:
        Function1<InFeedProductResponse, Unit> r17 = new DeepFeedBFFRequest$requestCouponWaistReturnData$4(r11, r1, r15);
        DeepFeedProductFeedBFFApi r18 = r3.N();
        if (r18 != null) goto L14;
        r17.invoke(null);
        return;
    L14:
        Map<String, String> r6 = MapsKt.toMutableMap(r3.n(null));
        r6.put("count", "4");
        r6.put("post_back", "");
        fa3.c.a(bg4.b.c(r18.loadInflowFeed(r6)).subscribe(new d(r17), new e(r17)), r3);
        return;
    L10:
        fa3.c.a(bg4.b.c(r5.loadProductPack(r3.o())).subscribe(new f(r16), new g(r16)), r3);
        goto L11
    L15:
        Unit r19 = (Unit) r14.invoke(null);
    }
}
