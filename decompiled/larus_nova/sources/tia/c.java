package tia;

import com.bytedance.keva.Keva;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes33.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f546283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f546284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f546285c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public r58.c f546286d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PthreadThreadV2 f546287e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile long f546288f;

    public static final class a {
    }

    static {
    }

    public final void a() {
        this.f546285c.set(false);
        PthreadThreadV2 r100 = this.f546287e;
        if (r100 == null) goto L26;
        r100.interrupt();
    L26:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L12
        r58.c r102 = this.f546286d;     // Catch: Throwable -> L12
        if (r102 == null) goto L9;
        r102.stop();     // Catch: Throwable -> L12
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L12
    L10:
        Result.m9449constructorimpl(r103);     // Catch: Throwable -> L12
    L24:
        r58.c r104 = this.f546286d;     // Catch: Throwable -> L20
        if (r104 == null) goto L17;
        r104.release();     // Catch: Throwable -> L20
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L20
    L18:
        Result.m9449constructorimpl(r105);     // Catch: Throwable -> L20
    L22:
        this.f546286d = null;
        this.f546288f = 0;
        return;
    L17:
        r105 = null;
    L20:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L22
    L9:
        r103 = null;
    L12:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L24
    }

    public c(f r100, o r101) {
        Intrinsics.checkNotNullParameter(r100, "ringBuffer");
        Intrinsics.checkNotNullParameter(r101, "onFinish");
        this.f546283a = r100;
        this.f546284b = r101;
        this.f546285c = new AtomicBoolean(false);
    }

    public static long b(long r110, int r111) {
        long r100 = System.currentTimeMillis();
        long r101 = ((Keva) r58.b.f536319a.getValue()).getLong("last_backtrace_recorder_release_time_ms", 0);
        long r102 = 4800;
        if (r101 > 0) goto L5;
    L8:
        long r103 = r110 - r102;
        FLogger.f375446a.i("WakeupCaptureProducer", "producer first read producerStartMs=" + r110 + " firstReadMs=" + r100 + " firstReadSize=" + r111 + " cacheMs=" + r102 + " lastReleaseMs=" + r101 + " audioStartMs=" + r103);
        return r103;
    L5:
        if (r101 >= r110) goto L8;
        r102 = RangesKt.coerceAtMost(r110 - r101, 4800);
        goto L8
    }
}
