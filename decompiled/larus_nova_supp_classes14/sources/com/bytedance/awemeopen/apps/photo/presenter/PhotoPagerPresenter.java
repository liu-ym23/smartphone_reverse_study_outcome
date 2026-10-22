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
import androidx.appcompat.widget.AppCompatTextView;
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
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
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
    public String J;
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
    public final a14.a d;
    public final lz3.b e;
    public final PhotoFeedPagerViewModel f;
    public SlidesPhotosConfig g;
    public final Lazy h;
    public final FrameLayout i;
    public final SlidesPhotosViewPager j;
    public final View k;
    public final View l;
    public final StoryListProgressBar m;
    public final MentionTextView n;
    public final MentionTextView o;
    public final MentionTextView p;
    public final LinearLayout q;
    public final ImageView r;
    public final MentionTextView s;
    public final SlidesPhotosLimitPageAdapter t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public r14.c y;
    public final ArrayList<PhotoModel> z;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/awemeopen/apps/photo/presenter/PhotoPagerPresenter$PhotoPageChangeListener;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "ao_apps_photo_release"}, k = 1, mv = {1, 7, 1})
    public final class PhotoPageChangeListener implements ViewPager.OnPageChangeListener {
        public final /* synthetic */ PhotoPagerPresenter a;

        public PhotoPageChangeListener(PhotoPagerPresenter r1) {
            this.a = r1;
        }

        public final void onPageScrollStateChanged(int r5) {
            AoLogger.g("fps_log", new Object[]{"onPageScrollStateChanged state = " + r5});
            if (r5 == 0) goto L7;
            AoCommonMonitorService r1 = this.a.U;
            if (r1 == null) goto L7;
            r1.S();
        L7:
            if (r5 == 0) goto L11;
            if (r5 != 1) goto L14;
            PhotoPagerPresenter r6 = this.a;
            r6.K = "manual_click";
            r6.D.a(false);
            this.a.v = true;
            return;
        L14:
            return;
        L11:
            this.a.D.a(false);
            PhotoPagerPresenter r7 = this.a;
            r7.D.a.a = 0;
            r7.v = false;
        }

        public final void onPageSelected(final int r21) {
            long r1 = System.currentTimeMillis();
            Map<Integer, Map<Integer, c04.f>> r3 = c04.e.a;
            c04.e.a(this.a.e.hashCode(), r21).d = r1;
            int r10 = 0;
            AoLogger.g("fps_log", new Object[]{"onPageSelected position = " + r21});
            AoCommonMonitorService r4 = this.a.U;
            if (r4 == null) goto L5;
            r4.N1();
        L5:
            PhotoPagerPresenter r5 = this.a;
            int r6 = r5.B;
            if (r21 <= r6) goto L8;
            String r7 = "slide_left";
        L9:
            r5.J = r7;
            if (r21 == r6) goto L12;
            c04.e.a(r5.e.hashCode(), this.a.B).e = r1;
            PhotoPagerPresenter r2 = this.a;
            r2.s(r2.B);
        L12:
            PhotoPagerPresenter r8 = this.a;
            r8.B = r21;
            if (r8.o() <= 0) goto L15;
            int r9 = r21 % r8.o();
        L16:
            r8.A = r9;
            r8.f.updateCurrentPosition(r9);
            PhotoPagerPresenter r11 = this.a;
            com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.o r12 = r11.C;
            if (r11.A != (r12.a - 1)) goto L19;
            r12.b = System.currentTimeMillis();
        L20:
            PhotoPagerPresenter r13 = this.a;
            SlidesPhotosViewPager r14 = r13.j;
            int r15 = r13.A;
            r14.c r16 = r13.y;
            if (r16 == null) goto L25;
            List r17 = r16.v();
            if (r17 == null) goto L25;
            int r18 = r17.size();
        L27:
            if (r15 != (r18 - 1)) goto L29;
            boolean r19 = true;
        L30:
            r14.H1 = r19;
            if (this.a.g.getStopByDrag() == false) goto L36;
            PhotoPagerPresenter r20 = this.a;
            if (r20.v == false) goto L36;
            r20.x = true;
        L36:
            if (this.a.g.getAutoPlayEnabled() == true) goto L38;
        L40:
            boolean r22 = false;
        L41:
            if (r22 == false) goto L57;
            PhotoPagerPresenter r23 = this.a;
            kz3.a r24 = r23.F;
            if (r24.g == false) goto L45;
        L46:
            r23.w = false;
            if (r24.h == false) goto L50;
            r24.a();
            PhotoPagerPresenter r110 = this.a;
            PhotoPagerPresenter.q(r110, r110.A, 0.0f, 0.0f, 0, false, 24);
        L62:
            final PhotoPagerPresenter r25 = this.a;
            if (r25.u == true) goto L82;
            kz3.a r26 = r25.F;
            if (r26.g == true) goto L67;
        L69:
            final String r27 = r25.K;
            final String r28 = r25.J;
            final int r29 = r25.o();
            final r14.c r30 = r25.y;
            if (r30 == null) goto L72;
            r25.V.postDelayed(new e0(r25, r30, r27, r28, r21, r29), 10);
        L72:
            PhotoPagerPresenter r31 = this.a;
            if (r31.A != (r31.o() - 1)) goto L82;
            if (this.a.o() > 1) goto L77;
            boolean r32 = true;
        L78:
            if (r32 == true) goto L82;
            PhotoPagerPresenter r33 = this.a;
            if (r33.M == true) goto L82;
            r33.M = true;
            goto L82
        L77:
            r32 = false;
            goto L78
        L67:
            if (r26.h == true) goto L69;
            r25.K = "auto";
        L82:
            PhotoPagerPresenter r34 = this.a;
            r34.L.add(Integer.valueOf(r34.A));
            PhotoPagerPresenter r35 = this.a;
            r35.u = false;
            AosPictureDetailConfig r36 = r35.d.c.getPageConfig();
            if (r36 == null) goto L85;
            r10 = r36.getImageDiskCacheCount();
        L85:
            if (r10 <= 0) goto L115;
            AosPictureDetailConfig r37 = r35.d.c.getPageConfig();
            if (r37 == null) goto L90;
            int r38 = r37.getOffscreenPageLimit();
        L91:
            int r39 = r35.W;
            if (r39 != (-1)) goto L99;
            int r40 = r38 + r21;
            int r41 = Math.min((r10 + r40) + 1, r35.z.size());
        L94:
            r40 = r40 + 1;
            if (r40 >= r41) goto L116;
            if (r35.r(r40) == false) goto L94;
            r35.W = r40;
            goto L94
        L116:
            return;
        L99:
            int r42 = (r38 + r21) + r10;
            if (r39 < r42) goto L102;
            return;
        L102:
            if (r42 < r35.z.size()) goto L104;
            return;
        L104:
            if (r35.r(r42) == false) goto L114;
            r35.W = r42;
            return;
        L114:
            return;
        L90:
            r38 = 3;
            goto L91
        L115:
            return;
        L50:
            if (r23.A != 0) goto L52;
        L55:
            long r43 = r23.g.getPhotoPlayDuration();
        L56:
            PhotoPagerPresenter r44 = this.a;
            r44.x = false;
            r44.F.d(true, r43, true);
            goto L62
        L52:
            if (r23.v == true) goto L55;
            r43 = r23.g.getPhotoPlayDuration() + this.a.g.getScrollAnimationDuration();
            goto L56
        L45:
            if (r23.w == true) goto L46;
        L57:
            if (r22 == true) goto L62;
            PhotoPagerPresenter r45 = this.a;
            if (r45.x == false) goto L61;
            r45.F.e();
        L61:
            PhotoPagerPresenter r111 = this.a;
            PhotoPagerPresenter.q(r111, r111.A, 100.0f, 100.0f, 0, r111.x, 8);
            goto L62
        L38:
            if (this.a.x == true) goto L40;
            r22 = true;
            goto L41
        L29:
            r19 = false;
        L25:
            r18 = 0;
            goto L27
        L19:
            r12.b = -1;
            goto L20
        L15:
            r9 = r21;
            goto L16
        L8:
            r7 = PinchStableView.Gesture.SLIDE_RIGHT;
            goto L9
        }

        public final void onPageScrolled(int r2, float r3, int r4) {
            PhotoPagerPresenter r5 = this.a;
            int r0 = PhotoPagerPresenter.X;
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
            if (this.a.u == false) goto L18;
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

    public static final class a {
    }

    public final class b implements kz3.a.InterfaceC0142a {
        public final /* synthetic */ PhotoPagerPresenter a;

        @Override // kz3.a.InterfaceC0142a
        public final boolean a() {
            if (this.a.g.getAutoPlayEnabled() == false) goto L9;
            nz3.f r0 = this.a.N;
            if (r0 == null) goto L11;
            r0.a();
            return true;
        L11:
            return true;
        L9:
            return false;
        }

        public b(PhotoPagerPresenter r1) {
            this.a = r1;
        }

        @Override // kz3.a.InterfaceC0142a
        public final void b(float r9, float r10, long r11) {
            PhotoPagerPresenter r0 = this.a;
            PhotoPagerPresenter.q(r0, r0.A, r9, r10, r11, false, 16);
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

    public /* synthetic */ class c {
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
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.a r1 = this.E;
        if (r1 == null) goto L14;
        PhotoModel r2 = r1.n();
        SlidesPhotosLimitPageAdapter r3 = this.t;
        List<PhotoModel> r4 = r3.d;
        if (((ArrayList) r4).size() <= 0) goto L7;
        int r5 = r0 % ((ArrayList) r3.d).size();
    L9:
        if (Intrinsics.areEqual(r2, (PhotoModel) CollectionsKt.getOrNull(r4, r5)) == false) goto L14;
        if (r0 != this.A) goto L14;
        return this.E;
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
        SlidesPhotosLimitPageAdapter r12 = this.t;
        List<PhotoModel> r13 = r12.d;
        if (((ArrayList) r13).size() <= 0) goto L28;
        int r14 = r0 % ((ArrayList) r12.d).size();
    L30:
        if (Intrinsics.areEqual(r11, (PhotoModel) CollectionsKt.getOrNull(r13, r14)) == false) goto L33;
        this.E = r8;
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

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void initialLoop() {
        q(this, this.A, 100.0f, 100.0f, 0, false, 24);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final boolean isLooping() {
        kz3.a r0 = this.F;
        if (r0.g == true) goto L5;
    L9:
        return false;
    L5:
        if (r0.h == true) goto L9;
        if (this.x == true) goto L9;
        return true;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final boolean isPaused() {
        return this.F.h;
    }

    public final void m() {
        this.j.setDisableScroll(!this.g.getDragEnabled());
        this.j.setDisableOutScroll(!this.g.getOutDragEnabled());
        this.D.b = (int) this.g.getScrollAnimationDuration();
        if (this.g.getShowProgressBar() == false) goto L7;
        x54.b.d(this.m);
        x54.b.d(this.k);
        this.m.post(new d0(this));
        if (this.g.getEnableProgressBarSwitch() == false) goto L8;
        this.m.setClickEnabled(true);
        this.m.setOnProgressBarSelected(new PhotoPagerPresenter$applySlidesPhotosConfig$2(this));
    L8:
        kz3.a r0 = this.F;
        long r1 = this.g.getPhotoPlayDuration();
        r0.b = r1;
        r0.d = (r0.c / r1) * 100.0f;
        kz3.a r2 = this.F;
        long r3 = this.g.getProgressInterval();
        r2.c = r3;
        r2.d = (r3 / r2.b) * 100.0f;
        if (this.g.getInitPlayPosition() <= 0) goto L14;
        if (this.j.getCurrentItem() == this.g.getInitPlayPosition()) goto L14;
        setCurrentPosition(this.g.getInitPlayPosition(), false, 0);
        int r4 = this.g.getInitPlayPosition();
        this.A = r4;
        this.f.updateCurrentPosition(r4);
        this.B = this.g.getInitPlayPosition();
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
        return ((ArrayList) this.t.d).size();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void onDragByUser() {
        if (this.g.getStopByDrag() == true) goto L5;
        return;
    L5:
        if (this.x == true) goto L9;
        this.x = true;
        this.F.e();
        q(this, this.A, 100.0f, 100.0f, 0, this.x, 8);
        return;
    }

    public final void p() {
        nz3.f r0 = this.N;
        if (r0 == null) goto L5;
        r0.b(this.A);
    L5:
        int r1 = o();
        boolean r2 = true;
        int r3 = this.B + 1;
        if (this.v == true) goto L11;
        if (r1 <= 1) goto L11;
        nz3.f r4 = this.N;
        if (r4 == null) goto L12;
        r4.g();
    L12:
        if (r2 == true) goto L14;
        return;
    L14:
        if (r3 < 10000) goto L19;
        nz3.f r5 = this.N;
        if (r5 == null) goto L18;
        r5.h();
    L18:
        setCurrentPosition(0, false, 0);
        return;
    L19:
        setCurrentPosition(r3, false, 0);
        return;
    L11:
        r2 = false;
        goto L12
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void pauseLoop() {
        if (this.g.getShowProgressBar() == true) goto L5;
        return;
    L5:
        kz3.a r0 = this.F;
        if (r0.g == false) goto L9;
        r0.h = true;
        r0.k = 0;
        r0.a.removeMessages(10001);
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void restartLoop() {
        if (this.g.getShowProgressBar() == true) goto L5;
        return;
    L5:
        p();
        q(this, this.A, 0.0f, 0.0f, 0, false, 24);
        startLoop(false);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void resumeLoop() {
        if (this.g.getShowProgressBar() == true) goto L5;
        return;
    L5:
        this.F.b();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void stopLoop() {
        if (this.g.getShowProgressBar() == true) goto L5;
        return;
    L5:
        this.F.e();
    }

    @Override // f04.a
    public final void k() {
        stopLoop();
        this.m.e();
        SlidesPhotosLimitPageAdapter r0 = this.t;
        Iterator<T> r1 = r0.e.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((com.bytedance.awemeopen.apps.framework.framework.viewpager.g) r1.next()).k();
        goto L4
    L6:
        r0.e.clear();
        this.y = null;
        this.x = false;
        this.E = null;
        this.J = "";
        this.K = "auto";
        this.L.clear();
        this.e.b.reset();
        this.f.getCancelLoop().removeObserver(this.H);
        this.f.getPreviewSelectedPhotoPosition().removeObserver(this.I);
        Map<Integer, Map<Integer, c04.f>> r2 = c04.e.a;
        int r3 = this.e.hashCode();
        Map<Integer, c04.f> r4 = c04.e.a.remove(Integer.valueOf(r3));
        if (r4 == null) goto L11;
        r4.clear();
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
        return this.m;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final boolean isStoppedByDrag() {
        return this.x;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void changeToFullPreview(boolean r3) {
        if (r3 == false) goto L9;
        this.e.b.setScaleType(ScaleType.FIT_CENTER);
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
        this.e.b.setScaleType(ScaleType.AUTO_MODE);
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.b r4 = getCurrentViewHolder();
        if (r4 == null) goto L12;
        ((com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.d) r4).q();
    L12:
        int r5 = this.j.getCurrentItem();
        n(r5 - 1);
        n(r5 + 1);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void handleProgressSwitch(boolean r5) {
        if (r5 == false) goto L5;
        setCurrentPosition(this.B + 1, false, 0);
    L8:
        onDragByUser();
        return;
    L5:
        int r6 = this.B;
        if (r6 < 1) goto L8;
        setCurrentPosition(r6 - 1, false, 0);
        goto L8
    }

    /* JADX WARN: Type inference failed for: r0v28, types: [android.widget.TextView, com.bytedance.awemeopen.apps.framework.feed.desc.MentionTextView] */
    /* JADX WARN: Type inference failed for: r0v61 */
    /* JADX WARN: Type inference failed for: r0v65 */
    @Override // f04.a
    public final void j(Unit r20) {
        Intrinsics.checkNotNullParameter(r20, "data");
        this.y = this.d.a;
        this.z.clear();
        ArrayList<PhotoModel> r0 = this.z;
        int r2 = com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.l.a;
        r0.addAll(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.l.a(this.y));
        this.e.c = this.y;
        Size r1 = this.S.a(this.d.a, getContext());
        this.T = r1;
        FrameLayout r3 = this.i;
        int r4 = r1.getHeight();
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r4 < 0) goto L9;
        ViewGroup.LayoutParams r5 = r3.getLayoutParams();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        if (r4 < 0) goto L8;
        r5.height = r4;
    L8:
        r3.setLayoutParams(r5);
    L9:
        this.t.c.b.setHeight(this.T.getHeight());
        this.t.c.b.setWidth(this.T.getWidth());
        this.t.c.b.setScaleType(ScaleType.ALWAYS_FIT_WIDTH);
        SlidesPhotosLimitPageAdapter r6 = this.t;
        ArrayList<PhotoModel> r7 = this.z;
        ((ArrayList) r6.d).clear();
        if (r7 == null) goto L12;
        ((ArrayList) r6.d).addAll(r7);
    L12:
        r6.notifyDataSetChanged();
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.o r8 = this.C;
        r14.c r9 = this.y;
        if (r9 == null) goto L17;
        List r10 = r9.v();
        if (r10 == null) goto L17;
        int r11 = r10.size();
    L18:
        r8.a = r11;
        boolean r12 = true;
        if (o() > 1) goto L21;
        boolean r13 = true;
    L22:
        if (r13 == false) goto L25;
        this.g.singlePhotoConfig();
    L25:
        if (com.bytedance.awemeopen.apps.framework.feed.ui.information.a.m == false) goto L27;
        this.g.setDragEnabled(true);
    L27:
        m();
        AppCompatTextView r14 = this.n;
        int r15 = com.bytedance.awemeopen.apps.photo.utils.d.a;
        r14.c r16 = this.d.a;
        if (r16 == null) goto L30;
        String r17 = r16.p();
    L31:
        CharSequence r18 = "";
        if (TextUtils.isEmpty(r17) == true) goto L43;
        TextExtraStruct r19 = com.bytedance.awemeopen.apps.photo.utils.d.a(r16);
        if (r19 == null) goto L43;
        if (r16 == null) goto L41;
        String r21 = r16.p();
        if (r21 == null) goto L41;
        CharSequence r22 = r21.subSequence(r19.getStart(), r19.getEnd());
    L42:
        r18 = String.valueOf(r22);
    L41:
        r22 = null;
    L43:
        Intrinsics.checkNotNullParameter(r14, "textView");
        if (StringsKt.isBlank(r18) == false) goto L46;
        r14.setVisibility(8);
    L47:
        AppCompatTextView r23 = this.o;
        r14.c r24 = this.d.a;
        if (r24 == null) goto L50;
        String r25 = r24.p();
    L51:
        CharSequence r26 = "";
        if (TextUtils.isEmpty(r25) == true) goto L108;
        TextExtraStruct r27 = com.bytedance.awemeopen.apps.photo.utils.d.a(r24);
        if (r27 != null) goto L61;
        if (r24 == null) goto L108;
        CharSequence r28 = r24.p();
        if (r28 == null) goto L108;
    L60:
        r26 = r28;
        goto L108
    L61:
        if (r24 == null) goto L63;
        String r29 = r24.p();
    L65:
        if (TextUtils.isEmpty(r29) == true) goto L98;
        if (r24 == null) goto L87;
        List r30 = r24.N();
        if (r30 == null) goto L87;
        ArrayList r110 = new ArrayList();
        Iterator r31 = r30.iterator();
    L72:
        if (r31.hasNext() == false) goto L76;
        TextExtraStruct r111 = (TextExtraStruct) r31.next();
        if (r111 == null) goto L72;
        r110.add(r111);
        goto L72
    L76:
        Iterator r32 = r110.iterator();
    L78:
        if (r32.hasNext() == false) goto L85;
        Object r112 = r32.next();
        if (((TextExtraStruct) r112).getType() != 8) goto L82;
        boolean r113 = true;
    L83:
        if (r113 == false) goto L78;
    L86:
        TextExtraStruct r114 = (TextExtraStruct) r112;
    L88:
        if (r114 == null) goto L98;
        if (r114.getStart() >= r114.getEnd()) goto L98;
        int r33 = r114.getEnd();
        String r115 = r24.p();
        if (r115 != null) goto L95;
        r115 = "";
    L95:
        if (r33 > r115.length()) goto L98;
        if (r114.getStart() < 0) goto L98;
    L99:
        if (r114 == null) goto L101;
        int r34 = r114.getEnd();
    L103:
        if (r24 == null) goto L108;
        String r35 = r24.p();
        if (r35 == null) goto L108;
        r28 = r35.subSequence(r34, r35.length()).toString();
        if (r28 != null) goto L60;
    L101:
        r34 = r27.getEnd();
        goto L103
    L82:
        r113 = false;
        goto L83
    L85:
        r112 = null;
    L87:
        r114 = null;
    L98:
        r114 = null;
        goto L99
    L63:
        r29 = null;
    L108:
        Intrinsics.checkNotNullParameter(r23, "textView");
        if (StringsKt.isBlank(r26) == false) goto L111;
        r23.setVisibility(8);
    L112:
        MentionTextView r36 = this.o;
        boolean r37 = r36 instanceof MentionTextView;
        ?? r38 = r36;
        if (r37 == true) goto L116;
        r38 = 0;
    L116:
        if (r38 == 0) goto L118;
        r38.setSpanSize(r38.getTextSize());
    L118:
        int r39 = Build.VERSION.SDK_INT;
        if (r39 >= 23) goto L121;
    L123:
        AppCompatTextView r40 = this.p;
        Activity r41 = this.d.getActivity();
        long r42 = TimeUnit.SECONDS.toMillis(this.d.a.o());
        SimpleDateFormat r43 = com.bytedance.awemeopen.apps.framework.utils.k0.a;
        long r44 = Calendar.getInstance().getTimeInMillis() - r42;
        if (r44 >= 60000) goto L127;
        CharSequence r45 = r41.getString(2131894212);
    L160:
        r40.setText(r45);
        int r46 = com.bytedance.awemeopen.apps.photo.utils.d.a;
        r14.c r47 = this.d.a;
        String r48 = "";
        if (r47 == null) goto L188;
        r14.i r49 = r47.h();
        if (r49 != null) goto L166;
    L168:
        boolean r50 = false;
    L169:
        if (r50 == false) goto L188;
        r14.i r51 = r47.h();
        if (r51 != null) goto L173;
    L175:
        r12 = false;
    L176:
        if (r12 == false) goto L188;
        if (r47.G() != ModelRate.NotRecommended) goto L180;
    L181:
        r14.i r52 = r47.h();
        if (r52 == null) goto L188;
        String r53 = r52.a();
        if (r53 == null) goto L188;
        r48 = r53;
        goto L188
    L180:
        if (r47.G() != ModelRate.Fresh) goto L188;
    L173:
        if (r51.d() != true) goto L175;
    L166:
        if (r49.c() == true) goto L168;
        r50 = true;
    L188:
        if (com.bytedance.awemeopen.apps.framework.utils.h0.a(r48) == false) goto L203;
        this.q.setVisibility(0);
        this.s.setText(r48);
        if (com.bytedance.awemeopen.apps.framework.utils.n0.d(getContext()) == false) goto L192;
        this.r.setColorFilter(getContext().getResources().getColor(2131100284), PorterDuff.Mode.SRC_IN);
    L192:
        r14.c r54 = this.d.a;
        if (r54 == null) goto L198;
        r14.i r55 = r54.h();
        if (r55 == null) goto L198;
        String r56 = r55.a();
        if (r56 == null) goto L198;
    L200:
        if (StringsKt.contains$default(r56, "声明", false, 2, null) == false) goto L202;
        this.r.setImageResource(2131231573);
    L204:
        this.f.getPreviewSelectedPhotoPosition().observe(this.d.d, this.I);
        this.d.d.getLifecycle().addObserver(this.G);
        return;
    L202:
        this.r.setImageResource(2131231579);
    L198:
        r56 = "";
        goto L200
    L203:
        this.q.setVisibility(8);
        goto L204
    L127:
        if (r44 >= 3600000) goto L129;
        r45 = r41.getString(2131894228, new Object[]{Long.valueOf(r44 / 60000)});
        goto L160
    L129:
        Calendar r116 = Calendar.getInstance();
        r116.set(11, 0);
        r116.set(12, 0);
        r116.set(13, 0);
        if (r42 < r116.getTimeInMillis()) goto L132;
        r45 = r41.getString(2131894210, new Object[]{Long.valueOf(r44 / 3600000)});
        goto L160
    L132:
        r116.add(6, -1);
        long r117 = r116.getTimeInMillis();
        Calendar r118 = Calendar.getInstance();
        r118.setTimeInMillis(r42);
        if (r42 < r117) goto L143;
        SimpleDateFormat r119 = com.bytedance.awemeopen.apps.framework.utils.k0.b;
        monitor-enter(r119);
        r45 = r41.getString(2131894305) + r119.format(r118.getTime());     // Catch: Throwable -> L139
        monitor-exit(r119);     // Catch: Throwable -> L139
    L139:
        th = move-exception;
        throw th;
    L143:
        if (r44 >= 345600000) goto L145;
        r45 = r41.getString(2131894184, new Object[]{Long.valueOf(r44 / 86400000)});
        goto L160
    L145:
        Calendar r57 = Calendar.getInstance();
        r57.set(6, 1);
        r57.set(11, 0);
        r57.set(12, 0);
        r57.set(13, 0);
        if (r42 < r57.getTimeInMillis()) goto L155;
        SimpleDateFormat r58 = com.bytedance.awemeopen.apps.framework.utils.k0.e;
        monitor-enter(r58);
        CharSequence r59 = r58.format(r118.getTime());     // Catch: Throwable -> L152
        monitor-exit(r58);     // Catch: Throwable -> L152
    L159:
        r45 = r59;
    L152:
        th = move-exception;
        throw th;
    L155:
        SimpleDateFormat r60 = com.bytedance.awemeopen.apps.framework.utils.k0.a;
        monitor-enter(r60);
        r59 = r60.format(r118.getTime());     // Catch: Throwable -> L206
        monitor-exit(r60);     // Catch: Throwable -> L206
    L206:
        th = move-exception;
        throw th;
    L121:
        if (r39 < 29) goto L123;
        this.o.setBreakStrategy(0);
        goto L123
    L111:
        r23.setText(r26);
        r23.setVisibility(0);
        goto L112
    L50:
        r25 = null;
        goto L51
    L46:
        r14.setText(r18);
        r14.setVisibility(0);
        goto L47
    L30:
        r17 = null;
        goto L31
    L21:
        r13 = false;
    L17:
        r11 = 0;
        goto L18
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
        View.OnClickListener r0 = this.P;
        if (r0 == null) goto L6;
        r0.onClick(r2);
        return;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r2) {
        View.OnLongClickListener r0 = this.O;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.onLongClick(r2);
    }

    @Override // nz3.g
    public final boolean onTouchEvent(MotionEvent r2) {
        nz3.g r0 = this.R;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.onTouchEvent(r2);
    }

    public final boolean r(int r4) {
        if (r4 >= 0) goto L5;
    L22:
        return false;
    L5:
        if (r4 >= this.z.size()) goto L22;
        r14.y r5 = ((PhotoModel) ListProtector.get(this.z, r4)).getUrlStruct();
        if (r5 == null) goto L10;
        List r6 = r5.c();
    L11:
        List r1 = r6;
        if (r1 != null) goto L14;
    L17:
        boolean r2 = true;
    L18:
        if (r2 == false) goto L20;
        return false;
    L20:
        int r0 = j64.b.a;
        AoImageService r3 = j64.a.a(AoImageService.class);
        Intrinsics.checkNotNull(r3);
        l64.b r7 = new l64.b();
        r7.c = r6;
        r3.h0(y54.a.a(), r7);
        return true;
    L14:
        if (r1.isEmpty() == true) goto L17;
        r2 = false;
        goto L18
    L10:
        r6 = null;
        goto L11
    }

    public final void s(int r34) {
        if (this.y != null) goto L5;
        return;
    L5:
        Map<Integer, Map<Integer, c04.f>> r1 = c04.e.a;
        int r2 = this.e.hashCode();
        Map<Integer, Map<Integer, c04.f>> r3 = c04.e.a;
        LinkedHashMap r4 = (LinkedHashMap) r3;
        Map r5 = (Map) r4.get(Integer.valueOf(r2));
        if (r5 == null) goto L8;
        c04.f r6 = (c04.f) r5.get(Integer.valueOf(r34));
    L9:
        if (r6 != null) goto L11;
        return;
    L11:
        long r7 = r6.d;
        long r8 = 0;
        if (r7 > 0) goto L14;
    L16:
        long r9 = r6.c;
        if (r9 > 0) goto L19;
    L21:
        r8 = r9 - r7;
    L22:
        long r16 = r8;
        AosEventReporter r10 = AosEventReporter.a;
        String r11 = this.d.c.sceneId();
        if (r6.a != 1) goto L25;
        boolean r12 = true;
    L26:
        int r13 = r6.f;
        int r14 = r6.g;
        long r15 = r6.e - r6.d;
        long r18 = r6.c - r6.b;
        r14.c r17 = this.y;
        Intrinsics.checkNotNull(r17);
        String r19 = this.K;
        String r20 = this.J;
        if (r34 != 0) goto L29;
        boolean r28 = true;
    L30:
        String r21 = String.valueOf(r34);
        String r22 = String.valueOf(o());
        AosPictureDetailConfig r23 = this.d.c.getPageConfig();
        if (r23 == null) goto L36;
        String r24 = r23.getPreviousPage();
        if (r24 == null) goto L36;
        String r110 = r24;
    L37:
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "enterFrom");
        Intrinsics.checkNotNullParameter(r17, "aweme");
        Intrinsics.checkNotNullParameter(r19, "enterMethod");
        Intrinsics.checkNotNullParameter(r20, "slideDirection");
        Intrinsics.checkNotNullParameter(r21, "photoSerialNum");
        Intrinsics.checkNotNullParameter(r22, "allPhotoNum");
        Intrinsics.checkNotNullParameter(r110, "previousPage");
        d14.a r25 = b14.a.a;
        t24.a r26 = b14.a.a(t24.a.class);
        User r27 = r17.f();
        if (r27 == null) goto L43;
        String r29 = r27.u();
        if (r29 == null) goto L43;
        String r210 = r29;
    L44:
        String r211 = r17.c();
        String r30 = r17.r().c;
        if (r30 != null) goto L47;
        String r212 = "";
    L48:
        String r213 = GsonProtectorUtils.toJson(GsonHolder.a(), r17.d);
        r14.a0 r0 = r17.d;
        if (r0 == null) goto L54;
        String r31 = r0.a();
        if (r31 == null) goto L54;
        String r214 = r31;
    L55:
        r26.e3(r11, r34, r16, r12, r13, r14, r15, r16, r18, r210, r211, r212, r19, r20, r214, r213, AosEventReporter.e(r17), r28, r21, r22, null, r110);
        return;
    L54:
        r214 = "";
        goto L55
    L47:
        r212 = r30;
    L43:
        r210 = "";
    L36:
        r110 = "";
        goto L37
    L29:
        r28 = false;
        goto L30
    L25:
        r12 = false;
        goto L26
    L19:
        if (r7 <= r9) goto L21;
    L14:
        if (r6.c > 0) goto L16;
        r8 = -1;
        goto L22
    L8:
        r6 = null;
        goto L9
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void seek(float r2) {
        if (this.g.getShowProgressBar() == true) goto L5;
        return;
    L5:
        this.F.c(r2);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void setClickListener(View.OnClickListener r1) {
        this.P = r1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void setLongClickListener(View.OnLongClickListener r1) {
        this.O = r1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void setOnSwipeListener(nz3.d r1) {
        this.Q = r1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void setRefreshInFirstPosition(boolean r4) {
        this.w = r4;
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
        this.g = r3;
        lz3.b r0 = this.e;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r0.b = r3;
        m();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void setSlidesProgressCallback(nz3.f r1) {
        this.N = r1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void setTouchInterceptor(nz3.g r1) {
        this.R = r1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void startLoop(boolean r13) {
        if (this.g.getShowProgressBar() == true) goto L6;
        return;
    L6:
        if (r13 == false) goto L9;
        reset(0, 0);
    L9:
        if (this.g.getAutoPlayEnabled() == false) goto L11;
        this.x = false;
        kz3.a r14 = this.F;
        long r1 = this.g.getPhotoPlayDuration();
        int r3 = kz3.a.l;
        r14.d(true, r1, false);
        return;
    L11:
        q(this, this.A, 100.0f, 100.0f, 0, false, 24);
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
        this.D.a.a = 0;
        this.m.f(r3);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void setCurrentPositionFullProgress(int r10, boolean r11) {
        this.D.a(r11);
        this.j.w(r10, r11);
        q(this, r10, 100.0f, 100.0f, 0, this.x, 8);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.bytedance.awemeopen.apps.photo.presenter.g0] */
    /* JADX WARN: Type inference failed for: r3v12, types: [com.bytedance.awemeopen.apps.photo.presenter.i0] */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.bytedance.awemeopen.apps.photo.presenter.h0] */
    public PhotoPagerPresenter(a14.a r7, lz3.b r8, PhotoFeedPagerViewModel r9) {
        Intrinsics.checkNotNullParameter(r7, "feedGroupParameters");
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r9, "photoVM");
        super(r7.b);
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r8.b;
        this.h = LazyKt.lazy(new PhotoPagerPresenter$pagePinchVM$2(this));
        this.i = (FrameLayout) i(2131382254);
        SlidesPhotosViewPager r10 = (SlidesPhotosViewPager) i(2131382259);
        this.j = r10;
        this.k = i(2131383301);
        View r0 = i(2131383298);
        this.l = r0;
        StoryListProgressBar r1 = (StoryListProgressBar) i(2131383297);
        r1.setMaskView(r0);
        this.m = r1;
        LinearLayout r2 = (LinearLayout) i(2131382251);
        this.n = (MentionTextView) i(2131391606);
        this.o = (MentionTextView) i(2131390479);
        this.p = (MentionTextView) i(2131391589);
        this.q = (LinearLayout) i(2131384659);
        this.r = (ImageView) i(2131384658);
        this.s = (MentionTextView) i(2131384660);
        Context r3 = getContext();
        r8.getClass();
        r8.a = this;
        Unit r4 = Unit.INSTANCE;
        SlidesPhotosLimitPageAdapter r5 = new SlidesPhotosLimitPageAdapter(r3, r8);
        this.t = r5;
        this.u = true;
        this.z = new ArrayList();
        this.C = new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.o();
        mz3.m r6 = new mz3.m(getContext());
        this.D = r6;
        PhotoPageChangeListener r11 = new PhotoPageChangeListener(this);
        b r12 = new b(this);
        kz3.a r13 = new kz3.a();
        Intrinsics.checkNotNullParameter(r12, "callback");
        r13.f = r12;
        this.F = r13;
        this.H = new g0(this);
        this.I = new h0(this);
        this.J = "";
        this.K = "auto";
        this.L = new LinkedHashSet();
        this.S = new ContainerSizeCalculator();
        this.T = new Size(0, 0);
        this.U = j64.a.a(AoCommonMonitorService.class);
        this.V = new Handler(Looper.getMainLooper());
        this.G = new i0(this);
        AosPictureDetailConfig r14 = r7.c.getPageConfig();
        if (r14 == null) goto L5;
        int r15 = r14.getOffscreenPageLimit();
    L6:
        r10.setOffscreenPageLimit(r15);
        r10.setAdapter(r5);
        r10.b(r11);
        Intrinsics.checkNotNullParameter(r10, "pager");
        Field r16 = ViewPager.class.getDeclaredField("mScroller");     // Catch: Exception -> L9
        r16.setAccessible(true);     // Catch: Exception -> L9
        r16.set(r10, r6);     // Catch: Exception -> L9
    L11:
        r10.setSwipeOutListener(new j0(this));
        r10.setScrollListener(new k0(this));
        r10.setScrollInterceptor(new l0(this));
        r10.setISlidesPhotosViewPagerInterceptor(new m0(this));
        this.W = -1;
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    L5:
        r15 = 3;
        goto L6
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api.ISlidesPhotosView
    public final void setCurrentPosition(final int r4, final boolean r5, long r6) {
        this.D.a(r5);
        if (r6 <= 0) goto L5;
        this.j.postDelayed(new f0(this, r4, r5), r6);
        return;
    L5:
        this.j.w(r4, r5);
    }

    public static void q(PhotoPagerPresenter r6, int r7, float r8, float r9, long r10, boolean r12, int r13) {
        if ((r13 & 8) == 0) goto L5;
        r10 = 300;
    L5:
        long r3 = r10;
        if ((r13 & 16) == 0) goto L9;
        r12 = false;
    L9:
        if (r6.g.getShowProgressBar() == true) goto L11;
    L15:
        nz3.f r11 = r6.N;
        if (r11 == null) goto L19;
        r11.c(r7, r8, r12);
        return;
    L19:
        return;
    L11:
        if (r6.g.getAutoPlayEnabled() == false) goto L14;
        if (r12 == true) goto L14;
        StoryListProgressBar.g(r6.m, r7, r9 / 100.0f, r3, 8);
    L14:
        r6.m.h(r7, r9 / 100.0f);
        goto L15
    }
}
