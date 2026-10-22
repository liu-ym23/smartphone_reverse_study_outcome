package com.larus.common_ui.photoviewer;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.common_ui.photoviewer.transition.TransitionPagerAdapter;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import j19.d;
import j19.g;
import j19.k;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010<\u001a\u00020=2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007J\b\u0010>\u001a\u00020=H\u0002J\u0010\u0010?\u001a\u00020=2\u0006\u0010\u0018\u001a\u00020@H\u0002J\u000e\u0010A\u001a\u00020=2\u0006\u00101\u001a\u00020*J\b\u0010B\u001a\u00020=H\u0016J\b\u0010C\u001a\u00020=H\u0016J\b\u0010D\u001a\u00020\u001fH\u0016J\u0010\u0010E\u001a\u00020=2\u0006\u0010F\u001a\u00020\u001fH\u0002J\u0018\u0010G\u001a\u00020=2\u0006\u0010F\u001a\u00020\u001f2\u0006\u0010H\u001a\u00020$H\u0002J&\u0010I\u001a\u0004\u0018\u00010@2\u0006\u0010J\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010M2\b\u0010N\u001a\u0004\u0018\u00010OH\u0016J\b\u0010P\u001a\u00020=H\u0016J\b\u0010Q\u001a\u00020=H\u0016J\b\u0010R\u001a\u00020=H\u0002J.\u0010S\u001a\u00020=2\n\b\u0002\u0010T\u001a\u0004\u0018\u00010U2\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020YH\u0002J\u0016\u0010Z\u001a\u00020=2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020YJ,\u0010S\u001a\u00020=2\b\u0010[\u001a\u0004\u0018\u00010@2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020Y2\b\u0010/\u001a\u0004\u0018\u000100H\u0002J:\u0010S\u001a\u00020=2\u0006\u0010\\\u001a\u00020\u001f2\b\u0010[\u001a\u0004\u0018\u00010@2\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u0010]\u001a\u00020$2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020YJ\b\u0010^\u001a\u00020=H\u0016J\u0018\u0010_\u001a\u00020=2\u0006\u0010F\u001a\u00020\u001f2\u0006\u0010H\u001a\u00020$H\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010%\u001a\u0012\u0012\u0004\u0012\u00020'0&j\b\u0012\u0004\u0012\u00020'`(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R(\u00103\u001a\u0004\u0018\u0001022\b\u0010\b\u001a\u0004\u0018\u000102@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u00108\u001a\u00020$2\u0006\u0010\b\u001a\u00020$@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;¨\u0006`"}, d2 = {"Lcom/larus/common_ui/photoviewer/PhotoViewerDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Lcom/larus/common_ui/photoviewer/OnPageSelectedListener;", "Landroidx/lifecycle/LifecycleObserver;", "<init>", "()V", "transitionAdapter", "Lcom/larus/common_ui/photoviewer/transition/TransitionPagerAdapter;", "value", "Landroidx/recyclerview/widget/RecyclerView;", "pager", "getPager", "()Landroidx/recyclerview/widget/RecyclerView;", "onPageSelectedListener", "getOnPageSelectedListener", "()Lcom/larus/common_ui/photoviewer/OnPageSelectedListener;", "setOnPageSelectedListener", "(Lcom/larus/common_ui/photoviewer/OnPageSelectedListener;)V", "onDismissListener", "Lcom/larus/common_ui/photoviewer/OnDismissListener;", "getOnDismissListener", "()Lcom/larus/common_ui/photoviewer/OnDismissListener;", "setOnDismissListener", "(Lcom/larus/common_ui/photoviewer/OnDismissListener;)V", "rootContainer", "Landroid/widget/FrameLayout;", "getRootContainer", "()Landroid/widget/FrameLayout;", "setRootContainer", "(Landroid/widget/FrameLayout;)V", "currentPos", "", "getCurrentPos", "()I", "_currentPos", "isAnimatedShow", "", "indicatorViews", "Ljava/util/ArrayList;", "Lcom/larus/common_ui/photoviewer/IIndicatorView;", "Lkotlin/collections/ArrayList;", "backgroundAlphaFactor", "", "backgroundAlphaFactorWhenDragEnd", "orientationHelper", "Landroidx/recyclerview/widget/OrientationHelper;", "isUserScrolling", "endViewInfo", "Lcom/larus/common_ui/photoviewer/transition/TransitionEndViewInfo;", "pagerMargin", "Lcom/larus/common_ui/photoviewer/IRestoreTransitionProvider;", "restoreTransitionProvider", "getRestoreTransitionProvider", "()Lcom/larus/common_ui/photoviewer/IRestoreTransitionProvider;", "setRestoreTransitionProvider", "(Lcom/larus/common_ui/photoviewer/IRestoreTransitionProvider;)V", "isInfinityLoop", "()Z", "setInfinityLoop", "(Z)V", "setTransitionAdapter", "", "updateLayoutManager", "initAdapter", "Landroid/view/View;", "setPagerMargin", "onEnterTransitionStart", "onEnterTransitionEnd", "getBottomMargin", "dispatchOnPageUnSelected", ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION, "dispatchOnPageSelected", "byScroll", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", LiveCommonConstants.REASON_ON_DEDTROY, WidgetCostModule.TYPE_ON_START, "makeNavigateBarTransparent", "showAnimated", "startRect", "Landroid/graphics/Rect;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "tag", "", "showSafely", "view", "position", "enableRestoreTransition", "dismiss", "setCurrentPos", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class PhotoViewerDialogFragment extends DialogFragment implements g, LifecycleObserver {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TransitionPagerAdapter<?> f327641d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RecyclerView f327642e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g f327643f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FrameLayout f327644g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f327645h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f327646i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList<d> f327647j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f327648k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f327649l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public OrientationHelper f327650m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f327651n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f327652o;

    @Override // j19.g
    public final void S80(int r100) {
    }

    public void U90() {
    }

    public void V90() {
    }

    @Override // j19.g
    public final void onPageSelected(int r100) {
    }

    @Override // j19.g
    public final void onPageSelected(int r100, boolean r101) {
    }

    public final FrameLayout T90() {
        FrameLayout r100 = this.f327644g;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
        return null;
    }

    public PhotoViewerDialogFragment() {
        this.f327645h = -1;
        this.f327647j = new ArrayList();
        this.f327648k = 1.0f;
        this.f327649l = 1.0f;
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void dismiss() {
        if (isAdded() == true) goto L12;
        FLogger.f375446a.w("PhotoViewerDialogFragment", "dismiss abort, not added");
        return;
    L12:
        super.dismissAllowingStateLoss();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r100 = DialogFragmentLancet.sLastShowStack;
        if (r100 == null) goto L14;
        com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Context r100 = getContext();
        if ((r100 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r101 = (FragmentActivity) r100;
    L6:
        if (r101 == null) goto L11;
        Lifecycle r102 = r101.getLifecycle();
        if (r102 == null) goto L12;
        r102.removeObserver(this);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r100 = getDialog();
        if (r100 == null) goto L17;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L18;
        WindowManager.LayoutParams r102 = r101.getAttributes();
        r101.setLayout(-1, -1);
        r101.setBackgroundDrawable(new ColorDrawable(0));
        r101.clearFlags(2);
        r101.setSoftInputMode(48);
        S90(r101).setPadding(0, 0, 0, 0);
        int r103 = Build.VERSION.SDK_INT;
        r101.addFlags(Integer.MIN_VALUE);
        S90(r101).setSystemUiVisibility(1280);
        if (r103 <= 28) goto L10;
        if (r102 == null) goto L10;
        r102.layoutInDisplayCutoutMode = 1;
    L10:
        Dialog r104 = getDialog();
        if (r104 == null) goto L19;
        Window r105 = r104.getWindow();
        if (r105 == null) goto L20;
        r105.setNavigationBarColor(0);
        r105.addFlags(AMapEngineUtils.HALF_MAX_P20_WIDTH);
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    }

    public static View S90(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public final void W90(FragmentManager r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "fragmentManager");
        Intrinsics.checkNotNullParameter(r101, "tag");
        if (isAdded() == false) goto L5;
    L13:
        FLogger.f375446a.w("PhotoViewerDialogFragment", "show abort, tag:" + r101);
        return;
    L5:
        if (r100.isStateSaved() == true) goto L13;
        LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r101, r102);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r100, this, r102) == true) goto L18;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L15
    L11:
        show(r100, r101);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Context r103 = requireContext();
        FrameLayout r104 = new FrameLayout(r103);
        r104.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        this.f327644g = r104;
        RecyclerView r105 = new RecyclerView(r103);
        r105.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f327642e = r105;
        new PagerSnapHelper().attachToRecyclerView(this.f327642e);
        T90().addView(this.f327642e, 0);
        RecyclerView r106 = this.f327642e;
        if (r106 == null) goto L5;
        r106.addOnScrollListener(new AnonymousClass3(this));
    L5:
        FrameLayout r107 = T90();
        RecyclerView r108 = this.f327642e;
        if (r108 == null) goto L8;
        r108.setAdapter(this.f327641d);
    L8:
        TransitionPagerAdapter<?> r109 = this.f327641d;
        if (r109 == null) goto L11;
        k r110 = new k(this, r107);
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        r109.f327749b = r110;
    L11:
        TransitionPagerAdapter<?> r111 = this.f327641d;
        if (r111 == null) goto L14;
        r111.registerAdapterDataObserver(new PhotoViewerDialogFragment$initAdapter$2());
    L14:
        RecyclerView.LayoutManager r112 = null;
        if ((r103 instanceof FragmentActivity) == false) goto L17;
        FragmentActivity r113 = (FragmentActivity) r103;
    L18:
        if (r113 == null) goto L22;
        Lifecycle r114 = r113.getLifecycle();
        if (r114 == null) goto L22;
        r114.addObserver(this);
    L22:
        RecyclerView r115 = this.f327642e;
        if (r115 == null) goto L25;
        LinearLayoutManager r116 = new LinearLayoutManager(requireContext());
        r116.setOrientation(0);
        r115.setLayoutManager(r116);
    L25:
        RecyclerView r117 = this.f327642e;
        if (r117 == null) goto L28;
        r112 = r117.getLayoutManager();
    L28:
        this.f327650m = OrientationHelper.createHorizontalHelper(r112);
        Dialog r118 = getDialog();
        if (r118 == null) goto L33;
        Window r119 = r118.getWindow();
        if (r119 == null) goto L33;
        r119.requestFeature(1);
    L33:
        T90().setBackgroundColor(-16777216);
        if (this.f327646i == false) goto L37;
        V90();
        T90().getBackground().setAlpha(0);
        this.f327648k = 0.0f;
    L37:
        return T90();
    L17:
        r113 = null;
        goto L18
    }
}
