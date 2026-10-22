package com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

/* JADX INFO: loaded from: classes14.dex */
public class DelegatingFragmentPagerAdapter extends FragmentPagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PagerAdapter f193490a;

    public static class a extends DataSetObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DelegatingFragmentPagerAdapter f193491a;

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            DelegatingFragmentPagerAdapter r100 = this.f193491a;
            if (r100 == null) goto L6;
            r100.f();
            return;
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            onChanged();
        }

        public a(DelegatingFragmentPagerAdapter r100) {
            this.f193491a = r100;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return this.f193490a.getCount();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void notifyDataSetChanged() {
        this.f193490a.notifyDataSetChanged();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public final Parcelable saveState() {
        return this.f193490a.saveState();
    }

    public final void f() {
        super.notifyDataSetChanged();
    }

    public DelegatingFragmentPagerAdapter(PagerAdapter r100) {
        super(null);
        this.f193490a = r100;
        r100.registerDataSetObserver(new a(this));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void finishUpdate(View r100) {
        this.f193490a.finishUpdate(r100);
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int r100) {
        return ((FragmentPagerAdapter) this.f193490a).getItem(r100);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object r100) {
        return this.f193490a.getItemPosition(r100);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int r100) {
        return this.f193490a.getPageTitle(r100);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public float getPageWidth(int r100) {
        return this.f193490a.getPageWidth(r100);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void registerDataSetObserver(DataSetObserver r100) {
        this.f193490a.registerDataSetObserver(r100);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void startUpdate(View r100) {
        this.f193490a.startUpdate(r100);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void unregisterDataSetObserver(DataSetObserver r100) {
        this.f193490a.unregisterDataSetObserver(r100);
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public final void finishUpdate(ViewGroup r100) {
        this.f193490a.finishUpdate(r100);
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public final void startUpdate(ViewGroup r100) {
        this.f193490a.startUpdate(r100);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(View r100, int r101) {
        return this.f193490a.instantiateItem(r100, r101);
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View r100, Object r101) {
        return this.f193490a.isViewFromObject(r100, r101);
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public final void restoreState(Parcelable r100, ClassLoader r101) {
        this.f193490a.restoreState(r100, r101);
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup r100, int r101) {
        return this.f193490a.instantiateItem(r100, r101);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(View r100, int r101, Object r102) {
        this.f193490a.destroyItem(r100, r101, r102);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(View r100, int r101, Object r102) {
        this.f193490a.setPrimaryItem(r100, r101, r102);
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup r100, int r101, Object r102) {
        this.f193490a.destroyItem(r100, r101, r102);
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup r100, int r101, Object r102) {
        this.f193490a.setPrimaryItem(r100, r101, r102);
    }
}
