package wsc;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ReplacementSpan;

/* JADX INFO: loaded from: classes41.dex */
public class f extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final msc.s f561137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f561138b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f561139c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f561140d;

    public void a(float r100) {
    }

    public f(msc.s r100, a r101) {
        this.f561137a = r100;
        this.f561138b = r101;
        this.f561139c = 2;
        this.f561140d = false;
        if (TextUtils.isEmpty(r101.f561116a) == false) goto L8;
        if (r100.f515566z == false) goto L8;
        r101.f561127l = true;
    L8:
        if (r101.a() == true) goto L11;
        r101.f561117b.c(r101);
        return;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        if (this.f561138b.a() == false) goto L9;
        Rect r105 = this.f561138b.getBounds();
        if (r104 == null) goto L18;
        int r106 = -r105.bottom;
        r104.ascent = r106;
        r104.descent = 0;
        r104.top = r106;
        r104.bottom = 0;
    L18:
        return r105.width();
    L9:
        if (this.f561140d == false) goto L17;
        msc.s r107 = this.f561137a;
        r100.setUnderlineText(r107.f515542b);
        int r108 = r107.f515541a;
        if (r108 == 0) goto L14;
        r100.setColor(r108);
        goto L17
    L14:
        if ((r100 instanceof TextPaint) == false) goto L17;
        r100.setColor(((TextPaint) r100).linkColor);
    L17:
        return (int) (r100.measureText(r101, r102, r103) + 0.5f);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas r110, CharSequence r111, int r112, int r113, float r114, int r115, int r116, int r117, Paint r118) {
        a r100 = this.f561138b;
        int r101 = ftc.d.a(r110, r111);
        float r102 = r118.getTextSize();
        r100.f561122g = r101;
        r100.f561123h = r102;
        if (r100.f561124i == false) goto L5;
        r100.b();
    L5:
        a r103 = this.f561138b;
        if (r103.a() == false) goto L19;
        int r104 = r117 - r103.getBounds().bottom;
        a(Math.max(r103.f561122g - r114, 0.0f));
        int r105 = r110.save();
        int r106 = this.f561139c;     // Catch: Throwable -> L16
        if (2 != r106) goto L12;
        r104 = r104 - (((r117 - r115) - r103.getBounds().height()) / 2);     // Catch: Throwable -> L16
    L14:
        r110.translate(r114, r104);     // Catch: Throwable -> L16
        r103.draw(r110);     // Catch: Throwable -> L16
        r110.restoreToCount(r105);
        return;
    L12:
        if (1 != r106) goto L14;
        r104 = r104 - r118.getFontMetricsInt().descent;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        r110.restoreToCount(r105);
        throw th;
    L19:
        float r107 = (int) ((((r117 - r115) / 2) + r115) - (((r118.descent() + r118.ascent()) / 2.0f) + 0.5f));
        if (this.f561140d == false) goto L27;
        msc.s r108 = this.f561137a;
        r118.setUnderlineText(r108.f515542b);
        int r109 = r108.f515541a;
        if (r109 == 0) goto L25;
        r118.setColor(r109);
        goto L27
    L25:
        if ((r118 instanceof TextPaint) == false) goto L27;
        r118.setColor(((TextPaint) r118).linkColor);
    L27:
        r110.drawText(r111, r112, r113, r114, r107, r118);
    }
}
