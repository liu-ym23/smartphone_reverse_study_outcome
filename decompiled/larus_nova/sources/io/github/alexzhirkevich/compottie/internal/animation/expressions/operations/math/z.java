package io.github.alexzhirkevich.compottie.internal.animation.expressions.operations.math;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class z {
    public static final Object a(Object r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "other");
        Object r102 = b.b(r100);
        Object r103 = b.b(r101);
        boolean r104 = r102 instanceof Number;
        if (r104 == false) goto L7;
        if ((r103 instanceof io.github.alexzhirkevich.compottie.internal.animation.expressions.y) == false) goto L7;
    L57:
        return Float.valueOf(Float.NaN);
    L7:
        if ((r102 instanceof io.github.alexzhirkevich.compottie.internal.animation.expressions.y) == true) goto L9;
    L11:
        boolean r105 = r102 instanceof Long;
        if (r105 == false) goto L17;
        if ((r103 instanceof Long) == false) goto L17;
        return Long.valueOf(((Number) r102).longValue() * ((Number) r103).longValue());
    L17:
        if ((r102 instanceof Double) == true) goto L19;
    L21:
        if (r105 == true) goto L23;
    L28:
        if (r104 == true) goto L30;
    L32:
        int r106 = 0;
        if ((r102 instanceof List) == true) goto L35;
    L40:
        if (r104 == false) goto L47;
        if ((r103 instanceof List) == false) goto L47;
        List r107 = (List) r103;
        double r108 = ((Number) r102).doubleValue();
        ArrayList r109 = new ArrayList(r107.size());
        int r110 = r107.size();
    L44:
        if (r106 >= r110) goto L64;
        r109.add(Double.valueOf(((Number) ListProtector.get(r107, r106)).doubleValue() * r108));
        r106 = r106 + 1;
        goto L44
    L64:
        return r109;
    L47:
        if ((r102 instanceof CharSequence) == true) goto L54;
        if ((r103 instanceof CharSequence) == true) goto L54;
        throw new IllegalStateException(("Cant multiply " + r102 + " by " + r103).toString());
    L54:
        return Double.valueOf(CastDoubleProtector.parseDouble(r102.toString()) * CastDoubleProtector.parseDouble(r103.toString()));
    L35:
        if ((r103 instanceof Number) == false) goto L40;
        List r111 = (List) r102;
        double r112 = ((Number) r103).doubleValue();
        ArrayList r113 = new ArrayList(r111.size());
        int r114 = r111.size();
    L37:
        if (r106 >= r114) goto L63;
        r113.add(Double.valueOf(((Number) ListProtector.get(r111, r106)).doubleValue() * r112));
        r106 = r106 + 1;
        goto L37
    L63:
        return r113;
    L30:
        if ((r103 instanceof Number) == false) goto L32;
        return Double.valueOf(((Number) r102).doubleValue() * ((Number) r103).doubleValue());
    L23:
        if ((r103 instanceof Long) == false) goto L28;
        Number r115 = (Number) r103;
        if (r115.longValue() != 0) goto L61;
        return Float.valueOf(Float.POSITIVE_INFINITY);
    L61:
        return Long.valueOf(((Number) r102).longValue() / r115.longValue());
    L19:
        if ((r103 instanceof Double) == false) goto L21;
        return Double.valueOf(((Number) r102).doubleValue() * ((Number) r103).doubleValue());
    L9:
        if ((r103 instanceof Number) == false) goto L11;
        goto L11
    }
}
