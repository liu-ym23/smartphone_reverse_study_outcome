package com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.officesdk.minutes.ui.databinding.OfficeSdkMmViewStandaloneAiInterpretationTopBarBinding;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001.B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bH\u0016J&\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u00020\u0010H\u0014J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J \u0010\u001f\u001a\u00020\u0010*\u00020 2\b\b\u0001\u0010!\u001a\u00020\b2\b\b\u0001\u0010\"\u001a\u00020\bH\u0002J\u0014\u0010#\u001a\u00020\u0010*\u00020 2\u0006\u0010$\u001a\u00020\u001aH\u0002J\b\u0010%\u001a\u00020\u0010H\u0002J\u0012\u0010&\u001a\u00020\b2\b\b\u0001\u0010\"\u001a\u00020\bH\u0002J\f\u0010'\u001a\u00020(*\u00020)H\u0002J \u0010*\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u001aH\u0002J\u0012\u0010-\u001a\u0004\u0018\u00010(2\u0006\u0010,\u001a\u00020\u001aH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/standaloneinterpretation/MmStandaloneAIInterpretationTopBarView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/controller/MmRecordingTopPaddingTarget;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/ss/android/lark/officesdk/minutes/ui/databinding/OfficeSdkMmViewStandaloneAiInterpretationTopBarBinding;", "bindScope", "Lkotlinx/coroutines/CoroutineScope;", "setTopPadding", "", GXTemplateKey.FLEXBOX_PADDING, "bind", "scope", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/slot/scope/MmRecordingSlotScope;", "viewModel", "Lcom/ss/android/lark/officesdk/minutes/ui/record/standaloneinterpretation/MmStandaloneAIInterpretationViewModel;", "uiLaunchMode", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;", "hasHostNavRect", "", "onDetachedFromWindow", "dp", "value", "", "setIcon", "Landroidx/appcompat/widget/AppCompatImageView;", "drawableRes", "colorRes", "setSpeakerIcon", "muted", "applyDoubaoMiniAppHeaderStyle", "tokenColor", "displayText", "", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/standaloneinterpretation/MmStandaloneAIInterpretationLanguage;", "showLanguagePanel", "showSpeakerToast", "soundOn", "resolveSpeakerToastMessage", "Companion", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmStandaloneAIInterpretationTopBarView extends ConstraintLayout implements com.ss.android.lark.officesdk.minutes.ui.record.recording.base.controller.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f436741c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OfficeSdkMmViewStandaloneAiInterpretationTopBarBinding f436742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CoroutineScope f436743b;

    public static final class a {
    }

    static {
    }

    public MmStandaloneAIInterpretationTopBarView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MmStandaloneAIInterpretationTopBarView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        CoroutineScope r100 = this.f436743b;
        if (r100 == null) goto L5;
        CoroutineScopeKt.cancel$default(r100, null, 1, null);
    L5:
        this.f436743b = null;
        super.onDetachedFromWindow();
    }

    public final int R5(float r100) {
        return UIUtils.dp2px(getContext(), r100);
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.recording.base.controller.a
    public void setTopPadding(int r100) {
        setPadding(0, r100, 0, 0);
    }

    public final void S5(AppCompatImageView r100, boolean r101) {
        if (r101 == false) goto L4;
        int r102 = R.drawable.office_sdk_mm_ic_standalone_ai_interpretation_speaker_off;
    L5:
        if (r101 == false) goto L7;
        int r103 = R.color.icon_n1;
    L8:
        r100.setImageResource(r102);
        r100.setImageTintList(ColorStateList.valueOf(UDColorUtils.getColor(getContext(), r103)));
        return;
    L7:
        r103 = com.ss.android.lark.officesdk.minutes.ui.style.a.a(r100.getContext()).c();
        goto L8
    L4:
        r102 = R.drawable.office_sdk_mm_ic_standalone_ai_interpretation_speaker_on;
        goto L5
    }

    public MmStandaloneAIInterpretationTopBarView(Context r210, AttributeSet r211, int r212) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r210, r211, r212);
        View r100 = LayoutInflater.from(r210).inflate(R.layout.office_sdk_mm_view_standalone_ai_interpretation_top_bar, this, false);
        addView(r100);
        int r101 = R.id.arrow_view;
        AppCompatImageView r102 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.arrow_view);
        if (r102 == null) goto L23;
        r101 = R.id.back_button;
        AppCompatImageView r110 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.back_button);
        if (r110 == null) goto L23;
        r101 = R.id.language_container;
        LinearLayout r103 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.language_container);
        if (r103 == null) goto L23;
        r101 = R.id.language_loading_container;
        FrameLayout r111 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.language_loading_container);
        if (r111 == null) goto L23;
        r101 = R.id.language_loading_view;
        View r112 = ViewBindings.findChildViewById(r100, R.id.language_loading_view);
        if (r112 == null) goto L23;
        r101 = R.id.separator_view;
        AppCompatImageView r113 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.separator_view);
        if (r113 == null) goto L23;
        r101 = R.id.source_language_view;
        TextView r114 = (TextView) ViewBindings.findChildViewById(r100, R.id.source_language_view);
        if (r114 == null) goto L23;
        r101 = R.id.speaker_button;
        AppCompatImageView r115 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.speaker_button);
        if (r115 == null) goto L23;
        r101 = R.id.target_language_view;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r100, R.id.target_language_view);
        if (r104 == null) goto L23;
        this.f436742a = new OfficeSdkMmViewStandaloneAiInterpretationTopBarBinding((ConstraintLayout) r100, r102, r110, r103, r111, r112, r113, r114, r115, r104);
        com.ss.android.lark.officesdk.minutes.ui.style.contract.d r105 = com.ss.android.lark.officesdk.minutes.ui.style.a.a(r210);
        int r106 = r105.o();
        int r107 = UDColorUtils.getColor(getContext(), r106);
        int r108 = r105.n();
        int r109 = r105.b();
        r114.setText(null);
        r114.setTextColor(r107);
        r104.setText(null);
        r104.setTextColor(r107);
        int r116 = zvb.a.f573774b;
        r112.setBackground(zvb.a.C8496a.c(r210, Integer.valueOf(R.color.bg_content_base), 36, null, null, 52));
        r110.setImageDrawable(UDIconUtils.getIconDrawable(r110.getContext(), R.drawable.ud_icon_left_outlined, UDColorUtils.getColor(getContext(), R.color.icon_n1)));
        r113.setImageResource(R.drawable.office_sdk_mm_ic_standalone_ai_interpretation_switch);
        r113.setImageTintList(ColorStateList.valueOf(UDColorUtils.getColor(getContext(), r109)));
        r102.setImageDrawable(UDIconUtils.getIconDrawable(r102.getContext(), R.drawable.ud_icon_expand_down_filled, UDColorUtils.getColor(getContext(), r108)));
        S5(r115, true);
        return;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public /* synthetic */ MmStandaloneAIInterpretationTopBarView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
