package com.larus.dora.impl.device.settings.lab.headcontrol.option;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextSelector;
import com.larus.dora.impl.databinding.LarusDoraPageHeadControlOptionBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.device.settings.lab.headcontrol.HeadControlActionOption;
import com.larus.dora.impl.device.settings.lab.headcontrol.HeadControlGestureType;
import com.larus.nova.R;
import com.larus.utils.e1;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u0012H\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\u000f\u0010!\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0002\u0010\"J\u0014\u0010#\u001a\u00020\u001a*\u00020\u00122\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020\u001aH\u0002J\u0010\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020%H\u0002J\b\u0010)\u001a\u00020\u001aH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f¨\u0006+"}, d2 = {"Lcom/larus/dora/impl/device/settings/lab/headcontrol/option/HeadControlOptionFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageHeadControlOptionBinding;", "viewModel", "Lcom/larus/dora/impl/device/settings/lab/headcontrol/option/HeadControlOptionViewModel;", "getViewModel", "()Lcom/larus/dora/impl/device/settings/lab/headcontrol/option/HeadControlOptionViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "gestureType", "Lcom/larus/dora/impl/device/settings/lab/headcontrol/HeadControlGestureType;", "getGestureType", "()Lcom/larus/dora/impl/device/settings/lab/headcontrol/HeadControlGestureType;", "gestureType$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "getCurrentPageName", "", "getPageMaskView", "setupTitle", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "bindOptions", "()Lkotlin/Unit;", "bindOption", "option", "Lcom/larus/dora/impl/device/settings/lab/headcontrol/HeadControlActionOption;", "observeState", "updateSelection", "selectedOption", "onDestroyView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HeadControlOptionFragment extends DoraBaseFragment {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f334725i = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LarusDoraPageHeadControlOptionBinding f334726f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f334727g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f334728h;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        LarusDoraPageHeadControlOptionBinding r100 = this.f334726f;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f332964b;
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        if (((HeadControlGestureType) this.f334728h.getValue()) != HeadControlGestureType.NOD) goto L5;
        return "head_control_nod_option";
    L5:
        return "head_control_shake_option";
    }

    public HeadControlOptionFragment() {
        final Function0<Fragment> r100 = new HeadControlOptionFragment$special$$inlined$viewModels$default$1(this);
        this.f334727g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(HeadControlOptionViewModel.class), new HeadControlOptionFragment$special$$inlined$viewModels$default$2(r100), new HeadControlOptionFragment$special$$inlined$viewModels$default$3(r100, this));
        this.f334728h = LazyKt.lazy(LazyThreadSafetyMode.NONE, new com.larus.dora.impl.device.settings.lab.headcontrol.option.a(this));
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f334726f = null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        LarusDoraPageHeadControlOptionBinding r102 = this.f334726f;
        if (r102 == null) goto L7;
        NovaTitleBarEx r103 = r102.f332968f;
        if (r103 == null) goto L7;
        NovaTitleBarEx.Y5(r103, ((HeadControlGestureType) this.f334728h.getValue()).getTitle(), null, null, 6);
        NovaTitleBarEx.b6(r103, R.drawable.larus_dora_ic_left_back, false, null, null, new b(this), 14);
    L7:
        LarusDoraPageHeadControlOptionBinding r104 = this.f334726f;
        if (r104 == null) goto L10;
        ItemTextSelector r105 = r104.f332965c;
        final HeadControlActionOption r106 = HeadControlActionOption.ACCEPT_CONFIRM;
        r105.setText(r106.getTitle());
        ItemTextSelector r107 = r104.f332967e;
        final HeadControlActionOption r108 = HeadControlActionOption.REJECT_CLOSE;
        r107.setText(r108.getTitle());
        ItemTextSelector r109 = r104.f332966d;
        final HeadControlActionOption r110 = HeadControlActionOption.NONE;
        r109.setText(r110.getTitle());
        e1.d(r104.f332965c, new c(this, r106));
        e1.d(r104.f332967e, new c(this, r108));
        e1.d(r104.f332966d, new c(this, r110));
        Unit r111 = Unit.INSTANCE;
    L10:
        Lifecycle.State r112 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new HeadControlOptionFragment$observeState$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r112, null, this), 3, null);
        ((HeadControlOptionViewModel) this.f334727g.getValue()).loadHeadGestureOptions();
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r110) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r102 = r100.inflate(R.layout.larus_dora_page_head_control_option, r101, false);
        int r103 = R.id.dora_page_mask;
        View r104 = ViewBindings.findChildViewById(r102, R.id.dora_page_mask);
        if (r104 == null) goto L19;
        r103 = R.id.head_control_accept_confirm_option;
        ItemTextSelector r105 = (ItemTextSelector) ViewBindings.findChildViewById(r102, R.id.head_control_accept_confirm_option);
        if (r105 == null) goto L19;
        r103 = R.id.head_control_none_option;
        ItemTextSelector r106 = (ItemTextSelector) ViewBindings.findChildViewById(r102, R.id.head_control_none_option);
        if (r106 == null) goto L19;
        r103 = R.id.head_control_option_group;
        if (((ItemGroup) ViewBindings.findChildViewById(r102, R.id.head_control_option_group)) == null) goto L19;
        r103 = R.id.head_control_reject_close_option;
        ItemTextSelector r107 = (ItemTextSelector) ViewBindings.findChildViewById(r102, R.id.head_control_reject_close_option);
        if (r107 == null) goto L19;
        r103 = R.id.scroll_view;
        if (((ScrollView) ViewBindings.findChildViewById(r102, R.id.scroll_view)) == null) goto L19;
        r103 = R.id.title;
        NovaTitleBarEx r108 = (NovaTitleBarEx) ViewBindings.findChildViewById(r102, R.id.title);
        if (r108 == null) goto L19;
        ConstraintLayout r109 = (ConstraintLayout) r102;
        this.f334726f = new LarusDoraPageHeadControlOptionBinding(r109, r104, r105, r106, r107, r108);
        return r109;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }
}
