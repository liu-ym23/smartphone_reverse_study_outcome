package com.bytedance.sdk.account.identitytoken;

import com.bytedance.sdk.account.utils.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f268932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f268933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f268934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f268935d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f268936e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f268937f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f268938g;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    public final int hashCode() {
        boolean r100 = this.f268932a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        String r103 = this.f268933b;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        int r106 = (((((r102 + r105) * 31) + this.f268934c) * 31) + this.f268935d) * 31;
        String r107 = this.f268936e;
        if (r107 == null) goto L12;
        int r108 = r107.hashCode();
    L13:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f268937f;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f268938g;
        if (r113 == null) goto L21;
        r104 = r113.hashCode();
    L21:
        return r112 + r104;
    L16:
        r111 = 0;
        goto L17
    L12:
        r108 = 0;
        goto L13
    L8:
        r105 = 0;
        goto L9
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("IdentityTokenResponse(isSuccess=");
        r100.append(this.f268932a);
        r100.append(", identityToken=");
        String r101 = this.f268933b;
        if (r101 == null) goto L5;
        k r102 = new k(r101);
    L6:
        r100.append(r102);
        r100.append(", errorCode=");
        r100.append(this.f268934c);
        r100.append(", serverErrorCode=");
        r100.append(this.f268935d);
        r100.append(", errorMsg=");
        r100.append(this.f268936e);
        r100.append(", logId=");
        r100.append(this.f268937f);
        r100.append(", abTestGroup=");
        r100.append(this.f268938g);
        r100.append(")");
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L38:
        return true;
    L5:
        if ((r100 instanceof d) == false) goto L37;
        d r101 = (d) r100;
        if (this.f268932a != r101.f268932a) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L37;
        String r103 = this.f268933b;
        k r104 = null;
        if (r103 == null) goto L14;
        k r105 = new k(r103);
    L15:
        String r106 = r101.f268933b;
        if (r106 == null) goto L19;
        r104 = new k(r106);
    L19:
        if (Intrinsics.areEqual(r105, r104) == false) goto L37;
        if (this.f268934c != r101.f268934c) goto L23;
        boolean r107 = true;
    L24:
        if (r107 == false) goto L37;
        if (this.f268935d != r101.f268935d) goto L28;
        boolean r108 = true;
    L29:
        if (r108 == false) goto L37;
        if (Intrinsics.areEqual(this.f268936e, r101.f268936e) == false) goto L37;
        if (Intrinsics.areEqual(this.f268937f, r101.f268937f) == false) goto L37;
        if (Intrinsics.areEqual(this.f268938g, r101.f268938g) == false) goto L37;
    L28:
        r108 = false;
        goto L29
    L23:
        r107 = false;
        goto L24
    L14:
        r105 = null;
        goto L15
    L9:
        r102 = false;
    L37:
        return false;
    }

    public d(boolean r100, String r101, int r102, int r103, String r104, String r105, String r106) {
        this.f268932a = r100;
        this.f268933b = r101;
        this.f268934c = r102;
        this.f268935d = r103;
        this.f268936e = r104;
        this.f268937f = r105;
        this.f268938g = r106;
    }
}
