package op6;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f524726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f524727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RectF f524728c;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        RectF r101 = this.f524728c;
        if (r101 == null) goto L6;
        r100.drawRect(r101, this.f524727b);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        this.f524727b.setColorFilter(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setBounds(int r100, int r101, int r102, int r103) {
        super.setBounds(r100, r101, r102, r103);
        this.f524728c = new RectF(r100, r101, r102, this.f524726a);
    }

    public a(int r100, float r101, float r102, float r103, float r104) {
        this.f524726a = r104;
        Paint r105 = new Paint();
        this.f524727b = r105;
        r105.setColor(0);
        r105.setAntiAlias(true);
        r105.setShadowLayer(r101, r102, r103, r100);
        r105.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
    }
}
