package com.suite.lark.component.navroute.group;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes40.dex */
public final class d<T> implements Comparator {
    public d() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(((com.suite.lark.component.navroute.a) r100).f460218f.getPriority(), ((com.suite.lark.component.navroute.a) r101).f460218f.getPriority());
    }
}
