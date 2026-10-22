package com.ss.android.videoshop.mediaview;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.videoshop.context.VideoContext;
import com.ss.android.videoshop.log.tracer.LogTracer;
import com.ss.android.videoshop.log.tracer.PathID;
import com.ss.ttm.player.PlaybackParams;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.net.TTVNetClient;
import nic.f;
import nic.j;
import nic.l;
import nic.p;
import zic.e;

/* JADX INFO: loaded from: classes40.dex */
public class SimpleMediaView extends RelativeLayout {

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final /* synthetic */ int f455989J = 0;
    public PlaybackParams A;
    public boolean B;
    public boolean C;
    public boolean D;
    public float E;
    public boolean F;
    public boolean G;
    public boolean H;
    public final a I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public tic.a f455990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ejc.b f455991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LayerHostMediaLayout f455992c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f455993d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public VideoContext f455994e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f455995f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public nic.a f455996g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f455997h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Lifecycle f455998i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public j f455999j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ejc.a f456000k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TTVNetClient f456001l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public nic.c f456002m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ViewTreeObserver f456003n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public f f456004o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f456005p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f456006q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f456007r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f456008s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Rect f456009t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f456010u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f456011v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f456012w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f456013x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f456014y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public b f456015z;

    public class a implements ViewTreeObserver.OnScrollChangedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SimpleMediaView f456016a;

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            SimpleMediaView r100 = this.f456016a;
            int r101 = SimpleMediaView.f455989J;
            r100.getClass();
            boolean r102 = false;
            if (r100.isShown() == true) goto L5;
            boolean r103 = false;
        L6:
            SimpleMediaView r104 = this.f456016a;
            VideoContext r105 = r104.f455994e;
            if (r105 != null) goto L9;
            return;
        L9:
            if (r105.f455947a.f555367f != 0) goto L11;
            r102 = true;
        L11:
            if (r102 == true) goto L13;
            return;
        L13:
            if (r104.f455996g != null) goto L15;
            return;
        L15:
            if (r105.r0(r104) == true) goto L17;
            return;
        L17:
            if (r105.q0(this.f456016a.f455990a) == false) goto L24;
            SimpleMediaView r106 = this.f456016a;
            r106.f455996g.a(r106, r103);
            ajc.b.c("SimpleMediaView", "onScrollVisibilityChange simpleMediaView hash:" + this.f456016a.hashCode() + " nowVisible:" + r103);
            return;
        L24:
            return;
        L5:
            r100.f456009t.setEmpty();
            r103 = r100.getGlobalVisibleRect(r100.f456009t);
            goto L6
        }

        public a(SimpleMediaView r100) {
            this.f456016a = r100;
        }
    }

    public static class b extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f456017a;

        public b() {
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            r101.setRoundRect(0, 0, r100.getWidth(), r100.getHeight(), Math.min((Math.min(r100.getWidth(), r100.getHeight()) / 2) + 1, this.f456017a));
        }
    }

    public e getLayerEventListener() {
        return null;
    }

    public final void b() {
        boolean r100 = true;
        if (this.f455993d == true) goto L5;
        StringBuilder r101 = new StringBuilder(">>>>>>> detachView called hash:");
        r101.append(hashCode());
        r101.append(" vid:");
        tic.a r102 = this.f455990a;
        if (r102 == null) goto L44;
        String r103 = r102.f546363a;
    L45:
        r101.append(r103);
        ajc.b.c("SimpleMediaView", r101.toString());
        VideoContext r104 = this.f455994e;
        if (r104 == null) goto L68;
        boolean r105 = this.f455995f;
        if (r105 == false) goto L68;
        if (r105 == false) goto L68;
        int r106 = r104.f455947a.f555367f;
        if (r106 != 0) goto L53;
        boolean r107 = true;
    L54:
        if (r107 == true) goto L61;
        if (r106 == 3) goto L59;
        r100 = false;
    L59:
        if (r100 == false) goto L68;
    L61:
        if (r104.r0(this) == false) goto L65;
        if (r104.q0(getPlayEntity()) == false) goto L65;
    L66:
        ajc.b.c("VideoContext", "send 200 MSG_DISPATCH_DETACH simpleMediaView:" + hashCode());
        r104.f455959m.sendMessage(r104.f455959m.obtainMessage(100, this));
    L65:
        if (i() == false) goto L66;
        r104.f455959m.sendMessage(r104.f455959m.obtainMessage(102, this));
        goto L68
    L53:
        r107 = false;
    L68:
        ajc.b.c("SimpleMediaView", "<<<<<<<< detachView end hash:" + hashCode());
        return;
    L44:
        r103 = "null";
        goto L45
    L5:
        if (this.f455995f == false) goto L40;
        VideoContext r108 = this.f455994e;
        if (r108 == null) goto L40;
        Lifecycle r109 = getObservedLifecycle();
        LayerHostMediaLayout r110 = r108.f455949c;
        if (r110 == null) goto L11;
        Lifecycle r111 = r110.getObservedLifecycle();
    L12:
        if (r109 != r111) goto L40;
        SimpleMediaView r112 = r108.f455950d;
        if (r112 == null) goto L18;
        if (r112.f455995f == false) goto L40;
    L18:
        if (r108.q0(getPlayEntity()) == false) goto L33;
        if (r108.f455950d == this) goto L31;
        LayerHostMediaLayout r113 = r108.f455949c;
        if (r113 == null) goto L31;
        ViewParent r114 = r113.getParent();
        if ((r114 instanceof SimpleMediaView) == false) goto L31;
        SimpleMediaView r115 = (SimpleMediaView) r114;
        if (r115.f455992c == null) goto L28;
        r115.removeAllViews();
        r115.f455992c.setParentView(null);
        r115.f455992c = null;
    L28:
        a(r108.f455949c);
        ajc.b.c("VideoContext", "updateSimpleMediaView change simplemediaview");
        if (r108.v0() == true) goto L31;
        UIUtils.setViewVisibility(this, 0);
    L31:
        r108.f455950d = this;
        ajc.b.c("VideoContext", "updateSimpleMediaView hash:" + Integer.valueOf(hashCode()));
        r108.f455959m.removeCallbacksAndMessages(null);
        r108.f455959m.sendMessage(r108.f455959m.obtainMessage(101, this));
        ajc.b.c("VideoContext", "send MSG_DISPATCH_ATTACH simpleMediaView:" + hashCode());
        goto L40
    L33:
        if (r108.f455947a.f555367f == 0) goto L36;
        r100 = false;
    L36:
        if (r100 == false) goto L40;
        if (r108.r0(this) == false) goto L40;
        ajc.b.c("VideoContext", "send 0 MSG_DISPATCH_DETACH simpleMediaView:" + hashCode());
        r108.f455959m.sendMessage(r108.f455959m.obtainMessage(100, this));
        goto L40
    L11:
        r111 = null;
    L40:
        ajc.b.c("SimpleMediaView", "attachView simplemediaview hash:" + hashCode() + " scrollVisible:" + this.f455997h);
    }

    public final void c() {
        LayerHostMediaLayout r100 = this.f455992c;
        if (r100 == null) goto L7;
        VideoContext r101 = r100.M;
        if (r101 == null) goto L13;
        r101.l0();
        return;
    L13:
        return;
    L7:
        VideoContext r102 = this.f455994e;
        if (r102 != null) goto L10;
        return;
    L10:
        if (r102.r0(this) == false) goto L16;
        this.f455994e.l0();
        return;
    }

    public final boolean f() {
        VideoContext r100 = this.f455994e;
        if (r100 != null) goto L5;
    L9:
        return false;
    L5:
        if (r100.r0(this) == false) goto L9;
        if (this.f455994e.s0() == false) goto L9;
        return true;
    }

    public final boolean g() {
        LayerHostMediaLayout r100 = this.f455992c;
        if (r100 == null) goto L10;
        qic.a r101 = r100.f456048j;
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r101.isPaused() == false) goto L18;
        return true;
    L18:
        return false;
    L10:
        VideoContext r102 = this.f455994e;
        if (r102 != null) goto L13;
    L16:
        return false;
    L13:
        if (r102.r0(this) == false) goto L16;
        return this.f455994e.t0();
    }

    public int getCurrentPosition() {
        boolean r100 = this.B;
        LayerHostMediaLayout r101 = this.f455992c;
        if (r101 == null) goto L8;
        qic.a r102 = r101.f456048j;
        if (r102 != null) goto L20;
        return 0;
    L20:
        return r102.p(r100);
    L8:
        VideoContext r103 = this.f455994e;
        if (r103 != null) goto L11;
        return 0;
    L11:
        if (r103.r0(this) == false) goto L22;
        LayerHostMediaLayout r104 = this.f455994e.f455949c;
        if (r104 == null) goto L24;
        qic.a r105 = r104.f456048j;
        if (r105 != null) goto L19;
        return 0;
    L19:
        return r105.p(r100);
    L24:
        return 0;
    L22:
        return 0;
    }

    public int getDuration() {
        LayerHostMediaLayout r100 = this.f455992c;
        if (r100 != null) goto L5;
        VideoContext r101 = this.f455994e;
        if (r101 != null) goto L9;
        return 0;
    L9:
        if (r101.r0(this) == false) goto L16;
        LayerHostMediaLayout r102 = this.f455994e.f455949c;
        if (r102 != null) goto L14;
        return 0;
    L14:
        return r102.getDuration();
    L16:
        return 0;
    L5:
        return r100.getDuration();
    }

    public LayerHostMediaLayout getLayerHostMediaLayout() {
        LayerHostMediaLayout r100 = this.f455992c;
        if (r100 == null) goto L5;
        return r100;
    L5:
        VideoContext r101 = this.f455994e;
        if (r101 != null) goto L8;
        return null;
    L8:
        if (r101.r0(this) == true) goto L10;
        return null;
    L10:
        return this.f455994e.f455949c;
    }

    public PlaybackParams getPlayBackParams() {
        LayerHostMediaLayout r100 = this.f455992c;
        if (r100 != null) goto L5;
        VideoContext r101 = this.f455994e;
        if (r101 == null) goto L16;
        if (r101.r0(this) == false) goto L16;
        LayerHostMediaLayout r102 = this.f455994e.f455949c;
        if (r102 != null) goto L17;
        return null;
    L17:
        return r102.getPlayBackParams();
    L16:
        return this.A;
    L5:
        return r100.getPlayBackParams();
    }

    public TTVideoEngine getVideoEngine() {
        LayerHostMediaLayout r100 = this.f455992c;
        if (r100 != null) goto L5;
        VideoContext r101 = this.f455994e;
        if (r101 != null) goto L9;
        return null;
    L9:
        if (r101.r0(this) == true) goto L11;
        return null;
    L11:
        return this.f455994e.o0();
    L5:
        return r100.getVideoEngine();
    }

    public Bitmap getVideoFrame() {
        LayerHostMediaLayout r100 = this.f455992c;
        if (r100 != null) goto L5;
        VideoContext r101 = this.f455994e;
        if (r101 != null) goto L9;
        return null;
    L9:
        if (r101.r0(this) == false) goto L15;
        LayerHostMediaLayout r102 = this.f455994e.f455949c;
        if (r102 != null) goto L13;
        return null;
    L13:
        return r102.getVideoFrame();
    L15:
        return null;
    L5:
        return r100.getVideoFrame();
    }

    public p getVideoStateInquirer() {
        LayerHostMediaLayout r100 = this.f455992c;
        if (r100 != null) goto L5;
        VideoContext r101 = this.f455994e;
        if (r101 != null) goto L9;
        return null;
    L9:
        if (r101.r0(this) == true) goto L11;
        return null;
    L11:
        return this.f455994e.p0();
    L5:
        return r100.getVideoStateInquirer();
    }

    public int getVideoViewMarginTop() {
        LayerHostMediaLayout r100 = this.f455992c;
        if (r100 != null) goto L5;
        return -1;
    L5:
        return r100.getVideoViewMarginTop();
    }

    public int getWatchedDuration() {
        LayerHostMediaLayout r100 = this.f455992c;
        if (r100 != null) goto L5;
        VideoContext r101 = this.f455994e;
        if (r101 != null) goto L9;
        return 0;
    L9:
        if (r101.r0(this) == false) goto L16;
        LayerHostMediaLayout r102 = this.f455994e.f455949c;
        if (r102 != null) goto L14;
        return 0;
    L14:
        return r102.getWatchedDuration();
    L16:
        return 0;
    L5:
        return r100.getWatchedDuration();
    }

    public final boolean h() {
        LayerHostMediaLayout r100 = this.f455992c;
        if (r100 != null) goto L5;
        VideoContext r101 = this.f455994e;
        if (r101 != null) goto L9;
        return false;
    L9:
        if (r101.r0(this) == true) goto L11;
        return false;
    L11:
        return this.f455994e.isPlaying();
    L5:
        return r100.V();
    }

    public final boolean i() {
        LayerHostMediaLayout r100 = this.f455992c;
        if (r100 != null) goto L5;
        VideoContext r101 = this.f455994e;
        if (r101 != null) goto L9;
        return true;
    L9:
        if (r101.r0(this) == true) goto L11;
        return true;
    L11:
        return this.f455994e.v0();
    L5:
        return r100.Z();
    }

    public final void j() {
        LayerHostMediaLayout r100 = this.f455992c;
        if (r100 == null) goto L5;
        r100.h0();
        return;
    L5:
        VideoContext r101 = this.f455994e;
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.r0(this) == false) goto L13;
        this.f455994e.pause();
        return;
    }

    public final void k() {
        if (this.f455990a != null) goto L7;
        ajc.b.b("SimpleMediaView", "setPlayEntity first before play");
        return;
    L7:
        if (this.f455992c == null) goto L9;
        l();
        return;
    L9:
        VideoContext r100 = this.f455994e;
        if (r100 != null) goto L12;
    L16:
        e(getContext());
        l();
        return;
    L12:
        if (r100.r0(this) == false) goto L16;
        LayerHostMediaLayout r101 = this.f455994e.f455949c;
        if (r101 == null) goto L19;
        r101.setPlayEntity(this.f455990a);
        this.f455994e.play();
        return;
    }

    public final void l() {
        VideoContext r100 = this.f455994e;
        if (r100 == null) goto L5;
        r100.I0(this);
    L5:
        this.f455992c.setPlayEntity(this.f455990a);
        LayerHostMediaLayout r101 = this.f455992c;
        Lifecycle r102 = this.f455998i;
        if (r102 == null) goto L8;
        r101.f456057s = r102;
    L9:
        j r103 = this.f455999j;
        if (r103 == null) goto L12;
        this.f455992c.setVideoPlayConfiger(r103);
    L12:
        ejc.a r104 = this.f456000k;
        if (r104 == null) goto L15;
        this.f455992c.setSurfaceViewConfiger(r104);
    L15:
        this.f455992c.setUseActiveLayers(this.F);
        this.f455992c.setDeactiveLayerWhenRelease(this.G);
        this.f455992c.setVideoMethodOpt(this.H);
        this.f455992c.setUseBlackCover(this.f456005p);
        this.f455992c.setHideHostWhenRelease(this.f456006q);
        this.f455992c.setVideoEngineFactory(this.f456004o);
        this.f455992c.setPlayUrlConstructor(this.f456002m);
        this.f455992c.setTtvNetClient(this.f456001l);
        this.f455992c.setTryToInterceptPlay(this.f456007r);
        this.f455992c.setPlayBackParams(this.A);
        this.f455992c.setAsyncPosition(this.B);
        this.f455992c.setAsyncRelease(this.C);
        this.f455992c.setLayerEventListener(null);
        this.f455992c.setCanPlayBackground(this.f456008s);
        this.f455992c.i0();
        return;
    L8:
        r101.getClass();
        goto L9
    }

    public final void m() {
        LayerHostMediaLayout r100 = this.f455992c;
        if (r100 != null) goto L5;
    L7:
        VideoContext r101 = this.f455994e;
        if (r101 != null) goto L10;
        return;
    L10:
        if (r101.r0(this) == false) goto L17;
        LayerHostMediaLayout r102 = this.f455994e.f455949c;
        if (r102 == null) goto L18;
        r102.k0();
        return;
    L18:
        return;
    L17:
        return;
    L5:
        if (r100.getParent() != this) goto L7;
        this.f455992c.k0();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ajc.b.c("SimpleMediaView", "onAttachedToWindow hash:" + hashCode() + " class:" + getClass().getSimpleName());
        ViewParent r100 = getParent();
    L3:
        boolean r101 = false;
        if (r100 == null) goto L9;
        if ((r100 instanceof AbsListView) == true) goto L7;
        r100 = r100.getParent();
        goto L3
    L7:
        boolean r102 = true;
    L10:
        if (r102 == true) goto L21;
        ViewParent r103 = getParent();
    L12:
        if (r103 == null) goto L19;
        if ((r103 instanceof RecyclerView) == true) goto L15;
        r103 = r103.getParent();     // Catch: Throwable -> L18
    L15:
        boolean r104 = true;
    L20:
        if (r104 == true) goto L21;
    L22:
        this.f455995f = r101;
        this.f455993d = true;
        b();
        LayerHostMediaLayout r105 = this.f455992c;
        if (r105 == null) goto L33;
        tic.a r106 = this.f455990a;
        if (r106 == null) goto L33;
        if (r106.equals(r105.f456044f) == false) goto L33;
        if (this.f455992c.f456044f == this.f455990a) goto L33;
        if (i() == true) goto L33;
        this.f455990a = this.f455992c.f456044f;
    L33:
        ViewTreeObserver r107 = getViewTreeObserver();
        this.f456003n = r107;
        r107.addOnScrollChangedListener(this.I);
        return;
    L19:
        r104 = false;
    L21:
        r101 = true;
        goto L22
    L9:
        r102 = false;
        goto L10
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ajc.b.c("SimpleMediaView", "onDetachedFromWindow hash:" + hashCode() + " class:" + getClass().getSimpleName());
        this.f455993d = false;
        b();
        ViewTreeObserver r100 = this.f456003n;
        if (r100 != null) goto L5;
    L7:
        ViewTreeObserver r101 = getViewTreeObserver();
        if (r101 == null) goto L12;
        r101.removeOnScrollChangedListener(this.I);
        return;
    L12:
        return;
    L5:
        if (r100.isAlive() == false) goto L7;
        this.f456003n.removeOnScrollChangedListener(this.I);
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        ajc.b.c("SimpleMediaView", "onFinishTemporaryDetach hash:" + hashCode() + " class:" + getClass().getSimpleName());
        this.f455993d = true;
        b();
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        ajc.b.c("SimpleMediaView", "onStartTemporaryDetach hash:" + hashCode() + " class:" + getClass().getSimpleName());
        this.f455993d = false;
        b();
    }

    public nic.a getAttachListener() {
        return this.f455996g;
    }

    public Lifecycle getObservedLifecycle() {
        return this.f455998i;
    }

    public tic.a getPlayEntity() {
        return this.f455990a;
    }

    public float getRadius() {
        return this.f456012w;
    }

    public j getVideoPlayConfiger() {
        return this.f455999j;
    }

    public SimpleMediaView(Context r100) {
        this(r100, null);
    }

    public final void a(LayerHostMediaLayout r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.f455992c == null) goto L7;
        removeAllViews();
        this.f455992c.setParentView(null);
        this.f455992c = null;
    L7:
        if (r100.getParent() == null) goto L33;
        ViewParent r101 = r100.getParent();
        if ((r101 instanceof ViewGroup) == false) goto L33;
        ((ViewGroup) r101).removeView(r100);     // Catch: Exception -> L30
    L33:
        boolean r102 = r100.getParent() instanceof ViewGroup;     // Catch: Exception -> L15
    L17:
        this.f455992c = r100;
        PlaybackParams r103 = r100.f456063y;
        if (r103 == this.A) goto L20;
        this.A = r103;
    L20:
        this.F = r100.getUseActiveLayers();
        this.G = r100.getDeactiveLayerWhenRelease();
        r100.getLayerEventListener();
        this.f455998i = r100.getObservedLifecycle();
        addView(r100, new ViewGroup.LayoutParams(-1, -1));     // Catch: Exception -> L23
        this.f455992c.setParentView(this);
        return;
    L23:
        e = move-exception;
        StringBuilder r104 = new StringBuilder("removeAgain:false\n");
        ViewParent r105 = r100.getParent();
    L25:
        if (r105 == null) goto L28;
        r104.append(r105.toString());
        r104.append("\n");
        r105 = r105.getParent();
        goto L25
    L28:
        throw new RuntimeException(r104.toString(), e);
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    public final void d(cjc.d r100) {
        LayerHostMediaLayout r101 = this.f455992c;
        if (r101 == null) goto L5;
        r101.C(r100);
        return;
    L5:
        VideoContext r102 = this.f455994e;
        if (r102 != null) goto L8;
    L13:
        r100.a(null);
        return;
    L8:
        if (r102.r0(this) == false) goto L13;
        LayerHostMediaLayout r103 = this.f455994e.f455949c;
        if (r103 == null) goto L12;
        r103.C(r100);
        return;
    L12:
        r100.a(null);
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        super.draw(r100);
    }

    public final void e(Context r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f455992c == null) goto L7;
        return;
    L7:
        if (this.f456010u == true) goto L9;
        this.f456011v = 0;
    L13:
        LayerHostMediaLayout r101 = new LayerHostMediaLayout(r100);
        this.f455992c = r101;
        r101.setVideoViewType(this.f456011v);
        this.f455992c.E();
        this.f455992c.setUseActiveLayers(this.F);
        this.f455992c.setDeactiveLayerWhenRelease(this.G);
        addView(this.f455992c, new ViewGroup.LayoutParams(-1, -1));
        this.f455992c.setUseActiveLayers(this.F);
        this.f455992c.setDeactiveLayerWhenRelease(this.G);
        this.f455992c.setParentView(this);
        LayerHostMediaLayout r102 = this.f455992c;
        Lifecycle r103 = this.f455998i;
        if (r103 == null) goto L16;
        r102.f456057s = r103;
        return;
    L16:
        r102.getClass();
        return;
    L9:
        if (Build.VERSION.SDK_INT >= 24) goto L11;
        this.f456011v = 2;
        goto L13
    L11:
        this.f456011v = 1;
        goto L13
    }

    public final void n(long r100) {
        LayerHostMediaLayout r101 = this.f455992c;
        if (r101 != null) goto L5;
        VideoContext r102 = this.f455994e;
        if (r102 != null) goto L12;
        return;
    L12:
        if (r102.r0(this) == false) goto L25;
        LayerHostMediaLayout r103 = this.f455994e.f455949c;
        if (r103 != null) goto L16;
        return;
    L16:
        if (r100 < 0) goto L27;
        qic.a r104 = r103.f456048j;
        if (r104 == null) goto L28;
        r104.seekTo(r100);
        return;
    L28:
        return;
    L27:
        return;
    L25:
        return;
    L5:
        if (r100 < 0) goto L21;
        qic.a r105 = r101.f456048j;
        if (r105 == null) goto L22;
        r105.seekTo(r100);
        return;
    L22:
        return;
    }

    public final void p(l.a r100) {
        VideoContext r101 = this.f455994e;
        if (r101 == null) goto L6;
        r101.K0(r100);
        return;
    }

    public void setAsyncPosition(boolean r100) {
        this.B = r100;
        LayerHostMediaLayout r101 = this.f455992c;
        if (r101 == null) goto L5;
        r101.setAsyncPosition(r100);
        return;
    L5:
        VideoContext r102 = this.f455994e;
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.r0(this) == false) goto L15;
        LayerHostMediaLayout r103 = this.f455994e.f455949c;
        if (r103 == null) goto L16;
        r103.setAsyncPosition(r100);
        return;
    L16:
        return;
    }

    public void setAsyncRelease(boolean r100) {
        this.C = r100;
        LayerHostMediaLayout r101 = this.f455992c;
        if (r101 == null) goto L5;
        r101.setAsyncRelease(r100);
        return;
    L5:
        VideoContext r102 = this.f455994e;
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.r0(this) == false) goto L15;
        LayerHostMediaLayout r103 = this.f455994e.f455949c;
        if (r103 == null) goto L16;
        r103.setAsyncRelease(r100);
        return;
    L16:
        return;
    }

    public void setAttachListener(nic.a r100) {
        this.f455996g = r100;
    }

    public void setCanPlayBackground(boolean r100) {
        this.f456008s = r100;
    }

    public void setDeactiveLayerWhenRelease(boolean r100) {
        this.G = r100;
        LayerHostMediaLayout r101 = this.f455992c;
        if (r101 == null) goto L6;
        r101.setDeactiveLayerWhenRelease(r100);
        return;
    }

    public void setEnablePortraitFullScreen(boolean r100) {
        this.f455994e.f455965s = r100;
    }

    public void setHideHostWhenRelease(boolean r100) {
        this.f456006q = r100;
        LayerHostMediaLayout r101 = this.f455992c;
        if (r101 == null) goto L5;
        r101.setHideHostWhenRelease(r100);
        return;
    L5:
        VideoContext r102 = this.f455994e;
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.r0(this) == false) goto L15;
        LayerHostMediaLayout r103 = this.f455994e.f455949c;
        if (r103 == null) goto L16;
        r103.setHideHostWhenRelease(r100);
        return;
    L16:
        return;
    }

    public void setLayerEventListener(e r100) {
        LayerHostMediaLayout r101 = this.f455992c;
        if (r101 == null) goto L6;
        r101.setLayerEventListener(r100);
        return;
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams r100) {
        super.setLayoutParams(r100);
        ajc.b.a("SimpleMediaView", "setLayoutParams:" + r100.width + "*" + r100.height);
        bjc.b r101 = bjc.b.b("SMVSetLayoutParams", PathID.TEXTURE_SIZE, 3);
        if (r101 == null) goto L6;
        r101.a("info", "width:" + r100.width + "  height:" + r100.height);
        LogTracer.INS.addTrace(this.f455994e.m0(), r101);
        return;
    }

    public void setLoop(boolean r100) {
        this.f455991b.f472903e = r100;
        LayerHostMediaLayout r101 = this.f455992c;
        if (r101 == null) goto L5;
        r101.setLoop(r100);
        return;
    L5:
        VideoContext r102 = this.f455994e;
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.r0(this) == false) goto L15;
        LayerHostMediaLayout r103 = this.f455994e.f455949c;
        if (r103 == null) goto L16;
        r103.setLoop(r100);
        return;
    L16:
        return;
    }

    public void setMute(boolean r100) {
        this.f455991b.f472902d = r100;
        LayerHostMediaLayout r101 = this.f455992c;
        if (r101 == null) goto L5;
        r101.setMute(r100);
        return;
    L5:
        VideoContext r102 = this.f455994e;
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.r0(this) == false) goto L15;
        LayerHostMediaLayout r103 = this.f455994e.f455949c;
        if (r103 == null) goto L16;
        r103.setMute(r100);
        return;
    L16:
        return;
    }

    public void setPlayBackParams(PlaybackParams r100) {
        this.A = r100;
        LayerHostMediaLayout r101 = this.f455992c;
        if (r101 == null) goto L5;
        r101.setPlayBackParams(r100);
        return;
    L5:
        VideoContext r102 = this.f455994e;
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.r0(this) == false) goto L15;
        LayerHostMediaLayout r103 = this.f455994e.f455949c;
        if (r103 == null) goto L16;
        r103.setPlayBackParams(r100);
        return;
    L16:
        return;
    }

    public void setPlayEntity(tic.a r100) {
        o(r100, false);
    }

    public void setPlayUrlConstructor(nic.c r100) {
        this.f456002m = r100;
        LayerHostMediaLayout r101 = this.f455992c;
        if (r101 == null) goto L6;
        r101.setPlayUrlConstructor(r100);
        return;
    }

    public void setPortrait(boolean r100) {
        VideoContext r101 = this.f455994e;
        if (r101 == null) goto L6;
        r101.f455947a.f555368g = r100;
        return;
    }

    public void setRadius(float r100) {
        if (r100 > 0.0f) goto L5;
        return;
    L5:
        if (this.f456012w == r100) goto L12;
        this.f456012w = r100;
        if (getClipToOutline() == true) goto L9;
        setOutlineProvider(this.f456015z);
        setClipToOutline(true);
    L9:
        this.f456015z.f456017a = r100;
        invalidate();
        return;
    }

    public void setReleaseEngineEnabled(boolean r100) {
        LayerHostMediaLayout r101 = this.f455992c;
        if (r101 == null) goto L5;
        r101.setReleaseEngineEnabled(r100);
        return;
    L5:
        VideoContext r102 = this.f455994e;
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.r0(this) == false) goto L15;
        LayerHostMediaLayout r103 = this.f455994e.f455949c;
        if (r103 == null) goto L16;
        r103.setReleaseEngineEnabled(r100);
        return;
    L16:
        return;
    }

    public void setRenderMode(int r100) {
        this.f455991b.f472906h = r100;
        LayerHostMediaLayout r101 = this.f455992c;
        if (r101 == null) goto L5;
        r101.setRenderMode(r100);
        return;
    L5:
        VideoContext r102 = this.f455994e;
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.r0(this) == false) goto L15;
        LayerHostMediaLayout r103 = this.f455994e.f455949c;
        if (r103 == null) goto L16;
        r103.setRenderMode(r100);
        return;
    L16:
        return;
    }

    public void setStartTime(int r100) {
        LayerHostMediaLayout r101 = this.f455992c;
        if (r101 == null) goto L5;
        r101.setStartTime(r100);
        return;
    L5:
        VideoContext r102 = this.f455994e;
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.r0(this) == false) goto L15;
        LayerHostMediaLayout r103 = this.f455994e.f455949c;
        if (r103 == null) goto L16;
        r103.setStartTime(r100);
        return;
    L16:
        return;
    }

    public void setSurfaceViewConfiger(ejc.a r100) {
        this.f456000k = r100;
        LayerHostMediaLayout r101 = this.f455992c;
        if (r101 == null) goto L6;
        r101.setVideoPlayConfiger(this.f455999j);
        return;
    }

    public void setTextureLayout(int r100) {
        this.f455991b.f472905g = r100;
        LayerHostMediaLayout r101 = this.f455992c;
        if (r101 == null) goto L10;
        ejc.b r102 = r101.f456045g;
        if (r102 == null) goto L7;
        r102.f472905g = r100;
    L7:
        cjc.c r103 = r101.f456040b;
        if (r103 == null) goto L23;
        r103.a(r100);
        return;
    L23:
        return;
    L10:
        VideoContext r104 = this.f455994e;
        if (r104 != null) goto L13;
        return;
    L13:
        if (r104.r0(this) == false) goto L26;
        LayerHostMediaLayout r105 = this.f455994e.f455949c;
        if (r105 == null) goto L27;
        ejc.b r106 = r105.f456045g;
        if (r106 == null) goto L19;
        r106.f472905g = r100;
    L19:
        cjc.c r107 = r105.f456040b;
        if (r107 == null) goto L28;
        r107.a(r100);
        return;
    L28:
        return;
    L27:
        return;
    }

    public void setTryToInterceptPlay(boolean r100) {
        this.f456007r = r100;
        LayerHostMediaLayout r101 = this.f455992c;
        if (r101 == null) goto L5;
        r101.setTryToInterceptPlay(r100);
        return;
    L5:
        VideoContext r102 = this.f455994e;
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.r0(this) == false) goto L15;
        LayerHostMediaLayout r103 = this.f455994e.f455949c;
        if (r103 == null) goto L16;
        r103.setTryToInterceptPlay(r100);
        return;
    L16:
        return;
    }

    public void setTtvNetClient(TTVNetClient r100) {
        this.f456001l = r100;
        LayerHostMediaLayout r101 = this.f455992c;
        if (r101 == null) goto L6;
        r101.setTtvNetClient(r100);
        return;
    }

    public void setUseActiveLayers(boolean r100) {
        this.F = r100;
        LayerHostMediaLayout r101 = this.f455992c;
        if (r101 == null) goto L6;
        r101.setUseActiveLayers(r100);
        return;
    }

    public void setUseBlackCover(boolean r100) {
        this.f456005p = r100;
        LayerHostMediaLayout r101 = this.f455992c;
        if (r101 == null) goto L5;
        r101.setUseBlackCover(r100);
        return;
    L5:
        VideoContext r102 = this.f455994e;
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.r0(this) == false) goto L15;
        LayerHostMediaLayout r103 = this.f455994e.f455949c;
        if (r103 == null) goto L16;
        r103.setUseBlackCover(r100);
        return;
    L16:
        return;
    }

    public void setUseSurfaceView(boolean r100) {
        this.f456010u = r100;
    }

    public void setVideoEngineFactory(f r100) {
        this.f456004o = r100;
        LayerHostMediaLayout r101 = this.f455992c;
        if (r101 == null) goto L5;
        r101.setVideoEngineFactory(r100);
        return;
    L5:
        VideoContext r102 = this.f455994e;
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.r0(this) == false) goto L15;
        LayerHostMediaLayout r103 = this.f455994e.f455949c;
        if (r103 == null) goto L16;
        r103.setVideoEngineFactory(r100);
        return;
    L16:
        return;
    }

    public void setVideoMethodOpt(boolean r100) {
        this.H = r100;
        LayerHostMediaLayout r101 = this.f455992c;
        if (r101 == null) goto L6;
        r101.setVideoMethodOpt(r100);
        return;
    }

    public void setVideoPlayConfiger(j r100) {
        this.f455999j = r100;
        LayerHostMediaLayout r101 = this.f455992c;
        if (r101 == null) goto L6;
        r101.setVideoPlayConfiger(r100);
        return;
    }

    public void setZoomingEnabled(boolean r100) {
        LayerHostMediaLayout r101 = this.f455992c;
        if (r101 == null) goto L5;
        r101.setZoomingEnabled(r100);
        return;
    L5:
        VideoContext r102 = this.f455994e;
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.r0(this) == false) goto L15;
        LayerHostMediaLayout r103 = this.f455994e.f455949c;
        if (r103 == null) goto L16;
        r103.setZoomingEnabled(r100);
        return;
    L16:
        return;
    }

    public SimpleMediaView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public final void o(tic.a r100, boolean r101) {
        this.f455990a = r100;
        if (r100 == null) goto L5;
        this.f455991b = r100.f546377o;
    L5:
        StringBuilder r102 = new StringBuilder("setPlayEntity this.hash:");
        r102.append(hashCode());
        r102.append(" vid:");
        if (r100 == null) goto L8;
        String r103 = r100.f546363a;
    L9:
        r102.append(r103);
        ajc.b.a("SimpleMediaView", r102.toString());
        if (r101 == false) goto L22;
        LayerHostMediaLayout r104 = this.f455992c;
        if (r104 == null) goto L14;
        r104.setPlayEntity(r100);
        return;
    L14:
        VideoContext r105 = this.f455994e;
        if (r105 != null) goto L17;
        return;
    L17:
        if (r105.r0(this) == false) goto L25;
        LayerHostMediaLayout r106 = this.f455994e.f455949c;
        if (r106 == null) goto L26;
        r106.setPlayEntity(r100);
        return;
    L26:
        return;
    L25:
        return;
    L22:
        return;
    L8:
        r103 = "null";
        goto L9
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        super.onVisibilityChanged(r100, r101);
        if (r100 == this) goto L5;
        return;
    L5:
        if (isShown() == true) goto L7;
        boolean r102 = false;
    L8:
        this.f455997h = r102;
        ajc.b.c("SimpleMediaView", "onVisibilityChanged:" + this.f455997h);
        return;
    L7:
        this.f456009t.setEmpty();
        r102 = getGlobalVisibleRect(this.f456009t);
        goto L8
    }

    public SimpleMediaView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f455991b = ejc.b.a();
        this.f455996g = new oic.a();
        this.f456005p = true;
        this.f456006q = true;
        this.f456008s = false;
        this.f456009t = new Rect();
        this.f456010u = false;
        this.E = 0.0f;
        this.F = false;
        this.G = false;
        this.H = false;
        this.I = new a(this);
        if (r101 == null) goto L5;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.radius});
        this.E = r103.getDimension(0, 0.0f);
        r103.recycle();
    L5:
        ComponentCallbacks2 r104 = fjc.d.a(r100);
        long r105 = ThreadMethodProxy.getLooperThread(Looper.getMainLooper()).getId();
        long r106 = ThreadMethodProxy.currentThread().getId();
        if (r104 != null) goto L8;
        return;
    L8:
        if (this.D == false) goto L10;
        return;
    L10:
        if (r105 == r106) goto L12;
        return;
    L12:
        if ((r104 instanceof LifecycleOwner) == false) goto L15;
        this.f455998i = ((LifecycleOwner) r104).getLifecycle();
    L15:
        if (this.f455994e != null) goto L17;
        this.f455994e = VideoContext.n0(getContext());
    L17:
        this.f456015z = new b();
        setRadius(this.E);
        this.D = true;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        int r105 = getWidth();
        int r106 = getHeight();
        if (this.f456013x == r105) goto L5;
    L6:
        this.f456013x = r105;
        this.f456014y = r106;
        ajc.b.a("SimpleMediaView", "smv_size_layout:" + r105 + "*" + r106);
        return;
    L5:
        if (this.f456014y != r106) goto L6;
    }
}
