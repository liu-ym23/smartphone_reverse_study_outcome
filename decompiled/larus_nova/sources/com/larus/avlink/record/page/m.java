package com.larus.avlink.record.page;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a<List<i0>> f294269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f294270b;

    public /* synthetic */ m() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f294269a, r101.f294269a) == true) goto L12;
        return false;
    L12:
        if (this.f294270b == r101.f294270b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f294269a.hashCode() * 31;
        if (this.f294270b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "RecordMinutesFetchResult(dataState=" + this.f294269a + ", justEndedStillPending=" + this.f294270b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(a<? extends List<i0>> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "dataState");
        this.f294269a = r100;
        this.f294270b = r101;
    }
}
