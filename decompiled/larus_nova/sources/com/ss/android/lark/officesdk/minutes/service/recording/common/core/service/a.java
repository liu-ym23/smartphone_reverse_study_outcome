package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f434265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f434266b;

    public a() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f434265a, r101.f434265a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f434266b, r101.f434266b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f434265a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f434266b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ForegroundNotificationContent(title=" + this.f434265a + ", content=" + this.f434266b + ')';
    }

    public a(String r100, String r101) {
        this.f434265a = r100;
        this.f434266b = r101;
    }
}
