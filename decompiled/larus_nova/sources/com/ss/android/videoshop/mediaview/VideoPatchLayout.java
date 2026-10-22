package com.ss.android.videoshop.mediaview;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.PixelCopy;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import cjc.f;
import cjc.g;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.videoshop.log.VideoTraceState;
import com.ss.android.videoshop.log.VideoTracer;
import com.ss.android.videoshop.log.tracer.LogTracer;
import com.ss.android.videoshop.log.tracer.PathID;
import com.ss.ttm.player.PlaybackParams;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineInfos;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.model.VideoRef;
import com.ss.ttvideoengine.net.TTVNetClient;
import com.ss.ttvideoengine.utils.Error;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.functions.Function1;
import nic.e;
import nic.j;
import nic.k;
import nic.l;
import nic.p;

/* JADX INFO: loaded from: classes40.dex */
public class VideoPatchLayout extends FrameLayout implements com.ss.android.videoshop.mediaview.a.InterfaceC5459a, l, k {
    public boolean A;
    public boolean B;
    public f C;
    public final b D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f456039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public cjc.c f456040b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.ss.android.videoshop.mediaview.a f456041c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f456042d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f456043e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public tic.a f456044f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ejc.b f456045g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f456046h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public e f456047i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public qic.a f456048j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public qic.c f456049k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public fjc.b f456050l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f456051m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f456052n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public j f456053o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ejc.a f456054p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public nic.f f456055q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List<l> f456056r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Lifecycle f456057s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public TTVNetClient f456058t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public nic.c f456059u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f456060v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f456061w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f456062x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public PlaybackParams f456063y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f456064z;

    public class a implements PixelCopy.OnPixelCopyFinishedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ cjc.d f456065a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Bitmap f456066b;

        @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
        public final void onPixelCopyFinished(int r100) {
            cjc.d r101 = this.f456065a;
            if (r101 == null) goto L6;
            r101.a(this.f456066b);
            return;
        }

        public a(cjc.d r100, Bitmap r101) {
            this.f456065a = r100;
            this.f456066b = r101;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoPatchLayout f456067a;

        @Override // java.lang.Runnable
        public final void run() {
            VideoPatchLayout r100 = this.f456067a;     // Catch: Throwable -> L11
            int r101 = r100.f456046h;     // Catch: Throwable -> L11
            if (r101 != 0) goto L5;
        L8:
            r100.f456048j.setSurface(r100.getSurface());     // Catch: Throwable -> L11
        L9:
            this.f456067a.t();     // Catch: Throwable -> L11
            return;
        L5:
            if (r101 == 2) goto L8;
            r100.f456048j.setSurfaceHolder(r100.getSurfaceHolder());     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L15;
            return;
        L15:
            throw th;
        }

        public b(VideoPatchLayout r100) {
            this.f456067a = r100;
        }
    }

    public interface c {
    }

    public e A(Context r100) {
        return null;
    }

    @Override // nic.b
    public final void S(boolean r100, int r101) {
    }

    @Override // nic.b
    public final boolean c(p r100, tic.a r101, boolean r102, int r103) {
        return false;
    }

    public boolean interceptPlayWhenVideoInfoReady(VideoRef r100) {
        return false;
    }

    public void k0() {
        this.f456062x = false;
        qic.a r100 = this.f456048j;
        if (r100 == null) goto L5;
        r100.release();
    L5:
        this.f456050l.a();
    }

    public final void E() {
        com.ss.android.videoshop.mediaview.a r100 = this.f456041c;
        if (r100 != null) goto L5;
        g r101 = this.f456039a;
        r101.f24000a = this.f456046h;
        Context r102 = getContext();
        if (r101.f24000a != 0) goto L15;
        cjc.c r103 = new TextureContainerLayout(r102);
    L16:
        this.f456040b = r103;
        setTextureLayout(this.f456045g.f472905g);
        cjc.c r104 = this.f456040b;
        if ((r104 instanceof TextureContainerLayout) == false) goto L19;
        ((TextureContainerLayout) r104).setBackgroundColor(this.f456045g.f472904f);
    L19:
        com.ss.android.videoshop.mediaview.a r105 = this.f456040b.getVideoView();
        this.f456041c = r105;
        r105.setSurfaceCallback(this);
        View r106 = this.f456040b.getBlackCoverView();
        this.f456042d = r106;
        if (this.f456060v == true) goto L22;
        r106.setVisibility(8);
    L22:
        FrameLayout.LayoutParams r107 = new FrameLayout.LayoutParams(-1, -1);
        r107.gravity = 17;
        addView(this.f456040b.getVideoContainer(), 0, r107);
        UIUtils.setViewVisibility(this.f456040b.getVideoContainer(), 8);
        return;
    L15:
        r103 = new SurfaceContainerLayout(r102);
        goto L16
    L5:
        if (this.f456054p != null) goto L7;
        this.f456054p = new cjc.e();
    L7:
        boolean r108 = r100 instanceof SurfaceView;
        this.f456054p.getClass();
        if (r108 == false) goto L24;
        setUseSurfaceView(false);
        return;
    }

    public final boolean V() {
        qic.a r100 = this.f456048j;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isPlaying() == false) goto L7;
        return true;
    }

    public final boolean Z() {
        qic.a r100 = this.f456048j;
        if (r100 != null) goto L5;
    L8:
        return true;
    L5:
        if (r100.isReleased() == true) goto L8;
        return false;
    }

    public final boolean a0() {
        int r100 = this.f456046h;
        if (r100 != 1) goto L5;
        return true;
    L5:
        if (r100 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    public final void d0() {
        StringBuilder r100 = new StringBuilder("onSurfaceChanged setSurface vid:");
        r100.append(this.f456044f.f546363a);
        r100.append(" title:nullhash:");
        this.f456044f.getClass();
        r100.append(this.f456048j.hashCode());
        r100.append(" VideoViewType = ");
        r100.append(this.f456046h);
        ajc.b.a("VideoPatchLayout", r100.toString());
        qic.a r101 = this.f456048j;
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.f456046h != 2) goto L9;
        r101.setSurface(getSurface());
        return;
    }

    public final void f0() {
        if (this.f456048j != null) goto L5;
    L20:
        VideoTracer.INS.trace(this.f456044f, VideoTraceState.SURFACE_AVAILABLE, "VideoViewType = " + this.f456046h, null, getVideoStateInquirer());
        return;
    L5:
        if (this.f456044f == null) goto L7;
        StringBuilder r100 = new StringBuilder("onSurfaceCreated setSurface vid:");
        r100.append(this.f456044f.f546363a);
        r100.append(" title:nullhash:");
        this.f456044f.getClass();
        r100.append(this.f456048j.hashCode());
        r100.append(" VideoViewType = ");
        r100.append(this.f456046h);
        ajc.b.a("VideoPatchLayout", r100.toString());
    L7:
        this.f456045g.getClass();
        int r101 = this.f456046h;
        if (r101 != 0) goto L10;
    L11:
        this.f456048j.setSurface(getSurface());
    L13:
        if (this.f456046h == 1) goto L15;
    L19:
        this.f456050l.b();
        goto L20
    L15:
        if (this.f456048j.isPrepared() == false) goto L19;
        if (this.f456048j.r() == true) goto L19;
        this.f456048j.setSurfaceHolder(getSurfaceHolder());
        goto L19
    L10:
        if (r101 != 2) goto L13;
        goto L11
    }

    public final void g0() {
        StringBuilder r100 = new StringBuilder("onSurfaceDestroyed setSurface vid:");
        r100.append(this.f456044f.f546363a);
        r100.append(" title:nullhash:");
        this.f456044f.getClass();
        r100.append(this.f456048j.hashCode());
        r100.append(" VideoViewType = ");
        r100.append(this.f456046h);
        ajc.b.a("VideoPatchLayout", r100.toString());
        qic.a r101 = this.f456048j;
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.f456046h != 2) goto L9;
        r101.setSurface(null);
        return;
    }

    public int getCurrentPosition() {
        boolean r100 = this.f456051m;
        qic.a r101 = this.f456048j;
        if (r101 != null) goto L6;
        return 0;
    L6:
        return r101.p(r100);
    }

    public int getDuration() {
        qic.a r100 = this.f456048j;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.getDuration();
    }

    public PlaybackParams getPlayBackParams() {
        qic.a r100 = this.f456048j;
        if (r100 == null) goto L6;
        return r100.a();
    L6:
        return this.f456063y;
    }

    public Surface getSurface() {
        com.ss.android.videoshop.mediaview.a r100 = this.f456041c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getSurface();
    }

    public SurfaceHolder getSurfaceHolder() {
        com.ss.android.videoshop.mediaview.a r100 = this.f456041c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getSurfaceHolder();
    }

    public int getTextureLayout() {
        return this.f456040b.getTextureLayout();
    }

    public RectF getTextureRealRectF() {
        if (this.f456046h == 0) goto L5;
        cjc.c r100 = this.f456040b;
        if (r100 != null) goto L11;
        return null;
    L11:
        return ((SurfaceContainerLayout) r100).getViewRect();
    L5:
        if (this.f456041c != null) goto L7;
        return null;
    L7:
        return new RectF(((TextureVideoView) this.f456041c).getViewRect());
    }

    public float getTextureScaleX() {
        if (this.f456046h != 0) goto L8;
        com.ss.android.videoshop.mediaview.a r100 = this.f456041c;
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100.getView().getScaleX();
    L8:
        cjc.c r101 = this.f456040b;
        if (r101 != null) goto L11;
        return 0.0f;
    L11:
        return r101.getVideoContainer().getScaleX();
    }

    public float getTextureScaleY() {
        if (this.f456046h != 0) goto L8;
        com.ss.android.videoshop.mediaview.a r100 = this.f456041c;
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100.getView().getScaleY();
    L8:
        cjc.c r101 = this.f456040b;
        if (r101 != null) goto L11;
        return 0.0f;
    L11:
        return r101.getVideoContainer().getScaleY();
    }

    public int getTextureViewHeight() {
        if (this.f456046h != 0) goto L8;
        com.ss.android.videoshop.mediaview.a r100 = this.f456041c;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getHeight();
    L8:
        cjc.c r101 = this.f456040b;
        if (r101 != null) goto L11;
        return 0;
    L11:
        return r101.getVideoContainer().getHeight();
    }

    public int getTextureViewWidth() {
        if (this.f456046h != 0) goto L8;
        com.ss.android.videoshop.mediaview.a r100 = this.f456041c;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getWidth();
    L8:
        cjc.c r101 = this.f456040b;
        if (r101 != null) goto L11;
        return 0;
    L11:
        return r101.getVideoContainer().getWidth();
    }

    public TTVideoEngine getVideoEngine() {
        qic.a r100 = this.f456048j;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f();
    }

    public Bitmap getVideoFrame() {
        com.ss.android.videoshop.mediaview.a r100 = this.f456041c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getBitmap();
    }

    public p getVideoStateInquirer() {
        qic.a r100 = this.f456048j;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getVideoStateInquirer();
    }

    public int getVideoViewMarginTop() {
        cjc.c r100 = this.f456040b;
        if (r100 != null) goto L5;
        return -1;
    L5:
        return r100.getVideoViewMarginTop();
    }

    public int getWatchedDuration() {
        qic.a r100 = this.f456048j;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.getWatchedDuration();
    }

    public void h0() {
        ajc.b.a("VideoPatchLayout", "pause");
        this.f456062x = false;
        this.f456050l.a();
        qic.a r100 = this.f456048j;
        if (r100 == null) goto L6;
        r100.pause();
        return;
    }

    public void i0() {
        if (this.f456044f != null) goto L6;
        ajc.b.b("VideoPatchLayout", "playEntity can't be null when play");
        return;
    L6:
        this.f456062x = true;
        E();
        l0();
        j0();
    }

    public void l0() {
        qic.a r100 = this.f456048j;
        if (r100 != null) goto L5;
        e r101 = this.f456047i;
        this.f456049k.getClass();
        qic.b r102 = new qic.b(r101);
        this.f456048j = r102;
        r102.f533229e = this.f456046h;
        return;
    L5:
        tic.a r103 = r100.g();
        if (r103 != null) goto L8;
        return;
    L8:
        if (r103.equals(this.f456044f) == true) goto L23;
        fjc.d.b(r103, "play_next");
        this.f456048j.release();
        if (a0() == true) goto L12;
        return;
    L12:
        if (this.f456048j.v() == false) goto L14;
        return;
    L14:
        if (UIUtils.isViewVisible(this.f456041c.getView()) == false) goto L26;
        com.ss.android.videoshop.mediaview.a r104 = this.f456041c;
        if (r104 != null) goto L18;
        return;
    L18:
        if (UIUtils.isViewVisible(r104.getView()) == false) goto L28;
        UIUtils.setViewVisibility(this.f456041c.getView(), 8);
        return;
    L28:
        return;
    L26:
        return;
    }

    public final void r() {
        ajc.b.a("VideoPatchLayout", "dismiss surface capture view mVideoViewContainer = " + this.f456040b);
        this.f456040b.c();
    }

    public final void t() {
        VideoTracer.INS.trace(this.f456044f, VideoTraceState.VIDEO_PATCH_DO_PLAY, null, null, getVideoStateInquirer());
        this.f456048j.play();
        if (this.f456062x == true) goto L6;
        h0();
        return;
    }

    public final void j0() {
        Activity r100 = fjc.d.a(getContext());
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L10;
    L12:
        VideoTracer.INS.trace(this.f456044f, VideoTraceState.VIDEO_PATCH_PLAY_INTERNAL, null, null, getVideoStateInquirer());
        ejc.b r102 = this.f456045g;
        if (r102 != null) goto L15;
    L18:
        nic.f r103 = this.f456055q;
        if (r103 == null) goto L21;
        this.f456048j.m(r103);
    L21:
        TTVNetClient r104 = this.f456058t;
        if (r104 == null) goto L24;
        this.f456048j.A(r104);
    L24:
        this.f456048j.o(this.f456061w);
        this.f456048j.setLoop(this.f456045g.f472903e);
        this.f456048j.q(this);
        this.f456048j.setRenderMode(this.f456045g.f472906h);
        this.f456048j.setPlayEntity(this.f456044f);
        this.f456048j.setPlaybackParams(this.f456063y);
        this.f456048j.l(this);
        this.f456048j.n(this.f456059u);
        this.f456048j.i(this.f456051m);
        this.f456048j.x(this.f456052n);
        this.f456048j.j(this.B);
        this.f456048j.t(this.f456045g.f472900b);
        com.ss.android.videoshop.mediaview.a r105 = this.f456041c;
        if (r105 == null) goto L28;
        r105.setPlayEntity(this.f456044f);
    L28:
        if ((!TextUtils.isEmpty(this.f456044f.f546369g)) == false) goto L31;
        UIUtils.setViewVisibility(this.f456041c.getView(), 8);
        t();
        return;
    L31:
        if (a0() == false) goto L33;
        setBackgroundColor(-16777216);
    L33:
        UIUtils.setViewVisibility(this, 0);
        f r106 = this.C;
        if (r106 == null) goto L36;
        r106.removeMessages(0);
    L36:
        UIUtils.setViewVisibility(this.f456041c.getView(), 0);
        UIUtils.setViewVisibility(this.f456040b.getVideoContainer(), 0);
        r();
        this.f456045g.getClass();
        if (this.A == false) goto L39;
        b r107 = this.D;
        if (r107 == null) goto L63;
        Surface r108 = getSurface();
        if (r108 != null) goto L53;
    L55:
        fjc.b r109 = this.f456050l;
        if (r109.f477548a != null) goto L58;
        r109.f477548a = new ArrayList();
    L58:
        ((ArrayList) r109.f477548a).add(r107);
        return;
    L53:
        if (r108.isValid() == false) goto L55;
        r107.run();
        return;
    L63:
        return;
    L39:
        if (a0() == false) goto L41;
        this.f456048j.setSurfaceHolder(getSurfaceHolder());
    L46:
        t();
        return;
    L41:
        Surface r110 = getSurface();
        if (r110 == null) goto L46;
        if (r110.isValid() == false) goto L46;
        this.f456048j.setSurface(getSurface());
        goto L46
    L15:
        if (this.f456046h != 0) goto L17;
        ((TextureVideoView) this.f456041c).setReuseSurfaceTexture(r102.f472899a);
    L17:
        setMute(this.f456045g.f472902d);
        this.A = this.f456045g.f472911m;
        goto L18
    L10:
        if (this.f456043e == true) goto L12;
        return;
    L5:
        if (r100.isFinishing() == false) goto L7;
        r101 = true;
        goto L8
    }

    public Lifecycle getObservedLifecycle() {
        return this.f456057s;
    }

    public tic.a getPlayEntity() {
        return this.f456044f;
    }

    public ejc.b getPlaySettings() {
        return this.f456045g;
    }

    public cjc.c getTextureContainer() {
        return this.f456040b;
    }

    public e getVideoContext() {
        return this.f456047i;
    }

    public j getVideoPlayConfiger() {
        return this.f456053o;
    }

    public long getVideoStopTimeStamp() {
        return this.f456064z;
    }

    public int getVideoViewType() {
        return this.f456046h;
    }

    public VideoPatchLayout(Context r100) {
        super(r100);
        this.f456039a = new g();
        this.f456043e = false;
        this.f456045g = ejc.b.a();
        this.f456046h = 0;
        this.f456056r = new CopyOnWriteArrayList();
        this.f456060v = true;
        this.f456062x = true;
        this.A = true;
        this.B = false;
        this.D = new b(this);
        H(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void C(cjc.d r100) {
        com.ss.android.videoshop.mediaview.a r101 = this.f456041c;
        if (r101 != 0) goto L7;
        r100.a(null);
        return;
    L7:
        if ((r101 instanceof SurfaceView) == true) goto L9;
        r100.a(((TextureView) r101).getBitmap());
        return;
    L9:
        if (Build.VERSION.SDK_INT >= 24) goto L11;
        if (r100 == null) goto L31;
        r100.a(this.f456048j.h());
        return;
    L31:
        return;
    L11:
        if (r101.getSurface() != null) goto L13;
    L21:
        if (r100 == null) goto L28;
        r100.a(null);
        return;
    L28:
        return;
    L13:
        if (this.f456041c.getSurface().isValid() == false) goto L21;
        if (this.f456041c.getView().getWidth() > 0) goto L18;
    L20:
        r100.a(null);
        return;
    L18:
        if (this.f456041c.getView().getWidth() <= 0) goto L20;
        Bitmap r102 = Bitmap.createBitmap(this.f456041c.getWidth(), this.f456041c.getWidth(), Bitmap.Config.ARGB_8888);
        PixelCopy.request(this.f456041c.getSurface(), r102, new a(r100, r102), getHandler());
    }

    public void H(Context r100) {
        this.f456050l = new fjc.b();
        this.f456047i = A(r100);
        this.f456049k = new qic.c();
        ComponentCallbacks2 r101 = fjc.d.a(r100);
        if ((r101 instanceof LifecycleOwner) == false) goto L6;
        this.f456057s = ((LifecycleOwner) r101).getLifecycle();
        return;
    }

    @Override // nic.h
    public final void N(VideoInfo r100) {
        LogTracer.INS.addTrace(this.f456044f, bjc.b.b("OnUpdateVideoSize", PathID.PLAY, 6));
        int r101 = r100.getValueInt(1);
        int r102 = r100.getValueInt(2);
        ajc.b.a("VideoPatchLayout", "onUpdateVideoSize width:" + r101 + " height:" + r102);
        this.f456040b.setVideoSize(r101, r102);
    }

    public boolean interceptPlay(NetworkUtils.NetworkType r100) {
        j r101 = this.f456053o;
        if (r101 != null) goto L5;
        return false;
    L5:
        return r101.interceptPlay(r100);
    }

    public final void m0(VideoInfo r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.getResolution() == Resolution.Auto) goto L8;
        LogTracer.INS.addTrace(this.f456044f, bjc.b.b("UpdateVideoSize", PathID.PLAY, 6));
        int r101 = r100.getValueInt(1);
        int r102 = r100.getValueInt(2);
        ajc.b.a("VideoPatchLayout", "selectVideoInfoToPlay width:" + r101 + " height:" + r102);
        this.f456040b.setVideoSize(r101, r102);
        return;
    }

    @Override // nic.j
    public final VideoInfo selectVideoInfoToPlay(VideoModel r100) {
        LogTracer.INS.addTrace(this.f456044f, bjc.b.b("SelectVideoInfoToPlay", PathID.PLAY, 6));
        if (r100 == null) goto L5;
        VideoRef r101 = r100.getVideoRef();
    L6:
        j r102 = this.f456053o;
        if (r102 == null) goto L9;
        VideoInfo r103 = r102.selectVideoInfoToPlay(r100);
    L10:
        m0(r103);
        return r103;
    L9:
        int r104 = Resolution.Standard.getIndex();
        r103 = fjc.c.b(r101).get(r104);
        goto L10
    L5:
        r101 = null;
        goto L6
    }

    public void setAsyncPosition(boolean r100) {
        this.f456051m = r100;
        qic.a r101 = this.f456048j;
        if (r101 == null) goto L6;
        r101.i(r100);
        return;
    }

    public void setAsyncRelease(boolean r100) {
        this.f456052n = r100;
        qic.a r101 = this.f456048j;
        if (r101 == null) goto L6;
        r101.x(r100);
        return;
    }

    public void setLoop(boolean r100) {
        this.f456045g.f472903e = r100;
        qic.a r101 = this.f456048j;
        if (r101 == null) goto L6;
        r101.setLoop(r100);
        return;
    }

    public void setMute(boolean r100) {
        this.f456045g.f472902d = r100;
        qic.a r101 = this.f456048j;
        if (r101 == null) goto L6;
        r101.setMute(r100);
        return;
    }

    public void setOptimizeBlackSide(boolean r100) {
        cjc.c r101 = this.f456040b;
        if (r101 == null) goto L6;
        r101.setOptimizeBlackSide(r100);
        return;
    }

    public void setOptimizeNormalFillScreen(boolean r100) {
        cjc.c r101 = this.f456040b;
        if (r101 == null) goto L6;
        r101.setOptimizeNormalFillScreen(r100);
        return;
    }

    public void setPlayBackParams(PlaybackParams r100) {
        this.f456063y = r100;
        qic.a r101 = this.f456048j;
        if (r101 == null) goto L6;
        r101.setPlaybackParams(r100);
        return;
    }

    public void setPlayEntity(tic.a r100) {
        this.f456044f = r100;
        if (r100 == null) goto L5;
        this.f456045g = r100.f546377o;
    L5:
        this.f456062x = false;
    }

    public void setPlayNeedSurfaceValid(boolean r100) {
        this.A = r100;
    }

    public void setPlayUrlConstructor(nic.c r100) {
        this.f456059u = r100;
        qic.a r101 = this.f456048j;
        if (r101 == null) goto L6;
        r101.n(r100);
        return;
    }

    public void setReleaseEngineEnabled(boolean r100) {
        if (this.f456048j != null) goto L5;
        e r101 = this.f456047i;
        this.f456049k.getClass();
        qic.b r102 = new qic.b(r101);
        this.f456048j = r102;
        r102.f533229e = this.f456046h;
    L5:
        this.f456048j.w(r100);
    }

    public void setRenderMode(int r100) {
        this.f456045g.f472906h = r100;
        qic.a r101 = this.f456048j;
        if (r101 == null) goto L6;
        r101.setRenderMode(r100);
        return;
    }

    public void setStartTime(int r100) {
        qic.a r101 = this.f456048j;
        if (r101 == null) goto L6;
        r101.setStartTime(r100);
        return;
    }

    public void setSurfaceViewConfiger(ejc.a r100) {
        this.f456054p = r100;
    }

    public void setTextureCropStrategy(gjc.a r100) {
        cjc.c r101 = this.f456040b;
        if (r101 == null) goto L6;
        r101.setCropStrategy(r100);
        return;
    }

    public void setTextureLayout(int r100) {
        ejc.b r101 = this.f456045g;
        if (r101 == null) goto L5;
        r101.f472905g = r100;
    L5:
        cjc.c r102 = this.f456040b;
        if (r102 == null) goto L9;
        r102.a(r100);
        return;
    }

    public void setTryToInterceptPlay(boolean r100) {
        this.f456061w = r100;
        qic.a r101 = this.f456048j;
        if (r101 == null) goto L6;
        r101.o(r100);
        return;
    }

    public void setTtvNetClient(TTVNetClient r100) {
        this.f456058t = r100;
        qic.a r101 = this.f456048j;
        if (r101 == null) goto L6;
        r101.A(r100);
        return;
    }

    public void setUseBlackCover(boolean r100) {
        this.f456060v = r100;
        if (r100 == true) goto L6;
        UIUtils.setViewVisibility(this.f456042d, 8);
        return;
    }

    public void setUseSurfaceView(boolean r100) {
        if (r100 == true) goto L4;
        this.f456046h = 0;
    L8:
        qic.a r101 = this.f456048j;
        if (r101 == null) goto L12;
        r101.s(this.f456046h);
        return;
    L12:
        return;
    L4:
        if (Build.VERSION.SDK_INT >= 24) goto L6;
        this.f456046h = 2;
        goto L8
    L6:
        this.f456046h = 1;
        goto L8
    }

    public void setVideoContext(Function1<Context, e> r100) {
        if (r100 == null) goto L5;
        this.f456047i = r100.invoke(getContext());
        return;
    }

    public void setVideoEngine(TTVideoEngine r100) {
        if (this.f456048j != null) goto L5;
        e r101 = this.f456047i;
        this.f456049k.getClass();
        qic.b r102 = new qic.b(r101);
        this.f456048j = r102;
        r102.f533229e = this.f456046h;
    L5:
        this.f456048j.e(r100);
    }

    public void setVideoEngineFactory(nic.f r100) {
        this.f456055q = r100;
    }

    public void setVideoMethodOpt(boolean r100) {
        this.B = r100;
    }

    public void setVideoPlayConfiger(j r100) {
        this.f456053o = r100;
        qic.a r101 = this.f456048j;
        if (r101 == null) goto L6;
        r101.l(this);
        return;
    }

    public void setVideoViewType(int r100) {
        this.f456046h = r100;
    }

    public void setZoomingEnabled(boolean r100) {
        cjc.c r101 = this.f456040b;
        if (r101 == null) goto L6;
        r101.setZoomingEnabled(r100);
        return;
    }

    @Override // nic.j
    public final VideoInfo selectVideoInfoToPlay(VideoRef r100) {
        j r101 = this.f456053o;
        if (r101 == null) goto L5;
        VideoInfo r102 = r101.selectVideoInfoToPlay(r100);
    L6:
        m0(r102);
        return r102;
    L5:
        int r103 = Resolution.Standard.getIndex();
        r102 = fjc.c.b(r100).get(r103);
        goto L6
    }

    public void setVideoContext(e r100) {
        this.f456047i = r100;
    }

    public VideoPatchLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f456039a = new g();
        this.f456043e = false;
        this.f456045g = ejc.b.a();
        this.f456046h = 0;
        this.f456056r = new CopyOnWriteArrayList();
        this.f456060v = true;
        this.f456062x = true;
        this.A = true;
        this.B = false;
        this.D = new b(this);
        H(r100);
    }

    public void B(p r100, tic.a r101) {
        UIUtils.setViewVisibility(this.f456042d, 8);
        Iterator r102 = ((CopyOnWriteArrayList) this.f456056r).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((l) r102.next()).B(r100, r101);
        goto L4
    }

    public void D(oic.f r100, tic.a r101) {
        Iterator r102 = ((CopyOnWriteArrayList) this.f456056r).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((l) r102.next()).D(r100, r101);
        goto L4
    }

    public void G(oic.f r100, tic.a r101) {
        this.f456063y = null;
        com.ss.android.videoshop.mediaview.a r102 = this.f456041c;
        if (r102 == null) goto L5;
        r102.setPlayEntity(null);
    L5:
        Iterator r103 = ((CopyOnWriteArrayList) this.f456056r).iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        ((l) r103.next()).G(r100, r101);
        goto L7
    }

    public void I(oic.f r100, tic.a r101) {
        Iterator r102 = ((CopyOnWriteArrayList) this.f456056r).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((l) r102.next()).I(r100, r101);
        goto L4
    }

    public void L(oic.f r100, tic.a r101) {
        Iterator r102 = ((CopyOnWriteArrayList) this.f456056r).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((l) r102.next()).L(r100, r101);
        goto L4
    }

    public void W(oic.f r100, tic.a r101) {
        Iterator r102 = ((CopyOnWriteArrayList) this.f456056r).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((l) r102.next()).W(r100, r101);
        goto L4
    }

    public void Y(oic.f r100, tic.a r101) {
        Iterator r102 = ((CopyOnWriteArrayList) this.f456056r).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((l) r102.next()).Y(r100, r101);
        goto L4
    }

    public void b(oic.f r100, tic.a r101) {
        Iterator r102 = ((CopyOnWriteArrayList) this.f456056r).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((l) r102.next()).b(r100, r101);
        goto L4
    }

    public void e0(oic.f r100, tic.a r101) {
        LogTracer.INS.addTrace(this.f456044f, bjc.b.b("OnEngineInitPlay", PathID.PLAY, 6));
        if (this.f456060v == false) goto L5;
        UIUtils.setViewVisibility(this.f456042d, 0);
    L5:
        Iterator r102 = ((CopyOnWriteArrayList) this.f456056r).iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        ((l) r102.next()).e0(r100, r101);
        goto L7
    }

    public void h(oic.f r100, tic.a r101) {
        LogTracer.INS.addTrace(this.f456044f, bjc.b.b("OnVideoReplay", PathID.PLAY, 6));
        Iterator r102 = ((CopyOnWriteArrayList) this.f456056r).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((l) r102.next()).h(r100, r101);
        goto L4
    }

    public void o(oic.f r100, tic.a r101) {
        if (this.f456060v == false) goto L5;
        UIUtils.setViewVisibility(this.f456042d, 0);
    L5:
        Iterator r102 = ((CopyOnWriteArrayList) this.f456056r).iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        ((l) r102.next()).o(r100, r101);
        goto L7
    }

    public void p(oic.f r100, tic.a r101) {
        Iterator r102 = ((CopyOnWriteArrayList) this.f456056r).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((l) r102.next()).p(r100, r101);
        goto L4
    }

    public void s(oic.f r100, tic.a r101) {
        Iterator r102 = ((CopyOnWriteArrayList) this.f456056r).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((l) r102.next()).s(r100, r101);
        goto L4
    }

    public void u(oic.f r100, tic.a r101) {
        Iterator r102 = ((CopyOnWriteArrayList) this.f456056r).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((l) r102.next()).u(r100, r101);
        goto L4
    }

    public void y(oic.f r100, tic.a r101) {
        LogTracer.INS.addTrace(this.f456044f, bjc.b.b("OnVideoRetry", PathID.PLAY, 6));
        Iterator r102 = ((CopyOnWriteArrayList) this.f456056r).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((l) r102.next()).y(r100, r101);
        goto L4
    }

    public void z(oic.f r100, tic.a r101) {
        Iterator r102 = ((CopyOnWriteArrayList) this.f456056r).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((l) r102.next()).z(r100, r101);
        goto L4
    }

    public VideoPatchLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f456039a = new g();
        this.f456043e = false;
        this.f456045g = ejc.b.a();
        this.f456046h = 0;
        this.f456056r = new CopyOnWriteArrayList();
        this.f456060v = true;
        this.f456062x = true;
        this.A = true;
        this.B = false;
        this.D = new b(this);
        H(r100);
    }

    public void F(oic.f r100, tic.a r101, int r102) {
        Iterator r103 = ((CopyOnWriteArrayList) this.f456056r).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((l) r103.next()).F(r100, r101, r102);
        goto L4
    }

    public void J(oic.f r100, tic.a r101, int r102) {
        if (r102 != 0) goto L4;
    L5:
        this.f456064z = System.currentTimeMillis();
    L6:
        Iterator r103 = ((CopyOnWriteArrayList) this.f456056r).iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        ((l) r103.next()).J(r100, r101, r102);
        goto L8
    L10:
        return;
    L4:
        if (r102 != 2) goto L6;
        goto L5
    }

    public void K(oic.f r100, tic.a r101, int r102) {
        Iterator r103 = ((CopyOnWriteArrayList) this.f456056r).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((l) r103.next()).K(r100, r101, r102);
        goto L4
    }

    public void Q(oic.f r100, tic.a r101, int r102) {
        Iterator r103 = ((CopyOnWriteArrayList) this.f456056r).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((l) r103.next()).Q(r100, r101, r102);
        goto L4
    }

    public void R(oic.f r100, tic.a r101, boolean r102) {
        Iterator r103 = ((CopyOnWriteArrayList) this.f456056r).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((l) r103.next()).x(r100, r101, r102);
        goto L4
    }

    public void c0(oic.f r100, tic.a r101, long r102) {
        Iterator r103 = ((CopyOnWriteArrayList) this.f456056r).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((l) r103.next()).c0(r100, r101, r102);
        goto L4
    }

    public void d(oic.f r100, tic.a r101, boolean r102) {
        Iterator r103 = ((CopyOnWriteArrayList) this.f456056r).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((l) r103.next()).d(r100, r101, r102);
        goto L4
    }

    public VideoInfo e(oic.f r100, VideoModel r101, tic.a r102) {
        if ((this.f456053o instanceof k) == false) goto L6;
        LogTracer.INS.addTrace(r102, bjc.b.b("SelectVideoInfoToPlayV2", PathID.PLAY, 6));
        VideoInfo r103 = ((k) this.f456053o).e(r100, r101, r102);
        m0(r103);
        return r103;
    L6:
        return null;
    }

    public void f(oic.f r100, tic.a r101, int r102) {
        LogTracer.INS.addTrace(this.f456044f, bjc.b.b("OnEnginePlayStart", PathID.PLAY, 6));
        Iterator r103 = ((CopyOnWriteArrayList) this.f456056r).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((l) r103.next()).f(r100, r101, r102);
        goto L4
    }

    public void g(oic.f r100, tic.a r101, String r102) {
        Iterator r103 = ((CopyOnWriteArrayList) this.f456056r).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((l) r103.next()).g(r100, r101, r102);
        goto L4
    }

    public void i(oic.f r100, tic.a r101, VideoEngineInfos r102) {
        Iterator r103 = ((CopyOnWriteArrayList) this.f456056r).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((l) r103.next()).i(r100, r101, r102);
        goto L4
    }

    public void j(oic.f r100, tic.a r101, int r102) {
        Iterator r103 = ((CopyOnWriteArrayList) this.f456056r).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((l) r103.next()).j(r100, r101, r102);
        goto L4
    }

    public void k(oic.f r100, tic.a r101, int r102) {
        Iterator r103 = ((CopyOnWriteArrayList) this.f456056r).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((l) r103.next()).k(r100, r101, r102);
        goto L4
    }

    public void v(oic.f r100, tic.a r101, Error r102) {
        Iterator r103 = ((CopyOnWriteArrayList) this.f456056r).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((l) r103.next()).v(r100, r101, r102);
        goto L4
    }

    public void w(oic.f r100, tic.a r101, long r102) {
        Iterator r103 = ((CopyOnWriteArrayList) this.f456056r).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((l) r103.next()).w(r100, r101, r102);
        goto L4
    }

    public void x(oic.f r100, tic.a r101, boolean r102) {
        Iterator r103 = ((CopyOnWriteArrayList) this.f456056r).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((l) r103.next()).x(r100, r101, r102);
        goto L4
    }

    public void M(oic.f r100, tic.a r101, String r102, Error r103) {
        Iterator r104 = ((CopyOnWriteArrayList) this.f456056r).iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((l) r104.next()).M(r100, r101, r102, r103);
        goto L4
    }

    public void P(oic.f r100, tic.a r101, int r102, int r103) {
        Iterator r104 = ((CopyOnWriteArrayList) this.f456056r).iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((l) r104.next()).P(r100, r101, r102, r103);
        goto L4
    }

    public void T(oic.f r100, tic.a r101, int r102, String r103) {
        Iterator r104 = ((CopyOnWriteArrayList) this.f456056r).iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((l) r104.next()).T(r100, r101, r102, r103);
        goto L4
    }

    public void U(oic.f r100, tic.a r101, Resolution r102, int r103) {
        Iterator r104 = ((CopyOnWriteArrayList) this.f456056r).iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((l) r104.next()).U(r100, r101, r102, r103);
        goto L4
    }

    public void b0(oic.f r100, tic.a r101, int r102, Map r103) {
        Iterator r104 = ((CopyOnWriteArrayList) this.f456056r).iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((l) r104.next()).b0(r100, r101, r102, r103);
        goto L4
    }

    public void l(oic.f r100, tic.a r101, Resolution r102, boolean r103) {
        Iterator r104 = ((CopyOnWriteArrayList) this.f456056r).iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((l) r104.next()).l(r100, r101, r102, r103);
        goto L4
    }

    public void m(oic.f r100, tic.a r101, int r102, int r103) {
        if ((this.f456040b.getVideoWidth() * this.f456040b.getVideoHeight()) != 0) goto L5;
        this.f456040b.setVideoSize(r102, r103);
    L5:
        Iterator r104 = ((CopyOnWriteArrayList) this.f456056r).iterator();
    L7:
        if (r104.hasNext() == false) goto L9;
        ((l) r104.next()).m(r100, r101, r102, r103);
        goto L7
    }

    @Override // nic.k
    public final void n(VideoInfo r100, oic.f r101, VideoModel r102, tic.a r103) {
        if ((this.f456053o instanceof k) == false) goto L6;
        LogTracer.INS.addTrace(r103, bjc.b.b("OnVideoInfoSelected", PathID.PLAY, 3));
        ((k) this.f456053o).n(r100, r101, r102, r103);
        return;
    }

    public void q(oic.f r100, tic.a r101, int r102, int r103) {
        Iterator r104 = ((CopyOnWriteArrayList) this.f456056r).iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((l) r104.next()).q(r100, r101, r102, r103);
        goto L4
    }

    public void O(p r110, tic.a r111, boolean r112, int r113, boolean r114, boolean r115) {
        Iterator r100 = ((CopyOnWriteArrayList) this.f456056r).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((l) r100.next()).O(r110, r111, r112, r113, r114, r115);
        goto L4
    }

    public void X(p r110, tic.a r111, e r112, boolean r113, int r114, boolean r115, boolean r116) {
        Iterator r100 = ((CopyOnWriteArrayList) this.f456056r).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((l) r100.next()).X(r110, r111, r112, r113, r114, r115, r116);
        goto L4
    }
}
