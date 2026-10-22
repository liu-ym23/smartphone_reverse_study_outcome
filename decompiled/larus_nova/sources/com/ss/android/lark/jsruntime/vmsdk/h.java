package com.ss.android.lark.jsruntime.vmsdk;

import java.io.InputStream;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f428165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f428166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f428167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InputStream f428168d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f428165a, r101.f428165a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f428166b, r101.f428166b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f428167c, r101.f428167c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f428168d, r101.f428168d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f428165a.hashCode() * 31) + this.f428166b.hashCode()) * 31) + this.f428167c.hashCode()) * 31;
        InputStream r101 = this.f428168d;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "NetWorkRequest(url=" + this.f428165a + ", method=" + this.f428166b + ", headers=" + this.f428167c + ", body=" + this.f428168d + ')';
    }

    public h(String r100, String r101, Map<String, String> r102, InputStream r103) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r102, "headers");
        this.f428165a = r100;
        this.f428166b = r101;
        this.f428167c = r102;
        this.f428168d = r103;
    }
}
