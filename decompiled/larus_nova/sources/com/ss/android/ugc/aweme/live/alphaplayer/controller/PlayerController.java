package com.ss.android.ugc.aweme.live.alphaplayer.controller;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.aweme.live.alphaplayer.AlphaVideoSurfaceView;
import com.ss.android.ugc.aweme.live.alphaplayer.AlphaVideoTextureView;
import com.ss.android.ugc.aweme.live.alphaplayer.Configuration;
import com.ss.android.ugc.aweme.live.alphaplayer.IAlphaVideoView;
import com.ss.android.ugc.aweme.live.alphaplayer.listener.AlphaPlayerAction;
import com.ss.android.ugc.aweme.live.alphaplayer.listener.ILoopListener;
import com.ss.android.ugc.aweme.live.alphaplayer.listener.IMonitor;
import com.ss.android.ugc.aweme.live.alphaplayer.listener.IPrepareListener;
import com.ss.android.ugc.aweme.live.alphaplayer.listener.IProgressListener;
import com.ss.android.ugc.aweme.live.alphaplayer.model.DataSource;
import com.ss.android.ugc.aweme.live.alphaplayer.model.MaskSrc;
import com.ss.android.ugc.aweme.live.alphaplayer.model.VideoInfo;
import com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer;
import com.ss.android.ugc.aweme.live.alphaplayer.player.DefaultSystemPlayer;
import com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer;
import com.ss.android.ugc.aweme.live.alphaplayer.player.PlayerState;
import com.ss.android.ugc.aweme.live.alphaplayer.render.VideoRenderer;
import com.ss.android.ugc.aweme.live.alphaplayer.utils.BitmapUtil;
import com.ss.android.ugc.aweme.live.alphaplayer.utils.PlayerProgressHelper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes40.dex */
public class PlayerController implements IPlayerController, LifecycleObserver, Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f451063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f451064b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f451065c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<MaskSrc> f451066d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PlayerState f451067e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Context f451068f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public IMonitor f451069g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AlphaPlayerAction f451070h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public IMediaPlayer<AbsPlayer<AbsPlayer>> f451071i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Handler f451072j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Handler f451073k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public PthreadHandlerThreadV2 f451074l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public IAlphaVideoView f451075m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f451076n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f451077o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f451078p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f451079q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile boolean f451080r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f451081s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final PlayerProgressHelper f451082t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public LifecycleOwner f451083u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public IPrepareListener f451084v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ILoopListener f451085w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f451086x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final IMediaPlayer.OnPreparedListener<AbsPlayer<AbsPlayer>> f451087y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final IMediaPlayer.OnErrorListener<AbsPlayer<AbsPlayer>> f451088z;

    /* JADX INFO: renamed from: com.ss.android.ugc.aweme.live.alphaplayer.controller.PlayerController$8, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass8 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f451097a = null;

        static {
            int[] r100 = new int[PlayerState.values().length];
            f451097a = r100;
            r100[PlayerState.PREPARED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f451097a[PlayerState.PAUSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f451097a[PlayerState.NOT_PREPARED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f451097a[PlayerState.STOPPED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public final void i() {
        this.f451064b = false;
        this.f451063a = 0;
        this.f451073k.post(new AnonymousClass1(this));
        this.f451082t.d();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        n(j(6, null));
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void pause() {
        n(j(3, null));
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void release() {
        n(j(6, null));
        LifecycleOwner r100 = this.f451083u;
        if (r100 == null) goto L6;
        r100.getLifecycle().removeObserver(this);
        this.f451083u = null;
        return;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void resume() {
        n(j(4, null));
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void stop() {
        n(j(5, null));
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final int a() {
        if (this.f451071i != null) goto L5;
    L15:
        return -1;
    L5:
        if (this.f451079q == 0) goto L15;
        float r100 = getDuration();
        if (r100 > 0.0f) goto L10;
        return -1;
    L10:
        float r101 = this.f451071i.getCurrentPosition() / r100;
        if (r101 <= 1.0f) goto L14;
        r101 = r101 - ((long) r101);
    L14:
        return (int) Math.ceil(r101 * this.f451079q);
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void cancel() {
        n(j(12, null));
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final int getDuration() {
        IMediaPlayer<AbsPlayer<AbsPlayer>> r100 = this.f451071i;
        if (r100 != null) goto L8;
        return -1;
    L8:
        return r100.getVideoInfo().f451180c;
    L7:
        return -1;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final String getPlayerType() {
        IMediaPlayer<AbsPlayer<AbsPlayer>> r100 = this.f451071i;
        if (r100 != null) goto L7;
        return "unknown";
    L7:
        return r100.c();
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final View getView() {
        IAlphaVideoView r100 = this.f451075m;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getView();
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final boolean isPlaying() {
        IMediaPlayer<AbsPlayer<AbsPlayer>> r100 = this.f451071i;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isPlaying() == false) goto L7;
        return true;
    }

    public final void l() throws Exception {
        if (this.f451078p > 0) goto L5;
        VideoInfo r100 = this.f451071i.getVideoInfo();
        this.f451076n = r100.f451178a / 2;
        this.f451077o = r100.f451179b;
    L5:
        this.f451075m.c(this.f451076n, this.f451077o);
        final DataSource.ScaleType r101 = this.f451075m.getScaleType();
        this.f451073k.post(new AnonymousClass4(this, r101));
    }

    public final void m() {
        IMediaPlayer<AbsPlayer<AbsPlayer>> r100 = this.f451071i;
        if (r100 != null) goto L5;
        return;
    L5:
        PlayerState r101 = this.f451067e;
        if (r101 != PlayerState.NOT_PREPARED) goto L8;
    L9:
        r100.f(this.f451087y);
        this.f451071i.e(this.f451088z);
        this.f451071i.prepareAsync();
        return;
    L8:
        if (r101 == PlayerState.STOPPED) goto L9;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void reset() {
        n(j(9, null));
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void startPlay() {
        Objects.toString(this.f451067e);
        getDuration();
        if (this.f451071i == null) goto L22;
        int r100 = AnonymousClass8.f451097a[this.f451067e.ordinal()];
        if (r100 != 1) goto L7;
        this.f451071i.start();
        this.f451064b = true;
        this.f451067e = PlayerState.STARTED;
        this.f451073k.post(new AnonymousClass7(this));
        this.f451082t.c();
        return;
    L7:
        if (r100 != 2) goto L9;
        this.f451071i.start();
        this.f451067e = PlayerState.STARTED;
        this.f451082t.c();
        return;
    L9:
        if (r100 != 3) goto L11;
    L20:
        m();     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
        k(false, 0, 0, "prepare and start MediaPlayer failure.");
        i();
        return;
    L11:
        if (r100 == 4) goto L20;
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        pause();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        resume();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        stop();
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void attachAlphaView(ViewGroup r100) {
        IAlphaVideoView r101 = this.f451075m;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.d(r100) == false) goto L9;
        this.f451080r = true;
        return;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void c(IMonitor r100) {
        this.f451069g = r100;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void d(DataSource r100) {
        f(r100, false);
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void detachAlphaView(ViewGroup r100) {
        IAlphaVideoView r101 = this.f451075m;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.b(r100) == false) goto L9;
        this.f451080r = false;
        return;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void e(ILoopListener r100) {
        this.f451085w = r100;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final IPlayerController g(AlphaPlayerAction r100) {
        this.f451070h = r100;
        return this;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void h(MaskSrc r100) {
        n(j(11, r100));
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r100) {
        switch(r100.what) {
            case 1: goto L93;
            case 2: goto L110;
            case 3: goto L77;
            case 4: goto L69;
            case 5: goto L61;
            case 6: goto L45;
            case 7: goto L106;
            case 8: goto L103;
            case 9: goto L39;
            case 10: goto L112;
            case 11: goto L10;
            case 12: goto L5;
            default: goto L103;
        };
    L5:
        IMediaPlayer<AbsPlayer<AbsPlayer>> r101 = this.f451071i;
        if (r101 == null) goto L103;
        r101.stop();
        this.f451067e = PlayerState.STOPPED;
        this.f451064b = false;
        this.f451082t.d();
        IAlphaVideoView r102 = this.f451075m;
        if (r102 == null) goto L103;
        r102.onCompletion();
        goto L103
    L10:
        Object r103 = r100.obj;
        if ((r103 instanceof MaskSrc) == false) goto L103;
        MaskSrc r104 = (MaskSrc) r103;
        if (r104.getType() == 0) goto L16;
    L20:
        Bitmap r105 = r104.f451161g;
        if (r105 == null) goto L103;
        if (r104.f451162h == false) goto L25;
        r105.getWidth();
        r104.f451161g.getHeight();
    L25:
        ((ArrayList) this.f451066d).add(r104);
        goto L103
    L16:
        if (TextUtils.isEmpty(r104.f451157c) == true) goto L20;
        r104.f451161g = BitmapUtil.a(r104);     // Catch: Throwable -> L19
        goto L20
    L39:
        IMediaPlayer<AbsPlayer<AbsPlayer>> r106 = this.f451071i;
        if (r106 == null) goto L103;
        r106.reset();
        this.f451082t.d();
        this.f451067e = PlayerState.NOT_PREPARED;
        this.f451064b = false;
        goto L103
    L45:
        this.f451075m.onPause();
        this.f451082t.d();
        PlayerProgressHelper r107 = this.f451082t;
        r107.a();
        PthreadHandlerThreadV2 r108 = r107.f451248e;
        if (r108 == null) goto L48;
        r108.quit();
        r107.f451248e = null;
    L48:
        r107.f451244a = null;
        r107.f451246c = 500;
        r107.f451245b = PlayerProgressHelper.f451243f;
        IMediaPlayer<AbsPlayer<AbsPlayer>> r109 = this.f451071i;
        if (r109 != null) goto L53;
        this.f451067e = PlayerState.NOT_PREPARED;
        return true;
    L53:
        if (this.f451067e != PlayerState.STARTED) goto L56;
        r109.pause();
        this.f451067e = PlayerState.PAUSED;
    L56:
        if (this.f451067e != PlayerState.PAUSED) goto L58;
        this.f451071i.stop();
        this.f451067e = PlayerState.STOPPED;
    L58:
        this.f451071i.release();
        this.f451075m.release();
        this.f451067e = PlayerState.RELEASE;
        PthreadHandlerThreadV2 r110 = this.f451074l;
        if (r110 == null) goto L103;
        r110.quit();
        this.f451074l.interrupt();
        goto L103
    L61:
        IMediaPlayer<AbsPlayer<AbsPlayer>> r111 = this.f451071i;
        if (r111 == null) goto L103;
        PlayerState r112 = this.f451067e;
        if (r112 != PlayerState.STARTED) goto L66;
    L67:
        r111.pause();
        this.f451082t.d();
        this.f451067e = PlayerState.PAUSED;
        goto L103
    L66:
        if (r112 != PlayerState.PAUSED) goto L103;
    L77:
        IMediaPlayer<AbsPlayer<AbsPlayer>> r113 = this.f451071i;
        if (r113 == null) goto L103;
        if (this.f451067e != PlayerState.STARTED) goto L103;
        r113.pause();
        this.f451082t.d();
        this.f451067e = PlayerState.PAUSED;
    L103:
        return true;
    L106:
        this.f451071i.setSurface((Surface) r100.obj);     // Catch: Exception -> L44
    L44:
        i();
        k(false, 0, 0, "surface has been released");
        goto L103
    L110:
        l();     // Catch: Exception -> L90
        this.f451067e = PlayerState.PREPARED;     // Catch: Exception -> L90
        IPrepareListener r114 = this.f451084v;     // Catch: Exception -> L90
        if (r114 == null) goto L85;
        r114.a();     // Catch: Exception -> L90
    L86:
        IPrepareListener r115 = this.f451084v;     // Catch: Exception -> L90
        if (r115 == null) goto L103;
        r115.onPrepared();     // Catch: Exception -> L90
        goto L103
    L85:
        startPlay();     // Catch: Exception -> L90
    L90:
        e = move-exception;
        i();
        k(false, 0, 0, "start video failure:" + Log.getStackTraceString(e));
        goto L103
    L112:
        this.f451071i.b();     // Catch: Exception -> L28
    L38:
        this.f451071i.a();
        this.f451071i.setLooping(this.f451086x);
        this.f451071i.d(new AnonymousClass2(this));
        this.f451071i.g(new AnonymousClass3(this));
    L28:
        e = move-exception;
        IMonitor r116 = this.f451069g;
        if (r116 == null) goto L37;
        IMediaPlayer<AbsPlayer<AbsPlayer>> r117 = this.f451071i;
        if (r117 == null) goto L35;
        String r118 = r117.c();
    L36:
        r116.a(r118, e);
        goto L37
    L35:
        r118 = "unknown";
    L37:
        DefaultSystemPlayer r119 = new DefaultSystemPlayer();
        r119.b();
        this.f451071i = r119;
        this.f451082t.f451244a = r119;
        goto L38
    L69:
        if (this.f451064b == false) goto L72;
        startPlay();
        goto L103
    L72:
        if (this.f451065c == false) goto L103;
        m();     // Catch: Exception -> L75
        this.f451065c = false;     // Catch: Exception -> L75
    L75:
        e = move-exception;
        e.printStackTrace();
        k(false, 0, 0, "RESUME: prepare and start MediaPlayer failure.");
        i();
        goto L103
    L93:
        if ((r100.obj instanceof DataSource) == false) goto L103;
        Handler r120 = this.f451072j;
        if (r120 == null) goto L104;
        r120.removeMessages(8);
    L104:
        p((DataSource) r100.obj);     // Catch: Exception -> L101
    L101:
        e = move-exception;
        e.printStackTrace();
        i();
        k(false, 0, 0, "alphaVideoView set dataSource failure:" + Log.getStackTraceString(e));
        goto L103
    }

    public final void n(Message r100) {
        PthreadHandlerThreadV2 r101 = this.f451074l;
        if (r101 != null) goto L5;
        return;
    L5:
        if (ThreadMethodProxy.isAlive(r101) == true) goto L7;
        return;
    L7:
        if (this.f451074l.isInterrupted() == false) goto L9;
        return;
    L9:
        if (this.f451072j != null) goto L11;
        this.f451072j = new Handler(this.f451074l.getLooper(), this);
    L11:
        this.f451072j.sendMessageDelayed(r100, 0);
    }

    public final void o(IPlayerController.OnElementClickListener r100) {
        this.f451075m.setOnElementClickListener(r100);
    }

    public final void p(DataSource r100) throws Exception {
        if (this.f451080r == true) goto L6;
        k(false, 0, 0, "alphaVideoView is not attach");
        i();
        return;
    L6:
        this.f451071i.reset();
        this.f451067e = PlayerState.NOT_PREPARED;
        int r101 = this.f451068f.getResources().getConfiguration().orientation;
        if (1 != r101) goto L9;
        DataSource.DataInfo r102 = r100.f451125b;
    L10:
        if (r102 != null) goto L12;
    L21:
        if (1 != r101) goto L27;
        StringBuilder r103 = new StringBuilder("dataPath is empty or File is not exists. path: ");
        if (r102 != null) goto L25;
        String r104 = "null";
    L26:
        r103.append(r104);
        k(false, 0, 0, r103.toString());
        goto L27
    L25:
        r104 = r102.f451135a;
    L27:
        i();
        return;
    L12:
        if (TextUtils.isEmpty(r102.f451135a) == true) goto L21;
        if (new PolarisFileWrapper(r102.f451135a).exists() == false) goto L21;
        this.f451075m.setConfigParams(r102);
        this.f451075m.e(this.f451066d);
        this.f451071i.setDataSource(r102.f451135a);
        boolean r105 = r100.f451127d;
        this.f451086x = r105;
        this.f451071i.setLooping(r105);
        this.f451079q = r102.f451137c;
        this.f451076n = r102.f451142h;
        this.f451077o = r102.f451143i;
        this.f451078p = r102.f451144j;
        this.f451081s = r100.f451130g;
        if (this.f451075m.a() == false) goto L19;
        m();
        return;
    L19:
        this.f451065c = true;
        return;
    L9:
        r102 = r100.f451126c;
        goto L10
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void setSurface(Surface r100) {
        n(j(7, r100));
    }

    public PlayerController(Configuration r100, AbsPlayer r101) {
        this.f451064b = false;
        this.f451065c = false;
        this.f451066d = new ArrayList();
        this.f451067e = PlayerState.NOT_PREPARED;
        this.f451073k = new Handler(Looper.getMainLooper());
        this.f451076n = 0;
        this.f451077o = 0;
        this.f451078p = 0;
        this.f451079q = 0;
        this.f451080r = false;
        this.f451081s = true;
        PlayerProgressHelper r102 = new PlayerProgressHelper();
        this.f451082t = r102;
        this.f451083u = null;
        this.f451087y = new AnonymousClass5(this);
        this.f451088z = new AnonymousClass6(this);
        Context r103 = r100.getContext();
        LifecycleOwner r104 = r100.f451008b;
        String r105 = r100.f451010d;
        this.f451068f = r103;
        this.f451083u = r104;
        if (r104 == null) goto L5;
        r104.getLifecycle().addObserver(this);
    L5:
        PthreadHandlerThreadV2 r106 = new PthreadHandlerThreadV2(r105, 10);
        this.f451074l = r106;
        ThreadMethodProxy.start(r106);
        this.f451072j = new Handler(this.f451074l.getLooper(), this);
        int r107 = r100.f451009c;
        boolean r108 = r100.f451011e;
        boolean r109 = r100.f451012f;
        if (r107 != 1) goto L8;
        this.f451075m = new AlphaVideoTextureView(this.f451068f, null);
    L9:
        ViewGroup.LayoutParams r110 = new ViewGroup.LayoutParams(-1, -1);
        this.f451075m.setLayoutParams(r110);
        this.f451075m.setPlayerController(this);
        IAlphaVideoView r111 = this.f451075m;
        r111.setVideoRenderer(new VideoRenderer(r111, r108));
        this.f451075m.setEnableElementEvent(r109);
        if (r101 != null) goto L12;
        this.f451071i = new DefaultSystemPlayer();
    L13:
        r102.f451244a = this.f451071i;
        n(j(10, null));
        return;
    L12:
        this.f451071i = r101;
        goto L13
    L8:
        this.f451075m = new AlphaVideoSurfaceView(this.f451068f, null);
        goto L9
    }

    public static Message j(int r100, Object r101) {
        Message r102 = Message.obtain();
        r102.what = r100;
        r102.obj = r101;
        return r102;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void b(IProgressListener r100, long r101) {
        PlayerProgressHelper r102 = this.f451082t;
        if (r100 == null) goto L5;
        r102.f451245b = r100;
    L6:
        r102.f451246c = r101;
        return;
    L5:
        r102.f451245b = PlayerProgressHelper.f451243f;
        goto L6
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void f(DataSource r100, boolean r101) {
        this.f451075m.setLastFrameHold(r101);
        if (r100 != null) goto L5;
        DataSource r102 = null;
    L6:
        this.f451063a = r100.f451129f;
        if (r100.f451124a == false) goto L9;
        this.f451075m.setVisibility(0);
        this.f451075m.bringToFront();
        n(j(1, r102));
        return;
    L9:
        i();
        k(false, 0, 0, "dataSource is invalid. ErrorInfo: " + r102.f451128e);
        return;
    L5:
        r102 = new DataSource();
        r102.f451125b = DataSource.DataInfo.a(r100.f451125b);
        r102.a();
        r102.f451126c = DataSource.DataInfo.a(r100.f451126c);
        r102.a();
        r102.f451127d = r100.f451127d;
        r102.f451130g = r100.f451130g;
        r102.f451129f = r100.f451129f;
        r102.f451124a = r100.f451124a;
        r102.f451128e = r100.f451128e;
        goto L6
    }

    public final void k(boolean r100, int r101, int r102, String r110) {
        IMonitor r103 = this.f451069g;
        if (r103 != null) goto L5;
        return;
    L5:
        IMediaPlayer<AbsPlayer<AbsPlayer>> r104 = this.f451071i;
        if (r104 == null) goto L8;
        String r105 = r104.c();
    L9:
        r103.monitor(r100, r105, r101, r102, r110 + ", messageId: " + this.f451063a);
        return;
    L8:
        r105 = "unknown";
        goto L9
    }
}
