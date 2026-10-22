package com.larus.common_ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u0018\u001a\u00020\u00142\b\b\u0001\u0010\u0019\u001a\u00020\u0007J\u0010\u0010\u001a\u001a\u00020\u00142\b\b\u0001\u0010\u0019\u001a\u00020\u0007J\u000e\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u000eR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/larus/common_ui/widget/CustomCircularProgressBar;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "progressPaint", "Landroid/graphics/Paint;", "backgroundPaint", "progress", "", "maxProgress", "progressWidth", "progressRect", "Landroid/graphics/RectF;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setProgress", "setProgressColor", "color", "setProgressBackgroundColor", "setProgressWidth", "width", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomCircularProgressBar extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f328426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f328427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f328428c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f328429d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f328430e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RectF f328431f;

    public CustomCircularProgressBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CustomCircularProgressBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        float r101 = Math.min(getWidth(), getHeight()) - this.f328430e;
        float r102 = getWidth() / 2.0f;
        float r103 = getHeight() / 2.0f;
        float r104 = r101 / 2.0f;
        this.f328431f.set(r102 - r104, r103 - r104, r102 + r104, r103 + r104);
        r100.drawOval(this.f328431f, this.f328427b);
        r100.drawArc(this.f328431f, -90.0f, (360 * this.f328428c) / this.f328429d, false, this.f328426a);
    }

    public final void setProgress(float r100) {
        this.f328428c = RangesKt.coerceIn(r100, 0.0f, this.f328429d);
        invalidate();
    }

    public final void setProgressBackgroundColor(int r100) {
        this.f328427b.setColor(r100);
        invalidate();
    }

    public final void setProgressColor(int r100) {
        this.f328426a.setColor(r100);
        invalidate();
    }

    public final void setProgressWidth(float r100) {
        this.f328430e = r100;
        this.f328426a.setStrokeWidth(r100);
        this.f328427b.setStrokeWidth(r100);
        invalidate();
    }

    public CustomCircularProgressBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Paint r103 = new Paint(1);
        this.f328426a = r103;
        Paint r104 = new Paint(1);
        this.f328427b = r104;
        this.f328428c = 20.0f;
        this.f328429d = 100.0f;
        this.f328430e = 10.0f;
        this.f328431f = new RectF();
        TypedArray r105 = r100.getTheme().obtainStyledAttributes(r101, new int[]{R.attr.larus_progressBackgroundColor, R.attr.larus_progressColor, R.attr.larus_progressWidth}, 0, 0);
        this.f328430e = r105.getDimension(2, this.f328430e);     // Catch: Throwable -> L6
        r103.setColor(r105.getColor(1, -16744448));     // Catch: Throwable -> L6
        r104.setColor(r105.getColor(0, FakePickerAvatarCreator.GREEN));     // Catch: Throwable -> L6
        r105.recycle();
        r103.setStyle(Paint.Style.STROKE);
        r103.setStrokeWidth(this.f328430e);
        r104.setStyle(Paint.Style.STROKE);
        r104.setStrokeWidth(this.f328430e);
        return;
    L6:
        th = move-exception;
        r105.recycle();
        throw th;
    }

    public /* synthetic */ CustomCircularProgressBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
