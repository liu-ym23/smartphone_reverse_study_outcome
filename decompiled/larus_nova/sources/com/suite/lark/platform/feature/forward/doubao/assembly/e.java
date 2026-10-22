package com.suite.lark.platform.feature.forward.doubao.assembly;

import java.util.Iterator;
import kotlin.collections.Grouping;

/* JADX INFO: loaded from: classes36.dex */
public final class e implements Grouping<npc.c, Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Iterable f461310a;

    @Override // kotlin.collections.Grouping
    public final Iterator<npc.c> sourceIterator() {
        return this.f461310a.iterator();
    }

    public e(Iterable r100) {
        this.f461310a = r100;
    }

    @Override // kotlin.collections.Grouping
    public final Integer keyOf(npc.c r100) {
        return Integer.valueOf(r100.f520077e);
    }
}
