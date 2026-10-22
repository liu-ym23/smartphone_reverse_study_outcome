package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.holder;

import android.view.View;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.FeedPagerListViewModel;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e extends g<jz3.a> {
    public static final /* synthetic */ int f = 0;
    public final FeedPagerListViewModel e;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final void g() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final void f() {
        this.e.getEnterSkeleton().setValue(Boolean.TRUE);
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final void h() {
        this.e.getEnterSkeleton().setValue(Boolean.FALSE);
    }

    public e(View r2, FeedPagerListViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "vm");
        super(r2);
        this.e = r3;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final void e(jz3.a r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "data");
    }
}
