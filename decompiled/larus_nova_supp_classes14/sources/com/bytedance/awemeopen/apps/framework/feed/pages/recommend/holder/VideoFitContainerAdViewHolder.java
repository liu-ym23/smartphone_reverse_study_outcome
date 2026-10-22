package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.holder;

import android.view.View;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.i;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.FeedGesturePresenterConfig;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.VideoFeedGesturePresenter;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.k0;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.g;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class VideoFitContainerAdViewHolder extends g<jz3.a> {
    public static final /* synthetic */ int g = 0;
    public final g04.b<jz3.a> e;
    public String f;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final void f() {
        AoLogger.g("VideoFitContainerAdViewHolder", new Object[]{"onSelected " + this.f});
        this.e.j();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final void g() {
        AoLogger.g("VideoFitContainerAdViewHolder", new Object[]{"onUnBind " + this.f});
        this.e.k();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final void h() {
        AoLogger.g("VideoFitContainerAdViewHolder", new Object[]{"onUnSelected " + this.f});
        this.e.l();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final void e(jz3.a r3, int r4) {
        jz3.a r5 = r3;
        Intrinsics.checkNotNullParameter(r5, "data");
        this.f = "index:" + r5.d + "\nawemeId:" + r5.a.c();
        StringBuilder r0 = new StringBuilder("onBind ");
        r0.append(this.f);
        AoLogger.g("VideoFitContainerAdViewHolder", new Object[]{r0.toString()});
        this.e.b(r5);
    }

    public VideoFitContainerAdViewHolder(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r5, final l14.b r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "feedGroupParameters");
        Intrinsics.checkNotNullParameter(r6, "fitContainerAd");
        super(r5.a);
        g04.b<jz3.a> r8 = new g04.b(this.a);
        this.e = r8;
        final k0 r0 = new k0(r5, r6, new i());
        r8.m(new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.a(r5, AnonymousClass1.INSTANCE, new AnonymousClass2(r6)));
        r8.m(r0);
        View r1 = this.a.findViewById(2131375768);
        FeedGesturePresenterConfig r2 = new FeedGesturePresenterConfig();
        r2.a = new VideoFitContainerAdViewHolder$3$1(r6);
        r2.b = new VideoFitContainerAdViewHolder$3$2(r0);
        r2.d = new VideoFitContainerAdViewHolder$3$3(r6);
        r2.e = new VideoFitContainerAdViewHolder$3$4(r6);
        VideoFitContainerAdViewHolder$3$5 r9 = VideoFitContainerAdViewHolder$3$5.INSTANCE;
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        r2.f = r9;
        Unit r10 = Unit.INSTANCE;
        r8.m(new VideoFeedGesturePresenter(r5, r1, r2));
    }
}
