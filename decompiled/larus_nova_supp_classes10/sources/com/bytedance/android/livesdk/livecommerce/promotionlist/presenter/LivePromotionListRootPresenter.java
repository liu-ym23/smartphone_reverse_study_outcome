package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.Toggle;
import com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.LivePromotionListViewModel;
import com.bytedance.android.livesdk.livecommerce.promotionlist.widget.LivePromotionListTopTabLayout;
import com.bytedance.android.ui.base.widget.tablayout.ECTabLayout;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LivePromotionListRootPresenter extends com.bytedance.android.livesdk.livecommerce.promotionlist.base.a {
    public static final /* synthetic */ int t = 0;
    public ViewPager j;
    public LivePromotionListTopTabLayout k;
    public View l;
    public boolean m;
    public boolean n;
    public LivePromotionListViewModel o;
    public QUIManager p;
    public nj2.a q;
    public LivePromotionListRootPresenter$getOnPageChangeListener$1 r;
    public Toggle s;

    public static final class a {
    }

    static {
    }

    public final void h0() {
        LivePromotionListRootPresenter$getOnPageChangeListener$1 r0 = this.r;
        if (r0 == null) goto L8;
        ViewPager r1 = this.j;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L7:
        r1.removeOnPageChangeListener(r0);
    L8:
        this.r = null;
        QUIManager r2 = this.p;
        if (r2 == null) goto L11;
        r2.r(nj2.a.class);
    L11:
        this.p = null;
        LivePromotionListViewModel r3 = this.o;
        if (r3 == null) goto L14;
        r3.onDestroy();
    L14:
        this.o = null;
        d0().setSecondViewModel(null);
        this.q = null;
        this.n = false;
        this.m = false;
        this.s = null;
    }

    public final View j0() {
        QUIManager r0 = this.p;
        if (r0 != null) goto L5;
        Context r1 = Y().c();
        View r2 = a0();
        if (r2 == null) goto L43;
        final View r3 = th.a.c(r1, 2131564727, (ViewGroup) r2, false);
        QViewModelOwner r4 = Y().d().i();
        if (r4 != null) goto L11;
    L41:
        return r3;
    L11:
        if (this.p != null) goto L14;
        this.p = new QUIManager();
    L14:
        if (this.q != null) goto L17;
        this.q = new nj2.a(r3, r4, true, "live_list_second_view_model");
    L17:
        if (this.o != null) goto L27;
        LivePromotionListViewModel r5 = new ViewModelProvider(r4.getViewModelStore(), r4.o6()).get("live_list_second_view_model", LivePromotionListViewModel.class);
        this.o = r5;
        if (r5 == null) goto L22;
        r5.setGetCurrentTab(new LivePromotionListRootPresenter$getSecondView$$inlined$also$lambda$1(this, r3));
    L22:
        if (d0().isInSplitScreen() == false) goto L26;
        LivePromotionListViewModel r6 = this.o;
        if (r6 == null) goto L26;
        r6.setInSplitScreen(d0().isInSplitScreen());
    L26:
        d0().setSecondViewModel(this.o);
    L27:
        nj2.a r7 = this.q;
        if (r7 == null) goto L32;
        QUIManager r8 = this.p;
        if (r8 == null) goto L32;
        r8.l(r7, r4.requireContext(), true);
    L32:
        QUIManager r9 = this.p;
        if (r9 == null) goto L35;
        r9.a = r4;
    L35:
        LivePromotionListViewModel r10 = this.o;
        if (r10 == null) goto L38;
        r10.setForceHideTopModule(true);
    L38:
        LivePromotionListViewModel r11 = this.o;
        if (r11 == null) goto L41;
        r11.setDefaultTab(false);
        goto L41
    L43:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L5:
        return r0.p();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.base.a
    public final void c0() {
        h0();
        super.c0();
        s0.e(this);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.base.a
    public final void e0() {
        this.j = Z().b(2131392857).f();
        this.k = (LivePromotionListTopTabLayout) Z().b(2131388934).f();
        LifecycleOwner r0 = ECQuickUtilKt.a(Y());
        com.bytedance.android.ec.core.arch.state.c.a(d0(), r0, LivePromotionListRootPresenter$init$1.INSTANCE, new LivePromotionListRootPresenter$init$2(this));
        com.bytedance.android.ec.core.arch.event.c.c(d0(), r0, Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.f0.class), new LivePromotionListRootPresenter$init$3(this));
        s0.c(this);
    }

    public LivePromotionListRootPresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2, null);
    }

    public final void i0(boolean r4) {
        if (r4 == true) goto L5;
    L7:
        boolean r5 = false;
    L8:
        d0().setForceHideTopModule(!r5);
        if (r5 == false) goto L11;
        Y().d().c(nj2.f.class, null);
        Y().d().q(nj2.f.class, 0);
        return;
    L11:
        Y().d().r(nj2.f.class);
        Y().d().q(nj2.f.class, 8);
        return;
    L5:
        if (d0().disableUpdateInteractionData() == true) goto L7;
        r5 = true;
        goto L8
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onReceiveTopFragmentStatusChanged(wk.b r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (this.m == false) goto L15;
        ECTabLayout.BaseOnTabSelectedListener r3 = this.k;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    L8:
        if (r3.getVisibility() != 0) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == true) goto L14;
        return;
    L14:
        throw null;
    L10:
        r4 = false;
        goto L11
    }
}
