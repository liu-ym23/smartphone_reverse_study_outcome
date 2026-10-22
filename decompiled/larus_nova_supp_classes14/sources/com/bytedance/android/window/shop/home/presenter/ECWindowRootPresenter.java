package com.bytedance.android.window.shop.home.presenter;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.Choreographer;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.ColorUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.window.base.status.WindowLazyStatusView;
import com.bytedance.android.ec.window.base.widget.ECWindowOverScrollExpandBehavior;
import com.bytedance.android.ec.window.base.widget.WindowControllableAppBarSnapBehavior;
import com.bytedance.android.window.shop.home.ECWindowActivity;
import com.bytedance.android.window.shop.home.ECWindowParam;
import com.bytedance.android.window.shop.home.header.WindowHeaderFragment;
import com.bytedance.android.window.shop.widget.WindowStatusView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowRootPresenter extends j {
    public static final /* synthetic */ int q = 0;
    public final Lazy m;
    public final Lazy n;
    public boolean o;
    public View p;

    public static final class a {
    }

    public static final class b implements AppBarLayout.OnOffsetChangedListener {
        public final /* synthetic */ AppBarLayout a;
        public final /* synthetic */ ECWindowRootPresenter b;

        public b(AppBarLayout r1, ECWindowRootPresenter r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onOffsetChanged(AppBarLayout r5, int r6) {
            Pair r7 = new Pair(Integer.valueOf(r6), Integer.valueOf(this.a.getTotalScrollRange()));
            ECWindowParam r0 = this.b.O().getShopParam();
            ECWindowRootPresenter r1 = this.b;
            float r2 = ((Number) r7.getFirst()).intValue();
            float r3 = ((Number) r7.getSecond()).intValue();
            r1.getClass();
            r0.setTopMode(AbsECWindowPresenter.S(r2, r3));
            Pair r4 = (Pair) this.b.O().getOffsetState().getValue();
            if (r4 != null) goto L5;
        L8:
            this.b.O().getOffsetState().setValue(r7);
            final ECWindowRootPresenter r8 = this.b;
            r8.getClass();
            Choreographer.getInstance().postFrameCallback(new x1(new ECWindowRootPresenter$updateMultiDispatchActiveRange$1(r8)));
            if (Math.abs(((Number) r7.getFirst()).intValue()) != 0) goto L11;
        L12:
            ECWindowRootPresenter.c0(this.b);
        L13:
            this.b.y().setBackgroundColor(ColorUtils.blendARGB(((Number) this.b.m.getValue()).intValue(), ((Number) this.b.n.getValue()).intValue(), 1 + (r6 / this.a.getTotalScrollRange())));
            return;
        L11:
            if (Math.abs(((Number) r7.getFirst()).intValue()) != Math.abs(((Number) r7.getSecond()).intValue())) goto L13;
        L5:
            if (((Number) r4.getFirst()).intValue() != ((Number) r7.getFirst()).intValue()) goto L8;
            if (((Number) r4.getSecond()).intValue() == ((Number) r7.getSecond()).intValue()) goto L13;
            goto L8
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ ECWindowRootPresenter a;

        public c(ECWindowRootPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            Boolean r5 = (Boolean) r4;
            this.a.O().getShopParam().setHasHeaderLive(this.a.F());
            this.a.O().getOffsetState().a(this.a.U(), new w1(this), false);
            ECWindowRootPresenter.a0(this.a);
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ ECWindowRootPresenter a;

        public d(ECWindowRootPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Integer r4 = (Integer) r3;
            ECWindowRootPresenter r5 = this.a;
            ECWindowRootPresenter.b0(r5, r5.w().b(2131370858).f(), this.a.N());
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ ECWindowRootPresenter a;

        public e(ECWindowRootPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Pair r2 = (Pair) r1;
            ECWindowRootPresenter.a0(this.a);
        }
    }

    static {
    }

    public ECWindowRootPresenter() {
        this.m = LazyKt.lazy(new ECWindowRootPresenter$colorStart$2(this));
        this.n = LazyKt.lazy(new ECWindowRootPresenter$colorEnd$2(this));
        this.o = true;
    }

    public static final void a0(ECWindowRootPresenter r19) {
        CoordinatorLayout r8 = r19.w().b(2131370858).f();
        AppBarLayout r9 = r19.w().b(2131370842).f();
        View r3 = r19.w().b(2131370924).f();
        if (r19.o == false) goto L5;
        boolean r11 = r19.O().couldLive();
    L7:
        if (r19.Y(r19.w().b(2131370890).f().getHeight()) < 1.0f) goto L9;
        boolean r14 = true;
    L10:
        ViewGroup.LayoutParams r0 = r9.getLayoutParams();
        if ((r0 instanceof CoordinatorLayout.LayoutParams) == true) goto L13;
        r0 = null;
    L13:
        CoordinatorLayout.LayoutParams r1 = (CoordinatorLayout.LayoutParams) r0;
        if (r1 == null) goto L16;
        CoordinatorLayout.Behavior r6 = r1.getBehavior();
    L17:
        int r5 = -r19.w().b(2131370890).f().getHeight();
        int r4 = r19.N();
        boolean r2 = r6 instanceof ECWindowOverScrollExpandBehavior;
        if (r2 == true) goto L20;
        CoordinatorLayout.Behavior r7 = null;
    L21:
        ECWindowOverScrollExpandBehavior r10 = (ECWindowOverScrollExpandBehavior) r7;
        if (r10 == null) goto L24;
        r10.refreshTargetOriginHeight(Integer.valueOf(r4));
    L24:
        CoordinatorLayout.Behavior r12 = r6;
        ECWindowRootPresenter$doAdjustWithAnim$finallyAction$1 r13 = new ECWindowRootPresenter$doAdjustWithAnim$finallyAction$1(r19, r8, r3, r4, r6, r9);
        t1 r15 = new t1(r13);
        if (r19.o == false) goto L34;
        if (r2 == true) goto L28;
        CoordinatorLayout.Behavior r16 = null;
    L29:
        ECWindowOverScrollExpandBehavior r17 = (ECWindowOverScrollExpandBehavior) r16;
        if (r17 == null) goto L32;
        r17.setExpandEnable(false);
    L32:
        r13.run();
        return;
    L28:
        r16 = r12;
        goto L29
    L34:
        if ((!r11) == false) goto L46;
        if (r14 == true) goto L46;
        if ((r12 instanceof WindowControllableAppBarSnapBehavior) == true) goto L39;
        r13.run();
        return;
    L39:
        int[] r18 = new int[2];
        Pair r20 = (Pair) r19.O().getOffsetState().getValue();
        if (r20 == null) goto L44;
        Integer r21 = (Integer) r20.getFirst();
        if (r21 == null) goto L44;
        int r22 = r21.intValue();
    L45:
        r18[0] = r22;
        r18[1] = r5;
        ValueAnimator r23 = ValueAnimator.ofInt(r18);
        r23.setDuration(300);
        r23.setInterpolator(new cr3.a(0.42f, 0.0f, 1.0f));
        r23.addUpdateListener(new s1(r12, r8, r9));
        r23.addListener(r15);
        r23.start();
        return;
    L44:
        r22 = 0;
    L46:
        r13.run();
        return;
    L20:
        r7 = r6;
        goto L21
    L16:
        r6 = null;
        goto L17
    L9:
        r14 = false;
        goto L10
    L5:
        r11 = false;
        goto L7
    }

    public static final void c0(ECWindowRootPresenter r3) {
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
        y().setBackgroundColor(ResourcesCompat.getColor(th.a.f(y().getContext()), 2131101856, null));
        View r10 = w().b(2131370956).f();
        final WindowLazyStatusView r0 = w().b(2131370955).f();
        com.bytedance.android.ec.window.base.status.c.d r3 = com.bytedance.android.ec.window.base.status.c.d.a;
        r0.setCreators(MapsKt.mapOf(new Pair[]{TuplesKt.to(r3, new com.bytedance.android.ec.window.base.status.d(new ECWindowRootPresenter$initStatusView$1(this, r0), null, null)), TuplesKt.to(com.bytedance.android.ec.window.base.status.c.c.a, new com.bytedance.android.ec.window.base.status.d(new ECWindowRootPresenter$initStatusView$2(this, r0), null, null))}));
        r0.b(r3);
        O().getLoadStatus().a(U(), new u1(r0, r10), false);
        if (this.p != null) goto L6;
        this.p = y().findViewById(2131370960);
    L6:
        if (yq3.a.a() != 1) goto L17;
        View r11 = this.p;
        if (r11 == null) goto L12;
        View r12 = r11.findViewById(2131371349);
        if (r12 == null) goto L12;
        r12.setVisibility(0);
    L12:
        View r13 = this.p;
        if (r13 == null) goto L27;
        View r14 = r13.findViewById(2131371348);
        if (r14 == null) goto L27;
        r14.setVisibility(8);
    L27:
        LifecycleOwner r15 = U();
        O().getHeaderSubTabsParam().e.a(r15, new v1(this, r15), false);
        QContext r16 = u();
        FragmentActivity r1 = com.bytedance.android.ec.core.utils.l0.c(r16.c());
        if ((r1 instanceof ECWindowActivity) == true) goto L30;
        r1 = null;
    L30:
        ECWindowActivity r2 = (ECWindowActivity) r1;
        if (r2 != null) goto L37;
        FragmentActivity r17 = r16.c();
        if ((r17 instanceof ECWindowActivity) == true) goto L35;
        r17 = null;
    L35:
        r2 = (ECWindowActivity) r17;
    L37:
        if (r2 == null) goto L43;
        FragmentTransaction r4 = r2.getSupportFragmentManager().beginTransaction();
        WindowHeaderFragment r5 = new WindowHeaderFragment();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r4, r5, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131370889) == true) goto L42;
        r4 = r4.replace(2131370889, r5);
    L42:
        r4.commitAllowingStateLoss();
    L87:
        AppBarLayout r18 = w().b(2131370842).f();
        r18.addOnOffsetChangedListener(new b(r18, this));
        O().isLiveOn().a(U(), new c(this), false);
        w().b(2131370858).f().g = true;
        O().getTabBarHeight().a(U(), new d(this), false);
        O().getSelectedTabLocation().a(U(), new e(this), false);
        return;
    L43:
        QContext r6 = u();
        FragmentActivity r7 = com.bytedance.android.ec.core.utils.l0.c(r6.c());
        if ((r7 instanceof FragmentActivity) == true) goto L46;
        r7 = null;
    L46:
        if (r7 != null) goto L51;
        Context r8 = r6.c();
        if ((r8 instanceof FragmentActivity) == true) goto L50;
        r8 = null;
    L50:
        r7 = (FragmentActivity) r8;
    L51:
        if (r7 == null) goto L55;
        FragmentManager r19 = r7.getSupportFragmentManager();
        if (r19 == null) goto L55;
        List r20 = r19.getFragments();
    L56:
        if (r20 == null) goto L80;
        ArrayList r21 = new ArrayList();
        Iterator r22 = r20.iterator();
    L59:
        if (r22.hasNext() == false) goto L66;
        Object r23 = r22.next();
        if (((Fragment) r23).getHost() == null) goto L63;
        boolean r24 = true;
    L64:
        if (r24 == false) goto L59;
        r21.add(r23);
        goto L59
    L63:
        r24 = false;
        goto L64
    L66:
        Iterator r25 = r21.iterator();
    L68:
        if (r25.hasNext() == false) goto L78;
        Object r26 = r25.next();
        View r27 = ((Fragment) r26).getView();
        if (r27 == null) goto L72;
        View r28 = r27.findViewById(2131370889);
    L73:
        if (r28 == null) goto L75;
        boolean r29 = true;
    L76:
        if (r29 == false) goto L68;
    L79:
        Fragment r30 = (Fragment) r26;
    L81:
        if (r30 == null) goto L87;
        FragmentTransaction r31 = r30.getChildFragmentManager().beginTransaction();
        WindowHeaderFragment r32 = new WindowHeaderFragment();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r31, r32, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131370889) == true) goto L86;
        r31 = r31.replace(2131370889, r32);
    L86:
        r31.commitAllowingStateLoss();
        goto L87
    L75:
        r29 = false;
        goto L76
    L72:
        r28 = null;
        goto L73
    L78:
        r26 = null;
        goto L79
    L80:
        r30 = null;
    L55:
        r20 = null;
        goto L56
    L17:
        View r33 = this.p;
        if (r33 == null) goto L22;
        View r34 = r33.findViewById(2131371349);
        if (r34 == null) goto L22;
        r34.setVisibility(8);
    L22:
        View r35 = this.p;
        if (r35 == null) goto L27;
        WindowStatusView r36 = (WindowStatusView) r35.findViewById(2131371348);
        if (r36 == null) goto L27;
        r36.setVisibility(0);
        r36.setVisibility(0);
        r36.setECStatus(0);
        goto L27
    }

    public static final void b0(ECWindowRootPresenter r3, CoordinatorLayout r4, int r5) {
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
        if (r0 == null) goto L10;
        r0.setMinimumHeight(r5);
    L10:
        if (r0 == null) goto L25;
        View r8 = r0.getChildAt(0);
        if ((r8 instanceof CollapsingToolbarLayout) == false) goto L15;
        r7 = r8;
    L15:
        CollapsingToolbarLayout r9 = (CollapsingToolbarLayout) r7;
        if (r9 == null) goto L26;
        r9.setMinimumHeight(r5);
        return;
    L26:
        return;
    }
}
