package com.larus.bmhome.upload.sdk.impl.engine;

import is8.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f314869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f314870b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f314869a, r101.f314869a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f314870b, r101.f314870b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f314869a.hashCode() * 31;
        l r101 = this.f314870b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "EngineUploadResult(remoteKey=" + this.f314869a + ", mediaMeta=" + this.f314870b + ')';
    }

    public b(String r100, l r101) {
        Intrinsics.checkNotNullParameter(r100, "remoteKey");
        this.f314869a = r100;
        this.f314870b = r101;
    }
}
