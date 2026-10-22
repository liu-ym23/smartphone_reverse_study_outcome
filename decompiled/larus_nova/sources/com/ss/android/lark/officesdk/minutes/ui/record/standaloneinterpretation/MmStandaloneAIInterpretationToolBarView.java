package com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.compose.foundation.widget.FlowSwitchStyle;
import com.ss.android.lark.foundation.widget.FlowSwitch;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 72\u00020\u0001:\u00017B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J \u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0012H\u0002J\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0012H\u0002J\u0018\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0012H\u0002J\u0018\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0012H\u0002J(\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0014J\b\u0010$\u001a\u00020\u0014H\u0014J\u0012\u0010%\u001a\u00020\u00142\b\b\u0002\u0010&\u001a\u00020\u0007H\u0002J\u0012\u0010'\u001a\u00020\u00142\b\u0010(\u001a\u0004\u0018\u00010\rH\u0002J\u001a\u0010)\u001a\u00020\u00142\b\u0010(\u001a\u0004\u0018\u00010\r2\u0006\u0010*\u001a\u00020\u0007H\u0002J\u0012\u0010+\u001a\u00020\u00072\b\u0010(\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0007H\u0002J\u001c\u0010.\u001a\u00020\u0014*\u00020\u00102\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u0007H\u0002J \u00101\u001a\u00020\u00142\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0007H\u0002J\b\u00105\u001a\u000206H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/standaloneinterpretation/MmStandaloneAIInterpretationToolBarView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/ss/android/lark/officesdk/minutes/ui/style/viewcontract/recording/MmRecordingAiNoteToolbarViewContract;", "saveSwitch", "Landroid/view/View;", "saveActionContainer", "stopButton", "Landroid/widget/ImageView;", "bindScope", "Lkotlinx/coroutines/CoroutineScope;", "bind", "", "scope", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/slot/scope/MmRecordingSlotScope;", "viewModel", "Lcom/ss/android/lark/officesdk/minutes/ui/record/standaloneinterpretation/MmStandaloneAIInterpretationViewModel;", "bindSaveSwitch", "coroutineScope", "showSettingsFailedToast", "subscribeDuration", "subscribeAudioVolume", "subscribeRecordingState", "onSizeChanged", "w", "h", "oldw", "oldh", "onDetachedFromWindow", "adjustActionWidthsIfNeeded", "viewWidthPx", "updateAdaptiveWidth", PickerReporterConstants.KEY.TARGET, "updateWidth", "widthDp", "getMarginStart", "dpToPx", "valueDp", "setIcon", "drawableRes", "colorRes", "applyResumePauseButtonStyle", "iconRes", "backgroundRes", "tintRes", "drawableProvider", "Lcom/ss/android/lark/officesdk/minutes/ui/style/contract/IMmUIDrawableProvider;", "Companion", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmStandaloneAIInterpretationToolBarView extends ConstraintLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f436731f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mwb.c f436732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f436733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f436734c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f436735d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CoroutineScope f436736e;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MmStandaloneAIInterpretationToolBarView f436737a;

        public a(MmStandaloneAIInterpretationToolBarView r100) {
            this.f436737a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MmStandaloneAIInterpretationToolBarView r100 = this.f436737a;     // Catch: Throwable -> L4
            MmStandaloneAIInterpretationToolBarView.R5(r100, r100.f436732a.f516038f.getWidth());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b {
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MmStandaloneAIInterpretationToolBarView f436738a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f436739b;

        public c(MmStandaloneAIInterpretationToolBarView r100, int r101) {
            this.f436738a = r100;
            this.f436739b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MmStandaloneAIInterpretationToolBarView r100 = this.f436738a;     // Catch: Throwable -> L14
            Integer r101 = Integer.valueOf(r100.f436732a.f516038f.getWidth());     // Catch: Throwable -> L14
            if (r101.intValue() <= 0) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == true) goto L9;
            r101 = null;
        L9:
            if (r101 == null) goto L11;
            int r103 = r101.intValue();     // Catch: Throwable -> L14
        L12:
            MmStandaloneAIInterpretationToolBarView.R5(r100, r103);     // Catch: Throwable -> L14
            return;
        L11:
            r103 = this.f436739b;     // Catch: Throwable -> L14
            goto L12
        L5:
            r102 = false;
        L14:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L18;
            return;
        L18:
            throw th;
        }
    }

    static {
    }

    public MmStandaloneAIInterpretationToolBarView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MmStandaloneAIInterpretationToolBarView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final com.ss.android.lark.officesdk.minutes.ui.style.contract.e T5() {
        com.ss.android.lark.officesdk.minutes.ui.style.e r100 = com.ss.android.lark.officesdk.minutes.ui.style.e.f436896a;
        MmRecordingUILaunchMode r101 = com.ss.android.lark.officesdk.minutes.ui.style.c.a(getContext());
        r100.getClass();
        return com.ss.android.lark.officesdk.minutes.ui.style.e.b(r101).getDrawable();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        CoroutineScope r100 = this.f436736e;
        if (r100 == null) goto L5;
        CoroutineScopeKt.cancel$default(r100, null, 1, null);
    L5:
        this.f436736e = null;
        super.onDetachedFromWindow();
    }

    public final void U5(View r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof LinearLayout.LayoutParams) == false) goto L7;
        LinearLayout.LayoutParams r102 = (LinearLayout.LayoutParams) r101;
    L8:
        if (r102 != null) goto L11;
        return;
    L11:
        if (r102.width == 0) goto L13;
    L18:
        r102.width = 0;
        r102.weight = 1.0f;
        r100.setLayoutParams(r102);
        r100.requestLayout();
        return;
    L13:
        if (r102.weight != 1.0f) goto L15;
        boolean r103 = true;
    L16:
        if (r103 == false) goto L18;
        return;
    L15:
        r103 = false;
        goto L16
    L7:
        r102 = null;
        goto L8
    }

    public static final void R5(MmStandaloneAIInterpretationToolBarView r100, int r101) {
        r100.getClass();
        Integer r102 = Integer.valueOf(r101);
        boolean r103 = false;
        if (r102.intValue() <= 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == true) goto L9;
        r102 = null;
    L9:
        if (r102 == null) goto L11;
        int r105 = r102.intValue();
    L12:
        Resources r106 = r100.getResources();
        float r107 = r105 / WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics()).density;
        if (r107 < 600.0f) goto L15;
        r103 = true;
    L15:
        if (r103 == false) goto L18;
        r100.U5(r100.f436732a.f516039g);
        r100.V5(r100.f436732a.f516040h, 108);
        r100.V5(r100.f436732a.f516041i, 108);
        return;
    L18:
        if (r107 <= 402.0f) goto L20;
        r100.U5(r100.f436732a.f516039g);
        r100.V5(r100.f436732a.f516040h, 78);
        r100.V5(r100.f436732a.f516041i, 78);
        return;
    L20:
        int r108 = 174;
        if (r107 >= 402.0f) goto L23;
        r108 = RangesKt.coerceAtLeast((int) (174 - (402 - r107)), 130);
    L23:
        Resources r109 = r100.getResources();
        TypedValue.applyDimension(1, r108, WindowDisplayMetricsOverride.apply(r109, r109.getDisplayMetrics()));
        r100.V5(r100.f436732a.f516039g, r108);
        r100.V5(r100.f436732a.f516040h, 78);
        r100.V5(r100.f436732a.f516041i, 78);
        return;
    L11:
        Resources r110 = r100.getResources();
        r105 = WindowDisplayMetricsOverride.apply(r110, r110.getDisplayMetrics()).widthPixels;
        goto L12
    L5:
        r104 = false;
        goto L6
    }

    public final void V5(View r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        Resources r102 = getResources();
        boolean r103 = true;
        int r104 = (int) TypedValue.applyDimension(1, r101, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()));
        ViewGroup.LayoutParams r105 = r100.getLayoutParams();
        if ((r105 instanceof LinearLayout.LayoutParams) == false) goto L7;
        LinearLayout.LayoutParams r106 = (LinearLayout.LayoutParams) r105;
    L8:
        if (r106 != null) goto L11;
        return;
    L11:
        if (r106.width == r104) goto L13;
    L18:
        r106.width = r104;
        r106.weight = 0.0f;
        r100.setLayoutParams(r106);
        r100.requestLayout();
        return;
    L13:
        if (r106.weight == 0.0f) goto L16;
        r103 = false;
    L16:
        if (r103 == false) goto L18;
        return;
    L7:
        r106 = null;
        goto L8
    }

    public MmStandaloneAIInterpretationToolBarView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        int r103 = mwb.c.f516032j;
        LayoutInflater r104 = LayoutInflater.from(r100);
        Intrinsics.checkNotNullParameter(r104, "inflater");
        mwb.c r105 = new mwb.c(r104.inflate(R.layout.office_sdk_mm_view_standalone_ai_interpretation_toolbar, this, true));
        this.f436732a = r105;
        ViewStub r106 = (ViewStub) findViewById(R.id.save_switch_stub);
        com.ss.android.lark.officesdk.minutes.ui.style.e r107 = com.ss.android.lark.officesdk.minutes.ui.style.e.f436896a;
        MmRecordingUILaunchMode r108 = com.ss.android.lark.officesdk.minutes.ui.style.c.a(r100);
        r107.getClass();
        r106.setLayoutResource(com.ss.android.lark.officesdk.minutes.ui.style.e.b(r108).getLayout().o());
        View r109 = r106.inflate();
        if ((r109 instanceof FlowSwitch) == false) goto L5;
        FlowSwitch r110 = (FlowSwitch) r109;
    L6:
        if (r110 == null) goto L8;
        r110.setStyle(FlowSwitchStyle.SMALL);
    L8:
        this.f436733b = r109;
        this.f436734c = findViewById(R.id.save_action_container);
        View r111 = r105.f516041i;
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView r112 = (ImageView) r111;
        this.f436735d = r112;
        Resources r113 = getResources();
        setMinHeight((int) TypedValue.applyDimension(1, 148, WindowDisplayMetricsOverride.apply(r113, r113.getDisplayMetrics())));
        r105.f516034b.setText("00:00");
        r105.f516036d.setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(r100).o(r100));
        r105.f516037e.setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(r100).c(r100));
        S5(T5().j(), T5().i(), T5().g());
        r112.setImageDrawable(UDIconUtils.getIconDrawable(r112.getContext(), R.drawable.ud_icon_base_agent_stop_filled, UIUtils.getColor(r112.getContext(), R.color.flow_ud_neutral_100)));
        r112.setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(r100).x(r100));
        r105.f516038f.post(new a(this));
        return;
    L5:
        r110 = null;
        goto L6
    }

    public final void S5(int r100, int r101, int r102) {
        this.f436732a.f516040h.setImageResource(r100);
        this.f436732a.f516040h.setImageTintList(ColorStateList.valueOf(UIUtils.getColor(getContext(), r102)));
        if (r101 == 0) goto L5;
        this.f436732a.f516040h.setBackgroundResource(r101);
        return;
    L5:
        this.f436732a.f516040h.setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(getContext()).z(getContext()));
    }

    public /* synthetic */ MmStandaloneAIInterpretationToolBarView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (r100 <= 0) goto L8;
        if (r100 == r102) goto L9;
        this.f436732a.f516038f.requestLayout();
        post(new c(this, r100));
        return;
    L9:
        return;
    }
}
