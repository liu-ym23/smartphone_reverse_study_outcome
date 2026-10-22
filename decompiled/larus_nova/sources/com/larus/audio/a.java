package com.larus.audio;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f288322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f288323b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f288322a, r101.f288322a) == true) goto L12;
        return false;
    L12:
        if (this.f288323b == r101.f288323b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f288322a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        if (this.f288323b == false) goto L9;
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
        return "AsrFailResult(messageContent=" + this.f288322a + ", alterToVoiceSend=" + this.f288323b + ')';
    }

    public a(String r100, boolean r101) {
        this.f288322a = r100;
        this.f288323b = r101;
    }
}
