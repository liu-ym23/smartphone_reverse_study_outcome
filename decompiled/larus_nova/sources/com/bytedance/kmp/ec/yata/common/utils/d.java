package com.bytedance.kmp.ec.yata.common.utils;

import com.google.gson.internal.LinkedTreeMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;
import kotlin.Deprecated;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class d {
    @Deprecated(message = "SDK内部API")
    public static final Double a(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L18
        if ((r100 instanceof Double) == false) goto L7;
        Double r102 = (Double) r100;     // Catch: Throwable -> L18
    L16:
        Object r103 = Result.m9449constructorimpl(r102);     // Catch: Throwable -> L18
    L21:
        if (Result.m9455isFailureimpl(r103) == false) goto L23;
        r103 = null;
    L23:
        Double r104 = (Double) r103;
        if (r104 == null) goto L28;
        boolean r105 = true;
        if (Double.isNaN(r104.doubleValue()) != true) goto L28;
    L29:
        if (r105 == false) goto L31;
        return null;
    L31:
        return r104;
    L28:
        r105 = false;
        goto L29
    L7:
        if ((r100 instanceof Float) == false) goto L10;
        r102 = StringsKt.toDoubleOrNull(r100.toString());     // Catch: Throwable -> L18
        goto L16
    L10:
        if ((r100 instanceof Number) == false) goto L13;
        r102 = Double.valueOf(((Number) r100).doubleValue());     // Catch: Throwable -> L18
        goto L16
    L13:
        if ((r100 instanceof String) == false) goto L15;
        r102 = StringsKt.toDoubleOrNull((String) r100);     // Catch: Throwable -> L18
        goto L16
    L15:
        r102 = null;
    L18:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    }

    @Deprecated(message = "SDK内部API")
    public static final Boolean b(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof Boolean) == true) goto L5;
        Long r101 = e(r100);
        if (r101 != null) goto L10;
    L13:
        Long r102 = e(r100);
        if (r102 != null) goto L17;
        return null;
    L17:
        if (r102.longValue() == 0) goto L19;
        return null;
    L19:
        return Boolean.FALSE;
    L10:
        if (r101.longValue() != 1) goto L13;
        return Boolean.TRUE;
    L5:
        return (Boolean) r100;
    }

    @Deprecated(message = "SDK内部API")
    public static final Float c(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof Float) == false) goto L6;
        Float r101 = (Float) r100;
    L12:
        if (r101 == null) goto L16;
        boolean r102 = true;
        if (Float.isNaN(r101.floatValue()) != true) goto L16;
    L17:
        if (r102 == false) goto L19;
        return null;
    L19:
        return r101;
    L16:
        r102 = false;
        goto L17
    L6:
        if ((r100 instanceof Number) == false) goto L9;
        r101 = Float.valueOf((float) ((Number) r100).doubleValue());
        goto L12
    L9:
        if ((r100 instanceof String) == false) goto L11;
        r101 = StringsKt.toFloatOrNull((String) r100);
        goto L12
    L11:
        r101 = null;
        goto L12
    }

    @Deprecated(message = "SDK内部API")
    public static final Integer d(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L17
        if ((r100 instanceof Integer) == false) goto L7;
        Integer r103 = (Integer) r100;     // Catch: Throwable -> L17
    L15:
        Object r104 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L17
    L20:
        if (Result.m9455isFailureimpl(r104) == true) goto L24;
        r101 = r104;
    L24:
        return (Integer) r101;
    L7:
        if ((r100 instanceof Number) == false) goto L10;
        r103 = i(((Number) r100).doubleValue());     // Catch: Throwable -> L17
        goto L15
    L10:
        if ((r100 instanceof String) == false) goto L14;
        Double r105 = StringsKt.toDoubleOrNull((String) r100);     // Catch: Throwable -> L17
        if (r105 == null) goto L14;
        r103 = i(r105.doubleValue());     // Catch: Throwable -> L17
    L14:
        r103 = null;
    L17:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    }

    @Deprecated(message = "SDK内部API")
    public static final Long e(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L17
        if ((r100 instanceof Long) == false) goto L7;
        Long r103 = (Long) r100;     // Catch: Throwable -> L17
    L15:
        Object r104 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L17
    L20:
        if (Result.m9455isFailureimpl(r104) == true) goto L24;
        r101 = r104;
    L24:
        return (Long) r101;
    L7:
        if ((r100 instanceof Number) == false) goto L10;
        r103 = j(((Number) r100).doubleValue());     // Catch: Throwable -> L17
        goto L15
    L10:
        if ((r100 instanceof String) == false) goto L14;
        Double r105 = StringsKt.toDoubleOrNull((String) r100);     // Catch: Throwable -> L17
        if (r105 == null) goto L14;
        r103 = j(r105.doubleValue());     // Catch: Throwable -> L17
    L14:
        r103 = null;
    L17:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated(message = "SDK内部API")
    public static final <T> List<T> f(List<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = f.f251564a;
        Intrinsics.checkNotNullParameter(r100, "list");
        if ((r100 instanceof ArrayList) == false) goto L6;
        return r100;
    L6:
        if ((r100 instanceof LinkedList) == false) goto L9;
        return r100;
    L9:
        if ((r100 instanceof Vector) == false) goto L12;
        return r100;
    L12:
        return CollectionsKt.toMutableList(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated(message = "SDK内部API")
    public static final <K, V> Map<K, V> g(Map<K, ? extends V> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = f.f251564a;
        Intrinsics.checkNotNullParameter(r100, "map");
        if ((r100 instanceof LinkedTreeMap) == false) goto L6;
        return r100;
    L6:
        if ((r100 instanceof LinkedHashMap) == false) goto L9;
        return r100;
    L9:
        if ((r100 instanceof HashMap) == false) goto L12;
        return r100;
    L12:
        if ((r100 instanceof TreeMap) == false) goto L15;
        return r100;
    L15:
        return MapsKt.toMutableMap(r100);
    }

    @Deprecated(message = "SDK内部API")
    public static final Integer i(double r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        Object r102 = Result.m9449constructorimpl(Integer.valueOf(MathKt.roundToInt(r100)));     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r102) == false) goto L10;
        r102 = null;
    L10:
        return (Integer) r102;
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Deprecated(message = "SDK内部API")
    public static final Long j(double r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        Object r102 = Result.m9449constructorimpl(Long.valueOf(MathKt.roundToLong(r100)));     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r102) == false) goto L10;
        r102 = null;
    L10:
        return (Long) r102;
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Deprecated(message = "SDK内部API")
    public static final Map<String, Object> h(Map<String, ? extends Object> r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Object r102 = r100.get(r101);
        if ((r102 instanceof Map) == true) goto L7;
        return null;
    L7:
        return (Map) r102;
    }
}
