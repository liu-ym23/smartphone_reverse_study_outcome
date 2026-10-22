package com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.ParcelableCompat;
import androidx.core.os.ParcelableCompatCreatorCallbacks;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.awemeopen.infra.base.env.AoEnv;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class RtlViewPager extends DmtViewPager {
    public float G1;
    public int h1;
    public final HashMap<ViewPager.OnPageChangeListener, b> k1;
    public boolean p1;
    public boolean v1;
    public boolean x1;
    public boolean y1;

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

    public class a extends DelegatingFragmentPagerAdapter {
        public final /* synthetic */ RtlViewPager b;

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DelegatingFragmentPagerAdapter
        public final Fragment getItem(int r2) {
            if (this.b.D() == false) goto L6;
            r2 = (getCount() - r2) - 1;
        L6:
            return super.getItem(r2);
        }

        public final long getItemId(int r3) {
            if (this.b.D() == false) goto L6;
            r3 = (getCount() - r3) - 1;
        L6:
            return super.getItemId(r3);
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DelegatingFragmentPagerAdapter
        public final int getItemPosition(Object r3) {
            int r4 = super.getItemPosition(r3);
            if (this.b.D() == true) goto L5;
            return r4;
        L5:
            if (r4 == (-1)) goto L9;
            if (r4 == (-2)) goto L9;
            return (getCount() - r4) - 1;
        L9:
            return -2;
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DelegatingFragmentPagerAdapter
        public final CharSequence getPageTitle(int r2) {
            if (this.b.D() == false) goto L6;
            r2 = (getCount() - r2) - 1;
        L6:
            return super.getPageTitle(r2);
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DelegatingFragmentPagerAdapter
        public final float getPageWidth(int r2) {
            if (this.b.D() == false) goto L6;
            r2 = (getCount() - r2) - 1;
        L6:
            return super.getPageWidth(r2);
        }

        public a(RtlViewPager r1, PagerAdapter r2) {
            this.b = r1;
            super(r2);
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DelegatingFragmentPagerAdapter
        public final Object instantiateItem(View r2, int r3) {
            if (this.b.D() == false) goto L6;
            r3 = (getCount() - r3) - 1;
        L6:
            return super.instantiateItem(r2, r3);
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DelegatingFragmentPagerAdapter
        public final Object instantiateItem(ViewGroup r2, int r3) {
            if (this.b.D() == false) goto L6;
            r3 = (getCount() - r3) - 1;
        L6:
            return super.instantiateItem(r2, r3);
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DelegatingFragmentPagerAdapter
        public final void destroyItem(ViewGroup r2, int r3, Object r4) {
            if (this.b.D() == false) goto L5;
            r3 = (getCount() - r3) - 1;
        L5:
            if (r3 >= 0) goto L7;
            r3 = 0;
        L7:
            super.destroyItem(r2, r3, r4);
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DelegatingFragmentPagerAdapter
        public final void setPrimaryItem(View r2, int r3, Object r4) {
            if (this.b.D() == false) goto L5;
            r3 = (getCount() - r3) - 1;
        L5:
            super.setPrimaryItem(r2, r3, r4);
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DelegatingFragmentPagerAdapter
        public final void destroyItem(View r2, int r3, Object r4) {
            if (this.b.D() == false) goto L5;
            r3 = (getCount() - r3) - 1;
        L5:
            super.destroyItem(r2, r3, r4);
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DelegatingFragmentPagerAdapter
        public final void setPrimaryItem(ViewGroup r2, int r3, Object r4) {
            if (this.b.D() == false) goto L5;
            r3 = (getCount() - r3) - 1;
        L5:
            super.setPrimaryItem(r2, r3, r4);
        }
    }

    public class b implements ViewPager.OnPageChangeListener {
        public final ViewPager.OnPageChangeListener a;
        public final /* synthetic */ RtlViewPager b;

        public final void onPageScrollStateChanged(int r3) {
            this.a.onPageScrollStateChanged(r3);
            RtlViewPager r0 = this.b;
            if (r0.p1 == false) goto L14;
            if (r3 == 0) goto L6;
            return;
        L6:
            if (r0.D() == false) goto L8;
            return;
        L8:
            if (this.b.getCurrentItem() == 0) goto L11;
            return;
        L11:
            if (this.b.getScrollX() <= 0) goto L17;
            this.b.setScrollX(0);
            return;
        L17:
            return;
        }

        public final void onPageSelected(int r3) {
            PagerAdapter r0 = RtlViewPager.C(this.b);
            if (this.b.D() == false) goto L6;
            if (r0 == null) goto L6;
            r3 = (r0.getCount() - r3) - 1;
        L6:
            this.a.onPageSelected(r3);
        }

        public b(RtlViewPager r1, ViewPager.OnPageChangeListener r2) {
            this.b = r1;
            this.a = r2;
        }

        public final void onPageScrolled(int r4, float r5, int r6) {
            PagerAdapter r0 = RtlViewPager.B(this.b);
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
        a r0 = super.getAdapter();
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

    public int getItemCount() {
        if (getAdapter() != null) goto L6;
        return 0;
    L6:
        return getAdapter().getCount();
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DmtViewPager, android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable r0 = super.onSaveInstanceState();
        if (AoEnv.j() == false) goto L6;
        return r0;
    L6:
        return new SavedState(r0, this.h1);
    }

    public RtlViewPager(Context r1) {
        super(r1);
        this.h1 = 0;
        this.k1 = new HashMap();
        this.v1 = true;
        this.x1 = true;
        this.y1 = true;
    }

    public static /* synthetic */ PagerAdapter B(RtlViewPager r0) {
        return super.getAdapter();
    }

    public static /* synthetic */ PagerAdapter C(RtlViewPager r0) {
        return super.getAdapter();
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DmtViewPager
    public final void b(ViewPager.OnPageChangeListener r3) {
        b r0 = new b(this, r3);
        this.k1.put(r3, r0);
        super.b(r0);
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DmtViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r5) {
        if (this.v1 == false) goto L11;
        if (this.x1 == true) goto L11;
        if (r5.getAction() != 0) goto L11;
        this.G1 = r5.getX();     // Catch: Exception -> L37
    L18:
        if (this.v1 == false) goto L25;
        if (this.y1 == true) goto L25;
        if (r5.getAction() != 0) goto L25;
        this.G1 = r5.getX();     // Catch: Exception -> L37
    L32:
        if (this.v1 == false) goto L40;
        if (super.onInterceptTouchEvent(r5) == false) goto L41;
        return true;
    L41:
        return false;
    L40:
        return false;
    L25:
        if (this.y1 == true) goto L32;
        if (r5.getAction() != 2) goto L32;
        float r1 = r5.getX();     // Catch: Exception -> L37
        if (this.G1 >= r1) goto L32;
        return false;
    L11:
        if (this.x1 == true) goto L18;
        if (r5.getAction() != 2) goto L18;
        float r2 = r5.getX();     // Catch: Exception -> L37
        if (this.G1 <= r2) goto L18;
        return false;
    L42:
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
    public boolean onTouchEvent(MotionEvent r6) {
        if (this.v1 == false) goto L13;
        if (this.x1 == true) goto L13;
        if (r6.getAction() != 2) goto L13;
        float r2 = r6.getX();     // Catch: Exception -> L28
        if (this.G1 <= r2) goto L13;
        return false;
    L13:
        if (this.v1 == false) goto L22;
        if (this.y1 == true) goto L22;
        if (r6.getAction() != 2) goto L22;
        float r3 = r6.getX();     // Catch: Exception -> L28
        if (this.G1 >= r3) goto L22;
        return false;
    L22:
        if (this.v1 == false) goto L26;
        if (super.onTouchEvent(r6) == false) goto L26;
        return true;
    L26:
        return false;
    L29:
        if (r6.getAction() != 1) goto L32;
        r6.setAction(3);
        return super.onTouchEvent(r6);
    L32:
        return false;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DmtViewPager
    public void setAdapter(PagerAdapter r2) {
        if (r2 == null) goto L4;
        r2 = new a(this, r2);
    L4:
        super.setAdapter(r2);
        setCurrentItem(0);
    }

    public void setCheckScrollXWhenIdle(boolean r1) {
        this.p1 = r1;
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

    public void setLeftSwipeEnabled(boolean r1) {
        this.y1 = r1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DmtViewPager
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener r2) {
        super.setOnPageChangeListener(new b(this, r2));
    }

    public void setRightSwipeEnabled(boolean r1) {
        this.x1 = r1;
    }

    public void setScrollable(boolean r1) {
        this.v1 = r1;
        if (r1 == true) goto L6;
        setCurrentItem(0);
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DmtViewPager
    public final void v(ViewPager.OnPageChangeListener r2) {
        super.v(this.k1.get(r2));
    }

    public RtlViewPager(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.h1 = 0;
        this.k1 = new HashMap();
        this.v1 = true;
        this.x1 = true;
        this.y1 = true;
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
    public void onMeasure(int r5, int r6) {
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
    public final void y(int r3, boolean r4) {
        PagerAdapter r0 = super.getAdapter();
        if (r0 != null) goto L5;
    L7:
        super.y(r3, r4);
        return;
    L5:
        if (D() == false) goto L7;
        r3 = (r0.getCount() - r3) - 1;
        goto L7
    }
}
