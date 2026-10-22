package com.bytedance.ee.bear.office.common.screenmenu;

import java.util.Comparator;
import kotlin.Pair;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class p<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Comparator f235242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f235243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f235244c;

    public p(o r100, boolean r101, int r102) {
        this.f235242a = r100;
        this.f235243b = r101;
        this.f235244c = r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        int r102 = this.f235242a.compare(r100, r101);
        if (r102 != 0) goto L19;
        Pair r103 = (Pair) r100;
        if (this.f235243b == true) goto L8;
    L10:
        int r104 = 1;
    L11:
        Pair r105 = (Pair) r101;
        if (this.f235243b == true) goto L14;
    L16:
        int r106 = 1;
    L18:
        return ComparisonsKt.compareValues(r104, r106);
    L14:
        if (((Number) r105.getFirst()).intValue() != this.f235244c) goto L16;
        r106 = 0;
        goto L18
    L8:
        if (((Number) r103.getFirst()).intValue() != this.f235244c) goto L10;
        r104 = 0;
        goto L11
    L19:
        return r102;
    }
}
