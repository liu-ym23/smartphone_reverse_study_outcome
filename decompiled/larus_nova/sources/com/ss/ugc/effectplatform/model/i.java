package com.ss.ugc.effectplatform.model;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f457427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f457428b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L10;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f457427a, r101.f457427a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f457428b, r101.f457428b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        List<String> r100 = this.f457427a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f457428b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "UrlModelWithPrefix(url_prefix=" + this.f457427a + ", uri=" + this.f457428b + ")";
    }

    public i() {
        this(new ArrayList(), null);
    }

    public i(List<String> r100, String r101) {
        this.f457427a = r100;
        this.f457428b = r101;
    }
}
