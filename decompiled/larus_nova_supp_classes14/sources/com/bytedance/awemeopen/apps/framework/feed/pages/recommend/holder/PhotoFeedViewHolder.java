package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.holder;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.FeedGesturePresenterConfig;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.LongPressSpeedPresenterConfig;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vm.PhotoFeedPagerViewModel;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.FeedLongPressFastSpeedPresenter;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.VideoFeedGesturePresenter;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.VideoFeedPlayerPresenter;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.f0;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.j;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.n0;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.photo.PhotoFeedPagerPresenter;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.photo.PhotoFeedProgressPresenter;
import com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.FeedPinchPresenter;
import com.bytedance.awemeopen.apps.framework.feed.ui.page.VideoFeedPage;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.g;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.o;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.p;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class PhotoFeedViewHolder extends g<jz3.a> {
    public static final /* synthetic */ int o = 0;
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a e;
    public String f;
    public final PhotoFeedPagerViewModel g;
    public final lz3.b h;
    public final g04.b<jz3.a> i;
    public final PhotoFeedPagerPresenter j;
    public final j k;
    public final VideoFeedPlayerPresenter l;
    public final VideoFeedGesturePresenter m;
    public final VideoFeedPage n;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final void f() {
        AoLogger.b("PhotoFeedViewHolder", new Object[]{"onSelected " + this.f});
        jz3.a r1 = (jz3.a) this.b;
        if (r1 == null) goto L5;
        r14.c r2 = r1.a;
    L6:
        if (r2 == null) goto L9;
        r2.q = true;
    L9:
        this.i.j();
        this.n.a();
        if (this.e.c.getPageConfig().getNeedOpenComment() == false) goto L13;
        this.n.l.o.g().a.b(Boolean.TRUE);
        return;
    L13:
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final void g() {
        AoLogger.b("PhotoFeedViewHolder", new Object[]{"onUnBind " + this.f});
        this.i.k();
        this.n.i();
        MutableLiveData<p> r0 = this.e.c.getSlidesProgressInfo();
        if (r0 == null) goto L6;
        r0.setValue(null);
    L6:
        MutableLiveData<Integer> r1 = this.e.c.getSlidesPlayCompletedPosition();
        if (r1 == null) goto L10;
        r1.setValue(null);
    L10:
        this.g.reset();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final void h() {
        AoLogger.b("PhotoFeedViewHolder", new Object[]{"onUnSelected " + this.f});
        this.i.l();
        this.n.d();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final boolean d() {
        return this.n.j();
    }

    public PhotoFeedViewHolder(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r19, com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.p r20) {
        Intrinsics.checkNotNullParameter(r19, "feedGroupParameters");
        Intrinsics.checkNotNullParameter(r20, "eventRecorder");
        super(r19.a);
        this.e = r19;
        this.g = new PhotoFeedPagerViewModel();
        this.h = new lz3.b();
        g04.b<jz3.a> r3 = new g04.b(this.a);
        this.i = r3;
        PhotoFeedPagerPresenter r4 = new PhotoFeedPagerPresenter(this.e, this.h, this.g, r20);
        this.j = r4;
        j r5 = new j(r19.a);
        this.k = r5;
        VideoFeedPlayerPresenter r6 = new VideoFeedPlayerPresenter(r19, r20, null, null);
        this.l = r6;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r8 = this.e;
        View r9 = r8.a.findViewById(2131375768);
        FeedGesturePresenterConfig r10 = new FeedGesturePresenterConfig();
        r10.b = new PhotoFeedViewHolder$createFeedGesturePresenterConfig$1$1(this);
        r10.c = new PhotoFeedViewHolder$createFeedGesturePresenterConfig$1$2(this);
        r10.d = new PhotoFeedViewHolder$createFeedGesturePresenterConfig$1$3(this);
        r10.e = new PhotoFeedViewHolder$createFeedGesturePresenterConfig$1$4(this);
        r10.g = new PhotoFeedViewHolder$createFeedGesturePresenterConfig$1$5(this);
        r10.h = new PhotoFeedViewHolder$createFeedGesturePresenterConfig$1$6(this);
        VideoFeedGesturePresenter r2 = new VideoFeedGesturePresenter(r8, r9, r10);
        this.m = r2;
        Activity r13 = r19.getActivity();
        Intrinsics.checkNotNull(r13);
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r14 = r19.e;
        o r15 = r19.c;
        vz3.c r11 = new vz3.c();
        AosExtConfig.b.z();
        r11.a = null;
        r11.b = null;
        Unit r12 = Unit.INSTANCE;
        VideoFeedPage r16 = new VideoFeedPage(r13, r14, r15, r11, (ViewGroup) this.a.findViewById(2131372243));
        this.n = r16;
        r4.L = new c(this);
        r4.P = new d(this);
        r3.m(r4);
        r3.m(new PhotoFeedProgressPresenter(this.e, this.g));
        r3.m(r6);
        r3.m(r5);
        r3.m(r2);
        r3.m(new n0(r19.a, null));
        r3.m(new f0(r19));
        LongPressSpeedPresenterConfig r7 = new LongPressSpeedPresenterConfig();
        r7.b = new PhotoFeedViewHolder$1$1(this);
        r7.c = new PhotoFeedViewHolder$1$2(this);
        r3.m(new FeedLongPressFastSpeedPresenter(r19, r7));
        if (com.bytedance.awemeopen.apps.framework.feed.ui.information.a.m == false) goto L5;
        FeedPinchPresenter r17 = new FeedPinchPresenter(r19);
        Intrinsics.checkNotNull(r17);
        r3.m(r17);
    L5:
        r16.c();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final void e(jz3.a r3, int r4) {
        jz3.a r5 = r3;
        Intrinsics.checkNotNullParameter(r5, "data");
        MutableLiveData<p> r6 = this.e.c.getSlidesProgressInfo();
        String r0 = null;
        if (r6 == null) goto L6;
        r6.setValue(null);
    L6:
        MutableLiveData<Integer> r7 = this.e.c.getSlidesPlayCompletedPosition();
        if (r7 == null) goto L10;
        r7.setValue(null);
    L10:
        StringBuilder r8 = new StringBuilder("index:");
        r8.append(r5.d);
        r8.append("\nawemeId:");
        r8.append(r5.a.c());
        r8.append("\nuserOpenId:");
        User r1 = r5.a.f();
        if (r1 == null) goto L13;
        String r2 = r1.u();
    L14:
        r8.append(r2);
        r8.append("\nnickName:");
        User r9 = r5.a.f();
        if (r9 == null) goto L17;
        r0 = r9.t();
    L17:
        r8.append(r0);
        r8.append('\n');
        this.f = r8.toString();
        AoLogger.b("PhotoFeedViewHolder", new Object[]{"onBind " + this.f});
        this.i.b(r5);
        this.n.b(r5);
        return;
    L13:
        r2 = null;
        goto L14
    }
}
