package com.larus.bmhome.chat.layout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.c7;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/DeepResearchWebProgressBar;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "paint", "Landroid/graphics/Paint;", "rectF", "Landroid/graphics/RectF;", "progress", "", "maxProgress", "strokeWidth", "progressColor", "backgroundColor", "setProgress", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeepResearchWebProgressBar extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f304804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f304805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f304806c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f304807d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f304808e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f304809f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f304810g;

    public DeepResearchWebProgressBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DeepResearchWebProgressBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        float r101 = getWidth() / 2.0f;
        float r102 = getHeight() / 2.0f;
        float r103 = (RangesKt.coerceAtMost(getWidth(), getHeight()) - this.f304808e) / 2.0f;
        RectF r104 = this.f304805b;
        r104.left = r101 - r103;
        r104.top = r102 - r103;
        r104.right = r101 + r103;
        r104.bottom = r102 + r103;
        this.f304804a.setColor(ContextCompat.getColor(getContext(), this.f304810g));
        this.f304804a.setStrokeWidth(this.f304808e);
        r100.drawArc(this.f304805b, 0.0f, 360.0f, false, this.f304804a);
        this.f304804a.setColor(ContextCompat.getColor(getContext(), this.f304809f));
        r100.drawArc(this.f304805b, 270.0f, (this.f304806c / this.f304807d) * 360.0f, false, this.f304804a);
    }

    public final void setProgress(float r100) {
        this.f304806c = this.f304807d * r100;
        invalidate();
    }

    public DeepResearchWebProgressBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Paint r103 = new Paint(1);
        this.f304804a = r103;
        this.f304805b = new RectF();
        this.f304806c = 75.0f;
        this.f304807d = 100.0f;
        this.f304808e = c7.b(2);
        this.f304809f = v19.c.b(R.attr.larus_neutral_50, null, R.color.larus_neutral_50);
        this.f304810g = v19.c.b(R.attr.larus_neutral_transparent_1, null, R.color.larus_neutral_transparent_1);
        r103.setStyle(Paint.Style.STROKE);
        r103.setStrokeCap(Paint.Cap.ROUND);
    }

    public /* synthetic */ DeepResearchWebProgressBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
