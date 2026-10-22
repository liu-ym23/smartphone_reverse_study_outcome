package com.bytedance.awemeopen.apps.framework.base.view;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.awemeopen.apps.framework.utils.n0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class HollowTextView extends View {
    public String a;
    public PorterDuffXfermode b;
    public PorterDuffXfermode c;
    public RectF d;
    public int e;
    public int f;
    public int g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public Paint l;
    public int m;
    public int n;

    public static class a {
        public int a;
        public int b;
        public int c;
        public boolean d;
        public boolean e;
        public boolean f;
        public boolean g;

        public a() {
        }
    }

    public final void a() {
        Paint r0 = new Paint();
        this.l = r0;
        r0.setTextSize(this.e);
        this.l.setAntiAlias(true);
        this.l.setTypeface(Typeface.create("sans-serif-medium", 0));
        this.l.setColor(this.f);
        this.l.setAntiAlias(true);
    }

    public String getText() {
        return this.a;
    }

    public HollowTextView(Context r2) {
        this(r2, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r10) {
        if (TextUtils.isEmpty(this.a) == true) goto L30;
        int r6 = r10.saveLayer(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), null);
        if (this.c != null) goto L7;
        this.c = new PorterDuffXfermode(PorterDuff.Mode.SRC);
    L7:
        this.l.setXfermode(this.c);
        if (this.g > 0) goto L10;
        r10.drawRect(0.0f, 0.0f, this.m, this.n, this.l);
    L26:
        if (this.b != null) goto L28;
        this.b = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    L28:
        this.l.setXfermode(this.b);
        r10.drawText(this.a, getPaddingLeft(), (((int) (this.n - this.l.getFontMetrics().ascent)) >> 1) - 2, this.l);
        r10.restoreToCount(r6);
        return;
    L10:
        if (this.d != null) goto L12;
        this.d = new RectF();
    L12:
        RectF r0 = this.d;
        r0.left = 0.0f;
        r0.top = 0.0f;
        r0.right = this.m;
        r0.bottom = this.n;
        int r1 = this.g;
        r10.drawRoundRect(r0, r1, r1, this.l);
        if (this.h == true) goto L16;
        int r2 = this.g;
        r10.drawRect(0.0f, 0.0f, r2, r2, this.l);
    L16:
        if (this.i == true) goto L19;
        int r3 = this.m;
        int r4 = this.g;
        r10.drawRect(r3 - r4, 0.0f, r3, r4, this.l);
    L19:
        if (this.j == true) goto L22;
        int r5 = this.n;
        int r7 = this.g;
        r10.drawRect(0.0f, r5 - r7, r7, r5, this.l);
    L22:
        if (this.k == true) goto L26;
        int r8 = this.m;
        int r9 = this.g;
        int r11 = this.n;
        r10.drawRect(r8 - r9, r11 - r9, r8, r11, this.l);
        goto L26
    }

    public void setText(String r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.equals(this.a) == true) goto L9;
        this.a = r2;
        requestLayout();
        invalidate();
        setContentDescription(r2);
        return;
    }

    public HollowTextView(Context r1, a r2) {
        super(r1);
        this.a = null;
        this.e = r2.a;
        this.f = r2.b;
        this.g = r2.c;
        this.h = r2.d;
        this.i = r2.e;
        this.j = r2.f;
        this.k = r2.g;
        a();
    }

    @Override // android.view.View
    public final void onMeasure(int r5, int r6) {
        this.m = (((int) this.l.measureText(this.a)) + getPaddingLeft()) + getPaddingRight();
        this.n = (this.e + getPaddingTop()) + getPaddingBottom();
        int r0 = this.m;
        int r1 = View.MeasureSpec.getMode(r5);
        int r7 = View.MeasureSpec.getSize(r5);
        if (r1 == Integer.MIN_VALUE) goto L7;
        if (r1 != 1073741824) goto L8;
        r0 = r7;
    L8:
        this.m = r0;
        int r8 = this.n;
        int r2 = View.MeasureSpec.getMode(r6);
        int r9 = View.MeasureSpec.getSize(r6);
        if (r2 == Integer.MIN_VALUE) goto L13;
        if (r2 != 1073741824) goto L14;
        r8 = r9;
    L14:
        this.n = r8;
        setMeasuredDimension(this.m, r8);
        return;
    L13:
        r8 = Math.min(r8, r9);
        goto L14
    L7:
        r0 = Math.min(r0, r7);
        goto L8
    }

    public HollowTextView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public HollowTextView(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        this.e = 15;
        this.f = -1711276033;
        this.g = 0;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = false;
        TypedArray r5 = r2.obtainStyledAttributes(r3, new int[]{R.attr.textSize, R.attr.text, R.attr.radius, 2130969557, 2130970377, 2130970378, 2130970390, 2130970391});
        this.e = (int) r5.getDimension(0, n0.a(r2, 15.0f));
        this.a = r5.getString(1);
        this.f = r5.getColor(3, 0);
        this.g = (int) r5.getDimension(2, 0.0f);
        this.h = r5.getBoolean(6, false);
        this.i = r5.getBoolean(7, false);
        this.j = r5.getBoolean(4, false);
        this.k = r5.getBoolean(5, false);
        r5.recycle();
        a();
    }
}
