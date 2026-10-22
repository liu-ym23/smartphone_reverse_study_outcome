package com.bytedance.iesgurd;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f250685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f250686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f250687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f250688d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f250689e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f250690f;

    public f() {
        this(0, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L18;
        f r101 = (f) r100;
        if (this.f250685a == r101.f250685a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f250686b, r101.f250686b) == true) goto L10;
        return false;
    L10:
        if (this.f250687c == r101.f250687c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f250688d, r101.f250688d) == true) goto L14;
        return false;
    L14:
        if (this.f250689e == r101.f250689e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f250690f, r101.f250690f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f250685a * 31;
        String r101 = this.f250686b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (((r100 + r103) * 31) + this.f250687c) * 31;
        String r105 = this.f250688d;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (((r104 + r106) * 31) + this.f250689e) * 31;
        String r108 = this.f250690f;
        if (r108 == null) goto L14;
        r102 = r108.hashCode();
    L14:
        return r107 + r102;
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "IESGurdResError(offlineCode=" + this.f250685a + ", offlineMessage=" + this.f250686b + ", cdnCode=" + this.f250687c + ", cdnMessage=" + this.f250688d + ", updateCode=" + this.f250689e + ", updateMessage=" + this.f250690f + ")";
    }

    public f(int r100, String r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this.f250685a = r100;
        this.f250686b = r101;
        this.f250687c = 0;
        this.f250688d = null;
        this.f250689e = 0;
        this.f250690f = null;
    }
}
