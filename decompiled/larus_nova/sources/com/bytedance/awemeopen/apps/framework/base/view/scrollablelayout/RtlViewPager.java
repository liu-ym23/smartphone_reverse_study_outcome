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

/* JADX INFO: loaded from: classes14.dex */
public class RtlViewPager extends DmtViewPager {
    public float G1;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public int f193551h1;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public final HashMap<ViewPager.OnPageChangeListener, b> f193552k1;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public boolean f193553p1;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public boolean f193554v1;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public boolean f193555x1;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public boolean f193556y1;

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Parcelable f193557a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f193558b;

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
            this.f193557a = r100.readParcelable(r101);
            this.f193558b = r100.readInt();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            r100.writeParcelable(this.f193557a, r101);
            r100.writeInt(this.f193558b);
        }

        public SavedState(Parcelable r100, int r101) {
            this.f193557a = r100;
            this.f193558b = r101;
        }
    }

    public class a extends DelegatingFragmentPagerAdapter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RtlViewPager f193559b;

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DelegatingFragmentPagerAdapter, androidx.fragment.app.FragmentPagerAdapter
        public final Fragment getItem(int r100) {
            if (this.f193559b.D() == false) goto L6;
            r100 = (getCount() - r100) - 1;
        L6:
            return super.getItem(r100);
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public final long getItemId(int r100) {
            if (this.f193559b.D() == false) goto L6;
            r100 = (getCount() - r100) - 1;
        L6:
            return super.getItemId(r100);
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DelegatingFragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public final int getItemPosition(Object r100) {
            int r101 = super.getItemPosition(r100);
            if (this.f193559b.D() == true) goto L5;
            return r101;
        L5:
            if (r101 == (-1)) goto L9;
            if (r101 == (-2)) goto L9;
            return (getCount() - r101) - 1;
        L9:
            return -2;
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DelegatingFragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public final CharSequence getPageTitle(int r100) {
            if (this.f193559b.D() == false) goto L6;
            r100 = (getCount() - r100) - 1;
        L6:
            return super.getPageTitle(r100);
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DelegatingFragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public final float getPageWidth(int r100) {
            if (this.f193559b.D() == false) goto L6;
            r100 = (getCount() - r100) - 1;
        L6:
            return super.getPageWidth(r100);
        }

        public a(RtlViewPager r100, PagerAdapter r101) {
            this.f193559b = r100;
            super(r101);
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DelegatingFragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public final Object instantiateItem(View r100, int r101) {
            if (this.f193559b.D() == false) goto L6;
            r101 = (getCount() - r101) - 1;
        L6:
            return super.instantiateItem(r100, r101);
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DelegatingFragmentPagerAdapter, androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public final Object instantiateItem(ViewGroup r100, int r101) {
            if (this.f193559b.D() == false) goto L6;
            r101 = (getCount() - r101) - 1;
        L6:
            return super.instantiateItem(r100, r101);
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DelegatingFragmentPagerAdapter, androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public final void destroyItem(ViewGroup r100, int r101, Object r102) {
            if (this.f193559b.D() == false) goto L5;
            r101 = (getCount() - r101) - 1;
        L5:
            if (r101 >= 0) goto L7;
            r101 = 0;
        L7:
            super.destroyItem(r100, r101, r102);
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DelegatingFragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public final void setPrimaryItem(View r100, int r101, Object r102) {
            if (this.f193559b.D() == false) goto L5;
            r101 = (getCount() - r101) - 1;
        L5:
            super.setPrimaryItem(r100, r101, r102);
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DelegatingFragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public final void destroyItem(View r100, int r101, Object r102) {
            if (this.f193559b.D() == false) goto L5;
            r101 = (getCount() - r101) - 1;
        L5:
            super.destroyItem(r100, r101, r102);
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DelegatingFragmentPagerAdapter, androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public final void setPrimaryItem(ViewGroup r100, int r101, Object r102) {
            if (this.f193559b.D() == false) goto L5;
            r101 = (getCount() - r101) - 1;
        L5:
            super.setPrimaryItem(r100, r101, r102);
        }
    }

    public class b implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewPager.OnPageChangeListener f193560a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RtlViewPager f193561b;

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int r100) {
            this.f193560a.onPageScrollStateChanged(r100);
            RtlViewPager r101 = this.f193561b;
            if (r101.f193553p1 == false) goto L14;
            if (r100 == 0) goto L6;
            return;
        L6:
            if (r101.D() == false) goto L8;
            return;
        L8:
            if (this.f193561b.getCurrentItem() == 0) goto L11;
            return;
        L11:
            if (this.f193561b.getScrollX() <= 0) goto L17;
            this.f193561b.setScrollX(0);
            return;
        L17:
            return;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int r100) {
            PagerAdapter r101 = RtlViewPager.C(this.f193561b);
            if (this.f193561b.D() == false) goto L6;
            if (r101 == null) goto L6;
            r100 = (r101.getCount() - r100) - 1;
        L6:
            this.f193560a.onPageSelected(r100);
        }

        public b(RtlViewPager r100, ViewPager.OnPageChangeListener r101) {
            this.f193561b = r100;
            this.f193560a = r101;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int r100, float r101, int r102) {
            PagerAdapter r103 = RtlViewPager.B(this.f193561b);
            if (this.f193561b.D() == false) goto L11;
            if (r103 == null) goto L11;
            int r104 = r103.getCount();
            if (r100 == (r104 - 1)) goto L8;
        L10:
            this.f193560a.onPageScrolled((r104 - (r100 + 1)) - 1, 1.0f - r101, this.f193561b.getWidth() - r102);
            return;
        L8:
            if (r101 != 0.0f) goto L10;
            r100 = r100 - 1;
            r102 = this.f193561b.getWidth();
            r101 = 1.0f;
        L11:
            this.f193560a.onPageScrolled(r100, r101, r102);
        }
    }

    public final boolean D() {
        if (this.f193551h1 == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DmtViewPager
    public PagerAdapter getAdapter() {
        a r100 = (a) super.getAdapter();
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.f193490a;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DmtViewPager
    public int getCurrentItem() {
        int r100 = super.getCurrentItem();
        PagerAdapter r101 = super.getAdapter();
        if (r101 != null) goto L5;
        return r100;
    L5:
        if (D() == true) goto L7;
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

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DmtViewPager, android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable r100 = super.onSaveInstanceState();
        if (AoEnv.j() == false) goto L6;
        return r100;
    L6:
        return new SavedState(r100, this.f193551h1);
    }

    public RtlViewPager(Context r100) {
        super(r100);
        this.f193551h1 = 0;
        this.f193552k1 = new HashMap();
        this.f193554v1 = true;
        this.f193555x1 = true;
        this.f193556y1 = true;
    }

    public static /* synthetic */ PagerAdapter B(RtlViewPager r100) {
        return super.getAdapter();
    }

    public static /* synthetic */ PagerAdapter C(RtlViewPager r100) {
        return super.getAdapter();
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DmtViewPager
    public final void b(ViewPager.OnPageChangeListener r100) {
        b r101 = new b(this, r100);
        this.f193552k1.put(r100, r101);
        super.b(r101);
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DmtViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f193554v1 == false) goto L11;
        if (this.f193555x1 == true) goto L11;
        if (r100.getAction() != 0) goto L11;
        this.G1 = r100.getX();     // Catch: Exception -> L37
    L18:
        if (this.f193554v1 == false) goto L25;
        if (this.f193556y1 == true) goto L25;
        if (r100.getAction() != 0) goto L25;
        this.G1 = r100.getX();     // Catch: Exception -> L37
    L32:
        if (this.f193554v1 == false) goto L40;
        if (super.onInterceptTouchEvent(r100) == false) goto L41;
        return true;
    L41:
        return false;
    L40:
        return false;
    L25:
        if (this.f193556y1 == true) goto L32;
        if (r100.getAction() != 2) goto L32;
        float r101 = r100.getX();     // Catch: Exception -> L37
        if (this.G1 >= r101) goto L32;
        return false;
    L11:
        if (this.f193555x1 == true) goto L18;
        if (r100.getAction() != 2) goto L18;
        float r102 = r100.getX();     // Catch: Exception -> L37
        if (this.G1 <= r102) goto L18;
        return false;
    L42:
        return false;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DmtViewPager, android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r100);
        return;
    L6:
        SavedState r101 = (SavedState) r100;
        this.f193551h1 = r101.f193558b;
        super.onRestoreInstanceState(r101.f193557a);
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int r100) {
        super.onRtlPropertiesChanged(r100);
        int r101 = 0;
        int r102 = 1;
        if (r100 == 1) goto L7;
        r102 = 0;
    L7:
        if (r102 == this.f193551h1) goto L15;
        PagerAdapter r103 = super.getAdapter();
        if (r103 == null) goto L11;
        r101 = getCurrentItem();
    L11:
        this.f193551h1 = r102;
        if (r103 == null) goto L16;
        r103.notifyDataSetChanged();
        setCurrentItem(r101);
        return;
    L16:
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DmtViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        if (this.f193554v1 == false) goto L13;
        if (this.f193555x1 == true) goto L13;
        if (r100.getAction() != 2) goto L13;
        float r101 = r100.getX();     // Catch: Exception -> L28
        if (this.G1 <= r101) goto L13;
        return false;
    L13:
        if (this.f193554v1 == false) goto L22;
        if (this.f193556y1 == true) goto L22;
        if (r100.getAction() != 2) goto L22;
        float r102 = r100.getX();     // Catch: Exception -> L28
        if (this.G1 >= r102) goto L22;
        return false;
    L22:
        if (this.f193554v1 == false) goto L26;
        if (super.onTouchEvent(r100) == false) goto L26;
        return true;
    L26:
        return false;
    L29:
        if (r100.getAction() != 1) goto L32;
        r100.setAction(3);
        return super.onTouchEvent(r100);
    L32:
        return false;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DmtViewPager
    public void setAdapter(PagerAdapter r100) {
        if (r100 == null) goto L4;
        r100 = new a(this, r100);
    L4:
        super.setAdapter(r100);
        setCurrentItem(0);
    }

    public void setCheckScrollXWhenIdle(boolean r100) {
        this.f193553p1 = r100;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DmtViewPager
    public void setCurrentItem(int r100) {
        PagerAdapter r101 = super.getAdapter();
        if (r101 != null) goto L5;
    L7:
        super.setCurrentItem(r100);
        return;
    L5:
        if (D() == false) goto L7;
        r100 = (r101.getCount() - r100) - 1;
        goto L7
    }

    public void setLeftSwipeEnabled(boolean r100) {
        this.f193556y1 = r100;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DmtViewPager
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener r100) {
        super.setOnPageChangeListener(new b(this, r100));
    }

    public void setRightSwipeEnabled(boolean r100) {
        this.f193555x1 = r100;
    }

    public void setScrollable(boolean r100) {
        this.f193554v1 = r100;
        if (r100 == true) goto L6;
        setCurrentItem(0);
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DmtViewPager
    public final void v(ViewPager.OnPageChangeListener r100) {
        super.v(this.f193552k1.get(r100));
    }

    public RtlViewPager(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f193551h1 = 0;
        this.f193552k1 = new HashMap();
        this.f193554v1 = true;
        this.f193555x1 = true;
        this.f193556y1 = true;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DmtViewPager, android.view.ViewGroup
    public final int getChildDrawingOrder(int r100, int r101) {
        return super.getChildDrawingOrder(r100, r101);
    L4:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DmtViewPager, android.view.View
    public void onMeasure(int r100, int r101) {
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

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DmtViewPager
    public final void y(int r100, boolean r101) {
        PagerAdapter r102 = super.getAdapter();
        if (r102 != null) goto L5;
    L7:
        super.y(r100, r101);
        return;
    L5:
        if (D() == false) goto L7;
        r100 = (r102.getCount() - r100) - 1;
        goto L7
    }
}
