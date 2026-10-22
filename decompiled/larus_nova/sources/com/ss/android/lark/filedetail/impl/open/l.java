package com.ss.android.lark.filedetail.impl.open;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OpenFileActionType f421844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f421845b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (this.f421844a == r101.f421844a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f421845b, r101.f421845b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f421844a.hashCode() * 31;
        String r101 = this.f421845b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "OpenFileAction(type=" + this.f421844a + ", title=" + this.f421845b + ')';
    }

    public final OpenFileActionType getType() {
        return this.f421844a;
    }

    public l(OpenFileActionType r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f421844a = r100;
        this.f421845b = r101;
    }
}
