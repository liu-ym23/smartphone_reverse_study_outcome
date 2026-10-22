package com.larus.dora.impl.device.settings.gesture;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import androidx.activity.OnBackPressedDispatcher;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemGroupTitle;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.databinding.LarusDoraPageGestureSettingsBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.device.settings.gesture.options.OptionModel;
import com.larus.dora.impl.device.settings.gesture.wakeup.GestureWakeupType;
import com.larus.dora.impl.device.settings.gesture.widget.DoraGestureGuidanceMaskView;
import com.larus.dora.impl.model.GestureSettingsKey;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.util.DoraImageType;
import com.larus.dora.impl.util.DoraResourceUtil;
import com.larus.dora.impl.util.DoraSKU;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.larus.utils.j0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.dora.IObricDoraService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\b\u000b\u0018\u0000 :2\u00020\u0001:\u0001:B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010!\u001a\u00020\u001fH\u0002J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u0017H\u0002J\u0012\u0010$\u001a\u0004\u0018\u00010\t2\u0006\u0010%\u001a\u00020\u0012H\u0002J\u0018\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020+H\u0016J#\u0010,\u001a\u0004\u0018\u00010\u001f2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002000.H\u0002¢\u0006\u0002\u00101J\n\u00102\u001a\u0004\u0018\u00010\u0017H\u0016J\u000f\u00103\u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0002\u00104J\u000f\u00105\u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0002\u00104J\u0010\u00106\u001a\u00020\u001f2\u0006\u00107\u001a\u00020\u0012H\u0002J\u0010\u00108\u001a\u00020\u001f2\u0006\u00107\u001a\u00020\u0012H\u0002J\b\u00109\u001a\u00020\u001fH\u0002R\u0018\u0010\u0004\u001a\u00020\u0005*\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/larus/dora/impl/device/settings/gesture/GestureSettingsFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "dp", "", "getDp", "(I)I", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageGestureSettingsBinding;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/device/settings/gesture/GestureSettingsViewModel;", "getModel", "()Lcom/larus/dora/impl/device/settings/gesture/GestureSettingsViewModel;", "model$delegate", "Lkotlin/Lazy;", "isFirst", "isSupportSimulInterpret", "", "isSupportOta3p5", "doraGestureGuidanceMask", "Lcom/larus/dora/impl/device/settings/gesture/widget/DoraGestureGuidanceMaskView;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setSimultaneousInterpretGuideMask", "showGuideMask", "targetItem", "updateGestureWakeupGroup", "isSupport", "updateGestureWakeup", "side", "type", "Lcom/larus/dora/impl/device/settings/gesture/wakeup/GestureWakeupType;", "getCurrentPageName", "", "bind", "map", "", "Lcom/larus/dora/impl/model/GestureSettingsKey;", "", "(Ljava/util/Map;)Lkotlin/Unit;", "getPageMaskView", "setupTitle", "()Lkotlin/Unit;", "setPrefer", "gotoMediaGestureSettingsPage", "isLeft", "gotoCallingGestureSettingsPage", "setupBackPressedCallback", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GestureSettingsFragment extends DoraBaseFragment {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f334391l = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LarusDoraPageGestureSettingsBinding f334392f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f334393g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f334394h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f334395i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f334396j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public DoraGestureGuidanceMaskView f334397k;

    public static final class a {
    }

    public static final class b<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GestureSettingsFragment f334398a;

        public b(GestureSettingsFragment r100) {
            this.f334398a = r100;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object r100, Continuation r101) {
            c0 r102 = (c0) r100;
            if (Intrinsics.areEqual(r102, c0.a.f334429a) == true) goto L14;
            if (Intrinsics.areEqual(r102, c0.b.f334430a) == true) goto L14;
            if ((r102 instanceof c0.c) == false) goto L12;
            GestureSettingsFragment r103 = this.f334398a;
            Map<GestureSettingsKey, Byte> r104 = ((c0.c) r102).f334431a;
            LarusDoraPageGestureSettingsBinding r105 = r103.f334392f;
            if (r105 == null) goto L14;
            ItemTextArrow r106 = r105.f332955e;
            GestureSettingsRepository r107 = GestureSettingsRepository.f334402a;
            Byte r108 = r104.get(GestureSettingsKey.MEDIA_LEFT_DOUBLE_CLICK);
            r107.getClass();
            String r109 = GestureSettingsRepository.i(r108);
            int r110 = ItemTextArrow.f316958k;
            r106.Z5(r109, null);
            r105.f332956f.Z5(GestureSettingsRepository.i(r104.get(GestureSettingsKey.MEDIA_RIGHT_DOUBLE_CLICK)), null);
            r105.f332953c.Z5(GestureSettingsRepository.i(r104.get(GestureSettingsKey.CALLING_LEFT_DOUBLE_CLICK)), null);
            r105.f332954d.Z5(GestureSettingsRepository.i(r104.get(GestureSettingsKey.CALLING_RIGHT_DOUBLE_CLICK)), null);
            Unit r111 = Unit.INSTANCE;
            goto L14
        L12:
            throw new NoWhenBranchMatchedException();
        L14:
            return Unit.INSTANCE;
        }
    }

    public static final class c<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GestureSettingsFragment f334399a;

        public c(GestureSettingsFragment r100) {
            this.f334399a = r100;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object r100, Continuation r101) {
            com.larus.dora.impl.device.settings.gesture.wakeup.h r102 = (com.larus.dora.impl.device.settings.gesture.wakeup.h) r100;
            if (r102 == null) goto L26;
            GestureWakeupType r103 = r102.getType();
            if (r103 == null) goto L26;
            GestureSettingsFragment r104 = this.f334399a;
            int r105 = r102.f334536b;
            int r106 = GestureSettingsFragment.f334391l;
            r104.getClass();
            if (r105 != 0) goto L9;
        L11:
            LarusDoraPageGestureSettingsBinding r107 = r104.f334392f;
            if (r107 == null) goto L16;
            ItemTextArrow r108 = r107.f332959i;
            if (r108 == null) goto L16;
            int r109 = j0.f375426a;
            String r110 = j0.d(r103.getTitleResId());
            int r111 = ItemTextArrow.f316958k;
            r108.Z5(r110, null);
        L16:
            if (r105 != 0) goto L18;
        L20:
            LarusDoraPageGestureSettingsBinding r112 = r104.f334392f;
            if (r112 == null) goto L26;
            ItemTextArrow r113 = r112.f332960j;
            if (r113 == null) goto L26;
            int r114 = j0.f375426a;
            String r115 = j0.d(r103.getTitleResId());
            int r116 = ItemTextArrow.f316958k;
            r113.Z5(r115, null);
            goto L26
        L18:
            if (r105 == 2) goto L20;
        L9:
            if (r105 == 1) goto L11;
        L26:
            return Unit.INSTANCE;
        }
    }

    public static final class d<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GestureSettingsFragment f334400a;

        public d(GestureSettingsFragment r100) {
            this.f334400a = r100;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object r100, Continuation r101) {
            boolean r102 = ((Boolean) r100).booleanValue();
            final GestureSettingsFragment r103 = this.f334400a;
            LarusDoraPageGestureSettingsBinding r104 = r103.f334392f;
            if (r104 == null) goto L8;
            if (r102 == false) goto L6;
            e1.x(r104.f332957g);
            e1.x(r104.f332958h);
            e1.d(r104.f332959i, new t(r103));
            e1.d(r104.f332960j, new u(r103));
            goto L8
        L6:
            e1.o(r104.f332957g);
            e1.o(r104.f332958h);
        L8:
            return Unit.INSTANCE;
        }
    }

    static {
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        return "gesture_setting";
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        LarusDoraPageGestureSettingsBinding r100 = this.f334392f;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f332961k;
    }

    public GestureSettingsFragment() {
        final Function0<Fragment> r100 = new GestureSettingsFragment$special$$inlined$viewModels$default$1(this);
        this.f334393g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(GestureSettingsViewModel.class), new GestureSettingsFragment$special$$inlined$viewModels$default$2(r100), new GestureSettingsFragment$special$$inlined$viewModels$default$3(r100, this));
    }

    public final void W90(boolean r100) {
        if (r100 == false) goto L4;
        GestureSettingsKey r101 = GestureSettingsKey.CALLING_LEFT_DOUBLE_CLICK;
    L5:
        ArrayList r102 = CollectionsKt.arrayListOf(new OptionModel[]{new OptionModel(getString(R.string.larus_dora_gesture_calling_hang_up_or_answer_cn), "", r101, (byte) 1), new OptionModel(getString(R.string.larus_dora_gesture_calling_answer_cn), "", r101, (byte) 2), new OptionModel(getString(R.string.larus_dora_gesture_calling_hang_up_cn), "", r101, (byte) 3), new OptionModel(getString(R.string.larus_dora_gesture_none_cn), "", r101, (byte) 0)});
        if (r100 == false) goto L8;
        String r103 = getString(R.string.larus_dora_gesture_double_click_left_cn);
    L9:
        Intrinsics.checkNotNull(r103);
        com.bytedance.router.i r104 = SmartRouter.buildRoute(getContext(), "//dora_options_activity");
        Bundle r105 = com.larus.utils.f.c(new Pair[0]);
        by7.h.k(r105, this);
        r104.f267554c.putExtras(r105);
        r104.f267554c.putExtra("options_title", r103);
        r104.f267554c.putExtra("options_data", r102);
        r104.f267555d = R.anim.larus_router_slide_in_right;
        r104.f267556e = R.anim.larus_router_no_anim;
        r104.d();
        return;
    L8:
        r103 = getString(R.string.larus_dora_gesture_double_click_right_cn);
        goto L9
    L4:
        r101 = GestureSettingsKey.CALLING_RIGHT_DOUBLE_CLICK;
        goto L5
    }

    public final void X90(boolean r100) {
        DoraGestureGuidanceMaskView r101 = this.f334397k;
        if (r101 == null) goto L5;
        r101.setVisibility(8);
    L5:
        if (r100 == false) goto L7;
        GestureSettingsKey r102 = GestureSettingsKey.MEDIA_LEFT_DOUBLE_CLICK;
    L8:
        boolean r103 = true;
        ArrayList r104 = CollectionsKt.arrayListOf(new OptionModel[]{new OptionModel(getString(R.string.larus_dora_gesture_media_play_or_pause_cn), "", r102, (byte) 16), new OptionModel(getString(R.string.larus_dora_gesture_media_previous_cn), "", r102, (byte) 19), new OptionModel(getString(R.string.larus_dora_gesture_media_next_cn), "", r102, (byte) 20)});
        if (this.f334395i == false) goto L12;
        r104.add(new OptionModel(getString(R.string.larus_dora_gesture_start_end_simul_interpret_cn), "", r102, (byte) 34));
    L12:
        if (this.f334396j == false) goto L21;
        IObricDoraService r105 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r105 != null) goto L16;
    L18:
        r103 = false;
    L19:
        if (r103 == true) goto L21;
        r104.add(new OptionModel(getString(R.string.larus_dora_broadcast_tips_cn), "", r102, (byte) -1));
        goto L21
    L16:
        if (r105.t() != true) goto L18;
    L21:
        r104.add(new OptionModel(getString(R.string.larus_dora_gesture_none_cn), "", r102, (byte) 0));
        if (r100 == false) goto L24;
        String r106 = getString(R.string.larus_dora_gesture_double_click_left_cn);
    L25:
        Intrinsics.checkNotNull(r106);
        com.bytedance.router.i r107 = SmartRouter.buildRoute(getContext(), "//dora_options_activity");
        Bundle r108 = com.larus.utils.f.c(new Pair[0]);
        by7.h.k(r108, this);
        r107.f267554c.putExtras(r108);
        r107.f267554c.putExtra("options_title", r106);
        r107.f267554c.putExtra("options_data", r104);
        r107.f267555d = R.anim.larus_router_slide_in_right;
        r107.f267556e = R.anim.larus_router_no_anim;
        r107.d();
        return;
    L24:
        r106 = getString(R.string.larus_dora_gesture_double_click_right_cn);
        goto L25
    L7:
        r102 = GestureSettingsKey.MEDIA_RIGHT_DOUBLE_CLICK;
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r210, Bundle r211) {
        Intrinsics.checkNotNullParameter(r210, "view");
        super.onViewCreated(r210, r211);
        Bundle r100 = getArguments();
        boolean r101 = false;
        if (r100 == null) goto L5;
        int r102 = r100.getInt(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST);
    L6:
        this.f334394h = r102;
        IDoraService r103 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r103 == null) goto L13;
        DeviceService r104 = r103.device();
        if (r104 == null) goto L13;
        if (r104.j0() != true) goto L13;
        boolean r105 = true;
    L14:
        this.f334395i = r105;
        if (r103 == null) goto L21;
        DeviceService r106 = r103.device();
        if (r106 == null) goto L21;
        if (r106.q0(null) != true) goto L21;
        boolean r107 = true;
    L22:
        this.f334396j = r107;
        LarusDoraPageGestureSettingsBinding r108 = this.f334392f;
        if (r108 == null) goto L29;
        NovaTitleBarEx r109 = r108.f332962l;
        NovaTitleBarEx.Y5(r109, getString(R.string.larus_dora_device_gesture_settings_cn), null, null, 6);
        NovaTitleBarEx.b6(r109, R.drawable.larus_dora_ic_left_back, false, null, null, new v(this), 14);
        DoraDevice r110 = DoraAdapterExtKt.h(kj4.a.g());
        if (r110 == null) goto L27;
        Integer r111 = Integer.valueOf(r110.sku);
    L28:
        DoraSKU r112 = DoraSKU.a.b(DoraSKU.Companion, r111);
        g49.d.d("GestureSettingsFragment", "GestureSettings sku=" + r111 + ", doraSku name is " + r112);
        ImageView r113 = r108.f332952b;
        DoraResourceUtil r114 = DoraResourceUtil.f338111a;
        r113.setImageBitmap(DoraResourceUtil.c(DoraImageType.IMAGE_ONBOARDING_POPUP_HEADPHONE_GESTURE.fileName(r112)));
        Unit r115 = Unit.INSTANCE;
        goto L29
    L27:
        r111 = null;
    L29:
        final LarusDoraPageGestureSettingsBinding r116 = this.f334392f;
        if (r116 == null) goto L65;
        e1.d(r116.f332955e, new w(this));
        e1.d(r116.f332956f, new x(this));
        if (this.f334394h != 0) goto L34;
    L47:
        e1.d(r116.f332953c, new z(this));
        e1.d(r116.f332954d, new a0(this));
        IDoraService r117 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r117 == null) goto L54;
        DeviceService r118 = r117.device();
        if (r118 == null) goto L54;
        if (r118.q0(null) != true) goto L54;
        boolean r119 = true;
    L55:
        if (r119 == false) goto L63;
        IObricDoraService r120 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r120 != null) goto L59;
    L61:
        if (r101 == true) goto L63;
        e1.x(r116.f332960j);
        r116.f332959i.setText(getString(R.string.larus_dora_long_press_left_cn));
    L64:
        Unit r121 = Unit.INSTANCE;
        goto L65
    L59:
        if (r120.t() != true) goto L61;
        r101 = true;
    L63:
        r116.f332959i.setText(getString(R.string.larus_dora_wakeup_gesture_long_press_cn));
        e1.o(r116.f332960j);
    L54:
        r119 = false;
        goto L55
    L34:
        if (this.f334395i == false) goto L47;
        Window r122 = requireActivity().getWindow();
        if (r122 == null) goto L42;
        View r123 = r122.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L43;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r124 = ThreadMethodProxy.currentThread();
        if (r124 == com.larus.home.impl.utils.c.f346341a) goto L43;
        com.larus.home.impl.utils.c.a(r124, "getDecorView");
    L43:
        Intrinsics.checkNotNull(r123, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r125 = (ViewGroup) r123;
        this.f334397k = new DoraGestureGuidanceMaskView(requireContext(), null, 6, 0);
        FrameLayout.LayoutParams r126 = new FrameLayout.LayoutParams(-1, -1);
        DoraGestureGuidanceMaskView r127 = this.f334397k;
        if (r127 == null) goto L46;
        boolean r128 = v19.h.f552477a;
        r127.setDarkMode(v19.h.a(null));
        r127.setClickable(false);
        r127.setFocusable(true);
    L46:
        r125.addView(this.f334397k, r126);
        r116.f332956f.post(new y(this, r116));
        this.f334394h = 0;
        goto L47
    L42:
        r123 = null;
    L65:
        FragmentActivity r129 = getActivity();
        if (r129 == null) goto L70;
        OnBackPressedDispatcher r130 = r129.getOnBackPressedDispatcher();
        if (r130 == null) goto L70;
        r130.addCallback(getViewLifecycleOwner(), new GestureSettingsFragment$setupBackPressedCallback$1(this));
    L70:
        Lifecycle.State r131 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new GestureSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r131, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new GestureSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r131, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new GestureSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r131, null, this), 3, null);
        return;
    L21:
        r107 = false;
    L13:
        r105 = false;
        goto L14
    L5:
        r102 = 0;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        View r100 = r110.inflate(R.layout.larus_dora_page_gesture_settings, r111, false);
        int r101 = R.id.dora_device_item;
        ImageView r102 = (ImageView) ViewBindings.findChildViewById(r100, R.id.dora_device_item);
        if (r102 == null) goto L33;
        r101 = R.id.dora_gesture_calling_group;
        if (((ItemGroup) ViewBindings.findChildViewById(r100, R.id.dora_gesture_calling_group)) == null) goto L33;
        r101 = R.id.dora_gesture_calling_left_ear;
        ItemTextArrow r103 = (ItemTextArrow) ViewBindings.findChildViewById(r100, R.id.dora_gesture_calling_left_ear);
        if (r103 == null) goto L33;
        r101 = R.id.dora_gesture_calling_right_ear;
        ItemTextArrow r104 = (ItemTextArrow) ViewBindings.findChildViewById(r100, R.id.dora_gesture_calling_right_ear);
        if (r104 == null) goto L33;
        r101 = R.id.dora_gesture_media_group;
        if (((ItemGroup) ViewBindings.findChildViewById(r100, R.id.dora_gesture_media_group)) == null) goto L33;
        r101 = R.id.dora_gesture_media_left_ear;
        ItemTextArrow r105 = (ItemTextArrow) ViewBindings.findChildViewById(r100, R.id.dora_gesture_media_left_ear);
        if (r105 == null) goto L33;
        r101 = R.id.dora_gesture_media_right_ear;
        ItemTextArrow r106 = (ItemTextArrow) ViewBindings.findChildViewById(r100, R.id.dora_gesture_media_right_ear);
        if (r106 == null) goto L33;
        r101 = R.id.dora_gesture_wakeup_group;
        ItemGroup r113 = (ItemGroup) ViewBindings.findChildViewById(r100, R.id.dora_gesture_wakeup_group);
        if (r113 == null) goto L33;
        r101 = R.id.dora_gesture_wakeup_group_title;
        ItemGroupTitle r114 = (ItemGroupTitle) ViewBindings.findChildViewById(r100, R.id.dora_gesture_wakeup_group_title);
        if (r114 == null) goto L33;
        r101 = R.id.dora_gesture_wakeup_left;
        ItemTextArrow r115 = (ItemTextArrow) ViewBindings.findChildViewById(r100, R.id.dora_gesture_wakeup_left);
        if (r115 == null) goto L33;
        r101 = R.id.dora_gesture_wakeup_right;
        ItemTextArrow r116 = (ItemTextArrow) ViewBindings.findChildViewById(r100, R.id.dora_gesture_wakeup_right);
        if (r116 == null) goto L33;
        r101 = R.id.dora_page_mask;
        View r117 = ViewBindings.findChildViewById(r100, R.id.dora_page_mask);
        if (r117 == null) goto L33;
        r101 = R.id.scroll_view;
        if (((ScrollView) ViewBindings.findChildViewById(r100, R.id.scroll_view)) == null) goto L33;
        r101 = R.id.title;
        NovaTitleBarEx r118 = (NovaTitleBarEx) ViewBindings.findChildViewById(r100, R.id.title);
        if (r118 == null) goto L33;
        ConstraintLayout r107 = (ConstraintLayout) r100;
        this.f334392f = new LarusDoraPageGestureSettingsBinding(r107, r102, r103, r104, r105, r106, r113, r114, r115, r116, r117, r118);
        return r107;
    L33:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }
}
