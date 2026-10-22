package com.bytedance.android.livesdk.livecommerce.promotionlist.repository.datasource;

import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.android.ec.model.g;
import com.bytedance.android.ec.model.live.ECPromotionListTopData;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.actionrecord.node.Action;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import tj2.e;
import vi2.h;
import vi2.o0;
import vi2.p0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements e {

    public static final class a<T> implements Consumer {
        public final /* synthetic */ b a;
        public final /* synthetic */ int b;
        public final /* synthetic */ com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;
        public final /* synthetic */ com.bytedance.android.ec.core.async.b g;
        public final /* synthetic */ Function3 h;
        public final /* synthetic */ int i;

        public a(b r1, int r2, com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r3, int r4, int r5, int r6, com.bytedance.android.ec.core.async.b r7, Function3 r8, int r9) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r9;
        }

        public final void accept(Object r13) {
            vj2.b r14 = (vj2.b) r13;
            if (((g) r14).statusCode == 0) goto L5;
            this.h.invoke(Boolean.FALSE, Integer.valueOf((this.i + this.e) - this.d), null);
            return;
        L5:
            if (r14.v() == true) goto L7;
        L11:
            this.h.invoke(Boolean.TRUE, Integer.valueOf((this.i + this.e) - this.d), r14);
            int r15 = zg2.a.a;
            com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r16 = this.c;
            zg2.a.a(r16.h, r16.j, Action.SHOP_LIST_DATA_FROM, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("data_from", String.valueOf(1))}));
            return;
        L7:
            if (r14.i() <= 0) goto L11;
            if (this.b > 20) goto L11;
            this.a.f(this.c, this.d, r14.i(), this.e, this.f, this.b + 1, this.g, this.h);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.promotionlist.repository.datasource.b$b, reason: collision with other inner class name */
    public static final class C0094b<T> implements Consumer {
        public final /* synthetic */ Function3 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;

        public C0094b(Function3 r1, int r2, int r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            this.a.invoke(Boolean.FALSE, Integer.valueOf((this.b + this.c) - this.d), null);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ uj2.a a;
        public final /* synthetic */ com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c b;

        public c(uj2.a r1, com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            vj2.b r6 = (vj2.b) r5;
            uj2.a r0 = this.a;
            if (r0 == null) goto L16;
            String r1 = this.b.h.toString();
            r0.a.c("room_id", r1);
            Integer r2 = Integer.valueOf(((g) r6).statusCode);
            r0.a.c("status_code", String.valueOf(r2));
            LruCache<String, uj2.a> r3 = uj2.b.a;
            String r7 = r6.getLogId();
            Intrinsics.checkNotNullParameter(r0, "event");
            if (r7 != null) goto L7;
            return;
        L7:
            if (r7.length() <= 0) goto L9;
            boolean r4 = true;
        L10:
            if (r4 == true) goto L13;
            r7 = null;
        L13:
            if (r7 == null) goto L18;
            uj2.b.a.put(r7, r0);
            return;
        L18:
            return;
        L9:
            r4 = false;
            goto L10
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ uj2.a a;
        public final /* synthetic */ com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c b;

        public d(uj2.a r1, com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            if ((r5 instanceof CronetIOException) == true) goto L5;
            r5 = null;
        L5:
            CronetIOException r6 = (CronetIOException) r5;
            if (r6 == null) goto L10;
            uj2.a r0 = this.a;
            if (r0 == null) goto L10;
            r0.b(Integer.valueOf(r6.getStatusCode()));
        L10:
            uj2.a r7 = this.a;
            if (r7 == null) goto L13;
            r7.a.c("status_code", String.valueOf(-1));
        L13:
            uj2.a r8 = this.a;
            if (r8 == null) goto L16;
            Intrinsics.checkNotNullParameter("network_error", LocationMonitorConst.TYPE);
            r8.a.c("error_type", "network_error");
        L16:
            uj2.a r9 = this.a;
            if (r9 == null) goto L19;
            r9.a.c("room_id", this.b.h.toString());
        L19:
            uj2.a r10 = this.a;
            if (r10 == null) goto L23;
            r10.a.i(null);
            return;
        }
    }

    public b() {
    }

    @Override // tj2.e
    public final Observable<ECPromotionListTopData> b(final String r9, final String r10, final String r11, final String r12) {
        String r0 = h.a;
        final String r1 = si2.g.U;
        return h.e(r9, r10, r1, new vi2.e(r11, r12, r9, r10, r1));
    }

    @Override // tj2.e
    public final Observable<vj2.a> c(String r17, com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r18, List<vj2.d> r19, Map<String, String> r20) {
        Intrinsics.checkNotNullParameter(r18, "params");
        return h.k(r18.f, r18.g, r18.h, r18.j, r18.i, r18.b(), r19, null, -1, com.bytedance.android.livesdk.livecommerce.promotionlist.base.c.a(r18.h, r18.j), r17, true, r18.z, r20);
    }

    public final Observable<vj2.c> g(com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r17, String r18, Map<String, String> r19, int r20) {
        Intrinsics.checkNotNullParameter(r17, "params");
        String r4 = r17.f;
        String r5 = r17.g;
        String r2 = r17.h;
        String r15 = r17.j;
        String r10 = r17.i;
        String r8 = r17.z;
        String r11 = r17.b();
        int r13 = com.bytedance.android.livesdk.livecommerce.promotionlist.base.c.a(r17.h, r17.j);
        String r0 = h.a;
        if (r18 != null) goto L5;
    L8:
        String r1 = si2.g.h;
    L10:
        return h.e(r2, r15, r1, new p0(r4, r5, r2, r15, r8, r19, r10, r11, r20, r13, r1));
    L5:
        if (TextUtils.isEmpty(r18) == true) goto L8;
        r1 = si2.g.a + r18;
        goto L10
    }

    @Override // tj2.e
    public final Observable<vj2.b> a(com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r36, int r37, int r38, int r39, boolean r40, boolean r41) {
        Intrinsics.checkNotNullParameter(r36, "params");
        boolean r11 = r36.e;
        r36.e = false;
        if (r39 == 1) goto L5;
    L9:
        int r15 = r39;
    L10:
        PromotionListController.a r3 = PromotionListController.T;
        String r4 = r36.h;
        String r5 = r36.j;
        r3.getClass();
        PromotionListController r6 = PromotionListController.a.c(r4, r5);
        PromotionCategory.a r7 = PromotionCategory.Companion;
        String r8 = r36.b;
        r7.getClass();
        boolean r9 = PromotionCategory.a.b(r8);
        uj2.a r10 = null;
        if (r9 == false) goto L16;
        if (r37 != 0) goto L16;
        if (r6.x() == false) goto L16;
        String r12 = r6.f;
        String r25 = r6.g;
        String r24 = r12;
    L18:
        if (r41 == false) goto L20;
    L24:
        int r20 = 1;
    L25:
        int r13 = xh2.c.a;
        if (xh2.c.a(r36.a) == false) goto L29;
        if (r41 == false) goto L29;
        int r21 = 1;
    L30:
        boolean r2 = r36.n;
        int r14 = r36.o;
        if (r40 == false) goto L33;
        int r17 = -1;
        boolean r18 = false;
    L34:
        ECLiveABUtils r32 = ECLiveABUtils.INSTANCE;
        if (r32.getEC_LIVE_ENABLE_API_ERROR_REPORT() == false) goto L37;
        r10 = new uj2.a();
    L37:
        uj2.a r16 = r10;
        String r19 = r36.f;
        String r22 = r36.g;
        String r110 = r36.h;
        String r111 = r36.j;
        String r23 = r36.i;
        boolean r26 = r36.k;
        String r27 = r36.b;
        String r28 = r36.b();
        int r29 = r36.a;
        boolean r112 = r36.r;
        String r30 = r36.s;
        boolean r1 = r36.t;
        int r210 = com.bytedance.android.livesdk.livecommerce.promotionlist.base.c.a(r36.h, r36.j);
        String r211 = EComABUtils.getLiveListRecommendedABTag();
        boolean r31 = r36.x;
        String r33 = r36.y;
        int r310 = r15;
        String r113 = r36.z;
        String r212 = h.a;
        if (r40 == true) goto L40;
        String r213 = si2.g.f;
    L41:
        String r42 = r213;
        Observable<vj2.b> r0 = h.e(r110, r111, r42, new o0(r110, r19, r22, r23, r26, r27, r28, r29, r112, r11, r37, r38, r1, r310, r211, r17, r18, r210, r20, r21, r111, r30, r24, r25, r40, r31, r33, r113, r16, r42));
        if (r32.getEC_LIVE_ENABLE_API_ERROR_REPORT() == true) goto L44;
        return r0;
    L44:
        return r0.doOnNext(new c(r16, r36)).doOnError(new d(r16, r36));
    L40:
        r213 = si2.g.g;
        goto L41
    L33:
        r18 = r2;
        r17 = r14;
    L29:
        r21 = -1;
        goto L30
    L20:
        if (PromotionCategory.a.b(r36.b) == false) goto L23;
        if (r37 == 0) goto L24;
    L23:
        r20 = -1;
    L16:
        r24 = null;
        r25 = null;
        goto L18
    L5:
        if (r36.a != 9) goto L9;
        if (r11 == false) goto L8;
        r15 = 5;
        goto L10
    L8:
        r15 = 4;
        goto L10
    }

    @Override // tj2.e
    @Deprecated(message = "尽量不要直接调用此方法, 可以直接使用包含了向下重试能力的标准能力", replaceWith = @ReplaceWith(expression = "requestFirstPageDataWithProductBlockingCheck", imports = {}))
    public final void e(com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r11, int r12, int r13, int r14, com.bytedance.android.ec.core.async.b r15, Function3<? super Boolean, ? super Integer, ? super vj2.b, Unit> r16) {
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r15, "disposableScope");
        Intrinsics.checkNotNullParameter(r16, "callback");
        f(r11, r12, r12, r13, r14, 1, r15, r16);
    }

    @Override // tj2.e
    public final void d(com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r14, int r15, int r16, boolean r17, com.bytedance.android.ec.core.async.b r18, Function2 r19, Function0 r20) {
        Intrinsics.checkNotNullParameter(r14, "params");
        Intrinsics.checkNotNullParameter(r18, "disposableScope");
        Intrinsics.checkNotNullParameter(r19, "onSucceed");
        Intrinsics.checkNotNullParameter(r20, "onFailed");
        if (r17 == true) goto L8;
        PromotionCategory.a r0 = PromotionCategory.Companion;
        String r1 = r14.b;
        r0.getClass();
        if (PromotionCategory.a.b(r1) == true) goto L8;
        boolean r6 = false;
    L9:
        com.bytedance.android.ec.core.async.a.a(a(r14, 0, r15, r16, false, r6).observeOn(Schedulers.io()).subscribe(new com.bytedance.android.livesdk.livecommerce.promotionlist.repository.datasource.c(this, r14, r15, r16, r18, r19, r20), new com.bytedance.android.livesdk.livecommerce.promotionlist.repository.datasource.d(r20)), r18);
        return;
    L8:
        r6 = true;
        goto L9
    }

    public final void f(com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r14, int r15, int r16, int r17, int r18, int r19, com.bytedance.android.ec.core.async.b r20, Function3<? super Boolean, ? super Integer, ? super vj2.b, Unit> r21) {
        PromotionCategory.a r0 = PromotionCategory.Companion;
        String r1 = r14.b;
        r0.getClass();
        if (PromotionCategory.a.b(r1) == false) goto L6;
        if (r16 != 0) goto L6;
        boolean r5 = true;
    L7:
        com.bytedance.android.ec.core.async.a.a(e.a.a(this, r14, r16, r17, 1, r5).observeOn(Schedulers.io()).subscribe(new a(this, r19, r14, r15, r17, r18, r20, r21, r16), new C0094b(r21, r16, r17, r15)), r20);
        return;
    L6:
        r5 = false;
        goto L7
    }
}
