package com.obric.assistant.view.continuespeech;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RuntimeShader;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.shopping.yata.business.ability.common.TriggerTiming;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u001b\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0016\u0018\u0000 j2\u00020\u0001:\u0002ijB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010P2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010)J\b\u0010R\u001a\u00020NH\u0002J\u0010\u0010S\u001a\u00020N2\u0006\u0010T\u001a\u00020;H\u0002J\u0010\u0010U\u001a\u00020N2\u0006\u0010T\u001a\u00020;H\u0002J\u0010\u0010V\u001a\u00020N2\u0006\u0010W\u001a\u00020\rH\u0002J\u0012\u0010X\u001a\u00020N2\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0016J\b\u0010[\u001a\u00020NH\u0002J\u0010\u0010\\\u001a\u00020N2\u0006\u0010]\u001a\u00020^H\u0014J \u0010_\u001a\u00020N2\u0006\u0010]\u001a\u00020^2\u0006\u0010`\u001a\u00020\r2\u0006\u0010a\u001a\u00020\rH\u0002J\b\u0010b\u001a\u00020NH\u0014J\b\u0010c\u001a\u00020NH\u0014J\"\u0010d\u001a\u00020N2\u0006\u0010e\u001a\u00020,2\u0006\u0010f\u001a\u00020g2\b\b\u0001\u0010h\u001a\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R$\u0010\u0016\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R$\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR$\u0010 \u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR$\u0010\"\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R\u000e\u0010%\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006k"}, d2 = {"Lcom/obric/assistant/view/continuespeech/AudioGradientView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "initialized", "", "value", "", "cornerRadius", "getCornerRadius", "()F", "setCornerRadius", "(F)V", "blurRadius", "getBlurRadius", "setBlurRadius", "expandSize", "getExpandSize", "setExpandSize", "autoExpand", "getAutoExpand", "()Z", "setAutoExpand", "(Z)V", "isAnimating", "setAnimating", "isWarning", "setWarning", "grayRatio", "getGrayRatio", "setGrayRatio", "warningColor", "useCustomGradient", "customColorCount", "customColorsPacked", "", "customPositionsPacked", "runtimeShader", "Landroid/graphics/RuntimeShader;", "paint", "Landroid/graphics/Paint;", "grayPaint", "fadePaint", "leftFadeGradient", "Landroid/graphics/LinearGradient;", "rightFadeGradient", "leftFadeMatrix", "Landroid/graphics/Matrix;", "rightFadeMatrix", "animState", "Lcom/obric/assistant/view/continuespeech/AudioGradientView$AnimState;", "currentOffset", "lastFrameNanos", "", "retStartOffset", "retForwardDist", "retDurationMs", "retStartNanos", "warnValue", "warnTarget", "warnStartValue", "warnStartNanos", "warnRunning", "widthRatioMultiplier", "widthRatioAnimator", "Landroid/animation/ValueAnimator;", "baseMarginLeft", "baseMarginTop", "baseMarginRight", "baseMarginBottom", "isApplyingMargins", "setGradientColors", "", "colors", "", "positions", "startReturning", "updateOffset", TriggerTiming.NOW, "updateWarning", "animateWidthRatio", PickerReporterConstants.KEY.TARGET, "setLayoutParams", "params", "Landroid/view/ViewGroup$LayoutParams;", "applyBlurMargins", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawGrayArea", "w", "h", "onAttachedToWindow", "onDetachedFromWindow", "setColorUniform", "shader", "name", "", "color", "AnimState", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class AudioGradientView extends View {

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final /* synthetic */ int f394062J = 0;
    public float A;
    public long B;
    public float C;
    public float D;
    public float E;
    public long F;
    public boolean G;
    public float H;
    public ValueAnimator I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f394063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f394064b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f394065c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f394066d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f394067e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f394068f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f394069g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f394070h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f394071i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f394072j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f394073k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float[] f394074l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float[] f394075m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final RuntimeShader f394076n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Paint f394077o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Paint f394078p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Paint f394079q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final LinearGradient f394080r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final LinearGradient f394081s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Matrix f394082t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Matrix f394083u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public AnimState f394084v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f394085w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f394086x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f394087y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f394088z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/view/continuespeech/AudioGradientView$AnimState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "SCROLLING", "RETURNING", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AnimState extends Enum<AnimState> {
        public static final AnimState IDLE = null;
        public static final AnimState RETURNING = null;
        public static final AnimState SCROLLING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AnimState[] f394089a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f394090b = null;

        public static EnumEntries<AnimState> getEntries() {
            return f394090b;
        }

        static {
            AnimState r100 = new AnimState("IDLE", 0);
            IDLE = r100;
            AnimState r101 = new AnimState("SCROLLING", 1);
            SCROLLING = r101;
            AnimState r102 = new AnimState("RETURNING", 2);
            RETURNING = r102;
            AnimState[] r103 = {r100, r101, r102};
            f394089a = r103;
            f394090b = EnumEntriesKt.enumEntries(r103);
        }

        public static AnimState[] values() {
            return (AnimState[]) f394089a.clone();
        }

        public static AnimState valueOf(String r100) {
            return (AnimState) r27.a.a(AnimState.class, r100);
        }

        public AnimState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f394091a = null;

        static {
            int[] r100 = new int[AnimState.values().length];
            r100[AnimState.SCROLLING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[AnimState.RETURNING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[AnimState.IDLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f394091a = r100;
        }
    }

    static {
        new a();
    }

    public AudioGradientView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AudioGradientView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f394086x = 0;
        if (this.f394084v == AnimState.IDLE) goto L5;
    L6:
        postInvalidateOnAnimation();
        return;
    L5:
        if (this.G == true) goto L6;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f394086x = 0;
        ValueAnimator r100 = this.I;
        if (r100 == null) goto L6;
        r100.cancel();
        return;
    }

    public final boolean getAutoExpand() {
        return this.f394067e;
    }

    public final float getBlurRadius() {
        return this.f394065c;
    }

    public final float getCornerRadius() {
        return this.f394064b;
    }

    public final float getExpandSize() {
        return this.f394066d;
    }

    public final float getGrayRatio() {
        return this.f394070h;
    }

    @Override // android.view.View
    public void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        float r100 = getWidth();
        float r101 = getHeight();
        float r102 = 0.0f;
        if (r100 > 0.0f) goto L5;
        return;
    L5:
        if (r101 <= 0.0f) goto L47;
        RuntimeShader r103 = this.f394076n;
        if (r103 != null) goto L11;
        r110.drawRect(0.0f, 0.0f, r100, r101, this.f394077o);
        a(r110, r100, r101);
        return;
    L11:
        long r104 = System.nanoTime();
        int r105 = b.f394091a[this.f394084v.ordinal()];
        if (r105 == 1) goto L22;
        if (r105 != 2) goto L15;
        float r106 = RangesKt.coerceIn(((r104 - this.B) / 1000000.0f) / this.A, 0.0f, 1.0f);
        float r111 = 1.0f - r106;
        this.f394085w = this.f394087y + (this.f394088z * (1.0f - (r111 * r111)));
        if (r106 < 1.0f) goto L27;
        this.f394084v = AnimState.IDLE;
    L27:
        if (this.G == false) goto L33;
        float r107 = RangesKt.coerceIn(((r104 - this.F) / 1000000.0f) / 200.0f, 0.0f, 1.0f);
        float r108 = this.E;
        float r109 = this.D;
        float r112 = 1.0f - r107;
        this.C = r108 + ((r109 - r108) * (1.0f - (r112 * r112)));
        if (r107 < 1.0f) goto L33;
        this.C = r109;
        this.G = false;
    L33:
        if (this.f394067e == false) goto L35;
        float r113 = this.f394065c * 1.3f;
    L36:
        float r114 = 2 * r113;
        float r115 = Math.min(r100 - r114, r101 - r114) / 2.0f;
        r103.setFloatUniform("uResolution", r100, r101);
        r103.setFloatUniform("uRadius", Math.min(this.f394064b, r115));
        r103.setFloatUniform("uBlur", this.f394065c);
        r103.setFloatUniform("uInset", r113);
        r103.setFloatUniform("uOffsetX", this.f394085w);
        r103.setFloatUniform("uGradientWidthRatio", this.H * 0.8f);
        r103.setFloatUniform("uSpacingRatio", 1.5f);
        r103.setFloatUniform("uWarningProgress", this.C);
        if (this.f394072j == false) goto L39;
        r102 = 1.0f;
    L39:
        r103.setFloatUniform("uUseCustomGradient", r102);
        r103.setFloatUniform("uCustomColorCount", this.f394073k);
        r103.setFloatUniform("uCustomColors", this.f394074l);
        r103.setFloatUniform("uCustomPositions", this.f394075m);
        int r116 = this.f394071i;
        r103.setFloatUniform("uWarningColor", Color.red(r116) / 255.0f, Color.green(r116) / 255.0f, Color.blue(r116) / 255.0f);
        r110.drawRect(0.0f, 0.0f, r100, r101, this.f394077o);
        a(r110, r100, r101);
        if (this.f394084v == AnimState.IDLE) goto L42;
    L43:
        postInvalidateOnAnimation();
        return;
    L42:
        if (this.G == true) goto L43;
        return;
    L35:
        r113 = 0.0f;
        goto L36
    L15:
        if (r105 == 3) goto L27;
        throw new NoWhenBranchMatchedException();
    L22:
        long r117 = this.f394086x;
        if (r117 <= 0) goto L25;
        this.f394085w += ((r104 - r117) * 1.0f) / 1.0E9f;
    L25:
        this.f394086x = r104;
        goto L27
    }

    public void setAnimating(boolean r100) {
        if (this.f394068f != r100) goto L5;
        return;
    L5:
        this.f394068f = r100;
        if (r100 == false) goto L8;
        this.f394084v = AnimState.SCROLLING;
        this.f394086x = 0;
        postInvalidateOnAnimation();
    L12:
        if (r100 == false) goto L14;
        float r101 = 1.5f;
    L15:
        ValueAnimator r102 = this.I;
        if (r102 == null) goto L18;
        r102.cancel();
    L18:
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{this.H, r101});
        r103.setDuration(400);
        r103.addUpdateListener(new a0(this));
        r103.start();
        this.I = r103;
        return;
    L14:
        r101 = 0.8f;
        goto L15
    L8:
        float r104 = this.f394085w;
        float r105 = (1.0f - ((((r104 - 0.3f) % 1.0f) + 1.0f) % 1.0f)) % 1.0f;
        if (r105 >= 0.001f) goto L11;
        this.f394084v = AnimState.IDLE;
        goto L12
    L11:
        this.f394084v = AnimState.RETURNING;
        this.f394087y = r104;
        this.f394088z = r105;
        this.A = ((r105 * 2.0f) / 1.0f) * 1000.0f;
        this.B = System.nanoTime();
        this.f394086x = 0;
        postInvalidateOnAnimation();
        goto L12
    }

    public final void setAutoExpand(boolean r100) {
        this.f394067e = r100;
        if (this.f394063a == false) goto L6;
        invalidate();
        return;
    }

    public final void setBlurRadius(float r100) {
        this.f394065c = r100;
        if (this.f394063a == false) goto L6;
        invalidate();
        return;
    }

    public final void setCornerRadius(float r100) {
        this.f394064b = r100;
        if (this.f394063a == false) goto L6;
        invalidate();
        return;
    }

    public final void setExpandSize(float r100) {
        this.f394066d = r100;
        if (this.f394063a == false) goto L6;
        invalidate();
        return;
    }

    public final void setGrayRatio(float r100) {
        this.f394070h = Math.max(0.0f, Math.min(1.0f, r100));
        invalidate();
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams r100) {
        if ((r100 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r101 = (ViewGroup.MarginLayoutParams) r100;
        int r102 = r101.leftMargin;
        int r103 = r101.topMargin;
        int r104 = r101.rightMargin;
        int r105 = r101.bottomMargin;
    L5:
        super.setLayoutParams(r100);
    }

    public final void setWarning(boolean r100) {
        if (this.f394069g != r100) goto L5;
        return;
    L5:
        this.f394069g = r100;
        if (r100 == false) goto L8;
        float r101 = 1.0f;
    L9:
        this.D = r101;
        this.E = this.C;
        this.F = System.nanoTime();
        this.G = true;
        postInvalidateOnAnimation();
        return;
    L8:
        r101 = 0.0f;
        goto L9
    }

    public AudioGradientView(Context r210, AttributeSet r211, int r212) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r210, r211, r212);
        this.f394067e = true;
        this.f394071i = -42663;
        this.f394074l = new float[32];
        this.f394075m = new float[8];
        RuntimeShader r100 = new RuntimeShader("\nuniform float2 uResolution;\nuniform float uRadius;\nuniform float uBlur;\nuniform float uInset;\nuniform float uOffsetX;\nuniform float uGradientWidthRatio;\nuniform float uSpacingRatio;\nuniform float uWarningProgress;\nuniform float3 uWarningColor;\nuniform float uUseCustomGradient;\nuniform float uCustomColorCount;\nuniform float uCustomColors[32];\nuniform float uCustomPositions[8];\n\nfloat erf_approx(float x) {\n    float ax = abs(x);\n    float t  = 1.0 / (1.0 + 0.3275911 * ax);\n    float y  = 1.0 - (((((1.061405429 * t - 1.453152027) * t)\n               + 1.421413741) * t - 0.284496736) * t + 0.254829592)\n               * t * exp(-ax * ax);\n    return x >= 0.0 ? y : -y;\n}\n\nfloat gaussianEdge(float dist, float sigma) {\n    return 0.5 - 0.5 * erf_approx(dist / (sigma * 1.4142135));\n}\n\nfloat roundedRectSDF(float2 p, float2 size, float r) {\n    float2 h = size * 0.5;\n    float2 d = abs(p) - h + r;\n    float outside = length(max(d, 0.0));\n    float inside  = min(max(d.x, d.y), 0.0);\n    return outside + inside - r;\n}\n\n// 高斯加权三色渐变，softness 控制颜色过渡柔和度\nfloat4 gaussianGradient3(float2 p, float2 ctr, float angle, float w,\n                         float4 cA, float4 cB, float4 cC, float mirror,\n                         float softness) {\n    float cosA = cos(angle);\n    float sinA = sin(angle);\n    float projected = dot(p - ctr, float2(cosA, sinA));\n    float t = projected / w + 0.5;\n    if (mirror > 0.5) {\n        t = 1.0 - abs(t * 2.0 - 1.0);\n    }\n    float s = max(softness, 0.15);\n    float fade = s * 0.5;\n    float edge = smoothstep(-fade, 0.0, t) * smoothstep(-fade, 0.0, 1.0 - t);\n    if (edge <= 0.0) {\n        return float4(0.0);\n    }\n    float inv2s2 = 1.0 / (2.0 * s * s);\n    float wA = exp(-t * t * inv2s2);\n    float wB = exp(-(t - 0.5) * (t - 0.5) * inv2s2);\n    float wC = exp(-(t - 1.0) * (t - 1.0) * inv2s2);\n    float total = wA + wB + wC;\n    float4 result = (cA * wA + cB * wB + cC * wC) / total;\n    result.a *= edge;\n    return result;\n}\n\nconst float  GRADIENT_ANGLE    = 0.0;\nconst float  GRADIENT_SOFTNESS = 1.0 / 4.0;\nconst float3 COLOR_BG          = float3(0.373, 0.522, 1.0);\nconst float3 COLOR_WARNING     = float3(1.0, 0.349, 0.349);\nconst float4 COLOR_A           = float4(1.0, 0.565, 0.565, 0.0);\nconst float4 COLOR_B           = float4(1.0, 0.565, 0.565, 1.0);\nconst float4 COLOR_C           = float4(0.996, 0.757, 0.514, 1.0);\n\nint clampColorCount(int n) {\n    if (n < 0) {\n        return 0;\n    }\n    if (n > 8) {\n        return 8;\n    }\n    return n;\n}\n\nfloat4 customColor0() { return float4(uCustomColors[0], uCustomColors[1], uCustomColors[2], uCustomColors[3]); }\nfloat4 customColor1() { return float4(uCustomColors[4], uCustomColors[5], uCustomColors[6], uCustomColors[7]); }\nfloat4 customColor2() { return float4(uCustomColors[8], uCustomColors[9], uCustomColors[10], uCustomColors[11]); }\nfloat4 customColor3() { return float4(uCustomColors[12], uCustomColors[13], uCustomColors[14], uCustomColors[15]); }\nfloat4 customColor4() { return float4(uCustomColors[16], uCustomColors[17], uCustomColors[18], uCustomColors[19]); }\nfloat4 customColor5() { return float4(uCustomColors[20], uCustomColors[21], uCustomColors[22], uCustomColors[23]); }\nfloat4 customColor6() { return float4(uCustomColors[24], uCustomColors[25], uCustomColors[26], uCustomColors[27]); }\nfloat4 customColor7() { return float4(uCustomColors[28], uCustomColors[29], uCustomColors[30], uCustomColors[31]); }\n\nfloat4 mixSegment(float x, float prevPos, float pos, float4 prevCol, float4 col) {\n    float denom = max(pos - prevPos, 0.0001);\n    float t = clamp((x - prevPos) / denom, 0.0, 1.0);\n    return mix(prevCol, col, t);\n}\n\nfloat4 sampleCustomGradient(float x) {\n    int n = clampColorCount(int(uCustomColorCount + 0.5));\n    if (n <= 0) {\n        return float4(COLOR_BG, 1.0);\n    }\n    x = clamp(x, 0.0, 1.0);\n    float p0 = uCustomPositions[0];\n    float p1 = uCustomPositions[1];\n    float p2 = uCustomPositions[2];\n    float p3 = uCustomPositions[3];\n    float p4 = uCustomPositions[4];\n    float p5 = uCustomPositions[5];\n    float p6 = uCustomPositions[6];\n    float p7 = uCustomPositions[7];\n    float4 c0 = customColor0();\n    float4 c1 = customColor1();\n    float4 c2 = customColor2();\n    float4 c3 = customColor3();\n    float4 c4 = customColor4();\n    float4 c5 = customColor5();\n    float4 c6 = customColor6();\n    float4 c7 = customColor7();\n\n    if (n == 1) {\n        return c0;\n    }\n    if (x <= p0) {\n        return c0;\n    }\n    if (n == 2 || x <= p1) {\n        return mixSegment(x, p0, p1, c0, c1);\n    }\n    if (n == 3 || x <= p2) {\n        return mixSegment(x, p1, p2, c1, c2);\n    }\n    if (n == 4 || x <= p3) {\n        return mixSegment(x, p2, p3, c2, c3);\n    }\n    if (n == 5 || x <= p4) {\n        return mixSegment(x, p3, p4, c3, c4);\n    }\n    if (n == 6 || x <= p5) {\n        return mixSegment(x, p4, p5, c4, c5);\n    }\n    if (n == 7 || x <= p6) {\n        return mixSegment(x, p5, p6, c5, c6);\n    }\n    if (n == 8 || x <= p7) {\n        return mixSegment(x, p6, p7, c6, c7);\n    }\n    return c7;\n}\n\nhalf4 main(float2 p) {\n    float2 center = uResolution * 0.5;\n    float2 size   = uResolution - uInset * 2.0;\n\n    float dist = roundedRectSDF(p - center, size, uRadius);\n    float shape;\n    if (uBlur > 0.0) {\n        float sigma = uBlur * 0.5;\n        float inner = gaussianEdge(dist, sigma / 6.0);\n        float outer = gaussianEdge(dist, sigma);\n        shape = inner + outer * (1.0 - inner);\n    } else {\n        shape = clamp(0.5 - dist, 0.0, 1.0);\n    }\n\n    float3 color;\n    float colorAlpha = 1.0;\n    int n = clampColorCount(int(uCustomColorCount + 0.5));\n    if (uUseCustomGradient > 0.5 && n > 0) {\n        float4 customColor = sampleCustomGradient(p.x / uResolution.x);\n        color = customColor.rgb;\n        colorAlpha = customColor.a;\n    } else {\n        float gradientWidth = size.x * uGradientWidthRatio;\n        float spacing       = size.x * uSpacingRatio;\n        float wrapped       = mod(uOffsetX * spacing, spacing);\n\n        float4 g0 = gaussianGradient3(p, center + float2(wrapped - spacing, 0.0),\n                                       GRADIENT_ANGLE, gradientWidth,\n                                       COLOR_A, COLOR_B, COLOR_C, 1.0, GRADIENT_SOFTNESS);\n        float4 g1 = gaussianGradient3(p, center + float2(wrapped, 0.0),\n                                       GRADIENT_ANGLE, gradientWidth,\n                                       COLOR_A, COLOR_B, COLOR_C, 1.0, GRADIENT_SOFTNESS);\n\n        color = COLOR_BG;\n        color = g0.rgb * g0.a + color * (1.0 - g0.a);\n        color = g1.rgb * g1.a + color * (1.0 - g1.a);\n    }\n    color = mix(color, uWarningColor, uWarningProgress);\n    float finalAlpha = shape * colorAlpha;\n    return half4(half3(color) * half(finalAlpha), half(finalAlpha));\n}\n");     // Catch: Throwable -> L5
    L6:
        this.f394076n = r100;
        Paint r101 = new Paint(1);
        r101.setShader(r100);
        if (r100 != null) goto L9;
        r101.setColor(ColorProtector.parseColor("#5F85FF"));
    L9:
        this.f394077o = r101;
        Paint r102 = new Paint();
        r102.setColor(ColorProtector.parseColor("#FFC9CDCF"));
        this.f394078p = r102;
        this.f394079q = new Paint(1);
        this.f394080r = new LinearGradient(0.0f, 0.0f, 1.0f, 0.0f, new int[]{r102.getColor(), 16777215}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        this.f394081s = new LinearGradient(0.0f, 0.0f, 1.0f, 0.0f, new int[]{16777215, r102.getColor()}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        this.f394082t = new Matrix();
        this.f394083u = new Matrix();
        this.f394084v = AnimState.IDLE;
        this.f394085w = 0.3f;
        this.H = 1.0f;
        TypedArray r103 = r210.obtainStyledAttributes(r211, new int[]{R.attr.autoExpand, R.attr.blurRadius, R.attr.cornerRadius, R.attr.expandSize}, r212, 0);
        setAutoExpand(r103.getBoolean(0, true));     // Catch: Throwable -> L13
        setCornerRadius(r103.getDimension(2, 0.0f));     // Catch: Throwable -> L13
        setBlurRadius(r103.getDimension(1, 0.0f));     // Catch: Throwable -> L13
        setExpandSize(r103.getDimension(3, 0.0f));     // Catch: Throwable -> L13
        r103.recycle();
        this.f394063a = true;
        return;
    L13:
        th = move-exception;
        r103.recycle();
        throw th;
    L5:
        r100 = null;
        goto L6
    }

    public final void a(Canvas r210, float r211, float r212) {
        Resources r100 = getResources();
        float r101 = Math.min(0.04f * r211, WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()).density * 24.0f);
        float r102 = ((r211 / 2.0f) + (2 * r101)) * this.f394070h;
        if (r102 <= 0.0f) goto L10;
        float r103 = Math.max(0.0f, r102 - r101);
        if (r103 <= 0.0f) goto L8;
        r210.drawRect(0.0f, 0.0f, r103, r212, this.f394078p);
    L8:
        if (r102 <= r103) goto L10;
        this.f394082t.reset();
        this.f394082t.setScale(RangesKt.coerceAtLeast(r102 - r103, 0.0f), 1.0f);
        this.f394082t.postTranslate(r103, 0.0f);
        this.f394080r.setLocalMatrix(this.f394082t);
        this.f394079q.setShader(this.f394080r);
        r210.drawRect(r103, 0.0f, r102, r212, this.f394079q);
        this.f394079q.setShader(null);
    L10:
        if (r102 <= 0.0f) goto L18;
        float r110 = r211 - r102;
        float r104 = Math.min(r211, r101 + r110);
        if (r104 <= r110) goto L15;
        this.f394083u.reset();
        this.f394083u.setScale(RangesKt.coerceAtLeast(r104 - r110, 0.0f), 1.0f);
        this.f394083u.postTranslate(r110, 0.0f);
        this.f394081s.setLocalMatrix(this.f394083u);
        this.f394079q.setShader(this.f394081s);
        r210.drawRect(r110, 0.0f, r104, r212, this.f394079q);
        this.f394079q.setShader(null);
    L15:
        if (r211 <= r104) goto L19;
        r210.drawRect(r104, 0.0f, r211, r212, this.f394078p);
        return;
    L19:
        return;
    }

    public /* synthetic */ AudioGradientView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
