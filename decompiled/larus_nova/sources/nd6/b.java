package nd6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {
    static {
    }

    public static Object a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "feature");
        com.bytedance.kmp.ab.b r101 = com.bytedance.kmp.ab.b.f251225c;
        if (r101.contains(r100.getKey()) == false) goto L29;
        Object r102 = r100.getDefaultValue();
        if ((r102 instanceof Boolean) == false) goto L11;
        String r103 = r100.getKey();
        Object r104 = r100.getDefaultValue();
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.Boolean");
        Boolean r105 = r101.Q0(r103, (Boolean) r104);
        if (r105 == null) goto L29;
        return r105;
    L11:
        if ((r102 instanceof Integer) == false) goto L16;
        String r106 = r100.getKey();
        Object r107 = r100.getDefaultValue();
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type kotlin.Int");
        Integer r108 = r101.X0(r106, (Integer) r107);
        if (r108 == null) goto L29;
        return r108;
    L16:
        if ((r102 instanceof Long) == false) goto L21;
        String r109 = r100.getKey();
        Object r110 = r100.getDefaultValue();
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type kotlin.Long");
        Long r111 = r101.K0(r109, (Long) r110);
        if (r111 == null) goto L29;
        return r111;
    L21:
        if ((r102 instanceof String) == false) goto L26;
        String r112 = r100.getKey();
        Object r113 = r100.getDefaultValue();
        Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type kotlin.String");
        String r114 = r101.Z0(r112, (String) r113);
        if (r114 == null) goto L29;
        return r114;
    L26:
        if ((r102 instanceof Float) == false) goto L29;
        String r115 = r100.getKey();
        Object r116 = r100.getDefaultValue();
        Intrinsics.checkNotNull(r116, "null cannot be cast to non-null type kotlin.Float");
        Float r117 = r101.J1(r115, (Float) r116);
        if (r117 == null) goto L29;
        return r117;
    L29:
        return null;
    }
}
