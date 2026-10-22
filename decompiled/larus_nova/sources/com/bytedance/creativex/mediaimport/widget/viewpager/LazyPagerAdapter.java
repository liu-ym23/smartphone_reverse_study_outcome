package com.bytedance.creativex.mediaimport.widget.viewpager;

import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;

/* JADX INFO: loaded from: classes15.dex */
public abstract class LazyPagerAdapter<T> extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<T> f204222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f204223b;

    public abstract T f(ViewGroup r100, int r101);

    public LazyPagerAdapter() {
        this.f204222a = new SparseArray();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup r100, int r101, Object r102) {
        this.f204223b = f(r100, r101);
    }
}
