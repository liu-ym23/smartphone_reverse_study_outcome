package ncc;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.ss.android.lark.widget.span.TextStyleInfo;
import java.util.Objects;

/* JADX INFO: loaded from: classes38.dex */
public final class h extends MetricAffectingSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextStyleInfo f518743a;

    public final int hashCode() {
        return Objects.hash(new Object[]{this.f518743a});
    }

    public h(TextStyleInfo r100) {
        this.f518743a = r100;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if (h.class == r100.getClass()) goto L10;
        return false;
    L10:
        return this.f518743a.equals(((h) r100).f518743a);
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        TextStyleInfo r101 = this.f518743a;
        int r102 = r101.textBgColor;
        if (r102 == 0) goto L5;
        r100.bgColor = r102;
    L5:
        int r103 = r101.textSize;
        if (r103 <= (-1)) goto L8;
        r100.setTextSize(r103);
    L8:
        int r104 = this.f518743a.textColor;
        if (r104 == 0) goto L11;
        r100.setColor(r104);
    L11:
        Typeface r105 = this.f518743a.textStyle;
        if (r105 == null) goto L15;
        r100.setTypeface(r105);
    L15:
        if (this.f518743a.isItalic == false) goto L18;
        r100.setTextSkewX(-0.25f);
    L18:
        if (this.f518743a.isBold == false) goto L21;
        r100.setFakeBoldText(true);
    L21:
        if (this.f518743a.isUnderlineText == false) goto L24;
        r100.setUnderlineText(true);
    L24:
        if (this.f518743a.isStrikeThruText == false) goto L27;
        r100.setStrikeThruText(true);
        return;
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r100) {
        int r101 = this.f518743a.textSize;
        if (r101 <= 0) goto L5;
        r100.setTextSize(r101);
    L5:
        Typeface r102 = this.f518743a.textStyle;
        if (r102 == null) goto L9;
        r100.setTypeface(r102);
        return;
    }
}
