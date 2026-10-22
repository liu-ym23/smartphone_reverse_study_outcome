package com.larus.bmhome.resource.access;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f313716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ResourcePhase f313717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ResourceNodeStatus f313718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f313719d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f313720e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, String> f313721f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q0) == true) goto L8;
        return false;
    L8:
        q0 r101 = (q0) r100;
        if (Intrinsics.areEqual(this.f313716a, r101.f313716a) == true) goto L12;
        return false;
    L12:
        if (this.f313717b == r101.f313717b) goto L15;
        return false;
    L15:
        if (this.f313718c == r101.f313718c) goto L18;
        return false;
    L18:
        if (this.f313719d == r101.f313719d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f313720e, r101.f313720e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f313721f, r101.f313721f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f313716a.hashCode() * 31) + this.f313717b.hashCode()) * 31) + this.f313718c.hashCode()) * 31;
        long r101 = this.f313719d;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        String r103 = this.f313720e;
        if (r103 != null) goto L5;
        int r104 = 0;
    L7:
        return ((r102 + r104) * 31) + this.f313721f.hashCode();
    L5:
        r104 = r103.hashCode();
        goto L7
    }

    public final String toString() {
        return "ResourceNodeState(nodeKey=" + this.f313716a + ", phase=" + this.f313717b + ", status=" + this.f313718c + ", costMs=" + this.f313719d + ", errorCode=" + this.f313720e + ", attributes=" + this.f313721f + ')';
    }

    public q0(String r100, ResourcePhase r101, ResourceNodeStatus r102, long r103, String r104, Map<String, String> r105) {
        Intrinsics.checkNotNullParameter(r100, "nodeKey");
        Intrinsics.checkNotNullParameter(r101, "phase");
        Intrinsics.checkNotNullParameter(r102, "status");
        Intrinsics.checkNotNullParameter(r105, "attributes");
        this.f313716a = r100;
        this.f313717b = r101;
        this.f313718c = r102;
        this.f313719d = r103;
        this.f313720e = r104;
        this.f313721f = r105;
    }
}
