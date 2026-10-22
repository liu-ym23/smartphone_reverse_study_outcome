package com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class DelegatingFragmentPagerAdapter extends FragmentPagerAdapter {
    public final PagerAdapter a;

    public static class a extends DataSetObserver {
        public final DelegatingFragmentPagerAdapter a;

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            DelegatingFragmentPagerAdapter r0 = this.a;
            if (r0 == null) goto L6;
            r0.f();
            return;
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            onChanged();
        }

        public a(DelegatingFragmentPagerAdapter r1) {
            this.a = r1;
        }
    }

    public final int getCount() {
        return this.a.getCount();
    }

    public final void notifyDataSetChanged() {
        this.a.notifyDataSetChanged();
    }

    public final Parcelable saveState() {
        return this.a.saveState();
    }

    public final void f() {
        super/*androidx.viewpager.widget.PagerAdapter*/.notifyDataSetChanged();
    }

    public DelegatingFragmentPagerAdapter(PagerAdapter r2) {
        super(null);
        this.a = r2;
        r2.registerDataSetObserver(new a(this));
    }

    public final void finishUpdate(View r2) {
        this.a.finishUpdate(r2);
    }

    public Fragment getItem(int r2) {
        return this.a.getItem(r2);
    }

    public int getItemPosition(Object r2) {
        return this.a.getItemPosition(r2);
    }

    public CharSequence getPageTitle(int r2) {
        return this.a.getPageTitle(r2);
    }

    public float getPageWidth(int r2) {
        return this.a.getPageWidth(r2);
    }

    public final void registerDataSetObserver(DataSetObserver r2) {
        this.a.registerDataSetObserver(r2);
    }

    public final void startUpdate(View r2) {
        this.a.startUpdate(r2);
    }

    public final void unregisterDataSetObserver(DataSetObserver r2) {
        this.a.unregisterDataSetObserver(r2);
    }

    public final void finishUpdate(ViewGroup r2) {
        this.a.finishUpdate(r2);
    }

    public final void startUpdate(ViewGroup r2) {
        this.a.startUpdate(r2);
    }

    public Object instantiateItem(View r2, int r3) {
        return this.a.instantiateItem(r2, r3);
    }

    public final boolean isViewFromObject(View r2, Object r3) {
        return this.a.isViewFromObject(r2, r3);
    }

    public final void restoreState(Parcelable r2, ClassLoader r3) {
        this.a.restoreState(r2, r3);
    }

    public Object instantiateItem(ViewGroup r2, int r3) {
        return this.a.instantiateItem(r2, r3);
    }

    public void destroyItem(View r2, int r3, Object r4) {
        this.a.destroyItem(r2, r3, r4);
    }

    public void setPrimaryItem(View r2, int r3, Object r4) {
        this.a.setPrimaryItem(r2, r3, r4);
    }

    public void destroyItem(ViewGroup r2, int r3, Object r4) {
        this.a.destroyItem(r2, r3, r4);
    }

    public void setPrimaryItem(ViewGroup r2, int r3, Object r4) {
        this.a.setPrimaryItem(r2, r3, r4);
    }
}
