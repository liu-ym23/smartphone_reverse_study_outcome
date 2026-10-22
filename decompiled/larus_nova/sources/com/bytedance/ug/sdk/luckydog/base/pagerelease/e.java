package com.bytedance.ug.sdk.luckydog.base.pagerelease;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, b> f271802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, b> f271803b;

    public e() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L10;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f271802a, r101.f271802a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f271803b, r101.f271803b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        HashMap<String, b> r100 = this.f271802a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        HashMap<String, b> r104 = this.f271803b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "OtherPageAppearStrategy(frontedScenes=" + this.f271802a + ", nativeScenes=" + this.f271803b + ")";
    }

    public /* synthetic */ e(int r100) {
        this(new HashMap(), new HashMap());
    }

    public e(HashMap<String, b> r100, HashMap<String, b> r101) {
        this.f271802a = r100;
        this.f271803b = r101;
    }
}
