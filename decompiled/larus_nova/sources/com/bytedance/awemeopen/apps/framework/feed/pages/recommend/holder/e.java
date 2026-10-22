package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.holder;

import android.view.View;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.FeedPagerListViewModel;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class e extends g<jz3.a> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f195140f = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FeedPagerListViewModel f195141e;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final void g() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final void f() {
        this.f195141e.getEnterSkeleton().setValue(Boolean.TRUE);
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final void h() {
        this.f195141e.getEnterSkeleton().setValue(Boolean.FALSE);
    }

    public e(View r100, FeedPagerListViewModel r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "vm");
        super(r100);
        this.f195141e = r101;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final void e(jz3.a r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }
}
