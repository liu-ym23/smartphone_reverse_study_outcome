package com.larus.agents.impl.webfetch;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f286866d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f286867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f286868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f286869c;

    public static final class a {
        public static l a(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            return new l(r101, null, r100);
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (this.f286867a == r101.f286867a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f286868b, r101.f286868b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f286869c, r101.f286869c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f286867a * 31;
        String r101 = this.f286868b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.f286869c.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "WebFetchOutcome(httpCode=" + this.f286867a + ", reason=" + this.f286869c + ')';
    }

    public l(int r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "reason");
        this.f286867a = r100;
        this.f286868b = r101;
        this.f286869c = r102;
    }
}
