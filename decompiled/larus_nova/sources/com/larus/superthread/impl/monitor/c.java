package com.larus.superthread.impl.monitor;

import java.util.Iterator;
import kotlin.collections.Grouping;

/* JADX INFO: loaded from: classes31.dex */
public final class c implements Grouping<Thread, String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Iterable f370130a;

    @Override // kotlin.collections.Grouping
    public final Iterator<Thread> sourceIterator() {
        return this.f370130a.iterator();
    }

    public c(Iterable r100) {
        this.f370130a = r100;
    }

    @Override // kotlin.collections.Grouping
    public final String keyOf(Thread r100) {
        return r100.getName();
    }
}
