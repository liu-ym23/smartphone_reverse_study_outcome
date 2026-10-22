package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.bytedance.ee.bear.contract.NetService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f241712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f241713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f241714c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f241715d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f241716e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final NetService f241717f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f241712a, r101.f241712a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f241713b, r101.f241713b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f241714c, r101.f241714c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f241715d, r101.f241715d) == true) goto L21;
        return false;
    L21:
        if (this.f241716e == r101.f241716e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f241717f, r101.f241717f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f241712a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f241713b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f241714c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f241715d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        if (this.f241716e == false) goto L21;
        int r113 = 1231;
    L22:
        int r114 = (r112 + r113) * 31;
        NetService r115 = this.f241717f;
        if (r115 == null) goto L27;
        r101 = r115.hashCode();
    L27:
        return r114 + r101;
    L21:
        r113 = 1237;
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "RenamePullerBean(newTitle=" + this.f241712a + ", wikiToken=" + this.f241713b + ", objToken=" + this.f241714c + ", objType=" + this.f241715d + ", isShortcut=" + this.f241716e + ", netService=" + this.f241717f + ')';
    }

    public q(String r100, String r101, String r102, Integer r103, boolean r104, NetService r105) {
        this.f241712a = r100;
        this.f241713b = r101;
        this.f241714c = r102;
        this.f241715d = r103;
        this.f241716e = r104;
        this.f241717f = r105;
    }
}
