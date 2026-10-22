package com.larus.office.base.plugins.toolbar.view;

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
import v19.c;
import v19.c7;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0014J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\tJ\u000e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\rR\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/office/base/plugins/toolbar/view/RoundedView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "color", "", "paint", "Landroid/graphics/Paint;", "showBoard", "", "boardPaint", "rectF", "Landroid/graphics/RectF;", "boardRectF", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setColor", "newColor", "setBoard", "show", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RoundedView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f360974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f360975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f360976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f360977d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f360978e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RectF f360979f;

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
        this.f360978e.set(r103, r104, r105, r106);
        if (r102 <= 0) goto L5;
        float r107 = r102 / 2.0f;
    L6:
        r100.drawRoundRect(this.f360978e, r107, r107, this.f360975b);
        if (this.f360976c == false) goto L12;
        float r108 = this.f360977d.getStrokeWidth() / 2;
        this.f360979f.set(r103 + r108, r104 + r108, r105 - r108, r106 - r108);
        float r109 = r107 - r108;
        if (r109 <= 0.0f) goto L13;
        r100.drawRoundRect(this.f360979f, r109, r109, this.f360977d);
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
        this.f360976c = r100;
        invalidate();
    }

    public final void setColor(int r100) {
        this.f360974a = r100;
        this.f360975b.setColor(r100);
        invalidate();
    }

    public RoundedView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        this.f360974a = -16777216;
        Paint r102 = new Paint(1);
        this.f360975b = r102;
        Paint r103 = new Paint(1);
        this.f360977d = r103;
        this.f360978e = new RectF();
        this.f360979f = new RectF();
        r103.setStyle(Paint.Style.STROKE);
        r103.setColor(c.b(R.attr.larus_neutral_transparent_2, r100, R.color.larus_neutral_transparent_2));
        r103.setStrokeWidth(c7.b(1));
        r102.setColor(this.f360974a);
        r102.setAntiAlias(true);
        r102.setColor(this.f360974a);
        r102.setStyle(Paint.Style.FILL);
    }
}
