package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.holder;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.p;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.FeedGesturePresenterConfig;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.LongPressSpeedPresenterConfig;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.FeedLongPressFastSpeedPresenter;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.VideoFeedGesturePresenter;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.VideoFeedPlayerPresenter;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.f0;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.i;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.j;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.n0;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.o;
import com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.FeedPinchPresenter;
import com.bytedance.awemeopen.apps.framework.feed.ui.page.VideoFeedPage;
import com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.RightBarGroup;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.g;
import com.bytedance.awemeopen.apps.framework.landscape.f;
import com.bytedance.awemeopen.apps.framework.player.FullVideoView;
import com.bytedance.awemeopen.bizmodels.feed.Video;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import pz3.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class VideoFeedViewHolder extends g<jz3.a> {
    public static final /* synthetic */ int p = 0;
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a e;
    public String f;
    public final g04.b<jz3.a> g;
    public final j h;
    public final VideoFeedPlayerPresenter i;
    public final Lazy j;
    public final VideoFeedGesturePresenter k;
    public boolean l;
    public final VideoFeedPage m;
    public final TextView n;
    public boolean o;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final void f() {
        AoLogger.b("VideoFeedVideoViewHolder", new Object[]{"onSelected " + this.f});
        jz3.a r1 = (jz3.a) this.b;
        if (r1 == null) goto L5;
        r14.c r2 = r1.a;
    L6:
        if (r2 == null) goto L9;
        r2.q = true;
    L9:
        this.g.j();
        this.m.a();
        if (this.e.c.getPageConfig().getNeedOpenComment() == false) goto L13;
        this.m.l.o.g().a.b(Boolean.TRUE);
        return;
    L13:
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final void g() {
        AoLogger.b("VideoFeedVideoViewHolder", new Object[]{"onUnBind " + this.f});
        this.g.k();
        this.m.i();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final void h() {
        AoLogger.b("VideoFeedVideoViewHolder", new Object[]{"onUnSelected " + this.f});
        this.g.l();
        this.m.d();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final boolean d() {
        return this.m.j();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final void j() {
        this.k.m(null);
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final void m() {
        RightBarGroup r0 = this.m.l;
        r0.m.t();
        r0.n.r();
        r0.q.r(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void o(boolean r3) {
        View r0 = this.a.findViewById(2131373353);
        if (r0 == null) goto L19;
        if (r3 == true) goto L16;
        boolean r4 = f.a;
        jz3.a r5 = (jz3.a) this.b;
        if (r5 == null) goto L11;
        r14.c r6 = r5.a;
        if (r6 == null) goto L11;
        Video r7 = r6.P();
    L13:
        if (f.b(r7) == false) goto L16;
        int r8 = 0;
    L17:
        r0.setVisibility(r8);
        return;
    L11:
        r7 = null;
    L16:
        r8 = 8;
        goto L17
    }

    public static final void n(VideoFeedViewHolder r3, boolean r4) {
        ViewGroup r0 = r3.m.b;
        boolean r1 = false;
        if (r4 == false) goto L5;
        int r2 = 8;
    L6:
        r0.setVisibility(r2);
        if (r4 == false) goto L9;
    L10:
        r1 = true;
    L11:
        r3.o(r1);
        return;
    L9:
        if (r3.o == false) goto L11;
    L5:
        r2 = 0;
        goto L6
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final void e(jz3.a r3, int r4) {
        jz3.a r5 = r3;
        Intrinsics.checkNotNullParameter(r5, "data");
        StringBuilder r6 = new StringBuilder("index:");
        r6.append(r5.d);
        r6.append("\nawemeId:");
        r6.append(r5.a.c());
        r6.append("\nuserOpenId:");
        User r0 = r5.a.f();
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.u();
    L6:
        r6.append(r2);
        r6.append("\nnickName:");
        User r7 = r5.a.f();
        if (r7 == null) goto L9;
        r1 = r7.t();
    L9:
        r6.append(r1);
        r6.append('\n');
        this.f = r6.toString();
        AoLogger.b("VideoFeedVideoViewHolder", new Object[]{"onBind " + this.f});
        this.g.b(r5);
        this.m.b(r5);
        if (r5.f == true) goto L12;
        this.m.b.setVisibility(0);
    L14:
        if (this.l == false) goto L16;
        this.n.setVisibility(0);
        this.n.setText(((FullVideoView) this.a.findViewById(2131375746)).getPlayerType());
        return;
    L16:
        this.n.setVisibility(8);
        return;
    L12:
        this.m.b.setVisibility(8);
        goto L14
    L5:
        r2 = null;
        goto L6
    }

    public /* synthetic */ VideoFeedViewHolder(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r7, com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d r8, p r9, com.bytedance.awemeopen.apps.framework.player.e r10) {
        this(r7, r8, r9, r10, null);
    }

    public VideoFeedViewHolder(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r21, com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d r22, p r23, com.bytedance.awemeopen.apps.framework.player.e r24, Function1<? super String, Long> r25) {
        Intrinsics.checkNotNullParameter(r21, "feedGroupParameters");
        Intrinsics.checkNotNullParameter(r22, "seekBar");
        Intrinsics.checkNotNullParameter(r23, "eventRecorder");
        Intrinsics.checkNotNullParameter(r24, "videoPrePreRenderHelper");
        super(r21.a);
        this.e = r21;
        g04.b<jz3.a> r5 = new g04.b(this.a);
        this.g = r5;
        j r6 = new j(r21.a);
        this.h = r6;
        VideoFeedPlayerPresenter r7 = new VideoFeedPlayerPresenter(r21, r23, r24, r25);
        this.i = r7;
        Lazy r3 = LazyKt.lazy(VideoFeedViewHolder$videoLeftBottomAd$2.INSTANCE);
        this.j = r3;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r8 = this.e;
        View r9 = r8.a.findViewById(2131375768);
        FeedGesturePresenterConfig r10 = new FeedGesturePresenterConfig();
        r10.a = new VideoFeedViewHolder$createFeedGesturePresenterConfig$1$1(this);
        r10.b = new VideoFeedViewHolder$createFeedGesturePresenterConfig$1$2(this);
        r10.c = new VideoFeedViewHolder$createFeedGesturePresenterConfig$1$3(this);
        VideoFeedViewHolder$createFeedGesturePresenterConfig$1$4 r11 = VideoFeedViewHolder$createFeedGesturePresenterConfig$1$4.INSTANCE;
        r10.d = new VideoFeedViewHolder$createFeedGesturePresenterConfig$1$5(this);
        r10.g = new VideoFeedViewHolder$createFeedGesturePresenterConfig$1$6(this);
        r10.h = new VideoFeedViewHolder$createFeedGesturePresenterConfig$1$7(this);
        r10.i = new VideoFeedViewHolder$createFeedGesturePresenterConfig$1$8(this);
        r10.e = new VideoFeedViewHolder$createFeedGesturePresenterConfig$1$9(this);
        VideoFeedGesturePresenter r4 = new VideoFeedGesturePresenter(r8, r9, r10);
        this.k = r4;
        Activity r13 = r21.getActivity();
        Intrinsics.checkNotNull(r13);
        VideoFeedPage r12 = new VideoFeedPage(r13, r21.e, r21.c, (l14.c) r3.getValue(), r21.g, (ViewGroup) this.a.findViewById(2131372243), new VideoFeedViewHolder$videoFeedPage$1(this));
        this.m = r12;
        this.n = (TextView) this.a.findViewById(2131368594);
        r5.m(new i(r21));
        r5.m(new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.a(r21, AnonymousClass1.INSTANCE, new AnonymousClass2(this)));
        r5.m(r7);
        r5.m(r6);
        r5.m(new o(r21, (l14.c) r3.getValue()));
        r5.m(r4);
        LongPressSpeedPresenterConfig r14 = new LongPressSpeedPresenterConfig();
        r14.b = new VideoFeedViewHolder$3$1(this);
        r14.c = new VideoFeedViewHolder$3$2(this);
        Unit r15 = Unit.INSTANCE;
        r5.m(new FeedLongPressFastSpeedPresenter(r21, r14));
        r5.m(new n0(r21.a, r22));
        r5.m(new f0(r21));
        View r2 = this.a;
        View r16 = r2.findViewById(2131373357);
        pz3.f r17 = new pz3.f();
        r17.a = new VideoFeedViewHolder$4$1(this);
        r17.b = new VideoFeedViewHolder$4$2(this);
        r5.m(new h(r2, r16, r21, r17));
        if (com.bytedance.awemeopen.apps.framework.feed.ui.information.a.k == false) goto L5;
        FeedPinchPresenter r18 = new FeedPinchPresenter(r21);
        Intrinsics.checkNotNull(r18);
        r5.m(r18);
    L5:
        r5.m(new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.h(r21));
        r12.c();
    }
}
