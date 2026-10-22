package com.obric.oui.orecyclerview.widget;

import android.graphics.Rect;
import android.view.View;

/* JADX INFO: loaded from: classes34.dex */
public abstract class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView.k f401788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f401789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f401790c;

    public abstract int a(View r100);

    public abstract int b(View r100);

    public abstract int c(View r100);

    public abstract int d(View r100);

    public abstract int e();

    public abstract int f();

    public abstract int g();

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l(View r100);

    public abstract int m(View r100);

    public abstract void n(int r100);

    public c0(RecyclerView.k r100) {
        this.f401789b = Integer.MIN_VALUE;
        this.f401790c = new Rect();
        this.f401788a = r100;
    }
}
