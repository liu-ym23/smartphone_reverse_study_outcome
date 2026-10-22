package com.bytedance.android.shopping.store.aggregate.classification;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/store/aggregate/classification/ShopClassificationViewPagerAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopClassificationViewPagerAdapter extends FragmentPagerAdapter {
    public final List<Fragment> a;

    public final int getCount() {
        return ((ArrayList) this.a).size();
    }

    public ShopClassificationViewPagerAdapter(FragmentManager r2) {
        Intrinsics.checkNotNullParameter(r2, "fragmentManager");
        super(r2, 1);
        this.a = new ArrayList();
    }

    public final Fragment getItem(int r2) {
        Fragment r3 = (Fragment) CollectionsKt.getOrNull(this.a, r2);
        if (r3 == null) goto L5;
        return r3;
    L5:
        return new Fragment();
    }
}
