package com.ss.android.lark.officesdk.minutes.ui.foundation.mvi;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.crash.d;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import h18.f;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0017J\u0012\u0010\u001b\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0017J&\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0017J\u001a\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u001f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0017J\u0010\u0010'\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u001fH\u0002J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0002J(\u0010,\u001a\u00020\u00182\u0006\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020)2\u0006\u0010/\u001a\u00020)2\u0006\u00100\u001a\u00020)H\u0014J\b\u00101\u001a\u00020)H\u0004J\b\u00102\u001a\u00020)H\u0004J\b\u00103\u001a\u00020\u0012H\u0004J\u0010\u00104\u001a\u00020\u00182\u0006\u00105\u001a\u00020\u0012H\u0014J\b\u00106\u001a\u00020\u0018H\u0004J\u0012\u00107\u001a\u00020\u00182\b\b\u0002\u00108\u001a\u00020\u0012H\u0004J\b\u00109\u001a\u00020\u0018H\u0004J\b\u0010:\u001a\u00020\u0018H\u0017J\b\u0010;\u001a\u00020\u0018H\u0017J\b\u0010<\u001a\u00020\u0018H\u0017J\b\u0010=\u001a\u00020\u0018H\u0017J\b\u0010>\u001a\u00020\u0018H\u0017J\b\u0010?\u001a\u00020\u0018H\u0017R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\f\u001a\u0004\u0018\u00010\u0012@BX\u0084\u000e¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010$\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/foundation/mvi/MmBaseFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "logDetail", "", "getLogDetail", "()Ljava/lang/String;", "logDetail$delegate", "Lkotlin/Lazy;", "dispatchedInsets", "Landroidx/core/graphics/Insets;", "value", "systemBarInsets", "getSystemBarInsets", "()Landroidx/core/graphics/Insets;", "darkModeJob", "Lkotlinx/coroutines/Job;", "", "appliedDarkMode", "getAppliedDarkMode", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "onAttach", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "insetsListenerView", "onViewCreated", "view", "setupWindowInsetsListener", "resolveNavigationAvoidanceBottom", "", "insets", "Landroidx/core/view/WindowInsetsCompat;", "onWindowInsetsChanged", "left", "top", "right", "bottom", "getStatusBarHeight", "getNavigationBarHeight", "isCurrentDarkMode", "onDarkModeChanged", "isDarkMode", "dismissAllChildDialogs", "handleDarkModeChange", "debounce", "initDarkModeState", WidgetCostModule.TYPE_ON_START, "onResume", "onPause", "onStop", "onDestroyView", "onDetach", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class MmBaseFragment extends Fragment {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f435621j = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f435622d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Insets f435623e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Insets f435624f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Job f435625g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Boolean f435626h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f435627i;

    public void X90(boolean r100) {
    }

    public void Y90(int r100, int r101, int r102, int r103) {
    }

    private final String U90() {
        return (String) this.f435622d.getValue();
    }

    public MmBaseFragment() {
        this.f435622d = LazyKt.lazy(new MmBaseFragment$logDetail$2(this));
        this.f435624f = Insets.NONE;
    }

    public final void T90() {
        Iterator<T> r100 = getChildFragmentManager().getFragments().iterator();
    L4:
        if (r100.hasNext() == false) goto L14;
        Fragment r101 = (Fragment) r100.next();
        if ((r101 instanceof DialogFragment) == false) goto L4;
        ((DialogFragment) r101).dismissAllowingStateLoss();     // Catch: Exception -> L10
    L10:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r102 = DialogFragmentLancet.sLastShowStack;
        if (r102 == null) goto L4;
        d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L4
    }

    public final boolean W90() {
        Context r100 = getContext();
        if (r100 != null) goto L5;
        r100 = LarkContext.getApplication();
    L5:
        Intrinsics.checkNotNull(r100);
        return f.a(r100);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Job r100 = this.f435625g;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.f435625g = null;
        View r101 = this.f435627i;
        if (r101 == null) goto L8;
        ViewCompat.setOnApplyWindowInsetsListener(r101, null);
    L8:
        this.f435627i = null;
        int r102 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "onDestroyView", null, U90(), 4);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        int r100 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "onDetach", null, U90(), 4);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        int r100 = bwb.b.f21271a;
        bwb.b.b(MmUiLogScene.FOUNDATION, "onPause", null, U90(), 4);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        int r100 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "onResume", null, U90(), 4);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        int r100 = bwb.b.f21271a;
        bwb.b.b(MmUiLogScene.FOUNDATION, WidgetCostModule.TYPE_ON_START, null, U90(), 4);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        int r100 = bwb.b.f21271a;
        bwb.b.b(MmUiLogScene.FOUNDATION, "onStop", null, U90(), 4);
    }

    public static final /* synthetic */ String S90(MmBaseFragment r100) {
        return r100.U90();
    }

    public final void V90(boolean r100) {
        boolean r101 = W90();
        if (Intrinsics.areEqual(this.f435626h, Boolean.valueOf(r101)) == false) goto L6;
        int r102 = bwb.b.f21271a;
        bwb.b.f(MmUiLogScene.FOUNDATION, "handleDarkModeChange", "handleDarkModeChange, theme not changed, skip", U90());
        return;
    L6:
        if (r100 == true) goto L9;
        this.f435626h = Boolean.valueOf(r101);
        X90(r101);
        return;
    L9:
        Job r103 = this.f435625g;
        if (r103 == null) goto L12;
        Job.DefaultImpls.cancel$default(r103, null, 1, null);
    L12:
        this.f435625g = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new MmBaseFragment$handleDarkModeChange$1(this, null), 3, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.onAttach(r100);
        int r101 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "onAttach", null, U90(), 4);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        int r101 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.FOUNDATION, WidgetCostModule.TYPE_ON_CREATE, null, U90(), 4);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        uvb.a.c(r100, getClass().getSimpleName());
        int r102 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "onViewCreated", null, U90(), 4);
        this.f435627i = r100;
        ViewCompat.setOnApplyWindowInsetsListener(r100, new b(this));
        ViewCompat.requestApplyInsets(r100);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        int r103 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "onCreateView", null, U90(), 4);
        return super.onCreateView(r100, r101, r102);
    }
}
