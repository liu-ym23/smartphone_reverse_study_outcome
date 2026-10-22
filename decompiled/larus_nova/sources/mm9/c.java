package mm9;

import android.os.SystemClock;
import com.larus.utils.logger.FLogger;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes.dex */
public final class c implements g09.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Pair<Long, Long> f514500a;

    public static final class a {
    }

    static {
    }

    public c() {
    }

    @Override // g09.a
    public final long currentTimeMillis() {
        Pair<Long, Long> r100 = this.f514500a;
        if (r100 == null) goto L5;
        long r101 = r100.getFirst().longValue();
    L7:
        if (r101 < 10000) goto L9;
        Pair<Long, Long> r102 = this.f514500a;
        if (r102 == null) goto L14;
        return (SystemClock.elapsedRealtime() - r102.getFirst().longValue()) + r102.getSecond().longValue();
    L14:
        return System.currentTimeMillis();
    L9:
        return System.currentTimeMillis();
    L5:
        r101 = 0;
        goto L7
    }

    @Override // g09.a
    public final void d(long r100) {
        if (r100 != 0) goto L6;
        return;
    L6:
        if (this.f514500a != null) goto L9;
        FLogger.f375446a.i("AppClockImpl", "updateTimestamp, timestampMillis:" + r100);
        this.f514500a = TuplesKt.to(Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(r100));
        Unit r101 = Unit.INSTANCE;
        return;
    }
}
