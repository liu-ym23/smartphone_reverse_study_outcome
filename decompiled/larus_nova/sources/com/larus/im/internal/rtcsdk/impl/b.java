package com.larus.im.internal.rtcsdk.impl;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f349847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f349848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f349849c;

    public final String toString() {
        return "AudioExtraCache(source=" + Arrays.toString(this.f349847a) + ", extra=" + this.f349848b + ')';
    }

    public final int hashCode() {
        byte[] r100 = this.f349847a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = Arrays.hashCode(r100);
    L6:
        int r103 = r102 * 31;
        String r104 = this.f349848b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        byte[] r101 = this.f349847a;
        if (r101 == null) goto L17;
        byte[] r102 = ((b) r100).f349847a;
        if (r102 != null) goto L14;
        return false;
    L14:
        if (Arrays.equals(r101, r102) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f349848b, ((b) r100).f349848b) == true) goto L22;
        return false;
    L22:
        return true;
    L17:
        if (((b) r100).f349847a == null) goto L20;
        return false;
    }

    public b(byte[] r100, String r101) {
        this.f349847a = r100;
        this.f349848b = r101;
        this.f349849c = 1;
    }
}
