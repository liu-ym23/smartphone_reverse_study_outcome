package com.obric.miniapp.intent;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f397715d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f397716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f397717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f397718c;

    public static final class a {
        public static k b() {
            return new k(true, "", "");
        }

        public static k a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "errorCode");
            Intrinsics.checkNotNullParameter(r101, "errorMessage");
            return new k(false, r100, r101);
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (this.f397716a == r101.f397716a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f397717b, r101.f397717b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f397718c, r101.f397718c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f397716a == false) goto L5;
        int r100 = 1231;
    L7:
        return (((r100 * 31) + this.f397717b.hashCode()) * 31) + this.f397718c.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "IntentCardOperationResult(success=" + this.f397716a + ", errorCode=" + this.f397717b + ", errorMessage=" + this.f397718c + ')';
    }

    public k(boolean r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "errorCode");
        Intrinsics.checkNotNullParameter(r102, "errorMessage");
        this.f397716a = r100;
        this.f397717b = r101;
        this.f397718c = r102;
    }
}
