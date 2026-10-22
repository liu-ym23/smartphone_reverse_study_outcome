package com.bytedance.relax.ttmlstatic;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.rts.kmp.foundation.j;
import com.bytedance.rts.kmp.foundation.r;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Object> f267227a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f267228b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f267229c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f267230d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f267231e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f267232f = null;

    static {
        f267227a = new LinkedHashMap();
        f267228b = 4;
        f267229c = 5;
        f267230d = "__RenderPage";
        f267231e = "__UpdatePage";
        f267232f = "__DestroyLifetime";
    }

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
        final Map r103 = TypeIntrinsics.asMutableMap(new LinkedHashMap());
        j.b(r102, new IndexKt$normalizeOptionalMap$1(r103));
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.Any");
        return r103;
    L14:
        if (TypeIntrinsics.isMutableMap(r100) == false) goto L16;
        r101 = (Map) r100;
    L16:
        if (r101 == null) goto L19;
        Intrinsics.checkNotNullParameter(r101, "map");
        final Map r104 = TypeIntrinsics.asMutableMap(new LinkedHashMap());
        j.b(r101, new IndexKt$normalizeObjectMap$1(r104));
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
        Intrinsics.checkNotNullParameter(r100, "event");
        Object r101 = a(r100);
        Intrinsics.checkNotNull(r101);
        return TypeIntrinsics.asMutableMap(r101);
    }

    public static final Function1<Object, Unit> d(Function1<Object, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        t87.b.f545055a.getClass();
        Intrinsics.checkNotNullParameter(r100, "callback");
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.Function1<kotlin.Any, kotlin.Unit>{ com.bytedance.relax.ttmlstatic.bytekmp.RendererFunctionNGKt.CommonCallbackNG }");
        return (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r100, 1);
    }

    public static final Object c(Object r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Object r102 = a(r100);
        Intrinsics.checkNotNull(r102);
        int r103 = g.f267235a;
        Object r104 = g.a.a(r102, "data");
        if ((r104 instanceof ArrayList) == false) goto L5;
        ArrayList r105 = (ArrayList) r104;
    L6:
        if (r105 == null) goto L12;
        IntCompanionObject r106 = IntCompanionObject.INSTANCE;
        Intrinsics.checkNotNullParameter(r105, "<this>");
        int r107 = r105.size();
        Intrinsics.checkNotNullParameter(r106, "<this>");
        if (r107 <= r101) goto L12;
        return a(ListProtector.get(r105, r101));
    L12:
        int r108 = r.f267614a;
        r.a.a(new Object[]{"[TTML Static] Invalid host event payload: missing data[" + r101 + "]."});
        return null;
    L5:
        r105 = null;
        goto L6
    }
}
