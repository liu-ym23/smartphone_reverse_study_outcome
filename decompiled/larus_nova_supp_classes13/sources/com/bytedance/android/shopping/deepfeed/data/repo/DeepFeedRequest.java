package com.bytedance.android.shopping.deepfeed.data.repo;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.shopping.deepfeed.data.DeepFeedQueryParam;
import com.bytedance.android.shopping.deepfeed.data.api.DeepFeedProductFeedApi;
import com.bytedance.android.shopping.deepfeed.data.api.DeepFeedProductPackApi;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackData;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackDataElements;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductResponse;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.bytedance.android.shopping.infeed.data.idl.InFeedUrlModel;
import he3.c2;
import he3.e2;
import he3.f1;
import he3.h1;
import he3.k1;
import he3.k2;
import he3.m1;
import he3.o0;
import he3.p0;
import he3.p1;
import he3.q;
import he3.r0;
import he3.r1;
import he3.s;
import he3.u1;
import he3.v;
import he3.y0;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class DeepFeedRequest extends AbsDeepFeedRequest {
    public DeepFeedProductPackApi E;
    public DeepFeedProductFeedApi F;
    public Function2<? super Boolean, ? super InFeedProductV2, Unit> G;
    public n H;
    public final List<InFeedProductV2> I;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ DeepFeedRequest b;
        public final /* synthetic */ n c;

        public a(String r1, DeepFeedRequest r2, n r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            InFeedProductResponse r5 = (InFeedProductResponse) r4;
            DeepFeedRequest r0 = this.b;
            AbsDeepFeedRequest.PendingRequestType r1 = AbsDeepFeedRequest.PendingRequestType.FEED;
            if (r0.G(r1, this.a) == false) goto L5;
            DeepFeedRequest r2 = this.b;
            n r3 = r2.H;
            if (r3 != null) goto L10;
            r3 = this.c;
        L10:
            r2.H = null;
            r2.x(r5, r3);
            return;
        L5:
            if (this.b.q(r1, this.a) == false) goto L12;
            this.b.B();
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ DeepFeedRequest b;

        public b(String r1, DeepFeedRequest r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            DeepFeedRequest r5 = this.b;
            AbsDeepFeedRequest.PendingRequestType r0 = AbsDeepFeedRequest.PendingRequestType.FEED;
            if (r5.q(r0, this.a) == false) goto L9;
            if (this.b.s(r0, this.a) == true) goto L9;
            DeepFeedRequest r6 = this.b;
            r6.H = null;
            r6.w();
            return;
        L9:
            if (this.b.q(r0, this.a) == false) goto L13;
            this.b.B();
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ DeepFeedRequest b;
        public final /* synthetic */ Function2 c;

        public c(String r1, DeepFeedRequest r2, Function2 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r10) {
            y0 r11 = (y0) r10;
            DeepFeedRequest r0 = this.b;
            AbsDeepFeedRequest.PendingRequestType r1 = AbsDeepFeedRequest.PendingRequestType.PACK;
            if (r0.G(r1, this.a) == false) goto L5;
            DeepFeedRequest r2 = this.b;
            Function2<? super Boolean, ? super InFeedProductV2, Unit> r3 = r2.G;
            if (r3 != null) goto L10;
            r3 = this.c;
        L10:
            List<InFeedUrlModel> r4 = null;
            r2.G = null;
            r2.C();
            List<InFeedProductV2> r5 = r11.b();
            if (r5 != null) goto L13;
        L16:
            boolean r6 = true;
        L17:
            if (r6 == false) goto L19;
        L114:
            r2.z(r11, r3);
            return;
        L19:
            if (r2.I.size() == 1) goto L23;
            if (AbsDeepFeedRequest.p(r2.I) == false) goto L114;
        L23:
            if (r11.b().size() != 1) goto L114;
            InFeedProductV2 r7 = (InFeedProductV2) CollectionsKt.firstOrNull(r11.b());
            if (r7 == null) goto L29;
            v r8 = r7.getDynamicData();
            if (r8 == null) goto L29;
            r8.e = true;
        L29:
            int r9 = dd3.c.a;
            MutableLiveData<he3.l> r12 = r2.c;
            if (r12 == null) goto L32;
            he3.l r13 = (he3.l) r12.getValue();
        L33:
            if (r13 == null) goto L42;
            if (r7 == null) goto L42;
            v r14 = r7.getDynamicData();
            if (r14 == null) goto L42;
            MutableLiveData<he3.l> r15 = r2.c;
            if (r15 == null) goto L40;
            he3.l r16 = (he3.l) r15.getValue();
        L41:
            r14.d = r16;
            goto L42
        L40:
            r16 = null;
        L42:
            if (r7 == null) goto L114;
            InFeedProductPackData r17 = r7.getPackData();
            if (r17 == null) goto L114;
            InFeedProductPackDataElements r18 = r17.getElements();
            if (r18 == null) goto L114;
            List<p0> r19 = r18.getProducts();
            if (r19 == null) goto L114;
            p0 r20 = (p0) CollectionsKt.firstOrNull(r19);
            if (r20 == null) goto L114;
            InFeedProductV2 r21 = (InFeedProductV2) CollectionsKt.firstOrNull(r2.I);
            if (r21 == null) goto L114;
            InFeedProductPackData r22 = r21.getPackData();
            if (r22 == null) goto L114;
            InFeedProductPackDataElements r23 = r22.getElements();
            if (r23 == null) goto L114;
            List<p0> r24 = r23.getProducts();
            if (r24 == null) goto L114;
            p0 r25 = (p0) CollectionsKt.firstOrNull(r24);
            if (r25 == null) goto L114;
            if (r21.getDynamicData().f == true) goto L64;
            r20.u(null);
            r7.getDynamicData().g = true;
        L69:
            m1 r26 = r25.i();
            if (r26 == null) goto L91;
            he3.m r27 = r26.a();
            if (r27 == null) goto L91;
            List<q> r28 = r27.a();
            if (r28 == null) goto L91;
            if (r20.i() != null) goto L78;
            r20.t(new m1(new he3.m(r28, 5), 2));
            goto L91
        L78:
            m1 r29 = r20.i();
            if (r29 == null) goto L81;
            he3.m r30 = r29.a();
        L82:
            if (r30 != null) goto L86;
            m1 r31 = r20.i();
            if (r31 == null) goto L91;
            r31.b(new he3.m(r28, 5));
            goto L91
        L86:
            m1 r32 = r20.i();
            if (r32 == null) goto L91;
            he3.m r33 = r32.a();
            if (r33 == null) goto L91;
            r33.d(r28);
            goto L91
        L81:
            r30 = null;
        L91:
            k1 r34 = r25.g();
            if (r34 == null) goto L94;
            List<e2> r35 = r34.c();
        L95:
            if (r35 == null) goto L103;
            k1 r36 = r20.g();
            if (r36 == null) goto L103;
            k1 r37 = r25.g();
            if (r37 == null) goto L101;
            List<e2> r38 = r37.c();
        L102:
            r36.e(r38);
            goto L103
        L101:
            r38 = null;
        L103:
            k1 r39 = r25.g();
            if (r39 == null) goto L106;
            List<InFeedUrlModel> r40 = r39.b();
        L107:
            if (r40 == null) goto L114;
            k1 r41 = r20.g();
            if (r41 == null) goto L114;
            k1 r42 = r25.g();
            if (r42 == null) goto L113;
            r4 = r42.b();
        L113:
            r41.d(r4);
            goto L114
        L106:
            r40 = null;
            goto L107
        L94:
            r35 = null;
            goto L95
        L64:
            if (tc3.f.b() == true) goto L69;
            if (Intrinsics.areEqual(tc3.a.a().h(), Boolean.TRUE) == true) goto L69;
            r20.u(r25.m());
            goto L69
        L32:
            r13 = null;
            goto L33
        L13:
            if (r5.isEmpty() == true) goto L16;
            r6 = false;
            goto L17
        L5:
            if (this.b.q(r1, this.a) == false) goto L116;
            this.b.C();
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ DeepFeedRequest b;
        public final /* synthetic */ Function2 c;

        public d(String r1, DeepFeedRequest r2, Function2 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            DeepFeedRequest r0 = this.b;
            AbsDeepFeedRequest.PendingRequestType r1 = AbsDeepFeedRequest.PendingRequestType.PACK;
            if (r0.q(r1, this.a) == false) goto L9;
            if (this.b.s(r1, this.a) == true) goto L9;
            DeepFeedRequest r2 = this.b;
            r2.G = null;
            r2.y(r5, this.c);
            return;
        L9:
            if (this.b.q(r1, this.a) == false) goto L13;
            this.b.C();
            return;
        }
    }

    @Override // com.bytedance.android.shopping.deepfeed.data.repo.o
    public final void a(Function2<? super Boolean, ? super InFeedProductV2, Unit> r6) {
        Intrinsics.checkNotNullParameter(r6, "callback");
        DeepFeedProductPackApi r0 = this.E;
        if (r0 != null) goto L15;
        DeepFeedProductPackApi.a.getClass();
        r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        Object r2 = Result.constructor-impl((DeepFeedProductPackApi) com.bytedance.android.ec.sdk.helper.n.a.create("https://ecom.snssdk.com", DeepFeedProductPackApi.class, null, uc3.a.a()));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r2) == false) goto L12;
        r2 = null;
    L12:
        DeepFeedProductPackApi r3 = (DeepFeedProductPackApi) r2;
        if (r3 == null) goto L15;
        this.E = r3;
        r0 = r3;
    L7:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
    L15:
        if (r0 != null) goto L17;
        return;
    L17:
        if (this.l == false) goto L19;
        return;
    L19:
        this.l = true;
        this.b.postDelayed(this.n, 15000);
        Map<String, String> r5 = o();
        String r7 = F(AbsDeepFeedRequest.PendingRequestType.PACK, "/aweme/v2/commerce/deep/feed/pack", r5);
        this.G = r6;
        fa3.c.a(bg4.b.c(r0.loadProductPack(r5)).subscribe(new c(r7, this, r6), new d(r7, this, r6)), this);
    }

    @Override // com.bytedance.android.shopping.deepfeed.data.repo.o
    public final void loadProductFeed(final n r7) {
        DeepFeedProductFeedApi r0 = this.F;
        List<String> r1 = null;
        if (r0 != null) goto L16;
        DeepFeedProductFeedApi.a.getClass();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L7
        Object r3 = Result.constructor-impl((DeepFeedProductFeedApi) com.bytedance.android.ec.sdk.helper.n.a.create("https://ecom.snssdk.com", DeepFeedProductFeedApi.class, null, uc3.a.a()));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r3) == false) goto L12;
        r3 = null;
    L12:
        r0 = (DeepFeedProductFeedApi) r3;
        if (r0 == null) goto L15;
        this.F = r0;
        goto L16
    L15:
        r0 = null;
    L7:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
    L16:
        if (r0 == null) goto L33;
        Function0<Unit> r5 = new DeepFeedRequest$loadProductFeed$$inlined$let$lambda$1(this, r7);
        Intrinsics.checkNotNullParameter(r5, "requestBlock");
        boolean r6 = false;
        if (this.m == false) goto L27;
        if (r7 == null) goto L22;
        r1 = r7.b;
    L22:
        if (r1 == null) goto L24;
        r6 = true;
    L24:
        if (r6 == false) goto L26;
        this.t = new com.bytedance.android.shopping.deepfeed.data.repo.a(r5);
    L26:
        r6 = true;
    L27:
        if (r6 == false) goto L29;
        return;
    L29:
        this.m = true;
        this.b.postDelayed(this.o, 15000);
        this.H = r7;
        u(r7);
        Map<String, String> r8 = n(r7);
        String r9 = F(AbsDeepFeedRequest.PendingRequestType.FEED, "/aweme/v2/commerce/deep/feed", r8);
        fa3.c.a(bg4.b.c(r0.loadInflowFeed(r8)).subscribe(new a(r9, this, r7), new b(r9, this)), this);
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.data.repo.o
    public final void c(JSONObject r18, JSONObject r19, boolean r20) {
        if (r18 != null) goto L5;
        return;
    L5:
        if (r19 != null) goto L7;
        return;
    L7:
        JSONObject r0 = r18.optJSONObject("shop_info");
        if (r0 == null) goto L20;
        JSONObject r1 = r0.optJSONObject("base_info");
        if (r1 == null) goto L20;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L16
        k2 r6 = (k2) u0.b(r1.toString(), k2.class);     // Catch: Throwable -> L16
        Object r2 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L19:
        Result.box-impl(r2);
    L21:
        if (r20 == true) goto L33;
        JSONObject r3 = r18.optJSONObject("sales_info");
        if (r3 == null) goto L33;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L29
        u1 r8 = (u1) u0.b(r3.toString(), u1.class);     // Catch: Throwable -> L29
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L27
    L32:
        Result.box-impl(r4);
        u1 r11 = r8;
    L72:
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L67
        c2 r10 = new c2(r19.optString("title"), 6);     // Catch: Throwable -> L67
        p1 r12 = (p1) u0.b(r19.optString("price"), p1.class);     // Catch: Throwable -> L67
        r0 r13 = new r0(r6, 14);     // Catch: Throwable -> L67
        if (r20 == false) goto L37;
        r1 r14 = null;
    L38:
        p0 r15 = new p0(r10, (k1) u0.b(r18.optString("cover_info"), k1.class), r12, r11, r14, r13, new h1(Boolean.TRUE, new f1("url", 14), 4), (m1) u0.b(r18.optString("extend_info"), m1.class), 4189769);     // Catch: Throwable -> L67
        m1 r16 = r15.i();     // Catch: Throwable -> L67
        if (r16 == null) goto L53;
        he3.m r17 = r16.a();     // Catch: Throwable -> L67
        if (r17 == null) goto L53;
        s r21 = r17.c();     // Catch: Throwable -> L67
        if (r21 == null) goto L53;
        List<o0> r22 = r21.a();     // Catch: Throwable -> L67
        if (r22 == null) goto L53;
        if ((!r22.isEmpty()) != true) goto L53;
        m1 r23 = r15.i();     // Catch: Throwable -> L67
        if (r23 == null) goto L53;
        he3.m r24 = r23.a();     // Catch: Throwable -> L67
        if (r24 == null) goto L53;
        r24.d(null);     // Catch: Throwable -> L67
    L53:
        InFeedProductV2 r25 = new InFeedProductV2();     // Catch: Throwable -> L67
        r25.setCacheData(true);     // Catch: Throwable -> L67
        r25.setPackData(new InFeedProductPackData(new InFeedProductPackDataElements(CollectionsKt.listOf(r15), null, null, null, 14, null)));     // Catch: Throwable -> L67
        int r26 = 0;
        if (r20 == false) goto L56;
        r25.getDynamicData().f = false;     // Catch: Throwable -> L67
    L56:
        this.I.add(r25);     // Catch: Throwable -> L67
        this.a = true;     // Catch: Throwable -> L67
        if (this.z == true) goto L59;
    L65:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L67
        return;
    L59:
        if (DeepFeedRepHelpKt.b() == 1) goto L63;
        if (DeepFeedRepHelpKt.b() != 3) goto L65;
    L63:
        if (r26 >= 10) goto L65;
        List<InFeedProductV2> r27 = this.I;     // Catch: Throwable -> L67
        InFeedProductV2 r28 = new InFeedProductV2();     // Catch: Throwable -> L67
        r28.setSkeletonData(true);     // Catch: Throwable -> L67
        Unit r29 = Unit.INSTANCE;     // Catch: Throwable -> L67
        r27.add(r28);     // Catch: Throwable -> L67
        r26 = r26 + 1;     // Catch: Throwable -> L67
        goto L63
    L37:
        r14 = (r1) u0.b(r18.optString("rec_reason_info"), r1.class);     // Catch: Throwable -> L67
    L67:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L27:
        th = th;
    L31:
        Result.Companion r31 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
    L29:
        th = th;
        r8 = null;
    L33:
        r11 = null;
    L14:
        th = th;
    L18:
        Result.Companion r32 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
    L16:
        th = th;
        r6 = null;
    L20:
        r6 = null;
        goto L21
    }

    public DeepFeedRequest(boolean r2, DeepFeedQueryParam r3, tf3.b r4, List<InFeedProductV2> r5) {
        Intrinsics.checkNotNullParameter(r3, "deepFeedParam");
        Intrinsics.checkNotNullParameter(r5, "inFeedProductList");
        super(r2, r3, r4, r5);
        this.I = r5;
    }
}
