package com.ss.android.lark.ug.business.badge;

import com.ss.android.lark.pb.ug_reach.BadgeMaterial;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f444419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BadgeMaterial f444420b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f444419a == r101.f444419a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f444420b, r101.f444420b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f444419a * 31) + this.f444420b.hashCode();
    }

    public final String toString() {
        return "BadgeInfo(badgeCount=" + this.f444419a + ", data=" + this.f444420b + ')';
    }

    public final a a(a r100) {
        if (r100 == null) goto L4;
        int r101 = r100.f444419a + this.f444419a;
    L6:
        return new a(r101, new BadgeMaterial.Builder().type(BadgeMaterial.BadgeType.RedPoint).build());
    L4:
        r101 = this.f444419a;
        goto L6
    }

    public a(int r100, BadgeMaterial r101) {
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f444419a = r100;
        this.f444420b = r101;
    }
}
