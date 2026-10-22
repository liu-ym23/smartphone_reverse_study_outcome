package com.bytedance.ee.bear.list.delete;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f227855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f227856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f227857c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f227855a, r101.f227855a) == true) goto L12;
        return false;
    L12:
        if (this.f227856b == r101.f227856b) goto L15;
        return false;
    L15:
        if (this.f227857c == r101.f227857c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f227855a.hashCode() * 31) + this.f227856b) * 31;
        if (this.f227857c == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "DeleteItem(objToken=" + this.f227855a + ", objType=" + this.f227856b + ", isOwner=" + this.f227857c + ')';
    }

    public d(String r100, int r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "objToken");
        this.f227855a = r100;
        this.f227856b = r101;
        this.f227857c = r102;
    }
}
