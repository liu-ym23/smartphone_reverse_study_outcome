package com.larus.dora.impl.onboarding.lite;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.viewbinding.ViewBindings;
import com.byted.cast.common.bean.State;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.router.SmartRouter;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.dora.impl.databinding.LarusDoraOnboardingDeviceFoundBinding;
import com.larus.dora.impl.dynamic.n1;
import com.larus.dora.impl.onboarding.DoraOnboardingDevice;
import com.larus.dora.impl.view.DoraMovieView;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import v19.i5;

/* JADX INFO: loaded from: classes27.dex */
@Deprecated(message = "This fragment is only used in DoraDeviceFragment, and DoraDeviceFragment is deprecated.")
@Metadata(d1 = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u0011\b\u0007\u0018\u0000 .2\u00020\u0001:\u0002-.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0016J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010 \u001a\u00020\u001eH\u0016J\b\u0010!\u001a\u00020\u001eH\u0016J\b\u0010\"\u001a\u00020\u001eH\u0016J\u0012\u0010#\u001a\u00020\u001e2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\nH\u0002J\b\u0010(\u001a\u00020\u001eH\u0002J\b\u0010)\u001a\u00020\u001eH\u0002J\u0016\u0010*\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020%H\u0082@¢\u0006\u0002\u0010+J\u0010\u0010,\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020%H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012¨\u0006/"}, d2 = {"Lcom/larus/dora/impl/onboarding/lite/DoraLiteOnboardingConnectDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraOnboardingDeviceFoundBinding;", "interruptDialog", "Lcom/larus/common_ui/dialog/CommonDialog;", "needUnbindDialog", "state", "Lcom/larus/dora/impl/onboarding/lite/DoraLiteOnboardingConnectDialogFragment$UiState;", "enterPageTraced", "", "newMultiDevice", "doraOnboardingDevice", "Lcom/larus/dora/impl/onboarding/DoraOnboardingDevice;", "doraLinkCallback", "com/larus/dora/impl/onboarding/lite/DoraLiteOnboardingConnectDialogFragment$doraLinkCallback$1", "Lcom/larus/dora/impl/onboarding/lite/DoraLiteOnboardingConnectDialogFragment$doraLinkCallback$1;", "getTheme", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", WidgetCostModule.TYPE_ON_START, "onResume", "onDestroyView", "connect", "device", "Lcom/bytedance/dora/device/DoraDevice;", "updateUi", "uiState", "gotoDeviceGuide", "showInterruptDialog", "showNeedUnbindDialog", "(Lcom/bytedance/dora/device/DoraDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "replaceAndConnect", "UiState", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraLiteOnboardingConnectDialogFragment extends BottomSheetDialogFragment {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f336864l = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LarusDoraOnboardingDeviceFoundBinding f336865d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CommonDialog f336866e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CommonDialog f336867f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public UiState f336868g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f336869h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f336870i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public DoraOnboardingDevice f336871j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final DoraLiteOnboardingConnectDialogFragment$doraLinkCallback$1 f336872k;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/dora/impl/onboarding/lite/DoraLiteOnboardingConnectDialogFragment$UiState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "CONNECTING", "CONNECTED", State.DISCONNECTED, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum UiState extends Enum<UiState> {
        public static final UiState CONNECTED = null;
        public static final UiState CONNECTING = null;
        public static final UiState DISCONNECTED = null;
        public static final UiState IDLE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ UiState[] f336873a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f336874b = null;

        public static EnumEntries<UiState> getEntries() {
            return f336874b;
        }

        static {
            UiState r100 = new UiState("IDLE", 0);
            IDLE = r100;
            UiState r101 = new UiState("CONNECTING", 1);
            CONNECTING = r101;
            UiState r102 = new UiState("CONNECTED", 2);
            CONNECTED = r102;
            UiState r103 = new UiState(State.DISCONNECTED, 3);
            DISCONNECTED = r103;
            UiState[] r104 = {r100, r101, r102, r103};
            f336873a = r104;
            f336874b = EnumEntriesKt.enumEntries(r104);
        }

        public static UiState[] values() {
            return (UiState[]) f336873a.clone();
        }

        public static UiState valueOf(String r100) {
            return (UiState) r27.a.a(UiState.class, r100);
        }

        public UiState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f336875a = null;

        static {
            int[] r100 = new int[UiState.values().length];
            r100[UiState.IDLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[UiState.CONNECTING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[UiState.CONNECTED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[UiState.DISCONNECTED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f336875a = r100;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoraLiteOnboardingConnectDialogFragment f336876a;

        public c(DoraLiteOnboardingConnectDialogFragment r100) {
            this.f336876a = r100;
        }

        public final void a() {
            DoraLiteOnboardingConnectDialogFragment r100 = this.f336876a;
            int r101 = DoraLiteOnboardingConnectDialogFragment.f336864l;
            r100.getClass();
            Bundle r102 = r100.getArguments();     // Catch: Throwable -> L26
            String r103 = null;
            if (r102 == null) goto L7;
            DoraOnboardingDevice r104 = (DoraOnboardingDevice) r102.getParcelable("key_dora_onboarding_device");     // Catch: Throwable -> L26
        L8:
            Bundle r105 = r100.getArguments();     // Catch: Throwable -> L26
            if (r105 == null) goto L11;
            String r106 = r105.getString("key_dora_onboarding_origin_from");     // Catch: Throwable -> L26
        L12:
            Context r107 = r100.getContext();     // Catch: Throwable -> L26
            if (r107 != null) goto L16;
            return;
        L16:
            if (r100.f336870i == false) goto L24;
            Intent r108 = new Intent("action.DEVICE_UPDATE_DYNAMIC");     // Catch: Throwable -> L26
            if (r104 == null) goto L20;
            r103 = r104.f336552b;     // Catch: Throwable -> L26
        L20:
            r108.putExtra("mac", r103);     // Catch: Throwable -> L26
            LocalBroadcastManager.getInstance(AppHost.f326268a.getApplication()).sendBroadcast(r108);     // Catch: Throwable -> L26
            if (Intrinsics.areEqual(r106, "device_manage") == false) goto L23;
            g49.d.d("DoraOnboardingConnectDialogFragment", "from page : " + r106);     // Catch: Throwable -> L26
            goto L24
        L23:
            n1.i();     // Catch: Throwable -> L26
        L24:
            com.bytedance.router.i r109 = SmartRouter.buildRoute(r107, "//dora_onboarding_v2");     // Catch: Throwable -> L26
            r109.f267555d = R.anim.larus_dora_router_slide_in_bottom;     // Catch: Throwable -> L26
            r109.f267556e = R.anim.larus_router_no_anim;     // Catch: Throwable -> L26
            r109.f267554c.putExtra("key_dora_onboarding_device", r104);     // Catch: Throwable -> L26
            r109.d();     // Catch: Throwable -> L26
            DoraLiteOnboardingConnectDialogFragment.S90(r100);     // Catch: Throwable -> L26
            return;
        L11:
            r106 = null;
            goto L12
        L7:
            r104 = null;
        L26:
            th = move-exception;
            g49.d.c("DoraOnboardingConnectDialogFragment", "gotoDeviceGuide: exception", th);
            DoraLiteOnboardingConnectDialogFragment.S90(r100);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // androidx.fragment.app.DialogFragment
    public final int getTheme() {
        return R.style.BottomSheetTransparentDialog_Dora_Onboarding;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingConnectDialogFragment$doraLinkCallback$1] */
    public DoraLiteOnboardingConnectDialogFragment() {
        this.f336868g = UiState.IDLE;
        this.f336872k = new DoraLiteOnboardingConnectDialogFragment$doraLinkCallback$1(this);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        kj4.a.g().unregisterDoraLinkCallback(this.f336872k);
        LarusDoraOnboardingDeviceFoundBinding r100 = this.f336865d;
        if (r100 == null) goto L8;
        DoraMovieView r101 = r100.f332791e;
        if (r101 == null) goto L9;
        r101.g();
        r101.f();
        return;
    L9:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (this.f336869h == true) goto L6;
        j49.a.g("", "earphone_connection");
        this.f336869h = true;
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r100 = getDialog();
        if (r100 == null) goto L6;
        BottomSheetBehavior.from(r100.findViewById(R.id.design_bottom_sheet)).setHideable(false);
        return;
    }

    public static void S90(DoraLiteOnboardingConnectDialogFragment r100) {
        r100.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L11;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void T90(UiState r100) {
        this.f336868g = r100;
        int r101 = b.f336875a[r100.ordinal()];
        if (r101 != 1) goto L5;
        LarusDoraOnboardingDeviceFoundBinding r102 = this.f336865d;
        if (r102 == null) goto L46;
        LinearLayoutCompat r103 = r102.f332790d;
        if (r103 == null) goto L46;
        e1.o(r103);
    L46:
        LarusDoraOnboardingDeviceFoundBinding r104 = this.f336865d;
        if (r104 == null) goto L61;
        AppCompatTextView r105 = r104.f332789c;
        if (r105 == null) goto L62;
        e1.x(r105);
        return;
    L62:
        return;
    L61:
        return;
    L5:
        if (r101 != 2) goto L7;
        LarusDoraOnboardingDeviceFoundBinding r106 = this.f336865d;
        if (r106 == null) goto L36;
        LinearLayoutCompat r107 = r106.f332790d;
        if (r107 == null) goto L36;
        e1.x(r107);
    L36:
        LarusDoraOnboardingDeviceFoundBinding r108 = this.f336865d;
        if (r108 == null) goto L58;
        AppCompatTextView r109 = r108.f332789c;
        if (r109 == null) goto L59;
        e1.o(r109);
        return;
    L59:
        return;
    L58:
        return;
    L7:
        if (r101 != 3) goto L9;
        boolean r110 = com.larus.dora.impl.onboarding.d.f336616a;
        com.larus.dora.impl.onboarding.d.f336619d = SystemClock.elapsedRealtime();
        CommonDialog r111 = this.f336866e;
        if (r111 != null) goto L52;
    L30:
        new Handler(Looper.getMainLooper()).postDelayed(new c(this), 200);
        return;
    L52:
        r111.dismissAllowingStateLoss();     // Catch: Exception -> L26
    L26:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r112 = DialogFragmentLancet.sLastShowStack;
        if (r112 == null) goto L30;
        com.bytedance.crash.d.d(r112, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L30
    L9:
        if (r101 != 4) goto L21;
        LarusDoraOnboardingDeviceFoundBinding r113 = this.f336865d;
        if (r113 == null) goto L15;
        LinearLayoutCompat r114 = r113.f332790d;
        if (r114 == null) goto L15;
        e1.o(r114);
    L15:
        LarusDoraOnboardingDeviceFoundBinding r115 = this.f336865d;
        if (r115 == null) goto L54;
        AppCompatTextView r116 = r115.f332789c;
        if (r116 == null) goto L55;
        e1.x(r116);
        return;
    L55:
        return;
    L54:
        return;
    L21:
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r110) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r110);
        Dialog r101 = getDialog();
        if ((r101 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r102 = (BottomSheetDialog) r101;
    L6:
        if (r102 == null) goto L8;
        View r103 = r102.findViewById(R.id.design_bottom_sheet);
    L9:
        int r111 = com.larus.utils.m0.f375450a;
        int r112 = com.larus.utils.m0.a(getContext());
        com.larus.utils.i0.f375410a.getClass();
        int r113 = ((r112 - com.larus.utils.i0.g()) - com.larus.utils.i0.e()) - i5.c0();
        if (r103 == null) goto L12;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        r104.height = r113;
        r103.setLayoutParams(r104);
        BottomSheetBehavior r105 = BottomSheetBehavior.from(r103);
        r103.setBackgroundResource(android.R.color.transparent);
        r105.setState(3);
        r105.setPeekHeight(r113);
    L12:
        Bundle r106 = getArguments();
        if (r106 == null) goto L15;
        final DoraOnboardingDevice r107 = (DoraOnboardingDevice) r106.getParcelable("key_dora_onboarding_device");
    L16:
        Bundle r114 = getArguments();
        boolean r108 = false;
        if (r114 == null) goto L19;
        boolean r115 = r114.getBoolean("key_dora_onboarding_auto_connect", false);
    L20:
        this.f336871j = r107;
        Bundle r109 = getArguments();
        if (r109 == null) goto L23;
        r108 = r109.getBoolean("key_dora_is_new_multi_device", false);
    L23:
        this.f336870i = r108;
        final LarusDoraOnboardingDeviceFoundBinding r116 = this.f336865d;
        if (r116 == null) goto L26;
        e1.d(r116.f332788b, new com.larus.dora.impl.onboarding.lite.a(this));
        e1.d(r116.f332789c, new com.larus.dora.impl.onboarding.lite.b(r107, this));
        r116.f332791e.post(new com.larus.dora.impl.onboarding.lite.c(r107, r116));
    L26:
        kj4.a.g().registerDoraLinkCallback(this.f336872k);
        if (r115 == false) goto L36;
        if (r107 == null) goto L30;
        DoraDevice r117 = com.larus.dora.impl.onboarding.x.b(r107);
    L31:
        StringBuilder r118 = new StringBuilder("auto connect ");
        if (r117 == null) goto L34;
        String r119 = o59.a.h(r117);
    L35:
        r118.append(r119);
        g49.d.d("DoraOnboardingConnectDialogFragment", r118.toString());
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DoraLiteOnboardingConnectDialogFragment$connect$1(this, r117, null), 3, null);
        return;
    L34:
        r119 = null;
        goto L35
    L30:
        r117 = null;
        goto L31
    L36:
        T90(UiState.IDLE);
        return;
    L19:
        r115 = false;
        goto L20
    L15:
        r107 = null;
        goto L16
    L8:
        r103 = null;
        goto L9
    L5:
        r102 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r110) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r102 = r100.inflate(R.layout.larus_dora_onboarding_device_found, r101, false);
        int r103 = R.id.dora_onboarding_close_btn;
        ImageView r104 = (ImageView) ViewBindings.findChildViewById(r102, R.id.dora_onboarding_close_btn);
        if (r104 == null) goto L17;
        r103 = R.id.dora_onboarding_connect_btn;
        AppCompatTextView r105 = (AppCompatTextView) ViewBindings.findChildViewById(r102, R.id.dora_onboarding_connect_btn);
        if (r105 == null) goto L17;
        r103 = R.id.dora_onboarding_connecting;
        LinearLayoutCompat r106 = (LinearLayoutCompat) ViewBindings.findChildViewById(r102, R.id.dora_onboarding_connecting);
        if (r106 == null) goto L17;
        r103 = R.id.dora_onboarding_device_mv;
        DoraMovieView r107 = (DoraMovieView) ViewBindings.findChildViewById(r102, R.id.dora_onboarding_device_mv);
        if (r107 == null) goto L17;
        r103 = R.id.dora_onboarding_device_mv_layout;
        FrameLayout r108 = (FrameLayout) ViewBindings.findChildViewById(r102, R.id.dora_onboarding_device_mv_layout);
        if (r108 == null) goto L17;
        r103 = R.id.dora_onboarding_title;
        if (((AppCompatTextView) ViewBindings.findChildViewById(r102, R.id.dora_onboarding_title)) == null) goto L17;
        FrameLayout r109 = (FrameLayout) r102;
        this.f336865d = new LarusDoraOnboardingDeviceFoundBinding(r109, r104, r105, r106, r107, r108);
        return r109;
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }
}
