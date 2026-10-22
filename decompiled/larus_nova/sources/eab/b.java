package eab;

import kotlin.jvm.internal.Intrinsics;
import v7b.f0;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class b extends s {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f471735j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f471736k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f471737l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f471735j == r101.f471735j) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f471736k, r101.f471736k) == true) goto L15;
        return false;
    L15:
        if (this.f471737l == r101.f471737l) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f471735j;
        return (((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f471736k.hashCode()) * 31) + this.f471737l;
    }

    @Override // v7b.s
    public final String toString() {
        return "AtUserGroupNode(userGroupId=" + this.f471735j + ", userGroupName=" + this.f471736k + ", permissionStatus=" + this.f471737l + ')';
    }

    @Override // v7b.s
    public final s h() {
        return new b(this.f471735j, this.f471736k, this.f471737l);
    }

    @Override // v7b.s
    public final void c(f0 r100) {
        if (r100 == null) goto L5;
        r100.a(this);
        return;
    }

    public b(long r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r101, "userGroupName");
        this.f471735j = r100;
        this.f471736k = r101;
        this.f471737l = r102;
    }
}
