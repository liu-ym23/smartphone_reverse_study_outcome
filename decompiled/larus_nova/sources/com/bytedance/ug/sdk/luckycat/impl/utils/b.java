package com.bytedance.ug.sdk.luckycat.impl.utils;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<View> f271508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewTreeObserver f271509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f271510c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewGroup.LayoutParams f271511d;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        View r100 = this.f271508a.get();
        if (r100 == null) goto L5;
        Rect r101 = new Rect();
        r100.getWindowVisibleDisplayFrame(r101);
        if (Build.VERSION.SDK_INT < 23) goto L18;
        WindowInsets r102 = r100.getRootWindowInsets();
        if (r102 != null) goto L13;
        int r103 = r101.bottom;
    L20:
        if (r103 == this.f271510c) goto L25;
        ViewGroup.LayoutParams r104 = this.f271511d;
        r104.height = r103;
        r100.setLayoutParams(r104);
        this.f271510c = r103;
        return;
    L25:
        return;
    L13:
        if (r102.getStableInsetTop() != r101.top) goto L15;
        r103 = r101.bottom;
        goto L20
    L15:
        int r105 = r102.getStableInsetTop();
        int r106 = r101.top;
        if (r105 >= r106) goto L18;
        r103 = r101.bottom - (r106 - r102.getStableInsetTop());
    L18:
        r103 = r101.bottom;
        goto L20
    L5:
        if (this.f271509b.isAlive() == false) goto L23;
        this.f271509b.removeGlobalOnLayoutListener(this);
        return;
    }

    public b(View r100) {
        if (r100 == null) goto L6;
        this.f271508a = new WeakReference(r100);
        ViewTreeObserver r101 = r100.getViewTreeObserver();
        this.f271509b = r101;
        r101.addOnGlobalLayoutListener(this);
        this.f271511d = r100.getLayoutParams();
        return;
    }
}
