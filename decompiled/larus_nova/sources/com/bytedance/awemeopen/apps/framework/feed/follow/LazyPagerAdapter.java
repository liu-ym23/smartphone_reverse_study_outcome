package com.bytedance.awemeopen.apps.framework.feed.follow;

import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;

/* JADX INFO: loaded from: classes14.dex */
public abstract class LazyPagerAdapter<T> extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<T> f194720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f194721b;

    public abstract T f(ViewGroup r100, int r101);

    public LazyPagerAdapter() {
        this.f194720a = new SparseArray();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup r100, int r101, Object r102) {
        this.f194721b = f(r100, r101);
    }
}
