package com.bytedance.ee.bear.drive.view.preview.audio;

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
import com.larus.nova.R;
import ea5.m;
import g95.f;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes16.dex */
public class AudioView extends FrameLayout implements sf5.a, ProgressBar.a, ProgressBar.b, VolumeView.a, h95.a, m65.b, m85.a {
    public static final /* synthetic */ int H = 0;
    public final CompositeDisposable A;
    public int B;
    public boolean C;
    public boolean D;
    public long E;
    public VideoSummaryViewModel F;
    public final c G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f224743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f224744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ProgressBar f224745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f224746d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f224747e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f224748f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f224749g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f224750h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f224751i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public f f224752j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f224753k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public g f224754l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f224755m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public SystemAudioPlayer f224756n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public m65.b.a f224757o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public e f224758p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public PreviewViewModel f224759q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public d f224760r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f224761s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final et3.c f224762t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ViewOwner f224763u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public DriveComponentRenderVM f224764v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public DriveMediaVM f224765w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public DriveBlockPreviewVM f224766x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ImageView f224767y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public m f224768z;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AudioView f224769a;

        public a(AudioView r100) {
            this.f224769a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            AudioView r101 = this.f224769a;
            if (r101.f224768z.f471610k == false) goto L5;
            return;
        L5:
            if (r101.f224766x.getLiveBlockState().getValue() != DriveBlockPreviewVM.BlockState.BLOCK) goto L13;
            SystemAudioPlayer r102 = this.f224769a.f224756n;
            if (r102 != null) goto L9;
            return;
        L9:
            if (r102.getPlaybackState() != 4) goto L15;
            this.f224769a.f224768z.e();
            return;
        L15:
            return;
        }
    }

    public class b extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AudioView f224770c;

        public b(AudioView r100) {
            this.f224770c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            VideoSummaryViewModel r101 = this.f224770c.F;
            if (r101 != null) goto L5;
        L8:
            AudioView r102 = this.f224770c;
            boolean r103 = r102.f224768z.f471610k;
            VideoSummaryViewModel r104 = r102.F;
            if (r104 == null) goto L11;
            r104.sendEvent(new fa5.c.a(r103));
        L11:
            if (r103 == true) goto L15;
            AudioView r105 = this.f224770c;
            m r106 = r105.f224768z;
            r106.f471606g.cancel();
            r106.f471608i.cancel();
            r106.f471605f.cancel();
            r106.f471607h.cancel();
            r105.f224768z.e();
            r105.x();
            VideoSummaryViewModel r107 = r105.F;
            if (r107 == null) goto L17;
            r107.exitImmersive();
            return;
        L17:
            return;
        L15:
            this.f224770c.m();
            return;
        L5:
            if (r101.isSummaryExpand() == false) goto L8;
            this.f224770c.F.collapseSummary();
        }
    }

    public class c implements u95.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AudioView f224771a;

        @Override // u95.a
        public final void a() {
            this.f224771a.f224758p.removeCallbacksAndMessages(null);
            this.f224771a.f224745c.setPlayState(false);
            this.f224771a.f224756n.pause();
            this.f224771a.f224765w.getStartMedia().postValue(Boolean.FALSE);
        }

        public final void e() {
            this.f224771a.f224765w.getStartMedia().postValue(Boolean.TRUE);
            AudioView r100 = this.f224771a;
            if (r100.D == false) goto L5;
            r100.w();
            this.f224771a.l();
            this.f224771a.x();
        L5:
            this.f224771a.f224756n.start();
            this.f224771a.s();
        }

        @Override // u95.a
        public final void c() {
            e();
        }

        @Override // u95.a
        public final void d() {
            e();
        }

        public c(AudioView r100) {
            this.f224771a = r100;
        }

        @Override // u95.a
        public final void b(final String r100) {
            if (TextUtils.isEmpty(r100) == true) goto L5;
            final AudioView r101 = this.f224771a;
            int r102 = AudioView.H;
            r101.getClass();
            com.bytedance.ee.util.ui.m.a(new g95.g(r101, r100));
            return;
        L5:
            e();
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f224772a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final z f224773b;

        public d(String r100, z r101) {
            this.f224772a = r100;
            this.f224773b = r101;
        }
    }

    public static class e extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<AudioView> f224774a;

        public e(AudioView r100) {
            this.f224774a = new WeakReference(r100);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            if (r100.what != 0) goto L22;
            AudioView r101 = this.f224774a.get();
            if (r101 != null) goto L8;
            return;
        L8:
            if (r101.f224751i != 4) goto L23;
            int r102 = (int) r101.f224756n.getCurrentPosition();
            r101.f224748f = r102;
            r101.f224745c.setProgress(r102);
            if (r101.p(r101.f224748f) == false) goto L13;
            r101.f224751i = 5;
        L13:
            r101.r();
            tt5.a.h(r101.f224743a, "updateProgress, curPosition = " + r101.f224748f + ", audioLength = " + r101.f224747e);
            if (r101.f224748f < r101.f224747e) goto L16;
            return;
        L16:
            if (r101.f224751i != 4) goto L21;
            r101.f224758p.sendEmptyMessageDelayed(0, 1000);
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
        tt5.a.h(this.f224743a, "onStartTrackingTouch()");
        this.C = true;
    }

    @Override // com.bytedance.ee.bear.drive.view.widget.ProgressBar.b
    public final void b() {
        tt5.a.h(this.f224743a, "onStopTrackingTouch()");
        this.C = false;
    }

    @Override // h95.a
    public final void c() {
        m r100 = this.f224768z;
        if (r100.f471610k == true) goto L6;
        r100.e();
        x();
        return;
    }

    @Override // m65.b
    public long getCurrentTime() {
        if (this.f224751i >= 3) goto L7;
        return this.f224748f / 1000;
    L7:
        return this.f224756n.getCurrentPosition() / 1000;
    }

    @Override // m65.b
    public int getPlayState() {
        int r100 = this.f224751i;
        if (r100 != 4) goto L5;
        return 1;
    L5:
        if (r100 == 5) goto L8;
        return 2;
    L8:
        return 3;
    }

    public final void l() {
        tt5.a.h(this.f224743a, "destroy timer");
        this.B = 0;
        this.A.clear();
    }

    public final void m() {
        m r100 = this.f224768z;
        r100.f471606g.cancel();
        r100.f471608i.cancel();
        r100.f471605f.cancel();
        r100.f471607h.cancel();
        this.f224768z.c();
        l();
        VideoSummaryViewModel r101 = this.F;
        if (r101 == null) goto L6;
        r101.enterImmersive();
        return;
    }

    @Override // m85.a
    public final void onRelease() {
        PreviewViewModel r100 = this.f224759q;
        if (r100 != null) goto L5;
    L7:
        this.f224765w.getPlayPosition().setValue(Long.valueOf(this.f224756n.getCurrentPosition()));
        this.f224765w.getStartMedia().postValue(Boolean.FALSE);
        this.f224756n.getCurrentPosition();
        r();
        this.f224758p.removeCallbacksAndMessages(null);
        SystemAudioPlayer r101 = this.f224756n;
        if (r101.f225545f != this) goto L10;
        r101.f225545f = null;
    L10:
        r101.release();
        this.f224766x.removeBlockClickInterceptor(this);
        ((DriveVCFollowVM) this.f224763u.viewModel(DriveVCFollowVM.class)).getLiveIsMuted().removeObserver(this.f224752j);
        return;
    L5:
        if (r100.isBlockViewChanging() == false) goto L7;
    }

    @Override // sf5.a
    public final void onRenderStart() {
        tt5.a.h(this.f224743a, "onRenderStart()");
    }

    public final void q() {
        m65.b.a r100 = this.f224757o;
        if (r100 == null) goto L6;
        m65.a.C6774a r101 = (m65.a.C6774a) r100;
        r101.getClass();
        tt5.a.b("CCMFollow_AudioVCFollowConnector", "VideoActionStateListener onUserClick: ");
        ((l65.a.C6654a) r101.f512284a).a();
        return;
    }

    public final void r() {
        m65.b.a r100 = this.f224757o;
        if (r100 == null) goto L6;
        tt5.a.b("CCMFollow_AudioVCFollowConnector", "VideoActionStateListener onCurrentTimeChanged: ");
        ((l65.a.C6654a) ((m65.a.C6774a) r100).f512284a).b();
        return;
    }

    public final void s() {
        m65.b.a r100 = this.f224757o;
        if (r100 == null) goto L6;
        tt5.a.b("CCMFollow_AudioVCFollowConnector", "VideoActionStateListener onPlayStateChanged: ");
        ((l65.a.C6654a) ((m65.a.C6774a) r100).f512284a).b();
        return;
    }

    public final void t() {
        tt5.a.h(this.f224743a, "audio view play()");
        PreviewViewModel r100 = this.f224759q;
        if (r100 == null) goto L5;
        r100.liveInnerReportMsg().a(new a0(6));
    L5:
        int r101 = this.f224751i;
        if (r101 == 1) goto L8;
    L10:
        if (r101 != 1) goto L12;
        u();
        return;
    L12:
        this.D = false;
        this.f224765w.tryPlayAudio(this.G);
        return;
    L8:
        if (this.f224760r.f224772a != null) goto L10;
    }

    public final void u() {
        tt5.a.h(this.f224743a, "audio view prepare()");
        if (this.f224751i == 1) goto L9;
        SystemAudioPlayer r100 = this.f224756n;
        r100.getClass();
        r100.f225542c.reset();     // Catch: Exception -> L7
    L7:
        e = move-exception;
        tt5.a.f("SystemAudioPlayer", e, false);
    L9:
        this.f224756n.b(UriProtector.parse(this.f224760r.f224772a));
        this.f224745c.setProgress(0);
    }

    public final void w() {
        this.f224767y.setVisibility(8);
        this.f224746d.setVisibility(8);
        this.f224766x.getBlockTitleViewVisibility().postValue(Boolean.TRUE);
        this.f224745c.e(false);
    }

    public final void x() {
        int r100 = this.f224751i;
        if (r100 != 3) goto L5;
    L8:
        l();
        this.A.add(Flowable.interval(1000, TimeUnit.MILLISECONDS).observeOn(fo5.d.d()).subscribe(new g95.d(this), new g95.e(this)));
        return;
    L5:
        if (r100 == 4) goto L8;
        tt5.a.h(this.f224743a, "current status is not ready or playing, do not need start timer " + this.f224751i);
    }

    public final void y() {
        if (this.f224753k == true) goto L5;
        return;
    L5:
        if (this.f224751i != 4) goto L9;
        this.f224758p.removeCallbacksAndMessages(null);
        this.f224745c.setPlayState(false);
        this.f224756n.pause();
        this.f224765w.getStartMedia().postValue(Boolean.FALSE);
        return;
    }

    public final void n() {
        LayoutInflater.from(getContext()).inflate(R.layout.drive_preview_audio_view, this);
        ImageView r100 = (ImageView) findViewById(R.id.ivAudioLogo);
        this.f224744b = r100;
        r100.setImageDrawable(AppCompatResources.getDrawable(getContext(), kac.a.b(R.drawable.ud_icon_file_round_audio_colorful)));
        this.f224767y = (ImageView) findViewById(R.id.block_play);
        this.f224745c = (ProgressBar) findViewById(R.id.progress_bar);
        this.f224746d = (TextView) findViewById(R.id.block_length);
        this.f224745c.setProgressBg(R.drawable.drive_progressbar_bg_audio);
        this.f224745c.setStartBtnBg(R.drawable.drive_progressbar_play_white);
        this.f224745c.setPauseBtnBg(R.drawable.drive_progressbar_pause_white);
        this.f224745c.setThumbBg(R.drawable.drive_progressbar_thumb_video);
        this.f224745c.setMaxLengthTextColor(R.color.lkui_N00);
        this.f224745c.setProgressTextColor(R.color.lkui_N00);
        this.f224745c.setWholeBackgroundColor(android.R.color.transparent);
        this.f224745c.setResolutionTextColor(R.color.lkui_N00);
        this.f224745c.setVolumeStateChangedListener(this);
        this.f224745c.setPlayStateChangedListener(this);
        this.f224745c.setProgressSeekedListener(this);
        this.f224758p = new e(this);
        this.f224767y.setTag(R.id.drive_preview_block_fun_location_tag, Boolean.TRUE);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f224764v.needBindReleaseListener() == true) goto L6;
        onRelease();
        return;
    }

    public AudioView(Context r100) {
        super(r100);
        this.f224743a = "preview_audio_" + hashCode();
        this.f224751i = 1;
        this.f224761s = true;
        this.f224762t = new et3.c("bear_drive_voice_play");
        this.A = new CompositeDisposable();
        this.D = false;
        this.E = 0;
        this.G = new c(this);
        n();
    }

    private void setVolume(boolean r100) {
        if (this.f224756n != null) goto L6;
        tt5.a.d(this.f224743a, "mIPlayer == null, setVolume failed");
        return;
    L6:
        this.f224749g = r100;
        tt5.a.h(this.f224743a, "set Volume =" + this.f224749g + " mForceSilent=" + this.f224750h);
        if (this.f224750h == true) goto L13;
        if (r100 == true) goto L13;
        this.f224756n.setVolume(1.0f);
        PreviewViewModel r101 = this.f224759q;
        if (r101 == null) goto L17;
        r101.liveInnerReportMsg().a(new a0(9));
        return;
    L17:
        return;
    L13:
        this.f224756n.setVolume(0.0f);
        PreviewViewModel r102 = this.f224759q;
        if (r102 == null) goto L19;
        r102.liveInnerReportMsg().a(new a0(8));
        return;
    }

    @Override // com.bytedance.ee.bear.drive.view.widget.ProgressBar.a
    public final void d(boolean r100) {
        tt5.a.h(this.f224743a, "onPlayStateChanged() isPlay=" + r100);
        if (r100 == false) goto L6;
        t();
        this.f224762t.d();
        x();
    L12:
        e(r100);
        return;
    L6:
        if (this.f224751i == 5) goto L11;
        PreviewViewModel r101 = this.f224759q;
        if (r101 == null) goto L10;
        r101.liveInnerReportMsg().a(new a0(7));
    L10:
        this.f224758p.removeCallbacksAndMessages(null);
        this.f224756n.pause();
        this.f224765w.getStartMedia().postValue(Boolean.FALSE);
        s();
    L11:
        this.f224762t.f();
        l();
        goto L12
    }

    @Override // com.bytedance.ee.bear.drive.view.widget.ProgressBar.a
    public final void e(boolean r100) {
        PreviewViewModel r101 = this.f224759q;
        if (r101 != null) goto L5;
        tt5.a.d(this.f224743a, "mPreviewViewModel == null, keep screen on failed");
        return;
    L5:
        r101.liveInnerKeepScreenOn().postValue(Boolean.valueOf(r100));
    }

    @Override // com.bytedance.ee.bear.drive.view.widget.VolumeView.a
    public final void f(boolean r100) {
        tt5.a.h(this.f224743a, "onVolumeStateChanged() isSilent=" + r100);
        setVolume(r100);
    }

    @Override // sf5.a
    public final void h(int r100) {
        tt5.a.h(this.f224743a, "onPlaybackStateChanged() state = " + this.f224751i);
        this.f224751i = r100;
        boolean r101 = false;
        if (r100 != 3) goto L17;
        g r102 = this.f224754l;
        if (r102 == null) goto L8;
        r102.onViewReady();
    L8:
        if (this.f224761s == false) goto L16;
        this.f224761s = false;
        int r103 = (int) this.f224756n.i();
        this.f224747e = r103;
        this.f224745c.setMaxLength(r103);
        this.f224746d.setText(zu5.b.d(this.f224747e));
        if (this.f224753k == false) goto L12;
    L14:
        if (r101 == false) goto L16;
        this.f224745c.setPlayState(true);
        goto L16
    L12:
        if (this.f224765w.isAutoPlay() == false) goto L14;
        r101 = true;
    L16:
        q();
    L34:
        if (this.f224751i == 4) goto L36;
        return;
    L36:
        if (this.f224766x.getLiveBlockState().getValue() != DriveBlockPreviewVM.BlockState.BLOCK) goto L40;
        x();
        return;
    L40:
        return;
    L17:
        if (r100 != 4) goto L20;
        this.f224745c.setPlayState(true);
        this.f224758p.sendEmptyMessage(0);
        q();
        goto L34
    L20:
        if (r100 != 5) goto L34;
        tt5.a.h(this.f224743a, "audio play finished, curPoint = " + this.f224756n.getPlaybackState() + ", totalLength = " + this.f224756n.i());
        if (this.f224755m == true) goto L24;
        this.f224745c.setProgress(this.f224747e);
    L24:
        this.f224745c.setPlayState(false);
        PreviewViewModel r104 = this.f224759q;
        if (r104 == null) goto L27;
        r104.liveInnerReportMsg().a(new a0(7));
    L27:
        DriveBlockPreviewVM.BlockState r105 = this.f224766x.getLiveBlockState().getValue();
        if (r105 == null) goto L34;
        MutableLiveData<Boolean> r106 = this.f224766x.getBlockTitleViewVisibility();
        Boolean r107 = Boolean.FALSE;
        r106.postValue(r107);
        m r108 = this.f224768z;
        r108.f471606g.cancel();
        r108.f471608i.cancel();
        r108.f471605f.cancel();
        r108.f471607h.cancel();
        this.f224768z.d();
        l();
        if (r105 != DriveBlockPreviewVM.BlockState.BLOCK) goto L32;
        this.f224745c.e(true);
        this.f224767y.setVisibility(0);
        this.f224746d.setVisibility(0);
    L32:
        this.f224756n.seekTo(0);
        this.f224756n.pause();
        this.f224765w.getStartMedia().postValue(r107);
        q();
        goto L34
    }

    @Override // com.bytedance.ee.bear.drive.view.widget.ProgressBar.b
    public final void i(int r100) {
        if (this.f224751i != 1) goto L5;
        return;
    L5:
        tt5.a.h(this.f224743a, "onProgressSeeked() progress = " + r100);
        this.f224748f = r100;
        this.f224756n.seekTo((long) r100);
        r();
    }

    @Override // sf5.a
    public final void j(Exception r100) {
        tt5.a.e(this.f224743a, "onPlayerError: ", r100, false);
        long r101 = this.E;
        if (r101 != 0) goto L5;
    L6:
        j65.a.a(this.f224759q, this.f224743a);
    L7:
        this.E = System.currentTimeMillis();
        SystemAudioPlayer r102 = this.f224756n;
        r102.getClass();
        r102.f225542c.reset();     // Catch: Exception -> L10
    L12:
        this.f224765w.getStartMedia().postValue(Boolean.FALSE);
        s();
        this.f224762t.f();
        return;
    L10:
        e = move-exception;
        tt5.a.f("SystemAudioPlayer", e, false);
        goto L12
    L5:
        if (Math.abs(r101 - System.currentTimeMillis()) <= 400) goto L7;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [g95.f] */
    public final void o(d r100) {
        Context r101 = getContext();
        if (this.f224753k == false) goto L5;
    L7:
        boolean r102 = false;
    L8:
        SystemAudioPlayer r103 = new SystemAudioPlayer(r101, r102);
        this.f224756n = r103;
        r103.f225545f = this;
        this.f224760r = r100;
        this.f224745c.setFileModel(r100.f224773b);
        this.f224752j = new f(this);
        ((DriveVCFollowVM) this.f224763u.viewModel(DriveVCFollowVM.class)).getLiveIsMuted().observe(this.f224763u.lifecycleOwner(), this.f224752j);
        return;
    L5:
        if (this.f224765w.isAutoPlay() == false) goto L7;
        r102 = true;
        goto L8
    }

    public final boolean p(double r100) {
        int r101 = this.f224747e;
        if (r101 > 0) goto L5;
    L9:
        return false;
    L5:
        if ((r100 / ((double) r101)) <= 0.949999988079071d) goto L9;
        if (Math.abs(r100 - ((double) r101)) >= 1000.0d) goto L9;
        return true;
    }

    @Override // m65.b
    public void setAudioActionListener(m65.b.a r100) {
        this.f224757o = r100;
    }

    public void setAudioLogoDrawable(int r100) {
        this.f224744b.setImageResource(kac.a.b(r100));
    }

    public void setCurrentTime(double r100) {
        if (this.f224751i >= 2) goto L5;
        return;
    L5:
        int r101 = (int) (r100 * 1000.0d);
        int r102 = this.f224747e;
        if (r102 <= 0) goto L14;
        if (r101 > r102) goto L14;
        if (Math.abs(this.f224748f - r101) < 2000) goto L11;
    L13:
        this.f224756n.seekTo(r101);
        this.f224745c.setProgress(r101);
        r();
        return;
    L11:
        if (Math.abs(this.f224745c.getProgress() - r101) >= 2000) goto L13;
        return;
    L14:
        if (r101 <= r102) goto L18;
        this.f224756n.seekTo(r102);
        this.f224745c.setProgress(this.f224747e);
        return;
    }

    public AudioView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f224743a = "preview_audio_" + hashCode();
        this.f224751i = 1;
        this.f224761s = true;
        this.f224762t = new et3.c("bear_drive_voice_play");
        this.A = new CompositeDisposable();
        this.D = false;
        this.E = 0;
        this.G = new c(this);
        n();
    }

    public static /* synthetic */ void k(AudioView r100, Boolean r101) {
        tt5.a.h(r100.f224743a, "setForceSilent =" + r101);
        r100.f224750h = Boolean.TRUE.equals(r101);
        r100.setVolume(r100.f224749g);
    }

    @Override // m65.b
    public final void g(int r100, double r101) {
        setCurrentTime(r101);
        this.f224755m = false;
        if (r100 == 1) goto L16;
        if (r100 != 2) goto L7;
        this.f224755m = true;
        y();
        if (this.f224767y.getVisibility() != 0) goto L13;
    L14:
        w();
        this.f224768z.e();
    L30:
        s();
        return;
    L13:
        if (this.f224768z.f471610k == true) goto L30;
    L7:
        if (r100 == 3) goto L9;
        y();
        goto L30
    L9:
        this.f224756n.seekTo(this.f224747e);
        this.f224745c.setProgress(this.f224747e);
        y();
        goto L30
    L16:
        if (this.f224758p.hasMessages(0) == true) goto L30;
        if (p(r101 * 1000.0d) == true) goto L30;
        DriveBlockPreviewVM.BlockState r102 = this.f224766x.getLiveBlockState().getValue();
        if (r102 != null) goto L22;
    L29:
        this.f224758p.sendEmptyMessage(0);
        this.f224745c.setPlayState(true);
        t();
        goto L30
    L22:
        if (r102 == DriveBlockPreviewVM.BlockState.FULLSCREEN) goto L29;
        if (this.f224767y.getVisibility() != 0) goto L26;
    L27:
        w();
        this.f224768z.e();
    L28:
        x();
        goto L29
    L26:
        if (this.f224768z.f471610k == true) goto L28;
        goto L27
    }

    @Override // sf5.a
    public final void onVideoSizeChanged(int r100, int r101) {
        tt5.a.h(this.f224743a, "onVideoSizeChanged() width=" + r100 + ", height=" + r101);
    }

    public final void v(ViewOwner r100, ViewOwner r101) {
        this.f224763u = r101;
        this.f224759q = (PreviewViewModel) r101.viewModel(PreviewViewModel.class);
        this.f224745c.setViewModel(r101);
        this.f224764v = (DriveComponentRenderVM) r100.viewModel(DriveComponentRenderVM.class);
        this.f224765w = (DriveMediaVM) r101.viewModel(DriveMediaVM.class);
        this.f224766x = (DriveBlockPreviewVM) r101.viewModel(DriveBlockPreviewVM.class);
        this.f224768z = new m(getContext(), this.f224745c, new View(getContext()), this.f224766x.getBlockTitleView());
        this.f224764v.bindReleaseListener(this);
        this.f224765w.getPauseMedia().observe(r101.lifecycleOwner(), new g95.a(this));
        this.f224766x.getLiveBlockState().observe(r101.lifecycleOwner(), new g95.b(this));
        this.f224766x.addBlockClickInterceptor(this);
        this.f224759q = (PreviewViewModel) r101.viewModel(PreviewViewModel.class);
        DriveBlockPreviewVM r102 = (DriveBlockPreviewVM) r101.viewModel(DriveBlockPreviewVM.class);
        this.f224766x = r102;
        if (r102.isFromBlockPreview() == true) goto L5;
        VideoSummaryViewModel r103 = (VideoSummaryViewModel) r101.viewModel(VideoSummaryViewModel.class);
        this.F = r103;
        if (r103 == null) goto L11;
        r103.exitImmersive();
    L11:
        setOnClickListener(new b(this));
        return;
    L5:
        if (this.f224766x.getLiveBlockState().getValue() == DriveBlockPreviewVM.BlockState.FULLSCREEN) goto L7;
        this.f224767y.setVisibility(0);
        this.f224746d.setVisibility(0);
    L7:
        this.f224767y.setOnClickListener(new g95.c(this));
        setOnClickListener(new a(this));
    }

    public AudioView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f224743a = "preview_audio_" + hashCode();
        this.f224751i = 1;
        this.f224761s = true;
        this.f224762t = new et3.c("bear_drive_voice_play");
        this.A = new CompositeDisposable();
        this.D = false;
        this.E = 0;
        this.G = new c(this);
        n();
    }
}
