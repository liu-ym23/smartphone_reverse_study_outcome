package p58;

import android.media.AudioTrack;
import android.os.SystemClock;
import com.bytedance.flow_audio.api.tracer.TtsTracer;
import com.larus.audio.audiov3.audio.player.AudioPlayerErrorEnum;
import com.larus.audio.audiov3.audio.player.AudioPlayerState;
import fna.g;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import m58.h;
import m58.p;
import m58.t;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements q58.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q58.b f527798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile AudioPlayerState f527799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AudioTrack f527800c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public u58.a f527801d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f527802e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f527803f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TtsTracer f527804g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f527805h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f527806i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f527807j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b f527808k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f527809l;

    /* JADX INFO: renamed from: p58.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes24.dex */
    public /* synthetic */ class C7153a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f527810a = null;

        static {
            int[] r100 = new int[AudioPlayerState.values().length];
            r100[AudioPlayerState.STOPPED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[AudioPlayerState.PAUSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f527810a = r100;
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static final class b implements AudioTrack.OnPlaybackPositionUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f527811a;

        public b(a r100) {
            this.f527811a = r100;
        }

        @Override // android.media.AudioTrack.OnPlaybackPositionUpdateListener
        public final void onMarkerReached(AudioTrack r100) {
            TtsTracer r101 = this.f527811a.f527804g;
            if (r101 == null) goto L5;
            r101.playFirstFrame(true);
        L5:
            int r102 = c68.b.f22600a;
            this.f527811a.getClass();
            StringBuilder r103 = new StringBuilder();
            if (r100 == null) goto L8;
            int r104 = r100.hashCode();
        L9:
            r103.append(r104);
            r103.append(":onMarkerReached:");
            Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L16
            if (r100 == null) goto L13;
            Integer r106 = Integer.valueOf(r100.getPlaybackHeadPosition());     // Catch: Throwable -> L16
        L14:
            Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L16
        L18:
            r103.append(Result.m9457toStringimpl(r107));
            c68.b.d("TTSAudioPlayer", r103.toString());
            return;
        L13:
            r106 = null;
        L16:
            th = move-exception;
            Result.Companion r108 = Result.Companion;
            r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L18
        L8:
            r104 = 0;
            goto L9
        }

        @Override // android.media.AudioTrack.OnPlaybackPositionUpdateListener
        public final void onPeriodicNotification(AudioTrack r100) {
            int r101 = c68.b.f22600a;
            this.f527811a.getClass();
            StringBuilder r102 = new StringBuilder();
            if (r100 == null) goto L5;
            int r103 = r100.hashCode();
        L6:
            r102.append(r103);
            r102.append(":onPeriodicNotification:");
            Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L13
            if (r100 == null) goto L10;
            Integer r105 = Integer.valueOf(r100.getPlaybackHeadPosition());     // Catch: Throwable -> L13
        L11:
            Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L13
        L15:
            r102.append(Result.m9457toStringimpl(r106));
            c68.b.d("TTSAudioPlayer", r102.toString());
            return;
        L10:
            r105 = null;
        L13:
            th = move-exception;
            Result.Companion r107 = Result.Companion;
            r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L15
        L5:
            r103 = 0;
            goto L6
        }
    }

    @Override // q58.a
    public final boolean d() {
        if (this.f527809l != 0) goto L23;
        int r100 = this.f527803f;
        u58.a r101 = this.f527801d;
        int r102 = 2;
        if (r101 != null) goto L7;
    L9:
        boolean r103 = false;
    L10:
        if (r103 == true) goto L13;
        r102 = 1;
    L13:
        AudioTrack r104 = this.f527800c;
        if (r104 == null) goto L16;
        int r105 = r104.getPlaybackHeadPosition();
    L17:
        AudioTrack r106 = this.f527800c;
        if (r106 == null) goto L20;
        int r107 = r106.getSampleRate();
    L21:
        int r108 = (((r100 / r102) - r105) * 1000) / r107;
        this.f527809l = SystemClock.elapsedRealtime() + ((long) (r108 * 2));
        int r109 = c68.b.f22600a;
        c68.b.b("TTSAudioPlayer", "check timeout, estimated remaining time = " + r108);
        goto L23
    L20:
        r107 = 1;
        goto L21
    L16:
        r105 = 0;
        goto L17
    L7:
        if (r101.getFormat() != 2) goto L9;
        r103 = true;
    L23:
        if (SystemClock.elapsedRealtime() < this.f527809l) goto L26;
        return true;
    L26:
        return false;
    }

    @Override // q58.a
    public final boolean e() {
        AudioTrack r100 = this.f527800c;
        if (r100 == null) goto L5;
        int r101 = r100.getPlaybackHeadPosition();
    L6:
        u58.a r102 = this.f527801d;
        int r103 = 2;
        if (r102 != null) goto L9;
    L11:
        boolean r104 = false;
    L12:
        if (r104 == false) goto L14;
        int r105 = 2;
    L15:
        u58.a r106 = this.f527801d;
        if (r106 != null) goto L18;
    L20:
        boolean r107 = false;
    L21:
        if (r107 == false) goto L23;
        r103 = 1;
    L23:
        int r108 = r105 * r103;
        if (r101 < (this.f527803f / r108)) goto L27;
        return true;
    L27:
        return false;
    L18:
        if (r106.getChannel() != 4) goto L20;
        r107 = true;
        goto L21
    L14:
        r105 = 1;
        goto L15
    L9:
        if (r102.getFormat() != 2) goto L11;
        r104 = true;
        goto L12
    L5:
        r101 = 0;
        goto L6
    }

    @Override // q58.a
    public final void pause() {
        Integer r100 = null;
        if (this.f527799b == AudioPlayerState.STARTED) goto L31;
        int r101 = c68.b.f22600a;
        StringBuilder r102 = new StringBuilder();
        AudioTrack r103 = this.f527800c;
        if (r103 == null) goto L7;
        r100 = Integer.valueOf(r103.hashCode());
    L7:
        r102.append(r100);
        r102.append(":player not started, current state ");
        r102.append(this.f527799b);
        c68.b.b("TTSAudioPlayer", r102.toString());
        return;
    L31:
        AudioTrack r104 = this.f527800c;     // Catch: Exception -> L15
        if (r104 != null) goto L11;
    L30:
    L26:
        AudioPlayerState r105 = AudioPlayerState.PAUSED;
        this.f527799b = r105;
        q58.b r106 = this.f527798a;
        if (r106 == null) goto L34;
        r106.b(r105);
        return;
    L34:
        return;
    L11:
        if (g.d() == true) goto L13;
        r104.pause();     // Catch: Exception -> L15
        goto L30
    L13:
        r104.pause();     // Catch: Exception -> L15
        gna.a.a(r104.hashCode());     // Catch: Exception -> L15
    L15:
        e = move-exception;
        m58.a r107 = h.f512137h;
        if (r107 == null) goto L19;
        r107.ensureNotReachHere(e);
    L19:
        TtsTracer r108 = this.f527804g;
        if (r108 == null) goto L22;
        r108.onPlayErr(true, "pause AudioTrack error. msg=" + e.getMessage());
    L22:
        int r109 = c68.b.f22600a;
        StringBuilder r110 = new StringBuilder();
        AudioTrack r111 = this.f527800c;
        if (r111 == null) goto L25;
        r100 = Integer.valueOf(r111.hashCode());
    L25:
        r110.append(r100);
        r110.append(":audio pause exception ");
        r110.append(e);
        c68.b.b("TTSAudioPlayer", r110.toString());
        goto L26
    }

    @Override // q58.a
    public final void resume() {
        Integer r100 = null;
        if (this.f527799b == AudioPlayerState.PAUSED) goto L26;
        int r101 = c68.b.f22600a;
        StringBuilder r102 = new StringBuilder();
        AudioTrack r103 = this.f527800c;
        if (r103 == null) goto L7;
        r100 = Integer.valueOf(r103.hashCode());
    L7:
        r102.append(r100);
        r102.append(":player not paused, current state ");
        r102.append(this.f527799b);
        c68.b.b("TTSAudioPlayer", r102.toString());
        return;
    L26:
        AudioTrack r104 = this.f527800c;     // Catch: Exception -> L12
        if (r104 == null) goto L22;
        b(r104);     // Catch: Exception -> L12
    L22:
        AudioPlayerState r105 = AudioPlayerState.STARTED;
        this.f527799b = r105;
        q58.b r106 = this.f527798a;
        if (r106 == null) goto L29;
        r106.b(r105);
        return;
    L29:
        return;
    L12:
        e = move-exception;
        m58.a r107 = h.f512137h;
        if (r107 == null) goto L16;
        r107.ensureNotReachHere(e);
    L16:
        int r108 = c68.b.f22600a;
        StringBuilder r109 = new StringBuilder();
        AudioTrack r110 = this.f527800c;
        if (r110 == null) goto L19;
        r100 = Integer.valueOf(r110.hashCode());
    L19:
        r109.append(r100);
        r109.append(":audio resume exception ");
        r109.append(e);
        c68.b.b("TTSAudioPlayer", r109.toString());
        TtsTracer r111 = this.f527804g;
        if (r111 == null) goto L22;
        r111.onPlayErr(true, "resume AudioTrack error. msg=" + e.getMessage());
        goto L22
    }

    @Override // q58.a
    public final void start() {
        int r100 = C7153a.f527810a[this.f527799b.ordinal()];
        Integer r101 = null;
        if (r100 != 1) goto L5;
        u58.a r102 = this.f527801d;
        boolean r103 = false;
        if (r102 == null) goto L87;
        int r104 = AudioTrack.getMinBufferSize(r102.getSampleRate(), r102.getChannel(), r102.getFormat());
        this.f527802e = r104;
        if (r104 >= 1) goto L116;
        int r105 = c68.b.f22600a;
        StringBuilder r106 = new StringBuilder();
        AudioTrack r107 = this.f527800c;
        if (r107 == null) goto L37;
        r101 = Integer.valueOf(r107.hashCode());
    L37:
        r106.append(r101);
        r106.append(":mMinBufferSize is invalid :");
        r106.append(this.f527802e);
        c68.b.b("TTSAudioPlayer", r106.toString());
        q58.b r108 = this.f527798a;
        if (r108 == null) goto L120;
        r108.a(AudioPlayerErrorEnum.INIT_ERROR);
        return;
    L120:
        return;
    L116:
        p r109 = h.f512144o;     // Catch: Exception -> L69
        if (r109 == null) goto L44;
        AudioTrack r110 = r109.a(r102, r104);     // Catch: Exception -> L69
    L45:
        this.f527800c = r110;     // Catch: Exception -> L69
        if (r110 != null) goto L56;
        this.f527800c = new AudioTrack(3, r102.getSampleRate(), r102.getChannel(), r102.getFormat(), this.f527802e, 1);     // Catch: Exception -> L69
        int r111 = c68.b.f22600a;     // Catch: Exception -> L69
        StringBuilder r112 = new StringBuilder();     // Catch: Exception -> L69
        AudioTrack r113 = this.f527800c;     // Catch: Exception -> L69
        if (r113 == null) goto L50;
        Integer r114 = Integer.valueOf(r113.hashCode());     // Catch: Exception -> L69
    L51:
        r112.append(r114);     // Catch: Exception -> L69
        r112.append(":create customized tracker of type ");     // Catch: Exception -> L69
        AudioTrack r115 = this.f527800c;     // Catch: Exception -> L69
        if (r115 == null) goto L54;
        Integer r116 = Integer.valueOf(r115.getStreamType());     // Catch: Exception -> L69
    L55:
        r112.append(r116);     // Catch: Exception -> L69
        c68.b.d("TTSAudioPlayer", r112.toString());     // Catch: Exception -> L69
        goto L56
    L54:
        r116 = null;
        goto L55
    L50:
        r114 = null;
    L56:
        AudioTrack r117 = this.f527800c;     // Catch: Exception -> L69
        if (r117 == null) goto L59;
        r117.setNotificationMarkerPosition(1);     // Catch: Exception -> L69
    L59:
        AudioTrack r118 = this.f527800c;     // Catch: Exception -> L69
        if (r118 == null) goto L62;
        r118.setPositionNotificationPeriod(16000);     // Catch: Exception -> L69
    L62:
        AudioTrack r119 = this.f527800c;     // Catch: Exception -> L69
        if (r119 == null) goto L65;
        r119.setPlaybackPositionUpdateListener(this.f527808k);     // Catch: Exception -> L69
    L65:
        AudioTrack r120 = this.f527800c;     // Catch: Exception -> L69
        if (r120 == null) goto L81;
        b(r120);     // Catch: Exception -> L69
    L81:
        this.f527803f = 0;
        this.f527809l = 0;
        int r121 = c68.b.f22600a;
        c68.b.a("TTSAudioPlayer", "minBufferSize is " + this.f527802e);
        StringBuilder r122 = new StringBuilder();
        AudioTrack r123 = this.f527800c;
        if (r123 == null) goto L84;
        Integer r124 = Integer.valueOf(r123.hashCode());
    L85:
        r122.append(r124);
        r122.append(":minBufferSize is ");
        r122.append(this.f527802e);
        c68.b.d("TTSAudioPlayer", r122.toString());
        goto L87
    L84:
        r124 = null;
        goto L85
    L44:
        r110 = null;
    L69:
        e = move-exception;
        TtsTracer r125 = this.f527804g;
        if (r125 == null) goto L73;
        r125.onPlayErr(true, "init AudioTrack err. msg=" + e.getMessage());
    L73:
        m58.a r126 = h.f512137h;
        if (r126 == null) goto L76;
        r126.ensureNotReachHere(e);
    L76:
        int r127 = c68.b.f22600a;
        StringBuilder r128 = new StringBuilder();
        AudioTrack r129 = this.f527800c;
        if (r129 == null) goto L79;
        Integer r130 = Integer.valueOf(r129.hashCode());
    L80:
        r128.append(r130);
        r128.append(":audio start exception ");
        r128.append(e);
        c68.b.b("TTSAudioPlayer", r128.toString());
        goto L81
    L79:
        r130 = null;
    L87:
        if (this.f527801d != null) goto L89;
    L103:
        int r131 = c68.b.f22600a;
        StringBuilder r132 = new StringBuilder();
        AudioTrack r133 = this.f527800c;
        if (r133 == null) goto L106;
        r101 = Integer.valueOf(r133.hashCode());
    L106:
        r132.append(r101);
        r132.append(":config is null, pls config before start");
        c68.b.b("TTSAudioPlayer", r132.toString());
        TtsTracer r134 = this.f527804g;
        if (r134 == null) goto L112;
        StringBuilder r135 = new StringBuilder("init AudioTrack err. config is null=");
        if (this.f527801d != null) goto L111;
        r103 = true;
    L111:
        r135.append(r103);
        r135.append(" , mMinBufferSize =");
        r135.append(this.f527802e);
        r134.onPlayErr(true, r135.toString());
    L112:
        q58.b r136 = this.f527798a;
        if (r136 == null) goto L123;
        r136.a(AudioPlayerErrorEnum.START_ERROR);
        return;
    L123:
        return;
    L89:
        if (this.f527802e == 0) goto L103;
        AudioPlayerState r137 = AudioPlayerState.STARTED;
        this.f527799b = r137;
        q58.b r138 = this.f527798a;
        if (r138 == null) goto L94;
        r138.b(r137);
    L94:
        int r139 = c68.b.f22600a;
        StringBuilder r140 = new StringBuilder("start to play, session id = ");
        AudioTrack r141 = this.f527800c;
        if (r141 == null) goto L97;
        Integer r142 = Integer.valueOf(r141.getAudioSessionId());
    L98:
        r140.append(r142);
        c68.b.a("TTSAudioPlayer", r140.toString());
        StringBuilder r143 = new StringBuilder();
        AudioTrack r144 = this.f527800c;
        if (r144 == null) goto L101;
        r101 = Integer.valueOf(r144.hashCode());
    L101:
        r143.append(r101);
        r143.append(":start to play");
        c68.b.d("TTSAudioPlayer", r143.toString());
        return;
    L97:
        r142 = null;
        goto L98
    L5:
        if (r100 == 2) goto L118;
        int r145 = c68.b.f22600a;
        StringBuilder r146 = new StringBuilder();
        AudioTrack r147 = this.f527800c;
        if (r147 == null) goto L9;
        r101 = Integer.valueOf(r147.hashCode());
    L9:
        r146.append(r101);
        r146.append(":player already stated, current state ");
        r146.append(this.f527799b);
        c68.b.d("TTSAudioPlayer", r146.toString());
        return;
    L118:
        AudioTrack r148 = this.f527800c;     // Catch: Exception -> L14
        if (r148 == null) goto L23;
        b(r148);     // Catch: Exception -> L14
    L23:
        AudioPlayerState r149 = AudioPlayerState.STARTED;
        this.f527799b = r149;
        q58.b r150 = this.f527798a;
        if (r150 == null) goto L26;
        r150.b(r149);
    L26:
        int r151 = c68.b.f22600a;
        StringBuilder r152 = new StringBuilder();
        AudioTrack r153 = this.f527800c;
        if (r153 == null) goto L29;
        r101 = Integer.valueOf(r153.hashCode());
    L29:
        r152.append(r101);
        r152.append(":continue to play");
        c68.b.d("TTSAudioPlayer", r152.toString());
        return;
    L14:
        e = move-exception;
        m58.a r154 = h.f512137h;
        if (r154 == null) goto L18;
        r154.ensureNotReachHere(e);
    L18:
        int r155 = c68.b.f22600a;
        StringBuilder r156 = new StringBuilder();
        AudioTrack r157 = this.f527800c;
        if (r157 == null) goto L21;
        Integer r158 = Integer.valueOf(r157.hashCode());
    L22:
        r156.append(r158);
        r156.append(":audio pause->play exception ");
        r156.append(e);
        c68.b.b("TTSAudioPlayer", r156.toString());
        goto L23
    L21:
        r158 = null;
        goto L22
    }

    @Override // q58.a
    public final void stop() {
        AudioPlayerState r100 = this.f527799b;
        AudioPlayerState r101 = AudioPlayerState.STOPPED;
        Integer r102 = null;
        if (r100 != r101) goto L8;
        int r103 = c68.b.f22600a;
        StringBuilder r104 = new StringBuilder();
        AudioTrack r105 = this.f527800c;
        if (r105 == null) goto L7;
        r102 = Integer.valueOf(r105.hashCode());
    L7:
        r104.append(r102);
        r104.append(":player not started, current state ");
        r104.append(this.f527799b);
        c68.b.b("TTSAudioPlayer", r104.toString());
        return;
    L8:
        this.f527799b = r101;
        int r106 = c68.b.f22600a;
        StringBuilder r107 = new StringBuilder();
        AudioTrack r108 = this.f527800c;
        if (r108 == null) goto L11;
        Integer r109 = Integer.valueOf(r108.hashCode());
    L12:
        r107.append(r109);
        r107.append(":stop player ");
        r107.append(this.f527799b);
        c68.b.d("TTSAudioPlayer", r107.toString());
        AudioTrack r110 = this.f527800c;     // Catch: Exception -> L32
        if (r110 != null) goto L16;
    L44:
        AudioTrack r111 = this.f527800c;     // Catch: Exception -> L32
        if (r111 == null) goto L47;
        r111.release();     // Catch: Exception -> L32
    L47:
        this.f527803f = 0;     // Catch: Exception -> L32
        this.f527805h = 0;     // Catch: Exception -> L32
        this.f527806i = 0;     // Catch: Exception -> L32
        this.f527807j = 0;     // Catch: Exception -> L32
    L57:
        this.f527800c = null;
        q58.b r112 = this.f527798a;
        if (r112 == null) goto L64;
        r112.b(AudioPlayerState.STOPPED);
        return;
    L64:
        return;
    L16:
        if (r110.getState() != 1) goto L18;
        boolean r113 = true;
    L19:
        if (r113 == false) goto L44;
        AudioTrack r114 = this.f527800c;     // Catch: Exception -> L32
        if (r114 != null) goto L23;
    L25:
        boolean r115 = false;
    L26:
        if (r115 == false) goto L44;
        AudioTrack r116 = this.f527800c;     // Catch: Exception -> L32
        if (r116 != null) goto L30;
    L35:
        AudioTrack r117 = this.f527800c;     // Catch: Exception -> L32
        if (r117 == null) goto L38;
        r117.flush();     // Catch: Exception -> L32
    L38:
        AudioTrack r118 = this.f527800c;     // Catch: Exception -> L32
        if (r118 == null) goto L44;
        if (g.d() == true) goto L43;
        r118.stop();     // Catch: Exception -> L32
        goto L44
    L43:
        r118.stop();     // Catch: Exception -> L32
        gna.a.a(r118.hashCode());     // Catch: Exception -> L32
        goto L44
    L30:
        if (g.d() == true) goto L34;
        r116.pause();     // Catch: Exception -> L32
        goto L35
    L34:
        r116.pause();     // Catch: Exception -> L32
        gna.a.a(r116.hashCode());     // Catch: Exception -> L32
        goto L35
    L23:
        if (r114.getPlayState() != 3) goto L25;
        r115 = true;
        goto L26
    L18:
        r113 = false;
    L32:
        e = move-exception;
        TtsTracer r119 = this.f527804g;
        if (r119 == null) goto L52;
        r119.onPlayErr(true, "Release AudioTrack error. msg=" + e.getMessage());
    L52:
        int r120 = c68.b.f22600a;
        StringBuilder r121 = new StringBuilder();
        AudioTrack r122 = this.f527800c;
        if (r122 == null) goto L55;
        Integer r123 = Integer.valueOf(r122.hashCode());
    L56:
        r121.append(r123);
        r121.append(":Release AudioTrack error");
        c68.b.c("TTSAudioPlayer", r121.toString(), e);
        goto L57
    L55:
        r123 = null;
        goto L56
    L11:
        r109 = null;
        goto L12
    }

    public a() {
        this.f527799b = AudioPlayerState.STOPPED;
        this.f527808k = new b(this);
    }

    @Override // q58.a
    public final int c() {
        return this.f527802e;
    }

    @Override // q58.a
    public final AudioPlayerState getPlayState() {
        return this.f527799b;
    }

    public static void b(AudioTrack r100) {
        if (g.d() == true) goto L6;
        r100.play();
        return;
    L6:
        r100.play();
        gna.a.c(r100.hashCode());
    }

    @Override // q58.a
    public final void f(u58.a r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        if ((r100 instanceof g78.a) == false) goto L6;
        this.f527801d = r100;
        return;
    }

    @Override // q58.a
    public final void g(q58.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f527798a = r100;
    }

    @Override // q58.a
    public final void setVolume(float r100) {
        AudioTrack r101 = this.f527800c;
        if (r101 == null) goto L6;
        r101.setVolume(r100);
        return;
    }

    @Override // q58.a
    public final void a(byte[] r100, int r110) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Integer r101 = null;
        if (this.f527799b != AudioPlayerState.STARTED) goto L5;
    L12:
        t r102 = h.f512142m;
        int r103 = 0;
        if (r102 == null) goto L17;
        boolean r104 = true;
        if (r102.enableAudioPlayerFlushWithSilence() != true) goto L17;
    L18:
        if (r104 == true) goto L20;
    L35:
        int r105 = this.f527803f;
        AudioTrack r106 = this.f527800c;
        if (r106 == null) goto L38;
        r103 = r106.write(r100, 0, r110);
    L38:
        this.f527803f = r105 + r103;
        this.f527806i = System.currentTimeMillis();
        return;
    L20:
        if (this.f527803f <= 0) goto L35;
        if (r110 > 0) goto L35;
        int r107 = this.f527802e;
        byte[] r108 = new byte[r107];
        int r109 = c68.b.f22600a;
        c68.b.d("TTSAudioPlayer", "flushWithSilence: " + r107);
        int r111 = 0;
    L23:
        if (r111 >= r107) goto L31;
        AudioTrack r112 = this.f527800c;
        if (r112 == null) goto L26;
        int r113 = r112.write(r108, r111, r107 - r111);
        if (r113 < 0) goto L29;
        r111 = r111 + r113;
        goto L23
    L29:
        int r114 = c68.b.f22600a;
        c68.b.b("TTSAudioPlayer", "Padding write error: " + r113);
        goto L31
    L26:
        c68.b.d("TTSAudioPlayer", "flushWithSilence null tracker");
    L31:
        this.f527803f += r111;
        int r115 = c68.b.f22600a;
        StringBuilder r116 = new StringBuilder();
        AudioTrack r117 = this.f527800c;
        if (r117 == null) goto L34;
        r101 = Integer.valueOf(r117.hashCode());
    L34:
        r116.append(r101);
        r116.append(":flushWithSilence totalBytesWritten = ");
        r116.append(this.f527803f);
        r116.append(" and written = ");
        r116.append(r111);
        c68.b.a("TTSAudioPlayer", r116.toString());
    L17:
        r104 = false;
        goto L18
    L5:
        if (this.f527799b == AudioPlayerState.PAUSED) goto L12;
        int r118 = c68.b.f22600a;
        StringBuilder r119 = new StringBuilder();
        AudioTrack r120 = this.f527800c;
        if (r120 == null) goto L9;
        r101 = Integer.valueOf(r120.hashCode());
    L9:
        r119.append(r101);
        r119.append(":player not started, current state ");
        r119.append(this.f527799b);
        c68.b.b("TTSAudioPlayer", r119.toString());
        q58.b r121 = this.f527798a;
        if (r121 == null) goto L43;
        r121.a(AudioPlayerErrorEnum.WRITE_ERROR);
        return;
    }
}
