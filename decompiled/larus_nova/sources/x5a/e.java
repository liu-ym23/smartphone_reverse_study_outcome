package x5a;

import android.graphics.Canvas;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.drawable.PictureDrawable;
import com.lynx.component.svg.parser.SVG;
import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: classes32.dex */
public final class e extends PictureDrawable {
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

    public e(SVG r100, com.lynx.component.svg.parser.c r101, com.lynx.component.svg.d r102) {
        super(null);
        Picture r103 = r100.e(r101, r102);
        if (r103 == null) goto L5;
        LLog.i("lynx_UISvg", "renderToPicture success.svgHashCode:" + r100.hashCode() + " picture hashCode:" + r103.hashCode());
    L5:
        setPicture(r103);
    }
}
