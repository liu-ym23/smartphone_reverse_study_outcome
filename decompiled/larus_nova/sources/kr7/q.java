package kr7;

import android.graphics.Canvas;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes22.dex */
public final class q extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p f505830c;

    @Override // kr7.t, lr7.c
    public final float a() {
        int r100 = this.f505839a;
        if (r100 > 0) goto L9;
        p r101 = this.f505830c;
        if (r101 == null) goto L9;
        r100 = r101.f505819a;
    L9:
        return r100;
    }

    @Override // kr7.t, lr7.c
    public final float b() {
        int r100 = this.f505840b;
        if (r100 > 0) goto L9;
        p r101 = this.f505830c;
        if (r101 == null) goto L9;
        r100 = r101.f505820b;
    L9:
        return -r100;
    }

    public final void d(Canvas r100, Rect r101) {
        p r102 = this.f505830c;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.f505824f == null) goto L16;
        r100.save();
        if (this.f505839a > 0) goto L10;
    L12:
        p r103 = this.f505830c;
        r103.f505824f.setBounds(r101.left, r101.top, r103.f505819a, r103.f505820b);
    L13:
        this.f505830c.f505824f.draw(r100);
        r100.restore();
        return;
    L10:
        if (this.f505840b <= 0) goto L12;
        this.f505830c.f505824f.setBounds(r101);
        r100.clipRect(r101);
        goto L13
    }

    public q(p r100, int r101, int r102) {
        super(r101, r102);
        this.f505830c = r100;
    }
}
