package com.larus.dora.impl.onboarding.lite;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.databinding.LarusDoraOnboardingV2KeepAliveScrollableBinding;
import com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment;
import com.larus.dora.impl.onboarding.DoraOnboardingDevice;
import com.larus.dora.impl.onboarding.DoraOnboardingKeepAliveViewModel;
import com.larus.dora.impl.onboarding2.DoraOnboardingNotificationGuideFragment;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.settings.DoraPushSummaryConfig;
import com.larus.dora.impl.settings.DoraSetting;
import com.larus.dora.impl.view.DoraItemTextToggleSubTitle;
import com.larus.dora.impl.view.DoraUrlSpanTextView;
import com.larus.nova.R;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.e1;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J&\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u001e\u001a\u00020\u0013H\u0002J\b\u0010\u001f\u001a\u00020\u0013H\u0002J\b\u0010 \u001a\u00020\u0013H\u0002J\u0012\u0010!\u001a\u00020\u00132\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\b\u0010$\u001a\u00020\u0013H\u0002J\b\u0010%\u001a\u00020\u0013H\u0002J\u0010\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020#H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/larus/dora/impl/onboarding/lite/DoraLiteOnboardingKeepAliveFragment;", "Lcom/larus/dora/impl/onboarding/lite/DoraLiteOnboardingBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraOnboardingV2KeepAliveScrollableBinding;", "keepAliveModel", "Lcom/larus/dora/impl/onboarding/DoraOnboardingKeepAliveViewModel;", "getKeepAliveModel", "()Lcom/larus/dora/impl/onboarding/DoraOnboardingKeepAliveViewModel;", "keepAliveModel$delegate", "Lkotlin/Lazy;", "waitCdmOnJob", "Lkotlinx/coroutines/Job;", "cdmSwitch", "Lcom/larus/dora/impl/view/DoraItemTextToggleSubTitle;", "notificationSwitch", "Lcom/larus/bmhome/view/item/ItemTextToggle;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "goNotificationGuidePage", "goDeviceManagementPage", "initDoraKeepAliveCdm", "updateCdmEnableDeviceDesc", "deviceName", "", "initDoraNotification", "setupAvatar", "onAttach", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "shouldShowSkipButton", "", "getCurrentPageName", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraLiteOnboardingKeepAliveFragment extends DoraLiteOnboardingBaseFragment {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f336885t = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public LarusDoraOnboardingV2KeepAliveScrollableBinding f336886o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f336887p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Job f336888q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public DoraItemTextToggleSubTitle f336889r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ItemTextToggle f336890s;

    public static final class a {
    }

    public static final class b<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoraLiteOnboardingKeepAliveFragment f336891a;

        public b(DoraLiteOnboardingKeepAliveFragment r100) {
            this.f336891a = r100;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object r100, Continuation r101) {
            DoraOnboardingKeepAliveViewModel.AuthButtonState r102 = (DoraOnboardingKeepAliveViewModel.AuthButtonState) r100;
            DoraLiteOnboardingKeepAliveFragment r103 = this.f336891a;
            int r104 = DoraLiteOnboardingKeepAliveFragment.f336885t;
            TextView r105 = r103.f336547h;
            if (r105 == null) goto L6;
            r105.setText(r102.getResId());
        L6:
            return Unit.INSTANCE;
        }
    }

    static {
    }

    @Override // com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingBaseFragment, com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final boolean ba0() {
        return false;
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        return "keep_active";
    }

    public final DoraOnboardingKeepAliveViewModel ea0() {
        return (DoraOnboardingKeepAliveViewModel) this.f336887p.getValue();
    }

    public final void fa0() {
        IFlowSdkDepend r100 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r100 == null) goto L7;
        com.larus.home.impl.sdk.s r101 = r100.s0();
        if (r101 == null) goto L7;
        r101.N(this);
    L7:
        FragmentActivity r102 = getActivity();
        if (r102 == null) goto L11;
        r102.finish();
        return;
    }

    public DoraLiteOnboardingKeepAliveFragment() {
        this.f336887p = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraOnboardingKeepAliveViewModel.class), new DoraLiteOnboardingKeepAliveFragment$special$$inlined$activityViewModels$default$1(this), new DoraLiteOnboardingKeepAliveFragment$special$$inlined$activityViewModels$default$2(this));
    }

    public final void ga0() {
        if (DoraOnboardingBaseFragment.Y90() == true) goto L5;
    L8:
        DoraSetting.f338023a.getClass();
        DoraPushSummaryConfig r100 = DoraSetting.e();
        boolean r101 = false;
        if (r100.getNotificationSummary() == false) goto L11;
    L12:
        IDoraService r102 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r102 == null) goto L19;
        DeviceService r103 = r102.device();
        if (r103 == null) goto L19;
        if (r103.n0("startVUI") != true) goto L19;
        boolean r104 = true;
    L20:
        if (r104 == false) goto L22;
        r101 = true;
    L22:
        if (r101 == false) goto L24;
        Z90(new DoraOnboardingNotificationGuideFragment());
        return;
    L24:
        fa0();
        return;
    L19:
        r104 = false;
        goto L20
    L11:
        if (r100.getProactiveMessage() == false) goto L22;
    L5:
        if (DoraOnboardingBaseFragment.X90() == false) goto L8;
        g49.d.d("DoraLiteOnboardingKeepAliveFragment", "skip notification guide when dora keep alive enabled");
        fa0();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.onAttach(r100);
        ea0().createCompanionDeviceAssociator(this);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        ca0().exitOnboardingMode();
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        LarusDoraOnboardingV2KeepAliveScrollableBinding r112 = this.f336886o;
        if (r112 == null) goto L5;
        ItemGroup r113 = r112.f332824e;
    L6:
        this.f336545f = r113;
        Context r114 = getContext();
        if (r114 == null) goto L66;
        ItemGroup r100 = this.f336545f;
        if (r100 == null) goto L11;
        r100.removeAllViews();
    L11:
        int r101 = 0;
        if (ea0().isCdmSwitchExposed() == false) goto L48;
        g49.d.d("DoraLiteOnboardingKeepAliveFragment", "cdm switch exposed");
        DoraItemTextToggleSubTitle r102 = new DoraItemTextToggleSubTitle(r114);
        r102.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r102.setText(getString(R.string.larus_dora_keep_alive_ongoing_cdm_title_cn));
        r102.setTextFontWeight(500);
        this.f336889r = r102;
        DoraOnboardingDevice r103 = ca0().getDoraOnboardingDevice();
        if (r103 == null) goto L16;
        String r104 = r103.f336551a;
    L17:
        if (r104 != null) goto L19;
    L22:
        boolean r105 = true;
    L23:
        if (r105 == true) goto L32;
        DoraItemTextToggleSubTitle r106 = this.f336889r;
        if (r106 == null) goto L27;
        r106.setSubTitle(getString(R.string.larus_dora_keep_alive_cdn_associate_device_name_cn) + r104);
    L27:
        DoraItemTextToggleSubTitle r107 = this.f336889r;
        if (r107 == null) goto L37;
        TextView r108 = r107.getSubTitle();
        if (r108 == null) goto L37;
        e1.x(r108);
    L37:
        DoraItemTextToggleSubTitle r109 = this.f336889r;
        if (r109 == null) goto L42;
        CustomSwitchCompat r115 = r109.getToggleView();
        if (r115 == null) goto L42;
        r115.setChecked(true);
    L42:
        DoraItemTextToggleSubTitle r116 = this.f336889r;
        if (r116 == null) goto L45;
        r116.getToggleView().setOnCheckedChangeListener(new l(this));
    L45:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraLiteOnboardingKeepAliveFragment$initDoraKeepAliveCdm$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, Lifecycle.State.STARTED, null, this), 3, null);
        ItemGroup r117 = this.f336545f;
        if (r117 == null) goto L49;
        r117.addView(this.f336889r);
    L49:
        ItemTextToggle r118 = new ItemTextToggle(r114);
        r118.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r118.setText(getString(R.string.larus_dora_keep_alive_ongoing_notification_title_cn));
        r118.setTextFontWeight(500);
        this.f336890s = r118;
        ItemGroup r119 = this.f336545f;
        if (r119 == null) goto L52;
        r119.addView(r118);
    L52:
        ItemGroup r120 = this.f336545f;
        if (r120 == null) goto L66;
        e1.x(r120);
        int r121 = r120.getChildCount();
    L55:
        if (r101 >= r121) goto L66;
        View r122 = r120.getChildAt(r101);
        if (r121 != 1) goto L59;
        int r123 = R.drawable.larus_dora_onboarding_item_bg_shadow_round_all;
    L65:
        r122.setBackgroundResource(r123);
        r101 = r101 + 1;
        goto L55
    L59:
        if (r101 != 0) goto L62;
        r123 = R.drawable.larus_dora_onboarding_item_bg_shadow_round_up;
        goto L65
    L62:
        if (r101 != (r121 - 1)) goto L64;
        r123 = R.drawable.larus_dora_onboarding_item_bg_shadow_round_down;
        goto L65
    L64:
        r123 = R.drawable.larus_dora_onboarding_item_bg_shadow_middle;
        goto L65
    L32:
        DoraItemTextToggleSubTitle r124 = this.f336889r;
        if (r124 == null) goto L37;
        TextView r125 = r124.getSubTitle();
        if (r125 == null) goto L37;
        e1.o(r125);
        goto L37
    L19:
        if (r104.length() == 0) goto L22;
        r105 = false;
        goto L23
    L16:
        r104 = null;
        goto L17
    L48:
        ea0().setCdmSwitchOn(false);
    L66:
        TextView r126 = this.f336547h;
        if (r126 == null) goto L69;
        e1.x(r126);
        r126.setText(R.string.larus_dora_onboarding_goto_keep_alive_btn_cn);
        e1.d(r126, new j(this));
    L69:
        Lifecycle.State r127 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraLiteOnboardingKeepAliveFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r127, null, this), 3, null);
        FragmentActivity r128 = getActivity();
        if (r128 == null) goto L74;
        View r129 = r128.findViewById(R.id.dora_onboarding_later_btn);
        if (r129 == null) goto L74;
        e1.x(r129);
        e1.d(r129, new k(this));
    L74:
        LarusDoraOnboardingV2KeepAliveScrollableBinding r130 = this.f336886o;
        if (r130 == null) goto L79;
        DoraUrlSpanTextView r131 = r130.f332823d;
        if (r131 == null) goto L79;
        int r132 = com.larus.utils.j0.f375426a;
        r131.setUrlSpannedText(com.larus.utils.j0.d(R.string.larus_dora_onboarding_keep_alive_msg_cn));
    L79:
        ca0().fetchAvatarUrl();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraLiteOnboardingKeepAliveFragment$setupAvatar$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r127, null, this), 3, null);
        ItemTextToggle r133 = this.f336890s;
        if (r133 == null) goto L88;
        r133.getToggleView().setChecked(true);
        r133.getToggleView().setOnCheckedChangeListener(new m(this));
        return;
    L88:
        return;
    L5:
        r113 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        LarusDoraOnboardingV2KeepAliveScrollableBinding r103 = LarusDoraOnboardingV2KeepAliveScrollableBinding.a(r100, r101);
        this.f336886o = r103;
        return r103.f332820a;
    }
}
