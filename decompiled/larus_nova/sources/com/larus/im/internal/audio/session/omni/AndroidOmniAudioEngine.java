package com.larus.im.internal.audio.session.omni;

import android.media.AudioManager;
import android.os.Build;
import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.im.internal.jni.bean.OMNIAVFrameExt;
import com.larus.im.internal.jni.media.OmniAVFrameDataCenter;
import com.larus.im.internal.jni.media.OmniAudioEngineConfig;
import com.larus.im.internal.jni.media.OmniAudioEngineDelegate;
import com.larus.im.internal.jni.media.OmniAudioEngineDeviceState;
import com.larus.im.internal.jni.media.OmniAudioEngineDeviceType;
import com.larus.im.internal.jni.media.OmniAudioEngineMode;
import com.larus.im.internal.jni.media.OmniAudioEngineProtocol;
import com.larus.im.internal.jni.media.OmniAudioExtraCache;
import com.larus.im.internal.jni.media.OmniAudioFrame;
import com.larus.im.internal.jni.media.OmniAudioPlayerDelegate;
import com.larus.im.internal.jni.media.OmniAudioRecorderDelegate;
import com.larus.im.internal.jni.model.OmniAVFrameKtxKt;
import com.larus.media.AudioDeviceMode;
import com.larus.media.AudioInputRoutePolicy;
import com.larus.media.AudioOutputRoutePolicy;
import com.larus.media.AudioPlayer;
import com.larus.media.PlayScenario;
import com.larus.media.RecordSourceType;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes29.dex */
public final class AndroidOmniAudioEngine implements OmniAudioEngineProtocol {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OmniAudioEngineConfig f347202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q f347203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<String, Unit> f347204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f347205d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CopyOnWriteArrayList<OmniAudioEngineDelegate> f347206e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicReference<Boolean> f347207f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicReference<Boolean> f347208g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicReference<Boolean> f347209h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicBoolean f347210i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ok9.a f347211j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final qk9.b f347212k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.larus.media.n f347213l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public AudioPlayer f347214m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Function1<? super byte[], Unit> f347215n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.larus.media.a f347216o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.larus.media.a f347217p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f347218q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f347219r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final n0 f347220s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public OmniAudioExtraCache f347221t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public OmniAudioExtraCache f347222u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ExecutorService f347223v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f347224w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public o0 f347225x;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f347226a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f347227b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f347226a == r101.f347226a) goto L12;
            return false;
        L12:
            if (this.f347227b == r101.f347227b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f347226a * 31;
            if (this.f347227b == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "PlayerChannelConfig(channelConfig=" + this.f347226a + ", enableStereoPlayoutGain=" + this.f347227b + ')';
        }

        public b(int r100, boolean r101) {
            this.f347226a = r100;
            this.f347227b = r101;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AndroidOmniAudioEngine f347228a;

        public c(AndroidOmniAudioEngine r100) {
            this.f347228a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f347228a.g(false);     // Catch: Throwable -> L4
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
        public final /* synthetic */ float f347229a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AndroidOmniAudioEngine f347230b;

        public d(float r100, AndroidOmniAudioEngine r101) {
            this.f347229a = r100;
            this.f347230b = r101;
        }

        public final void a() {
            float r100 = RangesKt.coerceIn(this.f347229a, 0.0f, 1.0f);     // Catch: Exception -> L7
            fe9.c.f476624a.a(this.f347230b.f347205d, "Setting player volume to: " + r100);     // Catch: Exception -> L7
            AudioPlayer r101 = this.f347230b.f347214m;     // Catch: Exception -> L7
            if (r101 == null) goto L12;
            r101.H(r100);     // Catch: Exception -> L7
            return;
        L12:
            return;
        L7:
            e = move-exception;
            fe9.c.f476624a.b(this.f347230b.f347205d, "Failed to set volume: " + e.getMessage());
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

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AndroidOmniAudioEngine f347231a;

        public e(AndroidOmniAudioEngine r100) {
            this.f347231a = r100;
        }

        public final void a() {
            if (this.f347231a.f347209h.get().booleanValue() == false) goto L13;
            fe9.c.f476624a.f(this.f347231a.f347205d, "Player is not playing or already paused, " + this.f347231a.f());
            return;
        L13:
            fe9.c.f476624a.a(this.f347231a.f347205d, "Pausing player");     // Catch: Exception -> L10
            this.f347231a.f347209h.set(Boolean.TRUE);     // Catch: Exception -> L10
            AudioPlayer r100 = this.f347231a.f347214m;     // Catch: Exception -> L10
            if (r100 == null) goto L8;
            r100.A();     // Catch: Exception -> L10
        L8:
            AndroidOmniAudioEngine.a(this.f347231a);     // Catch: Exception -> L10
            return;
        L10:
            e = move-exception;
            fe9.c.f476624a.b(this.f347231a.f347205d, "Failed to pause player: " + e.getMessage());
            AndroidOmniAudioEngine.k(this.f347231a, OmniAudioEngineDeviceState.ERROR, OmniAudioEngineDeviceType.PLAYER, e);
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

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AndroidOmniAudioEngine f347232a;

        public f(AndroidOmniAudioEngine r100) {
            this.f347232a = r100;
        }

        public final void a() {
        L11:
            e = move-exception;
            fe9.c.f476624a.b(this.f347232a.f347205d, "Failed to resume player: " + e.getMessage());
            AndroidOmniAudioEngine.k(this.f347232a, OmniAudioEngineDeviceState.ERROR, OmniAudioEngineDeviceType.PLAYER, e);
            return;
        L4:
            if (this.f347232a.f347209h.get().booleanValue() == true) goto L6;
            fe9.c.f476624a.f(this.f347232a.f347205d, "Player is not paused, " + this.f347232a.f());     // Catch: Exception -> L11
            return;
        L6:
            fe9.c.f476624a.a(this.f347232a.f347205d, "Resuming player");     // Catch: Exception -> L11
            this.f347232a.f347209h.set(Boolean.FALSE);     // Catch: Exception -> L11
            AudioPlayer r100 = this.f347232a.f347214m;     // Catch: Exception -> L11
            if (r100 == null) goto L9;
            r100.F();     // Catch: Exception -> L11
        L9:
            AndroidOmniAudioEngine.b(this.f347232a);     // Catch: Exception -> L11
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

    public static final class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AndroidOmniAudioEngine f347233a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f347234b;

        public g(AndroidOmniAudioEngine r100, boolean r101) {
            this.f347233a = r100;
            this.f347234b = r101;
        }

        public final void a() {
            AndroidOmniAudioEngine r100 = this.f347233a;
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
            if (r100.f347202a.getMode() == OmniAudioEngineMode.PLAY_ONLY) goto L16;
            fe9.c.f476624a.e(r100.f347205d, "setBluetoothForceToMedia, enable=" + this.f347234b);     // Catch: Throwable -> L8
            r100.h().i(this.f347234b);     // Catch: Throwable -> L8
            r100.h().f359102f = r100.o(r100.f347216o);     // Catch: Throwable -> L8
            r100.c("reconfigureAudioDevice");     // Catch: Throwable -> L8
            Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        L10:
            Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
            if (r103 == null) goto L17;
            fe9.c.f476624a.b(this.f347233a.f347205d, "Failed to setBluetoothForceToMedia, enable=" + this.f347234b + ", error=" + r103);
            return;
        L17:
            return;
        L16:
            return;
        L8:
            th = move-exception;
            Result.Companion r104 = Result.Companion;
            r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L10
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

    public static final class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AndroidOmniAudioEngine f347235a;

        public h(AndroidOmniAudioEngine r100) {
            this.f347235a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f347235a.p();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AndroidOmniAudioEngine f347236a;

        public i(AndroidOmniAudioEngine r100) {
            this.f347236a = r100;
        }

        public final void a() {
        L10:
            e = move-exception;
            fe9.c.f476624a.b(this.f347236a.f347205d, "Failed to start recorder: " + e.getMessage());
            this.f347236a.f347207f.set(Boolean.FALSE);
            AndroidOmniAudioEngine.k(this.f347236a, OmniAudioEngineDeviceState.ERROR, OmniAudioEngineDeviceType.RECORDER, e);
            return;
        L3:
            if (this.f347236a.f347207f.get().booleanValue() == false) goto L5;
            fe9.c.f476624a.f(this.f347236a.f347205d, "Recorder already started");     // Catch: Exception -> L10
            return;
        L5:
            fe9.c.f476624a.a(this.f347236a.f347205d, "Starting recorder");     // Catch: Exception -> L10
            this.f347236a.f347207f.set(Boolean.TRUE);     // Catch: Exception -> L10
            this.f347236a.f347211j.b(true);     // Catch: Exception -> L10
            this.f347236a.i().setIsRecording(true);     // Catch: Exception -> L10
            com.larus.media.n r100 = this.f347236a.f347213l;     // Catch: Exception -> L10
            if (r100 == null) goto L8;
            r100.start();     // Catch: Exception -> L10
        L8:
            AndroidOmniAudioEngine.k(this.f347236a, OmniAudioEngineDeviceState.STARTED, OmniAudioEngineDeviceType.RECORDER, null);     // Catch: Exception -> L10
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

    public static final class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AndroidOmniAudioEngine f347237a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f347238b;

        public j(AndroidOmniAudioEngine r100, boolean r101) {
            this.f347237a = r100;
            this.f347238b = r101;
        }

        public final void a() {
        L10:
            e = move-exception;
            fe9.c.f476624a.b(this.f347237a.f347205d, "Failed to stop player: " + e.getMessage());
            AndroidOmniAudioEngine.k(this.f347237a, OmniAudioEngineDeviceState.ERROR, OmniAudioEngineDeviceType.PLAYER, e);
            return;
        L4:
            if (this.f347237a.f347208g.get().booleanValue() == true) goto L8;
            fe9.c.f476624a.f(this.f347237a.f347205d, "Player already stopped, " + this.f347237a.f());     // Catch: Exception -> L10
            if (this.f347238b == true) goto L13;
            this.f347237a.g(false);     // Catch: Exception -> L10
        L13:
            return;
        L8:
            fe9.c.f476624a.a(this.f347237a.f347205d, "Stopping player");     // Catch: Exception -> L10
            AtomicReference<Boolean> r100 = this.f347237a.f347208g;     // Catch: Exception -> L10
            Boolean r101 = Boolean.FALSE;     // Catch: Exception -> L10
            r100.set(r101);     // Catch: Exception -> L10
            this.f347237a.f347209h.set(r101);     // Catch: Exception -> L10
            this.f347237a.g(this.f347238b);     // Catch: Exception -> L10
            AndroidOmniAudioEngine.k(this.f347237a, OmniAudioEngineDeviceState.STOPPED, OmniAudioEngineDeviceType.PLAYER, null);     // Catch: Exception -> L10
            goto L13
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

    public static final class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AndroidOmniAudioEngine f347239a;

        public k(AndroidOmniAudioEngine r100) {
            this.f347239a = r100;
        }

        public final void a() {
            fe9.c.f476624a.a(this.f347239a.f347205d, "Stopping recorder");     // Catch: Exception -> L4
            this.f347239a.f347207f.set(Boolean.FALSE);     // Catch: Exception -> L4
            this.f347239a.f347211j.b(true);     // Catch: Exception -> L4
            this.f347239a.i().setIsRecording(false);     // Catch: Exception -> L4
            AndroidOmniAudioEngine.k(this.f347239a, OmniAudioEngineDeviceState.STOPPED, OmniAudioEngineDeviceType.RECORDER, null);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            fe9.c.f476624a.b(this.f347239a.f347205d, "Failed to stop recorder: " + e.getMessage());
            AndroidOmniAudioEngine.k(this.f347239a, OmniAudioEngineDeviceState.ERROR, OmniAudioEngineDeviceType.RECORDER, e);
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

    static {
    }

    @Override // com.larus.im.internal.jni.media.OmniAudioRecorderProtocol
    public final float getRecordAmplitude() {
        return 0.0f;
    }

    @Override // com.larus.im.internal.jni.media.OmniAudioPlayerProtocol
    public final void stopPlayer() {
        q(false);
    }

    @Override // com.larus.im.internal.jni.media.OmniAudioPlayerProtocol
    public final void clearPlayerBuffer() {
        ExecutorService r100 = this.f347223v;
        if (r100.isShutdown() == true) goto L12;
        r100.execute(new c(this));     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        fe9.c.f476624a.c(this.f347205d, "asyncDispatch", th);
        return;
    }

    @Override // com.larus.im.internal.jni.media.OmniAudioEngineProtocol
    public final void destroyEngine() {
        fe9.c.f476624a.a(this.f347205d, "Destroying audio engine");
        stopRecorder();
        q(false);
        qk9.b r100 = this.f347212k;
        if (r100.f533575d.getAndSet(false) == false) goto L13;
        r100.d("monitor_stop");
        r100.b("monitor_stop");
        Thread r101 = r100.f533577e.getAndSet(null);
        if (r101 == null) goto L8;
        r101.interrupt();
    L8:
        Object r102 = r100.f533578e0;
        monitor-enter(r102);
        r100.f533580f0 = 0;     // Catch: Throwable -> L41
        r100.f533582g0 = 0;     // Catch: Throwable -> L41
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L41
        monitor-exit(r102);
    L41:
        th = move-exception;
        throw th;
    L13:
        this.f347220s.c();
        com.larus.media.n r104 = this.f347213l;
        if (r104 == null) goto L16;
        r104.destroyEngine();
    L16:
        this.f347213l = null;
        AudioPlayer r105 = this.f347214m;
        if (r105 == null) goto L19;
        r105.l();
    L19:
        this.f347214m = null;
        h().e();
        com.larus.media.m r106 = h();
        r106.f359100d.removeCallbacks(r106.f359109m);
        r106.f359102f = null;
        if (r106.f359099c.d() == true) goto L22;
        r106.f359101e = null;
    L39:
        this.f347206e.clear();
        this.f347223v.shutdown();
        return;
    L22:
        AudioManager r107 = r106.f359098b;
        if (r107 != null) goto L25;
        r106.f359101e = null;
        goto L39
    L25:
        Object r108 = r106.f359101e;
        if (r108 == null) goto L39;
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L30
        r106.f359099c.c(r107, r108);     // Catch: Throwable -> L30
        Object r110 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L30
    L33:
        if (Result.m9456isSuccessimpl(r110) == false) goto L35;
        Unit r111 = (Unit) r110;
        com.larus.im.internal.delegate.c0.f348199b.i(r106.f359097a, "unregisterRouteChangeListener success");
    L35:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r110);
        if (r112 == null) goto L38;
        com.larus.im.internal.delegate.c0.f348199b.e(r106.f359097a, "unregisterRouteChangeListener failed: " + r112.getMessage());
    L38:
        r106.f359101e = null;
    L30:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L33
    }

    public final String f() {
        return "playState: " + this.f347208g.get() + ", pauseState: " + this.f347209h.get();
    }

    public final com.larus.media.m h() {
        return (com.larus.media.m) this.f347218q.getValue();
    }

    public final OmniAVFrameDataCenter i() {
        return (OmniAVFrameDataCenter) this.f347219r.getValue();
    }

    public final void j() {
        com.larus.media.i r100 = new com.larus.media.i();     // Catch: Exception -> L11
        qk9.b r101 = this.f347212k;     // Catch: Exception -> L11
        r100.f359080n = r101;     // Catch: Exception -> L11
        if (r101 == null) goto L5;
        r101.i(r100.f359070d);     // Catch: Exception -> L11
    L5:
        this.f347213l = r100;     // Catch: Exception -> L11
        r100.g(e(this.f347217p));     // Catch: Exception -> L11
        Function1<? super byte[], Unit> r102 = new com.larus.im.internal.audio.session.omni.a(this);     // Catch: Exception -> L11
        Intrinsics.checkNotNullParameter(r102, "callback");     // Catch: Exception -> L11
        r100.f359079m = r102;     // Catch: Exception -> L11
        OmniAVFrameDataCenter r103 = i();     // Catch: Exception -> L11
        int r104 = this.f347202a.getSourceFormat().getSampleRate();     // Catch: Exception -> L11
        int r105 = this.f347202a.getSourceFormat().getChannels();     // Catch: Exception -> L11
        Integer r106 = this.f347203b.f347354a;     // Catch: Exception -> L11
        if (r106 == null) goto L8;
        int r107 = r106.intValue();     // Catch: Exception -> L11
    L9:
        r103.setRecordConfig(r104, r105, r107);     // Catch: Exception -> L11
        fe9.c.f476624a.a(this.f347205d, "Recorder initialized");     // Catch: Exception -> L11
        return;
    L8:
        r107 = 20;
    L11:
        e = move-exception;
        fe9.c.f476624a.b(this.f347205d, "Failed to initialize recorder: " + e.getMessage());
        k(this, OmniAudioEngineDeviceState.ERROR, OmniAudioEngineDeviceType.RECORDER, e);
    }

    public final b n() {
        if (this.f347203b.f347356c.f359140a == true) goto L5;
    L7:
        boolean r100 = false;
    L8:
        int r101 = 12;
        if (r100 == true) goto L15;
        if (this.f347202a.getOutputFormat().getChannels() != 1) goto L15;
        r101 = 4;
    L15:
        return new b(r101, r100);
    L5:
        if (this.f347202a.getOutputFormat().getChannels() != 1) goto L7;
        r100 = true;
        goto L8
    }

    public final void p() {
    L14:
        e = move-exception;
        fe9.c.f476624a.b(this.f347205d, "Failed to start player: " + e.getMessage());
        this.f347208g.set(Boolean.FALSE);
        k(this, OmniAudioEngineDeviceState.ERROR, OmniAudioEngineDeviceType.PLAYER, e);
        return;
    L4:
        if (this.f347208g.get().booleanValue() == true) goto L6;
    L9:
        fe9.c.f476624a.a(this.f347205d, "Starting player");     // Catch: Exception -> L14
        this.f347208g.set(Boolean.TRUE);     // Catch: Exception -> L14
        this.f347209h.set(Boolean.FALSE);     // Catch: Exception -> L14
        AudioPlayer r100 = this.f347214m;     // Catch: Exception -> L14
        if (r100 == null) goto L12;
        r100.K();     // Catch: Exception -> L14
    L12:
        k(this, OmniAudioEngineDeviceState.STARTED, OmniAudioEngineDeviceType.PLAYER, null);     // Catch: Exception -> L14
        return;
    L6:
        if (this.f347209h.get().booleanValue() == true) goto L9;
        fe9.c.f476624a.f(this.f347205d, "Player already started, " + f());     // Catch: Exception -> L14
    }

    @Override // com.larus.im.internal.jni.media.OmniAudioPlayerProtocol
    public final void pausePlayer() {
        ExecutorService r100 = this.f347223v;
        if (r100.isShutdown() == true) goto L12;
        r100.execute(new e(this));     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        fe9.c.f476624a.c(this.f347205d, "asyncDispatch", th);
        return;
    }

    @Override // com.larus.im.internal.jni.media.OmniAudioPlayerProtocol
    public final void resumePlayer() {
        ExecutorService r100 = this.f347223v;
        if (r100.isShutdown() == true) goto L12;
        r100.execute(new f(this));     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        fe9.c.f476624a.c(this.f347205d, "asyncDispatch", th);
        return;
    }

    @Override // com.larus.im.internal.jni.media.OmniAudioPlayerProtocol
    public final void startPlayer() {
        ExecutorService r100 = this.f347223v;
        if (r100.isShutdown() == true) goto L12;
        r100.execute(new h(this));     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        fe9.c.f476624a.c(this.f347205d, "asyncDispatch", th);
        return;
    }

    @Override // com.larus.im.internal.jni.media.OmniAudioRecorderProtocol
    public final void startRecorder() {
        ExecutorService r100 = this.f347223v;
        if (r100.isShutdown() == true) goto L12;
        r100.execute(new i(this));     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        fe9.c.f476624a.c(this.f347205d, "asyncDispatch", th);
        return;
    }

    @Override // com.larus.im.internal.jni.media.OmniAudioRecorderProtocol
    public final void stopRecorder() {
        if (this.f347207f.get().booleanValue() == true) goto L6;
        fe9.c.f476624a.f(this.f347205d, "Recorder already stopped");
        return;
    L6:
        ExecutorService r100 = this.f347223v;
        if (r100.isShutdown() == true) goto L16;
        r100.execute(new k(this));     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        fe9.c.f476624a.c(this.f347205d, "asyncDispatch", th);
        return;
    }

    @Override // com.larus.im.internal.jni.media.OmniAudioPlayerProtocol
    public final float getPlayAmplitude() {
        return this.f347224w;
    }

    public static final void a(AndroidOmniAudioEngine r100) {
        Iterator<OmniAudioEngineDelegate> r101 = r100.f347206e.iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        r101.next().onAudioEnginePause();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        fe9.c.f476624a.b(r100.f347205d, "Error in listener callback: " + e.getMessage());
        goto L4
    }

    public static final void b(AndroidOmniAudioEngine r100) {
        Iterator<OmniAudioEngineDelegate> r101 = r100.f347206e.iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        r101.next().onAudioEngineResume();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        fe9.c.f476624a.b(r100.f347205d, "Error in listener callback: " + e.getMessage());
        goto L4
    }

    @Override // com.larus.im.internal.jni.media.OmniAudioEngineProtocol
    public final void addListener(OmniAudioEngineDelegate r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        if (this.f347206e.contains(r100) == true) goto L6;
        this.f347206e.add(r100);
        fe9.c.f476624a.a(this.f347205d, "Added audio engine listener");
        return;
    }

    public final void c(String r110) {
        com.larus.media.a r100 = m(this.f347216o);
        if (Intrinsics.areEqual(r100, this.f347217p) == true) goto L61;
        fe9.c r101 = fe9.c.f476624a;
        r101.e(this.f347205d, r110 + " resolved reconfigure from " + this.f347217p + " to " + r100);
        if (Intrinsics.areEqual(this.f347217p, r100) == false) goto L7;
        r101.e(this.f347205d, "reconfigureAudioDevice skipped, config unchanged: " + r100);
        return;
    L7:
        r101.e(this.f347205d, "reconfigureAudioDevice from " + this.f347217p + " to " + r100);
        com.larus.media.j r111 = e(this.f347217p);
        com.larus.media.j r102 = e(r100);
        boolean r112 = Intrinsics.areEqual(r111, r102) ^ true;
        if (r112 == true) goto L10;
    L12:
        boolean r103 = false;
    L13:
        b r104 = n();
        com.larus.media.d r105 = d(r104.f347226a, r104.f347227b, this.f347217p);
        com.larus.media.d r106 = d(r104.f347226a, r104.f347227b, r100);
        boolean r107 = !Intrinsics.areEqual(r105, r106);
        if (r107 == true) goto L16;
    L22:
        boolean r108 = false;
    L23:
        if (r108 == false) goto L27;
        r101.e(this.f347205d, "reconfigureAudioDevice pause player to hold playback buffer");
        AudioPlayer r109 = this.f347214m;
        if (r109 == null) goto L27;
        r109.A();
    L27:
        if (r103 == false) goto L31;
        this.f347207f.set(Boolean.FALSE);
        this.f347211j.b(false);
        i().setIsRecording(false);
        com.larus.media.n r113 = this.f347213l;
        if (r113 == null) goto L31;
        r113.stop();
    L31:
        if (r112 == false) goto L36;
        r101.e(this.f347205d, "reconfigureAudioDevice reconfigure recorder with config=" + r102);
        com.larus.media.n r114 = this.f347213l;
        if (r114 == null) goto L35;
        r114.destroyEngine();
    L35:
        this.f347213l = null;
    L37:
        h().a(r100);
        this.f347217p = r100;
        if (r112 == true) goto L40;
    L44:
        if (r107 == true) goto L46;
    L52:
        if (r103 == false) goto L56;
        this.f347207f.set(Boolean.TRUE);
        i().setIsRecording(true);
        com.larus.media.n r115 = this.f347213l;
        if (r115 == null) goto L56;
        r115.start();
    L56:
        if (r108 == false) goto L60;
        r101.e(this.f347205d, "reconfigureAudioDevice resume player after audio device reconfigure");
        AudioPlayer r116 = this.f347214m;
        if (r116 == null) goto L60;
        r116.F();
    L60:
        r101.e(this.f347205d, "reconfigureAudioDevice keeps current player and reference signal buffer");
        return;
    L46:
        if (this.f347202a.getMode() != OmniAudioEngineMode.PLAY_ONLY) goto L48;
    L49:
        r101.e(this.f347205d, "reconfigureAudioDevice reconfigure player with config=" + r106);
        AudioPlayer r117 = this.f347214m;
        if (r117 == null) goto L52;
        r117.C(r106);
        goto L52
    L48:
        if (this.f347202a.getMode() != OmniAudioEngineMode.RECORD_AND_PLAY) goto L52;
    L40:
        if (this.f347202a.getMode() != OmniAudioEngineMode.RECORD_ONLY) goto L42;
    L43:
        j();
        goto L44
    L42:
        if (this.f347202a.getMode() != OmniAudioEngineMode.RECORD_AND_PLAY) goto L44;
    L36:
        r101.e(this.f347205d, "reconfigureAudioDevice keep recorder, config unchanged");
        goto L37
    L16:
        if (r100.f358984g == false) goto L22;
        if (this.f347208g.get().booleanValue() == false) goto L22;
        if (this.f347209h.get().booleanValue() == true) goto L22;
        r108 = true;
        goto L23
    L10:
        if (this.f347207f.get().booleanValue() == false) goto L12;
        r103 = true;
        goto L13
    L61:
        fe9.c.f476624a.e(this.f347205d, r110 + " resolved config unchanged, reapply route: " + r100);
        h().a(r100);
    }

    @Override // com.larus.im.internal.jni.media.OmniAudioPlayerProtocol
    public final void duck(float r100) {
        ExecutorService r101 = this.f347223v;
        if (r101.isShutdown() == true) goto L12;
        r101.execute(new d(r100, this));     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        fe9.c.f476624a.c(this.f347205d, "asyncDispatch", th);
        return;
    }

    public final com.larus.media.j e(com.larus.media.a r110) {
        RecordSourceType r100 = r110.f358980c;
        int r101 = this.f347202a.getSourceFormat().getSampleRate();
        if (this.f347202a.getSourceFormat().getChannels() != 2) goto L5;
        int r102 = 12;
    L6:
        boolean r103 = r110.f358985h;
        boolean r104 = r110.f358986i;
        boolean r105 = r110.f358987j;
        q r111 = this.f347203b;
        return new com.larus.media.j(r100, r101, r102, 2, r103, r104, r105, r111.f347359f, r111.f347360g, true);
    L5:
        r102 = 16;
        goto L6
    }

    public final void g(boolean r100) {
        fe9.c.f476624a.a(this.f347205d, "Clearing player buffer, " + f());     // Catch: Exception -> L10
        this.f347225x.f347351d = true;     // Catch: Exception -> L10
        AudioPlayer r101 = this.f347214m;     // Catch: Exception -> L10
        if ((r101 instanceof AudioPlayer) == true) goto L7;
        r101 = null;
    L7:
        if (r101 == null) goto L15;
        r101.f(r100);     // Catch: Exception -> L10
        return;
    L15:
        return;
    L10:
        e = move-exception;
        fe9.c.f476624a.b(this.f347205d, "Failed to clear player buffer: " + e.getMessage());
    }

    public final com.larus.media.a m(com.larus.media.a r100) {
        com.larus.media.m r101 = h();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "config");
        if (r100.f358978a == AudioDeviceMode.MEDIA) goto L5;
        return r100;
    L5:
        if (r100.f358982e == AudioInputRoutePolicy.PREFER_BLUETOOTH_WHEN_AVAILABLE) goto L8;
        return r100;
    L8:
        if (r101.f359104h == false) goto L10;
        com.larus.im.internal.delegate.c0.f348199b.i(r101.f359097a, "resolveRuntimeConfig: keep media mode because built-in mic is forced");
        return r100;
    L10:
        AudioManager r102 = r101.f359098b;
        if (r102 != null) goto L14;
        return r100;
    L14:
        if (r101.f359099c.i(r102) == false) goto L22;
        com.larus.im.internal.delegate.c0.f348199b.i(r101.f359097a, "resolveRuntimeConfig: promote media to communication for bluetooth input");
        int r103 = com.larus.media.a.f358977k;
        return com.larus.media.a.C4419a.a(r100.f358985h, r100.f358986i, r100.f358987j, r100.f358982e, AudioOutputRoutePolicy.PREFER_SPEAKER_WHEN_NO_EXTERNAL_DEVICE, r100.f358984g, r100.f358979b);
    L22:
        return r100;
    }

    @Override // com.larus.im.internal.jni.media.OmniAudioPlayerProtocol
    public final void mutePlayer(boolean r100) {
        fe9.c.f476624a.a(this.f347205d, "Setting player mute: " + r100);
        AudioPlayer r101 = this.f347214m;
        if (r101 == null) goto L6;
        r101.x(r100);
        return;
    }

    public final Function0<Unit> o(com.larus.media.a r100) {
        h().getClass();
        Intrinsics.checkNotNullParameter(r100, "config");
        if (r100.f358978a == AudioDeviceMode.MEDIA) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L12;
        return null;
    L12:
        return new AndroidOmniAudioEngine$resolveRouteDeviceChangedCallback$1(this);
    L5:
        if (r100.f358982e != AudioInputRoutePolicy.PREFER_BLUETOOTH_WHEN_AVAILABLE) goto L7;
        r101 = true;
        goto L8
    }

    @Override // com.larus.im.internal.jni.media.OmniAudioPlayerProtocol
    public final synchronized void playFrame(OmniAudioFrame r210) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r210, "frame");     // Catch: Throwable -> L54
        long r100 = System.currentTimeMillis();     // Catch: Throwable -> L54
    L50:
        e = move-exception;
        fe9.c.f476624a.b(this.f347205d, "Failed to play frame: " + e.getMessage());     // Catch: Throwable -> L54
    L52:
        monitor-exit(this);
        return;
    L6:
        if (this.f347208g.get().booleanValue() == false) goto L8;
    L10:
        String r101 = r210.getExtData();     // Catch: Exception -> L50 Throwable -> L54
        if (r101 != null) goto L13;
        r101 = "";
    L13:
        OMNIAVFrameExt r102 = l(r101, r210.getData());     // Catch: Exception -> L50 Throwable -> L54
        if (r102 == null) goto L17;
        r(r102);     // Catch: Exception -> L50 Throwable -> L54
    L17:
        if (this.f347225x.f347351d == false) goto L21;
        fe9.c.f476624a.f(this.f347205d, "Reply unique id is dirty, " + this.f347225x.a() + ", drop frame");     // Catch: Exception -> L50 Throwable -> L54
        monitor-exit(this);
        return;
    L21:
        long r103 = System.currentTimeMillis();     // Catch: Exception -> L50 Throwable -> L54
        if (r102 == null) goto L24;
        long r110 = r102.downlinkProcessStartTimestampMs;     // Catch: Exception -> L50 Throwable -> L54
    L25:
        if (r102 == null) goto L27;
        long r111 = r102.downlinkProcessEndTimestampMs;     // Catch: Exception -> L50 Throwable -> L54
    L28:
        boolean r104 = false;
        if (r110 > 0) goto L31;
    L33:
        boolean r105 = false;
    L34:
        if (r105 == false) goto L36;
        long r112 = r110;
    L37:
        if (r105 == false) goto L39;
        long r113 = r111;
    L40:
        AudioPlayer r106 = this.f347214m;     // Catch: Exception -> L50 Throwable -> L54
        if (r106 == null) goto L48;
        byte[] r107 = r210.getData();     // Catch: Exception -> L50 Throwable -> L54
        String r108 = r210.getExtData();     // Catch: Exception -> L50 Throwable -> L54
        if (r102 != null) goto L45;
    L47:
        r106.Q(new com.larus.media.w(r107, r108, r104, new com.larus.media.x(r112, r113, 14)));     // Catch: Exception -> L50 Throwable -> L54
        goto L48
    L45:
        if (r102.status != 1) goto L47;
        r104 = true;
    L48:
        this.f347224w = r210.getAmplitude();     // Catch: Exception -> L50 Throwable -> L54
        goto L52
    L39:
        r113 = r103;
        goto L40
    L36:
        r112 = r100;
        goto L37
    L31:
        if (r111 < r110) goto L33;
        r105 = true;
        goto L34
    L27:
        r111 = 0;
        goto L28
    L24:
        r110 = 0;
        goto L25
    L8:
        if (this.f347209h.get().booleanValue() == true) goto L10;
        fe9.c.f476624a.f(this.f347205d, "Cannot play frame: player is not playing");     // Catch: Exception -> L50 Throwable -> L54
        p();     // Catch: Exception -> L50 Throwable -> L54
    L54:
        th = move-exception;
        throw th;
    }

    public final void q(boolean r100) {
        ExecutorService r101 = this.f347223v;
        if (r101.isShutdown() == true) goto L12;
        r101.execute(new j(this, r100));     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        fe9.c.f476624a.c(this.f347205d, "asyncDispatch", th);
        return;
    }

    public final void r(OMNIAVFrameExt r100) {
        if (r100.queryRound > 0) goto L5;
        return;
    L5:
        if (com.flow.kmp.common.util.f.a(r100.taskId) == false) goto L22;
        long r101 = r100.queryRound;
        o0 r102 = this.f347225x;
        if (r101 == r102.f347348a) goto L9;
    L12:
        fe9.a r103 = fe9.a.f476620a;
        r103.e(this.f347205d, "tryUpdateReplyUniqueId queryRound = " + r100.queryRound + "，replyRound = " + r100.replyRound + " , taskId = " + r100.taskId);
        long r104 = r100.queryRound;
        String r105 = r100.replyRound;
        String r106 = "";
        if (r105 != null) goto L15;
        r105 = "";
    L15:
        String r107 = r100.taskId;
        if (r107 == null) goto L19;
        r106 = r107;
    L19:
        o0 r108 = new o0(r104, r105, r106);
        r103.e(this.f347205d, "change unique id from " + this.f347225x.a() + " to " + r108.a());
        this.f347225x = r108;
        return;
    L9:
        if (Intrinsics.areEqual(r100.replyRound, r102.f347349b) == false) goto L12;
        if (Intrinsics.areEqual(r100.taskId, this.f347225x.f347350c) == false) goto L12;
        return;
    }

    @Override // com.larus.im.internal.jni.media.OmniAudioEngineProtocol
    public final void removeListener(OmniAudioEngineDelegate r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        if (this.f347206e.remove(r100) == false) goto L6;
        fe9.c.f476624a.a(this.f347205d, "Removed audio engine listener");
        return;
    }

    @Override // com.larus.im.internal.jni.media.OmniAudioRecorderProtocol
    public final void setBluetoothForceToMedia(boolean r100) {
        ExecutorService r101 = this.f347223v;
        if (r101.isShutdown() == true) goto L12;
        r101.execute(new g(this, r100));     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        fe9.c.f476624a.c(this.f347205d, "asyncDispatch", th);
        return;
    }

    @Override // com.larus.im.internal.jni.media.OmniAudioPlayerProtocol
    public final void addListener(OmniAudioPlayerDelegate r100) {
        OmniAudioEngineProtocol.DefaultImpls.addListener(this, r100);
    }

    @Override // com.larus.im.internal.jni.media.OmniAudioPlayerProtocol
    public final void removeListener(OmniAudioPlayerDelegate r100) {
        OmniAudioEngineProtocol.DefaultImpls.removeListener(this, r100);
    }

    @Override // com.larus.im.internal.jni.media.OmniAudioRecorderProtocol
    public final void addListener(OmniAudioRecorderDelegate r100) {
        OmniAudioEngineProtocol.DefaultImpls.addListener(this, r100);
    }

    @Override // com.larus.im.internal.jni.media.OmniAudioRecorderProtocol
    public final void removeListener(OmniAudioRecorderDelegate r100) {
        OmniAudioEngineProtocol.DefaultImpls.removeListener(this, r100);
    }

    public final OMNIAVFrameExt l(String r100, byte[] r101) {
        OmniAudioExtraCache r102 = this.f347221t;
        String r103 = null;
        if (r102 != null) goto L5;
    L15:
        OMNIAVFrameExt r104 = OmniAVFrameKtxKt.toOMNIAVFrameExt(r100);
        OmniAudioExtraCache r105 = new OmniAudioExtraCache(r100, r104);
        if (Intrinsics.areEqual(this.f347221t, r105) == true) goto L39;
        OmniAudioExtraCache r106 = this.f347221t;
        int r107 = 0;
        if (r106 == null) goto L20;
        int r108 = r106.getTotalAudioSize();
    L21:
        int r109 = this.f347202a.getOutputFormat().getSampleRate();
        int r110 = this.f347202a.getOutputFormat().getChannels();
        if (r109 <= 0) goto L27;
        if (r110 <= 0) goto L27;
        if (r110 > 3) goto L27;
        int r111 = (((r109 / 1000) * r110) * 16) / 8;
    L28:
        if (r111 <= 0) goto L31;
        r107 = r108 / r111;
    L31:
        fe9.a r112 = fe9.a.f476620a;
        String r113 = this.f347205d;
        StringBuilder r114 = new StringBuilder("lastAudioExtraCache hit count: ");
        OmniAudioExtraCache r115 = this.f347221t;
        if (r115 == null) goto L34;
        Integer r116 = Integer.valueOf(r115.getCacheHitCount());
    L35:
        r114.append(r116);
        r114.append(", total audio: ");
        r114.append(r107);
        r114.append("ms, changed to ");
        OMNIAVFrameExt r117 = r105.getOmniExtraExt();
        if (r117 == null) goto L38;
        r103 = r117.extra;
    L38:
        r114.append(r103);
        r112.e(r113, r114.toString());
        this.f347221t = r105;
        goto L39
    L34:
        r116 = null;
    L27:
        r111 = 0;
        goto L28
    L20:
        r108 = 0;
    L39:
        OmniAudioExtraCache r118 = this.f347221t;
        if (r118 == null) goto L43;
        r118.updateTotalAudioSize(r101.length);
    L43:
        return r104;
    L5:
        if (Intrinsics.areEqual(r100, r102.getSource()) == false) goto L15;
        OmniAudioExtraCache r119 = this.f347221t;
        if (r119 == null) goto L9;
        r119.hit();
    L9:
        OmniAudioExtraCache r120 = this.f347221t;
        if (r120 == null) goto L12;
        r120.updateTotalAudioSize(r101.length);
    L12:
        OmniAudioExtraCache r121 = this.f347221t;
        if (r121 != null) goto L45;
        return null;
    L45:
        return r121.getOmniExtraExt();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v27, types: [com.larus.media.l] */
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
    public AndroidOmniAudioEngine(OmniAudioEngineConfig r210, q r211, k0 r212) {
        Intrinsics.checkNotNullParameter(r210, "config");
        Intrinsics.checkNotNullParameter(r211, "options");
        this.f347202a = r210;
        this.f347203b = r211;
        this.f347204c = r212;
        this.f347205d = "OmniAudioEngine";
        this.f347206e = new CopyOnWriteArrayList();
        Boolean r100 = Boolean.FALSE;
        this.f347207f = new AtomicReference(r100);
        this.f347208g = new AtomicReference(r100);
        this.f347209h = new AtomicReference(r100);
        this.f347210i = new AtomicBoolean(false);
        int r101 = r210.getSourceFormat().getSampleRate();
        int r102 = r210.getSourceFormat().getChannels();
        com.larus.im.internal.delegate.w.c r103 = com.larus.im.internal.delegate.w.j().f348360e;
        if (r103 == null) goto L7;
        com.larus.im.internal.delegate.w.j r104 = r103.f348347s;
        if (r104 == null) goto L7;
        boolean r105 = r104.f348390a;
    L8:
        com.larus.im.internal.delegate.w.c r106 = com.larus.im.internal.delegate.w.j().f348360e;
        long r110 = 5000;
        if (r106 == null) goto L13;
        com.larus.im.internal.delegate.w.j r107 = r106.f348347s;
        if (r107 == null) goto L13;
        long r111 = r107.f348391b;
    L14:
        com.larus.im.internal.delegate.w.c r108 = com.larus.im.internal.delegate.w.j().f348360e;
        if (r108 == null) goto L19;
        com.larus.im.internal.delegate.w.j r109 = r108.f348347s;
        if (r109 == null) goto L19;
        float r112 = r109.f348392c;
    L20:
        com.larus.im.internal.delegate.w.c r113 = com.larus.im.internal.delegate.w.j().f348360e;
        if (r113 == null) goto L25;
        com.larus.im.internal.delegate.w.j r114 = r113.f348347s;
        if (r114 == null) goto L25;
        r110 = r114.f348393d;
    L25:
        long r115 = r110;
        com.larus.im.internal.delegate.w.c r116 = com.larus.im.internal.delegate.w.j().f348360e;
        if (r116 == null) goto L30;
        com.larus.im.internal.delegate.w.j r117 = r116.f348347s;
        if (r117 == null) goto L30;
        int r118 = r117.f348394e;
    L31:
        com.larus.im.internal.delegate.w.c r119 = com.larus.im.internal.delegate.w.j().f348360e;
        if (r119 == null) goto L36;
        com.larus.im.internal.delegate.w.j r120 = r119.f348347s;
        if (r120 == null) goto L36;
        boolean r121 = r120.f348395f;
    L37:
        com.larus.im.internal.delegate.w.c r122 = com.larus.im.internal.delegate.w.j().f348360e;
        if (r122 == null) goto L42;
        com.larus.im.internal.delegate.w.j r123 = r122.f348347s;
        if (r123 == null) goto L42;
        long r213 = r123.f348396g;
    L43:
        this.f347211j = new ok9.a(r101, r102, r105, r111, r112, r115, r118, r121, r213);
        com.larus.im.internal.delegate.w.a r124 = com.larus.im.internal.delegate.w.j().f348361f;
        if (r124 == null) goto L46;
        long r125 = r124.f348309v;
    L47:
        this.f347212k = new qk9.b(r125, new AndroidOmniAudioEngine$audioPeriodicStatsMonitor$1(this));
        com.larus.media.a r126 = r211.f347355b;
        this.f347216o = r126;
        this.f347217p = r126;
        this.f347218q = LazyKt.lazy(new com.larus.im.internal.audio.session.omni.b());
        this.f347219r = LazyKt.lazy(new com.larus.im.internal.audio.session.omni.c());
        this.f347220s = new n0(r211.f347364k);
        this.f347223v = PThreadExecutorsUtils.newSingleThreadExecutor(new com.larus.im.internal.audio.session.omni.d());
        this.f347225x = new o0(0, "", "");
        fe9.c.f476624a.a("OmniAudioEngine", "Initializing audio engine with config: " + r210 + ", runtimeConfig=" + this.f347216o);
        final com.larus.media.m r127 = h();
        Function0<Unit> r128 = o(this.f347216o);
        if (r127.f359099c.d() == true) goto L50;
        com.larus.im.internal.delegate.c0.f348199b.i(r127.f359097a, "registerRouteChangeListener: unsupported sdk=" + Build.VERSION.SDK_INT);
    L67:
        this.f347217p = m(this.f347216o);
        h().a(this.f347217p);
        if (this.f347202a.getMode() != OmniAudioEngineMode.RECORD_ONLY) goto L70;
    L71:
        j();
    L73:
        if (this.f347202a.getMode() == OmniAudioEngineMode.PLAY_ONLY) goto L108;
        if (this.f347202a.getMode() == OmniAudioEngineMode.RECORD_AND_PLAY) goto L108;
    L92:
        i().setOnDequeueRecordFrame(new com.larus.im.internal.audio.session.omni.e(this));
        final qk9.b r129 = this.f347212k;
        if (r129.f533571b > 0) goto L95;
        return;
    L95:
        if (r129.f533575d.compareAndSet(false, true) == false) goto L113;
        long r130 = SystemClock.elapsedRealtime();
        Object r131 = r129.f533578e0;
        monitor-enter(r131);
        r129.f533580f0 = 0;     // Catch: Throwable -> L102
        r129.f533582g0 = 0;     // Catch: Throwable -> L102
        Unit r132 = Unit.INSTANCE;     // Catch: Throwable -> L102
        monitor-exit(r131);
        r129.f(r130);
        PthreadThreadV2 r133 = new PthreadThreadV2(new qk9.a(r129), "AudioPeriodicStatsMonitor");
        ThreadMethodProxy.setName(r133, "AudioPeriodicStats");
        r133.setDaemon(true);
        r129.f533577e.set(r133);
        ThreadMethodProxy.start(r133);
        return;
    L102:
        th = move-exception;
        throw th;
    L113:
        return;
    L108:
        b r134 = n();     // Catch: Exception -> L90
        int r135 = this.f347202a.getOutputFormat().getChannels();     // Catch: Exception -> L90
        n0.h(this.f347220s, this.f347202a.getOutputFormat().getSampleRate(), r135);     // Catch: Exception -> L90
        AudioPlayer r136 = new AudioPlayer();     // Catch: Exception -> L90
        r136.f358906p = this.f347215n;     // Catch: Exception -> L90
        qk9.b r137 = this.f347212k;     // Catch: Exception -> L90
        r136.f358909s = r137;     // Catch: Exception -> L90
        if (r137 == null) goto L80;
        r137.h(r136.f358893c);     // Catch: Exception -> L90
    L80:
        r136.N();     // Catch: Exception -> L90
        qk9.c r138 = r136.f358908r;     // Catch: Exception -> L90
        if (r138 == null) goto L85;
        r138.I = r137;     // Catch: Exception -> L90
        if (r137 == null) goto L85;
        r137.h(r138.f533603b);     // Catch: Exception -> L90
    L85:
        this.f347214m = r136;     // Catch: Exception -> L90
        r136.r(d(r134.f347226a, r134.f347227b, this.f347217p));     // Catch: Exception -> L90
        AudioPlayer r139 = this.f347214m;     // Catch: Exception -> L90
        if ((r139 instanceof AudioPlayer) == false) goto L88;
        Intrinsics.checkNotNull(r139, "null cannot be cast to non-null type com.larus.media.AudioPlayer");     // Catch: Exception -> L90
        r139.f358905o = new com.larus.im.internal.audio.session.omni.f(this);     // Catch: Exception -> L90
        AudioPlayer r140 = this.f347214m;     // Catch: Exception -> L90
        Intrinsics.checkNotNull(r140, "null cannot be cast to non-null type com.larus.media.AudioPlayer");     // Catch: Exception -> L90
        r140.f358907q = new com.larus.im.internal.audio.session.omni.g(this);     // Catch: Exception -> L90
    L88:
        p();     // Catch: Exception -> L90
        fe9.c.f476624a.a(this.f347205d, "Player initialized and started with channel mode: " + this.f347202a.getOutputFormat().getChannels() + ", stereoPlayoutGain=" + r134.f347227b);     // Catch: Exception -> L90
    L90:
        e = move-exception;
        fe9.c.f476624a.b(this.f347205d, "Failed to initialize player: " + e.getMessage());
        k(this, OmniAudioEngineDeviceState.ERROR, OmniAudioEngineDeviceType.PLAYER, e);
        goto L92
    L70:
        if (this.f347202a.getMode() != OmniAudioEngineMode.RECORD_AND_PLAY) goto L73;
    L50:
        AudioManager r141 = r127.f359098b;
        if (r141 != null) goto L54;
        com.larus.im.internal.delegate.c0.f348199b.e(r127.f359097a, "registerRouteChangeListener: AudioManager is null");
        goto L67
    L54:
        if (r127.f359101e == null) goto L56;
        r127.f359102f = r128;
        com.larus.im.internal.delegate.c0.f348199b.i(r127.f359097a, "registerRouteChangeListener: already registered");
        goto L67
    L56:
        r127.f359102f = r128;
        Result.Companion r142 = Result.Companion;     // Catch: Throwable -> L59
        Object r143 = Result.m9449constructorimpl(r127.f359099c.a(r141, r127.f359100d, new com.larus.media.l(r127)));     // Catch: Throwable -> L59
    L62:
        if (Result.m9456isSuccessimpl(r143) == false) goto L64;
        r127.f359101e = r143;
        com.larus.im.internal.delegate.c0.f348199b.i(r127.f359097a, "registerRouteChangeListener success");
        r127.d("registerRouteChangeListener", r127.f359103g, "registered", null, r127.f359099c.e(r141));
    L64:
        Throwable r144 = Result.m9452exceptionOrNullimpl(r143);
        if (r144 == null) goto L67;
        com.larus.im.internal.delegate.c0.f348199b.e(r127.f359097a, "registerRouteChangeListener failed: " + r144.getMessage());
        r127.f359101e = null;
    L59:
        th = move-exception;
        Result.Companion r145 = Result.Companion;
        r143 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L62
    L46:
        r125 = 2000;
    L42:
        r213 = 2000;
    L36:
        r121 = true;
    L30:
        r118 = 2;
    L19:
        r112 = 0.0f;
    L13:
        r111 = 5000;
    L7:
        r105 = true;
        goto L8
    }

    public final com.larus.media.d d(int r110, boolean r111, com.larus.media.a r112) {
        PlayScenario r100 = r112.f358981d;
        int r101 = this.f347202a.getOutputFormat().getSampleRate();
        int r102 = 2;
        if (r111 == false) goto L5;
        com.larus.media.p0 r103 = this.f347203b.f347356c;
    L6:
        com.larus.media.p0 r104 = r103;
        q r105 = this.f347203b;
        return new com.larus.media.d(r100, r101, r110, r102, r104, r105.f347357d, r105.f347358e, r105.f347361h, r105.f347362i, r105.f347363j, true, com.larus.im.internal.delegate.c.f348197a.getApplication().getApplicationContext(), 4);
    L5:
        r103 = new com.larus.media.p0(0);
        goto L6
    }

    public static void k(AndroidOmniAudioEngine r100, OmniAudioEngineDeviceState r101, OmniAudioEngineDeviceType r102, Exception r103) {
        Iterator<OmniAudioEngineDelegate> r104 = r100.f347206e.iterator();
    L4:
        if (r104.hasNext() == false) goto L10;
        r104.next().onAudioEngineStateChanged(r101, r102, r103, null);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        fe9.c.f476624a.b(r100.f347205d, "Error in listener callback: " + e.getMessage());
        goto L4
    }
}
