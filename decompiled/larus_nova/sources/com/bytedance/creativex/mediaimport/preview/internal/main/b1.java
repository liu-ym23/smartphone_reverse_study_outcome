package com.bytedance.creativex.mediaimport.preview.internal.main;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.Surface;
import bytedance.io.BdMediaFileSystem;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b1 implements fi4.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f203478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MediaPlayer f203479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i f203480c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public fi4.g f203481d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PthreadHandlerThreadV2 f203482e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Handler f203483f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f203484g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f203485h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f203486i;

    public static final class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b1 f203487a;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
        L56:
            e = move-exception;
            Objects.toString(r100);
            e.toString();
            return;
        L4:
            switch(r100.what) {
                case 1: goto L31;
                case 2: goto L21;
                case 3: goto L20;
                case 4: goto L16;
                case 5: goto L15;
                case 6: goto L7;
                case 7: goto L6;
                default: goto L60;
            };     // Catch: Exception -> L56
        L6:
            b1 r101 = this.f203487a;     // Catch: Exception -> L56
            Object r102 = r100.obj;     // Catch: Exception -> L56
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Boolean");     // Catch: Exception -> L56
            r101.f203479b.setLooping(((Boolean) r102).booleanValue());     // Catch: Exception -> L56
            return;
        L7:
            b1 r103 = this.f203487a;     // Catch: Exception -> L56
            Object r104 = r100.obj;     // Catch: Exception -> L56
            Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.Int");     // Catch: Exception -> L56
            int r105 = ((Integer) r104).intValue();     // Catch: Exception -> L56
            if (r103.f203486i == true) goto L11;
            r103.f203479b.prepare();     // Catch: Exception -> L56
            r103.f203486i = true;     // Catch: Exception -> L56
        L11:
            if (Build.VERSION.SDK_INT < 26) goto L13;
            r103.f203479b.seekTo(r105, 3);     // Catch: Exception -> L56
        L62:
            return;
        L13:
            r103.f203479b.seekTo(r105);     // Catch: Exception -> L56
            goto L62
        L15:
            b1 r106 = this.f203487a;     // Catch: Exception -> L56
            Object r107 = r100.obj;     // Catch: Exception -> L56
            Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type android.net.Uri");     // Catch: Exception -> L56
            Uri r108 = (Uri) r107;     // Catch: Exception -> L56
            i r109 = r106.f203480c;     // Catch: Exception -> L56
            r109.f203503a = 2;     // Catch: Exception -> L56
            r109.f203504b = 0;     // Catch: Exception -> L56
            r109.f203505c = 0;     // Catch: Exception -> L56
            r106.f203479b.setDataSource(r106.f203478a, r108);     // Catch: Exception -> L56
            Objects.toString(r108);     // Catch: Exception -> L56
            return;
        L16:
            b1 r110 = this.f203487a;     // Catch: Exception -> L56
            r110.a();     // Catch: Exception -> L56
            r110.f203482e.quit();     // Catch: Exception -> L56
            i r111 = r110.f203480c;     // Catch: Exception -> L56
            r111.f203504b = 0;     // Catch: Exception -> L56
            if (r111.f203503a != 1) goto L19;
            r111.f203505c = SystemClock.elapsedRealtime();     // Catch: Exception -> L56
        L19:
            r110.f203479b.release();     // Catch: Exception -> L56
            return;
        L20:
            this.f203487a.a();     // Catch: Exception -> L56
            return;
        L21:
            final b1 r112 = this.f203487a;     // Catch: Exception -> L56
            i r113 = r112.f203480c;     // Catch: Exception -> L56
            if (r113.f203503a != 1) goto L26;
            r113.f203503a = 2;     // Catch: Exception -> L56
            int r114 = (int) (SystemClock.elapsedRealtime() - r113.f203505c);     // Catch: Exception -> L56
            if (r114 < 0) goto L26;
            r113.f203504b += r114;     // Catch: Exception -> L56
        L26:
            MediaPlayer r115 = r112.f203479b;     // Catch: Exception -> L56
            if (fna.g.d() == true) goto L29;
            r115.pause();     // Catch: Exception -> L56
        L30:
            r112.f203483f.post(new z0(r112));     // Catch: Exception -> L56
            return;
        L29:
            r115.pause();     // Catch: Exception -> L56
            gna.a.a(r115.hashCode());     // Catch: Exception -> L56
            goto L30
        L31:
            Object r116 = r100.obj;     // Catch: Exception -> L56
            if ((r116 instanceof Integer) == false) goto L44;
            final b1 r117 = this.f203487a;     // Catch: Exception -> L56
            int r118 = ((Number) r116).intValue();     // Catch: Exception -> L56
            if (r117.f203486i == true) goto L36;
            r117.f203479b.prepare();     // Catch: Exception -> L56
            r117.f203486i = true;     // Catch: Exception -> L56
        L36:
            r117.f203479b.seekTo(r118);     // Catch: Exception -> L56
            i r119 = r117.f203480c;     // Catch: Exception -> L56
            if (r119.f203503a != 2) goto L39;
            r119.f203503a = 1;     // Catch: Exception -> L56
            r119.f203505c = SystemClock.elapsedRealtime();     // Catch: Exception -> L56
        L39:
            MediaPlayer r120 = r117.f203479b;     // Catch: Exception -> L56
            if (fna.g.d() == true) goto L42;
            r120.start();     // Catch: Exception -> L56
        L43:
            r117.f203483f.post(new r0(r117));     // Catch: Exception -> L56
            return;
        L42:
            r120.start();     // Catch: Exception -> L56
            gna.a.c(r120.hashCode());     // Catch: Exception -> L56
            goto L43
        L44:
            final b1 r121 = this.f203487a;     // Catch: Exception -> L56
            if (r121.f203486i == true) goto L47;
            r121.f203479b.prepare();     // Catch: Exception -> L56
            r121.f203486i = true;     // Catch: Exception -> L56
        L47:
            i r122 = r121.f203480c;     // Catch: Exception -> L56
            if (r122.f203503a != 2) goto L50;
            r122.f203503a = 1;     // Catch: Exception -> L56
            r122.f203505c = SystemClock.elapsedRealtime();     // Catch: Exception -> L56
        L50:
            MediaPlayer r123 = r121.f203479b;     // Catch: Exception -> L56
            if (fna.g.d() == true) goto L53;
            r123.start();     // Catch: Exception -> L56
        L54:
            r121.f203483f.post(new y0(r121));     // Catch: Exception -> L56
            return;
        L53:
            r123.start();     // Catch: Exception -> L56
            gna.a.c(r123.hashCode());     // Catch: Exception -> L56
            goto L54
        }

        public a(b1 r100, Looper r101) {
            this.f203487a = r100;
            super(r101);
        }
    }

    public static final class b {
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f203488a;

        public c() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (this.f203488a == ((c) r100).f203488a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f203488a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "Configure(screenOnWhilePlaying=" + this.f203488a + ')';
        }

        public c(int r100) {
            this.f203488a = true;
        }
    }

    static {
    }

    public final void a() {
        i r100 = this.f203480c;
        if (r100.f203503a != 1) goto L7;
        r100.f203503a = 2;
        int r101 = (int) (SystemClock.elapsedRealtime() - r100.f203505c);
        if (r101 < 0) goto L7;
        r100.f203504b += r101;
    L7:
        MediaPlayer r102 = this.f203479b;
        if (fna.g.d() == true) goto L10;
        r102.stop();
    L11:
        this.f203486i = false;
        this.f203483f.post(new o0(this));
        return;
    L10:
        r102.stop();
        gna.a.a(r102.hashCode());
        goto L11
    }

    public final int b() {
        return this.f203479b.getVideoHeight();
    L4:
        return 0;
    }

    @Override // fi4.e
    public final void c() {
        Message r100 = Message.obtain(this.f203484g);
        r100.what = 7;
        r100.obj = Boolean.TRUE;
        r100.sendToTarget();
    }

    @Override // fi4.e
    public final void e() {
        Message r100 = Message.obtain(this.f203484g);
        r100.what = 6;
        r100.obj = 0;
        r100.sendToTarget();
    }

    public final int g() {
        return this.f203479b.getVideoWidth();
    L4:
        return 0;
    }

    @Override // fi4.e
    public final int getPlayedDuration() {
        i r100 = this.f203480c;
        if (r100.f203503a != 1) goto L9;
        long r101 = SystemClock.elapsedRealtime();
        int r102 = (int) (r101 - r100.f203505c);
        if (r102 < 0) goto L7;
        r100.f203504b += r102;
    L7:
        r100.f203505c = r101;
    L9:
        return r100.f203504b;
    }

    @Override // fi4.e
    public final boolean isPlaying() {
        return this.f203479b.isPlaying();
    L4:
        return false;
    }

    @Override // fi4.e
    public final void pause() {
        Message r100 = Message.obtain(this.f203484g);
        r100.what = 2;
        r100.sendToTarget();
    }

    @Override // fi4.e
    public final void play() {
        if (this.f203485h == true) goto L5;
        return;
    L5:
        Message r100 = Message.obtain(this.f203484g);
        r100.what = 1;
        r100.sendToTarget();
    }

    @Override // fi4.e
    public final void release() {
        Message r100 = Message.obtain(this.f203484g);
        r100.what = 4;
        r100.sendToTarget();
    }

    @Override // fi4.e
    public final void stop() {
        Message r100 = Message.obtain(this.f203484g);
        r100.what = 3;
        r100.sendToTarget();
    }

    public final Context getContext() {
        return this.f203478a;
    }

    @Override // fi4.e
    public final boolean isPrepared() {
        return this.f203486i;
    }

    @Override // fi4.e
    public final void d(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        if (BdMediaFileSystem.isUriExists(this.f203478a, r100) == true) goto L6;
        Objects.toString(r100);
        this.f203485h = false;
        return;
    L6:
        this.f203485h = true;
        Message r101 = Message.obtain(this.f203484g);
        r101.what = 5;
        r101.obj = r100;
        r101.sendToTarget();
    }

    @Override // fi4.e
    public final void f(gi4.t r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f203481d = r100;
    }

    @Override // fi4.e
    public final void setSurface(final Surface r100) {
        Intrinsics.checkNotNullParameter(r100, "surface");
        this.f203484g.post(new n0(r100, this));
    }

    public b1(Context r100, Function1<? super c, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f203478a = r100;
        c r102 = new c(0);
        MediaPlayer r103 = new MediaPlayer();
        this.f203479b = r103;
        this.f203480c = new i();
        PthreadHandlerThreadV2 r104 = new PthreadHandlerThreadV2("thread-creativex-player");
        this.f203482e = r104;
        this.f203483f = new Handler(Looper.getMainLooper());
        this.f203485h = true;
        if (r101 == null) goto L5;
        r101.invoke(r102);
    L5:
        r103.setOnErrorListener(new s0(this));
        r103.setOnCompletionListener(new t0(this));
        r103.setOnPreparedListener(new u0(this));
        r103.setOnVideoSizeChangedListener(new v0(this));
        r103.setOnInfoListener(new w0(this));
        r103.setScreenOnWhilePlaying(true);
        ThreadMethodProxy.start(r104);
        this.f203484g = new a(this, r104.getLooper());
    }
}
