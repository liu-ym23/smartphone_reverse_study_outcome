package com.larus.dora.impl.device.settings.lab.headdown;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0014R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/larus/dora/impl/device/settings/lab/headdown/HeadDownCircularProgressView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "strokeWidth", "", "arcBounds", "Landroid/graphics/RectF;", "trackPaint", "Landroid/graphics/Paint;", "progressPaint", "value", "", "progress", "getProgress", "()I", "setProgress", "(I)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HeadDownCircularProgressView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f334759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f334760b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f334761c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f334762d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f334763e;

    public final int getProgress() {
        return this.f334763e;
    }

    public HeadDownCircularProgressView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        float r100 = this.f334759a / 2.0f;
        this.f334760b.set(r100, r100, getWidth() - r100, getHeight() - r100);
        r110.drawArc(this.f334760b, -90.0f, 360.0f, false, this.f334761c);
        int r101 = this.f334763e;
        if (r101 <= 0) goto L6;
        r110.drawArc(this.f334760b, -90.0f, (r101 * 360.0f) / 100.0f, false, this.f334762d);
        return;
    }

    public final void setProgress(int r100) {
        int r101 = RangesKt.coerceIn(r100, 0, 100);
        if (this.f334763e != r101) goto L5;
        return;
    L5:
        this.f334763e = r101;
        invalidate();
    }

    public HeadDownCircularProgressView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        float r102 = getResources().getDimension(R.dimen.larus_dp_10);
        this.f334759a = r102;
        this.f334760b = new RectF();
        Paint r103 = new Paint(1);
        r103.setStyle(Paint.Style.STROKE);
        r103.setStrokeCap(Paint.Cap.ROUND);
        r103.setStrokeWidth(r102);
        r103.setColor(v19.c.a(R.attr.larus_neutral_30, r100, R.color.larus_neutral_30));
        this.f334761c = r103;
        Paint r104 = new Paint(1);
        r104.setStyle(Paint.Style.STROKE);
        r104.setStrokeCap(Paint.Cap.ROUND);
        r104.setStrokeWidth(r102);
        r104.setColor(v19.c.a(R.attr.larus_primary_50, r100, R.color.larus_primary_50));
        this.f334762d = r104;
    }
}
