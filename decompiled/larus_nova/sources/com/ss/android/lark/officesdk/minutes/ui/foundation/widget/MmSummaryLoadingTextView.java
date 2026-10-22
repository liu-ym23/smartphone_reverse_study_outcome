package com.ss.android.lark.officesdk.minutes.ui.foundation.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.ColorUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0017H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0012\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u0018\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u0017H\u0002J\u0010\u0010\"\u001a\u00020\u00132\b\b\u0002\u0010#\u001a\u00020\u0015J\u0006\u0010$\u001a\u00020\u001bJ\u0006\u0010%\u001a\u00020\u0013J\u0006\u0010&\u001a\u00020\u0013J\u000e\u0010'\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010(\u001a\u00020\u001bH\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/MmSummaryLoadingTextView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "textView", "Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/LineHeightTextView;", "sweepView", "Landroid/view/View;", "sweepAnimation", "Landroid/view/animation/TranslateAnimation;", "autoLoopRunnable", "Ljava/lang/Runnable;", "isAnimating", "", "loopInterval", "", "sweepWidthPx", "", "px2sp", "pxValue", "initSweepBackground", "", "updateTextAndInitAnimation", "text", "", "initAnimation", "textWidth", "sweepWidth", "startAutoLoop", VideoThumbInfo.KEY_INTERVAL, "playOneShot", "stop", "isInAnimation", "setText", "onDetachedFromWindow", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmSummaryLoadingTextView extends ConstraintLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f435713h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LineHeightTextView f435714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f435715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TranslateAnimation f435716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f435717d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f435718e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f435719f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f435720g;

    public MmSummaryLoadingTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MmSummaryLoadingTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final boolean R5() {
        if (this.f435718e == true) goto L5;
        return false;
    L5:
        int r100 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "stop", null, null, 12);
        this.f435718e = false;
        e r101 = this.f435717d;
        if (r101 == null) goto L8;
        removeCallbacks(r101);
    L8:
        this.f435717d = null;
        this.f435715b.clearAnimation();
        this.f435715b.setVisibility(4);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        R5();
    }

    public final void S5(String r100) {
        this.f435714a.setText(r100);
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L18;
        this.f435714a.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        float r102 = this.f435714a.getMeasuredWidth();
        float r103 = this.f435720g;
        if (r103 > 0.0f) goto L15;
        r103 = UIUtils.dp2px(getContext(), 40.0f);
    L15:
        if (r102 <= 0.0f) goto L19;
        this.f435715b.setTranslationX(-r103);
        TranslateAnimation r104 = new TranslateAnimation(0.0f, r102 + r103, 0.0f, 0.0f);
        r104.setDuration(500);
        r104.setFillAfter(false);
        r104.setAnimationListener(new d(this));
        this.f435716c = r104;
        return;
    L19:
        return;
    L18:
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        S5(r100);
    }

    public MmSummaryLoadingTextView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        this.f435719f = 4000;
        View.inflate(r110, R.layout.office_sdk_mm_view_summary_loading_text, this);
        LineHeightTextView r113 = (LineHeightTextView) findViewById(R.id.loadingTextView);
        this.f435714a = r113;
        View r100 = findViewById(R.id.sweepView);
        this.f435715b = r100;
        if (r111 == null) goto L14;
        TypedArray r114 = r110.obtainStyledAttributes(r111, new int[]{R.attr.loadingText, R.attr.loadingTextColor, R.attr.loadingTextLineHeight, R.attr.loadingTextSize, R.attr.sweepViewWidth});
        String r101 = r114.getString(0);
        float r102 = r114.getDimension(3, -1.0f);
        if (r102 <= 0.0f) goto L7;
        Resources r115 = r110.getResources();
        r113.setTextSize(r102 / WindowDisplayMetricsOverride.apply(r115, r115.getDisplayMetrics()).scaledDensity);
    L7:
        r113.setTextColor(r114.getColor(1, -16777216));
        float r116 = r114.getDimension(2, -1.0f);
        if (r116 <= 0.0f) goto L10;
        r113.setUXLineHeight(r116);
    L10:
        float r117 = r114.getDimension(4, -1.0f);
        if (r117 <= 0.0f) goto L13;
        this.f435720g = r117;
        ViewGroup.LayoutParams r118 = r100.getLayoutParams();
        Intrinsics.checkNotNull(r118, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r119 = (ConstraintLayout.LayoutParams) r118;
        ((ViewGroup.MarginLayoutParams) r119).width = (int) r117;
        r100.setLayoutParams(r119);
    L13:
        r114.recycle();
        S5(r101);
    L14:
        GradientDrawable r120 = new GradientDrawable();
        r120.setGradientType(0);
        r120.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        int r121 = UIUtils.getColor(getContext(), R.color.bg_body);
        int r122 = ColorUtils.setAlphaComponent(r121, 0);
        r120.setColors(new int[]{r122, ColorUtils.setAlphaComponent(r121, 153), r122});
        r100.setBackground(r120);
    }

    public /* synthetic */ MmSummaryLoadingTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
