package com.larus.bmhome.taskskill.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.core.content.ContextCompat;
import com.facebook.keyframes.model.KFFeatureEffect;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 *2\u00020\u0001:\u0001*B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001a\u001a\u00020\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u001bH\u0014J\u0018\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u0007H\u0014J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u0007H\u0014J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#H\u0014J\u0018\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0002J\b\u0010'\u001a\u00020\u001bH\u0002J\b\u0010(\u001a\u00020\u001bH\u0002J\b\u0010)\u001a\u00020\u001bH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/larus/bmhome/taskskill/ui/PcDeviceAuthorizingLoadingView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "arcRect", "Landroid/graphics/RectF;", "paint", "Landroid/graphics/Paint;", "gradientColors", "", "animator", "Landroid/animation/ValueAnimator;", KFFeatureEffect.GRADIENT_JSON_FIELD, "Landroid/graphics/SweepGradient;", "gradientCenterX", "", "gradientCenterY", "rotationDegrees", "attached", "", "onAttachedToWindow", "", "onDetachedFromWindow", "onVisibilityChanged", "changedView", RemoteMessageConst.Notification.VISIBILITY, "onWindowVisibilityChanged", "onDraw", "canvas", "Landroid/graphics/Canvas;", "getGradient", "centerX", "centerY", "updateAnimationState", "startAnimation", "stopAnimation", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PcDeviceAuthorizingLoadingView extends View {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final float[] f314516j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f314517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f314518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f314519c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ValueAnimator f314520d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SweepGradient f314521e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f314522f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f314523g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f314524h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f314525i;

    public static final class a {
    }

    public PcDeviceAuthorizingLoadingView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PcDeviceAuthorizingLoadingView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        this.f314525i = false;
        ValueAnimator r100 = this.f314520d;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f314520d = null;
        this.f314524h = 0.0f;
        super.onDetachedFromWindow();
    }

    static {
        f314516j = new float[]{0.0f, 0.38f, 0.78f, 1.0f};
    }

    public final void a() {
        if (this.f314525i == true) goto L5;
    L17:
        ValueAnimator r100 = this.f314520d;
        if (r100 == null) goto L20;
        r100.cancel();
    L20:
        this.f314520d = null;
        this.f314524h = 0.0f;
        return;
    L5:
        if (getVisibility() != 0) goto L17;
        if (getWindowVisibility() != 0) goto L17;
        ValueAnimator r101 = this.f314520d;
        if (r101 == null) goto L13;
        boolean r102 = true;
        if (r101.isRunning() != true) goto L13;
    L14:
        if (r102 == true) goto L23;
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{0.0f, 360.0f});
        r103.setDuration(750);
        r103.setInterpolator(new LinearInterpolator());
        r103.setRepeatCount(-1);
        r103.addUpdateListener(new d(this));
        r103.start();
        this.f314520d = r103;
        return;
    L23:
        return;
    L13:
        r102 = false;
        goto L14
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f314525i = true;
        a();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        float r100 = Math.min(getWidth(), getHeight());
        if (r100 > 0.0f) goto L5;
        return;
    L5:
        float r101 = getWidth() / 2.0f;
        float r102 = getHeight() / 2.0f;
        float r103 = 0.2f * r100;
        float r104 = ((r100 - r103) / 2.0f) - (r100 * 0.06f);
        if (r104 > 0.0f) goto L8;
        return;
    L8:
        this.f314518b.setStrokeWidth(r103);
        Paint r105 = this.f314518b;
        SweepGradient r106 = this.f314521e;
        if (r106 == null) goto L20;
        boolean r107 = false;
        if (this.f314522f != r101) goto L13;
        boolean r108 = true;
    L14:
        if (r108 == false) goto L20;
        if (this.f314523g != r102) goto L18;
        r107 = true;
    L18:
        if (r107 == false) goto L20;
    L21:
        r105.setShader(r106);
        this.f314517a.set(r101 - r104, r102 - r104, r101 + r104, r104 + r102);
        r110.save();
        r110.rotate(this.f314524h, r101, r102);
        r110.drawArc(this.f314517a, 0.0f, 260.0f, false, this.f314518b);
        r110.restore();
        return;
    L13:
        r108 = false;
    L20:
        r106 = new SweepGradient(r101, r102, this.f314519c, f314516j);
        this.f314521e = r106;
        this.f314522f = r101;
        this.f314523g = r102;
        goto L21
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r100) {
        super.onWindowVisibilityChanged(r100);
        a();
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "changedView");
        super.onVisibilityChanged(r100, r101);
        a();
    }

    public PcDeviceAuthorizingLoadingView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f314517a = new RectF();
        Paint r103 = new Paint(1);
        r103.setStyle(Paint.Style.STROKE);
        r103.setStrokeCap(Paint.Cap.ROUND);
        this.f314518b = r103;
        this.f314519c = new int[]{ContextCompat.getColor(r100, v19.c.b(R.attr.larus_neutral_transparent_2, r100, R.color.larus_neutral_transparent_2)), ContextCompat.getColor(r100, v19.c.b(R.attr.larus_neutral_30, r100, R.color.larus_neutral_30)), ContextCompat.getColor(r100, v19.c.b(R.attr.larus_neutral_70, r100, R.color.larus_neutral_70)), ContextCompat.getColor(r100, v19.c.b(R.attr.larus_neutral_transparent_2, r100, R.color.larus_neutral_transparent_2))};
    }

    public /* synthetic */ PcDeviceAuthorizingLoadingView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
