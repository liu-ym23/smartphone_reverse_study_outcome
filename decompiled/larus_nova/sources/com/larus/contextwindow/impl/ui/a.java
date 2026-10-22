package com.larus.contextwindow.impl.ui;

import com.larus.contextwindow.api.ContextWindowSnapshot;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ContextWindowSnapshot f330468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f330469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f330470c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f330468a, r101.f330468a) == true) goto L12;
        return false;
    L12:
        if (this.f330469b == r101.f330469b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f330470c, r101.f330470c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f330468a.hashCode() * 31;
        if (this.f330469b == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        j r103 = this.f330470c;
        if (r103 != null) goto L9;
        int r104 = 0;
    L11:
        return r102 + r104;
    L9:
        r104 = r103.hashCode();
        goto L11
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ContextWindowPanelState(contextSnapshot=" + this.f330468a + ", isContextCompressing=" + this.f330469b + ", membership=" + this.f330470c + ')';
    }

    public a(ContextWindowSnapshot r100, boolean r101, j r102) {
        Intrinsics.checkNotNullParameter(r100, "contextSnapshot");
        this.f330468a = r100;
        this.f330469b = r101;
        this.f330470c = r102;
    }
}
