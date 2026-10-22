package com.lynx.clay.embedding.engine.plugins.video;

import android.content.Context;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineInfoListener;
import com.ss.ttvideoengine.VideoEngineInfos;
import com.ss.ttvideoengine.VideoEngineSimpleCallback;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.model.VideoRef;
import com.ss.ttvideoengine.utils.Error;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class b implements com.lynx.clay.embedding.engine.plugins.video.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f380893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.lynx.clay.embedding.engine.plugins.video.a.InterfaceC4551a f380894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TTVideoEngine f380895c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f380896d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f380897e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f380898f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f380899g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f380900h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f380901i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f380902j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f380903k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f380904l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public double f380905m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f380906n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f380907o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f380908p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f380909q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f380910r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final a f380911s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final C4552b f380912t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public c f380913u;

    public class a extends VideoEngineSimpleCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f380914a;

        public a(b r100) {
            this.f380914a = r100;
        }

        @Override // com.ss.ttvideoengine.VideoEngineSimpleCallback, com.ss.ttvideoengine.VideoEngineCallback
        public final void onBufferEnd(int r100) {
            c5a.c.c("VideoEngineTTImpl", "onBufferEnd code = " + r100);
            this.f380914a.f380894b.onPlaying();
        }

        @Override // com.ss.ttvideoengine.VideoEngineSimpleCallback, com.ss.ttvideoengine.VideoEngineCallback
        public final void onCompletion(TTVideoEngine r100) {
            c5a.c.c("VideoEngineTTImpl", "onCompletion");
            this.f380914a.f380894b.onEnded();
        }

        @Override // com.ss.ttvideoengine.VideoEngineSimpleCallback, com.ss.ttvideoengine.VideoEngineCallback
        public final void onError(Error r100) {
            c5a.c.c("VideoEngineTTImpl", "onError error = " + r100);
            b r101 = this.f380914a;
            r101.f380894b.onError(r100.code, r100.description, r101.f380896d);
        }

        @Override // com.ss.ttvideoengine.VideoEngineSimpleCallback, com.ss.ttvideoengine.VideoEngineCallback
        public final void onPrepare(TTVideoEngine r100) {
            c5a.c.c("VideoEngineTTImpl", "onPrepare");
        }

        @Override // com.ss.ttvideoengine.VideoEngineSimpleCallback, com.ss.ttvideoengine.VideoEngineCallback
        public final void onPrepared(TTVideoEngine r100) {
            c5a.c.c("VideoEngineTTImpl", "onPrepared");
            this.f380914a.f380894b.onPrepared(r100.getDuration());
            b r101 = this.f380914a;
            if (r101.f380909q == false) goto L16;
            r101.f380909q = false;
            int r102 = r101.f380907o;
            if (r102 <= 0) goto L7;
            r100.seekTo(r102, null);
        L7:
            b r103 = this.f380914a;
            if (r103.f380898f == false) goto L10;
        L15:
            r100.play();
            goto L16
        L10:
            if (r103.f380910r == true) goto L15;
            if (r100.isSystemPlayer() == false) goto L16;
            r100.pause();
        L16:
            this.f380914a.f380894b.onCanPlay();
        }

        @Override // com.ss.ttvideoengine.VideoEngineSimpleCallback, com.ss.ttvideoengine.VideoEngineCallback
        public final void onReadyForDisplay(TTVideoEngine r100) {
            c5a.c.c("VideoEngineTTImpl", "onReadyForDisplay");
        }

        @Override // com.ss.ttvideoengine.VideoEngineSimpleCallback, com.ss.ttvideoengine.VideoEngineCallback
        public final void onRenderStart(TTVideoEngine r100) {
            c5a.c.c("VideoEngineTTImpl", "onRenderStart");
            this.f380914a.f380894b.onFirstFrame();
        }

        @Override // com.ss.ttvideoengine.VideoEngineSimpleCallback, com.ss.ttvideoengine.VideoEngineCallback
        public final void onVideoStatusException(int r100) {
            c5a.c.c("VideoEngineTTImpl", "onVideoStatusException status = " + r100);
        }

        @Override // com.ss.ttvideoengine.VideoEngineSimpleCallback, com.ss.ttvideoengine.VideoEngineCallback
        public final void onABRPredictBitrate(int r100, int r101) {
            c5a.c.c("VideoEngineTTImpl", "onABRPredictBitrate mediaType = " + r100 + " , bitrate = " + r101);
        }

        @Override // com.ss.ttvideoengine.VideoEngineSimpleCallback, com.ss.ttvideoengine.VideoEngineCallback
        public final void onBufferingUpdate(TTVideoEngine r100, int r101) {
            c5a.c.c("VideoEngineTTImpl", "onBufferingUpdate percent = " + r101);
            this.f380914a.f380894b.onBufferingChange(r101);
        }

        @Override // com.ss.ttvideoengine.VideoEngineSimpleCallback, com.ss.ttvideoengine.VideoEngineCallback
        public final void onFrameDraw(int r100, Map r101) {
            c5a.c.c("VideoEngineTTImpl", "onFrameDraw frameCount = " + r100 + " , map = " + r101);
        }

        @Override // com.ss.ttvideoengine.VideoEngineSimpleCallback, com.ss.ttvideoengine.VideoEngineCallback
        public final void onLoadStateChanged(TTVideoEngine r100, int r101) {
            c5a.c.c("VideoEngineTTImpl", "onLoadStateChanged loadState = " + r101);
        }

        @Override // com.ss.ttvideoengine.VideoEngineSimpleCallback, com.ss.ttvideoengine.VideoEngineCallback
        public final void onPlaybackStateChanged(TTVideoEngine r100, int r101) {
            c5a.c.c("VideoEngineTTImpl", "onPlaybackStateChanged playbackState = " + r101);
            if (r101 != 1) goto L5;
            this.f380914a.f380894b.onPlay();
            return;
        L5:
            if (r101 != 2) goto L11;
            this.f380914a.f380894b.onPause();
            return;
        }

        @Override // com.ss.ttvideoengine.VideoEngineSimpleCallback, com.ss.ttvideoengine.VideoEngineCallback
        public final void onSARChanged(int r100, int r101) {
            c5a.c.c("VideoEngineTTImpl", "onSARChanged num = " + r100 + " , den = " + r101);
        }

        @Override // com.ss.ttvideoengine.VideoEngineSimpleCallback, com.ss.ttvideoengine.VideoEngineCallback
        public final void onStreamChanged(TTVideoEngine r100, int r101) {
            c5a.c.c("VideoEngineTTImpl", "onStreamChanged type = " + r101);
        }

        @Override // com.ss.ttvideoengine.VideoEngineSimpleCallback, com.ss.ttvideoengine.VideoEngineCallback
        public final void onVideoStreamBitrateChanged(Resolution r100, int r101) {
            c5a.c.c("VideoEngineTTImpl", "onVideoStreamBitrateChanged resolution = " + r100 + " , bitrate = " + r101);
        }

        @Override // com.ss.ttvideoengine.VideoEngineSimpleCallback, com.ss.ttvideoengine.VideoEngineCallback
        public final void onVideoURLRouteFailed(Error r100, String r101) {
            c5a.c.c("VideoEngineTTImpl", "onVideoURLRouteFailed error = " + r100 + " , url = " + r101);
        }

        @Override // com.ss.ttvideoengine.VideoEngineSimpleCallback, com.ss.ttvideoengine.VideoEngineCallback
        public final void onBufferStart(int r100, int r101, int r102) {
            c5a.c.c("VideoEngineTTImpl", "onBufferStart reason = " + r100 + " , afterFirstFrame = " + r101 + " , action = " + r102);
            this.f380914a.f380894b.onWaiting();
        }

        @Override // com.ss.ttvideoengine.VideoEngineSimpleCallback, com.ss.ttvideoengine.VideoEngineCallback
        public final void onVideoSizeChanged(TTVideoEngine r100, int r101, int r102) {
            c5a.c.c("VideoEngineTTImpl", "onVideoSizeChanged width = " + r101 + " , height = " + r102);
            this.f380914a.f380894b.onVideoSizeChanged(r101, r102);
        }
    }

    /* JADX INFO: renamed from: com.lynx.clay.embedding.engine.plugins.video.b$b, reason: collision with other inner class name */
    public class C4552b implements VideoEngineInfoListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f380915a;

        public C4552b(b r100) {
            this.f380915a = r100;
        }

        @Override // com.ss.ttvideoengine.VideoEngineInfoListener
        public final void onVideoEngineInfos(VideoEngineInfos r100) {
            this.f380915a.f380894b.onVideoInfos(r100.getUsingMDLPlayTaskKey(), r100.getUsingMDLHitCacheSize());
        }
    }

    public interface c {
        void a(TTVideoEngine r100);

        void b(TTVideoEngine r100);

        void c();

        void d();

        void dispose();
    }

    public class d implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Surface f380916a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f380917b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f380918c;

        @Override // com.lynx.clay.embedding.engine.plugins.video.b.c
        public final void c() {
            TTVideoEngine r100 = this.f380918c.f380895c;
            if (r100 != null) goto L5;
        L9:
            this.f380917b = false;
            return;
        L5:
            if (this.f380917b == false) goto L9;
            if (r100.getPlaybackState() != 2) goto L9;
            this.f380918c.f380895c.play();
            goto L9
        }

        @Override // com.lynx.clay.embedding.engine.plugins.video.b.c
        public final void d() {
            TTVideoEngine r100 = this.f380918c.f380895c;
            if (r100 != null) goto L5;
        L7:
            this.f380917b = false;
            return;
        L5:
            if (r100.getPlaybackState() != 1) goto L7;
            this.f380918c.f380895c.pause();
            this.f380917b = true;
        }

        @Override // com.lynx.clay.embedding.engine.plugins.video.b.c
        public final void dispose() {
            a(this.f380918c.f380895c);
        }

        @Override // com.lynx.clay.embedding.engine.plugins.video.b.c
        public final void a(TTVideoEngine r100) {
            if (r100 == null) goto L5;
            r100.setIntOption(654, 0);
            r100.setSurfaceSync(null);
            return;
        }

        @Override // com.lynx.clay.embedding.engine.plugins.video.b.c
        public final void b(TTVideoEngine r100) {
            if (r100 == null) goto L5;
            r100.setIntOption(654, 1);
            r100.setSurfaceSync(this.f380916a);
            return;
        }

        public d(b r100, Surface r101) {
            this.f380918c = r100;
            this.f380917b = false;
            this.f380916a = r101;
        }
    }

    public class e implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f380919a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f380920b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f380921c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final SurfaceHolder f380922d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final a f380923e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ b f380924f;

        public class a implements SurfaceHolder.Callback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f380925a;

            public a(e r100) {
                this.f380925a = r100;
            }

            @Override // android.view.SurfaceHolder.Callback
            public final void surfaceCreated(SurfaceHolder r100) {
                c5a.c.c("VideoEngineTTImpl", String.format("surfaceCreated createEngineForNewSurface=%b lastPlaying=%b lastPlaybackTime=%d", new Object[]{Boolean.valueOf(this.f380925a.f380921c), Boolean.valueOf(this.f380925a.f380919a), Integer.valueOf(this.f380925a.f380920b)}));
                e r101 = this.f380925a;
                if (r101.f380921c == false) goto L6;
                r101.f380924f.k();
                return;
            }

            @Override // android.view.SurfaceHolder.Callback
            public final void surfaceDestroyed(SurfaceHolder r100) {
                boolean r101 = false;
                c5a.c.c("VideoEngineTTImpl", String.format("surfaceDestroyed createEngineForNewSurface=%b lastPlaying=%b lastPlaybackTime=%d", new Object[]{Boolean.valueOf(this.f380925a.f380921c), Boolean.valueOf(this.f380925a.f380919a), Integer.valueOf(this.f380925a.f380920b)}));
                TTVideoEngine r102 = this.f380925a.f380924f.f380895c;
                if (r102 != null) goto L6;
                return;
            L6:
                if (r102.getPlaybackState() != 1) goto L8;
            L11:
                e r103 = this.f380925a;
                r103.f380920b = r103.f380924f.f380895c.getIntOption(52);
            L12:
                e r104 = this.f380925a;
                if (r104.f380924f.f380895c.getPlaybackState() != 1) goto L15;
                r101 = true;
            L15:
                r104.f380919a = r101;
                this.f380925a.f380924f.f380895c.release();
                e r105 = this.f380925a;
                r105.f380924f.f380895c = null;
                r105.f380921c = true;
                return;
            L8:
                if (this.f380925a.f380924f.f380895c.getPlaybackState() == 2) goto L11;
                this.f380925a.f380920b = -1;
                goto L12
            }

            @Override // android.view.SurfaceHolder.Callback
            public final void surfaceChanged(SurfaceHolder r100, int r101, int r102, int r103) {
                c5a.c.c("VideoEngineTTImpl", "surfaceChanged width=" + r102 + ", height=" + r103);
                TTVideoEngine r104 = this.f380925a.f380924f.f380895c;
                if (r104 == null) goto L6;
                r104.setSurfaceHolderSync(r100);
                return;
            }
        }

        @Override // com.lynx.clay.embedding.engine.plugins.video.b.c
        public final void c() {
        }

        @Override // com.lynx.clay.embedding.engine.plugins.video.b.c
        public final void d() {
        }

        @Override // com.lynx.clay.embedding.engine.plugins.video.b.c
        public final void dispose() {
            a(this.f380924f.f380895c);
            this.f380922d.removeCallback(this.f380923e);
        }

        @Override // com.lynx.clay.embedding.engine.plugins.video.b.c
        public final void a(TTVideoEngine r100) {
            if (r100 == null) goto L5;
            r100.setSurfaceHolderSync(null);
            return;
        }

        @Override // com.lynx.clay.embedding.engine.plugins.video.b.c
        public final void b(TTVideoEngine r100) {
            if (r100 == null) goto L12;
            r100.setSurfaceHolderSync(this.f380922d);
            TTVideoEngine r101 = this.f380924f.f380895c;
            if (r101 != null) goto L7;
            return;
        L7:
            if (this.f380921c == false) goto L13;
            this.f380921c = false;
            int r102 = this.f380920b;
            if (r102 == (-1)) goto L14;
            r101.seekTo(r102, new com.lynx.clay.embedding.engine.plugins.video.c(this));
            this.f380920b = -1;
            return;
        L14:
            return;
        L13:
            return;
        }

        public e(b r100, SurfaceHolder r101) {
            this.f380924f = r100;
            this.f380919a = false;
            this.f380920b = -1;
            this.f380921c = false;
            a r102 = new a(this);
            this.f380923e = r102;
            this.f380922d = r101;
            r101.addCallback(r102);
        }
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void a() {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void e() {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void g() {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void c() {
        c r100 = this.f380913u;
        if (r100 == null) goto L6;
        r100.dispose();
        this.f380913u = null;
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void d() {
        if (this.f380897e == false) goto L5;
        k();
        this.f380897e = false;
        return;
    L5:
        l();
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void dispose() {
        TTVideoEngine r100 = this.f380895c;
        if (r100 == null) goto L8;
        r100.setVideoEngineSimpleCallback(null);
        if (this.f380895c.getPlaybackState() != 1) goto L7;
        this.f380895c.stop();
    L7:
        this.f380895c.releaseAsync();
        this.f380895c = null;
    L8:
        c r101 = this.f380913u;
        if (r101 == null) goto L12;
        r101.dispose();
        this.f380913u = null;
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void enterBackground() {
        c r100 = this.f380913u;
        if (r100 == null) goto L6;
        r100.d();
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void enterForeground() {
        c r100 = this.f380913u;
        if (r100 == null) goto L6;
        r100.c();
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final int getDuration() {
        TTVideoEngine r100 = this.f380895c;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getDuration();
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final int getPosition() {
        TTVideoEngine r100 = this.f380895c;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getIntOption(52);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void k() {
        boolean r100 = false;
        TTVideoEngine r101 = this.f380895c;     // Catch: Throwable -> L13
        if (r101 != null) goto L6;
    L11:
        TTVideoEngine r102 = new TTVideoEngine(this.f380893a.getApplicationContext(), 0);     // Catch: Throwable -> L13
        this.f380895c = r102;     // Catch: Throwable -> L13
        r102.isSystemPlayer();     // Catch: Throwable -> L13
    L16:
        if (this.f380895c == null) goto L18;
    L17:
        boolean r103 = true;
    L19:
        if (r103 == false) goto L52;
        this.f380895c.setIntOption(160, this.f380904l ? 1 : 0);
        this.f380895c.setIntOption(21, 1);
        this.f380895c.setIntOption(7, 1);
        this.f380895c.setIntOption(415, 1);
        this.f380895c.setIntOption(42068, 1);
        TTVideoEngine.setIntValue(1163, 1);
        this.f380895c.setVideoEngineSimpleCallback(this.f380911s);
        this.f380895c.setVideoEngineInfoListener(this.f380912t);
        l();
        if (this.f380895c == null) goto L44;
        String r104 = this.f380896d;
        if (r104 != null) goto L26;
    L43:
        this.f380895c.setDirectURL("");
        goto L44
    L26:
        if (r104.isEmpty() == true) goto L43;
        if (this.f380896d.startsWith("{") == true) goto L50;
        String r105 = this.f380896d;
        if (r105.startsWith("http://") == false) goto L37;
    L38:
        r100 = true;
    L39:
        if (r100 == false) goto L41;
        this.f380895c.setDirectUrlUseDataLoader(this.f380896d, this.f380903k);
    L42:
        this.f380895c.prepare();
        goto L44
    L41:
        this.f380895c.setLocalURL(this.f380896d);
        goto L42
    L37:
        if (r105.startsWith("https://") == false) goto L39;
    L50:
        VideoRef r106 = new VideoRef();     // Catch: Throwable -> L32
        r106.extractFields(new JSONObject(this.f380896d));     // Catch: Throwable -> L32
        VideoModel r107 = new VideoModel();     // Catch: Throwable -> L32
        r107.setVideoRef(r106);     // Catch: Throwable -> L32
        this.f380895c.setVideoModel(r107);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        c5a.c.d(6, "VideoEngineTTImpl", "Load VideoModel failed");
        th.printStackTrace();
        this.f380895c.setDirectURL("");
    L44:
        c r108 = this.f380913u;
        if (r108 == null) goto L53;
        r108.b(this.f380895c);
        return;
    L53:
        return;
    L52:
        return;
    L18:
        r103 = false;
        goto L19
    L6:
        if (this.f380908p == true) goto L17;
        r101.setListener(null);     // Catch: Throwable -> L13
        c r109 = this.f380913u;     // Catch: Throwable -> L13
        if (r109 == null) goto L10;
        r109.a(this.f380895c);     // Catch: Throwable -> L13
    L10:
        this.f380895c.release();     // Catch: Throwable -> L13
        this.f380895c = null;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        c5a.c.d(6, "VideoEngineTTImpl", "VideoEngine create " + th.toString());
        this.f380895c = null;
        goto L16
    }

    public final void l() {
        TTVideoEngine r100 = this.f380895c;
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.f380900h == false) goto L9;
        r100.setIsMute(this.f380899g);
        this.f380900h = false;
    L9:
        if (this.f380902j == false) goto L12;
        this.f380895c.setLooping(this.f380901i);
        this.f380902j = false;
    L12:
        if (this.f380906n == false) goto L15;
        float r101 = ((float) this.f380905m) * this.f380895c.getMaxVolume();
        this.f380895c.setVolume(r101, r101);
        this.f380906n = false;
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void pause() {
        c5a.c.c("VideoEngineTTImpl", "pause");
        this.f380910r = false;
        TTVideoEngine r100 = this.f380895c;
        if (r100 == null) goto L6;
        r100.pause();
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void play() {
        c5a.c.c("VideoEngineTTImpl", "play");
        this.f380910r = true;
        TTVideoEngine r100 = this.f380895c;
        if (r100 == null) goto L6;
        r100.play();
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void stop() {
        c5a.c.c("VideoEngineTTImpl", "stop");
        this.f380910r = false;
        TTVideoEngine r100 = this.f380895c;
        if (r100 == null) goto L6;
        r100.stop();
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void b(boolean r100) {
        c5a.c.c("VideoEngineTTImpl", "setAutoplay " + r100);
        this.f380898f = r100;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final View createView(Context r100) {
        c r101 = this.f380913u;
        if (r101 == null) goto L5;
        r101.dispose();
        this.f380913u = null;
    L5:
        SurfaceView r102 = new SurfaceView(r100);
        r102.setZOrderOnTop(false);
        e r103 = new e(this, r102.getHolder());
        this.f380913u = r103;
        TTVideoEngine r104 = this.f380895c;
        if (r104 == null) goto L8;
        r103.b(r104);
    L8:
        return r102;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void f(boolean r100) {
        c5a.c.c("VideoEngineTTImpl", "setCache " + r100);
        this.f380904l = r100;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void h(int r100) {
        c5a.c.c("VideoEngineTTImpl", "setInitTime " + r100);
        this.f380907o = r100;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void i(String r100) {
        c5a.c.c("VideoEngineTTImpl", "setPreloadKey " + r100);
        this.f380903k = r100;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void j(boolean r100) {
        this.f380908p = r100;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void seekTo(int r100) {
        c5a.c.c("VideoEngineTTImpl", "seekTo " + r100);
        TTVideoEngine r101 = this.f380895c;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getPlaybackState() != 0) goto L7;
        this.f380895c.play();
    L7:
        this.f380895c.seekTo(r100, null);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void setLoop(boolean r100) {
        c5a.c.c("VideoEngineTTImpl", "setLoop " + r100);
        this.f380901i = r100;
        this.f380902j = true;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void setMuted(boolean r100) {
        c5a.c.c("VideoEngineTTImpl", "setMuted " + r100);
        this.f380899g = r100;
        this.f380900h = true;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void setSpeed(float r100) {
        c5a.c.c("VideoEngineTTImpl", "setSpeed " + r100);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void setSrc(String r100) {
        c5a.c.c("VideoEngineTTImpl", "setSrc " + r100);
        if (TextUtils.equals(this.f380896d, r100) == false) goto L5;
    L10:
        boolean r101 = false;
    L11:
        if (r101 == false) goto L14;
        this.f380909q = true;
        this.f380897e = true;
        return;
    L14:
        return;
    L5:
        if (TextUtils.isEmpty(this.f380896d) == true) goto L7;
    L9:
        this.f380896d = r100;
        r101 = true;
        goto L11
    L7:
        if (TextUtils.isEmpty(r100) == false) goto L9;
        goto L9
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void setSurface(Surface r100) {
        c r101 = this.f380913u;
        if (r101 == null) goto L5;
        r101.dispose();
        this.f380913u = null;
    L5:
        if (r100 == null) goto L10;
        d r102 = new d(this, r100);
        this.f380913u = r102;
        TTVideoEngine r103 = this.f380895c;
        if (r103 == null) goto L11;
        r102.b(r103);
        return;
    L11:
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void setVolume(double r100) {
        c5a.c.c("VideoEngineTTImpl", "setVolume " + r100);
        this.f380905m = r100;
        this.f380906n = true;
    }

    public b(Context r100, com.lynx.clay.embedding.engine.plugins.video.a.InterfaceC4551a r101) {
        this.f380897e = false;
        this.f380898f = false;
        this.f380899g = false;
        this.f380900h = false;
        this.f380901i = false;
        this.f380902j = false;
        this.f380904l = true;
        this.f380905m = 1.0d;
        this.f380906n = false;
        this.f380907o = -1;
        this.f380908p = true;
        this.f380909q = true;
        this.f380910r = false;
        this.f380911s = new a(this);
        this.f380912t = new C4552b(this);
        this.f380893a = r100;
        this.f380894b = r101;
    }
}
