package wu7;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;

/* JADX INFO: loaded from: classes23.dex */
public abstract class e extends f {
    public final Paint B;
    public int C;
    public int D;

    public abstract void h(Canvas r100, Paint r101);

    public e() {
        e(-1);
        Paint r100 = new Paint();
        this.B = r100;
        r100.setAntiAlias(true);
        r100.setColor(this.C);
    }

    @Override // wu7.f
    public final int c() {
        return this.D;
    }

    @Override // wu7.f
    public final void b(Canvas r100) {
        this.B.setColor(this.C);
        h(r100, this.B);
    }

    @Override // wu7.f
    public final void e(int r100) {
        this.D = r100;
        int r101 = this.f561462o;
        int r102 = r101 + (r101 >> 7);
        int r103 = ((r100 >>> 24) * r102) >> 8;
        this.C = ((r100 << 8) >>> 8) | (r103 << 24);
    }

    @Override // wu7.f, android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f561462o = r100;
        int r101 = r100 + (r100 >> 7);
        int r102 = this.D;
        int r103 = ((r102 >>> 24) * r101) >> 8;
        int r104 = r103 << 24;
        this.C = r104 | ((r102 << 8) >>> 8);
    }

    @Override // wu7.f, android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        this.B.setColorFilter(r100);
    }
}
