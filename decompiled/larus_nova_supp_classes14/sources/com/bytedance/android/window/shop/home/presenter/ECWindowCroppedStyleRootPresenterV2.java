package com.bytedance.android.window.shop.home.presenter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.window.base.utils.window.ECWindowShopLiveData;
import com.bytedance.android.ec.window.base.utils.window.IECFeedControllerPresenter;
import com.bytedance.android.ec.window.base.widget.ECWindowOverScrollExpandBehavior;
import com.bytedance.android.window.shop.home.ECWindowDialogFragment;
import com.bytedance.android.window.shop.home.header.WindowHeaderFragment;
import com.bytedance.android.window.shop.repository.header.utils.WindowHeaderStrategy;
import com.gyf.barlibrary.ImmersionBar;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0004\u001a\u00020\u0003H\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/window/shop/home/presenter/ECWindowCroppedStyleRootPresenterV2;", "Lcom/bytedance/android/window/shop/home/presenter/AbsECWindowPresenter;", "Landroidx/lifecycle/LifecycleObserver;", "", "onStop", "<init>", "()V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowCroppedStyleRootPresenterV2 extends AbsECWindowPresenter implements LifecycleObserver {
    public static final /* synthetic */ int r = 0;
    public final a m;
    public final Lazy n;
    public final c o;
    public ImmersionBar p;
    public final Lazy q;

    public final class a extends IECFeedControllerPresenter {
        public final /* synthetic */ ECWindowCroppedStyleRootPresenterV2 d;

        public final Context b() {
            ECWindowCroppedStyleRootPresenterV2 r0 = this.d;
            int r1 = ECWindowCroppedStyleRootPresenterV2.r;
            return r0.u().c();
        }

        public final ECWindowShopLiveData c() {
            return this.d.O().getCroppedState();
        }

        public final LifecycleOwner d() {
            return this.d.U();
        }

        public final boolean e() {
            return this.d.Q();
        }

        public final boolean f() {
            return this.d.T();
        }

        public a(ECWindowCroppedStyleRootPresenterV2 r1) {
            this.d = r1;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ ECWindowCroppedStyleRootPresenterV2 a;

        public b(ECWindowCroppedStyleRootPresenterV2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.D();
        }
    }

    public static final class c implements ECWindowOverScrollExpandBehavior.c {
        public final /* synthetic */ ECWindowCroppedStyleRootPresenterV2 a;

        public final void b() {
        }

        public final boolean d() {
            return true;
        }

        public final long f() {
            return 200;
        }

        public final int a() {
            return this.a.G() / 2;
        }

        public final void e() {
            this.a.D();
        }

        public c(ECWindowCroppedStyleRootPresenterV2 r1) {
            this.a = r1;
        }

        public final void c(int r2) {
            this.a.O().getPullOffset().setValue(Integer.valueOf(r2));
        }

        public final void onRelease(int r3) {
            if (r3 <= ((int) (this.a.G() * 1.35f))) goto L6;
            this.a.D();
            return;
        }
    }

    public final void C() {
        a r0 = this.m;
        r0.c().removeObserver((Observer) ((IECFeedControllerPresenter) r0).b.getValue());
        r0.d().getLifecycle().removeObserver((LifecycleEventObserver) ((IECFeedControllerPresenter) r0).c.getValue());
        U().getLifecycle().removeObserver(this);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        ImmersionBar r2 = this.p;     // Catch: Throwable -> L9
        if (r2 == null) goto L6;
        r2.destroy();     // Catch: Throwable -> L9
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Result.constructor-impl(r3);     // Catch: Throwable -> L9
    L11:
        this.p = null;
        return;
    L6:
        r3 = null;
    L9:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public ECWindowCroppedStyleRootPresenterV2() {
        this.m = new a(this);
        this.n = LazyKt.lazy(new ECWindowCroppedStyleRootPresenterV2$doDragShowFullShopWindowEventReportOnce$2(this));
        this.o = new c(this);
        this.q = LazyKt.lazy(new ECWindowCroppedStyleRootPresenterV2$slideNoticeView$2(this));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        boolean r0 = O().getShopParam().getStatusBarDarkFont();
        QContext r1 = u();
        Activity r2 = com.bytedance.android.ec.core.utils.l0.c(r1.c());
        if ((r2 instanceof FragmentActivity) == true) goto L5;
        r2 = null;
    L5:
        if (r2 != null) goto L7;
        r2 = r1.a();
    L7:
        int r3 = com.bytedance.android.ec.core.utils.y1.a;
        com.bytedance.android.ec.core.utils.y1.c(r2, r2.getWindow(), r0);
    }

    public final void A(QModel r5) {
        this.m.a();
        w().b(2131370890).f().setOnTouchListener(new z());
        w().b(2131370890).g(4);
        O().getHeaderResponse().a(U(), new a0(this), true);
        O().getHeaderResponse().a(U(), new b0(this), true);
        O().getOffsetState().a(U(), new c0(this), false);
        O().getCroppedState().observe(U(), new y(this));
        Fragment r6 = ECQuickUtilKt.b(u(), ECWindowDialogFragment.class);
        ECWindowOverScrollExpandBehavior r1 = null;
        if ((r6 instanceof DialogFragment) == true) goto L5;
        r6 = null;
    L5:
        DialogFragment r7 = (DialogFragment) r6;
        if (r7 != null) goto L79;
    L15:
        View r8 = y().findViewById(2131371106);
        if (r8 == null) goto L18;
        r8.setVisibility(0);
        r8.setOnClickListener(new b(this));
    L18:
        View r9 = y();
    L19:
        if (r9 == null) goto L27;
        View r0 = com.bytedance.android.ec.window.base.utils.c.a(X(), ECWindowCroppedStyleRootPresenterV2$setupOverScrollController$owner$1.INSTANCE);
        if (r0 != null) goto L22;
        Object r10 = r9.getParent();
        if ((r10 instanceof View) == true) goto L26;
        r10 = null;
    L26:
        r9 = (View) r10;
        goto L19
    L22:
        r9 = r0;
    L27:
        if (r9 == null) goto L29;
        ViewGroup.LayoutParams r11 = r9.getLayoutParams();
    L31:
        if ((r11 instanceof CoordinatorLayout.LayoutParams) == true) goto L33;
        r11 = null;
    L33:
        CoordinatorLayout.LayoutParams r12 = (CoordinatorLayout.LayoutParams) r11;
        if (r12 == null) goto L42;
        ECWindowOverScrollExpandBehavior r13 = r12.getBehavior();
        if (r13 == null) goto L42;
        if ((r13 instanceof ECWindowOverScrollExpandBehavior) == false) goto L40;
        r1 = r13;
    L40:
        if (r1 == null) goto L42;
        r1.setExpandController(this.o);
    L42:
        U().getLifecycle().addObserver(this);
        ECWindowDialogFragment r14 = ECQuickUtilKt.b(u(), ECWindowDialogFragment.class);
        if (r14 == null) goto L54;
        FragmentManager r15 = r14.getChildFragmentManager();
        if (r15 == null) goto L54;
        FragmentTransaction r16 = r15.beginTransaction();
        if (r16 == null) goto L54;
        WindowHeaderFragment r2 = new WindowHeaderFragment();
        String r3 = String.valueOf(WindowHeaderStrategy.ONLY_SHOW_IN_FULLSCREEN.getStrategy());
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r16, r2, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, r3, 2131371270) == true) goto L52;
        r16 = r16.replace(2131371270, r2, r3);
    L52:
        if (r16 == null) goto L54;
        r16.commit();
    L54:
        ECWindowDialogFragment r17 = ECQuickUtilKt.b(u(), ECWindowDialogFragment.class);
        if (r17 == null) goto L66;
        FragmentManager r18 = r17.getChildFragmentManager();
        if (r18 == null) goto L66;
        FragmentTransaction r19 = r18.beginTransaction();
        if (r19 == null) goto L66;
        WindowHeaderFragment r4 = new WindowHeaderFragment();
        String r20 = String.valueOf(WindowHeaderStrategy.ONLY_SHOW_IN_SPLIT.getStrategy());
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r19, r4, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, r20, 2131370889) == true) goto L64;
        r19 = r19.replace(2131370889, r4, r20);
    L64:
        if (r19 == null) goto L66;
        r19.commit();
    L66:
        ECWindowDialogFragment r21 = ECQuickUtilKt.b(u(), ECWindowDialogFragment.class);
        if (r21 == null) goto L85;
        FragmentManager r22 = r21.getChildFragmentManager();
        if (r22 == null) goto L86;
        FragmentTransaction r23 = r22.beginTransaction();
        if (r23 == null) goto L87;
        WindowHeaderFragment r24 = new WindowHeaderFragment();
        String r25 = String.valueOf(WindowHeaderStrategy.ALWAYS_SHOWING.getStrategy());
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r23, r24, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, r25, 2131371262) == true) goto L76;
        r23 = r23.replace(2131371262, r24, r25);
    L76:
        if (r23 == null) goto L88;
        r23.commit();
        return;
    L88:
        return;
    L87:
        return;
    L86:
        return;
    L85:
        return;
    L29:
        r11 = null;
        goto L31
    L79:
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L9
        Object r27 = Result.constructor-impl(ImmersionBar.with(r7));     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r27) == false) goto L14;
        r27 = null;
    L14:
        this.p = (ImmersionBar) r27;
    L9:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r27 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }
}
