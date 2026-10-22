package l8;

import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.android.annie.monitor.common.timing.PerformanceTiming;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, PerformanceTiming> f507905a = null;

    static {
        f507905a = new ConcurrentHashMap();
    }

    public static PerformanceTiming a(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        PerformanceTiming r102 = f507905a.get(r100);     // Catch: Throwable -> L7
        if (r102 == null) goto L5;
        return r102;
    L5:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        PerformanceTiming r103 = new PerformanceTiming();
        f507905a.put(r100, r103);
        return r103;
    L7:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    public static void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, ST.UUID_DEVICE);
        Intrinsics.checkNotNullParameter(r101, "stageName");
        long r102 = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r100, ST.UUID_DEVICE);
        Intrinsics.checkNotNullParameter(r101, "stageName");
        Long r103 = Long.valueOf(r102);
        a(r100).put(r101, r103);
    }

    public static void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, ST.UUID_DEVICE);
        Intrinsics.checkNotNullParameter(r101, "bizKey");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        PerformanceTiming r103 = f507905a.get(r100);     // Catch: Throwable -> L8
        if (r103 != null) goto L6;
        return;
    L6:
        Schedulers.computation().scheduleDirect(new a(r103, r101));     // Catch: Throwable -> L8
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
