package vs;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;

/* JADX INFO: loaded from: classes44.dex */
public final class f extends BitmapDrawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f556972a;

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        r100.rotate(this.f556972a);
        super.draw(r100);
        r100.restore();
    }

    public f(Bitmap r100, int r101) {
        super(r100);
        this.f556972a = r101;
    }
}
