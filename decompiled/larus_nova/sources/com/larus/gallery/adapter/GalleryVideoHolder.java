package com.larus.gallery.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.RectF;
import android.view.View;
import android.widget.ImageView;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.photoviewer.transition.TransitionLayout;
import com.larus.common_ui.photoviewer.transition.TransitionViewHolder;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.common_ui.video.progress.PlayerProgressView;
import com.larus.gallery.adapter.ui.GalleryVideoPlayView;
import com.larus.gallery.adapter.ui.GalleryVideoView;
import com.larus.gallery.impl.databinding.LarusGalleryVideoViewBinding;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.search.common.result.recycler.ECSaasScrollViewController;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 W2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001WB7\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020!2\u0006\u0010,\u001a\u00020!H\u0000¢\u0006\u0002\b-J\b\u0010.\u001a\u00020\u0016H\u0002J\u0016\u0010/\u001a\u00020)2\u0006\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u00020!J\u0010\u00102\u001a\u00020\u00162\u0006\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u00020)H\u0002J\b\u00106\u001a\u00020)H\u0002J\u001a\u00107\u001a\u00020)2\b\u00100\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u00020\u0016H\u0002J\b\u0010:\u001a\u00020)H\u0002J\b\u0010;\u001a\u00020)H\u0002J\b\u0010<\u001a\u00020)H\u0002J\r\u0010=\u001a\u00020)H\u0000¢\u0006\u0002\b>J\u0010\u0010?\u001a\u00020)2\u0006\u0010@\u001a\u00020\u0016H\u0002J\b\u0010A\u001a\u00020)H\u0002J\u0010\u0010B\u001a\u00020)2\u0006\u0010C\u001a\u00020\u0016H\u0002J\u0018\u0010D\u001a\u00020)2\u0006\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u00020!H\u0002J \u0010E\u001a\u00020)2\b\u0010F\u001a\u0004\u0018\u0001082\f\u0010G\u001a\b\u0012\u0004\u0012\u00020)0HH\u0002J(\u0010I\u001a\u00020)2\b\u0010F\u001a\u0004\u0018\u0001082\u0014\u0010J\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0004\u0012\u00020)0KH\u0002J\b\u0010L\u001a\u00020)H\u0016J\b\u0010M\u001a\u00020)H\u0016J\b\u0010N\u001a\u00020)H\u0016J\b\u0010O\u001a\u00020)H\u0016J\b\u0010P\u001a\u00020)H\u0016J\b\u0010Q\u001a\u00020)H\u0016J\b\u0010R\u001a\u00020SH\u0002J\b\u0010T\u001a\u00020)H\u0002J\u0006\u0010U\u001a\u00020)J\u0006\u0010V\u001a\u00020)R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010#R\u000e\u0010$\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006X"}, d2 = {"Lcom/larus/gallery/adapter/GalleryVideoHolder;", "Lcom/larus/common_ui/photoviewer/transition/TransitionViewHolder;", "Lcom/larus/gallery/adapter/ViewHolderSelectListener;", "Lcom/larus/gallery/adapter/GalleryVideoStateListener;", "Lcom/larus/gallery/adapter/GalleryContentBoundsProvider;", "binding", "Lcom/larus/gallery/impl/databinding/LarusGalleryVideoViewBinding;", "lifecycleScope", "Lkotlinx/coroutines/CoroutineScope;", "listener", "Lcom/larus/gallery/adapter/InternalGalleryItemListener;", "displayConfig", "Lcom/larus/gallery/api/DisplayConfig;", "centerStatusSaver", "Lcom/larus/gallery/adapter/GalleryCenterStatusSaver;", "<init>", "(Lcom/larus/gallery/impl/databinding/LarusGalleryVideoViewBinding;Lkotlinx/coroutines/CoroutineScope;Lcom/larus/gallery/adapter/InternalGalleryItemListener;Lcom/larus/gallery/api/DisplayConfig;Lcom/larus/gallery/adapter/GalleryCenterStatusSaver;)V", "getCenterStatusSaver", "()Lcom/larus/gallery/adapter/GalleryCenterStatusSaver;", "galleryData", "Lcom/larus/gallery/api/GalleryData;", ECSaasScrollViewController.SEARCH_SCROLL_STATE_DRAGGING, "", "latestDragSeekTime", "", "logTag", "", "getDataJob", "Lkotlinx/coroutines/Job;", "isSelected", "isDataLoaded", "hasDetachedFromWindow", "currentPos", "", "containsAudio", "Ljava/lang/Boolean;", "hasReportedVideoPause", "appBackGroundListener", "Lcom/larus/gallery/adapter/GalleryVideoHolder$Companion$WeakAppBackgroundListener;", "showVideoControlButtons", "updateMediaCanvas", "", "width", "height", "topMargin", "updateMediaCanvas$gallery_mainlandRelease", "canResumeOnForeground", "bind", "data", "position", "getContentBoundsOnScreen", "outBounds", "Landroid/graphics/RectF;", "initVideoView", "reportVideoPauseIfNeeded", "notifyVideoPlayStart", "Lcom/larus/platform/model/video/VideoPlayData;", "isAutoPlay", "initSeekbar", "initRetryView", "initPlayControl", "togglePlaybackByUser", "togglePlaybackByUser$gallery_mainlandRelease", "refreshButtonState", "isPlaying", "initAudioControl", "refreshMutedState", "isMuted", "loadVideo", "startAfterDataReady", "videoPlayData", "onReady", "Lkotlin/Function0;", "requestVideoModel", "onNext", "Lkotlin/Function1;", "onPageSelect", "onPageUnselect", "onViewAttachedToWindow", "onViewDetachedFromWindow", "onViewHolderStop", "onViewHolderResume", "getVideoPlayView", "Lcom/larus/gallery/adapter/ui/GalleryVideoPlayView;", "resumeCurrentVideo", "onAppBackground", "onAppForeground", "Companion", "gallery_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GalleryVideoHolder extends TransitionViewHolder implements t, q, com.larus.gallery.adapter.a {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f343678s = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LarusGalleryVideoViewBinding f343679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CoroutineScope f343680c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r f343681d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.larus.gallery.api.b f343682e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.larus.gallery.api.k f343683f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f343684g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f343685h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f343686i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Job f343687j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f343688k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f343689l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f343690m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f343691n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Boolean f343692o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f343693p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final b.a f343694q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f343695r;

    public static final class a implements l19.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GalleryVideoHolder f343696a;

        @Override // l19.f
        public final void onTransitionChanged(int r100, float r101) {
        }

        public a(GalleryVideoHolder r100) {
            this.f343696a = r100;
        }

        @Override // l19.f
        public final void onTransitionBegin(int r100) {
            e1.o(this.f343696a.f343679b.f343977e);
        }

        @Override // l19.f
        public final void onTransitionEnd(int r100) {
            e1.x(this.f343696a.f343679b.f343977e);
            if (r100 != 2) goto L6;
            this.f343696a.f343679b.f343974b.setVisibility(8);
            return;
        }
    }

    public static final class b {

        public static final class a implements f09.a.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final WeakReference<GalleryVideoHolder> f343697a;

            @Override // f09.a.b
            public final void onAllActivityDestroyed() {
            }

            @Override // f09.a.b
            public final void onAppBackground() {
                GalleryVideoHolder r100 = this.f343697a.get();
                if (r100 == null) goto L6;
                VideoPlayView.z(r100.U3(), 0, 3);
                r100.W3(false);
                return;
            }

            @Override // f09.a.b
            public final void onAppForeground() {
                GalleryVideoHolder r100 = this.f343697a.get();
                if (r100 == null) goto L6;
                r100.Y3();
                return;
            }

            public a(GalleryVideoHolder r100) {
                Intrinsics.checkNotNullParameter(r100, "holder");
                this.f343697a = new WeakReference(r100);
            }
        }
    }

    static {
    }

    @Override // com.larus.gallery.adapter.t
    public final void G3() {
        this.f343688k = false;
        FLogger.f375446a.i(this.f343686i, "[onPageUnselect]");
        U3().N();
        Job r100 = this.f343687j;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.f343687j = null;
        this.f343679b.f343974b.setIsPageSelected(false);
    }

    @Override // com.larus.gallery.adapter.t
    public final void onViewAttachedToWindow() {
    }

    @Override // com.larus.gallery.adapter.t
    public final void onViewDetachedFromWindow() {
        this.f343688k = false;
        this.f343690m = true;
        FLogger.f375446a.i(this.f343686i, "[onViewDetachedFromWindow]");
        U3().N();
        GalleryVideoPlayView r100 = U3();
        r100.f327986k = 0.0f;
        r100.f327980g.setVisibility(0);
        r100.i(false);
        Job r101 = this.f343687j;
        if (r101 == null) goto L5;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L5:
        this.f343687j = null;
        this.f343679b.f343974b.setIsPageSelected(false);
        this.f343679b.f343974b.g();
        AppHost.f326268a.a().c(this.f343694q);
    }

    public final GalleryVideoPlayView U3() {
        return this.f343679b.f343974b.getVideoPlayView();
    }

    public final void Y3() {
        Context r100 = this.f343679b.f343973a.getContext();
        if (r100 == null) goto L20;
        Activity r101 = com.larus.utils.i.getActivity(r100);
        if (r101 == null) goto L20;
        AppHost.Companion r102 = AppHost.f326268a;
        Activity r103 = r102.a().getCurrentActivity();
        if (r103 == null) goto L20;
        if (r101.isFinishing() == true) goto L20;
        if (r101.isDestroyed() == true) goto L20;
        if (r102.a().isAppBackground() == true) goto L20;
        if (r101 != r103) goto L20;
        boolean r104 = true;
    L21:
        if (r104 == true) goto L23;
        return;
    L23:
        VideoPlayView.H(U3(), 0, 3);
        x19.a.f562148a = true;
        com.larus.gallery.api.k r105 = this.f343683f;
        if (r105 == null) goto L28;
        com.larus.gallery.api.q r106 = r105.f343861c;
        if (r106 == null) goto L28;
        nr9.g r107 = r106.f343890b;
    L29:
        V3(r107, true);
        W3(true);
        return;
    L28:
        r107 = null;
    L20:
        r104 = false;
        goto L21
    }

    public final void Z3() {
        if (this.f343689l == true) goto L5;
        return;
    L5:
        boolean r100 = U3().r();
        if (r100 == false) goto L8;
        VideoPlayView.z(U3(), 0, 3);
    L15:
        W3(!r100);
        return;
    L8:
        VideoPlayView.H(U3(), 0, 3);
        x19.a.f562148a = false;
        com.larus.gallery.api.k r101 = this.f343683f;
        if (r101 == null) goto L13;
        com.larus.gallery.api.q r102 = r101.f343861c;
        if (r102 == null) goto L13;
        nr9.g r103 = r102.f343890b;
    L14:
        V3(r103, false);
    L13:
        r103 = null;
        goto L14
    }

    @Override // com.larus.gallery.adapter.t
    public final void a0() {
        if (this.f343688k == false) goto L5;
        return;
    L5:
        this.f343688k = true;
        r r100 = this.f343681d;
        if (r100 == null) goto L8;
        boolean r101 = r100.k();
    L9:
        FLogger r102 = FLogger.f375446a;
        r102.i(this.f343686i, "[onPageSelect] isDataLoaded:" + this.f343689l + " isMuted:" + r101 + ' ' + U3().hashCode());
        if (this.f343689l == true) goto L12;
    L20:
        this.f343679b.f343974b.setIsPageSelected(true);
        return;
    L12:
        if (U3().r() == true) goto L20;
        r102.i(this.f343686i, "[onPageSelect] start play");
        boolean r103 = x19.a.f562148a;
        x19.a.f562148a = true;
        com.larus.gallery.api.k r104 = this.f343683f;
        if (r104 == null) goto L18;
        com.larus.gallery.api.q r105 = r104.f343861c;
        if (r105 == null) goto L18;
        nr9.g r106 = r105.f343890b;
    L19:
        V3(r106, true);
        U3().M();
        U3().setIsMuted(r101);
        X3(r101);
    L18:
        r106 = null;
        goto L19
    L8:
        r101 = false;
        goto L9
    }

    @Override // com.larus.gallery.adapter.q
    public final void c3() {
        VideoPlayView.z(U3(), 0, 3);
        W3(false);
    }

    @Override // com.larus.gallery.adapter.q
    public final void onViewHolderResume() {
        Y3();
    }

    public final void W3(boolean r100) {
        ImageView r101 = this.f343679b.f343976d;
        if (r100 == false) goto L5;
        int r102 = R.drawable.larus_ic_video_pause;
    L6:
        r101.setImageResource(r102);
        return;
    L5:
        r102 = R.drawable.larus_ic_video_play;
        goto L6
    }

    public final void X3(boolean r100) {
        Boolean r101 = this.f343692o;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.booleanValue() == false) goto L9;
        if (r100 == false) goto L8;
        this.f343679b.f343975c.setImageResource(R.drawable.larus_ic_video_audio_mute);
        return;
    L8:
        this.f343679b.f343975c.setImageResource(R.drawable.larus_ic_video_audio_play);
        return;
    L9:
        this.f343679b.f343975c.setImageResource(R.drawable.larus_ic_video_audio_disable);
    }

    @Override // com.larus.gallery.adapter.a
    public final boolean c0(RectF r100) {
        Intrinsics.checkNotNullParameter(r100, "outBounds");
        View r101 = this.f343679b.f343974b.getScalableView();
        this.f343679b.f343974b.a(r100);
        if (r100.isEmpty() == false) goto L5;
        return false;
    L5:
        int[] r102 = new int[2];
        r101.getLocationOnScreen(r102);
        r100.offset(r102[0] + r101.getPaddingLeft(), r102[1] + r101.getPaddingTop());
        return true;
    }

    public final void V3(nr9.g r100, boolean r101) {
        this.f343693p = false;
        r r102 = this.f343681d;
        if (r102 == null) goto L6;
        r102.c(r100, r101);
        return;
    }

    public GalleryVideoHolder(LarusGalleryVideoViewBinding r110, CoroutineScope r111, r r112, com.larus.gallery.api.b r113, GalleryCenterStatusSaver r210) {
        Intrinsics.checkNotNullParameter(r110, "binding");
        super(r110.f343973a);
        this.f343679b = r110;
        this.f343680c = r111;
        this.f343681d = r112;
        this.f343682e = r113;
        this.f343686i = "GalleryVideoHolder" + hashCode();
        b.a r114 = new b.a(this);
        this.f343694q = r114;
        if (r113 != null) goto L5;
    L7:
        boolean r100 = false;
    L8:
        boolean r115 = !r100;
        this.f343695r = r115;
        TransitionLayout r101 = T3();
        if (r113 == null) goto L11;
        long r102 = r113.f343827g;
    L12:
        r101.setTransitionAnimationDuration(r102);
        TransitionLayout r103 = T3();
        if (r113 == null) goto L15;
        float r104 = r113.f343828h;
    L16:
        r103.setMaxDragTransitionFactor(r104);
        T3().setDelegateDragTransitionView(r110.f343974b);
        if (r113 == null) goto L22;
        com.larus.gallery.api.a r105 = r113.f343821a;
        if (r105 == null) goto L21;
        r110.f343974b.k(r105.f343817a, r105.f343818b, r105.f343819c, r111, r210);
    L21:
        GalleryVideoView r106 = r110.f343974b;
        boolean r107 = r113.f343824d;
        boolean r108 = r113.f343825e;
        com.larus.gallery.adapter.ui.p r109 = r106.f343729a;
        r109.f327671d = r107;
        r109.C = !r108;
    L22:
        final GalleryVideoPlayView r116 = r110.f343974b.getVideoPlayView();
        r116.setBackgroundColor(0);
        r116.setDiablePlayButton(true);
        r116.setForceUpdateProgress(true);
        if (r112 == null) goto L25;
        boolean r117 = r112.k();
    L26:
        r116.setIsMuted(r117);
        r116.i(false);
        r116.w(new h(this));
        r116.f327977d = new i(this, r116);
        PlayerProgressView r118 = r110.f343978f;
        r118.setSeekBarAlignToBottom(true);
        r118.k6(2000);
        r118.Y5(new g(), new m(this, r118), 2);
        r110.f343979g.setOnClickListener(new k(this));
        e1.d(r110.f343976d, new j(this));
        e1.d(r110.f343975c, new f(this));
        if (r115 == true) goto L29;
        e1.o(r110.f343976d);
        e1.o(r110.f343975c);
    L29:
        r110.f343974b.f343731c = r112;
        U3().setHeightChangedListener(new d(this));
        r110.f343974b.c(new a(this));
        AppHost.f326268a.a().j(r114);
        return;
    L25:
        r117 = false;
        goto L26
    L15:
        r104 = 0.1f;
        goto L16
    L11:
        r102 = 100;
        goto L12
    L5:
        if (r113.f343835o == true) goto L7;
        r100 = true;
        goto L8
    }
}
