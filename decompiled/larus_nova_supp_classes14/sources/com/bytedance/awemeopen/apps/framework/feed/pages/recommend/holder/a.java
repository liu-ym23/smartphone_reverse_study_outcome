package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.holder;

import android.view.View;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.k;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.FeedGesturePresenterConfig;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.VideoFeedGesturePresenter;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.g;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends g<jz3.a> {
    public static final /* synthetic */ int h = 0;
    public String e;
    public final g04.b<jz3.a> f;
    public final oz3.d g;

    /* JADX INFO: renamed from: com.bytedance.awemeopen.apps.framework.feed.pages.recommend.holder.a$a, reason: collision with other inner class name */
    public static final class C0082a {
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final void f() {
        AoLogger.b("VideoFeedLiveViewHolder", new Object[]{"onSelected " + this.e});
        this.f.j();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final void g() {
        AoLogger.b("VideoFeedLiveViewHolder", new Object[]{"onUnBind " + this.e});
        this.f.k();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final void h() {
        AoLogger.b("VideoFeedLiveViewHolder", new Object[]{"onUnSelected " + this.e});
        this.f.l();
    }

    public a(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r6) {
        Intrinsics.checkNotNullParameter(r6, "feedGroupParameters");
        super(r6.a);
        g04.b<jz3.a> r0 = new g04.b(this.a);
        this.f = r0;
        oz3.d r1 = new oz3.d(r6, new k());
        this.g = r1;
        r0.m(r1);
        View r2 = r6.a.findViewById(2131375768);
        FeedGesturePresenterConfig r3 = new FeedGesturePresenterConfig();
        r3.b = new HostVideoFeedViewHolder$createFeedGesturePresenterConfig$1$1(this);
        r0.m(new VideoFeedGesturePresenter(r6, r2, r3));
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final void e(jz3.a r3, int r4) {
        jz3.a r5 = r3;
        Intrinsics.checkNotNullParameter(r5, "data");
        StringBuilder r6 = new StringBuilder("index:");
        r6.append(r5.d);
        r6.append("\nawemeId:");
        r6.append(r5.a.c());
        r6.append("\ncellRoom.rawData:");
        v14.a r0 = r5.a.j();
        if (r0 == null) goto L5;
        String r1 = r0.a();
    L6:
        r6.append(r1);
        r6.append('\n');
        this.e = r6.toString();
        AoLogger.l("VideoFeedLiveViewHolder", new Object[]{"onBind " + this.e});
        this.f.b(r5);
        return;
    L5:
        r1 = null;
        goto L6
    }
}
