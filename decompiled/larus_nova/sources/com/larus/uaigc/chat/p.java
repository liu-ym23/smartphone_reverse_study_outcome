package com.larus.uaigc.chat;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class p<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Comparator f371346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f371347b;

    public p(o r100, String r101) {
        this.f371346a = r100;
        this.f371347b = r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        int r102 = this.f371346a.compare(r100, r101);
        if (r102 == 0) goto L6;
        return r102;
    L6:
        if (Intrinsics.areEqual(((CreationVideoManagerViewModel.b) r100).f370397a, this.f371347b) == false) goto L8;
        int r103 = 0;
    L10:
        if (Intrinsics.areEqual(((CreationVideoManagerViewModel.b) r101).f370397a, this.f371347b) == false) goto L12;
        int r104 = 0;
    L14:
        return ComparisonsKt.compareValues(r103, r104);
    L12:
        r104 = 1;
        goto L14
    L8:
        r103 = 1;
        goto L10
    }
}
