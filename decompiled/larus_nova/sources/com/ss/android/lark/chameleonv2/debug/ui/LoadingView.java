package com.ss.android.lark.chameleonv2.debug.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\nH\u0014J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0015H\u0002J\u0006\u0010\u001c\u001a\u00020\u0015J\u0006\u0010\u001d\u001a\u00020\u0015J \u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$H\u0002R\u000e\u0010\f\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/ss/android/lark/chameleonv2/debug/ui/LoadingView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "maxColor", "degree360", "mWidth", "", "mPadding", "startAngle", "mPaint", "Landroid/graphics/Paint;", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "initPaint", "startAnim", "stopAnim", "valueAnimator", "Landroid/animation/ValueAnimator;", "startViewAnim", "startF", "endF", "time", "", "chameleon-debug_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LoadingView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f411415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f411416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f411417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f411418d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f411419e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Paint f411420f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ValueAnimator f411421g;

    public LoadingView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        Paint r100 = this.f411420f;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mPaint");
        r100 = null;
    L5:
        int r101 = this.f411415a;
        r100.setColor(Color.argb(100, r101, r101, r101));
        float r102 = this.f411417c;
        float r103 = 2;
        float r104 = r102 / r103;
        float r105 = r102 / r103;
        float r106 = (r102 / r103) - this.f411418d;
        Paint r107 = this.f411420f;
        if (r107 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mPaint");
        r107 = null;
    L8:
        r110.drawCircle(r104, r105, r106, r107);
        Paint r108 = this.f411420f;
        if (r108 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mPaint");
        r108 = null;
    L11:
        r108.setColor(-1);
        float r109 = this.f411418d;
        float r111 = this.f411417c;
        RectF r112 = new RectF(r109, r109, r111 - r109, r111 - r109);
        float r113 = this.f411419e;
        Paint r114 = this.f411420f;
        if (r114 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mPaint");
        Paint r115 = null;
    L15:
        r110.drawArc(r112, r113, 100.0f, false, r115);
        return;
    L14:
        r115 = r114;
        goto L15
    }

    public LoadingView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (getMeasuredWidth() <= getMeasuredHeight()) goto L5;
        int r102 = getMeasuredHeight();
    L6:
        this.f411417c = r102;
        this.f411418d = 5.0f;
        return;
    L5:
        r102 = getMeasuredWidth();
        goto L6
    }

    public LoadingView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f411415a = 255;
        this.f411416b = 360;
        Paint r103 = new Paint();
        r103.setAntiAlias(true);
        r103.setStyle(Paint.Style.STROKE);
        r103.setColor(-1);
        r103.setStrokeWidth(8.0f);
        this.f411420f = r103;
    }
}
