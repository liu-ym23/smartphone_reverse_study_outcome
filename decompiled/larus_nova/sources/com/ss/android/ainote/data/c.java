package com.ss.android.ainote.data;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f406709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f406710b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f406709a, r101.f406709a) == true) goto L12;
        return false;
    L12:
        if (this.f406710b == r101.f406710b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.f406709a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        if (this.f406710b == false) goto L9;
        int r103 = 1231;
    L11:
        return r102 + r103;
    L9:
        r103 = 1237;
        goto L11
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AINoteSaveSwitchStatus(isOn=" + this.f406709a + ", featureEnabled=" + this.f406710b + ')';
    }

    public c(Boolean r100, boolean r101) {
        this.f406709a = r100;
        this.f406710b = r101;
    }
}
