package com.larus.common.account.bdauth.repository;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BDAuthorizeBlockingErrorType f325943a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L9;
        return false;
    L9:
        if (this.f325943a == ((d) r100).f325943a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f325943a.hashCode();
    }

    public final String toString() {
        return "BDAuthorizeBlockingError(type=" + this.f325943a + ')';
    }

    public final BDAuthorizeBlockingErrorType getType() {
        return this.f325943a;
    }

    public d(BDAuthorizeBlockingErrorType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f325943a = r100;
    }
}
