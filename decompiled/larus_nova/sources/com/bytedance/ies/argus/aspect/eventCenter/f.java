package com.bytedance.ies.argus.aspect.eventCenter;

import com.bytedance.sdk.xbridge.cn.auth.bean.AuthBridgeAccess;
import com.bytedance.sdk.xbridge.cn.auth.bean.FeAuthSource;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import ld7.m;

/* JADX INFO: loaded from: classes19.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AuthBridgeAccess f245857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Set<String> f245858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Set<String> f245859c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f245860d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, m> f245861e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f245862f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FeAuthConfigSource f245863g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f245864h;

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
        if (this.f245857a == r101.f245857a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f245858b, r101.f245858b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f245859c, r101.f245859c) == true) goto L18;
        return false;
    L18:
        if (this.f245860d == r101.f245860d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f245861e, r101.f245861e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f245862f, r101.f245862f) == true) goto L27;
        return false;
    L27:
        if (this.f245863g == r101.f245863g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f245864h, r101.f245864h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        return (((((((((((((this.f245857a.hashCode() * 31) + this.f245858b.hashCode()) * 31) + this.f245859c.hashCode()) * 31) + this.f245860d) * 31) + this.f245861e.hashCode()) * 31) + this.f245862f.hashCode()) * 31) + this.f245863g.hashCode()) * 31) + this.f245864h.hashCode();
    }

    public final String toString() {
        return "FeAuthConfig(access=" + this.f245857a + ", includedMethods=" + this.f245858b + ", excludedMethods=" + this.f245859c + ", secureAuthVersion=" + this.f245860d + ", methodCallLimits=" + this.f245861e + ", feId=" + this.f245862f + ", source=" + this.f245863g + ", feAuthSource=" + this.f245864h + ')';
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
        Map<String, m> r106 = MapsKt.emptyMap();
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
        this.f245857a = r100;
        this.f245858b = r104;
        this.f245859c = r105;
        this.f245860d = 0;
        this.f245861e = r106;
        this.f245862f = r107;
        this.f245863g = r101;
        this.f245864h = r103;
        new ConcurrentHashMap();
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
        this.f245862f = r100;
        if (r101 == null) goto L8;
        this.f245857a = r101.f508701d;
        this.f245858b = CollectionsKt.toSet(r101.f508702e);
        this.f245859c = CollectionsKt.toSet(r101.f508703f);
        this.f245860d = r101.f508705h;
        Map<String, m> r103 = r101.f508704g;
        if (r103 != null) goto L7;
        r103 = MapsKt.emptyMap();
    L7:
        this.f245861e = r103;
        this.f245864h = FeAuthSource.CONTENT_V2.getDesc();
    L8:
        this.f245863g = r102;
    }
}
