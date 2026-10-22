package com.bytedance.ug.sdk.luckydog.base.pagerelease;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f271801a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L19:
        return true;
    L5:
        if ((r100 instanceof c) == false) goto L18;
        c r101 = (c) r100;
        r101.getClass();
        if (Intrinsics.areEqual(null, null) == false) goto L18;
        if (Intrinsics.areEqual(null, null) == false) goto L18;
        if (Intrinsics.areEqual(null, null) == false) goto L18;
        if (this.f271801a != r101.f271801a) goto L15;
        boolean r102 = true;
    L16:
        if (r102 == false) goto L18;
    L15:
        r102 = false;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    public final int hashCode() {
        boolean r100 = this.f271801a;
        ?? r101 = r100;
        if (r100 == false) goto L6;
        r101 = 1;
    L6:
        return 0 + r101;
    }

    public final String toString() {
        return "ContainerInfo(uri=null, path=null, container=null, isVisible=" + this.f271801a + ")";
    }

    public final Context getContext() {
        throw null;
    }
}
