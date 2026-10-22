package com.larus.bmhome.chat.api;

import com.larus.bmhome.auth.LaunchInfo;
import com.larus.network.http.AsyncThrowable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LaunchInfo f297186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f297187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f297188c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AsyncThrowable f297189d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e0) == true) goto L8;
        return false;
    L8:
        e0 r101 = (e0) r100;
        if (Intrinsics.areEqual(this.f297186a, r101.f297186a) == true) goto L12;
        return false;
    L12:
        if (this.f297187b == r101.f297187b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f297188c, r101.f297188c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f297189d, r101.f297189d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        LaunchInfo r100 = this.f297186a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f297187b) * 31;
        String r104 = this.f297188c;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        AsyncThrowable r107 = this.f297189d;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "LaunchInfoWithStatus(data=" + this.f297186a + ", status=" + this.f297187b + ", from=" + this.f297188c + ", error=" + this.f297189d + ')';
    }

    public final LaunchInfo b() {
        return this.f297186a;
    }

    public e0(LaunchInfo r100, int r101, String r102, AsyncThrowable r103) {
        this.f297186a = r100;
        this.f297187b = r101;
        this.f297188c = r102;
        this.f297189d = r103;
        if (r100 == null) goto L5;
        return;
    L5:
        if (r101 == 2) goto L8;
        return;
    L8:
        throw new IllegalArgumentException();
    }

    public static e0 a(e0 r100, LaunchInfo r101, int r102, String r103, AsyncThrowable r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.f297186a;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.f297187b;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.f297188c;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.f297189d;
    L15:
        return new e0(r101, r102, r103, r104);
    }
}
