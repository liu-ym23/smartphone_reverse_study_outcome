package com.bytedance.dux.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/dux/widget/RadiusLayout;", "Landroid/widget/FrameLayout;", "", "r", "", "setRadius", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dux_release"}, k = 1, mv = {1, 7, 1})
public class RadiusLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f205924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f205925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f205926c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float[] f205927d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f205928e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Path f205929f;

    public RadiusLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RadiusLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void c(Canvas r100) {
        this.f205928e.set(0.0f, 0.0f, getWidth(), getHeight());
        this.f205929f.reset();
        Path r101 = this.f205929f;
        RectF r102 = this.f205928e;
        float[] r103 = this.f205927d;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("radiusArray");
        r103 = null;
    L5:
        r101.addRoundRect(r102, r103, Path.Direction.CW);
        r100.clipPath(this.f205929f);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        c(r100);
        super.dispatchDraw(r100);
        if (this.f205926c == true) goto L5;
        return;
    L5:
        if (this.f205924a == false) goto L15;
        Paint r101 = this.f205925b;
        if (r101 == null) goto L16;
        this.f205928e.set(0.0f, 0.0f, getWidth(), getHeight());
        this.f205929f.reset();
        Path r102 = this.f205929f;
        RectF r103 = this.f205928e;
        float[] r104 = this.f205927d;
        if (r104 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("radiusArray");
        r104 = null;
    L12:
        r102.addRoundRect(r103, r104, Path.Direction.CW);
        r100.drawPath(this.f205929f, r101);
        return;
    L16:
        return;
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        c(r100);
        super.draw(r100);
    }

    public final void setRadius(float r100) {
        this.f205927d = new float[]{r100, r100, r100, r100, r100, r100, r100, r100};
        invalidate();
    }

    public RadiusLayout(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        boolean r100 = true;
        this.f205924a = true;
        this.f205928e = new RectF();
        this.f205929f = new Path();
        TypedArray r113 = r110.obtainStyledAttributes(r111, new int[]{R.attr.cornerRadius, R.attr.cornerRadiusLeftBottom, R.attr.cornerRadiusLeftTop, R.attr.cornerRadiusRightBottom, R.attr.cornerRadiusRightTop, R.attr.radiusStrokeColor, R.attr.radiusStrokeDashGapWidth, R.attr.radiusStrokeDashWidth, R.attr.radiusStrokeWidth}, r112, 0);
        float r114 = r113.getDimension(0, 0.0f);
        float r101 = r113.getDimension(2, r114);
        float r102 = r113.getDimension(4, r114);
        float r103 = r113.getDimension(1, r114);
        float r115 = r113.getDimension(3, r114);
        int r104 = r113.getColor(5, -16777216);
        int r105 = r113.getDimensionPixelOffset(8, 0);
        int r106 = r113.getDimensionPixelOffset(7, 0);
        int r116 = r113.getDimensionPixelOffset(6, 0);
        d(r101, r102, r103, r115);
        Paint r117 = new Paint();
        r117.setAntiAlias(true);
        r117.setColor(r104);
        r117.setStyle(Paint.Style.STROKE);
        if (r106 == 0) goto L6;
        if (r116 == 0) goto L6;
        r117.setPathEffect(new DashPathEffect(new float[]{r106, r116}, 0.0f));
    L6:
        r117.setStrokeWidth(r105);
        this.f205925b = r117;
        if ((r104 & (-16777216)) == 0) goto L10;
        if (r105 == 0) goto L10;
    L11:
        this.f205926c = r100;
        invalidate();
        r113.recycle();
        return;
    L10:
        r100 = false;
        goto L11
    }

    public /* synthetic */ RadiusLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void d(float r100, float r101, float r102, float r103) {
        this.f205927d = new float[]{r100, r100, r101, r101, r103, r103, r102, r102};
        invalidate();
    }
}
