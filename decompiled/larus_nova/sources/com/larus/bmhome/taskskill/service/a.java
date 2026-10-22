package com.larus.bmhome.taskskill.service;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f314427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f314428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f314429c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f314430d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f314431e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f314432f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f314427a, r101.f314427a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f314428b, r101.f314428b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f314429c, r101.f314429c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f314430d, r101.f314430d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f314431e, r101.f314431e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f314432f, r101.f314432f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f314427a.hashCode() * 31) + this.f314428b.hashCode()) * 31;
        String r101 = this.f314429c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f314430d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f314431e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f314432f;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "CreatedProject(projectId=" + this.f314427a + ", name=" + this.f314428b + ", deviceId=" + this.f314429c + ", deviceName=" + this.f314430d + ", folderName=" + this.f314431e + ", workspace=" + this.f314432f + ')';
    }

    public a(String r100, String r101, String r102, String r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "projectId");
        Intrinsics.checkNotNullParameter(r101, "name");
        this.f314427a = r100;
        this.f314428b = r101;
        this.f314429c = r102;
        this.f314430d = r103;
        this.f314431e = r104;
        this.f314432f = r105;
    }
}
