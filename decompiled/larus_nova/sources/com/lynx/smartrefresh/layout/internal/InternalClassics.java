package com.lynx.smartrefresh.layout.internal;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.lynx.smartrefresh.layout.SmartRefreshLayout;
import com.lynx.smartrefresh.layout.internal.InternalClassics;
import m6a.h;
import m6a.i;
import p6a.a;
import p6a.b;
import p6a.d;

/* JADX INFO: loaded from: classes32.dex */
public abstract class InternalClassics<T extends InternalClassics> extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f381619d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f381620e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f381621f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public h f381622g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f381623h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f381624i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f381625j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f381626k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f381627l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f381628m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f381629n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f381630o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f381631p;

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ImageView r100 = this.f381620e;
        ImageView r101 = this.f381621f;
        r100.animate().cancel();
        r101.animate().cancel();
        Object r102 = this.f381621f.getDrawable();
        if ((r102 instanceof Animatable) == false) goto L8;
        Animatable r103 = (Animatable) r102;
        if (r103.isRunning() == false) goto L9;
        r103.stop();
        return;
    L9:
        return;
    }

    public void g(int r100) {
        this.f381625j = true;
        this.f381619d.setTextColor(r100);
        a r101 = this.f381623h;
        if (r101 == null) goto L5;
        r101.a(r100);
        this.f381620e.invalidateDrawable(this.f381623h);
    L5:
        d r102 = this.f381624i;
        if (r102 == null) goto L9;
        r102.a(r100);
        this.f381621f.invalidateDrawable(this.f381624i);
        return;
    }

    @Override // p6a.b, m6a.g
    public void setPrimaryColors(int... r100) {
        if (r100.length > 0) goto L5;
        return;
    L5:
        if ((getBackground() instanceof BitmapDrawable) == true) goto L13;
        if (this.f381626k == true) goto L13;
        int r101 = r100[0];
        this.f381626k = true;
        this.f381627l = r101;
        h r102 = this.f381622g;
        if (r102 == null) goto L11;
        ((SmartRefreshLayout.i) r102).c(this, r101);
    L11:
        this.f381626k = false;
    L13:
        if (this.f381625j == false) goto L15;
        return;
    L15:
        if (r100.length <= 1) goto L17;
        g(r100[1]);
    L21:
        this.f381625j = false;
        return;
    L17:
        int r103 = -1;
        if (r100[0] != (-1)) goto L20;
        r103 = -10066330;
    L20:
        g(r103);
        goto L21
    }

    @Override // p6a.b, m6a.g
    public int e(SmartRefreshLayout r100, boolean r101) {
        ImageView r102 = this.f381621f;
        Object r103 = r102.getDrawable();
        if ((r103 instanceof Animatable) == false) goto L7;
        Animatable r104 = (Animatable) r103;
        if (r104.isRunning() == false) goto L8;
        r104.stop();
    L8:
        r102.setVisibility(8);
        return this.f381628m;
    L7:
        r102.animate().rotation(0.0f).setDuration(0);
        goto L8
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = 0;
        if (this.f381631p != 0) goto L16;
        this.f381629n = getPaddingTop();
        int r103 = getPaddingBottom();
        this.f381630o = r103;
        if (this.f381629n == 0) goto L7;
        if (r103 == 0) goto L7;
    L14:
        setClipToPadding(false);
    L7:
        int r104 = getPaddingLeft();
        int r105 = getPaddingRight();
        int r106 = this.f381629n;
        if (r106 != 0) goto L10;
        r106 = r6a.b.c(20.0f);
    L10:
        this.f381629n = r106;
        int r107 = this.f381630o;
        if (r107 != 0) goto L13;
        r107 = r6a.b.c(20.0f);
    L13:
        this.f381630o = r107;
        setPadding(r104, this.f381629n, r105, r107);
    L16:
        if (View.MeasureSpec.getMode(r101) != 1073741824) goto L21;
        int r108 = View.MeasureSpec.getSize(r101);
        int r109 = this.f381631p;
        if (r108 >= r109) goto L20;
        int r110 = (r108 - r109) / 2;
        setPadding(getPaddingLeft(), r110, getPaddingRight(), r110);
    L22:
        super.onMeasure(r100, r101);
        if (this.f381631p == 0) goto L25;
        return;
    L25:
        if (r102 >= getChildCount()) goto L34;
        int r111 = getChildAt(r102).getMeasuredHeight();
        if (this.f381631p >= r111) goto L29;
        this.f381631p = r111;
    L29:
        r102 = r102 + 1;
        goto L25
    L34:
        return;
    L20:
        setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
        goto L22
    L21:
        setPadding(getPaddingLeft(), this.f381629n, getPaddingRight(), this.f381630o);
        goto L22
    }

    public InternalClassics(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f381628m = 500;
        this.f381629n = 20;
        this.f381630o = 20;
        this.f381631p = 0;
        this.f527945b = n6a.b.f518183d;
    }

    @Override // p6a.b, m6a.g
    public final void j(SmartRefreshLayout.i r100, int r101, int r102) {
        this.f381622g = r100;
        r100.c(this, this.f381627l);
    }

    @Override // p6a.b, m6a.g
    public final void k(i r100, int r101, int r102) {
        n(r100, r101, r102);
    }

    @Override // p6a.b, m6a.g
    public void n(i r100, int r101, int r102) {
        ImageView r103 = this.f381621f;
        if (r103.getVisibility() == 0) goto L9;
        r103.setVisibility(0);
        Object r104 = this.f381621f.getDrawable();
        if ((r104 instanceof Animatable) == false) goto L7;
        ((Animatable) r104).start();
        return;
    L7:
        r103.animate().rotation(36000.0f).setDuration(100000);
        return;
    }
}
