package com.larus.dora.impl.device.scan;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.common_ui.widget.roundlayout.RoundLinearLayout;
import com.larus.dora.impl.core.BindAndConnectResult;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.databinding.LarusDoraDialogScanDeviceBinding;
import com.larus.dora.impl.device.DoraDeviceViewModel;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.larus.utils.i0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.FlowCollector;
import v19.o5;

/* JADX INFO: loaded from: classes27.dex */
@Deprecated(message = "This dialog is only used in DoraDeviceFragment, and DoraDeviceFragment is deprecated")
@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u001a\b\u0007\u0018\u0000 72\u00020\u0001:\u00017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J$\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020(H\u0002J\u001a\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020\u001dH\u0016J\b\u0010/\u001a\u00020\u001dH\u0016J\b\u00100\u001a\u00020\u001dH\u0016J\u0016\u00101\u001a\u00020\u001d2\u0006\u00102\u001a\u000203H\u0082@¢\u0006\u0002\u00104J\u0016\u00105\u001a\u00020\u001d2\u0006\u00102\u001a\u000203H\u0082@¢\u0006\u0002\u00104J\u0010\u00106\u001a\u00020\u001d2\u0006\u00102\u001a\u000203H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001b¨\u00068"}, d2 = {"Lcom/larus/dora/impl/device/scan/ScanDeviceDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/device/DoraDeviceViewModel;", "getModel", "()Lcom/larus/dora/impl/device/DoraDeviceViewModel;", "model$delegate", "Lkotlin/Lazy;", "scanDialogModel", "Lcom/larus/dora/impl/device/scan/ScanDeviceDialogViewModel;", "getScanDialogModel", "()Lcom/larus/dora/impl/device/scan/ScanDeviceDialogViewModel;", "scanDialogModel$delegate", "lastLinkState", "", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraDialogScanDeviceBinding;", "ioScope", "Lkotlinx/coroutines/CoroutineScope;", "scanListAdapter", "Lcom/larus/dora/impl/device/scan/ScanDeviceListAdapter;", "isConnectingOrReplacing", "Ljava/util/concurrent/atomic/AtomicBoolean;", "doraLinkCallback", "com/larus/dora/impl/device/scan/ScanDeviceDialog$doraLinkCallback$1", "Lcom/larus/dora/impl/device/scan/ScanDeviceDialog$doraLinkCallback$1;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "setupStatusBar", LiveEndPageData.TAG_WINDOW, "Landroid/view/Window;", "onViewCreated", "view", "onDismiss", "dialog", "Landroid/content/DialogInterface;", WidgetCostModule.TYPE_ON_START, "onStop", "onDestroyView", "connect", "device", "Lcom/bytedance/dora/device/DoraDevice;", "(Lcom/bytedance/dora/device/DoraDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showNeedUnbindDialog", "replaceAndConnect", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScanDeviceDialog extends DialogFragment {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f334234l = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f334235d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f334236e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f334237f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LarusDoraDialogScanDeviceBinding f334238g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CoroutineScope f334239h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ScanDeviceListAdapter f334240i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicBoolean f334241j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ScanDeviceDialog$doraLinkCallback$1 f334242k;

    public static final class a {
    }

    public static final class b<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ScanDeviceDialog f334243a;

        public b(ScanDeviceDialog r100) {
            this.f334243a = r100;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object r100, Continuation r101) {
            j r102 = (j) r100;
            ScanDeviceListAdapter r103 = this.f334243a.f334240i;
            if (r103 == null) goto L19;
            Intrinsics.checkNotNullParameter(r102, "deviceModel");
            List<j> r104 = r103.f334254a;
            if ((r104 instanceof Collection) == true) goto L7;
        L9:
            Iterator r105 = ((ArrayList) r104).iterator();
        L11:
            if (r105.hasNext() == false) goto L15;
            if (Intrinsics.areEqual(((j) r105.next()).f334266a, r102.f334266a) == false) goto L11;
            boolean r106 = false;
        L16:
            if (r106 == false) goto L19;
            ((ArrayList) r103.f334254a).add(r102);
            r103.notifyItemInserted(((ArrayList) r103.f334254a).size() - 1);
        L15:
            r106 = true;
            goto L16
        L7:
            if (((ArrayList) r104).isEmpty() == false) goto L9;
        L19:
            return Unit.INSTANCE;
        }
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.larus.dora.impl.device.scan.ScanDeviceDialog$doraLinkCallback$1] */
    public ScanDeviceDialog() {
        this.f334235d = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraDeviceViewModel.class), new ScanDeviceDialog$special$$inlined$activityViewModels$default$1(this), new ScanDeviceDialog$special$$inlined$activityViewModels$default$2(this));
        final Function0<Fragment> r100 = new ScanDeviceDialog$special$$inlined$viewModels$default$1(this);
        this.f334236e = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ScanDeviceDialogViewModel.class), new ScanDeviceDialog$special$$inlined$viewModels$default$2(r100), new ScanDeviceDialog$special$$inlined$viewModels$default$3(r100, this));
        this.f334239h = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        this.f334241j = new AtomicBoolean(false);
        this.f334242k = new ScanDeviceDialog$doraLinkCallback$1(this);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f334238g = null;
        kj4.a.g().unregisterDoraLinkCallback(this.f334242k);
        if (this.f334237f != 2) goto L5;
        boolean r100 = true;
    L6:
        g49.d.d("ScanDeviceDialog", "showBluetoothDialog is " + r100);
        o5.a(this, "showBluetoothDialog", com.larus.utils.f.c(new Pair[]{TuplesKt.to("showBluetoothDialog", Boolean.valueOf(r100))}));
        o5.a(this, "find_device", com.larus.utils.f.c(new Pair[0]));
        return;
    L5:
        r100 = false;
        goto L6
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        ((ScanDeviceDialogViewModel) this.f334236e.getValue()).startScan();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        ((ScanDeviceDialogViewModel) this.f334236e.getValue()).stopScan();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(2, R.style.Theme_ScanDeviceDialog);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L7
        super.onDismiss(r100);     // Catch: Throwable -> L7
        if ((((DoraDeviceViewModel) this.f334235d.getValue()).getDeviceStateFlow().getValue() instanceof com.larus.dora.impl.device.c.b) == false) goto L5;
        g49.d.d("ScanDeviceDialog", "dialog dismissed and deviceState=DeviceState.Disconnected");     // Catch: Throwable -> L7
        ((DoraDeviceViewModel) this.f334235d.getValue()).startConnectOrScan("ScanDeviceDialog#onDismiss");     // Catch: Throwable -> L7
    L5:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L7:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        LarusDoraDialogScanDeviceBinding r102 = this.f334238g;
        if (r102 == null) goto L7;
        FrameLayout r103 = r102.f332502a;
        if (r103 == null) goto L7;
        r103.setOnClickListener(new com.larus.dora.impl.device.scan.a(this));
    L7:
        final ScanDeviceListAdapter r104 = new ScanDeviceListAdapter();
        Function1<? super j, Unit> r105 = new com.larus.dora.impl.device.scan.b(this, r104);
        Intrinsics.checkNotNullParameter(r105, "clickAction");
        r104.f334255b = r105;
        this.f334240i = r104;
        LarusDoraDialogScanDeviceBinding r106 = this.f334238g;
        if (r106 == null) goto L12;
        RecyclerView r107 = r106.f332503b;
        if (r107 == null) goto L12;
        r107.setLayoutManager(new LinearLayoutManager(r107.getContext()));
        r107.setAdapter(this.f334240i);
    L12:
        this.f334241j.set(false);
        kj4.a.g().registerDoraLinkCallback(this.f334242k);
        Lifecycle.State r108 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ScanDeviceDialog$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r108, null, this), 3, null);
    }

    public static final Object S90(ScanDeviceDialog r100, DoraDevice r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof ScanDeviceDialog$connect$1) == false) goto L7;
        ScanDeviceDialog$connect$1 r103 = (ScanDeviceDialog$connect$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L16;
        if (r107 == 1) goto L15;
        if (r107 != 2) goto L14;
        ResultKt.throwOnFailure(r105);
    L24:
        Unit r108 = (Unit) r105;
    L26:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r101 = (DoraDevice) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L19:
        BindAndConnectResult r109 = (BindAndConnectResult) r105;
        r100.f334241j.set(false);
        if (r100.getActivity() == null) goto L26;
        MainCoroutineDispatcher r110 = Dispatchers.getMain();
        ScanDeviceDialog$connect$2$1 r111 = new ScanDeviceDialog$connect$2$1(r109, r100, r101, null);
        r103.L$0 = null;
        r103.label = 2;
        r105 = BuildersKt.withContext(r110, r111, r103);
        if (r105 != r106) goto L24;
        return r106;
    L16:
        ResultKt.throwOnFailure(r105);
        r100.f334241j.set(true);
        kj4.a r112 = kj4.a.g();
        r103.L$0 = r101;
        r103.label = 1;
        r105 = DoraAdapterExtKt.a(r112, r101, r103);
        if (r105 != r106) goto L19;
        return r106;
    L7:
        r103 = new ScanDeviceDialog$connect$1(r100, r102);
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r110) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r102 = r100.inflate(R.layout.larus_dora_dialog_scan_device, r101, false);
        int r103 = R.id.container_layout;
        RoundLinearLayout r111 = (RoundLinearLayout) ViewBindings.findChildViewById(r102, R.id.container_layout);
        if (r111 == null) goto L28;
        r103 = R.id.device_list_recycler_view;
        RecyclerView r104 = (RecyclerView) ViewBindings.findChildViewById(r102, R.id.device_list_recycler_view);
        if (r104 == null) goto L28;
        r103 = R.id.find_device_hint;
        if (((TextView) ViewBindings.findChildViewById(r102, R.id.find_device_hint)) == null) goto L28;
        FrameLayout r105 = (FrameLayout) r102;
        LarusDoraDialogScanDeviceBinding r106 = new LarusDoraDialogScanDeviceBinding(r105, r111, r104);
        Dialog r107 = getDialog();
        if (r107 == null) goto L11;
        r107.setCanceledOnTouchOutside(true);
    L11:
        Dialog r108 = getDialog();
        if (r108 == null) goto L25;
        Window r109 = r108.getWindow();
        if (r109 == null) goto L25;
        r109.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(requireContext(), android.R.color.transparent)));
        r109.setFlags(512, 512);
        if ((getResources().getConfiguration().uiMode & 48) != 32) goto L18;
        boolean r112 = true;
    L19:
        WindowCompat.setDecorFitsSystemWindows(r109, false);
        r109.setStatusBarColor(Color.argb(1, 255, 255, 255));
        View r113 = r109.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L24;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r114 = ThreadMethodProxy.currentThread();
        if (r114 == com.larus.home.impl.utils.c.f346341a) goto L24;
        com.larus.home.impl.utils.c.a(r114, "getDecorView");
    L24:
        WindowCompat.getInsetsController(r109, r113).setAppearanceLightStatusBars(!r112);
        goto L25
    L18:
        r112 = false;
    L25:
        i0.f375410a.getClass();
        int r115 = i0.g();
        int r116 = r111.getPaddingStart();
        int r117 = r111.getPaddingEnd();
        int r118 = r111.getPaddingBottom();
        FLogger.f375446a.i("updatePaddingRelative", "view:" + r111.getClass().getSimpleName() + ",source:,start:" + r116 + ",top:" + r115 + ",end:" + r117 + ",bottom:" + r118);
        r111.setPaddingRelative(r116, r115, r117, r118);
        this.f334238g = r106;
        return r105;
    L28:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }
}
