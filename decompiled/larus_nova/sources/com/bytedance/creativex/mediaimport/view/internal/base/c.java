package com.bytedance.creativex.mediaimport.view.internal.base;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public abstract class c<DATA> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewPager f203824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f203825b;

    public abstract List<ti4.s<DATA>> a();

    public abstract PagerAdapter b();

    public c(ViewPager r100) {
        Intrinsics.checkNotNullParameter(r100, "innerViewPager");
        this.f203824a = r100;
        this.f203825b = LazyKt.lazy(new b(this));
    }

    public final boolean c(DATA r100) {
        Iterator<ti4.s<DATA>> r101 = a().iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(r101.next().f546102a, r100) == true) goto L10;
        r102 = r102 + 1;
    L10:
        Integer r103 = Integer.valueOf(r102);
        if (r103.intValue() < 0) goto L13;
        boolean r104 = true;
    L14:
        if (r104 == true) goto L17;
        r103 = null;
    L17:
        if (r103 == null) goto L22;
        d(r103.intValue(), false);
        return true;
    L22:
        return false;
    L13:
        r104 = false;
        goto L14
    L9:
        r102 = -1;
        goto L10
    }

    public final void d(int r100, boolean r101) {
        if (r100 >= b().getCount()) goto L6;
        this.f203824a.setCurrentItem(r100, r101);
        return;
    }
}
