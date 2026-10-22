package com.bytedance.ee.bear.drive.view.preview.video;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.drive.biz.preview.vc.DriveVCFollowVM;
import com.bytedance.ee.bear.drive.biz.preview.vc.connector.g;
import com.bytedance.ee.bear.drive.module.nativepreview.model.DriveComponentRenderVM;
import com.bytedance.ee.bear.drive.view.preview.block.DriveBlockPreviewVM;
import com.bytedance.ee.bear.drive.view.preview.capture.DriveCaptureVM;
import com.bytedance.ee.bear.drive.view.preview.media.DriveMediaVM;
import com.bytedance.ee.bear.drive.view.preview.video.player.w;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.VideoPreviewView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.bytedance.ee.bear.drive.view.preview.wrapper.a0;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.bytedance.ee.bear.drive.view.widget.ProgressBar;
import com.bytedance.ee.bear.middleground.drive.export.player.view.VideoSurfaceView;
import com.bytedance.ee.drive.preview.f;
import com.bytedance.ee.util.ui.m;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.videoarch.strategy.dataCenter.strategyData.HistoryTableOperate;
import ea5.b0;
import ea5.c0;
import ea5.d0;
import ea5.e0;
import ea5.f0;
import ea5.g0;
import ea5.j0;
import ea5.l0;
import ea5.m0;
import ea5.n0;
import ea5.v;
import ea5.y;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes16.dex */
public class VideoView extends FrameLayout implements sf5.a, ea5.a, h95.a, o65.a, m85.a {
    public static final /* synthetic */ int P = 0;
    public DriveComponentRenderVM A;
    public DriveMediaVM B;
    public DriveBlockPreviewVM C;
    public DriveCaptureVM D;
    public boolean E;
    public int F;
    public boolean G;
    public boolean H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f225499J;
    public boolean K;
    public h65.a L;
    public j0 M;
    public c N;
    public final a O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f225500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f225501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public VideoSurfaceView f225502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public VideoPlayerContentView f225503d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public VideoPlayerControllerView f225504e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f225505f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f225506g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f225507h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f225508i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f225509j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f225510k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f225511l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f225512m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f225513n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f225514o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public g f225515p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public w f225516q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public o65.a.InterfaceC7020a f225517r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final CompositeDisposable f225518s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f225519t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f225520u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public d f225521v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public PreviewViewModel f225522w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ViewOwner f225523x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f225524y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public b f225525z;

    public class a implements u95.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoView f225526a;

        @Override // u95.a
        public final void a() {
            this.f225526a.b();
            this.f225526a.t();
        }

        @Override // u95.a
        public final void c() {
            w r100 = this.f225526a.f225516q;
            if (r100 != null) goto L6;
            tt5.a.h("DRIVE_VideoPlayer", "onMediaResourceMutexSuccess skip, player is null");
            return;
        L6:
            r100.start();
            this.f225526a.B.getStartMedia().postValue(Boolean.TRUE);
        }

        @Override // u95.a
        public final void d() {
            w r100 = this.f225526a.f225516q;
            if (r100 != null) goto L6;
            tt5.a.h("DRIVE_VideoPlayer", "onMediaResourceInterruptionEnd skip, player is null");
            return;
        L6:
            r100.start();
            this.f225526a.B.getStartMedia().postValue(Boolean.TRUE);
        }

        public a(VideoView r100) {
            this.f225526a = r100;
        }

        @Override // u95.a
        public final void b(final String r100) {
            this.f225526a.H = false;
            if (TextUtils.isEmpty(r100) == true) goto L5;
            final VideoView r101 = this.f225526a;
            r101.getClass();
            m.a(new c0(r101, r100));
            return;
        L5:
            w r102 = this.f225526a.f225516q;
            if (r102 != null) goto L9;
            tt5.a.h("DRIVE_VideoPlayer", "onMediaResourceMutexFail skip start, player is null");
            return;
        L9:
            r102.start();
            this.f225526a.B.getStartMedia().postValue(Boolean.TRUE);
        }
    }

    public interface b {
    }

    public interface c {
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f225527a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f225528b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final LinkedHashMap<String, String> f225529c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final z f225530d;

        public d(String r100, String r101, LinkedHashMap<String, String> r102, z r103) {
            LinkedHashMap<String, String> r104 = new LinkedHashMap();
            this.f225529c = r104;
            this.f225527a = r100;
            this.f225528b = r101;
            if (hu5.a.e(r102) == true) goto L5;
            r104.putAll(r102);
        L5:
            this.f225530d = r103;
        }
    }

    @Override // m85.a
    public String getReleaseKey() {
        return "VideoView";
    }

    public void k(d r100) {
    }

    public final boolean m() {
    L7:
        e = move-exception;
        tt5.a.d("DRIVE_VideoPlayer", "isCurrentPortrait fail:" + e);
        return false;
    L4:
        if ((getContext() instanceof Activity) == false) goto L12;
        Activity r100 = (Activity) getContext();     // Catch: Exception -> L7
        int r101 = com.bytedance.ee.bear.drive.biz.preview.orientation.a.f223672a;     // Catch: Exception -> L7
        return com.bytedance.ee.bear.drive.biz.preview.orientation.a.C3208a.b(r100);
    L12:
        return false;
    }

    public final void d() {
        if (this.f225499J == true) goto L6;
        tt5.a.h("DRIVE_VideoPlayer", "enterFullScreen blocked, videoLandscapeEnabled=false, horizontalVideo=" + o() + ", currentMode=" + this.f225500a);
        return;
    L6:
        h65.a r100 = this.L;
        if (r100 == null) goto L10;
        r100.f483921c.b(r100.f483920b);
        return;
    }

    public final void f() {
        VideoPlayerControllerView r100 = this.f225504e;
        r100.f225493w = true;
        r100.f225474d.setVideoControlBarClearScreen(true);
        r100.q();
        r100.B.c();
        this.f225504e.g();
    }

    public int getBarsShowState() {
        return this.f225504e.getBarsShowState();
    }

    @Override // o65.a
    public long getCurrentTime() {
        w r100 = this.f225516q;
        if (r100 == null) goto L12;
        int r101 = this.f225512m;
        if (r101 < 3) goto L12;
        if (r101 == 5) goto L12;
        return r100.getCurrentPosition() / 1000;
    L12:
        return ((long) this.f225507h) / 1000;
    }

    @Override // o65.a
    public int getPlayState() {
        int r100 = this.f225512m;
        if (r100 == 1) goto L14;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L14;
        if (r100 != 4) goto L10;
        return 1;
    L10:
        if (r100 == 5) goto L12;
        return 4;
    L12:
        return 3;
    L14:
        return 2;
    }

    public final boolean l() {
        if (this.f225514o == false) goto L5;
    L7:
        return false;
    L5:
        if (this.B.isAutoPlay() == false) goto L7;
        return true;
    }

    public final boolean n() {
        Boolean r100 = ((DriveVCFollowVM) this.f225523x.viewModel(DriveVCFollowVM.class)).getLiveIsReplay().getValue();
        if (this.f225514o == true) goto L5;
    L7:
        return false;
    L5:
        if (Boolean.TRUE.equals(r100) == false) goto L7;
        return true;
    }

    public final boolean o() {
        if ((this.f225508i * 3) <= (this.f225509j * 4)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        PreviewViewModel r100 = this.f225522w;
        if (r100 != null) goto L5;
    L8:
        super.onDetachedFromWindow();
        if (this.A.needBindReleaseListener() == true) goto L12;
        onRelease();
        return;
    L12:
        return;
    L5:
        if (r100.isBlockViewChanging() == false) goto L8;
        tt5.a.h("DRIVE_VideoPlayer", "onDetachedFromWindow() isBlockViewChanging");
    }

    public void onRelease() {
        PreviewViewModel r100 = this.f225522w;
        if (r100 != null) goto L5;
    L7:
        b();
        DriveBlockPreviewVM r101 = this.C;
        if (r101 == null) goto L10;
        r101.removeBlockClickInterceptor(this);
    L10:
        DriveMediaVM r102 = this.B;
        if (r102 != null) goto L13;
    L15:
        w r103 = this.f225516q;
        if (r103 == null) goto L21;
        tt5.a.h("TTPlayer", "ttPlayer removeEventListener");
        r103.f225558d.remove(this);
        if (hu5.a.d(r103.f225558d) == false) goto L20;
        r103.f225557c = null;
    L20:
        this.f225516q.release();
        this.f225516q = null;
    L21:
        ((DriveVCFollowVM) this.f225523x.viewModel(DriveVCFollowVM.class)).getLiveIsMuted().removeObserver(this.M);
        return;
    L13:
        if (this.f225516q == null) goto L15;
        r102.getPlayPosition().setValue(Long.valueOf(this.f225516q.getCurrentPosition()));
        this.B.getStartMedia().setValue(Boolean.FALSE);
        this.f225516q.getCurrentPosition();
        p();
        goto L15
    L5:
        if (r100.isBlockViewChanging() == false) goto L7;
    }

    @Override // sf5.a
    public final void onRenderStart() {
        tt5.a.h("DRIVE_VideoPlayer", "VideoView.onRenderStart(). auto play");
        if (this.f225504e == null) goto L8;
        if (l() == false) goto L8;
        this.f225504e.setPlayState(true);
    L8:
        if (this.I == true) goto L10;
        this.f225503d.setEmptyViewVisibility(8);
    L16:
        VideoPlayerContentView r100 = this.f225503d;
        if (this.D.getInCapture().getValue() != null) goto L19;
    L21:
        boolean r101 = false;
    L22:
        r100.b(r101);
        this.f225524y = true;
        post(new v(this));
        if (this.E == false) goto L25;
    L29:
        Long r102 = this.B.getResumePosition().getValue();
        if (r102 == null) goto L33;
        tt5.a.h("DRIVE_VideoPlayer", "onRenderStart() resumePosition=" + r102);
        this.f225516q.seekTo(r102.longValue());
        r102.longValue();
        p();
        this.B.getResumePosition().setValue(null);
        return;
    L33:
        return;
    L25:
        if (l() == true) goto L29;
        if (this.f225502c == null) goto L29;
        this.E = true;
        post(new b0(this));
        goto L29
    L19:
        if (this.D.getInCapture().getValue().booleanValue() == false) goto L21;
        r101 = true;
        goto L22
    L10:
        VideoPlayerControllerView r103 = this.f225504e;
        if (r103 == null) goto L13;
        r103.setRootViewClickable(true);
    L13:
        VideoPlayerContentView r104 = this.f225503d;
        if (r104 == null) goto L16;
        r104.setRootViewClickable(true);
        goto L16
    }

    public final void p() {
        o65.a.InterfaceC7020a r100 = this.f225517r;
        if (r100 == null) goto L6;
        tt5.a.b("CCMFollow_VideoVCFollowConnector", "VideoActionStateListener onCurrentTimeChanged: ");
        ((l65.a.C6654a) ((o65.b.a) r100).f522201a).b();
        return;
    }

    public void play() {
        tt5.a.h("DRIVE_VideoPlayer", "start play video");
        PreviewViewModel r100 = this.f225522w;
        if (r100 == null) goto L5;
        r100.liveInnerReportMsg().a(new a0(11));
    L5:
        int r101 = this.f225512m;
        if (r101 == 1) goto L8;
    L10:
        if (r101 != 1) goto L12;
        tt5.a.h("DRIVE_VideoPlayer", "start loading resources");
        u(this.f225505f);
        return;
    L12:
        tt5.a.h("DRIVE_VideoPlayer", "resource is ready, play video");
        y();
        return;
    L8:
        if (this.f225505f != null) goto L10;
    }

    public final void q() {
        o65.a.InterfaceC7020a r100 = this.f225517r;
        if (r100 == null) goto L6;
        tt5.a.b("CCMFollow_VideoVCFollowConnector", "VideoActionStateListener onCurrentPlayModeChanged: ");
        ((l65.a.C6654a) ((o65.b.a) r100).f522201a).b();
        return;
    }

    public final void r() {
        o65.a.InterfaceC7020a r100 = this.f225517r;
        if (r100 == null) goto L6;
        tt5.a.b("CCMFollow_VideoVCFollowConnector", "VideoActionStateListener onPlayStateChanged: ");
        ((l65.a.C6654a) ((o65.b.a) r100).f522201a).b();
        return;
    }

    public final void s() {
        o65.a.InterfaceC7020a r100 = this.f225517r;
        if (r100 == null) goto L6;
        o65.b.a r101 = (o65.b.a) r100;
        r101.getClass();
        tt5.a.b("CCMFollow_VideoVCFollowConnector", "VideoActionStateListener onUsersClick: ");
        ((l65.a.C6654a) r101.f522201a).a();
        return;
    }

    public final void t() {
        tt5.a.h("DRIVE_VideoPlayer", "start pause video");
        w r100 = this.f225516q;
        if (r100 != null) goto L6;
        tt5.a.h("DRIVE_VideoPlayer", "pause skip, player is null");
        this.B.getStartMedia().postValue(Boolean.FALSE);
        return;
    L6:
        r100.pause();
        this.B.getStartMedia().postValue(Boolean.FALSE);
    }

    public final void v() {
        if (this.f225516q != null) goto L6;
        tt5.a.h("DRIVE_VideoPlayer", "releasePlayerForCacheRecovery skip, player is null");
        return;
    L6:
        tt5.a.h("DRIVE_VideoPlayer", "releasePlayerForCacheRecovery");
        b();
        w r100 = this.f225516q;
        r100.getClass();
        tt5.a.h("TTPlayer", "ttPlayer removeEventListener");
        r100.f225558d.remove(this);
        if (hu5.a.d(r100.f225558d) == false) goto L9;
        r100.f225557c = null;
    L9:
        this.f225516q.release();
        this.f225516q = null;
        this.f225512m = 1;
    }

    public final void x() {
        VideoPlayerControllerView r100 = this.f225504e;
        r100.f225493w = false;
        r100.f225474d.setVideoControlBarClearScreen(false);
        r100.q();
        r100.B.e();
        this.f225504e.o();
    }

    public final void y() {
        w r100 = this.f225516q;
        if (r100 != null) goto L7;
        tt5.a.h("DRIVE_VideoPlayer", "start skip, player is null");
        return;
    L7:
        if (this.H == false) goto L9;
        r100.start();
        this.B.getStartMedia().postValue(Boolean.TRUE);
        return;
    L9:
        this.H = true;
        this.B.tryPlayVideo(this.O);
    }

    public final void b() {
        r();
        this.f225518s.clear();
    }

    @Override // h95.a
    public final void c() {
        int r100 = getBarsShowState();
        tt5.a.h("DRIVE_VideoPlayer", "onClick()...barsShowState=" + r100);
        if (r100 != 1) goto L5;
        x();
        return;
    L5:
        if (r100 != 0) goto L9;
        f();
        return;
    }

    public final void z() {
        r();
        this.f225518s.add(Flowable.interval(0, 100, TimeUnit.MILLISECONDS).takeWhile(new n0(this)).subscribe(new l0(this), new m0()));
    }

    public int getCurrentPlayMode() {
        return this.f225500a;
    }

    public FrameLayout getViewContainer() {
        return this.f225501b;
    }

    public VideoView(Context r100) {
        super(r100);
        this.f225500a = 0;
        this.f225512m = 1;
        this.f225513n = 1;
        this.f225518s = new CompositeDisposable();
        this.f225519t = "";
        this.f225520u = "";
        this.f225524y = false;
        this.G = true;
        this.H = false;
        this.I = false;
        this.f225499J = true;
        this.K = false;
        this.O = new a(this);
        g(r100);
    }

    public final void e(int r100) {
        if (this.f225512m != 4) goto L8;
        if (r100 == 0) goto L8;
        this.f225513n = 4;
        post(new d0(this));
        return;
    L8:
        if (this.f225513n != 4) goto L12;
        if (r100 != 0) goto L13;
        this.f225513n = 1;
        post(new e0(this));
        return;
    L13:
        return;
    }

    public final void g(Context r100) {
        tt5.a.h("DRIVE_VideoPlayer", "add view container in current view");
        this.f225501b = new FrameLayout(r100);
        FrameLayout.LayoutParams r101 = new FrameLayout.LayoutParams(-1, -1);
        addView(this.f225501b, r101);
        this.I = com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.drive.mobile.play_origin_video");
    }

    @Override // sf5.a
    public final void h(int r100) {
        tt5.a.h("DRIVE_VideoPlayer", "VideoView.onPlayerStateChanged(). playerState = " + r100);
        this.f225512m = r100;
        VideoPlayerControllerView r101 = this.f225504e;
        if (r101 != null) goto L6;
        tt5.a.d("DRIVE_VideoPlayer", "onPlayerStateChanged failed, mControllerView == null");
        b();
        return;
    L6:
        r101.setPlayerState(r100);
        if (r100 != 3) goto L13;
        tt5.a.h("DRIVE_VideoPlayer", "video status is ready");
        g r102 = this.f225515p;
        if (r102 == null) goto L11;
        r102.onViewReady();
    L11:
        int r103 = (int) this.f225516q.k();
        this.f225506g = r103;
        this.f225504e.setProgressbarMaxLength(r103);
        b();
        return;
    L13:
        if (r100 != 4) goto L22;
        s();
        tt5.a.h("DRIVE_VideoPlayer", " current mode is play, start timer");
        this.f225504e.o();
        if (this.f225506g > 0) goto L17;
        int r104 = (int) this.f225516q.k();
        this.f225506g = r104;
        this.f225504e.setProgressbarMaxLength(r104);
        tt5.a.h("DRIVE_VideoPlayer", "set mVideoLength in play state length=" + this.f225506g);
    L17:
        this.f225507h = (int) this.f225516q.getCurrentPosition();
        p();
        if (this.f225512m == 4) goto L20;
        tt5.a.h("DRIVE_VideoPlayer", "mPlayerState != IPlayer.STATE_PLAYING, return");
        return;
    L20:
        z();
        return;
    L22:
        if (r100 != 5) goto L38;
        tt5.a.h("DRIVE_VideoPlayer", "video play finished, curPoint = " + this.f225516q.getCurrentPosition() + ", totalLength = " + this.f225516q.k());
        s();
        this.f225504e.g();
        if (this.f225520u.equals(this.f225519t) == false) goto L29;
        tt5.a.h("DRIVE_VideoPlayer", "auto stop, do not change resolution");
        p();
        this.f225504e.setProgress(this.f225506g);
        this.f225504e.setPlayState(false);
        if (this.f225522w == null) goto L28;
        HashMap r105 = new HashMap();
        r105.put(HistoryTableOperate.HISTORY_PLAY_TIME, Long.valueOf(this.f225516q.getCurrentPosition()));
        this.f225522w.liveInnerReportMsg().a(new a0(12, r105));
    L28:
        b();
    L29:
        DriveBlockPreviewVM.BlockState r106 = this.C.getLiveBlockState().getValue();
        if (r106 != null) goto L32;
    L36:
        this.f225520u = this.f225519t;
        return;
    L32:
        if (TextUtils.equals(this.f225520u, this.f225519t) == false) goto L36;
        this.f225516q.seekTo(0);
        t();
        p();
        if (r106 != DriveBlockPreviewVM.BlockState.BLOCK) goto L36;
        this.f225504e.l(true);
        goto L36
    L38:
        if (r100 != 2) goto L40;
        s();
        tt5.a.h("DRIVE_VideoPlayer", "current mode is buffering destroy timer");
        this.f225504e.g();
        b();
        return;
    L40:
        if (r100 != 1) goto L48;
        b();
        return;
    }

    /* JADX WARN: Type inference failed for: r7v2, types: [ea5.j0] */
    public void i(d r100) {
        tt5.a.h("", "init video data");
        this.f225521v = r100;
        this.F = 0;
        this.f225504e.setFileModel(r100.f225530d);
        if (this.f225514o == false) goto L5;
        VideoPlayerControllerView r101 = this.f225504e;
        r101.getClass();
        int r102 = n.d(4);
        int r103 = n.d(8);
        FrameLayout.LayoutParams r104 = (FrameLayout.LayoutParams) r101.f225477g.getLayoutParams();
        r104.leftMargin += r103;
        r104.topMargin += r103;
        r104.rightMargin += r103;
        r104.bottomMargin += r103;
        r101.f225477g.setLayoutParams(r104);
        ProgressBar r105 = r101.f225474d;
        r105.setPadding(r105.getPaddingStart() + r102, r101.f225474d.getPaddingTop(), r101.f225474d.getPaddingEnd(), r101.f225474d.getPaddingBottom() + r103);
    L5:
        this.f225516q = new w(getContext());
        VideoSurfaceView r106 = this.f225502c;
        tt5.a.h("DRIVE_VideoPlayer", "initPlayer... ");
        this.f225516q.l(r106);
        this.f225516q.i(this);
        VideoPlayerControllerView r107 = this.f225504e;
        r107.f225472b = this.f225516q;
        r107.f225473c = this;
        ((DriveBlockPreviewVM) this.f225523x.viewModel(DriveBlockPreviewVM.class)).getLiveBlockState().observe(this.f225523x.lifecycleOwner(), new y(this));
        this.f225516q.f225561g = r100.f225528b;
        this.M = new j0(this);
        ((DriveVCFollowVM) this.f225523x.viewModel(DriveVCFollowVM.class)).getLiveIsMuted().observe(this.f225523x.lifecycleOwner(), this.M);
    }

    /* JADX WARN: Type inference failed for: r1v9, types: [ea5.z] */
    @Override // sf5.a
    public final void j(final Exception r100) {
        final boolean r101 = false;
        tt5.a.e("DRIVE_VideoPlayer", "VideoView.onPlayerError(). hasRenderStart: " + this.f225524y, r100, false);
        boolean r102 = com.bytedance.ee.bear.appsetting.c.a.f206237a.f("ccm.drive.mobile.video_mdl_cache_recovery_enable");
        tt5.a.h("DRIVE_VideoPlayer", "isMdlCacheRecoveryEnabled, enabled=" + r102);
        boolean r103 = true;
        if (r102 == true) goto L5;
    L49:
        StringBuilder r104 = new StringBuilder("tryRecoverFromMdlCacheError skip, hasRenderStart=");
        r104.append(this.f225524y);
        r104.append(", retryCount=");
        r104.append(this.F);
        r104.append(", maxRetryCount=1, handlerNull=");
        if (this.N != null) goto L52;
        boolean r105 = true;
    L53:
        r104.append(r105);
        r104.append(", videoEntityNull=");
        if (this.f225521v != null) goto L56;
        boolean r106 = true;
    L57:
        r104.append(r106);
        r104.append(", playerNull=");
        if (this.f225516q != null) goto L60;
        boolean r107 = true;
    L61:
        r104.append(r107);
        r104.append(", cacheKeyEmpty=");
        d r108 = this.f225521v;
        if (r108 != null) goto L64;
    L67:
        r104.append(r103);
        r104.append(", error=");
        r104.append(r100);
        tt5.a.h("DRIVE_VideoPlayer", r104.toString());
    L68:
        if (r101 == false) goto L71;
        return;
    L71:
        if (this.f225524y == false) goto L76;
        w r109 = this.f225516q;
        r109.getClass();
        tt5.a.h("TTPlayer", "ttPlayer reset... ");
        if (r109.f225555a.getPlaybackState() == 0) goto L75;
        tt5.a.h("TTPlayer", "ttPlayer reset, stop playing");
        r109.stop();
    L75:
        this.B.getStartMedia().postValue(Boolean.FALSE);
        r();
    L79:
        post(new g0(this, r100));
        return;
    L76:
        PreviewViewModel r110 = this.f225522w;
        if (r110 == null) goto L79;
        r110.getLiveInnerShowPreviewFailedPage().postValue(null);
        goto L79
    L64:
        if (TextUtils.isEmpty(r108.f225528b) == true) goto L67;
        r103 = false;
        goto L67
    L60:
        r107 = false;
        goto L61
    L56:
        r106 = false;
        goto L57
    L52:
        r105 = false;
        goto L53
    L5:
        if (this.f225524y == true) goto L49;
        if (this.F >= 1) goto L49;
        if (this.N == null) goto L49;
        d r111 = this.f225521v;
        if (r111 == null) goto L49;
        if (this.f225516q == null) goto L49;
        if (TextUtils.isEmpty(r111.f225528b) == true) goto L49;
        if (TextUtils.isEmpty(this.f225521v.f225527a) == true) goto L26;
        String r112 = UriProtector.parse(this.f225521v.f225527a).getScheme();
        if ("http".equalsIgnoreCase(r112) == true) goto L24;
        if ("https".equalsIgnoreCase(r112) == false) goto L26;
    L24:
        if (this.f225521v.f225527a.contains("api/box/stream/sdk") == true) goto L26;
        boolean r113 = true;
    L27:
        if (r113 == false) goto L49;
        if (r100 != null) goto L30;
        String r114 = null;
    L32:
        if (TextUtils.isEmpty(r114) == false) goto L34;
    L38:
        boolean r115 = false;
    L39:
        if (r115 == false) goto L49;
        int r116 = this.f225512m;
        if (r116 != 2) goto L44;
    L47:
        r101 = true;
    L48:
        this.F++;
        tt5.a.h("DRIVE_VideoPlayer", "tryRecoverFromMdlCacheError, clear video cache and retry, shouldStartAfterRetry=" + r101 + ", retryCount=" + this.F);
        this.B.getStartMedia().postValue(Boolean.FALSE);
        v();
        c r117 = this.N;
        VideoPreviewView.f(((com.bytedance.ee.bear.drive.view.preview.wrapper.j0) r117).f225808a, new ea5.z(this, r101));
        r101 = true;
        goto L68
    L44:
        if (r116 == 4) goto L47;
        if (l() == false) goto L48;
    L34:
        if (r114.contains("-10006") == false) goto L36;
    L37:
        r115 = true;
        goto L39
    L36:
        if (r114.contains("-10008") == false) goto L38;
    L30:
        r114 = r100.toString();
    L26:
        r113 = false;
        goto L27
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r100) {
        super.onWindowVisibilityChanged(r100);
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.f("spacekit.mobile.drive.embed_enable") == false) goto L6;
        e(r100);
        return;
    }

    public void setCommunication(PreviewViewModel r100) {
        this.f225522w = r100;
    }

    public void setCurrentPlayMode(int r100) {
        boolean r101 = false;
        if (this.f225509j != 0) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L17;
        StringBuilder r103 = new StringBuilder("isHeightOrWidthZero() is: ");
        if (this.f225509j != 0) goto L13;
    L14:
        r101 = true;
    L15:
        r103.append(r101);
        tt5.a.d("DRIVE_VideoPlayer", r103.toString());
        return;
    L13:
        if (this.f225508i != 0) goto L15;
    L17:
        this.f225500a = r100;
        this.f225504e.setVerticalVideoCurrentPlayMode(r100);
        return;
    L5:
        if (this.f225508i == 0) goto L8;
        r102 = false;
        goto L9
    }

    public void setCurrentPlayModeOrientation(int r100) {
        this.f225500a = r100;
    }

    public void setCurrentTime(float r100) {
        w r101 = this.f225516q;
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.f225512m < 2) goto L22;
        int r102 = (int) (r100 * 1000.0f);
        int r103 = this.f225506g;
        if (r103 <= 0) goto L16;
        if (r102 > r103) goto L16;
        if (Math.abs(this.f225507h - r102) < 2000) goto L13;
    L15:
        this.f225507h = r102;
        this.f225516q.seekTo(r102);
        this.f225504e.setProgress(r102);
        p();
        return;
    L13:
        if (Math.abs(this.f225504e.getProgress() - r102) >= 2000) goto L15;
        return;
    L16:
        if (r102 <= r103) goto L21;
        r101.seekTo(r103);
        this.f225504e.setProgress(this.f225506g);
        return;
    L21:
        return;
    }

    public void setCustomHeaders(Map<String, String> r100) {
        w r101 = this.f225516q;
        if (r101 == null) goto L6;
        r101.c(r100);
        return;
    }

    public void setReportCb(b r100) {
        this.f225525z = r100;
    }

    @Override // o65.a
    public void setVideoActionListener(o65.a.InterfaceC7020a r100) {
        this.f225517r = r100;
    }

    public void setVideoCacheRecoveryHandler(c r100) {
        this.N = r100;
    }

    public final void u(String r100) {
        tt5.a.h("DRIVE_VideoPlayer", "init video view status");
        if (this.f225512m == 1) goto L7;
        w r101 = this.f225516q;
        r101.getClass();
        tt5.a.h("TTPlayer", "ttPlayer reset... ");
        if (r101.f225555a.getPlaybackState() == 0) goto L7;
        tt5.a.h("TTPlayer", "ttPlayer reset, stop playing");
        r101.stop();
    L7:
        this.f225505f = r100;
        setCustomHeaders(((f) org.koin.java.a.a(f.class)).oc(r100));
        this.f225516q.b(UriProtector.parse(r100));
        if (l() == false) goto L10;
        this.f225504e.setSilent(false);
    L11:
        this.f225504e.setProgress(this.f225507h);
        return;
    L10:
        this.f225504e.setSilent(true);
        goto L11
    }

    public VideoView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f225500a = 0;
        this.f225512m = 1;
        this.f225513n = 1;
        this.f225518s = new CompositeDisposable();
        this.f225519t = "";
        this.f225520u = "";
        this.f225524y = false;
        this.G = true;
        this.H = false;
        this.I = false;
        this.f225499J = true;
        this.K = false;
        this.O = new a(this);
        g(r100);
    }

    @Override // o65.a
    public final void a(int r100, float r101) {
        setCurrentTime(r101);
        if (r100 == 1) goto L29;
        if (r100 == 2) goto L21;
        if (r100 == 3) goto L10;
        b();
        return;
    L10:
        if (this.f225514o == true) goto L12;
        return;
    L12:
        if (this.f225512m != 4) goto L39;
        b();
        t();
        if (this.f225504e == null) goto L40;
        DriveBlockPreviewVM r102 = this.C;
        if (r102 != null) goto L18;
        return;
    L18:
        if (r102.getLiveBlockState().getValue() != DriveBlockPreviewVM.BlockState.BLOCK) goto L42;
        this.f225504e.setPlayState(false);
        this.f225504e.l(true);
        return;
    L42:
        return;
    L40:
        return;
    L39:
        return;
    L21:
        if (this.f225514o == true) goto L23;
    L25:
        VideoPlayerControllerView r103 = this.f225504e;
        if (r103.B.f471610k == true) goto L44;
        r103.n();
        return;
    L44:
        return;
    L23:
        if (this.f225512m != 4) goto L25;
        b();
        t();
        goto L25
    L29:
        if (this.f225512m == 4) goto L46;
        DriveBlockPreviewVM.BlockState r104 = this.C.getLiveBlockState().getValue();
        if (r104 != null) goto L33;
    L35:
        z();
        play();
        return;
    L33:
        if (r104 == DriveBlockPreviewVM.BlockState.FULLSCREEN) goto L35;
        this.f225504e.n();
        goto L35
    }

    @Override // sf5.a
    public final void onVideoSizeChanged(int r100, int r101) {
        tt5.a.h("DRIVE_VideoPlayer", "VideoView.onVideoSizeChanged(). " + r100 + ", height = " + r101);
        this.f225508i = r100;
        this.f225509j = r101;
        boolean r102 = o();
        boolean r103 = false;
        if (this.C.getLiveBlockState().getValue() != DriveBlockPreviewVM.BlockState.BLOCK) goto L5;
        boolean r104 = true;
    L6:
        if (r102 == true) goto L8;
    L12:
        this.G = false;
        VideoPlayerControllerView r105 = this.f225504e;
        if (r105 == null) goto L39;
        if (r102 == false) goto L19;
        if (r104 == true) goto L19;
        if (this.f225499J == false) goto L19;
        boolean r106 = true;
    L20:
        ViewGroup r107 = r105.f225477g;
        if (r106 == true) goto L23;
    L25:
        boolean r108 = false;
    L27:
        if (r108 == false) goto L29;
        int r109 = 0;
    L30:
        r107.setVisibility(r109);
        if (r102 == true) goto L33;
    L37:
        this.f225504e.setEnterFullScreenButtonVisibility(8);
    L38:
        this.f225504e.setVisibility(0);
        goto L39
    L33:
        if (this.f225499J == false) goto L37;
        tt5.a.h("DRIVE_VideoPlayer", "horizontal video, if mode is normal show full screen button");
        if (this.f225500a != 0) goto L38;
        this.f225504e.setEnterFullScreenButtonVisibility(0);
        goto L38
    L29:
        r109 = 8;
        goto L30
    L23:
        if (r105.f225494x == false) goto L25;
        r108 = true;
    L19:
        r106 = false;
    L39:
        int r110 = this.f225511l;
        int r111 = this.f225510k;
        if (this.f225508i != 0) goto L42;
    L45:
        StringBuilder r112 = new StringBuilder("adjustSurfaceViewSize mVideoWidth == 0 ");
        if (this.f225508i != 0) goto L48;
        boolean r113 = true;
    L49:
        r112.append(r113);
        r112.append(" mVideoHeight == 0 ");
        if (this.f225509j != 0) goto L52;
        r103 = true;
    L52:
        r112.append(r103);
        tt5.a.d("DRIVE_VideoPlayer", r112.toString());
    L53:
        tt5.a.h("DRIVE_VideoPlayer", "onVideoSizeChanged, isBlockState: " + r104 + ", isCompactStyle: " + this.C.isCompactStyle() + ", isFollowingPresenter: " + n());
        if (r104 == true) goto L56;
        return;
    L56:
        if (this.C.isCompactStyle() == true) goto L58;
        return;
    L58:
        if (n() == true) goto L63;
        post(new f0(this));
        this.f225504e.l(true);
        return;
    L63:
        return;
    L48:
        r113 = false;
        goto L49
    L42:
        if (this.f225509j == 0) goto L45;
        w(r110, r111);
        this.f225502c.requestLayout();
        goto L53
    L8:
        if (this.f225500a != 1) goto L12;
        if (this.G == false) goto L12;
        this.f225522w.liveInnerToggleFullScreen().postValue(this.f225521v.f225530d.f225835c);
        this.f225500a = 0;
        this.f225504e.setVerticalVideoCurrentPlayMode(0);
        tt5.a.h("DRIVE_VideoPlayer", "horizontal video, if mode is fullScreen show");
        goto L12
    L5:
        r104 = false;
        goto L6
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        super.onVisibilityChanged(r100, r101);
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.f("spacekit.mobile.drive.embed_enable") == true) goto L6;
        e(r101);
        return;
    }

    public final void w(int r100, int r110) {
        int r101 = this.f225508i;
        if (r101 == 0) goto L13;
        int r102 = this.f225509j;
        if (r102 == 0) goto L13;
        if ((r101 / r102) <= (r110 / r100)) goto L10;
        int r103 = (int) (((double) (r102 * r110)) / ((double) r101));
        int r104 = r110;
    L11:
        FrameLayout.LayoutParams r105 = (FrameLayout.LayoutParams) this.f225502c.getLayoutParams();
        r105.width = r104;
        r105.height = r103;
        r105.gravity = 17;
        this.f225501b.measure(View.MeasureSpec.makeMeasureSpec(this.f225501b.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.f225501b.getMeasuredHeight(), 1073741824));
        this.f225501b.layout(getLeft(), getTop(), getRight(), getBottom());
        tt5.a.h("DRIVE_VideoPlayer", "setTextureViewParams() parentWidth=" + r110 + " parentHeight=" + r100 + " surfaceWidth=" + r104 + " surfaceHeight=" + r103);
        return;
    L10:
        r104 = (int) (((double) (r101 * r100)) / ((double) r102));
        r103 = r100;
    L13:
        StringBuilder r106 = new StringBuilder("setTextureViewParams mVideoWidth == 0? ");
        boolean r107 = true;
        if (this.f225508i != 0) goto L16;
        boolean r111 = true;
    L17:
        r106.append(r111);
        r106.append(" mVideoHeight == 0? ");
        if (this.f225509j == 0) goto L21;
        r107 = false;
    L21:
        r106.append(r107);
        tt5.a.d("DRIVE_VideoPlayer", r106.toString());
        return;
    L16:
        r111 = false;
        goto L17
    }

    public VideoView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f225500a = 0;
        this.f225512m = 1;
        this.f225513n = 1;
        this.f225518s = new CompositeDisposable();
        this.f225519t = "";
        this.f225520u = "";
        this.f225524y = false;
        this.G = true;
        this.H = false;
        this.I = false;
        this.f225499J = true;
        this.K = false;
        this.O = new a(this);
        g(r100);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f225510k = r100;
        this.f225511l = r101;
        w(r101, r100);
        this.f225502c.requestLayout();
    }
}
