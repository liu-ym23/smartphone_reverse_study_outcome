package com.bytedance.android.shopping.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.common.utility.UIUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class PriceView extends com.bytedance.android.ec.core.widget.price.PriceView {
    public static final /* synthetic */ int C = 0;
    public Boolean A;
    public String B;
    public Paint c;
    public Paint d;
    public Paint e;
    public final Paint f;
    public int g;
    public String h;
    public boolean i;
    public String j;
    public String k;
    public float l;
    public float m;
    public float n;
    public float o;
    public final float p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public float u;
    public String v;
    public float w;
    public int x;
    public Paint y;
    public float z;

    public class a extends AccessibilityDelegateCompat {
        public final /* synthetic */ PriceView a;

        public a(PriceView r1) {
            this.a = r1;
        }

        public final void onInitializeAccessibilityNodeInfo(View r2, AccessibilityNodeInfoCompat r3) {
            super.onInitializeAccessibilityNodeInfo(r2, r3);
            if (r3 != null) goto L5;
            return;
        L5:
            PriceView r4 = this.a;
            int r0 = PriceView.C;
            r3.setText(r4.D());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private float getCalculateViewWidth() {
        float r1 = 0.0f;
        if (TextUtils.isEmpty(this.j) == true) goto L12;
        float r0 = this.d.measureText(this.j);
        if (TextUtils.isEmpty(this.k) == true) goto L8;
        r0 = r0 + this.e.measureText(this.k);
    L8:
        if (TextUtils.isEmpty(null) == true) goto L14;
        r0 = r0 + this.d.measureText(null);
        if (TextUtils.isEmpty(null) == true) goto L14;
        r0 = r0 + this.e.measureText(null);
    L14:
        if (this.i == true) goto L16;
        float r2 = this.u + this.o;
    L18:
        if (TextUtils.isEmpty(this.v) == true) goto L21;
        r1 = this.y.measureText(this.v);
    L21:
        return ((((r2 + r0) + r1) + getPaddingRight()) + getPaddingLeft()) + 0.5f;
    L16:
        r2 = 0.0f;
        goto L18
    L12:
        r0 = 0.0f;
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String D() {
        if (TextUtils.isEmpty(this.j) == false) goto L5;
        return null;
    L5:
        StringBuilder r0 = new StringBuilder();
        if (TextUtils.isEmpty(this.B) == false) goto L12;
        Context r2 = getContext();
        if (this.s == false) goto L10;
        int r3 = 2131913940;
    L11:
        r0.append(r2.getString(r3));
    L13:
        r0.append(this.j);
        if (TextUtils.isEmpty(this.k) == true) goto L17;
        r0.append(this.k);
    L17:
        if (TextUtils.isEmpty(null) == false) goto L23;
        r0.append(getContext().getString(2131913847));
        if (TextUtils.isEmpty(this.v) == true) goto L22;
        r0.append(this.v);
    L22:
        return r0.toString();
    L23:
        throw null;
    L10:
        r3 = 2131913848;
        goto L11
    L12:
        r0.append(this.B);
        goto L13
    }

    public final boolean x() {
        if (this.A != null) goto L6;
        this.A = Boolean.valueOf(ECSettingKeys.J0());
    L6:
        return this.A.booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PriceView(Context r5) {
        super(r5);
        this.f = new Paint();
        this.g = -364470;
        this.i = false;
        this.m = UIUtils.sp2px(getContext(), 20.0f);
        this.o = UIUtils.dip2Px(getContext(), 5.0f);
        this.p = UIUtils.sp2px(getContext(), 1.0f);
        this.u = 0.0f;
        this.w = UIUtils.sp2px(getContext(), 10.0f);
        this.x = -364470;
        this.z = 0.0f;
        this.A = null;
        E(r5, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void draw(Canvas r13) {
        super/*android.widget.TextView*/.draw(r13);
        if (x() == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(this.h) == true) goto L8;
    L9:
        float r0 = getHeight();
        Paint.FontMetrics r1 = this.c.getFontMetrics();
        Paint.FontMetrics r2 = this.d.getFontMetrics();
        if (this.l <= this.m) goto L12;
        float r3 = getPaddingTop();
        float r4 = r1.descent;
        float r5 = (r3 + (((r0 + r4) - r1.ascent) / 2.0f)) - r4;
    L13:
        float r6 = getPaddingLeft();
        if (this.i == true) goto L19;
        if (TextUtils.isEmpty(this.h) == true) goto L19;
        r13.drawText(this.h, getPaddingLeft(), r5, this.c);
        r6 = r6 + (this.u + this.o);
    L19:
        if (TextUtils.isEmpty(this.j) == true) goto L36;
        r13.drawText(this.j, r6, r5, this.d);
        float r7 = this.d.measureText(this.j);
        if (TextUtils.isEmpty(this.k) == true) goto L23;
        float r8 = this.e.measureText(this.k);
    L25:
        if (TextUtils.isEmpty(this.k) == true) goto L28;
        r13.drawText(this.k, r6 + r7, r5, this.e);
    L28:
        if (TextUtils.isEmpty(null) == true) goto L33;
        float r9 = (r6 + r8) + r7;
        r13.drawText(null, r9, r5, this.d);
        if (TextUtils.isEmpty(null) == true) goto L36;
        r13.drawText(null, r9 + this.d.measureText(null), r5, this.e);
        goto L36
    L33:
        if (TextUtils.isEmpty(this.v) == true) goto L36;
        r13.drawText(this.v, (r6 + r8) + r7, r5, this.y);
        goto L36
    L23:
        r8 = 0.0f;
    L36:
        if (this.s == false) goto L40;
        this.f.setColor(this.g);
        this.f.setStrokeWidth(this.p);
        r13.drawLine(3.0f, getMeasuredHeight() / 2.0f, getMeasuredWidth(), getMeasuredHeight() / 2.0f, this.f);
        return;
    L40:
        return;
    L12:
        float r10 = getPaddingTop();
        float r11 = r2.descent;
        r5 = (r10 + (((r0 + r11) - r2.ascent) / 2.0f)) - r11;
        goto L13
    L8:
        if (TextUtils.isEmpty(this.j) == false) goto L9;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setExtraText(final String r2) {
        if (x() == false) goto L5;
        C(new l(r2));
        return;
    L5:
        this.v = r2;
        requestLayout();
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setExtraTextColor(final int r2) {
        if (x() == false) goto L5;
        C(new i(r2));
        return;
    L5:
        this.x = r2;
        this.y.setColor(r2);
        requestLayout();
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setHideYang(final boolean r2) {
        if (x() == false) goto L5;
        C(new o(r2));
        return;
    L5:
        this.i = r2;
        invalidate();
        requestLayout();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setMaxWidth(float r2) {
        if (x() == true) goto L5;
        this.z = r2;
        requestLayout();
        invalidate();
        return;
    L5:
        if (r2 <= 0.0f) goto L7;
        super.setMaxWidth(r2);
    L8:
        C(new d());
        return;
    L7:
        super/*android.widget.TextView*/.setMaxWidth(Integer.MAX_VALUE);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setPriceText(final String r3) {
        if (x() == false) goto L6;
        C(new e(r3));
        return;
    L6:
        if (TextUtils.isEmpty(r3) == false) goto L8;
        return;
    L8:
        if (this.t == true) goto L10;
    L12:
        this.j = r3;
        this.k = null;
    L13:
        requestLayout();
        invalidate();
        return;
    L10:
        if (r3.contains(".") == false) goto L12;
        int r0 = r3.indexOf(".");
        this.j = r3.substring(0, r0);
        this.k = r3.substring(r0);
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setPriceTextColor(final int r2) {
        if (x() == false) goto L5;
        C(new f(r2));
        return;
    L5:
        this.g = r2;
        this.c.setColor(r2);
        this.d.setColor(this.g);
        this.e.setColor(this.g);
        this.f.setColor(this.g);
        invalidate();
        requestLayout();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setShowDeleteLine(final boolean r2) {
        if (x() == false) goto L5;
        C(new h(r2));
        return;
    L5:
        this.s = r2;
        invalidate();
        requestLayout();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setSpaceSize(final float r2) {
        if (x() == false) goto L5;
        C(new g(r2));
        return;
    L5:
        this.o = r2;
        invalidate();
        requestLayout();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setThinDecimal(final boolean r2) {
        if (x() == false) goto L5;
        C(new k(this, r2));
        return;
    L5:
        this.t = r2;
        if (r2 == true) goto L8;
        this.e.setTextSize(this.m);
    L12:
        invalidate();
        requestLayout();
        return;
    L8:
        if (this.n != 0.0f) goto L10;
        this.n = this.m * 0.8f;
    L10:
        this.e.setTextSize(this.n);
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setYangBold(final boolean r2) {
        if (x() == false) goto L5;
        C(new m(r2));
        return;
    L5:
        this.r = r2;
        if (r2 == false) goto L8;
        this.c.setTypeface(Typeface.DEFAULT_BOLD);
    L8:
        requestLayout();
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setYangTextSize(final float r2) {
        if (x() == false) goto L5;
        C(new n(this, r2));
        return;
    L5:
        this.l = r2;
        this.c.setTextSize(r2);
        requestLayout();
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setupCustomPrefix4ContentDescription(String r2) {
        if (x() == true) goto L6;
        this.B = r2;
        setContentDescription(D());
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PriceView(Context r5, AttributeSet r6) {
        super(r5, r6);
        this.f = new Paint();
        this.g = -364470;
        this.i = false;
        this.m = UIUtils.sp2px(getContext(), 20.0f);
        this.o = UIUtils.dip2Px(getContext(), 5.0f);
        this.p = UIUtils.sp2px(getContext(), 1.0f);
        this.u = 0.0f;
        this.w = UIUtils.sp2px(getContext(), 10.0f);
        this.x = -364470;
        this.z = 0.0f;
        this.A = null;
        E(r5, r6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void E(Context r7, AttributeSet r8) {
        if (r8 == null) goto L6;
        TypedArray r9 = getContext().obtainStyledAttributes(r8, new int[]{2130968874, 2130970016, 2130970017, 2130970018, 2130970211, 2130972703, 2130972759, 2130972819, 2130973590, 2130973591, 2130973592, 2130973593, 2130973594, 2130973600, 2130973601, 2130973602, 2130973603, 2130973604, 2130973605, 2130974058, 2130974116, 2130974336, 2130974556, 2130975167});
        this.j = r9.getString(15);
        this.g = r9.getColor(16, -364470);
        this.m = r9.getDimension(17, this.m);
        this.n = r9.getDimension(14, this.n);
        this.l = r9.getDimension(23, 0.0f);
        this.i = r9.getBoolean(4, false);
        this.o = r9.getDimension(20, this.o);
        this.q = r9.getBoolean(13, this.q);
        this.s = r9.getBoolean(19, this.s);
        this.t = r9.getBoolean(22, false);
        this.v = r9.getString(1);
        this.x = r9.getColor(2, -364470);
        this.w = r9.getDimension(3, this.w);
        this.z = r9.getDimension(18, this.z);
        r9.recycle();
    L6:
        if (x() == false) goto L10;
        C(new j(this));
        float r10 = this.z;
        if (r10 <= 0.0f) goto L31;
        setMaxWidth(r10);
        return;
    L31:
        return;
    L10:
        setFocusable(true);
        ViewCompat.setAccessibilityDelegate(this, new a(this));
        setPriceText(this.j);
        setWillNotDraw(false);
        if (this.l != 0.0f) goto L13;
        this.l = this.m * 0.8f;
    L13:
        this.h = r7.getString(2131913569);
        Paint r11 = new Paint();
        this.c = r11;
        r11.setTextSize(this.l);
        this.c.setColor(this.g);
        this.c.setAntiAlias(true);
        if (this.r == false) goto L16;
        this.c.setTypeface(Typeface.DEFAULT_BOLD);
    L16:
        Paint r12 = new Paint();
        this.d = r12;
        r12.setTextSize(this.m);
        this.d.setColor(this.g);
        this.d.setAntiAlias(true);
        if (this.q == false) goto L19;
        this.d.setTypeface(Typeface.DEFAULT_BOLD);
    L19:
        Paint r13 = new Paint();
        this.e = r13;
        if (this.t == true) goto L22;
        r13.setTextSize(this.m);
    L26:
        this.e.setColor(this.g);
        this.e.setAntiAlias(true);
        if (this.q == false) goto L29;
        this.e.setTypeface(Typeface.DEFAULT_BOLD);
    L29:
        Paint r14 = new Paint();
        this.y = r14;
        r14.setColor(this.x);
        this.y.setAntiAlias(true);
        this.y.setTextSize(this.w);
        return;
    L22:
        if (this.n != 0.0f) goto L24;
        this.n = this.m * 0.8f;
    L24:
        r13.setTextSize(this.n);
        goto L26
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r7, int r8) {
        if (x() == false) goto L6;
        super.onMeasure(r7, r8);
        return;
    L6:
        if (TextUtils.isEmpty(this.h) == true) goto L8;
        Rect r0 = new Rect();
        Paint r1 = this.c;
        String r2 = this.h;
        r1.getTextBounds(r2, 0, r2.length(), r0);
        this.u = r0.width();
    L8:
        int r3 = View.MeasureSpec.getMode(r7);
        int r9 = View.MeasureSpec.getSize(r7);
        if (r3 == 1073741824) goto L35;
        float r4 = getCalculateViewWidth();
        float r5 = this.z;
        if (r5 > 0.0f) goto L14;
    L32:
        if (r9 != 0) goto L34;
        r9 = (int) r4;
        goto L35
    L34:
        r9 = (int) Math.min(r4, r9);
        goto L35
    L14:
        if (r4 <= r5) goto L32;
    L16:
        if (r4 <= this.z) goto L32;
        float r6 = this.m;
        if (r6 <= 1.0f) goto L32;
        float r10 = r6 - 1.0f;
        if (r10 < 0.0f) goto L22;
        Paint r11 = this.d;
        this.m = r10;
        r11.setTextSize(r10);
    L22:
        float r12 = this.n - 1.0f;
        if (r12 < 0.0f) goto L25;
        Paint r13 = this.e;
        this.n = r12;
        r13.setTextSize(r12);
    L25:
        float r14 = this.l - 1.0f;
        if (r14 < 0.0f) goto L28;
        Paint r15 = this.c;
        this.l = r14;
        r15.setTextSize(r14);
    L28:
        float r16 = this.w - 1.0f;
        if (r16 < 0.0f) goto L31;
        Paint r17 = this.y;
        this.w = r16;
        r17.setTextSize(r16);
    L31:
        r4 = getCalculateViewWidth();
    L35:
        int r18 = View.MeasureSpec.getMode(r8);
        int r19 = TextView.getDefaultSize(getMinimumHeight(), r8);
        if (r18 == 1073741824) goto L42;
        float r20 = ((this.m + getPaddingBottom()) + getPaddingTop()) + 0.5f;
        if (r19 != 0) goto L41;
        r19 = Math.round(r20);
        goto L42
    L41:
        r19 = Math.round(Math.min(r20, r19));
    L42:
        setMeasuredDimension(r9, r19);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PriceView(Context r4, AttributeSet r5, int r6) {
        super(r4, r5, r6);
        this.f = new Paint();
        this.g = -364470;
        this.i = false;
        this.m = UIUtils.sp2px(getContext(), 20.0f);
        this.o = UIUtils.dip2Px(getContext(), 5.0f);
        this.p = UIUtils.sp2px(getContext(), 1.0f);
        this.u = 0.0f;
        this.w = UIUtils.sp2px(getContext(), 10.0f);
        this.x = -364470;
        this.z = 0.0f;
        this.A = null;
        E(r4, r5);
    }
}
