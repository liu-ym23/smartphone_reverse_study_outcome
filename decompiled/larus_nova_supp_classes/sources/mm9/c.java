package mm9;

import android.os.SystemClock;
import com.larus.utils.logger.FLogger;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class c implements g09.a {
    public Pair<Long, Long> a;

    public static final class a {
    }

    static {
    }

    public c() {
    }

    @Override // g09.a
    public final long currentTimeMillis() {
        Pair<Long, Long> r0 = this.a;
        if (r0 == null) goto L5;
        long r1 = r0.getFirst().longValue();
    L7:
        if (r1 < 10000) goto L9;
        Pair<Long, Long> r2 = this.a;
        if (r2 == null) goto L14;
        return (SystemClock.elapsedRealtime() - r2.getFirst().longValue()) + r2.getSecond().longValue();
    L14:
        return System.currentTimeMillis();
    L9:
        return System.currentTimeMillis();
    L5:
        r1 = 0;
        goto L7
    }

    @Override // g09.a
    public final void d(long r4) {
        if (r4 != 0) goto L6;
        return;
    L6:
        if (this.a != null) goto L9;
        FLogger.a.i("AppClockImpl", "updateTimestamp, timestampMillis:" + r4);
        this.a = TuplesKt.to(Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(r4));
        Unit r5 = Unit.INSTANCE;
        return;
    }
}
