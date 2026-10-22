package com.scwang.smartrefresh.layout.internal;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.internal.InternalClassics;
import cqa.g;
import cqa.h;
import fqa.a;
import fqa.b;
import fqa.d;

/* JADX INFO: loaded from: classes34.dex */
public abstract class InternalClassics<T extends InternalClassics> extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f406001d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f406002e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f406003f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public g f406004g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f406005h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f406006i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f406007j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f406008k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f406009l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f406010m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f406011n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f406012o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f406013p;

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ImageView r100 = this.f406002e;
        ImageView r101 = this.f406003f;
        r100.animate().cancel();
        r101.animate().cancel();
        Object r102 = this.f406003f.getDrawable();
        if ((r102 instanceof Animatable) == false) goto L8;
        Animatable r103 = (Animatable) r102;
        if (r103.isRunning() == false) goto L9;
        r103.stop();
        return;
    L9:
        return;
    }

    public void k(int r100) {
        this.f406007j = true;
        this.f406001d.setTextColor(r100);
        a r101 = this.f406005h;
        if (r101 == null) goto L5;
        r101.a(r100);
        this.f406002e.invalidateDrawable(this.f406005h);
    L5:
        d r102 = this.f406006i;
        if (r102 == null) goto L9;
        r102.a(r100);
        this.f406003f.invalidateDrawable(this.f406006i);
        return;
    }

    @Override // fqa.b, cqa.f
    public void setPrimaryColors(int... r100) {
        if (r100.length > 0) goto L5;
        return;
    L5:
        if ((getBackground() instanceof BitmapDrawable) == true) goto L13;
        if (this.f406008k == true) goto L13;
        int r101 = r100[0];
        this.f406008k = true;
        this.f406009l = r101;
        g r102 = this.f406004g;
        if (r102 == null) goto L11;
        ((SmartRefreshLayout.j) r102).c(this, r101);
    L11:
        this.f406008k = false;
    L13:
        if (this.f406007j == false) goto L15;
        return;
    L15:
        if (r100.length <= 1) goto L17;
        k(r100[1]);
    L21:
        this.f406007j = false;
        return;
    L17:
        int r103 = -1;
        if (r100[0] != (-1)) goto L20;
        r103 = -10066330;
    L20:
        k(r103);
        goto L21
    }

    @Override // fqa.b, cqa.f
    public int j(SmartRefreshLayout r100, boolean r101) {
        ImageView r102 = this.f406003f;
        Object r103 = r102.getDrawable();
        if ((r103 instanceof Animatable) == false) goto L7;
        Animatable r104 = (Animatable) r103;
        if (r104.isRunning() == false) goto L8;
        r104.stop();
    L8:
        r102.setVisibility(8);
        return this.f406010m;
    L7:
        r102.animate().rotation(0.0f).setDuration(0);
        goto L8
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = 0;
        if (this.f406013p != 0) goto L16;
        this.f406011n = getPaddingTop();
        int r103 = getPaddingBottom();
        this.f406012o = r103;
        if (this.f406011n == 0) goto L7;
        if (r103 == 0) goto L7;
    L14:
        setClipToPadding(false);
    L7:
        int r104 = getPaddingLeft();
        int r105 = getPaddingRight();
        int r106 = this.f406011n;
        if (r106 != 0) goto L10;
        r106 = hqa.b.c(20.0f);
    L10:
        this.f406011n = r106;
        int r107 = this.f406012o;
        if (r107 != 0) goto L13;
        r107 = hqa.b.c(20.0f);
    L13:
        this.f406012o = r107;
        setPadding(r104, this.f406011n, r105, r107);
    L16:
        if (View.MeasureSpec.getMode(r101) != 1073741824) goto L21;
        int r108 = View.MeasureSpec.getSize(r101);
        int r109 = this.f406013p;
        if (r108 >= r109) goto L20;
        int r110 = (r108 - r109) / 2;
        setPadding(getPaddingLeft(), r110, getPaddingRight(), r110);
    L22:
        super.onMeasure(r100, r101);
        if (this.f406013p == 0) goto L25;
        return;
    L25:
        if (r102 >= getChildCount()) goto L34;
        int r111 = getChildAt(r102).getMeasuredHeight();
        if (this.f406013p >= r111) goto L29;
        this.f406013p = r111;
    L29:
        r102 = r102 + 1;
        goto L25
    L34:
        return;
    L20:
        setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
        goto L22
    L21:
        setPadding(getPaddingLeft(), this.f406011n, getPaddingRight(), this.f406012o);
        goto L22
    }

    public InternalClassics(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f406010m = 500;
        this.f406011n = 20;
        this.f406012o = 20;
        this.f406013p = 0;
        this.f478467b = dqa.b.f469717d;
    }

    @Override // fqa.b, cqa.f
    public void f(h r100, int r101, int r102) {
        ImageView r103 = this.f406003f;
        if (r103.getVisibility() == 0) goto L9;
        r103.setVisibility(0);
        Object r104 = this.f406003f.getDrawable();
        if ((r104 instanceof Animatable) == false) goto L7;
        ((Animatable) r104).start();
        return;
    L7:
        r103.animate().rotation(36000.0f).setDuration(100000);
        return;
    }

    @Override // fqa.b, cqa.f
    public final void g(SmartRefreshLayout.j r100, int r101, int r102) {
        this.f406004g = r100;
        r100.c(this, this.f406009l);
    }

    @Override // fqa.b, cqa.f
    public final void i(h r100, int r101, int r102) {
        f(r100, r101, r102);
    }
}
