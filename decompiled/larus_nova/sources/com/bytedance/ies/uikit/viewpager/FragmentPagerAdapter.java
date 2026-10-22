package com.bytedance.ies.uikit.viewpager;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;

/* JADX INFO: loaded from: classes19.dex */
public abstract class FragmentPagerAdapter extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Fragment f249247a;

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void finishUpdate(ViewGroup r100) {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void restoreState(Parcelable r100, ClassLoader r101) {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Parcelable saveState() {
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void startUpdate(ViewGroup r100) {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup r100, int r101) {
        throw null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View r100, Object r101) {
        if (((Fragment) r101).getView() != r100) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup r100, int r101, Object r102) {
        throw null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void setPrimaryItem(ViewGroup r100, int r101, Object r102) {
        Fragment r103 = (Fragment) r102;
        Fragment r104 = this.f249247a;
        if (r103 == r104) goto L10;
        if (r104 == null) goto L6;
        r104.setMenuVisibility(false);
        this.f249247a.setUserVisibleHint(false);
    L6:
        if (r103 == null) goto L8;
        r103.setMenuVisibility(true);
        r103.setUserVisibleHint(true);
    L8:
        this.f249247a = r103;
        return;
    }
}
