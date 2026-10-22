package com.larus.dora.impl.device.settings.sound;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.dora.impl.databinding.LarusDoragPageSoundSettingsBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u0017H\u0002J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/larus/dora/impl/device/settings/sound/DoraGSoundSettingsFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoragPageSoundSettingsBinding;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/device/settings/sound/DoraGSoundSettingsViewModel;", "getModel", "()Lcom/larus/dora/impl/device/settings/sound/DoraGSoundSettingsViewModel;", "model$delegate", "Lkotlin/Lazy;", "checkedChangeListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "getCurrentPageName", "", "getPageMaskView", "setupTitle", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "setupAntiSoundLeak", "refreshAntiSoundLeakCheckedState", "state", "Lcom/larus/dora/impl/device/settings/sound/AntiSoundLeakState;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraGSoundSettingsFragment extends DoraBaseFragment {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f334890i = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LarusDoragPageSoundSettingsBinding f334891f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f334892g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f334893h;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        return "g_sound_setting";
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        LarusDoragPageSoundSettingsBinding r100 = this.f334891f;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f333334b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.dora.impl.device.settings.sound.c] */
    public DoraGSoundSettingsFragment() {
        final Function0<Fragment> r100 = new DoraGSoundSettingsFragment$special$$inlined$viewModels$default$1(this);
        this.f334892g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraGSoundSettingsViewModel.class), new DoraGSoundSettingsFragment$special$$inlined$viewModels$default$2(r100), new DoraGSoundSettingsFragment$special$$inlined$viewModels$default$3(r100, this));
        this.f334893h = new c(this);
    }

    public static final void W90(DoraGSoundSettingsFragment r100, com.larus.dora.impl.device.settings.sound.a r101) {
        LarusDoragPageSoundSettingsBinding r102 = r100.f334891f;
        if (r102 == null) goto L9;
        ItemTextToggle r103 = r102.f333335c;
        if (r103 == null) goto L9;
        CustomSwitchCompat r104 = r103.getToggleView();
        if (r104 == null) goto L9;
        r104.setOnCheckedChangeListener(null);
    L9:
        LarusDoragPageSoundSettingsBinding r105 = r100.f334891f;
        if (r105 == null) goto L16;
        ItemTextToggle r106 = r105.f333335c;
        if (r106 == null) goto L16;
        CustomSwitchCompat r107 = r106.getToggleView();
        if (r107 == null) goto L16;
        r107.setChecked(Intrinsics.areEqual(r101, com.larus.dora.impl.device.settings.sound.a.b.f334908a));
    L16:
        LarusDoragPageSoundSettingsBinding r108 = r100.f334891f;
        if (r108 == null) goto L24;
        ItemTextToggle r109 = r108.f333335c;
        if (r109 == null) goto L25;
        CustomSwitchCompat r110 = r109.getToggleView();
        if (r110 == null) goto L26;
        r110.setOnCheckedChangeListener(r100.f334893h);
        return;
    L26:
        return;
    L25:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        LarusDoragPageSoundSettingsBinding r112 = this.f334891f;
        if (r112 == null) goto L5;
        NovaTitleBarEx r100 = r112.f333336d;
        NovaTitleBarEx.Y5(r100, getString(R.string.larus_dora_settings_sound_cn), null, null, 6);
        NovaTitleBarEx.b6(r100, R.drawable.larus_dora_ic_left_back, false, null, null, new d(this), 14);
    L5:
        LarusDoragPageSoundSettingsBinding r113 = this.f334891f;
        if (r113 == null) goto L12;
        ItemTextToggle r114 = r113.f333335c;
        if (r114 == null) goto L12;
        CustomSwitchCompat r115 = r114.getToggleView();
        if (r115 == null) goto L12;
        r115.setOnCheckedChangeListener(this.f334893h);
    L12:
        Lifecycle.State r116 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraGSoundSettingsFragment$setupAntiSoundLeak$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r116, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraGSoundSettingsFragment$setupAntiSoundLeak$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r116, null, this), 3, null);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.larus_dorag_page_sound_settings, r101, false);
        int r104 = R.id.dora_page_mask;
        View r105 = ViewBindings.findChildViewById(r103, R.id.dora_page_mask);
        if (r105 == null) goto L17;
        r104 = R.id.dorag_anti_sound_leak_group;
        if (((ItemGroup) ViewBindings.findChildViewById(r103, R.id.dorag_anti_sound_leak_group)) == null) goto L17;
        r104 = R.id.dorag_anti_sound_leak_hint;
        if (((AppCompatTextView) ViewBindings.findChildViewById(r103, R.id.dorag_anti_sound_leak_hint)) == null) goto L17;
        r104 = R.id.dorag_anti_sound_leak_switch;
        ItemTextToggle r106 = (ItemTextToggle) ViewBindings.findChildViewById(r103, R.id.dorag_anti_sound_leak_switch);
        if (r106 == null) goto L17;
        r104 = R.id.scroll_view;
        if (((ScrollView) ViewBindings.findChildViewById(r103, R.id.scroll_view)) == null) goto L17;
        r104 = R.id.title;
        NovaTitleBarEx r107 = (NovaTitleBarEx) ViewBindings.findChildViewById(r103, R.id.title);
        if (r107 == null) goto L17;
        LinearLayout r108 = (LinearLayout) r103;
        this.f334891f = new LarusDoragPageSoundSettingsBinding(r108, r105, r106, r107);
        return r108;
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }
}
