package com.bytedance.ies.argus.bean;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RequestCheckAction f246045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f246046b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f246047c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, String> f246048d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, String> f246049e;

    public t() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L8;
        return false;
    L8:
        t r101 = (t) r100;
        if (this.f246045a == r101.f246045a) goto L12;
        return false;
    L12:
        if (this.f246046b == r101.f246046b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f246047c, r101.f246047c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f246048d, r101.f246048d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f246049e, r101.f246049e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f246045a.hashCode() * 31;
        if (this.f246046b == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        String r103 = this.f246047c;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        Map<String, String> r107 = this.f246048d;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, String> r110 = this.f246049e;
        if (r110 == null) goto L19;
        r104 = r110.hashCode();
    L19:
        return r109 + r104;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "RequestCheckResult(action=" + this.f246045a + ", checkSuccess=" + this.f246046b + ", denyReason=" + this.f246047c + ", trackingInfo=" + this.f246048d + ", trackingWarn=" + this.f246049e + ')';
    }

    public t(RequestCheckAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f246045a = r100;
        this.f246046b = true;
        this.f246047c = null;
        this.f246048d = null;
        this.f246049e = null;
    }
}
