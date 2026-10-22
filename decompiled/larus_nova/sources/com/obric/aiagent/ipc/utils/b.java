package com.obric.aiagent.ipc.utils;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<IPCAnomalyType> f384723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f384724b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f384723a, r101.f384723a) == true) goto L12;
        return false;
    L12:
        if (this.f384724b == r101.f384724b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f384723a.hashCode() * 31) + this.f384724b;
    }

    public final String toString() {
        return "IPCAnomalyDecision(anomalyTypes=" + this.f384723a + ", windowCount=" + this.f384724b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(List<? extends IPCAnomalyType> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "anomalyTypes");
        this.f384723a = r100;
        this.f384724b = r101;
    }
}
