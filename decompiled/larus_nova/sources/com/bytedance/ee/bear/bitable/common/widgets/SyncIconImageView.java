package com.bytedance.ee.bear.bitable.common.widgets;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Region;
import android.os.Build;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.graphics.PathParser;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\u000bJ\u000e\u0010,\u001a\u00020-2\u0006\u0010*\u001a\u00020+J\u0018\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u0007H\u0014J\u0010\u00101\u001a\u00020-2\u0006\u00102\u001a\u00020$H\u0014R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0010X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\"\u001a\u0004\b'\u0010(R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/bytedance/ee/bear/bitable/common/widgets/SyncIconImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "syncOffsetX", "", "syncOffsety", "outlinePathData", "", "outlinePathConst", "Landroid/graphics/Path;", "outlinePath", "outlineMatrix", "Landroid/graphics/Matrix;", "outlineViewportWidth", "outlineViewportHeight", "syncIconPathData", "syncIconPathConst", "syncIconPath", "syncIconMatrix", "syncIconViewportWidth", "bitamap", "Landroid/graphics/Bitmap;", "getBitamap", "()Landroid/graphics/Bitmap;", "bitamap$delegate", "Lkotlin/Lazy;", "targetCanvas", "Landroid/graphics/Canvas;", "syncPaint", "Landroid/graphics/Paint;", "getSyncPaint", "()Landroid/graphics/Paint;", "syncPaint$delegate", "syncIconVisible", "", "setSyncIconVisible", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SyncIconImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f209870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f209871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Path f209872c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Path f209873d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Matrix f209874e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f209875f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f209876g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Path f209877h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Path f209878i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Matrix f209879j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f209880k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f209881l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Canvas f209882m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f209883n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f209884o;

    private final Bitmap getBitamap() {
        return (Bitmap) this.f209881l.getValue();
    }

    private final Paint getSyncPaint() {
        return (Paint) this.f209883n.getValue();
    }

    public SyncIconImageView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f209884o == true) goto L6;
        super.onDraw(r100);
        return;
    L6:
        int r101 = 0;
        getBitamap().eraseColor(0);
        this.f209882m.setBitmap(getBitamap());
        if (Build.VERSION.SDK_INT < 26) goto L9;
        this.f209882m.clipOutPath(this.f209873d);
    L10:
        super.onDraw(this.f209882m);
        r100.drawBitmap(getBitamap(), 0.0f, 0.0f, null);
        Paint r102 = getSyncPaint();
        ColorStateList r103 = getImageTintList();
        if (r103 == null) goto L13;
        r101 = r103.getDefaultColor();
    L13:
        r102.setColor(r101);
        r100.drawPath(this.f209878i, getSyncPaint());
        return;
    L9:
        this.f209882m.clipPath(this.f209873d, Region.Op.DIFFERENCE);
        goto L10
    }

    public final void setSyncIconVisible(boolean r100) {
        if (this.f209884o == r100) goto L6;
        this.f209884o = r100;
        invalidate();
        return;
    }

    public SyncIconImageView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, -1);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (this.f209884o == true) goto L5;
        return;
    L5:
        float r102 = ((getMeasuredWidth() * 1.0f) / 2) / this.f209880k;
        float r103 = getMeasuredWidth() / 2.0f;
        float r104 = 0.25f * r103;
        this.f209870a = r104;
        float r105 = 0.125f * r103;
        this.f209871b = r105;
        setPadding(0, 0, (int) r104, (int) r105);
        this.f209878i.reset();
        this.f209878i.addPath(this.f209877h);
        this.f209879j.reset();
        Path r106 = this.f209878i;
        Matrix r107 = this.f209879j;
        r107.postScale(r102, r102, 0.0f, 0.0f);
        r107.postTranslate((getMeasuredWidth() - r103) + this.f209870a, (getMeasuredHeight() - r103) + this.f209871b);
        r106.transform(r107);
        this.f209873d.reset();
        this.f209873d.addPath(this.f209872c);
        this.f209874e.reset();
        Path r108 = this.f209873d;
        Matrix r109 = this.f209874e;
        r109.postScale(r102, r102, 0.0f, 0.0f);
        float r110 = getMeasuredWidth();
        int r111 = this.f209875f;
        int r112 = this.f209880k;
        float r113 = (r110 - ((((r111 - r112) / 2) + r112) * r102)) + this.f209870a;
        float r114 = getMeasuredHeight();
        int r115 = this.f209876g;
        int r116 = this.f209880k;
        r109.postTranslate(r113, (r114 - ((((r115 - r116) / 2) + r116) * r102)) + this.f209871b);
        r108.transform(r109);
        setMeasuredDimension((int) (getMeasuredWidth() + this.f209870a), (int) (getMeasuredHeight() + this.f209871b));
    }

    public SyncIconImageView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f209872c = PathParser.createPathFromPathData("M4.0028 1.32076L3.97891 1.34767L1.07477 4.95271C0.0209347 6.19225 0.815871 8.11797 2.45128 8.24072L2.73067 8.26169L2.73068 9.33086C2.73072 11.1708 5.0053 12.0348 6.22693 10.659L6.25082 10.6321L9.15496 7.02706C10.2088 5.78752 9.41386 3.86181 7.77844 3.73906L7.49906 3.71809L7.49904 2.64892C7.49901 0.808985 5.22443 -0.0550551 4.0028 1.32076Z");
        this.f209873d = new Path();
        this.f209874e = new Matrix();
        this.f209875f = 10;
        this.f209876g = 12;
        this.f209877h = PathParser.createPathFromPathData("M4.12175 0.317461C4.42709 -0.0264257 4.99562 0.189546 4.99563 0.649432L4.99567 3.10822L6.66141 3.23325C7.07405 3.26422 7.27262 3.7544 6.99787 4.06383L4.10259 7.65788C3.79724 8.00177 3.22871 7.7858 3.2287 7.32591L3.22866 4.86712L1.56292 4.74209C1.15029 4.71112 0.951718 4.22094 1.22646 3.91151L4.12175 0.317461Z");
        this.f209878i = new Path();
        this.f209879j = new Matrix();
        this.f209880k = 8;
        this.f209881l = LazyKt.lazy(new SyncIconImageView$bitamap$2(this));
        this.f209882m = new Canvas();
        this.f209883n = LazyKt.lazy(new SyncIconImageView$syncPaint$2(this));
    }
}
