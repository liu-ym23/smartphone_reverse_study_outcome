package com.ivy.ivykit.api.bridge;

import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f278302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f278303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f278304c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Object> f278305d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f278306e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f278307f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f278308g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f278309h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f278310i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f278311j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f278302a, r101.f278302a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f278303b, r101.f278303b) == true) goto L15;
        return false;
    L15:
        if (this.f278304c == r101.f278304c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f278305d, r101.f278305d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f278306e, r101.f278306e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f278307f, r101.f278307f) == true) goto L27;
        return false;
    L27:
        if (this.f278308g == r101.f278308g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f278309h, r101.f278309h) == true) goto L33;
        return false;
    L33:
        if (this.f278310i == r101.f278310i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f278311j, r101.f278311j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v23 */
    public final int hashCode() {
        int r100 = ((((this.f278302a.hashCode() * 31) + this.f278303b.hashCode()) * 31) + this.f278304c) * 31;
        Map<String, Object> r101 = this.f278305d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f278306e;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f278307f;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        boolean r111 = this.f278308g;
        ?? r112 = r111;
        if (r111 == false) goto L17;
        r112 = 1;
    L17:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f278309h;
        if (r114 == null) goto L21;
        r102 = r114.hashCode();
    L21:
        long r115 = this.f278310i;
        return ((((r113 + r102) * 31) + ((int) (r115 ^ (r115 >>> 32)))) * 31) + this.f278311j.hashCode();
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "IvyBridgeCallInfo(id=" + this.f278302a + ", methodName=" + this.f278303b + ", code=" + this.f278304c + ", params=" + this.f278305d + ", namespace=" + this.f278306e + ", message=" + this.f278307f + ", success=" + this.f278308g + ", url=" + this.f278309h + ", timestamp=" + this.f278310i + ", platformType=" + this.f278311j + ")";
    }

    public c(String r100, String r101, int r102, Map<String, ? extends Object> r103, String r104, String r105, boolean r106, String r107, long r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "methodName");
        Intrinsics.checkNotNullParameter(r111, Keys.API_PARAM_KEY_PLATFORM_TYPE);
        this.f278302a = r100;
        this.f278303b = r101;
        this.f278304c = r102;
        this.f278305d = r103;
        this.f278306e = r104;
        this.f278307f = r105;
        this.f278308g = r106;
        this.f278309h = r107;
        this.f278310i = r110;
        this.f278311j = r111;
    }
}
