package kfb;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.ss.android.lark.widget.span.BorderProperty;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f503282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f503283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f503284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f503285d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Matrix f503286e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RectF f503287f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f503288g;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        b r100 = (b) this;
        mfb.a r101 = r100.f503289h;
        float r102 = r101.f513683e;
        if (r102 >= 0.0f) goto L5;
        r102 = 0.0f;
    L5:
        float r103 = r101.f513684f;
        if (r103 >= 0.0f) goto L8;
        r103 = 0.0f;
    L8:
        this.f503283b.set(r102, r103, r101.f513680b - r102, r101.f513681c);
        Drawable r104 = r100.f503289h.f513679a;
        if ((r104 instanceof BitmapDrawable) == false) goto L23;
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        Bitmap r105 = ((BitmapDrawable) r104).getBitmap();
        if (r105 == null) goto L23;
        if (r105.isRecycled() == true) goto L23;
        this.f503284c.set(this.f503283b);
        this.f503284c.inset(r100.f503290i.getBorderWidthPx(), r100.f503290i.getBorderWidthPx());
        this.f503286e.reset();
        float r106 = r100.f503289h.f513685g;
        if (r106 != 0.0f) goto L19;
        boolean r107 = true;
    L20:
        if (r107 == true) goto L22;
        this.f503286e.setScale(r106, r106);
    L22:
        Matrix r108 = this.f503286e;
        mfb.a r109 = r100.f503289h;
        r108.postTranslate(r109.f513683e, r109.f513684f);
        int r111 = r110.getSaveCount();
        r110.save();
        this.f503282a.reset();
        this.f503282a.addRoundRect(this.f503284c, r100.f503290i.getBorderRadiusPx(), r100.f503290i.getBorderRadiusPx(), Path.Direction.CW);
        r110.clipPath(this.f503282a);
        r110.drawBitmap(r105, this.f503286e, this.f503285d);
        r110.restoreToCount(r111);
        goto L23
    L19:
        r107 = false;
    L23:
        float r112 = r100.f503290i.getBorderWidthPx() / 2;
        this.f503287f.set(this.f503283b);
        this.f503287f.inset(r112, r112);
        this.f503288g.setAntiAlias(true);
        this.f503288g.setStyle(Paint.Style.STROKE);
        this.f503288g.setColor(r100.f503290i.getBorderColor());
        this.f503288g.setStrokeWidth(r100.f503290i.getBorderWidthPx());
        this.f503282a.reset();
        this.f503282a.addRoundRect(this.f503287f, r100.f503290i.getBorderRadiusPx(), r100.f503290i.getBorderRadiusPx(), Path.Direction.CW);
        r110.drawPath(this.f503282a, this.f503288g);
    }

    public a(mfb.a r100, BorderProperty r101) {
        Intrinsics.checkNotNullParameter(r100, "drawableParams");
        Intrinsics.checkNotNullParameter(r101, "borderParams");
        this.f503282a = new Path();
        this.f503283b = new RectF();
        this.f503284c = new RectF();
        this.f503285d = new Paint(2);
        this.f503286e = new Matrix();
        this.f503287f = new RectF();
        this.f503288g = new Paint();
    }
}
