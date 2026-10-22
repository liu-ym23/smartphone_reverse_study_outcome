package com.bytedance.sdk.xbridge.cn.auth;

import com.bytedance.sdk.xbridge.cn.auth.bean.AuthBridgeAccess;
import com.bytedance.sdk.xbridge.cn.auth.bean.FeAuthConfigSource;
import com.bytedance.sdk.xbridge.cn.auth.bean.FeAuthSource;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AuthBridgeAccess f269839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Set<String> f269840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Set<String> f269841c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f269842d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, ld7.m> f269843e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f269844f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FeAuthConfigSource f269845g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f269846h;

    public f() {
        this(null, null, 255);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f269839a == r101.f269839a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f269840b, r101.f269840b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f269841c, r101.f269841c) == true) goto L18;
        return false;
    L18:
        if (this.f269842d == r101.f269842d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f269843e, r101.f269843e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f269844f, r101.f269844f) == true) goto L27;
        return false;
    L27:
        if (this.f269845g == r101.f269845g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f269846h, r101.f269846h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        return (((((((((((((this.f269839a.hashCode() * 31) + this.f269840b.hashCode()) * 31) + this.f269841c.hashCode()) * 31) + this.f269842d) * 31) + this.f269843e.hashCode()) * 31) + this.f269844f.hashCode()) * 31) + this.f269845g.hashCode()) * 31) + this.f269846h.hashCode();
    }

    public final String toString() {
        return "FeAuthConfig(access=" + this.f269839a + ", includedMethods=" + this.f269840b + ", excludedMethods=" + this.f269841c + ", secureAuthVersion=" + this.f269842d + ", methodCallLimits=" + this.f269843e + ", feId=" + this.f269844f + ", source=" + this.f269845g + ", feAuthSource=" + this.f269846h + ')';
    }

    public f(AuthBridgeAccess r100, FeAuthConfigSource r101, int r102) {
        if ((r102 & 1) == 0) goto L5;
        r100 = AuthBridgeAccess.PUBLIC;
    L5:
        String r103 = null;
        if ((r102 & 2) == 0) goto L8;
        Set<String> r104 = SetsKt.emptySet();
    L10:
        if ((r102 & 4) == 0) goto L12;
        Set<String> r105 = SetsKt.emptySet();
    L14:
        if ((r102 & 16) == 0) goto L16;
        Map<String, ld7.m> r106 = MapsKt.emptyMap();
    L18:
        if ((r102 & 32) == 0) goto L20;
        String r107 = "0";
    L22:
        if ((r102 & 64) == 0) goto L25;
        r101 = FeAuthConfigSource.UN_KNOWN;
    L25:
        if ((r102 & 128) == 0) goto L27;
        r103 = FeAuthSource.NULL.getDesc();
    L27:
        Intrinsics.checkNotNullParameter(r100, "access");
        Intrinsics.checkNotNullParameter(r104, "includedMethods");
        Intrinsics.checkNotNullParameter(r105, "excludedMethods");
        Intrinsics.checkNotNullParameter(r106, "methodCallLimits");
        Intrinsics.checkNotNullParameter(r107, "feId");
        Intrinsics.checkNotNullParameter(r101, "source");
        Intrinsics.checkNotNullParameter(r103, "feAuthSource");
        this.f269839a = r100;
        this.f269840b = r104;
        this.f269841c = r105;
        this.f269842d = 0;
        this.f269843e = r106;
        this.f269844f = r107;
        this.f269845g = r101;
        this.f269846h = r103;
        return;
    L20:
        r107 = null;
        goto L22
    L16:
        r106 = null;
        goto L18
    L12:
        r105 = null;
        goto L14
    L8:
        r104 = null;
        goto L10
    }

    public final void a(String r100, ld7.a r101, FeAuthConfigSource r102) {
        Intrinsics.checkNotNullParameter(r100, "authFeId");
        Intrinsics.checkNotNullParameter(r102, "updateSource");
        this.f269844f = r100;
        this.f269839a = r101.f508701d;
        this.f269840b = CollectionsKt.toSet(r101.f508702e);
        this.f269841c = CollectionsKt.toSet(r101.f508703f);
        this.f269842d = r101.f508705h;
        Map<String, ld7.m> r103 = r101.f508704g;
        if (r103 != null) goto L5;
        r103 = MapsKt.emptyMap();
    L5:
        this.f269843e = r103;
        this.f269846h = FeAuthSource.CONTENT_V2.getDesc();
        this.f269845g = r102;
    }
}
