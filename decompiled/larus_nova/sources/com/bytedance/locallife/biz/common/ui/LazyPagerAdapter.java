package com.bytedance.locallife.biz.common.ui;

import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;

/* JADX INFO: loaded from: classes21.dex */
public abstract class LazyPagerAdapter<T> extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<T> f256628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f256629b;

    public abstract T f(ViewGroup r100, int r101);

    public abstract Object g(int r100);

    public LazyPagerAdapter() {
        this.f256628a = new SparseArray();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup r100, int r101, Object r102) {
        this.f256629b = f(r100, r101);
    }
}
