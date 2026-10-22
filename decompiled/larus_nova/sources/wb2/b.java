package wb2;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes9.dex */
public final class b extends j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f558920b;

    @Override // com.bytedance.android.livesdk.widget.a
    public final float a(float r100) {
        return r100;
    }

    @Override // com.bytedance.android.livesdk.widget.a
    public final float b(Paint r100, int r101) {
        return 0.0f;
    }

    public b(Drawable r100) {
        super(r100);
        this.f558920b = 1.0f;
    }

    @Override // com.bytedance.android.livesdk.widget.a, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Rect r105 = getDrawable().getBounds();
        if (r104 == null) goto L6;
        Paint.FontMetricsInt r106 = r100.getFontMetricsInt();
        int r107 = r106.bottom - r106.top;
        int r108 = r105.bottom - r105.top;
        this.f558920b = r100.getTextSize() / r108;
        int r109 = r108 / 2;
        int r110 = r107 / 4;
        int r111 = r109 - r110;
        int r112 = -(r109 + r110);
        r104.ascent = r112;
        r104.top = r112;
        r104.bottom = r111;
        r104.descent = r111;
    L6:
        return (int) ((r105.right * this.f558920b) + 0);
    }

    @Override // com.bytedance.android.livesdk.widget.a, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
        Drawable r109 = getDrawable();
        float r110 = (r109.getBounds().bottom - r109.getBounds().top) * this.f558920b;
        r100.save();
        r100.translate(r104, (r105 + ((r107 - r105) / 2.0f)) - (r110 / 2.0f));
        float r111 = this.f558920b;
        r100.scale(r111, r111);
        r109.draw(r100);
        r100.restore();
    }
}
