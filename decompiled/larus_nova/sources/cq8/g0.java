package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f464841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f464842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f464843c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g0) == true) goto L8;
        return false;
    L8:
        g0 r101 = (g0) r100;
        if (this.f464841a == r101.f464841a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f464842b, r101.f464842b) == true) goto L15;
        return false;
    L15:
        if (this.f464843c == r101.f464843c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f464841a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.f464842b;
        if (r102 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r101 + r103) * 31;
        if (this.f464843c == false) goto L9;
        int r105 = 1231;
    L11:
        return r104 + r105;
    L9:
        r105 = 1237;
        goto L11
    L5:
        r103 = r102.hashCode();
        goto L6
    }

    public final String toString() {
        return "MenuTabItem(tabId=" + this.f464841a + ", name=" + this.f464842b + ", selected=" + this.f464843c + ')';
    }

    public g0(long r100, String r101, boolean r102) {
        this.f464841a = r100;
        this.f464842b = r101;
        this.f464843c = r102;
    }
}
