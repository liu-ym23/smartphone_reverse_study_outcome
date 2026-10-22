package com.larus.bmhome.chat.larkforward;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f303422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f303423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f303424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f303425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f303426e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f303427f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final e0 f303428g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f303429h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f303430i;

    public p() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f303422a, r101.f303422a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f303423b, r101.f303423b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f303424c, r101.f303424c) == true) goto L18;
        return false;
    L18:
        if (this.f303425d == r101.f303425d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f303426e, r101.f303426e) == true) goto L24;
        return false;
    L24:
        if (this.f303427f == r101.f303427f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f303428g, r101.f303428g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f303429h, r101.f303429h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f303430i, r101.f303430i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f303422a.hashCode() * 31;
        String r101 = this.f303423b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.f303424c.hashCode()) * 31;
        int r105 = 1231;
        if (this.f303425d == false) goto L9;
        int r106 = 1231;
    L10:
        int r107 = (((r104 + r106) * 31) + this.f303426e.hashCode()) * 31;
        if (this.f303427f == true) goto L14;
        r105 = 1237;
    L14:
        int r108 = (((r107 + r105) * 31) + this.f303428g.hashCode()) * 31;
        String r109 = this.f303429h;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        String r112 = this.f303430i;
        if (r112 == null) goto L23;
        r102 = r112.hashCode();
    L23:
        return r111 + r102;
    L17:
        r110 = r109.hashCode();
        goto L18
    L9:
        r106 = 1237;
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowLarkToDoubaoRequest(larkMessageIds=" + this.f303422a + ", extraNote=" + this.f303423b + ", quasiTitle=" + this.f303424c + ", isGroupChat=" + this.f303425d + ", chatId=" + this.f303426e + ", isThreadRootMsg=" + this.f303427f + ", trackParams=" + this.f303428g + ", functionScene=" + this.f303429h + ", originMergeForwardId=" + this.f303430i + ')';
    }

    public p(List r100, String r101, String r102, boolean r103, String r104, boolean r105, e0 r106, String r107) {
        Intrinsics.checkNotNullParameter(r100, "larkMessageIds");
        Intrinsics.checkNotNullParameter(r102, "quasiTitle");
        Intrinsics.checkNotNullParameter(r104, "chatId");
        Intrinsics.checkNotNullParameter(r106, "trackParams");
        this.f303422a = r100;
        this.f303423b = r101;
        this.f303424c = r102;
        this.f303425d = r103;
        this.f303426e = r104;
        this.f303427f = r105;
        this.f303428g = r106;
        this.f303429h = null;
        this.f303430i = r107;
    }
}
