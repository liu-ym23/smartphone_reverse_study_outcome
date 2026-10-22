package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related;

import android.content.Context;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.OptCardUtil;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.promotion.ECUISmallPopCard;
import com.bytedance.android.ec.model.response.ECCurrentPromotion;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.opt.ECLivePerformanceMonitor;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.y;
import com.facebook.imagepipeline.common.Priority;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class PromotionCardLoadOptUtils {
    public static final HashMap<String, PromotionCardLoadOptUtils> n = null;
    public static final Lazy o = null;
    public static final Companion p = null;
    public volatile boolean a;
    public volatile Long b;
    public volatile Long c;
    public volatile ECUIPromotion d;
    public volatile boolean e;
    public volatile Disposable f;
    public volatile Function1<? super ECUIPromotion, Unit> g;
    public ECContext h;
    public volatile boolean i;
    public WeakReference<Context> j;
    public final Function3<com.bytedance.android.livesdk.livecommerce.room.model.e, String, Boolean, Observable<ECCurrentPromotion>> k;
    public final int l;
    public final a m;

    public static final class Companion {
        public Companion() {
        }

        public static PromotionCardLoadOptUtils c(String r4) {
            Intrinsics.checkNotNullParameter(r4, "roomId");
            HashMap<String, PromotionCardLoadOptUtils> r0 = PromotionCardLoadOptUtils.n;
            PromotionCardLoadOptUtils r1 = r0.get(r4);
            if (r1 != null) goto L6;
            PromotionCardLoadOptUtils r2 = new PromotionCardLoadOptUtils(PromotionCardLoadOptUtils$Companion$getRelatedOpt$1.INSTANCE, (PromotionCardLoadOptUtils$Companion$RELATED_MONITOR$2.a) PromotionCardLoadOptUtils.o.getValue());
            PromotionCardLoadOptUtils.p.getClass();
            r0.put(r4, r2);
            return r2;
        L6:
            return r1;
        }

        public static final void b(Companion r13, ECUIPromotion r14) {
            r13.getClass();
            Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L19
            String r0 = r14.imageUrl;     // Catch: Throwable -> L19
            int r16 = com.bytedance.android.ec.core.imagex.r.h;     // Catch: Throwable -> L19
            com.bytedance.android.ec.core.imagex.r r1 = com.bytedance.android.ec.core.imagex.r.a.b("goods_card_view");     // Catch: Throwable -> L19
            Priority r17 = Priority.IMMEDIATE;     // Catch: Throwable -> L19
            ImageExtensionsKt.B(r0, r1, null, null, r17, new d(), null, false, 192);     // Catch: Throwable -> L19
            ECUrlModel r2 = r14.topIcon;     // Catch: Throwable -> L19
            if (r2 == null) goto L8;
            String r4 = r2.getFirstUrl();     // Catch: Throwable -> L19
            if (r4 == null) goto L8;
            ImageExtensionsKt.B(r4, com.bytedance.android.ec.core.imagex.r.a.b("goods_card_top_up_view"), null, null, r17, new e(), null, false, 192);     // Catch: Throwable -> L19
        L8:
            y.o.getClass();     // Catch: Throwable -> L19
            if (y.m == false) goto L24;
            ImageExtensionsKt.B(r14.normalBottonIcon, com.bytedance.android.ec.core.imagex.r.a.b("goods_card_botton_normal_view"), null, null, r17, new f(), null, false, 192);     // Catch: Throwable -> L19
            ImageExtensionsKt.B(r14.qIvIcon, com.bytedance.android.ec.core.imagex.r.a.b("goods_card_up_view"), null, null, r17, new g(), null, false, 192);     // Catch: Throwable -> L19
            ECUISmallPopCard r18 = r14.smallPopCard;     // Catch: Throwable -> L19
            if (r18 == null) goto L16;
            String r5 = r18.backgroundImgNew;     // Catch: Throwable -> L19
            if (r5 == null) goto L16;
            ImageExtensionsKt.B(r5, com.bytedance.android.ec.core.imagex.r.a.b("goods_card_activity_view"), null, null, r17, new h(), null, false, 192);     // Catch: Throwable -> L19
            Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L19
        L17:
            Result.constructor-impl(r19);     // Catch: Throwable -> L19
            return;
        L16:
            r19 = null;
            goto L17
        L24:
            return;
        L19:
            th = move-exception;
            Result.Companion r110 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }

        public static final void a(Companion r1, Context r2, int r3) {
            r1.getClass();
            ShoppingAsyncInflater.a r4 = ShoppingAsyncInflater.e;
            Context r5 = th.a.e(r2, true);
            r4.getClass();
            com.bytedance.android.ec.opt.asyncInflate.d r6 = ShoppingAsyncInflater.a.a(r5).a();
            r6.c(2131560684, r3, "ec_explain_card_uimodule_above");
            r6.c(2131560682, r3, "ec_explain_card_bottom_layout");
            r6.commit();
        }
    }

    static {
        p = new Companion();
        n = new HashMap();
        o = LazyKt.lazy(PromotionCardLoadOptUtils$Companion$RELATED_MONITOR$2.INSTANCE);
    }

    public final WeakReference<Context> getContext() {
        return this.j;
    }

    public PromotionCardLoadOptUtils(Function3 r2, PromotionCardLoadOptUtils$Companion$RELATED_MONITOR$2.a r3) {
        Intrinsics.checkNotNullParameter(r2, "dataSource");
        Intrinsics.checkNotNullParameter(r3, "monitor");
        this.k = r2;
        this.l = 1;
        this.m = r3;
    }

    public final void a(ECContext r5, com.bytedance.android.livesdk.livecommerce.room.model.g r6, String r7, Context r8, com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.p r9) {
        Intrinsics.checkNotNullParameter(r5, "ecContext");
        Intrinsics.checkNotNullParameter(r6, "liveRoomInfo");
        if (ECLiveABUtils.INSTANCE.getENABLE_KMP_POP_CARD() == false) goto L5;
        return;
    L5:
        dm.a.b r0 = dm.a.a("LiveCardLoad");
        StringBuilder r1 = new StringBuilder("preload related card, is instant = ");
        if (r9 == null) goto L8;
        boolean r3 = true;
    L9:
        r1.append(r3);
        r0.i(r1.toString());
        if (r9 == null) goto L13;
        r9.c(r5, r6, r7);
        return;
    L13:
        if (r7 != null) goto L16;
        return;
    L16:
        if (com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t.f == true) goto L19;
        return;
    L19:
        if (this.a != true) goto L21;
    L23:
        this.h = r5;
        if (r8 == null) goto L38;
        y.o.getClass();
        if (y.k == false) goto L36;
        WeakReference<Context> r10 = this.j;
        if (r10 == null) goto L30;
        Context r11 = r10.get();
    L31:
        boolean r12 = Intrinsics.areEqual(r11, r8);
        this.m.c((ECLivePerformanceMonitor) r5.getEcLivePerformanceMonitor().getValue(), r12);
        OptCardUtil.b(null, "async layout same: " + r12);
        if (this.i == false) goto L35;
        if (r12 == false) goto L35;
        return;
    L35:
        Companion.a(p, r8, this.l);
        return;
    L30:
        r11 = null;
        goto L31
    L36:
        Companion.a(p, r8, this.l);
        return;
    L38:
        return;
    L21:
        if (this.e == true) goto L23;
        OptCardUtil.b(null, "request=" + com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t.h + " bind=" + com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t.i + " show=" + com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t.j + " CardDoFrame=" + com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t.k + " PicPreload=" + com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t.l + " PicDoFrame=" + com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t.m);
        this.a = true;
        this.m.e((ECLivePerformanceMonitor) r5.getEcLivePerformanceMonitor().getValue());
        bk2.c.a(((Observable) this.k.invoke(r6, r7, Boolean.TRUE)).subscribe(new k(this, r5), new l(this, r5)), (bk2.d) r5.getDisposableContext().getValue());
        goto L23
    L8:
        r3 = false;
        goto L9
    }
}
