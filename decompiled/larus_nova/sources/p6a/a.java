package p6a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes32.dex */
public final class a extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f527941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f527942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Path f527943d;

    public a() {
        this.f527941b = 0;
        this.f527942c = 0;
        this.f527943d = new Path();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r110) {
        Rect r100 = getBounds();
        int r101 = r100.width();
        int r102 = r100.height();
        if (this.f527941b == r101) goto L5;
    L6:
        this.f527943d.reset();
        float r103 = (r101 * 30) / 225;
        float r104 = r103 * 0.70710677f;
        float r105 = r103 / 0.70710677f;
        float r106 = r101;
        float r107 = r106 / 2.0f;
        float r108 = r102;
        this.f527943d.moveTo(r107, r108);
        float r111 = r108 / 2.0f;
        this.f527943d.lineTo(0.0f, r111);
        float r112 = r111 - r104;
        this.f527943d.lineTo(r104, r112);
        float r109 = r103 / 2.0f;
        float r113 = r107 - r109;
        float r114 = (r108 - r105) - r109;
        this.f527943d.lineTo(r113, r114);
        this.f527943d.lineTo(r113, 0.0f);
        float r115 = r107 + r109;
        this.f527943d.lineTo(r115, 0.0f);
        this.f527943d.lineTo(r115, r114);
        this.f527943d.lineTo(r106 - r104, r112);
        this.f527943d.lineTo(r106, r111);
        this.f527943d.close();
        this.f527941b = r101;
        this.f527942c = r102;
    L7:
        r110.drawPath(this.f527943d, this.f527947a);
        return;
    L5:
        if (this.f527942c == r102) goto L7;
        goto L6
    }
}
