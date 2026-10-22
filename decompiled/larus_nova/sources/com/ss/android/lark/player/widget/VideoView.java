package com.ss.android.lark.player.widget;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.player.entity.DataSource;
import com.ss.android.lark.player.player.IMPlayerSettings;
import com.ss.android.lark.player.player.h;
import com.ss.android.lark.player.player.m;
import com.ss.android.lark.player.player.n;
import com.ss.android.lark.player.player.s;
import com.ss.android.lark.player.player.v;
import com.ss.android.lark.utils.LarkContext;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineInfoListener;
import e0c.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import v0c.j;
import v0c.p;
import v0c.q;
import v0c.r;
import v0c.t;

/* JADX INFO: loaded from: classes37.dex */
public class VideoView extends FrameLayout implements com.ss.android.lark.player.player.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public v f438748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SuperContainer f438749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RenderSurfaceView f438750c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f438751d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f438752e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f438753f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f438754g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f438755h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f438756i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f438757j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public RenderSurfaceView.b f438758k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public DataSource f438759l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final a f438760m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public n f438761n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public m f438762o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final b f438763p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final f f438764q;

    public class a implements RenderSurfaceView.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoView f438765a;

        public a(VideoView r100) {
            this.f438765a = r100;
        }
    }

    public class b implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoView f438766a;

        @Override // v0c.r
        public final boolean a() {
            return this.f438766a.f438755h;
        }

        @Override // v0c.r
        public final int getState() {
            return this.f438766a.f438748a.c();
        }

        public b(VideoView r100) {
            this.f438766a = r100;
        }
    }

    public class c implements t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoView f438767a;

        @Override // v0c.t
        public final r i() {
            return this.f438767a.f438763p;
        }

        public c(VideoView r100) {
            this.f438767a = r100;
        }
    }

    public class d implements n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoView f438768a;

        public d(VideoView r100) {
            this.f438768a = r100;
        }

        @Override // com.ss.android.lark.player.player.n
        public final void a(int r100, Bundle r101) {
            switch(r100) {
                case -99018: goto L9;
                case -99017: goto L7;
                case -99011: goto L6;
                case -99010: goto L5;
                default: goto L14;
            };
        L5:
            this.f438768a.f438755h = true;
            goto L14
        L6:
            this.f438768a.f438755h = false;
            goto L14
        L7:
            if (r101 == null) goto L14;
            this.f438768a.f438753f = r101.getInt("int_arg1");
            this.f438768a.f438754g = r101.getInt("int_arg2");
            Log.i("VideoView", "onVideoSizeChange : videoWidth = " + this.f438768a.f438753f + ", videoHeight = " + this.f438768a.f438754g);
            goto L14
        L9:
            if (r101 == null) goto L13;
            VideoView r102 = this.f438768a;
            if (r102.f438750c == null) goto L13;
            r102.f438753f = r101.getInt("int_arg1");
            this.f438768a.f438754g = r101.getInt("int_arg2");
        L13:
            VideoView r103 = this.f438768a;
            VideoView.b(r103, r103.f438758k);
        L14:
            n r104 = this.f438768a.f438761n;
            if (r104 == null) goto L17;
            r104.a(r100, r101);
        L17:
            this.f438768a.f438749b.b(r100, r101);
        }
    }

    public class e implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoView f438769a;

        public e(VideoView r100) {
            this.f438769a = r100;
        }

        @Override // com.ss.android.lark.player.player.m
        public final void h(int r100, Bundle r101) {
            Log.e("VideoView", "onError : code = " + r100 + ", Message = " + r101.toString());
            m r102 = this.f438769a.f438762o;
            if (r102 == null) goto L5;
            r102.h(r100, r101);
        L5:
            v0c.g r103 = this.f438769a.f438749b.f438738f;
            if (r103 == null) goto L9;
            r103.f552359a.d(new j(r100, r101));
            r101.clear();
            return;
        }
    }

    public class f implements AudioManager.OnAudioFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoView f438770a;

        public f(VideoView r100) {
            this.f438770a = r100;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(int r100) {
            if (r100 != (-3)) goto L5;
            this.f438770a.f();
            return;
        L5:
            if (r100 != (-2)) goto L7;
            this.f438770a.f();
            return;
        L7:
            if (r100 != (-1)) goto L15;
            this.f438770a.f();
            return;
        }
    }

    public class g implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoView f438771a;

        public g(VideoView r100) {
            this.f438771a = r100;
        }

        @Override // v0c.q
        public final void a(int r100, Bundle r101) {
            int r102 = 0;
            switch(r100) {
                case -660011: goto L36;
                case -66016: goto L35;
                case -66015: goto L34;
                case -66013: goto L31;
                case -66009: goto L27;
                case -66007: goto L23;
                case -66005: goto L20;
                case -66003: goto L13;
                case -66001: goto L6;
                default: goto L56;
            };
        L20:
            if (r101 == null) goto L22;
            r102 = r101.getInt("int_data");
        L22:
            this.f438771a.f438748a.i(r102);
            return;
        L23:
            VideoView r103 = this.f438771a;
            v r104 = r103.f438748a;
            if (r104.f() == false) goto L26;
            r104.f438710a.l();
        L26:
            r103.g();
            return;
        L27:
            VideoView r105 = this.f438771a;
            v r106 = r105.f438748a;
            if (r106.f() == false) goto L30;
            r106.f438710a.l();
        L30:
            r105.g();
            return;
        L31:
            VideoView r107 = this.f438771a;
            r107.h();
            v r108 = r107.f438748a;
            DataSource r109 = r108.f438711b;
            if (r109 == null) goto L51;
            r108.d(r109);
            r108.e(0);
            return;
        L51:
            return;
        L34:
            this.f438771a.f438748a.m(true);
            return;
        L35:
            this.f438771a.f438748a.m(false);
            return;
        L36:
            if (r101 == null) goto L38;
            r102 = r101.getInt("int_data");
        L38:
            VideoView r110 = this.f438771a;
            r110.h();
            v r111 = r110.f438748a;
            DataSource r112 = r111.f438711b;
            if (r112 == null) goto L55;
            r111.d(r112);
            r111.e(r102);
            return;
        L55:
            return;
        L56:
            return;
        L6:
            if (this.f438771a.e() == false) goto L8;
            this.f438771a.f();
            return;
        L8:
            VideoView r113 = this.f438771a;
            v r114 = r113.f438748a;
            if (r114.f() == false) goto L11;
            r114.f438710a.l();
        L11:
            r113.g();
            return;
        L13:
            if (this.f438771a.e() == false) goto L17;
            VideoView r115 = this.f438771a;
            r115.h();
            v r116 = r115.f438748a;
            if (r116.f() == false) goto L44;
            r116.f438710a.h();
            return;
        L44:
            return;
        L17:
            VideoView r117 = this.f438771a;
            r117.h();
            v r118 = r117.f438748a;
            DataSource r119 = r118.f438711b;
            if (r119 == null) goto L46;
            r118.d(r119);
            r118.e(0);
            return;
        }
    }

    public final void c() {
        Log.i("VideoView", "adjustSurfaceSizeIfNeed start, mViewWidth=" + this.f438751d + ",mViewHeight=" + this.f438752e + ",mVideoWidth=" + this.f438753f + ",mVideoHeight=" + this.f438754g);
        if (this.f438750c == null) goto L29;
        v r100 = this.f438748a;
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.f() == false) goto L11;
        s r101 = r100.f438710a;
        if (r101.b() == false) goto L11;
        boolean r102 = r101.f438689g.isSystemPlayer();
    L12:
        if (r102 == false) goto L14;
    L18:
        float r103 = this.f438751d;
        if (r103 <= 0.0f) goto L31;
        float r104 = this.f438752e;
        if (r104 <= 0.0f) goto L32;
        float r105 = this.f438753f;
        if (r105 <= 0.0f) goto L33;
        float r106 = this.f438754g;
        if (r106 <= 0.0f) goto L35;
        float r107 = Math.min(r103 / r105, r104 / r106);
        FrameLayout.LayoutParams r108 = (FrameLayout.LayoutParams) this.f438750c.getLayoutParams();
        r108.width = (int) (this.f438753f * r107);
        r108.height = (int) (this.f438754g * r107);
        this.f438750c.setLayoutParams(r108);
        this.f438749b.c();
        Log.i("VideoView", "adjustSurfaceSizeIfNeed end, longSideRatio=" + r107 + ", surfaceWidth=" + r108.width + ",surfaceHeight=" + r108.height);
        return;
    L35:
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    L14:
        if (this.f438748a.g() == true) goto L18;
        if (this.f438757j == true) goto L18;
        return;
    L11:
        r102 = true;
        goto L12
    }

    public final void f() {
        this.f438748a.h();
        g();
    }

    public final void g() {
        Log.i("VideoView", "<<releaseAudioFocus>>");
        AudioManager r100 = (AudioManager) getContext().getSystemService("audio");
        if (r100 == null) goto L6;
        r100.abandonAudioFocus(this.f438764q);
        return;
    }

    public int getBufferPercentage() {
        v r100 = this.f438748a;
        if (r100.f() == true) goto L7;
        return 0;
    L7:
        return r100.f438710a.f438667e;
    }

    public int getCurrentPosition() {
        return this.f438748a.a();
    }

    public int getDuration() {
        return this.f438748a.b();
    }

    public int getState() {
        return this.f438748a.c();
    }

    public final void h() {
        Log.i("VideoView", ">>requestAudioFocus<<");
        AudioManager r100 = (AudioManager) getContext().getSystemService("audio");
        if (r100 == null) goto L6;
        r100.requestAudioFocus(this.f438764q, 3, 2);
        return;
    }

    public final void i() {
        Log.i("VideoView", "stopPlayback release.");
        g();
        v r100 = this.f438748a;
        if (r100.f() == false) goto L14;
        s r101 = r100.f438710a;
        r101.getClass();
        Log.i("TTEnginePlayer", "destroy: " + r101.f438698p);
        com.ss.android.lark.player.player.a r102 = r101.f438690h;
        if (r102 == null) goto L8;
        r102.f438662a.dispose();
        r101.f438690h = null;
    L8:
        if (r101.b() == false) goto L14;
        r101.n(-2);
        if (r101.b() == false) goto L13;
        r101.f438689g.setListener(null);
    L13:
        TTVideoEngine r103 = r101.f438689g;
        r101.f438689g = null;
        r103.release();
        r101.a(-99009, null);
    L14:
        r100.f438712c.f438706e = null;
        s r104 = r100.f438710a;
        if (r104 == null) goto L20;
        r104.f438664b = null;
        r104.f438665c = null;
        r104.f438666d = null;
        if (r104.b() == false) goto L20;
        r104.f438689g.setVideoEngineInfoListener(null);
    L20:
        this.f438758k = null;
        SuperContainer r105 = this.f438749b;
        p r106 = r105.f438739g;
        if (r106 == null) goto L23;
        r106.c(r105.f438743k);
    L23:
        x0c.c r107 = r105.f438735c;
        Iterator r108 = ((CopyOnWriteArrayList) r107.f562079a).iterator();
    L25:
        if (r108.hasNext() == false) goto L27;
        x0c.a r109 = (x0c.a) r108.next();
        r109.a();
        r109.destroy();
        goto L25
    L27:
        ((CopyOnWriteArrayList) r107.f562079a).clear();
        FrameLayout r110 = r105.f438733a;
        if (r110 == null) goto L30;
        r110.removeAllViews();
    L30:
        v0c.c r111 = r105.f438734b;
        ((ArrayList) r111.f552353b).clear();
        r111.f552352a.removeAllViews();
    }

    public final boolean e() {
        int r100 = getState();
        if (r100 != (-2)) goto L5;
    L12:
        return false;
    L5:
        if (r100 == (-1)) goto L12;
        if (r100 == 0) goto L12;
        if (r100 == 1) goto L12;
        if (r100 == 5) goto L12;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        setKeepScreenOn(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setKeepScreenOn(false);
    }

    public m getOnErrorEventListener() {
        return this.f438762o;
    }

    public n getOnPlayerEventListener() {
        return this.f438761n;
    }

    public final SuperContainer getSuperContainer() {
        return this.f438749b;
    }

    public VideoView(Context r100) {
        this(r100, null);
    }

    public final void d(String r100) {
        s r101 = this.f438748a.f438710a;
        if ((r101 instanceof s) == false) goto L23;
        com.ss.android.lark.player.player.a r102 = r101.f438690h;
        if (r102 == null) goto L8;
        r102.f438662a.dispose();
        r101.f438690h = null;
    L8:
        if (r101.b() == false) goto L24;
        TTVideoEngine r103 = r101.f438689g;
        h r104 = h.f438673a;
        Intrinsics.checkNotNullParameter(r103, "engine");
        Intrinsics.checkNotNullParameter(r100, "userId");
        com.ss.android.lark.player.player.d r105 = com.ss.android.lark.player.player.d.f438669a;
        Intrinsics.checkNotNullParameter(r103, "engine");
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r105, "builder");
        com.ss.android.lark.player.player.e r106 = new com.ss.android.lark.player.player.e(new WeakReference(r103));
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r105, "builder");
        Intrinsics.checkNotNullParameter(r106, "writer");
        h r107 = h.f438673a;
        com.ss.android.lark.player.player.f r108 = new com.ss.android.lark.player.player.f(r106);
        r107.getClass();
        com.ss.android.lark.player.player.g r109 = new com.ss.android.lark.player.player.g();
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L13
        Object r111 = Result.m9449constructorimpl(((com.ss.android.lark.passport.auth.e) k.a(LarkContext.getApplication(), com.ss.android.lark.passport.auth.e.class)).a(r100, r109, r108));     // Catch: Throwable -> L13
    L15:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r111);
        if (r112 == null) goto L19;
        Log.e("PlayerAuthHeaders", "bind Passport auth headers failed", r112);
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r109, "build");
        Intrinsics.checkNotNullParameter(r108, "onHeadersChanged");
        r111 = new com.ss.android.lark.passport.auth.a(r109, r108);
    L19:
        r101.f438690h = new com.ss.android.lark.player.player.a((com.ss.android.lark.passport.auth.h) r111);
        r101.m();
        return;
    L13:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    L24:
        return;
    }

    public void setDataSource(DataSource r100) {
        DataSource r101 = this.f438759l;
        if (r101 != null) goto L5;
    L11:
        boolean r102 = false;
    L12:
        if (r102 == true) goto L29;
        v r103 = this.f438748a;
        if (r103.f() == false) goto L22;
        s r104 = r103.f438710a;
        r104.getClass();
    L20:
        e = move-exception;
        r104.e(e);
        goto L22
    L17:
        if (r104.b() == false) goto L22;
        r104.f438689g.setSurface(null);     // Catch: Exception -> L20
        r104.a(-99002, null);     // Catch: Exception -> L20
    L22:
        this.f438758k = null;
        RenderSurfaceView r105 = new RenderSurfaceView(getContext());
        this.f438750c = r105;
        r105.setRenderCallback(this.f438760m);
        this.f438749b.setRenderView(this.f438750c);
        RenderSurfaceView r106 = this.f438750c;
        if (r106 == null) goto L29;
        if (this.f438756i == false) goto L28;
        r106.setVisibility(0);
        goto L29
    L28:
        r106.setVisibility(4);
    L29:
        this.f438748a.j(r100);
        this.f438759l = r100;
        return;
    L5:
        if (Objects.equals(r101.getData(), r100.getData()) == false) goto L7;
    L8:
        r102 = true;
        if (IMPlayerSettings.a().getReuseSurfaceView() != 1) goto L11;
    L7:
        if (this.f438759l.getUri() != r100.getUri()) goto L11;
        goto L8
    }

    public void setMute(boolean r100) {
        this.f438748a.k(r100);
    }

    public void setOnErrorEventListener(m r100) {
        this.f438762o = r100;
    }

    public void setOnPlayerEventListener(n r100) {
        this.f438761n = r100;
    }

    public void setReceiverGroup(p r100) {
        this.f438749b.setReceiverGroup(r100);
    }

    public void setSpeed(float r100) {
        this.f438748a.l(r100);
    }

    public void setSurfaceViewVisible(boolean r100) {
        this.f438756i = r100;
        RenderSurfaceView r101 = this.f438750c;
        if (r101 == null) goto L10;
        if (r100 == false) goto L7;
        r101.setVisibility(0);
        return;
    L7:
        r101.setVisibility(4);
        return;
    }

    public void setVideoEngineInfoListener(VideoEngineInfoListener r100) {
        v r101 = this.f438748a;
        if (r101 == null) goto L6;
        r101.f438715f = r100;
        return;
    }

    public void setVideoID(String r100) {
        v r101 = this.f438748a;
        if (r101.f() == false) goto L8;
        s r102 = r101.f438710a;
        if (r102.b() == false) goto L9;
        r102.f438689g.setVideoID(r100);
        return;
    L9:
        return;
    }

    public void setDataSource(com.ss.ttvideoengine.DataSource r100) {
        v r101 = this.f438748a;
        if (r101.f() == false) goto L8;
        s r102 = r101.f438710a;
        if (r102.b() == false) goto L9;
        r102.f438689g.setDataSource(r100);
        return;
    L9:
        return;
    }

    public VideoView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public static void b(VideoView r100, RenderSurfaceView.b r101) {
        if (r101 == null) goto L16;
        v r102 = r100.f438748a;
        RenderSurfaceView.c r103 = (RenderSurfaceView.c) r101;
        if (r102 != null) goto L6;
        return;
    L6:
        if (r103.f438729a.get() == null) goto L21;
        SurfaceHolder r104 = r103.f438729a.get();
        if (r102.f() == false) goto L22;
        s r105 = r102.f438710a;
        r105.getClass();
    L14:
        e = move-exception;
        r105.e(e);
        return;
    L11:
        if (r105.b() == false) goto L23;
        r105.f438689g.setSurfaceHolder(r104);     // Catch: Exception -> L14
        r105.a(-99002, null);     // Catch: Exception -> L14
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L16:
        r100.getClass();
    }

    @Override // com.ss.android.lark.player.player.b.a
    public final void a(float r100, float r101) {
        this.f438753f = r100;
        this.f438754g = r101;
        c();
    }

    public VideoView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f438756i = true;
        this.f438757j = false;
        this.f438760m = new a(this);
        this.f438763p = new b(this);
        c r103 = new c(this);
        d r104 = new d(this);
        e r105 = new e(this);
        this.f438764q = new f(this);
        g r106 = new g(this);
        v r107 = new v();
        this.f438748a = r107;
        r107.f438713d = r104;
        r107.f438714e = r105;
        r107.f438716g = this;
        SuperContainer r108 = new SuperContainer(r100);
        this.f438749b = r108;
        r108.setStateGetter(r103);
        this.f438749b.setOnReceiverEventListener(r106);
        ViewGroup.LayoutParams r109 = new ViewGroup.LayoutParams(-1, -1);
        addView(this.f438749b, r109);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        this.f438751d = r100;
        this.f438752e = r101;
        c();
    }
}
