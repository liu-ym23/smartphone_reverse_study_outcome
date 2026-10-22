package com.bytedance.ee.bear.middleground.permission.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.ee.util.ui.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class DividerTextView extends AppCompatTextView {
    public Paint a;
    public boolean b;
    public boolean c;

    public DividerTextView(Context r2) {
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r9) {
        super/*android.widget.TextView*/.onDraw(r9);
        float r0 = n.c(0.5f) / 2.0f;
        if (this.b == false) goto L6;
        r9.drawLine(0.0f, r0, getMeasuredWidth(), r0, this.a);
    L6:
        if (this.c == false) goto L9;
        r9.drawLine(0.0f, getMeasuredHeight() - r0, getMeasuredWidth(), getMeasuredHeight() - r0, this.a);
        return;
    }

    public DividerTextView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DividerTextView(Context r3, AttributeSet r4, int r5) {
        super(r3, r4, r5);
        TypedArray r6 = r3.obtainStyledAttributes(r4, new int[]{2130969045, 2130974620});
        this.b = r6.getBoolean(1, true);
        this.c = r6.getBoolean(0, true);
        r6.recycle();
        Paint r7 = new Paint();
        this.a = r7;
        r7.setColor(r3.getResources().getColor(2131103353));
        this.a.setAntiAlias(true);
        this.a.setStrokeWidth(n.c(0.5f));
        this.a.setStyle(Paint.Style.FILL);
        setBackgroundColor(r3.getResources().getColor(2131100545));
    }
}
