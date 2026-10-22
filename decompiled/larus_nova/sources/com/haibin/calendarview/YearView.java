package com.haibin.calendarview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public abstract class YearView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f276118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f276119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f276120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f276121d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f276122e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f276123f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f276124g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f276125h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Paint f276126i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<Calendar> f276127j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f276128k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f276129l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f276130m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f276131n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f276132o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f276133p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f276134q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f276135r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f276136s;

    public abstract void b(Canvas r100, int r101, int r102, int r103);

    public abstract void c();

    public abstract void d();

    public abstract void e(Canvas r100, Calendar r101, int r102, int r103, boolean r104, boolean r105);

    public abstract void f(Canvas r100, int r101, int r102, int r103, int r104);

    private int getMonthViewTop() {
        l r100 = this.f276118a;
        return ((r100.f276198v + r100.f276192s) + r100.f276199w) + r100.f276194t;
    }

    public YearView(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        int r100 = getWidth();
        l r101 = this.f276118a;
        int r102 = r101.f276196u;
        this.f276129l = (r100 - (r102 * 2)) / 7;
        int r103 = this.f276134q;
        int r104 = r101.f276198v;
        getWidth();
        int r105 = this.f276118a.f276196u;
        b(r110, r103, r102, r104);
        l r106 = this.f276118a;
        if (r106.f276194t <= 0) goto L14;
        int r107 = r106.f276156a;
        if (r107 <= 0) goto L8;
        r107 = r107 - 1;
    L8:
        int r108 = (getWidth() - (this.f276118a.f276196u * 2)) / 7;
        int r111 = 0;
    L9:
        if (r111 >= 7) goto L14;
        l r109 = this.f276118a;
        f(r110, r107, r109.f276196u + (r111 * r108), (r109.f276192s + r109.f276198v) + r109.f276199w, r108);
        r107 = r107 + 1;
        if (r107 < 7) goto L13;
        r107 = 0;
    L13:
        r111 = r111 + 1;
    L14:
        int r112 = 0;
        int r113 = 0;
    L16:
        if (r112 >= this.f276136s) goto L40;
        int r114 = 0;
    L18:
        if (r114 >= 7) goto L39;
        Calendar r115 = (Calendar) ListProtector.get(this.f276127j, r113);
        if (r113 > (((ArrayList) this.f276127j).size() - this.f276135r)) goto L49;
        if (r115.isCurrentMonth() == false) goto L38;
        int r116 = (this.f276129l * r114) + this.f276118a.f276196u;
        int r117 = (this.f276128k * r112) + getMonthViewTop();
        boolean r118 = r115.equals(this.f276118a.f276183n0);
        boolean r119 = r115.hasScheme();
        if (r119 == false) goto L35;
        if (r118 == false) goto L29;
        d();
    L29:
        if (r118 == true) goto L37;
        Paint r120 = this.f276121d;
        if (r115.getSchemeColor() == 0) goto L33;
        int r121 = r115.getSchemeColor();
    L34:
        r120.setColor(r121);
        c();
        goto L37
    L33:
        r121 = this.f276118a.I;
    L37:
        e(r110, r115, r116, r117, r119, r118);
        goto L38
    L35:
        if (r118 == false) goto L37;
        d();
    L38:
        r113 = r113 + 1;
        r114 = r114 + 1;
        goto L18
    L49:
        return;
    L39:
        r112 = r112 + 1;
        goto L16
    }

    public final void setup(l r100) {
        this.f276118a = r100;
        this.f276119b.setTextSize(r100.f276188q);
        this.f276122e.setTextSize(r100.f276188q);
        this.f276120c.setTextSize(r100.f276188q);
        this.f276124g.setTextSize(r100.f276188q);
        this.f276123f.setTextSize(r100.f276188q);
        this.f276122e.setColor(r100.f276202z);
        this.f276119b.setColor(r100.f276201y);
        this.f276120c.setColor(r100.f276201y);
        this.f276124g.setColor(r100.B);
        this.f276123f.setColor(r100.A);
        this.f276125h.setTextSize(r100.f276186p);
        this.f276125h.setColor(r100.f276200x);
        this.f276126i.setColor(r100.C);
        this.f276126i.setTextSize(r100.f276190r);
    }

    public YearView(Context r110, AttributeSet r111) {
        super(r110, r111);
        Paint r100 = new Paint();
        this.f276119b = r100;
        Paint r101 = new Paint();
        this.f276120c = r101;
        Paint r102 = new Paint();
        Paint r103 = new Paint();
        Paint r104 = new Paint();
        Paint r105 = new Paint();
        Paint r106 = new Paint();
        this.f276121d = r106;
        Paint r107 = new Paint();
        Paint r108 = new Paint();
        this.f276122e = r108;
        Paint r112 = new Paint();
        this.f276123f = r112;
        Paint r113 = new Paint();
        this.f276124g = r113;
        Paint r114 = new Paint();
        Paint r115 = new Paint();
        this.f276125h = r115;
        Paint r116 = new Paint();
        this.f276126i = r116;
        r100.setAntiAlias(true);
        r100.setTextAlign(Paint.Align.CENTER);
        r100.setColor(-15658735);
        r100.setFakeBoldText(true);
        r101.setAntiAlias(true);
        r101.setTextAlign(Paint.Align.CENTER);
        r101.setColor(-1973791);
        r101.setFakeBoldText(true);
        r102.setAntiAlias(true);
        r102.setTextAlign(Paint.Align.CENTER);
        r103.setAntiAlias(true);
        r103.setTextAlign(Paint.Align.CENTER);
        r104.setAntiAlias(true);
        r104.setTextAlign(Paint.Align.CENTER);
        r115.setAntiAlias(true);
        r115.setFakeBoldText(true);
        r116.setAntiAlias(true);
        r116.setFakeBoldText(true);
        r116.setTextAlign(Paint.Align.CENTER);
        r105.setAntiAlias(true);
        r105.setTextAlign(Paint.Align.CENTER);
        r108.setAntiAlias(true);
        r108.setStyle(Paint.Style.FILL);
        r108.setTextAlign(Paint.Align.CENTER);
        r108.setColor(-1223853);
        r108.setFakeBoldText(true);
        r112.setAntiAlias(true);
        r112.setStyle(Paint.Style.FILL);
        r112.setTextAlign(Paint.Align.CENTER);
        r112.setColor(-1223853);
        r112.setFakeBoldText(true);
        r106.setAntiAlias(true);
        r106.setStyle(Paint.Style.FILL);
        r106.setStrokeWidth(2.0f);
        r106.setColor(-1052689);
        r113.setAntiAlias(true);
        r113.setTextAlign(Paint.Align.CENTER);
        r113.setColor(-65536);
        r113.setFakeBoldText(true);
        r114.setAntiAlias(true);
        r114.setTextAlign(Paint.Align.CENTER);
        r114.setColor(-65536);
        r114.setFakeBoldText(true);
        r107.setAntiAlias(true);
        r107.setStyle(Paint.Style.FILL);
        r107.setStrokeWidth(2.0f);
    }

    public final void a(int r100, int r101) {
        Rect r102 = new Rect();
        this.f276119b.getTextBounds("1", 0, 1, r102);
        int r103 = (r102.height() * 12) + getMonthViewTop();
        if (r101 >= r103) goto L6;
        r101 = r103;
    L6:
        getLayoutParams().width = r100;
        getLayoutParams().height = r101;
        this.f276128k = (r101 - getMonthViewTop()) / 6;
        Paint.FontMetrics r104 = this.f276119b.getFontMetrics();
        this.f276130m = ((this.f276128k / 2) - r104.descent) + ((r104.bottom - r104.top) / 2.0f);
        Paint.FontMetrics r105 = this.f276125h.getFontMetrics();
        this.f276131n = ((this.f276118a.f276192s / 2) - r105.descent) + ((r105.bottom - r105.top) / 2.0f);
        Paint.FontMetrics r106 = this.f276126i.getFontMetrics();
        this.f276132o = ((this.f276118a.f276194t / 2) - r106.descent) + ((r106.bottom - r106.top) / 2.0f);
        invalidate();
    }
}
