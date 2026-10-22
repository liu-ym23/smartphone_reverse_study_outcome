package com.bytedance.awemeopen.apps.framework.feed.home;

import android.util.SparseArray;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sx3.a;
import sx3.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/home/FeedHomeContainerAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class FeedHomeContainerAdapter extends FragmentPagerAdapter {
    public final SparseArray<b> a;

    public final int getCount() {
        return this.a.size();
    }

    public final Fragment getItem(int r2) {
        return this.a.get(r2).create();
    }

    public FeedHomeContainerAdapter(final Fragment r5, final FeedHomeContainerViewModel r6) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        Intrinsics.checkNotNullParameter(r6, "homeContainerViewModel");
        super(r5.getChildFragmentManager());
        SparseArray<b> r0 = new SparseArray();
        this.a = r0;
        r0.put(0, new a(AnonymousClass1.INSTANCE, new AnonymousClass2(r6, r5)));
        r0.put(1, new a(AnonymousClass3.INSTANCE, new AnonymousClass4(r6)));
    }
}
