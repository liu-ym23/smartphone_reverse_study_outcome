package com.larus.avlink;

import com.larus.audio.audiov3.audio.record.AudioRecordState;
import com.larus.avlink.plugins.k4;
import com.larus.avlink.plugins.x2;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes24.dex */
public final class w implements r58.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f294728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AudioRecordState f294729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PipedInputStream f294730c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PipedOutputStream f294731d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BlockingQueue<byte[]> f294732e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.larus.audio.call.util.o f294733f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f294734g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final x f294735h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f294736i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f294737j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function0<Unit> f294738k;

    public static final class a {
    }

    static {
    }

    @Override // r58.c
    public final void b(long r100, long r101) {
    }

    @Override // r58.c
    public final int c() {
        return 80;
    }

    @Override // r58.c
    public final long d(long r100) {
        return 0;
    }

    @Override // r58.c
    public final void f(Function2<? super String, ? super Long, Unit> r100) {
    }

    @Override // r58.c
    public final void g(Function2<? super Boolean, ? super String, Unit> r100) {
    }

    @Override // r58.c
    public final void j() {
    }

    @Override // r58.c
    public final void prepare() {
        n1.a("DoraAudioRecorder", "prepare");
        m(AudioRecordState.INITIALIZED);
    }

    @Override // r58.c
    public final void release() {
        n1.a("DoraAudioRecorder", "release");
        this.f294734g.set(true);
        this.f294730c.close();     // Catch: Exception -> L5
        this.f294731d.close();     // Catch: Exception -> L5
        ((LinkedBlockingQueue) this.f294732e).clear();     // Catch: Exception -> L5
    L7:
        m(AudioRecordState.UNINITIALIZED);
        n1.b("DoraAudioRecorder", "unRegisterDoraVoiceCallback");
        Map<Function1<Boolean, Unit>, k4> r100 = x2.f294117a;
        x2.k(this.f294735h);
        return;
    L5:
        e = move-exception;
        n1.c("DoraAudioRecorder", "stream release exception", e);
        goto L7
    }

    @Override // r58.c
    public final void start() {
        n1.a("DoraAudioRecorder", "start");
        m(AudioRecordState.STARTED);
    }

    @Override // r58.c
    public final void stop() {
        n1.a("DoraAudioRecorder", "stop");
        m(AudioRecordState.STOPPED);
    }

    @Override // r58.c
    public final AudioRecordState l() {
        return this.f294729b;
    }

    public w(int r100) {
        this.f294728a = null;
        this.f294729b = AudioRecordState.UNINITIALIZED;
        PipedInputStream r101 = new PipedInputStream(40000);
        this.f294730c = r101;
        PipedOutputStream r102 = new PipedOutputStream();
        this.f294731d = r102;
        this.f294732e = new LinkedBlockingQueue();
        this.f294733f = new com.larus.audio.call.util.o(300);
        this.f294734g = new AtomicBoolean(false);
        this.f294735h = new x(this);
        this.f294736i = true;
        r101.connect(r102);     // Catch: Exception -> L5
    L7:
        n1.b("DoraAudioRecorder", "registerDoraVoiceCallback");
        Map<Function1<Boolean, Unit>, k4> r103 = x2.f294117a;
        x2.d(this.f294735h);
        m(AudioRecordState.INITIALIZED);
        return;
    L5:
        e = move-exception;
        n1.c("DoraAudioRecorder", "stream connect exception", e);
        goto L7
    }

    @Override // r58.c
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
    }

    @Override // r58.c
    public final void e(Function0<Unit> r100) {
        this.f294731d.close();     // Catch: Exception -> L4
    L6:
        this.f294738k = r100;
        this.f294737j = true;
        return;
    L4:
        e = move-exception;
        n1.c("DoraAudioRecorder", "pendingStop failed", e);
        goto L6
    }

    @Override // r58.c
    public final void h(v58.a r100) {
        Intrinsics.checkNotNullParameter(r100, "audioRecordConfig");
        n1.a("DoraAudioRecorder", "config");
    }

    @Override // r58.c
    public final void k(Function2<? super r58.d, ? super byte[], Unit> r110) {
        Intrinsics.checkNotNullParameter(r110, "onAudioDataReceived");
        byte[] r100 = new byte[80];
    L4:
        if (ThreadMethodProxy.currentThread().isInterrupted() == true) goto L42;
        if (this.f294734g.get() == true) goto L43;
        byte[] r101 = new byte[256];
        Intrinsics.checkNotNullParameter(r100, "buffer");
        int r102 = i(r100, 80);
        int r103 = 0;
        if (r102 > 0) goto L33;
    L24:
        Pair r104 = new Pair(Integer.valueOf(r102), Integer.valueOf(r103));
        int r105 = ((Number) r104.component1()).intValue();
        int r106 = ((Number) r104.component2()).intValue();
        if (r105 == 0) goto L4;
        if (r105 <= 0) goto L29;
        r110.invoke(new r58.d(r105, Arrays.copyOf(r100, r105)), Arrays.copyOf(r101, r106));
        goto L4
    L29:
        n1.b("DoraAudioRecorder", "audioRecord record failed, error code: " + r105);
        return;
    L33:
    L22:
        th = th;
    L23:
        n1.a("DoraAudioRecorder", "vad read " + com.larus.utils.u0.a(th));
        goto L24
    L10:
        if (((LinkedBlockingQueue) this.f294732e).size() <= 0) goto L24;
        byte[] r107 = (byte[]) ((LinkedBlockingQueue) this.f294732e).poll(0, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L22
        if (r107 == null) goto L15;
        int r108 = r107.length;     // Catch: Throwable -> L22
    L16:
        if (r108 > 0) goto L31;
    L21:
        r103 = r108;
        goto L24
    L31:
        System.arraycopy(r107, 0, r101, 0, r107.length);     // Catch: Throwable -> L19
        n1.a("DoraAudioRecorder", "vad read: " + r107.length);     // Catch: Throwable -> L19
    L19:
        th = th;
        r103 = r108;
        goto L23
    L15:
        r108 = 0;
        goto L16
    L43:
        return;
    }

    public final void m(AudioRecordState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        n1.a("DoraAudioRecorder", "#onStateChange state:" + r100);
        this.f294729b = r100;
    }

    @Override // r58.c
    public final int i(byte[] r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "buffer");
        if (this.f294736i == false) goto L7;
        this.f294736i = false;
        Function0<Unit> r102 = this.f294728a;
        if (r102 == null) goto L7;
        r102.invoke();
    L7:
        final Ref.IntRef r103 = new Ref.IntRef();
        r103.element = this.f294730c.read(r100, 0, r101);     // Catch: Exception -> L10
    L13:
        if (r103.element == 80) goto L15;
        n1.b("DoraAudioRecorder", "read: " + r103.element + ", pendingStop:" + this.f294737j);
    L17:
        if (r103.element != (-1)) goto L25;
        if (this.f294737j == false) goto L25;
        this.f294737j = false;
        Function0<Unit> r104 = this.f294738k;
        if (r104 == null) goto L23;
        r104.invoke();
    L23:
        stop();
    L25:
        return r103.element;
    L15:
        this.f294733f.a(new v(r103, this));
    L10:
        e = move-exception;
        n1.c("DoraAudioRecorder", "read failed: " + r103.element, e);
        r103.element = -1;
        goto L13
    }
}
