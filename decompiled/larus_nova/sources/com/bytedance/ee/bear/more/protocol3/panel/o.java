package com.bytedance.ee.bear.more.protocol3.panel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f234996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f234997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q f234998c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f234996a, r101.f234996a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f234997b, r101.f234997b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f234998c, r101.f234998c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f234996a.hashCode() * 31;
        r r101 = this.f234997b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        q r105 = this.f234998c;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MoreItemConfig(itemId=" + this.f234996a + ", factory=" + this.f234997b + ", delegate=" + this.f234998c + ')';
    }

    public o(String r100, c r101, j r102) {
        Intrinsics.checkNotNullParameter(r100, "itemId");
        this.f234996a = r100;
        this.f234997b = r101;
        this.f234998c = r102;
    }
}
