package uk8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final rk8.a f550565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kc8.b f550566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f550567c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f550565a, r101.f550565a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f550566b, r101.f550566b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f550567c, r101.f550567c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f550565a.hashCode() * 31;
        kc8.b r101 = this.f550566b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.f550567c.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "ElapsedBlockVMData(blockModel=" + this.f550565a + ", blockDependConfig=" + this.f550566b + ", headerModel=" + this.f550567c + ')';
    }

    public d(rk8.a r100, kc8.b r101, b r102) {
        Intrinsics.checkNotNullParameter(r100, "blockModel");
        Intrinsics.checkNotNullParameter(r102, "headerModel");
        this.f550565a = r100;
        this.f550566b = r101;
        this.f550567c = r102;
    }
}
