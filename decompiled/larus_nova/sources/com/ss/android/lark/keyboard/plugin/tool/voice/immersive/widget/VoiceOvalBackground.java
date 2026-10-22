package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.widget;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import h18.f;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 G2\u00020\u0001:\u0001GB\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010+\u001a\u00020,H\u0014J\u000e\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\u0018J$\u0010/\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u0018002\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104J(\u00105\u001a\u00020,2\u0006\u00106\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\u000e2\u0006\u00108\u001a\u00020\u000e2\u0006\u00109\u001a\u00020\u000eH\u0014J\b\u0010:\u001a\u00020,H\u0002J\u0010\u0010;\u001a\u00020,2\u0006\u0010<\u001a\u00020=H\u0014J\b\u0010>\u001a\u00020,H\u0002J \u0010?\u001a\u00020,2\b\b\u0002\u0010@\u001a\u00020\u00182\u000e\b\u0002\u0010A\u001a\b\u0012\u0004\u0012\u00020,0BJ,\u0010C\u001a\u00020,*\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010D\u001a\u00020\u00102\u0006\u0010E\u001a\u00020\u00102\u0006\u0010F\u001a\u00020\u0010H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b'\u0010(¨\u0006H"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/widget/VoiceOvalBackground;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "path", "Landroid/graphics/Path;", "paint", "Landroid/graphics/Paint;", "borderPaint", "shadowColor", "", "shadowRadius", "", "shadowX", "shadowY", "borderSize", "borderColor", "rectF", "Landroid/graphics/RectF;", "isNormalState", "", "ovalBackgroundRegion", "Landroid/graphics/Region;", "startSemiMajorAxis", "startSemiMinorAxis", "endSemiMajorAxis", "endSemiMinorAxis", "currentSemiMajorAxis", "currentSemiMinorAxis", "whiteColor", "whiteColor10", "voiceRecordIcon", "Landroidx/appcompat/widget/AppCompatImageView;", "gradientColor", "", "getGradientColor", "()[I", "gradientColor$delegate", "Lkotlin/Lazy;", "onFinishInflate", "", "setState", "isNormal", "checkTouchInOvalArea", "Lkotlin/Pair;", "event", "Landroid/view/MotionEvent;", PickerReporterConstants.KEY.TARGET, "Landroid/view/View;", "onSizeChanged", "w", "h", "oldw", "oldh", "updateOvalRegion", "onDraw", "canvas", "Landroid/graphics/Canvas;", "initData", "startAnimator", "isExpand", "onAnimatorEnd", "Lkotlin/Function0;", "addOval", "r1", "r2", "shadowHeight", "Companion", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceOvalBackground extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f430665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f430666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f430667c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f430668d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f430669e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RectF f430670f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f430671g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Region f430672h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f430673i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f430674j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f430675k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f430676l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f430677m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f430678n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f430679o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f430680p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public AppCompatImageView f430681q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f430682r;

    public static final class a {
    }

    static {
    }

    private final int[] getGradientColor() {
        return (int[]) this.f430682r.getValue();
    }

    public final void e() {
        RectF r100 = new RectF();
        Path r101 = new Path(this.f430665a);
        Path r102 = new Path();
        r102.addRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), Path.Direction.CW);
        r101.op(r102, Path.Op.INTERSECT);
        r101.computeBounds(r100, true);
        this.f430672h.setPath(r101, new Region((int) r100.left, (int) r100.top, (int) r100.right, (int) r100.bottom));
    }

    public final void c() {
        this.f430670f.set(0.0f, 0.0f, getWidth(), getHeight());
        boolean r100 = f.a(getContext());
        Paint r101 = this.f430666b;
        r101.setStyle(Paint.Style.FILL);
        if (this.f430671g == true) goto L5;
        r101.setShader(new LinearGradient(getWidth() / 2.0f, 0.0f, getWidth() / 2.0f, getHeight(), getGradientColor(), new float[]{0.0f, 0.6f, 1.0f}, Shader.TileMode.CLAMP));
        this.f430666b.setColor(this.f430679o);
    L10:
        Paint r102 = this.f430667c;
        r102.setColor(this.f430669e);
        r102.setStrokeWidth(this.f430668d);
        if (r100 == false) goto L13;
        int r103 = 26;
    L14:
        r102.setAlpha(r103);
        r102.setStyle(Paint.Style.STROKE);
        this.f430665a.reset();
        if (this.f430671g == true) goto L17;
        a(this.f430665a, this.f430670f, this.f430678n, this.f430677m, this.f430668d / 2.0f);
        return;
    L17:
        a(this.f430665a, this.f430670f, this.f430678n, this.f430677m, 0.0f);
        return;
    L13:
        r103 = 51;
        goto L14
    L5:
        this.f430666b.setShader(null);
        Paint r104 = this.f430666b;
        if (r100 == false) goto L8;
        int r105 = this.f430680p;
    L9:
        r104.setColor(r105);
        goto L10
    L8:
        r105 = UIUtils.getColor(getContext(), R.color.static_black_20);
        goto L9
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        AppCompatImageView r100 = (AppCompatImageView) findViewById(R.id.icon_voice);
        Drawable r101 = r100.getDrawable();
        if (r101 == null) goto L5;
        r101.setColorFilter(new PorterDuffColorFilter(UIUtils.getColor(r100.getContext(), R.color.static_black_50), PorterDuff.Mode.SRC_IN));
    L5:
        this.f430681q = r100;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        if (this.f430671g == true) goto L5;
        r100.drawPath(this.f430665a, this.f430666b);
        int r101 = r100.save();
        r100.translate(0.0f, this.f430668d / 2.0f);
        r100.drawPath(this.f430665a, this.f430667c);
        r100.restoreToCount(r101);
        return;
    L5:
        r100.drawPath(this.f430665a, this.f430666b);
    }

    public final void setState(boolean r100) {
        this.f430671g = r100;
        c();
        invalidate();
        if (r100 == false) goto L9;
        AppCompatImageView r101 = this.f430681q;
        if (r101 == null) goto L15;
        Drawable r102 = r101.getDrawable();
        if (r102 == null) goto L16;
        r102.setColorFilter(new PorterDuffColorFilter(UIUtils.getColor(getContext(), R.color.static_white_70), PorterDuff.Mode.SRC_IN));
        return;
    L16:
        return;
    L15:
        return;
    L9:
        AppCompatImageView r103 = this.f430681q;
        if (r103 == null) goto L18;
        Drawable r104 = r103.getDrawable();
        if (r104 == null) goto L19;
        r104.setColorFilter(new PorterDuffColorFilter(UIUtils.getColor(getContext(), R.color.static_black_50), PorterDuff.Mode.SRC_IN));
        return;
    L19:
        return;
    }

    public VoiceOvalBackground(final Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f430665a = new Path();
        this.f430666b = new Paint(5);
        this.f430667c = new Paint(5);
        ColorProtector.parseColor("#FFE4E5E5");
        UIUtils.dp2px(r100, 10.0f);
        UIUtils.dp2px(r100, 4.0f);
        UIUtils.dp2px(r100, -4.0f);
        this.f430668d = UIUtils.dp2px(r100, 4.0f);
        this.f430669e = -1;
        this.f430670f = new RectF();
        this.f430672h = new Region();
        float r102 = UIUtils.dp2px(r100, 153.0f);
        this.f430673i = r102;
        float r103 = UIUtils.dp2px(r100, 23.0f);
        this.f430674j = r103;
        this.f430675k = UIUtils.dp2px(r100, 340.0f);
        this.f430676l = UIUtils.dp2px(r100, 200.0f);
        this.f430677m = r102;
        this.f430678n = r103;
        this.f430679o = UIUtils.getColor(r100, R.color.static_white);
        this.f430680p = UIUtils.getColor(r100, R.color.static_white_10);
        this.f430682r = LazyKt.lazy(new VoiceOvalBackground$gradientColor$2(r100));
        setWillNotDraw(false);
        setLayerType(1, null);
    }

    public final Pair<int[], Boolean> b(MotionEvent r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (r101 == null) goto L5;
        int[] r102 = {0, 0};
        if (sob.c.a(this) == false) goto L9;
        r101.getLocationInWindow(r102);
        int r103 = r102[0];
        int r104 = r102[1];
        getLocationInWindow(r102);
        r102[0] = ((int) r100.getX()) + (r103 - r102[0]);
        r102[1] = ((int) r100.getY()) + (r104 - r102[1]);
    L11:
        return new Pair(r102, Boolean.valueOf(this.f430672h.contains(r102[0], r102[1]) | this.f430672h.isEmpty()));
    L9:
        getLocationOnScreen(r102);
        r102[0] = (int) (r100.getRawX() - r102[0]);
        r102[1] = (int) (r100.getRawY() - r102[1]);
        goto L11
    L5:
        return new Pair(new int[]{0, 0}, Boolean.FALSE);
    }

    public static void d(VoiceOvalBackground r100, Function0 r101, int r102) {
        if ((r102 & 1) == 0) goto L5;
        boolean r103 = true;
    L7:
        if ((r102 & 2) == 0) goto L9;
        r101 = VoiceOvalBackground$startAnimator$1.INSTANCE;
    L9:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "onAnimatorEnd");
        ValueAnimator r104 = ObjectAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r104.setDuration(150);
        r104.setInterpolator(new LinearInterpolator());
        r104.addUpdateListener(new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.widget.a(r100, r103));
        Intrinsics.checkNotNull(r104);
        r104.addListener(new b(r101));
        r104.start();
        return;
    L5:
        r103 = false;
        goto L7
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        c();
        e();
    }

    public static void a(Path r100, RectF r101, float r102, float r103, float r104) {
        float r105 = r101.width();
        float r106 = r101.height();
        float r107 = 2;
        float r108 = r103 * r107;
        float r109 = r107 * r102;
        float r110 = r108 - r105;
        if (r106 <= r102) goto L5;
        r101.set((-r110) / 2.0f, r106 - r102, r105 + (r110 / 2.0f), r106 + r102);
    L6:
        r100.addOval(r101, Path.Direction.CW);
        return;
    L5:
        r101.set((-r110) / 2.0f, r104, r105 + (r110 / 2.0f), r109);
        goto L6
    }
}
