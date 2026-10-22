package p58;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import com.bytedance.android.livesdk.message.model.vf;
import com.bytedance.keva.Keva;
import com.larus.audio.audiov3.audio.record.AudioRecordErrorEnum;
import com.larus.audio.audiov3.audio.record.AudioRecordState;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import fna.g;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import m58.h;

/* JADX INFO: loaded from: classes24.dex */
public final class e implements r58.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f527821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f527822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f527823c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f527824d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f527825e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function2<? super Boolean, ? super String, Unit> f527826f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f527827g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AudioRecord f527828h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AudioRecordState f527829i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f527830j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f527831k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f527832l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f527833m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f527834n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AudioManager f527835o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f527836p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile long f527837q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile long f527838r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile String f527839s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public volatile Function2<? super String, ? super Long, Unit> f527840t;

    public static final class a {
    }

    static {
    }

    @Override // r58.c
    public final void e(Function0<Unit> r100) {
    }

    @Override // r58.c
    public final void h(v58.a r100) {
        Intrinsics.checkNotNullParameter(r100, "audioRecordConfig");
    }

    @Override // r58.c
    public final void j() {
        this.f527825e = true;
    }

    @Override // r58.c
    public final int c() {
        int r100 = this.f527821a;
        if (r100 == (-1)) goto L5;
        return r100;
    L5:
        m();
        return this.f527821a;
    }

    public final void m() {
        this.f527821a = (((this.f527831k / 1000) * this.f527830j) * this.f527832l) * 40;
        int r100 = c68.b.f22600a;
        c68.b.d("BackTraceAudioRecorder", "assignMinBufferSize => minBufferSize:" + this.f527821a);
    }

    @Override // r58.c
    public final void prepare() {
        if (this.f527824d == false) goto L5;
    L67:
        int r100 = c68.b.f22600a;
        c68.b.e("BackTraceAudioRecorder", "prepare ignored: releaseRequested=" + this.f527824d + ", isReleased=" + this.f527827g);
        return;
    L5:
        if (this.f527827g == true) goto L67;
        Field r101 = AudioFormat.class.getDeclaredField("CHANNEL_IN_2POINT0POINT2");
        boolean r102 = true;
        r101.setAccessible(true);
        Object r103 = r101.get(null);
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.Int");
        v58.a r104 = new v58.a(this.f527831k, ((Integer) r103).intValue(), this.f527830j, this.f527833m);
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L51
        if (this.f527821a != (-1)) goto L11;
        m();     // Catch: Throwable -> L51
    L11:
        int r106 = c68.b.f22600a;     // Catch: Throwable -> L51
        c68.b.d("BackTraceAudioRecorder", "start => minBufferSize:" + this.f527821a);     // Catch: Throwable -> L51
        Object r107 = this.f527823c;     // Catch: Throwable -> L51
        monitor-enter(r107);     // Catch: Throwable -> L51
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L48
        monitor-exit(r107);     // Catch: Throwable -> L51
        AudioRecord.Builder r109 = new AudioRecord.Builder();     // Catch: Throwable -> L51
        AudioRecord.Builder.class.getDeclaredMethod("setRequestBacktraceStream", new Class[]{Boolean.TYPE}).invoke(r109, new Object[]{Boolean.TRUE});     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23 Throwable -> L51
    L25:
        AudioRecord r110 = r109.setAudioFormat(new AudioFormat.Builder().setEncoding(r104.f553277c).setSampleRate(r104.f553275a).setChannelMask(r104.f553276b).build()).setAudioSource(r104.f553278d).setBufferSizeInBytes(this.f527834n).build();     // Catch: Throwable -> L51
        Object r111 = this.f527823c;     // Catch: Throwable -> L51
        monitor-enter(r111);     // Catch: Throwable -> L51
    L45:
        th = move-exception;
        throw th;     // Catch: Throwable -> L51
    L28:
        if (this.f527824d == false) goto L30;
    L33:
        if (r102 == true) goto L35;
        this.f527828h = r110;     // Catch: Throwable -> L45
    L35:
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L45
        monitor-exit(r111);     // Catch: Throwable -> L51
        if (r102 == true) goto L76;
        Object r113 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L51
    L54:
        if (Result.m9456isSuccessimpl(r113) == false) goto L56;
        Unit r114 = (Unit) r113;
        c68.b.d("BackTraceAudioRecorder", "prepare => success");
        r(AudioRecordState.INITIALIZED);
    L56:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r113);
        if (r115 == null) goto L66;
        Object r116 = this.f527823c;
        monitor-enter(r116);
        Unit r117 = Unit.INSTANCE;     // Catch: Throwable -> L63
        monitor-exit(r116);
        c68.b.c("BackTraceAudioRecorder", "prepare => fail", r115);
        q(AudioRecordErrorEnum.PREPARE_ERROR);
        return;
    L63:
        th = move-exception;
        throw th;
    L66:
        return;
    L76:
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L40
        n(r110);     // Catch: Throwable -> L40
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L40
    L42:
        r(AudioRecordState.UNINITIALIZED);     // Catch: Throwable -> L51
        return;
    L40:
        th = move-exception;
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L51
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L51
        goto L42
    L30:
        if (this.f527827g == true) goto L33;
        r102 = false;
        goto L33
    L21:
        e = move-exception;
        int r120 = c68.b.f22600a;     // Catch: Throwable -> L51
        c68.b.e("BackTraceAudioRecorder", e.toString());     // Catch: Throwable -> L51
    L23:
        e = move-exception;
        int r121 = c68.b.f22600a;     // Catch: Throwable -> L51
        c68.b.e("BackTraceAudioRecorder", e.toString());     // Catch: Throwable -> L51
    L19:
        e = move-exception;
        int r122 = c68.b.f22600a;     // Catch: Throwable -> L51
        c68.b.e("BackTraceAudioRecorder", e.toString());     // Catch: Throwable -> L51
        goto L25
    L48:
        th = move-exception;
        throw th;     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L54
    }

    @Override // r58.c
    public final void release() {
        Object r100 = this.f527823c;
        monitor-enter(r100);
        this.f527824d = true;     // Catch: Throwable -> L28
        this.f527827g = true;     // Catch: Throwable -> L28
        AudioRecord r101 = this.f527828h;     // Catch: Throwable -> L28
        this.f527828h = null;     // Catch: Throwable -> L28
        monitor-exit(r100);
        if (r101 != null) goto L9;
    L26:
        r(AudioRecordState.UNINITIALIZED);
        return;
    L9:
        if (r101.getState() == 0) goto L26;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L13
        n(r101);     // Catch: Throwable -> L13
        r(AudioRecordState.UNINITIALIZED);     // Catch: Throwable -> L13
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L16:
        if (Result.m9456isSuccessimpl(r103) == false) goto L22;
        Unit r104 = (Unit) r103;
        Lazy r105 = r58.b.f536319a;
        long r106 = System.currentTimeMillis();
        if (r106 <= 0) goto L21;
        ((Keva) r58.b.f536319a.getValue()).storeLong("last_backtrace_recorder_release_time_ms", r106);
    L21:
        c68.b.d("BackTraceAudioRecorder", "release => success");
    L22:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r103);
        if (r107 == null) goto L35;
        c68.b.c("BackTraceAudioRecorder", "release => fail", r107);
        q(AudioRecordErrorEnum.RELEASE_ERROR);
        return;
    L35:
        return;
    L13:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L28:
        th = move-exception;
        throw th;
    }

    public final void s() {
        if (this.f527825e == false) goto L5;
        return;
    L5:
        long r100 = System.currentTimeMillis();
        long r101 = 0;
        if (this.f527837q <= 0) goto L8;
        long r102 = this.f527837q;
    L9:
        boolean r103 = false;
        Unit r110 = null;
        if (this.f527838r <= 0) goto L22;
        Long r104 = Long.valueOf(r100 - this.f527838r);
        long r105 = r104.longValue();
        if (1 <= r105) goto L14;
    L16:
        boolean r106 = false;
    L17:
        if (r106 == true) goto L20;
        r104 = null;
    L20:
        if (r104 == null) goto L22;
        r101 = r104.longValue();
        goto L22
    L14:
        if (r105 >= vf.CNY_A_2) goto L16;
        r106 = true;
    L22:
        long r107 = r102 + r101;
        int r108 = c68.b.f22600a;
        c68.b.d("BackTraceAudioRecorder", "setBackTraceTime, backTraceTimeMs: " + r102 + ", timeOfIPC: " + r101 + ", realBackTrace: " + r107);
        AudioManager r109 = this.f527835o;
        if (r109 == null) goto L25;
        r109.setParameters("backtrace_history_length=" + r107);
    L25:
        String r111 = this.f527839s;
        if (r111.length() <= 0) goto L28;
        r103 = true;
    L28:
        if (r103 == false) goto L39;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L34
        Function2<? super String, ? super Long, Unit> r113 = this.f527840t;     // Catch: Throwable -> L34
        if (r113 == null) goto L32;
        r113.invoke(r111, Long.valueOf(r107));     // Catch: Throwable -> L34
        r110 = Unit.INSTANCE;     // Catch: Throwable -> L34
    L32:
        Result.m9449constructorimpl(r110);     // Catch: Throwable -> L34
        return;
    L34:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L39:
        return;
    L8:
        r102 = 50;
        goto L9
    }

    @Override // r58.c
    public final void start() {
        if (this.f527824d == false) goto L5;
    L104:
        int r100 = c68.b.f22600a;
        c68.b.e("BackTraceAudioRecorder", "start ignored: releaseRequested=" + this.f527824d + ", isReleased=" + this.f527827g);
        q(AudioRecordErrorEnum.START_ERROR);
        Function2<? super Boolean, ? super String, Unit> r101 = this.f527826f;
        if (r101 == null) goto L125;
        r101.invoke(Boolean.FALSE, "isReleased");
        return;
    L125:
        return;
    L5:
        if (this.f527827g == true) goto L104;
        Object r102 = this.f527823c;
        monitor-enter(r102);
        AudioRecord r103 = this.f527828h;     // Catch: Throwable -> L101
        monitor-exit(r102);
        boolean r104 = true;
        if (r103 != null) goto L14;
    L26:
        Field r105 = AudioFormat.class.getDeclaredField("CHANNEL_IN_2POINT0POINT2");
        r105.setAccessible(true);
        Object r106 = r105.get(null);
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type kotlin.Int");
        v58.a r107 = new v58.a(this.f527831k, ((Integer) r106).intValue(), this.f527830j, this.f527833m);
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L81
        if (this.f527821a != (-1)) goto L30;
        m();     // Catch: Throwable -> L81
    L30:
        int r109 = c68.b.f22600a;     // Catch: Throwable -> L81
        c68.b.d("BackTraceAudioRecorder", "start => minBufferSize:" + this.f527821a);     // Catch: Throwable -> L81
        Object r110 = this.f527823c;     // Catch: Throwable -> L81
        monitor-enter(r110);     // Catch: Throwable -> L81
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L78
        monitor-exit(r110);     // Catch: Throwable -> L81
        AudioRecord.Builder r112 = new AudioRecord.Builder();     // Catch: Throwable -> L81
        AudioRecord.Builder.class.getDeclaredMethod("setRequestBacktraceStream", new Class[]{Boolean.TYPE}).invoke(r112, new Object[]{Boolean.TRUE});     // Catch: InvocationTargetException -> L40 IllegalAccessException -> L42 NoSuchMethodException -> L44 Throwable -> L81
        if (this.f527822b == (-1)) goto L46;
        AudioRecord.Builder.class.getDeclaredMethod("setSessionId", new Class[]{Integer.TYPE}).invoke(r112, new Object[]{Integer.valueOf(this.f527822b)});     // Catch: InvocationTargetException -> L40 IllegalAccessException -> L42 NoSuchMethodException -> L44 Throwable -> L81
    L46:
        AudioRecord r113 = r112.setAudioFormat(new AudioFormat.Builder().setEncoding(r107.f553277c).setSampleRate(r107.f553275a).setChannelMask(r107.f553276b).build()).setAudioSource(r107.f553278d).setBufferSizeInBytes(this.f527834n).build();     // Catch: Throwable -> L81
        Object r114 = this.f527823c;     // Catch: Throwable -> L81
        monitor-enter(r114);     // Catch: Throwable -> L81
    L75:
        th = move-exception;
        throw th;     // Catch: Throwable -> L81
    L49:
        if (this.f527824d == false) goto L51;
    L54:
        if (r104 == true) goto L56;
        this.f527828h = r113;     // Catch: Throwable -> L75
    L56:
        Unit r115 = Unit.INSTANCE;     // Catch: Throwable -> L75
        monitor-exit(r114);     // Catch: Throwable -> L81
        if (r104 == true) goto L117;
        c68.b.d("BackTraceAudioRecorder", "start => set sessionId: " + this.f527822b + ", new record sessionId: " + r113.getAudioSessionId());     // Catch: Throwable -> L81
        r(AudioRecordState.INITIALIZED);     // Catch: Throwable -> L81
        if (this.f527822b != (-1)) goto L71;
        s();     // Catch: Throwable -> L81
    L71:
        if (g.d() == true) goto L73;
        o(r113);     // Catch: Throwable -> L81
    L74:
        Object r116 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L81
    L84:
        if (Result.m9456isSuccessimpl(r116) == false) goto L88;
        Unit r117 = (Unit) r116;
        c68.b.d("BackTraceAudioRecorder", "start => success");
        r(AudioRecordState.STARTED);
        Function2<? super Boolean, ? super String, Unit> r118 = this.f527826f;
        if (r118 == null) goto L88;
        r118.invoke(Boolean.TRUE, "");
    L88:
        Throwable r119 = Result.m9452exceptionOrNullimpl(r116);
        if (r119 == null) goto L100;
        Object r120 = this.f527823c;
        monitor-enter(r120);
        Unit r121 = Unit.INSTANCE;     // Catch: Throwable -> L97
        monitor-exit(r120);
        c68.b.c("BackTraceAudioRecorder", "start => fail", r119);
        q(AudioRecordErrorEnum.START_ERROR);
        Function2<? super Boolean, ? super String, Unit> r122 = this.f527826f;
        if (r122 == null) goto L123;
        r122.invoke(Boolean.FALSE, "start fail");
        return;
    L123:
        return;
    L97:
        th = move-exception;
        throw th;
    L100:
        return;
    L73:
        o(r113);     // Catch: Throwable -> L81
        hna.a.b(r113.hashCode());     // Catch: Throwable -> L81
        goto L74
    L117:
        Result.Companion r123 = Result.Companion;     // Catch: Throwable -> L61
        n(r113);     // Catch: Throwable -> L61
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L61
    L63:
        r(AudioRecordState.UNINITIALIZED);     // Catch: Throwable -> L81
        Function2<? super Boolean, ? super String, Unit> r124 = this.f527826f;     // Catch: Throwable -> L81
        if (r124 == null) goto L122;
        r124.invoke(Boolean.FALSE, "releaseImmediately");     // Catch: Throwable -> L81
        return;
    L122:
        return;
    L61:
        th = move-exception;
        Result.Companion r125 = Result.Companion;     // Catch: Throwable -> L81
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L81
        goto L63
    L51:
        if (this.f527827g == true) goto L54;
        r104 = false;
    L40:
        e = move-exception;
        int r126 = c68.b.f22600a;     // Catch: Throwable -> L81
        c68.b.e("BackTraceAudioRecorder", e.toString());     // Catch: Throwable -> L81
    L42:
        e = move-exception;
        int r127 = c68.b.f22600a;     // Catch: Throwable -> L81
        c68.b.e("BackTraceAudioRecorder", e.toString());     // Catch: Throwable -> L81
    L44:
        e = move-exception;
        int r128 = c68.b.f22600a;     // Catch: Throwable -> L81
        c68.b.e("BackTraceAudioRecorder", e.toString());     // Catch: Throwable -> L81
        goto L46
    L78:
        th = move-exception;
        throw th;     // Catch: Throwable -> L81
    L81:
        th = move-exception;
        Result.Companion r129 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L84
    L14:
        if (r103.getState() != 1) goto L26;
        c68.b.d("BackTraceAudioRecorder", "start => success");
        if (this.f527822b != (-1)) goto L19;
        s();
    L19:
        if (g.d() == true) goto L21;
        o(r103);
    L22:
        r(AudioRecordState.STARTED);
        Function2<? super Boolean, ? super String, Unit> r130 = this.f527826f;
        if (r130 == null) goto L121;
        r130.invoke(Boolean.TRUE, "");
        return;
    L121:
        return;
    L21:
        o(r103);
        hna.a.b(r103.hashCode());
    L101:
        th = move-exception;
        throw th;
    }

    @Override // r58.c
    public final void stop() {
        Object r100 = this.f527823c;
        monitor-enter(r100);
        AudioRecord r101 = this.f527828h;     // Catch: Throwable -> L27
        monitor-exit(r100);
        if (r101 != null) goto L8;
    L25:
        r(AudioRecordState.STOPPED);
        return;
    L8:
        if (r101.getState() == 0) goto L25;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L16
        if (g.d() == true) goto L13;
        p(r101);     // Catch: Throwable -> L16
    L14:
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L19:
        if (Result.m9456isSuccessimpl(r103) == false) goto L21;
        Unit r104 = (Unit) r103;
        c68.b.d("BackTraceAudioRecorder", "stop => success");
        r(AudioRecordState.STOPPED);
    L21:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r103);
        if (r105 == null) goto L34;
        c68.b.c("BackTraceAudioRecorder", "stop => fail", r105);
        q(AudioRecordErrorEnum.UNKNOWN_ERROR);
        return;
    L34:
        return;
    L13:
        p(r101);     // Catch: Throwable -> L16
        hna.a.c(r101.hashCode());     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L27:
        th = move-exception;
        throw th;
    }

    @Override // r58.c
    public final AudioRecordState l() {
        return this.f527829i;
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
        this.f527839s = r100;
    }

    @Override // r58.c
    public final long d(long r100) {
        return ((r100 / ((long) (this.f527830j * this.f527832l))) * ((long) 1000)) / ((long) this.f527831k);
    L4:
        th = move-exception;
        int r101 = c68.b.f22600a;
        c68.b.b("BackTraceAudioRecorder", "calculateAudioDuration msg=" + th.getMessage());
        return 0;
    }

    @Override // r58.c
    public final void f(Function2<? super String, ? super Long, Unit> r100) {
        this.f527840t = r100;
    }

    @Override // r58.c
    public final void g(Function2<? super Boolean, ? super String, Unit> r100) {
        x58.a r101 = h.f512130a;
        m58.b r102 = h.f512140k;
        boolean r103 = false;
        if (r102 != null) goto L5;
    L7:
        if (r103 == false) goto L10;
        this.f527826f = r100;
        return;
    L10:
        return;
    L5:
        if (r102.a() != true) goto L7;
        r103 = true;
        goto L7
    }

    @Override // r58.c
    public final void k(Function2<? super r58.d, ? super byte[], Unit> r110) {
        Intrinsics.checkNotNullParameter(r110, "onAudioDataReceived");
        int r100 = c() * this.f527836p;
        if (r100 > 0) goto L8;
        int r111 = c68.b.f22600a;
        c68.b.b("BackTraceAudioRecorder", "audio recorder startLoop fail: size " + r100 + " is under zero");
        Function2<? super Boolean, ? super String, Unit> r112 = this.f527826f;
        if (r112 == null) goto L42;
        r112.invoke(Boolean.FALSE, "startLoop fail: size " + r100 + " is under zero");
        return;
    L42:
        return;
    L8:
        byte[] r101 = new byte[r100];
    L10:
        if (ThreadMethodProxy.currentThread().isInterrupted() == true) goto L43;
        if (this.f527827g == true) goto L44;
        if (this.f527829i != AudioRecordState.STARTED) goto L34;
    L22:
        int r102 = i(r101, r100);
        int r103 = c68.b.f22600a;
        c68.b.d("BackTraceAudioRecorder", "readSize: " + r102);
        if (r102 < 0) goto L25;
    L30:
        if (r102 <= 0) goto L10;
        r110.invoke(new r58.d(r102, Arrays.copyOf(r101, r102), null), null);
        goto L10
    L25:
        if (this.f527829i != AudioRecordState.STARTED) goto L30;
        Function2<? super Boolean, ? super String, Unit> r104 = this.f527826f;
        if (r104 == null) goto L29;
        r104.invoke(Boolean.FALSE, "startLoop:readSize < 0， " + r102);
    L29:
        this.f527826f = null;
        goto L30
    L34:
        Thread.sleep(100);     // Catch: Exception -> L18 InterruptedException -> L20
    L20:
        e = move-exception;
        int r105 = c68.b.f22600a;
        c68.b.c("BackTraceAudioRecorder", "interruptException1.", e);
        return;
    L18:
        e = move-exception;
        int r106 = c68.b.f22600a;
        c68.b.c("BackTraceAudioRecorder", "1 on err. msg=" + e.getMessage(), e);
        goto L22
    L44:
        return;
    }

    public final void q(AudioRecordErrorEnum r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        int r101 = c68.b.f22600a;
        c68.b.d("BackTraceAudioRecorder", "onFailed error:" + r100);
        r(AudioRecordState.STOPPED);
    }

    public final void r(AudioRecordState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        int r101 = c68.b.f22600a;
        c68.b.d("BackTraceAudioRecorder", "onStateChange state:" + r100);
        this.f527829i = r100;
    }

    @Override // r58.c
    public final void b(long r100, long r101) {
        this.f527837q = r100;
        this.f527838r = r101;
        int r102 = c68.b.f22600a;
        c68.b.d("BackTraceAudioRecorder", "setBackTraceParams historyLengthMs: " + r100 + ", wakeupTime: " + r101 + ", sessionId: " + this.f527822b);
    }

    @Override // r58.c
    public final int i(byte[] r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "buffer");
        AudioRecord r102 = this.f527828h;
        int r103 = -1;
        if (r102 != null) goto L5;
    L14:
        return r103;
    L5:
        if (r102.getState() != 0) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == true) goto L14;
        AudioRecord r105 = this.f527828h;
        if (r105 == null) goto L13;
        r103 = r105.read(r100, 0, r101);
    L13:
        Intrinsics.checkNotNullParameter(r100, "data");
        goto L14
    L7:
        r104 = false;
        goto L8
    }

    public e(Context r100, int r101, int r102) {
        this.f527821a = r101;
        this.f527822b = r102;
        this.f527823c = new Object();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
        Object r104 = Result.m9449constructorimpl(new SimpleDateFormat("yyyyMMdd_HHmmss_SSS", Locale.US).format(new Date()));     // Catch: Throwable -> L5
    L8:
        if (Result.m9452exceptionOrNullimpl(r104) == null) goto L11;
        r104 = String.valueOf(System.currentTimeMillis());
    L11:
        String r105 = (String) r104;
        this.f527829i = AudioRecordState.UNINITIALIZED;
        this.f527830j = 2;
        this.f527831k = 16000;
        this.f527832l = 4;
        this.f527833m = 6;
        this.f527834n = 640000;
        AudioManager r106 = null;
        if (r100 == null) goto L16;
        Context r107 = r100.getApplicationContext();
        if (r107 == null) goto L16;
        Object r108 = r107.getSystemService("audio");
    L18:
        if ((r108 instanceof AudioManager) == false) goto L20;
        r106 = (AudioManager) r108;
    L20:
        this.f527835o = r106;
        this.f527836p = 4;
        this.f527837q = 50;
        this.f527839s = "";
        return;
    L16:
        r108 = null;
    L5:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
