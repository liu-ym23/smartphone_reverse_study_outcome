package com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker;

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

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0014J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\tJ\u000e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\rR\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/RoundedView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "color", "", "paint", "Landroid/graphics/Paint;", "showBoard", "", "boardPaint", "rectF", "Landroid/graphics/RectF;", "boardRectF", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setColor", "newColor", "setBoard", "show", "docs-slide_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RoundedView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f238650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f238651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f238652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f238653d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f238654e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RectF f238655f;

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        int r101 = getWidth();
        int r102 = getHeight();
        float r103 = getPaddingLeft();
        float r104 = getPaddingTop();
        float r105 = r101 - getPaddingRight();
        float r106 = r102 - getPaddingBottom();
        this.f238654e.set(r103, r104, r105, r106);
        if (r102 <= 0) goto L5;
        float r107 = r102 / 2.0f;
    L6:
        r100.drawRoundRect(this.f238654e, r107, r107, this.f238651b);
        if (this.f238652c == false) goto L12;
        float r108 = this.f238653d.getStrokeWidth() / 2;
        this.f238655f.set(r103 + r108, r104 + r108, r105 - r108, r106 - r108);
        float r109 = r107 - r108;
        if (r109 <= 0.0f) goto L13;
        r100.drawRoundRect(this.f238655f, r109, r109, this.f238653d);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r107 = 0.0f;
        goto L6
    }

    public final void setBoard(boolean r100) {
        this.f238652c = r100;
        invalidate();
    }

    public final void setColor(int r100) {
        this.f238650a = r100;
        this.f238651b.setColor(r100);
        invalidate();
    }

    public RoundedView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        this.f238650a = -16777216;
        Paint r102 = new Paint(1);
        this.f238651b = r102;
        Paint r103 = new Paint(1);
        this.f238653d = r103;
        this.f238654e = new RectF();
        this.f238655f = new RectF();
        r103.setStyle(Paint.Style.STROKE);
        r103.setColor(ContextCompat.getColor(r100, R.color.neutral_transparent_2));
        r103.setStrokeWidth(xo5.a.a(1.0f));
        r102.setColor(this.f238650a);
        r102.setAntiAlias(true);
        r102.setColor(this.f238650a);
        r102.setStyle(Paint.Style.FILL);
    }
}
