package com.larus.uaigc.music.applet;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class v1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f373654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f373655b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v1) == true) goto L8;
        return false;
    L8:
        v1 r101 = (v1) r100;
        if (Intrinsics.areEqual(this.f373654a, r101.f373654a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f373655b, r101.f373655b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f373654a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f373655b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "SendFinishedEvent(conversationId=" + this.f373654a + ", sourceSessionId=" + this.f373655b + ')';
    }

    public v1(String r100, String r101) {
        this.f373654a = r100;
        this.f373655b = r101;
    }
}
