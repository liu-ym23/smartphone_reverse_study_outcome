package rx9;

import com.bytedance.keva.Keva;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes4.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f539856a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f539857b = null;

    static {
        f539856a = LazyKt.lazy(new h());
        f539857b = LazyKt.lazy(new i());
    }

    public static Keva a() {
        return (Keva) f539856a.getValue();
    }

    public static String b(String r100) {
        return r100 + "_total_millis";
    }
}
