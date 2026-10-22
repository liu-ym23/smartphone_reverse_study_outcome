package com.bytedance.ee.bear.widgets;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.bytedance.ee.bear.widgets.viewpager.FixPageTransformerViewPager;
import com.bytedance.ee.bear.widgets.viewpager.viewpager2.widget.ViewPager2;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class CardIndicator extends View implements FixPageTransformerViewPager.e {
    public static final /* synthetic */ int B = 0;
    public int A;
    public int a;
    public int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public FixPageTransformerViewPager n;
    public ViewPager2 o;
    public Paint p;
    public a[] q;
    public a[] r;
    public a[][] s;
    public a[] t;
    public int u;
    public float v;
    public boolean w;
    public int x;
    public ArgbEvaluator y;
    public float z;

    public class a {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public float e;
        public final /* synthetic */ CardIndicator f;

        public a(CardIndicator r1, int r2, int r3) {
            this.f = r1;
            this.a = r2;
            this.b = r3;
            this.c = r3 + r2;
            this.d = r1.j / 2;
        }
    }

    public class b extends ViewPager2.OnPageChangeCallback {
        public final /* synthetic */ CardIndicator a;

        public b(CardIndicator r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.viewpager.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public final void onPageScrollStateChanged(int r2) {
            this.a.onPageScrollStateChanged(r2);
        }

        @Override // com.bytedance.ee.bear.widgets.viewpager.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public final void onPageSelected(int r2) {
            this.a.onPageSelected(r2);
        }

        @Override // com.bytedance.ee.bear.widgets.viewpager.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public final void onPageScrolled(int r1, float r2, int r3) {
            this.a.a(r1, r2);
        }
    }

    private int getCount() {
        FixPageTransformerViewPager r0 = this.n;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        ViewPager2 r3 = this.o;
        if (r3 != null) goto L15;
    L18:
        if (r1 == false) goto L20;
        return 0;
    L20:
        return this.o.getAdapter().getItemCount();
    L15:
        if (r3.getAdapter() == null) goto L18;
        r1 = false;
        goto L18
    L11:
        return this.n.getAdapter().b();
    L5:
        if (r0.getAdapter() == null) goto L8;
        r2 = false;
        goto L9
    }

    private int getCurrentItem() {
        FixPageTransformerViewPager r0 = this.n;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        ViewPager2 r3 = this.o;
        if (r3 != null) goto L15;
    L18:
        if (r1 == false) goto L20;
        return 0;
    L20:
        return this.o.getCurrentItem();
    L15:
        if (r3.getAdapter() == null) goto L18;
        r1 = false;
        goto L18
    L11:
        return this.n.getCurrentItem();
    L5:
        if (r0.getAdapter() == null) goto L8;
        r2 = false;
        goto L9
    }

    private int getHeightLinePos() {
        if (this.w == true) goto L5;
    L17:
        int r0 = this.u;
        if (r0 >= 4) goto L20;
        return r0;
    L20:
        if (r0 < 4) goto L25;
        if (r0 > (getCount() - 3)) goto L25;
        return 4;
    L25:
        if (this.u != (getCount() - 2)) goto L27;
        return 5;
    L27:
        return 6;
    L5:
        if (this.v == 0.0f) goto L17;
        int r1 = this.u;
        if (r1 != 0) goto L9;
        return 1;
    L9:
        if (r1 < 4) goto L11;
        if (r1 >= 4) goto L14;
    L16:
        return 6;
    L14:
        if (r1 > (getCount() - 3)) goto L16;
        return 5;
    L11:
        return r1 + 1;
    }

    public final void d() {
        int r1 = 0;
        if (getCount() > 5) goto L10;
        int r0 = ((this.i - (getCount() * this.c)) - ((getCount() - 1) * this.f)) / 2;
        this.q = new a[getCount()];
    L6:
        if (r1 >= getCount()) goto L8;
        this.q[r1] = new a(this, this.c, r0);
        r0 = r0 + (this.c + this.f);
        r1 = r1 + 1;
        goto L6
    L8:
        this.r = this.q;
        return;
    L10:
        if (getCount() != 6) goto L12;
        this.s = (a[][]) Array.newInstance(a.class, new int[]{getCount(), getCount()});
        this.q = new a[getCount()];
        this.r = new a[getCount()];
        this.s[0][0] = new a(this, this.c, this.k);
        a[] r2 = this.s[0];
        r2[1] = new a(this, this.c, r2[0].c + this.f);
        a[] r3 = this.s[0];
        r3[2] = new a(this, this.c, r3[1].c + this.f);
        a[] r4 = this.s[0];
        r4[3] = new a(this, this.d, r4[2].c + this.g);
        a[] r5 = this.s[0];
        r5[4] = new a(this, this.e, r5[3].c + this.h);
        a[] r6 = this.s[0];
        r6[5] = new a(this, 0, r6[4].c + this.h);
        a[][] r7 = this.s;
        a[] r8 = r7[0];
        r7[1] = r8;
        r7[2] = r8;
        r7[3][0] = new a(this, this.d, this.l);
        a[] r9 = this.s[3];
        r9[1] = new a(this, this.c, r9[0].c + this.g);
        a[] r10 = this.s[3];
        r10[2] = new a(this, this.c, r10[1].c + this.f);
        a[] r11 = this.s[3];
        r11[3] = new a(this, this.c, r11[2].c + this.f);
        a[] r12 = this.s[3];
        r12[4] = new a(this, this.d, r12[3].c + this.g);
        a[] r13 = this.s[3];
        r13[5] = new a(this, this.e, r13[4].c + this.h);
        this.s[4][0] = new a(this, this.e, this.l);
        a[] r14 = this.s[4];
        r14[1] = new a(this, this.d, r14[0].c + this.h);
        a[] r15 = this.s[4];
        r15[2] = new a(this, this.c, r15[1].c + this.g);
        a[] r16 = this.s[4];
        r16[3] = new a(this, this.c, r16[2].c + this.f);
        a[] r17 = this.s[4];
        r17[4] = new a(this, this.c, r17[3].c + this.f);
        a[] r18 = this.s[4];
        r18[5] = new a(this, this.d, r18[4].c + this.g);
        this.s[5][0] = new a(this, 0, this.l - this.e);
        this.s[5][1] = new a(this, this.e, this.k);
        a[] r19 = this.s[5];
        r19[2] = new a(this, this.d, r19[1].c + this.h);
        a[] r20 = this.s[5];
        r20[3] = new a(this, this.c, r20[2].c + this.g);
        a[] r21 = this.s[5];
        r21[4] = new a(this, this.c, r21[3].c + this.f);
        a[] r22 = this.s[5];
        r22[5] = new a(this, this.c, r22[4].c + this.f);
        a[] r23 = this.s[this.u];
        this.q = r23;
        this.r = r23;
        return;
    L12:
        a[][] r24 = (a[][]) Array.newInstance(a.class, new int[]{7, 8});
        this.s = r24;
        this.q = new a[8];
        this.t = new a[8];
        r24[0][0] = new a(this, this.c, this.k);
        a[] r25 = this.s[0];
        r25[1] = new a(this, this.c, r25[0].c + this.f);
        a[] r26 = this.s[0];
        r26[2] = new a(this, this.c, r26[1].c + this.f);
        a[] r27 = this.s[0];
        r27[3] = new a(this, this.d, r27[2].c + this.g);
        a[] r28 = this.s[0];
        r28[4] = new a(this, this.e, r28[3].c + this.h);
        a[] r29 = this.s[0];
        r29[5] = new a(this, 0, r29[4].c + this.h);
        a[] r30 = this.s[0];
        r30[6] = new a(this, 0, r30[5].c + this.h);
        a[] r31 = this.s[0];
        r31[7] = new a(this, 0, r31[6].c + this.h);
        a[][] r32 = this.s;
        a[] r33 = r32[0];
        r32[1] = r33;
        r32[2] = r33;
        r32[3][0] = new a(this, this.d, this.l);
        a[] r34 = this.s[3];
        r34[1] = new a(this, this.c, r34[0].c + this.g);
        a[] r35 = this.s[3];
        r35[2] = new a(this, this.c, r35[1].c + this.f);
        a[] r36 = this.s[3];
        r36[3] = new a(this, this.c, r36[2].c + this.f);
        a[] r37 = this.s[3];
        r37[4] = new a(this, this.d, r37[3].c + this.g);
        a[] r38 = this.s[3];
        r38[5] = new a(this, this.e, r38[4].c + this.h);
        a[] r39 = this.s[3];
        r39[6] = new a(this, 0, r39[5].c + this.h);
        a[] r40 = this.s[3];
        r40[7] = new a(this, 0, r40[6].c + this.h);
        this.s[4][0] = new a(this, this.e, this.m);
        a[] r41 = this.s[4];
        r41[1] = new a(this, this.d, r41[0].c + this.h);
        a[] r42 = this.s[4];
        r42[2] = new a(this, this.c, r42[1].c + this.g);
        a[] r43 = this.s[4];
        r43[3] = new a(this, this.c, r43[2].c + this.f);
        a[] r44 = this.s[4];
        r44[4] = new a(this, this.c, r44[3].c + this.f);
        a[] r45 = this.s[4];
        r45[5] = new a(this, this.d, r45[4].c + this.g);
        a[] r46 = this.s[4];
        r46[6] = new a(this, this.e, r46[5].c + this.h);
        a[] r47 = this.s[4];
        r47[7] = new a(this, 0, r47[6].c + this.h);
        this.s[5][0] = new a(this, 0, this.m - this.e);
        this.s[5][1] = new a(this, this.e, this.l);
        a[] r48 = this.s[5];
        r48[2] = new a(this, this.d, r48[1].c + this.h);
        a[] r49 = this.s[5];
        r49[3] = new a(this, this.c, r49[2].c + this.g);
        a[] r50 = this.s[5];
        r50[4] = new a(this, this.c, r50[3].c + this.f);
        a[] r51 = this.s[5];
        r51[5] = new a(this, this.c, r51[4].c + this.f);
        a[] r52 = this.s[5];
        r52[6] = new a(this, this.d, r52[5].c + this.g);
        a[] r53 = this.s[5];
        r53[7] = new a(this, 0, r53[6].c + this.h);
        this.s[6][0] = new a(this, 0, this.m - this.e);
        this.s[6][1] = new a(this, 0, this.l - this.e);
        this.s[6][2] = new a(this, this.e, this.k);
        a[] r54 = this.s[6];
        r54[3] = new a(this, this.d, r54[2].c + this.h);
        a[] r55 = this.s[6];
        r55[4] = new a(this, this.c, r55[3].c + this.g);
        a[] r56 = this.s[6];
        r56[5] = new a(this, this.c, r56[4].c + this.f);
        a[] r57 = this.s[6];
        r57[6] = new a(this, this.c, r57[5].c + this.f);
        a[] r58 = this.s[6];
        r58[7] = new a(this, 0, r58[6].c + this.h);
        this.t[0] = new a(this, 0, this.m - this.c);
        this.t[1] = new a(this, this.e, this.m);
        a[] r59 = this.t;
        r59[2] = new a(this, this.d, r59[1].c + this.h);
        a[] r60 = this.t;
        r60[3] = new a(this, this.c, r60[2].c + this.g);
        a[] r61 = this.t;
        r61[4] = new a(this, this.c, r61[3].c + this.f);
        a[] r62 = this.t;
        r62[5] = new a(this, this.c, r62[4].c + this.f);
        a[] r63 = this.t;
        r63[6] = new a(this, this.d, r63[5].c + this.g);
        a[] r64 = this.t;
        r64[7] = new a(this, this.e, r64[6].c + this.h);
        a[] r65 = this.s[getHeightLinePos()];
        this.q = r65;
        this.r = r65;
    }

    public void update() {
        int r0 = getCurrentItem();
        if (r0 < getCount()) goto L5;
        r0 = getCount() - 1;
    L5:
        this.u = r0;
        if (getCount() > 1) goto L10;
        setVisibility(8);
        return;
    L10:
        if (getVisibility() == 4) goto L12;
        setVisibility(0);
    L12:
        d();
        invalidate();
    }

    public CardIndicator(Context r2) {
        this(r2, null);
    }

    public final int c(int r3) {
        Resources r0 = getResources();
        return (int) TypedValue.applyDimension(1, r3, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()));
    }

    @Override // android.view.View
    public final void onDraw(Canvas r17) {
        super.onDraw(r17);
        if (getCount() <= 6) goto L6;
        this.x = getHeightLinePos();
    L6:
        if (this.q != null) goto L8;
        return;
    L8:
        int r2 = 0;
    L9:
        a[] r3 = this.q;
        if (r2 >= r3.length) goto L37;
        if (this.w == false) goto L19;
        int r4 = this.x;
        if (r2 != (r4 - 1)) goto L16;
        r3[r2].e = 1.0f - this.z;
    L25:
        a r5 = r3[r2];
        a r6 = this.r[r2];
        r5.getClass();
        int r7 = r5.b;
        float r8 = r7;
        float r9 = r6.b - r7;
        CardIndicator r10 = r5.f;
        float r11 = r10.v;
        float r12 = r8 + (r9 * r11);
        int r13 = r5.a;
        float r14 = r13 + ((r6.a - r13) * r11);
        Paint r15 = r10.p;
        if (r14 != 0.0f) goto L28;
        Paint.Cap r16 = Paint.Cap.BUTT;
    L29:
        r15.setStrokeCap(r16);
        CardIndicator r18 = r5.f;
        r5.f.p.setColor(((Integer) r18.y.evaluate(r5.e, Integer.valueOf(r18.b), Integer.valueOf(r5.f.a))).intValue());
        CardIndicator r19 = r5.f;
        if (r19.A != 11) goto L32;
        boolean r20 = true;
    L33:
        if (r20 == false) goto L35;
        float r110 = r5.d;
        r17.drawLine(r12, r110, r12 + r14, r110, r19.p);
    L36:
        r2 = r2 + 1;
        goto L9
    L35:
        float r111 = r5.d;
        r17.drawLine(r111, r12, r111, r12 + r14, r19.p);
        goto L36
    L32:
        r20 = false;
        goto L33
    L28:
        r16 = Paint.Cap.ROUND;
        goto L29
    L16:
        if (r2 != r4) goto L18;
        r3[r2].e = this.z;
        goto L25
    L18:
        r3[r2].e = 0.0f;
        goto L25
    L19:
        int r21 = this.x;
        if (r2 != (r21 + 1)) goto L22;
        r3[r2].e = this.z;
        goto L25
    L22:
        if (r2 != r21) goto L24;
        r3[r2].e = 1.0f - this.z;
        goto L25
    L24:
        r3[r2].e = 0.0f;
        goto L25
    }

    @Override // com.bytedance.ee.bear.widgets.viewpager.FixPageTransformerViewPager.e
    public final void onPageScrollStateChanged(int r3) {
        tt5.a.b("Indicator", "onPageScrollStateChanged(),  state:" + r3);
        if (r3 != 0) goto L12;
        tt5.a.b("Indicator", "onPageScrollStateChanged(),  SCROLL_STATE_IDLE");
        if (getCount() != 6) goto L7;
        a[] r4 = this.s[this.u];
        this.r = r4;
        this.q = r4;
    L7:
        float r5 = 0.0f;
        this.v = 0.0f;
        if (this.w == false) goto L10;
        r5 = 1.0f;
    L10:
        this.z = r5;
        invalidate();
        return;
    }

    @Override // com.bytedance.ee.bear.widgets.viewpager.FixPageTransformerViewPager.e
    public final void onPageSelected(int r3) {
        tt5.a.b("Indicator", "onPageSelected(),  position:" + r3);
        invalidate();
    }

    public void setViewPager(FixPageTransformerViewPager r2) {
        if (r2 != null) goto L4;
    L8:
        tt5.a.d("Indicator", "setViewPager(), viewPage is null || adapter == null");
        return;
    L4:
        if (r2.getAdapter() == null) goto L8;
        this.n = r2;
        r2.b(this);
        update();
    }

    public void setViewPager2(ViewPager2 r2) {
        if (r2 != null) goto L4;
    L8:
        tt5.a.d("Indicator", "setViewPager(), viewPage is null || adapter == null");
        return;
    L4:
        if (r2.getAdapter() == null) goto L8;
        this.o = r2;
        r2.registerOnPageChangeCallback(new b(this));
        update();
    }

    public CardIndicator(Context r2, AttributeSet r3) {
        this(r2, r3, -1);
    }

    @Override // com.bytedance.ee.bear.widgets.viewpager.FixPageTransformerViewPager.e
    public final void a(int r7, float r8) {
        int r0 = 0;
        if (r8 == 0.0f) goto L9;
        float r4 = this.v;
        if (r8 == r4) goto L9;
        if (r8 <= r4) goto L8;
        boolean r5 = true;
    L10:
        this.w = r5;
        tt5.a.b("Indicator", "onPageScrolled(), mDirection:" + this.w + ", positionOffset:" + r8 + ", mProgress:" + this.v);
        this.v = r8;
        if (this.w == false) goto L14;
        if (r8 != 0.0f) goto L14;
        r8 = 1.0f;
    L14:
        this.z = r8;
        this.u = r7;
        d();
        if (getCount() > 6) goto L31;
        if (this.w == false) goto L29;
        int r9 = this.u;
        if (r9 != 0) goto L25;
        if (this.v == 0.0f) goto L23;
        r0 = 1;
    L23:
        this.x = r0;
        goto L31
    L25:
        if (this.v == 0.0f) goto L28;
        r9 = r9 + 1;
    L28:
        this.x = r9;
        goto L31
    L29:
        this.x = this.u;
    L31:
        if (getCount() != 6) goto L38;
        if ((this.u + 1) < getCount()) goto L35;
        int r10 = this.u;
    L36:
        a[][] r11 = this.s;
        this.r = r11[r10];
        this.q = r11[this.u];
    L60:
        invalidate();
        return;
    L35:
        r10 = this.u + 1;
        goto L36
    L38:
        if (getCount() <= 6) goto L60;
        int r12 = this.u;
        if (r12 >= 2) goto L42;
        a[] r13 = this.s[r12];
        this.q = r13;
        this.r = r13;
        goto L60
    L42:
        if (r12 != 2) goto L45;
        a[][] r14 = this.s;
        this.q = r14[r12];
        this.r = r14[r12 + 1];
        goto L60
    L45:
        if (r12 != 3) goto L47;
        a[][] r15 = this.s;
        this.q = r15[r12];
        this.r = r15[4];
        goto L60
    L47:
        if (r12 < 4) goto L52;
        if (r12 >= (getCount() - 3)) goto L52;
        this.q = this.s[4];
        this.r = this.t;
    L52:
        if (this.u != (getCount() - 3)) goto L55;
        a[][] r16 = this.s;
        this.q = r16[4];
        this.r = r16[5];
        goto L60
    L55:
        if (this.u != (getCount() - 2)) goto L58;
        a[][] r17 = this.s;
        this.q = r17[5];
        this.r = r17[6];
        goto L60
    L58:
        if (this.u != (getCount() - 1)) goto L60;
        a[] r18 = this.s[6];
        this.q = r18;
        this.r = r18;
        goto L60
    L8:
        r5 = false;
    L9:
        r5 = this.w;
        goto L10
    }

    @Override // android.view.View
    public final void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        boolean r0 = true;
        if (this.A != 11) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L8;
        int r13 = getMeasuredWidth();
    L9:
        this.i = r13;
        if (this.A != 11) goto L12;
        boolean r14 = true;
    L13:
        if (r14 == false) goto L15;
        int r15 = getMeasuredHeight();
    L16:
        this.j = r15;
        int r16 = this.i;
        int r17 = this.c * 3;
        int r2 = this.d;
        int r4 = this.e;
        int r5 = this.f;
        int r7 = this.g;
        int r8 = this.h;
        this.k = ((r16 - ((r17 + r2) + r4)) - (((r5 * 2) + r7) + r8)) / 2;
        int r18 = r17 + (r2 * 2);
        int r6 = r5 + r7;
        this.l = ((r16 - (r18 + r4)) - ((r6 * 2) + r8)) / 2;
        this.m = ((r16 - (r18 + (r4 * 2))) - ((r6 + r8) * 2)) / 2;
        FixPageTransformerViewPager r19 = this.n;
        if (r19 != null) goto L19;
    L22:
        boolean r110 = true;
    L23:
        if (r110 == false) goto L33;
        ViewPager2 r111 = this.o;
        if (r111 != null) goto L27;
    L30:
        boolean r112 = true;
    L31:
        if (r112 == false) goto L33;
    L34:
        if (r0 == false) goto L36;
        this.u = 0;
        d();
        return;
    L36:
        update();
        return;
    L27:
        if (r111.getAdapter() == null) goto L30;
        r112 = false;
    L33:
        r0 = false;
        goto L34
    L19:
        if (r19.getAdapter() == null) goto L22;
        r110 = false;
        goto L23
    L15:
        r15 = getMeasuredWidth();
        goto L16
    L12:
        r14 = false;
        goto L13
    L8:
        r13 = getMeasuredHeight();
        goto L9
    L5:
        r12 = false;
        goto L6
    }

    public CardIndicator(Context r9, AttributeSet r10, int r11) {
        super(r9, r10, r11);
        int r12 = eu5.b.a.getResources().getColor(2131106622);
        int r0 = eu5.b.a.getResources().getColor(2131106610);
        this.c = c(10);
        this.d = c(6);
        this.e = c(3);
        int r3 = c(2);
        this.f = c(8);
        this.g = c(13);
        this.h = c(13);
        this.w = false;
        this.z = 0.0f;
        this.A = 11;
        Paint r6 = new Paint();
        this.p = r6;
        r6.setAntiAlias(true);
        this.p.setDither(true);
        this.y = new ArgbEvaluator();
        setOnClickListener(new l());
        TypedArray r13 = r9.obtainStyledAttributes(r10, new int[]{2130969729, 2130969774, 2130970212, 2130970345});
        this.a = r13.getColor(2, r12);
        this.b = r13.getColor(0, r0);
        int r14 = r13.getInt(3, r3);
        this.A = r13.getInt(3, 11);
        r13.recycle();
        this.p.setColor(this.b);
        this.p.setStrokeWidth(r14);
    }
}
