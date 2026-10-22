package com.larus.setting.api;

import java.util.Comparator;
import java.util.Map;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes31.dex */
public final class f<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f367904a;

    public f(Map r100) {
        this.f367904a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        Integer r102 = (Integer) this.f367904a.get(((zs9.c) r100).f573498a);
        int r103 = Integer.MAX_VALUE;
        if (r102 == null) goto L5;
        int r104 = r102.intValue();
    L6:
        Integer r105 = Integer.valueOf(r104);
        Integer r106 = (Integer) this.f367904a.get(((zs9.c) r101).f573498a);
        if (r106 == null) goto L10;
        r103 = r106.intValue();
    L10:
        return ComparisonsKt.compareValues(r105, Integer.valueOf(r103));
    L5:
        r104 = Integer.MAX_VALUE;
        goto L6
    }
}
