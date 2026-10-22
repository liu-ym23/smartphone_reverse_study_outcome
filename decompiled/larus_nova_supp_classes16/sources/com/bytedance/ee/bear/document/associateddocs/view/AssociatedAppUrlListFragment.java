package com.bytedance.ee.bear.document.associateddocs.view;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.associateddocs.AssociatedAppUrlListViewModel;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.ee.util.ui.n;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/document/associateddocs/view/AssociatedAppUrlListFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseBottomSheetDialogFragment;", "<init>", "()V", "associatedUrlListPanelFromXml", "Lcom/bytedance/ee/bear/widgets/panel/CommonActionPanelLayout;", "getAssociatedUrlListPanelFromXml", "()Lcom/bytedance/ee/bear/widgets/panel/CommonActionPanelLayout;", "setAssociatedUrlListPanelFromXml", "(Lcom/bytedance/ee/bear/widgets/panel/CommonActionPanelLayout;)V", "clearFromXmlViewCache", "", "onDestroyView", "viewModel", "Lcom/bytedance/ee/bear/document/associateddocs/AssociatedAppUrlListViewModel;", "appUrlListAdapter", "Lcom/bytedance/ee/bear/document/associateddocs/view/AssociatedAppUrlListAdapter;", "onStart", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "initPeekHeight", "newConfig", "Landroid/content/res/Configuration;", "onConfigurationChanged", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AssociatedAppUrlListFragment extends BaseBottomSheetDialogFragment {
    public CommonActionPanelLayout k;
    public AssociatedAppUrlListViewModel l;
    public final AssociatedAppUrlListAdapter m;

    public static final class a {
    }

    public static final class b implements AssociatedAppUrlListAdapter.a {
        public final /* synthetic */ AssociatedAppUrlListFragment a;

        public b(AssociatedAppUrlListFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.document.associateddocs.view.AssociatedAppUrlListAdapter.a
        public final void a(String r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "url");
            Intrinsics.checkNotNullParameter(r4, "urlMetaId");
            AssociatedAppUrlListViewModel r0 = this.a.l;
            if (r0 == null) goto L5;
            r0.onItemClick(r4);
        L5:
            ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).u5(r3);
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L8
            return;
        L8:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r5 = DialogFragmentLancet.sLastShowStack;
            if (r5 == null) goto L15;
            com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class c implements AssociatedAppUrlListViewModel.c {
        public final /* synthetic */ AssociatedAppUrlListFragment a;
        public final /* synthetic */ AssociatedAppUrlListViewModel b;

        @Override // com.bytedance.ee.bear.document.associateddocs.AssociatedAppUrlListViewModel.c
        public final void a() {
            AssociatedAppUrlListAdapter r0 = this.a.m;
            ArrayList<com.bytedance.ee.bear.document.associateddocs.view.a> r1 = this.b.getAssociatedAppUrlItems();
            r0.getClass();
            Intrinsics.checkNotNullParameter(r1, "items");
            r0.b.submitList(r1);
        }

        public c(AssociatedAppUrlListFragment r1, AssociatedAppUrlListViewModel r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class d extends CommonActionPanelLayout.b {
        public final /* synthetic */ AssociatedAppUrlListFragment a;

        public final void b() {
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r0 = DialogFragmentLancet.sLastShowStack;
            if (r0 == null) goto L12;
            com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }

        public d(AssociatedAppUrlListFragment r1) {
            this.a = r1;
        }
    }

    static {
    }

    public AssociatedAppUrlListFragment() {
        this.m = new AssociatedAppUrlListAdapter();
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        this.k = null;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        da0(getResources().getConfiguration());
    }

    public final void da0(Configuration r7) {
        Dialog r0 = getDialog();     // Catch: Throwable -> L11
        if (r0 == null) goto L17;
        Window r1 = r0.getWindow();     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        View r2 = r1.getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.e == false) goto L13;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r3 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r3 == com.larus.home.impl.utils.c.a) goto L13;
        com.larus.home.impl.utils.c.a(r3, "getDecorView");     // Catch: Throwable -> L11
    L13:
        if (r2 == null) goto L17;
        FrameLayout r4 = (FrameLayout) r2.findViewById(2131368870);     // Catch: Throwable -> L11
        if (r4 == null) goto L17;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();     // Catch: Throwable -> L11
    L19:
        if ((r5 instanceof CoordinatorLayout.LayoutParams) == false) goto L31;
        BottomSheetBehavior r6 = ((CoordinatorLayout.LayoutParams) r5).getBehavior();     // Catch: Throwable -> L11
        if ((r6 instanceof BottomSheetBehavior) == false) goto L23;
        r6.setPeekHeight(n.p(getContext()));     // Catch: Throwable -> L11
    L23:
        int r8 = (int) (((double) n.p(getContext())) * 0.98d);     // Catch: Throwable -> L11
        ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) r5)).height = r8;     // Catch: Throwable -> L11
        if (r7.orientation != 2) goto L26;
        int r9 = (int) (((double) n.q(getContext())) * 0.7d);     // Catch: Throwable -> L11
        ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) r5)).width = r9;     // Catch: Throwable -> L11
        return;
    L26:
        int r10 = n.q(getContext());     // Catch: Throwable -> L11
        ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) r5)).width = r10;     // Catch: Throwable -> L11
        return;
    L31:
        return;
    L17:
        r5 = null;
    L11:
        th = move-exception;
        tt5.a.e("AssociatedAppUrlListFragment", "init peek height", th, false);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment
    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super.onConfigurationChanged(r2);
        da0(r2);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment
    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        this.l = (AssociatedAppUrlListViewModel) q.a(this, AssociatedAppUrlListViewModel.class);
        RecyclerView r6 = r4.findViewById(2131363291);
        r6.setNestedScrollingEnabled(false);
        r6.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        r6.setAdapter(this.m);
        AssociatedAppUrlListAdapter r7 = this.m;
        r7.a = new b(this);
        AssociatedAppUrlListViewModel r8 = this.l;
        if (r8 == null) goto L5;
        ArrayList<com.bytedance.ee.bear.document.associateddocs.view.a> r0 = r8.getAssociatedAppUrlItems();
        Intrinsics.checkNotNullParameter(r0, "items");
        r7.b.submitList(r0);
        r8.setViewDelegate(new c(this, r8));
    L5:
        View r9 = this.k;
        CharSequence r1 = null;
        if (r9 != null) goto L12;
        View r10 = getView();
        if (r10 == null) goto L10;
        r9 = r10.findViewById(2131363292);
    L11:
        this.k = (CommonActionPanelLayout) r9;
        goto L12
    L10:
        r9 = null;
    L12:
        ((CommonActionPanelLayout) r9).setOnActionListener(new d(this));
        View r11 = this.k;
        if (r11 != null) goto L19;
        View r12 = getView();
        if (r12 == null) goto L17;
        r11 = r12.findViewById(2131363292);
    L18:
        this.k = (CommonActionPanelLayout) r11;
        goto L19
    L17:
        r11 = null;
    L19:
        CommonActionPanelLayout r13 = (CommonActionPanelLayout) r11;
        Context r14 = getContext();
        if (r14 == null) goto L22;
        r1 = r14.getText(2131888950);
    L22:
        r13.setTitle(r1);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment
    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131560030, r3, false);
    }
}
