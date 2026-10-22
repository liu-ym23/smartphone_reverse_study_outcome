package com.bytedance.ee.bear.document.associateddocs.view;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseDialogFragment;
import com.bytedance.ee.bear.document.associateddocs.AssociatedDocViewModel;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.util.ui.n;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.lark.picker.Dependency;
import com.ss.android.lark.picker.Picker;
import com.ss.android.lark.picker.config.Permissions;
import com.ss.android.lark.picker.config.PickerConfig;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J&\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00122\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0012H\u0002J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\n\u0010\u001f\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/bytedance/ee/bear/document/associateddocs/view/AssociatedDocFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseDialogFragment;", "<init>", "()V", "mResult", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "Lkotlin/collections/ArrayList;", "viewModel", "Lcom/bytedance/ee/bear/document/associateddocs/AssociatedDocViewModel;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "getTheme", "", WidgetCostModule.TYPE_ON_START, "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "initView", "rootView", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "initPeekHeight", "getPicker", "getPickerConfig", "Lcom/ss/android/lark/picker/config/PickerConfig;", "activity", "Landroidx/fragment/app/FragmentActivity;", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AssociatedDocFragment extends BaseDialogFragment {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList<SearchBaseInfo> f219035h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AssociatedDocViewModel f219036i;

    public static final class a {
    }

    static {
    }

    public AssociatedDocFragment() {
        new ArrayList();
    }

    @Override // androidx.fragment.app.DialogFragment
    public final int getTheme() {
        if (getContext() != null) goto L5;
    L7:
        return R.style.CustomBottomSheetDialog;
    L5:
        if (ku5.c.k(getContext()) == false) goto L7;
        return R.style.CustomPadBottomSheetDialog;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        ba0(getResources().getConfiguration());
    }

    public final void ba0(Configuration r100) {
        Dialog r101 = getDialog();     // Catch: Throwable -> L26
        FrameLayout.LayoutParams r102 = null;
        if (r101 == null) goto L7;
        Window r103 = r101.getWindow();     // Catch: Throwable -> L26
        if (r103 == null) goto L7;
        WindowManager.LayoutParams r104 = r103.getAttributes();     // Catch: Throwable -> L26
    L8:
        if (r104 == null) goto L10;
        r104.gravity = 81;     // Catch: Throwable -> L26
    L10:
        if (r104 == null) goto L12;
        r104.height = (int) (((double) n.p(getContext())) * 0.95d);     // Catch: Throwable -> L26
    L12:
        Dialog r105 = getDialog();     // Catch: Throwable -> L26
        if (r105 == null) goto L17;
        Window r106 = r105.getWindow();     // Catch: Throwable -> L26
        if (r106 == null) goto L17;
        r106.setAttributes(r104);     // Catch: Throwable -> L26
    L17:
        Dialog r107 = getDialog();     // Catch: Throwable -> L26
        if (r107 == null) goto L30;
        Window r108 = r107.getWindow();     // Catch: Throwable -> L26
        if (r108 == null) goto L30;
        View r109 = r108.getDecorView();     // Catch: Throwable -> L26
        if (com.larus.home.impl.utils.c.f346345e == false) goto L28;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L26
        Thread r110 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L26
        if (r110 == com.larus.home.impl.utils.c.f346341a) goto L28;
        com.larus.home.impl.utils.c.a(r110, "getDecorView");     // Catch: Throwable -> L26
    L28:
        if (r109 == null) goto L30;
        LinearLayout r111 = (LinearLayout) r109.findViewById(R.id.associate_doc_panel_root);     // Catch: Throwable -> L26
    L31:
        if (r111 == null) goto L33;
        ViewGroup.LayoutParams r112 = r111.getLayoutParams();     // Catch: Throwable -> L26
    L35:
        if ((r112 instanceof FrameLayout.LayoutParams) == false) goto L37;
        r102 = (FrameLayout.LayoutParams) r112;     // Catch: Throwable -> L26
    L37:
        if (r102 != null) goto L39;
        return;
    L39:
        if (r100.orientation != 2) goto L41;
        r102.width = (int) (((double) n.q(getContext())) * 0.7d);     // Catch: Throwable -> L26
        r102.gravity = 1;     // Catch: Throwable -> L26
        return;
    L41:
        r102.width = n.q(getContext());     // Catch: Throwable -> L26
        r102.gravity = -1;     // Catch: Throwable -> L26
        return;
    L33:
        r112 = null;
    L30:
        r111 = null;
    L7:
        r104 = null;
    L26:
        th = move-exception;
        tt5.a.e("AssociatedDocFragment", "init peek height", th, false);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        ba0(r100);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        if ((getContext() instanceof FragmentActivity) == false) goto L6;
        Context r101 = getContext();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        this.f219036i = (AssociatedDocViewModel) new ViewModelProvider((FragmentActivity) r101).get(AssociatedDocViewModel.class);
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        if (getActivity() == null) goto L10;
        LinearLayout.LayoutParams r102 = new LinearLayout.LayoutParams(-1, -1);
        LinearLayout r103 = (LinearLayout) r100;
        FragmentActivity r104 = getActivity();
        if (r104 == null) goto L7;
        Picker r105 = new Picker(r104);
        PickerConfig r106 = new PickerConfig(new Dependency(r104, r104.getSupportFragmentManager()), new Permissions(CollectionsKt.emptyList()));
        r106.extra(new AssociatedDocFragment$getPickerConfig$config$1$1(this));
        r106.searcher(AssociatedDocFragment$getPickerConfig$config$1$2.INSTANCE);
        r106.recommendList(AssociatedDocFragment$getPickerConfig$config$1$3.INSTANCE);
        r105.init2(r106);
    L8:
        r103.addView(r105, 1, r102);
        ((BaseTitleBar) r100.findViewById(R.id.associate_title_bar)).setLeftClickListener(new k(this));
        return;
    L7:
        r105 = null;
        goto L8
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.dialog_fragment_associated_panel, r101, false);
    }
}
