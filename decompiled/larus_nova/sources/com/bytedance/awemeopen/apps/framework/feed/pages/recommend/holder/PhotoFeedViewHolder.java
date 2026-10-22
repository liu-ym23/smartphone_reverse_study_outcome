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
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class PhotoFeedViewHolder extends g<jz3.a> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f195107o = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a f195108e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f195109f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PhotoFeedPagerViewModel f195110g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final lz3.b f195111h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final g04.b<jz3.a> f195112i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final PhotoFeedPagerPresenter f195113j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final j f195114k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final VideoFeedPlayerPresenter f195115l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final VideoFeedGesturePresenter f195116m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final VideoFeedPage f195117n;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final void f() {
        AoLogger.b("PhotoFeedViewHolder", new Object[]{"onSelected " + this.f195109f});
        jz3.a r100 = (jz3.a) this.f197059b;
        if (r100 == null) goto L5;
        r14.c r101 = r100.f501173a;
    L6:
        if (r101 == null) goto L9;
        r101.f535635q = true;
    L9:
        this.f195112i.j();
        this.f195117n.a();
        if (this.f195108e.f195163c.getPageConfig().getNeedOpenComment() == false) goto L13;
        this.f195117n.f196568l.f196600o.g().f574084a.b(Boolean.TRUE);
        return;
    L13:
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final void g() {
        AoLogger.b("PhotoFeedViewHolder", new Object[]{"onUnBind " + this.f195109f});
        this.f195112i.k();
        this.f195117n.i();
        MutableLiveData<p> r100 = this.f195108e.f195163c.getSlidesProgressInfo();
        if (r100 == null) goto L6;
        r100.setValue(null);
    L6:
        MutableLiveData<Integer> r101 = this.f195108e.f195163c.getSlidesPlayCompletedPosition();
        if (r101 == null) goto L10;
        r101.setValue(null);
    L10:
        this.f195110g.reset();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final void h() {
        AoLogger.b("PhotoFeedViewHolder", new Object[]{"onUnSelected " + this.f195109f});
        this.f195112i.l();
        this.f195117n.d();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final boolean d() {
        return this.f195117n.j();
    }

    public PhotoFeedViewHolder(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r110, com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.p r210) {
        Intrinsics.checkNotNullParameter(r110, "feedGroupParameters");
        Intrinsics.checkNotNullParameter(r210, "eventRecorder");
        super(r110.f195161a);
        this.f195108e = r110;
        this.f195110g = new PhotoFeedPagerViewModel();
        this.f195111h = new lz3.b();
        g04.b<jz3.a> r100 = new g04.b(this.f197058a);
        this.f195112i = r100;
        PhotoFeedPagerPresenter r101 = new PhotoFeedPagerPresenter(this.f195108e, this.f195111h, this.f195110g, r210);
        this.f195113j = r101;
        j r102 = new j(r110.f195161a);
        this.f195114k = r102;
        VideoFeedPlayerPresenter r103 = new VideoFeedPlayerPresenter(r110, r210, null, null);
        this.f195115l = r103;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r104 = this.f195108e;
        View r105 = r104.f195161a.findViewById(R.id.item_gesture_fl);
        FeedGesturePresenterConfig r111 = new FeedGesturePresenterConfig();
        r111.f195149b = new PhotoFeedViewHolder$createFeedGesturePresenterConfig$1$1(this);
        r111.f195150c = new PhotoFeedViewHolder$createFeedGesturePresenterConfig$1$2(this);
        r111.f195151d = new PhotoFeedViewHolder$createFeedGesturePresenterConfig$1$3(this);
        r111.f195152e = new PhotoFeedViewHolder$createFeedGesturePresenterConfig$1$4(this);
        r111.f195154g = new PhotoFeedViewHolder$createFeedGesturePresenterConfig$1$5(this);
        r111.f195155h = new PhotoFeedViewHolder$createFeedGesturePresenterConfig$1$6(this);
        VideoFeedGesturePresenter r106 = new VideoFeedGesturePresenter(r104, r105, r111);
        this.f195116m = r106;
        Activity r112 = r110.getActivity();
        Intrinsics.checkNotNull(r112);
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r113 = r110.f195165e;
        o r114 = r110.f195163c;
        vz3.c r107 = new vz3.c();
        AosExtConfig.f193138b.z();
        r107.f557704a = null;
        r107.f557705b = null;
        Unit r108 = Unit.INSTANCE;
        VideoFeedPage r109 = new VideoFeedPage(r112, r113, r114, r107, (ViewGroup) this.f197058a.findViewById(R.id.feed_page));
        this.f195117n = r109;
        r101.L = new c(this);
        r101.P = new d(this);
        r100.m(r101);
        r100.m(new PhotoFeedProgressPresenter(this.f195108e, this.f195110g));
        r100.m(r103);
        r100.m(r102);
        r100.m(r106);
        r100.m(new n0(r110.f195161a, null));
        r100.m(new f0(r110));
        LongPressSpeedPresenterConfig r115 = new LongPressSpeedPresenterConfig();
        r115.f195159b = new PhotoFeedViewHolder$1$1(this);
        r115.f195160c = new PhotoFeedViewHolder$1$2(this);
        r100.m(new FeedLongPressFastSpeedPresenter(r110, r115));
        if (com.bytedance.awemeopen.apps.framework.feed.ui.information.a.f196001m == false) goto L5;
        FeedPinchPresenter r116 = new FeedPinchPresenter(r110);
        Intrinsics.checkNotNull(r116);
        r100.m(r116);
    L5:
        r109.c();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final void e(jz3.a r100, int r101) {
        jz3.a r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "data");
        MutableLiveData<p> r103 = this.f195108e.f195163c.getSlidesProgressInfo();
        String r104 = null;
        if (r103 == null) goto L6;
        r103.setValue(null);
    L6:
        MutableLiveData<Integer> r105 = this.f195108e.f195163c.getSlidesPlayCompletedPosition();
        if (r105 == null) goto L10;
        r105.setValue(null);
    L10:
        StringBuilder r106 = new StringBuilder("index:");
        r106.append(r102.f501176d);
        r106.append("\nawemeId:");
        r106.append(r102.f501173a.c());
        r106.append("\nuserOpenId:");
        User r107 = r102.f501173a.f();
        if (r107 == null) goto L13;
        String r108 = r107.u();
    L14:
        r106.append(r108);
        r106.append("\nnickName:");
        User r109 = r102.f501173a.f();
        if (r109 == null) goto L17;
        r104 = r109.t();
    L17:
        r106.append(r104);
        r106.append('\n');
        this.f195109f = r106.toString();
        AoLogger.b("PhotoFeedViewHolder", new Object[]{"onBind " + this.f195109f});
        this.f195112i.b(r102);
        this.f195117n.b(r102);
        return;
    L13:
        r108 = null;
        goto L14
    }
}
