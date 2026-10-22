package com.bytedance.badger.network;

import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f199070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Pair<String, String>> f199071b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f199072c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a0) == false) goto L12;
        a0 r101 = (a0) r100;
        if (Intrinsics.areEqual(this.f199070a, r101.f199070a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f199071b, r101.f199071b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f199072c, r101.f199072c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f199070a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<Pair<String, String>> r104 = this.f199071b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, String> r107 = this.f199072c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "RequestBundle(url=" + this.f199070a + ", headers=" + this.f199071b + ", body=" + this.f199072c + ")";
    }

    public a0(String r100, List<Pair<String, String>> r101, Map<String, String> r102) {
        this.f199070a = r100;
        this.f199071b = r101;
        this.f199072c = r102;
    }
}
