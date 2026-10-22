package com.larus.setting.api;

import java.util.Comparator;
import java.util.Map;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes31.dex */
public final class g<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f367905a;

    public g(Map r100) {
        this.f367905a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        Integer r102 = (Integer) this.f367905a.get(((zs9.b) r100).f573490a);
        int r103 = Integer.MAX_VALUE;
        if (r102 == null) goto L5;
        int r104 = r102.intValue();
    L6:
        Integer r105 = Integer.valueOf(r104);
        Integer r106 = (Integer) this.f367905a.get(((zs9.b) r101).f573490a);
        if (r106 == null) goto L10;
        r103 = r106.intValue();
    L10:
        return ComparisonsKt.compareValues(r105, Integer.valueOf(r103));
    L5:
        r104 = Integer.MAX_VALUE;
        goto L6
    }
}
