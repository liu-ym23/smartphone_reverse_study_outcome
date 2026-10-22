package mq;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b {
    public static final boolean a(Object r100) {
        if (Intrinsics.areEqual(r100, Boolean.TRUE) == false) goto L5;
        return true;
    L5:
        if (Intrinsics.areEqual(r100, "true") == false) goto L7;
        return true;
    L7:
        if (Intrinsics.areEqual(r100, 1) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public static final int b(Object r100, int r101) {
        if ((r100 instanceof Number) == false) goto L6;
        return ((Number) r100).intValue();
    L6:
        if ((r100 instanceof String) == false) goto L13;
        return CastIntegerProtector.parseInt((String) r100);
    L14:
        return r101;
    L13:
        return r101;
    }

    public static final boolean c(Map<String, ? extends Object> r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100 != null) goto L5;
        return r102;
    L5:
        Object r103 = r100.get(r101);
        if (r103 != null) goto L9;
        r103 = Boolean.valueOf(r102);
    L9:
        return a(r103);
    }

    public static final String d(Map<String, ? extends Object> r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100 == null) goto L12;
        Object r103 = r100.get(r101);
        if (r103 == null) goto L13;
        String r104 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r103);
        if (r104 != null) goto L11;
        return r102;
    L11:
        return r104;
    L13:
        return r102;
    L12:
        return r102;
    }
}
