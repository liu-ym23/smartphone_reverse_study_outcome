package f07;

import android.content.Context;
import android.os.Message;
import android.view.Surface;
import com.bytedance.common.utility.collection.WeakHandler;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.LLog;
import com.ss.texturerender.VideoSurface;
import com.ss.ttm.player.PlaybackParams;
import com.ss.ttvideoengine.DataSource;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.SeekCompletionListener;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ss.ttvideoengine.VideoEngineCallback;
import com.ss.ttvideoengine.VideoEngineInfoListener;
import com.ss.ttvideoengine.VideoEngineInfos;
import com.ss.ttvideoengine.log.VideoEventManager;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.model.VideoRef;
import com.ss.ttvideoengine.utils.Error;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements VideoEngineInfoListener, VideoEngineCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile TTVideoEngine f474984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f474985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f474986c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g07.b f474987d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public VideoEngineCallback f474988e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public VideoEngineInfoListener f474989f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public DataSource f474990g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public f07.a f474991h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PlaybackParams f474992i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public e f474993j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f474994k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile boolean f474995l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f474996m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f474997n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f474998o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f474999p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f475000q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final C5844c f475001r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final d f475002s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final WeakHandler f475003t;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f475004a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f475005b;

        @Override // java.lang.Runnable
        public final void run() {
            LLog.i("VideoController", "Do trigger video engine prepare in video controller");     // Catch: Throwable -> L7
            TTVideoEngine r100 = this.f475005b.f474984a;     // Catch: Throwable -> L7
            if (this.f475004a == true) goto L10;
            if (r100 == null) goto L14;
            r100.prepare();     // Catch: Throwable -> L7
            return;
        L14:
            return;
        L10:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L15;
            throw th;
        }

        public a(c r100, boolean r101) {
            this.f475005b = r100;
            this.f475004a = r101;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f475006a;

        @Override // java.lang.Runnable
        public final void run() {
            LLog.i("VideoController", "Do trigger video engine play in video controller");     // Catch: Throwable -> L6
            TTVideoEngine r100 = this.f475006a.f474984a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.play();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public b(c r100) {
            this.f475006a = r100;
        }
    }

    /* JADX INFO: renamed from: f07.c$c, reason: collision with other inner class name */
    public class C5844c implements SeekCompletionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f475007a;

        public C5844c(c r100) {
            this.f475007a = r100;
        }

        @Override // com.ss.ttvideoengine.SeekCompletionListener
        public final void onCompletion(boolean r100) {
            if (this.f475007a.f474984a != null) goto L5;
            return;
        L5:
            if (r100 == true) goto L10;
            c r101 = this.f475007a;
            if (r101.f474994k == (-1)) goto L9;
            r101.f474984a.setStartTime(this.f475007a.f474994k);
            this.f475007a.f474994k = -1;
        L9:
            c.a(this.f475007a, true);
            return;
        L10:
            c.a(this.f475007a, r100);
        }
    }

    public class d implements WeakHandler.IHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f475008a;

        public d(c r100) {
            this.f475008a = r100;
        }

        @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
        public final void handleMsg(Message r100) {
            if (r100.what != 201) goto L38;
            c r101 = this.f475008a;
            g07.b r102 = r101.f474987d;
            if (r102 == null) goto L8;
            g07.a r103 = r102.f479498n;
        L9:
            if (r103 == null) goto L12;
            int r104 = r103.f479484j;
            if (r104 <= 0) goto L12;
        L14:
            if (r101.f474984a == null) goto L23;
            Object r105 = r100.obj;
            if (r105 == null) goto L18;
            ((Boolean) r105).booleanValue();
        L18:
            int r106 = this.f475008a.f474984a.getCurrentPlaybackTime();
            if (this.f475008a.f474984a.getDuration() <= 0) goto L23;
            c r107 = this.f475008a;
            VideoEngineCallback r108 = r107.f474988e;
            if (r108 == null) goto L23;
            r108.onCurrentPlaybackTimeUpdate(r107.f474984a, r106);
        L23:
            c r109 = this.f475008a;
            if (r109.f474996m == true) goto L26;
        L30:
            boolean r110 = false;
        L31:
            if (r110 == false) goto L33;
            return;
        L33:
            if (this.f475008a.c() == false) goto L37;
            this.f475008a.f475003t.sendMessageDelayed(this.f475008a.f475003t.obtainMessage(201), r104);
            return;
        L37:
            return;
        L26:
            if (r109.f474984a == null) goto L30;
            if (r109.f474984a.getPlaybackState() != 0) goto L30;
            r110 = true;
        L12:
            r104 = 167;
            goto L14
        L8:
            r103 = null;
            goto L9
        }
    }

    public interface e {
        void a();

        void b(Runnable r100);

        void c();

        void onVideoPlay();

        void onVideoSizeChanged(int r100, int r101);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public final /* synthetic */ String getEncryptedLocalTime() {
        return VideoEngineCallback.CC.$default$getEncryptedLocalTime(this);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public final /* synthetic */ void onAVBadInterlaced(Map r100) {
        VideoEngineCallback.CC.$default$onAVBadInterlaced(this, r100);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public final /* synthetic */ void onFirstAVSyncFrame(TTVideoEngine r100) {
        VideoEngineCallback.CC.$default$onFirstAVSyncFrame(this, r100);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public final /* synthetic */ void onInfoIdChanged(int r100) {
        VideoEngineCallback.CC.$default$onInfoIdChanged(this, r100);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public final /* synthetic */ void onPlayUrlChanged(int r100, String r101, String r102) {
        VideoEngineCallback.CC.$default$onPlayUrlChanged(this, r100, r101, r102);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public final /* synthetic */ void onRefreshSurface(TTVideoEngine r100) {
        VideoEngineCallback.CC.$default$onRefreshSurface(this, r100);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public final /* synthetic */ int onSetSurface(TTVideoEngine r100, VideoSurface r101, Surface r102) {
        return VideoEngineCallback.CC.$default$onSetSurface(this, r100, r101, r102);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public final /* synthetic */ void onSilenceDetected(TTVideoEngine r100) {
        VideoEngineCallback.CC.$default$onSilenceDetected(this, r100);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public final /* synthetic */ void onVideoSecondFrame(TTVideoEngine r100) {
        VideoEngineCallback.CC.$default$onVideoSecondFrame(this, r100);
    }

    public final void b() {
        TTVideoEngine.setReportLogByEngine(true, this.f474986c);
        if (this.f474984a != null) goto L18;
        VideoEventManager.instance.setLoggerVersion(2);
        f07.a r100 = this.f474991h;
        if (r100 != null) goto L7;
    L9:
        int r101 = 0;
    L10:
        if (r101 != 2) goto L12;
        boolean r102 = true;
    L13:
        this.f475000q = r102;
        this.f474984a = new TTVideoEngine(this.f474986c, r101);
        this.f474984a.setVideoEngineCallback(this);
        this.f474984a.setVideoEngineInfoListener(this);
        if (this.f474990g == null) goto L16;
        this.f474984a.setDataSource(this.f474990g);
    L16:
        this.f474984a.setIntOption(12, 0);
        this.f474984a.setIntOption(TTVideoEngineInterface.PLAYER_OPTION_USE_FALLBACK_API, 1);
        this.f474984a.setIntOption(471, 3);
        this.f474984a.setIntOption(7, 0);
        this.f474984a.setIntOption(5, 5);
        return;
    L12:
        r102 = false;
        goto L13
    L7:
        if (r100.a() < 0) goto L9;
        r101 = this.f474991h.a();
        goto L10
    }

    public final boolean c() {
        if (this.f474996m == true) goto L5;
    L9:
        return false;
    L5:
        if (this.f474984a == null) goto L9;
        if (this.f474984a.getPlaybackState() != 1) goto L9;
        return true;
    }

    public final void d() {
        if (this.f474995l == true) goto L6;
        e(true);
    L6:
        if (this.f474984a != null) goto L10;
        LLog.i("VideoController", "VideoEngine not initialized");
        return;
    L10:
        if (g() == false) goto L14;
        e r100 = this.f474993j;
        if (r100 == null) goto L14;
        r100.b(new b(this));
        return;
    L14:
        TTVideoEngine r101 = this.f474984a;
        if (r101 == null) goto L19;
        r101.play();
        return;
    }

    public final boolean g() {
        g07.b r100 = this.f474987d;
        if (r100 == null) goto L5;
        g07.a r101 = r100.f479498n;
    L7:
        if (r101 != null) goto L9;
        return false;
    L9:
        Map<String, String> r102 = r101.f479483i;
        if (r102 != null) goto L12;
        return false;
    L12:
        String r103 = r102.get("experimental-force-prepare-play-after-surface-available");
        if (r103 != null) goto L16;
        return false;
    L16:
        return "true".equalsIgnoreCase(r103);
    L5:
        r101 = null;
        goto L7
    }

    public final void e(boolean r100) {
        if (this.f474995l == false) goto L5;
    L67:
        LLog.i("VideoController", "Failed to trigger prepare in videoController for prepareCalled or preparing");
        return;
    L5:
        if (this.f474997n == true) goto L67;
        this.f474997n = true;
        Object r101 = this.f474985b;
        monitor-enter(r101);
    L64:
        th = move-exception;
        throw th;
    L10:
        if (this.f474984a != null) goto L12;
        b();     // Catch: Throwable -> L64
    L12:
        monitor-exit(r101);     // Catch: Throwable -> L64
        if (this.f474984a == null) goto L45;
        f07.a r102 = this.f474991h;
        if (r102 == null) goto L18;
        r102.b(this.f474984a, this.f474987d);
    L18:
        this.f474984a.setIntOption(160, 1);
        this.f474984a.setIntOption(509, 1);
        this.f474984a.setIntOption(402, 1);
        g07.b r103 = this.f474987d;
        String r104 = r103.f479486b;
        if (r103.f479490f == null) goto L22;
        TTVideoEngine r105 = this.f474984a;
        g07.b r106 = this.f474987d;
        r105.setDirectUrlUseDataLoader(r106.f479490f, r106.f479489e);
        goto L45
    L22:
        if (r103.f479491g == null) goto L24;
        this.f474984a.setLocalURL(this.f474987d.f479491g);
        goto L45
    L24:
        if (r104 == null) goto L38;
        if (r103.f479492h == true) goto L32;
        VideoModel r107 = new VideoModel();
        VideoRef r108 = new VideoRef();     // Catch: JSONException -> L30
        r108.extractFields(new JSONObject(r103.f479486b));     // Catch: JSONException -> L30
        r107.setVideoRef(r108);     // Catch: JSONException -> L30
    L31:
        r103.f479493i = r107;
        r103.f479492h = true;
    L30:
        r107 = null;
    L32:
        VideoModel r109 = r103.f479493i;
        if (r109 == null) goto L45;
        this.f474984a.setVideoModel(r109);
        if (r109.hasFormat(IVideoModel.Format.DASH) == false) goto L45;
        this.f474984a.setIntOption(17, 1);
        this.f474984a.setIntOption(33, 1);
        this.f474984a.setIntOption(473, 3);
        goto L45
    L38:
        if (r103.f479485a == null) goto L45;
        this.f474984a.setIntOption(21, 1);
        this.f474984a.setVideoID(this.f474987d.f479485a);
        if (this.f474987d.f479487c == null) goto L45;
        this.f474984a.setPlayAPIVersion(2, this.f474987d.f479487c);
        if (this.f474987d.f479488d == null) goto L45;
        TTVideoEngine r110 = this.f474984a;
        g07.b r111 = this.f474987d;
        r110.setDataSource(new e07.a(r111.f479487c, r111.f479488d));
    L45:
        if (this.f474984a != null) goto L49;
        LLog.i("VideoController", "VideoEngine not initialized");
        this.f474997n = false;
        return;
    L49:
        if (this.f474995l == true) goto L54;
        e r112 = this.f474993j;
        if (r112 == null) goto L54;
        r112.c();
    L54:
        if (g() == false) goto L58;
        e r113 = this.f474993j;
        if (r113 == null) goto L58;
        r113.b(new a(this, r100));
    L62:
        this.f474995l = true;
        this.f474997n = false;
        return;
    L58:
        TTVideoEngine r114 = this.f474984a;
        if (r100 == true) goto L62;
        if (r114 == null) goto L62;
        r114.prepare();
        goto L62
    }

    public final void f(Surface r100) {
        if (r100 != null) goto L5;
        this.f474998o = false;
        return;
    L5:
        if (this.f474984a != null) goto L7;
        return;
    L7:
        if (this.f474998o == true) goto L12;
        this.f474998o = true;
        LLog.i("VideoController", "Set surface to video engine");
        this.f474984a.setSurface(r100);
        return;
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public final void onBufferEnd(int r100) {
        VideoEngineCallback r101 = this.f474988e;
        if (r101 == null) goto L6;
        r101.onBufferEnd(r100);
        return;
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public final void onCompletion(TTVideoEngine r100) {
        if (r100.getLooping(false) == true) goto L7;
        WeakHandler r101 = this.f475003t;
        if (r101 == null) goto L7;
        r101.removeMessages(201);
    L7:
        VideoEngineCallback r102 = this.f474988e;
        if (r102 == null) goto L11;
        r102.onCompletion(r100);
        return;
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public final void onError(Error r100) {
        VideoEngineCallback r101 = this.f474988e;
        if (r101 == null) goto L6;
        r101.onError(r100);
        return;
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public final void onPrepare(TTVideoEngine r100) {
        VideoEngineCallback r101 = this.f474988e;
        if (r101 == null) goto L6;
        r101.onPrepare(r100);
        return;
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public final void onPrepared(TTVideoEngine r100) {
        LLog.d("VideoController", "onPrepared");
        this.f474996m = true;
        VideoEngineCallback r101 = this.f474988e;
        if (r101 == null) goto L6;
        r101.onPrepared(r100);
        return;
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public final void onReadyForDisplay(TTVideoEngine r100) {
        VideoEngineCallback r101 = this.f474988e;
        if (r101 == null) goto L6;
        r101.onReadyForDisplay(r100);
        return;
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public final void onRenderStart(TTVideoEngine r100) {
        VideoEngineCallback r101 = this.f474988e;
        if (r101 == null) goto L6;
        r101.onRenderStart(r100);
        return;
    }

    @Override // com.ss.ttvideoengine.VideoEngineInfoListener
    public final void onVideoEngineInfos(VideoEngineInfos r100) {
        VideoEngineInfoListener r101 = this.f474989f;
        if (r101 == null) goto L6;
        r101.onVideoEngineInfos(r100);
        return;
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public final void onVideoStatusException(int r100) {
        VideoEngineCallback r101 = this.f474988e;
        if (r101 == null) goto L6;
        r101.onVideoStatusException(r100);
        return;
    }

    public c(Context r100, g07.b r101) {
        this.f474985b = new Object();
        this.f474994k = -1;
        this.f474995l = false;
        this.f474996m = false;
        this.f474997n = false;
        this.f474998o = false;
        this.f474999p = false;
        this.f475000q = false;
        this.f475001r = new C5844c(this);
        this.f475002s = new d(this);
        this.f475003t = new WeakHandler(this.f475002s);
        this.f474986c = r100;
        this.f474987d = r101;
        this.f474992i = new PlaybackParams();
    }

    public static void a(c r100, boolean r101) {
        r100.getClass();
        if (r101 == false) goto L5;
        String r102 = "done";
    L6:
        LLog.d("VideoController", "seek_complete:".concat(r102));
        r100.f474993j.a();
        if (r100.c() == false) goto L12;
        WeakHandler r103 = r100.f475003t;
        if (r103 == null) goto L13;
        r103.sendEmptyMessage(201);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r102 = "fail";
        goto L6
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public final void onABRPredictBitrate(int r100, int r101) {
        VideoEngineCallback r102 = this.f474988e;
        if (r102 == null) goto L6;
        r102.onABRPredictBitrate(r100, r101);
        return;
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public final void onBufferingUpdate(TTVideoEngine r100, int r101) {
        VideoEngineCallback r102 = this.f474988e;
        if (r102 == null) goto L6;
        r102.onBufferingUpdate(r100, r101);
        return;
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public final void onCurrentPlaybackTimeUpdate(TTVideoEngine r100, int r101) {
        VideoEngineCallback r102 = this.f474988e;
        if (r102 == null) goto L6;
        r102.onCurrentPlaybackTimeUpdate(r100, r101);
        return;
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public final void onFrameDraw(int r100, Map r101) {
        VideoEngineCallback r102 = this.f474988e;
        if (r102 == null) goto L6;
        r102.onFrameDraw(r100, r101);
        return;
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public final void onLoadStateChanged(TTVideoEngine r100, int r101) {
        LLog.d("VideoController", "onLoadStateChanged:" + r101);
        if (r101 != 1) goto L5;
        LLog.d("VideoController", "load_state_changed -> playable");
        LLog.d("VideoController", "onBufferEnd");
    L12:
        VideoEngineCallback r102 = this.f474988e;
        if (r102 == null) goto L16;
        r102.onLoadStateChanged(r100, r101);
        return;
    L16:
        return;
    L5:
        if (r101 != 2) goto L7;
        LLog.d("VideoController", "load_state_changed -> stalled");
        LLog.d("VideoController", "onBufferStart");
        goto L12
    L7:
        if (r101 != 3) goto L12;
        LLog.d("VideoController", "load_state_changed -> error");
        goto L12
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public final void onPlaybackStateChanged(TTVideoEngine r100, int r101) {
        if (r101 != 0) goto L5;
        LLog.d("VideoController", "play_back_state_changed -> stopped");
    L22:
        VideoEngineCallback r102 = this.f474988e;
        if (r102 == null) goto L26;
        r102.onPlaybackStateChanged(r100, r101);
        return;
    L26:
        return;
    L5:
        if (r101 != 1) goto L7;
        LLog.d("VideoController", "play_back_state_changed -> playing");
        WeakHandler r103 = this.f475003t;
        if (r103 == null) goto L18;
        r103.sendEmptyMessage(201);
    L18:
        e r104 = this.f474993j;
        if (r104 == null) goto L22;
        r104.onVideoPlay();
        goto L22
    L7:
        if (r101 != 2) goto L9;
        LLog.d("VideoController", "play_back_state_changed -> paused");
        goto L22
    L9:
        if (r101 != 3) goto L22;
        LLog.d("VideoController", "play_back_state_changed -> error");
        WeakHandler r105 = this.f475003t;
        if (r105 == null) goto L22;
        r105.removeMessages(201);
        goto L22
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public final void onSARChanged(int r100, int r101) {
        VideoEngineCallback r102 = this.f474988e;
        if (r102 == null) goto L6;
        r102.onSARChanged(r100, r101);
        return;
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public final void onStreamChanged(TTVideoEngine r100, int r101) {
        VideoEngineCallback r102 = this.f474988e;
        if (r102 == null) goto L6;
        r102.onStreamChanged(r100, r101);
        return;
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public final void onVideoStreamBitrateChanged(Resolution r100, int r101) {
        LLog.d("VideoController", "onVideoStreamBitrateChanged ->" + r100.toString(VideoRef.TYPE_VIDEO));
        VideoEngineCallback r102 = this.f474988e;
        if (r102 == null) goto L6;
        r102.onVideoStreamBitrateChanged(r100, r101);
        return;
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public final void onVideoURLRouteFailed(Error r100, String r101) {
        VideoEngineCallback r102 = this.f474988e;
        if (r102 == null) goto L6;
        r102.onVideoURLRouteFailed(r100, r101);
        return;
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public final void onBufferStart(int r100, int r101, int r102) {
        VideoEngineCallback r103 = this.f474988e;
        if (r103 == null) goto L6;
        r103.onBufferStart(r100, r101, r102);
        return;
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public final void onVideoSizeChanged(TTVideoEngine r100, int r101, int r102) {
        this.f474993j.onVideoSizeChanged(r101, r102);
        VideoEngineCallback r103 = this.f474988e;
        if (r103 == null) goto L6;
        r103.onVideoSizeChanged(r100, r101, r102);
        return;
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public final void onFrameAboutToBeRendered(TTVideoEngine r100, int r110, long r111, long r112, Map<Integer, String> r113) {
        VideoEngineCallback r101 = this.f474988e;
        if (r101 == null) goto L6;
        r101.onFrameAboutToBeRendered(r100, r110, r111, r112, r113);
        return;
    }
}
