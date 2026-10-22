package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.util.AttributeSet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class DialogTitle extends AppCompatTextView {
    public DialogTitle(Context r1) {
        super(r1);
    }

    public DialogTitle(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onMeasure(int r7, int r8) {
        super.onMeasure(r7, r8);
        Layout r0 = getLayout();
        if (r0 == null) goto L13;
        int r1 = r0.getLineCount();
        if (r1 > 0) goto L7;
        return;
    L7:
        if (r0.getEllipsisCount(r1 - 1) <= 0) goto L15;
        setSingleLine(false);
        setMaxLines(2);
        TypedArray r2 = getContext().obtainStyledAttributes(null, new int[]{R.attr.textSize, R.attr.typeface, R.attr.textStyle, R.attr.textColor, R.attr.textColorHint, R.attr.textColorLink, R.attr.shadowColor, R.attr.shadowDx, R.attr.shadowDy, R.attr.shadowRadius, R.attr.fontFamily, R.attr.textFontWeight, 2130970118, 2130970129, 2130974497, 2130974532}, R.attr.textAppearanceMedium, R.style.TextAppearance.Medium);
        int r3 = r2.getDimensionPixelSize(0, 0);
        if (r3 == 0) goto L11;
        setTextSize(0, r3);
    L11:
        r2.recycle();
        super.onMeasure(r7, r8);
        return;
    L15:
        return;
    }

    public DialogTitle(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
