package com.larus.bmhome.chat.larkforward;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f303397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f303398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f303399c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f303400d;

    public e0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e0) == true) goto L8;
        return false;
    L8:
        e0 r101 = (e0) r100;
        if (Intrinsics.areEqual(this.f303397a, r101.f303397a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f303398b, r101.f303398b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f303399c, r101.f303399c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f303400d, r101.f303400d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f303397a.hashCode() * 31) + this.f303398b.hashCode()) * 31) + this.f303399c.hashCode()) * 31) + this.f303400d.hashCode();
    }

    public final String toString() {
        return "FlowLarkToDoubaoTrackParams(larkFirstScene=" + this.f303397a + ", larkSecondScene=" + this.f303398b + ", currentModule=" + this.f303399c + ", enterMethod=" + this.f303400d + ')';
    }

    public /* synthetic */ e0(int r100) {
        this("", "", "", "");
    }

    public e0(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "larkFirstScene");
        Intrinsics.checkNotNullParameter(r101, "larkSecondScene");
        Intrinsics.checkNotNullParameter(r102, "currentModule");
        Intrinsics.checkNotNullParameter(r103, "enterMethod");
        this.f303397a = r100;
        this.f303398b = r101;
        this.f303399c = r102;
        this.f303400d = r103;
    }
}
