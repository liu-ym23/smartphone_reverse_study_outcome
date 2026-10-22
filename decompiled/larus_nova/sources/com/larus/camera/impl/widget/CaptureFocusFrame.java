package com.larus.camera.impl.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableKt;
import com.byted.cast.common.CastMonitor;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 .2\u00020\u0001:\u0001.B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u0012H\u0016J0\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u0010H\u0014J\u000e\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\u0010J\u0016\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020$J\b\u0010,\u001a\u00020\u001dH\u0002J\f\u0010-\u001a\u00020\u0010*\u00020\u0010H\u0002R\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0018\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/larus/camera/impl/widget/CaptureFocusFrame;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "cornerBitmaps", "", "Landroid/graphics/Bitmap;", "[Landroid/graphics/Bitmap;", "cornerMatrix", "Landroid/graphics/Matrix;", "[Landroid/graphics/Matrix;", "imageSize", "", "currentDegree", "", "viewWidth", "viewHeight", "drawableMargin", "bitmapPaint", "Landroid/graphics/Paint;", "animator", "Landroid/animation/ValueAnimator;", "customRectSizeCalculator", "Lcom/larus/camera/impl/widget/RectSizeCalculator;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setAlpha", "alpha", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "", "left", "top", "right", "bottom", "rotateTo", "degrees", "animate", "calCornerPosition", "degree2Valid", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CaptureFocusFrame extends FrameLayout {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static int f322835j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static int f322836k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bitmap[] f322837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Matrix[] f322838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f322839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f322840d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f322841e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f322842f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f322843g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f322844h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ValueAnimator f322845i;

    public static final class a {
    }

    static {
    }

    public final void a() {
        if (this.f322838b != null) goto L5;
        return;
    L5:
        Float r100 = Float.valueOf(this.f322841e);
        if (r100.floatValue() <= 0.0f) goto L8;
        boolean r101 = true;
    L9:
        Float r102 = null;
        if (r101 == true) goto L13;
        r100 = null;
    L13:
        if (r100 == null) goto L23;
        float r103 = r100.floatValue();
        Float r104 = Float.valueOf(this.f322842f);
        if (r104.floatValue() <= 0.0f) goto L17;
        boolean r105 = true;
    L18:
        if (r105 == false) goto L20;
        r102 = r104;
    L20:
        if (r102 == null) goto L24;
        r102.floatValue();
        float r106 = 2;
        float r107 = getMeasuredWidth() / r106;
        float r108 = getMeasuredHeight() / r106;
        Math.abs(this.f322840d);
        float r109 = r103 - (this.f322843g * 2);
        int r110 = (int) r109;
        f322835j = r110;
        f322836k = r110;
        Matrix r111 = this.f322838b[0];
        r111.reset();
        float r112 = r109 / r106;
        float r113 = r107 - r112;
        float r114 = r108 - r112;
        r111.setTranslate(r113, r114);
        r111.postRotate(this.f322840d, r107, r108);
        Matrix r115 = this.f322838b[1];
        r115.reset();
        float r116 = r107 + r112;
        r115.setTranslate(r116 - this.f322839c, r114);
        r115.postRotate(this.f322840d, r107, r108);
        Matrix r117 = this.f322838b[2];
        r117.reset();
        int r118 = this.f322839c;
        float r119 = r112 + r108;
        r117.setTranslate(r116 - r118, r119 - r118);
        r117.postRotate(this.f322840d, r107, r108);
        Matrix r120 = this.f322838b[3];
        r120.reset();
        r120.setTranslate(r113, r119 - this.f322839c);
        r120.postRotate(this.f322840d, r107, r108);
        return;
    L24:
        return;
    L17:
        r105 = false;
        goto L18
    L23:
        return;
    L8:
        r101 = false;
        goto L9
    }

    public CaptureFocusFrame(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        Bitmap[] r101 = this.f322837a;
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.f322838b == null) goto L11;
        int r102 = r101.length;
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L12;
        r100.drawBitmap(this.f322837a[r103], this.f322838b[r103], this.f322844h);
        r103 = r103 + 1;
        goto L7
    L12:
        return;
    }

    @Override // android.view.View
    public void setAlpha(float r100) {
        super.setAlpha(r100);
        this.f322844h.setAlpha((int) (r100 * 255));
    }

    public CaptureFocusFrame(Context r110, AttributeSet r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111);
        Bitmap[] r100 = null;
        this.f322843g = i5.y0(v19.c.b(R.attr.larus_dp_40, null, R.dimen.larus_dp_40));
        this.f322844h = new Paint();
        Drawable r101 = ContextCompat.getDrawable(r110, R.drawable.larus_edu_camera_ic_tip_rect_topleft);
        if (r101 == null) goto L5;
        Bitmap r112 = DrawableKt.toBitmap$default(r101, 0, 0, null, 7, null);
    L7:
        if (r112 == null) goto L18;
        this.f322839c = r112.getWidth();
        Matrix[] r102 = new Matrix[4];
        int r103 = 0;
    L9:
        if (r103 >= 4) goto L11;
        r102[r103] = new Matrix();
        r103 = r103 + 1;
        goto L9
    L11:
        this.f322838b = r102;
        Matrix r104 = new Matrix();
        Bitmap[] r105 = new Bitmap[4];
        int r113 = 0;
    L12:
        if (r113 >= 4) goto L17;
        if (r113 != 0) goto L15;
        Bitmap r106 = r112;
    L16:
        r105[r113] = r106;
        r113 = r113 + 1;
        goto L12
    L15:
        r104.postRotate(90.0f);
        r106 = Bitmap.createBitmap(r112, 0, 0, r112.getWidth(), r112.getHeight(), r104, true);
        Intrinsics.checkNotNull(r106);
        goto L16
    L17:
        r100 = r105;
    L19:
        this.f322837a = r100;
        setWillNotDraw(false);
        return;
    L18:
        this.f322839c = 0;
        this.f322838b = null;
        goto L19
    L5:
        r112 = null;
        goto L7
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (getMeasuredHeight() == this.f322842f) goto L5;
    L6:
        this.f322841e = getMeasuredWidth();
        this.f322842f = getMeasuredHeight();
        a();
        return;
    L5:
        if (getMeasuredWidth() != this.f322841e) goto L6;
    }
}
