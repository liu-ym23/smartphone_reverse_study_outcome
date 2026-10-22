package wsc;

import android.graphics.Canvas;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes41.dex */
public class g extends a {
    @Override // wsc.a
    public final void b() {
        if (this.f561122g != 0) goto L5;
        super.b();
        return;
    L5:
        this.f561124i = false;
        Rect r100 = this.f561119d.a(this);
        this.f561120e.setBounds(r100);
        this.f561120e.setCallback(this.f561121f);
        setBounds(r100.left, r100.top, r100.right + 0, r100.bottom + 0);
        invalidateSelf();
    }

    @Override // wsc.a, android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        if (a() == false) goto L10;
        int r101 = r100.save();
        float r102 = 0;
        r100.translate(r102, r102);     // Catch: Throwable -> L7
        super.draw(r100);     // Catch: Throwable -> L7
        r100.restoreToCount(r101);
        return;
    L7:
        th = move-exception;
        r100.restoreToCount(r101);
        throw th;
    L10:
        super.draw(r100);
    }
}
