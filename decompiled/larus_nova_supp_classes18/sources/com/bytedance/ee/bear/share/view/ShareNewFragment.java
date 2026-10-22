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
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment;
import com.bytedance.ee.bear.share.export.SharePanelState;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.bear.share.export.i;
import com.bytedance.ee.bear.share.externalshare.ShareScene;
import com.bytedance.ee.bear.share.newshare.d0;
import com.bytedance.ee.bear.share.newshare.e0;
import com.bytedance.ee.util.ui.n;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larksuite.framework.utils.DeviceUtils;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.lark.base.embedded.f;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import iu5.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ku5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 32\u00020\u00012\u00020\u0002:\u000234B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0006\u0010\u001a\u001a\u00020\u0016J\u000e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0010J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u001e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010%\u001a\u00020\u0014H\u0016J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010\u0013\u001a\u00020\u0016H\u0002J\b\u0010)\u001a\u00020\u0016H\u0002J\b\u0010*\u001a\u00020\u0016H\u0016J\u0010\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u001eH\u0002J\b\u0010-\u001a\u00020\u0016H\u0002J\b\u0010.\u001a\u00020\u0016H\u0002J\b\u0010/\u001a\u00020\u0016H\u0016J\b\u00100\u001a\u00020\u0016H\u0016J\b\u00101\u001a\u000202H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/bytedance/ee/bear/share/view/ShareNewFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseBottomSheetDialogFragment;", "Lcom/bytedance/ee/bear/share/export/ISharePanel;", "<init>", "()V", "panelSession", "", "getPanelSession", "()Ljava/lang/String;", "params", "Lcom/bytedance/ee/bear/share/export/ShareParams;", "getParams", "()Lcom/bytedance/ee/bear/share/export/ShareParams;", "setParams", "(Lcom/bytedance/ee/bear/share/export/ShareParams;)V", "shareViewModel", "Lcom/bytedance/ee/bear/share/view/ShareViewModel;", "shareAdapter", "Lcom/bytedance/ee/bear/share/view/ShareAdapter;", "initWatermark", "", "onStart", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "initData", "setViewModel", "viewModel", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "isSupportScreenLandscape", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "initPeekHeight", "onResume", "initView", "rootView", "bindView", "dismissStateLoss", "onDestroyView", "onDestroy", "buildShareItemModelParams", "Lcom/bytedance/ee/bear/share/externalshare/DocumentShareItemModelParams;", "Companion", "ShareHostImpl", "features-share-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareNewFragment extends BaseBottomSheetDialogFragment implements i {
    public static final /* synthetic */ int p = 0;
    public final String k;
    public ShareParams l;
    public ShareViewModel m;
    public ShareAdapter n;
    public boolean o;

    public static final class a {
    }

    public final class b implements com.bytedance.ee.bear.share.newshare.b {
        public final /* synthetic */ ShareNewFragment a;

        @Override // com.bytedance.ee.bear.share.newshare.b
        public final void a() {
            ShareNewFragment r0 = this.a;
            int r1 = ShareNewFragment.p;
            r0.getClass();
        L13:
            th = move-exception;
            tt5.a.f("ShareNewFragment", th, false);
            d.a("ShareNewFragment_dismissIgnoreErr()", th);
            return;
        L4:
            if (r0.isAdded() == true) goto L19;
            tt5.a.d("ShareNewFragment", "fragment is not add");     // Catch: Throwable -> L13
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

        @Override // com.bytedance.ee.bear.share.newshare.b
        public final void e() {
            Dialog r0 = this.a.getDialog();
            if (r0 != null) goto L5;
            return;
        L5:
            if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L11;
            DialogLancet.handleBlockedDialogShow(r0);
            return;
        L11:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L10
        L8:
            DialogLancet.beforeDialogShow(r0);
            r0.show();
            DialogLancet.afterDialogShow(r0);
        }

        @Override // com.bytedance.ee.bear.share.newshare.b
        public final Bundle getArguments() {
            return this.a.getArguments();
        }

        @Override // com.bytedance.ee.bear.share.newshare.b
        public final boolean isShowing() {
            Dialog r0 = this.a.getDialog();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.isShowing();
        }

        @Override // com.bytedance.ee.bear.share.newshare.b
        public final FragmentActivity p0() {
            return this.a.getActivity();
        }

        @Override // com.bytedance.ee.bear.share.newshare.b
        public final ShareNewFragment getHostFragment() {
            return this.a;
        }

        public b(ShareNewFragment r1) {
            this.a = r1;
        }
    }

    static {
    }

    public final km5.a ea0() {
        ShareViewModel r1 = this.m;
        if (r1 == null) goto L6;
        km5.a r2 = r1.buildShareItemModelParams();
        if (r2 == null) goto L6;
        return r2;
    L6:
        int r3 = km5.a.s;
        return new km5.a(0, -1, "", false, false, null, null, null, false, false, false, false, null, null, false, false, ShareScene.DOCUMENT);
    }

    public final ShareParams fa0() {
        ShareParams r0 = this.l;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("params");
        return null;
    }

    public ShareNewFragment() {
        this.k = String.valueOf(hashCode());
    }

    public final boolean ba0() {
        return !c.k(getActivity());
    }

    public final void ga0() {
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
        tt5.a.e("ShareNewFragment", "init peek height", th, false);
    }

    public final void onDestroy() {
        super.onDestroy();
        ShareViewModel r0 = this.m;
        if (r0 == null) goto L6;
        r0.release();
        return;
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).H9(this, SharePanelState.NOT_SHOW, ea0());
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        ShareViewModel r0 = this.m;
        if (r0 == null) goto L6;
        r0.onResume();
        return;
    }

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
        boolean r0 = true;
    L15:
        if (r0 == true) goto L18;
        if (DeviceUtils.isPad() == true) goto L18;
        return;
    L11:
        if (com.ss.android.lark.base.embedded.b.g() == true) goto L14;
        r0 = false;
        goto L15
    }

    @Override // com.bytedance.ee.bear.share.export.i
    public final String getPanelSession() {
        return this.k;
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

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super.onConfigurationChanged(r2);
        ShareViewModel r0 = this.m;
        if (r0 == null) goto L5;
        r0.onConfigurationChanged(r2);
    L5:
        ga0();
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        Bundle r5 = getArguments();
        if (r5 == null) goto L5;
        Object r6 = r5.getSerializable("extra_params");
    L7:
        if ((r6 instanceof ShareParams) == false) goto L9;
        ShareParams r7 = (ShareParams) r6;
    L10:
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        this.l = r7;
        return;
    L9:
        r7 = new ShareParams(requireActivity(), null, 2, null);
        goto L10
    L5:
        r6 = null;
        goto L7
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment*/.onViewCreated(r2, r3);
        tt5.a.h("ShareNewFragment", "onViewCreated");
        this.n = new ShareAdapter();
        RecyclerView r4 = r2.findViewById(2131380287);
        r4.setAdapter(this.n);
        r4.setLayoutManager(new LinearLayoutManager(getContext()));
        ShareViewModel r5 = this.m;
        if (r5 == null) goto L5;
        r5.create(new b(this), fa0());
    L5:
        ShareViewModel r6 = this.m;
        if (r6 == null) goto L10;
        LiveData<d0> r7 = r6.getMoreUIList();
        if (r7 == null) goto L10;
        r7.observe(this, new nm5.a(this));
    L10:
        ShareViewModel r8 = this.m;
        if (r8 == null) goto L15;
        LiveData<e0> r9 = r8.getChangeUIItem();
        if (r9 == null) goto L15;
        r9.observe(this, new nm5.b(this));
    L15:
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).H9(this, SharePanelState.SHOWING, ea0());
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131564515, r3, false);
    }
}
