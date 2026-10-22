package io.noties.markwon.core.spans;

import android.graphics.Paint;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.LineHeightSpan;
import android.text.style.ReplacementSpan;

/* JADX INFO: loaded from: classes41.dex */
public class l implements LineHeightSpan.WithDensity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f492346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f492347b;

    @Override // android.text.style.LineHeightSpan
    public final void chooseHeight(CharSequence r100, int r101, int r102, int r103, int r104, Paint.FontMetricsInt r105) {
    }

    public static boolean a(CharSequence r100) {
        int r101 = 0;
    L4:
        if (r101 >= r100.length()) goto L11;
        char r102 = r100.charAt(r101);
        if (Character.isWhitespace(r102) == true) goto L10;
        if (Character.isSpaceChar(r102) == true) goto L10;
        return false;
    L10:
        r101 = r101 + 1;
        goto L4
    L11:
        return true;
    }

    public l(float r100, float r101) {
        this.f492346a = r100;
        this.f492347b = r101;
    }

    @Override // android.text.style.LineHeightSpan.WithDensity
    public void chooseHeight(CharSequence r100, int r101, int r102, int r103, int r104, Paint.FontMetricsInt r105, TextPaint r106) {
        if (r106 != null) goto L4;
        return;
    L4:
        Paint.FontMetricsInt r107 = r106.getFontMetricsInt();
        if ((r107.descent - r107.ascent) > 0) goto L8;
        return;
    L8:
        if ((r100 instanceof Spanned) == false) goto L15;
        ReplacementSpan[] r108 = (ReplacementSpan[]) ((Spanned) r100).getSpans(r101, r102, ReplacementSpan.class);
        if (r108 == null) goto L15;
        if (r108.length <= 0) goto L15;
        return;
    L15:
        if (a(r100.subSequence(r101, r102)) == false) goto L17;
        float r109 = this.f492346a;
    L18:
        r105.ascent = Math.round(r107.ascent * r109);
        r105.descent = Math.round(r107.descent * r109);
        r105.top = Math.round(r107.top * r109);
        r105.bottom = Math.round(r107.bottom * r109);
        return;
    L17:
        r109 = this.f492347b;
        goto L18
    }
}
