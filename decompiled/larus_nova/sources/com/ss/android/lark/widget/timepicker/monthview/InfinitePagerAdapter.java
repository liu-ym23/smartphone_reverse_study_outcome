package com.ss.android.lark.widget.timepicker.monthview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import vec.c;

/* JADX INFO: loaded from: classes38.dex */
public abstract class InfinitePagerAdapter extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f449005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c[] f449006b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f449007c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f449008d;

    public abstract void f();

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return 3;
    }

    public InfinitePagerAdapter(Context r100) {
        this.f449007c = 0;
        this.f449008d = false;
        this.f449005a = r100;
        this.f449006b = new c[3];
    }

    public final <T extends View> T g(int r100) {
        if (r100 >= 0) goto L4;
        return null;
    L4:
        if (r100 <= 2) goto L7;
        return null;
    L7:
        return (T) this.f449006b[r100].f554545b;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup r100, int r101) {
        c r102 = this.f449006b[r101];
        r100.addView(r102.f554544a);
        int r103 = this.f449007c + 1;
        this.f449007c = r103;
        if (r103 != 3) goto L5;
        this.f449008d = true;
    L5:
        f();
        return r102;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View r100, Object r101) {
        if (r100 != ((c) r101).f554544a) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup r100, int r101, Object r102) {
        r100.removeView(((c) r102).f554544a);
    }
}
