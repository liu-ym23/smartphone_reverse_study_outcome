package com.google.common.collect;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public final class m1 extends z2<Map.Entry<Object, Object>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Iterator f275484a;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f275484a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        Map.Entry r100 = (Map.Entry) this.f275484a.next();
        r100.getClass();
        return new l1(r100);
    }

    public m1(Iterator r100) {
        this.f275484a = r100;
    }
}
