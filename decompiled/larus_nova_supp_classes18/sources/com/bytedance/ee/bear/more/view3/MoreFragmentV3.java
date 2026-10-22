package com.bytedance.ee.bear.more.view3;

import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.appsetting.downgrade.DowngradeSettingUtil;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LinearLayoutManagerWrapper;
import com.bytedance.ee.bear.more.protocol3.i;
import com.bytedance.ee.bear.more.protocol3.k;
import com.bytedance.ee.util.ui.n;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 52\u00020\u0001:\u000245B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\"\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0017H\u0016J\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u001cH\u0002J\b\u0010 \u001a\u00020\u001cH\u0002J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020\u001cH\u0002J\u0010\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020'H\u0002J\u0012\u0010(\u001a\u00020\u001c2\b\u0010)\u001a\u0004\u0018\u00010*H\u0002J\b\u0010+\u001a\u00020\u001cH\u0016J\b\u0010,\u001a\u00020\u0019H\u0016J\u0010\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020\u001cH\u0002J\b\u00101\u001a\u00020\u001cH\u0002J\b\u00102\u001a\u00020\u001cH\u0002J\b\u00103\u001a\u00020\u001cH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u00101\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/bytedance/ee/bear/more/view3/MoreFragmentV3;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseBottomSheetDialogFragment;", "<init>", "()V", "viewModel", "Lcom/bytedance/ee/bear/more/view3/MoreViewModelV3;", "moreAdapter", "Lcom/bytedance/ee/bear/more/view3/MoreAdapter;", "getMoreAdapter", "()Lcom/bytedance/ee/bear/more/view3/MoreAdapter;", "moreAdapter$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAnimation", "Landroid/view/animation/Animation;", "transit", "", "enter", "", "nextAnim", "onViewCreated", "", "view", "onResume", "initView", "initGroups", "disableFlingSettle", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "bindView", "bindMoreList", "uiList", "Lcom/bytedance/ee/bear/more/protocol3/MoreUIList;", "bindFixedHeader", "header", "Lcom/bytedance/ee/bear/more/protocol3/UIMoreItem;", "onStart", "isSupportScreenLandscape", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "initPeekHeight", "initWatermark", "dismissStateLoss", "onDestroy", "MoreHostImpl", "Companion", "features-more_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MoreFragmentV3 extends BaseBottomSheetDialogFragment {
    public static final /* synthetic */ int n = 0;
    public MoreViewModelV3 k;
    public final Lazy l;
    public boolean m;

    public static final class a {
    }

    public final class b implements sj5.b {
        public final /* synthetic */ MoreFragmentV3 a;

        @Override // sj5.b
        public final void a() {
            MoreFragmentV3 r0 = this.a;
            int r1 = MoreFragmentV3.n;
            r0.getClass();
        L13:
            th = move-exception;
            tt5.a.f("MoreFragmentV3", th, false);
            iu5.d.a("MoreFragmentV3_dismissIgnoreErr()", th);
            return;
        L4:
            if (r0.isAdded() == true) goto L19;
            tt5.a.d("MoreFragmentV3", "fragment is not add");     // Catch: Throwable -> L13
        L16:
            return;
        L19:
            r0.dismissAllowingStateLoss();     // Catch: Exception -> L7 Throwable -> L13
        L7:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L13
            Throwable r2 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L13
            if (r2 == null) goto L16;
            com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
            goto L16
        }

        @Override // sj5.b
        public final boolean isShowing() {
            if (ForsetiHelper.s(this.a) == true) goto L10;
            Dialog r0 = this.a.getDialog();
            if (r0 != null) goto L11;
            return false;
        L11:
            return r0.isShowing();
        L10:
            return this.a.isAdded();
        }

        @Override // sj5.b
        public final MoreFragmentV3 getHostFragment() {
            return this.a;
        }

        public b(MoreFragmentV3 r1) {
            this.a = r1;
        }
    }

    static {
    }

    public MoreFragmentV3() {
        this.l = LazyKt.lazy(MoreFragmentV3$moreAdapter$2.INSTANCE);
    }

    public final boolean ba0() {
        return !ku5.c.k(getActivity());
    }

    public final void fa0() {
        Dialog r0 = getDialog();     // Catch: Throwable -> L18
        if (r0 == null) goto L11;
        Window r1 = r0.getWindow();     // Catch: Throwable -> L18
        if (r1 == null) goto L11;
        View r2 = da0(r1);     // Catch: Throwable -> L18
        if (r2 == null) goto L11;
        FrameLayout r3 = (FrameLayout) r2.findViewById(2131368870);     // Catch: Throwable -> L18
        if (r3 == null) goto L11;
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();     // Catch: Throwable -> L18
    L13:
        if ((r4 instanceof CoordinatorLayout.LayoutParams) == false) goto L23;
        BottomSheetBehavior r5 = ((CoordinatorLayout.LayoutParams) r4).getBehavior();     // Catch: Throwable -> L18
        if ((r5 instanceof BottomSheetBehavior) == false) goto L24;
        r5.setPeekHeight((int) (n.t() * 0.75f));     // Catch: Throwable -> L18
        return;
    L24:
        return;
    L23:
        return;
    L11:
        r4 = null;
    L18:
        th = move-exception;
        tt5.a.e("MoreFragmentV3", "init peek height", th, false);
    }

    public final void onDestroy() {
        super.onDestroy();
        tt5.a.h("MoreFragmentV3", "onDestroy.");
        MoreViewModelV3 r0 = this.k;
        if (r0 == null) goto L6;
        r0.release();
        return;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        StringBuilder r0 = new StringBuilder("onResume layerType: ");
        View r1 = getView();
        if (r1 == null) goto L5;
        Integer r2 = Integer.valueOf(r1.getLayerType());
    L6:
        r0.append(r2);
        tt5.a.h("MoreFragmentV3", r0.toString());
        if (ForsetiHelper.s(this) == false) goto L12;
        View r3 = getView();
        if (r3 == null) goto L13;
        r3.setLayerType(2, null);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        tt5.a.h("MoreFragmentV3", "onStart");
        super.onStart();
        fa0();
    }

    public static View da0(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public final void ea0(k r8) {
        View r0 = getView();
        if (r0 == null) goto L25;
        FrameLayout r1 = (FrameLayout) r0.findViewById(2131380288);
        if (r1 == null) goto L26;
        if (r8 != null) goto L10;
        r1.setVisibility(8);
        r1.removeAllViews();
        return;
    L10:
        r1.setVisibility(0);
        int r3 = r8.e();
        View r2 = r1.getChildAt(0);
        Integer r4 = null;
        if (r2 == null) goto L13;
        Object r5 = r2.getTag(2131380288);
    L15:
        if ((r5 instanceof Integer) == false) goto L17;
        r4 = (Integer) r5;
    L17:
        if (r2 == null) goto L22;
        if (r4 == null) goto L22;
        if (r4.intValue() != r3) goto L22;
    L23:
        r8.a(r2);
        return;
    L22:
        r1.removeAllViews();
        r2 = r8.c(r1);
        r2.setTag(2131380288, Integer.valueOf(r3));
        r1.addView(r2);
        goto L23
    L13:
        r5 = null;
        goto L15
    L26:
        return;
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super.onConfigurationChanged(r2);
        fa0();
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment*/.onViewCreated(r2, r3);
        if (ForsetiHelper.s(this) == false) goto L5;
        r2.setLayerType(1, null);
    L5:
        this.k = (MoreViewModelV3) ViewModelProviders.of(requireActivity()).get(MoreViewModelV3.class);
        View r4 = getView();
        if (r4 == null) goto L15;
        final RecyclerView r5 = r4.findViewById(2131380287);
        if (r5 == null) goto L15;
        r5.setAdapter((MoreAdapter) this.l.getValue());
        r5.setLayoutManager(new LinearLayoutManagerWrapper(getContext()));
        if (DowngradeSettingUtil.a("downgradeMoreDisableFling") == true) goto L15;
        if (r5.getOnFlingListener() == null) goto L14;
        tt5.a.h("MoreFragmentV3", "skip disableFlingSettle because onFlingListener already exists");
        goto L15
    L14:
        r5.setOnFlingListener(new MoreFragmentV3$disableFlingSettle$1(r5));
    L15:
        MoreViewModelV3 r6 = this.k;
        if (r6 == null) goto L18;
        r6.create(new b(this));
    L18:
        MoreViewModelV3 r7 = this.k;
        if (r7 == null) goto L23;
        LiveData<i> r8 = r7.getMoreUIList();
        if (r8 == null) goto L23;
        r8.observe(this, new com.bytedance.ee.bear.more.view3.a(this));
    L23:
        MoreViewModelV3 r9 = this.k;
        if (r9 == null) goto L29;
        LiveData<k> r10 = r9.getChangedUIItem();
        if (r10 == null) goto L30;
        r10.observe(this, new com.bytedance.ee.bear.more.view3.b(this));
        return;
    L30:
        return;
    }

    public final Animation onCreateAnimation(int r3, boolean r4, int r5) {
        tt5.a.h("MoreFragmentV3", "onCreateAnimation()... transit: " + r3 + ", enter: " + r4 + ", nextAnim: " + r5);
        if (r3 != 4097) goto L7;
        if (r4 == true) goto L6;
        return null;
    L6:
        return AnimationUtils.loadAnimation(requireContext(), 2130772201);
    L7:
        return null;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131563694, r3, false);
    }
}
