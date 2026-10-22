package com.relax.relaxreact;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class n1 {
    public static final Object a(Object r100) {
        Map r101 = null;
        if (r100 != null) goto L6;
        return null;
    L6:
        if (TypeIntrinsics.isMutableMap(r100) == false) goto L8;
        Map r102 = (Map) r100;
    L10:
        if (r102 == null) goto L14;
        Intrinsics.checkNotNullParameter(r102, "map");
        Map r103 = TypeIntrinsics.asMutableMap(new LinkedHashMap());
        com.bytedance.rts.kmp.foundation.j.b(r102, new UtilsKt$normalizeOptionalMapToJsonPayload$1(r103));
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.Any");
        return r103;
    L14:
        if (TypeIntrinsics.isMutableMap(r100) == false) goto L16;
        r101 = (Map) r100;
    L16:
        if (r101 == null) goto L19;
        Intrinsics.checkNotNullParameter(r101, "map");
        Map r104 = TypeIntrinsics.asMutableMap(new LinkedHashMap());
        com.bytedance.rts.kmp.foundation.j.b(r101, new UtilsKt$normalizeObjectMapToJsonPayload$1(r104));
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.Any");
        return r104;
    L19:
        int r105 = com.bytedance.rts.kmp.foundation.a.f267607a;
        if ((r100 instanceof ArrayList) == false) goto L26;
        ArrayList r106 = (ArrayList) r100;
        Intrinsics.checkNotNullParameter(r106, "values");
        ArrayList r107 = new ArrayList();
        int r108 = 0;
    L22:
        IntCompanionObject r109 = IntCompanionObject.INSTANCE;
        Intrinsics.checkNotNullParameter(r106, "<this>");
        int r110 = r106.size();
        Intrinsics.checkNotNullParameter(r109, "<this>");
        if (r108 >= r110) goto L25;
        Object r111 = a(ListProtector.get(r106, r108));
        Intrinsics.checkNotNullParameter(r107, "<this>");
        r107.add(r111);
        r108 = r108 + 1;
        goto L22
    L25:
        return r107;
    L26:
        return r100;
    L8:
        r102 = null;
        goto L10
    }

    public static final Map<String, Object> b(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        Map r101 = null;
        if (TypeIntrinsics.isMutableMap(r100) == false) goto L5;
        Map r102 = (Map) r100;
    L7:
        if (r102 == null) goto L11;
        Intrinsics.checkNotNullParameter(r102, "map");
        Map<String, Object> r103 = TypeIntrinsics.asMutableMap(new LinkedHashMap());
        com.bytedance.rts.kmp.foundation.j.b(r102, new UtilsKt$normalizeOptionalMapToJsonPayload$1(r103));
        return r103;
    L11:
        if (TypeIntrinsics.isMutableMap(r100) == false) goto L13;
        r101 = (Map) r100;
    L13:
        if (r101 == null) goto L16;
        Intrinsics.checkNotNullParameter(r101, "map");
        Map<String, Object> r104 = TypeIntrinsics.asMutableMap(new LinkedHashMap());
        com.bytedance.rts.kmp.foundation.j.b(r101, new UtilsKt$normalizeObjectMapToJsonPayload$1(r104));
        return r104;
    L16:
        Object r105 = a(r100);
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>{ com.relax.relaxreact.RendererCoreKt.UnspecifiedJsonPayload }");
        return TypeIntrinsics.asMutableMap(r105);
    L5:
        r102 = null;
        goto L7
    }
}
