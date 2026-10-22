package com.bytedance.ee.bear.widgets;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f240326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f240327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f240328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f240329d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f240330e;

    public s(View r100, AttributeSet r101) {
        this.f240327b = -1;
        this.f240328c = -1;
        this.f240329d = true;
        this.f240330e = true;
        this.f240326a = r100;
        if (r101 == null) goto L6;
        TypedArray r102 = r100.getContext().obtainStyledAttributes(r101, new int[]{R.attr.maxHeight, R.attr.maxWidth});
        this.f240327b = r102.getDimensionPixelSize(1, -1);
        this.f240328c = r102.getDimensionPixelSize(0, -1);
        r102.recycle();
        return;
    }

    public static int a(int r100, boolean r101, int r102) {
        int r103 = View.MeasureSpec.getMode(r100);
        int r104 = View.MeasureSpec.getSize(r100);
        if (r101 == false) goto L15;
        if (r102 >= 0) goto L6;
        return r100;
    L6:
        if (r103 != Integer.MIN_VALUE) goto L10;
        return View.MeasureSpec.makeMeasureSpec(Math.min(r102, r104), Integer.MIN_VALUE);
    L10:
        if (r103 != 1073741824) goto L14;
        return View.MeasureSpec.makeMeasureSpec(Math.min(r102, r104), 1073741824);
    L14:
        return View.MeasureSpec.makeMeasureSpec(r102, Integer.MIN_VALUE);
    L15:
        return r100;
    }
}
