package com.larus.bmhome.chat.api;

import com.larus.network.http.AsyncThrowable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larus.bmhome.auth.a f297183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f297184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AsyncThrowable f297185c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f297183a, r101.f297183a) == true) goto L12;
        return false;
    L12:
        if (this.f297184b == r101.f297184b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f297185c, r101.f297185c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        com.larus.bmhome.auth.a r100 = this.f297183a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f297184b) * 31;
        AsyncThrowable r104 = this.f297185c;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AppLaunchInfoWithStatus(data=" + this.f297183a + ", status=" + this.f297184b + ", error=" + this.f297185c + ')';
    }

    public a(com.larus.bmhome.auth.a r100, int r101, AsyncThrowable r102) {
        this.f297183a = r100;
        this.f297184b = r101;
        this.f297185c = r102;
        if (r100 == null) goto L5;
        return;
    L5:
        if (r101 == 2) goto L8;
        return;
    L8:
        throw new IllegalArgumentException();
    }

    public static a a(a r100, com.larus.bmhome.auth.a r101, int r102, AsyncThrowable r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.f297183a;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.f297184b;
    L9:
        if ((r104 & 4) == 0) goto L11;
        r103 = r100.f297185c;
    L11:
        r100.getClass();
        return new a(r101, r102, r103);
    }
}
