package com.bytedance.awemeopen.apps.framework.collect;

import android.util.SparseArray;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DmtViewPager;
import com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.UserProfileViewPager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/collect/UserCollectContainerAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class UserCollectContainerAdapter extends FragmentPagerAdapter {
    public final DmtViewPager a;
    public final Fragment b;
    public String c;
    public boolean d;
    public final String e;
    public final boolean f;
    public final String g;
    public final SparseArray<sx3.b> h;

    public final int getCount() {
        return this.h.size();
    }

    public final Fragment f(int r5) {
        return this.b.getChildFragmentManager().findFragmentByTag("android:switcher:" + this.a.getId() + ':' + r5);
    }

    public final Fragment getItem(int r2) {
        return this.h.get(r2).create();
    }

    public UserCollectContainerAdapter(UserProfileViewPager r2, Fragment r3, String r4, boolean r5, String r6, boolean r7, String r8) {
        Intrinsics.checkNotNullParameter(r2, "viewPager");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r6, "userOpenId");
        Intrinsics.checkNotNullParameter(r8, "hostEnterFrom");
        super(r3.getChildFragmentManager());
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        SparseArray<sx3.b> r9 = new SparseArray();
        this.h = r9;
        r9.put(0, new sx3.a(AnonymousClass1.INSTANCE, new AnonymousClass2(this)));
    }
}
