package com.obric.assistant.settings.autogui;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f391887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f391888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f391889c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f391890d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f391891e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f391887a, r101.f391887a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f391888b, r101.f391888b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f391889c, r101.f391889c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f391890d, r101.f391890d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f391891e, r101.f391891e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f391887a.hashCode() * 31) + this.f391888b.hashCode()) * 31) + this.f391889c.hashCode()) * 31) + this.f391890d.hashCode()) * 31) + this.f391891e.hashCode();
    }

    public final String toString() {
        return "AuthorizationItem(sectionTitle=" + this.f391887a + ", title=" + this.f391888b + ", hint=" + this.f391889c + ", key=" + this.f391890d + ", defaultStatus=" + this.f391891e + ')';
    }

    public a(String r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "sectionTitle");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "hint");
        Intrinsics.checkNotNullParameter(r103, "key");
        Intrinsics.checkNotNullParameter(r104, "defaultStatus");
        this.f391887a = r100;
        this.f391888b = r101;
        this.f391889c = r102;
        this.f391890d = r103;
        this.f391891e = r104;
    }
}
