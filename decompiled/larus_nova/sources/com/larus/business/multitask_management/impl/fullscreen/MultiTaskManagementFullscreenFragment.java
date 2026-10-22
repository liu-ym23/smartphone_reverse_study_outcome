package com.larus.business.multitask_management.impl.fullscreen;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.z;
import com.larus.business.multitask_management.impl.component.DiscoverServicesFeature;
import com.larus.business.multitask_management.impl.component.OngoingTasksFeature;
import com.larus.business.multitask_management.impl.component.PinnedServicesFeature;
import com.larus.business.multitask_management.impl.component.RecentServicesFeature;
import com.larus.business.multitask_management.impl.databinding.LarusFragmentMultitaskManagementFullscreenBinding;
import com.larus.business.multitask_management.impl.sheet.MultiTaskManagementSheetComponent;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.i0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.u;
import k1a.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tx9.h2;
import xw8.c;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001#B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0017\u001a\u00020\fH\u0002J\b\u0010\u0018\u001a\u00020\fH\u0002J\b\u0010\u0019\u001a\u00020\fH\u0002J\u0012\u0010\u001a\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001e\u001a\u00020\fH\u0016J\u0012\u0010\u001f\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010!\u001a\u00020\fH\u0016J\b\u0010\"\u001a\u00020\fH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/larus/business/multitask_management/impl/fullscreen/MultiTaskManagementFullscreenFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/larus/bmhome/ISideBarChildFragment;", "<init>", "()V", "binding", "Lcom/larus/business/multitask_management/impl/databinding/LarusFragmentMultitaskManagementFullscreenBinding;", "enterTime", "", "hasReportedLeave", "", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "setupBackground", "setupTitleBar", "attachTaskCenterComponents", "onFirstEnterTab", "previousPage", "", "onEnterTab", "onLeaveTab", "onNewIntent", "bundle", "onDestroyView", "reportLeave", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MultiTaskManagementFullscreenFragment extends Fragment implements z {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f320918g = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LarusFragmentMultitaskManagementFullscreenBinding f320919d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f320920e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f320921f;

    public static final class a {
    }

    static {
    }

    public final void S90() {
        if (this.f320921f == false) goto L5;
        return;
    L5:
        if (this.f320920e == 0) goto L10;
        h2.b("navigation_tab_click", "click_navigation", Long.valueOf(SystemClock.elapsedRealtime() - this.f320920e));
        this.f320921f = true;
        return;
    }

    public final void T90() {
        Bundle r100 = getArguments();
        String r101 = getString(R.string.larus_mobileSideBar_nav_explore);
        Intrinsics.checkNotNullParameter(r101, "fallback");
        if (r100 == null) goto L17;
        String r102 = r100.getString("navigation_title");
        if (r102 == null) goto L17;
        String r103 = StringsKt.trim(r102).toString();
        if (r103 == null) goto L17;
        if (r103.length() <= 0) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == true) goto L15;
        r103 = null;
    L15:
        if (r103 == null) goto L17;
        String r105 = r103;
    L18:
        LarusFragmentMultitaskManagementFullscreenBinding r106 = this.f320919d;
        if (r106 == null) goto L24;
        NovaTitleBarEx r107 = r106.f320828b;
        if (r107 == null) goto L25;
        NovaTitleBarEx.Y5(r107, r105, null, null, 6);
        NovaTitleBarEx.b6(r107, R.drawable.larus_ic_side_bar, false, null, r105, new c(this), 6);
        return;
    L25:
        return;
    L24:
        return;
    L11:
        r104 = false;
    L17:
        r105 = r101;
        goto L18
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        S90();
        this.f320919d = null;
        super.onDestroyView();
    }

    public MultiTaskManagementFullscreenFragment() {
    }

    @Override // com.larus.bmhome.z
    public final void t1() {
        S90();
    }

    @Override // com.larus.bmhome.z
    public final void a2(Bundle r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Bundle r101 = getArguments();
        Intrinsics.checkNotNullParameter(r100, "incoming");
        if (r101 != null) goto L7;
        Bundle r102 = new Bundle();
    L8:
        r102.putAll(r100);
        if (r101 != null) goto L11;
        setArguments(r102);
    L11:
        T90();
        return;
    L7:
        r102 = r101;
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.f320920e = SystemClock.elapsedRealtime();
    }

    @Override // com.larus.bmhome.z
    public final void pp(String r100) {
        this.f320920e = SystemClock.elapsedRealtime();
        this.f320921f = false;
    }

    @Override // com.larus.bmhome.z
    public final void y2(String r100) {
        this.f320920e = SystemClock.elapsedRealtime();
        this.f320921f = false;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        LarusFragmentMultitaskManagementFullscreenBinding r112 = this.f320919d;
        if (r112 == null) goto L8;
        ConstraintLayout r113 = r112.f320827a;
        if (r113 == null) goto L8;
        Context r114 = r113.getContext();
        r113.setBackground(new xw8.a(ContextCompat.getColor(r114, v19.c.b(R.attr.larus_base_1, r114, R.color.larus_base_1)), ContextCompat.getColor(r114, v19.c.b(R.attr.larus_base_1_overlay, r114, R.color.larus_base_1_overlay))));
    L8:
        T90();
        final PinnedServicesFeature r100 = new PinnedServicesFeature();
        if ((!z2.f365865a.getMultiTaskEntranceConfig().a()) == false) goto L11;
        OngoingTasksFeature r115 = new OngoingTasksFeature();
    L12:
        final OngoingTasksFeature r101 = r115;
        final RecentServicesFeature r102 = new RecentServicesFeature();
        final DiscoverServicesFeature r103 = new DiscoverServicesFeature();
        final MultiTaskManagementSheetComponent r104 = new MultiTaskManagementSheetComponent(false, true);
        b.a(this, new xw8.b(this, r101, r100, r102, r103, r104));
        LarusFragmentMultitaskManagementFullscreenBinding r116 = this.f320919d;
        if (r116 == null) goto L18;
        ConstraintLayout r117 = r116.f320827a;
        if (r117 == null) goto L19;
        i0.f375410a.getClass();
        int r118 = i0.g();
        int r105 = u.b(getActivity());
        int r106 = r117.getPaddingStart();
        int r107 = r117.getPaddingEnd();
        FLogger.f375446a.i("updatePaddingRelative", "view:" + r117.getClass().getSimpleName() + ",source:,start:" + r106 + ",top:" + r118 + ",end:" + r107 + ",bottom:" + r105);
        r117.setPaddingRelative(r106, r118, r107, r105);
        return;
    L19:
        return;
    L18:
        return;
    L11:
        r115 = null;
        goto L12
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.larus_fragment_multitask_management_fullscreen, r101, false);
        int r104 = R.id.mtm_fullscreen_content;
        if (((ConstraintLayout) ViewBindings.findChildViewById(r103, R.id.mtm_fullscreen_content)) == null) goto L11;
        r104 = R.id.mtm_sheet_container;
        if (((RecyclerView) ViewBindings.findChildViewById(r103, R.id.mtm_sheet_container)) == null) goto L11;
        r104 = R.id.mtm_title_bar;
        NovaTitleBarEx r105 = (NovaTitleBarEx) ViewBindings.findChildViewById(r103, R.id.mtm_title_bar);
        if (r105 == null) goto L11;
        ConstraintLayout r106 = (ConstraintLayout) r103;
        this.f320919d = new LarusFragmentMultitaskManagementFullscreenBinding(r106, r105);
        return r106;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }
}
