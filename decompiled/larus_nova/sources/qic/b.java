package qic;

import android.graphics.Bitmap;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.videoshop.controller.AsyncVideoMsg;
import com.ss.android.videoshop.log.VideoTraceState;
import com.ss.android.videoshop.log.VideoTracer;
import com.ss.android.videoshop.log.tracer.LogTracer;
import com.ss.android.videoshop.log.tracer.PathID;
import com.ss.texturerender.VideoSurface;
import com.ss.ttm.player.PlaybackParams;
import com.ss.ttvideoengine.DataSource;
import com.ss.ttvideoengine.MaskInfoListener;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.SeekCompletionListener;
import com.ss.ttvideoengine.StreamInfoListener;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineInfoListener;
import com.ss.ttvideoengine.VideoEngineInfos;
import com.ss.ttvideoengine.VideoEngineSimpleCallback;
import com.ss.ttvideoengine.VideoInfoListener;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.model.VideoRef;
import com.ss.ttvideoengine.net.TTVNetClient;
import com.ss.ttvideoengine.utils.Error;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import nic.j;
import nic.k;
import nic.l;
import nic.o;
import nic.p;

/* JADX INFO: loaded from: classes40.dex */
public final class b extends VideoEngineSimpleCallback implements qic.a, VideoInfoListener, VideoEngineInfoListener, StreamInfoListener {
    public Error A;
    public boolean B;
    public int C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f533224J;
    public String K;
    public final f L;
    public PlaybackParams M;
    public VideoModel N;
    public final Map<String, VideoEngineInfos> O;
    public boolean P;
    public Resolution Q;
    public fjc.b R;
    public final g S;
    public final ric.a T;
    public long U;
    public boolean V;
    public final a W;
    public final C7333b X;
    public final WeakHandler Y;
    public final c Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Surface f533225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SurfaceHolder f533226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TTVideoEngine f533227c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public tic.a f533228d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f533229e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TTVNetClient f533230f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f533231g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f533232h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f533233i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f533234j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f533235k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public l f533236l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public j f533237m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f533238n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public oic.f f533239o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public nic.f f533240p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Resolution f533241q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Resolution f533242r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final nic.e f533243s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f533244t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f533245u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public SparseArray<VideoInfo> f533246v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public List<VideoInfo> f533247w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f533248x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f533249y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f533250z;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f533251a;

        public final void a() {
            if (this.f533251a.V == false) goto L5;
            this.f533251a.f533228d.getClass();
            ajc.b.a("VideoController", "playRunnable videoEngine:" + this.f533251a.f533227c + ", vid:" + this.f533251a.f533228d.f546363a + ", hashCode:" + this.f533251a.hashCode() + ", title:null");
        L6:
            this.f533251a.I();
            return;
        L5:
            this.f533251a.f533228d.getClass();
            ajc.b.a("VideoController", "playRunnable videoEngine:" + this.f533251a.f533227c + ", vid:" + this.f533251a.f533228d.f546363a + ", hashCode:" + this.f533251a.hashCode() + ", thread:" + ThreadMethodProxy.currentThread() + " title:null");
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(b r100) {
            this.f533251a = r100;
        }
    }

    /* JADX INFO: renamed from: qic.b$b, reason: collision with other inner class name */
    public class C7333b implements WeakHandler.IHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f533252a;

        public C7333b(b r100) {
            this.f533252a = r100;
        }

        @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
        public final void handleMsg(Message r100) {
            boolean r101 = true;
            if (e.f533257a[AsyncVideoMsg.getMsg(r100.what).ordinal()] != 1) goto L46;
            b r102 = this.f533252a;
            tic.a r103 = r102.f533228d;
            if (r103 == null) goto L8;
            ejc.b r104 = r103.f546377o;
        L9:
            if (r104 == null) goto L12;
            int r105 = r104.f472901c;
            if (r105 <= 0) goto L12;
        L14:
            if (r102.f533227c == null) goto L39;
            Object r106 = r100.obj;
            if (r106 != null) goto L18;
        L20:
            r101 = false;
        L21:
            int r107 = this.f533252a.getCurrentPosition();
            int r108 = this.f533252a.f533227c.getDuration();
            if (r107 < r108) goto L24;
            r107 = r108;
        L24:
            if (r108 <= 0) goto L30;
            if (r101 == false) goto L27;
            if (r107 >= r105) goto L30;
        L27:
            b r109 = this.f533252a;
            l r110 = r109.f533236l;
            if (r110 == null) goto L30;
            r110.q(r109.f533239o, r109.f533228d, r107, r108);
        L30:
            b r111 = this.f533252a;
            if (r111.f533238n == true) goto L39;
            if (r107 <= 0) goto L39;
            tic.a r112 = r111.f533228d;
            if (r112 == null) goto L39;
            if (TextUtils.isEmpty(r112.f546363a) == true) goto L39;
            djc.a.a(this.f533252a.f533228d.f546363a, r107);
            goto L39
        L18:
            if (((Boolean) r106).booleanValue() == false) goto L20;
        L39:
            if (this.f533252a.k() == false) goto L41;
            return;
        L41:
            if (this.f533252a.isPlaying() == false) goto L45;
            this.f533252a.Y.sendMessageDelayed(this.f533252a.Y.obtainMessage(AsyncVideoMsg.UPDATE_PROGRESS.getWhat()), r105);
            return;
        L45:
            return;
        L12:
            r105 = 500;
            goto L14
        L8:
            r104 = null;
            goto L9
        }
    }

    public class c implements SeekCompletionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f533253a;

        public c(b r100) {
            this.f533253a = r100;
        }

        @Override // com.ss.ttvideoengine.SeekCompletionListener
        public final void onCompletion(boolean r110) {
            b r100 = this.f533253a;
            r100.getClass();
            if (r110 == false) goto L5;
            String r101 = "done";
        L6:
            ajc.b.a("VideoController", "seek_complete:".concat(r101));
            VideoTracer.INS.trace(r100.f533228d, VideoTraceState.CONTROLLER_SEEK_COMPLETE, null, null, r100.f533239o);
            LogTracer.INS.addTrace(r100.f533228d, bjc.b.b("VCOnSeekComplete", PathID.SEEK, 6));
            if (r100.k() == false) goto L9;
        L17:
            l r102 = r100.f533236l;
            if (r102 == null) goto L21;
            r102.x(r100.f533239o, r100.f533228d, r110);
            return;
        L21:
            return;
        L9:
            if (r100.isPlaying() == false) goto L17;
            if (r100.B == true) goto L13;
        L14:
            WeakHandler r103 = r100.Y;
            if (r103 == null) goto L17;
            r103.sendEmptyMessage(AsyncVideoMsg.UPDATE_PROGRESS.getWhat());
            goto L17
        L13:
            if (r100.f533233i == false) goto L17;
        L5:
            r101 = "fail";
            goto L6
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f533254a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f533255b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f533256c;

        @Override // java.lang.Runnable
        public final void run() {
            b r100 = this.f533256c;     // Catch: Throwable -> L6
            l r101 = r100.f533236l;     // Catch: Throwable -> L6
            if (r101 == null) goto L9;
            r101.b0(r100.f533239o, r100.f533228d, this.f533254a, this.f533255b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public d(b r100, int r101, Map r102) {
            this.f533256c = r100;
            this.f533254a = r101;
            this.f533255b = r102;
        }
    }

    public static /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f533257a = null;

        static {
            int[] r100 = new int[AsyncVideoMsg.values().length];
            f533257a = r100;
            r100[AsyncVideoMsg.UPDATE_PROGRESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
            return;
        }
    }

    public static class f implements DataSource {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public nic.c f533258a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public tic.a f533259b;

        public f() {
        }

        @Override // com.ss.ttvideoengine.DataSource
        public final String apiForFetcher(Map<String, String> r100, int r101) {
            nic.c r102 = this.f533258a;
            if (r102 != null) goto L5;
            return null;
        L5:
            return r102.a(this.f533259b, r100, r101);
        }
    }

    public static class g implements MaskInfoListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<b> f533260a;

        public g(b r100) {
            this.f533260a = new WeakReference(r100);
        }

        @Override // com.ss.ttvideoengine.MaskInfoListener
        public final void onMaskInfoCallback(int r100, int r101, String r102) {
            WeakReference<b> r103 = this.f533260a;
            if (r103 == null) goto L10;
            b r104 = r103.get();
            if (r104 == null) goto L11;
            l r105 = r104.f533236l;
            if (r105 == null) goto L12;
            r105.T(r104.f533239o, r104.f533228d, r101, r102);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public final void G() {
        this.f533238n = false;
        this.f533250z = false;
        this.P = false;
        this.Q = null;
        this.f533241q = null;
        this.f533248x = 0;
        ((HashMap) this.O).clear();
        this.H = false;
        boolean r100 = this.f533240p instanceof nic.g;
        TTVideoEngine r101 = this.f533227c;
        if (r101 == null) goto L18;
        int r102 = this.f533229e;
        if (r102 != 0) goto L7;
    L10:
        r101.setSurface(null);
    L11:
        if (r100 == false) goto L14;
        ((nic.g) this.f533240p).c();
    L14:
        if (this.f533235k == false) goto L16;
        this.f533227c.releaseAsync();
    L17:
        C(this.f533227c);
        goto L18
    L16:
        this.f533227c.release();
        goto L17
    L7:
        if (r102 == 2) goto L10;
        r101.setSurfaceHolder(null);
    L18:
        LogTracer.INS.addTrace(this.f533228d, bjc.b.b("CreateEngine", PathID.PLAY, 0));
        if (r100 == false) goto L24;
        nic.g r103 = (nic.g) this.f533240p;
        if (r103.c() == (-1)) goto L23;
        r103.d();
        r103.e();
        r103.c();
    L23:
        new TTVideoEngine(o.f519408a, r103.d(), r103.e());
        this.f533227c = ((nic.g) this.f533240p).a();
    L25:
        TTVideoEngine r104 = this.f533227c;
        if (r104 == null) goto L33;
        TTVNetClient r105 = this.f533230f;
        if (r105 == null) goto L30;
        r104.setNetworkClient(r105);
    L30:
        this.f533227c.setVideoEngineSimpleCallback(this);
        this.f533227c.setMaskInfoListener(this.S);
        this.f533227c.setSubInfoCallBack(this.T);
        this.f533227c.setVideoInfoListener(this);
        this.f533227c.setStreamInfoListener(this);
        this.f533227c.setVideoEngineInfoListener(this);
        VideoTracer.INS.trace(this.f533228d, VideoTraceState.CONTROLLER_CREATE_ENGINE, null, null, this.f533239o);
        return;
    L33:
        throw new NullPointerException("video engine can't be null");
    L24:
        this.f533227c = this.f533240p.b(o.f519408a, this.f533228d, this.f533243s);
        goto L25
    }

    public final void D() {
        this.f533239o = new oic.f(this, this.f533243s);
        this.f533240p = new oic.d();
        this.f533237m = new oic.e();
        this.R = new fjc.b();
    }

    public final void E() {
        WeakHandler r100 = this.Y;
        if (r100 == null) goto L6;
        r100.removeMessages(AsyncVideoMsg.UPDATE_PROGRESS.getWhat());
        return;
    }

    public final void F() {
        if (this.f533250z == true) goto L5;
        return;
    L5:
        if (this.f533227c == null) goto L20;
        Error r100 = this.A;
        if (r100 == null) goto L20;
        int r101 = r100.internalCode;
        if (r101 == 10408) goto L20;
        if (r101 == 50401) goto L20;
        LogTracer.INS.addTrace(this.f533228d, bjc.b.b("VCErrRelease", PathID.PLAY, 0));
        nic.f r102 = this.f533240p;
        if ((r102 instanceof nic.g) == false) goto L16;
        ((nic.g) r102).c();
    L16:
        if (this.f533235k == false) goto L18;
        this.f533227c.releaseAsync();
    L19:
        C(this.f533227c);
        this.f533227c = null;
        VideoTracer.INS.trace(this.f533228d, VideoTraceState.CONTROLLER_RELEASE_ENGINE_WHEN_ERR, null, this.A, this.f533239o);
        goto L20
    L18:
        this.f533227c.release();
    L20:
        this.A = null;
    }

    public final void H() {
        LogTracer.INS.addTrace(this.f533228d, bjc.b.b("VCSetEngineParams", PathID.PLAY, 0));
        if (this.V == false) goto L5;
        ajc.b.a("VideoController", "videoEngine setPlayAPIVersion. videoEngine:" + this.f533227c + ", vid:" + this.f533228d.f546363a + ", hashCode:" + hashCode());
    L6:
        this.f533228d.getClass();
        this.f533228d.getClass();
        if (TextUtils.isEmpty(null) == true) goto L9;
        TTVideoEngine r100 = this.f533227c;
        this.f533228d.getClass();
        r100.setPlayAPIVersion(1, null);
    L11:
        if (TextUtils.isEmpty(this.f533228d.f546373k) == false) goto L13;
        this.f533227c.setTag("");
    L15:
        if (TextUtils.isEmpty(this.f533228d.f546374l) == false) goto L17;
        this.f533227c.setSubTag("");
    L18:
        this.f533228d.getClass();
        this.f533227c.setDataSource(this.L);
        if (TextUtils.isEmpty(this.f533228d.f546372j) == true) goto L21;
        this.f533227c.setEncodedKey(this.f533228d.f546372j);
    L22:
        this.f533228d.getClass();
        if (TextUtils.isEmpty(null) == true) goto L25;
        TTVideoEngine r101 = this.f533227c;
        this.f533228d.getClass();
        r101.setDecryptionKey(null);
    L26:
        PlaybackParams r102 = this.M;
        if (r102 == null) goto L30;
        this.f533227c.setPlaybackParams(r102);
        return;
    L30:
        return;
    L25:
        this.f533227c.setDecryptionKey("");
        goto L26
    L21:
        this.f533227c.setEncodedKey("");
        goto L22
    L17:
        this.f533227c.setSubTag(this.f533228d.f546374l);
        goto L18
    L13:
        this.f533227c.setTag(this.f533228d.f546373k);
        goto L15
    L9:
        this.f533227c.setPlayAPIVersion(0, "");
        goto L11
    L5:
        ajc.b.a("VideoController", "videoEngine setPlayAPIVersion. videoEngine:" + this.f533227c + ", vid:" + this.f533228d.f546363a + ", hashCode:" + hashCode() + ", thread:" + ThreadMethodProxy.currentThread());
        goto L6
    }

    public final void I() {
        VideoTracer r100 = VideoTracer.INS;
        r100.trace(this.f533228d, VideoTraceState.CONTROLLER_SET_PARAMS_AND_PLAY, null, null, this.f533239o);
        H();
        l r101 = this.f533236l;
        if (r101 != null) goto L5;
    L12:
        int r102 = this.f533229e;
        if (r102 != 0) goto L15;
        this.f533227c.setSurface(this.f533225a);
    L18:
        this.U = -1;
        this.f533250z = false;
        if (this.f533227c == null) goto L65;
    L61:
        e = move-exception;
        Logger.throwException(e);
        return;
    L22:
        if (this.f533249y == false) goto L33;
        if (this.f533246v == null) goto L26;
    L27:
        j r103 = this.f533237m;     // Catch: Exception -> L61
        if (r103 == null) goto L33;
        if (r103.interceptPlay(NetworkUtils.getNetworkTypeFast(o.f519408a)) == false) goto L33;
        ajc.b.a("VideoController", "intercept play");     // Catch: Exception -> L61
        r100.trace(this.f533228d, VideoTraceState.CONTROLLER_INTERCEPT_DO_PLAY, null, null, this.f533239o);     // Catch: Exception -> L61
        return;
    L26:
        if (this.f533247w != null) goto L27;
    L33:
        if (k() == false) goto L36;
        this.f533224J = 3;     // Catch: Exception -> L61
        String r104 = "replay";
    L45:
        ajc.b.a("VideoController", "doPlay mute:" + this.f533232h);     // Catch: Exception -> L61
        this.f533227c.setIsMute(this.f533232h);     // Catch: Exception -> L61
        setRenderMode(this.f533231g);     // Catch: Exception -> L61
        this.f533227c.setLooping(this.f533233i);     // Catch: Exception -> L61
        this.f533238n = false;     // Catch: Exception -> L61
        if (this.V == true) goto L49;
        ajc.b.a("VideoController", "play volume:" + this.f533227c.getVolume() + " max volume:" + this.f533227c.getMaxVolume());     // Catch: Exception -> L61
    L49:
        if (this.G == false) goto L51;
        this.f533227c.setIntOption(100, 1);     // Catch: Exception -> L61
    L51:
        bjc.b r105 = bjc.b.b("EnginePlay", PathID.PLAY, 6);     // Catch: Exception -> L61
        if (r105 == null) goto L54;
        r105.a("type", r104);     // Catch: Exception -> L61
        LogTracer.INS.addTrace(this.f533228d, r105);     // Catch: Exception -> L61
    L54:
        this.f533227c.play();     // Catch: Exception -> L61
        l r106 = this.f533236l;     // Catch: Exception -> L61
        if (r106 != null) goto L57;
    L59:
        r100.trace(this.f533228d, VideoTraceState.CONTROLLER_DO_ENGINE_PLAY, null, null, this.f533239o);     // Catch: Exception -> L61
        return;
    L57:
        if (this.I == true) goto L59;
        r106.f(this.f533239o, this.f533228d, this.f533224J);     // Catch: Exception -> L61
        goto L59
    L36:
        if (isPaused() == false) goto L39;
        this.f533224J = 2;     // Catch: Exception -> L61
        r104 = "pause2play";
        goto L45
    L39:
        if (this.I == false) goto L42;
        this.f533224J = 5;     // Catch: Exception -> L61
        r104 = "preparing2play";
        goto L45
    L42:
        if (this.H == false) goto L44;
        this.f533224J = 4;     // Catch: Exception -> L61
        r104 = "prepared2play";
        goto L45
    L44:
        this.f533224J = 1;     // Catch: Exception -> L61
        r104 = "release2play";
        goto L45
    L65:
        return;
    L15:
        if (r102 != 2) goto L17;
        this.f533227c.setSurfaceSync(this.f533225a);
        goto L18
    L17:
        this.f533227c.setSurfaceHolder(this.f533226b);
        goto L18
    L5:
        if (this.I == true) goto L12;
        if (this.f533250z == false) goto L10;
        r101.y(this.f533239o, this.f533228d);
        goto L12
    L10:
        if (k() == false) goto L12;
        this.f533236l.h(this.f533239o, this.f533228d);
        goto L12
    }

    @Override // qic.a
    public final VideoInfo b() {
        TTVideoEngine r100 = this.f533227c;
        if (r100 != null) goto L5;
    L14:
        Resolution r101 = this.f533241q;
        if (r101 != Resolution.Auto) goto L25;
        TTVideoEngine r102 = this.f533227c;
        if (r102 == null) goto L23;
        Resolution r103 = r102.getCurrentResolution();
        if (r103 == null) goto L23;
        if (this.Q == r103) goto L23;
        this.Q = r103;
    L23:
        r101 = this.Q;
    L25:
        if (this.f533246v == null) goto L46;
        if (r101 == null) goto L60;
        int r104 = 0;
        int r105 = 0;
    L29:
        if (r105 >= this.f533246v.size()) goto L39;
        VideoInfo r106 = this.f533246v.valueAt(r105);
        if (r106 == null) goto L37;
        if (r106.getResolution() != r101) goto L37;
        if (r106.getMediatype() != VideoRef.TYPE_VIDEO) goto L37;
        return r106;
    L37:
        r105 = r105 + 1;
    L39:
        if (r104 >= this.f533246v.size()) goto L61;
        VideoInfo r107 = this.f533246v.valueAt(r104);
        if (r107 == null) goto L45;
        if (r107.getResolution() != r101) goto L45;
        return r107;
    L45:
        r104 = r104 + 1;
        goto L39
    L61:
        return null;
    L60:
        return null;
    L46:
        return null;
    L5:
        if (TextUtils.isEmpty(r100.getCurrentQualityDesc()) == true) goto L14;
        if (this.f533247w == null) goto L14;
        String r108 = this.f533227c.getCurrentQualityDesc();
        Iterator<VideoInfo> r109 = this.f533247w.iterator();
    L10:
        if (r109.hasNext() == false) goto L14;
        VideoInfo r110 = r109.next();
        if (r108.equals(r110.getValueStr(32)) == false) goto L10;
        return r110;
    }

    @Override // qic.a
    public final int getCurrentPosition() {
        return p(this.f533234j);
    }

    @Override // qic.a
    public final int getDuration() {
        TTVideoEngine r100 = this.f533227c;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getDuration();
    }

    @Override // qic.a
    public final int getWatchedDuration() {
        TTVideoEngine r100 = this.f533227c;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getWatchedDuration();
    }

    @Override // qic.a
    public final boolean isPaused() {
        TTVideoEngine r100 = this.f533227c;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.getPlaybackState() != 2) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // qic.a
    public final boolean isPlaying() {
        TTVideoEngine r100 = this.f533227c;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.getPlaybackState() != 1) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // qic.a
    public final boolean isReleased() {
        if (this.f533227c != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // qic.a
    public final boolean isShouldPlay() {
        TTVideoEngine r100 = this.f533227c;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isShouldPlay() == false) goto L7;
        return true;
    }

    @Override // qic.a
    public final boolean isStarted() {
        TTVideoEngine r100 = this.f533227c;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.isStarted();
    }

    @Override // qic.a
    public final boolean k() {
        if (this.f533227c != null) goto L5;
    L7:
        return false;
    L5:
        if (this.f533238n == false) goto L7;
        return true;
    }

    @Override // qic.a
    public final void pause() {
        StringBuilder r100 = new StringBuilder("pause_video vid:");
        tic.a r101 = this.f533228d;
        String r102 = "entity null";
        if (r101 == null) goto L5;
        String r103 = r101.f546363a;
    L6:
        r100.append(r103);
        r100.append(" hashCode:");
        r100.append(hashCode());
        r100.append(" title:");
        if (this.f533228d == null) goto L9;
        r102 = null;
    L9:
        r100.append(r102);
        ajc.b.a("VideoController", r100.toString());
        VideoTracer.INS.trace(this.f533228d, VideoTraceState.CONTROLLER_PAUSE, null, null, this.f533239o);
        LogTracer.INS.addTrace(this.f533228d, bjc.b.b("VCPause", PathID.PLAY, 6));
        TTVideoEngine r104 = this.f533227c;
        if (r104 == null) goto L12;
        r104.pause();
    L12:
        E();
        this.R.a();
        return;
    L5:
        r103 = "entity null";
        goto L6
    }

    @Override // qic.a
    public final void play() {
        if (this.f533228d != null) goto L7;
        ajc.b.b("VideoController", "playEntity can't be null when play");
        return;
    L7:
        if (this.V == false) goto L9;
        this.f533228d.getClass();
        ajc.b.a("VideoController", "play videoEngine:" + this.f533227c + ", vid:" + this.f533228d.f546363a + ", hashCode:" + hashCode() + ", title:null");
    L10:
        VideoTracer r100 = VideoTracer.INS;
        r100.trace(this.f533228d, VideoTraceState.CONTROLLER_PLAY, null, null, this.f533239o);
        this.C = 0;
        F();
        if (this.f533227c != null) goto L13;
        G();
        boolean r101 = true;
    L14:
        bjc.b r102 = bjc.b.b("VCPlay", PathID.PLAY, 6);
        if (r102 == null) goto L18;
        LogTracer.INS.addTrace(this.f533228d, r102);
    L18:
        if (r101 == false) goto L28;
        if (r102 == null) goto L21;
        r102.a("type", "init");
    L21:
        boolean r103 = J(0);
        l r104 = this.f533236l;
        if (r104 == null) goto L24;
        r104.e0(this.f533239o, this.f533228d);
    L24:
        if (r103 == true) goto L26;
        I();
    L71:
        this.F = true;
        return;
    L26:
        r100.trace(this.f533228d, VideoTraceState.CONTROLLER_INTERCEPT_INIT_PLAY, null, null, this.f533239o);
        goto L71
    L28:
        if (this.G == false) goto L68;
        this.f533228d.getClass();
        ajc.b.a("VideoController", "prepareCalled play:" + this.f533228d.f546363a + " title:null");
        if (this.F == true) goto L46;
        if (this.f533249y == false) goto L38;
        j r105 = this.f533237m;
        if (r105 == null) goto L38;
        VideoModel r106 = this.N;
        if (r106 == null) goto L38;
        boolean r107 = r105.interceptPlayWhenVideoInfoReady(r106.getVideoRef());
    L39:
        l r108 = this.f533236l;
        if (r108 == null) goto L42;
        r108.d(this.f533239o, this.f533228d, r107);
        this.f533236l.e0(this.f533239o, this.f533228d);
    L42:
        if (r107 == false) goto L46;
        this.F = true;
        r100.trace(this.f533228d, VideoTraceState.CONTROLLER_INTERCEPT_PREPARE_PLAY, null, null, this.f533239o);
        return;
    L38:
        r107 = false;
    L46:
        if (this.H == false) goto L54;
        if (r102 == null) goto L49;
        r102.a("type", "prepared");
    L49:
        this.f533228d.getClass();
        ajc.b.a("VideoController", "prepared play:" + this.f533228d.f546363a + " title:null");
        this.I = false;
        I();
        if (this.F == true) goto L71;
        l r109 = this.f533236l;
        if (r109 == null) goto L71;
        r109.L(this.f533239o, this.f533228d);
        goto L71
    L54:
        if (r102 == null) goto L56;
        r102.a("type", "preparing");
    L56:
        this.I = true;
        this.f533228d.getClass();
        ajc.b.a("VideoController", "preparing play:" + this.f533228d.f546363a + " title:null");
        l r110 = this.f533236l;
        if (r110 != null) goto L59;
    L64:
        this.f533224J = 5;
        l r111 = this.f533236l;
        if (r111 == null) goto L67;
        r111.f(this.f533239o, this.f533228d, 5);
    L67:
        this.W.run();
        goto L71
    L59:
        if (this.f533250z == false) goto L62;
        r110.y(this.f533239o, this.f533228d);
        goto L64
    L62:
        if (k() == false) goto L64;
        this.f533236l.h(this.f533239o, this.f533228d);
        goto L64
    L68:
        if (r102 == null) goto L70;
        r102.a("type", "paused");
    L70:
        this.f533228d.getClass();
        ajc.b.a("VideoController", "pause play:" + this.f533228d.f546363a + " title:null");
        I();
        goto L71
    L13:
        r101 = false;
        goto L14
    L9:
        this.f533228d.getClass();
        ajc.b.a("VideoController", "play videoEngine:" + this.f533227c + ", vid:" + this.f533228d.f546363a + ", hashCode:" + hashCode() + ", thread:" + ThreadMethodProxy.currentThread() + " title:null");
        goto L10
    }

    @Override // qic.a
    public final void prepare() {
        if (this.f533228d != null) goto L7;
        ajc.b.b("VideoController", "playEntity can't be null when prepare");
        return;
    L7:
        if (this.F == false) goto L9;
        return;
    L9:
        if (this.G == false) goto L12;
        return;
    L12:
        if (this.V == false) goto L14;
        this.f533228d.getClass();
        ajc.b.a("VideoController", "prepare videoEngine:" + this.f533227c + ", vid:" + this.f533228d.f546363a + ", hashCode:" + hashCode() + ", title:null");
    L15:
        VideoTracer r100 = VideoTracer.INS;
        r100.trace(this.f533228d, VideoTraceState.CONTROLLER_PREPARE, null, null, this.f533239o);
        F();
        if (this.f533227c != null) goto L18;
        G();
        boolean r101 = true;
    L19:
        if (r101 == false) goto L21;
        J(1);
    L21:
        H();
        int r102 = this.f533229e;
        if (r102 != 0) goto L25;
        this.f533227c.setSurface(this.f533225a);
    L28:
        this.U = -1;
        this.f533250z = false;
        if (this.f533227c == null) goto L33;
        LogTracer.INS.addTrace(this.f533228d, bjc.b.b("VCPrepare", PathID.PLAY, 6));
        this.G = true;
        this.f533227c.prepare();
        r100.trace(this.f533228d, VideoTraceState.CONTROLLER_ENGINE_PREPARE, null, null, this.f533239o);
        return;
    L33:
        return;
    L25:
        if (r102 != 2) goto L27;
        this.f533227c.setSurfaceSync(this.f533225a);
        goto L28
    L27:
        this.f533227c.setSurfaceHolder(null);
        goto L28
    L18:
        r101 = false;
        goto L19
    L14:
        this.f533228d.getClass();
        ajc.b.a("VideoController", "prepare videoEngine:" + this.f533227c + ", vid:" + this.f533228d.f546363a + ", hashCode:" + hashCode() + ", thread:" + ThreadMethodProxy.currentThread() + " title:null");
        goto L15
    }

    @Override // qic.a
    public final void u() {
        TTVideoEngine r100 = this.f533227c;
        if (r100 == null) goto L6;
        r100.setSurfaceSync(null);
        return;
    }

    @Override // qic.a
    public final qic.d z() {
        qic.d r100 = new qic.d();
        r100.f533261a = this.f533227c;
        r100.f533262b = this.f533238n;
        r100.f533263c = this.f533228d;
        Resolution r101 = this.f533241q;
        r100.f533264d = r101;
        r100.f533265e = this.f533248x;
        r100.f533266f = this.M;
        SparseArray<VideoInfo> r102 = this.f533246v;
        r100.f533267g = r102;
        if (r102 == null) goto L6;
        if (r101 == null) goto L6;
        VideoInfo r103 = r102.get(r101.getIndex());
    L6:
        r100.f533268h = this.f533233i;
        r100.f533271k = this.f533235k;
        return r100;
    }

    public b() {
        this.f533231g = 0;
        this.f533244t = true;
        this.B = false;
        this.C = 0;
        this.D = true;
        this.E = true;
        this.K = "";
        this.L = new f();
        this.O = new HashMap();
        this.S = new g(this);
        this.T = new ric.a(this);
        this.U = -1;
        this.V = false;
        this.W = new a(this);
        this.X = new C7333b(this);
        this.Y = new WeakHandler(this.X);
        this.Z = new c(this);
        D();
    }

    @Override // qic.a
    public final Bitmap h() {
        if (isReleased() == true) goto L8;
        TTVideoEngine r100 = this.f533227c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.saveFrame();
    L8:
        return null;
    }

    @Override // qic.a
    public final void release() {
        if (isReleased() == false) goto L5;
        return;
    L5:
        this.R.a();
        this.f533228d.getClass();
        ajc.b.a("VideoController", "releaseEngineEnabled:" + this.E + ", asyncRelease:" + this.f533235k + ", vid:" + this.f533228d.f546363a + " title:null");
        VideoTracer.INS.trace(this.f533228d, VideoTraceState.CONTROLLER_RELEASE, null, null, this.f533239o);
        TTVideoEngine r100 = this.f533227c;
        if (r100 == null) goto L8;
        r100.getIntOption(83);
        this.f533227c.getIntOption(84);
        this.f533227c.getWatchedDuration();
    L8:
        l r101 = this.f533236l;
        if (r101 == null) goto L11;
        r101.G(this.f533239o, this.f533228d);
    L11:
        E();
        if (this.f533238n == true) goto L20;
        long r102 = getCurrentPosition();
        if (r102 <= 0) goto L20;
        tic.a r103 = this.f533228d;
        if (r103 == null) goto L20;
        if (TextUtils.isEmpty(r103.f546363a) == true) goto L20;
        djc.a.a(this.f533228d.f546363a, r102);
        ajc.b.a("VideoController", "Release Vid:" + this.f533228d.f546363a + " Push Pos:" + r102);
    L20:
        this.H = false;
        this.f533238n = false;
        Object r104 = null;
        this.f533241q = null;
        this.U = -1;
        this.f533246v = null;
        this.f533247w = null;
        this.f533250z = false;
        this.A = null;
        this.Q = null;
        this.P = false;
        this.N = null;
        this.f533248x = 0;
        this.M = null;
        ((HashMap) this.O).clear();
        this.F = false;
        this.G = false;
        this.I = false;
        this.K = "";
        TTVideoEngine r105 = this.f533227c;
        if (r105 != null) goto L23;
    L39:
        this.f533227c = null;
        l r106 = this.f533236l;
        if (r106 == null) goto L42;
        r106.o(this.f533239o, this.f533228d);
    L42:
        bjc.b r107 = bjc.b.b("VCRelease", PathID.PLAY, 6);
        if (r107 != null) goto L45;
    L58:
        LogTracer.INS.getTracesJson(this.f533228d);
        return;
    L45:
        if (this.f533228d == null) goto L55;
        if (Map.class.isInstance(null) == false) goto L50;
        Object r108 = Map.class.cast(null);     // Catch: Exception -> L49
    L51:
        Map r109 = (Map) r108;     // Catch: Exception -> L49
        if (r109 == null) goto L55;
        r104 = r109.get("release_reason");     // Catch: Exception -> L49
        goto L55
    L50:
        r108 = null;
    L55:
        if ((r104 instanceof String) == false) goto L57;
        r107.a("reason", (String) r104);
    L57:
        LogTracer.INS.addTrace(this.f533228d, r107);
        goto L58
    L23:
        if (this.E == false) goto L39;
        int r110 = this.f533229e;
        if (r110 != 0) goto L27;
    L30:
        r105.setSurface(null);
    L31:
        nic.f r111 = this.f533240p;
        if ((r111 instanceof nic.g) == false) goto L35;
        ((nic.g) r111).c();
    L35:
        if (this.f533235k == false) goto L37;
        r105.releaseAsync();
    L38:
        C(r105);
        goto L39
    L37:
        r105.release();
        goto L38
    L27:
        if (r110 == 2) goto L30;
        r105.setSurfaceHolder(null);
        goto L31
    }

    @Override // qic.a
    public final PlaybackParams a() {
        return this.M;
    }

    @Override // qic.a
    public final long d() {
        return this.f533245u;
    }

    @Override // qic.a
    public final TTVideoEngine f() {
        return this.f533227c;
    }

    @Override // qic.a
    public final tic.a g() {
        return this.f533228d;
    }

    @Override // qic.a
    public final Resolution getResolution() {
        return this.f533241q;
    }

    @Override // qic.a
    public final VideoModel getVideoModel() {
        return this.N;
    }

    @Override // qic.a
    public final p getVideoStateInquirer() {
        return this.f533239o;
    }

    @Override // qic.a
    public final boolean isPrepared() {
        return this.H;
    }

    @Override // qic.a
    public final boolean r() {
        return this.P;
    }

    @Override // qic.a
    public final boolean v() {
        return this.F;
    }

    @Override // qic.a
    public final boolean y() {
        return this.f533233i;
    }

    public b(nic.e r100) {
        this.f533231g = 0;
        this.f533244t = true;
        this.B = false;
        this.C = 0;
        this.D = true;
        this.E = true;
        this.K = "";
        this.L = new f();
        this.O = new HashMap();
        this.S = new g(this);
        this.T = new ric.a(this);
        this.U = -1;
        this.V = false;
        this.W = new a(this);
        this.X = new C7333b(this);
        this.Y = new WeakHandler(this.X);
        this.Z = new c(this);
        this.f533243s = r100;
        D();
    }

    public static void C(TTVideoEngine r100) {
        if (r100 == null) goto L5;
        r100.setVideoEngineSimpleCallback(null);
        r100.setVideoInfoListener(null);
        r100.setStreamInfoListener(null);
        r100.setVideoEngineInfoListener(null);
        r100.setABRListener(null);
        r100.setMaskInfoListener(null);
        r100.setSubInfoCallBack(null);
        return;
    }

    @Override // qic.a
    public final void A(TTVNetClient r100) {
        this.f533230f = r100;
    }

    @Override // qic.a
    public final void B(qic.d r100) {
        e(r100.f533261a);
        this.f533238n = r100.f533262b;
        tic.a r101 = r100.f533263c;
        this.f533228d = r101;
        this.f533241q = r100.f533264d;
        this.f533248x = r100.f533265e;
        this.M = r100.f533266f;
        this.f533246v = r100.f533267g;
        this.f533233i = r100.f533268h;
        this.f533235k = r100.f533271k;
        this.L.f533259b = r101;
    }

    public final boolean J(int r100) {
        bjc.b r101 = bjc.b.b("VCSetEngineSource", PathID.PLAY, 6);
        LogTracer.INS.addTrace(this.f533228d, r101);
        if (r100 != 1) goto L5;
        String r102 = "try_prepare";
    L6:
        boolean r103 = false;
        TTVideoEngine.setForceUseLitePlayer(false);
        tic.a r104 = this.f533228d;
        Long r105 = null;
        if (r104.f546370h == null) goto L17;
        ajc.b.a("VideoController", r102.concat("_direct_url_use_data_loader"));
        if (r101 == null) goto L11;
        r101.a("source", "DirectUrlUseDataLoader");
    L11:
        Resolution r106 = this.f533241q;
        if (r106 == null) goto L14;
        K(r106, false);
    L15:
        TTVideoEngine r107 = this.f533227c;
        tic.a r108 = this.f533228d;
        r107.setDirectUrlUseDataLoader(r108.f546370h, r108.f546371i);
    L68:
        long r109 = this.U;
        long r110 = 0;
        if (r109 <= 0) goto L72;
        M(r109);
    L91:
        return r103;
    L72:
        if (this.f533244t == false) goto L89;
        String r111 = this.f533228d.f546363a;
        if (r111 != null) goto L76;
        LinkedHashMap<String, Pair<Long, Long>> r112 = djc.a.f468981a;
    L84:
        if (r105 == null) goto L90;
        r110 = r105.longValue();
    L90:
        M(r110);
        goto L91
    L76:
        LinkedHashMap<String, Pair<Long, Long>> r113 = djc.a.f468981a;
        monitor-enter(r113);
        Pair<Long, Long> r114 = r113.get(r111);     // Catch: Throwable -> L86
        if (r114 == null) goto L83;
        Object r115 = r114.first;     // Catch: Throwable -> L86
        if (r115 == null) goto L83;
        r105 = Long.valueOf(((Long) r115).longValue());     // Catch: Throwable -> L86
    L83:
        monitor-exit(r113);     // Catch: Throwable -> L86
    L86:
        th = move-exception;
        throw th;
    L89:
        r110 = this.f533228d.f546365c;
        goto L90
    L14:
        this.f533228d.getClass();
        L(null);
        goto L15
    L17:
        if (r104.f546366d == null) goto L22;
        if (r101 == null) goto L20;
        r101.a("source", "VideoModel");
    L20:
        this.f533228d.getClass();
        ajc.b.a("VideoController", r102 + "_cache_video_model vid:" + this.f533228d.f546363a + " title:null");
        this.f533227c.setVideoModel(this.f533228d.f546366d);
        r103 = onFetchedVideoInfo(this.f533228d.f546366d);
        goto L68
    L22:
        if (TextUtils.isEmpty(r104.f546368f) == true) goto L31;
        if (r101 == null) goto L25;
        r101.a("source", "LocalUrl");
    L25:
        ajc.b.a("VideoController", r102 + "_local_url:" + this.f533228d.f546368f);
        Resolution r116 = this.f533241q;
        if (r116 == null) goto L28;
        K(r116, false);
    L29:
        this.f533227c.setLocalURL(this.f533228d.f546368f);
        goto L68
    L28:
        this.f533228d.getClass();
        L(null);
        goto L29
    L31:
        if (TextUtils.isEmpty(this.f533228d.f546367e) == true) goto L44;
        if (r101 == null) goto L34;
        r101.a("source", "VideoUrl");
    L34:
        ajc.b.a("VideoController", r102 + "_direct_url:" + this.f533228d.f546367e);
        Resolution r117 = this.f533241q;
        if (r117 == null) goto L37;
        K(r117, false);
    L38:
        this.f533227c.setDirectURL(this.f533228d.f546367e);
        Map<String, String> r118 = this.f533228d.f546376n;
        if (r118 == null) goto L68;
        Iterator<Map.Entry<String, String>> r119 = r118.entrySet().iterator();
    L42:
        if (r119.hasNext() == false) goto L68;
        Map.Entry<String, String> r120 = r119.next();
        this.f533227c.setCustomHeader(r120.getKey(), r120.getValue());
        goto L42
    L37:
        this.f533228d.getClass();
        L(null);
        goto L38
    L44:
        this.f533228d.getClass();
        if (TextUtils.isEmpty(this.f533228d.f546369g) == true) goto L53;
        if (r101 == null) goto L48;
        r101.a("source", "MusicUrl");
    L48:
        ajc.b.a("VideoController", r102 + "_music_url:" + this.f533228d.f546369g);
        Resolution r121 = this.f533241q;
        if (r121 == null) goto L51;
        K(r121, false);
    L52:
        this.f533227c.setDirectURL(this.f533228d.f546369g);
        goto L68
    L51:
        this.f533228d.getClass();
        L(null);
        goto L52
    L53:
        this.f533228d.getClass();
        if (TextUtils.isEmpty(null) == true) goto L62;
        if (r101 == null) goto L57;
        r101.a("source", "MusicPath");
    L57:
        this.f533228d.getClass();
        ajc.b.a("VideoController", r102.concat("_music_path:null"));
        Resolution r122 = this.f533241q;
        if (r122 == null) goto L60;
        K(r122, false);
    L61:
        TTVideoEngine r123 = this.f533227c;
        this.f533228d.getClass();
        r123.setLocalURL(null);
        goto L68
    L60:
        this.f533228d.getClass();
        L(null);
        goto L61
    L62:
        if (r101 == null) goto L64;
        r101.a("source", "vid");
    L64:
        this.f533228d.getClass();
        ajc.b.a("VideoController", r102 + "_vid:" + this.f533228d.f546363a + " title:null");
        this.f533227c.setVideoID(this.f533228d.f546363a);
        Resolution r124 = this.f533241q;
        if (r124 == null) goto L67;
        K(r124, false);
        goto L68
    L67:
        this.f533228d.getClass();
        L(null);
        goto L68
    L5:
        r102 = "try_play";
        goto L6
    }

    public final void L(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        K(fjc.c.a(r100), false);
    }

    public final void M(long r100) {
        if (r100 > 0) goto L5;
        this.f533245u = 0;
        return;
    L5:
        if (this.H == false) goto L7;
        ajc.b.a("VideoController", "updateStartPlayPosition videoEngine.seekTo:" + r100 + " vid:" + this.f533228d.f546363a);
        seekTo(r100);
    L8:
        this.f533245u = r100;
        return;
    L7:
        ajc.b.a("VideoController", "videoEngine.setStartTime:" + r100 + " vid:" + this.f533228d.f546363a);
        this.f533227c.setStartTime((int) r100);
        goto L8
    }

    public final void N(VideoRef r100) {
        if (this.f533236l == null) goto L14;
        if (r100 == null) goto L20;
        Resolution[] r101 = Resolution.getAllResolutions();
        int r102 = r101.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L22;
        VideoInfo r104 = r100.getVideoInfo(r101[r103], null);
        if (r104 == null) goto L13;
        int r105 = r104.getValueInt(1);
        if (r104.getValueInt(2) <= 0) goto L13;
        if (r105 <= 0) goto L13;
        this.f533236l.N(r104);
        return;
    L13:
        r103 = r103 + 1;
        goto L6
    L22:
        return;
    L20:
        return;
    }

    @Override // qic.a
    public final VideoEngineInfos c(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        return (VideoEngineInfos) ((HashMap) this.O).get(r100);
    }

    @Override // qic.a
    public final void e(TTVideoEngine r100) {
        TTVideoEngine r101 = this.f533227c;
        if (r101 == null) goto L5;
        r101.setNetworkClient(null);
        this.f533227c.setVideoEngineSimpleCallback(null);
        this.f533227c.setVideoInfoListener(null);
        this.f533227c.setMaskInfoListener(null);
        this.f533227c.setSubInfoCallBack(null);
    L5:
        this.f533227c = r100;
        if (r100 == null) goto L12;
        TTVNetClient r102 = this.f533230f;
        if (r102 == null) goto L10;
        r100.setNetworkClient(r102);
    L10:
        this.f533227c.setVideoEngineSimpleCallback(this);
        this.f533227c.setVideoInfoListener(this);
        this.f533227c.setMaskInfoListener(this.S);
        this.f533227c.setSubInfoCallBack(this.T);
        return;
    }

    @Override // qic.a
    public final void i(boolean r100) {
        this.f533234j = r100;
    }

    @Override // qic.a
    public final void j(boolean r100) {
        this.V = r100;
    }

    @Override // qic.a
    public final void l(j r100) {
        this.f533237m = r100;
    }

    @Override // qic.a
    public final void m(nic.f r100) {
        if (r100 == null) goto L5;
        this.f533240p = r100;
        return;
    }

    @Override // qic.a
    public final void n(nic.c r100) {
        if (r100 == null) goto L5;
        this.L.f533258a = r100;
        return;
    }

    @Override // qic.a
    public final void o(boolean r100) {
        this.f533249y = r100;
    }

    @Override // com.ss.ttvideoengine.VideoEngineSimpleCallback, com.ss.ttvideoengine.VideoEngineCallback
    public final void onCompletion(TTVideoEngine r100) {
        ajc.b.a("VideoController", "onCompletion");
        this.f533238n = true;
        this.f533250z = false;
        this.A = null;
        if (this.f533233i == true) goto L5;
        E();
    L5:
        this.f533227c.getIntOption(83);
        this.f533227c.getIntOption(84);
        r100.getWatchedDuration();
        if (this.f533233i == false) goto L8;
        r100.getWatchedDuration();
    L8:
        tic.a r101 = this.f533228d;
        if (r101 != null) goto L11;
    L30:
        this.U = -1;
        l r102 = this.f533236l;
        if (r102 == null) goto L40;
        r102.D(this.f533239o, this.f533228d);
        this.f533236l.b(this.f533239o, this.f533228d);
        if (this.f533233i == false) goto L41;
        this.f533236l.h(this.f533239o, this.f533228d);
        this.f533238n = false;
        return;
    L41:
        return;
    L40:
        return;
    L11:
        if (TextUtils.isEmpty(r101.f546363a) == true) goto L30;
        String r103 = this.f533228d.f546363a;
        if (r103 == null) goto L29;
        LinkedHashMap<String, Pair<Long, Long>> r104 = djc.a.f468981a;
        monitor-enter(r104);
        r104.remove(r103);     // Catch: Throwable -> L26
        monitor-exit(r104);     // Catch: Throwable -> L26
        LinkedHashMap<String, Boolean> r105 = djc.a.f468982b;
        monitor-enter(r105);
        r105.remove(r103);     // Catch: Throwable -> L23
        monitor-exit(r105);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    L26:
        th = move-exception;
        throw th;
    L29:
        LinkedHashMap<String, Pair<Long, Long>> r106 = djc.a.f468981a;
        goto L30
    }

    @Override // com.ss.ttvideoengine.VideoEngineSimpleCallback, com.ss.ttvideoengine.VideoEngineCallback
    public final void onError(Error r100) {
        String r101 = "onError:" + r100.description + " errorCode:" + r100.code + " internalCode:" + r100.internalCode;
        ajc.b.a("VideoController", r101);
        bjc.b r102 = bjc.b.b("VCOnError", PathID.PLAY, 6);
        if (r102 == null) goto L5;
        r102.a("err", r101);
        LogTracer.INS.addTrace(this.f533228d, r102);
    L5:
        VideoTracer.INS.trace(this.f533228d, VideoTraceState.CONTROLLER_ON_ERROR, r101, r100, this.f533239o);
        this.f533250z = true;
        this.G = false;
        this.F = false;
        this.H = false;
        this.I = false;
        this.A = r100;
        l r103 = this.f533236l;
        if (r103 == null) goto L9;
        r103.v(this.f533239o, this.f533228d, r100);
        return;
    }

    @Override // com.ss.ttvideoengine.VideoInfoListener
    public final boolean onFetchedVideoInfo(VideoModel r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
        return false;
    L5:
        LogTracer.INS.addTrace(this.f533228d, bjc.b.b("VCOnFetchedVideoInfo", PathID.PLAY, 6));
        this.N = r100;
        VideoRef r102 = r100.getVideoRef();
        this.f533246v = fjc.c.b(r102);
        ArrayList r103 = new ArrayList();
        if (r102 != null) goto L8;
    L15:
        this.f533247w = r103;
        j r104 = this.f533237m;
        if (r104 != null) goto L18;
    L52:
        SparseArray<VideoInfo> r105 = fjc.c.b(r102);
        int r106 = r105.size() - 1;
        int r107 = 0;
    L53:
        if (r106 < 0) goto L58;
        if (r105.valueAt(r106) == null) goto L57;
        r107 = r107 + 1;
    L57:
        r106 = r106 - 1;
        goto L53
    L58:
        this.f533248x = r107;
        if (this.f533249y == false) goto L63;
        j r108 = this.f533237m;
        if (r108 == null) goto L63;
        r101 = r108.interceptPlayWhenVideoInfoReady(r102);
    L63:
        l r109 = this.f533236l;
        if (r109 == null) goto L66;
        r109.d(this.f533239o, this.f533228d, r101);
    L66:
        return r101;
    L18:
        if ((r104 instanceof k) == false) goto L20;
        k r110 = (k) r104;
        VideoInfo r111 = r110.e(this.f533239o, r100, this.f533228d);
        r110.n(r111, this.f533239o, r100, this.f533228d);
    L21:
        if (r111 != null) goto L23;
        r111 = this.f533237m.selectVideoInfoToPlay(r100);
    L23:
        if (r111 != null) goto L25;
        r111 = this.f533237m.selectVideoInfoToPlay(r102);
    L25:
        if (r111 == null) goto L51;
        StringBuilder r112 = new StringBuilder("get_video_info:");
        r112.append(r111.getValueStr(8) + ", size:" + r111.getValueInt(1) + "*" + r111.getValueInt(2) + ", definition:" + r111.getValueStr(7));
        ajc.b.a("VideoController", r112.toString());
        TTVideoEngine r113 = this.f533227c;
        if (r113 != null) goto L29;
    L31:
        boolean r114 = false;
    L32:
        if (r114 == false) goto L34;
    L45:
        boolean r115 = true;
    L46:
        if (r115 == false) goto L50;
        Resolution r116 = r111.getResolution();
        Resolution r117 = Resolution.Auto;
        if (r116 != r117) goto L50;
        this.f533241q = r117;
        K(r117, false);
        N(r102);
    L50:
        String r118 = r111.getValueStr(7);
        this.K = r111.getValueStr(32);
        this.f533241q = fjc.c.a(r118);
        TextUtils.isEmpty(this.K);
        L(r118);
        goto L52
    L34:
        if (r100.isDashSource() == false) goto L37;
    L40:
        boolean r119 = true;
    L42:
        if (r119 == true) goto L45;
        r115 = false;
        goto L46
    L37:
        if (r100.isMp4Source() == true) goto L39;
    L41:
        r119 = false;
        goto L42
    L39:
        if (r100.isSupportBash() == false) goto L41;
    L29:
        if (r113.isDashSource() == false) goto L31;
        r114 = true;
        goto L32
    L51:
        N(r102);
        goto L52
    L20:
        r111 = null;
        goto L21
    L8:
        if (r102.getVideoInfoList() == null) goto L15;
        Iterator<VideoInfo> r120 = r102.getVideoInfoList().iterator();
    L11:
        if (r120.hasNext() == false) goto L15;
        VideoInfo r121 = r120.next();
        if (TextUtils.isEmpty(r121.getValueStr(7)) == true) goto L11;
        r103.add(r121);
        goto L11
    }

    @Override // com.ss.ttvideoengine.VideoEngineSimpleCallback, com.ss.ttvideoengine.VideoEngineCallback
    public final void onPrepare(TTVideoEngine r100) {
        LogTracer.INS.addTrace(this.f533228d, bjc.b.b("VCOnPrepare", PathID.PLAY, 3));
        ajc.b.a("VideoController", "onPrepare");
        VideoTracer.INS.trace(this.f533228d, VideoTraceState.CONTROLLER_ON_PREPARE, null, null, this.f533239o);
        l r101 = this.f533236l;
        if (r101 == null) goto L6;
        r101.u(this.f533239o, this.f533228d);
        return;
    }

    @Override // com.ss.ttvideoengine.VideoEngineSimpleCallback, com.ss.ttvideoengine.VideoEngineCallback
    public final void onPrepared(TTVideoEngine r100) {
        LogTracer.INS.addTrace(this.f533228d, bjc.b.b("VCOnPrepared", PathID.PLAY, 6));
        this.H = true;
        StringBuilder r101 = new StringBuilder("onPrepared:");
        r101.append(this.f533228d.f546363a);
        r101.append(" title:null hashCode:");
        this.f533228d.getClass();
        r101.append(hashCode());
        ajc.b.a("VideoController", r101.toString());
        VideoTracer.INS.trace(this.f533228d, VideoTraceState.CONTROLLER_ON_PREPARED, null, null, this.f533239o);
        l r102 = this.f533236l;
        if (r102 == null) goto L5;
        r102.L(this.f533239o, this.f533228d);
    L5:
        this.R.b();
    }

    @Override // com.ss.ttvideoengine.VideoEngineSimpleCallback, com.ss.ttvideoengine.VideoEngineCallback
    public final void onRenderStart(TTVideoEngine r100) {
        LogTracer.INS.addTrace(this.f533228d, bjc.b.b("VCOnRenderStart", PathID.PLAY, 6));
        StringBuilder r101 = new StringBuilder("onRenderStart:");
        r101.append(this.f533228d.f546363a);
        r101.append(" title:null hashCode:");
        this.f533228d.getClass();
        r101.append(hashCode());
        ajc.b.a("VideoController", r101.toString());
        VideoTracer r102 = VideoTracer.INS;
        r102.trace(this.f533228d, VideoTraceState.CONTROLLER_ON_RENDER_START, null, null, this.f533239o);
        if (this.V == true) goto L12;
        tic.a r103 = this.f533228d;
        TTVideoEngine r104 = this.f533227c;
        float r105 = 0.0f;
        if (r104 == null) goto L7;
        float r106 = r104.getMaxVolume();
    L8:
        TTVideoEngine r107 = this.f533227c;
        if (r107 == null) goto L11;
        r105 = r107.getVolume();
    L11:
        r102.updateVolume(r103, r106, r105);
        goto L12
    L7:
        r106 = 0.0f;
    L12:
        this.P = true;
        l r108 = this.f533236l;
        if (r108 == null) goto L16;
        r108.z(this.f533239o, this.f533228d);
        this.f533236l.B(this.f533239o, this.f533228d);
        return;
    }

    @Override // com.ss.ttvideoengine.VideoEngineInfoListener
    public final void onVideoEngineInfos(VideoEngineInfos r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        VideoEngineInfos r101 = new VideoEngineInfos();
        r101.setKey(r100.getKey());
        r101.setUrlInfos(r100.getUrlInfos());
        r101.setObject(r100.getObject());
        r101.setUsingMDLHitCacheSize(r100.getUsingMDLHitCacheSize());
        String r102 = r100.getUsingMDLPlayTaskKey();
        if (TextUtils.isEmpty(r102) == true) goto L7;
        r101.setUsingMDLPlayTaskKey(r102);
    L7:
        Map<String, VideoEngineInfos> r103 = this.O;
        HashMap r104 = (HashMap) r103;
        r104.put(r101.getKey(), r101);
        l r105 = this.f533236l;
        if (r105 == null) goto L11;
        r105.i(this.f533239o, this.f533228d, r101);
    L11:
        if (r101.getKey().equals(VideoEngineInfos.USING_RENDER_SEEK_COMPLETE) == true) goto L13;
        return;
    L13:
        if (this.f533236l != null) goto L15;
        return;
    L15:
        if ((r101.getObject() instanceof Integer) == true) goto L17;
    L19:
        boolean r106 = false;
    L20:
        this.f533236l.R(this.f533239o, this.f533228d, r106);
        return;
    L17:
        if (((Integer) r101.getObject()).intValue() <= 0) goto L19;
        r106 = true;
        goto L20
    }

    @Override // com.ss.ttvideoengine.VideoEngineSimpleCallback, com.ss.ttvideoengine.VideoEngineCallback
    public final void onVideoStatusException(int r110) {
        bjc.b r100 = bjc.b.b("VCOnVideoStatusException", PathID.PLAY, 6);
        if (r100 == null) goto L5;
        r100.a("status", "" + r110);
        LogTracer.INS.addTrace(this.f533228d, r100);
    L5:
        ajc.b.a("VideoController", "onVideoStatusException:" + r110);
        VideoTracer.INS.trace(this.f533228d, VideoTraceState.CONTROLLER_ON_STATUS_EXCEPTION, "" + r110, Integer.valueOf(r110), this.f533239o);
        l r101 = this.f533236l;
        if (r101 == null) goto L9;
        r101.k(this.f533239o, this.f533228d, r110);
        return;
    }

    @Override // qic.a
    public final int p(boolean r100) {
        if (r100 == true) goto L5;
    L10:
        TTVideoEngine r101 = this.f533227c;
        if (r101 != null) goto L13;
        return 0;
    L13:
        return r101.getCurrentPlaybackTime();
    L5:
        if (this.f533234j == false) goto L10;
        TTVideoEngine r102 = this.f533227c;
        if (r102 != null) goto L9;
        return 0;
    L9:
        return r102.getCurrentPlaybackTimeAsync();
    }

    @Override // qic.a
    public final void q(l r100) {
        this.f533236l = r100;
    }

    @Override // qic.a
    public final void s(int r100) {
        this.f533229e = r100;
    }

    @Override // qic.a
    public final void seekTo(long r100) {
        l r101 = this.f533236l;
        if (r101 == null) goto L5;
        r101.c0(this.f533239o, this.f533228d, r100);
    L5:
        TTVideoEngine r102 = this.f533227c;
        if (r102 != null) goto L8;
    L12:
        StringBuilder r103 = new StringBuilder("seek:");
        if (this.B == false) goto L15;
        String r104 = "end";
    L16:
        r103.append(r104);
        ajc.b.a("VideoController", r103.toString());
        if (this.f533227c != null) goto L19;
        return;
    L19:
        VideoTracer.INS.trace(this.f533228d, VideoTraceState.CONTROLLER_SEEK, null, null, this.f533239o);
        LogTracer.INS.addTrace(this.f533228d, bjc.b.b("VCSeekTo", PathID.SEEK, 6));
        this.D = false;
        E();
        this.f533227c.seekTo((int) r100, this.Z);
        l r105 = this.f533236l;
        if (r105 == null) goto L23;
        r105.w(this.f533239o, this.f533228d, r100);
        return;
    L23:
        return;
    L15:
        r104 = "" + r100;
        goto L16
    L8:
        if (r100 < r102.getDuration()) goto L10;
        boolean r106 = true;
    L11:
        this.B = r106;
        goto L12
    L10:
        r106 = false;
        goto L11
    }

    @Override // qic.a
    public final void setLoop(boolean r100) {
        this.f533233i = r100;
        TTVideoEngine r101 = this.f533227c;
        if (r101 == null) goto L6;
        r101.setLooping(r100);
        return;
    }

    @Override // qic.a
    public final void setMute(boolean r100) {
        this.f533232h = r100;
        if (this.f533227c == null) goto L6;
        ajc.b.a("VideoController", "setMute:" + r100);
        this.f533227c.setIsMute(r100);
        return;
    }

    @Override // qic.a
    public final void setPlayEntity(tic.a r100) {
        this.f533228d = r100;
        this.L.f533259b = r100;
    }

    @Override // qic.a
    public final void setPlaybackParams(PlaybackParams r100) {
        this.M = r100;
        TTVideoEngine r101 = this.f533227c;
        if (r101 == null) goto L7;
        if (r100 == null) goto L8;
        r101.setPlaybackParams(r100);
        return;
    L8:
        return;
    }

    @Override // qic.a
    public final void setRenderMode(int r100) {
        this.f533231g = r100;
        TTVideoEngine r101 = this.f533227c;
        if (r101 == null) goto L6;
        r101.setIntOption(4, r100);
        return;
    }

    @Override // qic.a
    public final void setStartTime(int r100) {
        TTVideoEngine r101 = this.f533227c;
        if (r101 == null) goto L6;
        r101.setStartTime(r100);
        return;
    }

    @Override // qic.a
    public final void setSurface(Surface r100) {
        if (this.f533225a == r100) goto L13;
        this.f533225a = r100;
        TTVideoEngine r101 = this.f533227c;
        if (r101 == null) goto L14;
        int r102 = this.f533229e;
        if (r102 != 0) goto L10;
        r101.setSurface(r100);
        return;
    L10:
        if (r102 != 2) goto L16;
        r101.setSurfaceSync(r100);
        return;
    L16:
        return;
    L14:
        return;
    }

    @Override // qic.a
    public final void setSurfaceHolder(SurfaceHolder r100) {
        if (this.f533226b == r100) goto L15;
        this.f533226b = r100;
        TTVideoEngine r101 = this.f533227c;
        if (r101 != null) goto L7;
        return;
    L7:
        if (this.G == true) goto L9;
    L13:
        r101.setSurfaceHolder(r100);
        return;
    L9:
        if (this.F == true) goto L13;
        r101.setSurfaceHolderSync(r100);
        VideoSurface r102 = this.f533227c.getTextureSurface();
        if (r102 == null) goto L17;
        r102.setIntOption(25, 1);
        return;
    L17:
        return;
    }

    @Override // qic.a
    public final void t(boolean r100) {
        this.f533244t = r100;
    }

    @Override // qic.a
    public final void w(boolean r100) {
        this.E = r100;
    }

    @Override // qic.a
    public final void x(boolean r100) {
        this.f533235k = r100;
    }

    public final void K(Resolution r100, boolean r101) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f533241q == r100) goto L10;
        bjc.b r102 = bjc.b.b("SetResolution", PathID.PLAY, 6);
        if (r102 == null) goto L9;
        r102.a("resolution", r100.toString());
        LogTracer.INS.addTrace(this.f533228d, r102);
    L9:
        boolean r103 = true;
    L11:
        this.f533242r = r100;
        if (this.f533241q != null) goto L14;
        this.f533241q = r100;
    L14:
        Resolution r104 = Resolution.Auto;
        if (r100 != r104) goto L18;
        this.f533241q = r104;
    L22:
        l r105 = this.f533236l;
        if (r105 == null) goto L27;
        if (r103 == false) goto L27;
        r105.l(this.f533239o, this.f533228d, r100, r101);
    L27:
        if (this.f533227c != null) goto L29;
        return;
    L29:
        if (r100 != r104) goto L31;
        ajc.b.a("VideoController", "setResolution Auto");
        this.f533227c.setIntOption(29, 1);
    L37:
        if (this.G == true) goto L39;
        return;
    L39:
        if (this.P == true) goto L44;
        this.f533241q = r100;
        return;
    L44:
        return;
    L31:
        StringBuilder r106 = new StringBuilder("setResolution:");
        r106.append(r100);
        r106.append(" title:");
        if (this.f533228d != null) goto L34;
        String r107 = "entity null";
    L35:
        r106.append(r107);
        ajc.b.a("VideoController", r106.toString());
        this.f533227c.configResolution(r100);
        goto L37
    L34:
        r107 = null;
        goto L35
    L18:
        if (this.f533241q != r104) goto L22;
        if (r100 != this.Q) goto L22;
        this.f533241q = r100;
        goto L22
    L10:
        r103 = false;
        goto L11
    }

    @Override // com.ss.ttvideoengine.VideoEngineSimpleCallback, com.ss.ttvideoengine.VideoEngineCallback
    public final void onBufferingUpdate(TTVideoEngine r100, int r101) {
        l r102 = this.f533236l;
        if (r102 == null) goto L6;
        r102.Q(this.f533239o, this.f533228d, r101);
        return;
    }

    @Override // com.ss.ttvideoengine.VideoEngineSimpleCallback, com.ss.ttvideoengine.VideoEngineCallback
    public final void onFrameDraw(int r100, Map r101) {
        super.onFrameDraw(r100, r101);
        fjc.a.a().post(new d(this, r100, r101));
    }

    @Override // com.ss.ttvideoengine.VideoEngineSimpleCallback, com.ss.ttvideoengine.VideoEngineCallback
    public final void onLoadStateChanged(TTVideoEngine r110, int r111) {
        bjc.b r112 = bjc.b.b("OnLoadStateChanged", PathID.PLAY, 3);
        LogTracer.INS.addTrace(this.f533228d, r112);
        if (r111 != 1) goto L5;
        ajc.b.a("VideoController", "load_state_changed -> playable");
        ajc.b.a("VideoController", "onBufferEnd");
        l r100 = this.f533236l;
        if (r100 == null) goto L23;
        r100.I(this.f533239o, this.f533228d);
    L23:
        VideoTracer.INS.trace(this.f533228d, VideoTraceState.CONTROLLER_LOAD_STATE_PLAYABLE, null, null, this.f533239o);
        String r101 = "playable";
    L24:
        if (r112 == null) goto L26;
        r112.a("state", r101);
    L26:
        l r113 = this.f533236l;
        if (r113 == null) goto L30;
        r113.K(this.f533239o, this.f533228d, r111);
        return;
    L30:
        return;
    L5:
        if (r111 == 2) goto L9;
        if (r111 == 3) goto L8;
        r101 = "";
        goto L24
    L8:
        ajc.b.a("VideoController", "load_state_changed -> error");
        VideoTracer.INS.trace(this.f533228d, VideoTraceState.CONTROLLER_LOAD_STATE_ERROR, null, null, this.f533239o);
        r101 = "error";
        goto L24
    L9:
        ajc.b.a("VideoController", "load_state_changed -> stalled");
        ajc.b.a("VideoController", "onBufferStart");
        l r102 = this.f533236l;
        if (r102 == null) goto L13;
        r102.Y(this.f533239o, this.f533228d);
    L13:
        if (this.D == false) goto L15;
        this.C++;
    L16:
        l r103 = this.f533236l;
        if (r103 == null) goto L19;
        r103.j(this.f533239o, this.f533228d, this.C);
    L19:
        VideoTracer.INS.trace(this.f533228d, VideoTraceState.CONTROLLER_LOAD_STATE_STALLED, null, null, this.f533239o);
        r101 = "stalled";
        goto L24
    L15:
        this.D = true;
        goto L16
    }

    @Override // com.ss.ttvideoengine.VideoEngineSimpleCallback, com.ss.ttvideoengine.VideoEngineCallback
    public final void onPlaybackStateChanged(TTVideoEngine r110, int r111) {
        bjc.b r112 = bjc.b.b("PlayStateChanged", PathID.PLAY, 3);
        LogTracer.INS.addTrace(this.f533228d, r112);
        if (r111 != 0) goto L5;
        ajc.b.a("VideoController", "play_back_state_changed -> stopped");
        VideoTracer.INS.trace(this.f533228d, VideoTraceState.CONTROLLER_PLAY_STATE_STOPPED, null, null, this.f533239o);
        String r100 = "stopped";
    L23:
        if (r112 == null) goto L25;
        r112.a("state", r100);
    L25:
        l r113 = this.f533236l;
        if (r113 == null) goto L29;
        r113.J(this.f533239o, this.f533228d, r111);
        return;
    L29:
        return;
    L5:
        if (r111 != 1) goto L7;
        ajc.b.a("VideoController", "play_back_state_changed -> playing");
        WeakHandler r101 = this.Y;
        if (r101 == null) goto L18;
        r101.sendEmptyMessage(AsyncVideoMsg.UPDATE_PROGRESS.getWhat());
    L18:
        l r102 = this.f533236l;
        if (r102 == null) goto L21;
        r102.W(this.f533239o, this.f533228d);
    L21:
        VideoTracer.INS.trace(this.f533228d, VideoTraceState.CONTROLLER_PLAY_STATE_PLAYING, null, null, this.f533239o);
        r100 = "playing";
        goto L23
    L7:
        if (r111 == 2) goto L11;
        if (r111 == 3) goto L10;
        r100 = "";
        goto L23
    L10:
        ajc.b.a("VideoController", "play_back_state_changed -> error");
        E();
        VideoTracer.INS.trace(this.f533228d, VideoTraceState.CONTROLLER_PLAY_STATE_ERROR, null, null, this.f533239o);
        r100 = "error";
        goto L23
    L11:
        ajc.b.a("VideoController", "play_back_state_changed -> paused");
        l r103 = this.f533236l;
        if (r103 == null) goto L14;
        r103.s(this.f533239o, this.f533228d);
    L14:
        VideoTracer.INS.trace(this.f533228d, VideoTraceState.CONTROLLER_PLAY_STATE_PAUSED, null, null, this.f533239o);
        r100 = "paused";
        goto L23
    }

    @Override // com.ss.ttvideoengine.VideoEngineSimpleCallback, com.ss.ttvideoengine.VideoEngineCallback
    public final void onStreamChanged(TTVideoEngine r100, int r101) {
        ajc.b.a("VideoController", "onStreamChanged type:" + r101);
        bjc.b r102 = bjc.b.b("VCOnStreamChanged", PathID.PLAY, 3);
        if (r102 == null) goto L5;
        r102.a("type", "" + r101);
        LogTracer.INS.addTrace(this.f533228d, r102);
    L5:
        if (r101 != 0) goto L9;
        Resolution r103 = this.f533242r;
        if (r103 == null) goto L9;
        this.f533241q = r103;
        this.f533242r = null;
    L9:
        l r104 = this.f533236l;
        if (r104 == null) goto L13;
        r104.F(this.f533239o, this.f533228d, r101);
        return;
    }

    @Override // com.ss.ttvideoengine.VideoEngineSimpleCallback, com.ss.ttvideoengine.VideoEngineCallback
    public final void onVideoStreamBitrateChanged(Resolution r100, int r101) {
        bjc.b r102 = bjc.b.b("VCOnBitrateChanged", PathID.PLAY, 3);
        if (r102 == null) goto L7;
        if (r100 == null) goto L6;
        r102.a("resolution", r100.toString());
    L6:
        LogTracer.INS.addTrace(this.f533228d, r102);
    L7:
        ajc.b.a("VideoController", "onVideoStreamBitrateChanged resolution:" + r100.toString());
        this.Q = r100;
        Resolution r103 = this.f533242r;
        if (r103 == null) goto L10;
        this.f533241q = r103;
        this.f533242r = null;
    L10:
        l r104 = this.f533236l;
        if (r104 == null) goto L14;
        r104.U(this.f533239o, this.f533228d, r100, r101);
        return;
    }

    @Override // qic.a
    public final void setResolution(Resolution r100, boolean r101) {
        K(r100, r101);
    }

    @Override // qic.a
    public final void setVolume(float r100, float r101) {
        if (this.f533227c == null) goto L12;
        ajc.b.a("VideoController", "setVolume left:" + r100 + " right:" + r101);
        this.f533227c.setVolume(r100, r101);
        if (this.V == true) goto L13;
        VideoTracer r102 = VideoTracer.INS;
        tic.a r103 = this.f533228d;
        TTVideoEngine r104 = this.f533227c;
        if (r104 == null) goto L9;
        float r105 = r104.getMaxVolume();
    L10:
        r102.updateVolume(r103, r105, r100);
        return;
    L9:
        r105 = 0.0f;
        goto L10
    L13:
        return;
    }

    @Override // com.ss.ttvideoengine.VideoEngineSimpleCallback, com.ss.ttvideoengine.VideoEngineCallback
    public final void onVideoSizeChanged(TTVideoEngine r100, int r101, int r102) {
        l r103 = this.f533236l;
        if (r103 == null) goto L6;
        r103.m(this.f533239o, this.f533228d, r101, r102);
        return;
    }
}
