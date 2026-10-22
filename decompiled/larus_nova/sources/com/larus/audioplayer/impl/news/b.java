package com.larus.audioplayer.impl.news;

import android.animation.ValueAnimator;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.audio.constant.GlobalAudioSceneEnum;
import com.larus.audio.observer.GlobalAudioObserver;
import com.larus.audioplayer.api.news.SOURCE_TYPE;
import com.larus.audioplayer.api.news.UrlAudioPlayStatus;
import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaResourceManager;
import com.larus.media.MediaScene;
import com.larus.media.o;
import com.larus.media.o0;
import com.larus.media.v;
import com.larus.platform.api.IVideoController;
import com.larus.platform.api.k4;
import com.larus.platform.api.n0;
import com.larus.trace.GlobalAudioErrorType;
import com.larus.utils.logger.FLogger;
import com.larus.video.api.VideoService;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import f88.a0;
import f88.b0;
import f88.p;
import f88.q;
import f88.r;
import f88.s;
import f88.y;
import f88.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import lk9.g;
import org.json.JSONObject;
import tx9.i1;

/* JADX INFO: loaded from: classes24.dex */
public final class b {
    public static final /* synthetic */ int B = 0;
    public float A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f290328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f290329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f290330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b88.a f290331d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final JSONObject f290332e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e78.c f290333f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f290334g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f290335h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f290336i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f290337j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f290338k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Function1<String, Unit> f290339l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final IVideoController f290340m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final c f290341n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f290342o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f290343p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile boolean f290344q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f290345r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f290346s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public volatile boolean f290347t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f290348u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Long f290349v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Long f290350w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Long f290351x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ArrayList<Function0<Unit>> f290352y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public InterfaceC3974b f290353z;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.audioplayer.impl.news.b$b, reason: collision with other inner class name */
    public interface InterfaceC3974b {
        void a(String r100, b r101, int r102);

        void b(String r100, b r101, int r102);

        void l(String r100, b r101);
    }

    public final class c implements n0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public UrlAudioPlayStatus f290354a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f290355b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.larus.media.model.a f290356c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f290357d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f290358e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ b f290359f;

        public static final class a implements v {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f290360a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public boolean f290361b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public boolean f290362c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public ValueAnimator f290363d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ b f290364e;

            /* JADX INFO: renamed from: com.larus.audioplayer.impl.news.b$c$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C3975a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f290365a = null;

                static {
                    int[] r100 = new int[MediaResourceManager.FlowAudioBroadcastEvent.values().length];
                    r100[MediaResourceManager.FlowAudioBroadcastEvent.asrWaitReplyBegin.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
                L9:
                    r100[MediaResourceManager.FlowAudioBroadcastEvent.asrWaitReplyEnd.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
                L5:
                    f290365a = r100;
                }
            }

            public a(b r100) {
                this.f290364e = r100;
            }

            @Override // com.larus.media.v
            public final boolean b(g r100) {
                Intrinsics.checkNotNullParameter(r100, "applicant");
                Map<String, o0.a> r101 = o0.f359131a;
                return o0.a(this.f290364e.f290334g, r100.getScene());
            }

            @Override // com.larus.media.v
            public final void e(final g r100) {
                Intrinsics.checkNotNullParameter(r100, "applicant");
                v.a.d(r100);
                this.f290361b = false;
                Handler r101 = new Handler(Looper.getMainLooper());
                final b r102 = this.f290364e;
                r101.post(new a0(this, r102, r100));
            }

            @Override // com.larus.media.v
            public final void f(MediaResourceManager.a r100) {
                Intrinsics.checkNotNullParameter(r100, "event");
                Intrinsics.checkNotNullParameter(r100, "event");
                if (o.a() == false) goto L23;
                MediaResourceManager.FlowAudioBroadcastEvent r101 = r100.f358959c;
                if (r101 != null) goto L7;
                int r102 = -1;
            L9:
                if (r102 != 1) goto L11;
                FLogger.f375446a.i("UrlAudioPlayer", "event asrWaitReplyBegin , msgId: " + r100.f358958b);
                this.f290362c = true;
                return;
            L11:
                if (r102 == 2) goto L13;
                FLogger.f375446a.i("UrlAudioPlayer", "else  msgId: " + r100.f358958b);
                this.f290362c = false;
                return;
            L13:
                int r103 = r100.f358957a;
                if (r103 == 4) goto L18;
                if (r103 == 2) goto L18;
                if (r103 == 3) goto L18;
                return;
            L18:
                FLogger.f375446a.i("UrlAudioPlayer", "event asrWaitReplyEnd , msgId: " + r100.f358958b);
                if (this.f290362c == false) goto L26;
                this.f290362c = false;
                Handler r104 = new Handler(Looper.getMainLooper());
                final b r105 = this.f290364e;
                r104.post(new z(this, r105));
                return;
            L26:
                return;
            L7:
                r102 = C3975a.f290365a[r101.ordinal()];
                goto L9
            }

            @Override // com.larus.media.v
            public final void a(final g r100, final float r110) {
                Intrinsics.checkNotNullParameter(r100, "applicant");
                v.a.f(r100, r110);
                String r101 = this.f290360a;
                if (r101 != null) goto L5;
                r101 = "";
            L5:
                final String r102 = r101;
                this.f290360a = null;
                this.f290364e.f290340m.c(r110);
                this.f290364e.A = r110;
                if (this.f290361b == false) goto L11;
                this.f290361b = false;
                if (this.f290362c == true) goto L12;
                Handler r103 = new Handler(Looper.getMainLooper());
                final b r104 = this.f290364e;
                r103.post(new b0(this, r110, r100, r104, r102));
                return;
            L12:
                return;
            }

            @Override // com.larus.media.v
            public final void d(g r100, g r101) {
                v.a.c(r100, r101);
            }

            @Override // com.larus.media.v
            public final void g(g r100, final float r101) {
                Intrinsics.checkNotNullParameter(r100, "applicant");
                v.a.g(r100, r101);
                FLogger.f375446a.i("UrlAudioPlayer", "audio focus onMediaVolumeChange. applicant:" + r100 + ", volumeFactor: " + r101 + ", audioUrl: " + this.f290364e.f290328a + '.');
                this.f290364e.A = r101;
                Handler r102 = new Handler(Looper.getMainLooper());
                final b r103 = this.f290364e;
                r102.post(new s(this, r103, r101));
            }

            @Override // com.larus.media.v
            public final void i(g r100, final g r101) {
                Intrinsics.checkNotNullParameter(r100, "current");
                Intrinsics.checkNotNullParameter(r101, "applicant");
                v.a.e(r100, r101);
                this.f290361b = true;
                Handler r102 = new Handler(Looper.getMainLooper());
                final b r103 = this.f290364e;
                r102.postAtFrontOfQueue(new y(this, r103, r101));
                this.f290360a = r101.getScene();
            }

            @Override // com.larus.media.v
            public final MediaOccupyStrategy c(g r100, g r101, int r102) {
                return v.a.a(this, r100, r101, r102);
            }

            @Override // com.larus.media.v
            public final MediaOccupyStrategy h(g r100, g r101, int r102) {
                Intrinsics.checkNotNullParameter(r100, "current");
                Intrinsics.checkNotNullParameter(r101, "applicant");
                Map<String, o0.a> r103 = o0.f359131a;
                return o0.b(this.f290364e.f290334g, r101.getScene());
            }
        }

        @Override // com.larus.platform.api.n0
        public final void b(Integer r100, Integer r101) {
        }

        @Override // com.larus.platform.api.n0
        public final void onPrepared() {
        }

        @Override // com.larus.platform.api.n0
        public final void onRenderStart() {
        }

        public final void e() {
            FLogger.f375446a.i("UrlAudioPlayer", "abandon audio focus actively, audioUrl: " + this.f290359f.f290328a);
            Lazy r100 = MediaResourceManager.f358950a;
            MediaResourceManager.a(this.f290356c);
        }

        public final void h() {
            UrlAudioPlayStatus r100 = UrlAudioPlayStatus.ERROR;
            this.f290354a = r100;
            b r101 = this.f290359f;
            b88.a r102 = r101.f290331d;
            if (r102 == null) goto L6;
            r102.d(r101.f290328a, r101.f290330c, r101.f290329b, r100);
            return;
        }

        @Override // com.larus.platform.api.n0
        public final void onCompletion() {
            i1.a(this.f290359f.a(), this.f290359f.f290328a);
            b r100 = this.f290359f;
            b88.a r101 = r100.f290331d;
            if (r101 == null) goto L5;
            r101.d(r100.f290328a, r100.f290330c, r100.f290329b, UrlAudioPlayStatus.FINISH);
        L5:
            FLogger.f375446a.i("UrlAudioPlayer", "callback onPrepare, audioUrl: " + this.f290359f.f290328a);
        }

        @Override // com.larus.platform.api.n0
        public final void onPrepare() {
            UrlAudioPlayStatus r100 = this.f290354a;
            if (r100 != UrlAudioPlayStatus.PLAYING) goto L5;
            return;
        L5:
            UrlAudioPlayStatus r101 = UrlAudioPlayStatus.PREPARE;
            if (r100 != r101) goto L8;
            return;
        L8:
            this.f290354a = r101;
            b r102 = this.f290359f;
            b88.a r103 = r102.f290331d;
            if (r103 == null) goto L11;
            r103.d(r102.f290328a, r102.f290330c, r102.f290329b, r101);
        L11:
            FLogger.f375446a.i("UrlAudioPlayer", "callback onPrepare, audioUrl: " + this.f290359f.f290328a);
        }

        public c(b r110) {
            this.f290359f = r110;
            this.f290354a = UrlAudioPlayStatus.STOPPED;
            this.f290356c = new com.larus.media.model.a(null, r110.f290334g, false, 0, 2, false, 0, false, false, 0, false, new a(r110), DataLoaderHelper.DATALOADER_KEY_STRING_PRECISE_PRELOAD_CONFIG);
            this.f290357d = new Object();
        }

        @Override // com.larus.platform.api.n0
        public final void c(int r100) {
            Object r101 = this.f290357d;
            monitor-enter(r101);
            i(r100);     // Catch: Throwable -> L7
            Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L7
            monitor-exit(r101);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.larus.platform.api.n0
        public final void d(int r100) {
            i1.f(this.f290359f.a(), this.f290359f.f290328a, r100);
            if (r100 == 1) goto L9;
            if (r100 != 3) goto L11;
            FLogger.f375446a.e("UrlAudioPlayer", "load_state_error: " + this.f290359f.f290328a);
            h();
        L11:
            b r101 = this.f290359f;
            InterfaceC3974b r102 = r101.f290353z;
            if (r102 == null) goto L14;
            r102.a(r101.f290328a, r101, r100);
        L14:
            FLogger.f375446a.i("UrlAudioPlayer", "callback onLoadStateChanged, loadState: " + r100 + ", audioUrl: " + this.f290359f.f290328a);
            return;
        L9:
            if (this.f290354a == UrlAudioPlayStatus.PLAYING) goto L11;
            c(1);
            goto L11
        }

        public final void i(int r110) {
            b r100 = this.f290359f;
            int r101 = r100.f290346s;
            if (r110 != 3) goto L7;
            h();
            this.f290359f.f290346s = r110;
            g(this, r110, r101, null, 28);
            return;
        L7:
            if (r110 == 0) goto L39;
            if (r110 != 1) goto L10;
            UrlAudioPlayStatus r102 = this.f290354a;
            UrlAudioPlayStatus r103 = UrlAudioPlayStatus.PLAYING;
            if (r102 != r103) goto L26;
            return;
        L26:
            boolean r104 = !r100.f290347t;
            Long r105 = this.f290359f.f290349v;
            if (r105 == null) goto L29;
            Long r106 = Long.valueOf(System.currentTimeMillis() - r105.longValue());
        L30:
            b r107 = this.f290359f;
            r107.f290349v = null;
            r107.f290347t = true;
            Boolean r108 = Boolean.valueOf(r104);
            if (r104 == false) goto L33;
            Boolean r109 = Boolean.valueOf(this.f290359f.f290348u);
        L34:
            f(r110, r101, r106, r108, r109);
            this.f290355b = true;
            b r111 = this.f290359f;
            r111.f290342o = true;
            this.f290354a = r103;
            r111.f290345r = 3;
            InterfaceC3974b r112 = r111.f290353z;
            if (r112 == null) goto L37;
            r112.b(r111.f290328a, r111, 3);
        L37:
            UrlAudioPlayStatus r113 = this.f290354a;
        L59:
            FLogger.f375446a.i("UrlAudioPlayer", "callback onPlaybackStateChanged, playbackState: " + r110 + ", audioUrl: " + this.f290359f.f290328a);
            b r114 = this.f290359f;
            r114.f290346s = r110;
            b88.a r115 = r114.f290331d;
            if (r115 == null) goto L64;
            r115.d(r114.f290328a, r114.f290330c, r114.f290329b, r113);
            return;
        L64:
            return;
        L33:
            r109 = null;
            goto L34
        L29:
            r106 = null;
            goto L30
        L10:
            if (r110 == 2) goto L13;
            r100.f290342o = false;
            r113 = UrlAudioPlayStatus.UNKNOWN;
            this.f290354a = r113;
            goto L59
        L13:
            if (this.f290355b == true) goto L15;
            return;
        L15:
            Long r116 = r100.f290350w;
            if (r116 == null) goto L18;
            Long r117 = Long.valueOf(System.currentTimeMillis() - r116.longValue());
        L19:
            this.f290359f.f290350w = null;
            g(this, r110, r101, r117, 24);
            b r118 = this.f290359f;
            r118.f290342o = true;
            this.f290354a = UrlAudioPlayStatus.PAUSED;
            r118.f290345r = 2;
            InterfaceC3974b r119 = r118.f290353z;
            if (r119 == null) goto L22;
            r119.b(r118.f290328a, r118, 2);
        L22:
            r113 = this.f290354a;
            goto L59
        L18:
            r117 = null;
            goto L19
        L39:
            if (this.f290355b == true) goto L41;
            return;
        L41:
            Long r120 = r100.f290351x;
            if (r120 == null) goto L44;
            Long r121 = Long.valueOf(System.currentTimeMillis() - r120.longValue());
        L45:
            this.f290359f.f290351x = null;
            g(this, r110, r101, r121, 24);
            this.f290359f.f290342o = false;
            e();
            this.f290354a = UrlAudioPlayStatus.STOPPED;
            b r122 = this.f290359f;
            r122.f290345r = 1;
            InterfaceC3974b r123 = r122.f290353z;
            if (r123 == null) goto L48;
            r123.b(r122.f290328a, r122, 1);
        L48:
            b r124 = this.f290359f;
            InterfaceC3974b r125 = r124.f290353z;
            if (r125 == null) goto L51;
            r125.l(r124.f290328a, r124);
        L51:
            b r126 = this.f290359f;
            if (r126.f290352y.isEmpty() == true) goto L58;
            ArrayList r127 = new ArrayList(r126.f290352y);
            r126.f290352y.clear();
            Iterator r128 = r127.iterator();
        L56:
            if (r128.hasNext() == false) goto L58;
            ((Function0) r128.next()).invoke();
        L58:
            r113 = this.f290354a;
            goto L59
        L44:
            r121 = null;
            goto L45
        }

        @Override // com.larus.platform.api.n0
        public final void onVideoStatusException(int r100) {
            h();
            FLogger.f375446a.e("UrlAudioPlayer", "callback onVideoStatusException, status " + r100 + ": " + this.f290359f.f290328a);
        }

        @Override // com.larus.platform.api.n0
        public final void a(Integer r100, Integer r101) {
            i1.e(this.f290359f.a(), this.f290359f.f290328a, GlobalAudioErrorType.SDK, "sdk_error_code_" + r100, r100, 96);
            Lazy r102 = MediaResourceManager.f358950a;
            MediaResourceManager.a(this.f290356c);
            h();
            FLogger r103 = FLogger.f375446a;
            StringBuilder r104 = new StringBuilder("callback onError, code ");
            Object r105 = "unknown";
            if (r100 != null) goto L5;
            Object r106 = "unknown";
        L6:
            r104.append(r106);
            r104.append(", internalCode ");
            if (r101 == null) goto L10;
            r105 = r101;
        L10:
            r104.append(r105);
            r104.append(": ");
            r104.append(this.f290359f.f290328a);
            r103.e("UrlAudioPlayer", r104.toString());
            b r107 = this.f290359f;
            if (r107.f290337j == false) goto L14;
            GlobalAudioObserver.f289772a.f(r107.f290335h, r100, r101);
            return;
        L14:
            return;
        L5:
            r106 = r100;
            goto L6
        }

        public static /* synthetic */ void g(c r100, int r101, int r102, Long r103, int r110) {
            if ((r110 & 4) == 0) goto L5;
            r103 = null;
        L5:
            r100.f(r101, r102, r103, null, null);
        }

        public final void f(int r100, int r110, Long r111, Boolean r112, Boolean r113) {
            if (r100 != this.f290358e) goto L5;
            return;
        L5:
            this.f290358e = r100;
            i1.i(this.f290359f.a(), this.f290359f.f290328a, r100, r110, r111, r112, r113);
        }
    }

    static {
    }

    public final String a() {
        if (this.f290332e.has("scene") == false) goto L6;
        return JSONObjectProtectorUtils.getString(this.f290332e, "scene");
    L6:
        return "unknown";
    L11:
        return "unknown";
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [f88.o, java.lang.Object] */
    public final synchronized void c(String r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "playReason");     // Catch: Throwable -> L19
        if (this.f290344q == true) goto L7;
        boolean r101 = true;
    L8:
        this.f290344q = true;     // Catch: Throwable -> L19
        if (this.f290345r == 3) goto L12;
        this.f290349v = Long.valueOf(System.currentTimeMillis());     // Catch: Throwable -> L19
        i1.h(a(), r100, this.f290328a, r101, this.f290346s);     // Catch: Throwable -> L19
    L12:
        if (this.f290338k == true) goto L16;
        this.f290340m.play();     // Catch: Throwable -> L19
        FLogger.f375446a.i("UrlAudioPlayer", "start playing without requesting audio focus: " + this.f290328a);     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L16:
        c r102 = this.f290341n;     // Catch: Throwable -> L19
        final ?? r103 = new f88.o(this);     // Catch: Throwable -> L19
        r102.getClass();     // Catch: Throwable -> L19
        Intrinsics.checkNotNullParameter(r103, "onSuccess");     // Catch: Throwable -> L19
        Lazy r104 = MediaResourceManager.f358950a;     // Catch: Throwable -> L19
        com.larus.media.model.a r105 = r102.f290356c;     // Catch: Throwable -> L19
        final b r106 = r102.f290359f;     // Catch: Throwable -> L19
        final Function0 r107 = null;
        MediaResourceManager.m(r105, new q(r106, r103), new r(r106, r107), 0, 8);     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L7:
        r101 = false;
    L19:
        th = move-exception;
        throw th;
    }

    public final synchronized void d(Function0<Unit> r100) {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (this.f290345r == 1) goto L8;
        this.f290351x = Long.valueOf(System.currentTimeMillis());     // Catch: Throwable -> L19
        i1.j(a(), this.f290328a, this.f290346s);     // Catch: Throwable -> L19
    L8:
        if (this.f290342o == true) goto L14;
        this.f290340m.stop();     // Catch: Throwable -> L19
        if (r100 == null) goto L12;
        r100.invoke();     // Catch: Throwable -> L19
    L12:
        monitor-exit(this);
        return;
    L14:
        if (r100 == null) goto L16;
        this.f290352y.add(r100);     // Catch: Throwable -> L19
    L16:
        this.f290340m.stop();     // Catch: Throwable -> L19
        FLogger.f375446a.i("UrlAudioPlayer", "stop playing: " + this.f290328a);     // Catch: Throwable -> L19
        monitor-exit(this);
    }

    public final synchronized void b(boolean r100, String r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r101, "pausedReason");     // Catch: Throwable -> L24
        UrlAudioPlayStatus r102 = this.f290341n.f290354a;     // Catch: Throwable -> L24
        if (r102 != UrlAudioPlayStatus.STOPPED) goto L10;
        FLogger.f375446a.i("UrlAudioPlayer", "ignore pausing because stopped: " + this.f290328a + ", pauseReason: " + r101);     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L10:
        if (r102 == UrlAudioPlayStatus.PAUSED) goto L12;
        this.f290350w = Long.valueOf(System.currentTimeMillis());     // Catch: Throwable -> L24
        i1.g(a(), r101, this.f290328a, this.f290346s);     // Catch: Throwable -> L24
        this.f290343p = r101;     // Catch: Throwable -> L24
        if (r100 == true) goto L21;
        this.f290341n.e();     // Catch: Throwable -> L24
    L21:
        this.f290340m.b();     // Catch: Throwable -> L24
        FLogger.f375446a.i("UrlAudioPlayer", "pause playing: " + this.f290328a + ", reason: " + r101);     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L12:
        if (Intrinsics.areEqual(r101, "default") == false) goto L16;
        FLogger.f375446a.i("UrlAudioPlayer", "only do prepare pausing: " + this.f290328a + ", newReason: " + r101 + ", oldReason: " + this.f290343p);     // Catch: Throwable -> L24
        this.f290343p = r101;     // Catch: Throwable -> L24
        if (r100 == true) goto L16;
        this.f290341n.e();     // Catch: Throwable -> L24
    L16:
        monitor-exit(this);
        return;
    L24:
        th = move-exception;
        throw th;
    }

    public b(String r110, int r111, com.larus.video.impl.sdk.a r112, String r210, b88.a r211, k4 r212, JSONObject r213, com.larus.audioplayer.impl.news.a.b r214, JSONObject r215, String r216, String r217, boolean r218, boolean r219, boolean r310, Function1 r311, int r312) {
        if ((r312 & 4) == 0) goto L5;
        com.larus.video.impl.sdk.a r100 = null;
    L7:
        if ((r312 & 8) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r312 & 16) == 0) goto L13;
        b88.a r102 = null;
    L15:
        if ((r312 & 64) == 0) goto L17;
        JSONObject r103 = new JSONObject();
    L19:
        if ((r312 & 128) == 0) goto L21;
        com.larus.audioplayer.impl.news.a.b r104 = null;
    L23:
        if ((r312 & 256) == 0) goto L25;
        JSONObject r113 = null;
    L27:
        if ((r312 & 512) == 0) goto L29;
        String r114 = MediaScene.NEWS;
    L31:
        if ((r312 & 1024) == 0) goto L33;
        String r115 = GlobalAudioSceneEnum.PLUGIN_AUDIO;
    L35:
        if ((r312 & 2048) == 0) goto L37;
        boolean r116 = true;
    L39:
        if ((r312 & 4096) == 0) goto L41;
        boolean r117 = true;
    L43:
        if ((r312 & 8192) == 0) goto L45;
        boolean r118 = true;
    L47:
        if ((r312 & 16384) == 0) goto L49;
        Function1 r105 = null;
    L50:
        com.larus.video.impl.sdk.a r119 = r100;
        Intrinsics.checkNotNullParameter(r110, "url");
        Intrinsics.checkNotNullParameter(r212, "mediaScene");
        Intrinsics.checkNotNullParameter(r103, "traceInfo");
        Intrinsics.checkNotNullParameter(r114, "focusScene");
        Intrinsics.checkNotNullParameter(r115, "globalAudioScene");
        this.f290328a = r110;
        this.f290329b = r111;
        this.f290330c = r101;
        this.f290331d = r102;
        this.f290332e = r103;
        this.f290333f = r104;
        this.f290334g = r114;
        this.f290335h = r115;
        this.f290336i = r116;
        this.f290337j = r117;
        this.f290338k = r118;
        this.f290339l = r105;
        c r106 = new c(this);
        this.f290341n = r106;
        this.f290345r = 1;
        this.f290352y = new ArrayList();
        this.A = 1.0f;
        IVideoController r107 = VideoService.f375656a.f("url_audio_play_engine", null);
        r107.h(r212);
        r107.p(r106);
        if (r111 != SOURCE_TYPE.LOCAL_FILE.getValue()) goto L53;
        r107.setLocalURL(r110);
    L54:
        if (r113 == null) goto L59;
        JSONObject r108 = r113.optJSONObject(ITTVideoEngineEventSource.KEY_VOLUME);
        if (r108 == null) goto L59;
        r107.B((float) r108.optDouble("loudness"), (float) r108.optDouble("peak"));
    L59:
        if (r111 != SOURCE_TYPE.URL.getValue()) goto L62;
        r107.setDirectUrlUseDataLoader(r110, d88.a.a(r110));
    L65:
        r107.s(new p(this));
        this.f290340m = r107;
        return;
    L62:
        if (r111 != SOURCE_TYPE.VIDEO_MODEL.getValue()) goto L65;
        if (r119 == null) goto L65;
        r107.j(r119, false);
        goto L65
    L53:
        r107.setDirectUrlUseDataLoader(r110, d88.a.a(r110));
        goto L54
    L49:
        r105 = r311;
        goto L50
    L45:
        r118 = r310;
        goto L47
    L41:
        r117 = r219;
        goto L43
    L37:
        r116 = r218;
        goto L39
    L33:
        r115 = r217;
        goto L35
    L29:
        r114 = r216;
        goto L31
    L25:
        r113 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }
}
