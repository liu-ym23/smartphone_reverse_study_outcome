package pd6;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f528682a;

    static {
        f528682a = d.f528683a;
    }

    public static a a(KClass r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        return f528682a.a(r100);
    }

    public static List b(KClass r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        return f528682a.b(r100);
    }

    public static void c(KClass r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "impl");
        f528682a.c(r100, r101);
    }
}
