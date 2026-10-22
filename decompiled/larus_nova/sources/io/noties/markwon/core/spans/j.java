package io.noties.markwon.core.spans;

import android.graphics.Paint;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes41.dex */
public final class j extends l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f492343c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f492344d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f492345e;

    public j(float r100, float r101, boolean r102) {
        super(r100, r101);
        this.f492343c = r100;
        this.f492344d = r101;
        this.f492345e = r102;
    }

    @Override // io.noties.markwon.core.spans.l, android.text.style.LineHeightSpan.WithDensity
    public final void chooseHeight(CharSequence r100, int r101, int r102, int r110, int r111, Paint.FontMetricsInt r112, TextPaint r113) {
        if (r113 != null) goto L4;
        return;
    L4:
        if (r112 != null) goto L6;
        return;
    L6:
        if (r100 != null) goto L8;
        return;
    L8:
        Paint.FontMetricsInt r114 = r113.getFontMetricsInt();
        if ((r114.descent - r114.ascent) > 0) goto L12;
        return;
    L12:
        if ((r100 instanceof Spanned) == false) goto L29;
        ReplacementSpan[] r115 = (ReplacementSpan[]) ((Spanned) r100).getSpans(r101, r102, ReplacementSpan.class);
        boolean r103 = false;
        if (r115 == null) goto L21;
        ArrayList r104 = new ArrayList();
        int r105 = r115.length;
        int r106 = 0;
    L16:
        if (r106 >= r105) goto L22;
        ReplacementSpan r107 = r115[r106];
        if ((!(r107 instanceof gw8.d)) == false) goto L20;
        r104.add(r107);
    L20:
        r106 = r106 + 1;
    L22:
        if (r104 != null) goto L24;
    L25:
        r103 = true;
    L26:
        if (r103 == true) goto L29;
        return;
    L24:
        if (r104.isEmpty() == false) goto L26;
    L21:
        r104 = null;
    L29:
        if (l.a(r100.subSequence(r101, r102)) == true) goto L31;
    L35:
        float r108 = this.f492344d;
    L36:
        r112.ascent = Math.round(r114.ascent * r108);
        r112.descent = Math.round(r114.descent * r108);
        r112.top = Math.round(r114.top * r108);
        r112.bottom = Math.round(r114.bottom * r108);
        return;
    L31:
        if (this.f492345e == true) goto L33;
    L34:
        r108 = this.f492343c;
        goto L36
    L33:
        if (r100.length() == (r102 - 1)) goto L35;
        goto L34
    }
}
