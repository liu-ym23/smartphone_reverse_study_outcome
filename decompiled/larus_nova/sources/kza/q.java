package kza;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f506809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f506810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f506811c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f506812d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f506813e;

    public q() {
        this(null, false, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f506809a, r101.f506809a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f506810b, r101.f506810b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f506811c, r101.f506811c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f506812d, r101.f506812d) == true) goto L21;
        return false;
    L21:
        if (this.f506813e == r101.f506813e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f506809a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f506810b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f506811c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f506812d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        int r111 = (r109 + r101) * 31;
        if (this.f506813e == false) goto L21;
        int r112 = 1231;
    L23:
        return r111 + r112;
    L21:
        r112 = 1237;
        goto L23
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "OpenFeishuMediaAuthorizationRequest(authEntityId=" + this.f506809a + ", resourceKey=" + this.f506810b + ", senderId=" + this.f506811c + ", senderTenantId=" + this.f506812d + ", requiresAuditCheck=" + this.f506813e + ')';
    }

    public q(String r100, boolean r101, int r102) {
        if ((r102 & 2) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 16) == 0) goto L8;
        r101 = false;
    L8:
        this.f506809a = null;
        this.f506810b = r100;
        this.f506811c = null;
        this.f506812d = null;
        this.f506813e = r101;
    }
}
