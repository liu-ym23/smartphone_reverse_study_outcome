package com.bytedance.badger.network;

import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f199082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f199083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Pair<String, String>> f199084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f199085d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L22:
        return true;
    L5:
        if ((r100 instanceof b0) == false) goto L21;
        b0 r101 = (b0) r100;
        if (this.f199082a != r101.f199082a) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L21;
        if (this.f199083b != r101.f199083b) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == false) goto L21;
        if (Intrinsics.areEqual(this.f199084c, r101.f199084c) == false) goto L21;
        if (Intrinsics.areEqual(this.f199085d, r101.f199085d) == false) goto L21;
    L14:
        r103 = false;
        goto L15
    L9:
        r102 = false;
    L21:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final int hashCode() {
        boolean r100 = this.f199082a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = ((r101 * 31) + this.f199083b) * 31;
        List<Pair<String, String>> r103 = this.f199084c;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        int r106 = (r102 + r105) * 31;
        String r107 = this.f199085d;
        if (r107 == null) goto L13;
        r104 = r107.hashCode();
    L13:
        return r106 + r104;
    L8:
        r105 = 0;
        goto L9
    }

    public final String toString() {
        return "ResponseBundle(isSuccess=" + this.f199082a + ", status=" + this.f199083b + ", headers=" + this.f199084c + ", body=" + this.f199085d + ")";
    }

    public b0(boolean r100, int r101, List<Pair<String, String>> r102, String r103) {
        this.f199082a = r100;
        this.f199083b = r101;
        this.f199084c = r102;
        this.f199085d = r103;
    }
}
