package com.bytedance.ee.bear.more.protocol3;

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
public final class i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i f234894c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<k> f234895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Integer> f234896b;

    public static final class a {
    }

    static {
        f234894c = new i(CollectionsKt.emptyList());
    }

    public i(List<? extends k> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        List<k> r101 = CollectionsKt.toMutableList(r100);
        this.f234895a = r101;
        List<k> r102 = r101;
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
        r103.add(TuplesKt.to(((k) r106).f234901a, Integer.valueOf(r105)));
        r105 = r107;
        goto L4
    L9:
        this.f234896b = MapsKt.toMap(r103);
    }

    public final k a(int r100) {
        return (k) ListProtector.get(this.f234895a, r100);
    }
}
