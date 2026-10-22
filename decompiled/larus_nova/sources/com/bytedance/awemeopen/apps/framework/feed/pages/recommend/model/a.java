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

/* JADX INFO: loaded from: classes14.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f195161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f195162b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f195163c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Activity f195164d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f195165e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g54.b f195166f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final vz3.c f195167g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function0<Integer> f195168h;

    public com.bytedance.awemeopen.apps.framework.utils.audio.a a() {
        LifecycleOwner r100 = this.f195165e.f195172d;
        if ((r100 instanceof AosFeedPagerListFragment) == false) goto L6;
        return ((AosFeedPagerListFragment) r100).f197024x;
    L6:
        if ((r100 instanceof AosFeedPagerListLayout) == true) goto L11;
        return null;
    L11:
        return ((AosFeedPagerListLayout) r100).getAudioHelper();
    }

    public k54.c b() {
        LifecycleOwner r100 = this.f195165e.f195172d;
        if ((r100 instanceof AosFeedPagerListFragment) == false) goto L6;
        ((AosFeedPagerListFragment) r100).getClass();
        return null;
    L6:
        if ((r100 instanceof AosFeedPagerListLayout) == true) goto L8;
        return null;
    L8:
        return ((AosFeedPagerListLayout) r100).getFeedPageListener();
    }

    public final Activity getActivity() {
        return this.f195164d;
    }

    public a(View r100, ViewGroup r101, o r102, Activity r103, b r104, g54.b r105, vz3.c r106, Function0<Integer> r107) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "viewPager");
        Intrinsics.checkNotNullParameter(r102, "vm");
        Intrinsics.checkNotNullParameter(r104, "pageOwner");
        Intrinsics.checkNotNullParameter(r105, "impression");
        Intrinsics.checkNotNullParameter(r106, "feedPageConfig");
        Intrinsics.checkNotNullParameter(r107, "bottomMargin");
        this.f195161a = r100;
        this.f195162b = r101;
        this.f195163c = r102;
        this.f195164d = r103;
        this.f195165e = r104;
        this.f195166f = r105;
        this.f195167g = r106;
        this.f195168h = r107;
    }
}
