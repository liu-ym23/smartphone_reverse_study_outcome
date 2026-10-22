package com.obric.assistant.cocreationreview;

import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ModuleKey f387705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f387706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f387707c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f387708d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r0) == true) goto L8;
        return false;
    L8:
        r0 r101 = (r0) r100;
        if (this.f387705a == r101.f387705a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f387706b, r101.f387706b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f387707c, r101.f387707c) == true) goto L18;
        return false;
    L18:
        if (this.f387708d == r101.f387708d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f387705a.hashCode() * 31) + this.f387706b.hashCode()) * 31) + this.f387707c.hashCode()) * 31;
        long r101 = this.f387708d;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "CocreationReport(module=" + this.f387705a + ", issue=" + this.f387706b + ", content=" + this.f387707c + ", createdAt=" + this.f387708d + ')';
    }

    public r0(ModuleKey r100, String r101, String r102) {
        long r103 = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r100, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r101, "issue");
        Intrinsics.checkNotNullParameter(r102, "content");
        this.f387705a = r100;
        this.f387706b = r101;
        this.f387707c = r102;
        this.f387708d = r103;
    }
}
