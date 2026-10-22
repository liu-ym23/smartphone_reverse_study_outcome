package com.bytedance.android.shopping.deepfeed.data.repo;

import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.imagex.s0;
import com.bytedance.android.shopping.buynow.data.model.TTPayCode;
import com.bytedance.android.shopping.deepfeed.data.DeepFeedQueryParam;
import com.bytedance.android.shopping.deepfeed.data.api.DeepFeedPackBFFApi;
import com.bytedance.android.shopping.deepfeed.data.api.DeepFeedProductFeedBFFApi;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackData;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackDataElements;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductResponse;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.bytedance.android.shopping.infeed.data.idl.InFeedUrlModel;
import com.google.gson.internal.LinkedTreeMap;
import he3.a0;
import he3.e2;
import he3.h2;
import he3.k0;
import he3.l0;
import he3.n0;
import he3.u;
import he3.u0;
import he3.w0;
import he3.y;
import he3.y0;
import he3.z;
import he3.z0;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class DeepFeedBFFRequest extends AbsDeepFeedRequest {
    public static final /* synthetic */ int L = 0;
    public DeepFeedPackBFFApi E;
    public DeepFeedProductFeedBFFApi F;
    public z G;
    public Function2<? super Boolean, ? super InFeedProductV2, Unit> H;
    public n I;
    public Map<String, String> J;
    public final List<InFeedProductV2> K;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ DeepFeedBFFRequest b;
        public final /* synthetic */ n c;

        public b(String r1, DeepFeedBFFRequest r2, n r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            InFeedProductResponse r5 = (InFeedProductResponse) r4;
            DeepFeedBFFRequest r0 = this.b;
            AbsDeepFeedRequest.PendingRequestType r1 = AbsDeepFeedRequest.PendingRequestType.FEED;
            if (r0.G(r1, this.a) == false) goto L5;
            DeepFeedBFFRequest r2 = this.b;
            n r3 = r2.I;
            if (r3 != null) goto L10;
            r3 = this.c;
        L10:
            r2.I = null;
            r2.x(r5, r3);
            return;
        L5:
            if (this.b.q(r1, this.a) == false) goto L12;
            this.b.B();
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ DeepFeedBFFRequest b;

        public c(String r1, DeepFeedBFFRequest r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            DeepFeedBFFRequest r5 = this.b;
            AbsDeepFeedRequest.PendingRequestType r0 = AbsDeepFeedRequest.PendingRequestType.FEED;
            if (r5.q(r0, this.a) == false) goto L9;
            if (this.b.s(r0, this.a) == true) goto L9;
            DeepFeedBFFRequest r6 = this.b;
            r6.I = null;
            r6.w();
            return;
        L9:
            if (this.b.q(r0, this.a) == false) goto L13;
            this.b.B();
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ DeepFeedBFFRequest b;
        public final /* synthetic */ Function2 c;

        public d(String r1, DeepFeedBFFRequest r2, Function2 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            y0 r5 = (y0) r4;
            DeepFeedBFFRequest r0 = this.b;
            AbsDeepFeedRequest.PendingRequestType r1 = AbsDeepFeedRequest.PendingRequestType.PACK;
            if (r0.G(r1, this.a) == false) goto L5;
            DeepFeedBFFRequest r2 = this.b;
            Function2<? super Boolean, ? super InFeedProductV2, Unit> r3 = r2.H;
            if (r3 != null) goto L10;
            r3 = this.c;
        L10:
            r2.H = null;
            r2.R(r5, r3);
            return;
        L5:
            if (this.b.q(r1, this.a) == false) goto L12;
            this.b.C();
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ DeepFeedBFFRequest b;
        public final /* synthetic */ Function2 c;

        public e(String r1, DeepFeedBFFRequest r2, Function2 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            DeepFeedBFFRequest r0 = this.b;
            AbsDeepFeedRequest.PendingRequestType r1 = AbsDeepFeedRequest.PendingRequestType.PACK;
            if (r0.q(r1, this.a) == false) goto L9;
            if (this.b.s(r1, this.a) == true) goto L9;
            DeepFeedBFFRequest r2 = this.b;
            r2.H = null;
            r2.y(r5, this.c);
            return;
        L9:
            if (this.b.q(r1, this.a) == false) goto L13;
            this.b.C();
            return;
        }
    }

    static {
    }

    public final DeepFeedProductFeedBFFApi N() {
        DeepFeedProductFeedBFFApi r0 = this.F;
        if (r0 != null) goto L18;
        DeepFeedProductFeedBFFApi.a.getClass();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        Object r2 = Result.constructor-impl((DeepFeedProductFeedBFFApi) com.bytedance.android.ec.sdk.helper.n.a.create("https://ecom.snssdk.com", DeepFeedProductFeedBFFApi.class, null, uc3.a.a()));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r2) == false) goto L12;
        r2 = null;
    L12:
        DeepFeedProductFeedBFFApi r3 = (DeepFeedProductFeedBFFApi) r2;
        if (r3 == null) goto L19;
        this.F = r3;
        return r3;
    L19:
        return null;
    L7:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    L18:
        return r0;
    }

    public final DeepFeedPackBFFApi O() {
        DeepFeedPackBFFApi r0 = this.E;
        if (r0 != null) goto L18;
        DeepFeedPackBFFApi.a.getClass();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        Object r2 = Result.constructor-impl((DeepFeedPackBFFApi) com.bytedance.android.ec.sdk.helper.n.a.create("https://ecom.snssdk.com", DeepFeedPackBFFApi.class, null, uc3.a.a()));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r2) == false) goto L12;
        r2 = null;
    L12:
        DeepFeedPackBFFApi r3 = (DeepFeedPackBFFApi) r2;
        if (r3 == null) goto L19;
        this.E = r3;
        return r3;
    L19:
        return null;
    L7:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    L18:
        return r0;
    }

    public final void S() {
        Iterator<T> r0 = this.K.iterator();
    L4:
        if (r0.hasNext() == false) goto L40;
        InFeedProductPackData r1 = ((InFeedProductV2) r0.next()).getPackData();
        if (r1 == null) goto L10;
        InFeedProductPackDataElements r2 = r1.getElements();
        if (r2 == null) goto L10;
        n0 r3 = r2.getSliceCard();
    L12:
        if (r3 == null) goto L23;
        y r4 = r3.c;
        if (r4 == null) goto L23;
        a0 r5 = r4.a();
        if (r5 == null) goto L23;
        List<InFeedUrlModel> r6 = r5.a();
        if (r6 == null) goto L23;
        Iterator<T> r7 = r6.iterator();
    L21:
        if (r7.hasNext() == false) goto L23;
        InFeedUrlModel r8 = (InFeedUrlModel) r7.next();
        int r9 = s0.f;
        s0.b(new s0(r8, new r("ec_na_deepfeed", "mall_infeed_product_image")));
    L23:
        if (r3 == null) goto L34;
        y r10 = r3.c;
        if (r10 == null) goto L34;
        a0 r11 = r10.a();
        if (r11 == null) goto L34;
        List<e2> r12 = r11.c();
        if (r12 == null) goto L34;
        Iterator<T> r13 = r12.iterator();
    L32:
        if (r13.hasNext() == false) goto L34;
        e2 r14 = (e2) r13.next();
        int r15 = s0.f;
        s0.b(new s0(r14.b(), new r("ec_na_deepfeed", "mall_infeed_product_image")));
    L34:
        if (r3 == null) goto L4;
        k0 r16 = r3.e();
        if (r16 == null) goto L4;
        l0 r17 = r16.e();
        if (r17 == null) goto L4;
        T(r17.b());
        T(r17.a());
        T(r17.c());
    L10:
        r3 = null;
        goto L12
    }

    @Override // com.bytedance.android.shopping.deepfeed.data.repo.AbsDeepFeedRequest
    public final void A() {
        S();
    }

    @Override // com.bytedance.android.shopping.deepfeed.data.repo.AbsDeepFeedRequest, com.bytedance.android.shopping.deepfeed.data.repo.o
    public final Map<String, String> b() {
        return this.J;
    }

    public static void K(y0 r6) {
        u r7 = r6.a();
        if (r7 == null) goto L13;
        List<InFeedProductV2> r8 = r7.a();
        if (r8 == null) goto L13;
        InFeedProductV2 r9 = (InFeedProductV2) CollectionsKt.firstOrNull(r8);
        if (r9 == null) goto L13;
        InFeedProductPackData r10 = r9.getPackData();
        if (r10 == null) goto L13;
        InFeedProductPackDataElements r11 = r10.getElements();
        if (r11 == null) goto L13;
        n0 r12 = r11.getSliceCard();
    L14:
        if (r12 == null) goto L35;
        Map<String, Map<String, Object>> r13 = r12.f();
        if (r13 == null) goto L41;
        Collection<Map<String, Object>> r14 = r13.values();
        if (r14 == null) goto L42;
        Iterator<T> r15 = r14.iterator();
    L21:
        if (r15.hasNext() == false) goto L43;
        Map r1 = (Map) r15.next();
        if (r1 == null) goto L25;
        Object r3 = r1.get("state");
    L27:
        if (TypeIntrinsics.isMutableMap(r3) == true) goto L29;
        r3 = null;
    L29:
        Map r4 = (Map) r3;
        if (r4 != null) goto L32;
        r4 = new LinkedHashMap();
    L32:
        r4.put("visible", Boolean.TRUE);
        if (r1 == null) goto L21;
        r1.put("state", r4);
        goto L21
    L25:
        r3 = null;
        goto L27
    L43:
        return;
    L42:
        return;
    L41:
        return;
    L35:
        return;
    L13:
        r12 = null;
        goto L14
    }

    public static Map L(JSONObject r16) {
        JSONArray r2 = r16.optJSONArray("items");
        if (r2 == null) goto L5;
        int r3 = r2.length();
    L6:
        if (r3 > 0) goto L8;
        JSONArray r4 = r16.optJSONArray("tabs");
        if (r4 == null) goto L41;
        if (r4.length() == 0) goto L41;
        ArrayList r5 = new ArrayList();
        LinkedHashMap r6 = new LinkedHashMap();
        LinkedHashMap r7 = new LinkedHashMap();
        int r8 = r4.length();
        int r9 = 0;
    L15:
        if (r9 >= r8) goto L33;
        JSONObject r11 = r4.optJSONObject(r9);
        if (r11 == null) goto L32;
        String r13 = r11.optString("tab_type");
        if (r13.length() != 0) goto L22;
        boolean r14 = true;
    L23:
        if (r14 == true) goto L32;
        Map<String, Object> r12 = xc3.b.b(r11);
        Integer r15 = (Integer) r6.get(r13);
        if (r15 != null) goto L28;
        r15 = 0;
    L28:
        int r17 = r15.intValue();
        if (r7.containsKey(r13) == true) goto L31;
        r7.put(r13, Integer.valueOf(r5.size()));
    L31:
        r6.put(r13, Integer.valueOf(r17 + 1));
        r5.add(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("tab", r12), TuplesKt.to("tab_type", r13), TuplesKt.to("index_on_type", Integer.valueOf(r17))}));
        goto L32
    L22:
        r14 = false;
    L32:
        r9 = r9 + 1;
        goto L15
    L33:
        Map r1 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("items", r5)});
        JSONObject r10 = r16.optJSONObject("custom");
        if (r10 == null) goto L36;
        r1.put("custom", xc3.b.b(r10));
    L36:
        JSONArray r0 = r16.optJSONArray("tabs");
        if (r0 == null) goto L39;
        r1.put("tabs", xc3.b.a(r0));
    L39:
        return r1;
    L41:
        return xc3.b.b(r16);
    L8:
        return xc3.b.b(r16);
    L5:
        r3 = 0;
        goto L6
    }

    public static void P(InFeedProductResponse r4) {
        u r5 = r4.getBffData();
        if (r5 == null) goto L35;
        List<InFeedProductV2> r6 = r5.a();
        if (r6 == null) goto L41;
        Iterator<T> r7 = r6.iterator();
    L8:
        if (r7.hasNext() == false) goto L42;
        InFeedProductV2 r0 = (InFeedProductV2) r7.next();
        if (r0.getCustom() != null) goto L8;
        u0 r1 = new u0();
        InFeedProductPackData r2 = r0.getPackData();
        String r3 = null;
        if (r2 == null) goto L22;
        InFeedProductPackDataElements r8 = r2.getElements();
        if (r8 == null) goto L22;
        n0 r9 = r8.getSliceCard();
        if (r9 == null) goto L22;
        k0 r10 = r9.e();
        if (r10 == null) goto L22;
        w0 r11 = r10.c();
        if (r11 == null) goto L22;
        String r12 = r11.b();
    L23:
        r1.c(r12);
        InFeedProductPackData r13 = r0.getPackData();
        if (r13 == null) goto L34;
        InFeedProductPackDataElements r14 = r13.getElements();
        if (r14 == null) goto L34;
        n0 r15 = r14.getSliceCard();
        if (r15 == null) goto L34;
        k0 r16 = r15.e();
        if (r16 == null) goto L34;
        w0 r17 = r16.c();
        if (r17 == null) goto L34;
        r3 = r17.a();
    L34:
        r1.b(r3);
        Unit r18 = Unit.INSTANCE;
        r0.setCustom(r1);
    L22:
        r12 = null;
        goto L23
    L42:
        return;
    L41:
        return;
    }

    public static void T(List r4) {
        if (r4 == null) goto L10;
        Iterator r5 = r4.iterator();
    L5:
        if (r5.hasNext() == false) goto L16;
        String r0 = (String) r5.next();
        if (StringsKt.isBlank(r0) == true) goto L5;
        int r1 = s0.f;
        s0.b(new s0(r0, new r("ec_na_deepfeed", "mall_infeed_product_image")));
        goto L5
    L16:
        return;
    }

    public final void U(y0 r2) {
        u r3 = r2.a();
        Map<String, String> r0 = null;
        if (r3 == null) goto L13;
        List<InFeedProductV2> r4 = r3.a();
        if (r4 == null) goto L13;
        InFeedProductV2 r5 = (InFeedProductV2) CollectionsKt.firstOrNull(r4);
        if (r5 == null) goto L13;
        InFeedProductPackData r6 = r5.getPackData();
        if (r6 == null) goto L13;
        InFeedProductPackDataElements r7 = r6.getElements();
        if (r7 == null) goto L13;
        n0 r8 = r7.getSliceCard();
    L14:
        if (r8 == null) goto L16;
        r0 = r8.d();
    L16:
        this.J = r0;
        return;
    L13:
        r8 = null;
        goto L14
    }

    @Override // com.bytedance.android.shopping.deepfeed.data.repo.o
    public final void a(Function2<? super Boolean, ? super InFeedProductV2, Unit> r6) {
        Intrinsics.checkNotNullParameter(r6, "callback");
        DeepFeedPackBFFApi r0 = O();
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.l == false) goto L7;
        return;
    L7:
        this.l = true;
        this.b.postDelayed(this.n, 15000);
        Map<String, String> r1 = o();
        String r2 = F(AbsDeepFeedRequest.PendingRequestType.PACK, "/aweme/v2/commerce/bff/deep/feed/pack", r1);
        this.H = r6;
        fa3.c.a(bg4.b.c(r0.loadProductPack(r1)).subscribe(new d(r2, this, r6), new e(r2, this, r6)), this);
    }

    @Override // com.bytedance.android.shopping.deepfeed.data.repo.AbsDeepFeedRequest
    public final void h(InFeedProductResponse r2) {
        Intrinsics.checkNotNullParameter(r2, "resp");
        P(r2);
    }

    @Override // com.bytedance.android.shopping.deepfeed.data.repo.o
    public final void loadProductFeed(final n r6) {
        DeepFeedProductFeedBFFApi r0 = N();
        if (r0 == null) goto L19;
        Function0<Unit> r1 = new DeepFeedBFFRequest$loadProductFeed$$inlined$let$lambda$1(this, r6);
        Intrinsics.checkNotNullParameter(r1, "requestBlock");
        boolean r4 = false;
        if (this.m == false) goto L15;
        if (r6 == null) goto L9;
        List<String> r2 = r6.b;
    L10:
        if (r2 == null) goto L12;
        r4 = true;
    L12:
        if (r4 == false) goto L14;
        this.t = new com.bytedance.android.shopping.deepfeed.data.repo.a(r1);
    L14:
        r4 = true;
        goto L15
    L9:
        r2 = null;
    L15:
        if (r4 == false) goto L17;
        return;
    L17:
        this.m = true;
        this.b.postDelayed(this.o, 15000);
        this.I = r6;
        u(r6);
        Map<String, String> r3 = n(r6);
        String r5 = F(AbsDeepFeedRequest.PendingRequestType.FEED, "/aweme/v2/commerce/bff/deep/feed", r3);
        fa3.c.a(bg4.b.c(r0.loadInflowFeed(r3)).subscribe(new b(r5, this, r6), new c(r5, this)), this);
        return;
    }

    public static void M(InFeedProductV2 r10, InFeedProductV2 r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r11 != null) goto L6;
        return;
    L6:
        InFeedProductPackData r0 = r11.getPackData();
        if (r0 == null) goto L80;
        InFeedProductPackDataElements r1 = r0.getElements();
        if (r1 == null) goto L86;
        n0 r2 = r1.getSliceCard();
        if (r2 != null) goto L14;
        return;
    L14:
        InFeedProductPackData r3 = r10.getPackData();
        if (r3 == null) goto L23;
        InFeedProductPackDataElements r4 = r3.getElements();
        if (r4 == null) goto L23;
        n0 r5 = r4.getSliceCard();
        if (r5 == null) goto L23;
        Map<String, Object> r6 = r5.c();
        if (r6 == null) goto L23;
        Object r7 = r6.get("cover_info");
    L25:
        if (TypeIntrinsics.isMutableMap(r7) == true) goto L27;
        r7 = null;
    L27:
        Map r8 = (Map) r7;
        Map<String, Object> r9 = r2.c();
        if (r9 != null) goto L30;
        return;
    L30:
        if (r8 == null) goto L42;
        Object r12 = r8.get("images");
        Object r13 = r8.get("product_videos");
        Object r14 = r9.get("cover_info");
        if (TypeIntrinsics.isMutableMap(r14) == true) goto L34;
        r14 = null;
    L34:
        Map r15 = (Map) r14;
        if (r15 != null) goto L37;
        return;
    L37:
        if (r12 == null) goto L39;
        r15.put("images", r12);
    L39:
        if (r13 == null) goto L42;
        r15.put("product_videos", r13);
        r11.getDynamicData().o = true;
    L42:
        if (r10.getDynamicData().f == true) goto L45;
        r9.put("rec_reason_info", null);
    L45:
        if (tc3.f.b() == false) goto L47;
    L59:
        InFeedProductPackData r16 = r10.getPackData();
        if (r16 == null) goto L81;
        InFeedProductPackDataElements r17 = r16.getElements();
        if (r17 == null) goto L82;
        n0 r18 = r17.getSliceCard();
        if (r18 == null) goto L83;
        k0 r19 = r18.e();
        if (r19 == null) goto L84;
        h2 r110 = r19.f();
        if (r110 == null) goto L87;
        k0 r20 = r2.e();
        if (r20 == null) goto L73;
        h2 r21 = r20.f();
    L74:
        if (r21 != null) goto L85;
        k0 r22 = r2.e();
        if (r22 != null) goto L78;
        r22 = new k0(null, 127);
    L78:
        r11.setPackData(new InFeedProductPackData(new InFeedProductPackDataElements(r1.getProducts(), n0.a(r2, k0.a(r22, r110)), r1.getAd(), r1.getAuthor())));
        return;
    L85:
        return;
    L73:
        r21 = null;
        goto L74
    L87:
        return;
    L84:
        return;
    L83:
        return;
    L82:
        return;
    L81:
        return;
    L47:
        if (Intrinsics.areEqual(tc3.a.a().h(), Boolean.TRUE) == true) goto L59;
        r9.put("rec_reason_info", null);
        InFeedProductPackData r23 = r10.getPackData();
        if (r23 == null) goto L59;
        InFeedProductPackDataElements r24 = r23.getElements();
        if (r24 == null) goto L59;
        n0 r25 = r24.getSliceCard();
        if (r25 == null) goto L59;
        Map<String, Object> r26 = r25.c();
        if (r26 == null) goto L59;
        Object r27 = r26.get("rec_reason_info");
        if (r27 == null) goto L59;
        r9.put("rec_reason_info", r27);
    L23:
        r7 = null;
        goto L25
    L86:
        return;
    }

    public final void Q(Map<String, ? extends Object> r5, List<InFeedProductV2> r6) {
        if (r6 == null) goto L35;
        Iterator<T> r7 = r6.iterator();
    L5:
        if (r7.hasNext() == false) goto L43;
        InFeedProductV2 r0 = (InFeedProductV2) r7.next();
        InFeedProductPackData r1 = r0.getPackData();
        Object r2 = null;
        if (r1 == null) goto L11;
        InFeedProductPackDataElements r3 = r1.getElements();
        if (r3 == null) goto L11;
        n0 r4 = r3.getSliceCard();
    L12:
        if (r4 == null) goto L14;
        r4.b(r5, this.G);
    L14:
        z0 r8 = r0.getRespExtra();
        if (r8 == null) goto L17;
        String r9 = r8.c();
    L18:
        if (r9 != null) goto L20;
    L23:
        boolean r10 = true;
    L24:
        if (r10 == false) goto L5;
        z0 r11 = r0.getRespExtra();
        if (r11 == null) goto L5;
        if (r5 == null) goto L29;
        Object r12 = r5.get("request_id");
    L31:
        if ((r12 instanceof String) == false) goto L34;
        r2 = r12;
    L34:
        r11.e((String) r2);
        goto L5
    L29:
        r12 = null;
        goto L31
    L20:
        if (r9.length() == 0) goto L23;
        r10 = false;
        goto L24
    L17:
        r9 = null;
    L11:
        r4 = null;
        goto L12
    L43:
        return;
    }

    public final void R(y0 r4, Function2<? super Boolean, ? super InFeedProductV2, Unit> r5) {
        u r0 = r4.a();
        Map<String, Object> r1 = null;
        if (r0 == null) goto L5;
        z r2 = r0.c();
    L6:
        this.G = r2;
        C();
        InFeedProductV2 r3 = (InFeedProductV2) CollectionsKt.firstOrNull(this.K);
        List r6 = AbsDeepFeedRequest.j(r4);
        if (r6 == null) goto L9;
        InFeedProductV2 r7 = (InFeedProductV2) CollectionsKt.firstOrNull(r6);
    L10:
        M(r3, r7);
        z(r4, r5);
        K(r4);
        u r8 = r4.a();
        if (r8 == null) goto L13;
        r1 = r8.b();
    L13:
        Q(r1, AbsDeepFeedRequest.j(r4));
        U(r4);
        S();
        return;
    L9:
        r7 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.shopping.deepfeed.data.repo.AbsDeepFeedRequest
    public final void f(InFeedProductResponse r5, com.bytedance.android.shopping.deepfeed.data.a r6) {
        Intrinsics.checkNotNullParameter(r5, "resp");
        Intrinsics.checkNotNullParameter(r6, "cardUpdateState");
        u r7 = r5.getBffData();
        tc3.c r0 = null;
        if (r7 == null) goto L5;
        Map<String, Object> r8 = r7.b();
    L6:
        Q(r8, AbsDeepFeedRequest.i(r5));
        tc3.c r9 = tc3.d.a;
        if (r9.a() == false) goto L9;
        r0 = r9;
    L9:
        if (r0 == null) goto L16;
        Long r10 = r0.b();
        if (r10 == null) goto L17;
        long r1 = r10.longValue();
        if (r1 <= 100) goto L18;
        this.b.postDelayed(new com.bytedance.android.shopping.deepfeed.data.repo.c(this, r5), r1);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L5:
        r8 = null;
        goto L6
    }

    @Override // com.bytedance.android.shopping.deepfeed.data.repo.o
    public final void c(JSONObject r19, JSONObject r20, boolean r21) {
        if (r19 != null) goto L5;
        return;
    L5:
        if (r20 != null) goto L7;
        return;
    L7:
        LinkedHashMap r4 = new LinkedHashMap();
        LinkedHashMap r5 = new LinkedHashMap();
        JSONObject r6 = r19.optJSONObject("shop_info");
        if (r6 == null) goto L16;
        JSONObject r7 = r6.optJSONObject("base_info");
        if (r7 == null) goto L16;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L13
        Object r0 = Result.constructor-impl(r5.put("shop_info", xc3.b.b(r7)));     // Catch: Throwable -> L13
    L15:
        Result.box-impl(r0);
    L13:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
    L16:
        r4.put("top_bar_card", r5);
        LinkedHashMap r10 = new LinkedHashMap();
        JSONObject r11 = r19.optJSONObject("sales_info");
        if (r11 != null) goto L93;
    L23:
        JSONObject r1 = r19.optJSONObject("extend_info");
        if (r1 == null) goto L34;
        JSONObject r2 = r1.optJSONObject("deep_feed_extend_info");
        if (r2 == null) goto L34;
        JSONObject r3 = r2.optJSONObject("multi_tab_info");
        if (r3 == null) goto L34;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L31
        Object r13 = Result.constructor-impl(r10.put("multi_tab_info", L(r3)));     // Catch: Throwable -> L31
    L33:
        Result.box-impl(r13);
    L31:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
    L34:
        String r15 = r20.optString("title");
        if (r15 == null) goto L37;
        r10.put("title_info", MapsKt.mapOf(TuplesKt.to("title", r15)));
    L37:
        JSONObject r16 = r20.optJSONObject("price");
        if (r16 == null) goto L40;
        r10.put("price_info", xc3.b.b(r16));
    L40:
        r4.put("product_card", r10);
        String r17 = r20.optString("product_detail_link");
        int r18 = 0;
        if (r17 == null) goto L43;
        Map r22 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("product_detail", r17)});
    L44:
        JSONObject r23 = r19.optJSONObject("promotion_info");
        if (r23 != null) goto L99;
        h2 r24 = null;
    L55:
        LinkedHashMap r25 = new LinkedHashMap();
        JSONObject r110 = r19.optJSONObject("cover_info");
        if (r110 == null) goto L65;
        Object r111 = r110.remove("cover");
        if ((r111 instanceof JSONObject) == true) goto L60;
        r111 = null;
    L60:
        JSONObject r112 = (JSONObject) r111;
        if (r112 == null) goto L63;
        JSONArray r113 = r112.optJSONArray("url_list");
    L64:
        r110.putOpt("cover", r113);
        r25.put("cover_info", xc3.b.b(r110));
        goto L65
    L63:
        r113 = null;
    L65:
        if (r21 == true) goto L69;
        JSONObject r26 = r19.optJSONObject("rec_reason_info");
        if (r26 == null) goto L69;
        r25.put("rec_reason_info", xc3.b.b(r26));
    L69:
        JSONObject r27 = r20.optJSONObject("extra_slice_data");
        if (r27 == null) goto L72;
        r25.put("extra_slice_data", xc3.b.b(r27));
    L72:
        n0 r114 = new n0(r4, r25, new k0(r24, TTPayCode.WECHAT_NOT_INSTALLED), r22, 16);
        Map<String, LinkedTreeMap<String, Object>> r28 = com.bytedance.android.shopping.deepfeed.slice.g.a;
        Map r29 = com.bytedance.android.shopping.deepfeed.slice.g.a.a();
        LinkedHashMap r30 = new LinkedHashMap();
        LinkedHashMap r31 = (LinkedHashMap) r29;
        Iterator r32 = r31.keySet().iterator();
    L74:
        if (r32.hasNext() == false) goto L80;
        String r33 = (String) r32.next();
        com.bytedance.android.shopping.deepfeed.slice.g r34 = (com.bytedance.android.shopping.deepfeed.slice.g) r31.get(r33);
        if (r34 == null) goto L74;
        String r35 = r34.c();
        if (r35 == null) goto L74;
        r30.put(r33, r35);
        goto L74
    L80:
        r114.b(null, new z(r30, null));
        InFeedProductV2 r36 = new InFeedProductV2();
        r36.setCacheData(true);
        r36.setPackData(new InFeedProductPackData(new InFeedProductPackDataElements(null, r114, null, null, 13, null)));
        if (r21 == false) goto L83;
        r36.getDynamicData().f = false;
    L83:
        this.K.add(r36);
        this.a = true;
        if (this.z == true) goto L86;
        return;
    L86:
        if (DeepFeedRepHelpKt.b() == 1) goto L90;
        if (DeepFeedRepHelpKt.b() == 3) goto L90;
        return;
    L90:
        if (r18 >= 10) goto L111;
        List<InFeedProductV2> r37 = this.K;
        InFeedProductV2 r38 = new InFeedProductV2();
        r38.setSkeletonData(true);
        Unit r39 = Unit.INSTANCE;
        r37.add(r38);
        r18 = r18 + 1;
        goto L90
    L111:
        return;
    L99:
        Result.Companion r40 = Result.Companion;     // Catch: Throwable -> L48
        Object r41 = Result.constructor-impl((h2) com.bytedance.android.ec.core.utils.u0.c().fromJson(r23.toString(), h2.class));     // Catch: Throwable -> L48
    L51:
        if (Result.isFailure-impl(r41) == false) goto L53;
        r41 = null;
    L53:
        r24 = (h2) r41;
    L48:
        th = move-exception;
        Result.Companion r42 = Result.Companion;
        r41 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L51
    L43:
        r22 = null;
        goto L44
    L93:
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L20
        Object r44 = Result.constructor-impl(r10.put("sales_info", xc3.b.b(r11)));     // Catch: Throwable -> L20
    L22:
        Result.box-impl(r44);
    L20:
        th = move-exception;
        Result.Companion r45 = Result.Companion;
        r44 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    }

    public DeepFeedBFFRequest(boolean r2, DeepFeedQueryParam r3, tf3.b r4, List<InFeedProductV2> r5) {
        Intrinsics.checkNotNullParameter(r3, "deepFeedParam");
        Intrinsics.checkNotNullParameter(r5, "inFeedProductList");
        super(r2, r3, r4, r5);
        this.K = r5;
    }
}
