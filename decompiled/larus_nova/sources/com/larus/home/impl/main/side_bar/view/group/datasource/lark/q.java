package com.larus.home.impl.main.side_bar.view.group.datasource.lark;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class q {
    public static final f a(iza.d r110) {
        List<iza.c> r100 = r110.f496726a;
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        iza.c r103 = (iza.c) r102.next();
        r101.add(new e(r103.f496720a, r103.f496721b, r103.f496722c, r103.f496723d, r103.f496724e, r103.f496725f));
        goto L4
    L7:
        return new f(r101, r110.f496727b);
    }
}
