package com.larus.dora.obric.device_management.setting.common.sound;

import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.gaiax.render.view.GXViewKey;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.device.settings.sound.DoraAmbientVolumeSettingsNotifier;
import com.larus.dora.impl.device.settings.sound.SoundSettingsViewModel;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.lynx.textra.PlatformFontCaps;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.slider.OSlider;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000£\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0017\u0018\u0000 t2\u00020\u0001:\u0001tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010&\u001a\u00020$H\u0016J\b\u0010'\u001a\u00020$H\u0016J\b\u0010(\u001a\u00020$H\u0016J\b\u0010)\u001a\u00020*H\u0016J\n\u0010+\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010,\u001a\u00020\u000bH\u0002J\b\u0010-\u001a\u00020\u000bH\u0002J\b\u0010.\u001a\u00020\u000bH\u0002J\b\u0010/\u001a\u00020\u000bH\u0002J\b\u00100\u001a\u00020\u000bH\u0002J\b\u00101\u001a\u00020\u000bH\u0002J\b\u00102\u001a\u00020*H\u0002J\b\u00103\u001a\u00020*H\u0002J0\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010*2\u0006\u00107\u001a\u00020\u000b2\b\u00108\u001a\u0004\u0018\u00010*2\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010:\u001a\u00020\u000b2\u0006\u00106\u001a\u00020*H\u0002J\u0010\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020*H\u0002J8\u0010=\u001a\u00020>2\u0006\u00106\u001a\u00020*2\b\u0010?\u001a\u0004\u0018\u00010*2\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020$0A2\b\b\u0002\u0010B\u001a\u00020CH\u0002J\u001a\u0010D\u001a\u00020>2\u0006\u00106\u001a\u00020*2\b\u0010E\u001a\u0004\u0018\u00010\u0014H\u0002J*\u0010F\u001a\u00020\u00142\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020H2\u0006\u0010J\u001a\u00020H2\b\b\u0002\u0010K\u001a\u00020CH\u0002J\b\u0010L\u001a\u00020$H\u0002J\b\u0010M\u001a\u00020$H\u0002J\b\u0010N\u001a\u00020$H\u0002J\u000e\u0010O\u001a\u00020CH\u0082@¢\u0006\u0002\u0010PJ\b\u0010Q\u001a\u00020$H\u0002J\b\u0010R\u001a\u00020$H\u0002J\b\u0010S\u001a\u00020$H\u0002J\b\u0010T\u001a\u00020$H\u0002J\u0010\u0010U\u001a\u00020$2\u0006\u0010V\u001a\u00020CH\u0002J\u0010\u0010W\u001a\u00020$2\u0006\u0010X\u001a\u00020YH\u0002J\u0010\u0010Z\u001a\u00020$2\u0006\u0010V\u001a\u00020CH\u0002J\u0010\u0010[\u001a\u00020$2\u0006\u0010\\\u001a\u00020]H\u0002J\b\u0010^\u001a\u00020CH\u0002J\b\u0010_\u001a\u00020CH\u0002J\u0017\u0010`\u001a\u00020a2\b\u0010b\u001a\u0004\u0018\u00010aH\u0002¢\u0006\u0002\u0010cJ\u0017\u0010d\u001a\u00020a2\b\u0010b\u001a\u0004\u0018\u00010aH\u0002¢\u0006\u0002\u0010cJ\f\u0010e\u001a\u00020$*\u00020>H\u0002J\f\u0010f\u001a\u00020$*\u00020>H\u0002J\f\u0010g\u001a\u00020$*\u00020>H\u0002J\f\u0010h\u001a\u00020$*\u00020>H\u0002J\f\u0010i\u001a\u00020$*\u00020>H\u0002J\u0010\u0010j\u001a\u00020\u000b2\u0006\u0010k\u001a\u00020aH\u0002J\b\u0010l\u001a\u00020aH\u0002J\b\u0010m\u001a\u00020aH\u0002J\b\u0010n\u001a\u00020aH\u0002J\f\u0010o\u001a\u00020$*\u00020pH\u0002J\f\u0010q\u001a\u00020$*\u00020pH\u0002J\f\u0010r\u001a\u00020a*\u00020aH\u0002J\f\u0010s\u001a\u00020a*\u00020HH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006u"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/common/sound/DoraObricSoundSettingsFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/device/settings/sound/SoundSettingsViewModel;", "getModel", "()Lcom/larus/dora/impl/device/settings/sound/SoundSettingsViewModel;", "model$delegate", "Lkotlin/Lazy;", "ambientSection", "Landroid/view/View;", "cueToneSection", "antiSoundLeakSection", "ambientToCueGap", "cueToAntiGap", "ambientSwitch", "Lcom/obric/oui/oswitch/OSwitch;", "antiSoundLeakSwitch", "cueToneSlider", "Lcom/obric/oui/slider/OSlider;", "pageMaskView", "ambientVolumeChangedReceiver", "com/larus/dora/obric/device_management/setting/common/sound/DoraObricSoundSettingsFragment$ambientVolumeChangedReceiver$1", "Lcom/larus/dora/obric/device_management/setting/common/sound/DoraObricSoundSettingsFragment$ambientVolumeChangedReceiver$1;", "antiSoundLeakCheckedChangeListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "ambientVolumeCheckedChangeListener", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", WidgetCostModule.TYPE_ON_START, "onStop", "onDestroyView", "getCurrentPageName", "", "getPageMaskView", "buildContentView", "buildTitleBar", "buildScrollContent", "buildAmbientSection", "buildCueToneSection", "buildAntiSoundLeakSection", "getAmbientVolumeAdaptiveTips", "getCueToneVolumeDesc", "buildSection", "Landroid/widget/LinearLayout;", "title", BrowserDependency.UrlClickType.CARD, "supportiveText", "extraCard", "buildSectionTitle", "buildSupportiveText", "text", "buildSwitchCard", "Lcom/obric/oui/lisitem/OCardListItem;", "subtitle", "onSwitchCreated", "Lkotlin/Function1;", "embeddedInCard", "", "buildSliderCard", GXViewKey.VIEW_TYPE_CONTAINER_SLIDER, "buildSlider", BitableFieldEditAnalytic.ProgressFieldEditScene.MIN, "", BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, "defaultProgress", "showLeftIcon", "setupAmbientVolume", "setupDefaultAmbientVolume", "setupEarbudsAmbientVolume", "isEarbudsAmbientVolumeSupported", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setupCueToneVolume", "setupAntiSoundLeak", "updateSectionGaps", "setupCueToneSeek", "updateAmbientVolumeSwitch", "isOpen", "refreshAntiSoundLeakCheckedState", "state", "Lcom/larus/dora/impl/device/settings/sound/AntiSoundLeakState;", "updateAntiSoundLeakSwitch", "updateSpeakerVolumeSwitch", "vol", "", "isGDevice", "useEarbudsSoundStyle", "convertIntToByte", "", "input", "(Ljava/lang/Integer;)I", "convertByteToInt", "applyCardStyle", "applyEmbeddedSwitchRowStyle", "applyContainerCardStyle", "resetCardContainerMargins", "applyCardRadius", "buildSpacer", "heightDp", "resolveBackgroundColor", "resolvePrimaryTextColor", "resolveSecondaryTextColor", "applyTitleBarTextStyle", "Landroid/widget/TextView;", "applySupportiveTextStyle", "dp", CloudControlInf.SP, "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricSoundSettingsFragment extends DoraBaseFragment {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final IntRange f339652s = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f339653f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f339654g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f339655h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f339656i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f339657j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f339658k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public OSwitch f339659l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public OSwitch f339660m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public OSlider f339661n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f339662o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final DoraObricSoundSettingsFragment$ambientVolumeChangedReceiver$1 f339663p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final b f339664q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final c f339665r;

    public static final class a {
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        return "dora_voice_setting";
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        this.f339654g = null;
        this.f339655h = null;
        this.f339656i = null;
        this.f339657j = null;
        this.f339658k = null;
        this.f339659l = null;
        this.f339660m = null;
        this.f339661n = null;
        this.f339662o = null;
        super.onDestroyView();
    }

    static {
        f339652s = new IntRange(0, 1);
    }

    public final SoundSettingsViewModel ea0() {
        return (SoundSettingsViewModel) this.f339653f.getValue();
    }

    public final void ia0() {
        View r100 = this.f339654g;
        boolean r101 = true;
        int r102 = 0;
        if (r100 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        View r104 = this.f339655h;
        if (r104 != null) goto L11;
    L13:
        boolean r105 = false;
    L14:
        View r106 = this.f339656i;
        if (r106 != null) goto L17;
    L19:
        r101 = false;
    L20:
        View r107 = this.f339657j;
        if (r107 == null) goto L27;
        if (r103 == false) goto L25;
        if (r105 == false) goto L25;
        int r108 = 0;
    L26:
        r107.setVisibility(r108);
    L25:
        r108 = 8;
    L27:
        View r109 = this.f339658k;
        if (r109 == null) goto L36;
        if (r101 == false) goto L33;
        if (r103 == true) goto L34;
        if (r105 == false) goto L33;
    L34:
        r109.setVisibility(r102);
        return;
    L33:
        r102 = 8;
        goto L34
    L36:
        return;
    L17:
        if (r106.getVisibility() != 0) goto L19;
    L11:
        if (r104.getVisibility() != 0) goto L13;
        r105 = true;
        goto L14
    L5:
        if (r100.getVisibility() != 0) goto L7;
        r103 = true;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.dora.obric.device_management.setting.common.sound.DoraObricSoundSettingsFragment$ambientVolumeChangedReceiver$1] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.larus.dora.obric.device_management.setting.common.sound.b] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.larus.dora.obric.device_management.setting.common.sound.c] */
    public DoraObricSoundSettingsFragment() {
        final Function0<Fragment> r100 = new DoraObricSoundSettingsFragment$special$$inlined$viewModels$default$1(this);
        this.f339653f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SoundSettingsViewModel.class), new DoraObricSoundSettingsFragment$special$$inlined$viewModels$default$2(r100), new DoraObricSoundSettingsFragment$special$$inlined$viewModels$default$3(r100, this));
        this.f339663p = new DoraObricSoundSettingsFragment$ambientVolumeChangedReceiver$1(this);
        this.f339664q = new b(this);
        this.f339665r = new c(this);
    }

    public final int ga0() {
        return v19.c.a(R.attr.larus_neutral_100, requireContext(), R.color.larus_neutral_100);
    }

    public final boolean ja0() {
        Bundle r100 = getArguments();
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.getBoolean("key_use_earbuds_sound_style", false) != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        LocalBroadcastManager r100 = LocalBroadcastManager.getInstance(requireContext());
        DoraObricSoundSettingsFragment$ambientVolumeChangedReceiver$1 r101 = this.f339663p;
        DoraAmbientVolumeSettingsNotifier r102 = DoraAmbientVolumeSettingsNotifier.f334888a;
        r100.registerReceiver(r101, new IntentFilter("com.larus.dora.impl.action.AMBIENT_VOLUME_CHANGED"));
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment, androidx.fragment.app.Fragment
    public final void onStop() {
        LocalBroadcastManager.getInstance(requireContext()).unregisterReceiver(this.f339663p);
        super.onStop();
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        return this.f339662o;
    }

    public final void Z90(OCardListItem r100) {
        Iterator r101 = CollectionsKt.listOf(new Drawable[]{r100.getCardContainer().getBackground(), r100.getContentContainer().getBackground()}).iterator();
    L4:
        if (r101.hasNext() == false) goto L12;
        Drawable r102 = (Drawable) r101.next();
        if ((r102 instanceof GradientDrawable) == false) goto L8;
        GradientDrawable r103 = (GradientDrawable) r102;
    L9:
        if (r103 == null) goto L4;
        r103.setCornerRadius(da0(20));
        goto L4
    L8:
        r103 = null;
        goto L9
    }

    public final View ba0(int r100) {
        View r101 = new View(requireContext());
        r101.setLayoutParams(new LinearLayout.LayoutParams(-1, da0(r100)));
        return r101;
    }

    public final int da0(int r100) {
        Resources r101 = getResources();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
    }

    public final void fa0(OCardListItem r100) {
        ViewGroup.LayoutParams r101 = r100.getCardContainer().getLayoutParams();
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
    L6:
        if (r102 == null) goto L9;
        r102.setMarginStart(0);
        r102.setMarginEnd(0);
        r102.leftMargin = 0;
        r102.rightMargin = 0;
        r100.getCardContainer().setLayoutParams(r102);
        return;
    L9:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final int ha0(float r100) {
        Resources r101 = getResources();
        return (int) TypedValue.applyDimension(2, r100, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()));
    }

    public static final Object W90(DoraObricSoundSettingsFragment r100, Continuation r101) {
        r100.getClass();
        if ((r101 instanceof DoraObricSoundSettingsFragment$isEarbudsAmbientVolumeSupported$1) == false) goto L7;
        DoraObricSoundSettingsFragment$isEarbudsAmbientVolumeSupported$1 r102 = (DoraObricSoundSettingsFragment$isEarbudsAmbientVolumeSupported$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        boolean r107 = true;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        int r108 = r102.I$1;
        int r109 = r102.I$0;
        ResultKt.throwOnFailure(r104);
    L18:
        int r110 = ((Number) r104).intValue();
        if (r109 > r110) goto L22;
        if (r110 > r108) goto L22;
    L24:
        return Boxing.boxBoolean(r107);
    L22:
        r107 = false;
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        IntRange r111 = f339652s;
        int r112 = r111.getFirst();
        int r113 = r111.getLast();
        kj4.a r114 = kj4.a.g();
        r102.I$0 = r112;
        r102.I$1 = r113;
        r102.label = 1;
        Object r115 = DoraAdapterExtKt.l(r114);
        if (r115 == r105) goto L25;
        r108 = r113;
        r104 = r115;
        r109 = r112;
        goto L18
    L25:
        return r105;
    L7:
        r102 = new DoraObricSoundSettingsFragment$isEarbudsAmbientVolumeSupported$1(r100, r101);
        goto L8
    }

    public static final void X90(DoraObricSoundSettingsFragment r100, com.larus.dora.impl.device.settings.sound.a r101) {
        r100.getClass();
        boolean r102 = Intrinsics.areEqual(r101, com.larus.dora.impl.device.settings.sound.a.b.f334908a);
        OSwitch r103 = r100.f339660m;
        if (r103 == null) goto L5;
        r103.setOnCheckedChangeListener(null);
    L5:
        OSwitch r104 = r100.f339660m;
        if (r104 == null) goto L8;
        r104.setChecked(r102);
    L8:
        OSwitch r105 = r100.f339660m;
        if (r105 == null) goto L12;
        r105.setOnCheckedChangeListener(r100.f339664q);
        return;
    }

    public static final void Y90(DoraObricSoundSettingsFragment r100, boolean r101) {
        r100.getClass();
        g49.d.d("DoraObricSoundSettings", "updateAmbientVolumeSwitch: " + r101);
        OSwitch r102 = r100.f339659l;
        if (r102 == null) goto L5;
        r102.setOnCheckedChangeListener(null);
    L5:
        OSwitch r103 = r100.f339659l;
        if (r103 == null) goto L8;
        r103.setChecked(r101);
    L8:
        OSwitch r104 = r100.f339659l;
        if (r104 == null) goto L12;
        r104.setOnCheckedChangeListener(r100.f339665r);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        if (ja0() == false) goto L5;
        Lifecycle.State r112 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricSoundSettingsFragment$setupEarbudsAmbientVolume$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r112, null, this), 3, null);
    L15:
        Lifecycle.State r113 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricSoundSettingsFragment$setupCueToneVolume$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r113, null, this), 3, null);
        if (ja0() == true) goto L20;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricSoundSettingsFragment$setupAntiSoundLeak$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r113, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricSoundSettingsFragment$setupAntiSoundLeak$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r113, null, this), 3, null);
        return;
    L20:
        return;
    L5:
        boolean r114 = DoraAdapterExtKt.y(kj4.a.g());
        View r100 = this.f339654g;
        if (r100 == null) goto L11;
        if (r114 == false) goto L9;
        int r101 = 0;
    L10:
        r100.setVisibility(r101);
        goto L11
    L9:
        r101 = 8;
    L11:
        ia0();
        if (r114 == false) goto L15;
        Lifecycle.State r115 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricSoundSettingsFragment$setupDefaultAmbientVolume$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r115, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricSoundSettingsFragment$setupDefaultAmbientVolume$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r115, null, this), 3, null);
        goto L15
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        Context r100 = requireContext();
        AttributeSet r101 = null;
        int r102 = 6;
        int r103 = 0;
        OFloatingTitleBar r104 = new OFloatingTitleBar(requireContext(), null, 6, 0);
        r104.setClipChildren(false);
        r104.setClipToPadding(false);
        r104.setBackgroundColor(v19.c.a(R.attr.larus_base_1_overlay, requireContext(), R.color.larus_base_1_overlay));
        r104.setCenterTitle(getString(R.string.larus_dora_sound_title_cn));
        r104.setCenterTitleColor(ga0());
        TextView r105 = (TextView) r104.findViewById(R.id.center_title);
        if (r105 == null) goto L5;
        r105.setTextColor(ga0());
        r105.setTextSize(2, 16.0f);
        TextViewCompat.setLineHeight(r105, ha0(22.0f));
        r105.setTypeface(Typeface.create(Typeface.create(PlatformFontCaps.DEFAULT_FAMILY_NAME, 0), 600, false));
    L5:
        r104.R(false);
        OFloatingTitleBar.k(r104, null, 6).setOnClickListener(new d(this));
        Context r106 = requireContext();
        LinearLayout r113 = new LinearLayout(r106);
        r113.setOrientation(1);
        r113.setClipChildren(false);
        r113.setClipToPadding(false);
        r113.setPadding(da0(12), 0, da0(12), da0(24));
        String r107 = getString(R.string.larus_dora_sound_ambient_volume_cn);
        OCardListItem r108 = ca0(this, getString(R.string.larus_dora_sound_ambient_volume_adaptive_cn), null, new e(this));
        IDoraService r109 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r109 == null) goto L12;
        DeviceService r114 = r109.device();
        if (r114 == null) goto L12;
        if (r114.M() != true) goto L12;
        boolean r115 = true;
    L13:
        if (r115 == false) goto L15;
        String r116 = getString(R.string.larus_dorag_sound_ambient_volume_adaptive_tips_cn);
        Intrinsics.checkNotNull(r116);
    L16:
        LinearLayout r117 = aa0(this, r107, r108, r116);
        r113.addView(r117);
        this.f339654g = r117;
        View r118 = ba0(16);
        r113.addView(r118);
        this.f339657j = r118;
        OSlider r119 = new OSlider(requireContext(), r101, r102, r103);
        r119.setMinValue(0.0f);
        r119.setMaxValue(5.0f);
        r119.setProgress(4.0f);
        r119.f402994g = true;
        Drawable r120 = ContextCompat.getDrawable(r119.getContext(), R.drawable.o_slider_audio_white_icon);
        if (r120 == null) goto L21;
        r119.setLeftIcon(r120);
        r119.f402989b.setVisibility(0);
        ImageView r121 = (ImageView) r119.findViewById(R.id.tvLeftIcon);
        if (r121 == null) goto L21;
        r121.setColorFilter(ContextCompat.getColor(r119.getContext(), R.color.oui_basic_text_1));
    L21:
        r119.f402990c.setVisibility(8);
        this.f339661n = r119;
        String r122 = getString(R.string.larus_dora_sound_cuetone_volume_cn);
        String r123 = getString(R.string.larus_dora_sound_cuetone_volume_cn);
        OSlider r124 = this.f339661n;
        LinearLayout r125 = new LinearLayout(requireContext());
        r125.setOrientation(1);
        r125.setGravity(16);
        r125.setPadding(da0(12), da0(12), da0(4), da0(10));
        OTextView r126 = new OTextView(r125.getContext(), null, 0, 14);
        r126.setText(r123);
        r126.setTextColor(ga0());
        r126.setTextSize(2, 16.0f);
        TextViewCompat.setLineHeight(r126, ha0(22.0f));
        r126.setTypeface(Typeface.create(Typeface.create(PlatformFontCaps.DEFAULT_FAMILY_NAME, 0), 400, false));
        r125.addView(r126, new LinearLayout.LayoutParams(-1, -2));
        if (r124 == null) goto L24;
        LinearLayout.LayoutParams r127 = new LinearLayout.LayoutParams(-1, da0(32));
        int r128 = 6;
        r127.topMargin = da0(6);
        Unit r129 = Unit.INSTANCE;
        r125.addView(r124, r127);
    L25:
        OCardListItem r130 = new OCardListItem(requireContext(), null, r128, 0);
        r130.setCardType(2);
        OCardListItem.h(r130, 0);
        r130.setShowCardBg(true);
        r130.setCustomStartView(r125);
        r130.n(true);
        r130.m(false);
        r130.r(false);
        fa0(r130);
        r130.getCardContainer().setPadding(da0(8), da0(8), da0(8), da0(8));
        r130.getContentContainer().setPadding(0, 0, 0, 0);
        r130.o(false);
        Z90(r130);
        if (ja0() == false) goto L28;
        String r131 = getString(R.string.larus_dora_sound_cuetone_volume_desc_cn);
        Intrinsics.checkNotNull(r131);
    L29:
        LinearLayout r132 = aa0(this, r122, r130, r131);
        r113.addView(r132);
        this.f339655h = r132;
        if (ja0() == true) goto L32;
        View r133 = ba0(16);
        r113.addView(r133);
        this.f339658k = r133;
        LinearLayout r134 = aa0(this, null, ca0(this, getString(R.string.larus_dora_antiaudioleak_title_cn), getString(R.string.larus_dora_antisoundleak_button_cn), new f(this)), null);
        r113.addView(r134);
        this.f339656i = r134;
    L32:
        NestedScrollView r135 = new NestedScrollView(r106);
        r135.setClipChildren(true);
        r135.setClipToPadding(false);
        r135.setOverScrollMode(2);
        r135.setFillViewport(true);
        r135.setPadding(0, da0(8), 0, 0);
        r135.addView(r113, new ViewGroup.LayoutParams(-1, -2));
        return com.larus.dora.obric.utils.c.c(r100, r104, r135, v19.c.a(R.attr.larus_base_1_overlay, requireContext(), R.color.larus_base_1_overlay), new com.larus.dora.obric.device_management.setting.common.sound.a(this));
    L28:
        r131 = getString(R.string.larus_dora_g_device_vol_tip_cn);
        Intrinsics.checkNotNull(r131);
        goto L29
    L24:
        r128 = 6;
        goto L25
    L15:
        r116 = getString(R.string.larus_dora_sound_ambient_volume_adaptive_tips_cn);
        Intrinsics.checkNotNull(r116);
    L12:
        r115 = false;
        goto L13
    }

    public static LinearLayout aa0(DoraObricSoundSettingsFragment r110, String r111, OCardListItem r112, String r113) {
        r110.getClass();
        LinearLayout r100 = new LinearLayout(r110.requireContext());
        r100.setOrientation(1);
        r100.setClipChildren(false);
        r100.setClipToPadding(false);
        r100.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        if (r111 == null) goto L8;
        OSectionTitleBar r114 = new OSectionTitleBar(r110.requireContext(), null, 6, 0);
        LinearLayout r115 = (LinearLayout) r114.findViewById(R.id.container);
        if (r115 == null) goto L7;
        r115.setPadding(r110.da0(20), r110.da0(8), r110.da0(12), r110.da0(8));
    L7:
        r114.setTitleText(r111);
        r114.setTitleStyle(R.style.SectionTitle_S);
        r114.setLayoutParams(new LinearLayout.LayoutParams(-1, r110.da0(32)));
        r100.addView(r114);
    L8:
        r100.addView(r112);
        if (r113 == null) goto L14;
        OSectionSupportiveText r101 = new OSectionSupportiveText(r110.requireContext(), null, 6, 0);
        r101.setPadding(r110.da0(20), 0, r110.da0(20), 0);
        r101.setSectionDes(r113);
        TextView r102 = (TextView) r101.findViewById(R.id.section_des);
        if (r102 == null) goto L13;
        r102.setTextColor(ContextCompat.getColor(r110.requireContext(), R.color.oui_basic_text_3));
        r102.setTextSize(2, 12.0f);
        TextViewCompat.setLineHeight(r102, r110.ha0(16.0f));
        r102.setTypeface(Typeface.create(Typeface.create(PlatformFontCaps.DEFAULT_FAMILY_NAME, 0), 400, false));
    L13:
        r101.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r100.addView(r101);
    L14:
        return r100;
    }

    public static OCardListItem ca0(DoraObricSoundSettingsFragment r100, String r101, String r102, Function1 r103) {
        r100.getClass();
        OCardListItem r104 = new OCardListItem(r100.requireContext(), null, 6, 0);
        r104.setCardType(0);
        OCardListItem.h(r104, 0);
        r104.setShowCardBg(true);
        r104.p(false);
        r104.setTitle(r101);
        r104.s(true);
        r104.setSubTitle(r102);
        if (r102 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        r104.q(!r105);
        r104.setDefaultCustomEndView(1);
        r104.m(true);
        r104.r(false);
        OSwitch r106 = r104.getEndSwitch();
        if (r106 == null) goto L12;
        r103.invoke(r106);
    L12:
        r100.fa0(r104);
        r104.getCardContainer().setPadding(r100.da0(8), r100.da0(8), r100.da0(8), r100.da0(8));
        r104.getContentContainer().setPadding(0, 0, r100.da0(4), 0);
        r104.getTitleContainer().setGravity(16);
        r104.getTitleContainer().setPadding(r100.da0(12), r100.da0(10), r100.da0(8), r100.da0(10));
        OTextView r107 = r104.getTitleView();
        r107.setGravity(GravityCompat.START);
        r107.setMaxLines(1);
        r107.setTextColor(r100.ga0());
        r107.setTextSize(2, 16.0f);
        TextViewCompat.setLineHeight(r107, r100.ha0(22.0f));
        r107.setTypeface(Typeface.create(Typeface.create(PlatformFontCaps.DEFAULT_FAMILY_NAME, 0), 400, false));
        OTextView r108 = r104.getSubTitleView();
        r108.setMaxLines(5);
        r108.setTextColor(ContextCompat.getColor(r100.requireContext(), R.color.oui_basic_text_3));
        r108.setTextSize(2, 12.0f);
        TextViewCompat.setLineHeight(r108, r100.ha0(16.0f));
        r104.o(false);
        r100.Z90(r104);
        return r104;
    L5:
        if (r102.length() == 0) goto L8;
        r105 = false;
        goto L9
    }
}
