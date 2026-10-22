package com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.ui.entity.MmBubbleDirection;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.l;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MMRecordingState;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingFragment;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel;
import com.ss.android.lark.officesdk.minutes.ui.style.e;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 Q2\u00020\u0001:\u0001QB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0007J*\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00140$J\u0012\u0010&\u001a\u00020\u001c2\b\u0010'\u001a\u0004\u0018\u00010\rH\u0002J(\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0007H\u0014J\u0010\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u0007H\u0002J\u0012\u0010/\u001a\u00020\u001c2\b\b\u0002\u0010.\u001a\u00020\u0007H\u0002J\u0012\u00100\u001a\u00020\u001c2\b\u00101\u001a\u0004\u0018\u000102H\u0002J\u001a\u00103\u001a\u00020\u001c2\b\u00101\u001a\u0004\u0018\u0001022\u0006\u00104\u001a\u00020\u0007H\u0002J\u0012\u00105\u001a\u00020\u00072\b\u00101\u001a\u0004\u0018\u000102H\u0002J\u0010\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0007H\u0002J,\u00108\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020 2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00140$H\u0002J\u0018\u00109\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020 H\u0002J,\u0010:\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020 2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00140$H\u0002J\u0010\u0010;\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0018\u0010<\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010=\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0018\u0010>\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010?\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0016\u0010@\u001a\u00020\u00142\u0006\u0010A\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020 J\u0010\u0010B\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010C\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010D\u001a\u00020\u001cH\u0002J\b\u0010E\u001a\u00020\u001cH\u0002J$\u0010F\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00140$H\u0002J\b\u0010G\u001a\u00020\u001cH\u0002J \u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u00072\u0006\u0010J\u001a\u00020\u00072\u0006\u0010K\u001a\u00020\u0007H\u0002J\u0010\u0010L\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020 H\u0002J$\u0010M\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00140$H\u0002J\b\u0010N\u001a\u00020\u001cH\u0014J\u000e\u0010O\u001a\u0004\u0018\u00010P*\u00020\u0003H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/toolbar/MmRecordingAINoteToolBarView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/ss/android/lark/officesdk/minutes/ui/style/viewcontract/recording/MmRecordingAiNoteToolbarViewContract;", "inflatedUiLaunchMode", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;", "aiNoteControl", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/ainote/MmAINoteControl;", "aiNoteControlKey", "", "aiNoteVisibilityListenerKey", "isAiNotePageShowing", "", "latestRecordingState", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/MMRecordingState;", "pauseResumeVisible", "aiNoteTooltipBubble", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/ui/IMmBubbleHandle;", "firstMarkTooltipBubble", "setBottomPadding", "", GXTemplateKey.FLEXBOX_PADDING, "bind", "viewModel", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/MmRecordingViewModel;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "onNavigateToSubtitle", "Lkotlin/Function1;", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/ainote/MmRecordingAINoteSubtitleNavigationRequest;", "ensureBinding", "uiLaunchMode", "onSizeChanged", "w", "h", "oldw", "oldh", "refreshActionWidths", "viewWidthPx", "adjustActionWidthsIfNeeded", "updateAdaptiveWidth", PickerReporterConstants.KEY.TARGET, "Landroid/view/View;", "updateWidth", "widthDp", "getMarginStart", "dpToPx", "valueDp", "subscribeDuration", "subscribeAudioVolume", "subscribeRecordingState", "renderResumePauseButton", "subscribePageViewTrack", "trackAiNotesEntryViewIfNeeded", "subscribeAINoteTooltip", "showAINoteTooltipAfterToolbarLayout", "showFirstMarkTooltipIfNeeded", "message", "canOpenAINote", "consumeAndDismissAINoteTooltip", "dismissAINoteTooltip", "dismissFirstMarkTooltip", "registerAINoteVisibilityListener", "syncRecordWaveBarState", "applyResumePauseButtonStyle", "iconRes", "backgroundRes", "tintRes", "buildAINoteOwnerKey", "getAINoteControl", "onDetachedFromWindow", "findFragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "Companion", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmRecordingAINoteToolBarView extends ConstraintLayout {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f436623k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public mwb.c f436624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MmRecordingUILaunchMode f436625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.a f436626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f436627d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f436628e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f436629f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public MMRecordingState f436630g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f436631h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public qub.a f436632i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public qub.a f436633j;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f436634a = null;

        static {
            int[] r100 = new int[MMRecordingState.values().length];
            r100[MMRecordingState.RECORDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[MMRecordingState.PAUSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f436634a = r100;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MmRecordingAINoteToolBarView f436635a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f436636b;

        public c(MmRecordingAINoteToolBarView r100, int r101) {
            this.f436635a = r100;
            this.f436636b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MmRecordingAINoteToolBarView r100 = this.f436635a;     // Catch: Throwable -> L16
            mwb.c r101 = r100.f436624a;     // Catch: Throwable -> L16
            Integer r102 = null;
            if (r101 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("binding");     // Catch: Throwable -> L16
            r101 = null;
        L5:
            Integer r103 = Integer.valueOf(r101.f516038f.getWidth());     // Catch: Throwable -> L16
            if (r103.intValue() <= 0) goto L8;
            boolean r104 = true;
        L9:
            if (r104 == false) goto L11;
            r102 = r103;
        L11:
            if (r102 == null) goto L13;
            int r105 = r102.intValue();     // Catch: Throwable -> L16
        L14:
            r100.Z5(r105);     // Catch: Throwable -> L16
            return;
        L13:
            r105 = this.f436636b;     // Catch: Throwable -> L16
            goto L14
        L8:
            r104 = false;
        L16:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L20;
            return;
        L20:
            throw th;
        }
    }

    static {
    }

    public MmRecordingAINoteToolBarView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MmRecordingAINoteToolBarView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        int r100 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.AI_NOTE, "MmRecordingAINoteToolBarView#onDetachedFromWindow", "unregister listener=" + this.f436628e, null, 8);
        qub.a r101 = this.f436632i;
        this.f436632i = null;
        if (r101 == null) goto L5;
        r101.hide();
    L5:
        qub.a r102 = this.f436633j;
        this.f436633j = null;
        if (r102 == null) goto L8;
        r102.hide();
    L8:
        com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.a r103 = this.f436626c;
        if (r103 == null) goto L11;
        String r104 = this.f436628e;
        Intrinsics.checkNotNullParameter(r104, "listenerKey");
        r103.f436076m.remove(r104);
    L11:
        super.onDetachedFromWindow();
    }

    public static final void T5(MmRecordingAINoteToolBarView r100) {
        if (r100.f436624a != null) goto L6;
        return;
    L6:
        if (r100.f436630g == MMRecordingState.RECORDING) goto L8;
    L10:
        boolean r101 = false;
    L11:
        int r102 = bwb.b.f21271a;
        mwb.c r103 = null;
        bwb.b.g(MmUiLogScene.AI_NOTE, "MmRecordingAINoteToolBarView#syncRecordWaveBarState", "shouldResume=" + r101 + " recordingState=" + r100.f436630g + " aiNoteShowing=" + r100.f436629f, null, 8);
        if (r101 == false) goto L18;
        mwb.c r104 = r100.f436624a;
        if (r104 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L17:
        r103.f516035c.g();
        return;
    L16:
        r103 = r104;
        goto L17
    L18:
        mwb.c r105 = r100.f436624a;
        if (r105 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L22:
        r103.f516035c.b();
        return;
    L21:
        r103 = r105;
        goto L22
    L8:
        if (r100.f436629f == true) goto L10;
        r101 = true;
        goto L11
    }

    public final void Z5(int r110) {
        mwb.c r100 = null;
        if (this.f436631h == true) goto L5;
        mwb.c r111 = this.f436624a;
        if (r111 != null) goto L109;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L110:
        c6(r100.f516039g);
        return;
    L109:
        r100 = r111;
        goto L110
    L5:
        if (this.f436624a == null) goto L115;
        Integer r112 = Integer.valueOf(r110);
        boolean r101 = true;
        if (r112.intValue() <= 0) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == true) goto L14;
        r112 = null;
    L14:
        if (r112 == null) goto L16;
        int r113 = r112.intValue();
    L17:
        Resources r103 = getResources();
        float r104 = r113 / WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).density;
        if (r104 < 600.0f) goto L20;
        boolean r105 = true;
    L21:
        if (r105 == false) goto L34;
        mwb.c r114 = this.f436624a;
        if (r114 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r114 = null;
    L25:
        c6(r114.f516039g);
        mwb.c r115 = this.f436624a;
        if (r115 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r115 = null;
    L28:
        i6(r115.f516040h, 108);
        mwb.c r116 = this.f436624a;
        if (r116 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L32:
        i6(r100.f516041i, 108);
        return;
    L31:
        r100 = r116;
        goto L32
    L34:
        if (r104 <= 402.0f) goto L46;
        mwb.c r117 = this.f436624a;
        if (r117 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r117 = null;
    L38:
        c6(r117.f516039g);
        mwb.c r118 = this.f436624a;
        if (r118 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r118 = null;
    L41:
        i6(r118.f516040h, 78);
        mwb.c r119 = this.f436624a;
        if (r119 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L45:
        i6(r100.f516041i, 78);
        return;
    L44:
        r100 = r119;
        goto L45
    L46:
        int r106 = 174;
        if (r104 >= 402.0f) goto L49;
        r106 = RangesKt.coerceAtLeast((int) (174 - (402 - r104)), 142);
    L49:
        Resources r107 = getResources();
        int r108 = (int) TypedValue.applyDimension(1, r106, WindowDisplayMetricsOverride.apply(r107, r107.getDisplayMetrics()));
        mwb.c r109 = this.f436624a;
        if (r109 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r109 = null;
    L52:
        Integer r120 = Integer.valueOf(r109.f516038f.getWidth());
        if (r120.intValue() > 0) goto L56;
        r101 = false;
    L56:
        if (r101 == true) goto L59;
        r120 = null;
    L59:
        if (r120 == null) goto L61;
        r113 = r120.intValue();
    L61:
        mwb.c r121 = this.f436624a;
        if (r121 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r121 = null;
    L64:
        int r122 = r113 - r121.f516038f.getPaddingLeft();
        mwb.c r123 = this.f436624a;
        if (r123 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r123 = null;
    L67:
        int r124 = (r122 - r123.f516038f.getPaddingRight()) - r108;
        mwb.c r125 = this.f436624a;
        if (r125 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r125 = null;
    L70:
        ImageView r126 = r125.f516040h;
        if (r126 == null) goto L73;
        ViewGroup.LayoutParams r127 = r126.getLayoutParams();
    L75:
        if ((r127 instanceof ViewGroup.MarginLayoutParams) == false) goto L77;
        ViewGroup.MarginLayoutParams r128 = (ViewGroup.MarginLayoutParams) r127;
    L78:
        if (r128 != null) goto L80;
        int r129 = 0;
    L81:
        int r130 = r124 - r129;
        mwb.c r131 = this.f436624a;
        if (r131 != null) goto L84;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r131 = null;
    L84:
        View r132 = r131.f516041i;
        if (r132 == null) goto L87;
        ViewGroup.LayoutParams r133 = r132.getLayoutParams();
    L89:
        if ((r133 instanceof ViewGroup.MarginLayoutParams) == false) goto L91;
        ViewGroup.MarginLayoutParams r134 = (ViewGroup.MarginLayoutParams) r133;
    L92:
        if (r134 != null) goto L94;
        int r135 = 0;
    L95:
        float r136 = RangesKt.coerceAtLeast(r130 - r135, 0) / 2.0f;
        Resources r137 = getResources();
        int r138 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast((int) (r136 / WindowDisplayMetricsOverride.apply(r137, r137.getDisplayMetrics()).density), 60), 78);
        mwb.c r139 = this.f436624a;
        if (r139 != null) goto L98;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r139 = null;
    L98:
        i6(r139.f516039g, r106);
        mwb.c r140 = this.f436624a;
        if (r140 != null) goto L101;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r140 = null;
    L101:
        i6(r140.f516040h, r138);
        mwb.c r141 = this.f436624a;
        if (r141 != null) goto L104;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L105:
        i6(r100.f516041i, r138);
        return;
    L104:
        r100 = r141;
        goto L105
    L94:
        r135 = r134.getMarginStart();
        goto L95
    L91:
        r134 = null;
        goto L92
    L87:
        r133 = null;
        goto L89
    L80:
        r129 = r128.getMarginStart();
        goto L81
    L77:
        r128 = null;
        goto L78
    L73:
        r127 = null;
        goto L75
    L20:
        r105 = false;
        goto L21
    L16:
        Resources r142 = getResources();
        r113 = WindowDisplayMetricsOverride.apply(r142, r142.getDisplayMetrics()).widthPixels;
        goto L17
    L10:
        r102 = false;
        goto L11
    }

    public final void c6(View r100) {
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

    public final void setBottomPadding(int r100) {
        setPadding(0, 0, 0, r100);
    }

    public static final FragmentActivity R5(MmRecordingAINoteToolBarView r100, Context r101) {
        r100.getClass();
    L4:
        if ((r101 instanceof ContextWrapper) == false) goto L9;
        if ((r101 instanceof FragmentActivity) == true) goto L13;
        r101 = ((ContextWrapper) r101).getBaseContext();
        goto L4
    L13:
        return (FragmentActivity) r101;
    L9:
        return null;
    }

    public static final void S5(MmRecordingAINoteToolBarView r100, MmRecordingViewModel r101) {
        r100.getClass();
        e r102 = e.f436896a;
        MmRecordingUILaunchMode r103 = r101.getUiLaunchMode();
        r102.getClass();
        com.ss.android.lark.officesdk.minutes.ui.style.contract.e r104 = e.b(r103).getDrawable();
        MMRecordingState r105 = r100.f436630g;
        int r106 = 0;
        if (r105 != MMRecordingState.RECORDING) goto L5;
    L8:
        boolean r107 = true;
    L9:
        mwb.c r108 = r100.f436624a;
        mwb.c r109 = null;
        if (r108 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r108 = null;
    L12:
        ImageView r110 = r108.f516040h;
        if (r100.f436631h == true) goto L16;
        r106 = 8;
    L16:
        r110.setVisibility(r106);
        mwb.c r111 = r100.f436624a;
        if (r111 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r111 = null;
    L19:
        r100.Z5(r111.f516038f.getWidth());
        int r112 = b.f436634a[r100.f436630g.ordinal()];
        if (r112 != 1) goto L22;
        r100.U5(r104.b(), r104.d(), r104.h());
    L26:
        mwb.c r113 = r100.f436624a;
        if (r113 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L30:
        r109.f516040h.setEnabled(r107);
        return;
    L29:
        r109 = r113;
        goto L30
    L22:
        if (r112 == 2) goto L24;
        r100.U5(r104.j(), r104.i(), r104.g());
        goto L26
    L24:
        r100.U5(r104.j(), r104.d(), r104.h());
        goto L26
    L5:
        if (r105 == MMRecordingState.PAUSED) goto L8;
        r107 = false;
        goto L9
    }

    public final com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.a Y5(final MmRecordingViewModel r110, Function1<? super l, Boolean> r111) {
        int r100 = com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.a.f436063n;
        String r101 = r110.getMeetingId();
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        String r102 = String.valueOf(hashCode());
        Intrinsics.checkNotNullParameter(r101, "meetingId");
        Intrinsics.checkNotNullParameter(r102, "token");
        if ((!StringsKt.isBlank(r101)) == false) goto L9;
        String r103 = "meeting_".concat(r101);
    L12:
        com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.a r104 = this.f436626c;
        if (r104 != null) goto L15;
    L17:
        if (r104 == null) goto L19;
        String r105 = this.f436628e;
        Intrinsics.checkNotNullParameter(r105, "listenerKey");
        r104.f436076m.remove(r105);
    L19:
        String r106 = r110.getMeetingId();
        if (r106 != null) goto L22;
        String r107 = "";
    L23:
        com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.a r108 = new com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.a(r103, r107, r110.getUiLaunchMode(), new MmRecordingAINoteToolBarView$getAINoteControl$1(r110), r111);
        this.f436626c = r108;
        this.f436627d = r103;
        return r108;
    L22:
        r107 = r106;
        goto L23
    L15:
        if (Intrinsics.areEqual(this.f436627d, r103) == false) goto L17;
        return r104;
    L9:
        if ((!StringsKt.isBlank(r102)) == false) goto L11;
        r103 = "token_" + r102;
        goto L12
    L11:
        r103 = "MmAINoteControl";
        goto L12
    }

    public final boolean b6(String r210, final MmRecordingViewModel r211) {
        Intrinsics.checkNotNullParameter(r210, "message");
        Intrinsics.checkNotNullParameter(r211, "viewModel");
        if (StringsKt.isBlank(r210) == false) goto L5;
        return false;
    L5:
        mwb.c r100 = this.f436624a;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r100 = null;
    L8:
        View r101 = r100.f516039g;
        qub.a r102 = this.f436633j;
        if (r102 != null) goto L11;
    L13:
        boolean r103 = false;
    L14:
        if (r103 == false) goto L19;
        qub.a r104 = this.f436633j;
        this.f436633j = null;
        if (r104 == null) goto L19;
        r104.hide();
    L19:
        if (isAttachedToWindow() == true) goto L21;
    L41:
        int r105 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.AI_NOTE, "showFirstMarkTooltipIfNeeded", "skip: view not ready, attached=" + isAttachedToWindow() + ", shown=" + isShown() + ", anchor=" + r101.getWidth() + Permission.EXECUTE + r101.getHeight(), null, 8);
        return false;
    L21:
        if (isShown() == false) goto L41;
        if (r101.getWidth() <= 0) goto L41;
        if (r101.getHeight() <= 0) goto L41;
        int r106 = UIUtils.dp2px(getContext(), 16.0f);
        int r107 = UIUtils.dp2px(getContext(), 18.0f);
        int r108 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast((getWidth() - (r106 * 2)) - r107, UIUtils.dp2px(getContext(), 80.0f)), UIUtils.dp2px(getContext(), 220.0f) - r107);
        int r109 = com.ss.android.lark.officesdk.minutes.ui.record.bubble.c.f435826a;
        boolean r110 = true;
        qub.a r111 = com.ss.android.lark.officesdk.minutes.ui.record.bubble.c.b(getContext(), r101, r210, MmBubbleDirection.BOTTOM, false, true, 3000, false, Integer.valueOf(r108), 2, null, null, (qub.b) r211.getUiProviders().f436802g.getValue(), r211.getUiLaunchMode(), new MmRecordingAINoteToolBarView$showFirstMarkTooltipIfNeeded$1(this, r211), 10, 6152);
        this.f436633j = r111;
        if (r111 == qub.a.C7394a.f534851a) goto L30;
        boolean r112 = true;
    L32:
        if (r111.isShowing() == true) goto L35;
        r110 = false;
    L35:
        if (r112 == true) goto L39;
        qub.a r113 = this.f436633j;
        this.f436633j = null;
        if (r113 == null) goto L39;
        r113.hide();
    L39:
        int r114 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.AI_NOTE, "showFirstMarkTooltipIfNeeded", "shown=" + r112 + ", actualIsShowing=" + r110, null, 8);
        return r112;
    L30:
        r112 = false;
        goto L32
    L11:
        if (r102.isShowing() != true) goto L13;
        r103 = true;
        goto L14
    }

    public final void i6(View r100, int r101) {
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

    public MmRecordingAINoteToolBarView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f436628e = "MmRecordingAINoteToolBarView_" + hashCode();
        this.f436630g = MMRecordingState.INIT;
        this.f436631h = true;
    }

    public final void U5(int r100, int r101, int r102) {
        mwb.c r103 = this.f436624a;
        mwb.c r104 = null;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r103 = null;
    L5:
        r103.f516040h.setImageResource(r100);
        mwb.c r105 = this.f436624a;
        if (r105 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r105 = null;
    L8:
        r105.f516040h.setImageTintList(ColorStateList.valueOf(UIUtils.getColor(getContext(), r102)));
        if (r101 == 0) goto L15;
        mwb.c r106 = this.f436624a;
        if (r106 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L14:
        r104.f516040h.setBackgroundResource(r101);
        return;
    L13:
        r104 = r106;
        goto L14
    L15:
        mwb.c r107 = this.f436624a;
        if (r107 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L19:
        r104.f516040h.setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(getContext()).z(getContext()));
        return;
    L18:
        r104 = r107;
        goto L19
    }

    public final void V5(final MmRecordingViewModel r100, MmRecordingFragment r101, final Function1 r102) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r102, "onNavigateToSubtitle");
        MmRecordingUILaunchMode r103 = r100.getUiLaunchMode();
        if (this.f436624a != null) goto L5;
    L7:
        removeAllViews();
        e.f436896a.getClass();
        mwb.c r104 = e.b(r103).getLayout().s(LayoutInflater.from(com.ss.android.lark.officesdk.minutes.ui.style.c.c(getContext(), r103)), this);
        this.f436624a = r104;
        this.f436625b = r103;
        if (r104 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r104 = null;
    L10:
        r104.f516036d.setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(getContext()).o(getContext()));
        mwb.c r105 = this.f436624a;
        if (r105 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r105 = null;
    L13:
        r105.f516037e.setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(getContext()).c(getContext()));
        mwb.c r106 = this.f436624a;
        if (r106 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r106 = null;
    L16:
        r106.f516039g.setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(getContext()).z(getContext()));
        U5(e.b(r103).getDrawable().j(), e.b(r103).getDrawable().i(), e.b(r103).getDrawable().g());
        mwb.c r107 = this.f436624a;
        if (r107 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r107 = null;
    L19:
        r107.f516041i.setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(getContext()).x(getContext()));
        mwb.c r108 = this.f436624a;
        if (r108 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r108 = null;
    L22:
        r108.f516038f.post(new com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar.a(this));
    L23:
        mwb.c r109 = this.f436624a;
        if (r109 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r109 = null;
    L26:
        h.a(r109.f516039g, new MmRecordingAINoteToolBarView$bind$1(this, r100, r102));
        mwb.c r110 = this.f436624a;
        if (r110 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r110 = null;
    L29:
        h.a(r110.f516040h, new MmRecordingAINoteToolBarView$bind$2(this, r100));
        mwb.c r111 = this.f436624a;
        if (r111 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r111 = null;
    L32:
        h.a(r111.f516041i, new MmRecordingAINoteToolBarView$bind$3(r100));
        r100.selectSubscribe(LifecycleOwnerKt.getLifecycleScope(r101), MmRecordingAINoteToolBarView$subscribeAudioVolume$1.INSTANCE, new MmRecordingAINoteToolBarView$subscribeAudioVolume$2(this, null));
        r100.selectSubscribe(LifecycleOwnerKt.getLifecycleScope(r101), MmRecordingAINoteToolBarView$subscribeDuration$1.INSTANCE, new MmRecordingAINoteToolBarView$subscribeDuration$2(this, r100, r102, null));
        r100.selectSubscribe(LifecycleOwnerKt.getLifecycleScope(r101), MmRecordingAINoteToolBarView$subscribeRecordingState$1.INSTANCE, new MmRecordingAINoteToolBarView$subscribeRecordingState$2(this, r100, r102, null));
        r100.selectSubscribe(LifecycleOwnerKt.getLifecycleScope(r101), MmRecordingAINoteToolBarView$subscribeRecordingState$3.INSTANCE, new MmRecordingAINoteToolBarView$subscribeRecordingState$4(this, r100, null));
        com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.a r112 = Y5(r100, r102);
        String r113 = this.f436628e;
        Function1<Boolean, Unit> r114 = new MmRecordingAINoteToolBarView$registerAINoteVisibilityListener$1(this);
        Intrinsics.checkNotNullParameter(r113, "listenerKey");
        Intrinsics.checkNotNullParameter(r114, "listener");
        r112.f436076m.put(r113, r114);
        r114.invoke(Boolean.valueOf(r112.f436075l));
        r100.trackAINoteEntryViewIfNeeded();
        r100.selectSubscribe(LifecycleOwnerKt.getLifecycleScope(r101), MmRecordingAINoteToolBarView$subscribePageViewTrack$1.INSTANCE, new MmRecordingAINoteToolBarView$subscribePageViewTrack$2(this, r100, null));
        r100.selectSubscribe(LifecycleOwnerKt.getLifecycleScope(r101), MmRecordingAINoteToolBarView$subscribePageViewTrack$3.INSTANCE, new MmRecordingAINoteToolBarView$subscribePageViewTrack$4(this, r100, null));
        r100.refreshAINoteTooltipIfNeeded();
        r100.selectSubscribe(LifecycleOwnerKt.getLifecycleScope(r101), MmRecordingAINoteToolBarView$subscribeAINoteTooltip$1.INSTANCE, new MmRecordingAINoteToolBarView$subscribeAINoteTooltip$2(this, r100, null));
        return;
    L5:
        if (this.f436625b != r103) goto L7;
        goto L7
    }

    public /* synthetic */ MmRecordingAINoteToolBarView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (r100 <= 0) goto L12;
        if (r100 == r102) goto L13;
        mwb.c r104 = this.f436624a;
        if (r104 == null) goto L14;
        if (r104 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r104 = null;
    L10:
        r104.f516038f.requestLayout();
        post(new c(this, r100));
        return;
    L14:
        return;
    L13:
        return;
    }
}
