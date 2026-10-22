package epc;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;

/* JADX INFO: loaded from: classes36.dex */
public final class b extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f473453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Drawable f473454b;

    public b(a r100) {
        this.f473453a = new Paint();
        this.f473454b = r100;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        this.f473453a.set(r100);
        if (r104 == null) goto L9;
        this.f473453a.getFontMetricsInt(r104);
        Drawable r105 = this.f473454b;
        if (r105 != null) goto L7;
        Rect r106 = new Rect();
    L8:
        int r107 = r104.descent - r104.ascent;
        int r108 = ((int) 0.0f) / 2;
        int r109 = r104.top;
        r104.ascent = Math.min(r109, ((r107 - r106.bottom) / 2) + r109) - r108;
        int r110 = r104.bottom;
        int r111 = Math.max(r110, ((r106.bottom - r107) / 2) + r110) + r108;
        r104.descent = r111;
        r104.top = r104.ascent;
        r104.bottom = r111;
        goto L9
    L7:
        r106 = r105.getBounds();
    L9:
        Drawable r112 = this.f473454b;
        if (r112 != null) goto L12;
        Rect r113 = new Rect();
    L14:
        return r113.right;
    L12:
        r113 = r112.getBounds();
        goto L14
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
        if (this.f473454b == null) goto L6;
        r100.save();
        r100.translate(r104, ((r107 - this.f473454b.getBounds().bottom) + r105) / 2);
        this.f473454b.draw(r100);
        r100.restore();
        return;
    }
}
