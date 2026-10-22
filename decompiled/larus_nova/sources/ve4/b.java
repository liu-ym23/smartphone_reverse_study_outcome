package ve4;

import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final <T extends ICJService> T a(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        a.f554342a.getClass();
        return (T) a.a(r100);
    }

    public static final <T extends ICJService> T b(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        a.f554342a.getClass();
        Intrinsics.checkNotNullParameter(r100, "clazz");
        return (T) a.c(r100);
    }
}
