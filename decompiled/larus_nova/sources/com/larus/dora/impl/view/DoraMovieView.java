package com.larus.dora.impl.view;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.TypedArray;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.widget.FrameLayout;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.nova.R;
import com.larus.platform.api.z3;
import com.larus.platform.service.q3;
import com.ss.ttvideoengine.TTVideoEngine;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes27.dex */
public class DoraMovieView extends FrameLayout {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f338183r = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TTVideoEngine f338184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f338185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f338186c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f338187d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f338188e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextureView f338189f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f338190g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SurfaceTexture f338191h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public e f338192i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public d f338193j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Boolean f338194k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Boolean f338195l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Boolean f338196m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f338197n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f338198o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public c f338199p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Handler f338200q;

    public class a implements TextureView.SurfaceTextureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoraMovieView f338201a;

        public a(DoraMovieView r100) {
            this.f338201a = r100;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture r100) {
            g49.d.a("DoraMovieView", "MovieView ---onSurfaceTextureDestroyed");
            this.f338201a.f338191h = r100;
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureUpdated(SurfaceTexture r100) {
            this.f338201a.f338191h = r100;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(SurfaceTexture r100, int r101, int r102) {
            g49.d.a("DoraMovieView", "MovieView ---onSurfaceTextureAvailable");
            DoraMovieView r103 = this.f338201a;
            r103.f338191h = r100;
            if (r103.f338184a != null) goto L5;
            r103.c(new Surface(r100));
            return;
        L5:
            r103.e();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureSizeChanged(SurfaceTexture r100, int r101, int r102) {
            this.f338201a.f338191h = r100;
        }
    }

    public class b implements Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoraMovieView f338202a;

        public b(DoraMovieView r100) {
            this.f338202a = r100;
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message r100) {
            if (r100.what != 1000) goto L8;
            DoraMovieView r101 = this.f338202a;
            int r102 = DoraMovieView.f338183r;
            r101.getClass();
            return false;
        L8:
            return false;
        }
    }

    public interface c {
        void a();
    }

    public interface d {
        void onFirstFrameRendered();
    }

    public interface e {
        void onStart();
    }

    public interface f {
    }

    public void setOnProgressListener(f r100) {
    }

    public final boolean a() {
        TTVideoEngine r100 = this.f338184a;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.getPlaybackState() != 1) goto L7;
        return true;
    }

    public final void b() {
        g49.d.a("DoraMovieView", "MovieView loopplay: " + this.f338184a + " - " + a());
        TTVideoEngine r100 = this.f338184a;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.setLooping(true);
        this.f338184a.play();
        this.f338200q.sendEmptyMessage(1000);
        setKeepScreenOn(true);
    }

    public final void d() {
        g49.d.a("DoraMovieView", "MovieView pause: " + this.f338184a + " - " + a());
        TTVideoEngine r100 = this.f338184a;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.pause();
        if (this.f338200q.hasMessages(1000) == false) goto L8;
        this.f338200q.removeMessages(1000);
    L8:
        setKeepScreenOn(false);
    }

    public final void e() {
        g49.d.a("DoraMovieView", "MovieView play: " + this.f338184a + " - " + a());
        TTVideoEngine r100 = this.f338184a;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.play();
        this.f338200q.sendEmptyMessage(1000);
        setKeepScreenOn(true);
    }

    public final void f() {
        TTVideoEngine r100 = this.f338184a;
        if (r100 == null) goto L6;
        r100.release();
        this.f338184a = null;
    L6:
        if (this.f338200q.hasMessages(1000) == false) goto L9;
        this.f338200q.removeMessages(1000);
        return;
    }

    public final void g() {
        g49.d.a("DoraMovieView", "MovieView stop: " + this.f338184a + " - " + a());
        TTVideoEngine r100 = this.f338184a;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.stop();
        if (this.f338200q.hasMessages(1000) == false) goto L8;
        this.f338200q.removeMessages(1000);
    L8:
        setKeepScreenOn(false);
    }

    public int getCurrentPosition() {
        TTVideoEngine r100 = this.f338184a;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getCurrentPlaybackTime();
    }

    public int getDuration() {
        TTVideoEngine r100 = this.f338184a;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getDuration();
    }

    public DoraMovieView(Context r100) {
        this(r100, null);
    }

    public final void c(Surface r100) {
        if (this.f338185b == 0) goto L5;
    L7:
        Lazy r101 = q3.f365794a;
        z3 r102 = q3.a();
        if (r102 == null) goto L10;
        r102.j();
    L10:
        TTVideoEngine r103 = new TTVideoEngine(getContext(), 0);
        this.f338184a = r103;
        r103.setIntOption(4, 1);
        this.f338184a.setSurface(r100);
        this.f338184a.setLooping(this.f338194k.booleanValue());
        if (this.f338185b == 0) goto L13;
        AssetFileDescriptor r104 = getResources().openRawResourceFd(this.f338185b);
        this.f338184a.setDataSource(r104.getFileDescriptor(), r104.getStartOffset(), r104.getLength());
    L14:
        this.f338184a.setVideoEngineCallback(new com.larus.dora.impl.view.a(this));
        this.f338184a.prepare();
        return;
    L13:
        PolarisFileWrapper r105 = new PolarisFileWrapper(this.f338186c);
        this.f338184a.setLocalURL(r105.getAbsolutePath());
        goto L14
    L5:
        if (TextUtils.isEmpty(this.f338186c) == false) goto L7;
    }

    public void setDataSource(int r100) {
    L10:
        e = move-exception;
        throw new RuntimeException(e);
    L3:
        if (this.f338184a != null) goto L5;
        return;
    L5:
        g49.d.a("DoraMovieView", "setDataSource videoResourceId start");     // Catch: Exception -> L10
        if (r100 == this.f338185b) goto L15;
        if (r100 == 0) goto L16;
        this.f338185b = r100;     // Catch: Exception -> L10
        this.f338184a.stop();     // Catch: Exception -> L10
        AssetFileDescriptor r101 = getResources().openRawResourceFd(this.f338185b);     // Catch: Exception -> L10
        this.f338184a.setDataSource(r101.getFileDescriptor(), r101.getStartOffset(), r101.getLength());     // Catch: Exception -> L10
        return;
    L16:
        return;
    }

    public void setDoraMovieCallback(c r100) {
        this.f338199p = r100;
    }

    public void setEngineLooping(boolean r100) {
        TTVideoEngine r101 = this.f338184a;
        if (r101 == null) goto L6;
        r101.setLooping(r100);
        return;
    }

    public void setFirstFrameRenderedListener(d r100) {
        this.f338193j = r100;
    }

    public void setLooping(Boolean r100) {
        this.f338194k = r100;
    }

    public void setMediaPlayerStartListener(e r100) {
        this.f338192i = r100;
    }

    public void setPauseInFirst(boolean r100) {
        this.f338195l = Boolean.valueOf(r100);
    }

    public void setVideoResourceId(int r100) {
        if (r100 > 0) goto L15;
        String r101 = "invalid res id : " + r100;
    L7:
        g49.d.a("DoraMovieView", "MovieView setVideoResourceId: " + r101);
        this.f338185b = r100;
        this.f338186c = "";
        if (this.f338191h != null) goto L11;
        return;
    L11:
        if (this.f338184a != null) goto L13;
        c(new Surface(this.f338191h));
        return;
    L13:
        e();
        return;
    L15:
        r101 = getResources().getResourceName(r100);     // Catch: Exception -> L5
    L5:
        r101 = "Unable to find resource ID" + r100;
        goto L7
    }

    public void setVideoResourceIdOnly(int r100) {
        if (r100 > 0) goto L14;
        String r101 = "invalid res id : " + r100;
    L7:
        g49.d.a("DoraMovieView", "MovieView setVideoResourceId: " + r101);
        this.f338185b = r100;
        this.f338186c = "";
        if (this.f338191h != null) goto L11;
        return;
    L11:
        if (this.f338184a != null) goto L16;
        c(new Surface(this.f338191h));
        return;
    L16:
        return;
    L14:
        r101 = getResources().getResourceName(r100);     // Catch: Exception -> L5
    L5:
        r101 = "Unable to find resource ID" + r100;
        goto L7
    }

    public void setVideoResourcePath(String r100) {
        g49.d.a("DoraMovieView", "MovieView setVideoResourcePath: " + r100);
        this.f338186c = r100;
        this.f338185b = 0;
        if (this.f338191h != null) goto L6;
        return;
    L6:
        if (this.f338184a != null) goto L8;
        c(new Surface(this.f338191h));
        return;
    L8:
        e();
    }

    public void setVideoResourcePathOnly(String r100) {
        g49.d.a("DoraMovieView", "MovieView setVideoResourcePath: " + r100);
        this.f338186c = r100;
        this.f338185b = 0;
        if (this.f338191h != null) goto L6;
        return;
    L6:
        if (this.f338184a != null) goto L9;
        c(new Surface(this.f338191h));
        return;
    }

    public void setDataSource(String r100) {
    L11:
        e = move-exception;
        throw new RuntimeException(e);
    L3:
        if (this.f338184a != null) goto L5;
        return;
    L5:
        g49.d.a("DoraMovieView", "setDataSource videoResourcePath start");     // Catch: Exception -> L11
        if (r100.equals(this.f338186c) == false) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r100) == true) goto L17;
        this.f338186c = r100;     // Catch: Exception -> L11
        this.f338184a.stop();     // Catch: Exception -> L11
        PolarisFileWrapper r101 = new PolarisFileWrapper(this.f338186c);     // Catch: Exception -> L11
        this.f338184a.setLocalURL(r101.getAbsolutePath());     // Catch: Exception -> L11
        return;
    }

    public DoraMovieView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public DoraMovieView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f338184a = null;
        Boolean r103 = Boolean.FALSE;
        this.f338194k = r103;
        this.f338195l = r103;
        this.f338196m = Boolean.TRUE;
        this.f338197n = 0;
        this.f338198o = 0;
        this.f338199p = null;
        this.f338200q = new Handler(new b(this));
        if (r101 == null) goto L10;
        TypedArray r104 = getContext().getTheme().obtainStyledAttributes(r101, new int[]{R.attr.larus_bottomRadius, R.attr.larus_topRadius}, 0, 0);
        this.f338197n = r104.getDimensionPixelSize(1, 0);     // Catch: Throwable -> L7
        this.f338198o = r104.getDimensionPixelSize(0, 0);     // Catch: Throwable -> L7
        r104.recycle();
    L7:
        th = move-exception;
        r104.recycle();
        throw th;
    L10:
        TextureView r105 = new TextureView(getContext());
        this.f338189f = r105;
        addView(r105, -1, -1);
        r105.setSurfaceTextureListener(new a(this));
    }
}
