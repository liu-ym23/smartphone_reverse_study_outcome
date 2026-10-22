package com.larus.bmhome.resource.access;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f313726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f313727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ResourceMediaType f313728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f313729d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r0) == true) goto L8;
        return false;
    L8:
        r0 r101 = (r0) r100;
        if (Intrinsics.areEqual(this.f313726a, r101.f313726a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f313727b, r101.f313727b) == true) goto L15;
        return false;
    L15:
        if (this.f313728c == r101.f313728c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f313729d, r101.f313729d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f313726a.hashCode() * 31) + this.f313727b.hashCode()) * 31) + this.f313728c.hashCode()) * 31;
        String r101 = this.f313729d;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "ResourceTaskKey(scene=" + this.f313726a + ", resourceInputKey=" + this.f313727b + ", mediaType=" + this.f313728c + ", bizScope=" + this.f313729d + ')';
    }

    public r0(x r100, String r101, ResourceMediaType r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "resourceInputKey");
        Intrinsics.checkNotNullParameter(r102, "mediaType");
        this.f313726a = r100;
        this.f313727b = r101;
        this.f313728c = r102;
        this.f313729d = r103;
    }
}
