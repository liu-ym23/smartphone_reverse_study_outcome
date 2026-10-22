package com.ss.android.ugc.aweme.search.common.viewpager.customview;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

/* JADX INFO: loaded from: classes40.dex */
public class ECDelegatingFragmentPagerAdapter extends FragmentPagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PagerAdapter f452561a;

    public static class MyDataSetObserver extends DataSetObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ECDelegatingFragmentPagerAdapter f452562a;

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            ECDelegatingFragmentPagerAdapter r100 = this.f452562a;
            if (r100 == null) goto L6;
            r100.f();
            return;
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            onChanged();
        }

        public MyDataSetObserver(ECDelegatingFragmentPagerAdapter r100) {
            this.f452562a = r100;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return this.f452561a.getCount();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void notifyDataSetChanged() {
        this.f452561a.notifyDataSetChanged();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public final Parcelable saveState() {
        return this.f452561a.saveState();
    }

    public final void f() {
        super.notifyDataSetChanged();
    }

    public ECDelegatingFragmentPagerAdapter(PagerAdapter r100) {
        super(null);
        this.f452561a = r100;
        r100.registerDataSetObserver(new MyDataSetObserver(this));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void finishUpdate(View r100) {
        this.f452561a.finishUpdate(r100);
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int r100) {
        return ((FragmentPagerAdapter) this.f452561a).getItem(r100);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object r100) {
        return this.f452561a.getItemPosition(r100);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int r100) {
        return this.f452561a.getPageTitle(r100);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public float getPageWidth(int r100) {
        return this.f452561a.getPageWidth(r100);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void registerDataSetObserver(DataSetObserver r100) {
        this.f452561a.registerDataSetObserver(r100);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void startUpdate(View r100) {
        this.f452561a.startUpdate(r100);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void unregisterDataSetObserver(DataSetObserver r100) {
        this.f452561a.unregisterDataSetObserver(r100);
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public final void finishUpdate(ViewGroup r100) {
        this.f452561a.finishUpdate(r100);
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public final void startUpdate(ViewGroup r100) {
        this.f452561a.startUpdate(r100);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(View r100, int r101) {
        return this.f452561a.instantiateItem(r100, r101);
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View r100, Object r101) {
        return this.f452561a.isViewFromObject(r100, r101);
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public final void restoreState(Parcelable r100, ClassLoader r101) {
        this.f452561a.restoreState(r100, r101);
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup r100, int r101) {
        return this.f452561a.instantiateItem(r100, r101);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(View r100, int r101, Object r102) {
        this.f452561a.destroyItem(r100, r101, r102);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(View r100, int r101, Object r102) {
        this.f452561a.setPrimaryItem(r100, r101, r102);
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup r100, int r101, Object r102) {
        this.f452561a.destroyItem(r100, r101, r102);
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup r100, int r101, Object r102) {
        this.f452561a.setPrimaryItem(r100, r101, r102);
    }
}
