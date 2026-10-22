package com.larus.feishu.office.im.impl.officemention;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f343221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f343222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f343223c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f343221a, r101.f343221a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f343222b, r101.f343222b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f343223c, r101.f343223c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f343221a.hashCode() * 31) + this.f343222b.hashCode()) * 31) + this.f343223c.hashCode();
    }

    public final String toString() {
        return "OfficeAtMention(userId=" + this.f343221a + ", userName=" + this.f343222b + ", rawText=" + this.f343223c + ')';
    }

    public b(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "userName");
        Intrinsics.checkNotNullParameter(r102, "rawText");
        this.f343221a = r100;
        this.f343222b = r101;
        this.f343223c = r102;
    }
}
