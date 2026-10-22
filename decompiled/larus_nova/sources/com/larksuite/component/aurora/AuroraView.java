package com.larksuite.component.aurora;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttm.player.MediaPlayer;
import h18.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 V2\u00020\u0001:\u0002UVB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\b\u0010\u0010\u001a\u00020\u000fH\u0002J\"\u00106\u001a\u0002072\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u0019J,\u00108\u001a\u0002072\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u00109\u001a\u00020:J\u0006\u0010;\u001a\u000207J\u0006\u0010<\u001a\u000207J\u0010\u0010=\u001a\u0002072\b\b\u0001\u0010>\u001a\u00020\u0012J\u0010\u0010?\u001a\u0002072\b\b\u0001\u0010@\u001a\u00020\u0012J\u0010\u0010A\u001a\u0002072\u0006\u0010B\u001a\u00020CH\u0014J\b\u0010D\u001a\u000207H\u0014JZ\u0010E\u001a\u000207*\u00020\u00192\u0006\u0010B\u001a\u00020C2!\u0010F\u001a\u001d\u0012\u0013\u0012\u00110H¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(K\u0012\u0004\u0012\u0002070G2!\u0010L\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(M\u0012\u0004\u0012\u00020\n0GH\u0002J'\u0010N\u001a\u00020\n2\u0006\u0010M\u001a\u00020\n2\b\u0010O\u001a\u0004\u0018\u00010\n2\u0006\u0010>\u001a\u00020\u0012H\u0002¢\u0006\u0002\u0010PJ\"\u0010Q\u001a\u0002072\u0006\u0010K\u001a\u00020H2\b\u0010R\u001a\u0004\u0018\u00010S2\u0006\u0010>\u001a\u00020\u0012H\u0002J*\u0010T\u001a\u0002072\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00128\u0000@\u0000X\u0081\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u00020\u00128\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00020\u00128\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00020\u00128\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u00020\u00128\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010(\u001a\u00020\u00128\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u001b\u0010)\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b+\u0010,R\u0010\u0010/\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00102\u001a\u00020\u00128\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u001b\u00103\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010.\u001a\u0004\b4\u0010,¨\u0006W"}, d2 = {"Lcom/larksuite/component/aurora/AuroraView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "delegate", "Lcom/larksuite/component/aurora/AuroraDelegate;", "createDelegate", "blurRadius", "", "getBlurRadius$aurora_release", "()F", "setBlurRadius$aurora_release", "(F)V", "standardCanvasWidth", "mainBlob", "Lcom/larksuite/component/aurora/AuroraView$AuroraBlob;", "subBlob", "reflectionBlob", "normalMainFraction", "normalSubFraction", "normalReflectionFraction", "slideMainOffsetX", "slideSubOffsetX", "slideReflectionOffsetX", "normalMainRadiusOffsetX", "normalMainRadiusOffsetY", "normalSubRadiusOffsetX", "normalSubRadiusOffsetY", "normalReflectionOffsetX", "normalReflectionOffsetY", "slideFraction", "normalAnimator", "Landroid/animation/ValueAnimator;", "getNormalAnimator", "()Landroid/animation/ValueAnimator;", "normalAnimator$delegate", "Lkotlin/Lazy;", "targetMainBlob", "targetSubBlob", "targetReflectionBlob", "blobFraction", "blobAnimator", "getBlobAnimator", "blobAnimator$delegate", "setBlobs", "", "animateBlobs", "duration", "", "startNormalAnimate", "pauseNormalAnimate", "setSlideFraction", "fraction", "setBlurRadius", "radius", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onDetachedFromWindow", "draw", "boundModifier", "Lkotlin/Function1;", "Landroid/graphics/RectF;", "Lkotlin/ParameterName;", "name", "bound", "colorModifier", "color", "interpolateColors", "targetColor", "(ILjava/lang/Integer;F)I", "interpolateBound", "targetBound", "Landroid/graphics/Rect;", "applyAttrs", "AuroraBlob", "Companion", "aurora_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuroraView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AuroraDelegate f282938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f282939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f282940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f282941d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f282942e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f282943f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f282944g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f282945h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f282946i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f282947j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f282948k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f282949l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f282950m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f282951n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f282952o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f282953p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f282954q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f282955r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f282956s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f282957t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public a f282958u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public a f282959v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public a f282960w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f282961x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f282962y;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f282963a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f282964b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Rect f282965c;

        /* JADX INFO: renamed from: com.larksuite.component.aurora.AuroraView$a$a, reason: collision with other inner class name */
        public static final class C3886a {
        }

        static {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f282963a == r101.f282963a) goto L12;
            return false;
        L12:
            if (Float.compare(this.f282964b, r101.f282964b) == 0) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f282965c, r101.f282965c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f282963a * 31) + Float.floatToIntBits(this.f282964b)) * 31) + this.f282965c.hashCode();
        }

        public final String toString() {
            return "AuroraBlob(color=" + this.f282963a + ", alpha=" + this.f282964b + ", bound=" + this.f282965c + ')';
        }

        public final int a() {
            return UDColorUtils.getAlphaColor(this.f282963a, this.f282964b);
        }

        public a(int r100, float r101, Rect r102) {
            Intrinsics.checkNotNullParameter(r102, "bound");
            this.f282963a = r100;
            this.f282964b = r101;
            this.f282965c = r102;
        }

        public a(int r100, float r101, int r102, int r103, int r104, int r105) {
            this(r100, r101, new Rect(r102, r103, r104 + r102, r105 + r103));
        }
    }

    public static final class b {
    }

    static {
    }

    private final ValueAnimator getBlobAnimator() {
        return (ValueAnimator) this.f282962y.getValue();
    }

    private final ValueAnimator getNormalAnimator() {
        return (ValueAnimator) this.f282957t.getValue();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (getNormalAnimator().isRunning() == false) goto L6;
        getNormalAnimator().cancel();
        return;
    }

    public final float getBlurRadius$aurora_release() {
        return this.f282939b;
    }

    public AuroraView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        a r101 = this.f282941d;
        if (r101 == null) goto L5;
        final Function1<RectF, Unit> r102 = new AnonymousClass1(this);
        Function1<Integer, Integer> r103 = new AnonymousClass2(this);
        this.f282938a.b(r100, r101, new AuroraView$draw$1(r102, this), r103);
    L5:
        a r104 = this.f282942e;
        if (r104 == null) goto L8;
        final Function1<RectF, Unit> r105 = new AnonymousClass3(this);
        Function1<Integer, Integer> r106 = new AnonymousClass4(this);
        this.f282938a.b(r100, r104, new AuroraView$draw$1(r105, this), r106);
    L8:
        a r107 = this.f282943f;
        if (r107 == null) goto L12;
        final Function1<RectF, Unit> r108 = new AnonymousClass5(this);
        Function1<Integer, Integer> r109 = new AnonymousClass6(this);
        this.f282938a.b(r100, r107, new AuroraView$draw$1(r108, this), r109);
        return;
    }

    public final void setBlurRadius(float r100) {
        if (r100 >= 0.0f) goto L5;
        return;
    L5:
        this.f282939b = r100;
        this.f282938a.f();
    }

    public final void setBlurRadius$aurora_release(float r100) {
        this.f282939b = r100;
    }

    public final void setSlideFraction(float r100) {
        this.f282956s = r100;
        invalidate();
    }

    public AuroraView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public AuroraView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112, 0);
        int r100 = Build.VERSION.SDK_INT;
        if (r100 < 31) goto L6;
        AuroraDelegate r101 = new c(this);
    L9:
        this.f282938a = r101;
        this.f282939b = d.b(getContext(), 80);
        this.f282940c = d.b(getContext(), MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS);
        this.f282945h = (float) Math.sin(0.6283185307179586d);
        this.f282947j = (int) d.b(getContext(), 48);
        this.f282948k = (int) d.b(getContext(), 16);
        this.f282949l = (int) d.b(getContext(), 24);
        this.f282950m = (int) d.b(getContext(), 14);
        this.f282951n = (int) d.b(getContext(), 14);
        this.f282952o = (int) d.b(getContext(), 25);
        this.f282953p = (int) d.b(getContext(), 25);
        this.f282954q = (int) d.b(getContext(), 25);
        this.f282955r = (int) d.b(getContext(), 20);
        LazyThreadSafetyMode r102 = LazyThreadSafetyMode.NONE;
        this.f282957t = LazyKt.lazy(r102, new AuroraView$normalAnimator$2(this));
        this.f282962y = LazyKt.lazy(r102, new AuroraView$blobAnimator$2(this));
        r101.e();
        TypedArray r113 = r110.obtainStyledAttributes(r111, new int[]{R.attr.blurRadius, R.attr.mainBlob_alpha, R.attr.mainBlob_bound_height, R.attr.mainBlob_bound_left, R.attr.mainBlob_bound_top, R.attr.mainBlob_bound_width, R.attr.mainBlob_color, R.attr.reflectionBlob_alpha, R.attr.reflectionBlob_bound_height, R.attr.reflectionBlob_bound_left, R.attr.reflectionBlob_bound_top, R.attr.reflectionBlob_bound_width, R.attr.reflectionBlob_color, R.attr.subBlob_alpha, R.attr.subBlob_bound_height, R.attr.subBlob_bound_left, R.attr.subBlob_bound_top, R.attr.subBlob_bound_width, R.attr.subBlob_color}, r112, 0);
        int r114 = r113.getDimensionPixelSize(0, -1);
        if (r114 < 0) goto L12;
        setBlurRadius(r114);
    L12:
        int r103 = r113.getColor(6, 0);
        float r104 = r113.getFloat(1, 0.0f);
        int r105 = r113.getDimensionPixelSize(3, 0);
        int r106 = r113.getDimensionPixelSize(4, 0);
        int r115 = r113.getDimensionPixelSize(5, 0);
        int r116 = r113.getDimensionPixelSize(2, 0);
        a r117 = null;
        if (r103 == 0) goto L15;
        a r107 = new a(r103, r104, r105, r106, r115, r116);
    L16:
        int r108 = r113.getColor(18, 0);
        float r109 = r113.getFloat(13, 0.0f);
        int r118 = r113.getDimensionPixelSize(15, 0);
        int r119 = r113.getDimensionPixelSize(16, 0);
        int r120 = r113.getDimensionPixelSize(17, 0);
        int r121 = r113.getDimensionPixelSize(14, 0);
        if (r108 == 0) goto L19;
        a r122 = new a(r108, r109, r118, r119, r120, r121);
    L20:
        int r123 = r113.getColor(12, 0);
        float r124 = r113.getFloat(7, 0.0f);
        int r125 = r113.getDimensionPixelSize(9, 0);
        int r126 = r113.getDimensionPixelSize(10, 0);
        int r127 = r113.getDimensionPixelSize(11, 0);
        int r128 = r113.getDimensionPixelSize(8, 0);
        if (r123 == 0) goto L23;
        r117 = new a(r123, r124, r125, r126, r127, r128);
    L23:
        r113.recycle();
        if (r107 != null) goto L29;
        if (r122 != null) goto L29;
        if (r117 != null) goto L29;
        return;
    L29:
        if (r107 == null) goto L31;
        Intrinsics.checkNotNullParameter(r107, "mainBlob");
        this.f282941d = r107;
        this.f282942e = r122;
        this.f282943f = r117;
        invalidate();
        return;
    L31:
        a r129 = new a(0, 0.0f, 0, 0, 0, 0);
        Intrinsics.checkNotNullParameter(r129, "mainBlob");
        this.f282941d = r129;
        this.f282942e = r122;
        this.f282943f = r117;
        invalidate();
        return;
    L19:
        r122 = null;
        goto L20
    L15:
        r107 = null;
        goto L16
    L6:
        if (r100 < 28) goto L8;
        r101 = new com.larksuite.component.aurora.b(this);
        goto L9
    L8:
        r101 = new com.larksuite.component.aurora.a(this);
        goto L9
    }

    public static final void a(AuroraView r100, RectF r101, Rect r102, float r103) {
        r100.getClass();
        if (r102 == null) goto L7;
        float r104 = r102.left;
        float r105 = r101.left;
        float r106 = r102.top;
        float r107 = r101.top;
        float r108 = r102.right;
        float r109 = r101.right;
        float r110 = r102.bottom;
        float r111 = r101.bottom;
        r101.left = r105 + ((r104 - r105) * r103);
        r101.top = r107 + ((r106 - r107) * r103);
        r101.right = r109 + ((r108 - r109) * r103);
        r101.bottom = r111 + ((r110 - r111) * r103);
        return;
    }

    public static final int b(AuroraView r100, int r101, Integer r102, float r103) {
        r100.getClass();
        if (r102 == null) goto L7;
        float r104 = 1 - r103;
        return Color.argb((int) ((Color.alpha(r101) * r104) + (Color.alpha(r102.intValue()) * r103)), (int) ((Color.red(r101) * r104) + (Color.red(r102.intValue()) * r103)), (int) ((Color.green(r101) * r104) + (Color.green(r102.intValue()) * r103)), (int) ((Color.blue(r101) * r104) + (Color.blue(r102.intValue()) * r103)));
    L7:
        return r101;
    }
}
