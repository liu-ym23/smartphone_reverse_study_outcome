package com.larus.bmhome.share.panel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f313961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f313962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f313963c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f313961a, r101.f313961a) == true) goto L12;
        return false;
    L12:
        if (this.f313962b == r101.f313962b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f313963c, r101.f313963c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f313961a.hashCode() * 31;
        if (this.f313962b == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        String r103 = this.f313963c;
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
        return "SharePanelItemEnableState(channel=" + this.f313961a + ", enableStatus=" + this.f313962b + ", disableTip=" + this.f313963c + ')';
    }

    public j(String r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        this.f313961a = r100;
        this.f313962b = r101;
        this.f313963c = r102;
    }
}
