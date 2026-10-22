package j6a;

import android.graphics.Canvas;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.drawable.PictureDrawable;

/* JADX INFO: loaded from: classes32.dex */
public final class a extends PictureDrawable {
    public a(Picture r100) {
        super(r100);
    }

    @Override // android.graphics.drawable.PictureDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Rect r101 = getBounds();
        r100.save();
        if (getPicture() == null) goto L5;
        r100.translate(r101.left, r101.top);
        r100.drawPicture(getPicture());
    L5:
        r100.restore();
    }
}
