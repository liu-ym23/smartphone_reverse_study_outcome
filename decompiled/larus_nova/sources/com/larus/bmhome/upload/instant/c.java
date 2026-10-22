package com.larus.bmhome.upload.instant;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f314772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f314773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f314774c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f314775d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f314776e;

    public c() {
        this(null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f314772a, r101.f314772a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f314773b, r101.f314773b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f314774c, r101.f314774c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f314775d, r101.f314775d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f314772a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f314773b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f314774c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, String> r110 = this.f314775d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ImageInstantUploadPolicyId(family=" + this.f314772a + ", digest=" + this.f314773b + ", schemaVersion=" + this.f314774c + ", definition=" + this.f314775d + ')';
    }

    public final String a() {
        return this.f314772a;
    }

    public final String b() {
        return this.f314776e;
    }

    public c(String r100, String r101, Integer r102, Map<String, String> r103) {
        this.f314772a = r100;
        this.f314773b = r101;
        this.f314774c = r102;
        this.f314775d = r103;
        StringBuilder r104 = new StringBuilder("standard:");
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r104.append(r100);
        r104.append(':');
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        r104.append(r101);
        r104.append(":v");
        if (r102 == null) goto L11;
        int r105 = r102.intValue();
    L12:
        r104.append(r105);
        this.f314776e = r104.toString();
        return;
    L11:
        r105 = 0;
        goto L12
    }
}
