package p58;

import android.media.AudioRecord;
import android.media.AudioTimestamp;
import android.os.Build;
import android.os.SystemClock;
import com.larus.audio.audiov3.audio.record.AudioRecordErrorEnum;
import com.larus.audio.audiov3.audio.record.AudioRecordState;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import fna.g;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class d implements r58.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f527813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f527814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f527815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public v58.a f527816d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AudioRecord f527817e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AudioRecordState f527818f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f527819g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f527820h;

    public static final class a {
    }

    static {
    }

    @Override // r58.c
    public final void b(long r100, long r101) {
    }

    @Override // r58.c
    public final void e(Function0<Unit> r100) {
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
    public final int c() {
        int r100 = this.f527813a;
        if (r100 == (-1)) goto L5;
        return r100;
    L5:
        v58.a r101 = this.f527816d;
        if (r101 == null) goto L9;
        m(r101);
    L9:
        return this.f527813a;
    }

    @Override // r58.c
    public final void prepare() {
        v58.a r100 = this.f527816d;
        if (r100 == null) goto L21;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        if (this.f527813a != (-1)) goto L7;
        m(r100);     // Catch: Throwable -> L9
    L7:
        int r102 = c68.b.f22600a;     // Catch: Throwable -> L9
        c68.b.d(this.f527814b, "start => minBufferSize:" + this.f527813a);     // Catch: Throwable -> L9
        this.f527817e = new AudioRecord(r100.f553278d, r100.f553275a, r100.f553276b, r100.f553277c, this.f527813a * ((Number) this.f527820h.getValue()).intValue());     // Catch: Throwable -> L9
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L12:
        if (Result.m9456isSuccessimpl(r103) == false) goto L14;
        Unit r104 = (Unit) r103;
        int r105 = c68.b.f22600a;
        c68.b.d(this.f527814b, "prepare => success");
        s(AudioRecordState.INITIALIZED);
    L14:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r103);
        if (r106 == null) goto L17;
        int r107 = c68.b.f22600a;
        c68.b.c(this.f527814b, "prepare => fail", r106);
        r(AudioRecordErrorEnum.PREPARE_ERROR);
    L17:
        Result.m9448boximpl(r103);
        return;
    L9:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public final long q() {
        v58.a r100 = this.f527816d;
        if (r100 != null) goto L6;
        return 40;
    L6:
        int r101 = c();
        if (r100.f553276b != 12) goto L9;
        int r102 = 2;
    L11:
        return (((((long) r101) * 1000) / ((long) r100.f553275a)) / ((long) r100.f553277c)) / ((long) r102);
    L9:
        r102 = 1;
        goto L11
    }

    @Override // r58.c
    public final void release() {
        AudioRecord r100 = this.f527817e;
        if (r100 != null) goto L5;
    L25:
        r(AudioRecordErrorEnum.RELEASE_ERROR);
        return;
    L5:
        if (r100.getState() != 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L25;
        AudioRecord r102 = this.f527817e;
        if (r102 != null) goto L27;
    L23:
        this.f527815c = true;
        return;
    L27:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L14
        n(r102);     // Catch: Throwable -> L14
        s(AudioRecordState.UNINITIALIZED);     // Catch: Throwable -> L14
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L17:
        if (Result.m9456isSuccessimpl(r104) == false) goto L19;
        Unit r105 = (Unit) r104;
        int r106 = c68.b.f22600a;
        c68.b.d(this.f527814b, "release => success");
    L19:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r104);
        if (r107 == null) goto L22;
        int r108 = c68.b.f22600a;
        c68.b.c(this.f527814b, "release => fail", r107);
        r(AudioRecordErrorEnum.RELEASE_ERROR);
    L22:
        Result.m9448boximpl(r104);
    L14:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    L7:
        r101 = false;
        goto L8
    }

    @Override // r58.c
    public final void start() {
        if (this.f527816d != null) goto L6;
        r(AudioRecordErrorEnum.START_ERROR);
        return;
    L6:
        AudioRecord r100 = this.f527817e;
        if (r100 == null) goto L21;
        boolean r101 = true;
        if (r100.getState() == 1) goto L12;
        r101 = false;
    L12:
        if (r101 == false) goto L21;
        int r102 = c68.b.f22600a;
        c68.b.d(this.f527814b, "start => success");
        AudioRecord r103 = this.f527817e;
        if (r103 != null) goto L16;
    L19:
        s(AudioRecordState.STARTED);
        return;
    L16:
        if (g.d() == true) goto L18;
        o(r103);
        goto L19
    L18:
        o(r103);
        hna.a.b(r103.hashCode());
    L21:
        v58.a r104 = this.f527816d;
        if (r104 == null) goto L48;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L36
        if (this.f527813a != (-1)) goto L26;
        m(r104);     // Catch: Throwable -> L36
    L26:
        int r106 = c68.b.f22600a;     // Catch: Throwable -> L36
        c68.b.d(this.f527814b, "start => minBufferSize:" + this.f527813a);     // Catch: Throwable -> L36
        this.f527817e = new AudioRecord(r104.f553278d, r104.f553275a, r104.f553276b, r104.f553277c, this.f527813a * ((Number) this.f527820h.getValue()).intValue());     // Catch: Throwable -> L36
        s(AudioRecordState.INITIALIZED);     // Catch: Throwable -> L36
        AudioRecord r107 = this.f527817e;     // Catch: Throwable -> L36
        if (r107 != null) goto L29;
        Unit r108 = null;
    L34:
        Object r109 = Result.m9449constructorimpl(r108);     // Catch: Throwable -> L36
    L39:
        if (Result.m9456isSuccessimpl(r109) == false) goto L41;
        Unit r110 = (Unit) r109;
        int r111 = c68.b.f22600a;
        c68.b.d(this.f527814b, "start => success");
        s(AudioRecordState.STARTED);
    L41:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r109);
        if (r112 == null) goto L44;
        int r113 = c68.b.f22600a;
        c68.b.c(this.f527814b, "start => fail", r112);
        r(AudioRecordErrorEnum.START_ERROR);
    L44:
        Result.m9448boximpl(r109);
        return;
    L29:
        if (g.d() == true) goto L31;
        o(r107);     // Catch: Throwable -> L36
    L32:
        r108 = Unit.INSTANCE;     // Catch: Throwable -> L36
        goto L34
    L31:
        o(r107);     // Catch: Throwable -> L36
        hna.a.b(r107.hashCode());     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L39
    }

    @Override // r58.c
    public final void stop() {
        AudioRecord r100 = this.f527817e;
        if (r100 != null) goto L5;
    L28:
        r(AudioRecordErrorEnum.UNKNOWN_ERROR);
        return;
    L5:
        if (r100.getState() != 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L28;
        AudioRecord r102 = this.f527817e;
        if (r102 == null) goto L32;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L18
        if (g.d() == true) goto L15;
        p(r102);     // Catch: Throwable -> L18
    L16:
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L21:
        if (Result.m9456isSuccessimpl(r104) == false) goto L23;
        Unit r105 = (Unit) r104;
        int r106 = c68.b.f22600a;
        c68.b.d(this.f527814b, "stop => success");
        s(AudioRecordState.STOPPED);
    L23:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r104);
        if (r107 == null) goto L26;
        int r108 = c68.b.f22600a;
        c68.b.c(this.f527814b, "stop => fail", r107);
        r(AudioRecordErrorEnum.UNKNOWN_ERROR);
    L26:
        Result.m9448boximpl(r104);
        return;
    L15:
        p(r102);     // Catch: Throwable -> L18
        hna.a.c(r102.hashCode());     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    L32:
        return;
    L7:
        r101 = false;
        goto L8
    }

    @Override // r58.c
    public final AudioRecordState l() {
        return this.f527818f;
    }

    public d(int r100) {
        this.f527813a = r100;
        this.f527814b = "AudioRecorder";
        this.f527818f = AudioRecordState.UNINITIALIZED;
        this.f527819g = LazyKt.lazy(new b());
        this.f527820h = LazyKt.lazy(new c(this));
    }

    public static void n(AudioRecord r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        if (r100.b(100403, "android/media/AudioRecord", "release", r110, r101, "void", r111).f474982a == false) goto L6;
        r100.a(100403, "android/media/AudioRecord", "release", r110, r101, null, r111, false);
        return;
    L6:
        r110.release();
        r100.a(100403, "android/media/AudioRecord", "release", r110, r101, null, r111, true);
    }

    public static void o(AudioRecord r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        if (r100.b(100400, "android/media/AudioRecord", "startRecording", r110, r101, "void", r111).f474982a == false) goto L6;
        r100.a(100400, "android/media/AudioRecord", "startRecording", r110, r101, null, r111, false);
        return;
    L6:
        r110.startRecording();
        r100.a(100400, "android/media/AudioRecord", "startRecording", r110, r101, null, r111, true);
    }

    public static void p(AudioRecord r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        if (r100.b(100401, "android/media/AudioRecord", "stop", r110, r101, "void", r111).f474982a == false) goto L6;
        r100.a(100401, "android/media/AudioRecord", "stop", r110, r101, null, r111, false);
        return;
    L6:
        r110.stop();
        r100.a(100401, "android/media/AudioRecord", "stop", r110, r101, null, r111, true);
    }

    @Override // r58.c
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
    }

    @Override // r58.c
    public final long d(long r100) {
        v58.a r101 = this.f527816d;     // Catch: Throwable -> L12
        if (r101 != null) goto L7;
        return 0;
    L7:
        if (r101.f553276b != 16) goto L9;
        int r102 = 1;
    L10:
        return (((long) 1000) * (r100 / ((long) (r101.f553277c * r102)))) / ((long) r101.f553275a);
    L9:
        r102 = 2;
    L12:
        th = move-exception;
        int r103 = c68.b.f22600a;
        c68.b.b(this.f527814b, "calculateAudioDuration msg=" + th.getMessage());
        return 0;
    }

    @Override // r58.c
    public final void h(v58.a r100) {
        Intrinsics.checkNotNullParameter(r100, "audioRecordConfig");
        this.f527816d = r100;
    }

    @Override // r58.c
    public final void k(Function2<? super r58.d, ? super byte[], Unit> r110) {
        Intrinsics.checkNotNullParameter(r110, "onAudioDataReceived");
        int r100 = c() * ((Number) this.f527820h.getValue()).intValue();
        if (r100 > 0) goto L6;
        int r111 = c68.b.f22600a;
        c68.b.b(this.f527814b, "audio recorder startLoop fail: size " + r100 + " is under zero");
        return;
    L6:
        byte[] r101 = new byte[r100];
        AudioTimestamp r102 = new AudioTimestamp();
        long r103 = 0;
    L8:
        if (ThreadMethodProxy.currentThread().isInterrupted() == true) goto L76;
        if (this.f527815c == true) goto L77;
        if (this.f527818f == AudioRecordState.STARTED) goto L21;
        Thread.sleep(100);     // Catch: Exception -> L16 InterruptedException -> L18
    L33:
        if (((Boolean) this.f527819g.getValue()).booleanValue() == false) goto L58;
        int r104 = Build.VERSION.SDK_INT;
        if (r104 < 23) goto L58;
        if (r104 >= 24) goto L65;
        Long r105 = Long.valueOf(SystemClock.elapsedRealtimeNanos());
    L46:
        Intrinsics.checkNotNullParameter(r101, "buffer");
        AudioRecord r106 = this.f527817e;
        int r107 = -1;
        if (r106 != null) goto L49;
    L59:
        long r108 = System.currentTimeMillis();
        int r112 = c68.b.f22600a;
        c68.b.d(this.f527814b, "readSize: " + r107);
        if (r107 <= 0) goto L63;
        r110.invoke(new r58.d(r107, Arrays.copyOf(r101, r107), r105), null);
    L63:
        r103 = r108;
        goto L8
    L49:
        if (r106.getState() != 0) goto L51;
        boolean r109 = true;
    L52:
        if (r109 == true) goto L59;
        AudioRecord r113 = this.f527817e;
        if (r113 == null) goto L57;
        r107 = r113.read(r101, 0, r100, 1);
    L57:
        Intrinsics.checkNotNullParameter(r101, "data");
        goto L59
    L51:
        r109 = false;
        goto L52
    L65:
        AudioRecord r114 = this.f527817e;     // Catch: Exception -> L43
        if (r114 == null) goto L41;
        r114.getTimestamp(r102, 1);     // Catch: Exception -> L43
    L41:
        r105 = Long.valueOf(r102.nanoTime);     // Catch: Exception -> L43
    L43:
        e = move-exception;
        int r115 = c68.b.f22600a;
        c68.b.c(this.f527814b, "getTimestampException", e);
        r105 = Long.valueOf(SystemClock.elapsedRealtimeNanos());
    L58:
        r107 = i(r101, r100);
        r105 = null;
    L18:
        e = move-exception;
        int r116 = c68.b.f22600a;
        c68.b.c(this.f527814b, "interruptException1.", e);
        return;
    L16:
        e = move-exception;
        int r117 = c68.b.f22600a;
        c68.b.c(this.f527814b, "1 on err. msg=" + e.getMessage(), e);
        goto L33
    L21:
        if (r103 <= 0) goto L33;
        if (((Boolean) this.f527819g.getValue()).booleanValue() == false) goto L33;
        long r118 = q() - (System.currentTimeMillis() - r103);     // Catch: Exception -> L28 InterruptedException -> L30
        if (r118 <= 0) goto L33;
        Thread.sleep(r118);     // Catch: Exception -> L28 InterruptedException -> L30
    L30:
        e = move-exception;
        int r119 = c68.b.f22600a;
        c68.b.c(this.f527814b, "interruptException2", e);
        return;
    L28:
        e = move-exception;
        int r120 = c68.b.f22600a;
        c68.b.c(this.f527814b, "2 on err. msg=" + e.getMessage(), e);
        goto L33
    L77:
        return;
    }

    public final void m(v58.a r100) {
        this.f527813a = AudioRecord.getMinBufferSize(r100.f553275a, r100.f553276b, r100.f553277c);
        int r101 = c68.b.f22600a;
        c68.b.d(this.f527814b, "assignMinBufferSize => minBufferSize:" + this.f527813a);
    }

    public final void r(AudioRecordErrorEnum r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        int r101 = c68.b.f22600a;
        c68.b.a(this.f527814b, "onFailed error:" + r100);
        s(AudioRecordState.STOPPED);
    }

    public final void s(AudioRecordState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        int r101 = c68.b.f22600a;
        c68.b.d(this.f527814b, "onStateChange state:" + r100);
        this.f527818f = r100;
    }

    @Override // r58.c
    public final int i(byte[] r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "buffer");
        AudioRecord r102 = this.f527817e;
        int r103 = -1;
        if (r102 != null) goto L5;
    L14:
        return r103;
    L5:
        if (r102.getState() != 0) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == true) goto L14;
        AudioRecord r105 = this.f527817e;
        if (r105 == null) goto L13;
        r103 = r105.read(r100, 0, r101);
    L13:
        Intrinsics.checkNotNullParameter(r100, "data");
        goto L14
    L7:
        r104 = false;
        goto L8
    }
}
