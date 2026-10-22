package com.obric.assistant.dora;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f389120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DoraBleDevice f389121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f389122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t39.d f389123d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f389120a, r101.f389120a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f389121b, r101.f389121b) == true) goto L15;
        return false;
    L15:
        if (this.f389122c == r101.f389122c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f389123d, r101.f389123d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f389120a.hashCode() * 31) + this.f389121b.hashCode()) * 31;
        if (this.f389122c == false) goto L5;
        int r101 = 1231;
    L7:
        return ((r100 + r101) * 31) + this.f389123d.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "PendingAutoBindRequest(requestId=" + this.f389120a + ", device=" + this.f389121b + ", isH=" + this.f389122c + ", doraDeviceInfo=" + this.f389123d + ')';
    }

    public i(String r100, DoraBleDevice r101, boolean r102, t39.d r103) {
        Intrinsics.checkNotNullParameter(r100, "requestId");
        Intrinsics.checkNotNullParameter(r101, "device");
        Intrinsics.checkNotNullParameter(r103, "doraDeviceInfo");
        this.f389120a = r100;
        this.f389121b = r101;
        this.f389122c = r102;
        this.f389123d = r103;
    }
}
