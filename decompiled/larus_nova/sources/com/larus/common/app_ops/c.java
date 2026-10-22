package com.larus.common.app_ops;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<? extends Throwable> f326264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f326265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f326266c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f326264a, r101.f326264a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f326265b, r101.f326265b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f326266c, r101.f326266c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        List<? extends Throwable> r100 = this.f326264a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((r101 * 31) + this.f326265b.hashCode()) * 31) + this.f326266c.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "CacheAttributionTagItem(stackTrace=" + this.f326264a + ", xGroup=" + this.f326265b + ", serviceName=" + this.f326266c + ')';
    }

    public c() {
        Intrinsics.checkNotNullParameter("", "xGroup");
        Intrinsics.checkNotNullParameter("", "serviceName");
        this.f326264a = null;
        this.f326265b = "";
        this.f326266c = "";
    }
}
