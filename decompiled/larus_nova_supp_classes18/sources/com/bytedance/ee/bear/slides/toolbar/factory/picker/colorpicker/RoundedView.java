package com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0014J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\tJ\u000e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\rR\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/RoundedView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "color", "", "paint", "Landroid/graphics/Paint;", "showBoard", "", "boardPaint", "rectF", "Landroid/graphics/RectF;", "boardRectF", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setColor", "newColor", "setBoard", "show", "docs-slide_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RoundedView extends View {
    public int a;
    public final Paint b;
    public boolean c;
    public final Paint d;
    public final RectF e;
    public final RectF f;

    @Override // android.view.View
    public final void onDraw(Canvas r9) {
        Intrinsics.checkNotNullParameter(r9, "canvas");
        super.onDraw(r9);
        int r0 = getWidth();
        int r1 = getHeight();
        float r2 = getPaddingLeft();
        float r3 = getPaddingTop();
        float r4 = r0 - getPaddingRight();
        float r5 = r1 - getPaddingBottom();
        this.e.set(r2, r3, r4, r5);
        if (r1 <= 0) goto L5;
        float r6 = r1 / 2.0f;
    L6:
        r9.drawRoundRect(this.e, r6, r6, this.b);
        if (this.c == false) goto L12;
        float r7 = this.d.getStrokeWidth() / 2;
        this.f.set(r2 + r7, r3 + r7, r4 - r7, r5 - r7);
        float r8 = r6 - r7;
        if (r8 <= 0.0f) goto L13;
        r9.drawRoundRect(this.f, r8, r8, this.d);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r6 = 0.0f;
        goto L6
    }

    public final void setBoard(boolean r1) {
        this.c = r1;
        invalidate();
    }

    public final void setColor(int r2) {
        this.a = r2;
        this.b.setColor(r2);
        invalidate();
    }

    public RoundedView(Context r4, AttributeSet r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "attrs");
        super(r4, r5);
        this.a = -16777216;
        Paint r6 = new Paint(1);
        this.b = r6;
        Paint r1 = new Paint(1);
        this.d = r1;
        this.e = new RectF();
        this.f = new RectF();
        r1.setStyle(Paint.Style.STROKE);
        r1.setColor(ContextCompat.getColor(r4, 2131103686));
        r1.setStrokeWidth(xo5.a.a(1.0f));
        r6.setColor(this.a);
        r6.setAntiAlias(true);
        r6.setColor(this.a);
        r6.setStyle(Paint.Style.FILL);
    }
}
