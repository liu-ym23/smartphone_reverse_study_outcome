package com.larus.uaigc.chat;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes31.dex */
public final class o<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f371345a;

    public o(Function1 r100) {
        this.f371345a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        Function1 r102 = this.f371345a;
        Comparable r103 = (Comparable) r102.invoke((CreationVideoManagerViewModel.b) r100);
        Function1 r104 = this.f371345a;
        return ComparisonsKt.compareValues(r103, (Comparable) r104.invoke((CreationVideoManagerViewModel.b) r101));
    }
}
