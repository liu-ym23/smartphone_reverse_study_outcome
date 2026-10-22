package com.larus.audio.call;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f289265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f289266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f289267c;

    public n() {
        this(null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f289265a, r101.f289265a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f289266b, r101.f289266b) == true) goto L15;
        return false;
    L15:
        if (this.f289267c == r101.f289267c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f289265a.hashCode() * 31) + this.f289266b.hashCode()) * 31) + this.f289267c;
    }

    public final String toString() {
        return "SceneModel(key=" + this.f289265a + ", speakerId=" + this.f289266b + ", listenWaitingTime=" + this.f289267c + ')';
    }

    public /* synthetic */ n(String r100, int r101) {
        String r102 = "";
        if ((r101 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r101 & 2) != 0) goto L9;
        r102 = null;
    L9:
        this(r100, r102, 0);
    }

    public n(String r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "speakerId");
        this.f289265a = r100;
        this.f289266b = r101;
        this.f289267c = r102;
    }
}
