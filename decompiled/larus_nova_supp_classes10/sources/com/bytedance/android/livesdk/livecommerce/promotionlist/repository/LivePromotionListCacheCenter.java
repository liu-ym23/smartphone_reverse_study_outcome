package com.bytedance.android.livesdk.livecommerce.promotionlist.repository;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import com.bytedance.android.ec.core.async.DisposableScope;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.model.live.ECPromotionInterationData;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.actionrecord.node.Action;
import com.bytedance.android.livesdk.livecommerce.model.CategoryInfo;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.android.livesdk.livecommerce.opt.ECLivePerformanceMonitor;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.LivePromotionPageCategoryData;
import com.bytedance.android.livesdk.livecommerce.room.api.ControllerExtensionsKt;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.android.livesdk.livecommerce.utils.k;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import si2.d0;
import si2.e0;
import si2.f0;
import si2.t;
import si2.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LivePromotionListCacheCenter implements lj2.a, oj2.a {
    public final c a;
    public mj2.e b;
    public boolean c;
    public final int d;
    public long e;
    public final com.bytedance.android.livesdk.livecommerce.promotionlist.repository.datasource.b f;
    public final DisposableScope g;
    public Disposable h;
    public Disposable i;
    public final com.bytedance.android.livesdk.livecommerce.room.utils.g j;
    public final Function0<Boolean> k;
    public final Function0<Boolean> l;
    public final RoomContextController m;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ LivePromotionListCacheCenter a;
        public final /* synthetic */ int b;
        public final /* synthetic */ long c;

        public a(LivePromotionListCacheCenter r1, int r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r6) {
            vj2.b r7 = (vj2.b) r6;
            if (this.b != 11) goto L6;
            long r0 = SystemClock.elapsedRealtime() - this.c;
            int r2 = com.bytedance.android.livesdk.livecommerce.opt.d.a;
            com.bytedance.android.livesdk.livecommerce.opt.d.a("data_fetched", this.a.a.h, Long.valueOf(r0), this.a.m.l());
        L6:
            if (((com.bytedance.android.ec.model.g) r7).statusCode != 0) goto L8;
            int r1 = mj2.e.y;
            mj2.e r8 = mj2.e.a.a(r7);
            LivePromotionListCacheCenter r3 = this.a;
            c r4 = r3.a;
            Handler r5 = k.a;
            r3.i(r4, r8, SystemClock.elapsedRealtime());
        L8:
            int r9 = zg2.a.a;
            c r10 = this.a.a;
            zg2.a.a(r10.h, r10.j, Action.SHOP_LIST_DATA_FROM, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("data_from", String.valueOf(this.b))}));
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    @Override // lj2.a
    public final void H(z r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
    }

    @Override // lj2.a
    public final void a(e0 r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
    }

    @Override // lj2.a
    public final void d(f0 r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
    }

    @Override // lj2.a
    public final void h(z r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
    }

    @Override // lj2.a
    public final void z(boolean r1, List<ECPromotionInterationData> r2) {
    }

    public final void e() {
        this.e = -1;
        this.b = null;
        this.c = false;
        this.g.clearDisposable();
        this.j.a();
        Disposable r1 = this.h;
        if (r1 != null) goto L5;
    L10:
        Disposable r2 = this.i;
        if (r2 != null) goto L13;
    L18:
        this.h = null;
        this.i = null;
        return;
    L13:
        if ((!r2.isDisposed()) == true) goto L16;
        r2 = null;
    L16:
        if (r2 == null) goto L18;
        r2.dispose();
        goto L18
    L5:
        if ((!r1.isDisposed()) == true) goto L8;
        r1 = null;
    L8:
        if (r1 == null) goto L10;
        r1.dispose();
        goto L10
    }

    public final boolean f() {
        long r0 = this.e;
        if (r0 <= 0) goto L9;
        long r1 = r0 + ((long) this.d);
        Handler r2 = k.a;
        if (r1 <= SystemClock.elapsedRealtime()) goto L9;
        if (this.b == null) goto L9;
        return true;
    L9:
        return false;
    }

    public static void b(LivePromotionListCacheCenter r6) {
        PromotionListController r0 = ControllerExtensionsKt.c(r6.m, r6.a.h).A().r;
        Context r7 = ControllerExtensionsKt.c(r6.m, r6.a.h).getContext();
        if (r7 == null) goto L18;
        int r1 = com.bytedance.android.livesdk.livecommerce.promotion.card.utils.g.a;
        Intrinsics.checkNotNullParameter(r7, "context");
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater r8 = ShoppingAsyncInflater.a.a(r7);
        com.bytedance.android.ec.opt.asyncInflate.d r2 = r8.a();
        boolean r3 = true;
        boolean r4 = com.bytedance.android.livesdk.livecommerce.promotion.card.utils.g.a(r8, r2, 2131564662, 1);
        if (com.bytedance.android.livesdk.livecommerce.promotion.card.utils.g.a(r8, r2, 2131564760, 10) == true) goto L9;
        if (r4 == true) goto L9;
        boolean r5 = false;
    L11:
        if (com.bytedance.android.livesdk.livecommerce.promotion.card.utils.g.a(r8, r2, 2131564757, 3) == true) goto L15;
        if (r5 == true) goto L15;
        r3 = false;
    L15:
        if (r3 == false) goto L19;
        r2.commit();
        return;
    L19:
        return;
    L9:
        r5 = true;
        goto L11
    }

    @Override // oj2.a
    public final void I(d0 r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        sj2.a.a("[cache] recv list refresh message");
        if (f() == true) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.livecommerce.room.utils.g r6 = this.j;
        Function0<Unit> r0 = new LivePromotionListCacheCenter$updateProductListFromListRefreshMessage$1(this);
        int r1 = com.bytedance.android.livesdk.livecommerce.room.utils.g.c;
        r6.c("update_product_list", 0, true, r0);
    }

    public final boolean c(c r5) {
        PromotionCategory.a r0 = PromotionCategory.Companion;
        String r1 = r5.b;
        r0.getClass();
        boolean r2 = PromotionCategory.a.b(r1);
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_SPLIT_PROMOTION_LIST_REQUEST().booleanValue() == false) goto L8;
        if (this.c == r5.x) goto L8;
        r2 = false;
    L8:
        if (Intrinsics.areEqual(r5.m, "live_shopping_cart") == false) goto L20;
        String r6 = r5.p;
        if (r6 != null) goto L12;
    L15:
        boolean r7 = true;
    L16:
        if (r7 == false) goto L21;
        if (r2 == false) goto L22;
        return true;
    L22:
        return false;
    L21:
        return false;
    L12:
        if (r6.length() == 0) goto L15;
        r7 = false;
        goto L16
    L20:
        return false;
    }

    public final mj2.e j(c r3) {
        Intrinsics.checkNotNullParameter(r3, "reqParam");
        boolean r4 = c(r3);
        boolean r0 = f();
        if (r4 == false) goto L9;
        if (r0 == false) goto L10;
        mj2.e r5 = this.b;
        if (r5 == null) goto L11;
        r5.u = true;
        r5.o = null;
        r5.l = null;
        return r5;
    L11:
        return null;
    L10:
        return null;
    L9:
        return null;
    }

    @Override // lj2.a
    public final void m(t r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        PromotionListController r0 = ControllerExtensionsKt.c(this.m, this.a.h).A().r;
        if (r5.msgType != 1) goto L5;
        boolean r6 = true;
    L6:
        r0.I = Boolean.valueOf(r6);
        if (f() == true) goto L9;
        return;
    L9:
        e();
        this.j.c("update_product_list", 0, true, new LivePromotionListCacheCenter$updateAuthorConnect$1(this));
        return;
    L5:
        r6 = false;
        goto L6
    }

    @Override // oj2.a
    public final void w(si2.c r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        sj2.a.a("[cache] recv category refresh message");
        if (f() == true) goto L5;
        return;
    L5:
        mj2.e r0 = this.b;
        if (r0 == null) goto L19;
        LivePromotionPageCategoryData r1 = r0.p;
        if (r1 == null) goto L20;
        List<CategoryInfo> r6 = r5.categoryInfo;
        if (r6 == null) goto L15;
        List<CategoryInfo> r7 = r6;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator<T> r8 = r7.iterator();
    L13:
        if (r8.hasNext() == false) goto L16;
        CategoryInfo r3 = (CategoryInfo) r8.next();
        PromotionCategory.Companion.getClass();
        r2.add(PromotionCategory.a.a(r3));
    L16:
        r1.setCategories(r2);
        return;
    L15:
        r2 = null;
        goto L16
    L20:
        return;
    }

    public final void g(boolean r11, int r12) {
        if (r11 == false) goto L7;
        if (xh2.a.b() == true) goto L7;
        return;
    L7:
        if (r11 == false) goto L11;
        ControllerExtensionsKt.c(this.m, this.a.h).A().r.l = true;
        ECLivePerformanceMonitor.b r13 = ECLivePerformanceMonitor.x;
        c r14 = this.a;
        ECLivePerformanceMonitor r15 = ECLivePerformanceMonitor.c.a(r14.h, r14.j);
        if (r15 == null) goto L11;
        r15.p(4, true);
    L11:
        c r16 = this.a;
        r16.k = ((Boolean) this.k.invoke()).booleanValue();
        long r1 = SystemClock.elapsedRealtime();
        com.bytedance.android.livesdk.livecommerce.promotionlist.repository.datasource.b r3 = this.f;
        c r4 = this.a;
        r4.t = ((Boolean) this.l.invoke()).booleanValue();
        Unit r17 = Unit.INSTANCE;
        Disposable r18 = r3.a(r4, 0, EComABUtils.liveListLoadPageSize(), r12, true, true).observeOn(Schedulers.io()).subscribe(new a(this, r12, r1), b.a);
        if (EComABUtils.isLiveListMemoryLeakSwitchForDisposable() == false) goto L22;
        Disposable r19 = this.h;
        if (r19 != null) goto L16;
    L21:
        this.h = r18;
        return;
    L16:
        if ((true ^ r19.isDisposed()) == true) goto L19;
        r19 = null;
    L19:
        if (r19 == null) goto L21;
        r19.dispose();
        goto L21
    L22:
        com.bytedance.android.ec.core.async.a.a(r18, this.g);
    }

    public final void i(c r2, mj2.e r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "reqParam");
        this.c = r2.x;
        if (c(r2) == false) goto L5;
        this.e = r4;
        this.b = r3;
        return;
    L5:
        this.e = -1;
        this.b = null;
        this.c = false;
    }

    @Override // lj2.a
    public final void t(String r4, final String r5, final Map<String, String> r6) {
        if (f() == true) goto L6;
        return;
    L6:
        if (r4 != null) goto L8;
    L11:
        boolean r7 = true;
    L12:
        if (r7 == false) goto L17;
        mj2.e r8 = this.b;
        if (r8 == null) goto L19;
        r8.c = null;
        return;
    L19:
        return;
    L17:
        com.bytedance.android.livesdk.livecommerce.room.utils.g r9 = this.j;
        Function0<Unit> r2 = new LivePromotionListCacheCenter$updateExplainPromotionFromMessage$1(this, r5, r6);
        int r10 = com.bytedance.android.livesdk.livecommerce.room.utils.g.c;
        r9.c("update_explain_promotion", 0, true, r2);
        return;
    L8:
        if (r4.length() == 0) goto L11;
        r7 = false;
        goto L12
    }

    public LivePromotionListCacheCenter(String r26, String r27, String r28, Function0<Boolean> r29, Function0<Boolean> r30, RoomContextController r31) {
        Intrinsics.checkNotNullParameter(r26, "anchorId");
        Intrinsics.checkNotNullParameter(r27, "anchorSecId");
        Intrinsics.checkNotNullParameter(r28, "roomId");
        Intrinsics.checkNotNullParameter(r29, "isLinkmic");
        Intrinsics.checkNotNullParameter(r30, "recommendedProductDisplayed");
        Intrinsics.checkNotNullParameter(r31, "roomContextController");
        this.k = r29;
        this.l = r30;
        this.m = r31;
        this.a = new c(r26, r27, r28, r28, r31.D(), ((Boolean) r29.invoke()).booleanValue(), false, "live_shopping_cart", false, -1, null, null, false, null, ((Boolean) r30.invoke()).booleanValue(), null, false, null, null, 2064384);
        this.d = EComABUtils.liveListCacheExpireTime();
        this.e = -1;
        this.f = new com.bytedance.android.livesdk.livecommerce.promotionlist.repository.datasource.b();
        this.g = new DisposableScope();
        this.j = new com.bytedance.android.livesdk.livecommerce.room.utils.g();
    }
}
