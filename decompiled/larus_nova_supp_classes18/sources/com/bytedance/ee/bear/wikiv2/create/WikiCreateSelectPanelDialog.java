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
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j;
import com.bytedance.ee.util.ui.n;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.suite.lark.component.navroute.forseti.ForsetiNavOptions;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 52\u00020\u0001:\u0003345B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u000bH\u0016J\u001a\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u000bH\u0002J\b\u0010%\u001a\u00020\u000bH\u0002J\b\u0010&\u001a\u00020\u000bH\u0002J\b\u0010'\u001a\u00020\u000bH\u0002J\u000e\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020*J\b\u0010,\u001a\u00020\u000bH\u0002R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u00066"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/create/WikiCreateSelectPanelDialog;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsSheetDialogFragment;", "<init>", "()V", "createSelectViewFromXml", "Lcom/bytedance/ee/bear/wikiv2/create/WikiCreateSelectView;", "getCreateSelectViewFromXml", "()Lcom/bytedance/ee/bear/wikiv2/create/WikiCreateSelectView;", "setCreateSelectViewFromXml", "(Lcom/bytedance/ee/bear/wikiv2/create/WikiCreateSelectView;)V", "clearFromXmlViewCache", "", "onDestroyView", "viewModel", "Lcom/bytedance/ee/bear/wikiv2/create/WikiCreateSelectPanelDialog$_ViewModel;", "getViewModel", "()Lcom/bytedance/ee/bear/wikiv2/create/WikiCreateSelectPanelDialog$_ViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "bundle", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "getTheme", "", "onStart", "onViewCreated", "view", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "initView", "compatForsetiUI", "bindView", "bindListener", "setCanCreate", "canCreate", "", "isShowing", "initPeekHeight", "mTag", "", "getMTag", "()Ljava/lang/String;", "setMTag", "(Ljava/lang/String;)V", "_ViewModel", "ViewDelegate", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiCreateSelectPanelDialog extends BaseAntiScreenshotsSheetDialogFragment {
    public static final /* synthetic */ int m = 0;
    public WikiCreateSelectView i;
    public final Lazy j;
    public Bundle k;
    public String l;

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

        public final void setCanCreateDoc(MutableLiveData<Boolean> r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.canCreateDoc = r2;
        }

        public final void setDelegate(b r1) {
            this.delegate = r1;
        }

        public final void setNode(j r1) {
            this.node = r1;
        }
    }

    public static final class a {
        @JvmStatic
        public static WikiCreateSelectPanelDialog a(FragmentActivity r9, b r10, j r11, boolean r12, View r13, Fragment r14) {
            Intrinsics.checkNotNullParameter(r9, "context");
            _ViewModel r0 = (_ViewModel) ViewModelProviders.of(r9).get(_ViewModel.class);
            r0.setDelegate(r10);
            r0.getCanCreateDoc().setValue(Boolean.valueOf(r12));
            r0.setNode(r11);
            Fragment r15 = Fragment.instantiate(r9, WikiCreateSelectPanelDialog.class.getName());
            Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type com.bytedance.ee.bear.wikiv2.create.WikiCreateSelectPanelDialog");
            Fragment r16 = (WikiCreateSelectPanelDialog) r15;
            if (ForsetiHelper.s(r14) == true) goto L5;
        L7:
            FragmentManager r17 = r9.getSupportFragmentManager();
            String r18 = WikiCreateSelectPanelDialog.class.getName();
            if ((r16 instanceof Fragment) == false) goto L10;
            Fragment r19 = r16;
        L11:
            LandscapeRestrictionOperation r110 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r19, r18, r110);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r17, r19, r110) == false) goto L18;
        L16:
            return r16;
        L18:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L17
        L15:
            r16.show(r17, r18);
            goto L16
        L10:
            r19 = null;
            goto L11
        L5:
            if (ForsetiHelper.o() == false) goto L7;
            Bundle r111 = new Bundle();
            r111.putBoolean("IS_FORSETI_ON", true);
            r16.setArguments(r111);
            com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.f.h(r16, r9, ForsetiNavOptions.DestinationStyle.HALF_FLOAT, r13, 0, null, r14, true, 308);
            goto L16
        }
    }

    public interface b {
        void a(int r1);
    }

    static {
    }

    public final int getTheme() {
        return 2131951905;
    }

    public final WikiCreateSelectView Z90() {
        View r0 = this.i;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131368206);
    L8:
        this.i = (WikiCreateSelectView) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (WikiCreateSelectView) r0;
    }

    public WikiCreateSelectPanelDialog() {
        this.j = LazyKt.lazy(new WikiCreateSelectPanelDialog$viewModel$2(this));
    }

    public final void aa0() {
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
        if ((r6 instanceof BottomSheetBehavior) == true) goto L23;
        return;
    L23:
        if (en4.a.l() == false) goto L26;
        r6.setPeekHeight(-1);     // Catch: Throwable -> L11
        return;
    L26:
        r6.setPeekHeight((int) (n.t() * 0.75f));     // Catch: Throwable -> L11
        return;
    L31:
        return;
    L17:
        r5 = null;
    L11:
        th = move-exception;
        tt5.a.e("WikiCreateSelectPanelDialog", "init peek height", th, false);
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        this.i = null;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        aa0();
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        aa0();
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment*/.onViewCreated(r2, r3);
        Bundle r4 = this.k;
        if (r4 == null) goto L5;
        boolean r5 = r4.getBoolean("IS_FORSETI_ON");
    L6:
        if (r5 == true) goto L8;
    L11:
        _ViewModel r6 = (_ViewModel) this.j.getValue();
        if (r6 == null) goto L16;
        MutableLiveData<Boolean> r7 = r6.getCanCreateDoc();
        if (r7 == null) goto L16;
        r7.observe(this, new c(this));
    L16:
        Z90().setDelegate(new com.bytedance.ee.bear.wikiv2.create.b(this));
        return;
    L8:
        if (com.suite.lark.component.navroute.forseti.f.b(this) == null) goto L11;
        Z90().setForsetiOn(true);
        Z90().getLayoutParams().height = -2;
        goto L11
    L5:
        r5 = false;
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        this.k = getArguments();
        if (en4.a.l() == false) goto L5;
        int r5 = 2131568231;
    L7:
        return r2.inflate(r5, r3, false);
    L5:
        r5 = 2131568232;
        goto L7
    }
}
