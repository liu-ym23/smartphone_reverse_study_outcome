package com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.ParcelableCompat;
import androidx.core.os.ParcelableCompatCreatorCallbacks;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class DmtRtlViewPager extends DmtViewPager {
    public int h1;
    public final HashMap<ViewPager.OnPageChangeListener, c> k1;

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        public final Parcelable a;
        public final int b;

        public static class a implements ParcelableCompatCreatorCallbacks<SavedState> {
            public a() {
            }

            public final Object[] newArray(int r1) {
                return new SavedState[r1];
            }

            public final Object createFromParcel(Parcel r2, ClassLoader r3) {
                return new SavedState(r2, r3);
            }
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        static {
            CREATOR = ParcelableCompat.newCreator(new a());
        }

        public SavedState(Parcel r1, ClassLoader r2) {
            if (r2 != null) goto L5;
            r2 = getClass().getClassLoader();
        L5:
            this.a = r1.readParcelable(r2);
            this.b = r1.readInt();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r2, int r3) {
            r2.writeParcelable(this.a, r3);
            r2.writeInt(this.b);
        }

        public SavedState(Parcelable r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static class a extends DataSetObserver {
        public final b a;

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            b r0 = this.a;
            if (r0 == null) goto L6;
            r0.f();
            return;
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            onChanged();
        }

        public a(b r1) {
            this.a = r1;
        }
    }

    public class b extends FragmentPagerAdapter {
        public final PagerAdapter a;
        public final /* synthetic */ DmtRtlViewPager b;

        public final int getCount() {
            return this.a.getCount();
        }

        public final Parcelable saveState() {
            return this.a.saveState();
        }

        public final void f() {
            super/*androidx.viewpager.widget.PagerAdapter*/.notifyDataSetChanged();
        }

        public final void finishUpdate(ViewGroup r2) {
            this.a.finishUpdate(r2);
        }

        public final Fragment getItem(int r2) {
            if (this.b.D() == false) goto L6;
            r2 = (getCount() - r2) - 1;
        L6:
            return this.a.getItem(r2);
        }

        public final long getItemId(int r3) {
            if (this.b.D() == false) goto L6;
            r3 = (getCount() - r3) - 1;
        L6:
            return super.getItemId(r3);
        }

        public final int getItemPosition(Object r3) {
            int r4 = this.a.getItemPosition(r3);
            if (this.b.D() == true) goto L5;
            return r4;
        L5:
            if (r4 == (-1)) goto L9;
            if (r4 == (-2)) goto L9;
            return (getCount() - r4) - 1;
        L9:
            return -2;
        }

        public final CharSequence getPageTitle(int r2) {
            if (this.b.D() == false) goto L6;
            r2 = (getCount() - r2) - 1;
        L6:
            return this.a.getPageTitle(r2);
        }

        public final float getPageWidth(int r2) {
            if (this.b.D() == false) goto L6;
            r2 = (getCount() - r2) - 1;
        L6:
            return this.a.getPageWidth(r2);
        }

        public final void startUpdate(ViewGroup r2) {
            this.a.startUpdate(r2);
        }

        public b(DmtRtlViewPager r1, PagerAdapter r2) {
            this.b = r1;
            super(null);
            this.a = r2;
            r2.registerDataSetObserver(new a(this));
        }

        public final Object instantiateItem(View r2, int r3) {
            if (this.b.D() == false) goto L6;
            r3 = (getCount() - r3) - 1;
        L6:
            return this.a.instantiateItem(r2, r3);
        }

        public final boolean isViewFromObject(View r2, Object r3) {
            return this.a.isViewFromObject(r2, r3);
        }

        public final void restoreState(Parcelable r2, ClassLoader r3) {
            this.a.restoreState(r2, r3);
        }

        public final Object instantiateItem(ViewGroup r2, int r3) {
            if (this.b.D() == false) goto L6;
            r3 = (getCount() - r3) - 1;
        L6:
            return this.a.instantiateItem(r2, r3);
        }

        public final void destroyItem(ViewGroup r2, int r3, Object r4) {
            if (this.b.D() == false) goto L5;
            r3 = (getCount() - r3) - 1;
        L5:
            if (r3 >= 0) goto L7;
            r3 = 0;
        L7:
            this.a.destroyItem(r2, r3, r4);
        }

        public final void setPrimaryItem(View r2, int r3, Object r4) {
            if (this.b.D() == false) goto L5;
            r3 = (getCount() - r3) - 1;
        L5:
            this.a.setPrimaryItem(r2, r3, r4);
        }

        public final void destroyItem(View r2, int r3, Object r4) {
            if (this.b.D() == false) goto L5;
            r3 = (getCount() - r3) - 1;
        L5:
            this.a.destroyItem(r2, r3, r4);
        }

        public final void setPrimaryItem(ViewGroup r2, int r3, Object r4) {
            if (this.b.D() == false) goto L5;
            r3 = (getCount() - r3) - 1;
        L5:
            this.a.setPrimaryItem(r2, r3, r4);
        }
    }

    public class c implements ViewPager.OnPageChangeListener {
        public final ViewPager.OnPageChangeListener a;
        public final /* synthetic */ DmtRtlViewPager b;

        public final void onPageScrollStateChanged(int r2) {
            this.a.onPageScrollStateChanged(r2);
        }

        public final void onPageSelected(int r3) {
            PagerAdapter r0 = DmtRtlViewPager.C(this.b);
            if (this.b.D() == false) goto L6;
            if (r0 == null) goto L6;
            r3 = (r0.getCount() - r3) - 1;
        L6:
            this.a.onPageSelected(r3);
        }

        public c(DmtRtlViewPager r1, ViewPager.OnPageChangeListener r2) {
            this.b = r1;
            this.a = r2;
        }

        public final void onPageScrolled(int r4, float r5, int r6) {
            PagerAdapter r0 = DmtRtlViewPager.B(this.b);
            if (this.b.D() == false) goto L11;
            if (r0 == null) goto L11;
            int r1 = r0.getCount();
            if (r4 == (r1 - 1)) goto L8;
        L10:
            this.a.onPageScrolled((r1 - (r4 + 1)) - 1, 1.0f - r5, this.b.getWidth() - r6);
            return;
        L8:
            if (r5 != 0.0f) goto L10;
            r4 = r4 - 1;
            r6 = this.b.getWidth();
            r5 = 1.0f;
        L11:
            this.a.onPageScrolled(r4, r5, r6);
        }
    }

    public final boolean D() {
        if (this.h1 == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DmtViewPager
    public PagerAdapter getAdapter() {
        b r0 = super.getAdapter();
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.a;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DmtViewPager
    public int getCurrentItem() {
        int r0 = super.getCurrentItem();
        PagerAdapter r1 = super.getAdapter();
        if (r1 != null) goto L5;
        return r0;
    L5:
        if (D() == true) goto L7;
        return r0;
    L7:
        return (r1.getCount() - r0) - 1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DmtViewPager, android.view.View
    public final Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.h1);
    }

    public DmtRtlViewPager(Context r1) {
        super(r1);
        this.h1 = 0;
        this.k1 = new HashMap();
    }

    public static /* synthetic */ PagerAdapter B(DmtRtlViewPager r0) {
        return super.getAdapter();
    }

    public static /* synthetic */ PagerAdapter C(DmtRtlViewPager r0) {
        return super.getAdapter();
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DmtViewPager
    public final void b(ViewPager.OnPageChangeListener r3) {
        if (this.k1.containsKey(r3) == false) goto L5;
        return;
    L5:
        c r0 = new c(this, r3);
        this.k1.put(r3, r0);
        super.b(r0);
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DmtViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r2) {
        return super.onInterceptTouchEvent(r2);
    L4:
        e = move-exception;
        if ((e instanceof IllegalStateException) == false) goto L8;
    L9:
        e.printStackTrace();
        return false;
    L8:
        if ((e instanceof IllegalArgumentException) == true) goto L9;
        return false;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DmtViewPager, android.view.View
    public final void onRestoreInstanceState(Parcelable r2) {
        if ((r2 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r2);
        return;
    L6:
        SavedState r3 = (SavedState) r2;
        this.h1 = r3.b;
        super.onRestoreInstanceState(r3.a);
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int r3) {
        super.onRtlPropertiesChanged(r3);
        int r0 = 0;
        int r1 = 1;
        if (r3 == 1) goto L7;
        r1 = 0;
    L7:
        if (r1 == this.h1) goto L15;
        PagerAdapter r4 = super.getAdapter();
        if (r4 == null) goto L11;
        r0 = getCurrentItem();
    L11:
        this.h1 = r1;
        if (r4 == null) goto L16;
        r4.notifyDataSetChanged();
        setCurrentItem(r0);
        return;
    L16:
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DmtViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent r3) {
        return super.onTouchEvent(r3);
    L4:
        e = move-exception;
        if ((e instanceof IllegalStateException) == false) goto L8;
    L9:
        e.printStackTrace();
    L11:
        if (r3.getAction() != 1) goto L14;
        r3.setAction(3);
        return super.onTouchEvent(r3);
    L14:
        return false;
    L8:
        if ((e instanceof IllegalArgumentException) == false) goto L11;
        goto L9
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DmtViewPager
    public void setAdapter(PagerAdapter r2) {
        if (r2 == null) goto L4;
        r2 = new b(this, r2);
    L4:
        super.setAdapter(r2);
        setCurrentItem(0);
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DmtViewPager
    public void setCurrentItem(int r3) {
        PagerAdapter r0 = super.getAdapter();
        if (r0 != null) goto L5;
    L7:
        super.setCurrentItem(r3);
        return;
    L5:
        if (D() == false) goto L7;
        r3 = (r0.getCount() - r3) - 1;
        goto L7
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DmtViewPager
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener r2) {
        super.setOnPageChangeListener(new c(this, r2));
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DmtViewPager
    public final void v(ViewPager.OnPageChangeListener r2) {
        super.v(this.k1.get(r2));
        this.k1.remove(r2);
    }

    public DmtRtlViewPager(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.h1 = 0;
        this.k1 = new HashMap();
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DmtViewPager, android.view.ViewGroup
    public final int getChildDrawingOrder(int r1, int r2) {
        return super.getChildDrawingOrder(r1, r2);
    L4:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DmtViewPager, android.view.View
    public final void onMeasure(int r5, int r6) {
        if (View.MeasureSpec.getMode(r6) != 0) goto L12;
        int r0 = 0;
        int r1 = 0;
    L6:
        if (r0 >= getChildCount()) goto L11;
        View r2 = getChildAt(r0);
        r2.measure(r5, View.MeasureSpec.makeMeasureSpec(0, 0));
        int r3 = r2.getMeasuredHeight();
        if (r3 <= r1) goto L10;
        r1 = r3;
    L10:
        r0 = r0 + 1;
        goto L6
    L11:
        r6 = View.MeasureSpec.makeMeasureSpec(r1, 1073741824);
    L12:
        super.onMeasure(r5, r6);
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DmtViewPager
    public final void y(int r2, boolean r3) {
        PagerAdapter r4 = super.getAdapter();
        if (r4 != null) goto L5;
    L7:
        super.y(r2, true);
        return;
    L5:
        if (D() == false) goto L7;
        r2 = (r4.getCount() - r2) - 1;
        goto L7
    }
}
