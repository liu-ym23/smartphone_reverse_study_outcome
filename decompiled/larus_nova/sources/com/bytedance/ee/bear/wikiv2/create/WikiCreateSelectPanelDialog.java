package com.bytedance.ee.bear.wikiv2.create;

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
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j;
import com.bytedance.ee.util.ui.n;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.suite.lark.component.navroute.forseti.ForsetiNavOptions;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 52\u00020\u0001:\u0003345B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u000bH\u0016J\u001a\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u000bH\u0002J\b\u0010%\u001a\u00020\u000bH\u0002J\b\u0010&\u001a\u00020\u000bH\u0002J\b\u0010'\u001a\u00020\u000bH\u0002J\u000e\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020*J\b\u0010,\u001a\u00020\u000bH\u0002R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u00066"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/create/WikiCreateSelectPanelDialog;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsSheetDialogFragment;", "<init>", "()V", "createSelectViewFromXml", "Lcom/bytedance/ee/bear/wikiv2/create/WikiCreateSelectView;", "getCreateSelectViewFromXml", "()Lcom/bytedance/ee/bear/wikiv2/create/WikiCreateSelectView;", "setCreateSelectViewFromXml", "(Lcom/bytedance/ee/bear/wikiv2/create/WikiCreateSelectView;)V", "clearFromXmlViewCache", "", "onDestroyView", "viewModel", "Lcom/bytedance/ee/bear/wikiv2/create/WikiCreateSelectPanelDialog$_ViewModel;", "getViewModel", "()Lcom/bytedance/ee/bear/wikiv2/create/WikiCreateSelectPanelDialog$_ViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "bundle", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "getTheme", "", WidgetCostModule.TYPE_ON_START, "onViewCreated", "view", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "initView", "compatForsetiUI", "bindView", "bindListener", "setCanCreate", "canCreate", "", "isShowing", "initPeekHeight", "mTag", "", "getMTag", "()Ljava/lang/String;", "setMTag", "(Ljava/lang/String;)V", "_ViewModel", "ViewDelegate", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiCreateSelectPanelDialog extends BaseAntiScreenshotsSheetDialogFragment {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f240666m = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public WikiCreateSelectView f240667i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f240668j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Bundle f240669k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f240670l;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/create/WikiCreateSelectPanelDialog$_ViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "delegate", "Lcom/bytedance/ee/bear/wikiv2/create/WikiCreateSelectPanelDialog$ViewDelegate;", "getDelegate", "()Lcom/bytedance/ee/bear/wikiv2/create/WikiCreateSelectPanelDialog$ViewDelegate;", "setDelegate", "(Lcom/bytedance/ee/bear/wikiv2/create/WikiCreateSelectPanelDialog$ViewDelegate;)V", "node", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/UITreeNode;", "getNode", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/UITreeNode;", "setNode", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/UITreeNode;)V", "canCreateDoc", "Landroidx/lifecycle/MutableLiveData;", "", "getCanCreateDoc", "()Landroidx/lifecycle/MutableLiveData;", "setCanCreateDoc", "(Landroidx/lifecycle/MutableLiveData;)V", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class _ViewModel extends ViewModel {
        private MutableLiveData<Boolean> canCreateDoc;
        private b delegate;
        private j node;

        public _ViewModel() {
            this.canCreateDoc = new MutableLiveData();
        }

        public final MutableLiveData<Boolean> getCanCreateDoc() {
            return this.canCreateDoc;
        }

        public final b getDelegate() {
            return this.delegate;
        }

        public final j getNode() {
            return this.node;
        }

        public final void setCanCreateDoc(MutableLiveData<Boolean> r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.canCreateDoc = r100;
        }

        public final void setDelegate(b r100) {
            this.delegate = r100;
        }

        public final void setNode(j r100) {
            this.node = r100;
        }
    }

    public static final class a {
        @JvmStatic
        public static WikiCreateSelectPanelDialog a(FragmentActivity r100, b r110, j r111, boolean r112, View r113, Fragment r114) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            _ViewModel r101 = (_ViewModel) ViewModelProviders.of(r100).get(_ViewModel.class);
            r101.setDelegate(r110);
            r101.getCanCreateDoc().setValue(Boolean.valueOf(r112));
            r101.setNode(r111);
            Fragment r115 = Fragment.instantiate(r100, WikiCreateSelectPanelDialog.class.getName());
            Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type com.bytedance.ee.bear.wikiv2.create.WikiCreateSelectPanelDialog");
            WikiCreateSelectPanelDialog r116 = (WikiCreateSelectPanelDialog) r115;
            if (ForsetiHelper.s(r114) == true) goto L5;
        L7:
            FragmentManager r102 = r100.getSupportFragmentManager();
            String r117 = WikiCreateSelectPanelDialog.class.getName();
            if ((r116 instanceof Fragment) == false) goto L10;
            WikiCreateSelectPanelDialog r118 = r116;
        L11:
            LandscapeRestrictionOperation r119 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r118, r117, r119);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r102, r118, r119) == false) goto L18;
        L16:
            return r116;
        L18:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L17
        L15:
            r116.show(r102, r117);
            goto L16
        L10:
            r118 = null;
            goto L11
        L5:
            if (ForsetiHelper.o() == false) goto L7;
            Bundle r120 = new Bundle();
            r120.putBoolean("IS_FORSETI_ON", true);
            r116.setArguments(r120);
            com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.f.h(r116, r100, ForsetiNavOptions.DestinationStyle.HALF_FLOAT, r113, 0, null, r114, true, 308);
            goto L16
        }
    }

    public interface b {
        void a(int r100);
    }

    static {
    }

    @Override // androidx.fragment.app.DialogFragment
    public final int getTheme() {
        return R.style.BearTransparentBottomSheetStyle;
    }

    public final WikiCreateSelectView Z90() {
        View r100 = this.f240667i;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.create_select_view);
    L8:
        this.f240667i = (WikiCreateSelectView) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (WikiCreateSelectView) r100;
    }

    public WikiCreateSelectPanelDialog() {
        this.f240668j = LazyKt.lazy(new WikiCreateSelectPanelDialog$viewModel$2(this));
    }

    public final void aa0() {
        Dialog r100 = getDialog();     // Catch: Throwable -> L11
        if (r100 == null) goto L17;
        Window r101 = r100.getWindow();     // Catch: Throwable -> L11
        if (r101 == null) goto L17;
        View r102 = r101.getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.f346345e == false) goto L13;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r103 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r103 == com.larus.home.impl.utils.c.f346341a) goto L13;
        com.larus.home.impl.utils.c.a(r103, "getDecorView");     // Catch: Throwable -> L11
    L13:
        if (r102 == null) goto L17;
        FrameLayout r104 = (FrameLayout) r102.findViewById(R.id.design_bottom_sheet);     // Catch: Throwable -> L11
        if (r104 == null) goto L17;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();     // Catch: Throwable -> L11
    L19:
        if ((r105 instanceof CoordinatorLayout.LayoutParams) == false) goto L31;
        CoordinatorLayout.Behavior r106 = ((CoordinatorLayout.LayoutParams) r105).getBehavior();     // Catch: Throwable -> L11
        if ((r106 instanceof BottomSheetBehavior) == true) goto L23;
        return;
    L23:
        if (en4.a.l() == false) goto L26;
        ((BottomSheetBehavior) r106).setPeekHeight(-1);     // Catch: Throwable -> L11
        return;
    L26:
        ((BottomSheetBehavior) r106).setPeekHeight((int) (n.t() * 0.75f));     // Catch: Throwable -> L11
        return;
    L31:
        return;
    L17:
        r105 = null;
    L11:
        th = move-exception;
        tt5.a.e("WikiCreateSelectPanelDialog", "init peek height", th, false);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f240667i = null;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        aa0();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        aa0();
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Bundle r102 = this.f240669k;
        if (r102 == null) goto L5;
        boolean r103 = r102.getBoolean("IS_FORSETI_ON");
    L6:
        if (r103 == true) goto L8;
    L11:
        _ViewModel r104 = (_ViewModel) this.f240668j.getValue();
        if (r104 == null) goto L16;
        MutableLiveData<Boolean> r105 = r104.getCanCreateDoc();
        if (r105 == null) goto L16;
        r105.observe(this, new c(this));
    L16:
        Z90().setDelegate(new com.bytedance.ee.bear.wikiv2.create.b(this));
        return;
    L8:
        if (com.suite.lark.component.navroute.forseti.f.b(this) == null) goto L11;
        Z90().setForsetiOn(true);
        Z90().getLayoutParams().height = -2;
        goto L11
    L5:
        r103 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        this.f240669k = getArguments();
        if (en4.a.l() == false) goto L5;
        int r103 = R.layout.wiki_create_select_layout_doubao;
    L7:
        return r100.inflate(r103, r101, false);
    L5:
        r103 = R.layout.wiki_create_select_layout_v2;
        goto L7
    }
}
