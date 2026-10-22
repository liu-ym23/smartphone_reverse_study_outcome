package ncc;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import java.util.Objects;

/* JADX INFO: loaded from: classes38.dex */
public final class b extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f518711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f518712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f518713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f518714d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f518715e;

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.f518711a), Boolean.valueOf(this.f518712b), Integer.valueOf(this.f518713c), Integer.valueOf(this.f518714d), Integer.valueOf(this.f518715e)});
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f518711a == r101.f518711a) goto L11;
    L19:
        return false;
    L11:
        if (this.f518712b != r101.f518712b) goto L19;
        if (this.f518713c != r101.f518713c) goto L19;
        if (this.f518714d != r101.f518714d) goto L19;
        if (this.f518715e != r101.f518715e) goto L19;
        return true;
    }

    public b(int r100, int r101, int r102, boolean r103) {
        this.f518712b = r103;
        this.f518713c = r100;
        this.f518714d = r101;
        this.f518715e = r102;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        int r105 = this.f518715e;
        if (r105 == 0) goto L5;
        r100.setTextSize(r105);
    L5:
        Paint.FontMetricsInt r106 = r100.getFontMetricsInt();
        int r107 = (int) (((r106.bottom - r106.top) / 2) + r100.measureText(r101, r102, r103));
        this.f518711a = r107;
        return r107;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r110, CharSequence r111, int r112, int r113, float r210, int r211, int r212, int r213, Paint r214) {
        int r100 = this.f518715e;
        if (r100 == 0) goto L5;
        r214.setTextSize(r100);
    L5:
        Paint.FontMetricsInt r101 = r214.getFontMetricsInt();
        int r114 = r101.bottom - r101.top;
        if (this.f518712b == false) goto L8;
        r214.setColor(this.f518713c);
        int r102 = (int) (this.f518711a + r210);
        float r103 = r214.measureText(r111, r112, r113);
        RectF r115 = new RectF();
        float r104 = r102;
        float r105 = r104 - r103;
        r115.left = r105;
        float r116 = r211;
        r115.top = r116;
        r115.right = r104;
        float r117 = r213;
        r115.bottom = r117;
        r110.drawRect(r115, r214);
        r214.setColor(this.f518714d);
        r110.drawText(r111, r112, r113, r105, r212, r214);
        r214.setColor(this.f518713c);
        float r106 = r115.left;
        float r107 = r114 / 2;
        r110.drawArc(new RectF(r106 - r107, r116, r106 + r107, r117), 90.0f, 180.0f, false, r214);
        return;
    L8:
        r214.setColor(this.f518713c);
        float r118 = r214.measureText(r111, r112, r113);
        RectF r108 = new RectF();
        r108.left = r210;
        float r119 = r211;
        r108.top = r119;
        r108.right = r210 + r118;
        float r120 = r213;
        r108.bottom = r120;
        r110.drawRect(r108, r214);
        r214.setColor(this.f518714d);
        r110.drawText(r111, r112, r113, r210, r212, r214);
        r214.setColor(this.f518713c);
        float r109 = r210 + r118;
        float r121 = r114 / 2;
        r110.drawArc(new RectF(r109 - r121, r119, r109 + r121, r120), 270.0f, 180.0f, false, r214);
    }
}
