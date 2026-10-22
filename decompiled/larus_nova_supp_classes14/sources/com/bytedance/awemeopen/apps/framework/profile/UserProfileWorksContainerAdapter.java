package com.bytedance.awemeopen.apps.framework.profile;

import android.util.SparseArray;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DmtViewPager;
import com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.UserProfileViewPager;
import com.bytedance.awemeopen.apps.framework.profile.likes.UserProfileLikesFragment;
import com.bytedance.awemeopen.apps.framework.profile.likes.UserProfileLikesFragmentViewModel;
import com.bytedance.awemeopen.apps.framework.profile.works.UserProfileWorksFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/profile/UserProfileWorksContainerAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class UserProfileWorksContainerAdapter extends FragmentPagerAdapter {
    public final DmtViewPager a;
    public final Fragment b;
    public String c;
    public boolean d;
    public final boolean e;
    public final JSONObject f;
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

    /* JADX WARN: Multi-variable type inference failed */
    public final void g(String r6, boolean r7, JSONObject r8) {
        this.d = r7;
        this.c = r6;
        boolean r0 = false;
        Fragment r1 = f(0);
        UserProfileLikesFragment r3 = null;
        if ((r1 instanceof UserProfileWorksFragment) == false) goto L5;
        UserProfileWorksFragment r2 = (UserProfileWorksFragment) r1;
    L6:
        if (r2 == null) goto L8;
        r2.ma0(r6, r7, r8);
    L8:
        Fragment r4 = f(1);
        if ((r4 instanceof UserProfileLikesFragment) == false) goto L11;
        r3 = (UserProfileLikesFragment) r4;
    L11:
        if (r3 != null) goto L13;
        return;
    L13:
        if (r3.d == 0) goto L15;
        r0 = true;
    L15:
        if (r0 == false) goto L24;
        UserProfileLikesFragmentViewModel r5 = (UserProfileLikesFragmentViewModel) r3.W90();
        if (r6 != null) goto L19;
        r6 = "";
    L19:
        r5.setEnterAid(r6);
        ((UserProfileLikesFragmentViewModel) r3.W90()).setEnterIsLive(r7);
        if (r8 == null) goto L25;
        ((UserProfileLikesFragmentViewModel) r3.W90()).setHostExtraParams(r8);
        return;
    L25:
        return;
    L24:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public UserProfileWorksContainerAdapter(UserProfileViewPager r2, Fragment r3, String r4, boolean r5, boolean r6, JSONObject r7, String r8) {
        Intrinsics.checkNotNullParameter(r2, "viewPager");
        Intrinsics.checkNotNullParameter(r3, "fragment");
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
        r9.put(1, new sx3.a(AnonymousClass3.INSTANCE, new AnonymousClass4(this)));
    }
}
