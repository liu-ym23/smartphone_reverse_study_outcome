package ld7;

import com.bytedance.sdk.xbridge.cn.auth.bean.AuthBridgeAccess;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthConfigType;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AuthConfigType f508698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f508699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f508700c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AuthBridgeAccess f508701d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<String> f508702e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<String> f508703f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, m> f508704g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f508705h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f508698a == r101.f508698a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f508699b, r101.f508699b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f508700c, r101.f508700c) == true) goto L18;
        return false;
    L18:
        if (this.f508701d == r101.f508701d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f508702e, r101.f508702e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f508703f, r101.f508703f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f508704g, r101.f508704g) == true) goto L30;
        return false;
    L30:
        if (this.f508705h == r101.f508705h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((this.f508698a.hashCode() * 31) + this.f508699b.hashCode()) * 31) + this.f508700c.hashCode()) * 31) + this.f508701d.hashCode()) * 31) + this.f508702e.hashCode()) * 31) + this.f508703f.hashCode()) * 31;
        Map<String, m> r101 = this.f508704g;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.f508705h;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "AuthConfigBean(type=" + this.f508698a + ", safe_urls=" + this.f508699b + ", public_key=" + this.f508700c + ", group=" + this.f508701d + ", included_methods=" + this.f508702e + ", excluded_methods=" + this.f508703f + ", method_call_limits=" + this.f508704g + ", fe_secure_auth_version=" + this.f508705h + ')';
    }

    public final AuthConfigType getType() {
        return this.f508698a;
    }

    public a(AuthConfigType r100, List<String> r101, n r102, AuthBridgeAccess r103, List<String> r104, List<String> r105, Map<String, m> r106, int r107) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "safe_urls");
        Intrinsics.checkNotNullParameter(r102, "public_key");
        Intrinsics.checkNotNullParameter(r103, "group");
        Intrinsics.checkNotNullParameter(r104, "included_methods");
        Intrinsics.checkNotNullParameter(r105, "excluded_methods");
        this.f508698a = r100;
        this.f508699b = r101;
        this.f508700c = r102;
        this.f508701d = r103;
        this.f508702e = r104;
        this.f508703f = r105;
        this.f508704g = r106;
        this.f508705h = r107;
    }
}
