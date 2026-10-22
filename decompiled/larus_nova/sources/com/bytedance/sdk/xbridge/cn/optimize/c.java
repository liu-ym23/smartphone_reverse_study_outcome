package com.bytedance.sdk.xbridge.cn.optimize;

import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashSet<String> f269940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HashSet<String> f269941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HashSet<String> f269942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashSet<String> f269943d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashSet<String> f269944e;

    public c() {
        HashSet r100 = null;
        this(r100, r100, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f269940a, r101.f269940a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f269941b, r101.f269941b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f269942c, r101.f269942c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f269943d, r101.f269943d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f269944e, r101.f269944e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        HashSet<String> r100 = this.f269940a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        HashSet<String> r104 = this.f269941b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        HashSet<String> r107 = this.f269942c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        HashSet<String> r110 = this.f269943d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        HashSet<String> r113 = this.f269944e;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
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
        return "ThreadOptConfig(threadOptSchemas=" + this.f269940a + ", syncMethods=" + this.f269941b + ", asyncMethods=" + this.f269942c + ", mainThreadMethods=" + this.f269943d + ", mainThreadOptMethods=" + this.f269944e + ')';
    }

    public /* synthetic */ c(HashSet r100, HashSet r110, int r111) {
        if ((r111 & 1) == 0) goto L5;
        HashSet r101 = null;
    L7:
        if ((r111 & 4) == 0) goto L9;
        HashSet r102 = null;
    L10:
        this(r101, null, r102, null, null);
        return;
    L9:
        r102 = r110;
        goto L10
    L5:
        r101 = r100;
        goto L7
    }

    public c(HashSet<String> r100, HashSet<String> r101, HashSet<String> r102, HashSet<String> r103, HashSet<String> r104) {
        this.f269940a = r100;
        this.f269941b = r101;
        this.f269942c = r102;
        this.f269943d = r103;
        this.f269944e = r104;
    }
}
