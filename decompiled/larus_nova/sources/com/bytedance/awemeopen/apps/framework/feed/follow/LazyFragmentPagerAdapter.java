package com.bytedance.awemeopen.apps.framework.feed.follow;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes14.dex */
public abstract class LazyFragmentPagerAdapter extends LazyPagerAdapter<Fragment> {
    @Override // androidx.viewpager.widget.PagerAdapter
    public final void finishUpdate(ViewGroup r100) {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void startUpdate(ViewGroup r100) {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.follow.LazyPagerAdapter
    public final /* bridge */ /* synthetic */ Fragment f(ViewGroup r100, int r101) {
        g(r100, r101);
        return null;
    }

    public final Fragment g(ViewGroup r100, int r101) {
        if (((Fragment) this.f194720a.get(r101)) != null) goto L5;
        return null;
    L5:
        r100.getId();
        throw null;
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [T, androidx.fragment.app.Fragment] */
    @Override // com.bytedance.awemeopen.apps.framework.feed.follow.LazyPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public final void setPrimaryItem(ViewGroup r100, int r101, Object r102) {
        if (this.f194720a.get(r101) == null) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        startUpdate(r100);
        g(r100, r101);
        finishUpdate(r100);
    L8:
        ?? r104 = (Fragment) r102;
        T r105 = this.f194721b;
        if (r104 == r105) goto L16;
        if (r105 == 0) goto L12;
        ((Fragment) r105).setMenuVisibility(false);
        ((Fragment) this.f194721b).setUserVisibleHint(false);
    L12:
        if (r104 == 0) goto L14;
        r104.setMenuVisibility(true);
        r104.setUserVisibleHint(true);
    L14:
        this.f194721b = r104;
        return;
    L16:
        return;
    L5:
        r103 = false;
        goto L6
    }
}
