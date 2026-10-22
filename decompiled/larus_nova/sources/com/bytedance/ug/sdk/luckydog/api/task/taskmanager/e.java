package com.bytedance.ug.sdk.luckydog.api.task.taskmanager;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f271705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f271706b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L15:
        return true;
    L5:
        if ((r100 instanceof e) == false) goto L14;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f271705a, r101.f271705a) == false) goto L14;
        if (this.f271706b != r101.f271706b) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L14;
    L11:
        r102 = false;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final int hashCode() {
        f r100 = this.f271705a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = r101 * 31;
        boolean r103 = this.f271706b;
        ?? r104 = r103;
        if (r103 == false) goto L10;
        r104 = 1;
    L10:
        return r102 + r104;
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "FullPathInfo(params=" + this.f271705a + ", canAddHostEvent=" + this.f271706b + ")";
    }

    public e(f r100) {
        this.f271705a = r100;
        this.f271706b = false;
    }
}
