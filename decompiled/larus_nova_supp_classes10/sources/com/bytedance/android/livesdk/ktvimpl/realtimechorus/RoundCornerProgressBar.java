package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010R*\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/RoundCornerProgressBar;", "Landroid/view/View;", "", "value", "b", "F", "getProgress", "()F", "setProgress", "(F)V", "progress", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RoundCornerProgressBar extends View {
    public final Paint a;
    public float b;
    public final RectF c;
    public final Path d;
    public final int e;

    public final float getProgress() {
        return this.b;
    }

    public RoundCornerProgressBar(Context r2) {
        this(r2, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r9) {
        Intrinsics.checkNotNullParameter(r9, "canvas");
        super.onDraw(r9);
        float r5 = 2;
        this.c.set(this.a.getStrokeWidth() / r5, this.a.getStrokeWidth() / r5, getWidth() - (this.a.getStrokeWidth() / r5), getHeight() - (this.a.getStrokeWidth() / r5));
        Path r0 = this.d;
        RectF r1 = this.c;
        int r2 = this.e;
        r0.addRoundRect(r1, r2, r2, Path.Direction.CW);
        float r3 = new PathMeasure(this.d, false).getLength();
        this.a.setPathEffect(new DashPathEffect(new float[]{(this.b * r3) / 100, r3}, 0.0f));
        r9.drawPath(this.d, this.a);
    }

    public final void setProgress(float r3) {
        this.b = RangesKt.coerceIn(r3, 0.0f, 100.0f);
        invalidate();
    }

    public RoundCornerProgressBar(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        Paint r4 = new Paint();
        this.a = r4;
        this.c = new RectF();
        this.d = new Path();
        this.e = s1.f(45.0f);
        r4.setColor(-1);
        r4.setStyle(Paint.Style.STROKE);
        r4.setAntiAlias(true);
        r4.setStrokeWidth(s1.f(2.0f));
    }
}
