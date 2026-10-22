package com.larus.audioplayer.impl.music;

import a88.e;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.larus.audio.constant.GlobalAudioSceneEnum;
import com.larus.audio.observer.GlobalAudioObserver;
import com.larus.media.MediaResourceManager;
import com.larus.media.MediaScene;
import com.larus.platform.api.IVideoController;
import com.larus.platform.api.k4;
import com.larus.platform.api.n0;
import com.larus.platform.api.w0;
import com.larus.trace.GlobalAudioErrorType;
import com.larus.utils.logger.FLogger;
import com.larus.video.api.VideoService;
import com.ss.ttvideoengine.DataLoaderHelper;
import e88.d;
import e88.f;
import e88.g;
import e88.t;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tx9.i1;

/* JADX INFO: loaded from: classes24.dex */
public final class a implements w0 {
    public static final /* synthetic */ int A = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f290266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e78.c f290267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f290268c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f290269d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f290270e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final IVideoController f290271f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile int f290272g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f290273h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f290274i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f290275j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f290276k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f290277l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public e88.b f290278m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ArrayList<Function0<Unit>> f290279n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public a88.c f290280o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public b f290281p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f290282q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile boolean f290283r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile boolean f290284s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f290285t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Long f290286u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Long f290287v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Long f290288w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final com.larus.media.model.a f290289x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final com.larus.media.model.a f290290y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public com.larus.media.model.a f290291z;

    /* JADX INFO: renamed from: com.larus.audioplayer.impl.music.a$a, reason: collision with other inner class name */
    public static final class C3972a {
    }

    public interface b {
        void a(e r100, a r101);

        void b(e r100, a r101, int r102);
    }

    public final class c implements n0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f290292a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f290293b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f290294c;

        @Override // com.larus.platform.api.n0
        public final void b(Integer r100, Integer r101) {
        }

        @Override // com.larus.platform.api.n0
        public final void onPrepared() {
        }

        @Override // com.larus.platform.api.n0
        public final void onRenderStart() {
        }

        @Override // com.larus.platform.api.n0
        public final void onCompletion() {
            if (h("onCompletion") == false) goto L5;
            return;
        L5:
            e r100 = this.f290294c.f290266a;
            i1.a(r100.f2201m, r100.f2189a);
            FLogger.f375446a.i("MusicPlayEngine", "callback onCompletion, musicId:" + this.f290294c.f290266a.f2189a);
            a r101 = this.f290294c;
            a88.c r102 = r101.f290280o;
            if (r102 == null) goto L9;
            r102.f(r101.f290266a.f2189a);
            return;
        }

        @Override // com.larus.platform.api.n0
        public final void onPrepare() {
            if (h("onPrepare") == false) goto L6;
            return;
        L6:
            if (this.f290294c.f290272g != 1) goto L8;
            return;
        L8:
            FLogger.f375446a.i("MusicPlayEngine", "callback onPrepare, musicId:" + this.f290294c.f290266a.f2189a);
            a r100 = this.f290294c;
            a88.c r101 = r100.f290280o;
            if (r101 == null) goto L12;
            r101.d(r100.f290266a.f2189a);
            return;
        }

        public c(a r100) {
            this.f290294c = r100;
            this.f290292a = new Object();
        }

        @Override // com.larus.platform.api.n0
        public final void c(int r100) {
            if (h("onPlaybackStateChanged") == false) goto L5;
            return;
        L5:
            Object r101 = this.f290292a;
            monitor-enter(r101);
            g(r100);     // Catch: Throwable -> L10
            Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L10
            monitor-exit(r101);
            return;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // com.larus.platform.api.n0
        public final void d(int r100) {
            if (h("onLoadStateChanged") == false) goto L5;
            return;
        L5:
            e r101 = this.f290294c.f290266a;
            i1.f(r101.f2201m, r101.f2189a, r100);
            if (r100 != 3) goto L8;
            FLogger.f375446a.e("MusicPlayEngine", "load_state_error. musicId:" + this.f290294c.f290266a.f2189a + ", video_model:" + this.f290294c.f290266a.f2190b);
        L8:
            FLogger.f375446a.i("MusicPlayEngine", "callback onLoadStateChanged, loadState: " + r100 + ", musicId:" + this.f290294c.f290266a.f2189a);
            a r102 = this.f290294c;
            a88.c r103 = r102.f290280o;
            if (r103 == null) goto L12;
            r103.i(r102.f290266a.f2189a, r100);
            return;
        }

        public final void g(int r110) {
            int r100 = this.f290294c.f290272g;
            this.f290294c.f290275j = false;
            Boolean r101 = null;
            if (r110 != 3) goto L7;
            this.f290294c.f290272g = r110;
            f(this, r110, r100, null, 28);
            return;
        L7:
            if (r110 == 0) goto L29;
            if (r110 != 1) goto L10;
            a r102 = this.f290294c;
            r102.f290273h = true;
            boolean r103 = !r102.f290284s;
            Long r104 = this.f290294c.f290286u;
            if (r104 == null) goto L22;
            Long r105 = Long.valueOf(System.currentTimeMillis() - r104.longValue());
        L23:
            a r106 = this.f290294c;
            r106.f290286u = null;
            r106.f290284s = true;
            Boolean r107 = Boolean.valueOf(r103);
            if (r103 == false) goto L26;
            r101 = Boolean.valueOf(this.f290294c.f290285t);
        L26:
            e(r110, r100, r105, r107, r101);
            a r108 = this.f290294c;
            b r109 = r108.f290281p;
            if (r109 == null) goto L40;
            r109.b(r108.f290266a, r108, 3);
        L40:
            this.f290294c.f290272g = r110;
            FLogger.f375446a.i("MusicPlayEngine", "callback onPlaybackStateChanged, playbackState: " + r110 + ", musicId:" + this.f290294c.f290266a.f2189a);
            a r111 = this.f290294c;
            a88.c r112 = r111.f290280o;
            if (r112 == null) goto L44;
            r112.g(r111.f290266a.f2189a, r110);
            return;
        L44:
            return;
        L22:
            r105 = null;
            goto L23
        L10:
            if (r110 != 2) goto L40;
            a r113 = this.f290294c;
            r113.f290273h = true;
            Long r114 = r113.f290287v;
            if (r114 == null) goto L15;
            Long r115 = Long.valueOf(System.currentTimeMillis() - r114.longValue());
        L16:
            this.f290294c.f290287v = null;
            f(this, r110, r100, r115, 24);
            a r116 = this.f290294c;
            b r117 = r116.f290281p;
            if (r117 == null) goto L40;
            r117.b(r116.f290266a, r116, 2);
            goto L40
        L15:
            r115 = null;
            goto L16
        L29:
            a r118 = this.f290294c;
            r118.f290273h = false;
            Long r119 = r118.f290288w;
            if (r119 == null) goto L32;
            Long r120 = Long.valueOf(System.currentTimeMillis() - r119.longValue());
        L33:
            this.f290294c.f290288w = null;
            f(this, r110, r100, r120, 24);
            this.f290294c.b();
            a r121 = this.f290294c;
            b r122 = r121.f290281p;
            if (r122 == null) goto L36;
            r122.b(r121.f290266a, r121, 1);
        L36:
            a r123 = this.f290294c;
            b r124 = r123.f290281p;
            if (r124 == null) goto L39;
            r124.a(r123.f290266a, r123);
        L39:
            this.f290294c.e();
            goto L40
        L32:
            r120 = null;
            goto L33
        }

        public final boolean h(String r100) {
            if (this.f290294c.f290270e == true) goto L6;
            return false;
        L6:
            FLogger.f375446a.i("MusicPlayEngine", "ignore " + r100 + " after background audio takeover, musicId:" + this.f290294c.f290266a.f2189a);
            return true;
        }

        @Override // com.larus.platform.api.n0
        public final void onVideoStatusException(int r100) {
            if (h("onVideoStatusException") == false) goto L5;
            return;
        L5:
            FLogger.f375446a.e("MusicPlayEngine", "callback onVideoStatusException, status " + r100 + ". musicId:" + this.f290294c.f290266a.f2189a + ", video_model:" + this.f290294c.f290266a.f2190b);
            a r101 = this.f290294c;
            a88.c r102 = r101.f290280o;
            if (r102 == null) goto L9;
            r102.h(r101.f290266a.f2189a);
            return;
        }

        @Override // com.larus.platform.api.n0
        public final void a(Integer r100, Integer r101) {
            if (h(LynxVideoManagerLite.EVENT_ON_ERROR) == false) goto L5;
            return;
        L5:
            e r102 = this.f290294c.f290266a;
            i1.e(r102.f2201m, r102.f2189a, GlobalAudioErrorType.SDK, "sdk_error_code_" + r100, r100, 96);
            FLogger r103 = FLogger.f375446a;
            StringBuilder r104 = new StringBuilder("callback onError. code ");
            Object r105 = "unknown";
            if (r100 != null) goto L8;
            Object r106 = "unknown";
        L9:
            r104.append(r106);
            r104.append(", internalCode ");
            if (r101 == null) goto L13;
            r105 = r101;
        L13:
            r104.append(r105);
            r104.append(", musicId:");
            r104.append(this.f290294c.f290266a.f2189a);
            r104.append(", video_model:");
            r104.append(this.f290294c.f290266a.f2190b);
            r103.e("MusicPlayEngine", r104.toString());
            a r107 = this.f290294c;
            a88.c r108 = r107.f290280o;
            if (r108 == null) goto L16;
            r108.onError(r107.f290266a.f2189a);
        L16:
            GlobalAudioObserver.f289772a.f(GlobalAudioSceneEnum.PLUGIN_MUSIC, r100, r101);
            return;
        L8:
            r106 = r100;
            goto L9
        }

        public static /* synthetic */ void f(c r100, int r101, int r102, Long r103, int r110) {
            if ((r110 & 4) == 0) goto L5;
            r103 = null;
        L5:
            r100.e(r101, r102, r103, null, null);
        }

        public final void e(int r100, int r110, Long r111, Boolean r112, Boolean r113) {
            if (r100 != this.f290293b) goto L5;
            return;
        L5:
            this.f290293b = r100;
            e r101 = this.f290294c.f290266a;
            i1.i(r101.f2201m, r101.f2189a, r100, r110, r111, r112, r113);
        }
    }

    static {
    }

    public final void b() {
        FLogger.f375446a.i("MusicPlayEngine", "abandon audio focus actively, musicId: " + this.f290266a.f2189a + ", currentMusicMediaApplicant: " + this.f290291z);
        Lazy r100 = MediaResourceManager.f358950a;
        MediaResourceManager.a(this.f290291z);
    }

    public final void c() {
        if (this.f290270e == false) goto L6;
        FLogger.f375446a.i("MusicPlayEngine", "background audio takeover already cancelled music, musicId:" + this.f290266a.f2189a);
        return;
    L6:
        FLogger.f375446a.i("MusicPlayEngine", "background audio takeover cancels music engine, musicId:" + this.f290266a.f2189a + ", isVideoModelReady:" + this.f290268c + ", isWorking:" + this.f290273h + ", playbackState:" + this.f290272g);
        this.f290270e = true;
        this.f290278m = null;
        this.f290275j = false;
        this.f290272g = 0;
        this.f290273h = false;
        b();
        a88.c r100 = this.f290280o;
        if (r100 == null) goto L9;
        r100.g(this.f290266a.f2189a, 0);
    L9:
        this.f290280o = null;
        b r101 = this.f290281p;
        if (r101 == null) goto L12;
        r101.b(this.f290266a, this, 1);
    L12:
        b r102 = this.f290281p;
        if (r102 == null) goto L16;
        r102.a(this.f290266a, this);
    L16:
        if (this.f290281p != null) goto L18;
        this.f290271f.release();
    L18:
        e();
    }

    public final void e() {
        if (this.f290279n.isEmpty() == false) goto L5;
        return;
    L5:
        ArrayList r100 = new ArrayList(this.f290279n);
        this.f290279n.clear();
        Iterator r101 = r100.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((Function0) r101.next()).invoke();
        goto L7
    }

    @Override // com.larus.platform.api.w0
    public final String getId() {
        e r100 = this.f290266a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f2198j;
    }

    @Override // com.larus.platform.api.w0
    public final IVideoController.PlayType getStatus() {
        return this.f290271f.d();
    }

    @Override // com.larus.platform.api.w0
    public final boolean a() {
        return this.f290275j;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [e88.c] */
    public final void d(boolean r100) {
        if (this.f290269d == false) goto L5;
        return;
    L5:
        if (this.f290270e == true) goto L24;
        final ?? r101 = new e88.c(this);
        FLogger r102 = FLogger.f375446a;
        r102.i("MusicPlayEngine", "requireAudioFocus before assignment: isAuto: " + r100 + ", currentMusicMediaApplicant=" + this.f290291z);
        if (r100 == true) goto L10;
    L11:
        if (r100 == false) goto L13;
    L15:
        boolean r103 = false;
    L16:
        if (r103 == false) goto L18;
        b();
    L18:
        if (r100 == false) goto L20;
        com.larus.media.model.a r104 = this.f290290y;
    L21:
        this.f290291z = r104;
        r102.i("MusicPlayEngine", "requireAudioFocus after assignment: isAuto: " + r100 + ", currentMusicMediaApplicant=" + this.f290291z);
        Lazy r105 = MediaResourceManager.f358950a;
        final Function0 r106 = null;
        MediaResourceManager.m(this.f290291z, new d(this, r101), new e88.e(this, r106), 0, 8);
        return;
    L20:
        r104 = this.f290289x;
        goto L21
    L13:
        if (Intrinsics.areEqual(this.f290291z, this.f290289x) == true) goto L15;
    L14:
        r103 = true;
        goto L16
    L10:
        if (Intrinsics.areEqual(this.f290291z, this.f290290y) == false) goto L14;
    }

    public final void h(Function0<Unit> r100) {
        if (this.f290269d == false) goto L5;
    L15:
        if (r100 == null) goto L18;
        r100.invoke();
        return;
    L18:
        return;
    L5:
        if (this.f290273h == false) goto L15;
        if (this.f290272g == 0) goto L10;
        this.f290288w = Long.valueOf(System.currentTimeMillis());
        e r101 = this.f290266a;
        i1.j(r101.f2201m, r101.f2189a, this.f290272g);
    L10:
        this.f290275j = false;
        if (r100 == null) goto L13;
        this.f290279n.add(r100);
    L13:
        this.f290271f.stop();
    }

    public final void f(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "pausedReason");
        if (this.f290269d == false) goto L5;
        return;
    L5:
        this.f290275j = false;
        if (this.f290272g != 0) goto L10;
        FLogger.f375446a.i("MusicPlayEngine", "ignore pausing because stopped, musicId: " + this.f290266a.f2189a + ", pauseReason: " + r101);
        return;
    L10:
        if (this.f290272g == 2) goto L12;
        this.f290287v = Long.valueOf(System.currentTimeMillis());
        e r102 = this.f290266a;
        i1.g(r102.f2201m, r101, r102.f2189a, this.f290272g);
        FLogger.f375446a.i("MusicPlayEngine", "pause playing, musicId: " + this.f290266a.f2189a + ", reason: " + r101);
        this.f290276k = r101;
        if (r100 == true) goto L20;
        this.f290282q = true;
        b();
    L20:
        this.f290271f.b();
        return;
    L12:
        if (Intrinsics.areEqual(r101, "default") == false) goto L22;
        FLogger.f375446a.i("MusicPlayEngine", "only do prepare pausing, musicId: " + this.f290266a.f2189a + ", newReason: " + r101 + ", oldReason: " + this.f290276k);
        this.f290276k = r101;
        if (r100 == true) goto L23;
        this.f290282q = true;
        b();
        return;
    L23:
        return;
    }

    public a(e r210, String r310, MusicPlayManager.b r311) {
        Intrinsics.checkNotNullParameter(r210, "music");
        this.f290266a = r210;
        this.f290267b = r311;
        c r100 = new c(this);
        this.f290274i = 1.0f;
        this.f290279n = new ArrayList();
        IVideoController r101 = VideoService.f375656a.f("music_play_engine", null);
        r101.p(r100);
        r101.h(new k4("music", r210.f2191c, r210.f2192d, r210.f2189a, r210.f2199k, r210.f2200l));
        r101.f(r210.f2190b, new f(this, r101));
        r101.s(new g(this));
        this.f290271f = r101;
        t r102 = new t(this);
        com.larus.media.model.a r103 = new com.larus.media.model.a(null, "music", false, 0, 2, false, 0, false, false, 0, false, r102, DataLoaderHelper.DATALOADER_KEY_STRING_PRECISE_PRELOAD_CONFIG);
        this.f290289x = r103;
        this.f290290y = new com.larus.media.model.a(null, MediaScene.AUTO_MUSIC, false, 0, 2, false, 0, false, false, 0, false, r102, DataLoaderHelper.DATALOADER_KEY_STRING_PRECISE_PRELOAD_CONFIG);
        this.f290291z = r103;
    }

    public static void g(a r100, boolean r101, boolean r102, String r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r101 = false;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = false;
    L9:
        if ((r104 & 4) == 0) goto L11;
        r103 = "default";
    L11:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r103, "playReason");
        if (r100.f290269d == false) goto L14;
        return;
    L14:
        if (r100.f290270e == false) goto L17;
        return;
    L17:
        if (r100.f290282q == false) goto L20;
        if (r102 == false) goto L20;
        FLogger.f375446a.i("MusicPlayEngine", "MediaApplicant try play when actively paused");
        return;
    L20:
        r100.f290277l = r103;
        r100.f290282q = false;
        r100.f290275j = true;
        boolean r105 = !r100.f290283r;
        r100.f290283r = true;
        if (r100.f290272g == 1) goto L24;
        r100.f290286u = Long.valueOf(System.currentTimeMillis());
        e r106 = r100.f290266a;
        i1.h(r106.f2201m, r103, r106.f2189a, r105, r100.f290272g);
    L24:
        if (r100.f290268c == true) goto L26;
        r100.f290278m = new e88.b(r100, r101);
        return;
    L26:
        r100.d(r101);
    }
}
