package com.larus.dora.impl.assistant;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f332036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f332037b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f332038c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f332036a == r101.f332036a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f332037b, r101.f332037b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f332038c, r101.f332038c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f332036a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String r102 = this.f332037b;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f332038c;
        if (r106 == null) goto L15;
        r103 = r106.hashCode();
    L15:
        return r105 + r103;
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "AssistantWifiOperationResult(success=" + this.f332036a + ", errorCode=" + this.f332037b + ", errorMsg=" + this.f332038c + ')';
    }

    public b(boolean r100, String r101, String r102) {
        this.f332036a = r100;
        this.f332037b = r101;
        this.f332038c = r102;
    }
}
