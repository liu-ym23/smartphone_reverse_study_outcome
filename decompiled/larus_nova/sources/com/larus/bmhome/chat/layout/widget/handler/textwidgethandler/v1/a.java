package com.larus.bmhome.chat.layout.widget.handler.textwidgethandler.v1;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f305151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f305152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f305153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f305154d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f305155e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f305151a, r101.f305151a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f305152b, r101.f305152b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f305153c, r101.f305153c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f305154d, r101.f305154d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f305155e, r101.f305155e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f305151a.hashCode() * 31) + this.f305152b.hashCode()) * 31;
        String r101 = this.f305153c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f305154d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f305155e;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "CitationSpanInfo(inlineType=" + this.f305151a + ", inlineText=" + this.f305152b + ", docId=" + this.f305153c + ", docPosition=" + this.f305154d + ", inlineDisplayPosition=" + this.f305155e + ')';
    }

    public a(String r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "inlineType");
        Intrinsics.checkNotNullParameter(r101, "inlineText");
        this.f305151a = r100;
        this.f305152b = r101;
        this.f305153c = r102;
        this.f305154d = r103;
        this.f305155e = r104;
    }
}
