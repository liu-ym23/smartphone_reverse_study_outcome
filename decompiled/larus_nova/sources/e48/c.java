package e48;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f470997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f470998b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f470999c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f471000d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f470997a, r101.f470997a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f470998b, r101.f470998b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f470999c, r101.f470999c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f471000d, r101.f471000d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f470997a.hashCode() * 31;
        String r101 = this.f470998b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f470999c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f471000d;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "AccountSecurityConfirmRequest(riskDeviceId=" + this.f470997a + ", riskReason=" + this.f470998b + ", messageId=" + this.f470999c + ", enterMethod=" + this.f471000d + ')';
    }

    public c(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "riskDeviceId");
        this.f470997a = r100;
        this.f470998b = r101;
        this.f470999c = r102;
        this.f471000d = "foreground_dialog";
    }
}
