package com.larus.dora.obric.device_management.device_bind;

import android.app.Application;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.router.SmartRouter;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.onboarding.DoraOnboardingDialogViewModel;
import com.larus.dora.impl.onboarding.DoraOnboardingPromptDialogFragment;
import com.larus.dora.impl.onboarding.TOAST_TYPE;
import com.larus.dora.impl.onboarding.o0;
import com.larus.dora.impl.onboarding.othersmart.DoraExternalDeviceOnboardingDialogFragment;
import com.larus.dora.impl.onboarding.p0;
import com.larus.dora.impl.onboarding.q0;
import com.larus.dora.impl.onboarding.x;
import com.larus.nova.R;
import com.larus.platform.api.g1;
import com.larus.platform.service.i2;
import com.larus.utils.j0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.oui.text.OTextView;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import v19.o5;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 [2\u00020\u0001:\u0001[B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020&H\u0016J$\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u001a\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020(2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u00101\u001a\u00020\u0012H\u0016J\b\u00102\u001a\u00020\u0012H\u0016J\b\u00103\u001a\u00020\u0012H\u0016J\b\u00104\u001a\u00020\u0019H\u0016J\b\u00105\u001a\u000206H\u0002J\b\u00107\u001a\u00020(H\u0002J\b\u00108\u001a\u00020\u0012H\u0002J\u0010\u00109\u001a\u00020\u00122\u0006\u0010:\u001a\u00020;H\u0002J \u0010<\u001a\u00020\u00122\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u00192\u0006\u0010@\u001a\u00020\u000bH\u0002J\u0018\u0010A\u001a\u00020\u00122\u0006\u0010B\u001a\u00020\u00192\u0006\u0010@\u001a\u00020\u000bH\u0002J\b\u0010C\u001a\u00020\u0012H\u0002J\u0010\u0010D\u001a\u00020\u00122\u0006\u0010E\u001a\u00020FH\u0002J\u0010\u0010G\u001a\u00020\u00122\u0006\u0010H\u001a\u00020IH\u0002J\u0010\u0010J\u001a\u00020\u00122\u0006\u0010=\u001a\u00020>H\u0002J\b\u0010K\u001a\u00020\u0012H\u0002J\b\u0010L\u001a\u00020MH\u0002J\b\u0010N\u001a\u00020\u0012H\u0002J\u0010\u0010O\u001a\u00020\u00122\u0006\u0010=\u001a\u00020>H\u0002J\b\u0010P\u001a\u00020\u0012H\u0003J\f\u0010Q\u001a\u00020>*\u00020RH\u0002J\f\u0010S\u001a\u00020\u0019*\u00020RH\u0002J \u0010T\u001a\u00020\u00122\b\b\u0002\u0010U\u001a\u00020\u00192\f\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\u001e\u0010W\u001a\u00020\u00122\u0006\u0010U\u001a\u00020\u00192\f\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\b\u0010X\u001a\u00020\u0012H\u0002J\u0010\u0010Y\u001a\u00020\u00122\u0006\u0010Z\u001a\u00020\u0019H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\\"}, d2 = {"Lcom/larus/dora/obric/device_management/device_bind/DoraObricSmartDeviceBindFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "scanModel", "Lcom/larus/dora/impl/onboarding/DoraOnboardingDialogViewModel;", "getScanModel", "()Lcom/larus/dora/impl/onboarding/DoraOnboardingDialogViewModel;", "scanModel$delegate", "Lkotlin/Lazy;", "isChecking", "", "onboardingDialogFragment", "Lcom/larus/dora/impl/onboarding/DoraOnboardingDialogBaseFragment;", "gpsDialog", "Lcom/larus/common_ui/dialog/CommonDialog;", "pendingCheckAction", "Lkotlin/Function0;", "", "btSwitch", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "productId", "", "prePage", "", "buryPointSource", "mac", ECPromotion.SKU, "vendorId", "bindButtonText", "needUnbindDialog", "connectFailedDialog", "Lcom/larus/dora/impl/onboarding/DoraOnboardingPromptDialogFragment;", "pageRenderer", "Lcom/larus/dora/obric/device_management/device_bind/DoraObricBindPageRenderer;", "onAttach", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onResume", "onStop", "onDestroyView", "getCurrentPageName", "buildNativePageContent", "Lcom/larus/dora/obric/device_management/device_bind/DoraObricBindPageRenderer$Content;", "buildContentView", "onBindButtonClicked", "handleUiState", "state", "Lcom/larus/dora/impl/onboarding/OnboardingUiState;", "renderFoundDevice", "device", "Lcom/bytedance/dora/device/DoraDevice;", "buttonText", "enabled", "renderBindButton", "text", "showScanLongTimeDialog", "showConnectFailedDialog", "uiState", "Lcom/larus/dora/impl/onboarding/OnboardingUiState$DeviceConnectFailed;", "handleAction", "action", "Lcom/larus/dora/impl/onboarding/OnboardingAction;", "showNeedUnbindDialog", "startBind", "resolveScanProductType", "Lcom/bytedance/dora/annotation/ProductNameType;", "launchOnboarding", "gotoOnboardingPage", "bindBondedDeviceIfNeeded", "toDoraDevice", "Landroid/bluetooth/BluetoothDevice;", "safeBluetoothName", "checkReady", "from", "doNext", "requestPermissions", "showGpsDialog", "handlePermissionDenied", "reason", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricSmartDeviceBindFragment extends DoraBaseFragment {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f338954v = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f338955f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f338956g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public DoraExternalDeviceOnboardingDialogFragment f338957h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CommonDialog f338958i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function0<Unit> f338959j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ActivityResultLauncher<Intent> f338960k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f338961l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f338962m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f338963n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f338964o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f338965p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f338966q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f338967r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public CommonDialog f338968s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public DoraOnboardingPromptDialogFragment f338969t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public f f338970u;

    public static final class a {
    }

    public /* synthetic */ class b implements FlowCollector, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoraObricSmartDeviceBindFragment f338971a;

        public b(DoraObricSmartDeviceBindFragment r100) {
            this.f338971a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof FlowCollector) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return new AdaptedFunctionReference(2, this.f338971a, DoraObricSmartDeviceBindFragment.class, "handleUiState", "handleUiState(Lcom/larus/dora/impl/onboarding/OnboardingUiState;)V", 4);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object r110, Continuation r111) {
            q0 r112 = (q0) r110;
            DoraObricSmartDeviceBindFragment r113 = this.f338971a;
            int r100 = DoraObricSmartDeviceBindFragment.f338954v;
            r113.getClass();
            g49.d.d("DoraObricSmartDeviceBindFragment", "handleUiState: " + r112);
            boolean r101 = false;
            if (Intrinsics.areEqual(r112, q0.e.f337331a) == false) goto L16;
            f r114 = r113.f338970u;
            if (r114 == null) goto L9;
            OTextView r115 = r114.f338990h;
            if (r115 == null) goto L9;
            r115.setVisibility(8);
        L9:
            String r116 = r113.f338967r;
            if (r116.length() <= 0) goto L12;
            r101 = true;
        L12:
            f r117 = r113.f338970u;
            if (r117 == null) goto L61;
            r117.g(r116, r101);
        L61:
            Unit r118 = Unit.INSTANCE;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return r118;
        L16:
            if (Intrinsics.areEqual(r112, q0.f.f337332a) == false) goto L24;
            DoraOnboardingPromptDialogFragment r119 = new DoraOnboardingPromptDialogFragment(new w(r113), "scan_long_time");
            r119.setArguments(com.larus.utils.f.c(new Pair[]{TuplesKt.to("key_dora_onboarding_origin_from", r113.f338962m)}));
            DoraObricSmartDeviceBindFragment.X90(r119, r113.getParentFragmentManager());
            r113.ba0().stopScan();
            String r120 = r113.f338967r;
            if (r120.length() <= 0) goto L20;
            r101 = true;
        L20:
            f r121 = r113.f338970u;
            if (r121 == null) goto L61;
            r121.g(r120, r101);
            goto L61
        L24:
            if ((r112 instanceof q0.d) == false) goto L27;
            r113.da0(((q0.d) r112).f337330a, r113.getString(R.string.larus_dora_connect_device_balloon_connect), true);
            goto L61
        L27:
            if ((r112 instanceof q0.c) == false) goto L30;
            r113.da0(((q0.c) r112).f337329a, r113.getString(R.string.larus_dora_other_smart_onboarding_connecting), false);
            goto L61
        L30:
            if ((r112 instanceof q0.b) == false) goto L54;
            o5.a(r113, "fragment_request_key_onboarding_start", com.larus.utils.f.c(new Pair[0]));
            DoraDevice r122 = ((q0.b) r112).f337328a;
            Context r102 = r113.getContext();     // Catch: Throwable -> L51
            if (r102 == null) goto L61;
            LocalBroadcastManager r103 = LocalBroadcastManager.getInstance(AppHost.f326268a.getApplication());     // Catch: Throwable -> L51
            Intent r104 = new Intent("action.DEVICE_UPDATE_DYNAMIC");     // Catch: Throwable -> L51
            r104.putExtra("mac", r122.f204389mac);     // Catch: Throwable -> L51
            r103.sendBroadcast(r104);     // Catch: Throwable -> L51
            com.bytedance.router.i r105 = SmartRouter.buildRoute(r102, "//dora_onboarding_v2");     // Catch: Throwable -> L51
            r105.f267555d = R.anim.larus_dora_router_slide_in_bottom;     // Catch: Throwable -> L51
            r105.f267556e = R.anim.larus_router_no_anim;     // Catch: Throwable -> L51
            r105.f267554c.putExtra("key_dora_onboarding_device", x.c(r122));     // Catch: Throwable -> L51
            r105.f267554c.putExtra("bury_point_source", r113.f338963n);     // Catch: Throwable -> L51
            Bundle r123 = r113.getArguments();     // Catch: Throwable -> L51
            if (r123 == null) goto L47;
            String r124 = r123.getString("next_action");     // Catch: Throwable -> L51
            if (r124 == null) goto L47;
            if (r124.length() <= 0) goto L42;
            r101 = true;
        L42:
            if (r101 == true) goto L45;
            r124 = null;
        L45:
            if (r124 == null) goto L47;
            r105.j("next_action", r124);     // Catch: Throwable -> L51
        L47:
            r105.d();     // Catch: Throwable -> L51
            FragmentActivity r125 = r113.getActivity();     // Catch: Throwable -> L51
            if (r125 == null) goto L61;
            r125.finish();     // Catch: Throwable -> L51
        L51:
            th = move-exception;
            g49.d.c("DoraObricSmartDeviceBindFragment", "gotoOnboardingPage failed", th);
            goto L61
        L54:
            if ((r112 instanceof q0.a) == false) goto L64;
            r113.ba0().stopScan();
            if (r113.isResumed() == false) goto L58;
            r113.ea0((q0.a) r112);
        L58:
            String r126 = r113.getString(R.string.larus_dora_connect_device_balloon_connect);
            f r127 = r113.f338970u;
            if (r127 == null) goto L61;
            r127.g(r126, true);
            goto L61
        L64:
            throw new NoWhenBranchMatchedException();
        }
    }

    public /* synthetic */ class c implements FlowCollector, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoraObricSmartDeviceBindFragment f338972a;

        public c(DoraObricSmartDeviceBindFragment r100) {
            this.f338972a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof FlowCollector) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return new AdaptedFunctionReference(2, this.f338972a, DoraObricSmartDeviceBindFragment.class, "handleAction", "handleAction(Lcom/larus/dora/impl/onboarding/OnboardingAction;)V", 4);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object r100, Continuation r101) {
            o0 r102 = (o0) r100;
            final DoraObricSmartDeviceBindFragment r103 = this.f338972a;
            int r104 = DoraObricSmartDeviceBindFragment.f338954v;
            r103.getClass();
            if ((r102 instanceof o0.c) == false) goto L17;
            final DoraDevice r105 = ((o0.c) r102).f337036a;
            boolean r106 = false;
            if (r103.f338968s != null) goto L7;
            CommonDialog.a r107 = new CommonDialog.a();
            r107.i(r103.getString(R.string.larus_dora_device_need_unbind_dialog_title_cn));
            r107.g(r103.getString(R.string.larus_dora_device_need_unbind_dialog_msg_cn));
            CommonDialog.a.f(r107, new u(r103, r105), r103.getString(R.string.larus_dora_device_btn_unbind_cn), false, 12);
            CommonDialog.a.e(r107, new v(r103, r105), r103.getString(R.string.larus_dora_dialog_btn_cancel_cn), 4);
            r107.f327197z = false;
            Function0<Boolean> r108 = new m(r103, r105);
            Intrinsics.checkNotNullParameter(r108, "callback");
            r107.B = r108;
            r103.f338968s = r107.a();
        L7:
            CommonDialog r109 = r103.f338968s;
            if (r109 != null) goto L10;
        L12:
            if (r106 == true) goto L29;
            CommonDialog r110 = r103.f338968s;
            if (r110 == null) goto L29;
            DoraObricSmartDeviceBindFragment.W90(r110, r103.getChildFragmentManager());
        L29:
            Unit r111 = Unit.INSTANCE;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return r111;
        L10:
            if (r109.isVisible() != true) goto L12;
            r106 = true;
            goto L12
        L17:
            if ((r102 instanceof o0.d) == false) goto L23;
            o0.d r112 = (o0.d) r102;
            if (r112.getType() != TOAST_TYPE.TOAST_TYPE_WARNING) goto L21;
            t19.s r113 = t19.s.f544207a;
            Application r114 = AppHost.f326268a.getApplication();
            String r115 = r112.f337037a;
            r113.getClass();
            t19.s.t(r114, r115);
            goto L29
        L21:
            t19.s r116 = t19.s.f544207a;
            Application r117 = AppHost.f326268a.getApplication();
            String r118 = r112.f337037a;
            r116.getClass();
            t19.s.c(r117, r118);
            goto L29
        L23:
            if (Intrinsics.areEqual(r102, o0.a.f337034a) == true) goto L29;
            if ((r102 instanceof o0.b) == true) goto L29;
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class d implements g1.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f338973a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DoraObricSmartDeviceBindFragment f338974b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f338975c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f338976d;

        @Override // com.larus.platform.api.g1.b
        public final void onSettingPageReturn() {
        }

        @Override // com.larus.platform.api.g1.b
        public final void onGoSettingsDialogShow() {
            this.f338973a.element = true;
        }

        @Override // com.larus.platform.api.g1.b
        public final void onGoSettingsDialogDismiss(boolean r100) {
            DoraBuryPointManager.f331862a.G(false, this.f338974b.f338963n);
            if (r100 == true) goto L6;
            this.f338974b.ca0("go settings dialog dismissed");
            return;
        }

        public d(Ref.BooleanRef r100, DoraObricSmartDeviceBindFragment r101, Function0<Unit> r102, String r103) {
            this.f338973a = r100;
            this.f338974b = r101;
            this.f338975c = r102;
            this.f338976d = r103;
        }

        @Override // com.larus.platform.api.g1.c
        public final void onResult(boolean r100, List<String> r101, List<String> r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r101, "grantedList");
            Intrinsics.checkNotNullParameter(r102, "deniedList");
            if (r103 == true) goto L5;
            DoraBuryPointManager.f331862a.G(r100, this.f338974b.f338963n);
        L5:
            if (r100 == false) goto L7;
            DoraObricSmartDeviceBindFragment r104 = this.f338974b;
            Function0<Unit> r105 = this.f338975c;
            int r106 = DoraObricSmartDeviceBindFragment.f338954v;
            r104.aa0("check_from_permission_granted", r105);
            return;
        L7:
            DoraObricSmartDeviceBindFragment r107 = this.f338974b;
            r107.f338956g = false;
            if (this.f338973a.element == true) goto L12;
            r107.ca0("permission denied from " + this.f338976d);
            return;
        }
    }

    public static final class e implements p0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoraObricSmartDeviceBindFragment f338977a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ q0.a f338978b;

        @Override // com.larus.dora.impl.onboarding.p0
        public final void onCloseButtonClick() {
        }

        @Override // com.larus.dora.impl.onboarding.p0
        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "promptType");
            DoraObricSmartDeviceBindFragment r101 = this.f338977a;
            int r102 = DoraObricSmartDeviceBindFragment.f338954v;
            r101.ba0().bindAndConnect(this.f338978b.f337327a);
        }

        public e(DoraObricSmartDeviceBindFragment r100, q0.a r101) {
            this.f338977a = r100;
            this.f338978b = r101;
        }
    }

    static {
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        return "obric_smart_device_bind";
    }

    public final DoraOnboardingDialogViewModel ba0() {
        return (DoraOnboardingDialogViewModel) this.f338955f.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        f r100 = this.f338970u;
        if (r100 == null) goto L5;
        r100.f338987e = null;
        r100.f338988f = null;
        r100.f338989g = null;
        r100.f338990h = null;
        r100.f338991i = null;
        r100.f338992j = null;
        r100.f338993k = null;
    L5:
        this.f338970u = null;
        super.onDestroyView();
    }

    public DoraObricSmartDeviceBindFragment() {
        this.f338955f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraOnboardingDialogViewModel.class), new DoraObricSmartDeviceBindFragment$special$$inlined$activityViewModels$default$1(this), new DoraObricSmartDeviceBindFragment$special$$inlined$activityViewModels$default$2(this));
        this.f338959j = new l();
        this.f338961l = -1;
        this.f338963n = "";
        this.f338964o = "";
        this.f338965p = "";
        this.f338966q = 4096;
        this.f338967r = "";
    }

    @Override // com.larus.trace.tracknode.TraceFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        q0 r100 = ba0().getUiStateFlow().getValue();
        if ((r100 instanceof q0.a) == false) goto L5;
        q0.a r101 = (q0.a) r100;
    L6:
        if (r101 == null) goto L9;
        ea0(r101);
        return;
    L9:
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment, androidx.fragment.app.Fragment
    public final void onStop() {
        ba0().stopScan();
        super.onStop();
    }

    public final void ca0(String r100) {
        g49.d.d("DoraObricSmartDeviceBindFragment", "handlePermissionDenied: " + r100);
    }

    public final void ea0(q0.a r100) {
        DoraOnboardingPromptDialogFragment r101 = this.f338969t;
        if (r101 != null) goto L12;
    L10:
        DoraOnboardingPromptDialogFragment r102 = new DoraOnboardingPromptDialogFragment(new e(this, r100), "connect_failed");
        r102.setArguments(com.larus.utils.f.c(new Pair[]{TuplesKt.to("key_dora_onboarding_origin_from", this.f338962m)}));
        this.f338969t = r102;
        X90(r102, getParentFragmentManager());
        return;
    L12:
        r101.dismissAllowingStateLoss();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r103 = DialogFragmentLancet.sLastShowStack;
        if (r103 == null) goto L10;
        com.bytedance.crash.d.d(r103, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L10
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.onAttach(r100);
        this.f338960k = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new q(this));
    }

    public static void W90(CommonDialog r100, FragmentManager r101) {
        LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r100, null, r102);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r100, r102) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r100.show(r101, null);
    }

    public static void X90(DoraOnboardingPromptDialogFragment r100, FragmentManager r101) {
        LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r100, "DoraObricSmartDeviceBindFragment", r102);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r100, r102) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r100.show(r101, "DoraObricSmartDeviceBindFragment");
    }

    public static final DoraDevice Z90(DoraObricSmartDeviceBindFragment r110, BluetoothDevice r111) {
        if (Build.VERSION.SDK_INT >= 31) goto L5;
    L38:
        String r100 = r111.getName();     // Catch: SecurityException -> L10
        if (r100 == null) goto L12;
    L13:
        DoraDevice r112 = DoraDevice.from(r111);
        r112.productId = r110.f338961l;
        ProductNameType r101 = ProductNameType.H_FREE_CLIP_2;
        r112.type = r101.deviceType;
        r112.vendorId = r110.f338966q;
        boolean r102 = false;
        String r103 = null;
        if (StringsKt.startsWith$default(r100, "HUAWEI FreeClip 2 HE", false, 2, null) == false) goto L16;
    L27:
        r112.vendorId = 4096;
        ProductNameType r104 = ProductNameType.H_FREE_CLIP_2_HE;
        r112.productId = r104.f204375id;
        r112.type = r104.deviceType;
        r112.sku = 0;
    L28:
        String r113 = r110.f338965p;
        if (r113.length() <= 0) goto L31;
        r102 = true;
    L31:
        if (r102 == false) goto L33;
        r103 = r113;
    L33:
        if (r103 == null) goto L37;
        Integer r114 = StringsKt.toIntOrNull(r103, 16);
        if (r114 == null) goto L37;
        r112.sku = r114.intValue();
    L37:
        return r112;
    L16:
        if (StringsKt.startsWith$default(r100, "HUAWEI FreeClip 2 " + AppHost.f326268a.getApplication().getString(R.string.larus_dora_h_robinh_tips_special_cn), false, 2, null) == true) goto L27;
        if (StringsKt.startsWith$default(r100, "HUAWEI FreeClip 2", false, 2, null) == false) goto L21;
    L26:
        r112.vendorId = 4096;
        r112.productId = r101.f204375id;
        r112.type = r101.deviceType;
        r112.sku = 1;
        goto L28
    L21:
        if (StringsKt.startsWith$default(r100, "Robin", false, 2, null) == true) goto L26;
        if (StringsKt.startsWith$default(r100, "HUAWEI FreeBuds Pro 5", false, 2, null) == false) goto L28;
        r112.vendorId = 4096;
        ProductNameType r105 = ProductNameType.H_FREE_BUDS_PRO_5;
        r112.productId = r105.f204375id;
        r112.type = r105.deviceType;
        r112.sku = 1;
    L12:
        r100 = "";
    L10:
        e = move-exception;
        g49.d.c("DoraObricSmartDeviceBindFragment", "read bluetooth name failed", e);
        goto L12
    L5:
        if (l69.a.a("DoraObricSmartDeviceBindFragment") == true) goto L38;
        goto L12
    }

    private final void requestPermissions(String r110, Function0<Unit> r111) {
        ArrayList r100 = new ArrayList();
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 31) goto L5;
        r100.add("android.permission.BLUETOOTH_SCAN");
        r100.add("android.permission.BLUETOOTH_CONNECT");
        r100.add("android.permission.BLUETOOTH");
    L6:
        DoraBuryPointManager.f331862a.H(this.f338963n);
        Ref.BooleanRef r102 = new Ref.BooleanRef();
        i2 r103 = i2.f365748b;
        d r104 = new d(r102, this, r111, r110);
        if (r101 < 31) goto L9;
        int r112 = j0.f375426a;
        Map r113 = MapsKt.mapOf(TuplesKt.to("android.permission.BLUETOOTH_SCAN", j0.d(R.string.larus_dora_bt_auth_cn)));
    L10:
        g1.a.a(this, r100, r104, r113, null, 16);
        return;
    L9:
        int r105 = j0.f375426a;
        r113 = MapsKt.mapOf(new Pair[]{TuplesKt.to("android.permission.BLUETOOTH", j0.d(R.string.larus_dora_bt_auth_cn)), TuplesKt.to("android.permission.ACCESS_FINE_LOCATION", j0.d(R.string.larus_dora_poi_auth_cn)), TuplesKt.to("android.permission.ACCESS_COARSE_LOCATION", j0.d(R.string.larus_dora_poi_auth_cn))});
        goto L10
    L5:
        r100.add("android.permission.BLUETOOTH");
        r100.add("android.permission.BLUETOOTH_ADMIN");
        r100.add("android.permission.ACCESS_FINE_LOCATION");
        r100.add("android.permission.ACCESS_COARSE_LOCATION");
        goto L6
    }

    public final void aa0(String r100, Function0<Unit> r101) {
        g49.d.d("DoraObricSmartDeviceBindFragment", "checkReady: " + r100 + " start");
        if (Intrinsics.areEqual(r100, "check_from_main") == true) goto L5;
    L7:
        this.f338956g = true;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DoraObricSmartDeviceBindFragment$checkReady$1(r101, this, r100, null), 3, null);
        return;
    L5:
        if (this.f338956g == false) goto L7;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        f r112 = this.f338970u;
        boolean r113 = true;
        if (r112 == null) goto L9;
        String r100 = getString(R.string.larus_dora_other_smart_bind_device_title_cn);
        String r101 = getString(R.string.larus_dora_other_smart_bind_device_desc_sax_cn);
        String r102 = this.f338967r;
        if (r102.length() <= 0) goto L7;
        boolean r103 = true;
    L8:
        r112.d(new f.b(r100, r101, R.drawable.larus_dora_obric_device_bind_img_smart_earbuds, null, r102, r103, null, null, false, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_HTTP_RES_FINISH_TIME));
        goto L9
    L7:
        r103 = false;
    L9:
        Lifecycle.State r114 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricSmartDeviceBindFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r114, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricSmartDeviceBindFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r114, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricSmartDeviceBindFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r114, null, this), 3, null);
        if (this.f338964o.length() == 0) goto L13;
        r113 = false;
    L13:
        if (r113 == true) goto L17;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new DoraObricSmartDeviceBindFragment$bindBondedDeviceIfNeeded$1(this, null), 2, null);
        return;
    }

    public static final /* synthetic */ void Y90(DoraObricSmartDeviceBindFragment r100, String r101, Function0 r102) {
        r100.requestPermissions(r101, r102);
    }

    public final void da0(DoraDevice r100, String r101, boolean r102) {
        f r103 = this.f338970u;
        if (r103 == null) goto L7;
        String r104 = getString(R.string.larus_dora_other_smart_onboarding_device_found, new Object[]{o59.a.d(r100)});
        Intrinsics.checkNotNullParameter(r104, "text");
        OTextView r105 = r103.f338990h;
        if (r105 == null) goto L7;
        r105.setText(r104);
        r105.setVisibility(0);
    L7:
        f r106 = this.f338970u;
        if (r106 == null) goto L11;
        r106.g(r101, r102);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Bundle r103 = getArguments();
        String r104 = null;
        if (r103 == null) goto L5;
        String r105 = r103.getString("device_manage");
    L6:
        String r106 = "";
        if (r105 != null) goto L9;
        r105 = "";
    L9:
        this.f338962m = r105;
        Bundle r107 = getArguments();
        if (r107 == null) goto L16;
        String r108 = r107.getString("product_id");
        if (r108 == null) goto L16;
        Integer r109 = StringsKt.toIntOrNull(r108);
        if (r109 == null) goto L16;
        int r110 = r109.intValue();
    L17:
        this.f338961l = r110;
        this.f338967r = getString(R.string.larus_dora_bind_device_button_title_cn);
        Bundle r111 = getArguments();
        if (r111 == null) goto L20;
        String r112 = r111.getString("extra_mac");
    L21:
        if (r112 != null) goto L23;
        r112 = "";
    L23:
        this.f338964o = r112;
        Bundle r113 = getArguments();
        if (r113 == null) goto L26;
        String r114 = r113.getString("extra_sku");
    L27:
        if (r114 != null) goto L29;
        r114 = "";
    L29:
        this.f338965p = r114;
        Bundle r115 = getArguments();
        int r116 = 4096;
        if (r115 == null) goto L32;
        r116 = r115.getInt("extra_vendor_id", 4096);
    L32:
        this.f338966q = r116;
        Bundle r117 = getArguments();
        if (r117 == null) goto L35;
        r104 = r117.getString("bury_point_source");
    L35:
        if (r104 == null) goto L38;
        r106 = r104;
    L38:
        this.f338963n = r106;
        f r118 = new f(requireContext(), new o(this), new DoraObricSmartDeviceBindFragment$buildContentView$2(this), new p());
        this.f338970u = r118;
        return r118.b();
    L26:
        r114 = null;
        goto L27
    L20:
        r112 = null;
    L16:
        r110 = -1;
        goto L17
    L5:
        r105 = null;
        goto L6
    }
}
