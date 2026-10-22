package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class h0 {
    private final G2OtaHomeCardAction action;
    private final String targetVersion;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h0) == true) goto L8;
        return false;
    L8:
        h0 r101 = (h0) r100;
        if (Intrinsics.areEqual(this.targetVersion, r101.targetVersion) == true) goto L12;
        return false;
    L12:
        if (this.action == r101.action) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.targetVersion.hashCode() * 31) + this.action.hashCode();
    }

    public final String toString() {
        return "G2OtaHomeCardState(targetVersion=" + this.targetVersion + ", action=" + this.action + ')';
    }

    public final G2OtaHomeCardAction a() {
        return this.action;
    }

    public final String b() {
        return this.targetVersion;
    }

    public h0(String r100, G2OtaHomeCardAction r101) {
        Intrinsics.checkNotNullParameter(r100, "targetVersion");
        Intrinsics.checkNotNullParameter(r101, "action");
        this.targetVersion = r100;
        this.action = r101;
    }
}
