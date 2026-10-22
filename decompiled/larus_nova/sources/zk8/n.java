package zk8;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.media.MediaLevel;
import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaResourceManager;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.ttvideoengine.model.VideoRef;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f572677a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static MediaPlayer f572678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f572679c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Function1<? super vl8.g, Unit> f572680d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f572681e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f572682f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f572683g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Handler f572684h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static j f572685i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ExecutorService f572686j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final b f572687k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final com.larus.media.model.a f572688l = null;

    public static final class a implements com.larus.media.v {
        public a() {
        }

        @Override // com.larus.media.v
        public final boolean b(lk9.g r100) {
            Intrinsics.checkNotNullParameter(r100, "applicant");
            return false;
        }

        @Override // com.larus.media.v
        public final void e(lk9.g r100) {
            Intrinsics.checkNotNullParameter(r100, "applicant");
            n.f572684h.post(new l());
        }

        @Override // com.larus.media.v
        public final void f(MediaResourceManager.a r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
        }

        @Override // com.larus.media.v
        public final void a(lk9.g r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, "applicant");
            n.f572684h.post(new k(this));
        }

        @Override // com.larus.media.v
        public final void d(lk9.g r100, lk9.g r101) {
            com.larus.media.v.a.c(r100, r101);
        }

        @Override // com.larus.media.v
        public final void g(lk9.g r100, float r101) {
            com.larus.media.v.a.g(r100, r101);
        }

        @Override // com.larus.media.v
        public final void i(lk9.g r100, lk9.g r101) {
            Intrinsics.checkNotNullParameter(r100, "current");
            Intrinsics.checkNotNullParameter(r101, "applicant");
            n.f572684h.post(new m(this));
        }

        @Override // com.larus.media.v
        public final MediaOccupyStrategy c(lk9.g r100, lk9.g r101, int r102) {
            return com.larus.media.v.a.a(this, r100, r101, r102);
        }

        @Override // com.larus.media.v
        public final MediaOccupyStrategy h(lk9.g r100, lk9.g r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "current");
            Intrinsics.checkNotNullParameter(r101, "applicant");
            return MediaOccupyStrategy.PAUSE;
        }
    }

    public static final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            n.f572677a.getClass();     // Catch: Throwable -> L11
            n.d();     // Catch: Throwable -> L11
            MediaPlayer r100 = n.f572678b;     // Catch: Throwable -> L11
            if (r100 == null) goto L7;
            boolean r101 = true;
            if (r100.isPlaying() != true) goto L7;
        L8:
            if (r101 == false) goto L14;
            n.f572684h.postDelayed(this, 200);     // Catch: Throwable -> L11
            return;
        L14:
            return;
        L7:
            r101 = false;
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L18;
            throw th;
        }
    }

    public n() {
    }

    public final synchronized void e() {
        monitor-enter(this);
        b();     // Catch: Throwable -> L20
        f572684h.removeCallbacks(f572687k);     // Catch: Throwable -> L20
        Function1<? super vl8.g, Unit> r100 = f572680d;     // Catch: Throwable -> L20
        if (r100 == null) goto L6;
        r100.invoke(new vl8.g(false, false, false, 0.0f, 15));     // Catch: Throwable -> L20
    L6:
        final MediaPlayer r101 = f572678b;     // Catch: Throwable -> L20
        f572678b = null;     // Catch: Throwable -> L20
        f572679c = null;     // Catch: Throwable -> L20
        f572680d = null;     // Catch: Throwable -> L20
        f572681e = false;     // Catch: Throwable -> L20
        f572683g = false;     // Catch: Throwable -> L20
        if (f572682f == false) goto L10;
        f572682f = false;     // Catch: Throwable -> L20
        Lazy r102 = MediaResourceManager.f358950a;     // Catch: Throwable -> L20
        MediaResourceManager.a(f572688l);     // Catch: Throwable -> L20
    L10:
        if (r101 != null) goto L25;
        monitor-exit(this);
        return;
    L25:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L15
        r101.setOnPreparedListener(null);     // Catch: Throwable -> L15
        r101.setOnCompletionListener(null);     // Catch: Throwable -> L15
        r101.setOnErrorListener(null);     // Catch: Throwable -> L15
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        f572686j.execute(new zk8.b(r101));     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L20
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    static {
        f572677a = new n();
        f572684h = new Handler(Looper.getMainLooper());
        f572686j = PThreadExecutorsUtils.newSingleThreadExecutor(new zk8.a());
        f572687k = new b();
        f572688l = new com.larus.media.model.a("file_audio", "music", false, 0, 2, false, 0, false, false, MediaLevel.PLAY_HIGH.getValue(), false, new a(), VideoRef.VALUE_VIDEO_REF_CONST_DEPTH);
    }

    public static vl8.g a() {
        MediaPlayer r100 = f572678b;
        if (r100 != null) goto L7;
        return new vl8.g(false, false, false, 0.0f, 15);
    L7:
        if (f572681e == false) goto L9;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L12
        Object r102 = Result.m9449constructorimpl(Integer.valueOf(r100.getDuration()));     // Catch: Throwable -> L12
    L15:
        if (Result.m9455isFailureimpl(r102) == false) goto L17;
        r102 = 0;
    L17:
        int r103 = ((Number) r102).intValue();
        Object r104 = Result.m9449constructorimpl(Integer.valueOf(r100.getCurrentPosition()));     // Catch: Throwable -> L20
    L23:
        if (Result.m9455isFailureimpl(r104) == false) goto L25;
        r104 = 0;
    L25:
        int r105 = ((Number) r104).intValue();
        Object r106 = Result.m9449constructorimpl(Boolean.valueOf(r100.isPlaying()));     // Catch: Throwable -> L28
    L30:
        Boolean r107 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r106) == false) goto L33;
        r106 = r107;
    L33:
        boolean r108 = ((Boolean) r106).booleanValue();
        boolean r109 = !r108;
        if (r103 <= 0) goto L36;
        float r110 = r105 / r103;
    L38:
        return new vl8.g(r108, false, r109, r110, 2);
    L36:
        r110 = 0.0f;
    L28:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L20:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L12:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    L9:
        return new vl8.g(false, true, false, 0.0f, 13);
    }

    public static void b() {
        j r100 = f572685i;
        if (r100 == null) goto L5;
        f572684h.removeCallbacks(r100);
    L5:
        f572685i = null;
    }

    public static void d() {
        Function1<? super vl8.g, Unit> r100 = f572680d;
        if (r100 == null) goto L6;
        r100.invoke(a());
        return;
    }

    public final synchronized vl8.g c(String r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "path");     // Catch: Throwable -> L11
        if (Intrinsics.areEqual(r100, f572679c) == true) goto L8;
        vl8.g r101 = new vl8.g(false, false, false, 0.0f, 15);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r101;
    L8:
        vl8.g r102 = a();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L11:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v13, types: [java.lang.Runnable, zk8.j] */
    public final synchronized void f(Context r100, final String r110, Function1<? super vl8.g, Unit> r111, final Function0<Unit> r112) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: Throwable -> L79
        Intrinsics.checkNotNullParameter(r110, "path");     // Catch: Throwable -> L79
        Intrinsics.checkNotNullParameter(r111, "onStateChanged");     // Catch: Throwable -> L79
        Intrinsics.checkNotNullParameter(r112, LynxVideoManagerLite.EVENT_ON_ERROR);     // Catch: Throwable -> L79
        ch8.a.f23807a.getClass();     // Catch: Throwable -> L79
        ch8.b r101 = ch8.a.a(r110);     // Catch: Throwable -> L79
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        Object r103 = Result.m9449constructorimpl(UriProtector.parse(r110).getScheme());     // Catch: Throwable -> L7
    L10:
        if (Result.m9455isFailureimpl(r103) == false) goto L12;
        r103 = null;
    L12:
        String r104 = (String) r103;     // Catch: Throwable -> L79
        if (StringsKt.equals(r104, "http", true) == false) goto L15;
    L18:
        boolean r105 = true;
    L19:
        if (r101 != null) goto L25;
        if (r105 == true) goto L25;
        FLogger.f375446a.e("FileAudioPlayer", "play failed, invalid or missing file: ".concat(r110));     // Catch: Throwable -> L79
        r112.invoke();     // Catch: Throwable -> L79
        monitor-exit(this);
        return;
    L25:
        if ((r101 instanceof ch8.b.C0447b) == false) goto L32;
        if (((ch8.b.C0447b) r101).f23809a.isFile() == true) goto L32;
        FLogger.f375446a.e("FileAudioPlayer", "play failed, file does not exist: ".concat(r110));     // Catch: Throwable -> L79
        r112.invoke();     // Catch: Throwable -> L79
        monitor-exit(this);
        return;
    L32:
        if (Intrinsics.areEqual(f572679c, r110) == false) goto L59;
        final MediaPlayer r106 = f572678b;     // Catch: Throwable -> L79
        if (r106 == null) goto L59;
        f572680d = r111;     // Catch: Throwable -> L79
        if (f572681e == true) goto L40;
        monitor-exit(this);
        return;
    L40:
        if (r106.isPlaying() == false) goto L51;
        if (fna.g.d() == true) goto L44;
        r106.pause();     // Catch: Throwable -> L79
    L46:
        if (f572682f == false) goto L49;
        f572682f = false;     // Catch: Throwable -> L79
        Lazy r107 = MediaResourceManager.f358950a;     // Catch: Throwable -> L79
        MediaResourceManager.a(f572688l);     // Catch: Throwable -> L79
    L49:
        f572684h.removeCallbacks(f572687k);     // Catch: Throwable -> L79
        d();     // Catch: Throwable -> L79
    L57:
        monitor-exit(this);
        return;
    L44:
        r106.pause();     // Catch: Throwable -> L79
        gna.a.a(r106.hashCode());     // Catch: Throwable -> L79
        goto L46
    L51:
        if (f572683g == true) goto L53;
    L56:
        Function0 r108 = new c(r106);     // Catch: Throwable -> L79
        f572683g = false;     // Catch: Throwable -> L79
        Lazy r113 = MediaResourceManager.f358950a;     // Catch: Throwable -> L79
        MediaResourceManager.m(f572688l, new h(r108), new i(r112), 0, 8);     // Catch: Throwable -> L79
        goto L57
    L53:
        if (f572682f == false) goto L56;
        f572682f = false;     // Catch: Throwable -> L79
        Lazy r109 = MediaResourceManager.f358950a;     // Catch: Throwable -> L79
        MediaResourceManager.a(f572688l);     // Catch: Throwable -> L79
    L59:
        e();     // Catch: Throwable -> L79
        f572679c = r110;     // Catch: Throwable -> L79
        f572680d = r111;     // Catch: Throwable -> L79
        f572681e = false;     // Catch: Throwable -> L79
        final MediaPlayer r114 = new MediaPlayer();     // Catch: Throwable -> L79
        f572678b = r114;     // Catch: Throwable -> L79
        d();     // Catch: Throwable -> L79
        r114.setAudioAttributes(new AudioAttributes.Builder().setContentType(2).setUsage(1).build());     // Catch: Throwable -> L69
        if ((r101 instanceof ch8.b.C0447b) == false) goto L64;
        r114.setDataSource(((ch8.b.C0447b) r101).f23809a.getPath());     // Catch: Throwable -> L69
    L68:
        r114.setOnPreparedListener(new d(this, r112));     // Catch: Throwable -> L69
        r114.setOnCompletionListener(new e(this));     // Catch: Throwable -> L69
        r114.setOnErrorListener(new f(this, r112));     // Catch: Throwable -> L69
        r114.prepareAsync();     // Catch: Throwable -> L69
        b();     // Catch: Throwable -> L69
        ?? r115 = new j(r114, r110, r112);     // Catch: Throwable -> L69
        f572685i = r115;     // Catch: Throwable -> L69
        f572684h.postDelayed(r115, 3000);     // Catch: Throwable -> L69
        Object r116 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L69
    L74:
        Throwable r117 = Result.m9452exceptionOrNullimpl(r116);     // Catch: Throwable -> L79
        if (r117 == null) goto L77;
        FLogger.f375446a.e("FileAudioPlayer", "play failed, path=".concat(r110), r117);     // Catch: Throwable -> L79
        f572677a.e();     // Catch: Throwable -> L79
        r112.invoke();     // Catch: Throwable -> L79
    L77:
        monitor-exit(this);
        return;
    L64:
        if ((r101 instanceof ch8.b.a) == false) goto L66;
        r114.setDataSource(r100.getApplicationContext(), ((ch8.b.a) r101).f23808a);     // Catch: Throwable -> L69
        goto L68
    L66:
        if (r101 != null) goto L72;
        r114.setDataSource(r110);     // Catch: Throwable -> L69
        goto L68
    L72:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L69
    L69:
        th = move-exception;
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L79
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L79
        goto L74
    L15:
        if (StringsKt.equals(r104, "https", true) == true) goto L18;
        r105 = false;
    L7:
        th = move-exception;
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L79
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L79
    L79:
        th = move-exception;
        throw th;
    }
}
