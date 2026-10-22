package kj9;

import com.larus.livetutor.impl.rtc.l0;
import com.larus.livetutor.impl.utils.track.LiveTutorTrackerService;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f503724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f503725b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, l0> f503726c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static LiveTutorTrackerService f503727d;

    static {
        f503725b = LazyKt.lazy(new a());
        f503726c = new LinkedHashMap();
    }

    public static LiveTutorTrackerService c() {
        if (f503727d != null) goto L6;
        f503727d = new LiveTutorTrackerService();
    L6:
        return f503727d;
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "log");
        mj9.a r101 = (mj9.a) f503725b.getValue();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "log");
        FLogger.f375446a.d(r101.f514262a, r100);
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "log");
        mj9.a r101 = (mj9.a) f503725b.getValue();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "log");
        FLogger.f375446a.e(r101.f514262a, r100);
    }

    public static void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "log");
        mj9.a r101 = (mj9.a) f503725b.getValue();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "log");
        FLogger.f375446a.i(r101.f514262a, r100);
    }
}
