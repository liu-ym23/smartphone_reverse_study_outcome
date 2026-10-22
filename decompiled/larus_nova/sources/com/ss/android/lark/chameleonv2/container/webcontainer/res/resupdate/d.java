package com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate;

import com.ss.android.lark.vfs.VFSPath;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VFSPath f411279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f411280b;

    public d() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f411279a, r101.f411279a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f411280b, r101.f411280b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        VFSPath r100 = this.f411279a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f411280b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ChameleonResource(path=" + this.f411279a + ", version=" + this.f411280b + ')';
    }

    public d(VFSPath r100, String r101) {
        this.f411279a = r100;
        this.f411280b = r101;
    }
}
