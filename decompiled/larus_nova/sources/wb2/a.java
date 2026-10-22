package wb2;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends com.bytedance.android.livesdk.widget.a {
    public a(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        super(r100);
    }

    @Override // com.bytedance.android.livesdk.widget.a, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r108, "paint");
        Drawable r109 = getDrawable();
        if ((r109 instanceof BitmapDrawable) == false) goto L9;
        BitmapDrawable r110 = (BitmapDrawable) r109;
        if (r110.getBitmap() != null) goto L7;
        return;
    L7:
        if (r110.getBitmap().isRecycled() == true) goto L12;
        r100.save();
        r109.draw(r100);
        r100.restore();
        return;
    L12:
        return;
    L9:
        r100.save();
        r109.draw(r100);
        r100.restore();
    }
}
