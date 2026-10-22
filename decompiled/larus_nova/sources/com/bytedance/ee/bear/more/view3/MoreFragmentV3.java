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
import com.bytedance.ai.api.navi.AppletNaviType;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.appsetting.downgrade.DowngradeSettingUtil;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LinearLayoutManagerWrapper;
import com.bytedance.ee.bear.more.protocol3.i;
import com.bytedance.ee.bear.more.protocol3.k;
import com.bytedance.ee.util.ui.n;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 52\u00020\u0001:\u000245B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\"\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0017H\u0016J\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u001cH\u0002J\b\u0010 \u001a\u00020\u001cH\u0002J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020\u001cH\u0002J\u0010\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020'H\u0002J\u0012\u0010(\u001a\u00020\u001c2\b\u0010)\u001a\u0004\u0018\u00010*H\u0002J\b\u0010+\u001a\u00020\u001cH\u0016J\b\u0010,\u001a\u00020\u0019H\u0016J\u0010\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020\u001cH\u0002J\b\u00101\u001a\u00020\u001cH\u0002J\b\u00102\u001a\u00020\u001cH\u0002J\b\u00103\u001a\u00020\u001cH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u00101\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/bytedance/ee/bear/more/view3/MoreFragmentV3;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseBottomSheetDialogFragment;", "<init>", "()V", "viewModel", "Lcom/bytedance/ee/bear/more/view3/MoreViewModelV3;", "moreAdapter", "Lcom/bytedance/ee/bear/more/view3/MoreAdapter;", "getMoreAdapter", "()Lcom/bytedance/ee/bear/more/view3/MoreAdapter;", "moreAdapter$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAnimation", "Landroid/view/animation/Animation;", AppletNaviType.TRANSIT, "", "enter", "", "nextAnim", "onViewCreated", "", "view", "onResume", "initView", "initGroups", "disableFlingSettle", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "bindView", "bindMoreList", "uiList", "Lcom/bytedance/ee/bear/more/protocol3/MoreUIList;", "bindFixedHeader", "header", "Lcom/bytedance/ee/bear/more/protocol3/UIMoreItem;", WidgetCostModule.TYPE_ON_START, "isSupportScreenLandscape", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "initPeekHeight", "initWatermark", "dismissStateLoss", LiveCommonConstants.REASON_ON_DEDTROY, "MoreHostImpl", "Companion", "features-more_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MoreFragmentV3 extends BaseBottomSheetDialogFragment {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f235014n = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public MoreViewModelV3 f235015k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f235016l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f235017m;

    public static final class a {
    }

    public final class b implements sj5.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MoreFragmentV3 f235018a;

        @Override // sj5.b
        public final void a() {
            MoreFragmentV3 r100 = this.f235018a;
            int r101 = MoreFragmentV3.f235014n;
            r100.getClass();
        L13:
            th = move-exception;
            tt5.a.f("MoreFragmentV3", th, false);
            iu5.d.a("MoreFragmentV3_dismissIgnoreErr()", th);
            return;
        L4:
            if (r100.isAdded() == true) goto L19;
            tt5.a.d("MoreFragmentV3", "fragment is not add");     // Catch: Throwable -> L13
        L16:
            return;
        L19:
            r100.dismissAllowingStateLoss();     // Catch: Exception -> L7 Throwable -> L13
        L7:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L13
            Throwable r102 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L13
            if (r102 == null) goto L16;
            com.bytedance.crash.d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
            goto L16
        }

        @Override // sj5.b
        public final boolean isShowing() {
            if (ForsetiHelper.s(this.f235018a) == true) goto L10;
            Dialog r100 = this.f235018a.getDialog();
            if (r100 != null) goto L11;
            return false;
        L11:
            return r100.isShowing();
        L10:
            return this.f235018a.isAdded();
        }

        @Override // sj5.b
        public final MoreFragmentV3 getHostFragment() {
            return this.f235018a;
        }

        public b(MoreFragmentV3 r100) {
            this.f235018a = r100;
        }
    }

    static {
    }

    public MoreFragmentV3() {
        this.f235016l = LazyKt.lazy(MoreFragmentV3$moreAdapter$2.INSTANCE);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment
    public final boolean ba0() {
        return !ku5.c.k(getActivity());
    }

    public final void fa0() {
        Dialog r100 = getDialog();     // Catch: Throwable -> L18
        if (r100 == null) goto L11;
        Window r101 = r100.getWindow();     // Catch: Throwable -> L18
        if (r101 == null) goto L11;
        View r102 = da0(r101);     // Catch: Throwable -> L18
        if (r102 == null) goto L11;
        FrameLayout r103 = (FrameLayout) r102.findViewById(R.id.design_bottom_sheet);     // Catch: Throwable -> L18
        if (r103 == null) goto L11;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();     // Catch: Throwable -> L18
    L13:
        if ((r104 instanceof CoordinatorLayout.LayoutParams) == false) goto L23;
        CoordinatorLayout.Behavior r105 = ((CoordinatorLayout.LayoutParams) r104).getBehavior();     // Catch: Throwable -> L18
        if ((r105 instanceof BottomSheetBehavior) == false) goto L24;
        ((BottomSheetBehavior) r105).setPeekHeight((int) (n.t() * 0.75f));     // Catch: Throwable -> L18
        return;
    L24:
        return;
    L23:
        return;
    L11:
        r104 = null;
    L18:
        th = move-exception;
        tt5.a.e("MoreFragmentV3", "init peek height", th, false);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        tt5.a.h("MoreFragmentV3", "onDestroy.");
        MoreViewModelV3 r100 = this.f235015k;
        if (r100 == null) goto L6;
        r100.release();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        StringBuilder r100 = new StringBuilder("onResume layerType: ");
        View r101 = getView();
        if (r101 == null) goto L5;
        Integer r102 = Integer.valueOf(r101.getLayerType());
    L6:
        r100.append(r102);
        tt5.a.h("MoreFragmentV3", r100.toString());
        if (ForsetiHelper.s(this) == false) goto L12;
        View r103 = getView();
        if (r103 == null) goto L13;
        r103.setLayerType(2, null);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        tt5.a.h("MoreFragmentV3", WidgetCostModule.TYPE_ON_START);
        super.onStart();
        fa0();
    }

    public static View da0(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public final void ea0(k r100) {
        View r101 = getView();
        if (r101 == null) goto L25;
        FrameLayout r102 = (FrameLayout) r101.findViewById(R.id.moreFixedHeaderContainer);
        if (r102 == null) goto L26;
        if (r100 != null) goto L10;
        r102.setVisibility(8);
        r102.removeAllViews();
        return;
    L10:
        r102.setVisibility(0);
        int r103 = r100.e();
        View r104 = r102.getChildAt(0);
        Integer r105 = null;
        if (r104 == null) goto L13;
        Object r106 = r104.getTag(R.id.moreFixedHeaderContainer);
    L15:
        if ((r106 instanceof Integer) == false) goto L17;
        r105 = (Integer) r106;
    L17:
        if (r104 == null) goto L22;
        if (r105 == null) goto L22;
        if (r105.intValue() != r103) goto L22;
    L23:
        r100.a(r104);
        return;
    L22:
        r102.removeAllViews();
        r104 = r100.c(r102);
        r104.setTag(R.id.moreFixedHeaderContainer, Integer.valueOf(r103));
        r102.addView(r104);
        goto L23
    L13:
        r106 = null;
        goto L15
    L26:
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        fa0();
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        if (ForsetiHelper.s(this) == false) goto L5;
        r100.setLayerType(1, null);
    L5:
        this.f235015k = (MoreViewModelV3) ViewModelProviders.of(requireActivity()).get(MoreViewModelV3.class);
        View r102 = getView();
        if (r102 == null) goto L15;
        final RecyclerView r103 = (RecyclerView) r102.findViewById(R.id.moreContainer);
        if (r103 == null) goto L15;
        r103.setAdapter((MoreAdapter) this.f235016l.getValue());
        r103.setLayoutManager(new LinearLayoutManagerWrapper(getContext()));
        if (DowngradeSettingUtil.a("downgradeMoreDisableFling") == true) goto L15;
        if (r103.getOnFlingListener() == null) goto L14;
        tt5.a.h("MoreFragmentV3", "skip disableFlingSettle because onFlingListener already exists");
        goto L15
    L14:
        r103.setOnFlingListener(new MoreFragmentV3$disableFlingSettle$1(r103));
    L15:
        MoreViewModelV3 r104 = this.f235015k;
        if (r104 == null) goto L18;
        r104.create(new b(this));
    L18:
        MoreViewModelV3 r105 = this.f235015k;
        if (r105 == null) goto L23;
        LiveData<i> r106 = r105.getMoreUIList();
        if (r106 == null) goto L23;
        r106.observe(this, new com.bytedance.ee.bear.more.view3.a(this));
    L23:
        MoreViewModelV3 r107 = this.f235015k;
        if (r107 == null) goto L29;
        LiveData<k> r108 = r107.getChangedUIItem();
        if (r108 == null) goto L30;
        r108.observe(this, new com.bytedance.ee.bear.more.view3.b(this));
        return;
    L30:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final Animation onCreateAnimation(int r100, boolean r101, int r102) {
        tt5.a.h("MoreFragmentV3", "onCreateAnimation()... transit: " + r100 + ", enter: " + r101 + ", nextAnim: " + r102);
        if (r100 != 4097) goto L7;
        if (r101 == true) goto L6;
        return null;
    L6:
        return AnimationUtils.loadAnimation(requireContext(), R.anim.dialog_in_from_bottom);
    L7:
        return null;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.more_v3_layout, r101, false);
    }
}
