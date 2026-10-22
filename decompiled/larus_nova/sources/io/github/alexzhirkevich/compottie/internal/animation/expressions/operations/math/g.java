package io.github.alexzhirkevich.compottie.internal.animation.expressions.operations.math;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class g {
    public static final Object a(Object r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "other");
        Object r102 = b.b(r100);
        Object r103 = b.b(r101);
        boolean r104 = r102 instanceof Number;
        if (r104 == false) goto L7;
        if ((r103 instanceof io.github.alexzhirkevich.compottie.internal.animation.expressions.y) == false) goto L7;
    L44:
        return Float.valueOf(Float.NaN);
    L7:
        if ((r102 instanceof io.github.alexzhirkevich.compottie.internal.animation.expressions.y) == false) goto L12;
        if ((r103 instanceof Number) == true) goto L44;
    L12:
        if ((r102 instanceof Long) == true) goto L14;
    L22:
        if (r104 == false) goto L27;
        if ((r103 instanceof Number) == false) goto L27;
        return Double.valueOf(((Number) r102).doubleValue() / ((Number) r103).doubleValue());
    L27:
        if ((r102 instanceof List) == false) goto L35;
        if ((r103 instanceof Number) == false) goto L35;
        List r105 = (List) r102;
        double r106 = ((Number) r103).doubleValue();
        ArrayList r107 = new ArrayList(r105.size());
        int r108 = r105.size();
        int r109 = 0;
    L31:
        if (r109 >= r108) goto L49;
        r107.add(Double.valueOf(((Number) ListProtector.get(r105, r109)).doubleValue() / r106));
        r109 = r109 + 1;
        goto L31
    L49:
        return r107;
    L35:
        if ((r102 instanceof CharSequence) == true) goto L42;
        if ((r103 instanceof CharSequence) == true) goto L42;
        throw new IllegalStateException(("Cant divide " + r102 + " by " + r103).toString());
    L42:
        return Double.valueOf(CastDoubleProtector.parseDouble(r102.toString()) / CastDoubleProtector.parseDouble(r103.toString()));
    L14:
        if ((r103 instanceof Long) == false) goto L22;
        Number r110 = (Number) r103;
        if (r110.longValue() == 0) goto L45;
        Number r111 = (Number) r102;
        if ((r111.longValue() % r110.longValue()) != 0) goto L47;
        return Long.valueOf(r111.longValue() / r110.longValue());
    L47:
        return Double.valueOf(r111.longValue() / r110.doubleValue());
    L45:
        return Double.valueOf(Double.POSITIVE_INFINITY);
    }
}
