package sv6;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {
    public static final int a(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof Integer) == false) goto L8;
        return ((Number) r100).intValue();
    L8:
        if ((r100 instanceof Double) == false) goto L12;
        return (int) ((Number) r100).doubleValue();
    L12:
        if ((r100 instanceof String) == true) goto L14;
        return 0;
    L14:
        return CastIntegerProtector.parseInt((String) r100);
    L19:
        return 0;
    }
}
