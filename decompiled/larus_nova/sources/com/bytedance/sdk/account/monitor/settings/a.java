package com.bytedance.sdk.account.monitor.settings;

import ac7.g;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f269196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f269197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f269198c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f269199d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g f269200e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f269201f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set<String> f269202g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f269203h;

    public a() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L33:
        return true;
    L5:
        if ((r100 instanceof a) == false) goto L32;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f269196a, r101.f269196a) == false) goto L32;
        if (this.f269197b != r101.f269197b) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L32;
        if (Intrinsics.areEqual(this.f269198c, r101.f269198c) == false) goto L32;
        if (this.f269199d != r101.f269199d) goto L18;
        boolean r103 = true;
    L19:
        if (r103 == false) goto L32;
        if (Intrinsics.areEqual(this.f269200e, r101.f269200e) == false) goto L32;
        if (Intrinsics.areEqual(this.f269201f, r101.f269201f) == false) goto L32;
        if (Intrinsics.areEqual(this.f269202g, r101.f269202g) == false) goto L32;
        if (this.f269203h != r101.f269203h) goto L29;
        boolean r104 = true;
    L30:
        if (r104 == false) goto L32;
    L29:
        r104 = false;
        goto L30
    L18:
        r103 = false;
        goto L19
    L11:
        r102 = false;
    L32:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        b r100 = this.f269196a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f269197b) * 31;
        String r104 = this.f269198c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((r103 + r105) * 31) + this.f269199d) * 31;
        g r107 = this.f269200e;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f269201f;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Set<String> r113 = this.f269202g;
        if (r113 == null) goto L21;
        r101 = r113.hashCode();
    L21:
        int r114 = (r112 + r101) * 31;
        boolean r115 = this.f269203h;
        ?? r116 = r115;
        if (r115 == false) goto L25;
        r116 = 1;
    L25:
        return r114 + r116;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "EventConfig(parent=" + this.f269196a + ", sampleRate=" + this.f269197b + ", configVersion=" + this.f269198c + ", sampleMode=" + this.f269199d + ", sampleIf=" + this.f269200e + ", sampleGroup=" + this.f269201f + ", logParams=" + this.f269202g + ", logAllParams=" + this.f269203h + ")";
    }

    public a(b r100, int r101, int r102, g r103, String r104, Set r110, boolean r111, int r112) {
        if ((r112 & 2) == 0) goto L6;
        r101 = 1;
    L6:
        if ((r112 & 4) == 0) goto L8;
        String r105 = "";
    L10:
        if ((r112 & 8) == 0) goto L13;
        r102 = 0;
    L13:
        if ((r112 & 16) == 0) goto L16;
        r103 = null;
    L16:
        if ((r112 & 32) == 0) goto L19;
        r104 = null;
    L19:
        if ((r112 & 64) == 0) goto L22;
        r110 = null;
    L22:
        if ((r112 & 128) == 0) goto L24;
        r111 = false;
    L24:
        this.f269196a = r100;
        this.f269197b = r101;
        this.f269198c = r105;
        this.f269199d = r102;
        this.f269200e = r103;
        this.f269201f = r104;
        this.f269202g = r110;
        this.f269203h = r111;
        return;
    L8:
        r105 = null;
        goto L10
    }
}
