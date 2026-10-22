package x90;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

/* JADX INFO: loaded from: classes45.dex */
public final class a extends ImageSpan implements e90.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f562962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f562963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f562964c;

    @Override // e90.a
    public final int a() {
        return 1;
    }

    @Override // e90.a
    public final /* synthetic */ boolean b() {
        return false;
    }

    @Override // e90.a
    public final String getDesc() {
        return this.f562964c;
    }

    public a(Drawable r100) {
        super(r100);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Rect r105 = getDrawable().getBounds();
        if (r104 == null) goto L6;
        Paint.FontMetricsInt r106 = r100.getFontMetricsInt();
        int r107 = r106.bottom - r106.top;
        int r108 = (r105.bottom - r105.top) / 2;
        int r109 = r107 / 4;
        int r110 = r108 - r109;
        int r111 = -(r108 + r109);
        r104.ascent = r111;
        r104.top = r111;
        r104.bottom = r110;
        r104.descent = r110;
    L6:
        return (r105.right + this.f562962a) + this.f562963b;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
        float r109 = r104 + this.f562962a;
        Drawable r110 = getDrawable();
        r100.save();
        Paint.FontMetricsInt r111 = r108.getFontMetricsInt();
        r100.translate(r109, (int) (((((r111.descent + r106) + (r106 + r111.ascent)) / 2) - (r110.getBounds().bottom / 2)) + 0.5f));
        r110.draw(r100);
        r100.restore();
    }
}
