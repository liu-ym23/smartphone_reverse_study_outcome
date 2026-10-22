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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public final mo5.a a;
    public final d b;
    public final com.bytedance.ee.bear.tts.media.c c;
    public final f d;
    public final j e;
    public final g f;
    public final h g;
    public final i h;
    public final Lazy i;
    public final Lazy j;
    public TtsMediaService.f k;
    public boolean l;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.tts.media.b$b, reason: collision with other inner class name */
    public final class ServiceConnectionC0193b implements ServiceConnection {
        public final /* synthetic */ b a;

        public ServiceConnectionC0193b(b r1) {
            this.a = r1;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r3) {
            tt5.a.h("TtsMediaViewModel", "TtsMediaServiceConnection-onServiceDisconnected, name: " + r3);
            b r4 = this.a;
            TtsMediaService.f r0 = r4.k;
            if (r0 == null) goto L9;
            TtsMediaService.b r1 = r0.a;
            if (r1 == null) goto L7;
            r1.b();
        L7:
            r0.a = null;
            r4.k = null;
            return;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r4, IBinder r5) {
            tt5.a.h("TtsMediaViewModel", "TtsMediaServiceConnection-onServiceConnected, name: " + r4 + ", service: " + r5);
            b r6 = this.a;
            if ((r5 instanceof TtsMediaService.f) == false) goto L5;
            TtsMediaService.f r7 = (TtsMediaService.f) r5;
        L6:
            r6.k = r7;
            if (r7 == null) goto L12;
            TtsMediaService.b r8 = (TtsMediaService.b) r6.j.getValue();
            Intrinsics.checkNotNullParameter(r8, "remoteListener");
            TtsMediaService.b r1 = r7.a;
            if (r1 == null) goto L11;
            r1.b();
        L11:
            r7.a = r8;
        L12:
            this.a.getClass();
            tt5.a.h("TtsMediaViewModel", "startRemoteForeground.");
            Application r9 = LarkContext.getApplication();
            Intent r10 = new Intent(r9, TtsMediaService.class);
            r10.setAction(TtsMediaRemoteAction.FOREGROUND.getActionName());
        L18:
            e = move-exception;
            tt5.a.e("TtsMediaViewModel", "startRemoteForeground, error:", e, false);
            Unit r11 = Unit.INSTANCE;
            return;
        L14:
            if (Build.VERSION.SDK_INT < 26) goto L16;
            r9.startForegroundService(r10);     // Catch: Exception -> L18
        L21:
            return;
        L16:
            r9.startService(r10);     // Catch: Exception -> L18
            goto L21
        L5:
            r7 = null;
            goto L6
        }
    }

    public final class c implements TtsMediaService.b {
        public final /* synthetic */ b a;

        public static final class a implements Runnable {
            public final /* synthetic */ b a;

            /* JADX INFO: renamed from: com.bytedance.ee.bear.tts.media.b$c$a$a, reason: collision with other inner class name */
            public static final class C0194a implements mo5.b {
                public static final C0194a a = null;

                static {
                    a = new C0194a();
                }

                public C0194a() {
                }

                @Override // mo5.b
                public final void a(TtsResult r2) {
                    Intrinsics.checkNotNullParameter(r2, "it");
                    com.bytedance.ee.bear.tts.a.a(r2);
                }
            }

            public a(b r1) {
                this.a = r1;
            }

            public final void a() {
                List r0 = (List) this.a.a.b().getValue();
                if (r0 == null) goto L5;
                int r1 = r0.size();
            L7:
                if (r1 <= 1) goto L9;
            L12:
                tt5.a.h("TtsMediaViewModel", "TtsMediaServiceListener-onRemoteNext, albumVM: " + this.a.a);
                mo5.g r2 = mo5.h.e(this.a.a);
                if (r2 == null) goto L20;
                mo5.g r3 = this.a.a.d(r2);
                if (r3 == null) goto L21;
                mo5.g r4 = this.a.a.h(r3);
                if (r4 == null) goto L22;
                tt5.a.h("TtsMediaViewModel", "TtsMediaServiceListener-onRemoteNext, selectedVM: " + r4);
                r4.p(TtsLoadScene.SWITCH_ITEM, C0194a.a);
                return;
            L22:
                return;
            L21:
                return;
            L20:
                return;
            L9:
                if (mo5.h.e(this.a.a) == null) goto L12;
                tt5.a.h("TtsMediaViewModel", "TtsMediaServiceListener-onRemoteNext, no more item to switch.");
                return;
            L5:
                r1 = 0;
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
        public static final class RunnableC0195b implements Runnable {
            public final /* synthetic */ b a;

            public RunnableC0195b(b r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                mo5.g r0 = mo5.h.e(this.a.a);     // Catch: Throwable -> L6
                if (r0 == null) goto L9;
                r0.pause();     // Catch: Throwable -> L6
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
        public static final class RunnableC0196c implements Runnable {
            public final /* synthetic */ b a;

            /* JADX INFO: renamed from: com.bytedance.ee.bear.tts.media.b$c$c$a */
            public static final class a implements mo5.b {
                public static final a a = null;

                static {
                    a = new a();
                }

                public a() {
                }

                @Override // mo5.b
                public final void a(TtsResult r2) {
                    Intrinsics.checkNotNullParameter(r2, "it");
                    com.bytedance.ee.bear.tts.a.a(r2);
                }
            }

            public RunnableC0196c(b r1) {
                this.a = r1;
            }

            public final void a() {
                List r0 = (List) this.a.a.b().getValue();
                if (r0 == null) goto L5;
                int r1 = r0.size();
            L7:
                if (r1 <= 1) goto L9;
            L12:
                tt5.a.h("TtsMediaViewModel", "TtsMediaServiceListener-onRemotePrevious, albumVM: " + this.a.a);
                mo5.g r2 = mo5.h.e(this.a.a);
                if (r2 == null) goto L20;
                mo5.g r3 = this.a.a.f(r2);
                if (r3 == null) goto L21;
                mo5.g r4 = this.a.a.h(r3);
                if (r4 == null) goto L22;
                tt5.a.h("TtsMediaViewModel", "TtsMediaServiceListener-onRemotePrevious, selectedVM: " + r4);
                r4.p(TtsLoadScene.SWITCH_ITEM, a.a);
                return;
            L22:
                return;
            L21:
                return;
            L20:
                return;
            L9:
                if (mo5.h.e(this.a.a) == null) goto L12;
                tt5.a.h("TtsMediaViewModel", "TtsMediaServiceListener-onRemotePrevious, no more item to switch.");
                return;
            L5:
                r1 = 0;
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
            public final /* synthetic */ b a;
            public final /* synthetic */ long b;

            public static final class a implements mo5.b {
                public static final a a = null;

                static {
                    a = new a();
                }

                public a() {
                }

                @Override // mo5.b
                public final void a(TtsResult r3) {
                    Intrinsics.checkNotNullParameter(r3, "it");
                    tt5.a.h("TtsMediaViewModel", "TtsMediaServiceListener-onRemoteProgressMs, seek result: " + r3);
                }
            }

            public d(b r1, long r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                mo5.g r0 = mo5.h.e(this.a.a);     // Catch: Throwable -> L6
                if (r0 == null) goto L9;
                r0.t(this.b, a.a);     // Catch: Throwable -> L6
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
            public final /* synthetic */ b a;

            public static final class a implements mo5.b {
                public static final a a = null;

                static {
                    a = new a();
                }

                public a() {
                }

                @Override // mo5.b
                public final void a(TtsResult r3) {
                    Intrinsics.checkNotNullParameter(r3, "it");
                    tt5.a.h("TtsMediaViewModel", "onRemoteResume, prepareAndResume result: " + r3);
                    com.bytedance.ee.bear.tts.a.a(r3);
                }
            }

            public e(b r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                mo5.g r0 = mo5.h.e(this.a.a);     // Catch: Throwable -> L6
                if (r0 == null) goto L9;
                r0.p(TtsLoadScene.DEFAULT, a.a);     // Catch: Throwable -> L6
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
            com.bytedance.ee.util.ui.j.f(new a(this.a));
        }

        @Override // com.bytedance.ee.bear.tts.media.TtsMediaService.b
        public final void b() {
            tt5.a.h("TtsMediaViewModel", "TtsMediaServiceListener-onRemotePaused");
            com.bytedance.ee.util.ui.j.f(new RunnableC0195b(this.a));
        }

        @Override // com.bytedance.ee.bear.tts.media.TtsMediaService.b
        public final void c() {
            com.bytedance.ee.util.ui.j.f(new RunnableC0196c(this.a));
        }

        @Override // com.bytedance.ee.bear.tts.media.TtsMediaService.b
        public final void e() {
            tt5.a.h("TtsMediaViewModel", "TtsMediaServiceListener-onRemoteResume");
            com.bytedance.ee.util.ui.j.f(new e(this.a));
        }

        public c(b r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.tts.media.TtsMediaService.b
        public final void d(long r3) {
            tt5.a.h("TtsMediaViewModel", "TtsMediaServiceListener-onRemoteProgressMs");
            com.bytedance.ee.util.ui.j.f(new d(this.a, r3));
        }
    }

    static {
    }

    public final void b() {
        tt5.a.h("TtsMediaViewModel", "onDestroy.");
        tt5.a.h("TtsMediaViewModel", "stopAlbumObservers.");
        this.a.e().removeObserver(this.b);
        this.a.b().removeObserver(this.c);
        c(mo5.h.e(this.a));
        List r1 = (List) this.a.b().getValue();
        if (r1 == null) goto L8;
        Iterator r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        c((mo5.g) r2.next());
    L8:
        tt5.a.h("TtsMediaViewModel", "destroyRemoteService.");
        Application r3 = LarkContext.getApplication();
        Intent r4 = new Intent(r3, TtsMediaService.class);
        r4.setAction(TtsMediaRemoteAction.TERMINAL.getActionName());
        r3.startService(r4);     // Catch: Exception -> L11
    L20:
        r3.unbindService((ServiceConnection) this.i.getValue());     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        tt5.a.e("TtsMediaViewModel", "destroyRemoteService, unbindService, error:", e, false);
        return;
    L11:
        e = move-exception;
        tt5.a.e("TtsMediaViewModel", "destroyRemoteService, notify service to stopSelf, error:", e, false);
        Unit r5 = Unit.INSTANCE;
        goto L20
    }

    public b(TtsAlbumViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "albumVM");
        this.a = r2;
        this.b = new d(this);
        this.c = new com.bytedance.ee.bear.tts.media.c(this);
        this.d = new f(this);
        this.e = new j(this);
        this.f = new g(this);
        this.g = new h(this);
        this.h = new i(this);
        this.i = LazyKt.lazy(new TtsMediaViewModel$remoteConnection$2(this));
        this.j = LazyKt.lazy(new TtsMediaViewModel$remoteListener$2(this));
    }

    public static final void a(b r8) {
        TtsMediaService.f r0 = r8.k;
        if (r0 == null) goto L37;
        mo5.g r9 = mo5.h.e(r8.a);
        com.bytedance.ee.bear.tts.media.a r2 = null;
        String r3 = null;
        if (r9 == null) goto L34;
        com.bytedance.ee.bear.tts.media.a r4 = new com.bytedance.ee.bear.tts.media.a();
        r4.a = mo5.h.a(r9);
        Integer r5 = mo5.h.b(r9);
        if (r5 == null) goto L10;
        int r6 = r5.intValue();
    L11:
        r4.b = r6;
        mo5.j r7 = (mo5.j) r9.i().getValue();
        if (r7 == null) goto L14;
        String r10 = r7.c;
    L15:
        r4.c = r10;
        mo5.j r11 = (mo5.j) r9.i().getValue();
        if (r11 == null) goto L18;
        String r12 = r11.d;
    L19:
        r4.d = r12;
        mo5.j r13 = (mo5.j) r9.i().getValue();
        if (r13 == null) goto L22;
        r3 = r13.e;
    L22:
        r4.e = r3;
        r4.f = (IPlayer.State) r9.u().getValue();
        Long r14 = (Long) r9.g().getValue();
        long r15 = 0;
        if (r14 == null) goto L25;
        long r16 = r14.longValue();
    L26:
        r4.g = r16;
        Long r17 = (Long) r9.o().getValue();
        if (r17 == null) goto L29;
        r15 = r17.longValue();
    L29:
        r4.h = r15;
        Float r18 = (Float) r9.r().getValue();
        if (r18 == null) goto L32;
        float r19 = r18.floatValue();
    L33:
        r4.i = r19;
        r2 = r4;
        goto L34
    L32:
        r19 = 1.0f;
        goto L33
    L25:
        r16 = 0;
        goto L26
    L18:
        r12 = null;
        goto L19
    L14:
        r10 = null;
        goto L15
    L10:
        r6 = -1;
    L34:
        if (r2 == null) goto L36;
        tt5.a.h("TtsMediaViewModel", "updateNotificationMedia, mediaBean: " + r2);
        TtsMediaService r20 = r0.b;
        r20.g = r2;
        r20.d();
        r0.b.f();
        r0.b.e();
        r0.b.c();
        return;
    L36:
        tt5.a.h("TtsMediaViewModel", "updateNotificationMedia, no playing media, remove remote media.");
        TtsMediaService r21 = r0.b;
        int r1 = TtsMediaService.l;
        r21.b();
        return;
    L37:
        tt5.a.k("TtsMediaViewModel", "updateNotificationMedia, remoteBinder is null.");
    }

    public final void c(mo5.g r3) {
        if (r3 != null) goto L6;
        tt5.a.d("TtsMediaViewModel", "stopItemObserver, itemVM is null.");
        return;
    L6:
        tt5.a.h("TtsMediaViewModel", "stopItemObserver.");
        r3.i().removeObserver(this.d);
        r3.u().removeObserver(this.e);
        r3.o().removeObserver(this.f);
        r3.r().removeObserver(this.g);
        r3.g().removeObserver(this.h);
    }
}
