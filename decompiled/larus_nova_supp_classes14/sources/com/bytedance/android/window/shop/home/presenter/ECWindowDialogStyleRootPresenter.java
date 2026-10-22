package com.bytedance.android.window.shop.home.presenter;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.window.base.status.WindowLazyStatusView;
import com.bytedance.android.ec.window.base.widget.ECWindowOverScrollExpandBehavior;
import com.bytedance.android.ec.window.base.widget.WindowControllableAppBarSnapBehavior;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.window.shop.widget.WindowStatusView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowDialogStyleRootPresenter extends AbsECWindowPresenter {
    public static final /* synthetic */ int r = 0;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public boolean p;
    public View q;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ ECWindowDialogStyleRootPresenter a;

        public b(ECWindowDialogStyleRootPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Integer r4 = (Integer) r3;
            ECWindowDialogStyleRootPresenter r5 = this.a;
            ECWindowDialogStyleRootPresenter.Z(r5, r5.w().b(2131370858).f(), this.a.N());
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ ECWindowDialogStyleRootPresenter a;

        public c(ECWindowDialogStyleRootPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Pair r2 = (Pair) r1;
            this.a.b0();
        }
    }

    static {
    }

    public final void b0() {
        CoordinatorLayout r9 = w().b(2131370858).f();
        AppBarLayout r11 = w().b(2131370842).f();
        View r3 = w().b(2131370924).f();
        boolean r12 = this.p;
        if (Y(((View) this.o.getValue()).getHeight()) < 1.0f) goto L5;
        boolean r15 = true;
    L6:
        ViewGroup.LayoutParams r0 = r11.getLayoutParams();
        CoordinatorLayout.Behavior r16 = null;
        if ((r0 instanceof CoordinatorLayout.LayoutParams) == true) goto L9;
        r0 = null;
    L9:
        CoordinatorLayout.LayoutParams r1 = (CoordinatorLayout.LayoutParams) r0;
        if (r1 == null) goto L12;
        CoordinatorLayout.Behavior r7 = r1.getBehavior();
    L13:
        boolean r6 = r7 instanceof ECWindowOverScrollExpandBehavior;
        if (r6 == true) goto L16;
        CoordinatorLayout.Behavior r2 = null;
    L17:
        ECWindowOverScrollExpandBehavior r4 = (ECWindowOverScrollExpandBehavior) r2;
        if (r4 == null) goto L20;
        r4.refreshTargetOriginHeight(Integer.valueOf(K()));
    L20:
        CoordinatorLayout.Behavior r10 = r7;
        ECWindowDialogStyleRootPresenter$doAdjustWithAnim$finallyAction$1 r5 = new ECWindowDialogStyleRootPresenter$doAdjustWithAnim$finallyAction$1(this, r9, r3, r7, r12, -w().b(2131370890).f().getHeight(), r11);
        if (this.p == false) goto L29;
        if (r6 == false) goto L25;
        r16 = r10;
    L25:
        ECWindowOverScrollExpandBehavior r8 = (ECWindowOverScrollExpandBehavior) r16;
        if (r8 == null) goto L28;
        r8.setExpandEnable(false);
    L28:
        this.p = false;
        r11.setExpanded(true);
        r5.run();
        return;
    L29:
        f0 r13 = new f0(r5);
        if ((!r12) == false) goto L51;
        if (r15 == true) goto L51;
        if ((r10 instanceof WindowControllableAppBarSnapBehavior) == true) goto L36;
        r5.run();
        return;
    L36:
        if (O().isVideoTrailerOrSplitOpt() == false) goto L43;
        int r14 = w().b(2131370842).f().getHeight() - w().b(2131370968).f().getHeight();
        ViewGroup.LayoutParams r17 = w().b(2131370961).f().getLayoutParams();
        if (r17 == null) goto L42;
        int r18 = r14 + ((ViewGroup.MarginLayoutParams) r17).topMargin;
    L40:
        int r19 = -r18;
        int[] r20 = new int[2];
        Pair r21 = (Pair) O().getOffsetState().getValue();
        if (r21 == null) goto L49;
        Integer r22 = (Integer) r21.getFirst();
        if (r22 == null) goto L49;
        int r23 = r22.intValue();
    L50:
        r20[0] = r23;
        r20[1] = r19;
        ValueAnimator r24 = ValueAnimator.ofInt(r20);
        r24.setDuration(300);
        r24.setInterpolator(new DecelerateInterpolator());
        r24.addUpdateListener(new e0(r10, r9, r11));
        r24.addListener(r13);
        r24.start();
        return;
    L49:
        r23 = 0;
        goto L50
    L42:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L43:
        r18 = w().b(2131370890).f().getHeight();
    L51:
        r5.run();
        return;
    L16:
        r2 = r7;
        goto L17
    L12:
        r7 = null;
        goto L13
    L5:
        r15 = false;
        goto L6
    }

    public ECWindowDialogStyleRootPresenter() {
        this.m = LazyKt.lazy(new ECWindowDialogStyleRootPresenter$colorStart$2(this));
        this.n = LazyKt.lazy(new ECWindowDialogStyleRootPresenter$colorEnd$2(this));
        this.o = LazyKt.lazy(new ECWindowDialogStyleRootPresenter$infoArea$2(this));
        this.p = true;
    }

    public static final void a0(ECWindowDialogStyleRootPresenter r3) {
        ViewGroup.LayoutParams r0 = r3.w().b(2131370842).f().getLayoutParams();
        CoordinatorLayout.Behavior r2 = null;
        if ((r0 instanceof CoordinatorLayout.LayoutParams) == true) goto L5;
        r0 = null;
    L5:
        CoordinatorLayout.LayoutParams r1 = (CoordinatorLayout.LayoutParams) r0;
        if (r1 == null) goto L8;
        CoordinatorLayout.Behavior r4 = r1.getBehavior();
    L10:
        if ((r4 instanceof WindowControllableAppBarSnapBehavior) == false) goto L13;
        r2 = r4;
    L13:
        WindowControllableAppBarSnapBehavior r5 = (WindowControllableAppBarSnapBehavior) r2;
        if (r5 == null) goto L20;
        int r6 = r3.w().b(2131370890).f().getHeight();
        ViewGroup.LayoutParams r7 = r3.w().b(2131370961).f().getLayoutParams();
        if (r7 == null) goto L19;
        r5.setSnapIntermediately(r6 + ((ViewGroup.MarginLayoutParams) r7).topMargin);
        return;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L20:
        return;
    L8:
        r4 = null;
        goto L10
    }

    public final void A(QModel r9) {
        y().setBackgroundColor(0);
        View r10 = w().b(2131370956).f();
        ViewGroup.LayoutParams r1 = r10.getLayoutParams();
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r1 = null;
    L5:
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
        if (r2 == null) goto L8;
        r2.setMargins(r2.leftMargin, G(), r2.rightMargin, r2.bottomMargin);
        Unit r3 = Unit.INSTANCE;
    L9:
        r10.setLayoutParams(r2);
        ViewExtensionsKt.g(r10, 12.0f, 12.0f, 0.0f, 0.0f);
        final WindowLazyStatusView r4 = w().b(2131370955).f();
        com.bytedance.android.ec.window.base.status.c.d r5 = com.bytedance.android.ec.window.base.status.c.d.a;
        r4.setCreators(MapsKt.mapOf(new Pair[]{TuplesKt.to(r5, new com.bytedance.android.ec.window.base.status.d(new ECWindowDialogStyleRootPresenter$initStatusView$2(this), null, null)), TuplesKt.to(com.bytedance.android.ec.window.base.status.c.c.a, new com.bytedance.android.ec.window.base.status.d(new ECWindowDialogStyleRootPresenter$initStatusView$3(this, r4), null, null))}));
        r4.b(r5);
        O().getLoadStatus().a(U(), new g0(r4, r10), false);
        if (this.q != null) goto L13;
        this.q = y().findViewById(2131370960);
    L13:
        if (yq3.a.a() != 1) goto L24;
        View r11 = this.q;
        if (r11 == null) goto L19;
        View r12 = r11.findViewById(2131371349);
        if (r12 == null) goto L19;
        r12.setVisibility(0);
    L19:
        View r13 = this.q;
        if (r13 == null) goto L34;
        View r14 = r13.findViewById(2131371348);
        if (r14 == null) goto L34;
        r14.setVisibility(8);
    L34:
        LifecycleOwner r15 = U();
        O().getHeaderSubTabsParam().e.a(r15, new h0(this, r15), false);
        AppBarLayout r16 = w().b(2131370842).f();
        r16.addOnOffsetChangedListener(new i0(r16, this));
        O().getShopParam().setHasHeaderLive(false);
        w().b(2131370923).f().setVisibility(8);
        b0();
        w().b(2131370858).f().g = false;
        O().getTabBarHeight().a(U(), new b(this), false);
        O().getSelectedTabLocation().a(U(), new c(this), false);
        return;
    L24:
        View r17 = this.q;
        if (r17 == null) goto L29;
        View r18 = r17.findViewById(2131371349);
        if (r18 == null) goto L29;
        r18.setVisibility(8);
    L29:
        View r19 = this.q;
        if (r19 == null) goto L34;
        WindowStatusView r20 = (WindowStatusView) r19.findViewById(2131371348);
        if (r20 == null) goto L34;
        r20.setVisibility(0);
        r20.setVisibility(0);
        r20.setECStatus(0);
        goto L34
    L8:
        r2 = null;
        goto L9
    }

    public static final void Z(ECWindowDialogStyleRootPresenter r3, CoordinatorLayout r4, int r5) {
        r3.getClass();
        Iterator r6 = com.bytedance.commerce.base.view.b.a(r4).iterator();
        View r7 = null;
        AppBarLayout r0 = null;
    L4:
        if (r6.hasNext() == false) goto L8;
        AppBarLayout r1 = (View) r6.next();
        if ((r1 instanceof AppBarLayout) == false) goto L4;
        r0 = r1;
        goto L4
    L8:
        if (r0 == null) goto L23;
        View r8 = r0.getChildAt(0);
        if ((r8 instanceof CollapsingToolbarLayout) == false) goto L13;
        r7 = r8;
    L13:
        CollapsingToolbarLayout r9 = (CollapsingToolbarLayout) r7;
        if (r9 == null) goto L24;
        r9.setMinimumHeight(r5);
        return;
    L24:
        return;
    }
}
