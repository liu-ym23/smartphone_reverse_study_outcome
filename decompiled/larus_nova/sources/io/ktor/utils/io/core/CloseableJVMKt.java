package io.ktor.utils.io.core;

import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class CloseableJVMKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f492018a = null;

    static {
        f492018a = LazyKt.lazy(CloseableJVMKt$AddSuppressedMethod$2.INSTANCE);
    }

    public static final void a(Throwable r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "other");
        Method r102 = (Method) f492018a.getValue();
        if (r102 == null) goto L6;
        r102.invoke(r100, new Object[]{r101});
        return;
    }
}
