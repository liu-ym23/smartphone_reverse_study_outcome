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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
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
    public boolean J;
    public final d K;
    public nz3.f L;
    public View.OnLongClickListener M;
    public View.OnClickListener N;
    public nz3.d O;
    public nz3.g P;
    public final a Q;
    public final AoCommonMonitorService R;
    public final Handler S;
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a e;
    public final lz3.b f;
    public final PhotoFeedPagerViewModel g;
    public final p h;
    public SlidesPhotosConfig i;
    public final SlidesPhotosViewPager j;
    public final View k;
    public final View l;
    public final StoryListProgressBar m;
    public final SlidesPhotosPageAdapter n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public jz3.a s;
    public r14.c t;
    public final ArrayList<PhotoModel> u;
    public int v;
    public int w;
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.o x;
    public final mz3.m y;
    public final PhotoPageChangeListener z;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/presenter/photo/PhotoFeedPagerPresenter$PhotoPageChangeListener;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public final class PhotoPageChangeListener implements ViewPager.OnPageChangeListener {
        public final /* synthetic */ PhotoFeedPagerPresenter a;

        public PhotoPageChangeListener(PhotoFeedPagerPresenter r1) {
            this.a = r1;
        }

        public final void onPageScrollStateChanged(int r5) {
            AoLogger.g("fps_log", new Object[]{"onPageScrollStateChanged state = " + r5});
            if (r5 == 0) goto L7;
            AoCommonMonitorService r1 = this.a.R;
            if (r1 == null) goto L7;
            r1.S();
        L7:
            if (r5 == 0) goto L11;
            if (r5 != 1) goto L14;
            PhotoFeedPagerPresenter r6 = this.a;
            r6.H = "manual_click";
            r6.y.a(false);
            this.a.p = true;
            return;
        L14:
            return;
        L11:
            this.a.y.a(false);
            PhotoFeedPagerPresenter r7 = this.a;
            r7.y.a.a = 0;
            r7.p = false;
        }

        public final void onPageSelected(final int r18) {
            AoLogger.g("fps_log", new Object[]{"onPageSelected position = " + r18});
            AoCommonMonitorService r1 = this.a.R;
            if (r1 == null) goto L5;
            r1.N1();
        L5:
            PhotoFeedPagerPresenter r2 = this.a;
            if (r18 <= r2.w) goto L8;
            String r3 = "slide_left";
        L9:
            r2.G = r3;
            r2.w = r18;
            if (r2.o() <= 0) goto L12;
            int r4 = r18 % r2.o();
        L13:
            r2.v = r4;
            PhotoFeedPagerPresenter r5 = this.a;
            com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.o r6 = r5.x;
            if (r5.v != (r6.a - 1)) goto L16;
            r6.b = System.currentTimeMillis();
        L17:
            PhotoFeedPagerPresenter r7 = this.a;
            SlidesPhotosViewPager r8 = r7.j;
            int r9 = r7.v;
            r14.c r10 = r7.t;
            if (r10 == null) goto L22;
            List r11 = r10.v();
            if (r11 == null) goto L22;
            int r12 = r11.size();
        L24:
            if (r9 != (r12 - 1)) goto L26;
            boolean r13 = true;
        L27:
            r8.H1 = r13;
            if (this.a.i.getStopByDrag() == false) goto L33;
            PhotoFeedPagerPresenter r14 = this.a;
            if (r14.p == false) goto L33;
            r14.r = true;
        L33:
            if (this.a.i.getAutoPlayEnabled() == true) goto L35;
        L37:
            boolean r15 = false;
        L38:
            if (r15 == false) goto L54;
            PhotoFeedPagerPresenter r16 = this.a;
            kz3.a r17 = r16.B;
            if (r17.g == false) goto L42;
        L43:
            r16.q = false;
            if (r17.h == false) goto L47;
            r17.a();
            PhotoFeedPagerPresenter r19 = this.a;
            PhotoFeedPagerPresenter.q(r19, r19.v, 0.0f, 0.0f, 0, false, 24);
        L59:
            final PhotoFeedPagerPresenter r20 = this.a;
            if (r20.o == true) goto L77;
            kz3.a r21 = r20.B;
            if (r21.g == true) goto L64;
        L66:
            final String r22 = r20.H;
            final String r23 = r20.G;
            final int r24 = r20.o();
            r20.S.postDelayed(new f(r20, r22, r23, r18, r24), 10);
            PhotoFeedPagerPresenter r25 = this.a;
            if (r25.v != (r25.o() - 1)) goto L77;
            if (this.a.r() == true) goto L77;
            PhotoFeedPagerPresenter r26 = this.a;
            if (r26.J == true) goto L76;
            r26.J = true;
            AosEventReporter r27 = AosEventReporter.a;
            com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r28 = r26.e;
            jz3.a r29 = r26.s;
            if (r29 != null) goto L75;
            Intrinsics.throwUninitializedPropertyAccessException("mData");
            r29 = null;
        L75:
            r27.getClass();
            AosEventReporter.S(r28, r29);
        L76:
            this.a.h.c++;
            goto L77
        L64:
            if (r21.h == true) goto L66;
            r20.H = "auto";
        L77:
            PhotoFeedPagerPresenter r30 = this.a;
            r30.I.add(Integer.valueOf(r30.v));
            this.a.o = false;
            return;
        L47:
            if (r16.v != 0) goto L49;
        L52:
            long r31 = r16.i.getPhotoPlayDuration();
        L53:
            PhotoFeedPagerPresenter r32 = this.a;
            r32.r = false;
            r32.B.d(true, r31, true);
            goto L59
        L49:
            if (r16.p == true) goto L52;
            r31 = r16.i.getPhotoPlayDuration() + this.a.i.getScrollAnimationDuration();
            goto L53
        L42:
            if (r16.q == true) goto L43;
        L54:
            if (r15 == true) goto L59;
            PhotoFeedPagerPresenter r33 = this.a;
            if (r33.r == false) goto L58;
            r33.B.e();
        L58:
            PhotoFeedPagerPresenter r34 = this.a;
            PhotoFeedPagerPresenter.q(r34, r34.v, 100.0f, 100.0f, 0, r34.r, 8);
            goto L59
        L35:
            if (this.a.r == true) goto L37;
            r15 = true;
            goto L38
        L26:
            r13 = false;
        L22:
            r12 = 0;
            goto L24
        L16:
            r6.b = -1;
            goto L17
        L12:
            r4 = r18;
            goto L13
        L8:
            r3 = PinchStableView.Gesture.SLIDE_RIGHT;
            goto L9
        }

        public final void onPageScrolled(int r2, float r3, int r4) {
            PhotoFeedPagerPresenter r5 = this.a;
            int r0 = PhotoFeedPagerPresenter.T;
            if (r5.o() <= 0) goto L5;
            int r6 = r2 % r5.o();
        L6:
            if (r2 == 0) goto L8;
            return;
        L8:
            if (r3 != 0.0f) goto L10;
            boolean r7 = true;
        L11:
            if (r7 == true) goto L13;
            return;
        L13:
            if (this.a.o == false) goto L18;
            onPageSelected(r6);
            return;
        L18:
            return;
        L10:
            r7 = false;
            goto L11
        L5:
            r6 = r2;
            goto L6
        }
    }

    public static final class a implements com.bytedance.awemeopen.apps.framework.utils.audio.a.InterfaceC0106a {
        public final /* synthetic */ PhotoFeedPagerPresenter a;

        @Override // com.bytedance.awemeopen.apps.framework.utils.audio.a.InterfaceC0106a
        public final void a() {
        }

        @Override // com.bytedance.awemeopen.apps.framework.utils.audio.a.InterfaceC0106a
        public final void b() {
        }

        @Override // com.bytedance.awemeopen.apps.framework.utils.audio.a.InterfaceC0106a
        public final void d() {
            if (this.a.i.getShowProgressBar() == false) goto L10;
            PhotoFeedPagerPresenter r0 = this.a;
            if (r0.B.h == true) goto L7;
            return;
        L7:
            if (r0.isLooping() == true) goto L12;
            this.a.resumeLoop();
            return;
        L12:
            return;
        }

        public a(PhotoFeedPagerPresenter r1) {
            this.a = r1;
        }

        @Override // com.bytedance.awemeopen.apps.framework.utils.audio.a.InterfaceC0106a
        public final void c(boolean r1) {
            this.a.pauseLoop();
        }
    }

    public static final class b {
    }

    public final class c implements kz3.a.InterfaceC0142a {
        public final /* synthetic */ PhotoFeedPagerPresenter a;

        @Override // kz3.a.InterfaceC0142a
        public final boolean a() {
            if (this.a.i.getAutoPlayEnabled() == false) goto L9;
            nz3.f r0 = this.a.L;
            if (r0 == null) goto L11;
            r0.a();
            return true;
        L11:
            return true;
        L9:
            return false;
        }

        public c(PhotoFeedPagerPresenter r1) {
            this.a = r1;
        }

        @Override // kz3.a.InterfaceC0142a
        public final void b(float r9, float r10, long r11) {
            PhotoFeedPagerPresenter r0 = this.a;
            PhotoFeedPagerPresenter.q(r0, r0.v, r9, r10, r11, false, 16);
            if (r9 != 100.0f) goto L5;
            boolean r12 = true;
        L6:
            if (r12 == false) goto L9;
            this.a.p();
            return;
        L9:
            return;
        L5:
            r12 = false;
            goto L6
        }
    }

    public final class d {
        public long a;
        public boolean b;
        public j c;
        public final /* synthetic */ PhotoFeedPagerPresenter d;

        public final void a() {
            if (this.d.r() == true) goto L5;
            return;
        L5:
            if (this.b == false) goto L8;
            return;
        L8:
            if (this.d.J == false) goto L10;
            return;
        L10:
            this.b = true;
            long r0 = this.a;
            j r2 = new j(this, this.d, r0);
            this.c = r2;
            r2.start();
        }

        public final void b() {
            if (this.d.r() == true) goto L5;
            return;
        L5:
            if (this.b == false) goto L12;
            this.b = false;
            j r0 = this.c;
            if (r0 == null) goto L9;
            r0.cancel();
        L9:
            this.c = null;
            return;
        }

        public d(PhotoFeedPagerPresenter r3) {
            this.d = r3;
            this.a = 4000;
        }
    }

    public /* synthetic */ class e {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Lifecycle.Event.values().length];
            r0[Lifecycle.Event.ON_RESUME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[Lifecycle.Event.ON_PAUSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void setImageGestureListener(nz3.b r1) {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.b getCurrentViewHolder() {
        int r0 = this.j.getCurrentItem();
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.a r1 = this.A;
        if (r1 == null) goto L14;
        PhotoModel r2 = r1.n();
        SlidesPhotosPageAdapter r3 = this.n;
        List<PhotoModel> r4 = r3.d;
        if (((ArrayList) r4).size() <= 0) goto L7;
        int r5 = r0 % ((ArrayList) r3.d).size();
    L9:
        if (Intrinsics.areEqual(r2, (PhotoModel) CollectionsKt.getOrNull(r4, r5)) == false) goto L14;
        if (r0 != this.v) goto L14;
        return this.A;
    L7:
        r5 = r0;
    L14:
        int r6 = this.j.getChildCount();
        int r7 = 0;
    L15:
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.a r8 = null;
        if (r7 >= r6) goto L34;
        View r9 = this.j.getChildAt(r7);
        if (r9 == null) goto L20;
        Object r10 = r9.getTag(2131367557);
    L22:
        if ((r10 instanceof com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.a) == false) goto L24;
        r8 = (com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.a) r10;
    L24:
        if (r8 == null) goto L33;
        PhotoModel r11 = r8.n();
        SlidesPhotosPageAdapter r12 = this.n;
        List<PhotoModel> r13 = r12.d;
        if (((ArrayList) r13).size() <= 0) goto L28;
        int r14 = r0 % ((ArrayList) r12.d).size();
    L30:
        if (Intrinsics.areEqual(r11, (PhotoModel) CollectionsKt.getOrNull(r13, r14)) == false) goto L33;
        this.A = r8;
        return r8;
    L28:
        r14 = r0;
    L33:
        r7 = r7 + 1;
        goto L15
    L20:
        r10 = null;
        goto L22
    L34:
        return null;
    }

    @Override // g04.a
    public final void i() {
        PhotoFeedPagerPresenter r0 = this;
        pauseLoop();
        int r1 = 0;
        r0.J = false;
        d r2 = r0.K;
        if (r2.d.r() == false) goto L5;
        r2.b();
        r2.a = 4000;
    L5:
        AosEventReporter r3 = AosEventReporter.a;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r4 = r0.e;
        jz3.a r6 = r0.s;
        AosUserProfileFeedFragmentViewModel r7 = null;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mData");
        r6 = null;
    L8:
        p r8 = r0.h;
        int r9 = r0.I.size();
        int r10 = o();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "feedGroupParameters");
        Intrinsics.checkNotNullParameter(r6, "data");
        Intrinsics.checkNotNullParameter(r8, "eventRecorder");
        String r12 = r4.c.sceneId();
        long r25 = r8.a();
        if (r10 != 0) goto L12;
        AoNpthService r5 = AoExceptionReporter.a;
        AoExceptionReporter.b(ErrorPriority.p0, AosEventReporter.b, "reportPictureVideoOver", "picCount=0", 16);
    L37:
        com.bytedance.awemeopen.apps.framework.utils.audio.a r11 = iz3.a.a(r0.e);
        if (r11 == null) goto L41;
        TypeIntrinsics.asMutableCollection(r11.c).remove(r0.Q);
        return;
    L41:
        return;
    L12:
        if (r10 == 1) goto L14;
        if (r9 < r10) goto L18;
    L17:
        r1 = 1;
    L18:
        double r13 = Math.min(Math.round((r9 / r10) * 100), 100.0f);
        int r14 = r8.c;
        if (Intrinsics.areEqual(r12, "others_homepage") == false) goto L25;
        com.bytedance.awemeopen.apps.framework.framework.viewpager.o r15 = r4.c;
        if ((r15 instanceof AosUserProfileFeedFragmentViewModel) == false) goto L23;
        r7 = (AosUserProfileFeedFragmentViewModel) r15;
    L23:
        if (r7 == null) goto L25;
        String r17 = r7.getFromGroupId();
    L26:
        FeedPageConfig r16 = r4.c.getPageConfig();
        d14.a r18 = b14.a.a;
        t24.a r19 = b14.a.a(t24.a.class);
        String r20 = r16.getHostEnterFrom();
        String r110 = r6.a.c();
        String r111 = AosEventReporter.b(r6.a, r16);
        if (r111 != null) goto L29;
        r111 = "";
        String r112 = r111;
    L30:
        a0 r113 = r6.a.d;
        if (r113 == null) goto L36;
        String r114 = r113.a();
        if (r114 == null) goto L36;
        r112 = r114;
    L36:
        String r115 = GsonProtectorUtils.toJson(GsonHolder.a(), r6.a.d);
        boolean r116 = AosEventReporter.e(r6.a);
        boolean r21 = r16.isCardMode();
        boolean r22 = r8.b;
        r14.c r23 = r6.a;
        r19.i2(r12, r20, r110, r111, r112, r17, r115, r116, r6.a.i(), r21, r13, r1, r25, null, r14, r22, r23.t, Integer.valueOf(r9), Integer.valueOf(r10), r23.r().a, r16.getHostExtraParams(), new HostCommonParamProvider(r16.getHostCommonParams()));
        r0 = this;
        goto L37
    L29:
        r112 = "";
    L25:
        r17 = "";
        goto L26
    L14:
        if (r25 <= 4000) goto L18;
        goto L18
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void initialLoop() {
        q(this, this.v, 100.0f, 100.0f, 0, false, 24);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final boolean isLooping() {
        kz3.a r0 = this.B;
        if (r0.g == true) goto L5;
    L9:
        return false;
    L5:
        if (r0.h == true) goto L9;
        if (this.r == true) goto L9;
        return true;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final boolean isPaused() {
        return this.B.h;
    }

    public final void m() {
        this.j.setDisableScroll(!this.i.getDragEnabled());
        this.j.setDisableOutScroll(!this.i.getOutDragEnabled());
        this.y.b = (int) this.i.getScrollAnimationDuration();
        if (this.i.getShowProgressBar() == false) goto L7;
        x54.b.d(this.m);
        x54.b.d(this.k);
        this.m.post(new g(this));
        if (this.i.getEnableProgressBarSwitch() == false) goto L8;
        this.m.setClickEnabled(true);
        this.m.setOnProgressBarSelected(new PhotoFeedPagerPresenter$applySlidesPhotosConfig$2(this));
    L8:
        kz3.a r0 = this.B;
        long r1 = this.i.getPhotoPlayDuration();
        r0.b = r1;
        r0.d = (r0.c / r1) * 100.0f;
        kz3.a r2 = this.B;
        long r3 = this.i.getProgressInterval();
        r2.c = r3;
        r2.d = (r3 / r2.b) * 100.0f;
        if (this.i.getInitPlayPosition() <= 0) goto L14;
        if (this.j.getCurrentItem() == this.i.getInitPlayPosition()) goto L14;
        setCurrentPosition(this.i.getInitPlayPosition(), false, 0);
        this.v = this.i.getInitPlayPosition();
        this.w = this.i.getInitPlayPosition();
        return;
    L14:
        if (this.j.getCurrentItem() == 0) goto L18;
        setCurrentPosition(0, false, 0);
        return;
    L18:
        return;
    L7:
        x54.b.a(this.k);
        goto L8
    }

    public final int o() {
        return ((ArrayList) this.n.d).size();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void onDragByUser() {
        if (this.i.getStopByDrag() == true) goto L5;
        return;
    L5:
        if (this.r == true) goto L9;
        this.r = true;
        this.B.e();
        q(this, this.v, 100.0f, 100.0f, 0, this.r, 8);
        return;
    }

    public final void p() {
        nz3.f r0 = this.L;
        if (r0 == null) goto L5;
        r0.b(this.v);
    L5:
        int r1 = o();
        boolean r2 = true;
        int r3 = this.w + 1;
        if (this.p == true) goto L11;
        if (r1 <= 1) goto L11;
        nz3.f r4 = this.L;
        if (r4 == null) goto L12;
        r4.g();
    L12:
        if (r2 == true) goto L14;
        return;
    L14:
        if (r3 < 10000) goto L19;
        nz3.f r5 = this.L;
        if (r5 == null) goto L18;
        r5.h();
    L18:
        setCurrentPosition(0, false, 0);
        return;
    L19:
        if (r3 > 0) goto L21;
    L25:
        setCurrentPosition(r3, false, 0);
        return;
    L21:
        if ((r3 % r1) != 0) goto L25;
        if (this.d == false) goto L25;
        this.e.c.doAutoPlay();
    L11:
        r2 = false;
        goto L12
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void pauseLoop() {
        if (this.i.getShowProgressBar() == true) goto L5;
        return;
    L5:
        kz3.a r0 = this.B;
        if (r0.g == false) goto L9;
        r0.h = true;
        r0.k = 0;
        r0.a.removeMessages(10001);
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void restartLoop() {
        if (this.i.getShowProgressBar() == true) goto L5;
        return;
    L5:
        p();
        q(this, this.v, 0.0f, 0.0f, 0, false, 24);
        startLoop(false);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void resumeLoop() {
        if (this.i.getShowProgressBar() == true) goto L5;
        return;
    L5:
        this.B.b();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void stopLoop() {
        if (this.i.getShowProgressBar() == true) goto L5;
        return;
    L5:
        this.B.e();
    }

    public final void t() {
        if (this.i.getShowProgressBar() == true) goto L5;
        return;
    L5:
        if (this.B.g == true) goto L7;
        startLoop(false);
        return;
    L7:
        resumeLoop();
    }

    @Override // g04.a
    public final void g() {
        t();
        this.K.a();
        com.bytedance.awemeopen.apps.framework.utils.audio.a r0 = iz3.a.a(this.e);
        if (r0 == null) goto L10;
        a r1 = this.Q;
        if (r1 != null) goto L7;
        return;
    L7:
        if (((ArrayList) r0.c).contains(r1) == true) goto L12;
        ((ArrayList) r0.c).add(r1);
        return;
    L12:
        return;
    }

    @Override // g04.a
    public final void h() {
        stopLoop();
        this.m.e();
        SlidesPhotosPageAdapter r0 = this.n;
        Iterator<T> r1 = r0.e.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((com.bytedance.awemeopen.apps.framework.framework.viewpager.g) r1.next()).k();
        goto L4
    L6:
        r0.e.clear();
        this.t = null;
        this.r = false;
        this.A = null;
        this.G = "";
        this.H = "auto";
        this.I.clear();
        this.f.b.reset();
        this.e.c.getFeedHomeContainerSelectedIndex().removeObserver(this.D);
        this.g.getCancelLoop().removeObserver(this.E);
        this.g.getPreviewSelectedPhotoPosition().removeObserver(this.F);
    }

    public final boolean r() {
        if (o() <= 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final int getCurrentItem() {
        return this.w;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final int getCurrentPosition() {
        return this.v;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final View getProgressBar() {
        return this.m;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final boolean isStoppedByDrag() {
        return this.r;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void changeToFullPreview(boolean r3) {
        if (r3 == false) goto L9;
        this.f.b.setScaleType(ScaleType.FIT_CENTER);
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.b r0 = getCurrentViewHolder();
        if (r0 == null) goto L6;
        ((com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.d) r0).q();
    L6:
        int r1 = this.j.getCurrentItem();
        n(r1 - 1);
        n(r1 + 1);
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.b r2 = getCurrentViewHolder();
        if (r2 == null) goto L14;
        r2.b(r3);
        return;
    L14:
        return;
    L9:
        this.f.b.setScaleType(ScaleType.AUTO_MODE);
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.b r4 = getCurrentViewHolder();
        if (r4 == null) goto L12;
        ((com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.d) r4).q();
    L12:
        int r5 = this.j.getCurrentItem();
        n(r5 - 1);
        n(r5 + 1);
    }

    @Override // g04.a
    public final void f(jz3.a r3) {
        jz3.a r4 = r3;
        Intrinsics.checkNotNullParameter(r4, "data");
        this.s = r4;
        this.t = r4.a;
        this.u.clear();
        ArrayList<PhotoModel> r5 = this.u;
        int r0 = com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.l.a;
        r5.addAll(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.l.a(this.t));
        lz3.b r6 = this.f;
        r6.c = this.t;
        SlidesPhotosPageAdapter r7 = this.n;
        ArrayList<PhotoModel> r1 = this.u;
        ((ArrayList) r7.d).clear();
        if (r1 == null) goto L5;
        ((ArrayList) r7.d).addAll(r1);
    L5:
        r7.notifyDataSetChanged();
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.o r8 = this.x;
        r14.c r2 = this.t;
        if (r2 == null) goto L10;
        List r9 = r2.v();
        if (r9 == null) goto L10;
        int r10 = r9.size();
    L11:
        r8.a = r10;
        this.l.post(new h(this));
        if (r() == false) goto L14;
        this.i.singlePhotoConfig();
    L14:
        m();
        this.e.c.getFeedHomeContainerSelectedIndex().observe(this.e.e.d, this.D);
        this.g.getCancelLoop().observe(this.e.e.d, this.E);
        this.g.getPreviewSelectedPhotoPosition().observe(this.e.e.d, this.F);
        this.e.e.d.getLifecycle().addObserver(this.C);
        return;
    L10:
        r10 = 0;
        goto L11
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void handleProgressSwitch(boolean r5) {
        if (r5 == false) goto L5;
        setCurrentPosition(this.w + 1, false, 0);
    L8:
        onDragByUser();
        return;
    L5:
        int r6 = this.w;
        if (r6 < 1) goto L8;
        setCurrentPosition(r6 - 1, false, 0);
        goto L8
    }

    public final void n(int r3) {
        if (r3 >= 0) goto L4;
        return;
    L4:
        if (r3 >= this.j.getChildCount()) goto L18;
        View r4 = this.j.getChildAt(r3);
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.a r0 = null;
        if (r4 == null) goto L9;
        Object r5 = r4.getTag(2131367557);
    L11:
        if ((r5 instanceof com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.a) == false) goto L13;
        r0 = (com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.a) r5;
    L13:
        if (r0 == null) goto L17;
        ((com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.d) r0).q();
        return;
    L17:
        return;
    L9:
        r5 = null;
        goto L11
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        View.OnClickListener r0 = this.N;
        if (r0 == null) goto L6;
        r0.onClick(r2);
        return;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r2) {
        View.OnLongClickListener r0 = this.M;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.onLongClick(r2);
    }

    @Override // nz3.g
    public final boolean onTouchEvent(MotionEvent r2) {
        nz3.g r0 = this.P;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.onTouchEvent(r2);
    }

    public final void s(Map<String, Object> r4) {
        String r0 = this.e.c.sceneId();
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        r4.put("enter_from", r0);
        r14.c r2 = this.t;
        if (r2 == null) goto L9;
        String r3 = r2.c();
        if (r3 == null) goto L9;
    L10:
        r4.put("group_id", r3);
        r14.c r5 = this.t;
        if (r5 == null) goto L18;
        User r6 = r5.f();
        if (r6 == null) goto L18;
        String r7 = r6.u();
        if (r7 == null) goto L18;
        r1 = r7;
    L18:
        r4.put("author_id", r1);
        r4.put("enter_method", "click_screen");
        r14.c r8 = this.t;
        if (r8 == null) goto L21;
        int r9 = r8.q();
    L22:
        r4.put("item_duration", Integer.valueOf(r9));
        r4.put("pinch_zoom", Integer.valueOf(Intrinsics.areEqual(this.e.c.getEnterPinchMode().getValue(), Boolean.TRUE) ? 1 : 0));
        r4.put("pure_zoom", 0);
        return;
    L21:
        r9 = 0;
    L9:
        r3 = "";
        goto L10
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void seek(float r2) {
        if (this.i.getShowProgressBar() == true) goto L5;
        return;
    L5:
        this.B.c(r2);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void setClickListener(View.OnClickListener r1) {
        this.N = r1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void setLongClickListener(View.OnLongClickListener r1) {
        this.M = r1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void setOnSwipeListener(nz3.d r1) {
        this.O = r1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void setRefreshInFirstPosition(boolean r4) {
        this.q = r4;
        if (r4 == true) goto L5;
        return;
    L5:
        if (this.j.getCurrentItem() == 0) goto L7;
        setCurrentPosition(0, false, 300);
        return;
    L7:
        startLoop(false);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void setSlidesPhotosConfig(SlidesPhotosConfig r3) {
        Intrinsics.checkNotNullParameter(r3, "config");
        this.i = r3;
        lz3.b r0 = this.f;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r0.b = r3;
        m();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void setSlidesProgressCallback(nz3.f r1) {
        this.L = r1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void setTouchInterceptor(nz3.g r1) {
        this.P = r1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void startLoop(boolean r13) {
        if (this.i.getShowProgressBar() == true) goto L6;
        return;
    L6:
        if (r13 == false) goto L9;
        reset(0, 0);
    L9:
        if (this.i.getAutoPlayEnabled() == false) goto L11;
        this.r = false;
        kz3.a r14 = this.B;
        long r1 = this.i.getPhotoPlayDuration();
        int r3 = kz3.a.l;
        r14.d(true, r1, false);
        return;
    L11:
        q(this, this.v, 100.0f, 100.0f, 0, false, 24);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void reset(int r3, long r4) {
        stopLoop();
        int r0 = this.j.getCurrentItem();
        if (o() <= 0) goto L6;
        r0 = r0 % o();
    L6:
        if (r0 == r3) goto L8;
        setCurrentPosition(r3, false, r4);
    L8:
        this.y.a.a = 0;
        this.m.f(r3);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void setCurrentPositionFullProgress(int r10, boolean r11) {
        this.y.a(r11);
        this.j.w(r10, r11);
        q(this, r10, 100.0f, 100.0f, 0, this.r, 8);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void setCurrentPosition(final int r4, final boolean r5, long r6) {
        this.y.a(r5);
        if (r6 <= 0) goto L5;
        this.j.postDelayed(new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.photo.e(this, r4, r5), r6);
        return;
    L5:
        this.j.w(r4, r5);
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
    public PhotoFeedPagerPresenter(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r9, lz3.b r10, PhotoFeedPagerViewModel r11, p r12) {
        Intrinsics.checkNotNullParameter(r9, "feedGroupParameters");
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "photoVM");
        Intrinsics.checkNotNullParameter(r12, "eventRecorder");
        super(r9.a);
        this.e = r9;
        this.f = r10;
        this.g = r11;
        this.h = r12;
        this.i = r10.b;
        this.j = (SlidesPhotosViewPager) e(2131382259);
        this.k = e(2131383301);
        View r13 = e(2131383298);
        this.l = r13;
        StoryListProgressBar r14 = (StoryListProgressBar) e(2131383297);
        r14.setMaskView(r13);
        this.m = r14;
        Context r15 = getContext();
        r10.getClass();
        r10.a = this;
        Unit r16 = Unit.INSTANCE;
        this.n = new SlidesPhotosPageAdapter(r15, r10);
        this.o = true;
        this.u = new ArrayList();
        this.x = new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.o();
        this.y = new mz3.m(getContext());
        this.z = new PhotoPageChangeListener(this);
        c r17 = new c(this);
        kz3.a r18 = new kz3.a();
        Intrinsics.checkNotNullParameter(r17, "callback");
        r18.f = r17;
        this.B = r18;
        this.E = new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.photo.a(this);
        this.F = new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.photo.b(this);
        this.G = "";
        this.H = "auto";
        this.I = new LinkedHashSet();
        this.K = new d(this);
        this.R = j64.a.a(AoCommonMonitorService.class);
        this.S = new Handler(Looper.getMainLooper());
        this.C = new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.photo.c(this);
        this.D = new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.photo.d(this);
        this.a.setBackgroundColor(ContextCompat.getColor(getContext(), 2131100268));
        int r19 = b0.a;
        Context r110 = getContext();
        boolean r111 = false;
        if (r110 != null) goto L5;
    L76:
        if (r111 == false) goto L78;
        this.j.addOnLayoutChangeListener(new i(this));
    L78:
        SlidesPhotosViewPager r112 = this.j;
        r112.setAdapter(this.n);
        r112.b(this.z);
        mz3.m r113 = this.y;
        r113.getClass();
        Intrinsics.checkNotNullParameter(r112, "pager");
        Field r114 = ViewPager.class.getDeclaredField("mScroller");     // Catch: Exception -> L81
        r114.setAccessible(true);     // Catch: Exception -> L81
        r114.set(r112, r113);     // Catch: Exception -> L81
    L83:
        r112.setSwipeOutListener(new k(this));
        r112.setScrollListener(new l(this));
        r112.setScrollInterceptor(new m(this));
        r112.setISlidesPhotosViewPagerInterceptor(new n(this));
        this.Q = new a(this);
        return;
    L81:
        e = move-exception;
        e.printStackTrace();
        goto L83
    L5:
        if (r110.getResources() == null) goto L76;
        if (r110.getResources().getConfiguration() == null) goto L76;
        Map<String, String> r1 = b0.b;
        monitor-enter(r1);
        ?? r2 = ((HashMap) r1).get("ro.build.characteristics");     // Catch: Throwable -> L73
        String r3 = (String) r2;     // Catch: Throwable -> L73
        if (r3 != null) goto L14;
    L19:
        boolean r4 = false;
    L20:
        if (r4 == true) goto L97;
    L65:
        Unit r115 = Unit.INSTANCE;     // Catch: Throwable -> L73
        monitor-exit(r1);
        String r5 = (String) r2;
        if (TextUtils.isEmpty(r5) == false) goto L70;
    L71:
        r5 = "phone";
    L72:
        r111 = Intrinsics.areEqual("tablet", r5);
        goto L76
    L70:
        if (Intrinsics.areEqual(r5, "tablet") == true) goto L72;
    L97:
        SharedPreferences r116 = r110.getSharedPreferences("system_properties_cache", 0);     // Catch: Exception -> L63 Throwable -> L73
        BufferedReader r6 = null;
        r2 = r116.getString("ro.build.characteristics", null);     // Catch: Exception -> L63 Throwable -> L73
        if (r2 != 0) goto L24;
    L29:
        boolean r7 = false;
    L93:
        if (r7 == false) goto L65;
        r2 = i0.a();     // Catch: Throwable -> L33
    L48:
        if (r2 != 0) goto L50;
    L55:
        if (r111 == false) goto L65;
        ?? r117 = r116.edit();     // Catch: Exception -> L63 Throwable -> L73
        r117.putString("ro.build.characteristics", r2);     // Catch: Exception -> L63 Throwable -> L73
        r117.apply();     // Catch: Exception -> L63 Throwable -> L73
        goto L65
    L50:
        if (r2.length() <= 0) goto L52;
        boolean r8 = true;
    L53:
        if (r8 != true) goto L55;
        r111 = true;
        goto L55
    L52:
        r8 = false;
    L33:
        BufferedReader r20 = new BufferedReader(new InputStreamReader(com.bytedance.awemeopen.apps.framework.utils.m.a(Runtime.getRuntime(), "getprop ro.build.characteristics").getInputStream(), "UTF-8"), 1024);     // Catch: Throwable -> L39 IOException -> L41
        String r21 = r20.readLine();     // Catch: IOException -> L85 Throwable -> L58
        r20.close();     // Catch: IOException -> L85 Throwable -> L58
        r20.close();     // Catch: IOException -> L37 Exception -> L63 Throwable -> L73
    L38:
        r6 = r21;
    L47:
        r2 = r6;
    L43:
        if (r20 == null) goto L47;
        r20.close();     // Catch: IOException -> L46 Exception -> L63 Throwable -> L73
        goto L47
    L41:
        r20 = null;
    L39:
        th = th;
    L60:
        if (r6 != null) goto L89;
    L62:
        throw th;     // Catch: Exception -> L63 Throwable -> L73
    L89:
        r6.close();     // Catch: IOException -> L86 Exception -> L63 Throwable -> L73
    L58:
        th = th;
        r6 = r20;
        goto L60
    L24:
        if (r2.length() != 0) goto L26;
        boolean r22 = true;
    L27:
        if (r22 != true) goto L29;
        r7 = true;
        goto L93
    L26:
        r22 = false;
    L63:
        e = move-exception;
        e.toString();     // Catch: Throwable -> L73
        goto L65
    L14:
        if (r3.length() != 0) goto L16;
        boolean r23 = true;
    L17:
        if (r23 != true) goto L19;
        r4 = true;
        goto L20
    L16:
        r23 = false;
    L73:
        th = move-exception;
        throw th;
    }

    public static void q(PhotoFeedPagerPresenter r6, int r7, float r8, float r9, long r10, boolean r12, int r13) {
        if ((r13 & 8) == 0) goto L5;
        r10 = 300;
    L5:
        long r3 = r10;
        if ((r13 & 16) == 0) goto L9;
        r12 = false;
    L9:
        if (r6.i.getShowProgressBar() == true) goto L11;
    L15:
        nz3.f r11 = r6.L;
        if (r11 == null) goto L19;
        r11.c(r7, r8, r12);
        return;
    L19:
        return;
    L11:
        if (r6.i.getAutoPlayEnabled() == false) goto L14;
        if (r12 == true) goto L14;
        StoryListProgressBar.g(r6.m, r7, r9 / 100.0f, r3, 8);
    L14:
        r6.m.h(r7, r9 / 100.0f);
        goto L15
    }
}
