package com.bytedance.android.livesdk.livecommerce.intro.controller;

import android.view.View;
import com.bytedance.android.ec.core.utils.OptCardUtil;
import com.bytedance.android.livesdk.livecommerce.intro.model.req.IntroCardScene;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroProduct;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroAuctionPromotionVO;
import com.bytedance.android.livesdk.livecommerce.opt.ECLivePerformanceMonitor;
import com.bytedance.bdlocation.exception.BDLocationException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f extends com.bytedance.android.livesdk.livecommerce.intro.manager.a {
    public final /* synthetic */ IntroAuctionWidgetController f;
    public final /* synthetic */ boolean g;
    public final /* synthetic */ Function0 h;
    public final /* synthetic */ IntroAuctionPromotionVO i;

    public static final class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ f a;

        public a(f r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r4) {
            Intrinsics.checkNotNullParameter(r4, "v");
            this.a.f.t.b(120, r4.getHeight(), this.a.f.t.a(1.0f));
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            r2.removeOnAttachStateChangeListener(this);
        }
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.manager.a
    public final void a() {
        dm.a.a("IntroWidgetController").a("[showCardAnim] animEnd");
        Boolean r1 = null;
        OptCardUtil.b(null, "call animEnd");
        this.f.c.getShowAfterAnimAction().e(new bk2.a(Unit.INSTANCE));
        int r0 = g.a;
        ECLivePerformanceMonitor r2 = g.a(this.f.o);
        if (r2 == null) goto L21;
        if (IntroAuctionWidgetController.b(this.f) == false) goto L11;
        boolean r3 = !this.g;
        IntroProduct r4 = this.i.getProduct();
        if (r4 == null) goto L9;
        int r5 = r4.h();
    L10:
        r2.m(true, r3, r5);
    L16:
        IntroCardScene r6 = this.i.getCardReqScene();
        if (r6 == null) goto L19;
        r1 = Boolean.valueOf(sh2.f.b(r6));
    L19:
        r2.x(false, r1, new gf.a(0), this.c, BDLocationException.ERROR_TIMEOUT);
        goto L21
    L9:
        r5 = 1;
        goto L10
    L11:
        boolean r7 = !this.g;
        IntroProduct r8 = this.i.getProduct();
        if (r8 == null) goto L14;
        int r9 = r8.h();
    L15:
        r2.m(r7, r7, r9);
        goto L16
    L14:
        r9 = 1;
    L21:
        if (this.g == true) goto L23;
    L26:
        IntroAuctionWidgetController r10 = this.f;
        r10.getClass();
        g.c(true, new IntroAuctionWidgetController$onCardVisible$1(r10), r10.o);
        return;
    L23:
        if (IntroAuctionWidgetController.b(this.f) == true) goto L26;
        IntroAuctionWidgetController r11 = this.f;
        r11.g = true;
        r11.f = true;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.manager.a
    public final void b() {
        if (this.g == true) goto L5;
    L7:
        dm.a.a("IntroWidgetController").a("[showCardAnim] animStart");
        Function0 r0 = this.h;
        if (r0 == null) goto L10;
        Unit r1 = (Unit) r0.invoke();
    L10:
        this.f.c.getShowBeforeAnimAction().e(new bk2.a(Unit.INSTANCE));
        OptCardUtil.b(null, "call anim start; set promotion state");
        com.bytedance.android.livesdk.livecommerce.intro.utils.k.c(">> post card state to vm, from animStart");
        this.f.c.getCardState().e(this.i);
        return;
    L5:
        if (((Boolean) IntroAuctionWidgetController.w.getValue()).booleanValue() == false) goto L7;
        this.f.b.p().addOnAttachStateChangeListener(new a(this));
        goto L7
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.manager.a
    public final void c() {
        dm.a.a("IntroWidgetController").a("[showCardAnim] invalidAnim");
    }

    public f(IntroAuctionWidgetController r1, boolean r2, Function0 r3, IntroAuctionPromotionVO r4, String r5, View r6, Function2 r7) {
        this.f = r1;
        this.g = r2;
        this.h = r3;
        this.i = r4;
        super(r5, r6, 0, r7);
    }
}
