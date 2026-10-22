package com.larus.uaigc.chat;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes31.dex */
public final class q<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Comparator f371348a;

    public q(p r100) {
        this.f371348a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        int r102 = this.f371348a.compare(r100, r101);
        if (r102 == 0) goto L6;
        return r102;
    L6:
        return ComparisonsKt.compareValues(((CreationVideoManagerViewModel.b) r100).f370397a, ((CreationVideoManagerViewModel.b) r101).f370397a);
    }
}
