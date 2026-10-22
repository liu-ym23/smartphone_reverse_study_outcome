package com.bytedance.ee.bear.share.newshare;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d0 f237205d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<e0> f237206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<e0> f237207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Integer> f237208c;

    public static final class a {
    }

    static {
        f237205d = new d0(CollectionsKt.emptyList());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d0(List<? extends e0> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        this.f237206a = r100;
        List<e0> r101 = CollectionsKt.toMutableList(r100);
        this.f237207b = r101;
        List<e0> r102 = r101;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
        int r105 = 0;
    L4:
        if (r104.hasNext() == false) goto L9;
        Object r106 = r104.next();
        int r107 = r105 + 1;
        if (r105 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        r103.add(TuplesKt.to(((e0) r106).f237211a, Integer.valueOf(r105)));
        r105 = r107;
        goto L4
    L9:
        this.f237208c = MapsKt.toMap(r103);
    }

    public final e0 a(int r100) {
        return (e0) ListProtector.get(this.f237207b, r100);
    }
}
