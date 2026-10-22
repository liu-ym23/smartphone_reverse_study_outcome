package com.larus.dora.impl.device.settings.lab.headcontrol.settings;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.dora.impl.databinding.LarusDoraPageHeadControlSettingsBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.device.settings.lab.headcontrol.HeadControlGestureType;
import com.larus.nova.R;
import com.larus.utils.e1;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u000f\u0010\u001f\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\u0017H\u0002J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\rH\u0002J\b\u0010'\u001a\u00020\u0017H\u0002J\b\u0010(\u001a\u00020\u0017H\u0002J\b\u0010)\u001a\u00020\u0017H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/larus/dora/impl/device/settings/lab/headcontrol/settings/HeadControlSettingsFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageHeadControlSettingsBinding;", "viewModel", "Lcom/larus/dora/impl/device/settings/lab/headcontrol/settings/HeadControlSettingsViewModel;", "getViewModel", "()Lcom/larus/dora/impl/device/settings/lab/headcontrol/settings/HeadControlSettingsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "isSyncingBehaviorAware", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "getCurrentPageName", "", "getPageMaskView", "setupTitle", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "bindActions", "()Lkotlin/Unit;", "observeState", "openOptionPage", "type", "Lcom/larus/dora/impl/device/settings/lab/headcontrol/HeadControlGestureType;", "renderBehaviorAwareBanner", "show", "showBehaviorAwareEnableDialog", "syncBehaviorAwareThenRefresh", "onDestroyView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HeadControlSettingsFragment extends DoraBaseFragment {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f334744i = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LarusDoraPageHeadControlSettingsBinding f334745f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f334746g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f334747h;

    public static final class a {
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        return "head_control_settings";
    }

    static {
        f334744i = Color.rgb(152, 102, 65);
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        LarusDoraPageHeadControlSettingsBinding r100 = this.f334745f;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f332979b;
    }

    public final HeadControlSettingsViewModel W90() {
        return (HeadControlSettingsViewModel) this.f334746g.getValue();
    }

    public HeadControlSettingsFragment() {
        final Function0<Fragment> r100 = new HeadControlSettingsFragment$special$$inlined$viewModels$default$1(this);
        this.f334746g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(HeadControlSettingsViewModel.class), new HeadControlSettingsFragment$special$$inlined$viewModels$default$2(r100), new HeadControlSettingsFragment$special$$inlined$viewModels$default$3(r100, this));
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f334745f = null;
    }

    @Override // com.larus.trace.tracknode.TraceFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        W90().refreshBehaviorAwareBannerState();
    }

    public final void X90(HeadControlGestureType r100) {
        g49.d.d("HeadControlSettings", "open option page, type=" + r100);
        com.bytedance.router.i r101 = SmartRouter.buildRoute(getContext(), "//flow/dora/lab_head_control_option");
        Bundle r102 = com.larus.utils.f.c(new Pair[0]);
        by7.h.k(r102, this);
        r101.f267554c.putExtras(r102);
        r101.f267554c.putExtra("arg_gesture_type", r100.name());
        r101.f267555d = R.anim.larus_router_slide_in_right;
        r101.f267556e = R.anim.larus_router_no_anim;
        r101.d();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        LarusDoraPageHeadControlSettingsBinding r112 = this.f334745f;
        if (r112 == null) goto L7;
        NovaTitleBarEx r100 = r112.f332986i;
        if (r100 == null) goto L7;
        NovaTitleBarEx.Y5(r100, getString(R.string.larus_dora_g_head_control_cn), null, null, 6);
        NovaTitleBarEx.b6(r100, R.drawable.larus_dora_ic_left_back, false, null, null, new com.larus.dora.impl.device.settings.lab.headcontrol.settings.a(this), 14);
    L7:
        LarusDoraPageHeadControlSettingsBinding r113 = this.f334745f;
        if (r113 == null) goto L10;
        e1.d(r113.f332983f, new b(this));
        e1.d(r113.f332985h, new c(this));
        r113.f332984g.setTextColor(v19.c.a(R.attr.larus_primary_50, r113.f332978a.getContext(), R.color.larus_primary_50));
        e1.d(r113.f332984g, new d(this));
        Unit r114 = Unit.INSTANCE;
    L10:
        Lifecycle.State r115 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new HeadControlSettingsFragment$observeState$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r115, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new HeadControlSettingsFragment$observeState$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r115, null, this), 3, null);
        W90().loadHeadGestureOptions();
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        View r113 = r110.inflate(R.layout.larus_dora_page_head_control_settings, r111, false);
        int r114 = R.id.dora_page_mask;
        View r100 = ViewBindings.findChildViewById(r113, R.id.dora_page_mask);
        if (r100 == null) goto L21;
        r114 = R.id.head_control_behavior_notice_banner;
        ConstraintLayout r101 = (ConstraintLayout) ViewBindings.findChildViewById(r113, R.id.head_control_behavior_notice_banner);
        if (r101 == null) goto L21;
        r114 = R.id.head_control_behavior_notice_btn;
        TextView r102 = (TextView) ViewBindings.findChildViewById(r113, R.id.head_control_behavior_notice_btn);
        if (r102 == null) goto L21;
        r114 = R.id.head_control_behavior_notice_text;
        TextView r103 = (TextView) ViewBindings.findChildViewById(r113, R.id.head_control_behavior_notice_text);
        if (r103 == null) goto L21;
        r114 = R.id.head_control_nod_item;
        ItemTextArrow r104 = (ItemTextArrow) ViewBindings.findChildViewById(r113, R.id.head_control_nod_item);
        if (r104 == null) goto L21;
        r114 = R.id.head_control_practice_btn;
        ItemTextArrow r105 = (ItemTextArrow) ViewBindings.findChildViewById(r113, R.id.head_control_practice_btn);
        if (r105 == null) goto L21;
        r114 = R.id.head_control_shake_item;
        ItemTextArrow r106 = (ItemTextArrow) ViewBindings.findChildViewById(r113, R.id.head_control_shake_item);
        if (r106 == null) goto L21;
        r114 = R.id.title;
        NovaTitleBarEx r107 = (NovaTitleBarEx) ViewBindings.findChildViewById(r113, R.id.title);
        if (r107 == null) goto L21;
        ConstraintLayout r115 = (ConstraintLayout) r113;
        this.f334745f = new LarusDoraPageHeadControlSettingsBinding(r115, r100, r101, r102, r103, r104, r105, r106, r107);
        return r115;
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r113.getResources().getResourceName(r114)));
    }
}
