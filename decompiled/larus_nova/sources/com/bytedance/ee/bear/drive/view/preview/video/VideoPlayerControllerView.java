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
import com.bytedance.ee.util.ui.h;
import com.bytedance.ee.util.ui.n;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.videoarch.strategy.dataCenter.strategyData.HistoryTableOperate;
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

/* JADX INFO: loaded from: classes16.dex */
public class VideoPlayerControllerView extends FrameLayout implements ProgressBar.a, VolumeView.a, ProgressBar.b, View.OnClickListener, ia5.a {
    public static final /* synthetic */ int G = 0;
    public final boolean A;
    public m B;
    public final ia5.b C;
    public b D;
    public final c E;
    public VideoSummaryViewModel F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f225471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IPlayer f225472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ea5.a f225473c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ProgressBar f225474d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f225475e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f225476f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewGroup f225477g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FrameLayout f225478h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageView f225479i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ViewGroup f225480j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ImageView f225481k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f225482l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public PreviewViewModel f225483m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public DriveViewFullScreenVM f225484n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public DriveBlockPreviewVM f225485o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public z f225486p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public LifecycleOwner f225487q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f225488r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f225489s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f225490t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f225491u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f225492v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f225493w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f225494x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f225495y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f225496z;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f225497a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ VideoPlayerControllerView f225498b;

        @Override // java.lang.Runnable
        public final void run() {
            this.f225498b.f225474d.setProgress(this.f225497a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(VideoPlayerControllerView r100, int r101) {
            this.f225498b = r100;
            this.f225497a = r101;
        }
    }

    public interface b {
    }

    @Override // com.bytedance.ee.bear.drive.view.widget.ProgressBar.b
    public final void a() {
        this.C.f488917c = true;
        if (this.A == false) goto L5;
        g();
    L5:
        b r100 = this.D;
        if (r100 == null) goto L9;
        ((com.bytedance.ee.bear.drive.view.preview.video.a) r100).f225531a.b();
        return;
    }

    @Override // com.bytedance.ee.bear.drive.view.widget.ProgressBar.b
    public final void b() {
        this.C.f488917c = false;
        b r100 = this.D;
        if (r100 == null) goto L6;
        ((com.bytedance.ee.bear.drive.view.preview.video.a) r100).f225531a.z();
    L6:
        if (this.A == false) goto L9;
        o();
        return;
    }

    public final void c() {
        ImageView r100 = this.f225481k;
        if (r100 != null) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if (r101 != null) goto L8;
        return;
    L8:
        int r102 = n.d(50);
        int r103 = r102 + 8;
        if (getWidth() >= r103) goto L11;
    L13:
        r102 = Math.min(getWidth(), getHeight()) - 8;
        if (r102 >= 0) goto L16;
        r102 = 0;
    L16:
        tt5.a.h("DRIVE_VideoPlayer", "adjustPlayButton, from width: " + r101.width + ", height: " + r101.height + ", to: " + r102);
        if (r101.width == r102) goto L19;
    L20:
        r101.width = r102;
        r101.height = r102;
        r100.setLayoutParams(r101);
        return;
    L19:
        if (r101.height != r102) goto L20;
        return;
    L11:
        if (getHeight() < r103) goto L13;
        goto L13
    }

    public final void g() {
        this.C.a();
    }

    public int getProgress() {
        return this.f225474d.getProgress();
    }

    public final boolean j() {
        DriveBlockPreviewVM r100 = this.f225485o;
        if (r100 != null) goto L5;
    L8:
        return true;
    L5:
        if (r100.getLiveBlockState().getValue() == null) goto L8;
        return false;
    }

    public final void n() {
        this.f225481k.setVisibility(8);
        this.f225474d.e(false);
        this.f225475e.setVisibility(8);
        ProgressBar r100 = this.f225474d;
        r100.f225953y = false;
        r100.g(true);
        this.f225493w = false;
        this.f225474d.setVideoControlBarClearScreen(false);
        q();
        this.B.e();
    }

    public final void o() {
        boolean r100 = true;
        if (this.f225495y == false) goto L5;
    L7:
        boolean r101 = false;
    L9:
        if (r101 == false) goto L13;
        tt5.a.h("DRIVE_VideoPlayer", "skip startTimer, controller auto hide disabled in drive file preview");
        return;
    L13:
        if (this.f225496z == true) goto L15;
    L17:
        r100 = false;
    L18:
        if (r100 == false) goto L21;
        tt5.a.h("DRIVE_VideoPlayer", "skip startTimer, AI interaction active");
        return;
    L21:
        ia5.b r102 = this.C;
        r102.getClass();
        tt5.a.h("VideoProgressTimerManager", "startTimer!!! instance=" + r102.f488915a.hashCode() + ", current status = " + r102.f488916b);
        if (ia5.b.f488914f.contains(Integer.valueOf(r102.f488916b)) == false) goto L26;
        r102.f488919e = 0;
        r102.f488918d.clear();
        r102.f488918d.add(Flowable.interval(1000, TimeUnit.MILLISECONDS).observeOn(d.d()).subscribe(new ia5.c(r102), new ia5.d(r102)));
        return;
    L26:
        return;
    L15:
        if (j() == false) goto L17;
    L5:
        if (j() == false) goto L7;
        r101 = true;
        goto L9
    }

    public final void p() {
        ViewGroup r100 = this.f225480j;
        if (this.f225494x == true) goto L5;
    L7:
        int r101 = 8;
    L8:
        r100.setVisibility(r101);
        return;
    L5:
        if (ku5.c.k(getContext()) == true) goto L7;
        r101 = 0;
        goto L8
    }

    public final void q() {
        ViewGroup.LayoutParams r100 = this.f225474d.getLayoutParams();
        if ((r100 instanceof ViewGroup.MarginLayoutParams) == true) goto L6;
        tt5.a.d("DRIVE_VideoPlayer", "updateVideoControlBarBottomMargin ignored, supportMargin=false, v2Enabled=" + this.f225492v + ", clearScreen=" + this.f225493w);
        return;
    L6:
        ViewGroup.MarginLayoutParams r101 = (ViewGroup.MarginLayoutParams) r100;
        if (this.f225492v == true) goto L9;
    L11:
        int r102 = 0;
    L13:
        if (r101.bottomMargin != r102) goto L15;
        return;
    L15:
        r101.bottomMargin = r102;
        this.f225474d.setLayoutParams(r101);
        tt5.a.h("DRIVE_VideoPlayer", "updateVideoControlBarBottomMargin, v2Enabled=" + this.f225492v + ", clearScreen=" + this.f225493w + ", isPad=" + ku5.c.k(getContext()) + ", bottomMargin=" + r102);
        return;
    L9:
        if (this.f225493w == false) goto L11;
        r102 = getResources().getDimensionPixelSize(R.dimen.drive_progress_bar_v2_clear_screen_bottom_margin);
        goto L13
    }

    public int getBarsShowState() {
        return this.f225491u;
    }

    public VideoPlayerControllerView(Context r100) {
        super(r100);
        this.f225482l = 1;
        this.f225490t = 0;
        this.f225491u = 0;
        this.f225494x = true;
        this.f225495y = true;
        this.A = com.bytedance.ee.bear.appsetting.c.a.f206237a.h("spacekit.mobile.drive_fullscreen_animation");
        this.C = new ia5.b(this);
        this.E = new c("bear_drive_video_play");
        h(r100);
    }

    private void setVolume(boolean r100) {
        if (this.f225472b != null) goto L6;
        tt5.a.d("preview_video", "mIPlayer == null, setVolume failed");
        return;
    L6:
        this.f225489s = r100;
        tt5.a.h("preview_video", "set Volume =" + this.f225489s + " mForceSilent=" + this.f225488r);
        if (this.f225488r == true) goto L13;
        if (r100 == true) goto L13;
        this.f225472b.setVolume(1.0f);
        PreviewViewModel r101 = this.f225483m;
        if (r101 == null) goto L17;
        r101.liveInnerReportMsg().a(new a0(16));
        return;
    L17:
        return;
    L13:
        this.f225472b.setVolume(0.0f);
        PreviewViewModel r102 = this.f225483m;
        if (r102 == null) goto L19;
        r102.liveInnerReportMsg().a(new a0(15));
        return;
    }

    @Override // com.bytedance.ee.bear.drive.view.widget.ProgressBar.a
    public final void d(boolean r100) {
        if (this.f225472b != null) goto L6;
        tt5.a.d("preview_video", "mIPlayer == null, PlayStateChangedListener failed");
        return;
    L6:
        if (r100 == false) goto L16;
        this.f225473c.play();
        this.E.d();
        PreviewViewModel r101 = this.f225483m;
        if (r101 == null) goto L10;
        r101.liveInnerReportMsg().a(new a0(27));
    L10:
        DriveBlockPreviewVM r102 = this.f225485o;
        if (r102 != null) goto L13;
        return;
    L13:
        if (r102.getLiveBlockState().getValue() != DriveBlockPreviewVM.BlockState.BLOCK) goto L23;
        o();
        return;
    L23:
        return;
    L16:
        if (this.f225482l == 5) goto L20;
        tt5.a.h("preview_video", "stop play video after progress bar status changed");
        ((VideoView) this.f225473c).t();
        if (this.f225483m == null) goto L20;
        HashMap r103 = new HashMap();
        r103.put(HistoryTableOperate.HISTORY_PLAY_TIME, Long.valueOf(this.f225472b.getCurrentPosition()));
        this.f225483m.liveInnerReportMsg().a(new a0(12, r103));
    L20:
        this.E.f();
    }

    @Override // com.bytedance.ee.bear.drive.view.widget.ProgressBar.a
    public final void e(boolean r100) {
        PreviewViewModel r101 = this.f225483m;
        if (r101 != null) goto L5;
        tt5.a.d("DRIVE_VideoPlayer", "mPreviewViewModel == null, keep screen on failed");
        return;
    L5:
        r101.liveInnerKeepScreenOn().postValue(Boolean.valueOf(r100));
    }

    @Override // com.bytedance.ee.bear.drive.view.widget.VolumeView.a
    public final void f(boolean r100) {
        if (this.f225472b != null) goto L6;
        tt5.a.d("preview_video", "mIPlayer == null, VolumeStateChangedListener failed");
        return;
    L6:
        setVolume(r100);
    }

    public final void h(Context r100) {
        tt5.a.h("DRIVE_VideoPlayer", "init video player controller, driveFullscreenAnimationEnabled=" + this.A);
        LayoutInflater.from(r100).inflate(R.layout.drive_preview_video_view_controller, this);
        this.f225471a = findViewById(R.id.drive_video_controller_view_empty);
        this.f225474d = (ProgressBar) findViewById(R.id.progress_bar);
        this.f225475e = (TextView) findViewById(R.id.block_length);
        this.f225476f = (TextView) findViewById(R.id.file_name_tv);
        this.f225481k = (ImageView) findViewById(R.id.block_play);
        this.f225477g = (ViewGroup) findViewById(R.id.drive_video_player_title_root);
        this.f225478h = (FrameLayout) findViewById(R.id.drive_video_player_enter_full_screen_button);
        this.f225479i = (ImageView) findViewById(R.id.drive_video_player_back_image);
        this.f225480j = (ViewGroup) findViewById(R.id.control_fullscreen_root);
        this.f225474d.setProgressBg(R.drawable.drive_progressbar_bg_video);
        this.f225474d.setThumbBg(R.drawable.drive_progressbar_thumb_video);
        this.f225474d.setStartBtnBg(R.drawable.drive_progressbar_play_white);
        this.f225474d.setPauseBtnBg(R.drawable.drive_progressbar_pause_white);
        this.f225474d.setMaxLengthTextColor(R.color.lkui_N00);
        this.f225474d.setProgressTextColor(R.color.lkui_N00);
        this.f225474d.setBackgroundResource(R.drawable.drive_progressbar_bg);
        this.f225474d.setResolutionTextColor(R.color.lkui_N00);
        this.f225474d.setPlayStateChangedListener(this);
        this.f225474d.setProgressSeekedListener(this);
        if (this.A == false) goto L5;
        final ProgressBar r101 = this.f225474d;
        r101.f225932d.post(new com.bytedance.ee.bear.drive.view.widget.m(r101));
        tt5.a.h("DRIVE_VideoPlayer", "init video seek bar drag optimization, enabled=true");
    L5:
        this.f225478h.setOnClickListener(this);
        this.f225479i.setOnClickListener(this);
        this.f225474d.setVolumeStateChangedListener(this);
        this.f225481k.setOnClickListener(this);
        this.f225481k.setTag(R.id.drive_preview_block_fun_location_tag, Boolean.TRUE);
        p();
        post(new q(this));
        addOnLayoutChangeListener(new r(this));
    }

    @Override // com.bytedance.ee.bear.drive.view.widget.ProgressBar.b
    public final void i(int r100) {
        if (this.f225482l != 1) goto L7;
        tt5.a.h("preview_video", "mPlayerState == IPlayer.STATE_IDLE, return");
        return;
    L7:
        if (this.f225472b != null) goto L10;
        tt5.a.d("preview_video", "mIPlayer == null, seek to failed");
        return;
    L10:
        tt5.a.h("preview_video", "onProgressSeeked, progress = " + r100);
        VideoView r101 = (VideoView) this.f225473c;
        r101.getClass();
        tt5.a.h("DRIVE_VideoPlayer", "onStopTrackingTouchProgressChanged progress = " + r100);
        r101.f225507h = r100;
        r101.s();
        this.f225472b.seekTo(r100);
    }

    public final void k(int r100) {
        this.f225490t = r100;
        int r101 = 8;
        if (r100 != 0) goto L5;
        FrameLayout r102 = this.f225478h;
        if (this.f225494x == false) goto L16;
        int r103 = 0;
    L17:
        r102.setVisibility(r103);
        this.f225479i.setVisibility(8);
        this.f225476f.setVisibility(8);
        this.f225493w = false;
        this.f225474d.setVideoControlBarClearScreen(false);
        q();
        this.B.e();
        o();
        return;
    L16:
        r103 = 8;
        goto L17
    L5:
        if (r100 != 1) goto L21;
        this.f225478h.setVisibility(8);
        ImageView r104 = this.f225479i;
        if (this.f225494x == false) goto L10;
        r101 = 0;
    L10:
        r104.setVisibility(r101);
        if ((!ku5.c.k(getContext())) == true) goto L19;
        this.f225476f.setVisibility(0);
        return;
    L19:
        return;
    }

    public final void l(boolean r100) {
        if (r100 == false) goto L5;
    L12:
        boolean r101 = true;
    L13:
        this.f225474d.e(r101);
        this.f225477g.setVisibility(8);
        if (this.f225472b == null) goto L17;
        if (r101 == false) goto L17;
        this.B.d();
        this.f225475e.setVisibility(0);
        this.f225481k.setVisibility(0);
    L18:
        tt5.a.h("DRIVE_VideoPlayer", "showBlockUI, isCompactStyle: " + this.f225485o.isCompactStyle() + ", playEndOrInit: " + r101);
        if (this.f225485o.isCompactStyle() == false) goto L23;
        if (r101 == false) goto L24;
        this.f225474d.g(false);
        this.f225475e.setVisibility(8);
        return;
    L24:
        return;
    L23:
        return;
    L17:
        this.f225475e.setVisibility(8);
        this.f225481k.setVisibility(8);
        goto L18
    L5:
        if (this.f225474d.f225953y == true) goto L12;
        if (this.f225472b.getPlaybackState() == 3) goto L12;
        if (this.f225472b.getPlaybackState() == 5) goto L12;
        r101 = false;
        goto L13
    }

    public final void m(boolean r100) {
        this.f225474d.f();
        ViewGroup r101 = this.f225477g;
        int r102 = 0;
        if (r100 == true) goto L5;
    L7:
        boolean r103 = false;
    L9:
        if (r103 == true) goto L12;
        r102 = 8;
    L12:
        r101.setVisibility(r102);
        this.f225475e.setVisibility(8);
        this.f225481k.setVisibility(8);
        return;
    L5:
        if (this.f225494x == false) goto L7;
        r103 = true;
        goto L9
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (h.a(500) == true) goto L6;
        tt5.a.h("DRIVE_VideoPlayer", "onClick() isValidClick=false");
        return;
    L6:
        int r101 = r100.getId();
        if (r101 != R.id.drive_video_player_enter_full_screen_button) goto L19;
        if (this.f225494x == true) goto L12;
        tt5.a.h("DRIVE_VideoPlayer", "enter landscape ignored, videoLandscapeEnabled=false");
        return;
    L12:
        this.f225490t = 1;
        ((VideoView) this.f225473c).d();     // Catch: Exception -> L15
        HashMap r102 = new HashMap();     // Catch: Exception -> L15
        r102.put("is_fullscreen", Boolean.TRUE);     // Catch: Exception -> L15
        this.f225483m.liveInnerReportMsg().a(new a0(12, r102));     // Catch: Exception -> L15
    L17:
        o();
        return;
    L15:
        e = move-exception;
        tt5.a.e("DRIVE_VideoPlayer", "mVideoPlayer.enterFullScreen error", e, false);
        goto L17
    L19:
        if (r101 != R.id.drive_video_player_back_image) goto L30;
        this.f225490t = 0;
        h65.a r103 = ((VideoView) this.f225473c).L;     // Catch: Exception -> L26
        if (r103 == null) goto L24;
        r103.f483921c.a(r103.f483920b);     // Catch: Exception -> L26
    L24:
        HashMap r104 = new HashMap();     // Catch: Exception -> L26
        r104.put("is_fullscreen", Boolean.FALSE);     // Catch: Exception -> L26
        this.f225483m.liveInnerReportMsg().a(new a0(12, r104));     // Catch: Exception -> L26
    L28:
        o();
        return;
    L26:
        e = move-exception;
        tt5.a.e("DRIVE_VideoPlayer", "mVideoPlayer.exitFullScreen error", e, false);
        goto L28
    L30:
        if (r101 != R.id.block_play) goto L41;
        this.f225473c.play();
        n();
        g();
        tt5.a.h("DRIVE_VideoPlayer", "onClick - playButton, isCompactStyle: " + this.f225485o.isCompactStyle());
        if (this.f225485o.isCompactStyle() == false) goto L42;
        this.f225474d.g(false);
        this.f225485o.getEnterFullScreen().postValue(null);
        return;
    L42:
        return;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        p();
    }

    public void setControllerAutoHideInDriveFilePreviewEnabled(boolean r100) {
        this.f225495y = r100;
        if (r100 == false) goto L5;
    L7:
        tt5.a.h("DRIVE_VideoPlayer", "setControllerAutoHideInDriveFilePreviewEnabled, enabled=" + r100 + ", isDriveFilePreview=" + j());
        return;
    L5:
        if (j() == false) goto L7;
        g();
        goto L7
    }

    public void setEnterFullScreenButtonVisibility(int r100) {
        FrameLayout r101 = this.f225478h;
        if (this.f225494x == true) goto L6;
        r100 = 8;
    L6:
        r101.setVisibility(r100);
    }

    public void setFileModel(z r100) {
        this.f225486p = r100;
        this.f225474d.setFileModel(r100);
        this.f225476f.setText(this.f225486p.f225833a);
    }

    public void setForceSilent(boolean r100) {
        tt5.a.h("preview_video", "video player control setForceSilent=" + r100);
        this.f225488r = r100;
        setVolume(this.f225489s);
    }

    public void setPlayState(boolean r100) {
        this.f225474d.setPlayState(r100);
    }

    public void setPlayerState(int r100) {
        this.f225482l = r100;
        this.C.f488916b = r100;
        this.f225474d.setPlayerState(r100);
        if (r100 != 4) goto L8;
        if (this.f225485o.getLiveBlockState().getValue() != DriveBlockPreviewVM.BlockState.BLOCK) goto L8;
        o();
    L8:
        if (r100 != 5) goto L11;
        this.f225485o.getBlockTitleViewVisibility().postValue(Boolean.FALSE);
        return;
    }

    public void setProgress(int r100) {
        this.f225474d.post(new a(this, r100));
    }

    public void setProgressBarVisibility(int r100) {
        this.f225474d.setVisibility(r100);
    }

    public void setProgressbarMaxLength(int r100) {
        tt5.a.h("preview_video", "video player control setProgressbarMaxLength=" + r100);
        this.f225474d.setMaxLength(r100);
        this.f225475e.setText(zu5.b.d(r100));
    }

    public void setResolution(String r100) {
        this.f225474d.setResolution(r100);
    }

    public void setResolutionClickListener(View.OnClickListener r100) {
        this.f225474d.setResolutionClickListener(r100);
    }

    public void setResolutionVisible(boolean r100) {
        this.f225474d.setResolutionVisible(r100);
    }

    public void setRootViewClickable(boolean r100) {
        View r101 = this.f225471a;
        if (r100 == false) goto L5;
        int r102 = 8;
    L6:
        r101.setVisibility(r102);
        if (r100 == true) goto L10;
        this.f225471a.setOnClickListener(new o());
        return;
    L10:
        return;
    L5:
        r102 = 0;
        goto L6
    }

    public void setSilent(boolean r100) {
        tt5.a.h("preview_video", "video player control setSilent=" + r100);
        this.f225474d.setSilent(r100);
    }

    public void setUpdateProgressBarListener(b r100) {
        this.D = r100;
    }

    public void setVerticalVideoCurrentPlayMode(int r100) {
        this.f225490t = r100;
        if (r100 != 0) goto L5;
        this.f225493w = false;
        this.f225474d.setVideoControlBarClearScreen(false);
        q();
        this.B.e();
        o();
        return;
    L5:
        if (r100 != 1) goto L11;
        o();
        return;
    }

    public void setVideoControlBarV2Enabled(boolean r100) {
        this.f225474d.setVideoControlBarV2Enabled(r100);
        ProgressBar r101 = this.f225474d;
        boolean r102 = r101.B;
        this.f225492v = r102;
        if (this.f225491u == 0) goto L5;
        boolean r103 = true;
    L6:
        this.f225493w = r103;
        if (r102 == false) goto L9;
        r101.setVideoControlBarClearScreen(r103);
    L9:
        q();
        m r104 = this.B;
        if (r104 == null) goto L17;
        boolean r105 = this.f225492v;
        r104.f471609j = r105;
        if (r105 == false) goto L17;
        int r106 = r104.f471604e;
        ViewGroup.LayoutParams r107 = r104.f471600a.getLayoutParams();
        if (r107.height == r106) goto L17;
        r107.height = r106;
        r104.f471600a.setLayoutParams(r107);
    L17:
        tt5.a.h("DRIVE_VideoPlayer", "setVideoControlBarV2Enabled, requested=" + r100 + ", v2Enabled=" + this.f225492v + ", isPad=" + ku5.c.k(getContext()));
        return;
    L5:
        r103 = false;
        goto L6
    }

    public void setVideoLandscapeEnabled(boolean r100) {
        this.f225494x = r100;
        p();
        if (r100 == true) goto L7;
        this.f225478h.setVisibility(8);
        this.f225479i.setVisibility(8);
        if (this.f225490t != 0) goto L7;
        this.f225477g.setVisibility(8);
    L7:
        tt5.a.h("DRIVE_VideoPlayer", "setVideoLandscapeEnabled, enabled=" + r100 + ", isPad=" + ku5.c.k(getContext()));
    }

    public void setViewModel(ViewOwner r100) {
        this.f225487q = r100.lifecycleOwner();
        this.f225483m = (PreviewViewModel) r100.viewModel(PreviewViewModel.class);
        this.f225484n = (DriveViewFullScreenVM) r100.viewModel(DriveViewFullScreenVM.class);
        this.f225485o = (DriveBlockPreviewVM) r100.viewModel(DriveBlockPreviewVM.class);
        DriveMediaVM r101 = (DriveMediaVM) r100.viewModel(DriveMediaVM.class);
        this.f225474d.setViewModel(r100);
        Context r102 = getContext();
        ProgressBar r103 = this.f225474d;
        m r104 = new m(r102, r103, this.f225477g, this.f225485o.getBlockTitleView());
        this.B = r104;
        boolean r105 = this.f225492v;
        r104.f471609j = r105;
        if (r105 == false) goto L8;
        int r106 = r104.f471604e;
        ViewGroup.LayoutParams r107 = r103.getLayoutParams();
        if (r107.height == r106) goto L8;
        r107.height = r106;
        r103.setLayoutParams(r107);
    L8:
        VideoSummaryViewModel r108 = (VideoSummaryViewModel) r100.viewModel(VideoSummaryViewModel.class);
        this.F = r108;
        r108.exitImmersive();
        m r109 = this.B;
        t r110 = new t(this);
        r109.f471606g.addListener(r110);
        r109.f471608i.addListener(r110);
        m r111 = this.B;
        u r112 = new u(this);
        r111.f471605f.addListener(r112);
        r111.f471607h.addListener(r112);
        this.f225484n.liveOuterFullScreenSate.observe(r100.lifecycleOwner(), new p(this));
    }

    public VideoPlayerControllerView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f225482l = 1;
        this.f225490t = 0;
        this.f225491u = 0;
        this.f225494x = true;
        this.f225495y = true;
        this.A = com.bytedance.ee.bear.appsetting.c.a.f206237a.h("spacekit.mobile.drive_fullscreen_animation");
        this.C = new ia5.b(this);
        this.E = new c("bear_drive_video_play");
        h(r100);
    }

    public VideoPlayerControllerView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f225482l = 1;
        this.f225490t = 0;
        this.f225491u = 0;
        this.f225494x = true;
        this.f225495y = true;
        this.A = com.bytedance.ee.bear.appsetting.c.a.f206237a.h("spacekit.mobile.drive_fullscreen_animation");
        this.C = new ia5.b(this);
        this.E = new c("bear_drive_video_play");
        h(r100);
    }
}
