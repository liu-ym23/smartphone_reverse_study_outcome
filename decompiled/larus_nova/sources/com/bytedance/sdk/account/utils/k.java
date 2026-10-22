package com.bytedance.sdk.account.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f269548a;

    public final int hashCode() {
        String r100 = this.f269548a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return n.b(this.f269548a, 8);
    }

    public /* synthetic */ k(String r100) {
        this.f269548a = r100;
    }

    public final boolean equals(Object r100) {
        String r101 = this.f269548a;
        if ((r100 instanceof k) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r101, ((k) r100).f269548a) == false) goto L7;
        return true;
    }
}
