package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 )2\u00020\u0001:\u0001)B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001dJ\b\u0010\u001f\u001a\u00020\u001dH\u0014J\b\u0010 \u001a\u00020\u001dH\u0014J\u0018\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u0007H\u0014J\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&H\u0014J \u0010'\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/ainote/MmAINoteWaveBarView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isLowDevice", "", "animationDurationMs", "", "paint", "Landroid/graphics/Paint;", "baseSizePx", "", "baseStrokeWidthPx", "startBarHeightsPx", "", "endBarHeightsPx", "barCentersPx", "progress", "isAnimating", "animator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "start", "", "stop", "onAttachedToWindow", "onDetachedFromWindow", "onVisibilityChanged", "changedView", RemoteMessageConst.Notification.VISIBILITY, "onDraw", "canvas", "Landroid/graphics/Canvas;", "lerp", "end", "Companion", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmAINoteWaveBarView extends View {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final float[] f436049k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final float[] f436050l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final float[] f436051m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f436052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f436053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f436054c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f436055d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<Float> f436056e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<Float> f436057f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<Float> f436058g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f436059h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f436060i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ValueAnimator f436061j;

    public static final class a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MmAINoteWaveBarView f436062a;

        public b(MmAINoteWaveBarView r100) {
            this.f436062a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            MmAINoteWaveBarView r101 = this.f436062a;
            Object r102 = r100.getAnimatedValue();
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Float");
            r101.f436059h = ((Float) r102).floatValue();
            this.f436062a.invalidate();
        }
    }

    public MmAINoteWaveBarView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MmAINoteWaveBarView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void a() {
        this.f436060i = false;
        if (this.f436061j.isRunning() == false) goto L5;
        this.f436061j.cancel();
    L5:
        this.f436059h = 0.0f;
        invalidate();
    }

    static {
        f436049k = new float[]{7.0f, 13.0f, 17.0f, 9.0f};
        f436050l = new float[]{8.0f, 4.0f, 6.0f, 12.0f};
        f436051m = new float[]{4.0f, 9.0f, 14.0f, 19.0f};
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        this.f436061j.cancel();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f436060i == true) goto L5;
        return;
    L5:
        if (this.f436061j.isRunning() == false) goto L7;
        return;
    L7:
        if (getVisibility() == 0) goto L9;
        return;
    L9:
        if (isShown() == false) goto L15;
        this.f436061j.start();
        return;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        if (this.f436054c <= 0.0f) goto L5;
        float r100 = getWidth() / this.f436054c;
    L7:
        if (this.f436054c <= 0.0f) goto L9;
        float r101 = getHeight() / this.f436054c;
    L10:
        this.f436053b.setStrokeWidth(this.f436055d * Math.min(r100, r101));
        float r102 = getHeight() / 2.0f;
        int r111 = this.f436056e.size();
        int r112 = 0;
    L11:
        if (r112 >= r111) goto L13;
        float r103 = ((Number) ListProtector.get(this.f436056e, r112)).floatValue();
        float r104 = ((r103 + ((((Number) ListProtector.get(this.f436057f, r112)).floatValue() - r103) * this.f436059h)) * r101) / 2.0f;
        float r105 = RangesKt.coerceIn(((Number) ListProtector.get(this.f436058g, r112)).floatValue() * r100, this.f436053b.getStrokeWidth() / 2.0f, getWidth() - (this.f436053b.getStrokeWidth() / 2.0f));
        r110.drawLine(r105, r102 - r104, r105, r102 + r104, this.f436053b);
        r112 = r112 + 1;
        goto L11
    L13:
        return;
    L9:
        r101 = 1.0f;
        goto L10
    L5:
        r100 = 1.0f;
        goto L7
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "changedView");
        super.onVisibilityChanged(r100, r101);
        if (this.f436060i == true) goto L5;
        return;
    L5:
        if (r101 != 0) goto L12;
        if (isShown() == false) goto L12;
        if (this.f436061j.isRunning() == true) goto L15;
        this.f436061j.start();
        return;
    L15:
        return;
    L12:
        if (this.f436061j.isRunning() == false) goto L17;
        this.f436061j.cancel();
        return;
    }

    public MmAINoteWaveBarView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f436052a = 300;
        Paint r103 = new Paint(1);
        r103.setColor(ContextCompat.getColor(r100, R.color.flow_ud_neutral_70));
        r103.setStrokeCap(Paint.Cap.ROUND);
        this.f436053b = r103;
        this.f436054c = UIUtils.dp2px(r100, 24.0f);
        this.f436055d = UIUtils.dp2px(r100, 2.0f);
        float[] r104 = f436049k;
        ArrayList r105 = new ArrayList(4);
        int r106 = 0;
        int r107 = 0;
    L3:
        if (r107 >= 4) goto L5;
        r105.add(Float.valueOf(UIUtils.dp2px(r100, r104[r107])));
        r107 = r107 + 1;
        goto L3
    L5:
        this.f436056e = r105;
        float[] r108 = f436050l;
        ArrayList r109 = new ArrayList(4);
        int r110 = 0;
    L6:
        if (r110 >= 4) goto L8;
        r109.add(Float.valueOf(UIUtils.dp2px(r100, r108[r110])));
        r110 = r110 + 1;
        goto L6
    L8:
        this.f436057f = r109;
        float[] r111 = f436051m;
        ArrayList r112 = new ArrayList(4);
    L9:
        if (r106 >= 4) goto L11;
        r112.add(Float.valueOf(UIUtils.dp2px(r100, r111[r106])));
        r106 = r106 + 1;
        goto L9
    L11:
        this.f436058g = r112;
        ValueAnimator r113 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r113.setDuration(this.f436052a);
        r113.setInterpolator(new LinearInterpolator());
        r113.setRepeatCount(-1);
        r113.setRepeatMode(2);
        r113.addUpdateListener(new b(this));
        this.f436061j = r113;
    }

    public /* synthetic */ MmAINoteWaveBarView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
