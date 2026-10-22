package com.bytedance.android.shopping.widget.ecvideoplayer;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.bytedance.android.shopping.api.video.AVScene;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.texturerender.VideoSurface;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineListener;
import com.ss.ttvideoengine.utils.Error;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECVideoPlayer implements VideoEngineListener {
    public static final /* synthetic */ int r = 0;
    public TTVideoEngine a;
    public final k b;
    public volatile boolean c;
    public boolean d;
    public final LinkedList<com.bytedance.android.shopping.widget.ecvideoplayer.b> e;
    public final LinkedList<com.bytedance.android.shopping.widget.ecvideoplayer.b> f;
    public final com.bytedance.android.shopping.widget.ecvideoplayer.i g;
    public int h;
    public int i;
    public boolean j;
    public volatile boolean k;
    public Error l;
    public final b m;
    public final ReentrantLock n;
    public final Condition o;
    public final Context p;
    public final AVScene q;

    public static final class a {
        public static String a(int r1) {
            if (r1 == (-1)) goto L25;
            if (r1 != 0) goto L6;
            return "idle";
        L6:
            if (r1 != 2) goto L8;
            return "prepared";
        L8:
            if (r1 != 3) goto L10;
            return "playing";
        L10:
            if (r1 != 4) goto L12;
            return "paused";
        L12:
            if (r1 != 6) goto L14;
            return "release";
        L14:
            if (r1 != 7) goto L16;
            return "preparing";
        L16:
            if (r1 == 8) goto L18;
            return "";
        L18:
            return "buffering";
        L25:
            return "error";
        }
    }

    public static final class b extends Handler {
        public final /* synthetic */ ECVideoPlayer a;

        @Override // android.os.Handler
        public final void handleMessage(Message r7) {
            Intrinsics.checkNotNullParameter(r7, "msg");
            if (r7.what != 1) goto L32;
            ECVideoPlayer r8 = this.a;
            TTVideoEngine r1 = r8.a;
            if (r1 == null) goto L7;
            int r2 = r1.getCurrentPlaybackTime();
        L8:
            if (r2 > 0) goto L10;
        L15:
            Iterator<T> r3 = r8.d().iterator();
        L17:
            if (r3.hasNext() == false) goto L27;
            com.bytedance.android.shopping.widget.ecvideoplayer.b r4 = (com.bytedance.android.shopping.widget.ecvideoplayer.b) r3.next();
            TTVideoEngine r5 = r8.a;
            if (r5 == null) goto L21;
            int r6 = r5.getCurrentPlaybackTime();
        L22:
            TTVideoEngine r9 = r8.a;
            if (r9 == null) goto L25;
            int r10 = r9.getDuration();
        L26:
            r4.h(r6, r10);
            goto L17
        L25:
            r10 = 0;
            goto L26
        L21:
            r6 = 0;
            goto L22
        L27:
            sendEmptyMessageDelayed(1, 500);
            return;
        L10:
            if (r8.g.d != 2) goto L12;
            boolean r11 = true;
        L13:
            if (r11 == false) goto L15;
            r8.g.a(3);
            r8.c();
            goto L15
        L12:
            r11 = false;
            goto L13
        L7:
            r2 = 0;
            goto L8
        }

        public b(ECVideoPlayer r1, Looper r2) {
            this.a = r1;
            super(r2);
        }
    }

    public static final class c extends com.bytedance.android.shopping.widget.ecvideoplayer.j {
        public final /* synthetic */ TTVideoEngine c;
        public final /* synthetic */ ECVideoPlayer d;

        @Override // com.bytedance.android.shopping.widget.ecvideoplayer.j
        public final void a() {
            this.d.g(this);
            this.c.stop();
            this.d.m.removeMessages(1);
        }

        public c(TTVideoEngine r1, ECVideoPlayer r2) {
            this.c = r1;
            this.d = r2;
            super(6);
        }
    }

    public static final class d extends com.bytedance.android.shopping.widget.ecvideoplayer.j {
        public final /* synthetic */ TTVideoEngine c;
        public final /* synthetic */ ECVideoPlayer d;
        public final /* synthetic */ Surface e;

        @Override // com.bytedance.android.shopping.widget.ecvideoplayer.j
        public final void a() {
            if (this.e.isValid() == false) goto L8;
            this.c.setSurface(this.e);
            this.d.c = true;
            if (this.e.isValid() == true) goto L8;
            this.c.setSurface(null);
            this.d.c = false;
        L8:
            if (this.d.c == false) goto L13;
            int r0 = com.bytedance.android.shopping.widget.ecvideoplayer.a.a;
            StringBuilder r1 = new StringBuilder("PlayerTaskExecutor");
            k r4 = this.a;
            if (r4 != null) goto L12;
            Intrinsics.throwUninitializedPropertyAccessException("playerTaskExecutor");
        L12:
            r1.append(r4.hashCode());
            r1.append(" run setSurface success ");
            r1.append(b());
            r1.append(" surface = ");
            r1.append(this.e.hashCode());
            r1.append(" isSurfaceValid = ");
            r1.append(this.e.isValid());
            com.bytedance.android.shopping.widget.ecvideoplayer.a.a(r1.toString());
            return;
        L13:
            int r2 = com.bytedance.android.shopping.widget.ecvideoplayer.a.a;
            StringBuilder r3 = new StringBuilder("PlayerTaskExecutor");
            k r5 = this.a;
            if (r5 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("playerTaskExecutor");
        L16:
            r3.append(r5.hashCode());
            r3.append(" run setSurface fail ");
            r3.append(b());
            r3.append(" surface = ");
            r3.append(this.e.hashCode());
            r3.append(" isSurfaceValid = ");
            r3.append(this.e.isValid());
            com.bytedance.android.shopping.widget.ecvideoplayer.a.a(r3.toString());
        }

        public d(TTVideoEngine r1, ECVideoPlayer r2, Surface r3) {
            this.c = r1;
            this.d = r2;
            this.e = r3;
            super(10);
        }
    }

    public static final class e extends com.bytedance.android.shopping.widget.ecvideoplayer.j {
        public final /* synthetic */ TTVideoEngine c;
        public final /* synthetic */ ECVideoPlayer d;

        @Override // com.bytedance.android.shopping.widget.ecvideoplayer.j
        public final void a() {
            this.c.setSurface(null);
            this.d.c = false;
            int r0 = com.bytedance.android.shopping.widget.ecvideoplayer.a.a;
            StringBuilder r1 = new StringBuilder("PlayerTaskExecutor");
            k r2 = this.a;
            if (r2 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("playerTaskExecutor");
        L5:
            r1.append(r2.hashCode());
            r1.append(" run ");
            r1.append(b());
            r1.append(" onSurfaceDestroy");
            com.bytedance.android.shopping.widget.ecvideoplayer.a.a(r1.toString());
        }

        public e(TTVideoEngine r1, ECVideoPlayer r2) {
            this.c = r1;
            this.d = r2;
            super(10);
        }
    }

    public static final class f extends com.bytedance.android.shopping.widget.ecvideoplayer.j {
        public final /* synthetic */ TTVideoEngine c;
        public final /* synthetic */ ECVideoPlayer d;

        @Override // com.bytedance.android.shopping.widget.ecvideoplayer.j
        public final void a() {
            com.bytedance.android.shopping.widget.ecvideoplayer.i r0 = this.d.g;
            r0.getClass();
            if (r0.c(new int[]{3}) == false) goto L5;
            this.d.g(this);
            this.c.pause();
            return;
        L5:
            this.d.f(this);
        }

        public f(TTVideoEngine r1, ECVideoPlayer r2) {
            this.c = r1;
            this.d = r2;
            super(1);
        }
    }

    public static final class g extends com.bytedance.android.shopping.widget.ecvideoplayer.j {
        public final /* synthetic */ TTVideoEngine c;
        public final /* synthetic */ ECVideoPlayer d;

        @Override // com.bytedance.android.shopping.widget.ecvideoplayer.j
        public final void a() {
            com.bytedance.android.shopping.widget.ecvideoplayer.i r0 = this.d.g;
            r0.getClass();
            if (r0.c(new int[]{0, 4, -1}) == false) goto L31;
            this.d.g(this);
            boolean r1 = true;
            if (this.d.g.d != 0) goto L7;
            boolean r2 = true;
        L8:
            if (r2 == false) goto L10;
        L14:
            this.d.g.a(7);
            this.d.c();
        L15:
            ECVideoPlayer r3 = this.d;
            TTVideoEngine r4 = r3.a;
            if (r4 == null) goto L19;
            r4.setIsMute(r3.j);
        L19:
            if (this.d.q.getTag().length() <= 0) goto L21;
            boolean r5 = true;
        L22:
            if (r5 == false) goto L25;
            this.c.setTag(this.d.q.getTag());
        L25:
            if (this.d.q.getSubTag().length() > 0) goto L28;
            r1 = false;
        L28:
            if (r1 == false) goto L30;
            this.c.setSubTag(this.d.q.getSubTag());
        L30:
            dm.a.a("ECVideoPlayer").i("play tag: " + this.d.q.getTag() + ", subTag: " + this.d.q.getSubTag());
            this.c.play();
            return;
        L21:
            r5 = false;
            goto L22
        L10:
            if (this.d.g.d != (-1)) goto L12;
            boolean r6 = true;
        L13:
            if (r6 == false) goto L15;
        L12:
            r6 = false;
            goto L13
        L7:
            r2 = false;
            goto L8
        L31:
            this.d.f(this);
        }

        public g(TTVideoEngine r1, ECVideoPlayer r2) {
            this.c = r1;
            this.d = r2;
            super(0);
        }
    }

    public static final class h extends com.bytedance.android.shopping.widget.ecvideoplayer.j {
        public final /* synthetic */ TTVideoEngine c;
        public final /* synthetic */ ECVideoPlayer d;

        @Override // com.bytedance.android.shopping.widget.ecvideoplayer.j
        public final void a() {
            this.d.g(this);
            this.c.releaseAsync();
        }

        public h(TTVideoEngine r1, ECVideoPlayer r2) {
            this.c = r1;
            this.d = r2;
            super(3);
        }
    }

    public static final class i extends com.bytedance.android.shopping.widget.ecvideoplayer.j {
        public final /* synthetic */ ECVideoPlayer c;
        public final /* synthetic */ String d;

        @Override // com.bytedance.android.shopping.widget.ecvideoplayer.j
        public final void a() {
            TTVideoEngine r0 = this.c.a;
            if (r0 == null) goto L5;
            r0.setDirectURL(this.d);
        L5:
            this.c.g(this);
        }

        public i(ECVideoPlayer r1, String r2) {
            this.c = r1;
            this.d = r2;
            super(4);
        }
    }

    public static final class j extends com.bytedance.android.shopping.widget.ecvideoplayer.j {
        public final /* synthetic */ TTVideoEngine c;
        public final /* synthetic */ ECVideoPlayer d;

        @Override // com.bytedance.android.shopping.widget.ecvideoplayer.j
        public final void a() {
            com.bytedance.android.shopping.widget.ecvideoplayer.i r0 = this.d.g;
            r0.getClass();
            if (r0.c(new int[]{3, 4, 2}) == false) goto L7;
            this.d.g(this);
            this.c.stop();
            if (this.d.g.d != 2) goto L9;
            ECVideoPlayer r1 = this.d;
            r1.i = 0;
            r1.h = 0;
            r1.g.a(0);
            r1.m.removeMessages(1);
            r1.c();
            return;
        L9:
            return;
        L7:
            this.d.f(this);
        }

        public j(TTVideoEngine r1, ECVideoPlayer r2) {
            this.c = r1;
            this.d = r2;
            super(2);
        }
    }

    static {
    }

    public final void onBufferingUpdate(TTVideoEngine r1, int r2) {
    }

    public final /* synthetic */ void onFirstAVSyncFrame(TTVideoEngine r1) {
        VideoEngineListener.-CC.$default$onFirstAVSyncFrame(this, r1);
    }

    public final void onPrepare(TTVideoEngine r1) {
    }

    public final /* synthetic */ void onRefreshSurface(TTVideoEngine r1) {
        VideoEngineListener.-CC.$default$onRefreshSurface(this, r1);
    }

    public final /* synthetic */ int onSetSurface(TTVideoEngine r1, VideoSurface r2, Surface r3) {
        return VideoEngineListener.-CC.$default$onSetSurface(this, r1, r2, r3);
    }

    public final /* synthetic */ void onSilenceDetected(TTVideoEngine r1) {
        VideoEngineListener.-CC.$default$onSilenceDetected(this, r1);
    }

    public final void onStreamChanged(TTVideoEngine r1, int r2) {
    }

    public final /* synthetic */ void onVideoSecondFrame(TTVideoEngine r1) {
        VideoEngineListener.-CC.$default$onVideoSecondFrame(this, r1);
    }

    public final void c() {
        Function0<Unit> r0 = new ECVideoPlayer$dispatchVideoStatusToAll$1(this);
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        r0.invoke();
        return;
    L8:
        this.m.post(new com.bytedance.android.shopping.widget.ecvideoplayer.c(r0));
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final List<com.bytedance.android.shopping.widget.ecvideoplayer.b> d() {
        this.f.clear();
        this.f.addAll(this.e);
        return this.f;
    }

    public final boolean e() {
        if (this.g.d != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public final void i() {
        int r0 = com.bytedance.android.shopping.widget.ecvideoplayer.a.a;
        com.bytedance.android.shopping.widget.ecvideoplayer.a.a("PlayerTaskExecutor" + this.b.hashCode() + " onSurfaceDestroy");
        b();
        TTVideoEngine r1 = this.a;
        if (r1 == null) goto L6;
        this.b.c(new e(r1, this));
        return;
    }

    public final void b() {
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return;
    L9:
        throw new IllegalStateException("only main thread can touch");
    L5:
        r0 = false;
        goto L6
    }

    public final void j() {
        b();
        TTVideoEngine r0 = this.a;
        if (r0 == null) goto L6;
        this.b.c(new f(r0, this));
        return;
    }

    public final void k() {
        b();
        TTVideoEngine r0 = this.a;
        if (r0 == null) goto L6;
        this.b.c(new g(r0, this));
        return;
    }

    public final void l() {
        b();
        this.g.a(6);
        TTVideoEngine r0 = this.a;
        this.a = null;
        Iterator<T> r1 = d().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((com.bytedance.android.shopping.widget.ecvideoplayer.b) r1.next()).onRelease();
        goto L4
    L6:
        if (r0 == null) goto L10;
        this.b.c(new h(r0, this));
        this.m.removeMessages(1);
        return;
    }

    public final void q() {
        b();
        TTVideoEngine r0 = this.a;
        if (r0 == null) goto L6;
        this.b.c(new j(r0, this));
        return;
    }

    public final Context getContext() {
        return this.p;
    }

    public /* synthetic */ ECVideoPlayer(Context r2) {
        this(r2, AVScene.CONTENT_DEFAULT);
    }

    public final void a(com.bytedance.android.shopping.widget.ecvideoplayer.b r3) {
        Intrinsics.checkNotNullParameter(r3, "ecVideoListener");
        b();
        this.e.add(r3);
        ECVideoPlayer$dispatchVideoStatus$1 r0 = new ECVideoPlayer$dispatchVideoStatus$1(this, r3);
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L8;
        r0.invoke();
        return;
    L8:
        this.m.post(new com.bytedance.android.shopping.widget.ecvideoplayer.c(r0));
        return;
    L5:
        r4 = false;
        goto L6
    }

    public final void f(com.bytedance.android.shopping.widget.ecvideoplayer.j r3) {
        Intrinsics.checkNotNullParameter(r3, "playerTask");
        int r0 = com.bytedance.android.shopping.widget.ecvideoplayer.a.a;
        com.bytedance.android.shopping.widget.ecvideoplayer.a.a("PlayerTaskExecutor" + this.b.hashCode() + " ignore " + r3.b() + " PlayerState = " + a.a(this.g.d) + " due to error or release");
    }

    public final void g(com.bytedance.android.shopping.widget.ecvideoplayer.j r3) {
        Intrinsics.checkNotNullParameter(r3, "playerTask");
        int r0 = com.bytedance.android.shopping.widget.ecvideoplayer.a.a;
        com.bytedance.android.shopping.widget.ecvideoplayer.a.a("PlayerTaskExecutor" + this.b.hashCode() + " run " + r3.b() + " PlayerState = " + a.a(this.g.d));
    }

    public final void h(Surface r4) {
        Intrinsics.checkNotNullParameter(r4, "surface");
        int r0 = com.bytedance.android.shopping.widget.ecvideoplayer.a.a;
        com.bytedance.android.shopping.widget.ecvideoplayer.a.a("PlayerTaskExecutor" + this.b.hashCode() + " onSurfaceCreated surface" + r4.hashCode());
        b();
        TTVideoEngine r1 = this.a;
        if (r1 == null) goto L6;
        this.b.c(new d(r1, this, r4));
        return;
    }

    public final void m(com.bytedance.android.shopping.widget.ecvideoplayer.b r2) {
        Intrinsics.checkNotNullParameter(r2, "ecVideoListener");
        b();
        this.e.remove(r2);
    }

    public final void n(boolean r2) {
        TTVideoEngine r0 = this.a;
        if (r0 == null) goto L5;
        r0.setLooping(r2);
    L5:
        this.d = r2;
    }

    public final void o(boolean r2) {
        this.j = r2;
        TTVideoEngine r0 = this.a;
        if (r0 == null) goto L6;
        r0.setIsMute(r2);
        return;
    }

    public final void onCompletion(TTVideoEngine r5) {
        if (this.d == false) goto L5;
        return;
    L5:
        if (this.a == null) goto L7;
        this.b.c(new com.bytedance.android.shopping.widget.ecvideoplayer.f(5));
    L7:
        Iterator<T> r6 = d().iterator();
    L9:
        if (r6.hasNext() == false) goto L22;
        com.bytedance.android.shopping.widget.ecvideoplayer.b r0 = (com.bytedance.android.shopping.widget.ecvideoplayer.b) r6.next();
        TTVideoEngine r1 = this.a;
        int r2 = 0;
        if (r1 == null) goto L13;
        int r3 = r1.getDuration();
    L14:
        TTVideoEngine r4 = this.a;
        if (r4 == null) goto L17;
        r2 = r4.getDuration();
    L17:
        r0.h(r3, r2);
        r0.g();
        goto L9
    L13:
        r3 = 0;
        goto L14
    }

    public final void onError(Error r3) {
        int r0 = com.bytedance.android.shopping.widget.ecvideoplayer.a.a;
        StringBuilder r1 = new StringBuilder("PlayerTaskExecutor");
        r1.append(this.b.hashCode());
        r1.append(" onError RetryStrategy=");
        if (r3 == null) goto L5;
        Integer r2 = Integer.valueOf(r3.getRetryStrategy());
    L6:
        r1.append(r2);
        r1.append(" onError=");
        r1.append(r3);
        com.bytedance.android.shopping.widget.ecvideoplayer.a.a(r1.toString());
        if (this.k == false) goto L9;
        return;
    L9:
        this.l = r3;
        this.k = true;
        this.g.a(-1);
        TTVideoEngine r4 = this.a;
        if (r4 == null) goto L12;
        this.b.c(new c(r4, this));
    L12:
        c();
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void onPrepared(TTVideoEngine r2) {
        int r3 = com.bytedance.android.shopping.widget.ecvideoplayer.a.a;
        com.bytedance.android.shopping.widget.ecvideoplayer.a.a("PlayerTaskExecutor" + this.b.hashCode() + " onPrepared isInErrorProcessing=" + this.k);
        if (this.k == false) goto L5;
        return;
    L5:
        this.g.a(2);
        if (this.m.hasMessages(1) == true) goto L9;
        this.m.sendEmptyMessage(1);
        return;
    }

    public final void onRenderStart(TTVideoEngine r2) {
        int r3 = com.bytedance.android.shopping.widget.ecvideoplayer.a.a;
        com.bytedance.android.shopping.widget.ecvideoplayer.a.a("PlayerTaskExecutor" + this.b.hashCode() + " DispatchPlayerEvent onRenderStart");
        Iterator<T> r4 = d().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        ((com.bytedance.android.shopping.widget.ecvideoplayer.b) r4.next()).onRenderStart();
        goto L4
    }

    public final void onVideoStatusException(int r4) {
        onError(new Error("error", 0, String.valueOf(r4)));
    }

    public final void p(String r3) {
        Intrinsics.checkNotNullParameter(r3, "url");
        b();
        if (this.a == null) goto L6;
        this.b.c(new i(this, r3));
        return;
    }

    public ECVideoPlayer(Context r5, AVScene r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "scene");
        this.p = r5;
        this.q = r6;
        this.a = new TTVideoEngine(r5, 0);
        k r7 = new k(this);
        this.b = r7;
        this.e = new LinkedList();
        this.f = new LinkedList();
        com.bytedance.android.shopping.widget.ecvideoplayer.i r0 = new com.bytedance.android.shopping.widget.ecvideoplayer.i();
        this.g = r0;
        this.m = new b(this, Looper.getMainLooper());
        TTVideoEngine r1 = this.a;
        if (r1 == null) goto L5;
        r1.setListener(this);
        r1.setTag(r6.getTag());
        r1.setSubTag(r6.getSubTag());
        dm.a.a("ECVideoPlayer").i("init tag: " + r6.getTag() + ", subTag: " + r6.getSubTag());
    L5:
        r0.c = r7.hashCode();
        TTVideoEngine r8 = this.a;
        if (r8 == null) goto L8;
        r8.setIntOption(4, 1);
    L8:
        ReentrantLock r9 = new ReentrantLock();
        this.n = r9;
        this.o = r9.newCondition();
    }

    public final void onLoadStateChanged(TTVideoEngine r5, int r6) {
        int r7 = com.bytedance.android.shopping.widget.ecvideoplayer.a.a;
        com.bytedance.android.shopping.widget.ecvideoplayer.a.a("PlayerTaskExecutor" + this.b.hashCode() + " onLoadStateChanged " + r6 + " isInErrorProcessing=" + this.k);
        if (this.k == false) goto L5;
        return;
    L5:
        boolean r2 = false;
        if (r6 == 1) goto L23;
        if (r6 == 2) goto L10;
        return;
    L10:
        if (this.g.d != 0) goto L12;
        boolean r8 = true;
    L13:
        if (r8 == false) goto L16;
        this.g.a(7);
        c();
        return;
    L16:
        if (e() == false) goto L18;
    L21:
        this.g.a(8);
        c();
        return;
    L18:
        if (this.g.d != 2) goto L20;
        r2 = true;
    L20:
        if (r2 == true) goto L21;
        return;
    L12:
        r8 = false;
        goto L13
    L23:
        if (this.g.d != 7) goto L25;
        boolean r9 = true;
    L26:
        if (r9 == false) goto L31;
        this.g.a(2);
        c();
        if (this.m.hasMessages(1) == true) goto L39;
        this.m.sendEmptyMessage(1);
        return;
    L39:
        return;
    L31:
        if (this.g.d != 8) goto L33;
        r2 = true;
    L33:
        if (r2 == false) goto L41;
        this.g.a(3);
        c();
        return;
    L41:
        return;
    L25:
        r9 = false;
        goto L26
    }

    public final void onPlaybackStateChanged(TTVideoEngine r5, int r6) {
        int r0 = com.bytedance.android.shopping.widget.ecvideoplayer.a.a;
        com.bytedance.android.shopping.widget.ecvideoplayer.a.a("PlayerTaskExecutor" + this.b.hashCode() + " onPlaybackStateChanged " + r6 + " isInErrorProcessing=" + this.k);
        if (this.k == false) goto L8;
        if (r6 != 0) goto L29;
        this.k = false;
        return;
    L29:
        return;
    L8:
        if (r6 != 0) goto L10;
        this.i = 0;
        this.h = 0;
        this.g.a(0);
        this.m.removeMessages(1);
        c();
        return;
    L10:
        if (r6 == 1) goto L24;
        if (r6 == 2) goto L22;
        if (r6 == 3) goto L16;
        return;
    L16:
        if (r5 == null) goto L20;
        JSONObject r7 = r5.getPlayErrorInfo();
        if (r7 == null) goto L20;
        String r8 = r7.toString();
    L21:
        onError(new Error("error", 0, r8));
        return;
    L20:
        r8 = null;
        goto L21
    L22:
        this.g.a(4);
        this.m.removeMessages(1);
        c();
        return;
    L24:
        if (this.m.hasMessages(1) == true) goto L26;
        this.m.sendEmptyMessage(1);
    L26:
        this.g.a(3);
        c();
    }

    public final void onVideoSizeChanged(TTVideoEngine r2, int r3, int r4) {
        this.h = r3;
        this.i = r4;
        Iterator<T> r5 = d().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((com.bytedance.android.shopping.widget.ecvideoplayer.b) r5.next()).onVideoSizeChanged(r3, r4);
        goto L4
    }
}
