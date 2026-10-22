package com.obric.assistant.cocreationreview;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class x4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f387792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f387793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<y4> f387794c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x4) == true) goto L8;
        return false;
    L8:
        x4 r101 = (x4) r100;
        if (Intrinsics.areEqual(this.f387792a, r101.f387792a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f387793b, r101.f387793b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f387794c, r101.f387794c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f387792a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((r101 * 31) + this.f387793b.hashCode()) * 31) + this.f387794c.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "DetailPage(recordId=" + this.f387792a + ", title=" + this.f387793b + ", sections=" + this.f387794c + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public x4(String r100, e r101, List<? extends y4> r102) {
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "sections");
        this.f387792a = r100;
        this.f387793b = r101;
        this.f387794c = r102;
    }
}
