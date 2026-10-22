package com.larus.bmhome.chat.markdown.richtext;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class u extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f307241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f307242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f307243c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f307244d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f307245e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final r f307246f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (this.f307241a == r101.f307241a) goto L12;
        return false;
    L12:
        if (this.f307242b == r101.f307242b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f307243c, r101.f307243c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f307244d, r101.f307244d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f307245e, r101.f307245e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f307246f, r101.f307246f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.f307241a * 31) + this.f307242b) * 31) + this.f307243c.hashCode()) * 31) + this.f307244d.hashCode()) * 31) + this.f307245e.hashCode()) * 31) + this.f307246f.hashCode();
    }

    public final String toString() {
        return "ResourceReplacement(start=" + this.f307241a + ", end=" + this.f307242b + ", displayText=" + this.f307243c + ", label=" + this.f307244d + ", destination=" + this.f307245e + ", resource=" + this.f307246f + ')';
    }

    @Override // com.larus.bmhome.chat.markdown.richtext.t
    public final String a() {
        return this.f307243c;
    }

    @Override // com.larus.bmhome.chat.markdown.richtext.t
    public final int b() {
        return this.f307242b;
    }

    @Override // com.larus.bmhome.chat.markdown.richtext.t
    public final int c() {
        return this.f307241a;
    }

    public u(int r100, int r101, String r102, String r103, String r104, r r105) {
        Intrinsics.checkNotNullParameter(r102, "displayText");
        Intrinsics.checkNotNullParameter(r103, "label");
        Intrinsics.checkNotNullParameter(r104, com.bytedance.android.ec.core.event.a.KEY_DESTINATION);
        Intrinsics.checkNotNullParameter(r105, "resource");
        this.f307241a = r100;
        this.f307242b = r101;
        this.f307243c = r102;
        this.f307244d = r103;
        this.f307245e = r104;
        this.f307246f = r105;
    }
}
