package gpc;

import com.bytedance.lark.pb.basic.v1.TenantNameStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f482141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TenantNameStatus f482142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f482143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f482144d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f482145e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f482141a, r101.f482141a) == true) goto L12;
        return false;
    L12:
        if (this.f482142b == r101.f482142b) goto L15;
        return false;
    L15:
        if (this.f482143c == r101.f482143c) goto L18;
        return false;
    L18:
        if (this.f482144d == r101.f482144d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f482145e, r101.f482145e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f482141a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        TenantNameStatus r104 = this.f482142b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        int r107 = 1231;
        if (this.f482143c == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r106 + r108) * 31;
        if (this.f482144d == true) goto L18;
        r107 = 1237;
    L18:
        int r110 = (r109 + r107) * 31;
        String r111 = this.f482145e;
        if (r111 == null) goto L23;
        r101 = r111.hashCode();
    L23:
        return r110 + r101;
    L13:
        r108 = 1237;
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "TenantNameData(tenantName=" + this.f482141a + ", tenantNameStatus=" + this.f482142b + ", isFriend=" + this.f482143c + ", ignoreTenantNameStatus=" + this.f482144d + ", chatterId=" + this.f482145e + ')';
    }

    public a(String r100, TenantNameStatus r101, boolean r102, String r103) {
        this.f482141a = r100;
        this.f482142b = r101;
        this.f482143c = r102;
        this.f482144d = false;
        this.f482145e = r103;
    }
}
