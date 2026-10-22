package com.larus.audio.call.play;

import android.media.AudioTrack;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.play.abs.TtsPlayEndType;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import kotlin.UByte;
import kotlin.collections.ArraysKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes24.dex */
public class c extends AbsAudioPlayManager {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RealtimeCallParam f289300f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f289301g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f289302h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f289303i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile float f289304j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f289305k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final LinkedBlockingQueue<h> f289306l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile b f289307m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile AudioTrack f289308n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile boolean f289309o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public volatile AbsAudioPlayManager.Wait f289310p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile boolean f289311q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile int f289312r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f289313s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f289314t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public volatile boolean f289315u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f289316v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public volatile boolean f289317w;

    public static final class a {
    }

    public static final class b extends PthreadThreadV2 {

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final /* synthetic */ c f289318v;

        public final void l() {
            super.run();
            com.larus.audio.call.util.e.f289645a.i(this.f289318v.t(), "StartLoop: isInterrupted:" + isInterrupted() + ",  callFinished:" + this.f289318v.f289317w);
        L4:
            if (isInterrupted() == true) goto L37;
            if (this.f289318v.f289317w == true) goto L37;
            this.f289318v.f289311q = false;     // Catch: Exception -> L10 InterruptedException -> L35
            c.o(this.f289318v);     // Catch: Exception -> L10 InterruptedException -> L35
        L12:
            c r100 = this.f289318v;
            r100.getClass();
            if (com.larus.audio.call.f.d().f289146v == true) goto L15;
            if (r100.f289306l.size() != 0) goto L4;
            if (r100.f289309o == false) goto L4;
            com.larus.audio.call.util.e r101 = com.larus.audio.call.util.e.f289645a;
            r101.i(r100.t(), "onPlayEnd fixAudioPlayManagerPlayEnd(false)");
            r100.f289309o = false;
            u68.a.b.C7839a.a(r100.f289289e);
            if (r100.f289310p != AbsAudioPlayManager.Wait.DATA_END) goto L4;
            r101.i(r100.t(), "onPlayComplete fixAudioPlayManagerPlayEnd(false)");
            r100.w(AbsAudioPlayManager.Wait.COMPLETE);
            r100.f289289e.onPlayComplete();
            goto L4
        L15:
            if (r100.f289306l.size() != 0) goto L4;
            if (r100.f289309o == false) goto L4;
            if (r100.f289310p == AbsAudioPlayManager.Wait.DATA_END) goto L20;
            if (r100.f289310p == AbsAudioPlayManager.Wait.STOPPED) goto L23;
            if (r100.f289313s >= r100.f289314t) goto L26;
            com.larus.audio.call.util.e.f289645a.i(r100.t(), "waitForPlayEndCount = " + r100.f289313s);
            r100.f289313s = r100.f289313s + 1;
            goto L4
        L26:
            com.larus.audio.call.util.e.f289645a.i(r100.t(), "onPlayEnd, waitForPlayEndCount = " + r100.f289313s);
            r100.f289289e.f(TtsPlayEndType.TIMEOUT);
            r100.f289313s = 0;
            r100.f289309o = false;
            goto L4
        L23:
            r100.f289309o = false;
            com.larus.audio.call.util.e.f289645a.i(r100.t(), "onPlayEnd Wait.STOPPED");
            u68.a.b.C7839a.a(r100.f289289e);
            goto L4
        L20:
            com.larus.audio.call.util.e r102 = com.larus.audio.call.util.e.f289645a;
            r102.i(r100.t(), "onPlayEnd Wait.DATA_END");
            r100.f289309o = false;
            u68.a.b.C7839a.a(r100.f289289e);
            r100.w(AbsAudioPlayManager.Wait.COMPLETE);
            r102.i(r100.t(), "onPlayComplete Wait.DATA_END");
            r100.f289289e.onPlayComplete();
            goto L4
        L35:
            e = move-exception;
            com.larus.audio.call.util.e.f289645a.e(this.f289318v.t(), "InterruptedException.", e);
        L10:
            e = move-exception;
            com.larus.audio.call.util.e.f289645a.e(this.f289318v.t(), "unknown exception.", e);
        L37:
            com.larus.audio.call.util.e.f289645a.e(this.f289318v.t(), "OutLoop: isInterrupted:" + isInterrupted() + ",  callFinished:" + this.f289318v.f289317w);
        }

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
        public final void run() {
            l();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(c r100, String r101) {
            this.f289318v = r100;
            super(r101);
        }
    }

    static {
    }

    public int p() {
        return 1;
    }

    @Override // u68.a
    public final void a() {
        w(AbsAudioPlayManager.Wait.WAIT);
    }

    @Override // u68.a
    public void b() {
        com.larus.audio.call.util.e.f289645a.i(t(), "audio play interrupt");
        this.f289289e.e(this.f289309o);
        d(true, true, "client_interrupt");
        u68.a.C7838a.a(this, false, "client_interrupt", 3);
        this.f289311q = true;
    }

    @Override // u68.a
    public final void h() {
        com.larus.audio.call.util.e.f289645a.i(t(), "audio play clearTTS");
        this.f289306l.clear();
    }

    @Override // u68.c
    public void init() {
        if (Intrinsics.areEqual(this.f289300f.f288751k.f288826o, "dora_si") == true) goto L5;
    L8:
        e(true);
        this.f289307m = new b(this, this.f289316v);
        b r100 = this.f289307m;     // Catch: Exception -> L16
        if (r100 == null) goto L12;
        ThreadMethodProxy.setPriority(r100, 10);     // Catch: Exception -> L16
    L12:
        b r101 = this.f289307m;     // Catch: Exception -> L16
        if (r101 == null) goto L21;
        ThreadMethodProxy.start(r101);     // Catch: Exception -> L16
        return;
    L21:
        return;
    L16:
        e = move-exception;
        com.larus.audio.call.util.e.f289645a.e(t(), "AudioPlayManager start thread failed.", e);
        return;
    L5:
        if (this.f289302h != 1) goto L8;
        com.larus.audio.call.util.e.f289645a.i(t(), "no init in Lite si");
    }

    public boolean q() {
        if (this.f289310p != AbsAudioPlayManager.Wait.STOPPED) goto L5;
    L7:
        return false;
    L5:
        if (this.f289310p == AbsAudioPlayManager.Wait.COMPLETE) goto L7;
        return true;
    }

    public int r() {
        int r100 = AudioTrack.getMinBufferSize(l().f289297c, l().f289298d, l().f289299e);
        if (r100 <= 0) goto L5;
        return r100;
    L5:
        return l().f289296b;
    }

    @Override // u68.a
    public boolean isPlaying() {
        return this.f289309o;
    }

    public String t() {
        return this.f289305k;
    }

    public static void m(AudioTrack r100) {
        if (fna.g.d() == true) goto L6;
        r100.pause();
        return;
    L6:
        r100.pause();
        gna.a.a(r100.hashCode());
    }

    public static void n(AudioTrack r100) {
        if (fna.g.d() == true) goto L6;
        r100.stop();
        return;
    L6:
        r100.stop();
        gna.a.a(r100.hashCode());
    }

    public static final void o(c r100) {
        r100.getClass();
        if (com.larus.audio.call.f.d().f289146v == false) goto L7;
        h r101 = r100.f289306l.poll(10, TimeUnit.MILLISECONDS);
        if (r101 == null) goto L11;
        r100.u(r101);
        return;
    L11:
        return;
    L7:
        h r102 = r100.f289306l.take();
        if (r102 == null) goto L13;
        r100.u(r102);
        return;
    }

    @Override // com.larus.audio.call.play.AbsAudioPlayManager, u68.a
    public final void c(boolean r100) {
        com.larus.audio.call.util.e.f289645a.i(t(), "mutePlay: enable=" + r100 + ", previousMuted=" + this.f289303i + ", lastGain=" + this.f289304j);
        if (this.f289303i != r100) goto L5;
        return;
    L5:
        this.f289303i = r100;
        AudioTrack r101 = this.f289308n;     // Catch: Throwable -> L13
        if (r101 == null) goto L18;
        if (r100 == false) goto L10;
        float r102 = 0.0f;
    L11:
        r101.setVolume(r102);     // Catch: Throwable -> L13
        return;
    L10:
        r102 = this.f289304j;     // Catch: Throwable -> L13
        goto L11
    L18:
        return;
    L13:
        th = move-exception;
        com.larus.audio.call.util.e.f289645a.e(t(), "mutePlay setVolume error: " + th.getMessage(), th);
    }

    @Override // u68.a
    public final void e(boolean r110) {
        if (this.f289308n == null) goto L7;
        if (r110 == true) goto L7;
        com.larus.audio.call.util.e.f289645a.i(t(), "audio play createPlayEngine, audioTrack is not null");
        return;
    L7:
        com.larus.audio.call.util.e r111 = com.larus.audio.call.util.e.f289645a;
        r111.i(t(), "audio play createPlayEngine");
        this.f289312r = r();     // Catch: Exception -> L17
        r111.i(t(), "createPlayEngine, minBufferSize=" + this.f289312r);     // Catch: Exception -> L17
        this.f289308n = new AudioTrack(l().f289295a, l().f289297c, l().f289298d, l().f289299e, this.f289312r * p(), 1, 0);     // Catch: Exception -> L17
        if (this.f289303i == true) goto L23;
    L20:
        return;
    L23:
        AudioTrack r112 = this.f289308n;     // Catch: Throwable -> L14
        if (r112 == null) goto L20;
        r112.setVolume(0.0f);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        com.larus.audio.call.util.e.f289645a.e(t(), "createPlayEngine reapply mute error: " + th.getMessage(), th);     // Catch: Exception -> L17
    L17:
        e = move-exception;
        com.larus.audio.call.util.e.f289645a.e(t(), e.getMessage(), e);
    }

    @Override // u68.b
    public void g(h r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        com.larus.audio.call.util.e r101 = com.larus.audio.call.util.e.f289645a;
        String r102 = t();
        StringBuilder r103 = new StringBuilder("audio play enqueue: ");
        r103.append(this.f289306l.size());
        r103.append(", data type is play= ");
        boolean r104 = r100 instanceof h.a;
        r103.append(r104);
        r103.append(", data:");
        String r105 = null;
        if (r104 == false) goto L5;
        h.a r106 = (h.a) r100;
    L6:
        if (r106 == null) goto L8;
        r105 = r106.f289332b;
    L8:
        r103.append(r105);
        r103.append(' ');
        r101.i(r102, r103.toString());
        this.f289306l.offer(r100);
        return;
    L5:
        r106 = null;
        goto L6
    }

    @Override // u68.a
    public void pause(String r100) {
        Intrinsics.checkNotNullParameter(r100, "caller");
        com.larus.audio.call.util.e.f289645a.i(t(), "audio play pause, caller: " + r100);
        this.f289289e.onPaused();
        w(AbsAudioPlayManager.Wait.PAUSED);
        AudioTrack r101 = this.f289308n;     // Catch: IllegalStateException -> L7
        if (r101 == null) goto L12;
        m(r101);     // Catch: IllegalStateException -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        com.larus.audio.call.util.e.f289645a.e(t(), "AudioTrack error while pause.", e);
    }

    @Override // u68.a
    public void release(boolean r100) {
        com.larus.audio.call.util.e.f289645a.i(t(), "audio play release " + r100);
        d(true, true, "stop_session");
        ((CopyOnWriteArraySet) this.f289289e.f289323b).clear();
        this.f289317w = r100;     // Catch: Exception -> L7
        b r101 = this.f289307m;     // Catch: Exception -> L7
        if (r101 == null) goto L12;
        r101.interrupt();     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        com.larus.audio.call.util.e.f289645a.e(t(), "release error", e);
    }

    @Override // u68.a
    public void resume(String r100) {
        Intrinsics.checkNotNullParameter(r100, "caller");
        com.larus.audio.call.util.e.f289645a.i(t(), "audio play resume, caller: " + r100);
        u68.a.C7838a.a(this, false, "resume -> " + r100, 3);
        w(AbsAudioPlayManager.Wait.RESUME);
        this.f289289e.onResume();
    }

    public byte[] s(byte[] r110) {
        if (r110 != null) goto L6;
        return null;
    L6:
        if (this.f289285a == true) goto L8;
    L20:
        return r110;
    L8:
        if (this.f289286b == false) goto L20;
        byte[] r100 = new byte[r110.length * 2];
        int r101 = ProgressionUtilKt.getProgressionLastElement(0, r110.length - 1, 2);
        if (r101 < 0) goto L19;
        int r102 = 0;
        int r103 = 0;
    L12:
        int r104 = r102 + 1;
        short r105 = (short) ((r110[r102] & UByte.MAX_VALUE) | ((r110[r104] & UByte.MAX_VALUE) << 8));
        if (com.larus.audio.call.f.c().e() == true) goto L16;
        r105 = (short) (r105 >> 1);
    L16:
        byte[] r106 = {(byte) (r105 & 255), (byte) (r105 >> 8)};
        r100[r103] = r110[r102];
        r100[r103 + 1] = r110[r104];
        r100[r103 + 2] = r106[0];
        r100[r103 + 3] = r106[1];
        r103 = r103 + 4;
        if (r102 == r101) goto L19;
        r102 = r102 + 2;
    L19:
        return r100;
    }

    @Override // u68.a
    public void setVolume(float r100) {
        com.larus.audio.call.util.e.f289645a.i(t(), "setVolume (), gain: " + r100 + ", isMuted: " + this.f289303i);     // Catch: Throwable -> L9
        this.f289304j = r100;     // Catch: Throwable -> L9
        if (this.f289303i == true) goto L14;
        AudioTrack r101 = this.f289308n;     // Catch: Throwable -> L9
        if (r101 == null) goto L15;
        r101.setVolume(r100);     // Catch: Throwable -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        th = move-exception;
        com.larus.audio.call.util.e.f289645a.e(t(), th.getMessage(), th);
    }

    public final void u(h r100) {
        if ((r100 instanceof h.d) == false) goto L6;
        com.larus.audio.call.util.e.f289645a.i(t(), "audio play poll: Warmup");
        v(((h.d) r100).f289337a);
        return;
    L6:
        if ((r100 instanceof h.c) == false) goto L32;
        com.larus.audio.call.util.e r101 = com.larus.audio.call.util.e.f289645a;
        r101.i(t(), "audio play poll: TtsStart");
        boolean r102 = false;
        this.f289315u = false;
        AudioTrack r103 = this.f289308n;
        if (r103 != null) goto L10;
    L12:
        if (r102 == false) goto L25;
        AudioTrack r104 = this.f289308n;
        if (r104 == null) goto L16;
        n(r104);
    L16:
        AudioTrack r105 = this.f289308n;
        if (r105 == null) goto L19;
        r105.flush();
    L19:
        AudioTrack r106 = this.f289308n;
        if (r106 == null) goto L25;
        if (fna.g.d() == true) goto L24;
        r106.play();
        goto L25
    L24:
        r106.play();
        gna.a.c(r106.hashCode());
    L25:
        AudioTrack r107 = this.f289308n;
        if (r107 == null) goto L30;
        r101.i(t(), "[tts_start]:setPositionNotification");
        r107.setPositionNotificationPeriod(this.f289301g);
        r107.setNotificationMarkerPosition(r107.getPlaybackHeadPosition() + 1);
        long r108 = System.currentTimeMillis();
        AudioTrack r109 = this.f289308n;
        if (r109 == null) goto L30;
        r109.setPlaybackPositionUpdateListener(new d(this, r108));
    L30:
        w(AbsAudioPlayManager.Wait.WAIT);
        this.f289289e.b(((h.c) r100).f289336a);
        return;
    L10:
        if (r103.getPlayState() != 3) goto L12;
        r102 = true;
        goto L12
    L32:
        if ((r100 instanceof h.a) == false) goto L38;
        com.larus.audio.call.util.e r110 = com.larus.audio.call.util.e.f289645a;
        r110.i(t(), "audio play poll: Play");
        if (q() == false) goto L36;
        h.a r111 = (h.a) r100;
        this.f289289e.d(r111);
        v(r111.f289331a);
        return;
    L36:
        r110.i(t(), "playData, waitPCM == " + this.f289310p);
        return;
    L38:
        if ((r100 instanceof h.b) == false) goto L40;
        com.larus.audio.call.util.e.f289645a.i(t(), "audio play poll: TtsEnd");
        w(AbsAudioPlayManager.Wait.DATA_END);
        this.f289289e.a();
        return;
    L40:
        Thread.sleep(100);
    }

    public final void v(byte[] r110) {
        byte[] r100 = s(r110);
        if (r100 != null) goto L5;
        return;
    L5:
        this.f289309o = true;
        com.larus.audio.call.util.e r101 = com.larus.audio.call.util.e.f289645a;
        String r102 = t();
        StringBuilder r103 = new StringBuilder("[playData] playData, data size: ");
        r103.append(r100.length);
        r103.append(", origin size: ");
        if (r110 == null) goto L8;
        Integer r111 = Integer.valueOf(r110.length);
    L9:
        r103.append(r111);
        r101.i(r102, r103.toString());
        int r104 = 0;
    L11:
        if (r104 >= r100.length) goto L63;
        if (this.f289308n == null) goto L42;
        if (this.f289311q == true) goto L42;
        AudioTrack r105 = this.f289308n;
        if (r105 == null) goto L64;
        int r106 = RangesKt.coerceAtMost(this.f289312r, r100.length - r104);
        int r107 = (r104 + r106) - 1;
        if (r107 <= r104) goto L24;
        this.f289289e.g(ArraysKt.copyOfRange(r100, r104, r107));
    L24:
        if (q() == false) goto L25;
        if (r100.length != 0) goto L29;
        boolean r108 = true;
    L31:
        if ((!r108) == false) goto L11;
        if (r106 <= 0) goto L11;
        int r109 = r105.write(r100, r104, r106);     // Catch: Exception -> L35
    L37:
        if (r109 < 0) goto L38;
        if (r109 == 0) goto L40;
        com.larus.audio.call.util.e.f289645a.i(t(), "[playData] AudioTrack write data normal, writeSize is: " + r109);
        int r112 = r109 + r104;
        this.f289289e.i(ArraysKt.copyOfRange(r100, r104, r112));
        this.f289313s = 0;
        r104 = r112;
        goto L11
    L40:
        Thread.sleep(10);
        com.larus.audio.call.util.e.f289645a.e(t(), "[playData] AudioTrack write data zero.");
        goto L11
    L38:
        Thread.sleep(50);
        com.larus.audio.call.util.e.f289645a.e(t(), "[playData] AudioTrack write data error, errorCode: " + r109 + '.');
    L35:
        e = move-exception;
        com.larus.audio.call.util.e.f289645a.e(t(), "[playData] AudioTrack write data error.", e);
        this.f289311q = true;
        r109 = -1;
        goto L37
    L29:
        r108 = false;
        goto L31
    L25:
        com.larus.audio.call.util.e.f289645a.i(t(), "[playData] break. waitPCM:" + this.f289310p);
        return;
    L64:
        return;
    L42:
        Thread.sleep(50);
        com.larus.audio.call.util.e.f289645a.e(t(), "[playData] AudioTrack null break. needBreak:" + this.f289311q);
        return;
    L63:
        return;
    L8:
        r111 = null;
        goto L9
    }

    public final void w(AbsAudioPlayManager.Wait r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        if (this.f289310p == r100) goto L5;
        com.larus.audio.call.util.e.f289645a.i(t(), "waitPCM change, from: " + this.f289310p + " to " + r100);
    L5:
        this.f289310p = r100;
    }

    public c(RealtimeCallParam r100, boolean r101, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "realtimeCallParam");
        this(r100, r101, r110, null, 0);
    }

    @Override // u68.a
    public void d(boolean r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "endType");
        com.larus.audio.call.util.e.f289645a.i(t(), "audio play stop, immediate: " + r100 + ", release: " + r101 + ", " + r102 + '.');
        w(AbsAudioPlayManager.Wait.STOPPED);
        this.f289306l.clear();     // Catch: IllegalStateException -> L21
        if (r100 == false) goto L14;
        AudioTrack r103 = this.f289308n;     // Catch: IllegalStateException -> L21
        if (r103 == null) goto L8;
        m(r103);     // Catch: IllegalStateException -> L21
    L8:
        AudioTrack r104 = this.f289308n;     // Catch: IllegalStateException -> L21
        if (r104 == null) goto L11;
        r104.flush();     // Catch: IllegalStateException -> L21
    L11:
        AudioTrack r105 = this.f289308n;     // Catch: IllegalStateException -> L21
        if (r105 == null) goto L23;
        n(r105);     // Catch: IllegalStateException -> L21
    L23:
        if (r101 == true) goto L39;
        return;
    L39:
        AudioTrack r106 = this.f289308n;     // Catch: Throwable -> L30 IllegalStateException -> L32
        if (r106 == null) goto L28;
        r106.release();     // Catch: Throwable -> L30 IllegalStateException -> L32
    L28:
        this.f289308n = null;     // Catch: Throwable -> L30 IllegalStateException -> L32
    L34:
        this.f289308n = null;
        return;
    L30:
        th = move-exception;
        this.f289308n = null;
        throw th;
    L32:
        e = move-exception;
        com.larus.audio.call.util.e.f289645a.e(t(), "AudioTrack release while stop.", e);     // Catch: Throwable -> L30
        goto L34
    L14:
        AudioTrack r107 = this.f289308n;     // Catch: IllegalStateException -> L21
        if (r107 == null) goto L17;
        n(r107);     // Catch: IllegalStateException -> L21
    L17:
        AudioTrack r108 = this.f289308n;     // Catch: IllegalStateException -> L21
        if (r108 == null) goto L23;
        r108.flush();     // Catch: IllegalStateException -> L21
    L21:
        e = move-exception;
        com.larus.audio.call.util.e.f289645a.e(t(), "AudioTrack error while stop.", e);
        goto L23
    }

    @Override // u68.a
    public void k(boolean r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "caller");
        if (Intrinsics.areEqual(this.f289300f.f288751k.f288826o, "dora_si") == true) goto L5;
    L8:
        com.larus.audio.call.util.e r103 = com.larus.audio.call.util.e.f289645a;
        String r104 = t();
        StringBuilder r105 = new StringBuilder("audio play, playState: ");
        AudioTrack r106 = this.f289308n;
        if (r106 == null) goto L11;
        Integer r107 = Integer.valueOf(r106.getPlayState());
    L12:
        r105.append(r107);
        r105.append(", earphone: ");
        r105.append(com.larus.audio.call.f.c().e());
        r105.append(", flush: ");
        r105.append(r100);
        r105.append(", create: ");
        r105.append(r101);
        r105.append(", caller: ");
        r105.append(r102);
        r103.i(r104, r105.toString());
        if (this.f289308n == null) goto L22;
        AudioTrack r108 = this.f289308n;
        if (r108 != null) goto L17;
    L19:
        boolean r109 = false;
    L20:
        if (r109 == true) goto L22;
        r103.e(t(), "audio play, init error");
        e(true);
        goto L22
    L17:
        if (r108.getState() != 1) goto L19;
        r109 = true;
    L22:
        if (r101 == true) goto L24;
    L26:
        if (r100 == true) goto L45;
    L33:
        AudioTrack r110 = this.f289308n;     // Catch: Exception -> L40 IllegalStateException -> L42
        if (r110 != null) goto L36;
        return;
    L36:
        if (fna.g.d() == true) goto L38;
        r110.play();     // Catch: Exception -> L40 IllegalStateException -> L42
        return;
    L38:
        r110.play();     // Catch: Exception -> L40 IllegalStateException -> L42
        gna.a.c(r110.hashCode());     // Catch: Exception -> L40 IllegalStateException -> L42
        return;
    L45:
        AudioTrack r111 = this.f289308n;     // Catch: Exception -> L40 IllegalStateException -> L42
        if (r111 == null) goto L30;
        m(r111);     // Catch: Exception -> L40 IllegalStateException -> L42
    L30:
        AudioTrack r112 = this.f289308n;     // Catch: Exception -> L40 IllegalStateException -> L42
        if (r112 == null) goto L33;
        r112.flush();     // Catch: Exception -> L40 IllegalStateException -> L42
    L42:
        e = move-exception;
        com.larus.audio.call.util.e.f289645a.e(t(), "AudioTrack error while play.", e);
        return;
    L40:
        e = move-exception;
        com.larus.audio.call.util.e.f289645a.e(t(), e.getMessage(), e);
        return;
    L24:
        if (this.f289308n != null) goto L26;
        e(false);
        goto L26
    L11:
        r107 = null;
        goto L12
    L5:
        if (this.f289302h != 1) goto L8;
        com.larus.audio.call.util.e.f289645a.i(t(), "no play in Lite si");
    }

    public c(RealtimeCallParam r100, boolean r101, boolean r102, Integer r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "realtimeCallParam");
        super(r101, r102, r103);
        this.f289300f = r100;
        this.f289301g = 10;
        this.f289302h = r104;
        this.f289304j = 1.0f;
        this.f289305k = "AudioPlayManager" + hashCode();
        this.f289306l = new LinkedBlockingQueue();
        this.f289310p = AbsAudioPlayManager.Wait.INVALID;
        this.f289312r = 1280;
        this.f289314t = 100;
        this.f289316v = "flow-audio-play-manager";
    }
}
