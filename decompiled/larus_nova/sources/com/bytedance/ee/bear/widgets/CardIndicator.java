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
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes18.dex */
public class CardIndicator extends View implements FixPageTransformerViewPager.e {
    public static final /* synthetic */ int B = 0;
    public int A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f240068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f240069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f240070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f240071d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f240072e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f240073f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f240074g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f240075h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f240076i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f240077j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f240078k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f240079l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f240080m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public FixPageTransformerViewPager f240081n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ViewPager2 f240082o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Paint f240083p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public a[] f240084q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public a[] f240085r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public a[][] f240086s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public a[] f240087t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f240088u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f240089v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f240090w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f240091x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ArgbEvaluator f240092y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f240093z;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f240094a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f240095b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f240096c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f240097d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f240098e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ CardIndicator f240099f;

        public a(CardIndicator r100, int r101, int r102) {
            this.f240099f = r100;
            this.f240094a = r101;
            this.f240095b = r102;
            this.f240096c = r102 + r101;
            this.f240097d = r100.f240077j / 2;
        }
    }

    public class b extends ViewPager2.OnPageChangeCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CardIndicator f240100a;

        public b(CardIndicator r100) {
            this.f240100a = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.viewpager.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public final void onPageScrollStateChanged(int r100) {
            this.f240100a.onPageScrollStateChanged(r100);
        }

        @Override // com.bytedance.ee.bear.widgets.viewpager.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public final void onPageSelected(int r100) {
            this.f240100a.onPageSelected(r100);
        }

        @Override // com.bytedance.ee.bear.widgets.viewpager.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public final void onPageScrolled(int r100, float r101, int r102) {
            this.f240100a.a(r100, r101);
        }
    }

    private int getCount() {
        FixPageTransformerViewPager r100 = this.f240081n;
        boolean r101 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        ViewPager2 r103 = this.f240082o;
        if (r103 != null) goto L15;
    L18:
        if (r101 == false) goto L20;
        return 0;
    L20:
        return this.f240082o.getAdapter().getItemCount();
    L15:
        if (r103.getAdapter() == null) goto L18;
        r101 = false;
        goto L18
    L11:
        return this.f240081n.getAdapter().b();
    L5:
        if (r100.getAdapter() == null) goto L8;
        r102 = false;
        goto L9
    }

    private int getCurrentItem() {
        FixPageTransformerViewPager r100 = this.f240081n;
        boolean r101 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        ViewPager2 r103 = this.f240082o;
        if (r103 != null) goto L15;
    L18:
        if (r101 == false) goto L20;
        return 0;
    L20:
        return this.f240082o.getCurrentItem();
    L15:
        if (r103.getAdapter() == null) goto L18;
        r101 = false;
        goto L18
    L11:
        return this.f240081n.getCurrentItem();
    L5:
        if (r100.getAdapter() == null) goto L8;
        r102 = false;
        goto L9
    }

    private int getHeightLinePos() {
        if (this.f240090w == true) goto L5;
    L17:
        int r100 = this.f240088u;
        if (r100 >= 4) goto L20;
        return r100;
    L20:
        if (r100 < 4) goto L25;
        if (r100 > (getCount() - 3)) goto L25;
        return 4;
    L25:
        if (this.f240088u != (getCount() - 2)) goto L27;
        return 5;
    L27:
        return 6;
    L5:
        if (this.f240089v == 0.0f) goto L17;
        int r101 = this.f240088u;
        if (r101 != 0) goto L9;
        return 1;
    L9:
        if (r101 < 4) goto L11;
        if (r101 >= 4) goto L14;
    L16:
        return 6;
    L14:
        if (r101 > (getCount() - 3)) goto L16;
        return 5;
    L11:
        return r101 + 1;
    }

    public final void d() {
        int r100 = 0;
        if (getCount() > 5) goto L10;
        int r101 = ((this.f240076i - (getCount() * this.f240070c)) - ((getCount() - 1) * this.f240073f)) / 2;
        this.f240084q = new a[getCount()];
    L6:
        if (r100 >= getCount()) goto L8;
        this.f240084q[r100] = new a(this, this.f240070c, r101);
        r101 = r101 + (this.f240070c + this.f240073f);
        r100 = r100 + 1;
        goto L6
    L8:
        this.f240085r = this.f240084q;
        return;
    L10:
        if (getCount() != 6) goto L12;
        this.f240086s = (a[][]) Array.newInstance(a.class, new int[]{getCount(), getCount()});
        this.f240084q = new a[getCount()];
        this.f240085r = new a[getCount()];
        this.f240086s[0][0] = new a(this, this.f240070c, this.f240078k);
        a[] r102 = this.f240086s[0];
        r102[1] = new a(this, this.f240070c, r102[0].f240096c + this.f240073f);
        a[] r103 = this.f240086s[0];
        r103[2] = new a(this, this.f240070c, r103[1].f240096c + this.f240073f);
        a[] r104 = this.f240086s[0];
        r104[3] = new a(this, this.f240071d, r104[2].f240096c + this.f240074g);
        a[] r105 = this.f240086s[0];
        r105[4] = new a(this, this.f240072e, r105[3].f240096c + this.f240075h);
        a[] r106 = this.f240086s[0];
        r106[5] = new a(this, 0, r106[4].f240096c + this.f240075h);
        a[][] r107 = this.f240086s;
        a[] r108 = r107[0];
        r107[1] = r108;
        r107[2] = r108;
        r107[3][0] = new a(this, this.f240071d, this.f240079l);
        a[] r109 = this.f240086s[3];
        r109[1] = new a(this, this.f240070c, r109[0].f240096c + this.f240074g);
        a[] r110 = this.f240086s[3];
        r110[2] = new a(this, this.f240070c, r110[1].f240096c + this.f240073f);
        a[] r111 = this.f240086s[3];
        r111[3] = new a(this, this.f240070c, r111[2].f240096c + this.f240073f);
        a[] r112 = this.f240086s[3];
        r112[4] = new a(this, this.f240071d, r112[3].f240096c + this.f240074g);
        a[] r113 = this.f240086s[3];
        r113[5] = new a(this, this.f240072e, r113[4].f240096c + this.f240075h);
        this.f240086s[4][0] = new a(this, this.f240072e, this.f240079l);
        a[] r114 = this.f240086s[4];
        r114[1] = new a(this, this.f240071d, r114[0].f240096c + this.f240075h);
        a[] r115 = this.f240086s[4];
        r115[2] = new a(this, this.f240070c, r115[1].f240096c + this.f240074g);
        a[] r116 = this.f240086s[4];
        r116[3] = new a(this, this.f240070c, r116[2].f240096c + this.f240073f);
        a[] r117 = this.f240086s[4];
        r117[4] = new a(this, this.f240070c, r117[3].f240096c + this.f240073f);
        a[] r118 = this.f240086s[4];
        r118[5] = new a(this, this.f240071d, r118[4].f240096c + this.f240074g);
        this.f240086s[5][0] = new a(this, 0, this.f240079l - this.f240072e);
        this.f240086s[5][1] = new a(this, this.f240072e, this.f240078k);
        a[] r119 = this.f240086s[5];
        r119[2] = new a(this, this.f240071d, r119[1].f240096c + this.f240075h);
        a[] r120 = this.f240086s[5];
        r120[3] = new a(this, this.f240070c, r120[2].f240096c + this.f240074g);
        a[] r121 = this.f240086s[5];
        r121[4] = new a(this, this.f240070c, r121[3].f240096c + this.f240073f);
        a[] r122 = this.f240086s[5];
        r122[5] = new a(this, this.f240070c, r122[4].f240096c + this.f240073f);
        a[] r123 = this.f240086s[this.f240088u];
        this.f240084q = r123;
        this.f240085r = r123;
        return;
    L12:
        a[][] r124 = (a[][]) Array.newInstance(a.class, new int[]{7, 8});
        this.f240086s = r124;
        this.f240084q = new a[8];
        this.f240087t = new a[8];
        r124[0][0] = new a(this, this.f240070c, this.f240078k);
        a[] r125 = this.f240086s[0];
        r125[1] = new a(this, this.f240070c, r125[0].f240096c + this.f240073f);
        a[] r126 = this.f240086s[0];
        r126[2] = new a(this, this.f240070c, r126[1].f240096c + this.f240073f);
        a[] r127 = this.f240086s[0];
        r127[3] = new a(this, this.f240071d, r127[2].f240096c + this.f240074g);
        a[] r128 = this.f240086s[0];
        r128[4] = new a(this, this.f240072e, r128[3].f240096c + this.f240075h);
        a[] r129 = this.f240086s[0];
        r129[5] = new a(this, 0, r129[4].f240096c + this.f240075h);
        a[] r130 = this.f240086s[0];
        r130[6] = new a(this, 0, r130[5].f240096c + this.f240075h);
        a[] r131 = this.f240086s[0];
        r131[7] = new a(this, 0, r131[6].f240096c + this.f240075h);
        a[][] r132 = this.f240086s;
        a[] r133 = r132[0];
        r132[1] = r133;
        r132[2] = r133;
        r132[3][0] = new a(this, this.f240071d, this.f240079l);
        a[] r134 = this.f240086s[3];
        r134[1] = new a(this, this.f240070c, r134[0].f240096c + this.f240074g);
        a[] r135 = this.f240086s[3];
        r135[2] = new a(this, this.f240070c, r135[1].f240096c + this.f240073f);
        a[] r136 = this.f240086s[3];
        r136[3] = new a(this, this.f240070c, r136[2].f240096c + this.f240073f);
        a[] r137 = this.f240086s[3];
        r137[4] = new a(this, this.f240071d, r137[3].f240096c + this.f240074g);
        a[] r138 = this.f240086s[3];
        r138[5] = new a(this, this.f240072e, r138[4].f240096c + this.f240075h);
        a[] r139 = this.f240086s[3];
        r139[6] = new a(this, 0, r139[5].f240096c + this.f240075h);
        a[] r140 = this.f240086s[3];
        r140[7] = new a(this, 0, r140[6].f240096c + this.f240075h);
        this.f240086s[4][0] = new a(this, this.f240072e, this.f240080m);
        a[] r141 = this.f240086s[4];
        r141[1] = new a(this, this.f240071d, r141[0].f240096c + this.f240075h);
        a[] r142 = this.f240086s[4];
        r142[2] = new a(this, this.f240070c, r142[1].f240096c + this.f240074g);
        a[] r143 = this.f240086s[4];
        r143[3] = new a(this, this.f240070c, r143[2].f240096c + this.f240073f);
        a[] r144 = this.f240086s[4];
        r144[4] = new a(this, this.f240070c, r144[3].f240096c + this.f240073f);
        a[] r145 = this.f240086s[4];
        r145[5] = new a(this, this.f240071d, r145[4].f240096c + this.f240074g);
        a[] r146 = this.f240086s[4];
        r146[6] = new a(this, this.f240072e, r146[5].f240096c + this.f240075h);
        a[] r147 = this.f240086s[4];
        r147[7] = new a(this, 0, r147[6].f240096c + this.f240075h);
        this.f240086s[5][0] = new a(this, 0, this.f240080m - this.f240072e);
        this.f240086s[5][1] = new a(this, this.f240072e, this.f240079l);
        a[] r148 = this.f240086s[5];
        r148[2] = new a(this, this.f240071d, r148[1].f240096c + this.f240075h);
        a[] r149 = this.f240086s[5];
        r149[3] = new a(this, this.f240070c, r149[2].f240096c + this.f240074g);
        a[] r150 = this.f240086s[5];
        r150[4] = new a(this, this.f240070c, r150[3].f240096c + this.f240073f);
        a[] r151 = this.f240086s[5];
        r151[5] = new a(this, this.f240070c, r151[4].f240096c + this.f240073f);
        a[] r152 = this.f240086s[5];
        r152[6] = new a(this, this.f240071d, r152[5].f240096c + this.f240074g);
        a[] r153 = this.f240086s[5];
        r153[7] = new a(this, 0, r153[6].f240096c + this.f240075h);
        this.f240086s[6][0] = new a(this, 0, this.f240080m - this.f240072e);
        this.f240086s[6][1] = new a(this, 0, this.f240079l - this.f240072e);
        this.f240086s[6][2] = new a(this, this.f240072e, this.f240078k);
        a[] r154 = this.f240086s[6];
        r154[3] = new a(this, this.f240071d, r154[2].f240096c + this.f240075h);
        a[] r155 = this.f240086s[6];
        r155[4] = new a(this, this.f240070c, r155[3].f240096c + this.f240074g);
        a[] r156 = this.f240086s[6];
        r156[5] = new a(this, this.f240070c, r156[4].f240096c + this.f240073f);
        a[] r157 = this.f240086s[6];
        r157[6] = new a(this, this.f240070c, r157[5].f240096c + this.f240073f);
        a[] r158 = this.f240086s[6];
        r158[7] = new a(this, 0, r158[6].f240096c + this.f240075h);
        this.f240087t[0] = new a(this, 0, this.f240080m - this.f240070c);
        this.f240087t[1] = new a(this, this.f240072e, this.f240080m);
        a[] r159 = this.f240087t;
        r159[2] = new a(this, this.f240071d, r159[1].f240096c + this.f240075h);
        a[] r160 = this.f240087t;
        r160[3] = new a(this, this.f240070c, r160[2].f240096c + this.f240074g);
        a[] r161 = this.f240087t;
        r161[4] = new a(this, this.f240070c, r161[3].f240096c + this.f240073f);
        a[] r162 = this.f240087t;
        r162[5] = new a(this, this.f240070c, r162[4].f240096c + this.f240073f);
        a[] r163 = this.f240087t;
        r163[6] = new a(this, this.f240071d, r163[5].f240096c + this.f240074g);
        a[] r164 = this.f240087t;
        r164[7] = new a(this, this.f240072e, r164[6].f240096c + this.f240075h);
        a[] r165 = this.f240086s[getHeightLinePos()];
        this.f240084q = r165;
        this.f240085r = r165;
    }

    public void update() {
        int r100 = getCurrentItem();
        if (r100 < getCount()) goto L5;
        r100 = getCount() - 1;
    L5:
        this.f240088u = r100;
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

    public CardIndicator(Context r100) {
        this(r100, null);
    }

    public final int c(int r100) {
        Resources r101 = getResources();
        return (int) TypedValue.applyDimension(1, r100, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()));
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        if (getCount() <= 6) goto L6;
        this.f240091x = getHeightLinePos();
    L6:
        if (this.f240084q != null) goto L8;
        return;
    L8:
        int r100 = 0;
    L9:
        a[] r101 = this.f240084q;
        if (r100 >= r101.length) goto L37;
        if (this.f240090w == false) goto L19;
        int r102 = this.f240091x;
        if (r100 != (r102 - 1)) goto L16;
        r101[r100].f240098e = 1.0f - this.f240093z;
    L25:
        a r103 = r101[r100];
        a r104 = this.f240085r[r100];
        r103.getClass();
        int r105 = r103.f240095b;
        float r106 = r105;
        float r107 = r104.f240095b - r105;
        CardIndicator r108 = r103.f240099f;
        float r109 = r108.f240089v;
        float r111 = r106 + (r107 * r109);
        int r112 = r103.f240094a;
        float r113 = r112 + ((r104.f240094a - r112) * r109);
        Paint r114 = r108.f240083p;
        if (r113 != 0.0f) goto L28;
        Paint.Cap r115 = Paint.Cap.BUTT;
    L29:
        r114.setStrokeCap(r115);
        CardIndicator r116 = r103.f240099f;
        r103.f240099f.f240083p.setColor(((Integer) r116.f240092y.evaluate(r103.f240098e, Integer.valueOf(r116.f240069b), Integer.valueOf(r103.f240099f.f240068a))).intValue());
        CardIndicator r117 = r103.f240099f;
        if (r117.A != 11) goto L32;
        boolean r118 = true;
    L33:
        if (r118 == false) goto L35;
        float r119 = r103.f240097d;
        r110.drawLine(r111, r119, r111 + r113, r119, r117.f240083p);
    L36:
        r100 = r100 + 1;
        goto L9
    L35:
        float r120 = r103.f240097d;
        r110.drawLine(r120, r111, r120, r111 + r113, r117.f240083p);
        goto L36
    L32:
        r118 = false;
        goto L33
    L28:
        r115 = Paint.Cap.ROUND;
        goto L29
    L16:
        if (r100 != r102) goto L18;
        r101[r100].f240098e = this.f240093z;
        goto L25
    L18:
        r101[r100].f240098e = 0.0f;
        goto L25
    L19:
        int r121 = this.f240091x;
        if (r100 != (r121 + 1)) goto L22;
        r101[r100].f240098e = this.f240093z;
        goto L25
    L22:
        if (r100 != r121) goto L24;
        r101[r100].f240098e = 1.0f - this.f240093z;
        goto L25
    L24:
        r101[r100].f240098e = 0.0f;
        goto L25
    }

    @Override // com.bytedance.ee.bear.widgets.viewpager.FixPageTransformerViewPager.e
    public final void onPageScrollStateChanged(int r100) {
        tt5.a.b("Indicator", "onPageScrollStateChanged(),  state:" + r100);
        if (r100 != 0) goto L12;
        tt5.a.b("Indicator", "onPageScrollStateChanged(),  SCROLL_STATE_IDLE");
        if (getCount() != 6) goto L7;
        a[] r101 = this.f240086s[this.f240088u];
        this.f240085r = r101;
        this.f240084q = r101;
    L7:
        float r102 = 0.0f;
        this.f240089v = 0.0f;
        if (this.f240090w == false) goto L10;
        r102 = 1.0f;
    L10:
        this.f240093z = r102;
        invalidate();
        return;
    }

    @Override // com.bytedance.ee.bear.widgets.viewpager.FixPageTransformerViewPager.e
    public final void onPageSelected(int r100) {
        tt5.a.b("Indicator", "onPageSelected(),  position:" + r100);
        invalidate();
    }

    public void setViewPager(FixPageTransformerViewPager r100) {
        if (r100 != null) goto L4;
    L8:
        tt5.a.d("Indicator", "setViewPager(), viewPage is null || adapter == null");
        return;
    L4:
        if (r100.getAdapter() == null) goto L8;
        this.f240081n = r100;
        r100.b(this);
        update();
    }

    public void setViewPager2(ViewPager2 r100) {
        if (r100 != null) goto L4;
    L8:
        tt5.a.d("Indicator", "setViewPager(), viewPage is null || adapter == null");
        return;
    L4:
        if (r100.getAdapter() == null) goto L8;
        this.f240082o = r100;
        r100.registerOnPageChangeCallback(new b(this));
        update();
    }

    public CardIndicator(Context r100, AttributeSet r101) {
        this(r100, r101, -1);
    }

    @Override // com.bytedance.ee.bear.widgets.viewpager.FixPageTransformerViewPager.e
    public final void a(int r100, float r101) {
        int r102 = 0;
        if (r101 == 0.0f) goto L9;
        float r103 = this.f240089v;
        if (r101 == r103) goto L9;
        if (r101 <= r103) goto L8;
        boolean r104 = true;
    L10:
        this.f240090w = r104;
        tt5.a.b("Indicator", "onPageScrolled(), mDirection:" + this.f240090w + ", positionOffset:" + r101 + ", mProgress:" + this.f240089v);
        this.f240089v = r101;
        if (this.f240090w == false) goto L14;
        if (r101 != 0.0f) goto L14;
        r101 = 1.0f;
    L14:
        this.f240093z = r101;
        this.f240088u = r100;
        d();
        if (getCount() > 6) goto L31;
        if (this.f240090w == false) goto L29;
        int r105 = this.f240088u;
        if (r105 != 0) goto L25;
        if (this.f240089v == 0.0f) goto L23;
        r102 = 1;
    L23:
        this.f240091x = r102;
        goto L31
    L25:
        if (this.f240089v == 0.0f) goto L28;
        r105 = r105 + 1;
    L28:
        this.f240091x = r105;
        goto L31
    L29:
        this.f240091x = this.f240088u;
    L31:
        if (getCount() != 6) goto L38;
        if ((this.f240088u + 1) < getCount()) goto L35;
        int r106 = this.f240088u;
    L36:
        a[][] r107 = this.f240086s;
        this.f240085r = r107[r106];
        this.f240084q = r107[this.f240088u];
    L60:
        invalidate();
        return;
    L35:
        r106 = this.f240088u + 1;
        goto L36
    L38:
        if (getCount() <= 6) goto L60;
        int r108 = this.f240088u;
        if (r108 >= 2) goto L42;
        a[] r109 = this.f240086s[r108];
        this.f240084q = r109;
        this.f240085r = r109;
        goto L60
    L42:
        if (r108 != 2) goto L45;
        a[][] r110 = this.f240086s;
        this.f240084q = r110[r108];
        this.f240085r = r110[r108 + 1];
        goto L60
    L45:
        if (r108 != 3) goto L47;
        a[][] r111 = this.f240086s;
        this.f240084q = r111[r108];
        this.f240085r = r111[4];
        goto L60
    L47:
        if (r108 < 4) goto L52;
        if (r108 >= (getCount() - 3)) goto L52;
        this.f240084q = this.f240086s[4];
        this.f240085r = this.f240087t;
    L52:
        if (this.f240088u != (getCount() - 3)) goto L55;
        a[][] r112 = this.f240086s;
        this.f240084q = r112[4];
        this.f240085r = r112[5];
        goto L60
    L55:
        if (this.f240088u != (getCount() - 2)) goto L58;
        a[][] r113 = this.f240086s;
        this.f240084q = r113[5];
        this.f240085r = r113[6];
        goto L60
    L58:
        if (this.f240088u != (getCount() - 1)) goto L60;
        a[] r114 = this.f240086s[6];
        this.f240084q = r114;
        this.f240085r = r114;
        goto L60
    L8:
        r104 = false;
    L9:
        r104 = this.f240090w;
        goto L10
    }

    @Override // android.view.View
    public final void onMeasure(int r110, int r111) {
        super.onMeasure(r110, r111);
        boolean r100 = true;
        if (this.A != 11) goto L5;
        boolean r112 = true;
    L6:
        if (r112 == false) goto L8;
        int r113 = getMeasuredWidth();
    L9:
        this.f240076i = r113;
        if (this.A != 11) goto L12;
        boolean r114 = true;
    L13:
        if (r114 == false) goto L15;
        int r115 = getMeasuredHeight();
    L16:
        this.f240077j = r115;
        int r116 = this.f240076i;
        int r117 = this.f240070c * 3;
        int r101 = this.f240071d;
        int r102 = this.f240072e;
        int r103 = this.f240073f;
        int r104 = this.f240074g;
        int r105 = this.f240075h;
        this.f240078k = ((r116 - ((r117 + r101) + r102)) - (((r103 * 2) + r104) + r105)) / 2;
        int r118 = r117 + (r101 * 2);
        int r106 = r103 + r104;
        this.f240079l = ((r116 - (r118 + r102)) - ((r106 * 2) + r105)) / 2;
        this.f240080m = ((r116 - (r118 + (r102 * 2))) - ((r106 + r105) * 2)) / 2;
        FixPageTransformerViewPager r119 = this.f240081n;
        if (r119 != null) goto L19;
    L22:
        boolean r120 = true;
    L23:
        if (r120 == false) goto L33;
        ViewPager2 r121 = this.f240082o;
        if (r121 != null) goto L27;
    L30:
        boolean r122 = true;
    L31:
        if (r122 == false) goto L33;
    L34:
        if (r100 == false) goto L36;
        this.f240088u = 0;
        d();
        return;
    L36:
        update();
        return;
    L27:
        if (r121.getAdapter() == null) goto L30;
        r122 = false;
    L33:
        r100 = false;
        goto L34
    L19:
        if (r119.getAdapter() == null) goto L22;
        r120 = false;
        goto L23
    L15:
        r115 = getMeasuredWidth();
        goto L16
    L12:
        r114 = false;
        goto L13
    L8:
        r113 = getMeasuredHeight();
        goto L9
    L5:
        r112 = false;
        goto L6
    }

    public CardIndicator(Context r100, AttributeSet r110, int r111) {
        super(r100, r110, r111);
        int r112 = eu5.b.f474075a.getResources().getColor(R.color.text_title);
        int r101 = eu5.b.f474075a.getResources().getColor(R.color.text_disable);
        this.f240070c = c(10);
        this.f240071d = c(6);
        this.f240072e = c(3);
        int r102 = c(2);
        this.f240073f = c(8);
        this.f240074g = c(13);
        this.f240075h = c(13);
        this.f240090w = false;
        this.f240093z = 0.0f;
        this.A = 11;
        Paint r103 = new Paint();
        this.f240083p = r103;
        r103.setAntiAlias(true);
        this.f240083p.setDither(true);
        this.f240092y = new ArgbEvaluator();
        setOnClickListener(new l());
        TypedArray r104 = r100.obtainStyledAttributes(r110, new int[]{R.attr.defaultColor, R.attr.dividerWidth, R.attr.highLightColor, R.attr.indicator_orientation});
        this.f240068a = r104.getColor(2, r112);
        this.f240069b = r104.getColor(0, r101);
        int r113 = r104.getInt(3, r102);
        this.A = r104.getInt(3, 11);
        r104.recycle();
        this.f240083p.setColor(this.f240069b);
        this.f240083p.setStrokeWidth(r113);
    }
}
