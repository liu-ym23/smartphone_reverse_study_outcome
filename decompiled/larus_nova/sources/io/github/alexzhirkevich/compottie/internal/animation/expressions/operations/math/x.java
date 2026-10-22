package io.github.alexzhirkevich.compottie.internal.animation.expressions.operations.math;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class x {
    public static final Object a(Object r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        Intrinsics.checkNotNullParameter(r101, "b");
        Object r102 = b.b(r100);
        Object r103 = b.b(r101);
        if ((r102 instanceof Long) == false) goto L8;
        if ((r103 instanceof Long) == false) goto L8;
        return Long.valueOf(((Number) r102).longValue() % ((Number) r103).longValue());
    L8:
        if ((r102 instanceof Number) == false) goto L14;
        if ((r103 instanceof Number) == false) goto L14;
        return Double.valueOf(((Number) r102).doubleValue() % ((Number) r103).doubleValue());
    L14:
        throw new IllegalStateException(("Can't get mod of " + r102 + " and " + r103).toString());
    }
}
