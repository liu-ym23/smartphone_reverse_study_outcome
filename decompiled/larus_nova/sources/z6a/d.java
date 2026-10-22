package z6a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Spannable;
import android.text.style.ReplacementSpan;
import com.lynx.tasm.behavior.shadow.text.BackgroundColorSpan;

/* JADX INFO: loaded from: classes32.dex */
public final class d extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f570561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f570562b;

    public d(int r100, float r101) {
        this.f570561a = r100;
        this.f570562b = r101;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        return Math.round(r100.measureText(r101, r102, r103));
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r110, CharSequence r111, int r112, int r113, float r114, int r115, int r210, int r211, Paint r212) {
        Paint.FontMetrics r100 = r212.getFontMetrics();
        if ((r111 instanceof Spannable) == false) goto L11;
        Spannable r101 = (Spannable) r111;
        BackgroundColorSpan[] r102 = (BackgroundColorSpan[]) r101.getSpans(r112, r113, BackgroundColorSpan.class);
        if (r102 == null) goto L11;
        if (r102.length == 0) goto L11;
        Paint r103 = new Paint();
        r103.setStyle(Paint.Style.FILL);
        r103.setColor(r102[0].getBackgroundColor());
        Rect r116 = new Rect(Math.round(r114), r115, Math.round(r114 + r212.measureText(r101, r112, r113)), r211);
        r116.offset(0, Math.round(this.f570562b));
        r110.drawRect(r116, r103);
    L11:
        int r104 = this.f570561a;
        if (r104 != 0) goto L15;
        int r105 = -Math.round(r100.top);
    L27:
        r110.drawText(r111, r112, r113, r114, r105, r212);
        return;
    L15:
        if (r104 != 2) goto L18;
        r105 = r211 - Math.round(r100.leading);
        goto L27
    L18:
        if (r104 != 1) goto L23;
        r105 = (int) ((Math.round(Math.abs(r100.ascent)) + r115) + (((r211 - r115) - (r100.descent - r100.ascent)) / 2.0f));
        if (r100.leading != 0.0f) goto L27;
        float r106 = r105 + ((r100.descent / 2.0f) - r212.getStrokeMiter());
    L25:
        r105 = (int) r106;
        goto L27
    L23:
        if (r104 != 3) goto L26;
        r106 = r210 + this.f570562b;
        goto L25
    L26:
        r105 = r210;
        goto L27
    }
}
