package com.larus.bmhome.chat;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class d5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f302085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f302086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f302087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Boolean f302088d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f302089e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f302090f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d5) == true) goto L8;
        return false;
    L8:
        d5 r101 = (d5) r100;
        if (Intrinsics.areEqual(this.f302085a, r101.f302085a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f302086b, r101.f302086b) == true) goto L15;
        return false;
    L15:
        if (this.f302087c == r101.f302087c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f302088d, r101.f302088d) == true) goto L21;
        return false;
    L21:
        if (this.f302089e == r101.f302089e) goto L24;
        return false;
    L24:
        if (this.f302090f == r101.f302090f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f302085a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Uri r104 = this.f302086b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        int r107 = 1231;
        if (this.f302087c == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.f302088d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        int r111 = (r109 + r101) * 31;
        if (this.f302089e == false) goto L21;
        int r112 = 1231;
    L22:
        int r113 = (r111 + r112) * 31;
        if (this.f302090f == true) goto L27;
        r107 = 1237;
    L27:
        return r113 + r107;
    L21:
        r112 = 1237;
        goto L22
    L13:
        r108 = 1237;
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "SendImgLoadResult(tosKey=" + this.f302085a + ", uri=" + this.f302086b + ", isLocalFile=" + this.f302087c + ", result=" + this.f302088d + ", isFromCache=" + this.f302089e + ", isFromDrive=" + this.f302090f + ')';
    }

    public final void setResult(Boolean r100) {
        this.f302088d = r100;
    }

    public d5(String r100, Uri r101, boolean r102, boolean r103, int r104) {
        if ((r104 & 32) == 0) goto L5;
        r103 = false;
    L5:
        this.f302085a = r100;
        this.f302086b = r101;
        this.f302087c = r102;
        this.f302088d = null;
        this.f302089e = false;
        this.f302090f = r103;
    }
}
