package com.larus.dora.obric.device_management.setting.earbuds.gesture;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.device.settings.gesture.wakeup.GestureWakeupType;
import com.larus.dora.impl.device.settings.gesture.wakeup.GestureWakeupViewModel;
import com.larus.dora.impl.view.DoraMovieView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.larus.utils.j0;
import com.lynx.textra.PlatformFontCaps;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 Q2\u00020\u0001:\u0001QB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001a\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010'\u001a\u00020%H\u0016J\b\u0010(\u001a\u00020)H\u0016J\n\u0010*\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010+\u001a\u00020\rH\u0002J\b\u0010,\u001a\u00020\rH\u0002J\b\u0010-\u001a\u00020\rH\u0002J\b\u0010.\u001a\u00020\rH\u0002J\b\u0010/\u001a\u00020\u0018H\u0002J\b\u00100\u001a\u00020%H\u0002J\u0010\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020\u0012H\u0002J\b\u00103\u001a\u00020%H\u0002J\b\u00104\u001a\u00020%H\u0002J\u0010\u00105\u001a\u00020%2\u0006\u00102\u001a\u00020\u0012H\u0002J\u0018\u00106\u001a\u00020%2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u0012H\u0002J\u0010\u00107\u001a\u00020%2\u0006\u00102\u001a\u00020\u0012H\u0002J\b\u00108\u001a\u00020%H\u0002J\b\u00109\u001a\u00020%H\u0002J.\u0010:\u001a\u00020\u00132\u0006\u0010;\u001a\u00020)2\u0006\u0010<\u001a\u00020)2\u0006\u0010=\u001a\u00020\u000b2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020%0?H\u0002J\u0018\u0010@\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\u000bH\u0002J\u0010\u0010C\u001a\u00020\r2\u0006\u0010;\u001a\u00020)H\u0002J\f\u0010D\u001a\u00020%*\u00020\u0013H\u0002J\f\u0010E\u001a\u00020%*\u00020\u0013H\u0002J\b\u0010F\u001a\u00020\u000bH\u0002J\b\u0010G\u001a\u00020\u000bH\u0002J\b\u0010H\u001a\u00020\u000bH\u0002J\b\u0010I\u001a\u00020\u000bH\u0002J\f\u0010J\u001a\u00020%*\u00020\u0018H\u0002J\f\u0010K\u001a\u00020%*\u00020\u0018H\u0002J\u0010\u0010L\u001a\u00020%2\u0006\u0010M\u001a\u00020\rH\u0002J\f\u0010N\u001a\u00020\u000b*\u00020\u000bH\u0002J\f\u0010O\u001a\u00020\u000b*\u00020PH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011j\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013`\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/earbuds/gesture/DoraObricEarbudsGestureWakeUpFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/device/settings/gesture/wakeup/GestureWakeupViewModel;", "getModel", "()Lcom/larus/dora/impl/device/settings/gesture/wakeup/GestureWakeupViewModel;", "model$delegate", "Lkotlin/Lazy;", "side", "", "pageMaskView", "Landroid/view/View;", "optionContainer", "Landroid/widget/LinearLayout;", "optionViews", "Ljava/util/LinkedHashMap;", "Lcom/larus/dora/impl/device/settings/gesture/wakeup/GestureWakeupType;", "Lcom/obric/oui/lisitem/OCardListItem;", "Lkotlin/collections/LinkedHashMap;", "hintSectionTitle", "hintGroup", "hintText", "Landroid/widget/TextView;", "hintVideo", "Lcom/larus/dora/impl/view/DoraMovieView;", "hintPlayIcon", "Landroid/widget/ImageView;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "getCurrentPageName", "", "getPageMaskView", "buildContentView", "buildTitleBar", "buildScrollContent", "buildHintVideoCard", "buildHintText", "initHintVideo", "updateHintVideo", "type", "releaseHintVideo", "setupOptions", "onOptionClicked", "updateSelectItemView", "updateSelectionMark", "observeState", "observeActions", "buildOptionCard", "title", "subtitle", "position", SendEventContainerMethodParamModel.EventKinds.onClick, "Lkotlin/Function0;", "resolveCardPosition", "index", "size", "buildSectionTitle", "applyCardStyle", "resetCardContainerMargins", "resolveBackgroundColor", "resolvePrimaryTextColor", "resolveSecondaryTextColor", "resolveCardBackgroundColor", "applyTitleBarTextStyle", "applySectionTitleTextStyle", "relaxClipForShadow", PickerReporterConstants.KEY.TARGET, "dp", CloudControlInf.SP, "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricEarbudsGestureWakeUpFragment extends DoraBaseFragment {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f340091p = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f340092f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f340093g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f340094h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinearLayout f340095i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinkedHashMap<GestureWakeupType, OCardListItem> f340096j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public OSectionTitleBar f340097k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f340098l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f340099m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public DoraMovieView f340100n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ImageView f340101o;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f340102a = null;

        static {
            int[] r100 = new int[GestureWakeupType.values().length];
            r100[GestureWakeupType.CLOSE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[GestureWakeupType.RADIO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[GestureWakeupType.RADIO_RECORD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[GestureWakeupType.RADIO_CONTINUOUS_DIALOGUE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f340102a = r100;
        }
    }

    static {
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        return "";
    }

    public final GestureWakeupViewModel Y90() {
        return (GestureWakeupViewModel) this.f340092f.getValue();
    }

    public final void Z90() {
        DoraMovieView r100 = this.f340100n;
        if (r100 == null) goto L5;
        r100.g();
    L5:
        DoraMovieView r101 = this.f340100n;
        if (r101 == null) goto L9;
        r101.f();
        return;
    }

    public DoraObricEarbudsGestureWakeUpFragment() {
        final Function0<Fragment> r100 = new DoraObricEarbudsGestureWakeUpFragment$special$$inlined$viewModels$default$1(this);
        this.f340092f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(GestureWakeupViewModel.class), new DoraObricEarbudsGestureWakeUpFragment$special$$inlined$viewModels$default$2(r100), new DoraObricEarbudsGestureWakeUpFragment$special$$inlined$viewModels$default$3(r100, this));
        this.f340096j = new LinkedHashMap();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        Z90();
        this.f340096j.clear();
        this.f340094h = null;
        this.f340095i = null;
        this.f340097k = null;
        this.f340098l = null;
        this.f340099m = null;
        this.f340100n = null;
        this.f340101o = null;
        super.onDestroyView();
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        return this.f340094h;
    }

    public final int X90(int r100) {
        Resources r101 = getResources();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
    }

    public final void aa0(GestureWakeupType r100) {
        Iterator<Map.Entry<GestureWakeupType, OCardListItem>> r101 = this.f340096j.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        Map.Entry<GestureWakeupType, OCardListItem> r102 = r101.next();
        GestureWakeupType r103 = r102.getKey();
        OCardListItem r104 = r102.getValue();
        if (r103 != r100) goto L8;
        boolean r105 = true;
    L9:
        r104.m(r105);
        goto L4
    L8:
        r105 = false;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r13v2, types: [com.larus.dora.obric.device_management.setting.earbuds.gesture.r] */
    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        Bundle r100 = getArguments();
        if (r100 == null) goto L5;
        int r101 = r100.getInt("device_side");
    L6:
        this.f340093g = r101;
        LinearLayout r102 = this.f340095i;
        int r103 = 1;
        if (r102 == null) goto L42;
        Context r104 = requireContext();
        List<GestureWakeupType> r105 = Y90().getGestureWakeupTypes();
        r102.removeAllViews();
        this.f340096j.clear();
        Iterator<T> r106 = r105.iterator();
        int r107 = 0;
    L11:
        if (r106.hasNext() == false) goto L42;
        Object r108 = r106.next();
        int r112 = r107 + 1;
        if (r107 >= 0) goto L15;
        CollectionsKt.throwIndexOverflow();
    L15:
        final GestureWakeupType r109 = (GestureWakeupType) r108;
        String r113 = r104.getString(r109.getTitleResId());
        if (r109.getSubtitleResId() <= 0) goto L18;
        String r114 = r104.getString(r109.getSubtitleResId());
    L19:
        Intrinsics.checkNotNull(r114);
        int r115 = r105.size();
        if (r115 > r103) goto L22;
        int r116 = 0;
    L28:
        final ?? r117 = new r(this, r109);
        final OCardListItem r118 = new OCardListItem(requireContext(), null, 6, 0);
        r118.setCardType(0);
        OCardListItem.h(r118, r116);
        r118.setShowCardBg(true);
        r118.p(false);
        r118.setTitle(r113);
        r118.s(true);
        if (r114.length() != 0) goto L31;
        boolean r119 = true;
    L32:
        if (r119 == false) goto L34;
        r118.q(false);
    L35:
        r118.setDefaultCustomEndView(2);
        r118.m(false);
        r118.r(false);
        ViewGroup.LayoutParams r120 = r118.getCardContainer().getLayoutParams();
        if ((r120 instanceof ViewGroup.MarginLayoutParams) == false) goto L38;
        ViewGroup.MarginLayoutParams r121 = (ViewGroup.MarginLayoutParams) r120;
    L39:
        if (r121 == null) goto L41;
        r121.setMarginStart(0);
        r121.setMarginEnd(0);
        r121.leftMargin = 0;
        r121.rightMargin = 0;
        r118.getCardContainer().setLayoutParams(r121);
    L41:
        r118.getContentContainer().setPadding(0, 0, X90(4), 0);
        r118.getTitleContainer().setGravity(16);
        r118.getTitleContainer().setPadding(X90(12), X90(10), X90(8), X90(10));
        OTextView r122 = r118.getTitleView();
        r122.setGravity(GravityCompat.START);
        r122.setMaxLines(1);
        r122.setTextColor(v19.c.a(R.attr.larus_neutral_100, requireContext(), R.color.larus_neutral_100));
        r122.setTextSize(2, 16.0f);
        Resources r123 = getResources();
        TextViewCompat.setLineHeight(r122, (int) TypedValue.applyDimension(2, 22.0f, WindowDisplayMetricsOverride.apply(r123, r123.getDisplayMetrics())));
        r122.setTypeface(Typeface.create(Typeface.create(PlatformFontCaps.DEFAULT_FAMILY_NAME, 0), 400, false));
        r118.o(false);
        r118.setOnContentClickListener(new s(r118, r117));
        this.f340096j.put(r109, r118);
        r102.addView(r118);
        r107 = r112;
        r103 = 1;
        goto L11
    L38:
        r121 = null;
        goto L39
    L34:
        r118.setSubTitle(r114);
        r118.getSubTitleView().setMaxLines(5);
        r118.q(true);
        goto L35
    L31:
        r119 = false;
        goto L32
    L22:
        if (r107 != 0) goto L25;
        r116 = 1;
        goto L28
    L25:
        if (r107 != (r115 - 1)) goto L27;
        r116 = 3;
        goto L28
    L27:
        r116 = 2;
        goto L28
    L18:
        r114 = "";
    L42:
        final DoraMovieView r124 = this.f340100n;
        if (r124 == null) goto L49;
        final ImageView r125 = this.f340101o;
        if (r125 == null) goto L49;
        r124.setLooping(Boolean.TRUE);
        r124.setPauseInFirst(true);
        r124.setMediaPlayerStartListener(new p(r125));
        e1.d(r124, new q(r124, r125));
    L49:
        Lifecycle.State r126 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricEarbudsGestureWakeUpFragment$observeState$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r126, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricEarbudsGestureWakeUpFragment$observeState$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r126, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricEarbudsGestureWakeUpFragment$observeActions$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r126, null, this), 3, null);
        return;
    L5:
        r101 = 0;
        goto L6
    }

    public static final void W90(final DoraObricEarbudsGestureWakeUpFragment r100, int r101, GestureWakeupType r102) {
        if (r101 != 0) goto L4;
    L6:
        r100.aa0(r102);
        final DoraMovieView r103 = r100.f340100n;
        if (r103 == null) goto L39;
        View r104 = r100.f340098l;
        if (r104 == null) goto L40;
        OSectionTitleBar r105 = r100.f340097k;
        if (r105 == null) goto L41;
        TextView r106 = r100.f340099m;
        if (r106 == null) goto L42;
        int r107 = b.f340102a[r102.ordinal()];
        if (r107 != 1) goto L21;
        r105.setVisibility(8);
        r104.setVisibility(8);
        r106.setVisibility(8);
        return;
    L21:
        if (r107 != 2) goto L23;
    L29:
        r105.setVisibility(0);
        r104.setVisibility(0);
        r106.setVisibility(0);
        if (r102 != GestureWakeupType.RADIO) goto L32;
        String r108 = r100.getString(R.string.larus_dora_wakeup_gesture_radio_title_cn);
    L33:
        r106.setText(r108);
        r103.post(new l(r100, r103));
        return;
    L32:
        r108 = r100.getString(R.string.larus_dora_quick_note_long_press_cn);
        goto L33
    L23:
        if (r107 == 3) goto L29;
        if (r107 != 4) goto L28;
        r105.setVisibility(0);
        r104.setVisibility(0);
        r106.setVisibility(0);
        r106.setText(r100.getString(R.string.larus_dora_wakeup_gesture_radio_continuous_dialogue_title_cn));
        r103.post(new m(r100, r103));
        return;
    L28:
        throw new NoWhenBranchMatchedException();
    L42:
        return;
    L41:
        return;
    L40:
        return;
    L39:
        return;
    L4:
        if (r101 == r100.f340093g) goto L6;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        Context r100 = requireContext();
        LinearLayout r101 = new LinearLayout(r100);
        r101.setOrientation(1);
        r101.setClipChildren(true);
        r101.setClipToPadding(true);
        r101.setBackgroundColor(v19.c.a(R.attr.larus_base_1_overlay, requireContext(), R.color.larus_base_1_overlay));
        OFloatingTitleBar r102 = new OFloatingTitleBar(requireContext(), null, 6, 0);
        com.larus.dora.obric.utils.c.a(r102);
        r102.setBackgroundColor(v19.c.a(R.attr.larus_base_1_overlay, requireContext(), R.color.larus_base_1_overlay));
        int r103 = j0.f375426a;
        r102.setCenterTitle(j0.d(R.string.larus_dora_wakeup_gesture_title_cn));
        r102.setCenterTitleColor(v19.c.a(R.attr.larus_neutral_100, requireContext(), R.color.larus_neutral_100));
        TextView r104 = (TextView) r102.findViewById(R.id.center_title);
        if (r104 == null) goto L5;
        r104.setTextColor(v19.c.a(R.attr.larus_neutral_100, requireContext(), R.color.larus_neutral_100));
        r104.setTextSize(2, 16.0f);
        Resources r105 = getResources();
        TextViewCompat.setLineHeight(r104, (int) TypedValue.applyDimension(2, 22.0f, WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics())));
        r104.setTypeface(Typeface.create(Typeface.create(PlatformFontCaps.DEFAULT_FAMILY_NAME, 0), 600, false));
    L5:
        r102.R(false);
        final View r106 = OFloatingTitleBar.k(r102, null, 6);
        r106.setOnClickListener(new n(this));
        r102.post(new o(this, r106));
        r101.addView(r102, new LinearLayout.LayoutParams(-1, -2));
        Context r107 = requireContext();
        LinearLayout r108 = new LinearLayout(r107);
        r108.setOrientation(1);
        r108.setClipChildren(false);
        r108.setClipToPadding(false);
        r108.setPadding(X90(12), 0, X90(12), X90(16));
        LinearLayout r109 = new LinearLayout(r107);
        r109.setOrientation(1);
        r109.setClipChildren(false);
        r109.setClipToPadding(false);
        this.f340095i = r109;
        r108.addView(r109);
        String r113 = j0.d(R.string.larus_dora_wakeup_gesture_hint_title_cn);
        OSectionTitleBar r114 = new OSectionTitleBar(requireContext(), null, 6, 0);
        LinearLayout r115 = (LinearLayout) r114.findViewById(R.id.container);
        if (r115 == null) goto L8;
        r115.setPadding(X90(20), X90(8), X90(12), X90(8));
    L8:
        r114.setTitleText(r113);
        r114.setTitleTextSize(12.0f);
        r114.setTitleTextColor(ContextCompat.getColor(requireContext(), R.color.oui_basic_text_3));
        TextView r116 = (TextView) r114.findViewById(R.id.titleTextView);
        if (r116 == null) goto L11;
        r116.setTextColor(ContextCompat.getColor(requireContext(), R.color.oui_basic_text_3));
        r116.setTextSize(2, 12.0f);
        Resources r117 = getResources();
        TextViewCompat.setLineHeight(r116, (int) TypedValue.applyDimension(2, 16.0f, WindowDisplayMetricsOverride.apply(r117, r117.getDisplayMetrics())));
        r116.setTypeface(Typeface.create(Typeface.create(PlatformFontCaps.DEFAULT_FAMILY_NAME, 0), 500, false));
    L11:
        r114.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        ViewGroup.LayoutParams r118 = r114.getLayoutParams();
        if ((r118 instanceof LinearLayout.LayoutParams) == false) goto L14;
        LinearLayout.LayoutParams r119 = (LinearLayout.LayoutParams) r118;
    L15:
        if (r119 == null) goto L17;
        r119.topMargin = X90(16);
    L17:
        r114.setVisibility(8);
        r108.addView(r114);
        this.f340097k = r114;
        Context r120 = requireContext();
        GradientDrawable r121 = new GradientDrawable();
        r121.setShape(0);
        r121.setCornerRadius(X90(20));
        r121.setColor(v19.c.a(R.attr.larus_base_2, requireContext(), R.color.larus_base_2));
        FrameLayout r122 = new FrameLayout(r120);
        r122.setBackground(r121);
        r122.setClipToOutline(true);
        r122.setLayoutParams(new LinearLayout.LayoutParams(-1, X90(252)));
        DoraMovieView r123 = new DoraMovieView(r120);
        r123.setClipToOutline(true);
        r122.addView(r123, new FrameLayout.LayoutParams(-1, -1, 17));
        this.f340100n = r123;
        ImageView r124 = new ImageView(r120);
        r124.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r124.setImageResource(R.drawable.larus_dora_img_ailab_play);
        r124.setVisibility(8);
        r122.addView(r124, new FrameLayout.LayoutParams(X90(48), X90(48), 17));
        this.f340101o = r124;
        r122.setVisibility(8);
        r108.addView(r122);
        this.f340098l = r122;
        TextView r125 = new TextView(requireContext());
        r125.setGravity(17);
        r125.setTextAlignment(4);
        r125.setTextColor(ContextCompat.getColor(requireContext(), R.color.oui_basic_text_3));
        r125.setTextSize(2, 13.0f);
        LinearLayout.LayoutParams r126 = new LinearLayout.LayoutParams(-2, -2);
        r126.gravity = 1;
        r126.setMarginStart(X90(16));
        r126.setMarginEnd(X90(16));
        r126.topMargin = X90(8);
        r125.setLayoutParams(r126);
        r125.setVisibility(8);
        r108.addView(r125);
        this.f340099m = r125;
        NestedScrollView r127 = new NestedScrollView(r107);
        r127.setClipChildren(false);
        r127.setClipToPadding(false);
        r127.setOverScrollMode(2);
        r127.setFillViewport(true);
        r127.setPadding(0, X90(16), 0, 0);
        r127.addView(r108, new ViewGroup.LayoutParams(-1, -2));
        r101.addView(r127, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        FrameLayout r128 = new FrameLayout(r100);
        r128.setBackgroundColor(v19.c.a(R.attr.larus_base_1_overlay, requireContext(), R.color.larus_base_1_overlay));
        r128.addView(r101, new FrameLayout.LayoutParams(-1, -1));
        View r129 = new View(r100);
        r129.setBackgroundColor(ContextCompat.getColor(r100, R.color.larus_dora_page_mask_color));
        r129.setClickable(true);
        r129.setFocusable(true);
        r128.addView(r129, new FrameLayout.LayoutParams(-1, -1));
        this.f340094h = r129;
        return r128;
    L14:
        r119 = null;
        goto L15
    }
}
