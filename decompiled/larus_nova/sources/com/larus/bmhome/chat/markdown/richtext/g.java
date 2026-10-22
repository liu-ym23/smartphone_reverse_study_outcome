package com.larus.bmhome.chat.markdown.richtext;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f307197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f307198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f307199c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MessageMarkdownLinkSource f307200d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.f307197a == r101.f307197a) goto L12;
        return false;
    L12:
        if (this.f307198b == r101.f307198b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f307199c, r101.f307199c) == true) goto L18;
        return false;
    L18:
        if (this.f307200d == r101.f307200d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f307197a * 31) + this.f307198b) * 31) + this.f307199c.hashCode()) * 31) + this.f307200d.hashCode();
    }

    public final String toString() {
        return "MessageMarkdownLinkSpan(start=" + this.f307197a + ", end=" + this.f307198b + ", url=" + this.f307199c + ", source=" + this.f307200d + ')';
    }

    public g(int r100, int r101, String r102, MessageMarkdownLinkSource r103) {
        Intrinsics.checkNotNullParameter(r102, "url");
        Intrinsics.checkNotNullParameter(r103, "source");
        this.f307197a = r100;
        this.f307198b = r101;
        this.f307199c = r102;
        this.f307200d = r103;
    }

    public static g a(g r100, int r101, int r102, String r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.f307197a;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.f307198b;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.f307199c;
    L12:
        if ((r104 & 8) == 0) goto L14;
        MessageMarkdownLinkSource r105 = r100.f307200d;
    L15:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r103, "url");
        Intrinsics.checkNotNullParameter(r105, "source");
        return new g(r101, r102, r103, r105);
    L14:
        r105 = null;
        goto L15
    }
}
