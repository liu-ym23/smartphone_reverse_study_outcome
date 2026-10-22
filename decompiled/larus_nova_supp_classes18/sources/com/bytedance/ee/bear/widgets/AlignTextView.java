package com.bytedance.ee.bear.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class AlignTextView extends AppCompatTextView {
    public AlignTextView(Context r1) {
        super(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r16) {
        Layout r0 = getLayout();
        if (r0 == null) goto L40;
        int r2 = 1;
        if (r0.getLineCount() <= 1) goto L40;
        Paint.FontMetrics r1 = getPaint().getFontMetrics();
        int r3 = (int) ((((int) Math.ceil(r1.descent - r1.ascent)) * r0.getSpacingMultiplier()) + r0.getSpacingAdd());
        int r4 = (getMeasuredWidth() - getPaddingStart()) - getPaddingEnd();
        CharSequence r5 = getText();
        TextPaint r11 = getPaint();
        r11.setColor(getCurrentTextColor());
        r11.drawableState = getDrawableState();
        int r12 = r5.length();
    L9:
        if (r2 > getMaxLines()) goto L39;
        float r8 = getPaddingStart();
        float r9 = (r11.getTextSize() + (((r2 - 1) * r3) * getLineSpacingMultiplier())) + getPaddingTop();
        CharSequence r6 = null;
        if (r2 == getMaxLines()) goto L29;
        int r7 = 0;
    L14:
        if (r7 > r5.length()) goto L24;
        r6 = r5.subSequence(0, r7);
        if (StaticLayout.getDesiredWidth(r6, r11) > r4) goto L17;
        r7 = r7 + 1;
        goto L14
    L17:
        CharSequence r10 = r5.subSequence(0, r7 - 1);
        if (yu5.a.b(r10.charAt(r10.length() - 1)) == true) goto L20;
    L22:
        CharSequence r13 = r10;
    L25:
        int r14 = r13.length();
        r16.drawText(r13, 0, r14, r8, r9, r11);
        if (r14 >= r12) goto L50;
        r5 = r5.subSequence(r14, r12);
        r12 = r12 - r14;
    L38:
        r2 = r2 + 1;
        goto L9
    L50:
        return;
    L20:
        if (yu5.a.b(r5.charAt(r10.length())) == false) goto L22;
        r10 = r10.subSequence(0, r10.length() - 1);
        goto L22
    L24:
        r13 = r6;
        goto L25
    L29:
        float r15 = StaticLayout.getDesiredWidth("...", r11);
        int r17 = 0;
    L31:
        if (r17 >= r5.length()) goto L36;
        r6 = r5.subSequence(0, r17);
        if ((StaticLayout.getDesiredWidth(r6, r11) + r15) > r4) goto L34;
        r17 = r17 + 1;
        goto L31
    L34:
        CharSequence r18 = r5.subSequence(0, r17 - 1) + "...";
    L37:
        r16.drawText(r18, 0, r18.length(), r8, r9, r11);
        goto L38
    L36:
        r18 = r6;
        goto L37
    L39:
        return;
    L40:
        super/*android.widget.TextView*/.onDraw(r16);
    }

    public AlignTextView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public AlignTextView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
