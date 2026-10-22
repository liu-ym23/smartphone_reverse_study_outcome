package com.bytedance.timonbase.apicache;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f270793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f270794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f270795c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f270796d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object[] f270797e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f270798f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L18;
        a r101 = (a) r100;
        if (this.f270793a == r101.f270793a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f270794b, r101.f270794b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f270795c, r101.f270795c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f270796d, r101.f270796d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f270797e, r101.f270797e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f270798f, r101.f270798f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f270793a * 31;
        String r101 = this.f270794b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f270795c;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        Object r108 = this.f270796d;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        Object[] r111 = this.f270797e;
        if (r111 == null) goto L17;
        int r112 = Arrays.hashCode(r111);
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f270798f;
        if (r114 == null) goto L22;
        r102 = r114.hashCode();
    L22:
        return r113 + r102;
    L17:
        r112 = 0;
        goto L18
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "ApiArgs(id=" + this.f270793a + ", className=" + this.f270794b + ", memberName=" + this.f270795c + ", thisOrClass=" + this.f270796d + ", parameters=" + Arrays.toString(this.f270797e) + ", returnType=" + this.f270798f + ")";
    }

    public a(int r100, String r101, String r102, Object r103, Object[] r104, String r105) {
        this.f270793a = r100;
        this.f270794b = r101;
        this.f270795c = r102;
        this.f270796d = r103;
        this.f270797e = r104;
        this.f270798f = r105;
    }
}
