package com.bytedance.android.shopping.store.tabkit;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/TabKitFragmentPagerAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabKitFragmentPagerAdapter extends FragmentPagerAdapter {
    public final LinkedList<TabKitTabFragment> a;

    public final int getItemPosition(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "any");
        return -2;
    }

    public final int getCount() {
        return this.a.size();
    }

    public TabKitFragmentPagerAdapter(FragmentManager r2) {
        Intrinsics.checkNotNullParameter(r2, "fragmentManager");
        super(r2);
        this.a = new LinkedList();
    }

    public final Fragment getItem(int r2) {
        return this.a.get(r2);
    }

    public final long getItemId(int r3) {
        return this.a.get(r3).hashCode();
    }
}
