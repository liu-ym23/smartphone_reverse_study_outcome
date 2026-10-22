package com.larus.bmhome.chat.markdown.richtext;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f307178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f307179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f307180c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f307181d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f307178a == r101.f307178a) goto L12;
        return false;
    L12:
        if (this.f307179b == r101.f307179b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f307180c, r101.f307180c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f307181d, r101.f307181d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f307178a * 31) + this.f307179b) * 31) + this.f307180c.hashCode()) * 31) + this.f307181d.hashCode();
    }

    public final String toString() {
        return "MarkdownLinkReplacement(start=" + this.f307178a + ", end=" + this.f307179b + ", displayText=" + this.f307180c + ", url=" + this.f307181d + ')';
    }

    @Override // com.larus.bmhome.chat.markdown.richtext.t
    public final String a() {
        return this.f307180c;
    }

    @Override // com.larus.bmhome.chat.markdown.richtext.t
    public final int b() {
        return this.f307179b;
    }

    @Override // com.larus.bmhome.chat.markdown.richtext.t
    public final int c() {
        return this.f307178a;
    }

    public a(int r100, int r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r102, "displayText");
        Intrinsics.checkNotNullParameter(r103, "url");
        this.f307178a = r100;
        this.f307179b = r101;
        this.f307180c = r102;
        this.f307181d = r103;
    }
}
