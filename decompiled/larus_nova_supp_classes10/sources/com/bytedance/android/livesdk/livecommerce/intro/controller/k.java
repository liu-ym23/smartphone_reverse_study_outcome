package com.bytedance.android.livesdk.livecommerce.intro.controller;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.utils.OptCardUtil;
import com.bytedance.android.livesdk.livecommerce.intro.model.req.IntroCardScene;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroProduct;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroPromotionVO;
import com.bytedance.android.livesdk.livecommerce.opt.ECLivePerformanceMonitor;
import com.bytedance.bdlocation.exception.BDLocationException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k extends com.bytedance.android.livesdk.livecommerce.intro.manager.a {
    public final /* synthetic */ IntroCardWidgetController f;
    public final /* synthetic */ boolean g;
    public final /* synthetic */ Function0 h;
    public final /* synthetic */ IntroPromotionVO i;

    public static final class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ k a;

        public a(k r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r4) {
            Intrinsics.checkNotNullParameter(r4, "v");
            this.a.f.u.b(120, r4.getHeight(), this.a.f.u.a(1.0f));
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
        this.f.d.getShowAfterAnimAction().e(new bk2.a(Unit.INSTANCE));
        int r0 = g.a;
        ECLivePerformanceMonitor r2 = g.a(this.f.p);
        if (r2 == null) goto L21;
        if (IntroCardWidgetController.b(this.f) == false) goto L11;
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
        IntroCardWidgetController r10 = this.f;
        r10.getClass();
        g.c(true, new IntroCardWidgetController$onCardVisible$1(r10), r10.p);
        return;
    L23:
        if (IntroCardWidgetController.b(this.f) == true) goto L26;
        IntroCardWidgetController r11 = this.f;
        r11.h = true;
        r11.g = true;
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
        oh2.b r2 = this.f.c;
        if ((r2 instanceof ph2.h) == true) goto L13;
        r2 = null;
    L13:
        ph2.h r3 = (ph2.h) r2;
        if (r3 == null) goto L21;
        View r4 = r3.l;
        if ((r4 instanceof ConstraintLayout) == true) goto L18;
        r4 = null;
    L18:
        ConstraintLayout r5 = (ConstraintLayout) r4;
        if (r5 == null) goto L21;
        r3.k(r5);
    L21:
        this.f.d.getShowBeforeAnimAction().e(new bk2.a(Unit.INSTANCE));
        OptCardUtil.b(null, "call anim start; set promotion state");
        com.bytedance.android.livesdk.livecommerce.intro.utils.k.c(">> post card state to vm, from animStart");
        this.f.d.getCardState().e(this.i);
        return;
    L5:
        if (((Boolean) IntroCardWidgetController.y.getValue()).booleanValue() == false) goto L7;
        this.f.b.p().addOnAttachStateChangeListener(new a(this));
        goto L7
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.manager.a
    public final void c() {
        dm.a.a("IntroWidgetController").a("[showCardAnim] invalidAnim");
    }

    public k(IntroCardWidgetController r1, boolean r2, Function0 r3, IntroPromotionVO r4, String r5, View r6, Function2 r7) {
        this.f = r1;
        this.g = r2;
        this.h = r3;
        this.i = r4;
        super(r5, r6, 0, r7);
    }
}
