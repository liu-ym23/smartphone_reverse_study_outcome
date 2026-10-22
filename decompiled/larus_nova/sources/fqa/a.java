package fqa;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes34.dex */
public final class a extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f478463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f478464c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Path f478465d;

    public a() {
        this.f478463b = 0;
        this.f478464c = 0;
        this.f478465d = new Path();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r110) {
        Rect r100 = getBounds();
        int r101 = r100.width();
        int r102 = r100.height();
        if (this.f478463b == r101) goto L5;
    L6:
        this.f478465d.reset();
        float r103 = (r101 * 30) / 225;
        float r104 = r103 * 0.70710677f;
        float r105 = r103 / 0.70710677f;
        float r106 = r101;
        float r107 = r106 / 2.0f;
        float r108 = r102;
        this.f478465d.moveTo(r107, r108);
        float r111 = r108 / 2.0f;
        this.f478465d.lineTo(0.0f, r111);
        float r112 = r111 - r104;
        this.f478465d.lineTo(r104, r112);
        float r109 = r103 / 2.0f;
        float r113 = r107 - r109;
        float r114 = (r108 - r105) - r109;
        this.f478465d.lineTo(r113, r114);
        this.f478465d.lineTo(r113, 0.0f);
        float r115 = r107 + r109;
        this.f478465d.lineTo(r115, 0.0f);
        this.f478465d.lineTo(r115, r114);
        this.f478465d.lineTo(r106 - r104, r112);
        this.f478465d.lineTo(r106, r111);
        this.f478465d.close();
        this.f478463b = r101;
        this.f478464c = r102;
    L7:
        r110.drawPath(this.f478465d, this.f478469a);
        return;
    L5:
        if (this.f478464c == r102) goto L7;
        goto L6
    }
}
