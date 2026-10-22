package com.bytedance.ee.bear.wikiv2.home2.model;

import java.util.List;
import java.util.concurrent.Callable;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i<V> implements Callable {
    public static final i<V> a = null;

    static {
        a = new i();
    }

    public i() {
    }

    @Override // java.util.concurrent.Callable
    public final List<WikiSpaceType> call() {
        if (yp5.c.c() == false) goto L6;
        return CollectionsKt.listOf(new WikiSpaceType[]{new WikiSpaceType("all", eu5.b.a.getString(2131889791)), new WikiSpaceType(WikiSpaceType.TEAM, eu5.b.a.getString(2131889795)), new WikiSpaceType(WikiSpaceType.PERSONAL, eu5.b.a.getString(2131889794))});
    L6:
        return CollectionsKt.emptyList();
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
