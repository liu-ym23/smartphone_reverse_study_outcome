package jm2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes11.dex */
public final class a {
    public static final <R extends T, T extends c<T>> List<R> a(List<? extends T> r100) {
        if (r100 == null) goto L12;
        List<? extends T> r101 = r100;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L5:
        if (r103.hasNext() == false) goto L15;
        c r104 = d((c) r103.next());
        if (r104 == null) goto L10;
        r102.add(r104);
        goto L5
    L10:
        throw new NullPointerException("null cannot be cast to non-null type R");
    L15:
        return r102;
    L12:
        return CollectionsKt.emptyList();
    }

    public static final <T1, R extends T2, T2 extends c<T2>> Map<T1, R> b(Map<T1, ? extends T2> r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L12
        LinkedHashMap r102 = new LinkedHashMap(MapsKt.mapCapacity(r100.size()));     // Catch: Throwable -> L12
        Iterator<T> r103 = r100.entrySet().iterator();     // Catch: Throwable -> L12
    L4:
        if (r103.hasNext() == false) goto L10;
        Object r104 = r103.next();     // Catch: Throwable -> L12
        Object r105 = ((Map.Entry) r104).getKey();     // Catch: Throwable -> L12
        c r106 = d((c) ((Map.Entry) r104).getValue());     // Catch: Throwable -> L12
        if (r106 == null) goto L9;
        r102.put(r105, r106);     // Catch: Throwable -> L12
        goto L4
    L9:
        throw new NullPointerException("null cannot be cast to non-null type R");     // Catch: Throwable -> L12
    L10:
        Object r107 = Result.m9449constructorimpl(r102);     // Catch: Throwable -> L12
    L15:
        if (Result.m9455isFailureimpl(r107) == false) goto L17;
        r107 = null;
    L17:
        Map<T1, R> r108 = (Map) r107;
        if (r108 == null) goto L20;
        return r108;
    L20:
        return MapsKt.emptyMap();
    L12:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    public static final <R extends T, T extends c<T>> List<R> c(List<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$castToRealModelMutableList");
        List<? extends T> r101 = r100;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L11;
        c r104 = d((c) r103.next());
        if (r104 == null) goto L9;
        r102.add(r104);
        goto L4
    L9:
        throw new NullPointerException("null cannot be cast to non-null type R");
    L11:
        return CollectionsKt.toMutableList(r102);
    }

    public static final <T extends c<T>> c<T> d(c<T> r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if ((r100 instanceof e) == false) goto L12;
        Object r101 = ((e) r100).getFlexInstance();
        if (r101 == null) goto L9;
        return (c) r101;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.tools.kcp.modelx.runtime.FlexModel<T>");
    L12:
        return r100;
    }

    public static final c e(c r100) {
        c r101 = d(r100);
        if ((r101 instanceof Object) == true) goto L6;
        r101 = null;
    L6:
        return r101;
    }
}
