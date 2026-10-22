package com.larus.dora.impl.device.settings.sound;

import android.app.Application;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemGroupTitle;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.databinding.LarusDoraPageSoundSettingsBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UByte;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowCollector;
import t19.s;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002*\u0001\r\u0018\u0000 42\u00020\u0001:\u00014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001aH\u0002J\b\u0010\u001f\u001a\u00020\u001aH\u0002J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"H\u0002J\u0015\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010$¢\u0006\u0002\u0010&J\u0015\u0010'\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010$¢\u0006\u0002\u0010&J\b\u0010(\u001a\u00020)H\u0016J\n\u0010*\u001a\u0004\u0018\u00010+H\u0002J\n\u0010,\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010.\u001a\u00020\u001a2\u0006\u0010/\u001a\u000200H\u0002J\u0010\u00101\u001a\u00020\u001a2\u0006\u00102\u001a\u000203H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/larus/dora/impl/device/settings/sound/SoundSettingsFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageSoundSettingsBinding;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/device/settings/sound/SoundSettingsViewModel;", "getModel", "()Lcom/larus/dora/impl/device/settings/sound/SoundSettingsViewModel;", "model$delegate", "Lkotlin/Lazy;", "ambientVolumeChangedReceiver", "com/larus/dora/impl/device/settings/sound/SoundSettingsFragment$ambientVolumeChangedReceiver$1", "Lcom/larus/dora/impl/device/settings/sound/SoundSettingsFragment$ambientVolumeChangedReceiver$1;", "checkedChangeListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", WidgetCostModule.TYPE_ON_START, "onStop", "setupVoiceSeek", "setupAntiSoundLeak", "refreshAntiSoundLeakCheckedState", "state", "Lcom/larus/dora/impl/device/settings/sound/AntiSoundLeakState;", "convertIntToByte", "", "input", "(Ljava/lang/Integer;)I", "convertByteToInt", "getCurrentPageName", "", "setupTitle", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "getPageMaskView", "soundAmbientVolumeSwitchCheckedChangeListener", "updateAmbientVolumeSwitch", "isOpen", "", "updateSpeakerVolumeSwitch", "vol", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SoundSettingsFragment extends DoraBaseFragment {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f334895k = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LarusDoraPageSoundSettingsBinding f334896f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f334897g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SoundSettingsFragment$ambientVolumeChangedReceiver$1 f334898h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final g f334899i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final h f334900j;

    public static final class a {
    }

    public static final class b<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SoundSettingsFragment f334902a;

        public b(SoundSettingsFragment r100) {
            this.f334902a = r100;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object r100, Continuation r101) {
            l r102 = (l) r100;
            if (Intrinsics.areEqual(r102, l.a.f334921a) == true) goto L12;
            if (Intrinsics.areEqual(r102, l.b.f334922a) == true) goto L12;
            if ((r102 instanceof l.c) == false) goto L10;
            SoundSettingsFragment.X90(this.f334902a, ((l.c) r102).f334923a);
            goto L12
        L10:
            throw new NoWhenBranchMatchedException();
        L12:
            return Unit.INSTANCE;
        }
    }

    public static final class c<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SoundSettingsFragment f334903a;

        public c(SoundSettingsFragment r100) {
            this.f334903a = r100;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object r100, Continuation r101) {
            if (((Boolean) r100).booleanValue() == true) goto L8;
            s r102 = s.f544207a;
            Application r103 = AppHost.f326268a.getApplication();
            r102.getClass();
            s.b(r103, R.string.larus_dora_toast_update_failed_cn, false);
            SoundSettingsFragment r104 = this.f334903a;
            int r105 = SoundSettingsFragment.f334895k;
            l r106 = r104.Y90().getSoundSettingsStateFlow().getValue();
            if ((r106 instanceof l.c) == false) goto L8;
            SoundSettingsFragment.X90(this.f334903a, ((l.c) r106).f334923a);
        L8:
            return Unit.INSTANCE;
        }
    }

    public static final class d<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SoundSettingsFragment f334904a;

        public d(SoundSettingsFragment r100) {
            this.f334904a = r100;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object r100, Continuation r101) {
            m r102 = (m) r100;
            if (Intrinsics.areEqual(r102, m.a.f334924a) == true) goto L87;
            if (Intrinsics.areEqual(r102, m.b.f334925a) == true) goto L87;
            if ((r102 instanceof m.c) == false) goto L85;
            if (r102 == null) goto L87;
            SoundSettingsFragment r103 = this.f334904a;
            byte r104 = ((m.c) r102).f334926a;
            int r105 = SoundSettingsFragment.f334895k;
            r103.getClass();
            g49.d.d("SoundSettingsFragment", "update updateSpeakerVolumeSwitch " + r104);
            LarusDoraPageSoundSettingsBinding r106 = r103.f334896f;
            if (r106 == null) goto L87;
            SeekBar r107 = r106.f333260r;
            if (r107 == null) goto L87;
            Integer r108 = Integer.valueOf(r104 & UByte.MAX_VALUE);
            if (r108 == null) goto L20;
            if (r108.intValue() != 253) goto L20;
            int r109 = 0;
        L83:
            r107.setProgress(r109);
        L20:
            if (r108 == null) goto L26;
            if (r108.intValue() != 254) goto L26;
            r109 = 1;
        L26:
            if (r108 == null) goto L32;
            if (r108.intValue() != 255) goto L32;
            r109 = 2;
        L32:
            if (r108 == null) goto L38;
            if (r108.intValue() != 0) goto L38;
        L82:
            r109 = 3;
        L38:
            if (r108 == null) goto L44;
            if (r108.intValue() != 1) goto L44;
            r109 = 4;
        L44:
            if (r108 == null) goto L50;
            if (r108.intValue() != 2) goto L50;
            r109 = 5;
        L50:
            if (r108 == null) goto L56;
            if (r108.intValue() != 3) goto L56;
            r109 = 6;
        L56:
            if (r108 == null) goto L62;
            if (r108.intValue() != 4) goto L62;
            r109 = 7;
        L62:
            if (r108 != null) goto L65;
        L67:
            if (r108 != null) goto L70;
        L72:
            if (r108 != null) goto L75;
        L77:
            if (r108 == null) goto L82;
            if (r108.intValue() != 8) goto L82;
            r109 = 11;
            goto L83
        L75:
            if (r108.intValue() != 7) goto L77;
            r109 = 10;
            goto L83
        L70:
            if (r108.intValue() != 6) goto L72;
            r109 = 9;
            goto L83
        L65:
            if (r108.intValue() != 5) goto L67;
            r109 = 8;
            goto L83
        L85:
            throw new NoWhenBranchMatchedException();
        L87:
            return Unit.INSTANCE;
        }
    }

    static {
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        return "dora_voice_setting";
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        LarusDoraPageSoundSettingsBinding r100 = this.f334896f;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f333245c;
    }

    public final SoundSettingsViewModel Y90() {
        return (SoundSettingsViewModel) this.f334897g.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.dora.impl.device.settings.sound.SoundSettingsFragment$ambientVolumeChangedReceiver$1] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.larus.dora.impl.device.settings.sound.g] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.larus.dora.impl.device.settings.sound.h] */
    public SoundSettingsFragment() {
        final Function0<Fragment> r100 = new SoundSettingsFragment$special$$inlined$viewModels$default$1(this);
        this.f334897g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SoundSettingsViewModel.class), new SoundSettingsFragment$special$$inlined$viewModels$default$2(r100), new SoundSettingsFragment$special$$inlined$viewModels$default$3(r100, this));
        this.f334898h = new SoundSettingsFragment$ambientVolumeChangedReceiver$1(this);
        this.f334899i = new g(this);
        this.f334900j = new h(this);
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        LocalBroadcastManager r100 = LocalBroadcastManager.getInstance(requireContext());
        SoundSettingsFragment$ambientVolumeChangedReceiver$1 r101 = this.f334898h;
        DoraAmbientVolumeSettingsNotifier r102 = DoraAmbientVolumeSettingsNotifier.f334888a;
        r100.registerReceiver(r101, new IntentFilter("com.larus.dora.impl.action.AMBIENT_VOLUME_CHANGED"));
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment, androidx.fragment.app.Fragment
    public final void onStop() {
        LocalBroadcastManager.getInstance(requireContext()).unregisterReceiver(this.f334898h);
        super.onStop();
    }

    public static final void W90(SoundSettingsFragment r100, com.larus.dora.impl.device.settings.sound.a r101) {
        LarusDoraPageSoundSettingsBinding r102 = r100.f334896f;
        if (r102 == null) goto L9;
        ItemTextToggle r103 = r102.f333256n;
        if (r103 == null) goto L9;
        CustomSwitchCompat r104 = r103.getToggleView();
        if (r104 == null) goto L9;
        r104.setOnCheckedChangeListener(null);
    L9:
        LarusDoraPageSoundSettingsBinding r105 = r100.f334896f;
        if (r105 == null) goto L16;
        ItemTextToggle r106 = r105.f333256n;
        if (r106 == null) goto L16;
        CustomSwitchCompat r107 = r106.getToggleView();
        if (r107 == null) goto L16;
        r107.setChecked(Intrinsics.areEqual(r101, com.larus.dora.impl.device.settings.sound.a.b.f334908a));
    L16:
        LarusDoraPageSoundSettingsBinding r108 = r100.f334896f;
        if (r108 == null) goto L24;
        ItemTextToggle r109 = r108.f333256n;
        if (r109 == null) goto L25;
        CustomSwitchCompat r110 = r109.getToggleView();
        if (r110 == null) goto L26;
        r110.setOnCheckedChangeListener(r100.f334899i);
        return;
    L26:
        return;
    L25:
        return;
    }

    public static final void X90(SoundSettingsFragment r100, boolean r101) {
        r100.getClass();
        g49.d.d("SoundSettingsFragment", "update AmbientVolumeSwitch " + r101);
        LarusDoraPageSoundSettingsBinding r102 = r100.f334896f;
        if (r102 == null) goto L9;
        ItemTextToggle r103 = r102.f333250h;
        if (r103 == null) goto L9;
        CustomSwitchCompat r104 = r103.getToggleView();
        if (r104 == null) goto L9;
        r104.setOnCheckedChangeListener(null);
        r104.setChecked(r101);
        r104.setOnCheckedChangeListener(r100.f334900j);
    L9:
        LarusDoraPageSoundSettingsBinding r105 = r100.f334896f;
        if (r105 == null) goto L15;
        LinearLayout r106 = r105.f333247e;
        if (r106 == null) goto L16;
        e1.o(r106);
        return;
    L16:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r210, Bundle r310) {
        Intrinsics.checkNotNullParameter(r210, "view");
        super.onViewCreated(r210, r310);
        LarusDoraPageSoundSettingsBinding r100 = this.f334896f;
        if (r100 == null) goto L5;
        NovaTitleBarEx r101 = r100.f333259q;
        NovaTitleBarEx.Y5(r101, getString(R.string.larus_dora_settings_sound_cn), null, null, 6);
        NovaTitleBarEx.b6(r101, R.drawable.larus_dora_ic_left_back, false, null, null, new i(this), 14);
    L5:
        LarusDoraPageSoundSettingsBinding r102 = this.f334896f;
        if (r102 == null) goto L8;
        r102.f333260r.setOnSeekBarChangeListener(new SoundSettingsFragment$setupVoiceSeek$1$1(this));
    L8:
        IDoraService r103 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        boolean r104 = true;
        if (r103 == null) goto L15;
        DeviceService r105 = r103.device();
        if (r105 == null) goto L15;
        if (r105.M() != true) goto L15;
        boolean r110 = true;
    L16:
        Lifecycle.State r111 = Lifecycle.State.STARTED;
        boolean r106 = r110;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new SoundSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r111, null, this, r106), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new SoundSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r111, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new SoundSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r111, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new SoundSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$4(this, r111, null, this, r106), 3, null);
        if (com.larus.dora.impl.util.s.a() == false) goto L36;
        IDoraService r107 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r107 == null) goto L25;
        DeviceService r108 = r107.device();
        if (r108 == null) goto L25;
        if (r108.N() != true) goto L25;
    L26:
        if (r104 == false) goto L36;
        LarusDoraPageSoundSettingsBinding r109 = this.f334896f;
        if (r109 == null) goto L35;
        ItemTextToggle r112 = r109.f333256n;
        if (r112 == null) goto L35;
        CustomSwitchCompat r113 = r112.getToggleView();
        if (r113 == null) goto L35;
        r113.setOnCheckedChangeListener(this.f334899i);
    L35:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new SoundSettingsFragment$setupAntiSoundLeak$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r111, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new SoundSettingsFragment$setupAntiSoundLeak$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r111, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new SoundSettingsFragment$setupAntiSoundLeak$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r111, null, this), 3, null);
        return;
    L25:
        r104 = false;
    L36:
        LarusDoraPageSoundSettingsBinding r114 = this.f334896f;
        if (r114 == null) goto L41;
        ItemGroupTitle r115 = r114.f333257o;
        if (r115 == null) goto L41;
        e1.o(r115);
    L41:
        LarusDoraPageSoundSettingsBinding r116 = this.f334896f;
        if (r116 == null) goto L46;
        ItemGroup r117 = r116.f333254l;
        if (r117 == null) goto L46;
        e1.o(r117);
    L46:
        LarusDoraPageSoundSettingsBinding r118 = this.f334896f;
        if (r118 == null) goto L51;
        AppCompatTextView r119 = r118.f333255m;
        if (r119 == null) goto L51;
        e1.o(r119);
    L51:
        LarusDoraPageSoundSettingsBinding r120 = this.f334896f;
        if (r120 == null) goto L56;
        View r121 = r120.f333251i;
        if (r121 == null) goto L56;
        e1.o(r121);
    L56:
        LarusDoraPageSoundSettingsBinding r122 = this.f334896f;
        if (r122 == null) goto L65;
        ItemTextToggle r123 = r122.f333256n;
        if (r123 == null) goto L66;
        CustomSwitchCompat r124 = r123.getToggleView();
        if (r124 == null) goto L67;
        r124.setChecked(false);
        return;
    L67:
        return;
    L66:
        return;
    L65:
        return;
    L15:
        r110 = false;
        goto L16
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r210, ViewGroup r211, Bundle r212) {
        Intrinsics.checkNotNullParameter(r210, "inflater");
        View r100 = r210.inflate(R.layout.larus_dora_page_sound_settings, r211, false);
        int r101 = R.id.dora_multi_devices_switch_hint;
        AppCompatTextView r102 = (AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.dora_multi_devices_switch_hint);
        if (r102 == null) goto L55;
        r101 = R.id.dora_page_mask;
        View r103 = ViewBindings.findChildViewById(r100, R.id.dora_page_mask);
        if (r103 == null) goto L55;
        r101 = R.id.dora_sound_ambient_interval;
        View r104 = ViewBindings.findChildViewById(r100, R.id.dora_sound_ambient_interval);
        if (r104 == null) goto L55;
        r101 = R.id.dora_sound_ambient_snr_group;
        LinearLayout r105 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.dora_sound_ambient_snr_group);
        if (r105 == null) goto L55;
        r101 = R.id.dora_sound_ambient_snr_left_tv;
        if (((AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.dora_sound_ambient_snr_left_tv)) == null) goto L55;
        r101 = R.id.dora_sound_ambient_snr_progress;
        if (((SeekBar) ViewBindings.findChildViewById(r100, R.id.dora_sound_ambient_snr_progress)) == null) goto L55;
        r101 = R.id.dora_sound_ambient_snr_progress_tv;
        if (((AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.dora_sound_ambient_snr_progress_tv)) == null) goto L55;
        r101 = R.id.dora_sound_ambient_snr_right_tv;
        if (((AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.dora_sound_ambient_snr_right_tv)) == null) goto L55;
        r101 = R.id.dora_sound_ambient_snr_title;
        if (((ItemGroupTitle) ViewBindings.findChildViewById(r100, R.id.dora_sound_ambient_snr_title)) == null) goto L55;
        r101 = R.id.dora_sound_ambient_title;
        ItemGroupTitle r106 = (ItemGroupTitle) ViewBindings.findChildViewById(r100, R.id.dora_sound_ambient_title);
        if (r106 == null) goto L55;
        r101 = R.id.dora_sound_ambient_volume_group;
        ItemGroup r110 = (ItemGroup) ViewBindings.findChildViewById(r100, R.id.dora_sound_ambient_volume_group);
        if (r110 == null) goto L55;
        r101 = R.id.dora_sound_ambient_volume_switch;
        ItemTextToggle r111 = (ItemTextToggle) ViewBindings.findChildViewById(r100, R.id.dora_sound_ambient_volume_switch);
        if (r111 == null) goto L55;
        r101 = R.id.dora_sound_anti_leak_interval;
        View r112 = ViewBindings.findChildViewById(r100, R.id.dora_sound_anti_leak_interval);
        if (r112 == null) goto L55;
        r101 = R.id.dora_sound_assistant_volume_group;
        ItemGroup r113 = (ItemGroup) ViewBindings.findChildViewById(r100, R.id.dora_sound_assistant_volume_group);
        if (r113 == null) goto L55;
        r101 = R.id.dora_sound_cuetone_volume_desc;
        AppCompatTextView r114 = (AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.dora_sound_cuetone_volume_desc);
        if (r114 == null) goto L55;
        r101 = R.id.dorag_anti_sound_leak_group;
        ItemGroup r115 = (ItemGroup) ViewBindings.findChildViewById(r100, R.id.dorag_anti_sound_leak_group);
        if (r115 == null) goto L55;
        r101 = R.id.dorag_anti_sound_leak_hint;
        AppCompatTextView r116 = (AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.dorag_anti_sound_leak_hint);
        if (r116 == null) goto L55;
        r101 = R.id.dorag_anti_sound_leak_switch;
        ItemTextToggle r117 = (ItemTextToggle) ViewBindings.findChildViewById(r100, R.id.dorag_anti_sound_leak_switch);
        if (r117 == null) goto L55;
        r101 = R.id.scroll_view;
        if (((ScrollView) ViewBindings.findChildViewById(r100, R.id.scroll_view)) == null) goto L55;
        r101 = R.id.sound_anti_leak_title;
        ItemGroupTitle r118 = (ItemGroupTitle) ViewBindings.findChildViewById(r100, R.id.sound_anti_leak_title);
        if (r118 == null) goto L55;
        r101 = R.id.sound_cuetone_volume;
        ItemGroupTitle r119 = (ItemGroupTitle) ViewBindings.findChildViewById(r100, R.id.sound_cuetone_volume);
        if (r119 == null) goto L55;
        r101 = R.id.title;
        NovaTitleBarEx r213 = (NovaTitleBarEx) ViewBindings.findChildViewById(r100, R.id.title);
        if (r213 == null) goto L55;
        r101 = R.id.voice_left_icon;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.voice_left_icon)) == null) goto L55;
        r101 = R.id.voice_rate_progress;
        SeekBar r214 = (SeekBar) ViewBindings.findChildViewById(r100, R.id.voice_rate_progress);
        if (r214 == null) goto L55;
        r101 = R.id.voice_right_icon;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.voice_right_icon)) == null) goto L55;
        LinearLayout r107 = (LinearLayout) r100;
        this.f334896f = new LarusDoraPageSoundSettingsBinding(r107, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r213, r214);
        return r107;
    L55:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }
}
