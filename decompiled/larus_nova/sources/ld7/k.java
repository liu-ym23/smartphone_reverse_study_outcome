package ld7;

import java.util.Arrays;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String[] f508750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<Integer> f508751b;

    public k() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f508750a, r101.f508750a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f508751b, r101.f508751b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String[] r100 = this.f508750a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (r101 * 31) + this.f508751b.hashCode();
    L5:
        r101 = Arrays.hashCode(r100);
        goto L7
    }

    public final String toString() {
        return "LynxAuthStrategyConfig(lynxSignVerifyWhiteList=" + Arrays.toString(this.f508750a) + ", forceDegradeCodeList=" + this.f508751b + ')';
    }

    public k(Object r100) {
        List<Integer> r101 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(r101, "forceDegradeCodeList");
        this.f508750a = null;
        this.f508751b = r101;
    }
}
