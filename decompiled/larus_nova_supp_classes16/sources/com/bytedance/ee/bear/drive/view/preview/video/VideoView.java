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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
    public boolean J;
    public boolean K;
    public h65.a L;
    public j0 M;
    public c N;
    public final a O;
    public int a;
    public FrameLayout b;
    public VideoSurfaceView c;
    public VideoPlayerContentView d;
    public VideoPlayerControllerView e;
    public String f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public g p;
    public w q;
    public o65.a.InterfaceC0267a r;
    public final CompositeDisposable s;
    public String t;
    public String u;
    public d v;
    public PreviewViewModel w;
    public ViewOwner x;
    public boolean y;
    public b z;

    public class a implements u95.a {
        public final /* synthetic */ VideoView a;

        @Override // u95.a
        public final void a() {
            this.a.b();
            this.a.t();
        }

        @Override // u95.a
        public final void c() {
            w r0 = this.a.q;
            if (r0 != null) goto L6;
            tt5.a.h("DRIVE_VideoPlayer", "onMediaResourceMutexSuccess skip, player is null");
            return;
        L6:
            r0.start();
            this.a.B.getStartMedia().postValue(Boolean.TRUE);
        }

        @Override // u95.a
        public final void d() {
            w r0 = this.a.q;
            if (r0 != null) goto L6;
            tt5.a.h("DRIVE_VideoPlayer", "onMediaResourceInterruptionEnd skip, player is null");
            return;
        L6:
            r0.start();
            this.a.B.getStartMedia().postValue(Boolean.TRUE);
        }

        public a(VideoView r1) {
            this.a = r1;
        }

        @Override // u95.a
        public final void b(final String r3) {
            this.a.H = false;
            if (TextUtils.isEmpty(r3) == true) goto L5;
            final VideoView r0 = this.a;
            r0.getClass();
            m.a(new c0(r0, r3));
            return;
        L5:
            w r4 = this.a.q;
            if (r4 != null) goto L9;
            tt5.a.h("DRIVE_VideoPlayer", "onMediaResourceMutexFail skip start, player is null");
            return;
        L9:
            r4.start();
            this.a.B.getStartMedia().postValue(Boolean.TRUE);
        }
    }

    public interface b {
    }

    public interface c {
    }

    public static class d {
        public final String a;
        public String b;
        public final LinkedHashMap<String, String> c;
        public final z d;

        public d(String r2, String r3, LinkedHashMap<String, String> r4, z r5) {
            LinkedHashMap<String, String> r0 = new LinkedHashMap();
            this.c = r0;
            this.a = r2;
            this.b = r3;
            if (hu5.a.e(r4) == true) goto L5;
            r0.putAll(r4);
        L5:
            this.d = r5;
        }
    }

    @Override // m85.a
    public String getReleaseKey() {
        return "VideoView";
    }

    public void k(d r1) {
    }

    public final boolean m() {
    L7:
        e = move-exception;
        tt5.a.d("DRIVE_VideoPlayer", "isCurrentPortrait fail:" + e);
        return false;
    L4:
        if ((getContext() instanceof Activity) == false) goto L12;
        Activity r1 = (Activity) getContext();     // Catch: Exception -> L7
        int r2 = com.bytedance.ee.bear.drive.biz.preview.orientation.a.a;     // Catch: Exception -> L7
        return com.bytedance.ee.bear.drive.biz.preview.orientation.a.C0152a.b(r1);
    L12:
        return false;
    }

    public final void d() {
        if (this.J == true) goto L6;
        tt5.a.h("DRIVE_VideoPlayer", "enterFullScreen blocked, videoLandscapeEnabled=false, horizontalVideo=" + o() + ", currentMode=" + this.a);
        return;
    L6:
        h65.a r0 = this.L;
        if (r0 == null) goto L10;
        r0.c.b(r0.b);
        return;
    }

    public final void f() {
        VideoPlayerControllerView r0 = this.e;
        r0.w = true;
        r0.d.setVideoControlBarClearScreen(true);
        r0.q();
        r0.B.c();
        this.e.g();
    }

    public int getBarsShowState() {
        return this.e.getBarsShowState();
    }

    @Override // o65.a
    public long getCurrentTime() {
        w r0 = this.q;
        if (r0 == null) goto L12;
        int r3 = this.m;
        if (r3 < 3) goto L12;
        if (r3 == 5) goto L12;
        return r0.getCurrentPosition() / 1000;
    L12:
        return ((long) this.h) / 1000;
    }

    @Override // o65.a
    public int getPlayState() {
        int r0 = this.m;
        if (r0 == 1) goto L14;
        if (r0 == 2) goto L14;
        if (r0 == 3) goto L14;
        if (r0 != 4) goto L10;
        return 1;
    L10:
        if (r0 == 5) goto L12;
        return 4;
    L12:
        return 3;
    L14:
        return 2;
    }

    public final boolean l() {
        if (this.o == false) goto L5;
    L7:
        return false;
    L5:
        if (this.B.isAutoPlay() == false) goto L7;
        return true;
    }

    public final boolean n() {
        Boolean r0 = (Boolean) ((DriveVCFollowVM) this.x.viewModel(DriveVCFollowVM.class)).getLiveIsReplay().getValue();
        if (this.o == true) goto L5;
    L7:
        return false;
    L5:
        if (Boolean.TRUE.equals(r0) == false) goto L7;
        return true;
    }

    public final boolean o() {
        if ((this.i * 3) <= (this.j * 4)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        PreviewViewModel r0 = this.w;
        if (r0 != null) goto L5;
    L8:
        super.onDetachedFromWindow();
        if (this.A.needBindReleaseListener() == true) goto L12;
        onRelease();
        return;
    L12:
        return;
    L5:
        if (r0.isBlockViewChanging() == false) goto L8;
        tt5.a.h("DRIVE_VideoPlayer", "onDetachedFromWindow() isBlockViewChanging");
    }

    public void onRelease() {
        PreviewViewModel r0 = this.w;
        if (r0 != null) goto L5;
    L7:
        b();
        DriveBlockPreviewVM r1 = this.C;
        if (r1 == null) goto L10;
        r1.removeBlockClickInterceptor(this);
    L10:
        DriveMediaVM r2 = this.B;
        if (r2 != null) goto L13;
    L15:
        w r3 = this.q;
        if (r3 == null) goto L21;
        tt5.a.h("TTPlayer", "ttPlayer removeEventListener");
        r3.d.remove(this);
        if (hu5.a.d(r3.d) == false) goto L20;
        r3.c = null;
    L20:
        this.q.release();
        this.q = null;
    L21:
        ((DriveVCFollowVM) this.x.viewModel(DriveVCFollowVM.class)).getLiveIsMuted().removeObserver(this.M);
        return;
    L13:
        if (this.q == null) goto L15;
        r2.getPlayPosition().setValue(Long.valueOf(this.q.getCurrentPosition()));
        this.B.getStartMedia().setValue(Boolean.FALSE);
        this.q.getCurrentPosition();
        p();
        goto L15
    L5:
        if (r0.isBlockViewChanging() == false) goto L7;
    }

    public final void onRenderStart() {
        tt5.a.h("DRIVE_VideoPlayer", "VideoView.onRenderStart(). auto play");
        if (this.e == null) goto L8;
        if (l() == false) goto L8;
        this.e.setPlayState(true);
    L8:
        if (this.I == true) goto L10;
        this.d.setEmptyViewVisibility(8);
    L16:
        VideoPlayerContentView r1 = this.d;
        if (this.D.getInCapture().getValue() != null) goto L19;
    L21:
        boolean r3 = false;
    L22:
        r1.b(r3);
        this.y = true;
        post(new v(this));
        if (this.E == false) goto L25;
    L29:
        Long r2 = (Long) this.B.getResumePosition().getValue();
        if (r2 == null) goto L33;
        tt5.a.h("DRIVE_VideoPlayer", "onRenderStart() resumePosition=" + r2);
        this.q.seekTo(r2.longValue());
        r2.longValue();
        p();
        this.B.getResumePosition().setValue(null);
        return;
    L33:
        return;
    L25:
        if (l() == true) goto L29;
        if (this.c == null) goto L29;
        this.E = true;
        post(new b0(this));
        goto L29
    L19:
        if (((Boolean) this.D.getInCapture().getValue()).booleanValue() == false) goto L21;
        r3 = true;
        goto L22
    L10:
        VideoPlayerControllerView r4 = this.e;
        if (r4 == null) goto L13;
        r4.setRootViewClickable(true);
    L13:
        VideoPlayerContentView r5 = this.d;
        if (r5 == null) goto L16;
        r5.setRootViewClickable(true);
        goto L16
    }

    public final void p() {
        o65.a.InterfaceC0267a r0 = this.r;
        if (r0 == null) goto L6;
        tt5.a.b("CCMFollow_VideoVCFollowConnector", "VideoActionStateListener onCurrentTimeChanged: ");
        ((l65.a.C0248a) ((o65.b.a) r0).a).b();
        return;
    }

    public void play() {
        tt5.a.h("DRIVE_VideoPlayer", "start play video");
        PreviewViewModel r1 = this.w;
        if (r1 == null) goto L5;
        r1.liveInnerReportMsg().a(new a0(11));
    L5:
        int r2 = this.m;
        if (r2 == 1) goto L8;
    L10:
        if (r2 != 1) goto L12;
        tt5.a.h("DRIVE_VideoPlayer", "start loading resources");
        u(this.f);
        return;
    L12:
        tt5.a.h("DRIVE_VideoPlayer", "resource is ready, play video");
        y();
        return;
    L8:
        if (this.f != null) goto L10;
    }

    public final void q() {
        o65.a.InterfaceC0267a r0 = this.r;
        if (r0 == null) goto L6;
        tt5.a.b("CCMFollow_VideoVCFollowConnector", "VideoActionStateListener onCurrentPlayModeChanged: ");
        ((l65.a.C0248a) ((o65.b.a) r0).a).b();
        return;
    }

    public final void r() {
        o65.a.InterfaceC0267a r0 = this.r;
        if (r0 == null) goto L6;
        tt5.a.b("CCMFollow_VideoVCFollowConnector", "VideoActionStateListener onPlayStateChanged: ");
        ((l65.a.C0248a) ((o65.b.a) r0).a).b();
        return;
    }

    public final void s() {
        o65.a.InterfaceC0267a r0 = this.r;
        if (r0 == null) goto L6;
        o65.b.a r1 = (o65.b.a) r0;
        r1.getClass();
        tt5.a.b("CCMFollow_VideoVCFollowConnector", "VideoActionStateListener onUsersClick: ");
        ((l65.a.C0248a) r1.a).a();
        return;
    }

    public final void t() {
        tt5.a.h("DRIVE_VideoPlayer", "start pause video");
        w r1 = this.q;
        if (r1 != null) goto L6;
        tt5.a.h("DRIVE_VideoPlayer", "pause skip, player is null");
        this.B.getStartMedia().postValue(Boolean.FALSE);
        return;
    L6:
        r1.pause();
        this.B.getStartMedia().postValue(Boolean.FALSE);
    }

    public final void v() {
        if (this.q != null) goto L6;
        tt5.a.h("DRIVE_VideoPlayer", "releasePlayerForCacheRecovery skip, player is null");
        return;
    L6:
        tt5.a.h("DRIVE_VideoPlayer", "releasePlayerForCacheRecovery");
        b();
        w r0 = this.q;
        r0.getClass();
        tt5.a.h("TTPlayer", "ttPlayer removeEventListener");
        r0.d.remove(this);
        if (hu5.a.d(r0.d) == false) goto L9;
        r0.c = null;
    L9:
        this.q.release();
        this.q = null;
        this.m = 1;
    }

    public final void x() {
        VideoPlayerControllerView r0 = this.e;
        r0.w = false;
        r0.d.setVideoControlBarClearScreen(false);
        r0.q();
        r0.B.e();
        this.e.o();
    }

    public final void y() {
        w r0 = this.q;
        if (r0 != null) goto L7;
        tt5.a.h("DRIVE_VideoPlayer", "start skip, player is null");
        return;
    L7:
        if (this.H == false) goto L9;
        r0.start();
        this.B.getStartMedia().postValue(Boolean.TRUE);
        return;
    L9:
        this.H = true;
        this.B.tryPlayVideo(this.O);
    }

    public final void b() {
        r();
        this.s.clear();
    }

    @Override // h95.a
    public final void c() {
        int r0 = getBarsShowState();
        tt5.a.h("DRIVE_VideoPlayer", "onClick()...barsShowState=" + r0);
        if (r0 != 1) goto L5;
        x();
        return;
    L5:
        if (r0 != 0) goto L9;
        f();
        return;
    }

    public final void z() {
        r();
        this.s.add(Flowable.interval(0, 100, TimeUnit.MILLISECONDS).takeWhile(new n0(this)).subscribe(new l0(this), new m0()));
    }

    public int getCurrentPlayMode() {
        return this.a;
    }

    public FrameLayout getViewContainer() {
        return this.b;
    }

    public VideoView(Context r4) {
        super(r4);
        this.a = 0;
        this.m = 1;
        this.n = 1;
        this.s = new CompositeDisposable();
        this.t = "";
        this.u = "";
        this.y = false;
        this.G = true;
        this.H = false;
        this.I = false;
        this.J = true;
        this.K = false;
        this.O = new a(this);
        g(r4);
    }

    public final void e(int r3) {
        if (this.m != 4) goto L8;
        if (r3 == 0) goto L8;
        this.n = 4;
        post(new d0(this));
        return;
    L8:
        if (this.n != 4) goto L12;
        if (r3 != 0) goto L13;
        this.n = 1;
        post(new e0(this));
        return;
    L13:
        return;
    }

    public final void g(Context r3) {
        tt5.a.h("DRIVE_VideoPlayer", "add view container in current view");
        this.b = new FrameLayout(r3);
        FrameLayout.LayoutParams r4 = new FrameLayout.LayoutParams(-1, -1);
        addView(this.b, r4);
        this.I = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.drive.mobile.play_origin_video");
    }

    public final void h(int r6) {
        tt5.a.h("DRIVE_VideoPlayer", "VideoView.onPlayerStateChanged(). playerState = " + r6);
        this.m = r6;
        VideoPlayerControllerView r0 = this.e;
        if (r0 != null) goto L6;
        tt5.a.d("DRIVE_VideoPlayer", "onPlayerStateChanged failed, mControllerView == null");
        b();
        return;
    L6:
        r0.setPlayerState(r6);
        if (r6 != 3) goto L13;
        tt5.a.h("DRIVE_VideoPlayer", "video status is ready");
        g r7 = this.p;
        if (r7 == null) goto L11;
        r7.onViewReady();
    L11:
        int r8 = (int) this.q.k();
        this.g = r8;
        this.e.setProgressbarMaxLength(r8);
        b();
        return;
    L13:
        if (r6 != 4) goto L22;
        s();
        tt5.a.h("DRIVE_VideoPlayer", " current mode is play, start timer");
        this.e.o();
        if (this.g > 0) goto L17;
        int r9 = (int) this.q.k();
        this.g = r9;
        this.e.setProgressbarMaxLength(r9);
        tt5.a.h("DRIVE_VideoPlayer", "set mVideoLength in play state length=" + this.g);
    L17:
        this.h = (int) this.q.getCurrentPosition();
        p();
        if (this.m == 4) goto L20;
        tt5.a.h("DRIVE_VideoPlayer", "mPlayerState != IPlayer.STATE_PLAYING, return");
        return;
    L20:
        z();
        return;
    L22:
        if (r6 != 5) goto L38;
        tt5.a.h("DRIVE_VideoPlayer", "video play finished, curPoint = " + this.q.getCurrentPosition() + ", totalLength = " + this.q.k());
        s();
        this.e.g();
        if (this.u.equals(this.t) == false) goto L29;
        tt5.a.h("DRIVE_VideoPlayer", "auto stop, do not change resolution");
        p();
        this.e.setProgress(this.g);
        this.e.setPlayState(false);
        if (this.w == null) goto L28;
        HashMap r10 = new HashMap();
        r10.put("play_time", Long.valueOf(this.q.getCurrentPosition()));
        this.w.liveInnerReportMsg().a(new a0(12, r10));
    L28:
        b();
    L29:
        DriveBlockPreviewVM.BlockState r11 = (DriveBlockPreviewVM.BlockState) this.C.getLiveBlockState().getValue();
        if (r11 != null) goto L32;
    L36:
        this.u = this.t;
        return;
    L32:
        if (TextUtils.equals(this.u, this.t) == false) goto L36;
        this.q.seekTo(0);
        t();
        p();
        if (r11 != DriveBlockPreviewVM.BlockState.BLOCK) goto L36;
        this.e.l(true);
        goto L36
    L38:
        if (r6 != 2) goto L40;
        s();
        tt5.a.h("DRIVE_VideoPlayer", "current mode is buffering destroy timer");
        this.e.g();
        b();
        return;
    L40:
        if (r6 != 1) goto L48;
        b();
        return;
    }

    /* JADX WARN: Type inference failed for: r7v2, types: [ea5.j0] */
    public void i(d r7) {
        tt5.a.h("", "init video data");
        this.v = r7;
        this.F = 0;
        this.e.setFileModel(r7.d);
        if (this.o == false) goto L5;
        VideoPlayerControllerView r0 = this.e;
        r0.getClass();
        int r1 = n.d(4);
        int r2 = n.d(8);
        FrameLayout.LayoutParams r3 = (FrameLayout.LayoutParams) r0.g.getLayoutParams();
        r3.leftMargin += r2;
        r3.topMargin += r2;
        r3.rightMargin += r2;
        r3.bottomMargin += r2;
        r0.g.setLayoutParams(r3);
        ProgressBar r4 = r0.d;
        r4.setPadding(r4.getPaddingStart() + r1, r0.d.getPaddingTop(), r0.d.getPaddingEnd(), r0.d.getPaddingBottom() + r2);
    L5:
        this.q = new w(getContext());
        VideoSurfaceView r5 = this.c;
        tt5.a.h("DRIVE_VideoPlayer", "initPlayer... ");
        this.q.l(r5);
        this.q.i(this);
        VideoPlayerControllerView r6 = this.e;
        r6.b = this.q;
        r6.c = this;
        ((DriveBlockPreviewVM) this.x.viewModel(DriveBlockPreviewVM.class)).getLiveBlockState().observe(this.x.lifecycleOwner(), new y(this));
        this.q.g = r7.b;
        this.M = new j0(this);
        ((DriveVCFollowVM) this.x.viewModel(DriveVCFollowVM.class)).getLiveIsMuted().observe(this.x.lifecycleOwner(), this.M);
    }

    /* JADX WARN: Type inference failed for: r1v9, types: [ea5.z] */
    public final void j(final Exception r8) {
        final boolean r2 = false;
        tt5.a.e("DRIVE_VideoPlayer", "VideoView.onPlayerError(). hasRenderStart: " + this.y, r8, false);
        boolean r0 = com.bytedance.ee.bear.appsetting.c.a.a.f("ccm.drive.mobile.video_mdl_cache_recovery_enable");
        tt5.a.h("DRIVE_VideoPlayer", "isMdlCacheRecoveryEnabled, enabled=" + r0);
        boolean r4 = true;
        if (r0 == true) goto L5;
    L49:
        StringBuilder r1 = new StringBuilder("tryRecoverFromMdlCacheError skip, hasRenderStart=");
        r1.append(this.y);
        r1.append(", retryCount=");
        r1.append(this.F);
        r1.append(", maxRetryCount=1, handlerNull=");
        if (this.N != null) goto L52;
        boolean r5 = true;
    L53:
        r1.append(r5);
        r1.append(", videoEntityNull=");
        if (this.v != null) goto L56;
        boolean r6 = true;
    L57:
        r1.append(r6);
        r1.append(", playerNull=");
        if (this.q != null) goto L60;
        boolean r7 = true;
    L61:
        r1.append(r7);
        r1.append(", cacheKeyEmpty=");
        d r9 = this.v;
        if (r9 != null) goto L64;
    L67:
        r1.append(r4);
        r1.append(", error=");
        r1.append(r8);
        tt5.a.h("DRIVE_VideoPlayer", r1.toString());
    L68:
        if (r2 == false) goto L71;
        return;
    L71:
        if (this.y == false) goto L76;
        w r3 = this.q;
        r3.getClass();
        tt5.a.h("TTPlayer", "ttPlayer reset... ");
        if (r3.a.getPlaybackState() == 0) goto L75;
        tt5.a.h("TTPlayer", "ttPlayer reset, stop playing");
        r3.stop();
    L75:
        this.B.getStartMedia().postValue(Boolean.FALSE);
        r();
    L79:
        post(new g0(this, r8));
        return;
    L76:
        PreviewViewModel r10 = this.w;
        if (r10 == null) goto L79;
        r10.getLiveInnerShowPreviewFailedPage().postValue(null);
        goto L79
    L64:
        if (TextUtils.isEmpty(r9.b) == true) goto L67;
        r4 = false;
        goto L67
    L60:
        r7 = false;
        goto L61
    L56:
        r6 = false;
        goto L57
    L52:
        r5 = false;
        goto L53
    L5:
        if (this.y == true) goto L49;
        if (this.F >= 1) goto L49;
        if (this.N == null) goto L49;
        d r11 = this.v;
        if (r11 == null) goto L49;
        if (this.q == null) goto L49;
        if (TextUtils.isEmpty(r11.b) == true) goto L49;
        if (TextUtils.isEmpty(this.v.a) == true) goto L26;
        String r12 = UriProtector.parse(this.v.a).getScheme();
        if ("http".equalsIgnoreCase(r12) == true) goto L24;
        if ("https".equalsIgnoreCase(r12) == false) goto L26;
    L24:
        if (this.v.a.contains("api/box/stream/sdk") == true) goto L26;
        boolean r13 = true;
    L27:
        if (r13 == false) goto L49;
        if (r8 != null) goto L30;
        String r14 = null;
    L32:
        if (TextUtils.isEmpty(r14) == false) goto L34;
    L38:
        boolean r16 = false;
    L39:
        if (r16 == false) goto L49;
        int r17 = this.m;
        if (r17 != 2) goto L44;
    L47:
        r2 = true;
    L48:
        this.F++;
        tt5.a.h("DRIVE_VideoPlayer", "tryRecoverFromMdlCacheError, clear video cache and retry, shouldStartAfterRetry=" + r2 + ", retryCount=" + this.F);
        this.B.getStartMedia().postValue(Boolean.FALSE);
        v();
        c r18 = this.N;
        VideoPreviewView.f(((com.bytedance.ee.bear.drive.view.preview.wrapper.j0) r18).a, new ea5.z(this, r2));
        r2 = true;
        goto L68
    L44:
        if (r17 == 4) goto L47;
        if (l() == false) goto L48;
    L34:
        if (r14.contains("-10006") == false) goto L36;
    L37:
        r16 = true;
        goto L39
    L36:
        if (r14.contains("-10008") == false) goto L38;
    L30:
        r14 = r8.toString();
    L26:
        r13 = false;
        goto L27
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r3) {
        super.onWindowVisibilityChanged(r3);
        if (com.bytedance.ee.bear.appsetting.c.a.a.f("spacekit.mobile.drive.embed_enable") == false) goto L6;
        e(r3);
        return;
    }

    public void setCommunication(PreviewViewModel r1) {
        this.w = r1;
    }

    public void setCurrentPlayMode(int r4) {
        boolean r1 = false;
        if (this.j != 0) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == true) goto L17;
        StringBuilder r5 = new StringBuilder("isHeightOrWidthZero() is: ");
        if (this.j != 0) goto L13;
    L14:
        r1 = true;
    L15:
        r5.append(r1);
        tt5.a.d("DRIVE_VideoPlayer", r5.toString());
        return;
    L13:
        if (this.i != 0) goto L15;
    L17:
        this.a = r4;
        this.e.setVerticalVideoCurrentPlayMode(r4);
        return;
    L5:
        if (this.i == 0) goto L8;
        r0 = false;
        goto L9
    }

    public void setCurrentPlayModeOrientation(int r1) {
        this.a = r1;
    }

    public void setCurrentTime(float r6) {
        w r0 = this.q;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.m < 2) goto L22;
        int r7 = (int) (r6 * 1000.0f);
        int r1 = this.g;
        if (r1 <= 0) goto L16;
        if (r7 > r1) goto L16;
        if (Math.abs(this.h - r7) < 2000) goto L13;
    L15:
        this.h = r7;
        this.q.seekTo(r7);
        this.e.setProgress(r7);
        p();
        return;
    L13:
        if (Math.abs(this.e.getProgress() - r7) >= 2000) goto L15;
        return;
    L16:
        if (r7 <= r1) goto L21;
        r0.seekTo(r1);
        this.e.setProgress(this.g);
        return;
    L21:
        return;
    }

    public void setCustomHeaders(Map<String, String> r2) {
        w r0 = this.q;
        if (r0 == null) goto L6;
        r0.c(r2);
        return;
    }

    public void setReportCb(b r1) {
        this.z = r1;
    }

    @Override // o65.a
    public void setVideoActionListener(o65.a.InterfaceC0267a r1) {
        this.r = r1;
    }

    public void setVideoCacheRecoveryHandler(c r1) {
        this.N = r1;
    }

    public final void u(String r5) {
        tt5.a.h("DRIVE_VideoPlayer", "init video view status");
        if (this.m == 1) goto L7;
        w r0 = this.q;
        r0.getClass();
        tt5.a.h("TTPlayer", "ttPlayer reset... ");
        if (r0.a.getPlaybackState() == 0) goto L7;
        tt5.a.h("TTPlayer", "ttPlayer reset, stop playing");
        r0.stop();
    L7:
        this.f = r5;
        setCustomHeaders(((f) org.koin.java.a.a(f.class)).oc(r5));
        this.q.b(UriProtector.parse(r5));
        if (l() == false) goto L10;
        this.e.setSilent(false);
    L11:
        this.e.setProgress(this.h);
        return;
    L10:
        this.e.setSilent(true);
        goto L11
    }

    public VideoView(Context r3, AttributeSet r4) {
        super(r3, r4);
        this.a = 0;
        this.m = 1;
        this.n = 1;
        this.s = new CompositeDisposable();
        this.t = "";
        this.u = "";
        this.y = false;
        this.G = true;
        this.H = false;
        this.I = false;
        this.J = true;
        this.K = false;
        this.O = new a(this);
        g(r3);
    }

    @Override // o65.a
    public final void a(int r3, float r4) {
        setCurrentTime(r4);
        if (r3 == 1) goto L29;
        if (r3 == 2) goto L21;
        if (r3 == 3) goto L10;
        b();
        return;
    L10:
        if (this.o == true) goto L12;
        return;
    L12:
        if (this.m != 4) goto L39;
        b();
        t();
        if (this.e == null) goto L40;
        DriveBlockPreviewVM r5 = this.C;
        if (r5 != null) goto L18;
        return;
    L18:
        if (r5.getLiveBlockState().getValue() != DriveBlockPreviewVM.BlockState.BLOCK) goto L42;
        this.e.setPlayState(false);
        this.e.l(true);
        return;
    L42:
        return;
    L40:
        return;
    L39:
        return;
    L21:
        if (this.o == true) goto L23;
    L25:
        VideoPlayerControllerView r6 = this.e;
        if (r6.B.k == true) goto L44;
        r6.n();
        return;
    L44:
        return;
    L23:
        if (this.m != 4) goto L25;
        b();
        t();
        goto L25
    L29:
        if (this.m == 4) goto L46;
        DriveBlockPreviewVM.BlockState r7 = (DriveBlockPreviewVM.BlockState) this.C.getLiveBlockState().getValue();
        if (r7 != null) goto L33;
    L35:
        z();
        play();
        return;
    L33:
        if (r7 == DriveBlockPreviewVM.BlockState.FULLSCREEN) goto L35;
        this.e.n();
        goto L35
    }

    public final void onVideoSizeChanged(int r7, int r8) {
        tt5.a.h("DRIVE_VideoPlayer", "VideoView.onVideoSizeChanged(). " + r7 + ", height = " + r8);
        this.i = r7;
        this.j = r8;
        boolean r9 = o();
        boolean r3 = false;
        if (this.C.getLiveBlockState().getValue() != DriveBlockPreviewVM.BlockState.BLOCK) goto L5;
        boolean r10 = true;
    L6:
        if (r9 == true) goto L8;
    L12:
        this.G = false;
        VideoPlayerControllerView r0 = this.e;
        if (r0 == null) goto L39;
        if (r9 == false) goto L19;
        if (r10 == true) goto L19;
        if (this.J == false) goto L19;
        boolean r4 = true;
    L20:
        ViewGroup r5 = r0.g;
        if (r4 == true) goto L23;
    L25:
        boolean r1 = false;
    L27:
        if (r1 == false) goto L29;
        int r2 = 0;
    L30:
        r5.setVisibility(r2);
        if (r9 == true) goto L33;
    L37:
        this.e.setEnterFullScreenButtonVisibility(8);
    L38:
        this.e.setVisibility(0);
        goto L39
    L33:
        if (this.J == false) goto L37;
        tt5.a.h("DRIVE_VideoPlayer", "horizontal video, if mode is normal show full screen button");
        if (this.a != 0) goto L38;
        this.e.setEnterFullScreenButtonVisibility(0);
        goto L38
    L29:
        r2 = 8;
        goto L30
    L23:
        if (r0.x == false) goto L25;
        r1 = true;
    L19:
        r4 = false;
    L39:
        int r11 = this.l;
        int r6 = this.k;
        if (this.i != 0) goto L42;
    L45:
        StringBuilder r12 = new StringBuilder("adjustSurfaceViewSize mVideoWidth == 0 ");
        if (this.i != 0) goto L48;
        boolean r13 = true;
    L49:
        r12.append(r13);
        r12.append(" mVideoHeight == 0 ");
        if (this.j != 0) goto L52;
        r3 = true;
    L52:
        r12.append(r3);
        tt5.a.d("DRIVE_VideoPlayer", r12.toString());
    L53:
        tt5.a.h("DRIVE_VideoPlayer", "onVideoSizeChanged, isBlockState: " + r10 + ", isCompactStyle: " + this.C.isCompactStyle() + ", isFollowingPresenter: " + n());
        if (r10 == true) goto L56;
        return;
    L56:
        if (this.C.isCompactStyle() == true) goto L58;
        return;
    L58:
        if (n() == true) goto L63;
        post(new f0(this));
        this.e.l(true);
        return;
    L63:
        return;
    L48:
        r13 = false;
        goto L49
    L42:
        if (this.j == 0) goto L45;
        w(r11, r6);
        this.c.requestLayout();
        goto L53
    L8:
        if (this.a != 1) goto L12;
        if (this.G == false) goto L12;
        this.w.liveInnerToggleFullScreen().postValue(this.v.d.c);
        this.a = 0;
        this.e.setVerticalVideoCurrentPlayMode(0);
        tt5.a.h("DRIVE_VideoPlayer", "horizontal video, if mode is fullScreen show");
        goto L12
    L5:
        r10 = false;
        goto L6
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r2, int r3) {
        super.onVisibilityChanged(r2, r3);
        if (com.bytedance.ee.bear.appsetting.c.a.a.f("spacekit.mobile.drive.embed_enable") == true) goto L6;
        e(r3);
        return;
    }

    public final void w(int r9, int r10) {
        int r0 = this.i;
        if (r0 == 0) goto L13;
        int r2 = this.j;
        if (r2 == 0) goto L13;
        if ((r0 / r2) <= (r10 / r9)) goto L10;
        int r3 = (int) (((double) (r2 * r10)) / ((double) r0));
        int r1 = r10;
    L11:
        FrameLayout.LayoutParams r4 = (FrameLayout.LayoutParams) this.c.getLayoutParams();
        r4.width = r1;
        r4.height = r3;
        r4.gravity = 17;
        this.b.measure(View.MeasureSpec.makeMeasureSpec(this.b.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.b.getMeasuredHeight(), 1073741824));
        this.b.layout(getLeft(), getTop(), getRight(), getBottom());
        tt5.a.h("DRIVE_VideoPlayer", "setTextureViewParams() parentWidth=" + r10 + " parentHeight=" + r9 + " surfaceWidth=" + r1 + " surfaceHeight=" + r3);
        return;
    L10:
        r1 = (int) (((double) (r0 * r9)) / ((double) r2));
        r3 = r9;
    L13:
        StringBuilder r11 = new StringBuilder("setTextureViewParams mVideoWidth == 0? ");
        boolean r5 = true;
        if (this.i != 0) goto L16;
        boolean r12 = true;
    L17:
        r11.append(r12);
        r11.append(" mVideoHeight == 0? ");
        if (this.j == 0) goto L21;
        r5 = false;
    L21:
        r11.append(r5);
        tt5.a.d("DRIVE_VideoPlayer", r11.toString());
        return;
    L16:
        r12 = false;
        goto L17
    }

    public VideoView(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        this.a = 0;
        this.m = 1;
        this.n = 1;
        this.s = new CompositeDisposable();
        this.t = "";
        this.u = "";
        this.y = false;
        this.G = true;
        this.H = false;
        this.I = false;
        this.J = true;
        this.K = false;
        this.O = new a(this);
        g(r2);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        this.k = r1;
        this.l = r2;
        w(r2, r1);
        this.c.requestLayout();
    }
}
