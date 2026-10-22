package com.lynx.clay.embedding.engine.plugins.video;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import fna.g;
import java.io.IOException;

/* JADX INFO: loaded from: classes32.dex */
public final class VideoEngineMPImpl implements com.lynx.clay.embedding.engine.plugins.video.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.lynx.clay.embedding.engine.plugins.video.a.InterfaceC4551a f380862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f380863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f380864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f380865d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f380866e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f380867f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public double f380868g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f380869h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f380870i;

    public static final enum MediaPlayerState extends Enum<MediaPlayerState> {
        public static final MediaPlayerState ERROR = null;
        public static final MediaPlayerState IDLE = null;
        public static final MediaPlayerState INITIALIZED = null;
        public static final MediaPlayerState PAUSED = null;
        public static final MediaPlayerState PLAYBACK_COMPLETED = null;
        public static final MediaPlayerState PREPARED = null;
        public static final MediaPlayerState PREPARING = null;
        public static final MediaPlayerState STARTED = null;
        public static final MediaPlayerState STOPPED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MediaPlayerState[] f380871a = null;

        static {
            MediaPlayerState r100 = new MediaPlayerState("ERROR", 0);
            ERROR = r100;
            MediaPlayerState r101 = new MediaPlayerState("IDLE", 1);
            IDLE = r101;
            MediaPlayerState r102 = new MediaPlayerState("INITIALIZED", 2);
            INITIALIZED = r102;
            MediaPlayerState r103 = new MediaPlayerState("PREPARING", 3);
            PREPARING = r103;
            MediaPlayerState r104 = new MediaPlayerState("PREPARED", 4);
            PREPARED = r104;
            MediaPlayerState r105 = new MediaPlayerState("STARTED", 5);
            STARTED = r105;
            MediaPlayerState r110 = new MediaPlayerState("PAUSED", 6);
            PAUSED = r110;
            MediaPlayerState r111 = new MediaPlayerState("STOPPED", 7);
            STOPPED = r111;
            MediaPlayerState r112 = new MediaPlayerState("PLAYBACK_COMPLETED", 8);
            PLAYBACK_COMPLETED = r112;
            f380871a = new MediaPlayerState[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
        }

        public static MediaPlayerState[] values() {
            return (MediaPlayerState[]) f380871a.clone();
        }

        public static MediaPlayerState valueOf(String r100) {
            return (MediaPlayerState) r27.a.a(MediaPlayerState.class, r100);
        }

        public MediaPlayerState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum PendingAction extends Enum<PendingAction> {
        public static final PendingAction NONE = null;
        public static final PendingAction PAUSE = null;
        public static final PendingAction PLAY = null;
        public static final PendingAction STOP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PendingAction[] f380872a = null;

        static {
            PendingAction r100 = new PendingAction(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            PendingAction r101 = new PendingAction(FeatureConfigInfo.PLAY_FEATURE_TYPE_ID, 1);
            PLAY = r101;
            PendingAction r102 = new PendingAction("PAUSE", 2);
            PAUSE = r102;
            PendingAction r103 = new PendingAction("STOP", 3);
            STOP = r103;
            f380872a = new PendingAction[]{r100, r101, r102, r103};
        }

        public static PendingAction[] values() {
            return (PendingAction[]) f380872a.clone();
        }

        public static PendingAction valueOf(String r100) {
            return (PendingAction) r27.a.a(PendingAction.class, r100);
        }

        public PendingAction(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f380873a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f380874b = null;

        static {
            int[] r100 = new int[MediaPlayerState.values().length];
            f380874b = r100;
            r100[MediaPlayerState.ERROR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L32:
            f380874b[MediaPlayerState.PREPARING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L38:
            f380874b[MediaPlayerState.PREPARED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L54:
            f380874b[MediaPlayerState.STARTED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L34:
            f380874b[MediaPlayerState.PAUSED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L24
        L40:
            f380874b[MediaPlayerState.PLAYBACK_COMPLETED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L25
        L44:
            f380874b[MediaPlayerState.STOPPED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L26
        L48:
            f380874b[MediaPlayerState.IDLE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L27
        L14:
            int[] r101 = new int[PendingAction.values().length];
            f380873a = r101;
            r101[PendingAction.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L28
        L42:
            f380873a[PendingAction.PLAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L29
        L46:
            f380873a[PendingAction.PAUSE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L30
        L36:
            f380873a[PendingAction.STOP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L31
            return;
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MediaPlayer f380875a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a f380876b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public MediaPlayerState f380877c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public PendingAction f380878d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f380879e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f380880f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f380881g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ VideoEngineMPImpl f380882h;

        public class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnSeekCompleteListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f380883a;

            public a(b r100) {
                this.f380883a = r100;
            }

            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer r100) {
                c5a.c.d(6, "VideoEngineMPImpl", "onCompletion");
                b r101 = this.f380883a;
                r101.f380877c = MediaPlayerState.PLAYBACK_COMPLETED;
                r101.f380882h.f380862a.onEnded();
            }

            @Override // android.media.MediaPlayer.OnPreparedListener
            public final void onPrepared(MediaPlayer r100) {
                c5a.c.d(6, "VideoEngineMPImpl", "onPrepared");
                b r101 = this.f380883a;
                r101.f380877c = MediaPlayerState.PREPARED;
                if (r101.f380879e < 0) goto L5;
                c5a.c.d(6, "VideoEngineMPImpl", "do pending: seek " + this.f380883a.f380879e);
                r100.seekTo(this.f380883a.f380879e);
                this.f380883a.f380879e = -1;
            L5:
                int r102 = a.f380873a[this.f380883a.f380878d.ordinal()];
                if (r102 != 2) goto L8;
                c5a.c.d(6, "VideoEngineMPImpl", "do pending: play");
                if (g.d() == true) goto L29;
                r100.start();
            L30:
                this.f380883a.f380882h.f380862a.onPlay();
                this.f380883a.f380877c = MediaPlayerState.STARTED;
            L31:
                b r103 = this.f380883a;
                r103.f380878d = PendingAction.NONE;
                r103.f380882h.f380862a.onPrepared(r100.getDuration());
                this.f380883a.f380882h.f380862a.onCanPlay();
                return;
            L29:
                r100.start();
                gna.a.c(r100.hashCode());
                goto L30
            L8:
                if (r102 != 3) goto L10;
                c5a.c.d(6, "VideoEngineMPImpl", "do pending: pause");
                if (g.d() == true) goto L20;
                r100.start();
            L22:
                if (g.d() == true) goto L24;
                r100.pause();
            L25:
                this.f380883a.f380882h.f380862a.onPause();
                this.f380883a.f380877c = MediaPlayerState.PAUSED;
                goto L31
            L24:
                r100.pause();
                gna.a.a(r100.hashCode());
                goto L25
            L20:
                r100.start();
                gna.a.c(r100.hashCode());
                goto L22
            L10:
                if (r102 != 4) goto L31;
                c5a.c.d(6, "VideoEngineMPImpl", "do pending: stop");
                if (g.d() == true) goto L15;
                r100.stop();
            L16:
                this.f380883a.f380877c = MediaPlayerState.STOPPED;
                goto L31
            L15:
                r100.stop();
                gna.a.a(r100.hashCode());
                goto L16
            }

            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public final void onSeekComplete(MediaPlayer r100) {
                c5a.c.d(6, "VideoEngineMPImpl", "onSeekComplete");
            }

            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public final void onBufferingUpdate(MediaPlayer r100, int r101) {
                c5a.c.d(6, "VideoEngineMPImpl", "onBufferingUpdate percent=" + r101);
                this.f380883a.f380882h.f380862a.onBufferingChange(r101);
            }

            @Override // android.media.MediaPlayer.OnErrorListener
            public final boolean onError(MediaPlayer r100, int r101, int r102) {
                c5a.c.d(6, "VideoEngineMPImpl", "onError what=" + r101 + ", extra=" + r102);
                b r103 = this.f380883a;
                r103.f380877c = MediaPlayerState.ERROR;
                VideoEngineMPImpl r104 = r103.f380882h;
                com.lynx.clay.embedding.engine.plugins.video.a.InterfaceC4551a r105 = r104.f380862a;
                r104.getClass();
                if (r101 != (-1010)) goto L5;
                String r106 = "MediaPlayer is unsupported.";
            L23:
                r105.onError(r101, r106, this.f380883a.f380882h.f380864c);
                return true;
            L5:
                if (r101 != (-1007)) goto L7;
                r106 = "MediaPlayer malformed error.";
                goto L23
            L7:
                if (r101 != (-1004)) goto L9;
                r106 = "MediaPlayer io error";
                goto L23
            L9:
                if (r101 == (-110)) goto L19;
                if (r101 != 1) goto L12;
                r106 = "MediaPlayer has a unspecified error.";
                goto L23
            L12:
                if (r101 != 100) goto L14;
                r106 = "MediaPlayer server died.";
                goto L23
            L14:
                if (r101 == 200) goto L16;
                r106 = "";
                goto L23
            L16:
                r106 = "MediaPlayer is not valid for progressive playback.";
                goto L23
            L19:
                r106 = "Media Player is time out when playing media.";
                goto L23
            }

            @Override // android.media.MediaPlayer.OnInfoListener
            public final boolean onInfo(MediaPlayer r100, int r101, int r102) {
                if (r101 != 1) goto L5;
                c5a.c.d(6, "VideoEngineMPImpl", "onInfo UNKNOWN");
                return false;
            L5:
                if (r101 == 3) goto L15;
                switch(r101) {
                    case 700: goto L14;
                    case 701: goto L13;
                    case 702: goto L12;
                    default: goto L7;
                };
            L7:
                switch(r101) {
                    case 800: goto L11;
                    case 801: goto L10;
                    case 802: goto L9;
                    default: goto L26;
                };
            L9:
                c5a.c.d(6, "VideoEngineMPImpl", "onInfo Metadata update");
                return false;
            L10:
                c5a.c.d(6, "VideoEngineMPImpl", "onInfo Not seekable");
                return false;
            L11:
                c5a.c.d(6, "VideoEngineMPImpl", "onInfo Bad interleaving");
                return false;
            L26:
                return false;
            L12:
                c5a.c.d(6, "VideoEngineMPImpl", "onInfo Buffering end");
                this.f380883a.f380882h.f380862a.onPlaying();
                return false;
            L13:
                c5a.c.d(6, "VideoEngineMPImpl", "onInfo Buffering start");
                this.f380883a.f380882h.f380862a.onWaiting();
                return false;
            L14:
                c5a.c.d(6, "VideoEngineMPImpl", "onInfo Video track lagging");
                return false;
            L15:
                c5a.c.d(6, "VideoEngineMPImpl", "onInfo Rendering start");
                return false;
            }

            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public final void onVideoSizeChanged(MediaPlayer r100, int r101, int r102) {
                c5a.c.d(6, "VideoEngineMPImpl", "onVideoSizeChanged width=" + r101 + ", height=" + r102);
                this.f380883a.f380882h.f380862a.onVideoSizeChanged(r101, r102);
            }
        }

        public final void c() {
            if (this.f380875a != null) goto L8;
            MediaPlayer r100 = new MediaPlayer();
            this.f380875a = r100;
            r100.setOnBufferingUpdateListener(this.f380876b);
            this.f380875a.setOnInfoListener(this.f380876b);
            this.f380875a.setOnPreparedListener(this.f380876b);
            this.f380875a.setOnVideoSizeChangedListener(this.f380876b);
            this.f380875a.setOnErrorListener(this.f380876b);
            this.f380875a.setOnCompletionListener(this.f380876b);
            this.f380875a.setOnSeekCompleteListener(this.f380876b);
            c r101 = this.f380882h.f380863b;
            if (r101 == null) goto L7;
            r101.a(this.f380875a);
        L7:
            this.f380877c = MediaPlayerState.IDLE;
        L8:
            MediaPlayerState r102 = this.f380877c;
            MediaPlayerState r103 = MediaPlayerState.IDLE;
            if (r102 == r103) goto L11;
            this.f380875a.reset();
            this.f380877c = r103;
        L11:
            d();
            this.f380875a.setDataSource(this.f380882h.f380864c);     // Catch: IOException -> L25
            this.f380877c = MediaPlayerState.INITIALIZED;     // Catch: IOException -> L25
            this.f380875a.prepareAsync();
            VideoEngineMPImpl r104 = this.f380882h;
            if (r104.f380865d == true) goto L16;
        L18:
            int r105 = r104.f380869h;
            if (r105 > 0) goto L21;
        L23:
            this.f380877c = MediaPlayerState.PREPARING;
            return;
        L21:
            if (this.f380879e != (-1)) goto L23;
            this.f380879e = r105;
            goto L23
        L16:
            if (this.f380878d != PendingAction.NONE) goto L18;
            this.f380878d = PendingAction.PLAY;
        L25:
            e = move-exception;
            e.printStackTrace();
            this.f380877c = MediaPlayerState.ERROR;
            VideoEngineMPImpl r106 = this.f380882h;
            r106.f380862a.onError(-1, "", r106.f380864c);
        }

        public final void d() {
            MediaPlayer r100 = this.f380875a;
            if (r100 == null) goto L10;
            VideoEngineMPImpl r101 = this.f380882h;
            if (r101.f380866e == false) goto L7;
            float r102 = 0.0f;
        L8:
            r100.setVolume(r102, r102);
            this.f380875a.setLooping(this.f380882h.f380867f);
            return;
        L7:
            r102 = (float) r101.f380868g;
            goto L8
        }

        public b(VideoEngineMPImpl r100) {
            this.f380882h = r100;
            this.f380876b = new a(this);
            this.f380877c = MediaPlayerState.IDLE;
            this.f380878d = PendingAction.NONE;
            this.f380879e = -1;
            this.f380880f = false;
            this.f380881g = -1;
        }

        public static void a(MediaPlayer r100) {
            if (g.d() == true) goto L6;
            r100.pause();
            return;
        L6:
            r100.pause();
            gna.a.a(r100.hashCode());
        }

        public static void b(MediaPlayer r100) {
            if (g.d() == true) goto L6;
            r100.start();
            return;
        L6:
            r100.start();
            gna.a.c(r100.hashCode());
        }
    }

    public interface c {
        void a(MediaPlayer r100);

        void dispose();
    }

    public class d implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Surface f380884a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public MediaPlayer f380885b;

        @Override // com.lynx.clay.embedding.engine.plugins.video.VideoEngineMPImpl.c
        public final void dispose() {
            MediaPlayer r100 = this.f380885b;
            if (r100 == null) goto L6;
            r100.setSurface(null);
            this.f380885b = null;
            return;
        }

        public d(Surface r100) {
            this.f380884a = r100;
        }

        @Override // com.lynx.clay.embedding.engine.plugins.video.VideoEngineMPImpl.c
        public final void a(MediaPlayer r100) {
            this.f380885b = r100;
            r100.setSurface(this.f380884a);
        }
    }

    public class e implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SurfaceHolder f380886a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public MediaPlayer f380887b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f380888c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final a f380889d;

        public class a implements SurfaceHolder.Callback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f380890a;

            @Override // android.view.SurfaceHolder.Callback
            public final void surfaceChanged(SurfaceHolder r100, int r101, int r102, int r103) {
            }

            public a(e r100) {
                this.f380890a = r100;
            }

            @Override // android.view.SurfaceHolder.Callback
            public final void surfaceCreated(SurfaceHolder r100) {
                e r101 = this.f380890a;
                r101.f380888c = true;
                MediaPlayer r102 = r101.f380887b;
                if (r102 == null) goto L6;
                r102.setDisplay(r100);
                return;
            }

            @Override // android.view.SurfaceHolder.Callback
            public final void surfaceDestroyed(SurfaceHolder r100) {
                e r101 = this.f380890a;
                r101.f380888c = false;
                MediaPlayer r102 = r101.f380887b;
                if (r102 == null) goto L6;
                r102.setDisplay(null);
                return;
            }
        }

        @Override // com.lynx.clay.embedding.engine.plugins.video.VideoEngineMPImpl.c
        public final void dispose() {
            this.f380886a.removeCallback(this.f380889d);
            MediaPlayer r100 = this.f380887b;
            if (r100 == null) goto L6;
            r100.setDisplay(null);
            this.f380887b = null;
            return;
        }

        public e(SurfaceHolder r100) {
            this.f380888c = false;
            a r101 = new a(this);
            this.f380889d = r101;
            this.f380886a = r100;
            r100.addCallback(r101);
        }

        @Override // com.lynx.clay.embedding.engine.plugins.video.VideoEngineMPImpl.c
        public final void a(MediaPlayer r100) {
            this.f380887b = r100;
            if (this.f380888c == false) goto L6;
            r100.setDisplay(this.f380886a);
            return;
        }
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void a() {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final /* synthetic */ void d() {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void e() {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final /* synthetic */ void f(boolean r100) {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void g() {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final /* synthetic */ void i(String r100) {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final /* synthetic */ void j(boolean r100) {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final /* synthetic */ void setSpeed(float r100) {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void c() {
        c r100 = this.f380863b;
        if (r100 == null) goto L6;
        r100.dispose();
        this.f380863b = null;
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void dispose() {
        b r100 = this.f380870i;
        r100.getClass();
        c5a.c.d(6, "VideoEngineMPImpl", "release");
        MediaPlayer r101 = r100.f380875a;
        if (r101 == null) goto L6;
        r101.reset();
        r100.f380875a.release();
        r100.f380875a = null;
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void enterBackground() {
        b r100 = this.f380870i;
        MediaPlayer r101 = r100.f380875a;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isPlaying() == false) goto L9;
        r100.f380881g = r100.f380875a.getCurrentPosition();
        b.a(r100.f380875a);
        r100.f380877c = MediaPlayerState.PAUSED;
        r100.f380882h.f380862a.onPause();
        r100.f380880f = true;
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void enterForeground() {
        b r100 = this.f380870i;
        MediaPlayer r101 = r100.f380875a;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100.f380880f == true) goto L7;
    L12:
        r100.f380880f = false;
        r100.f380881g = -1;
        return;
    L7:
        if (r100.f380877c != MediaPlayerState.PAUSED) goto L12;
        int r102 = r100.f380881g;
        if (r102 < 0) goto L11;
        r101.seekTo(r102);
    L11:
        b.b(r100.f380875a);
        r100.f380877c = MediaPlayerState.STARTED;
        r100.f380882h.f380862a.onPlay();
        goto L12
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final int getDuration() {
        MediaPlayer r100 = this.f380870i.f380875a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getDuration();
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final int getPosition() {
        MediaPlayer r100 = this.f380870i.f380875a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getCurrentPosition();
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void pause() {
        b r100 = this.f380870i;
        r100.getClass();
        c5a.c.d(6, "VideoEngineMPImpl", "pause");
        if (r100.f380875a == null) goto L27;
        int r101 = a.f380874b[r100.f380877c.ordinal()];
        if (r101 != 1) goto L8;
        c5a.c.d(6, "VideoEngineMPImpl", "---- pause: setupEngine");
        r100.c();
        r100.f380878d = PendingAction.PAUSE;
        return;
    L8:
        if (r101 != 2) goto L10;
        c5a.c.d(6, "VideoEngineMPImpl", "---- pause: pending");
        r100.f380878d = PendingAction.PAUSE;
        return;
    L10:
        if (r101 != 3) goto L12;
    L19:
        c5a.c.d(6, "VideoEngineMPImpl", "---- pause: start + pause");
        b.b(r100.f380875a);
        b.a(r100.f380875a);
        r100.f380882h.f380862a.onPause();
        r100.f380877c = MediaPlayerState.PAUSED;
        return;
    L12:
        if (r101 == 4) goto L18;
        if (r101 == 6) goto L19;
        if (r101 != 7) goto L28;
        c5a.c.d(6, "VideoEngineMPImpl", "---- pause: prepare");
        r100.f380875a.prepareAsync();
        r100.f380877c = MediaPlayerState.PREPARING;
        r100.f380878d = PendingAction.PAUSE;
        return;
    L28:
        return;
    L18:
        c5a.c.d(6, "VideoEngineMPImpl", "---- pause: pause");
        b.a(r100.f380875a);
        r100.f380882h.f380862a.onPause();
        r100.f380877c = MediaPlayerState.PAUSED;
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void play() {
        b r100 = this.f380870i;
        r100.getClass();
        c5a.c.d(6, "VideoEngineMPImpl", "start");
        if (r100.f380875a != null) goto L6;
        return;
    L6:
        switch(a.f380874b[r100.f380877c.ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L9;
            case 7: goto L8;
            default: goto L17;
        };
    L8:
        c5a.c.d(6, "VideoEngineMPImpl", "---- start: prepare");
        r100.f380875a.prepareAsync();
        r100.f380877c = MediaPlayerState.PREPARING;
        r100.f380878d = PendingAction.PLAY;
        return;
    L9:
        c5a.c.d(6, "VideoEngineMPImpl", "---- start: start");
        b.b(r100.f380875a);
        r100.f380877c = MediaPlayerState.STARTED;
        r100.f380882h.f380862a.onPlay();
        return;
    L10:
        c5a.c.d(6, "VideoEngineMPImpl", "---- start: pending");
        r100.f380878d = PendingAction.PLAY;
        return;
    L11:
        c5a.c.d(6, "VideoEngineMPImpl", "---- start: setupEngine");
        r100.c();
        r100.f380878d = PendingAction.PLAY;
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void stop() {
        b r100 = this.f380870i;
        r100.getClass();
        c5a.c.d(6, "VideoEngineMPImpl", "stop");
        if (r100.f380875a == null) goto L23;
        int r101 = a.f380874b[r100.f380877c.ordinal()];
        if (r101 != 2) goto L8;
        c5a.c.d(6, "VideoEngineMPImpl", "---- stop: pending");
        r100.f380878d = PendingAction.STOP;
        return;
    L8:
        if (r101 != 3) goto L10;
    L15:
        c5a.c.d(6, "VideoEngineMPImpl", "---- stop: stop");
        MediaPlayer r102 = r100.f380875a;
        if (g.d() == true) goto L18;
        r102.stop();
    L19:
        r100.f380877c = MediaPlayerState.STOPPED;
        return;
    L18:
        r102.stop();
        gna.a.a(r102.hashCode());
        goto L19
    L10:
        if (r101 == 4) goto L15;
        if (r101 == 5) goto L15;
        if (r101 == 6) goto L15;
        return;
    }

    public VideoEngineMPImpl(com.lynx.clay.embedding.engine.plugins.video.a.InterfaceC4551a r100) {
        this.f380865d = false;
        this.f380866e = false;
        this.f380867f = false;
        this.f380868g = 1.0d;
        this.f380869h = -1;
        this.f380870i = new b(this);
        this.f380862a = r100;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void b(boolean r100) {
        this.f380865d = r100;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final View createView(Context r100) {
        c r101 = this.f380863b;
        if (r101 == null) goto L5;
        r101.dispose();
        this.f380863b = null;
    L5:
        SurfaceView r102 = new SurfaceView(r100);
        r102.setZOrderOnTop(false);
        e r103 = new e(r102.getHolder());
        this.f380863b = r103;
        MediaPlayer r104 = this.f380870i.f380875a;
        if (r104 == null) goto L8;
        r103.a(r104);
    L8:
        return r102;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void h(int r100) {
        this.f380869h = r100;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void seekTo(int r100) {
        b r101 = this.f380870i;
        r101.getClass();
        c5a.c.d(6, "VideoEngineMPImpl", "seekTo " + r100);
        if (r101.f380875a != null) goto L6;
        return;
    L6:
        switch(a.f380874b[r101.f380877c.ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L9;
            case 7: goto L8;
            default: goto L17;
        };
    L8:
        c5a.c.d(6, "VideoEngineMPImpl", "---- seekTo: prepare");
        r101.f380875a.prepareAsync();
        r101.f380877c = MediaPlayerState.PREPARING;
        r101.f380879e = r100;
        return;
    L9:
        c5a.c.d(6, "VideoEngineMPImpl", "---- seekTo: seekTo");
        r101.f380875a.seekTo(r100);
        return;
    L10:
        c5a.c.d(6, "VideoEngineMPImpl", "---- seekTo: pending");
        r101.f380879e = r100;
        return;
    L11:
        c5a.c.d(6, "VideoEngineMPImpl", "---- seekTo: setupEngine");
        r101.c();
        r101.f380879e = r100;
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void setLoop(boolean r100) {
        this.f380867f = r100;
        this.f380870i.d();
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void setMuted(boolean r100) {
        this.f380866e = r100;
        this.f380870i.d();
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void setSrc(String r100) {
        this.f380864c = r100;
        this.f380870i.c();
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void setSurface(Surface r100) {
        c r101 = this.f380863b;
        if (r101 == null) goto L5;
        r101.dispose();
        this.f380863b = null;
    L5:
        if (r100 == null) goto L10;
        d r102 = new d(r100);
        this.f380863b = r102;
        MediaPlayer r103 = this.f380870i.f380875a;
        if (r103 == null) goto L11;
        r102.a(r103);
        return;
    L11:
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void setVolume(double r100) {
        this.f380868g = r100;
        this.f380870i.d();
    }
}
