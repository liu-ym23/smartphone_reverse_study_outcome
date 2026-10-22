package com.bytedance.awemeopen.apps.photo;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtStatusView;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DoubleColorBallAnimationView;
import com.bytedance.awemeopen.apps.framework.comment.CommentListView;
import com.bytedance.awemeopen.apps.framework.comment.view.commentimage.AosCommentImageContainer;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.model.SlidesPhotosConfig;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vm.PhotoFeedPagerViewModel;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.AosDefaultNetErrorView;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.AosNoMoreFeedErrorView;
import com.bytedance.awemeopen.apps.framework.utils.c0;
import com.bytedance.awemeopen.apps.framework.utils.n0;
import com.bytedance.awemeopen.apps.framework.utils.reporter.HostCommonParamProvider;
import com.bytedance.awemeopen.apps.framework.utils.z;
import com.bytedance.awemeopen.apps.photo.presenter.AppBarScrollPresenter;
import com.bytedance.awemeopen.apps.photo.presenter.CameraStrongPresenter;
import com.bytedance.awemeopen.apps.photo.presenter.CameraWeekPresenter;
import com.bytedance.awemeopen.apps.photo.presenter.FlowDetailPinchGalleryPresenter;
import com.bytedance.awemeopen.apps.photo.presenter.GuesturePresenter;
import com.bytedance.awemeopen.apps.photo.presenter.MultiCameraPresenter;
import com.bytedance.awemeopen.apps.photo.presenter.PhotoPagerPresenter;
import com.bytedance.awemeopen.apps.photo.presenter.PictureTopInfoPresenter;
import com.bytedance.awemeopen.apps.photo.presenter.PinchBasicPresenter;
import com.bytedance.awemeopen.apps.photo.presenter.PinchBtmBarPresenter;
import com.bytedance.awemeopen.apps.photo.presenter.k;
import com.bytedance.awemeopen.apps.photo.presenter.n;
import com.bytedance.awemeopen.apps.photo.presenter.o0;
import com.bytedance.awemeopen.apps.photo.presenter.q;
import com.bytedance.awemeopen.apps.photo.presenter.t;
import com.bytedance.awemeopen.apps.photo.viewmodel.AosPictureDetailViewModel;
import com.bytedance.awemeopen.apps.photo.viewmodel.FlowPagePinchVM;
import com.bytedance.awemeopen.domain.feed.preload.aweme.AosAwemePreloadManager;
import com.bytedance.awemeopen.export.api.picturedetail.AosPictureDetailConfig;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import nz3.f;
import nz3.g;
import org.json.JSONObject;
import r14.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u000f\u0012\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016R\u001b\u0010\u0011\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0014\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R\u001b\u0010\u0019\u001a\u00020\u00158DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0018R\"\u0010!\u001a\u00020\u001a8\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006&"}, d2 = {"Lcom/bytedance/awemeopen/apps/photo/AosPictureDetailLayout;", "Lcom/bytedance/awemeopen/apps/framework/feed/layout/layout/AosBaseLayout;", "Lcom/bytedance/awemeopen/apps/photo/viewmodel/AosPictureDetailViewModel;", "", "Lcom/bytedance/awemeopen/apps/framework/utils/z;", "Landroid/os/Bundle;", "bundle", "", "setArguments", "Ln54/b;", "listener", "setPageListener", "", "q", "Lkotlin/Lazy;", "getUseStopReport", "()Z", "useStopReport", "r", "getEnablePreloadFilterExempt", "enablePreloadFilterExempt", "Lcom/bytedance/awemeopen/apps/photo/viewmodel/FlowPagePinchVM;", "t", "getPagePinchVM", "()Lcom/bytedance/awemeopen/apps/photo/viewmodel/FlowPagePinchVM;", "pagePinchVM", "Lcom/bytedance/awemeopen/apps/framework/base/view/refresh/DmtStatusView;", "v", "Lcom/bytedance/awemeopen/apps/framework/base/view/refresh/DmtStatusView;", "getStatusView", "()Lcom/bytedance/awemeopen/apps/framework/base/view/refresh/DmtStatusView;", "setStatusView", "(Lcom/bytedance/awemeopen/apps/framework/base/view/refresh/DmtStatusView;)V", "statusView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "ao_apps_photo_release"}, k = 1, mv = {1, 7, 1})
public class AosPictureDetailLayout extends AosBaseLayout<AosPictureDetailViewModel> implements z {
    public static final /* synthetic */ int H = 0;
    public a14.a A;
    public HostCommonParamProvider B;
    public final com.bytedance.awemeopen.apps.photo.d C;
    public boolean D;
    public final lz3.a E;
    public qz3.c F;
    public boolean G;
    public n54.b i;
    public long j;
    public long k;
    public f04.b<Unit> l;
    public PhotoPagerPresenter m;
    public GuesturePresenter n;
    public n o;
    public AppBarScrollPresenter p;
    public final Lazy q;
    public final Lazy r;
    public PinchBasicPresenter s;
    public final Lazy t;
    public final PhotoFeedPagerViewModel u;
    public DmtStatusView v;
    public Fragment w;
    public FrameLayout x;
    public DoubleColorBallAnimationView y;
    public AoImageView z;

    public static final class a implements f {
        public a() {
        }

        @Override // nz3.f
        public final void a() {
        }

        @Override // nz3.f
        public final void b(int r1) {
        }

        @Override // nz3.f
        public final void c(int r1, float r2, boolean r3) {
        }

        @Override // nz3.f
        public final void g() {
        }

        @Override // nz3.f
        public final void h() {
        }
    }

    public static final class b implements g {
        public final /* synthetic */ AosPictureDetailLayout a;

        public b(AosPictureDetailLayout r1) {
            this.a = r1;
        }

        @Override // nz3.g
        public final boolean onTouchEvent(MotionEvent r3) {
            if (r3 == null) goto L6;
            qz3.c r0 = this.a.F;
            if (r0 == null) goto L6;
            Intrinsics.checkNotNullParameter(r3, "motionEvent");
            r0.a.setValue(r3);
        L6:
            GuesturePresenter r1 = this.a.n;
            Intrinsics.checkNotNull(r1);
            return r1.k.dispatchTouchEvent(r3);
        }
    }

    public static final class c implements nz3.d {
        public final /* synthetic */ AosPictureDetailLayout a;

        @Override // nz3.d
        public final void a() {
            this.a.getPagePinchVM().onStableCloseClick("slide");
        }

        @Override // nz3.d
        public final boolean b() {
            if (Intrinsics.areEqual(this.a.getPagePinchVM().getInStableView().getValue(), Boolean.TRUE) == false) goto L6;
            return true;
        L6:
            return false;
        }

        @Override // nz3.d
        public final void c() {
            this.a.getPagePinchVM().onStableCloseClick("slide");
        }

        @Override // nz3.d
        public final boolean d() {
            if (Intrinsics.areEqual(this.a.getPagePinchVM().getInStableView().getValue(), Boolean.TRUE) == false) goto L6;
            return true;
        L6:
            return false;
        }

        public c(AosPictureDetailLayout r1) {
            this.a = r1;
        }
    }

    public static final class d implements h04.e<r14.c> {
        public final /* synthetic */ AosPictureDetailLayout a;
        public final /* synthetic */ long b;

        public d(AosPictureDetailLayout r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // h04.e
        public final void a(Exception r3, int r4) {
            lz3.a r5 = this.a.E;
            r5.e = System.currentTimeMillis();
            AosPictureDetailLayout.p(this.a);
            this.a.w();
            long r6 = this.a.E.e - this.b;
            d14.a r0 = b14.a.a;
            b14.a.a(t24.a.class).s2(false, r6);
        }

        @Override // h04.e
        public final void b(List<? extends r14.c> r8, boolean r9, boolean r10) {
            Intrinsics.checkNotNullParameter(r8, "data");
            lz3.a r11 = this.a.E;
            r11.e = System.currentTimeMillis();
            AosPictureDetailLayout r12 = this.a;
            Iterator<T> r13 = r8.iterator();
        L4:
            if (r13.hasNext() == false) goto L8;
            Object r14 = r13.next();
            if (Intrinsics.areEqual(((r14.c) r14).c(), r12.getVm().getEnterAid()) == false) goto L4;
        L9:
            r14.c r15 = (r14.c) r14;
            AosPictureDetailLayout.p(this.a);
            if (r15 != null) goto L12;
        L26:
            this.a.w();
        L27:
            long r16 = this.a.E.e - this.b;
            d14.a r0 = b14.a.a;
            b14.a.a(t24.a.class).s2(true, r16);
            return;
        L12:
            if (com.bytedance.awemeopen.bizmodels.user.d.b(r15) == false) goto L26;
            if (Intrinsics.areEqual(r15.r().e, Boolean.TRUE) == false) goto L16;
            AosAwemePreloadManager r17 = AosAwemePreloadManager.a;
            Intrinsics.checkNotNullParameter(r15, "aweme");
            com.bytedance.awemeopen.domain.feed.preload.aweme.d.f.c(r15.c(), new w34.a(r15, SystemClock.elapsedRealtime()));
        L17:
            this.a.getStatusView().c();
            this.a.getVm().initAweme(r15);
            AosPictureDetailLayout r18 = this.a;
            String r1 = r18.getVm().getEnterAid();
            Intrinsics.checkNotNull(r1);
            long r3 = System.currentTimeMillis();
            AosPictureDetailLayout r19 = this.a;
            long r4 = r3 - r19.E.d;
            r14.c r110 = r19.getVm().getAweme();
            if (r110 == null) goto L20;
            int r6 = r110.i();
        L22:
            if (r18.G == true) goto L25;
            r18.G = true;
            d14.a r20 = b14.a.a;
            b14.a.a(t24.a.class).E0(r1, false, r4, 1, r6);
        L25:
            this.a.u();
            goto L27
        L20:
            r6 = 0;
            goto L22
        L16:
            AosAwemePreloadManager r21 = AosAwemePreloadManager.a;
            AosAwemePreloadManager.b(r15);
            goto L17
        L8:
            r14 = null;
            goto L9
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public final int f() {
        return 2131558684;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public final Class<AosPictureDetailViewModel> m() {
        return AosPictureDetailViewModel.class;
    }

    private final boolean getEnablePreloadFilterExempt() {
        return ((Boolean) this.r.getValue()).booleanValue();
    }

    private final boolean getUseStopReport() {
        return ((Boolean) this.q.getValue()).booleanValue();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public final boolean g() {
        PinchBasicPresenter r0 = this.s;
        if (r0 != null) goto L5;
    L10:
        boolean r1 = false;
    L11:
        if (r1 == false) goto L13;
        return true;
    L13:
        n r2 = this.o;
        if (r2 == null) goto L21;
        AosCommentImageContainer r3 = r2.e.F;
        if (r3 == null) goto L18;
        boolean r4 = r3.d();
    L19:
        if (r4 != true) goto L21;
        boolean r5 = true;
    L22:
        if (r5 == false) goto L29;
        n r6 = this.o;
        if (r6 == null) goto L28;
        CommentListView r7 = r6.e;
        r7.getClass();
        Intrinsics.checkNotNullParameter("slide", "exitMethod");
        AosCommentImageContainer r8 = r7.F;
        if (r8 == null) goto L28;
        r8.b("slide");
    L28:
        return true;
    L29:
        return false;
    L18:
        r4 = false;
    L21:
        r5 = false;
        goto L22
    L5:
        if (r0.o == false) goto L7;
        r0.p(true, "back");
        boolean r9 = true;
    L8:
        if (r9 != true) goto L10;
        r1 = true;
        goto L11
    L7:
        r9 = false;
        goto L8
    }

    public final FlowPagePinchVM getPagePinchVM() {
        return (FlowPagePinchVM) this.t.getValue();
    }

    public final DmtStatusView getStatusView() {
        DmtStatusView r0 = this.v;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("statusView");
        return null;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public final void h() {
        lz3.a r0 = this.E;
        r0.c = this.k;
        r0.d = System.currentTimeMillis();
        r14.c r1 = getVm().checkPreloadData(getVm().getEnterAid());
        if (r1 != null) goto L14;
        AosPictureDetailConfig r3 = getVm().getPageConfig();
        if (r3 != null) goto L7;
    L9:
        boolean r4 = false;
    L10:
        if (r4 == false) goto L12;
    L13:
        r1 = getVm().checkPreloadNoMusicItem(getVm().getEnterAid());
        goto L14
    L12:
        if (getEnablePreloadFilterExempt() == false) goto L14;
    L7:
        if (r3.getEnablePreloadFilterExemptItem() != true) goto L9;
        r4 = true;
    L14:
        if (r1 != null) goto L18;
        this.E.f = false;
        s();
        t();
        v();
        d14.a r2 = b14.a.a;
        p24.e r5 = b14.a.a(p24.e.class);
        Application r6 = y54.a.a();
        String r7 = getVm().getEnterAid();
        Intrinsics.checkNotNull(r7);
        r5.z2(r6, r7);
        return;
    L18:
        if (com.bytedance.awemeopen.bizmodels.user.d.b(r1) == true) goto L21;
        s();
        t();
        w();
        return;
    L21:
        lz3.a r8 = this.E;
        r8.e = System.currentTimeMillis();
        this.E.f = true;
        getVm().initAweme(r1);
        u();
        String r9 = getVm().getEnterAid();
        Intrinsics.checkNotNull(r9);
        long r10 = System.currentTimeMillis() - this.E.d;
        r14.c r11 = getVm().getAweme();
        if (r11 == null) goto L24;
        int r12 = r11.i();
    L26:
        if (this.G == true) goto L30;
        this.G = true;
        d14.a r13 = b14.a.a;
        b14.a.a(t24.a.class).E0(r9, true, r10, 0, r12);
        return;
    L30:
        return;
    L24:
        r12 = 0;
        goto L26
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public final void i() {
        f04.b<Unit> r0 = this.l;
        if (r0 == null) goto L5;
        r0.k();
    L5:
        d14.a r1 = b14.a.a;
        b14.a.a(t24.a.class).z0(this.B);
        b14.a.a(t24.a.class).z0(this.C);
        String[] r2 = c0.a;
        c0.c(getContext(), this);
        com.bytedance.awemeopen.apps.framework.utils.c r3 = com.bytedance.awemeopen.apps.framework.utils.c.a;
        r14.c r4 = getVm().getAweme();
        if (r4 == null) goto L8;
        String r5 = r4.c();
    L9:
        k34.b r6 = com.bytedance.awemeopen.apps.framework.utils.c.b;
        if (r6 == null) goto L13;
        r6.M1();
        com.bytedance.awemeopen.appserviceimpl.user.a.a.a(r5);
        return;
    L13:
        return;
    L8:
        r5 = null;
        goto L9
    }

    public final void u() {
        Context r0 = getContext();
        JSONObject r8 = null;
        if ((r0 instanceof Activity) == false) goto L5;
        Activity r9 = (Activity) r0;
    L6:
        if (r9 != null) goto L9;
        r();
        return;
    L9:
        d14.a r1 = b14.a.a;
        b14.a.a(t24.a.class).H1(this.C);
        r14.c r2 = getVm().getAweme();
        Intrinsics.checkNotNull(r2);
        a14.a r10 = new a14.a(r2, getRootView(), getVm(), this, this, r9);
        this.A = r10;
        this.l = new f04.b(getLayoutRootView());
        this.n = new GuesturePresenter(r10, this.u, new AosPictureDetailLayout$realOnBind$1(this));
        boolean r3 = com.bytedance.awemeopen.apps.framework.feed.ui.information.a.m;
        lz3.b r4 = new lz3.b();
        SlidesPhotosConfig r5 = r4.b;
        AosPictureDetailConfig r6 = getVm().getPageConfig();
        if (r6 == null) goto L12;
        String r7 = r6.getHostPlaceholderUrl();
    L13:
        r5.setHostPlaceHolderUrl(r7);
        SlidesPhotosConfig r11 = r4.b;
        AosPictureDetailConfig r12 = getVm().getPageConfig();
        if (r12 == null) goto L16;
        Boolean r13 = Boolean.valueOf(r12.getOptVisibilityAggregated());
    L17:
        r11.setOptVisibilityAggregated(r13);
        r4.d = this.E;
        Unit r14 = Unit.INSTANCE;
        PhotoPagerPresenter r15 = new PhotoPagerPresenter(r10, r4, this.u);
        r15.N = new a();
        r15.R = new b(this);
        if (r3 == false) goto L20;
        r15.Q = new c(this);
    L20:
        this.m = r15;
        this.o = new n(r10);
        this.p = new AppBarScrollPresenter(r10);
        f04.b<Unit> r16 = this.l;
        Intrinsics.checkNotNull(r16);
        PhotoPagerPresenter r17 = this.m;
        Intrinsics.checkNotNull(r17);
        r16.m(r17);
        r16.m(new PictureTopInfoPresenter(r10, new AosPictureDetailLayout$realOnBind$4(this)));
        r16.m(new k(r10));
        r16.m(new t(r10));
        r16.m(new q(r10));
        r16.m(new com.bytedance.awemeopen.apps.photo.presenter.c0(r10));
        if (r3 == false) goto L26;
        qz3.d r18 = new qz3.d();
        this.F = new qz3.c();
        final PinchBasicPresenter r19 = new PinchBasicPresenter(r10, r18);
        this.s = r19;
        GuesturePresenter r20 = this.n;
        if (r20 == null) goto L25;
        r20.o = new com.bytedance.awemeopen.apps.photo.b(r19);
    L25:
        r16.m(r19);
        r16.m(new PinchBtmBarPresenter(r10));
        r16.m(new FlowDetailPinchGalleryPresenter(r10, this.u));
        r16.m(new com.bytedance.awemeopen.apps.photo.presenter.z(r10, r18, this.F));
    L26:
        n r21 = this.o;
        Intrinsics.checkNotNull(r21);
        r16.m(r21);
        GuesturePresenter r22 = this.n;
        Intrinsics.checkNotNull(r22);
        r16.m(r22);
        AppBarScrollPresenter r23 = this.p;
        Intrinsics.checkNotNull(r23);
        r16.m(r23);
        r16.m(new o0(r10));
        r16.m(new CameraStrongPresenter(r10));
        r16.m(new MultiCameraPresenter(r10, this, this.w));
        r16.m(new CameraWeekPresenter(r10));
        r16.f(Unit.INSTANCE);
        com.bytedance.awemeopen.apps.photo.utils.a.a.getClass();
        Intrinsics.checkNotNullParameter(r10, "feedGroupParameters");
        Map r110 = com.bytedance.awemeopen.apps.photo.utils.a.a(r10);
        r110.put("from_group_id", r10.a.c());
        AosEventReporter r24 = AosEventReporter.a;
        com.bytedance.awemeopen.apps.framework.utils.e r25 = new com.bytedance.awemeopen.apps.framework.utils.e(r10.a);
        AosPictureDetailConfig r26 = r10.c.getPageConfig();
        if (r26 == null) goto L29;
        JSONObject r111 = r26.getHostExtraParams();
    L30:
        AosEventReporter.s(r24, "page_show", r110, null, r111, r25, 4);
        if (this.D == true) goto L36;
        long r27 = System.currentTimeMillis() - this.k;
        PhotoPagerPresenter r28 = this.m;
        Intrinsics.checkNotNull(r28);
        int r29 = r28.o();
        Intrinsics.checkNotNullParameter(r10, "feedGroupParameters");
        Map r30 = com.bytedance.awemeopen.apps.photo.utils.a.a(r10);
        r30.put("from_group_id", r10.a.c());
        r30.put("duration", Long.valueOf(r27));
        r30.put("status", 1);
        r30.put("all_photo_num", String.valueOf(r29));
        AosPictureDetailConfig r31 = r10.c.getPageConfig();
        if (r31 == null) goto L35;
        r8 = r31.getHostExtraParams();
    L35:
        AosEventReporter.s(r24, "page_cost", r30, null, r8, new com.bytedance.awemeopen.apps.framework.utils.e(r10.a), 4);
    L36:
        getVm().observeDiggStatusChange(new com.bytedance.awemeopen.apps.photo.c(this));
        String[] r32 = c0.a;
        c0.b(r9, this);
        com.bytedance.awemeopen.apps.framework.utils.c r33 = com.bytedance.awemeopen.apps.framework.utils.c.a;
        AosPictureDetailConfig r34 = getVm().getPageConfig();
        String r35 = "";
        if (r34 == null) goto L40;
        String r36 = r34.getHostEnterFrom();
        if (r36 == null) goto L40;
    L41:
        String r37 = getVm().sceneId();
        r14.c r38 = getVm().getAweme();
        if (r38 == null) goto L45;
        String r39 = r38.c();
        if (r39 == null) goto L45;
    L46:
        r14.c r40 = getVm().getAweme();
        if (r40 == null) goto L54;
        a0 r41 = r40.d;
        if (r41 == null) goto L54;
        String r42 = r41.a();
        if (r42 == null) goto L54;
        r35 = r42;
    L54:
        com.bytedance.awemeopen.apps.framework.utils.c.c(new k34.a(r36, r37, r39, r35));
        return;
    L45:
        r39 = "";
    L40:
        r36 = "";
        goto L41
    L29:
        r111 = null;
        goto L30
    L16:
        r13 = null;
        goto L17
    L12:
        r7 = null;
        goto L13
    L5:
        r9 = null;
        goto L6
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public final void e() {
        this.k = System.currentTimeMillis();
        findViewById(2131382307).setOnClickListener(new e(this));
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public final void k() {
        Bundle r0 = getBundle();
        if (r0 == null) goto L5;
        AosPictureDetailConfig r1 = (AosPictureDetailConfig) r0.getParcelable("PICTURE_DETAIL_CONFIG_KEY");
    L6:
        if (r1 != null) goto L8;
        r1 = new AosPictureDetailConfig();
    L8:
        String r2 = r1.getEnterAid();
        if (r2 != null) goto L11;
    L14:
        boolean r3 = true;
    L15:
        if (r3 == false) goto L18;
        r();
        return;
    L18:
        lz3.a r4 = this.E;
        r4.b = r1.getHostEnterTime();
        getVm().initPageConfig(r1);
        this.B = new HostCommonParamProvider(r1.getHostCommonParams());
        d14.a r5 = b14.a.a;
        b14.a.a(t24.a.class).H1(this.B);
        return;
    L11:
        if (r2.length() == 0) goto L14;
        r3 = false;
        goto L15
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public final boolean l() {
        AosPictureDetailConfig r0 = getVm().getPageConfig();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getShouldPaddingStatusBarHeight() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.base.LifeCycleFrameLayout, com.bytedance.awemeopen.apps.framework.feed.layout.base.ILifeCycleView
    public final void onCreate() {
        super.onCreate();
        Context r0 = getContext();
        if ((r0 instanceof Activity) == false) goto L5;
        Activity r1 = (Activity) r0;
    L7:
        if (r1 == null) goto L9;
        r1.getWindow().setNavigationBarColor(r1.getResources().getColor(2131100242));
    L9:
        getLayoutRootView().setBackgroundColor(getContext().getResources().getColor(2131100242));
        this.k = System.currentTimeMillis();
        return;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout, com.bytedance.awemeopen.apps.framework.feed.layout.base.LifeCycleFrameLayout, com.bytedance.awemeopen.apps.framework.feed.layout.base.ILifeCycleView
    public final void onDestroy() {
        super.onDestroy();
        getVm().onDestroy();
        this.w = null;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.base.LifeCycleFrameLayout, com.bytedance.awemeopen.apps.framework.feed.layout.base.ILifeCycleView
    public final void onPause() {
        super.onPause();
        if (getUseStopReport() == true) goto L8;
        a14.a r0 = this.A;
        if (r0 == null) goto L9;
        com.bytedance.awemeopen.apps.photo.utils.a r1 = com.bytedance.awemeopen.apps.photo.utils.a.a;
        long r2 = System.currentTimeMillis() - this.j;
        r1.getClass();
        com.bytedance.awemeopen.apps.photo.utils.a.e(r0, r2);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.base.LifeCycleFrameLayout, com.bytedance.awemeopen.apps.framework.feed.layout.base.ILifeCycleView
    public final void onResume() {
        super.onResume();
        if (getUseStopReport() == true) goto L6;
        this.j = System.currentTimeMillis();
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.base.LifeCycleFrameLayout, com.bytedance.awemeopen.apps.framework.feed.layout.base.ILifeCycleView
    public final void onStart() {
        super.onStart();
        if (getUseStopReport() == false) goto L5;
        this.j = System.currentTimeMillis();
    L5:
        AppBarScrollPresenter r0 = this.p;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.j == false) goto L12;
        r0.n();
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.base.LifeCycleFrameLayout, com.bytedance.awemeopen.apps.framework.feed.layout.base.ILifeCycleView
    public final void onStop() {
        super.onStop();
        if (getUseStopReport() == false) goto L7;
        a14.a r0 = this.A;
        if (r0 == null) goto L7;
        com.bytedance.awemeopen.apps.photo.utils.a r1 = com.bytedance.awemeopen.apps.photo.utils.a.a;
        long r2 = System.currentTimeMillis() - this.j;
        r1.getClass();
        com.bytedance.awemeopen.apps.photo.utils.a.e(r0, r2);
    L7:
        AppBarScrollPresenter r3 = this.p;
        if (r3 != null) goto L10;
        return;
    L10:
        if (r3.j == false) goto L14;
        r3.m();
        return;
    }

    public final void r() {
        Context r0 = getContext();
        if ((r0 instanceof Activity) == false) goto L5;
        Activity r1 = (Activity) r0;
    L6:
        if (r1 == null) goto L8;
        r1.finish();
    L8:
        n54.b r2 = this.i;
        if (r2 == null) goto L12;
        r2.b();
        return;
    L12:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void s() {
        this.x = (FrameLayout) findViewById(2131375296);
        DoubleColorBallAnimationView r0 = (DoubleColorBallAnimationView) findViewById(2131375295);
        this.y = r0;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("initLoadingDoubleBall");
        r0 = null;
    L5:
        r0.setResumeWhenAttached(true);
        this.z = findViewById(2131375294);
    }

    public final void t() {
        setStatusView((DmtStatusView) findViewById(2131387318));
        DmtStatusView.a r0 = DmtStatusView.a.a(getContext());
        DmtStatusView r1 = getStatusView();
        Intrinsics.checkNotNullParameter(r1, "statusView");
        AosDefaultNetErrorView r2 = new AosDefaultNetErrorView(r1.getContext());
        r2.findViewById(2131384465).setOnClickListener(new com.bytedance.awemeopen.apps.photo.a(this));
        r0.d(r2);
        AosNoMoreFeedErrorView r3 = new AosNoMoreFeedErrorView(getStatusView().getContext());
        r0.e = r3;
        r3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        getStatusView().setBuilder(r0);
        boolean r4 = n0.c(getContext());
        getStatusView().setForceDarkTheme(Boolean.valueOf(r4));
        getStatusView().c();
        if (r4 == false) goto L5;
        r2.b();
        return;
    L5:
        r2.c();
    }

    public final void v() {
        getStatusView().c();
        AppCompatImageView r0 = this.z;
        String r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("hostCover");
        r0 = null;
    L5:
        r0.setImageResource(2131231572);
        FrameLayout r2 = this.x;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("initLoadingFl");
        r2 = null;
    L8:
        x54.b.d(r2);
        DoubleColorBallAnimationView r3 = this.y;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("initLoadingDoubleBall");
        r3 = null;
    L11:
        r3.setVisibility(0);
        DoubleColorBallAnimationView r4 = this.y;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("initLoadingDoubleBall");
        r4 = null;
    L14:
        r4.c();
        long r5 = System.currentTimeMillis();
        AosPictureDetailViewModel r6 = getVm();
        String r7 = getVm().getEnterAid();
        Intrinsics.checkNotNull(r7);
        String r8 = getVm().getEnterRequestId();
        AosPictureDetailConfig r9 = getVm().getPageConfig();
        if (r9 == null) goto L17;
        r1 = r9.getContentScene();
    L17:
        r6.startServerRefreshSpecified(r7, r8, r1, new d(this, r5));
    }

    public final void w() {
        getStatusView().d();
        if (this.D == true) goto L15;
        com.bytedance.awemeopen.apps.photo.utils.a r0 = com.bytedance.awemeopen.apps.photo.utils.a.a;
        AosPictureDetailViewModel r1 = getVm();
        long r2 = System.currentTimeMillis() - this.k;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "viewModel");
        LinkedHashMap r6 = new LinkedHashMap();
        r6.put("enter_from", r1.sceneId());
        AosPictureDetailConfig r3 = r1.getPageConfig();
        if (r3 == null) goto L8;
        String r4 = r3.getPreviousPage();
        if (r4 == null) goto L8;
    L9:
        r6.put(BaseFollowStoreViewModel.KEY_PREVIOUS_PAGE, r4);
        r6.put("duration", Long.valueOf(r2));
        r6.put("status", 0);
        AosEventReporter r5 = AosEventReporter.a;
        AosPictureDetailConfig r7 = r1.getPageConfig();
        if (r7 == null) goto L12;
        JSONObject r8 = r7.getHostExtraParams();
    L13:
        AosEventReporter.s(r5, "page_cost", r6, null, r8, new com.bytedance.awemeopen.apps.framework.utils.e(r1.getAweme()), 4);
        return;
    L12:
        r8 = null;
    L8:
        r4 = "";
        goto L9
    }

    /* JADX WARN: Type inference failed for: r2v8, types: [com.bytedance.awemeopen.apps.photo.d] */
    public AosPictureDetailLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2);
        this.q = LazyKt.lazy(AosPictureDetailLayout$useStopReport$2.INSTANCE);
        this.r = LazyKt.lazy(AosPictureDetailLayout$enablePreloadFilterExempt$2.INSTANCE);
        this.t = LazyKt.lazy(new AosPictureDetailLayout$pagePinchVM$2(this));
        this.u = new PhotoFeedPagerViewModel();
        this.C = new com.bytedance.awemeopen.apps.photo.d(this);
        this.E = new lz3.a();
    }

    public static final void p(AosPictureDetailLayout r3) {
        FrameLayout r0 = r3.x;
        DoubleColorBallAnimationView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("initLoadingFl");
        r0 = null;
    L5:
        x54.b.a(r0);
        DoubleColorBallAnimationView r2 = r3.y;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("initLoadingDoubleBall");
        r2 = null;
    L9:
        if (r2.k == false) goto L16;
        DoubleColorBallAnimationView r4 = r3.y;
        if (r4 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("initLoadingDoubleBall");
    L14:
        r1.d();
        return;
    L13:
        r1 = r4;
        goto L14
    }

    @Override // com.bytedance.awemeopen.apps.framework.utils.z
    public final void M00(String r9) {
        Intrinsics.checkNotNullParameter(r9, "filePath");
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L12;
        a14.a r10 = this.A;
        if (r10 == null) goto L13;
        com.bytedance.awemeopen.apps.photo.utils.a.a.getClass();
        Intrinsics.checkNotNullParameter(r10, "feedGroupParameters");
        Map r3 = com.bytedance.awemeopen.apps.photo.utils.a.a(r10);
        r3.put("from_group_id", r10.a.c());
        AosEventReporter r1 = AosEventReporter.a;
        AosPictureDetailConfig r0 = r10.c.getPageConfig();
        if (r0 == null) goto L9;
        JSONObject r2 = r0.getHostExtraParams();
    L10:
        AosEventReporter.s(r1, "screenshoot_click", r3, null, r2, new com.bytedance.awemeopen.apps.framework.utils.e(r10.a), 4);
        return;
    L9:
        r2 = null;
        goto L10
    L13:
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public void setArguments(Bundle r1) {
        setBundle(r1);
    }

    public void setPageListener(n54.b r1) {
        this.i = r1;
    }

    public final void setStatusView(DmtStatusView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.v = r2;
    }
}
