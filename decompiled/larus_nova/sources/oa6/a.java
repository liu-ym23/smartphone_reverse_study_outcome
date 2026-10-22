package oa6;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {
    public static final long e() {
        int r100 = na6.b.f518468a;
        return System.currentTimeMillis();
    }

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

    public static /* synthetic */ long d(Object r100) {
        return c(r100, 0);
    }

    public static final int b(Object r100, int r101) {
        if (r100 != null) goto L14;
        return r101;
    L14:
    L13:
        return r101;
    L5:
        if ((r100 instanceof Number) == false) goto L8;
        return ((Number) r100).intValue();
    L8:
        if ((r100 instanceof String) == false) goto L12;
        return CastIntegerProtector.parseInt((String) r100);
    L12:
        throw new IllegalArgumentException("无法转换为Int：非法的参数类型");     // Catch: Throwable -> L13
    }

    public static final long c(Object r100, long r101) {
        if (r100 != null) goto L14;
        return r101;
    L14:
    L13:
        return r101;
    L5:
        if ((r100 instanceof Number) == false) goto L8;
        return ((Number) r100).longValue();
    L8:
        if ((r100 instanceof String) == false) goto L12;
        return CastLongProtector.parseLong((String) r100);
    L12:
        throw new IllegalArgumentException("无法转换为Long：非法的参数类型");     // Catch: Throwable -> L13
    }
}
