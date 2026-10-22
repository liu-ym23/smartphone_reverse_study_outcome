package com.obric.miniapp.alarm;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class q {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f397480d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f397481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f397482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f397483c;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f397481a, r101.f397481a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f397482b, r101.f397482b) == true) goto L15;
        return false;
    L15:
        if (this.f397483c == r101.f397483c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f397481a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f397482b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (r103 + r101) * 31;
        if (this.f397483c == false) goto L13;
        int r106 = 1231;
    L15:
        return r105 + r106;
    L13:
        r106 = 1237;
        goto L15
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AlarmTtsPayload(eventName=" + this.f397481a + ", content=" + this.f397482b + ", isReport=" + this.f397483c + ')';
    }

    public q(String r100, String r101, boolean r102) {
        this.f397481a = r100;
        this.f397482b = r101;
        this.f397483c = r102;
    }
}
