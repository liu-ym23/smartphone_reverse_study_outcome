package com.bytedance.ee.bear.bitable.homepage.chart.add;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment;
import com.bytedance.ee.bear.facade.common.widget.RoundFrameLayout;
import com.bytedance.ee.util.ui.n;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 22\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J&\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u001a\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020!2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010*\u001a\u00020\u000b2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010+\u001a\u00020,2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010-\u001a\u00020\u000bH\u0002J\b\u0010.\u001a\u00020\u000bH\u0002J\b\u0010/\u001a\u00020\u000bH\u0002J\b\u00100\u001a\u00020\u000bH\u0016J\b\u00101\u001a\u00020\u000bH\u0002R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0013\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001c¨\u00063"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/chart/add/AddChartContainerFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseBottomSheetDialogFragment;", "<init>", "()V", "hpAddChartContainerFromXml", "Lcom/bytedance/ee/bear/facade/common/widget/RoundFrameLayout;", "getHpAddChartContainerFromXml", "()Lcom/bytedance/ee/bear/facade/common/widget/RoundFrameLayout;", "setHpAddChartContainerFromXml", "(Lcom/bytedance/ee/bear/facade/common/widget/RoundFrameLayout;)V", "clearFromXmlViewCache", "", "onDestroyView", "viewModel", "Lcom/bytedance/ee/bear/bitable/homepage/chart/add/AddChartContainerViewModel;", "getViewModel", "()Lcom/bytedance/ee/bear/bitable/homepage/chart/add/AddChartContainerViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "lazyInitHeight", "getLazyInitHeight", "()Lkotlin/Unit;", "lazyInitHeight$delegate", "containerEnv", "", "getContainerEnv", "()Ljava/lang/String;", "setContainerEnv", "(Ljava/lang/String;)V", "hpFrom", "getHpFrom", "setHpFrom", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", WidgetCostModule.TYPE_ON_CREATE, "onCreateDialog", "Landroid/app/Dialog;", "observeDismissEvent", "observeBitableSelected", "showBitableChooser", WidgetCostModule.TYPE_ON_START, "initHeight", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AddChartContainerFragment extends BaseBottomSheetDialogFragment {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f212342p = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public RoundFrameLayout f212343k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f212344l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f212345m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f212346n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f212347o;

    public static final class a {
    }

    static {
    }

    public final void ea0() {
        Dialog r100 = getDialog();     // Catch: Throwable -> L23
        ViewGroup.LayoutParams r101 = null;
        if (r100 == null) goto L14;
        Window r102 = r100.getWindow();     // Catch: Throwable -> L23
        if (r102 == null) goto L14;
        View r103 = r102.getDecorView();     // Catch: Throwable -> L23
        if (com.larus.home.impl.utils.c.f346345e == false) goto L12;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L23
        Thread r104 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L23
        if (r104 == com.larus.home.impl.utils.c.f346341a) goto L12;
        com.larus.home.impl.utils.c.a(r104, "getDecorView");     // Catch: Throwable -> L23
    L12:
        if (r103 == null) goto L14;
        FrameLayout r105 = (FrameLayout) r103.findViewById(R.id.design_bottom_sheet);     // Catch: Throwable -> L23
    L15:
        if (r105 == null) goto L18;
        r101 = r105.getLayoutParams();     // Catch: Throwable -> L23
    L18:
        if ((r101 instanceof CoordinatorLayout.LayoutParams) == false) goto L28;
        int r106 = (int) (((double) n.p(getActivity())) * 0.9d);     // Catch: Throwable -> L23
        ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) r101)).height = r106;     // Catch: Throwable -> L23
        CoordinatorLayout.Behavior r107 = ((CoordinatorLayout.LayoutParams) r101).getBehavior();     // Catch: Throwable -> L23
        if ((r107 instanceof BottomSheetBehavior) == false) goto L29;
        ((BottomSheetBehavior) r107).setDraggable(false);     // Catch: Throwable -> L23
        ((BottomSheetBehavior) r107).setPeekHeight(r106);     // Catch: Throwable -> L23
        return;
    L29:
        return;
    L28:
        return;
    L14:
        r105 = null;
    L23:
        th = move-exception;
        tt5.a.e("AddChartContainerFragment", "init peek height failed", th, false);
    }

    public final AddChartContainerViewModel da0() {
        return (AddChartContainerViewModel) this.f212344l.getValue();
    }

    public AddChartContainerFragment() {
        final Function0<Fragment> r100 = new AddChartContainerFragment$special$$inlined$viewModels$default$1(this);
        this.f212344l = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AddChartContainerViewModel.class), new AddChartContainerFragment$special$$inlined$viewModels$default$2(r100), new AddChartContainerFragment$special$$inlined$viewModels$default$3(r100, this));
        this.f212345m = LazyKt.lazy(new AddChartContainerFragment$lazyInitHeight$2(this));
        this.f212346n = "";
        this.f212347o = "";
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f212343k = null;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        this.f212345m.getValue();
        Unit r100 = Unit.INSTANCE;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        da0().setContainerEnv(this.f212346n);
        da0().setHpFrom(this.f212347o);
        da0().getOnBaseSelected().observe(this, new b(this));
        da0().getOnDismissEvent().observe(this, new c(this));
        FragmentTransaction r101 = getChildFragmentManager().beginTransaction();
        ChooseBaseFragment r102 = new ChooseBaseFragment();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r101, r102, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "ChooseBaseFragment", R.id.hp_add_chart_container) == true) goto L6;
        r101.add(R.id.hp_add_chart_container, r102, "ChooseBaseFragment");
    L6:
        r101.addToBackStack(null);
        r101.commit();
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        final Context r101 = requireContext();
        final int r102 = getTheme();
        BottomSheetDialog r103 = new AddChartContainerFragment$onCreateDialog$dialog$1(this, r101, r102);
        r103.setCancelable(false);
        r103.setCanceledOnTouchOutside(false);
        return r103;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        View r102 = this.f212343k;
        if (r102 != null) goto L9;
        View r103 = getView();
        if (r103 == null) goto L7;
        r102 = r103.findViewById(R.id.hp_add_chart_container);
    L8:
        this.f212343k = (RoundFrameLayout) r102;
        goto L9
    L7:
        r102 = null;
    L9:
        ((RoundFrameLayout) r102).f226533e = true;
        int r104 = com.bytedance.ee.bear.bitable.homepage.chart.add.a.f212406a;
        String r105 = da0().getContainerEnv();
        String r106 = da0().getHpFrom();
        int r107 = com.bytedance.ee.bear.bitable.homepage.chart.c.f212424a;
        CoreThreadPool.getBackgroundHandler().post(new com.bytedance.ee.bear.bitable.homepage.chart.f(r105, r106));
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.bitable_homepage_add_chart_container, r101, false);
    }
}
