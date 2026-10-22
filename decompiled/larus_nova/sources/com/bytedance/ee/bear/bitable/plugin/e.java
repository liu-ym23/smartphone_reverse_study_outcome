package com.bytedance.ee.bear.bitable.plugin;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f214925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f214926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f214927c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f214925a, r101.f214925a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f214926b, r101.f214926b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f214927c, r101.f214927c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f214925a.hashCode() * 31) + this.f214926b.hashCode()) * 31) + this.f214927c.hashCode();
    }

    public final String toString() {
        return "ChooseBaseViewRequest(callbackId=" + this.f214925a + ", requestId=" + this.f214926b + ", source=" + this.f214927c + ')';
    }

    public e(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "callbackId");
        Intrinsics.checkNotNullParameter(r101, "requestId");
        Intrinsics.checkNotNullParameter(r102, "source");
        this.f214925a = r100;
        this.f214926b = r101;
        this.f214927c = r102;
    }
}
