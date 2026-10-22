package com.larus.drive.biz.impl.file;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f341210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f341211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f341212c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f341213d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f341210a, r101.f341210a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f341211b, r101.f341211b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f341212c, r101.f341212c) == true) goto L18;
        return false;
    L18:
        if (this.f341213d == r101.f341213d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f341210a.hashCode() * 31;
        String r101 = this.f341211b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f341212c;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        int r106 = (r104 + r102) * 31;
        if (this.f341213d == false) goto L13;
        int r107 = 1231;
    L15:
        return r106 + r107;
    L13:
        r107 = 1237;
        goto L15
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "DriveSelectedFile(uri=" + this.f341210a + ", displayName=" + this.f341211b + ", mimeType=" + this.f341212c + ", parseFailed=" + this.f341213d + ')';
    }

    public i(Uri r100, String r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        this.f341210a = r100;
        this.f341211b = r101;
        this.f341212c = r102;
        this.f341213d = r103;
    }
}
