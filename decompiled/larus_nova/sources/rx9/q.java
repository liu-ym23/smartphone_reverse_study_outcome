package rx9;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f539873a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<String, List<k>> f539874b = null;

    static {
        f539873a = LazyKt.lazy(new l());
        f539874b = new HashMap();
    }

    public static void a(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "command");
        ((ThreadPoolExecutor) f539873a.getValue()).submit(r100);
    }
}
