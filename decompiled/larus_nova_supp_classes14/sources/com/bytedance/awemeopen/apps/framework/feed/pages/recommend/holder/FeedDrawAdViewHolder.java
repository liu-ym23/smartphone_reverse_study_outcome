package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.holder;

import android.app.Activity;
import android.content.Context;
import com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.RtlViewPager;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.AosRecomendFeedViewModel;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.f;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class FeedDrawAdViewHolder extends g<jz3.a> {
    public final Context e;
    public final f f;
    public final Lazy g;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final void f() {
        s54.a r0 = this.f.a;
        if (r0 == null) goto L5;
        r0.u();
    L5:
        Context r1 = this.e;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.app.Activity");
        RtlViewPager r2 = (RtlViewPager) ((Activity) r1).findViewById(2131363039);
        if (r2 == null) goto L9;
        r2.setScrollable(false);
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final void g() {
        s54.a r0 = this.f.a;
        if (r0 == null) goto L5;
        r0.c();
    L5:
        s54.a r1 = this.f.a;
        if (r1 == null) goto L9;
        r1.d();
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final void h() {
        s54.a r0 = this.f.a;
        if (r0 == null) goto L5;
        r0.b();
    L5:
        Context r1 = this.e;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.app.Activity");
        RtlViewPager r2 = (RtlViewPager) ((Activity) r1).findViewById(2131363039);
        if (r2 == null) goto L9;
        r2.setScrollable(true);
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final void e(jz3.a r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "data");
        s54.a r3 = this.f.a;
        if (r3 == null) goto L5;
        FeedDrawAdViewHolder$hostAdListener$2.a r4 = (FeedDrawAdViewHolder$hostAdListener$2.a) this.g.getValue();
        r3.d();
    L5:
        s54.a r5 = this.f.a;
        if (r5 == null) goto L9;
        new JSONObject();
        r5.onBind();
        return;
    }

    public FeedDrawAdViewHolder(Context r2, f r3, final AosRecomendFeedViewModel r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "feedDrawAd");
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        s54.a r0 = r3.a;
        Intrinsics.checkNotNull(r0);
        super(r0.a());
        this.e = r2;
        this.f = r3;
        this.g = LazyKt.lazy(new FeedDrawAdViewHolder$hostAdListener$2(this, r4));
    }
}
