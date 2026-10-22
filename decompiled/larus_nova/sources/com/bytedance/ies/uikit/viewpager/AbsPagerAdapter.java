package com.bytedance.ies.uikit.viewpager;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes19.dex */
public abstract class AbsPagerAdapter extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<View> f249246a;

    public abstract View getView(int r100, View r101, ViewGroup r102);

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View r100, Object r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    public AbsPagerAdapter() {
        this.f249246a = new LinkedList();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup r100, int r101) {
        if (this.f249246a.isEmpty() == true) goto L5;
        View r102 = this.f249246a.removeFirst();
    L6:
        View r103 = getView(r101, r102, r100);
        r100.addView(r103);
        return r103;
    L5:
        r102 = null;
        goto L6
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup r100, int r101, Object r102) {
        if (r102 != null) goto L4;
        return;
    L4:
        View r103 = (View) r102;
        r100.removeView(r103);
        this.f249246a.add(r103);
    }
}
