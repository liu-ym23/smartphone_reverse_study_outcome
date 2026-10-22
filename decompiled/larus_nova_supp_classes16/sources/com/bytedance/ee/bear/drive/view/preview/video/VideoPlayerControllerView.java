package com.bytedance.ee.bear.drive.view.preview.video;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ee.bear.drive.biz.preview.screen.DriveViewFullScreenVM;
import com.bytedance.ee.bear.drive.view.preview.block.DriveBlockPreviewVM;
import com.bytedance.ee.bear.drive.view.preview.media.DriveMediaVM;
import com.bytedance.ee.bear.drive.view.preview.video.aisummary.VideoSummaryViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.bytedance.ee.bear.drive.view.preview.wrapper.a0;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.bytedance.ee.bear.drive.view.widget.ProgressBar;
import com.bytedance.ee.bear.drive.view.widget.VolumeView;
import com.bytedance.ee.bear.middleground.drive.export.player.IPlayer;
import com.bytedance.ee.util.ui.g;
import com.bytedance.ee.util.ui.h;
import com.bytedance.ee.util.ui.n;
import com.larus.apm.impl.protector.RunnableProtector;
import ea5.m;
import ea5.o;
import ea5.p;
import ea5.q;
import ea5.r;
import ea5.t;
import ea5.u;
import et3.c;
import fo5.d;
import io.reactivex.Flowable;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class VideoPlayerControllerView extends FrameLayout implements ProgressBar.a, VolumeView.a, ProgressBar.b, View.OnClickListener, ia5.a {
    public static final /* synthetic */ int G = 0;
    public final boolean A;
    public m B;
    public final ia5.b C;
    public b D;
    public final c E;
    public VideoSummaryViewModel F;
    public View a;
    public IPlayer b;
    public ea5.a c;
    public ProgressBar d;
    public TextView e;
    public TextView f;
    public ViewGroup g;
    public FrameLayout h;
    public ImageView i;
    public ViewGroup j;
    public ImageView k;
    public int l;
    public PreviewViewModel m;
    public DriveViewFullScreenVM n;
    public DriveBlockPreviewVM o;
    public z p;
    public LifecycleOwner q;
    public boolean r;
    public boolean s;
    public int t;
    public int u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    public class a implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ VideoPlayerControllerView b;

        @Override // java.lang.Runnable
        public final void run() {
            this.b.d.setProgress(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(VideoPlayerControllerView r1, int r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public interface b {
    }

    @Override // com.bytedance.ee.bear.drive.view.widget.ProgressBar.b
    public final void a() {
        this.C.c = true;
        if (this.A == false) goto L5;
        g();
    L5:
        b r0 = this.D;
        if (r0 == null) goto L9;
        ((com.bytedance.ee.bear.drive.view.preview.video.a) r0).a.b();
        return;
    }

    @Override // com.bytedance.ee.bear.drive.view.widget.ProgressBar.b
    public final void b() {
        this.C.c = false;
        b r0 = this.D;
        if (r0 == null) goto L6;
        ((com.bytedance.ee.bear.drive.view.preview.video.a) r0).a.z();
    L6:
        if (this.A == false) goto L9;
        o();
        return;
    }

    public final void c() {
        ImageView r0 = this.k;
        if (r0 != null) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 != null) goto L8;
        return;
    L8:
        int r2 = n.d(50);
        int r3 = r2 + 8;
        if (getWidth() >= r3) goto L11;
    L13:
        r2 = Math.min(getWidth(), getHeight()) - 8;
        if (r2 >= 0) goto L16;
        r2 = 0;
    L16:
        tt5.a.h("DRIVE_VideoPlayer", "adjustPlayButton, from width: " + r1.width + ", height: " + r1.height + ", to: " + r2);
        if (r1.width == r2) goto L19;
    L20:
        r1.width = r2;
        r1.height = r2;
        r0.setLayoutParams(r1);
        return;
    L19:
        if (r1.height != r2) goto L20;
        return;
    L11:
        if (getHeight() < r3) goto L13;
        goto L13
    }

    public final void g() {
        this.C.a();
    }

    public int getProgress() {
        return this.d.getProgress();
    }

    public final boolean j() {
        DriveBlockPreviewVM r0 = this.o;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.getLiveBlockState().getValue() == null) goto L8;
        return false;
    }

    public final void n() {
        this.k.setVisibility(8);
        this.d.e(false);
        this.e.setVisibility(8);
        ProgressBar r0 = this.d;
        r0.y = false;
        r0.g(true);
        this.w = false;
        this.d.setVideoControlBarClearScreen(false);
        q();
        this.B.e();
    }

    public final void o() {
        boolean r1 = true;
        if (this.y == false) goto L5;
    L7:
        boolean r0 = false;
    L9:
        if (r0 == false) goto L13;
        tt5.a.h("DRIVE_VideoPlayer", "skip startTimer, controller auto hide disabled in drive file preview");
        return;
    L13:
        if (this.z == true) goto L15;
    L17:
        r1 = false;
    L18:
        if (r1 == false) goto L21;
        tt5.a.h("DRIVE_VideoPlayer", "skip startTimer, AI interaction active");
        return;
    L21:
        ia5.b r2 = this.C;
        r2.getClass();
        tt5.a.h("VideoProgressTimerManager", "startTimer!!! instance=" + r2.a.hashCode() + ", current status = " + r2.b);
        if (ia5.b.f.contains(Integer.valueOf(r2.b)) == false) goto L26;
        r2.e = 0;
        r2.d.clear();
        r2.d.add(Flowable.interval(1000, TimeUnit.MILLISECONDS).observeOn(d.d()).subscribe(new ia5.c(r2), new ia5.d(r2)));
        return;
    L26:
        return;
    L15:
        if (j() == false) goto L17;
    L5:
        if (j() == false) goto L7;
        r0 = true;
        goto L9
    }

    public final void p() {
        ViewGroup r0 = this.j;
        if (this.x == true) goto L5;
    L7:
        int r1 = 8;
    L8:
        r0.setVisibility(r1);
        return;
    L5:
        if (ku5.c.k(getContext()) == true) goto L7;
        r1 = 0;
        goto L8
    }

    public final void q() {
        ViewGroup.LayoutParams r0 = this.d.getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == true) goto L6;
        tt5.a.d("DRIVE_VideoPlayer", "updateVideoControlBarBottomMargin ignored, supportMargin=false, v2Enabled=" + this.v + ", clearScreen=" + this.w);
        return;
    L6:
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        if (this.v == true) goto L9;
    L11:
        int r2 = 0;
    L13:
        if (r1.bottomMargin != r2) goto L15;
        return;
    L15:
        r1.bottomMargin = r2;
        this.d.setLayoutParams(r1);
        tt5.a.h("DRIVE_VideoPlayer", "updateVideoControlBarBottomMargin, v2Enabled=" + this.v + ", clearScreen=" + this.w + ", isPad=" + ku5.c.k(getContext()) + ", bottomMargin=" + r2);
        return;
    L9:
        if (this.w == false) goto L11;
        r2 = getResources().getDimensionPixelSize(2131166326);
        goto L13
    }

    public int getBarsShowState() {
        return this.u;
    }

    public VideoPlayerControllerView(Context r3) {
        super(r3);
        this.l = 1;
        this.t = 0;
        this.u = 0;
        this.x = true;
        this.y = true;
        this.A = com.bytedance.ee.bear.appsetting.c.a.a.h("spacekit.mobile.drive_fullscreen_animation");
        this.C = new ia5.b(this);
        this.E = new c("bear_drive_video_play");
        h(r3);
    }

    private void setVolume(boolean r4) {
        if (this.b != null) goto L6;
        tt5.a.d("preview_video", "mIPlayer == null, setVolume failed");
        return;
    L6:
        this.s = r4;
        tt5.a.h("preview_video", "set Volume =" + this.s + " mForceSilent=" + this.r);
        if (this.r == true) goto L13;
        if (r4 == true) goto L13;
        this.b.setVolume(1.0f);
        PreviewViewModel r5 = this.m;
        if (r5 == null) goto L17;
        r5.liveInnerReportMsg().a(new a0(16));
        return;
    L17:
        return;
    L13:
        this.b.setVolume(0.0f);
        PreviewViewModel r6 = this.m;
        if (r6 == null) goto L19;
        r6.liveInnerReportMsg().a(new a0(15));
        return;
    }

    @Override // com.bytedance.ee.bear.drive.view.widget.ProgressBar.a
    public final void d(boolean r4) {
        if (this.b != null) goto L6;
        tt5.a.d("preview_video", "mIPlayer == null, PlayStateChangedListener failed");
        return;
    L6:
        if (r4 == false) goto L16;
        this.c.play();
        this.E.d();
        PreviewViewModel r5 = this.m;
        if (r5 == null) goto L10;
        r5.liveInnerReportMsg().a(new a0(27));
    L10:
        DriveBlockPreviewVM r6 = this.o;
        if (r6 != null) goto L13;
        return;
    L13:
        if (r6.getLiveBlockState().getValue() != DriveBlockPreviewVM.BlockState.BLOCK) goto L23;
        o();
        return;
    L23:
        return;
    L16:
        if (this.l == 5) goto L20;
        tt5.a.h("preview_video", "stop play video after progress bar status changed");
        ((VideoView) this.c).t();
        if (this.m == null) goto L20;
        HashMap r7 = new HashMap();
        r7.put("play_time", Long.valueOf(this.b.getCurrentPosition()));
        this.m.liveInnerReportMsg().a(new a0(12, r7));
    L20:
        this.E.f();
    }

    @Override // com.bytedance.ee.bear.drive.view.widget.ProgressBar.a
    public final void e(boolean r2) {
        PreviewViewModel r0 = this.m;
        if (r0 != null) goto L5;
        tt5.a.d("DRIVE_VideoPlayer", "mPreviewViewModel == null, keep screen on failed");
        return;
    L5:
        r0.liveInnerKeepScreenOn().postValue(Boolean.valueOf(r2));
    }

    @Override // com.bytedance.ee.bear.drive.view.widget.VolumeView.a
    public final void f(boolean r2) {
        if (this.b != null) goto L6;
        tt5.a.d("preview_video", "mIPlayer == null, VolumeStateChangedListener failed");
        return;
    L6:
        setVolume(r2);
    }

    public final void h(Context r4) {
        tt5.a.h("DRIVE_VideoPlayer", "init video player controller, driveFullscreenAnimationEnabled=" + this.A);
        LayoutInflater.from(r4).inflate(2131560223, this);
        this.a = findViewById(2131370341);
        this.d = (ProgressBar) findViewById(2131383297);
        this.e = (TextView) findViewById(2131364275);
        this.f = (TextView) findViewById(2131372416);
        this.k = (ImageView) findViewById(2131364278);
        this.g = (ViewGroup) findViewById(2131370344);
        this.h = (FrameLayout) findViewById(2131370343);
        this.i = (ImageView) findViewById(2131370342);
        this.j = (ViewGroup) findViewById(2131367929);
        this.d.setProgressBg(2131234031);
        this.d.setThumbBg(2131234036);
        this.d.setStartBtnBg(2131234035);
        this.d.setPauseBtnBg(2131234033);
        this.d.setMaxLengthTextColor(2131103449);
        this.d.setProgressTextColor(2131103449);
        this.d.setBackgroundResource(2131234029);
        this.d.setResolutionTextColor(2131103449);
        this.d.setPlayStateChangedListener(this);
        this.d.setProgressSeekedListener(this);
        if (this.A == false) goto L5;
        final ProgressBar r5 = this.d;
        r5.d.post(new com.bytedance.ee.bear.drive.view.widget.m(r5));
        tt5.a.h("DRIVE_VideoPlayer", "init video seek bar drag optimization, enabled=true");
    L5:
        this.h.setOnClickListener(this);
        this.i.setOnClickListener(this);
        this.d.setVolumeStateChangedListener(this);
        this.k.setOnClickListener(this);
        this.k.setTag(2131370304, Boolean.TRUE);
        p();
        post(new q(this));
        addOnLayoutChangeListener(new r(this));
    }

    @Override // com.bytedance.ee.bear.drive.view.widget.ProgressBar.b
    public final void i(int r4) {
        if (this.l != 1) goto L7;
        tt5.a.h("preview_video", "mPlayerState == IPlayer.STATE_IDLE, return");
        return;
    L7:
        if (this.b != null) goto L10;
        tt5.a.d("preview_video", "mIPlayer == null, seek to failed");
        return;
    L10:
        tt5.a.h("preview_video", "onProgressSeeked, progress = " + r4);
        VideoView r0 = (VideoView) this.c;
        r0.getClass();
        tt5.a.h("DRIVE_VideoPlayer", "onStopTrackingTouchProgressChanged progress = " + r4);
        r0.h = r4;
        r0.s();
        this.b.seekTo(r4);
    }

    public final void k(int r5) {
        this.t = r5;
        int r1 = 8;
        if (r5 != 0) goto L5;
        FrameLayout r6 = this.h;
        if (this.x == false) goto L16;
        int r2 = 0;
    L17:
        r6.setVisibility(r2);
        this.i.setVisibility(8);
        this.f.setVisibility(8);
        this.w = false;
        this.d.setVideoControlBarClearScreen(false);
        q();
        this.B.e();
        o();
        return;
    L16:
        r2 = 8;
        goto L17
    L5:
        if (r5 != 1) goto L21;
        this.h.setVisibility(8);
        ImageView r7 = this.i;
        if (this.x == false) goto L10;
        r1 = 0;
    L10:
        r7.setVisibility(r1);
        if ((!ku5.c.k(getContext())) == true) goto L19;
        this.f.setVisibility(0);
        return;
    L19:
        return;
    }

    public final void l(boolean r5) {
        if (r5 == false) goto L5;
    L12:
        boolean r6 = true;
    L13:
        this.d.e(r6);
        this.g.setVisibility(8);
        if (this.b == null) goto L17;
        if (r6 == false) goto L17;
        this.B.d();
        this.e.setVisibility(0);
        this.k.setVisibility(0);
    L18:
        tt5.a.h("DRIVE_VideoPlayer", "showBlockUI, isCompactStyle: " + this.o.isCompactStyle() + ", playEndOrInit: " + r6);
        if (this.o.isCompactStyle() == false) goto L23;
        if (r6 == false) goto L24;
        this.d.g(false);
        this.e.setVisibility(8);
        return;
    L24:
        return;
    L23:
        return;
    L17:
        this.e.setVisibility(8);
        this.k.setVisibility(8);
        goto L18
    L5:
        if (this.d.y == true) goto L12;
        if (this.b.getPlaybackState() == 3) goto L12;
        if (this.b.getPlaybackState() == 5) goto L12;
        r6 = false;
        goto L13
    }

    public final void m(boolean r4) {
        this.d.f();
        ViewGroup r0 = this.g;
        int r1 = 0;
        if (r4 == true) goto L5;
    L7:
        boolean r5 = false;
    L9:
        if (r5 == true) goto L12;
        r1 = 8;
    L12:
        r0.setVisibility(r1);
        this.e.setVisibility(8);
        this.k.setVisibility(8);
        return;
    L5:
        if (this.x == false) goto L7;
        r5 = true;
        goto L9
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        if (h.a(500) == true) goto L6;
        tt5.a.h("DRIVE_VideoPlayer", "onClick() isValidClick=false");
        return;
    L6:
        int r7 = r6.getId();
        if (r7 != 2131370343) goto L19;
        if (this.x == true) goto L12;
        tt5.a.h("DRIVE_VideoPlayer", "enter landscape ignored, videoLandscapeEnabled=false");
        return;
    L12:
        this.t = 1;
        ((VideoView) this.c).d();     // Catch: Exception -> L15
        HashMap r8 = new HashMap();     // Catch: Exception -> L15
        r8.put("is_fullscreen", Boolean.TRUE);     // Catch: Exception -> L15
        this.m.liveInnerReportMsg().a(new a0(12, r8));     // Catch: Exception -> L15
    L17:
        o();
        return;
    L15:
        e = move-exception;
        tt5.a.e("DRIVE_VideoPlayer", "mVideoPlayer.enterFullScreen error", e, false);
        goto L17
    L19:
        if (r7 != 2131370342) goto L30;
        this.t = 0;
        h65.a r9 = ((VideoView) this.c).L;     // Catch: Exception -> L26
        if (r9 == null) goto L24;
        r9.c.a(r9.b);     // Catch: Exception -> L26
    L24:
        HashMap r10 = new HashMap();     // Catch: Exception -> L26
        r10.put("is_fullscreen", Boolean.FALSE);     // Catch: Exception -> L26
        this.m.liveInnerReportMsg().a(new a0(12, r10));     // Catch: Exception -> L26
    L28:
        o();
        return;
    L26:
        e = move-exception;
        tt5.a.e("DRIVE_VideoPlayer", "mVideoPlayer.exitFullScreen error", e, false);
        goto L28
    L30:
        if (r7 != 2131364278) goto L41;
        this.c.play();
        n();
        g();
        tt5.a.h("DRIVE_VideoPlayer", "onClick - playButton, isCompactStyle: " + this.o.isCompactStyle());
        if (this.o.isCompactStyle() == false) goto L42;
        this.d.g(false);
        this.o.getEnterFullScreen().postValue(null);
        return;
    L42:
        return;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        p();
    }

    public void setControllerAutoHideInDriveFilePreviewEnabled(boolean r3) {
        this.y = r3;
        if (r3 == false) goto L5;
    L7:
        tt5.a.h("DRIVE_VideoPlayer", "setControllerAutoHideInDriveFilePreviewEnabled, enabled=" + r3 + ", isDriveFilePreview=" + j());
        return;
    L5:
        if (j() == false) goto L7;
        g();
        goto L7
    }

    public void setEnterFullScreenButtonVisibility(int r3) {
        FrameLayout r0 = this.h;
        if (this.x == true) goto L6;
        r3 = 8;
    L6:
        r0.setVisibility(r3);
    }

    public void setFileModel(z r2) {
        this.p = r2;
        this.d.setFileModel(r2);
        this.f.setText(this.p.a);
    }

    public void setForceSilent(boolean r3) {
        tt5.a.h("preview_video", "video player control setForceSilent=" + r3);
        this.r = r3;
        setVolume(this.s);
    }

    public void setPlayState(boolean r2) {
        this.d.setPlayState(r2);
    }

    public void setPlayerState(int r3) {
        this.l = r3;
        this.C.b = r3;
        this.d.setPlayerState(r3);
        if (r3 != 4) goto L8;
        if (this.o.getLiveBlockState().getValue() != DriveBlockPreviewVM.BlockState.BLOCK) goto L8;
        o();
    L8:
        if (r3 != 5) goto L11;
        this.o.getBlockTitleViewVisibility().postValue(Boolean.FALSE);
        return;
    }

    public void setProgress(int r3) {
        this.d.post(new a(this, r3));
    }

    public void setProgressBarVisibility(int r2) {
        this.d.setVisibility(r2);
    }

    public void setProgressbarMaxLength(int r3) {
        tt5.a.h("preview_video", "video player control setProgressbarMaxLength=" + r3);
        this.d.setMaxLength(r3);
        this.e.setText(zu5.b.d(r3));
    }

    public void setResolution(String r2) {
        this.d.setResolution(r2);
    }

    public void setResolutionClickListener(View.OnClickListener r2) {
        this.d.setResolutionClickListener(r2);
    }

    public void setResolutionVisible(boolean r2) {
        this.d.setResolutionVisible(r2);
    }

    public void setRootViewClickable(boolean r3) {
        View r0 = this.a;
        if (r3 == false) goto L5;
        int r1 = 8;
    L6:
        r0.setVisibility(r1);
        if (r3 == true) goto L10;
        this.a.setOnClickListener(new o());
        return;
    L10:
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public void setSilent(boolean r3) {
        tt5.a.h("preview_video", "video player control setSilent=" + r3);
        this.d.setSilent(r3);
    }

    public void setUpdateProgressBarListener(b r1) {
        this.D = r1;
    }

    public void setVerticalVideoCurrentPlayMode(int r2) {
        this.t = r2;
        if (r2 != 0) goto L5;
        this.w = false;
        this.d.setVideoControlBarClearScreen(false);
        q();
        this.B.e();
        o();
        return;
    L5:
        if (r2 != 1) goto L11;
        o();
        return;
    }

    public void setVideoControlBarV2Enabled(boolean r5) {
        this.d.setVideoControlBarV2Enabled(r5);
        ProgressBar r0 = this.d;
        boolean r1 = r0.B;
        this.v = r1;
        if (this.u == 0) goto L5;
        boolean r2 = true;
    L6:
        this.w = r2;
        if (r1 == false) goto L9;
        r0.setVideoControlBarClearScreen(r2);
    L9:
        q();
        m r3 = this.B;
        if (r3 == null) goto L17;
        boolean r4 = this.v;
        r3.j = r4;
        if (r4 == false) goto L17;
        int r6 = r3.e;
        ViewGroup.LayoutParams r7 = r3.a.getLayoutParams();
        if (r7.height == r6) goto L17;
        r7.height = r6;
        r3.a.setLayoutParams(r7);
    L17:
        tt5.a.h("DRIVE_VideoPlayer", "setVideoControlBarV2Enabled, requested=" + r5 + ", v2Enabled=" + this.v + ", isPad=" + ku5.c.k(getContext()));
        return;
    L5:
        r2 = false;
        goto L6
    }

    public void setVideoLandscapeEnabled(boolean r3) {
        this.x = r3;
        p();
        if (r3 == true) goto L7;
        this.h.setVisibility(8);
        this.i.setVisibility(8);
        if (this.t != 0) goto L7;
        this.g.setVisibility(8);
    L7:
        tt5.a.h("DRIVE_VideoPlayer", "setVideoLandscapeEnabled, enabled=" + r3 + ", isPad=" + ku5.c.k(getContext()));
    }

    public void setViewModel(ViewOwner r6) {
        this.q = r6.lifecycleOwner();
        this.m = (PreviewViewModel) r6.viewModel(PreviewViewModel.class);
        this.n = (DriveViewFullScreenVM) r6.viewModel(DriveViewFullScreenVM.class);
        this.o = (DriveBlockPreviewVM) r6.viewModel(DriveBlockPreviewVM.class);
        DriveMediaVM r0 = (DriveMediaVM) r6.viewModel(DriveMediaVM.class);
        this.d.setViewModel(r6);
        Context r1 = getContext();
        ProgressBar r2 = this.d;
        m r3 = new m(r1, r2, this.g, this.o.getBlockTitleView());
        this.B = r3;
        boolean r4 = this.v;
        r3.j = r4;
        if (r4 == false) goto L8;
        int r5 = r3.e;
        ViewGroup.LayoutParams r7 = r2.getLayoutParams();
        if (r7.height == r5) goto L8;
        r7.height = r5;
        r2.setLayoutParams(r7);
    L8:
        VideoSummaryViewModel r8 = (VideoSummaryViewModel) r6.viewModel(VideoSummaryViewModel.class);
        this.F = r8;
        r8.exitImmersive();
        m r9 = this.B;
        g.a r10 = new t(this);
        r9.g.addListener(r10);
        r9.i.addListener(r10);
        m r11 = this.B;
        g.a r12 = new u(this);
        r11.f.addListener(r12);
        r11.h.addListener(r12);
        this.n.liveOuterFullScreenSate.observe(r6.lifecycleOwner(), new p(this));
    }

    public VideoPlayerControllerView(Context r2, AttributeSet r3) {
        super(r2, r3);
        this.l = 1;
        this.t = 0;
        this.u = 0;
        this.x = true;
        this.y = true;
        this.A = com.bytedance.ee.bear.appsetting.c.a.a.h("spacekit.mobile.drive_fullscreen_animation");
        this.C = new ia5.b(this);
        this.E = new c("bear_drive_video_play");
        h(r2);
    }

    public VideoPlayerControllerView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.l = 1;
        this.t = 0;
        this.u = 0;
        this.x = true;
        this.y = true;
        this.A = com.bytedance.ee.bear.appsetting.c.a.a.h("spacekit.mobile.drive_fullscreen_animation");
        this.C = new ia5.b(this);
        this.E = new c("bear_drive_video_play");
        h(r1);
    }
}
