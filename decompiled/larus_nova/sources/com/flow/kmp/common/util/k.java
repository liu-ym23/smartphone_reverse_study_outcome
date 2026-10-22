package com.flow.kmp.common.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ouc.a0;
import ouc.d0;
import ouc.g0;

/* JADX INFO: loaded from: classes3.dex */
public final class k {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Long] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.Double] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v0, types: [ouc.i] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object] */
    public static final Object a(ouc.i r100) {
        if ((r100 instanceof a0) == false) goto L6;
        return null;
    L6:
        if ((r100 instanceof d0) == false) goto L13;
        Map r101 = (Map) r100;
        ArrayList r102 = new ArrayList(r101.size());
        Iterator r103 = r101.entrySet().iterator();
    L9:
        if (r103.hasNext() == false) goto L37;
        Map.Entry r104 = (Map.Entry) r103.next();
        r102.add(TuplesKt.to((String) r104.getKey(), a((ouc.i) r104.getValue())));
        goto L9
    L37:
        return MapsKt.toMap(r102);
    L13:
        if ((r100 instanceof ouc.b) == false) goto L20;
        Iterable r105 = (Iterable) r100;
        ?? r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator r107 = r105.iterator();
    L16:
        if (r107.hasNext() == false) goto L38;
        r106.add(a((ouc.i) r107.next()));
    L38:
        return r106;
    L20:
        if ((r100 instanceof g0) == false) goto L33;
        g0 r108 = (g0) r100;
        if (r108.c() == true) goto L39;
        r106 = ouc.k.f(r108);
        if (r106 != 0) goto L38;
        r106 = ouc.k.q(r108);
        if (r106 != 0) goto L38;
        r106 = ouc.k.i(r108);
        if (r106 != 0) goto L38;
        return r108.a();
    L39:
        return r108.a();
    L33:
        throw new NoWhenBranchMatchedException();
    }

    public static final String b(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Set<Map.Entry<String, ? extends Object>> r101 = r100.entrySet();
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L25;
        Map.Entry r104 = (Map.Entry) r103.next();
        String r105 = (String) r104.getKey();
        Object r106 = r104.getValue();
        if (r106 == null) goto L9;
        String r107 = r106.toString();
        if (r107 == null) goto L9;
    L11:
        if (r105 != null) goto L13;
    L16:
        boolean r108 = true;
    L17:
        if (r108 == false) goto L19;
    L21:
        String r109 = null;
    L22:
        if (r109 == null) goto L4;
        r102.add(r109);
        goto L4
    L19:
        if ((true ^ StringsKt.isBlank(r107)) == false) goto L21;
        r109 = r105 + com.alipay.sdk.m.n.a.f25612h + r107;
        goto L22
    L13:
        if (r105.length() == 0) goto L16;
        r108 = false;
    L9:
        r107 = "";
        goto L11
    L25:
        return CollectionsKt.joinToString$default(r102, ",", null, null, 0, null, null, 62, null);
    }

    public static final d0 c(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.isEmpty() == true) goto L5;
        LinkedHashMap r101 = new LinkedHashMap(MapsKt.mapCapacity(r100.size()));
        Iterator<T> r102 = r100.entrySet().iterator();
    L8:
        if (r102.hasNext() == false) goto L11;
        Map.Entry r103 = (Map.Entry) r102.next();
        r101.put(r103.getKey(), ouc.k.c((String) r103.getValue()));
        goto L8
    L11:
        return new d0(r101);
    L5:
        return new d0(MapsKt.emptyMap());
    }

    public static final Map<String, String> d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return e(r100, new j());
    }

    public static final <T> Map<String, T> e(String r100, Function2<? super String, Object, ? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "transform");
        if (StringsKt.isBlank(r100) == true) goto L5;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L21
        ouc.i r103 = ouc.a.f526798d.e(r100);     // Catch: Throwable -> L21
        if ((r103 instanceof d0) == false) goto L9;
        d0 r104 = (d0) r103;     // Catch: Throwable -> L21
    L10:
        if (r104 != null) goto L12;
        LinkedHashMap r105 = new LinkedHashMap();     // Catch: Throwable -> L21
    L19:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L21
    L23:
        LinkedHashMap r107 = new LinkedHashMap();
        if (Result.m9455isFailureimpl(r106) == false) goto L27;
        r106 = r107;
    L27:
        return (Map) r106;
    L12:
        LinkedHashMap r108 = new LinkedHashMap();     // Catch: Throwable -> L21
        Iterator<Map.Entry<String, ouc.i>> r109 = r104.entrySet().iterator();     // Catch: Throwable -> L21
    L14:
        if (r109.hasNext() == false) goto L18;
        Map.Entry<String, ouc.i> r110 = r109.next();     // Catch: Throwable -> L21
        String r111 = r110.getKey();     // Catch: Throwable -> L21
        T r112 = r101.invoke(r111, a(r110.getValue()));     // Catch: Throwable -> L21
        if (r112 == null) goto L14;
        r108.put(r111, r112);     // Catch: Throwable -> L21
        goto L14
    L18:
        r105 = r108;
        goto L19
    L9:
        r104 = null;
    L21:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L23
    L5:
        return new LinkedHashMap();
    }
}
