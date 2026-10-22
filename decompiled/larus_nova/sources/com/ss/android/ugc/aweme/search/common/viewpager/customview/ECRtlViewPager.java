package com.ss.android.ugc.aweme.search.common.viewpager.customview;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.ParcelableCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import java.util.HashMap;

/* JADX INFO: loaded from: classes40.dex */
public class ECRtlViewPager extends ViewPager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f452567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<ViewPager.OnPageChangeListener, ReversingOnPageChangeListener> f452568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f452569c;

    public class ReversingAdapter extends ECDelegatingFragmentPagerAdapter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ECRtlViewPager f452570b;

        @Override // com.ss.android.ugc.aweme.search.common.viewpager.customview.ECDelegatingFragmentPagerAdapter, androidx.fragment.app.FragmentPagerAdapter
        public final Fragment getItem(int r100) {
            if (this.f452570b.isRtl() == false) goto L6;
            r100 = (getCount() - r100) - 1;
        L6:
            return super.getItem(r100);
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public final long getItemId(int r100) {
            if (this.f452570b.isRtl() == false) goto L6;
            r100 = (getCount() - r100) - 1;
        L6:
            return super.getItemId(r100);
        }

        @Override // com.ss.android.ugc.aweme.search.common.viewpager.customview.ECDelegatingFragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public final int getItemPosition(Object r100) {
            int r101 = super.getItemPosition(r100);
            if (this.f452570b.isRtl() == true) goto L5;
            return r101;
        L5:
            if (r101 == (-1)) goto L9;
            if (r101 == (-2)) goto L9;
            return (getCount() - r101) - 1;
        L9:
            return -2;
        }

        @Override // com.ss.android.ugc.aweme.search.common.viewpager.customview.ECDelegatingFragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public final CharSequence getPageTitle(int r100) {
            if (this.f452570b.isRtl() == false) goto L6;
            r100 = (getCount() - r100) - 1;
        L6:
            return super.getPageTitle(r100);
        }

        @Override // com.ss.android.ugc.aweme.search.common.viewpager.customview.ECDelegatingFragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public final float getPageWidth(int r100) {
            if (this.f452570b.isRtl() == false) goto L6;
            r100 = (getCount() - r100) - 1;
        L6:
            return super.getPageWidth(r100);
        }

        public ReversingAdapter(ECRtlViewPager r100, PagerAdapter r101) {
            this.f452570b = r100;
            super(r101);
        }

        @Override // com.ss.android.ugc.aweme.search.common.viewpager.customview.ECDelegatingFragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public final Object instantiateItem(View r100, int r101) {
            if (this.f452570b.isRtl() == false) goto L6;
            r101 = (getCount() - r101) - 1;
        L6:
            return super.instantiateItem(r100, r101);
        }

        @Override // com.ss.android.ugc.aweme.search.common.viewpager.customview.ECDelegatingFragmentPagerAdapter, androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public final Object instantiateItem(ViewGroup r100, int r101) {
            if (this.f452570b.isRtl() == false) goto L6;
            r101 = (getCount() - r101) - 1;
        L6:
            return super.instantiateItem(r100, r101);
        }

        @Override // com.ss.android.ugc.aweme.search.common.viewpager.customview.ECDelegatingFragmentPagerAdapter, androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public final void destroyItem(ViewGroup r100, int r101, Object r102) {
            if (this.f452570b.isRtl() == false) goto L5;
            r101 = (getCount() - r101) - 1;
        L5:
            if (r101 >= 0) goto L7;
            r101 = 0;
        L7:
            super.destroyItem(r100, r101, r102);
        }

        @Override // com.ss.android.ugc.aweme.search.common.viewpager.customview.ECDelegatingFragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public final void setPrimaryItem(View r100, int r101, Object r102) {
            if (this.f452570b.isRtl() == false) goto L5;
            r101 = (getCount() - r101) - 1;
        L5:
            super.setPrimaryItem(r100, r101, r102);
        }

        @Override // com.ss.android.ugc.aweme.search.common.viewpager.customview.ECDelegatingFragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public final void destroyItem(View r100, int r101, Object r102) {
            if (this.f452570b.isRtl() == false) goto L5;
            r101 = (getCount() - r101) - 1;
        L5:
            super.destroyItem(r100, r101, r102);
        }

        @Override // com.ss.android.ugc.aweme.search.common.viewpager.customview.ECDelegatingFragmentPagerAdapter, androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public final void setPrimaryItem(ViewGroup r100, int r101, Object r102) {
            if (this.f452570b.isRtl() == false) goto L5;
            r101 = (getCount() - r101) - 1;
        L5:
            super.setPrimaryItem(r100, r101, r102);
        }
    }

    public class ReversingOnPageChangeListener implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewPager.OnPageChangeListener f452571a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ECRtlViewPager f452572b;

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int r100) {
            this.f452571a.onPageScrollStateChanged(r100);
            ECRtlViewPager r101 = this.f452572b;
            if (r101.f452569c == false) goto L14;
            if (r100 == 0) goto L6;
            return;
        L6:
            if (r101.isRtl() == false) goto L8;
            return;
        L8:
            if (this.f452572b.getCurrentItem() == 0) goto L11;
            return;
        L11:
            if (this.f452572b.getScrollX() <= 0) goto L17;
            this.f452572b.setScrollX(0);
            return;
        L17:
            return;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int r100) {
            PagerAdapter r101 = ECRtlViewPager.i(this.f452572b);
            if (this.f452572b.isRtl() == false) goto L6;
            if (r101 == null) goto L6;
            r100 = (r101.getCount() - r100) - 1;
        L6:
            this.f452571a.onPageSelected(r100);
        }

        public ReversingOnPageChangeListener(ECRtlViewPager r100, ViewPager.OnPageChangeListener r101) {
            this.f452572b = r100;
            this.f452571a = r101;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int r100, float r101, int r102) {
            PagerAdapter r103 = ECRtlViewPager.h(this.f452572b);
            if (this.f452572b.isRtl() == false) goto L11;
            if (r103 == null) goto L11;
            int r104 = r103.getCount();
            if (r100 == (r104 - 1)) goto L8;
        L10:
            this.f452571a.onPageScrolled((r104 - (r100 + 1)) - 1, 1.0f - r101, this.f452572b.getWidth() - r102);
            return;
        L8:
            if (r101 != 0.0f) goto L10;
            r100 = r100 - 1;
            r102 = this.f452572b.getWidth();
            r101 = 1.0f;
        L11:
            this.f452571a.onPageScrolled(r100, r101, r102);
        }
    }

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Parcelable f452573a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f452574b;

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        static {
            CREATOR = ParcelableCompat.newCreator(new AnonymousClass1());
        }

        public SavedState(Parcel r100, ClassLoader r101) {
            if (r101 != null) goto L5;
            r101 = getClass().getClassLoader();
        L5:
            this.f452573a = r100.readParcelable(r101);
            this.f452574b = r100.readInt();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            r100.writeParcelable(this.f452573a, r101);
            r100.writeInt(this.f452574b);
        }

        public SavedState(Parcelable r100, int r101) {
            this.f452573a = r100;
            this.f452574b = r101;
        }
    }

    public final boolean isRtl() {
        if (this.f452567a == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public PagerAdapter getAdapter() {
        ReversingAdapter r100 = (ReversingAdapter) super.getAdapter();
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.f452561a;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public int getCurrentItem() {
        int r100 = super.getCurrentItem();
        PagerAdapter r101 = super.getAdapter();
        if (r101 != null) goto L5;
        return r100;
    L5:
        if (isRtl() == true) goto L7;
        return r100;
    L7:
        return (r101.getCount() - r100) - 1;
    }

    public int getItemCount() {
        if (getAdapter() != null) goto L6;
        return 0;
    L6:
        return getAdapter().getCount();
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.f452567a);
    }

    public ECRtlViewPager(Context r100) {
        super(r100);
        this.f452567a = 0;
        this.f452568b = new HashMap();
    }

    public static /* synthetic */ PagerAdapter h(ECRtlViewPager r100) {
        return super.getAdapter();
    }

    public static /* synthetic */ PagerAdapter i(ECRtlViewPager r100) {
        return super.getAdapter();
    }

    @Override // androidx.viewpager.widget.ViewPager
    public final void addOnPageChangeListener(ViewPager.OnPageChangeListener r100) {
        ReversingOnPageChangeListener r101 = new ReversingOnPageChangeListener(this, r100);
        this.f452568b.put(r100, r101);
        super.addOnPageChangeListener(r101);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r100) {
        return super.onInterceptTouchEvent(r100);
    L4:
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r100);
        return;
    L6:
        SavedState r101 = (SavedState) r100;
        this.f452567a = r101.f452574b;
        super.onRestoreInstanceState(r101.f452573a);
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int r100) {
        super.onRtlPropertiesChanged(r100);
        int r101 = 0;
        int r102 = 1;
        if (r100 == 1) goto L7;
        r102 = 0;
    L7:
        if (r102 == this.f452567a) goto L15;
        PagerAdapter r103 = super.getAdapter();
        if (r103 == null) goto L11;
        r101 = getCurrentItem();
    L11:
        this.f452567a = r102;
        if (r103 == null) goto L16;
        r103.notifyDataSetChanged();
        setCurrentItem(r101);
        return;
    L16:
        return;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        return super.onTouchEvent(r100);
    L5:
        if (r100.getAction() != 1) goto L8;
        r100.setAction(3);
        return super.onTouchEvent(r100);
    L8:
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public final void removeOnPageChangeListener(ViewPager.OnPageChangeListener r100) {
        super.removeOnPageChangeListener(this.f452568b.get(r100));
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setAdapter(PagerAdapter r100) {
        if (r100 == null) goto L4;
        r100 = new ReversingAdapter(this, r100);
    L4:
        super.setAdapter(r100);
        setCurrentItem(0);
    }

    public void setCheckScrollXWhenIdle(boolean r100) {
        this.f452569c = r100;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int r100) {
        PagerAdapter r101 = super.getAdapter();
        if (r101 != null) goto L5;
    L7:
        super.setCurrentItem(r100);
        return;
    L5:
        if (isRtl() == false) goto L7;
        r100 = (r101.getCount() - r100) - 1;
        goto L7
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener r100) {
        super.setOnPageChangeListener(new ReversingOnPageChangeListener(this, r100));
    }

    public ECRtlViewPager(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f452567a = 0;
        this.f452568b = new HashMap();
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public final int getChildDrawingOrder(int r100, int r101) {
        return super.getChildDrawingOrder(r100, r101);
    L4:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final void onMeasure(int r100, int r101) {
        if (View.MeasureSpec.getMode(r101) != 0) goto L12;
        int r102 = 0;
        int r103 = 0;
    L6:
        if (r102 >= getChildCount()) goto L11;
        View r104 = getChildAt(r102);
        r104.measure(r100, View.MeasureSpec.makeMeasureSpec(0, 0));
        int r105 = r104.getMeasuredHeight();
        if (r105 <= r103) goto L10;
        r103 = r105;
    L10:
        r102 = r102 + 1;
        goto L6
    L11:
        r101 = View.MeasureSpec.makeMeasureSpec(r103, 1073741824);
    L12:
        super.onMeasure(r100, r101);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public final void setCurrentItem(int r100, boolean r101) {
        PagerAdapter r102 = super.getAdapter();
        if (r102 != null) goto L5;
    L7:
        super.setCurrentItem(r100, r101);
        return;
    L5:
        if (isRtl() == false) goto L7;
        r100 = (r102.getCount() - r100) - 1;
        goto L7
    }
}
