package wu7;

import android.graphics.Canvas;
import android.graphics.Paint;

/* JADX INFO: loaded from: classes23.dex */
public class d extends e {
    public d() {
    }

    @Override // wu7.e
    public final void h(Canvas r100, Paint r101) {
        if (this.f561463p == null) goto L6;
        r101.setStyle(Paint.Style.STROKE);
        int r102 = Math.min(this.f561463p.width(), this.f561463p.height()) / 2;
        r101.setStrokeWidth(r102 / 12);
        r100.drawCircle(this.f561463p.centerX(), this.f561463p.centerY(), r102, r101);
        return;
    }
}
