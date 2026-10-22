package com.bytedance.awemeopen.apps.photo.presenter;

import android.app.Activity;
import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Size;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.feed.desc.MentionTextView;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.model.PhotoModel;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.model.ScaleType;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.model.SlidesPhotosConfig;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.SlidesPhotosViewPager;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.progress.StoryListProgressBar;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vm.PhotoFeedPagerViewModel;
import com.bytedance.awemeopen.apps.photo.SlidesPhotosLimitPageAdapter;
import com.bytedance.awemeopen.apps.photo.pinch.PinchStableView;
import com.bytedance.awemeopen.apps.photo.utils.ContainerSizeCalculator;
import com.bytedance.awemeopen.bizmodels.feed.ModelRate;
import com.bytedance.awemeopen.bizmodels.feed.video.TextExtraStruct;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.domain.base.repo.GsonHolder;
import com.bytedance.awemeopen.export.api.picturedetail.AosPictureDetailConfig;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.servicesapi.image.AoImageService;
import com.bytedance.awemeopen.servicesapi.monitor.common.AoCommonMonitorService;
import com.bytedance.bdp.bdpbase.service.IBdpService;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.nova.R;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class PhotoPagerPresenter extends f04.a<Unit> implements ISlidesPhotosView, nz3.b, View.OnClickListener, View.OnLongClickListener, nz3.g {
    public static final /* synthetic */ int X = 0;
    public int A;
    public int B;
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.o C;
    public final mz3.m D;
    public com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.a E;
    public final kz3.a F;
    public final i0 G;
    public final g0 H;
    public final h0 I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public String f197866J;
    public String K;
    public final Set<Integer> L;
    public boolean M;
    public nz3.f N;
    public View.OnLongClickListener O;
    public View.OnClickListener P;
    public nz3.d Q;
    public nz3.g R;
    public final ContainerSizeCalculator S;
    public Size T;
    public final AoCommonMonitorService U;
    public final Handler V;
    public int W;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a14.a f197867d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final lz3.b f197868e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PhotoFeedPagerViewModel f197869f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SlidesPhotosConfig f197870g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f197871h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final FrameLayout f197872i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final SlidesPhotosViewPager f197873j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View f197874k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f197875l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final StoryListProgressBar f197876m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final MentionTextView f197877n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final MentionTextView f197878o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final MentionTextView f197879p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final LinearLayout f197880q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ImageView f197881r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final MentionTextView f197882s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final SlidesPhotosLimitPageAdapter f197883t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f197884u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f197885v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f197886w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f197887x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public r14.c f197888y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ArrayList<PhotoModel> f197889z;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/awemeopen/apps/photo/presenter/PhotoPagerPresenter$PhotoPageChangeListener;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "ao_apps_photo_release"}, k = 1, mv = {1, 7, 1})
    public final class PhotoPageChangeListener implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhotoPagerPresenter f197890a;

        public PhotoPageChangeListener(PhotoPagerPresenter r100) {
            this.f197890a = r100;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int r100) {
            AoLogger.g("fps_log", new Object[]{"onPageScrollStateChanged state = " + r100});
            if (r100 == 0) goto L7;
            AoCommonMonitorService r101 = this.f197890a.U;
            if (r101 == null) goto L7;
            r101.S();
        L7:
            if (r100 == 0) goto L11;
            if (r100 != 1) goto L14;
            PhotoPagerPresenter r102 = this.f197890a;
            r102.K = "manual_click";
            r102.D.a(false);
            this.f197890a.f197885v = true;
            return;
        L14:
            return;
        L11:
            this.f197890a.D.a(false);
            PhotoPagerPresenter r103 = this.f197890a;
            r103.D.f516492a.f516488a = 0;
            r103.f197885v = false;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(final int r210) {
            long r100 = System.currentTimeMillis();
            Map<Integer, Map<Integer, c04.f>> r101 = c04.e.f21917a;
            c04.e.a(this.f197890a.f197868e.hashCode(), r210).f21921d = r100;
            int r110 = 0;
            AoLogger.g("fps_log", new Object[]{"onPageSelected position = " + r210});
            AoCommonMonitorService r102 = this.f197890a.U;
            if (r102 == null) goto L5;
            r102.N1();
        L5:
            PhotoPagerPresenter r103 = this.f197890a;
            int r104 = r103.B;
            if (r210 <= r104) goto L8;
            String r105 = "slide_left";
        L9:
            r103.f197866J = r105;
            if (r210 == r104) goto L12;
            c04.e.a(r103.f197868e.hashCode(), this.f197890a.B).f21922e = r100;
            PhotoPagerPresenter r106 = this.f197890a;
            r106.s(r106.B);
        L12:
            PhotoPagerPresenter r107 = this.f197890a;
            r107.B = r210;
            if (r107.o() <= 0) goto L15;
            int r108 = r210 % r107.o();
        L16:
            r107.A = r108;
            r107.f197869f.updateCurrentPosition(r108);
            PhotoPagerPresenter r109 = this.f197890a;
            com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.o r111 = r109.C;
            if (r109.A != (r111.f195085a - 1)) goto L19;
            r111.f195086b = System.currentTimeMillis();
        L20:
            PhotoPagerPresenter r112 = this.f197890a;
            SlidesPhotosViewPager r113 = r112.f197873j;
            int r114 = r112.A;
            r14.c r115 = r112.f197888y;
            if (r115 == null) goto L25;
            List<r14.y> r116 = r115.v();
            if (r116 == null) goto L25;
            int r117 = r116.size();
        L27:
            if (r114 != (r117 - 1)) goto L29;
            boolean r118 = true;
        L30:
            r113.H1 = r118;
            if (this.f197890a.f197870g.getStopByDrag() == false) goto L36;
            PhotoPagerPresenter r119 = this.f197890a;
            if (r119.f197885v == false) goto L36;
            r119.f197887x = true;
        L36:
            if (this.f197890a.f197870g.getAutoPlayEnabled() == true) goto L38;
        L40:
            boolean r120 = false;
        L41:
            if (r120 == false) goto L57;
            PhotoPagerPresenter r121 = this.f197890a;
            kz3.a r122 = r121.F;
            if (r122.f506742g == false) goto L45;
        L46:
            r121.f197886w = false;
            if (r122.f506743h == false) goto L50;
            r122.a();
            PhotoPagerPresenter r123 = this.f197890a;
            PhotoPagerPresenter.q(r123, r123.A, 0.0f, 0.0f, 0, false, 24);
        L62:
            final PhotoPagerPresenter r124 = this.f197890a;
            if (r124.f197884u == true) goto L82;
            kz3.a r125 = r124.F;
            if (r125.f506742g == true) goto L67;
        L69:
            final String r126 = r124.K;
            final String r127 = r124.f197866J;
            final int r128 = r124.o();
            final r14.c r129 = r124.f197888y;
            if (r129 == null) goto L72;
            r124.V.postDelayed(new e0(r124, r129, r126, r127, r210, r128), 10);
        L72:
            PhotoPagerPresenter r130 = this.f197890a;
            if (r130.A != (r130.o() - 1)) goto L82;
            if (this.f197890a.o() > 1) goto L77;
            boolean r131 = true;
        L78:
            if (r131 == true) goto L82;
            PhotoPagerPresenter r132 = this.f197890a;
            if (r132.M == true) goto L82;
            r132.M = true;
            goto L82
        L77:
            r131 = false;
            goto L78
        L67:
            if (r125.f506743h == true) goto L69;
            r124.K = "auto";
        L82:
            PhotoPagerPresenter r133 = this.f197890a;
            r133.L.add(Integer.valueOf(r133.A));
            PhotoPagerPresenter r134 = this.f197890a;
            r134.f197884u = false;
            AosPictureDetailConfig r135 = r134.f197867d.f1368c.getPageConfig();
            if (r135 == null) goto L85;
            r110 = r135.getImageDiskCacheCount();
        L85:
            if (r110 <= 0) goto L115;
            AosPictureDetailConfig r136 = r134.f197867d.f1368c.getPageConfig();
            if (r136 == null) goto L90;
            int r137 = r136.getOffscreenPageLimit();
        L91:
            int r138 = r134.W;
            if (r138 != (-1)) goto L99;
            int r139 = r137 + r210;
            int r140 = Math.min((r110 + r139) + 1, r134.f197889z.size());
        L94:
            r139 = r139 + 1;
            if (r139 >= r140) goto L116;
            if (r134.r(r139) == false) goto L94;
            r134.W = r139;
            goto L94
        L116:
            return;
        L99:
            int r141 = (r137 + r210) + r110;
            if (r138 < r141) goto L102;
            return;
        L102:
            if (r141 < r134.f197889z.size()) goto L104;
            return;
        L104:
            if (r134.r(r141) == false) goto L114;
            r134.W = r141;
            return;
        L114:
            return;
        L90:
            r137 = 3;
            goto L91
        L115:
            return;
        L50:
            if (r121.A != 0) goto L52;
        L55:
            long r142 = r121.f197870g.getPhotoPlayDuration();
        L56:
            PhotoPagerPresenter r143 = this.f197890a;
            r143.f197887x = false;
            r143.F.d(true, r142, true);
            goto L62
        L52:
            if (r121.f197885v == true) goto L55;
            r142 = r121.f197870g.getPhotoPlayDuration() + this.f197890a.f197870g.getScrollAnimationDuration();
            goto L56
        L45:
            if (r121.f197886w == true) goto L46;
        L57:
            if (r120 == true) goto L62;
            PhotoPagerPresenter r144 = this.f197890a;
            if (r144.f197887x == false) goto L61;
            r144.F.e();
        L61:
            PhotoPagerPresenter r145 = this.f197890a;
            PhotoPagerPresenter.q(r145, r145.A, 100.0f, 100.0f, 0, r145.f197887x, 8);
            goto L62
        L38:
            if (this.f197890a.f197887x == true) goto L40;
            r120 = true;
            goto L41
        L29:
            r118 = false;
        L25:
            r117 = 0;
            goto L27
        L19:
            r111.f195086b = -1;
            goto L20
        L15:
            r108 = r210;
            goto L16
        L8:
            r105 = PinchStableView.Gesture.SLIDE_RIGHT;
            goto L9
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int r100, float r101, int r102) {
            PhotoPagerPresenter r103 = this.f197890a;
            int r104 = PhotoPagerPresenter.X;
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
            if (this.f197890a.f197884u == false) goto L18;
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

    public static final class a {
    }

    public final class b implements kz3.a.InterfaceC6635a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhotoPagerPresenter f197891a;

        @Override // kz3.a.InterfaceC6635a
        public final boolean a() {
            if (this.f197891a.f197870g.getAutoPlayEnabled() == false) goto L9;
            nz3.f r100 = this.f197891a.N;
            if (r100 == null) goto L11;
            r100.a();
            return true;
        L11:
            return true;
        L9:
            return false;
        }

        public b(PhotoPagerPresenter r100) {
            this.f197891a = r100;
        }

        @Override // kz3.a.InterfaceC6635a
        public final void b(float r100, float r110, long r111) {
            PhotoPagerPresenter r101 = this.f197891a;
            PhotoPagerPresenter.q(r101, r101.A, r100, r110, r111, false, 16);
            if (r100 != 100.0f) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == false) goto L9;
            this.f197891a.p();
            return;
        L9:
            return;
        L5:
            r102 = false;
            goto L6
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f197892a = null;

        static {
            int[] r100 = new int[Lifecycle.Event.values().length];
            r100[Lifecycle.Event.ON_RESUME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[Lifecycle.Event.ON_PAUSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f197892a = r100;
        }
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void setImageGestureListener(nz3.b r100) {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.b getCurrentViewHolder() {
        int r100 = this.f197873j.getCurrentItem();
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.a r101 = this.E;
        if (r101 == null) goto L14;
        PhotoModel r102 = r101.n();
        SlidesPhotosLimitPageAdapter r103 = this.f197883t;
        List<PhotoModel> r104 = r103.f197780d;
        if (((ArrayList) r104).size() <= 0) goto L7;
        int r105 = r100 % ((ArrayList) r103.f197780d).size();
    L9:
        if (Intrinsics.areEqual(r102, (PhotoModel) CollectionsKt.getOrNull(r104, r105)) == false) goto L14;
        if (r100 != this.A) goto L14;
        return this.E;
    L7:
        r105 = r100;
    L14:
        int r106 = this.f197873j.getChildCount();
        int r107 = 0;
    L15:
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.a r108 = null;
        if (r107 >= r106) goto L34;
        View r109 = this.f197873j.getChildAt(r107);
        if (r109 == null) goto L20;
        Object r110 = r109.getTag(R.id.common_feed_core_holder_id);
    L22:
        if ((r110 instanceof com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.a) == false) goto L24;
        r108 = (com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.a) r110;
    L24:
        if (r108 == null) goto L33;
        PhotoModel r111 = r108.n();
        SlidesPhotosLimitPageAdapter r112 = this.f197883t;
        List<PhotoModel> r113 = r112.f197780d;
        if (((ArrayList) r113).size() <= 0) goto L28;
        int r114 = r100 % ((ArrayList) r112.f197780d).size();
    L30:
        if (Intrinsics.areEqual(r111, (PhotoModel) CollectionsKt.getOrNull(r113, r114)) == false) goto L33;
        this.E = r108;
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

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void initialLoop() {
        q(this, this.A, 100.0f, 100.0f, 0, false, 24);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final boolean isLooping() {
        kz3.a r100 = this.F;
        if (r100.f506742g == true) goto L5;
    L9:
        return false;
    L5:
        if (r100.f506743h == true) goto L9;
        if (this.f197887x == true) goto L9;
        return true;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final boolean isPaused() {
        return this.F.f506743h;
    }

    public final void m() {
        this.f197873j.setDisableScroll(!this.f197870g.getDragEnabled());
        this.f197873j.setDisableOutScroll(!this.f197870g.getOutDragEnabled());
        this.D.f516493b = (int) this.f197870g.getScrollAnimationDuration();
        if (this.f197870g.getShowProgressBar() == false) goto L7;
        x54.b.d(this.f197876m);
        x54.b.d(this.f197874k);
        this.f197876m.post(new d0(this));
        if (this.f197870g.getEnableProgressBarSwitch() == false) goto L8;
        this.f197876m.setClickEnabled(true);
        this.f197876m.setOnProgressBarSelected(new PhotoPagerPresenter$applySlidesPhotosConfig$2(this));
    L8:
        kz3.a r100 = this.F;
        long r101 = this.f197870g.getPhotoPlayDuration();
        r100.f506737b = r101;
        r100.f506739d = (r100.f506738c / r101) * 100.0f;
        kz3.a r102 = this.F;
        long r103 = this.f197870g.getProgressInterval();
        r102.f506738c = r103;
        r102.f506739d = (r103 / r102.f506737b) * 100.0f;
        if (this.f197870g.getInitPlayPosition() <= 0) goto L14;
        if (this.f197873j.getCurrentItem() == this.f197870g.getInitPlayPosition()) goto L14;
        setCurrentPosition(this.f197870g.getInitPlayPosition(), false, 0);
        int r104 = this.f197870g.getInitPlayPosition();
        this.A = r104;
        this.f197869f.updateCurrentPosition(r104);
        this.B = this.f197870g.getInitPlayPosition();
        return;
    L14:
        if (this.f197873j.getCurrentItem() == 0) goto L18;
        setCurrentPosition(0, false, 0);
        return;
    L18:
        return;
    L7:
        x54.b.a(this.f197874k);
        goto L8
    }

    public final int o() {
        return ((ArrayList) this.f197883t.f197780d).size();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void onDragByUser() {
        if (this.f197870g.getStopByDrag() == true) goto L5;
        return;
    L5:
        if (this.f197887x == true) goto L9;
        this.f197887x = true;
        this.F.e();
        q(this, this.A, 100.0f, 100.0f, 0, this.f197887x, 8);
        return;
    }

    public final void p() {
        nz3.f r100 = this.N;
        if (r100 == null) goto L5;
        r100.b(this.A);
    L5:
        int r101 = o();
        boolean r102 = true;
        int r103 = this.B + 1;
        if (this.f197885v == true) goto L11;
        if (r101 <= 1) goto L11;
        nz3.f r104 = this.N;
        if (r104 == null) goto L12;
        r104.g();
    L12:
        if (r102 == true) goto L14;
        return;
    L14:
        if (r103 < 10000) goto L19;
        nz3.f r105 = this.N;
        if (r105 == null) goto L18;
        r105.h();
    L18:
        setCurrentPosition(0, false, 0);
        return;
    L19:
        setCurrentPosition(r103, false, 0);
        return;
    L11:
        r102 = false;
        goto L12
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void pauseLoop() {
        if (this.f197870g.getShowProgressBar() == true) goto L5;
        return;
    L5:
        kz3.a r100 = this.F;
        if (r100.f506742g == false) goto L9;
        r100.f506743h = true;
        r100.f506746k = 0;
        r100.f506736a.removeMessages(10001);
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void restartLoop() {
        if (this.f197870g.getShowProgressBar() == true) goto L5;
        return;
    L5:
        p();
        q(this, this.A, 0.0f, 0.0f, 0, false, 24);
        startLoop(false);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void resumeLoop() {
        if (this.f197870g.getShowProgressBar() == true) goto L5;
        return;
    L5:
        this.F.b();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void stopLoop() {
        if (this.f197870g.getShowProgressBar() == true) goto L5;
        return;
    L5:
        this.F.e();
    }

    @Override // f04.a
    public final void k() {
        stopLoop();
        this.f197876m.e();
        SlidesPhotosLimitPageAdapter r100 = this.f197883t;
        Iterator<T> r101 = r100.f197781e.values().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((com.bytedance.awemeopen.apps.framework.framework.viewpager.g) r101.next()).k();
        goto L4
    L6:
        r100.f197781e.clear();
        this.f197888y = null;
        this.f197887x = false;
        this.E = null;
        this.f197866J = "";
        this.K = "auto";
        this.L.clear();
        this.f197868e.f511362b.reset();
        this.f197869f.getCancelLoop().removeObserver(this.H);
        this.f197869f.getPreviewSelectedPhotoPosition().removeObserver(this.I);
        Map<Integer, Map<Integer, c04.f>> r102 = c04.e.f21917a;
        int r103 = this.f197868e.hashCode();
        Map<Integer, c04.f> r104 = c04.e.f21917a.remove(Integer.valueOf(r103));
        if (r104 == null) goto L11;
        r104.clear();
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final int getCurrentItem() {
        return this.B;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final int getCurrentPosition() {
        return this.A;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final View getProgressBar() {
        return this.f197876m;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final boolean isStoppedByDrag() {
        return this.f197887x;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void changeToFullPreview(boolean r100) {
        if (r100 == false) goto L9;
        this.f197868e.f511362b.setScaleType(ScaleType.FIT_CENTER);
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.b r101 = getCurrentViewHolder();
        if (r101 == null) goto L6;
        ((com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.d) r101).q();
    L6:
        int r102 = this.f197873j.getCurrentItem();
        n(r102 - 1);
        n(r102 + 1);
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.b r103 = getCurrentViewHolder();
        if (r103 == null) goto L14;
        r103.b(r100);
        return;
    L14:
        return;
    L9:
        this.f197868e.f511362b.setScaleType(ScaleType.AUTO_MODE);
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.b r104 = getCurrentViewHolder();
        if (r104 == null) goto L12;
        ((com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.d) r104).q();
    L12:
        int r105 = this.f197873j.getCurrentItem();
        n(r105 - 1);
        n(r105 + 1);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void handleProgressSwitch(boolean r100) {
        if (r100 == false) goto L5;
        setCurrentPosition(this.B + 1, false, 0);
    L8:
        onDragByUser();
        return;
    L5:
        int r101 = this.B;
        if (r101 < 1) goto L8;
        setCurrentPosition(r101 - 1, false, 0);
        goto L8
    }

    @Override // f04.a
    public final void j(Unit r210) {
        Intrinsics.checkNotNullParameter(r210, "data");
        this.f197888y = this.f197867d.f1366a;
        this.f197889z.clear();
        ArrayList<PhotoModel> r100 = this.f197889z;
        int r101 = com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.l.f195077a;
        r100.addAll(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.l.a(this.f197888y));
        this.f197868e.f511363c = this.f197888y;
        Size r102 = this.S.a(this.f197867d.f1366a, getContext());
        this.T = r102;
        FrameLayout r103 = this.f197872i;
        int r104 = r102.getHeight();
        Intrinsics.checkNotNullParameter(r103, "<this>");
        Intrinsics.checkNotNullParameter(r103, "<this>");
        if (r104 < 0) goto L9;
        ViewGroup.LayoutParams r105 = r103.getLayoutParams();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        if (r104 < 0) goto L8;
        r105.height = r104;
    L8:
        r103.setLayoutParams(r105);
    L9:
        this.f197883t.f197779c.f511362b.setHeight(this.T.getHeight());
        this.f197883t.f197779c.f511362b.setWidth(this.T.getWidth());
        this.f197883t.f197779c.f511362b.setScaleType(ScaleType.ALWAYS_FIT_WIDTH);
        SlidesPhotosLimitPageAdapter r106 = this.f197883t;
        ArrayList<PhotoModel> r107 = this.f197889z;
        ((ArrayList) r106.f197780d).clear();
        if (r107 == null) goto L12;
        ((ArrayList) r106.f197780d).addAll(r107);
    L12:
        r106.notifyDataSetChanged();
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.o r108 = this.C;
        r14.c r109 = this.f197888y;
        if (r109 == null) goto L17;
        List<r14.y> r110 = r109.v();
        if (r110 == null) goto L17;
        int r111 = r110.size();
    L18:
        r108.f195085a = r111;
        boolean r112 = true;
        if (o() > 1) goto L21;
        boolean r113 = true;
    L22:
        if (r113 == false) goto L25;
        this.f197870g.singlePhotoConfig();
    L25:
        if (com.bytedance.awemeopen.apps.framework.feed.ui.information.a.f196001m == false) goto L27;
        this.f197870g.setDragEnabled(true);
    L27:
        m();
        MentionTextView r114 = this.f197877n;
        int r115 = com.bytedance.awemeopen.apps.photo.utils.d.f198040a;
        r14.c r116 = this.f197867d.f1366a;
        if (r116 == null) goto L30;
        String r117 = r116.p();
    L31:
        String r118 = "";
        if (TextUtils.isEmpty(r117) == true) goto L43;
        TextExtraStruct r119 = com.bytedance.awemeopen.apps.photo.utils.d.a(r116);
        if (r119 == null) goto L43;
        if (r116 == null) goto L41;
        String r120 = r116.p();
        if (r120 == null) goto L41;
        CharSequence r121 = r120.subSequence(r119.getStart(), r119.getEnd());
    L42:
        r118 = String.valueOf(r121);
    L41:
        r121 = null;
    L43:
        Intrinsics.checkNotNullParameter(r114, "textView");
        if (StringsKt.isBlank(r118) == false) goto L46;
        r114.setVisibility(8);
    L47:
        MentionTextView r122 = this.f197878o;
        r14.c r123 = this.f197867d.f1366a;
        if (r123 == null) goto L50;
        String r124 = r123.p();
    L51:
        String r125 = "";
        if (TextUtils.isEmpty(r124) == true) goto L108;
        TextExtraStruct r126 = com.bytedance.awemeopen.apps.photo.utils.d.a(r123);
        if (r126 != null) goto L61;
        if (r123 == null) goto L108;
        String r127 = r123.p();
        if (r127 == null) goto L108;
    L60:
        r125 = r127;
        goto L108
    L61:
        if (r123 == null) goto L63;
        String r128 = r123.p();
    L65:
        if (TextUtils.isEmpty(r128) == true) goto L98;
        if (r123 == null) goto L87;
        List<TextExtraStruct> r129 = r123.N();
        if (r129 == null) goto L87;
        ArrayList r130 = new ArrayList();
        Iterator<T> r131 = r129.iterator();
    L72:
        if (r131.hasNext() == false) goto L76;
        TextExtraStruct r132 = (TextExtraStruct) r131.next();
        if (r132 == null) goto L72;
        r130.add(r132);
        goto L72
    L76:
        Iterator r133 = r130.iterator();
    L78:
        if (r133.hasNext() == false) goto L85;
        Object r134 = r133.next();
        if (((TextExtraStruct) r134).getType() != 8) goto L82;
        boolean r135 = true;
    L83:
        if (r135 == false) goto L78;
    L86:
        TextExtraStruct r136 = (TextExtraStruct) r134;
    L88:
        if (r136 == null) goto L98;
        if (r136.getStart() >= r136.getEnd()) goto L98;
        int r137 = r136.getEnd();
        String r138 = r123.p();
        if (r138 != null) goto L95;
        r138 = "";
    L95:
        if (r137 > r138.length()) goto L98;
        if (r136.getStart() < 0) goto L98;
    L99:
        if (r136 == null) goto L101;
        int r139 = r136.getEnd();
    L103:
        if (r123 == null) goto L108;
        String r140 = r123.p();
        if (r140 == null) goto L108;
        r127 = r140.subSequence(r139, r140.length()).toString();
        if (r127 != null) goto L60;
    L101:
        r139 = r126.getEnd();
        goto L103
    L82:
        r135 = false;
        goto L83
    L85:
        r134 = null;
    L87:
        r136 = null;
    L98:
        r136 = null;
        goto L99
    L63:
        r128 = null;
    L108:
        Intrinsics.checkNotNullParameter(r122, "textView");
        if (StringsKt.isBlank(r125) == false) goto L111;
        r122.setVisibility(8);
    L112:
        MentionTextView r141 = this.f197878o;
        if ((r141 instanceof MentionTextView) == true) goto L116;
        r141 = null;
    L116:
        if (r141 == null) goto L118;
        r141.setSpanSize(r141.getTextSize());
    L118:
        int r142 = Build.VERSION.SDK_INT;
        if (r142 >= 23) goto L121;
    L123:
        MentionTextView r143 = this.f197879p;
        Activity r144 = this.f197867d.getActivity();
        long r145 = TimeUnit.SECONDS.toMillis(this.f197867d.f1366a.o());
        SimpleDateFormat r146 = com.bytedance.awemeopen.apps.framework.utils.k0.f197720a;
        long r147 = Calendar.getInstance().getTimeInMillis() - r145;
        if (r147 >= 60000) goto L127;
        String r148 = r144.getString(R.string.aos_just_now);
    L160:
        r143.setText(r148);
        int r149 = com.bytedance.awemeopen.apps.photo.utils.d.f198040a;
        r14.c r150 = this.f197867d.f1366a;
        String r151 = "";
        if (r150 == null) goto L188;
        r14.i r152 = r150.h();
        if (r152 != null) goto L166;
    L168:
        boolean r153 = false;
    L169:
        if (r153 == false) goto L188;
        r14.i r154 = r150.h();
        if (r154 != null) goto L173;
    L175:
        r112 = false;
    L176:
        if (r112 == false) goto L188;
        if (r150.G() != ModelRate.NotRecommended) goto L180;
    L181:
        r14.i r155 = r150.h();
        if (r155 == null) goto L188;
        String r156 = r155.a();
        if (r156 == null) goto L188;
        r151 = r156;
        goto L188
    L180:
        if (r150.G() != ModelRate.Fresh) goto L188;
    L173:
        if (r154.d() != true) goto L175;
    L166:
        if (r152.c() == true) goto L168;
        r153 = true;
    L188:
        if (com.bytedance.awemeopen.apps.framework.utils.h0.a(r151) == false) goto L203;
        this.f197880q.setVisibility(0);
        this.f197882s.setText(r151);
        if (com.bytedance.awemeopen.apps.framework.utils.n0.d(getContext()) == false) goto L192;
        this.f197881r.setColorFilter(getContext().getResources().getColor(R.color.aos_full_page_publish_info), PorterDuff.Mode.SRC_IN);
    L192:
        r14.c r157 = this.f197867d.f1366a;
        if (r157 == null) goto L198;
        r14.i r158 = r157.h();
        if (r158 == null) goto L198;
        String r159 = r158.a();
        if (r159 == null) goto L198;
    L200:
        if (StringsKt.contains$default(r159, "声明", false, 2, null) == false) goto L202;
        this.f197881r.setImageResource(R.drawable.aos_picture_reminder_icon);
    L204:
        this.f197869f.getPreviewSelectedPhotoPosition().observe(this.f197867d.f1369d, this.I);
        this.f197867d.f1369d.getLifecycle().addObserver(this.G);
        return;
    L202:
        this.f197881r.setImageResource(R.drawable.aos_picture_warning_icon);
    L198:
        r159 = "";
        goto L200
    L203:
        this.f197880q.setVisibility(8);
        goto L204
    L127:
        if (r147 >= 3600000) goto L129;
        r148 = r144.getString(R.string.aos_minutes_ago, new Object[]{Long.valueOf(r147 / 60000)});
        goto L160
    L129:
        Calendar r160 = Calendar.getInstance();
        r160.set(11, 0);
        r160.set(12, 0);
        r160.set(13, 0);
        if (r145 < r160.getTimeInMillis()) goto L132;
        r148 = r144.getString(R.string.aos_hours_ago, new Object[]{Long.valueOf(r147 / 3600000)});
        goto L160
    L132:
        r160.add(6, -1);
        long r161 = r160.getTimeInMillis();
        Calendar r162 = Calendar.getInstance();
        r162.setTimeInMillis(r145);
        if (r145 < r161) goto L143;
        SimpleDateFormat r163 = com.bytedance.awemeopen.apps.framework.utils.k0.f197721b;
        monitor-enter(r163);
        r148 = r144.getString(R.string.aos_yesterday) + r163.format(r162.getTime());     // Catch: Throwable -> L139
        monitor-exit(r163);     // Catch: Throwable -> L139
    L139:
        th = move-exception;
        throw th;
    L143:
        if (r147 >= 345600000) goto L145;
        r148 = r144.getString(R.string.aos_days_ago, new Object[]{Long.valueOf(r147 / 86400000)});
        goto L160
    L145:
        Calendar r164 = Calendar.getInstance();
        r164.set(6, 1);
        r164.set(11, 0);
        r164.set(12, 0);
        r164.set(13, 0);
        if (r145 < r164.getTimeInMillis()) goto L155;
        SimpleDateFormat r165 = com.bytedance.awemeopen.apps.framework.utils.k0.f197724e;
        monitor-enter(r165);
        String r166 = r165.format(r162.getTime());     // Catch: Throwable -> L152
        monitor-exit(r165);     // Catch: Throwable -> L152
    L159:
        r148 = r166;
    L152:
        th = move-exception;
        throw th;
    L155:
        SimpleDateFormat r167 = com.bytedance.awemeopen.apps.framework.utils.k0.f197720a;
        monitor-enter(r167);
        r166 = r167.format(r162.getTime());     // Catch: Throwable -> L206
        monitor-exit(r167);     // Catch: Throwable -> L206
    L206:
        th = move-exception;
        throw th;
    L121:
        if (r142 < 29) goto L123;
        this.f197878o.setBreakStrategy(0);
        goto L123
    L111:
        r122.setText(r125);
        r122.setVisibility(0);
        goto L112
    L50:
        r124 = null;
        goto L51
    L46:
        r114.setText(r118);
        r114.setVisibility(0);
        goto L47
    L30:
        r117 = null;
        goto L31
    L21:
        r113 = false;
    L17:
        r111 = 0;
        goto L18
    }

    public final void n(int r100) {
        if (r100 >= 0) goto L4;
        return;
    L4:
        if (r100 >= this.f197873j.getChildCount()) goto L18;
        View r101 = this.f197873j.getChildAt(r100);
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
        View.OnClickListener r101 = this.P;
        if (r101 == null) goto L6;
        r101.onClick(r100);
        return;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        View.OnLongClickListener r101 = this.O;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.onLongClick(r100);
    }

    @Override // nz3.g
    public final boolean onTouchEvent(MotionEvent r100) {
        nz3.g r101 = this.R;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.onTouchEvent(r100);
    }

    public final boolean r(int r100) {
        if (r100 >= 0) goto L5;
    L22:
        return false;
    L5:
        if (r100 >= this.f197889z.size()) goto L22;
        r14.y r101 = ((PhotoModel) ListProtector.get(this.f197889z, r100)).getUrlStruct();
        if (r101 == null) goto L10;
        List<String> r102 = r101.c();
    L11:
        List<String> r103 = r102;
        if (r103 != null) goto L14;
    L17:
        boolean r104 = true;
    L18:
        if (r104 == false) goto L20;
        return false;
    L20:
        int r105 = j64.b.f497514a;
        IBdpService r106 = j64.a.a(AoImageService.class);
        Intrinsics.checkNotNull(r106);
        l64.b r107 = new l64.b();
        r107.f507668c = r102;
        ((AoImageService) r106).h0(y54.a.a(), r107);
        return true;
    L14:
        if (r103.isEmpty() == true) goto L17;
        r104 = false;
        goto L18
    L10:
        r102 = null;
        goto L11
    }

    public final void s(int r310) {
        if (this.f197888y != null) goto L5;
        return;
    L5:
        Map<Integer, Map<Integer, c04.f>> r100 = c04.e.f21917a;
        int r101 = this.f197868e.hashCode();
        Map<Integer, Map<Integer, c04.f>> r102 = c04.e.f21917a;
        LinkedHashMap r103 = (LinkedHashMap) r102;
        Map r104 = (Map) r103.get(Integer.valueOf(r101));
        if (r104 == null) goto L8;
        c04.f r105 = (c04.f) r104.get(Integer.valueOf(r310));
    L9:
        if (r105 != null) goto L11;
        return;
    L11:
        long r106 = r105.f21921d;
        long r107 = 0;
        if (r106 > 0) goto L14;
    L16:
        long r108 = r105.f21920c;
        if (r108 > 0) goto L19;
    L21:
        r107 = r108 - r106;
    L22:
        long r110 = r107;
        AosEventReporter r109 = AosEventReporter.f194596a;
        String r111 = this.f197867d.f1368c.sceneId();
        if (r105.f21918a != 1) goto L25;
        boolean r112 = true;
    L26:
        int r113 = r105.f21923f;
        int r114 = r105.f21924g;
        long r115 = r105.f21922e - r105.f21921d;
        long r116 = r105.f21920c - r105.f21919b;
        r14.c r117 = this.f197888y;
        Intrinsics.checkNotNull(r117);
        String r118 = this.K;
        String r119 = this.f197866J;
        if (r310 != 0) goto L29;
        boolean r210 = true;
    L30:
        String r120 = String.valueOf(r310);
        String r121 = String.valueOf(o());
        AosPictureDetailConfig r122 = this.f197867d.f1368c.getPageConfig();
        if (r122 == null) goto L36;
        String r123 = r122.getPreviousPage();
        if (r123 == null) goto L36;
        String r124 = r123;
    L37:
        r109.getClass();
        Intrinsics.checkNotNullParameter(r111, "enterFrom");
        Intrinsics.checkNotNullParameter(r117, ShareChannel.DOUYIN);
        Intrinsics.checkNotNullParameter(r118, "enterMethod");
        Intrinsics.checkNotNullParameter(r119, "slideDirection");
        Intrinsics.checkNotNullParameter(r120, "photoSerialNum");
        Intrinsics.checkNotNullParameter(r121, "allPhotoNum");
        Intrinsics.checkNotNullParameter(r124, "previousPage");
        d14.a r125 = b14.a.f16924a;
        t24.a r126 = (t24.a) b14.a.a(t24.a.class);
        User r127 = r117.f();
        if (r127 == null) goto L43;
        String r128 = r127.u();
        if (r128 == null) goto L43;
        String r211 = r128;
    L44:
        String r212 = r117.c();
        String r129 = r117.r().f535651c;
        if (r129 != null) goto L47;
        String r213 = "";
    L48:
        String r214 = GsonProtectorUtils.toJson(GsonHolder.a(), r117.f535622d);
        r14.a0 r130 = r117.f535622d;
        if (r130 == null) goto L54;
        String r131 = r130.a();
        if (r131 == null) goto L54;
        String r215 = r131;
    L55:
        r126.e3(r111, r310, r110, r112, r113, r114, r115, r110, r116, r211, r212, r213, r118, r119, r215, r214, AosEventReporter.e(r117), r210, r120, r121, null, r124);
        return;
    L54:
        r215 = "";
        goto L55
    L47:
        r213 = r129;
    L43:
        r211 = "";
    L36:
        r124 = "";
        goto L37
    L29:
        r210 = false;
        goto L30
    L25:
        r112 = false;
        goto L26
    L19:
        if (r106 <= r108) goto L21;
    L14:
        if (r105.f21920c > 0) goto L16;
        r107 = -1;
        goto L22
    L8:
        r105 = null;
        goto L9
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void seek(float r100) {
        if (this.f197870g.getShowProgressBar() == true) goto L5;
        return;
    L5:
        this.F.c(r100);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void setClickListener(View.OnClickListener r100) {
        this.P = r100;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void setLongClickListener(View.OnLongClickListener r100) {
        this.O = r100;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void setOnSwipeListener(nz3.d r100) {
        this.Q = r100;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void setRefreshInFirstPosition(boolean r100) {
        this.f197886w = r100;
        if (r100 == true) goto L5;
        return;
    L5:
        if (this.f197873j.getCurrentItem() == 0) goto L7;
        setCurrentPosition(0, false, 300);
        return;
    L7:
        startLoop(false);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void setSlidesPhotosConfig(SlidesPhotosConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f197870g = r100;
        lz3.b r101 = this.f197868e;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r101.f511362b = r100;
        m();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void setSlidesProgressCallback(nz3.f r100) {
        this.N = r100;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void setTouchInterceptor(nz3.g r100) {
        this.R = r100;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void startLoop(boolean r110) {
        if (this.f197870g.getShowProgressBar() == true) goto L6;
        return;
    L6:
        if (r110 == false) goto L9;
        reset(0, 0);
    L9:
        if (this.f197870g.getAutoPlayEnabled() == false) goto L11;
        this.f197887x = false;
        kz3.a r111 = this.F;
        long r100 = this.f197870g.getPhotoPlayDuration();
        int r101 = kz3.a.f506735l;
        r111.d(true, r100, false);
        return;
    L11:
        q(this, this.A, 100.0f, 100.0f, 0, false, 24);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void reset(int r100, long r101) {
        stopLoop();
        int r102 = this.f197873j.getCurrentItem();
        if (o() <= 0) goto L6;
        r102 = r102 % o();
    L6:
        if (r102 == r100) goto L8;
        setCurrentPosition(r100, false, r101);
    L8:
        this.D.f516492a.f516488a = 0;
        this.f197876m.f(r100);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void setCurrentPositionFullProgress(int r110, boolean r111) {
        this.D.a(r111);
        this.f197873j.w(r110, r111);
        q(this, r110, 100.0f, 100.0f, 0, this.f197887x, 8);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.bytedance.awemeopen.apps.photo.presenter.g0] */
    /* JADX WARN: Type inference failed for: r3v12, types: [com.bytedance.awemeopen.apps.photo.presenter.i0] */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.bytedance.awemeopen.apps.photo.presenter.h0] */
    public PhotoPagerPresenter(a14.a r100, lz3.b r101, PhotoFeedPagerViewModel r102) {
        Intrinsics.checkNotNullParameter(r100, "feedGroupParameters");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "photoVM");
        super(r100.f1367b);
        this.f197867d = r100;
        this.f197868e = r101;
        this.f197869f = r102;
        this.f197870g = r101.f511362b;
        this.f197871h = LazyKt.lazy(new PhotoPagerPresenter$pagePinchVM$2(this));
        this.f197872i = (FrameLayout) i(R.id.photos_container);
        SlidesPhotosViewPager r103 = (SlidesPhotosViewPager) i(R.id.photos_viewpager);
        this.f197873j = r103;
        this.f197874k = i(R.id.progress_bar_mask);
        View r104 = i(R.id.progress_bar_edge_view);
        this.f197875l = r104;
        StoryListProgressBar r105 = (StoryListProgressBar) i(R.id.progress_bar);
        r105.setMaskView(r104);
        this.f197876m = r105;
        LinearLayout r106 = (LinearLayout) i(R.id.photos_card_extras_module);
        this.f197877n = (MentionTextView) i(R.id.tv_title);
        this.f197878o = (MentionTextView) i(R.id.tv_desc);
        this.f197879p = (MentionTextView) i(R.id.tv_time);
        this.f197880q = (LinearLayout) i(R.id.risk_warning_layout);
        this.f197881r = (ImageView) i(R.id.risk_warning_icon);
        this.f197882s = (MentionTextView) i(R.id.risk_warning_text);
        Context r107 = getContext();
        r101.getClass();
        r101.f511361a = this;
        Unit r108 = Unit.INSTANCE;
        SlidesPhotosLimitPageAdapter r109 = new SlidesPhotosLimitPageAdapter(r107, r101);
        this.f197883t = r109;
        this.f197884u = true;
        this.f197889z = new ArrayList();
        this.C = new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.o();
        mz3.m r110 = new mz3.m(getContext());
        this.D = r110;
        PhotoPageChangeListener r111 = new PhotoPageChangeListener(this);
        b r112 = new b(this);
        kz3.a r113 = new kz3.a();
        Intrinsics.checkNotNullParameter(r112, "callback");
        r113.f506741f = r112;
        this.F = r113;
        this.H = new g0(this);
        this.I = new h0(this);
        this.f197866J = "";
        this.K = "auto";
        this.L = new LinkedHashSet();
        this.S = new ContainerSizeCalculator();
        this.T = new Size(0, 0);
        this.U = (AoCommonMonitorService) j64.a.a(AoCommonMonitorService.class);
        this.V = new Handler(Looper.getMainLooper());
        this.G = new i0(this);
        AosPictureDetailConfig r114 = r100.f1368c.getPageConfig();
        if (r114 == null) goto L5;
        int r115 = r114.getOffscreenPageLimit();
    L6:
        r103.setOffscreenPageLimit(r115);
        r103.setAdapter(r109);
        r103.b(r111);
        Intrinsics.checkNotNullParameter(r103, "pager");
        Field r116 = ViewPager.class.getDeclaredField("mScroller");     // Catch: Exception -> L9
        r116.setAccessible(true);     // Catch: Exception -> L9
        r116.set(r103, r110);     // Catch: Exception -> L9
    L11:
        r103.setSwipeOutListener(new j0(this));
        r103.setScrollListener(new k0(this));
        r103.setScrollInterceptor(new l0(this));
        r103.setISlidesPhotosViewPagerInterceptor(new m0(this));
        this.W = -1;
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    L5:
        r115 = 3;
        goto L6
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void setCurrentPosition(final int r100, final boolean r101, long r102) {
        this.D.a(r101);
        if (r102 <= 0) goto L5;
        this.f197873j.postDelayed(new f0(this, r100, r101), r102);
        return;
    L5:
        this.f197873j.w(r100, r101);
    }

    public static void q(PhotoPagerPresenter r100, int r101, float r102, float r103, long r110, boolean r111, int r112) {
        if ((r112 & 8) == 0) goto L5;
        r110 = 300;
    L5:
        long r104 = r110;
        if ((r112 & 16) == 0) goto L9;
        r111 = false;
    L9:
        if (r100.f197870g.getShowProgressBar() == true) goto L11;
    L15:
        nz3.f r105 = r100.N;
        if (r105 == null) goto L19;
        r105.c(r101, r102, r111);
        return;
    L19:
        return;
    L11:
        if (r100.f197870g.getAutoPlayEnabled() == false) goto L14;
        if (r111 == true) goto L14;
        StoryListProgressBar.g(r100.f197876m, r101, r103 / 100.0f, r104, 8);
    L14:
        r100.f197876m.h(r101, r103 / 100.0f);
        goto L15
    }
}
