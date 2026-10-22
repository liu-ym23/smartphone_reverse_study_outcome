package com.bytedance.android.livesdk.livecommerce.view;

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
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.widget.price.PriceView;
import com.bytedance.android.livesdk.livecommerce.utils.w0;
import ol2.b;
import ol2.c;
import ol2.d;
import ol2.e;
import ol2.f;
import ol2.g;
import ol2.h;
import ol2.i;
import ol2.j;
import ol2.k;
import ol2.l;
import ol2.m;
import ol2.n;
import ol2.o;
import ol2.p;
import ol2.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class ECPriceView extends PriceView {
    public static final /* synthetic */ int M = 0;
    public float A;
    public float B;
    public final float C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public float I;
    public float J;
    public boolean K;
    public Boolean L;
    public Paint c;
    public Paint d;
    public Paint e;
    public final Paint f;
    public int g;
    public String h;
    public boolean i;
    public String j;
    public String k;
    public String l;
    public String m;
    public float n;
    public float o;
    public float p;
    public float q;
    public float r;
    public float s;
    public boolean t;
    public String u;
    public float v;
    public Paint w;
    public String x;
    public float y;
    public Paint z;

    public final void E() {
        if (TextUtils.isEmpty(this.h) == true) goto L6;
        Rect r0 = new Rect();
        Paint r1 = this.c;
        String r2 = this.h;
        r1.getTextBounds(r2, 0, r2.length(), r0);
        this.I = r0.width();
        r0.height();
        return;
    }

    public final boolean x() {
        if (this.L != null) goto L6;
        this.L = Boolean.valueOf(ECSettingKeys.J0());
    L6:
        return this.L.booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public float getCalculateViewWidth() {
        if (x() == false) goto L6;
        TextView r0 = getBuilder().b;
        return ((r0.getPaint().measureText(r0.getText().toString()) + r0.getPaddingLeft()) + r0.getPaddingRight()) + 0.5f;
    L6:
        float r2 = 0.0f;
        if (TextUtils.isEmpty(this.j) == true) goto L11;
        float r1 = this.d.measureText(this.j);
        if (TextUtils.isEmpty(this.k) == true) goto L13;
        r1 = r1 + this.e.measureText(this.k);
    L13:
        if (TextUtils.isEmpty(this.l) == true) goto L18;
        float r3 = this.d.measureText(this.l);
        if (TextUtils.isEmpty(this.m) == true) goto L17;
        r3 = r3 + this.e.measureText(this.m);
    L17:
        float r4 = r3 + this.A;
    L20:
        if (this.i == false) goto L22;
        float r5 = 0.0f;
    L27:
        if (TextUtils.isEmpty(this.u) == true) goto L29;
        float r6 = this.w.measureText(this.u) + this.B;
    L31:
        if (TextUtils.isEmpty(this.x) == true) goto L34;
        r2 = this.z.measureText(this.x);
    L34:
        return ((((((r5 + r1) + r4) + r6) + r2) + getPaddingRight()) + getPaddingLeft()) + 0.5f;
    L29:
        r6 = 0.0f;
        goto L31
    L22:
        if (this.I != 0.0f) goto L24;
        E();
    L24:
        r5 = this.I + this.A;
        goto L27
    L18:
        r4 = 0.0f;
        goto L20
    L11:
        r1 = 0.0f;
        goto L13
    }

    public ECPriceView(Context r4) {
        super(r4);
        this.f = new Paint();
        this.g = -364470;
        this.i = false;
        float r1 = w0.b(20.0f);
        this.o = r1;
        this.q = r1;
        this.s = 8.0f;
        this.t = false;
        this.A = w0.a(2.0f);
        this.B = w0.a(2.0f);
        this.C = w0.b(1.0f);
        this.I = 0.0f;
        this.J = 0.0f;
        this.K = false;
        this.L = null;
        D(r4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void draw(Canvas r13) {
        super/*android.widget.TextView*/.draw(r13);
        if (x() == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(this.h) == true) goto L7;
    L8:
        float r0 = getHeight();
        Paint.FontMetrics r1 = this.c.getFontMetrics();
        Paint.FontMetrics r2 = this.d.getFontMetrics();
        this.e.getFontMetrics();
        if (this.n <= this.o) goto L11;
        float r3 = getPaddingTop();
        float r4 = r1.descent;
        float r5 = (r3 + (((r0 + r4) - r1.ascent) / 2.0f)) - r4;
    L12:
        float r6 = getPaddingLeft();
        if (TextUtils.isEmpty(this.u) == true) goto L20;
        if (this.K == false) goto L17;
        float r7 = r5 - w0.a(0.7f);
    L18:
        r13.drawText(this.u, r6, r7, this.w);
        r6 = r6 + (this.w.measureText(this.u) + this.B);
        goto L20
    L17:
        r7 = r5;
    L20:
        if (this.i == true) goto L25;
        if (TextUtils.isEmpty(this.h) == true) goto L25;
        r13.drawText(this.h, r6, r5, this.c);
        r6 = r6 + (this.I + this.A);
    L25:
        if (TextUtils.isEmpty(this.j) == true) goto L30;
        float r8 = this.d.measureText(this.j);
        r13.drawText(this.j, r6, r5, this.d);
        r6 = r6 + r8;
        if (TextUtils.isEmpty(this.k) == true) goto L30;
        float r9 = this.e.measureText(this.k);
        r13.drawText(this.k, r6, r5, this.e);
        r6 = r6 + r9;
    L30:
        if (TextUtils.isEmpty(this.l) == true) goto L35;
        float r10 = r6 + this.A;
        float r11 = this.d.measureText(this.l);
        r13.drawText(this.l, r10, r5, this.d);
        r6 = r10 + r11;
        if (TextUtils.isEmpty(this.m) == true) goto L35;
        float r12 = this.e.measureText(this.m);
        r13.drawText(this.m, r6, r5, this.e);
        r6 = r6 + r12;
    L35:
        if (TextUtils.isEmpty(this.x) == true) goto L38;
        r13.drawText(this.x, r6, r5, this.z);
    L38:
        if (this.G == false) goto L43;
        this.f.setColor(this.g);
        this.f.setStrokeWidth(this.C);
        r13.drawLine(3.0f, getMeasuredHeight() / 2.0f, getMeasuredWidth(), getMeasuredHeight() / 2.0f, this.f);
        return;
    L43:
        return;
    L11:
        float r14 = getPaddingTop();
        float r15 = r2.descent;
        r5 = (r14 + (((r0 + r15) - r2.ascent) / 2.0f)) - r15;
        goto L12
    L7:
        if (TextUtils.isEmpty(this.j) == false) goto L8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setAlignPrefixToBaseline(boolean r1) {
        this.K = r1;
        requestLayout();
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setAutoResizeByMeasureWidth(final boolean r2) {
        if (x() == false) goto L5;
        C(new n(r2));
        return;
    L5:
        this.t = r2;
        requestLayout();
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setHideYang(final boolean r2) {
        if (x() == false) goto L5;
        C(new p(r2));
        return;
    L5:
        this.i = r2;
        requestLayout();
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setMaxPriceText(final String r5) {
        if (x() == false) goto L6;
        C(new q(r5));
        return;
    L6:
        if (TextUtils.isEmpty(r5) == false) goto L8;
        this.l = null;
        this.m = null;
    L14:
        requestLayout();
        invalidate();
        return;
    L8:
        if (this.H == true) goto L10;
    L12:
        this.l = "-" + r5;
        this.m = null;
        goto L14
    L10:
        if (r5.contains(".") == false) goto L12;
        int r0 = r5.indexOf(".");
        this.l = "-" + r5.substring(0, r0);
        this.m = r5.substring(r0);
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setMaxWidth(float r4) {
        if (x() == false) goto L10;
        if (r4 <= 0.0f) goto L7;
        super.setMaxWidth(r4);
    L8:
        C(new h());
        return;
    L7:
        super/*android.widget.TextView*/.setMaxWidth(Integer.MAX_VALUE);
        goto L8
    L10:
        if (x() == true) goto L12;
        float r0 = this.d.getTextSize();
        float r2 = this.o;
        if (r0 >= r2) goto L17;
        setPriceTextSize(r2);
    L17:
        float r1 = this.c.getTextSize();
        float r3 = this.n;
        if (r1 >= r3) goto L20;
        setYangTextSize(r3);
    L20:
        float r5 = this.w.getTextSize();
        float r6 = this.v;
        if (r5 >= r6) goto L23;
        setPrefixTextSize(r6);
    L23:
        float r7 = this.z.getTextSize();
        float r8 = this.y;
        if (r7 >= r8) goto L26;
        setSuffixTextSize(r8);
    L26:
        this.J = 0.0f;
    L27:
        this.J = r4;
        requestLayout();
        invalidate();
        return;
    L12:
        if (this.J == 0.0f) goto L27;
        setMaxWidth(0);
        goto L27
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setPrefixSpaceSize(final float r2) {
        if (x() == false) goto L5;
        C(new e(r2));
        return;
    L5:
        this.B = r2;
        requestLayout();
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setPrefixText(final String r2) {
        if (x() == false) goto L5;
        C(new k(r2));
        return;
    L5:
        this.u = r2;
        requestLayout();
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setPrefixTextSize(final float r2) {
        if (x() == false) goto L5;
        C(new i(r2));
        return;
    L5:
        this.v = r2;
        this.w.setTextSize(r2);
        requestLayout();
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setPriceBold(boolean r2) {
        this.D = r2;
        this.E = r2;
        if (r2 == false) goto L6;
        this.d.setTypeface(Typeface.DEFAULT_BOLD);
    L6:
        if (this.E == false) goto L8;
        this.e.setTypeface(Typeface.DEFAULT_BOLD);
    L8:
        requestLayout();
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setPriceDecimalTextSize(final float r2) {
        if (x() == false) goto L5;
        C(new b(r2));
        return;
    L5:
        this.p = r2;
        requestLayout();
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setPriceText(final String r3) {
        if (x() == false) goto L6;
        C(new o(r3));
        return;
    L6:
        if (TextUtils.isEmpty(r3) == false) goto L8;
        return;
    L8:
        if (this.H == true) goto L10;
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
        this.g = r2;
        C(new m(r2));
        return;
    L5:
        this.g = r2;
        this.w.setColor(r2);
        this.c.setColor(this.g);
        this.z.setColor(this.g);
        this.d.setColor(this.g);
        this.e.setColor(this.g);
        this.f.setColor(this.g);
        this.w.setColor(this.g);
        requestLayout();
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setPriceTextSize(final float r3) {
        if (x() == false) goto L5;
        C(new l(r3));
        return;
    L5:
        this.o = r3;
        this.d.setTextSize(r3);
        if (this.H == false) goto L8;
        this.e.setTextSize((r3 * 2.0f) / 3.0f);
    L9:
        requestLayout();
        invalidate();
        return;
    L8:
        this.e.setTextSize(r3);
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setSpaceSize(final float r2) {
        if (x() == false) goto L5;
        C(new g(r2));
        return;
    L5:
        this.A = r2;
        requestLayout();
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setSuffixText(final String r2) {
        if (x() == false) goto L5;
        C(new f(r2));
        return;
    L5:
        this.x = r2;
        requestLayout();
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setSuffixTextSize(final float r2) {
        if (x() == false) goto L5;
        C(new c(r2));
        return;
    L5:
        this.y = r2;
        this.z.setTextSize(r2);
        requestLayout();
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setYangTextSize(final float r2) {
        if (x() == false) goto L5;
        C(new d(this, r2));
        return;
    L5:
        this.n = r2;
        this.c.setTextSize(r2);
        requestLayout();
        invalidate();
    }

    public ECPriceView(Context r4, AttributeSet r5) {
        super(r4, r5);
        this.f = new Paint();
        this.g = -364470;
        this.i = false;
        float r1 = w0.b(20.0f);
        this.o = r1;
        this.q = r1;
        this.s = 8.0f;
        this.t = false;
        this.A = w0.a(2.0f);
        this.B = w0.a(2.0f);
        this.C = w0.b(1.0f);
        this.I = 0.0f;
        this.J = 0.0f;
        this.K = false;
        this.L = null;
        D(r4, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void D(Context r5, AttributeSet r6) {
        if (r6 == null) goto L5;
        TypedArray r7 = getContext().obtainStyledAttributes(r6, new int[]{2130968874, 2130970016, 2130970017, 2130970018, 2130970211, 2130972703, 2130972759, 2130972819, 2130973590, 2130973591, 2130973592, 2130973593, 2130973594, 2130973600, 2130973601, 2130973602, 2130973603, 2130973604, 2130973605, 2130974058, 2130974116, 2130974336, 2130974556, 2130975167});
        this.j = r7.getString(15);
        this.g = r7.getColor(16, -364470);
        this.l = r7.getString(5);
        this.o = r7.getDimension(17, this.o);
        this.p = r7.getDimension(14, 0.0f);
        this.n = r7.getDimension(23, 0.0f);
        this.i = r7.getBoolean(4, false);
        this.A = r7.getDimension(20, this.A);
        boolean r1 = r7.getBoolean(13, false);
        this.D = r1;
        this.E = r1;
        this.F = r1;
        this.G = r7.getBoolean(19, this.G);
        this.H = r7.getBoolean(22, false);
        this.v = r7.getDimension(12, this.o);
        this.B = r7.getDimension(8, this.B);
        this.y = r7.getDimension(21, this.o);
        this.J = r7.getDimension(18, this.J);
        this.s = r7.getDimension(6, 8.0f);
        this.t = r7.getBoolean(0, false);
        r7.recycle();
        this.r = this.n;
    L5:
        this.g = -119723;
        if (x() == false) goto L10;
        C(new j(this));
        float r8 = this.J;
        if (r8 <= 0.0f) goto L36;
        setMaxWidth(r8);
        return;
    L36:
        return;
    L10:
        setPriceText(this.j);
        setMaxPriceText(this.l);
        if (this.p != 0.0f) goto L14;
        this.p = (this.o * 2.0f) / 3.0f;
    L14:
        if (this.n != 0.0f) goto L16;
        float r9 = (this.o * 2.0f) / 3.0f;
        this.n = r9;
        this.r = r9;
    L16:
        this.h = r5.getString(2131896680);
        Paint r10 = new Paint();
        this.c = r10;
        r10.setTextSize(this.n);
        this.c.setColor(this.g);
        this.c.setAntiAlias(true);
        if (this.F == false) goto L19;
        this.c.setTypeface(Typeface.DEFAULT_BOLD);
    L19:
        Paint r11 = new Paint();
        this.d = r11;
        r11.setTextSize(this.o);
        this.d.setColor(this.g);
        this.d.setAntiAlias(true);
        if (this.D == false) goto L22;
        this.d.setTypeface(Typeface.DEFAULT_BOLD);
    L22:
        Paint r12 = new Paint();
        this.e = r12;
        if (this.H == false) goto L25;
        r12.setTextSize(this.p);
    L26:
        this.e.setColor(this.g);
        this.e.setAntiAlias(true);
        if (this.E == false) goto L29;
        this.e.setTypeface(Typeface.DEFAULT_BOLD);
    L29:
        Paint r13 = new Paint();
        this.w = r13;
        r13.setColor(this.g);
        this.w.setTextSize(this.v);
        this.w.setAntiAlias(true);
        if (this.D == false) goto L32;
        this.w.setTypeface(Typeface.DEFAULT);
    L32:
        Paint r14 = new Paint();
        this.z = r14;
        r14.setColor(this.g);
        this.z.setTextSize(this.y);
        this.z.setAntiAlias(true);
        if (this.D == false) goto L38;
        this.z.setTypeface(Typeface.DEFAULT);
        return;
    L38:
        return;
    L25:
        r12.setTextSize(this.o);
        goto L26
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r5, int r6) {
        if (x() == false) goto L5;
        super.onMeasure(r5, r6);
        return;
    L5:
        E();
        int r0 = View.MeasureSpec.getMode(r5);
        int r7 = TextView.getDefaultSize(getMinimumWidth(), r5);
        int r1 = (int) getCalculateViewWidth();
        if (r0 != 1073741824) goto L11;
        if (this.t == true) goto L11;
    L30:
        int r2 = View.MeasureSpec.getMode(r6);
        int r8 = TextView.getDefaultSize(getMinimumHeight(), r6);
        if (r2 == 1073741824) goto L37;
        float r3 = ((this.o + getPaddingBottom()) + getPaddingTop()) + 0.5f;
        if (r8 != 0) goto L36;
        r8 = Math.round(r3);
        goto L37
    L36:
        r8 = Math.round(Math.min(r3, r8));
    L37:
        setMeasuredDimension(r7, r8);
        return;
    L11:
        if (this.t == false) goto L13;
        this.J = r7;
    L13:
        float r4 = this.J;
        if (r4 > 0.0f) goto L16;
    L27:
        if (r7 != 0) goto L29;
        r7 = r1;
        goto L30
    L29:
        r7 = Math.min(r1, r7);
        goto L30
    L16:
        if (r1 <= r4) goto L27;
        this.q = this.o;
    L19:
        if (r1 <= this.J) goto L27;
        float r9 = this.q;
        if (r9 <= this.s) goto L27;
        float r10 = r9 - 1.0f;
        this.q = r10;
        if (this.H == false) goto L25;
        this.r = (2.0f * r10) / 3.0f;
    L26:
        this.d.setTextSize(r10);
        this.e.setTextSize(this.r);
        this.c.setTextSize(this.r);
        this.w.setTextSize(this.q);
        this.z.setTextSize(this.r);
        r1 = (int) getCalculateViewWidth();
        goto L19
    L25:
        this.r = r10;
        goto L26
    }

    public ECPriceView(Context r3, AttributeSet r4, int r5) {
        super(r3, r4, r5);
        this.f = new Paint();
        this.g = -364470;
        this.i = false;
        float r0 = w0.b(20.0f);
        this.o = r0;
        this.q = r0;
        this.s = 8.0f;
        this.t = false;
        this.A = w0.a(2.0f);
        this.B = w0.a(2.0f);
        this.C = w0.b(1.0f);
        this.I = 0.0f;
        this.J = 0.0f;
        this.K = false;
        this.L = null;
        D(r3, r4);
    }
}
