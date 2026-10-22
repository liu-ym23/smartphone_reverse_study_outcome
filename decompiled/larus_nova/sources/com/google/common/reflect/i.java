package com.google.common.reflect;

import com.google.common.collect.Ordering;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes23.dex */
public final class i extends Ordering<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Comparator f275700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f275701b;

    public i(Ordering r100, Map r101) {
        this.f275700a = r100;
        this.f275701b = r101;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public final int compare(Object r100, Object r101) {
        Comparator r102 = this.f275700a;
        Object r103 = this.f275701b.get(r100);
        Objects.requireNonNull(r103);
        Object r104 = this.f275701b.get(r101);
        Objects.requireNonNull(r104);
        return r102.compare(r103, r104);
    }
}
