package com.bytedance.ee.bear.drive.view.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.bytedance.ee.bear.drive.view.preview.block.DriveBlockPreviewVM;
import com.bytedance.ee.bear.drive.view.preview.media.DriveMediaVM;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.bytedance.ee.bear.drive.view.preview.wrapper.a0;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.larus.nova.R;
import com.ss.android.lark.slideback.SlideFrameLayout;
import java.util.Arrays;

/* JADX INFO: loaded from: classes16.dex */
public class ProgressBar extends FrameLayout implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public CharSequence F;
    public View.OnClickListener G;
    public VolumeView.a H;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f225928J;
    public int K;
    public int L;
    public Drawable M;
    public Drawable N;
    public int O;
    public int P;
    public int Q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f225929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f225930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f225931c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SeekBar f225932d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f225933e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f225934f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f225935g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f225936h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public VolumeView f225937i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f225938j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f225939k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ViewGroup f225940l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ViewGroup f225941m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f225942n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f225943o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f225944p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public a f225945q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public b f225946r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f225947s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public PreviewViewModel f225948t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f225949u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f225950v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public DriveMediaVM f225951w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public DriveBlockPreviewVM f225952x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f225953y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public SlideFrameLayout f225954z;

    public interface a {
        void d(boolean r100);

        void e(boolean r100);
    }

    public interface b {
        void a();

        void b();

        void i(int r100);
    }

    public final void f() {
        this.f225950v = false;
        this.f225947s = false;
        this.D = false;
        setVisibility(0);
        if (this.f225935g == true) goto L5;
    L7:
        this.f225932d.setVisibility(0);
        this.f225937i.setVisibility(0);
        this.f225929a.setVisibility(0);
        this.f225933e.setVisibility(0);
        this.f225938j.setVisibility(0);
        this.f225939k.setVisibility(8);
        this.f225934f.setVisibility(0);
        if (this.B == false) goto L10;
        setBackground(null);
    L11:
        c();
        return;
    L10:
        setBackgroundDrawable(getResources().getDrawable(R.drawable.drive_progressbar_bg));
        goto L11
    L5:
        if (this.B == true) goto L7;
        this.f225936h.setVisibility(0);
        goto L7
    }

    public void setFileModel(z r100) {
    }

    private SlideFrameLayout getMultiTaskSlideFrameLayout() {
        SlideFrameLayout r100 = this.f225954z;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Context r101 = getContext();
        if (r101 != null) goto L8;
    L14:
        return null;
    L8:
        if ((r101 instanceof Activity) == false) goto L14;
        View r102 = ((Activity) r101).findViewById(android.R.id.content);
        if ((r102.getParent() instanceof SlideFrameLayout) == false) goto L14;
        SlideFrameLayout r103 = (SlideFrameLayout) r102.getParent();
        this.f225954z = r103;
        return r103;
    }

    public final void a() {
        this.f225932d.setVisibility(8);
        this.f225937i.setVisibility(8);
        this.f225929a.setVisibility(8);
        this.f225933e.setVisibility(8);
        this.f225938j.setVisibility(8);
        this.f225939k.setVisibility(8);
        this.f225934f.setVisibility(8);
        setBackground(null);
    }

    public final void b() {
        if (this.f225944p == false) goto L5;
        this.f225930b.setVisibility(8);
        this.f225931c.setVisibility(0);
        return;
    L5:
        this.f225930b.setVisibility(0);
        this.f225931c.setVisibility(8);
    }

    public final void c() {
        boolean r100 = this.B;
        if (r100 == true) goto L6;
        return;
    L6:
        if (this.D == false) goto L8;
        a();
        return;
    L8:
        int r101 = 0;
        if (this.f225947s == false) goto L16;
        if (r100 == true) goto L12;
        return;
    L12:
        if (this.f225940l == null) goto L44;
        h(R.dimen.drive_progress_bar_v2_track_seeking_height, R.drawable.drive_progressbar_v2_seeking_video);
        i(true);
        j(R.dimen.drive_progress_bar_v2_time_seeking_size, R.color.drive_video_control_v2_time_secondary, Typeface.create("sans-serif-medium", 0));
        this.f225940l.setVisibility(0);
        this.f225936h.setVisibility(8);
        return;
    L44:
        return;
    L16:
        if (this.C == false) goto L22;
        if (r100 == true) goto L19;
        return;
    L19:
        if (this.f225940l == null) goto L45;
        h(R.dimen.drive_progress_bar_v2_track_normal_height, R.drawable.drive_progressbar_v2_normal_video);
        this.f225940l.setVisibility(8);
        this.f225936h.setVisibility(8);
        this.f225939k.setVisibility(8);
        return;
    L45:
        return;
    L22:
        if (r100 == true) goto L24;
        return;
    L24:
        if (this.f225940l == null) goto L46;
        h(R.dimen.drive_progress_bar_v2_track_normal_height, R.drawable.drive_progressbar_v2_normal_video);
        i(false);
        int r102 = h18.e.f483540a;
        j(R.dimen.drive_progress_bar_v2_time_normal_size, R.color.static_white, h18.e.b(getContext(), 0));
        this.f225940l.setVisibility(0);
        TextView r103 = this.f225936h;
        if (this.f225935g == true) goto L29;
    L31:
        int r104 = 8;
    L32:
        r103.setVisibility(r104);
        View r105 = this.f225939k;
        if (this.f225950v == true) goto L36;
        r101 = 8;
    L36:
        r105.setVisibility(r101);
        return;
    L29:
        if (this.f225950v == true) goto L31;
        r104 = 0;
        goto L32
    }

    public int getMaxLength() {
        return this.f225943o;
    }

    public boolean getPlayState() {
        return this.f225944p;
    }

    public int getProgress() {
        return this.f225942n;
    }

    public ProgressBar(Context r100) {
        super(r100);
        this.f225942n = 0;
        this.f225943o = 0;
        this.f225944p = false;
        this.f225947s = false;
        this.f225949u = -1;
        this.f225953y = true;
        d(R.layout.drive_progress_bar);
    }

    private void setProgressInternal(int r100) {
        this.f225942n = r100;
        this.f225932d.setProgress(r100);
        this.f225933e.setText(zu5.b.d(r100));
        DriveMediaVM r101 = this.f225951w;
        if (r101 == null) goto L6;
        r101.getPlayPosition().postValue(Long.valueOf(r100));
        return;
    }

    public final void d(int r100) {
        removeAllViews();
        LayoutInflater.from(getContext()).inflate(r100, this);
        this.f225929a = (ViewGroup) findViewById(R.id.start_pause_root);
        this.f225930b = (ImageView) findViewById(R.id.start);
        this.f225931c = (ImageView) findViewById(R.id.pause);
        this.f225932d = (SeekBar) findViewById(R.id.seek_bar);
        this.f225933e = (TextView) findViewById(R.id.current);
        this.f225934f = (TextView) findViewById(R.id.length);
        this.f225936h = (TextView) findViewById(R.id.resolution_switch);
        this.f225937i = (VolumeView) findViewById(R.id.drive_video_player_volume_view);
        this.f225938j = findViewById(R.id.length_split);
        this.f225939k = findViewById(R.id.block_enter_full);
        this.f225940l = (ViewGroup) findViewById(R.id.time_container);
        this.f225941m = (ViewGroup) findViewById(R.id.seek_bar_touch_area);
        this.f225937i.setVocalSrc(R.drawable.icon_tool_volume_on_in_dark);
        this.f225937i.setSilentSrc(R.drawable.icon_tool_volume_off_in_dark);
        this.f225931c.setOnClickListener(this);
        this.f225930b.setOnClickListener(this);
        this.f225932d.setOnSeekBarChangeListener(this);
        this.f225939k.setOnClickListener(new k(this));
        ViewGroup r101 = this.f225929a;
        Boolean r102 = Boolean.TRUE;
        r101.setTag(R.id.drive_preview_block_fun_location_tag, r102);
        this.f225932d.setTag(R.id.drive_preview_block_fun_location_tag, r102);
        this.f225937i.setTag(R.id.drive_preview_block_fun_location_tag, r102);
        this.f225939k.setTag(R.id.drive_preview_block_fun_location_tag, r102);
        this.f225932d.setMax(this.f225943o);
        this.f225934f.setText(zu5.b.d(this.f225943o));
        this.f225932d.setProgress(this.f225942n);
        this.f225933e.setText(zu5.b.d(this.f225942n));
        b();
        this.f225936h.setText(this.F);
        if (this.I == 0) goto L6;
        this.f225932d.setProgressDrawable(getResources().getDrawable(this.I, null));
    L6:
        if (this.f225928J == 0) goto L8;
        this.f225932d.setThumb(getResources().getDrawable(this.f225928J, null));
    L8:
        Drawable r103 = this.M;
        if (r103 == null) goto L11;
        this.f225930b.setImageDrawable(r103);
    L14:
        Drawable r104 = this.N;
        if (r104 == null) goto L17;
        this.f225931c.setImageDrawable(r104);
    L21:
        if (this.O == 0) goto L24;
        this.f225934f.setTextColor(getResources().getColor(this.O));
    L24:
        if (this.P == 0) goto L27;
        this.f225933e.setTextColor(getResources().getColor(this.P));
    L27:
        if (this.Q == 0) goto L29;
        this.f225936h.setTextColor(getResources().getColor(this.Q));
    L29:
        this.f225937i.setSilent(this.E);
        this.f225937i.setVolumeStateChangedListener(this.H);
        this.f225936h.setOnClickListener(this.G);
        TextView r105 = this.f225936h;
        if (this.f225935g == true) goto L32;
    L40:
        int r106 = 8;
    L41:
        r105.setVisibility(r106);
        return;
    L32:
        if (this.f225950v == true) goto L40;
        if (this.B == true) goto L36;
    L39:
        r106 = 0;
        goto L41
    L36:
        if (this.f225947s == true) goto L40;
        if (this.C == true) goto L40;
    L17:
        int r107 = this.L;
        if (r107 == 0) goto L21;
        this.f225931c.setImageResource(r107);
        goto L21
    L11:
        int r108 = this.K;
        if (r108 == 0) goto L14;
        this.f225930b.setImageResource(r108);
        goto L14
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r110) {
        SlideFrameLayout r100 = getMultiTaskSlideFrameLayout();
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        boolean r102 = super.dispatchTouchEvent(r110);
        int r111 = r110.getAction();
        if (this.B == false) goto L16;
        if (r111 != 3) goto L16;
        if (this.f225947s == false) goto L16;
        this.f225947s = false;
        c();
        b r103 = this.f225946r;
        if (r103 == null) goto L16;
        r103.b();
    L16:
        if (r100 != null) goto L18;
        return r102;
    L18:
        if (r111 != 0) goto L21;
        this.A = r100.f440571b;
    L21:
        if (r111 == 2) goto L23;
        tt5.a.b("ProgressBar", "ProgressBar dispatchTouchEvent: " + r102 + ", action=" + r111 + ", isSlideable=" + r101 + ", mSlideable=" + this.A);
    L23:
        if (r101 == false) goto L28;
        if (r111 != 0) goto L28;
        if (r102 == false) goto L28;
        r100.setSlideable(false);
    L32:
        return r102;
    L28:
        if (r101 == this.A) goto L32;
        if (Arrays.asList(new Integer[]{1, 3}).contains(Integer.valueOf(r111)) == false) goto L32;
        r100.setSlideable(this.A);
        goto L32
    L5:
        if (r100.f440571b == false) goto L7;
        r101 = true;
        goto L8
    }

    public final void e(boolean r100) {
        this.f225950v = true;
        this.f225947s = false;
        this.D = r100;
        setVisibility(0);
        this.f225936h.setVisibility(8);
        if (r100 == false) goto L5;
        a();
        return;
    L5:
        this.f225932d.setVisibility(0);
        this.f225937i.setVisibility(0);
        this.f225929a.setVisibility(0);
        this.f225933e.setVisibility(0);
        this.f225934f.setVisibility(0);
        this.f225938j.setVisibility(0);
        this.f225939k.setVisibility(0);
        if (this.B == false) goto L8;
        setBackground(null);
    L9:
        c();
        return;
    L8:
        setBackgroundDrawable(getResources().getDrawable(R.drawable.drive_progressbar_bg));
        goto L9
    }

    public final void g(boolean r100) {
        tt5.a.h("ProgressBar", "switchTitle: " + r100);
        this.f225952x.getBlockTitleViewVisibility().postValue(Boolean.valueOf(r100));
    }

    public final void i(boolean r100) {
        FrameLayout.LayoutParams r101 = (FrameLayout.LayoutParams) this.f225940l.getLayoutParams();
        if (r100 == false) goto L5;
        int r102 = 1;
    L6:
        r101.gravity = r102;
        if (r100 == false) goto L9;
        int r103 = 0;
    L10:
        r101.setMarginStart(r103);
        this.f225940l.setLayoutParams(r101);
        return;
    L9:
        r103 = getResources().getDimensionPixelSize(R.dimen.drive_progress_bar_v2_time_normal_start_margin);
        goto L10
    L5:
        r102 = GravityCompat.START;
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        int r101 = r100.getId();
        if (r101 != R.id.start) goto L6;
        setPlayState(true);
        this.f225953y = false;
        g(true);
        return;
    L6:
        if (r101 != R.id.pause) goto L10;
        setPlayState(false);
        return;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar r100) {
        this.f225947s = true;
        c();
        b r101 = this.f225946r;
        if (r101 == null) goto L6;
        r101.a();
        return;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar r100) {
        this.f225947s = false;
        c();
        b r101 = this.f225946r;
        if (r101 == null) goto L6;
        r101.i(r100.getProgress());
        this.f225946r.b();
    L6:
        if (r100.getProgress() <= this.f225949u) goto L10;
        PreviewViewModel r102 = this.f225948t;
        if (r102 == null) goto L13;
        r102.liveInnerReportMsg().a(new a0(4));
    L13:
        this.f225949u = r100.getProgress();
        return;
    L10:
        PreviewViewModel r103 = this.f225948t;
        if (r103 == null) goto L13;
        r103.liveInnerReportMsg().a(new a0(5));
        goto L13
    }

    public void setMaxLength(int r100) {
        this.f225943o = r100;
        this.f225932d.setMax(r100);
        String r101 = zu5.b.d(r100);
        this.f225934f.setText(r101);
    }

    public void setMaxLengthTextColor(int r100) {
        this.O = r100;
        this.f225934f.setTextColor(getResources().getColor(r100));
    }

    public void setPauseBtnBg(int r100) {
        this.L = r100;
        this.N = null;
        this.f225931c.setImageResource(r100);
    }

    public void setPauseBtnDrawable(Drawable r100) {
        this.N = r100;
        this.f225931c.setImageDrawable(r100);
    }

    public void setPlayState(boolean r100) {
        boolean r101 = this.f225944p;
        if (r100 != r101) goto L5;
        return;
    L5:
        if (r100 == r101) goto L8;
        this.f225944p = r100;
        b();
    L8:
        a r102 = this.f225945q;
        if (r102 == null) goto L12;
        r102.d(r100);
        return;
    }

    public void setPlayStateChangedListener(a r100) {
        this.f225945q = r100;
    }

    public void setPlayerState(int r100) {
        boolean r101 = true;
        if (r100 != 5) goto L6;
        this.f225953y = true;
    L6:
        if (r100 == 4) goto L10;
        r101 = false;
    L10:
        if (r101 == this.f225944p) goto L13;
        this.f225944p = r101;
        b();
    L13:
        a r102 = this.f225945q;
        if (r102 == null) goto L17;
        r102.e(r101);
        return;
    }

    public void setProgress(int r100) {
        if (r100 >= 0) goto L4;
        return;
    L4:
        if (r100 <= this.f225943o) goto L6;
        return;
    L6:
        if (this.f225947s == true) goto L12;
        setProgressInternal(r100);
        return;
    }

    public void setProgressBg(int r100) {
        this.I = r100;
        this.f225932d.setProgressDrawable(getResources().getDrawable(r100, null));
    }

    public void setProgressSeekedListener(b r100) {
        this.f225946r = r100;
    }

    public void setProgressTextColor(int r100) {
        this.P = r100;
        this.f225933e.setTextColor(getResources().getColor(r100));
    }

    public void setResolution(String r100) {
        this.F = r100;
        this.f225936h.setText(r100);
    }

    public void setResolutionClickListener(View.OnClickListener r100) {
        this.G = r100;
        this.f225936h.setOnClickListener(r100);
    }

    public void setResolutionTextColor(int r100) {
        this.Q = r100;
        this.f225936h.setTextColor(getResources().getColor(r100));
    }

    public void setResolutionVisible(boolean r100) {
        this.f225935g = r100;
        TextView r101 = this.f225936h;
        if (r100 == true) goto L5;
    L13:
        int r102 = 8;
    L14:
        r101.setVisibility(r102);
        return;
    L5:
        if (this.f225950v == true) goto L13;
        if (this.B == true) goto L9;
    L12:
        r102 = 0;
        goto L14
    L9:
        if (this.f225947s == true) goto L13;
        if (this.C == true) goto L13;
        goto L12
    }

    public void setSilent(boolean r100) {
        this.E = r100;
        this.f225937i.setSilent(r100);
    }

    public void setStartBtnBg(int r100) {
        this.K = r100;
        this.M = null;
        this.f225930b.setImageResource(r100);
    }

    public void setStartBtnDrawable(Drawable r100) {
        this.M = r100;
        this.f225930b.setImageDrawable(r100);
    }

    public void setThumbBg(int r100) {
        this.f225928J = r100;
        this.f225932d.setThumb(getResources().getDrawable(r100, null));
    }

    public void setVideoControlBarClearScreen(boolean r100) {
        if (this.B == true) goto L5;
        return;
    L5:
        if (this.C == r100) goto L10;
        this.C = r100;
        c();
        tt5.a.h("ProgressBar", "setVideoControlBarClearScreen, clearScreen=" + r100 + ", isSeeking=" + this.f225947s + ", isBlock=" + this.f225950v);
        return;
    }

    public void setVideoControlBarV2Enabled(boolean r100) {
        if (r100 == true) goto L5;
        return;
    L5:
        if (this.B == false) goto L18;
        return;
    L18:
        this.B = true;     // Catch: Throwable -> L11
        d(R.layout.drive_progress_bar_v2);     // Catch: Throwable -> L11
        this.f225932d.setThumb(null);     // Catch: Throwable -> L11
        ViewGroup r101 = this.f225941m;     // Catch: Throwable -> L11
        if (r101 != null) goto L13;
        tt5.a.k("ProgressBar", "install v2 seek touch forwarder failed, missing touch area");     // Catch: Throwable -> L11
    L14:
        setBackground(null);     // Catch: Throwable -> L11
        c();     // Catch: Throwable -> L11
        tt5.a.h("ProgressBar", "setVideoControlBarV2Enabled success, v2Enabled=true, isBlock=" + this.f225950v);     // Catch: Throwable -> L11
        return;
    L13:
        r101.setOnTouchListener(new l(this));     // Catch: Throwable -> L11
        tt5.a.h("ProgressBar", "install v2 seek touch forwarder success");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        tt5.a.e("ProgressBar", "setVideoControlBarV2Enabled failed, use legacy", th, false);
        this.B = false;
        d(R.layout.drive_progress_bar);
        setBackgroundResource(R.drawable.drive_progressbar_bg);
    }

    public void setViewModel(ViewOwner r100) {
        this.f225948t = (PreviewViewModel) r100.viewModel(PreviewViewModel.class);
        this.f225951w = (DriveMediaVM) r100.viewModel(DriveMediaVM.class);
        this.f225952x = (DriveBlockPreviewVM) r100.viewModel(DriveBlockPreviewVM.class);
    }

    public void setVolumeStateChangedListener(VolumeView.a r100) {
        this.H = r100;
        this.f225937i.setVolumeStateChangedListener(r100);
    }

    public void setWholeBackgroundColor(int r100) {
        setBackgroundColor(getResources().getColor(r100));
    }

    public ProgressBar(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f225942n = 0;
        this.f225943o = 0;
        this.f225944p = false;
        this.f225947s = false;
        this.f225949u = -1;
        this.f225953y = true;
        d(R.layout.drive_progress_bar);
    }

    public final void h(int r100, int r101) {
        this.f225932d.setProgressDrawable(getResources().getDrawable(r101, null));
        int r102 = getResources().getDimensionPixelSize(r100);
        int r103 = Math.max(0, Math.round(getResources().getDimensionPixelSize(R.dimen.drive_progress_bar_v2_track_center_offset_bottom) - (r102 / 2.0f)));
        FrameLayout.LayoutParams r104 = (FrameLayout.LayoutParams) this.f225932d.getLayoutParams();
        if (r104.height == r102) goto L5;
    L7:
        r104.height = r102;
        r104.bottomMargin = r103;
        this.f225932d.setLayoutParams(r104);
        return;
    L5:
        if (r104.bottomMargin != r103) goto L7;
    }

    public ProgressBar(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f225942n = 0;
        this.f225943o = 0;
        this.f225944p = false;
        this.f225947s = false;
        this.f225949u = -1;
        this.f225953y = true;
        d(R.layout.drive_progress_bar);
    }

    public final void j(int r100, int r101, Typeface r102) {
        float r103 = getResources().getDimension(r100);
        TextView r104 = (TextView) this.f225938j;
        this.f225933e.setTextSize(0, r103);
        r104.setTextSize(0, r103);
        this.f225934f.setTextSize(0, r103);
        this.f225933e.setTypeface(r102);
        r104.setTypeface(r102);
        this.f225934f.setTypeface(r102);
        this.f225933e.setTextColor(getResources().getColor(R.color.static_white));
        r104.setTextColor(getResources().getColor(r101));
        this.f225934f.setTextColor(getResources().getColor(r101));
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar r100, int r101, boolean r102) {
        setProgressInternal(r101);
    }
}
