package com.obric.assistant.card.layout.viewholder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0007J\u0016\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0013H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/MusicCircularProgressView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "strokeWidth", "", "arcBounds", "Landroid/graphics/RectF;", "trackPaint", "Landroid/graphics/Paint;", "progressPaint", "progress", "setProgress", "", "setColors", "progressColor", "trackColor", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onDetachedFromWindow", "Companion", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MusicCircularProgressView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f386369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f386370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f386371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f386372d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f386373e;

    public static final class a {
    }

    static {
    }

    public MusicCircularProgressView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MusicCircularProgressView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        float r101 = this.f386369a / 2.0f;
        this.f386370b.set(r101, r101, getWidth() - r101, getHeight() - r101);
        r100.drawOval(this.f386370b, this.f386371c);
        r100.drawArc(this.f386370b, -90.0f, (this.f386373e * 360.0f) / 100.0f, false, this.f386372d);
    }

    public final void setProgress(int r100) {
        this.f386373e = RangesKt.coerceIn(r100, 0, 100);
        invalidate();
    }

    public final void a(int r100, int r101) {
        boolean r102 = true;
        if (this.f386372d.getColor() == r100) goto L5;
        this.f386372d.setColor(r100);
        boolean r103 = true;
    L7:
        if (this.f386371c.getColor() == r101) goto L9;
        this.f386371c.setColor(r101);
    L10:
        if (r102 == false) goto L13;
        invalidate();
        return;
    L13:
        return;
    L9:
        r102 = r103;
        goto L10
    L5:
        r103 = false;
        goto L7
    }

    public MusicCircularProgressView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Resources r103 = getResources();
        float r104 = WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).density * 2.0f;
        this.f386369a = r104;
        this.f386370b = new RectF();
        Paint r105 = new Paint(1);
        r105.setStyle(Paint.Style.STROKE);
        r105.setStrokeCap(Paint.Cap.ROUND);
        r105.setStrokeWidth(r104);
        r105.setColor(ColorProtector.parseColor("#1A000000"));
        this.f386371c = r105;
        Paint r106 = new Paint(1);
        r106.setStyle(Paint.Style.STROKE);
        r106.setStrokeCap(Paint.Cap.ROUND);
        r106.setStrokeWidth(r104);
        r106.setColor(ColorProtector.parseColor("#FF000000"));
        this.f386372d = r106;
    }

    public /* synthetic */ MusicCircularProgressView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
