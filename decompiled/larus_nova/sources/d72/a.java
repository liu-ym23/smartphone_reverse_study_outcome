package d72;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f467220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f467221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Path f467222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float[] f467223d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float[] f467224e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float[] f467225f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f467226g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f467227h;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.f467221b.set(getBounds());
        this.f467222c.reset();
        boolean r101 = this.f467226g;
        if (r101 == true) goto L5;
    L7:
        if (r101 == false) goto L9;
    L11:
        if (r101 == true) goto L13;
    L15:
        this.f467222c.addRect(this.f467221b, Path.Direction.CCW);
    L16:
        r100.drawPath(this.f467222c, this.f467220a);
        return;
    L13:
        if (this.f467227h == false) goto L15;
        this.f467222c.addRoundRect(this.f467221b, this.f467225f, Path.Direction.CCW);
        goto L16
    L9:
        if (this.f467227h == false) goto L11;
        this.f467222c.addRoundRect(this.f467221b, this.f467224e, Path.Direction.CCW);
        goto L16
    L5:
        if (this.f467227h == true) goto L7;
        this.f467222c.addRoundRect(this.f467221b, this.f467223d, Path.Direction.CCW);
        goto L16
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f467220a.setAlpha(r100);
        invalidateSelf();
    }

    public a(int r110, boolean r111, boolean r112) {
        this.f467226g = r111;
        this.f467227h = r112;
        Paint r113 = new Paint(1);
        r113.setColor(r110);
        r113.setStyle(Paint.Style.FILL);
        Unit r114 = Unit.INSTANCE;
        this.f467220a = r113;
        this.f467221b = new RectF();
        this.f467222c = new Path();
        float r115 = UtilityKotlinExtentionsKt.h(8);
        this.f467223d = new float[]{r115, r115, r115, r115, 0.0f, 0.0f, 0.0f, 0.0f};
        this.f467224e = new float[]{0.0f, 0.0f, 0.0f, 0.0f, r115, r115, r115, r115};
        this.f467225f = new float[]{r115, r115, r115, r115, r115, r115, r115, r115};
    }
}
