package ld7;

import com.bytedance.sdk.xbridge.cn.auth.bean.AuthBridgeAccess;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f508706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AuthBridgeAccess f508707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f508708c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f508709d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f508710e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f508706a, r101.f508706a) == true) goto L12;
        return false;
    L12:
        if (this.f508707b == r101.f508707b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f508708c, r101.f508708c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f508709d, r101.f508709d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f508710e, r101.f508710e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f508706a.hashCode() * 31) + this.f508707b.hashCode()) * 31) + this.f508708c.hashCode()) * 31) + this.f508709d.hashCode()) * 31;
        Long r101 = this.f508710e;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "AuthConfigV1Bean(pattern=" + this.f508706a + ", access=" + this.f508707b + ", included_methods=" + this.f508708c + ", excluded_methods=" + this.f508709d + ", feId=" + this.f508710e + ')';
    }

    public b(String r100, AuthBridgeAccess r101, List<String> r102, List<String> r103, Long r104) {
        Intrinsics.checkNotNullParameter(r100, "pattern");
        Intrinsics.checkNotNullParameter(r101, "access");
        Intrinsics.checkNotNullParameter(r102, "included_methods");
        Intrinsics.checkNotNullParameter(r103, "excluded_methods");
        this.f508706a = r100;
        this.f508707b = r101;
        this.f508708c = r102;
        this.f508709d = r103;
        this.f508710e = r104;
    }
}
