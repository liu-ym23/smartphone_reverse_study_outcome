package com.larus.bmhome.chat.component.bottom.voice.service;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f300483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f300484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f300485c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f300486d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f300487e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f300483a, r101.f300483a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f300484b, r101.f300484b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f300485c, r101.f300485c) == true) goto L18;
        return false;
    L18:
        if (this.f300486d == r101.f300486d) goto L21;
        return false;
    L21:
        if (this.f300487e == r101.f300487e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f300483a.hashCode() * 31) + this.f300484b.hashCode()) * 31) + this.f300485c.hashCode()) * 31;
        int r101 = 1231;
        if (this.f300486d == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f300487e == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "Param(conversationId=" + this.f300483a + ", itemId=" + this.f300484b + ", botId=" + this.f300485c + ", isImmerse=" + this.f300486d + ", disableTimeout=" + this.f300487e + ')';
    }

    public f(String r100, String r101, String r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r101, "itemId");
        Intrinsics.checkNotNullParameter(r102, "botId");
        this.f300483a = r100;
        this.f300484b = r101;
        this.f300485c = r102;
        this.f300486d = r103;
        this.f300487e = r104;
    }
}
