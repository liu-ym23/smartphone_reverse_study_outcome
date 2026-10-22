package com.bytedance.awemeopen.apps.framework.feed.follow;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class LazyFragmentPagerAdapter extends LazyPagerAdapter<Fragment> {
    public final void finishUpdate(ViewGroup r1) {
    }

    public final void startUpdate(ViewGroup r1) {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.follow.LazyPagerAdapter
    public final /* bridge */ /* synthetic */ Fragment f(ViewGroup r1, int r2) {
        g(r1, r2);
        return null;
    }

    public final Fragment g(ViewGroup r2, int r3) {
        if (((Fragment) this.a.get(r3)) != null) goto L5;
        return null;
    L5:
        r2.getId();
        throw null;
    }

    public final Object instantiateItem(ViewGroup r1, int r2) {
        throw null;
    }

    public final boolean isViewFromObject(View r1, Object r2) {
        if (((Fragment) r2).getView() != r1) goto L5;
        return true;
    L5:
        return false;
    }

    public final void destroyItem(ViewGroup r1, int r2, Object r3) {
        throw null;
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [T, androidx.fragment.app.Fragment] */
    @Override // com.bytedance.awemeopen.apps.framework.feed.follow.LazyPagerAdapter
    public final void setPrimaryItem(ViewGroup r4, int r5, Object r6) {
        if (this.a.get(r5) == null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        startUpdate(r4);
        g(r4, r5);
        finishUpdate(r4);
    L8:
        ?? r7 = (Fragment) r6;
        T r8 = this.b;
        if (r7 == r8) goto L16;
        if (r8 == 0) goto L12;
        ((Fragment) r8).setMenuVisibility(false);
        ((Fragment) this.b).setUserVisibleHint(false);
    L12:
        if (r7 == 0) goto L14;
        r7.setMenuVisibility(true);
        r7.setUserVisibleHint(true);
    L14:
        this.b = r7;
        return;
    L16:
        return;
    L5:
        r0 = false;
        goto L6
    }
}
