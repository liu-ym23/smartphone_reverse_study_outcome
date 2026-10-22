package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.widget;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.nova.R;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceModule;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\"\u001a\u00020\tH\u0002J\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\tH\u0014J\u0010\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020)H\u0014J\u0010\u0010*\u001a\u00020$2\b\b\u0002\u0010+\u001a\u00020\u001aJ\u0010\u0010,\u001a\u00020$2\b\b\u0002\u0010+\u001a\u00020\u001aJ8\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00132\u0006\u00100\u001a\u00020\u00132\u0006\u00101\u001a\u00020\t2\u0006\u00102\u001a\u00020\t2\u0006\u00103\u001a\u00020\t2\u0006\u00104\u001a\u00020\tH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001e\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001f¨\u00065"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/widget/VoiceCircleButton;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "normalCircleColor", "", "normalCircleColorDM", "expandedCircleColor", "normalIconTintColor", "expandedIconTintColor", "iconDrawable", "Landroid/graphics/drawable/Drawable;", "iconNonCnDrawable", "currentIconDrawable", "iconRotateAngle", "", "normalRadius", "expandedRadius", "iconSize", "paint", "Landroid/graphics/Paint;", "isNormal", "", "currentCircleRadius", "currentCircleColor", "currentIconColor", "isNightMode", "()Z", "isNightMode$delegate", "Lkotlin/Lazy;", "circleColor", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "scaleUpWithAnimationIfNeed", "needAnimation", "scaleDownWithAnimationIfNeed", "buildAnimator", "Landroid/animation/ValueAnimator;", "startRadius", "endRadius", "startColor", "endColor", "startIconColor", "endIconColor", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceCircleButton extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f430644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f430645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f430646c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f430647d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f430648e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Drawable f430649f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f430650g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f430651h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f430652i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f430653j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Paint f430654k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f430655l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f430656m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f430657n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f430658o;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoiceCircleButton f430659a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArgbEvaluator f430660b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f430661c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f430662d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f430663e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f430664f;

        public a(VoiceCircleButton r100, ArgbEvaluator r101, int r102, int r103, int r104, int r105) {
            this.f430659a = r100;
            this.f430660b = r101;
            this.f430661c = r102;
            this.f430662d = r103;
            this.f430663e = r104;
            this.f430664f = r105;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            VoiceCircleButton r101 = this.f430659a;
            Object r102 = r100.getAnimatedValue();
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Float");
            r101.f430655l = ((Float) r102).floatValue();
            float r103 = r100.getAnimatedFraction();
            VoiceCircleButton r104 = this.f430659a;
            Object r105 = this.f430660b.evaluate(r103, Integer.valueOf(this.f430661c), Integer.valueOf(this.f430662d));
            Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.Int");
            r104.f430656m = ((Integer) r105).intValue();
            VoiceCircleButton r106 = this.f430659a;
            Object r107 = this.f430660b.evaluate(r103, Integer.valueOf(this.f430663e), Integer.valueOf(this.f430664f));
            Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type kotlin.Int");
            r106.f430657n = ((Integer) r107).intValue();
            this.f430659a.invalidate();
        }
    }

    public final void c() {
        float r100 = this.f430651h;
        float r101 = this.f430652i;
        if (((Boolean) this.f430658o.getValue()).booleanValue() == false) goto L5;
        int r102 = this.f430645b;
    L6:
        a(r100, r101, r102, this.f430646c, this.f430647d, this.f430648e).start();
        return;
    L5:
        r102 = this.f430644a;
        goto L6
    }

    public final void b(boolean r100) {
        if (r100 == false) goto L8;
        float r101 = this.f430652i;
        float r102 = this.f430651h;
        int r103 = this.f430646c;
        if (((Boolean) this.f430658o.getValue()).booleanValue() == false) goto L6;
        int r104 = this.f430645b;
    L7:
        a(r101, r102, r103, r104, this.f430648e, this.f430647d).start();
        return;
    L6:
        r104 = this.f430644a;
        goto L7
    L8:
        this.f430655l = this.f430651h;
        if (((Boolean) this.f430658o.getValue()).booleanValue() == false) goto L11;
        int r105 = this.f430645b;
    L12:
        this.f430656m = r105;
        this.f430657n = this.f430647d;
        return;
    L11:
        r105 = this.f430644a;
        goto L12
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        float r101 = getWidth() / 2.0f;
        float r102 = getHeight() / 2.0f;
        this.f430654k.setColor(this.f430656m);
        r100.drawCircle(r101, r102, this.f430655l, this.f430654k);
        Drawable r103 = this.f430649f;
        if (r103 == null) goto L5;
        float r104 = (getWidth() / 2.0f) - (this.f430653j / 2.0f);
        float r105 = (getHeight() / 2.0f) - (this.f430653j / 2.0f);
        r100.save();
        r100.rotate(this.f430650g, r100.getWidth() / 2.0f, r100.getHeight() / 2.0f);
        r103.setTint(this.f430657n);
        float r106 = this.f430653j;
        r103.setBounds((int) r104, (int) r105, (int) (r104 + r106), (int) (r105 + r106));
        r103.draw(r100);
        r100.restore();
    L5:
        super.onDraw(r100);
    }

    public VoiceCircleButton(final Context r100, AttributeSet r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "attributeSet");
        super(r100, r110);
        Paint r101 = new Paint(5);
        r101.setStyle(Paint.Style.FILL);
        this.f430654k = r101;
        Lazy r102 = LazyKt.lazy(new VoiceCircleButton$isNightMode$2(r100));
        this.f430658o = r102;
        TypedArray r103 = r100.getTheme().obtainStyledAttributes(r110, new int[]{R.attr.expandedCircleColor, R.attr.expandedIconTintColor, R.attr.expandedRadius, R.attr.iconDrawable, R.attr.iconNonCnDrawable, R.attr.iconRotateAngel, R.attr.iconSize, R.attr.normalCircleColor, R.attr.normalCircleColorDM, R.attr.normalIconTintColor, R.attr.normalRadius}, 0, 0);
        int r111 = r103.getColor(7, FakePickerAvatarCreator.GRAY);     // Catch: Throwable -> L13
        this.f430644a = r111;     // Catch: Throwable -> L13
        int r104 = r103.getColor(8, FakePickerAvatarCreator.GRAY);     // Catch: Throwable -> L13
        this.f430645b = r104;     // Catch: Throwable -> L13
        this.f430646c = r103.getColor(0, -65536);     // Catch: Throwable -> L13
        int r105 = r103.getColor(9, -16777216);     // Catch: Throwable -> L13
        this.f430647d = r105;     // Catch: Throwable -> L13
        this.f430648e = r103.getColor(1, -65536);     // Catch: Throwable -> L13
        Drawable r106 = r103.getDrawable(3);     // Catch: Throwable -> L13
        Drawable r107 = r103.getDrawable(4);     // Catch: Throwable -> L13
        this.f430650g = r103.getFloat(5, 8.0f);     // Catch: Throwable -> L13
        float r108 = r103.getDimension(10, 38.0f);     // Catch: Throwable -> L13
        this.f430651h = r108;     // Catch: Throwable -> L13
        this.f430652i = r103.getDimension(2, 44.0f);     // Catch: Throwable -> L13
        this.f430653j = r103.getDimension(6, 24.0f);     // Catch: Throwable -> L13
        if (KeyboardVoiceModule.a().isZh() == true) goto L7;
        r106 = r107;
    L7:
        this.f430649f = r106;     // Catch: Throwable -> L13
        this.f430655l = r108;     // Catch: Throwable -> L13
        if (((Boolean) r102.getValue()).booleanValue() == false) goto L10;
        r111 = r104;
    L10:
        this.f430656m = r111;     // Catch: Throwable -> L13
        this.f430657n = r105;     // Catch: Throwable -> L13
        r103.recycle();
        return;
    L13:
        th = move-exception;
        r103.recycle();
        throw th;
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = RangesKt.coerceAtMost(View.MeasureSpec.getSize(r100), View.MeasureSpec.getSize(r101));
        setMeasuredDimension(r102, r102);
    }

    public final ValueAnimator a(float r100, float r101, int r110, int r111, int r112, int r113) {
        ArgbEvaluator r102 = new ArgbEvaluator();
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{r100, r101});
        r103.setDuration(200);
        r103.setInterpolator(new AccelerateInterpolator());
        r103.addUpdateListener(new a(this, r102, r110, r111, r112, r113));
        Intrinsics.checkNotNull(r103);
        return r103;
    }
}
