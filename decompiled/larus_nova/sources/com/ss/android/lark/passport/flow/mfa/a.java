package com.ss.android.lark.passport.flow.mfa;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExternalBidpCallbackPhase f437883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f437884b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f437883a == r101.f437883a) goto L12;
        return false;
    L12:
        if (this.f437884b == r101.f437884b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f437883a.hashCode() * 31;
        long r101 = this.f437884b;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "ExternalBidpCallbackStatus(phase=" + this.f437883a + ", attempt=" + this.f437884b + ')';
    }

    public a(ExternalBidpCallbackPhase r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "phase");
        this.f437883a = r100;
        this.f437884b = r101;
    }

    public static a a(a r100, ExternalBidpCallbackPhase r101) {
        long r102 = r100.f437884b;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "phase");
        return new a(r101, r102);
    }
}
