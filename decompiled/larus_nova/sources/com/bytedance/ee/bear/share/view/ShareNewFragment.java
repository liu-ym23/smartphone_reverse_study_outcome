package com.bytedance.ee.bear.share.view;

import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment;
import com.bytedance.ee.bear.share.export.SharePanelState;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.bear.share.export.i;
import com.bytedance.ee.bear.share.externalshare.ShareScene;
import com.bytedance.ee.bear.share.newshare.d0;
import com.bytedance.ee.bear.share.newshare.e0;
import com.bytedance.ee.util.ui.n;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larksuite.framework.utils.DeviceUtils;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.lark.base.embedded.f;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import iu5.d;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ku5.c;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 32\u00020\u00012\u00020\u0002:\u000234B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0006\u0010\u001a\u001a\u00020\u0016J\u000e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0010J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u001e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010%\u001a\u00020\u0014H\u0016J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010\u0013\u001a\u00020\u0016H\u0002J\b\u0010)\u001a\u00020\u0016H\u0002J\b\u0010*\u001a\u00020\u0016H\u0016J\u0010\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u001eH\u0002J\b\u0010-\u001a\u00020\u0016H\u0002J\b\u0010.\u001a\u00020\u0016H\u0002J\b\u0010/\u001a\u00020\u0016H\u0016J\b\u00100\u001a\u00020\u0016H\u0016J\b\u00101\u001a\u000202H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/bytedance/ee/bear/share/view/ShareNewFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseBottomSheetDialogFragment;", "Lcom/bytedance/ee/bear/share/export/ISharePanel;", "<init>", "()V", "panelSession", "", "getPanelSession", "()Ljava/lang/String;", "params", "Lcom/bytedance/ee/bear/share/export/ShareParams;", "getParams", "()Lcom/bytedance/ee/bear/share/export/ShareParams;", "setParams", "(Lcom/bytedance/ee/bear/share/export/ShareParams;)V", "shareViewModel", "Lcom/bytedance/ee/bear/share/view/ShareViewModel;", "shareAdapter", "Lcom/bytedance/ee/bear/share/view/ShareAdapter;", "initWatermark", "", WidgetCostModule.TYPE_ON_START, "", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "initData", "setViewModel", "viewModel", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "isSupportScreenLandscape", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "initPeekHeight", "onResume", "initView", "rootView", "bindView", "dismissStateLoss", "onDestroyView", LiveCommonConstants.REASON_ON_DEDTROY, "buildShareItemModelParams", "Lcom/bytedance/ee/bear/share/externalshare/DocumentShareItemModelParams;", "Companion", "ShareHostImpl", "features-share-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareNewFragment extends BaseBottomSheetDialogFragment implements i {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f237273p = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f237274k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ShareParams f237275l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ShareViewModel f237276m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ShareAdapter f237277n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f237278o;

    public static final class a {
    }

    public final class b implements com.bytedance.ee.bear.share.newshare.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShareNewFragment f237279a;

        @Override // com.bytedance.ee.bear.share.newshare.b
        public final void a() {
            ShareNewFragment r100 = this.f237279a;
            int r101 = ShareNewFragment.f237273p;
            r100.getClass();
        L13:
            th = move-exception;
            tt5.a.f("ShareNewFragment", th, false);
            d.a("ShareNewFragment_dismissIgnoreErr()", th);
            return;
        L4:
            if (r100.isAdded() == true) goto L19;
            tt5.a.d("ShareNewFragment", "fragment is not add");     // Catch: Throwable -> L13
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

        @Override // com.bytedance.ee.bear.share.newshare.b
        public final void e() {
            Dialog r100 = this.f237279a.getDialog();
            if (r100 != null) goto L5;
            return;
        L5:
            if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L11;
            DialogLancet.handleBlockedDialogShow(r100);
            return;
        L11:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L10
        L8:
            DialogLancet.beforeDialogShow(r100);
            r100.show();
            DialogLancet.afterDialogShow(r100);
        }

        @Override // com.bytedance.ee.bear.share.newshare.b
        public final Bundle getArguments() {
            return this.f237279a.getArguments();
        }

        @Override // com.bytedance.ee.bear.share.newshare.b
        public final boolean isShowing() {
            Dialog r100 = this.f237279a.getDialog();
            if (r100 != null) goto L7;
            return false;
        L7:
            return r100.isShowing();
        }

        @Override // com.bytedance.ee.bear.share.newshare.b
        public final FragmentActivity p0() {
            return this.f237279a.getActivity();
        }

        @Override // com.bytedance.ee.bear.share.newshare.b
        public final ShareNewFragment getHostFragment() {
            return this.f237279a;
        }

        public b(ShareNewFragment r100) {
            this.f237279a = r100;
        }
    }

    static {
    }

    public final km5.a ea0() {
        ShareViewModel r100 = this.f237276m;
        if (r100 == null) goto L6;
        km5.a r101 = r100.buildShareItemModelParams();
        if (r101 == null) goto L6;
        return r101;
    L6:
        int r102 = km5.a.f504064s;
        return new km5.a(0, -1, "", false, false, null, null, null, false, false, false, false, null, null, false, false, ShareScene.DOCUMENT);
    }

    public final ShareParams fa0() {
        ShareParams r100 = this.f237275l;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("params");
        return null;
    }

    public ShareNewFragment() {
        this.f237274k = String.valueOf(hashCode());
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment
    public final boolean ba0() {
        return !c.k(getActivity());
    }

    public final void ga0() {
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
        tt5.a.e("ShareNewFragment", "init peek height", th, false);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        ShareViewModel r100 = this.f237276m;
        if (r100 == null) goto L6;
        r100.release();
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).H9(this, SharePanelState.NOT_SHOW, ea0());
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        ShareViewModel r100 = this.f237276m;
        if (r100 == null) goto L6;
        r100.onResume();
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        if (n.D(getActivity()) == false) goto L5;
    L18:
        ga0();
        return;
    L5:
        if (rcb.b.b(getActivity()) == true) goto L18;
        if (n.C(getActivity()) == true) goto L18;
        if (f.a() == false) goto L11;
    L14:
        boolean r100 = true;
    L15:
        if (r100 == true) goto L18;
        if (DeviceUtils.isPad() == true) goto L18;
        return;
    L11:
        if (com.ss.android.lark.base.embedded.b.g() == true) goto L14;
        r100 = false;
        goto L15
    }

    @Override // com.bytedance.ee.bear.share.export.i
    public final String getPanelSession() {
        return this.f237274k;
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

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        ShareViewModel r101 = this.f237276m;
        if (r101 == null) goto L5;
        r101.onConfigurationChanged(r100);
    L5:
        ga0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        Fragment r102 = null;
        Object[] r103 = 0;
        if (r101 == null) goto L5;
        Serializable r104 = r101.getSerializable("extra_params");
    L7:
        if ((r104 instanceof ShareParams) == false) goto L9;
        ShareParams r105 = (ShareParams) r104;
    L10:
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        this.f237275l = r105;
        return;
    L9:
        r105 = new ShareParams(requireActivity(), r102, 2, r103 == true ? 1 : 0);
        goto L10
    L5:
        r104 = null;
        goto L7
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        tt5.a.h("ShareNewFragment", "onViewCreated");
        this.f237277n = new ShareAdapter();
        RecyclerView r102 = (RecyclerView) r100.findViewById(R.id.moreContainer);
        r102.setAdapter(this.f237277n);
        r102.setLayoutManager(new LinearLayoutManager(getContext()));
        ShareViewModel r103 = this.f237276m;
        if (r103 == null) goto L5;
        r103.create(new b(this), fa0());
    L5:
        ShareViewModel r104 = this.f237276m;
        if (r104 == null) goto L10;
        LiveData<d0> r105 = r104.getMoreUIList();
        if (r105 == null) goto L10;
        r105.observe(this, new nm5.a(this));
    L10:
        ShareViewModel r106 = this.f237276m;
        if (r106 == null) goto L15;
        LiveData<e0> r107 = r106.getChangeUIItem();
        if (r107 == null) goto L15;
        r107.observe(this, new nm5.b(this));
    L15:
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).H9(this, SharePanelState.SHOWING, ea0());
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.share_new_fragment_layout, r101, false);
    }
}
