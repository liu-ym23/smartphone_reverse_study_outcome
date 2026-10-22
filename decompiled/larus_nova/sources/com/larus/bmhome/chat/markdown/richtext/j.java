package com.larus.bmhome.chat.markdown.richtext;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f307213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f307214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f307215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f307216d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final r f307217e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (this.f307213a == r101.f307213a) goto L12;
        return false;
    L12:
        if (this.f307214b == r101.f307214b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f307215c, r101.f307215c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f307216d, r101.f307216d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f307217e, r101.f307217e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f307213a * 31) + this.f307214b) * 31) + this.f307215c.hashCode()) * 31) + this.f307216d.hashCode()) * 31) + this.f307217e.hashCode();
    }

    public final String toString() {
        return "MessageMarkdownResourceSpan(start=" + this.f307213a + ", end=" + this.f307214b + ", label=" + this.f307215c + ", destination=" + this.f307216d + ", resource=" + this.f307217e + ')';
    }

    public j(int r100, int r101, String r102, String r103, r r104) {
        Intrinsics.checkNotNullParameter(r102, "label");
        Intrinsics.checkNotNullParameter(r103, com.bytedance.android.ec.core.event.a.KEY_DESTINATION);
        Intrinsics.checkNotNullParameter(r104, "resource");
        this.f307213a = r100;
        this.f307214b = r101;
        this.f307215c = r102;
        this.f307216d = r103;
        this.f307217e = r104;
    }
}
