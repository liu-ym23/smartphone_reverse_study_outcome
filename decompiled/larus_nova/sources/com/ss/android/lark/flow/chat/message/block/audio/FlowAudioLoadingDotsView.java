package com.ss.android.lark.flow.chat.message.block.audio;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0014\u001a\u00020\u00152\b\b\u0001\u0010\u0016\u001a\u00020\u0007J\u0006\u0010\u0017\u001a\u00020\u0015J\u0006\u0010\u0018\u001a\u00020\u0015J\u0006\u0010\u0019\u001a\u00020\u0015J\b\u0010\u001a\u001a\u00020\u0015H\u0014J\u0018\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\u0014J\u0010\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 H\u0014J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u000eH\u0002J\u0010\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u000eH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/ss/android/lark/flow/chat/message/block/audio/FlowAudioLoadingDotsView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "paint", "Landroid/graphics/Paint;", "dotColor", "dotSizePx", "", "dotGapPx", "dotAlphas", "", "animator", "Landroid/animation/ValueAnimator;", "setDotColor", "", "color", "start", "showStaticDots", "stop", "onDetachedFromWindow", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "updateAlphas", "progress", "dpToPx", "dp", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowAudioLoadingDotsView extends View {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final float[][] f422368g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f422369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f422370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f422371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f422372d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float[] f422373e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ValueAnimator f422374f;

    public static final class a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowAudioLoadingDotsView f422375a;

        public b(FlowAudioLoadingDotsView r100) {
            this.f422375a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "valueAnimator");
            Object r101 = r100.getAnimatedValue();
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Float");
            float r102 = ((Float) r101).floatValue();
            FlowAudioLoadingDotsView r103 = this.f422375a;
            float[][] r104 = FlowAudioLoadingDotsView.f422368g;
            r103.getClass();
            float r105 = RangesKt.coerceIn(r102, 0.0f, 1.0f) * 3.0f;
            int r106 = 0;
            int r107 = RangesKt.coerceIn((int) r105, 0, 2);
            float r108 = RangesKt.coerceIn(r105 - r107, 0.0f, 1.0f);
            int r109 = (r107 + 1) % 3;
            float[][] r110 = FlowAudioLoadingDotsView.f422368g;
            float[] r111 = r110[r107];
            float[] r112 = r110[r109];
        L3:
            if (r106 >= 3) goto L5;
            float[] r113 = r103.f422373e;
            float r114 = r111[r106];
            r113[r106] = r114 + ((r112[r106] - r114) * r108);
            r106 = r106 + 1;
            goto L3
        L5:
            this.f422375a.invalidate();
        }
    }

    public FlowAudioLoadingDotsView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public FlowAudioLoadingDotsView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    static {
        f422368g = new float[][]{new float[]{1.0f, 0.5f, 0.3f}, new float[]{0.3f, 1.0f, 0.5f}, new float[]{0.5f, 0.3f, 1.0f}};
    }

    public final void a() {
        ValueAnimator r100 = this.f422374f;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        if (r101 == false) goto L9;
        return;
    L9:
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r102.setDuration(900);
        r102.setRepeatCount(-1);
        r102.setRepeatMode(1);
        r102.setInterpolator(new LinearInterpolator());
        r102.addUpdateListener(new b(this));
        r102.start();
        this.f422374f = r102;
        return;
    L5:
        if (r100.isStarted() != true) goto L7;
        r101 = true;
        goto L7
    }

    public final void b() {
        ValueAnimator r100 = this.f422374f;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f422374f = null;
        float[] r101 = this.f422373e;
        r101[0] = 0.0f;
        r101[1] = 0.0f;
        r101[2] = 0.0f;
        invalidate();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        float r100 = this.f422371c;
        float r101 = r100 / 2.0f;
        float r102 = ((getWidth() - ((r100 * 3) + (this.f422372d * 2))) / 2.0f) + r101;
        float r103 = getHeight() / 2.0f;
        int r104 = 0;
    L3:
        if (r104 >= 3) goto L5;
        float r105 = (r104 * (this.f422371c + this.f422372d)) + r102;
        this.f422369a.setAlpha(RangesKt.coerceIn((int) (Math.max(0.0f, this.f422373e[r104]) * 255), 0, 255));
        r110.drawCircle(r105, r103, r101, this.f422369a);
        r104 = r104 + 1;
        goto L3
    L5:
        this.f422369a.setColor(this.f422370b);
    }

    public final void setDotColor(int r100) {
        this.f422370b = r100;
        this.f422369a.setColor(r100);
        invalidate();
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        float r102 = this.f422371c;
        setMeasuredDimension(View.resolveSize((int) ((3 * r102) + (this.f422372d * 2)), r100), View.resolveSize((int) r102, r101));
    }

    public FlowAudioLoadingDotsView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Paint r103 = new Paint(1);
        r103.setColor(-1);
        this.f422369a = r103;
        this.f422370b = r103.getColor();
        Resources r104 = getResources();
        this.f422371c = 8.0f * WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).density;
        Resources r105 = getResources();
        this.f422372d = 4.0f * WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics()).density;
        this.f422373e = new float[]{0.0f, 0.0f, 0.0f};
    }

    public /* synthetic */ FlowAudioLoadingDotsView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
