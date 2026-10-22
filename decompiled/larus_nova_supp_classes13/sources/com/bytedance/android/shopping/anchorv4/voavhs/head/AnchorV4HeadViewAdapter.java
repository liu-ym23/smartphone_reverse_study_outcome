package com.bytedance.android.shopping.anchorv4.voavhs.head;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/AnchorV4HeadViewAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4HeadViewAdapter extends PagerAdapter {
    public final Map<View, com.bytedance.android.shopping.anchorv4.voavhs.head.base.a> a;
    public int b;
    public com.bytedance.android.shopping.anchorv4.voavhs.head.base.a c;
    public final com.bytedance.android.shopping.anchorv4.voavhs.head.base.f d;
    public List<? extends com.bytedance.android.shopping.anchorv4.voavhs.head.base.a> e;

    public final int getCount() {
        return this.e.size();
    }

    public final int getItemPosition(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "object");
        LinkedHashMap r0 = (LinkedHashMap) this.a;
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.a r3 = (com.bytedance.android.shopping.anchorv4.voavhs.head.base.a) r0.get((View) r2);
        int r4 = CollectionsKt.indexOf(this.e, r3);
        if (r4 != (-1)) goto L6;
        return -2;
    L6:
        return r4;
    }

    public AnchorV4HeadViewAdapter(com.bytedance.android.shopping.anchorv4.voavhs.head.base.f r2, List<? extends com.bytedance.android.shopping.anchorv4.voavhs.head.base.a> r3) {
        Intrinsics.checkNotNullParameter(r2, "viewPagerCallback");
        Intrinsics.checkNotNullParameter(r3, "holders");
        this.d = r2;
        this.e = r3;
        this.a = new LinkedHashMap();
        this.b = -1;
    }

    public final Object instantiateItem(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "container");
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.a r4 = (com.bytedance.android.shopping.anchorv4.voavhs.head.base.a) ListProtector.get(this.e, r3);
        View r0 = r4.b();
        r2.addView(r0);
        this.a.put(r0, r4);
        r4.d();
        return r0;
    }

    public final boolean isViewFromObject(View r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r3, "specific");
        return Intrinsics.areEqual(r2, r3);
    }

    public final void destroyItem(ViewGroup r1, int r2, Object r3) {
        Intrinsics.checkNotNullParameter(r1, "container");
        Intrinsics.checkNotNullParameter(r3, "object");
        View r4 = (View) r3;
        r1.removeView(r4);
        Object r5 = ((LinkedHashMap) this.a).get(r4);
        if ((r5 instanceof com.bytedance.android.shopping.anchorv4.voavhs.head.base.h) == true) goto L5;
        r5 = null;
    L5:
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.h r6 = (com.bytedance.android.shopping.anchorv4.voavhs.head.base.h) r5;
        if (r6 == null) goto L9;
        r6.j();
        return;
    }

    public final void setPrimaryItem(ViewGroup r4, int r5, Object r6) {
        Intrinsics.checkNotNullParameter(r4, "container");
        Intrinsics.checkNotNullParameter(r6, "object");
        super.setPrimaryItem(r4, r5, r6);
        LinkedHashMap r7 = (LinkedHashMap) this.a;
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.a r8 = (com.bytedance.android.shopping.anchorv4.voavhs.head.base.a) r7.get((View) r6);
        int r9 = this.b;
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.a r0 = this.c;
        this.b = r5;
        this.c = r8;
        if (r9 == r5) goto L10;
        if (r8 == null) goto L10;
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.f r1 = this.d;
        if (r9 != (-1)) goto L8;
        boolean r2 = true;
    L9:
        r1.c(r5, r2, r8.g());
        goto L10
    L8:
        r2 = false;
    L10:
        if (r9 == r5) goto L14;
        if (r0 == null) goto L15;
        this.d.e(r0.g());
        return;
    L15:
        return;
    }
}
