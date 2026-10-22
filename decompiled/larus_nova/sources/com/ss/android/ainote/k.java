package com.ss.android.ainote;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class k<T, U, R> implements BiFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f406833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f406834b;

    public k(long r100, long r101) {
        this.f406833a = r100;
        this.f406834b = r101;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object r100, Object r110) {
        j.c r111 = (j.c) r110;
        Intrinsics.checkNotNullParameter((String) r100, "<unused var>");
        Intrinsics.checkNotNullParameter(r111, "task");
        List<Long> r101 = r111.f406797d;
        long r102 = this.f406833a;
        long r103 = this.f406834b;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r105 = r101.iterator();
    L4:
        if (r105.hasNext() == false) goto L10;
        long r106 = ((Number) r105.next()).longValue();
        if (r106 != r102) goto L8;
        r106 = r103;
    L8:
        r104.add(Long.valueOf(r106));
        goto L4
    L10:
        return j.c.a(r111, CollectionsKt.distinct(r104), 0, 55);
    }
}
