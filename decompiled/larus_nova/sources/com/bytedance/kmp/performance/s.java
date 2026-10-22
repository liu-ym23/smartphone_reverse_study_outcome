package com.bytedance.kmp.performance;

import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f252839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f252840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r f252841c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q f252842d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<String> f252843e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f252844f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<String> f252845g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f252846h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f252847i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final double f252848j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f252849k;

    public s() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (this.f252839a == r101.f252839a) goto L12;
        return false;
    L12:
        if (this.f252840b == r101.f252840b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f252841c, r101.f252841c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f252842d, r101.f252842d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f252843e, r101.f252843e) == true) goto L24;
        return false;
    L24:
        if (this.f252844f == r101.f252844f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f252845g, r101.f252845g) == true) goto L30;
        return false;
    L30:
        if (this.f252846h == r101.f252846h) goto L33;
        return false;
    L33:
        if (this.f252847i == r101.f252847i) goto L36;
        return false;
    L36:
        if (Double.compare(this.f252848j, r101.f252848j) == 0) goto L39;
        return false;
    L39:
        if (this.f252849k == r101.f252849k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(null, null) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f252839a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f252840b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (((((((r102 + r103) * 31) + this.f252841c.hashCode()) * 31) + this.f252842d.hashCode()) * 31) + this.f252843e.hashCode()) * 31;
        if (this.f252844f == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (((r104 + r105) * 31) + this.f252845g.hashCode()) * 31;
        if (this.f252846h == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.f252847i == true) goto L22;
        r100 = 1237;
    L22:
        int r109 = (r108 + r100) * 31;
        long r110 = Double.doubleToLongBits(this.f252848j);
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        long r112 = this.f252849k;
        return ((r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31) + 0;
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "KmpPerformanceConfig(enableTraceHook=" + this.f252839a + ", enableFrameMonitor=" + this.f252840b + ", memoryUpload=" + this.f252841c + ", memoryCollection=" + this.f252842d + ", ffiTraceWhitelist=" + this.f252843e + ", enableFfiTrace=" + this.f252844f + ", ffiTraceWhitelistPrefixes=" + this.f252845g + ", enableFfiTraceDiagLog=" + this.f252846h + ", enableFfiTraceAllApis=" + this.f252847i + ", ffiTraceAllApisSampleRate=" + this.f252848j + ", ffiTraceAllApisMinMainThreadDuration=" + this.f252849k + ", composeSceneEventCollector=null)";
    }

    public s(Object r100) {
        r r101 = new r(0);
        q r102 = new q(0);
        Set<String> r103 = SetsKt.emptySet();
        List<String> r104 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(r101, "memoryUpload");
        Intrinsics.checkNotNullParameter(r102, "memoryCollection");
        Intrinsics.checkNotNullParameter(r103, "ffiTraceWhitelist");
        Intrinsics.checkNotNullParameter(r104, "ffiTraceWhitelistPrefixes");
        this.f252839a = true;
        this.f252840b = true;
        this.f252841c = r101;
        this.f252842d = r102;
        this.f252843e = r103;
        this.f252844f = false;
        this.f252845g = r104;
        this.f252846h = false;
        this.f252847i = false;
        this.f252848j = 0.01d;
        this.f252849k = 10;
    }
}
