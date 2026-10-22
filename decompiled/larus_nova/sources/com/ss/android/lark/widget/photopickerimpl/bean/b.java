package com.ss.android.lark.widget.photopickerimpl.bean;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f447751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f447752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<String> f447753c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f447754d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f447755e;

    public final int hashCode() {
        return this.f447752b.hashCode();
    }

    public final String toString() {
        return "PhotoDir(name='" + this.f447752b + "', paths=" + this.f447753c + ", photoCount=" + this.f447754d + ", coverPhotoPath='" + this.f447755e + "')";
    }

    public b() {
        this.f447751a = 4096;
        this.f447752b = "";
        this.f447753c = new LinkedHashSet();
        this.f447755e = "";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L10;
        return false;
    L10:
        return Intrinsics.areEqual(this.f447752b, ((b) r100).f447752b);
    }
}
