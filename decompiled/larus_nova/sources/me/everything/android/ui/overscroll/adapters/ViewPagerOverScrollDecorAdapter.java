package me.everything.android.ui.overscroll.adapters;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import suc.a;

/* JADX INFO: loaded from: classes42.dex */
public class ViewPagerOverScrollDecorAdapter implements a, ViewPager.OnPageChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f513443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f513444b;

    @Override // suc.a
    public final View getView() {
        return null;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int r100) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageSelected(int r100) {
    }

    @Override // suc.a
    public final boolean a() {
        if (this.f513443a == 0) goto L5;
    L7:
        return false;
    L5:
        if (this.f513444b != 0.0f) goto L7;
        return true;
    }

    @Override // suc.a
    public final boolean b() {
        throw null;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrolled(int r100, float r101, int r102) {
        this.f513443a = r100;
        this.f513444b = r101;
    }
}
