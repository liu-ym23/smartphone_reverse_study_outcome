package com.google.android.flexbox;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f274424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f274425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f274426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f274427d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f274428e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f274429f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f274430g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f274431h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f274432i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f274433j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f274434k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f274435l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f274436m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<Integer> f274437n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f274438o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f274439p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f274440q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f274441r;

    public b() {
        this.f274424a = Integer.MAX_VALUE;
        this.f274425b = Integer.MAX_VALUE;
        this.f274426c = Integer.MIN_VALUE;
        this.f274427d = Integer.MIN_VALUE;
        this.f274437n = new ArrayList();
    }

    public final void a(View r100, int r101, int r102, int r103, int r104) {
        FlexItem r105 = (FlexItem) r100.getLayoutParams();
        this.f274424a = Math.min(this.f274424a, (r100.getLeft() - r105.getMarginLeft()) - r101);
        this.f274425b = Math.min(this.f274425b, (r100.getTop() - r105.getMarginTop()) - r102);
        this.f274426c = Math.max(this.f274426c, (r100.getRight() + r105.getMarginRight()) + r103);
        this.f274427d = Math.max(this.f274427d, (r100.getBottom() + r105.getMarginBottom()) + r104);
    }
}
