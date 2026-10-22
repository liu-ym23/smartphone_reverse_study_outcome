package com.larus.business.arc.api;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f319917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f319918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f319919c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f319920d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f319921e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f319922f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final s f319923g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L8;
        return false;
    L8:
        t r101 = (t) r100;
        if (this.f319917a == r101.f319917a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f319918b, r101.f319918b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f319919c, r101.f319919c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f319920d, r101.f319920d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f319921e, r101.f319921e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f319922f, r101.f319922f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f319923g, r101.f319923g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        if (this.f319917a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((r100 * 31) + this.f319918b.hashCode()) * 31;
        String r102 = this.f319919c;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f319920d;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        String r109 = this.f319921e;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        String r112 = this.f319922f;
        if (r112 == null) goto L23;
        r103 = r112.hashCode();
    L23:
        return ((r111 + r103) * 31) + this.f319923g.hashCode();
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "ArcResponseParts(ok=" + this.f319917a + ", command=" + this.f319918b + ", code=" + this.f319919c + ", error=" + this.f319920d + ", group=" + this.f319921e + ", tool=" + this.f319922f + ", body=" + this.f319923g + ')';
    }

    public t(String r100, String r101, String r102) {
        s.c r103 = s.c.f319916a;
        Intrinsics.checkNotNullParameter(r100, "command");
        Intrinsics.checkNotNullParameter(r103, ContainerPosition.BODY);
        this.f319917a = false;
        this.f319918b = r100;
        this.f319919c = r101;
        this.f319920d = r102;
        this.f319921e = null;
        this.f319922f = null;
        this.f319923g = r103;
    }
}
