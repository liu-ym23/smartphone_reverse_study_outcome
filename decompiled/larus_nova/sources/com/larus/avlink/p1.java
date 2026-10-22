package com.larus.avlink;

import com.byted.cast.common.ErrorCode;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.audio.audiov3.audio.record.AudioRecordState;
import com.larus.avlink.plugins.n4;
import com.larus.platform.api.IDoraAutoTestPlatform;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.BufferedInputStream;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public final class p1 implements r58.c {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static volatile p1 f293505o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f293506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n4 f293507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f293508c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AudioRecordState f293509d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PolarisFileInputStreamWrapper f293510e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BufferedInputStream f293511f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ConcurrentLinkedQueue<String> f293512g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f293513h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final BlockingQueue<byte[]> f293514i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.larus.audio.call.util.o f293515j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicBoolean f293516k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f293517l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f293518m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Function0<Unit> f293519n;

    public static final class a {
    }

    static {
    }

    @Override // r58.c
    public final void b(long r100, long r101) {
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

    public final void m() {
        BufferedInputStream r100 = this.f293511f;     // Catch: Throwable -> L10 Exception -> L12
        if (r100 == null) goto L6;
        r100.close();     // Catch: Throwable -> L10 Exception -> L12
    L6:
        PolarisFileInputStreamWrapper r101 = this.f293510e;     // Catch: Throwable -> L10 Exception -> L12
        if (r101 == null) goto L14;
        r101.close();     // Catch: Throwable -> L10 Exception -> L12
    L14:
        this.f293511f = null;
        this.f293510e = null;
        return;
    L10:
        th = move-exception;
        this.f293511f = null;
        this.f293510e = null;
        throw th;
    L12:
        e = move-exception;
        n1.c("MockAudioRecorder", "Failed to close streams", e);     // Catch: Throwable -> L10
        goto L14
    }

    public final boolean p() {
        String r100 = this.f293512g.poll();
        if (r100 == null) goto L32;
        n1.a("MockAudioRecorder", "tryNextFile: switching to ".concat(r100));
        n1.a("MockAudioRecorder", "switchToFile: ".concat(r100));
        m();
        String r101 = new PolarisFileWrapper(r100).getCanonicalPath();
        this.f293513h = r101;
        PolarisFileWrapper r110 = new PolarisFileWrapper(r101);     // Catch: Exception -> L29
        n1.a("MockAudioRecorder", "File exists: " + r110.exists() + ", isFile: " + r110.isFile() + ", canRead: " + r110.canRead());     // Catch: Exception -> L29
        StringBuilder r111 = new StringBuilder("File size: ");     // Catch: Exception -> L29
        if (r110.exists() == false) goto L8;
        Object r102 = Long.valueOf(r110.length());     // Catch: Exception -> L29
    L9:
        r111.append(r102);     // Catch: Exception -> L29
        r111.append(" bytes");     // Catch: Exception -> L29
        n1.a("MockAudioRecorder", r111.toString());     // Catch: Exception -> L29
        if (r110.exists() == true) goto L12;
    L16:
        n1.b("MockAudioRecorder", "File does not exist, is not a file, or cannot be read: " + r101);     // Catch: Exception -> L29
        n1.b("MockAudioRecorder", "  - exists: " + r110.exists());     // Catch: Exception -> L29
        n1.b("MockAudioRecorder", "  - isFile: " + r110.isFile());     // Catch: Exception -> L29
        n1.b("MockAudioRecorder", "  - canRead: " + r110.canRead());     // Catch: Exception -> L29
        if (r110.exists() == false) goto L27;
        StringBuilder r103 = new StringBuilder("  - parent exists: ");     // Catch: Exception -> L29
        File r104 = r110.getParentFile();     // Catch: Exception -> L29
        if (r104 == null) goto L21;
        Boolean r105 = Boolean.valueOf(r104.exists());     // Catch: Exception -> L29
    L22:
        r103.append(r105);     // Catch: Exception -> L29
        n1.b("MockAudioRecorder", r103.toString());     // Catch: Exception -> L29
        StringBuilder r106 = new StringBuilder("  - parent canRead: ");     // Catch: Exception -> L29
        File r107 = r110.getParentFile();     // Catch: Exception -> L29
        if (r107 == null) goto L25;
        Boolean r108 = Boolean.valueOf(r107.canRead());     // Catch: Exception -> L29
    L26:
        r106.append(r108);     // Catch: Exception -> L29
        n1.b("MockAudioRecorder", r106.toString());     // Catch: Exception -> L29
        goto L27
    L25:
        r108 = null;
        goto L26
    L21:
        r105 = null;
    L27:
        this.f293513h = null;     // Catch: Exception -> L29
    L31:
        return true;
    L12:
        if (r110.isFile() == false) goto L16;
        if (r110.canRead() == false) goto L16;
        this.f293510e = new PolarisFileInputStreamWrapper(r110);     // Catch: Exception -> L29
        this.f293511f = new BufferedInputStream(this.f293510e, ErrorCode.LICENSE_USER_VALID);     // Catch: Exception -> L29
        n1.a("MockAudioRecorder", "Successfully opened file: " + r101);     // Catch: Exception -> L29
        goto L31
    L8:
        r102 = "N/A";
    L29:
        e = move-exception;
        n1.c("MockAudioRecorder", "Failed to open file: " + r101, e);
        this.f293513h = null;
        goto L31
    L32:
        return false;
    }

    @Override // r58.c
    public final void prepare() {
        n1.a("MockAudioRecorder", "prepare");
        n(AudioRecordState.INITIALIZED);
    }

    @Override // r58.c
    public final void release() {
        n1.a("MockAudioRecorder", "release");
        this.f293516k.set(true);
        m();     // Catch: Exception -> L5
        ((LinkedBlockingQueue) this.f293514i).clear();     // Catch: Exception -> L5
        n1.a("MockAudioRecorder", "clearAllAudioFiles");     // Catch: Exception -> L5
        this.f293512g.clear();     // Catch: Exception -> L5
        m();     // Catch: Exception -> L5
        this.f293513h = null;     // Catch: Exception -> L5
    L7:
        n(AudioRecordState.UNINITIALIZED);
        n1.b("MockAudioRecorder", "unRegisterDoraVoiceCallback");
        if (Intrinsics.areEqual(f293505o, this) == false) goto L13;
        f293505o = null;
        return;
    L13:
        return;
    L5:
        e = move-exception;
        n1.c("MockAudioRecorder", "stream release exception", e);
        goto L7
    }

    @Override // r58.c
    public final void start() {
        n1.a("MockAudioRecorder", "start, queue size: " + this.f293512g.size());
        n(AudioRecordState.STARTED);
    }

    @Override // r58.c
    public final void stop() {
        n1.a("MockAudioRecorder", "stop");
        n(AudioRecordState.STOPPED);
    }

    @Override // r58.c
    public final int c() {
        return this.f293508c;
    }

    @Override // r58.c
    public final AudioRecordState l() {
        return this.f293509d;
    }

    public p1(n4 r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f293506a = null;
        this.f293507b = r100;
        this.f293508c = 80;
        this.f293509d = AudioRecordState.UNINITIALIZED;
        this.f293512g = new ConcurrentLinkedQueue();
        this.f293514i = new LinkedBlockingQueue();
        this.f293515j = new com.larus.audio.call.util.o(300);
        this.f293516k = new AtomicBoolean(false);
        this.f293517l = true;
        f293505o = this;
        n1.b("MockAudioRecorder", "registerDoraVoiceCallback");
        n(AudioRecordState.INITIALIZED);
    }

    @Override // r58.c
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
    }

    @Override // r58.c
    public final void e(Function0<Unit> r100) {
        n1.a("MockAudioRecorder", "pendingStop called");     // Catch: Exception -> L5
    L7:
        this.f293519n = r100;
        this.f293518m = true;
        return;
    L5:
        e = move-exception;
        n1.c("MockAudioRecorder", "pendingStop failed", e);
        goto L7
    }

    @Override // r58.c
    public final void h(v58.a r100) {
        Intrinsics.checkNotNullParameter(r100, "audioRecordConfig");
        n1.a("MockAudioRecorder", "config");
    }

    @Override // r58.c
    public final void k(Function2<? super r58.d, ? super byte[], Unit> r110) {
        Intrinsics.checkNotNullParameter(r110, "onAudioDataReceived");
        int r100 = this.f293508c;
        byte[] r101 = new byte[r100];
        n1.a("MockAudioRecorder", "startLoop started with buffer size: " + r100);
    L4:
        if (ThreadMethodProxy.currentThread().isInterrupted() == true) goto L26;
        if (this.f293516k.get() == true) goto L26;
        byte[] r102 = new byte[256];     // Catch: Exception -> L24
        Pair r103 = o(r101, r100, r102);     // Catch: Exception -> L24
        int r104 = ((Number) r103.component1()).intValue();     // Catch: Exception -> L24
        int r105 = ((Number) r103.component2()).intValue();     // Catch: Exception -> L24
        if (r100 == 0) goto L10;
        if (r104 == 0) goto L12;
        if (r104 > 0) goto L14;
        if (this.f293513h != null) goto L21;
        if (this.f293512g.isEmpty() == false) goto L21;
        Thread.sleep(10);     // Catch: Exception -> L24
    L21:
        if (this.f293511f != null) goto L4;
        n1.e("MockAudioRecorder", "File path set but stream is null, waiting for file to be opened...");     // Catch: Exception -> L24
        Thread.sleep(100);     // Catch: Exception -> L24
        goto L4
    L14:
        r110.invoke(new r58.d(r104, Arrays.copyOf(r101, r104)), Arrays.copyOf(r102, r105));     // Catch: Exception -> L24
        goto L4
    L12:
        Thread.sleep(10);     // Catch: Exception -> L24
        goto L4
    L10:
        n1.e("MockAudioRecorder", "Buffer size is 0, continuing...");     // Catch: Exception -> L24
        Thread.sleep(10);     // Catch: Exception -> L24
    L24:
        e = move-exception;
        FLogger.f375446a.i("MockAudioRecorder", "mockAudioRecorder: " + e);
        Thread.sleep(10);
    L26:
        n1.a("MockAudioRecorder", "startLoop ended");
    }

    public final void n(AudioRecordState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        n1.a("MockAudioRecorder", "#onStateChange state:" + r100);
        this.f293509d = r100;
    }

    @Override // r58.c
    public final int i(byte[] r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "buffer");
        if (this.f293517l == false) goto L7;
        this.f293517l = false;
        Function0<Unit> r102 = this.f293506a;
        if (r102 == null) goto L7;
        r102.invoke();
    L7:
        final Ref.IntRef r103 = new Ref.IntRef();
        BufferedInputStream r104 = this.f293511f;     // Catch: Exception -> L39
        if (r104 == null) goto L30;
        int r105 = r104.read(r100, 0, r101);     // Catch: Exception -> L39
        r103.element = r105;     // Catch: Exception -> L39
        if (r105 != (-1)) goto L41;
        n1.a("MockAudioRecorder", "Reached end of current file: " + this.f293513h);     // Catch: Exception -> L39
        m();     // Catch: Exception -> L39
        this.f293513h = null;     // Catch: Exception -> L39
        if (p() == false) goto L20;
        BufferedInputStream r106 = this.f293511f;     // Catch: Exception -> L39
        if (r106 == null) goto L19;
        int r107 = r106.read(r100, 0, r101);     // Catch: Exception -> L39
        r103.element = r107;     // Catch: Exception -> L39
        if (r107 != (-1)) goto L41;
        n1.a("MockAudioRecorder", "New file also ended immediately");     // Catch: Exception -> L39
        r103.element = 0;     // Catch: Exception -> L39
        goto L41
    L19:
        n1.e("MockAudioRecorder", "Failed to switch to new file");     // Catch: Exception -> L39
        r103.element = 0;     // Catch: Exception -> L39
        goto L41
    L20:
        n1.a("MockAudioRecorder", "No more files in queue");     // Catch: Exception -> L39
        if (this.f293507b.q() != 2) goto L23;
        boolean r108 = true;
    L24:
        if (r108 == false) goto L28;
        IDoraAutoTestPlatform r109 = (IDoraAutoTestPlatform) ServiceManager.get().getService(IDoraAutoTestPlatform.class);     // Catch: Exception -> L39
        if (r109 == null) goto L28;
        new JSONObject().put("scene", "queryEnd");     // Catch: Exception -> L39
        r109.a();     // Catch: Exception -> L39
    L28:
        r103.element = -1;     // Catch: Exception -> L39
        goto L41
    L23:
        r108 = false;
    L41:
        int r110 = r103.element;
        if (r110 == this.f293508c) goto L46;
        if (r110 == (-1)) goto L46;
        if (r110 == 0) goto L46;
        n1.b("MockAudioRecorder", "read: " + r103.element + ", pendingStop:" + this.f293518m + ", currentFile: " + this.f293513h + ", queueSize: " + this.f293512g.size());
    L49:
        if (r103.element != (-1)) goto L57;
        if (this.f293518m == false) goto L57;
        this.f293518m = false;
        Function0<Unit> r111 = this.f293519n;
        if (r111 == null) goto L55;
        r111.invoke();
    L55:
        stop();
    L57:
        return r103.element;
    L46:
        if (r110 <= 0) goto L49;
        this.f293515j.a(new o1(r103, this));
        goto L49
    L30:
        if (p() == false) goto L37;
        BufferedInputStream r112 = this.f293511f;     // Catch: Exception -> L39
        if (r112 == null) goto L36;
        int r113 = r112.read(r100, 0, r101);     // Catch: Exception -> L39
        r103.element = r113;     // Catch: Exception -> L39
        if (r113 != (-1)) goto L41;
        n1.a("MockAudioRecorder", "New file from queue ended immediately");     // Catch: Exception -> L39
        r103.element = -1;     // Catch: Exception -> L39
        goto L41
    L36:
        n1.e("MockAudioRecorder", "Failed to open file from queue");     // Catch: Exception -> L39
        r103.element = 0;     // Catch: Exception -> L39
        goto L41
    L37:
        r103.element = 0;     // Catch: Exception -> L39
    L39:
        e = move-exception;
        n1.c("MockAudioRecorder", "read failed: " + r103.element, e);
        r103.element = -1;
        goto L41
    }

    public final Pair o(byte[] r100, int r101, byte[] r102) {
        Intrinsics.checkNotNullParameter(r100, "buffer");
        int r103 = i(r100, r101);
        int r104 = 0;
        if (r103 <= 0) goto L21;
    L16:
        th = move-exception;
        Throwable th10 = th;
        int r105 = 0;
    L18:
        n1.a("MockAudioRecorder", "vad read " + com.larus.utils.u0.a(th10));
    L19:
        r104 = r105;
        goto L21
    L5:
        if (((LinkedBlockingQueue) this.f293514i).size() <= 0) goto L21;
        byte[] r106 = (byte[]) ((LinkedBlockingQueue) this.f293514i).poll(0, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L16
        if (r106 == null) goto L10;
        r105 = r106.length;     // Catch: Throwable -> L16
    L11:
        if (r105 <= 0) goto L19;
        System.arraycopy(r106, 0, r102, 0, r106.length);     // Catch: Throwable -> L14
        n1.a("MockAudioRecorder", "vad read: " + r106.length);     // Catch: Throwable -> L14
    L14:
        th10 = th;
        goto L18
    L10:
        r105 = 0;
    L21:
        return new Pair(Integer.valueOf(r103), Integer.valueOf(r104));
    }
}
