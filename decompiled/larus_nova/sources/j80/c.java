package j80;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes45.dex */
public final class c {
    public static final float d(d r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$norm2");
        return (float) Math.sqrt((r100.a().floatValue() * r100.a().floatValue()) + (r100.b().floatValue() * r100.b().floatValue()));
    }

    public static final e f(d r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$roundToVec2i");
        return new e(MathKt.roundToInt(r100.a().floatValue()), MathKt.roundToInt(r100.b().floatValue()));
    }

    public static final d h(e r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toVec2f");
        return new d(r100.a().intValue(), r100.b().intValue());
    }

    public static final float a(d r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        Intrinsics.checkNotNullParameter(r101, "b");
        d r102 = b(r101, r100);
        float r103 = r102.a().floatValue();
        float r104 = r102.b().floatValue();
        return (float) Math.sqrt((r103 * r103) + (r104 * r104));
    }

    public static final d b(d r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$minus");
        Intrinsics.checkNotNullParameter(r101, "rhs");
        return new d(r100.a().floatValue() - r101.a().floatValue(), r100.b().floatValue() - r101.b().floatValue());
    }

    public static final e c(e r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$minus");
        Intrinsics.checkNotNullParameter(r101, "rhs");
        return new e(r100.a().intValue() - r101.a().intValue(), r100.b().intValue() - r101.b().intValue());
    }

    public static final d e(d r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$plus");
        Intrinsics.checkNotNullParameter(r101, "rhs");
        return new d(r100.a().floatValue() + r101.a().floatValue(), r100.b().floatValue() + r101.b().floatValue());
    }

    public static final int g(e r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$times");
        Intrinsics.checkNotNullParameter(r101, "rhs");
        return (r100.a().intValue() * r101.a().intValue()) + (r100.b().intValue() * r101.b().intValue());
    }
}
