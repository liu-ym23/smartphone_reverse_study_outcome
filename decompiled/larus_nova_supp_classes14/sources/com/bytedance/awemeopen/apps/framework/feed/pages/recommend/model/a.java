package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosFeedPagerListLayout;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.AosFeedPagerListFragment;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.o;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class a {
    public final View a;
    public final ViewGroup b;
    public final o c;
    public final Activity d;
    public final b e;
    public final g54.b f;
    public final vz3.c g;
    public final Function0<Integer> h;

    public com.bytedance.awemeopen.apps.framework.utils.audio.a a() {
        LifecycleOwner r0 = this.e.d;
        if ((r0 instanceof AosFeedPagerListFragment) == false) goto L6;
        return ((AosFeedPagerListFragment) r0).x;
    L6:
        if ((r0 instanceof AosFeedPagerListLayout) == true) goto L11;
        return null;
    L11:
        return ((AosFeedPagerListLayout) r0).getAudioHelper();
    }

    public k54.c b() {
        LifecycleOwner r0 = this.e.d;
        if ((r0 instanceof AosFeedPagerListFragment) == false) goto L6;
        ((AosFeedPagerListFragment) r0).getClass();
        return null;
    L6:
        if ((r0 instanceof AosFeedPagerListLayout) == true) goto L8;
        return null;
    L8:
        return ((AosFeedPagerListLayout) r0).getFeedPageListener();
    }

    public final Activity getActivity() {
        return this.d;
    }

    public a(View r2, ViewGroup r3, o r4, Activity r5, b r6, g54.b r7, vz3.c r8, Function0<Integer> r9) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "viewPager");
        Intrinsics.checkNotNullParameter(r4, "vm");
        Intrinsics.checkNotNullParameter(r6, "pageOwner");
        Intrinsics.checkNotNullParameter(r7, "impression");
        Intrinsics.checkNotNullParameter(r8, "feedPageConfig");
        Intrinsics.checkNotNullParameter(r9, "bottomMargin");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
