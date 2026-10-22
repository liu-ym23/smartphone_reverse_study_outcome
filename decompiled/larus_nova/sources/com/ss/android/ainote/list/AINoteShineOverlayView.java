package com.ss.android.ainote.list;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.SystemClock;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ec.model.response.anchorv3.SalesInfoStruct;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 D2\u00020\u0001:\u0001DB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0014J\u0010\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020\u0013H\u0016J \u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020\u00072\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010)J\u0018\u0010*\u001a\u00020!2\u0006\u0010'\u001a\u00020\u00072\b\b\u0002\u0010+\u001a\u00020\u0018J\u0006\u0010,\u001a\u00020!J\u000e\u0010-\u001a\u00020!2\u0006\u0010.\u001a\u00020\u001fJ\b\u0010/\u001a\u00020!H\u0002J\u0010\u00100\u001a\u00020!2\u0006\u00101\u001a\u00020\u0013H\u0002J\b\u00102\u001a\u00020!H\u0002J\u0010\u00103\u001a\u00020!2\u0006\u0010'\u001a\u00020\u0007H\u0002J\u0010\u00104\u001a\u0002052\u0006\u0010'\u001a\u00020\u0007H\u0002J\u0018\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u000209H\u0002J\u0010\u0010:\u001a\u0002092\u0006\u00107\u001a\u00020\u0007H\u0002J\u0010\u0010;\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020#H\u0002J\u0018\u0010<\u001a\u00020!2\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010)H\u0002J\b\u0010=\u001a\u00020!H\u0002J0\u0010>\u001a\u00020!2\u0006\u0010?\u001a\u00020\u00132\u0006\u0010@\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u00182\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010)H\u0002J\u0010\u0010A\u001a\u00020!2\u0006\u0010B\u001a\u00020CH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/ss/android/ainote/list/AINoteShineOverlayView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gradientMatrix", "Landroid/graphics/Matrix;", "overlayPaint", "Landroid/graphics/Paint;", "overlayGradient", "Landroid/graphics/LinearGradient;", "animator", "Landroid/animation/ValueAnimator;", "isShineEnabled", "", "isAnimationRunning", "shouldResumeLoopWhenVisible", "runningRepeat", "playOnceStartUptimeMs", "", "shineAreaWidthPx", "shineSpeedPx", "loopPauseTimeMs", "translateX", "currentTextColor", "targetTextView", "Landroid/widget/TextView;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onVisibilityAggregated", "isVisible", "playOnce", "textColor", "onEnd", "Lkotlin/Function0;", "showLoopShine", "pauseTimeMs", "disableShine", "bindTargetTextView", "textView", "moveOverlayOffscreen", "startLoopShine", "forceRestart", "rebuildGradient", "updateGradientIfNeeded", "resolveOverlayColors", "", "applyAlpha", "color", "alphaRatio", "", "calculateLuminance", "drawTextOccupiedArea", "startShineOnce", "startShineLoopInternal", "startShineInternal", SalesInfoStruct.REPEAT, "startDelayMs", "stopShine", "reason", "", "Companion", "ai-note_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AINoteShineOverlayView extends View {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f407026p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matrix f407027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f407028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinearGradient f407029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ValueAnimator f407030d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f407031e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f407032f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f407033g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f407034h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f407035i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f407036j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f407037k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f407038l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f407039m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f407040n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public TextView f407041o;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AINoteShineOverlayView f407042a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f407043b;

        public b(AINoteShineOverlayView r100, Function0<Unit> r101) {
            this.f407042a = r100;
            this.f407043b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AINoteShineOverlayView r100 = this.f407042a;     // Catch: Throwable -> L4
            Function0<Unit> r101 = this.f407043b;     // Catch: Throwable -> L4
            int r102 = AINoteShineOverlayView.f407026p;     // Catch: Throwable -> L4
            r100.h(false, 300, 0, r101);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AINoteShineOverlayView f407044a;

        public c(AINoteShineOverlayView r100) {
            this.f407044a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AINoteShineOverlayView r100 = this.f407044a;     // Catch: Throwable -> L4
            int r101 = AINoteShineOverlayView.f407026p;     // Catch: Throwable -> L4
            r100.g(true);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f407045a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AINoteShineOverlayView f407046b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f407047c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f407048d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f407049e;

        public d(long r100, AINoteShineOverlayView r101, long r102, int r103, int r104) {
            this.f407045a = r100;
            this.f407046b = r101;
            this.f407047c = r102;
            this.f407048d = r103;
            this.f407049e = r104;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            Object r101 = r100.getAnimatedValue();
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Float");
            float r102 = ((Float) r101).floatValue() * this.f407045a;
            AINoteShineOverlayView r103 = this.f407046b;
            long r104 = this.f407047c;
            if (r102 > r104) goto L5;
            int r105 = (int) (this.f407048d + ((r102 / r104) * this.f407049e));
        L6:
            r103.f407039m = r105;
            r103.invalidate();
            return;
        L5:
            r105 = this.f407049e;
            goto L6
        }
    }

    public static final class e extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f407050a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AINoteShineOverlayView f407051b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f407052c;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f407050a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            AINoteShineOverlayView r101 = this.f407051b;
            String r102 = "anim_end(cancelled=" + this.f407050a + ')';
            int r103 = AINoteShineOverlayView.f407026p;
            r101.i(r102);
            Function0<Unit> r104 = this.f407052c;
            if (r104 == null) goto L6;
            r104.invoke();
            return;
        }

        public e(AINoteShineOverlayView r100, Function0<Unit> r101) {
            this.f407051b = r100;
            this.f407052c = r101;
        }
    }

    static {
    }

    public AINoteShineOverlayView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AINoteShineOverlayView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void d() {
        this.f407031e = false;
        this.f407033g = false;
        i("disableShine()");
        setVisibility(8);
    }

    public final void f() {
        int r100 = this.f407040n;
        Context r101 = getContext();
        int r102 = com.ss.android.ainote.util.a.f407220a;
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r103 = ContextCompat.getColor(r101, R.color.bg_body);
        float r104 = (RangesKt.coerceAtLeast(0.45f - Math.abs(b(r100) - b(r103)), 0.0f) / 0.45f) * 0.08f;
        float r105 = RangesKt.coerceAtMost((0.5f * r104) + 0.4f, 0.46f);
        this.f407029c = new LinearGradient(0.0f, 0.0f, this.f407036j, 0.0f, new int[]{a(r103, 0.0f), a(r103, r105), a(r103, RangesKt.coerceAtMost(r104 + 0.6f, 0.68f)), a(r103, r105), a(r103, 0.0f)}, null, Shader.TileMode.CLAMP);
        invalidate();
    }

    public static float b(int r100) {
        float r101 = c(Color.red(r100));
        float r102 = c(Color.green(r100));
        return ((r101 * 0.2126f) + (r102 * 0.7152f)) + (c(Color.blue(r100)) * 0.0722f);
    }

    public static final float c(int r100) {
        float r101 = r100 / 255.0f;
        if (r101 > 0.03928f) goto L6;
        return r101 / 12.92f;
    L6:
        return (float) Math.pow((r101 + 0.055f) / 1.055f, 2.4d);
    }

    public final void g(boolean r100) {
        if (getWidth() != 0) goto L7;
        post(new c(this));
        return;
    L7:
        if (this.f407032f == true) goto L9;
    L12:
        h(true, 1000, this.f407038l, null);
        return;
    L9:
        if (this.f407034h == false) goto L12;
        if (r100 == true) goto L12;
    }

    public final void i(String r100) {
        if (this.f407032f == true) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L10;
    L12:
        long r102 = -1;
    L13:
        this.f407032f = false;
        this.f407034h = false;
        ValueAnimator r103 = this.f407030d;
        if (r103 == null) goto L16;
        r103.cancel();
    L16:
        this.f407030d = null;
        this.f407039m = -this.f407036j;
        invalidate();
        invalidate();
        if (r101 == false) goto L20;
        int r104 = com.ss.android.ainote.t.f407207a;
        com.ss.android.ainote.t.d("AINoteShineOverlayView", "stopShine playOnce, reason=" + r100 + ", elapsedMs=" + r102 + ", isShown=" + isShown() + ", visibility=" + getVisibility() + ", windowVisibility=" + getWindowVisibility());
        return;
    L20:
        return;
    L10:
        if (this.f407035i <= 0) goto L12;
        r102 = RangesKt.coerceAtLeast(SystemClock.uptimeMillis() - this.f407035i, 0);
        goto L13
    L5:
        if (this.f407034h == true) goto L7;
        r101 = true;
        goto L8
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        LinearGradient r100 = this.f407029c;
        if (r100 != null) goto L5;
        return;
    L5:
        this.f407027a.setTranslate(this.f407039m, 0.0f);
        r100.setLocalMatrix(this.f407027a);
        this.f407028b.setShader(r100);
        TextView r101 = this.f407041o;
        int r102 = 0;
        if (r101 == null) goto L42;
        Layout r103 = r101.getLayout();
        CharSequence r104 = r101.getText();
        if (r104 != null) goto L11;
    L14:
        boolean r105 = true;
    L15:
        if (r105 == true) goto L26;
        if (r103 == null) goto L26;
        if (r103.getLineCount() <= 0) goto L26;
        float r106 = r101.getTotalPaddingLeft();
        float r107 = r101.getTotalPaddingTop();
        int r108 = r103.getLineCount();
    L20:
        if (r102 >= r108) goto L25;
        float r109 = r106 + r103.getLineLeft(r102);
        float r111 = r106 + r103.getLineRight(r102);
        if (r111 <= r109) goto L24;
        r110.drawRect(r109, r107 + r103.getLineTop(r102), r111, r107 + r103.getLineBottom(r102), this.f407028b);
    L24:
        r102 = r102 + 1;
    L25:
        r102 = 1;
    L26:
        CharSequence r112 = r101.getHint();
        if (r112 == null) goto L29;
        String r113 = r112.toString();
    L30:
        if (r113 != null) goto L33;
        r113 = "";
    L33:
        if (StringsKt.isBlank(r113) == true) goto L42;
        int r114 = RangesKt.coerceAtLeast((r101.getWidth() - r101.getTotalPaddingLeft()) - r101.getTotalPaddingRight(), 0);
        if (r114 <= 0) goto L42;
        float r115 = RangesKt.coerceAtMost(r101.getPaint().measureText(r113), r114);
        if (r115 <= 0.0f) goto L42;
        float r116 = r101.getTotalPaddingLeft();
        float r117 = r101.getTotalPaddingTop();
        r110.drawRect(r116, r117, r116 + r115, RangesKt.coerceAtMost(r101.getLineHeight() + r117, r101.getHeight() - r101.getTotalPaddingBottom()), this.f407028b);
        goto L25
    L29:
        r113 = null;
        goto L30
    L11:
        if (r104.length() == 0) goto L14;
        r105 = false;
    L42:
        if (r102 != 0) goto L48;
        r110.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.f407028b);
        return;
    }

    @Override // android.view.View
    public final void onVisibilityAggregated(boolean r100) {
        super.onVisibilityAggregated(r100);
        if (this.f407031e == true) goto L5;
        return;
    L5:
        if (r100 == true) goto L7;
        i("visibility_aggregated=false");
        return;
    L7:
        if (this.f407033g == false) goto L11;
        g(true);
        return;
    }

    public static int a(int r100, float r101) {
        return Color.argb((int) (RangesKt.coerceIn(r101, 0.0f, 1.0f) * 255), Color.red(r100), Color.green(r100), Color.blue(r100));
    }

    public final void e(int r100, Function0<Unit> r101) {
        if (this.f407040n == r100) goto L5;
    L7:
        this.f407040n = r100;
        f();
    L8:
        this.f407031e = true;
        this.f407033g = false;
        this.f407039m = -this.f407036j;
        invalidate();
        setVisibility(0);
        if (this.f407032f == false) goto L12;
        return;
    L12:
        if (getWidth() != 0) goto L14;
        post(new b(this, r101));
        return;
    L14:
        h(false, 300, 0, r101);
        return;
    L5:
        if (this.f407029c == null) goto L7;
        goto L7
    }

    public AINoteShineOverlayView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f407027a = new Matrix();
        this.f407028b = new Paint(1);
        this.f407036j = com.ss.android.ainote.util.a.a(r100, 77.0f);
        this.f407037k = com.ss.android.ainote.util.a.a(r100, 200.0f);
        this.f407038l = 2000;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f407040n = ContextCompat.getColor(r100, R.color.text_title);
        setClickable(false);
        setFocusable(false);
        setFocusableInTouchMode(false);
        setImportantForAccessibility(2);
        f();
    }

    public /* synthetic */ AINoteShineOverlayView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void h(boolean r110, long r111, long r112, Function0<Unit> r210) {
        ValueAnimator r100 = this.f407030d;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        Integer r101 = Integer.valueOf(getWidth());
        int r102 = 0;
        if (r101.intValue() <= 0) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == true) goto L12;
        r101 = null;
    L12:
        if (r101 == null) goto L14;
        int r104 = r101.intValue();
    L15:
        if (r104 > 0) goto L17;
        return;
    L17:
        int r105 = -this.f407036j;
        int r106 = r104 - r105;
        long r107 = (long) ((r106 / this.f407037k) * 1000);
        long r113 = r107 + r112;
        this.f407034h = r110;
        this.f407032f = true;
        if (r110 == true) goto L20;
        this.f407035i = SystemClock.uptimeMillis();
    L20:
        this.f407039m = r105;
        invalidate();
        ValueAnimator r114 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r114.setDuration(r113);
        if (r110 == false) goto L23;
        r102 = -1;
    L23:
        r114.setRepeatCount(r102);
        r114.setRepeatMode(1);
        r114.setInterpolator(new LinearInterpolator());
        r114.setStartDelay(r111);
        r114.addUpdateListener(new d(r113, this, r107, r105, r106));
        if (r110 == true) goto L26;
        r114.addListener(new e(this, r210));
    L26:
        r114.start();
        this.f407030d = r114;
        return;
    L14:
        r104 = getMeasuredWidth();
        goto L15
    L8:
        r103 = false;
        goto L9
    }
}
