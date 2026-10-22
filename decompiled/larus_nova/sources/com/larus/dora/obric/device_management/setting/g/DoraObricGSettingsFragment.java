package com.larus.dora.obric.device_management.setting.g;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.obric.device_v2.ObricDoraGConnectFailedDialogFragment;
import com.larus.nova.R;
import com.lynx.textra.PlatformFontCaps;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.oui.badge.OBadgeView;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000·\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0016\u0018\u0000 j2\u00020\u0001:\u0001jB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020!H\u0016J\b\u0010'\u001a\u00020!H\u0016J\b\u0010(\u001a\u00020!H\u0016J\b\u0010)\u001a\u00020!H\u0016J\u0010\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020\rH\u0016J\b\u0010.\u001a\u00020!H\u0016J\b\u0010/\u001a\u00020\u0019H\u0002J\b\u00100\u001a\u00020\u0019H\u0002J\b\u00101\u001a\u00020\u0019H\u0002J\b\u00102\u001a\u00020!H\u0002J\u0016\u00103\u001a\u00020!2\f\u00104\u001a\b\u0012\u0004\u0012\u00020605H\u0002J\b\u00107\u001a\u00020\u0019H\u0002J0\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\r2\u0006\u0010;\u001a\u00020,2\b\b\u0002\u0010<\u001a\u00020,2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020!0>H\u0002J\b\u0010?\u001a\u00020!H\u0002J\u0012\u0010?\u001a\u00020!2\b\u0010@\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010A\u001a\u00020!H\u0002J\u0010\u0010B\u001a\u00020!2\u0006\u0010@\u001a\u00020\rH\u0002J\b\u0010C\u001a\u00020!H\u0002J\u0012\u0010D\u001a\u00020!2\b\u0010@\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010E\u001a\u00020!H\u0002J\u0010\u0010F\u001a\u00020\u00192\u0006\u0010G\u001a\u00020\rH\u0002J\u0018\u0010H\u001a\u00020\u00192\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020LH\u0002J\u0014\u0010M\u001a\u00020!*\u0002092\u0006\u0010I\u001a\u00020JH\u0002J\u0018\u0010N\u001a\u00020L2\u0006\u0010O\u001a\u00020L2\u0006\u0010P\u001a\u00020LH\u0002J\b\u0010Q\u001a\u00020\u0019H\u0002J\u0010\u0010R\u001a\u00020\u00192\u0006\u0010S\u001a\u00020LH\u0002J\b\u0010T\u001a\u00020!H\u0002J\b\u0010U\u001a\u00020!H\u0002J\b\u0010V\u001a\u00020!H\u0002J\b\u0010W\u001a\u00020!H\u0002J\u0010\u0010X\u001a\u00020!2\u0006\u0010Y\u001a\u00020ZH\u0002J\u0010\u0010[\u001a\u00020!2\u0006\u0010Y\u001a\u00020ZH\u0002J\u0012\u0010\\\u001a\u00020!2\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0002J\b\u0010]\u001a\u00020!H\u0002J\b\u0010^\u001a\u00020!H\u0002J\u0010\u0010_\u001a\u00020!2\u0006\u0010`\u001a\u00020aH\u0002J\b\u0010b\u001a\u00020LH\u0002J\b\u0010c\u001a\u00020LH\u0002J\b\u0010d\u001a\u00020LH\u0002J\f\u0010e\u001a\u00020!*\u00020fH\u0002J\f\u0010g\u001a\u00020L*\u00020LH\u0002J\f\u0010h\u001a\u00020L*\u00020iH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017¨\u0006k"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/g/DoraObricGSettingsFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "viewModel", "Lcom/larus/dora/obric/device_management/setting/g/DoraObricGSettingsViewModel;", "getViewModel", "()Lcom/larus/dora/obric/device_management/setting/g/DoraObricGSettingsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "contentContainer", "Landroid/widget/LinearLayout;", "pendingReconnectMac", "", "btSwitch", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "connectFailedDialog", "Lcom/larus/dora/obric/device_v2/ObricDoraGConnectFailedDialogFragment;", "gpsDialog", "Lcom/obric/oui/dialog/v2/alert/OAlertDialog;", "localReceiver", "com/larus/dora/obric/device_management/setting/g/DoraObricGSettingsFragment$localReceiver$1", "Lcom/larus/dora/obric/device_management/setting/g/DoraObricGSettingsFragment$localReceiver$1;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onAttach", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", WidgetCostModule.TYPE_ON_START, "onResume", "onStop", "onDestroyView", "onDoraConnectStateChanged", "isConnected", "", "getCurrentPageName", "logEnterPage", "buildContentView", "buildScrollContent", "buildTitleBar", "renderSettings", "renderSections", "sections", "", "Lcom/larus/dora/obric/device_management/setting/g/DoraObricGSettingsSection;", "buildDisconnectedActionPanel", "buildDisconnectedActionButton", "Lcom/obric/oui/lisitem/OCardListItem;", "text", "primary", "isLoading", SendEventContainerMethodParamModel.EventKinds.onClick, "Lkotlin/Function0;", "checkReadyForReconnect", "mac", "showGpsDialogForReconnect", "requestBluetoothPermissionForReconnect", "requestEnableBluetoothForReconnect", "startReconnect", "openDeviceHome", "buildSectionTitle", "title", "buildSettingItem", MapController.ITEM_LAYER_TAG, "Lcom/larus/dora/obric/device_management/setting/g/DoraObricGSettingsItem;", "position", "", "bindEndContent", "resolveCardPosition", "index", "size", "buildRedDotView", "buildSpacer", "heightDp", "observeUiState", "observeNavigation", "observeEffects", "showDisconnectedUnbindDialog", "showReconnectUnbindDialog", "device", "Lcom/bytedance/dora/device/DoraDevice;", "unbindAndDisconnect", "showConnectFailedDialog", "dismissConnectFailedDialog", "dismissGpsDialog", "openRoute", NotificationCompat.CATEGORY_NAVIGATION, "Lcom/larus/dora/obric/device_management/setting/g/DoraObricGSettingsNavigation$Route;", "resolveBackgroundColor", "resolvePrimaryTextColor", "resolveSecondaryTextColor", "applyValueTextStyle", "Lcom/obric/oui/text/OTextView;", "dp", CloudControlInf.SP, "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricGSettingsFragment extends DoraBaseFragment {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f340242m = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f340243f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinearLayout f340244g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f340245h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ActivityResultLauncher<Intent> f340246i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ObricDoraGConnectFailedDialogFragment f340247j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.obric.oui.dialog.v2.alert.c f340248k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final DoraObricGSettingsFragment$localReceiver$1 f340249l;

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

    public final void Y90() {
        com.obric.oui.dialog.v2.alert.c r100 = this.f340248k;
        if (r100 == null) goto L21;
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r100);
        goto L21
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r102 == null) goto L18;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        goto L18
    L7:
        if (Looper.myLooper() == r101.getLooper()) goto L9;
        r101.post(DialogLancet.createDismissRunnable(r100));
    L21:
        this.f340248k = null;
    }

    public final DoraObricGSettingsViewModel aa0() {
        return (DoraObricGSettingsViewModel) this.f340243f.getValue();
    }

    public final void ca0() {
        LinearLayout r100 = this.f340244g;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.removeAllViews();
        u r101 = aa0().getUiState().getValue();
        String r102 = aa0().currentDeviceName();
        if (r101.f340612a == true) goto L9;
        ba0(aa0().disconnected(r102));
        Context r103 = requireContext();
        u r104 = aa0().getUiState().getValue();
        LinearLayout r105 = new LinearLayout(r103);
        r105.setOrientation(1);
        r105.setGravity(1);
        r105.setPadding(0, Z90(16), 0, 0);
        OCardListItem r106 = W90(getString(R.string.larus_dora_device_disconnected_btn_retry_cn), true, r104.f340613b, new DoraObricGSettingsFragment$buildDisconnectedActionPanel$1$1(this));
        LinearLayout.LayoutParams r107 = new LinearLayout.LayoutParams(-1, Z90(64));
        r107.topMargin = Z90(0);
        Unit r108 = Unit.INSTANCE;
        r105.addView(r106, r107);
        OCardListItem r109 = W90(getString(R.string.larus_dora_g_unbind_device_new_cn), false, false, new DoraObricGSettingsFragment$buildDisconnectedActionPanel$1$3(this));
        LinearLayout.LayoutParams r110 = new LinearLayout.LayoutParams(-1, Z90(64));
        r110.topMargin = Z90(16);
        r105.addView(r109, r110);
        r100.addView(r105);
        return;
    L9:
        ba0(aa0().connected(r102));
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        ObricDoraGConnectFailedDialogFragment r100 = this.f340247j;
        if (r100 != null) goto L12;
    L10:
        this.f340247j = null;
        Y90();
        this.f340244g = null;
        super.onDestroyView();
        return;
    L12:
        r100.dismissAllowingStateLoss();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L10;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L10
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment, androidx.fragment.app.Fragment
    public final void onStop() {
        LocalBroadcastManager.getInstance(AppHost.f326268a.getApplication()).unregisterReceiver(this.f340249l);
        super.onStop();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.dora.obric.device_management.setting.g.DoraObricGSettingsFragment$localReceiver$1] */
    public DoraObricGSettingsFragment() {
        final Function0<Fragment> r100 = new DoraObricGSettingsFragment$special$$inlined$viewModels$default$1(this);
        this.f340243f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraObricGSettingsViewModel.class), new DoraObricGSettingsFragment$special$$inlined$viewModels$default$2(r100), new DoraObricGSettingsFragment$special$$inlined$viewModels$default$3(r100, this));
        this.f340249l = new DoraObricGSettingsFragment$localReceiver$1(this);
    }

    @Override // com.larus.trace.tracknode.TraceFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        aa0().refreshConnectionState();
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        LocalBroadcastManager.getInstance(AppHost.f326268a.getApplication()).registerReceiver(this.f340249l, new IntentFilter("action.DEVICE_UPDATE_NAME"));
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void V90(boolean r100) {
        super.V90(r100);
        aa0().refreshConnectionState();
    }

    public final void X90(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L11;
        g49.d.e("DoraObricGSettingsFragment", "checkReadyForReconnect skipped, mac is empty");
        return;
    L11:
        this.f340245h = r100;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DoraObricGSettingsFragment$checkReadyForReconnect$1(this, r100, null), 3, null);
        return;
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    public final int Z90(int r100) {
        Resources r101 = getResources();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v18, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v20 */
    public final void ba0(List<t> r110) {
        LinearLayout r100 = this.f340244g;
        if (r100 != null) goto L5;
        return;
    L5:
        Iterator<T> r101 = r110.iterator();
        int r102 = 0;
        int r103 = 0;
    L7:
        if (r101.hasNext() == false) goto L58;
        Object r104 = r101.next();
        int r105 = r103 + 1;
        if (r103 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        t r106 = (t) r104;
        if (r103 <= 0) goto L14;
        View r107 = new View(requireContext());
        r107.setLayoutParams(new LinearLayout.LayoutParams(-1, Z90(16)));
        r100.addView(r107);
    L14:
        String r108 = r106.f340610a;
        int r109 = 8;
        if (r108 == null) goto L20;
        OSectionTitleBar r111 = new OSectionTitleBar(requireContext(), null, 6, r102);
        LinearLayout r112 = (LinearLayout) r111.findViewById(R.id.container);
        if (r112 == null) goto L19;
        r112.setPadding(Z90(20), Z90(8), Z90(12), Z90(8));
    L19:
        r111.setTitleText(r108);
        r111.setTitleStyle(R.style.SectionTitle_S);
        r111.setLayoutParams(new LinearLayout.LayoutParams(-1, Z90(32)));
        r100.addView(r111);
    L20:
        Iterator<T> r113 = r106.f340611b.iterator();
        int r114 = 0;
    L22:
        if (r113.hasNext() == false) goto L57;
        Object r115 = r113.next();
        int r116 = r114 + 1;
        if (r114 >= 0) goto L26;
        CollectionsKt.throwIndexOverflow();
    L26:
        final r r117 = (r) r115;
        int r118 = r106.f340611b.size();
        if (r118 > 1) goto L29;
        int r119 = 0;
    L35:
        OCardListItem r120 = new OCardListItem(requireContext(), null, 6, 0);
        r120.setCardType(0);
        OCardListItem.h(r120, r119);
        r120.setShowCardBg(true);
        r120.p(false);
        r120.setTitle(r117.f340603a);
        r120.s(true);
        r120.q(false);
        if (r117.f340606d == false) goto L39;
        int r121 = Z90(r109);
        OBadgeView r122 = new OBadgeView(requireContext(), null, 6, 0);
        r122.setLayoutParams(new FrameLayout.LayoutParams(r121, r121, 17));
        r120.setCustomEndView(r122);
        r120.m(true);
    L38:
        ?? r123 = 0;
    L53:
        if (r117.f340607e == false) goto L55;
        r120.setDefaultTailIcon(r123);
        r120.r(true);
        r120.getTailIconView().setColorFilter(null);
    L56:
        r120.o(r123);
        r120.setOnContentClickListener(new g(this, r117));
        r100.addView(r120);
        r114 = r116;
        r109 = 8;
        goto L22
    L55:
        r120.r(r123);
        goto L56
    L39:
        String r124 = r117.f340605c;
        if (r124 != null) goto L42;
    L45:
        boolean r125 = true;
    L46:
        if (r125 == true) goto L51;
        r120.setDefaultCustomEndView(3);
        r120.k(r117.f340605c, -1);
        OTextView r126 = r120.getEndDetail();
        if (r126 == null) goto L50;
        r126.setTextColor(v19.c.a(R.attr.larus_neutral_50, requireContext(), R.color.larus_neutral_50));
        r126.setTextSize(2, 14.0f);
        Resources r127 = getResources();
        TextViewCompat.setLineHeight(r126, (int) TypedValue.applyDimension(2, 18.0f, WindowDisplayMetricsOverride.apply(r127, r127.getDisplayMetrics())));
        r126.setSingleLine(true);
        r126.setMaxLines(1);
        r126.setEllipsize(TextUtils.TruncateAt.END);
    L50:
        r120.m(true);
        goto L38
    L51:
        r123 = 0;
        r120.m(false);
        goto L53
    L42:
        if (r124.length() == 0) goto L45;
        r125 = false;
        goto L46
    L29:
        if (r114 != 0) goto L32;
        r119 = 1;
        goto L35
    L32:
        if (r114 != (r118 - 1)) goto L34;
        r119 = 3;
        goto L35
    L34:
        r119 = 2;
        goto L35
    L57:
        r103 = r105;
        r102 = 0;
        goto L7
    }

    public final void da0(String r100) {
        StringBuilder r101 = new StringBuilder("startReconnect macEmpty=");
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        r101.append(r102);
        g49.d.d("DoraObricGSettingsFragment", r101.toString());
        this.f340245h = null;
        aa0().startReconnect(r100);
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.onAttach(r100);
        this.f340246i = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new f(r100, this));
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        aa0().initialize(getArguments());
        aa0().refreshConnectionState();
        Lifecycle.State r102 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricGSettingsFragment$observeUiState$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r102, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricGSettingsFragment$observeNavigation$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r102, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricGSettingsFragment$observeEffects$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r102, null, this), 3, null);
        ca0();
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r110) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Context r102 = requireContext();
        OFloatingTitleBar r103 = new OFloatingTitleBar(requireContext(), null, 6, 0);
        r103.setClipChildren(false);
        r103.setClipToPadding(false);
        r103.setBackgroundColor(v19.c.a(R.attr.larus_base_1_overlay, requireContext(), R.color.larus_base_1_overlay));
        r103.setCenterTitle(getString(R.string.larus_dora_device_manage_tab_settings_cn));
        r103.R(false);
        OFloatingTitleBar.k(r103, null, 6).setOnClickListener(new h(this));
        Context r111 = requireContext();
        LinearLayout r104 = new LinearLayout(r111);
        r104.setOrientation(1);
        r104.setClipChildren(false);
        r104.setClipToPadding(false);
        r104.setPadding(0, 0, 0, Z90(24));
        this.f340244g = r104;
        NestedScrollView r105 = new NestedScrollView(r111);
        r105.setClipChildren(true);
        r105.setClipToPadding(false);
        r105.setOverScrollMode(2);
        r105.setFillViewport(true);
        r105.setPadding(0, Z90(16), 0, 0);
        r105.addView(this.f340244g, new ViewGroup.LayoutParams(-1, -2));
        return com.larus.dora.obric.utils.c.c(r102, r103, r105, v19.c.a(R.attr.larus_base_1_overlay, requireContext(), R.color.larus_base_1_overlay), null);
    }

    public final OCardListItem W90(String r100, boolean r101, boolean r102, final Function0<Unit> r110) {
        Context r103 = requireContext();
        if (r101 == false) goto L5;
        int r104 = R.color.oui_accent_fg;
    L6:
        int r105 = ContextCompat.getColor(r103, r104);
        ConstraintLayout.LayoutParams r106 = null;
        OCardListItem r107 = new OCardListItem(r103, null, 6, 0);
        r107.setCardType(0);
        OCardListItem.h(r107, 0);
        r107.setShowCardBg(true);
        r107.p(false);
        r107.setTitle(r100);
        r107.s(!r102);
        r107.q(false);
        r107.m(false);
        r107.r(false);
        r107.o(false);
        r107.l(r105, r105);
        r107.getContentContainer().setPadding(0, 0, 0, 0);
        LinearLayout r108 = r107.getTitleContainer();
        r108.setGravity(17);
        r108.setPadding(Z90(16), 0, Z90(16), 0);
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
        if ((r109 instanceof ConstraintLayout.LayoutParams) == false) goto L9;
        r106 = (ConstraintLayout.LayoutParams) r109;
    L9:
        if (r106 == null) goto L11;
        ((ViewGroup.MarginLayoutParams) r106).width = 0;
        r106.f400439t = 0;
        r106.f400441v = 0;
        r106.f400438s = -1;
        r106.f400440u = -1;
        r106.E = 0.5f;
        r108.setLayoutParams(r106);
    L11:
        OTextView r111 = r107.getTitleView();
        r111.setGravity(17);
        r111.setTextSize(2, 16.0f);
        r111.setIncludeFontPadding(false);
        Resources r112 = getResources();
        TextViewCompat.setLineHeight(r111, (int) TypedValue.applyDimension(2, 22.0f, WindowDisplayMetricsOverride.apply(r112, r112.getDisplayMetrics())));
        r111.setTypeface(Typeface.create(Typeface.create(PlatformFontCaps.DEFAULT_FAMILY_NAME, 0), 500, false));
        if (r102 == false) goto L14;
        ODownloadProgressView r113 = new ODownloadProgressView(r103);
        r113.setLayoutParams(new LinearLayout.LayoutParams(Z90(24), Z90(24)));
        r113.setSize(2);
        r113.setProcessingColor(ContextCompat.getColor(r103, R.color.oui_basic_text_1));
        r113.setProgressBackgroundColor(ContextCompat.getColor(r103, R.color.oui_basic_line_2));
        r113.setCurrentState(0);
        r113.setClickable(false);
        r107.f401331n.addView(r113, 0);
    L14:
        r107.setOnContentClickListener(new e(r110));
        return r107;
    L5:
        r104 = R.color.oui_functional_red_7;
        goto L6
    }
}
