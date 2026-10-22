package com.bytedance.awemeopen.apps.framework.feed.follow;

import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class LazyPagerAdapter<T> extends PagerAdapter {
    public final SparseArray<T> a;
    public T b;

    public abstract T f(ViewGroup r1, int r2);

    public LazyPagerAdapter() {
        this.a = new SparseArray();
    }

    public void setPrimaryItem(ViewGroup r1, int r2, Object r3) {
        this.b = f(r1, r2);
    }
}
