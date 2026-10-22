package com.larus.bmhome.view.actionbar.edit.component;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class j2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f316388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f316389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p1 f316390c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j2) == true) goto L8;
        return false;
    L8:
        j2 r101 = (j2) r100;
        if (Intrinsics.areEqual(this.f316388a, r101.f316388a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f316389b, r101.f316389b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f316390c, r101.f316390c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f316388a.hashCode() * 31;
        String r101 = this.f316389b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        p1 r105 = this.f316390c;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "StartParam(targetPageRouter=" + this.f316388a + ", selectedId=" + this.f316389b + ", mobParam=" + this.f316390c + ')';
    }

    public j2(String r100, String r101, p1 r102) {
        Intrinsics.checkNotNullParameter(r100, "targetPageRouter");
        this.f316388a = r100;
        this.f316389b = r101;
        this.f316390c = r102;
    }
}
