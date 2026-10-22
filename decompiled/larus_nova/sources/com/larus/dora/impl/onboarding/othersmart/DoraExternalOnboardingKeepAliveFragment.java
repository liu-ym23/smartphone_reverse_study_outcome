package com.larus.dora.impl.onboarding.othersmart;

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
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.CircleSimpleDraweeView;
import com.larus.dora.impl.databinding.LarusDoraOnboardingV2KeepAliveScrollableBinding;
import com.larus.dora.impl.nl.DoraUserSettingsManager;
import com.larus.dora.impl.onboarding.DoraOnboardingDevice;
import com.larus.dora.impl.onboarding.DoraOnboardingKeepAliveViewModel;
import com.larus.dora.impl.onboarding.othersmart.streamlined.DoraHStreamlinedCompletionFragment;
import com.larus.dora.impl.onboarding.othersmart.streamlined.DoraHStreamlinedOnboardingViewModel;
import com.larus.dora.impl.settings.DoraSetting;
import com.larus.dora.impl.view.DoraItemTextToggleSubTitle;
import com.larus.dora.impl.view.DoraUrlSpanTextView;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.obric.assistant.spi.dora.IObricDoraService;
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
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 22\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J&\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u001c2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010#\u001a\u00020\u0018H\u0002J\b\u0010$\u001a\u00020\u0018H\u0002J\b\u0010%\u001a\u00020\u0018H\u0002J\u0012\u0010&\u001a\u00020\u00182\b\u0010'\u001a\u0004\u0018\u00010(H\u0002J\b\u0010)\u001a\u00020\u0018H\u0002J\b\u0010*\u001a\u00020\u0018H\u0002J\u0010\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020(H\u0016J\n\u00101\u001a\u0004\u0018\u00010(H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/larus/dora/impl/onboarding/othersmart/DoraExternalOnboardingKeepAliveFragment;", "Lcom/larus/dora/impl/onboarding/othersmart/DoraExternalOnboardingBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraOnboardingV2KeepAliveScrollableBinding;", "keepAliveModel", "Lcom/larus/dora/impl/onboarding/DoraOnboardingKeepAliveViewModel;", "getKeepAliveModel", "()Lcom/larus/dora/impl/onboarding/DoraOnboardingKeepAliveViewModel;", "keepAliveModel$delegate", "Lkotlin/Lazy;", "streamlinedModel", "Lcom/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedOnboardingViewModel;", "getStreamlinedModel", "()Lcom/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedOnboardingViewModel;", "streamlinedModel$delegate", "waitCdmOnJob", "Lkotlinx/coroutines/Job;", "cdmSwitch", "Lcom/larus/dora/impl/view/DoraItemTextToggleSubTitle;", "notificationSwitch", "Lcom/larus/bmhome/view/item/ItemTextToggle;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "goNextPage", "goNotificationGuidePage", "initDoraKeepAliveCdm", "updateCdmEnableDeviceDesc", "deviceName", "", "initDoraNotification", "setupAvatar", "onAttach", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "shouldShowSkipButton", "", "getCurrentPageName", "getCurrentCardName", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraExternalOnboardingKeepAliveFragment extends DoraExternalOnboardingBaseFragment {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f337046u = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public LarusDoraOnboardingV2KeepAliveScrollableBinding f337047o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f337048p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f337049q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Job f337050r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public DoraItemTextToggleSubTitle f337051s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ItemTextToggle f337052t;

    public static final class a {
    }

    public static final class b<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoraExternalOnboardingKeepAliveFragment f337053a;

        public b(DoraExternalOnboardingKeepAliveFragment r100) {
            this.f337053a = r100;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object r100, Continuation r101) {
            DoraOnboardingKeepAliveViewModel.AuthButtonState r102 = (DoraOnboardingKeepAliveViewModel.AuthButtonState) r100;
            DoraExternalOnboardingKeepAliveFragment r103 = this.f337053a;
            int r104 = DoraExternalOnboardingKeepAliveFragment.f337046u;
            TextView r105 = r103.f336547h;
            if (r105 == null) goto L6;
            r105.setText(r102.getResId());
        L6:
            return Unit.INSTANCE;
        }
    }

    static {
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final String V90() {
        return null;
    }

    @Override // com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingBaseFragment, com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final boolean ba0() {
        return false;
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        return "keep_active";
    }

    public final DoraOnboardingKeepAliveViewModel fa0() {
        return (DoraOnboardingKeepAliveViewModel) this.f337048p.getValue();
    }

    public final void ga0() {
        DoraUserSettingsManager r100 = DoraUserSettingsManager.f336185a;
        IObricDoraService r101 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r101 == null) goto L7;
        boolean r102 = true;
        if (r101.n() != true) goto L7;
    L8:
        if (r102 == false) goto L10;
        g49.d.d("DoraExternalOnboardingBaseFragment", "skip notification guide for OBRIC proactive setting hidden");
    L10:
        if (r102 == false) goto L15;
        DoraSetting.f338023a.getClass();
        if (DoraSetting.m() == false) goto L14;
        Z90(new DoraHStreamlinedCompletionFragment());
        return;
    L14:
        da0();
        return;
    L15:
        DoraHOnboardingNotificationGuideFragment r103 = new DoraHOnboardingNotificationGuideFragment();
        Bundle r104 = new Bundle();
        r104.putString("arg_card_name", null);
        r103.setArguments(r104);
        Z90(r103);
        return;
    L7:
        r102 = false;
        goto L8
    }

    public DoraExternalOnboardingKeepAliveFragment() {
        this.f337048p = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraOnboardingKeepAliveViewModel.class), new DoraExternalOnboardingKeepAliveFragment$special$$inlined$activityViewModels$default$1(this), new DoraExternalOnboardingKeepAliveFragment$special$$inlined$activityViewModels$default$2(this));
        this.f337049q = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraHStreamlinedOnboardingViewModel.class), new DoraExternalOnboardingKeepAliveFragment$special$$inlined$activityViewModels$default$3(this), new DoraExternalOnboardingKeepAliveFragment$special$$inlined$activityViewModels$default$4(this));
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.onAttach(r100);
        fa0().createCompanionDeviceAssociator(this);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        ca0().exitOnboardingMode();
    }

    @Override // com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingBaseFragment, com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        LarusDoraOnboardingV2KeepAliveScrollableBinding r112 = this.f337047o;
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
        if (fa0().isCdmSwitchExposed() == false) goto L48;
        g49.d.d("DoraExternalOnboardingKeepAliveFragment", "cdm switch exposed");
        DoraItemTextToggleSubTitle r102 = new DoraItemTextToggleSubTitle(r114);
        r102.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r102.setText(getString(R.string.larus_dora_keep_alive_ongoing_cdm_title_cn));
        r102.setTextFontWeight(500);
        this.f337051s = r102;
        DoraOnboardingDevice r103 = ca0().getDoraOnboardingDevice();
        if (r103 == null) goto L16;
        String r104 = r103.f336551a;
    L17:
        if (r104 != null) goto L19;
    L22:
        boolean r105 = true;
    L23:
        if (r105 == true) goto L32;
        DoraItemTextToggleSubTitle r106 = this.f337051s;
        if (r106 == null) goto L27;
        r106.setSubTitle(getString(R.string.larus_dora_keep_alive_cdn_associate_device_name_cn) + r104);
    L27:
        DoraItemTextToggleSubTitle r107 = this.f337051s;
        if (r107 == null) goto L37;
        TextView r108 = r107.getSubTitle();
        if (r108 == null) goto L37;
        e1.x(r108);
    L37:
        DoraItemTextToggleSubTitle r109 = this.f337051s;
        if (r109 == null) goto L42;
        CustomSwitchCompat r115 = r109.getToggleView();
        if (r115 == null) goto L42;
        r115.setChecked(true);
    L42:
        DoraItemTextToggleSubTitle r116 = this.f337051s;
        if (r116 == null) goto L45;
        r116.getToggleView().setOnCheckedChangeListener(new e(this));
    L45:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraExternalOnboardingKeepAliveFragment$initDoraKeepAliveCdm$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, Lifecycle.State.STARTED, null, this), 3, null);
        ItemGroup r117 = this.f336545f;
        if (r117 == null) goto L49;
        r117.addView(this.f337051s);
    L49:
        ItemTextToggle r118 = new ItemTextToggle(r114);
        r118.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r118.setText(getString(R.string.larus_dora_keep_alive_ongoing_notification_title_cn));
        r118.setTextFontWeight(500);
        this.f337052t = r118;
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
        DoraItemTextToggleSubTitle r124 = this.f337051s;
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
        fa0().setCdmSwitchOn(false);
    L66:
        TextView r126 = this.f336547h;
        if (r126 == null) goto L69;
        e1.x(r126);
        r126.setText(R.string.larus_dora_onboarding_goto_keep_alive_btn_cn);
        e1.d(r126, new c(this));
    L69:
        Lifecycle.State r127 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraExternalOnboardingKeepAliveFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r127, null, this), 3, null);
        FragmentActivity r128 = getActivity();
        if (r128 == null) goto L74;
        TextView r129 = (TextView) r128.findViewById(R.id.dora_onboarding_later_btn);
        if (r129 == null) goto L74;
        e1.x(r129);
        r129.setText(R.string.larus_dora_btn_setup_later_cn);
        e1.d(r129, new d(this));
    L74:
        LarusDoraOnboardingV2KeepAliveScrollableBinding r130 = this.f337047o;
        if (r130 == null) goto L79;
        DoraUrlSpanTextView r131 = r130.f332823d;
        if (r131 == null) goto L79;
        int r132 = com.larus.utils.j0.f375426a;
        r131.setUrlSpannedText(com.larus.utils.j0.d(R.string.larus_dora_onboarding_keep_alive_msg_cn));
    L79:
        LarusDoraOnboardingV2KeepAliveScrollableBinding r133 = this.f337047o;
        if (r133 == null) goto L84;
        CircleSimpleDraweeView r134 = r133.f332822c;
        if (r134 == null) goto L84;
        CircleSimpleDraweeView.f(r134, UriProtector.parse("res://" + AppHost.f326268a.getApplication().getPackageName() + "/2131240621"), null, null, 0, 0, 62);
    L84:
        ((DoraHStreamlinedOnboardingViewModel) this.f337049q.getValue()).fetchAvatarUrl();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraExternalOnboardingKeepAliveFragment$setupAvatar$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r127, null, this), 3, null);
        ItemTextToggle r135 = this.f337052t;
        if (r135 == null) goto L93;
        r135.getToggleView().setChecked(true);
        r135.getToggleView().setOnCheckedChangeListener(new f(this));
        return;
    L93:
        return;
    L5:
        r113 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        LarusDoraOnboardingV2KeepAliveScrollableBinding r103 = LarusDoraOnboardingV2KeepAliveScrollableBinding.a(r100, r101);
        this.f337047o = r103;
        return r103.f332820a;
    }
}
