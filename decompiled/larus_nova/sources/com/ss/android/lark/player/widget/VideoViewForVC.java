package com.ss.android.lark.player.widget;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.player.entity.DataSource;
import com.ss.android.lark.player.player.IMPlayerSettings;
import com.ss.android.lark.player.player.m;
import com.ss.android.lark.player.player.n;
import com.ss.android.lark.player.player.s;
import com.ss.android.lark.player.player.v;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineInfoListener;
import java.util.Objects;
import v0c.g;
import v0c.j;
import v0c.p;
import v0c.q;
import v0c.r;
import v0c.t;

/* JADX INFO: loaded from: classes37.dex */
public class VideoViewForVC extends FrameLayout implements com.ss.android.lark.player.player.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public v f438772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SuperContainer f438773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RenderTextureView f438774c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f438775d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f438776e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f438777f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f438778g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f438779h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f438780i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RenderTextureView.b f438781j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public DataSource f438782k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final a f438783l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public n f438784m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public m f438785n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final b f438786o;

    public class a implements RenderTextureView.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoViewForVC f438787a;

        public a(VideoViewForVC r100) {
            this.f438787a = r100;
        }
    }

    public class b implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoViewForVC f438788a;

        @Override // v0c.r
        public final boolean a() {
            return this.f438788a.f438779h;
        }

        @Override // v0c.r
        public final int getState() {
            return this.f438788a.f438772a.c();
        }

        public b(VideoViewForVC r100) {
            this.f438788a = r100;
        }
    }

    public class c implements t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoViewForVC f438789a;

        @Override // v0c.t
        public final r i() {
            return this.f438789a.f438786o;
        }

        public c(VideoViewForVC r100) {
            this.f438789a = r100;
        }
    }

    public class d implements n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoViewForVC f438790a;

        public d(VideoViewForVC r100) {
            this.f438790a = r100;
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
            this.f438790a.f438779h = true;
            goto L14
        L6:
            this.f438790a.f438779h = false;
            goto L14
        L7:
            if (r101 == null) goto L14;
            this.f438790a.f438777f = r101.getInt("int_arg1");
            this.f438790a.f438778g = r101.getInt("int_arg2");
            Log.i("VideoView", "onVideoSizeChange : videoWidth = " + this.f438790a.f438777f + ", videoHeight = " + this.f438790a.f438778g);
            goto L14
        L9:
            if (r101 == null) goto L13;
            VideoViewForVC r102 = this.f438790a;
            if (r102.f438774c == null) goto L13;
            r102.f438777f = r101.getInt("int_arg1");
            this.f438790a.f438778g = r101.getInt("int_arg2");
        L13:
            VideoViewForVC r103 = this.f438790a;
            VideoViewForVC.b(r103, r103.f438781j);
        L14:
            n r104 = this.f438790a.f438784m;
            if (r104 == null) goto L17;
            r104.a(r100, r101);
        L17:
            this.f438790a.f438773b.b(r100, r101);
        }
    }

    public class e implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoViewForVC f438791a;

        public e(VideoViewForVC r100) {
            this.f438791a = r100;
        }

        @Override // com.ss.android.lark.player.player.m
        public final void h(int r100, Bundle r101) {
            Log.e("VideoView", "onError : code = " + r100 + ", Message = " + r101.toString());
            m r102 = this.f438791a.f438785n;
            if (r102 == null) goto L5;
            r102.h(r100, r101);
        L5:
            g r103 = this.f438791a.f438773b.f438738f;
            if (r103 == null) goto L9;
            r103.f552359a.d(new j(r100, r101));
            r101.clear();
            return;
        }
    }

    public class f implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoViewForVC f438792a;

        public f(VideoViewForVC r100) {
            this.f438792a = r100;
        }

        @Override // v0c.q
        public final void a(int r100, Bundle r101) {
            boolean r102 = true;
            int r103 = 0;
            switch(r100) {
                case -660011: goto L47;
                case -66016: goto L46;
                case -66015: goto L45;
                case -66013: goto L42;
                case -66009: goto L39;
                case -66007: goto L36;
                case -66005: goto L33;
                case -66003: goto L18;
                case -66001: goto L5;
                default: goto L70;
            };
        L5:
            int r104 = this.f438792a.getState();
            if (r104 == (-2)) goto L12;
            if (r104 == (-1)) goto L12;
            if (r104 == 0) goto L12;
            if (r104 == 1) goto L12;
            if (r104 == 5) goto L12;
        L13:
            if (r102 == false) goto L15;
            this.f438792a.f438772a.h();
            return;
        L15:
            v r105 = this.f438792a.f438772a;
            if (r105.f() == false) goto L54;
            r105.f438710a.l();
            return;
        L54:
            return;
        L12:
            r102 = false;
            goto L13
        L18:
            int r106 = this.f438792a.getState();
            if (r106 == (-2)) goto L25;
            if (r106 == (-1)) goto L25;
            if (r106 == 0) goto L25;
            if (r106 == 1) goto L25;
            if (r106 == 5) goto L25;
        L26:
            if (r102 == false) goto L30;
            v r107 = this.f438792a.f438772a;
            if (r107.f() == false) goto L56;
            r107.f438710a.h();
            return;
        L56:
            return;
        L30:
            v r108 = this.f438792a.f438772a;
            DataSource r109 = r108.f438711b;
            if (r109 == null) goto L58;
            r108.d(r109);
            r108.e(0);
            return;
        L58:
            return;
        L25:
            r102 = false;
            goto L26
        L33:
            if (r101 == null) goto L35;
            r103 = r101.getInt("int_data");
        L35:
            this.f438792a.f438772a.i(r103);
            return;
        L36:
            v r110 = this.f438792a.f438772a;
            if (r110.f() == false) goto L61;
            r110.f438710a.l();
            return;
        L61:
            return;
        L39:
            v r111 = this.f438792a.f438772a;
            if (r111.f() == false) goto L63;
            r111.f438710a.l();
            return;
        L63:
            return;
        L42:
            v r112 = this.f438792a.f438772a;
            DataSource r113 = r112.f438711b;
            if (r113 == null) goto L65;
            r112.d(r113);
            r112.e(0);
            return;
        L65:
            return;
        L45:
            this.f438792a.f438772a.m(true);
            return;
        L46:
            this.f438792a.f438772a.m(false);
            return;
        L47:
            if (r101 == null) goto L49;
            r103 = r101.getInt("int_data");
        L49:
            v r114 = this.f438792a.f438772a;
            DataSource r115 = r114.f438711b;
            if (r115 == null) goto L69;
            r114.d(r115);
            r114.e(r103);
            return;
        L69:
            return;
        }
    }

    public final void c() {
        Log.i("VideoView", "adjustSurfaceSizeIfNeed start, mViewWidth=" + this.f438775d + ",mViewHeight=" + this.f438776e + ",mVideoWidth=" + this.f438777f + ",mVideoHeight=" + this.f438778g);
        if (this.f438774c == null) goto L27;
        v r100 = this.f438772a;
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.f() == false) goto L11;
        s r101 = r100.f438710a;
        if (r101.b() == false) goto L11;
        boolean r102 = r101.f438689g.isSystemPlayer();
    L12:
        if (r102 == false) goto L14;
    L16:
        float r103 = this.f438775d;
        if (r103 <= 0.0f) goto L29;
        float r104 = this.f438776e;
        if (r104 <= 0.0f) goto L30;
        float r105 = this.f438777f;
        if (r105 <= 0.0f) goto L31;
        float r106 = this.f438778g;
        if (r106 <= 0.0f) goto L33;
        float r107 = Math.min(r103 / r105, r104 / r106);
        FrameLayout.LayoutParams r108 = (FrameLayout.LayoutParams) this.f438774c.getLayoutParams();
        r108.width = (int) (this.f438777f * r107);
        r108.height = (int) (this.f438778g * r107);
        this.f438774c.setLayoutParams(r108);
        this.f438773b.c();
        Log.i("VideoView", "adjustSurfaceSizeIfNeed end, longSideRatio=" + r107 + ", surfaceWidth=" + r108.width + ",surfaceHeight=" + r108.height);
        return;
    L33:
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L14:
        if (this.f438772a.g() == true) goto L16;
        return;
    L11:
        r102 = true;
        goto L12
    }

    public int getBufferPercentage() {
        v r100 = this.f438772a;
        if (r100.f() == true) goto L7;
        return 0;
    L7:
        return r100.f438710a.f438667e;
    }

    public int getCurrentPosition() {
        return this.f438772a.a();
    }

    public int getDuration() {
        return this.f438772a.b();
    }

    public int getState() {
        return this.f438772a.c();
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
        return this.f438785n;
    }

    public n getOnPlayerEventListener() {
        return this.f438784m;
    }

    public final SuperContainer getSuperContainer() {
        return this.f438773b;
    }

    public VideoViewForVC(Context r100) {
        this(r100, null);
    }

    public void setDataSource(DataSource r100) {
        DataSource r101 = this.f438782k;
        if (r101 != null) goto L5;
    L11:
        boolean r102 = false;
    L12:
        if (r102 == true) goto L29;
        v r103 = this.f438772a;
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
        this.f438781j = null;
        RenderTextureView r105 = new RenderTextureView(getContext());
        this.f438774c = r105;
        r105.setRenderCallback(this.f438783l);
        this.f438773b.setRenderView(this.f438774c);
        RenderTextureView r106 = this.f438774c;
        if (r106 == null) goto L29;
        if (this.f438780i == false) goto L28;
        r106.setVisibility(0);
        goto L29
    L28:
        r106.setVisibility(4);
    L29:
        this.f438772a.j(r100);
        this.f438782k = r100;
        return;
    L5:
        if (Objects.equals(r101.getData(), r100.getData()) == false) goto L7;
    L8:
        r102 = true;
        if (IMPlayerSettings.a().getReuseSurfaceView() != 1) goto L11;
    L7:
        if (this.f438782k.getUri() != r100.getUri()) goto L11;
        goto L8
    }

    public void setHardwareDecode(boolean r100) {
        v r101 = this.f438772a;
        if (r101 == null) goto L10;
        s r102 = r101.f438710a;
        if (r102 == null) goto L11;
        TTVideoEngine r103 = r102.f438689g;
        if (r103 == null) goto L12;
        r103.setIntOption(7, r100 ? 1 : 0);
        return;
    L12:
        return;
    L11:
        return;
    }

    public void setMute(boolean r100) {
        this.f438772a.k(r100);
    }

    public void setOnErrorEventListener(m r100) {
        this.f438785n = r100;
    }

    public void setOnPlayerEventListener(n r100) {
        this.f438784m = r100;
    }

    public void setReceiverGroup(p r100) {
        this.f438773b.setReceiverGroup(r100);
    }

    public void setSpeed(float r100) {
        this.f438772a.l(r100);
    }

    public void setSurfaceViewVisible(boolean r100) {
        this.f438780i = r100;
        RenderTextureView r101 = this.f438774c;
        if (r101 == null) goto L10;
        if (r100 == false) goto L7;
        r101.setVisibility(0);
        return;
    L7:
        r101.setVisibility(4);
        return;
    }

    public void setVideoEngineInfoListener(VideoEngineInfoListener r100) {
        v r101 = this.f438772a;
        if (r101 == null) goto L6;
        r101.f438715f = r100;
        return;
    }

    public void setVideoID(String r100) {
        v r101 = this.f438772a;
        if (r101.f() == false) goto L8;
        s r102 = r101.f438710a;
        if (r102.b() == false) goto L9;
        r102.f438689g.setVideoID(r100);
        return;
    L9:
        return;
    }

    public void setDataSource(com.ss.ttvideoengine.DataSource r100) {
        v r101 = this.f438772a;
        if (r101.f() == false) goto L8;
        s r102 = r101.f438710a;
        if (r102.b() == false) goto L9;
        r102.f438689g.setDataSource(r100);
        return;
    L9:
        return;
    }

    public VideoViewForVC(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public static void b(VideoViewForVC r100, RenderTextureView.b r101) {
        if (r101 == null) goto L16;
        v r102 = r100.f438772a;
        RenderTextureView.c r103 = (RenderTextureView.c) r101;
        if (r102 != null) goto L6;
        return;
    L6:
        if (r103.f438732a.get() == null) goto L21;
        Surface r104 = new Surface(r103.f438732a.get());
        if (r102.f() == false) goto L22;
        s r105 = r102.f438710a;
        r105.getClass();
    L14:
        e = move-exception;
        r105.e(e);
        return;
    L11:
        if (r105.b() == false) goto L23;
        r105.f438689g.setSurface(r104);     // Catch: Exception -> L14
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
        this.f438777f = r100;
        this.f438778g = r101;
        c();
    }

    public VideoViewForVC(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f438780i = true;
        this.f438783l = new a(this);
        this.f438786o = new b(this);
        c r103 = new c(this);
        d r104 = new d(this);
        e r105 = new e(this);
        f r106 = new f(this);
        v r107 = new v();
        this.f438772a = r107;
        r107.k(true);
        v r108 = this.f438772a;
        r108.f438713d = r104;
        r108.f438714e = r105;
        r108.f438716g = this;
        SuperContainer r109 = new SuperContainer(r100);
        this.f438773b = r109;
        r109.setStateGetter(r103);
        this.f438773b.setOnReceiverEventListener(r106);
        ViewGroup.LayoutParams r110 = new ViewGroup.LayoutParams(-1, -1);
        addView(this.f438773b, r110);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        this.f438775d = r100;
        this.f438776e = r101;
        c();
    }
}
