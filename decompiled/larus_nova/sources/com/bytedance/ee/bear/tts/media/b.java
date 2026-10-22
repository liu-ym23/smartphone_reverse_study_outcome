package com.bytedance.ee.bear.tts.media;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import com.bytedance.ee.bear.middleground.drive.export.player.IPlayer;
import com.bytedance.ee.bear.tts.TtsLoadScene;
import com.bytedance.ee.bear.tts.TtsResult;
import com.bytedance.ee.bear.tts.impl.TtsAlbumViewModel;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.LarkContext;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mo5.a f239698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f239699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.ee.bear.tts.media.c f239700c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f239701d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j f239702e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g f239703f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final h f239704g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final i f239705h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f239706i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f239707j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TtsMediaService.f f239708k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f239709l;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.tts.media.b$b, reason: collision with other inner class name */
    public final class ServiceConnectionC3440b implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f239710a;

        public ServiceConnectionC3440b(b r100) {
            this.f239710a = r100;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r100) {
            tt5.a.h("TtsMediaViewModel", "TtsMediaServiceConnection-onServiceDisconnected, name: " + r100);
            b r101 = this.f239710a;
            TtsMediaService.f r102 = r101.f239708k;
            if (r102 == null) goto L9;
            TtsMediaService.b r103 = r102.f239680a;
            if (r103 == null) goto L7;
            r103.b();
        L7:
            r102.f239680a = null;
            r101.f239708k = null;
            return;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r100, IBinder r101) {
            tt5.a.h("TtsMediaViewModel", "TtsMediaServiceConnection-onServiceConnected, name: " + r100 + ", service: " + r101);
            b r102 = this.f239710a;
            if ((r101 instanceof TtsMediaService.f) == false) goto L5;
            TtsMediaService.f r103 = (TtsMediaService.f) r101;
        L6:
            r102.f239708k = r103;
            if (r103 == null) goto L12;
            TtsMediaService.b r104 = (TtsMediaService.b) r102.f239707j.getValue();
            Intrinsics.checkNotNullParameter(r104, "remoteListener");
            TtsMediaService.b r105 = r103.f239680a;
            if (r105 == null) goto L11;
            r105.b();
        L11:
            r103.f239680a = r104;
        L12:
            this.f239710a.getClass();
            tt5.a.h("TtsMediaViewModel", "startRemoteForeground.");
            Application r106 = LarkContext.getApplication();
            Intent r107 = new Intent(r106, TtsMediaService.class);
            r107.setAction(TtsMediaRemoteAction.FOREGROUND.getActionName());
        L18:
            e = move-exception;
            tt5.a.e("TtsMediaViewModel", "startRemoteForeground, error:", e, false);
            Unit r108 = Unit.INSTANCE;
            return;
        L14:
            if (Build.VERSION.SDK_INT < 26) goto L16;
            r106.startForegroundService(r107);     // Catch: Exception -> L18
        L21:
            return;
        L16:
            r106.startService(r107);     // Catch: Exception -> L18
            goto L21
        L5:
            r103 = null;
            goto L6
        }
    }

    public final class c implements TtsMediaService.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f239711a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f239712a;

            /* JADX INFO: renamed from: com.bytedance.ee.bear.tts.media.b$c$a$a, reason: collision with other inner class name */
            public static final class C3441a implements mo5.b {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final C3441a f239713a = null;

                static {
                    f239713a = new C3441a();
                }

                public C3441a() {
                }

                @Override // mo5.b
                public final void a(TtsResult r100) {
                    Intrinsics.checkNotNullParameter(r100, "it");
                    com.bytedance.ee.bear.tts.a.a(r100);
                }
            }

            public a(b r100) {
                this.f239712a = r100;
            }

            public final void a() {
                List r100 = (List) this.f239712a.f239698a.b().getValue();
                if (r100 == null) goto L5;
                int r101 = r100.size();
            L7:
                if (r101 <= 1) goto L9;
            L12:
                tt5.a.h("TtsMediaViewModel", "TtsMediaServiceListener-onRemoteNext, albumVM: " + this.f239712a.f239698a);
                mo5.g r102 = mo5.h.e(this.f239712a.f239698a);
                if (r102 == null) goto L20;
                mo5.g r103 = this.f239712a.f239698a.d(r102);
                if (r103 == null) goto L21;
                mo5.g r104 = this.f239712a.f239698a.h(r103);
                if (r104 == null) goto L22;
                tt5.a.h("TtsMediaViewModel", "TtsMediaServiceListener-onRemoteNext, selectedVM: " + r104);
                r104.p(TtsLoadScene.SWITCH_ITEM, C3441a.f239713a);
                return;
            L22:
                return;
            L21:
                return;
            L20:
                return;
            L9:
                if (mo5.h.e(this.f239712a.f239698a) == null) goto L12;
                tt5.a.h("TtsMediaViewModel", "TtsMediaServiceListener-onRemoteNext, no more item to switch.");
                return;
            L5:
                r101 = 0;
                goto L7
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
        }

        /* JADX INFO: renamed from: com.bytedance.ee.bear.tts.media.b$c$b, reason: collision with other inner class name */
        public static final class RunnableC3442b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f239714a;

            public RunnableC3442b(b r100) {
                this.f239714a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                mo5.g r100 = mo5.h.e(this.f239714a.f239698a);     // Catch: Throwable -> L6
                if (r100 == null) goto L9;
                r100.pause();     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ee.bear.tts.media.b$c$c, reason: collision with other inner class name */
        public static final class RunnableC3443c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f239715a;

            /* JADX INFO: renamed from: com.bytedance.ee.bear.tts.media.b$c$c$a */
            public static final class a implements mo5.b {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final a f239716a = null;

                static {
                    f239716a = new a();
                }

                public a() {
                }

                @Override // mo5.b
                public final void a(TtsResult r100) {
                    Intrinsics.checkNotNullParameter(r100, "it");
                    com.bytedance.ee.bear.tts.a.a(r100);
                }
            }

            public RunnableC3443c(b r100) {
                this.f239715a = r100;
            }

            public final void a() {
                List r100 = (List) this.f239715a.f239698a.b().getValue();
                if (r100 == null) goto L5;
                int r101 = r100.size();
            L7:
                if (r101 <= 1) goto L9;
            L12:
                tt5.a.h("TtsMediaViewModel", "TtsMediaServiceListener-onRemotePrevious, albumVM: " + this.f239715a.f239698a);
                mo5.g r102 = mo5.h.e(this.f239715a.f239698a);
                if (r102 == null) goto L20;
                mo5.g r103 = this.f239715a.f239698a.f(r102);
                if (r103 == null) goto L21;
                mo5.g r104 = this.f239715a.f239698a.h(r103);
                if (r104 == null) goto L22;
                tt5.a.h("TtsMediaViewModel", "TtsMediaServiceListener-onRemotePrevious, selectedVM: " + r104);
                r104.p(TtsLoadScene.SWITCH_ITEM, a.f239716a);
                return;
            L22:
                return;
            L21:
                return;
            L20:
                return;
            L9:
                if (mo5.h.e(this.f239715a.f239698a) == null) goto L12;
                tt5.a.h("TtsMediaViewModel", "TtsMediaServiceListener-onRemotePrevious, no more item to switch.");
                return;
            L5:
                r101 = 0;
                goto L7
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
        }

        public static final class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f239717a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ long f239718b;

            public static final class a implements mo5.b {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final a f239719a = null;

                static {
                    f239719a = new a();
                }

                public a() {
                }

                @Override // mo5.b
                public final void a(TtsResult r100) {
                    Intrinsics.checkNotNullParameter(r100, "it");
                    tt5.a.h("TtsMediaViewModel", "TtsMediaServiceListener-onRemoteProgressMs, seek result: " + r100);
                }
            }

            public d(b r100, long r101) {
                this.f239717a = r100;
                this.f239718b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                mo5.g r100 = mo5.h.e(this.f239717a.f239698a);     // Catch: Throwable -> L6
                if (r100 == null) goto L9;
                r100.t(this.f239718b, a.f239719a);     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        public static final class e implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f239720a;

            public static final class a implements mo5.b {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final a f239721a = null;

                static {
                    f239721a = new a();
                }

                public a() {
                }

                @Override // mo5.b
                public final void a(TtsResult r100) {
                    Intrinsics.checkNotNullParameter(r100, "it");
                    tt5.a.h("TtsMediaViewModel", "onRemoteResume, prepareAndResume result: " + r100);
                    com.bytedance.ee.bear.tts.a.a(r100);
                }
            }

            public e(b r100) {
                this.f239720a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                mo5.g r100 = mo5.h.e(this.f239720a.f239698a);     // Catch: Throwable -> L6
                if (r100 == null) goto L9;
                r100.p(TtsLoadScene.DEFAULT, a.f239721a);     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        @Override // com.bytedance.ee.bear.tts.media.TtsMediaService.b
        public final void a() {
            com.bytedance.ee.util.ui.j.f(new a(this.f239711a));
        }

        @Override // com.bytedance.ee.bear.tts.media.TtsMediaService.b
        public final void b() {
            tt5.a.h("TtsMediaViewModel", "TtsMediaServiceListener-onRemotePaused");
            com.bytedance.ee.util.ui.j.f(new RunnableC3442b(this.f239711a));
        }

        @Override // com.bytedance.ee.bear.tts.media.TtsMediaService.b
        public final void c() {
            com.bytedance.ee.util.ui.j.f(new RunnableC3443c(this.f239711a));
        }

        @Override // com.bytedance.ee.bear.tts.media.TtsMediaService.b
        public final void e() {
            tt5.a.h("TtsMediaViewModel", "TtsMediaServiceListener-onRemoteResume");
            com.bytedance.ee.util.ui.j.f(new e(this.f239711a));
        }

        public c(b r100) {
            this.f239711a = r100;
        }

        @Override // com.bytedance.ee.bear.tts.media.TtsMediaService.b
        public final void d(long r100) {
            tt5.a.h("TtsMediaViewModel", "TtsMediaServiceListener-onRemoteProgressMs");
            com.bytedance.ee.util.ui.j.f(new d(this.f239711a, r100));
        }
    }

    static {
    }

    public final void b() {
        tt5.a.h("TtsMediaViewModel", "onDestroy.");
        tt5.a.h("TtsMediaViewModel", "stopAlbumObservers.");
        this.f239698a.e().removeObserver(this.f239699b);
        this.f239698a.b().removeObserver(this.f239700c);
        c(mo5.h.e(this.f239698a));
        List r100 = (List) this.f239698a.b().getValue();
        if (r100 == null) goto L8;
        Iterator r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        c((mo5.g) r101.next());
    L8:
        tt5.a.h("TtsMediaViewModel", "destroyRemoteService.");
        Application r102 = LarkContext.getApplication();
        Intent r103 = new Intent(r102, TtsMediaService.class);
        r103.setAction(TtsMediaRemoteAction.TERMINAL.getActionName());
        r102.startService(r103);     // Catch: Exception -> L11
    L20:
        r102.unbindService((ServiceConnection) this.f239706i.getValue());     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        tt5.a.e("TtsMediaViewModel", "destroyRemoteService, unbindService, error:", e, false);
        return;
    L11:
        e = move-exception;
        tt5.a.e("TtsMediaViewModel", "destroyRemoteService, notify service to stopSelf, error:", e, false);
        Unit r104 = Unit.INSTANCE;
        goto L20
    }

    public b(TtsAlbumViewModel r100) {
        Intrinsics.checkNotNullParameter(r100, "albumVM");
        this.f239698a = r100;
        this.f239699b = new d(this);
        this.f239700c = new com.bytedance.ee.bear.tts.media.c(this);
        this.f239701d = new f(this);
        this.f239702e = new j(this);
        this.f239703f = new g(this);
        this.f239704g = new h(this);
        this.f239705h = new i(this);
        this.f239706i = LazyKt.lazy(new TtsMediaViewModel$remoteConnection$2(this));
        this.f239707j = LazyKt.lazy(new TtsMediaViewModel$remoteListener$2(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(b r100) {
        TtsMediaService.f r101 = r100.f239708k;
        if (r101 == null) goto L37;
        mo5.g r102 = mo5.h.e(r100.f239698a);
        com.bytedance.ee.bear.tts.media.a r103 = null;
        String r104 = null;
        if (r102 == null) goto L34;
        com.bytedance.ee.bear.tts.media.a r105 = new com.bytedance.ee.bear.tts.media.a();
        r105.f239689a = mo5.h.a(r102);
        Integer r106 = mo5.h.b(r102);
        if (r106 == null) goto L10;
        int r107 = r106.intValue();
    L11:
        r105.f239690b = r107;
        mo5.j r108 = (mo5.j) r102.i().getValue();
        if (r108 == null) goto L14;
        String r109 = r108.f514588c;
    L15:
        r105.f239691c = r109;
        mo5.j r110 = (mo5.j) r102.i().getValue();
        if (r110 == null) goto L18;
        String r111 = r110.f514589d;
    L19:
        r105.f239692d = r111;
        mo5.j r112 = (mo5.j) r102.i().getValue();
        if (r112 == null) goto L22;
        r104 = r112.f514590e;
    L22:
        r105.f239693e = r104;
        r105.f239694f = (IPlayer.State) r102.u().getValue();
        Long r113 = (Long) r102.g().getValue();
        long r114 = 0;
        if (r113 == null) goto L25;
        long r115 = r113.longValue();
    L26:
        r105.f239695g = r115;
        Long r116 = (Long) r102.o().getValue();
        if (r116 == null) goto L29;
        r114 = r116.longValue();
    L29:
        r105.f239696h = r114;
        Float r117 = (Float) r102.r().getValue();
        if (r117 == null) goto L32;
        float r118 = r117.floatValue();
    L33:
        r105.f239697i = r118;
        r103 = r105;
        goto L34
    L32:
        r118 = 1.0f;
        goto L33
    L25:
        r115 = 0;
        goto L26
    L18:
        r111 = null;
        goto L19
    L14:
        r109 = null;
        goto L15
    L10:
        r107 = -1;
    L34:
        if (r103 == null) goto L36;
        tt5.a.h("TtsMediaViewModel", "updateNotificationMedia, mediaBean: " + r103);
        TtsMediaService r119 = r101.f239681b;
        r119.f239660g = r103;
        r119.d();
        r101.f239681b.f();
        r101.f239681b.e();
        r101.f239681b.c();
        return;
    L36:
        tt5.a.h("TtsMediaViewModel", "updateNotificationMedia, no playing media, remove remote media.");
        TtsMediaService r120 = r101.f239681b;
        int r121 = TtsMediaService.f239653l;
        r120.b();
        return;
    L37:
        tt5.a.k("TtsMediaViewModel", "updateNotificationMedia, remoteBinder is null.");
    }

    public final void c(mo5.g r100) {
        if (r100 != null) goto L6;
        tt5.a.d("TtsMediaViewModel", "stopItemObserver, itemVM is null.");
        return;
    L6:
        tt5.a.h("TtsMediaViewModel", "stopItemObserver.");
        r100.i().removeObserver(this.f239701d);
        r100.u().removeObserver(this.f239702e);
        r100.o().removeObserver(this.f239703f);
        r100.r().removeObserver(this.f239704g);
        r100.g().removeObserver(this.f239705h);
    }
}
