package com.larus.dora.obric.device_management.setting.earbuds;

import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u008f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0016\u0018\u0000 F2\u00020\u0001:\u0001FB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010#\u001a\u00020!H\u0016J\b\u0010$\u001a\u00020!H\u0016J\b\u0010%\u001a\u00020!H\u0016J\u0010\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020\u0014H\u0016J\b\u0010*\u001a\u00020!H\u0016J\b\u0010+\u001a\u00020\u0019H\u0002J\b\u0010,\u001a\u00020\u0019H\u0002J\b\u0010-\u001a\u00020!H\u0002J\b\u0010.\u001a\u00020!H\u0002J\b\u0010/\u001a\u00020!H\u0002J\b\u00100\u001a\u00020!H\u0002J\u0010\u00101\u001a\u00020(2\u0006\u00102\u001a\u000203H\u0002J\u0010\u00104\u001a\u00020!2\u0006\u00105\u001a\u000206H\u0002J2\u00107\u001a\u00020!2\u0010\u00108\u001a\f\u0012\b\u0012\u00060:j\u0002`;092\u000e\u0010<\u001a\n\u0018\u00010=j\u0004\u0018\u0001`>2\u0006\u0010?\u001a\u000203H\u0002J\b\u0010@\u001a\u00020!H\u0002J\b\u0010A\u001a\u00020BH\u0002J\u0010\u0010C\u001a\u00020!2\u0006\u0010D\u001a\u00020\u0019H\u0002J\f\u0010E\u001a\u00020B*\u00020BH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017¨\u0006G"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/earbuds/DoraObricEarbudsDSLSettingsFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "viewModel", "Lcom/larus/dora/obric/device_management/setting/earbuds/DoraObricEarbudsDSLSettingsViewModel;", "getViewModel", "()Lcom/larus/dora/obric/device_management/setting/earbuds/DoraObricEarbudsDSLSettingsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "actionModel", "Lcom/larus/dora/impl/dynamic/viewmodel/DoraDynamicViewModelV2;", "getActionModel", "()Lcom/larus/dora/impl/dynamic/viewmodel/DoraDynamicViewModelV2;", "actionModel$delegate", "adapter", "Lcom/larus/dora/obric/device_management/setting/earbuds/DoraObricEarbudsDslCardAdapter;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "pageKey", "", "localReceiver", "com/larus/dora/obric/device_management/setting/earbuds/DoraObricEarbudsDSLSettingsFragment$localReceiver$1", "Lcom/larus/dora/obric/device_management/setting/earbuds/DoraObricEarbudsDSLSettingsFragment$localReceiver$1;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", WidgetCostModule.TYPE_ON_START, "onResume", "onStop", "onDoraConnectStateChanged", "isConnected", "", "getCurrentPageName", "logEnterPage", "buildContentView", "buildTitleBar", "setupAdapter", "refreshRenderedCards", "observeViewModel", "observeSettingActions", "shouldHandleConnectionState", "state", "Lcom/larus/dora/impl/dynamic/event/DeviceConnectionState;", "showUnbindConfirmDialog", "event", "Lcom/larus/dora/impl/dynamic/event/DialogEvent$ShowUnbindConfirm;", "updateAdapter", "cards", "", "Lcom/larus/dora/impl/dynamic/dsl/DslCard;", "Lcom/larus/dora/obric/device_management/setting/earbuds/DslCard;", "cardContext", "Lcom/larus/dora/impl/dynamic/entity/CardContext;", "Lcom/larus/dora/obric/device_management/setting/earbuds/CardContext;", "connectionState", "loadData", "resolveBackgroundColor", "", "relaxClipForShadow", PickerReporterConstants.KEY.TARGET, "dp", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricEarbudsDSLSettingsFragment extends DoraBaseFragment {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f339681l = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f339682f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f339683g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public DoraObricEarbudsDslCardAdapter f339684h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RecyclerView f339685i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f339686j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final DoraObricEarbudsDSLSettingsFragment$localReceiver$1 f339687k;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        return "settings_home";
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment, com.larus.trace.tracknode.TraceFragment
    public final void T90() {
        int r100 = y69.a.f566402a;
        String r101 = y69.b.a(this, getArguments());
        Bundle r102 = getArguments();
        if (r102 == null) goto L5;
        String r103 = r102.getString("enter_method");
    L6:
        y69.a.a("settings_home", r101, r103);
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final DoraDynamicViewModelV2 W90() {
        return (DoraDynamicViewModelV2) this.f339683g.getValue();
    }

    public final DoraObricEarbudsDSLSettingsViewModel X90() {
        return (DoraObricEarbudsDSLSettingsViewModel) this.f339682f.getValue();
    }

    public final void Y90() {
        final DoraObricEarbudsDslCardAdapter r100 = this.f339684h;
        if (r100 == null) goto L9;
        o r101 = o.f340185a;
        Intrinsics.checkNotNullParameter(r101, "event");
        if (Intrinsics.areEqual(r101, r101) == false) goto L8;
        r100.f339697e.post(new l(r100));
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment, androidx.fragment.app.Fragment
    public final void onStop() {
        LocalBroadcastManager.getInstance(AppHost.f326268a.getApplication()).unregisterReceiver(this.f339687k);
        super.onStop();
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.larus.dora.obric.device_management.setting.earbuds.DoraObricEarbudsDSLSettingsFragment$localReceiver$1] */
    public DoraObricEarbudsDSLSettingsFragment() {
        final Function0<Fragment> r100 = new DoraObricEarbudsDSLSettingsFragment$special$$inlined$viewModels$default$1(this);
        this.f339682f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraObricEarbudsDSLSettingsViewModel.class), new DoraObricEarbudsDSLSettingsFragment$special$$inlined$viewModels$default$2(r100), new DoraObricEarbudsDSLSettingsFragment$special$$inlined$viewModels$default$3(r100, this));
        this.f339683g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraDynamicViewModelV2.class), new DoraObricEarbudsDSLSettingsFragment$special$$inlined$activityViewModels$default$1(this), new DoraObricEarbudsDSLSettingsFragment$special$$inlined$activityViewModels$default$2(this));
        this.f339687k = new DoraObricEarbudsDSLSettingsFragment$localReceiver$1(this);
    }

    @Override // com.larus.trace.tracknode.TraceFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        X90().refreshConnectionState();
        Y90();
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        LocalBroadcastManager.getInstance(AppHost.f326268a.getApplication()).registerReceiver(this.f339687k, new IntentFilter("action.DEVICE_UPDATE_NAME"));
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void V90(boolean r100) {
        super.V90(r100);
        X90().refreshConnectionState();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        RecyclerView r112 = this.f339685i;
        if (r112 == null) goto L6;
        DoraObricEarbudsDslCardAdapter r113 = new DoraObricEarbudsDslCardAdapter(W90());
        this.f339684h = r113;
        r112.setAdapter(r113);
    L6:
        Bundle r114 = getArguments();
        if (r114 == null) goto L26;
        boolean r100 = false;
        int r101 = r114.getInt("product_id", 0);
        String r102 = r114.getString(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        String r103 = r114.getString(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MAC);
        String r104 = r114.getString(DoraObricDeviceHomeViewModel.PARAM_PAGE_KEY);
        if (r104 != null) goto L12;
        r104 = "";
    L12:
        this.f339686j = r104;
        Integer r115 = Integer.valueOf(r114.getInt(DoraObricDeviceHomeViewModel.PARAM_VENDOR_ID, 0));
        if (r115.intValue() == 0) goto L15;
        boolean r105 = true;
    L16:
        if (r105 == false) goto L18;
        Integer r106 = r115;
    L19:
        DoraObricEarbudsDSLSettingsViewModel r116 = X90();
        Integer r107 = Integer.valueOf(r101);
        if (r107.intValue() == 0) goto L22;
        r100 = true;
    L22:
        if (r100 == false) goto L24;
        Integer r108 = r107;
    L25:
        r116.loadData(r106, r108, r102, this.f339686j, r103);
        goto L26
    L24:
        r108 = null;
        goto L25
    L18:
        r106 = null;
        goto L19
    L15:
        r105 = false;
    L26:
        Lifecycle.State r117 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricEarbudsDSLSettingsFragment$observeViewModel$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r117, null, this), 3, null);
        W90().getConnectionState().observe(getViewLifecycleOwner(), new j(new c(this)));
        W90().getDialogEvent().observe(getViewLifecycleOwner(), new j(new d(this)));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricEarbudsDSLSettingsFragment$observeSettingActions$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r117, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricEarbudsDSLSettingsFragment$observeSettingActions$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r117, null, this), 3, null);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Context r103 = requireContext();
        LinearLayout r104 = new LinearLayout(r103);
        r104.setOrientation(1);
        r104.setClipChildren(true);
        r104.setClipToPadding(true);
        r104.setBackgroundColor(v19.c.a(R.attr.larus_base_1_overlay, requireContext(), R.color.larus_base_1_overlay));
        OFloatingTitleBar r105 = new OFloatingTitleBar(requireContext(), null, 6, 0);
        com.larus.dora.obric.utils.c.a(r105);
        r105.setBackgroundColor(v19.c.a(R.attr.larus_base_1_overlay, requireContext(), R.color.larus_base_1_overlay));
        r105.setCenterTitle(getString(R.string.larus_dora_obric_earbuds_settings_title_cn));
        r105.R(false);
        final View r106 = OFloatingTitleBar.k(r105, null, 6);
        r106.setOnClickListener(new com.larus.dora.obric.device_management.setting.earbuds.a(this));
        r105.post(new b(this, r106));
        r104.addView(r105, new LinearLayout.LayoutParams(-1, -2));
        RecyclerView r107 = new RecyclerView(r103);
        r107.setLayoutManager(new LinearLayoutManager(r103));
        r107.setClipChildren(false);
        r107.setClipToPadding(false);
        r107.setOverScrollMode(2);
        Resources r108 = getResources();
        int r109 = (int) ((8 * WindowDisplayMetricsOverride.apply(r108, r108.getDisplayMetrics()).density) + 0.5f);
        Resources r110 = getResources();
        r107.setPadding(0, r109, 0, (int) ((24 * WindowDisplayMetricsOverride.apply(r110, r110.getDisplayMetrics()).density) + 0.5f));
        this.f339685i = r107;
        r104.addView(r107, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        return r104;
    }
}
