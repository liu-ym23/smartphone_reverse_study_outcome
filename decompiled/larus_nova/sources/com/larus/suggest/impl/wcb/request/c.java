package com.larus.suggest.impl.wcb.request;

import com.larus.suggest.impl.wcb.policy.z;
import com.larus.suggest.impl.wcb.render.p;
import ic8.k0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z f370099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WcbRequestTrigger f370100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k0 f370101c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f370102d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final p f370103e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f370104f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f370105g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f370099a, r101.f370099a) == true) goto L12;
        return false;
    L12:
        if (this.f370100b == r101.f370100b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f370101c, r101.f370101c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f370102d, r101.f370102d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f370103e, r101.f370103e) == true) goto L24;
        return false;
    L24:
        if (this.f370104f == r101.f370104f) goto L27;
        return false;
    L27:
        if (this.f370105g == r101.f370105g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f370099a.hashCode() * 31) + this.f370100b.hashCode()) * 31) + this.f370101c.hashCode()) * 31) + this.f370102d.hashCode()) * 31;
        p r101 = this.f370103e;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (((r100 + r102) * 31) + this.f370104f) * 31;
        if (this.f370105g == false) goto L9;
        int r104 = 1231;
    L11:
        return r103 + r104;
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "WcbRequest(policy=" + this.f370099a + ", trigger=" + this.f370100b + ", params=" + this.f370101c + ", reqSrc=" + this.f370102d + ", target=" + this.f370103e + ", requestScene=" + this.f370104f + ", isFirstModeEntry=" + this.f370105g + ')';
    }

    public c(z r100, WcbRequestTrigger r101, k0 r102, String r103, p r104, int r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r100, "policy");
        Intrinsics.checkNotNullParameter(r101, "trigger");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r103, "reqSrc");
        this.f370099a = r100;
        this.f370100b = r101;
        this.f370101c = r102;
        this.f370102d = r103;
        this.f370103e = r104;
        this.f370104f = r105;
        this.f370105g = r106;
    }
}
