package pia;

import com.bytedance.keva.Keva;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f529407a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f529408b = null;

    public b() {
    }

    static {
        f529407a = new b();
        f529408b = LazyKt.lazy(new a());
    }

    public static Keva a() {
        return (Keva) f529408b.getValue();
    }

    public static String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter("", "defValue");
        return a().getString(r100, "");
    }

    public static void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        a().erase(r100);
    }

    public static void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        a().storeString(r100, r101);
    }
}
