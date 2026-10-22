package wu7;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes23.dex */
public class b extends e {
    public b() {
    }

    @Override // wu7.e
    public final void h(Canvas r100, Paint r101) {
        Rect r102 = this.f561463p;
        if (r102 == null) goto L6;
        r100.drawCircle(this.f561463p.centerX(), this.f561463p.centerY(), Math.min(r102.width(), this.f561463p.height()) / 2, r101);
        return;
    }
}
