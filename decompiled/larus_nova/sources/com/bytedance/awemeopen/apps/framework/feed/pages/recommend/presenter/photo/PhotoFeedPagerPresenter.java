package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.photo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.p;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.SlidesPhotosPageAdapter;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.model.PhotoModel;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.model.ScaleType;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.model.SlidesPhotosConfig;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.SlidesPhotosViewPager;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.progress.StoryListProgressBar;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vm.PhotoFeedPagerViewModel;
import com.bytedance.awemeopen.apps.framework.feed.profile.AosUserProfileFeedFragmentViewModel;
import com.bytedance.awemeopen.apps.framework.utils.b0;
import com.bytedance.awemeopen.apps.framework.utils.i0;
import com.bytedance.awemeopen.apps.framework.utils.reporter.HostCommonParamProvider;
import com.bytedance.awemeopen.apps.photo.pinch.PinchStableView;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.domain.base.repo.GsonHolder;
import com.bytedance.awemeopen.export.api.pageconfig.recfeed.FeedPageConfig;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.infra.base.npth.AoExceptionReporter;
import com.bytedance.awemeopen.infra.base.npth.ErrorPriority;
import com.bytedance.awemeopen.servicesapi.monitor.common.AoCommonMonitorService;
import com.bytedance.awemeopen.servicesapi.npth.AoNpthService;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.larksuite.framework.utils.DeviceUtils;
import com.larus.nova.R;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import r14.a0;
import r14.y;

/* JADX INFO: loaded from: classes14.dex */
public final class PhotoFeedPagerPresenter extends g04.a<jz3.a> implements ISlidesPhotosView, nz3.b, View.OnClickListener, View.OnLongClickListener, nz3.g {
    public static final /* synthetic */ int T = 0;
    public com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.a A;
    public final kz3.a B;
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.photo.c C;
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.photo.d D;
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.photo.a E;
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.photo.b F;
    public String G;
    public String H;
    public final Set<Integer> I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f195556J;
    public final d K;
    public nz3.f L;
    public View.OnLongClickListener M;
    public View.OnClickListener N;
    public nz3.d O;
    public nz3.g P;
    public final a Q;
    public final AoCommonMonitorService R;
    public final Handler S;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a f195557e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final lz3.b f195558f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PhotoFeedPagerViewModel f195559g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final p f195560h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SlidesPhotosConfig f195561i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final SlidesPhotosViewPager f195562j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View f195563k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f195564l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final StoryListProgressBar f195565m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final SlidesPhotosPageAdapter f195566n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f195567o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f195568p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f195569q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f195570r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public jz3.a f195571s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public r14.c f195572t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ArrayList<PhotoModel> f195573u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f195574v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f195575w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.o f195576x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final mz3.m f195577y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final PhotoPageChangeListener f195578z;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/presenter/photo/PhotoFeedPagerPresenter$PhotoPageChangeListener;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public final class PhotoPageChangeListener implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhotoFeedPagerPresenter f195579a;

        public PhotoPageChangeListener(PhotoFeedPagerPresenter r100) {
            this.f195579a = r100;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int r100) {
            AoLogger.g("fps_log", new Object[]{"onPageScrollStateChanged state = " + r100});
            if (r100 == 0) goto L7;
            AoCommonMonitorService r101 = this.f195579a.R;
            if (r101 == null) goto L7;
            r101.S();
        L7:
            if (r100 == 0) goto L11;
            if (r100 != 1) goto L14;
            PhotoFeedPagerPresenter r102 = this.f195579a;
            r102.H = "manual_click";
            r102.f195577y.a(false);
            this.f195579a.f195568p = true;
            return;
        L14:
            return;
        L11:
            this.f195579a.f195577y.a(false);
            PhotoFeedPagerPresenter r103 = this.f195579a;
            r103.f195577y.f516492a.f516488a = 0;
            r103.f195568p = false;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(final int r110) {
            AoLogger.g("fps_log", new Object[]{"onPageSelected position = " + r110});
            AoCommonMonitorService r100 = this.f195579a.R;
            if (r100 == null) goto L5;
            r100.N1();
        L5:
            PhotoFeedPagerPresenter r101 = this.f195579a;
            if (r110 <= r101.f195575w) goto L8;
            String r102 = "slide_left";
        L9:
            r101.G = r102;
            r101.f195575w = r110;
            if (r101.o() <= 0) goto L12;
            int r103 = r110 % r101.o();
        L13:
            r101.f195574v = r103;
            PhotoFeedPagerPresenter r104 = this.f195579a;
            com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.o r105 = r104.f195576x;
            if (r104.f195574v != (r105.f195085a - 1)) goto L16;
            r105.f195086b = System.currentTimeMillis();
        L17:
            PhotoFeedPagerPresenter r106 = this.f195579a;
            SlidesPhotosViewPager r107 = r106.f195562j;
            int r108 = r106.f195574v;
            r14.c r109 = r106.f195572t;
            if (r109 == null) goto L22;
            List<y> r111 = r109.v();
            if (r111 == null) goto L22;
            int r112 = r111.size();
        L24:
            if (r108 != (r112 - 1)) goto L26;
            boolean r113 = true;
        L27:
            r107.H1 = r113;
            if (this.f195579a.f195561i.getStopByDrag() == false) goto L33;
            PhotoFeedPagerPresenter r114 = this.f195579a;
            if (r114.f195568p == false) goto L33;
            r114.f195570r = true;
        L33:
            if (this.f195579a.f195561i.getAutoPlayEnabled() == true) goto L35;
        L37:
            boolean r115 = false;
        L38:
            if (r115 == false) goto L54;
            PhotoFeedPagerPresenter r116 = this.f195579a;
            kz3.a r117 = r116.B;
            if (r117.f506742g == false) goto L42;
        L43:
            r116.f195569q = false;
            if (r117.f506743h == false) goto L47;
            r117.a();
            PhotoFeedPagerPresenter r118 = this.f195579a;
            PhotoFeedPagerPresenter.q(r118, r118.f195574v, 0.0f, 0.0f, 0, false, 24);
        L59:
            final PhotoFeedPagerPresenter r119 = this.f195579a;
            if (r119.f195567o == true) goto L77;
            kz3.a r120 = r119.B;
            if (r120.f506742g == true) goto L64;
        L66:
            final String r121 = r119.H;
            final String r122 = r119.G;
            final int r123 = r119.o();
            r119.S.postDelayed(new f(r119, r121, r122, r110, r123), 10);
            PhotoFeedPagerPresenter r124 = this.f195579a;
            if (r124.f195574v != (r124.o() - 1)) goto L77;
            if (this.f195579a.r() == true) goto L77;
            PhotoFeedPagerPresenter r125 = this.f195579a;
            if (r125.f195556J == true) goto L76;
            r125.f195556J = true;
            AosEventReporter r126 = AosEventReporter.f194596a;
            com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r127 = r125.f195557e;
            jz3.a r128 = r125.f195571s;
            if (r128 != null) goto L75;
            Intrinsics.throwUninitializedPropertyAccessException("mData");
            r128 = null;
        L75:
            r126.getClass();
            AosEventReporter.S(r127, r128);
        L76:
            this.f195579a.f195560h.f195089c++;
            goto L77
        L64:
            if (r120.f506743h == true) goto L66;
            r119.H = "auto";
        L77:
            PhotoFeedPagerPresenter r129 = this.f195579a;
            r129.I.add(Integer.valueOf(r129.f195574v));
            this.f195579a.f195567o = false;
            return;
        L47:
            if (r116.f195574v != 0) goto L49;
        L52:
            long r130 = r116.f195561i.getPhotoPlayDuration();
        L53:
            PhotoFeedPagerPresenter r131 = this.f195579a;
            r131.f195570r = false;
            r131.B.d(true, r130, true);
            goto L59
        L49:
            if (r116.f195568p == true) goto L52;
            r130 = r116.f195561i.getPhotoPlayDuration() + this.f195579a.f195561i.getScrollAnimationDuration();
            goto L53
        L42:
            if (r116.f195569q == true) goto L43;
        L54:
            if (r115 == true) goto L59;
            PhotoFeedPagerPresenter r132 = this.f195579a;
            if (r132.f195570r == false) goto L58;
            r132.B.e();
        L58:
            PhotoFeedPagerPresenter r133 = this.f195579a;
            PhotoFeedPagerPresenter.q(r133, r133.f195574v, 100.0f, 100.0f, 0, r133.f195570r, 8);
            goto L59
        L35:
            if (this.f195579a.f195570r == true) goto L37;
            r115 = true;
            goto L38
        L26:
            r113 = false;
        L22:
            r112 = 0;
            goto L24
        L16:
            r105.f195086b = -1;
            goto L17
        L12:
            r103 = r110;
            goto L13
        L8:
            r102 = PinchStableView.Gesture.SLIDE_RIGHT;
            goto L9
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int r100, float r101, int r102) {
            PhotoFeedPagerPresenter r103 = this.f195579a;
            int r104 = PhotoFeedPagerPresenter.T;
            if (r103.o() <= 0) goto L5;
            int r105 = r100 % r103.o();
        L6:
            if (r100 == 0) goto L8;
            return;
        L8:
            if (r101 != 0.0f) goto L10;
            boolean r106 = true;
        L11:
            if (r106 == true) goto L13;
            return;
        L13:
            if (this.f195579a.f195567o == false) goto L18;
            onPageSelected(r105);
            return;
        L18:
            return;
        L10:
            r106 = false;
            goto L11
        L5:
            r105 = r100;
            goto L6
        }
    }

    public static final class a implements com.bytedance.awemeopen.apps.framework.utils.audio.a.InterfaceC2833a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhotoFeedPagerPresenter f195580a;

        @Override // com.bytedance.awemeopen.apps.framework.utils.audio.a.InterfaceC2833a
        public final void a() {
        }

        @Override // com.bytedance.awemeopen.apps.framework.utils.audio.a.InterfaceC2833a
        public final void b() {
        }

        @Override // com.bytedance.awemeopen.apps.framework.utils.audio.a.InterfaceC2833a
        public final void d() {
            if (this.f195580a.f195561i.getShowProgressBar() == false) goto L10;
            PhotoFeedPagerPresenter r100 = this.f195580a;
            if (r100.B.f506743h == true) goto L7;
            return;
        L7:
            if (r100.isLooping() == true) goto L12;
            this.f195580a.resumeLoop();
            return;
        L12:
            return;
        }

        public a(PhotoFeedPagerPresenter r100) {
            this.f195580a = r100;
        }

        @Override // com.bytedance.awemeopen.apps.framework.utils.audio.a.InterfaceC2833a
        public final void c(boolean r100) {
            this.f195580a.pauseLoop();
        }
    }

    public static final class b {
    }

    public final class c implements kz3.a.InterfaceC6635a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhotoFeedPagerPresenter f195581a;

        @Override // kz3.a.InterfaceC6635a
        public final boolean a() {
            if (this.f195581a.f195561i.getAutoPlayEnabled() == false) goto L9;
            nz3.f r100 = this.f195581a.L;
            if (r100 == null) goto L11;
            r100.a();
            return true;
        L11:
            return true;
        L9:
            return false;
        }

        public c(PhotoFeedPagerPresenter r100) {
            this.f195581a = r100;
        }

        @Override // kz3.a.InterfaceC6635a
        public final void b(float r100, float r110, long r111) {
            PhotoFeedPagerPresenter r101 = this.f195581a;
            PhotoFeedPagerPresenter.q(r101, r101.f195574v, r100, r110, r111, false, 16);
            if (r100 != 100.0f) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == false) goto L9;
            this.f195581a.p();
            return;
        L9:
            return;
        L5:
            r102 = false;
            goto L6
        }
    }

    public final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f195582a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f195583b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public j f195584c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ PhotoFeedPagerPresenter f195585d;

        public final void a() {
            if (this.f195585d.r() == true) goto L5;
            return;
        L5:
            if (this.f195583b == false) goto L8;
            return;
        L8:
            if (this.f195585d.f195556J == false) goto L10;
            return;
        L10:
            this.f195583b = true;
            long r100 = this.f195582a;
            j r101 = new j(this, this.f195585d, r100);
            this.f195584c = r101;
            r101.start();
        }

        public final void b() {
            if (this.f195585d.r() == true) goto L5;
            return;
        L5:
            if (this.f195583b == false) goto L12;
            this.f195583b = false;
            j r100 = this.f195584c;
            if (r100 == null) goto L9;
            r100.cancel();
        L9:
            this.f195584c = null;
            return;
        }

        public d(PhotoFeedPagerPresenter r100) {
            this.f195585d = r100;
            this.f195582a = 4000;
        }
    }

    public /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f195586a = null;

        static {
            int[] r100 = new int[Lifecycle.Event.values().length];
            r100[Lifecycle.Event.ON_RESUME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[Lifecycle.Event.ON_PAUSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f195586a = r100;
        }
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void setImageGestureListener(nz3.b r100) {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.b getCurrentViewHolder() {
        int r100 = this.f195562j.getCurrentItem();
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.a r101 = this.A;
        if (r101 == null) goto L14;
        PhotoModel r102 = r101.n();
        SlidesPhotosPageAdapter r103 = this.f195566n;
        List<PhotoModel> r104 = r103.f195181d;
        if (((ArrayList) r104).size() <= 0) goto L7;
        int r105 = r100 % ((ArrayList) r103.f195181d).size();
    L9:
        if (Intrinsics.areEqual(r102, (PhotoModel) CollectionsKt.getOrNull(r104, r105)) == false) goto L14;
        if (r100 != this.f195574v) goto L14;
        return this.A;
    L7:
        r105 = r100;
    L14:
        int r106 = this.f195562j.getChildCount();
        int r107 = 0;
    L15:
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.a r108 = null;
        if (r107 >= r106) goto L34;
        View r109 = this.f195562j.getChildAt(r107);
        if (r109 == null) goto L20;
        Object r110 = r109.getTag(R.id.common_feed_core_holder_id);
    L22:
        if ((r110 instanceof com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.a) == false) goto L24;
        r108 = (com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.a) r110;
    L24:
        if (r108 == null) goto L33;
        PhotoModel r111 = r108.n();
        SlidesPhotosPageAdapter r112 = this.f195566n;
        List<PhotoModel> r113 = r112.f195181d;
        if (((ArrayList) r113).size() <= 0) goto L28;
        int r114 = r100 % ((ArrayList) r112.f195181d).size();
    L30:
        if (Intrinsics.areEqual(r111, (PhotoModel) CollectionsKt.getOrNull(r113, r114)) == false) goto L33;
        this.A = r108;
        return r108;
    L28:
        r114 = r100;
    L33:
        r107 = r107 + 1;
        goto L15
    L20:
        r110 = null;
        goto L22
    L34:
        return null;
    }

    @Override // g04.a
    public final void i() {
        PhotoFeedPagerPresenter r100 = this;
        pauseLoop();
        int r101 = 0;
        r100.f195556J = false;
        d r102 = r100.K;
        if (r102.f195585d.r() == false) goto L5;
        r102.b();
        r102.f195582a = 4000;
    L5:
        AosEventReporter r103 = AosEventReporter.f194596a;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r104 = r100.f195557e;
        jz3.a r105 = r100.f195571s;
        AosUserProfileFeedFragmentViewModel r106 = null;
        if (r105 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mData");
        r105 = null;
    L8:
        p r107 = r100.f195560h;
        int r108 = r100.I.size();
        int r110 = o();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "feedGroupParameters");
        Intrinsics.checkNotNullParameter(r105, "data");
        Intrinsics.checkNotNullParameter(r107, "eventRecorder");
        String r111 = r104.f195163c.sceneId();
        long r210 = r107.a();
        if (r110 != 0) goto L12;
        AoNpthService r109 = AoExceptionReporter.f198706a;
        AoExceptionReporter.b(ErrorPriority.f198710p0, AosEventReporter.f194597b, "reportPictureVideoOver", "picCount=0", 16);
    L37:
        com.bytedance.awemeopen.apps.framework.utils.audio.a r112 = iz3.a.a(r100.f195557e);
        if (r112 == null) goto L41;
        TypeIntrinsics.asMutableCollection(r112.f197672c).remove(r100.Q);
        return;
    L41:
        return;
    L12:
        if (r110 == 1) goto L14;
        if (r108 < r110) goto L18;
    L17:
        r101 = 1;
    L18:
        double r113 = Math.min(Math.round((r108 / r110) * 100), 100.0f);
        int r114 = r107.f195089c;
        if (Intrinsics.areEqual(r111, "others_homepage") == false) goto L25;
        com.bytedance.awemeopen.apps.framework.framework.viewpager.o r115 = r104.f195163c;
        if ((r115 instanceof AosUserProfileFeedFragmentViewModel) == false) goto L23;
        r106 = (AosUserProfileFeedFragmentViewModel) r115;
    L23:
        if (r106 == null) goto L25;
        String r116 = r106.getFromGroupId();
    L26:
        FeedPageConfig r117 = r104.f195163c.getPageConfig();
        d14.a r118 = b14.a.f16924a;
        t24.a r119 = (t24.a) b14.a.a(t24.a.class);
        String r120 = r117.getHostEnterFrom();
        String r121 = r105.f501173a.c();
        String r122 = AosEventReporter.b(r105.f501173a, r117);
        if (r122 != null) goto L29;
        r122 = "";
        String r123 = r122;
    L30:
        a0 r124 = r105.f501173a.f535622d;
        if (r124 == null) goto L36;
        String r125 = r124.a();
        if (r125 == null) goto L36;
        r123 = r125;
    L36:
        String r126 = GsonProtectorUtils.toJson(GsonHolder.a(), r105.f501173a.f535622d);
        boolean r127 = AosEventReporter.e(r105.f501173a);
        boolean r211 = r117.isCardMode();
        boolean r128 = r107.f195088b;
        r14.c r129 = r105.f501173a;
        r119.i2(r111, r120, r121, r122, r123, r116, r126, r127, r105.f501173a.i(), r211, r113, r101, r210, null, r114, r128, r129.f535638t, Integer.valueOf(r108), Integer.valueOf(r110), r129.r().f535649a, r117.getHostExtraParams(), new HostCommonParamProvider(r117.getHostCommonParams()));
        r100 = this;
        goto L37
    L29:
        r123 = "";
    L25:
        r116 = "";
        goto L26
    L14:
        if (r210 <= 4000) goto L18;
        goto L18
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void initialLoop() {
        q(this, this.f195574v, 100.0f, 100.0f, 0, false, 24);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final boolean isLooping() {
        kz3.a r100 = this.B;
        if (r100.f506742g == true) goto L5;
    L9:
        return false;
    L5:
        if (r100.f506743h == true) goto L9;
        if (this.f195570r == true) goto L9;
        return true;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final boolean isPaused() {
        return this.B.f506743h;
    }

    public final void m() {
        this.f195562j.setDisableScroll(!this.f195561i.getDragEnabled());
        this.f195562j.setDisableOutScroll(!this.f195561i.getOutDragEnabled());
        this.f195577y.f516493b = (int) this.f195561i.getScrollAnimationDuration();
        if (this.f195561i.getShowProgressBar() == false) goto L7;
        x54.b.d(this.f195565m);
        x54.b.d(this.f195563k);
        this.f195565m.post(new g(this));
        if (this.f195561i.getEnableProgressBarSwitch() == false) goto L8;
        this.f195565m.setClickEnabled(true);
        this.f195565m.setOnProgressBarSelected(new PhotoFeedPagerPresenter$applySlidesPhotosConfig$2(this));
    L8:
        kz3.a r100 = this.B;
        long r101 = this.f195561i.getPhotoPlayDuration();
        r100.f506737b = r101;
        r100.f506739d = (r100.f506738c / r101) * 100.0f;
        kz3.a r102 = this.B;
        long r103 = this.f195561i.getProgressInterval();
        r102.f506738c = r103;
        r102.f506739d = (r103 / r102.f506737b) * 100.0f;
        if (this.f195561i.getInitPlayPosition() <= 0) goto L14;
        if (this.f195562j.getCurrentItem() == this.f195561i.getInitPlayPosition()) goto L14;
        setCurrentPosition(this.f195561i.getInitPlayPosition(), false, 0);
        this.f195574v = this.f195561i.getInitPlayPosition();
        this.f195575w = this.f195561i.getInitPlayPosition();
        return;
    L14:
        if (this.f195562j.getCurrentItem() == 0) goto L18;
        setCurrentPosition(0, false, 0);
        return;
    L18:
        return;
    L7:
        x54.b.a(this.f195563k);
        goto L8
    }

    public final int o() {
        return ((ArrayList) this.f195566n.f195181d).size();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void onDragByUser() {
        if (this.f195561i.getStopByDrag() == true) goto L5;
        return;
    L5:
        if (this.f195570r == true) goto L9;
        this.f195570r = true;
        this.B.e();
        q(this, this.f195574v, 100.0f, 100.0f, 0, this.f195570r, 8);
        return;
    }

    public final void p() {
        nz3.f r100 = this.L;
        if (r100 == null) goto L5;
        r100.b(this.f195574v);
    L5:
        int r101 = o();
        boolean r102 = true;
        int r103 = this.f195575w + 1;
        if (this.f195568p == true) goto L11;
        if (r101 <= 1) goto L11;
        nz3.f r104 = this.L;
        if (r104 == null) goto L12;
        r104.g();
    L12:
        if (r102 == true) goto L14;
        return;
    L14:
        if (r103 < 10000) goto L19;
        nz3.f r105 = this.L;
        if (r105 == null) goto L18;
        r105.h();
    L18:
        setCurrentPosition(0, false, 0);
        return;
    L19:
        if (r103 > 0) goto L21;
    L25:
        setCurrentPosition(r103, false, 0);
        return;
    L21:
        if ((r103 % r101) != 0) goto L25;
        if (this.f479460d == false) goto L25;
        this.f195557e.f195163c.doAutoPlay();
    L11:
        r102 = false;
        goto L12
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void pauseLoop() {
        if (this.f195561i.getShowProgressBar() == true) goto L5;
        return;
    L5:
        kz3.a r100 = this.B;
        if (r100.f506742g == false) goto L9;
        r100.f506743h = true;
        r100.f506746k = 0;
        r100.f506736a.removeMessages(10001);
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void restartLoop() {
        if (this.f195561i.getShowProgressBar() == true) goto L5;
        return;
    L5:
        p();
        q(this, this.f195574v, 0.0f, 0.0f, 0, false, 24);
        startLoop(false);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void resumeLoop() {
        if (this.f195561i.getShowProgressBar() == true) goto L5;
        return;
    L5:
        this.B.b();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void stopLoop() {
        if (this.f195561i.getShowProgressBar() == true) goto L5;
        return;
    L5:
        this.B.e();
    }

    public final void t() {
        if (this.f195561i.getShowProgressBar() == true) goto L5;
        return;
    L5:
        if (this.B.f506742g == true) goto L7;
        startLoop(false);
        return;
    L7:
        resumeLoop();
    }

    @Override // g04.a
    public final void g() {
        t();
        this.K.a();
        com.bytedance.awemeopen.apps.framework.utils.audio.a r100 = iz3.a.a(this.f195557e);
        if (r100 == null) goto L10;
        a r101 = this.Q;
        if (r101 != null) goto L7;
        return;
    L7:
        if (((ArrayList) r100.f197672c).contains(r101) == true) goto L12;
        ((ArrayList) r100.f197672c).add(r101);
        return;
    L12:
        return;
    }

    @Override // g04.a
    public final void h() {
        stopLoop();
        this.f195565m.e();
        SlidesPhotosPageAdapter r100 = this.f195566n;
        Iterator<T> r101 = r100.f195182e.values().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((com.bytedance.awemeopen.apps.framework.framework.viewpager.g) r101.next()).k();
        goto L4
    L6:
        r100.f195182e.clear();
        this.f195572t = null;
        this.f195570r = false;
        this.A = null;
        this.G = "";
        this.H = "auto";
        this.I.clear();
        this.f195558f.f511362b.reset();
        this.f195557e.f195163c.getFeedHomeContainerSelectedIndex().removeObserver(this.D);
        this.f195559g.getCancelLoop().removeObserver(this.E);
        this.f195559g.getPreviewSelectedPhotoPosition().removeObserver(this.F);
    }

    public final boolean r() {
        if (o() <= 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final int getCurrentItem() {
        return this.f195575w;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final int getCurrentPosition() {
        return this.f195574v;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final View getProgressBar() {
        return this.f195565m;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final boolean isStoppedByDrag() {
        return this.f195570r;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void changeToFullPreview(boolean r100) {
        if (r100 == false) goto L9;
        this.f195558f.f511362b.setScaleType(ScaleType.FIT_CENTER);
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.b r101 = getCurrentViewHolder();
        if (r101 == null) goto L6;
        ((com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.d) r101).q();
    L6:
        int r102 = this.f195562j.getCurrentItem();
        n(r102 - 1);
        n(r102 + 1);
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.b r103 = getCurrentViewHolder();
        if (r103 == null) goto L14;
        r103.b(r100);
        return;
    L14:
        return;
    L9:
        this.f195558f.f511362b.setScaleType(ScaleType.AUTO_MODE);
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.b r104 = getCurrentViewHolder();
        if (r104 == null) goto L12;
        ((com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.d) r104).q();
    L12:
        int r105 = this.f195562j.getCurrentItem();
        n(r105 - 1);
        n(r105 + 1);
    }

    @Override // g04.a
    public final void f(jz3.a r100) {
        jz3.a r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f195571s = r101;
        this.f195572t = r101.f501173a;
        this.f195573u.clear();
        ArrayList<PhotoModel> r102 = this.f195573u;
        int r103 = com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.l.f195077a;
        r102.addAll(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.l.a(this.f195572t));
        lz3.b r104 = this.f195558f;
        r104.f511363c = this.f195572t;
        SlidesPhotosPageAdapter r105 = this.f195566n;
        ArrayList<PhotoModel> r106 = this.f195573u;
        ((ArrayList) r105.f195181d).clear();
        if (r106 == null) goto L5;
        ((ArrayList) r105.f195181d).addAll(r106);
    L5:
        r105.notifyDataSetChanged();
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.o r107 = this.f195576x;
        r14.c r108 = this.f195572t;
        if (r108 == null) goto L10;
        List<y> r109 = r108.v();
        if (r109 == null) goto L10;
        int r110 = r109.size();
    L11:
        r107.f195085a = r110;
        this.f195564l.post(new h(this));
        if (r() == false) goto L14;
        this.f195561i.singlePhotoConfig();
    L14:
        m();
        this.f195557e.f195163c.getFeedHomeContainerSelectedIndex().observe(this.f195557e.f195165e.f195172d, this.D);
        this.f195559g.getCancelLoop().observe(this.f195557e.f195165e.f195172d, this.E);
        this.f195559g.getPreviewSelectedPhotoPosition().observe(this.f195557e.f195165e.f195172d, this.F);
        this.f195557e.f195165e.f195172d.getLifecycle().addObserver(this.C);
        return;
    L10:
        r110 = 0;
        goto L11
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void handleProgressSwitch(boolean r100) {
        if (r100 == false) goto L5;
        setCurrentPosition(this.f195575w + 1, false, 0);
    L8:
        onDragByUser();
        return;
    L5:
        int r101 = this.f195575w;
        if (r101 < 1) goto L8;
        setCurrentPosition(r101 - 1, false, 0);
        goto L8
    }

    public final void n(int r100) {
        if (r100 >= 0) goto L4;
        return;
    L4:
        if (r100 >= this.f195562j.getChildCount()) goto L18;
        View r101 = this.f195562j.getChildAt(r100);
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.a r102 = null;
        if (r101 == null) goto L9;
        Object r103 = r101.getTag(R.id.common_feed_core_holder_id);
    L11:
        if ((r103 instanceof com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.a) == false) goto L13;
        r102 = (com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.a) r103;
    L13:
        if (r102 == null) goto L17;
        ((com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.d) r102).q();
        return;
    L17:
        return;
    L9:
        r103 = null;
        goto L11
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        View.OnClickListener r101 = this.N;
        if (r101 == null) goto L6;
        r101.onClick(r100);
        return;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        View.OnLongClickListener r101 = this.M;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.onLongClick(r100);
    }

    @Override // nz3.g
    public final boolean onTouchEvent(MotionEvent r100) {
        nz3.g r101 = this.P;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.onTouchEvent(r100);
    }

    public final void s(Map<String, Object> r100) {
        String r101 = this.f195557e.f195163c.sceneId();
        String r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100.put("enter_from", r101);
        r14.c r103 = this.f195572t;
        if (r103 == null) goto L9;
        String r104 = r103.c();
        if (r104 == null) goto L9;
    L10:
        r100.put("group_id", r104);
        r14.c r105 = this.f195572t;
        if (r105 == null) goto L18;
        User r106 = r105.f();
        if (r106 == null) goto L18;
        String r107 = r106.u();
        if (r107 == null) goto L18;
        r102 = r107;
    L18:
        r100.put("author_id", r102);
        r100.put("enter_method", "click_screen");
        r14.c r108 = this.f195572t;
        if (r108 == null) goto L21;
        int r109 = r108.q();
    L22:
        r100.put("item_duration", Integer.valueOf(r109));
        r100.put("pinch_zoom", Integer.valueOf(Intrinsics.areEqual(this.f195557e.f195163c.getEnterPinchMode().getValue(), Boolean.TRUE) ? 1 : 0));
        r100.put("pure_zoom", 0);
        return;
    L21:
        r109 = 0;
    L9:
        r104 = "";
        goto L10
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void seek(float r100) {
        if (this.f195561i.getShowProgressBar() == true) goto L5;
        return;
    L5:
        this.B.c(r100);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void setClickListener(View.OnClickListener r100) {
        this.N = r100;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void setLongClickListener(View.OnLongClickListener r100) {
        this.M = r100;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void setOnSwipeListener(nz3.d r100) {
        this.O = r100;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void setRefreshInFirstPosition(boolean r100) {
        this.f195569q = r100;
        if (r100 == true) goto L5;
        return;
    L5:
        if (this.f195562j.getCurrentItem() == 0) goto L7;
        setCurrentPosition(0, false, 300);
        return;
    L7:
        startLoop(false);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void setSlidesPhotosConfig(SlidesPhotosConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f195561i = r100;
        lz3.b r101 = this.f195558f;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r101.f511362b = r100;
        m();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void setSlidesProgressCallback(nz3.f r100) {
        this.L = r100;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void setTouchInterceptor(nz3.g r100) {
        this.P = r100;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void startLoop(boolean r110) {
        if (this.f195561i.getShowProgressBar() == true) goto L6;
        return;
    L6:
        if (r110 == false) goto L9;
        reset(0, 0);
    L9:
        if (this.f195561i.getAutoPlayEnabled() == false) goto L11;
        this.f195570r = false;
        kz3.a r111 = this.B;
        long r100 = this.f195561i.getPhotoPlayDuration();
        int r101 = kz3.a.f506735l;
        r111.d(true, r100, false);
        return;
    L11:
        q(this, this.f195574v, 100.0f, 100.0f, 0, false, 24);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void reset(int r100, long r101) {
        stopLoop();
        int r102 = this.f195562j.getCurrentItem();
        if (o() <= 0) goto L6;
        r102 = r102 % o();
    L6:
        if (r102 == r100) goto L8;
        setCurrentPosition(r100, false, r101);
    L8:
        this.f195577y.f516492a.f516488a = 0;
        this.f195565m.f(r100);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void setCurrentPositionFullProgress(int r110, boolean r111) {
        this.f195577y.a(r111);
        this.f195562j.w(r110, r111);
        q(this, r110, 100.0f, 100.0f, 0, this.f195570r, 8);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void setCurrentPosition(final int r100, final boolean r101, long r102) {
        this.f195577y.a(r101);
        if (r102 <= 0) goto L5;
        this.f195562j.postDelayed(new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.photo.e(this, r100, r101), r102);
        return;
    L5:
        this.f195562j.w(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v16, types: [com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.photo.c] */
    /* JADX WARN: Type inference failed for: r10v17, types: [com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.photo.d] */
    /* JADX WARN: Type inference failed for: r10v28, types: [android.content.SharedPreferences$Editor] */
    /* JADX WARN: Type inference failed for: r10v6, types: [com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.photo.a] */
    /* JADX WARN: Type inference failed for: r10v7, types: [com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.photo.b] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v7 */
    public PhotoFeedPagerPresenter(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r100, lz3.b r110, PhotoFeedPagerViewModel r111, p r112) {
        Intrinsics.checkNotNullParameter(r100, "feedGroupParameters");
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "photoVM");
        Intrinsics.checkNotNullParameter(r112, "eventRecorder");
        super(r100.f195161a);
        this.f195557e = r100;
        this.f195558f = r110;
        this.f195559g = r111;
        this.f195560h = r112;
        this.f195561i = r110.f511362b;
        this.f195562j = (SlidesPhotosViewPager) e(R.id.photos_viewpager);
        this.f195563k = e(R.id.progress_bar_mask);
        View r101 = e(R.id.progress_bar_edge_view);
        this.f195564l = r101;
        StoryListProgressBar r113 = (StoryListProgressBar) e(R.id.progress_bar);
        r113.setMaskView(r101);
        this.f195565m = r113;
        Context r102 = getContext();
        r110.getClass();
        r110.f511361a = this;
        Unit r114 = Unit.INSTANCE;
        this.f195566n = new SlidesPhotosPageAdapter(r102, r110);
        this.f195567o = true;
        this.f195573u = new ArrayList();
        this.f195576x = new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.o();
        this.f195577y = new mz3.m(getContext());
        this.f195578z = new PhotoPageChangeListener(this);
        c r115 = new c(this);
        kz3.a r116 = new kz3.a();
        Intrinsics.checkNotNullParameter(r115, "callback");
        r116.f506741f = r115;
        this.B = r116;
        this.E = new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.photo.a(this);
        this.F = new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.photo.b(this);
        this.G = "";
        this.H = "auto";
        this.I = new LinkedHashSet();
        this.K = new d(this);
        this.R = (AoCommonMonitorService) j64.a.a(AoCommonMonitorService.class);
        this.S = new Handler(Looper.getMainLooper());
        this.C = new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.photo.c(this);
        this.D = new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.photo.d(this);
        this.f479457a.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.aos_const_bg_inverse));
        int r117 = b0.f197678a;
        Context r118 = getContext();
        boolean r119 = false;
        if (r118 != null) goto L5;
    L76:
        if (r119 == false) goto L78;
        this.f195562j.addOnLayoutChangeListener(new i(this));
    L78:
        SlidesPhotosViewPager r120 = this.f195562j;
        r120.setAdapter(this.f195566n);
        r120.b(this.f195578z);
        mz3.m r121 = this.f195577y;
        r121.getClass();
        Intrinsics.checkNotNullParameter(r120, "pager");
        Field r122 = ViewPager.class.getDeclaredField("mScroller");     // Catch: Exception -> L81
        r122.setAccessible(true);     // Catch: Exception -> L81
        r122.set(r120, r121);     // Catch: Exception -> L81
    L83:
        r120.setSwipeOutListener(new k(this));
        r120.setScrollListener(new l(this));
        r120.setScrollInterceptor(new m(this));
        r120.setISlidesPhotosViewPagerInterceptor(new n(this));
        this.Q = new a(this);
        return;
    L81:
        e = move-exception;
        e.printStackTrace();
        goto L83
    L5:
        if (r118.getResources() == null) goto L76;
        if (r118.getResources().getConfiguration() == null) goto L76;
        Map<String, String> r103 = b0.f197679b;
        monitor-enter(r103);
        ?? r104 = ((HashMap) r103).get(DeviceUtils.PROPERTIES_KEY_CHARACTERISTICS);     // Catch: Throwable -> L73
        String r105 = (String) r104;     // Catch: Throwable -> L73
        if (r105 != null) goto L14;
    L19:
        boolean r106 = false;
    L20:
        if (r106 == true) goto L97;
    L65:
        Unit r123 = Unit.INSTANCE;     // Catch: Throwable -> L73
        monitor-exit(r103);
        String r107 = (String) r104;
        if (TextUtils.isEmpty(r107) == false) goto L70;
    L71:
        r107 = "phone";
    L72:
        r119 = Intrinsics.areEqual("tablet", r107);
        goto L76
    L70:
        if (Intrinsics.areEqual(r107, "tablet") == true) goto L72;
    L97:
        SharedPreferences r124 = r118.getSharedPreferences("system_properties_cache", 0);     // Catch: Exception -> L63 Throwable -> L73
        BufferedReader r108 = null;
        r104 = r124.getString(DeviceUtils.PROPERTIES_KEY_CHARACTERISTICS, null);     // Catch: Exception -> L63 Throwable -> L73
        if (r104 != 0) goto L24;
    L29:
        boolean r109 = false;
    L93:
        if (r109 == false) goto L65;
        r104 = i0.a();     // Catch: Throwable -> L33
    L48:
        if (r104 != 0) goto L50;
    L55:
        if (r119 == false) goto L65;
        ?? r125 = r124.edit();     // Catch: Exception -> L63 Throwable -> L73
        r125.putString(DeviceUtils.PROPERTIES_KEY_CHARACTERISTICS, r104);     // Catch: Exception -> L63 Throwable -> L73
        r125.apply();     // Catch: Exception -> L63 Throwable -> L73
        goto L65
    L50:
        if (r104.length() <= 0) goto L52;
        boolean r126 = true;
    L53:
        if (r126 != true) goto L55;
        r119 = true;
        goto L55
    L52:
        r126 = false;
    L33:
        BufferedReader r127 = new BufferedReader(new InputStreamReader(com.bytedance.awemeopen.apps.framework.utils.m.a(Runtime.getRuntime(), "getprop ro.build.characteristics").getInputStream(), "UTF-8"), 1024);     // Catch: Throwable -> L39 IOException -> L41
        String r128 = r127.readLine();     // Catch: IOException -> L85 Throwable -> L58
        r127.close();     // Catch: IOException -> L85 Throwable -> L58
        r127.close();     // Catch: IOException -> L37 Exception -> L63 Throwable -> L73
    L38:
        r108 = r128;
    L47:
        r104 = r108;
    L43:
        if (r127 == null) goto L47;
        r127.close();     // Catch: IOException -> L46 Exception -> L63 Throwable -> L73
        goto L47
    L41:
        r127 = null;
    L39:
        th = th;
    L60:
        if (r108 != null) goto L89;
    L62:
        throw th;     // Catch: Exception -> L63 Throwable -> L73
    L89:
        r108.close();     // Catch: IOException -> L86 Exception -> L63 Throwable -> L73
    L58:
        th = th;
        r108 = r127;
        goto L60
    L24:
        if (r104.length() != 0) goto L26;
        boolean r129 = true;
    L27:
        if (r129 != true) goto L29;
        r109 = true;
        goto L93
    L26:
        r129 = false;
    L63:
        e = move-exception;
        e.toString();     // Catch: Throwable -> L73
        goto L65
    L14:
        if (r105.length() != 0) goto L16;
        boolean r130 = true;
    L17:
        if (r130 != true) goto L19;
        r106 = true;
        goto L20
    L16:
        r130 = false;
    L73:
        th = move-exception;
        throw th;
    }

    public static void q(PhotoFeedPagerPresenter r100, int r101, float r102, float r103, long r110, boolean r111, int r112) {
        if ((r112 & 8) == 0) goto L5;
        r110 = 300;
    L5:
        long r104 = r110;
        if ((r112 & 16) == 0) goto L9;
        r111 = false;
    L9:
        if (r100.f195561i.getShowProgressBar() == true) goto L11;
    L15:
        nz3.f r105 = r100.L;
        if (r105 == null) goto L19;
        r105.c(r101, r102, r111);
        return;
    L19:
        return;
    L11:
        if (r100.f195561i.getAutoPlayEnabled() == false) goto L14;
        if (r111 == true) goto L14;
        StoryListProgressBar.g(r100.f195565m, r101, r103 / 100.0f, r104, 8);
    L14:
        r100.f195565m.h(r101, r103 / 100.0f);
        goto L15
    }
}
