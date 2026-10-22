package com.bytedance.ee.bear.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: loaded from: classes18.dex */
public class AlignTextView extends AppCompatTextView {
    public AlignTextView(Context r100) {
        super(r100);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r110) {
        Layout r100 = getLayout();
        if (r100 == null) goto L40;
        int r101 = 1;
        if (r100.getLineCount() <= 1) goto L40;
        Paint.FontMetrics r102 = getPaint().getFontMetrics();
        int r103 = (int) ((((int) Math.ceil(r102.descent - r102.ascent)) * r100.getSpacingMultiplier()) + r100.getSpacingAdd());
        int r104 = (getMeasuredWidth() - getPaddingStart()) - getPaddingEnd();
        CharSequence r105 = getText();
        TextPaint r111 = getPaint();
        r111.setColor(getCurrentTextColor());
        r111.drawableState = getDrawableState();
        int r112 = r105.length();
    L9:
        if (r101 > getMaxLines()) goto L39;
        float r106 = getPaddingStart();
        float r107 = (r111.getTextSize() + (((r101 - 1) * r103) * getLineSpacingMultiplier())) + getPaddingTop();
        CharSequence r108 = null;
        if (r101 == getMaxLines()) goto L29;
        int r109 = 0;
    L14:
        if (r109 > r105.length()) goto L24;
        r108 = r105.subSequence(0, r109);
        if (StaticLayout.getDesiredWidth(r108, r111) > r104) goto L17;
        r109 = r109 + 1;
        goto L14
    L17:
        CharSequence r113 = r105.subSequence(0, r109 - 1);
        if (yu5.a.b(r113.charAt(r113.length() - 1)) == true) goto L20;
    L22:
        CharSequence r114 = r113;
    L25:
        int r115 = r114.length();
        r110.drawText(r114, 0, r115, r106, r107, r111);
        if (r115 >= r112) goto L50;
        r105 = r105.subSequence(r115, r112);
        r112 = r112 - r115;
    L38:
        r101 = r101 + 1;
        goto L9
    L50:
        return;
    L20:
        if (yu5.a.b(r105.charAt(r113.length())) == false) goto L22;
        r113 = r113.subSequence(0, r113.length() - 1);
        goto L22
    L24:
        r114 = r108;
        goto L25
    L29:
        float r116 = StaticLayout.getDesiredWidth("...", r111);
        int r117 = 0;
    L31:
        if (r117 >= r105.length()) goto L36;
        r108 = r105.subSequence(0, r117);
        if ((StaticLayout.getDesiredWidth(r108, r111) + r116) > r104) goto L34;
        r117 = r117 + 1;
        goto L31
    L34:
        CharSequence r118 = r105.subSequence(0, r117 - 1) + "...";
    L37:
        r110.drawText(r118, 0, r118.length(), r106, r107, r111);
        goto L38
    L36:
        r118 = r108;
        goto L37
    L39:
        return;
    L40:
        super.onDraw(r110);
    }

    public AlignTextView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public AlignTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
