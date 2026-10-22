package com.ss.android.lark.todo.impl.features.detail.viewmodel.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b {
    public static final <T, V extends a<T>> List<T> a(List<? extends V> r100) {
        Intrinsics.checkNotNullParameter(r100, "dataList");
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        T r103 = r102.next();
        if (((a) r103).isValid() == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r105 = r101.iterator();
    L10:
        if (r105.hasNext() == false) goto L12;
        r104.add(((a) r105.next()).parseToPb());
        goto L10
    L12:
        return r104;
    }

    public static final <T, V extends a<T>> List<T> b(List<? extends V> r100) {
        if (r100 == null) goto L10;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L5:
        if (r102.hasNext() == false) goto L16;
        Object r103 = ((a) r102.next()).parseToPb();
        if (r103 == null) goto L5;
        r101.add(r103);
        goto L5
    L16:
        return r101;
    L10:
        return CollectionsKt.emptyList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, V extends a<T>> List<V> c(List<? extends T> r100, Class<T> r101, Class<V> r102) {
        Intrinsics.checkNotNullParameter(r100, "pbDataList");
        Intrinsics.checkNotNullParameter(r101, "clazzT");
        Intrinsics.checkNotNullParameter(r102, "clazzV");
        List<? extends T> r103 = r100;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L4:
        if (r105.hasNext() == false) goto L7;
        T r106 = r105.next();
        Intrinsics.checkNotNullParameter(r101, "clazzT");
        Intrinsics.checkNotNullParameter(r102, "clazzV");
        r104.add((a) r102.getDeclaredConstructor(new Class[]{r101}).newInstance(new Object[]{r106}));
        goto L4
    L7:
        return CollectionsKt.toMutableList(r104);
    }
}
