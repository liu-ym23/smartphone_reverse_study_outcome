package com.bytedance.ee.bear.drive.view.preview.audio;

import android.R;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.document.offline.file.upload.UploadResult;
import com.bytedance.ee.bear.drive.biz.preview.vc.DriveVCFollowVM;
import com.bytedance.ee.bear.drive.biz.preview.vc.connector.g;
import com.bytedance.ee.bear.drive.module.nativepreview.model.DriveComponentRenderVM;
import com.bytedance.ee.bear.drive.view.preview.block.DriveBlockPreviewVM;
import com.bytedance.ee.bear.drive.view.preview.media.DriveMediaVM;
import com.bytedance.ee.bear.drive.view.preview.video.aisummary.VideoSummaryViewModel;
import com.bytedance.ee.bear.drive.view.preview.video.player.SystemAudioPlayer;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.bytedance.ee.bear.drive.view.preview.wrapper.a0;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.bytedance.ee.bear.drive.view.widget.ProgressBar;
import com.bytedance.ee.bear.drive.view.widget.VolumeView;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.mt.protector.impl.UriProtector;
import ea5.m;
import g95.f;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class AudioView extends FrameLayout implements sf5.a, ProgressBar.a, ProgressBar.b, VolumeView.a, h95.a, m65.b, m85.a {
    public static final /* synthetic */ int H = 0;
    public final CompositeDisposable A;
    public int B;
    public boolean C;
    public boolean D;
    public long E;
    public VideoSummaryViewModel F;
    public final c G;
    public final String a;
    public ImageView b;
    public ProgressBar c;
    public TextView d;
    public int e;
    public int f;
    public boolean g;
    public boolean h;
    public int i;
    public f j;
    public boolean k;
    public g l;
    public boolean m;
    public SystemAudioPlayer n;
    public m65.b.a o;
    public e p;
    public PreviewViewModel q;
    public d r;
    public boolean s;
    public final et3.c t;
    public ViewOwner u;
    public DriveComponentRenderVM v;
    public DriveMediaVM w;
    public DriveBlockPreviewVM x;
    public ImageView y;
    public m z;

    public class a implements View.OnClickListener {
        public final /* synthetic */ AudioView a;

        public a(AudioView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            AudioView r3 = this.a;
            if (r3.z.k == false) goto L5;
            return;
        L5:
            if (r3.x.getLiveBlockState().getValue() != DriveBlockPreviewVM.BlockState.BLOCK) goto L13;
            SystemAudioPlayer r4 = this.a.n;
            if (r4 != null) goto L9;
            return;
        L9:
            if (r4.getPlaybackState() != 4) goto L15;
            this.a.z.e();
            return;
        L15:
            return;
        }
    }

    public class b extends t {
        public final /* synthetic */ AudioView c;

        public b(AudioView r1) {
            this.c = r1;
        }

        public final void a(View r3) {
            VideoSummaryViewModel r4 = this.c.F;
            if (r4 != null) goto L5;
        L8:
            AudioView r5 = this.c;
            boolean r0 = r5.z.k;
            VideoSummaryViewModel r6 = r5.F;
            if (r6 == null) goto L11;
            r6.sendEvent(new fa5.c.a(r0));
        L11:
            if (r0 == true) goto L15;
            AudioView r7 = this.c;
            m r1 = r7.z;
            r1.g.cancel();
            r1.i.cancel();
            r1.f.cancel();
            r1.h.cancel();
            r7.z.e();
            r7.x();
            VideoSummaryViewModel r8 = r7.F;
            if (r8 == null) goto L17;
            r8.exitImmersive();
            return;
        L17:
            return;
        L15:
            this.c.m();
            return;
        L5:
            if (r4.isSummaryExpand() == false) goto L8;
            this.c.F.collapseSummary();
        }
    }

    public class c implements u95.a {
        public final /* synthetic */ AudioView a;

        @Override // u95.a
        public final void a() {
            this.a.p.removeCallbacksAndMessages(null);
            this.a.c.setPlayState(false);
            this.a.n.pause();
            this.a.w.getStartMedia().postValue(Boolean.FALSE);
        }

        public final void e() {
            this.a.w.getStartMedia().postValue(Boolean.TRUE);
            AudioView r0 = this.a;
            if (r0.D == false) goto L5;
            r0.w();
            this.a.l();
            this.a.x();
        L5:
            this.a.n.start();
            this.a.s();
        }

        @Override // u95.a
        public final void c() {
            e();
        }

        @Override // u95.a
        public final void d() {
            e();
        }

        public c(AudioView r1) {
            this.a = r1;
        }

        @Override // u95.a
        public final void b(final String r3) {
            if (TextUtils.isEmpty(r3) == true) goto L5;
            final AudioView r0 = this.a;
            int r1 = AudioView.H;
            r0.getClass();
            com.bytedance.ee.util.ui.m.a(new g95.g(r0, r3));
            return;
        L5:
            e();
        }
    }

    public static class d {
        public final String a;
        public final z b;

        public d(String r1, z r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static class e extends Handler {
        public final WeakReference<AudioView> a;

        public e(AudioView r2) {
            this.a = new WeakReference(r2);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r5) {
            if (r5.what != 0) goto L22;
            AudioView r6 = this.a.get();
            if (r6 != null) goto L8;
            return;
        L8:
            if (r6.i != 4) goto L23;
            int r0 = (int) r6.n.getCurrentPosition();
            r6.f = r0;
            r6.c.setProgress(r0);
            if (r6.p(r6.f) == false) goto L13;
            r6.i = 5;
        L13:
            r6.r();
            tt5.a.h(r6.a, "updateProgress, curPosition = " + r6.f + ", audioLength = " + r6.e);
            if (r6.f < r6.e) goto L16;
            return;
        L16:
            if (r6.i != 4) goto L21;
            r6.p.sendEmptyMessageDelayed(0, 1000);
            return;
        L21:
            return;
        L23:
            return;
        }
    }

    @Override // m85.a
    public String getReleaseKey() {
        return "AudioView";
    }

    @Override // com.bytedance.ee.bear.drive.view.widget.ProgressBar.b
    public final void a() {
        tt5.a.h(this.a, "onStartTrackingTouch()");
        this.C = true;
    }

    @Override // com.bytedance.ee.bear.drive.view.widget.ProgressBar.b
    public final void b() {
        tt5.a.h(this.a, "onStopTrackingTouch()");
        this.C = false;
    }

    @Override // h95.a
    public final void c() {
        m r0 = this.z;
        if (r0.k == true) goto L6;
        r0.e();
        x();
        return;
    }

    @Override // m65.b
    public long getCurrentTime() {
        if (this.i >= 3) goto L7;
        return this.f / UploadResult.UPLOAD_CACELL;
    L7:
        return this.n.getCurrentPosition() / 1000;
    }

    @Override // m65.b
    public int getPlayState() {
        int r0 = this.i;
        if (r0 != 4) goto L5;
        return 1;
    L5:
        if (r0 == 5) goto L8;
        return 2;
    L8:
        return 3;
    }

    public final void l() {
        tt5.a.h(this.a, "destroy timer");
        this.B = 0;
        this.A.clear();
    }

    public final void m() {
        m r0 = this.z;
        r0.g.cancel();
        r0.i.cancel();
        r0.f.cancel();
        r0.h.cancel();
        this.z.c();
        l();
        VideoSummaryViewModel r1 = this.F;
        if (r1 == null) goto L6;
        r1.enterImmersive();
        return;
    }

    @Override // m85.a
    public final void onRelease() {
        PreviewViewModel r0 = this.q;
        if (r0 != null) goto L5;
    L7:
        this.w.getPlayPosition().setValue(Long.valueOf(this.n.getCurrentPosition()));
        this.w.getStartMedia().postValue(Boolean.FALSE);
        this.n.getCurrentPosition();
        r();
        this.p.removeCallbacksAndMessages(null);
        SystemAudioPlayer r1 = this.n;
        if (r1.f != this) goto L10;
        r1.f = null;
    L10:
        r1.release();
        this.x.removeBlockClickInterceptor(this);
        ((DriveVCFollowVM) this.u.viewModel(DriveVCFollowVM.class)).getLiveIsMuted().removeObserver(this.j);
        return;
    L5:
        if (r0.isBlockViewChanging() == false) goto L7;
    }

    public final void onRenderStart() {
        tt5.a.h(this.a, "onRenderStart()");
    }

    public final void q() {
        m65.b.a r0 = this.o;
        if (r0 == null) goto L6;
        m65.a.C0254a r1 = (m65.a.C0254a) r0;
        r1.getClass();
        tt5.a.b("CCMFollow_AudioVCFollowConnector", "VideoActionStateListener onUserClick: ");
        ((l65.a.C0248a) r1.a).a();
        return;
    }

    public final void r() {
        m65.b.a r0 = this.o;
        if (r0 == null) goto L6;
        tt5.a.b("CCMFollow_AudioVCFollowConnector", "VideoActionStateListener onCurrentTimeChanged: ");
        ((l65.a.C0248a) ((m65.a.C0254a) r0).a).b();
        return;
    }

    public final void s() {
        m65.b.a r0 = this.o;
        if (r0 == null) goto L6;
        tt5.a.b("CCMFollow_AudioVCFollowConnector", "VideoActionStateListener onPlayStateChanged: ");
        ((l65.a.C0248a) ((m65.a.C0254a) r0).a).b();
        return;
    }

    public final void t() {
        tt5.a.h(this.a, "audio view play()");
        PreviewViewModel r0 = this.q;
        if (r0 == null) goto L5;
        r0.liveInnerReportMsg().a(new a0(6));
    L5:
        int r1 = this.i;
        if (r1 == 1) goto L8;
    L10:
        if (r1 != 1) goto L12;
        u();
        return;
    L12:
        this.D = false;
        this.w.tryPlayAudio(this.G);
        return;
    L8:
        if (this.r.a != null) goto L10;
    }

    public final void u() {
        tt5.a.h(this.a, "audio view prepare()");
        if (this.i == 1) goto L9;
        SystemAudioPlayer r0 = this.n;
        r0.getClass();
        r0.c.reset();     // Catch: Exception -> L7
    L7:
        e = move-exception;
        tt5.a.f("SystemAudioPlayer", e, false);
    L9:
        this.n.b(UriProtector.parse(this.r.a));
        this.c.setProgress(0);
    }

    public final void w() {
        this.y.setVisibility(8);
        this.d.setVisibility(8);
        this.x.getBlockTitleViewVisibility().postValue(Boolean.TRUE);
        this.c.e(false);
    }

    public final void x() {
        int r0 = this.i;
        if (r0 != 3) goto L5;
    L8:
        l();
        this.A.add(Flowable.interval(1000, TimeUnit.MILLISECONDS).observeOn(fo5.d.d()).subscribe(new g95.d(this), new g95.e(this)));
        return;
    L5:
        if (r0 == 4) goto L8;
        tt5.a.h(this.a, "current status is not ready or playing, do not need start timer " + this.i);
    }

    public final void y() {
        if (this.k == true) goto L5;
        return;
    L5:
        if (this.i != 4) goto L9;
        this.p.removeCallbacksAndMessages(null);
        this.c.setPlayState(false);
        this.n.pause();
        this.w.getStartMedia().postValue(Boolean.FALSE);
        return;
    }

    public final void n() {
        LayoutInflater.from(getContext()).inflate(2131560213, this);
        ImageView r0 = (ImageView) findViewById(2131375899);
        this.b = r0;
        r0.setImageDrawable(AppCompatResources.getDrawable(getContext(), kac.a.b(2131254619)));
        this.y = (ImageView) findViewById(2131364278);
        this.c = (ProgressBar) findViewById(2131383297);
        this.d = (TextView) findViewById(2131364275);
        this.c.setProgressBg(2131234030);
        this.c.setStartBtnBg(2131234035);
        this.c.setPauseBtnBg(2131234033);
        this.c.setThumbBg(2131234036);
        this.c.setMaxLengthTextColor(2131103449);
        this.c.setProgressTextColor(2131103449);
        this.c.setWholeBackgroundColor(R.color.transparent);
        this.c.setResolutionTextColor(2131103449);
        this.c.setVolumeStateChangedListener(this);
        this.c.setPlayStateChangedListener(this);
        this.c.setProgressSeekedListener(this);
        this.p = new e(this);
        this.y.setTag(2131370304, Boolean.TRUE);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.v.needBindReleaseListener() == true) goto L6;
        onRelease();
        return;
    }

    public AudioView(Context r3) {
        super(r3);
        this.a = "preview_audio_" + hashCode();
        this.i = 1;
        this.s = true;
        this.t = new et3.c("bear_drive_voice_play");
        this.A = new CompositeDisposable();
        this.D = false;
        this.E = 0;
        this.G = new c(this);
        n();
    }

    private void setVolume(boolean r4) {
        if (this.n != null) goto L6;
        tt5.a.d(this.a, "mIPlayer == null, setVolume failed");
        return;
    L6:
        this.g = r4;
        tt5.a.h(this.a, "set Volume =" + this.g + " mForceSilent=" + this.h);
        if (this.h == true) goto L13;
        if (r4 == true) goto L13;
        this.n.setVolume(1.0f);
        PreviewViewModel r5 = this.q;
        if (r5 == null) goto L17;
        r5.liveInnerReportMsg().a(new a0(9));
        return;
    L17:
        return;
    L13:
        this.n.setVolume(0.0f);
        PreviewViewModel r6 = this.q;
        if (r6 == null) goto L19;
        r6.liveInnerReportMsg().a(new a0(8));
        return;
    }

    @Override // com.bytedance.ee.bear.drive.view.widget.ProgressBar.a
    public final void d(boolean r4) {
        tt5.a.h(this.a, "onPlayStateChanged() isPlay=" + r4);
        if (r4 == false) goto L6;
        t();
        this.t.d();
        x();
    L12:
        e(r4);
        return;
    L6:
        if (this.i == 5) goto L11;
        PreviewViewModel r0 = this.q;
        if (r0 == null) goto L10;
        r0.liveInnerReportMsg().a(new a0(7));
    L10:
        this.p.removeCallbacksAndMessages(null);
        this.n.pause();
        this.w.getStartMedia().postValue(Boolean.FALSE);
        s();
    L11:
        this.t.f();
        l();
        goto L12
    }

    @Override // com.bytedance.ee.bear.drive.view.widget.ProgressBar.a
    public final void e(boolean r2) {
        PreviewViewModel r0 = this.q;
        if (r0 != null) goto L5;
        tt5.a.d(this.a, "mPreviewViewModel == null, keep screen on failed");
        return;
    L5:
        r0.liveInnerKeepScreenOn().postValue(Boolean.valueOf(r2));
    }

    @Override // com.bytedance.ee.bear.drive.view.widget.VolumeView.a
    public final void f(boolean r4) {
        tt5.a.h(this.a, "onVolumeStateChanged() isSilent=" + r4);
        setVolume(r4);
    }

    public final void h(int r7) {
        tt5.a.h(this.a, "onPlaybackStateChanged() state = " + this.i);
        this.i = r7;
        boolean r3 = false;
        if (r7 != 3) goto L17;
        g r8 = this.l;
        if (r8 == null) goto L8;
        r8.onViewReady();
    L8:
        if (this.s == false) goto L16;
        this.s = false;
        int r9 = (int) this.n.i();
        this.e = r9;
        this.c.setMaxLength(r9);
        this.d.setText(zu5.b.d(this.e));
        if (this.k == false) goto L12;
    L14:
        if (r3 == false) goto L16;
        this.c.setPlayState(true);
        goto L16
    L12:
        if (this.w.isAutoPlay() == false) goto L14;
        r3 = true;
    L16:
        q();
    L34:
        if (this.i == 4) goto L36;
        return;
    L36:
        if (this.x.getLiveBlockState().getValue() != DriveBlockPreviewVM.BlockState.BLOCK) goto L40;
        x();
        return;
    L40:
        return;
    L17:
        if (r7 != 4) goto L20;
        this.c.setPlayState(true);
        this.p.sendEmptyMessage(0);
        q();
        goto L34
    L20:
        if (r7 != 5) goto L34;
        tt5.a.h(this.a, "audio play finished, curPoint = " + this.n.getPlaybackState() + ", totalLength = " + this.n.i());
        if (this.m == true) goto L24;
        this.c.setProgress(this.e);
    L24:
        this.c.setPlayState(false);
        PreviewViewModel r10 = this.q;
        if (r10 == null) goto L27;
        r10.liveInnerReportMsg().a(new a0(7));
    L27:
        DriveBlockPreviewVM.BlockState r11 = (DriveBlockPreviewVM.BlockState) this.x.getLiveBlockState().getValue();
        if (r11 == null) goto L34;
        MutableLiveData<Boolean> r0 = this.x.getBlockTitleViewVisibility();
        Boolean r4 = Boolean.FALSE;
        r0.postValue(r4);
        m r1 = this.z;
        r1.g.cancel();
        r1.i.cancel();
        r1.f.cancel();
        r1.h.cancel();
        this.z.d();
        l();
        if (r11 != DriveBlockPreviewVM.BlockState.BLOCK) goto L32;
        this.c.e(true);
        this.y.setVisibility(0);
        this.d.setVisibility(0);
    L32:
        this.n.seekTo(0);
        this.n.pause();
        this.w.getStartMedia().postValue(r4);
        q();
        goto L34
    }

    @Override // com.bytedance.ee.bear.drive.view.widget.ProgressBar.b
    public final void i(int r4) {
        if (this.i != 1) goto L5;
        return;
    L5:
        tt5.a.h(this.a, "onProgressSeeked() progress = " + r4);
        this.f = r4;
        this.n.seekTo((long) r4);
        r();
    }

    public final void j(Exception r6) {
        tt5.a.e(this.a, "onPlayerError: ", r6, false);
        long r0 = this.E;
        if (r0 != 0) goto L5;
    L6:
        j65.a.a(this.q, this.a);
    L7:
        this.E = System.currentTimeMillis();
        SystemAudioPlayer r7 = this.n;
        r7.getClass();
        r7.c.reset();     // Catch: Exception -> L10
    L12:
        this.w.getStartMedia().postValue(Boolean.FALSE);
        s();
        this.t.f();
        return;
    L10:
        e = move-exception;
        tt5.a.f("SystemAudioPlayer", e, false);
        goto L12
    L5:
        if (Math.abs(r0 - System.currentTimeMillis()) <= 400) goto L7;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [g95.f] */
    public final void o(d r4) {
        Context r1 = getContext();
        if (this.k == false) goto L5;
    L7:
        boolean r2 = false;
    L8:
        SystemAudioPlayer r0 = new SystemAudioPlayer(r1, r2);
        this.n = r0;
        r0.f = this;
        this.r = r4;
        this.c.setFileModel(r4.b);
        this.j = new f(this);
        ((DriveVCFollowVM) this.u.viewModel(DriveVCFollowVM.class)).getLiveIsMuted().observe(this.u.lifecycleOwner(), this.j);
        return;
    L5:
        if (this.w.isAutoPlay() == false) goto L7;
        r2 = true;
        goto L8
    }

    public final boolean p(double r7) {
        int r0 = this.e;
        if (r0 > 0) goto L5;
    L9:
        return false;
    L5:
        if ((r7 / ((double) r0)) <= 0.949999988079071d) goto L9;
        if (Math.abs(r7 - ((double) r0)) >= 1000.0d) goto L9;
        return true;
    }

    @Override // m65.b
    public void setAudioActionListener(m65.b.a r1) {
        this.o = r1;
    }

    public void setAudioLogoDrawable(int r2) {
        this.b.setImageResource(kac.a.b(r2));
    }

    public void setCurrentTime(double r5) {
        if (this.i >= 2) goto L5;
        return;
    L5:
        int r6 = (int) (r5 * 1000.0d);
        int r7 = this.e;
        if (r7 <= 0) goto L14;
        if (r6 > r7) goto L14;
        if (Math.abs(this.f - r6) < 2000) goto L11;
    L13:
        this.n.seekTo(r6);
        this.c.setProgress(r6);
        r();
        return;
    L11:
        if (Math.abs(this.c.getProgress() - r6) >= 2000) goto L13;
        return;
    L14:
        if (r6 <= r7) goto L18;
        this.n.seekTo(r7);
        this.c.setProgress(this.e);
        return;
    }

    public AudioView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = "preview_audio_" + hashCode();
        this.i = 1;
        this.s = true;
        this.t = new et3.c("bear_drive_voice_play");
        this.A = new CompositeDisposable();
        this.D = false;
        this.E = 0;
        this.G = new c(this);
        n();
    }

    public static /* synthetic */ void k(AudioView r3, Boolean r4) {
        tt5.a.h(r3.a, "setForceSilent =" + r4);
        r3.h = Boolean.TRUE.equals(r4);
        r3.setVolume(r3.g);
    }

    @Override // m65.b
    public final void g(int r5, double r6) {
        setCurrentTime(r6);
        this.m = false;
        if (r5 == 1) goto L16;
        if (r5 != 2) goto L7;
        this.m = true;
        y();
        if (this.y.getVisibility() != 0) goto L13;
    L14:
        w();
        this.z.e();
    L30:
        s();
        return;
    L13:
        if (this.z.k == true) goto L30;
    L7:
        if (r5 == 3) goto L9;
        y();
        goto L30
    L9:
        this.n.seekTo(this.e);
        this.c.setProgress(this.e);
        y();
        goto L30
    L16:
        if (this.p.hasMessages(0) == true) goto L30;
        if (p(r6 * 1000.0d) == true) goto L30;
        DriveBlockPreviewVM.BlockState r7 = (DriveBlockPreviewVM.BlockState) this.x.getLiveBlockState().getValue();
        if (r7 != null) goto L22;
    L29:
        this.p.sendEmptyMessage(0);
        this.c.setPlayState(true);
        t();
        goto L30
    L22:
        if (r7 == DriveBlockPreviewVM.BlockState.FULLSCREEN) goto L29;
        if (this.y.getVisibility() != 0) goto L26;
    L27:
        w();
        this.z.e();
    L28:
        x();
        goto L29
    L26:
        if (this.z.k == true) goto L28;
        goto L27
    }

    public final void onVideoSizeChanged(int r4, int r5) {
        tt5.a.h(this.a, "onVideoSizeChanged() width=" + r4 + ", height=" + r5);
    }

    public final void v(ViewOwner r5, ViewOwner r6) {
        this.u = r6;
        this.q = (PreviewViewModel) r6.viewModel(PreviewViewModel.class);
        this.c.setViewModel(r6);
        this.v = (DriveComponentRenderVM) r5.viewModel(DriveComponentRenderVM.class);
        this.w = (DriveMediaVM) r6.viewModel(DriveMediaVM.class);
        this.x = (DriveBlockPreviewVM) r6.viewModel(DriveBlockPreviewVM.class);
        this.z = new m(getContext(), this.c, new View(getContext()), this.x.getBlockTitleView());
        this.v.bindReleaseListener(this);
        this.w.getPauseMedia().observe(r6.lifecycleOwner(), new g95.a(this));
        this.x.getLiveBlockState().observe(r6.lifecycleOwner(), new g95.b(this));
        this.x.addBlockClickInterceptor(this);
        this.q = (PreviewViewModel) r6.viewModel(PreviewViewModel.class);
        DriveBlockPreviewVM r7 = (DriveBlockPreviewVM) r6.viewModel(DriveBlockPreviewVM.class);
        this.x = r7;
        if (r7.isFromBlockPreview() == true) goto L5;
        VideoSummaryViewModel r8 = (VideoSummaryViewModel) r6.viewModel(VideoSummaryViewModel.class);
        this.F = r8;
        if (r8 == null) goto L11;
        r8.exitImmersive();
    L11:
        setOnClickListener(new b(this));
        return;
    L5:
        if (this.x.getLiveBlockState().getValue() == DriveBlockPreviewVM.BlockState.FULLSCREEN) goto L7;
        this.y.setVisibility(0);
        this.d.setVisibility(0);
    L7:
        this.y.setOnClickListener(new g95.c(this));
        setOnClickListener(new a(this));
    }

    public AudioView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = "preview_audio_" + hashCode();
        this.i = 1;
        this.s = true;
        this.t = new et3.c("bear_drive_voice_play");
        this.A = new CompositeDisposable();
        this.D = false;
        this.E = 0;
        this.G = new c(this);
        n();
    }
}
