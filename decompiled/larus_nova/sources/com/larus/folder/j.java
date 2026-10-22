package com.larus.folder;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f343630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f343631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f343632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f343633d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f343634e;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f343630a, r101.f343630a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f343631b, r101.f343631b) == true) goto L15;
        return false;
    L15:
        if (this.f343632c == r101.f343632c) goto L18;
        return false;
    L18:
        if (this.f343633d == r101.f343633d) goto L21;
        return false;
    L21:
        if (this.f343634e == r101.f343634e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f343630a.hashCode() * 31) + this.f343631b.hashCode()) * 31;
        int r101 = 1231;
        if (this.f343632c == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f343633d == true) goto L11;
        r101 = 1237;
    L11:
        return ((r103 + r101) * 31) + this.f343634e;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "FolderItem(name=" + this.f343630a + ", path=" + this.f343631b + ", notUseFolder=" + this.f343632c + ", isLoading=" + this.f343633d + ", loadingIndex=" + this.f343634e + ')';
    }

    public /* synthetic */ j(String r100, String r110, boolean r111, int r112) {
        if ((r112 & 4) == 0) goto L5;
        boolean r101 = false;
    L7:
        if ((r112 & 16) == 0) goto L9;
        int r102 = -1;
    L10:
        this(r100, r110, r101, false, r102);
        return;
    L9:
        r102 = 0;
        goto L10
    L5:
        r101 = r111;
        goto L7
    }

    public j(String r100, String r101, boolean r102, boolean r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "path");
        this.f343630a = r100;
        this.f343631b = r101;
        this.f343632c = r102;
        this.f343633d = r103;
        this.f343634e = r104;
    }
}
