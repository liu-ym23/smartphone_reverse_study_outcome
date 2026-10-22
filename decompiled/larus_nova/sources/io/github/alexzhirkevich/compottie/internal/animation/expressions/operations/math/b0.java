package io.github.alexzhirkevich.compottie.internal.animation.expressions.operations.math;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class b0 {
    public static final Object a(Object r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "other");
        Object r102 = b.b(r100);
        Object r103 = b.b(r101);
        boolean r104 = r102 instanceof Number;
        if (r104 == false) goto L7;
        if ((r103 instanceof io.github.alexzhirkevich.compottie.internal.animation.expressions.y) == false) goto L7;
    L43:
        return Float.valueOf(Float.NaN);
    L7:
        if ((r102 instanceof io.github.alexzhirkevich.compottie.internal.animation.expressions.y) == false) goto L12;
        if ((r103 instanceof Number) == true) goto L43;
    L12:
        if ((r102 instanceof Long) == false) goto L17;
        if ((r103 instanceof Long) == false) goto L17;
        return Long.valueOf(((Number) r102).longValue() - ((Number) r103).longValue());
    L17:
        if ((r102 instanceof Double) == true) goto L19;
    L21:
        if (r104 == false) goto L26;
        if ((r103 instanceof Number) == false) goto L26;
        return Double.valueOf(((Number) r102).doubleValue() - ((Number) r103).doubleValue());
    L26:
        if ((r102 instanceof List) == false) goto L34;
        if ((r103 instanceof List) == false) goto L34;
        List r105 = (List) r102;
        List r106 = (List) r103;
        int r107 = Math.min(r105.size(), r106.size());
        ArrayList r108 = new ArrayList(r107);
        int r109 = 0;
    L30:
        if (r109 >= r107) goto L47;
        r108.add(Double.valueOf(((Number) ListProtector.get(r105, r109)).doubleValue() - ((Number) ListProtector.get(r106, r109)).doubleValue()));
        r109 = r109 + 1;
        goto L30
    L47:
        return r108;
    L34:
        if ((r102 instanceof CharSequence) == true) goto L41;
        if ((r103 instanceof CharSequence) == true) goto L41;
        throw new IllegalStateException(("Cant subtract " + r103 + " from " + r102).toString());
    L41:
        return Double.valueOf(CastDoubleProtector.parseDouble(r102.toString()) - CastDoubleProtector.parseDouble(r103.toString()));
    L19:
        if ((r103 instanceof Double) == false) goto L21;
        return Double.valueOf(((Number) r102).doubleValue() - ((Number) r103).doubleValue());
    }
}
