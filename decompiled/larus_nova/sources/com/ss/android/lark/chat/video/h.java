package com.ss.android.lark.chat.video;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.transition.TransitionManager;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes35.dex */
public final class h extends v0c.a implements y0c.b, com.ss.android.lark.player.player.o {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Image f416793e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewGroup f416794f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f416795g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f416796h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f416797i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f416798j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f416799k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f416800l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ImageView f416801m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TextView f416802n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public SeekBar f416803o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextView f416804p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ObjectAnimator f416805q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ObjectAnimator f416806r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f416807s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f416808t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f416809u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View.OnClickListener f416810v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public f f416811w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final a f416812x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final b f416813y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final c f416814z;

    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f416815a;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            super.handleMessage(r100);
            if (r100.what != 101) goto L7;
            this.f416815a.s(false);
            return;
        }

        public a(h r100, Looper r101) {
            this.f416815a = r100;
            super(r101);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f416816a;

        @Override // java.lang.Runnable
        public final void run() {
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L14;
            throw th;
        L14:
            return;
        L3:
            if (this.f416816a.f416808t < 0) goto L10;
            Bundle r100 = w0c.a.a();     // Catch: Throwable -> L7
            r100.putInt("int_data", this.f416816a.f416808t);     // Catch: Throwable -> L7
            this.f416816a.j(-66005, r100);     // Catch: Throwable -> L7
            return;
        }

        public b(h r100) {
            this.f416816a = r100;
        }
    }

    public class c implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f416817a;

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStartTrackingTouch(SeekBar r100) {
        }

        public c(h r100) {
            this.f416817a = r100;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStopTrackingTouch(SeekBar r100) {
            h r101 = this.f416817a;
            int r102 = r100.getProgress();
            r101.f416809u = false;
            r101.f416808t = r102;
            r101.f416812x.removeCallbacks(r101.f416813y);
            r101.f416812x.postDelayed(r101.f416813y, 300);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onProgressChanged(SeekBar r100, int r101, boolean r102) {
            if (r102 == false) goto L5;
            this.f416817a.u(r101, r100.getMax());
            return;
        }
    }

    public class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f416818a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f416819b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            super.onAnimationEnd(r100);
            if (this.f416818a == true) goto L6;
            this.f416819b.f416797i.setVisibility(8);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            super.onAnimationStart(r100);
            if (this.f416818a == false) goto L6;
            this.f416819b.f416797i.setVisibility(0);
            return;
        }

        public d(h r100, boolean r101) {
            this.f416819b = r100;
            this.f416818a = r101;
        }
    }

    public class e extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f416820a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f416821b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            super.onAnimationEnd(r100);
            if (this.f416820a == true) goto L6;
            this.f416821b.f416800l.setVisibility(8);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            super.onAnimationStart(r100);
            if (this.f416820a == false) goto L6;
            this.f416821b.f416800l.setVisibility(0);
            return;
        }

        public e(h r100, boolean r101) {
            this.f416821b = r100;
            this.f416820a = r101;
        }
    }

    public interface f {
        void onPlay();
    }

    @Override // y0c.b
    public final /* synthetic */ void f() {
    }

    @Override // y0c.b
    public final void onDoubleTap(MotionEvent r100) {
    }

    @Override // y0c.b
    public final void onDown(MotionEvent r100) {
    }

    @Override // y0c.b
    public final void onLongPress(MotionEvent r100) {
    }

    @Override // y0c.b
    public final /* synthetic */ void onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
    }

    @Override // v0c.o
    public final void g() {
        n();
        this.f416795g = this.f416794f.findViewById(R.id.play_label);
        this.f416796h = (ImageView) this.f416794f.findViewById(R.id.video_cover);
        this.f416797i = this.f416794f.findViewById(R.id.controller_top_layout);
        this.f416799k = this.f416794f.findViewById(R.id.ctrl_close);
        this.f416800l = this.f416794f.findViewById(R.id.controller_bottom_layout);
        this.f416801m = (ImageView) this.f416794f.findViewById(R.id.video_operator);
        this.f416802n = (TextView) this.f416794f.findViewById(R.id.current_play_time);
        this.f416804p = (TextView) this.f416794f.findViewById(R.id.video_duration);
        this.f416803o = (SeekBar) this.f416794f.findViewById(R.id.video_seek);
        View r100 = this.f416794f.findViewById(R.id.video_menu);
        this.f416798j = r100;
        r100.setVisibility(8);
        this.f416801m.setSelected(true);
        this.f416802n.setText(com.larksuite.framework.utils.e.f(0));
        this.f416804p.setText(com.larksuite.framework.utils.e.f(0));
        UIUtils.display(this.f416797i, false);
        UIUtils.display(this.f416800l, false);
        this.f416798j.setOnClickListener(new i(this));
        j r101 = new j(this);
        this.f416801m.setOnClickListener(r101);
        this.f416795g.setOnClickListener(r101);
        this.f416799k.setOnClickListener(new k(this));
        this.f416803o.setOnSeekBarChangeListener(this.f416814z);
        this.f416800l.setOnTouchListener(new l(this));
        if (this.f416793e == null) goto L6;
        ImageLoader.with(getContext()).load(new EncryptImage(this.f416793e.getKey())).error(R.drawable.__picker_ic_broken_image_black_48dp).into(this.f416796h);
        return;
    }

    @Override // v0c.b, v0c.o
    public final void d(int r100) {
        switch(r100) {
            case -66018: goto L6;
            case -66017: goto L5;
            default: goto L9;
        };
    L5:
        s(false);
        UIUtils.display(this.f416795g, false);
        return;
    L6:
        q(0);
        s(true);
        return;
    }

    @Override // v0c.a
    public final View m(Context r100) {
        ViewGroup r101 = (ViewGroup) LayoutInflater.from(r100).inflate(R.layout.online_controller_cover, null);
        this.f416794f = r101;
        return r101;
    }

    @Override // y0c.b
    public final void onSingleTapUp(MotionEvent r100) {
        if (this.f416800l.getVisibility() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        s(false);
        return;
    L8:
        s(true);
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void r(boolean r100) {
        this.f416800l.clearAnimation();
        ObjectAnimator r101 = this.f416805q;
        if (r101 == null) goto L5;
        r101.cancel();
        this.f416805q.removeAllListeners();
        this.f416805q.removeAllUpdateListeners();
    L5:
        View r102 = this.f416800l;
        float[] r103 = new float[2];
        float r104 = 1.0f;
        if (r100 == false) goto L8;
        float r105 = 0.0f;
    L9:
        r103[0] = r105;
        if (r100 == true) goto L13;
        r104 = 0.0f;
    L13:
        r103[1] = r104;
        ObjectAnimator r106 = ObjectAnimator.ofFloat(r102, "alpha", r103).setDuration(300);
        this.f416805q = r106;
        r106.addListener(new e(this, r100));
        this.f416805q.start();
        if (r100 == false) goto L16;
        n();
        return;
    L16:
        j(-66016, null);
        return;
    L8:
        r105 = 1.0f;
        goto L9
    }

    public final void s(boolean r100) {
        if (r100 == false) goto L5;
        this.f416812x.removeMessages(101);
        this.f416812x.sendEmptyMessageDelayed(101, 5000);
    L6:
        t(r100);
        r(r100);
        return;
    L5:
        this.f416812x.removeMessages(101);
        goto L6
    }

    public final void t(boolean r100) {
        this.f416797i.clearAnimation();
        ObjectAnimator r101 = this.f416806r;
        if (r101 == null) goto L5;
        r101.cancel();
        this.f416806r.removeAllListeners();
        this.f416806r.removeAllUpdateListeners();
    L5:
        View r102 = this.f416797i;
        float[] r103 = new float[2];
        float r104 = 0.0f;
        if (r100 == false) goto L8;
        float r105 = 0.0f;
    L9:
        r103[0] = r105;
        if (r100 == false) goto L12;
        r104 = 1.0f;
    L12:
        r103[1] = r104;
        ObjectAnimator r106 = ObjectAnimator.ofFloat(r102, "alpha", r103).setDuration(300);
        this.f416806r = r106;
        r106.addListener(new d(this, r100));
        this.f416806r.start();
        return;
    L8:
        r105 = 1.0f;
        goto L9
    }

    public h(FragmentActivity r100, Image r101) {
        super(r100);
        this.f416808t = -1;
        this.f416809u = true;
        this.f416812x = new a(this, Looper.getMainLooper());
        this.f416813y = new b(this);
        this.f416814z = new c(this);
        this.f416793e = r101;
    }

    @Override // v0c.b, v0c.o
    public final void a(int r100, Bundle r101) {
        switch(r100) {
            case -99031: goto L10;
            case -99016: goto L9;
            case -99015: goto L8;
            case -99014: goto L7;
            case -99010: goto L6;
            case -99004: goto L5;
            default: goto L24;
        };
    L5:
        t(false);
        r(false);
        return;
    L6:
        UIUtils.display(this.f416795g, false);
        return;
    L7:
        this.f416809u = true;
        return;
    L8:
        TransitionManager.beginDelayedTransition(this.f416794f);
        this.f416796h.setVisibility(8);
        TransitionManager.endTransitions(this.f416794f);
        this.f416809u = true;
        return;
    L9:
        int r102 = this.f416803o.getMax();
        p();
        s(true);
        u(0, this.f416803o.getMax());
        this.f416801m.setSelected(true);
        UIUtils.display(this.f416795g, true);
        UIUtils.display(this.f416796h, true);
        u(r102, r102);
        return;
    L10:
        int r103 = r101.getInt("int_data");
        if (r103 != 4) goto L14;
        this.f416801m.setSelected(true);
        return;
    L14:
        if (r103 != 3) goto L23;
        this.f416801m.setSelected(false);
        UIUtils.display(this.f416795g, false);
        return;
    L23:
        return;
    }

    @Override // v0c.b, v0c.o
    public final void h(int r100, Bundle r101) {
        Log.e("play video eventCode: " + r100);
        UIUtils.display(this.f416797i, false);
        UIUtils.display(this.f416800l, false);
    }

    public final void u(int r100, int r101) {
        this.f416803o.setMax(r101);
        this.f416803o.setProgress(r100);
        this.f416803o.setSecondaryProgress((int) (((this.f416807s * 1.0f) / 100.0f) * r101));
        this.f416802n.setText(com.larksuite.framework.utils.e.f(r100));
        this.f416804p.setText(com.larksuite.framework.utils.e.f(r101));
    }

    @Override // com.ss.android.lark.player.player.o
    public final void e(int r100, int r101, int r102) {
        if (this.f416809u == true) goto L5;
        return;
    L5:
        this.f416807s = r102;
        u(r100, r101);
    }
}
