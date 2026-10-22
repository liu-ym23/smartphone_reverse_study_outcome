package com.bytedance.android.livesdk.livecommerce.intro.card.presenter;

import android.net.Uri;
import android.view.View;
import android.view.ViewTreeObserver;
import com.bytedance.android.livesdk.livecommerce.intro.card.vm.IntroCardViewModel;
import com.bytedance.android.livesdk.livecommerce.intro.card.widget.bg.ECStrokedWaveDraweeView;
import com.bytedance.android.livesdk.livecommerce.intro.manager.BottomRightAnim;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroPromotionVO;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.quick.ActionObserver;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.room.widgets.anim.CartCardLinkedAnimController;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.o0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class IntroCardPresenter extends oh2.a implements ViewTreeObserver.OnGlobalLayoutListener {
    public IntroPromotionVO i;
    public Long j;
    public boolean k;
    public Uri l;
    public final Lazy m;

    public IntroCardPresenter() {
        super(0);
        this.m = LazyKt.lazy(new IntroCardPresenter$cartViewAttachStateChangeListener$2(this));
    }

    public final View F() {
        IntroCardViewModel r0 = this.e;
        if (r0 == null) goto L15;
        RoomContextController r1 = r0.getRoomContextController();
        if (r1 == null) goto L15;
        ECContext r2 = r1.r();
        if (r2 == null) goto L15;
        com.bytedance.live.datacontext.i<CartCardLinkedAnimController> r3 = r2.getLinkedAnimController();
        if (r3 == null) goto L15;
        CartCardLinkedAnimController r4 = (CartCardLinkedAnimController) r3.getValue();
        if (r4 == null) goto L15;
        yk2.c r5 = r4.d;
        if (r5 == null) goto L15;
        return r5.getView();
    L15:
        return null;
    }

    @Override // oh2.a
    public final void C() {
        clearDisposable();
        UtilityKotlinExtentionsKt.f(this.j, this.i, new IntroCardPresenter$logShowDurationEvent$1(this));
        this.j = null;
        View r0 = F();
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.k == false) goto L9;
        this.k = false;
        r0.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        r0.removeOnAttachStateChangeListener((IntroCardPresenter$cartViewAttachStateChangeListener$2.a) this.m.getValue());
        return;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [android.widget.ImageView, com.bytedance.android.livesdk.livecommerce.intro.card.widget.bg.ECStrokedWaveDraweeView] */
    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        ?? r0 = (ECStrokedWaveDraweeView) w().b(2131376045).f();
        View r1 = F();
        if (r1 == null) goto L8;
        float r2 = E(r1);
        if (r2 == r0.getWaveLeftMargin()) goto L9;
        float r3 = r0.a;
        float r4 = r0.b;
        r0.a = RangesKt.coerceAtLeast(r3, 0.0f);
        r0.b = RangesKt.coerceAtLeast(r4, 0.0f);
        r0.c = r2;
        r0.j();
        r0.invalidate();
        return;
    L9:
        return;
    }

    @Override // oh2.a
    public final void D(oh2.h r5) {
        Intrinsics.checkNotNullParameter(r5, "model");
        IntroCardViewModel r0 = this.e;
        if (r0 == null) goto L7;
        bk2.e<bk2.a<Unit>> r1 = r0.getShowBeforeAnimAction();
        if (r1 == null) goto L7;
        r1.b(r5.getLifecycleOwner(), new ActionObserver(new IntroCardPresenter$bind$1(this)));
    L7:
        IntroCardViewModel r2 = this.e;
        if (r2 == null) goto L12;
        bk2.e<bk2.a<Unit>> r3 = r2.getShowAfterAnimAction();
        if (r3 == null) goto L12;
        r3.b(r5.getLifecycleOwner(), new ActionObserver(new IntroCardPresenter$bind$2(this)));
    L12:
        IntroCardViewModel r4 = this.e;
        if (r4 == null) goto L17;
        bk2.e<IntroPromotionVO> r6 = r4.getCardState();
        if (r6 == null) goto L17;
        r6.b(r5.getLifecycleOwner(), new IntroCardPresenter$bind$3(this));
    L17:
        IntroCardViewModel r7 = this.e;
        if (r7 == null) goto L22;
        bk2.e<bk2.a<Unit>> r8 = r7.getShowCardAction();
        if (r8 == null) goto L22;
        r8.b(r5.getLifecycleOwner(), new ActionObserver(new IntroCardPresenter$bind$4(this)));
    L22:
        com.bytedance.android.ec.core.widget.f.c(w().b(2131376107).f(), null, null, new IntroCardPresenter$bind$5(this), 3);
        com.bytedance.android.ec.core.widget.f.c(w().f(), null, "bind_key_live_cart_card", new IntroCardPresenter$bind$6(this), 1);
    }

    public final float E(View r4) {
        BottomRightAnim.a.getClass();
        Intrinsics.checkNotNullParameter(r4, "view");
        int[] r0 = new int[2];
        r4.getLocationOnScreen(r0);
        int r1 = 0;
        int r2 = r0[0];
        if (r2 <= 0) goto L5;
        r1 = r2;
    L5:
        if (r1 > 0) goto L9;
        return Float.MAX_VALUE;
    L9:
        return (((r1 - UtilityKotlinExtentionsKt.c(12)) - o0.a(w().f())) + (r4.getWidth() / 2.0f)) - (((ECStrokedWaveDraweeView) w().b(2131376045).f()).getWaveWidth() / 2.0f);
    }
}
