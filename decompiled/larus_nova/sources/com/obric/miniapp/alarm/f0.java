package com.obric.miniapp.alarm;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<e0> f397461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f397462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f397463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f397464d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f397465e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f0) == true) goto L8;
        return false;
    L8:
        f0 r101 = (f0) r100;
        if (Intrinsics.areEqual(this.f397461a, r101.f397461a) == true) goto L12;
        return false;
    L12:
        if (this.f397462b == r101.f397462b) goto L15;
        return false;
    L15:
        if (this.f397463c == r101.f397463c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f397464d, r101.f397464d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f397465e, r101.f397465e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f397461a.hashCode() * 31;
        int r101 = 1231;
        if (this.f397462b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f397463c == true) goto L10;
        r101 = 1237;
    L10:
        int r104 = (r103 + r101) * 31;
        String r105 = this.f397464d;
        int r106 = 0;
        if (r105 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r104 + r107) * 31;
        Integer r109 = this.f397465e;
        if (r109 == null) goto L19;
        r106 = r109.hashCode();
    L19:
        return r108 + r106;
    L13:
        r107 = r105.hashCode();
        goto L14
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "PendingGroup(entries=" + this.f397461a + ", isBluetoothHeadSetConnected=" + this.f397462b + ", isDoraConnected=" + this.f397463c + ", deviceMacDigest=" + this.f397464d + ')';
    }

    public f0(List<e0> r100, boolean r101, boolean r102, String r103, Integer r104) {
        Intrinsics.checkNotNullParameter(r100, "entries");
        this.f397461a = r100;
        this.f397462b = r101;
        this.f397463c = r102;
        this.f397464d = r103;
        this.f397465e = r104;
    }
}
