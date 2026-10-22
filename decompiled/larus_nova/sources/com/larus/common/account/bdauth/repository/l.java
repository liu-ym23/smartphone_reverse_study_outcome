package com.larus.common.account.bdauth.repository;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f325952a;

    public l() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f325952a, ((l) r100).f325952a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f325952a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "BDAuthorizeSceneSnapshot(sceneKey=" + this.f325952a + ')';
    }

    public l(String r100) {
        this.f325952a = r100;
    }
}
