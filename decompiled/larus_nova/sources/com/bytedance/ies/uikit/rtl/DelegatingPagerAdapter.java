package com.bytedance.ies.uikit.rtl;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;

/* JADX INFO: loaded from: classes19.dex */
public class DelegatingPagerAdapter extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PagerAdapter f249178a;

    public static class a extends DataSetObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DelegatingPagerAdapter f249179a;

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            DelegatingPagerAdapter r100 = this.f249179a;
            if (r100 == null) goto L6;
            r100.f();
            return;
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            onChanged();
        }

        public a(DelegatingPagerAdapter r100) {
            this.f249179a = r100;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return this.f249178a.getCount();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void notifyDataSetChanged() {
        this.f249178a.notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Parcelable saveState() {
        return this.f249178a.saveState();
    }

    public final void f() {
        super.notifyDataSetChanged();
    }

    public DelegatingPagerAdapter(PagerAdapter r100) {
        this.f249178a = r100;
        r100.registerDataSetObserver(new a(this));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void finishUpdate(View r100) {
        this.f249178a.finishUpdate(r100);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object r100) {
        return this.f249178a.getItemPosition(r100);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int r100) {
        return this.f249178a.getPageTitle(r100);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public float getPageWidth(int r100) {
        return this.f249178a.getPageWidth(r100);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void registerDataSetObserver(DataSetObserver r100) {
        this.f249178a.registerDataSetObserver(r100);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void startUpdate(View r100) {
        this.f249178a.startUpdate(r100);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void unregisterDataSetObserver(DataSetObserver r100) {
        this.f249178a.unregisterDataSetObserver(r100);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void finishUpdate(ViewGroup r100) {
        this.f249178a.finishUpdate(r100);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void startUpdate(ViewGroup r100) {
        this.f249178a.startUpdate(r100);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(View r100, int r101) {
        return this.f249178a.instantiateItem(r100, r101);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View r100, Object r101) {
        return this.f249178a.isViewFromObject(r100, r101);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void restoreState(Parcelable r100, ClassLoader r101) {
        this.f249178a.restoreState(r100, r101);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup r100, int r101) {
        return this.f249178a.instantiateItem(r100, r101);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(View r100, int r101, Object r102) {
        this.f249178a.destroyItem(r100, r101, r102);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(View r100, int r101, Object r102) {
        this.f249178a.setPrimaryItem(r100, r101, r102);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup r100, int r101, Object r102) {
        this.f249178a.destroyItem(r100, r101, r102);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup r100, int r101, Object r102) {
        this.f249178a.setPrimaryItem(r100, r101, r102);
    }
}
