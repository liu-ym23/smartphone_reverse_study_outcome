package com.bytedance.ee.bear.atbottombar;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public class AtCardAdapter extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f206334a;

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View r100, Object r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return ((ArrayList) this.f206334a).size();
    }

    public AtCardAdapter(List<b> r100) {
        ArrayList r101 = new ArrayList();
        this.f206334a = r101;
        r101.addAll(r100);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup r100, int r101) {
        View r102 = ((b) ListProtector.get(this.f206334a, r101)).f206336a;
        r100.addView(r102);
        return r102;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup r100, int r101, Object r102) {
        r100.removeView(((b) ListProtector.get(this.f206334a, r101)).f206336a);
    }
}
