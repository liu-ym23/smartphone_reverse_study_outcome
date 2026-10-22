package com.larksuite.component.universe_design.progress;

import a18.c;
import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.widget.ProgressBar;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0016\u0018\u0000 62\u00020\u0001:\u000256B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\"\u0010\u0018\u001a\u00020\u00192\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0014J\u0018\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\nH\u0014J(\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\nH\u0014J\b\u0010%\u001a\u00020\u0019H\u0002J\u000e\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\nJ\u000e\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\nJ\u000e\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\nJ\u000e\u0010,\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\nJ\u000e\u0010-\u001a\u00020\u00192\u0006\u0010.\u001a\u00020\u000fJ\u0010\u0010/\u001a\u00020\u00192\u0006\u00100\u001a\u00020\nH\u0016J\u0018\u0010/\u001a\u00020\u00192\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u000202H\u0016J\u0010\u00103\u001a\u00020\u00192\u0006\u00104\u001a\u00020\nH\u0002R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/larksuite/component/universe_design/progress/UDProgress;", "Landroid/widget/ProgressBar;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "FLOAT_ZERO", "", "onChangedListener", "Lcom/larksuite/component/universe_design/progress/UDProgress$OnChangeListener;", "getOnChangedListener", "()Lcom/larksuite/component/universe_design/progress/UDProgress$OnChangeListener;", "setOnChangedListener", "(Lcom/larksuite/component/universe_design/progress/UDProgress$OnChangeListener;)V", "progressSpec", "Lcom/larksuite/component/universe_design/progress/UDProgressSpec;", "init", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "resetDrawable", "setType", "type", "setThickness", "thickness", "setTrackColor", "color", "setIndicatorColor", "setIndicatorCornerRadius", "radius", "setProgress", "progress", "animate", "", "animateProgress", "newProgress", "OnChangeListener", "Companion", "universe-ui-progress_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class UDProgress extends ProgressBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f285215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z08.b f285216b;

    public static final class a {
    }

    public interface b {
    }

    static {
    }

    public final b getOnChangedListener() {
        return null;
    }

    public final void setOnChangedListener(b r100) {
    }

    public UDProgress(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        int r101 = r100.save();
        if (getPaddingLeft() == 0) goto L5;
    L6:
        r100.translate(getPaddingLeft(), getPaddingTop());
    L8:
        if (getPaddingRight() == 0) goto L10;
    L11:
        r100.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
    L12:
        getProgressDrawable().draw(r100);
        r100.restoreToCount(r101);
        return;
    L10:
        if (getPaddingBottom() == 0) goto L12;
    L5:
        if (getPaddingTop() == 0) goto L8;
        goto L6
    }

    public final void setIndicatorColor(int r100) {
        z08.b r101 = this.f285216b;
        if (r101.f569641d == r100) goto L6;
        r101.f569641d = r100;
        invalidate();
        return;
    }

    public final void setIndicatorCornerRadius(float r100) {
        if (Math.abs(this.f285216b.f569642e - r100) <= this.f285215a) goto L6;
        this.f285216b.f569642e = r100;
        invalidate();
        return;
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int r100) {
        if (getProgress() == r100) goto L8;
        super.setProgress(r100);
        z08.b r101 = this.f285216b;
        if (r101 == null) goto L9;
        r101.f569643f = r100;
        invalidate();
        return;
    L9:
        return;
    }

    public final void setThickness(int r100) {
        z08.b r101 = this.f285216b;
        if (r101.f569639b == r100) goto L6;
        r101.f569639b = r100;
        requestLayout();
        invalidate();
        return;
    }

    public final void setTrackColor(int r100) {
        z08.b r101 = this.f285216b;
        if (r101.f569640c == r100) goto L6;
        r101.f569640c = r100;
        invalidate();
        return;
    }

    public final void setType(int r100) {
        if (this.f285216b.getType() == r100) goto L17;
        z08.b r101 = this.f285216b;
        if (r100 != 0) goto L7;
        int r102 = 0;
    L8:
        r101.f569638a = r102;
        if (r100 != 1) goto L12;
        r101.f569644g = Math.min(getLayoutParams().width, getLayoutParams().height);
    L12:
        if (this.f285216b.getType() != 0) goto L14;
        Drawable r103 = new a18.b(this.f285216b);
    L15:
        setProgressDrawable(r103);
        requestLayout();
        invalidate();
        return;
    L14:
        r103 = new a18.a(this.f285216b);
        goto L15
    L7:
        r102 = 1;
        goto L8
    }

    public UDProgress(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        Drawable r102 = getProgressDrawable();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.larksuite.component.universe_design.progress.drawable.ProgressDrawable");
        c r103 = (c) r102;
        int r104 = r103.e();
        int r105 = r103.d();
        if (r104 > 0) goto L5;
        int r106 = getMeasuredWidth();
    L6:
        if (r105 > 0) goto L8;
        int r107 = getMeasuredHeight();
    L9:
        setMeasuredDimension(r106, r107);
        return;
    L8:
        r107 = (r105 + getPaddingTop()) + getPaddingBottom();
        goto L9
    L5:
        r106 = (r104 + getPaddingLeft()) + getPaddingRight();
        goto L6
    }

    @Override // android.widget.ProgressBar
    public final void setProgress(int r100, boolean r101) {
        if (getProgress() == r100) goto L12;
        if (r101 == false) goto L10;
        Animation r102 = getAnimation();
        if (r102 == null) goto L8;
        r102.cancel();
    L8:
        ValueAnimator r103 = ValueAnimator.ofInt(new int[]{getProgress(), r100});
        r103.addUpdateListener(new z08.a(this));
        r103.addListener(new com.larksuite.component.universe_design.progress.a(this));
        r103.setDuration(300);
        r103.start();
        return;
    L10:
        setProgress(r100);
        return;
    }

    public UDProgress(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, 0);
        this.f285215a = 0.1f;
        z08.b r103 = new z08.b(0);
        this.f285216b = r103;
        TypedArray r104 = getContext().obtainStyledAttributes(r101, new int[]{R.attr.layout_width, R.attr.layout_height, com.larus.nova.R.attr.ud_progress_indicatorColor, com.larus.nova.R.attr.ud_progress_indicatorCornerRadius, com.larus.nova.R.attr.ud_progress_thickness, com.larus.nova.R.attr.ud_progress_trackColor, com.larus.nova.R.attr.ud_progress_type}, r102, 0);
        r103.f569638a = r104.getInt(6, 0);
        r103.f569639b = r104.getDimensionPixelSize(4, 0);
        r103.f569640c = r104.getColor(5, 0);
        r103.f569641d = r104.getColor(2, 0);
        r103.f569642e = r104.getDimensionPixelSize(3, 0);
        r103.f569643f = getProgress();
        r103.f569644g = Math.min(r104.getLayoutDimension(0, 0), r104.getLayoutDimension(0, 0));
        r104.recycle();
        if (r103.getType() != 0) goto L5;
        Drawable r105 = new a18.b(r103);
    L6:
        setProgressDrawable(r105);
        return;
    L5:
        r105 = new a18.a(r103);
        goto L6
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        int r104 = Math.min(r100, r101);
        z08.b r105 = this.f285216b;
        if (r105.f569644g == r104) goto L8;
        r105.f569644g = r104;
        if (r105.getType() != 1) goto L9;
        requestLayout();
        invalidate();
        return;
    L9:
        return;
    }
}
