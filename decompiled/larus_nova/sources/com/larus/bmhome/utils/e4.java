package com.larus.bmhome.utils;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class e4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<List<Long>, Unit> f315006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<d4> f315007b;

    public e4(q0 r100) {
        Intrinsics.checkNotNullParameter(r100, "eventsCompleteHandler");
        this.f315006a = r100;
        ArrayList r101 = new ArrayList(3);
        int r102 = 0;
    L3:
        if (r102 >= 3) goto L5;
        r101.add(new d4());
        r102 = r102 + 1;
        goto L3
    L5:
        this.f315007b = r101;
    }

    public final void a(int r100) {
        if (r100 >= 0) goto L4;
        return;
    L4:
        if (r100 >= ((ArrayList) this.f315007b).size()) goto L28;
        if (r100 > 0) goto L8;
    L10:
        ((d4) ListProtector.get(this.f315007b, r100)).f315001a = System.currentTimeMillis();
        ((d4) ListProtector.get(this.f315007b, r100)).f315002b = true;
        if (r100 != (((ArrayList) this.f315007b).size() - 1)) goto L21;
        Iterator<T> r101 = this.f315007b.iterator();
    L14:
        if (r101.hasNext() == false) goto L16;
        ((d4) r101.next()).f315002b = false;
        goto L14
    L16:
        Function1<List<Long>, Unit> r102 = this.f315006a;
        List<d4> r103 = this.f315007b;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L18:
        if (r105.hasNext() == false) goto L20;
        r104.add(Long.valueOf(((d4) r105.next()).f315001a));
        goto L18
    L20:
        r102.invoke(r104);
    L21:
        int r106 = r100 + 1;
        int r107 = ((ArrayList) this.f315007b).size();
    L22:
        if (r106 >= r107) goto L29;
        ((d4) ListProtector.get(this.f315007b, r106)).f315002b = false;
        r106 = r106 + 1;
        goto L22
    L29:
        return;
    L8:
        if (((d4) ListProtector.get(this.f315007b, r100 - 1)).f315002b == true) goto L10;
        return;
    }
}
