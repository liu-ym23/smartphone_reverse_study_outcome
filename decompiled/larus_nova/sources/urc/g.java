package urc;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes41.dex */
public final class g {
    /* JADX WARN: Type inference failed for: r0v2, types: [urc.f] */
    public static final f a(final io.github.alexzhirkevich.compottie.internal.animation.expressions.f r100, final io.github.alexzhirkevich.compottie.internal.animation.expressions.f r101, final boolean r102) {
        Intrinsics.checkNotNullParameter(r100, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        Intrinsics.checkNotNullParameter(r101, "b");
        return new f(r100, r101, r102);
    }

    public static final boolean b(Object r100, Object r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        Intrinsics.checkNotNullParameter(r101, "b");
        if ((r100 instanceof Number) == true) goto L5;
    L10:
        if (r102 == true) goto L26;
        if (r100.getClass() == r101.getClass()) goto L26;
        if ((r100 instanceof String) == false) goto L20;
        if ((r101 instanceof Number) == false) goto L20;
        return Intrinsics.areEqual(StringsKt.toDoubleOrNull((String) r100), ((Number) r101).doubleValue());
    L20:
        if ((r101 instanceof String) == false) goto L31;
        if ((r100 instanceof Number) == false) goto L31;
        return Intrinsics.areEqual(StringsKt.toDoubleOrNull((String) r101), ((Number) r100).doubleValue());
    L31:
        return Intrinsics.areEqual(r100.toString(), r101.toString());
    L26:
        return Intrinsics.areEqual(r100, r101);
    L5:
        if ((r101 instanceof Number) == false) goto L10;
        if (((Number) r100).doubleValue() != ((Number) r101).doubleValue()) goto L9;
        return true;
    L9:
        return false;
    }
}
