package com.larus.bmhome.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class u3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f315123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f315124b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u3) == true) goto L8;
        return false;
    L8:
        u3 r101 = (u3) r100;
        if (Intrinsics.areEqual(this.f315123a, r101.f315123a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f315124b, r101.f315124b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f315123a.hashCode() * 31;
        String r101 = this.f315124b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "TaskKey(conversationId=" + this.f315123a + ", pageScopeId=" + this.f315124b + ')';
    }

    public u3(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        this.f315123a = r100;
        this.f315124b = r101;
    }
}
