package com.larus.uaigc.service;

import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f374001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f374002b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z) == true) goto L8;
        return false;
    L8:
        z r101 = (z) r100;
        if (this.f374001a == r101.f374001a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f374002b, r101.f374002b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f374001a * 31) + this.f374002b.hashCode();
    }

    public final String toString() {
        return "NotifyItem(imageResId=" + this.f374001a + ", clickCallback=" + this.f374002b + ')';
    }

    public z(c r100) {
        Intrinsics.checkNotNullParameter(r100, "clickCallback");
        this.f374001a = R.drawable.larus_community_share_aweme;
        this.f374002b = r100;
    }
}
