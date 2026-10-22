package com.bytedance.ee.bear.bitable.card.view.stage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.byted.cast.common.CastMonitor;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB-\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ0\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u0002012\u0006\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020\n2\u0006\u0010@\u001a\u00020\n2\u0006\u0010A\u001a\u00020\nH\u0014J\u0010\u0010B\u001a\u00020<2\u0006\u0010C\u001a\u00020DH\u0014J\u0016\u0010E\u001a\u00020<2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000201J\u0010\u0010F\u001a\u00020<2\b\b\u0001\u0010G\u001a\u00020\nJ\u0010\u0010H\u001a\u00020<2\b\b\u0001\u0010G\u001a\u00020\nR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001d\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0017X\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010#\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0015\u001a\u0004\b$\u0010\u001bR\u000e\u0010&\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0017X\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010*\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0015\u001a\u0004\b+\u0010\u001bR\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00103\u001a\u0002048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u0010\u0015\u001a\u0004\b5\u00106R\u001b\u00108\u001a\u0002048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010\u0015\u001a\u0004\b9\u00106¨\u0006I"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/stage/StageStepView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "viewportWidth", "", "viewportHeight", "borderWidth", "getBorderWidth", "()F", "borderWidth$delegate", "Lkotlin/Lazy;", "leftPathData", "", "leftPathConst", "Landroid/graphics/Path;", "getLeftPathConst", "()Landroid/graphics/Path;", "leftPathConst$delegate", "leftPath", "leftPathBounds", "Landroid/graphics/RectF;", "leftPathPoint", "Landroid/graphics/PointF;", "rightPathData", "rightPathConst", "getRightPathConst", "rightPathConst$delegate", "rightPath", "rightPathBounds", "rightPathPoint", "edgePathData", "edgePathConst", "getEdgePathConst", "edgePathConst$delegate", "pathMatrix", "Landroid/graphics/Matrix;", "contentRect", "isFirst", "", "isLast", "contentPaint", "Landroid/graphics/Paint;", "getContentPaint", "()Landroid/graphics/Paint;", "contentPaint$delegate", "borderPaint", "getBorderPaint", "borderPaint$delegate", "onLayout", "", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "left", "top", "right", "bottom", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setMode", "setContentColor", "color", "setBorderColor", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StageStepView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f208693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f208694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f208695c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f208696d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f208697e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Path f208698f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RectF f208699g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PointF f208700h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f208701i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f208702j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Path f208703k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final RectF f208704l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final PointF f208705m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f208706n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f208707o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Matrix f208708p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final RectF f208709q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f208710r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f208711s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f208712t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f208713u;

    private final Paint getBorderPaint() {
        return (Paint) this.f208713u.getValue();
    }

    private final float getBorderWidth() {
        return ((Number) this.f208695c.getValue()).floatValue();
    }

    private final Paint getContentPaint() {
        return (Paint) this.f208712t.getValue();
    }

    private final Path getEdgePathConst() {
        return (Path) this.f208707o.getValue();
    }

    private final Path getLeftPathConst() {
        return (Path) this.f208697e.getValue();
    }

    private final Path getRightPathConst() {
        return (Path) this.f208702j.getValue();
    }

    public StageStepView(Context r100) {
        super(r100);
        this.f208693a = 24.0f;
        this.f208694b = 36.0f;
        this.f208695c = LazyKt.lazy(StageStepView$borderWidth$2.INSTANCE);
        this.f208696d = "M.71 4.61C.06 2.907-.266 2.055-.049 1.385A2 2 0 0 1 .602.44C1.15 0 2.062 0 3.886 0h20.132l-.05 36H3.886c-1.824 0-2.736 0-3.284-.441a2 2 0 0 1-.65-.943c-.217-.67.108-1.522.757-3.227L5.58 18.605c.094-.246.141-.369.155-.496a1 1 0 0 0 0-.218c-.014-.127-.06-.25-.155-.496L.71 4.61z";
        this.f208697e = LazyKt.lazy(new StageStepView$leftPathConst$2(this));
        this.f208698f = new Path();
        this.f208699g = new RectF();
        this.f208700h = new PointF();
        this.f208701i = "M.005.015L14.877 0c.93 0 1.394 0 1.785.176a2 2 0 0 1 .593.408c.303.303.47.737.8 1.605l5.793 15.206c.094.246.14.369.155.496a.993.993 0 0 1 0 .218c-.014.127-.06.25-.155.496l-5.793 15.206c-.33.868-.497 1.302-.8 1.605-.17.17-.372.309-.593.408-.39.176-.856.176-1.785.176H0L.005.015z";
        this.f208702j = LazyKt.lazy(new StageStepView$rightPathConst$2(this));
        this.f208703k = new Path();
        this.f208704l = new RectF();
        this.f208705m = new PointF();
        this.f208706n = "M0 10.2c0-3.928 0-5.892.884-7.335A6 6 0 0 1 2.865.885C4.308 0 6.272 0 10.2 0l13.798-.014L24.013 36H10.2c-3.928 0-5.892 0-7.335-.884a6 6 0 0 1-1.98-1.981C0 31.692 0 29.728 0 25.8V10.2z";
        this.f208707o = LazyKt.lazy(new StageStepView$edgePathConst$2(this));
        this.f208708p = new Matrix();
        this.f208709q = new RectF();
        this.f208712t = LazyKt.lazy(StageStepView$contentPaint$2.INSTANCE);
        this.f208713u = LazyKt.lazy(new StageStepView$borderPaint$2(this));
    }

    public static final /* synthetic */ float a(StageStepView r100) {
        return r100.getBorderWidth();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        r100.save();
        PointF r101 = this.f208700h;
        r100.translate(r101.x, r101.y);
        r100.drawPath(this.f208698f, getContentPaint());
        r100.drawPath(this.f208698f, getBorderPaint());
        r100.restore();
        r100.save();
        PointF r102 = this.f208705m;
        r100.translate(r102.x, r102.y);
        r100.drawPath(this.f208703k, getContentPaint());
        r100.drawPath(this.f208703k, getBorderPaint());
        r100.restore();
        RectF r103 = this.f208709q;
        r100.drawRect(r103.left, r103.top, r103.right, r103.bottom, getContentPaint());
        RectF r104 = this.f208709q;
        float r105 = r104.left;
        float r106 = r104.top;
        r100.drawLine(r105, r106, r104.right, r106, getBorderPaint());
        RectF r107 = this.f208709q;
        float r108 = r107.left;
        float r109 = r107.bottom;
        r100.drawLine(r108, r109, r107.right, r109, getBorderPaint());
    }

    public final void setBorderColor(int r100) {
        getBorderPaint().setColor(r100);
        invalidate();
    }

    public final void setContentColor(int r100) {
        getContentPaint().setColor(r100);
        invalidate();
    }

    public StageStepView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f208693a = 24.0f;
        this.f208694b = 36.0f;
        this.f208695c = LazyKt.lazy(StageStepView$borderWidth$2.INSTANCE);
        this.f208696d = "M.71 4.61C.06 2.907-.266 2.055-.049 1.385A2 2 0 0 1 .602.44C1.15 0 2.062 0 3.886 0h20.132l-.05 36H3.886c-1.824 0-2.736 0-3.284-.441a2 2 0 0 1-.65-.943c-.217-.67.108-1.522.757-3.227L5.58 18.605c.094-.246.141-.369.155-.496a1 1 0 0 0 0-.218c-.014-.127-.06-.25-.155-.496L.71 4.61z";
        this.f208697e = LazyKt.lazy(new StageStepView$leftPathConst$2(this));
        this.f208698f = new Path();
        this.f208699g = new RectF();
        this.f208700h = new PointF();
        this.f208701i = "M.005.015L14.877 0c.93 0 1.394 0 1.785.176a2 2 0 0 1 .593.408c.303.303.47.737.8 1.605l5.793 15.206c.094.246.14.369.155.496a.993.993 0 0 1 0 .218c-.014.127-.06.25-.155.496l-5.793 15.206c-.33.868-.497 1.302-.8 1.605-.17.17-.372.309-.593.408-.39.176-.856.176-1.785.176H0L.005.015z";
        this.f208702j = LazyKt.lazy(new StageStepView$rightPathConst$2(this));
        this.f208703k = new Path();
        this.f208704l = new RectF();
        this.f208705m = new PointF();
        this.f208706n = "M0 10.2c0-3.928 0-5.892.884-7.335A6 6 0 0 1 2.865.885C4.308 0 6.272 0 10.2 0l13.798-.014L24.013 36H10.2c-3.928 0-5.892 0-7.335-.884a6 6 0 0 1-1.98-1.981C0 31.692 0 29.728 0 25.8V10.2z";
        this.f208707o = LazyKt.lazy(new StageStepView$edgePathConst$2(this));
        this.f208708p = new Matrix();
        this.f208709q = new RectF();
        this.f208712t = LazyKt.lazy(StageStepView$contentPaint$2.INSTANCE);
        this.f208713u = LazyKt.lazy(new StageStepView$borderPaint$2(this));
    }

    public StageStepView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f208693a = 24.0f;
        this.f208694b = 36.0f;
        this.f208695c = LazyKt.lazy(StageStepView$borderWidth$2.INSTANCE);
        this.f208696d = "M.71 4.61C.06 2.907-.266 2.055-.049 1.385A2 2 0 0 1 .602.44C1.15 0 2.062 0 3.886 0h20.132l-.05 36H3.886c-1.824 0-2.736 0-3.284-.441a2 2 0 0 1-.65-.943c-.217-.67.108-1.522.757-3.227L5.58 18.605c.094-.246.141-.369.155-.496a1 1 0 0 0 0-.218c-.014-.127-.06-.25-.155-.496L.71 4.61z";
        this.f208697e = LazyKt.lazy(new StageStepView$leftPathConst$2(this));
        this.f208698f = new Path();
        this.f208699g = new RectF();
        this.f208700h = new PointF();
        this.f208701i = "M.005.015L14.877 0c.93 0 1.394 0 1.785.176a2 2 0 0 1 .593.408c.303.303.47.737.8 1.605l5.793 15.206c.094.246.14.369.155.496a.993.993 0 0 1 0 .218c-.014.127-.06.25-.155.496l-5.793 15.206c-.33.868-.497 1.302-.8 1.605-.17.17-.372.309-.593.408-.39.176-.856.176-1.785.176H0L.005.015z";
        this.f208702j = LazyKt.lazy(new StageStepView$rightPathConst$2(this));
        this.f208703k = new Path();
        this.f208704l = new RectF();
        this.f208705m = new PointF();
        this.f208706n = "M0 10.2c0-3.928 0-5.892.884-7.335A6 6 0 0 1 2.865.885C4.308 0 6.272 0 10.2 0l13.798-.014L24.013 36H10.2c-3.928 0-5.892 0-7.335-.884a6 6 0 0 1-1.98-1.981C0 31.692 0 29.728 0 25.8V10.2z";
        this.f208707o = LazyKt.lazy(new StageStepView$edgePathConst$2(this));
        this.f208708p = new Matrix();
        this.f208709q = new RectF();
        this.f208712t = LazyKt.lazy(StageStepView$contentPaint$2.INSTANCE);
        this.f208713u = LazyKt.lazy(new StageStepView$borderPaint$2(this));
    }

    @Override // android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        float r105 = ((getHeight() - getPaddingTop()) - getPaddingBottom()) / this.f208694b;
        this.f208698f.reset();
        this.f208708p.reset();
        this.f208708p.postScale(r105, r105, 0.0f, 0.0f);
        if (this.f208710r == false) goto L5;
        this.f208698f.addPath(getEdgePathConst());
    L6:
        this.f208698f.transform(this.f208708p);
        this.f208698f.computeBounds(this.f208699g, true);
        float r106 = 2;
        this.f208700h.set(getPaddingLeft(), getPaddingTop() + ((((getHeight() - getPaddingTop()) - getPaddingBottom()) - this.f208699g.height()) / r106));
        this.f208703k.reset();
        this.f208708p.reset();
        if (this.f208711s == false) goto L9;
        this.f208703k.addPath(getEdgePathConst());
        Matrix r107 = this.f208708p;
        r107.postRotate(180.0f, this.f208693a / r106, this.f208694b / r106);
        r107.postScale(r105, r105, 0.0f, 0.0f);
    L10:
        this.f208703k.transform(this.f208708p);
        this.f208703k.computeBounds(this.f208704l, true);
        this.f208705m.set((getWidth() - getPaddingRight()) - this.f208704l.width(), this.f208700h.y);
        this.f208709q.set((getPaddingLeft() + this.f208699g.width()) - getBorderWidth(), getPaddingTop(), ((getWidth() - getPaddingRight()) - this.f208704l.width()) + getBorderWidth(), getHeight() - getPaddingBottom());
        return;
    L9:
        this.f208703k.addPath(getRightPathConst());
        this.f208708p.postScale(r105, r105, 0.0f, 0.0f);
        goto L10
    L5:
        this.f208698f.addPath(getLeftPathConst());
        goto L6
    }
}
