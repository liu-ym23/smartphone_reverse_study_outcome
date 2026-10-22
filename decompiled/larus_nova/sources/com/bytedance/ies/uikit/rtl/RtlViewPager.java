package com.bytedance.ies.uikit.rtl;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.ParcelableCompat;
import androidx.core.os.ParcelableCompatCreatorCallbacks;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import java.util.HashMap;

/* JADX INFO: loaded from: classes19.dex */
public class RtlViewPager extends ViewPager {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f249180c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f249181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<ViewPager.OnPageChangeListener, b> f249182b;

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Parcelable f249183a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f249184b;

        public static class a implements ParcelableCompatCreatorCallbacks<SavedState> {
            public a() {
            }

            @Override // androidx.core.os.ParcelableCompatCreatorCallbacks
            public final SavedState[] newArray(int r100) {
                return new SavedState[r100];
            }

            @Override // androidx.core.os.ParcelableCompatCreatorCallbacks
            public final SavedState createFromParcel(Parcel r100, ClassLoader r101) {
                return new SavedState(r100, r101);
            }
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        static {
            CREATOR = ParcelableCompat.newCreator(new a());
        }

        public SavedState(Parcel r100, ClassLoader r101) {
            if (r101 != null) goto L5;
            r101 = getClass().getClassLoader();
        L5:
            this.f249183a = r100.readParcelable(r101);
            this.f249184b = r100.readInt();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            r100.writeParcelable(this.f249183a, r101);
            r100.writeInt(this.f249184b);
        }

        public SavedState(Parcelable r100, int r101) {
            this.f249183a = r100;
            this.f249184b = r101;
        }
    }

    public class a extends DelegatingPagerAdapter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RtlViewPager f249185b;

        @Override // com.bytedance.ies.uikit.rtl.DelegatingPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public final int getItemPosition(Object r100) {
            int r101 = super.getItemPosition(r100);
            RtlViewPager r102 = this.f249185b;
            int r103 = RtlViewPager.f249180c;
            if (r102.isRtl() == true) goto L5;
            return r101;
        L5:
            if (r101 == (-1)) goto L9;
            if (r101 == (-2)) goto L9;
            return (getCount() - r101) - 1;
        L9:
            return -2;
        }

        @Override // com.bytedance.ies.uikit.rtl.DelegatingPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public final CharSequence getPageTitle(int r100) {
            RtlViewPager r101 = this.f249185b;
            int r102 = RtlViewPager.f249180c;
            if (r101.isRtl() == false) goto L6;
            r100 = (getCount() - r100) - 1;
        L6:
            return super.getPageTitle(r100);
        }

        @Override // com.bytedance.ies.uikit.rtl.DelegatingPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public final float getPageWidth(int r100) {
            RtlViewPager r101 = this.f249185b;
            int r102 = RtlViewPager.f249180c;
            if (r101.isRtl() == false) goto L6;
            r100 = (getCount() - r100) - 1;
        L6:
            return super.getPageWidth(r100);
        }

        public a(RtlViewPager r100, PagerAdapter r101) {
            this.f249185b = r100;
            super(r101);
        }

        @Override // com.bytedance.ies.uikit.rtl.DelegatingPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public final Object instantiateItem(View r100, int r101) {
            RtlViewPager r102 = this.f249185b;
            int r103 = RtlViewPager.f249180c;
            if (r102.isRtl() == false) goto L6;
            r101 = (getCount() - r101) - 1;
        L6:
            return super.instantiateItem(r100, r101);
        }

        @Override // com.bytedance.ies.uikit.rtl.DelegatingPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public final Object instantiateItem(ViewGroup r100, int r101) {
            RtlViewPager r102 = this.f249185b;
            int r103 = RtlViewPager.f249180c;
            if (r102.isRtl() == false) goto L6;
            r101 = (getCount() - r101) - 1;
        L6:
            return super.instantiateItem(r100, r101);
        }

        @Override // com.bytedance.ies.uikit.rtl.DelegatingPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public final void destroyItem(View r100, int r101, Object r102) {
            RtlViewPager r103 = this.f249185b;
            int r104 = RtlViewPager.f249180c;
            if (r103.isRtl() == false) goto L5;
            r101 = (getCount() - r101) - 1;
        L5:
            super.destroyItem(r100, r101, r102);
        }

        @Override // com.bytedance.ies.uikit.rtl.DelegatingPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public final void setPrimaryItem(View r100, int r101, Object r102) {
            RtlViewPager r103 = this.f249185b;
            int r104 = RtlViewPager.f249180c;
            if (r103.isRtl() == false) goto L5;
            r101 = (getCount() - r101) - 1;
        L5:
            super.setPrimaryItem(r100, r101, r102);
        }

        @Override // com.bytedance.ies.uikit.rtl.DelegatingPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public final void destroyItem(ViewGroup r100, int r101, Object r102) {
            RtlViewPager r103 = this.f249185b;
            int r104 = RtlViewPager.f249180c;
            if (r103.isRtl() == false) goto L5;
            r101 = (getCount() - r101) - 1;
        L5:
            super.destroyItem(r100, r101, r102);
        }

        @Override // com.bytedance.ies.uikit.rtl.DelegatingPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public final void setPrimaryItem(ViewGroup r100, int r101, Object r102) {
            RtlViewPager r103 = this.f249185b;
            int r104 = RtlViewPager.f249180c;
            if (r103.isRtl() == false) goto L5;
            r101 = (getCount() - r101) - 1;
        L5:
            super.setPrimaryItem(r100, r101, r102);
        }
    }

    public class b implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewPager.OnPageChangeListener f249186a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RtlViewPager f249187b;

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int r100) {
            this.f249186a.onPageScrollStateChanged(r100);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int r100) {
            PagerAdapter r101 = RtlViewPager.i(this.f249187b);
            if (this.f249187b.isRtl() == false) goto L6;
            if (r101 == null) goto L6;
            r100 = (r101.getCount() - r100) - 1;
        L6:
            this.f249186a.onPageSelected(r100);
        }

        public b(RtlViewPager r100, ViewPager.OnPageChangeListener r101) {
            this.f249187b = r100;
            this.f249186a = r101;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int r100, float r101, int r102) {
            int r103 = this.f249187b.getWidth();
            PagerAdapter r104 = RtlViewPager.h(this.f249187b);
            if (this.f249187b.isRtl() == false) goto L10;
            if (r104 == null) goto L10;
            int r105 = r104.getCount();
            float r106 = r103;
            int r107 = ((int) ((1.0f - r104.getPageWidth(r100)) * r106)) + r102;
        L6:
            if (r100 >= r105) goto L9;
            if (r107 <= 0) goto L9;
            r100 = r100 + 1;
            r107 = r107 - ((int) (r104.getPageWidth(r100) * r106));
        L9:
            r100 = (r105 - r100) - 1;
            r102 = -r107;
            r101 = r102 / (r106 * r104.getPageWidth(r100));
        L10:
            this.f249186a.onPageScrolled(r100, r101, r102);
        }
    }

    public final boolean isRtl() {
        if (this.f249181a == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public final void clearOnPageChangeListeners() {
        super.clearOnPageChangeListeners();
        this.f249182b.clear();
    }

    @Override // androidx.viewpager.widget.ViewPager
    public PagerAdapter getAdapter() {
        a r100 = (a) super.getAdapter();
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.f249178a;
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

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.f249181a);
    }

    public RtlViewPager(Context r100) {
        super(r100);
        this.f249181a = 0;
        this.f249182b = new HashMap();
    }

    public static /* synthetic */ PagerAdapter h(RtlViewPager r100) {
        return super.getAdapter();
    }

    public static /* synthetic */ PagerAdapter i(RtlViewPager r100) {
        return super.getAdapter();
    }

    @Override // androidx.viewpager.widget.ViewPager
    public final void addOnPageChangeListener(ViewPager.OnPageChangeListener r100) {
        b r101 = new b(this, r100);
        this.f249182b.put(r100, r101);
        super.addOnPageChangeListener(r101);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r100);
        return;
    L6:
        SavedState r101 = (SavedState) r100;
        this.f249181a = r101.f249184b;
        super.onRestoreInstanceState(r101.f249183a);
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int r100) {
        super.onRtlPropertiesChanged(r100);
        int r101 = 0;
        int r102 = 1;
        if (r100 == 1) goto L7;
        r102 = 0;
    L7:
        if (r102 == this.f249181a) goto L15;
        PagerAdapter r103 = super.getAdapter();
        if (r103 == null) goto L11;
        r101 = getCurrentItem();
    L11:
        this.f249181a = r102;
        if (r103 == null) goto L16;
        r103.notifyDataSetChanged();
        setCurrentItem(r101);
        return;
    L16:
        return;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public final void removeOnPageChangeListener(ViewPager.OnPageChangeListener r100) {
        b r101 = this.f249182b.remove(r100);
        if (r101 == null) goto L6;
        super.removeOnPageChangeListener(r101);
        return;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setAdapter(PagerAdapter r100) {
        if (r100 == null) goto L4;
        r100 = new a(this, r100);
    L4:
        super.setAdapter(r100);
        setCurrentItem(0);
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
        super.setOnPageChangeListener(new b(this, r100));
    }

    public RtlViewPager(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f249181a = 0;
        this.f249182b = new HashMap();
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
