package io.github.alexzhirkevich.compottie.internal.animation.expressions.operations.math;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes41.dex */
public final class b {
    public static final Object b(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof Byte) == false) goto L6;
        return Long.valueOf(((Number) r100).byteValue());
    L6:
        if ((r100 instanceof UByte) == false) goto L9;
        return Long.valueOf(((long) ((UByte) r100).m9517unboximpl()) & 255);
    L9:
        if ((r100 instanceof Short) == false) goto L12;
        return Long.valueOf(((Number) r100).shortValue());
    L12:
        if ((r100 instanceof UShort) == false) goto L15;
        return Long.valueOf(((long) ((UShort) r100).m9780unboximpl()) & 65535);
    L15:
        if ((r100 instanceof Integer) == false) goto L18;
        return Long.valueOf(((Number) r100).intValue());
    L18:
        if ((r100 instanceof UInt) == false) goto L21;
        return Long.valueOf(((long) ((UInt) r100).m9596unboximpl()) & BodyPartID.bodyIdMax);
    L21:
        if ((r100 instanceof ULong) == false) goto L24;
        return Long.valueOf(((ULong) r100).m9675unboximpl());
    L24:
        if ((r100 instanceof Float) == true) goto L26;
        return r100;
    L26:
        return Double.valueOf(((Number) r100).floatValue());
    }

    public static final Object a(Object r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "other");
        Object r102 = b(r100);
        Object r103 = b(r101);
        boolean r104 = r102 instanceof Number;
        if (r104 == false) goto L7;
        if ((r103 instanceof io.github.alexzhirkevich.compottie.internal.animation.expressions.y) == false) goto L7;
    L50:
        return Float.valueOf(Float.NaN);
    L7:
        if ((r102 instanceof io.github.alexzhirkevich.compottie.internal.animation.expressions.y) == false) goto L12;
        if ((r103 instanceof Number) == true) goto L50;
    L12:
        if ((r102 instanceof Long) == true) goto L14;
    L16:
        if (r104 == true) goto L18;
    L20:
        boolean r105 = r102 instanceof List;
        int r106 = 0;
        if (r105 == false) goto L29;
        if ((r103 instanceof List) == false) goto L29;
        List r107 = (List) r102;
        List r108 = (List) r103;
        int r109 = Math.min(r107.size(), r108.size());
        ArrayList r110 = new ArrayList(r109);
    L25:
        if (r106 >= r109) goto L53;
        r110.add(Double.valueOf(((Number) ListProtector.get(r107, r106)).doubleValue() + ((Number) ListProtector.get(r108, r106)).doubleValue()));
        r106 = r106 + 1;
        goto L25
    L53:
        return r110;
    L29:
        if (r105 == true) goto L31;
    L36:
        if (r104 == false) goto L44;
        if ((r103 instanceof List) == false) goto L44;
        if (TypeIntrinsics.isMutableList(r103) == false) goto L57;
        TypeIntrinsics.asMutableList(r103);
        List r111 = (List) r103;
        ListProtector.set(r111, 0, Double.valueOf(((Number) ListProtector.get(r111, 0)).doubleValue() + ((Number) r102).doubleValue()));
        return r103;
    L57:
        return a(Double.valueOf(((Number) r102).doubleValue() + ((Number) CollectionsKt.first((List) r103)).doubleValue()), CollectionsKt.drop((Iterable) r103, 1));
    L44:
        if ((r102 instanceof CharSequence) == false) goto L48;
        StringBuilder r112 = new StringBuilder();
        r112.append(r102);
        r112.append(r103);
        return r112.toString();
    L48:
        throw new IllegalStateException(("Cant calculate the sum of " + r102 + " and " + r103).toString());
    L31:
        if ((r103 instanceof Number) == false) goto L36;
        if (TypeIntrinsics.isMutableList(r102) == false) goto L55;
        TypeIntrinsics.asMutableList(r102);
        List r113 = (List) r102;
        ListProtector.set(r113, 0, Double.valueOf(((Number) ListProtector.get(r113, 0)).doubleValue() + ((Number) r103).doubleValue()));
        return r102;
    L55:
        return a(Double.valueOf(((Number) CollectionsKt.first((List) r102)).doubleValue() + ((Number) r103).doubleValue()), CollectionsKt.drop((Iterable) r102, 1));
    L18:
        if ((r103 instanceof Number) == false) goto L20;
        return Double.valueOf(((Number) r102).doubleValue() + ((Number) r103).doubleValue());
    L14:
        if ((r103 instanceof Long) == false) goto L16;
        return Long.valueOf(((Number) r102).longValue() + ((Number) r103).longValue());
    }
}
