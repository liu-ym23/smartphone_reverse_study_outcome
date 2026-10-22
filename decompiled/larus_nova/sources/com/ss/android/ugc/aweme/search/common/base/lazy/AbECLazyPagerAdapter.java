package com.ss.android.ugc.aweme.search.common.base.lazy;

import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;

/* JADX INFO: loaded from: classes40.dex */
public abstract class AbECLazyPagerAdapter<T> extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<T> f451488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f451489b;

    public abstract T f(ViewGroup r100, int r101);

    public abstract Object g(int r100);

    public AbECLazyPagerAdapter() {
        this.f451488a = new SparseArray();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup r100, int r101, Object r102) {
        this.f451489b = f(r100, r101);
    }
}
