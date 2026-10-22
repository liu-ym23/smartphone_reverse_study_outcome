package com.ss.android.lark.keyboard.base;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f428245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f428246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f428247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f428248d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (this.f428245a == r101.f428245a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f428246b, r101.f428246b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f428247c, r101.f428247c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f428248d, r101.f428248d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f428245a * 31) + this.f428246b.hashCode()) * 31;
        String r101 = this.f428247c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f428248d;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append("chatId = " + this.f428246b + ", ");
        r100.append("scene = " + this.f428245a + ", ");
        r100.append("threadId = " + this.f428247c + ", ");
        StringBuilder r101 = new StringBuilder("rootId = ");
        r101.append(this.f428248d);
        r100.append(r101.toString());
        return r100.toString();
    }

    public p(String r100) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        this.f428245a = 1;
        this.f428246b = r100;
        this.f428247c = null;
        this.f428248d = null;
    }
}
