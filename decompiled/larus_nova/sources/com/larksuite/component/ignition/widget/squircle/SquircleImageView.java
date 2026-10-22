package com.larksuite.component.ignition.widget.squircle;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ(\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\nH\u0014J\u0010\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020$2\u0006\u0010*\u001a\u00020+H\u0014J\u0010\u0010-\u001a\u00020$2\u0006\u0010*\u001a\u00020+H\u0002J\u001a\u0010.\u001a\u00020$2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010/\u001a\u00020$H\u0002J\f\u00100\u001a\u00020$*\u00020\u001bH\u0002J\f\u00101\u001a\u00020$*\u00020\u001bH\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R&\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R&\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/larksuite/component/ignition/widget/squircle/SquircleImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "xfermode", "Landroid/graphics/PorterDuffXfermode;", "value", "radius", "getRadius", "()I", "setRadius", "(I)V", "borderWidth", "getBorderWidth", "setBorderWidth", "borderColor", "getBorderColor", "setBorderColor", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint$delegate", "Lkotlin/Lazy;", "rectPath", "Landroid/graphics/Path;", "squirclePath", "onSizeChanged", "", "w", "h", "oldw", "oldh", "draw", "canvas", "Landroid/graphics/Canvas;", "onDraw", "drawBorder", "applyStyle", "ensurePath", "setBorderMode", "setClipMode", "ignition-widget-squircle_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SquircleImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PorterDuffXfermode f284023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f284024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f284025c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f284026d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f284027e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Path f284028f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Path f284029g;

    private final Paint getPaint() {
        return (Paint) this.f284027e.getValue();
    }

    public final void j() {
        this.f284029g.reset();
        Path r100 = this.f284029g;
        Rect r101 = new Rect(0, 0, getWidth(), getHeight());
        int r102 = this.f284024b;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "bounds");
        float r103 = r102;
        float r110 = r103 * 0.29289323f;
        float r111 = r110 * 2;
        float r112 = r103 * 1.057191f;
        float r113 = r103 * 2.0f;
        float r114 = r101.width();
        float r115 = r101.height();
        r100.offset(-r101.left, -r101.top);
        r100.moveTo(0.0f, r113);
        r100.cubicTo(0.0f, r112, 0.0f, r111, r110, r110);
        r100.cubicTo(r111, 0.0f, r112, 0.0f, r113, 0.0f);
        float r104 = r114 - r113;
        r100.lineTo(r104, 0.0f);
        float r116 = r114 - r112;
        float r117 = r114 - r111;
        float r210 = r114 - r110;
        r100.cubicTo(r116, 0.0f, r117, 0.0f, r210, r110);
        r100.cubicTo(r114, r111, r114, r112, r114, r113);
        float r105 = r115 - r113;
        r100.lineTo(r114, r105);
        float r118 = r115 - r112;
        float r211 = r115 - r111;
        float r212 = r115 - r110;
        r100.cubicTo(r114, r118, r114, r211, r210, r212);
        r100.cubicTo(r117, r115, r116, r115, r104, r115);
        r100.lineTo(r113, r115);
        r100.cubicTo(r112, r115, r111, r115, r110, r212);
        r100.cubicTo(0.0f, r211, 0.0f, r118, 0.0f, r105);
        r100.lineTo(0.0f, r113);
        r100.close();
        r100.offset(r101.left, r101.top);
        this.f284028f.reset();
        float r106 = 1;
        this.f284028f.addRect(-1.0f, -1.0f, getWidth() + r106, getHeight() + r106, Path.Direction.CW);
        this.f284028f.op(this.f284029g, Path.Op.DIFFERENCE);
    }

    public final int getBorderColor() {
        return this.f284026d;
    }

    public final int getBorderWidth() {
        return this.f284025c;
    }

    public final int getRadius() {
        return this.f284024b;
    }

    public SquircleImageView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    private final void setBorderMode(Paint r100) {
        r100.setStyle(Paint.Style.STROKE);
        r100.setXfermode(null);
    }

    private final void setClipMode(Paint r100) {
        r100.setStyle(Paint.Style.FILL);
        r100.setXfermode(this.f284023a);
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        int r101 = r100.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null);
        super.draw(r100);
        setClipMode(getPaint());
        r100.drawPath(this.f284028f, getPaint());
        r100.restoreToCount(r101);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        if (this.f284025c <= 0) goto L7;
        setBorderMode(getPaint());
        getPaint().setColor(this.f284026d);
        getPaint().setStrokeWidth(this.f284025c * 2.0f);
        r100.drawPath(this.f284029g, getPaint());
        return;
    }

    public final void setBorderColor(int r100) {
        this.f284026d = r100;
        invalidate();
    }

    public final void setBorderWidth(int r100) {
        this.f284025c = r100;
        invalidate();
    }

    public final void setRadius(int r100) {
        if (r100 == this.f284024b) goto L6;
        j();
        this.f284024b = r100;
        return;
    }

    public SquircleImageView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public SquircleImageView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f284023a = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.f284027e = LazyKt.lazy(SquircleImageView$paint$2.INSTANCE);
        this.f284028f = new Path();
        this.f284029g = new Path();
        TypedArray r103 = getContext().obtainStyledAttributes(r101, new int[]{R.attr.border_color, R.attr.border_width, R.attr.radius}, r102, 0);
        setRadius(r103.getDimensionPixelSize(2, this.f284024b));
        setBorderWidth(r103.getDimensionPixelSize(1, this.f284025c));
        setBorderColor(r103.getColor(0, this.f284026d));
        r103.recycle();
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (r100 != r102) goto L5;
        if (r101 != r103) goto L5;
        return;
    L5:
        j();
    }
}
