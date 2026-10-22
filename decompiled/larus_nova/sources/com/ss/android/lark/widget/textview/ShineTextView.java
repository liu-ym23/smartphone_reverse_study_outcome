package com.ss.android.lark.widget.textview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 32\u00020\u0001:\u00013B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ(\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\nH\u0014J\u0010\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020(H\u0014J\u0010\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020\rH\u0016J\b\u0010+\u001a\u00020!H\u0014J\u0006\u0010,\u001a\u00020!J\b\u0010-\u001a\u00020!H\u0002J\u0006\u0010.\u001a\u00020!J\b\u0010/\u001a\u00020!H\u0002J\b\u00100\u001a\u00020!H\u0002J\u0018\u00101\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00102\u001a\u00020\u0018H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/ss/android/lark/widget/textview/ShineTextView;", "Lcom/ss/android/lark/widget/textview/LineHeightTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isAnimationRunning", "", "isEnableShine", "mGradientMatrix", "Landroid/graphics/Matrix;", "whiteAlpha4", "whiteAlpha6", "mShineColors", "", "mShineAreaWidth", "mShineSpeed", "shineAreaCenterStartRatio", "", "mTranslate", "mLinearGradient", "Landroid/graphics/LinearGradient;", "valueAnimator", "Landroid/animation/ValueAnimator;", "startShineRunnable", "Ljava/lang/Runnable;", "onSizeChanged", "", "w", "h", "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onVisibilityAggregated", "isVisible", "onDetachedFromWindow", "disableShine", "stopShineImpl", "enableAndStartShine", "startShineImpl", "restartShine", "dp2px", "dp", "Companion", "widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ShineTextView extends LineHeightTextView {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f448917o = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f448918e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f448919f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Matrix f448920g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f448921h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f448922i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f448923j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f448924k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final LinearGradient f448925l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ValueAnimator f448926m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final c f448927n;

    public static final class a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f448928a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ShineTextView f448929b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f448930c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f448931d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ float f448932e;

        public b(long r100, ShineTextView r101, long r102, int r103, float r104) {
            this.f448928a = r100;
            this.f448929b = r101;
            this.f448930c = r102;
            this.f448931d = r103;
            this.f448932e = r104;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
            Object r101 = r100.getAnimatedValue();
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Float");
            float r102 = ((Float) r101).floatValue() * this.f448928a;
            ShineTextView r103 = this.f448929b;
            long r104 = this.f448930c;
            if (r102 > r104) goto L5;
            int r105 = (int) (this.f448931d + ((r102 / r104) * this.f448932e));
        L6:
            r103.f448924k = r105;
            r103.invalidate();
            return;
        L5:
            r105 = (int) this.f448932e;
            goto L6
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShineTextView f448933a;

        public c(ShineTextView r100) {
            this.f448933a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ShineTextView r100 = this.f448933a;     // Catch: Throwable -> L4
            int r101 = ShineTextView.f448917o;     // Catch: Throwable -> L4
            r100.z();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void x() {
        this.f448919f = false;
        A();
        Log.i("ShineTextView", "disableShine");
    }

    public final void y() {
        boolean r100 = true;
        this.f448919f = true;
        Log.i("ShineTextView", "enableAndStartShine");
        if (this.f448918e == false) goto L5;
    L18:
        StringBuilder r101 = new StringBuilder("startShine skipped running=");
        r101.append(this.f448918e);
        r101.append(" textEmpty=");
        if (getText().length() == 0) goto L22;
        r100 = false;
    L22:
        r101.append(r100);
        Log.d("ShineTextView", r101.toString());
        return;
    L5:
        if (getText().length() != 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L18;
        if (getWidth() != 0) goto L13;
    L16:
        removeCallbacks(this.f448927n);
        post(this.f448927n);
        return;
    L13:
        if (getLayout() == null) goto L16;
        z();
        return;
    L7:
        r102 = false;
        goto L8
    }

    public final void A() {
        Log.i("ShineTextView", "stopShineImpl running=" + this.f448918e + ", enable=" + this.f448919f);
        removeCallbacks(this.f448927n);
        this.f448918e = false;
        ValueAnimator r100 = this.f448926m;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f448926m = null;
        getPaint().setShader(null);
        invalidate();
    }

    public final void z() {
        if (this.f448919f == true) goto L5;
        return;
    L5:
        if (isAttachedToWindow() == false) goto L26;
        ValueAnimator r100 = this.f448926m;
        if (r100 == null) goto L11;
        r100.cancel();
    L11:
        if (getLayout() == null) goto L15;
        int r101 = getLayout().getLineCount();
        int r102 = 0;
        float r103 = 0.0f;
    L13:
        if (r102 >= r101) goto L17;
        r103 = RangesKt.coerceAtLeast(r103, getLayout().getLineWidth(r102));
        r102 = r102 + 1;
    L17:
        if (r103 > 0.0f) goto L19;
        r103 = getMeasuredWidth();
    L19:
        Log.i("ShineTextView", "startShineImpl textWidth=" + r103);
        if (r103 > 0.0f) goto L22;
        return;
    L22:
        this.f448918e = true;
        getPaint().setShader(this.f448925l);
        int r110 = -((int) (this.f448921h * this.f448923j));
        float r111 = r103 - r110;
        long r104 = (long) ((r111 / this.f448922i) * 1000);
        long r105 = r104 + 1000;
        ValueAnimator r106 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r106.setDuration(r105);
        r106.setRepeatCount(-1);
        r106.setRepeatMode(1);
        r106.setInterpolator(new LinearInterpolator());
        r106.setStartDelay(300);
        r106.addUpdateListener(new b(r105, this, r104, r110, r111));
        this.f448926m = r106;
        r106.start();
        return;
    L15:
        r103 = 0.0f;
        goto L17
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("lark.myai.shine_text_view_detach_cancel.disable") == false) goto L6;
        Log.i("ShineTextView", "onDetachedFromWindow skip stopShineImpl by FG disable");
        return;
    L6:
        A();
    }

    public ShineTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        this.f448920g.setTranslate(this.f448924k, 0.0f);
        this.f448925l.setLocalMatrix(this.f448920g);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onVisibilityAggregated(boolean r100) {
        super.onVisibilityAggregated(r100);
        if (this.f448919f == true) goto L5;
        return;
    L5:
        Log.d("ShineTextView", "onVisibilityAggregated isVisible=" + r100 + ", running=" + this.f448918e + ", enable=" + this.f448919f);
        if (r100 == false) goto L8;
        y();
        return;
    L8:
        A();
    }

    public ShineTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public ShineTextView(Context r100, AttributeSet r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r110, r111);
        this.f448920g = new Matrix();
        int r101 = UIUtils.getAlphaColor(getCurrentTextColor(), 0.6d);
        int[] r102 = {getCurrentTextColor(), r101, UIUtils.getAlphaColor(getCurrentTextColor(), 0.4d), r101, getCurrentTextColor()};
        Resources r103 = getContext().getResources();
        int r104 = (int) (77.0f * WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).density);
        this.f448921h = r104;
        Resources r112 = getContext().getResources();
        int r113 = (int) (200.0f * WindowDisplayMetricsOverride.apply(r112, r112.getDisplayMetrics()).density);
        this.f448922i = r113;
        float r114 = 5;
        float r105 = (r114 / 2.0f) / r114;
        this.f448923j = r105;
        float r106 = r104;
        this.f448924k = -((int) ((((double) r113) * 0.3d) + ((double) (r105 * r106))));
        this.f448925l = new LinearGradient(0.0f, 0.0f, r106, 0.0f, r102, null, Shader.TileMode.CLAMP);
        this.f448927n = new c(this);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (this.f448919f == false) goto L9;
        getPaint().setShader(this.f448925l);
        ValueAnimator r104 = this.f448926m;
        if (r104 == null) goto L7;
        r104.cancel();
    L7:
        this.f448926m = null;
        z();
        return;
    }
}
