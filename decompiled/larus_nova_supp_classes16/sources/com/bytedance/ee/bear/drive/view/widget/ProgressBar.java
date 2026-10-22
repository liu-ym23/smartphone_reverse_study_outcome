package com.bytedance.ee.bear.drive.view.widget;

import android.R;
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
import com.bytedance.ee.bear.drive.view.preview.block.DriveBlockPreviewVM;
import com.bytedance.ee.bear.drive.view.preview.media.DriveMediaVM;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.bytedance.ee.bear.drive.view.preview.wrapper.a0;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.ss.android.lark.slideback.SlideFrameLayout;
import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
    public int J;
    public int K;
    public int L;
    public Drawable M;
    public Drawable N;
    public int O;
    public int P;
    public int Q;
    public ViewGroup a;
    public ImageView b;
    public ImageView c;
    public SeekBar d;
    public TextView e;
    public TextView f;
    public boolean g;
    public TextView h;
    public VolumeView i;
    public View j;
    public View k;
    public ViewGroup l;
    public ViewGroup m;
    public int n;
    public int o;
    public boolean p;
    public a q;
    public b r;
    public boolean s;
    public PreviewViewModel t;
    public int u;
    public boolean v;
    public DriveMediaVM w;
    public DriveBlockPreviewVM x;
    public boolean y;
    public SlideFrameLayout z;

    public interface a {
        void d(boolean r1);

        void e(boolean r1);
    }

    public interface b {
        void a();

        void b();

        void i(int r1);
    }

    public final void f() {
        this.v = false;
        this.s = false;
        this.D = false;
        setVisibility(0);
        if (this.g == true) goto L5;
    L7:
        this.d.setVisibility(0);
        this.i.setVisibility(0);
        this.a.setVisibility(0);
        this.e.setVisibility(0);
        this.j.setVisibility(0);
        this.k.setVisibility(8);
        this.f.setVisibility(0);
        if (this.B == false) goto L10;
        setBackground(null);
    L11:
        c();
        return;
    L10:
        setBackgroundDrawable(getResources().getDrawable(2131234029));
        goto L11
    L5:
        if (this.B == true) goto L7;
        this.h.setVisibility(0);
        goto L7
    }

    public void setFileModel(z r1) {
    }

    private SlideFrameLayout getMultiTaskSlideFrameLayout() {
        SlideFrameLayout r0 = this.z;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Context r1 = getContext();
        if (r1 != null) goto L8;
    L14:
        return null;
    L8:
        if ((r1 instanceof Activity) == false) goto L14;
        View r2 = ((Activity) r1).findViewById(R.id.content);
        if ((r2.getParent() instanceof SlideFrameLayout) == false) goto L14;
        SlideFrameLayout r3 = r2.getParent();
        this.z = r3;
        return r3;
    }

    public final void a() {
        this.d.setVisibility(8);
        this.i.setVisibility(8);
        this.a.setVisibility(8);
        this.e.setVisibility(8);
        this.j.setVisibility(8);
        this.k.setVisibility(8);
        this.f.setVisibility(8);
        setBackground(null);
    }

    public final void b() {
        if (this.p == false) goto L5;
        this.b.setVisibility(8);
        this.c.setVisibility(0);
        return;
    L5:
        this.b.setVisibility(0);
        this.c.setVisibility(8);
    }

    public final void c() {
        boolean r0 = this.B;
        if (r0 == true) goto L6;
        return;
    L6:
        if (this.D == false) goto L8;
        a();
        return;
    L8:
        int r2 = 0;
        if (this.s == false) goto L16;
        if (r0 == true) goto L12;
        return;
    L12:
        if (this.l == null) goto L44;
        h(2131166337, 2131234038);
        i(true);
        j(2131166333, 2131101400, Typeface.create("sans-serif-medium", 0));
        this.l.setVisibility(0);
        this.h.setVisibility(8);
        return;
    L44:
        return;
    L16:
        if (this.C == false) goto L22;
        if (r0 == true) goto L19;
        return;
    L19:
        if (this.l == null) goto L45;
        h(2131166336, 2131234037);
        this.l.setVisibility(8);
        this.h.setVisibility(8);
        this.k.setVisibility(8);
        return;
    L45:
        return;
    L22:
        if (r0 == true) goto L24;
        return;
    L24:
        if (this.l == null) goto L46;
        h(2131166336, 2131234037);
        i(false);
        int r1 = h18.e.a;
        j(2131166331, 2131106521, h18.e.b(getContext(), 0));
        this.l.setVisibility(0);
        TextView r3 = this.h;
        if (this.g == true) goto L29;
    L31:
        int r4 = 8;
    L32:
        r3.setVisibility(r4);
        View r5 = this.k;
        if (this.v == true) goto L36;
        r2 = 8;
    L36:
        r5.setVisibility(r2);
        return;
    L29:
        if (this.v == true) goto L31;
        r4 = 0;
        goto L32
    }

    public int getMaxLength() {
        return this.o;
    }

    public boolean getPlayState() {
        return this.p;
    }

    public int getProgress() {
        return this.n;
    }

    public ProgressBar(Context r1) {
        super(r1);
        this.n = 0;
        this.o = 0;
        this.p = false;
        this.s = false;
        this.u = -1;
        this.y = true;
        d(2131560225);
    }

    private void setProgressInternal(int r4) {
        this.n = r4;
        this.d.setProgress(r4);
        this.e.setText(zu5.b.d(r4));
        DriveMediaVM r0 = this.w;
        if (r0 == null) goto L6;
        r0.getPlayPosition().postValue(Long.valueOf(r4));
        return;
    }

    public final void d(int r4) {
        removeAllViews();
        LayoutInflater.from(getContext()).inflate(r4, this);
        this.a = (ViewGroup) findViewById(2131387227);
        this.b = (ImageView) findViewById(2131387199);
        this.c = (ImageView) findViewById(2131381971);
        this.d = (SeekBar) findViewById(2131385750);
        this.e = (TextView) findViewById(2131368322);
        this.f = (TextView) findViewById(2131377832);
        this.h = (TextView) findViewById(2131384424);
        this.i = (VolumeView) findViewById(2131370345);
        this.j = findViewById(2131377833);
        this.k = findViewById(2131364272);
        this.l = (ViewGroup) findViewById(2131388662);
        this.m = (ViewGroup) findViewById(2131385757);
        this.i.setVocalSrc(2131238089);
        this.i.setSilentSrc(2131238088);
        this.c.setOnClickListener(this);
        this.b.setOnClickListener(this);
        this.d.setOnSeekBarChangeListener(this);
        this.k.setOnClickListener(new k(this));
        ViewGroup r5 = this.a;
        Boolean r0 = Boolean.TRUE;
        r5.setTag(2131370304, r0);
        this.d.setTag(2131370304, r0);
        this.i.setTag(2131370304, r0);
        this.k.setTag(2131370304, r0);
        this.d.setMax(this.o);
        this.f.setText(zu5.b.d(this.o));
        this.d.setProgress(this.n);
        this.e.setText(zu5.b.d(this.n));
        b();
        this.h.setText(this.F);
        if (this.I == 0) goto L6;
        this.d.setProgressDrawable(getResources().getDrawable(this.I, null));
    L6:
        if (this.J == 0) goto L8;
        this.d.setThumb(getResources().getDrawable(this.J, null));
    L8:
        Drawable r6 = this.M;
        if (r6 == null) goto L11;
        this.b.setImageDrawable(r6);
    L14:
        Drawable r7 = this.N;
        if (r7 == null) goto L17;
        this.c.setImageDrawable(r7);
    L21:
        if (this.O == 0) goto L24;
        this.f.setTextColor(getResources().getColor(this.O));
    L24:
        if (this.P == 0) goto L27;
        this.e.setTextColor(getResources().getColor(this.P));
    L27:
        if (this.Q == 0) goto L29;
        this.h.setTextColor(getResources().getColor(this.Q));
    L29:
        this.i.setSilent(this.E);
        this.i.setVolumeStateChangedListener(this.H);
        this.h.setOnClickListener(this.G);
        TextView r8 = this.h;
        if (this.g == true) goto L32;
    L40:
        int r1 = 8;
    L41:
        r8.setVisibility(r1);
        return;
    L32:
        if (this.v == true) goto L40;
        if (this.B == true) goto L36;
    L39:
        r1 = 0;
        goto L41
    L36:
        if (this.s == true) goto L40;
        if (this.C == true) goto L40;
    L17:
        int r9 = this.L;
        if (r9 == 0) goto L21;
        this.c.setImageResource(r9);
        goto L21
    L11:
        int r10 = this.K;
        if (r10 == 0) goto L14;
        this.b.setImageResource(r10);
        goto L14
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r10) {
        SlideFrameLayout r0 = getMultiTaskSlideFrameLayout();
        if (r0 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        boolean r4 = super.dispatchTouchEvent(r10);
        int r11 = r10.getAction();
        if (this.B == false) goto L16;
        if (r11 != 3) goto L16;
        if (this.s == false) goto L16;
        this.s = false;
        c();
        b r5 = this.r;
        if (r5 == null) goto L16;
        r5.b();
    L16:
        if (r0 != null) goto L18;
        return r4;
    L18:
        if (r11 != 0) goto L21;
        this.A = r0.b;
    L21:
        if (r11 == 2) goto L23;
        tt5.a.b("ProgressBar", "ProgressBar dispatchTouchEvent: " + r4 + ", action=" + r11 + ", isSlideable=" + r3 + ", mSlideable=" + this.A);
    L23:
        if (r3 == false) goto L28;
        if (r11 != 0) goto L28;
        if (r4 == false) goto L28;
        r0.setSlideable(false);
    L32:
        return r4;
    L28:
        if (r3 == this.A) goto L32;
        if (Arrays.asList(new Integer[]{1, 3}).contains(Integer.valueOf(r11)) == false) goto L32;
        r0.setSlideable(this.A);
        goto L32
    L5:
        if (r0.b == false) goto L7;
        r3 = true;
        goto L8
    }

    public final void e(boolean r4) {
        this.v = true;
        this.s = false;
        this.D = r4;
        setVisibility(0);
        this.h.setVisibility(8);
        if (r4 == false) goto L5;
        a();
        return;
    L5:
        this.d.setVisibility(0);
        this.i.setVisibility(0);
        this.a.setVisibility(0);
        this.e.setVisibility(0);
        this.f.setVisibility(0);
        this.j.setVisibility(0);
        this.k.setVisibility(0);
        if (this.B == false) goto L8;
        setBackground(null);
    L9:
        c();
        return;
    L8:
        setBackgroundDrawable(getResources().getDrawable(2131234029));
        goto L9
    }

    public final void g(boolean r3) {
        tt5.a.h("ProgressBar", "switchTitle: " + r3);
        this.x.getBlockTitleViewVisibility().postValue(Boolean.valueOf(r3));
    }

    public final void i(boolean r3) {
        FrameLayout.LayoutParams r0 = (FrameLayout.LayoutParams) this.l.getLayoutParams();
        if (r3 == false) goto L5;
        int r1 = 1;
    L6:
        r0.gravity = r1;
        if (r3 == false) goto L9;
        int r4 = 0;
    L10:
        r0.setMarginStart(r4);
        this.l.setLayoutParams(r0);
        return;
    L9:
        r4 = getResources().getDimensionPixelSize(2131166332);
        goto L10
    L5:
        r1 = 8388611;
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        int r4 = r3.getId();
        if (r4 != 2131387199) goto L6;
        setPlayState(true);
        this.y = false;
        g(true);
        return;
    L6:
        if (r4 != 2131381971) goto L10;
        setPlayState(false);
        return;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar r1) {
        this.s = true;
        c();
        b r2 = this.r;
        if (r2 == null) goto L6;
        r2.a();
        return;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar r4) {
        this.s = false;
        c();
        b r0 = this.r;
        if (r0 == null) goto L6;
        r0.i(r4.getProgress());
        this.r.b();
    L6:
        if (r4.getProgress() <= this.u) goto L10;
        PreviewViewModel r1 = this.t;
        if (r1 == null) goto L13;
        r1.liveInnerReportMsg().a(new a0(4));
    L13:
        this.u = r4.getProgress();
        return;
    L10:
        PreviewViewModel r2 = this.t;
        if (r2 == null) goto L13;
        r2.liveInnerReportMsg().a(new a0(5));
        goto L13
    }

    public void setMaxLength(int r2) {
        this.o = r2;
        this.d.setMax(r2);
        String r3 = zu5.b.d(r2);
        this.f.setText(r3);
    }

    public void setMaxLengthTextColor(int r3) {
        this.O = r3;
        this.f.setTextColor(getResources().getColor(r3));
    }

    public void setPauseBtnBg(int r2) {
        this.L = r2;
        this.N = null;
        this.c.setImageResource(r2);
    }

    public void setPauseBtnDrawable(Drawable r2) {
        this.N = r2;
        this.c.setImageDrawable(r2);
    }

    public void setPlayState(boolean r2) {
        boolean r0 = this.p;
        if (r2 != r0) goto L5;
        return;
    L5:
        if (r2 == r0) goto L8;
        this.p = r2;
        b();
    L8:
        a r1 = this.q;
        if (r1 == null) goto L12;
        r1.d(r2);
        return;
    }

    public void setPlayStateChangedListener(a r1) {
        this.q = r1;
    }

    public void setPlayerState(int r3) {
        boolean r1 = true;
        if (r3 != 5) goto L6;
        this.y = true;
    L6:
        if (r3 == 4) goto L10;
        r1 = false;
    L10:
        if (r1 == this.p) goto L13;
        this.p = r1;
        b();
    L13:
        a r4 = this.q;
        if (r4 == null) goto L17;
        r4.e(r1);
        return;
    }

    public void setProgress(int r2) {
        if (r2 >= 0) goto L4;
        return;
    L4:
        if (r2 <= this.o) goto L6;
        return;
    L6:
        if (this.s == true) goto L12;
        setProgressInternal(r2);
        return;
    }

    public void setProgressBg(int r4) {
        this.I = r4;
        this.d.setProgressDrawable(getResources().getDrawable(r4, null));
    }

    public void setProgressSeekedListener(b r1) {
        this.r = r1;
    }

    public void setProgressTextColor(int r3) {
        this.P = r3;
        this.e.setTextColor(getResources().getColor(r3));
    }

    public void setResolution(String r2) {
        this.F = r2;
        this.h.setText(r2);
    }

    public void setResolutionClickListener(View.OnClickListener r2) {
        this.G = r2;
        this.h.setOnClickListener(r2);
    }

    public void setResolutionTextColor(int r3) {
        this.Q = r3;
        this.h.setTextColor(getResources().getColor(r3));
    }

    public void setResolutionVisible(boolean r2) {
        this.g = r2;
        TextView r0 = this.h;
        if (r2 == true) goto L5;
    L13:
        int r3 = 8;
    L14:
        r0.setVisibility(r3);
        return;
    L5:
        if (this.v == true) goto L13;
        if (this.B == true) goto L9;
    L12:
        r3 = 0;
        goto L14
    L9:
        if (this.s == true) goto L13;
        if (this.C == true) goto L13;
        goto L12
    }

    public void setSilent(boolean r2) {
        this.E = r2;
        this.i.setSilent(r2);
    }

    public void setStartBtnBg(int r2) {
        this.K = r2;
        this.M = null;
        this.b.setImageResource(r2);
    }

    public void setStartBtnDrawable(Drawable r2) {
        this.M = r2;
        this.b.setImageDrawable(r2);
    }

    public void setThumbBg(int r4) {
        this.J = r4;
        this.d.setThumb(getResources().getDrawable(r4, null));
    }

    public void setVideoControlBarClearScreen(boolean r3) {
        if (this.B == true) goto L5;
        return;
    L5:
        if (this.C == r3) goto L10;
        this.C = r3;
        c();
        tt5.a.h("ProgressBar", "setVideoControlBarClearScreen, clearScreen=" + r3 + ", isSeeking=" + this.s + ", isBlock=" + this.v);
        return;
    }

    public void setVideoControlBarV2Enabled(boolean r5) {
        if (r5 == true) goto L5;
        return;
    L5:
        if (this.B == false) goto L18;
        return;
    L18:
        this.B = true;     // Catch: Throwable -> L11
        d(2131560226);     // Catch: Throwable -> L11
        this.d.setThumb(null);     // Catch: Throwable -> L11
        ViewGroup r6 = this.m;     // Catch: Throwable -> L11
        if (r6 != null) goto L13;
        tt5.a.k("ProgressBar", "install v2 seek touch forwarder failed, missing touch area");     // Catch: Throwable -> L11
    L14:
        setBackground(null);     // Catch: Throwable -> L11
        c();     // Catch: Throwable -> L11
        tt5.a.h("ProgressBar", "setVideoControlBarV2Enabled success, v2Enabled=true, isBlock=" + this.v);     // Catch: Throwable -> L11
        return;
    L13:
        r6.setOnTouchListener(new l(this));     // Catch: Throwable -> L11
        tt5.a.h("ProgressBar", "install v2 seek touch forwarder success");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        tt5.a.e("ProgressBar", "setVideoControlBarV2Enabled failed, use legacy", th, false);
        this.B = false;
        d(2131560225);
        setBackgroundResource(2131234029);
    }

    public void setViewModel(ViewOwner r2) {
        this.t = (PreviewViewModel) r2.viewModel(PreviewViewModel.class);
        this.w = (DriveMediaVM) r2.viewModel(DriveMediaVM.class);
        this.x = (DriveBlockPreviewVM) r2.viewModel(DriveBlockPreviewVM.class);
    }

    public void setVolumeStateChangedListener(VolumeView.a r2) {
        this.H = r2;
        this.i.setVolumeStateChangedListener(r2);
    }

    public void setWholeBackgroundColor(int r2) {
        setBackgroundColor(getResources().getColor(r2));
    }

    public ProgressBar(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.n = 0;
        this.o = 0;
        this.p = false;
        this.s = false;
        this.u = -1;
        this.y = true;
        d(2131560225);
    }

    public final void h(int r4, int r5) {
        this.d.setProgressDrawable(getResources().getDrawable(r5, null));
        int r6 = getResources().getDimensionPixelSize(r4);
        int r7 = Math.max(0, Math.round(getResources().getDimensionPixelSize(2131166334) - (r6 / 2.0f)));
        FrameLayout.LayoutParams r0 = (FrameLayout.LayoutParams) this.d.getLayoutParams();
        if (r0.height == r6) goto L5;
    L7:
        r0.height = r6;
        r0.bottomMargin = r7;
        this.d.setLayoutParams(r0);
        return;
    L5:
        if (r0.bottomMargin != r7) goto L7;
    }

    public ProgressBar(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.n = 0;
        this.o = 0;
        this.p = false;
        this.s = false;
        this.u = -1;
        this.y = true;
        d(2131560225);
    }

    public final void j(int r4, int r5, Typeface r6) {
        float r7 = getResources().getDimension(r4);
        TextView r0 = (TextView) this.j;
        this.e.setTextSize(0, r7);
        r0.setTextSize(0, r7);
        this.f.setTextSize(0, r7);
        this.e.setTypeface(r6);
        r0.setTypeface(r6);
        this.f.setTypeface(r6);
        this.e.setTextColor(getResources().getColor(2131106521));
        r0.setTextColor(getResources().getColor(r5));
        this.f.setTextColor(getResources().getColor(r5));
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar r1, int r2, boolean r3) {
        setProgressInternal(r2);
    }
}
