package com.bytedance.android.shopping.anchorv4.voavhs.detailhead;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/AutoHeightViewPager;", "Landroidx/viewpager/widget/ViewPager;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AutoHeightViewPager extends ViewPager {
    public int a;

    /* JADX WARN: Multi-variable type inference failed */
    public final void h(int r2) {
        PagerAdapter r0 = getAdapter();
        if (r0 == null) goto L5;
        int r1 = r0.getCount();
    L6:
        if (r1 <= r2) goto L12;
        ViewGroup.LayoutParams r3 = getLayoutParams();
        if (r3 == null) goto L11;
        LinearLayout.LayoutParams r4 = (LinearLayout.LayoutParams) r3;
        r4.height = this.a;
        setLayoutParams(r4);
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L12:
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public AutoHeightViewPager(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        addOnPageChangeListener(new AutoHeightViewPager$addPageChangeListener$1(this));
    }

    public final void onMeasure(int r3, int r4) {
        PagerAdapter r5 = getAdapter();
        View r1 = null;
        if ((r5 instanceof FragmentPagerAdapter) == true) goto L5;
        r5 = null;
    L5:
        FragmentPagerAdapter r6 = (FragmentPagerAdapter) r5;
        if (r6 == null) goto L10;
        Fragment r7 = r6.getItem(getCurrentItem());
        if (r7 == null) goto L10;
        r1 = r7.getView();
    L10:
        if (r1 == null) goto L12;
        r1.measure(r3, View.MeasureSpec.makeMeasureSpec(0, 0));
        this.a = r1.getMeasuredHeight();
    L12:
        super.onMeasure(r3, View.MeasureSpec.makeMeasureSpec(this.a, 1073741824));
    }
}
