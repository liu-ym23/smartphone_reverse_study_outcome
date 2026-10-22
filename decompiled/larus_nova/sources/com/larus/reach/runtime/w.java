package com.larus.reach.runtime;

import com.larus.reach.api.ReachRequestSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f367353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ns9.m f367354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ReachRequestSource f367355c;

    /* JADX WARN: Multi-variable type inference failed */
    public w() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L8;
        return false;
    L8:
        w r101 = (w) r100;
        if (Intrinsics.areEqual(this.f367353a, r101.f367353a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f367354b, r101.f367354b) == true) goto L15;
        return false;
    L15:
        if (this.f367355c == r101.f367355c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f367353a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        ns9.m r104 = this.f367354b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return ((r103 + r101) * 31) + this.f367355c.hashCode();
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ReachNotifyInput(cmdType=" + this.f367353a + ", reachNotify=" + this.f367354b + ", requestSource=" + this.f367355c + ')';
    }

    public /* synthetic */ w(Integer r100, ns9.m r101, int r102) {
        ReachRequestSource r103 = null;
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r102 & 4) == 0) goto L11;
        r103 = ReachRequestSource.SERVER_CMD;
    L11:
        this(r100, r101, r103);
    }

    public w(Integer r100, ns9.m r101, ReachRequestSource r102) {
        Intrinsics.checkNotNullParameter(r102, "requestSource");
        this.f367353a = r100;
        this.f367354b = r101;
        this.f367355c = r102;
    }
}
