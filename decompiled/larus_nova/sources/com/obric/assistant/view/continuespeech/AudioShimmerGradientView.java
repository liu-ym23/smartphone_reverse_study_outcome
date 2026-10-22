package com.obric.assistant.view.continuespeech;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RuntimeShader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 >2\u00020\u0001:\u0002=>B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010$\u001a\u00020\u001e2\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dJ\u0018\u0010&\u001a\u00020\u001e2\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dJ\u0006\u0010'\u001a\u00020\u001eJ\u0010\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*H\u0014J\b\u0010+\u001a\u00020\u001eH\u0014J(\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u0007H\u0014J\u0018\u00101\u001a\u00020\u001e2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0007H\u0014J\u0010\u00105\u001a\u00020\u001e2\u0006\u00104\u001a\u00020\u0007H\u0014J\b\u00106\u001a\u00020\u001eH\u0014J\u0018\u00107\u001a\u00020\u001e2\u000e\u00108\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dH\u0002J\b\u00109\u001a\u00020\u001eH\u0002J\b\u0010:\u001a\u00020\u001eH\u0002J\b\u0010;\u001a\u00020\u001eH\u0002J\b\u0010<\u001a\u00020\u0018H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010 \u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0018@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006?"}, d2 = {"Lcom/obric/assistant/view/continuespeech/AudioShimmerGradientView;", "Lcom/obric/assistant/view/continuespeech/AudioGradientView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "shimmerShader", "Landroid/graphics/RuntimeShader;", "shimmerPaint", "Landroid/graphics/Paint;", "shimmerWidth", "", "shimmerAngle", "shimmerBaseAlpha", "shimmerHighlightAlpha", "shimmerState", "Lcom/obric/assistant/view/continuespeech/AudioShimmerGradientView$ShimmerState;", "shimmerOffset", "shimmerCycleStartOffset", "shimmerVisible", "", "pendingShimmerStart", "shimmerAnimator", "Landroid/animation/ValueAnimator;", "shimmerStopCallback", "Lkotlin/Function0;", "", "value", "isAnimating", "()Z", "setAnimating", "(Z)V", "playShimmerOnce", "onComplete", "stopShimmerAfterComplete", "stopShimmerImmediately", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onAttachedToWindow", "onSizeChanged", "w", "h", "oldw", "oldh", "onVisibilityChanged", "changedView", "Landroid/view/View;", RemoteMessageConst.Notification.VISIBILITY, "onWindowVisibilityChanged", "onDetachedFromWindow", "appendStopCallback", "callback", "dispatchStopCallback", "ensureShimmerCycleRunningIfNeeded", "ensureShimmerCycleRunning", "isReadyToAnimate", "ShimmerState", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioShimmerGradientView extends AudioGradientView {

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final /* synthetic */ int f394092p0 = 0;
    public final RuntimeShader K;
    public final Paint L;
    public final float M;
    public final float N;
    public final float O;
    public final float P;
    public ShimmerState Q;
    public float R;
    public float S;
    public boolean T;
    public boolean U;
    public ValueAnimator V;
    public Function0<Unit> W;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f394093k0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/view/continuespeech/AudioShimmerGradientView$ShimmerState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "SCROLLING", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ShimmerState extends Enum<ShimmerState> {
        public static final ShimmerState IDLE = null;
        public static final ShimmerState SCROLLING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ShimmerState[] f394094a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f394095b = null;

        public static EnumEntries<ShimmerState> getEntries() {
            return f394095b;
        }

        static {
            ShimmerState r100 = new ShimmerState("IDLE", 0);
            IDLE = r100;
            ShimmerState r101 = new ShimmerState("SCROLLING", 1);
            SCROLLING = r101;
            ShimmerState[] r102 = {r100, r101};
            f394094a = r102;
            f394095b = EnumEntriesKt.enumEntries(r102);
        }

        public static ShimmerState[] values() {
            return (ShimmerState[]) f394094a.clone();
        }

        public static ShimmerState valueOf(String r100) {
            return (ShimmerState) r27.a.a(ShimmerState.class, r100);
        }

        public ShimmerState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f394096a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AudioShimmerGradientView f394097b;

        public b(AudioShimmerGradientView r100) {
            this.f394097b = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f394096a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            AudioShimmerGradientView r101 = this.f394097b;
            if (r101.V == r100) goto L5;
            return;
        L5:
            r101.V = null;
            if (this.f394096a == false) goto L8;
            return;
        L8:
            r101.R = r101.S + 1.0f;
            r101.invalidate();
            AudioShimmerGradientView r102 = this.f394097b;
            r102.Q = ShimmerState.IDLE;
            Function0<Unit> r103 = r102.W;
            r102.W = null;
            if (r103 == null) goto L12;
            r103.invoke();
            return;
        }
    }

    static {
    }

    public AudioShimmerGradientView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AudioShimmerGradientView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void d() {
        setAnimating(false);
        this.T = false;
        this.U = false;
        this.W = null;
        ValueAnimator r100 = this.V;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.V = null;
        this.Q = ShimmerState.IDLE;
    }

    public final void b() {
        ValueAnimator r100 = this.V;
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L11;
        return;
    L11:
        if (getWidth() > 0) goto L13;
    L17:
        boolean r102 = false;
    L18:
        if (r102 == true) goto L21;
        this.U = true;
        return;
    L21:
        this.U = false;
        this.S = this.R;
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r103.setDuration(1250);
        r103.setInterpolator(new LinearInterpolator());
        r103.addUpdateListener(new c0(this));
        r103.addListener(new b(this));
        r103.start();
        this.V = r103;
        return;
    L13:
        if (getHeight() <= 0) goto L17;
        if (isShown() == false) goto L17;
        r102 = true;
        goto L18
    L5:
        if (r100.isRunning() != true) goto L7;
        r101 = true;
        goto L8
    }

    public final void c() {
        if (this.Q == ShimmerState.IDLE) goto L5;
    L6:
        b();
        return;
    L5:
        if (this.U == true) goto L6;
    }

    @Override // com.obric.assistant.view.continuespeech.AudioGradientView, android.view.View
    public final void onDetachedFromWindow() {
        ValueAnimator r100 = this.V;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.V = null;
        if (this.Q == ShimmerState.IDLE) goto L8;
        this.U = true;
    L8:
        super.onDetachedFromWindow();
    }

    @Override // com.obric.assistant.view.continuespeech.AudioGradientView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        c();
    }

    @Override // com.obric.assistant.view.continuespeech.AudioGradientView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.T == true) goto L6;
        super.onDraw(r100);
        return;
    L6:
        float r101 = getWidth();
        float r102 = getHeight();
        if (r101 > 0.0f) goto L9;
        return;
    L9:
        if (r102 <= 0.0f) goto L14;
        float r103 = ((this.R % 1.0f) + 1.0f) % 1.0f;
        this.K.setFloatUniform("uResolution", r101, r102);
        this.K.setFloatUniform("uPhase", r103);
        this.K.setFloatUniform("uShimmerWidthRatio", this.M);
        this.K.setFloatUniform("uAngle", this.N);
        this.K.setFloatUniform("uBaseAlpha", this.O);
        this.K.setFloatUniform("uHighlightAlpha", this.P);
        r100.drawRect(0.0f, 0.0f, r101, r102, this.L);
        return;
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r100) {
        super.onWindowVisibilityChanged(r100);
        if (r100 != 0) goto L6;
        c();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.obric.assistant.view.continuespeech.d0] */
    /* JADX WARN: Type inference failed for: r5v2, types: [kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0<kotlin.Unit>] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v8 */
    @Override // com.obric.assistant.view.continuespeech.AudioGradientView
    public void setAnimating(boolean r100) {
        if (this.f394093k0 != r100) goto L5;
        return;
    L5:
        this.f394093k0 = r100;
        final Function0 r101 = null;
        if (r100 == false) goto L11;
        Function0<Unit> r102 = new b0(this);
        this.T = true;
        this.W = r102;
        this.U = false;
        ValueAnimator r103 = this.V;
        if (r103 == null) goto L10;
        r103.cancel();
    L10:
        this.V = null;
        this.R = 0.0f;
        this.Q = ShimmerState.SCROLLING;
        b();
        return;
    L11:
        final ?? r104 = new d0(this, r101);
        final Function0<Unit> r105 = this.W;
        ?? r106 = r104;
        if (r105 == null) goto L15;
        r106 = new e0(r105, r104);
    L15:
        this.W = r106;
        if (this.U == false) goto L21;
        if (this.V != null) goto L21;
        this.U = false;
        this.Q = ShimmerState.IDLE;
    L21:
        if (this.Q != ShimmerState.IDLE) goto L25;
        this.W = null;
        r106.invoke();
        return;
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "changedView");
        super.onVisibilityChanged(r100, r101);
        if (r101 != 0) goto L6;
        c();
        return;
    }

    public AudioShimmerGradientView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        RuntimeShader r103 = new RuntimeShader("\n            uniform float2 uResolution;\n            uniform float uPhase;\n            uniform float uShimmerWidthRatio;\n            uniform float uAngle;\n            uniform float uBaseAlpha;\n            uniform float uHighlightAlpha;\n\n            half4 main(float2 p) {\n                float2 center = uResolution * 0.5;\n                float2 dir = float2(cos(uAngle), sin(uAngle));\n                float projected = dot(p - center, dir);\n\n                float bandWidth = max(uResolution.x * uShimmerWidthRatio, 1.0);\n                float travel = length(uResolution) + 3.0 * bandWidth;\n                float bandPos = -travel * 0.5 + uPhase * travel;\n\n                float d = (projected - bandPos) / bandWidth;\n                float t = clamp(exp(-d * d * 6.0), 0.0, 1.0);\n\n                float alpha = mix(uBaseAlpha, uHighlightAlpha, t);\n                return half4(half(alpha));\n            }\n        ");
        this.K = r103;
        Paint r104 = new Paint();
        r104.setShader(r103);
        this.L = r104;
        this.M = 0.5f;
        this.O = 1.0f;
        this.P = 0.5f;
        this.Q = ShimmerState.IDLE;
        TypedArray r105 = r100.obtainStyledAttributes(r101, new int[]{R.attr.angle, R.attr.animating, R.attr.baseAlpha, R.attr.highlightAlpha, R.attr.shimmerWidth}, r102, 0);
        this.M = r105.getFloat(4, 0.5f);     // Catch: Throwable -> L8
        this.N = r105.getFloat(0, this.N);     // Catch: Throwable -> L8
        this.O = r105.getFloat(2, 1.0f);     // Catch: Throwable -> L8
        this.P = r105.getFloat(3, 0.5f);     // Catch: Throwable -> L8
        if (r105.getBoolean(1, false) == false) goto L6;
        setAnimating(true);     // Catch: Throwable -> L8
    L6:
        r105.recycle();
        return;
    L8:
        th = move-exception;
        r105.recycle();
        throw th;
    }

    public /* synthetic */ AudioShimmerGradientView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        c();
    }
}
