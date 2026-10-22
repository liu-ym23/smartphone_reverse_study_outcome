package com.lynx.xelement.viewpager;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/lynx/xelement/viewpager/ReversingAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ViewPager_release"}, k = 1, mv = {1, 6, 0})
public final class ReversingAdapter extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PagerAdapter f384335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f384336b;

    public static final class a extends DataSetObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ReversingAdapter f384337a;

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            ReversingAdapter r100 = this.f384337a;
            if (r100 == null) goto L6;
            ReversingAdapter.f(r100);
            return;
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            onChanged();
        }

        public a(ReversingAdapter r100) {
            Intrinsics.checkNotNullParameter(r100, "mParent");
            this.f384337a = r100;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return this.f384335a.getCount();
    }

    public ReversingAdapter(PagerAdapter r100) {
        Intrinsics.checkNotNullParameter(r100, "mDelegete");
        this.f384335a = r100;
        r100.registerDataSetObserver(new a(this));
    }

    public static final void f(ReversingAdapter r100) {
        super.notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getItemPosition(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "object");
        int r101 = this.f384335a.getItemPosition(r100);
        if (this.f384336b == true) goto L5;
        return r101;
    L5:
        if (r101 != (-2)) goto L7;
    L9:
        return -2;
    L7:
        if (r101 == (-1)) goto L9;
        return (getCount() - r101) - 1;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final CharSequence getPageTitle(int r100) {
        if (this.f384336b == false) goto L6;
        r100 = (getCount() - r100) - 1;
    L6:
        return this.f384335a.getPageTitle(r100);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final float getPageWidth(int r100) {
        if (this.f384336b == false) goto L6;
        r100 = (getCount() - r100) - 1;
    L6:
        return this.f384335a.getPageWidth(r100);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @Deprecated(message = "")
    public final Object instantiateItem(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        if (this.f384336b == false) goto L6;
        r101 = (getCount() - r101) - 1;
    L6:
        return this.f384335a.instantiateItem(r100, r101);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "o");
        return this.f384335a.isViewFromObject(r100, r101);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        if (this.f384336b == false) goto L6;
        r101 = (getCount() - r101) - 1;
    L6:
        return this.f384335a.instantiateItem(r100, r101);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @Deprecated(message = "")
    public final void destroyItem(View r100, int r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, "object");
        if (this.f384336b == false) goto L5;
        r101 = (getCount() - r101) - 1;
    L5:
        this.f384335a.destroyItem(r100, r101, r102);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @Deprecated(message = "")
    public final void setPrimaryItem(View r100, int r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, "object");
        if (this.f384336b == false) goto L5;
        r101 = (getCount() - r101) - 1;
    L5:
        this.f384335a.setPrimaryItem(r100, r101, r102);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup r100, int r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, "object");
        if (this.f384336b == false) goto L5;
        r101 = (getCount() - r101) - 1;
    L5:
        this.f384335a.destroyItem(r100, r101, r102);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void setPrimaryItem(ViewGroup r100, int r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, "object");
        if (this.f384336b == false) goto L5;
        r101 = (getCount() - r101) - 1;
    L5:
        this.f384335a.setPrimaryItem(r100, r101, r102);
    }
}
